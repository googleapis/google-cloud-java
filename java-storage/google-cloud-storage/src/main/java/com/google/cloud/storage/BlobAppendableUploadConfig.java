/*
 * Copyright 2025 Google LLC
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

import static java.util.Objects.requireNonNull;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.core.SettableApiFuture;
import com.google.cloud.storage.BidiUploadState.AppendableUploadState;
import com.google.cloud.storage.BidiUploadState.TakeoverAppendableUploadState;
import com.google.cloud.storage.BlobAppendableUpload.AppendableUploadWriteableByteChannel;
import com.google.cloud.storage.BlobAppendableUploadImpl.AppendableObjectBufferedWritableByteChannel;
import com.google.cloud.storage.FlushPolicy.MinFlushSizeFlushPolicy;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.UnifiedOpts.ObjectTargetOpt;
import com.google.cloud.storage.UnifiedOpts.Opts;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.storage.v2.BidiWriteObjectResponse;
import com.google.storage.v2.ServiceConstants.Values;
import java.util.Objects;
import java.util.function.BiFunction;
import javax.annotation.concurrent.Immutable;

/**
 * Configuration parameters for an appendable uploads channel.
 *
 * <p>Instances of this class are immutable and thread safe.
 *
 * @see Storage#blobAppendableUpload(BlobInfo, BlobAppendableUploadConfig, BlobWriteOption...)
 * @since 2.51.0 This new api is in preview and is subject to breaking changes.
 */
@Immutable
@BetaApi
@TransportCompatibility({Transport.GRPC})
public final class BlobAppendableUploadConfig {

  private static final BlobAppendableUploadConfig INSTANCE =
      new BlobAppendableUploadConfig(
          FlushPolicy.minFlushSize(), CloseAction.CLOSE_WITHOUT_FINALIZING, 3);

  private final FlushPolicy flushPolicy;
  private final CloseAction closeAction;
  private final int maxRedirectsAllowed;

  private BlobAppendableUploadConfig(
      FlushPolicy flushPolicy, CloseAction closeAction, int maxRedirectsAllowed) {
    this.flushPolicy = flushPolicy;
    this.closeAction = closeAction;
    this.maxRedirectsAllowed = maxRedirectsAllowed;
  }

  /**
   * The {@link FlushPolicy} which will be used to determine when and how many bytes to flush to
   * GCS.
   *
   * <p><i>Default:</i> {@link FlushPolicy#minFlushSize()}
   *
   * @see #withFlushPolicy(FlushPolicy)
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public FlushPolicy getFlushPolicy() {
    return flushPolicy;
  }

  /**
   * Return an instance with the {@code FlushPolicy} set to be the specified value.
   *
   * <p><i>Default:</i> {@link FlushPolicy#minFlushSize()}
   *
   * @see #getFlushPolicy()
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public BlobAppendableUploadConfig withFlushPolicy(FlushPolicy flushPolicy) {
    requireNonNull(flushPolicy, "flushPolicy must be non null");
    if (this.flushPolicy.equals(flushPolicy)) {
      return this;
    }
    return new BlobAppendableUploadConfig(flushPolicy, closeAction, maxRedirectsAllowed);
  }

  /**
   * The {@link CloseAction} which will dictate the behavior of {@link
   * AppendableUploadWriteableByteChannel#close()}.
   *
   * <p><i>Default:</i> {@link CloseAction#CLOSE_WITHOUT_FINALIZING}
   *
   * @see #withCloseAction(CloseAction)
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public CloseAction getCloseAction() {
    return closeAction;
  }

  /**
   * Return an instance with the {@code CloseAction} set to be the specified value.
   *
   * <p><i>Default:</i> {@link CloseAction#CLOSE_WITHOUT_FINALIZING}
   *
   * @see #getCloseAction()
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public BlobAppendableUploadConfig withCloseAction(CloseAction closeAction) {
    requireNonNull(closeAction, "closeAction must be non null");
    if (this.closeAction == closeAction) {
      return this;
    }
    return new BlobAppendableUploadConfig(flushPolicy, closeAction, maxRedirectsAllowed);
  }

  /**
   * The {@code maxRedirectsAllowed} set to be the specified value.
   *
   * <p><i>Default:</i> 3
   *
   * @see #withMaxRedirectsAllowed(int)
   * @since 2.56.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  int getMaxRedirectsAllowed() {
    return maxRedirectsAllowed;
  }

  /**
   * Return an instance with the {@code maxRedirectsAllowed} set to be the specified value.
   *
   * <p><i>Default:</i> 3
   *
   * @see #getMaxRedirectsAllowed()
   * @since 2.56.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  BlobAppendableUploadConfig withMaxRedirectsAllowed(int maxRedirectsAllowed) {
    Preconditions.checkArgument(
        maxRedirectsAllowed >= 0, "maxRedirectsAllowed >= 0 (%s >= 0)", maxRedirectsAllowed);
    if (this.maxRedirectsAllowed == maxRedirectsAllowed) {
      return this;
    }
    return new BlobAppendableUploadConfig(flushPolicy, closeAction, maxRedirectsAllowed);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BlobAppendableUploadConfig)) {
      return false;
    }
    BlobAppendableUploadConfig that = (BlobAppendableUploadConfig) o;
    return maxRedirectsAllowed == that.maxRedirectsAllowed
        && Objects.equals(flushPolicy, that.flushPolicy)
        && closeAction == that.closeAction;
  }

  @Override
  public int hashCode() {
    return Objects.hash(flushPolicy, closeAction, maxRedirectsAllowed);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("flushPolicy", flushPolicy)
        .add("closeAction", closeAction)
        .add("maxRedirectsAllowed", maxRedirectsAllowed)
        .toString();
  }

  /**
   * Default instance factory method.
   *
   * <p>The {@link FlushPolicy} of this instance is equivalent to the following:
   *
   * <pre>{@code
   * BlobAppendableUploadConfig.of()
   *   .withFlushPolicy(FlushPolicy.minFlushSize(256 * 1024))
   *   .withCloseAction(CloseAction.CLOSE_WITHOUT_FINALIZING)
   * }</pre>
   *
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   * @see FlushPolicy#minFlushSize(int)
   */
  @BetaApi
  public static BlobAppendableUploadConfig of() {
    return INSTANCE;
  }

  /**
   * Enum providing the possible actions which can be taken during the {@link
   * AppendableUploadWriteableByteChannel#close()} call.
   *
   * @see AppendableUploadWriteableByteChannel#close()
   * @see BlobAppendableUploadConfig#withCloseAction(CloseAction)
   * @see BlobAppendableUploadConfig#getCloseAction()
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public enum CloseAction {
    /**
     * Designate that when {@link AppendableUploadWriteableByteChannel#close()} is called, the
     * appendable upload should be finalized.
     *
     * @since 2.51.0 This new api is in preview and is subject to breaking changes.
     * @see AppendableUploadWriteableByteChannel#finalizeAndClose()
     */
    @BetaApi
    FINALIZE_WHEN_CLOSING,
    /**
     * Designate that when {@link AppendableUploadWriteableByteChannel#close()} is called, the
     * appendable upload should NOT be finalized, allowing for takeover by another session or
     * client.
     *
     * @since 2.51.0 This new api is in preview and is subject to breaking changes.
     * @see AppendableUploadWriteableByteChannel#closeWithoutFinalizing()
     */
    @BetaApi
    CLOSE_WITHOUT_FINALIZING
  }

  BlobAppendableUpload create(GrpcStorageImpl storage, BlobInfo info, Opts<ObjectTargetOpt> opts) {
    long maxPendingBytes = this.getFlushPolicy().getMaxPendingBytes();
    AppendableUploadState state = storage.getAppendableState(info, opts, maxPendingBytes);
    WritableByteChannelSession<AppendableObjectBufferedWritableByteChannel, BidiWriteObjectResponse>
        build =
            new AppendableSession(
                ApiFutures.immediateFuture(state),
                (start, resultFuture) -> {
                  BidiUploadStreamingStream stream =
                      new BidiUploadStreamingStream(
                          start,
                          storage.storageDataClient.executor,
                          storage.storageClient.bidiWriteObjectCallable(),
                          maxRedirectsAllowed,
                          storage.storageDataClient.retryContextProvider.create());
                  ChunkSegmenter chunkSegmenter =
                      new ChunkSegmenter(
                          Hasher.enabled(),
                          ByteStringStrategy.copy(),
                          Math.min(
                              Values.MAX_WRITE_CHUNK_BYTES_VALUE, Math.toIntExact(maxPendingBytes)),
                          /* blockSize= */ 1);
                  BidiAppendableUnbufferedWritableByteChannel c;
                  if (state instanceof TakeoverAppendableUploadState) {
                    // start the takeover reconciliation
                    stream.awaitTakeoverStateReconciliation();
                    c =
                        new BidiAppendableUnbufferedWritableByteChannel(
                            stream,
                            chunkSegmenter,
                            flushInterval(flushPolicy),
                            state.getConfirmedBytes());
                  } else {
                    c =
                        new BidiAppendableUnbufferedWritableByteChannel(
                            stream, chunkSegmenter, flushInterval(flushPolicy), 0);
                  }
                  return new AppendableObjectBufferedWritableByteChannel(
                      flushPolicy.createBufferedChannel(c, /* blocking= */ false),
                      c,
                      this.closeAction == CloseAction.FINALIZE_WHEN_CLOSING);
                },
                state.getResultFuture());

    return new BlobAppendableUploadImpl(
        new DefaultBlobWriteSessionConfig.DecoratedWritableByteChannelSession<>(
            build, BidiBlobWriteSessionConfig.Factory.WRITE_OBJECT_RESPONSE_BLOB_INFO_DECODER));
  }

  private static long flushInterval(FlushPolicy fp) {
    if (fp instanceof MinFlushSizeFlushPolicy) {
      MinFlushSizeFlushPolicy min = (MinFlushSizeFlushPolicy) fp;
      return min.getMinFlushSize();
    } else {
      return fp.getMaxPendingBytes();
    }
  }

  private static final class AppendableSession
      extends ChannelSession<
          AppendableUploadState,
          BidiWriteObjectResponse,
          AppendableObjectBufferedWritableByteChannel>
      implements WritableByteChannelSession<
          AppendableObjectBufferedWritableByteChannel, BidiWriteObjectResponse> {
    private AppendableSession(
        ApiFuture<AppendableUploadState> startFuture,
        BiFunction<
                AppendableUploadState,
                SettableApiFuture<BidiWriteObjectResponse>,
                AppendableObjectBufferedWritableByteChannel>
            f,
        SettableApiFuture<BidiWriteObjectResponse> resultFuture) {
      super(startFuture, f, resultFuture);
    }
  }
}
