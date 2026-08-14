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
import com.google.common.base.Preconditions;
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

    /** The upload was successfully finalized by the server. */
    FINALIZED,

    /** The upload failed unrecoverably or was cancelled. */
    FAILED
  }

  /** Returns the negotiated upload session URI, or {@code null} if session initiation is pending. */
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

  /** Returns true if the upload completed successfully. */
  public boolean isCompleted() {
    return getState() == State.FINALIZED;
  }

  /** Returns true if the upload is in a terminal state ({@code FINALIZED} or {@code FAILED}). */
  public boolean isDone() {
    return getState() == State.FINALIZED || getState() == State.FAILED;
  }

  public abstract Builder toBuilder();

  public static Builder builder() {
    return new AutoValue_ResumableUploadStatus.Builder()
        .setBytesUploaded(0L)
        .setTotalBytes(-1L)
        .setState(State.STARTING);
  }

  /**
   * Creates a {@link ResumableUploadStatus} snapshot.
   *
   * @param uploadUrl the upload session URI
   * @param bytesUploaded the number of bytes uploaded so far
   * @param totalBytes the total size of the payload in bytes, or -1 if unknown
   * @param state the current upload state
   * @return a new {@link ResumableUploadStatus} instance
   */
  public static ResumableUploadStatus create(
      @Nullable String uploadUrl, long bytesUploaded, long totalBytes, State state) {
    return builder()
        .setUploadUrl(uploadUrl)
        .setBytesUploaded(bytesUploaded)
        .setTotalBytes(totalBytes)
        .setState(state)
        .build();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setUploadUrl(@Nullable String uploadUrl);

    public abstract Builder setBytesUploaded(long bytesUploaded);

    public abstract Builder setTotalBytes(long totalBytes);

    public abstract Builder setState(State state);

    public abstract Builder setException(@Nullable Throwable exception);

    abstract ResumableUploadStatus autoBuild();

    public ResumableUploadStatus build() {
      ResumableUploadStatus status = autoBuild();
      Preconditions.checkArgument(
          status.getBytesUploaded() >= 0L, "bytesUploaded must be non-negative");
      Preconditions.checkArgument(status.getTotalBytes() >= -1L, "totalBytes must be >= -1");
      if (status.getTotalBytes() >= 0L) {
        Preconditions.checkArgument(
            status.getBytesUploaded() <= status.getTotalBytes(),
            "bytesUploaded must be <= totalBytes");
      }
      return status;
    }
  }
}
