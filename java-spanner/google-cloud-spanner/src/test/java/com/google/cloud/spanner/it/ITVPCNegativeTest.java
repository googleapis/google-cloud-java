/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.it;

import static com.google.cloud.spanner.testing.ExperimentalHostHelper.isExperimentalHost;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.PermissionDeniedException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.Policy;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.BackupId;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.InstanceAdminClient;
import com.google.cloud.spanner.InstanceId;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SerialIntegrationTest;
import com.google.cloud.spanner.SessionPoolOptions;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerOptions;
import com.google.common.base.Strings;
import com.google.longrunning.OperationsClient;
import com.google.longrunning.OperationsSettings;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration tests for VPC-SC */
@Category(SerialIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITVPCNegativeTest {
  private static final Logger logger = Logger.getLogger(ITVPCNegativeTest.class.getName());
  private static final String IN_VPCSC_TEST = System.getenv("GOOGLE_CLOUD_TESTS_IN_VPCSC");
  private static final String OUTSIDE_VPC_PROJECT =
      System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");

  private Spanner spanner;
  private InstanceAdminClient instanceAdminClient;
  private DatabaseAdminClient databaseAdminClient;
  private DatabaseClient databaseClient;
  private InstanceId instanceId;
  private BackupId backupId;

  @BeforeClass
  public static void setUpClass() {
    assumeFalse("Not applicable for experimental host", isExperimentalHost());
    assumeTrue(
        "To run tests, GOOGLE_CLOUD_TESTS_IN_VPCSC environment variable needs to be set to True",
        IN_VPCSC_TEST != null && IN_VPCSC_TEST.equalsIgnoreCase("true"));
    assertFalse(
        "GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT environment variable needs "
            + "to be set to a GCP project that is outside the VPC perimeter",
        Strings.isNullOrEmpty(OUTSIDE_VPC_PROJECT));
    assumeTrue(Strings.isNullOrEmpty(System.getenv("SPANNER_EMULATOR_HOST")));
  }

  @Before
  public void setUp() {
    instanceId = InstanceId.of(OUTSIDE_VPC_PROJECT, "nonexistent-instance");
    backupId = BackupId.of(OUTSIDE_VPC_PROJECT, "nonexistent-instance", "nonexistent-backup");
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId(instanceId.getProject())
            .setSessionPoolOption(
                SessionPoolOptions.newBuilder()
                    // Do not eagerly create sessions since they will fail outside the VPC.
                    .setMinSessions(0)
                    // Client shouldn't block if sessions cannot be created
                    .setFailIfPoolExhausted()
                    .build())
            .build();
    spanner = options.getService();
    instanceAdminClient = spanner.getInstanceAdminClient();
    databaseAdminClient = spanner.getDatabaseAdminClient();
    databaseClient =
        spanner.getDatabaseClient(
            DatabaseId.of(OUTSIDE_VPC_PROJECT, "nonexistent-instance", "nonexistent-database"));
  }

  @After
  public void tearDown() {
    spanner.close();
  }

  private void checkExceptionForVPCError(SpannerException e) {
    assertEquals(ErrorCode.PERMISSION_DENIED, e.getErrorCode());
    assertThat(e.getMessage()).contains("Request is prohibited by organization's policy");
  }

  @Test
  public void deniedListInstanceConfigs() {
    try {
      instanceAdminClient.listInstanceConfigs();
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (SpannerException e) {
      checkExceptionForVPCError(e);
    }
  }

  @Test
  public void deniedGetInstanceConfig() {
    try {
      instanceAdminClient.getInstanceConfig("nonexistent-configs");
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (SpannerException e) {
      checkExceptionForVPCError(e);
    }
  }

  @Test
  public void deniedListInstances() {
    try {
      instanceAdminClient.listInstances();
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (SpannerException e) {
      checkExceptionForVPCError(e);
    }
  }

  @Test
  public void deniedGetInstance() {
    try {
      instanceAdminClient.getInstance("non-existent");
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (SpannerException e) {
      checkExceptionForVPCError(e);
    }
  }

  @Test
  public void deniedListDatabases() {
    try {
      databaseAdminClient.listDatabases("nonexistent-instance", Options.pageSize(1));
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (SpannerException e) {
      checkExceptionForVPCError(e);
    }
  }

  @Test
  public void deniedGetDatabase() {
    try {
      databaseAdminClient.getDatabase("nonexistent-instance", "nonexistent-database");
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (SpannerException e) {
      checkExceptionForVPCError(e);
    }
  }

  @Test
  public void deniedRead() {
    // Getting a session and starting a read is non-blocking and will not cause an exception. Trying
    // to get results from the result set will.
    ResultSet rs =
        databaseClient
            .singleUse()
            .read("nonexistent-table", KeySet.all(), Collections.singletonList("nonexistent-col"));
    try {
      // Tests that the initial create session request returns a permission denied.
      rs.next();
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (SpannerException e) {
      checkExceptionForVPCError(e);
    }
  }

  @Test
  public void deniedCreateBackup() throws InterruptedException {
    try {
      databaseAdminClient
          .createBackup(instanceId.getInstance(), "newbackup-id", "nonexistent-db", Timestamp.now())
          .get();
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (ExecutionException e) {
      Throwable thrown = e.getCause();
      checkExceptionForVPCError((SpannerException) thrown);
    }
  }

  @Test
  public void deniedGetBackup() {
    try {
      databaseAdminClient.getBackup(instanceId.getInstance(), backupId.getBackup());
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (SpannerException e) {
      checkExceptionForVPCError(e);
    }
  }

  @Test
  public void deniedUpdateBackup() {
    try {
      databaseAdminClient.updateBackup(
          instanceId.getInstance(), backupId.getBackup(), Timestamp.now());
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (SpannerException e) {
      checkExceptionForVPCError(e);
    }
  }

  @Test
  public void deniedListBackup() {
    try {
      databaseAdminClient.listBackups(instanceId.getInstance());
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (SpannerException e) {
      checkExceptionForVPCError(e);
    }
  }

  @Test
  public void deniedDeleteBackup() {
    try {
      databaseAdminClient.deleteBackup(instanceId.getInstance(), backupId.getBackup());
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (SpannerException e) {
      checkExceptionForVPCError(e);
    }
  }

  @Test
  public void deniedRestoreDatabase() throws InterruptedException {
    try {
      databaseAdminClient
          .restoreDatabase(
              instanceId.getInstance(), "nonexistent-backup", instanceId.getInstance(), "newdb-id")
          .get();
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (ExecutionException e) {
      Throwable thrown = e.getCause();
      checkExceptionForVPCError((SpannerException) thrown);
    }
  }

  @Test
  public void deniedListBackupOperationsInInstance() {
    try {
      databaseAdminClient.listBackupOperations(instanceId.getInstance());
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (SpannerException e) {
      checkExceptionForVPCError(e);
    }
  }

  @Test
  public void deniedListDatabaseOperationsInInstance() {
    try {
      databaseAdminClient.listDatabaseOperations(instanceId.getInstance());
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (SpannerException e) {
      checkExceptionForVPCError(e);
    }
  }

  @Test
  public void deniedGetBackupIamPolicy() {
    try {
      databaseAdminClient.getBackupIAMPolicy(instanceId.getInstance(), backupId.getBackup());
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (SpannerException e) {
      checkExceptionForVPCError(e);
    }
  }

  @Test
  public void deniedSetBackupIamPolicy() {
    try {
      Policy policy = Policy.newBuilder().build();
      databaseAdminClient.setBackupIAMPolicy(
          backupId.getInstanceId().getInstance(), backupId.getBackup(), policy);
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (SpannerException e) {
      checkExceptionForVPCError(e);
    }
  }

  @Test
  public void deniedTestBackupIamPermissions() {
    try {
      List<String> permissions = new ArrayList<>();
      databaseAdminClient.testBackupIAMPermissions(
          backupId.getInstanceId().getInstance(), backupId.getBackup(), permissions);
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (SpannerException e) {
      checkExceptionForVPCError(e);
    }
  }

  @Test
  public void deniedCancelBackupOperation() {
    try {
      databaseAdminClient.cancelOperation(backupId.getName() + "/operations/nonexistentop");
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (SpannerException e) {
      checkExceptionForVPCError(e);
    }
  }

  @Test
  public void deniedGetBackupOperation() {
    try {
      databaseAdminClient.getOperation(backupId.getName() + "/operations/nonexistentop");
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (SpannerException e) {
      checkExceptionForVPCError(e);
    }
  }

  @Test
  public void deniedListBackupOperations() throws IOException {
    try (OperationsClient client =
        OperationsClient.create(
            OperationsSettings.newBuilder()
                .setTransportChannelProvider(InstantiatingGrpcChannelProvider.newBuilder().build())
                .setEndpoint("spanner.googleapis.com:443")
                .setCredentialsProvider(
                    FixedCredentialsProvider.create(GoogleCredentials.getApplicationDefault()))
                .build())) {
      client.listOperations(backupId.getName() + "/operations", "");
      fail("Expected PermissionDeniedException");
    } catch (PermissionDeniedException e) {
      assertThat(e.getMessage()).contains("Request is prohibited by organization's policy");
    }
  }
}
