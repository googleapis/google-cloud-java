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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
// CHECKSTYLE OFF: AbbreviationAsWordInName
public class RiskAnalysisIT {

  // CHECKSTYLE ON: AbbreviationAsWordInName
  private ByteArrayOutputStream bout;
  private PrintStream out;

  private String topicId = "dlp-tests";
  private String subscriptionId = "dlp-test";

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
  public void testNumericalStats() throws Exception {
    RiskAnalysis.main(
        new String[] {
          "-n",
          "-datasetId",
          "integration_tests_dlp",
          "-tableId",
          "harmful",
          "-columnName",
          "Age",
          "-topicId",
          topicId,
          "-subscriptionId",
          subscriptionId
        });
    String output = bout.toString();
    assertThat(output, containsString("Value at "));
  }

  @Test
  public void testCategoricalStats() throws Exception {
    RiskAnalysis.main(
        new String[] {
          "-c",
          "-datasetId",
          "integration_tests_dlp",
          "-tableId",
          "harmful",
          "-columnName",
          "Mystery",
          "-topicId",
          topicId,
          "-subscriptionId",
          subscriptionId
        });
    String output = bout.toString();

    assertTrue(Pattern.compile("Most common value occurs \\d time").matcher(output).find());
    assertTrue(Pattern.compile("Least common value occurs \\d time").matcher(output).find());
  }

  @Test
  public void testKAnonymity() throws Exception {
    RiskAnalysis.main(
        new String[] {
          "-a",
          "-datasetId",
          "integration_tests_dlp",
          "-tableId",
          "harmful",
          "-quasiIdColumnNames",
          "Age",
          "Mystery",
          "-topicId",
          topicId,
          "-subscriptionId",
          subscriptionId
        });
    String output = bout.toString();
    assertTrue(Pattern.compile("Bucket size range: \\[\\d, \\d\\]").matcher(output).find());
    assertTrue(output.contains("Quasi-ID values: integer_value: 19"));
    assertTrue(output.contains("Class size: 1"));
  }

  @Test
  public void testLDiversity() throws Exception {
    RiskAnalysis.main(
        new String[] {
          "-l",
          "-datasetId",
          "integration_tests_dlp",
          "-tableId",
          "harmful",
          "-sensitiveAttribute",
          "Name",
          "-quasiIdColumnNames",
          "Age",
          "Mystery",
          "-topicId",
          topicId,
          "-subscriptionId",
          subscriptionId
        });
    String output = bout.toString();
    assertTrue(output.contains("Quasi-ID values: integer_value: 19"));
    assertTrue(output.contains("Class size: 1"));
    assertTrue(output.contains("Sensitive value string_value: \"James\""));
  }

  @Test
  public void testKMap() throws Exception {
    RiskAnalysis.main(
        new String[] {
          "-m",
          "-datasetId",
          "integration_tests_dlp",
          "-tableId",
          "harmful",
          "-topicId",
          topicId,
          "-subscriptionId",
          subscriptionId,
          "-regionCode",
          "US",
          "-quasiIdColumnNames",
          "Age",
          "Gender",
          "-infoTypes",
          "AGE",
          "GENDER"
        });
    String output = bout.toString();

    assertTrue(Pattern.compile("Anonymity range: \\[\\d, \\d]").matcher(output).find());
    assertTrue(Pattern.compile("Size: \\d").matcher(output).find());
    assertTrue(Pattern.compile("Values: \\{\\d{2}, \"Female\"\\}").matcher(output).find());
  }

  @After
  public void tearDown() {
    System.setOut(null);
    bout.reset();
  }
}
