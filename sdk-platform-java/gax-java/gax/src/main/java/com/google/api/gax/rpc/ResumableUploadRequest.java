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
 * Parameter class for a resumable upload call. Contains the request metadata, the stream payload,
 * and the progress listener.
 *
 * @param <RequestT> the type of request message that contains standard metadata
 */
@BetaApi
public final class ResumableUploadRequest<RequestT> {
  private final RequestT request;
  private final InputStreamProvider streamProvider;
  private final long totalBytes;
  private final ResumableUploadProgressListener progressListener;

  private ResumableUploadRequest(Builder<RequestT> builder) {
    this.request = Preconditions.checkNotNull(builder.request);
    this.streamProvider = Preconditions.checkNotNull(builder.streamProvider);
    this.totalBytes = builder.totalBytes;
    this.progressListener = builder.progressListener;
  }

  /** Returns the metadata request message. */
  @Nonnull
  public RequestT getRequest() {
    return request;
  }

  /** Returns the stream provider. */
  @Nonnull
  public InputStreamProvider getStreamProvider() {
    return streamProvider;
  }

  /** Returns the total size of the stream, or -1 if unknown. */
  public long getTotalBytes() {
    return totalBytes;
  }

  /** Returns the progress listener, or null if not set. */
  @Nullable
  public ResumableUploadProgressListener getProgressListener() {
    return progressListener;
  }

  public static <RequestT> Builder<RequestT> newBuilder() {
    return new Builder<>();
  }

  public static class Builder<RequestT> {
    private RequestT request;
    private InputStreamProvider streamProvider;
    private long totalBytes = -1;
    private ResumableUploadProgressListener progressListener;

    public Builder<RequestT> setRequest(RequestT request) {
      this.request = request;
      return this;
    }

    public Builder<RequestT> setStreamProvider(InputStreamProvider streamProvider) {
      this.streamProvider = streamProvider;
      return this;
    }

    public Builder<RequestT> setTotalBytes(long totalBytes) {
      this.totalBytes = totalBytes;
      return this;
    }

    public Builder<RequestT> setProgressListener(ResumableUploadProgressListener progressListener) {
      this.progressListener = progressListener;
      return this;
    }

    public ResumableUploadRequest<RequestT> build() {
      return new ResumableUploadRequest<>(this);
    }
  }
}
