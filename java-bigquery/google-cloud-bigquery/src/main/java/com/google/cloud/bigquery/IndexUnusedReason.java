/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery;

import com.google.auto.value.AutoValue;
import java.io.Serializable;
import javax.annotation.Nullable;

/** Represents Reason of why the index was not used in a SQL search. */
@AutoValue
public abstract class IndexUnusedReason implements Serializable {

  @AutoValue.Builder
  public abstract static class Builder {

    /**
     * Specifies the name of the unused search index, if available.
     *
     * @param indexName indexName or {@code null} for none
     */
    public abstract Builder setIndexName(String indexName);

    /**
     * Specifies the high-level reason for the scenario when no search index was used.
     *
     * @param code code or {@code null} for none
     */
    public abstract Builder setCode(String code);

    /**
     * Free form human-readable reason for the scenario when no search index was used.
     *
     * @param message message or {@code null} for none
     */
    public abstract Builder setMessage(String message);

    /**
     * Specifies the base table involved in the reason that no search index was used.
     *
     * @param baseTable baseTable or {@code null} for none
     */
    public abstract Builder setBaseTableId(TableId baseTable);

    /** Creates a @code IndexUnusedReason} object. */
    public abstract IndexUnusedReason build();
  }

  public abstract Builder toBuilder();

  public static Builder newBuilder() {
    return new AutoValue_IndexUnusedReason.Builder();
  }

  /**
   * Returns the name of the unused search index, if available.
   *
   * @return value or {@code null} for none
   */
  @Nullable
  public abstract String getIndexName();

  /**
   * Returns the high-level reason for the scenario when no search index was used.
   *
   * @return value or {@code null} for none
   */
  @Nullable
  public abstract String getCode();

  /**
   * Returns free form human-readable reason for the scenario when no search index was used.
   *
   * @return value or {@code null} for none
   */
  @Nullable
  public abstract String getMessage();

  /**
   * Returns the base table involved in the reason that no search index was used.
   *
   * @return value or {@code null} for none
   */
  @Nullable
  public abstract TableId getBaseTableId();

  com.google.api.services.bigquery.model.IndexUnusedReason toPb() {
    com.google.api.services.bigquery.model.IndexUnusedReason indexUnusedReason =
        new com.google.api.services.bigquery.model.IndexUnusedReason();
    if (getIndexName() != null) {
      indexUnusedReason.setIndexName(indexUnusedReason.getIndexName());
    }
    if (getCode() != null) {
      indexUnusedReason.setCode(indexUnusedReason.getCode());
    }
    if (getMessage() != null) {
      indexUnusedReason.setMessage(indexUnusedReason.getMessage());
    }
    if (getBaseTableId() != null) {
      indexUnusedReason.setBaseTable(getBaseTableId().toPb());
    }
    return indexUnusedReason;
  }

  static IndexUnusedReason fromPb(
      com.google.api.services.bigquery.model.IndexUnusedReason indexUnusedReason) {
    Builder builder = newBuilder();
    if (indexUnusedReason.getIndexName() != null) {
      builder.setIndexName(indexUnusedReason.getIndexName());
    }
    if (indexUnusedReason.getCode() != null) {
      builder.setCode(indexUnusedReason.getCode());
    }
    if (indexUnusedReason.getMessage() != null) {
      builder.setMessage(indexUnusedReason.getMessage());
    }
    if (indexUnusedReason.getBaseTable() != null) {
      builder.setBaseTableId(TableId.fromPb(indexUnusedReason.getBaseTable()));
    }
    return builder.build();
  }
}
