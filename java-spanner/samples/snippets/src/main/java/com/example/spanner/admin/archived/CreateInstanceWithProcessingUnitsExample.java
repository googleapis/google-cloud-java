/*
 * Copyright 2021 Google LLC
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

package com.example.spanner.admin.archived;

//[START spanner_create_instance_with_processing_units]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.spanner.Instance;
import com.google.cloud.spanner.InstanceAdminClient;
import com.google.cloud.spanner.InstanceConfigId;
import com.google.cloud.spanner.InstanceId;
import com.google.cloud.spanner.InstanceInfo;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.spanner.admin.instance.v1.CreateInstanceMetadata;

class CreateInstanceWithProcessingUnitsExample {

  static void createInstance() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    createInstance(projectId, instanceId);
  }

  static void createInstance(String projectId, String instanceId) {
    Spanner spanner = SpannerOptions.newBuilder().setProjectId(projectId).build().getService();
    InstanceAdminClient instanceAdminClient = spanner.getInstanceAdminClient();

    // Set Instance configuration.
    String configId = "regional-us-east4";
    // This will create an instance with the processing power of 0.2 nodes.
    int processingUnits = 500;
    String displayName = "Descriptive name";

    try {
      // Creates a new instance
      System.out.printf("Creating instance %s.%n", instanceId);
      OperationFuture<Instance, CreateInstanceMetadata> operation =
          instanceAdminClient.createInstance(InstanceInfo
              .newBuilder(InstanceId.of(projectId, instanceId))
              .setInstanceConfigId(InstanceConfigId.of(projectId, configId))
              .setProcessingUnits(processingUnits)
              .setDisplayName(displayName)
              .build());

      // Wait for the createInstance operation to finish.
      System.out.printf("Waiting for operation on %s to complete...%n", instanceId);
      Instance createdInstance = operation.get();

      System.out.printf("Created instance %s.%n", createdInstance.getId().getInstance());

      Instance instance = instanceAdminClient.getInstance(instanceId);
      System.out.printf("Instance %s has %d processing units.%n", instance.getId().getInstance(),
          instance.getProcessingUnits());
    } catch (Exception e) {
      System.out.printf("Error: %s.%n", e.getMessage());
    }
    spanner.close();
  }
}
//[END spanner_create_instance_with_processing_units]
