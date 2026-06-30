/*
 * Copyright 2017 Google Inc.
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

package com.example.spanner;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.rpc.FailedPreconditionException;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Instance;
import com.google.cloud.spanner.InstanceAdminClient;
import com.google.cloud.spanner.InstanceConfigId;
import com.google.cloud.spanner.InstanceId;
import com.google.cloud.spanner.InstanceInfo;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.spanner.admin.database.v1.Backup;
import com.google.spanner.admin.database.v1.BackupName;
import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.database.v1.DatabaseName;
import com.google.spanner.admin.database.v1.InstanceName;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@code SpannerSample} */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class SpannerSampleIT extends SampleTestBaseV2 {

  private static final int DBID_LENGTH = 20;
  // The instance needs to exist for tests to pass.
  private static final String instanceId = System.getProperty("spanner.test.instance");
  private static final String baseDbId = System.getProperty("spanner.sample.database");
  private static final String keyLocation =
      Preconditions.checkNotNull(System.getProperty("spanner.test.key.location"));
  private static final String keyRing =
      Preconditions.checkNotNull(System.getProperty("spanner.test.key.ring"));
  private static final String keyName =
      Preconditions.checkNotNull(System.getProperty("spanner.test.key.name"));
  private static final String encryptedBackupId = formatForTest(baseDbId);
  private static final long STALE_INSTANCE_THRESHOLD_SECS =
      TimeUnit.SECONDS.convert(24L, TimeUnit.HOURS);
  static Spanner spanner;
  static DatabaseAdminClient databaseAdminClient;
  private static String key;
  private long lastUpdateDataTimeInMillis;

  private String runSample(String command, String databaseId) throws Exception {
    PrintStream stdOut = System.out;
    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bout);
    System.setOut(out);
    SpannerSample.main(new String[] {command, instanceId, databaseId, null});
    System.setOut(stdOut);
    return bout.toString();
  }

  private String runSample(String command, String databaseId, String backupId) throws Exception {
    PrintStream stdOut = System.out;
    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bout);
    System.setOut(out);
    SpannerSample.main(new String[] {command, instanceId, databaseId, backupId});
    System.setOut(stdOut);
    return bout.toString();
  }

  @BeforeClass
  public static void setUp() throws Exception {
    SpannerOptions options =
        SpannerOptions.newBuilder().setAutoThrottleAdministrativeRequests().build();
    spanner = options.getService();
    databaseAdminClient = DatabaseAdminClient.create();
    // Delete stale test databases that have been created earlier by this test, but not deleted.
    deleteStaleTestDatabases();
    key =
        String.format(
            "projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s",
            options.getProjectId(), keyLocation, keyRing, keyName);

    /*
     * Delete stale instances that have been created earlier by this test but not deleted.
     * Backups needed to be deleted from the instance first, as the instance can only be
     * deleted once all backups have been deleted.
     * */
    deleteStaleEncryptedTestInstances();
  }

  /**
   * Deleting all the test instances with name starting with 'encrypted-test-' and were created
   * before 24 hours.
   *
   * @throws InterruptedException If Thread.sleep() interrupted
   */
  private static void deleteStaleEncryptedTestInstances() throws InterruptedException {
    Timestamp now = Timestamp.now();

    for (Instance instance :
        spanner
            .getInstanceAdminClient()
            .listInstances(Options.filter("name:encrypted-test-"))
            .iterateAll()) {
      if ((now.getSeconds() - instance.getCreateTime().getSeconds())
          > STALE_INSTANCE_THRESHOLD_SECS) {
        deleteAllBackups(instance.getId().getInstance());
        instance.delete();
      }
    }
  }

  static void deleteStaleTestDatabases() throws IOException {
    Timestamp now = Timestamp.now();
    Pattern samplePattern = getTestDbIdPattern(SpannerSampleIT.baseDbId);
    Pattern restoredPattern = getTestDbIdPattern("restored");
    try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
      for (Database db :
          databaseAdminClient.listDatabases(InstanceName.of(projectId, instanceId)).iterateAll()) {
        DatabaseName databaseName = DatabaseName.parse(db.getName());
        if (TimeUnit.HOURS.convert(
                now.getSeconds() - db.getCreateTime().getSeconds(), TimeUnit.SECONDS)
            > 24) {
          if (databaseName.getDatabase().length() >= DBID_LENGTH) {
            if (samplePattern
                .matcher(toComparableId(SpannerSampleIT.baseDbId, databaseName.getDatabase()))
                .matches()) {
              databaseAdminClient.dropDatabase(db.getName());
            }
            if (restoredPattern
                .matcher(toComparableId("restored", databaseName.getDatabase()))
                .matches()) {
              databaseAdminClient.dropDatabase(db.getName());
            }
          }
        }
      }
    }
  }

  @AfterClass
  public static void tearDown() {
    databaseAdminClient.deleteBackup(BackupName.of(projectId, instanceId, encryptedBackupId));
    spanner.close();
  }

  @Test
  public void testSample() throws Exception {
    String databaseId = idGenerator.generateDatabaseId();
    DatabaseId dbId = DatabaseId.of(projectId, instanceId, databaseId);
    assertThat(instanceId).isNotNull();
    assertThat(databaseId).isNotNull();
    String out = runSample("createdatabase", databaseId);
    assertThat(out).contains("Created database");
    assertThat(out).contains(dbId.getName());

    System.out.println("Write data to sample tables ...");
    runSample("write", databaseId);

    System.out.println("Delete data to sample tables ...");
    out = runSample("delete", databaseId);
    assertThat(out).contains("Records deleted.");

    runSample("write", databaseId);

    System.out.println("Read data from sample tables ...");
    out = runSample("read", databaseId);
    assertThat(out).contains("1 1 Total Junk");

    out = runSample("query", databaseId);
    assertThat(out).contains("1 1 Total Junk");
    runSample("addmarketingbudget", databaseId);

    // wait for 15 seconds to elapse and then run an update, and query for stale data
    lastUpdateDataTimeInMillis = System.currentTimeMillis();
    while (System.currentTimeMillis() < lastUpdateDataTimeInMillis + 16000) {
      Thread.sleep(1000);
    }
    runSample("update", databaseId);

    System.out.println("Read stale data from sample tables ...");
    out = runSample("readstaledata", databaseId);
    assertThat(out).contains("1 1 NULL");
    runSample("writetransaction", databaseId);

    System.out.println("Query marketing budget ...");
    out = runSample("querymarketingbudget", databaseId);
    assertThat(out).contains("1 1 300000");
    assertThat(out).contains("2 2 300000");

    System.out.println("Add index ...");
    runSample("addindex", databaseId);

    System.out.println("Query index ...");
    out = runSample("queryindex", databaseId);
    assertThat(out).contains("Go, Go, Go");
    assertThat(out).contains("Forever Hold Your Peace");
    assertThat(out).doesNotContain("Green");

    System.out.println("Read index ...");
    out = runSample("readindex", databaseId);
    assertThat(out).contains("Go, Go, Go");
    assertThat(out).contains("Forever Hold Your Peace");
    assertThat(out).contains("Green");

    System.out.println("Add Storing index ...");
    runSample("addstoringindex", databaseId);
    out = runSample("readstoringindex", databaseId);
    assertThat(out).contains("300000");

    System.out.println("Read storing index ...");
    out = runSample("readonlytransaction", databaseId);
    assertThat(out.replaceAll("[\r\n]+", " ")).containsMatch("(Total Junk.*){2}");

    out = runSample("addcommittimestamp", databaseId);
    assertThat(out).contains("Added LastUpdateTime as a commit timestamp column");

    runSample("updatewithtimestamp", databaseId);
    out = runSample("querywithtimestamp", databaseId);
    assertThat(out).contains("1 1 1000000");
    assertThat(out).contains("2 2 750000");

    out = runSample("createtablewithtimestamp", databaseId);
    assertThat(out).contains("Created Performances table in database");

    runSample("writewithtimestamp", databaseId);
    out = runSample("queryperformancestable", databaseId);
    assertThat(out).contains("1 4 2017-10-05 11000");
    assertThat(out).contains("1 19 2017-11-02 15000");
    assertThat(out).contains("2 42 2017-12-23 7000");

    runSample("writestructdata", databaseId);
    out = runSample("querywithstruct", databaseId);
    assertThat(out).startsWith("6\n");

    out = runSample("querywitharrayofstruct", databaseId);
    assertThat(out).startsWith("8\n7\n6");

    out = runSample("querystructfield", databaseId);
    assertThat(out).startsWith("6\n");

    out = runSample("querynestedstructfield", databaseId);
    assertThat(out).contains("6 Imagination\n");
    assertThat(out).contains("9 Imagination\n");

    runSample("insertusingdml", databaseId);
    out = runSample("querysingerstable", databaseId);
    assertThat(out).contains("Virginia Watson");

    runSample("updateusingdml", databaseId);
    out = runSample("querymarketingbudget", databaseId);
    assertThat(out).contains("1 1 2000000");

    runSample("deleteusingdml", databaseId);
    out = runSample("querysingerstable", databaseId);
    assertThat(out).doesNotContain("Alice Trentor");

    out = runSample("updateusingdmlwithtimestamp", databaseId);
    assertThat(out).contains("2 records updated");

    out = runSample("writeandreadusingdml", databaseId);
    assertThat(out).contains("Timothy Campbell");

    runSample("updateusingdmlwithstruct", databaseId);
    out = runSample("querysingerstable", databaseId);
    assertThat(out).contains("Timothy Grant");

    runSample("writeusingdml", databaseId);
    out = runSample("querysingerstable", databaseId);
    assertThat(out).contains("Melissa Garcia");
    assertThat(out).contains("Russell Morales");
    assertThat(out).contains("Jacqueline Long");
    assertThat(out).contains("Dylan Shaw");
    out = runSample("querywithparameter", databaseId);
    assertThat(out).contains("12 Melissa Garcia");

    runSample("writewithtransactionusingdml", databaseId);
    out = runSample("querymarketingbudget", databaseId);
    assertThat(out).contains("1 1 2200000");
    assertThat(out).contains("2 2 550000");

    runSample("updateusingpartitioneddml", databaseId);
    out = runSample("querymarketingbudget", databaseId);
    assertThat(out).contains("1 1 2200000");
    assertThat(out).contains("2 2 100000");

    runSample("deleteusingpartitioneddml", databaseId);
    out = runSample("querysingerstable", databaseId);
    assertThat(out).doesNotContain("Timothy Grant");
    assertThat(out).doesNotContain("Melissa Garcia");
    assertThat(out).doesNotContain("Russell Morales");
    assertThat(out).doesNotContain("Jacqueline Long");
    assertThat(out).doesNotContain("Dylan Shaw");

    out = runSample("updateusingbatchdml", databaseId);
    assertThat(out).contains("1 record updated by stmt 0");
    assertThat(out).contains("1 record updated by stmt 1");

    out = runSample("createtablewithdatatypes", databaseId);
    assertThat(out).contains("Created Venues table in database");

    runSample("writedatatypesdata", databaseId);
    out = runSample("querywitharray", databaseId);
    assertThat(out).contains("19 Venue 19 2020-11-01");
    assertThat(out).contains("42 Venue 42 2020-10-01");

    out = runSample("querywithbool", databaseId);
    assertThat(out).contains("19 Venue 19 true");

    out = runSample("querywithbytes", databaseId);
    assertThat(out).contains("4 Venue 4");

    out = runSample("querywithdate", databaseId);
    assertThat(out).contains("4 Venue 4 2018-09-02");
    assertThat(out).contains("42 Venue 42 2018-10-01");

    out = runSample("querywithfloat", databaseId);
    assertThat(out).contains("4 Venue 4 0.8");
    assertThat(out).contains("19 Venue 19 0.9");

    out = runSample("querywithint", databaseId);
    assertThat(out).contains("19 Venue 19 6300");
    assertThat(out).contains("42 Venue 42 3000");

    out = runSample("querywithstring", databaseId);
    assertThat(out).contains("42 Venue 42");

    out = runSample("querywithtimestampparameter", databaseId);
    assertThat(out).contains("4 Venue 4");
    assertThat(out).contains("19 Venue 19");
    assertThat(out).contains("42 Venue 42");

    out = runSample("querywithnumeric", databaseId);
    assertThat(out).contains("19 Venue 19 1200100");
    assertThat(out).contains("42 Venue 42 390650.99");

    out = runSample("clientwithqueryoptions", databaseId);
    assertThat(out).contains("1 1 Total Junk");
    out = runSample("querywithqueryoptions", databaseId);
    assertThat(out).contains("1 1 Total Junk");
  }

  @Test
  public void testBackupSamples_withoutEncryption() {
    String databaseId = idGenerator.generateDatabaseId();
    DatabaseId dbId = DatabaseId.of(projectId, instanceId, databaseId);
    String restoreDatabaseId = idGenerator.generateDatabaseId();
    String backupId = idGenerator.generateBackupId();

    try {
      assertThat(instanceId).isNotNull();
      assertThat(databaseId).isNotNull();

      System.out.println("Creating Database ...");
      String out = runSample("createdatabase", databaseId);
      assertThat(out).contains("Created database");
      assertThat(out).contains(dbId.getName());

      BackupName backupName = BackupName.of(projectId, instanceId, backupId);

      System.out.println("Creating Backup ...");
      out = runSample("createbackup", databaseId, backupId);
      assertThat(out).contains("Created backup [" + backupName.toString() + "]");

      // TODO: remove try-catch when filtering on metadata fields works.
      try {
        System.out.println("List Backup Operations ...");
        out = runSample("listbackupoperations", databaseId, backupId);
        assertThat(out)
            .contains(
                String.format("Backup %s on database %s pending:", backupName, dbId.getName()));
        assertTrue(
            "Out does not contain copy backup operations", out.contains("Copy Backup Operations"));
      } catch (SpannerException e) {
        assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
        assertThat(e.getMessage()).contains("Cannot evaluate filter expression");
      }

      System.out.println("List Backup ...");
      out = runSample("listbackups", databaseId, backupId);
      assertThat(out).contains("All backups:");
      assertThat(out)
          .contains(String.format("All backups with backup name containing \"%s\":", backupId));
      assertThat(out)
          .contains(
              String.format(
                  "All backups for databases with a name containing \"%s\":", dbId.getDatabase()));
      assertThat(out).contains(String.format("All backups that expire before"));
      assertThat(out).contains("All backups with size greater than 100 bytes:");
      assertThat(out)
          .containsMatch(Pattern.compile("All databases created after (.+) and that are ready:"));
      assertThat(out).contains("All backups, listed using pagination:");
      // All the above tests should include the created backup exactly once, i.e. exactly 6 times.
      assertThat(countOccurrences(out, backupName.toString())).isEqualTo(6);

      // Try the restore operation in a retry loop, as there is a limit on the number of restore
      // operations that is allowed to execute simultaneously, and we should retry if we hit this
      // limit.
      boolean restored = false;
      int restoreAttempts = 0;
      while (true) {
        try {
          System.out.println("Restore Backup ...");
          out = runSample("restorebackup", restoreDatabaseId, backupId);
          assertThat(out)
              .contains(
                  "Restored database ["
                      + DatabaseName.of(projectId, instanceId, restoreDatabaseId).toString()
                      + "] from ["
                      + backupName
                      + "]");
          restored = true;
          break;
        } catch (SpannerException e) {
          if (e.getErrorCode() == ErrorCode.FAILED_PRECONDITION
              && e.getMessage()
                  .contains("Please retry the operation once the pending restores complete")) {
            restoreAttempts++;
            if (restoreAttempts == 10) {
              System.out.println(
                  "Restore operation failed 10 times because of other pending restores. "
                      + "Giving up restore.");
              break;
            }
            Uninterruptibles.sleepUninterruptibly(60L, TimeUnit.SECONDS);
          } else {
            throw e;
          }
        }
      }

      if (restored) {
        System.out.println("List Database Operations ...");
        out = runSample("listdatabaseoperations", restoreDatabaseId);
        assertThat(out)
            .contains(
                String.format(
                    "Database %s restored from backup",
                    DatabaseId.of(dbId.getInstanceId(), restoreDatabaseId).getName()));
      }

      System.out.println("Updating backup ...");
      out = runSample("updatebackup", databaseId, backupId);
      assertThat(out).contains(String.format("Updated backup [" + backupId + "]"));

      // Drop the restored database before we try to delete the backup.
      // Otherwise the delete backup operation might fail as the backup is still in use by
      // the OptimizeRestoredDatabase operation.
      databaseAdminClient.dropDatabase(
          DatabaseName.of(projectId, dbId.getInstanceId().getInstance(), restoreDatabaseId));

      System.out.println("Deleting Backup ...");
      out = runSample("deletebackup", databaseId, backupId);
      assertThat(out).contains("Deleted backup [" + backupId + "]");

    } catch (Exception ex) {
      Assert.fail("Exception raised => " + ex.getCause());
    }
  }

  @Test
  public void testCancelBackupSamples() {
    String databaseId = idGenerator.generateDatabaseId();
    DatabaseId dbId = DatabaseId.of(projectId, instanceId, databaseId);

    try {
      assertThat(instanceId).isNotNull();
      assertThat(databaseId).isNotNull();

      String out = runSample("createdatabase", databaseId);
      assertThat(out).contains("Created database");
      assertThat(out).contains(dbId.getName());

      String backupId = idGenerator.generateBackupId();

      out = runSample("cancelcreatebackup", databaseId, backupId);
      assertThat(out).contains("Backup operation for [" + backupId + "_cancel] successfully");
    } catch (Exception ex) {
      Assert.fail("Exception raised => " + ex.getCause());
    }
  }

  @Test
  public void testEncryptedDatabaseAndBackupSamples() throws Exception {
    String projectId = spanner.getOptions().getProjectId();
    String databaseId = idGenerator.generateDatabaseId();
    String restoreId = idGenerator.generateDatabaseId();
    // Create a separate instance for this test to prevent multiple parallel backup operations on
    // the same instance that need to wait for each other.
    String instanceId = idGenerator.generateInstanceId();
    InstanceAdminClient instanceAdminClient = spanner.getInstanceAdminClient();
    instanceAdminClient
        .createInstance(
            InstanceInfo.newBuilder(InstanceId.of(projectId, instanceId))
                .setDisplayName("Encrypted test instance")
                .setInstanceConfigId(InstanceConfigId.of(projectId, "regional-" + keyLocation))
                .setNodeCount(1)
                .build())
        .get();
    System.out.println("Creating database ...");
    try {
      String out =
          SampleRunner.runSample(
              () ->
                  SpannerSample.createDatabase(
                      databaseAdminClient, InstanceName.of(projectId, instanceId), databaseId));
      assertThat(out)
          .contains(
              String.format(
                  "Created database [%s]", DatabaseName.of(projectId, instanceId, databaseId)));

      System.out.println("Creating backup with encryption key ...");
      out =
          SampleRunner.runSampleWithRetry(
              () ->
                  CreateBackupWithEncryptionKey.createBackupWithEncryptionKey(
                      databaseAdminClient,
                      projectId,
                      instanceId,
                      databaseId,
                      encryptedBackupId,
                      key),
              new ShouldRetryBackupOperation());
      assertThat(out)
          .containsMatch(
              String.format(
                  "Backup projects/%s/instances/%s/backups/%s of size \\d+ bytes "
                      + "was created at (.*) using encryption key %s",
                  projectId, instanceId, encryptedBackupId, key));

      System.out.println("Restoring backup with encryption key ...");
      out =
          SampleRunner.runSampleWithRetry(
              () ->
                  RestoreBackupWithEncryptionKey.restoreBackupWithEncryptionKey(
                      databaseAdminClient,
                      projectId,
                      instanceId,
                      encryptedBackupId,
                      restoreId,
                      key),
              new ShouldRetryBackupOperation());
      assertThat(out)
          .contains(
              String.format(
                  "Database projects/%s/instances/%s/databases/%s"
                      + " restored to projects/%s/instances/%s/databases/%s"
                      + " from backup projects/%s/instances/%s/backups/%s"
                      + " using encryption key %s",
                  projectId,
                  instanceId,
                  databaseId,
                  projectId,
                  instanceId,
                  restoreId,
                  projectId,
                  instanceId,
                  encryptedBackupId,
                  key));
    } finally {
      // Delete the backups from the test instance first, as the instance can only be deleted once
      // all backups have been deleted.
      System.out.println("Deleting backups ...");
      deleteAllBackups(instanceId);
      instanceAdminClient.deleteInstance(instanceId);
    }
  }

  @Test
  public void testDeleteBackups() {
    try {
      String projectId = spanner.getOptions().getProjectId();
      String databaseId = idGenerator.generateDatabaseId();
      String backupId = idGenerator.generateBackupId();

      String out =
          SampleRunner.runSample(
              () ->
                  SpannerSample.createDatabase(
                      databaseAdminClient, InstanceName.of(projectId, instanceId), databaseId));
      assertThat(out)
          .contains(
              String.format(
                  "Created database [%s]", DatabaseName.of(projectId, instanceId, databaseId)));

      out =
          SampleRunner.runSampleWithRetry(
              () ->
                  CreateBackupWithEncryptionKey.createBackupWithEncryptionKey(
                      databaseAdminClient, projectId, instanceId, databaseId, backupId, key),
              new ShouldRetryBackupOperation());
      assertThat(out)
          .containsMatch(
              String.format(
                  "Backup projects/%s/instances/%s/backups/%s of size \\d+ bytes "
                      + "was created at (.*) using encryption key %s",
                  projectId, instanceId, backupId, key));

      out = runSample("deletebackup", databaseId, backupId);
      assertThat(out).contains("Deleted backup [" + backupId + "]");
    } catch (Exception ex) {
      Assert.fail("Exception raised => " + ex.getCause());
    }
  }

  private static void deleteAllBackups(String instanceId) throws InterruptedException {
    InstanceName instanceName = InstanceName.of(projectId, instanceId);
    for (Backup backup : databaseAdminClient.listBackups(instanceName.toString()).iterateAll()) {
      int attempts = 0;
      System.out.printf("Deleting backup ... %s%n", backup.getName());
      while (attempts < 30) {
        try {
          attempts++;
          databaseAdminClient.deleteBackup(backup.getName());
          break;
        } catch (SpannerException | FailedPreconditionException e) {
          ErrorCode errorCode = ErrorCode.FAILED_PRECONDITION;

          if (e instanceof SpannerException) {
            errorCode = ((SpannerException) e).getErrorCode();
          }
          if (errorCode == ErrorCode.FAILED_PRECONDITION
              && e.getMessage()
                  .contains(
                      "Please try deleting the backup once the restore or post-restore optimize "
                          + "operations have completed on these databases.")) {
            // Wait 30 seconds and then retry.
            Thread.sleep(30_000L);
          } else {
            throw e;
          }
        }
      }
    }
  }

  private String runSampleRunnable(Runnable sample) {
    PrintStream stdOut = System.out;
    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bout);
    System.setOut(out);
    sample.run();
    System.setOut(stdOut);
    return bout.toString();
  }

  @Test
  public void testCreateAndUpdateInstanceSample() {
    String databaseId = idGenerator.generateDatabaseId();
    DatabaseId dbId = DatabaseId.of(projectId, instanceId, databaseId);

    String instanceId = formatForTest("sample-inst");
    String out =
        runSampleRunnable(
            () -> {
              try {
                CreateInstanceExample.createInstance(dbId.getInstanceId().getProject(), instanceId);
                UpdateInstanceExample.updateInstance(dbId.getInstanceId().getProject(), instanceId);
              } finally {
                spanner.getInstanceAdminClient().deleteInstance(instanceId);
              }
            });
    assertThat(out)
        .contains(
            String.format(
                "Instance %s was successfully created",
                InstanceId.of(dbId.getInstanceId().getProject(), instanceId)));
    assertThat(out)
        .contains(
            String.format(
                "Instance %s was successfully updated",
                InstanceId.of(dbId.getInstanceId().getProject(), instanceId)));
  }

  @Test
  public void testCreateAndUpdateInstanceDefaultBackupScheduleTypeSample() {
    String databaseId = idGenerator.generateDatabaseId();
    DatabaseId dbId = DatabaseId.of(projectId, instanceId, databaseId);

    String instanceId = formatForTest("sample-inst");
    String out =
        runSampleRunnable(
            () -> {
              try {
                CreateInstanceWithoutDefaultBackupSchedulesExample
                    .createInstanceWithoutDefaultBackupSchedules(
                        dbId.getInstanceId().getProject(), instanceId);
                UpdateInstanceDefaultBackupScheduleTypeExample
                    .updateInstanceDefaultBackupScheduleType(
                        dbId.getInstanceId().getProject(), instanceId);
              } finally {
                spanner.getInstanceAdminClient().deleteInstance(instanceId);
              }
            });
    assertThat(out)
        .contains(
            String.format(
                "Instance %s was successfully created",
                InstanceId.of(dbId.getInstanceId().getProject(), instanceId)));
    assertThat(out)
        .contains(
            String.format(
                "Instance %s was successfully updated",
                InstanceId.of(dbId.getInstanceId().getProject(), instanceId)));
  }

  private static int countOccurrences(String input, String search) {
    return input.split(search).length - 1;
  }

  private static String toComparableId(String baseId, String existingId) {
    String zeroUuid = "00000000-0000-0000-0000-0000-00000000";
    int shouldBeLength = (baseId + "-" + zeroUuid).length();
    int missingLength = shouldBeLength - existingId.length();
    return existingId + zeroUuid.substring(zeroUuid.length() - missingLength);
  }

  private static Pattern getTestDbIdPattern(String baseDbId) {
    return Pattern.compile(
        baseDbId + "-[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{8}",
        Pattern.CASE_INSENSITIVE);
  }

  static String formatForTest(String name) {
    return name + "-" + UUID.randomUUID().toString().substring(0, DBID_LENGTH);
  }

  static class ShouldRetryBackupOperation implements Predicate<SpannerException> {

    private static final int MAX_ATTEMPTS = 20;
    private int attempts = 0;

    @Override
    public boolean test(SpannerException e) {
      if (e.getErrorCode() == ErrorCode.FAILED_PRECONDITION
          && e.getMessage().contains("Please retry the operation once the pending")) {
        attempts++;
        if (attempts == MAX_ATTEMPTS) {
          // Throw custom exception so it is easier to locate in the log why it went wrong.
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.DEADLINE_EXCEEDED,
              String.format(
                  "Operation failed %d times because of other pending operations. "
                      + "Giving up operation.\n",
                  attempts),
              e);
        }
        // Wait one minute before retrying.
        Uninterruptibles.sleepUninterruptibly(60L, TimeUnit.SECONDS);
        return true;
      }
      return false;
    }
  }
}
