/*
 * Copyright 2018 Google LLC
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

import com.google.api.gax.paging.Page;
import com.google.auto.value.AutoValue;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.Nullable;

@AutoValue
public abstract class TableResult implements Page<FieldValueList>, Serializable {

  private static final long serialVersionUID = 1L;

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract TableResult.Builder setSchema(Schema schema);

    /**
     * Sets the total number of rows in the complete result set, which can be more than the number
     * of rows in the first page of results returned by {@link #getValues()}.
     */
    public abstract TableResult.Builder setTotalRows(Long totalRows);

    public abstract TableResult.Builder setJobId(JobId jobId);

    public abstract TableResult.Builder setPageNoSchema(Page<FieldValueList> pageNoSchema);

    public abstract TableResult.Builder setQueryId(String queryId);

    /** Creates a @code TableResult} object. */
    public abstract TableResult build();
  }

  public abstract Builder toBuilder();

  public static Builder newBuilder() {
    return new AutoValue_TableResult.Builder();
  }

  /** Returns the schema of the results. Null if the schema is not supplied. */
  @Nullable
  public abstract Schema getSchema();

  /**
   * Returns the total number of rows in the complete result set, which can be more than the number
   * of rows in the first page of results. If no rows are returned, this value can still be greater
   * than 0 if any rows were affected by the query, such as INSERT, UPDATE, or DELETE queries.
   */
  public abstract long getTotalRows();

  public abstract Page<FieldValueList> getPageNoSchema();

  @Nullable
  public abstract JobId getJobId();

  @Nullable
  public abstract String getQueryId();

  @Override
  public boolean hasNextPage() {
    return getPageNoSchema().hasNextPage();
  }

  @Override
  public String getNextPageToken() {
    return getPageNoSchema().getNextPageToken();
  }

  @Override
  public TableResult getNextPage() {
    if (getPageNoSchema().hasNextPage()) {
      return TableResult.newBuilder()
          .setSchema(getSchema())
          .setTotalRows(getTotalRows())
          .setPageNoSchema(getPageNoSchema().getNextPage())
          .setQueryId(getQueryId())
          .build();
    }
    return null;
  }

  @Override
  public Iterable<FieldValueList> iterateAll() {
    return addSchema(getPageNoSchema().iterateAll());
  }

  @Override
  public Iterable<FieldValueList> getValues() {
    return addSchema(getPageNoSchema().getValues());
  }

  private Iterable<FieldValueList> addSchema(Iterable<FieldValueList> iter) {
    if (getSchema() == null) {
      return iter;
    }
    return Iterables.transform(
        iter,
        new Function<FieldValueList, FieldValueList>() {
          @Override
          public FieldValueList apply(FieldValueList list) {
            return list.withSchema(getSchema().getFields());
          }
        });
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("rows", getValues())
        .add("schema", getSchema())
        .add("totalRows", getTotalRows())
        .add("cursor", getNextPageToken())
        .add("queryId", getQueryId())
        .toString();
  }

  @Override
  public final int hashCode() {
    return Objects.hash(getPageNoSchema(), getSchema(), getTotalRows(), getQueryId());
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(AutoValue_TableResult.class)) {
      return false;
    }
    TableResult response = (TableResult) obj;
    return Objects.equals(getNextPageToken(), response.getNextPageToken())
        && Iterators.elementsEqual(getValues().iterator(), response.getValues().iterator())
        && Objects.equals(getSchema(), response.getSchema())
        && getTotalRows() == response.getTotalRows()
        && getQueryId() == response.getQueryId();
  }
}
