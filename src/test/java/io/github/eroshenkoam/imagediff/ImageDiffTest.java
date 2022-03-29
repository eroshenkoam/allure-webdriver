package io.github.eroshenkoam.imagediff;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

@ExtendWith(SeleniumJupiter.class)
public class ImageDiffTest {

    @Test
    public void testGitHub(final ChromeDriver driver) throws IOException {
        driver.get("https://github.com");

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        BufferedImage actualImage = ImageIO.read(screenshotFile);
        BufferedImage expectedImage = ImageComparisonUtil.readImageFromResources("github.png");
        File diffImagePath = Files.createTempFile("diff", "png").toFile();

        ImageComparisonResult result = new ImageComparison(expectedImage, actualImage, diffImagePath).compareImages();

        ImageDiff imageDiff = new ImageDiff();
        imageDiff.setExpected(toBase64(result.getExpected()));
        imageDiff.setActual(toBase64(result.getActual()));
        imageDiff.setDiff(toBase64(result.getResult()));

        String json = new ObjectMapper().writeValueAsString(imageDiff);

        Allure.addAttachment("ImageDiff", "application/vnd.allure.image.diff", json, "imagediff");
    }

    public static String toBase64(final BufferedImage img) {
        final ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ImageIO.write(img, "png", os);
            return String.format("data:image/png;base64, %s", Base64.getEncoder().encodeToString(os.toByteArray()));
        } catch (final IOException ioe) {
            throw new UncheckedIOException(ioe);
        }
    }

}
