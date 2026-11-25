/*
 * Copyright 2026, Google Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google Inc. nor the names of its
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
package com.google.auth.oauth2;

import com.google.auth.oauth2.AgentIdentityUtils.CertInfo;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.util.Date;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * An {@link AccessToken} that is bound to an agent identity certificate.
 *
 * <p>Keeps the {@link CertInfo} that the token was bound to when it was minted, so callers that
 * send the token over mTLS present exactly that certificate, even if the certificate on disk has
 * rotated since then.
 *
 * <p>The certificate isn't serialized. {@link #writeReplace()} writes a plain {@link AccessToken}
 * that is already expired, so serialized credentials stay readable by versions of the library
 * without this class, and deserialized credentials mint a new token (bound to the certificate
 * available where they run) on first use instead of sending a bound token without its certificate.
 */
@NullMarked
final class BoundAccessToken extends AccessToken {
  private static final long serialVersionUID = 1L;

  private final transient CertInfo certInfo;

  BoundAccessToken(String tokenValue, @Nullable Date expirationTime, CertInfo certInfo) {
    super(tokenValue, expirationTime);
    this.certInfo = certInfo;
  }

  /** Returns the certificate this token is bound to. */
  CertInfo getCertInfo() {
    return certInfo;
  }

  private Object writeReplace() throws ObjectStreamException {
    return new AccessToken(getTokenValue(), new Date(0));
  }

  private void readObject(ObjectInputStream in) throws InvalidObjectException {
    throw new InvalidObjectException("BoundAccessToken cannot be deserialized directly");
  }
}
