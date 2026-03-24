/*
 * Copyright 2020 Google LLC
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
package com.google.api.gax.rpc.internal;

import com.google.api.client.util.Beta;
import com.google.auth.Credentials;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * {@code QuotaProjectIdHidingCredentials} is intended to be used to wrap a {@link Credentials} to
 * hide quota project id
 *
 * <p>Ensure that a custom set quota project id takes priority over one detected by credentials.
 */
@Beta
public class QuotaProjectIdHidingCredentials extends Credentials {
  private static final String QUOTA_PROJECT_ID_HEADER_KEY = "x-goog-user-project";
  private final Credentials wrappedCredentials;

  public QuotaProjectIdHidingCredentials(Credentials credentials) {
    this.wrappedCredentials = credentials;
  }

  @Override
  public String getAuthenticationType() {
    return this.wrappedCredentials.getAuthenticationType();
  }

  @Override
  public Map<String, List<String>> getRequestMetadata(URI uri) throws IOException {
    ImmutableMap.Builder<String, List<String>> metaBuilder = ImmutableMap.builder();
    for (Map.Entry<String, List<String>> entry :
        this.wrappedCredentials.getRequestMetadata(uri).entrySet()) {
      if (entry.getKey().equals(QUOTA_PROJECT_ID_HEADER_KEY)) {
        continue;
      }
      metaBuilder.put(entry);
    }
    return metaBuilder.build();
  }

  @Override
  public Map<String, List<String>> getRequestMetadata() throws IOException {
    return this.getRequestMetadata(null);
  }

  @Override
  public boolean hasRequestMetadata() {
    return this.wrappedCredentials.hasRequestMetadata();
  }

  @Override
  public boolean hasRequestMetadataOnly() {
    return this.wrappedCredentials.hasRequestMetadataOnly();
  }

  @Override
  public void refresh() throws IOException {
    this.wrappedCredentials.refresh();
  }

  @Override
  public String getUniverseDomain() throws IOException {
    return this.wrappedCredentials.getUniverseDomain();
  }
}
