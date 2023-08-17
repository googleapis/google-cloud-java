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

import com.google.api.services.bigquery.model.SearchStatistics;
import com.google.auto.value.AutoValue;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

/** Represents Search statistics information of a search query. */
@AutoValue
public abstract class SearchStats implements Serializable {

  @AutoValue.Builder
  public abstract static class Builder {

    /**
     * Specifies index usage mode for the query.
     *
     * @param indexUsageMode, has three modes UNUSED, PARTIALLY_USED, and FULLY_USED
     */
    public abstract Builder setIndexUsageMode(String indexUsageMode);

    /**
     * When index_usage_mode is UNUSED or PARTIALLY_USED, this field explains why index was not used
     * in all or part of the search query. If index_usage_mode is FULLY_USED, this field is not
     * populated.
     *
     * @param indexUnusedReasons
     */
    public abstract Builder setIndexUnusedReasons(List<IndexUnusedReason> indexUnusedReasons);

    /** Creates a @code SearchStats} object. */
    public abstract SearchStats build();
  }

  public abstract Builder toBuilder();

  public static Builder newBuilder() {
    return new AutoValue_SearchStats.Builder();
  }

  @Nullable
  public abstract String getIndexUsageMode();

  @Nullable
  public abstract List<IndexUnusedReason> getIndexUnusedReasons();

  SearchStatistics toPb() {
    SearchStatistics searchStatistics = new SearchStatistics();
    if (getIndexUsageMode() != null) {
      searchStatistics.setIndexUsageMode(getIndexUsageMode());
    }
    if (getIndexUnusedReasons() != null) {
      searchStatistics.setIndexUnusedReasons(
          getIndexUnusedReasons().stream()
              .map(IndexUnusedReason::toPb)
              .collect(Collectors.toList()));
    }
    return searchStatistics;
  }

  static SearchStats fromPb(SearchStatistics searchStatistics) {
    Builder builder = newBuilder();
    if (searchStatistics.getIndexUsageMode() != null) {
      builder.setIndexUsageMode(searchStatistics.getIndexUsageMode());
    }
    if (searchStatistics.getIndexUnusedReasons() != null) {
      builder.setIndexUnusedReasons(
          searchStatistics.getIndexUnusedReasons().stream()
              .map(IndexUnusedReason::fromPb)
              .collect(Collectors.toList()));
    }
    return builder.build();
  }
}
