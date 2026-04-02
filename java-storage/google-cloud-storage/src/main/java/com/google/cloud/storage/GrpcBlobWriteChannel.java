/*
 * Copyright 2022 Google LLC
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

import com.google.api.core.ApiFuture;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.cloud.RestorableState;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Retrying.RetrierWithAlg;
import com.google.storage.v2.WriteObjectRequest;
import com.google.storage.v2.WriteObjectResponse;
import java.util.function.Supplier;

final class GrpcBlobWriteChannel extends BaseStorageWriteChannel<WriteObjectResponse> {

  private final ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse> write;
  private final RetrierWithAlg retrier;
  private final Supplier<ApiFuture<ResumableWrite>> start;
  private final Hasher hasher;

  GrpcBlobWriteChannel(
      ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse> write,
      RetrierWithAlg retrier,
      Supplier<ApiFuture<ResumableWrite>> start,
      Hasher hasher) {
    super(Conversions.grpc().blobInfo().compose(WriteObjectResponse::getResource));
    this.write = write;
    this.retrier = retrier;
    this.start = start;
    this.hasher = hasher;
  }

  @Override
  public RestorableState<WriteChannel> capture() {
    return CrossTransportUtils.throwHttpJsonOnly(WriteChannel.class, "capture");
  }

  @Override
  protected LazyWriteChannel<WriteObjectResponse> newLazyWriteChannel() {
    return new LazyWriteChannel<>(
        () ->
            ResumableMedia.gapic()
                .write()
                .byteChannel(write)
                .setHasher(hasher)
                .setByteStringStrategy(ByteStringStrategy.copy())
                .resumable()
                .withRetryConfig(retrier)
                .buffered(getBufferHandle())
                .setStartAsync(start.get())
                .build());
  }
}
