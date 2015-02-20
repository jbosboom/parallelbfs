package com.jeffreybosboom.parallelbfs;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * DataContainer implementations are fixed-size byte containers intended for
 * compactly storing visited states.
 * @author Jeffrey Bosboom <jbosboom@csail.mit.edu>
 * @since 2/20/2015
 */
public interface DataContainer {
	public byte get(int index);
	public void set(int index, byte b);
	public int size();
	public default Stream<Byte> stream() {
		return IntStream.range(0, size()).mapToObj(this::get);
	}

	public static DataContainer create(int size) {
		switch (size) {
			case 0: return DataContainer0.INSTANCE;
			case 1: return new DataContainer1();
			case 2: return new DataContainer2();
			case 3: return new DataContainer3();
			case 4: return new DataContainer4();
			case 5: return new DataContainer5();
			case 6: return new DataContainer6();
			case 7: return new DataContainer7();
			case 8: return new DataContainer8();
			case 9: return new DataContainer9();
			case 10: return new DataContainer10();
			case 11: return new DataContainer11();
			case 12: return new DataContainer12();
			case 13: return new DataContainer13();
			case 14: return new DataContainer14();
			case 15: return new DataContainer15();
			case 16: return new DataContainer16();
			case 17: return new DataContainer17();
			case 18: return new DataContainer18();
			case 19: return new DataContainer19();
			case 20: return new DataContainer20();
			case 21: return new DataContainer21();
			case 22: return new DataContainer22();
			case 23: return new DataContainer23();
			case 24: return new DataContainer24();
		}
		if (size < 0) throw new IllegalArgumentException("negative size: "+size);
		return new DataContainerN(size);
	}

//	public static void main(String[] args) {
//		for (int i = 1; i <= 24; ++i) {
//			emitClass(i);
////			System.out.format("case %d: return new DataContainer%d();%n", i, i);
//		}
//	}
//
//	static void emitClass(int i) {
//		PrintStream o = System.out;
//		String cn = "DataContainer"+i;
//		o.println("final class "+cn+" implements DataContainer {");
//
//		o.print("private byte ");
//		o.print(IntStream.range(0, i).mapToObj(x -> "b"+x).collect(Collectors.joining(", ")));
//		o.println(";");
//
//		o.println(cn+"() {}");
//
//		o.println("@Override public byte get(int index) {");
//		o.println("switch (index) {");
//		for (int j = 0; j < i; ++j)
//			o.printf("case %d: return b%d;%n", j, j);
//		o.println("default: throw new IndexOutOfBoundsException(\"\"+index);");
//		o.println("}");
//		o.println("}");
//
//		o.println("@Override public void set(int index, byte data) {");
//		o.println("switch (index) {");
//		for (int j = 0; j < i; ++j)
//			o.printf("case %d: b%d = data; break;%n", j, j);
//		o.println("default: throw new IndexOutOfBoundsException(\"\"+index);");
//		o.println("}");
//		o.println("}");
//
//		o.println("@Override public int size() {");
//		o.println("return "+i+";");
//		o.println("}");
//
//		o.println("@Override public boolean equals(Object o) {");
//		o.println("if (o == null || getClass() != o.getClass()) return false;");
//		o.println(cn+" n = ("+cn+")o;");
//		o.print("return ");
//		o.print(IntStream.range(0, i).mapToObj(x -> "b"+x+" == n.b"+x).collect(Collectors.joining(" && ")));
//		o.println(";");
//		o.println("}");
//
//		o.println("@Override public int hashCode() {");
//		o.println("int result = size();");
//		IntStream.range(0, i).mapToObj(x -> "result = 31 * result + b"+x+";").forEachOrdered(o::println);
//		o.println("return result;");
//		o.println("}");
//
//		o.println("}");
//	}
}

final class DataContainer0 implements DataContainer {
	public static final DataContainer INSTANCE = new DataContainer0();
	private DataContainer0() {}
	@Override
	public byte get(int index) {
		throw new IndexOutOfBoundsException();
	}
	@Override
	public void set(int index, byte b) {
		throw new IndexOutOfBoundsException();
	}
	@Override
	public int size() {
		return 0;
	}
	@Override
	public boolean equals(Object o) {
		return o != null && getClass() == o.getClass();
	}
	@Override
	public int hashCode() {
		return 0;
	}
}

/**
 * A DataContainer implementation backed by a byte array, supporting any size.
 * We only use this for sizes larger than the max fixed-size implementation to
 * ensure {@code equals} remains transitive.
 * @author Jeffrey Bosboom <jbosboom@csail.mit.edu>
 */
final class DataContainerN implements DataContainer {
	private final byte[] data;
	DataContainerN(int size) {
		this.data = new byte[size];
	}
	@Override
	public byte get(int index) {
		return data[index];
	}
	@Override
	public void set(int index, byte b) {
		data[index] = b;
	}
	@Override
	public int size() {
		return data.length;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final DataContainerN other = (DataContainerN)obj;
		return Arrays.equals(this.data, other.data);
	}
	@Override
	public int hashCode() {
		return Arrays.hashCode(data);
	}
}

final class DataContainer1 implements DataContainer {
private byte b0;
DataContainer1() {}
@Override public byte get(int index) {
switch (index) {
case 0: return b0;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public void set(int index, byte data) {
switch (index) {
case 0: b0 = data; break;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public int size() {
return 1;
}
@Override public boolean equals(Object o) {
if (o == null || getClass() != o.getClass()) return false;
DataContainer1 n = (DataContainer1)o;
return b0 == n.b0;
}
@Override public int hashCode() {
int result = size();
result = 31 * result + b0;
return result;
}
}
final class DataContainer2 implements DataContainer {
private byte b0, b1;
DataContainer2() {}
@Override public byte get(int index) {
switch (index) {
case 0: return b0;
case 1: return b1;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public void set(int index, byte data) {
switch (index) {
case 0: b0 = data; break;
case 1: b1 = data; break;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public int size() {
return 2;
}
@Override public boolean equals(Object o) {
if (o == null || getClass() != o.getClass()) return false;
DataContainer2 n = (DataContainer2)o;
return b0 == n.b0 && b1 == n.b1;
}
@Override public int hashCode() {
int result = size();
result = 31 * result + b0;
result = 31 * result + b1;
return result;
}
}
final class DataContainer3 implements DataContainer {
private byte b0, b1, b2;
DataContainer3() {}
@Override public byte get(int index) {
switch (index) {
case 0: return b0;
case 1: return b1;
case 2: return b2;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public void set(int index, byte data) {
switch (index) {
case 0: b0 = data; break;
case 1: b1 = data; break;
case 2: b2 = data; break;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public int size() {
return 3;
}
@Override public boolean equals(Object o) {
if (o == null || getClass() != o.getClass()) return false;
DataContainer3 n = (DataContainer3)o;
return b0 == n.b0 && b1 == n.b1 && b2 == n.b2;
}
@Override public int hashCode() {
int result = size();
result = 31 * result + b0;
result = 31 * result + b1;
result = 31 * result + b2;
return result;
}
}
final class DataContainer4 implements DataContainer {
private byte b0, b1, b2, b3;
DataContainer4() {}
@Override public byte get(int index) {
switch (index) {
case 0: return b0;
case 1: return b1;
case 2: return b2;
case 3: return b3;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public void set(int index, byte data) {
switch (index) {
case 0: b0 = data; break;
case 1: b1 = data; break;
case 2: b2 = data; break;
case 3: b3 = data; break;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public int size() {
return 4;
}
@Override public boolean equals(Object o) {
if (o == null || getClass() != o.getClass()) return false;
DataContainer4 n = (DataContainer4)o;
return b0 == n.b0 && b1 == n.b1 && b2 == n.b2 && b3 == n.b3;
}
@Override public int hashCode() {
int result = size();
result = 31 * result + b0;
result = 31 * result + b1;
result = 31 * result + b2;
result = 31 * result + b3;
return result;
}
}
final class DataContainer5 implements DataContainer {
private byte b0, b1, b2, b3, b4;
DataContainer5() {}
@Override public byte get(int index) {
switch (index) {
case 0: return b0;
case 1: return b1;
case 2: return b2;
case 3: return b3;
case 4: return b4;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public void set(int index, byte data) {
switch (index) {
case 0: b0 = data; break;
case 1: b1 = data; break;
case 2: b2 = data; break;
case 3: b3 = data; break;
case 4: b4 = data; break;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public int size() {
return 5;
}
@Override public boolean equals(Object o) {
if (o == null || getClass() != o.getClass()) return false;
DataContainer5 n = (DataContainer5)o;
return b0 == n.b0 && b1 == n.b1 && b2 == n.b2 && b3 == n.b3 && b4 == n.b4;
}
@Override public int hashCode() {
int result = size();
result = 31 * result + b0;
result = 31 * result + b1;
result = 31 * result + b2;
result = 31 * result + b3;
result = 31 * result + b4;
return result;
}
}
final class DataContainer6 implements DataContainer {
private byte b0, b1, b2, b3, b4, b5;
DataContainer6() {}
@Override public byte get(int index) {
switch (index) {
case 0: return b0;
case 1: return b1;
case 2: return b2;
case 3: return b3;
case 4: return b4;
case 5: return b5;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public void set(int index, byte data) {
switch (index) {
case 0: b0 = data; break;
case 1: b1 = data; break;
case 2: b2 = data; break;
case 3: b3 = data; break;
case 4: b4 = data; break;
case 5: b5 = data; break;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public int size() {
return 6;
}
@Override public boolean equals(Object o) {
if (o == null || getClass() != o.getClass()) return false;
DataContainer6 n = (DataContainer6)o;
return b0 == n.b0 && b1 == n.b1 && b2 == n.b2 && b3 == n.b3 && b4 == n.b4 && b5 == n.b5;
}
@Override public int hashCode() {
int result = size();
result = 31 * result + b0;
result = 31 * result + b1;
result = 31 * result + b2;
result = 31 * result + b3;
result = 31 * result + b4;
result = 31 * result + b5;
return result;
}
}
final class DataContainer7 implements DataContainer {
private byte b0, b1, b2, b3, b4, b5, b6;
DataContainer7() {}
@Override public byte get(int index) {
switch (index) {
case 0: return b0;
case 1: return b1;
case 2: return b2;
case 3: return b3;
case 4: return b4;
case 5: return b5;
case 6: return b6;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public void set(int index, byte data) {
switch (index) {
case 0: b0 = data; break;
case 1: b1 = data; break;
case 2: b2 = data; break;
case 3: b3 = data; break;
case 4: b4 = data; break;
case 5: b5 = data; break;
case 6: b6 = data; break;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public int size() {
return 7;
}
@Override public boolean equals(Object o) {
if (o == null || getClass() != o.getClass()) return false;
DataContainer7 n = (DataContainer7)o;
return b0 == n.b0 && b1 == n.b1 && b2 == n.b2 && b3 == n.b3 && b4 == n.b4 && b5 == n.b5 && b6 == n.b6;
}
@Override public int hashCode() {
int result = size();
result = 31 * result + b0;
result = 31 * result + b1;
result = 31 * result + b2;
result = 31 * result + b3;
result = 31 * result + b4;
result = 31 * result + b5;
result = 31 * result + b6;
return result;
}
}
final class DataContainer8 implements DataContainer {
private byte b0, b1, b2, b3, b4, b5, b6, b7;
DataContainer8() {}
@Override public byte get(int index) {
switch (index) {
case 0: return b0;
case 1: return b1;
case 2: return b2;
case 3: return b3;
case 4: return b4;
case 5: return b5;
case 6: return b6;
case 7: return b7;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public void set(int index, byte data) {
switch (index) {
case 0: b0 = data; break;
case 1: b1 = data; break;
case 2: b2 = data; break;
case 3: b3 = data; break;
case 4: b4 = data; break;
case 5: b5 = data; break;
case 6: b6 = data; break;
case 7: b7 = data; break;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public int size() {
return 8;
}
@Override public boolean equals(Object o) {
if (o == null || getClass() != o.getClass()) return false;
DataContainer8 n = (DataContainer8)o;
return b0 == n.b0 && b1 == n.b1 && b2 == n.b2 && b3 == n.b3 && b4 == n.b4 && b5 == n.b5 && b6 == n.b6 && b7 == n.b7;
}
@Override public int hashCode() {
int result = size();
result = 31 * result + b0;
result = 31 * result + b1;
result = 31 * result + b2;
result = 31 * result + b3;
result = 31 * result + b4;
result = 31 * result + b5;
result = 31 * result + b6;
result = 31 * result + b7;
return result;
}
}
final class DataContainer9 implements DataContainer {
private byte b0, b1, b2, b3, b4, b5, b6, b7, b8;
DataContainer9() {}
@Override public byte get(int index) {
switch (index) {
case 0: return b0;
case 1: return b1;
case 2: return b2;
case 3: return b3;
case 4: return b4;
case 5: return b5;
case 6: return b6;
case 7: return b7;
case 8: return b8;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public void set(int index, byte data) {
switch (index) {
case 0: b0 = data; break;
case 1: b1 = data; break;
case 2: b2 = data; break;
case 3: b3 = data; break;
case 4: b4 = data; break;
case 5: b5 = data; break;
case 6: b6 = data; break;
case 7: b7 = data; break;
case 8: b8 = data; break;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public int size() {
return 9;
}
@Override public boolean equals(Object o) {
if (o == null || getClass() != o.getClass()) return false;
DataContainer9 n = (DataContainer9)o;
return b0 == n.b0 && b1 == n.b1 && b2 == n.b2 && b3 == n.b3 && b4 == n.b4 && b5 == n.b5 && b6 == n.b6 && b7 == n.b7 && b8 == n.b8;
}
@Override public int hashCode() {
int result = size();
result = 31 * result + b0;
result = 31 * result + b1;
result = 31 * result + b2;
result = 31 * result + b3;
result = 31 * result + b4;
result = 31 * result + b5;
result = 31 * result + b6;
result = 31 * result + b7;
result = 31 * result + b8;
return result;
}
}
final class DataContainer10 implements DataContainer {
private byte b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
DataContainer10() {}
@Override public byte get(int index) {
switch (index) {
case 0: return b0;
case 1: return b1;
case 2: return b2;
case 3: return b3;
case 4: return b4;
case 5: return b5;
case 6: return b6;
case 7: return b7;
case 8: return b8;
case 9: return b9;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public void set(int index, byte data) {
switch (index) {
case 0: b0 = data; break;
case 1: b1 = data; break;
case 2: b2 = data; break;
case 3: b3 = data; break;
case 4: b4 = data; break;
case 5: b5 = data; break;
case 6: b6 = data; break;
case 7: b7 = data; break;
case 8: b8 = data; break;
case 9: b9 = data; break;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public int size() {
return 10;
}
@Override public boolean equals(Object o) {
if (o == null || getClass() != o.getClass()) return false;
DataContainer10 n = (DataContainer10)o;
return b0 == n.b0 && b1 == n.b1 && b2 == n.b2 && b3 == n.b3 && b4 == n.b4 && b5 == n.b5 && b6 == n.b6 && b7 == n.b7 && b8 == n.b8 && b9 == n.b9;
}
@Override public int hashCode() {
int result = size();
result = 31 * result + b0;
result = 31 * result + b1;
result = 31 * result + b2;
result = 31 * result + b3;
result = 31 * result + b4;
result = 31 * result + b5;
result = 31 * result + b6;
result = 31 * result + b7;
result = 31 * result + b8;
result = 31 * result + b9;
return result;
}
}
final class DataContainer11 implements DataContainer {
private byte b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;
DataContainer11() {}
@Override public byte get(int index) {
switch (index) {
case 0: return b0;
case 1: return b1;
case 2: return b2;
case 3: return b3;
case 4: return b4;
case 5: return b5;
case 6: return b6;
case 7: return b7;
case 8: return b8;
case 9: return b9;
case 10: return b10;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public void set(int index, byte data) {
switch (index) {
case 0: b0 = data; break;
case 1: b1 = data; break;
case 2: b2 = data; break;
case 3: b3 = data; break;
case 4: b4 = data; break;
case 5: b5 = data; break;
case 6: b6 = data; break;
case 7: b7 = data; break;
case 8: b8 = data; break;
case 9: b9 = data; break;
case 10: b10 = data; break;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public int size() {
return 11;
}
@Override public boolean equals(Object o) {
if (o == null || getClass() != o.getClass()) return false;
DataContainer11 n = (DataContainer11)o;
return b0 == n.b0 && b1 == n.b1 && b2 == n.b2 && b3 == n.b3 && b4 == n.b4 && b5 == n.b5 && b6 == n.b6 && b7 == n.b7 && b8 == n.b8 && b9 == n.b9 && b10 == n.b10;
}
@Override public int hashCode() {
int result = size();
result = 31 * result + b0;
result = 31 * result + b1;
result = 31 * result + b2;
result = 31 * result + b3;
result = 31 * result + b4;
result = 31 * result + b5;
result = 31 * result + b6;
result = 31 * result + b7;
result = 31 * result + b8;
result = 31 * result + b9;
result = 31 * result + b10;
return result;
}
}
final class DataContainer12 implements DataContainer {
private byte b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11;
DataContainer12() {}
@Override public byte get(int index) {
switch (index) {
case 0: return b0;
case 1: return b1;
case 2: return b2;
case 3: return b3;
case 4: return b4;
case 5: return b5;
case 6: return b6;
case 7: return b7;
case 8: return b8;
case 9: return b9;
case 10: return b10;
case 11: return b11;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public void set(int index, byte data) {
switch (index) {
case 0: b0 = data; break;
case 1: b1 = data; break;
case 2: b2 = data; break;
case 3: b3 = data; break;
case 4: b4 = data; break;
case 5: b5 = data; break;
case 6: b6 = data; break;
case 7: b7 = data; break;
case 8: b8 = data; break;
case 9: b9 = data; break;
case 10: b10 = data; break;
case 11: b11 = data; break;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public int size() {
return 12;
}
@Override public boolean equals(Object o) {
if (o == null || getClass() != o.getClass()) return false;
DataContainer12 n = (DataContainer12)o;
return b0 == n.b0 && b1 == n.b1 && b2 == n.b2 && b3 == n.b3 && b4 == n.b4 && b5 == n.b5 && b6 == n.b6 && b7 == n.b7 && b8 == n.b8 && b9 == n.b9 && b10 == n.b10 && b11 == n.b11;
}
@Override public int hashCode() {
int result = size();
result = 31 * result + b0;
result = 31 * result + b1;
result = 31 * result + b2;
result = 31 * result + b3;
result = 31 * result + b4;
result = 31 * result + b5;
result = 31 * result + b6;
result = 31 * result + b7;
result = 31 * result + b8;
result = 31 * result + b9;
result = 31 * result + b10;
result = 31 * result + b11;
return result;
}
}
final class DataContainer13 implements DataContainer {
private byte b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;
DataContainer13() {}
@Override public byte get(int index) {
switch (index) {
case 0: return b0;
case 1: return b1;
case 2: return b2;
case 3: return b3;
case 4: return b4;
case 5: return b5;
case 6: return b6;
case 7: return b7;
case 8: return b8;
case 9: return b9;
case 10: return b10;
case 11: return b11;
case 12: return b12;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public void set(int index, byte data) {
switch (index) {
case 0: b0 = data; break;
case 1: b1 = data; break;
case 2: b2 = data; break;
case 3: b3 = data; break;
case 4: b4 = data; break;
case 5: b5 = data; break;
case 6: b6 = data; break;
case 7: b7 = data; break;
case 8: b8 = data; break;
case 9: b9 = data; break;
case 10: b10 = data; break;
case 11: b11 = data; break;
case 12: b12 = data; break;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public int size() {
return 13;
}
@Override public boolean equals(Object o) {
if (o == null || getClass() != o.getClass()) return false;
DataContainer13 n = (DataContainer13)o;
return b0 == n.b0 && b1 == n.b1 && b2 == n.b2 && b3 == n.b3 && b4 == n.b4 && b5 == n.b5 && b6 == n.b6 && b7 == n.b7 && b8 == n.b8 && b9 == n.b9 && b10 == n.b10 && b11 == n.b11 && b12 == n.b12;
}
@Override public int hashCode() {
int result = size();
result = 31 * result + b0;
result = 31 * result + b1;
result = 31 * result + b2;
result = 31 * result + b3;
result = 31 * result + b4;
result = 31 * result + b5;
result = 31 * result + b6;
result = 31 * result + b7;
result = 31 * result + b8;
result = 31 * result + b9;
result = 31 * result + b10;
result = 31 * result + b11;
result = 31 * result + b12;
return result;
}
}
final class DataContainer14 implements DataContainer {
private byte b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13;
DataContainer14() {}
@Override public byte get(int index) {
switch (index) {
case 0: return b0;
case 1: return b1;
case 2: return b2;
case 3: return b3;
case 4: return b4;
case 5: return b5;
case 6: return b6;
case 7: return b7;
case 8: return b8;
case 9: return b9;
case 10: return b10;
case 11: return b11;
case 12: return b12;
case 13: return b13;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public void set(int index, byte data) {
switch (index) {
case 0: b0 = data; break;
case 1: b1 = data; break;
case 2: b2 = data; break;
case 3: b3 = data; break;
case 4: b4 = data; break;
case 5: b5 = data; break;
case 6: b6 = data; break;
case 7: b7 = data; break;
case 8: b8 = data; break;
case 9: b9 = data; break;
case 10: b10 = data; break;
case 11: b11 = data; break;
case 12: b12 = data; break;
case 13: b13 = data; break;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public int size() {
return 14;
}
@Override public boolean equals(Object o) {
if (o == null || getClass() != o.getClass()) return false;
DataContainer14 n = (DataContainer14)o;
return b0 == n.b0 && b1 == n.b1 && b2 == n.b2 && b3 == n.b3 && b4 == n.b4 && b5 == n.b5 && b6 == n.b6 && b7 == n.b7 && b8 == n.b8 && b9 == n.b9 && b10 == n.b10 && b11 == n.b11 && b12 == n.b12 && b13 == n.b13;
}
@Override public int hashCode() {
int result = size();
result = 31 * result + b0;
result = 31 * result + b1;
result = 31 * result + b2;
result = 31 * result + b3;
result = 31 * result + b4;
result = 31 * result + b5;
result = 31 * result + b6;
result = 31 * result + b7;
result = 31 * result + b8;
result = 31 * result + b9;
result = 31 * result + b10;
result = 31 * result + b11;
result = 31 * result + b12;
result = 31 * result + b13;
return result;
}
}
final class DataContainer15 implements DataContainer {
private byte b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14;
DataContainer15() {}
@Override public byte get(int index) {
switch (index) {
case 0: return b0;
case 1: return b1;
case 2: return b2;
case 3: return b3;
case 4: return b4;
case 5: return b5;
case 6: return b6;
case 7: return b7;
case 8: return b8;
case 9: return b9;
case 10: return b10;
case 11: return b11;
case 12: return b12;
case 13: return b13;
case 14: return b14;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public void set(int index, byte data) {
switch (index) {
case 0: b0 = data; break;
case 1: b1 = data; break;
case 2: b2 = data; break;
case 3: b3 = data; break;
case 4: b4 = data; break;
case 5: b5 = data; break;
case 6: b6 = data; break;
case 7: b7 = data; break;
case 8: b8 = data; break;
case 9: b9 = data; break;
case 10: b10 = data; break;
case 11: b11 = data; break;
case 12: b12 = data; break;
case 13: b13 = data; break;
case 14: b14 = data; break;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public int size() {
return 15;
}
@Override public boolean equals(Object o) {
if (o == null || getClass() != o.getClass()) return false;
DataContainer15 n = (DataContainer15)o;
return b0 == n.b0 && b1 == n.b1 && b2 == n.b2 && b3 == n.b3 && b4 == n.b4 && b5 == n.b5 && b6 == n.b6 && b7 == n.b7 && b8 == n.b8 && b9 == n.b9 && b10 == n.b10 && b11 == n.b11 && b12 == n.b12 && b13 == n.b13 && b14 == n.b14;
}
@Override public int hashCode() {
int result = size();
result = 31 * result + b0;
result = 31 * result + b1;
result = 31 * result + b2;
result = 31 * result + b3;
result = 31 * result + b4;
result = 31 * result + b5;
result = 31 * result + b6;
result = 31 * result + b7;
result = 31 * result + b8;
result = 31 * result + b9;
result = 31 * result + b10;
result = 31 * result + b11;
result = 31 * result + b12;
result = 31 * result + b13;
result = 31 * result + b14;
return result;
}
}
final class DataContainer16 implements DataContainer {
private byte b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15;
DataContainer16() {}
@Override public byte get(int index) {
switch (index) {
case 0: return b0;
case 1: return b1;
case 2: return b2;
case 3: return b3;
case 4: return b4;
case 5: return b5;
case 6: return b6;
case 7: return b7;
case 8: return b8;
case 9: return b9;
case 10: return b10;
case 11: return b11;
case 12: return b12;
case 13: return b13;
case 14: return b14;
case 15: return b15;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public void set(int index, byte data) {
switch (index) {
case 0: b0 = data; break;
case 1: b1 = data; break;
case 2: b2 = data; break;
case 3: b3 = data; break;
case 4: b4 = data; break;
case 5: b5 = data; break;
case 6: b6 = data; break;
case 7: b7 = data; break;
case 8: b8 = data; break;
case 9: b9 = data; break;
case 10: b10 = data; break;
case 11: b11 = data; break;
case 12: b12 = data; break;
case 13: b13 = data; break;
case 14: b14 = data; break;
case 15: b15 = data; break;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public int size() {
return 16;
}
@Override public boolean equals(Object o) {
if (o == null || getClass() != o.getClass()) return false;
DataContainer16 n = (DataContainer16)o;
return b0 == n.b0 && b1 == n.b1 && b2 == n.b2 && b3 == n.b3 && b4 == n.b4 && b5 == n.b5 && b6 == n.b6 && b7 == n.b7 && b8 == n.b8 && b9 == n.b9 && b10 == n.b10 && b11 == n.b11 && b12 == n.b12 && b13 == n.b13 && b14 == n.b14 && b15 == n.b15;
}
@Override public int hashCode() {
int result = size();
result = 31 * result + b0;
result = 31 * result + b1;
result = 31 * result + b2;
result = 31 * result + b3;
result = 31 * result + b4;
result = 31 * result + b5;
result = 31 * result + b6;
result = 31 * result + b7;
result = 31 * result + b8;
result = 31 * result + b9;
result = 31 * result + b10;
result = 31 * result + b11;
result = 31 * result + b12;
result = 31 * result + b13;
result = 31 * result + b14;
result = 31 * result + b15;
return result;
}
}
final class DataContainer17 implements DataContainer {
private byte b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16;
DataContainer17() {}
@Override public byte get(int index) {
switch (index) {
case 0: return b0;
case 1: return b1;
case 2: return b2;
case 3: return b3;
case 4: return b4;
case 5: return b5;
case 6: return b6;
case 7: return b7;
case 8: return b8;
case 9: return b9;
case 10: return b10;
case 11: return b11;
case 12: return b12;
case 13: return b13;
case 14: return b14;
case 15: return b15;
case 16: return b16;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public void set(int index, byte data) {
switch (index) {
case 0: b0 = data; break;
case 1: b1 = data; break;
case 2: b2 = data; break;
case 3: b3 = data; break;
case 4: b4 = data; break;
case 5: b5 = data; break;
case 6: b6 = data; break;
case 7: b7 = data; break;
case 8: b8 = data; break;
case 9: b9 = data; break;
case 10: b10 = data; break;
case 11: b11 = data; break;
case 12: b12 = data; break;
case 13: b13 = data; break;
case 14: b14 = data; break;
case 15: b15 = data; break;
case 16: b16 = data; break;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public int size() {
return 17;
}
@Override public boolean equals(Object o) {
if (o == null || getClass() != o.getClass()) return false;
DataContainer17 n = (DataContainer17)o;
return b0 == n.b0 && b1 == n.b1 && b2 == n.b2 && b3 == n.b3 && b4 == n.b4 && b5 == n.b5 && b6 == n.b6 && b7 == n.b7 && b8 == n.b8 && b9 == n.b9 && b10 == n.b10 && b11 == n.b11 && b12 == n.b12 && b13 == n.b13 && b14 == n.b14 && b15 == n.b15 && b16 == n.b16;
}
@Override public int hashCode() {
int result = size();
result = 31 * result + b0;
result = 31 * result + b1;
result = 31 * result + b2;
result = 31 * result + b3;
result = 31 * result + b4;
result = 31 * result + b5;
result = 31 * result + b6;
result = 31 * result + b7;
result = 31 * result + b8;
result = 31 * result + b9;
result = 31 * result + b10;
result = 31 * result + b11;
result = 31 * result + b12;
result = 31 * result + b13;
result = 31 * result + b14;
result = 31 * result + b15;
result = 31 * result + b16;
return result;
}
}
final class DataContainer18 implements DataContainer {
private byte b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17;
DataContainer18() {}
@Override public byte get(int index) {
switch (index) {
case 0: return b0;
case 1: return b1;
case 2: return b2;
case 3: return b3;
case 4: return b4;
case 5: return b5;
case 6: return b6;
case 7: return b7;
case 8: return b8;
case 9: return b9;
case 10: return b10;
case 11: return b11;
case 12: return b12;
case 13: return b13;
case 14: return b14;
case 15: return b15;
case 16: return b16;
case 17: return b17;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public void set(int index, byte data) {
switch (index) {
case 0: b0 = data; break;
case 1: b1 = data; break;
case 2: b2 = data; break;
case 3: b3 = data; break;
case 4: b4 = data; break;
case 5: b5 = data; break;
case 6: b6 = data; break;
case 7: b7 = data; break;
case 8: b8 = data; break;
case 9: b9 = data; break;
case 10: b10 = data; break;
case 11: b11 = data; break;
case 12: b12 = data; break;
case 13: b13 = data; break;
case 14: b14 = data; break;
case 15: b15 = data; break;
case 16: b16 = data; break;
case 17: b17 = data; break;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public int size() {
return 18;
}
@Override public boolean equals(Object o) {
if (o == null || getClass() != o.getClass()) return false;
DataContainer18 n = (DataContainer18)o;
return b0 == n.b0 && b1 == n.b1 && b2 == n.b2 && b3 == n.b3 && b4 == n.b4 && b5 == n.b5 && b6 == n.b6 && b7 == n.b7 && b8 == n.b8 && b9 == n.b9 && b10 == n.b10 && b11 == n.b11 && b12 == n.b12 && b13 == n.b13 && b14 == n.b14 && b15 == n.b15 && b16 == n.b16 && b17 == n.b17;
}
@Override public int hashCode() {
int result = size();
result = 31 * result + b0;
result = 31 * result + b1;
result = 31 * result + b2;
result = 31 * result + b3;
result = 31 * result + b4;
result = 31 * result + b5;
result = 31 * result + b6;
result = 31 * result + b7;
result = 31 * result + b8;
result = 31 * result + b9;
result = 31 * result + b10;
result = 31 * result + b11;
result = 31 * result + b12;
result = 31 * result + b13;
result = 31 * result + b14;
result = 31 * result + b15;
result = 31 * result + b16;
result = 31 * result + b17;
return result;
}
}
final class DataContainer19 implements DataContainer {
private byte b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18;
DataContainer19() {}
@Override public byte get(int index) {
switch (index) {
case 0: return b0;
case 1: return b1;
case 2: return b2;
case 3: return b3;
case 4: return b4;
case 5: return b5;
case 6: return b6;
case 7: return b7;
case 8: return b8;
case 9: return b9;
case 10: return b10;
case 11: return b11;
case 12: return b12;
case 13: return b13;
case 14: return b14;
case 15: return b15;
case 16: return b16;
case 17: return b17;
case 18: return b18;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public void set(int index, byte data) {
switch (index) {
case 0: b0 = data; break;
case 1: b1 = data; break;
case 2: b2 = data; break;
case 3: b3 = data; break;
case 4: b4 = data; break;
case 5: b5 = data; break;
case 6: b6 = data; break;
case 7: b7 = data; break;
case 8: b8 = data; break;
case 9: b9 = data; break;
case 10: b10 = data; break;
case 11: b11 = data; break;
case 12: b12 = data; break;
case 13: b13 = data; break;
case 14: b14 = data; break;
case 15: b15 = data; break;
case 16: b16 = data; break;
case 17: b17 = data; break;
case 18: b18 = data; break;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public int size() {
return 19;
}
@Override public boolean equals(Object o) {
if (o == null || getClass() != o.getClass()) return false;
DataContainer19 n = (DataContainer19)o;
return b0 == n.b0 && b1 == n.b1 && b2 == n.b2 && b3 == n.b3 && b4 == n.b4 && b5 == n.b5 && b6 == n.b6 && b7 == n.b7 && b8 == n.b8 && b9 == n.b9 && b10 == n.b10 && b11 == n.b11 && b12 == n.b12 && b13 == n.b13 && b14 == n.b14 && b15 == n.b15 && b16 == n.b16 && b17 == n.b17 && b18 == n.b18;
}
@Override public int hashCode() {
int result = size();
result = 31 * result + b0;
result = 31 * result + b1;
result = 31 * result + b2;
result = 31 * result + b3;
result = 31 * result + b4;
result = 31 * result + b5;
result = 31 * result + b6;
result = 31 * result + b7;
result = 31 * result + b8;
result = 31 * result + b9;
result = 31 * result + b10;
result = 31 * result + b11;
result = 31 * result + b12;
result = 31 * result + b13;
result = 31 * result + b14;
result = 31 * result + b15;
result = 31 * result + b16;
result = 31 * result + b17;
result = 31 * result + b18;
return result;
}
}
final class DataContainer20 implements DataContainer {
private byte b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19;
DataContainer20() {}
@Override public byte get(int index) {
switch (index) {
case 0: return b0;
case 1: return b1;
case 2: return b2;
case 3: return b3;
case 4: return b4;
case 5: return b5;
case 6: return b6;
case 7: return b7;
case 8: return b8;
case 9: return b9;
case 10: return b10;
case 11: return b11;
case 12: return b12;
case 13: return b13;
case 14: return b14;
case 15: return b15;
case 16: return b16;
case 17: return b17;
case 18: return b18;
case 19: return b19;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public void set(int index, byte data) {
switch (index) {
case 0: b0 = data; break;
case 1: b1 = data; break;
case 2: b2 = data; break;
case 3: b3 = data; break;
case 4: b4 = data; break;
case 5: b5 = data; break;
case 6: b6 = data; break;
case 7: b7 = data; break;
case 8: b8 = data; break;
case 9: b9 = data; break;
case 10: b10 = data; break;
case 11: b11 = data; break;
case 12: b12 = data; break;
case 13: b13 = data; break;
case 14: b14 = data; break;
case 15: b15 = data; break;
case 16: b16 = data; break;
case 17: b17 = data; break;
case 18: b18 = data; break;
case 19: b19 = data; break;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public int size() {
return 20;
}
@Override public boolean equals(Object o) {
if (o == null || getClass() != o.getClass()) return false;
DataContainer20 n = (DataContainer20)o;
return b0 == n.b0 && b1 == n.b1 && b2 == n.b2 && b3 == n.b3 && b4 == n.b4 && b5 == n.b5 && b6 == n.b6 && b7 == n.b7 && b8 == n.b8 && b9 == n.b9 && b10 == n.b10 && b11 == n.b11 && b12 == n.b12 && b13 == n.b13 && b14 == n.b14 && b15 == n.b15 && b16 == n.b16 && b17 == n.b17 && b18 == n.b18 && b19 == n.b19;
}
@Override public int hashCode() {
int result = size();
result = 31 * result + b0;
result = 31 * result + b1;
result = 31 * result + b2;
result = 31 * result + b3;
result = 31 * result + b4;
result = 31 * result + b5;
result = 31 * result + b6;
result = 31 * result + b7;
result = 31 * result + b8;
result = 31 * result + b9;
result = 31 * result + b10;
result = 31 * result + b11;
result = 31 * result + b12;
result = 31 * result + b13;
result = 31 * result + b14;
result = 31 * result + b15;
result = 31 * result + b16;
result = 31 * result + b17;
result = 31 * result + b18;
result = 31 * result + b19;
return result;
}
}
final class DataContainer21 implements DataContainer {
private byte b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20;
DataContainer21() {}
@Override public byte get(int index) {
switch (index) {
case 0: return b0;
case 1: return b1;
case 2: return b2;
case 3: return b3;
case 4: return b4;
case 5: return b5;
case 6: return b6;
case 7: return b7;
case 8: return b8;
case 9: return b9;
case 10: return b10;
case 11: return b11;
case 12: return b12;
case 13: return b13;
case 14: return b14;
case 15: return b15;
case 16: return b16;
case 17: return b17;
case 18: return b18;
case 19: return b19;
case 20: return b20;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public void set(int index, byte data) {
switch (index) {
case 0: b0 = data; break;
case 1: b1 = data; break;
case 2: b2 = data; break;
case 3: b3 = data; break;
case 4: b4 = data; break;
case 5: b5 = data; break;
case 6: b6 = data; break;
case 7: b7 = data; break;
case 8: b8 = data; break;
case 9: b9 = data; break;
case 10: b10 = data; break;
case 11: b11 = data; break;
case 12: b12 = data; break;
case 13: b13 = data; break;
case 14: b14 = data; break;
case 15: b15 = data; break;
case 16: b16 = data; break;
case 17: b17 = data; break;
case 18: b18 = data; break;
case 19: b19 = data; break;
case 20: b20 = data; break;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public int size() {
return 21;
}
@Override public boolean equals(Object o) {
if (o == null || getClass() != o.getClass()) return false;
DataContainer21 n = (DataContainer21)o;
return b0 == n.b0 && b1 == n.b1 && b2 == n.b2 && b3 == n.b3 && b4 == n.b4 && b5 == n.b5 && b6 == n.b6 && b7 == n.b7 && b8 == n.b8 && b9 == n.b9 && b10 == n.b10 && b11 == n.b11 && b12 == n.b12 && b13 == n.b13 && b14 == n.b14 && b15 == n.b15 && b16 == n.b16 && b17 == n.b17 && b18 == n.b18 && b19 == n.b19 && b20 == n.b20;
}
@Override public int hashCode() {
int result = size();
result = 31 * result + b0;
result = 31 * result + b1;
result = 31 * result + b2;
result = 31 * result + b3;
result = 31 * result + b4;
result = 31 * result + b5;
result = 31 * result + b6;
result = 31 * result + b7;
result = 31 * result + b8;
result = 31 * result + b9;
result = 31 * result + b10;
result = 31 * result + b11;
result = 31 * result + b12;
result = 31 * result + b13;
result = 31 * result + b14;
result = 31 * result + b15;
result = 31 * result + b16;
result = 31 * result + b17;
result = 31 * result + b18;
result = 31 * result + b19;
result = 31 * result + b20;
return result;
}
}
final class DataContainer22 implements DataContainer {
private byte b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21;
DataContainer22() {}
@Override public byte get(int index) {
switch (index) {
case 0: return b0;
case 1: return b1;
case 2: return b2;
case 3: return b3;
case 4: return b4;
case 5: return b5;
case 6: return b6;
case 7: return b7;
case 8: return b8;
case 9: return b9;
case 10: return b10;
case 11: return b11;
case 12: return b12;
case 13: return b13;
case 14: return b14;
case 15: return b15;
case 16: return b16;
case 17: return b17;
case 18: return b18;
case 19: return b19;
case 20: return b20;
case 21: return b21;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public void set(int index, byte data) {
switch (index) {
case 0: b0 = data; break;
case 1: b1 = data; break;
case 2: b2 = data; break;
case 3: b3 = data; break;
case 4: b4 = data; break;
case 5: b5 = data; break;
case 6: b6 = data; break;
case 7: b7 = data; break;
case 8: b8 = data; break;
case 9: b9 = data; break;
case 10: b10 = data; break;
case 11: b11 = data; break;
case 12: b12 = data; break;
case 13: b13 = data; break;
case 14: b14 = data; break;
case 15: b15 = data; break;
case 16: b16 = data; break;
case 17: b17 = data; break;
case 18: b18 = data; break;
case 19: b19 = data; break;
case 20: b20 = data; break;
case 21: b21 = data; break;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public int size() {
return 22;
}
@Override public boolean equals(Object o) {
if (o == null || getClass() != o.getClass()) return false;
DataContainer22 n = (DataContainer22)o;
return b0 == n.b0 && b1 == n.b1 && b2 == n.b2 && b3 == n.b3 && b4 == n.b4 && b5 == n.b5 && b6 == n.b6 && b7 == n.b7 && b8 == n.b8 && b9 == n.b9 && b10 == n.b10 && b11 == n.b11 && b12 == n.b12 && b13 == n.b13 && b14 == n.b14 && b15 == n.b15 && b16 == n.b16 && b17 == n.b17 && b18 == n.b18 && b19 == n.b19 && b20 == n.b20 && b21 == n.b21;
}
@Override public int hashCode() {
int result = size();
result = 31 * result + b0;
result = 31 * result + b1;
result = 31 * result + b2;
result = 31 * result + b3;
result = 31 * result + b4;
result = 31 * result + b5;
result = 31 * result + b6;
result = 31 * result + b7;
result = 31 * result + b8;
result = 31 * result + b9;
result = 31 * result + b10;
result = 31 * result + b11;
result = 31 * result + b12;
result = 31 * result + b13;
result = 31 * result + b14;
result = 31 * result + b15;
result = 31 * result + b16;
result = 31 * result + b17;
result = 31 * result + b18;
result = 31 * result + b19;
result = 31 * result + b20;
result = 31 * result + b21;
return result;
}
}
final class DataContainer23 implements DataContainer {
private byte b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22;
DataContainer23() {}
@Override public byte get(int index) {
switch (index) {
case 0: return b0;
case 1: return b1;
case 2: return b2;
case 3: return b3;
case 4: return b4;
case 5: return b5;
case 6: return b6;
case 7: return b7;
case 8: return b8;
case 9: return b9;
case 10: return b10;
case 11: return b11;
case 12: return b12;
case 13: return b13;
case 14: return b14;
case 15: return b15;
case 16: return b16;
case 17: return b17;
case 18: return b18;
case 19: return b19;
case 20: return b20;
case 21: return b21;
case 22: return b22;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public void set(int index, byte data) {
switch (index) {
case 0: b0 = data; break;
case 1: b1 = data; break;
case 2: b2 = data; break;
case 3: b3 = data; break;
case 4: b4 = data; break;
case 5: b5 = data; break;
case 6: b6 = data; break;
case 7: b7 = data; break;
case 8: b8 = data; break;
case 9: b9 = data; break;
case 10: b10 = data; break;
case 11: b11 = data; break;
case 12: b12 = data; break;
case 13: b13 = data; break;
case 14: b14 = data; break;
case 15: b15 = data; break;
case 16: b16 = data; break;
case 17: b17 = data; break;
case 18: b18 = data; break;
case 19: b19 = data; break;
case 20: b20 = data; break;
case 21: b21 = data; break;
case 22: b22 = data; break;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public int size() {
return 23;
}
@Override public boolean equals(Object o) {
if (o == null || getClass() != o.getClass()) return false;
DataContainer23 n = (DataContainer23)o;
return b0 == n.b0 && b1 == n.b1 && b2 == n.b2 && b3 == n.b3 && b4 == n.b4 && b5 == n.b5 && b6 == n.b6 && b7 == n.b7 && b8 == n.b8 && b9 == n.b9 && b10 == n.b10 && b11 == n.b11 && b12 == n.b12 && b13 == n.b13 && b14 == n.b14 && b15 == n.b15 && b16 == n.b16 && b17 == n.b17 && b18 == n.b18 && b19 == n.b19 && b20 == n.b20 && b21 == n.b21 && b22 == n.b22;
}
@Override public int hashCode() {
int result = size();
result = 31 * result + b0;
result = 31 * result + b1;
result = 31 * result + b2;
result = 31 * result + b3;
result = 31 * result + b4;
result = 31 * result + b5;
result = 31 * result + b6;
result = 31 * result + b7;
result = 31 * result + b8;
result = 31 * result + b9;
result = 31 * result + b10;
result = 31 * result + b11;
result = 31 * result + b12;
result = 31 * result + b13;
result = 31 * result + b14;
result = 31 * result + b15;
result = 31 * result + b16;
result = 31 * result + b17;
result = 31 * result + b18;
result = 31 * result + b19;
result = 31 * result + b20;
result = 31 * result + b21;
result = 31 * result + b22;
return result;
}
}
final class DataContainer24 implements DataContainer {
private byte b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23;
DataContainer24() {}
@Override public byte get(int index) {
switch (index) {
case 0: return b0;
case 1: return b1;
case 2: return b2;
case 3: return b3;
case 4: return b4;
case 5: return b5;
case 6: return b6;
case 7: return b7;
case 8: return b8;
case 9: return b9;
case 10: return b10;
case 11: return b11;
case 12: return b12;
case 13: return b13;
case 14: return b14;
case 15: return b15;
case 16: return b16;
case 17: return b17;
case 18: return b18;
case 19: return b19;
case 20: return b20;
case 21: return b21;
case 22: return b22;
case 23: return b23;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public void set(int index, byte data) {
switch (index) {
case 0: b0 = data; break;
case 1: b1 = data; break;
case 2: b2 = data; break;
case 3: b3 = data; break;
case 4: b4 = data; break;
case 5: b5 = data; break;
case 6: b6 = data; break;
case 7: b7 = data; break;
case 8: b8 = data; break;
case 9: b9 = data; break;
case 10: b10 = data; break;
case 11: b11 = data; break;
case 12: b12 = data; break;
case 13: b13 = data; break;
case 14: b14 = data; break;
case 15: b15 = data; break;
case 16: b16 = data; break;
case 17: b17 = data; break;
case 18: b18 = data; break;
case 19: b19 = data; break;
case 20: b20 = data; break;
case 21: b21 = data; break;
case 22: b22 = data; break;
case 23: b23 = data; break;
default: throw new IndexOutOfBoundsException(""+index);
}
}
@Override public int size() {
return 24;
}
@Override public boolean equals(Object o) {
if (o == null || getClass() != o.getClass()) return false;
DataContainer24 n = (DataContainer24)o;
return b0 == n.b0 && b1 == n.b1 && b2 == n.b2 && b3 == n.b3 && b4 == n.b4 && b5 == n.b5 && b6 == n.b6 && b7 == n.b7 && b8 == n.b8 && b9 == n.b9 && b10 == n.b10 && b11 == n.b11 && b12 == n.b12 && b13 == n.b13 && b14 == n.b14 && b15 == n.b15 && b16 == n.b16 && b17 == n.b17 && b18 == n.b18 && b19 == n.b19 && b20 == n.b20 && b21 == n.b21 && b22 == n.b22 && b23 == n.b23;
}
@Override public int hashCode() {
int result = size();
result = 31 * result + b0;
result = 31 * result + b1;
result = 31 * result + b2;
result = 31 * result + b3;
result = 31 * result + b4;
result = 31 * result + b5;
result = 31 * result + b6;
result = 31 * result + b7;
result = 31 * result + b8;
result = 31 * result + b9;
result = 31 * result + b10;
result = 31 * result + b11;
result = 31 * result + b12;
result = 31 * result + b13;
result = 31 * result + b14;
result = 31 * result + b15;
result = 31 * result + b16;
result = 31 * result + b17;
result = 31 * result + b18;
result = 31 * result + b19;
result = 31 * result + b20;
result = 31 * result + b21;
result = 31 * result + b22;
result = 31 * result + b23;
return result;
}
}
