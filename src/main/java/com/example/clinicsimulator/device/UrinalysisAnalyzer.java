package com.example.clinicsimulator.device;

import com.example.clinicsimulator.results.TestCode;
import com.example.clinicsimulator.results.TestCategory;
import com.example.clinicsimulator.results.TestResult;

import java.util.HashMap;
import java.util.Map;

public class UrinalysisAnalyzer extends Analyzer
{
    public UrinalysisAnalyzer()
    {
        super(5);
    }

    @Override
    protected Map<TestCode, TestResult> provideResults()
    {
        final Map<TestCode, TestResult> resultMap = new HashMap<>();
        resultMap.put(TestCode.VWX, TestResult.TWO);
        resultMap.put(TestCode.MNO, TestResult.ONE);
        resultMap.put(TestCode.YZZ, TestResult.NEGATIVE);
        resultMap.put(TestCode.ABC, TestResult.INCONCLUSIVE);
        return resultMap;
    }

    @Override
    public TestCategory getResultCategory()
    {
        return TestCategory.URINALYSIS;
    }

    @Override
    public String formatResults(Map<TestCode, TestResult> results)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Urinalysis Results:\n");
        for (TestCode testCode : results.keySet())
        {
            sb.append(String.format("  %s: %s", testCode, results.get(testCode)));
            sb.append("\n");
        }
        return sb.toString();
    }
}
