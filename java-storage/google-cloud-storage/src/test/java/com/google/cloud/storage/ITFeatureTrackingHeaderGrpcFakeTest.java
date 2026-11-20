/*
 * Copyright 2026 Google LLC
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
import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.BufferAllocationStrategy;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.ExecutorSupplier;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.PartCleanupStrategy;
import com.google.cloud.storage.it.AssertRequestHeaders.FilteringPolicy;
import com.google.cloud.storage.it.GrpcRequestAuditing;
import com.google.common.hash.Hashing;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.storage.v2.ComposeObjectRequest;
import com.google.storage.v2.ComposeObjectRequest.SourceObject;
import com.google.storage.v2.DeleteObjectRequest;
import com.google.storage.v2.Object;
import com.google.storage.v2.ObjectChecksums;
import com.google.storage.v2.StartResumableWriteRequest;
import com.google.storage.v2.StartResumableWriteResponse;
import com.google.storage.v2.StorageGrpc.StorageImplBase;
import com.google.storage.v2.WriteObjectRequest;
import com.google.storage.v2.WriteObjectResponse;
import com.google.storage.v2.WriteObjectSpec;
import io.grpc.Status.Code;
import io.grpc.stub.StreamObserver;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * End-to-end verification, against an in-process fake gRPC server, that a parallel composite upload
 * reports {@link TrackedFeature#PCU} on every RPC it issues, and that a default write session
 * reports nothing.
 */
public final class ITFeatureTrackingHeaderGrpcFakeTest {

  private static final String BUCKET = "projects/_/buckets/b";

  /** URL-safe base64 of a mask with only {@link TrackedFeature#PCU} (bit 0) set. */
  private static final String PCU_HEADER_VALUE = "AAAAAQ==";

  private static final byte[] CONTENT = DataGenerator.base64Characters().genBytes(3 * _256KiB);

  private ExecutorService exec;

  @Before
  public void setUp() {
    exec = Executors.newCachedThreadPool();
  }

  @After
  public void tearDown() {
    exec.shutdownNow();
  }

  @Test
  public void pcuSession_everyRpcCarriesFeatureTrackingHeader() throws Exception {
    InMemoryStorage fake = new InMemoryStorage();
    GrpcRequestAuditing requestAuditing = new GrpcRequestAuditing();
    ParallelCompositeUploadBlobWriteSessionConfig pcu =
        BlobWriteSessionConfigs.parallelCompositeUpload()
            .withExecutorSupplier(ExecutorSupplier.useExecutor(exec))
            // 3 parts of 256KiB each
            .withBufferAllocationStrategy(BufferAllocationStrategy.simple(_256KiB))
            .withPartCleanupStrategy(PartCleanupStrategy.always());

    try (FakeServer fakeServer = FakeServer.of(fake);
        Storage storage =
            fakeServer.getGrpcStorageOptions().toBuilder()
                .setRetrySettings(RetrySettings.newBuilder().setMaxAttempts(1).build())
                .setBlobWriteSessionConfig(pcu)
                .setGrpcInterceptorProvider(requestAuditing)
                .build()
                .getService()) {

      BlobInfo result = write(storage, BlobInfo.newBuilder("b", "o").build());

      int rpcCount = fake.rpcCount();
      assertAll(
          () -> assertThat(fake.writeCount.get()).isEqualTo(3),
          () -> assertThat(fake.composeCount.get()).isEqualTo(1),
          () -> assertThat(fake.deleteCount.get()).isEqualTo(3),
          // every single RPC issued by the session (3 part writes + 1 compose + 3 deletes)
          // carried the header with the PCU bit set
          () ->
              requestAuditing
                  .assertRequestHeader(FeatureTracking.HEADER, FilteringPolicy.NO_FILTER)
                  .hasSize(rpcCount),
          () ->
              requestAuditing
                  .assertRequestHeader(FeatureTracking.HEADER, FilteringPolicy.DISTINCT)
                  .containsExactly(PCU_HEADER_VALUE),
          () -> assertThat(result.getName()).isEqualTo("o"),
          () -> assertThat(xxd(fake.objects.get("o"))).isEqualTo(xxd(CONTENT)));
    }
  }

  @Test
  public void defaultSession_doesNotSendFeatureTrackingHeader() throws Exception {
    InMemoryStorage fake = new InMemoryStorage();
    GrpcRequestAuditing requestAuditing = new GrpcRequestAuditing();

    try (FakeServer fakeServer = FakeServer.of(fake);
        Storage storage =
            fakeServer.getGrpcStorageOptions().toBuilder()
                .setRetrySettings(RetrySettings.newBuilder().setMaxAttempts(1).build())
                .setBlobWriteSessionConfig(BlobWriteSessionConfigs.getDefault())
                .setGrpcInterceptorProvider(requestAuditing)
                .build()
                .getService()) {

      BlobInfo result = write(storage, BlobInfo.newBuilder("b", "o").build());

      assertAll(
          () -> assertThat(fake.rpcCount()).isAtLeast(1),
          () ->
              requestAuditing
                  .assertRequestHeader(FeatureTracking.HEADER, FilteringPolicy.NO_FILTER)
                  .isEmpty(),
          () -> assertThat(result.getName()).isEqualTo("o"),
          () -> assertThat(xxd(fake.objects.get("o"))).isEqualTo(xxd(CONTENT)));
    }
  }

  private static BlobInfo write(Storage storage, BlobInfo info) throws Exception {
    BlobWriteSession session = storage.blobWriteSession(info);
    try (WritableByteChannel c = session.open()) {
      ByteBuffer buf = ByteBuffer.wrap(CONTENT);
      while (buf.hasRemaining()) {
        c.write(buf);
      }
    }
    return session.getResult().get(30, TimeUnit.SECONDS);
  }

  /**
   * Minimal in-memory object store: supports direct and resumable writes, compose and delete, which
   * is everything a parallel composite upload or default write session needs.
   */
  private static final class InMemoryStorage extends StorageImplBase {
    private final Map<String, byte[]> objects = new ConcurrentHashMap<>();
    private final Map<String, WriteObjectSpec> resumableWrites = new ConcurrentHashMap<>();
    private final AtomicLong generations = new AtomicLong(1);
    private final AtomicInteger startResumableWriteCount = new AtomicInteger();
    private final AtomicInteger writeCount = new AtomicInteger();
    private final AtomicInteger composeCount = new AtomicInteger();
    private final AtomicInteger deleteCount = new AtomicInteger();

    int rpcCount() {
      return startResumableWriteCount.get()
          + writeCount.get()
          + composeCount.get()
          + deleteCount.get();
    }

    @Override
    public void startResumableWrite(
        StartResumableWriteRequest request, StreamObserver<StartResumableWriteResponse> respond) {
      startResumableWriteCount.getAndIncrement();
      String uploadId = "upload-" + generations.getAndIncrement();
      resumableWrites.put(uploadId, request.getWriteObjectSpec());
      respond.onNext(StartResumableWriteResponse.newBuilder().setUploadId(uploadId).build());
      respond.onCompleted();
    }

    @Override
    public StreamObserver<WriteObjectRequest> writeObject(
        StreamObserver<WriteObjectResponse> respond) {
      writeCount.getAndIncrement();
      return new StreamObserver<WriteObjectRequest>() {
        private final ByteArrayOutputStream content = new ByteArrayOutputStream();
        private WriteObjectSpec spec;
        private boolean finished;

        @Override
        public void onNext(WriteObjectRequest request) {
          if (request.hasWriteObjectSpec()) {
            spec = request.getWriteObjectSpec();
          } else if (!request.getUploadId().isEmpty()) {
            spec = resumableWrites.get(request.getUploadId());
          }
          if (request.hasChecksummedData()) {
            ByteString bytes = request.getChecksummedData().getContent();
            content.write(bytes.toByteArray(), 0, bytes.size());
          }
          finished |= request.getFinishWrite();
        }

        @Override
        public void onError(Throwable t) {}

        @Override
        public void onCompleted() {
          if (spec == null) {
            respond.onError(TestUtils.apiException(Code.INVALID_ARGUMENT, "missing spec"));
            return;
          }
          byte[] bytes = content.toByteArray();
          WriteObjectResponse.Builder b = WriteObjectResponse.newBuilder();
          if (finished) {
            b.setResource(put(spec.getResource(), bytes));
          } else {
            b.setPersistedSize(bytes.length);
          }
          respond.onNext(b.build());
          respond.onCompleted();
        }
      };
    }

    @Override
    public void composeObject(ComposeObjectRequest request, StreamObserver<Object> respond) {
      composeCount.getAndIncrement();
      ByteArrayOutputStream composed = new ByteArrayOutputStream();
      for (SourceObject source : request.getSourceObjectsList()) {
        byte[] bytes = objects.get(source.getName());
        if (bytes == null) {
          respond.onError(TestUtils.apiException(Code.NOT_FOUND, source.getName()));
          return;
        }
        composed.write(bytes, 0, bytes.length);
      }
      respond.onNext(put(request.getDestination(), composed.toByteArray()));
      respond.onCompleted();
    }

    @Override
    public void deleteObject(DeleteObjectRequest request, StreamObserver<Empty> respond) {
      deleteCount.getAndIncrement();
      if (objects.remove(request.getObject()) == null) {
        respond.onError(TestUtils.apiException(Code.NOT_FOUND, request.getObject()));
        return;
      }
      respond.onNext(Empty.getDefaultInstance());
      respond.onCompleted();
    }

    /** Stores {@code bytes} under {@code resource}'s name, echoing the resource's metadata. */
    private Object put(Object resource, byte[] bytes) {
      objects.put(resource.getName(), bytes);
      return Object.newBuilder()
          .setBucket(BUCKET)
          .setName(resource.getName())
          .setGeneration(generations.getAndIncrement())
          .setSize(bytes.length)
          .putAllMetadata(resource.getMetadataMap())
          .setChecksums(
              ObjectChecksums.newBuilder().setCrc32C(Hashing.crc32c().hashBytes(bytes).asInt()))
          .build();
    }
  }
}
