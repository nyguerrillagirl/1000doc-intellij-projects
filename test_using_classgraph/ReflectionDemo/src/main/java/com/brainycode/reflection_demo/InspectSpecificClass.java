package com.brainycode.reflection_demo;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.MethodInfo;
import io.github.classgraph.FieldInfo;
import io.github.classgraph.AnnotationInfo;
import io.github.classgraph.ScanResult;

public class InspectSpecificClass {
    public static void main(String[] args) {

        String targetClass = "reactor.core.publisher.Flux";

        try (ScanResult scanResult = new ClassGraph()
                .enableAllInfo()          // enable methods, fields, annotations, etc.
                .acceptClasses(targetClass) // only scan this class
                .scan()) {

            ClassInfo classInfo = scanResult.getClassInfo(targetClass);

            if (classInfo == null) {
                System.out.println("Class not found on the classpath: " + targetClass);
                return;
            }

            // Print basic class info
            System.out.println("Class: " + classInfo.getName());
            System.out.println("Package: " + classInfo.getPackageName());
            System.out.println("From JAR: " + classInfo.getClasspathElementURI());
            System.out.println();

            // Print methods
            System.out.println("Methods:");
            for (MethodInfo method : classInfo.getMethodInfo()) {
                System.out.println("    " + method.getName() + method.getTypeDescriptor());
            }
            System.out.println();

            // Print fields
            System.out.println("Fields:");
            for (FieldInfo field : classInfo.getFieldInfo()) {
                System.out.println("    " + field.getName() + " : " + field.getTypeSignatureOrTypeDescriptor());
            }
            System.out.println();

            // Print annotations
            System.out.println("Annotations:");
            for (AnnotationInfo annotation : classInfo.getAnnotationInfo()) {
                System.out.println("    @" + annotation.getName());
            }
        }
    }
}
