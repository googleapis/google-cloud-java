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

// [START spanner_update_instance_default_backup_schedule_type]

import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient;
import com.google.common.collect.Lists;
import com.google.protobuf.FieldMask;
import com.google.spanner.admin.instance.v1.Instance;
import com.google.spanner.admin.instance.v1.InstanceConfigName;
import com.google.spanner.admin.instance.v1.InstanceName;
import com.google.spanner.admin.instance.v1.UpdateInstanceRequest;
import java.util.concurrent.ExecutionException;

public class UpdateInstanceDefaultBackupScheduleTypeExample {

  static void updateInstanceDefaultBackupScheduleType() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    updateInstanceDefaultBackupScheduleType(projectId, instanceId);
  }

  static void updateInstanceDefaultBackupScheduleType(String projectId, String instanceId) {
    // Set Instance configuration.
    int nodeCount = 2;
    String displayName = "Updated name";

    // Update an Instance object that will be used to update the instance.
    Instance instance =
        Instance.newBuilder()
            .setName(InstanceName.of(projectId, instanceId).toString())
            .setDisplayName(displayName)
            .setNodeCount(nodeCount)
            .setDefaultBackupScheduleType(Instance.DefaultBackupScheduleType.AUTOMATIC)
            .setConfig(InstanceConfigName.of(projectId, "regional-us-east4").toString())
            .build();

    try (Spanner spanner =
            SpannerOptions.newBuilder().setProjectId(projectId).build().getService();
        InstanceAdminClient instanceAdminClient = spanner.createInstanceAdminClient()) {

      // Wait for the updatedInstance operation to finish.
      Instance updatedInstance =
          instanceAdminClient
              .updateInstanceAsync(
                  UpdateInstanceRequest.newBuilder()
                      .setFieldMask(
                          FieldMask.newBuilder()
                              .addAllPaths(Lists.newArrayList("default_backup_schedule_type")))
                      .setInstance(instance)
                      .build())
              .get();
      System.out.printf("Instance %s was successfully updated%n", updatedInstance.getName());
    } catch (ExecutionException e) {
      System.out.printf(
          "Error: Updating instance %s failed with error message %s%n",
          instance.getName(), e.getMessage());
    } catch (InterruptedException e) {
      System.out.println("Error: Waiting for updateInstance operation to finish was interrupted");
    }
  }
}

// [END spanner_update_instance_default_backup_schedule_type]
