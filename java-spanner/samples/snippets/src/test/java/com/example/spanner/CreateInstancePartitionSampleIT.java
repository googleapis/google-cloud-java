/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.spanner;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.spanner.InstanceAdminClient;
import com.google.cloud.spanner.InstanceConfigId;
import com.google.cloud.spanner.InstanceId;
import com.google.cloud.spanner.InstanceInfo;
import com.google.spanner.admin.instance.v1.Instance.Edition;
import com.google.spanner.admin.instance.v1.InstancePartitionName;
import org.junit.Test;

public class CreateInstancePartitionSampleIT extends SampleTestBaseV2 {

  @Test
  public void testCreateInstancePartition() throws Exception {
    String instanceId = idGenerator.generateInstanceId();
    InstanceAdminClient instanceAdminClient = spanner.getInstanceAdminClient();
    instanceAdminClient
        .createInstance(
            InstanceInfo.newBuilder(InstanceId.of(projectId, instanceId))
                .setEdition(Edition.ENTERPRISE_PLUS)
                .setDisplayName("Geo-partitioning test instance")
                .setInstanceConfigId(InstanceConfigId.of(projectId, "regional-us-central1"))
                .setNodeCount(1)
                .build())
        .get();

    String instancePartitionId = "my-instance-partition";
    String out =
        SampleRunner.runSample(
            () ->
                CreateInstancePartitionSample.createInstancePartition(
                    projectId, instanceId, instancePartitionId));
    assertThat(out)
        .contains(
            String.format(
                "Instance partition %s",
                InstancePartitionName.of(projectId, instanceId, instancePartitionId).toString()));
  }
}
