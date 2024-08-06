package com.example.clinicsimulator;

import com.example.clinicsimulator.device.HematologyAnalyzer;
import com.example.clinicsimulator.device.UrinalysisAnalyzer;
import com.example.clinicsimulator.results.TestCode;
import com.example.clinicsimulator.results.TestCategory;
import com.example.clinicsimulator.results.TestResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalysisCoordinator
{
    public static void executeAnalysis(List<TestCategory> testCategories)
    {
        for (TestCategory testCategory : testCategories)
        {
            final Map<TestCode, TestResult> resultMap;

            switch (testCategory)
            {
                case URINALYSIS:
                    UrinalysisAnalyzer ua = new UrinalysisAnalyzer();
                    resultMap = ua.runSampleTest();
                    System.out.println(ua.formatResults(resultMap));
                    break;
                case HEMATOLOGY:
                    HematologyAnalyzer ha = new HematologyAnalyzer();
                    resultMap = ha.runSampleTest();
                    System.out.println(ha.formatResults(resultMap));
                    break;
                default:
                    resultMap = new HashMap<>();
                    System.out.println("Requested test category was not handled!");
            }
        }
    }
}
