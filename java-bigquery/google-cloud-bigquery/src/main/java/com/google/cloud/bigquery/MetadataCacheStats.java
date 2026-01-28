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

import com.google.api.services.bigquery.model.MetadataCacheStatistics;
import com.google.auto.value.AutoValue;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

/**
 * Represents statistics for metadata caching in BigLake tables.
 *
 * @see <a href="https://cloud.google.com/bigquery/docs/biglake-intro">BigLake Tables</a>
 */
@AutoValue
public abstract class MetadataCacheStats implements Serializable {

  private static final long serialVersionUID = 1L;

  @AutoValue.Builder
  public abstract static class Builder {
    /** Sets the free form human-readable reason metadata caching was unused for the job. */
    public abstract MetadataCacheStats.Builder setTableMetadataCacheUsage(
        List<TableMetadataCacheUsage> tableMetadataCacheUsage);

    /** Creates a @code MetadataCacheStats} object. */
    public abstract MetadataCacheStats build();
  }

  public abstract Builder toBuilder();

  public static Builder newBuilder() {
    return new AutoValue_MetadataCacheStats.Builder();
  }

  @Nullable
  public abstract List<TableMetadataCacheUsage> getTableMetadataCacheUsage();

  MetadataCacheStatistics toPb() {
    MetadataCacheStatistics metadataCacheStatistics = new MetadataCacheStatistics();
    if (getTableMetadataCacheUsage() != null) {
      metadataCacheStatistics.setTableMetadataCacheUsage(
          getTableMetadataCacheUsage().stream()
              .map(TableMetadataCacheUsage::toPb)
              .collect(Collectors.toList()));
    }
    return metadataCacheStatistics;
  }

  static MetadataCacheStats fromPb(MetadataCacheStatistics metadataCacheStatistics) {
    Builder builder = newBuilder();
    if (metadataCacheStatistics.getTableMetadataCacheUsage() != null) {
      builder.setTableMetadataCacheUsage(
          metadataCacheStatistics.getTableMetadataCacheUsage().stream()
              .map(TableMetadataCacheUsage::fromPb)
              .collect(Collectors.toList()));
    }
    return builder.build();
  }
}
