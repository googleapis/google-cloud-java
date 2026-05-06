/*
 * Copyright 2024 Google LLC
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

package com.example.spanner;

// [START spanner_list_instance_config_operations]

import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient;
import com.google.longrunning.Operation;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.spanner.admin.instance.v1.CreateInstanceConfigMetadata;
import com.google.spanner.admin.instance.v1.ListInstanceConfigOperationsRequest;
import com.google.spanner.admin.instance.v1.ProjectName;

public class ListInstanceConfigOperationsSample {

  static void listInstanceConfigOperations() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    listInstanceConfigOperations(projectId);
  }

  static void listInstanceConfigOperations(String projectId) {
    try (Spanner spanner =
        SpannerOptions.newBuilder()
            .setProjectId(projectId)
            .build()
            .getService();
        InstanceAdminClient instanceAdminClient = spanner.createInstanceAdminClient()) {
      final ProjectName projectName = ProjectName.of(projectId);
      System.out.printf(
          "Getting list of instance config operations for project %s...\n",
          projectId);
      final ListInstanceConfigOperationsRequest request =
          ListInstanceConfigOperationsRequest.newBuilder()
              .setParent(projectName.toString())
              .setFilter("(metadata.@type=type.googleapis.com/"
                  + "google.spanner.admin.instance.v1.CreateInstanceConfigMetadata)").build();
      final Iterable<Operation> instanceConfigOperations =
          instanceAdminClient.listInstanceConfigOperations(request).iterateAll();
      for (Operation operation : instanceConfigOperations) {
        CreateInstanceConfigMetadata metadata =
            operation.getMetadata().unpack(CreateInstanceConfigMetadata.class);
        System.out.printf(
            "Create instance config operation for %s is %d%% completed.\n",
            metadata.getInstanceConfig().getName(), metadata.getProgress().getProgressPercent());
      }
      System.out.printf(
          "Obtained list of instance config operations for project %s...\n",
          projectName);
    } catch (InvalidProtocolBufferException e) {
      System.out.printf(
          "Error: Listing instance config operations failed with error message %s\n",
          e.getMessage());
    }
  }
}
// [END spanner_list_instance_config_operations]
