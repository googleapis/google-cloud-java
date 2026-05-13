/*
 * Copyright 2024 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.bigtable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.AuthorizedView;
import com.google.cloud.bigtable.admin.v2.models.CreateAuthorizedViewRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.FamilySubsets;
import com.google.cloud.bigtable.admin.v2.models.SubsetView;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.AuthorizedViewId;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowCell;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AuthorizedViewExampleTest extends BigtableBaseTest {

  private static final String TABLE_PREFIX = "table";
  private static final String AUTHORIZED_VIEW_PREFIX = "authorized-view";
  private static final String COLUMN_FAMILY = "cf";
  private String tableId;
  private String authorizedViewId;
  private static BigtableDataClient dataClient;
  private static BigtableTableAdminClient adminClient;
  private AuthorizedViewExample authorizedViewExample;

  @BeforeClass
  public static void beforeClass() throws IOException {
    initializeVariables();
    BigtableDataSettings settings =
        BigtableDataSettings.newBuilder().setProjectId(projectId).setInstanceId(instanceId).build();
    dataClient = BigtableDataClient.create(settings);
    BigtableTableAdminSettings adminSettings =
        BigtableTableAdminSettings.newBuilder()
            .setProjectId(projectId)
            .setInstanceId(instanceId)
            .build();
    adminClient = BigtableTableAdminClient.create(adminSettings);
  }

  @AfterClass
  public static void afterClass() {
    garbageCollect();
    dataClient.close();
    adminClient.close();
  }

  @Before
  public void setup() throws IOException {
    tableId = generateResourceId(TABLE_PREFIX);
    authorizedViewId = generateResourceId(AUTHORIZED_VIEW_PREFIX);
    authorizedViewExample =
        new AuthorizedViewExample(projectId, instanceId, tableId, authorizedViewId);
    adminClient.createTable(CreateTableRequest.of(tableId).addFamily(COLUMN_FAMILY));
    adminClient.createAuthorizedView(
        CreateAuthorizedViewRequest.of(tableId, authorizedViewId)
            .setAuthorizedViewType(
                SubsetView.create()
                    .addRowPrefix("")
                    .setFamilySubsets(
                        COLUMN_FAMILY, FamilySubsets.create().addQualifierPrefix(""))));
  }

  @After
  public void after() {
    if (adminClient.exists(tableId)) {
      // Deleting a table also deletes all the authorized views inside it.
      adminClient.deleteTable(tableId);
    }
    authorizedViewExample.close();
  }

  @Test
  public void testRunDoesNotFail() {
    authorizedViewExample.run();
  }

  @Test
  public void testAuthorizedViewCreateUpdateDelete() throws IOException {
    // Creates an authorized view.
    String testAuthorizedViewId = generateResourceId(AUTHORIZED_VIEW_PREFIX);
    AuthorizedViewExample testAuthorizedViewExample =
        new AuthorizedViewExample(projectId, instanceId, tableId, testAuthorizedViewId);
    testAuthorizedViewExample.createAuthorizedView();
    AuthorizedView authorizedView = adminClient.getAuthorizedView(tableId, testAuthorizedViewId);
    assertEquals(authorizedView.getId(), testAuthorizedViewId);

    // Updates the authorized view.
    testAuthorizedViewExample.updateAuthorizedView();
    AuthorizedView updatedAuthorizedView =
        adminClient.getAuthorizedView(tableId, testAuthorizedViewId);
    assertNotEquals(authorizedView, updatedAuthorizedView);

    // Deletes the authorized view.
    testAuthorizedViewExample.deleteAuthorizedView();
    assertThrows(
        NotFoundException.class,
        () -> adminClient.getAuthorizedView(tableId, testAuthorizedViewId));

    testAuthorizedViewExample.close();
  }

  @Test
  public void testGetAuthorizedView() {
    AuthorizedView authorizedView = authorizedViewExample.getAuthorizedView();
    assertNotNull(authorizedView);
    assertEquals(authorizedView.getId(), authorizedViewId);
  }

  @Test
  public void testListAuthorizedView() {
    List<String> authorizedViewIds = authorizedViewExample.listAllAuthorizedViews();
    assertEquals(authorizedViewIds.size(), 1);
    assertEquals(authorizedViewIds.get(0), authorizedViewId);
  }

  @Test
  public void testWriteToAuthorizedView() {
    assertNull(dataClient.readRow(AuthorizedViewId.of(tableId, authorizedViewId), "rowKey0"));
    authorizedViewExample.writeToAuthorizedView();
    assertNotNull(dataClient.readRow(AuthorizedViewId.of(tableId, authorizedViewId), "rowKey0"));
  }

  @Test
  public void testReadsFromAuthorizedView() {
    authorizedViewExample.writeToAuthorizedView();

    Row actualRow = authorizedViewExample.readSingleRowFromAuthorizedView();
    assertEquals("rowKey0", actualRow.getKey().toStringUtf8());
    assertEquals(2, actualRow.getCells().size());
    assertEquals("Hello World!", actualRow.getCells().get(0).getValue().toStringUtf8());
    assertEquals("World", actualRow.getCells().get(1).getValue().toStringUtf8());

    List<Row> rows = authorizedViewExample.readRowsWithFilterFromAuthorizedView();
    List<String> printedRows = new ArrayList<>();
    for (Row row : rows) {
      for (RowCell cell : row.getCells()) {
        printedRows.add(
            String.format(
                "%s_%s_%s:%s",
                row.getKey().toStringUtf8(),
                cell.getFamily(),
                cell.getQualifier().toStringUtf8(),
                cell.getValue().toStringUtf8()));
      }
    }
    String[] expectedRows =
        new String[] {
          "rowKey0_cf_greeting:Hello World!",
          "rowKey0_cf_name:World",
          "rowKey1_cf_greeting:Hello Bigtable!",
          "rowKey1_cf_name:Bigtable",
          "rowKey2_cf_greeting:Hello Java!",
          "rowKey2_cf_name:Java"
        };
    assertEquals(printedRows, Arrays.asList(expectedRows));
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
