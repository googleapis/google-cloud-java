/*
 * Copyright 2025 Google LLC
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
import com.google.api.gax.rpc.ApiException;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsRequest.Builder;
import com.google.bigtable.v2.RowSet;
import com.google.cloud.bigtable.data.v2.internal.RowSetUtil;
import com.google.cloud.bigtable.data.v2.models.RowAdapter;
import com.google.cloud.bigtable.data.v2.stub.BigtableStreamResumptionStrategy;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import java.util.Base64;
import java.util.logging.Logger;

/**
 * An implementation of a {@link StreamResumptionStrategy} for merged rows. This class tracks -
 *
 * <ul>
 *   <li>row key for the last row that was read successfully
 *   <li>row key for large-row that couldn't be read
 *   <li>list of all row keys for large-rows
 * </ul>
 *
 * Upon retry this class builds a request to omit the large rows & retry from the last row key that
 * was successfully read.
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications.
 */
@InternalApi
public class LargeReadRowsResumptionStrategy<RowT>
    extends BigtableStreamResumptionStrategy<ReadRowsRequest, RowT> {
  private static final Logger LOGGER =
      Logger.getLogger(LargeReadRowsResumptionStrategy.class.getName());
  private final RowAdapter<RowT> rowAdapter;
  private ByteString lastSuccessKey = ByteString.EMPTY;
  // Number of rows processed excluding Marker row.
  private long numProcessed;
  private ByteString largeRowKey = ByteString.EMPTY;
  // we modify the original request in the resumption strategy regardless of how many times it has
  // failed, {@code previousFailedRequestRowset} is stored for the use case of continuous large rows
  // row-keys
  private RowSet previousFailedRequestRowset = null;

  public LargeReadRowsResumptionStrategy(RowAdapter<RowT> rowAdapter) {
    this.rowAdapter = rowAdapter;
  }

  @Override
  public boolean canResume() {
    return true;
  }

  @Override
  public StreamResumptionStrategy<ReadRowsRequest, RowT> createNew() {
    return new LargeReadRowsResumptionStrategy<>(rowAdapter);
  }

  @Override
  public RowT processResponse(RowT response) {
    // Last key can come from both the last processed row key and a synthetic row marker. The
    // synthetic row marker is emitted when the server has read a lot of data that was filtered out.
    // The row marker can be used to trim the start of the scan, but does not contribute to the row
    // limit.
    lastSuccessKey = rowAdapter.getKey(response);

    if (!rowAdapter.isScanMarkerRow(response)) {
      // Only real rows count towards the rows limit.
      numProcessed++;
    }
    return response;
  }

  public Throwable processError(Throwable throwable) {
    ByteString rowKeyExtracted = extractLargeRowKey(throwable);
    if (rowKeyExtracted != null) {
      LOGGER.warning("skipping large row " + rowKeyExtracted);
      this.largeRowKey = rowKeyExtracted;
      numProcessed = numProcessed + 1;
    }
    return throwable;
  }

  private ByteString extractLargeRowKey(Throwable t) {
    if (t instanceof ApiException
        && ((ApiException) t).getReason() != null
        && ((ApiException) t).getReason().equals("LargeRowReadError")) {
      String rowKey = ((ApiException) t).getMetadata().get("rowKeyBase64Encoded");

      byte[] decodedBytes = Base64.getDecoder().decode(rowKey);
      return ByteString.copyFrom(decodedBytes);
    }
    return null;
  }

  /**
   * {@inheritDoc}
   *
   * <p>This returns an updated request excluding all the rows keys & ranges till (including) {@link
   * #lastSuccessKey} & also excludes the last encountered large row key ({@link #largeRowKey}).
   * Also, this implementation takes care to update the row limit of the request to account for all
   * of the received rows.
   */
  @Override
  public ReadRowsRequest getResumeRequest(ReadRowsRequest originalRequest) {

    // An empty lastSuccessKey means that we have not successfully read the first row,
    // so resume with the original request object.
    if (lastSuccessKey.isEmpty() && largeRowKey.isEmpty()) {
      return originalRequest;
    }

    RowSet remaining;
    if (previousFailedRequestRowset == null) {
      remaining = originalRequest.getRows();
    } else {
      remaining = previousFailedRequestRowset;
    }

    if (!lastSuccessKey.isEmpty()) {
      remaining = RowSetUtil.erase(remaining, lastSuccessKey, !originalRequest.getReversed());
    }
    if (!largeRowKey.isEmpty()) {
      remaining = RowSetUtil.eraseLargeRow(remaining, largeRowKey);
    }
    this.largeRowKey = ByteString.EMPTY;

    previousFailedRequestRowset = remaining;

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
          "Processed rows and number of large rows should not exceed the row limit in the original"
              + " request");
      builder.setRowsLimit(originalRequest.getRowsLimit() - numProcessed);
    }

    return builder.build();
  }
}
