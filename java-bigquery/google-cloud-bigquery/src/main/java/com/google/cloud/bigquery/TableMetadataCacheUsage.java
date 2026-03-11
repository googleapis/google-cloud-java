/*
 * Copyright 2024 Google LLC
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

/** Represents Table level detail on the usage of metadata caching. */
@AutoValue
public abstract class TableMetadataCacheUsage implements Serializable {

  private static final long serialVersionUID = 1L;

  /** Reason for not using metadata caching for the table. */
  public enum UnusedReason {
    /** Unused reasons not specified. */
    UNUSED_REASON_UNSPECIFIED,

    /** Metadata cache was outside the table's maxStaleness. */
    EXCEEDED_MAX_STALENESS,

    /**
     * Metadata caching feature is not enabled. Update BigLake tables to enable the metadata
     * caching.
     */
    METADATA_CACHING_NOT_ENABLED,

    /** Other unknown reason. */
    OTHER_REASON
  }

  @AutoValue.Builder
  public abstract static class Builder {
    /** Sets the free form human-readable reason metadata caching was unused for the job. */
    public abstract TableMetadataCacheUsage.Builder setExplanation(String explanation);

    /** Sets the metadata caching eligible table referenced in the query. */
    public abstract TableMetadataCacheUsage.Builder setTableReference(TableId tableReference);

    /** Sets the table type. */
    public abstract TableMetadataCacheUsage.Builder setTableType(String tableType);

    /** Sets reason for not using metadata caching for the table. */
    public abstract TableMetadataCacheUsage.Builder setUnusedReason(UnusedReason unusedReason);

    /** Creates a @code TableMetadataCacheUsage} object. */
    public abstract TableMetadataCacheUsage build();
  }

  public abstract Builder toBuilder();

  public static Builder newBuilder() {
    return new AutoValue_TableMetadataCacheUsage.Builder();
  }

  @Nullable
  public abstract String getExplanation();

  @Nullable
  public abstract TableId getTableReference();

  @Nullable
  public abstract String getTableType();

  @Nullable
  public abstract UnusedReason getUnusedReason();

  com.google.api.services.bigquery.model.TableMetadataCacheUsage toPb() {
    com.google.api.services.bigquery.model.TableMetadataCacheUsage tableMetadataCacheUsage =
        new com.google.api.services.bigquery.model.TableMetadataCacheUsage();
    if (getExplanation() != null) {
      tableMetadataCacheUsage.setExplanation(getExplanation());
    }
    if (getTableReference() != null) {
      tableMetadataCacheUsage.setTableReference(getTableReference().toPb());
    }
    if (getTableType() != null) {
      tableMetadataCacheUsage.setTableType(getTableType());
    }
    if (getUnusedReason() != null) {
      tableMetadataCacheUsage.setUnusedReason(getUnusedReason().toString());
    }
    return tableMetadataCacheUsage;
  }

  static TableMetadataCacheUsage fromPb(
      com.google.api.services.bigquery.model.TableMetadataCacheUsage tableMetadataCacheUsage) {
    Builder builder = newBuilder();
    if (tableMetadataCacheUsage.getExplanation() != null) {
      builder.setExplanation(tableMetadataCacheUsage.getExplanation());
    }
    if (tableMetadataCacheUsage.getTableReference() != null) {
      builder.setTableReference(TableId.fromPb(tableMetadataCacheUsage.getTableReference()));
    }
    if (tableMetadataCacheUsage.getTableType() != null) {
      builder.setTableType(tableMetadataCacheUsage.getTableType());
    }
    if (tableMetadataCacheUsage.getUnusedReason() != null) {
      builder.setUnusedReason(UnusedReason.valueOf(tableMetadataCacheUsage.getUnusedReason()));
    }
    return builder.build();
  }
}
