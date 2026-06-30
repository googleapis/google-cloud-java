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

import static com.google.cloud.storage.TestUtils.getChecksummedData;
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.ReadChannel;
import com.google.cloud.storage.GrpcUtils.ZeroCopyServerStreamingCallable;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.UnbufferedReadableByteChannelSession.UnbufferedReadableByteChannel;
import com.google.common.io.ByteStreams;
import com.google.protobuf.ByteString;
import com.google.storage.v2.Object;
import com.google.storage.v2.ReadObjectRequest;
import com.google.storage.v2.ReadObjectResponse;
import com.google.storage.v2.StorageClient;
import com.google.storage.v2.StorageGrpc;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.security.SecureRandom;
import java.util.concurrent.ExecutionException;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class ITGzipReadableByteChannelTest {

  @SuppressWarnings("PointlessArithmeticExpression")
  private static final int _1KiB = 1 * 1024;

  private static final int _2KiB = 2 * 1024;
  private static final int _3KiB = _1KiB + _2KiB;
  private static final SecureRandom rand = new SecureRandom();

  private static final byte[] dataUncompressed = DataGenerator.rand(rand).genBytes(_3KiB);
  private static final byte[] dataCompressed = TestUtils.gzipBytes(dataUncompressed);
  private static final ByteString contentUncompressed1 =
      ByteString.copyFrom(dataUncompressed, 0, _2KiB);
  private static final ByteString contentUncompressed2 =
      ByteString.copyFrom(dataUncompressed, _2KiB, _1KiB);
  private static final ByteString contentCompressed1 =
      ByteString.copyFrom(dataCompressed, 0, _2KiB);
  private static final ByteString contentCompressed2 =
      ByteString.copyFrom(dataCompressed, _2KiB, dataCompressed.length - _2KiB);
  private static final ReadObjectRequest reqUncompressed =
      ReadObjectRequest.newBuilder()
          .setBucket("projects/_/buckets/buck")
          .setObject("obj-uncompressed")
          .build();
  private static final ReadObjectRequest reqCompressed =
      ReadObjectRequest.newBuilder()
          .setBucket("projects/_/buckets/buck")
          .setObject("obj-compressed")
          .build();

  private static final ReadObjectResponse respUncompressed1 =
      ReadObjectResponse.newBuilder()
          .setMetadata(Object.newBuilder().setContentEncoding("identity").build())
          .setChecksummedData(getChecksummedData(contentUncompressed1))
          .build();
  private static final ReadObjectResponse respUncompressed2 =
      ReadObjectResponse.newBuilder()
          .setChecksummedData(getChecksummedData(contentUncompressed2))
          .build();

  private static final ReadObjectResponse respCompressed1 =
      ReadObjectResponse.newBuilder()
          .setMetadata(Object.newBuilder().setContentEncoding("gzip").build())
          .setChecksummedData(getChecksummedData(contentCompressed1))
          .build();
  private static final ReadObjectResponse respCompressed2 =
      ReadObjectResponse.newBuilder()
          .setChecksummedData(getChecksummedData(contentCompressed2))
          .build();

  public static final class Uncompressed {
    private static final StorageGrpc.StorageImplBase fakeStorage =
        new StorageGrpc.StorageImplBase() {
          @Override
          public void readObject(
              ReadObjectRequest request, StreamObserver<ReadObjectResponse> responseObserver) {
            if (request.equals(reqUncompressed)) {
              responseObserver.onNext(respUncompressed1);
              responseObserver.onNext(respUncompressed2);
              responseObserver.onCompleted();
            } else {
              responseObserver.onError(TestUtils.apiException(Status.Code.UNIMPLEMENTED));
            }
          }
        };

    @ClassRule(order = 1)
    public static final AutoClosableFixture<FakeServer> fakeServer =
        AutoClosableFixture.of(() -> FakeServer.of(fakeStorage));

    @ClassRule(order = 2)
    public static final AutoClosableFixture<StorageClient> storageClient =
        AutoClosableFixture.of(
            () -> StorageClient.create(fakeServer.getInstance().storageSettings()));

    @Test
    public void autoGzipDecompress_true() throws IOException {
      UnbufferedReadableByteChannelSession<Object> session =
          ResumableMedia.gapic()
              .read()
              .byteChannel(
                  new ZeroCopyServerStreamingCallable<>(
                      storageClient.getInstance().readObjectCallable(),
                      ResponseContentLifecycleManager.noop()),
                  TestUtils.retrierFromStorageOptions(
                      fakeServer.getInstance().getGrpcStorageOptions()),
                  StorageRetryStrategy.getDefaultStorageRetryStrategy().getIdempotentHandler())
              .setHasher(Hasher.noop())
              .setAutoGzipDecompression(true)
              .unbuffered()
              .setReadObjectRequest(reqUncompressed)
              .build();

      byte[] actualBytes = new byte[dataUncompressed.length];
      try (UnbufferedReadableByteChannel c = session.open()) {
        c.read(ByteBuffer.wrap(actualBytes));
      }
      assertThat(actualBytes).isEqualTo(dataUncompressed);
    }

    @Test
    public void autoGzipDecompress_false() throws IOException {
      UnbufferedReadableByteChannelSession<Object> session =
          ResumableMedia.gapic()
              .read()
              .byteChannel(
                  new ZeroCopyServerStreamingCallable<>(
                      storageClient.getInstance().readObjectCallable(),
                      ResponseContentLifecycleManager.noop()),
                  TestUtils.retrierFromStorageOptions(
                      fakeServer.getInstance().getGrpcStorageOptions()),
                  StorageRetryStrategy.getDefaultStorageRetryStrategy().getIdempotentHandler())
              .setHasher(Hasher.noop())
              .setAutoGzipDecompression(false)
              .unbuffered()
              .setReadObjectRequest(reqUncompressed)
              .build();

      byte[] actualBytes = new byte[dataUncompressed.length];
      try (UnbufferedReadableByteChannel c = session.open()) {
        c.read(ByteBuffer.wrap(actualBytes));
      }
      assertThat(actualBytes).isEqualTo(dataUncompressed);
    }
  }

  public static final class Compressed {

    private static final StorageGrpc.StorageImplBase fakeStorage =
        new StorageGrpc.StorageImplBase() {
          @Override
          public void readObject(
              ReadObjectRequest request, StreamObserver<ReadObjectResponse> responseObserver) {
            if (request.equals(reqCompressed)) {
              responseObserver.onNext(respCompressed1);
              responseObserver.onNext(respCompressed2);
              responseObserver.onCompleted();
            } else {
              responseObserver.onError(TestUtils.apiException(Status.Code.UNIMPLEMENTED));
            }
          }
        };

    @ClassRule(order = 1)
    public static final AutoClosableFixture<FakeServer> fakeServer =
        AutoClosableFixture.of(() -> FakeServer.of(fakeStorage));

    @ClassRule(order = 2)
    public static final AutoClosableFixture<StorageClient> storageClient =
        AutoClosableFixture.of(
            () -> StorageClient.create(fakeServer.getInstance().storageSettings()));

    @ClassRule(order = 3)
    public static final AutoClosableFixture<Storage> storageFixture =
        AutoClosableFixture.of(() -> fakeServer.getInstance().getGrpcStorageOptions().getService());

    @Test
    public void autoGzipDecompress_true() throws IOException {
      UnbufferedReadableByteChannelSession<Object> session =
          ResumableMedia.gapic()
              .read()
              .byteChannel(
                  new ZeroCopyServerStreamingCallable<>(
                      storageClient.getInstance().readObjectCallable(),
                      ResponseContentLifecycleManager.noop()),
                  TestUtils.retrierFromStorageOptions(
                      fakeServer.getInstance().getGrpcStorageOptions()),
                  StorageRetryStrategy.getDefaultStorageRetryStrategy().getIdempotentHandler())
              .setHasher(Hasher.noop())
              .setAutoGzipDecompression(true)
              .unbuffered()
              .setReadObjectRequest(reqCompressed)
              .build();

      byte[] actualBytes = new byte[dataUncompressed.length];
      try (UnbufferedReadableByteChannel c = session.open()) {
        c.read(ByteBuffer.wrap(actualBytes));
      }
      assertThat(actualBytes).isEqualTo(dataUncompressed);
    }

    @Test
    public void autoGzipDecompress_false() throws IOException {
      UnbufferedReadableByteChannelSession<Object> session =
          ResumableMedia.gapic()
              .read()
              .byteChannel(
                  new ZeroCopyServerStreamingCallable<>(
                      storageClient.getInstance().readObjectCallable(),
                      ResponseContentLifecycleManager.noop()),
                  TestUtils.retrierFromStorageOptions(
                      fakeServer.getInstance().getGrpcStorageOptions()),
                  StorageRetryStrategy.getDefaultStorageRetryStrategy().getIdempotentHandler())
              .setHasher(Hasher.noop())
              .setAutoGzipDecompression(false)
              .unbuffered()
              .setReadObjectRequest(reqCompressed)
              .build();

      byte[] actualBytes = new byte[dataCompressed.length];
      try (UnbufferedReadableByteChannel c = session.open()) {
        c.read(ByteBuffer.wrap(actualBytes));
      }
      assertThat(actualBytes).isEqualTo(dataCompressed);
    }

    @Test
    public void autoGzipDecompress_default_disabled() throws IOException {
      UnbufferedReadableByteChannelSession<Object> session =
          ResumableMedia.gapic()
              .read()
              .byteChannel(
                  new ZeroCopyServerStreamingCallable<>(
                      storageClient.getInstance().readObjectCallable(),
                      ResponseContentLifecycleManager.noop()),
                  TestUtils.retrierFromStorageOptions(
                      fakeServer.getInstance().getGrpcStorageOptions()),
                  StorageRetryStrategy.getDefaultStorageRetryStrategy().getIdempotentHandler())
              .setHasher(Hasher.noop())
              .unbuffered()
              .setReadObjectRequest(reqCompressed)
              .build();

      byte[] actualBytes = new byte[dataCompressed.length];
      try (UnbufferedReadableByteChannel c = session.open()) {
        c.read(ByteBuffer.wrap(actualBytes));
      }
      assertThat(actualBytes).isEqualTo(dataCompressed);
    }

    @Test
    public void storage_readAllBytes_defaultCompressed() {
      Storage s = storageFixture.getInstance();
      byte[] actual = s.readAllBytes(BlobId.of("buck", "obj-compressed"));
      assertThat(actual).isEqualTo(dataCompressed);
    }

    @Test
    public void storage_readAllBytes_returnRawInputStream_true() {
      Storage s = storageFixture.getInstance();
      byte[] actual =
          s.readAllBytes(
              BlobId.of("buck", "obj-compressed"),
              BlobSourceOption.shouldReturnRawInputStream(true));
      assertThat(actual).isEqualTo(dataCompressed);
    }

    @Test
    public void storage_reader_defaultCompressed() throws Exception {
      Storage s = storageFixture.getInstance();
      byte[] actual = new byte[dataCompressed.length];
      try (ReadChannel c = s.reader(BlobId.of("buck", "obj-compressed"))) {
        c.read(ByteBuffer.wrap(actual));
      }
      assertThat(actual).isEqualTo(dataCompressed);
    }

    @Test
    public void storage_reader_returnRawInputStream_true() throws Exception {
      Storage s = storageFixture.getInstance();
      byte[] actual = new byte[dataCompressed.length];
      try (ReadChannel c =
          s.reader(
              BlobId.of("buck", "obj-compressed"),
              BlobSourceOption.shouldReturnRawInputStream(true))) {
        c.read(ByteBuffer.wrap(actual));
      }
      assertThat(actual).isEqualTo(dataCompressed);
    }
  }

  public static final class Behavior {

    @Test
    public void properlyTracksEOF() throws IOException, InterruptedException, ExecutionException {
      final StorageGrpc.StorageImplBase fakeStorage =
          new StorageGrpc.StorageImplBase() {
            int count = 0;

            @Override
            public void readObject(
                ReadObjectRequest request, StreamObserver<ReadObjectResponse> responseObserver) {
              if (count++ == 0) {
                responseObserver.onNext(
                    ReadObjectResponse.newBuilder()
                        .setMetadata(Object.newBuilder().setSize(1).build())
                        .setChecksummedData(getChecksummedData(ByteString.copyFromUtf8("a")))
                        .build());
                responseObserver.onCompleted();
              } else {
                responseObserver.onError(TestUtils.apiException(Status.Code.UNIMPLEMENTED));
              }
            }
          };

      try (FakeServer fakeServer = FakeServer.of(fakeStorage);
          StorageClient sc = StorageClient.create(fakeServer.storageSettings())) {
        ReadableByteChannelSession<?, Object> session =
            ResumableMedia.gapic()
                .read()
                .byteChannel(
                    new ZeroCopyServerStreamingCallable<>(
                        sc.readObjectCallable(), ResponseContentLifecycleManager.noop()),
                    TestUtils.retrierFromStorageOptions(fakeServer.getGrpcStorageOptions()),
                    StorageRetryStrategy.getDefaultStorageRetryStrategy().getIdempotentHandler())
                .setHasher(Hasher.noop())
                .setAutoGzipDecompression(true)
                .unbuffered()
                .setReadObjectRequest(reqUncompressed)
                .build();

        byte[] expected = new byte[] {(byte) 'a'};
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ReadableByteChannel c = session.open()) {
          ByteStreams.copy(c, Channels.newChannel(baos));
        }
        byte[] actual = baos.toByteArray();
        assertThat(actual).isEqualTo(expected);
        assertThat(session.getResult().get()).isNotNull();
      }
    }
  }
}
