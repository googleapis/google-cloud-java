/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.grpc;

import static com.google.common.base.MoreObjects.firstNonNull;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.auth.Credentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.TransportOptions;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/** Class representing service options for those services that use gRPC as the transport layer. */
public class GrpcTransportOptions implements TransportOptions {

  private static final long serialVersionUID = -9049538465533951165L;
  private final String executorFactoryClassName;

  private transient ExecutorFactory<ScheduledExecutorService> executorFactory;

  /** Shared thread pool executor. */
  private static final SharedResourceHolder.Resource<ScheduledExecutorService> EXECUTOR =
      new SharedResourceHolder.Resource<ScheduledExecutorService>() {
        @Override
        public ScheduledExecutorService create() {
          ScheduledThreadPoolExecutor service =
              new ScheduledThreadPoolExecutor(
                  8,
                  new ThreadFactoryBuilder()
                      .setDaemon(true)
                      .setNameFormat("grpc-transport-%d")
                      .build());
          service.setKeepAliveTime(5, TimeUnit.SECONDS);
          service.allowCoreThreadTimeOut(true);
          service.setRemoveOnCancelPolicy(true);
          return service;
        }

        @Override
        public void close(ScheduledExecutorService instance) {
          instance.shutdown();
        }
      };

  /**
   * An interface for {@link ExecutorService} factories. Implementations of this interface can be
   * used to provide an user-defined executor to execute requests. Any implementation of this
   * interface must override the {@code get()} method to return the desired executor. The {@code
   * release(executor)} method should be overriden to free resources used by the executor (if
   * needed) according to application's logic.
   *
   * <p>Implementation must provide a public no-arg constructor. Loading of a factory implementation
   * is done via {@link java.util.ServiceLoader}.
   *
   * @param <T> the {@link ExecutorService} subclass created by this factory
   */
  public interface ExecutorFactory<T extends ExecutorService> {

    /** Gets an executor service instance. */
    T get();

    /** Releases resources used by the executor and possibly shuts it down. */
    void release(T executor);
  }

  @InternalApi
  public static class DefaultExecutorFactory implements ExecutorFactory<ScheduledExecutorService> {

    private static final DefaultExecutorFactory INSTANCE = new DefaultExecutorFactory();

    @Override
    public ScheduledExecutorService get() {
      return SharedResourceHolder.get(EXECUTOR);
    }

    @Override
    public synchronized void release(ScheduledExecutorService executor) {
      SharedResourceHolder.release(EXECUTOR, executor);
    }
  }

  /** Builder for {@code GrpcTransportOptions}. */
  public static class Builder {

    private ExecutorFactory executorFactory;

    private Builder() {}

    private Builder(GrpcTransportOptions options) {
      executorFactory = options.executorFactory;
    }

    public GrpcTransportOptions build() {
      return new GrpcTransportOptions(this);
    }

    /**
     * Sets the scheduled executor factory. This method can be used to provide an user-defined
     * scheduled executor to execute requests.
     *
     * @return the builder
     */
    public Builder setExecutorFactory(ExecutorFactory<ScheduledExecutorService> executorFactory) {
      this.executorFactory = executorFactory;
      return this;
    }
  }

  @SuppressWarnings("unchecked")
  private GrpcTransportOptions(Builder builder) {
    executorFactory =
        firstNonNull(
            builder.executorFactory,
            ServiceOptions.getFromServiceLoader(
                ExecutorFactory.class, DefaultExecutorFactory.INSTANCE));
    executorFactoryClassName = executorFactory.getClass().getName();
  }

  /** Returns a scheduled executor service provider. */
  public ExecutorFactory<ScheduledExecutorService> getExecutorFactory() {
    return executorFactory;
  }

  /** Returns a builder for API call settings. */
  @Deprecated
  public UnaryCallSettings.Builder getApiCallSettings(RetrySettings retrySettings) {
    return UnaryCallSettings.newUnaryCallSettingsBuilder().setRetrySettings(retrySettings);
  }

  /** Returns a channel provider from the given default provider. */
  @BetaApi
  public static TransportChannelProvider setUpChannelProvider(
      InstantiatingGrpcChannelProvider.Builder providerBuilder,
      ServiceOptions<?, ?> serviceOptions) {
    providerBuilder.setEndpoint(serviceOptions.getHost());
    return providerBuilder.build();
  }

  public static CredentialsProvider setUpCredentialsProvider(ServiceOptions<?, ?> serviceOptions) {
    Credentials scopedCredentials = serviceOptions.getScopedCredentials();
    if (scopedCredentials != null && scopedCredentials != NoCredentials.getInstance()) {
      return FixedCredentialsProvider.create(scopedCredentials);
    }
    return NoCredentialsProvider.create();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(executorFactoryClassName);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    GrpcTransportOptions other = (GrpcTransportOptions) obj;
    return Objects.equals(executorFactoryClassName, other.executorFactoryClassName);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    executorFactory = ServiceOptions.newInstance(executorFactoryClassName);
  }

  public static Builder newBuilder() {
    return new Builder();
  }
}
