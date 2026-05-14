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

import com.google.protobuf.ByteString;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SubsetViewTest {

  @Test
  public void testFromProto() {
    com.google.bigtable.admin.v2.AuthorizedView.SubsetView subsetViewProto =
        com.google.bigtable.admin.v2.AuthorizedView.SubsetView.newBuilder()
            .addRowPrefixes(ByteString.copyFromUtf8("row1#"))
            .addRowPrefixes(ByteString.copyFromUtf8("row2#"))
            .putFamilySubsets(
                "family1",
                com.google.bigtable.admin.v2.AuthorizedView.FamilySubsets.newBuilder()
                    .addQualifiers(ByteString.copyFromUtf8("column1"))
                    .addQualifiers(ByteString.copyFromUtf8("column2"))
                    .addQualifierPrefixes(ByteString.copyFromUtf8("column3#"))
                    .addQualifierPrefixes(ByteString.copyFromUtf8("column4#"))
                    .build())
            .putFamilySubsets(
                "family2",
                com.google.bigtable.admin.v2.AuthorizedView.FamilySubsets.newBuilder()
                    .addQualifiers(ByteString.copyFromUtf8("column5"))
                    .addQualifierPrefixes(ByteString.copyFromUtf8(""))
                    .build())
            .build();

    SubsetView result = SubsetView.fromProto(subsetViewProto);

    assertThat(result.getRowPrefixes())
        .containsExactly(ByteString.copyFromUtf8("row1#"), ByteString.copyFromUtf8("row2#"));

    Map<String, FamilySubsets> familySubsetsResult = result.getFamilySubsets();
    assertThat(familySubsetsResult)
        .containsExactly(
            "family1",
            FamilySubsets.fromProto(subsetViewProto.getFamilySubsetsOrThrow("family1")),
            "family2",
            FamilySubsets.fromProto(subsetViewProto.getFamilySubsetsOrThrow("family2")));
    assertThat(familySubsetsResult.get("family1").getQualifiers())
        .containsExactly(ByteString.copyFromUtf8("column1"), ByteString.copyFromUtf8("column2"));
    assertThat(familySubsetsResult.get("family1").getQualifierPrefixes())
        .containsExactly(ByteString.copyFromUtf8("column3#"), ByteString.copyFromUtf8("column4#"));
    assertThat(familySubsetsResult.get("family2").getQualifiers())
        .containsExactly(ByteString.copyFromUtf8("column5"));
    assertThat(familySubsetsResult.get("family2").getQualifierPrefixes())
        .containsExactly(ByteString.copyFromUtf8(""));
  }

  @Test
  public void testToProto() {
    SubsetView subsetView =
        SubsetView.create()
            .addRowPrefix("row1#")
            .addRowPrefix("row2#")
            .setFamilySubsets(
                "family1",
                FamilySubsets.create().addQualifier("column1").addQualifierPrefix("prefix1#"))
            .setFamilySubsets(
                "family1",
                FamilySubsets.create().addQualifier("column2").addQualifierPrefix("prefix2#"))
            .setFamilySubsets(
                "family2", FamilySubsets.create().addQualifier("column").addQualifierPrefix(""));

    com.google.bigtable.admin.v2.AuthorizedView.SubsetView subsetViewProto =
        com.google.bigtable.admin.v2.AuthorizedView.SubsetView.newBuilder()
            .addRowPrefixes(ByteString.copyFromUtf8("row1#"))
            .addRowPrefixes(ByteString.copyFromUtf8("row2#"))
            .putFamilySubsets(
                "family1",
                com.google.bigtable.admin.v2.AuthorizedView.FamilySubsets.newBuilder()
                    .addQualifiers(ByteString.copyFromUtf8("column2"))
                    .addQualifierPrefixes(ByteString.copyFromUtf8("prefix2#"))
                    .build())
            .putFamilySubsets(
                "family2",
                com.google.bigtable.admin.v2.AuthorizedView.FamilySubsets.newBuilder()
                    .addQualifiers(ByteString.copyFromUtf8("column"))
                    .addQualifierPrefixes(ByteString.copyFromUtf8(""))
                    .build())
            .build();

    assertThat(subsetView.getRowPrefixes())
        .containsExactly(ByteString.copyFromUtf8("row1#"), ByteString.copyFromUtf8("row2#"));
    Map<String, FamilySubsets> familySubsetsResult = subsetView.getFamilySubsets();
    assertThat(familySubsetsResult)
        .containsExactly(
            "family1",
            FamilySubsets.fromProto(subsetViewProto.getFamilySubsetsOrThrow("family1")),
            "family2",
            FamilySubsets.fromProto(subsetViewProto.getFamilySubsetsOrThrow("family2")));
    assertThat(familySubsetsResult.get("family1").getQualifiers())
        .containsExactly(ByteString.copyFromUtf8("column2"));
    assertThat(familySubsetsResult.get("family1").getQualifierPrefixes())
        .containsExactly(ByteString.copyFromUtf8("prefix2#"));
    assertThat(familySubsetsResult.get("family2").getQualifiers())
        .containsExactly(ByteString.copyFromUtf8("column"));
    assertThat(familySubsetsResult.get("family2").getQualifierPrefixes())
        .containsExactly(ByteString.copyFromUtf8(""));

    assertThat(subsetView.toProto()).isEqualTo(subsetViewProto);
  }

  @Test
  public void testEquality() {
    com.google.bigtable.admin.v2.AuthorizedView.SubsetView proto =
        com.google.bigtable.admin.v2.AuthorizedView.SubsetView.newBuilder()
            .addRowPrefixes(ByteString.copyFromUtf8("row1#"))
            .build();
    SubsetView subsetView = SubsetView.fromProto(proto);

    assertThat(subsetView).isEqualTo(SubsetView.fromProto(proto));
    assertThat(subsetView)
        .isNotEqualTo(
            SubsetView.fromProto(
                com.google.bigtable.admin.v2.AuthorizedView.SubsetView.newBuilder()
                    .addRowPrefixes(ByteString.copyFromUtf8("row2#"))
                    .build()));
  }

  @Test
  public void testHashCode() {
    com.google.bigtable.admin.v2.AuthorizedView.SubsetView proto =
        com.google.bigtable.admin.v2.AuthorizedView.SubsetView.newBuilder()
            .addRowPrefixes(ByteString.copyFromUtf8("row1#"))
            .build();
    SubsetView subsetView = SubsetView.fromProto(proto);

    assertThat(subsetView.hashCode()).isEqualTo(SubsetView.fromProto(proto).hashCode());
    assertThat(subsetView.hashCode())
        .isNotEqualTo(
            SubsetView.fromProto(
                    com.google.bigtable.admin.v2.AuthorizedView.SubsetView.newBuilder()
                        .addRowPrefixes(ByteString.copyFromUtf8("row2#"))
                        .build())
                .hashCode());
  }
}
