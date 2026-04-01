/*
 * Copyright 2023 Google LLC
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
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.BaseServiceException;
import com.google.cloud.storage.ApiFutureUtils.OnFailureApiFutureCallback;
import com.google.cloud.storage.ApiFutureUtils.OnSuccessApiFutureCallback;
import com.google.cloud.storage.AsyncAppendingQueue.ShortCircuitException;
import com.google.cloud.storage.BufferHandlePool.PooledBuffer;
import com.google.cloud.storage.BufferedWritableByteChannelSession.BufferedWritableByteChannel;
import com.google.cloud.storage.MetadataField.PartRange;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.PartCleanupStrategy;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.PartMetadataFieldDecoratorInstance;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.PartNamingStrategy;
import com.google.cloud.storage.Storage.ComposeRequest;
import com.google.cloud.storage.UnifiedOpts.Crc32cMatch;
import com.google.cloud.storage.UnifiedOpts.GenerationMatch;
import com.google.cloud.storage.UnifiedOpts.GenerationNotMatch;
import com.google.cloud.storage.UnifiedOpts.Md5Match;
import com.google.cloud.storage.UnifiedOpts.MetagenerationMatch;
import com.google.cloud.storage.UnifiedOpts.MetagenerationNotMatch;
import com.google.cloud.storage.UnifiedOpts.ObjectSourceOpt;
import com.google.cloud.storage.UnifiedOpts.ObjectTargetOpt;
import com.google.cloud.storage.UnifiedOpts.Opts;
import com.google.cloud.storage.UnifiedOpts.ResumableUploadExpectedObjectSize;
import com.google.cloud.storage.UnifiedOpts.SourceGenerationMatch;
import com.google.cloud.storage.UnifiedOpts.SourceGenerationNotMatch;
import com.google.cloud.storage.UnifiedOpts.SourceMetagenerationMatch;
import com.google.cloud.storage.UnifiedOpts.SourceMetagenerationNotMatch;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import io.grpc.Status.Code;
import io.opentelemetry.context.Context;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

@SuppressWarnings("UnstableApiUsage") // guava hashing
final class ParallelCompositeUploadWritableByteChannel implements BufferedWritableByteChannel {

  private static final MetadataField<String> FINAL_OBJECT_NAME =
      MetadataField.forString("pcu_finalObjectName");
  private static final MetadataField<PartRange> PART_INDEX =
      MetadataField.forPartRange("pcu_partIndex");
  private static final MetadataField<Long> OBJECT_OFFSET =
      MetadataField.forLong("pcu_objectOffset");
  private static final Comparator<BlobInfo> comparator =
      Comparator.comparing(PART_INDEX::readFrom, PartRange.COMP);
  private static final Predicate<ObjectTargetOpt> TO_EXCLUDE_FROM_PARTS;
  // when creating a part or composing we include a precondition so that it can be retried
  private static final Opts<GenerationMatch> DOES_NOT_EXIST =
      Opts.from(UnifiedOpts.generationMatch(0));

  static {
    //noinspection deprecation
    Predicate<ObjectTargetOpt> tmp =
        o ->
            o instanceof GenerationMatch
                || o instanceof GenerationNotMatch
                || o instanceof MetagenerationMatch
                || o instanceof MetagenerationNotMatch
                || o instanceof SourceGenerationMatch
                || o instanceof SourceGenerationNotMatch
                || o instanceof SourceMetagenerationMatch
                || o instanceof SourceMetagenerationNotMatch
                || o instanceof Crc32cMatch
                || o instanceof Md5Match
                || o instanceof ResumableUploadExpectedObjectSize;
    TO_EXCLUDE_FROM_PARTS = tmp.negate();
  }

  // immutable provided values
  private final BufferHandlePool bufferPool;
  private final Executor exec;
  private final PartNamingStrategy partNamingStrategy;
  private final PartCleanupStrategy partCleanupStrategy;
  private final int maxElementsPerCompact;
  private final PartMetadataFieldDecoratorInstance partMetadataFieldDecorator;
  private final SettableApiFuture<BlobInfo> finalObject;
  private final StorageInternal storage;
  private final BlobInfo ultimateObject;
  private final Opts<ObjectTargetOpt> opts;

  // immutable bootstrapped state
  private final Opts<ObjectTargetOpt> partOpts;
  private final Opts<ObjectSourceOpt> srcOpts;
  private final AsyncAppendingQueue<BlobInfo> queue;
  private final FailureForwarder failureForwarder;
  // mutable running state
  private final List<ApiFuture<BlobInfo>> pendingParts;
  private final List<BlobId> successfulParts;
  private final Hasher cumulativeHasher;
  private boolean open;
  private long totalObjectOffset;
  private PooledBuffer current;

  ParallelCompositeUploadWritableByteChannel(
      BufferHandlePool bufferPool,
      Executor exec,
      PartNamingStrategy partNamingStrategy,
      PartCleanupStrategy partCleanupStrategy,
      int maxElementsPerCompact,
      PartMetadataFieldDecoratorInstance partMetadataFieldDecorator,
      SettableApiFuture<BlobInfo> finalObject,
      StorageInternal storage,
      BlobInfo ultimateObject,
      Opts<ObjectTargetOpt> opts) {
    this.bufferPool = bufferPool;
    this.exec = Context.current().wrap(exec);
    this.partNamingStrategy = partNamingStrategy;
    this.partCleanupStrategy = partCleanupStrategy;
    this.maxElementsPerCompact = maxElementsPerCompact;
    this.partMetadataFieldDecorator = partMetadataFieldDecorator;
    this.finalObject = finalObject;
    this.storage = storage;
    this.ultimateObject = ultimateObject;
    this.opts = opts;
    this.queue = AsyncAppendingQueue.of(this.exec, maxElementsPerCompact, this::compose);
    this.pendingParts = new ArrayList<>();
    // this can be modified by another thread
    this.successfulParts = Collections.synchronizedList(new ArrayList<>());
    this.open = true;
    this.totalObjectOffset = 0;

    this.partOpts = getPartOpts(opts);
    this.srcOpts = partOpts.transformTo(ObjectSourceOpt.class);
    this.cumulativeHasher = Hashing.crc32c().newHasher();
    this.failureForwarder = new FailureForwarder();
  }

  @Override
  public int write(ByteBuffer src) throws IOException {
    if (!open) {
      throw new ClosedChannelException();
    }

    int remaining = src.remaining();
    cumulativeHasher.putBytes(src.duplicate());
    while (src.hasRemaining()) {
      if (current == null) {
        current = bufferPool.getBuffer();
      }

      ByteBuffer buf = current.getBufferHandle().get();
      Buffers.copy(src, buf);

      if (!buf.hasRemaining()) {
        internalFlush(buf);
      }
    }

    return remaining;
  }

  @Override
  public boolean isOpen() {
    return open;
  }

  @Override
  public void flush() throws IOException {
    if (current != null) {
      ByteBuffer buf = current.getBufferHandle().get();
      internalFlush(buf);
    }
  }

  @Override
  public void close() throws IOException {
    if (!open) {
      return;
    }
    open = false;

    flush();

    try {
      queue.close();
    } catch (NoSuchElementException e) {
      // We never created any parts
      // create an empty object
      try {
        BlobInfo blobInfo = storage.internalDirectUpload(ultimateObject, opts, Buffers.allocate(0));
        finalObject.set(blobInfo);
        return;
      } catch (StorageException se) {
        finalObject.setException(se);
        throw se;
      }
    }

    String expectedCrc32c = Utils.crc32cCodec.encode(cumulativeHasher.hash().asInt());
    ApiFuture<BlobInfo> closingTransform =
        ApiFutures.transformAsync(queue.getResult(), this::cleanupParts, exec);
    ApiFuture<BlobInfo> validatingTransform =
        ApiFutures.transformAsync(
            closingTransform,
            finalInfo -> {
              String crc32c = finalInfo.getCrc32c();
              if (expectedCrc32c.equals(crc32c)) {
                return ApiFutures.immediateFuture(finalInfo);
              } else {
                return ApiFutures.immediateFailedFuture(
                    StorageException.coalesce(
                        buildParallelCompositeUploadException(
                            ApiExceptionFactory.createException(
                                String.format(
                                    Locale.US,
                                    "CRC32C Checksum mismatch. expected: [%s] but was: [%s]",
                                    expectedCrc32c,
                                    crc32c),
                                null,
                                GrpcStatusCode.of(Code.DATA_LOSS),
                                false),
                            exec,
                            pendingParts,
                            successfulParts)));
              }
            },
            exec);

    if (partCleanupStrategy.isDeleteAllOnError()) {
      ApiFuture<BlobInfo> cleaningFuture =
          ApiFutures.catchingAsync(
              validatingTransform, Throwable.class, this::asyncCleanupAfterFailure, exec);
      ApiFutures.addCallback(cleaningFuture, failureForwarder, exec);
    } else {
      ApiFutures.addCallback(validatingTransform, failureForwarder, exec);
    }

    // we don't need the value from this, but we do need any exception that might be present
    try {
      ApiFutureUtils.await(validatingTransform);
    } catch (Throwable t) {
      AsynchronousCloseException e = new AsynchronousCloseException();
      e.initCause(t);
      throw e;
    }
  }

  private void internalFlush(ByteBuffer buf) {
    Buffers.flip(buf);
    int pendingByteCount = buf.remaining();
    int partIndex = pendingParts.size() + 1;
    BlobInfo partInfo = definePart(ultimateObject, PartRange.of(partIndex), totalObjectOffset);
    ApiFuture<BlobInfo> partFuture =
        ApiFutures.transform(
            ApiFutures.immediateFuture(partInfo),
            info -> {
              try {
                return storage.internalDirectUpload(info, partOpts, buf);
              } catch (StorageException e) {
                // a precondition failure usually means the part was created, but we didn't get the
                // response. And when we tried to retry the object already exists.
                if (e.getCode() == 412) {
                  return storage.internalObjectGet(info.getBlobId(), srcOpts);
                } else {
                  throw e;
                }
              }
            },
            exec);

    ApiFutures.addCallback(
        partFuture,
        new BufferHandleReleaser<>(
            bufferPool,
            current,
            (OnSuccessApiFutureCallback<BlobInfo>)
                result -> successfulParts.add(result.getBlobId())),
        exec);

    pendingParts.add(partFuture);
    try {
      queue.append(partFuture);
      totalObjectOffset += pendingByteCount;
    } catch (ShortCircuitException e) {
      open = false;
      bufferPool.returnBuffer(current);

      // attempt to cancel any pending requests which haven't started yet
      for (ApiFuture<BlobInfo> pendingPart : pendingParts) {
        pendingPart.cancel(false);
      }

      Throwable cause = e.getCause();
      BaseServiceException storageException;
      if (partCleanupStrategy.isDeleteAllOnError()) {
        storageException = StorageException.coalesce(cause);
        ApiFuture<Object> cleanupFutures = asyncCleanupAfterFailure(storageException);
        // asynchronously fail the finalObject future
        CancellationException cancellationException =
            new CancellationException(storageException.getMessage());
        cancellationException.initCause(storageException);
        ApiFutures.addCallback(
            cleanupFutures,
            new ApiFutureCallback<Object>() {
              @Override
              public void onFailure(Throwable throwable) {
                cancellationException.addSuppressed(throwable);
                failureForwarder.onFailure(cancellationException);
              }

              @Override
              public void onSuccess(Object o) {
                failureForwarder.onFailure(cancellationException);
              }
            },
            exec);
        // this will throw out if anything fails
        ApiFutureUtils.await(cleanupFutures);
      } else {
        // create our exception containing information about the upload context
        ParallelCompositeUploadException pcue =
            buildParallelCompositeUploadException(cause, exec, pendingParts, successfulParts);
        storageException = StorageException.coalesce(pcue);
        // asynchronously fail the finalObject future
        CancellationException cancellationException =
            new CancellationException(storageException.getMessage());
        cancellationException.initCause(storageException);
        ApiFutures.addCallback(
            ApiFutures.immediateFailedFuture(cancellationException),
            (OnFailureApiFutureCallback<BlobInfo>) failureForwarder::onFailure,
            exec);
        throw storageException;
      }
    } finally {
      current = null;
    }
  }

  @SuppressWarnings("DataFlowIssue")
  private BlobInfo compose(ImmutableList<BlobInfo> parts) {
    ComposeRequest.Builder builder = ComposeRequest.newBuilder();

    List<BlobInfo> sorted = parts.stream().sorted(comparator).collect(Collectors.toList());

    sorted.stream()
        .map(BlobInfo::getBlobId)
        .forEach(id -> builder.addSource(id.getName(), id.getGeneration()));

    if (parts.size() == maxElementsPerCompact) {
      // perform an intermediary compose
      BlobInfo first = sorted.get(0);
      BlobInfo last = sorted.get(sorted.size() - 1);

      long firstIdx = PART_INDEX.readFrom(first).getBegin();
      long lastIdx = PART_INDEX.readFrom(last).getEnd();
      long offset = OBJECT_OFFSET.readFrom(first);
      BlobInfo newPart = definePart(ultimateObject, PartRange.of(firstIdx, lastIdx), offset);
      builder.setTarget(newPart);
      builder.setTargetOpts(partOpts);
    } else {
      // with this compose create the ultimate object
      builder.setTarget(ultimateObject);
      builder.setTargetOpts(opts);
    }

    ComposeRequest composeRequest = builder.build();
    BlobInfo compose = storage.compose(composeRequest);
    successfulParts.add(compose.getBlobId());
    return compose;
  }

  private ApiFuture<BlobInfo> cleanupParts(BlobInfo finalInfo) {
    if (!partCleanupStrategy.isDeletePartsOnSuccess()) {
      return ApiFutures.immediateFuture(finalInfo);
    }
    List<ApiFuture<Boolean>> deletes =
        successfulParts.stream()
            // make sure we don't delete the object we're wanting to create
            .filter(id -> !id.equals(finalInfo.getBlobId()))
            .map(this::deleteAsync)
            .collect(Collectors.toList());

    ApiFuture<List<Boolean>> deletes2 = ApiFutureUtils.quietAllAsList(deletes);

    return ApiFutures.catchingAsync(
        ApiFutures.transform(deletes2, ignore -> finalInfo, exec),
        Throwable.class,
        cause -> ApiFutures.immediateFailedFuture(StorageException.coalesce(cause)),
        exec);
  }

  private BlobInfo definePart(BlobInfo ultimateObject, PartRange partRange, long offset) {
    BlobId id = ultimateObject.getBlobId();
    BlobInfo.Builder b = ultimateObject.toBuilder().clearCrc32c().clearMd5();
    String partName = partNamingStrategy.fmtName(id.getName(), partRange);
    b.setBlobId(BlobId.of(id.getBucket(), partName));
    ImmutableMap.Builder<String, String> builder = ImmutableMap.builder();
    Map<@NonNull String, @Nullable String> metadata = ultimateObject.getMetadata();
    if (metadata != null) {
      builder.putAll(metadata);
    }
    FINAL_OBJECT_NAME.appendTo(id.getName(), builder);
    PART_INDEX.appendTo(partRange, builder);
    OBJECT_OFFSET.appendTo(offset, builder);
    b.setMetadata(builder.build());
    // the value of a kms key name will contain the exact version when read from gcs
    // however, gcs will not accept that version resource identifier when creating a new object
    // strip it out, so it can be included as a query string parameter instead
    b.setKmsKeyName(null);
    b = partMetadataFieldDecorator.apply(b);
    return b.build();
  }

  private <R> ApiFuture<R> asyncCleanupAfterFailure(Throwable originalFailure) {
    ApiFuture<List<BlobId>> pendingAndSuccessfulBlobIds =
        getPendingAndSuccessfulBlobIds(exec, pendingParts, successfulParts);
    return ApiFutures.transformAsync(
        pendingAndSuccessfulBlobIds,
        blobIds -> {
          ImmutableList<ApiFuture<Boolean>> pendingDeletes =
              blobIds.stream().map(this::deleteAsync).collect(ImmutableList.toImmutableList());

          ApiFuture<List<Boolean>> futureDeleteResults =
              ApiFutures.successfulAsList(pendingDeletes);

          return ApiFutures.transformAsync(
              futureDeleteResults,
              deleteResults -> {
                List<BlobId> failedDeletes = new ArrayList<>();
                for (int i = 0; i < blobIds.size(); i++) {
                  BlobId id = blobIds.get(i);
                  Boolean deleteResult = deleteResults.get(i);
                  // deleteResult not equal to true means the request completed but was
                  //   unsuccessful
                  // deleteResult being null means the future failed
                  if (!Boolean.TRUE.equals(deleteResult)) {
                    failedDeletes.add(id);
                  }
                }

                if (!failedDeletes.isEmpty()) {
                  String failedGsUris =
                      failedDeletes.stream()
                          .map(BlobId::toGsUtilUriWithGeneration)
                          .collect(Collectors.joining(",\n", "[\n", "\n]"));

                  String message =
                      String.format(
                          Locale.US,
                          "Incomplete parallel composite upload cleanup after previous error."
                              + " Unknown object ids: %s",
                          failedGsUris);
                  StorageException storageException = new StorageException(0, message, null);
                  originalFailure.addSuppressed(storageException);
                }
                return ApiFutures.immediateFailedFuture(originalFailure);
              },
              exec);
        },
        exec);
  }

  @NonNull
  private ApiFuture<Boolean> deleteAsync(BlobId id) {
    return ApiFutures.transform(
        ApiFutures.immediateFuture(id),
        v -> {
          try {
            storage.internalObjectDelete(v, srcOpts);
            return true;
          } catch (NotFoundException e) {
            // not found means the part doesn't exist, which is what we want
            return true;
          } catch (StorageException e) {
            if (e.getCode() == 404) {
              return true;
            } else {
              throw e;
            }
          }
        },
        exec);
  }

  @VisibleForTesting
  @NonNull
  static Opts<ObjectTargetOpt> getPartOpts(Opts<ObjectTargetOpt> opts) {
    return opts.filter(TO_EXCLUDE_FROM_PARTS)
        .prepend(DOES_NOT_EXIST)
        // disable gzip transfer encoding for HTTP, it causes a significant bottleneck uploading
        // the parts
        .prepend(Opts.from(UnifiedOpts.disableGzipContent()));
  }

  @VisibleForTesting
  static final class BufferHandleReleaser<T> implements ApiFutureCallback<T> {
    private final BufferHandlePool bufferManager;
    private final ApiFutureCallback<T> delegate;
    private final PooledBuffer toRelease;

    @VisibleForTesting
    BufferHandleReleaser(
        BufferHandlePool bufferPool, PooledBuffer toRelease, ApiFutureCallback<T> delegate) {
      this.bufferManager = bufferPool;
      this.delegate = delegate;
      this.toRelease = toRelease;
    }

    @Override
    public void onFailure(Throwable t) {
      try {
        delegate.onFailure(t);
      } finally {
        bufferManager.returnBuffer(toRelease);
      }
    }

    @Override
    public void onSuccess(T result) {
      try {
        delegate.onSuccess(result);
      } finally {
        bufferManager.returnBuffer(toRelease);
      }
    }
  }

  private class FailureForwarder implements ApiFutureCallback<BlobInfo> {

    @Override
    public void onFailure(Throwable t) {
      finalObject.setException(t);
    }

    @Override
    public void onSuccess(BlobInfo result) {
      finalObject.set(result);
    }
  }

  @VisibleForTesting
  @NonNull
  static ParallelCompositeUploadException buildParallelCompositeUploadException(
      Throwable cause,
      Executor exec,
      List<ApiFuture<BlobInfo>> pendingParts,
      List<BlobId> successfulParts) {
    ApiFuture<List<BlobId>> fCreatedObjects =
        getPendingAndSuccessfulBlobIds(exec, pendingParts, successfulParts);

    return ParallelCompositeUploadException.of(cause, fCreatedObjects);
  }

  @NonNull
  private static ApiFuture<List<BlobId>> getPendingAndSuccessfulBlobIds(
      Executor exec, List<ApiFuture<BlobInfo>> pendingParts, List<BlobId> successfulParts) {
    ApiFuture<List<BlobInfo>> successfulList = ApiFutures.successfulAsList(pendingParts);
    // suppress any failure that might happen when waiting for any pending futures to resolve
    ApiFuture<List<BlobInfo>> catching =
        ApiFutures.catching(successfulList, Throwable.class, t2 -> ImmutableList.of(), exec);

    ApiFuture<List<BlobId>> fCreatedObjects =
        ApiFutures.transform(
            catching,
            l ->
                Stream.of(
                        l.stream()
                            // any failed future from successfulList will contain a null value
                            // filter out as that means an object wasn't created
                            .filter(Objects::nonNull)
                            .map(BlobInfo::getBlobId),
                        successfulParts.stream())
                    .flatMap(Function.identity()) // .flatten()
                    // a successful value could be in successfulParts and pendingParts if
                    // pendingParts haven't compacted yet
                    .distinct()
                    .collect(ImmutableList.toImmutableList()),
            exec);
    return fCreatedObjects;
  }
}
