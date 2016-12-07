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

package com.google.cloud.logging;

import static com.google.api.client.util.Preconditions.checkArgument;
import static com.google.cloud.logging.Logging.EntryListOption.OptionType.FILTER;
import static com.google.cloud.logging.Logging.EntryListOption.OptionType.ORDER_BY;
import static com.google.cloud.logging.Logging.ListOption.OptionType.PAGE_SIZE;
import static com.google.cloud.logging.Logging.ListOption.OptionType.PAGE_TOKEN;
import static com.google.cloud.logging.Logging.WriteOption.OptionType.LABELS;
import static com.google.cloud.logging.Logging.WriteOption.OptionType.LOG_NAME;
import static com.google.cloud.logging.Logging.WriteOption.OptionType.RESOURCE;

import com.google.cloud.AsyncPage;
import com.google.cloud.AsyncPageImpl;
import com.google.cloud.BaseService;
import com.google.cloud.MonitoredResource;
import com.google.cloud.MonitoredResourceDescriptor;
import com.google.cloud.Page;
import com.google.cloud.PageImpl;
import com.google.cloud.logging.spi.LoggingRpc;
import com.google.common.base.Function;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
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
import com.google.logging.v2.LogName;
import com.google.logging.v2.MetricName;
import com.google.logging.v2.ProjectName;
import com.google.logging.v2.SinkName;
import com.google.logging.v2.UpdateLogMetricRequest;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.logging.v2.WriteLogEntriesRequest;
import com.google.logging.v2.WriteLogEntriesResponse;
import com.google.protobuf.Empty;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

class LoggingImpl extends BaseService<LoggingOptions> implements Logging {

  private final LoggingRpc rpc;
  private boolean closed;

  private static final Function<Empty, Boolean> EMPTY_TO_BOOLEAN_FUNCTION =
      new Function<Empty, Boolean>() {
        @Override
        public Boolean apply(Empty input) {
          return input != null;
        }
      };
  private static final Function<WriteLogEntriesResponse, Void> WRITE_RESPONSE_TO_VOID_FUNCTION =
      new Function<WriteLogEntriesResponse, Void>() {
        @Override
        public Void apply(WriteLogEntriesResponse input) {
          return null;
        }
      };

  LoggingImpl(LoggingOptions options) {
    super(options);
    rpc = options.getRpc();
  }

  private static <V> V get(Future<V> future) {
    try {
      return Uninterruptibles.getUninterruptibly(future);
    } catch (ExecutionException ex) {
      throw Throwables.propagate(ex.getCause());
    }
  }

  private static <I, O> Future<O> transform(Future<I> future,
      Function<? super I, ? extends O> function) {
    if (future instanceof ListenableFuture) {
      return Futures.transform((ListenableFuture<I>) future, function);
    }
    return Futures.lazyTransform(future, function);
  }

  private abstract static class BasePageFetcher<T> implements AsyncPageImpl.NextPageFetcher<T> {

    private static final long serialVersionUID = 5095123855547444030L;

    private final LoggingOptions serviceOptions;
    private final Map<Option.OptionType, ?> requestOptions;

    private BasePageFetcher(LoggingOptions serviceOptions, String cursor,
        Map<Option.OptionType, ?> requestOptions) {
      this.serviceOptions = serviceOptions;
      this.requestOptions =
          PageImpl.nextRequestOptions(PAGE_TOKEN, cursor, requestOptions);
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

    SinkPageFetcher(LoggingOptions serviceOptions, String cursor,
        Map<Option.OptionType, ?> requestOptions) {
      super(serviceOptions, cursor, requestOptions);
    }

    @Override
    @Deprecated
    public Future<AsyncPage<Sink>> nextPage() {
      return getNextPage();
    }

    @Override
    public Future<AsyncPage<Sink>> getNextPage() {
      return listSinksAsync(serviceOptions(), requestOptions());
    }
  }

  private static class MonitoredResourceDescriptorPageFetcher
      extends BasePageFetcher<MonitoredResourceDescriptor> {

    private static final long serialVersionUID = -2346495771766629195L;

    MonitoredResourceDescriptorPageFetcher(LoggingOptions serviceOptions, String cursor,
        Map<Option.OptionType, ?> requestOptions) {
      super(serviceOptions, cursor, requestOptions);
    }

    @Override
    @Deprecated
    public Future<AsyncPage<MonitoredResourceDescriptor>> nextPage() {
      return getNextPage();
    }

    @Override
    public Future<AsyncPage<MonitoredResourceDescriptor>> getNextPage() {
      return listMonitoredResourceDescriptorsAsync(serviceOptions(), requestOptions());
    }
  }

  private static class MetricPageFetcher extends BasePageFetcher<Metric> {

    private static final long serialVersionUID = -316783549651771553L;

    MetricPageFetcher(LoggingOptions serviceOptions, String cursor,
        Map<Option.OptionType, ?> requestOptions) {
      super(serviceOptions, cursor, requestOptions);
    }

    @Override
    @Deprecated
    public Future<AsyncPage<Metric>> nextPage() {
      return getNextPage();
    }

    @Override
    public Future<AsyncPage<Metric>> getNextPage() {
      return listMetricsAsync(serviceOptions(), requestOptions());
    }
  }

  private static class LogEntryPageFetcher extends BasePageFetcher<LogEntry> {

    private static final long serialVersionUID = 4001239712280747734L;

    LogEntryPageFetcher(LoggingOptions serviceOptions, String cursor,
        Map<Option.OptionType, ?> requestOptions) {
      super(serviceOptions, cursor, requestOptions);
    }

    @Override
    @Deprecated
    public Future<AsyncPage<LogEntry>> nextPage() {
      return getNextPage();
    }

    @Override
    public Future<AsyncPage<LogEntry>> getNextPage() {
      return listLogEntriesAsync(serviceOptions(), requestOptions());
    }
  }

  @Override
  public Sink create(SinkInfo sink) {
    return get(createAsync(sink));
  }

  @Override
  public Future<Sink> createAsync(SinkInfo sink) {
    CreateSinkRequest request = CreateSinkRequest.newBuilder()
        .setParent(ProjectName.create(getOptions().getProjectId()).toString())
        .setSink(sink.toPb(getOptions().getProjectId()))
        .build();
    return transform(rpc.create(request), Sink.fromPbFunction(this));
  }

  @Override
  public Sink update(SinkInfo sink) {
    return get(updateAsync(sink));
  }

  @Override
  public Future<Sink> updateAsync(SinkInfo sink) {
    UpdateSinkRequest request = UpdateSinkRequest.newBuilder()
        .setSinkName(SinkName.create(getOptions().getProjectId(), sink.getName()).toString())
        .setSink(sink.toPb(getOptions().getProjectId()))
        .build();
    return transform(rpc.update(request), Sink.fromPbFunction(this));
  }

  @Override
  public Sink getSink(String sink) {
    return get(getSinkAsync(sink));
  }

  @Override
  public Future<Sink> getSinkAsync(String sink) {
    GetSinkRequest request = GetSinkRequest.newBuilder()
        .setSinkName(SinkName.create(getOptions().getProjectId(), sink).toString())
        .build();
    return transform(rpc.get(request), Sink.fromPbFunction(this));
  }

  private static ListSinksRequest listSinksRequest(LoggingOptions serviceOptions,
      Map<Option.OptionType, ?> options) {
    ListSinksRequest.Builder builder = ListSinksRequest.newBuilder();
    builder.setParent(ProjectName.create(serviceOptions.getProjectId()).toString());
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

  private static Future<AsyncPage<Sink>> listSinksAsync(final LoggingOptions serviceOptions,
      final Map<Option.OptionType, ?> options) {
    final ListSinksRequest request = listSinksRequest(serviceOptions, options);
    Future<ListSinksResponse> list = serviceOptions.getRpc().list(request);
    return transform(list, new Function<ListSinksResponse, AsyncPage<Sink>>() {
      @Override
      public AsyncPage<Sink> apply(ListSinksResponse listSinksResponse) {
        List<Sink> sinks = listSinksResponse.getSinksList() == null ? ImmutableList.<Sink>of()
            : Lists.transform(listSinksResponse.getSinksList(),
            Sink.fromPbFunction(serviceOptions.getService()));
        String cursor = listSinksResponse.getNextPageToken().equals("") ? null
            : listSinksResponse.getNextPageToken();
        return new AsyncPageImpl<>(
            new SinkPageFetcher(serviceOptions, cursor, options), cursor, sinks);
      }
    });
  }

  @Override
  public Page<Sink> listSinks(ListOption... options) {
    return get(listSinksAsync(options));
  }

  @Override
  public Future<AsyncPage<Sink>> listSinksAsync(ListOption... options) {
    return listSinksAsync(getOptions(), optionMap(options));
  }

  @Override
  public boolean deleteSink(String sink) {
    return get(deleteSinkAsync(sink));
  }

  @Override
  public Future<Boolean> deleteSinkAsync(String sink) {
    DeleteSinkRequest request = DeleteSinkRequest.newBuilder()
        .setSinkName(SinkName.create(getOptions().getProjectId(), sink).toString())
        .build();
    return transform(rpc.delete(request), EMPTY_TO_BOOLEAN_FUNCTION);
  }

  public boolean deleteLog(String log) {
    return get(deleteLogAsync(log));
  }

  public Future<Boolean> deleteLogAsync(String log) {
    DeleteLogRequest request = DeleteLogRequest.newBuilder()
        .setLogName(LogName.create(getOptions().getProjectId(), log).toString())
        .build();
    return transform(rpc.delete(request), EMPTY_TO_BOOLEAN_FUNCTION);
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

  private static Future<AsyncPage<MonitoredResourceDescriptor>>
      listMonitoredResourceDescriptorsAsync(final LoggingOptions serviceOptions,
          final Map<Option.OptionType, ?> options) {
    final ListMonitoredResourceDescriptorsRequest request =
        listMonitoredResourceDescriptorsRequest(options);
    Future<ListMonitoredResourceDescriptorsResponse> list = serviceOptions.getRpc().list(request);
    return transform(list, new Function<ListMonitoredResourceDescriptorsResponse,
        AsyncPage<MonitoredResourceDescriptor>>() {
          @Override
          public AsyncPage<MonitoredResourceDescriptor> apply(
              ListMonitoredResourceDescriptorsResponse listDescriptorsResponse) {
            List<MonitoredResourceDescriptor> descriptors =
                listDescriptorsResponse.getResourceDescriptorsList() == null
                    ? ImmutableList.<MonitoredResourceDescriptor>of()
                    : Lists.transform(listDescriptorsResponse.getResourceDescriptorsList(),
                MonitoredResourceDescriptor.FROM_PB_FUNCTION);
            String cursor = listDescriptorsResponse.getNextPageToken().equals("") ? null
                : listDescriptorsResponse.getNextPageToken();
            return new AsyncPageImpl<>(
                new MonitoredResourceDescriptorPageFetcher(serviceOptions, cursor, options), cursor,
                descriptors);
          }
        });
  }

  public Page<MonitoredResourceDescriptor> listMonitoredResourceDescriptors(ListOption... options) {
    return get(listMonitoredResourceDescriptorsAsync(options));
  }

  public Future<AsyncPage<MonitoredResourceDescriptor>> listMonitoredResourceDescriptorsAsync(
      ListOption... options) {
    return listMonitoredResourceDescriptorsAsync(getOptions(), optionMap(options));
  }

  @Override
  public Metric create(MetricInfo metric) {
    return get(createAsync(metric));
  }

  @Override
  public Future<Metric> createAsync(MetricInfo metric) {
    CreateLogMetricRequest request = CreateLogMetricRequest.newBuilder()
        .setParent(ProjectName.create(getOptions().getProjectId()).toString())
        .setMetric(metric.toPb())
        .build();
    return transform(rpc.create(request), Metric.fromPbFunction(this));
  }

  @Override
  public Metric update(MetricInfo metric) {
    return get(updateAsync(metric));
  }

  @Override
  public Future<Metric> updateAsync(MetricInfo metric) {
    UpdateLogMetricRequest request = UpdateLogMetricRequest.newBuilder()
        .setMetricName(MetricName.create(getOptions().getProjectId(), metric.getName()).toString())
        .setMetric(metric.toPb())
        .build();
    return transform(rpc.update(request), Metric.fromPbFunction(this));
  }

  @Override
  public Metric getMetric(String metric) {
    return get(getMetricAsync(metric));
  }

  @Override
  public Future<Metric> getMetricAsync(String metric) {
    GetLogMetricRequest request = GetLogMetricRequest.newBuilder()
        .setMetricName(MetricName.create(getOptions().getProjectId(), metric).toString())
        .build();
    return transform(rpc.get(request), Metric.fromPbFunction(this));
  }

  private static ListLogMetricsRequest listMetricsRequest(LoggingOptions serviceOptions,
      Map<Option.OptionType, ?> options) {
    ListLogMetricsRequest.Builder builder = ListLogMetricsRequest.newBuilder();
    builder.setParent(ProjectName.create(serviceOptions.getProjectId()).toString());
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

  private static Future<AsyncPage<Metric>> listMetricsAsync(final LoggingOptions serviceOptions,
      final Map<Option.OptionType, ?> options) {
    final ListLogMetricsRequest request = listMetricsRequest(serviceOptions, options);
    Future<ListLogMetricsResponse> list = serviceOptions.getRpc().list(request);
    return transform(list, new Function<ListLogMetricsResponse, AsyncPage<Metric>>() {
      @Override
      public AsyncPage<Metric> apply(ListLogMetricsResponse listMetricsResponse) {
        List<Metric> metrics = listMetricsResponse.getMetricsList() == null
            ? ImmutableList.<Metric>of() : Lists.transform(listMetricsResponse.getMetricsList(),
                Metric.fromPbFunction(serviceOptions.getService()));
        String cursor = listMetricsResponse.getNextPageToken().equals("") ? null
            : listMetricsResponse.getNextPageToken();
        return new AsyncPageImpl<>(new MetricPageFetcher(serviceOptions, cursor, options), cursor,
            metrics);
      }
    });
  }

  @Override
  public Page<Metric> listMetrics(ListOption... options) {
    return get(listMetricsAsync(options));
  }

  @Override
  public Future<AsyncPage<Metric>> listMetricsAsync(ListOption... options) {
    return listMetricsAsync(getOptions(), optionMap(options));
  }

  @Override
  public boolean deleteMetric(String metric) {
    return get(deleteMetricAsync(metric));
  }

  @Override
  public Future<Boolean> deleteMetricAsync(String metric) {
    DeleteLogMetricRequest request = DeleteLogMetricRequest.newBuilder()
        .setMetricName(MetricName.create(getOptions().getProjectId(), metric).toString())
        .build();
    return transform(rpc.delete(request), EMPTY_TO_BOOLEAN_FUNCTION);
  }

  private static WriteLogEntriesRequest writeLogEntriesRequest(LoggingOptions serviceOptions,
      Iterable<LogEntry> logEntries, Map<Option.OptionType, ?> options) {
    String projectId = serviceOptions.getProjectId();
    WriteLogEntriesRequest.Builder builder = WriteLogEntriesRequest.newBuilder();
    String logName = LOG_NAME.get(options);
    if (logName != null) {
      builder.setLogName(LogName.create(projectId, logName).toString());
    }
    MonitoredResource resource = RESOURCE.get(options);
    if (resource != null) {
      builder.setResource(resource.toPb());
    }
    Map<String, String> labels = LABELS.get(options);
    if (labels != null) {
      builder.putAllLabels(labels);
    }
    builder.addAllEntries(Iterables.transform(logEntries, LogEntry.toPbFunction(projectId)));
    return builder.build();
  }

  public void write(Iterable<LogEntry> logEntries, WriteOption... options) {
    get(writeAsync(logEntries, options));
  }

  public Future<Void> writeAsync(Iterable<LogEntry> logEntries, WriteOption... options) {
    return transform(
        rpc.write(writeLogEntriesRequest(getOptions(), logEntries, optionMap(options))),
        WRITE_RESPONSE_TO_VOID_FUNCTION);
  }

  private static ListLogEntriesRequest listLogEntriesRequest(LoggingOptions serviceOptions,
      Map<Option.OptionType, ?> options) {
    ListLogEntriesRequest.Builder builder = ListLogEntriesRequest.newBuilder();
    builder.addProjectIds(serviceOptions.getProjectId());
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
    String filter = FILTER.get(options);
    if (filter != null) {
      builder.setFilter(filter);
    }
    return builder.build();
  }

  private static Future<AsyncPage<LogEntry>> listLogEntriesAsync(
      final LoggingOptions serviceOptions, final Map<Option.OptionType, ?> options) {
    final ListLogEntriesRequest request = listLogEntriesRequest(serviceOptions, options);
    Future<ListLogEntriesResponse> list = serviceOptions.getRpc().list(request);
    return transform(list, new Function<ListLogEntriesResponse, AsyncPage<LogEntry>>() {
      @Override
      public AsyncPage<LogEntry> apply(ListLogEntriesResponse listLogEntrysResponse) {
        List<LogEntry> entries = listLogEntrysResponse.getEntriesList() == null
            ? ImmutableList.<LogEntry>of() : Lists.transform(listLogEntrysResponse.getEntriesList(),
            LogEntry.FROM_PB_FUNCTION);
        String cursor = listLogEntrysResponse.getNextPageToken().equals("") ? null
            : listLogEntrysResponse.getNextPageToken();
        return new AsyncPageImpl<>(new LogEntryPageFetcher(serviceOptions, cursor, options), cursor,
            entries);
      }
    });
  }

  @Override
  public Page<LogEntry> listLogEntries(EntryListOption... options) {
    return get(listLogEntriesAsync(options));
  }

  @Override
  public Future<AsyncPage<LogEntry>> listLogEntriesAsync(EntryListOption... options) {
    return listLogEntriesAsync(getOptions(), optionMap(options));
  }

  @Override
  public void close() throws Exception {
    if (closed) {
      return;
    }
    closed = true;
    rpc.close();
  }

  static <T extends Option.OptionType> Map<Option.OptionType, ?> optionMap(Option... options) {
    Map<Option.OptionType, Object> optionMap = Maps.newHashMap();
    for (Option option : options) {
      Object prev = optionMap.put(option.getOptionType(), option.getValue());
      checkArgument(prev == null, "Duplicate option %s", option);
    }
    return optionMap;
  }
}
