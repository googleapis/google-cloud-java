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

import com.google.cloud.RestorableState;
import com.google.cloud.storage.Conversions.Decoder;
import com.google.cloud.storage.Retrying.DefaultRetrier;
import com.google.cloud.storage.Retrying.HttpRetrier;
import com.google.cloud.storage.Retrying.Retrier;
import com.google.cloud.storage.Retrying.RetryingDependencies;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.cloud.storage.spi.v1.StorageRpc.RewriteRequest;
import com.google.cloud.storage.spi.v1.StorageRpc.RewriteResponse;
import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.function.UnaryOperator;

public class HttpCopyWriter extends CopyWriter {

  private final HttpStorageOptions serviceOptions;
  private final StorageRpc storageRpc;
  private RewriteResponse rewriteResponse;
  private final Retrier retrier;

  HttpCopyWriter(
      HttpStorageOptions serviceOptions, RewriteResponse rewriteResponse, Retrier retrier) {
    this.serviceOptions = serviceOptions;
    this.rewriteResponse = rewriteResponse;
    this.storageRpc = serviceOptions.getStorageRpcV1();
    this.retrier = retrier;
  }

  @Override
  public Blob getResult() {
    while (!isDone()) {
      copyChunk();
    }
    BlobInfo info = Conversions.json().blobInfo().decode(rewriteResponse.result);
    return info.asBlob(serviceOptions.getService());
  }

  @Override
  public long getBlobSize() {
    return rewriteResponse.blobSize;
  }

  @Override
  public boolean isDone() {
    return rewriteResponse.isDone;
  }

  @Override
  public long getTotalBytesCopied() {
    return rewriteResponse.totalBytesRewritten;
  }

  @Override
  public void copyChunk() {
    if (!isDone()) {
      RewriteRequest rewriteRequest = rewriteResponse.rewriteRequest;
      this.rewriteResponse =
          retrier.run(
              serviceOptions.getRetryAlgorithmManager().getForObjectsRewrite(rewriteRequest),
              () -> storageRpc.continueRewrite(rewriteResponse),
              Decoder.identity());
    }
  }

  @Override
  public RestorableState<CopyWriter> capture() {
    return StateImpl.newBuilder(
            serviceOptions,
            Conversions.json().blobId().decode(rewriteResponse.rewriteRequest.source),
            rewriteResponse.rewriteRequest.sourceOptions,
            rewriteResponse.rewriteRequest.overrideInfo,
            Conversions.json().blobInfo().decode(rewriteResponse.rewriteRequest.target),
            rewriteResponse.rewriteRequest.targetOptions)
        .setResult(
            rewriteResponse.result != null
                ? Conversions.json().blobInfo().decode(rewriteResponse.result)
                : null)
        .setBlobSize(getBlobSize())
        .setIsDone(isDone())
        .setMegabytesCopiedPerChunk(rewriteResponse.rewriteRequest.megabytesRewrittenPerCall)
        .setRewriteToken(rewriteResponse.rewriteToken)
        .setTotalBytesRewritten(getTotalBytesCopied())
        .build();
  }

  static class StateImpl implements RestorableState<CopyWriter>, Serializable {

    private static final long serialVersionUID = 1843004265650868946L;

    private final HttpStorageOptions serviceOptions;
    private final BlobId source;
    private final Map<StorageRpc.Option, ?> sourceOptions;
    private final boolean overrideInfo;
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
      this.overrideInfo = builder.overrideInfo;
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

      private final HttpStorageOptions serviceOptions;
      private final BlobId source;
      private final Map<StorageRpc.Option, ?> sourceOptions;
      private final boolean overrideInfo;
      private final BlobInfo target;
      private final Map<StorageRpc.Option, ?> targetOptions;
      private BlobInfo result;
      private long blobSize;
      private boolean isDone;
      private String rewriteToken;
      private long totalBytesCopied;
      private Long megabytesCopiedPerChunk;

      private Builder(
          HttpStorageOptions options,
          BlobId source,
          Map<StorageRpc.Option, ?> sourceOptions,
          boolean overrideInfo,
          BlobInfo target,
          Map<StorageRpc.Option, ?> targetOptions) {
        this.serviceOptions = options;
        this.source = source;
        this.sourceOptions = sourceOptions;
        this.overrideInfo = overrideInfo;
        this.target = target;
        this.targetOptions = targetOptions;
      }

      Builder setResult(BlobInfo result) {
        this.result = result;
        return this;
      }

      Builder setBlobSize(long blobSize) {
        this.blobSize = blobSize;
        return this;
      }

      Builder setIsDone(boolean isDone) {
        this.isDone = isDone;
        return this;
      }

      Builder setRewriteToken(String rewriteToken) {
        this.rewriteToken = rewriteToken;
        return this;
      }

      Builder setTotalBytesRewritten(long totalBytesRewritten) {
        this.totalBytesCopied = totalBytesRewritten;
        return this;
      }

      Builder setMegabytesCopiedPerChunk(Long megabytesCopiedPerChunk) {
        this.megabytesCopiedPerChunk = megabytesCopiedPerChunk;
        return this;
      }

      RestorableState<CopyWriter> build() {
        return new StateImpl(this);
      }
    }

    static Builder newBuilder(
        HttpStorageOptions options,
        BlobId source,
        Map<StorageRpc.Option, ?> sourceOptions,
        boolean overrideInfo,
        BlobInfo target,
        Map<StorageRpc.Option, ?> targetOptions) {
      return new Builder(options, source, sourceOptions, overrideInfo, target, targetOptions);
    }

    @Override
    public CopyWriter restore() {
      RewriteRequest rewriteRequest =
          new RewriteRequest(
              Conversions.json().blobId().encode(source),
              sourceOptions,
              overrideInfo,
              Conversions.json().blobInfo().encode(target),
              targetOptions,
              megabytesCopiedPerChunk);
      RewriteResponse rewriteResponse =
          new RewriteResponse(
              rewriteRequest,
              result != null ? Conversions.json().blobInfo().encode(result) : null,
              blobSize,
              isDone,
              rewriteToken,
              totalBytesCopied);
      HttpRetrier httpRetrier =
          new HttpRetrier(
              new DefaultRetrier(
                  UnaryOperator.identity(),
                  RetryingDependencies.simple(
                      serviceOptions.getClock(), serviceOptions.getRetrySettings())));
      return new HttpCopyWriter(serviceOptions, rewriteResponse, httpRetrier);
    }

    @Override
    public int hashCode() {
      return Objects.hash(
          serviceOptions,
          source,
          sourceOptions,
          overrideInfo,
          target,
          targetOptions,
          result,
          blobSize,
          isDone,
          megabytesCopiedPerChunk,
          rewriteToken,
          totalBytesCopied);
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
          && Objects.equals(this.overrideInfo, other.overrideInfo)
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
          .add("overrideInfo", overrideInfo)
          .add("target", target)
          .add("result", result)
          .add("blobSize", blobSize)
          .add("isDone", isDone)
          .add("rewriteToken", rewriteToken)
          .add("totalBytesCopied", totalBytesCopied)
          .add("megabytesCopiedPerChunk", megabytesCopiedPerChunk)
          .toString();
    }
  }
}
