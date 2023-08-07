package com.example.omarxv.pract_7_oigq;

import android.app.Activity;
import android.content.Intent;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler{
    private final Activity myContext;
    private final String LINE_SEPARATOR = "\n";
    StringBuilder errorReport = new StringBuilder();
    public ExceptionHandler(Activity context) {

        myContext = context;
    }
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        StringWriter stackTrace = new StringWriter();
        e.printStackTrace(new PrintWriter(stackTrace));
        errorReport.append("************ CAUSE OF ERROR ************\n\n");
        errorReport.append(stackTrace.toString());
        showErrorReport();
    }
    public void showErrorReport(){
        Intent intent = new Intent(myContext, Main3Activity.class);
        intent.putExtra("error", errorReport.toString());
        myContext.startActivity(intent);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(10);
    }
    public void addConsoleNotes(int i){
        errorReport.append(i);
        errorReport.append(LINE_SEPARATOR);
    }
    public void addConsoleNotes(String b){
        errorReport.append(b);
        errorReport.append(LINE_SEPARATOR);
    }
    public void addConsoleNotes(Boolean b){
        errorReport.append(b);
        errorReport.append(LINE_SEPARATOR);
    }
}

