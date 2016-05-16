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

import com.google.cloud.spi.ServiceRpcFactory;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

import io.grpc.internal.SharedResourceHolder;
import io.grpc.internal.SharedResourceHolder.Resource;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Abstract class representing service options for those services that use gRPC as the transport
 * layer.
 *
 * @param <ServiceT> the service subclass
 * @param <ServiceRpcT> the spi-layer class corresponding to the service
 * @param <OptionsT> the {@code ServiceOptions} subclass corresponding to the service
 */
public abstract class GrpcServiceOptions<ServiceT extends Service<OptionsT>, ServiceRpcT,
    OptionsT extends GrpcServiceOptions<ServiceT, ServiceRpcT, OptionsT>>
    extends ServiceOptions<ServiceT, ServiceRpcT, OptionsT> {

  private static final long serialVersionUID = 6415982522610509549L;
  private final String executorFactoryClassName;
  private final int initialTimeout;
  private final double timeoutMultiplier;
  private final int maxTimeout;

  private transient ExecutorFactory executorFactory;

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
   * An interface for {@link ScheduledExecutorService} factories. Implementations of this interface
   * can be used to provide an user-defined scheduled executor to execute requests. Any
   * implementation of this interface must override the {@code get()} method to return the desired
   * executor. The {@code release(executor)} method should be overriden to free resources used by
   * the executor (if needed) according to application's logic.
   *
   * <p>Implementation must provide a public no-arg constructor. Loading of a factory implementation
   * is done via {@link java.util.ServiceLoader}.
   */
  public interface ExecutorFactory {

    /**
     * Gets a scheduled executor service instance.
     */
    ScheduledExecutorService get();

    /**
     * Releases resources used by the executor and possibly shuts it down.
     */
    void release(ScheduledExecutorService executor);
  }

  @VisibleForTesting
  static class DefaultExecutorFactory implements ExecutorFactory {

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
   * Builder for {@code GrpcServiceOptions}.
   *
   * @param <ServiceT> the service subclass
   * @param <ServiceRpcT> the spi-layer class corresponding to the service
   * @param <OptionsT> the {@code GrpcServiceOptions} subclass corresponding to the service
   * @param <B> the {@code ServiceOptions} builder
   */
  protected abstract static class Builder<ServiceT extends Service<OptionsT>, ServiceRpcT,
      OptionsT extends GrpcServiceOptions<ServiceT, ServiceRpcT, OptionsT>,
      B extends Builder<ServiceT, ServiceRpcT, OptionsT, B>>
      extends ServiceOptions.Builder<ServiceT, ServiceRpcT, OptionsT, B> {

    private ExecutorFactory executorFactory;
    private int initialTimeout = 20_000;
    private double timeoutMultiplier = 1.5;
    private int maxTimeout = 100_000;

    protected Builder() {}

    protected Builder(GrpcServiceOptions<ServiceT, ServiceRpcT, OptionsT> options) {
      super(options);
      executorFactory = options.executorFactory;
      initialTimeout = options.initialTimeout;
      timeoutMultiplier = options.timeoutMultiplier;
      maxTimeout = options.maxTimeout;
    }

    @Override
    protected abstract GrpcServiceOptions<ServiceT, ServiceRpcT, OptionsT> build();

    /**
     * Sets the scheduled executor factory. This method can be used to provide an user-defined
     * scheduled executor to execute requests.
     *
     * @return the builder
     */
    public B executorFactory(ExecutorFactory executorFactory) {
      this.executorFactory = executorFactory;
      return self();
    }

    /**
     * Sets the timeout for the initial RPC, in milliseconds. Subsequent calls will use this value
     * adjusted according to {@link #timeoutMultiplier(double)}. Default value is 20000.
     *
     * @throws IllegalArgumentException if the provided timeout is &lt; 0
     * @return the builder
     */
    public B initialTimeout(int initialTimeout) {
      Preconditions.checkArgument(initialTimeout > 0, "Initial timeout must be > 0");
      this.initialTimeout = initialTimeout;
      return self();
    }

    /**
     * Sets the timeout multiplier. This value is used to compute the timeout for a retried RPC.
     * Timeout is computed as {@code timeoutMultiplier * previousTimeout}. Default value is 1.5.
     *
     * @throws IllegalArgumentException if the provided timeout multiplier is &lt; 0
     * @return the builder
     */
    public B timeoutMultiplier(double timeoutMultiplier) {
      Preconditions.checkArgument(timeoutMultiplier >= 1.0, "Timeout multiplier must be >= 1");
      this.timeoutMultiplier = timeoutMultiplier;
      return self();
    }

    /**
     * Sets the maximum timeout for a RPC call, in milliseconds. Default value is 100000. If
     * {@code maxTimeout} is lower than the initial timeout the {@link #initialTimeout(int)} value
     * is used instead.
     *
     * @return the builder
     */
    public B maxTimeout(int maxTimeout) {
      this.maxTimeout = maxTimeout;
      return self();
    }
  }

  protected GrpcServiceOptions(
      Class<? extends ServiceFactory<ServiceT, OptionsT>> serviceFactoryClass,
      Class<? extends ServiceRpcFactory<ServiceRpcT, OptionsT>> rpcFactoryClass, Builder<ServiceT,
      ServiceRpcT, OptionsT, ?> builder) {
    super(serviceFactoryClass, rpcFactoryClass, builder);
    executorFactory = firstNonNull(builder.executorFactory,
        getFromServiceLoader(ExecutorFactory.class, DefaultExecutorFactory.INSTANCE));
    executorFactoryClassName = executorFactory.getClass().getName();
    initialTimeout = builder.initialTimeout;
    timeoutMultiplier = builder.timeoutMultiplier;
    maxTimeout = builder.maxTimeout <= initialTimeout ? initialTimeout : builder.maxTimeout;
  }

  /**
   * Returns a scheduled executor service provider.
   */
  protected ExecutorFactory executorFactory() {
    return executorFactory;
  }

  /**
   * Returns the timeout for the initial RPC, in milliseconds. Subsequent calls will use this value
   * adjusted according to {@link #timeoutMultiplier()}. Default value is 20000.
   */
  public int initialTimeout() {
    return initialTimeout;
  }

  /**
   * Returns the timeout multiplier. This values is used to compute the timeout for a RPC. Timeout
   * is computed as {@code timeoutMultiplier * previousTimeout}. Default value is 1.5.
   */
  public double timeoutMultiplier() {
    return timeoutMultiplier;
  }

  /**
   * Returns the maximum timeout for a RPC call, in milliseconds. Default value is 100000.
   */
  public int maxTimeout() {
    return maxTimeout;
  }

  @Override
  protected int baseHashCode() {
    return Objects.hash(super.baseHashCode(), executorFactoryClassName, initialTimeout,
        timeoutMultiplier, maxTimeout);
  }

  protected boolean baseEquals(GrpcServiceOptions<?, ?, ?> other) {
    return super.baseEquals(other)
        && Objects.equals(executorFactoryClassName, other.executorFactoryClassName)
        && Objects.equals(initialTimeout, other.initialTimeout)
        && Objects.equals(timeoutMultiplier, other.timeoutMultiplier)
        && Objects.equals(maxTimeout, other.maxTimeout);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    executorFactory = newInstance(executorFactoryClassName);
  }
}
