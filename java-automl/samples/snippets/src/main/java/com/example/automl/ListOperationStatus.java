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

package com.example.automl;

// [START automl_list_operation_status]
import com.google.cloud.automl.v1.AutoMlClient;
import com.google.cloud.automl.v1.LocationName;
import com.google.longrunning.ListOperationsRequest;
import com.google.longrunning.Operation;
import java.io.IOException;

class ListOperationStatus {

  static void listOperationStatus() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "YOUR_PROJECT_ID";
    listOperationStatus(projectId);
  }

  // Get the status of an operation
  static void listOperationStatus(String projectId) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (AutoMlClient client = AutoMlClient.create()) {
      // A resource that represents Google Cloud Platform location.
      LocationName projectLocation = LocationName.of(projectId, "us-central1");

      // Create list operations request.
      ListOperationsRequest listrequest =
          ListOperationsRequest.newBuilder().setName(projectLocation.toString()).build();

      // List all the operations names available in the region by applying filter.
      for (Operation operation :
          client.getOperationsClient().listOperations(listrequest).iterateAll()) {
        System.out.println("Operation details:");
        System.out.format("\tName: %s\n", operation.getName());
        System.out.format("\tMetadata Type Url: %s\n", operation.getMetadata().getTypeUrl());
        System.out.format("\tDone: %s\n", operation.getDone());
        if (operation.hasResponse()) {
          System.out.format("\tResponse Type Url: %s\n", operation.getResponse().getTypeUrl());
        }
        if (operation.hasError()) {
          System.out.println("\tResponse:");
          System.out.format("\t\tError code: %s\n", operation.getError().getCode());
          System.out.format("\t\tError message: %s\n\n", operation.getError().getMessage());
        }
      }
    }
  }
}
// [END automl_list_operation_status]
