package demoShop.pages;

import com.codeborne.selenide.SelenideElement;
import demoShop.utils.Credentials;


import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private final SelenideElement inputLogin = $x("//input[@data-test=\"username\"]");
    private final SelenideElement inputPassword = $x("//input[@data-test=\"password\"]");

    private final SelenideElement buttonLogin = $x("//input[@data-test=\"login-button\"]");


    public LoginPage(String url) {
        open(url);
    }

    public void authorization(){
        inputLogin.setValue(Credentials.STANDARD_USER);
        inputPassword.setValue(Credentials.PASSWORD);

        buttonLogin.click();
    }



}
