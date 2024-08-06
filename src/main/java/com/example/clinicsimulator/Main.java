package com.example.clinicsimulator;

import com.example.clinicsimulator.results.TestCategory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main
{
    private static final String EXIT_COMMAND = "X";

    public static void main(String[] args)
    {
        List<String> categoryCodes = Arrays.stream(TestCategory.values())
                                           .map(TestCategory::getCategoryCode)
                                           .collect(Collectors.toList());

        System.out.println(
                "Request one or more of the following test categories separated by spaces: \n" + categoryCodes);

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext())
        {
            final String input = scanner.next();

            if (input.trim().equalsIgnoreCase(EXIT_COMMAND))
            {
                System.out.println("Exiting...");
                System.exit(0);
            }

            final List<TestCategory> requestedTestCategories = convertUserInput(input);

            AnalysisCoordinator.executeAnalysis(requestedTestCategories);
        }
    }

    private static List<TestCategory> convertUserInput(String input)
    {
        final String[] parsedInput = input.split(" ");
        final List<TestCategory> requestedTestCategories = new ArrayList<>();

        for (String requestedTestCategory : parsedInput)
        {
            TestCategory category = TestCategory.getInstance(requestedTestCategory);

            if (category != null)
            {
                requestedTestCategories.add(category);
            }
        }

        return requestedTestCategories;
    }
}
