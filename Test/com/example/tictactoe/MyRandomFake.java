package com.example.tictactoe;

import java.util.List;
import java.util.random.RandomGenerator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class MyRandomFake implements RandomGenerator {
    private List<Integer> values;
    private int place = 0;

    public MyRandomFake(List<Integer> values) {
        this.values = values;
    }

    @Override
    public boolean isDeprecated() {
        return RandomGenerator.super.isDeprecated();
    }

    @Override
    public DoubleStream doubles() {
        return RandomGenerator.super.doubles();
    }

    @Override
    public DoubleStream doubles(double randomNumberOrigin, double randomNumberBound) {
        return RandomGenerator.super.doubles(randomNumberOrigin, randomNumberBound);
    }

    @Override
    public DoubleStream doubles(long streamSize) {
        return RandomGenerator.super.doubles(streamSize);
    }

    @Override
    public DoubleStream doubles(long streamSize, double randomNumberOrigin, double randomNumberBound) {
        return RandomGenerator.super.doubles(streamSize, randomNumberOrigin, randomNumberBound);
    }

    @Override
    public IntStream ints() {
        return RandomGenerator.super.ints();
    }

    @Override
    public IntStream ints(int randomNumberOrigin, int randomNumberBound) {
        return RandomGenerator.super.ints(randomNumberOrigin, randomNumberBound);
    }

    @Override
    public IntStream ints(long streamSize) {
        return RandomGenerator.super.ints(streamSize);
    }

    @Override
    public IntStream ints(long streamSize, int randomNumberOrigin, int randomNumberBound) {
        return RandomGenerator.super.ints(streamSize, randomNumberOrigin, randomNumberBound);
    }

    @Override
    public LongStream longs() {
        return RandomGenerator.super.longs();
    }

    @Override
    public LongStream longs(long randomNumberOrigin, long randomNumberBound) {
        return RandomGenerator.super.longs(randomNumberOrigin, randomNumberBound);
    }

    @Override
    public LongStream longs(long streamSize) {
        return RandomGenerator.super.longs(streamSize);
    }

    @Override
    public LongStream longs(long streamSize, long randomNumberOrigin, long randomNumberBound) {
        return RandomGenerator.super.longs(streamSize, randomNumberOrigin, randomNumberBound);
    }

    @Override
    public boolean nextBoolean() {
        return RandomGenerator.super.nextBoolean();
    }

    @Override
    public void nextBytes(byte[] bytes) {
        RandomGenerator.super.nextBytes(bytes);
    }

    @Override
    public float nextFloat() {
        return RandomGenerator.super.nextFloat();
    }

    @Override
    public float nextFloat(float bound) {
        return RandomGenerator.super.nextFloat(bound);
    }

    @Override
    public float nextFloat(float origin, float bound) {
        return RandomGenerator.super.nextFloat(origin, bound);
    }

    @Override
    public double nextDouble() {
        return RandomGenerator.super.nextDouble();
    }

    @Override
    public double nextDouble(double bound) {
        return RandomGenerator.super.nextDouble(bound);
    }

    @Override
    public double nextDouble(double origin, double bound) {
        return RandomGenerator.super.nextDouble(origin, bound);
    }

    @Override
    public int nextInt() {
        return RandomGenerator.super.nextInt();
    }

    @Override
    public int nextInt(int bound) {
        return values.get(place++);
    }

    @Override
    public int nextInt(int origin, int bound) {
        return RandomGenerator.super.nextInt(origin, bound);
    }

    @Override
    public long nextLong() {
        return 0;
    }

    @Override
    public long nextLong(long bound) {
        return RandomGenerator.super.nextLong(bound);
    }

    @Override
    public long nextLong(long origin, long bound) {
        return RandomGenerator.super.nextLong(origin, bound);
    }

    @Override
    public double nextGaussian() {
        return RandomGenerator.super.nextGaussian();
    }

    @Override
    public double nextGaussian(double mean, double stddev) {
        return RandomGenerator.super.nextGaussian(mean, stddev);
    }

    @Override
    public double nextExponential() {
        return RandomGenerator.super.nextExponential();
    }
}
