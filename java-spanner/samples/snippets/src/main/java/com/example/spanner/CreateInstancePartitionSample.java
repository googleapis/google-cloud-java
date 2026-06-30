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

// [START spanner_create_instance_partition]

import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient;
import com.google.spanner.admin.instance.v1.CreateInstancePartitionRequest;
import com.google.spanner.admin.instance.v1.InstanceConfigName;
import com.google.spanner.admin.instance.v1.InstanceName;
import com.google.spanner.admin.instance.v1.InstancePartition;
import java.util.concurrent.ExecutionException;

class CreateInstancePartitionSample {

  static void createInstancePartition() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String instancePartitionId = "my-instance-partition";
    createInstancePartition(projectId, instanceId, instancePartitionId);
  }

  static void createInstancePartition(
      String projectId, String instanceId, String instancePartitionId) {
    // Set instance partition configuration.
    int nodeCount = 1;
    String displayName = "Descriptive name";

    // Create an InstancePartition object that will be used to create the instance partition.
    InstancePartition instancePartition =
        InstancePartition.newBuilder()
            .setDisplayName(displayName)
            .setNodeCount(nodeCount)
            .setConfig(InstanceConfigName.of(projectId, "nam3").toString())
            .build();

    try (Spanner spanner =
            SpannerOptions.newBuilder().setProjectId(projectId).build().getService();
        InstanceAdminClient instanceAdminClient = spanner.createInstanceAdminClient()) {

      // Wait for the createInstancePartition operation to finish.
      InstancePartition createdInstancePartition =
          instanceAdminClient
              .createInstancePartitionAsync(
                  CreateInstancePartitionRequest.newBuilder()
                      .setParent(InstanceName.of(projectId, instanceId).toString())
                      .setInstancePartitionId(instancePartitionId)
                      .setInstancePartition(instancePartition)
                      .build())
              .get();
      System.out.printf(
          "Instance partition %s was successfully created%n", createdInstancePartition.getName());
    } catch (ExecutionException e) {
      System.out.printf(
          "Error: Creating instance partition %s failed with error message %s%n",
          instancePartition.getName(), e.getMessage());
    } catch (InterruptedException e) {
      System.out.println(
          "Error: Waiting for createInstancePartition operation to finish was interrupted");
    }
  }
}
// [END spanner_create_instance_partition]
