/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package aiplatform;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PredictTextSentimentAnalysisSampleTest {

  private static final String PROJECT = System.getenv("UCAIP_PROJECT_ID");
  private static final String TEXT_CONTENT =
      "I was excited at the concept of my favorite comic book hero being on television... and"
          + " sorely disappointed at the end result.<br /><br />The only amazing thing was the"
          + " wall crawling (despite the visibility of the cable). I didn't think Nick Hammond was"
          + " Peter Parker... and he was visibly of a different build than the guy who did the"
          + " stunts in the spider suit. You could tell they were two different actors.<br /><br"
          + " />Granted, I can also spot in the modern Spider-Man movies when I am looking at"
          + " Tobey Macguire and when I am looking at CGI. But that is from a trained eye and"
          + " experience working with CGI. Still, the 70's version could have been better despite"
          + " lack of Special FX.<br /><br />The webs were hokey and looked like ropes that seemed"
          + " to wrap around things rather than stick to them. And what was up with giving him a"
          + " spider mobile to ride around in. Hello? He's the web slinger people.<br /><br"
          + " />Sorry... didn't mean to get so worked up, but our beloved wall crawler deserved"
          + " better.";
  private static final String ENDPOINT_ID = System.getenv("TEXT_SENTI_ENDPOINT_ID");
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  private static void requireEnvVar(String varName) {
    String errorMessage =
        String.format("Environment variable '%s' is required to perform these tests.", varName);
    assertNotNull(errorMessage, System.getenv(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("UCAIP_PROJECT_ID");
    requireEnvVar("TEXT_SENTI_ENDPOINT_ID");
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown() {
    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  public void testPredictTextSentimentAnalysis() throws IOException {
    // Act
    PredictTextSentimentAnalysisSample.predictTextSentimentAnalysis(
        PROJECT, TEXT_CONTENT, ENDPOINT_ID);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("Predict Text Sentiment Analysis Response");
  }
}
