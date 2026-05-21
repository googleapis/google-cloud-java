/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.admin.v2.models;

import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.admin.v2.AutoscalingLimits;
import com.google.bigtable.admin.v2.AutoscalingTargets;
import com.google.bigtable.admin.v2.Cluster;
import com.google.bigtable.admin.v2.PartialUpdateClusterRequest;
import com.google.cloud.bigtable.admin.v2.internal.NameUtil;
import com.google.protobuf.FieldMask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ClusterAutoscalingConfigTest {
  private static final String PROJECT_ID = "my-project";
  private static final String INSTANCE_ID = "my-instance";
  private static final String CLUSTER_ID = "my-cluster";

  @Test
  public void testToProto() {
    ClusterAutoscalingConfig request =
        ClusterAutoscalingConfig.of(INSTANCE_ID, CLUSTER_ID)
            .setMaxNodes(10)
            .setMinNodes(3)
            .setCpuUtilizationTargetPercent(30);

    PartialUpdateClusterRequest partialUpdateClusterRequestProto = request.toProto(PROJECT_ID);

    AutoscalingTargets autoscalingTargets =
        AutoscalingTargets.newBuilder().setCpuUtilizationPercent(30).build();
    AutoscalingLimits autoscalingLimits =
        AutoscalingLimits.newBuilder().setMinServeNodes(3).setMaxServeNodes(10).build();
    Cluster.ClusterAutoscalingConfig clusterAutoscalingConfig =
        Cluster.ClusterAutoscalingConfig.newBuilder()
            .setAutoscalingTargets(autoscalingTargets)
            .setAutoscalingLimits(autoscalingLimits)
            .build();
    Cluster.ClusterConfig clusterConfig =
        Cluster.ClusterConfig.newBuilder()
            .setClusterAutoscalingConfig(clusterAutoscalingConfig)
            .build();
    Cluster cluster =
        Cluster.newBuilder()
            .setName(NameUtil.formatClusterName(PROJECT_ID, INSTANCE_ID, CLUSTER_ID))
            .setClusterConfig(clusterConfig)
            .build();
    PartialUpdateClusterRequest requestProto =
        PartialUpdateClusterRequest.newBuilder()
            .setUpdateMask(
                FieldMask.newBuilder()
                    .addPaths(
                        "cluster_config.cluster_autoscaling_config.autoscaling_limits.max_serve_nodes")
                    .addPaths(
                        "cluster_config.cluster_autoscaling_config.autoscaling_limits.min_serve_nodes")
                    .addPaths(
                        "cluster_config.cluster_autoscaling_config.autoscaling_targets.cpu_utilization_percent"))
            .setCluster(cluster)
            .build();
    assertThat(partialUpdateClusterRequestProto).isEqualTo(requestProto);
  }

  @Test
  public void testEquality() {
    ClusterAutoscalingConfig request =
        ClusterAutoscalingConfig.of(INSTANCE_ID, CLUSTER_ID)
            .setCpuUtilizationTargetPercent(10)
            .setMaxNodes(2)
            .setMinNodes(1);
    assertThat(request)
        .isEqualTo(
            ClusterAutoscalingConfig.of(INSTANCE_ID, CLUSTER_ID)
                .setCpuUtilizationTargetPercent(10)
                .setMaxNodes(2)
                .setMinNodes(1));
    assertThat(request)
        .isNotEqualTo(
            ClusterAutoscalingConfig.of(INSTANCE_ID, CLUSTER_ID)
                .setCpuUtilizationTargetPercent(1)
                .setMaxNodes(2)
                .setMinNodes(1));
  }

  @Test
  public void testHashCode() {
    ClusterAutoscalingConfig request =
        ClusterAutoscalingConfig.of(INSTANCE_ID, CLUSTER_ID).setMaxNodes(10);
    assertThat(request.hashCode())
        .isEqualTo(ClusterAutoscalingConfig.of(INSTANCE_ID, CLUSTER_ID).setMaxNodes(10).hashCode());
    assertThat(request.hashCode())
        .isNotEqualTo(
            ClusterAutoscalingConfig.of(INSTANCE_ID, CLUSTER_ID).setMinNodes(50).hashCode());
  }
}
