/*
 * Copyright 2019 Google LLC
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

package dlp.snippets;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertNotNull;

import com.google.privacy.dlp.v2.FieldId;
import com.google.privacy.dlp.v2.Table;
import com.google.privacy.dlp.v2.Table.Row;
import com.google.privacy.dlp.v2.Value;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DeIdentificationTests {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  // TODO: Update as ENV_VARs
  private static final String bucketName = PROJECT_ID + "/dlp";
  private ByteArrayOutputStream bout;
  private String wrappedKey = System.getenv("DLP_DEID_WRAPPED_KEY");
  private String kmsKeyName = System.getenv("DLP_DEID_KEY_NAME");

  private static void requireEnvVar(String varName) {
    assertNotNull(
        String.format("Environment variable '%s' must be set to perform these tests.", varName),
        System.getenv(varName));
  }

  @Before
  public void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
    requireEnvVar("DLP_DEID_WRAPPED_KEY");
    requireEnvVar("DLP_DEID_KEY_NAME");
  }

  @Before
  public void captureOut() {
    bout = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bout));
  }

  @After
  public void releaseOut() {
    System.setOut(null);
    bout.reset();
  }

  @Test
  public void testDeIdentifyWithMasking() throws IOException {
    DeIdentifyWithMasking.deIdentifyWithMasking(PROJECT_ID, "My SSN is 372819127");

    String output = bout.toString();
    assertThat(output, containsString("Text after masking:"));
  }

  @Test
  public void testDeIdentifyWithFpe() throws IOException {
    DeIdentifyWithFpe.deIdentifyWithFpe(PROJECT_ID, "My SSN is 372819127", kmsKeyName, wrappedKey);

    String output = bout.toString();
    assertThat(output, containsString("Text after format-preserving encryption:"));
  }

  @Test
  public void testReIdentifyWithFpe() throws IOException {
    ReIdentifyWithFpe.reIdentifyWithFpe(
        PROJECT_ID, "My SSN is SSN_TOKEN(9):731997681", kmsKeyName, wrappedKey);

    String output = bout.toString();
    assertThat(output, containsString("Text after re-identification:"));
  }

  @Test
  public void testDeIdentifyTextWithFpe() throws IOException {
    DeIdentifyTextWithFpe.deIdentifyTextWithFpe(
        PROJECT_ID, "My phone number is 4359916732", kmsKeyName, wrappedKey);

    String output = bout.toString();
    assertThat(output, containsString("Text after format-preserving encryption: "));
  }

  @Test
  public void testReIdentifyTextWithFpe() throws IOException {
    ReIdentifyTextWithFpe.reIdentifyTextWithFpe(
        PROJECT_ID,
        "My phone number is PHONE_TOKEN(10):9617256398",
        kmsKeyName,
        wrappedKey);

    String output = bout.toString();
    assertThat(output, containsString("Text after re-identification: "));
  }

  @Test
  public void testDeIdentifyTableWithFpe() throws IOException {
    Table tableToDeIdentify = Table.newBuilder()
        .addHeaders(FieldId.newBuilder().setName("Employee ID").build())
        .addHeaders(FieldId.newBuilder().setName("Date").build())
        .addHeaders(FieldId.newBuilder().setName("Compensation").build())
        .addRows(Row.newBuilder()
            .addValues(Value.newBuilder().setStringValue("11111").build())
            .addValues(Value.newBuilder().setStringValue("2015").build())
            .addValues(Value.newBuilder().setStringValue("$10").build())
            .build())
        .addRows(Row.newBuilder()
            .addValues(Value.newBuilder().setStringValue("11111").build())
            .addValues(Value.newBuilder().setStringValue("2016").build())
            .addValues(Value.newBuilder().setStringValue("$20").build())
            .build())
        .addRows(Row.newBuilder()
            .addValues(Value.newBuilder().setStringValue("22222").build())
            .addValues(Value.newBuilder().setStringValue("2016").build())
            .addValues(Value.newBuilder().setStringValue("$15").build())
            .build())
        .build();

    DeIdentifyTableWithFpe.deIdentifyTableWithFpe(
        PROJECT_ID, tableToDeIdentify, kmsKeyName, wrappedKey);

    String output = bout.toString();
    assertThat(output, containsString("Table after format-preserving encryption:"));
  }

  @Test
  public void testReIdentifyTableWithFpe() throws IOException {
    Table tableToReIdentify = Table.newBuilder()
        .addHeaders(FieldId.newBuilder().setName("Employee ID").build())
        .addRows(Row.newBuilder()
            .addValues(Value.newBuilder().setStringValue("28777").build()).build())
        .build();

    ReIdentifyTableWithFpe.reIdentifyTableWithFpe(
        PROJECT_ID, tableToReIdentify, kmsKeyName, wrappedKey);

    String output = bout.toString();
    assertThat(output, containsString("Table after re-identification:"));
  }

  @Test
  public void testDeIdentifyWithDateShift() throws IOException {
    Path inputFile = Paths.get("src/test/resources/dates.csv");
    assertThat("Input file must exist", inputFile.toFile().exists());
    Path outputFile = Paths.get("src/test/resources/results.csv");
    assertThat("Output file must be writeable", inputFile.toFile().canWrite());
    DeIdentifyWithDateShift.deIdentifyWithDateShift(PROJECT_ID, inputFile, outputFile);

    String output = bout.toString();
    assertThat(output, containsString("Content written to file: "));

    // Clean up test output
    Files.delete(outputFile);
  }

  @Test
  public void testDeIdentifyWithRedaction() throws IOException {
    DeIdentifyWithRedaction.deIdentifyWithRedaction(
        PROJECT_ID,
        "My name is Alicia Abernathy, and my email address is aabernathy@example.com.");

    String output = bout.toString();
    assertThat(output, containsString("Text after redaction: "
        + "My name is Alicia Abernathy, and my email address is ."));
  }

  @Test
  public void testDeIdentifyWithReplacement() throws IOException {
    DeIdentifyWithReplacement.deIdentifyWithReplacement(
        PROJECT_ID,
        "My name is Alicia Abernathy, and my email address is aabernathy@example.com.");

    String output = bout.toString();
    assertThat(output, containsString("Text after redaction: "
        + "My name is Alicia Abernathy, and my email address is [email-address]."));
  }

  @Test
  public void testDeIdentifyWithInfoType() throws IOException {
    DeIdentifyWithInfoType.deIdentifyWithInfoType(
        PROJECT_ID,
        "My email is test@example.com");

    String output = bout.toString();
    assertThat(output, containsString("Text after redaction: "
        + "My email is [EMAIL_ADDRESS]"));
  }

  @Test
  public void testDeIdentifyWithSimpleWordList() throws IOException {
    DeIdentifyWithSimpleWordList.deidentifyWithSimpleWordList(
        PROJECT_ID, "Patient was seen in RM-YELLOW then transferred to rm green.");

    String output = bout.toString();
    assertThat(output, containsString("Text after replace with infotype config: "));
  }

  @Test
  public void testDeIdentifyWithExceptionList() throws IOException {
    DeIdentifyWithExceptionList.deIdentifyWithExceptionList(
        PROJECT_ID, "jack@example.org accessed customer record of user5@example.com");

    String output = bout.toString();
    assertThat(output, containsString("Text after replace with infotype config: "));
  }
}
