package demoQaSite.testCkeckThemeBlackWhite;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class TestWhiteTheme {

    @Test
    public void TestTheme(){
        open("https://developer.mozilla.org/ru/");

        $x("//button[@class=\"button action has-icon theme-switcher-menu small\"]").click();
        SelenideElement darkElement = $x("//span[@class=\"button-wrap\" and text()='Light']");
        SelenideElement footer = $x("//footer");

        String getTextButton = darkElement.getText();
        darkElement.click();

        String colorBack = footer.getCssValue("background-color");
        String colorActualBlack = "rgba(49, 49, 49, 1)";
        String colorActualLight = "rgba(249, 249, 251, 1)";
        if(colorBack.equals(colorActualBlack)){
            System.out.println("very good");
        }else{
            System.out.println("very bad");
        }



    }
}
