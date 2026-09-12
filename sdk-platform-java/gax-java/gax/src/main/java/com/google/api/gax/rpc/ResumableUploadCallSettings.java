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
import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;
import java.time.Duration;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * A settings class to configure a {@link ResumableUploadCallable} for executing resumable uploads.
 * Encapsulates protocol options such as payload chunk size and global upload timeout.
 */
@BetaApi
@AutoValue
@NullMarked
public abstract class ResumableUploadCallSettings {
  private static final int DEFAULT_CHUNK_SIZE = 8 * 1024 * 1024; // 8 MB
  // Matches Ruby google-apis-core RequestOptions.default.max_elapsed_time = 900s (CL-R9).
  private static final Duration DEFAULT_GLOBAL_TIMEOUT = Duration.ofMinutes(15);

  abstract @Nullable Integer chunkSizeOption();

  abstract @Nullable Duration globalTimeoutOption();

  /** Returns the configured chunk size in bytes (defaults to 8 MB / 8,388,608 bytes). */
  public int getChunkSize() {
    Integer size = chunkSizeOption();
    return size != null ? size : DEFAULT_CHUNK_SIZE;
  }

  /**
   * Returns the global upload timeout governing the entire upload duration (defaults to 15
   * minutes).
   */
  public Duration getGlobalTimeout() {
    Duration timeout = globalTimeoutOption();
    return timeout != null ? timeout : DEFAULT_GLOBAL_TIMEOUT;
  }

  /**
   * Merges another {@code ResumableUploadCallSettings} instance with this one. Fields explicitly
   * set in {@code other} override fields in this instance.
   *
   * @param other settings to overlay; may be {@code null}
   * @return a new, resolved {@code ResumableUploadCallSettings} instance
   */
  public ResumableUploadCallSettings merge(@Nullable ResumableUploadCallSettings other) {
    if (other == null) {
      return this;
    }
    Builder builder = toBuilder();
    if (other.chunkSizeOption() != null) {
      builder.setChunkSize(other.chunkSizeOption());
    }
    if (other.globalTimeoutOption() != null) {
      builder.setGlobalTimeout(other.globalTimeoutOption());
    }
    return builder.build();
  }

  public abstract Builder toBuilder();

  public static Builder newBuilder() {
    return new AutoValue_ResumableUploadCallSettings.Builder();
  }

  /** Builder for {@link ResumableUploadCallSettings}. */
  @AutoValue.Builder
  public abstract static class Builder {
    abstract Builder setChunkSizeOption(@Nullable Integer chunkSize);

    abstract @Nullable Integer chunkSizeOption();

    public Builder setChunkSize(int chunkSize) {
      return setChunkSizeOption(chunkSize);
    }

    public int getChunkSize() {
      Integer size = chunkSizeOption();
      return size != null ? size : DEFAULT_CHUNK_SIZE;
    }

    abstract Builder setGlobalTimeoutOption(@Nullable Duration globalTimeout);

    abstract @Nullable Duration globalTimeoutOption();

    public Builder setGlobalTimeout(@Nullable Duration globalTimeout) {
      return setGlobalTimeoutOption(globalTimeout);
    }

    public @Nullable Duration getGlobalTimeout() {
      return globalTimeoutOption();
    }

    abstract ResumableUploadCallSettings autoBuild();

    public ResumableUploadCallSettings build() {
      Integer size = chunkSizeOption();
      if (size != null) {
        Preconditions.checkArgument(size > 0, "chunkSize must be > 0");
      }
      Duration timeout = globalTimeoutOption();
      if (timeout != null) {
        Preconditions.checkArgument(
            !timeout.isNegative() && !timeout.isZero(), "globalTimeout must be positive");
      }
      return autoBuild();
    }
  }
}
