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

import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.FixedExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceFactory;
import com.google.cloud.storage.it.GrpcPlainRequestLoggingInterceptor;
import com.google.cloud.storage.it.runner.registry.Registry;
import com.google.storage.v2.StorageClient;
import com.google.storage.v2.StorageGrpc;
import com.google.storage.v2.StorageSettings;
import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.time.Duration;
import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class FakeServer implements AutoCloseable {

  private final Server server;
  private final GrpcStorageOptions grpcStorageOptions;
  private final ScheduledThreadPoolExecutor executor;

  FakeServer(Server server, GrpcStorageOptions grpcStorageOptions, ScheduledThreadPoolExecutor executor) {
    this.server = server;
    this.grpcStorageOptions = grpcStorageOptions;
    this.executor = executor;
  }

  GrpcStorageOptions getGrpcStorageOptions() {
    return grpcStorageOptions;
  }

  StorageSettings storageSettings() throws IOException {
    StorageSettings settings = grpcStorageOptions.getStorageSettings();
    if (executor != null) {
      ExecutorProvider executorProvider = FixedExecutorProvider.create(executor);
      StorageSettings.Builder builder = settings.toBuilder()
          .setBackgroundExecutorProvider(executorProvider);
      if (builder.getTransportChannelProvider() instanceof InstantiatingGrpcChannelProvider) {
        builder.setTransportChannelProvider(
            ((InstantiatingGrpcChannelProvider) builder.getTransportChannelProvider())
                .toBuilder()
                .setExecutorProvider(executorProvider)
                .build());
      }
      return builder.build();
    }
    return settings;
  }

  @Override
  public void close() throws InterruptedException {
    try {
      server.shutdownNow().awaitTermination(10, TimeUnit.SECONDS);
    } finally {
      if (executor != null) {
        executor.shutdownNow();
      }
    }
  }

  static void injectIsolatedClient(Storage storage, ScheduledThreadPoolExecutor executor) {
    Storage delegate = storage;
    if (storage instanceof OtelStorageDecorator) {
      try {
        java.lang.reflect.Field delegateField = OtelStorageDecorator.class.getDeclaredField("delegate");
        delegateField.setAccessible(true);
        delegate = (Storage) delegateField.get(storage);
      } catch (Exception e) {
        throw new RuntimeException("Failed to unwrap OtelStorageDecorator", e);
      }
    }
    if (delegate instanceof GrpcStorageImpl) {
      GrpcStorageImpl impl = (GrpcStorageImpl) delegate;
      try {
        StorageSettings settings = impl.getOptions().getStorageSettings();
        ExecutorProvider executorProvider = FixedExecutorProvider.create(executor);
        StorageSettings.Builder settingsBuilder = settings.toBuilder()
            .setBackgroundExecutorProvider(executorProvider);
        if (settingsBuilder.getTransportChannelProvider() instanceof InstantiatingGrpcChannelProvider) {
          settingsBuilder.setTransportChannelProvider(
              ((InstantiatingGrpcChannelProvider) settingsBuilder.getTransportChannelProvider())
                  .toBuilder()
                  .setExecutorProvider(executorProvider)
                  .build());
        }
        StorageSettings isolatedSettings = settingsBuilder.build();
        StorageClient isolatedClient = StorageClient.create(isolatedSettings);

        java.lang.reflect.Field clientField = GrpcStorageImpl.class.getDeclaredField("storageClient");
        clientField.setAccessible(true);
        clientField.set(impl, isolatedClient);
      } catch (Exception e) {
        throw new RuntimeException("Failed to inject isolated StorageClient", e);
      }
    }
  }

  static FakeServer of(StorageGrpc.StorageImplBase service) throws IOException {
    InetSocketAddress address = new InetSocketAddress("127.0.0.1", 0);
    ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(4);
    executor.setKeepAliveTime(10, TimeUnit.SECONDS);
    executor.allowCoreThreadTimeOut(true);
    Server server = NettyServerBuilder.forAddress(address).addService(service).executor(executor).build();
    server.start();
    String endpoint = String.format(Locale.US, "%s:%d", address.getHostString(), server.getPort());
    GrpcStorageOptions grpcStorageOptions =
        StorageOptions.grpc()
            .setHost("http://" + endpoint)
            .setProjectId("test-proj")
            .setCredentials(NoCredentials.getInstance())
            .setGrpcInterceptorProvider(GrpcPlainRequestLoggingInterceptor.getInterceptorProvider())
            .setEnableGrpcClientMetrics(false)
            .setAttemptDirectPath(false)
            .setOpenTelemetry(Registry.getInstance().otelSdk.get().get())
            .setServiceFactory(
                new ServiceFactory<Storage, StorageOptions>() {
                  @Override
                  @SuppressWarnings("deprecation")
                  public Storage create(StorageOptions opts) {
                    Storage storage = new GrpcStorageOptions.GrpcStorageFactory().create(opts);
                    injectIsolatedClient(storage, executor);
                    return storage;
                  }
                })
            // cut most retry settings by half. we're hitting an in process server.
            .setRetrySettings(
                RetrySettings.newBuilder()
                    .setTotalTimeoutDuration(Duration.ofSeconds(25))
                    .setInitialRetryDelayDuration(Duration.ofMillis(250))
                    .setRetryDelayMultiplier(1.2)
                    .setMaxRetryDelayDuration(Duration.ofSeconds(16))
                    .setMaxAttempts(6)
                    .setInitialRpcTimeoutDuration(Duration.ofSeconds(1))
                    .setRpcTimeoutMultiplier(1.0)
                    .setMaxRpcTimeoutDuration(Duration.ofSeconds(25))
                    .build())
            .build();
    return new FakeServer(server, grpcStorageOptions, executor);
  }
}
