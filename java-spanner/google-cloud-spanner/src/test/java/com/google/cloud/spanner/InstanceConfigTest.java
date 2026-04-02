/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.spanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import com.google.spanner.admin.instance.v1.ReplicaInfo.ReplicaType;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class InstanceConfigTest {

  private InstanceAdminClient client;

  @Before
  public void setUp() {
    client = mock(InstanceAdminClient.class);
  }

  @Test
  public void testInstanceConfigFromProto() {
    final InstanceConfig instanceConfig =
        InstanceConfig.fromProto(
            com.google.spanner.admin.instance.v1.InstanceConfig.newBuilder()
                .setDisplayName("Display Name")
                .setName("projects/my-project/instanceConfigs/my-instance-config")
                .setBaseConfig("projects/my-project/instanceConfigs/custom-base-config")
                .addAllOptionalReplicas(
                    Arrays.asList(
                        com.google.spanner.admin.instance.v1.ReplicaInfo.newBuilder()
                            .setLocation("Optional Replica Location 1")
                            .setType(ReplicaType.READ_ONLY)
                            .setDefaultLeaderLocation(true)
                            .build(),
                        com.google.spanner.admin.instance.v1.ReplicaInfo.newBuilder()
                            .setLocation("Optional Replica Location 2")
                            .setType(ReplicaType.READ_ONLY)
                            .setDefaultLeaderLocation(false)
                            .build()))
                .addAllLeaderOptions(Arrays.asList("Leader Option 1", "Leader Option 2"))
                .addAllReplicas(
                    Arrays.asList(
                        com.google.spanner.admin.instance.v1.ReplicaInfo.newBuilder()
                            .setLocation("Replica Location 1")
                            .setType(ReplicaType.READ_WRITE)
                            .setDefaultLeaderLocation(true)
                            .build(),
                        com.google.spanner.admin.instance.v1.ReplicaInfo.newBuilder()
                            .setLocation("Replica Location 2")
                            .setType(ReplicaType.READ_ONLY)
                            .setDefaultLeaderLocation(false)
                            .build(),
                        com.google.spanner.admin.instance.v1.ReplicaInfo.newBuilder()
                            .setLocation("Replica Location 3")
                            .setType(ReplicaType.WITNESS)
                            .setDefaultLeaderLocation(false)
                            .build()))
                .build(),
            client);

    assertEquals(
        new InstanceConfig(
            new InstanceConfig.Builder(
                    client, InstanceConfigId.of("my-project", "my-instance-config"))
                .setDisplayName("Display Name")
                .setReplicas(
                    Arrays.asList(
                        ReplicaInfo.newBuilder()
                            .setLocation("Replica Location 1")
                            .setType(ReplicaInfo.ReplicaType.READ_WRITE)
                            .setDefaultLeaderLocation(true)
                            .build(),
                        ReplicaInfo.newBuilder()
                            .setLocation("Replica Location 2")
                            .setType(ReplicaInfo.ReplicaType.READ_ONLY)
                            .setDefaultLeaderLocation(false)
                            .build(),
                        ReplicaInfo.newBuilder()
                            .setLocation("Replica Location 3")
                            .setType(ReplicaInfo.ReplicaType.WITNESS)
                            .setDefaultLeaderLocation(false)
                            .build()))
                .setLeaderOptions(Arrays.asList("Leader Option 1", "Leader Option 2"))
                .setOptionalReplicas(
                    Arrays.asList(
                        ReplicaInfo.newBuilder()
                            .setLocation("Optional Replica Location 1")
                            .setType(ReplicaInfo.ReplicaType.READ_ONLY)
                            .setDefaultLeaderLocation(true)
                            .build(),
                        ReplicaInfo.newBuilder()
                            .setLocation("Optional Replica Location 2")
                            .setType(ReplicaInfo.ReplicaType.READ_ONLY)
                            .setDefaultLeaderLocation(false)
                            .build()))
                .setBaseConfig(
                    new InstanceConfigInfo.BuilderImpl(
                            InstanceConfigId.of("my-project", "custom-base-config"))
                        .build())),
        instanceConfig);
  }

  @Test
  public void testInstanceConfigFromProtoWithoutReplicasAndLeaderOptions() {
    final InstanceConfig instanceConfig =
        InstanceConfig.fromProto(
            com.google.spanner.admin.instance.v1.InstanceConfig.newBuilder()
                .setDisplayName("Display Name")
                .setName("projects/my-project/instanceConfigs/my-instance-config")
                .build(),
            client);

    assertEquals(
        new InstanceConfig(
            InstanceConfigId.of("my-project", "my-instance-config"), "Display Name", client),
        instanceConfig);
  }
}
