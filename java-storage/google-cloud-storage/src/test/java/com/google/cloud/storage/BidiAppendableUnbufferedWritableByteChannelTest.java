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

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.cloud.storage.BidiUploadState.AppendableUploadState;
import com.google.cloud.storage.ITAppendableUploadFakeTest.FakeStorage;
import com.google.cloud.storage.it.ChecksummedTestContent;
import com.google.common.collect.ImmutableList;
import com.google.storage.v2.BidiWriteObjectResponse;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.time.OffsetDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public final class BidiAppendableUnbufferedWritableByteChannelTest {
  @Rule public final TestName testName = new TestName();

  @Test
  public void appendAndFinalizeOnlyPerformedIfAllBytesConsumed() throws IOException {
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    ChecksummedTestContent ctc = ChecksummedTestContent.gen(27);
    AppendableUploadState state =
        BidiUploadState.appendableNew(
            BidiUploadTest.appendRequestNew,
            GrpcCallContext::createDefault,
            16,
            SettableApiFuture.create(),
            Crc32cValue.zero());
    AtomicLong finishWriteOffset = new AtomicLong(-1);
    BidiUploadStreamingStream stream =
        new BidiUploadStreamingStream(
            state,
            executor,
            BidiUploadTestUtils.adaptOnlySend(
                respond ->
                    request -> {
                      if (request.getFinishWrite()) {
                        finishWriteOffset.set(
                            request.getWriteOffset()
                                + request.getChecksummedData().getContent().size());
                      }
                      executor.submit(
                          () -> {
                            switch ((int) request.getWriteOffset()) {
                              case 0:
                                respond.onResponse(BidiUploadTest.resourceWithSize(0));
                                break;
                              case 4:
                              case 8:
                                // do not ack any bytes until we receive 16, this simulates
                                // latency on the bytes being ack'd.
                                break;
                              case 12:
                                respond.onResponse(BidiUploadTestUtils.incremental(8));
                                break;
                              case 16:
                                respond.onResponse(BidiUploadTestUtils.incremental(12));
                                break;
                              case 20:
                                respond.onResponse(BidiUploadTestUtils.incremental(16));
                                break;
                              case 24:
                                BidiWriteObjectResponse.Builder b =
                                    BidiUploadTest.resourceFor(ctc).toBuilder();
                                b.getResourceBuilder()
                                    .setFinalizeTime(
                                        Conversions.grpc()
                                            .timestampCodec
                                            .encode(OffsetDateTime.now()));
                                respond.onResponse(b.build());
                                break;
                              default:
                                respond.onError(
                                    FakeStorage.unexpectedRequest(request, ImmutableList.of()));
                                break;
                            }
                          });
                    }),
            3,
            RetryContext.neverRetry());
    ChunkSegmenter chunkSegmenter =
        new ChunkSegmenter(Hasher.enabled(), ByteStringStrategy.copy(), 4, 2);
    BidiAppendableUnbufferedWritableByteChannel channel =
        new BidiAppendableUnbufferedWritableByteChannel(stream, chunkSegmenter, 4, 0);

    ByteBuffer buf = ctc.asByteBuffer();
    int written1 = channel.write(buf);
    // fill up the outbound queue
    assertThat(written1).isEqualTo(16);

    // asynchronously bytes will be ack'd 4 at a time, eventually there will be enough space in the
    // outbound queue to allow writeAndClose to start consuming bytes.
    channel.nextWriteShouldFinalize();
    int written2 = channel.writeAndClose(buf);
    assertThat(written2).isEqualTo(11);
    assertThat(finishWriteOffset.get()).isEqualTo(ctc.length());
  }
}
