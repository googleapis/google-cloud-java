/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigtable.data.v2.internal.api;

import com.google.bigtable.v2.RowSet;
import com.google.bigtable.v2.SessionReadRowsRequest;
import com.google.bigtable.v2.SessionReadRowsResponse;
import com.google.cloud.bigtable.data.v2.internal.RowSetUtil;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpcResumptionStrategy;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import javax.annotation.Nullable;

/**
 * {@link VRpcResumptionStrategy} for {@code SessionReadRows}. Tracks the last row key seen and the
 * number of rows delivered so that, upon a retryable mid-stream failure, it can narrow the request
 * to exclude everything already returned and shrink the row limit accordingly.
 *
 * <p>This mirrors the classic {@code ReadRowsResumptionStrategy} used on the gRPC path.
 */
public final class SessionReadRowsResumptionStrategy
    implements VRpcResumptionStrategy<SessionReadRowsRequest, SessionReadRowsResponse> {

  private ByteString lastKey = ByteString.EMPTY;
  // Number of rows delivered so far, used to shrink the row limit on resume.
  private long numProcessed;

  @Override
  public void onResponse(SessionReadRowsResponse response) {
    // The session read_rows response carries already-merged rows, so every row counts toward both
    // the resume point and the row limit. The last row's key is where a resume would pick up from.
    int rowCount = response.getRowCount();
    if (rowCount > 0) {
      lastKey = response.getRow(rowCount - 1).getKey();
      numProcessed += rowCount;
    }
  }

  /**
   * {@inheritDoc}
   *
   * <p>Narrows {@code originalRequest} to exclude all row keys and ranges that would produce rows
   * at or before {@link #lastKey}, and shrinks the row limit to account for rows already delivered.
   * Returns {@code null} when the scan is already fully satisfied (every range consumed, or the row
   * limit reached), signaling the retry layer to complete successfully.
   */
  @Override
  @Nullable
  public SessionReadRowsRequest getResumeRequest(SessionReadRowsRequest originalRequest) {
    // An empty lastKey means we have not successfully read the first row, so resume with the
    // original request object.
    if (lastKey.isEmpty()) {
      return originalRequest;
    }

    RowSet remaining =
        RowSetUtil.erase(originalRequest.getRows(), lastKey, !originalRequest.getReversed());

    // The scan is fulfilled if every requested range has been consumed, or if a row limit was set
    // and we have already delivered that many rows.
    if (remaining == null
        || (originalRequest.getRowsLimit() > 0 && originalRequest.getRowsLimit() == numProcessed)) {
      return null;
    }

    SessionReadRowsRequest.Builder builder = originalRequest.toBuilder().setRows(remaining);

    if (originalRequest.getRowsLimit() > 0) {
      Preconditions.checkState(
          originalRequest.getRowsLimit() > numProcessed,
          "Detected too many rows for the current row limit.");
      builder.setRowsLimit(originalRequest.getRowsLimit() - numProcessed);
    }

    return builder.build();
  }

  @VisibleForTesting
  ByteString getLastKey() {
    return lastKey;
  }

  @VisibleForTesting
  long getNumProcessed() {
    return numProcessed;
  }
}
