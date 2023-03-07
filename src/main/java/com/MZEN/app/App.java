package com.MZEN.app;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;


public class App 
{
    public static void main( String[] args )
    {
         
        // Open Chrome
        System.setProperty("webdriver.chrome.driver", "resource/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/google-chrome-stable");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.khanacademy.org/");
        

        // Login button
        WebElement login = driver.findElement(By.id("login-or-signup"));
        login.click();


        // Wait for load
        System.out.println("Enterered Chrome mode.");
        try{
            Thread.sleep(500);
        }catch(Exception e) {}


        // Login
        WebElement input_user = driver.findElement(By.cssSelector("input[type='text']"));
        WebElement input_pass = driver.findElement(By.cssSelector("input[type='password']"));

        input_user.sendKeys(args[0]);
        input_pass.sendKeys(args[1]);

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

        System.out.println("Retrieved elements.");
        submitButton.click();
        

        // Keep trying to open assignments until crash
        while(true) {
            // Wait for load
            try{
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println("An error occured.");
            }

            // Do Assignment
            try{
                WebElement assignmentButton = driver.findElement(By.cssSelector("a[class='_qm98q6h']"));
                assignmentButton.click();

                // Wait for Assignment to Load
                try{
                    Thread.sleep(3000);
                } catch (Exception e) {System.out.println("An error occured.");}


                // Fetch video if exists.
                List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        

                // Check there is video
                if (iframes.size() > 0) {

                    //Open video and play.
                    WebElement play = driver.findElement(By.cssSelector("button[aria-label='Play video']"));
                    play.click();

                    List<WebElement> replays = driver.findElements(By.cssSelector("button[aria-label='Replay this video']"));
                    while(replays.size()<1) {
                            replays = driver.findElements(By.cssSelector("button[aria-label='Replay this video']"));
                            System.out.println(replays.size());
                            try{
                                Thread.sleep(5000);
                            }catch(Exception x) {}  
                    }

                } else {
                    // Scroll Down until hit end of page.
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    long currentHeight = (long) js.executeScript("return document.body.scrollHeight");
                    long newHeight = 0;
                    while (newHeight < currentHeight) {
                        currentHeight = newHeight;
                        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {e.printStackTrace();}
                        newHeight = (long) js.executeScript("return document.body.scrollHeight");
                    }
                }
            }catch(Exception x) {break;}
            driver.get("https://www.khanacademy.org/");
        }
        driver.quit();
    }
}
