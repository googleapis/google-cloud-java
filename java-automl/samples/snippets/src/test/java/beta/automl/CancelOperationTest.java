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

import com.google.api.gax.rpc.NotFoundException;
import io.grpc.StatusRuntimeException;
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
public class CancelOperationTest {

  private static final String PROJECT_ID = System.getenv("AUTOML_PROJECT_ID");

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
  public void setUp() {
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
  public void testCancelOperation() throws IOException {
    String operationFullPathId =
        String.format(
            "projects/%s/locations/%s/operations/%s", PROJECT_ID, "us-central1", "TCN0000000000");
    // Any cancelled operation on models or datasets will be hidden once the operations are flagged
    // as failed operations
    // which makes them hard to delete in the teardown.
    try {
      CancelOperation.cancelOperation(operationFullPathId);
      String got = bout.toString();
      assertThat(got).contains("not found");
    } catch (NotFoundException | StatusRuntimeException | InterruptedException e) {
      assertThat(e.getMessage()).contains("not found");
    }
  }
}
