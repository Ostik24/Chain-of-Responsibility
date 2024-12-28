package ucu.edu.ua;

import java.util.function.Consumer;

public class Signature<T> extends Task<T> {
    private Consumer<T> consumer;

    public Signature(Consumer<T> consumer) {
        this.consumer = consumer;
    }

    @Override
    public void apply(T arg) {
        this.freeze();
        consumer.accept(arg);
    }
}