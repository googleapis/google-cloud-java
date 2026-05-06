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

//[START spanner_create_instance_with_processing_units]

import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient;
import com.google.spanner.admin.instance.v1.CreateInstanceRequest;
import com.google.spanner.admin.instance.v1.Instance;
import com.google.spanner.admin.instance.v1.InstanceConfigName;
import com.google.spanner.admin.instance.v1.ProjectName;

class CreateInstanceWithProcessingUnitsExample {

  static void createInstance() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    createInstance(projectId, instanceId);
  }

  static void createInstance(String projectId, String instanceId) {
    try (Spanner spanner =
        SpannerOptions.newBuilder()
            .setProjectId(projectId)
            .build()
            .getService();
        InstanceAdminClient instanceAdminClient = spanner.createInstanceAdminClient()) {

      // Set Instance configuration.
      String configId = "regional-us-east4";
      // This will create an instance with the processing power of 0.2 nodes.
      int processingUnits = 500;
      String displayName = "Descriptive name";

      try {
        // Creates a new instance
        System.out.printf("Creating instance %s.%n", instanceId);
        Instance instance =
            Instance.newBuilder()
                .setDisplayName(displayName)
                .setProcessingUnits(processingUnits)
                .setConfig(
                    InstanceConfigName.of(projectId, configId).toString())
                .build();
        // Wait for the createInstance operation to finish.
        System.out.printf("Waiting for operation on %s to complete...%n", instanceId);
        Instance createdInstance = instanceAdminClient.createInstanceAsync(
            CreateInstanceRequest.newBuilder()
                .setParent(ProjectName.of(projectId).toString())
                .setInstanceId(instanceId)
                .setInstance(instance)
                .build()).get();

        System.out.printf("Created instance %s.%n", createdInstance.getName());
        System.out.printf("Instance %s has %d processing units.%n", createdInstance.getName(),
            createdInstance.getProcessingUnits());
      } catch (Exception e) {
        System.out.printf("Error: %s.%n", e.getMessage());
      }
    }
  }
}
//[END spanner_create_instance_with_processing_units]
