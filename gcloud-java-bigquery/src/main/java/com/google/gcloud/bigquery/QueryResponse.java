/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.bigquery;

import com.google.common.base.MoreObjects;
import com.google.gcloud.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Google Cloud BigQuery Query Response. This class contains the results of a Query Job or of a
 * Query Request.
 *
 * <p>Example usage of a query response:
 * <pre>    {@code
 *    QueryResponse response = bigquery.query(request);
 *    while (!response.jobComplete()) {
 *      response = bigquery.getQueryResults(response.job());
 *      Thread.sleep(1000);
 *    }
 *    List<BigQueryError> executionErrors = response.executionErrors();
 *    Page<List<FieldValue>> rows = response.rows();
 * }</pre>
 *
 * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs/getQueryResults">Get Query
 *     Results</a>
 * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs/query">Query</a>
 */
public class QueryResponse implements Serializable {

  private static final long serialVersionUID = 3549226764825005655L;

  private final String etag;
  private final Schema schema;
  private final JobId job;
  private final Long totalRows;
  private final Page<List<FieldValue>> rows;
  private final Long totalBytesProcessed;
  private final boolean jobComplete;
  private final List<BigQueryError> executionErrors;
  private final Boolean cacheHit;

  static final class Builder {

    private String etag;
    private Schema schema;
    private JobId job;
    private Long totalRows;
    private Page<List<FieldValue>> rows;
    private Long totalBytesProcessed;
    private boolean jobComplete;
    private List<BigQueryError> executionErrors;
    private Boolean cacheHit;

    private Builder() {}

    Builder etag(String etag) {
      this.etag = etag;
      return this;
    }

    Builder schema(Schema schema) {
      this.schema = schema;
      return this;
    }

    Builder job(JobId job) {
      this.job = job;
      return this;
    }

    Builder totalRows(Long totalRows) {
      this.totalRows = totalRows;
      return this;
    }

    Builder rows(Page<List<FieldValue>> rows) {
      this.rows = rows;
      return this;
    }

    Builder totalBytesProcessed(Long totalBytesProcessed) {
      this.totalBytesProcessed = totalBytesProcessed;
      return this;
    }

    Builder jobComplete(boolean jobComplete) {
      this.jobComplete = jobComplete;
      return this;
    }

    Builder executionErrors(List<BigQueryError> executionErrors) {
      this.executionErrors = executionErrors;
      return this;
    }

    Builder cacheHit(Boolean cacheHit) {
      this.cacheHit = cacheHit;
      return this;
    }

    QueryResponse build() {
      return new QueryResponse(this);
    }
  }

  private QueryResponse(Builder builder) {
    this.etag = builder.etag;
    this.schema = builder.schema;
    this.job = builder.job;
    this.totalRows = builder.totalRows;
    this.rows = builder.rows;
    this.totalBytesProcessed = builder.totalBytesProcessed;
    this.jobComplete = builder.jobComplete;
    this.executionErrors = builder.executionErrors;
    this.cacheHit = builder.cacheHit;
  }

  /**
   * Returns the hash of the {@code QueryResponse} resource or {@code null} if not set.
   */
  public String etag() {
    return etag;
  }

  /**
   * Returns the schema of the results if the query completed successfully. Returns {@code null}
   * otherwise.
   */
  public Schema schema() {
    return schema;
  }

  /**
   * Returns the identity of the BigQuery Job that was created to run the query. This field will be
   * present even if the original request timed out.
   */
  public JobId job() {
    return job;
  }

  /**
   * Returns the total number of rows in the complete query result set, which can be more than the
   * number of rows in the first page of results returned by {@link #rows()}. Returns {@code null}
   * if the query did not complete successfully.
   */
  public Long totalRows() {
    return totalRows;
  }

  /**
   * Returns the query result as a paginated list of rows, if the query completed successfully.
   * Returns {@code null} otherwise.
   */
  public Page<List<FieldValue>> rows() {
    return rows;
  }

  /**
   * Returns the total number of bytes processed for the query. If this query was a dry run, this is
   * the number of bytes that would be processed if the query were run. Returns {@code null}
   * if the query did not complete.
   */
  public Long totalBytesProcessed() {
    return totalBytesProcessed;
  }

  /**
   * Returns whether the job running the query has completed or not. If {@link #rows()} and
   * {@link #totalRows()} are not {@code null}, this method will always return {@code true}. If this
   * method returns {@code false} {@link #totalRows()} and {@link #rows()} return {@code null}. This
   * method can be used to check if query execution completed and results are available.
   */
  public boolean jobComplete() {
    return jobComplete;
  }

  /**
   * Returns errors and warnings encountered during the running of the job, if any. Errors here do
   * not necessarily mean that the job has completed or was unsuccessful.
   */
  public List<BigQueryError> executionErrors() {
    return executionErrors;
  }

  /**
   * Returns whether the query result was fetched from the query cache.
   *
   * @see <a href="https://cloud.google.com/bigquery/querying-data#querycaching">Query Caching</a>
   */
  public Boolean cacheHit() {
    return cacheHit;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("job", job)
        .add("jobComplete", jobComplete)
        .add("totalRows", totalRows)
        .add("schema", schema)
        .add("totalBytesProcessed", totalBytesProcessed)
        .add("executionErrors", executionErrors)
        .add("cacheHit", cacheHit)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(job);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    QueryResponse response = (QueryResponse) obj;
    return jobComplete == response.jobComplete
        && Objects.equals(schema, response.schema)
        && Objects.equals(job, response.job)
        && Objects.equals(totalRows, response.totalRows)
        && Objects.equals(rows, response.rows)
        && Objects.equals(totalBytesProcessed, response.totalBytesProcessed)
        && Objects.equals(executionErrors, response.executionErrors)
        && Objects.equals(cacheHit, response.cacheHit);
  }

  static Builder builder() {
    return new Builder();
  }
}
