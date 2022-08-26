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

public class PredictTextEntityExtractionSampleTest {

  private static final String PROJECT = System.getenv("UCAIP_PROJECT_ID");
  private static final String TEXT_CONTENT =
      "1127526\\tAnalbuminemia in a neonate.\\tA small-for-gestational-age infant , found to have"
          + " analbuminemia in the neonatal period , is reported and the twelve cases recorded in"
          + " the world literature are reviewed . Patients lacking this serum protein are"
          + " essentially asymptomatic , apart from minimal ankle edema and ease of fatigue ."
          + " Apparent compensatory mechanisms which come into play when serum albumin is low"
          + " include prolonged half-life of albumin and transferrin , an increase in serum"
          + " globulins , beta lipoprotein , and glycoproteins , arterial hypotension with reduced"
          + " capillary hydrostatic pressure , and the ability to respond with rapid sodium and"
          + " chloride diuresis in response to small volume changes . Examination of plasma amino"
          + " acids , an investigation not previously reported , revealed an extremely low plasma"
          + " tryptophan level , a finding which may be important in view of the role of"
          + " tryptophan in albumin synthesis.";
  private static final String ENDPOINT_ID = System.getenv("TEXT_ENTITY_ENDPOINT_ID");
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
    requireEnvVar("TEXT_ENTITY_ENDPOINT_ID");
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
  public void testPredictTextEntityExtraction() throws IOException {
    // Act
    PredictTextEntityExtractionSample.predictTextEntityExtraction(
        PROJECT, TEXT_CONTENT, ENDPOINT_ID);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("Predict Text Entity Extraction Response");
  }
}
