package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import pages.commonPage;

public class CustomTestListener implements ITestListener {
    pages.commonPage commonPage = new commonPage();

    @Override
    public void onTestFailure(ITestResult result) {
        commonPage.clickOnSignOut();

    }
}