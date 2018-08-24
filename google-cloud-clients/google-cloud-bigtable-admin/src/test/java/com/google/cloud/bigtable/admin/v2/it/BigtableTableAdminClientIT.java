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
import com.google.bigtable.admin.v2.TableName;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.models.GCRules.DurationRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.IntersectionRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.UnionRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.VersionRule;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.ModifyColumnFamiliesRequest;
import com.google.cloud.bigtable.admin.v2.models.ConsistencyToken;
import com.google.cloud.bigtable.admin.v2.models.Table;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.threeten.bp.Duration;

public class BigtableTableAdminClientIT {
  private static final String INSTANCE_PROPERTY_NAME = "bigtable.instance";

  private static BigtableTableAdminClient tableAdmin;

  @BeforeClass
  public static void createClient() throws IOException {
    String targetInstance = System.getProperty(INSTANCE_PROPERTY_NAME);

    if (targetInstance == null) {
      tableAdmin = null;
      return;
    }

    InstanceName instanceName = InstanceName.parse(targetInstance);
    tableAdmin = BigtableTableAdminClient.create(instanceName);
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
    String tableId = "adminCreateTest";
    CreateTableRequest createTableReq =
        CreateTableRequest.of(tableId)
            .addFamily("cf1")
            .addFamily("cf2", GCRULES.maxVersions(10))
            .addSplit(ByteString.copyFromUtf8("b"))
            .addSplit(ByteString.copyFromUtf8("q"));

    try {
      Table tableResponse = tableAdmin.createTable(createTableReq);
      assertNotNull(tableResponse);
      assertEquals(tableId, tableResponse.getTableName().getTable());
      assertEquals(2, tableResponse.getColumnFamiles().size());
      assertFalse(tableResponse.getColumnFamiliesMap().get("cf1").hasGCRule());
      assertTrue(tableResponse.getColumnFamiliesMap().get("cf2").hasGCRule());
      assertEquals(
          10,
          ((VersionRule) tableResponse.getColumnFamiliesMap().get("cf2").getGCRule())
              .getMaxVersions());
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }

  @Test
  public void modifyFamilies() {
    String tableId = "adminModifyFamTest";
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
      assertEquals(5, tableResponse.getColumnFamiles().size());
      assertNotNull(tableResponse.getColumnFamiliesMap().get("mf1"));
      assertNotNull(tableResponse.getColumnFamiliesMap().get("mf2"));
      assertEquals(
          2,
          ((UnionRule) tableResponse.getColumnFamiliesMap().get("mf1").getGCRule())
              .getRulesList()
              .size());
      assertEquals(
          1000,
          ((DurationRule) tableResponse.getColumnFamiliesMap().get("mf2").getGCRule())
              .getMaxAge()
              .getSeconds());
      assertEquals(
          20000,
          ((DurationRule) tableResponse.getColumnFamiliesMap().get("mf2").getGCRule())
              .getMaxAge()
              .getNano());
      assertEquals(
          2,
          ((IntersectionRule) tableResponse.getColumnFamiliesMap().get("mf3").getGCRule())
              .getRulesList()
              .size());
      assertEquals(
          360,
          ((DurationRule) tableResponse.getColumnFamiliesMap().get("mf4").getGCRule())
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
    tableAdmin.createTable(CreateTableRequest.of(tableId));
    tableAdmin.deleteTable(tableId);
  }

  @Test
  public void getTable() {
    String tableId = "adminGetTest";

    try {
      tableAdmin.createTable(CreateTableRequest.of(tableId));
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
      tableAdmin.createTable(CreateTableRequest.of(tableId));
      List<TableName> tables = tableAdmin.listTables();
      assertNotNull(tables);
      assertFalse("List tables did not return any tables", tables.isEmpty());
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }

  @Test
  public void listTablesAsync() throws Exception {
    String tableId = "adminListTest";

    try {
      tableAdmin.createTable(CreateTableRequest.of(tableId));
      List<TableName> tables = tableAdmin.listTablesAsync().get();
      assertNotNull(tables);
      assertFalse("List tables did not return any tables", tables.isEmpty());
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }

  @Test
  public void dropRowRange() {
    String tableId = "adminDropRowrangeTest";

    try {
      tableAdmin.createTable(CreateTableRequest.of(tableId));
      tableAdmin.dropRowRange(tableId, "rowPrefix");
      tableAdmin.dropAllRows(tableId);
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }

  @Test
  public void checkConsistency() {
    String tableId = "adminConsistencyTest";

    try {
      tableAdmin.createTable(CreateTableRequest.of(tableId));
      ConsistencyToken consistencyToken = tableAdmin.generateConsistencyToken(tableId);
      assertNotNull(consistencyToken);
      boolean consistent = tableAdmin.isConsistent(tableId, consistencyToken);
      assertTrue(consistent);
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }
}
