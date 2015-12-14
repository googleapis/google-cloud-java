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
import com.google.common.collect.ImmutableList;
import com.google.gcloud.PageImpl;

import java.util.List;
import java.util.Objects;

public class QueryResult extends PageImpl<List<FieldValue>> {

  private static final long serialVersionUID = -4831062717210349818L;

  private final boolean cacheHit;
  private final Schema schema;
  private final long totalRows;
  private final long totalBytesProcessed;

  interface QueryResultsPageFetcher extends PageImpl.NextPageFetcher<List<FieldValue>> {
    @Override
    QueryResult nextPage();
  }

  static final class Builder {

    private QueryResultsPageFetcher pageFetcher;
    private String cursor;
    private Iterable<List<FieldValue>> results;
    private boolean cacheHit;
    private Schema schema;
    private long totalRows;
    private long totalBytesProcessed;

    private Builder() {}

    Builder cacheHit(boolean cacheHit) {
      this.cacheHit = cacheHit;
      return this;
    }

    Builder schema(Schema schema) {
      this.schema = schema;
      return this;
    }

    Builder totalBytesProcessed(long totalBytesProcessed) {
      this.totalBytesProcessed = totalBytesProcessed;
      return this;
    }

    Builder totalRows(long totalRows) {
      this.totalRows = totalRows;
      return this;
    }

    Builder pageFetcher(QueryResultsPageFetcher pageFetcher) {
      this.pageFetcher = pageFetcher;
      return this;
    };

    Builder cursor(String cursor) {
      this.cursor = cursor;
      return this;
    };

    Builder results(Iterable<List<FieldValue>> results) {
      this.results = results;
      return this;
    };

    QueryResult build() {
      return new QueryResult(this);
    }
  }

  private QueryResult(Builder builder) {
    super(builder.pageFetcher, builder.cursor, builder.results != null ? builder.results
      : ImmutableList.<List<FieldValue>>of());
    this.cacheHit = builder.cacheHit;
    this.schema = builder.schema;
    this.totalBytesProcessed = builder.totalBytesProcessed;
    this.totalRows = builder.totalRows;
  }

  /**
   * Returns whether the query result was fetched from the query cache.
   *
   * @see <a href="https://cloud.google.com/bigquery/querying-data#querycaching">Query Caching</a>
   */
  public boolean cacheHit() {
    return cacheHit;
  }

  /**
   * Returns the schema of the results.
   */
  public Schema schema() {
    return schema;
  }

  /**
   * Returns the total number of bytes processed for the query. If this query was a dry run, this is
   * the number of bytes that would be processed if the query were run.
   */
  public long totalBytesProcessed() {
    return totalBytesProcessed;
  }

  /**
   * Returns the total number of rows in the complete query result set, which can be more than the
   * number of rows in the first page of results returned by {@link #values()}. Returns {@code 0}
   * if the query was a dry run.
   */
  public long totalRows() {
    return totalRows;
  }

  @Override
  public QueryResult nextPage() {
    return (QueryResult) super.nextPage();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("rows", values())
        .add("cacheHit", cacheHit)
        .add("schema", schema)
        .add("totalBytesProcessed", totalBytesProcessed)
        .add("totalRows", totalRows)
        .add("cursor", nextPageCursor())
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), cacheHit, schema, totalBytesProcessed, totalRows);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    QueryResult response = (QueryResult) obj;
    return Objects.equals(nextPageCursor(), response.nextPageCursor())
        && Objects.equals(values(), response.values())
        && Objects.equals(schema, response.schema)
        && totalRows == response.totalRows
        && totalBytesProcessed == response.totalBytesProcessed
        && cacheHit == response.cacheHit;
  }

  static Builder builder() {
    return new Builder();
  }
}
