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
package com.google.cloud.bigtable.data.v2.stub.readrows;

import com.google.api.core.InternalApi;
import com.google.api.gax.retrying.StreamResumptionStrategy;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsRequest.Builder;
import com.google.bigtable.v2.RowSet;
import com.google.cloud.bigtable.data.v2.internal.RowSetUtil;
import com.google.cloud.bigtable.data.v2.models.RowAdapter;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;

/**
 * An implementation of a {@link StreamResumptionStrategy} for merged rows. This class tracks the
 * last complete row seen and upon retry can build a request to resume the stream from where it left
 * off.
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications.
 */
@InternalApi
public class ReadRowsResumptionStrategy<RowT>
    implements StreamResumptionStrategy<ReadRowsRequest, RowT> {
  private final RowAdapter<RowT> rowAdapter;
  private ByteString lastKey = ByteString.EMPTY;
  // Number of rows processed excluding Marker row.
  private long numProcessed;

  public ReadRowsResumptionStrategy(RowAdapter<RowT> rowAdapter) {
    this.rowAdapter = rowAdapter;
  }

  @Override
  public boolean canResume() {
    return true;
  }

  @Override
  public StreamResumptionStrategy<ReadRowsRequest, RowT> createNew() {
    return new ReadRowsResumptionStrategy<>(rowAdapter);
  }

  @Override
  public RowT processResponse(RowT response) {
    // Last key can come from both the last processed row key and a synthetic row marker. The
    // synthetic row marker is emitted when the server has read a lot of data that was filtered out.
    // The row marker can be used to trim the start of the scan, but does not contribute to the row
    // limit.
    lastKey = rowAdapter.getKey(response);
    if (!rowAdapter.isScanMarkerRow(response)) {
      // Only real rows count towards the rows limit.
      numProcessed++;
    }
    return response;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Given a request, this implementation will narrow that request to exclude all row keys and
   * ranges that would produce rows that come before {@link #lastKey}. Furthermore this
   * implementation takes care to update the row limit of the request to account for all of the
   * received rows.
   */
  @Override
  public ReadRowsRequest getResumeRequest(ReadRowsRequest originalRequest) {
    // An empty lastKey means that we have not successfully read the first row,
    // so resume with the original request object.
    if (lastKey.isEmpty()) {
      return originalRequest;
    }

    RowSet remaining = RowSetUtil.split(originalRequest.getRows(), lastKey).getRight();

    // Edge case: retrying a fulfilled request.
    // A fulfilled request is one that has had all of its row keys and ranges fulfilled, or if it
    // had a row limit, has seen enough rows. These requests are replaced with a marker request that
    // will be handled by ReadRowsRetryCompletedCallable. See docs in ReadRowsRetryCompletedCallable
    // for more details.
    if (remaining == null
        || (originalRequest.getRowsLimit() > 0 && originalRequest.getRowsLimit() == numProcessed)) {
      return ReadRowsRetryCompletedCallable.FULFILLED_REQUEST_MARKER;
    }

    Builder builder = originalRequest.toBuilder().setRows(remaining);

    if (originalRequest.getRowsLimit() > 0) {
      Preconditions.checkState(
          originalRequest.getRowsLimit() > numProcessed,
          "Detected too many rows for the current row limit during a retry.");
      builder.setRowsLimit(originalRequest.getRowsLimit() - numProcessed);
    }

    return builder.build();
  }
}
