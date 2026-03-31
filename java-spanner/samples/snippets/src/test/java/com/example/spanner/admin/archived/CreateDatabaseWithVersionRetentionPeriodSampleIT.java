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

package com.example.spanner.admin.archived;

import static com.google.common.truth.Truth.assertThat;

import com.example.spanner.SampleRunner;
import com.example.spanner.SampleTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Integration tests for {@link CreateDatabaseWithVersionRetentionPeriodSample}
 */
@RunWith(JUnit4.class)
public class CreateDatabaseWithVersionRetentionPeriodSampleIT extends SampleTestBase {

  @Test
  public void createsDatabaseWithVersionRetentionPeriod() throws Exception {
    final String databaseId = idGenerator.generateDatabaseId();
    final String versionRetentionPeriod = "7d";

    final String out = SampleRunner.runSample(() -> CreateDatabaseWithVersionRetentionPeriodSample
        .createDatabaseWithVersionRetentionPeriod(
            databaseAdminClient, instanceId, databaseId, versionRetentionPeriod
        ));

    assertThat(out).contains(
        "Created database [projects/" + projectId + "/instances/" + instanceId + "/databases/"
            + databaseId + "]");
    assertThat(out).contains("Version retention period: " + versionRetentionPeriod);
  }
}
