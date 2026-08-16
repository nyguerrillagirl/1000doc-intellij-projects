package com.brainycode.reflection_demo;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;

public class ReflectionDemo {
    public static void main(String[] args) {

        try (ScanResult scanResult = new ClassGraph()
                .enableClassInfo()
                .enableMethodInfo()
                .scan()) {

            long totalTypes = scanResult.getAllClasses().size();
            long totalMethods = scanResult.getAllClasses()
                    .stream()
                    .mapToLong(c -> c.getMethodInfo().size())
                    .sum();

            System.out.printf(
                    "%,d types with %,d methods on the classpath.%n",
                    totalTypes, totalMethods
            );
        }
    }
}
