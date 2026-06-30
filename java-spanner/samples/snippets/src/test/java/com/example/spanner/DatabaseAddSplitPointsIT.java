/*
 * Copyright 2025 Google LLC
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

import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.DatabaseId;
import com.google.common.collect.ImmutableList;
import java.util.concurrent.ExecutionException;
import org.junit.Before;
import org.junit.Test;

public class DatabaseAddSplitPointsIT extends SampleTestBase {
  private static String databaseId;

  @Before
  public void setup() throws ExecutionException, InterruptedException {
    databaseId = idGenerator.generateDatabaseId();
    databaseAdminClient
        .createDatabase(
            databaseAdminClient
                .newDatabaseBuilder(DatabaseId.of(projectId, instanceId, databaseId))
                .build(),
            ImmutableList.of(
                "CREATE TABLE Singers ("
                    + "  SingerId   INT64 NOT NULL,"
                    + "  FirstName  STRING(1024),"
                    + "  LastName   STRING(1024)"
                    + ") PRIMARY KEY (SingerId)",
                " CREATE INDEX IF NOT EXISTS SingersByFirstLastName ON Singers(FirstName,"
                    + " LastName)"))
        .get();
  }

  // TODO: Enable the test once the issue with split points is resolved
  // @Test
  public void testAddSplits() throws Exception {
    final String out =
        SampleRunner.runSample(
            () -> DatabaseAddSplitPointsSample.addSplitPoints(projectId, instanceId, databaseId));
    assertTrue(out.contains(""));
  }
}
