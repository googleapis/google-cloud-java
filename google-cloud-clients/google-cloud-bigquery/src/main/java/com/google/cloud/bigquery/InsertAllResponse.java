/*
 * Copyright 2015 Google LLC
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

import com.google.api.services.bigquery.model.ErrorProto;
import com.google.api.services.bigquery.model.TableDataInsertAllResponse;
import com.google.api.services.bigquery.model.TableDataInsertAllResponse.InsertErrors;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Google Cloud BigQuery insert all response. Objects of this class possibly contain errors for an
 * {@link InsertAllRequest}. If a row failed to be inserted, the non-empty list of errors associated
 * to that row's index can be obtained with {@link InsertAllResponse#getErrorsFor(long)}. {@link
 * InsertAllResponse#getInsertErrors()} can be used to return all errors caused by a {@link
 * InsertAllRequest} as a map.
 */
public class InsertAllResponse implements Serializable {

  private static final long serialVersionUID = -6934152676514098452L;

  private final Map<Long, List<BigQueryError>> insertErrors;

  InsertAllResponse(Map<Long, List<BigQueryError>> insertErrors) {
    this.insertErrors =
        insertErrors != null
            ? ImmutableMap.copyOf(insertErrors)
            : ImmutableMap.<Long, List<BigQueryError>>of();
  }

  /**
   * Returns all insertion errors as a map whose keys are indexes of rows that failed to insert.
   * Each failed row index is associated with a non-empty list of {@link BigQueryError}.
   */
  public Map<Long, List<BigQueryError>> getInsertErrors() {
    return insertErrors;
  }

  /** Returns errors for the provided row index. If no error exists returns {@code null}. */
  public List<BigQueryError> getErrorsFor(long index) {
    return insertErrors.get(index);
  }

  /**
   * Returns {@code true} if no row insertion failed, {@code false} otherwise. If {@code false}
   * {@link #getInsertErrors()} returns an empty map.
   */
  public boolean hasErrors() {
    return !insertErrors.isEmpty();
  }

  @Override
  public final int hashCode() {
    return Objects.hash(insertErrors);
  }

  @Override
  public final boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(InsertAllResponse.class)
            && Objects.equals(insertErrors, ((InsertAllResponse) obj).insertErrors);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("insertErrors", insertErrors).toString();
  }

  TableDataInsertAllResponse toPb() {
    TableDataInsertAllResponse responsePb = new TableDataInsertAllResponse();
    if (!insertErrors.isEmpty()) {
      responsePb.setInsertErrors(
          ImmutableList.copyOf(
              Iterables.transform(
                  insertErrors.entrySet(),
                  new Function<Map.Entry<Long, List<BigQueryError>>, InsertErrors>() {
                    @Override
                    public InsertErrors apply(Map.Entry<Long, List<BigQueryError>> entry) {
                      return new InsertErrors()
                          .setIndex(entry.getKey())
                          .setErrors(
                              Lists.transform(entry.getValue(), BigQueryError.TO_PB_FUNCTION));
                    }
                  })));
    }
    return responsePb;
  }

  static InsertAllResponse fromPb(TableDataInsertAllResponse responsePb) {
    Map<Long, List<BigQueryError>> insertErrors = null;
    if (responsePb.getInsertErrors() != null) {
      List<InsertErrors> errorsPb = responsePb.getInsertErrors();
      insertErrors = Maps.newHashMapWithExpectedSize(errorsPb.size());
      for (InsertErrors errorPb : errorsPb) {
        insertErrors.put(
            errorPb.getIndex(),
            Lists.transform(
                errorPb.getErrors() != null ? errorPb.getErrors() : ImmutableList.<ErrorProto>of(),
                BigQueryError.FROM_PB_FUNCTION));
      }
    }
    return new InsertAllResponse(insertErrors);
  }
}
