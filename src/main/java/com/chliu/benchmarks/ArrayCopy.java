package com.chliu.benchmarks;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class ArrayCopy {

    private int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

    @GenerateMicroBenchmark
    public int[] clone_() {
        int[] copy = array.clone();
        return copy;
    }

    @GenerateMicroBenchmark
    public int[] arrayCopy() {
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy;
    }

    @GenerateMicroBenchmark
    public int[] copyOf() {
        int[] copy = Arrays.copyOf(array, array.length);
        return copy;
    }

    @GenerateMicroBenchmark
    public int[] loop() {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(".*" + ArrayCopy.class.getSimpleName() + ".*")
                .forks(1)
                .warmupForks(1)
                .warmupIterations(2)
                .measurementIterations(2)
                .build();

        new Runner(opt).run();
    }

}
