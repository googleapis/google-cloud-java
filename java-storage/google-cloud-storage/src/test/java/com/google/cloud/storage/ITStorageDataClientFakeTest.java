/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.storage.ByteSizeConstants._2MiB;
import static com.google.cloud.storage.ITObjectReadSessionFakeTest.getReadRange;
import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.ApiFuture;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.cloud.storage.ITObjectReadSessionFakeTest.FakeStorage;
import com.google.cloud.storage.StorageDataClient.FastOpenObjectReadSession;
import com.google.cloud.storage.ZeroCopySupport.DisposableByteString;
import com.google.cloud.storage.it.ChecksummedTestContent;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.ByteStreams;
import com.google.protobuf.ByteString;
import com.google.storage.v2.BidiReadObjectRequest;
import com.google.storage.v2.BidiReadObjectResponse;
import com.google.storage.v2.BidiReadObjectSpec;
import com.google.storage.v2.BucketName;
import com.google.storage.v2.Object;
import com.google.storage.v2.ObjectRangeData;
import java.io.ByteArrayOutputStream;
import java.nio.channels.Channels;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public final class ITStorageDataClientFakeTest {
  private static final byte[] ALL_OBJECT_BYTES = DataGenerator.base64Characters().genBytes(64);
  private static final Object METADATA =
      Object.newBuilder()
          .setBucket(BucketName.format("_", "b"))
          .setName("o")
          .setGeneration(1)
          .setSize(_2MiB)
          .build();

  @Test
  public void fastOpen_futureBytes() throws Exception {
    doTest(
        ReadProjectionConfigs.asFutureBytes().withRangeSpec(RangeSpec.of(10, 20)),
        f -> f.get(10, TimeUnit.MILLISECONDS));
  }

  @Test
  public void fastOpen_channel() throws Exception {
    doTest(
        ReadProjectionConfigs.asChannel().withRangeSpec(RangeSpec.of(10, 20)),
        c -> {
          ByteArrayOutputStream baos = new ByteArrayOutputStream();
          ByteStreams.copy(c, Channels.newChannel(baos));
          return baos.toByteArray();
        });
  }

  @Test
  public void fastOpen_futureByteString() throws Exception {
    doTest(
        ReadProjectionConfigs.asFutureByteString().withRangeSpec(RangeSpec.of(10, 20)),
        f -> {
          try (DisposableByteString disposableByteString = f.get(10, TimeUnit.MILLISECONDS)) {
            ByteString byteString = disposableByteString.byteString();
            return byteString.toByteArray();
          }
        });
  }

  private <P> void doTest(ReadProjectionConfig<P> config, ThrowableFunction<P, byte[]> func)
      throws Exception {
    ChecksummedTestContent content = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 10, 20);
    ChecksummedTestContent content1 = ChecksummedTestContent.of(content.getBytes(), 0, 10);
    ChecksummedTestContent content2 = ChecksummedTestContent.of(content.getBytes(), 10, 10);

    BidiReadObjectRequest reqOpen =
        BidiReadObjectRequest.newBuilder()
            .setReadObjectSpec(
                BidiReadObjectSpec.newBuilder()
                    .setBucket(METADATA.getBucket())
                    .setObject(METADATA.getName())
                    .build())
            .addReadRanges(getReadRange(1, 10, 20))
            .build();
    BidiReadObjectResponse res2_1 =
        BidiReadObjectResponse.newBuilder()
            .setMetadata(METADATA)
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setChecksummedData(content1.asChecksummedData())
                    .setReadRange(getReadRange(1, 10, content1))
                    .build())
            .build();

    BidiReadObjectResponse res2_2 =
        BidiReadObjectResponse.newBuilder()
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setChecksummedData(content2.asChecksummedData())
                    .setReadRange(getReadRange(1, 20, content2))
                    .setRangeEnd(true)
                    .build())
            .build();
    FakeStorage fake =
        FakeStorage.of(
            ImmutableMap.of(
                reqOpen,
                respond -> {
                  respond.onNext(res2_1);
                  respond.onNext(res2_2);
                }));

    try (FakeServer fakeServer = FakeServer.of(fake);
        GrpcStorageImpl storage =
            (GrpcStorageImpl) fakeServer.getGrpcStorageOptions().getService()) {
      StorageDataClient dataClient = storage.storageDataClient;
      BidiReadObjectRequest req =
          BidiReadObjectRequest.newBuilder()
              .setReadObjectSpec(
                  BidiReadObjectSpec.newBuilder()
                      .setBucket(METADATA.getBucket())
                      .setObject(METADATA.getName())
                      .build())
              .build();

      ApiFuture<FastOpenObjectReadSession<P>> f =
          dataClient.fastOpenReadSession(req, GrpcCallContext.createDefault(), config);
      try (FastOpenObjectReadSession<P> fastOpen = f.get(3, TimeUnit.SECONDS)) {
        byte[] apply = func.apply(fastOpen.getProjection());
        assertThat(xxd(apply)).isEqualTo(xxd(content.getBytes()));
      }
    }
  }

  @FunctionalInterface
  interface ThrowableFunction<From, To> {
    To apply(From from) throws Exception;
  }
}
