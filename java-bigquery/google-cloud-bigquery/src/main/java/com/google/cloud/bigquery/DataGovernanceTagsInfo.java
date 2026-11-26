/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery;

import com.google.api.client.util.Data;
import com.google.api.services.bigquery.model.TableFieldSchema;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.util.Map;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Represents data governance tags attached to a BigQuery table schema {@link Field} for
 * column-level access control and dynamic data masking.
 *
 * <p>This wrapper distinguishes an unset field ({@code null} on {@link Field}, which preserves
 * existing column tags during a {@code Tables.patch} request) from an empty wrapper (for example,
 * {@code DataGovernanceTagsInfo.newBuilder().build()}, which serializes as an empty object to clear
 * existing tags from the column).
 *
 * @see <a href="https://cloud.google.com/bigquery/docs/tags#data-governance-tags">Control access to
 *     columns with data governance tags</a>
 */
@AutoValue
@NullMarked
public abstract class DataGovernanceTagsInfo implements Serializable {

  private static final long serialVersionUID = 1L;

  abstract ImmutableMap<String, String> getDataGovernanceTagsImmut();

  /**
   * Returns the data governance tags attached to the field, keyed by namespaced tag key (for
   * example, {@code "myProject/pii"}) and mapped to the tag value short name (for example, {@code
   * "sensitive"}). Returns an empty map when representing an empty {@code DataGovernanceTagsInfo}
   * object used to clear existing column tags.
   *
   * @return immutable map of data governance tag keys to values
   */
  public Map<String, String> getDataGovernanceTags() {
    return getDataGovernanceTagsImmut();
  }

  /** Returns a builder pre-populated with the contents of this {@code DataGovernanceTagsInfo}. */
  public abstract Builder toBuilder();

  /** Builder for {@code DataGovernanceTagsInfo}. */
  @AutoValue.Builder
  public abstract static class Builder {

    abstract Builder setDataGovernanceTagsImmut(
        ImmutableMap<String, String> dataGovernanceTagsImmut);

    /**
     * Sets the data governance tags map for the field. Pass an empty map (or build directly from
     * {@link #newBuilder()}) to clear existing data governance tags from a column during a {@code
     * Tables.patch} schema update.
     *
     * @param dataGovernanceTags non-null map of namespaced tag keys to tag value short names
     * @return this builder
     */
    public Builder setDataGovernanceTags(Map<String, String> dataGovernanceTags) {
      return setDataGovernanceTagsImmut(ImmutableMap.copyOf(dataGovernanceTags));
    }

    /** Creates a {@code DataGovernanceTagsInfo} object. */
    public abstract DataGovernanceTagsInfo build();
  }

  /**
   * Returns a new builder initialized with an empty data governance tags map. Building without
   * setting tags produces an empty {@code DataGovernanceTagsInfo} object, which clears existing
   * tags on a column when sent in a {@code Tables.patch} request.
   *
   * @return a new {@code Builder}
   */
  public static Builder newBuilder() {
    return new AutoValue_DataGovernanceTagsInfo.Builder()
        .setDataGovernanceTagsImmut(ImmutableMap.of());
  }

  /**
   * Creates a {@code DataGovernanceTagsInfo} containing the given data governance tags map.
   *
   * @param dataGovernanceTags non-null map of namespaced tag keys to tag value short names
   * @return a {@code DataGovernanceTagsInfo} instance
   */
  public static DataGovernanceTagsInfo of(Map<String, String> dataGovernanceTags) {
    return newBuilder().setDataGovernanceTags(dataGovernanceTags).build();
  }

  /**
   * Converts this instance to the underlying REST API {@link
   * TableFieldSchema.DataGovernanceTagsInfo} model. Omits the inner map when empty so JSON
   * serialization emits {@code "dataGovernanceTagsInfo": {}} for clearing column tags on patch.
   */
  TableFieldSchema.DataGovernanceTagsInfo toPb() {
    TableFieldSchema.DataGovernanceTagsInfo tagInfoPb =
        new TableFieldSchema.DataGovernanceTagsInfo();
    if (!getDataGovernanceTags().isEmpty()) {
      tagInfoPb.setDataGovernanceTags(getDataGovernanceTags());
    }
    return tagInfoPb;
  }

  /**
   * Creates a {@code DataGovernanceTagsInfo} from the underlying REST API {@link
   * TableFieldSchema.DataGovernanceTagsInfo} model, or returns {@code null} if {@code tagInfoPb} is
   * {@code null} or JSON null.
   */
  static @Nullable DataGovernanceTagsInfo fromPb(
      TableFieldSchema.@Nullable DataGovernanceTagsInfo tagInfoPb) {
    if (tagInfoPb == null || Data.isNull(tagInfoPb)) {
      return null;
    }
    Builder builder = newBuilder();
    if (tagInfoPb.getDataGovernanceTags() != null
        && !Data.isNull(tagInfoPb.getDataGovernanceTags())) {
      builder.setDataGovernanceTags(tagInfoPb.getDataGovernanceTags());
    }
    return builder.build();
  }
}
