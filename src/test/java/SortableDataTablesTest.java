import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SortableDataTablesTest extends BrowserSetUp {
    private final String dataTablesPage = "http://the-internet.herokuapp.com/tables";
    private String correctValueRow1Cell1 = "Smith";
    private String correctValueRow1Cell2 = "John";
    private String correctValueRow1Cell3 = "jsmith@gmail.com";
    private String correctValueRow2Cell4 = "$51.00";
    private String correctValueRow3Cell3 = "jdoe@hotmail.com";


    @Test(description = "Проверить содержимое нескольких (3-5) ячеек таблицы")
    public void verifyFirstTableValues() {

        driver.get(dataTablesPage);
        SoftAssert softAssert = new SoftAssert();

        String actualValueRow1Cell1 = driver.findElement(By.xpath("//table[@id='table1']//tr[1]//td[1]")).getText();
        String actualValueRow1Cell2 = driver.findElement(By.xpath("//table[@id='table1']//tr[1]//td[2]")).getText();
        String actualValueRow1Cell3 = driver.findElement(By.xpath("//table[@id='table1']//tr[1]//td[3]")).getText();
        String actualValueRow2Cell4 = driver.findElement(By.xpath("//table[@id='table1']//tr[2]//td[4]")).getText();
        String actualValueRow3Cell3 = driver.findElement(By.xpath("//table[@id='table1']//tr[3]//td[3]")).getText();

        softAssert.assertEquals(actualValueRow1Cell1, correctValueRow1Cell1);
        softAssert.assertEquals(actualValueRow1Cell2, correctValueRow1Cell2);
        softAssert.assertEquals(actualValueRow1Cell3, correctValueRow1Cell3);
        softAssert.assertEquals(actualValueRow2Cell4, correctValueRow2Cell4);
        softAssert.assertEquals(actualValueRow3Cell3, correctValueRow3Cell3);

        softAssert.assertAll();
    }
}
