/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.stub;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.v2.Cell;
import com.google.bigtable.v2.Column;
import com.google.bigtable.v2.Family;
import com.google.bigtable.v2.ReadModifyWriteRowRequest;
import com.google.bigtable.v2.ReadModifyWriteRowResponse;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.ReadModifyWriteRow;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowCell;
import com.google.common.collect.ImmutableList;

/** Simple wrapper for ReadModifyWriteRow to wrap the request and response protobufs. */
class ReadModifyWriteRowCallable extends UnaryCallable<ReadModifyWriteRow, Row> {
  private final UnaryCallable<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse> inner;
  private final RequestContext requestContext;

  ReadModifyWriteRowCallable(
      UnaryCallable<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse> inner,
      RequestContext requestContext) {
    this.inner = inner;
    this.requestContext = requestContext;
  }

  @Override
  public ApiFuture<Row> futureCall(ReadModifyWriteRow request, ApiCallContext context) {
    ApiFuture<ReadModifyWriteRowResponse> rawResponse =
        inner.futureCall(request.toProto(requestContext), context);

    return ApiFutures.transform(
        rawResponse,
        new ApiFunction<ReadModifyWriteRowResponse, Row>() {
          @Override
          public Row apply(ReadModifyWriteRowResponse readModifyWriteRowResponse) {
            return convertResponse(readModifyWriteRowResponse);
          }
        });
  }

  private Row convertResponse(ReadModifyWriteRowResponse response) {
    ImmutableList.Builder<RowCell> cells = ImmutableList.builder();

    for (Family family : response.getRow().getFamiliesList()) {
      for (Column column : family.getColumnsList()) {
        for (Cell cell : column.getCellsList()) {
          cells.add(
              RowCell.create(
                  family.getName(),
                  column.getQualifier(),
                  cell.getTimestampMicros(),
                  cell.getLabelsList(),
                  cell.getValue()));
        }
      }
    }
    return Row.create(response.getRow().getKey(), cells.build());
  }
}
