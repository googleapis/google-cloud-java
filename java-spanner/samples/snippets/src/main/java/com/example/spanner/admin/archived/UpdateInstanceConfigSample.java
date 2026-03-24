/*
 * Copyright 2022 Google LLC
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

// [START spanner_update_instance_config]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.spanner.InstanceAdminClient;
import com.google.cloud.spanner.InstanceConfig;
import com.google.cloud.spanner.InstanceConfigId;
import com.google.cloud.spanner.InstanceConfigInfo;
import com.google.cloud.spanner.InstanceConfigInfo.InstanceConfigField;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.common.collect.ImmutableList;
import com.google.spanner.admin.instance.v1.UpdateInstanceConfigMetadata;
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
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {
      final InstanceAdminClient instanceAdminClient = spanner.getInstanceAdminClient();
      InstanceConfigInfo instanceConfigInfo =
          InstanceConfig.newBuilder(InstanceConfigId.of(projectId, instanceConfigId))
              .setDisplayName("updated custom instance config")
              .addLabel("updated", "true")
              .build();
      final OperationFuture<InstanceConfig, UpdateInstanceConfigMetadata> operation =
          instanceAdminClient.updateInstanceConfig(
              instanceConfigInfo,
              ImmutableList.of(InstanceConfigField.DISPLAY_NAME, InstanceConfigField.LABELS));
      try {
        System.out.printf("Waiting for update operation on %s to complete...\n", instanceConfigId);
        InstanceConfig instanceConfig = operation.get(5, TimeUnit.MINUTES);
        System.out.printf(
            "Updated instance configuration %s with new display name %s\n",
            instanceConfig.getId(), instanceConfig.getDisplayName());
      } catch (ExecutionException | TimeoutException e) {
        System.out.printf(
            "Error: Updating instance config %s failed with error message %s\n",
            instanceConfigInfo.getId(), e.getMessage());
        e.printStackTrace();
      } catch (InterruptedException e) {
        System.out.println(
            "Error: Waiting for updateInstanceConfig operation to finish was interrupted");
      }
    }
  }
}
// [END spanner_update_instance_config]
