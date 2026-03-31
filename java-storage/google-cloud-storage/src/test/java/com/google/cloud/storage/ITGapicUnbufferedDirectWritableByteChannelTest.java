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

import static com.google.cloud.storage.ByteSizeConstants._256KiB;
import static com.google.cloud.storage.ByteSizeConstants._512KiB;
import static com.google.cloud.storage.ByteSizeConstants._768KiB;
import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.core.SettableApiFuture;
import com.google.cloud.storage.Hasher.GuavaHasher;
import com.google.cloud.storage.ITGapicUnbufferedWritableByteChannelTest.DirectWriteService;
import com.google.cloud.storage.WriteCtx.SimpleWriteObjectRequestBuilderFactory;
import com.google.cloud.storage.WriteCtx.WriteObjectRequestBuilderFactory;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.storage.v2.Object;
import com.google.storage.v2.ObjectChecksums;
import com.google.storage.v2.StorageClient;
import com.google.storage.v2.WriteObjectRequest;
import com.google.storage.v2.WriteObjectResponse;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public final class ITGapicUnbufferedDirectWritableByteChannelTest {

  public static final GuavaHasher HASHER = Hasher.enabled();
  private static final ChunkSegmenter CHUNK_SEGMENTER =
      new ChunkSegmenter(HASHER, ByteStringStrategy.copy(), _256KiB, _256KiB);

  /** Attempting to finalize, ack equals expected */
  @Test
  public void ack_eq() throws Exception {
    WriteObjectRequest req1 =
        WriteObjectRequest.newBuilder()
            .setWriteOffset(_256KiB)
            .setObjectChecksums(ObjectChecksums.newBuilder().setCrc32C(0).build())
            .setFinishWrite(true)
            .build();
    WriteObjectResponse resp1 =
        WriteObjectResponse.newBuilder()
            .setResource(Object.newBuilder().setName("name").setSize(_256KiB).build())
            .build();

    ImmutableMap<List<WriteObjectRequest>, WriteObjectResponse> map =
        ImmutableMap.of(ImmutableList.of(req1), resp1);
    DirectWriteService service1 = new DirectWriteService(map);

    try (FakeServer fakeServer = FakeServer.of(service1);
        GrpcStorageImpl storage =
            (GrpcStorageImpl) fakeServer.getGrpcStorageOptions().getService()) {
      StorageClient storageClient = storage.storageClient;

      SettableApiFuture<WriteObjectResponse> done = SettableApiFuture.create();
      WriteCtx<SimpleWriteObjectRequestBuilderFactory> writeCtx =
          WriteCtx.of(WriteObjectRequestBuilderFactory.simple(req1), HASHER);
      writeCtx.getTotalSentBytes().set(_256KiB);
      writeCtx.getConfirmedBytes().set(0);

      GapicUnbufferedDirectWritableByteChannel channel =
          new GapicUnbufferedDirectWritableByteChannel(
              done, CHUNK_SEGMENTER, storageClient.writeObjectCallable(), writeCtx);

      channel.close();

      WriteObjectResponse writeObjectResponse = done.get(2, TimeUnit.SECONDS);
      assertAll(
          () -> assertThat(writeObjectResponse).isEqualTo(resp1),
          () -> assertThat(writeCtx.getConfirmedBytes().get()).isEqualTo(_256KiB),
          () -> assertThat(channel.isOpen()).isFalse());
    }
  }

  /** Attempting to finalize, ack &lt; expected */
  @Test
  public void ack_lt() throws Exception {
    WriteObjectRequest req1 =
        WriteObjectRequest.newBuilder()
            .setWriteOffset(_512KiB)
            .setObjectChecksums(ObjectChecksums.newBuilder().setCrc32C(0).build())
            .setFinishWrite(true)
            .build();
    WriteObjectResponse resp1 =
        WriteObjectResponse.newBuilder()
            .setResource(Object.newBuilder().setName("name").setSize(_256KiB).build())
            .build();

    ImmutableMap<List<WriteObjectRequest>, WriteObjectResponse> map =
        ImmutableMap.of(ImmutableList.of(req1), resp1);
    DirectWriteService service1 = new DirectWriteService(map);

    try (FakeServer fakeServer = FakeServer.of(service1);
        GrpcStorageImpl storage =
            (GrpcStorageImpl) fakeServer.getGrpcStorageOptions().getService()) {
      StorageClient storageClient = storage.storageClient;

      SettableApiFuture<WriteObjectResponse> done = SettableApiFuture.create();
      WriteCtx<SimpleWriteObjectRequestBuilderFactory> writeCtx =
          WriteCtx.of(WriteObjectRequestBuilderFactory.simple(req1), HASHER);
      writeCtx.getTotalSentBytes().set(_512KiB);
      writeCtx.getConfirmedBytes().set(0);

      //noinspection resource
      GapicUnbufferedDirectWritableByteChannel channel =
          new GapicUnbufferedDirectWritableByteChannel(
              done, CHUNK_SEGMENTER, storageClient.writeObjectCallable(), writeCtx);

      StorageException se = assertThrows(StorageException.class, channel::close);
      assertAll(
          () -> assertThat(se.getCode()).isEqualTo(0),
          () -> assertThat(se.getReason()).isEqualTo("dataLoss"),
          () -> assertThat(writeCtx.getConfirmedBytes().get()).isEqualTo(0),
          () -> assertThat(channel.isOpen()).isFalse());
    }
  }

  /** Attempting to finalize, ack &gt; expected */
  @Test
  public void ack_gt() throws Exception {
    WriteObjectRequest req1 =
        WriteObjectRequest.newBuilder()
            .setWriteOffset(_512KiB)
            .setObjectChecksums(ObjectChecksums.newBuilder().setCrc32C(0).build())
            .setFinishWrite(true)
            .build();
    WriteObjectResponse resp1 =
        WriteObjectResponse.newBuilder()
            .setResource(Object.newBuilder().setName("name").setSize(_768KiB).build())
            .build();

    ImmutableMap<List<WriteObjectRequest>, WriteObjectResponse> map =
        ImmutableMap.of(ImmutableList.of(req1), resp1);
    DirectWriteService service1 = new DirectWriteService(map);

    try (FakeServer fakeServer = FakeServer.of(service1);
        GrpcStorageImpl storage =
            (GrpcStorageImpl) fakeServer.getGrpcStorageOptions().getService()) {
      StorageClient storageClient = storage.storageClient;

      SettableApiFuture<WriteObjectResponse> done = SettableApiFuture.create();
      WriteCtx<SimpleWriteObjectRequestBuilderFactory> writeCtx =
          WriteCtx.of(WriteObjectRequestBuilderFactory.simple(req1), HASHER);
      writeCtx.getTotalSentBytes().set(_512KiB);
      writeCtx.getConfirmedBytes().set(0);

      //noinspection resource
      GapicUnbufferedDirectWritableByteChannel channel =
          new GapicUnbufferedDirectWritableByteChannel(
              done, CHUNK_SEGMENTER, storageClient.writeObjectCallable(), writeCtx);

      StorageException se = assertThrows(StorageException.class, channel::close);
      assertAll(
          () -> assertThat(se.getCode()).isEqualTo(0),
          () -> assertThat(se.getReason()).isEqualTo("dataLoss"),
          () -> assertThat(writeCtx.getConfirmedBytes().get()).isEqualTo(0),
          () -> assertThat(channel.isOpen()).isFalse());
    }
  }
}
