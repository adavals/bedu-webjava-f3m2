package com.test.interviewer.exceptions;

public class InterviewerNotFoundException extends RuntimeException {
    public InterviewerNotFoundException() {
        super();  // Call the superclass constructor
    }

    public InterviewerNotFoundException(String message) {
        super(message);  // Call the superclass constructor with a custom message
    }
    
}
