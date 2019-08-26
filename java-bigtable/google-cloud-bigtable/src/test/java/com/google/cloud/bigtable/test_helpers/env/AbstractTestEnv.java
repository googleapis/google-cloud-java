/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.test_helpers.env;

import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import org.threeten.bp.Instant;
import org.threeten.bp.temporal.ChronoUnit;

/**
 * Defines the interface of a target environment.
 *
 * <p>This allows for integration tests to run against either production or an emulator.
 */
public abstract class AbstractTestEnv {
  private static final String PREFIX = "temp-";

  abstract void start() throws Exception;

  abstract void stop() throws Exception;

  public abstract BigtableDataClient getDataClient();

  public abstract BigtableTableAdminClient getTableAdminClient();

  public abstract String getProjectId();

  public abstract String getInstanceId();

  public abstract String getTableId();

  public String getFamilyId() {
    return "cf";
  }

  public String generateTableId(String suffix) {
    return newPrefix() + "-" + suffix;
  }

  private static String newPrefix() {
    return newPrefix(Instant.now());
  }

  private static String newPrefix(Instant instant) {
    return String.format(PREFIX + "015%d", instant.getEpochSecond());
  }

  void cleanUpStale() {
    cleanupStaleTables();
  }

  private void cleanupStaleTables() {
    String stalePrefix = newPrefix(Instant.now().minus(1, ChronoUnit.DAYS));

    for (String tableId : getTableAdminClient().listTables()) {
      if (!tableId.startsWith(PREFIX)) {
        continue;
      }
      if (stalePrefix.compareTo(tableId) > 0) {
        getTableAdminClient().deleteTable(tableId);
      }
    }
  }
}
