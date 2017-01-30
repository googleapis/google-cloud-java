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

import com.google.api.gax.core.Function;
import com.google.api.gax.core.RpcFuture;
import com.google.api.gax.grpc.ApiException;
import com.google.api.gax.grpc.ChannelProvider;
import com.google.api.gax.grpc.ExecutorProvider;
import com.google.api.gax.grpc.FixedChannelProvider;
import com.google.api.gax.grpc.FixedExecutorProvider;
import com.google.api.gax.grpc.ProviderManager;
import com.google.api.gax.grpc.UnaryCallSettings;
import com.google.cloud.GrpcServiceOptions.ExecutorFactory;
import com.google.cloud.NoCredentials;
import com.google.cloud.logging.LoggingException;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.spi.v2.ConfigServiceV2Client;
import com.google.cloud.logging.spi.v2.ConfigServiceV2Settings;
import com.google.cloud.logging.spi.v2.LoggingServiceV2Client;
import com.google.cloud.logging.spi.v2.LoggingServiceV2Settings;
import com.google.cloud.logging.spi.v2.MetricsServiceV2Client;
import com.google.cloud.logging.spi.v2.MetricsServiceV2Settings;
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
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public class DefaultLoggingRpc implements LoggingRpc {

  private final ConfigServiceV2Client configClient;
  private final LoggingServiceV2Client loggingClient;
  private final MetricsServiceV2Client metricsClient;
  private final ScheduledExecutorService executor;
  private final ProviderManager providerManager;
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
    protected ChannelProvider getChannelProvider() {
      return super.getChannelProvider();
    }
  }

  public DefaultLoggingRpc(LoggingOptions options) throws IOException {
    InternalLoggingOptions internalOptions = new InternalLoggingOptions(options);
    executorFactory = internalOptions.getExecutorFactory();
    executor = executorFactory.get();
    try {
      ExecutorProvider executorProvider = FixedExecutorProvider.create(executor);
      ChannelProvider channelProvider;
      // todo(mziccard): ChannelProvider should support null/absent credentials for testing
      if (options.getHost().contains("localhost")
          || options.getCredentials().equals(NoCredentials.getInstance())) {
        ManagedChannel managedChannel = NettyChannelBuilder.forTarget(options.getHost())
            .negotiationType(NegotiationType.PLAINTEXT)
            .executor(executor)
            .build();
        channelProvider = FixedChannelProvider.create(managedChannel);
      } else {
        channelProvider = internalOptions.getChannelProvider();
      }
      providerManager = ProviderManager.newBuilder()
          .setChannelProvider(channelProvider)
          .setExecutorProvider(executorProvider)
          .build();
      UnaryCallSettings.Builder callSettingsBuilder = internalOptions.getApiCallSettings();
      ConfigServiceV2Settings.Builder confBuilder = ConfigServiceV2Settings.defaultBuilder()
          .setExecutorProvider(providerManager)
          .setChannelProvider(providerManager)
          .applyToAllUnaryMethods(callSettingsBuilder);
      LoggingServiceV2Settings.Builder logBuilder = LoggingServiceV2Settings.defaultBuilder()
          .setExecutorProvider(providerManager)
          .setChannelProvider(providerManager)
          .applyToAllUnaryMethods(callSettingsBuilder);
      MetricsServiceV2Settings.Builder metricsBuilder = MetricsServiceV2Settings.defaultBuilder()
          .setExecutorProvider(providerManager)
          .setChannelProvider(providerManager)
          .applyToAllUnaryMethods(callSettingsBuilder);
      configClient = ConfigServiceV2Client.create(confBuilder.build());
      loggingClient = LoggingServiceV2Client.create(logBuilder.build());
      metricsClient = MetricsServiceV2Client.create(metricsBuilder.build());
    } catch (Exception ex) {
      throw new IOException(ex);
    }
  }

  private static <V> Future<V> translate(
      RpcFuture<V> from, final boolean idempotent, Code... returnNullOn) {
    final Set<Code> returnNullOnSet;
    if (returnNullOn.length > 0) {
      returnNullOnSet = EnumSet.of(returnNullOn[0], returnNullOn);
    } else {
      returnNullOnSet = Collections.<Code>emptySet();
    }
    return from.catching(
        ApiException.class,
        new Function<ApiException, V>() {
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
    return translate(configClient.createSinkCallable().futureCall(request), true);
  }

  @Override
  public Future<LogSink> update(UpdateSinkRequest request) {
    return translate(configClient.updateSinkCallable().futureCall(request), true);
  }

  @Override
  public Future<LogSink> get(GetSinkRequest request) {
    return translate(configClient.getSinkCallable().futureCall(request), true, Code.NOT_FOUND);
  }

  @Override
  public Future<ListSinksResponse> list(ListSinksRequest request) {
    return translate(configClient.listSinksCallable().futureCall(request), true);
  }

  @Override
  public Future<Empty> delete(DeleteSinkRequest request) {
    return translate(configClient.deleteSinkCallable().futureCall(request), true, Code.NOT_FOUND);
  }

  @Override
  public Future<Empty> delete(DeleteLogRequest request) {
    return translate(loggingClient.deleteLogCallable().futureCall(request), true, Code.NOT_FOUND);
  }

  @Override
  public Future<WriteLogEntriesResponse> write(WriteLogEntriesRequest request) {
    return translate(loggingClient.writeLogEntriesCallable().futureCall(request), false);
  }

  @Override
  public Future<ListLogEntriesResponse> list(ListLogEntriesRequest request) {
    return translate(loggingClient.listLogEntriesCallable().futureCall(request), true);
  }

  @Override
  public Future<ListMonitoredResourceDescriptorsResponse> list(
      ListMonitoredResourceDescriptorsRequest request) {
    return translate(loggingClient.listMonitoredResourceDescriptorsCallable().futureCall(request),
        true);
  }

  @Override
  public Future<LogMetric> create(CreateLogMetricRequest request) {
    return translate(metricsClient.createLogMetricCallable().futureCall(request), true);
  }

  @Override
  public Future<LogMetric> update(UpdateLogMetricRequest request) {
    return translate(metricsClient.updateLogMetricCallable().futureCall(request), true);
  }

  @Override
  public Future<LogMetric> get(GetLogMetricRequest request) {
    return translate(
        metricsClient.getLogMetricCallable().futureCall(request), true, Code.NOT_FOUND);
  }

  @Override
  public Future<ListLogMetricsResponse> list(ListLogMetricsRequest request) {
    return translate(metricsClient.listLogMetricsCallable().futureCall(request), true);
  }

  @Override
  public Future<Empty> delete(DeleteLogMetricRequest request) {
    return translate(
        metricsClient.deleteLogMetricCallable().futureCall(request), true, Code.NOT_FOUND);
  }

  @Override
  public void close() throws Exception {
    if (closed) {
      return;
    }
    closed = true;
    configClient.close();
    loggingClient.close();
    metricsClient.close();
    providerManager.getChannel().shutdown();
    executorFactory.release(executor);
  }
}
