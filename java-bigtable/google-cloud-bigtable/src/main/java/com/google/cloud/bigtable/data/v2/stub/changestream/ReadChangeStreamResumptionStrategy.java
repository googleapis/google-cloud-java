/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.changestream;

import com.google.api.core.InternalApi;
import com.google.api.gax.retrying.StreamResumptionStrategy;
import com.google.bigtable.v2.ReadChangeStreamRequest;
import com.google.bigtable.v2.ReadChangeStreamRequest.Builder;
import com.google.bigtable.v2.StreamContinuationToken;
import com.google.bigtable.v2.StreamContinuationTokens;
import com.google.cloud.bigtable.data.v2.models.ChangeStreamRecordAdapter;

/**
 * An implementation of a {@link StreamResumptionStrategy} for change stream records. This class
 * tracks the continuation token and upon retry can build a request to resume the stream from where
 * it left off.
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications.
 */
@InternalApi
public class ReadChangeStreamResumptionStrategy<ChangeStreamRecordT>
    implements StreamResumptionStrategy<ReadChangeStreamRequest, ChangeStreamRecordT> {
  private final ChangeStreamRecordAdapter<ChangeStreamRecordT> changeStreamRecordAdapter;
  private String token = null;

  public ReadChangeStreamResumptionStrategy(
      ChangeStreamRecordAdapter<ChangeStreamRecordT> changeStreamRecordAdapter) {
    this.changeStreamRecordAdapter = changeStreamRecordAdapter;
  }

  @Override
  public boolean canResume() {
    return true;
  }

  @Override
  public StreamResumptionStrategy<ReadChangeStreamRequest, ChangeStreamRecordT> createNew() {
    return new ReadChangeStreamResumptionStrategy<>(changeStreamRecordAdapter);
  }

  @Override
  public ChangeStreamRecordT processResponse(ChangeStreamRecordT response) {
    // Update the token from a Heartbeat or a ChangeStreamMutation.
    // We don't worry about resumption after CloseStream, since the server
    // will close the stream with an OK status right after sending a CloseStream,
    // no matter what status the CloseStream.Status is:
    // 1) ... => CloseStream.Ok => final OK. This means the read finishes successfully.
    // 2) ... => CloseStream.Error => final OK. This means the client should start
    //    a new ReadChangeStream call with the continuation tokens specified in
    //    CloseStream.
    // Either case, we don't need to retry after receiving a CloseStream.
    if (changeStreamRecordAdapter.isHeartbeat(response)) {
      this.token = changeStreamRecordAdapter.getTokenFromHeartbeat(response);
    } else if (changeStreamRecordAdapter.isChangeStreamMutation(response)) {
      this.token = changeStreamRecordAdapter.getTokenFromChangeStreamMutation(response);
    }
    return response;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Given a request, this implementation will narrow that request to include data changes that
   * come after {@link #token}.
   */
  @Override
  public ReadChangeStreamRequest getResumeRequest(ReadChangeStreamRequest originalRequest) {
    // A null token means that we have not successfully read a Heartbeat nor a ChangeStreamMutation,
    // so start from the beginning.
    if (this.token == null) {
      return originalRequest;
    }

    Builder builder = originalRequest.toBuilder();
    // We need to clear the start_from and use the updated continuation_tokens
    // to resume the request.
    // The partition should always be the same as the one from the original request,
    // otherwise we would receive a CloseStream with different
    // partitions(which indicates tablet split/merge events).
    builder.clearStartFrom();
    builder.setContinuationTokens(
        StreamContinuationTokens.newBuilder()
            .addTokens(
                StreamContinuationToken.newBuilder()
                    .setPartition(originalRequest.getPartition())
                    .setToken(this.token)
                    .build())
            .build());

    return builder.build();
  }
}
