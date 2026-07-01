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

/** Status snapshot of an ongoing resumable upload. */
@BetaApi
public final class ResumableUploadStatus {
  private final long bytesUploaded;
  private final long totalBytes;
  private final ResumableUploadProgressListener.State state;

  public ResumableUploadStatus(
      long bytesUploaded, long totalBytes, ResumableUploadProgressListener.State state) {
    this.bytesUploaded = bytesUploaded;
    this.totalBytes = totalBytes;
    this.state = state;
  }

  /** Returns the number of bytes successfully uploaded to the server so far. */
  public long getBytesUploaded() {
    return bytesUploaded;
  }

  /** Returns the total size of the stream in bytes, or -1 if unknown. */
  public long getTotalBytes() {
    return totalBytes;
  }

  /** Returns the current state of the upload session. */
  public ResumableUploadProgressListener.State getState() {
    return state;
  }

  @Override
  public String toString() {
    return "ResumableUploadStatus{"
        + "bytesUploaded="
        + bytesUploaded
        + ", totalBytes="
        + totalBytes
        + ", state="
        + state
        + '}';
  }
}
