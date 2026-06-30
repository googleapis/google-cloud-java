/*
 * Copyright 2021 Google LLC
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

import com.google.cloud.bigquery.JobStatistics.QueryStatistics;
import com.google.cloud.bigquery.JobStatistics.SessionInfo;

public class BigQueryResultStatsImpl implements BigQueryResultStats {

  private final QueryStatistics queryStatistics;
  private final SessionInfo sessionInfo;

  public BigQueryResultStatsImpl(QueryStatistics queryStatistics, SessionInfo sessionInfo) {
    this.queryStatistics = queryStatistics;
    this.sessionInfo = sessionInfo;
  }

  @Override
  public QueryStatistics getQueryStatistics() {
    return queryStatistics;
  }

  @Override
  public SessionInfo getSessionInfo() {
    return sessionInfo;
  }
}
