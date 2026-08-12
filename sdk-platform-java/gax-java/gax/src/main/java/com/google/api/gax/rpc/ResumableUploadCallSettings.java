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
import javax.annotation.Nullable;

/**
 * A settings class to configure a {@link ResumableUploadCallable} for executing resumable
 * uploads. Encapsulates protocol options such as payload chunk size and total stream length.
 *
 * @param <RequestT> request type
 * @param <ResponseT> response type
 */
@BetaApi
public final class ResumableUploadCallSettings<RequestT, ResponseT> {
  private static final int DEFAULT_CHUNK_SIZE = 8 * 1024 * 1024; // 8 MB

  @Nullable private final Integer chunkSize;
  @Nullable private final Long totalBytes;

  private ResumableUploadCallSettings(Builder<RequestT, ResponseT> builder) {
    this.chunkSize = builder.chunkSize;
    this.totalBytes = builder.totalBytes;
  }

  /** Returns the configured chunk size in bytes, or {@code null} if unconfigured. */
  @Nullable
  public Integer getChunkSize() {
    return chunkSize;
  }

  /** Returns the configured chunk size, or the GAX default (8 MB / 8,388,608 bytes). */
  public int getChunkSizeOrDefault() {
    return chunkSize != null ? chunkSize : DEFAULT_CHUNK_SIZE;
  }

  /** Returns the total payload size in bytes, or {@code null} if unknown/streamed. */
  @Nullable
  public Long getTotalBytes() {
    return totalBytes;
  }

  /**
   * Merges another {@code ResumableUploadCallSettings} instance with this one.
   * Fields set in {@code perRequestSettings} override fields in this instance.
   *
   * @param perRequestSettings settings to overlay; may be {@code null}
   * @return a new, resolved {@code ResumableUploadCallSettings} instance
   */
  public ResumableUploadCallSettings<RequestT, ResponseT> mergeWith(
      ResumableUploadCallSettings<RequestT, ResponseT> perRequestSettings) {
    if (perRequestSettings == null) {
      return this;
    }
    Builder<RequestT, ResponseT> builder = toBuilder();
    if (perRequestSettings.getChunkSize() != null) {
      builder.setChunkSize(perRequestSettings.getChunkSize());
    }
    if (perRequestSettings.getTotalBytes() != null) {
      builder.setTotalBytes(perRequestSettings.getTotalBytes());
    }
    return builder.build();
  }

  public Builder<RequestT, ResponseT> toBuilder() {
    return new Builder<>(this);
  }

  public static <RequestT, ResponseT> Builder<RequestT, ResponseT> newBuilder() {
    return new Builder<>();
  }

  /** Builder for {@link ResumableUploadCallSettings}. */
  public static class Builder<RequestT, ResponseT> {
    private Integer chunkSize;
    private Long totalBytes;

    private Builder() {}

    private Builder(ResumableUploadCallSettings<RequestT, ResponseT> settings) {
      this.chunkSize = settings.chunkSize;
      this.totalBytes = settings.totalBytes;
    }

    public Builder<RequestT, ResponseT> setChunkSize(Integer chunkSize) {
      this.chunkSize = chunkSize;
      return this;
    }

    @Nullable
    public Integer getChunkSize() {
      return chunkSize;
    }

    public Builder<RequestT, ResponseT> setTotalBytes(Long totalBytes) {
      this.totalBytes = totalBytes;
      return this;
    }

    @Nullable
    public Long getTotalBytes() {
      return totalBytes;
    }

    public ResumableUploadCallSettings<RequestT, ResponseT> build() {
      return new ResumableUploadCallSettings<>(this);
    }
  }
}
