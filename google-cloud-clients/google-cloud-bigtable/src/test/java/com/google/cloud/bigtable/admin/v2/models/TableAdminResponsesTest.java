package com.google.cloud.bigtable.admin.v2.models;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;
import com.google.bigtable.admin.v2.ColumnFamily;
import com.google.bigtable.admin.v2.GcRule;
import com.google.bigtable.admin.v2.Table;
import com.google.bigtable.admin.v2.Table.ClusterState;
import com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState;
import com.google.bigtable.admin.v2.Table.TimestampGranularity;
import com.google.bigtable.admin.v2.TableName;
import com.google.cloud.bigtable.admin.v2.models.TableAdminResponses.ConsistencyTokenResponse;
import com.google.cloud.bigtable.admin.v2.models.TableAdminResponses.TableResponse;
import com.google.bigtable.admin.v2.GcRule.Intersection;
import com.google.bigtable.admin.v2.GcRule.Union;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenResponse;
import static com.google.cloud.bigtable.admin.v2.models.GCRules.GCRULES;
import static com.google.common.truth.Truth.assertThat;

@RunWith(JUnit4.class)
public class TableAdminResponsesTest {

  @Test
  public void convertTable() {
    TableName testName = TableName.of("p", "i", "testTable");
    Table table =
        Table.newBuilder()
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

    TableResponse tableResponse = TableAdminResponses.convertTable(table);
    assertNotNull(tableResponse);
    assertEquals(testName, tableResponse.getTableName());
    assertEquals(TimestampGranularity.MILLIS, tableResponse.getTimestampGranularity());
    assertEquals(2, tableResponse.getClusterStates().size());
    assertEquals(
        ReplicationState.READY,
        tableResponse.getClusterStatesMap().get("test").getReplicationState());
    assertEquals(
        ReplicationState.INITIALIZING,
        tableResponse.getClusterStatesMap().get("prod").getReplicationState());
    assertEquals(3, tableResponse.getColumnFamiles().size());
    assertNotNull("cf1", tableResponse.getColumnFamiliesMap().get("cf1").getId());
    assertFalse(tableResponse.getColumnFamiliesMap().get("cf1").hasGcRule());

    assertThat(GCRULES.defaulRule().toProto())
        .isEqualTo(tableResponse.getColumnFamiliesMap().get("cf1").getGcRule());
    assertThat(GCRULES.maxVersions(1).toProto())
        .isEqualTo(tableResponse.getColumnFamiliesMap().get("cf2").getGcRule());
    assertThat(GCRULES.maxAge(Duration.ofSeconds(1, 99)).toProto())
        .isEqualTo(tableResponse.getColumnFamiliesMap().get("cf3").getGcRule());
  }

  @Test
  public void convertTable_unionOfIntersections() {
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

    Table table =
        Table.newBuilder()
            .putColumnFamilies("cf3", ColumnFamily.newBuilder().setGcRule(expected).build())
            .build();

    TableResponse tableResponse = TableAdminResponses.convertTable(table);
    assertThat(actual).isEqualTo(tableResponse.getColumnFamiliesMap().get("cf3").getGcRule());
    assertTrue(tableResponse.getColumnFamiliesMap().get("cf3").hasGcRule());
    assertTrue(tableResponse.getColumnFamiliesMap().get("cf3").hasUnion());
    assertFalse(tableResponse.getColumnFamiliesMap().get("cf3").hasIntersection());
    assertFalse(tableResponse.getColumnFamiliesMap().get("cf3").hasMaxAge());
  }

  @Test
  public void convertTable_intersectionOfUnions() {
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

    Table table =
        Table.newBuilder()
            .putColumnFamilies("cf3", ColumnFamily.newBuilder().setGcRule(expected).build())
            .build();

    TableResponse tableResponse = TableAdminResponses.convertTable(table);
    assertThat(actual).isEqualTo(tableResponse.getColumnFamiliesMap().get("cf3").getGcRule());
  }

  @Test
  public void convertTable_Empty() {
    TableResponse tableResponse = TableAdminResponses.convertTable(Table.newBuilder().build());

    assertNotNull(tableResponse);
    assertEquals(
        TimestampGranularity.TIMESTAMP_GRANULARITY_UNSPECIFIED,
        tableResponse.getTimestampGranularity());
    assertEquals(0, tableResponse.getClusterStates().size());
    assertEquals(0, tableResponse.getColumnFamiles().size());
  }

  @Test
  public void convertTokenResponse() {
    ConsistencyTokenResponse tokenResponse =
        TableAdminResponses.convertTokenResponse(
            GenerateConsistencyTokenResponse.newBuilder()
                .setConsistencyToken("87282hgwd8yg")
                .build());

    assertNotNull(tokenResponse);
    assertEquals("87282hgwd8yg", tokenResponse.getToken());
  }
}
