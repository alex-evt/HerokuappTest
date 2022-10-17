import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class InputsTest extends BrowserSetUp {
    private final String inputsPage = "http://the-internet.herokuapp.com/inputs";

    @Test
    public void verifyInputsTest() {

        SoftAssert softAssert = new SoftAssert();
        String emptyValue = "";
        String sixDigitValue = "586113";
        String specialSymbolValue = "!@#$";
        String latinValue = "asdfgh";
        String cyrillicValue = "ФЫВАП";
        String numberTwo = "2";
        String negativeNumberThree = "-3";

        driver.get(inputsPage);

        driver.findElement(By.tagName("input")).sendKeys(sixDigitValue);
        String enteredSixDigitValue = driver.findElement(By.xpath("//input[@type='number']")).getAttribute("value");
        softAssert.assertEquals(enteredSixDigitValue, sixDigitValue);
        driver.findElement(By.tagName("input")).clear();

        driver.findElement(By.tagName("input")).sendKeys(specialSymbolValue);
        String enteredSpecialSymbolValue = driver.findElement(By.xpath("//input[@type='number']")).getAttribute("value");
        softAssert.assertEquals(enteredSpecialSymbolValue, emptyValue);
        driver.findElement(By.tagName("input")).clear();

        driver.findElement(By.tagName("input")).sendKeys(latinValue);
        String enteredNonDigitValue = driver.findElement(By.xpath("//input[@type='number']")).getAttribute("value");
        softAssert.assertEquals(enteredNonDigitValue, emptyValue);
        driver.findElement(By.xpath("//input[@type='number']")).clear();

        driver.findElement(By.xpath("//input[@type='number']")).sendKeys(cyrillicValue);
        String enteredCyrillicValue = driver.findElement(By.xpath("//input[@type='number']")).getAttribute("value");
        softAssert.assertEquals(enteredCyrillicValue, emptyValue);
        driver.findElement(By.xpath("//input[@type='number']")).clear();

        driver.findElement(By.xpath("//input[@type='number']")).sendKeys(Keys.ARROW_UP);
        driver.findElement(By.xpath("//input[@type='number']")).sendKeys(Keys.ARROW_UP);
        String enteredNumberTwoViaArrowKeys = driver.findElement(By.xpath("//input[@type='number']")).getAttribute("value");
        softAssert.assertEquals(enteredNumberTwoViaArrowKeys, numberTwo);
        driver.findElement(By.xpath("//input[@type='number']")).clear();

        driver.findElement(By.xpath("//input[@type='number']")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//input[@type='number']")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//input[@type='number']")).sendKeys(Keys.ARROW_DOWN);
        String enteredNegativeNumberThreeViaArrowKeys = driver.findElement(By.xpath("//input[@type='number']")).getAttribute("value");
        softAssert.assertEquals(enteredNegativeNumberThreeViaArrowKeys, negativeNumberThree);

        softAssert.assertAll();
    }
}
