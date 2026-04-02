/*
 * Copyright 2021 Google LLC
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

package com.example.spanner;

import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.InstanceAdminClient;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/** Base class for sample integration tests. */
public class SampleTestBase {
  private static final String BASE_INSTANCE_ID =
      System.getProperty("spanner.sample.instance", "mysample-instance");
  private static final String BASE_DATABASE_ID =
      System.getProperty("spanner.sample.database", "sampledb");
  private static final String BASE_BACKUP_ID = "samplebk";
  private static final String BASE_INSTANCE_CONFIG_ID = "sampleconfig";

  protected static Spanner spanner;
  protected static DatabaseAdminClient databaseAdminClient;
  protected static InstanceAdminClient instanceAdminClient;
  protected static String projectId;
  protected static final String instanceId = System.getProperty("spanner.test.instance");
  protected static final String multiRegionalInstanceId =
      System.getProperty("spanner.test.instance.mr");
  protected static final String instanceConfigName = System
      .getProperty("spanner.test.instance.config");
  protected static SampleIdGenerator idGenerator;

  @BeforeClass
  public static void beforeClass() {
    final String serverUrl = "";
    final SpannerOptions.Builder optionsBuilder = SpannerOptions
        .newBuilder()
        .setAutoThrottleAdministrativeRequests();
    if (!serverUrl.isEmpty()) {
      optionsBuilder.setHost(serverUrl);
    }
    final SpannerOptions options = optionsBuilder.build();
    projectId = options.getProjectId();
    spanner = options.getService();
    databaseAdminClient = spanner.getDatabaseAdminClient();
    instanceAdminClient = spanner.getInstanceAdminClient();
    idGenerator = new SampleIdGenerator(
        BASE_DATABASE_ID, BASE_BACKUP_ID, BASE_INSTANCE_CONFIG_ID, BASE_INSTANCE_ID);
  }

  @AfterClass
  public static void afterClass() {
    for (String instanceId : idGenerator.getInstanceIds()) {
      System.out.println("Trying to drop " + instanceId);
      try {
        // If the database is not found, it is ignored (no exception is thrown)
        instanceAdminClient.deleteInstance(instanceId);
      } catch (Exception e) {
        System.out.println(
            "Failed to drop instance "
                + instanceId
                + " due to "
                + e.getMessage()
                + ", skipping...");
      }
    }

    for (String databaseId : idGenerator.getDatabaseIds()) {
      System.out.println("Trying to drop " + databaseId);
      try {
        // If the database is not found, it is ignored (no exception is thrown)
        databaseAdminClient.dropDatabase(instanceId, databaseId);
        databaseAdminClient.dropDatabase(multiRegionalInstanceId, databaseId);
      } catch (Exception e) {
        System.out.println(
            "Failed to drop database "
                + databaseId
                + " due to "
                + e.getMessage()
                + ", skipping...");
      }
    }
    for (String backupId : idGenerator.getBackupIds()) {
      try {
        // If the backup is not found, it is ignored (no exception is thrown)
        databaseAdminClient.deleteBackup(instanceId, backupId);
        databaseAdminClient.deleteBackup(multiRegionalInstanceId, backupId);
      } catch (Exception e) {
        System.out.println(
            "Failed to delete backup " + backupId + " due to " + e.getMessage() + ", skipping...");
      }
    }
    for (String configId : idGenerator.getInstanceConfigIds()) {
      try {
        // If the config is not found, it is ignored (no exception is thrown)
        instanceAdminClient.deleteInstanceConfig(configId);
      } catch (Exception e) {
        System.out.println(
            "Failed to delete instance config "
                + configId
                + " due to "
                + e.getMessage()
                + ", skipping...");
      }
    }
    spanner.close();
  }
}
