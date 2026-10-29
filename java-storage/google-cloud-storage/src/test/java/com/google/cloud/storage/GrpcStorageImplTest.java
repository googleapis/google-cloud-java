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

import static com.google.cloud.storage.StorageClientMetrics.KEY_ERROR_TYPE;
import static com.google.cloud.storage.StorageClientMetrics.KEY_GCP_STORAGE_OPERATION;
import static com.google.cloud.storage.StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS;
import static com.google.cloud.storage.StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_OPERATIONS;
import static com.google.cloud.storage.StorageErrorTypeMapper.STATUS_NOT_FOUND;
import static com.google.cloud.storage.StorageErrorTypeMapper.STATUS_OK;
import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.NotFoundException;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.NoCredentials;
import com.google.cloud.storage.Retrying.Retrier;
import com.google.cloud.storage.Storage.CopyRequest;
import com.google.cloud.storage.Storage.MoveBlobRequest;
import com.google.cloud.storage.UnifiedOpts.Opts;
import com.google.protobuf.Empty;
import com.google.storage.v2.Bucket;
import com.google.storage.v2.CreateBucketRequest;
import com.google.storage.v2.DeleteObjectRequest;
import com.google.storage.v2.GetObjectRequest;
import com.google.storage.v2.MoveObjectRequest;
import com.google.storage.v2.Object;
import com.google.storage.v2.RestoreObjectRequest;
import com.google.storage.v2.RewriteObjectRequest;
import com.google.storage.v2.RewriteResponse;
import com.google.storage.v2.StorageClient;
import com.google.storage.v2.UpdateObjectRequest;
import io.grpc.Status;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;

public final class GrpcStorageImplTest {

  private static final String BUCKET_NAME = "test-bucket";
  private static final String BLOB_NAME = "test-blob";

  private InMemoryMetricReader reader;
  private GrpcStorageOptions options;
  private TestStorageStub storageStub;
  private GrpcStorageImpl grpcStorage;

  @Before
  public void setUp() {
    reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    options =
        GrpcStorageOptions.newBuilder()
            .setMeterProvider(provider)
            .setEnableOtelMetrics(true)
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .build();

    storageStub = new TestStorageStub();
    StorageClient storageClient = StorageClient.create(storageStub);
    Retrier retrier = options.createRetrier();

    grpcStorage =
        new GrpcStorageImpl(
            options,
            storageClient,
            null,
            ResponseContentLifecycleManager.noop(),
            null,
            retrier,
            Opts.empty());
  }

  @Test
  @SuppressWarnings("unchecked")
  public void unaryCalls_recordOperationMetrics() {
    // 1. Create (Bucket)
    UnaryCallable<CreateBucketRequest, Bucket> createBucketCallable =
        TestStorageStub.mockCallable();
    storageStub.createBucketCallable = createBucketCallable;
    when(createBucketCallable.call(any(CreateBucketRequest.class), any(GrpcCallContext.class)))
        .thenReturn(Bucket.newBuilder().setName("projects/_/buckets/" + BUCKET_NAME).build());

    com.google.cloud.storage.Bucket createdBucket = grpcStorage.create(BucketInfo.of(BUCKET_NAME));
    assertThat(createdBucket).isNotNull();
    assertOperationCount("CreateBucket", STATUS_OK, 1L);

    // 2. Get (Blob)
    UnaryCallable<GetObjectRequest, Object> getObjectCallable = TestStorageStub.mockCallable();
    storageStub.getObjectCallable = getObjectCallable;
    when(getObjectCallable.call(any(GetObjectRequest.class), any(GrpcCallContext.class)))
        .thenReturn(
            Object.newBuilder()
                .setBucket("projects/_/buckets/" + BUCKET_NAME)
                .setName(BLOB_NAME)
                .build());

    Blob retrievedBlob = grpcStorage.get(BlobId.of(BUCKET_NAME, BLOB_NAME));
    assertThat(retrievedBlob).isNotNull();
    assertOperationCount("GetObject", STATUS_OK, 1L);

    // 3. Delete (Blob)
    UnaryCallable<DeleteObjectRequest, Empty> deleteObjectCallable = TestStorageStub.mockCallable();
    storageStub.deleteObjectCallable = deleteObjectCallable;
    when(deleteObjectCallable.call(any(DeleteObjectRequest.class), any(GrpcCallContext.class)))
        .thenReturn(Empty.getDefaultInstance());

    boolean deleted = grpcStorage.delete(BlobId.of(BUCKET_NAME, BLOB_NAME));
    assertThat(deleted).isTrue();
    assertOperationCount("DeleteObject", STATUS_OK, 1L);

    // 4. Update (Blob)
    UnaryCallable<UpdateObjectRequest, Object> updateObjectCallable =
        TestStorageStub.mockCallable();
    storageStub.updateObjectCallable = updateObjectCallable;
    when(updateObjectCallable.call(any(UpdateObjectRequest.class), any(GrpcCallContext.class)))
        .thenReturn(
            Object.newBuilder()
                .setBucket("projects/_/buckets/" + BUCKET_NAME)
                .setName(BLOB_NAME)
                .setContentType("text/plain")
                .build());

    Blob updatedBlob =
        grpcStorage.update(
            BlobInfo.newBuilder(BUCKET_NAME, BLOB_NAME).setContentType("text/plain").build());
    assertThat(updatedBlob).isNotNull();
    assertOperationCount("UpdateObject", STATUS_OK, 1L);

    // 5. Restore (Blob)
    UnaryCallable<RestoreObjectRequest, Object> restoreObjectCallable =
        TestStorageStub.mockCallable();
    storageStub.restoreObjectCallable = restoreObjectCallable;
    when(restoreObjectCallable.call(any(RestoreObjectRequest.class), any(GrpcCallContext.class)))
        .thenReturn(
            Object.newBuilder()
                .setBucket("projects/_/buckets/" + BUCKET_NAME)
                .setName(BLOB_NAME)
                .setGeneration(1L)
                .build());

    Blob restoredBlob = grpcStorage.restore(BlobId.of(BUCKET_NAME, BLOB_NAME, 1L));
    assertThat(restoredBlob).isNotNull();
    assertOperationCount("RestoreObject", STATUS_OK, 1L);

    // 6. MoveBlob
    UnaryCallable<MoveObjectRequest, Object> moveObjectCallable = TestStorageStub.mockCallable();
    storageStub.moveObjectCallable = moveObjectCallable;
    when(moveObjectCallable.call(any(MoveObjectRequest.class), any(GrpcCallContext.class)))
        .thenReturn(
            Object.newBuilder()
                .setBucket("projects/_/buckets/" + BUCKET_NAME)
                .setName("dst-blob")
                .build());

    Blob movedBlob =
        grpcStorage.moveBlob(
            MoveBlobRequest.newBuilder()
                .setSource(BlobId.of(BUCKET_NAME, BLOB_NAME))
                .setTarget(BlobId.of(BUCKET_NAME, "dst-blob"))
                .build());
    assertThat(movedBlob).isNotNull();
    assertOperationCount("MoveObject", STATUS_OK, 1L);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void deleteBlob_onNonExistentObject_returnsFalseWithErrorTypeOk() {
    UnaryCallable<DeleteObjectRequest, Empty> deleteObjectCallable = TestStorageStub.mockCallable();
    storageStub.deleteObjectCallable = deleteObjectCallable;
    when(deleteObjectCallable.call(any(DeleteObjectRequest.class), any(GrpcCallContext.class)))
        .thenThrow(
            new NotFoundException(
                "Not Found", null, GrpcStatusCode.of(Status.Code.NOT_FOUND), false));

    boolean deleted = grpcStorage.delete(BlobId.of(BUCKET_NAME, "non-existent"));
    assertThat(deleted).isFalse();

    // Verify operations metric records STATUS_OK and not NOT_FOUND
    assertOperationCount("DeleteObject", STATUS_OK, 1L);
    assertOperationCount("DeleteObject", STATUS_NOT_FOUND, 0L);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void copy_propagatesMultiContextToRetrierWithAlg() {
    UnaryCallable<RewriteObjectRequest, RewriteResponse> rewriteObjectCallable =
        TestStorageStub.mockCallable();
    storageStub.rewriteObjectCallable = rewriteObjectCallable;
    when(rewriteObjectCallable.withDefaultCallContext(any(GrpcCallContext.class)))
        .thenReturn(rewriteObjectCallable);

    RewriteResponse initialResp =
        RewriteResponse.newBuilder()
            .setDone(false)
            .setRewriteToken("token-step-1")
            .setTotalBytesRewritten(50L)
            .setObjectSize(100L)
            .build();
    RewriteResponse doneResp =
        RewriteResponse.newBuilder()
            .setDone(true)
            .setTotalBytesRewritten(100L)
            .setObjectSize(100L)
            .setResource(
                Object.newBuilder()
                    .setBucket("projects/_/buckets/" + BUCKET_NAME)
                    .setName("dst-blob")
                    .build())
            .build();

    when(rewriteObjectCallable.call(any(RewriteObjectRequest.class), any(GrpcCallContext.class)))
        .thenReturn(initialResp, doneResp);

    CopyWriter writer =
        grpcStorage.copy(
            CopyRequest.newBuilder()
                .setSource(BUCKET_NAME, BLOB_NAME)
                .setTarget(BlobId.of(BUCKET_NAME, "dst-blob"))
                .build());

    // Initial step returned done=false, so top-level operation is not recorded yet
    assertThat(writer.isDone()).isFalse();
    assertOperationCount("RewriteObject", STATUS_OK, 0L);

    // Copying chunk completes rewrite using bound multiContext
    writer.copyChunk();
    assertThat(writer.isDone()).isTrue();

    // Multi-step operation is completed once
    assertOperationCount("RewriteObject", STATUS_OK, 1L);

    // Calling getResult returns blob without double-recording
    Blob result = writer.getResult();
    assertThat(result).isNotNull();
    assertOperationCount("RewriteObject", STATUS_OK, 1L);

    // Verify 2 attempts were recorded under RewriteObject
    assertAttemptCount("RewriteObject", 2L);
  }

  private void assertOperationCount(String operation, String errorType, long expectedCount) {
    Collection<MetricData> collected = reader.collectAllMetrics();
    long count = 0;
    for (MetricData md : collected) {
      if (md.getName().equals(METRIC_GCP_STORAGE_CLIENT_OPERATIONS)) {
        for (LongPointData point : md.getLongSumData().getPoints()) {
          String op = point.getAttributes().get(KEY_GCP_STORAGE_OPERATION);
          String err = point.getAttributes().get(KEY_ERROR_TYPE);
          if (operation.equals(op) && errorType.equals(err)) {
            count += point.getValue();
          }
        }
      }
    }
    assertThat(count).isEqualTo(expectedCount);
  }

  private void assertAttemptCount(String operation, long expectedCount) {
    Collection<MetricData> collected = reader.collectAllMetrics();
    long count = 0;
    for (MetricData md : collected) {
      if (md.getName().equals(METRIC_GCP_STORAGE_CLIENT_ATTEMPTS)) {
        for (LongPointData point : md.getLongSumData().getPoints()) {
          String op = point.getAttributes().get(KEY_GCP_STORAGE_OPERATION);
          if (operation.equals(op)) {
            count += point.getValue();
          }
        }
      }
    }
    assertThat(count).isEqualTo(expectedCount);
  }
}
