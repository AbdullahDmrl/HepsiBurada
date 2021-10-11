package Pages;


import Utils.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class Parent {

    public void sendKeysFunction(WebElement element, String value)
    {
        waitUntilVisible(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(value);
    }
    public void clickFunction(WebElement element)
    {
        waitUntilClickable(element);
        scrollToElement(element);
        element.click();
    }
    public static void waitUntilVisible(WebElement element){
        WebDriverWait wait=new WebDriverWait(BaseDriver.getDriver(),20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitUntilClickable(WebElement element){
        WebDriverWait wait=new WebDriverWait(BaseDriver.getDriver(),20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public void scrollToElement(WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) BaseDriver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public void scrollToUpElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) BaseDriver.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'top:0px')", element);
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitVisibleListAllElement(List<WebElement> elementList){
        WebDriverWait wait=new WebDriverWait(BaseDriver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
    }

    public void verifyContainsText(WebElement element, String msg)
    {
        waitUntilVisible(element);
        Assert.assertTrue(element.getText().toLowerCase().contains(msg.toLowerCase()));
    }

    public void verifyContainsWebelement(List<WebElement> elements, String text)
    {
        waitVisibleListAllElement(elements);

        boolean istListAdded=false;
        for (WebElement e:elements){
            if (e.getText().contains(text)){
                istListAdded=true;
                Assert.assertTrue(istListAdded);break;
            }
            else
                Assert.fail();
        }
    }

    public void clickSelectedElement(List<WebElement> elements, String text)
    {
        waitVisibleListAllElement(elements);
      for (WebElement e:elements){
          if (e.getText().contains(text))
              e.click();break;
      }

    }

    public void delWebelement(List<WebElement> elements,List<WebElement> kaldirBtns, String text)
    {
        waitVisibleListAllElement(elements);

        for (int i = 0; i < elements.size(); i++) {
            for (int j = 0; j <kaldirBtns.size() ; j++) {
                if (elements.get(i).getText().contains(text))
                    kaldirBtns.get(j).click(); break;
            }
        }
    }

    public static void ActionHoverFunction(WebElement element)
    {
        Actions aksiyonlar=new Actions(BaseDriver.driver);
        Action action=aksiyonlar.moveToElement(element).build(); action.perform();
    }



    public static void waitUntilInvisibility(WebElement element){
        WebDriverWait wait =new WebDriverWait(BaseDriver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }


    public void waitnumberOfElementsToBeLessThan(By selector, int number)
    {
        WebDriverWait wait=new WebDriverWait(BaseDriver.getDriver(),20);
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(selector,number));
    }

    public void waitprecenceOfElementsLocatedBy(By selector)
    {
        WebDriverWait wait=new WebDriverWait(BaseDriver.getDriver(),20);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector));
    }

    public void waitStalenessofElement(WebElement element)
    {
        WebDriverWait wait=new WebDriverWait(BaseDriver.getDriver(),20);
        wait.until(ExpectedConditions.stalenessOf(element));
    }


    public void ESCClick()
    {
        try {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ESCAPE);
            r.keyRelease(KeyEvent.VK_ESCAPE);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }


    public static void scrollFunction()
    {
        JavascriptExecutor js= (JavascriptExecutor)BaseDriver.getDriver();
        // js.executeScript("window.scrollBy(0,1500)");
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public void selectFunction(WebElement element,String text)
    {
        Select select=new Select(element);
        select.selectByVisibleText(text);
        // select.selectByValue(text);
    }

    public static void delay(int second)
    {
        try {
            Thread.sleep(1000*second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
