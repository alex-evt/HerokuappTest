import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TyposTest extends BrowserSetUp{
    private final String typosPage = "http://the-internet.herokuapp.com/typos";
    private final String correctText = "Sometimes you'll see a typo, other times you won't.";

    @Test(description = "Проверить соответствие параграфа орфографии")
    public void verifyTypoSecondParagraphTest(){
        driver.get(typosPage);
        String actualText = driver.findElement(By.xpath("//*[contains(text(), 'other times you')]")).getText();
        Assert.assertEquals(actualText, correctText);
    }
}
