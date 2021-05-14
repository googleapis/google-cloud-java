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
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.TruthJUnit.assume;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.Policy;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.models.ColumnFamily;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.GCRules.DurationRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.IntersectionRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.UnionRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.VersionRule;
import com.google.cloud.bigtable.admin.v2.models.ModifyColumnFamiliesRequest;
import com.google.cloud.bigtable.admin.v2.models.Table;
import com.google.cloud.bigtable.test_helpers.env.EmulatorEnv;
import com.google.cloud.bigtable.test_helpers.env.PrefixGenerator;
import com.google.cloud.bigtable.test_helpers.env.TestEnvRule;
import com.google.common.collect.Maps;
import com.google.protobuf.ByteString;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class BigtableTableAdminClientIT {
  @ClassRule public static TestEnvRule testEnvRule = new TestEnvRule();
  @Rule public final PrefixGenerator prefixGenerator = new PrefixGenerator();

  private BigtableTableAdminClient tableAdmin;
  private String tableId;

  @Before
  public void setUp() {
    tableAdmin = testEnvRule.env().getTableAdminClient();
    tableId = prefixGenerator.newPrefix();
  }

  @After
  public void tearDown() {
    try {
      testEnvRule.env().getTableAdminClient().deleteTable(tableId);
    } catch (NotFoundException e) {
      // table was deleted in test or was never created. Carry on
    }
  }

  @Test
  public void createTable() {
    assume()
        .withMessage("Emulator doesn't return proper responses for CreateTable")
        .that(testEnvRule.env())
        .isNotInstanceOf(EmulatorEnv.class);

    CreateTableRequest createTableReq =
        CreateTableRequest.of(tableId)
            .addFamily("cf1")
            .addFamily("cf2", GCRULES.maxVersions(10))
            .addSplit(ByteString.copyFromUtf8("b"))
            .addSplit(ByteString.copyFromUtf8("q"));

    Table tableResponse = tableAdmin.createTable(createTableReq);
    assertEquals(tableId, tableResponse.getId());

    Map<String, ColumnFamily> columnFamilyById = Maps.newHashMap();
    for (ColumnFamily columnFamily : tableResponse.getColumnFamilies()) {
      columnFamilyById.put(columnFamily.getId(), columnFamily);
    }
    assertEquals(2, tableResponse.getColumnFamilies().size());
    assertFalse(columnFamilyById.get("cf1").hasGCRule());
    assertTrue(columnFamilyById.get("cf2").hasGCRule());
    assertEquals(10, ((VersionRule) columnFamilyById.get("cf2").getGCRule()).getMaxVersions());
  }

  @Test
  public void modifyFamilies() {
    tableAdmin.createTable(CreateTableRequest.of(tableId));

    ModifyColumnFamiliesRequest modifyFamiliesReq =
        ModifyColumnFamiliesRequest.of(tableId)
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

    Table tableResponse = tableAdmin.modifyFamilies(modifyFamiliesReq);

    Map<String, ColumnFamily> columnFamilyById = Maps.newHashMap();
    for (ColumnFamily columnFamily : tableResponse.getColumnFamilies()) {
      columnFamilyById.put(columnFamily.getId(), columnFamily);
    }
    assertEquals(5, columnFamilyById.size());
    assertNotNull(columnFamilyById.get("mf1"));
    assertNotNull(columnFamilyById.get("mf2"));
    assertEquals(2, ((UnionRule) columnFamilyById.get("mf1").getGCRule()).getRulesList().size());
    assertEquals(
        1000, ((DurationRule) columnFamilyById.get("mf2").getGCRule()).getMaxAge().getSeconds());
    assertEquals(
        20000, ((DurationRule) columnFamilyById.get("mf2").getGCRule()).getMaxAge().getNano());
    assertEquals(
        2, ((IntersectionRule) columnFamilyById.get("mf3").getGCRule()).getRulesList().size());
    assertEquals(
        360, ((DurationRule) columnFamilyById.get("mf4").getGCRule()).getMaxAge().getSeconds());
    assertNotNull(columnFamilyById.get("mf7"));
  }

  @Test
  public void deleteTable() {
    tableAdmin.createTable(CreateTableRequest.of(tableId));
    tableAdmin.deleteTable(tableId);
  }

  @Test
  public void getTable() {
    tableAdmin.createTable(CreateTableRequest.of(tableId));
    Table tableResponse = tableAdmin.getTable(tableId);
    assertNotNull(tableResponse);
    assertEquals(tableId, tableResponse.getId());
  }

  @Test
  public void listTables() {
    tableAdmin.createTable(CreateTableRequest.of(tableId));
    List<String> tables = tableAdmin.listTables();
    assertNotNull(tables);
    assertFalse("List tables did not return any tables", tables.isEmpty());
  }

  @Test
  public void listTablesAsync() throws Exception {
    tableAdmin.createTable(CreateTableRequest.of(tableId));
    List<String> tables = tableAdmin.listTablesAsync().get();
    assertNotNull(tables);
    assertFalse("List tables did not return any tables", tables.isEmpty());
  }

  @Test
  public void dropRowRange() {
    tableAdmin.createTable(CreateTableRequest.of(tableId));
    tableAdmin.dropRowRange(tableId, "rowPrefix");
    tableAdmin.dropAllRows(tableId);
  }

  @Test
  public void awaitReplication() {
    tableAdmin.createTable(CreateTableRequest.of(tableId));
    tableAdmin.awaitReplication(tableId);
  }

  @Test
  public void iamUpdateTest() {
    assume()
        .withMessage("Emulator doesn't return proper responses for IAM Policy operations")
        .that(testEnvRule.env())
        .isNotInstanceOf(EmulatorEnv.class);

    tableAdmin.createTable(CreateTableRequest.of(tableId));
    Policy policy = tableAdmin.getIamPolicy(tableId);
    assertThat(policy).isNotNull();

    Exception actualEx = null;
    try {
      assertThat(tableAdmin.setIamPolicy(tableId, policy)).isNotNull();
    } catch (Exception iamException) {
      actualEx = iamException;
    }
    assertThat(actualEx).isNull();

    List<String> permissions =
        tableAdmin.testIamPermission(
            tableId, "bigtable.tables.readRows", "bigtable.tables.mutateRows");
    assertThat(permissions).hasSize(2);
  }
}
