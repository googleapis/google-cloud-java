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
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import java.util.List;
import javax.annotation.Nonnull;

/** Represents subsets of a particular column family that are included in this authorized view. */
public final class FamilySubsets {
  private final com.google.bigtable.admin.v2.AuthorizedView.FamilySubsets.Builder builder;

  /**
   * Wraps the protobuf. This method is considered an internal implementation detail and not meant
   * to be used by applications.
   */
  @InternalApi
  public static FamilySubsets fromProto(
      @Nonnull com.google.bigtable.admin.v2.AuthorizedView.FamilySubsets proto) {
    return new FamilySubsets(proto);
  }

  public static FamilySubsets create() {
    return new FamilySubsets();
  }

  private FamilySubsets(@Nonnull com.google.bigtable.admin.v2.AuthorizedView.FamilySubsets proto) {
    this.builder = proto.toBuilder();
  }

  private FamilySubsets() {
    this.builder = com.google.bigtable.admin.v2.AuthorizedView.FamilySubsets.newBuilder();
  }

  /** Gets the list of column qualifiers included in this authorized view. */
  public List<ByteString> getQualifiers() {
    return ImmutableList.copyOf(this.builder.getQualifiersList());
  }

  /** Gets the list of column qualifier prefixes included in this authorized view. */
  public List<ByteString> getQualifierPrefixes() {
    return ImmutableList.copyOf(this.builder.getQualifierPrefixesList());
  }

  /** Adds an individual column qualifier to be included in this authorized view. */
  public FamilySubsets addQualifier(ByteString qualifier) {
    this.builder.addQualifiers(qualifier);
    return this;
  }

  /** Adds an individual column qualifier to be included in this authorized view. */
  public FamilySubsets addQualifier(String qualifier) {
    this.builder.addQualifiers(ByteString.copyFromUtf8(qualifier));
    return this;
  }

  /**
   * Adds a prefix for column qualifiers to be included in this authorized view. Every qualifier
   * starting with the prefix will be included in this authorized view. An empty string ("") prefix
   * means to provide access to all qualifiers.
   */
  public FamilySubsets addQualifierPrefix(ByteString qualifierPrefix) {
    this.builder.addQualifierPrefixes(qualifierPrefix);
    return this;
  }

  /**
   * Adds a prefix for column qualifiers to be included in this authorized view. Every qualifier
   * starting with the prefix will be included in this authorized view. An empty string ("") prefix
   * means to provide access to all qualifiers.
   */
  public FamilySubsets addQualifierPrefix(String qualifierPrefix) {
    this.builder.addQualifierPrefixes(ByteString.copyFromUtf8(qualifierPrefix));
    return this;
  }

  /**
   * Creates the request protobuf. This method is considered an internal implementation detail and
   * not meant to be used by applications.
   */
  @InternalApi
  public com.google.bigtable.admin.v2.AuthorizedView.FamilySubsets toProto() {
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
    FamilySubsets that = (FamilySubsets) o;
    return Objects.equal(builder.build(), that.builder.build());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(builder.build());
  }
}
