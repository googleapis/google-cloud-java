/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud;

import static com.google.common.base.MoreObjects.firstNonNull;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.core.RetrySettings;
import com.google.api.gax.grpc.ChannelProvider;
import com.google.api.gax.grpc.InstantiatingChannelProvider;
import com.google.api.gax.grpc.UnaryCallSettings;
import com.google.auth.Credentials;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.net.HostAndPort;
import io.grpc.internal.SharedResourceHolder;
import io.grpc.internal.SharedResourceHolder.Resource;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Class representing service options for those services that use gRPC as the transport
 * layer.
 */
public class GrpcTransportOptions implements TransportOptions {

  private static final long serialVersionUID = -9049538465533951165L;
  private final String executorFactoryClassName;
  private final int initialTimeout;
  private final double timeoutMultiplier;
  private final int maxTimeout;

  private transient ExecutorFactory<ScheduledExecutorService> executorFactory;

  /**
   * Shared thread pool executor.
   */
  private static final Resource<ScheduledExecutorService> EXECUTOR =
      new Resource<ScheduledExecutorService>() {
        @Override
        public ScheduledExecutorService create() {
          ScheduledThreadPoolExecutor service = new ScheduledThreadPoolExecutor(8);
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
   * interface must override the {@code get()} method to return the desired executor. The
   * {@code release(executor)} method should be overriden to free resources used by the executor (if
   * needed) according to application's logic.
   *
   * <p>Implementation must provide a public no-arg constructor. Loading of a factory implementation
   * is done via {@link java.util.ServiceLoader}.
   *
   * @param <T> the {@link ExecutorService} subclass created by this factory
   */
  public interface ExecutorFactory<T extends ExecutorService> {

    /**
     * Gets an executor service instance.
     */
    T get();

    /**
     * Releases resources used by the executor and possibly shuts it down.
     */
    void release(T executor);
  }

  @VisibleForTesting
  static class DefaultExecutorFactory implements ExecutorFactory<ScheduledExecutorService> {

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

  /**
   * Builder for {@code GrpcTransportOptions}.
   */
  public static class Builder {

    private ExecutorFactory executorFactory;
    private int initialTimeout = 20_000;
    private double timeoutMultiplier = 1.5;
    private int maxTimeout = 100_000;

    private Builder() {}

    private Builder(GrpcTransportOptions options) {
      executorFactory = options.executorFactory;
      initialTimeout = options.initialTimeout;
      timeoutMultiplier = options.timeoutMultiplier;
      maxTimeout = options.maxTimeout;
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

    /**
     * Sets the timeout for the initial RPC, in milliseconds. Subsequent calls will use this value
     * adjusted according to {@link #setTimeoutMultiplier(double)}. Default value is 20000.
     *
     * @return the builder
     * @throws IllegalArgumentException if the provided timeout is &lt; 0
     */
    public Builder setInitialTimeout(int initialTimeout) {
      Preconditions.checkArgument(initialTimeout > 0, "Initial timeout must be > 0");
      this.initialTimeout = initialTimeout;
      return this;
    }

    /**
     * Sets the timeout multiplier. This value is used to compute the timeout for a retried RPC.
     * Timeout is computed as {@code timeoutMultiplier * previousTimeout}. Default value is 1.5.
     *
     * @return the builder
     * @throws IllegalArgumentException if the provided timeout multiplier is &lt; 0
     */
    public Builder setTimeoutMultiplier(double timeoutMultiplier) {
      Preconditions.checkArgument(timeoutMultiplier >= 1.0, "Timeout multiplier must be >= 1");
      this.timeoutMultiplier = timeoutMultiplier;
      return this;
    }

    /**
     * Sets the maximum timeout for a RPC call, in milliseconds. Default value is 100000. If
     * {@code maxTimeout} is lower than the initial timeout the {@link #setInitialTimeout(int)}
     * value is used instead.
     *
     * @return the builder
     */
    public Builder setMaxTimeout(int maxTimeout) {
      this.maxTimeout = maxTimeout;
      return this;
    }
  }

  @SuppressWarnings("unchecked")
  private GrpcTransportOptions(Builder builder) {
    executorFactory = firstNonNull(builder.executorFactory,
        ServiceOptions.getFromServiceLoader(ExecutorFactory.class, DefaultExecutorFactory.INSTANCE));
    executorFactoryClassName = executorFactory.getClass().getName();
    initialTimeout = builder.initialTimeout;
    timeoutMultiplier = builder.timeoutMultiplier;
    maxTimeout = builder.maxTimeout <= initialTimeout ? initialTimeout : builder.maxTimeout;
  }

  /**
   * Returns a scheduled executor service provider.
   */
  public ExecutorFactory<ScheduledExecutorService> getExecutorFactory() {
    return executorFactory;
  }

  /**
   * Returns a builder for API call settings.
   */
  public UnaryCallSettings.Builder getApiCallSettings(RetrySettings retrySettings) {
    return UnaryCallSettings.newBuilder().setRetrySettingsBuilder(retrySettings.toBuilder());
  }

  /**
   * Returns a channel provider from the given default provider.
   */
  public static ChannelProvider setUpChannelProvider(
      InstantiatingChannelProvider.Builder providerBuilder, ServiceOptions<?, ?> serviceOptions) {
    providerBuilder.setEndpoint(serviceOptions.getHost())
        .setClientLibHeader(ServiceOptions.getGoogApiClientLibName(),
            firstNonNull(ServiceOptions.getLibraryVersion(), ""));
    Credentials scopedCredentials = serviceOptions.getScopedCredentials();
    if (scopedCredentials != null && scopedCredentials != NoCredentials.getInstance()) {
      providerBuilder.setCredentialsProvider(FixedCredentialsProvider.create(scopedCredentials));
    }
    return providerBuilder.build();
  }


  /**
   * Returns the timeout for the initial RPC, in milliseconds. Subsequent calls will use this value
   * adjusted according to {@link #getTimeoutMultiplier()}. Default value is 20000.
   */
  public int getInitialTimeout() {
    return initialTimeout;
  }

  /**
   * Returns the timeout multiplier. This values is used to compute the timeout for a RPC. Timeout
   * is computed as {@code timeoutMultiplier * previousTimeout}. Default value is 1.5.
   */
  public double getTimeoutMultiplier() {
    return timeoutMultiplier;
  }

  /**
   * Returns the maximum timeout for a RPC call, in milliseconds. Default value is 100000.
   */
  public int getMaxTimeout() {
    return maxTimeout;
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(executorFactoryClassName, initialTimeout,
        timeoutMultiplier, maxTimeout);
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
    return Objects.equals(executorFactoryClassName, other.executorFactoryClassName)
        && Objects.equals(initialTimeout, other.initialTimeout)
        && Objects.equals(timeoutMultiplier, other.timeoutMultiplier)
        && Objects.equals(maxTimeout, other.maxTimeout);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    executorFactory = ServiceOptions.newInstance(executorFactoryClassName);
  }

  public static Builder newBuilder() {
    return new Builder();
  }
}
