/*
 * Copyright 2019 Google LLC.  All Rights Reserved.
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
package com.google.cloud.examples.bigtable;

import static org.junit.Assert.assertTrue;

import com.google.bigtable.admin.v2.InstanceName;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.ColumnFamily;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.GCRules;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/** Integration tests for {@link TableAdmin} */
public class ITTableAdmin {

  private static final String INSTANCE_PROPERTY_NAME = "bigtable.instance";
  private static final String TABLE_PREFIX = "table";
  private static String tableId;
  private static BigtableTableAdminClient adminClient;
  private static InstanceName instanceName;
  private TableAdmin tableAdmin;

  @BeforeClass
  public static void beforeClass() throws IOException {
    String targetInstance = System.getProperty(INSTANCE_PROPERTY_NAME);
    if (targetInstance == null) {
      adminClient = null;
      return;
    }
    instanceName = InstanceName.parse(targetInstance);
    BigtableTableAdminSettings adminSettings =
        BigtableTableAdminSettings.newBuilder().setInstanceName(instanceName).build();
    adminClient = BigtableTableAdminClient.create(adminSettings);
  }

  @AfterClass
  public static void afterClass() {
    garbageCollect();
    adminClient.close();
  }

  @Before
  public void setup() throws IOException {
    if (adminClient == null) {
      throw new AssumptionViolatedException(
          INSTANCE_PROPERTY_NAME + " property is not set, skipping integration tests.");
    }
    tableId = generateTableId();
    tableAdmin = new TableAdmin(instanceName.getProject(), instanceName.getInstance(), tableId);
    adminClient.createTable(CreateTableRequest.of(tableId).addFamily("cf"));
  }

  @After
  public void after() {
    if (adminClient.exists(tableId)) {
      adminClient.deleteTable(tableId);
    }
  }

  @Test
  public void testCreateAndDeleteTable() throws IOException {
    // Creates a table.
    String fakeTable = generateTableId();
    TableAdmin testTableAdmin =
        new TableAdmin(instanceName.getProject(), instanceName.getInstance(), fakeTable);
    testTableAdmin.createTable();
    assertTrue(adminClient.exists(fakeTable));

    // Deletes a table.
    testTableAdmin.deleteTable();
    assertTrue(!adminClient.exists(fakeTable));
  }

  @Test
  public void testCreateMaxAgeRuleAndModifyAndPrintColumnFamily() {
    // Max age rule
    tableAdmin.maxAgeRule();
    GCRules.DurationRule maxAgeCondition = GCRules.GCRULES.maxAge(5, TimeUnit.DAYS);
    boolean maxAgeRule = ruleCheck(maxAgeCondition);
    assertTrue(maxAgeRule);

    // Modifies cf1.
    tableAdmin.modifyColumnFamilyRule();
    Object modifiedRule = GCRules.GCRULES.maxVersions(1);
    boolean maxVersionRule = ruleCheck(modifiedRule);
    assertTrue(maxVersionRule);
  }

  @Test
  public void testCreateMaxVersionsRuleAndDeleteColumnFamily() {
    // Max versions rule
    tableAdmin.maxVersionsRule();
    GCRules.VersionRule maxVersionCondition = GCRules.GCRULES.maxVersions(2);
    boolean maxVersionRule = ruleCheck(maxVersionCondition);
    assertTrue(maxVersionRule);

    // Deletes cf2.
    tableAdmin.deleteColumnFamily();
    boolean found = true;
    List<ColumnFamily> columnFamilies = adminClient.getTable(tableId).getColumnFamilies();
    for (ColumnFamily columnFamily : columnFamilies) {
      if (columnFamily.equals("cf2")) {
        found = false;
        break;
      }
    }
    assertTrue(found);
  }

  @Test
  public void testCreateUnionRule() {
    // Union rule
    tableAdmin.unionRule();
    GCRules.DurationRule maxAgeRule = GCRules.GCRULES.maxAge(5, TimeUnit.DAYS);
    GCRules.VersionRule versionRule = GCRules.GCRULES.maxVersions(1);
    GCRules.UnionRule unionCondition = GCRules.GCRULES.union().rule(maxAgeRule).rule(versionRule);
    boolean unionRule = ruleCheck(unionCondition);
    assertTrue(unionRule);
  }

  @Test
  public void testCreateIntersectionRule() {
    // Intersection rule
    tableAdmin.intersectionRule();
    GCRules.DurationRule maxAgeRule = GCRules.GCRULES.maxAge(5, TimeUnit.DAYS);
    GCRules.VersionRule versionRule = GCRules.GCRULES.maxVersions(2);
    GCRules.IntersectionRule intersectionCondition =
        GCRules.GCRULES.intersection().rule(maxAgeRule).rule(versionRule);
    boolean intersectionRule = ruleCheck(intersectionCondition);
    assertTrue(intersectionRule);
  }

  @Test
  public void testCreateNestedRule() {
    // Nested rule
    tableAdmin.nestedRule();
    GCRules.VersionRule versionRule = GCRules.GCRULES.maxVersions(10);
    GCRules.DurationRule maxAgeRule = GCRules.GCRULES.maxAge(30, TimeUnit.DAYS);
    GCRules.VersionRule versionRule2 = GCRules.GCRULES.maxVersions(2);
    GCRules.IntersectionRule intersectionRule =
        GCRules.GCRULES.intersection().rule(maxAgeRule).rule(versionRule2);
    GCRules.UnionRule nestedCondition =
        GCRules.GCRULES.union().rule(intersectionRule).rule(versionRule);
    boolean nestedRule = ruleCheck(nestedCondition);
    assertTrue(nestedRule);
  }

  @Test
  public void testRunDoesNotFail() {
    tableAdmin.run();
  }

  // TODO: add test for tableAdmin.listAllTables()
  // TODO: add test for tableAdmin.getTableMeta()
  // TODO: add test for tableAdmin.listColumnFamilies

  private boolean ruleCheck(Object condition) {
    boolean found = false;
    List<ColumnFamily> columnFamilies = adminClient.getTable(tableId).getColumnFamilies();
    for (ColumnFamily columnFamily : columnFamilies) {
      if (columnFamily.getGCRule().equals(condition)) {
        found = true;
        break;
      }
    }
    return found;
  }

  private String generateTableId() {
    return String.format(
        "%s-%016x-%x", TABLE_PREFIX, System.currentTimeMillis(), new Random().nextLong());
  }

  private static void garbageCollect() {
    Pattern timestampPattern = Pattern.compile(TABLE_PREFIX + "-([0-9a-f]+)-([0-9a-f]+)");
    for (String tableId : adminClient.listTables()) {
      Matcher matcher = timestampPattern.matcher(tableId);
      if (!matcher.matches()) {
        continue;
      }
      System.out.println("\nGarbage collecting orphaned table: " + tableId);
      adminClient.deleteTable(tableId);
    }
  }
}
