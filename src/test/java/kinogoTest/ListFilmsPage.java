package kinogoTest;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$$x;



public class ListFilmsPage {

    private final ElementsCollection getFilms = $$x("//div[@class='shortstory__title']/a");


    public Map<String,String> getListFilms(){
        Map<String, String> mapFilms = new HashMap<>();

        for(SelenideElement element : getFilms ){
            mapFilms.put(element.getText(),element.getAttribute("href"));
        }
        return mapFilms;
    }

}
