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
import com.google.cloud.automl.v1beta1.LocationName;
import com.google.longrunning.ListOperationsRequest;
import com.google.longrunning.Operation;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GetOperationStatusTest {

  private static final String PROJECT_ID = System.getenv("AUTOML_PROJECT_ID");
  private String operationId;
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
  public void setUp() throws IOException {
    // Use list operations to get a single operation id for the get call.
    try (AutoMlClient client = AutoMlClient.create()) {
      LocationName projectLocation = LocationName.of(PROJECT_ID, "us-central1");
      ListOperationsRequest request =
          ListOperationsRequest.newBuilder().setName(projectLocation.toString()).build();
      Operation operation =
          client.getOperationsClient().listOperations(request).iterateAll().iterator().next();
      operationId = operation.getName();
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
  public void testGetOperationStatus() throws IOException {
    GetOperationStatus.getOperationStatus(operationId);
    String got = bout.toString();
    assertThat(got).contains("Operation details:");
  }
}
