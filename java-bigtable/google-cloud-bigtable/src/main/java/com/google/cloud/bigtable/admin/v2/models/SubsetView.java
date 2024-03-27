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

import com.google.api.core.InternalApi;
import com.google.cloud.bigtable.admin.v2.models.AuthorizedView.AuthorizedViewType;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nonnull;

/**
 * Defines a simple authorized view that is a subset of the underlying Table.
 *
 * <p>Users can specify the rows in the form of row key prefixes, and specify the column families by
 * adding the family id along with its familySubsets rule to the family subsets map. The subset is
 * defined by the intersection of the specified row key prefixes and column family subsets.
 */
public class SubsetView implements AuthorizedViewType {
  private final com.google.bigtable.admin.v2.AuthorizedView.SubsetView.Builder builder;

  /**
   * Wraps the protobuf. This method is considered an internal implementation detail and not meant
   * to be used by applications.
   */
  @InternalApi
  public static SubsetView fromProto(
      @Nonnull com.google.bigtable.admin.v2.AuthorizedView.SubsetView proto) {
    return new SubsetView(proto);
  }

  public static SubsetView create() {
    return new SubsetView();
  }

  private SubsetView(@Nonnull com.google.bigtable.admin.v2.AuthorizedView.SubsetView proto) {
    this.builder = proto.toBuilder();
  }

  private SubsetView() {
    this.builder = com.google.bigtable.admin.v2.AuthorizedView.SubsetView.newBuilder();
  }

  /** Gets the row prefixes to be included in this subset view. */
  public List<ByteString> getRowPrefixes() {
    return ImmutableList.copyOf(this.builder.getRowPrefixesList());
  }

  /** Gets the map from familyId to familySubsets in this subset view. */
  public Map<String, FamilySubsets> getFamilySubsets() {
    ImmutableMap.Builder<String, FamilySubsets> familySubsets = ImmutableMap.builder();
    for (Entry<String, com.google.bigtable.admin.v2.AuthorizedView.FamilySubsets> entry :
        builder.getFamilySubsetsMap().entrySet()) {
      familySubsets.put(entry.getKey(), FamilySubsets.fromProto(entry.getValue()));
    }
    return familySubsets.build();
  }

  /** Adds a new rowPrefix to the subset view. */
  public SubsetView addRowPrefix(ByteString rowPrefix) {
    this.builder.addRowPrefixes(rowPrefix);
    return this;
  }

  /** Adds a new rowPrefix to the subset view. */
  public SubsetView addRowPrefix(String rowPrefix) {
    this.builder.addRowPrefixes(ByteString.copyFromUtf8(rowPrefix));
    return this;
  }

  /**
   * Adds a new familyId with its familySubsets to the subset view. Please note that calling this
   * method with the same familyId will overwrite the previous rule set on the family.
   */
  public SubsetView setFamilySubsets(String familyId, FamilySubsets familySubsets) {
    this.builder.putFamilySubsets(familyId, familySubsets.toProto());
    return this;
  }

  /**
   * Creates the request protobuf. This method is considered an internal implementation detail and
   * not meant to be used by applications.
   */
  @InternalApi
  public com.google.bigtable.admin.v2.AuthorizedView.SubsetView toProto() {
    return builder.build();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubsetView that = (SubsetView) o;
    return Objects.equal(builder.build(), that.builder.build());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(builder.build());
  }
}
