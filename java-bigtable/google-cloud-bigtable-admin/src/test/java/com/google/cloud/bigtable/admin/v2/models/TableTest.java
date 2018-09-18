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
import com.google.common.collect.Lists;
import java.util.List;
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
    List<com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState> validProtoValues =
        Lists.newArrayList(
            com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState.values());

    List<Table.ReplicationState> validModelValues = Lists
        .newArrayList(Table.ReplicationState.values());

    List<Table.ReplicationState> actualModelValues = Lists.newArrayList();

    for (com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState protoValue : validProtoValues) {
      Table.ReplicationState modelValue = Table.ReplicationState.fromProto(protoValue);
      actualModelValues.add(modelValue);
    }

    assertThat(actualModelValues).containsExactlyElementsIn(validModelValues);
  }
}
