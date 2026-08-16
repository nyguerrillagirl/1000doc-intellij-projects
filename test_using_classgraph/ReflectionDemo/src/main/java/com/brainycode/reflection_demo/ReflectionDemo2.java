package com.brainycode.reflection_demo;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.MethodInfo;
import io.github.classgraph.ScanResult;

public class ReflectionDemo2 {
    public static void main(String[] args) {

        try (ScanResult scanResult = new ClassGraph()
                .enableClassInfo()
                .enableMethodInfo()
                .scan()) {

            // Loop through all discovered classes
            for (ClassInfo classInfo : scanResult.getAllClasses()) {

                System.out.println("Type: " + classInfo.getName());

                // Get methods for this class
                for (MethodInfo method : classInfo.getMethodInfo()) {
                    System.out.println("    Method: " + method.getName());
                }

                System.out.println(); // Blank line between types
            }

            // Summary similar to your C# program
            long totalTypes = scanResult.getAllClasses().size();
            long totalMethods = scanResult.getAllClasses()
                    .stream()
                    .mapToLong(c -> c.getMethodInfo().size())
                    .sum();

            System.out.printf(
                    "%,d types with %,d methods on the classpath.%n",
                    totalTypes,
                    totalMethods
            );
        }
    }

}
