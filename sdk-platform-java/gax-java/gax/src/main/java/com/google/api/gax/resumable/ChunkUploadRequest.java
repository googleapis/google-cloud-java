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
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import org.jspecify.annotations.NullMarked;

/** Request value object for uploading a chunk to an active resumable upload session. */
@NullMarked
@InternalApi
@AutoValue
public abstract class ChunkUploadRequest {

  /** The upload session URL returned during session initialization. */
  public abstract String getUploadUrl();

  /** The binary chunk payload to upload. */
  public abstract ByteString getPayload();

  /** The byte offset of this chunk in the overall stream. */
  public abstract long getOffset();

  /** Whether this is the final chunk in the stream. */
  public abstract boolean isFinal();

  public static Builder newBuilder() {
    return new AutoValue_ChunkUploadRequest.Builder().setFinal(false);
  }

  public static ChunkUploadRequest create(String uploadUrl, ByteString payload, long offset) {
    return newBuilder()
        .setUploadUrl(uploadUrl)
        .setPayload(payload)
        .setOffset(offset)
        .setFinal(false)
        .build();
  }

  public static ChunkUploadRequest create(
      String uploadUrl, ByteString payload, long offset, boolean isFinal) {
    return newBuilder()
        .setUploadUrl(uploadUrl)
        .setPayload(payload)
        .setOffset(offset)
        .setFinal(isFinal)
        .build();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setUploadUrl(String uploadUrl);

    public abstract Builder setPayload(ByteString payload);

    public abstract Builder setOffset(long offset);

    public abstract Builder setFinal(boolean isFinal);

    abstract ChunkUploadRequest autoBuild();

    public ChunkUploadRequest build() {
      ChunkUploadRequest request = autoBuild();
      Preconditions.checkArgument(request.getOffset() >= 0, "offset must be non-negative");
      return request;
    }
  }
}
