/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigtable.data.v2.models;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MaterializedViewIdTest {
  private static final String PROJECT_ID = "my-project";
  private static final String INSTANCE_ID = "my-instance";
  private static final String TABLE_ID = "my-table";
  private static final String MATERIALIZED_VIEW_ID = "my-materialized-view";

  @Test
  public void testToResourceName() {
    MaterializedViewId authorizedViewId = MaterializedViewId.of(MATERIALIZED_VIEW_ID);

    assertThat(authorizedViewId.toResourceName(PROJECT_ID, INSTANCE_ID))
        .isEqualTo(
            "projects/my-project/instances/my-instance/materializedViews/my-materialized-view");
  }

  @Test
  public void testEquality() {
    MaterializedViewId authorizedViewId = MaterializedViewId.of(MATERIALIZED_VIEW_ID);

    assertThat(authorizedViewId).isEqualTo(MaterializedViewId.of(MATERIALIZED_VIEW_ID));
    assertThat(authorizedViewId).isNotEqualTo(MaterializedViewId.of("another-materialized-view"));
    assertThat(authorizedViewId).isNotEqualTo(TableId.of(TABLE_ID));
  }

  @Test
  public void testHashCode() {
    MaterializedViewId authorizedViewId = MaterializedViewId.of(MATERIALIZED_VIEW_ID);

    assertThat(authorizedViewId.hashCode())
        .isEqualTo(MaterializedViewId.of(MATERIALIZED_VIEW_ID).hashCode());
    assertThat(authorizedViewId.hashCode())
        .isNotEqualTo(MaterializedViewId.of("another-materialized-view").hashCode());
    assertThat(authorizedViewId.hashCode()).isNotEqualTo(TableId.of(TABLE_ID).hashCode());
  }

  @Test
  public void testToString() {
    MaterializedViewId authorizedViewId = MaterializedViewId.of(MATERIALIZED_VIEW_ID);

    assertThat(authorizedViewId.toString())
        .isEqualTo("MaterializedViewId{materializedViewId=my-materialized-view}");
  }
}
