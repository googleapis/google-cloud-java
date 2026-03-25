/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.spanner;

import com.google.auth.CredentialTypeForMetrics;
import com.google.auth.Credentials;
import com.google.auth.RequestMetadataCallback;
import com.google.auth.oauth2.ServiceAccountCredentials;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;

/**
 * A mutable {@link Credentials} implementation that delegates authentication behavior to a scoped
 * {@link ServiceAccountCredentials} instance.
 *
 * <p>This class is intended for scenarios where an application needs to replace the underlying
 * service account credentials for a long-running Spanner Client.
 *
 * <p>All operations inherited from {@link Credentials} are forwarded to the current delegate,
 * including request metadata retrieval and token refresh. Calling {@link
 * #updateCredentials(ServiceAccountCredentials)} replaces the delegate with a newly scoped
 * credentials instance created from the same scopes that were provided when this object was
 * constructed.
 */
public class MutableCredentials extends Credentials {
  private volatile ServiceAccountCredentials delegate;
  private final Set<String> scopes;

  /** Creates a MutableCredentials instance with default spanner scopes. */
  public MutableCredentials(ServiceAccountCredentials credentials) {
    this(credentials, SpannerOptions.SCOPES);
  }

  public MutableCredentials(
      @Nonnull ServiceAccountCredentials credentials, @Nonnull Set<String> scopes) {
    Objects.requireNonNull(credentials, "credentials must not be null");
    Objects.requireNonNull(scopes, "scopes must not be null");
    if (scopes.isEmpty()) {
      throw new IllegalArgumentException("Scopes must not be empty");
    }
    this.scopes = new java.util.HashSet<>(scopes);
    delegate = (ServiceAccountCredentials) credentials.createScoped(this.scopes);
  }

  /**
   * Replaces the current delegate with a newly scoped credentials instance.
   *
   * <p>Note any in-flight RPC may continue to use the old credentials.
   *
   * <p>The provided {@link ServiceAccountCredentials} is scoped using the same scopes that were
   * supplied when this {@link MutableCredentials} instance was created.
   *
   * @param credentials the new base service account credentials to scope and use for client
   *     authorization.
   */
  public void updateCredentials(@Nonnull ServiceAccountCredentials credentials) {
    Objects.requireNonNull(credentials, "credentials must not be null");
    delegate = (ServiceAccountCredentials) credentials.createScoped(scopes);
  }

  @Override
  public String getAuthenticationType() {
    return delegate.getAuthenticationType();
  }

  @Override
  public Map<String, List<String>> getRequestMetadata(URI uri) throws IOException {
    return delegate.getRequestMetadata(uri);
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

  @Override
  public void getRequestMetadata(URI uri, Executor executor, RequestMetadataCallback callback) {
    delegate.getRequestMetadata(uri, executor, callback);
  }

  @Override
  public String getUniverseDomain() throws IOException {
    return delegate.getUniverseDomain();
  }

  @Override
  public CredentialTypeForMetrics getMetricsCredentialType() {
    return delegate.getMetricsCredentialType();
  }
}
