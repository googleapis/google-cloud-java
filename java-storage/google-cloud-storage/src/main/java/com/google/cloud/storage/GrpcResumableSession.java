/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.storage;

import com.google.api.core.ApiFutures;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.storage.BufferedWritableByteChannelSession.BufferedWritableByteChannel;
import com.google.cloud.storage.Conversions.Decoder;
import com.google.cloud.storage.Retrying.RetrierWithAlg;
import com.google.storage.v2.Object;
import com.google.storage.v2.QueryWriteStatusRequest;
import com.google.storage.v2.QueryWriteStatusResponse;
import com.google.storage.v2.WriteObjectRequest;
import com.google.storage.v2.WriteObjectResponse;
import java.util.concurrent.atomic.AtomicBoolean;
import org.checkerframework.checker.nullness.qual.Nullable;

final class GrpcResumableSession {

  private final RetrierWithAlg retrier;
  private final ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse> writeCallable;
  private final UnaryCallable<QueryWriteStatusRequest, QueryWriteStatusResponse>
      queryWriteStatusCallable;
  private final ResumableWrite resumableWrite;
  private final Hasher hasher;

  GrpcResumableSession(
      RetrierWithAlg retrier,
      ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse> writeCallable,
      UnaryCallable<QueryWriteStatusRequest, QueryWriteStatusResponse> queryWriteStatusCallable,
      ResumableWrite resumableWrite,
      Hasher hasher) {
    this.retrier = retrier;
    this.writeCallable = writeCallable;
    this.queryWriteStatusCallable = queryWriteStatusCallable;
    this.resumableWrite = resumableWrite;
    this.hasher = hasher;
  }

  ResumableOperationResult<@Nullable Object> query() {
    QueryWriteStatusRequest.Builder b =
        QueryWriteStatusRequest.newBuilder().setUploadId(resumableWrite.getRes().getUploadId());
    if (resumableWrite.getReq().hasCommonObjectRequestParams()) {
      b.setCommonObjectRequestParams(resumableWrite.getReq().getCommonObjectRequestParams());
    }
    QueryWriteStatusRequest req = b.build();
    try {
      QueryWriteStatusResponse response = queryWriteStatusCallable.call(req);
      if (response.hasResource()) {
        return ResumableOperationResult.complete(
            response.getResource(), response.getResource().getSize());
      } else {
        return ResumableOperationResult.incremental(response.getPersistedSize());
      }
    } catch (Exception e) {
      throw StorageException.coalesce(e);
    }
  }

  ResumableOperationResult<@Nullable Object> put(RewindableContent content) {
    AtomicBoolean dirty = new AtomicBoolean(false);
    GrpcCallContext retryingCallContext = Retrying.newCallContext();
    BufferHandle handle = BufferHandle.allocate(ByteSizeConstants._2MiB);

    return retrier.run(
        () -> {
          if (dirty.getAndSet(true)) {
            ResumableOperationResult<@Nullable Object> query = query();
            if (query.getObject() != null) {
              return query;
            } else {
              handle.get().clear();
              content.rewindTo(query.getPersistedSize());
            }
          }
          WritableByteChannelSession<BufferedWritableByteChannel, WriteObjectResponse> session =
              ResumableMedia.gapic()
                  .write()
                  .byteChannel(writeCallable.withDefaultCallContext(retryingCallContext))
                  .setByteStringStrategy(ByteStringStrategy.copy())
                  .setHasher(hasher)
                  .resumable()
                  .setFsyncEvery(false)
                  .buffered(handle)
                  .setStartAsync(ApiFutures.immediateFuture(resumableWrite))
                  .build();

          try (BufferedWritableByteChannel channel = session.open()) {
            content.writeTo(channel);
          }

          WriteObjectResponse response = session.getResult().get();
          if (response.hasResource()) {
            return ResumableOperationResult.complete(
                response.getResource(), response.getResource().getSize());
          } else {
            return ResumableOperationResult.incremental(response.getPersistedSize());
          }
        },
        Decoder.identity());
  }
}
