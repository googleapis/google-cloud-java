/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link com.google.cloud.spanner.BackupId}. */
@RunWith(JUnit4.class)
public class BackupIdTest {

  @Test
  public void basics() {
    String name = "projects/test-project/instances/test-instance/backups/backup-1";
    BackupId bid = BackupId.of(name);
    assertThat(bid.getName()).isEqualTo(name);
    assertThat(bid.getInstanceId().getInstance()).isEqualTo("test-instance");
    assertThat(bid.getBackup()).isEqualTo("backup-1");
    assertThat(BackupId.of("test-project", "test-instance", "backup-1")).isEqualTo(bid);
    assertThat(BackupId.of(name)).isEqualTo(bid);
    assertThat(BackupId.of(name).hashCode()).isEqualTo(bid.hashCode());
    assertThat(bid.toString()).isEqualTo(name);
  }

  @Test
  public void badName() {
    IllegalArgumentException e =
        assertThrows(IllegalArgumentException.class, () -> BackupId.of("bad name"));
    assertThat(e.getMessage().contains("projects"));
  }
}
