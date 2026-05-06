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
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assert.assertThrows;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.cloud.storage.Hasher.GuavaHasher;
import com.google.cloud.storage.ITGapicUnbufferedWritableByteChannelTest.DirectWriteService;
import com.google.cloud.storage.Retrying.RetrierWithAlg;
import com.google.cloud.storage.it.ChecksummedTestContent;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import com.google.storage.v2.ChecksummedData;
import com.google.storage.v2.Object;
import com.google.storage.v2.ObjectChecksums;
import com.google.storage.v2.StartResumableWriteRequest;
import com.google.storage.v2.StartResumableWriteResponse;
import com.google.storage.v2.StorageClient;
import com.google.storage.v2.StorageGrpc.StorageImplBase;
import com.google.storage.v2.WriteObjectRequest;
import com.google.storage.v2.WriteObjectResponse;
import io.grpc.Status.Code;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.junit.Test;

public final class ITGapicUnbufferedChunkedResumableWritableByteChannelTest {

  public static final GuavaHasher HASHER = Hasher.enabled();
  private static final ChunkSegmenter CHUNK_SEGMENTER =
      new ChunkSegmenter(HASHER, ByteStringStrategy.copy(), _256KiB, _256KiB);

  /**
   *
   *
   * <h4>S.1</h4>
   *
   * Attempting to append to a session which has already been finalized should raise an error
   *
   * <table>
   *   <caption></caption>
   *   <tr>
   *     <td>server state</td>
   *     <td><pre>
   * resource = { name = obj, size = 524288 }
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>client state</td>
   *     <td><pre>
   * write_offset = 0, data = [0:262144]
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>request</td>
   *     <td><pre>
   * WriteObjectRequest{ upload_id = $UPLOAD_ID, write_offset= 0, checksummed_data.content.length = 262144 }
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>response</td>
   *     <td><pre>
   * onNext(WriteObjectResponse{ resources = {name = obj, size = 525288 } })
   *     </pre></td>
   *   </tr>
   * </table>
   */
  @Test
  public void scenario1() throws Exception {

    String uploadId = "uploadId";
    WriteObjectRequest req1 =
        WriteObjectRequest.newBuilder()
            .setUploadId(uploadId)
            .setChecksummedData(
                ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(_256KiB))
                    .asChecksummedData())
            .build();
    WriteObjectResponse resp1 =
        WriteObjectResponse.newBuilder()
            .setResource(Object.newBuilder().setName("obj").setSize(_512KiB).build())
            .build();

    ImmutableMap<List<WriteObjectRequest>, WriteObjectResponse> map =
        ImmutableMap.of(ImmutableList.of(req1), resp1);
    DirectWriteService service1 = new DirectWriteService(map);

    try (FakeServer fakeServer = FakeServer.of(service1);
        GrpcStorageImpl storage =
            (GrpcStorageImpl) fakeServer.getGrpcStorageOptions().getService()) {
      StorageClient storageClient = storage.storageClient;

      ResumableWrite resumableWrite = getResumableWrite(uploadId);

      WriteCtx<ResumableWrite> writeCtx = WriteCtx.of(resumableWrite, HASHER);
      SettableApiFuture<WriteObjectResponse> done = SettableApiFuture.create();
      //noinspection resource
      GapicUnbufferedChunkedResumableWritableByteChannel channel =
          new GapicUnbufferedChunkedResumableWritableByteChannel(
              done,
              CHUNK_SEGMENTER,
              storageClient.writeObjectCallable(),
              writeCtx,
              RetrierWithAlg.attemptOnce(),
              GrpcCallContext::createDefault);

      ByteBuffer bb = DataGenerator.base64Characters().genByteBuffer(_256KiB);
      StorageException se = assertThrows(StorageException.class, () -> channel.write(bb));
      assertAll(
          () -> assertThat(se.getCode()).isEqualTo(0),
          () -> assertThat(se.getReason()).isEqualTo("invalid"),
          () -> assertThat(writeCtx.getConfirmedBytes().get()).isEqualTo(0),
          () -> assertThat(channel.isOpen()).isFalse());
    }
  }

  /**
   *
   *
   * <h4>S.2</h4>
   *
   * Attempting to finalize a session with fewer bytes than GCS acknowledges.
   *
   * <table>
   *   <caption></caption>
   *   <tr>
   *     <td>server state</td>
   *     <td><pre>
   * persisted_size = 524288
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>client state</td>
   *     <td><pre>
   * write_offset = 262144, finish = true
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>request</td>
   *     <td><pre>
   * WriteObjectRequest{ upload_id = $UPLOAD_ID, write_offset = 262144, finish_write = true}
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>response</td>
   *     <td><pre>
   * onNext(WriteObjectResponse{ persisted_size = 525288 })
   *     </pre></td>
   *   </tr>
   * </table>
   */
  @Test
  public void scenario2() throws Exception {
    String uploadId = "uploadId";
    WriteObjectRequest req1 =
        WriteObjectRequest.newBuilder()
            .setUploadId(uploadId)
            .setWriteOffset(_256KiB)
            .setObjectChecksums(ObjectChecksums.newBuilder().setCrc32C(0).build())
            .setFinishWrite(true)
            .build();
    WriteObjectResponse resp1 = WriteObjectResponse.newBuilder().setPersistedSize(_512KiB).build();

    ImmutableMap<List<WriteObjectRequest>, WriteObjectResponse> map =
        ImmutableMap.of(ImmutableList.of(req1), resp1);
    DirectWriteService service1 = new DirectWriteService(map);

    try (FakeServer fakeServer = FakeServer.of(service1);
        GrpcStorageImpl storage =
            (GrpcStorageImpl) fakeServer.getGrpcStorageOptions().getService()) {
      StorageClient storageClient = storage.storageClient;

      SettableApiFuture<WriteObjectResponse> done = SettableApiFuture.create();
      ResumableWrite resumableWrite = getResumableWrite(uploadId);
      WriteCtx<ResumableWrite> writeCtx = WriteCtx.of(resumableWrite, HASHER);
      writeCtx.getTotalSentBytes().set(_256KiB);
      writeCtx.getConfirmedBytes().set(_256KiB);

      //noinspection resource
      GapicUnbufferedChunkedResumableWritableByteChannel channel =
          new GapicUnbufferedChunkedResumableWritableByteChannel(
              done,
              CHUNK_SEGMENTER,
              storageClient.writeObjectCallable(),
              writeCtx,
              RetrierWithAlg.attemptOnce(),
              GrpcCallContext::createDefault);

      StorageException se = assertThrows(StorageException.class, channel::close);
      assertAll(
          () -> assertThat(se.getCode()).isEqualTo(0),
          () -> assertThat(se.getReason()).isEqualTo("invalid"),
          () -> assertThat(writeCtx.getConfirmedBytes().get()).isEqualTo(_256KiB),
          () -> assertThat(channel.isOpen()).isFalse());
    }
  }

  /**
   *
   *
   * <h4>S.3</h4>
   *
   * Attempting to finalize a session with more bytes than GCS acknowledges.
   *
   * <table>
   *   <caption></caption>
   *   <tr>
   *     <td>server state</td>
   *     <td><pre>
   * persisted_size = 262144
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>client state</td>
   *     <td><pre>
   * write_offset = 524288, finish = true
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>request</td>
   *     <td><pre>
   * WriteObjectRequest{ upload_id = $UPLOAD_ID, write_offset = 524288, finish_write = true}
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>response</td>
   *     <td><pre>
   * onNext(WriteObjectResponse{ persisted_size = 262144 })
   *     </pre></td>
   *   </tr>
   * </table>
   */
  @Test
  public void scenario3() throws Exception {
    String uploadId = "uploadId";
    WriteObjectRequest req1 =
        WriteObjectRequest.newBuilder()
            .setUploadId(uploadId)
            .setWriteOffset(_512KiB)
            .setObjectChecksums(ObjectChecksums.newBuilder().setCrc32C(0).build())
            .setFinishWrite(true)
            .build();
    WriteObjectResponse resp1 = WriteObjectResponse.newBuilder().setPersistedSize(_256KiB).build();

    ImmutableMap<List<WriteObjectRequest>, WriteObjectResponse> map =
        ImmutableMap.of(ImmutableList.of(req1), resp1);
    DirectWriteService service1 = new DirectWriteService(map);

    try (FakeServer fakeServer = FakeServer.of(service1);
        GrpcStorageImpl storage =
            (GrpcStorageImpl) fakeServer.getGrpcStorageOptions().getService()) {
      StorageClient storageClient = storage.storageClient;

      SettableApiFuture<WriteObjectResponse> done = SettableApiFuture.create();
      ResumableWrite resumableWrite = getResumableWrite(uploadId);
      WriteCtx<ResumableWrite> writeCtx = WriteCtx.of(resumableWrite, HASHER);
      writeCtx.getTotalSentBytes().set(_512KiB);
      writeCtx.getConfirmedBytes().set(_512KiB);

      //noinspection resource
      GapicUnbufferedChunkedResumableWritableByteChannel channel =
          new GapicUnbufferedChunkedResumableWritableByteChannel(
              done,
              CHUNK_SEGMENTER,
              storageClient.writeObjectCallable(),
              writeCtx,
              RetrierWithAlg.attemptOnce(),
              GrpcCallContext::createDefault);

      StorageException se = assertThrows(StorageException.class, channel::close);
      assertAll(
          () -> assertThat(se.getCode()).isEqualTo(0),
          () -> assertThat(se.getReason()).isEqualTo("dataLoss"),
          () -> assertThat(writeCtx.getConfirmedBytes().get()).isEqualTo(_512KiB),
          () -> assertThat(channel.isOpen()).isFalse());
    }
  }

  /**
   *
   *
   * <h4>S.4</h4>
   *
   * Attempting to finalize an already finalized session
   *
   * <table>
   *   <caption></caption>
   *   <tr>
   *     <td>server state</td>
   *     <td><pre>
   * resource = {name = obj1, size = 262144}
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>client state</td>
   *     <td><pre>
   * write_offset = 262144, finish = true
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>request</td>
   *     <td><pre>
   * WriteObjectRequest{ upload_id = $UPLOAD_ID, write_offset = 262144, finish_write = true}
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>response</td>
   *     <td><pre>
   * onNext(WriteObjectResponse{ resources = {name = obj, size = 262144 } })
   *     </pre></td>
   *   </tr>
   * </table>
   */
  @Test
  public void scenario4() throws Exception {
    String uploadId = "uploadId";
    WriteObjectRequest req1 =
        WriteObjectRequest.newBuilder()
            .setUploadId(uploadId)
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
      ResumableWrite resumableWrite = getResumableWrite(uploadId);
      WriteCtx<ResumableWrite> writeCtx = WriteCtx.of(resumableWrite, HASHER);
      writeCtx.getTotalSentBytes().set(_256KiB);
      writeCtx.getConfirmedBytes().set(_256KiB);

      GapicUnbufferedChunkedResumableWritableByteChannel channel =
          new GapicUnbufferedChunkedResumableWritableByteChannel(
              done,
              CHUNK_SEGMENTER,
              storageClient.writeObjectCallable(),
              writeCtx,
              RetrierWithAlg.attemptOnce(),
              GrpcCallContext::createDefault);

      channel.close();

      WriteObjectResponse writeObjectResponse = done.get(2, TimeUnit.SECONDS);
      assertThat(writeObjectResponse).isEqualTo(resp1);
    }
  }

  /**
   *
   *
   * <h4>S.4.1</h4>
   *
   * Attempting to finalize an already finalized session (ack &lt; expected)
   *
   * <table>
   *   <caption></caption>
   *   <tr>
   *     <td>server state</td>
   *     <td><pre>
   * resource = {name = obj1, size = 262144}
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>client state</td>
   *     <td><pre>
   * write_offset = 524288, finish = true
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>request</td>
   *     <td><pre>
   * WriteObjectRequest{ upload_id = $UPLOAD_ID, write_offset = 524288, finish_write = true}
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>response</td>
   *     <td><pre>
   * onNext(WriteObjectResponse{ resources = {name = obj, size = 262144 } })
   *     </pre></td>
   *   </tr>
   * </table>
   */
  @Test
  public void scenario4_1() throws Exception {
    String uploadId = "uploadId";
    WriteObjectRequest req1 =
        WriteObjectRequest.newBuilder()
            .setUploadId(uploadId)
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
      ResumableWrite resumableWrite = getResumableWrite(uploadId);
      WriteCtx<ResumableWrite> writeCtx = WriteCtx.of(resumableWrite, HASHER);
      writeCtx.getTotalSentBytes().set(_512KiB);
      writeCtx.getConfirmedBytes().set(_512KiB);

      //noinspection resource
      GapicUnbufferedChunkedResumableWritableByteChannel channel =
          new GapicUnbufferedChunkedResumableWritableByteChannel(
              done,
              CHUNK_SEGMENTER,
              storageClient.writeObjectCallable(),
              writeCtx,
              RetrierWithAlg.attemptOnce(),
              GrpcCallContext::createDefault);

      StorageException se = assertThrows(StorageException.class, channel::close);
      assertAll(
          () -> assertThat(se.getCode()).isEqualTo(0),
          () -> assertThat(se.getReason()).isEqualTo("dataLoss"),
          () -> assertThat(writeCtx.getConfirmedBytes().get()).isEqualTo(_512KiB),
          () -> assertThat(channel.isOpen()).isFalse());
    }
  }

  /**
   *
   *
   * <h4>S.4.2</h4>
   *
   * Attempting to finalize an already finalized session (ack > expected)
   *
   * <table>
   *   <caption></caption>
   *   <tr>
   *     <td>server state</td>
   *     <td><pre>
   * resource = {name = obj1, size = 786432}
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>client state</td>
   *     <td><pre>
   * write_offset = 524288, finish = true
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>request</td>
   *     <td><pre>
   * WriteObjectRequest{ upload_id = $UPLOAD_ID, write_offset = 524288, finish_write = true}
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>response</td>
   *     <td><pre>
   * onNext(WriteObjectResponse{ resources = {name = obj, size = 786432 } })
   *     </pre></td>
   *   </tr>
   * </table>
   */
  @Test
  public void scenario4_2() throws Exception {
    String uploadId = "uploadId";
    WriteObjectRequest req1 =
        WriteObjectRequest.newBuilder()
            .setUploadId(uploadId)
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
      ResumableWrite resumableWrite = getResumableWrite(uploadId);
      WriteCtx<ResumableWrite> writeCtx = WriteCtx.of(resumableWrite, HASHER);
      writeCtx.getTotalSentBytes().set(_512KiB);
      writeCtx.getConfirmedBytes().set(_512KiB);

      //noinspection resource
      GapicUnbufferedChunkedResumableWritableByteChannel channel =
          new GapicUnbufferedChunkedResumableWritableByteChannel(
              done,
              CHUNK_SEGMENTER,
              storageClient.writeObjectCallable(),
              writeCtx,
              RetrierWithAlg.attemptOnce(),
              GrpcCallContext::createDefault);

      StorageException se = assertThrows(StorageException.class, channel::close);
      assertAll(
          () -> assertThat(se.getCode()).isEqualTo(0),
          () -> assertThat(se.getReason()).isEqualTo("dataLoss"),
          () -> assertThat(writeCtx.getConfirmedBytes().get()).isEqualTo(_512KiB),
          () -> assertThat(channel.isOpen()).isFalse());
    }
  }

  /**
   *
   *
   * <h4>S.5</h4>
   *
   * Attempt to append to a resumable session with an offset higher than GCS expects
   *
   * <table>
   *   <caption></caption>
   *   <tr>
   *     <td>server state</td>
   *     <td><pre>
   * persisted_size = 0
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>client state</td>
   *     <td><pre>
   * write_offset = 262144, data = [262144:524288]
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>request</td>
   *     <td><pre>
   * WriteObjectRequest{ upload_id = $UPLOAD_ID, write_offset = 262144, checksummed_data.content.length = 262144}
   *     </pre></td>
   *   </tr>
   *   <tr>
   *     <td>response</td>
   *     <td><pre>
   * onError(Status{code=OUT_OF_RANGE, description="Upload request started at offset '262144', which is past expected offset '0'."})
   *     </pre></td>
   *   </tr>
   * </table>
   */
  @Test
  public void scenario5() throws Exception {
    String uploadId = "uploadId";
    WriteObjectRequest req1 =
        WriteObjectRequest.newBuilder()
            .setUploadId(uploadId)
            .setWriteOffset(_256KiB)
            .setChecksummedData(
                ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(_256KiB))
                    .asChecksummedData())
            .build();
    StorageImplBase service1 =
        new DirectWriteService(
            (obs, requests) -> {
              if (requests.equals(ImmutableList.of(req1))) {
                obs.onError(
                    TestUtils.apiException(
                        Code.OUT_OF_RANGE,
                        "Upload request started at offset '262144', which is past expected offset"
                            + " '0'."));
              } else {
                obs.onError(
                    TestUtils.apiException(Code.PERMISSION_DENIED, "Unexpected request chain."));
              }
            });
    try (FakeServer fakeServer = FakeServer.of(service1);
        GrpcStorageImpl storage =
            (GrpcStorageImpl) fakeServer.getGrpcStorageOptions().getService()) {
      StorageClient storageClient = storage.storageClient;

      SettableApiFuture<WriteObjectResponse> done = SettableApiFuture.create();
      ResumableWrite resumableWrite = getResumableWrite(uploadId);
      WriteCtx<ResumableWrite> writeCtx = WriteCtx.of(resumableWrite, HASHER);
      writeCtx.getTotalSentBytes().set(_256KiB);
      writeCtx.getConfirmedBytes().set(_256KiB);

      //noinspection resource
      GapicUnbufferedChunkedResumableWritableByteChannel channel =
          new GapicUnbufferedChunkedResumableWritableByteChannel(
              done,
              CHUNK_SEGMENTER,
              storageClient.writeObjectCallable(),
              writeCtx,
              RetrierWithAlg.attemptOnce(),
              GrpcCallContext::createDefault);

      ByteBuffer bb = DataGenerator.base64Characters().genByteBuffer(_256KiB);
      StorageException se = assertThrows(StorageException.class, () -> channel.write(bb));
      assertAll(
          () -> assertThat(se.getCode()).isEqualTo(0),
          () -> assertThat(se.getReason()).isEqualTo("dataLoss"),
          () -> assertThat(writeCtx.getConfirmedBytes().get()).isEqualTo(_256KiB),
          () -> assertThat(channel.isOpen()).isFalse());
    }
  }

  /**
   *
   *
   * <h4>S.7</h4>
   *
   * GCS Acknowledges more bytes than were sent in the PUT
   *
   * <p>The client believes the server offset is N, it sends K bytes and the server responds that N
   * + 2K bytes are now committed.
   *
   * <p>The client has detected data loss and should raise an error and prevent sending of more
   * bytes.
   */
  @Test
  public void scenario7() throws Exception {

    String uploadId = "uploadId";
    WriteObjectRequest req1 =
        WriteObjectRequest.newBuilder()
            .setUploadId(uploadId)
            .setChecksummedData(
                ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(_256KiB))
                    .asChecksummedData())
            .build();
    WriteObjectResponse resp1 = WriteObjectResponse.newBuilder().setPersistedSize(_512KiB).build();

    ImmutableMap<List<WriteObjectRequest>, WriteObjectResponse> map =
        ImmutableMap.of(ImmutableList.of(req1), resp1);
    DirectWriteService service1 = new DirectWriteService(map);

    try (FakeServer fakeServer = FakeServer.of(service1);
        GrpcStorageImpl storage =
            (GrpcStorageImpl) fakeServer.getGrpcStorageOptions().getService()) {
      StorageClient storageClient = storage.storageClient;

      SettableApiFuture<WriteObjectResponse> done = SettableApiFuture.create();
      ResumableWrite resumableWrite = getResumableWrite(uploadId);
      WriteCtx<ResumableWrite> writeCtx = WriteCtx.of(resumableWrite, HASHER);

      //noinspection resource
      GapicUnbufferedChunkedResumableWritableByteChannel channel =
          new GapicUnbufferedChunkedResumableWritableByteChannel(
              done,
              CHUNK_SEGMENTER,
              storageClient.writeObjectCallable(),
              writeCtx,
              RetrierWithAlg.attemptOnce(),
              GrpcCallContext::createDefault);

      ByteBuffer buf = DataGenerator.base64Characters().genByteBuffer(_256KiB);
      StorageException se = assertThrows(StorageException.class, () -> channel.write(buf));
      assertAll(
          () -> assertThat(se.getCode()).isEqualTo(0),
          () -> assertThat(se.getReason()).isEqualTo("dataLoss"),
          () -> assertThat(writeCtx.getConfirmedBytes().get()).isEqualTo(0),
          () -> assertThat(channel.isOpen()).isFalse());
    }
  }

  @Test
  public void incremental_success() throws Exception {
    String uploadId = "uploadId";
    WriteObjectRequest req1 =
        WriteObjectRequest.newBuilder()
            .setUploadId(uploadId)
            .setChecksummedData(
                ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(_256KiB))
                    .asChecksummedData())
            .build();
    WriteObjectResponse resp1 = WriteObjectResponse.newBuilder().setPersistedSize(_256KiB).build();

    ImmutableMap<List<WriteObjectRequest>, WriteObjectResponse> map =
        ImmutableMap.of(ImmutableList.of(req1), resp1);
    DirectWriteService service1 = new DirectWriteService(map);

    try (FakeServer fakeServer = FakeServer.of(service1);
        GrpcStorageImpl storage =
            (GrpcStorageImpl) fakeServer.getGrpcStorageOptions().getService()) {
      StorageClient storageClient = storage.storageClient;

      SettableApiFuture<WriteObjectResponse> done = SettableApiFuture.create();
      ResumableWrite resumableWrite = getResumableWrite(uploadId);
      WriteCtx<ResumableWrite> writeCtx = WriteCtx.of(resumableWrite, HASHER);

      //noinspection resource
      GapicUnbufferedChunkedResumableWritableByteChannel channel =
          new GapicUnbufferedChunkedResumableWritableByteChannel(
              done,
              CHUNK_SEGMENTER,
              storageClient.writeObjectCallable(),
              writeCtx,
              RetrierWithAlg.attemptOnce(),
              GrpcCallContext::createDefault);

      ByteBuffer buf = DataGenerator.base64Characters().genByteBuffer(_256KiB);
      int written = channel.write(buf);
      assertAll(
          () -> assertThat(buf.remaining()).isEqualTo(0),
          () -> assertThat(written).isEqualTo(_256KiB),
          () -> assertThat(writeCtx.getTotalSentBytes().get()).isEqualTo(_256KiB),
          () -> assertThat(writeCtx.getConfirmedBytes().get()).isEqualTo(_256KiB));
    }
  }

  @Test
  public void incremental_partialSuccess() throws Exception {
    String uploadId = "uploadId";
    WriteObjectRequest req1 =
        WriteObjectRequest.newBuilder()
            .setUploadId(uploadId)
            .setChecksummedData(
                ChecksummedData.newBuilder()
                    .setContent(
                        ByteString.copyFrom(DataGenerator.base64Characters().genBytes(_512KiB)))
                    .build())
            .build();
    WriteObjectResponse resp1 = WriteObjectResponse.newBuilder().setPersistedSize(_256KiB).build();

    ImmutableMap<List<WriteObjectRequest>, WriteObjectResponse> map =
        ImmutableMap.of(ImmutableList.of(req1), resp1);
    DirectWriteService service1 = new DirectWriteService(map);

    try (FakeServer fakeServer = FakeServer.of(service1);
        GrpcStorageImpl storage =
            (GrpcStorageImpl) fakeServer.getGrpcStorageOptions().getService()) {
      StorageClient storageClient = storage.storageClient;

      SettableApiFuture<WriteObjectResponse> done = SettableApiFuture.create();
      ResumableWrite resumableWrite = getResumableWrite(uploadId);
      WriteCtx<ResumableWrite> writeCtx = WriteCtx.of(resumableWrite, HASHER);

      ChunkSegmenter chunkSegmenter =
          new ChunkSegmenter(Hasher.noop(), ByteStringStrategy.copy(), _512KiB, _256KiB);
      //noinspection resource
      GapicUnbufferedChunkedResumableWritableByteChannel channel =
          new GapicUnbufferedChunkedResumableWritableByteChannel(
              done,
              chunkSegmenter,
              storageClient.writeObjectCallable(),
              writeCtx,
              RetrierWithAlg.attemptOnce(),
              GrpcCallContext::createDefault);

      ByteBuffer buf = DataGenerator.base64Characters().genByteBuffer(_512KiB);
      int written = channel.write(buf);
      assertAll(
          () -> assertThat(buf.remaining()).isEqualTo(_256KiB),
          () -> assertThat(written).isEqualTo(_256KiB),
          () ->
              assertWithMessage("totalSentBytes")
                  .that(writeCtx.getTotalSentBytes().get())
                  .isEqualTo(_256KiB),
          () ->
              assertWithMessage("confirmedBytes")
                  .that(writeCtx.getConfirmedBytes().get())
                  .isEqualTo(_256KiB));
    }
  }

  private static @NonNull ResumableWrite getResumableWrite(String uploadId) {
    StartResumableWriteRequest req = StartResumableWriteRequest.getDefaultInstance();
    StartResumableWriteResponse resp =
        StartResumableWriteResponse.newBuilder().setUploadId(uploadId).build();
    return new ResumableWrite(
        req, resp, id -> WriteObjectRequest.newBuilder().setUploadId(id).build());
  }
}
