package com.example.clinicsimulator.device;

import com.example.clinicsimulator.results.TestCode;
import com.example.clinicsimulator.results.TestCategory;
import com.example.clinicsimulator.results.TestResult;

import java.util.HashMap;
import java.util.Map;

public class HematologyAnalyzer extends Analyzer
{
    public HematologyAnalyzer()
    {
        super(3);
    }

    @Override
    protected Map<TestCode, TestResult> provideResults()
    {
        final Map<TestCode, TestResult> resultMap = new HashMap<>();
        resultMap.put(TestCode.PQR, TestResult.POSITIVE);
        resultMap.put(TestCode.YZZ, TestResult.POSITIVE);
        resultMap.put(TestCode.GHI, TestResult.THREE);
        resultMap.put(TestCode.DEF, TestResult.NEGATIVE);
        return resultMap;
    }

    @Override
    public TestCategory getResultCategory()
    {
        return TestCategory.HEMATOLOGY;
    }

    @Override
    public String formatResults(Map<TestCode, TestResult> results)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Hematology Results:");
        for (TestCode testCode : results.keySet())
        {
            sb.append(String.format("  %s: %s", testCode, results.get(testCode)));
            sb.append("\n");
        }
        return sb.toString();
    }
}
