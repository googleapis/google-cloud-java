/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.storage;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.requireNonNull;

import com.google.api.core.ApiClock;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.auth.Credentials;
import com.google.cloud.ServiceFactory;
import com.google.cloud.ServiceRpc;
import com.google.cloud.TransportOptions;
import com.google.cloud.http.HttpTransportOptions;
import com.google.cloud.spi.ServiceRpcFactory;
import com.google.cloud.storage.BlobWriteSessionConfig.WriterFactory;
import com.google.cloud.storage.Retrying.HttpRetrier;
import com.google.cloud.storage.Retrying.RetryingDependencies;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.spi.StorageRpcFactory;
import com.google.cloud.storage.spi.v1.HttpStorageRpc;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;
import io.opentelemetry.api.OpenTelemetry;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.Clock;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * @since 2.14.0
 */
@TransportCompatibility(Transport.HTTP)
// non-final because of mocking frameworks
public class HttpStorageOptions extends StorageOptions {

  private static final long serialVersionUID = -5302637952911052045L;
  private static final String API_SHORT_NAME = "Storage";
  private static final String GCS_SCOPE = "https://www.googleapis.com/auth/devstorage.full_control";
  private static final Set<String> SCOPES = ImmutableSet.of(GCS_SCOPE);
  private final HttpRetryAlgorithmManager retryAlgorithmManager;
  private transient RetryDependenciesAdapter retryDepsAdapter;
  private final BlobWriteSessionConfig blobWriteSessionConfig;

  private transient OpenTelemetry openTelemetry;

  private HttpStorageOptions(Builder builder, StorageDefaults serviceDefaults) {
    super(builder, serviceDefaults);
    this.retryAlgorithmManager =
        new HttpRetryAlgorithmManager(
            MoreObjects.firstNonNull(
                builder.storageRetryStrategy, defaults().getStorageRetryStrategy()));
    retryDepsAdapter = new RetryDependenciesAdapter();
    blobWriteSessionConfig = builder.blobWriteSessionConfig;
    openTelemetry = builder.openTelemetry;
  }

  @Override
  protected Set<String> getScopes() {
    return SCOPES;
  }

  @InternalApi
  HttpRetryAlgorithmManager getRetryAlgorithmManager() {
    return retryAlgorithmManager;
  }

  @InternalApi
  StorageRpc getStorageRpcV1() {
    return (StorageRpc) getRpc();
  }

  /**
   * @since 2.47.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  @Override
  public OpenTelemetry getOpenTelemetry() {
    return openTelemetry;
  }

  @Override
  public HttpStorageOptions.Builder toBuilder() {
    return new HttpStorageOptions.Builder(this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        retryAlgorithmManager, blobWriteSessionConfig, openTelemetry, baseHashCode());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof HttpStorageOptions)) {
      return false;
    }
    HttpStorageOptions that = (HttpStorageOptions) o;
    return Objects.equals(retryAlgorithmManager, that.retryAlgorithmManager)
        && Objects.equals(blobWriteSessionConfig, that.blobWriteSessionConfig)
        && Objects.equals(openTelemetry, that.openTelemetry)
        && this.baseEquals(that);
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.retryDepsAdapter = new RetryDependenciesAdapter();
    this.openTelemetry = HttpStorageOptions.getDefaultInstance().getOpenTelemetry();
  }

  public static HttpStorageOptions.Builder newBuilder() {
    return new HttpStorageOptions.Builder();
  }

  public static HttpStorageOptions getDefaultInstance() {
    return newBuilder().build();
  }

  public static HttpStorageDefaults defaults() {
    return HttpStorageDefaults.INSTANCE;
  }

  @InternalApi
  RetryingDependencies asRetryDependencies() {
    return retryDepsAdapter;
  }

  public static class Builder extends StorageOptions.Builder {

    private StorageRetryStrategy storageRetryStrategy;
    private BlobWriteSessionConfig blobWriteSessionConfig =
        HttpStorageDefaults.INSTANCE.getDefaultStorageWriterConfig();
    private OpenTelemetry openTelemetry = HttpStorageDefaults.INSTANCE.getDefaultOpenTelemetry();

    Builder() {}

    Builder(StorageOptions options) {
      super(options);
      HttpStorageOptions hso = (HttpStorageOptions) options;
      this.storageRetryStrategy = hso.retryAlgorithmManager.retryStrategy;
      this.blobWriteSessionConfig = hso.blobWriteSessionConfig;
      this.openTelemetry = hso.getOpenTelemetry();
    }

    @Override
    public HttpStorageOptions.Builder setTransportOptions(TransportOptions transportOptions) {
      if (!(transportOptions instanceof HttpTransportOptions)) {
        throw new IllegalArgumentException(
            "Only http transport is allowed for " + API_SHORT_NAME + ".");
      }
      super.setTransportOptions(transportOptions);
      return this;
    }

    /**
     * Override the default retry handling behavior with an alternate strategy.
     *
     * @param storageRetryStrategy a non-null storageRetryStrategy to use
     * @return the builder
     * @see StorageRetryStrategy#getDefaultStorageRetryStrategy()
     */
    public HttpStorageOptions.Builder setStorageRetryStrategy(
        StorageRetryStrategy storageRetryStrategy) {
      this.storageRetryStrategy =
          requireNonNull(storageRetryStrategy, "storageRetryStrategy must be non null");
      return this;
    }

    @Override
    protected HttpStorageOptions.Builder self() {
      return this;
    }

    @Override
    public HttpStorageOptions.Builder setServiceFactory(
        ServiceFactory<Storage, StorageOptions> serviceFactory) {
      super.setServiceFactory(serviceFactory);
      return this;
    }

    @Override
    public HttpStorageOptions.Builder setClock(ApiClock clock) {
      super.setClock(clock);
      return this;
    }

    @Override
    public HttpStorageOptions.Builder setProjectId(String projectId) {
      super.setProjectId(projectId);
      return this;
    }

    @Override
    public HttpStorageOptions.Builder setHost(String host) {
      super.setHost(host);
      return this;
    }

    @Override
    public HttpStorageOptions.Builder setCredentials(Credentials credentials) {
      super.setCredentials(credentials);
      return this;
    }

    @Override
    public HttpStorageOptions.Builder setRetrySettings(RetrySettings retrySettings) {
      super.setRetrySettings(retrySettings);
      return this;
    }

    @Override
    public HttpStorageOptions.Builder setServiceRpcFactory(
        ServiceRpcFactory<StorageOptions> serviceRpcFactory) {
      super.setServiceRpcFactory(serviceRpcFactory);
      return this;
    }

    @Override
    public HttpStorageOptions.Builder setHeaderProvider(HeaderProvider headerProvider) {
      super.setHeaderProvider(headerProvider);
      return this;
    }

    @Override
    public HttpStorageOptions.Builder setClientLibToken(String clientLibToken) {
      super.setClientLibToken(clientLibToken);
      return this;
    }

    @Override
    public HttpStorageOptions.Builder setQuotaProjectId(String quotaProjectId) {
      super.setQuotaProjectId(quotaProjectId);
      return this;
    }

    /**
     * @see BlobWriteSessionConfig
     * @see BlobWriteSessionConfigs
     * @see Storage#blobWriteSession(BlobInfo, BlobWriteOption...)
     * @see HttpStorageDefaults#getDefaultStorageWriterConfig()
     * @since 2.29.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public HttpStorageOptions.Builder setBlobWriteSessionConfig(
        @NonNull BlobWriteSessionConfig blobWriteSessionConfig) {
      requireNonNull(blobWriteSessionConfig, "blobWriteSessionConfig must be non null");
      checkArgument(
          blobWriteSessionConfig instanceof BlobWriteSessionConfig.HttpCompatible,
          "The provided instance of BlobWriteSessionConfig is not compatible with this HTTP"
              + " transport.");
      this.blobWriteSessionConfig = blobWriteSessionConfig;
      return this;
    }

    @Override
    public HttpStorageOptions.Builder setUniverseDomain(String universeDomain) {
      super.setUniverseDomain(universeDomain);
      return this;
    }

    @Override
    public HttpStorageOptions.Builder setApiTracerFactory(ApiTracerFactory apiTracerFactory) {
      super.setApiTracerFactory(apiTracerFactory);
      return this;
    }

    @Override
    public HttpStorageOptions build() {
      HttpStorageOptions options = new HttpStorageOptions(this, defaults());

      // todo: In the future, this step will be done automatically, and the getResolvedApiaryHost
      // helper method will
      // be removed. When that happens, delete the following block.
      // https://github.com/googleapis/google-api-java-client-services/issues/19286
      if (options.getHost() != null) { // user did not manually set a host
        this.setHost(options.getResolvedApiaryHost("storage"));
        return new HttpStorageOptions(this, defaults());
      }
      return options;
    }

    /**
     * Enable OpenTelemetry Tracing and provide an instance for the client to use.
     *
     * @param openTelemetry User defined instance of OpenTelemetry to be used by the library
     * @since 2.47.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public HttpStorageOptions.Builder setOpenTelemetry(OpenTelemetry openTelemetry) {
      requireNonNull(openTelemetry, "openTelemetry must be non null");
      this.openTelemetry = openTelemetry;
      return this;
    }
  }

  public static final class HttpStorageDefaults extends StorageDefaults {
    static final HttpStorageDefaults INSTANCE = new HttpStorageDefaults();
    static final StorageFactory STORAGE_FACTORY = new HttpStorageFactory();
    static final StorageRpcFactory STORAGE_RPC_FACTORY = new HttpStorageRpcFactory();

    private HttpStorageDefaults() {}

    @Override
    public StorageFactory getDefaultServiceFactory() {
      return STORAGE_FACTORY;
    }

    @Override
    public StorageRpcFactory getDefaultRpcFactory() {
      return STORAGE_RPC_FACTORY;
    }

    @Override
    public HttpTransportOptions getDefaultTransportOptions() {
      return HttpTransportOptions.newBuilder().build();
    }

    public StorageRetryStrategy getStorageRetryStrategy() {
      return StorageRetryStrategy.getDefaultStorageRetryStrategy();
    }

    /**
     * @since 2.29.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public BlobWriteSessionConfig getDefaultStorageWriterConfig() {
      return BlobWriteSessionConfigs.getDefault();
    }

    /**
     * @since 2.47.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public OpenTelemetry getDefaultOpenTelemetry() {
      return OpenTelemetry.noop();
    }
  }

  /**
   * Internal implementation detail, only public to allow for {@link java.io.Serializable}.
   *
   * <p>To access an instance of this class instead use {@link
   * HttpStorageDefaults#getDefaultServiceFactory()
   * HttpStorageOptions.defaults().getDefaultServiceFactory()}.
   *
   * @see HttpStorageOptions#defaults()
   * @see HttpStorageDefaults#getDefaultServiceFactory()
   */
  @InternalApi
  public static class HttpStorageFactory implements StorageFactory, Serializable {
    private static final long serialVersionUID = 1063208433681579145L;

    /**
     * Internal implementation detail, only public to allow for {@link java.io.Serializable}.
     *
     * <p>To access an instance of this class instead use {@link
     * HttpStorageDefaults#getDefaultServiceFactory()
     * HttpStorageOptions.defaults().getDefaultServiceFactory()}.
     *
     * @see HttpStorageOptions#defaults()
     * @see HttpStorageDefaults#getDefaultServiceFactory()
     * @deprecated instead use {@link HttpStorageDefaults#getDefaultServiceFactory()
     *     HttpStorageOptions.defaults().getDefaultServiceFactory()}
     */
    // this class needs to be public due to ServiceOptions forName'ing it in it's readObject method
    @InternalApi
    @Deprecated
    @SuppressWarnings("DeprecatedIsStillUsed")
    public HttpStorageFactory() {}

    @Override
    public Storage create(StorageOptions options) {
      if (options instanceof HttpStorageOptions) {
        HttpStorageOptions httpStorageOptions = (HttpStorageOptions) options;
        Clock clock = Clock.systemUTC();
        try {
          OpenTelemetry otel = httpStorageOptions.getOpenTelemetry();
          BlobWriteSessionConfig blobWriteSessionConfig = httpStorageOptions.blobWriteSessionConfig;
          if (blobWriteSessionConfig == null) {
            blobWriteSessionConfig = HttpStorageOptions.defaults().getDefaultStorageWriterConfig();
          }
          WriterFactory factory = blobWriteSessionConfig.createFactory(clock);
          StorageImpl storage =
              new StorageImpl(
                  httpStorageOptions, factory, new HttpRetrier(options.createRetrier()));
          return OtelStorageDecorator.decorate(storage, otel, Transport.HTTP);
        } catch (IOException e) {
          throw new IllegalStateException(
              "Unable to instantiate HTTP com.google.cloud.storage.Storage client.", e);
        }
      } else {
        throw new IllegalArgumentException("Only HttpStorageOptions supported");
      }
    }
  }

  /**
   * Internal implementation detail, only public to allow for {@link java.io.Serializable}.
   *
   * <p>To access an instance of this class instead use {@link
   * HttpStorageDefaults#getDefaultRpcFactory()
   * HttpStorageOptions.defaults().getDefaultRpcFactory()}.
   *
   * @see HttpStorageOptions#defaults()
   * @see HttpStorageDefaults#getDefaultRpcFactory()
   */
  @InternalApi
  public static class HttpStorageRpcFactory implements StorageRpcFactory, Serializable {
    private static final long serialVersionUID = -5896805045709989797L;

    /**
     * Internal implementation detail, only public to allow for {@link java.io.Serializable}.
     *
     * <p>To access an instance of this class instead use {@link
     * HttpStorageDefaults#getDefaultRpcFactory()
     * HttpStorageOptions.defaults().getDefaultRpcFactory()}.
     *
     * @see HttpStorageOptions#defaults()
     * @see HttpStorageDefaults#getDefaultRpcFactory()
     * @deprecated instead use {@link HttpStorageDefaults#getDefaultRpcFactory()
     *     HttpStorageOptions.defaults().getDefaultRpcFactory()}
     */
    // this class needs to be public due to ServiceOptions forName'ing it in it's readObject method
    @InternalApi
    @Deprecated
    @SuppressWarnings("DeprecatedIsStillUsed")
    public HttpStorageRpcFactory() {}

    @Override
    public ServiceRpc create(StorageOptions options) {
      if (options instanceof HttpStorageOptions) {
        HttpStorageOptions httpStorageOptions = (HttpStorageOptions) options;
        return new HttpStorageRpc(httpStorageOptions);
      } else {
        throw new IllegalArgumentException("Only HttpStorageOptions supported");
      }
    }
  }

  /**
   * We don't yet want to make HttpStorageOptions itself implement {@link RetryingDependencies} but
   * we do need use it in a couple places, for those we create this adapter.
   */
  private final class RetryDependenciesAdapter implements RetryingDependencies {
    private RetryDependenciesAdapter() {}

    @Override
    public RetrySettings getRetrySettings() {
      return HttpStorageOptions.this.getRetrySettings();
    }

    @Override
    public ApiClock getClock() {
      return HttpStorageOptions.this.getClock();
    }
  }
}
