package controller;

import service.FibonacciService;
import view.FibonacciView;

public class FibonacciController {

    private static final int FIBONACCI_COUNT = 45;

    private FibonacciService service;
    private FibonacciView view;

    public FibonacciController() {
        this.service = new FibonacciService();
        this.view = new FibonacciView();
    }

    public void run() {
        long[] sequence = service.generateSequence(FIBONACCI_COUNT);
        view.displayFibonacci(FIBONACCI_COUNT, sequence);
    }
}
