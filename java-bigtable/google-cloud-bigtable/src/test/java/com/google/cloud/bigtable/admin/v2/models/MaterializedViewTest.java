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

package com.google.cloud.bigtable.admin.v2.models;

import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.admin.v2.MaterializedViewName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MaterializedViewTest {
  private static final String PROJECT_ID = "my-project";
  private static final String INSTANCE_ID = "my-instance";
  private static final String MATERIALIZED_VIEW_ID = "my-materialized-view";

  @Test
  public void testFromProto() {
    MaterializedViewName materializedViewName =
        MaterializedViewName.of(PROJECT_ID, INSTANCE_ID, MATERIALIZED_VIEW_ID);

    com.google.bigtable.admin.v2.MaterializedView materializedViewProto =
        com.google.bigtable.admin.v2.MaterializedView.newBuilder()
            .setName(materializedViewName.toString())
            .setDeletionProtection(true)
            .setQuery("SELECT 1 from Table")
            .build();

    MaterializedView result = MaterializedView.fromProto(materializedViewProto);

    assertThat(result.getId()).isEqualTo(MATERIALIZED_VIEW_ID);
    assertThat(result.isDeletionProtected()).isTrue();
    assertThat(result.getQuery()).isEqualTo("SELECT 1 from Table");
  }

  @Test
  public void testRequiresName() {
    com.google.bigtable.admin.v2.MaterializedView proto =
        com.google.bigtable.admin.v2.MaterializedView.newBuilder()
            .setDeletionProtection(true)
            .setQuery("SELECT 1 FROM Table")
            .build();

    Exception actualException = null;

    try {
      MaterializedView.fromProto(proto);
    } catch (Exception e) {
      actualException = e;
    }

    assertThat(actualException).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void testEquality() {
    MaterializedViewName materializedViewName =
        MaterializedViewName.of(PROJECT_ID, INSTANCE_ID, MATERIALIZED_VIEW_ID);
    com.google.bigtable.admin.v2.MaterializedView proto =
        com.google.bigtable.admin.v2.MaterializedView.newBuilder()
            .setName(materializedViewName.toString())
            .setDeletionProtection(true)
            .setQuery("SELECT 1 FROM Table")
            .build();
    MaterializedView materializedView = MaterializedView.fromProto(proto);

    assertThat(materializedView).isEqualTo(MaterializedView.fromProto(proto));

    assertThat(materializedView)
        .isNotEqualTo(
            com.google.bigtable.admin.v2.MaterializedView.newBuilder()
                .setName(materializedViewName.toString())
                .setDeletionProtection(false)
                .setQuery("SELECT 1 FROM Table")
                .build());
  }

  @Test
  public void testHashCode() {
    MaterializedViewName materializedViewName =
        MaterializedViewName.of(PROJECT_ID, INSTANCE_ID, MATERIALIZED_VIEW_ID);
    com.google.bigtable.admin.v2.MaterializedView proto =
        com.google.bigtable.admin.v2.MaterializedView.newBuilder()
            .setName(materializedViewName.toString())
            .setDeletionProtection(true)
            .setQuery("SELECT 1 FROM Table")
            .build();
    MaterializedView materializedView = MaterializedView.fromProto(proto);

    assertThat(materializedView.hashCode()).isEqualTo(MaterializedView.fromProto(proto).hashCode());

    assertThat(materializedView.hashCode())
        .isNotEqualTo(
            com.google.bigtable.admin.v2.MaterializedView.newBuilder()
                .setName(materializedViewName.toString())
                .setDeletionProtection(false)
                .setQuery("SELECT 1 FROM Table")
                .build()
                .hashCode());
  }
}
