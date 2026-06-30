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

package com.example.spanner.admin.archived;

import static org.junit.Assert.assertTrue;

import com.example.spanner.SampleRunner;
import com.example.spanner.SampleTestBase;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Dialect;
import java.util.Collections;
import org.junit.Test;

public class PgCaseSensitivitySampleIT extends SampleTestBase {

  @Test
  public void testPgCaseSensitivitySample() throws Exception {
    final String databaseId = idGenerator.generateDatabaseId();
    databaseAdminClient
        .createDatabase(
            databaseAdminClient
                .newDatabaseBuilder(DatabaseId.of(projectId, instanceId, databaseId))
                .setDialect(Dialect.POSTGRESQL)
                .build(),
            Collections.emptyList())
        .get();

    final String out =
        SampleRunner.runSample(
            () -> PgCaseSensitivitySample.pgCaseSensitivity(projectId, instanceId, databaseId));
    assertTrue(out, out.contains("SingerId: 1, FirstName: Bruce, LastName: Allison"));
    assertTrue(out, out.contains("SingerId: 1, FullName: Bruce Allison"));
  }
}