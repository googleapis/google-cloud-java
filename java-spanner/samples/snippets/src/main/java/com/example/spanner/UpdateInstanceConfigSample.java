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

// [START spanner_update_instance_config]

import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.FieldMask;
import com.google.spanner.admin.instance.v1.InstanceConfig;
import com.google.spanner.admin.instance.v1.InstanceConfigName;
import com.google.spanner.admin.instance.v1.UpdateInstanceConfigRequest;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class UpdateInstanceConfigSample {

  static void updateInstanceConfig() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceConfigId = "custom-instance-config";
    updateInstanceConfig(projectId, instanceConfigId);
  }

  static void updateInstanceConfig(String projectId, String instanceConfigId) {
    try (Spanner spanner =
        SpannerOptions.newBuilder()
            .setProjectId(projectId)
            .build()
            .getService();
        InstanceAdminClient instanceAdminClient = spanner.createInstanceAdminClient()) {
      final InstanceConfigName instanceConfigName =
          InstanceConfigName.of(projectId, instanceConfigId);
      final InstanceConfig instanceConfig =
          InstanceConfig.newBuilder()
              .setName(instanceConfigName.toString())
              .setDisplayName("updated custom instance config")
              .putLabels("updated", "true").build();
      /**
       * The field mask must always be specified; this prevents any future
       * fields in [InstanceConfig][google.spanner.admin.instance.v1.InstanceConfig]
       * from being erased accidentally by clients that do not know about them.
       */
      final UpdateInstanceConfigRequest updateInstanceConfigRequest =
          UpdateInstanceConfigRequest.newBuilder()
              .setInstanceConfig(instanceConfig)
              .setUpdateMask(
                  FieldMask.newBuilder().addAllPaths(ImmutableList.of("display_name", "labels"))
                      .build()).build();
      try {
        System.out.printf("Waiting for update operation on %s to complete...\n",
            instanceConfigName);
        InstanceConfig instanceConfigResult =
            instanceAdminClient.updateInstanceConfigAsync(
                updateInstanceConfigRequest).get(5, TimeUnit.MINUTES);
        System.out.printf(
            "Updated instance configuration %s with new display name %s\n",
            instanceConfigResult.getName(), instanceConfig.getDisplayName());
      } catch (ExecutionException | TimeoutException e) {
        System.out.printf(
            "Error: Updating instance config %s failed with error message %s\n",
            instanceConfig.getName(), e.getMessage());
        e.printStackTrace();
      } catch (InterruptedException e) {
        System.out.println(
            "Error: Waiting for updateInstanceConfig operation to finish was interrupted");
      }
    }
  }
}
// [END spanner_update_instance_config]
