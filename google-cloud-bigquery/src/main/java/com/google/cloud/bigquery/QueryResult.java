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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.gax.paging.Page;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Iterables;
import java.io.Serializable;
import java.util.Objects;

public class QueryResult implements Page<FieldValueList>, Serializable {

  private static final long serialVersionUID = -4831062717210349819L;

  private final Schema schema;
  private final long totalRows;
  private final Page<FieldValueList> pageNoSchema;
  private final transient Function<FieldValueList, FieldValueList> addSchemaFunc;

  QueryResult(final Schema schema, long totalRows, Page<FieldValueList> pageNoSchema) {
    // TODO(pongad): read totalRows directly from listTableData.
    this.schema = checkNotNull(schema);
    this.totalRows = totalRows;
    this.pageNoSchema = checkNotNull(pageNoSchema);
    this.addSchemaFunc =
        new Function<FieldValueList, FieldValueList>() {
          @Override
          public FieldValueList apply(FieldValueList list) {
            return list.withSchema(schema.getFields());
          }
        };
  }

  /**
   * Returns the schema of the results. This is present only when the query completes successfully.
   */
  public Schema getSchema() {
    return schema;
  }

  /**
   * Returns the total number of rows in the complete query result set, which can be more than the
   * number of rows in the first page of results returned by {@link #getValues()}. Returns {@code 0}
   * if the query was a dry run.
   */
  public long getTotalRows() {
    return totalRows;
  }

  @Override
  public boolean hasNextPage() {
    return pageNoSchema.hasNextPage();
  }

  @Override
  public String getNextPageToken() {
    return pageNoSchema.getNextPageToken();
  }

  @Override
  public QueryResult getNextPage() {
    return new QueryResult(schema, totalRows, pageNoSchema.getNextPage());
  }

  @Override
  public Iterable<FieldValueList> iterateAll() {
    return Iterables.transform(pageNoSchema.iterateAll(), addSchemaFunc);
  }

  @Override
  public Iterable<FieldValueList> getValues() {
    return Iterables.transform(pageNoSchema.getValues(), addSchemaFunc);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("rows", getValues())
        .add("schema", schema)
        .add("totalRows", totalRows)
        .add("cursor", getNextPageToken())
        .toString();
  }

  @Override
  public final int hashCode() {
    return Objects.hash(super.hashCode(), schema, totalRows);
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(QueryResult.class)) {
      return false;
    }
    QueryResult response = (QueryResult) obj;
    return Objects.equals(getNextPageToken(), response.getNextPageToken())
        && Objects.equals(getValues(), response.getValues())
        && Objects.equals(schema, response.schema)
        && totalRows == response.totalRows;
  }
}
