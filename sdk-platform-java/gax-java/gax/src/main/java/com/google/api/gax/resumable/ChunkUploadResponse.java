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

import com.google.api.core.InternalApi;
import com.google.auto.value.AutoValue;
import org.jspecify.annotations.NullMarked;

/** Response value object representing the outcome of a chunk upload. */
@NullMarked
@InternalApi
@AutoValue
public abstract class ChunkUploadResponse {

  /**
   * The total number of bytes successfully received and committed by the server so far.
   *
   * <p>This value is the starting offset for the next chunk upload.
   */
  public abstract long getCommittedOffset();

  /** Whether the overall resumable upload stream has finalized and completed on the server. */
  public abstract boolean isComplete();

  /**
   * The response body returned by the server upon final completion (e.g. JSON metadata of the
   * uploaded resource), or an empty string if no body was returned or the upload is still in
   * progress.
   */
  public abstract String getResponseBody();

  public static Builder newBuilder() {
    return new AutoValue_ChunkUploadResponse.Builder().setComplete(false).setResponseBody("");
  }

  public static ChunkUploadResponse create(long committedOffset, boolean isComplete) {
    return newBuilder().setCommittedOffset(committedOffset).setComplete(isComplete).build();
  }

  public static ChunkUploadResponse create(
      long committedOffset, boolean isComplete, String responseBody) {
    return newBuilder()
        .setCommittedOffset(committedOffset)
        .setComplete(isComplete)
        .setResponseBody(responseBody)
        .build();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setCommittedOffset(long committedOffset);

    public abstract Builder setComplete(boolean isComplete);

    public abstract Builder setResponseBody(String responseBody);

    public abstract ChunkUploadResponse build();
  }
}
