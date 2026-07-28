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
import com.google.protobuf.FieldMask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UpdateLogicalViewRequestTest {
  private static final String PROJECT_ID = "my-project";
  private static final String INSTANCE_ID = "my-instance";
  private static final String LOGICAL_VIEW_ID = "my-logical-view";

  @Test
  public void testToProto() {
    UpdateLogicalViewRequest request =
        UpdateLogicalViewRequest.of(INSTANCE_ID, LOGICAL_VIEW_ID)
            .setQuery("query 1")
            .setDeletionProtection(true);

    com.google.bigtable.admin.v2.UpdateLogicalViewRequest requestProto =
        com.google.bigtable.admin.v2.UpdateLogicalViewRequest.newBuilder()
            .setLogicalView(
                com.google.bigtable.admin.v2.LogicalView.newBuilder()
                    .setQuery("query 1")
                    .setDeletionProtection(true)
                    .setName(
                        NameUtil.formatLogicalViewName(PROJECT_ID, INSTANCE_ID, LOGICAL_VIEW_ID)))
            .setUpdateMask(
                FieldMask.newBuilder().addPaths("deletion_protection").addPaths("query").build())
            .build();
    assertThat(request.toProto(PROJECT_ID)).isEqualTo(requestProto);
  }

  @Test
  public void testEquality() {
    UpdateLogicalViewRequest request =
        UpdateLogicalViewRequest.of(INSTANCE_ID, LOGICAL_VIEW_ID)
            .setQuery("query 1")
            .setDeletionProtection(true);

    assertThat(request)
        .isEqualTo(
            UpdateLogicalViewRequest.of(INSTANCE_ID, LOGICAL_VIEW_ID)
                .setQuery("query 1")
                .setDeletionProtection(true));

    assertThat(request)
        .isNotEqualTo(
            UpdateLogicalViewRequest.of(INSTANCE_ID, LOGICAL_VIEW_ID)
                .setQuery("query 2")
                .setDeletionProtection(true));
  }

  @Test
  public void testHashCode() {
    UpdateLogicalViewRequest request =
        UpdateLogicalViewRequest.of(INSTANCE_ID, LOGICAL_VIEW_ID)
            .setQuery("query 1")
            .setDeletionProtection(true);

    assertThat(request.hashCode())
        .isEqualTo(
            UpdateLogicalViewRequest.of(INSTANCE_ID, LOGICAL_VIEW_ID)
                .setQuery("query 1")
                .setDeletionProtection(true)
                .hashCode());

    assertThat(request.hashCode())
        .isNotEqualTo(
            UpdateLogicalViewRequest.of(INSTANCE_ID, LOGICAL_VIEW_ID)
                .setQuery("query 2")
                .setDeletionProtection(true)
                .hashCode());
  }
}
