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

import static com.google.cloud.storage.ByteSizeConstants._16MiB;
import static com.google.cloud.storage.ByteSizeConstants._1MiB;
import static com.google.cloud.storage.ByteSizeConstants._256KiB;
import static com.google.cloud.storage.CrossTransportUtils.fmtMethodName;
import static com.google.cloud.storage.CrossTransportUtils.throwHttpJsonOnly;
import static com.google.cloud.storage.StorageV2ProtoUtils.bucketAclEntityOrAltEq;
import static com.google.cloud.storage.StorageV2ProtoUtils.objectAclEntityOrAltEq;
import static com.google.cloud.storage.Utils.bucketNameCodec;
import static com.google.cloud.storage.Utils.ifNonNull;
import static com.google.cloud.storage.Utils.projectNameCodec;
import static com.google.common.base.MoreObjects.firstNonNull;
import static java.util.Objects.requireNonNull;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.Page;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptions;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.NotFoundException;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.BaseService;
import com.google.cloud.Policy;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Acl.Entity;
import com.google.cloud.storage.BidiUploadState.AppendableUploadState;
import com.google.cloud.storage.BlobWriteSessionConfig.WriterFactory;
import com.google.cloud.storage.BufferedWritableByteChannelSession.BufferedWritableByteChannel;
import com.google.cloud.storage.Conversions.Decoder;
import com.google.cloud.storage.GrpcUtils.ZeroCopyServerStreamingCallable;
import com.google.cloud.storage.HmacKey.HmacKeyMetadata;
import com.google.cloud.storage.HmacKey.HmacKeyState;
import com.google.cloud.storage.PostPolicyV4.PostConditionsV4;
import com.google.cloud.storage.PostPolicyV4.PostFieldsV4;
import com.google.cloud.storage.Retrying.Retrier;
import com.google.cloud.storage.Retrying.RetrierWithAlg;
import com.google.cloud.storage.Storage.ComposeRequest.SourceBlob;
import com.google.cloud.storage.UnbufferedReadableByteChannelSession.UnbufferedReadableByteChannel;
import com.google.cloud.storage.UnbufferedWritableByteChannelSession.UnbufferedWritableByteChannel;
import com.google.cloud.storage.UnifiedOpts.BucketListOpt;
import com.google.cloud.storage.UnifiedOpts.BucketSourceOpt;
import com.google.cloud.storage.UnifiedOpts.BucketTargetOpt;
import com.google.cloud.storage.UnifiedOpts.Fields;
import com.google.cloud.storage.UnifiedOpts.Mapper;
import com.google.cloud.storage.UnifiedOpts.NamedField;
import com.google.cloud.storage.UnifiedOpts.ObjectListOpt;
import com.google.cloud.storage.UnifiedOpts.ObjectSourceOpt;
import com.google.cloud.storage.UnifiedOpts.ObjectTargetOpt;
import com.google.cloud.storage.UnifiedOpts.Opts;
import com.google.cloud.storage.UnifiedOpts.ProjectId;
import com.google.cloud.storage.UnifiedOpts.UserProject;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Streams;
import com.google.common.io.ByteStreams;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.storage.v2.AppendObjectSpec;
import com.google.storage.v2.BidiReadObjectRequest;
import com.google.storage.v2.BidiReadObjectSpec;
import com.google.storage.v2.BidiWriteObjectRequest;
import com.google.storage.v2.BucketAccessControl;
import com.google.storage.v2.ComposeObjectRequest;
import com.google.storage.v2.ComposeObjectRequest.SourceObject;
import com.google.storage.v2.CreateBucketRequest;
import com.google.storage.v2.DeleteBucketRequest;
import com.google.storage.v2.DeleteObjectRequest;
import com.google.storage.v2.GetBucketRequest;
import com.google.storage.v2.GetObjectRequest;
import com.google.storage.v2.ListBucketsRequest;
import com.google.storage.v2.ListObjectsRequest;
import com.google.storage.v2.ListObjectsResponse;
import com.google.storage.v2.LockBucketRetentionPolicyRequest;
import com.google.storage.v2.MoveObjectRequest;
import com.google.storage.v2.Object;
import com.google.storage.v2.ObjectAccessControl;
import com.google.storage.v2.ReadObjectRequest;
import com.google.storage.v2.ReadObjectResponse;
import com.google.storage.v2.RestoreObjectRequest;
import com.google.storage.v2.RewriteObjectRequest;
import com.google.storage.v2.RewriteResponse;
import com.google.storage.v2.StorageClient;
import com.google.storage.v2.UpdateBucketRequest;
import com.google.storage.v2.UpdateObjectRequest;
import com.google.storage.v2.WriteObjectRequest;
import com.google.storage.v2.WriteObjectResponse;
import com.google.storage.v2.WriteObjectSpec;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators.AbstractSpliterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

final class GrpcStorageImpl extends BaseService<StorageOptions>
    implements Storage, StorageInternal {

  private static final byte[] ZERO_BYTES = new byte[0];
  private static final Set<OpenOption> READ_OPS = ImmutableSet.of(StandardOpenOption.READ);
  private static final Set<OpenOption> WRITE_OPS =
      ImmutableSet.of(
          StandardOpenOption.WRITE,
          StandardOpenOption.CREATE,
          StandardOpenOption.TRUNCATE_EXISTING);
  private static final BucketSourceOption[] EMPTY_BUCKET_SOURCE_OPTIONS = new BucketSourceOption[0];

  private static final Opts<Fields> ALL_BLOB_FIELDS =
      Opts.from(UnifiedOpts.fields(ImmutableSet.copyOf(BlobField.values())));
  private static final Opts<Fields> ALL_BUCKET_FIELDS =
      // todo: b/308194853
      Opts.from(
          UnifiedOpts.fields(
              Arrays.stream(BucketField.values())
                  .filter(f -> !f.equals(BucketField.OBJECT_RETENTION))
                  .collect(ImmutableSet.toImmutableSet())));

  final StorageClient storageClient;
  final StorageDataClient storageDataClient;
  final ResponseContentLifecycleManager<ReadObjectResponse> responseContentLifecycleManager;
  final WriterFactory writerFactory;
  final GrpcConversions codecs;
  final GrpcRetryAlgorithmManager retryAlgorithmManager;
  final SyntaxDecoders syntaxDecoders;
  final Retrier retrier;

  // workaround for https://github.com/googleapis/java-storage/issues/1736
  private final Opts<UserProject> defaultOpts;
  @Deprecated private final Supplier<ProjectId> defaultProjectId;

  GrpcStorageImpl(
      GrpcStorageOptions options,
      StorageClient storageClient,
      StorageDataClient storageDataClient,
      ResponseContentLifecycleManager<ReadObjectResponse> responseContentLifecycleManager,
      WriterFactory writerFactory,
      Retrier retrier,
      Opts<UserProject> defaultOpts) {
    super(options);
    this.storageClient = storageClient;
    this.storageDataClient = storageDataClient;
    this.responseContentLifecycleManager = responseContentLifecycleManager;
    this.writerFactory = writerFactory;
    this.retrier = retrier;
    this.defaultOpts = defaultOpts;
    this.codecs = Conversions.grpc();
    this.retryAlgorithmManager = options.getRetryAlgorithmManager();
    this.syntaxDecoders = new SyntaxDecoders();
    this.defaultProjectId = Suppliers.memoize(() -> UnifiedOpts.projectId(options.getProjectId()));
  }

  @Override
  public void close() throws Exception {
    try (StorageClient s = storageClient;
        StorageDataClient ignore = storageDataClient) {
      s.shutdownNow();
      java.time.Duration terminationAwaitDuration = getOptions().getTerminationAwaitDuration();
      s.awaitTermination(terminationAwaitDuration.toMillis(), TimeUnit.MILLISECONDS);
    }
  }

  @Override
  public Bucket create(BucketInfo bucketInfo, BucketTargetOption... options) {
    Opts<BucketTargetOpt> opts = Opts.unwrap(options).resolveFrom(bucketInfo).prepend(defaultOpts);
    GrpcCallContext grpcCallContext =
        opts.grpcMetadataMapper().apply(GrpcCallContext.createDefault());
    com.google.storage.v2.Bucket bucket = codecs.bucketInfo().encode(bucketInfo);
    CreateBucketRequest.Builder builder =
        CreateBucketRequest.newBuilder()
            .setBucket(bucket)
            .setBucketId(bucketInfo.getName())
            .setParent("projects/_");
    if (bucketInfo.getProject() == null) {
      builder.getBucketBuilder().setProject(projectNameCodec.encode(getOptions().getProjectId()));
    }
    CreateBucketRequest req = opts.createBucketsRequest().apply(builder).build();
    GrpcCallContext merge = Utils.merge(grpcCallContext, Retrying.newCallContext());
    return retrier.run(
        retryAlgorithmManager.getFor(req),
        () -> storageClient.createBucketCallable().call(req, merge),
        syntaxDecoders.bucket);
  }

  @Override
  public Blob create(BlobInfo blobInfo, BlobTargetOption... options) {
    return create(blobInfo, null, options);
  }

  @Override
  public Blob create(BlobInfo blobInfo, byte[] content, BlobTargetOption... options) {
    content = firstNonNull(content, ZERO_BYTES);
    return create(blobInfo, content, 0, content.length, options);
  }

  @Override
  public Blob create(
      BlobInfo blobInfo, byte[] content, int offset, int length, BlobTargetOption... options) {
    Opts<ObjectTargetOpt> opts = Opts.unwrap(options).resolveFrom(blobInfo);
    return internalDirectUpload(blobInfo, opts, ByteBuffer.wrap(content, offset, length))
        .asBlob(this);
  }

  @Override
  public Blob create(BlobInfo blobInfo, InputStream content, BlobWriteOption... options) {
    try {
      requireNonNull(blobInfo, "blobInfo must be non null");
      InputStream inputStreamParam = firstNonNull(content, new ByteArrayInputStream(ZERO_BYTES));

      Opts<ObjectTargetOpt> optsWithDefaults = Opts.unwrap(options).prepend(defaultOpts);
      GrpcCallContext grpcCallContext =
          optsWithDefaults.grpcMetadataMapper().apply(GrpcCallContext.createDefault());
      WriteObjectRequest req = getWriteObjectRequest(blobInfo, optsWithDefaults);
      Hasher hasher = optsWithDefaults.getHasher();
      GrpcCallContext merge = Utils.merge(grpcCallContext, Retrying.newCallContext());
      UnbufferedWritableByteChannelSession<WriteObjectResponse> session =
          ResumableMedia.gapic()
              .write()
              .byteChannel(storageClient.writeObjectCallable().withDefaultCallContext(merge))
              .setByteStringStrategy(ByteStringStrategy.noCopy())
              .setHasher(hasher)
              .direct()
              .unbuffered()
              .setRequest(req)
              .build();

      try (UnbufferedWritableByteChannel c = session.open()) {
        ByteStreams.copy(Channels.newChannel(inputStreamParam), c);
      }
      ApiFuture<WriteObjectResponse> responseApiFuture = session.getResult();
      return this.getBlob(responseApiFuture);
    } catch (IOException | ApiException e) {
      throw StorageException.coalesce(e);
    }
  }

  @Override
  public Blob createFrom(BlobInfo blobInfo, Path path, BlobWriteOption... options)
      throws IOException {
    return createFrom(blobInfo, path, _16MiB, options);
  }

  @Override
  public Blob createFrom(BlobInfo blobInfo, Path path, int bufferSize, BlobWriteOption... options)
      throws IOException {
    Opts<ObjectTargetOpt> opts = Opts.unwrap(options).resolveFrom(blobInfo).prepend(defaultOpts);
    return internalCreateFrom(path, blobInfo, opts);
  }

  @Override
  public Blob internalCreateFrom(Path path, BlobInfo info, Opts<ObjectTargetOpt> opts)
      throws IOException {
    requireNonNull(path, "path must be non null");
    if (Files.isDirectory(path)) {
      throw new StorageException(0, path + " is a directory");
    }

    GrpcCallContext grpcCallContext =
        opts.grpcMetadataMapper().apply(GrpcCallContext.createDefault());
    WriteObjectRequest req = getWriteObjectRequest(info, opts);

    ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse> write =
        storageClient.writeObjectCallable().withDefaultCallContext(grpcCallContext);

    ApiFuture<ResumableWrite> start = startResumableWrite(grpcCallContext, req, opts);
    ApiFuture<GrpcResumableSession> session2 =
        ApiFutures.transform(
            start,
            rw ->
                ResumableSession.grpc(
                    retrier.withAlg(retryAlgorithmManager.idempotent()),
                    write,
                    storageClient.queryWriteStatusCallable(),
                    rw,
                    opts.getHasher()),
            MoreExecutors.directExecutor());
    try {
      GrpcResumableSession got = session2.get();
      ResumableOperationResult<@Nullable Object> put = got.put(RewindableContent.of(path));
      Object object = put.getObject();
      if (object == null) {
        // if by some odd chance the put didn't get the Object, query for it
        ResumableOperationResult<@Nullable Object> query = got.query();
        object = query.getObject();
      }
      return codecs.blobInfo().decode(object).asBlob(this);
    } catch (InterruptedException | ExecutionException e) {
      throw StorageException.coalesce(e);
    }
  }

  @Override
  public Blob createFrom(BlobInfo blobInfo, InputStream content, BlobWriteOption... options)
      throws IOException {
    return createFrom(blobInfo, content, _16MiB, options);
  }

  @Override
  public Blob createFrom(
      BlobInfo blobInfo, InputStream in, int bufferSize, BlobWriteOption... options)
      throws IOException {
    requireNonNull(blobInfo, "blobInfo must be non null");

    Opts<ObjectTargetOpt> opts = Opts.unwrap(options).resolveFrom(blobInfo).prepend(defaultOpts);
    GrpcCallContext grpcCallContext =
        opts.grpcMetadataMapper().apply(GrpcCallContext.createDefault());
    WriteObjectRequest req = getWriteObjectRequest(blobInfo, opts);

    ApiFuture<ResumableWrite> start = startResumableWrite(grpcCallContext, req, opts);

    BufferedWritableByteChannelSession<WriteObjectResponse> session =
        ResumableMedia.gapic()
            .write()
            .byteChannel(
                storageClient.writeObjectCallable().withDefaultCallContext(grpcCallContext))
            .setHasher(opts.getHasher())
            .setByteStringStrategy(ByteStringStrategy.noCopy())
            .resumable()
            .withRetryConfig(retrier.withAlg(retryAlgorithmManager.idempotent()))
            .buffered(Buffers.allocateAligned(bufferSize, _256KiB))
            .setStartAsync(start)
            .build();

    // Specifically not in the try-with, so we don't close the provided stream
    ReadableByteChannel src =
        Channels.newChannel(firstNonNull(in, new ByteArrayInputStream(ZERO_BYTES)));
    try (BufferedWritableByteChannel dst = session.open()) {
      ByteStreams.copy(src, dst);
    } catch (Exception e) {
      throw StorageException.coalesce(e);
    }
    return getBlob(session.getResult());
  }

  @Override
  public Bucket get(String bucket, BucketGetOption... options) {
    Opts<BucketSourceOpt> unwrap = Opts.unwrap(options);
    return internalBucketGet(bucket, unwrap);
  }

  @Override
  public Bucket lockRetentionPolicy(BucketInfo bucket, BucketTargetOption... options) {
    Opts<BucketTargetOpt> opts = Opts.unwrap(options).resolveFrom(bucket).prepend(defaultOpts);
    GrpcCallContext grpcCallContext =
        opts.grpcMetadataMapper().apply(GrpcCallContext.createDefault());
    LockBucketRetentionPolicyRequest.Builder builder =
        LockBucketRetentionPolicyRequest.newBuilder()
            .setBucket(bucketNameCodec.encode(bucket.getName()));
    LockBucketRetentionPolicyRequest req =
        opts.lockBucketRetentionPolicyRequest().apply(builder).build();
    GrpcCallContext merge = Utils.merge(grpcCallContext, Retrying.newCallContext());
    return retrier.run(
        retryAlgorithmManager.getFor(req),
        () -> storageClient.lockBucketRetentionPolicyCallable().call(req, merge),
        syntaxDecoders.bucket);
  }

  @Override
  public Blob get(String bucket, String blob, BlobGetOption... options) {
    return get(BlobId.of(bucket, blob), options);
  }

  @Override
  public Blob get(BlobId blob, BlobGetOption... options) {
    Opts<ObjectSourceOpt> unwrap = Opts.unwrap(options);
    return internalBlobGet(blob, unwrap);
  }

  @Override
  public Blob get(BlobId blob) {
    return get(blob, new BlobGetOption[0]);
  }

  @Override
  public Blob restore(BlobId blob, BlobRestoreOption... options) {
    Opts<ObjectSourceOpt> unwrap = Opts.unwrap(options);
    return internalObjectRestore(blob, unwrap);
  }

  private Blob internalObjectRestore(BlobId blobId, Opts<ObjectSourceOpt> opts) {
    Opts<ObjectSourceOpt> finalOpts = opts.prepend(defaultOpts).prepend(ALL_BLOB_FIELDS);
    GrpcCallContext grpcCallContext =
        finalOpts.grpcMetadataMapper().apply(GrpcCallContext.createDefault());
    RestoreObjectRequest.Builder builder =
        RestoreObjectRequest.newBuilder()
            .setBucket(bucketNameCodec.encode(blobId.getBucket()))
            .setObject(blobId.getName());
    ifNonNull(blobId.getGeneration(), builder::setGeneration);
    RestoreObjectRequest req = finalOpts.restoreObjectRequest().apply(builder).build();
    GrpcCallContext merge = Utils.merge(grpcCallContext, Retrying.newCallContext());
    return retrier.run(
        retryAlgorithmManager.getFor(req),
        () -> storageClient.restoreObjectCallable().call(req, merge),
        resp -> {
          BlobInfo tmp = codecs.blobInfo().decode(resp);
          return finalOpts.clearBlobFields().decode(tmp).asBlob(this);
        });
  }

  @Override
  public Page<Bucket> list(BucketListOption... options) {
    Opts<BucketListOpt> opts = Opts.unwrap(options).prepend(defaultOpts).prepend(ALL_BUCKET_FIELDS);
    GrpcCallContext grpcCallContext =
        opts.grpcMetadataMapper().apply(GrpcCallContext.createDefault());

    ListBucketsRequest request =
        defaultProjectId
            .get()
            .listBuckets()
            .andThen(opts.listBucketsRequest())
            .apply(ListBucketsRequest.newBuilder())
            .build();

    if (!request.getReturnPartialSuccess()) {
      try {
        GrpcCallContext merge = Utils.merge(grpcCallContext, Retrying.newCallContext());
        return retrier.run(
            retryAlgorithmManager.getFor(request),
            () -> storageClient.listBucketsPagedCallable().call(request, merge),
            resp ->
                new TransformingPageDecorator<>(
                    resp.getPage(),
                    syntaxDecoders.bucket.andThen(opts.clearBucketFields()),
                    retrier,
                    retryAlgorithmManager.getFor(request)));
      } catch (Exception e) {
        throw StorageException.coalesce(e);
      }
    } else {
      try {
        com.google.storage.v2.ListBucketsResponse response = listBuckets(grpcCallContext, request);
        return new ListBucketsWithPartialSuccessPage(grpcCallContext, request, response, opts);
      } catch (Exception e) {
        throw StorageException.coalesce(e);
      }
    }
  }

  @Override
  public Page<Blob> list(String bucket, BlobListOption... options) {
    Opts<ObjectListOpt> opts = Opts.unwrap(options).prepend(defaultOpts).prepend(ALL_BLOB_FIELDS);
    GrpcCallContext grpcCallContext =
        opts.grpcMetadataMapper().apply(GrpcCallContext.createDefault());
    ListObjectsRequest.Builder builder =
        ListObjectsRequest.newBuilder().setParent(bucketNameCodec.encode(bucket));
    ListObjectsRequest req = opts.listObjectsRequest().apply(builder).build();
    try {
      GrpcCallContext merge = Utils.merge(grpcCallContext, Retrying.newCallContext());
      return retrier.run(
          retryAlgorithmManager.getFor(req),
          () -> storageClient.listObjectsCallable().call(req, merge),
          resp -> new ListObjectsWithSyntheticDirectoriesPage(grpcCallContext, req, resp));
    } catch (Exception e) {
      throw StorageException.coalesce(e);
    }
  }

  @Override
  public Bucket update(BucketInfo bucketInfo, BucketTargetOption... options) {
    Opts<BucketTargetOpt> unwrap = Opts.unwrap(options);
    if (bucketInfo.getModifiedFields().isEmpty()) {
      return internalBucketGet(bucketInfo.getName(), unwrap.constrainTo(BucketSourceOpt.class));
    }
    Opts<BucketTargetOpt> opts = unwrap.resolveFrom(bucketInfo).prepend(defaultOpts);
    GrpcCallContext grpcCallContext =
        opts.grpcMetadataMapper().apply(GrpcCallContext.createDefault());
    com.google.storage.v2.Bucket bucket = codecs.bucketInfo().encode(bucketInfo);
    UpdateBucketRequest.Builder builder =
        opts.updateBucketsRequest().apply(UpdateBucketRequest.newBuilder().setBucket(bucket));
    builder
        .getUpdateMaskBuilder()
        .addAllPaths(
            bucketInfo.getModifiedFields().stream()
                .map(NamedField::getGrpcName)
                .collect(ImmutableList.toImmutableList()));
    UpdateBucketRequest req = builder.build();
    GrpcCallContext merge = Utils.merge(grpcCallContext, Retrying.newCallContext());
    return retrier.run(
        retryAlgorithmManager.getFor(req),
        () -> storageClient.updateBucketCallable().call(req, merge),
        syntaxDecoders.bucket);
  }

  @Override
  public Blob update(BlobInfo blobInfo, BlobTargetOption... options) {
    Opts<ObjectTargetOpt> unwrap = Opts.unwrap(options);
    if (blobInfo.getModifiedFields().isEmpty()) {
      return internalBlobGet(blobInfo.getBlobId(), unwrap.constrainTo(ObjectSourceOpt.class));
    }
    Opts<ObjectTargetOpt> opts = unwrap.resolveFrom(blobInfo).prepend(defaultOpts);
    GrpcCallContext grpcCallContext =
        opts.grpcMetadataMapper().apply(GrpcCallContext.createDefault());
    Object object = codecs.blobInfo().encode(blobInfo);
    UpdateObjectRequest.Builder builder =
        opts.updateObjectsRequest().apply(UpdateObjectRequest.newBuilder().setObject(object));
    builder
        .getUpdateMaskBuilder()
        .addAllPaths(
            blobInfo.getModifiedFields().stream()
                .map(NamedField::getGrpcName)
                .collect(ImmutableList.toImmutableList()));
    UpdateObjectRequest req = builder.build();
    GrpcCallContext merge = Utils.merge(grpcCallContext, Retrying.newCallContext());
    return retrier.run(
        retryAlgorithmManager.getFor(req),
        () -> storageClient.updateObjectCallable().call(req, merge),
        syntaxDecoders.blob);
  }

  @Override
  public Blob update(BlobInfo blobInfo) {
    return update(blobInfo, new BlobTargetOption[0]);
  }

  @Override
  public boolean delete(String bucket, BucketSourceOption... options) {
    Opts<BucketSourceOpt> opts = Opts.unwrap(options).prepend(defaultOpts);
    GrpcCallContext grpcCallContext =
        opts.grpcMetadataMapper().apply(GrpcCallContext.createDefault());
    DeleteBucketRequest.Builder builder =
        DeleteBucketRequest.newBuilder().setName(bucketNameCodec.encode(bucket));
    DeleteBucketRequest req = opts.deleteBucketsRequest().apply(builder).build();
    GrpcCallContext merge = Utils.merge(grpcCallContext, Retrying.newCallContext());
    return Boolean.TRUE.equals(
        retrier.run(
            retryAlgorithmManager.getFor(req),
            () -> {
              try {
                storageClient.deleteBucketCallable().call(req, merge);
                return true;
              } catch (NotFoundException e) {
                return false;
              }
            },
            Decoder.identity()));
  }

  @Override
  public boolean delete(String bucket, String blob, BlobSourceOption... options) {
    return delete(BlobId.of(bucket, blob), options);
  }

  @Override
  public boolean delete(BlobId blob, BlobSourceOption... options) {
    Opts<ObjectSourceOpt> opts = Opts.unwrap(options);
    try {
      internalObjectDelete(blob, opts);
      return true;
    } catch (NotFoundException e) {
      return false;
    } catch (StorageException e) {
      if (e.getCode() == 404) {
        return false;
      }
      throw e;
    }
  }

  @Override
  public boolean delete(BlobId blob) {
    return delete(blob, new BlobSourceOption[0]);
  }

  @Override
  public Void internalObjectDelete(BlobId id, Opts<ObjectSourceOpt> opts) {
    Opts<ObjectSourceOpt> finalOpts = opts.resolveFrom(id).prepend(defaultOpts);
    GrpcCallContext grpcCallContext =
        finalOpts.grpcMetadataMapper().apply(GrpcCallContext.createDefault());
    DeleteObjectRequest.Builder builder =
        DeleteObjectRequest.newBuilder()
            .setBucket(bucketNameCodec.encode(id.getBucket()))
            .setObject(id.getName());
    ifNonNull(id.getGeneration(), builder::setGeneration);
    DeleteObjectRequest req = finalOpts.deleteObjectsRequest().apply(builder).build();
    GrpcCallContext merge = Utils.merge(grpcCallContext, Retrying.newCallContext());
    return retrier.run(
        retryAlgorithmManager.getFor(req),
        () -> {
          storageClient.deleteObjectCallable().call(req, merge);
          return null;
        },
        Decoder.identity());
  }

  @Override
  public Blob compose(ComposeRequest composeRequest) {
    Opts<ObjectTargetOpt> opts = composeRequest.getTargetOpts().prepend(defaultOpts);
    GrpcCallContext grpcCallContext =
        opts.grpcMetadataMapper().apply(GrpcCallContext.createDefault());
    ComposeObjectRequest.Builder builder = ComposeObjectRequest.newBuilder();
    composeRequest.getSourceBlobs().stream()
        .map(src -> sourceObjectEncode(src))
        .forEach(builder::addSourceObjects);
    final Object target = codecs.blobInfo().encode(composeRequest.getTarget());
    builder.setDestination(target);
    ComposeObjectRequest req = opts.composeObjectsRequest().apply(builder).build();
    GrpcCallContext merge = Utils.merge(grpcCallContext, Retrying.newCallContext());
    return retrier.run(
        retryAlgorithmManager.getFor(req),
        () -> storageClient.composeObjectCallable().call(req, merge),
        syntaxDecoders.blob);
  }

  @Override
  public CopyWriter copy(CopyRequest copyRequest) {
    BlobId src = copyRequest.getSource();
    BlobInfo dst = copyRequest.getTarget();
    Opts<ObjectSourceOpt> srcOpts =
        Opts.unwrap(copyRequest.getSourceOptions())
            .projectAsSource()
            .resolveFrom(src)
            .prepend(defaultOpts);
    Opts<ObjectTargetOpt> dstOpts =
        Opts.unwrap(copyRequest.getTargetOptions()).resolveFrom(dst).prepend(defaultOpts);

    Mapper<RewriteObjectRequest.Builder> requestBuilderMapper =
        srcOpts.rewriteObjectsRequest().andThen(dstOpts.rewriteObjectsRequest());
    Mapper<GrpcCallContext> grpcCallContextMapper =
        srcOpts.grpcMetadataMapper().andThen(dstOpts.grpcMetadataMapper());

    Object srcProto = codecs.blobId().encode(src);
    Object dstProto = codecs.blobInfo().encode(dst);

    RewriteObjectRequest.Builder b =
        RewriteObjectRequest.newBuilder()
            .setDestinationName(dstProto.getName())
            .setDestinationBucket(dstProto.getBucket())
            .setSourceBucket(srcProto.getBucket())
            .setSourceObject(srcProto.getName());

    // according to the docs in the protos, it is illegal to populate the following fields,
    // clear them out if they are set
    // * destination_kms_key comes from dstOpts
    // * destination_predefined_acl comes from dstOpts
    // * if_*_match come from srcOpts and dstOpts
    // * copy_source_encryption_* come from srcOpts
    // * common_object_request_params come from dstOpts
    Object cleanedDst = dstProto.toBuilder().clearName().clearBucket().clearKmsKey().build();
    // only set the destination if it is not equal to the default instance
    // otherwise we will clobber default values populated in the gcs server side for the object
    // metadata
    if (!cleanedDst.equals(Object.getDefaultInstance())) {
      b.setDestination(cleanedDst);
    }

    if (src.getGeneration() != null) {
      b.setSourceGeneration(src.getGeneration());
    }

    if (copyRequest.getMegabytesCopiedPerChunk() != null) {
      b.setMaxBytesRewrittenPerCall(copyRequest.getMegabytesCopiedPerChunk() * _1MiB);
    }

    RewriteObjectRequest req = requestBuilderMapper.apply(b).build();
    GrpcCallContext grpcCallContext = grpcCallContextMapper.apply(GrpcCallContext.createDefault());
    UnaryCallable<RewriteObjectRequest, RewriteResponse> callable =
        storageClient.rewriteObjectCallable().withDefaultCallContext(grpcCallContext);
    GrpcCallContext retryContext = Retrying.newCallContext();
    RetrierWithAlg retrierWithAlg = retrier.withAlg(retryAlgorithmManager.idempotent());
    return retrier.run(
        retryAlgorithmManager.getFor(req),
        () -> callable.call(req, retryContext),
        (resp) -> new GapicCopyWriter(this, callable, retrierWithAlg, req, resp));
  }

  @Override
  public byte[] readAllBytes(String bucket, String blob, BlobSourceOption... options) {
    return readAllBytes(BlobId.of(bucket, blob), options);
  }

  @Override
  public byte[] readAllBytes(BlobId blob, BlobSourceOption... options) {
    UnbufferedReadableByteChannelSession<Object> session = unbufferedReadSession(blob, options);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (UnbufferedReadableByteChannel r = session.open();
        WritableByteChannel w = Channels.newChannel(baos)) {
      ByteStreams.copy(r, w);
    } catch (ApiException | IOException e) {
      throw StorageException.coalesce(e);
    }
    return baos.toByteArray();
  }

  @Override
  public StorageBatch batch() {
    return throwHttpJsonOnly("batch()");
  }

  @Override
  public GrpcBlobReadChannel reader(String bucket, String blob, BlobSourceOption... options) {
    return reader(BlobId.of(bucket, blob), options);
  }

  @Override
  public GrpcBlobReadChannel reader(BlobId blob, BlobSourceOption... options) {
    Opts<ObjectSourceOpt> opts = Opts.unwrap(options).resolveFrom(blob).prepend(defaultOpts);
    ReadObjectRequest request = getReadObjectRequest(blob, opts);
    GrpcCallContext grpcCallContext = opts.grpcMetadataMapper().apply(Retrying.newCallContext());

    return new GrpcBlobReadChannel(
        readObjectCallable(grpcCallContext),
        retrier,
        retryAlgorithmManager.getFor(request),
        request,
        !opts.autoGzipDecompression());
  }

  @Override
  public void downloadTo(BlobId blob, Path path, BlobSourceOption... options) {

    UnbufferedReadableByteChannelSession<Object> session = unbufferedReadSession(blob, options);

    try (UnbufferedReadableByteChannel r = session.open();
        WritableByteChannel w = Files.newByteChannel(path, WRITE_OPS)) {
      ByteStreams.copy(r, w);
    } catch (ApiException | IOException e) {
      throw StorageException.coalesce(e);
    }
  }

  @Override
  public void downloadTo(BlobId blob, OutputStream outputStream, BlobSourceOption... options) {

    UnbufferedReadableByteChannelSession<Object> session = unbufferedReadSession(blob, options);

    try (UnbufferedReadableByteChannel r = session.open();
        WritableByteChannel w = Channels.newChannel(outputStream)) {
      ByteStreams.copy(r, w);
    } catch (ApiException | IOException e) {
      throw StorageException.coalesce(e);
    }
  }

  @Override
  public GrpcBlobWriteChannel writer(BlobInfo blobInfo, BlobWriteOption... options) {
    Opts<ObjectTargetOpt> opts = Opts.unwrap(options).resolveFrom(blobInfo).prepend(defaultOpts);
    GrpcCallContext grpcCallContext =
        opts.grpcMetadataMapper().apply(GrpcCallContext.createDefault());
    WriteObjectRequest req = getWriteObjectRequest(blobInfo, opts);
    Hasher hasher = opts.getHasher();
    // in JSON, the starting of the resumable session happens before the invocation of write can
    // happen. Emulate the same thing here.
    //  1. create the future
    ApiFuture<ResumableWrite> startResumableWrite = startResumableWrite(grpcCallContext, req, opts);
    //  2. await the result of the future
    ResumableWrite resumableWrite = ApiFutureUtils.await(startResumableWrite);
    //  3. wrap the result in another future container before constructing the BlobWriteChannel
    ApiFuture<ResumableWrite> wrapped = ApiFutures.immediateFuture(resumableWrite);
    return new GrpcBlobWriteChannel(
        storageClient.writeObjectCallable().withDefaultCallContext(grpcCallContext),
        retrier.withAlg(retryAlgorithmManager.idempotent()),
        () -> wrapped,
        hasher);
  }

  @Override
  public BlobInfo internalDirectUpload(
      BlobInfo blobInfo, Opts<ObjectTargetOpt> opts, ByteBuffer buf) {
    requireNonNull(blobInfo, "blobInfo must be non null");
    requireNonNull(buf, "content must be non null");
    Opts<ObjectTargetOpt> optsWithDefaults = opts.prepend(defaultOpts);
    GrpcCallContext grpcCallContext =
        optsWithDefaults.grpcMetadataMapper().apply(GrpcCallContext.createDefault());
    WriteObjectRequest req = getWriteObjectRequest(blobInfo, optsWithDefaults);
    Hasher hasher = opts.getHasher();
    GrpcCallContext merge = Utils.merge(grpcCallContext, Retrying.newCallContext());
    RewindableContent content = RewindableContent.of(buf);
    return retrier.run(
        retryAlgorithmManager.getFor(req),
        () -> {
          content.rewindTo(0);
          UnbufferedWritableByteChannelSession<WriteObjectResponse> session =
              ResumableMedia.gapic()
                  .write()
                  .byteChannel(storageClient.writeObjectCallable().withDefaultCallContext(merge))
                  .setByteStringStrategy(ByteStringStrategy.noCopy())
                  .setHasher(hasher)
                  .direct()
                  .unbuffered()
                  .setRequest(req)
                  .build();

          try (UnbufferedWritableByteChannel c = session.open()) {
            content.writeTo(c);
          }
          return session.getResult();
        },
        this::getBlob);
  }

  @Override
  public WriteChannel writer(URL signedURL) {
    return throwHttpJsonOnly(fmtMethodName("writer", URL.class));
  }

  @Override
  public URL signUrl(BlobInfo blobInfo, long duration, TimeUnit unit, SignUrlOption... options) {
    return throwHttpJsonOnly(
        fmtMethodName("signUrl", BlobInfo.class, long.class, TimeUnit.class, SignUrlOption.class));
  }

  @Override
  public PostPolicyV4 generateSignedPostPolicyV4(
      BlobInfo blobInfo,
      long duration,
      TimeUnit unit,
      PostFieldsV4 fields,
      PostConditionsV4 conditions,
      PostPolicyV4Option... options) {
    return throwHttpJsonOnly(
        fmtMethodName(
            "generateSignedPostPolicyV4",
            BlobInfo.class,
            long.class,
            TimeUnit.class,
            PostFieldsV4.class,
            PostConditionsV4.class,
            PostPolicyV4Option.class));
  }

  @Override
  public PostPolicyV4 generateSignedPostPolicyV4(
      BlobInfo blobInfo,
      long duration,
      TimeUnit unit,
      PostFieldsV4 fields,
      PostPolicyV4Option... options) {
    return throwHttpJsonOnly(
        fmtMethodName(
            "generateSignedPostPolicyV4",
            BlobInfo.class,
            long.class,
            TimeUnit.class,
            PostFieldsV4.class,
            PostPolicyV4Option.class));
  }

  @Override
  public PostPolicyV4 generateSignedPostPolicyV4(
      BlobInfo blobInfo,
      long duration,
      TimeUnit unit,
      PostConditionsV4 conditions,
      PostPolicyV4Option... options) {
    return throwHttpJsonOnly(
        fmtMethodName(
            "generateSignedPostPolicyV4",
            BlobInfo.class,
            long.class,
            TimeUnit.class,
            PostConditionsV4.class,
            PostPolicyV4Option.class));
  }

  @Override
  public PostPolicyV4 generateSignedPostPolicyV4(
      BlobInfo blobInfo, long duration, TimeUnit unit, PostPolicyV4Option... options) {
    return throwHttpJsonOnly(
        fmtMethodName(
            "generateSignedPostPolicyV4",
            BlobInfo.class,
            long.class,
            TimeUnit.class,
            PostPolicyV4Option.class));
  }

  @Override
  public List<Blob> get(BlobId... blobIds) {
    return throwHttpJsonOnly(fmtMethodName("get", BlobId[].class));
  }

  @Override
  public List<Blob> get(Iterable<BlobId> blobIds) {
    return throwHttpJsonOnly(fmtMethodName("get", Iterable.class));
  }

  @Override
  public List<Blob> update(BlobInfo... blobInfos) {
    return throwHttpJsonOnly(fmtMethodName("update", BlobInfo[].class));
  }

  @Override
  public List<Blob> update(Iterable<BlobInfo> blobInfos) {
    return throwHttpJsonOnly(fmtMethodName("update", Iterable.class));
  }

  @Override
  public List<Boolean> delete(BlobId... blobIds) {
    return throwHttpJsonOnly(fmtMethodName("delete", BlobId[].class));
  }

  @Override
  public List<Boolean> delete(Iterable<BlobId> blobIds) {
    return throwHttpJsonOnly(fmtMethodName("delete", Iterable.class));
  }

  @Override
  public Acl getAcl(String bucket, Entity entity, BucketSourceOption... options) {
    try {
      Opts<BucketSourceOpt> opts = Opts.unwrap(options).prepend(defaultOpts);
      com.google.storage.v2.Bucket resp = getBucketWithAcls(bucket, opts);

      Predicate<BucketAccessControl> entityPredicate =
          bucketAclEntityOrAltEq(codecs.entity().encode(entity));

      Optional<BucketAccessControl> first =
          resp.getAclList().stream().filter(entityPredicate).findFirst();

      // HttpStorageRpc defaults to null if Not Found
      return first.map(codecs.bucketAcl()::decode).orElse(null);
    } catch (NotFoundException e) {
      return null;
    } catch (StorageException se) {
      if (se.getCode() == 404) {
        return null;
      } else {
        throw se;
      }
    }
  }

  @Override
  public Acl getAcl(String bucket, Entity entity) {
    return getAcl(bucket, entity, EMPTY_BUCKET_SOURCE_OPTIONS);
  }

  @Override
  public boolean deleteAcl(String bucket, Entity entity, BucketSourceOption... options) {
    try {
      Opts<BucketSourceOpt> opts = Opts.unwrap(options).prepend(defaultOpts);
      com.google.storage.v2.Bucket resp = getBucketWithAcls(bucket, opts);
      String encode = codecs.entity().encode(entity);

      Predicate<BucketAccessControl> entityPredicate = bucketAclEntityOrAltEq(encode);

      List<BucketAccessControl> currentAcls = resp.getAclList();
      ImmutableList<BucketAccessControl> newAcls =
          currentAcls.stream()
              .filter(entityPredicate.negate())
              .collect(ImmutableList.toImmutableList());
      if (newAcls.equals(currentAcls)) {
        // we didn't actually filter anything out, no need to send an RPC, simply return false
        return false;
      }
      long metageneration = resp.getMetageneration();

      UpdateBucketRequest req = createUpdateBucketAclRequest(bucket, newAcls, metageneration);

      com.google.storage.v2.Bucket updateResult = updateBucket(req);
      // read the response to ensure there is no longer an acl for the specified entity
      Optional<BucketAccessControl> first =
          updateResult.getAclList().stream().filter(entityPredicate).findFirst();
      return !first.isPresent();
    } catch (NotFoundException e) {
      // HttpStorageRpc returns false if the bucket doesn't exist :(
      return false;
    } catch (StorageException se) {
      if (se.getCode() == 404) {
        return false;
      } else {
        throw se;
      }
    }
  }

  @Override
  public boolean deleteAcl(String bucket, Entity entity) {
    return deleteAcl(bucket, entity, EMPTY_BUCKET_SOURCE_OPTIONS);
  }

  @Override
  public Acl createAcl(String bucket, Acl acl, BucketSourceOption... options) {
    return updateAcl(bucket, acl, options);
  }

  @Override
  public Acl createAcl(String bucket, Acl acl) {
    return createAcl(bucket, acl, EMPTY_BUCKET_SOURCE_OPTIONS);
  }

  @Override
  public Acl updateAcl(String bucket, Acl acl, BucketSourceOption... options) {
    try {
      Opts<BucketSourceOpt> opts = Opts.unwrap(options).prepend(defaultOpts);
      com.google.storage.v2.Bucket resp = getBucketWithAcls(bucket, opts);
      BucketAccessControl encode = codecs.bucketAcl().encode(acl);
      String entity = encode.getEntity();

      Predicate<BucketAccessControl> entityPredicate = bucketAclEntityOrAltEq(entity);

      ImmutableList<BucketAccessControl> newDefaultAcls =
          Streams.concat(
                  resp.getAclList().stream().filter(entityPredicate.negate()), Stream.of(encode))
              .collect(ImmutableList.toImmutableList());

      UpdateBucketRequest req =
          createUpdateBucketAclRequest(bucket, newDefaultAcls, resp.getMetageneration());

      com.google.storage.v2.Bucket updateResult = updateBucket(req);

      Optional<Acl> first =
          updateResult.getAclList().stream()
              .filter(entityPredicate)
              .findFirst()
              .map(codecs.bucketAcl()::decode);

      return first.orElseThrow(
          () -> new StorageException(0, "Acl update call success, but not in response"));
    } catch (NotFoundException e) {
      throw StorageException.coalesce(e);
    }
  }

  @Override
  public Acl updateAcl(String bucket, Acl acl) {
    return updateAcl(bucket, acl, EMPTY_BUCKET_SOURCE_OPTIONS);
  }

  @Override
  public List<Acl> listAcls(String bucket, BucketSourceOption... options) {
    try {
      Opts<BucketSourceOpt> opts = Opts.unwrap(options).prepend(defaultOpts);
      com.google.storage.v2.Bucket resp = getBucketWithAcls(bucket, opts);
      return resp.getAclList().stream()
          .map(codecs.bucketAcl()::decode)
          .collect(ImmutableList.toImmutableList());
    } catch (NotFoundException e) {
      throw StorageException.coalesce(e);
    }
  }

  @Override
  public List<Acl> listAcls(String bucket) {
    return listAcls(bucket, EMPTY_BUCKET_SOURCE_OPTIONS);
  }

  @Override
  public Acl getDefaultAcl(String bucket, Entity entity) {
    try {
      com.google.storage.v2.Bucket resp = getBucketWithDefaultAcls(bucket);

      Predicate<ObjectAccessControl> entityPredicate =
          objectAclEntityOrAltEq(codecs.entity().encode(entity));

      Optional<ObjectAccessControl> first =
          resp.getDefaultObjectAclList().stream().filter(entityPredicate).findFirst();

      // HttpStorageRpc defaults to null if Not Found
      return first.map(codecs.objectAcl()::decode).orElse(null);
    } catch (NotFoundException e) {
      return null;
    } catch (StorageException se) {
      if (se.getCode() == 404) {
        return null;
      } else {
        throw se;
      }
    }
  }

  @Override
  public boolean deleteDefaultAcl(String bucket, Entity entity) {
    try {
      com.google.storage.v2.Bucket resp = getBucketWithDefaultAcls(bucket);
      String encode = codecs.entity().encode(entity);

      Predicate<ObjectAccessControl> entityPredicate = objectAclEntityOrAltEq(encode);

      List<ObjectAccessControl> currentDefaultAcls = resp.getDefaultObjectAclList();
      ImmutableList<ObjectAccessControl> newDefaultAcls =
          currentDefaultAcls.stream()
              .filter(entityPredicate.negate())
              .collect(ImmutableList.toImmutableList());
      if (newDefaultAcls.equals(currentDefaultAcls)) {
        // we didn't actually filter anything out, no need to send an RPC, simply return false
        return false;
      }
      long metageneration = resp.getMetageneration();

      UpdateBucketRequest req =
          createUpdateDefaultAclRequest(bucket, newDefaultAcls, metageneration);

      com.google.storage.v2.Bucket updateResult = updateBucket(req);
      // read the response to ensure there is no longer an acl for the specified entity
      Optional<ObjectAccessControl> first =
          updateResult.getDefaultObjectAclList().stream().filter(entityPredicate).findFirst();
      return !first.isPresent();
    } catch (NotFoundException e) {
      // HttpStorageRpc returns false if the bucket doesn't exist :(
      return false;
    } catch (StorageException se) {
      if (se.getCode() == 404) {
        return false;
      } else {
        throw se;
      }
    }
  }

  @Override
  public Acl createDefaultAcl(String bucket, Acl acl) {
    return updateDefaultAcl(bucket, acl);
  }

  @Override
  public Acl updateDefaultAcl(String bucket, Acl acl) {
    try {
      com.google.storage.v2.Bucket resp = getBucketWithDefaultAcls(bucket);
      ObjectAccessControl encode = codecs.objectAcl().encode(acl);
      String entity = encode.getEntity();

      Predicate<ObjectAccessControl> entityPredicate = objectAclEntityOrAltEq(entity);

      ImmutableList<ObjectAccessControl> newDefaultAcls =
          Streams.concat(
                  resp.getDefaultObjectAclList().stream().filter(entityPredicate.negate()),
                  Stream.of(encode))
              .collect(ImmutableList.toImmutableList());

      UpdateBucketRequest req =
          createUpdateDefaultAclRequest(bucket, newDefaultAcls, resp.getMetageneration());

      com.google.storage.v2.Bucket updateResult = updateBucket(req);

      Optional<Acl> first =
          updateResult.getDefaultObjectAclList().stream()
              .filter(entityPredicate)
              .findFirst()
              .map(codecs.objectAcl()::decode);

      return first.orElseThrow(
          () -> new StorageException(0, "Acl update call success, but not in response"));
    } catch (NotFoundException e) {
      throw StorageException.coalesce(e);
    }
  }

  @Override
  public List<Acl> listDefaultAcls(String bucket) {
    try {
      com.google.storage.v2.Bucket resp = getBucketWithDefaultAcls(bucket);
      return resp.getDefaultObjectAclList().stream()
          .map(codecs.objectAcl()::decode)
          .collect(ImmutableList.toImmutableList());
    } catch (NotFoundException e) {
      throw StorageException.coalesce(e);
    }
  }

  @Override
  public Acl getAcl(BlobId blob, Entity entity) {
    try {
      Object req = codecs.blobId().encode(blob);
      Object resp = getObjectWithAcls(req);

      Predicate<ObjectAccessControl> entityPredicate =
          objectAclEntityOrAltEq(codecs.entity().encode(entity));

      Optional<ObjectAccessControl> first =
          resp.getAclList().stream().filter(entityPredicate).findFirst();

      // HttpStorageRpc defaults to null if Not Found
      return first.map(codecs.objectAcl()::decode).orElse(null);
    } catch (NotFoundException e) {
      return null;
    } catch (StorageException se) {
      if (se.getCode() == 404) {
        return null;
      } else {
        throw se;
      }
    }
  }

  @Override
  public boolean deleteAcl(BlobId blob, Entity entity) {
    try {
      Object obj = codecs.blobId().encode(blob);
      Object resp = getObjectWithAcls(obj);
      String encode = codecs.entity().encode(entity);

      Predicate<ObjectAccessControl> entityPredicate = objectAclEntityOrAltEq(encode);

      List<ObjectAccessControl> currentDefaultAcls = resp.getAclList();
      ImmutableList<ObjectAccessControl> newDefaultAcls =
          currentDefaultAcls.stream()
              .filter(entityPredicate.negate())
              .collect(ImmutableList.toImmutableList());
      if (newDefaultAcls.equals(currentDefaultAcls)) {
        // we didn't actually filter anything out, no need to send an RPC, simply return false
        return false;
      }
      long metageneration = resp.getMetageneration();

      UpdateObjectRequest req = createUpdateObjectAclRequest(obj, newDefaultAcls, metageneration);

      Object updateResult = updateObject(req);
      // read the response to ensure there is no longer an acl for the specified entity
      Optional<ObjectAccessControl> first =
          updateResult.getAclList().stream().filter(entityPredicate).findFirst();
      return !first.isPresent();
    } catch (NotFoundException e) {
      // HttpStorageRpc returns false if the bucket doesn't exist :(
      return false;
    } catch (StorageException se) {
      if (se.getCode() == 404) {
        return false;
      } else {
        throw se;
      }
    }
  }

  @Override
  public Acl createAcl(BlobId blob, Acl acl) {
    return updateAcl(blob, acl);
  }

  @Override
  public Acl updateAcl(BlobId blob, Acl acl) {
    try {
      Object obj = codecs.blobId().encode(blob);
      Object resp = getObjectWithAcls(obj);
      ObjectAccessControl encode = codecs.objectAcl().encode(acl);
      String entity = encode.getEntity();

      Predicate<ObjectAccessControl> entityPredicate = objectAclEntityOrAltEq(entity);

      ImmutableList<ObjectAccessControl> newDefaultAcls =
          Streams.concat(
                  resp.getAclList().stream().filter(entityPredicate.negate()), Stream.of(encode))
              .collect(ImmutableList.toImmutableList());

      UpdateObjectRequest req =
          createUpdateObjectAclRequest(obj, newDefaultAcls, resp.getMetageneration());

      Object updateResult = updateObject(req);

      Optional<Acl> first =
          updateResult.getAclList().stream()
              .filter(entityPredicate)
              .findFirst()
              .map(codecs.objectAcl()::decode);

      return first.orElseThrow(
          () -> new StorageException(0, "Acl update call success, but not in response"));
    } catch (NotFoundException e) {
      throw StorageException.coalesce(e);
    }
  }

  @Override
  public List<Acl> listAcls(BlobId blob) {
    try {
      Object req = codecs.blobId().encode(blob);
      Object resp = getObjectWithAcls(req);
      return resp.getAclList().stream()
          .map(codecs.objectAcl()::decode)
          .collect(ImmutableList.toImmutableList());
    } catch (NotFoundException e) {
      throw StorageException.coalesce(e);
    }
  }

  @Override
  public HmacKey createHmacKey(ServiceAccount serviceAccount, CreateHmacKeyOption... options) {
    return CrossTransportUtils.throwHttpJsonOnly(Storage.class, "createHmacKey");
  }

  @Override
  public Page<HmacKeyMetadata> listHmacKeys(ListHmacKeysOption... options) {
    return CrossTransportUtils.throwHttpJsonOnly(Storage.class, "listHmacKey");
  }

  @Override
  public HmacKeyMetadata getHmacKey(String accessId, GetHmacKeyOption... options) {
    return CrossTransportUtils.throwHttpJsonOnly(Storage.class, "getHmacKey");
  }

  @Override
  public void deleteHmacKey(HmacKeyMetadata hmacKeyMetadata, DeleteHmacKeyOption... options) {
    CrossTransportUtils.throwHttpJsonOnly(Storage.class, "deleteHmacKey");
  }

  @Override
  public HmacKeyMetadata updateHmacKeyState(
      HmacKeyMetadata hmacKeyMetadata, HmacKeyState state, UpdateHmacKeyOption... options) {
    return CrossTransportUtils.throwHttpJsonOnly(Storage.class, "updateHmacKeyState");
  }

  @Override
  public Policy getIamPolicy(String bucket, BucketSourceOption... options) {
    Opts<BucketSourceOpt> opts = Opts.unwrap(options).prepend(defaultOpts);
    GrpcCallContext grpcCallContext =
        opts.grpcMetadataMapper().apply(GrpcCallContext.createDefault());
    GetIamPolicyRequest.Builder builder =
        GetIamPolicyRequest.newBuilder().setResource(bucketNameCodec.encode(bucket));
    GetIamPolicyRequest req = opts.getIamPolicyRequest().apply(builder).build();
    GrpcCallContext merge = Utils.merge(grpcCallContext, Retrying.newCallContext());
    return retrier.run(
        retryAlgorithmManager.getFor(req),
        () -> storageClient.getIamPolicyCallable().call(req, merge),
        codecs.policyCodec());
  }

  @Override
  public Policy setIamPolicy(String bucket, Policy policy, BucketSourceOption... options) {
    Opts<BucketSourceOpt> opts = Opts.unwrap(options).prepend(defaultOpts);
    GrpcCallContext grpcCallContext =
        opts.grpcMetadataMapper().apply(GrpcCallContext.createDefault());
    SetIamPolicyRequest req =
        SetIamPolicyRequest.newBuilder()
            .setResource(bucketNameCodec.encode(bucket))
            .setPolicy(codecs.policyCodec().encode(policy))
            .build();
    GrpcCallContext merge = Utils.merge(grpcCallContext, Retrying.newCallContext());
    return retrier.run(
        retryAlgorithmManager.getFor(req),
        () -> storageClient.setIamPolicyCallable().call(req, merge),
        codecs.policyCodec());
  }

  @Override
  public List<Boolean> testIamPermissions(
      String bucket, List<String> permissions, BucketSourceOption... options) {
    Opts<BucketSourceOpt> opts = Opts.unwrap(options).prepend(defaultOpts);
    GrpcCallContext grpcCallContext =
        opts.grpcMetadataMapper().apply(GrpcCallContext.createDefault());
    TestIamPermissionsRequest req =
        TestIamPermissionsRequest.newBuilder()
            .setResource(bucketNameCodec.encode(bucket))
            .addAllPermissions(permissions)
            .build();
    GrpcCallContext merge = Utils.merge(grpcCallContext, Retrying.newCallContext());
    return retrier.run(
        retryAlgorithmManager.getFor(req),
        () -> storageClient.testIamPermissionsCallable().call(req, merge),
        resp -> {
          Set<String> heldPermissions = ImmutableSet.copyOf(resp.getPermissionsList());
          return permissions.stream()
              .map(heldPermissions::contains)
              .collect(ImmutableList.toImmutableList());
        });
  }

  @Override
  public ServiceAccount getServiceAccount(String projectId) {
    return CrossTransportUtils.throwHttpJsonOnly(Storage.class, "getServiceAccount");
  }

  @Override
  public Notification createNotification(String bucket, NotificationInfo notificationInfo) {
    return throwHttpJsonOnly(
        fmtMethodName("createNotification", String.class, NotificationInfo.class));
  }

  @Override
  public Notification getNotification(String bucket, String notificationId) {
    return throwHttpJsonOnly(fmtMethodName("getNotification", String.class, String.class));
  }

  @Override
  public List<Notification> listNotifications(String bucket) {
    return throwHttpJsonOnly(fmtMethodName("listNotifications", String.class));
  }

  @Override
  public boolean deleteNotification(String bucket, String notificationId) {
    return throwHttpJsonOnly(fmtMethodName("deleteNotification", String.class, String.class));
  }

  @BetaApi
  @Override
  public BlobWriteSession blobWriteSession(BlobInfo info, BlobWriteOption... options) {
    Opts<ObjectTargetOpt> opts = Opts.unwrap(options).resolveFrom(info);
    WritableByteChannelSession<?, BlobInfo> writableByteChannelSession =
        writerFactory.writeSession(this, info, opts);
    return BlobWriteSessions.of(writableByteChannelSession);
  }

  @BetaApi
  @Override
  public BlobAppendableUpload blobAppendableUpload(
      BlobInfo blobInfo, BlobAppendableUploadConfig uploadConfig, BlobWriteOption... options) {
    Opts<ObjectTargetOpt> opts = Opts.unwrap(options).resolveFrom(blobInfo);
    return uploadConfig.create(this, blobInfo, opts);
  }

  @Override
  public Blob moveBlob(MoveBlobRequest request) {
    Object srcObj = codecs.blobId().encode(request.getSource());
    Object dstObj = codecs.blobId().encode(request.getTarget());
    Opts<ObjectSourceOpt> srcOpts =
        Opts.unwrap(request.getSourceOptions()).resolveFrom(request.getSource()).projectAsSource();
    Opts<ObjectTargetOpt> dstOpts =
        Opts.unwrap(request.getTargetOptions()).resolveFrom(request.getTarget());
    MoveObjectRequest.Builder b =
        MoveObjectRequest.newBuilder()
            .setBucket(srcObj.getBucket())
            .setSourceObject(srcObj.getName())
            .setDestinationObject(dstObj.getName());

    srcOpts.moveObjectsRequest().apply(b);
    dstOpts.moveObjectsRequest().apply(b);

    MoveObjectRequest req = b.build();
    return retrier.run(
        retryAlgorithmManager.getFor(req),
        () -> storageClient.moveObjectCallable().call(req),
        syntaxDecoders.blob);
  }

  @Override
  public ApiFuture<BlobReadSession> blobReadSession(BlobId id, BlobSourceOption... options) {
    Opts<ObjectSourceOpt> opts = Opts.unwrap(options);
    Object object = codecs.blobId().encode(id);

    BidiReadObjectSpec.Builder spec =
        BidiReadObjectSpec.newBuilder().setBucket(object.getBucket()).setObject(object.getName());

    long generation = object.getGeneration();
    if (generation > 0) {
      spec.setGeneration(generation);
    }
    BidiReadObjectRequest.Builder b = BidiReadObjectRequest.newBuilder();
    b.setReadObjectSpec(spec);
    opts.bidiReadObjectRequest().apply(b);
    BidiReadObjectRequest req = b.build();

    GrpcCallContext context = opts.grpcMetadataMapper().apply(GrpcCallContext.createDefault());
    ApiFuture<ObjectReadSession> session = storageDataClient.readSession(req, context);

    return BlobReadSessionAdapter.wrap(session);
  }

  @Override
  public GrpcStorageOptions getOptions() {
    return (GrpcStorageOptions) super.getOptions();
  }

  boolean isClosed() {
    return storageClient.isShutdown();
  }

  private Blob getBlob(ApiFuture<WriteObjectResponse> result) {
    try {
      WriteObjectResponse response = ApiExceptions.callAndTranslateApiException(result);
      return syntaxDecoders.blob.decode(response.getResource());
    } catch (Exception e) {
      throw StorageException.coalesce(e);
    }
  }

  public AppendableUploadState getAppendableState(
      BlobInfo info, Opts<ObjectTargetOpt> opts, long maxPendingBytes) {
    boolean takeOver = info.getGeneration() != null;
    BidiWriteObjectRequest req =
        takeOver
            ? getBidiWriteObjectRequestForTakeover(info, opts)
            : getBidiWriteObjectRequest(info, opts, /* appendable= */ true);
    AppendableUploadState state;
    if (takeOver) {
      state =
          BidiUploadState.appendableTakeover(
              req,
              Retrying::newCallContext,
              maxPendingBytes,
              SettableApiFuture.create(),
              /* initialCrc32c= */ null);
    } else {
      state =
          BidiUploadState.appendableNew(
              req,
              Retrying::newCallContext,
              maxPendingBytes,
              SettableApiFuture.create(),
              opts.getHasher().initialValue());
    }
    return state;
  }

  /** Bind some decoders for our "Syntax" classes to this instance of GrpcStorageImpl */
  private final class SyntaxDecoders {

    final Decoder<Object, Blob> blob =
        o -> codecs.blobInfo().decode(o).asBlob(GrpcStorageImpl.this);
    final Decoder<com.google.storage.v2.Bucket, Bucket> bucket =
        b -> codecs.bucketInfo().decode(b).asBucket(GrpcStorageImpl.this);
  }

  /**
   * Today {@link com.google.cloud.storage.spi.v1.HttpStorageRpc#list(String, Map)} creates
   * synthetic objects to represent {@code prefixes} ("directories") returned as part of a list
   * objects response. Specifically, a StorageObject with an `isDirectory` attribute added.
   *
   * <p>This approach is not sound, and presents an otherwise ephemeral piece of metadata as an
   * actual piece of data. (A {@code prefix} is not actually an object, and therefor can't be
   * queried for other object metadata.)
   *
   * <p>In an effort to preserve compatibility with the current public API, this class attempts to
   * encapsulate the process of producing these Synthetic Directory Objects and lifting them into
   * the Page.
   *
   * <p>This behavior should NOT be carried forward to any possible new API for the storage client.
   */
  private final class ListObjectsWithSyntheticDirectoriesPage implements Page<Blob> {

    private final GrpcCallContext ctx;
    private final ListObjectsRequest req;
    private final ListObjectsResponse resp;

    private ListObjectsWithSyntheticDirectoriesPage(
        GrpcCallContext ctx, ListObjectsRequest req, ListObjectsResponse resp) {
      this.ctx = ctx;
      this.req = req;
      this.resp = resp;
    }

    @Override
    public boolean hasNextPage() {
      return !resp.getNextPageToken().isEmpty();
    }

    @Override
    public String getNextPageToken() {
      return resp.getNextPageToken();
    }

    @Override
    public Page<Blob> getNextPage() {
      ListObjectsRequest nextPageReq =
          req.toBuilder().setPageToken(resp.getNextPageToken()).build();
      try {
        GrpcCallContext merge = Utils.merge(ctx, Retrying.newCallContext());
        ListObjectsResponse nextPageResp =
            retrier.run(
                retryAlgorithmManager.getFor(nextPageReq),
                () -> storageClient.listObjectsCallable().call(nextPageReq, merge),
                Decoder.identity());
        return new ListObjectsWithSyntheticDirectoriesPage(ctx, nextPageReq, nextPageResp);
      } catch (Exception e) {
        throw StorageException.coalesce(e);
      }
    }

    @Override
    public Iterable<Blob> iterateAll() {
      // drop to our interface type to help type inference below with the stream.
      Page<Blob> curr = this;
      Predicate<Page<Blob>> exhausted = p -> p != null && p.hasNextPage();
      // Create a stream which will attempt to call getNextPage repeatedly until we meet our
      // condition of exhaustion. By doing this we are able to rely on the retry logic in
      // getNextPage
      return () ->
          streamIterate(curr, exhausted, Page::getNextPage)
              .filter(Objects::nonNull)
              .flatMap(p -> StreamSupport.stream(p.getValues().spliterator(), false))
              .iterator();
    }

    @Override
    public Iterable<Blob> getValues() {
      return () -> {
        String bucketName = bucketNameCodec.decode(req.getParent());
        return Streams.concat(
                resp.getObjectsList().stream().map(syntaxDecoders.blob::decode),
                resp.getPrefixesList().stream()
                    .map(
                        prefix ->
                            BlobInfo.newBuilder(bucketName, prefix)
                                .setSize(0L)
                                .setIsDirectory(true)
                                .build())
                    .map(info -> info.asBlob(GrpcStorageImpl.this)))
            .iterator();
      };
    }
  }

  private final class ListBucketsWithPartialSuccessPage implements Page<Bucket> {

    private final GrpcCallContext ctx;
    private final ListBucketsRequest req;
    private final com.google.storage.v2.ListBucketsResponse resp;
    private final Opts<BucketListOpt> opts;

    private ListBucketsWithPartialSuccessPage(
        GrpcCallContext ctx,
        ListBucketsRequest req,
        com.google.storage.v2.ListBucketsResponse resp,
        Opts<BucketListOpt> opts) {
      this.ctx = ctx;
      this.req = req;
      this.resp = resp;
      this.opts = opts;
    }

    @Override
    public boolean hasNextPage() {
      return !resp.getNextPageToken().isEmpty();
    }

    @Override
    public String getNextPageToken() {
      return resp.getNextPageToken();
    }

    @Override
    public Page<Bucket> getNextPage() {
      if (!hasNextPage()) {
        return null;
      }
      ListBucketsRequest nextPageReq =
          req.toBuilder().setPageToken(resp.getNextPageToken()).build();
      try {
        com.google.storage.v2.ListBucketsResponse nextPageResp = listBuckets(ctx, nextPageReq);
        return new ListBucketsWithPartialSuccessPage(ctx, nextPageReq, nextPageResp, opts);
      } catch (Exception e) {
        throw StorageException.coalesce(e);
      }
    }

    @Override
    public Iterable<Bucket> getValues() {
      Decoder<com.google.storage.v2.Bucket, Bucket> bucketDecoder =
          syntaxDecoders.bucket.andThen(opts.clearBucketFields());
      Stream<Bucket> reachable = resp.getBucketsList().stream().map(bucketDecoder::decode);
      Stream<Bucket> unreachable =
          resp.getUnreachableList().stream()
              .map(
                  name -> {
                    String decoded = bucketNameCodec.decode(name);
                    return BucketInfo.newBuilder(decoded)
                        .setIsUnreachable(true)
                        .build()
                        .asBucket(GrpcStorageImpl.this);
                  });
      return Streams.concat(reachable, unreachable).collect(ImmutableList.toImmutableList());
    }

    @Override
    public Iterable<Bucket> iterateAll() {
      Page<Bucket> curr = this;
      return () ->
          streamIterate(curr, p -> p != null && p.hasNextPage(), Page::getNextPage)
              .filter(Objects::nonNull)
              .flatMap(p -> StreamSupport.stream(p.getValues().spliterator(), false))
              .iterator();
    }
  }

  static final class TransformingPageDecorator<
          RequestT,
          ResponseT,
          ResourceT,
          PageT extends AbstractPage<RequestT, ResponseT, ResourceT, PageT>,
          ModelT>
      implements Page<ModelT> {

    private final PageT page;
    private final Decoder<ResourceT, ModelT> translator;
    private final Retrier retrier;
    private final ResultRetryAlgorithm<?> resultRetryAlgorithm;

    TransformingPageDecorator(
        PageT page,
        Decoder<ResourceT, ModelT> translator,
        Retrier retrier,
        ResultRetryAlgorithm<?> resultRetryAlgorithm) {
      this.page = page;
      this.translator = translator;
      this.retrier = retrier;
      this.resultRetryAlgorithm = resultRetryAlgorithm;
    }

    @Override
    public boolean hasNextPage() {
      return page.hasNextPage();
    }

    @Override
    public String getNextPageToken() {
      return page.getNextPageToken();
    }

    @Override
    public Page<ModelT> getNextPage() {
      return new TransformingPageDecorator<>(
          page.getNextPage(), translator, retrier, resultRetryAlgorithm);
    }

    @SuppressWarnings({"Convert2MethodRef"})
    @Override
    public Iterable<ModelT> iterateAll() {
      // iterateAll on AbstractPage isn't very friendly to decoration, as getNextPage isn't actually
      // ever called. This means we aren't able to apply our retry wrapping there.
      // Instead, what we do is create a stream which will attempt to call getNextPage repeatedly
      // until we meet some condition of exhaustion. At that point we can apply our retry logic.
      return () ->
          streamIterate(
                  page,
                  p -> p != null && p.hasNextPage(),
                  prev -> {
                    // TODO: retry token header
                    // explicitly define this callable rather than using the method reference to
                    // prevent a javac 1.8 exception
                    // https://bugs.java.com/bugdatabase/view_bug.do?bug_id=8056984
                    Callable<PageT> c = () -> prev.getNextPage();
                    return retrier.run(resultRetryAlgorithm, c, Decoder.identity());
                  })
              .filter(Objects::nonNull)
              .flatMap(p -> StreamSupport.stream(p.getValues().spliterator(), false))
              .map(translator::decode)
              .iterator();
    }

    @Override
    public Iterable<ModelT> getValues() {
      return () ->
          StreamSupport.stream(page.getValues().spliterator(), false)
              .map(translator::decode)
              .iterator();
    }
  }

  private static <T> Stream<T> streamIterate(
      T seed, Predicate<? super T> shouldComputeNext, UnaryOperator<T> computeNext) {
    requireNonNull(seed, "seed must be non null");
    requireNonNull(shouldComputeNext, "shouldComputeNext must be non null");
    requireNonNull(computeNext, "computeNext must be non null");
    Spliterator<T> spliterator =
        new AbstractSpliterator<T>(Long.MAX_VALUE, 0) {
          T prev;
          boolean started = false;
          boolean done = false;

          @Override
          public boolean tryAdvance(Consumer<? super T> action) {
            // if we haven't started, emit our seed and return
            if (!started) {
              started = true;
              action.accept(seed);
              prev = seed;
              return true;
            }
            // if we've previously finished quickly return
            if (done) {
              return false;
            }
            // test whether we should try and compute the next value
            if (shouldComputeNext.test(prev)) {
              // compute the next value and figure out if we can use it
              T next = computeNext.apply(prev);
              if (next != null) {
                action.accept(next);
                prev = next;
                return true;
              }
            }

            // fallthrough, if we haven't taken an action by now consider the stream done and
            // return
            done = true;
            return false;
          }
        };
    return StreamSupport.stream(spliterator, false);
  }

  ReadObjectRequest getReadObjectRequest(BlobId blob, Opts<ObjectSourceOpt> opts) {
    Object object = codecs.blobId().encode(blob);

    ReadObjectRequest.Builder builder =
        ReadObjectRequest.newBuilder().setBucket(object.getBucket()).setObject(object.getName());

    long generation = object.getGeneration();
    if (generation > 0) {
      builder.setGeneration(generation);
    }
    return opts.readObjectRequest().apply(builder).build();
  }

  WriteObjectRequest getWriteObjectRequest(BlobInfo info, Opts<ObjectTargetOpt> opts) {
    Object object = codecs.blobInfo().encode(info);
    Object.Builder objectBuilder =
        object.toBuilder()
            // required if the data is changing
            .clearChecksums()
            // trimmed to shave payload size
            .clearGeneration()
            .clearMetageneration()
            .clearSize()
            .clearCreateTime()
            .clearUpdateTime();
    WriteObjectSpec.Builder specBuilder = WriteObjectSpec.newBuilder().setResource(objectBuilder);

    WriteObjectRequest.Builder requestBuilder =
        WriteObjectRequest.newBuilder().setWriteObjectSpec(specBuilder);

    return opts.writeObjectRequest().apply(requestBuilder).build();
  }

  BidiWriteObjectRequest getBidiWriteObjectRequest(
      BlobInfo info, Opts<ObjectTargetOpt> opts, boolean appendable) {
    Object object = codecs.blobInfo().encode(info);
    Object.Builder objectBuilder =
        object.toBuilder()
            // clear out the checksums, if a crc32cMatch is specified it'll come back via opts
            .clearChecksums()
            .clearGeneration()
            .clearMetageneration()
            .clearSize()
            .clearCreateTime()
            .clearUpdateTime();
    WriteObjectSpec.Builder specBuilder = WriteObjectSpec.newBuilder().setResource(objectBuilder);
    if (appendable) {
      specBuilder.setAppendable(true);
    }

    BidiWriteObjectRequest.Builder requestBuilder =
        BidiWriteObjectRequest.newBuilder().setWriteObjectSpec(specBuilder);

    return opts.bidiWriteObjectRequest().apply(requestBuilder).build();
  }

  BidiWriteObjectRequest getBidiWriteObjectRequestForTakeover(
      BlobInfo info, Opts<ObjectTargetOpt> opts) {
    Object object = codecs.blobInfo().encode(info);
    AppendObjectSpec.Builder specBuilder =
        AppendObjectSpec.newBuilder()
            .setObject(object.getName())
            .setBucket(object.getBucket())
            .setGeneration(object.getGeneration());

    BidiWriteObjectRequest.Builder requestBuilder =
        BidiWriteObjectRequest.newBuilder().setAppendObjectSpec(specBuilder.build());

    return opts.bidiWriteObjectRequest().apply(requestBuilder).build();
  }

  private UnbufferedReadableByteChannelSession<Object> unbufferedReadSession(
      BlobId blob, BlobSourceOption[] options) {

    Opts<ObjectSourceOpt> opts = Opts.unwrap(options).resolveFrom(blob).prepend(defaultOpts);
    ReadObjectRequest readObjectRequest = getReadObjectRequest(blob, opts);
    GrpcCallContext grpcCallContext = opts.grpcMetadataMapper().apply(Retrying.newCallContext());
    return ResumableMedia.gapic()
        .read()
        .byteChannel(
            readObjectCallable(grpcCallContext),
            retrier,
            retryAlgorithmManager.getFor(readObjectRequest))
        .setAutoGzipDecompression(!opts.autoGzipDecompression())
        .unbuffered()
        .setReadObjectRequest(readObjectRequest)
        .build();
  }

  @VisibleForTesting
  ApiFuture<ResumableWrite> startResumableWrite(
      GrpcCallContext grpcCallContext, WriteObjectRequest req, Opts<ObjectTargetOpt> opts) {
    GrpcCallContext merge = Utils.merge(grpcCallContext, Retrying.newCallContext());
    return ResumableMedia.gapic()
        .write()
        .resumableWrite(
            storageClient.startResumableWriteCallable().withDefaultCallContext(merge),
            req,
            opts,
            retrier.withAlg(retryAlgorithmManager.getFor(req)));
  }

  ApiFuture<BidiResumableWrite> startResumableWrite(
      GrpcCallContext grpcCallContext, BidiWriteObjectRequest req, Opts<ObjectTargetOpt> opts) {
    GrpcCallContext merge = Utils.merge(grpcCallContext, Retrying.newCallContext());
    return ResumableMedia.gapic()
        .write()
        .bidiResumableWrite(
            storageClient.startResumableWriteCallable().withDefaultCallContext(merge),
            req,
            opts,
            retrier.withAlg(retryAlgorithmManager.getFor(req)));
  }

  private SourceObject sourceObjectEncode(SourceBlob from) {
    SourceObject.Builder to = SourceObject.newBuilder();
    to.setName(from.getName());
    ifNonNull(from.getGeneration(), to::setGeneration);
    return to.build();
  }

  private com.google.storage.v2.ListBucketsResponse listBuckets(
      GrpcCallContext grpcCallContext, ListBucketsRequest request) {
    GrpcCallContext merge = Utils.merge(grpcCallContext, Retrying.newCallContext());
    return retrier.run(
        retryAlgorithmManager.getFor(request),
        () -> storageClient.listBucketsCallable().call(request, merge),
        Decoder.identity());
  }

  private com.google.storage.v2.Bucket getBucketWithDefaultAcls(String bucketName) {
    Fields fields =
        UnifiedOpts.fields(
            ImmutableSet.of(
                BucketField.ACL, // workaround for b/261771961
                BucketField.DEFAULT_OBJECT_ACL,
                BucketField.METAGENERATION));
    GrpcCallContext grpcCallContext = GrpcCallContext.createDefault();
    GetBucketRequest req =
        fields
            .getBucket()
            .apply(GetBucketRequest.newBuilder())
            .setName(bucketNameCodec.encode(bucketName))
            .build();

    GrpcCallContext merge = Utils.merge(grpcCallContext, Retrying.newCallContext());
    return retrier.run(
        retryAlgorithmManager.getFor(req),
        () -> storageClient.getBucketCallable().call(req, merge),
        Decoder.identity());
  }

  private com.google.storage.v2.Bucket getBucketWithAcls(
      String bucketName, Opts<BucketSourceOpt> opts) {
    Fields fields =
        UnifiedOpts.fields(ImmutableSet.of(BucketField.ACL, BucketField.METAGENERATION));
    GrpcCallContext grpcCallContext = GrpcCallContext.createDefault();
    Mapper<GetBucketRequest.Builder> mapper = opts.getBucketsRequest().andThen(fields.getBucket());
    GetBucketRequest req =
        mapper
            .apply(GetBucketRequest.newBuilder())
            .setName(bucketNameCodec.encode(bucketName))
            .build();

    GrpcCallContext merge = Utils.merge(grpcCallContext, Retrying.newCallContext());
    return retrier.run(
        retryAlgorithmManager.getFor(req),
        () -> storageClient.getBucketCallable().call(req, merge),
        Decoder.identity());
  }

  private com.google.storage.v2.Bucket updateBucket(UpdateBucketRequest req) {
    GrpcCallContext grpcCallContext = GrpcCallContext.createDefault();
    GrpcCallContext merge = Utils.merge(grpcCallContext, Retrying.newCallContext());
    return retrier.run(
        retryAlgorithmManager.getFor(req),
        () -> storageClient.updateBucketCallable().call(req, merge),
        Decoder.identity());
  }

  private static UpdateBucketRequest createUpdateDefaultAclRequest(
      String bucket, ImmutableList<ObjectAccessControl> newDefaultAcls, long metageneration) {
    com.google.storage.v2.Bucket update =
        com.google.storage.v2.Bucket.newBuilder()
            .setName(bucketNameCodec.encode(bucket))
            .addAllDefaultObjectAcl(newDefaultAcls)
            .build();
    Opts<BucketTargetOpt> opts =
        Opts.from(
            UnifiedOpts.fields(ImmutableSet.of(BucketField.DEFAULT_OBJECT_ACL)),
            UnifiedOpts.metagenerationMatch(metageneration));
    return opts.updateBucketsRequest()
        .apply(UpdateBucketRequest.newBuilder())
        .setBucket(update)
        .build();
  }

  private static UpdateBucketRequest createUpdateBucketAclRequest(
      String bucket, ImmutableList<BucketAccessControl> newDefaultAcls, long metageneration) {
    com.google.storage.v2.Bucket update =
        com.google.storage.v2.Bucket.newBuilder()
            .setName(bucketNameCodec.encode(bucket))
            .addAllAcl(newDefaultAcls)
            .build();
    Opts<BucketTargetOpt> opts =
        Opts.from(
            UnifiedOpts.fields(ImmutableSet.of(BucketField.ACL)),
            UnifiedOpts.metagenerationMatch(metageneration));
    return opts.updateBucketsRequest()
        .apply(UpdateBucketRequest.newBuilder())
        .setBucket(update)
        .build();
  }

  private Object getObjectWithAcls(Object obj) {
    Fields fields =
        UnifiedOpts.fields(ImmutableSet.of(BucketField.ACL, BucketField.METAGENERATION));
    GrpcCallContext grpcCallContext = GrpcCallContext.createDefault();
    GetObjectRequest req =
        fields
            .getObject()
            .apply(GetObjectRequest.newBuilder())
            .setBucket(obj.getBucket())
            .setObject(obj.getName())
            .build();

    GrpcCallContext merge = Utils.merge(grpcCallContext, Retrying.newCallContext());
    return retrier.run(
        retryAlgorithmManager.getFor(req),
        () -> storageClient.getObjectCallable().call(req, merge),
        Decoder.identity());
  }

  private static UpdateObjectRequest createUpdateObjectAclRequest(
      Object obj, ImmutableList<ObjectAccessControl> newAcls, long metageneration) {
    Object update =
        Object.newBuilder()
            .setBucket(obj.getBucket())
            .setName(obj.getName())
            .addAllAcl(newAcls)
            .build();
    Opts<BucketTargetOpt> opts =
        Opts.from(
            UnifiedOpts.fields(ImmutableSet.of(BlobField.ACL)),
            UnifiedOpts.metagenerationMatch(metageneration));
    return opts.updateObjectsRequest()
        .apply(UpdateObjectRequest.newBuilder())
        .setObject(update)
        .build();
  }

  private Object updateObject(UpdateObjectRequest req) {
    GrpcCallContext grpcCallContext = GrpcCallContext.createDefault();
    GrpcCallContext merge = Utils.merge(grpcCallContext, Retrying.newCallContext());
    return retrier.run(
        retryAlgorithmManager.getFor(req),
        () -> storageClient.updateObjectCallable().call(req, merge),
        Decoder.identity());
  }

  @NonNull
  @Override
  public BlobInfo internalObjectGet(BlobId blobId, Opts<ObjectSourceOpt> opts) {
    Opts<ObjectSourceOpt> finalOpts = opts.prepend(defaultOpts).prepend(ALL_BLOB_FIELDS);
    GrpcCallContext grpcCallContext =
        finalOpts.grpcMetadataMapper().apply(GrpcCallContext.createDefault());
    GetObjectRequest.Builder builder =
        GetObjectRequest.newBuilder()
            .setBucket(bucketNameCodec.encode(blobId.getBucket()))
            .setObject(blobId.getName());
    ifNonNull(blobId.getGeneration(), builder::setGeneration);
    GetObjectRequest req = finalOpts.getObjectsRequest().apply(builder).build();
    GrpcCallContext merge = Utils.merge(grpcCallContext, Retrying.newCallContext());
    //noinspection DataFlowIssue
    return retrier.run(
        retryAlgorithmManager.getFor(req),
        () -> storageClient.getObjectCallable().call(req, merge),
        resp -> {
          BlobInfo tmp = codecs.blobInfo().decode(resp);
          return finalOpts.clearBlobFields().decode(tmp);
        });
  }

  @Nullable
  private Blob internalBlobGet(BlobId blob, Opts<ObjectSourceOpt> unwrap) {
    Opts<ObjectSourceOpt> opts = unwrap.resolveFrom(blob);
    try {
      return internalObjectGet(blob, opts).asBlob(this);
    } catch (StorageException e) {
      if (e.getCause() instanceof NotFoundException) {
        return null;
      } else {
        throw e;
      }
    } catch (NotFoundException nfe) {
      return null;
    }
  }

  @Nullable
  private Bucket internalBucketGet(String bucket, Opts<BucketSourceOpt> unwrap) {
    Opts<BucketSourceOpt> opts = unwrap.prepend(defaultOpts).prepend(ALL_BUCKET_FIELDS);
    GrpcCallContext grpcCallContext =
        opts.grpcMetadataMapper().apply(GrpcCallContext.createDefault());
    GetBucketRequest.Builder builder =
        GetBucketRequest.newBuilder().setName(bucketNameCodec.encode(bucket));
    GetBucketRequest req = opts.getBucketsRequest().apply(builder).build();
    GrpcCallContext merge = Utils.merge(grpcCallContext, Retrying.newCallContext());
    return retrier.run(
        retryAlgorithmManager.getFor(req),
        () -> {
          try {
            return storageClient.getBucketCallable().call(req, merge);
          } catch (NotFoundException e) {
            return null;
          }
        },
        syntaxDecoders.bucket.andThen(opts.clearBucketFields()));
  }

  private ZeroCopyServerStreamingCallable<ReadObjectRequest, ReadObjectResponse> readObjectCallable(
      GrpcCallContext grpcCallContext) {
    return new ZeroCopyServerStreamingCallable<>(
        storageClient.readObjectCallable().withDefaultCallContext(grpcCallContext),
        responseContentLifecycleManager);
  }
}
