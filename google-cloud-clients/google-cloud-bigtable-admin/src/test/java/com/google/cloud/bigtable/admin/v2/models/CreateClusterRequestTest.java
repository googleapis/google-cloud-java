/*
 * Copyright 2018 Google LLC
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

import com.google.bigtable.admin.v2.ProjectName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CreateClusterRequestTest {
  @Test
  public void testProductionSingle() {
    CreateInstanceRequest input =
        CreateInstanceRequest.of("my-instance")
            .setType(Instance.Type.PRODUCTION)
            .addCluster("cluster1", "us-east1-c", 3, StorageType.SSD);

    com.google.bigtable.admin.v2.CreateInstanceRequest actual =
        input.toProto(ProjectName.of("my-project"));

    com.google.bigtable.admin.v2.CreateInstanceRequest expected =
        com.google.bigtable.admin.v2.CreateInstanceRequest.newBuilder()
            .setParent(ProjectName.of("my-project").toString())
            .setInstanceId("my-instance")
            .setInstance(
                com.google.bigtable.admin.v2.Instance.newBuilder()
                    .setDisplayName("my-instance")
                    .setType(com.google.bigtable.admin.v2.Instance.Type.PRODUCTION))
            .putClusters(
                "cluster1",
                com.google.bigtable.admin.v2.Cluster.newBuilder()
                    .setLocation("projects/my-project/locations/us-east1-c")
                    .setServeNodes(3)
                    .setDefaultStorageType(com.google.bigtable.admin.v2.StorageType.SSD)
                    .build())
            .build();

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testProductionReplication() {
    CreateInstanceRequest input =
        CreateInstanceRequest.of("my-instance")
            .setType(Instance.Type.PRODUCTION)
            .addCluster("cluster1", "us-east1-c", 3, StorageType.SSD)
            .addCluster("cluster2", "us-east1-a", 3, StorageType.SSD);

    com.google.bigtable.admin.v2.CreateInstanceRequest actual =
        input.toProto(ProjectName.of("my-project"));

    com.google.bigtable.admin.v2.CreateInstanceRequest expected =
        com.google.bigtable.admin.v2.CreateInstanceRequest.newBuilder()
            .setParent(ProjectName.of("my-project").toString())
            .setInstanceId("my-instance")
            .setInstance(
                com.google.bigtable.admin.v2.Instance.newBuilder()
                    .setDisplayName("my-instance")
                    .setType(com.google.bigtable.admin.v2.Instance.Type.PRODUCTION))
            .putClusters(
                "cluster1",
                com.google.bigtable.admin.v2.Cluster.newBuilder()
                    .setLocation("projects/my-project/locations/us-east1-c")
                    .setServeNodes(3)
                    .setDefaultStorageType(com.google.bigtable.admin.v2.StorageType.SSD)
                    .build())
            .putClusters(
                "cluster2",
                com.google.bigtable.admin.v2.Cluster.newBuilder()
                    .setLocation("projects/my-project/locations/us-east1-a")
                    .setServeNodes(3)
                    .setDefaultStorageType(com.google.bigtable.admin.v2.StorageType.SSD)
                    .build())
            .build();

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testDevelopment() {
    CreateInstanceRequest input =
        CreateInstanceRequest.of("my-instance")
            .setType(Instance.Type.DEVELOPMENT)
            .addCluster("cluster1", "us-east1-c", 1, StorageType.SSD);

    com.google.bigtable.admin.v2.CreateInstanceRequest actual =
        input.toProto(ProjectName.of("my-project"));

    com.google.bigtable.admin.v2.CreateInstanceRequest expected =
        com.google.bigtable.admin.v2.CreateInstanceRequest.newBuilder()
            .setParent(ProjectName.of("my-project").toString())
            .setInstanceId("my-instance")
            .setInstance(
                com.google.bigtable.admin.v2.Instance.newBuilder()
                    .setDisplayName("my-instance")
                    .setType(com.google.bigtable.admin.v2.Instance.Type.DEVELOPMENT))
            .putClusters(
                "cluster1",
                com.google.bigtable.admin.v2.Cluster.newBuilder()
                    .setLocation("projects/my-project/locations/us-east1-c")
                    .setServeNodes(1)
                    .setDefaultStorageType(com.google.bigtable.admin.v2.StorageType.SSD)
                    .build())
            .build();

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testOptionalFields() {
    CreateInstanceRequest input =
        CreateInstanceRequest.of("my-instance")
            .setDisplayName("custom display name")
            .addLabel("my label", "with some value")
            .addLabel("my other label", "with some value")
            .setType(Instance.Type.DEVELOPMENT)
            .addCluster("cluster1", "us-east1-c", 1, StorageType.SSD);

    com.google.bigtable.admin.v2.CreateInstanceRequest actual =
        input.toProto(ProjectName.of("my-project"));

    com.google.bigtable.admin.v2.CreateInstanceRequest expected =
        com.google.bigtable.admin.v2.CreateInstanceRequest.newBuilder()
            .setParent(ProjectName.of("my-project").toString())
            .setInstanceId("my-instance")
            .setInstance(
                com.google.bigtable.admin.v2.Instance.newBuilder()
                    .setDisplayName("custom display name")
                    .putLabels("my label", "with some value")
                    .putLabels("my other label", "with some value")
                    .setType(com.google.bigtable.admin.v2.Instance.Type.DEVELOPMENT))
            .putClusters(
                "cluster1",
                com.google.bigtable.admin.v2.Cluster.newBuilder()
                    .setLocation("projects/my-project/locations/us-east1-c")
                    .setServeNodes(1)
                    .setDefaultStorageType(com.google.bigtable.admin.v2.StorageType.SSD)
                    .build())
            .build();

    assertThat(actual).isEqualTo(expected);
  }
}
