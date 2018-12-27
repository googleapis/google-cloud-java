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
package com.google.cloud.bigquery.storage.v1beta1.stub.readrows;

import com.google.api.core.InternalApi;
import com.google.api.gax.retrying.StreamResumptionStrategy;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse;

/**
 * An implementation of a {@link StreamResumptionStrategy} for the ReadRows API. This class tracks
 * the offset of the last row received and, upon retry, attempts to resume the stream at the next
 * offset.
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications.
 */
@InternalApi
public class ReadRowsResumptionStrategy
    implements StreamResumptionStrategy<ReadRowsRequest, ReadRowsResponse> {

  // Number of rows processed.
  private long rowsProcessed = 0;

  @Override
  public StreamResumptionStrategy<ReadRowsRequest, ReadRowsResponse> createNew() {
    return new ReadRowsResumptionStrategy();
  }

  @Override
  public ReadRowsResponse processResponse(ReadRowsResponse response) {
    rowsProcessed += response.getAvroRows().getRowCount();
    return response;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Given the initial/original request, this implementation generates a request that will yield
   * a new stream whose first response would come right after the last response received by
   * processResponse. It takes into account the offset from the original request.
   */
  @Override
  public ReadRowsRequest getResumeRequest(ReadRowsRequest originalRequest) {
    ReadRowsRequest.Builder resumeRequestBuilder = originalRequest.toBuilder();

    resumeRequestBuilder
        .getReadPositionBuilder()
        .setOffset(originalRequest.getReadPosition().getOffset() + rowsProcessed);

    return resumeRequestBuilder.build();
  }

  @Override
  public boolean canResume() {
    return true;
  }
}
