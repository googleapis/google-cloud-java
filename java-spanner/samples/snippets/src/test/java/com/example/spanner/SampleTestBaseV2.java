/*
 * Copyright 2023 Google LLC
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

import com.example.spanner.SampleIdGenerator;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminSettings;
import com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient;
import com.google.cloud.spanner.admin.instance.v1.InstanceAdminSettings;
import com.google.spanner.admin.database.v1.DatabaseDialect;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * Base class for sample integration intests using auto-generated admin clients.
 */
public class SampleTestBaseV2 {

  private static final String BASE_INSTANCE_ID =
      System.getProperty("spanner.sample.instance", "mysample-instance");

  private static final String BASE_DATABASE_ID =
      System.getProperty("spanner.sample.database", "sampledb");
  private static final String BASE_BACKUP_ID = "samplebk";
  private static final String BASE_INSTANCE_CONFIG_ID = "sampleconfig";
  private static final int AWAIT_TERMINATION_SECONDS = 10;

  protected static String projectId;
  protected static final String instanceId = System.getProperty("spanner.test.instance");
  protected static DatabaseAdminClient databaseAdminClient;
  protected static InstanceAdminClient instanceAdminClient;
  protected static Spanner spanner;
  protected static final String multiRegionalInstanceId =
      System.getProperty("spanner.test.instance.mr");
  protected static final String instanceConfigName = System
      .getProperty("spanner.test.instance.config");
  protected static SampleIdGenerator idGenerator;

  @BeforeClass
  public static void beforeClass() throws IOException {
    final String serverUrl = "";
    final SpannerOptions.Builder optionsBuilder =
        SpannerOptions.newBuilder().setAutoThrottleAdministrativeRequests();
    final SpannerOptions options = optionsBuilder.build();
    final DatabaseAdminSettings.Builder databaseAdminSettingsBuilder =
        DatabaseAdminSettings.newBuilder();
    final InstanceAdminSettings.Builder instanceAdminSettingBuilder =
        InstanceAdminSettings.newBuilder();

    if (!serverUrl.isEmpty()) {
      databaseAdminSettingsBuilder.setEndpoint(serverUrl);
      instanceAdminSettingBuilder.setEndpoint(serverUrl);
    }

    projectId = options.getProjectId();
    spanner = options.getService();
    databaseAdminClient = DatabaseAdminClient.create(databaseAdminSettingsBuilder.build());
    instanceAdminClient = InstanceAdminClient.create(instanceAdminSettingBuilder.build());
    idGenerator = new SampleIdGenerator(
        BASE_DATABASE_ID, BASE_BACKUP_ID, BASE_INSTANCE_CONFIG_ID, BASE_INSTANCE_ID);
  }

  @AfterClass
  public static void afterClass() throws InterruptedException {
    for (String instanceId : idGenerator.getInstanceIds()) {
      System.out.println("Trying to drop " + instanceId);
      try {
        // If the database is not found, it is ignored (no exception is thrown)
        instanceAdminClient.deleteInstance(getInstanceName(projectId, instanceId));
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
        databaseAdminClient.dropDatabase(
            getDatabaseName(projectId, instanceId, databaseId));
        databaseAdminClient.dropDatabase(
            getDatabaseName(projectId, multiRegionalInstanceId, databaseId));
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
      System.out.println("Trying to delete " + backupId);
      try {
        // If the backup is not found, it is ignored (no exception is thrown)
        databaseAdminClient.deleteBackup(
            getBackupName(projectId, instanceId, backupId));
        databaseAdminClient.deleteBackup(
            getBackupName(projectId, multiRegionalInstanceId, backupId));
      } catch (Exception e) {
        System.out.println(
            "Failed to delete backup " + backupId + " due to " + e.getMessage() + ", skipping...");
      }
    }
    for (String configId : idGenerator.getInstanceConfigIds()) {
      System.out.println("Trying to delete " + configId);
      try {
        // If the config is not found, it is ignored (no exception is thrown)
        instanceAdminClient.deleteInstanceConfig(getInstanceConfigName(projectId, configId));
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
    databaseAdminClient.close();
    instanceAdminClient.close();

    databaseAdminClient.awaitTermination(AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    instanceAdminClient.awaitTermination(AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
  }

  static String getDatabaseName(final String projectId,
      final String instanceId, final String databaseId) {
    return String.format(
        "projects/%s/instances/%s/databases/%s", projectId, instanceId, databaseId);
  }

  static String getBackupName(final String projectId,
      final String instanceId, final String backupId) {
    return String.format(
        "projects/%s/instances/%s/backups/%s", projectId, instanceId, backupId);
  }

  static String getInstanceName(final String projectId, final String instanceId) {
    return String.format("projects/%s/instances/%s", projectId, instanceId);
  }

  static String getInstanceConfigName(final String projectId, final String instanceConfigId) {
    return String.format("projects/%s/instanceConfigs/%s", projectId, instanceConfigId);
  }

  static String getProjectName(final String projectId) {
    return String.format("projects/%s", projectId);
  }

  static String getCreateDatabaseStatement(
      final String databaseName, final DatabaseDialect dialect) {
    if (dialect == DatabaseDialect.GOOGLE_STANDARD_SQL) {
      return "CREATE DATABASE `" + databaseName + "`";
    } else {
      return "CREATE DATABASE \"" + databaseName + "\"";
    }
  }
}
