/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.jdbc;

import com.google.cloud.spanner.ReadContext.QueryAnalyzeMode;

/**
 * {@link AnalyzeMode} indicates whether a query should be executed as a normal query (NONE),
 * whether only a query plan should be returned, or whether the query should be profiled while
 * executed.
 */
enum AnalyzeMode {
  NONE(null),
  PLAN(QueryAnalyzeMode.PLAN),
  PROFILE(QueryAnalyzeMode.PROFILE);

  private final QueryAnalyzeMode mode;

  private AnalyzeMode(QueryAnalyzeMode mode) {
    this.mode = mode;
  }

  QueryAnalyzeMode getQueryAnalyzeMode() {
    return mode;
  }

  /** Translates from the Spanner client library QueryAnalyzeMode to {@link AnalyzeMode}. */
  static AnalyzeMode of(QueryAnalyzeMode mode) {
    switch (mode) {
      case PLAN:
        return AnalyzeMode.PLAN;
      case PROFILE:
        return AnalyzeMode.PROFILE;
      default:
        throw new IllegalArgumentException(mode + " is unknown");
    }
  }
}
