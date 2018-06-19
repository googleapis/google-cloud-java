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
package com.google.cloud.bigtable.admin.v2.it;

import static com.google.cloud.bigtable.admin.v2.models.GCRules.GCRULES;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.threeten.bp.Duration;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.Table.TimestampGranularity;
import com.google.bigtable.admin.v2.TableName;
import com.google.cloud.bigtable.admin.v2.TableAdminClient;
import com.google.cloud.bigtable.admin.v2.models.TableAdminRequests;
import com.google.cloud.bigtable.admin.v2.models.TableAdminRequests.CreateTable;
import com.google.cloud.bigtable.admin.v2.models.TableAdminRequests.ModifyFamilies;
import com.google.cloud.bigtable.admin.v2.models.TableAdminResponses.ConsistencyToken;
import com.google.cloud.bigtable.admin.v2.models.TableAdminResponses.Table;
import com.google.protobuf.ByteString;

public class TableAdminClientIT {
  static TableAdminClient tableAdmin;

  @BeforeClass
  public static void setup() throws IOException {
    tableAdmin = TableAdminClient.create(InstanceName.of("sduskis-hello-shakespear", "beam-test"));
  }

  @AfterClass
  public static void cleanup() throws Exception {
    tableAdmin.close();
  }

  @Test
  public void createTable() throws Exception {
    String tableId = "adminCreateTest";
    CreateTable createTableReq =
        TableAdminRequests.createTable(tableId)
            .addColumnFamily("cf1")
            .addColumnFamily("cf2", GCRULES.maxVersions(10))
            .withGranularity(TimestampGranularity.MILLIS)
            .addSplit(ByteString.copyFromUtf8("b"))
            .addSplit(ByteString.copyFromUtf8("q"));

    try {
      Table tableResponse = tableAdmin.createTable(createTableReq);
      assertNotNull(tableResponse);
      assertEquals(tableId, tableResponse.getTableName().getTable());
      assertEquals(2, tableResponse.getColumnFamiles().size());
      assertFalse(tableResponse.getColumnFamiliesMap().get("cf1").hasGcRule());
      assertTrue(tableResponse.getColumnFamiliesMap().get("cf2").hasGcRule());
      assertEquals(
          10,
          tableResponse
              .getColumnFamiliesMap()
              .get("cf2")
              .getGCRule()
              .getVersionOrThow()
              .getMaxVersions());
      assertEquals(TimestampGranularity.MILLIS, tableResponse.getTimestampGranularity());
      // TODO: is there a way to test splits here?
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }

  @Test
  public void modifyFamilies() {
    String tableId = "adminModifyFamTest";
    ModifyFamilies modifyFamiliesReq = TableAdminRequests.modifyFamilies(tableId);
    Duration.ofSeconds(1000);
    modifyFamiliesReq
        .create("mf1")
        .createWithGCRule("mf2", GCRULES.maxAge(Duration.ofSeconds(1000, 20000)))
        .updateWithGCRule(
            "mf1",
            GCRULES
                .union()
                .rule(GCRULES.maxAge(Duration.ofSeconds(100)))
                .rule(GCRULES.maxVersions(1)))
        .createWithGCRule(
            "mf3",
            GCRULES
                .intersection()
                .rule(GCRULES.maxAge(Duration.ofSeconds(2000)))
                .rule(GCRULES.maxVersions(10)))
        .createWithGCRule(
            "mf4", GCRULES.intersection().rule(GCRULES.maxAge(Duration.ofSeconds(360))))
        .create("mf5")
        .create("mf6")
        .drop("mf5")
        .drop("mf6")
        .create("mf7");

    try {
      tableAdmin.createTable(TableAdminRequests.createTable(tableId));
      Table tableResponse = tableAdmin.modifyFamilies(modifyFamiliesReq);
      assertEquals(5, tableResponse.getColumnFamiles().size());
      assertNotNull(tableResponse.getColumnFamiliesMap().get("mf1"));
      assertNotNull(tableResponse.getColumnFamiliesMap().get("mf2"));
      assertEquals(
          2,
          tableResponse
              .getColumnFamiliesMap()
              .get("mf1")
              .getGCRule()
              .getUnionOrThow()
              .getRulesList()
              .size());
      assertEquals(
          1000,
          tableResponse
              .getColumnFamiliesMap()
              .get("mf2")
              .getGCRule()
              .getDurationOrThow()
              .getMaxAge()
              .getSeconds());
      assertEquals(
          20000,
          tableResponse
              .getColumnFamiliesMap()
              .get("mf2")
              .getGCRule()
              .getDurationOrThow()
              .getMaxAge()
              .getNano());
      assertEquals(
          2,
          tableResponse
              .getColumnFamiliesMap()
              .get("mf3")
              .getGCRule()
              .getIntersectionOrThow()
              .getRulesList()
              .size());
      assertEquals(
          360,
          tableResponse
              .getColumnFamiliesMap()
              .get("mf4")
              .getGCRule()
              .getDurationOrThow()
              .getMaxAge()
              .getSeconds());
      assertNotNull(tableResponse.getColumnFamiliesMap().get("mf7"));
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }

  @Test
  public void deleteTable() {
    String tableId = "adminDeleteTest";
    tableAdmin.createTable(TableAdminRequests.createTable(tableId));
    tableAdmin.deleteTable(tableId);
  }

  @Test
  public void getTable() {
    String tableId = "adminGetTest";

    try {
      tableAdmin.createTable(TableAdminRequests.createTable(tableId));
      Table tableResponse = tableAdmin.getTable(tableId);
      assertNotNull(tableResponse);
      assertEquals(tableId, tableResponse.getTableName().getTable());
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }

  @Test
  public void listTables() {
    String tableId = "adminListTest";

    try {
      tableAdmin.createTable(TableAdminRequests.createTable(tableId));
      List<TableName> tables = tableAdmin.listTables();
      assertNotNull(tables);
      assertEquals(1, tables.size());
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }

  @Test
  public void listTablesAsync() throws Exception {
    String tableId = "adminListTest";

    try {
      tableAdmin.createTable(TableAdminRequests.createTable(tableId));
      List<TableName> tables = tableAdmin.listTablesAsync().get();
      assertNotNull(tables);
      assertEquals(1, tables.size());
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }

  @Test
  public void dropRowRange() {
    String tableId = "adminDropRowrangeTest";

    try {
      tableAdmin.createTable(TableAdminRequests.createTable(tableId));
      tableAdmin.dropRowRange(tableId, "rowPrefix");
      tableAdmin.dropAllData(tableId);
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }

  @Test
  public void checkConsistency() {
    String tableId = "adminConsistencyTest";

    try {
      tableAdmin.createTable(TableAdminRequests.createTable(tableId));
      ConsistencyToken consistencyToken = tableAdmin.generateConsistencyToken(tableId);
      assertNotNull(consistencyToken);
      boolean consistent = tableAdmin.isConsistent(tableId, consistencyToken);
      assertTrue(consistent);
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }
}
