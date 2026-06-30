/*
 * Copyright 2015, Google Inc. All rights reserved.
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

package com.google.auth.appengine;

import com.google.appengine.api.appidentity.AppIdentityService;
import com.google.appengine.api.appidentity.AppIdentityServiceFailureException;
import com.google.appengine.api.appidentity.PublicCertificate;
import java.util.Collection;
import java.util.Date;

/** Mock implementation of AppIdentityService interface for testing. */
public class MockAppIdentityService implements AppIdentityService {

  private int getAccessTokenCallCount = 0;
  private String accessTokenText = null;
  private Date expiration = null;
  private String serviceAccountName = null;
  private SigningResult signingResult = null;

  public MockAppIdentityService() {}

  public int getGetAccessTokenCallCount() {
    return getAccessTokenCallCount;
  }

  public String getAccessTokenText() {
    return accessTokenText;
  }

  public void setAccessTokenText(String text) {
    accessTokenText = text;
  }

  public Date getExpiration() {
    return expiration;
  }

  public void setExpiration(Date expiration) {
    this.expiration = expiration;
  }

  @Override
  public SigningResult signForApp(byte[] signBlob) {
    return signingResult;
  }

  public void setSignature(byte[] signature) {
    this.signingResult = new SigningResult("keyName", signature);
  }

  @Override
  public Collection<PublicCertificate> getPublicCertificatesForApp() {
    return null;
  }

  @Override
  public GetAccessTokenResult getAccessToken(Iterable<String> scopes) {
    getAccessTokenCallCount++;
    int scopeCount = 0;
    for (String scope : scopes) {
      if (scope != null) {
        scopeCount++;
      }
    }
    if (scopeCount == 0) {
      throw new AppIdentityServiceFailureException("No scopes specified.");
    }
    return new GetAccessTokenResult(accessTokenText, expiration);
  }

  @Override
  public GetAccessTokenResult getAccessTokenUncached(Iterable<String> scopes) {
    return null;
  }

  @Override
  public String getServiceAccountName() {
    return serviceAccountName;
  }

  public void setServiceAccountName(String serviceAccountName) {
    this.serviceAccountName = serviceAccountName;
  }

  @Override
  public ParsedAppId parseFullAppId(String fullAppId) {
    return null;
  }

  @Override
  public String getDefaultGcsBucketName() {
    return null;
  }
}
