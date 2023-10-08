import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Alpieieva_HW10 extends BaseTestClass{

    @Test(dataProvider = "dataProviderFrames")
    public void switchToFrameMethod(String frameMain, String subFrame, String text) {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        if (!frameMain.equals("")) {
            driver.switchTo().frame(frameMain);
        }

        driver.switchTo().frame(subFrame);
        String body = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(body, text);

        driver.switchTo().defaultContent();

        Assert.assertEquals(driver.findElements(By.xpath("//frameset/frame")).size(), 2);
    }

    @DataProvider
    public Object[] dataProviderFrames () {
        return new Object[][] {
                {"frame-top", "frame-left", "LEFT"},
                {"frame-top", "frame-middle", "MIDDLE"},
                {"frame-top", "frame-right", "RIGHT"},
                {"", "frame-bottom", "BOTTOM"}
        };
    }
}
