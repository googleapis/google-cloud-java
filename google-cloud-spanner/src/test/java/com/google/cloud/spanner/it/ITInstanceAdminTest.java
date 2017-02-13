/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.spanner.Instance;
import com.google.cloud.spanner.InstanceAdminClient;
import com.google.cloud.spanner.InstanceConfig;
import com.google.cloud.spanner.InstanceInfo;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Operation;
import com.google.cloud.spanner.Options;
import com.google.common.collect.Iterators;
import com.google.spanner.admin.instance.v1.UpdateInstanceMetadata;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration tests for {@link com.google.cloud.spanner.InstanceAdminClient}. */
@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
public class ITInstanceAdminTest {
  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  @Rule public ExpectedException expectedException = ExpectedException.none();
  InstanceAdminClient instanceClient;

  @Before
  public void setUp() {
    instanceClient = env.getTestHelper().getClient().getInstanceAdminClient();
  }

  @Test
  public void instanceConfigOperations() {
    List<InstanceConfig> configs = new ArrayList<>();
    Iterators.addAll(configs, instanceClient.listInstanceConfigs().iterateAll());
    assertThat(configs.isEmpty()).isFalse();
    InstanceConfig config =
        instanceClient.getInstanceConfig(configs.get(0).getId().getInstanceConfig());
    assertThat(config.getId()).isEqualTo(configs.get(0).getId());
    config = config.reload();
    assertThat(config.getId()).isEqualTo(configs.get(0).getId());
  }

  @Test
  public void listInstances() throws Exception {
    Instance instance =
        Iterators.getOnlyElement(
            instanceClient
                .listInstances(
                    Options.filter(
                        "name:instances/" + env.getTestHelper().getInstanceId().getInstance()))
                .iterateAll());
    assertThat(instance.getId()).isEqualTo(env.getTestHelper().getInstanceId());
  }

  @Test
  public void updateInstance() throws Exception {
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
    Operation<Instance, UpdateInstanceMetadata> op =
        instanceClient.updateInstance(toUpdate, InstanceInfo.InstanceField.DISPLAY_NAME);
    Instance newInstance = op.waitFor().getResult();
    assertThat(newInstance.getNodeCount()).isEqualTo(instance.getNodeCount());
    assertThat(newInstance.getDisplayName()).isEqualTo(newDisplayName);

    Instance newInstanceFromGet =
        instanceClient.getInstance(env.getTestHelper().getInstanceId().getInstance());
    assertThat(newInstanceFromGet).isEqualTo(newInstance);

    toUpdate =
        InstanceInfo.newBuilder(instance.getId()).setDisplayName(instance.getDisplayName()).build();
    instanceClient.updateInstance(toUpdate, InstanceInfo.InstanceField.DISPLAY_NAME).waitFor();
  }

  @Test
  public void updateInstanceViaEntity() throws Exception {
    Instance instance =
        instanceClient.getInstance(env.getTestHelper().getInstanceId().getInstance());
    String rand = new Random().nextInt() + "";
    String newDisplayName = "instance test" + rand;
    Instance toUpdate =
        instance
            .toBuilder()
            .setDisplayName(newDisplayName)
            .setNodeCount(instance.getNodeCount() + 1)
            .build();
    // Only update display name
    Operation<Instance, UpdateInstanceMetadata> op =
        toUpdate.update(InstanceInfo.InstanceField.DISPLAY_NAME);
    Instance newInstance = op.waitFor().getResult();
    assertThat(newInstance.getNodeCount()).isEqualTo(instance.getNodeCount());
    assertThat(newInstance.getDisplayName()).isEqualTo(newDisplayName);

    Instance newInstanceFromGet = instance.reload();
    assertThat(newInstanceFromGet).isEqualTo(newInstance);

    toUpdate = newInstance.toBuilder().setDisplayName(instance.getDisplayName()).build();
    toUpdate.update(InstanceInfo.InstanceField.DISPLAY_NAME).waitFor();
  }
}
