/*
 * Copyright 2020 Google LLC
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

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static io.grpc.Status.Code.NOT_FOUND;
import static org.junit.Assert.fail;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.Policy;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.Backup;
import com.google.cloud.bigtable.admin.v2.models.CreateBackupRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.RestoreTableRequest;
import com.google.cloud.bigtable.admin.v2.models.RestoredTableResult;
import com.google.cloud.bigtable.admin.v2.models.Table;
import com.google.cloud.bigtable.admin.v2.models.UpdateBackupRequest;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;

@RunWith(JUnit4.class)
public class BigtableBackupIT {
  private static final Logger LOGGER = Logger.getLogger(BigtableBackupIT.class.getName());

  private static final String PROJECT_PROPERTY_NAME = "bigtable.project";
  private static final String INSTANCE_PROPERTY_NAME = "bigtable.instance";
  private static final String CLUSTER_PROPERTY_NAME = "bigtable.cluster";
  private static final String ADMIN_ENDPOINT_PROPERTY_NAME = "bigtable.adminendpoint";
  private static final String DATA_ENDPOINT_PROPERTY_NAME = "bigtable.dataendpoint";
  private static final String TABLE_SIZE_PROPERTY_NAME = "bigtable.tablesizekb";
  private static final int[] BACKOFF_DURATION = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};

  private static final String TEST_TABLE_SUFFIX = "test-table-for-backup-it";
  private static final String TEST_BACKUP_SUFFIX = "test-backup-for-backup-it";

  private static final int DAYS_IN_SECONDS = 24 * 60 * 60;

  private static BigtableTableAdminClient tableAdmin;
  private static BigtableDataClient dataClient;

  private static String targetProject;
  private static String targetInstance;
  private static String targetCluster;
  private static Table testTable;
  private static String prefix;

  @BeforeClass
  public static void createClient()
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    List<String> missingProperties = Lists.newArrayList();

    targetProject = System.getProperty(PROJECT_PROPERTY_NAME);
    if (targetProject == null) {
      missingProperties.add(PROJECT_PROPERTY_NAME);
    }

    targetInstance = System.getProperty(INSTANCE_PROPERTY_NAME);
    if (targetInstance == null) {
      missingProperties.add(INSTANCE_PROPERTY_NAME);
    }

    targetCluster = System.getProperty(CLUSTER_PROPERTY_NAME);
    if (targetCluster == null) {
      missingProperties.add(CLUSTER_PROPERTY_NAME);
    }

    String adminApiEndpoint = System.getProperty(ADMIN_ENDPOINT_PROPERTY_NAME);
    if (adminApiEndpoint == null) {
      adminApiEndpoint = "bigtableadmin.googleapis.com:443";
    }

    int tableSize = MoreObjects.firstNonNull(Integer.getInteger(TABLE_SIZE_PROPERTY_NAME), 1);
    if (!missingProperties.isEmpty()) {
      LOGGER.warning("Missing properties: " + Joiner.on(",").join(missingProperties));
      return;
    }

    // Setup a prefix to avoid collisions between concurrent test runs
    prefix = String.format("020%d", System.currentTimeMillis());

    BigtableTableAdminSettings.Builder settings =
        BigtableTableAdminSettings.newBuilder()
            .setInstanceId(targetInstance)
            .setProjectId(targetProject);
    settings.stubSettings().setEndpoint(adminApiEndpoint);
    tableAdmin = BigtableTableAdminClient.create(settings.build());

    testTable =
        tableAdmin.createTable(
            CreateTableRequest.of(generateId(TEST_TABLE_SUFFIX)).addFamily("cf1"));

    // Populate test data.
    if (tableSize > 0) {
      String dataApiEndpoint = System.getProperty(DATA_ENDPOINT_PROPERTY_NAME);
      if (dataApiEndpoint == null) {
        dataApiEndpoint = "bigtable.googleapis.com:443";
      }
      BigtableDataSettings.Builder dataSettings =
          BigtableDataSettings.newBuilder()
              .setInstanceId(targetInstance)
              .setProjectId(targetProject);
      dataSettings.stubSettings().setEndpoint(dataApiEndpoint);
      dataClient = BigtableDataClient.create(dataSettings.build());
      byte[] rowBytes = new byte[1024];
      Random random = new Random();
      random.nextBytes(rowBytes);

      List<ApiFuture<?>> futures = Lists.newArrayList();
      for (int i = 0; i < tableSize; i++) {
        ApiFuture<Void> future =
            dataClient.mutateRowAsync(
                RowMutation.create(testTable.getId(), "test-row-" + i)
                    .setCell("cf1", "", rowBytes.toString()));
        futures.add(future);
      }
      ApiFutures.allAsList(futures).get(3, TimeUnit.MINUTES);
    }

    // Cleanup old backups and tables, under normal circumstances this will do nothing
    String stalePrefix =
        String.format("020%d", System.currentTimeMillis() - TimeUnit.HOURS.toMillis(2));
    for (String backupId : tableAdmin.listBackups(targetCluster)) {
      if (backupId.endsWith(TEST_BACKUP_SUFFIX) && stalePrefix.compareTo(backupId) > 0) {
        LOGGER.info("Deleting stale backup: " + backupId);
        tableAdmin.deleteBackup(targetCluster, backupId);
      }
    }
    for (String tableId : tableAdmin.listTables()) {
      if (tableId.endsWith("TEST_TABLE_SUFFIX") && stalePrefix.compareTo(tableId) > 0) {
        LOGGER.info("Deleting stale backup: " + tableId);
        tableAdmin.deleteTable(tableId);
      }
    }
  }

  @AfterClass
  public static void closeClient() {
    if (testTable != null) {
      try {
        tableAdmin.deleteTable(testTable.getId());
      } catch (Exception e) {
        // Ignore.
      }
    }

    if (tableAdmin != null) {
      tableAdmin.close();
    }

    if (dataClient != null) {
      dataClient.close();
    }
  }

  @Before
  public void setup() {
    if (tableAdmin == null) {
      throw new AssumptionViolatedException(
          "Required properties are not set, skipping integration tests.");
    }
  }

  @Test
  public void createAndGetBackupTest() throws InterruptedException {
    Instant expireTime = Instant.now().plus(Duration.ofDays(15));
    String backupId = generateId(TEST_BACKUP_SUFFIX);
    CreateBackupRequest request =
        CreateBackupRequest.of(targetCluster, backupId)
            .setSourceTableId(testTable.getId())
            .setExpireTime(expireTime);
    try {
      Backup response = tableAdmin.createBackup(request);
      assertWithMessage("Got wrong backup Id in CreateBackup")
          .that(response.getId())
          .isEqualTo(backupId);
      assertWithMessage("Got wrong source table name in CreateBackup")
          .that(response.getSourceTableId())
          .isEqualTo(testTable.getId());
      assertWithMessage("Got wrong expire time in CreateBackup")
          .that(response.getExpireTime())
          .isEqualTo(expireTime);

      Backup result = tableAdmin.getBackup(targetCluster, backupId);
      assertWithMessage("Got wrong backup Id in GetBackup API")
          .that(result.getId())
          .isEqualTo(backupId);
      assertWithMessage("Got wrong source table name in GetBackup API")
          .that(result.getSourceTableId())
          .isEqualTo(testTable.getId());
      assertWithMessage("Got wrong expire time in GetBackup API")
          .that(result.getExpireTime())
          .isEqualTo(expireTime);
      assertWithMessage("Got empty start time in GetBackup API")
          .that(result.getStartTime())
          .isNotEqualTo(Timestamp.getDefaultInstance());
      assertWithMessage("Got wrong size bytes in GetBackup API")
          .that(result.getSizeBytes())
          .isEqualTo(0L);
      assertWithMessage("Got wrong state in GetBackup API")
          .that(result.getState())
          .isAnyOf(Backup.State.CREATING, Backup.State.READY);

    } finally {
      tableAdmin.deleteBackup(targetCluster, backupId);
    }
  }

  @Test
  public void listBackupTest() throws InterruptedException {
    String backupId1 = generateId("list-1-" + TEST_BACKUP_SUFFIX);
    String backupId2 = generateId("list-2-" + TEST_BACKUP_SUFFIX);

    try {
      createBackupAndWait(backupId1);
      createBackupAndWait(backupId2);

      List<String> response = tableAdmin.listBackups(targetCluster);
      // Concurrent tests running may cause flakiness. Use containsAtLeast instead of
      // containsExactly.
      assertWithMessage("Incorrect backup name")
          .that(response)
          .containsAtLeast(backupId1, backupId2);
    } finally {
      tableAdmin.deleteBackup(targetCluster, backupId1);
      tableAdmin.deleteBackup(targetCluster, backupId2);
    }
  }

  @Test
  public void updateBackupTest() throws InterruptedException {
    String backupId = generateId("update-" + TEST_BACKUP_SUFFIX);
    createBackupAndWait(backupId);

    Instant expireTime = Instant.now().plus(Duration.ofDays(20));
    UpdateBackupRequest req =
        UpdateBackupRequest.of(targetCluster, backupId).setExpireTime(expireTime);
    try {
      Backup backup = tableAdmin.updateBackup(req);
      assertWithMessage("Incorrect expire time").that(backup.getExpireTime()).isEqualTo(expireTime);
    } finally {
      tableAdmin.deleteBackup(targetCluster, backupId);
    }
  }

  @Test
  public void deleteBackupTest() throws InterruptedException {
    String backupId = generateId("delete-" + TEST_BACKUP_SUFFIX);

    createBackupAndWait(backupId);
    tableAdmin.deleteBackup(targetCluster, backupId);

    try {
      for (int i = 0; i < BACKOFF_DURATION.length; i++) {
        tableAdmin.getBackup(targetCluster, backupId);

        LOGGER.info("Wait for " + BACKOFF_DURATION[i] + " seconds for deleting backup " + backupId);
        Thread.sleep(BACKOFF_DURATION[i] * 1000);
      }
      fail("backup was not deleted.");
    } catch (ApiException ex) {
      assertWithMessage("Incorrect exception type")
          .that(ex.getCause())
          .isInstanceOf(StatusRuntimeException.class);
      assertWithMessage("Incorrect error message")
          .that(((StatusRuntimeException) ex.getCause()).getStatus().getCode())
          .isEqualTo(NOT_FOUND);
    }
  }

  @Test
  public void restoreTableTest() throws InterruptedException, ExecutionException {
    String backupId = generateId("restore-" + TEST_BACKUP_SUFFIX);
    String tableId = generateId("restored-table");
    createBackupAndWait(backupId);

    // Wait 2 minutes so that the RestoreTable API will trigger an optimize restored
    // table operation.
    Thread.sleep(120 * 1000);

    try {
      RestoreTableRequest req = RestoreTableRequest.of(targetCluster, backupId).setTableId(tableId);
      RestoredTableResult result = tableAdmin.restoreTable(req);
      assertWithMessage("Incorrect restored table id")
          .that(result.getTable().getId())
          .isEqualTo(tableId);

      // The assertion might be missing if the test is running against a HDD cluster or an
      // optimization is not necessary.
      assertWithMessage("Empty OptimizeRestoredTable token")
          .that(result.getOptimizeRestoredTableOperationToken())
          .isNotNull();
      tableAdmin.awaitOptimizeRestoredTable(result.getOptimizeRestoredTableOperationToken());
      tableAdmin.getTable(tableId);
    } finally {
      tableAdmin.deleteBackup(targetCluster, backupId);
      tableAdmin.deleteTable(tableId);
    }
  }

  @Test
  public void backupIamTest() throws InterruptedException {
    String backupId = generateId("iam-" + TEST_BACKUP_SUFFIX);
    createBackupAndWait(backupId);

    Policy policy = tableAdmin.getBackupIamPolicy(targetCluster, backupId);
    assertThat(policy).isNotNull();

    Exception actualEx = null;
    try {
      assertThat(tableAdmin.setBackupIamPolicy(targetCluster, backupId, policy)).isNotNull();
    } catch (Exception iamException) {
      actualEx = iamException;
    }
    assertThat(actualEx).isNull();

    List<String> permissions =
        tableAdmin.testBackupIamPermission(
            targetCluster,
            backupId,
            "bigtable.backups.get",
            "bigtable.backups.delete",
            "bigtable.backups.update",
            "bigtable.backups.restore");
    assertThat(permissions).hasSize(4);
  }

  private CreateBackupRequest createBackupRequest(String backupName) {
    return CreateBackupRequest.of(targetCluster, backupName)
        .setSourceTableId(testTable.getId())
        .setExpireTime(Instant.now().plus(Duration.ofDays(15)));
  }

  private static String generateId(String name) {
    return prefix + "-" + name;
  }

  private void createBackupAndWait(String backupId) throws InterruptedException {
    tableAdmin.createBackup(createBackupRequest(backupId));
    for (int i = 0; i < BACKOFF_DURATION.length; i++) {
      try {
        Backup backup = tableAdmin.getBackup(targetCluster, backupId);
        if (backup.getState() == Backup.State.READY) {
          return;
        }
      } catch (ApiException ex) {
        LOGGER.info("Wait for " + BACKOFF_DURATION[i] + " seconds for creating backup " + backupId);
      }

      Thread.sleep(BACKOFF_DURATION[i] * 1000);
    }

    fail("Creating Backup Timeout");
  }
}
