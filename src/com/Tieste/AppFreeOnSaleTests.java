package com.tieste;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppFreeOnSaleTests {

    public static String appID ="500909640";

    @Before
    public void beforeDriver(){
        TestHelper.setup(TestHelper.url);
        }

    @Test
    public void testOrderAppFreeOnSale() {
        Login.pressSignIn();
        Login.emailField("apppicker_developer@ukr.net");
        Login.passwordField("apppicker_developer");
        Login.pressLoginbutton();

        Assert.assertEquals("Lilia_developer", Login.getDeveloperNick(Login.developerNick));
        System.out.println(Login.getDeveloperNick(Login.developerNick));

        Assert.assertEquals("Block vs Block", BestOfList.getAppTitle(appID));
        System.out.println(BestOfList.getAppTitle(appID));

        BestOfList.pressAccessFeaturesButton(appID);

        AppFreeOnSale.pressFreeOnSaleMissionControl(appID);
        AppFreeOnSale.selectArticleAppsaleType("On sale iPhone apps");
        AppFreeOnSale.enterOldPrice("20");
        AppFreeOnSale.priceDropDate("25");
        TestHelper.slp(5);
        AppFreeOnSale.selectFirstPlace("0");
        TestHelper.slp(5);
        AppFreeOnSale.enterDescription("if you're thinking about getting a tattoo but you're hesitating because of " +
                "how permanent they are you're probably not alone. Getting a tattoo is a big decision " +
                "because it will be with you the rest of your life so it's not a decision you should take lightly. " +
                "It would be great if you could actually see what a tattoo might look like on you before you get " +
                "the work done. With Virtual Tattoo Maker FREE you can now virtually add tattoos to your body so that " +
                "you can see decide if it really is for you. This is a free app and it's compatible " +
                "with the iPhone, iPad, and iPod touch");
        AppFreeOnSale.setTick();
        AppFreeOnSale.pressButtonPayPal();
        TestHelper.slp(20);
        AppFreeOnSale.fillPayPal();
        TestHelper.slp(7);
        Assert.assertEquals("Lilia_developer", Login.getDeveloperNick(Login.developerNick));
    }

    @After
    public void afterDriver(){
        //TestHelper.quit();
    }
}
