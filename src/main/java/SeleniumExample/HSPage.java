package SeleniumExample;

import HS.Card;
import HS.ColumnType;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static HS.ColumnType.find;

/**
 * Created by Николай on 08.08.2016.
 */
public class HSPage {
    WebDriver webDriver;

    public HSPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public List<Card> search() {
        webDriver.get("http://ru.hearthhead.com/cards");
        webDriver.findElement(By.linkText("Хорошо, все понятно")).click();
        webDriver.findElement(By.cssSelector("a[href*='#text']")).click();
        //listview-mode-default
        List<Card> cards = new ArrayList<Card>();
        getCards(webDriver, cards);

        WebElement element;
        element = getNextWebElement();

        while (element != null) {
            element.click();
            getCards(webDriver, cards);
        }
        System.out.print(cards.size());
        return cards;

    }

    private WebElement getNextWebElement() {
        WebElement element;
        try {
            element = webDriver.findElement(By.linkText("Далее ›"));
        } catch (NoSuchElementException e) {
            element = null;
        }
        return element;
    }

    private List<Card> getCards(WebDriver webDriver, List<Card> cards) {
        WebElement table_element = webDriver.findElement(By.className("listview-mode-default"));
        List<WebElement> tr_collection = table_element.findElements(By.xpath("tbody/tr"));

        int row_num;
        int col_num;
        row_num = 1;
        for (WebElement trElement : tr_collection) {
            List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
            col_num = 1;
            Card.CardBuilder builder = new Card.CardBuilder();
            for (WebElement tdElement : td_collection) {
                ColumnType columnType = find(col_num);
                if (columnType != null) {
                    switch (columnType) {
                        case ATTACK:
                            String attack = tdElement.getText();
                            if (!attack.equals("")) {
                                builder.setAttack(Integer.valueOf(tdElement.getText()));
                            }
                            break;
                        case REDCOST:
                            String redkost = tdElement.findElement(By.tagName("span")).getAttribute("class");
                            builder.setRedkost(redkost);
                            break;
                        case PACK_TYPE:
                            String pack = getStringByClassNameWithoutException(tdElement, "q0");
                            builder.setPack(pack);
                            String type = getStringByClassNameWithoutException(tdElement, "q1");
                            builder.setType(type);
                            break;
                        case NAME_TEXT:

                            String name = getStringByClassNameWithoutException(tdElement, "listview-cleartext");
                            builder.setName(name);
                            String description = getStringByClassNameWithoutException(tdElement, "listview-blurb");
                            builder.setDescription(description);
                            break;
                        case POPULAR:
                            builder.setPopular(Integer.valueOf(tdElement.getText()));
                            break;
                        case NATION:
                            builder.setNation(tdElement.getText());
                            break;
                        case HEALTH:
                            String health = tdElement.getText();
                            if (!health.equals("")) {
                            builder.setHealth(Integer.valueOf(health));}
                            break;
                        case GAME_CLASS:
                            builder.setGameClass(tdElement.getText());
                            break;
                        case COST:
                            builder.setCost(Integer.valueOf(tdElement.getText()));
                            break;
                    }
                }
                System.out.println("row # " + row_num + ", col # " + columnType + " text=" + tdElement.getText());
                col_num++;
            }
            row_num++;
            cards.add(builder.build());
        }
        return cards;
    }

    private String getStringByClassNameWithoutException(WebElement element, String className) {
        try {
            return element.findElement(By.className(className)).getText();
        } catch (NoSuchElementException e) {
        }
        return null;
    }
}
