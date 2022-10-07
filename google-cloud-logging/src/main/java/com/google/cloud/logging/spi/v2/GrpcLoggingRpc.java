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

package com.google.cloud.logging.spi.v2;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.batching.FlowController.LimitExceededBehavior;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.BidiStream;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.TransportChannel;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.grpc.GrpcTransportOptions.ExecutorFactory;
import com.google.cloud.logging.LoggingException;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.v2.ConfigClient;
import com.google.cloud.logging.v2.ConfigSettings;
import com.google.cloud.logging.v2.LoggingClient;
import com.google.cloud.logging.v2.LoggingSettings;
import com.google.cloud.logging.v2.MetricsClient;
import com.google.cloud.logging.v2.MetricsSettings;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.logging.v2.CreateExclusionRequest;
import com.google.logging.v2.CreateLogMetricRequest;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.DeleteExclusionRequest;
import com.google.logging.v2.DeleteLogMetricRequest;
import com.google.logging.v2.DeleteLogRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.GetExclusionRequest;
import com.google.logging.v2.GetLogMetricRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.ListExclusionsRequest;
import com.google.logging.v2.ListExclusionsResponse;
import com.google.logging.v2.ListLogEntriesRequest;
import com.google.logging.v2.ListLogEntriesResponse;
import com.google.logging.v2.ListLogMetricsRequest;
import com.google.logging.v2.ListLogMetricsResponse;
import com.google.logging.v2.ListLogsRequest;
import com.google.logging.v2.ListLogsResponse;
import com.google.logging.v2.ListMonitoredResourceDescriptorsRequest;
import com.google.logging.v2.ListMonitoredResourceDescriptorsResponse;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.LogExclusion;
import com.google.logging.v2.LogMetric;
import com.google.logging.v2.LogSink;
import com.google.logging.v2.TailLogEntriesRequest;
import com.google.logging.v2.TailLogEntriesResponse;
import com.google.logging.v2.UpdateExclusionRequest;
import com.google.logging.v2.UpdateLogMetricRequest;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.logging.v2.WriteLogEntriesRequest;
import com.google.logging.v2.WriteLogEntriesResponse;
import com.google.protobuf.Empty;
import io.grpc.CallOptions;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.io.IOException;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

public class GrpcLoggingRpc implements LoggingRpc {

  private final ConfigClient configClient;
  private final LoggingClient loggingClient;
  private final MetricsClient metricsClient;
  private final ScheduledExecutorService executor;
  private final ClientContext clientContext;
  private final ExecutorFactory<ScheduledExecutorService> executorFactory;

  private boolean closed;

  public GrpcLoggingRpc(final LoggingOptions options) throws IOException {
    GrpcTransportOptions transportOptions = (GrpcTransportOptions) options.getTransportOptions();
    executorFactory = transportOptions.getExecutorFactory();
    executor = executorFactory.get();
    try {
      // todo(mziccard): ChannelProvider should support null/absent credentials for
      // testing
      if (options.getHost().contains("localhost")
          || NoCredentials.getInstance().equals(options.getCredentials())) {
        ManagedChannel managedChannel =
            ManagedChannelBuilder.forTarget(options.getHost())
                .usePlaintext()
                .executor(executor)
                .build();
        try (TransportChannel transportChannel = GrpcTransportChannel.create(managedChannel)) {
          clientContext =
              ClientContext.newBuilder()
                  .setCredentials(null)
                  .setExecutor(executor)
                  .setTransportChannel(transportChannel)
                  .setDefaultCallContext(GrpcCallContext.of(managedChannel, CallOptions.DEFAULT))
                  .setBackgroundResources(
                      Collections.<BackgroundResource>singletonList(transportChannel))
                  .setQuotaProjectId(options.getQuotaProjectId())
                  .build();
        } catch (Exception ex) {
          throw new IOException(ex);
        }
      } else {
        LoggingSettingsBuilder settingsBuilder =
            new LoggingSettingsBuilder(LoggingSettings.newBuilder().build());

        settingsBuilder.setCredentialsProvider(
            GrpcTransportOptions.setUpCredentialsProvider(options));
        settingsBuilder.setTransportChannelProvider(
            GrpcTransportOptions.setUpChannelProvider(
                LoggingSettings.defaultGrpcTransportProviderBuilder(), options));

        HeaderProvider internalHeaderProvider =
            LoggingSettings.defaultApiClientHeaderProviderBuilder()
                .setClientLibToken(
                    ServiceOptions.getGoogApiClientLibName(),
                    GaxProperties.getLibraryVersion(options.getClass()))
                .build();
        HeaderProvider headerProvider = options.getMergedHeaderProvider(internalHeaderProvider);
        settingsBuilder.setInternalHeaderProvider(headerProvider);
        settingsBuilder.setQuotaProjectId(options.getQuotaProjectId());

        clientContext = ClientContext.create(settingsBuilder.build());
      }
      ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> retrySettingsSetter =
          new ApiFunction<UnaryCallSettings.Builder<?, ?>, Void>() {
            @Override
            public Void apply(UnaryCallSettings.Builder<?, ?> builder) {
              builder.setRetrySettings(options.getRetrySettings());
              return null;
            }
          };
      ConfigSettings.Builder confBuilder =
          ConfigSettings.newBuilder(clientContext).applyToAllUnaryMethods(retrySettingsSetter);
      LoggingSettings.Builder logBuilder =
          LoggingSettings.newBuilder(clientContext).applyToAllUnaryMethods(retrySettingsSetter);
      MetricsSettings.Builder metricsBuilder =
          MetricsSettings.newBuilder(clientContext).applyToAllUnaryMethods(retrySettingsSetter);

      // TODO(pongad): Take advantage of
      // https://github.com/googleapis/gax-java/pull/452 when it's
      // released.
      BatchingSettings oldBatchSettings =
          logBuilder.writeLogEntriesSettings().getBatchingSettings();
      logBuilder
          .writeLogEntriesSettings()
          .setBatchingSettings(
              oldBatchSettings
                  .toBuilder()
                  .setFlowControlSettings(
                      oldBatchSettings
                          .getFlowControlSettings()
                          .toBuilder()
                          .setLimitExceededBehavior(LimitExceededBehavior.Block)
                          .build())
                  .build());

      configClient = ConfigClient.create(confBuilder.build());
      loggingClient = LoggingClient.create(logBuilder.build());
      metricsClient = MetricsClient.create(metricsBuilder.build());
    } catch (Exception ex) {
      throw new IOException(ex);
    }
  }

  private static <V> ApiFuture<V> translate(ApiFuture<V> from, StatusCode.Code... returnNullOn) {
    final Set<StatusCode.Code> returnNullOnSet;
    if (returnNullOn.length > 0) {
      returnNullOnSet = EnumSet.of(returnNullOn[0], returnNullOn);
    } else {
      returnNullOnSet = ImmutableSet.of();
    }
    return ApiFutures.catching(
        from,
        ApiException.class,
        new ApiFunction<ApiException, V>() {
          @Override
          public V apply(ApiException exception) {
            if (returnNullOnSet.contains(exception.getStatusCode().getCode())) {
              return null;
            }
            throw new LoggingException(exception);
          }
        },
        MoreExecutors.directExecutor());
  }

  @Override
  public ApiFuture<LogSink> create(CreateSinkRequest request) {
    return translate(configClient.createSinkCallable().futureCall(request));
  }

  @Override
  public ApiFuture<LogSink> update(UpdateSinkRequest request) {
    return translate(configClient.updateSinkCallable().futureCall(request));
  }

  @Override
  public ApiFuture<LogSink> get(GetSinkRequest request) {
    return translate(configClient.getSinkCallable().futureCall(request), StatusCode.Code.NOT_FOUND);
  }

  @Override
  public ApiFuture<ListSinksResponse> list(ListSinksRequest request) {
    return translate(configClient.listSinksCallable().futureCall(request));
  }

  @Override
  public ApiFuture<Empty> delete(DeleteSinkRequest request) {
    return translate(
        configClient.deleteSinkCallable().futureCall(request), StatusCode.Code.NOT_FOUND);
  }

  @Override
  public ApiFuture<LogExclusion> create(CreateExclusionRequest request) {
    return translate(configClient.createExclusionCallable().futureCall(request));
  }

  @Override
  public ApiFuture<LogExclusion> get(GetExclusionRequest request) {
    return translate(
        configClient.getExclusionCallable().futureCall(request), StatusCode.Code.NOT_FOUND);
  }

  @Override
  public ApiFuture<LogExclusion> update(UpdateExclusionRequest request) {
    return translate(configClient.updateExclusionCallable().futureCall(request));
  }

  @Override
  public ApiFuture<ListExclusionsResponse> list(ListExclusionsRequest request) {
    return translate(configClient.listExclusionsCallable().futureCall(request));
  }

  @Override
  public ApiFuture<Empty> delete(DeleteExclusionRequest request) {
    return translate(
        configClient.deleteExclusionCallable().futureCall(request), StatusCode.Code.NOT_FOUND);
  }

  @Override
  public ApiFuture<ListLogsResponse> listLogs(ListLogsRequest request) {
    return translate(loggingClient.listLogsCallable().futureCall(request));
  }

  @Override
  public ApiFuture<Empty> delete(DeleteLogRequest request) {
    return translate(
        loggingClient.deleteLogCallable().futureCall(request), StatusCode.Code.NOT_FOUND);
  }

  @Override
  public ApiFuture<WriteLogEntriesResponse> write(WriteLogEntriesRequest request) {
    return translate(loggingClient.writeLogEntriesCallable().futureCall(request));
  }

  @Override
  public ApiFuture<ListLogEntriesResponse> list(ListLogEntriesRequest request) {
    return translate(loggingClient.listLogEntriesCallable().futureCall(request));
  }

  @Override
  public BidiStream<TailLogEntriesRequest, TailLogEntriesResponse> getTailLogEntriesStream() {
    return loggingClient.tailLogEntriesCallable().call();
  }

  @Override
  public ApiFuture<ListMonitoredResourceDescriptorsResponse> list(
      ListMonitoredResourceDescriptorsRequest request) {
    return translate(loggingClient.listMonitoredResourceDescriptorsCallable().futureCall(request));
  }

  @Override
  public ApiFuture<LogMetric> create(CreateLogMetricRequest request) {
    return translate(metricsClient.createLogMetricCallable().futureCall(request));
  }

  @Override
  public ApiFuture<LogMetric> update(UpdateLogMetricRequest request) {
    return translate(metricsClient.updateLogMetricCallable().futureCall(request));
  }

  @Override
  public ApiFuture<LogMetric> get(GetLogMetricRequest request) {
    return translate(
        metricsClient.getLogMetricCallable().futureCall(request), StatusCode.Code.NOT_FOUND);
  }

  @Override
  public ApiFuture<ListLogMetricsResponse> list(ListLogMetricsRequest request) {
    return translate(metricsClient.listLogMetricsCallable().futureCall(request));
  }

  @Override
  public ApiFuture<Empty> delete(DeleteLogMetricRequest request) {
    return translate(
        metricsClient.deleteLogMetricCallable().futureCall(request), StatusCode.Code.NOT_FOUND);
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
    for (BackgroundResource resource : clientContext.getBackgroundResources()) {
      resource.close();
    }
    executorFactory.release(executor);
  }

  // This class is needed solely to get access to protected method
  // setInternalHeaderProvider()
  private static class LoggingSettingsBuilder extends LoggingSettings.Builder {
    private LoggingSettingsBuilder(LoggingSettings settings) {
      super(settings);
    }

    @Override
    protected LoggingSettings.Builder setInternalHeaderProvider(
        HeaderProvider internalHeaderProvider) {
      return super.setInternalHeaderProvider(internalHeaderProvider);
    }
  }
}
