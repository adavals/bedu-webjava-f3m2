package com.test.interviewer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MenuTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @AfterEach
    void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }



    @Test
    void addNewInterviewer () {
        final String interviewerName = "Interviewer Name";
        final String interviewerLastName = "Interviewer Lastname";
        final String interviewerEmail = "Interviewer Email";
        final String addNewInterviewerCommand = "1 \n "+ interviewerName + " \n " + interviewerLastName + " \n " + interviewerEmail + " \n 1 \n 5 \n";
        provideInput(addNewInterviewerCommand);

        Menu.main(new String[0]);
        final String output = getOutput();

        assertTrue(output.contains(interviewerName));
        assertTrue(output.contains(interviewerLastName));
        assertTrue(output.contains(interviewerEmail));
    }

    @Test
    void getInterviewer (){
        final String interviewerName = "Interviewer Name";
        final String interviewerLastName = "Interviewer Lastname";
        final String interviewerEmail = "interviewer@mail.com";
        final String addNewInterviewerCommand = "1 \n "+ interviewerName + " \n " + interviewerLastName + " \n " + interviewerEmail + " \n 1 \n";
        final String getInterviewerCommand = "2 \n " + interviewerEmail + "\n ";
        final String exitCommand = "5 \n";
        System.out.println(addNewInterviewerCommand);
        System.out.println(getInterviewerCommand);

        provideInput(addNewInterviewerCommand + getInterviewerCommand + exitCommand);
        Menu.main(new String[0]);
        final String output = getOutput();
    
        assertTrue(output.contains(interviewerName));
        assertTrue(output.contains(interviewerLastName));
        assertTrue(output.contains(interviewerEmail));
    }

    @Test
    void modifyInterviewer(){
        final String interviewerName = "Capri";
        final String interviewerLastName = "Cho";
        final String interviewerEmail = "capri@mail.com";
        final String addNewInterviewerCommand = "1 \n "+ interviewerName + " \n " + interviewerLastName + " \n " + interviewerEmail + " \n 1 \n";

        final String interviewerNameModified = "Bono";
        final String interviewerLastNameModified = "Chocolate";
        final String interviewerEmailModified = "bono@mail.com";
        final String modifyInterviewerCommand = "3 \n " + interviewerEmail + " \n " + interviewerNameModified + " \n " + interviewerLastNameModified + " \n " + interviewerEmailModified + " \n 2 \n";

        final String getInterviewerCommand = "2 \n " + interviewerEmailModified + " \n ";

        final String exitCommand = "5 \n";

        provideInput(addNewInterviewerCommand
                + modifyInterviewerCommand
                + getInterviewerCommand
                + exitCommand);

        Menu.main(new String[0]);
        final String output = getOutput();
        

        assertTrue(output.contains(interviewerNameModified));
        assertTrue(output.contains(interviewerLastNameModified));
        assertTrue(output.contains(interviewerEmailModified));

     }
}