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
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CreateDatasetImageSampleTest {

  private static final String PROJECT = System.getenv("UCAIP_PROJECT_ID");
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;
  private String datasetId;

  private static void requireEnvVar(String varName) {
    String errorMessage =
        String.format("Environment variable '%s' is required to perform these tests.", varName);
    assertNotNull(errorMessage, System.getenv(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("UCAIP_PROJECT_ID");
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown()
      throws InterruptedException, ExecutionException, IOException, TimeoutException {
    // Delete the created dataset
    DeleteDatasetSample.deleteDatasetSample(PROJECT, datasetId);

    // Assert
    String deleteResponse = bout.toString();
    assertThat(deleteResponse).contains("Deleted Dataset");
    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  @Ignore("https://github.com/googleapis/java-aiplatform/issues/420")
  public void testCreateDatasetSample()
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // Act
    String datasetDisplayName =
        String.format(
            "temp_create_dataset_test_%s",
            UUID.randomUUID().toString().replaceAll("-", "_").substring(0, 26));

    CreateDatasetImageSample.createDatasetImageSample(PROJECT, datasetDisplayName);

    // Assert
    String got = bout.toString();
    assertThat(got).contains(datasetDisplayName);
    assertThat(got).contains("Create Image Dataset Response");
    datasetId = got.split("Name: ")[1].split("datasets/")[1].split("\n")[0];
  }
}
