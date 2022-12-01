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

package com.google.cloud.logging;

import static com.google.api.client.util.Preconditions.checkArgument;
import static com.google.cloud.logging.Logging.EntryListOption.OptionType.ORDER_BY;
import static com.google.cloud.logging.Logging.ListOption.OptionType.PAGE_SIZE;
import static com.google.cloud.logging.Logging.ListOption.OptionType.PAGE_TOKEN;
import static com.google.cloud.logging.Logging.WriteOption.OptionType.LABELS;
import static com.google.cloud.logging.Logging.WriteOption.OptionType.LOG_DESTINATION;
import static com.google.cloud.logging.Logging.WriteOption.OptionType.LOG_NAME;
import static com.google.cloud.logging.Logging.WriteOption.OptionType.PARTIAL_SUCCESS;
import static com.google.cloud.logging.Logging.WriteOption.OptionType.RESOURCE;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.util.Strings;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.gax.paging.AsyncPage;
import com.google.api.gax.paging.Page;
import com.google.api.gax.rpc.BidiStream;
import com.google.cloud.AsyncPageImpl;
import com.google.cloud.BaseService;
import com.google.cloud.MonitoredResource;
import com.google.cloud.MonitoredResourceDescriptor;
import com.google.cloud.PageImpl;
import com.google.cloud.Tuple;
import com.google.cloud.logging.spi.v2.LoggingRpc;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Ascii;
import com.google.common.base.Function;
import com.google.common.base.Throwables;
import com.google.common.base.VerifyException;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Uninterruptibles;
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
import com.google.logging.v2.LogExclusionName;
import com.google.logging.v2.LogMetricName;
import com.google.logging.v2.LogName;
import com.google.logging.v2.LogSinkName;
import com.google.logging.v2.ProjectName;
import com.google.logging.v2.TailLogEntriesRequest;
import com.google.logging.v2.TailLogEntriesResponse;
import com.google.logging.v2.UpdateExclusionRequest;
import com.google.logging.v2.UpdateLogMetricRequest;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.logging.v2.WriteLogEntriesRequest;
import com.google.logging.v2.WriteLogEntriesResponse;
import com.google.protobuf.Empty;
import com.google.protobuf.util.Durations;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.jspecify.nullness.Nullable;

class LoggingImpl extends BaseService<LoggingOptions> implements Logging {
  protected static final String RESOURCE_NAME_FORMAT = "projects/%s/traces/%s";
  private static final int FLUSH_WAIT_TIMEOUT_SECONDS = 6;
  private final LoggingRpc rpc;
  private final Map<Object, ApiFuture<Void>> pendingWrites = new ConcurrentHashMap<>();

  private volatile Synchronicity writeSynchronicity = Synchronicity.ASYNC;
  private volatile Severity flushSeverity = Severity.NONE;
  private boolean closed;

  private static Boolean emptyToBooleanFunction(Empty input) {
    return input != null;
  }

  private static final Function<WriteLogEntriesResponse, Void> WRITE_RESPONSE_TO_VOID_FUNCTION =
      new Function<WriteLogEntriesResponse, Void>() {
        @Override
        public Void apply(WriteLogEntriesResponse input) {
          return null;
        }
      };
  private static final ThreadLocal<Boolean> inWriteCall = new ThreadLocal<>();

  @VisibleForTesting
  static ITimestampDefaultFilter defaultTimestampFilterCreator = new TimestampDefaultFilter();

  LoggingImpl(LoggingOptions options) {
    super(options);
    rpc = options.getLoggingRpcV2();
  }

  @Override
  public void setWriteSynchronicity(Synchronicity writeSynchronicity) {
    this.writeSynchronicity = writeSynchronicity;
  }

  @Override
  public void setFlushSeverity(Severity flushSeverity) {
    // For backward compatibility we treat null as Severity.NONE
    if (flushSeverity == null) {
      this.flushSeverity = Severity.NONE;
    } else {
      this.flushSeverity = flushSeverity;
    }
  }

  @Override
  public Synchronicity getWriteSynchronicity() {
    return writeSynchronicity;
  }

  @Override
  public Severity getFlushSeverity() {
    return flushSeverity;
  }

  private static <V> V get(ApiFuture<V> future) {
    try {
      return Uninterruptibles.getUninterruptibly(future);
    } catch (ExecutionException ex) {
      Throwables.throwIfUnchecked(ex.getCause());
      throw new VerifyException(ex);
    }
  }

  private static <I, O> ApiFuture<O> transform(
      ApiFuture<I> future, final Function<? super I, ? extends O> function) {
    return ApiFutures.transform(
        future,
        new ApiFunction<I, O>() {
          @Override
          public O apply(I i) {
            return function.apply(i);
          }
        },
        MoreExecutors.directExecutor());
  }

  private abstract static class BasePageFetcher<T> implements AsyncPageImpl.NextPageFetcher<T> {

    private static final long serialVersionUID = 5095123855547444030L;

    private final LoggingOptions serviceOptions;
    private final Map<Option.OptionType, ?> requestOptions;

    private BasePageFetcher(
        LoggingOptions serviceOptions, String cursor, Map<Option.OptionType, ?> requestOptions) {
      this.serviceOptions = serviceOptions;
      this.requestOptions = PageImpl.nextRequestOptions(PAGE_TOKEN, cursor, requestOptions);
    }

    LoggingOptions serviceOptions() {
      return serviceOptions;
    }

    Map<Option.OptionType, ?> requestOptions() {
      return requestOptions;
    }
  }

  private static class SinkPageFetcher extends BasePageFetcher<Sink> {

    private static final long serialVersionUID = 4879364260060886875L;

    SinkPageFetcher(
        LoggingOptions serviceOptions, String cursor, Map<Option.OptionType, ?> requestOptions) {
      super(serviceOptions, cursor, requestOptions);
    }

    @Override
    public ApiFuture<AsyncPage<Sink>> getNextPage() {
      return listSinksAsync(serviceOptions(), requestOptions());
    }
  }

  private static class LogNamePageFetcher extends BasePageFetcher<String> {
    private static final long serialVersionUID = 5308841362690185583L;

    LogNamePageFetcher(
        LoggingOptions serviceOptions, String cursor, Map<Option.OptionType, ?> requestOptions) {
      super(serviceOptions, cursor, requestOptions);
    }

    @Override
    public ApiFuture<AsyncPage<String>> getNextPage() {
      return listLogsAsync(serviceOptions(), requestOptions());
    }
  }

  private static class MonitoredResourceDescriptorPageFetcher
      extends BasePageFetcher<MonitoredResourceDescriptor> {

    private static final long serialVersionUID = -2346495771766629195L;

    MonitoredResourceDescriptorPageFetcher(
        LoggingOptions serviceOptions, String cursor, Map<Option.OptionType, ?> requestOptions) {
      super(serviceOptions, cursor, requestOptions);
    }

    @Override
    public ApiFuture<AsyncPage<MonitoredResourceDescriptor>> getNextPage() {
      return listMonitoredResourceDescriptorsAsync(serviceOptions(), requestOptions());
    }
  }

  private static class MetricPageFetcher extends BasePageFetcher<Metric> {

    private static final long serialVersionUID = -316783549651771553L;

    MetricPageFetcher(
        LoggingOptions serviceOptions, String cursor, Map<Option.OptionType, ?> requestOptions) {
      super(serviceOptions, cursor, requestOptions);
    }

    @Override
    public ApiFuture<AsyncPage<Metric>> getNextPage() {
      return listMetricsAsync(serviceOptions(), requestOptions());
    }
  }

  private static class ExclusionPageFetcher extends BasePageFetcher<Exclusion> {
    private static final long serialVersionUID = -1414118808031778916L;

    ExclusionPageFetcher(
        LoggingOptions serviceOptions, String cursor, Map<Option.OptionType, ?> requestOptions) {
      super(serviceOptions, cursor, requestOptions);
    }

    @Override
    public ApiFuture<AsyncPage<Exclusion>> getNextPage() {
      return listExclusionAsync(serviceOptions(), requestOptions());
    }
  }

  private static class LogEntryPageFetcher extends BasePageFetcher<LogEntry> {

    private static final long serialVersionUID = 4001239712280747734L;

    LogEntryPageFetcher(
        LoggingOptions serviceOptions, String cursor, Map<Option.OptionType, ?> requestOptions) {
      super(serviceOptions, cursor, requestOptions);
    }

    @Override
    public ApiFuture<AsyncPage<LogEntry>> getNextPage() {
      return listLogEntriesAsync(serviceOptions(), requestOptions());
    }
  }

  @Override
  public Sink create(SinkInfo sink) {
    return get(createAsync(sink));
  }

  @Override
  public Metric create(MetricInfo metric) {
    return get(createAsync(metric));
  }

  @Override
  public Exclusion create(Exclusion exclusion) {
    return get(createAsync(exclusion));
  }

  @Override
  public ApiFuture<Sink> createAsync(SinkInfo sink) {
    CreateSinkRequest request =
        CreateSinkRequest.newBuilder()
            .setParent(ProjectName.of(getOptions().getProjectId()).toString())
            .setSink(sink.toPb(getOptions().getProjectId()))
            .build();
    return transform(rpc.create(request), Sink.fromPbFunction(this));
  }

  @Override
  public ApiFuture<Metric> createAsync(MetricInfo metric) {
    CreateLogMetricRequest request =
        CreateLogMetricRequest.newBuilder()
            .setParent(ProjectName.of(getOptions().getProjectId()).toString())
            .setMetric(metric.toPb())
            .build();
    return transform(rpc.create(request), Metric.fromPbFunction(this));
  }

  @Override
  public ApiFuture<Exclusion> createAsync(Exclusion exclusion) {
    CreateExclusionRequest request =
        CreateExclusionRequest.newBuilder()
            .setParent(ProjectName.of(getOptions().getProjectId()).toString())
            .setExclusion(exclusion.toProtobuf())
            .build();
    return transform(rpc.create(request), Exclusion.FROM_PROTOBUF_FUNCTION);
  }

  @Override
  public Sink update(SinkInfo sink) {
    return get(updateAsync(sink));
  }

  @Override
  public Metric update(MetricInfo metric) {
    return get(updateAsync(metric));
  }

  @Override
  public Exclusion update(Exclusion exclusion) {
    return get(updateAsync(exclusion));
  }

  @Override
  public ApiFuture<Sink> updateAsync(SinkInfo sink) {
    UpdateSinkRequest request =
        UpdateSinkRequest.newBuilder()
            .setSinkName(
                LogSinkName.ofProjectSinkName(getOptions().getProjectId(), sink.getName())
                    .toString())
            .setSink(sink.toPb(getOptions().getProjectId()))
            .build();
    return transform(rpc.update(request), Sink.fromPbFunction(this));
  }

  @Override
  public ApiFuture<Metric> updateAsync(MetricInfo metric) {
    UpdateLogMetricRequest request =
        UpdateLogMetricRequest.newBuilder()
            .setMetricName(
                LogMetricName.of(getOptions().getProjectId(), metric.getName()).toString())
            .setMetric(metric.toPb())
            .build();
    return transform(rpc.update(request), Metric.fromPbFunction(this));
  }

  @Override
  public ApiFuture<Exclusion> updateAsync(Exclusion exclusion) {
    UpdateExclusionRequest request =
        UpdateExclusionRequest.newBuilder()
            .setName(
                LogExclusionName.of(getOptions().getProjectId(), exclusion.getName()).toString())
            .setExclusion(exclusion.toProtobuf())
            .build();
    return transform(rpc.update(request), Exclusion.FROM_PROTOBUF_FUNCTION);
  }

  @Override
  public Sink getSink(String sink) {
    return get(getSinkAsync(sink));
  }

  @Override
  public ApiFuture<Sink> getSinkAsync(String sink) {
    GetSinkRequest request =
        GetSinkRequest.newBuilder()
            .setSinkName(
                LogSinkName.ofProjectSinkName(getOptions().getProjectId(), sink).toString())
            .build();
    return transform(rpc.get(request), Sink.fromPbFunction(this));
  }

  private static ListSinksRequest listSinksRequest(
      LoggingOptions serviceOptions, Map<Option.OptionType, ?> options) {
    ListSinksRequest.Builder builder = ListSinksRequest.newBuilder();
    builder.setParent(ProjectName.of(serviceOptions.getProjectId()).toString());
    Integer pageSize = PAGE_SIZE.get(options);
    String pageToken = PAGE_TOKEN.get(options);
    if (pageSize != null) {
      builder.setPageSize(pageSize);
    }
    if (pageToken != null) {
      builder.setPageToken(pageToken);
    }
    return builder.build();
  }

  private static ApiFuture<AsyncPage<Sink>> listSinksAsync(
      final LoggingOptions serviceOptions, final Map<Option.OptionType, ?> options) {
    final ListSinksRequest request = listSinksRequest(serviceOptions, options);
    ApiFuture<ListSinksResponse> list = serviceOptions.getLoggingRpcV2().list(request);
    return transform(
        list,
        new Function<ListSinksResponse, AsyncPage<Sink>>() {
          @Override
          public AsyncPage<Sink> apply(ListSinksResponse listSinksResponse) {
            List<Sink> sinks =
                listSinksResponse.getSinksList().isEmpty()
                    ? ImmutableList.<Sink>of()
                    : Lists.transform(
                        listSinksResponse.getSinksList(),
                        Sink.fromPbFunction(serviceOptions.getService()));
            String cursor =
                listSinksResponse.getNextPageToken().isEmpty()
                    ? null
                    : listSinksResponse.getNextPageToken();
            return new AsyncPageImpl<>(
                new SinkPageFetcher(serviceOptions, cursor, options), cursor, sinks);
          }
        });
  }

  @Override
  public ApiFuture<AsyncPage<Sink>> listSinksAsync(ListOption... options) {
    return listSinksAsync(getOptions(), optionMap(options));
  }

  @Override
  public Page<Sink> listSinks(ListOption... options) {
    return get(listSinksAsync(options));
  }

  @Override
  public boolean deleteSink(String sink) {
    return get(deleteSinkAsync(sink));
  }

  @Override
  public ApiFuture<Boolean> deleteSinkAsync(String sink) {
    DeleteSinkRequest request =
        DeleteSinkRequest.newBuilder()
            .setSinkName(
                LogSinkName.ofProjectSinkName(getOptions().getProjectId(), sink).toString())
            .build();
    return transform(rpc.delete(request), LoggingImpl::emptyToBooleanFunction);
  }

  /**
   * Creates a new {@code ListLogsRequest} object.
   *
   * <p>Builds an instance of {@code ListLogsRequest} using page size, page token and project id
   * from the {@code LoggingOptions}. The project id is used as the request's parent parameter.
   *
   * @see com.google.logging.v2.ListLogEntriesRequest
   * @return the created {@code ListLogsRequest} object
   */
  private static ListLogsRequest listLogsRequest(
      LoggingOptions serviceOptions, Map<Option.OptionType, ?> options) {
    ListLogsRequest.Builder builder = ListLogsRequest.newBuilder();
    builder.setParent(ProjectName.of(serviceOptions.getProjectId()).toString());
    Integer pageSize = PAGE_SIZE.get(options);
    String pageToken = PAGE_TOKEN.get(options);
    if (pageSize != null) {
      builder.setPageSize(pageSize);
    }
    if (pageToken != null) {
      builder.setPageToken(pageToken);
    }
    return builder.build();
  }

  private static ApiFuture<AsyncPage<String>> listLogsAsync(
      final LoggingOptions serviceOptions, final Map<Option.OptionType, ?> options) {
    final ListLogsRequest request = listLogsRequest(serviceOptions, options);
    ApiFuture<ListLogsResponse> list = serviceOptions.getLoggingRpcV2().listLogs(request);
    return transform(
        list,
        new Function<ListLogsResponse, AsyncPage<String>>() {
          @Override
          public AsyncPage<String> apply(ListLogsResponse listLogsResponse) {
            List<String> logNames =
                listLogsResponse.getLogNamesList().isEmpty()
                    ? ImmutableList.<String>of()
                    : listLogsResponse.getLogNamesList();
            String cursor =
                listLogsResponse.getNextPageToken().isEmpty()
                    ? null
                    : listLogsResponse.getNextPageToken();
            return new AsyncPageImpl<>(
                new LogNamePageFetcher(serviceOptions, cursor, options), cursor, logNames);
          }
        });
  }

  @Override
  public ApiFuture<AsyncPage<String>> listLogsAsync(ListOption... options) {
    return listLogsAsync(getOptions(), optionMap(options));
  }

  @Override
  public Page<String> listLogs(ListOption... options) {
    return get(listLogsAsync(options));
  }

  @Override
  public boolean deleteLog(String log) {
    return get(deleteLogAsync(log, null));
  }

  @Override
  public boolean deleteLog(String log, LogDestinationName destination) {
    return get(deleteLogAsync(log, destination));
  }

  @Override
  public ApiFuture<Boolean> deleteLogAsync(String log) {
    return deleteLogAsync(log, null);
  }

  @Override
  public ApiFuture<Boolean> deleteLogAsync(String log, LogDestinationName destination) {
    checkNotNull(log, "log parameter cannot be null");
    String projectId = getOptions().getProjectId();
    if (destination == null) {
      checkNotNull(projectId, "projectId parameter cannot be null");
    }
    LogName name = getLogName(projectId, log, destination);
    DeleteLogRequest request = DeleteLogRequest.newBuilder().setLogName(name.toString()).build();
    return transform(rpc.delete(request), LoggingImpl::emptyToBooleanFunction);
  }

  private static ListMonitoredResourceDescriptorsRequest listMonitoredResourceDescriptorsRequest(
      Map<Option.OptionType, ?> options) {
    ListMonitoredResourceDescriptorsRequest.Builder builder =
        ListMonitoredResourceDescriptorsRequest.newBuilder();
    Integer pageSize = PAGE_SIZE.get(options);
    String pageToken = PAGE_TOKEN.get(options);
    if (pageSize != null) {
      builder.setPageSize(pageSize);
    }
    if (pageToken != null) {
      builder.setPageToken(pageToken);
    }
    return builder.build();
  }

  private static ApiFuture<AsyncPage<MonitoredResourceDescriptor>>
      listMonitoredResourceDescriptorsAsync(
          final LoggingOptions serviceOptions, final Map<Option.OptionType, ?> options) {
    final ListMonitoredResourceDescriptorsRequest request =
        listMonitoredResourceDescriptorsRequest(options);
    ApiFuture<ListMonitoredResourceDescriptorsResponse> list =
        serviceOptions.getLoggingRpcV2().list(request);
    return transform(
        list,
        new Function<
            ListMonitoredResourceDescriptorsResponse, AsyncPage<MonitoredResourceDescriptor>>() {
          @Override
          public AsyncPage<MonitoredResourceDescriptor> apply(
              ListMonitoredResourceDescriptorsResponse listDescriptorsResponse) {
            List<MonitoredResourceDescriptor> descriptors =
                listDescriptorsResponse.getResourceDescriptorsList().isEmpty()
                    ? ImmutableList.<MonitoredResourceDescriptor>of()
                    : Lists.transform(
                        listDescriptorsResponse.getResourceDescriptorsList(),
                        (com.google.api.MonitoredResourceDescriptor
                                monitoredResourceDescriptor) -> {
                          return MonitoredResourceDescriptor.FROM_PB_FUNCTION.apply(
                              monitoredResourceDescriptor);
                        });
            String cursor =
                listDescriptorsResponse.getNextPageToken().isEmpty()
                    ? null
                    : listDescriptorsResponse.getNextPageToken();
            return new AsyncPageImpl<>(
                new MonitoredResourceDescriptorPageFetcher(serviceOptions, cursor, options),
                cursor,
                descriptors);
          }
        });
  }

  @Override
  public ApiFuture<AsyncPage<MonitoredResourceDescriptor>> listMonitoredResourceDescriptorsAsync(
      ListOption... options) {
    return listMonitoredResourceDescriptorsAsync(getOptions(), optionMap(options));
  }

  @Override
  public Page<MonitoredResourceDescriptor> listMonitoredResourceDescriptors(ListOption... options) {
    return get(listMonitoredResourceDescriptorsAsync(options));
  }

  @Override
  public Metric getMetric(String metric) {
    return get(getMetricAsync(metric));
  }

  @Override
  public ApiFuture<Metric> getMetricAsync(String metric) {
    GetLogMetricRequest request =
        GetLogMetricRequest.newBuilder()
            .setMetricName(LogMetricName.of(getOptions().getProjectId(), metric).toString())
            .build();
    return transform(rpc.get(request), Metric.fromPbFunction(this));
  }

  private static ListLogMetricsRequest listMetricsRequest(
      LoggingOptions serviceOptions, Map<Option.OptionType, ?> options) {
    ListLogMetricsRequest.Builder builder = ListLogMetricsRequest.newBuilder();
    builder.setParent(ProjectName.of(serviceOptions.getProjectId()).toString());
    Integer pageSize = PAGE_SIZE.get(options);
    String pageToken = PAGE_TOKEN.get(options);
    if (pageSize != null) {
      builder.setPageSize(pageSize);
    }
    if (pageToken != null) {
      builder.setPageToken(pageToken);
    }
    return builder.build();
  }

  private static ApiFuture<AsyncPage<Metric>> listMetricsAsync(
      final LoggingOptions serviceOptions, final Map<Option.OptionType, ?> options) {
    final ListLogMetricsRequest request = listMetricsRequest(serviceOptions, options);
    ApiFuture<ListLogMetricsResponse> list = serviceOptions.getLoggingRpcV2().list(request);
    return transform(
        list,
        new Function<ListLogMetricsResponse, AsyncPage<Metric>>() {
          @Override
          public AsyncPage<Metric> apply(ListLogMetricsResponse listMetricsResponse) {
            List<Metric> metrics =
                listMetricsResponse.getMetricsList().isEmpty()
                    ? ImmutableList.<Metric>of()
                    : Lists.transform(
                        listMetricsResponse.getMetricsList(),
                        Metric.fromPbFunction(serviceOptions.getService()));
            String cursor =
                listMetricsResponse.getNextPageToken().isEmpty()
                    ? null
                    : listMetricsResponse.getNextPageToken();
            return new AsyncPageImpl<>(
                new MetricPageFetcher(serviceOptions, cursor, options), cursor, metrics);
          }
        });
  }

  @Override
  public ApiFuture<AsyncPage<Metric>> listMetricsAsync(ListOption... options) {
    return listMetricsAsync(getOptions(), optionMap(options));
  }

  @Override
  public Page<Metric> listMetrics(ListOption... options) {
    return get(listMetricsAsync(options));
  }

  @Override
  public boolean deleteMetric(String metric) {
    return get(deleteMetricAsync(metric));
  }

  @Override
  public ApiFuture<Boolean> deleteMetricAsync(String metric) {
    DeleteLogMetricRequest request =
        DeleteLogMetricRequest.newBuilder()
            .setMetricName(LogMetricName.of(getOptions().getProjectId(), metric).toString())
            .build();
    return transform(rpc.delete(request), LoggingImpl::emptyToBooleanFunction);
  }

  @Override
  public Exclusion getExclusion(String exclusion) {
    return get(getExclusionAsync(exclusion));
  }

  @Override
  public ApiFuture<Exclusion> getExclusionAsync(String exclusion) {
    GetExclusionRequest request =
        GetExclusionRequest.newBuilder()
            .setName(LogExclusionName.of(getOptions().getProjectId(), exclusion).toString())
            .build();
    return transform(rpc.get(request), Exclusion.FROM_PROTOBUF_FUNCTION);
  }

  @Override
  public boolean deleteExclusion(String exclusion) {
    return get(deleteExclusionAsync(exclusion));
  }

  @Override
  public ApiFuture<Boolean> deleteExclusionAsync(String exclusion) {
    DeleteExclusionRequest request =
        DeleteExclusionRequest.newBuilder()
            .setName(LogExclusionName.of(getOptions().getProjectId(), exclusion).toString())
            .build();
    return transform(rpc.delete(request), LoggingImpl::emptyToBooleanFunction);
  }

  @Override
  public Page<Exclusion> listExclusions(ListOption... options) {
    return get(listExclusionsAsync(options));
  }

  @Override
  public ApiFuture<AsyncPage<Exclusion>> listExclusionsAsync(ListOption... options) {
    return listExclusionAsync(getOptions(), optionMap(options));
  }

  private static ListExclusionsRequest listExclusionsRequest(
      LoggingOptions serviceOptions, Map<Option.OptionType, ?> options) {
    ListExclusionsRequest.Builder builder = ListExclusionsRequest.newBuilder();
    builder.setParent(ProjectName.of(serviceOptions.getProjectId()).toString());
    Integer pageSize = PAGE_SIZE.get(options);
    String pageToken = PAGE_TOKEN.get(options);
    if (pageSize != null) {
      builder.setPageSize(pageSize);
    }
    if (pageToken != null) {
      builder.setPageToken(pageToken);
    }
    return builder.build();
  }

  private static ApiFuture<AsyncPage<Exclusion>> listExclusionAsync(
      final LoggingOptions serviceOptions, final Map<Option.OptionType, ?> options) {
    final ListExclusionsRequest request = listExclusionsRequest(serviceOptions, options);
    ApiFuture<ListExclusionsResponse> list = serviceOptions.getLoggingRpcV2().list(request);
    return transform(
        list,
        new Function<ListExclusionsResponse, AsyncPage<Exclusion>>() {
          @Override
          public AsyncPage<Exclusion> apply(ListExclusionsResponse listExclusionsResponse) {
            List<Exclusion> exclusions =
                listExclusionsResponse.getExclusionsList().isEmpty()
                    ? ImmutableList.<Exclusion>of()
                    : Lists.transform(
                        listExclusionsResponse.getExclusionsList(),
                        Exclusion.FROM_PROTOBUF_FUNCTION);
            String cursor =
                listExclusionsResponse.getNextPageToken().isEmpty()
                    ? null
                    : listExclusionsResponse.getNextPageToken();
            return new AsyncPageImpl<>(
                new ExclusionPageFetcher(serviceOptions, cursor, options), cursor, exclusions);
          }
        });
  }

  private static WriteLogEntriesRequest writeLogEntriesRequest(
      LoggingOptions serviceOptions,
      Iterable<LogEntry> logEntries,
      Map<Option.OptionType, ?> options) {
    WriteLogEntriesRequest.Builder builder = WriteLogEntriesRequest.newBuilder();
    String projectId = serviceOptions.getProjectId();

    LogName logName = getLogName(projectId, LOG_NAME.get(options), LOG_DESTINATION.get(options));

    if (logName != null) {
      builder.setLogName(logName.toString());
    }
    MonitoredResource resource = RESOURCE.get(options);
    if (resource != null) {
      builder.setResource(resource.toPb());
    }
    Map<String, String> labels = LABELS.get(options);
    if (labels != null) {
      builder.putAllLabels(labels);
    }

    builder.setPartialSuccess(Boolean.TRUE.equals(PARTIAL_SUCCESS.get(options)));
    builder.addAllEntries(Iterables.transform(logEntries, LogEntry.toPbFunction(projectId)));
    return builder.build();
  }

  private static @Nullable LogName getLogName(
      String projectId, String logName, LogDestinationName destination) {
    if (logName == null) {
      return null;
    }

    // If no destination specified, fallback to project based log name
    if (destination == null) {
      return LogName.ofProjectLogName(projectId, logName);
    }

    return destination.toLogName(logName);
  }

  @Override
  public Iterable<LogEntry> populateMetadata(
      Iterable<LogEntry> logEntries,
      MonitoredResource customResource,
      String... exclusionClassPaths) {
    checkNotNull(logEntries);
    final boolean needDebugInfo =
        Iterables.any(
            logEntries,
            log -> log.getSeverity() == Severity.DEBUG && log.getSourceLocation() == null);
    final SourceLocation sourceLocation =
        needDebugInfo ? SourceLocation.fromCurrentContext(exclusionClassPaths) : null;
    // populate monitored resource metadata by prioritizing the one set via
    // WriteOption
    final MonitoredResource resourceMetadata =
        customResource == null
            ? MonitoredResourceUtil.getResource(getOptions().getProjectId(), null)
            : customResource;
    final Context context = new ContextHandler().getCurrentContext();
    final ArrayList<LogEntry> populatedLogEntries = Lists.newArrayList();

    // populate empty metadata fields of log entries before calling write API
    for (LogEntry entry : logEntries) {
      if (entry == null) {
        continue;
      }
      LogEntry.Builder entityBuilder = entry.toBuilder();
      if (resourceMetadata != null && entry.getResource() == null) {
        entityBuilder.setResource(resourceMetadata);
      }
      if (context != null && entry.getHttpRequest() == null) {
        entityBuilder.setHttpRequest(context.getHttpRequest());
      }
      if (context != null && Strings.isNullOrEmpty(entry.getTrace())) {
        MonitoredResource resource =
            entry.getResource() != null ? entry.getResource() : resourceMetadata;
        entityBuilder.setTrace(getFormattedTrace(context.getTraceId(), resource));
      }
      if (context != null && Strings.isNullOrEmpty(entry.getSpanId())) {
        entityBuilder.setSpanId(context.getSpanId());
      }
      if (entry.getSeverity() == Severity.DEBUG && entry.getSourceLocation() == null) {
        entityBuilder.setSourceLocation(sourceLocation);
      }
      populatedLogEntries.add(entityBuilder.build());
    }
    return populatedLogEntries;
  }

  @Override
  public void write(Iterable<LogEntry> logEntries, WriteOption... options) {
    if (inWriteCall.get() != null) {
      return;
    }
    inWriteCall.set(true);

    try {
      final Map<Option.OptionType, ?> writeOptions = optionMap(options);
      final Boolean loggingOptionsPopulateFlag = getOptions().getAutoPopulateMetadata();
      final Boolean writeOptionPartialSuccessFlag =
          WriteOption.OptionType.PARTIAL_SUCCESS.get(writeOptions);
      final Boolean writeOptionPopulateFlag =
          WriteOption.OptionType.AUTO_POPULATE_METADATA.get(writeOptions);
      Tuple<Boolean, Iterable<LogEntry>> pair =
          Instrumentation.populateInstrumentationInfo(logEntries);
      logEntries = pair.y();

      if (Objects.equals(writeOptionPopulateFlag, Boolean.TRUE)
          || (writeOptionPopulateFlag == null
              && Objects.equals(loggingOptionsPopulateFlag, Boolean.TRUE))) {
        final MonitoredResource sharedResourceMetadata = RESOURCE.get(writeOptions);
        logEntries =
            populateMetadata(logEntries, sharedResourceMetadata, this.getClass().getName());
      }
      // Add partialSuccess = true option always for request which does not have
      // it set explicitly in options.
      // For request containing instrumentation data (e.g. when pair.x() == true),
      // always set or override partialSuccess with true.
      if (pair.x() || writeOptionPartialSuccessFlag == null) {
        options = Instrumentation.addPartialSuccessOption(options);
      }
      writeLogEntries(logEntries, options);
      if (flushSeverity != Severity.NONE) {
        for (LogEntry logEntry : logEntries) {
          // flush pending writes if log severity at or above flush severity
          if (logEntry.getSeverity().compareTo(flushSeverity) >= 0) {
            flush();
            break;
          }
        }
      }
    } finally {
      inWriteCall.remove();
    }
  }

  @Override
  public void flush() {
    // BUG(1795): We should force batcher to issue RPC call for buffered messages,
    // so the code below doesn't wait uselessly.
    ArrayList<ApiFuture<Void>> writesToFlush = new ArrayList<>(pendingWrites.values());

    try {
      ApiFutures.allAsList(writesToFlush).get(FLUSH_WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
    } catch (InterruptedException | ExecutionException | TimeoutException e) {
      throw new VerifyException(e);
    }
  }

  /**
   * Formats trace following resource name template if the resource metadata has project id.
   *
   * @param traceId A trace id string or {@code null} if trace info is missing.
   * @param resource A {@see MonitoredResource} describing environment metadata.
   * @return A formatted trace id string.
   */
  private @Nullable String getFormattedTrace(String traceId, MonitoredResource resource) {
    if (traceId == null) {
      return null;
    }
    String projectId = null;
    if (resource != null) {
      projectId = resource.getLabels().getOrDefault(MonitoredResourceUtil.PORJECTID_LABEL, null);
    }
    if (projectId != null) {
      return String.format(RESOURCE_NAME_FORMAT, projectId, traceId);
    }
    return traceId;
  }

  /*
   * Write logs synchronously or asynchronously based on writeSynchronicity
   * setting.
   */
  private void writeLogEntries(Iterable<LogEntry> logEntries, WriteOption... writeOptions) {
    if (closed) {
      return;
    }

    switch (this.writeSynchronicity) {
      case SYNC:
        get(writeAsync(logEntries, writeOptions));
        break;

      case ASYNC:
        final ApiFuture<Void> writeFuture = writeAsync(logEntries, writeOptions);
        final Object pendingKey = new Object();
        pendingWrites.put(pendingKey, writeFuture);
        ApiFutures.addCallback(
            writeFuture,
            new ApiFutureCallback<Void>() {
              private void removeFromPending() {
                pendingWrites.remove(pendingKey);
              }

              @Override
              public void onSuccess(Void v) {
                removeFromPending();
              }

              @Override
              public void onFailure(Throwable t) {
                try {
                  Exception ex = t instanceof Exception ? (Exception) t : new Exception(t);
                  System.err.println("ERROR: onFailure exception: " + ex);
                } finally {
                  removeFromPending();
                }
              }
            },
            MoreExecutors.directExecutor());
        break;
    }
  }

  private ApiFuture<Void> writeAsync(Iterable<LogEntry> logEntries, WriteOption... options) {
    return transform(
        rpc.write(writeLogEntriesRequest(getOptions(), logEntries, optionMap(options))),
        WRITE_RESPONSE_TO_VOID_FUNCTION);
  }

  static ListLogEntriesRequest listLogEntriesRequest(
      String projectId, Map<Option.OptionType, ?> options) {
    ListLogEntriesRequest.Builder builder = ListLogEntriesRequest.newBuilder();
    builder.addResourceNames("projects/" + projectId);
    String organization = EntryListOption.OptionType.ORGANIZATION.get(options);
    if (organization != null) {
      builder.addResourceNames("organizations/" + organization);
    }
    String billingAccount = EntryListOption.OptionType.BILLINGACCOUNT.get(options);
    if (billingAccount != null) {
      builder.addResourceNames("billingAccounts/" + billingAccount);
    }
    String folder = EntryListOption.OptionType.FOLDER.get(options);
    if (folder != null) {
      builder.addResourceNames("folders/" + folder);
    }
    Integer pageSize = PAGE_SIZE.get(options);
    if (pageSize != null) {
      builder.setPageSize(pageSize);
    }
    String pageToken = PAGE_TOKEN.get(options);
    if (pageToken != null) {
      builder.setPageToken(pageToken);
    }
    String orderBy = ORDER_BY.get(options);
    if (orderBy != null) {
      builder.setOrderBy(orderBy);
    }
    String filter = EntryListOption.OptionType.FILTER.get(options);
    // Make sure timestamp filter is either explicitly specified or we add a default
    // time filter
    // of 24 hours back to be inline with gcloud behavior for the same API
    if (filter != null) {
      if (!Ascii.toLowerCase(filter).contains("timestamp")) {
        filter =
            String.format(
                "%s AND %s", filter, defaultTimestampFilterCreator.createDefaultTimestampFilter());
      }
      builder.setFilter(filter);
    } else {
      // If filter is not specified, default filter is looking back 24 hours in line
      // with gcloud
      // behavior
      builder.setFilter(defaultTimestampFilterCreator.createDefaultTimestampFilter());
    }

    return builder.build();
  }

  private static ApiFuture<AsyncPage<LogEntry>> listLogEntriesAsync(
      final LoggingOptions serviceOptions, final Map<Option.OptionType, ?> options) {
    final ListLogEntriesRequest request =
        listLogEntriesRequest(serviceOptions.getProjectId(), options);
    ApiFuture<ListLogEntriesResponse> list = serviceOptions.getLoggingRpcV2().list(request);
    return transform(
        list,
        new Function<ListLogEntriesResponse, AsyncPage<LogEntry>>() {
          @Override
          public AsyncPage<LogEntry> apply(ListLogEntriesResponse listLogEntriesResponse) {
            List<LogEntry> entries =
                listLogEntriesResponse.getEntriesList().isEmpty()
                    ? ImmutableList.<LogEntry>of()
                    : Lists.transform(
                        listLogEntriesResponse.getEntriesList(), LogEntry.FROM_PB_FUNCTION);
            String cursor =
                listLogEntriesResponse.getNextPageToken().isEmpty()
                    ? null
                    : listLogEntriesResponse.getNextPageToken();
            return new AsyncPageImpl<>(
                new LogEntryPageFetcher(serviceOptions, cursor, options), cursor, entries);
          }
        });
  }

  @Override
  public ApiFuture<AsyncPage<LogEntry>> listLogEntriesAsync(EntryListOption... options) {
    return listLogEntriesAsync(getOptions(), optionMap(options));
  }

  @Override
  public Page<LogEntry> listLogEntries(EntryListOption... options) {
    return get(listLogEntriesAsync(options));
  }

  static TailLogEntriesRequest buildTailLogEntriesRequest(
      Map<Option.OptionType, ?> options, String defaultProjectId) {
    TailLogEntriesRequest.Builder builder = TailLogEntriesRequest.newBuilder();

    String organization = TailOption.OptionType.ORGANIZATION.get(options);
    if (organization != null) {
      builder.addResourceNames("organizations/" + organization);
    }
    String billingAccount = TailOption.OptionType.BILLINGACCOUNT.get(options);
    if (billingAccount != null) {
      builder.addResourceNames("billingAccounts/" + billingAccount);
    }
    String folder = TailOption.OptionType.FOLDER.get(options);
    if (folder != null) {
      builder.addResourceNames("folders/" + folder);
    }
    String project = TailOption.OptionType.PROJECT.get(options);
    if (project != null) {
      builder.addResourceNames("projects/" + project);
    } else if (defaultProjectId != null) {
      builder.addResourceNames("projects/" + defaultProjectId);
    }
    String filter = TailOption.OptionType.FILTER.get(options);
    if (filter != null) {
      builder.setFilter(filter);
    }
    String bufferWindow = TailOption.OptionType.BUFFERWINDOW.get(options);
    if (bufferWindow != null) {
      try {
        builder.setBufferWindow(Durations.parse(bufferWindow));
      } catch (ParseException err) {
        System.err.println("ERROR: invalid duration format: " + bufferWindow);
      }
    }
    return builder.build();
  }

  @Override
  public LogEntryServerStream tailLogEntries(TailOption... options) {
    LoggingOptions serviceOptions = getOptions();
    BidiStream<TailLogEntriesRequest, TailLogEntriesResponse> bidiStream =
        serviceOptions.getLoggingRpcV2().getTailLogEntriesStream();
    final TailLogEntriesRequest request =
        buildTailLogEntriesRequest(optionMap(options), serviceOptions.getProjectId());
    bidiStream.send(request);
    return new LogEntryServerStream(bidiStream);
  }

  @Override
  public void close() throws Exception {
    if (closed) {
      return;
    }
    closed = true;
    flush();
    rpc.close();
  }

  static Map<Option.OptionType, ?> optionMap(Option... options) {
    Map<Option.OptionType, Object> optionMap = Maps.newHashMap();
    for (Option option : options) {
      Object prev = optionMap.put(option.getOptionType(), option.getValue());
      checkArgument(prev == null, "Duplicate option %s", option);
    }
    return optionMap;
  }

  @VisibleForTesting
  int getNumPendingWrites() {
    return pendingWrites.size();
  }
}
