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

package com.google.cloud.spanner.it;

import static com.google.cloud.spanner.testing.EmulatorSpannerHelper.isUsingEmulator;
import static com.google.cloud.spanner.testing.ExperimentalHostHelper.isExperimentalHost;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assume.assumeFalse;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.spanner.Instance;
import com.google.cloud.spanner.InstanceAdminClient;
import com.google.cloud.spanner.InstanceConfig;
import com.google.cloud.spanner.InstanceInfo;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.common.collect.Iterators;
import com.google.spanner.admin.instance.v1.AutoscalingConfig;
import com.google.spanner.admin.instance.v1.UpdateInstanceMetadata;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration tests for {@link com.google.cloud.spanner.InstanceAdminClient}. */
@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITInstanceAdminTest {

  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv(true);
  static InstanceAdminClient instanceClient;

  @BeforeClass
  public static void setUp() {
    assumeFalse(
        "instance / instanceConfig operations are not supported on experimental host",
        isExperimentalHost());
    instanceClient = env.getTestHelper().getClient().getInstanceAdminClient();
  }

  @Test
  public void instanceConfigOperations() {
    List<InstanceConfig> configs = new ArrayList<>();
    Iterators.addAll(configs, instanceClient.listInstanceConfigs().iterateAll().iterator());
    assertThat(configs.isEmpty()).isFalse();
    InstanceConfig config =
        instanceClient.getInstanceConfig(configs.get(0).getId().getInstanceConfig());
    assertThat(config.getId()).isEqualTo(configs.get(0).getId());
    config = config.reload();
    assertThat(config.getId()).isEqualTo(configs.get(0).getId());
  }

  @Ignore("Feature is not yet enabled in production")
  @Test
  public void instanceConfigLeaderOptions() {
    assumeFalse("The emulator does not support leader options", isUsingEmulator());
    List<InstanceConfig> configs = new ArrayList<>();
    Iterators.addAll(configs, instanceClient.listInstanceConfigs().iterateAll().iterator());

    configs.forEach(config -> assertThat(config.getReplicas()).isNotEmpty());
    configs.forEach(config -> assertThat(config.getLeaderOptions()).isNotEmpty());
  }

  @Test
  public void listInstances() {
    assumeFalse("The emulator does not support filtering on instances", isUsingEmulator());

    Instance instance =
        Iterators.getOnlyElement(
            instanceClient
                .listInstances(
                    Options.filter(
                        "name:instances/" + env.getTestHelper().getInstanceId().getInstance()))
                .iterateAll()
                .iterator());
    assertThat(instance.getId()).isEqualTo(env.getTestHelper().getInstanceId());
  }

  @Test
  public void updateInstance() throws Exception {
    assumeFalse("The emulator does not support updating instances", isUsingEmulator());

    Instance instance =
        instanceClient.getInstance(env.getTestHelper().getInstanceId().getInstance());
    String rand = new Random().nextInt() + "";
    String newDisplayName = "instance test" + rand;
    InstanceInfo toUpdate =
        InstanceInfo.newBuilder(env.getTestHelper().getInstanceId())
            .setDisplayName(newDisplayName)
            .setNodeCount(instance.getNodeCount() + 1)
            .build();
    // Only update display name
    OperationFuture<Instance, UpdateInstanceMetadata> op =
        instanceClient.updateInstance(toUpdate, InstanceInfo.InstanceField.DISPLAY_NAME);
    Instance newInstance = op.get();
    assertThat(newInstance.getNodeCount()).isEqualTo(instance.getNodeCount());
    assertThat(newInstance.getDisplayName()).isEqualTo(newDisplayName);

    Instance newInstanceFromGet =
        instanceClient.getInstance(env.getTestHelper().getInstanceId().getInstance());
    assertThat(newInstanceFromGet).isEqualTo(newInstance);

    toUpdate =
        InstanceInfo.newBuilder(instance.getId()).setDisplayName(instance.getDisplayName()).build();
    instanceClient.updateInstance(toUpdate, InstanceInfo.InstanceField.DISPLAY_NAME).get();
  }

  @Test
  public void updateInstanceWithAutoscalingConfig() throws Exception {
    assumeFalse(
        "The emulator does not support updating instances with autoscaler", isUsingEmulator());

    Instance instance =
        instanceClient.getInstance(env.getTestHelper().getInstanceId().getInstance());
    AutoscalingConfig autoscalingConfig =
        AutoscalingConfig.newBuilder()
            .setAutoscalingLimits(
                AutoscalingConfig.AutoscalingLimits.newBuilder()
                    .setMinProcessingUnits(1000)
                    .setMaxProcessingUnits(2000))
            .setAutoscalingTargets(
                AutoscalingConfig.AutoscalingTargets.newBuilder()
                    .setHighPriorityCpuUtilizationPercent(65)
                    .setStorageUtilizationPercent(95))
            .build();
    InstanceInfo toUpdate =
        InstanceInfo.newBuilder(env.getTestHelper().getInstanceId())
            .setNodeCount(0)
            .setAutoscalingConfig(autoscalingConfig)
            .build();
    OperationFuture<Instance, UpdateInstanceMetadata> op =
        instanceClient.updateInstance(toUpdate, InstanceInfo.InstanceField.AUTOSCALING_CONFIG);
    Instance newInstance = op.get();
    assertThat(newInstance.getAutoscalingConfig()).isEqualTo(autoscalingConfig);

    Instance newInstanceFromGet =
        instanceClient.getInstance(env.getTestHelper().getInstanceId().getInstance());
    assertThat(newInstanceFromGet).isEqualTo(newInstance);

    // Revert back to the instance original state.
    toUpdate =
        InstanceInfo.newBuilder(instance.getId())
            .setAutoscalingConfig(null)
            .setNodeCount(instance.getNodeCount())
            .build();
    instanceClient
        .updateInstance(
            toUpdate,
            InstanceInfo.InstanceField.AUTOSCALING_CONFIG,
            InstanceInfo.InstanceField.NODE_COUNT)
        .get();
  }

  @Test
  public void updateInstanceViaEntity() throws Exception {
    assumeFalse("The emulator does not support updating instances", isUsingEmulator());

    Instance instance =
        instanceClient.getInstance(env.getTestHelper().getInstanceId().getInstance());
    String rand = new Random().nextInt() + "";
    String newDisplayName = "instance test" + rand;
    Instance toUpdate =
        instance.toBuilder()
            .setDisplayName(newDisplayName)
            .setNodeCount(instance.getNodeCount() + 1)
            .build();
    // Only update display name
    OperationFuture<Instance, UpdateInstanceMetadata> op =
        toUpdate.update(InstanceInfo.InstanceField.DISPLAY_NAME);
    Instance newInstance = op.get();
    assertThat(newInstance.getNodeCount()).isEqualTo(instance.getNodeCount());
    assertThat(newInstance.getDisplayName()).isEqualTo(newDisplayName);

    Instance newInstanceFromGet = instance.reload();
    assertThat(newInstanceFromGet).isEqualTo(newInstance);

    toUpdate = newInstance.toBuilder().setDisplayName(instance.getDisplayName()).build();
    toUpdate.update(InstanceInfo.InstanceField.DISPLAY_NAME).get();
  }
}
