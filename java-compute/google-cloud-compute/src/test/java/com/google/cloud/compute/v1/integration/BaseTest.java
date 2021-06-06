/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.integration;

import static junit.framework.TestCase.fail;

import com.google.cloud.ServiceOptions;
import com.google.cloud.compute.v1.GlobalOperationsClient;
import com.google.cloud.compute.v1.Operation;
import java.io.IOException;
import java.util.UUID;

public class BaseTest {
  protected static final String DEFAULT_PROJECT = ServiceOptions.getDefaultProjectId();
  protected static final String DEFAULT_ZONE = "us-central1-a";
  protected static final String DEFAULT_REGION = "us-west1";

  public static String generateRandomName(String placeholder) {
    return "gapic-" + placeholder + UUID.randomUUID().toString().substring(0, 8);
  }

  public void waitGlobalOperation(Operation operation) throws IOException {
    GlobalOperationsClient operationsClient = GlobalOperationsClient.create();
    long startTime = System.currentTimeMillis();
    while (true) {
      if ((System.currentTimeMillis() - startTime) > 200000) {
        fail("Operation " + operation.getName() + " took more than 200 sec to finish");
      }
      Operation tempOperation = operationsClient.get(DEFAULT_PROJECT, operation.getName());
      if (tempOperation.getStatus().equals(Operation.Status.UNRECOGNIZED)) {
        fail("Unexpected operation status: UNRECOGNIZED");
        break;
      }
      if (tempOperation.getStatus().equals(Operation.Status.UNDEFINED_STATUS)) {
        fail("Unexpected operation status: UNDEFINED_STATUS");
        break;
      }
      if (tempOperation.getStatus().equals(Operation.Status.DONE)) {
        break;
      }
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        fail("Interrupted");
      }
    }
  }
}
