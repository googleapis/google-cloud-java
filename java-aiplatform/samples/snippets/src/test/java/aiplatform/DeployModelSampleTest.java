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

import io.grpc.StatusRuntimeException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DeployModelSampleTest {

  private static final String PROJECT_ID = System.getenv("UCAIP_PROJECT_ID");
  private static final String MODEL_ID = "00000000000000000";
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
  public void testDeployModelSample() throws TimeoutException {
    // As model deployment can take a long time, instead try to deploy a
    // nonexistent model and confirm that the model was not found, but other
    // elements of the request were valid.
    String deployedModelDisplayName =
        String.format(
            "temp_deploy_model_test_%s",
            UUID.randomUUID().toString().replaceAll("-", "_").substring(0, 26));
    try {
      DeployModelSample.deployModelSample(
          PROJECT_ID, deployedModelDisplayName, "4366591682456584192", MODEL_ID);
      // Assert
      String got = bout.toString();
      assertThat(got).contains("is not found.");
    } catch (StatusRuntimeException | ExecutionException | InterruptedException | IOException e) {
      assertThat(e.getMessage()).contains("is not found.");
    }
  }
}
