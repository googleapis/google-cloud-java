/*
 * Copyright 2024 Google LLC
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

// [START spanner_create_database_with_MR_CMEK]

import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.common.collect.ImmutableList;
import com.google.spanner.admin.database.v1.CreateDatabaseRequest;
import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.database.v1.EncryptionConfig;
import com.google.spanner.admin.database.v1.InstanceName;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CreateDatabaseWithMultiRegionEncryptionKey {

  static void createDatabaseWithEncryptionKey() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";
    String[] kmsKeyNames =
        new String[] {
          "projects/" + projectId + "/locations/<location1>/keyRings/<keyRing>/cryptoKeys/<keyId>",
          "projects/" + projectId + "/locations/<location2>/keyRings/<keyRing>/cryptoKeys/<keyId>",
          "projects/" + projectId + "/locations/<location3>/keyRings/<keyRing>/cryptoKeys/<keyId>"
        };
    try (Spanner spanner =
            SpannerOptions.newBuilder().setProjectId(projectId).build().getService();
        DatabaseAdminClient adminClient = spanner.createDatabaseAdminClient()) {
      createDatabaseWithMultiRegionEncryptionKey(
          adminClient, projectId, instanceId, databaseId, kmsKeyNames);
    }
  }

  static void createDatabaseWithMultiRegionEncryptionKey(
      DatabaseAdminClient adminClient,
      String projectId,
      String instanceId,
      String databaseId,
      String[] kmsKeyNames) {
    InstanceName instanceName = InstanceName.of(projectId, instanceId);
    CreateDatabaseRequest request =
        CreateDatabaseRequest.newBuilder()
            .setParent(instanceName.toString())
            .setCreateStatement("CREATE DATABASE `" + databaseId + "`")
            .setEncryptionConfig(
                EncryptionConfig.newBuilder()
                    .addAllKmsKeyNames(ImmutableList.copyOf(kmsKeyNames))
                    .build())
            .addAllExtraStatements(
                ImmutableList.of(
                    "CREATE TABLE Singers ("
                        + "  SingerId   INT64 NOT NULL,"
                        + "  FirstName  STRING(1024),"
                        + "  LastName   STRING(1024),"
                        + "  SingerInfo BYTES(MAX)"
                        + ") PRIMARY KEY (SingerId)",
                    "CREATE TABLE Albums ("
                        + "  SingerId     INT64 NOT NULL,"
                        + "  AlbumId      INT64 NOT NULL,"
                        + "  AlbumTitle   STRING(MAX)"
                        + ") PRIMARY KEY (SingerId, AlbumId),"
                        + "  INTERLEAVE IN PARENT Singers ON DELETE CASCADE"))
            .build();
    try {
      System.out.println("Waiting for operation to complete...");
      Database createdDatabase =
          adminClient.createDatabaseAsync(request).get(120, TimeUnit.SECONDS);

      System.out.printf(
          "Database %s created with encryption keys %s%n",
          createdDatabase.getName(), createdDatabase.getEncryptionConfig().getKmsKeyNamesList());
    } catch (ExecutionException e) {
      // If the operation failed during execution, expose the cause.
      throw SpannerExceptionFactory.asSpannerException(e.getCause());
    } catch (InterruptedException e) {
      // Throw when a thread is waiting, sleeping, or otherwise occupied,
      // and the thread is interrupted, either before or during the activity.
      throw SpannerExceptionFactory.propagateInterrupt(e);
    } catch (TimeoutException e) {
      // If the operation timed out propagates the timeout
      throw SpannerExceptionFactory.propagateTimeout(e);
    }
  }
}
// [END spanner_create_database_with_MR_CMEK]
