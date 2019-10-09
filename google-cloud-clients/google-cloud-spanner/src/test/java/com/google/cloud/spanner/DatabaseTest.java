/*
 * Copyright 2017 Google LLC
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
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import com.google.cloud.spanner.DatabaseInfo.State;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;

/** Unit tests for {@link com.google.cloud.spanner.Database}. */
@RunWith(JUnit4.class)
public class DatabaseTest {
  private static final String NAME =
      "projects/test-project/instances/test-instance/databases/database-1";

  @Rule public ExpectedException expectedException = ExpectedException.none();
  @Mock DatabaseAdminClient dbClient;

  @Before
  public void setUp() {
    initMocks(this);
  }

  @Test
  public void fromProto() {
    Database db = createDatabase();
    assertThat(db.getId().getName()).isEqualTo(NAME);
    assertThat(db.getState()).isEqualTo(DatabaseInfo.State.CREATING);
  }

  @Test
  public void getIAMPolicy() {
    Database database =
        new Database(
            DatabaseId.of("test-project", "test-instance", "test-database"), State.READY, dbClient);
    database.getIAMPolicy();
    verify(dbClient).getDatabaseIAMPolicy("test-instance", "test-database");
  }

  @Test
  public void setIAMPolicy() {
    Database database =
        new Database(
            DatabaseId.of("test-project", "test-instance", "test-database"), State.READY, dbClient);
    Policy policy =
        Policy.newBuilder().addIdentity(Role.editor(), Identity.user("joe@example.com")).build();
    database.setIAMPolicy(policy);
    verify(dbClient).setDatabaseIAMPolicy("test-instance", "test-database", policy);
  }

  @Test
  public void testIAMPermissions() {
    Database database =
        new Database(
            DatabaseId.of("test-project", "test-instance", "test-database"), State.READY, dbClient);
    Iterable<String> permissions = Arrays.asList("read");
    database.testIAMPermissions(permissions);
    verify(dbClient).testDatabaseIAMPermissions("test-instance", "test-database", permissions);
  }

  private Database createDatabase() {
    com.google.spanner.admin.database.v1.Database proto =
        com.google.spanner.admin.database.v1.Database.newBuilder()
            .setName(NAME)
            .setState(com.google.spanner.admin.database.v1.Database.State.CREATING)
            .build();
    return Database.fromProto(proto, dbClient);
  }
}
