package demoShop.tests;

import demoShop.pages.LoginPage;
import demoShop.pages.PlacingOrderPage;
import demoShop.pages.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class SauceDemoTest {
    private final static String URL = "https://www.saucedemo.com/";
    private final static int COUNT_CARD_SHOP = 4;
    private final static String completeOrder = "Thank you for your order!";

    @BeforeEach
    public void baseLog(){
       new LoginPage(URL).authorization();
       $x("//body").shouldBe(visible);
    }

    @Test
    @DisplayName("Проверка сортировки в обе стороны")
    public void checkSorted(){

       ProductsPage productsPage = new ProductsPage();
       List<Double> list = productsPage.getListCards(); //лежат карточку в произвольном порядке
       Collections.sort(list);
       Assertions.assertEquals(list,productsPage.checkSortedLowToHigh()); // Проверяем 2 листа сортированных по возрастанию
       //////////////////////////////////////////////
       Collections.sort(list, Comparator.reverseOrder());
       Assertions.assertEquals(list,productsPage.checkSortedHighToLow()); // Проверяем 2 листа сортированных по убыванию
    }


    @Test
    @DisplayName("Проверка оформления заказа")
    public void checkOrderPlaced(){
        new ProductsPage().addCardOnBasketStore(COUNT_CARD_SHOP);
        PlacingOrderPage placingOrderPage = new PlacingOrderPage();
        Assertions.assertEquals(completeOrder,placingOrderPage.orderCheck());
    }

}
