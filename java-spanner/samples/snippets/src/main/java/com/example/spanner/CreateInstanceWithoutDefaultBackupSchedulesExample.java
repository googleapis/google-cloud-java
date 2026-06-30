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

// [START spanner_create_instance_without_default_backup_schedule]

import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient;
import com.google.spanner.admin.instance.v1.CreateInstanceRequest;
import com.google.spanner.admin.instance.v1.Instance;
import com.google.spanner.admin.instance.v1.InstanceConfigName;
import com.google.spanner.admin.instance.v1.ProjectName;
import java.util.concurrent.ExecutionException;

class CreateInstanceWithoutDefaultBackupSchedulesExample {

  static void createInstanceWithoutDefaultBackupSchedules() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    createInstanceWithoutDefaultBackupSchedules(projectId, instanceId);
  }

  static void createInstanceWithoutDefaultBackupSchedules(String projectId, String instanceId) {
    // Set Instance configuration.
    int nodeCount = 2;
    String displayName = "Descriptive name";

    // Create an Instance object that will be used to create the instance.
    Instance instance =
        Instance.newBuilder()
            .setDisplayName(displayName)
            .setDefaultBackupScheduleType(Instance.DefaultBackupScheduleType.NONE)
            .setNodeCount(nodeCount)
            .setConfig(InstanceConfigName.of(projectId, "regional-us-east4").toString())
            .build();

    try (Spanner spanner =
            SpannerOptions.newBuilder().setProjectId(projectId).build().getService();
        InstanceAdminClient instanceAdminClient = spanner.createInstanceAdminClient()) {

      // Wait for the createInstance operation to finish.
      Instance createdInstance =
          instanceAdminClient
              .createInstanceAsync(
                  CreateInstanceRequest.newBuilder()
                      .setParent(ProjectName.of(projectId).toString())
                      .setInstanceId(instanceId)
                      .setInstance(instance)
                      .build())
              .get();
      System.out.printf("Instance %s was successfully created%n", createdInstance.getName());
    } catch (ExecutionException e) {
      System.out.printf(
          "Error: Creating instance %s failed with error message %s%n",
          instance.getName(), e.getMessage());
    } catch (InterruptedException e) {
      System.out.println("Error: Waiting for createInstance operation to finish was interrupted");
    }
  }
}
// [END spanner_create_instance_without_default_backup_schedule]
