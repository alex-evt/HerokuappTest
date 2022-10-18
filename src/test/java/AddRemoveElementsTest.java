import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRemoveElementsTest extends BrowserSetUp {

    @Test(description = "Добавить 2 элемента, удалить элемент, проверить количество элементов")
    public void verifyAddRemoveElementsTest() {
        String addRemovePage = "http://the-internet.herokuapp.com/add_remove_elements/";

        driver.get(addRemovePage);
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        int actualButtonsNumber = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        Assert.assertEquals(actualButtonsNumber, 1);
    }
}
