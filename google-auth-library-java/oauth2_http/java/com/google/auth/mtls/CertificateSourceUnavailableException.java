/*
 * Copyright 2025 Google LLC
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

package com.google.auth.mtls;

import java.io.IOException;

/**
 * This exception is thrown by certificate providers in the Google auth library when the certificate
 * source is unavailable. This means that the transport layer should move on to the next certificate
 * source provider type.
 */
public class CertificateSourceUnavailableException extends IOException {

  /**
   * Constructor with a message and throwable cause.
   *
   * @param message The detail message (which is saved for later retrieval by the {@link
   *     #getMessage()} method)
   * @param cause The cause (which is saved for later retrieval by the {@link #getCause()} method).
   *     (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
   */
  public CertificateSourceUnavailableException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructor with a throwable cause.
   *
   * @param cause The cause (which is saved for later retrieval by the {@link #getCause()} method).
   *     (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
   */
  public CertificateSourceUnavailableException(Throwable cause) {
    super(cause);
  }

  /**
   * Constructor with a message.
   *
   * @param message The detail message (which is saved for later retrieval by the {@link
   *     #getMessage()} method)
   */
  public CertificateSourceUnavailableException(String message) {
    super(message);
  }
}
