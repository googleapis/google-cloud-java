/*
 * Copyright 2017 Google Inc.
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

package com.example.dlp;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
// CHECKSTYLE OFF: AbbreviationAsWordInName
public class DeIdentificationIT {

  // CHECKSTYLE ON: AbbreviationAsWordInName
  private ByteArrayOutputStream bout;
  private PrintStream out;

  // Update to wrapped local encryption key
  private String wrappedKey = System.getenv("DLP_DEID_WRAPPED_KEY");

  // Update to name of KMS key used to wrap local encryption key
  private String keyName = System.getenv("DLP_DEID_KEY_NAME");

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
    assertNotNull(System.getenv("GOOGLE_APPLICATION_CREDENTIALS"));
    assertNotNull(System.getenv("DLP_DEID_WRAPPED_KEY"));
    assertNotNull(System.getenv("DLP_DEID_KEY_NAME"));
  }

  @Test
  public void testDeidReplaceWithInfoType() throws Exception {
    String text = "\"My SSN is 372819127\"";
    DeIdentification.main(
        new String[] {
          "-it", text,
          "-infoTypes", "US_SOCIAL_SECURITY_NUMBER"
        });
    String output = bout.toString();
    assertThat(output, containsString("My SSN is [US_SOCIAL_SECURITY_NUMBER]"));
  }

  @Test
  public void testDeidStringMasksCharacters() throws Exception {
    String text = "\"My SSN is 372819127\"";
    DeIdentification.main(
        new String[] {
          "-m", text,
          "-infoTypes", "US_SOCIAL_SECURITY_NUMBER",
          "-maskingCharacter", "x",
          "-numberToMask", "5"
        });
    String output = bout.toString();
    assertThat(output, containsString("My SSN is xxxxx9127"));
  }

  @Test
  public void testDeidReidFpe() throws Exception {

    // Test DeID
    String text = "My SSN is 372819127";
    DeIdentification.main(
        new String[] {
          "-f",
          "\"" + text + "\"",
          "-infoTypes",
          "US_SOCIAL_SECURITY_NUMBER",
          "-wrappedKey",
          wrappedKey,
          "-keyName",
          keyName,
          "-commonAlphabet",
          "NUMERIC",
          "-surrogateType",
          "SSN_TOKEN"
        });
    String deidOutput = bout.toString();
    assertFalse("Response contains original SSN.", deidOutput.contains("372819127"));
    assertTrue(deidOutput.matches("My SSN is SSN_TOKEN\\(9\\):\\d+\n"));

    // Test ReID
    bout.flush();
    DeIdentification.main(
        new String[] {
          "-r",
          deidOutput.toString().trim(),
          "-wrappedKey",
          wrappedKey,
          "-keyName",
          keyName,
          "-commonAlphabet",
          "NUMERIC",
          "-surrogateType",
          "SSN_TOKEN"
        });
    String reidOutput = bout.toString();
    assertThat(reidOutput, containsString(text));
  }

  @Test
  public void testDeidentifyWithDateShift() throws Exception {
    String outputPath = "src/test/resources/results.temp.csv";
    DeIdentification.main(
        new String[] {
          "-d",
          "-inputCsvPath",
          "src/test/resources/dates.csv",
          "-outputCsvPath",
          outputPath,
          "-dateFields",
          "birth_date,register_date",
          "-lowerBoundDays",
          "5",
          "-upperBoundDays",
          "5",
          "-contextField",
          "name",
          "-wrappedKey",
          wrappedKey,
          "-keyName",
          keyName
        });
    String output = bout.toString();
    assertThat(output, containsString("Successfully saved date-shift output to: results.temp.csv"));

    // Compare the result against an expected output file
    byte[] resultCsv = Files.readAllBytes(Paths.get(outputPath));
    byte[] correctCsv = Files.readAllBytes(Paths.get("src/test/resources/results.correct.csv"));

    assertTrue(Arrays.equals(resultCsv, correctCsv));
  }

  @After
  public void tearDown() {
    System.setOut(null);
    bout.reset();
  }
}
