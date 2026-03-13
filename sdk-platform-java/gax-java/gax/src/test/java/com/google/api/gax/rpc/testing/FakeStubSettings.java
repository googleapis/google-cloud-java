/*
 * Copyright 2018 Google LLC
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
package com.google.api.gax.rpc.testing;

import com.google.api.core.InternalApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.StubSettings;
import com.google.common.collect.ImmutableList;
import java.io.IOException;

@InternalApi("for testing")
public class FakeStubSettings extends StubSettings {

  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().build();

  private FakeStubSettings(Builder builder) throws IOException {
    super(builder);
  }

  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  @Override
  public String getServiceName() {
    return "test";
  }

  @Override
  public StubSettings.Builder toBuilder() {
    return new Builder(this);
  }

  public static class Builder extends StubSettings.Builder {

    public Builder(ClientContext clientContext) {
      super(clientContext);
    }

    public Builder(StubSettings stubSettings) {
      super(stubSettings);
    }

    public Builder() {
      super((ClientContext) null);
    }

    @Override
    public com.google.api.gax.rpc.testing.FakeStubSettings build() throws IOException {
      return new com.google.api.gax.rpc.testing.FakeStubSettings(this);
    }

    /** Returns default settings values. */
    public static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder());
      return builder;
    }

    /** Returns default credentials provider. */
    public static GoogleCredentialsProvider defaultCredentialsProviderBuilder() {
      return GoogleCredentialsProvider.newBuilder()
          .setScopesToApply(DEFAULT_SERVICE_SCOPES)
          .setUseJwtAccessWithScope(true)
          .build();
    }
  }
}
