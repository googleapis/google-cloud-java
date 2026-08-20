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
import com.google.api.gax.retrying.RetrySettings;
import com.google.auto.value.AutoValue;
import org.jspecify.annotations.Nullable;

/**
 * A settings class to configure a {@link ResumableUploadCallable} for executing resumable uploads.
 * Encapsulates protocol options such as payload chunk size and retry settings.
 */
@BetaApi
@AutoValue
public abstract class ResumableUploadCallSettings {
  private static final int DEFAULT_CHUNK_SIZE = 8 * 1024 * 1024; // 8 MB

  /** Returns the configured chunk size in bytes (defaults to 8 MB / 8,388,608 bytes). */
  public abstract int getChunkSize();

  /** Returns the configured retry settings, or null if defaults should be used. */
  public abstract @Nullable RetrySettings getRetrySettings();

  /**
   * Merges another {@code ResumableUploadCallSettings} instance with this one. Fields set in {@code
   * other} override fields in this instance.
   *
   * @param other settings to overlay; may be {@code null}
   * @return a new, resolved {@code ResumableUploadCallSettings} instance
   */
  public ResumableUploadCallSettings merge(ResumableUploadCallSettings other) {
    if (other == null) {
      return this;
    }
    Builder builder = toBuilder().setChunkSize(other.getChunkSize());
    if (other.getRetrySettings() != null) {
      builder.setRetrySettings(other.getRetrySettings());
    }
    return builder.build();
  }

  public abstract Builder toBuilder();

  public static Builder newBuilder() {
    return new AutoValue_ResumableUploadCallSettings.Builder().setChunkSize(DEFAULT_CHUNK_SIZE);
  }

  /** Builder for {@link ResumableUploadCallSettings}. */
  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setChunkSize(int chunkSize);

    public abstract int getChunkSize();

    public abstract Builder setRetrySettings(@Nullable RetrySettings retrySettings);

    public abstract @Nullable RetrySettings getRetrySettings();

    public abstract ResumableUploadCallSettings build();
  }
}
