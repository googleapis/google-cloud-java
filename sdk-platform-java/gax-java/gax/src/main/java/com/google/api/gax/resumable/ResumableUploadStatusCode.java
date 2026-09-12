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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.StatusCode;
import java.util.Objects;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * A {@link StatusCode} that preserves the transport status code of a failed resumable upload
 * command and carries the {@code X-Goog-Upload-Status} header value from the response.
 *
 * <p>Used to propagate a server rejection (a non-2xx response with {@code X-Goog-Upload-Status:
 * final}) from the transport layer to the resumable upload retry logic, so that the rejection is
 * treated as terminal while the original status code remains available.
 */
@NullMarked
@BetaApi
@InternalApi
public final class ResumableUploadStatusCode implements StatusCode {
  private final StatusCode delegate;
  private final ResumableUploadStatus uploadStatus;

  private ResumableUploadStatusCode(StatusCode delegate, ResumableUploadStatus uploadStatus) {
    this.delegate = checkNotNull(delegate, "delegate must not be null");
    this.uploadStatus = checkNotNull(uploadStatus, "uploadStatus must not be null");
  }

  public static ResumableUploadStatusCode of(
      StatusCode delegate, ResumableUploadStatus uploadStatus) {
    return new ResumableUploadStatusCode(delegate, uploadStatus);
  }

  @Override
  public Code getCode() {
    return delegate.getCode();
  }

  @Override
  public @Nullable Object getTransportCode() {
    return delegate.getTransportCode();
  }

  public ResumableUploadStatus getUploadStatus() {
    return uploadStatus;
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ResumableUploadStatusCode)) {
      return false;
    }
    ResumableUploadStatusCode that = (ResumableUploadStatusCode) o;
    return Objects.equals(delegate, that.delegate) && uploadStatus == that.uploadStatus;
  }

  @Override
  public int hashCode() {
    return Objects.hash(delegate, uploadStatus);
  }
}
