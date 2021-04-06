/*
 * Copyright 2021 Google LLC
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
import static com.google.common.truth.TruthJUnit.assume;
import static org.junit.Assert.fail;

import com.google.api.gax.rpc.ApiException;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.internal.NameUtil;
import com.google.cloud.bigtable.admin.v2.models.Backup;
import com.google.cloud.bigtable.admin.v2.models.Cluster;
import com.google.cloud.bigtable.admin.v2.models.CreateBackupRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateClusterRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateInstanceRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.EncryptionInfo;
import com.google.cloud.bigtable.admin.v2.models.StorageType;
import com.google.cloud.bigtable.common.Status;
import com.google.cloud.bigtable.common.Status.Code;
import com.google.cloud.bigtable.test_helpers.env.AbstractTestEnv;
import com.google.cloud.bigtable.test_helpers.env.EmulatorEnv;
import com.google.cloud.bigtable.test_helpers.env.TestEnvRule;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Instant;
import org.threeten.bp.temporal.ChronoUnit;

/**
 * Tests our CMEK offering. It can take up to 5 mins after a CMEK-protected table is created for the
 * key version and status fields to be populated. Set the `bigtable.wait-for-cmek-key-status` system
 * property to `true` when running the test in order to poll until the final state can be asserted.
 */
@RunWith(JUnit4.class)
public class BigtableCmekIT {

  private static final int[] BACKOFF_DURATION = {5, 10, 50, 100, 150, 200, 250, 300};
  private static final Logger LOGGER = Logger.getLogger(BigtableCmekIT.class.getName());
  private static final String TEST_TABLE_ID = "test-table-for-cmek-it";
  private static final String BACKUP_ID = "test-table-for-cmek-it-backup";

  @ClassRule public static TestEnvRule testEnvRule = new TestEnvRule();

  private static String instanceId;
  private static String clusterId1;
  private static String clusterId2;
  private static String kmsKeyName;
  private static String zoneId;

  private static BigtableInstanceAdminClient instanceAdmin;
  private static BigtableTableAdminClient tableAdmin;

  @BeforeClass
  public static void validatePlatform() throws IOException {
    assume()
        .withMessage("Emulator doesn't support CMEK")
        .that(testEnvRule.env())
        .isNotInstanceOf(EmulatorEnv.class);

    kmsKeyName = testEnvRule.env().getKmsKeyName();
    assertThat(kmsKeyName).isNotNull();
    assertThat(kmsKeyName).isNotEmpty();

    instanceId = AbstractTestEnv.TEST_INSTANCE_PREFIX + Instant.now().getEpochSecond();
    clusterId1 = instanceId + "-c1";
    clusterId2 = instanceId + "-c2";
    zoneId = testEnvRule.env().getPrimaryZone();

    instanceAdmin = testEnvRule.env().getInstanceAdminClient();
    tableAdmin =
        BigtableTableAdminClient.create(
            testEnvRule
                .env()
                .getTableAdminSettings()
                .toBuilder()
                .setInstanceId(instanceId)
                .build());
  }

  @AfterClass
  public static void teardown() {
    if (tableAdmin != null) {
      tableAdmin.close();
    }
    if (instanceAdmin != null) {
      instanceAdmin.close();
    }
  }

  @Test
  public void instanceAndClusterTest() {
    try {
      // With a KMS_KEY created and specified using `bigtable.kms_key_name` env variable, create a
      // CMEK protected instance
      instanceAdmin.createInstance(
          CreateInstanceRequest.of(instanceId)
              .addCmekCluster(clusterId1, zoneId, 1, StorageType.SSD, kmsKeyName));

      // Keys are specified per-cluster with each cluster requesting the same key and the cluster's
      // zone must be within the region of the key
      Cluster cluster = instanceAdmin.getCluster(instanceId, clusterId1);
      assertThat(cluster.getKmsKeyName()).isEqualTo(kmsKeyName);

      String secondZoneId = testEnvRule.env().getPrimaryRegionSecondZone();
      instanceAdmin.createCluster(
          CreateClusterRequest.of(instanceId, clusterId2)
              .setZone(secondZoneId)
              .setServeNodes(1)
              .setStorageType(StorageType.SSD)
              .setKmsKeyName(kmsKeyName));

      Cluster secondCluster = instanceAdmin.getCluster(instanceId, clusterId2);
      assertThat(secondCluster.getKmsKeyName()).isEqualTo(kmsKeyName);

      final String nonPrimaryRegionZoneId = testEnvRule.env().getSecondaryZone();
      try {
        instanceAdmin.createCluster(
            CreateClusterRequest.of(instanceId, clusterId2)
                .setZone(nonPrimaryRegionZoneId)
                .setServeNodes(1)
                .setStorageType(StorageType.SSD)
                .setKmsKeyName(kmsKeyName));
      } catch (com.google.api.gax.rpc.FailedPreconditionException e) {
        assertThat(e.getMessage())
            .contains(
                "FAILED_PRECONDITION: Error in field 'cluster' : "
                    + "Error in field 'encryption_config.kms_key_name' : CMEK key "
                    + kmsKeyName
                    + " cannot be used to protect a cluster in zone "
                    + NameUtil.formatLocationName(
                        testEnvRule.env().getProjectId(), nonPrimaryRegionZoneId));
      }
    } finally {
      instanceAdmin.deleteInstance(instanceId);
    }
  }

  @Test
  public void tableTest() throws Exception {
    try {
      instanceAdmin.createInstance(
          CreateInstanceRequest.of(instanceId)
              .addCmekCluster(clusterId1, zoneId, 1, StorageType.SSD, kmsKeyName));

      // Create a table. Key is inherited from the cluster configuration
      tableAdmin.createTable(CreateTableRequest.of(TEST_TABLE_ID).addFamily("cf"));

      // Confirm that table is CMEK-protected
      if (testEnvRule.env().shouldWaitForCmekKeyStatusUpdate()) {
        waitForCmekStatus(TEST_TABLE_ID, clusterId1);
      }
      Map<String, List<EncryptionInfo>> encryptionInfos =
          tableAdmin.getEncryptionInfo(TEST_TABLE_ID);
      assertThat(encryptionInfos).hasSize(1);
      assertThat(encryptionInfos.get(clusterId1)).hasSize(1);
      EncryptionInfo encryptionInfo = encryptionInfos.get(clusterId1).get(0);
      assertThat(encryptionInfo.getType())
          .isEqualTo(EncryptionInfo.Type.CUSTOMER_MANAGED_ENCRYPTION);
      assertThat(encryptionInfo.getStatus().getCode()).isAnyOf(Status.Code.OK, Status.Code.UNKNOWN);
      if (testEnvRule.env().shouldWaitForCmekKeyStatusUpdate()) {
        assertThat(encryptionInfo.getStatus().getCode()).isEqualTo(Status.Code.OK);
      }
      // For up to 5 minutes after a table is newly created, the key version and status fields are
      // not
      // populated.
      // Set the `bigtable.wait-for-cmek-key-status` system property to `true` when running the test
      // in order to poll until the final state can be asserted.
      if (encryptionInfo.getStatus().getCode() == Code.UNKNOWN) {
        assertThat(encryptionInfo.getKmsKeyVersion()).isEmpty();
        assertThat(encryptionInfo.getStatus().getMessage())
            .isEqualTo("Key version is not yet known.");
      } else {
        assertThat(encryptionInfo.getKmsKeyVersion()).startsWith(kmsKeyName);
        assertThat(encryptionInfo.getStatus().getMessage()).isEqualTo("");
      }
    } finally {
      tableAdmin.deleteTable(TEST_TABLE_ID);
      instanceAdmin.deleteInstance(instanceId);
    }
  }

  @Test
  public void backupTest() {
    try {
      instanceAdmin.createInstance(
          CreateInstanceRequest.of(instanceId)
              .addCmekCluster(clusterId1, zoneId, 1, StorageType.SSD, kmsKeyName));
      tableAdmin.createTable(CreateTableRequest.of(TEST_TABLE_ID).addFamily("cf"));

      // Create a backup.
      // Backups are pinned to the primary version of their table's CMEK key at the time they are
      // taken
      tableAdmin.createBackup(
          CreateBackupRequest.of(clusterId1, BACKUP_ID)
              .setExpireTime(Instant.now().plus(6, ChronoUnit.HOURS))
              .setSourceTableId(TEST_TABLE_ID));

      Backup backup = tableAdmin.getBackup(clusterId1, BACKUP_ID);

      // Confirm encryption details for an existing backup
      // The backup will be returned with the CMEK key version that the backup is pinned to.
      // The status of that key version will always be UNKNOWN.
      assertThat(backup.getEncryptionInfo().getKmsKeyVersion()).startsWith(kmsKeyName);
      assertThat(backup.getEncryptionInfo().getStatus().getCode()).isEqualTo(Status.Code.UNKNOWN);
      assertThat(backup.getEncryptionInfo().getType())
          .isEqualTo(EncryptionInfo.Type.CUSTOMER_MANAGED_ENCRYPTION);
      assertThat(backup.getEncryptionInfo().getStatus().getMessage())
          .isEqualTo("Status of the associated key version is not tracked.");
    } finally {
      tableAdmin.deleteBackup(clusterId1, BACKUP_ID);
      tableAdmin.deleteTable(TEST_TABLE_ID);
      instanceAdmin.deleteInstance(instanceId);
    }
  }

  private void waitForCmekStatus(String tableId, String clusterId) throws InterruptedException {
    for (int i = 0; i < BACKOFF_DURATION.length; i++) {
      try {
        EncryptionInfo encryptionInfo = tableAdmin.getEncryptionInfo(tableId).get(clusterId).get(0);
        if (encryptionInfo.getStatus().getCode() == Code.OK) {
          return;
        }
      } catch (ApiException ex) {
        LOGGER.info(
            "Wait for "
                + BACKOFF_DURATION[i]
                + " seconds for key status for table "
                + tableId
                + " and cluster "
                + clusterId);
      }
      Thread.sleep(BACKOFF_DURATION[i] * 1000);
    }
    fail("CMEK key status failed to return");
  }
}
