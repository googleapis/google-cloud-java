/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.bigtable.admin.v2.internal;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class NameUtilTest {
  @Rule public ExpectedException exception = ExpectedException.none();

  @Test
  public void extractBackupIdFromBackupNameTest() {
    String testBackupName =
        "projects/my-project/instances/my-instance/clusters/my-cluster/backups/my-backup";
    assertThat(NameUtil.extractBackupIdFromBackupName(testBackupName)).isEqualTo("my-backup");

    exception.expect(IllegalArgumentException.class);
    NameUtil.extractBackupIdFromBackupName("bad-format");
  }

  @Test
  public void formatBackupNameTest() {
    String testBackupName =
        "projects/my-project/instances/my-instance/clusters/my-cluster/backups/my-backup";

    assertThat(NameUtil.formatBackupName("my-project", "my-instance", "my-cluster", "my-backup"))
        .isEqualTo(testBackupName);
  }
}
