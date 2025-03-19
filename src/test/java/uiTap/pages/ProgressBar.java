package uiTap.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class ProgressBar {

    private final SelenideElement buttonStart = $x("//button[@id='startButton']");
    private final SelenideElement buttonStop = $x("//button[@id='stopButton']");


    public ProgressBar(String url) {
        open(url);
    }

    public String WaitProgress(String percent){
        String percentActual;
        buttonStart.click();
        while(true){
            SelenideElement progressBar = $x("//div[@id='progressBar']");
            if(progressBar.text().equals(percent)){
                buttonStop.click();
                percentActual = progressBar.text();
                break;
            }
        }
        return percentActual;
    }


}
