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

/** Represents the session metadata returned after starting a resumable upload. */
@InternalApi
@AutoValue
public abstract class ResumableUploadSession {

  private static final long DEFAULT_CHUNK_GRANULARITY = 1L;

  /** Returns the server-provided URL to which data uploads are directed. */
  public abstract String getUploadUrl();

  /**
   * Returns the server-mandated chunk granularity in bytes.
   *
   * <p>When specified by the server (via {@code X-Goog-Upload-Chunk-Granularity}), intermediate
   * upload chunks must have a size and offset that are an exact multiple of this value (the final
   * chunk may be smaller). If not specified by the server, this defaults to 1 byte, indicating no
   * alignment or granularity requirements apply.
   *
   * @return the chunk granularity in bytes
   */
  public abstract long getChunkGranularity();

  /**
   * Creates a {@link ResumableUploadSession} with the specified upload URL and default chunk
   * granularity.
   *
   * @param uploadUrl the upload session URL
   * @return a new {@link ResumableUploadSession} instance
   */
  public static ResumableUploadSession create(String uploadUrl) {
    return create(uploadUrl, DEFAULT_CHUNK_GRANULARITY);
  }

  /**
   * Creates a {@link ResumableUploadSession} with the specified upload URL and chunk granularity.
   *
   * @param uploadUrl the upload session URL
   * @param chunkGranularity the chunk granularity in bytes; if &le; 0, 1 is used to indicate no
   *     alignment or granularity requirements apply.
   * @return a new {@link ResumableUploadSession} instance
   */
  public static ResumableUploadSession create(String uploadUrl, long chunkGranularity) {
    return new AutoValue_ResumableUploadSession(
        uploadUrl, chunkGranularity > 0 ? chunkGranularity : DEFAULT_CHUNK_GRANULARITY);
  }
}
