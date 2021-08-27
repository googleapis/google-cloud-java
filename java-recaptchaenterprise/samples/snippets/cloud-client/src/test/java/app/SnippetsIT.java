/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SnippetsIT {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String DOMAIN_NAME = "localhost";
  private static String RECAPTCHA_SITE_KEY_1 = "recaptcha-site-key1";
  private static String RECAPTCHA_SITE_KEY_2 = "recaptcha-site-key2";
  private static WebDriver browser;
  @LocalServerPort private int randomServerPort;
  private ByteArrayOutputStream stdOut;

  // Check if the required environment variables are set.
  public static void requireEnvVar(String envVarName) {
    assertWithMessage(String.format("Missing environment variable '%s' ", envVarName))
        .that(System.getenv(envVarName))
        .isNotEmpty();
  }

  @BeforeClass
  public static void setUp() throws IOException, InterruptedException {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("GOOGLE_CLOUD_PROJECT");

    // Create reCAPTCHA Site key and associate the given domain.
    RECAPTCHA_SITE_KEY_1 = recaptcha.CreateSiteKey.createSiteKey(PROJECT_ID, DOMAIN_NAME);
    RECAPTCHA_SITE_KEY_2 = recaptcha.CreateSiteKey.createSiteKey(PROJECT_ID, DOMAIN_NAME);
    TimeUnit.SECONDS.sleep(5);

    // Set Selenium Driver to Chrome.
    WebDriverManager.chromedriver().setup();
    browser = new ChromeDriver();
  }

  @AfterClass
  public static void cleanUp()
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    ByteArrayOutputStream stdOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdOut));

    recaptcha.DeleteSiteKey.deleteSiteKey(PROJECT_ID, RECAPTCHA_SITE_KEY_1);
    assertThat(stdOut.toString()).contains("reCAPTCHA Site key successfully deleted !");

    browser.quit();

    stdOut.close();
    System.setOut(null);
  }

  @Before
  public void beforeEach() {
    stdOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdOut));
  }

  @After
  public void afterEach() {
    stdOut = null;
    System.setOut(null);
  }

  @Test
  public void testCreateSiteKey() {
    // Test if the recaptcha site key has already been successfully created, as part of the setup.
    Assert.assertFalse(RECAPTCHA_SITE_KEY_1.isEmpty());
  }

  @Test
  public void testGetKey()
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    recaptcha.GetSiteKey.getSiteKey(PROJECT_ID, RECAPTCHA_SITE_KEY_1);
    assertThat(stdOut.toString()).contains(RECAPTCHA_SITE_KEY_1);
  }

  @Test
  public void testListSiteKeys() throws IOException {
    recaptcha.ListSiteKeys.listSiteKeys(PROJECT_ID);
    assertThat(stdOut.toString()).contains(RECAPTCHA_SITE_KEY_1);
  }

  @Test
  public void testUpdateSiteKey()
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    recaptcha.UpdateSiteKey.updateSiteKey(PROJECT_ID, RECAPTCHA_SITE_KEY_1, DOMAIN_NAME);
    assertThat(stdOut.toString()).contains("reCAPTCHA Site key successfully updated !");
  }

  @Test
  public void testDeleteSiteKey()
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    recaptcha.DeleteSiteKey.deleteSiteKey(PROJECT_ID, RECAPTCHA_SITE_KEY_2);
    assertThat(stdOut.toString()).contains("reCAPTCHA Site key successfully deleted !");
  }

  @Test
  public void testCreateAssessment() throws IOException, JSONException, InterruptedException {
    // Construct the URL to call for validating the assessment.
    String assessURL = "http://localhost:" + randomServerPort + "/";
    URI url =
        UriComponentsBuilder.fromUriString(assessURL)
            .queryParam("recaptchaSiteKey", RECAPTCHA_SITE_KEY_1)
            .build()
            .encode()
            .toUri();

    browser.get(url.toURL().toString());

    // Wait until the page is loaded.
    JavascriptExecutor js = (JavascriptExecutor) browser;
    new WebDriverWait(browser, 10)
        .until(webDriver -> js.executeScript("return document.readyState").equals("complete"));

    // Pass the values to be entered.
    browser.findElement(By.id("username")).sendKeys("username");
    browser.findElement(By.id("password")).sendKeys("password");

    // On clicking the button, the request params will be sent to reCAPTCHA.
    browser.findElement(By.id("recaptchabutton")).click();

    TimeUnit.SECONDS.sleep(1);

    // Retrieve the reCAPTCHA token response.
    WebElement element = browser.findElement(By.cssSelector("#assessment"));
    String token = element.getAttribute("data-token");
    String action = element.getAttribute("data-action");

    // The obtained token must be further analyzed to get the score.
    float recaptchaScore = assessToken(token, action);

    // Set the score.
    browser.findElement(By.cssSelector("#assessment")).sendKeys(String.valueOf(recaptchaScore));
    return;
  }

  public float assessToken(String token, String action) throws IOException {
    // Send the token for analysis. The analysis score ranges from 0.0 to 1.0
    recaptcha.CreateAssessment.createAssessment(PROJECT_ID, RECAPTCHA_SITE_KEY_1, token, action);
    String response = stdOut.toString();
    assertThat(response).contains("The reCAPTCHA score is: ");
    float recaptchaScore =
        Float.parseFloat(response.substring(response.lastIndexOf(":") + 1).trim());
    return recaptchaScore;
  }
}
