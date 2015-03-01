package com.jeffreybosboom.parallelbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 * @param <S> the state type
 * @author Jeffrey Bosboom <jbosboom@csail.mit.edu>
 * @since 11/15/2014
 */
public final class ParallelBFS<S> {
	private final Function<S, Stream<S>> successors;
	private final Predicate<S> isSolution;
	private final List<Consumer<? super List<S>>> preGenerationActions = new ArrayList<>();
	private Predicate<S> filters = null;
	private boolean parallel = true;
	public ParallelBFS(Function<S, Stream<S>> successors, Predicate<S> isSolution) {
		this.successors = successors;
		this.isSolution = isSolution;
	}

	public ParallelBFS<S> sequential() {
		parallel = false;
		return this;
	}

	public ParallelBFS<S> filter(Predicate<S> filter) {
		this.filters = filters == null ? filter : filters.and(filter);
		return this;
	}

	public ParallelBFS<S> beforeGeneration(Consumer<? super List<S>> action) {
		preGenerationActions.add(action);
		return this;
	}

	public Optional<S> find(S startState) {
		if (isSolution.test(startState)) return Optional.of(startState);

		@SuppressWarnings("unchecked")
		S[] frontier = (S[])new Object[]{startState};
		@SuppressWarnings("unchecked")
		IntFunction<S[]> arrayNew = l -> (S[])new Object[l];

		while (frontier.length > 0) {
			final List<S> finalFrontier = Arrays.asList(frontier);
			preGenerationActions.forEach(c -> c.accept(finalFrontier));

			try {
				Stream<S> stream = Arrays.stream(frontier);
				if (parallel) stream = stream.parallel();
				frontier = stream
						.flatMap(successors)
						.peek(s -> {if (isSolution.test(s)) throw new SolutionException(s);})
						.filter(filters != null ? filters : s -> true)
						.toArray(arrayNew);
			} catch (SolutionException e) {
				@SuppressWarnings("unchecked")
				S solution = (S)e.solution;
				return Optional.of(solution);
			}
		}
		return Optional.empty();
	}

	@SuppressWarnings("serial")
	private static final class SolutionException extends RuntimeException {
		public final Object solution;
		SolutionException(Object solution) {
			this.solution = solution;
		}
		@Override
		public synchronized Throwable fillInStackTrace() {
			return this;
		}
	}
}
