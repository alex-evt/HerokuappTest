import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest extends BrowserSetUp {

    private final String checkboxesPage = "http://the-internet.herokuapp.com/checkboxes";

    @Test(priority = 1, description = "Проверить, что первый чекбокс unchecked")
    public void verifyFirstCheckboxUncheckedTest() {
        driver.get(checkboxesPage);
        boolean firstCheckbox = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).isSelected();
        Assert.assertEquals(firstCheckbox, false);
    }

    @Test(priority = 2, description = "Отметить первый чекбокс, проверить что он checked")
    public void verifyFirstCheckboxCheckedTest() {
        driver.get(checkboxesPage);
        driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).click();
        boolean firstCheckbox = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).isSelected();
        Assert.assertEquals(firstCheckbox, true);
    }

    @Test(priority = 3, description = "Проверить, что второй чекбокс checked")
    public void verifySecondCheckboxCheckedTest() {
        driver.get(checkboxesPage);
        boolean secondCheckbox = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).isSelected();
        Assert.assertEquals(secondCheckbox, true);
    }

    @Test(priority = 4, description = "Сделать uncheck второго чекбокса и проверить, что он unchecked")
    public void verifySecondCheckboxUncheckedTest() {
        driver.get(checkboxesPage);
        driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).click();
        boolean secondCheckbox = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).isSelected();
        Assert.assertEquals(secondCheckbox, false);
    }
}
