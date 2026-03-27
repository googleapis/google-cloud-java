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

import static com.google.common.truth.Truth.assertThat;

import com.google.spanner.admin.database.v1.BackupScheduleName;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CreateIncrementalBackupScheduleSampleIT extends SampleTestBaseV2 {
  // Default instance and given db should exist for tests to pass.
  private static String databaseId = System.getProperty("spanner.sample.database", "mysample");

  @Test
  public void testCreateIncrementalBackupScheduleSample() throws Exception {
    String backupScheduleId = String.format("schedule-%s", UUID.randomUUID());
    BackupScheduleName backupScheduleName =
        BackupScheduleName.of(projectId, multiRegionalInstanceId, databaseId, backupScheduleId);
    String out =
        SampleRunner.runSample(
            () -> {
              try {
                CreateIncrementalBackupScheduleSample.createIncrementalBackupSchedule(
                    projectId, multiRegionalInstanceId, databaseId, backupScheduleId);
              } finally {
                DeleteBackupScheduleSample.deleteBackupSchedule(
                    projectId, multiRegionalInstanceId, databaseId, backupScheduleId);
              }
            });
    assertThat(out)
        .contains(String.format("Created incremental backup schedule: %s", backupScheduleName));
  }
}
