/*
 * Copyright 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package com.m.examples.bigtable;

import static com.google.cloud.bigtable.admin.v2.models.GCRules.GCRULES;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.ColumnFamily;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.GCRules.DurationRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.GCRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.IntersectionRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.UnionRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.VersionRule;
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

/** Integration tests for {@link TableAdminExample} */
public class TableAdminExampleTest {

  private static final String PROJECT_PROPERTY_NAME = "bigtable.project";
  private static final String INSTANCE_PROPERTY_NAME = "bigtable.instance";
  private static final String TABLE_PREFIX = "table";
  private static BigtableTableAdminClient adminClient;
  private static String instanceId;
  private static String projectId;
  private String tableId;
  private TableAdminExample tableAdmin;

  @BeforeClass
  public static void beforeClass() throws IOException {
    projectId = System.getProperty(PROJECT_PROPERTY_NAME);
    instanceId = System.getProperty(INSTANCE_PROPERTY_NAME);
    if (projectId == null || instanceId == null) {
      adminClient = null;
      return;
    }
    BigtableTableAdminSettings adminSettings =
        BigtableTableAdminSettings.newBuilder()
            .setInstanceId(instanceId)
            .setProjectId(projectId)
            .build();
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
          INSTANCE_PROPERTY_NAME
              + " or "
              + PROJECT_PROPERTY_NAME
              + " property is not set, skipping integration tests.");
    }
    tableId = generateTableId();
    tableAdmin = new TableAdminExample(projectId, instanceId, tableId);
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
    String testTable = generateTableId();
    TableAdminExample testTableAdmin = new TableAdminExample(projectId, instanceId, testTable);
    testTableAdmin.createTable();
    assertTrue(adminClient.exists(testTable));

    // Deletes a table.
    testTableAdmin.deleteTable();
    assertFalse(adminClient.exists(testTable));
  }

  @Test
  public void testCreateMaxAgeRuleAndModifyAndPrintColumnFamily() {
    // Max age rule
    tableAdmin.addFamilyWithMaxAgeRule();
    DurationRule maxAgeCondition = GCRULES.maxAge(5, TimeUnit.DAYS);
    boolean maxAgeRule = ruleCheck(maxAgeCondition);
    assertTrue(maxAgeRule);

    // Modifies cf1.
    tableAdmin.modifyColumnFamilyRule();
    GCRule modifiedRule = GCRULES.maxVersions(1);
    boolean maxVersionRule = ruleCheck(modifiedRule);
    assertTrue(maxVersionRule);
  }

  @Test
  public void testCreateMaxVersionsRuleAndDeleteColumnFamily() {
    // Max versions rule
    tableAdmin.addFamilyWithMaxVersionsRule();
    VersionRule maxVersionCondition = GCRULES.maxVersions(2);
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
    tableAdmin.addFamilyWithUnionRule();
    DurationRule maxAgeRule = GCRULES.maxAge(5, TimeUnit.DAYS);
    VersionRule versionRule = GCRULES.maxVersions(1);
    UnionRule unionCondition = GCRULES.union().rule(maxAgeRule).rule(versionRule);
    boolean unionRule = ruleCheck(unionCondition);
    assertTrue(unionRule);
  }

  @Test
  public void testCreateIntersectionRule() {
    // Intersection rule
    tableAdmin.addFamilyWithIntersectionRule();
    DurationRule maxAgeRule = GCRULES.maxAge(5, TimeUnit.DAYS);
    VersionRule versionRule = GCRULES.maxVersions(2);
    IntersectionRule intersectionCondition =
        GCRULES.intersection().rule(maxAgeRule).rule(versionRule);
    boolean intersectionRule = ruleCheck(intersectionCondition);
    assertTrue(intersectionRule);
  }

  @Test
  public void testCreateNestedRule() {
    // Nested rule
    tableAdmin.addFamilyWithNestedRule();
    VersionRule versionRule = GCRULES.maxVersions(10);
    DurationRule maxAgeRule = GCRULES.maxAge(30, TimeUnit.DAYS);
    VersionRule versionRule2 = GCRULES.maxVersions(2);
    IntersectionRule intersectionRule = GCRULES.intersection().rule(maxAgeRule).rule(versionRule2);
    UnionRule nestedCondition = GCRULES.union().rule(intersectionRule).rule(versionRule);
    boolean nestedRule = ruleCheck(nestedCondition);
    assertTrue(nestedRule);
  }

  @Test
  public void testRunDoesNotFail() {
    tableAdmin.run();
  }

  // TODO: add test for tableAdmin.listAllTables()
  // TODO: add test for tableAdmin.getTableMeta()
  // TODO: add test for tableAdmin.listColumnFamilies()

  private boolean ruleCheck(GCRule condition) {
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
      String timestampStr = matcher.group(1);
      long timestamp = Long.parseLong(timestampStr, 16);
      if (System.currentTimeMillis() - timestamp < TimeUnit.MINUTES.toMillis(10)) {
        continue;
      }
      System.out.println("\nGarbage collecting orphaned table: " + tableId);
      adminClient.deleteTable(tableId);
    }
  }
}
