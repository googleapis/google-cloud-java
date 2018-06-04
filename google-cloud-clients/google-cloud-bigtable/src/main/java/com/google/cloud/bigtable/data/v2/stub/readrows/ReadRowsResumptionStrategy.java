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
import com.google.bigtable.v2.RowRange;
import com.google.bigtable.v2.RowSet;
import com.google.cloud.bigtable.data.v2.internal.ByteStringComparator;
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
  public ReadRowsRequest getResumeRequest(ReadRowsRequest request) {
    // An empty lastKey means that we have not successfully read the first row,
    // so resume with the original request object.
    if (lastKey.isEmpty()) {
      return request;
    }

    ReadRowsRequest originalRequest = request;

    // Special case: empty query implies full table scan, so make this explicit by adding an
    // unbounded range to the request
    if (request.getRows().getRowKeysList().isEmpty()
        && request.getRows().getRowRangesList().isEmpty()) {

      originalRequest =
          request
              .toBuilder()
              .setRows(RowSet.newBuilder().addRowRanges(RowRange.getDefaultInstance()))
              .build();
    }

    // Start building the resume request. The keys & ranges are cleared and will be recomputed.
    Builder builder = originalRequest.toBuilder();
    builder.clearRows();

    RowSet.Builder rowSetBuilder = RowSet.newBuilder();

    for (ByteString key : originalRequest.getRows().getRowKeysList()) {
      if (ByteStringComparator.INSTANCE.compare(key, lastKey) > 0) {
        rowSetBuilder.addRowKeys(key);
      }
    }

    for (RowRange rowRange : originalRequest.getRows().getRowRangesList()) {
      RowRange.Builder rowRangeBuilder = RowRange.newBuilder();

      switch (rowRange.getEndKeyCase()) {
        case END_KEY_CLOSED:
          if (ByteStringComparator.INSTANCE.compare(rowRange.getEndKeyClosed(), lastKey) > 0) {
            rowRangeBuilder.setEndKeyClosed(rowRange.getEndKeyClosed());
          } else {
            continue;
          }
          break;
        case END_KEY_OPEN:
          if (ByteStringComparator.INSTANCE.compare(rowRange.getEndKeyOpen(), lastKey) > 0) {
            rowRangeBuilder.setEndKeyOpen(rowRange.getEndKeyOpen());
          } else {
            continue;
          }
          break;
        case ENDKEY_NOT_SET:
          rowRangeBuilder.clearEndKey();
          break;
        default:
          throw new IllegalArgumentException("Unknown endKeyCase: " + rowRange.getEndKeyCase());
      }

      switch (rowRange.getStartKeyCase()) {
        case STARTKEY_NOT_SET:
          rowRangeBuilder.setStartKeyOpen(lastKey);
          break;
        case START_KEY_OPEN:
          if (ByteStringComparator.INSTANCE.compare(rowRange.getStartKeyOpen(), lastKey) < 0) {
            rowRangeBuilder.setStartKeyOpen(lastKey);
          } else {
            rowRangeBuilder.setStartKeyOpen(rowRange.getStartKeyOpen());
          }
          break;
        case START_KEY_CLOSED:
          if (ByteStringComparator.INSTANCE.compare(rowRange.getStartKeyClosed(), lastKey) <= 0) {
            rowRangeBuilder.setStartKeyOpen(lastKey);
          } else {
            rowRangeBuilder.setStartKeyClosed(rowRange.getStartKeyClosed());
          }
          break;
        default:
          throw new IllegalArgumentException("Unknown startKeyCase: " + rowRange.getStartKeyCase());
      }
      rowSetBuilder.addRowRanges(rowRangeBuilder.build());
    }

    // Edge case: retrying a fulfilled request.
    // A fulfilled request is one that has had all of its row keys and ranges fulfilled, or if it
    // had a row limit, has seen enough rows. These requests are replaced with a marker request that
    // will be handled by ReadRowsRetryCompletedCallable. See docs in ReadRowsRetryCompletedCallable
    // for more details.
    if ((rowSetBuilder.getRowRangesCount() == 0 && rowSetBuilder.getRowKeysCount() == 0)
        || (originalRequest.getRowsLimit() > 0 && originalRequest.getRowsLimit() == numProcessed)) {
      return ReadRowsRetryCompletedCallable.FULFILLED_REQUEST_MARKER;
    }

    if (originalRequest.getRowsLimit() > 0) {
      Preconditions.checkState(
          originalRequest.getRowsLimit() > numProcessed,
          "Detected too many rows for the current row limit during a retry.");
      builder.setRowsLimit(originalRequest.getRowsLimit() - numProcessed);
    }

    builder.setRows(rowSetBuilder.build());
    return builder.build();
  }
}
