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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.Timestamp;
import com.google.common.testing.EqualsTester;
import com.google.spanner.admin.instance.v1.AutoscalingConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class InstanceInfoTest {

  @Test
  public void testEmptyBuilder() {
    InstanceId id = InstanceId.of("test-project", "test-instance");
    InstanceInfo.Builder builder = InstanceInfo.newBuilder(id);
    InstanceInfo info = builder.build();
    assertNull(info.getDisplayName());
    assertEquals(InstanceId.of("test-project", "test-instance"), info.getId());
    assertNull(info.getInstanceConfigId());
    assertNull(info.getState());
    assertEquals(0, info.getNodeCount());
    assertEquals(0, info.getProcessingUnits());
    assertTrue(info.getLabels().isEmpty());
    assertNull(info.getUpdateTime());
    assertNull(info.getCreateTime());
    assertNull(info.getAutoscalingConfig());
  }

  @Test
  public void testBuildInstanceInfo() {
    InstanceId id = new InstanceId("test-project", "test-instance");
    InstanceConfigId configId = new InstanceConfigId("test-project", "test-instance-config");
    AutoscalingConfig autoscalingConfig =
        AutoscalingConfig.newBuilder()
            .setAutoscalingLimits(
                AutoscalingConfig.AutoscalingLimits.newBuilder()
                    .setMinProcessingUnits(1000)
                    .setMaxProcessingUnits(5000))
            .setAutoscalingTargets(
                AutoscalingConfig.AutoscalingTargets.newBuilder()
                    .setHighPriorityCpuUtilizationPercent(65)
                    .setStorageUtilizationPercent(95))
            .build();

    InstanceInfo info =
        InstanceInfo.newBuilder(id)
            .setInstanceConfigId(configId)
            .setDisplayName("test instance")
            .setNodeCount(1)
            .setProcessingUnits(2000)
            .setAutoscalingConfig(autoscalingConfig)
            .setState(InstanceInfo.State.READY)
            .addLabel("env", "prod")
            .addLabel("region", "us")
            .setUpdateTime(Timestamp.ofTimeMicroseconds(86000))
            .setCreateTime(Timestamp.ofTimeMicroseconds(46000))
            .build();
    assertThat(info.getId()).isEqualTo(id);
    assertThat(info.getInstanceConfigId()).isEqualTo(configId);
    assertThat(info.getDisplayName()).isEqualTo("test instance");
    assertThat(info.getNodeCount()).isEqualTo(1);
    assertThat(info.getProcessingUnits()).isEqualTo(2000);
    assertThat(info.getAutoscalingConfig()).isEqualTo(autoscalingConfig);
    assertThat(info.getState()).isEqualTo(InstanceInfo.State.READY);
    assertThat(info.getLabels()).containsExactly("env", "prod", "region", "us");
    assertEquals(Timestamp.ofTimeMicroseconds(86000), info.getUpdateTime());
    assertEquals(Timestamp.ofTimeMicroseconds(46000), info.getCreateTime());

    AutoscalingConfig newAutoscalingConfig =
        autoscalingConfig.toBuilder()
            .setAutoscalingLimits(
                AutoscalingConfig.AutoscalingLimits.newBuilder().setMinNodes(10).setMaxNodes(100))
            .build();
    info =
        info.toBuilder()
            .setDisplayName("new test instance")
            .setAutoscalingConfig(newAutoscalingConfig)
            .build();
    assertThat(info.getId()).isEqualTo(id);
    assertThat(info.getInstanceConfigId()).isEqualTo(configId);
    assertThat(info.getDisplayName()).isEqualTo("new test instance");
    assertThat(info.getNodeCount()).isEqualTo(1);
    assertThat(info.getProcessingUnits()).isEqualTo(2000);
    assertThat(info.getAutoscalingConfig()).isEqualTo(newAutoscalingConfig);
    assertThat(info.getState()).isEqualTo(InstanceInfo.State.READY);
    assertThat(info.getLabels()).containsExactly("env", "prod", "region", "us");
    assertEquals(Timestamp.ofTimeMicroseconds(86000), info.getUpdateTime());
    assertEquals(Timestamp.ofTimeMicroseconds(46000), info.getCreateTime());
  }

  @Test
  public void testToBuilder() {
    InstanceId id = new InstanceId("test-project", "test-instance");
    InstanceConfigId configId = new InstanceConfigId("test-project", "test-instance-config");
    AutoscalingConfig autoscalingConfig =
        AutoscalingConfig.newBuilder()
            .setAutoscalingLimits(
                AutoscalingConfig.AutoscalingLimits.newBuilder()
                    .setMinProcessingUnits(1000)
                    .setMaxProcessingUnits(5000))
            .setAutoscalingTargets(
                AutoscalingConfig.AutoscalingTargets.newBuilder()
                    .setHighPriorityCpuUtilizationPercent(65)
                    .setStorageUtilizationPercent(95))
            .build();
    InstanceInfo info =
        InstanceInfo.newBuilder(id)
            .setInstanceConfigId(configId)
            .setDisplayName("test instance")
            .setNodeCount(1)
            .setProcessingUnits(2000)
            .setAutoscalingConfig(autoscalingConfig)
            .setState(InstanceInfo.State.READY)
            .addLabel("env", "prod")
            .addLabel("region", "us")
            .setUpdateTime(Timestamp.ofTimeMicroseconds(86000))
            .setCreateTime(Timestamp.ofTimeMicroseconds(46000))
            .build();

    InstanceInfo rebuilt = info.toBuilder().setDisplayName("new test instance").build();
    assertThat(rebuilt.getId()).isEqualTo(id);
    assertThat(rebuilt.getInstanceConfigId()).isEqualTo(configId);
    assertThat(rebuilt.getDisplayName()).isEqualTo("new test instance");
    assertThat(rebuilt.getNodeCount()).isEqualTo(1);
    assertThat(rebuilt.getProcessingUnits()).isEqualTo(2000);
    assertThat(info.getAutoscalingConfig()).isEqualTo(autoscalingConfig);
    assertThat(rebuilt.getState()).isEqualTo(InstanceInfo.State.READY);
    assertThat(rebuilt.getLabels()).containsExactly("env", "prod", "region", "us");
    assertEquals(Timestamp.ofTimeMicroseconds(86000), rebuilt.getUpdateTime());
    assertEquals(Timestamp.ofTimeMicroseconds(46000), rebuilt.getCreateTime());
  }

  @Test
  public void testEquals() {
    InstanceId id = new InstanceId("test-project", "test-instance");
    InstanceConfigId configId1 = new InstanceConfigId("test-project", "test-instance-config");
    InstanceConfigId configId2 = new InstanceConfigId("test-project", "other-test-instance-config");

    AutoscalingConfig autoscalingConfig1 =
        AutoscalingConfig.newBuilder()
            .setAutoscalingLimits(
                AutoscalingConfig.AutoscalingLimits.newBuilder()
                    .setMinProcessingUnits(1000)
                    .setMaxProcessingUnits(5000))
            .setAutoscalingTargets(
                AutoscalingConfig.AutoscalingTargets.newBuilder()
                    .setHighPriorityCpuUtilizationPercent(65)
                    .setStorageUtilizationPercent(95))
            .build();

    AutoscalingConfig autoscalingConfig2 =
        autoscalingConfig1.toBuilder()
            .setAutoscalingLimits(
                autoscalingConfig1.getAutoscalingLimits().toBuilder()
                    .setMinNodes(50)
                    .setMaxNodes(100))
            .build();

    InstanceInfo instance =
        InstanceInfo.newBuilder(id)
            .setInstanceConfigId(configId1)
            .setDisplayName("test instance")
            .setNodeCount(1)
            .setProcessingUnits(2000)
            .setAutoscalingConfig(autoscalingConfig1)
            .setState(InstanceInfo.State.READY)
            .addLabel("env", "prod")
            .addLabel("region", "us")
            .setUpdateTime(Timestamp.ofTimeMicroseconds(86000))
            .setCreateTime(Timestamp.ofTimeMicroseconds(46000))
            .build();
    InstanceInfo instance2 =
        InstanceInfo.newBuilder(id)
            .setInstanceConfigId(configId1)
            .setDisplayName("test instance")
            .setNodeCount(1)
            .setProcessingUnits(2000)
            .setAutoscalingConfig(autoscalingConfig1)
            .setState(InstanceInfo.State.READY)
            .addLabel("region", "us")
            .addLabel("env", "prod")
            .setUpdateTime(Timestamp.ofTimeMicroseconds(86000))
            .setCreateTime(Timestamp.ofTimeMicroseconds(46000))
            .build();
    InstanceInfo instance3 =
        InstanceInfo.newBuilder(id)
            .setInstanceConfigId(configId2)
            .setDisplayName("other test instance")
            .setNodeCount(1)
            .setProcessingUnits(2000)
            .setState(InstanceInfo.State.READY)
            .addLabel("env", "prod")
            .setUpdateTime(Timestamp.ofTimeMicroseconds(8000))
            .setCreateTime(Timestamp.ofTimeMicroseconds(4000))
            .build();
    InstanceInfo instance4 =
        InstanceInfo.newBuilder(id)
            .setInstanceConfigId(configId2)
            .setDisplayName("other test instance")
            .setNodeCount(1)
            .setProcessingUnits(2000)
            .setAutoscalingConfig(autoscalingConfig2)
            .setState(InstanceInfo.State.READY)
            .addLabel("env", "prod")
            .setUpdateTime(Timestamp.ofTimeMicroseconds(8000))
            .setCreateTime(Timestamp.ofTimeMicroseconds(4000))
            .build();
    EqualsTester tester = new EqualsTester();
    tester.addEqualityGroup(instance, instance2);
    tester.addEqualityGroup(instance3);
    tester.addEqualityGroup(instance4);
    tester.testEquals();
  }
}
