package com.example.clinicsimulator.device;

import com.example.clinicsimulator.results.TestCode;
import com.example.clinicsimulator.results.TestCategory;
import com.example.clinicsimulator.results.TestResult;

import java.util.Map;

public abstract class Analyzer
{
    private final int runTimeInSeconds;

    protected Analyzer(int runTimeInSeconds)
    {
        this.runTimeInSeconds = runTimeInSeconds;
    }

    public Map<TestCode, TestResult> runSampleTest()
    {
        try
        {
            System.out.printf("Executing %s test, duration: %s seconds %n",
                              getResultCategory(), runTimeInSeconds);
            Thread.sleep(runTimeInSeconds * 1000L);
            return provideResults();
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }

    protected abstract Map<TestCode, TestResult> provideResults();

    public abstract TestCategory getResultCategory();

    public abstract String formatResults(Map<TestCode, TestResult> results);
}
