package view;

public class FibonacciView {

    public void displayHeader(int count) {
        System.out.println("The " + count + " sequence Fibonacci:");
    }

    public void displaySequence(long[] sequence) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sequence.length; i++) {
            sb.append(sequence[i]);
            if (i < sequence.length - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());
    }

    public void displayFibonacci(int count, long[] sequence) {
        displayHeader(count);
        displaySequence(sequence);
    }
}
