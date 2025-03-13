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

import com.google.cloud.bigtable.data.v2.models.AuthorizedViewId;
import com.google.cloud.bigtable.data.v2.models.MaterializedViewId;
import com.google.cloud.bigtable.data.v2.models.TableId;
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

  @Test
  public void formatAuthorizedViewNameTest() {
    String testAuthorizedViewName =
        "projects/my-project/instances/my-instance/tables/my-table/authorizedViews/my-authorized-view";

    assertThat(
            NameUtil.formatAuthorizedViewName(
                "my-project", "my-instance", "my-table", "my-authorized-view"))
        .isEqualTo(testAuthorizedViewName);
  }

  @Test
  public void formatMaterializedViewNameTest() {
    String testMaterializedViewName =
        "projects/my-project/instances/my-instance/materializedViews/my-materialized-view";

    assertThat(
            NameUtil.formatMaterializedViewName(
                "my-project", "my-instance", "my-materialized-view"))
        .isEqualTo(testMaterializedViewName);
  }

  @Test
  public void formatLogicalViewNameTest() {
    String testLogicalViewName =
        "projects/my-project/instances/my-instance/logicalViews/my-logical-view";

    assertThat(NameUtil.formatLogicalViewName("my-project", "my-instance", "my-logical-view"))
        .isEqualTo(testLogicalViewName);
  }

  @Test
  public void extractAuthorizedViewIdFromAuthorizedViewNameTest() {
    String testAuthorizedViewName =
        "projects/my-project/instances/my-instance/tables/my-table/authorizedViews/my-authorized-view";

    assertThat(NameUtil.extractAuthorizedViewIdFromAuthorizedViewName(testAuthorizedViewName))
        .isEqualTo("my-authorized-view");

    exception.expect(IllegalArgumentException.class);
    NameUtil.extractAuthorizedViewIdFromAuthorizedViewName("bad-format");
  }

  @Test
  public void extractTableIdFromAuthorizedViewNameTest() {
    String testAuthorizedViewName =
        "projects/my-project/instances/my-instance/tables/my-table/authorizedViews/my-authorized-view";

    assertThat(
            com.google.cloud.bigtable.data.v2.internal.NameUtil
                .extractTableIdFromAuthorizedViewName(testAuthorizedViewName))
        .isEqualTo("my-table");

    exception.expect(IllegalArgumentException.class);
    com.google.cloud.bigtable.data.v2.internal.NameUtil.extractTableIdFromAuthorizedViewName(
        "bad-format");
  }

  @Test
  public void extractTableNameFromAuthorizedViewNameTest() {
    String testAuthorizedViewName =
        "projects/my-project/instances/my-instance/tables/my-table/authorizedViews/my-authorized-view";

    assertThat(
            com.google.cloud.bigtable.data.v2.internal.NameUtil
                .extractTableNameFromAuthorizedViewName(testAuthorizedViewName))
        .isEqualTo("projects/my-project/instances/my-instance/tables/my-table");

    exception.expect(IllegalArgumentException.class);
    com.google.cloud.bigtable.data.v2.internal.NameUtil.extractTableNameFromAuthorizedViewName(
        "bad-format");
  }

  @Test
  public void testExtractTargetId2() {
    String testTableName = "projects/my-project/instances/my-instance/tables/my-table";
    String testAuthorizedViewName =
        "projects/my-project/instances/my-instance/tables/my-table/authorizedViews/my-authorized-view";
    assertThat(
            com.google.cloud.bigtable.data.v2.internal.NameUtil.extractTargetId(
                testTableName, "", ""))
        .isEqualTo(TableId.of("my-table"));
    assertThat(
            com.google.cloud.bigtable.data.v2.internal.NameUtil.extractTargetId(
                "", testAuthorizedViewName, ""))
        .isEqualTo(AuthorizedViewId.of("my-table", "my-authorized-view"));

    // No name is provided
    exception.expect(IllegalArgumentException.class);
    com.google.cloud.bigtable.data.v2.internal.NameUtil.extractTargetId("", "");

    // Multiple names are provided
    exception.expect(IllegalArgumentException.class);
    com.google.cloud.bigtable.data.v2.internal.NameUtil.extractTargetId(
        testTableName, testAuthorizedViewName);
  }

  @Test
  public void testExtractTargetId3() {
    String testTableName = "projects/my-project/instances/my-instance/tables/my-table";
    String testAuthorizedViewName =
        "projects/my-project/instances/my-instance/tables/my-table/authorizedViews/my-authorized-view";
    String testMaterializedViewName =
        "projects/my-project/instances/my-instance/materializedViews/my-materialized-view";
    assertThat(
            com.google.cloud.bigtable.data.v2.internal.NameUtil.extractTargetId(
                testTableName, "", ""))
        .isEqualTo(TableId.of("my-table"));
    assertThat(
            com.google.cloud.bigtable.data.v2.internal.NameUtil.extractTargetId(
                "", testAuthorizedViewName, ""))
        .isEqualTo(AuthorizedViewId.of("my-table", "my-authorized-view"));
    assertThat(
            com.google.cloud.bigtable.data.v2.internal.NameUtil.extractTargetId(
                "", "", testMaterializedViewName))
        .isEqualTo(MaterializedViewId.of("my-materialized-view"));

    // No name is provided
    exception.expect(IllegalArgumentException.class);
    com.google.cloud.bigtable.data.v2.internal.NameUtil.extractTargetId("", "", "");

    // Multiple names are provided
    exception.expect(IllegalArgumentException.class);
    com.google.cloud.bigtable.data.v2.internal.NameUtil.extractTargetId(
        testTableName, testAuthorizedViewName, "");

    exception.expect(IllegalArgumentException.class);
    com.google.cloud.bigtable.data.v2.internal.NameUtil.extractTargetId(
        testTableName, "", testMaterializedViewName);

    exception.expect(IllegalArgumentException.class);
    com.google.cloud.bigtable.data.v2.internal.NameUtil.extractTargetId(
        "", testAuthorizedViewName, testMaterializedViewName);
  }
}
