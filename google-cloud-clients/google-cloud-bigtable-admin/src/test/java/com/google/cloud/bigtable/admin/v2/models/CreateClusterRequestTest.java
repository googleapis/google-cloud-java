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

import com.google.bigtable.admin.v2.Cluster;
import com.google.bigtable.admin.v2.Instance;
import com.google.bigtable.admin.v2.Instance.Type;
import com.google.bigtable.admin.v2.ProjectName;
import com.google.bigtable.admin.v2.StorageType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CreateClusterRequestTest {
  @Test
  public void testProductionSingle() {
    CreateInstanceRequest input = CreateInstanceRequest.of("my-instance")
        .setType(Type.PRODUCTION)
        .addCluster("cluster1", "us-east1-c", 3, StorageType.SSD);

    com.google.bigtable.admin.v2.CreateInstanceRequest actual = input
        .toProto(ProjectName.of("my-project"));

    com.google.bigtable.admin.v2.CreateInstanceRequest expected =
        com.google.bigtable.admin.v2.CreateInstanceRequest.newBuilder()
            .setParent(ProjectName.of("my-project").toString())
            .setInstanceId("my-instance")
            .setInstance(
                Instance.newBuilder()
                    .setDisplayName("my-instance")
                    .setType(Type.PRODUCTION)
            )
            .putClusters("cluster1",
                Cluster.newBuilder()
                    .setLocation("projects/my-project/locations/us-east1-c")
                    .setServeNodes(3)
                    .setDefaultStorageType(StorageType.SSD)
                    .build()
            )
            .build();

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testProductionReplication() {
    CreateInstanceRequest input = CreateInstanceRequest.of("my-instance")
        .setType(Type.PRODUCTION)
        .addCluster("cluster1", "us-east1-c", 3, StorageType.SSD)
        .addCluster("cluster2", "us-east1-a", 3, StorageType.SSD);

    com.google.bigtable.admin.v2.CreateInstanceRequest actual = input
        .toProto(ProjectName.of("my-project"));

    com.google.bigtable.admin.v2.CreateInstanceRequest expected =
        com.google.bigtable.admin.v2.CreateInstanceRequest.newBuilder()
            .setParent(ProjectName.of("my-project").toString())
            .setInstanceId("my-instance")
            .setInstance(
                Instance.newBuilder()
                    .setDisplayName("my-instance")
                    .setType(Type.PRODUCTION)
            )
            .putClusters("cluster1",
                Cluster.newBuilder()
                    .setLocation("projects/my-project/locations/us-east1-c")
                    .setServeNodes(3)
                    .setDefaultStorageType(StorageType.SSD)
                    .build()
            )
            .putClusters("cluster2",
                Cluster.newBuilder()
                    .setLocation("projects/my-project/locations/us-east1-a")
                    .setServeNodes(3)
                    .setDefaultStorageType(StorageType.SSD)
                    .build()
            )
            .build();

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testDevelopment() {
    CreateInstanceRequest input = CreateInstanceRequest.of("my-instance")
        .setType(Type.DEVELOPMENT)
        .addCluster("cluster1", "us-east1-c", 1, StorageType.SSD);

    com.google.bigtable.admin.v2.CreateInstanceRequest actual = input
        .toProto(ProjectName.of("my-project"));

    com.google.bigtable.admin.v2.CreateInstanceRequest expected =
        com.google.bigtable.admin.v2.CreateInstanceRequest.newBuilder()
            .setParent(ProjectName.of("my-project").toString())
            .setInstanceId("my-instance")
            .setInstance(
                Instance.newBuilder()
                    .setDisplayName("my-instance")
                    .setType(Type.DEVELOPMENT)
            )
            .putClusters("cluster1",
                Cluster.newBuilder()
                    .setLocation("projects/my-project/locations/us-east1-c")
                    .setServeNodes(1)
                    .setDefaultStorageType(StorageType.SSD)
                    .build()
            )
            .build();

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testOptionalFields() {
    CreateInstanceRequest input = CreateInstanceRequest.of("my-instance")
        .setDisplayName("custom display name")
        .addLabel("my label", "with some value")
        .addLabel("my other label", "with some value")
        .setType(Type.DEVELOPMENT)
        .addCluster("cluster1", "us-east1-c", 1, StorageType.SSD);

    com.google.bigtable.admin.v2.CreateInstanceRequest actual = input
        .toProto(ProjectName.of("my-project"));

    com.google.bigtable.admin.v2.CreateInstanceRequest expected =
        com.google.bigtable.admin.v2.CreateInstanceRequest.newBuilder()
            .setParent(ProjectName.of("my-project").toString())
            .setInstanceId("my-instance")
            .setInstance(
                Instance.newBuilder()
                    .setDisplayName("custom display name")
                    .putLabels("my label", "with some value")
                    .putLabels("my other label", "with some value")
                    .setType(Type.DEVELOPMENT)
            )
            .putClusters("cluster1",
                Cluster.newBuilder()
                    .setLocation("projects/my-project/locations/us-east1-c")
                    .setServeNodes(1)
                    .setDefaultStorageType(StorageType.SSD)
                    .build()
            )
            .build();

    assertThat(actual).isEqualTo(expected);
  }
}
