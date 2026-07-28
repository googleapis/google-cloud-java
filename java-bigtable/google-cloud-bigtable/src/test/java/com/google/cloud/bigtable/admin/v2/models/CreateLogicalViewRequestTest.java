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
public class CreateLogicalViewRequestTest {
  private static final String PROJECT_ID = "my-project";
  private static final String INSTANCE_ID = "my-instance";
  private static final String LOGICAL_VIEW_ID = "my-logical-view";

  @Test
  public void testToProto() {
    String query = "SELECT * FROM Table";
    CreateLogicalViewRequest request =
        CreateLogicalViewRequest.of(INSTANCE_ID, LOGICAL_VIEW_ID)
            .setQuery(query)
            .setDeletionProtection(true);

    com.google.bigtable.admin.v2.CreateLogicalViewRequest requestProto =
        com.google.bigtable.admin.v2.CreateLogicalViewRequest.newBuilder()
            .setParent(NameUtil.formatInstanceName(PROJECT_ID, INSTANCE_ID))
            .setLogicalViewId(LOGICAL_VIEW_ID)
            .setLogicalView(
                com.google.bigtable.admin.v2.LogicalView.newBuilder()
                    .setQuery(query)
                    .setDeletionProtection(true))
            .build();
    assertThat(request.toProto(PROJECT_ID)).isEqualTo(requestProto);
  }

  @Test
  public void testEquality() {
    CreateLogicalViewRequest request =
        CreateLogicalViewRequest.of(INSTANCE_ID, LOGICAL_VIEW_ID)
            .setQuery("test 1")
            .setDeletionProtection(true);

    assertThat(request)
        .isEqualTo(
            CreateLogicalViewRequest.of(INSTANCE_ID, LOGICAL_VIEW_ID)
                .setQuery("test 1")
                .setDeletionProtection(true));

    assertThat(request)
        .isNotEqualTo(
            CreateLogicalViewRequest.of(INSTANCE_ID, LOGICAL_VIEW_ID)
                .setQuery("test 2")
                .setDeletionProtection(true));
  }

  @Test
  public void testHashCode() {
    CreateLogicalViewRequest request =
        CreateLogicalViewRequest.of(INSTANCE_ID, LOGICAL_VIEW_ID)
            .setQuery("test 1")
            .setDeletionProtection(true);

    assertThat(request.hashCode())
        .isEqualTo(
            CreateLogicalViewRequest.of(INSTANCE_ID, LOGICAL_VIEW_ID)
                .setQuery("test 1")
                .setDeletionProtection(true)
                .hashCode());

    assertThat(request.hashCode())
        .isNotEqualTo(
            CreateLogicalViewRequest.of(INSTANCE_ID, LOGICAL_VIEW_ID)
                .setQuery("test 2")
                .setDeletionProtection(true)
                .hashCode());
  }
}
