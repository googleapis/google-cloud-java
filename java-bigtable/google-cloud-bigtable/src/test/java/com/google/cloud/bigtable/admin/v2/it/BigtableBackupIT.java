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
import static com.google.common.truth.TruthJUnit.assume;
import static io.grpc.Status.Code.NOT_FOUND;
import static org.junit.Assert.fail;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.Policy;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.models.Backup;
import com.google.cloud.bigtable.admin.v2.models.CreateBackupRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateInstanceRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.Instance.Type;
import com.google.cloud.bigtable.admin.v2.models.RestoreTableRequest;
import com.google.cloud.bigtable.admin.v2.models.RestoredTableResult;
import com.google.cloud.bigtable.admin.v2.models.StorageType;
import com.google.cloud.bigtable.admin.v2.models.Table;
import com.google.cloud.bigtable.admin.v2.models.UpdateBackupRequest;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.test_helpers.env.AbstractTestEnv;
import com.google.cloud.bigtable.test_helpers.env.EmulatorEnv;
import com.google.cloud.bigtable.test_helpers.env.TestEnvRule;
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
  @ClassRule public static TestEnvRule testEnvRule = new TestEnvRule();

  private static final Logger LOGGER = Logger.getLogger(BigtableBackupIT.class.getName());

  private static final int[] BACKOFF_DURATION = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};

  private static final String TEST_TABLE_SUFFIX = "test-table-for-backup-it";
  private static final String TEST_BACKUP_SUFFIX = "test-backup-for-backup-it";

  private static BigtableTableAdminClient tableAdmin;
  private static BigtableInstanceAdminClient instanceAdmin;
  private static BigtableDataClient dataClient;

  private static String targetInstance;
  private static String targetCluster;
  private static Table testTable;
  private static String prefix;

  @BeforeClass
  public static void createClient()
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    assume()
        .withMessage("BigtableInstanceAdminClient is not supported on Emulator")
        .that(testEnvRule.env())
        .isNotInstanceOf(EmulatorEnv.class);

    instanceAdmin = testEnvRule.env().getInstanceAdminClient();

    targetCluster = AbstractTestEnv.TEST_CLUSTER_PREFIX + Instant.now().getEpochSecond();
    targetInstance =
        AbstractTestEnv.TEST_INSTANCE_PREFIX + "backup-" + Instant.now().getEpochSecond();

    instanceAdmin.createInstance(
        CreateInstanceRequest.of(targetInstance)
            .addCluster(targetCluster, testEnvRule.env().getPrimaryZone(), 3, StorageType.SSD)
            .setDisplayName("backups-test-instance")
            .addLabel("state", "readytodelete")
            .setType(Type.PRODUCTION));

    // Setup a prefix to avoid collisions between concurrent test runs
    prefix = String.format("020%d", System.currentTimeMillis());

    tableAdmin = BigtableTableAdminClient.create(testEnvRule.env().getProjectId(), targetInstance);

    testTable =
        tableAdmin.createTable(
            CreateTableRequest.of(generateId(TEST_TABLE_SUFFIX)).addFamily("cf1"));

    // Populate test data.
    dataClient = BigtableDataClient.create(testEnvRule.env().getProjectId(), targetInstance);
    byte[] rowBytes = new byte[1024];
    Random random = new Random();
    random.nextBytes(rowBytes);

    List<ApiFuture<?>> futures = Lists.newArrayList();
    for (int i = 0; i < 10; i++) {
      ApiFuture<Void> future =
          dataClient.mutateRowAsync(
              RowMutation.create(testTable.getId(), "test-row-" + i)
                  .setCell("cf1", "", rowBytes.toString()));
      futures.add(future);
    }
    ApiFutures.allAsList(futures).get(3, TimeUnit.MINUTES);
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

    if (targetInstance != null) {
      instanceAdmin.deleteInstance(targetInstance);
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
      tableAdmin.createBackup(createBackupRequest(backupId1));
      tableAdmin.createBackup(createBackupRequest(backupId2));

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
    tableAdmin.createBackup(createBackupRequest(backupId));

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

    tableAdmin.createBackup(createBackupRequest(backupId));
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
    tableAdmin.createBackup(createBackupRequest(backupId));

    // Wait 2 minutes so that the RestoreTable API will trigger an optimize restored
    // table operation.
    Thread.sleep(120 * 1000);

    try {
      RestoreTableRequest req = RestoreTableRequest.of(targetCluster, backupId).setTableId(tableId);
      RestoredTableResult result = tableAdmin.restoreTable(req);
      assertWithMessage("Incorrect restored table id")
          .that(result.getTable().getId())
          .isEqualTo(tableId);

      if (result.getOptimizeRestoredTableOperationToken() != null) {
        // The assertion might be missing if the test is running against a HDD cluster or an
        // optimization is not necessary.
        tableAdmin.awaitOptimizeRestoredTable(result.getOptimizeRestoredTableOperationToken());
        Table restoredTable = tableAdmin.getTable(tableId);
        assertWithMessage("Incorrect restored table id")
            .that(restoredTable.getId())
            .isEqualTo(tableId);
      }
    } finally {
      tableAdmin.deleteBackup(targetCluster, backupId);
      tableAdmin.deleteTable(tableId);
    }
  }

  @Test
  public void backupIamTest() throws InterruptedException {
    String backupId = generateId("iam-" + TEST_BACKUP_SUFFIX);

    try {
      tableAdmin.createBackup(createBackupRequest(backupId));

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
    } finally {
      tableAdmin.deleteBackup(targetCluster, backupId);
    }
  }

  private CreateBackupRequest createBackupRequest(String backupName) {
    return CreateBackupRequest.of(targetCluster, backupName)
        .setSourceTableId(testTable.getId())
        .setExpireTime(Instant.now().plus(Duration.ofDays(15)));
  }

  private static String generateId(String name) {
    return prefix + "-" + name;
  }
}
