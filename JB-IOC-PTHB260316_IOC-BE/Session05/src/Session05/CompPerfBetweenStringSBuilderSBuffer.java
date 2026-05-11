package Session05;

public class CompPerfBetweenStringSBuilderSBuffer {
	public static void main(String[] args) {
		final int N = 1_000_000;
		System.out.println("Concatenation iterations: " + N);
		long start = System.currentTimeMillis();
		String s = "Hello";
		for (int i = 0; i < N; i++) {
			s = s + "World";
		}
		long end = System.currentTimeMillis();
		System.out.println("String time: " + (end - start) + " ms; length=" + s.length());
		start = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder("Hello");
		for (int i = 0; i < N; i++) {
			sb.append("World");
		}
		end = System.currentTimeMillis();
		System.out.println("StringBuilder time: " + (end - start) + " ms; length=" + sb.length());
		start = System.currentTimeMillis();
		StringBuffer sbuf = new StringBuffer("Hello");
		for (int i = 0; i < N; i++) {
			sbuf.append("World");
		}
		end = System.currentTimeMillis();
		System.out.println("StringBuffer time: " + (end - start) + " ms; length=" + sbuf.length());
		System.out.println("Notes: String is immutable and becomes very slow for many concatenations; StringBuilder is recommended for single-threaded building; StringBuffer is thread-safe but slower than StringBuilder.");
	}
}
