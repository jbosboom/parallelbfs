package com.jeffreybosboom.parallelbfs;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 *
 * @author Jeffrey Bosboom <jbosboom@csail.mit.edu>
 * @since 3/1/2015
 */
public final class StatPrinter implements Consumer<List<?>> {
	private final Supplier<?> closedSetSize;
	private int generation = 0;
	public StatPrinter() {
		this(() -> -1);
	}
	public StatPrinter(Supplier<?> closedSetSize) {
		this.closedSetSize = closedSetSize;
	}
	@Override
	public void accept(List<?> frontier) {
		++generation;
		System.out.format("generation %d, frontier %d, closed %s%n",
				generation, frontier.size(), closedSetSize.get());
	}
}
