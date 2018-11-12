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

import com.google.bigtable.admin.v2.InstanceName;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.models.ColumnFamily;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.GCRules.DurationRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.IntersectionRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.UnionRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.VersionRule;
import com.google.cloud.bigtable.admin.v2.models.ModifyColumnFamiliesRequest;
import com.google.cloud.bigtable.admin.v2.models.Table;
import com.google.common.collect.Maps;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.threeten.bp.Duration;

public class BigtableTableAdminClientIT {
  private static final String INSTANCE_PROPERTY_NAME = "bigtable.instance";

  private static BigtableTableAdminClient tableAdmin;
  private static String prefix;

  @BeforeClass
  public static void createClient() throws IOException {
    String targetInstance = System.getProperty(INSTANCE_PROPERTY_NAME);

    if (targetInstance == null) {
      tableAdmin = null;
      return;
    }

    InstanceName instanceName = InstanceName.parse(targetInstance);
    tableAdmin = BigtableTableAdminClient.create(instanceName);

    // Setup a prefix to avoid collisions between concurrent test runs
    prefix = String.format("020%d", System.currentTimeMillis());

    // Cleanup old tables, under normal circumstances this will do nothing
    String stalePrefix = String.format("020%d", System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1));
    for (String tableId: tableAdmin.listTables()) {
      if (stalePrefix.compareTo(tableId) > 0) {
        tableAdmin.deleteTable(tableId);
      }
    }
  }

  @AfterClass
  public static void closeClient() {
    if (tableAdmin != null) {
      tableAdmin.close();
    }
  }

  @Before
  public void setup() {
    if (tableAdmin == null) {
      throw new AssumptionViolatedException(
          INSTANCE_PROPERTY_NAME + " property is not set, skipping integration tests.");
    }
  }

  @Test
  public void createTable() {
    String tableId = getTableId("adminCreateTest");
    CreateTableRequest createTableReq =
        CreateTableRequest.of(tableId)
            .addFamily("cf1")
            .addFamily("cf2", GCRULES.maxVersions(10))
            .addSplit(ByteString.copyFromUtf8("b"))
            .addSplit(ByteString.copyFromUtf8("q"));

    try {
      Table tableResponse = tableAdmin.createTable(createTableReq);
      assertNotNull(tableResponse);
      assertEquals(tableId, tableResponse.getId());

      Map<String, ColumnFamily> columnFamilyById = Maps.newHashMap();
      for (ColumnFamily columnFamily : tableResponse.getColumnFamilies()) {
        columnFamilyById.put(columnFamily.getId(), columnFamily);
      }
      assertEquals(2, tableResponse.getColumnFamilies().size());
      assertFalse(columnFamilyById.get("cf1").hasGCRule());
      assertTrue(columnFamilyById.get("cf2").hasGCRule());
      assertEquals(
          10,
          ((VersionRule) columnFamilyById.get("cf2").getGCRule())
              .getMaxVersions());
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }

  @Test
  public void modifyFamilies() {
    String tableId = getTableId("adminModifyFamTest");
    ModifyColumnFamiliesRequest modifyFamiliesReq = ModifyColumnFamiliesRequest.of(tableId);

    modifyFamiliesReq
        .addFamily("mf1")
        .addFamily("mf2", GCRULES.maxAge(Duration.ofSeconds(1000, 20000)))
        .updateFamily(
            "mf1",
            GCRULES
                .union()
                .rule(GCRULES.maxAge(Duration.ofSeconds(100)))
                .rule(GCRULES.maxVersions(1)))
        .addFamily(
            "mf3",
            GCRULES
                .intersection()
                .rule(GCRULES.maxAge(Duration.ofSeconds(2000)))
                .rule(GCRULES.maxVersions(10)))
        .addFamily("mf4", GCRULES.intersection().rule(GCRULES.maxAge(Duration.ofSeconds(360))))
        .addFamily("mf5")
        .addFamily("mf6")
        .dropFamily("mf5")
        .dropFamily("mf6")
        .addFamily("mf7");

    try {
      tableAdmin.createTable(CreateTableRequest.of(tableId));
      Table tableResponse = tableAdmin.modifyFamilies(modifyFamiliesReq);

      Map<String, ColumnFamily> columnFamilyById = Maps.newHashMap();
      for (ColumnFamily columnFamily : tableResponse.getColumnFamilies()) {
        columnFamilyById.put(columnFamily.getId(), columnFamily);
      }
      assertEquals(5, columnFamilyById.size());
      assertNotNull(columnFamilyById.get("mf1"));
      assertNotNull(columnFamilyById.get("mf2"));
      assertEquals(
          2,
          ((UnionRule) columnFamilyById.get("mf1").getGCRule())
              .getRulesList()
              .size());
      assertEquals(
          1000,
          ((DurationRule) columnFamilyById.get("mf2").getGCRule())
              .getMaxAge()
              .getSeconds());
      assertEquals(
          20000,
          ((DurationRule) columnFamilyById.get("mf2").getGCRule())
              .getMaxAge()
              .getNano());
      assertEquals(
          2,
          ((IntersectionRule) columnFamilyById.get("mf3").getGCRule())
              .getRulesList()
              .size());
      assertEquals(
          360,
          ((DurationRule) columnFamilyById.get("mf4").getGCRule())
              .getMaxAge()
              .getSeconds());
      assertNotNull(columnFamilyById.get("mf7"));
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }

  @Test
  public void deleteTable() {
    String tableId = getTableId("adminDeleteTest");
    tableAdmin.createTable(CreateTableRequest.of(tableId));
    tableAdmin.deleteTable(tableId);
  }

  @Test
  public void getTable() {
    String tableId = getTableId("adminGetTest");

    try {
      tableAdmin.createTable(CreateTableRequest.of(tableId));
      Table tableResponse = tableAdmin.getTable(tableId);
      assertNotNull(tableResponse);
      assertEquals(tableId, tableResponse.getId());
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }

  @Test
  public void listTables() {
    String tableId = getTableId("adminListTest");

    try {
      tableAdmin.createTable(CreateTableRequest.of(tableId));
      List<String> tables = tableAdmin.listTables();
      assertNotNull(tables);
      assertFalse("List tables did not return any tables", tables.isEmpty());
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }

  @Test
  public void listTablesAsync() throws Exception {
    String tableId = getTableId("adminListTest");

    try {
      tableAdmin.createTable(CreateTableRequest.of(tableId));
      List<String> tables = tableAdmin.listTablesAsync().get();
      assertNotNull(tables);
      assertFalse("List tables did not return any tables", tables.isEmpty());
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }

  @Test
  public void dropRowRange() {
    String tableId = getTableId("adminDropRowrangeTest");

    try {
      tableAdmin.createTable(CreateTableRequest.of(tableId));
      tableAdmin.dropRowRange(tableId, "rowPrefix");
      tableAdmin.dropAllRows(tableId);
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }

  @Test
  public void awaitReplication() {
    String tableId = getTableId("adminConsistencyTest");

    try {
      tableAdmin.createTable(CreateTableRequest.of(tableId));
      tableAdmin.awaitReplication(tableId);
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }

  private static String getTableId(String name) {
    return prefix + "-" + name;
  }
}
