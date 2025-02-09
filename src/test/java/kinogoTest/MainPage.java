package kinogoTest;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;


public class MainPage {
    private final String YEAR = "'Год: 2024'"; //Либо можно сделать переменную и в цикле искать год, подставлять
                                                        // и для каждого года выводить фильмы и собрать это все в один тест
    private final SelenideElement marvelButton = $x("//a[@href=\"/xfsearch/podborki/Marvel/\"]");
    private final SelenideElement dropdownClick = $x("//button[@title='Год']");
    private final SelenideElement getYear = $x("//button[@title="+YEAR+"]");
    private final SelenideElement buttonEnter = $x("//button[text()='Применить']");



    //OpenSite
    public MainPage(String url){
        open(url);
    }

    //Click on subcategory marvel films
    public void clickToMarvelPage() throws InterruptedException {
        marvelButton.click();

        dropdownClick.click();
        getYear.click();
        buttonEnter.click();
        Thread.sleep(300);
    }

}
