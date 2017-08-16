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

package com.google.cloud.bigquery;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Google Cloud BigQuery Query Response. This class contains the results of a Query Job
 * ({@link BigQuery#getQueryResults(JobId, BigQuery.QueryResultsOption...)}) or of a
 * Query Request ({@link BigQuery#query(QueryRequest)}).
 *
 * <p>Example usage of a query response:
 * <pre> {@code
 * QueryResponse response = bigquery.query(request);
 * while (!response.jobCompleted()) {
 *   Thread.sleep(1000);
 *   response = bigquery.getQueryResults(response.getJobId());
 * }
 * List<BigQueryError> executionErrors = response.getExecutionErrors();
 * // look for errors in executionErrors
 * QueryResult result = response.getResult();
 * Iterator<List<FieldValue>> rowIterator = result.iterateAll();
 * while(rowIterator.hasNext()) {
 *   List<FieldValue> row = rowIterator.next();
 *   // do something with row
 * }
 * }</pre>
 *
 * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs/getQueryResults">Get Query
 *     Results</a>
 * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs/query">Query</a>
 */
public class QueryResponse implements Serializable {

  private static final long serialVersionUID = 3549226764825005655L;

  private final QueryResult result;
  private final String etag;
  private final JobId jobId;
  private final Long numDmlAffectedRows;
  private final boolean jobCompleted;
  private final List<BigQueryError> executionErrors;

  static final class Builder {

    private QueryResult result;
    private String etag;
    private JobId jobId;
    private Long numDmlAffectedRows;
    private boolean jobCompleted;
    private List<BigQueryError> executionErrors;

    private Builder() {}

    Builder setResult(QueryResult result) {
      this.result = result;
      return this;
    }

    Builder setEtag(String etag) {
      this.etag = etag;
      return this;
    }

    Builder setJobId(JobId jobId) {
      this.jobId = jobId;
      return this;
    }

    Builder setNumDmlAffectedRows(Long numDmlAffectedRows) {
      this.numDmlAffectedRows = numDmlAffectedRows;
      return this;
    }

    Builder setJobCompleted(boolean jobCompleted) {
      this.jobCompleted = jobCompleted;
      return this;
    }

    Builder setExecutionErrors(List<BigQueryError> executionErrors) {
      this.executionErrors = executionErrors;
      return this;
    }

    QueryResponse build() {
      return new QueryResponse(this);
    }
  }

  private QueryResponse(Builder builder) {
    this.result = builder.result;
    this.etag = builder.etag;
    this.jobId = builder.jobId;
    this.numDmlAffectedRows = builder.numDmlAffectedRows;
    this.jobCompleted = builder.jobCompleted;
    this.executionErrors = builder.executionErrors != null ? builder.executionErrors
      : ImmutableList.<BigQueryError>of();
  }


  /**
   * Returns the result of the query. Returns {@code null} if {@link #jobCompleted()} is {@code
   * false}.
   */
  public QueryResult getResult() {
    return result;
  }


  /**
   * Returns the hash of the {@code QueryResponse} resource or {@code null} if not set.
   */
  public String getEtag() {
    return etag;
  }


  /**
   * Returns the identity of the BigQuery Job that was created to run the query. This field will be
   * present even if the original request timed out.
   */
  public JobId getJobId() {
    return jobId;
  }

  /**
   * Returns the number of rows affected by a DML statement. Present only for DML statements INSERT,
   * UPDATE or DELETE.
   */
  public Long getNumDmlAffectedRows() { return numDmlAffectedRows; }

  /**
   * Returns whether the job running the query has completed or not. If {@link #getResult()} is not
   * {@code null}, this method will always return {@code true}. If this method returns {@code false}
   * {@link #getResult()} returns {@code null}. This method can be used to check if query execution
   * completed and results are available.
   */
  public boolean jobCompleted() {
    return jobCompleted;
  }

  /**
   * Returns whether errors and warnings occurred during the execution of the job. If this method
   * returns {@code true} it does not necessarily mean that the job has completed or was
   * unsuccessful.
   */
  public boolean hasErrors() {
    return !executionErrors.isEmpty();
  }


  /**
   * Returns errors and warnings encountered during the running of the job, if any. Errors here do
   * not necessarily mean that the job has completed or was unsuccessful.
   */
  public List<BigQueryError> getExecutionErrors() {
    return executionErrors;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("result", result)
        .add("etag", etag)
        .add("jobId", jobId)
        .add("numDmlAffectedRows", numDmlAffectedRows)
        .add("jobCompleted", jobCompleted)
        .add("executionErrors", executionErrors)
        .toString();
  }

  @Override
  public final int hashCode() {
    return Objects.hash(result, etag, jobId, numDmlAffectedRows, jobCompleted, executionErrors);
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(QueryResponse.class)) {
      return false;
    }
    QueryResponse response = (QueryResponse) obj;
    return jobCompleted == response.jobCompleted
        && Objects.equals(etag, response.etag)
        && Objects.equals(result, response.result)
        && Objects.equals(jobId, response.jobId)
        && Objects.equals(numDmlAffectedRows, response.numDmlAffectedRows)
        && Objects.equals(executionErrors, response.executionErrors);
  }

  static Builder newBuilder() {
    return new Builder();
  }
}
