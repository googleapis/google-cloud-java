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

public class UnnamedParametersIT extends SampleTestBase {
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
                "CREATE TABLE Students ("
                    + "  StudentId INT64 NOT NULL PRIMARY KEY,"
                    + "  Name STRING(1024) NOT NULL,"
                    + "  IsNRI BOOL NOT NULL,"
                    + "  AvgMarks FLOAT32 NOT NULL,"
                    + "  JoinedAt DATE NOT NULL,"
                    + "  PinCode  INT64 NOT NULL,"
                    + "  CreatedAt TIMESTAMP NOT NULL"
                    + ")"))
        .get();
  }

  @Test
  public void testUnnamedParameters() throws Exception {
    final String out =
        SampleRunner.runSample(
            () -> UnnamedParametersExample.executeQueryWithUnnamedParameters(projectId, instanceId,
                databaseId));
    assertTrue(out.contains("Row is inserted."));
    assertTrue(out.contains("Google"));
    assertTrue(out.contains("Row is fetched."));
  }
}
