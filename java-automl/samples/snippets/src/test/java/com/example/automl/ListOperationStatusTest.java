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

package com.example.automl;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.api.client.util.ExponentialBackOff;
import com.google.api.gax.rpc.ResourceExhaustedException;
import com.google.cloud.automl.v1.AutoMlClient;
import com.google.cloud.automl.v1.LocationName;
import com.google.longrunning.ListOperationsRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ListOperationStatusTest {
  private static final String PROJECT_ID = System.getenv("AUTOML_PROJECT_ID");
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  private static void requireEnvVar(String varName) {
    assertNotNull(
        System.getenv(varName),
        "Environment variable '%s' is required to perform these tests.".format(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("AUTOML_PROJECT_ID");
  }

  @Before
  public void setUp() throws IOException, InterruptedException {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);

    // if the LRO status count more than 300, delete half of operations.
    try (AutoMlClient client = AutoMlClient.create()) {
      OperationsClient operationsClient = client.getOperationsClient();
      LocationName projectLocation = LocationName.of(PROJECT_ID, "us-central1");
      ListOperationsRequest listRequest =
          ListOperationsRequest.newBuilder().setName(projectLocation.toString()).build();
      List<String> operationFullPathsToBeDeleted = new ArrayList<>();
      for (Operation operation : operationsClient.listOperations(listRequest).iterateAll()) {
        // collect unused operation into the list.
        // Filter: deleting already done operations.
        if (operation.getDone() && !operation.hasError()) {
          operationFullPathsToBeDeleted.add(operation.getName());
        }
      }

      if (operationFullPathsToBeDeleted.size() > 300) {
        System.out.println("Cleaning up...");

        for (String operationFullPath :
            operationFullPathsToBeDeleted.subList(0, operationFullPathsToBeDeleted.size() / 2)) {
          // retry_interval * (random value in range [1 - rand_factor, 1 + rand_factor])
          ExponentialBackOff exponentialBackOff =
              new ExponentialBackOff.Builder()
                  .setInitialIntervalMillis(60000)
                  .setMaxElapsedTimeMillis(300000)
                  .setRandomizationFactor(0.5)
                  .setMultiplier(1.1)
                  .setMaxIntervalMillis(80000)
                  .build();

          // delete unused operations.
          try {
            operationsClient.deleteOperation(operationFullPath);
          } catch (ResourceExhaustedException ex) {
            // exponential back off and retry.
            long backOffInMillis = exponentialBackOff.nextBackOffMillis();
            System.out.printf(
                "Backing off for %d milliseconds " + "due to Resource exhaustion.\n",
                backOffInMillis);
            if (backOffInMillis < 0) {
              break;
            }
            System.out.println("Backing off" + backOffInMillis);
            TimeUnit.MILLISECONDS.sleep(backOffInMillis);
          } catch (Exception ex) {
            throw ex;
          }
        }
      } else {
        // Clear the list since we wont anything with the list.
        operationFullPathsToBeDeleted.clear();
      }
    }
  }

  @After
  public void tearDown() {
    // restores print statements in the original method
    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  public void testOperationStatus() throws IOException {
    ListOperationStatus.listOperationStatus(PROJECT_ID);
    String got = bout.toString();
    assertThat(got).contains("Operation details:");
  }
}
