/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.spanner.jdbc.it;

import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.connection.ConnectionOptions;
import com.google.cloud.spanner.testing.EmulatorSpannerHelper;
import java.util.HashMap;
import java.util.Map;

public class JdbcIntegrationTestEnv extends IntegrationTestEnv {
  /**
   * The test database(s) that have been created for this test run. The cleanup of these databases
   * is handled by {@link com.google.cloud.spanner.testing.RemoteSpannerHelper}.
   */
  private final Map<Dialect, Database> databases = new HashMap<>();

  Database getOrCreateDatabase(Dialect dialect, Iterable<String> ddlStatements) {
    if (databases.containsKey(dialect)) {
      return databases.get(dialect);
    }
    Database database = getTestHelper().createTestDatabase(dialect, ddlStatements);
    databases.put(dialect, database);

    return database;
  }

  @Override
  protected void initializeConfig()
      throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    if (EmulatorSpannerHelper.isUsingEmulator()) {
      // Make sure that we use an owned instance on the emulator.
      System.setProperty(TEST_INSTANCE_PROPERTY, "");
    }
    super.initializeConfig();
  }

  @Override
  protected void after() {
    super.after();
    try {
      ConnectionOptions.closeSpanner();
    } catch (SpannerException e) {
      // ignore
    }
  }
}
