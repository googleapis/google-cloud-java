/*
 * Copyright 2023 Google LLC
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

// [START spanner_create_instance_with_autoscaling_config]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.spanner.Instance;
import com.google.cloud.spanner.InstanceAdminClient;
import com.google.cloud.spanner.InstanceConfigId;
import com.google.cloud.spanner.InstanceId;
import com.google.cloud.spanner.InstanceInfo;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.spanner.admin.instance.v1.AutoscalingConfig;
import com.google.spanner.admin.instance.v1.CreateInstanceMetadata;
import com.google.spanner.admin.instance.v1.Instance.Edition;
import java.util.concurrent.ExecutionException;

class CreateInstanceWithAutoscalingConfigExample {

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
    // Create an autoscaling config.
    AutoscalingConfig autoscalingConfig =
        AutoscalingConfig.newBuilder()
            .setAutoscalingLimits(
                AutoscalingConfig.AutoscalingLimits.newBuilder().setMinNodes(1).setMaxNodes(2))
            .setAutoscalingTargets(
                AutoscalingConfig.AutoscalingTargets.newBuilder()
                    .setHighPriorityCpuUtilizationPercent(65)
                    .setStorageUtilizationPercent(95))
            .build();

    // Create an InstanceInfo object that will be used to create the instance.
    InstanceInfo instanceInfo =
        InstanceInfo.newBuilder(InstanceId.of(projectId, instanceId))
            .setInstanceConfigId(InstanceConfigId.of(projectId, configId))
            .setAutoscalingConfig(autoscalingConfig)
            .setDisplayName("Descriptive name")
            .setEdition(Edition.ENTERPRISE)
            .build();
    OperationFuture<Instance, CreateInstanceMetadata> operation =
        instanceAdminClient.createInstance(instanceInfo);

    try {
      // Wait for the createInstance operation to finish.
      Instance instance = operation.get();
      System.out.printf("Autoscaler instance %s was successfully created%n", instance.getId());
    } catch (ExecutionException e) {
      System.out.printf(
          "Error: Creating instance %s failed with error message %s%n",
          instanceInfo.getId(), e.getMessage());
    } catch (InterruptedException e) {
      System.out.println("Error: Waiting for createInstance operation to finish was interrupted");
    } finally {
      spanner.close();
    }
  }
}
// [END spanner_create_instance_with_autoscaling_config]
