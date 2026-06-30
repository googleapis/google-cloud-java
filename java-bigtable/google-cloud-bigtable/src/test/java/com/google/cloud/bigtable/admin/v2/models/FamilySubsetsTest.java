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

import com.google.bigtable.admin.v2.AuthorizedView;
import com.google.protobuf.ByteString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FamilySubsetsTest {

  @Test
  public void testFromProto() {
    AuthorizedView.FamilySubsets familySubsetsProto =
        com.google.bigtable.admin.v2.AuthorizedView.FamilySubsets.newBuilder()
            .addQualifiers(ByteString.copyFromUtf8("column1"))
            .addQualifiers(ByteString.copyFromUtf8("column2"))
            .addQualifierPrefixes(ByteString.copyFromUtf8("column3#"))
            .addQualifierPrefixes(ByteString.copyFromUtf8("column4#"))
            .build();

    FamilySubsets result = FamilySubsets.fromProto(familySubsetsProto);

    assertThat(result.getQualifiers())
        .containsExactly(ByteString.copyFromUtf8("column1"), ByteString.copyFromUtf8("column2"));
    assertThat(result.getQualifierPrefixes())
        .containsExactly(ByteString.copyFromUtf8("column3#"), ByteString.copyFromUtf8("column4#"));
  }

  @Test
  public void testEquality() {
    AuthorizedView.FamilySubsets proto =
        com.google.bigtable.admin.v2.AuthorizedView.FamilySubsets.newBuilder()
            .addQualifiers(ByteString.copyFromUtf8("column1"))
            .build();
    FamilySubsets familySubsets = FamilySubsets.fromProto(proto);

    assertThat(familySubsets).isEqualTo(FamilySubsets.fromProto(proto));
    assertThat(familySubsets)
        .isNotEqualTo(
            FamilySubsets.fromProto(
                com.google.bigtable.admin.v2.AuthorizedView.FamilySubsets.newBuilder()
                    .addQualifierPrefixes(ByteString.copyFromUtf8("column1"))
                    .build()));
  }

  @Test
  public void testHashCode() {
    AuthorizedView.FamilySubsets proto =
        com.google.bigtable.admin.v2.AuthorizedView.FamilySubsets.newBuilder()
            .addQualifiers(ByteString.copyFromUtf8("column1"))
            .build();
    FamilySubsets familySubsets = FamilySubsets.fromProto(proto);

    assertThat(familySubsets.hashCode()).isEqualTo(FamilySubsets.fromProto(proto).hashCode());
    assertThat(familySubsets.hashCode())
        .isNotEqualTo(
            FamilySubsets.fromProto(
                    com.google.bigtable.admin.v2.AuthorizedView.FamilySubsets.newBuilder()
                        .addQualifierPrefixes(ByteString.copyFromUtf8("column1"))
                        .build())
                .hashCode());
  }
}
