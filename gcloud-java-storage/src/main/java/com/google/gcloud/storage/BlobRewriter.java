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

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.gcloud.RetryHelper.runWithRetries;

import com.google.api.services.storage.model.RewriteResponse;
import com.google.gcloud.RetryHelper;
import com.google.gcloud.spi.StorageRpc;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Google Storage blob rewriter.
 */
public final class BlobRewriter {

  private final StorageOptions serviceOptions;
  private final BlobId source;
  private final Map<StorageRpc.Option, ?> sourceOptions;
  private final Map<StorageRpc.Option, ?> targetOptions;
  private final Long maxBytesRewrittenPerCall;
  private BigInteger blobSize;
  private BlobInfo target;
  private Boolean isDone;
  private String rewriteToken;
  private BigInteger totalBytesRewritten;

  private final StorageRpc storageRpc;

  private BlobRewriter(Builder builder) {
    this.serviceOptions = builder.serviceOptions;
    this.source = builder.source;
    this.sourceOptions = builder.sourceOptions;
    this.target = builder.target;
    this.targetOptions = builder.targetOptions;
    this.blobSize = builder.blobSize;
    this.isDone = builder.isDone;
    this.rewriteToken = builder.rewriteToken;
    this.totalBytesRewritten = firstNonNull(builder.totalBytesRewritten, BigInteger.ZERO);
    this.maxBytesRewrittenPerCall = builder.maxBytesRewrittenPerCall;
    this.storageRpc = serviceOptions.storageRpc();
  }

  static class Builder {

    private final StorageOptions serviceOptions;
    private final BlobId source;
    private final Map<StorageRpc.Option, ?> sourceOptions;
    private final BlobInfo target;
    private final Map<StorageRpc.Option, ?> targetOptions;
    private BigInteger blobSize;
    private Boolean isDone;
    private String rewriteToken;
    private BigInteger totalBytesRewritten;
    private Long maxBytesRewrittenPerCall;

    Builder(StorageOptions serviceOptions, BlobId source, Map<StorageRpc.Option, ?> sourceOptions,
        BlobInfo target, Map<StorageRpc.Option, ?> targetOptions) {
      this.serviceOptions = serviceOptions;
      this.source = source;
      this.sourceOptions = sourceOptions;
      this.target = target;
      this.targetOptions = targetOptions;
    }

    Builder blobSize(BigInteger blobSize) {
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

    Builder totalBytesRewritten(BigInteger totalBytesRewritten) {
      this.totalBytesRewritten = totalBytesRewritten;
      return this;
    }

    Builder maxBytesRewrittenPerCall(Long maxBytesRewrittenPerCall) {
      this.maxBytesRewrittenPerCall = maxBytesRewrittenPerCall;
      return this;
    }

    BlobRewriter build() {
      return new BlobRewriter(this);
    }
  }

  static Builder builder(StorageOptions options, BlobId source,
      Map<StorageRpc.Option, ?> sourceOpt,
      BlobInfo target, Map<StorageRpc.Option, ?> targetOpt) {
    return new Builder(options, source, sourceOpt, target, targetOpt);
  }

  /**
   * Returns the id of the source blob.
   */
  public BlobId source() {
    return source;
  }

  /**
   * Returns the info for the target blob. When {@link #isDone} is {@code true} this method returns
   * the updated information for the just written blob.
   */
  public BlobInfo target() {
    return target;
  }

  /**
   * Size of the blob being copied. Returns {@code null} until the first copy request returns.
   */
  public BigInteger blobSize() {
    return blobSize;
  }

  /**
   * Returns {@code true} of blob rewrite finished, {@code false} otherwise.
   */
  public Boolean isDone() {
    return isDone;
  }

  /**
   * Returns the token to be used to rewrite the next chunk of the blob.
   */
  public String rewriteToken() {
    return rewriteToken;
  }

  /**
   * Returns the number of bytes written. 
   */
  public BigInteger totalBytesRewritten() {
    return totalBytesRewritten;
  }

  /**
   * Returns the maximum number of bytes to be copied with each {@link #copyChunk()} call. This
   * parameter is ignored if source and target blob share the same location and storage class as
   * rewrite is made with one single RPC.
   */
  public Long maxBytesRewrittenPerCall() {
    return maxBytesRewrittenPerCall;
  }

  /**
   * Rewrite the next chunk of the blob. An RPC is issued only if rewrite has not finished yet
   * ({@link #isDone} returns {@code false}).
   *
   * @throws StorageException upon failure
   */
  public void copyChunk() {
    if (!isDone) {
      try {
        RewriteResponse response = runWithRetries(new Callable<RewriteResponse>() {
          @Override
          public RewriteResponse call() {
            return storageRpc.rewrite(
                source.toPb(),
                sourceOptions,
                target.toPb(),
                targetOptions,
                rewriteToken,
                maxBytesRewrittenPerCall);
          }
        }, serviceOptions.retryParams(), StorageImpl.EXCEPTION_HANDLER);
        rewriteToken = response.getRewriteToken();
        isDone = response.getDone();
        blobSize = response.getObjectSize();
        totalBytesRewritten = response.getTotalBytesRewritten();
        target = response.getResource() != null ? BlobInfo.fromPb(response.getResource()) : target;
      } catch (RetryHelper.RetryHelperException e) {
        throw StorageException.translateAndThrow(e);
      }
    }
  }
}
