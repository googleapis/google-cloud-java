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

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;
import com.google.bigtable.admin.v2.ColumnFamily;
import com.google.bigtable.admin.v2.GcRule;
import com.google.bigtable.admin.v2.Table.ClusterState;
import com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState;
import com.google.bigtable.admin.v2.Table.TimestampGranularity;
import com.google.bigtable.admin.v2.TableName;
import com.google.cloud.bigtable.admin.v2.models.GCRules.DurationRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.IntersectionRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.UnionRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.VersionRule;
import com.google.bigtable.admin.v2.GcRule.Intersection;
import com.google.bigtable.admin.v2.GcRule.Union;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenResponse;
import static com.google.cloud.bigtable.admin.v2.models.GCRules.GCRULES;
import static com.google.common.truth.Truth.assertThat;

@RunWith(JUnit4.class)
public class TableTest {

  @Test
  public void convertTable() {
    TableName testName = TableName.of("p", "i", "testTable");
    com.google.bigtable.admin.v2.Table table =
        com.google.bigtable.admin.v2.Table.newBuilder()
            .setName(testName.toString())
            .setGranularity(TimestampGranularity.MILLIS)
            .putClusterStates(
                "test",
                ClusterState.newBuilder().setReplicationState(ReplicationState.READY).build())
            .putClusterStates(
                "prod",
                ClusterState.newBuilder()
                    .setReplicationState(ReplicationState.INITIALIZING)
                    .build())
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

    Table tableResponse = Table.fromProto(table);
    assertNotNull(tableResponse);
    assertEquals(testName, tableResponse.getTableName());
    assertEquals(2, tableResponse.getClusterStates().size());
    assertEquals(
        ReplicationState.READY,
        tableResponse.getClusterStatesMap().get("test").getReplicationState());
    assertEquals(
        ReplicationState.INITIALIZING,
        tableResponse.getClusterStatesMap().get("prod").getReplicationState());
    assertEquals(3, tableResponse.getColumnFamiles().size());
    assertNotNull("cf1", tableResponse.getColumnFamiliesMap().get("cf1").getId());
    assertFalse(tableResponse.getColumnFamiliesMap().get("cf1").hasGCRule());

    assertThat(GCRULES.defaultRule().toProto())
        .isEqualTo(tableResponse.getColumnFamiliesMap().get("cf1").getGCRule().toProto());
    assertThat(GCRULES.maxVersions(1).toProto())
        .isEqualTo(tableResponse.getColumnFamiliesMap().get("cf2").getGCRule().toProto());
    assertThat(GCRULES.maxAge(Duration.ofSeconds(1, 99)).toProto())
        .isEqualTo(tableResponse.getColumnFamiliesMap().get("cf3").getGCRule().toProto());
  }

  @Test
  public void convertTableUnionOfIntersections() {
    GcRule expected =
        GcRule.newBuilder()
            .setUnion(
                Union.newBuilder()
                    .addRules(
                        GcRule.newBuilder()
                            .setIntersection(
                                Intersection.newBuilder()
                                    .addRules(GCRulesTest.buildVersionsRule(1))
                                    .addRules(GCRulesTest.buildAgeRule(1, 0))))
                    .addRules(
                        GcRule.newBuilder()
                            .setIntersection(
                                Intersection.newBuilder()
                                    .addRules(GCRulesTest.buildVersionsRule(1))
                                    .addRules(GCRulesTest.buildAgeRule(1, 0)))))
            .build();

    GcRule actual =
        GCRULES
            .union()
            .rule(
                GCRULES
                    .intersection()
                    .rule(GCRULES.maxVersions(1))
                    .rule(GCRULES.maxAge(Duration.ofSeconds(1))))
            .rule(
                GCRULES
                    .intersection()
                    .rule(GCRULES.maxVersions(1))
                    .rule(GCRULES.maxAge(Duration.ofSeconds(1))))
            .toProto();

    com.google.bigtable.admin.v2.Table table =
        com.google.bigtable.admin.v2.Table.newBuilder()
            .putColumnFamilies("cf3", ColumnFamily.newBuilder().setGcRule(expected).build())
            .build();

    Table tableResponse = Table.fromProto(table);
    assertThat(actual)
        .isEqualTo(tableResponse.getColumnFamiliesMap().get("cf3").getGCRule().toProto());
    assertTrue(tableResponse.getColumnFamiliesMap().get("cf3").hasGCRule());

    UnionRule parentUnion =
        ((UnionRule) tableResponse.getColumnFamiliesMap().get("cf3").getGCRule());
    assertEquals(2, parentUnion.getRulesList().size());

    IntersectionRule intersectionRule = ((IntersectionRule) parentUnion.getRulesList().get(0));
    assertEquals(2, intersectionRule.getRulesList().size());
    assertEquals(1, ((VersionRule) intersectionRule.getRulesList().get(0)).getMaxVersions());
    assertEquals(
        Duration.ofSeconds(1, 0),
        ((DurationRule) intersectionRule.getRulesList().get(1)).getMaxAge());

    intersectionRule = ((IntersectionRule) parentUnion.getRulesList().get(1));
    assertEquals(2, intersectionRule.getRulesList().size());
    assertEquals(1, ((VersionRule) intersectionRule.getRulesList().get(0)).getMaxVersions());
    assertEquals(
        Duration.ofSeconds(1, 0),
        ((DurationRule) intersectionRule.getRulesList().get(1)).getMaxAge());
  }

  @Test
  public void convertTableIntersectionOfUnions() {
    GcRule actual =
        GcRule.newBuilder()
            .setIntersection(
                Intersection.newBuilder()
                    .addRules(
                        GcRule.newBuilder()
                            .setUnion(
                                Union.newBuilder()
                                    .addRules(GCRulesTest.buildVersionsRule(1))
                                    .addRules(GCRulesTest.buildAgeRule(1, 0))))
                    .addRules(
                        GcRule.newBuilder()
                            .setUnion(
                                Union.newBuilder()
                                    .addRules(GCRulesTest.buildVersionsRule(1))
                                    .addRules(GCRulesTest.buildAgeRule(1, 0)))))
            .build();

    GcRule expected =
        GCRULES
            .intersection()
            .rule(
                GCRULES
                    .union()
                    .rule(GCRULES.maxVersions(1))
                    .rule(GCRULES.maxAge(Duration.ofSeconds(1))))
            .rule(
                GCRULES
                    .union()
                    .rule(GCRULES.maxVersions(1))
                    .rule(GCRULES.maxAge(Duration.ofSeconds(1))))
            .toProto();

    com.google.bigtable.admin.v2.Table table =
        com.google.bigtable.admin.v2.Table.newBuilder()
            .putColumnFamilies("cf3", ColumnFamily.newBuilder().setGcRule(expected).build())
            .build();

    Table tableResponse = Table.fromProto(table);
    assertThat(actual)
        .isEqualTo(tableResponse.getColumnFamiliesMap().get("cf3").getGCRule().toProto());
  }

  @Test
  public void convertTableEmpty() {
    Table tableResponse =
        Table.fromProto(com.google.bigtable.admin.v2.Table.newBuilder().build());

    assertNotNull(tableResponse);
    assertEquals(0, tableResponse.getClusterStates().size());
    assertEquals(0, tableResponse.getColumnFamiles().size());
  }
}
