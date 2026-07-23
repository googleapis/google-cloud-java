/*
 * Copyright 2026 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.rpc;

import com.google.api.core.BetaApi;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Parameter class for a resumable upload call.
 * Contains the request metadata, stream payload, and progress listener.
 *
 * @param <RequestT> the type of request message
 */
@BetaApi
public final class ResumableUploadRequest<RequestT> {
  /** Default chunk size. */
  private static final int DEFAULT_CHUNK_SIZE = 10 * 1024 * 1024;

  /** Request metadata. */
  private final RequestT request;
  /** Stream provider. */
  private final InputStreamProvider streamProvider;
  /** Total bytes. */
  private final long totalBytes;
  /** Chunk size. */
  private final int chunkSize;
  /** Progress listener. */
  private final ResumableUploadProgressListener progressListener;

  private ResumableUploadRequest(final Builder<RequestT> builder) {
    this.request = Preconditions.checkNotNull(builder.request);
    this.streamProvider = Preconditions.checkNotNull(builder.streamProvider);
    this.totalBytes = builder.totalBytes;
    this.chunkSize = builder.chunkSize;
    this.progressListener = builder.progressListener;
  }

  /**
   * Returns the metadata request message.
   *
   * @return the request metadata message
   */
  @Nonnull
  public RequestT getRequest() {
    return request;
  }

  /**
   * Returns the stream provider.
   *
   * @return the stream provider
   */
  @Nonnull
  public InputStreamProvider getStreamProvider() {
    return streamProvider;
  }

  /**
   * Returns the total size of the stream, or -1 if unknown.
   *
   * @return the total bytes
   */
  public long getTotalBytes() {
    return totalBytes;
  }

  /**
   * Returns the size of each upload chunk.
   *
   * @return the chunk size in bytes
   */
  public int getChunkSize() {
    return chunkSize;
  }

  /**
   * Returns the progress listener, or null if not set.
   *
   * @return the progress listener
   */
  @Nullable
  public ResumableUploadProgressListener getProgressListener() {
    return progressListener;
  }

  /**
   * Creates a new builder for {@link ResumableUploadRequest}.
   *
   * @param <RequestT> type of the request
   * @return a new builder
   */
  public static <RequestT> Builder<RequestT> newBuilder() {
    return new Builder<>();
  }

  /**
   * Builder for {@link ResumableUploadRequest}.
   *
   * @param <RequestT> type of the request
   */
  public static final class Builder<RequestT> {
    /** Request metadata. */
    private RequestT request;
    /** Stream provider. */
    private InputStreamProvider streamProvider;
    /** Total bytes. */
    private long totalBytes = -1;
    /** Chunk size. */
    private int chunkSize = DEFAULT_CHUNK_SIZE;
    /** Progress listener. */
    private ResumableUploadProgressListener progressListener;

    /**
     * Sets the request metadata.
     *
     * @param requestVal the request metadata
     * @return the builder
     */
    public Builder<RequestT> setRequest(final RequestT requestVal) {
      this.request = requestVal;
      return this;
    }

    /**
     * Sets the stream provider.
     *
     * @param streamProviderVal the stream provider
     * @return the builder
     */
    public Builder<RequestT> setStreamProvider(
        final InputStreamProvider streamProviderVal) {
      this.streamProvider = streamProviderVal;
      return this;
    }

    /**
     * Sets the total size of the stream.
     *
     * @param totalBytesVal the total size, or -1 if unknown
     * @return the builder
     */
    public Builder<RequestT> setTotalBytes(final long totalBytesVal) {
      this.totalBytes = totalBytesVal;
      return this;
    }

    /**
     * Sets the size of each upload chunk.
     *
     * @param chunkSizeVal the chunk size in bytes
     * @return the builder
     */
    public Builder<RequestT> setChunkSize(final int chunkSizeVal) {
      Preconditions.checkArgument(
          chunkSizeVal > 0, "chunkSize must be greater than 0");
      this.chunkSize = chunkSizeVal;
      return this;
    }

    /**
     * Sets the progress listener.
     *
     * @param progressListenerVal the progress listener
     * @return the builder
     */
    public Builder<RequestT> setProgressListener(
        final ResumableUploadProgressListener progressListenerVal) {
      this.progressListener = progressListenerVal;
      return this;
    }

    /**
     * Builds a {@link ResumableUploadRequest}.
     *
     * @return the request
     */
    public ResumableUploadRequest<RequestT> build() {
      return new ResumableUploadRequest<>(this);
    }
  }
}
