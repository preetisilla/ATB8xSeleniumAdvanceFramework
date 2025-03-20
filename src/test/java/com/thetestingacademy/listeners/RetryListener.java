package com.thetestingacademy.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer {

    public void transform(ITestAnnotation annotation,Class testClass){
        annotation.setRetryAnalyzer(RetryAnalyser.class);
    }
}
