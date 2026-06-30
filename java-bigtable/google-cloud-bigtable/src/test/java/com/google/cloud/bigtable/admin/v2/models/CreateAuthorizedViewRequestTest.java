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
import com.google.protobuf.ByteString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CreateAuthorizedViewRequestTest {
  private static final String PROJECT_ID = "my-project";
  private static final String INSTANCE_ID = "my-instance";
  private static final String TABLE_ID = "my-table";
  private static final String AUTHORIZED_VIEW_ID = "my-authorized-view";

  @Test
  public void testToProto() {
    CreateAuthorizedViewRequest request =
        CreateAuthorizedViewRequest.of(TABLE_ID, AUTHORIZED_VIEW_ID)
            .setDeletionProtection(true)
            .setAuthorizedViewType(
                SubsetView.create()
                    .addRowPrefix("row#")
                    .addRowPrefix("another-row#")
                    .setFamilySubsets(
                        "family",
                        FamilySubsets.create()
                            .addQualifier("column")
                            .addQualifierPrefix("column#")));

    com.google.bigtable.admin.v2.CreateAuthorizedViewRequest requestProto =
        com.google.bigtable.admin.v2.CreateAuthorizedViewRequest.newBuilder()
            .setParent(NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID))
            .setAuthorizedViewId(AUTHORIZED_VIEW_ID)
            .setAuthorizedView(
                com.google.bigtable.admin.v2.AuthorizedView.newBuilder()
                    .setDeletionProtection(true)
                    .setSubsetView(
                        com.google.bigtable.admin.v2.AuthorizedView.SubsetView.newBuilder()
                            .addRowPrefixes(ByteString.copyFromUtf8("row#"))
                            .addRowPrefixes(ByteString.copyFromUtf8("another-row#"))
                            .putFamilySubsets(
                                "family",
                                com.google.bigtable.admin.v2.AuthorizedView.FamilySubsets
                                    .newBuilder()
                                    .addQualifiers(ByteString.copyFromUtf8("column"))
                                    .addQualifierPrefixes(ByteString.copyFromUtf8("column#"))
                                    .build())))
            .build();
    assertThat(request.toProto(PROJECT_ID, INSTANCE_ID)).isEqualTo(requestProto);
  }

  @Test
  public void testEquality() {
    CreateAuthorizedViewRequest request =
        CreateAuthorizedViewRequest.of(TABLE_ID, AUTHORIZED_VIEW_ID)
            .setAuthorizedViewType(SubsetView.create().addRowPrefix("row#"))
            .setDeletionProtection(false);

    assertThat(request)
        .isEqualTo(
            CreateAuthorizedViewRequest.of(TABLE_ID, AUTHORIZED_VIEW_ID)
                .setAuthorizedViewType(SubsetView.create().addRowPrefix("row#")));

    assertThat(request)
        .isNotEqualTo(
            CreateAuthorizedViewRequest.of(TABLE_ID, AUTHORIZED_VIEW_ID)
                .setAuthorizedViewType(SubsetView.create().addRowPrefix("another-row#")));
  }

  @Test
  public void testHashCode() {
    CreateAuthorizedViewRequest request =
        CreateAuthorizedViewRequest.of(TABLE_ID, AUTHORIZED_VIEW_ID)
            .setAuthorizedViewType(SubsetView.create().addRowPrefix("row#"))
            .setDeletionProtection(false);

    assertThat(request.hashCode())
        .isEqualTo(
            CreateAuthorizedViewRequest.of(TABLE_ID, AUTHORIZED_VIEW_ID)
                .setAuthorizedViewType(SubsetView.create().addRowPrefix("row#"))
                .hashCode());

    assertThat(request.hashCode())
        .isNotEqualTo(
            CreateAuthorizedViewRequest.of(TABLE_ID, AUTHORIZED_VIEW_ID)
                .setAuthorizedViewType(SubsetView.create().addRowPrefix("another-row#"))
                .hashCode());
  }
}
