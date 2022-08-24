/*
 * Copyright 2021 Google Inc.
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

package com.example.contactcenterinsights;

// [START contactcenterinsights_get_operation]

import com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import java.io.IOException;

public class GetOperation {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace this variable before running the sample.
    String operationName = "projects/my_project_id/locations/us-central1/operations/12345";

    getOperation(operationName);
  }

  public static Operation getOperation(String operationName) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (ContactCenterInsightsClient client = ContactCenterInsightsClient.create()) {
      OperationsClient operationsClient = client.getOperationsClient();
      Operation operation = operationsClient.getOperation(operationName);

      System.out.printf("Got operation %s%n", operation.getName());
      return operation;
    }
  }
}

// [END contactcenterinsights_get_operation]
