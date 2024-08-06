package com.example.clinicsimulator.results;

public enum TestCategory
{
    URINALYSIS("U"),
    HEMATOLOGY("H");

    final String categoryCode;

    TestCategory(String categoryCode)
    {
        this.categoryCode = categoryCode;
    }

    public String getCategoryCode()
    {
        return categoryCode;
    }

    public static TestCategory getInstance(final String categoryCode)
    {
        TestCategory matchingCategory = null;

        for (TestCategory category : TestCategory.values())
        {
            if (category.categoryCode.equalsIgnoreCase(categoryCode))
            {
                matchingCategory = category;
            }
        }
        return matchingCategory;
    }
}
