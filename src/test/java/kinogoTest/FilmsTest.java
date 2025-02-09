package kinogoTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;


public class FilmsTest {

    private final static String BASE_URL = "https://kinogo.ec/";

    @Test
    @DisplayName("Будет выведен список фильмов которые вышли в каждом из годов")
    public void getMarvelsFilms() throws InterruptedException {

        new MainPage(BASE_URL).clickToMarvelPage();

        ListFilmsPage listFilmsPage = new ListFilmsPage();

        Map<String,String> mapFilms = listFilmsPage.getListFilms();
        System.out.println(mapFilms);

    }
}
