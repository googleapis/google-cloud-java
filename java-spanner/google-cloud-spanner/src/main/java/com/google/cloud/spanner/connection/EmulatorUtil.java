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

package com.google.cloud.spanner.connection;

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.InstanceConfigId;
import com.google.cloud.spanner.InstanceInfo;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.concurrent.ExecutionException;

/**
 * Util class for automatically generating a test instance and test database on a Cloud Spanner
 * emulator instance. This makes it easier to automatically start a working emulator and test an
 * application when working with JDBC.
 */
class EmulatorUtil {

  /**
   * Creates the instance and the database that are specified in the connection string on the
   * emulator that the given {@link Spanner} instance connects to if these do not already exist.
   *
   * @param spanner a {@link Spanner} instance that connects to an emulator instance
   * @param databaseId the id of the instance and the database to create
   * @param dialect the {@link Dialect} to use for the database to create
   */
  static void maybeCreateInstanceAndDatabase(
      Spanner spanner, DatabaseId databaseId, Dialect dialect) {
    Preconditions.checkArgument(
        NoCredentials.getInstance().equals(spanner.getOptions().getCredentials()));
    try {
      spanner
          .getInstanceAdminClient()
          .createInstance(
              InstanceInfo.newBuilder(databaseId.getInstanceId())
                  .setDisplayName("Automatically Generated Test Instance")
                  .setNodeCount(1)
                  .setInstanceConfigId(
                      InstanceConfigId.of(
                          databaseId.getInstanceId().getProject(), "emulator-config"))
                  .build())
          .get();
    } catch (ExecutionException executionException) {
      SpannerException spannerException = (SpannerException) executionException.getCause();
      if (spannerException.getErrorCode() != ErrorCode.ALREADY_EXISTS) {
        throw spannerException;
      }
    } catch (InterruptedException e) {
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
    try {
      spanner
          .getDatabaseAdminClient()
          .createDatabase(
              databaseId.getInstanceId().getInstance(),
              dialect.createDatabaseStatementFor(databaseId.getDatabase()),
              dialect,
              ImmutableList.of())
          .get();
    } catch (ExecutionException executionException) {
      SpannerException spannerException = (SpannerException) executionException.getCause();
      if (spannerException.getErrorCode() != ErrorCode.ALREADY_EXISTS) {
        throw spannerException;
      }
    } catch (InterruptedException e) {
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
  }
}
