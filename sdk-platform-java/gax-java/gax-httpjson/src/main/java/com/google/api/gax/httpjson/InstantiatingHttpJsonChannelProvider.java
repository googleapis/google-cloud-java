/*
 * Copyright 2017 Google LLC
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
package com.google.api.gax.httpjson;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.core.InternalExtensionOnly;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.mtls.CertificateBasedAccess;
import com.google.auth.Credentials;
import com.google.auth.mtls.CertificateSourceUnavailableException;
import com.google.auth.mtls.DefaultMtlsProviderFactory;
import com.google.auth.mtls.MtlsProvider;
import com.google.common.annotations.VisibleForTesting;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/**
 * InstantiatingHttpJsonChannelProvider is a TransportChannelProvider which constructs a {@link
 * ManagedHttpJsonChannel} with a number of configured inputs every time getChannel(...) is called.
 * These inputs include a port, a service address, and credentials.
 *
 * <p>The credentials can either be supplied directly (by providing a FixedCredentialsProvider to
 * Builder.setCredentialsProvider()) or acquired implicitly from Application Default Credentials (by
 * providing a GoogleCredentialsProvider to Builder.setCredentialsProvider()).
 *
 * <p>The client lib header and generator header values are used to form a value that goes into the
 * http header of requests to the service.
 */
@InternalExtensionOnly
public final class InstantiatingHttpJsonChannelProvider implements TransportChannelProvider {

  @VisibleForTesting
  static final Logger LOG = Logger.getLogger(InstantiatingHttpJsonChannelProvider.class.getName());

  private final Executor executor;
  private final HeaderProvider headerProvider;
  private final HttpJsonInterceptorProvider interceptorProvider;
  private final String endpoint;
  private final HttpTransport httpTransport;
  @Nullable private final MtlsProvider mtlsProvider;
  private final CertificateBasedAccess certificateBasedAccess;

  private InstantiatingHttpJsonChannelProvider(
      Executor executor,
      HeaderProvider headerProvider,
      HttpJsonInterceptorProvider interceptorProvider,
      String endpoint,
      HttpTransport httpTransport,
      MtlsProvider mtlsProvider,
      CertificateBasedAccess certificateBasedAccess) {
    this.executor = executor;
    this.headerProvider = headerProvider;
    this.interceptorProvider = interceptorProvider;
    this.endpoint = endpoint;
    this.httpTransport = httpTransport;
    this.mtlsProvider = mtlsProvider;
    this.certificateBasedAccess = certificateBasedAccess;
  }

  /**
   * @deprecated If executor is not set, this channel provider will create channels with default
   *     executor defined in {@link ManagedHttpJsonChannel}.
   */
  @Deprecated
  @Override
  public boolean needsExecutor() {
    return executor == null;
  }

  @Deprecated
  @Override
  public TransportChannelProvider withExecutor(ScheduledExecutorService executor) {
    return withExecutor((Executor) executor);
  }

  @Override
  public TransportChannelProvider withExecutor(Executor executor) {
    return toBuilder().setExecutor(executor).build();
  }

  @Override
  public boolean needsHeaders() {
    return headerProvider == null;
  }

  @Override
  public TransportChannelProvider withHeaders(Map<String, String> headers) {
    return toBuilder().setHeaderProvider(FixedHeaderProvider.create(headers)).build();
  }

  @Override
  public boolean needsEndpoint() {
    return endpoint == null;
  }

  @Override
  public TransportChannelProvider withEndpoint(String endpoint) {
    return toBuilder().setEndpoint(endpoint).build();
  }

  /**
   * @deprecated REST transport channel doesn't support channel pooling
   */
  @Deprecated
  @Override
  public boolean acceptsPoolSize() {
    return false;
  }

  /**
   * @deprecated REST transport channel doesn't support channel pooling
   */
  @Deprecated
  @Override
  public TransportChannelProvider withPoolSize(int size) {
    throw new UnsupportedOperationException(
        "InstantiatingHttpJsonChannelProvider doesn't allow pool size customization");
  }

  @Override
  public String getTransportName() {
    return HttpJsonTransportChannel.getHttpJsonTransportName();
  }

  @Override
  public HttpJsonTransportChannel getTransportChannel() throws IOException {
    if (needsHeaders()) {
      throw new IllegalStateException("getTransportChannel() called when needsHeaders() is true");
    } else {
      try {
        return createChannel();
      } catch (GeneralSecurityException e) {
        throw new IOException(e);
      }
    }
  }

  @Override
  public boolean needsCredentials() {
    return false;
  }

  @Override
  public TransportChannelProvider withCredentials(Credentials credentials) {
    throw new UnsupportedOperationException(
        "InstantiatingHttpJsonChannelProvider doesn't need credentials");
  }

  HttpTransport createHttpTransport() throws IOException, GeneralSecurityException {
    if (mtlsProvider == null) {
      return null;
    }
    if (certificateBasedAccess.useMtlsClientCertificate()) {
      KeyStore mtlsKeyStore = mtlsProvider.getKeyStore();
      if (mtlsKeyStore != null) {
        return new NetHttpTransport.Builder().trustCertificates(null, mtlsKeyStore, "").build();
      }
    }
    return null;
  }

  private HttpJsonTransportChannel createChannel() throws IOException, GeneralSecurityException {
    HttpTransport httpTransportToUse = httpTransport;
    if (httpTransportToUse == null) {
      httpTransportToUse = createHttpTransport();
    }

    // Pass the executor to the ManagedChannel. If no executor was provided (or null),
    // the channel will use a default executor for the calls.
    ManagedHttpJsonChannel channel =
        ManagedHttpJsonChannel.newBuilder()
            .setEndpoint(endpoint)
            .setExecutor(executor)
            .setHttpTransport(httpTransportToUse)
            .build();

    HttpJsonClientInterceptor headerInterceptor =
        new HttpJsonHeaderInterceptor(headerProvider.getHeaders());

    channel = new ManagedHttpJsonInterceptorChannel(channel, new HttpJsonLoggingInterceptor());
    channel = new ManagedHttpJsonInterceptorChannel(channel, headerInterceptor);
    if (interceptorProvider != null && interceptorProvider.getInterceptors() != null) {
      for (HttpJsonClientInterceptor interceptor : interceptorProvider.getInterceptors()) {
        channel = new ManagedHttpJsonInterceptorChannel(channel, interceptor);
      }
    }

    return HttpJsonTransportChannel.newBuilder().setManagedChannel(channel).build();
  }

  /** The endpoint to be used for the channel. */
  @Override
  public String getEndpoint() {
    return endpoint;
  }

  @Override
  public boolean shouldAutoClose() {
    return true;
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {

    private Executor executor;
    private HeaderProvider headerProvider;
    private HttpJsonInterceptorProvider interceptorProvider;
    private String endpoint;
    private HttpTransport httpTransport;
    private MtlsProvider mtlsProvider;
    private CertificateBasedAccess certificateBasedAccess;

    private Builder() {}

    private Builder(InstantiatingHttpJsonChannelProvider provider) {
      this.executor = provider.executor;
      this.headerProvider = provider.headerProvider;
      this.endpoint = provider.endpoint;
      this.httpTransport = provider.httpTransport;
      this.mtlsProvider = provider.mtlsProvider;
      this.certificateBasedAccess = provider.certificateBasedAccess;
      this.interceptorProvider = provider.interceptorProvider;
    }

    /**
     * Sets the Executor for this TransportChannelProvider.
     *
     * <p>This is optional; if it is not provided, needsExecutor() will return true, meaning that an
     * Executor must be provided when getChannel is called on the constructed
     * TransportChannelProvider instance. Note: InstantiatingHttpJsonChannelProvider will
     * automatically provide its own Executor in this circumstance when it calls getChannel.
     */
    public Builder setExecutor(Executor executor) {
      this.executor = executor;
      return this;
    }

    /**
     * @deprecated Please use {@link #setExecutor(Executor)}.
     */
    @Deprecated
    public Builder setExecutorProvider(ExecutorProvider executorProvider) {
      return setExecutor((Executor) executorProvider.getExecutor());
    }

    /**
     * Sets the HeaderProvider for this TransportChannelProvider.
     *
     * <p>This is optional; if it is not provided, needsHeaders() will return true, meaning that
     * headers must be provided when getChannel is called on the constructed
     * TransportChannelProvider instance.
     */
    public Builder setHeaderProvider(HeaderProvider headerProvider) {
      this.headerProvider = headerProvider;
      return this;
    }

    /**
     * Sets the GrpcInterceptorProvider for this TransportChannelProvider.
     *
     * <p>The provider will be called once for each underlying gRPC ManagedChannel that is created.
     * It is recommended to return a new list of new interceptors on each call so that interceptors
     * are not shared among channels, but this is not required.
     */
    public Builder setInterceptorProvider(HttpJsonInterceptorProvider interceptorProvider) {
      this.interceptorProvider = interceptorProvider;
      return this;
    }

    /** Sets the endpoint used to reach the service, eg "localhost:8080". */
    public Builder setEndpoint(String endpoint) {
      this.endpoint = endpoint;
      return this;
    }

    /** Sets the HTTP transport to be used. */
    public Builder setHttpTransport(HttpTransport httpTransport) {
      this.httpTransport = httpTransport;
      return this;
    }

    public String getEndpoint() {
      return endpoint;
    }

    @VisibleForTesting
    Builder setMtlsProvider(MtlsProvider mtlsProvider) {
      this.mtlsProvider = mtlsProvider;
      return this;
    }

    @VisibleForTesting
    Builder setCertificateBasedAccess(CertificateBasedAccess certificateBasedAccess) {
      this.certificateBasedAccess = certificateBasedAccess;
      return this;
    }

    public InstantiatingHttpJsonChannelProvider build() {
      if (certificateBasedAccess == null) {
        certificateBasedAccess = CertificateBasedAccess.createWithSystemEnv();
      }
      if (certificateBasedAccess.useMtlsClientCertificate()) {
        if (mtlsProvider == null) {
          // Attempt to create default MtlsProvider from environment.
          try {
            mtlsProvider = DefaultMtlsProviderFactory.create();
          } catch (CertificateSourceUnavailableException e) {
            // This is okay. Leave mtlsProvider as null so that we will not auto-upgrade
            // to mTLS endpoints. See https://google.aip.dev/auth/4114.
          } catch (IOException e) {
            LOG.log(
                Level.WARNING,
                "DefaultMtlsProviderFactory encountered unexpected IOException: " + e.getMessage());
            LOG.log(
                Level.WARNING,
                "mTLS configuration was detected on the device, but mTLS failed to initialize. Falling back to non-mTLS channel.");
          }
        }
      }
      return new InstantiatingHttpJsonChannelProvider(
          executor,
          headerProvider,
          interceptorProvider,
          endpoint,
          httpTransport,
          mtlsProvider,
          certificateBasedAccess);
    }
  }
}
