/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.spanner.it.slow;

import static com.google.cloud.spanner.testing.EmulatorSpannerHelper.isUsingEmulator;
import static com.google.cloud.spanner.testing.ExperimentalHostHelper.isExperimentalHost;
import static com.google.cloud.spanner.testing.TimestampHelper.afterDays;
import static com.google.cloud.spanner.testing.TimestampHelper.afterMinutes;
import static com.google.cloud.spanner.testing.TimestampHelper.daysAgo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

import com.google.api.client.util.Lists;
import com.google.api.gax.grpc.GrpcInterceptorProvider;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.Page;
import com.google.api.gax.rpc.FailedPreconditionException;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Backup;
import com.google.cloud.spanner.BackupId;
import com.google.cloud.spanner.BackupInfo.State;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Instance;
import com.google.cloud.spanner.InstanceAdminClient;
import com.google.cloud.spanner.InstanceId;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.Restore;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SlowTest;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.encryption.EncryptionConfigs;
import com.google.cloud.spanner.testing.RemoteSpannerHelper;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Iterables;
import com.google.longrunning.Operation;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.spanner.admin.database.v1.CreateBackupMetadata;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.database.v1.RestoreDatabaseMetadata;
import com.google.spanner.admin.database.v1.RestoreSourceType;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.Status.Code;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.StreamSupport;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

/**
 * Integration tests creating, reading, updating and deleting backups. This test class combines
 * several tests into one long test to reduce the total execution time.
 */
@Category(SlowTest.class)
@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ITBackupTest {
  private static final long BACKUP_TIMEOUT_MINUTES = 30L;
  private static final long DATABASE_TIMEOUT_MINUTES = 5;
  private static final Logger logger = Logger.getLogger(ITBackupTest.class.getName());
  private static final String EXPECTED_OP_NAME_FORMAT = "%s/backups/%s/operations/";
  private static final String KMS_KEY_NAME_PROPERTY = "spanner.testenv.kms_key.name";
  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static String keyName;

  private static DatabaseAdminClient dbAdminClient;
  private static Instance instance;
  private static RemoteSpannerHelper testHelper;
  private static final List<String> databases = new ArrayList<>();
  private static final List<String> backups = new ArrayList<>();
  private static String projectId;
  private static String instanceId;

  @BeforeClass
  public static void setup() {
    assumeFalse("backups are not supported on experimental host yet", isExperimentalHost());
    assumeFalse("backups are not supported on the emulator", isUsingEmulator());
    keyName = System.getProperty(KMS_KEY_NAME_PROPERTY);
    Preconditions.checkNotNull(
        keyName,
        "Key name is null, please set a key to be used for this test. The necessary permissions"
            + " should be grant to the spanner service account according to the CMEK user guide.");

    logger.info("Setting up tests");
    testHelper = env.getTestHelper();
    dbAdminClient = testHelper.getClient().getDatabaseAdminClient();
    InstanceAdminClient instanceAdminClient = testHelper.getClient().getInstanceAdminClient();
    instance = instanceAdminClient.getInstance(testHelper.getInstanceId().getInstance());
    projectId = testHelper.getInstanceId().getProject();
    instanceId = testHelper.getInstanceId().getInstance();
    logger.info("Finished setup");

    // Cancel any backup operation that has been started by this integration test if it has been
    // running for at least 6 hours.
    logger.info("Cancelling long-running test backup operations");
    Pattern pattern = Pattern.compile(".*/backups/testbck_\\d{6}_\\d{4}_bck\\d/operations/.*");
    try {
      for (Operation operation :
          dbAdminClient.listBackupOperations(instance.getId().getInstance()).iterateAll()) {
        Matcher matcher = pattern.matcher(operation.getName());
        if (matcher.matches()) {
          if (!operation.getDone()) {
            Timestamp currentTime = Timestamp.now();
            Timestamp startTime =
                Timestamp.fromProto(
                    operation
                        .getMetadata()
                        .unpack(CreateBackupMetadata.class)
                        .getProgress()
                        .getStartTime());
            long diffSeconds = currentTime.getSeconds() - startTime.getSeconds();
            if (TimeUnit.HOURS.convert(diffSeconds, TimeUnit.SECONDS) >= 6L) {
              logger.warning(
                  String.format(
                      "Cancelling test backup operation %s that was started at %s",
                      operation.getName(), startTime));
              dbAdminClient.cancelOperation(operation.getName());
            }
          }
        }
      }
    } catch (InvalidProtocolBufferException e) {
      logger.log(Level.WARNING, "Could not list all existing backup operations.", e);
    }
    logger.info("Finished checking existing test backup operations");
  }

  @AfterClass
  public static void tearDown() throws Exception {
    logger.info("Starting test teardown");
    for (String backup : backups) {
      logger.info(String.format("Waiting for optimize operation for backup %s to finish", backup));
      waitForDbOperations(backup);
      logger.info(String.format("Deleting backup %s", backup));
      dbAdminClient.deleteBackup(testHelper.getInstanceId().getInstance(), backup);
    }
    backups.clear();
    for (String db : databases) {
      logger.info(String.format("Dropping database %s", db));
      dbAdminClient.dropDatabase(testHelper.getInstanceId().getInstance(), db);
    }
  }

  private static void waitForDbOperations(String backupId) throws InterruptedException {
    try {
      Backup backupMetadata =
          dbAdminClient.getBackup(testHelper.getInstanceId().getInstance(), backupId);
      assertNotNull(backupMetadata.getProto());
      boolean allDbOpsDone = false;
      while (!allDbOpsDone) {
        allDbOpsDone = true;
        for (String referencingDb : backupMetadata.getProto().getReferencingDatabasesList()) {
          String filter =
              String.format(
                  "name:%s/operations/ AND "
                      + "("
                      + "(metadata.@type:type.googleapis.com/"
                      + "google.spanner.admin.database.v1.OptimizeRestoredDatabaseMetadata) OR "
                      + "(metadata.@type:type.googleapis.com/"
                      + "google.spanner.admin.database.v1.RestoreDatabaseMetadata)"
                      + ")",
                  referencingDb);
          for (Operation op :
              dbAdminClient
                  .listDatabaseOperations(
                      testHelper.getInstanceId().getInstance(), Options.filter(filter))
                  .iterateAll()) {
            if (!op.getDone()) {
              Thread.sleep(5000L);
              allDbOpsDone = false;
              break;
            }
          }
        }
      }
    } catch (SpannerException e) {
      if (e.getErrorCode() == ErrorCode.NOT_FOUND) {
        return;
      }
      throw e;
    }
  }

  @Test
  public void test01_Backups() throws InterruptedException, ExecutionException, TimeoutException {
    final String databaseId = testHelper.getUniqueDatabaseId() + "_db1";
    final Database sourceDatabase =
        dbAdminClient
            .newDatabaseBuilder(DatabaseId.of(projectId, instanceId, databaseId))
            .setEncryptionConfig(EncryptionConfigs.customerManagedEncryption(keyName))
            .build();
    logger.info(String.format("Creating test database %s", databaseId));
    OperationFuture<Database, CreateDatabaseMetadata> createDatabaseOperation =
        dbAdminClient.createDatabase(
            sourceDatabase,
            Collections.singletonList(
                "CREATE TABLE FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"));
    // Make sure the database has been created before we try to create a backup.
    Database database = createDatabaseOperation.get(DATABASE_TIMEOUT_MINUTES, TimeUnit.MINUTES);
    databases.add(database.getId().getDatabase());
    // Insert some data to make sure the backup will have a size>0.
    DatabaseClient client = testHelper.getDatabaseClient(database);
    client.writeAtLeastOnce(
        Collections.singletonList(
            Mutation.newInsertOrUpdateBuilder("FOO")
                .set("ID")
                .to(1L)
                .set("NAME")
                .to("TEST")
                .build()));

    // Verifies that the database encryption has been properly set
    testDatabaseEncryption(database, keyName);
    // Verifies that the database dialect has been properly set
    testDatabaseDialect(database, Dialect.GOOGLE_STANDARD_SQL);

    // Create a backup of the database.
    String backupId = testHelper.getUniqueBackupId() + "_bck1";
    Timestamp expireTime = afterDays(7);
    Timestamp versionTime = getCurrentTimestamp(client);
    logger.info(String.format("Creating backup %s", backupId));
    // This backup has the version time specified as the server's current timestamp
    // This backup is encrypted with a customer managed key
    // The expiry time is 7 days in the future.
    final Backup backupToCreate =
        dbAdminClient
            .newBackupBuilder(BackupId.of(projectId, instanceId, backupId))
            .setDatabase(database.getId())
            .setExpireTime(expireTime)
            .setVersionTime(versionTime)
            .setEncryptionConfig(EncryptionConfigs.customerManagedEncryption(keyName))
            .build();
    OperationFuture<Backup, CreateBackupMetadata> operation =
        dbAdminClient.createBackup(backupToCreate);
    backups.add(backupId);

    // Execute metadata tests as part of this integration test to reduce total execution time.
    testMetadata(operation, backupId, database);

    // Ensure that the backup has been created before we proceed.
    logger.info("Waiting for backup operation to finish");
    Backup backup = operation.get(BACKUP_TIMEOUT_MINUTES, TimeUnit.MINUTES);

    // Verifies that backup version time is the specified one
    testBackupVersionTime(backup, versionTime);
    // Verifies that backup encryption has been properly set
    testBackupEncryption(backup, keyName);

    // Insert some more data into the database to get a timestamp from the server.
    Timestamp commitTs =
        client.writeAtLeastOnce(
            Collections.singletonList(
                Mutation.newInsertOrUpdateBuilder("FOO")
                    .set("ID")
                    .to(2L)
                    .set("NAME")
                    .to("TEST2")
                    .build()));

    // Test listing operations.
    // List all backups.
    logger.info("Listing all backups");
    assertTrue(Iterables.contains(instance.listBackups().iterateAll(), backup));
    // List all backups whose names contain 'bck1'.
    logger.info("Listing backups with name bck1");
    assertTrue(
        Iterables.elementsEqual(
            dbAdminClient
                .listBackups(
                    instanceId, Options.filter(String.format("name:%s", backup.getId().getName())))
                .iterateAll(),
            Collections.singleton(backup)));
    logger.info("Listing ready backups");
    Iterable<Backup> readyBackups =
        dbAdminClient.listBackups(instanceId, Options.filter("state:READY")).iterateAll();
    assertTrue(Iterables.contains(readyBackups, backup));
    // List all backups for databases whose names contain 'db1'.
    logger.info("Listing backups for database db1");
    assertTrue(
        Iterables.elementsEqual(
            dbAdminClient
                .listBackups(
                    instanceId,
                    Options.filter(String.format("database:%s", database.getId().getName())))
                .iterateAll(),
            Collections.singleton(backup)));
    // List all backups that were created before a certain time.
    Timestamp ts = Timestamp.ofTimeSecondsAndNanos(commitTs.getSeconds(), 0);
    logger.info(String.format("Listing backups created before %s", ts));
    assertTrue(
        Iterables.contains(
            dbAdminClient
                .listBackups(instanceId, Options.filter(String.format("create_time<\"%s\"", ts)))
                .iterateAll(),
            backup));
    // List all backups with a size > 0.
    logger.info("Listing backups with size>0");
    assertTrue(
        Iterables.contains(
            dbAdminClient.listBackups(instanceId, Options.filter("size_bytes>0")).iterateAll(),
            backup));

    // Test pagination.
    testPagination();
    logger.info("Finished listBackup tests");

    // Execute other tests as part of this integration test to reduce total execution time.
    testGetBackup(database, backupId, expireTime);
    testUpdateBackup(backup);
    testCreateInvalidExpirationDate(database);
    testRestore(backup, versionTime, keyName);

    testCancelBackupOperation(database);
    // Finished all tests.
    logger.info("Finished all backup tests");
  }

  @Test
  public void test02_RetryNonIdempotentRpcsReturningLongRunningOperations() throws Exception {
    assumeFalse(
        "Querying long-running operations is not supported on the emulator", isUsingEmulator());

    // RPCs that return a long-running operation such as CreateDatabase, CreateBackup and
    // RestoreDatabase are non-idempotent and can normally not be automatically retried in case of a
    // transient failure. The client library will however automatically query the backend to check
    // whether the corresponding operation was started or not, and if it was, it will pick up the
    // existing operation. If no operation is found, a new RPC call will be executed to start the
    // operation.

    List<Database> databases = new ArrayList<>();
    String initialDatabaseId;
    Timestamp initialDbCreateTime;

    // CreateDatabase
    InjectErrorInterceptorProvider createDbInterceptor =
        new InjectErrorInterceptorProvider("CreateDatabase");
    SpannerOptions options =
        testHelper.getOptions().toBuilder().setInterceptorProvider(createDbInterceptor).build();
    try (Spanner spanner = options.getService()) {
      initialDatabaseId = testHelper.getUniqueDatabaseId();
      DatabaseAdminClient client = spanner.getDatabaseAdminClient();
      OperationFuture<Database, CreateDatabaseMetadata> op =
          client.createDatabase(
              testHelper.getInstanceId().getInstance(), initialDatabaseId, Collections.emptyList());
      databases.add(op.get(DATABASE_TIMEOUT_MINUTES, TimeUnit.MINUTES));
      // Keep track of the original create time of this database, as we will drop this database
      // later and create another one with the exact same name. That means that the ListOperations
      // call will return at least two CreateDatabase operations. The retry logic should always
      // pick the last one.
      initialDbCreateTime = op.get(DATABASE_TIMEOUT_MINUTES, TimeUnit.MINUTES).getCreateTime();
      // Assert that the CreateDatabase RPC was called only once, and that the operation tracking
      // was resumed through a GetOperation call.
      assertEquals(1, createDbInterceptor.methodCount.get());
      assertTrue(createDbInterceptor.getOperationCount.get() >= 1);
    }

    // CreateBackup
    InjectErrorInterceptorProvider createBackupInterceptor =
        new InjectErrorInterceptorProvider("CreateBackup");
    options =
        testHelper.getOptions().toBuilder().setInterceptorProvider(createBackupInterceptor).build();
    String backupId = String.format("test-bck-%08d", new Random().nextInt(100000000));
    try (Spanner spanner = options.getService()) {
      String databaseId = databases.get(0).getId().getDatabase();
      DatabaseAdminClient client = spanner.getDatabaseAdminClient();
      OperationFuture<Backup, CreateBackupMetadata> op =
          client.createBackup(
              testHelper.getInstanceId().getInstance(),
              backupId,
              databaseId,
              Timestamp.ofTimeSecondsAndNanos(
                  Timestamp.now().getSeconds() + TimeUnit.SECONDS.convert(7L, TimeUnit.DAYS), 0));
      Stopwatch watch = Stopwatch.createStarted();
      while (createBackupInterceptor.methodCount.get() < 1
          && createBackupInterceptor.getOperationCount.get() < 1
          && watch.elapsed(TimeUnit.SECONDS) < 120) {
        //noinspection BusyWait
        Thread.sleep(5000L);
      }
      client.cancelOperation(op.getName());
      // Assert that the CreateBackup RPC was called only once, and that the operation tracking
      // was resumed through a GetOperation call.
      assertEquals(1, createBackupInterceptor.methodCount.get());
      assertTrue(createBackupInterceptor.getOperationCount.get() >= 1);
    }

    // RestoreBackup
    if (!backups.isEmpty()) {
      InjectErrorInterceptorProvider restoreBackupInterceptor =
          new InjectErrorInterceptorProvider("RestoreDatabase");
      options =
          testHelper.getOptions().toBuilder()
              .setInterceptorProvider(restoreBackupInterceptor)
              .build();
      try (Spanner spanner = options.getService()) {
        String restoredDbId = testHelper.getUniqueDatabaseId();
        DatabaseAdminClient client = spanner.getDatabaseAdminClient();
        OperationFuture<Database, RestoreDatabaseMetadata> op =
            client.restoreDatabase(
                testHelper.getInstanceId().getInstance(),
                backups.get(0),
                testHelper.getInstanceId().getInstance(),
                restoredDbId);
        Stopwatch watch = Stopwatch.createStarted();
        while (restoreBackupInterceptor.methodCount.get() < 1
            && restoreBackupInterceptor.getOperationCount.get() < 1
            && watch.elapsed(TimeUnit.SECONDS) < 120) {
          //noinspection BusyWait
          Thread.sleep(5000L);
        }
        try {
          client.cancelOperation(op.getName());
        } catch (SpannerException | ExecutionException e) {
          // Ignore, this can happen, as the restore operation sometimes fails to start if there
          // is already a restore operation running on the instance.
        }
        // Assert that the RestoreDatabase RPC was called only once, and that the operation
        // tracking was resumed through a GetOperation call.
        assertEquals(1, restoreBackupInterceptor.methodCount.get());
        assertTrue(restoreBackupInterceptor.getOperationCount.get() >= 1);
      }
    }

    // Create another database with the exact same name as the first database.
    createDbInterceptor = new InjectErrorInterceptorProvider("CreateDatabase");
    options =
        testHelper.getOptions().toBuilder().setInterceptorProvider(createDbInterceptor).build();
    try (Spanner spanner = options.getService()) {
      DatabaseAdminClient client = spanner.getDatabaseAdminClient();
      // First drop the initial database.
      client.dropDatabase(testHelper.getInstanceId().getInstance(), initialDatabaseId);
      // Now re-create a database with the exact same name.
      OperationFuture<Database, CreateDatabaseMetadata> op =
          client.createDatabase(
              testHelper.getInstanceId().getInstance(), initialDatabaseId, Collections.emptyList());
      // Check that the second database was created and has a greater creation time than the
      // first.
      Timestamp secondCreationTime =
          op.get(DATABASE_TIMEOUT_MINUTES, TimeUnit.MINUTES).getCreateTime();
      // TODO: Change this to greaterThan when the create time of a database is reported back by
      // the server.
      assertTrue(secondCreationTime.compareTo(initialDbCreateTime) >= 0);
      // Assert that the CreateDatabase RPC was called only once, and that the operation tracking
      // was resumed through a GetOperation call.
      assertEquals(1, createDbInterceptor.methodCount.get());
      assertTrue(createDbInterceptor.getOperationCount.get() >= 1);
    }
  }

  @Test
  public void test03_Delete() throws InterruptedException {
    Assert.assertFalse("No backups created", backups.isEmpty());
    String backupId = backups.get(0);
    waitForDbOperations(backupId);
    // Get the backup.
    logger.info(String.format("Fetching backup %s", backupId));
    Backup backup = instance.getBackup(backupId);
    // Delete it.
    logger.info(String.format("Deleting backup %s", backupId));
    backup.delete();
    // Try to get it again. This should cause a NOT_FOUND error.
    logger.info(String.format("Fetching non-existent backup %s", backupId));
    SpannerException exception =
        assertThrows(SpannerException.class, () -> instance.getBackup(backupId));
    assertEquals(ErrorCode.NOT_FOUND, exception.getErrorCode());
    // Try to delete the non-existent backup. This should be a no-op.
    logger.info(String.format("Deleting non-existent backup %s", backupId));
    backup.delete();
    logger.info("Finished delete tests");
  }

  @Test(expected = SpannerException.class)
  public void test04_backupCreationWithVersionTimeTooFarInThePastFails() throws Exception {
    final Database testDatabase = testHelper.createTestDatabase();
    final DatabaseId databaseId = testDatabase.getId();
    final InstanceId instanceId = databaseId.getInstanceId();
    final String backupId = testHelper.getUniqueBackupId();
    final Timestamp expireTime = afterDays(7);
    final Timestamp versionTime = daysAgo(30);
    final Backup backupToCreate =
        dbAdminClient
            .newBackupBuilder(BackupId.of(instanceId, backupId))
            .setDatabase(databaseId)
            .setExpireTime(expireTime)
            .setVersionTime(versionTime)
            .build();

    getOrThrow(dbAdminClient.createBackup(backupToCreate));
  }

  @Test(expected = SpannerException.class)
  public void test05_backupCreationWithVersionTimeInTheFutureFails() throws Exception {
    final Database testDatabase = testHelper.createTestDatabase();
    final DatabaseId databaseId = testDatabase.getId();
    final InstanceId instanceId = databaseId.getInstanceId();
    final String backupId = testHelper.getUniqueBackupId();
    final Timestamp expireTime = afterDays(7);
    final Timestamp versionTime = afterDays(1);
    final Backup backupToCreate =
        dbAdminClient
            .newBackupBuilder(BackupId.of(instanceId, backupId))
            .setDatabase(databaseId)
            .setExpireTime(expireTime)
            .setVersionTime(versionTime)
            .build();

    getOrThrow(dbAdminClient.createBackup(backupToCreate));
  }

  private <T> void getOrThrow(OperationFuture<T, ?> operation)
      throws InterruptedException, ExecutionException {
    try {
      operation.get();
    } catch (ExecutionException e) {
      if (e.getCause() instanceof SpannerException) {
        throw (SpannerException) e.getCause();
      } else {
        throw e;
      }
    }
  }

  private Timestamp getCurrentTimestamp(DatabaseClient client) {
    try (ResultSet resultSet =
        client.singleUse().executeQuery(Statement.of("SELECT CURRENT_TIMESTAMP()"))) {
      resultSet.next();
      return resultSet.getTimestamp(0);
    }
  }

  private void testBackupVersionTime(Backup backup, Timestamp versionTime) {
    logger.info("Verifying backup version time for " + backup.getId());
    assertEquals(versionTime, backup.getVersionTime());
    logger.info("Done verifying backup version time for " + backup.getId());
  }

  private void testDatabaseEncryption(Database database, String expectedKey) {
    logger.info("Verifying database encryption for " + database.getId());
    assertNotNull(database.getEncryptionConfig());
    assertEquals(expectedKey, database.getEncryptionConfig().getKmsKeyName());
    logger.info("Done verifying database encryption for " + database.getId());
  }

  private void testDatabaseDialect(Database database, Dialect expectedDialect) {
    logger.info("Verifying dialect for " + database.getId());
    assertNotNull(database.getDialect());
    assertEquals(expectedDialect, database.getDialect());
    logger.info("Done verifying database dialect for " + database.getId());
  }

  private void testBackupEncryption(Backup backup, String expectedKey) {
    logger.info("Verifying backup encryption for " + backup.getId());
    assertNotNull(backup.getEncryptionInfo());
    assertTrue(backup.getEncryptionInfo().getKmsKeyVersion().contains(expectedKey));
    logger.info("Done verifying backup encryption for " + backup.getId());
  }

  private void testMetadata(
      OperationFuture<Backup, CreateBackupMetadata> operation, String backupId, Database database)
      throws InterruptedException, ExecutionException {

    logger.info("Getting operation metadata");
    CreateBackupMetadata metadata1 = operation.getMetadata().get();
    String expectedOperationName1 =
        String.format(EXPECTED_OP_NAME_FORMAT, testHelper.getInstanceId().getName(), backupId);
    assertTrue(operation.getName().startsWith(expectedOperationName1));
    assertEquals(database.getId().getName(), metadata1.getDatabase());
    assertEquals(BackupId.of(testHelper.getInstanceId(), backupId).getName(), metadata1.getName());
    logger.info("Finished metadata tests");
  }

  private void testCreateInvalidExpirationDate(Database database) {
    // This is not allowed, the expiration date must be at least 6 hours in the future.
    Timestamp expireTime = daysAgo(1);
    String backupId = testHelper.getUniqueBackupId();
    logger.info(String.format("Creating backup %s with invalid expiration date", backupId));
    OperationFuture<Backup, CreateBackupMetadata> op =
        dbAdminClient.createBackup(
            instanceId, backupId, database.getId().getDatabase(), expireTime);
    backups.add(backupId);
    ExecutionException executionException = assertThrows(ExecutionException.class, op::get);
    Throwable cause = executionException.getCause();
    assertEquals(SpannerException.class, cause.getClass());
    SpannerException spannerException = (SpannerException) cause;
    assertEquals(ErrorCode.INVALID_ARGUMENT, spannerException.getErrorCode());
  }

  private void testCancelBackupOperation(Database database)
      throws InterruptedException, ExecutionException {
    Timestamp expireTime = afterDays(7);
    String backupId = testHelper.getUniqueBackupId();
    logger.info(String.format("Starting to create backup %s", backupId));
    OperationFuture<Backup, CreateBackupMetadata> op =
        dbAdminClient.createBackup(
            instanceId, backupId, database.getId().getDatabase(), expireTime);
    backups.add(backupId);
    // Cancel the backup operation.
    logger.info(String.format("Cancelling the creation of backup %s", backupId));
    dbAdminClient.cancelOperation(op.getName());
    logger.info("Fetching backup operations");
    boolean operationFound = false;
    for (Operation operation :
        dbAdminClient
            .listBackupOperations(
                instanceId, Options.filter(String.format("name:%s", op.getName())))
            .iterateAll()) {
      assertEquals(Code.CANCELLED.value(), operation.getError().getCode());
      operationFound = true;
    }
    assertTrue(operationFound);
    logger.info("Finished cancel test");
  }

  private void testGetBackup(Database database, String backupId, Timestamp expireTime) {
    // Get the most recent version of the backup.
    logger.info(String.format("Getting backup %s", backupId));
    Backup backup = instance.getBackup(backupId);
    assertEquals(State.READY, backup.getState());
    assertTrue(backup.getSize() > 0L);
    assertEquals(expireTime, backup.getExpireTime());
    assertEquals(database.getId(), backup.getDatabase());
  }

  private void testUpdateBackup(Backup backup) {
    // Update the expire time.
    Timestamp tomorrow = afterDays(1);
    backup = backup.toBuilder().setExpireTime(tomorrow).build();
    logger.info(
        String.format("Updating expire time of backup %s to 1 week", backup.getId().getBackup()));
    backup.updateExpireTime();
    // Re-get the backup and ensure the expire time was updated.
    logger.info(String.format("Reloading backup %s", backup.getId().getBackup()));
    backup = backup.reload();
    assertEquals(tomorrow, backup.getExpireTime());

    // Try to set the expire time to 5 minutes in the future.
    Timestamp in5Minutes = afterMinutes(5);
    final Backup backupWithNewExpireTime = backup.toBuilder().setExpireTime(in5Minutes).build();
    logger.info(
        String.format(
            "Updating expire time of backup %s to 5 minutes", backup.getId().getBackup()));
    SpannerException spannerException =
        assertThrows(SpannerException.class, backupWithNewExpireTime::updateExpireTime);
    assertEquals(ErrorCode.INVALID_ARGUMENT, spannerException.getErrorCode());

    // Re-get the backup and ensure the expire time is still in one week.
    backup = backup.reload();
    assertEquals(tomorrow, backup.getExpireTime());
  }

  private void testPagination() {
    logger.info("Listing backups using pagination");

    // First get all current backups without using pagination so we can compare that list with
    // the same list when pagination fails.
    List<Backup> initialBackups =
        Lists.newArrayList(dbAdminClient.listBackups(instanceId).iterateAll());

    int numBackups = 0;
    logger.info("Fetching first page");
    Page<Backup> page = dbAdminClient.listBackups(instanceId, Options.pageSize(1));
    assertEquals(1, Iterables.size(page.getValues()));
    numBackups++;
    assertFalse(page.hasNextPage());
    Set<String> seenPageTokens = new HashSet<>();
    seenPageTokens.add("");
    while (page.hasNextPage()) {
      logger.info(
          String.format(
              "Fetching page %d with page token %s", numBackups + 1, page.getNextPageToken()));
      // The backend should not return the same page token twice.
      if (seenPageTokens.contains(page.getNextPageToken())) {
        // This should not happen, so to try to figure out why we list all the backups here to see
        // if there's anything that we can figure out from the list of backups now compared with
        // the initial list (for example that a new backup has been added while we were iterating).
        logger.info("Pagination of backups failed. Initial list of backups was:");
        for (Backup backup : initialBackups) {
          logger.info(backup.getId().toString());
        }
        logger.info("Current list of backups is:");
        List<Backup> currentBackups =
            Lists.newArrayList(dbAdminClient.listBackups(instanceId).iterateAll());
        for (Backup backup : currentBackups) {
          logger.info(backup.getId().toString());
        }
      }
      assertFalse(Iterables.contains(seenPageTokens, page.getNextPageToken()));
      seenPageTokens.add(page.getNextPageToken());
      page =
          dbAdminClient.listBackups(
              instanceId, Options.pageToken(page.getNextPageToken()), Options.pageSize(1));
      assertEquals(1, Iterables.size(page.getValues()));
      numBackups++;
    }
    assertTrue(numBackups >= 1);
  }

  private void testRestore(Backup backup, Timestamp versionTime, String expectedKey)
      throws InterruptedException, ExecutionException {
    // Restore the backup to a new database.
    String restoredDb = testHelper.getUniqueDatabaseId();
    String restoreOperationName;
    OperationFuture<Database, RestoreDatabaseMetadata> restoreOperation;
    int attempts = 0;
    while (true) {
      try {
        logger.info(
            String.format(
                "Restoring backup %s to database %s", backup.getId().getBackup(), restoredDb));
        final Restore restore =
            dbAdminClient
                .newRestoreBuilder(backup.getId(), DatabaseId.of(projectId, instanceId, restoredDb))
                .setEncryptionConfig(EncryptionConfigs.customerManagedEncryption(expectedKey))
                .build();
        restoreOperation = dbAdminClient.restoreDatabase(restore);
        restoreOperationName = restoreOperation.getName();
        break;
      } catch (ExecutionException e) {
        if (e.getCause() instanceof FailedPreconditionException
            && e.getCause()
                .getMessage()
                .contains("Please retry the operation once the pending restores complete")) {
          attempts++;
          if (attempts == 10) {
            logger.info(
                "Restore operation failed 10 times because of other pending restores. Skipping"
                    + " restore test.");
            return;
          }
          // wait and then retry.
          logger.info(
              String.format(
                  "Restoring backup %s to database %s must wait because of other pending restore"
                      + " operation",
                  backup.getId().getBackup(), restoredDb));
          //noinspection BusyWait
          Thread.sleep(60_000L);
        } else {
          throw e;
        }
      }
    }
    databases.add(restoredDb);
    logger.info(String.format("Restore operation %s running", restoreOperationName));
    RestoreDatabaseMetadata metadata = restoreOperation.getMetadata().get();
    assertEquals(backup.getId().getName(), metadata.getBackupInfo().getBackup());
    assertEquals(RestoreSourceType.BACKUP, metadata.getSourceType());
    assertEquals(
        DatabaseId.of(testHelper.getInstanceId(), restoredDb).getName(), metadata.getName());
    assertEquals(versionTime, Timestamp.fromProto(metadata.getBackupInfo().getVersionTime()));

    // Ensure the operations show up in the right collections.
    // TODO: Re-enable when it is clear why this fails on the CI environment.
    //    verifyRestoreOperations(backupOp.getName(), restoreOperationName);

    // Wait until the restore operation has finished successfully.
    Database database = restoreOperation.get();
    assertEquals(restoredDb, database.getId().getDatabase());

    // Reloads the database
    final Database reloadedDatabase = database.reload();
    assertNotNull(reloadedDatabase.getProto());
    assertEquals(
        versionTime,
        Timestamp.fromProto(
            reloadedDatabase.getProto().getRestoreInfo().getBackupInfo().getVersionTime()));
    testDatabaseEncryption(reloadedDatabase, expectedKey);
    testDatabaseDialect(reloadedDatabase, Dialect.GOOGLE_STANDARD_SQL);

    // Restoring the backup to an existing database should fail.
    logger.info(
        String.format(
            "Restoring backup %s to existing database %s", backup.getId().getBackup(), restoredDb));
    ExecutionException executionException =
        assertThrows(
            ExecutionException.class,
            () -> backup.restore(DatabaseId.of(testHelper.getInstanceId(), restoredDb)).get());
    assertEquals(SpannerException.class, executionException.getCause().getClass());
    SpannerException spannerException = (SpannerException) executionException.getCause();
    assertEquals(ErrorCode.ALREADY_EXISTS, spannerException.getErrorCode());
  }

  // TODO: Remove when this verification can be re-enabled.
  @SuppressWarnings("unused")
  private void verifyRestoreOperations(
      final String backupOperationName, final String restoreOperationName) {
    assertTrue(
        StreamSupport.stream(instance.listBackupOperations().iterateAll().spliterator(), false)
            .anyMatch(input -> input.getName().equals(backupOperationName)));
    assertFalse(
        StreamSupport.stream(instance.listBackupOperations().iterateAll().spliterator(), false)
            .anyMatch(input -> input.getName().equals(restoreOperationName)));
    assertFalse(
        StreamSupport.stream(instance.listDatabaseOperations().iterateAll().spliterator(), false)
            .anyMatch(input -> input.getName().equals(backupOperationName)));
    assertTrue(
        StreamSupport.stream(instance.listDatabaseOperations().iterateAll().spliterator(), false)
            .anyMatch(input -> input.getName().equals(restoreOperationName)));
  }

  private static final class InjectErrorInterceptorProvider implements GrpcInterceptorProvider {
    final AtomicBoolean injectError = new AtomicBoolean(true);
    final AtomicInteger getOperationCount = new AtomicInteger();
    final AtomicInteger methodCount = new AtomicInteger();
    final String methodName;

    private InjectErrorInterceptorProvider(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public List<ClientInterceptor> getInterceptors() {
      ClientInterceptor interceptor =
          new ClientInterceptor() {
            @Override
            public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
                MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
              if (method.getFullMethodName().contains("GetOperation")) {
                getOperationCount.incrementAndGet();
              }
              if (!method.getFullMethodName().contains(methodName)) {
                return next.newCall(method, callOptions);
              }

              methodCount.incrementAndGet();
              final AtomicBoolean errorInjected = new AtomicBoolean();
              final ClientCall<ReqT, RespT> clientCall = next.newCall(method, callOptions);

              return new SimpleForwardingClientCall<ReqT, RespT>(clientCall) {
                @Override
                public void start(Listener<RespT> responseListener, Metadata headers) {
                  super.start(
                      new SimpleForwardingClientCallListener<RespT>(responseListener) {
                        @Override
                        public void onMessage(RespT message) {
                          if (injectError.getAndSet(false)) {
                            errorInjected.set(true);
                            clientCall.cancel("Cancelling call for injected error", null);
                          } else {
                            super.onMessage(message);
                          }
                        }

                        @Override
                        public void onClose(Status status, Metadata metadata) {
                          if (errorInjected.get()) {
                            status = Status.UNAVAILABLE.augmentDescription("INJECTED BY TEST");
                          }
                          super.onClose(status, metadata);
                        }
                      },
                      headers);
                }
              };
            }
          };
      return Collections.singletonList(interceptor);
    }
  }
}
