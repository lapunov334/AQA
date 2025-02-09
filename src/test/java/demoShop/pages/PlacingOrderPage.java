package demoShop.pages;

import com.codeborne.selenide.SelenideElement;
import demoShop.utils.Credentials;


import static com.codeborne.selenide.Selenide.$x;

public class PlacingOrderPage {

    private final SelenideElement basketButton = $x("//div[@id=\"shopping_cart_container\"]");
    private final SelenideElement checkoutButton = $x("//button[@id=\"checkout\"]");

    private final SelenideElement firstName = $x("//input[@data-test=\"firstName\"]");
    private final SelenideElement lastName = $x("//input[@data-test=\"lastName\"]");
    private final SelenideElement postelCode = $x("//input[@data-test=\"postalCode\"]");
    private final SelenideElement submit = $x("//input[@type=\"submit\"]");
    private final SelenideElement finishButton = $x("//button[@name=\"finish\"]");
    private final SelenideElement completeOrder = $x("//h2[@class=\"complete-header\"]");




    public String orderCheck(){
        basketButton.click();
        checkoutButton.click();
        firstName.setValue(Credentials.FIRST_NAME);
        lastName.setValue(Credentials.LAST_NAME);
        postelCode.setValue(Credentials.POSTAL_CODE);
        submit.click();
        finishButton.click();

        return completeOrder.getText();
    }

}
