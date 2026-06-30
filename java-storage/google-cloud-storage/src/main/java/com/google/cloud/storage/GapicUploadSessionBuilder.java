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
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.storage.Conversions.Decoder;
import com.google.cloud.storage.Retrying.RetrierWithAlg;
import com.google.cloud.storage.UnifiedOpts.ObjectTargetOpt;
import com.google.cloud.storage.UnifiedOpts.Opts;
import com.google.storage.v2.BidiWriteObjectRequest;
import com.google.storage.v2.BidiWriteObjectResponse;
import com.google.storage.v2.StartResumableWriteRequest;
import com.google.storage.v2.StartResumableWriteResponse;
import com.google.storage.v2.WriteObjectRequest;
import com.google.storage.v2.WriteObjectResponse;
import java.util.function.Function;

final class GapicUploadSessionBuilder {

  private GapicUploadSessionBuilder() {}

  static GapicUploadSessionBuilder create() {
    return new GapicUploadSessionBuilder();
  }

  GapicWritableByteChannelSessionBuilder byteChannel(
      ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse> write) {
    return new GapicWritableByteChannelSessionBuilder(write);
  }

  GapicBidiWritableByteChannelSessionBuilder bidiByteChannel(
      BidiStreamingCallable<BidiWriteObjectRequest, BidiWriteObjectResponse> write) {
    return new GapicBidiWritableByteChannelSessionBuilder(write);
  }

  ApiFuture<ResumableWrite> resumableWrite(
      UnaryCallable<StartResumableWriteRequest, StartResumableWriteResponse> callable,
      WriteObjectRequest writeObjectRequest,
      Opts<ObjectTargetOpt> opts,
      RetrierWithAlg retrier) {
    StartResumableWriteRequest.Builder b = StartResumableWriteRequest.newBuilder();
    if (writeObjectRequest.hasWriteObjectSpec()) {
      b.setWriteObjectSpec(writeObjectRequest.getWriteObjectSpec());
    }
    if (writeObjectRequest.hasCommonObjectRequestParams()) {
      b.setCommonObjectRequestParams(writeObjectRequest.getCommonObjectRequestParams());
    }
    if (writeObjectRequest.hasObjectChecksums()) {
      b.setObjectChecksums(writeObjectRequest.getObjectChecksums());
    }
    StartResumableWriteRequest req = opts.startResumableWriteRequest().apply(b).build();
    Function<String, WriteObjectRequest> f =
        uploadId ->
            writeObjectRequest.toBuilder().clearWriteObjectSpec().setUploadId(uploadId).build();
    SettableApiFuture<ResumableWrite> future = SettableApiFuture.create();
    try {
      ResumableWrite resumableWrite =
          retrier.run(
              () -> {
                StartResumableWriteResponse resp = callable.call(req);
                return new ResumableWrite(req, resp, f);
              },
              Decoder.identity());
      future.set(resumableWrite);
    } catch (StorageException e) {
      future.setException(e);
    }
    return future;
  }

  ApiFuture<BidiResumableWrite> bidiResumableWrite(
      UnaryCallable<StartResumableWriteRequest, StartResumableWriteResponse> x,
      BidiWriteObjectRequest writeObjectRequest,
      Opts<ObjectTargetOpt> opts,
      RetrierWithAlg retrier) {
    StartResumableWriteRequest.Builder b = StartResumableWriteRequest.newBuilder();
    if (writeObjectRequest.hasWriteObjectSpec()) {
      b.setWriteObjectSpec(writeObjectRequest.getWriteObjectSpec());
    }
    if (writeObjectRequest.hasCommonObjectRequestParams()) {
      b.setCommonObjectRequestParams(writeObjectRequest.getCommonObjectRequestParams());
    }
    if (writeObjectRequest.hasObjectChecksums()) {
      b.setObjectChecksums(writeObjectRequest.getObjectChecksums());
    }
    StartResumableWriteRequest req = opts.startResumableWriteRequest().apply(b).build();
    Function<String, BidiWriteObjectRequest> f =
        uploadId ->
            writeObjectRequest.toBuilder().clearWriteObjectSpec().setUploadId(uploadId).build();
    SettableApiFuture<BidiResumableWrite> future = SettableApiFuture.create();
    try {
      BidiResumableWrite resumableWrite =
          retrier.run(
              () -> {
                StartResumableWriteResponse resp = x.call(req);
                return new BidiResumableWrite(req, resp, f);
              },
              Decoder.identity());
      future.set(resumableWrite);
    } catch (StorageException e) {
      future.setException(e);
    }
    return future;
  }
}
