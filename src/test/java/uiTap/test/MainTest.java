package uiTap.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uiTap.pages.HiddenLayers;
import uiTap.pages.ProgressBar;

public class MainTest {

    public static final String URL = "http://uitestingplayground.com/";

    @Test
    @DisplayName("Проверка нажатия кнопки")
    public void CheckHiddenLayers(){
        HiddenLayers hiddenLayers = new HiddenLayers(URL + "hiddenlayers");
        boolean checkNonClickButton = hiddenLayers.CheckButton(); //фолс потому что кнопка не нажата
        boolean checkClickButton = hiddenLayers.CheckClickButton(); //тру потому что кнопка нажата

        Assertions.assertEquals(checkNonClickButton,checkClickButton);
    }

    @Test
    @DisplayName("Отслеживание и остановка бара на текущем проценте")
    public void CheckProgressBar(){
        String percent = "30%";
        ProgressBar progressBar = new ProgressBar(URL + "progressbar");
        String percentBar = progressBar.WaitProgress(percent);

        Assertions.assertEquals(percent,percentBar);
    }
}
