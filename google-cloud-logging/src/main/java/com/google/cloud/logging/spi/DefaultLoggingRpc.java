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

package com.google.cloud.logging.spi;

import static com.google.common.base.MoreObjects.firstNonNull;

import com.google.api.gax.core.ConnectionSettings;
import com.google.api.gax.grpc.ApiException;
import com.google.api.gax.grpc.UnaryCallSettings;
import com.google.cloud.GrpcServiceOptions.ExecutorFactory;
import com.google.cloud.logging.LoggingException;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.spi.v2.ConfigServiceV2Api;
import com.google.cloud.logging.spi.v2.ConfigServiceV2Settings;
import com.google.cloud.logging.spi.v2.LoggingServiceV2Api;
import com.google.cloud.logging.spi.v2.LoggingServiceV2Settings;
import com.google.cloud.logging.spi.v2.MetricsServiceV2Api;
import com.google.cloud.logging.spi.v2.MetricsServiceV2Settings;
import com.google.common.base.Function;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.logging.v2.CreateLogMetricRequest;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.DeleteLogMetricRequest;
import com.google.logging.v2.DeleteLogRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.GetLogMetricRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.ListLogEntriesRequest;
import com.google.logging.v2.ListLogEntriesResponse;
import com.google.logging.v2.ListLogMetricsRequest;
import com.google.logging.v2.ListLogMetricsResponse;
import com.google.logging.v2.ListMonitoredResourceDescriptorsRequest;
import com.google.logging.v2.ListMonitoredResourceDescriptorsResponse;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.LogMetric;
import com.google.logging.v2.LogSink;
import com.google.logging.v2.UpdateLogMetricRequest;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.logging.v2.WriteLogEntriesRequest;
import com.google.logging.v2.WriteLogEntriesResponse;
import com.google.protobuf.Empty;

import io.grpc.ManagedChannel;
import io.grpc.Status.Code;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public class DefaultLoggingRpc implements LoggingRpc {

  private final ConfigServiceV2Api configApi;
  private final LoggingServiceV2Api loggingApi;
  private final MetricsServiceV2Api metricsApi;
  private final ScheduledExecutorService executor;
  private final ExecutorFactory<ScheduledExecutorService> executorFactory;

  private boolean closed;

  private static final class InternalLoggingOptions extends LoggingOptions {

    private static final long serialVersionUID = -2107638980310672033L;

    private InternalLoggingOptions(LoggingOptions options) {
      super(options.toBuilder());
    }

    @Override
    protected ExecutorFactory<ScheduledExecutorService> getExecutorFactory() {
      return super.getExecutorFactory();
    }

    @Override
    protected UnaryCallSettings.Builder getApiCallSettings() {
      return super.getApiCallSettings();
    }

    @Override
    protected ConnectionSettings.Builder getConnectionSettings() {
      return super.getConnectionSettings();
    }
  }

  public DefaultLoggingRpc(LoggingOptions options) throws IOException {
    InternalLoggingOptions internalOptions = new InternalLoggingOptions(options);
    executorFactory = internalOptions.getExecutorFactory();
    executor = executorFactory.get();
    String libraryName = options.getLibraryName();
    String libraryVersion = firstNonNull(options.getLibraryVersion(), "");
    try {
      ConfigServiceV2Settings.Builder confBuilder = ConfigServiceV2Settings.defaultBuilder()
          .provideExecutorWith(executor, false)
          .setClientLibHeader(libraryName, libraryVersion);
      LoggingServiceV2Settings.Builder logBuilder = LoggingServiceV2Settings.defaultBuilder()
          .provideExecutorWith(executor, false)
          .setClientLibHeader(libraryName, libraryVersion);
      MetricsServiceV2Settings.Builder metricsBuilder = MetricsServiceV2Settings.defaultBuilder()
          .provideExecutorWith(executor, false)
          .setClientLibHeader(libraryName, libraryVersion);
      // todo(mziccard): PublisherSettings should support null/absent credentials for testing
      if (options.getHost().contains("localhost") || options.getCredentials() == null) {
        ManagedChannel channel = NettyChannelBuilder.forTarget(options.getHost())
            .negotiationType(NegotiationType.PLAINTEXT)
            .build();
        confBuilder.provideChannelWith(channel, true);
        logBuilder.provideChannelWith(channel, true);
        metricsBuilder.provideChannelWith(channel, true);
      } else {
        ConnectionSettings connectionSettings = internalOptions.getConnectionSettings().build();
        confBuilder.provideChannelWith(connectionSettings);
        logBuilder.provideChannelWith(connectionSettings);
        metricsBuilder.provideChannelWith(connectionSettings);
      }
      UnaryCallSettings.Builder callSettingsBuilder = internalOptions.getApiCallSettings();
      confBuilder.applyToAllApiMethods(callSettingsBuilder);
      logBuilder.applyToAllApiMethods(callSettingsBuilder);
      metricsBuilder.applyToAllApiMethods(callSettingsBuilder);
      configApi = ConfigServiceV2Api.create(confBuilder.build());
      loggingApi = LoggingServiceV2Api.create(logBuilder.build());
      metricsApi = MetricsServiceV2Api.create(metricsBuilder.build());
    } catch (Exception ex) {
      throw new IOException(ex);
    }
  }

  private static <V> Future<V> translate(ListenableFuture<V> from, final boolean idempotent,
      int... returnNullOn) {
    final Set<Integer> returnNullOnSet = Sets.newHashSetWithExpectedSize(returnNullOn.length);
    for (int value : returnNullOn) {
      returnNullOnSet.add(value);
    }
    return Futures.catching(from, ApiException.class, new Function<ApiException, V>() {
      @Override
      public V apply(ApiException exception) {
        if (returnNullOnSet.contains(exception.getStatusCode().value())) {
          return null;
        }
        throw new LoggingException(exception, idempotent);
      }
    });
  }

  @Override
  public Future<LogSink> create(CreateSinkRequest request) {
    return translate(configApi.createSinkCallable().futureCall(request), true);
  }

  @Override
  public Future<LogSink> update(UpdateSinkRequest request) {
    return translate(configApi.updateSinkCallable().futureCall(request), true);
  }

  @Override
  public Future<LogSink> get(GetSinkRequest request) {
    return translate(configApi.getSinkCallable().futureCall(request), true, Code.NOT_FOUND.value());
  }

  @Override
  public Future<ListSinksResponse> list(ListSinksRequest request) {
    return translate(configApi.listSinksCallable().futureCall(request), true);
  }

  @Override
  public Future<Empty> delete(DeleteSinkRequest request) {
    return translate(configApi.deleteSinkCallable().futureCall(request), true,
        Code.NOT_FOUND.value());
  }

  @Override
  public Future<Empty> delete(DeleteLogRequest request) {
    return translate(loggingApi.deleteLogCallable().futureCall(request), true,
        Code.NOT_FOUND.value());
  }

  @Override
  public Future<WriteLogEntriesResponse> write(WriteLogEntriesRequest request) {
    return translate(loggingApi.writeLogEntriesCallable().futureCall(request), false);
  }

  @Override
  public Future<ListLogEntriesResponse> list(ListLogEntriesRequest request) {
    return translate(loggingApi.listLogEntriesCallable().futureCall(request), true);
  }

  @Override
  public Future<ListMonitoredResourceDescriptorsResponse> list(
      ListMonitoredResourceDescriptorsRequest request) {
    return translate(loggingApi.listMonitoredResourceDescriptorsCallable().futureCall(request),
        true);
  }

  @Override
  public Future<LogMetric> create(CreateLogMetricRequest request) {
    return translate(metricsApi.createLogMetricCallable().futureCall(request), true);
  }

  @Override
  public Future<LogMetric> update(UpdateLogMetricRequest request) {
    return translate(metricsApi.updateLogMetricCallable().futureCall(request), true);
  }

  @Override
  public Future<LogMetric> get(GetLogMetricRequest request) {
    return translate(metricsApi.getLogMetricCallable().futureCall(request), true,
        Code.NOT_FOUND.value());
  }

  @Override
  public Future<ListLogMetricsResponse> list(ListLogMetricsRequest request) {
    return translate(metricsApi.listLogMetricsCallable().futureCall(request), true);
  }

  @Override
  public Future<Empty> delete(DeleteLogMetricRequest request) {
    return translate(metricsApi.deleteLogMetricCallable().futureCall(request), true,
        Code.NOT_FOUND.value());
  }

  @Override
  public void close() throws Exception {
    if (closed) {
      return;
    }
    closed = true;
    configApi.close();
    loggingApi.close();
    metricsApi.close();
    executorFactory.release(executor);
  }
}
