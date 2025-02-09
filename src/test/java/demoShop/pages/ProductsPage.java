package demoShop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import demoShop.utils.Credentials;


import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;


public class ProductsPage {

    private final ElementsCollection productCards = $$x("//div[@class=\"inventory_item_price\"]");
    private final SelenideElement dropdownMenu = $x("//select[@class=\"product_sort_container\"]");

    private final ElementsCollection buttonImgCard = $$x("//div[@class=\"inventory_item_img\"]");
    private final SelenideElement buttonAddCard = $x("//button[@id='add-to-cart']");



    public List<Double> getListCards(){
        List<Double> cardList = new ArrayList<>();

        for(SelenideElement elements : productCards ){
            String onlyPrice = elements.getText().replaceAll("[^\\d.]", "");

            cardList.add(Double.parseDouble(onlyPrice));
        }
        return cardList;
    }

    public List<Double> checkSortedLowToHigh(){
        dropdownMenu.selectOption(Credentials.PRICE_L_TO_H);
        return getListCards();
    }

    public List<Double> checkSortedHighToLow(){
        dropdownMenu.selectOption(Credentials.PRICE_H_TO_L);
        return getListCards();
    }

    public void addCardOnBasketStore(int amountCardAdd){  //amountCardAdd - значение которое передаем вначале теста (кол-во карточек для добавления в корзину)
        for (int i = 0; i < amountCardAdd; i++) {
            buttonImgCard.get(i).click();
            buttonAddCard.click();
            back();
            int id = 0;
        }
    }



}
