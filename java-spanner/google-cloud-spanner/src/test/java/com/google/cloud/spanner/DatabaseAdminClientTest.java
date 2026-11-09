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

package com.google.cloud.spanner;

import static com.google.cloud.spanner.SpannerApiFutures.get;
import static com.google.cloud.spanner.testing.TimestampHelper.afterDays;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.paging.Page;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.Identity;
import com.google.cloud.NoCredentials;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.DatabaseInfo.State;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.longrunning.Operation;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.rpc.ErrorInfo;
import com.google.spanner.admin.database.v1.CreateBackupMetadata;
import com.google.spanner.admin.database.v1.CreateBackupRequest;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.database.v1.CreateDatabaseRequest;
import com.google.spanner.admin.database.v1.GetDatabaseRequest;
import com.google.spanner.admin.database.v1.OptimizeRestoredDatabaseMetadata;
import com.google.spanner.admin.database.v1.RestoreDatabaseMetadata;
import com.google.spanner.admin.database.v1.RestoreDatabaseRequest;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.protobuf.lite.ProtoLiteUtils;
import java.net.InetSocketAddress;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DatabaseAdminClientTest {
  private static final String PROJECT_ID = "my-project";
  private static final String INSTANCE_ID = "my-instance";
  private static final String DB_ID = "test-db";
  private static final String BCK_ID = "test-bck";
  private static final String RESTORED_ID = "restored-test-db";
  private static final String TEST_PARENT = "projects/my-project/instances/my-instance";
  private static final String TEST_BCK_NAME = String.format("%s/backups/test-bck", TEST_PARENT);
  private static final List<String> INITIAL_STATEMENTS =
      Arrays.asList("CREATE TABLE FOO", "CREATE TABLE BAR");

  private static MockOperationsServiceImpl mockOperations;
  private static MockDatabaseAdminServiceImpl mockDatabaseAdmin;
  private static Server server;

  private static Spanner spanner;
  private static DatabaseAdminClient client;
  private OperationFuture<Database, CreateDatabaseMetadata> createDatabaseOperation;
  private OperationFuture<Backup, CreateBackupMetadata> createBackupOperation;
  private OperationFuture<Database, RestoreDatabaseMetadata> restoreDatabaseOperation;

  @BeforeClass
  public static void startStaticServer() throws Exception {
    mockOperations = new MockOperationsServiceImpl();
    mockDatabaseAdmin = new MockDatabaseAdminServiceImpl(mockOperations);
    // This test uses a NettyServer to properly test network and timeout issues.
    InetSocketAddress address = new InetSocketAddress("localhost", 0);
    server =
        NettyServerBuilder.forAddress(address)
            .addService(mockOperations)
            .addService(mockDatabaseAdmin)
            .build()
            .start();
    SpannerOptions.Builder builder = SpannerOptions.newBuilder();
    RetrySettings longRunningInitialRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRpcTimeoutDuration(Duration.ofMillis(600L))
            .setMaxRpcTimeoutDuration(Duration.ofMillis(6000L))
            .setInitialRetryDelayDuration(Duration.ofMillis(20L))
            .setMaxRetryDelayDuration(Duration.ofMillis(45L))
            .setRetryDelayMultiplier(1.5)
            .setRpcTimeoutMultiplier(1.5)
            .setTotalTimeoutDuration(Duration.ofMinutes(48L))
            .build();
    builder
        .getDatabaseAdminStubSettingsBuilder()
        .createBackupOperationSettings()
        .setInitialCallSettings(
            UnaryCallSettings.<CreateBackupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                .setRetrySettings(longRunningInitialRetrySettings)
                .build());
    builder
        .getDatabaseAdminStubSettingsBuilder()
        .createBackupOperationSettings()
        .setPollingAlgorithm(
            OperationTimedPollAlgorithm.create(
                RetrySettings.newBuilder()
                    .setInitialRpcTimeoutDuration(Duration.ofMillis(20L))
                    .setInitialRetryDelayDuration(Duration.ofMillis(10L))
                    .setMaxRetryDelayDuration(Duration.ofMillis(150L))
                    .setMaxRpcTimeoutDuration(Duration.ofMillis(150L))
                    .setMaxAttempts(10)
                    .setTotalTimeoutDuration(Duration.ofMillis(5000L))
                    .setRetryDelayMultiplier(1.3)
                    .setRpcTimeoutMultiplier(1.3)
                    .build()));

    builder
        .getDatabaseAdminStubSettingsBuilder()
        .createDatabaseOperationSettings()
        .setInitialCallSettings(
            UnaryCallSettings
                .<CreateDatabaseRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                .setRetrySettings(longRunningInitialRetrySettings)
                .build());
    builder
        .getDatabaseAdminStubSettingsBuilder()
        .createDatabaseOperationSettings()
        .setPollingAlgorithm(
            OperationTimedPollAlgorithm.create(
                RetrySettings.newBuilder()
                    .setInitialRpcTimeoutDuration(Duration.ofMillis(20L))
                    .setInitialRetryDelayDuration(Duration.ofMillis(10L))
                    .setMaxRetryDelayDuration(Duration.ofMillis(150L))
                    .setMaxRpcTimeoutDuration(Duration.ofMillis(150L))
                    .setMaxAttempts(10)
                    .setTotalTimeoutDuration(Duration.ofMillis(5000L))
                    .setRetryDelayMultiplier(1.3)
                    .setRpcTimeoutMultiplier(1.3)
                    .build()));
    builder
        .getDatabaseAdminStubSettingsBuilder()
        .restoreDatabaseOperationSettings()
        .setInitialCallSettings(
            UnaryCallSettings
                .<RestoreDatabaseRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                .setRetrySettings(longRunningInitialRetrySettings)
                .build());
    builder
        .getDatabaseAdminStubSettingsBuilder()
        .restoreDatabaseOperationSettings()
        .setPollingAlgorithm(
            OperationTimedPollAlgorithm.create(
                RetrySettings.newBuilder()
                    .setInitialRpcTimeoutDuration(Duration.ofMillis(20L))
                    .setInitialRetryDelayDuration(Duration.ofMillis(10L))
                    .setMaxRetryDelayDuration(Duration.ofMillis(150L))
                    .setMaxRpcTimeoutDuration(Duration.ofMillis(150L))
                    .setMaxAttempts(10)
                    .setTotalTimeoutDuration(Duration.ofMillis(5000L))
                    .setRetryDelayMultiplier(1.3)
                    .setRpcTimeoutMultiplier(1.3)
                    .build()));
    builder.setRetryAdministrativeRequestsSettings(
        SpannerOptions.Builder.DEFAULT_ADMIN_REQUESTS_LIMIT_EXCEEDED_RETRY_SETTINGS.toBuilder()
            .setInitialRetryDelayDuration(Duration.ofNanos(1L))
            .build());
    spanner =
        builder
            .setHost("http://localhost:" + server.getPort())
            .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
            .setCredentials(NoCredentials.getInstance())
            .setProjectId(PROJECT_ID)
            .build()
            .getService();
    client = spanner.getDatabaseAdminClient();
  }

  @AfterClass
  public static void stopServer() throws Exception {
    spanner.close();
    server.shutdown();
    server.awaitTermination();
  }

  @Before
  public void setUp() {
    mockDatabaseAdmin.reset();
    mockOperations.reset();
    createTestDatabase();
    createTestBackup();
    restoreTestBackup();
  }

  @After
  public void tearDown() {
    mockDatabaseAdmin.reset();
    mockDatabaseAdmin.removeAllExecutionTimes();
    mockOperations.reset();
  }

  @Test
  public void dbAdminCreateBackup() throws InterruptedException, ExecutionException {
    final String backupId = "other-backup-id";
    OperationFuture<Backup, CreateBackupMetadata> op =
        client.createBackup(INSTANCE_ID, backupId, DB_ID, afterDays(7));
    Backup backup = op.get();
    assertThat(backup.getId().getName())
        .isEqualTo(
            String.format(
                "projects/%s/instances/%s/backups/%s", PROJECT_ID, INSTANCE_ID, backupId));
    assertThat(client.getBackup(INSTANCE_ID, backupId)).isEqualTo(backup);
  }

  @Test
  public void backupCreate() throws InterruptedException, ExecutionException {
    final String backupId = "other-backup-id";
    Backup backup =
        client
            .newBackupBuilder(BackupId.of(PROJECT_ID, INSTANCE_ID, backupId))
            .setDatabase(DatabaseId.of(PROJECT_ID, INSTANCE_ID, DB_ID))
            .setExpireTime(afterDays(7))
            .setVersionTime(sevenDaysAgo())
            .build();
    OperationFuture<Backup, CreateBackupMetadata> op = backup.create();
    backup = op.get();
    assertThat(backup.getId().getName())
        .isEqualTo(
            String.format(
                "projects/%s/instances/%s/backups/%s", PROJECT_ID, INSTANCE_ID, backupId));
    assertThat(client.getBackup(INSTANCE_ID, backupId)).isEqualTo(backup);
  }

  @Test
  public void databaseAdminBackupCreate() throws ExecutionException, InterruptedException {
    final String backupId = "other-backup-id";
    Backup backup =
        client
            .newBackupBuilder(BackupId.of(PROJECT_ID, INSTANCE_ID, backupId))
            .setDatabase(DatabaseId.of(PROJECT_ID, INSTANCE_ID, DB_ID))
            .setExpireTime(afterDays(7))
            .setVersionTime(sevenDaysAgo())
            .build();
    final OperationFuture<Backup, CreateBackupMetadata> op = client.createBackup(backup);
    backup = op.get();
    assertThat(backup.getId().getName())
        .isEqualTo(
            String.format(
                "projects/%s/instances/%s/backups/%s", PROJECT_ID, INSTANCE_ID, backupId));
    assertThat(client.getBackup(INSTANCE_ID, backupId)).isEqualTo(backup);
  }

  @Test
  public void backupCreateCancel() {
    final String backupId = "other-backup-id";
    // Set expire time to 14 days from now.
    long currentTimeInMicroSeconds =
        TimeUnit.MICROSECONDS.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    long deltaTimeInMicroseconds = TimeUnit.MICROSECONDS.convert(14L, TimeUnit.DAYS);
    Timestamp expireTime =
        Timestamp.ofTimeMicroseconds(currentTimeInMicroSeconds + deltaTimeInMicroseconds);
    Backup backup =
        client
            .newBackupBuilder(BackupId.of(PROJECT_ID, INSTANCE_ID, backupId))
            .setDatabase(DatabaseId.of(PROJECT_ID, INSTANCE_ID, DB_ID))
            .setExpireTime(expireTime)
            .build();
    // Start a creation of a backup.
    OperationFuture<Backup, CreateBackupMetadata> op = backup.create();
    try {
      // Try to cancel the backup operation.
      client.cancelOperation(op.getName());
      // Get a polling future for the running operation. This future will regularly poll the server
      // for the current status of the backup operation.
      RetryingFuture<OperationSnapshot> pollingFuture = op.getPollingFuture();
      // Wait for the operation to finish.
      // isDone will return true if the operation has finished successfully or if it was cancelled
      // or any other error occurred.
      while (!pollingFuture.get().isDone()) {
        Thread.sleep(TimeUnit.MILLISECONDS.convert(5, TimeUnit.SECONDS));
      }
    } catch (CancellationException e) {
      // ignore, this exception may also occur if the polling future has been cancelled.
    } catch (ExecutionException e) {
      throw (RuntimeException) e.getCause();
    } catch (InterruptedException e) {
      throw SpannerExceptionFactory.propagateInterrupt(e);
    } finally {
      backup.delete();
    }
  }

  @Test
  public void databaseBackup() throws InterruptedException, ExecutionException {
    final String backupId = "other-backup-id";
    Database db = client.getDatabase(INSTANCE_ID, DB_ID);
    Backup backup =
        db.backup(
                client
                    .newBackupBuilder(BackupId.of(PROJECT_ID, INSTANCE_ID, backupId))
                    .setExpireTime(afterDays(7))
                    .build())
            .get();
    assertThat(backup.getId().getName())
        .isEqualTo(
            String.format(
                "projects/%s/instances/%s/backups/%s", PROJECT_ID, INSTANCE_ID, backupId));
    assertThat(client.getBackup(INSTANCE_ID, backupId)).isEqualTo(backup);
  }

  @Test
  public void dbAdminCreateBackupAlreadyExists() {
    OperationFuture<Backup, CreateBackupMetadata> op =
        client.createBackup(INSTANCE_ID, BCK_ID, DB_ID, afterDays(7));
    SpannerException e = assertThrows(SpannerException.class, () -> get(op));
    assertEquals(ErrorCode.ALREADY_EXISTS, e.getErrorCode());
  }

  @Test
  public void backupCreateAlreadyExists() {
    Backup backup =
        client
            .newBackupBuilder(BackupId.of(PROJECT_ID, INSTANCE_ID, BCK_ID))
            .setDatabase(DatabaseId.of(PROJECT_ID, INSTANCE_ID, DB_ID))
            .setExpireTime(afterDays(7))
            .build();
    SpannerException e = assertThrows(SpannerException.class, () -> get(backup.create()));
    assertEquals(ErrorCode.ALREADY_EXISTS, e.getErrorCode());
  }

  @Test
  public void databaseBackupAlreadyExists() {
    Database db = client.getDatabase(INSTANCE_ID, DB_ID);
    OperationFuture<Backup, CreateBackupMetadata> op =
        db.backup(
            client
                .newBackupBuilder(BackupId.of(PROJECT_ID, INSTANCE_ID, BCK_ID))
                .setExpireTime(afterDays(7))
                .build());
    SpannerException e = assertThrows(SpannerException.class, () -> get(op));
    assertEquals(ErrorCode.ALREADY_EXISTS, e.getErrorCode());
  }

  @Test
  public void dbAdminCreateBackupDbNotFound() {
    final String backupId = "other-backup-id";
    OperationFuture<Backup, CreateBackupMetadata> op =
        client.createBackup(INSTANCE_ID, backupId, "does-not-exist", afterDays(7));
    SpannerException e = assertThrows(SpannerException.class, () -> get(op));
    assertEquals(ErrorCode.NOT_FOUND, e.getErrorCode());
  }

  @Test
  public void backupCreateDbNotFound() {
    final String backupId = "other-backup-id";
    Backup backup =
        client
            .newBackupBuilder(BackupId.of(PROJECT_ID, INSTANCE_ID, backupId))
            .setDatabase(DatabaseId.of(PROJECT_ID, INSTANCE_ID, "does-not-exist"))
            .setExpireTime(afterDays(7))
            .build();
    SpannerException e = assertThrows(SpannerException.class, () -> get(backup.create()));
    assertEquals(ErrorCode.NOT_FOUND, e.getErrorCode());
  }

  @Test
  public void databaseBackupDbNotFound() throws InterruptedException {
    final String backupId = "other-backup-id";
    Database db =
        new Database(
            DatabaseId.of(PROJECT_ID, INSTANCE_ID, "does-not-exist"), State.UNSPECIFIED, client);
    OperationFuture<Backup, CreateBackupMetadata> op =
        db.backup(
            client
                .newBackupBuilder(BackupId.of(PROJECT_ID, INSTANCE_ID, backupId))
                .setExpireTime(afterDays(7))
                .build());
    SpannerException e = assertThrows(SpannerException.class, () -> get(op));
    assertEquals(ErrorCode.NOT_FOUND, e.getErrorCode());
  }

  @Test
  public void dbAdminDeleteBackup() {
    Backup backup = client.newBackupBuilder(BackupId.of(PROJECT_ID, INSTANCE_ID, BCK_ID)).build();
    assertThat(backup.exists()).isTrue();
    client.deleteBackup(INSTANCE_ID, BCK_ID);
    assertThat(backup.exists()).isFalse();
  }

  @Test
  public void backupDelete() {
    Backup backup = client.newBackupBuilder(BackupId.of(PROJECT_ID, INSTANCE_ID, BCK_ID)).build();
    assertThat(backup.exists()).isTrue();
    backup.delete();
    assertThat(backup.exists()).isFalse();
  }

  @Test
  public void dbAdminDeleteBackupNotFound() {
    SpannerException e =
        assertThrows(
            SpannerException.class, () -> client.deleteBackup(INSTANCE_ID, "does-not-exist"));
    assertEquals(ErrorCode.NOT_FOUND, e.getErrorCode());
  }

  @Test
  public void backupDeleteNotFound() {
    Backup backup =
        client.newBackupBuilder(BackupId.of(PROJECT_ID, INSTANCE_ID, "does-not-exist")).build();
    SpannerException e = assertThrows(SpannerException.class, () -> backup.delete());
    assertEquals(ErrorCode.NOT_FOUND, e.getErrorCode());
  }

  @Test
  public void dbAdminGetBackup() {
    Backup backup = client.getBackup(INSTANCE_ID, BCK_ID);
    assertThat(backup.getId().getName()).isEqualTo(TEST_BCK_NAME);
  }

  @Test
  public void backupReload() {
    Backup backup = client.newBackupBuilder(BackupId.of(PROJECT_ID, INSTANCE_ID, BCK_ID)).build();
    assertThat(backup.getState()).isEqualTo(com.google.cloud.spanner.BackupInfo.State.UNSPECIFIED);
    backup.reload();
    assertThat(backup.getId().getName()).isEqualTo(TEST_BCK_NAME);
  }

  @Test
  public void dbAdminGetBackupNotFound() {
    SpannerException e =
        assertThrows(SpannerException.class, () -> client.getBackup(INSTANCE_ID, "does-not-exist"));
    assertEquals(ErrorCode.NOT_FOUND, e.getErrorCode());
  }

  @Test
  public void backupReloadNotFound() {
    Backup backup =
        client.newBackupBuilder(BackupId.of(PROJECT_ID, INSTANCE_ID, "does-not-exist")).build();
    SpannerException e = assertThrows(SpannerException.class, () -> backup.reload());
    assertEquals(ErrorCode.NOT_FOUND, e.getErrorCode());
  }

  @Test
  public void backupExists() {
    Backup backup =
        client.newBackupBuilder(BackupId.of(PROJECT_ID, INSTANCE_ID, "does-not-exist")).build();
    assertThat(backup.exists()).isFalse();
    backup = client.newBackupBuilder(BackupId.of(PROJECT_ID, INSTANCE_ID, BCK_ID)).build();
    assertThat(backup.exists()).isTrue();
  }

  @Test
  public void dbClientListBackups()
      throws SpannerException, InterruptedException, ExecutionException {
    Backup backup = client.getBackup(INSTANCE_ID, BCK_ID);
    assertThat(client.listBackups(INSTANCE_ID).iterateAll()).containsExactly(backup);
    Backup backup2 = client.createBackup(INSTANCE_ID, "backup2", DB_ID, afterDays(7)).get();
    assertThat(client.listBackups(INSTANCE_ID).iterateAll()).containsExactly(backup, backup2);
    backup2.delete();
    assertThat(client.listBackups(INSTANCE_ID).iterateAll()).containsExactly(backup);
  }

  @Test
  public void instanceListBackups()
      throws SpannerException, InterruptedException, ExecutionException {
    Instance instance =
        spanner
            .getInstanceAdminClient()
            .newInstanceBuilder(InstanceId.of(PROJECT_ID, INSTANCE_ID))
            .build();
    Backup backup = client.getBackup(INSTANCE_ID, BCK_ID);
    assertThat(instance.listBackups().iterateAll()).containsExactly(backup);
    Backup backup2 = client.createBackup(INSTANCE_ID, "backup2", DB_ID, afterDays(7)).get();
    assertThat(instance.listBackups().iterateAll()).containsExactly(backup, backup2);
    backup2.delete();
    assertThat(instance.listBackups().iterateAll()).containsExactly(backup);
  }

  @Test
  public void instanceListBackupsWithFilter()
      throws SpannerException, InterruptedException, ExecutionException {
    Instance instance =
        spanner
            .getInstanceAdminClient()
            .newInstanceBuilder(InstanceId.of(PROJECT_ID, INSTANCE_ID))
            .build();

    Backup backup = client.getBackup(INSTANCE_ID, BCK_ID);
    assertThat(instance.listBackups().iterateAll()).containsExactly(backup);
    Backup backup2 = client.createBackup(INSTANCE_ID, "backup2", DB_ID, afterDays(7)).get();

    // All backups.
    assertThat(instance.listBackups().iterateAll()).containsExactly(backup, backup2);

    // All backups with name containing 'backup2'.
    String filter = "name:backup2";
    mockDatabaseAdmin.addFilterMatches(filter, backup2.getId().getName());
    assertThat(instance.listBackups(Options.filter(filter)).iterateAll()).containsExactly(backup2);

    // All backups for a database with the name db2.
    filter = String.format("database:%s", DB_ID);
    mockDatabaseAdmin.addFilterMatches(filter, backup.getId().getName(), backup2.getId().getName());
    assertThat(instance.listBackups(Options.filter(filter)).iterateAll())
        .containsExactly(backup, backup2);

    // All backups that expire before a certain time.
    String ts = afterDays(14).toString();
    filter = String.format("expire_time < \"%s\"", ts);
    mockDatabaseAdmin.addFilterMatches(filter, backup.getId().getName(), backup2.getId().getName());
    assertThat(instance.listBackups(Options.filter(filter)).iterateAll())
        .containsExactly(backup, backup2);
    // All backups with size greater than a certain number of bytes.
    long minBytes = Math.min(backup.getSize(), backup2.getSize());
    filter = String.format("size_bytes > %d", minBytes);
    Backup backupWithLargestSize;
    if (backup.getSize() == minBytes) {
      backupWithLargestSize = backup2;
    } else {
      backupWithLargestSize = backup;
    }
    mockDatabaseAdmin.addFilterMatches(filter, backupWithLargestSize.getId().getName());
    assertThat(instance.listBackups(Options.filter(filter)).iterateAll())
        .containsExactly(backupWithLargestSize);
    // All backups with a create time after a certain timestamp and that are also ready.
    ts = backup2.getProto().getCreateTime().toString();
    filter = String.format("create_time >= \"%s\" AND state:READY", ts);
    mockDatabaseAdmin.addFilterMatches(filter, backup2.getId().getName());
    assertThat(instance.listBackups(Options.filter(filter)).iterateAll()).containsExactly(backup2);
  }

  @Test
  public void dbClientUpdateBackup() {
    Timestamp oldExpireTime = client.getBackup(INSTANCE_ID, BCK_ID).getExpireTime();
    Timestamp newExpireTime =
        Timestamp.ofTimeSecondsAndNanos(
            Timestamp.now().getSeconds() + TimeUnit.SECONDS.convert(1, TimeUnit.DAYS), 0);
    assertThat(oldExpireTime).isNotEqualTo(newExpireTime);
    Backup backup = client.updateBackup(INSTANCE_ID, BCK_ID, newExpireTime);
    assertThat(backup.getExpireTime()).isEqualTo(newExpireTime);
    assertThat(client.getBackup(INSTANCE_ID, BCK_ID)).isEqualTo(backup);
  }

  @Test
  public void backupUpdate() {
    Timestamp newExpireTime =
        Timestamp.ofTimeSecondsAndNanos(
            Timestamp.now().getSeconds() + TimeUnit.SECONDS.convert(1, TimeUnit.DAYS), 0);
    Backup backup = client.getBackup(INSTANCE_ID, BCK_ID);
    assertThat(backup.getExpireTime()).isNotEqualTo(newExpireTime);
    backup.toBuilder().setExpireTime(newExpireTime).build().updateExpireTime();
    Backup updated = client.getBackup(INSTANCE_ID, BCK_ID);
    assertThat(updated.getExpireTime()).isEqualTo(newExpireTime);
    assertThat(updated).isNotEqualTo(backup);
    assertThat(backup.reload()).isEqualTo(updated);
  }

  @Test
  public void dbClientRestoreDatabase() throws InterruptedException, ExecutionException {
    OperationFuture<Database, RestoreDatabaseMetadata> op =
        client.restoreDatabase(INSTANCE_ID, BCK_ID, "other-instance-id", "restored-db");
    Database restored = op.get();
    assertThat(restored.getId().getDatabase()).isEqualTo("restored-db");
    assertThat(restored.getId().getInstanceId().getInstance()).isEqualTo("other-instance-id");
  }

  @Test
  public void backupRestoreDatabase() throws InterruptedException, ExecutionException {
    Backup backup = client.newBackupBuilder(BackupId.of(PROJECT_ID, INSTANCE_ID, BCK_ID)).build();
    Database restored =
        backup.restore(DatabaseId.of(PROJECT_ID, "other-instance-id", "restored-db")).get();
    assertThat(restored.getId().getDatabase()).isEqualTo("restored-db");
    assertThat(restored.getId().getInstanceId().getInstance()).isEqualTo("other-instance-id");
  }

  @Test
  public void dbClientListDatabaseOperations()
      throws SpannerException, InterruptedException, ExecutionException {
    // Note: The mock server keeps all operations until the server is reset, including operations
    // that have already finished.
    // The setup method creates a test database --> 1 operation.
    // + restores a database --> 2 operations.
    assertThat(client.listDatabaseOperations(INSTANCE_ID).iterateAll()).hasSize(3);
    // Create another database which should also create another operation.
    client.createDatabase(INSTANCE_ID, "other-database", Collections.emptyList()).get();
    assertThat(client.listDatabaseOperations(INSTANCE_ID).iterateAll()).hasSize(4);
    // Restore a backup. This should create 2 database operations: One to restore the database and
    // one to optimize it.
    client.restoreDatabase(INSTANCE_ID, BCK_ID, INSTANCE_ID, "restored-db").get();
    assertThat(client.listDatabaseOperations(INSTANCE_ID).iterateAll()).hasSize(6);
  }

  @Test
  public void instanceListDatabaseOperations()
      throws SpannerException, InterruptedException, ExecutionException {
    Instance instance =
        spanner
            .getInstanceAdminClient()
            .newInstanceBuilder(InstanceId.of(PROJECT_ID, INSTANCE_ID))
            .build();
    assertThat(instance.listDatabaseOperations().iterateAll()).hasSize(3);
    instance.createDatabase("other-database", Collections.emptyList()).get();
    assertThat(instance.listDatabaseOperations().iterateAll()).hasSize(4);
    client
        .newBackupBuilder(BackupId.of(PROJECT_ID, INSTANCE_ID, BCK_ID))
        .build()
        .restore(DatabaseId.of(PROJECT_ID, INSTANCE_ID, "restored-db"))
        .get();
    assertThat(instance.listDatabaseOperations().iterateAll()).hasSize(6);
  }

  @Test
  public void instanceListDatabaseOperationsWithMetadata() throws Exception {
    Instance instance =
        spanner
            .getInstanceAdminClient()
            .newInstanceBuilder(InstanceId.of(PROJECT_ID, INSTANCE_ID))
            .build();
    String filter =
        "(metadata.@type:type.googleapis.com/"
            + "google.spanner.admin.database.v1.OptimizeRestoredDatabaseMetadata)";
    mockDatabaseAdmin.addFilterMatches(
        filter, restoreDatabaseOperation.getMetadata().get().getOptimizeDatabaseOperationName());
    Iterable<Operation> operations =
        instance.listDatabaseOperations(Options.filter(filter)).iterateAll();
    assertThat(operations).hasSize(1);
    for (Operation op : operations) {
      OptimizeRestoredDatabaseMetadata metadata =
          op.getMetadata().unpack(OptimizeRestoredDatabaseMetadata.class);
      String progress =
          String.format(
              "Restored database %s is optimized %d%%",
              metadata.getName(), metadata.getProgress().getProgressPercent());
      assertThat(progress.contains("100%"));
    }
  }

  @Test
  public void databaseListDatabaseOperations()
      throws SpannerException, InterruptedException, ExecutionException {
    Database database = client.getDatabase(INSTANCE_ID, DB_ID);
    mockDatabaseAdmin.addFilterMatches(
        "name:databases/" + DB_ID, createDatabaseOperation.getName());
    assertThat(database.listDatabaseOperations().iterateAll()).hasSize(1);
    // Create another database which should also create another operation, but for a different
    // database.
    client.createDatabase(INSTANCE_ID, "other-database", Collections.emptyList()).get();
    assertThat(database.listDatabaseOperations().iterateAll()).hasSize(1);
    // Update the database DDL. This should create an operation for this database.
    OperationFuture<Void, UpdateDatabaseDdlMetadata> op =
        database.updateDdl(Collections.singletonList("DROP TABLE FOO"), null);
    mockDatabaseAdmin.addFilterMatches("name:databases/" + DB_ID, op.getName());
    assertThat(database.listDatabaseOperations().iterateAll()).hasSize(2);
  }

  @Test
  public void dbClientListBackupOperations()
      throws SpannerException, InterruptedException, ExecutionException {
    assertThat(client.listBackupOperations(INSTANCE_ID).iterateAll()).hasSize(1);
    client.createBackup(INSTANCE_ID, "other-backup", DB_ID, afterDays(7)).get();
    assertThat(client.listBackupOperations(INSTANCE_ID).iterateAll()).hasSize(2);
    // Restore a backup. This creates 2 DATABASE operations: One to restore the database and
    // one to optimize it.
    client.restoreDatabase(INSTANCE_ID, BCK_ID, INSTANCE_ID, "restored-db").get();
    assertThat(client.listBackupOperations(INSTANCE_ID).iterateAll()).hasSize(2);
  }

  @Test
  public void instanceListBackupOperations()
      throws SpannerException, InterruptedException, ExecutionException {
    Instance instance =
        spanner
            .getInstanceAdminClient()
            .newInstanceBuilder(InstanceId.of(PROJECT_ID, INSTANCE_ID))
            .build();
    assertThat(instance.listBackupOperations().iterateAll()).hasSize(1);
    instance
        .getDatabase(DB_ID)
        .backup(
            client
                .newBackupBuilder(BackupId.of(PROJECT_ID, INSTANCE_ID, "other-backup"))
                .setExpireTime(afterDays(7))
                .build())
        .get();
    assertThat(instance.listBackupOperations().iterateAll()).hasSize(2);
    client
        .newBackupBuilder(BackupId.of(PROJECT_ID, INSTANCE_ID, BCK_ID))
        .build()
        .restore(DatabaseId.of(PROJECT_ID, INSTANCE_ID, "restored-db"))
        .get();
    assertThat(instance.listBackupOperations().iterateAll()).hasSize(2);
  }

  @Test
  public void instanceListBackupOperationsWithProgress() throws InvalidProtocolBufferException {
    Instance instance =
        spanner
            .getInstanceAdminClient()
            .newInstanceBuilder(InstanceId.of(PROJECT_ID, INSTANCE_ID))
            .build();
    String database = String.format("%s/databases/%s", TEST_PARENT, DB_ID);
    String filter =
        String.format(
            "(metadata.database:%s) AND "
                + "(metadata.@type:type.googleapis.com/"
                + "google.spanner.admin.database.v1.CreateBackupMetadata)",
            database);
    Page<Operation> operations = instance.listBackupOperations(Options.filter(filter));
    for (Operation op : operations.iterateAll()) {
      CreateBackupMetadata metadata = op.getMetadata().unpack(CreateBackupMetadata.class);
      String progress =
          String.format(
              "Backup %s on database %s pending: %d%% complete",
              metadata.getName(),
              metadata.getDatabase(),
              metadata.getProgress().getProgressPercent());
      assertThat(progress.contains("100%"));
    }
  }

  @Test
  public void backupListBackupOperations()
      throws SpannerException, InterruptedException, ExecutionException {
    Backup backup = client.newBackupBuilder(BackupId.of(PROJECT_ID, INSTANCE_ID, BCK_ID)).build();
    mockDatabaseAdmin.addFilterMatches("name:backups/" + BCK_ID, createBackupOperation.getName());
    assertThat(backup.listBackupOperations().iterateAll()).hasSize(1);
    client.createBackup(INSTANCE_ID, "other-backup", DB_ID, afterDays(7)).get();
    assertThat(backup.listBackupOperations().iterateAll()).hasSize(1);
  }

  @Test
  public void getAndSetIAMPolicy() {
    Policy policy = client.getDatabaseIAMPolicy(INSTANCE_ID, DB_ID, 1);
    assertThat(policy).isEqualTo(Policy.newBuilder().build());
    Policy newPolicy =
        Policy.newBuilder().addIdentity(Role.editor(), Identity.user("joe@example.com")).build();
    Policy returnedPolicy = client.setDatabaseIAMPolicy(INSTANCE_ID, DB_ID, newPolicy);
    assertThat(returnedPolicy).isEqualTo(newPolicy);
    assertThat(client.getDatabaseIAMPolicy(INSTANCE_ID, DB_ID, 1)).isEqualTo(newPolicy);
  }

  @Test
  public void testDatabaseIAMPermissions() {
    Iterable<String> permissions =
        client.testDatabaseIAMPermissions(
            INSTANCE_ID, DB_ID, Collections.singletonList("spanner.databases.select"));
    assertThat(permissions).containsExactly("spanner.databases.select");
  }

  private Timestamp sevenDaysAgo() {
    return Timestamp.ofTimeMicroseconds(
        TimeUnit.MICROSECONDS.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
            - TimeUnit.MICROSECONDS.convert(7, TimeUnit.DAYS));
  }

  private void createTestDatabase() {
    try {
      createDatabaseOperation = client.createDatabase(INSTANCE_ID, DB_ID, INITIAL_STATEMENTS);
      createDatabaseOperation.get();
    } catch (InterruptedException | ExecutionException e) {
      throw SpannerExceptionFactory.newSpannerException(e);
    }
  }

  private void createTestBackup() {
    try {
      createBackupOperation = client.createBackup(INSTANCE_ID, BCK_ID, DB_ID, afterDays(7));
      createBackupOperation.get();
    } catch (InterruptedException | ExecutionException e) {
      throw SpannerExceptionFactory.newSpannerException(e);
    }
  }

  private void restoreTestBackup() {
    try {
      restoreDatabaseOperation =
          client.restoreDatabase(INSTANCE_ID, BCK_ID, INSTANCE_ID, RESTORED_ID);
      restoreDatabaseOperation.get();
    } catch (InterruptedException | ExecutionException e) {
      throw SpannerExceptionFactory.newSpannerException(e);
    }
  }

  @Test
  public void retryCreateBackupSlowResponse() throws Exception {
    // Throw a DEADLINE_EXCEEDED after the operation has been created. This should cause the retry
    // to pick up the existing operation.
    mockDatabaseAdmin.setCreateBackupResponseExecutionTime(
        SimulatedExecutionTime.ofException(Status.DEADLINE_EXCEEDED.asRuntimeException()));
    final String backupId = "other-backup-id";
    OperationFuture<Backup, CreateBackupMetadata> op =
        client.createBackup(INSTANCE_ID, backupId, DB_ID, afterDays(7));
    Backup backup = op.get();
    assertThat(backup.getId().getName())
        .isEqualTo(
            String.format(
                "projects/%s/instances/%s/backups/%s", PROJECT_ID, INSTANCE_ID, backupId));
    assertThat(client.getBackup(INSTANCE_ID, backupId)).isEqualTo(backup);
    // There should be at exactly 2 requests. One from this test case and one from the setup of the
    // test which also creates a test backup.
    assertThat(mockDatabaseAdmin.countRequestsOfType(CreateBackupRequest.class)).isEqualTo(2);
  }

  @Test
  public void retryCreateBackupSlowStartup() throws Exception {
    mockDatabaseAdmin.setCreateBackupStartupExecutionTime(
        SimulatedExecutionTime.ofException(Status.DEADLINE_EXCEEDED.asRuntimeException()));
    final String backupId = "other-backup-id";
    OperationFuture<Backup, CreateBackupMetadata> op =
        client.createBackup(INSTANCE_ID, backupId, DB_ID, afterDays(7));
    Backup backup = op.get();
    assertThat(backup.getId().getName())
        .isEqualTo(
            String.format(
                "projects/%s/instances/%s/backups/%s", PROJECT_ID, INSTANCE_ID, backupId));
    assertThat(client.getBackup(INSTANCE_ID, backupId)).isEqualTo(backup);
    assertThat(mockDatabaseAdmin.countRequestsOfType(CreateBackupRequest.class)).isAtLeast(3);
  }

  @Test
  public void retryCreateDatabaseSlowResponse() throws Exception {
    // Throw a DEADLINE_EXCEEDED after the operation has been created. This should cause the retry
    // to pick up the existing operation.
    mockDatabaseAdmin.setCreateDatabaseResponseExecutionTime(
        SimulatedExecutionTime.ofException(Status.DEADLINE_EXCEEDED.asRuntimeException()));
    final String databaseId = "other-database-id";
    OperationFuture<Database, CreateDatabaseMetadata> op =
        client.createDatabase(INSTANCE_ID, databaseId, Collections.emptyList());
    Database database = op.get();
    assertThat(database.getId().getName())
        .isEqualTo(
            String.format(
                "projects/%s/instances/%s/databases/%s", PROJECT_ID, INSTANCE_ID, databaseId));
    assertThat(client.getDatabase(INSTANCE_ID, databaseId)).isEqualTo(database);
    // There should be at exactly 2 requests. One from this test case and one from the setup of the
    // test which also creates a test database.
    assertThat(mockDatabaseAdmin.countRequestsOfType(CreateDatabaseRequest.class)).isEqualTo(2);
  }

  @Test
  public void retryCreateDatabaseSlowStartup() throws Exception {
    mockDatabaseAdmin.setCreateDatabaseStartupExecutionTime(
        SimulatedExecutionTime.ofException(Status.DEADLINE_EXCEEDED.asRuntimeException()));
    final String databaseId = "other-database-id";
    OperationFuture<Database, CreateDatabaseMetadata> op =
        client.createDatabase(INSTANCE_ID, databaseId, Collections.emptyList());
    Database database = op.get();
    assertThat(database.getId().getName())
        .isEqualTo(
            String.format(
                "projects/%s/instances/%s/databases/%s", PROJECT_ID, INSTANCE_ID, databaseId));
    assertThat(client.getDatabase(INSTANCE_ID, databaseId)).isEqualTo(database);
    assertThat(mockDatabaseAdmin.countRequestsOfType(CreateDatabaseRequest.class)).isAtLeast(3);
  }

  @Test
  public void retryRestoreDatabaseSlowResponse() throws Exception {
    // Throw a DEADLINE_EXCEEDED after the operation has been created. This should cause the retry
    // to pick up the existing operation.
    mockDatabaseAdmin.setRestoreDatabaseResponseExecutionTime(
        SimulatedExecutionTime.ofException(Status.DEADLINE_EXCEEDED.asRuntimeException()));
    final String databaseId = "other-database-id";
    OperationFuture<Database, RestoreDatabaseMetadata> op =
        client.restoreDatabase(INSTANCE_ID, BCK_ID, INSTANCE_ID, databaseId);
    Database database = op.get();
    assertThat(database.getId().getName())
        .isEqualTo(
            String.format(
                "projects/%s/instances/%s/databases/%s", PROJECT_ID, INSTANCE_ID, databaseId));
    Database retrieved = client.getDatabase(INSTANCE_ID, databaseId);
    assertThat(retrieved.getCreateTime()).isEqualTo(database.getCreateTime());
    // There should be exactly 2 requests. One from this test case and one from the setup of the
    // test which also restores a test database.
    assertThat(mockDatabaseAdmin.countRequestsOfType(RestoreDatabaseRequest.class)).isEqualTo(2);
  }

  @Test
  public void retryRestoreDatabaseSlowStartup() throws Exception {
    mockDatabaseAdmin.setRestoreDatabaseStartupExecutionTime(
        SimulatedExecutionTime.ofException(Status.DEADLINE_EXCEEDED.asRuntimeException()));
    final String databaseId = "other-database-id";
    OperationFuture<Database, RestoreDatabaseMetadata> op =
        client.restoreDatabase(INSTANCE_ID, BCK_ID, INSTANCE_ID, databaseId);
    Database database = op.get();
    assertThat(database.getId().getName())
        .isEqualTo(
            String.format(
                "projects/%s/instances/%s/databases/%s", PROJECT_ID, INSTANCE_ID, databaseId));
    Database retrieved = client.getDatabase(INSTANCE_ID, databaseId);
    assertThat(retrieved.getCreateTime()).isEqualTo(database.getCreateTime());
    assertThat(mockDatabaseAdmin.countRequestsOfType(RestoreDatabaseRequest.class)).isAtLeast(3);
  }

  @Test
  public void testRetryOperationOnAdminMethodQuotaPerMinutePerProjectExceeded() {
    ErrorInfo info =
        ErrorInfo.newBuilder()
            .putMetadata("quota_limit", "AdminMethodQuotaPerMinutePerProject")
            .build();
    Metadata.Key<ErrorInfo> key =
        Metadata.Key.of(
            info.getDescriptorForType().getFullName() + Metadata.BINARY_HEADER_SUFFIX,
            ProtoLiteUtils.metadataMarshaller(info));
    Metadata trailers = new Metadata();
    trailers.put(key, info);
    mockDatabaseAdmin.addException(
        Status.RESOURCE_EXHAUSTED.withDescription("foo").asRuntimeException(trailers));
    mockDatabaseAdmin.clearRequests();

    Database database = client.getDatabase(INSTANCE_ID, DB_ID);
    assertEquals(DB_ID, database.getId().getDatabase());
    assertEquals(2, mockDatabaseAdmin.countRequestsOfType(GetDatabaseRequest.class));
  }

  @Test
  public void testRetriesDisabledForOperationOnAdminMethodQuotaPerMinutePerProjectExceeded() {
    ErrorInfo info =
        ErrorInfo.newBuilder()
            .putMetadata("quota_limit", "AdminMethodQuotaPerMinutePerProject")
            .build();
    Metadata.Key<ErrorInfo> key =
        Metadata.Key.of(
            info.getDescriptorForType().getFullName() + Metadata.BINARY_HEADER_SUFFIX,
            ProtoLiteUtils.metadataMarshaller(info));
    Metadata trailers = new Metadata();
    trailers.put(key, info);
    mockDatabaseAdmin.addException(
        Status.RESOURCE_EXHAUSTED.withDescription("foo").asRuntimeException(trailers));
    mockDatabaseAdmin.clearRequests();

    try (Spanner spannerWithoutRetries =
        spanner.getOptions().toBuilder()
            .disableAdministrativeRequestRetries()
            .build()
            .getService()) {
      AdminRequestsPerMinuteExceededException exception =
          assertThrows(
              AdminRequestsPerMinuteExceededException.class,
              () -> spannerWithoutRetries.getDatabaseAdminClient().getDatabase(INSTANCE_ID, DB_ID));
      assertEquals(ErrorCode.RESOURCE_EXHAUSTED, exception.getErrorCode());
      // There should be only one request on the server, as the request was not retried.
      assertEquals(1, mockDatabaseAdmin.countRequestsOfType(GetDatabaseRequest.class));
    }
  }
}
