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

import com.google.common.collect.Lists;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ClusterTest {

  @Test
  public void testFromProto() {
    com.google.bigtable.admin.v2.Cluster proto =
        com.google.bigtable.admin.v2.Cluster.newBuilder()
            .setName("projects/my-project/instances/my-instance/clusters/my-cluster")
            .setLocation("projects/my-project/locations/us-east1-c")
            .setState(com.google.bigtable.admin.v2.Cluster.State.READY)
            .setServeNodes(30)
            .setDefaultStorageType(com.google.bigtable.admin.v2.StorageType.SSD)
            .build();

    Cluster result = Cluster.fromProto(proto);

    assertThat(result.getId()).isEqualTo("my-cluster");
    assertThat(result.getInstanceId()).isEqualTo("my-instance");
    assertThat(result.getZone()).isEqualTo("us-east1-c");
    assertThat(result.getState()).isEqualTo(Cluster.State.READY);
    assertThat(result.getServeNodes()).isEqualTo(30);
    assertThat(result.getStorageType()).isEqualTo(StorageType.SSD);
  }

  @Test
  public void testRequiresName() {
    com.google.bigtable.admin.v2.Cluster proto =
        com.google.bigtable.admin.v2.Cluster.newBuilder()
            .setLocation("projects/my-project/locations/us-east1-c")
            .setState(com.google.bigtable.admin.v2.Cluster.State.READY)
            .setServeNodes(30)
            .setDefaultStorageType(com.google.bigtable.admin.v2.StorageType.SSD)
            .build();

    Exception actualException = null;

    try {
      Cluster.fromProto(proto);
    } catch (Exception e) {
      actualException = e;
    }

    assertThat(actualException).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void testStateEnumUpToDate() {
    List<com.google.bigtable.admin.v2.Cluster.State> validProtoValues =
        Lists.newArrayList(com.google.bigtable.admin.v2.Cluster.State.values());

    List<Cluster.State> validModelValues = Lists.newArrayList(Cluster.State.values());

    List<Cluster.State> actualModelValues = Lists.newArrayList();

    for (com.google.bigtable.admin.v2.Cluster.State protoValue : validProtoValues) {
      Cluster.State modelValue = Cluster.State.fromProto(protoValue);
      actualModelValues.add(modelValue);
    }

    assertThat(actualModelValues).containsExactlyElementsIn(validModelValues);
  }
}
