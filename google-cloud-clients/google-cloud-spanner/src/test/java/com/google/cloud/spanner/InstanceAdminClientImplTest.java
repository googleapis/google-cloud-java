/*
 * Copyright 2017 Google LLC
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

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.cloud.spanner.spi.v1.SpannerRpc.Paginated;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.protobuf.FieldMask;
import com.google.spanner.admin.instance.v1.CreateInstanceMetadata;
import com.google.spanner.admin.instance.v1.InstanceConfig;
import com.google.spanner.admin.instance.v1.UpdateInstanceMetadata;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;

/** Unit tests for {@link com.google.cloud.spanner.SpannerImpl.InstanceAdminClientImpl}. */
@RunWith(JUnit4.class)
public class InstanceAdminClientImplTest {
  private static final String PROJECT_ID = "my-project";
  private static final String INSTANCE_ID = "my-instance";
  private static final String INSTANCE_NAME = "projects/my-project/instances/my-instance";
  private static final String INSTANCE_NAME2 = "projects/my-project/instances/my-instance2";
  private static final String CONFIG_ID = "my-config";
  private static final String CONFIG_NAME = "projects/my-project/instanceConfigs/my-config";
  private static final String CONFIG_NAME2 = "projects/my-project/instanceConfigs/my-config2";

  @Mock SpannerRpc rpc;
  @Mock DatabaseAdminClient dbClient;
  SpannerImpl.InstanceAdminClientImpl client;

  @Before
  public void setUp() {
    initMocks(this);
    client = new SpannerImpl.InstanceAdminClientImpl(PROJECT_ID, rpc, dbClient);
  }

  @Test
  public void getInstanceConfig() {
    when(rpc.getInstanceConfig(CONFIG_NAME))
        .thenReturn(InstanceConfig.newBuilder().setName(CONFIG_NAME).build());
    assertThat(client.getInstanceConfig(CONFIG_ID).getId().getName()).isEqualTo(CONFIG_NAME);
  }

  @Test
  public void listInstanceConfigs() {
    String nextToken = "token";
    when(rpc.listInstanceConfigs(1, null))
        .thenReturn(
            new Paginated<InstanceConfig>(
                ImmutableList.of(InstanceConfig.newBuilder().setName(CONFIG_NAME).build()),
                nextToken));
    when(rpc.listInstanceConfigs(1, nextToken))
        .thenReturn(
            new Paginated<InstanceConfig>(
                ImmutableList.of(InstanceConfig.newBuilder().setName(CONFIG_NAME2).build()), ""));
    List<com.google.cloud.spanner.InstanceConfig> configs =
        Lists.newArrayList(client.listInstanceConfigs(Options.pageSize(1)).iterateAll());
    assertThat(configs.get(0).getId().getName()).isEqualTo(CONFIG_NAME);
    assertThat(configs.get(1).getId().getName()).isEqualTo(CONFIG_NAME2);
    assertThat(configs.size()).isEqualTo(2);
  }

  private com.google.spanner.admin.instance.v1.Instance getInstanceProto() {
    return com.google.spanner.admin.instance.v1.Instance.newBuilder()
        .setConfig(CONFIG_NAME)
        .setName(INSTANCE_NAME)
        .setNodeCount(1)
        .build();
  }

  private com.google.spanner.admin.instance.v1.Instance getAnotherInstanceProto() {
    return com.google.spanner.admin.instance.v1.Instance.newBuilder()
        .setConfig(CONFIG_NAME)
        .setName(INSTANCE_NAME2)
        .setNodeCount(1)
        .build();
  }

  @Test
  public void createInstance() {
    when(rpc.createInstance("projects/" + PROJECT_ID, INSTANCE_ID, getInstanceProto()))
        .thenReturn(
            com.google.longrunning.Operation.newBuilder()
                .setDone(true)
                .setName(INSTANCE_NAME + "/operations/op")
                .setResponse(DatabaseAdminClientImplTest.toAny(getInstanceProto()))
                .build());
    Operation<Instance, CreateInstanceMetadata> op =
        client.createInstance(
            InstanceInfo.newBuilder(InstanceId.of(PROJECT_ID, INSTANCE_ID))
                .setInstanceConfigId(InstanceConfigId.of(PROJECT_ID, CONFIG_ID))
                .setNodeCount(1)
                .build());
    assertThat(op.isDone()).isTrue();
    assertThat(op.getResult().getId().getName()).isEqualTo(INSTANCE_NAME);
  }

  @Test
  public void getInstance() {
    when(rpc.getInstance(INSTANCE_NAME)).thenReturn(getInstanceProto());
    assertThat(client.getInstance(INSTANCE_ID).getId().getName()).isEqualTo(INSTANCE_NAME);
  }

  @Test
  public void dropInstance() {
    client.deleteInstance(INSTANCE_ID);
    verify(rpc).deleteInstance(INSTANCE_NAME);
  }

  @Test
  public void updateInstanceMetadata() {
    com.google.spanner.admin.instance.v1.Instance instance =
        com.google.spanner.admin.instance.v1.Instance.newBuilder()
            .setName(INSTANCE_NAME)
            .setConfig(CONFIG_NAME)
            .setNodeCount(2)
            .build();
    when(rpc.updateInstance(instance, FieldMask.newBuilder().addPaths("node_count").build()))
        .thenReturn(
            com.google.longrunning.Operation.newBuilder()
                .setDone(true)
                .setName(INSTANCE_NAME + "/operations/op")
                .setResponse(DatabaseAdminClientImplTest.toAny(instance))
                .build());
    InstanceInfo instanceInfo =
        InstanceInfo.newBuilder(InstanceId.of(INSTANCE_NAME))
            .setInstanceConfigId(InstanceConfigId.of(CONFIG_NAME))
            .setNodeCount(2)
            .build();
    Operation<Instance, UpdateInstanceMetadata> op =
        client.updateInstance(instanceInfo, InstanceInfo.InstanceField.NODE_COUNT);
    assertThat(op.isDone()).isTrue();
    assertThat(op.getResult().getId().getName()).isEqualTo(INSTANCE_NAME);
  }

  @Test
  public void listInstances() {
    String nextToken = "token";
    String filter = "env:dev";
    when(rpc.listInstances(1, null, filter))
        .thenReturn(
            new Paginated<com.google.spanner.admin.instance.v1.Instance>(
                ImmutableList.of(getInstanceProto()), nextToken));
    when(rpc.listInstances(1, nextToken, filter))
        .thenReturn(
            new Paginated<com.google.spanner.admin.instance.v1.Instance>(
                ImmutableList.of(getAnotherInstanceProto()), ""));
    List<Instance> instances =
        Lists.newArrayList(
            client.listInstances(Options.pageSize(1), Options.filter(filter)).iterateAll());
    assertThat(instances.get(0).getId().getName()).isEqualTo(INSTANCE_NAME);
    assertThat(instances.get(1).getId().getName()).isEqualTo(INSTANCE_NAME2);
    assertThat(instances.size()).isEqualTo(2);
  }
}
