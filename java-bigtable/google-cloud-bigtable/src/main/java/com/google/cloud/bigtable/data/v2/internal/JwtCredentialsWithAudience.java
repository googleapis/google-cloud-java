/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.internal;

import com.google.api.core.InternalApi;
import com.google.auth.Credentials;
import com.google.auth.RequestMetadataCallback;
import com.google.auth.oauth2.ServiceAccountJwtAccessCredentials;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/**
 * Internal helper to fix the mapping between JWT audiences and service endpoints.
 *
 * <p>In most cases JWT audiences correspond to service endpoints. However, in some cases they
 * diverge. To workaround this, this class hardcodes the audience and forces the underlying
 * implementation to use it.
 *
 * <p>Internal Only - public for technical reasons
 */
@InternalApi
public class JwtCredentialsWithAudience extends Credentials {
  private final ServiceAccountJwtAccessCredentials delegate;

  public JwtCredentialsWithAudience(ServiceAccountJwtAccessCredentials delegate, URI audience) {
    this.delegate = delegate.toBuilder().setDefaultAudience(audience).build();
  }

  @Override
  public String getAuthenticationType() {
    return delegate.getAuthenticationType();
  }

  @Override
  public Map<String, List<String>> getRequestMetadata() throws IOException {
    return delegate.getRequestMetadata();
  }

  @Override
  public void getRequestMetadata(URI ignored, Executor executor, RequestMetadataCallback callback) {
    delegate.getRequestMetadata(null, executor, callback);
  }

  @Override
  public Map<String, List<String>> getRequestMetadata(URI ignored) throws IOException {
    return delegate.getRequestMetadata(null);
  }

  @Override
  public boolean hasRequestMetadata() {
    return delegate.hasRequestMetadata();
  }

  @Override
  public boolean hasRequestMetadataOnly() {
    return delegate.hasRequestMetadataOnly();
  }

  @Override
  public void refresh() throws IOException {
    delegate.refresh();
  }
}
