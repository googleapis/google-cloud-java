/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link com.google.cloud.spanner.DatabaseId}. */
@RunWith(JUnit4.class)
public class DatabaseIdTest {
  @Rule public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void basics() {
    String name = "projects/test-project/instances/test-instance/databases/database-1";
    DatabaseId db = DatabaseId.of(name);
    assertThat(db.getName()).isEqualTo(name);
    assertThat(db.getInstanceId().getInstance()).isEqualTo("test-instance");
    assertThat(db.getDatabase()).isEqualTo("database-1");
    assertThat(DatabaseId.of("test-project", "test-instance", "database-1")).isEqualTo(db);
    assertThat(DatabaseId.of(name)).isEqualTo(db);
    assertThat(DatabaseId.of(name).hashCode()).isEqualTo(db.hashCode());
    assertThat(db.toString()).isEqualTo(name);
  }

  @Test
  public void badName() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("projects"); // Expect conforming pattern in output.
    DatabaseId.of("bad name");
  }
}
