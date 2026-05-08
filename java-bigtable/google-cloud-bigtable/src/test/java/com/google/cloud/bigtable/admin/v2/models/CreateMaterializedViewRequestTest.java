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

import com.google.cloud.bigtable.admin.v2.internal.NameUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CreateMaterializedViewRequestTest {
  private static final String PROJECT_ID = "my-project";
  private static final String INSTANCE_ID = "my-instance";
  private static final String MATERIALIZED_VIEW_ID = "my-materialized-view";

  @Test
  public void testToProto() {
    String query = "SELECT * FROM Table";
    CreateMaterializedViewRequest request =
        CreateMaterializedViewRequest.of(INSTANCE_ID, MATERIALIZED_VIEW_ID)
            .setDeletionProtection(true)
            .setQuery(query);

    com.google.bigtable.admin.v2.CreateMaterializedViewRequest requestProto =
        com.google.bigtable.admin.v2.CreateMaterializedViewRequest.newBuilder()
            .setParent(NameUtil.formatInstanceName(PROJECT_ID, INSTANCE_ID))
            .setMaterializedViewId(MATERIALIZED_VIEW_ID)
            .setMaterializedView(
                com.google.bigtable.admin.v2.MaterializedView.newBuilder()
                    .setDeletionProtection(true)
                    .setQuery(query))
            .build();
    assertThat(request.toProto(PROJECT_ID)).isEqualTo(requestProto);
  }

  @Test
  public void testEquality() {
    CreateMaterializedViewRequest request =
        CreateMaterializedViewRequest.of(INSTANCE_ID, MATERIALIZED_VIEW_ID)
            .setQuery("test 1")
            .setDeletionProtection(false);

    assertThat(request)
        .isEqualTo(
            CreateMaterializedViewRequest.of(INSTANCE_ID, MATERIALIZED_VIEW_ID)
                .setQuery("test 1")
                .setDeletionProtection(false));

    assertThat(request)
        .isNotEqualTo(
            CreateMaterializedViewRequest.of(INSTANCE_ID, MATERIALIZED_VIEW_ID)
                .setQuery("test 2")
                .setDeletionProtection(false));
  }

  @Test
  public void testHashCode() {
    CreateMaterializedViewRequest request =
        CreateMaterializedViewRequest.of(INSTANCE_ID, MATERIALIZED_VIEW_ID)
            .setQuery("test 1")
            .setDeletionProtection(false);

    assertThat(request.hashCode())
        .isEqualTo(
            CreateMaterializedViewRequest.of(INSTANCE_ID, MATERIALIZED_VIEW_ID)
                .setQuery("test 1")
                .setDeletionProtection(false)
                .hashCode());

    assertThat(request.hashCode())
        .isNotEqualTo(
            CreateMaterializedViewRequest.of(INSTANCE_ID, MATERIALIZED_VIEW_ID)
                .setQuery("test 2")
                .setDeletionProtection(false)
                .hashCode());
  }
}
