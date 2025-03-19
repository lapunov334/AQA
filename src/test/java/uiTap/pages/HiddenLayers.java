package uiTap.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class HiddenLayers {
    private final SelenideElement buttonGreen = $x("//button[@id='greenButton']");//не нажатая кнопка
    private final SelenideElement buttonBlue = $x("//button[@id='blueButton']");//нажатая кнопка

    public HiddenLayers(String url) {
        open(url);
    }

    public boolean CheckButton(){
        return !buttonBlue.isDisplayed();
    }

    public boolean CheckClickButton(){
        buttonGreen.click();
        return buttonBlue.isDisplayed();
    }
}
