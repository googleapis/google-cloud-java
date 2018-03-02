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
 * last complete row seen and upon retry can build a request to resume the stream from were it left
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
  private long numProcessed = 0;

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
  public void onProgress(RowT response) {
    // Last key can come from both the last processed row key and a synthetic row marker. The
    // synthetic row marker is emitted when the server has read a lot of data that was filtered out.
    // So it can trim the start of the scan, but does not contribute to the row limit.
    lastKey = rowAdapter.getKey(response);
    if (!rowAdapter.isScanMarkerRow(response)) {
      // Only real rows count towards the rows limit.
      numProcessed++;
    }
  }

  @Override
  public ReadRowsRequest getResumeRequest(ReadRowsRequest request) {
    if (lastKey.isEmpty()) {
      return request;
    }
    Builder builder = request.toBuilder();

    if (request.getRowsLimit() > 0) {
      Preconditions.checkState(
          request.getRowsLimit() >= numProcessed,
          "Detected too many responses for the current row limit during a retry.");
      builder.setRowsLimit(request.getRowsLimit() - numProcessed);
    }

    // Reset rows to scan.
    builder.clearRows();

    RowSet.Builder newRowSet = RowSet.newBuilder();

    // Special case: empty query implies full table scan
    if (request.getRows().getRowKeysList().isEmpty()
        && request.getRows().getRowRangesList().isEmpty()) {
      newRowSet.addRowRanges(RowRange.newBuilder().setStartKeyOpen(lastKey).build());
    } else {
      for (ByteString key : request.getRows().getRowKeysList()) {
        if (ByteStringComparator.INSTANCE.compare(key, lastKey) > 0) {
          newRowSet.addRowKeys(key);
        }
      }

      for (RowRange rowRange : request.getRows().getRowRangesList()) {
        RowRange.Builder rangeBuilder = RowRange.newBuilder();

        switch (rowRange.getEndKeyCase()) {
          case END_KEY_CLOSED:
            if (ByteStringComparator.INSTANCE.compare(rowRange.getEndKeyClosed(), lastKey) <= 0) {
              continue;
            } else {
              rangeBuilder.setEndKeyClosed(rowRange.getEndKeyClosed());
            }
            break;
          case END_KEY_OPEN:
            if (ByteStringComparator.INSTANCE.compare(rowRange.getEndKeyOpen(), lastKey) <= 0) {
              continue;
            } else {
              rangeBuilder.setEndKeyOpen(rowRange.getEndKeyOpen());
            }
            break;
          case ENDKEY_NOT_SET:
            rangeBuilder.clearEndKey();
        }

        switch (rowRange.getStartKeyCase()) {
          case STARTKEY_NOT_SET:
            rangeBuilder.setStartKeyOpen(lastKey);
            break;
          case START_KEY_OPEN:
            if (ByteStringComparator.INSTANCE.compare(rowRange.getStartKeyOpen(), lastKey) < 0) {
              rangeBuilder.setStartKeyOpen(lastKey);
            } else {
              rangeBuilder.setStartKeyOpen(rowRange.getStartKeyOpen());
            }
            break;
          case START_KEY_CLOSED:
            if (ByteStringComparator.INSTANCE.compare(rowRange.getStartKeyClosed(), lastKey) <= 0) {
              rangeBuilder.setStartKeyOpen(lastKey);
            } else {
              rangeBuilder.setStartKeyClosed(rowRange.getStartKeyClosed());
            }
            break;
          default:
            throw new IllegalArgumentException(
                "Unknown startKeyCase: " + rowRange.getStartKeyCase());
        }
        newRowSet.addRowRanges(rangeBuilder.build());
      }
    }

    builder.setRows(newRowSet.build());
    return builder.build();
  }
}
