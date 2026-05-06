/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.cloud.storage.GrpcUtils.ZeroCopyServerStreamingCallable;
import com.google.cloud.storage.Retrying.Retrier;
import com.google.cloud.storage.it.ChecksummedTestContent;
import com.google.storage.v2.ReadObjectRequest;
import com.google.storage.v2.ReadObjectResponse;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Test;

public final class GapicUnbufferedReadableByteChannelTest {

  @Test
  public void ensureResponseAreClosed() throws IOException {
    ChecksummedTestContent testContent =
        ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(10));

    AtomicBoolean close = new AtomicBoolean(false);

    ResponseContentLifecycleManager<ReadObjectResponse> manager =
        resp -> ResponseContentLifecycleHandle.create(resp, () -> close.compareAndSet(false, true));

    try (GapicUnbufferedReadableByteChannel c =
        new GapicUnbufferedReadableByteChannel(
            SettableApiFuture.create(),
            new ZeroCopyServerStreamingCallable<>(
                new ServerStreamingCallable<ReadObjectRequest, ReadObjectResponse>() {
                  @Override
                  public void call(
                      ReadObjectRequest request,
                      ResponseObserver<ReadObjectResponse> respond,
                      ApiCallContext context) {
                    respond.onStart(TestUtils.nullStreamController());
                    respond.onResponse(
                        ReadObjectResponse.newBuilder()
                            .setChecksummedData(testContent.asChecksummedData())
                            .build());
                    respond.onComplete();
                  }
                },
                manager),
            ReadObjectRequest.getDefaultInstance(),
            Hasher.noop(),
            Retrier.attemptOnce(),
            Retrying.neverRetry())) {

      ByteBuffer buffer = ByteBuffer.allocate(15);
      c.read(buffer);
      assertThat(xxd(buffer)).isEqualTo(xxd(testContent.getBytes()));
      assertThat(close.get()).isTrue();
    }
  }
}
