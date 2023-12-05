package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import pages.CommonPage;

public class CustomTestListener implements ITestListener {
    CommonPage commonPage = new CommonPage();

    @Override
    public void onTestFailure(ITestResult result) {
        commonPage.clickOnSignOut();

    }
}