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

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RedactTests extends TestBase {

  private static final String SIMPLE_INPUT_FILE = "src/test/resources/test.png";
  private static final String SIMPLE_OUTPUT_FILE = "redacted.png";
  private static final String DOCUMENT_INPUT_FILE = "src/test/resources/sensitive-data-image.jpg";
  private static final String DOCUMENT_OUTPUT_FILE = "sensitive-data-image-redacted.jpg";

  @Override
  protected ImmutableList<String> requiredEnvVars() {
    return ImmutableList.of("GOOGLE_APPLICATION_CREDENTIALS", "GOOGLE_CLOUD_PROJECT");
  }

  @After
  public void after() throws IOException {
    Files.deleteIfExists(Paths.get(SIMPLE_OUTPUT_FILE));
    Files.deleteIfExists(Paths.get(DOCUMENT_OUTPUT_FILE));
  }

  @Test
  public void testRedactImage() throws Exception {
    RedactImageFile.redactImageFile(PROJECT_ID, SIMPLE_INPUT_FILE, SIMPLE_OUTPUT_FILE);

    String output = bout.toString();
    assertThat(output).contains("Redacted image written");
  }

  @Test
  public void testRedactImageAllInfoTypes() throws Exception {
    RedactImageFileAllInfoTypes.redactImageFileAllInfoTypes(
        PROJECT_ID, DOCUMENT_INPUT_FILE, DOCUMENT_OUTPUT_FILE);

    String output = bout.toString();
    assertThat(output).contains("Redacted image written");
  }

  @Test
  public void testRedactImageListedInfoTypes() throws Exception {
    RedactImageFileListedInfoTypes.redactImageFileListedInfoTypes(
        PROJECT_ID, DOCUMENT_INPUT_FILE, DOCUMENT_OUTPUT_FILE);

    String output = bout.toString();
    assertThat(output).contains("Redacted image written");
  }

  @Test
  public void testRedactImageColoredInfoTypes() throws Exception {
    RedactImageFileColoredInfoTypes.redactImageFileColoredInfoTypes(
        PROJECT_ID, DOCUMENT_INPUT_FILE, DOCUMENT_OUTPUT_FILE);

    String output = bout.toString();
    assertThat(output).contains("Redacted image written");
  }

  @Test
  public void testRedactImageAllText() throws Exception {
    RedactImageFileAllText.redactImageFileAllText(
        PROJECT_ID, DOCUMENT_INPUT_FILE, DOCUMENT_OUTPUT_FILE);

    String output = bout.toString();
    assertThat(output).contains("Redacted image written");
  }
}
