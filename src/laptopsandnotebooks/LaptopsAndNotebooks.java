package laptopsandnotebooks;

import com.google.common.base.Verify;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utility.Utility;

public class LaptopsAndNotebooks extends Utility {
    String baseurl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        Actions actions = new Actions(driver);
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        WebElement LaptopsNotebooks = driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        actions.moveToElement(LaptopsNotebooks).click().build().perform();
        //1.2 Click on “Show All Laptops & Notebooks”
        clickONElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));
        //1.3 Select Sort By "Price (High > Low)"
        Select obj = new Select(driver.findElement(By.xpath("//select[@id='input-sort']")));
        obj.selectByIndex(4);
        //1.4 Verify the Product price will arrange in High to Low order.
         verifyTextFromElements(By.xpath("//option[contains(text(),'Price (High > Low)')]"),"Price (High > Low)");
    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        Thread.sleep(500);
        Actions actions = new Actions(driver);
        //2.1 Mouse hover on Laptops & Notebooks Tab.and click
        WebElement LaptopsNotebooks = driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        actions.moveToElement(LaptopsNotebooks).click().build().perform();
        //2.2 Click on “Show All Laptops & Notebooks”
        Thread.sleep(1500);
        clickONElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));
        //2.3 Select Sort By "Price (High > Low)"
        Select obj = new Select(driver.findElement(By.xpath("//select[@id='input-sort']")));
        obj.selectByIndex(4);
        //2.4 Select Product “MacBook”
       clickONElement(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[4]/div[1]/div[2]/div[1]/h4[1]/a[1]"));
        //2.5 Verify the text “MacBook”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'MacBook')]"),"MacBook");
        //2.6 Click on ‘Add To Cart’ button
        clickONElement(By.xpath("//button[@id='button-cart']"));
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        verifyTextFromElements(By.xpath("//div[@class='alert alert-success alert-dismissible']"),"Success: You have added MacBook to your shopping cart!\n" +
                "×");
        Thread.sleep(1500);
        //2.8 Click on link “shopping cart” display into success message
        clickONElement(By.xpath("//span[contains(text(),'Shopping Cart')]"));
        //2.9 Verify the text "Shopping Cart"
       verifyTextFromElements(By.xpath("//h1[contains(text(),' (0.00kg)')]"),"Shopping Cart  (0.00kg)");
       //2.10 Verify the Product name "MacBook"
       verifyTextFromElements(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"),"MacBook");
        //2.11 Change Quantity "2"
        clearTest(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"));
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"),"2");
        //2.12 Click on “Update” Tab
        clickONElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]/i[1]"));
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        verifyTextFromElements(By.xpath("//body/div[@id='checkout-cart']/div[1]"),"Success: You have modified your shopping cart!\n" +
                "×");
        //2.14 Verify the Total £737.45
        verifyTextFromElements(By.xpath("//tbody/tr[1]/td[6]"),"$1,204.00");
        //2.15 Click on “Checkout” button
        clickONElement(By.xpath("//a[contains(text(),'Checkout')]"));
        //2.16 Verify the text “Checkout”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Checkout')]"),"Checkout");
        //2.17 Verify the Text “New Customer”
        verifyTextFromElements(By.xpath("//h2[contains(text(),'New Customer')]"),"New Customer");

        // verifyTextFromElements(By.xpath("//h2[contains(text(),'New Customer')]"),"New Customer");
        //2.18 Click on “Guest Checkout” radio button
        clickONElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]/input[1]"));
        //2.19 Click on “Continue” tab
        Thread.sleep(1500);
        clickONElement(By.xpath("//input[@id='button-account']"));
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"),"kishan");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"),"malaviya");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"),"kishan_0250@yahoo.co.in");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"),"07534994680");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"),"115a");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"),"london");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"),"kt3 5pd");
       clickONElement(By.xpath("//option[contains(text(),'Pakistan')]"));
       clickONElement(By.xpath("//option[contains(text(),'Punjab')]"));
       clickONElement(By.xpath("//input[@id='button-guest']"));
       //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/p[2]/textarea[1]"),"I need delivery after 5:00pm");
        //2.23 Check the Terms & Conditions check box
        Thread.sleep(1500);
        //2.24
        clickONElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/input[1]"));
        // Success: You have modified your shopping cart!
        clickONElement(By.xpath("//input[@id='button-payment-method']"));
        //2.25 Verify the message “Warning: Payment method required!”
        //verifyTextFromElements(By.xpath("//div[@class='alert alert-success alert-dismissible']/child::i"),"Warning: Payment method required!");













    }

}