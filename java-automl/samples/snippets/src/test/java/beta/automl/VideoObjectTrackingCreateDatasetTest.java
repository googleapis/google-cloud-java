/*
 * Copyright 2020 Google LLC
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

package beta.automl;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.cloud.automl.v1beta1.AutoMlClient;
import com.google.cloud.automl.v1beta1.DatasetName;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class VideoObjectTrackingCreateDatasetTest {

  private static final String PROJECT_ID = System.getenv("AUTOML_PROJECT_ID");
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;
  private String datasetId;

  private static String requireEnvVar(String varName) {
    String value = System.getenv(varName);
    assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
    return value;
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("AUTOML_PROJECT_ID");
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown() throws InterruptedException, ExecutionException, IOException {
    // Delete the created dataset
    try (AutoMlClient client = AutoMlClient.create()) {
      // Get the full path of the dataset.
      DatasetName datasetFullId = DatasetName.of(PROJECT_ID, "us-central1", datasetId);
      client.deleteDatasetAsync(datasetFullId).get();
    }
    System.setOut(originalPrintStream);
  }

  @Test
  public void testCreateDataset() throws IOException, ExecutionException, InterruptedException {
    // Create a random dataset name with a length of 32 characters (max allowed by AutoML)
    // To prevent name collisions when running tests in multiple java versions at once.
    // AutoML doesn't allow "-", but accepts "_"
    String datasetName =
        String.format("test_%s", UUID.randomUUID().toString().replace("-", "_").substring(0, 26));
    VideoObjectTrackingCreateDataset.createDataset(PROJECT_ID, datasetName);

    String got = bout.toString();
    assertThat(got).contains("Dataset id:");
    datasetId = got.split("Dataset id: ")[1].split("\n")[0];
  }
}
