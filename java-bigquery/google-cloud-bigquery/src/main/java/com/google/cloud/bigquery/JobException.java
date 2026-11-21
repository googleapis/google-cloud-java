/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery;

import com.google.common.collect.ImmutableList;
import java.util.List;

/**
 * Exception describing a failure of a job.
 *
 * <p>Although {@link BigQuery#query(QueryJobConfiguration, BigQuery.JobOption...)}, {@link
 * BigQuery#queryArrow(QueryJobConfiguration, BigQuery.JobOption...)}, {@link
 * BigQuery#queryWithTimeout(QueryJobConfiguration, JobId, Long, BigQuery.JobOption...)}, and {@link
 * Job#getQueryResults(BigQuery.QueryResultsOption...)} declare {@code JobException} in their {@code
 * throws} clauses for backwards compatibility, this exception is never thrown by current client
 * implementations, which report failed jobs by throwing {@link BigQueryException} instead. Callers
 * should catch {@link BigQueryException} and inspect {@link BigQueryException#getError()} or {@link
 * BigQueryException#getErrors()} to handle job failures.
 */
public class JobException extends RuntimeException {
  private final JobId id;
  private final ImmutableList<BigQueryError> errors;

  JobException(JobId id, ImmutableList<BigQueryError> errors) {
    super(String.format("job %s failed with error: %s", id, errors));
    this.id = id;
    this.errors = errors;
  }

  /** The ID for the failed job. */
  public JobId getId() {
    return id;
  }

  /**
   * The errors reported by the job.
   *
   * <p>The list is immutable.
   */
  public List<BigQueryError> getErrors() {
    return errors;
  }
}
