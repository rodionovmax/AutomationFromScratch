package com.romanceabroad.ui;

import org.testng.annotations.Test;

public class Passwords extends BaseUI{

    @Test(dataProvider = "passwords", dataProviderClass = DataProviders.class)
    public void testPasswords(String email, String password, boolean requirement){
        main.clickJoinButton();
        registrationForm.getStartedWithDataProvider(email, password);
    }
}
