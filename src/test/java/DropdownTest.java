import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class DropdownTest extends BrowserSetUp {

    private final String dropdownPage = "http://the-internet.herokuapp.com/dropdown";

    @Test(priority = 1, description = "Взять все элементы дроп-дауна и проверить их наличие")
    public void verifyDropdownExistenceTest() {
        SoftAssert softAssertDropdownPresent = new SoftAssert();
        driver.get(dropdownPage);
        Select dropdownList = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        List<WebElement> optionsList = dropdownList.getOptions();
        softAssertDropdownPresent.assertEquals(optionsList.get(0).isDisplayed(), true);
        softAssertDropdownPresent.assertEquals(optionsList.get(1).isDisplayed(), true);
        softAssertDropdownPresent.assertEquals(optionsList.get(2).isDisplayed(), true);

        softAssertDropdownPresent.assertEquals(optionsList.get(0).getText(), "Please select an option");
        softAssertDropdownPresent.assertEquals(optionsList.get(1).getText(), "Option 1");
        softAssertDropdownPresent.assertEquals(optionsList.get(2).getText(), "Option 2");
        softAssertDropdownPresent.assertAll();

    }

    @Test(priority = 2, description = "Выбрать первый элемент из выпадающего списка, проверить, что он выбран, выбрать второй, проверить, что он выбран")
    public void verifyDropdownOptionSelectionTest() {
        SoftAssert softAssertDropdownSelection = new SoftAssert();
        driver.get(dropdownPage);
        Select dropdownList = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        dropdownList.selectByVisibleText("Option 1");
        boolean firstOption = dropdownList.getOptions().get(1).isSelected();
        softAssertDropdownSelection.assertEquals(firstOption, true, "First option not selected");

        dropdownList.selectByVisibleText("Option 2");
        boolean secondOption = dropdownList.getOptions().get(2).isSelected();
        softAssertDropdownSelection.assertEquals(secondOption, true, "Second option not selected");

        softAssertDropdownSelection.assertAll();
    }
}