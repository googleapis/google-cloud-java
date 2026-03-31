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

// [START spanner_create_instance_with_autoscaling_config]

import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient;
import com.google.spanner.admin.instance.v1.AutoscalingConfig;
import com.google.spanner.admin.instance.v1.CreateInstanceRequest;
import com.google.spanner.admin.instance.v1.Instance;
import com.google.spanner.admin.instance.v1.Instance.Edition;
import com.google.spanner.admin.instance.v1.InstanceConfigName;
import com.google.spanner.admin.instance.v1.ProjectName;
import java.util.concurrent.ExecutionException;

class CreateInstanceWithAutoscalingConfigExample {

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
      String displayName = "Descriptive name";

      // Create an autoscaling config.
      // When autoscaling_config is enabled, node_count and processing_units fields
      // need not be specified.
      AutoscalingConfig autoscalingConfig =
          AutoscalingConfig.newBuilder()
              .setAutoscalingLimits(
                  AutoscalingConfig.AutoscalingLimits.newBuilder().setMinNodes(1).setMaxNodes(2))
              .setAutoscalingTargets(
                  AutoscalingConfig.AutoscalingTargets.newBuilder()
                      .setHighPriorityCpuUtilizationPercent(65)
                      .setStorageUtilizationPercent(95))
              .build();
      Instance instance =
          Instance.newBuilder()
              .setAutoscalingConfig(autoscalingConfig)
              .setDisplayName(displayName)
              .setConfig(
                  InstanceConfigName.of(projectId, configId).toString())
              .setEdition(Edition.ENTERPRISE)
              .build();

      // Creates a new instance
      System.out.printf("Creating instance %s.%n", instanceId);
      try {
        // Wait for the createInstance operation to finish.
        Instance instanceResult = instanceAdminClient.createInstanceAsync(
            CreateInstanceRequest.newBuilder()
                .setParent(ProjectName.of(projectId).toString())
                .setInstanceId(instanceId)
                .setInstance(instance)
                .build()).get();
        System.out.printf("Autoscaler instance %s was successfully created%n",
            instanceResult.getName());
      } catch (ExecutionException e) {
        System.out.printf(
            "Error: Creating instance %s failed with error message %s%n",
            instance.getName(), e.getMessage());
      } catch (InterruptedException e) {
        System.out.println("Error: Waiting for createInstance operation to finish was interrupted");
      }
    }
  }
}
// [END spanner_create_instance_with_autoscaling_config]
