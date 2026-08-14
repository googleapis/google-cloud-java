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
package com.google.api.gax.resumable;

import com.google.api.core.BetaApi;
import com.google.auto.value.AutoValue;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/** Status snapshot of an ongoing or completed resumable upload session. */
@BetaApi
@NullMarked
@AutoValue
public abstract class ResumableUploadStatus {

  /** The state of the resumable upload session. */
  public enum State {
    /** Session initiation is in progress (acquiring upload session URL). */
    STARTING,

    /** Transmitting chunk payloads to the server. */
    UPLOADING,

    /** A recoverable error occurred; querying server status and resynchronizing offset. */
    RECOVERING,

    /** The server query status succeeded and the committed offset was received. */
    OFFSET_RECEIVED,

    /** The upload was successfully finalized by the server. */
    FINALIZED,

    /** The upload failed unrecoverably or was cancelled. */
    FAILED
  }

  /**
   * Returns the negotiated upload session URI, or {@code null} if session initiation is pending.
   */
  public abstract @Nullable String getUploadUrl();

  /** Returns the number of bytes successfully uploaded to the server so far. */
  public abstract long getBytesUploaded();

  /** Returns the total size of the upload payload in bytes, or {@code -1} if unknown. */
  public abstract long getTotalBytes();

  /** Returns the current state of the upload session. */
  public abstract State getState();

  /** Returns the exception that triggered recovery or caused failure, if any. */
  public abstract @Nullable Throwable getException();

  /** Returns true if the total upload size is known (i.e. {@code totalBytes >= 0}). */
  public boolean hasTotalBytes() {
    return getTotalBytes() >= 0L;
  }

  public abstract Builder toBuilder();

  public static Builder newBuilder() {
    return new AutoValue_ResumableUploadStatus.Builder()
        .setBytesUploaded(0L)
        .setTotalBytes(-1L)
        .setState(State.STARTING);
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setUploadUrl(@Nullable String uploadUrl);

    public abstract Builder setBytesUploaded(long bytesUploaded);

    public abstract Builder setTotalBytes(long totalBytes);

    public abstract Builder setState(State state);

    public abstract Builder setException(@Nullable Throwable exception);

    public abstract ResumableUploadStatus build();
  }
}
