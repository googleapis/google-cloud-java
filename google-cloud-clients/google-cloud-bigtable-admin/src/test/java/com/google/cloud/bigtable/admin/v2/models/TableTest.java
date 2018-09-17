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

import com.google.bigtable.admin.v2.ColumnFamily;
import com.google.bigtable.admin.v2.GcRule;
import com.google.bigtable.admin.v2.Table.TimestampGranularity;
import com.google.bigtable.admin.v2.TableName;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map.Entry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TableTest {

  @Test
  public void testFromProto() {
    TableName testName = TableName.of("my-project", "my-instance", "my-table");
    com.google.bigtable.admin.v2.Table proto =
        com.google.bigtable.admin.v2.Table.newBuilder()
            .setName(testName.toString())
            .setGranularity(TimestampGranularity.MILLIS)
            .putClusterStates(
                "cluster1",
                com.google.bigtable.admin.v2.Table.ClusterState.newBuilder()
                    .setReplicationState(
                        com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState.READY
                    ).build()
            )
            .putClusterStates(
                "cluster2",
                com.google.bigtable.admin.v2.Table.ClusterState.newBuilder()
                    .setReplicationState(
                        com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState.INITIALIZING
                    ).build()
            )
            .putColumnFamilies("cf1", ColumnFamily.newBuilder().build())
            .putColumnFamilies(
                "cf2",
                ColumnFamily.newBuilder()
                    .setGcRule(GcRule.newBuilder().setMaxNumVersions(1))
                    .build())
            .putColumnFamilies(
                "cf3",
                ColumnFamily.newBuilder()
                    .setGcRule(
                        GcRule.newBuilder()
                            .setMaxAge(
                                com.google.protobuf.Duration.newBuilder()
                                    .setSeconds(1)
                                    .setNanos(99)))
                    .build())
            .build();

    Table result = Table.fromProto(proto);

    assertThat(result.getInstanceId()).isEqualTo("my-instance");
    assertThat(result.getId()).isEqualTo("my-table");
    assertThat(result.getReplicationStatesByClusterId()).containsExactly(
        "cluster1", Table.ReplicationState.READY,
        "cluster2", Table.ReplicationState.INITIALIZING
    );
    assertThat(result.getColumnFamilies()).hasSize(3);

    for (Entry<String, ColumnFamily> entry : proto.getColumnFamiliesMap().entrySet()) {
      assertThat(result.getColumnFamilies()).contains(
          com.google.cloud.bigtable.admin.v2.models.ColumnFamily
              .fromProto(entry.getKey(), entry.getValue())
      );
    }
  }

  @Test
  public void testReplicationStateEnumUpToDate() {
    Multimap<Table.ReplicationState, com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState> modelToProtoMap =
        ArrayListMultimap.create();

    for (com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState protoValue : com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState
        .values()) {
      Table.ReplicationState modelValue = Table.ReplicationState.fromProto(protoValue);
      modelToProtoMap.put(modelValue, protoValue);
    }

    // Make sure all model values are used
    assertThat(modelToProtoMap.keys())
        .containsAllIn(Arrays.asList(Table.ReplicationState.values()));

    // Make sure unknown is handled properly (it has multiple mappings)
    assertThat(modelToProtoMap).valuesForKey(Table.ReplicationState.NOT_KNOWN).containsExactly(
        com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState.STATE_NOT_KNOWN,
        com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState.UNRECOGNIZED
    );

    // Make sure everything else has exactly 1 mapping
    modelToProtoMap.removeAll(Table.ReplicationState.NOT_KNOWN);

    for (Table.ReplicationState modelState : modelToProtoMap.keySet()) {
      Collection<com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState> protoStates = modelToProtoMap
          .get(modelState);

      assertThat(protoStates).hasSize(1);
    }
  }
}
