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

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ClusterTest {

  @Test
  public void testFromProto() {
    com.google.bigtable.admin.v2.Cluster proto = com.google.bigtable.admin.v2.Cluster.newBuilder()
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
    com.google.bigtable.admin.v2.Cluster proto = com.google.bigtable.admin.v2.Cluster.newBuilder()
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
    Multimap<Cluster.State, com.google.bigtable.admin.v2.Cluster.State> modelToProtoMap =
        ArrayListMultimap.create();

    for (com.google.bigtable.admin.v2.Cluster.State protoValue : com.google.bigtable.admin.v2.Cluster.State
        .values()) {
      Cluster.State modelValue = Cluster.State.fromProto(protoValue);
      modelToProtoMap.put(modelValue, protoValue);
    }

    // Make sure all model values are used
    assertThat(modelToProtoMap.keys()).containsAllIn(Arrays.asList(Cluster.State.values()));

    // Make sure unknown is handled properly (it has multiple mappings)
    assertThat(modelToProtoMap).valuesForKey(Cluster.State.NOT_KNOWN).containsExactly(
        com.google.bigtable.admin.v2.Cluster.State.STATE_NOT_KNOWN,
        com.google.bigtable.admin.v2.Cluster.State.UNRECOGNIZED
    );

    // Make sure everything else has exactly 1 mapping
    modelToProtoMap.removeAll(Cluster.State.NOT_KNOWN);

    for (Cluster.State modelState : modelToProtoMap.keySet()) {
      Collection<com.google.bigtable.admin.v2.Cluster.State> protoStates = modelToProtoMap
          .get(modelState);

      assertThat(protoStates).hasSize(1);
    }
  }
}
