package demoQaSite.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class DragabblePage {

    private final SelenideElement movingBlock = $x("//div[text() = \"I'm contained within the box\"]");
    private final SelenideElement restricted = $x("//a[@data-rb-event-key=\"containerRestriction\"]");

    public DragabblePage(String url) {
        open(url);
    }

    public void MoveBlock(){
        restricted.click();
        actions().dragAndDropBy(movingBlock, 100,0).perform();
        screenshot("full_page");
    }
}
