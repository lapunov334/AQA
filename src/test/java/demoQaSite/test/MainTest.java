package demoQaSite.test;

import demoQaSite.pages.DragabblePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class MainTest {
    private final static String BASE_URL = "https://demoqa.com/";


    @Test
    @DisplayName("Проверка dragabble")
    public void CheckDragabblePage(){
        new DragabblePage(BASE_URL + "dragabble").MoveBlock();
    }


}