package com.globant.exercises;

import org.testng.annotations.*;
import org.testng.annotations.Listeners;
import org.testng.Assert;

@Listeners(com.globant.exercises.ListenerTest.class)
public class PageESPN {
    public DisableUser test2 = new DisableUser();
    public LogIn test1 = new LogIn();
    public LogOut test3 = new LogOut();

    @BeforeGroups(groups = {"Test1", "Test2", "Test3"})
    public void OpenBrowser() {
        System.out.println("----OPENING THE BROWSER----");
    }

    @BeforeMethod(groups = {"Test1", "Test2", "Test3"})
    public void InputUserPass() {
        System.out.println("The user goes to the url: https://www.espn.com/?src=com&adblock=true ");
    }

    @Test(groups = {"Test1"})
    public void LogeoIn() {
        test1.InputUserPass();
        test1.WelcomeMessage();
        test1.Login();
        System.out.println("!-!-!-End of the first case!-!-!-");
    }

    @Test(groups = {"Test2"})
    public void Disable() {
        test1.InputUserPass();
        test1.WelcomeMessage();
        test2.GoSettings();
        test2.SelectDisable();
        test2.DisableUser();
    }

    @Test(groups = {"Test3"})
    public void LogeoOut() {
        test1.InputUserPass();
        test1.WelcomeMessage();
        test3.ClickLoggedOut();
        test3.Logout();
    }

    @AfterGroups(groups = {"Test1", "Test2", "Test3"})
    public void CloseBrowser() {
        System.out.println("***CLOSING THE BROWSER***");
    }
}
