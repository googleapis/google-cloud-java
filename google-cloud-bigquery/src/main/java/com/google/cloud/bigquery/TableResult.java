/*
 * Copyright 2018 Google LLC All rights reserved.
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
import com.google.common.collect.Iterators;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.Nullable;

public class TableResult implements Page<FieldValueList>, Serializable {

  private static final long serialVersionUID = -4831062717210349819L;

  @Nullable private final Schema schema;
  private final long totalRows;
  private final Page<FieldValueList> pageNoSchema;

  TableResult(Schema schema, long totalRows, Page<FieldValueList> pageNoSchema) {
    this.schema = schema;
    this.totalRows = totalRows;
    this.pageNoSchema = checkNotNull(pageNoSchema);
  }

  /** Returns the schema of the results. Null if the schema is not supplied. */
  public Schema getSchema() {
    return schema;
  }

  /**
   * Returns the total number of rows in the complete result set, which can be more than the number
   * of rows in the first page of results returned by {@link #getValues()}.
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
  public TableResult getNextPage() {
    if (pageNoSchema.hasNextPage()) {
      return new TableResult(schema, totalRows, pageNoSchema.getNextPage());
    }
    return null;
  }

  @Override
  public Iterable<FieldValueList> iterateAll() {
    return addSchema(pageNoSchema.iterateAll());
  }

  @Override
  public Iterable<FieldValueList> getValues() {
    return addSchema(pageNoSchema.getValues());
  }

  private Iterable<FieldValueList> addSchema(Iterable<FieldValueList> iter) {
    if (schema == null) {
      return iter;
    }
    return Iterables.transform(
        iter,
        new Function<FieldValueList, FieldValueList>() {
          @Override
          public FieldValueList apply(FieldValueList list) {
            return list.withSchema(schema.getFields());
          }
        });
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
    return Objects.hash(pageNoSchema, schema, totalRows);
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(TableResult.class)) {
      return false;
    }
    TableResult response = (TableResult) obj;
    return Objects.equals(getNextPageToken(), response.getNextPageToken())
        && Iterators.elementsEqual(getValues().iterator(), response.getValues().iterator())
        && Objects.equals(schema, response.schema)
        && totalRows == response.totalRows;
  }
}
