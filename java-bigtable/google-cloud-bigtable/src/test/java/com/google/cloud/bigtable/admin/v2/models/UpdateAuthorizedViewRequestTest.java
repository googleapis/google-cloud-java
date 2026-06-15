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
import com.google.protobuf.FieldMask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UpdateAuthorizedViewRequestTest {
  private static final String PROJECT_ID = "my-project";
  private static final String INSTANCE_ID = "my-instance";
  private static final String TABLE_ID = "my-table";
  private static final String AUTHORIZED_VIEW_ID = "my-authorized-view";

  @Test
  public void testToProto() {
    UpdateAuthorizedViewRequest request =
        UpdateAuthorizedViewRequest.of(TABLE_ID, AUTHORIZED_VIEW_ID)
            .setDeletionProtection(true)
            .setAuthorizedViewType(SubsetView.create().addRowPrefix("row#"))
            .setIgnoreWarnings(true);

    com.google.bigtable.admin.v2.UpdateAuthorizedViewRequest requestProto =
        com.google.bigtable.admin.v2.UpdateAuthorizedViewRequest.newBuilder()
            .setAuthorizedView(
                com.google.bigtable.admin.v2.AuthorizedView.newBuilder()
                    .setName(
                        NameUtil.formatAuthorizedViewName(
                            PROJECT_ID, INSTANCE_ID, TABLE_ID, AUTHORIZED_VIEW_ID))
                    .setDeletionProtection(true)
                    .setSubsetView(
                        com.google.bigtable.admin.v2.AuthorizedView.SubsetView.newBuilder()
                            .addRowPrefixes(ByteString.copyFromUtf8("row#"))))
            .setUpdateMask(
                FieldMask.newBuilder().addPaths("deletion_protection").addPaths("subset_view"))
            .setIgnoreWarnings(true)
            .build();
    assertThat(request.toProto(PROJECT_ID, INSTANCE_ID)).isEqualTo(requestProto);
  }

  @Test
  public void testUpdateDeletionProtection() {
    com.google.bigtable.admin.v2.AuthorizedView existingAuthorizedView =
        com.google.bigtable.admin.v2.AuthorizedView.newBuilder()
            .setName(
                NameUtil.formatAuthorizedViewName(
                    PROJECT_ID, INSTANCE_ID, TABLE_ID, AUTHORIZED_VIEW_ID))
            .setDeletionProtection(true)
            .setSubsetView(
                com.google.bigtable.admin.v2.AuthorizedView.SubsetView.newBuilder()
                    .addRowPrefixes(ByteString.copyFromUtf8("row#")))
            .build();

    UpdateAuthorizedViewRequest request =
        UpdateAuthorizedViewRequest.of(AuthorizedView.fromProto(existingAuthorizedView))
            .setDeletionProtection(false);

    com.google.bigtable.admin.v2.UpdateAuthorizedViewRequest requestProto =
        com.google.bigtable.admin.v2.UpdateAuthorizedViewRequest.newBuilder()
            .setAuthorizedView(existingAuthorizedView.toBuilder().setDeletionProtection(false))
            .setUpdateMask(FieldMask.newBuilder().addPaths("deletion_protection"))
            .build();
    assertThat(request.toProto(PROJECT_ID, INSTANCE_ID)).isEqualTo(requestProto);
  }

  @Test
  public void testUpdateSubsetView() {
    com.google.bigtable.admin.v2.AuthorizedView authorizedViewProto =
        com.google.bigtable.admin.v2.AuthorizedView.newBuilder()
            .setName(
                NameUtil.formatAuthorizedViewName(
                    PROJECT_ID, INSTANCE_ID, TABLE_ID, AUTHORIZED_VIEW_ID))
            .setSubsetView(
                com.google.bigtable.admin.v2.AuthorizedView.SubsetView.newBuilder()
                    .addRowPrefixes(ByteString.copyFromUtf8("row#"))
                    .putFamilySubsets(
                        "cf",
                        com.google.bigtable.admin.v2.AuthorizedView.FamilySubsets.newBuilder()
                            .addQualifiers(ByteString.copyFromUtf8("qualifier"))
                            .addQualifierPrefixes(ByteString.copyFromUtf8("prefix#"))
                            .build()))
            .build();

    UpdateAuthorizedViewRequest request =
        UpdateAuthorizedViewRequest.of(TABLE_ID, AUTHORIZED_VIEW_ID)
            .setAuthorizedViewType(
                SubsetView.create()
                    .addRowPrefix("row#")
                    .setFamilySubsets(
                        "cf",
                        FamilySubsets.create()
                            .addQualifier("qualifier")
                            .addQualifierPrefix("prefix#")));

    com.google.bigtable.admin.v2.UpdateAuthorizedViewRequest requestProto =
        com.google.bigtable.admin.v2.UpdateAuthorizedViewRequest.newBuilder()
            .setAuthorizedView(authorizedViewProto)
            .setUpdateMask(FieldMask.newBuilder().addPaths("subset_view"))
            .build();
    assertThat(request.toProto(PROJECT_ID, INSTANCE_ID)).isEqualTo(requestProto);
  }

  @Test
  public void testEquality() {
    UpdateAuthorizedViewRequest request =
        UpdateAuthorizedViewRequest.of(TABLE_ID, AUTHORIZED_VIEW_ID)
            .setAuthorizedViewType(SubsetView.create().addRowPrefix("row#"));

    assertThat(request)
        .isEqualTo(
            UpdateAuthorizedViewRequest.of(TABLE_ID, AUTHORIZED_VIEW_ID)
                .setAuthorizedViewType(SubsetView.create().addRowPrefix("row#")));

    assertThat(request)
        .isNotEqualTo(
            UpdateAuthorizedViewRequest.of(TABLE_ID, AUTHORIZED_VIEW_ID)
                .setAuthorizedViewType(SubsetView.create().addRowPrefix("another-row#")));
  }

  @Test
  public void testHashCode() {
    UpdateAuthorizedViewRequest request =
        UpdateAuthorizedViewRequest.of(TABLE_ID, AUTHORIZED_VIEW_ID)
            .setAuthorizedViewType(SubsetView.create().addRowPrefix("row#"));

    assertThat(request.hashCode())
        .isEqualTo(
            UpdateAuthorizedViewRequest.of(TABLE_ID, AUTHORIZED_VIEW_ID)
                .setAuthorizedViewType(SubsetView.create().addRowPrefix("row#"))
                .hashCode());

    assertThat(request.hashCode())
        .isNotEqualTo(
            UpdateAuthorizedViewRequest.of(TABLE_ID, AUTHORIZED_VIEW_ID)
                .setAuthorizedViewType(SubsetView.create().addRowPrefix("another-row#"))
                .hashCode());
  }
}
