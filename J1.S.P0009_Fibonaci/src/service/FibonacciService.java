package service;

import model.Fibonacci;

public class FibonacciService {

    private Fibonacci fibonacci;

    public FibonacciService() {
        this.fibonacci = new Fibonacci();
    }

    public long[] generateSequence(int count) {
        long[] sequence = new long[count];
        for (int i = 0; i < count; i++) {
            sequence[i] = fibonacci.calculateFibonacci(i);
        }
        return sequence;
    }

    public long getFibonacciAt(int n) {
        return fibonacci.calculateFibonacci(n);
    }
}
