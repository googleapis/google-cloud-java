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

import com.google.cloud.automl.v1.AutoMlClient;
import com.google.cloud.automl.v1.DeployModelRequest;
import com.google.cloud.automl.v1.Model;
import com.google.cloud.automl.v1.ModelName;
import com.google.protobuf.Value;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class TablesPredictTest {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String MODEL_ID = "TBL7972827093840953344";
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

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
  public void setUp() throws IOException, ExecutionException, InterruptedException {
    // Verify that the model is deployed for prediction
    try (AutoMlClient client = AutoMlClient.create()) {
      ModelName modelFullId = ModelName.of(PROJECT_ID, "us-central1", MODEL_ID);
      Model model = client.getModel(modelFullId);
      if (model.getDeploymentState() == Model.DeploymentState.UNDEPLOYED) {
        // Deploy the model if not deployed
        DeployModelRequest request =
            DeployModelRequest.newBuilder().setName(modelFullId.toString()).build();
        client.deployModelAsync(request).get();
      }
    }

    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown() {
    // restores print statements in the original method
    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  public void testTablesPredict() throws IOException {
    List<Value> values = new ArrayList<>();
    values.add(Value.newBuilder().setNumberValue(39).build()); // Age
    values.add(Value.newBuilder().setStringValue("technician").build()); // Job
    values.add(Value.newBuilder().setStringValue("married").build()); // MaritalStatus
    values.add(Value.newBuilder().setStringValue("secondary").build()); // Education
    values.add(Value.newBuilder().setStringValue("no").build()); // Default
    values.add(Value.newBuilder().setNumberValue(52).build()); // Balance
    values.add(Value.newBuilder().setStringValue("no").build()); // Housing
    values.add(Value.newBuilder().setStringValue("no").build()); // Loan
    values.add(Value.newBuilder().setStringValue("cellular").build()); // Contact
    values.add(Value.newBuilder().setNumberValue(12).build()); // Day
    values.add(Value.newBuilder().setStringValue("aug").build()); // Month
    values.add(Value.newBuilder().setNumberValue(96).build()); // Duration
    values.add(Value.newBuilder().setNumberValue(2).build()); // Campaign
    values.add(Value.newBuilder().setNumberValue(-1).build()); // PDays
    values.add(Value.newBuilder().setNumberValue(0).build()); // Previous
    values.add(Value.newBuilder().setStringValue("unknown").build()); // POutcome

    TablesPredict.predict(PROJECT_ID, MODEL_ID, values);

    String got = bout.toString();
    assertThat(got).contains("Prediction results:");
  }
}
