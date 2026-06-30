/*
 * Copyright 2022 Google Inc.
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

package com.example.spanner.admin.archived;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Unit tests for {@code PgSpannerSample}
 */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class PgSpannerSampleIT {
  private static final int DBID_LENGTH = 20;
  // The instance needs to exist for tests to pass.
  private static final String instanceId = System.getProperty("spanner.test.instance");
  private static final String baseDbId = System.getProperty("spanner.sample.database");
  private static final String databaseId = formatForTest(baseDbId);
  private static final String encryptedDatabaseId = formatForTest(baseDbId);
  private static final String encryptedBackupId = formatForTest(baseDbId);
  private static final String encryptedRestoreId = formatForTest(baseDbId);
  static Spanner spanner;
  static DatabaseId dbId;
  static DatabaseAdminClient dbClient;

  @BeforeClass
  public static void setUp() {
    SpannerOptions options =
        SpannerOptions.newBuilder().setAutoThrottleAdministrativeRequests().build();
    spanner = options.getService();
    dbClient = spanner.getDatabaseAdminClient();
    dbId = DatabaseId.of(options.getProjectId(), instanceId, databaseId);
    // Delete stale test databases that have been created earlier by this test, but not deleted.
    deleteStaleTestDatabases();
  }

  static void deleteStaleTestDatabases() {
    Timestamp now = Timestamp.now();
    Pattern samplePattern = getTestDbIdPattern(PgSpannerSampleIT.baseDbId);
    Pattern restoredPattern = getTestDbIdPattern("restored");
    for (Database db : dbClient.listDatabases(PgSpannerSampleIT.instanceId).iterateAll()) {
      if (TimeUnit.HOURS.convert(now.getSeconds() - db.getCreateTime().getSeconds(),
          TimeUnit.SECONDS) > 24) {
        if (db.getId().getDatabase().length() >= DBID_LENGTH) {
          if (samplePattern.matcher(toComparableId(PgSpannerSampleIT.baseDbId,
              db.getId().getDatabase())).matches()) {
            db.drop();
          }
          if (restoredPattern.matcher(toComparableId("restored", db.getId().getDatabase()))
              .matches()) {
            db.drop();
          }
        }
      }
    }
  }

  @AfterClass
  public static void tearDown() {
    dbClient.dropDatabase(dbId.getInstanceId().getInstance(), dbId.getDatabase());
    dbClient.dropDatabase(
        dbId.getInstanceId().getInstance(), SpannerSample.createRestoredSampleDbId(dbId));
    dbClient.dropDatabase(instanceId, encryptedDatabaseId);
    dbClient.dropDatabase(instanceId, encryptedRestoreId);
    dbClient.deleteBackup(instanceId, encryptedBackupId);
    spanner.close();
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

  private String runSample(String command) {
    final PrintStream stdOut = System.out;
    final ByteArrayOutputStream bout = new ByteArrayOutputStream();
    final PrintStream out = new PrintStream(bout);
    System.setOut(out);
    System.out.println(instanceId + ":" + databaseId);
    PgSpannerSample.main(new String[]{command, instanceId, databaseId});
    System.setOut(stdOut);
    return bout.toString();
  }

  @Test
  public void testSample() throws Exception {
    assertThat(instanceId).isNotNull();
    assertThat(databaseId).isNotNull();

    System.out.println("Create Database ...");
    String out = runSample("createdatabase");
    assertThat(out).contains("Created database");
    assertThat(out).contains(dbId.getName());

    System.out.println("Create sample tables Singers and Albums ...");
    runSample("createtableusingddl");

    System.out.println("Write data to sample tables ...");
    runSample("write");

    System.out.println("Read data from sample tables ...");
    out = runSample("read");
    assertThat(out).contains("1 1 Total Junk");

    System.out.println("Write data using DML to sample table ...");
    runSample("writeusingdml");
    System.out.println("Query Singers table ...");
    out = runSample("querysingerstable");
    assertThat(out).contains("Melissa Garcia");
    out = runSample("query");
    assertThat(out).contains("1 1 Total Junk");
    out = runSample("querywithparameter");
    assertThat(out).contains("12 Melissa Garcia");

    System.out.println("Add column marketing budget ...");
    runSample("addmarketingbudget");

    // wait for 15 seconds to elapse and then run an update, and query for stale data
    long lastUpdateDataTimeInMillis = System.currentTimeMillis();
    while (System.currentTimeMillis() < lastUpdateDataTimeInMillis + 16000) {
      Thread.sleep(1000);
    }
    System.out.println("Write data to marketing budget ...");
    runSample("update");

    System.out.println("Query marketing budget ...");
    out = runSample("querymarketingbudget");
    assertThat(out).contains("1 1 100000");
    assertThat(out).contains("2 2 500000");

    System.out.println("Write with transaction using dml...");
    runSample("writewithtransactionusingdml");
    out = runSample("querymarketingbudget");
    assertThat(out).contains("1 1 300000");
    assertThat(out).contains("1 1 300000");

    System.out.println("Add index ...");
    runSample("addindex");

    System.out.println("Read index ...");
    out = runSample("readindex");
    assertThat(out).contains("Go, Go, Go");
    assertThat(out).contains("Forever Hold Your Peace");
    assertThat(out).contains("Green");

    System.out.println("Add Storing index ...");
    runSample("addstoringindex");

    System.out.println("Read storing index ...");
    out = runSample("readstoringindex");
    assertThat(out).contains("300000");

    System.out.println("Read only transaction ...");
    out = runSample("readonlytransaction");
    assertThat(out.replaceAll("[\r\n]+", " "))
        .containsMatch("(Total Junk.*){2}");

    System.out.println("Add Timestamp column ...");
    out = runSample("addlastupdatetimestampcolumn");
    assertThat(out).contains("Added LastUpdateTime as a timestamp column");

    System.out.println("Update values in Timestamp column ...");
    runSample("updatewithtimestamp");
    out = runSample("querywithtimestamp");
    assertThat(out).contains("1 1 1000000");
    assertThat(out).contains("2 2 750000");

    System.out.println("Create table with Timestamp column ...");
    out = runSample("createtablewithtimestamp");
    assertThat(out).contains("Created Performances table in database");

    System.out.println("Write with Timestamp ...");
    runSample("writewithtimestamp");
    out = runSample("queryperformancestable");
    assertThat(out).contains("1 4 11000");
    assertThat(out).contains("1 19 15000");
    assertThat(out).contains("2 42 7000");

    System.out.println("Write using DML ...");
    runSample("insertusingdml");
    out = runSample("querysingerstable");
    assertThat(out).contains("Virginia Watson");

    System.out.println("Update using DML ...");
    runSample("updateusingdml");
    out = runSample("querymarketingbudget");
    assertThat(out).contains("1 1 2000000");

    System.out.println("Delete using DML ...");
    runSample("deleteusingdml");
    out = runSample("querysingerstable");
    assertThat(out).doesNotContain("Alice Trentor");

    System.out.println("Write and Read using DML ...");
    out = runSample("writeandreadusingdml");
    assertThat(out).contains("Timothy Campbell");

    System.out.println("Update using partitioned DML ...");
    runSample("updateusingpartitioneddml");
    out = runSample("querymarketingbudget");
    assertThat(out).contains("2 2 100000");
    assertThat(out).contains("1 1 2000000");

    System.out.println("Delete using Partitioned DML ...");
    runSample("deleteusingpartitioneddml");
    out = runSample("querysingerstable");
    assertThat(out).doesNotContain("Timothy Grant");
    assertThat(out).doesNotContain("Melissa Garcia");
    assertThat(out).doesNotContain("Russell Morales");
    assertThat(out).doesNotContain("Jacqueline Long");
    assertThat(out).doesNotContain("Dylan Shaw");

    System.out.println("Update in Batch using DML ...");
    out = runSample("updateusingbatchdml");
    assertThat(out).contains("1 record updated by stmt 0");
    assertThat(out).contains("1 record updated by stmt 1");

    System.out.println("Create table with data types ...");
    out = runSample("createtablewithdatatypes");
    assertThat(out).contains("Created Venues table in database");

    System.out.println("Write into table and Query Boolean Type ...");
    runSample("writedatatypesdata");
    out = runSample("querywithbool");
    assertThat(out).contains("19 Venue 19 true");

    System.out.println("Query with Bytes ...");
    out = runSample("querywithbytes");
    assertThat(out).contains("4 Venue 4");

    System.out.println("Query with Float ...");
    out = runSample("querywithfloat");
    assertThat(out).contains("4 Venue 4 0.8");
    assertThat(out).contains("19 Venue 19 0.9");

    System.out.println("Query with Int ...");
    out = runSample("querywithint");
    assertThat(out).contains("19 Venue 19 6300");
    assertThat(out).contains("42 Venue 42 3000");

    System.out.println("Query with String ...");
    out = runSample("querywithstring");
    assertThat(out).contains("42 Venue 42");

    System.out.println("Query with Timestamp parameter ...");
    out = runSample("querywithtimestampparameter");
    assertThat(out).contains("4 Venue 4");
    assertThat(out).contains("19 Venue 19");
    assertThat(out).contains("42 Venue 42");

    System.out.println("Query with Numeric Type ...");
    out = runSample("querywithnumeric");
    assertThat(out).contains("19 Venue 19 1200100");
    assertThat(out).contains("42 Venue 42 390650.99");

    System.out.println("Query options ...");
    out = runSample("clientwithqueryoptions");
    assertThat(out).contains("1 1 Total Junk");
    out = runSample("querywithqueryoptions");
    assertThat(out).contains("1 1 Total Junk");
  }
}
