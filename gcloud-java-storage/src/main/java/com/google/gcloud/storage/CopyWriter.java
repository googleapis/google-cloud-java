/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.storage;

import static com.google.gcloud.RetryHelper.runWithRetries;

import com.google.common.base.MoreObjects;
import com.google.gcloud.Restorable;
import com.google.gcloud.RestorableState;
import com.google.gcloud.RetryHelper;
import com.google.gcloud.spi.StorageRpc;
import com.google.gcloud.spi.StorageRpc.RewriteRequest;
import com.google.gcloud.spi.StorageRpc.RewriteResponse;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;

/**
 * Google Storage blob copy writer. This class holds the result of a copy request. If source and
 * destination blobs share the same location and storage class the copy is completed in one RPC call
 * otherwise one or more {@link #copyChunk} calls are necessary to complete the copy. In addition,
 * {@link CopyWriter#result()} can be used to automatically complete the copy and return information
 * on the newly created blob.
 *
 * @see <a href="https://cloud.google.com/storage/docs/json_api/v1/objects/rewrite">Rewrite</a>
 */
public class CopyWriter implements Restorable<CopyWriter> {

  private final StorageOptions serviceOptions;
  private final StorageRpc storageRpc;
  private RewriteResponse rewriteResponse;

  CopyWriter(StorageOptions serviceOptions, RewriteResponse rewriteResponse) {
    this.serviceOptions = serviceOptions;
    this.rewriteResponse = rewriteResponse;
    this.storageRpc = serviceOptions.rpc();
  }

  /**
   * Returns the updated information for the written blob. Calling this method when {@code isDone()}
   * is {@code false} will block until all pending chunks are copied.
   * <p>
   * This method has the same effect of doing:
   * <pre>    {@code while (!copyWriter.isDone()) {
   *        copyWriter.copyChunk();
   *    }}
   * </pre>
   *
   * @throws StorageException upon failure
   */
  public BlobInfo result() {
    while (!isDone()) {
      copyChunk();
    }
    return BlobInfo.fromPb(rewriteResponse.result);
  }

  /**
   * Returns the size of the blob being copied.
   */
  public long blobSize() {
    return rewriteResponse.blobSize;
  }

  /**
   * Returns {@code true} of blob rewrite finished, {@code false} otherwise.
   */
  public boolean isDone() {
    return rewriteResponse.isDone;
  }

  /**
   * Returns the number of bytes copied. 
   */
  public long totalBytesCopied() {
    return rewriteResponse.totalBytesRewritten;
  }

  /**
   * Copies the next chunk of the blob. An RPC is issued only if copy has not finished yet
   * ({@link #isDone} returns {@code false}).
   *
   * @throws StorageException upon failure
   */
  public void copyChunk() {
    if (!isDone()) {
      try {
        this.rewriteResponse = runWithRetries(new Callable<RewriteResponse>() {
          @Override
          public RewriteResponse call() {
            return storageRpc.continueRewrite(rewriteResponse);
          }
        }, serviceOptions.retryParams(), StorageImpl.EXCEPTION_HANDLER);
      } catch (RetryHelper.RetryHelperException e) {
        throw StorageException.translateAndThrow(e);
      }
    }
  }

  @Override
  public RestorableState<CopyWriter> capture() {
    return StateImpl.builder(
        serviceOptions,
        BlobId.fromPb(rewriteResponse.rewriteRequest.source),
        rewriteResponse.rewriteRequest.sourceOptions,
        BlobInfo.fromPb(rewriteResponse.rewriteRequest.target),
        rewriteResponse.rewriteRequest.targetOptions)
        .blobSize(blobSize())
        .isDone(isDone())
        .megabytesCopiedPerChunk(rewriteResponse.rewriteRequest.megabytesRewrittenPerCall)
        .rewriteToken(rewriteResponse.rewriteToken)
        .totalBytesRewritten(totalBytesCopied())
        .build();
  }

  static class StateImpl implements RestorableState<CopyWriter>, Serializable {

    private static final long serialVersionUID = 8279287678903181701L;

    private final StorageOptions serviceOptions;
    private final BlobId source;
    private final Map<StorageRpc.Option, ?> sourceOptions;
    private final BlobInfo target;
    private final Map<StorageRpc.Option, ?> targetOptions;
    private final BlobInfo result;
    private final long blobSize;
    private final boolean isDone;
    private final String rewriteToken;
    private final long totalBytesCopied;
    private final Long megabytesCopiedPerChunk;

    StateImpl(Builder builder) {
      this.serviceOptions = builder.serviceOptions;
      this.source = builder.source;
      this.sourceOptions = builder.sourceOptions;
      this.target = builder.target;
      this.targetOptions = builder.targetOptions;
      this.result = builder.result;
      this.blobSize = builder.blobSize;
      this.isDone = builder.isDone;
      this.rewriteToken = builder.rewriteToken;
      this.totalBytesCopied = builder.totalBytesCopied;
      this.megabytesCopiedPerChunk = builder.megabytesCopiedPerChunk;
    }

    static class Builder {

      private final StorageOptions serviceOptions;
      private final BlobId source;
      private final Map<StorageRpc.Option, ?> sourceOptions;
      private final BlobInfo target;
      private final Map<StorageRpc.Option, ?> targetOptions;
      private BlobInfo result;
      private long blobSize;
      private boolean isDone;
      private String rewriteToken;
      private long totalBytesCopied;
      private Long megabytesCopiedPerChunk;

      private Builder(StorageOptions options, BlobId source,
          Map<StorageRpc.Option, ?> sourceOptions,
          BlobInfo target, Map<StorageRpc.Option, ?> targetOptions) {
        this.serviceOptions = options;
        this.source = source;
        this.sourceOptions = sourceOptions;
        this.target = target;
        this.targetOptions = targetOptions;
      }

      Builder result(BlobInfo result) {
        this.result = result;
        return this;
      }

      Builder blobSize(long blobSize) {
        this.blobSize = blobSize;
        return this;
      }

      Builder isDone(boolean isDone) {
        this.isDone = isDone;
        return this;
      }

      Builder rewriteToken(String rewriteToken) {
        this.rewriteToken = rewriteToken;
        return this;
      }

      Builder totalBytesRewritten(long totalBytesRewritten) {
        this.totalBytesCopied = totalBytesRewritten;
        return this;
      }

      Builder megabytesCopiedPerChunk(Long megabytesCopiedPerChunk) {
        this.megabytesCopiedPerChunk = megabytesCopiedPerChunk;
        return this;
      }

      RestorableState<CopyWriter> build() {
        return new StateImpl(this);
      }
    }

    static Builder builder(StorageOptions options, BlobId source,
        Map<StorageRpc.Option, ?> sourceOptions, BlobInfo target,
        Map<StorageRpc.Option, ?> targetOptions) {
      return new Builder(options, source, sourceOptions, target, targetOptions);
    }

    @Override
    public CopyWriter restore() {
      RewriteRequest rewriteRequest = new RewriteRequest(
          source.toPb(), sourceOptions, target.toPb(), targetOptions, megabytesCopiedPerChunk);
      RewriteResponse rewriteResponse = new RewriteResponse(rewriteRequest,
          result != null ? result.toPb() : null, blobSize, isDone, rewriteToken,
          totalBytesCopied);
      return new CopyWriter(serviceOptions, rewriteResponse);
    }

    @Override
    public int hashCode() {
      return Objects.hash(serviceOptions, source, sourceOptions, target, targetOptions, result,
          blobSize, isDone, megabytesCopiedPerChunk, rewriteToken, totalBytesCopied);
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null) {
        return false;
      }
      if (!(obj instanceof StateImpl)) {
        return false;
      }
      final StateImpl other = (StateImpl) obj;
      return Objects.equals(this.serviceOptions, other.serviceOptions)
          && Objects.equals(this.source, other.source)
          && Objects.equals(this.sourceOptions, other.sourceOptions)
          && Objects.equals(this.target, other.target)
          && Objects.equals(this.targetOptions, other.targetOptions)
          && Objects.equals(this.result, other.result)
          && Objects.equals(this.rewriteToken, other.rewriteToken)
          && Objects.equals(this.megabytesCopiedPerChunk, other.megabytesCopiedPerChunk)
          && this.blobSize == other.blobSize
          && this.isDone == other.isDone
          && this.totalBytesCopied == other.totalBytesCopied;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("source", source)
          .add("target", target)
          .add("isDone", isDone)
          .add("totalBytesRewritten", totalBytesCopied)
          .add("blobSize", blobSize)
          .toString();
    }
  }
}
