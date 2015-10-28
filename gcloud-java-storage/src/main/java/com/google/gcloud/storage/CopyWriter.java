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
 * Google Storage blob copy writer. This class holds the result of a copy request.
 * If source and destination blobs do not share the same location or storage class more than one
 * RPC request is needed to copy the blob. When this is the case {@link #copyChunk()} can be used
 * to copy to destination other chunks of the source blob.
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
   * Returns the updated information for the just written blob when {@link #isDone} is {@code true}.
   * Returns {@code null} otherwise.
   */
  public BlobInfo result() {
    return rewriteResponse.result != null ? BlobInfo.fromPb(rewriteResponse.result) : null;
  }

  /**
   * Size of the blob being copied.
   */
  public Long blobSize() {
    return rewriteResponse.blobSize;
  }

  /**
   * Returns {@code true} of blob rewrite finished, {@code false} otherwise.
   */
  public Boolean isDone() {
    return rewriteResponse.isDone;
  }

  /**
   * Returns the number of bytes copied. 
   */
  public Long totalBytesCopied() {
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
        .megabytesRewrittenPerCall(rewriteResponse.rewriteRequest.megabytesRewrittenPerCall)
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
    private final Long blobSize;
    private final Boolean isDone;
    private final String rewriteToken;
    private final Long totalBytesCopied;
    private final Long megabytesRewrittenPerCall;

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
      this.megabytesRewrittenPerCall = builder.megabytesRewrittenPerCall;
    }

    static class Builder {

      private final StorageOptions serviceOptions;
      private final BlobId source;
      private final Map<StorageRpc.Option, ?> sourceOptions;
      private final BlobInfo target;
      private final Map<StorageRpc.Option, ?> targetOptions;
      private BlobInfo result;
      private Long blobSize;
      private Boolean isDone;
      private String rewriteToken;
      private Long totalBytesCopied;
      private Long megabytesRewrittenPerCall;

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

      Builder blobSize(Long blobSize) {
        this.blobSize = blobSize;
        return this;
      }

      Builder isDone(Boolean isDone) {
        this.isDone = isDone;
        return this;
      }

      Builder rewriteToken(String rewriteToken) {
        this.rewriteToken = rewriteToken;
        return this;
      }

      Builder totalBytesRewritten(Long totalBytesRewritten) {
        this.totalBytesCopied = totalBytesRewritten;
        return this;
      }

      Builder megabytesRewrittenPerCall(Long megabytesRewrittenPerCall) {
        this.megabytesRewrittenPerCall = megabytesRewrittenPerCall;
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
          source.toPb(), sourceOptions, target.toPb(), targetOptions, megabytesRewrittenPerCall);
      RewriteResponse rewriteResponse = new RewriteResponse(rewriteRequest,
          result != null ? result.toPb() : null, blobSize, isDone, rewriteToken,
          totalBytesCopied);
      return new CopyWriter(serviceOptions, rewriteResponse);
    }

    @Override
    public int hashCode() {
      return Objects.hash(serviceOptions, source, sourceOptions, target, targetOptions, result,
          blobSize, isDone, megabytesRewrittenPerCall, rewriteToken, totalBytesCopied);
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
          && Objects.equals(this.blobSize, other.blobSize)
          && Objects.equals(this.isDone, other.isDone)
          && Objects.equals(this.megabytesRewrittenPerCall, other.megabytesRewrittenPerCall)
          && Objects.equals(this.totalBytesCopied, other.totalBytesCopied);
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
