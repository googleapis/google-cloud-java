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
package com.google.api.gax.resumableupload;

import com.google.api.core.BetaApi;
import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;
import org.jspecify.annotations.NullMarked;

/** Status snapshot of an ongoing resumable upload session. */
@BetaApi
@NullMarked
@AutoValue
public abstract class ResumableUploadStatus {

  /** The state of the resumable upload session. */
  public enum State {
    /** The upload session was successfully initiated with the server. */
    STARTED,

    /** A data chunk was successfully uploaded to the server. */
    UPLOADING,

    /** A recoverable error occurred; the client is initiating recovery. */
    RECOVERING,

    /** A status query succeeded and the stream offset was reconciled. */
    OFFSET_RECEIVED,

    /** The final chunk was accepted and the upload session is complete. */
    FINALIZED
  }

  /** Returns the negotiated upload session URI. */
  public abstract String getUploadUrl();

  /** Returns the number of bytes successfully uploaded to the server so far. */
  public abstract long getBytesUploaded();

  /** Returns the total size of the upload payload in bytes, or -1 if unknown. */
  public abstract long getTotalBytes();

  /** Returns the current state of the upload session. */
  public abstract State getState();

  /** Returns whether the total upload size is unknown (e.g. streaming upload). */
  public boolean isIndeterminate() {
    return getTotalBytes() == -1;
  }

  /** Returns whether the upload has reached a completed state. */
  public boolean isCompleted() {
    return getState() == State.FINALIZED;
  }

  /**
   * Returns the upload progress as a fraction between 0.0 and 1.0, or -1.0 if total size is
   * unknown.
   *
   * @return progress fraction between 0.0 and 1.0, or -1.0 if unknown
   */
  public double getProgressFraction() {
    if (isIndeterminate()) {
      return -1.0;
    }
    if (getTotalBytes() == 0) {
      return 1.0;
    }
    return (double) getBytesUploaded() / getTotalBytes();
  }

  public abstract Builder toBuilder();

  public static Builder builder() {
    return new AutoValue_ResumableUploadStatus.Builder()
        .setBytesUploaded(0L)
        .setTotalBytes(-1L)
        .setState(State.STARTED);
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
      String uploadUrl, long bytesUploaded, long totalBytes, State state) {
    return builder()
        .setUploadUrl(uploadUrl)
        .setBytesUploaded(bytesUploaded)
        .setTotalBytes(totalBytes)
        .setState(state)
        .build();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setUploadUrl(String uploadUrl);

    public abstract Builder setBytesUploaded(long bytesUploaded);

    public abstract Builder setTotalBytes(long totalBytes);

    public abstract Builder setState(State state);

    abstract ResumableUploadStatus autoBuild();

    public ResumableUploadStatus build() {
      ResumableUploadStatus status = autoBuild();
      Preconditions.checkArgument(
          status.getBytesUploaded() >= 0, "bytesUploaded must be non-negative");
      Preconditions.checkArgument(status.getTotalBytes() >= -1, "totalBytes must be >= -1");
      if (status.getTotalBytes() >= 0) {
        Preconditions.checkArgument(
            status.getBytesUploaded() <= status.getTotalBytes(),
            "bytesUploaded must be <= totalBytes");
      }
      return status;
    }
  }
}
