/*
 * Copyright 2016, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.logging.spi.v2;

import static com.google.cloud.logging.spi.v2.PagedResponseWrappers.ListLogMetricsPagedResponse;

import com.google.api.gax.grpc.ChannelAndExecutor;
import com.google.api.gax.grpc.UnaryCallable;
import com.google.logging.v2.CreateLogMetricRequest;
import com.google.logging.v2.DeleteLogMetricRequest;
import com.google.logging.v2.GetLogMetricRequest;
import com.google.logging.v2.ListLogMetricsRequest;
import com.google.logging.v2.ListLogMetricsResponse;
import com.google.logging.v2.LogMetric;
import com.google.logging.v2.MetricNameOneof;
import com.google.logging.v2.ParentNameOneof;
import com.google.logging.v2.UpdateLogMetricRequest;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Service for configuring logs-based metrics.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (MetricsServiceV2Client metricsServiceV2Client = MetricsServiceV2Client.create()) {
 *   MetricNameOneof metricName = MetricNameOneof.from(MetricName.create("[PROJECT]", "[METRIC]"));
 *   LogMetric response = metricsServiceV2Client.getLogMetric(metricName);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the metricsServiceV2Client object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li> A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li> A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of MetricsServiceV2Settings to
 * create(). For example:
 *
 * <pre>
 * <code>
 * InstantiatingChannelProvider channelProvider =
 *     MetricsServiceV2Settings.defaultChannelProviderBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MetricsServiceV2Settings metricsServiceV2Settings =
 *     MetricsServiceV2Settings.defaultBuilder().setChannelProvider(channelProvider).build();
 * MetricsServiceV2Client metricsServiceV2Client =
 *     MetricsServiceV2Client.create(metricsServiceV2Settings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC")
public class MetricsServiceV2Client implements AutoCloseable {
  private final MetricsServiceV2Settings settings;
  private final ScheduledExecutorService executor;
  private final ManagedChannel channel;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final UnaryCallable<ListLogMetricsRequest, ListLogMetricsResponse> listLogMetricsCallable;
  private final UnaryCallable<ListLogMetricsRequest, ListLogMetricsPagedResponse>
      listLogMetricsPagedCallable;
  private final UnaryCallable<GetLogMetricRequest, LogMetric> getLogMetricCallable;
  private final UnaryCallable<CreateLogMetricRequest, LogMetric> createLogMetricCallable;
  private final UnaryCallable<UpdateLogMetricRequest, LogMetric> updateLogMetricCallable;
  private final UnaryCallable<DeleteLogMetricRequest, Empty> deleteLogMetricCallable;

  /** Constructs an instance of MetricsServiceV2Client with default settings. */
  public static final MetricsServiceV2Client create() throws IOException {
    return create(MetricsServiceV2Settings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of MetricsServiceV2Client, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final MetricsServiceV2Client create(MetricsServiceV2Settings settings)
      throws IOException {
    return new MetricsServiceV2Client(settings);
  }

  /**
   * Constructs an instance of MetricsServiceV2Client, using the given settings. This is protected
   * so that it easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected MetricsServiceV2Client(MetricsServiceV2Settings settings) throws IOException {
    this.settings = settings;
    ChannelAndExecutor channelAndExecutor = settings.getChannelAndExecutor();
    this.executor = channelAndExecutor.getExecutor();
    this.channel = channelAndExecutor.getChannel();

    this.listLogMetricsCallable =
        UnaryCallable.create(settings.listLogMetricsSettings(), this.channel, this.executor);
    this.listLogMetricsPagedCallable =
        UnaryCallable.createPagedVariant(
            settings.listLogMetricsSettings(), this.channel, this.executor);
    this.getLogMetricCallable =
        UnaryCallable.create(settings.getLogMetricSettings(), this.channel, this.executor);
    this.createLogMetricCallable =
        UnaryCallable.create(settings.createLogMetricSettings(), this.channel, this.executor);
    this.updateLogMetricCallable =
        UnaryCallable.create(settings.updateLogMetricSettings(), this.channel, this.executor);
    this.deleteLogMetricCallable =
        UnaryCallable.create(settings.deleteLogMetricSettings(), this.channel, this.executor);

    if (settings.getChannelProvider().shouldAutoClose()) {
      closeables.add(
          new Closeable() {
            @Override
            public void close() throws IOException {
              channel.shutdown();
            }
          });
    }
    if (settings.getExecutorProvider().shouldAutoClose()) {
      closeables.add(
          new Closeable() {
            @Override
            public void close() throws IOException {
              executor.shutdown();
            }
          });
    }
  }

  public final MetricsServiceV2Settings getSettings() {
    return settings;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists logs-based metrics.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricsServiceV2Client metricsServiceV2Client = MetricsServiceV2Client.create()) {
   *   ParentNameOneof parent = ParentNameOneof.from(ProjectName.create("[PROJECT]"));
   *   for (LogMetric element : metricsServiceV2Client.listLogMetrics(parent).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the project containing the metrics:
   *     <p>"projects/[PROJECT_ID]"
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final ListLogMetricsPagedResponse listLogMetrics(ParentNameOneof parent) {
    ListLogMetricsRequest request =
        ListLogMetricsRequest.newBuilder().setParentWithParentNameOneof(parent).build();
    return listLogMetrics(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists logs-based metrics.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricsServiceV2Client metricsServiceV2Client = MetricsServiceV2Client.create()) {
   *   ParentNameOneof parent = ParentNameOneof.from(ProjectName.create("[PROJECT]"));
   *   ListLogMetricsRequest request = ListLogMetricsRequest.newBuilder()
   *     .setParentWithParentNameOneof(parent)
   *     .build();
   *   for (LogMetric element : metricsServiceV2Client.listLogMetrics(request).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final ListLogMetricsPagedResponse listLogMetrics(ListLogMetricsRequest request) {
    return listLogMetricsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists logs-based metrics.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricsServiceV2Client metricsServiceV2Client = MetricsServiceV2Client.create()) {
   *   ParentNameOneof parent = ParentNameOneof.from(ProjectName.create("[PROJECT]"));
   *   ListLogMetricsRequest request = ListLogMetricsRequest.newBuilder()
   *     .setParentWithParentNameOneof(parent)
   *     .build();
   *   RpcFuture&lt;ListLogMetricsPagedResponse&gt; future = metricsServiceV2Client.listLogMetricsPagedCallable().futureCall(request);
   *   // Do something
   *   for (LogMetric element : future.get().iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListLogMetricsRequest, ListLogMetricsPagedResponse>
      listLogMetricsPagedCallable() {
    return listLogMetricsPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists logs-based metrics.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricsServiceV2Client metricsServiceV2Client = MetricsServiceV2Client.create()) {
   *   ParentNameOneof parent = ParentNameOneof.from(ProjectName.create("[PROJECT]"));
   *   ListLogMetricsRequest request = ListLogMetricsRequest.newBuilder()
   *     .setParentWithParentNameOneof(parent)
   *     .build();
   *   while (true) {
   *     ListLogMetricsResponse response = metricsServiceV2Client.listLogMetricsCallable().call(request);
   *     for (LogMetric element : response.getMetricsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListLogMetricsRequest, ListLogMetricsResponse>
      listLogMetricsCallable() {
    return listLogMetricsCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricsServiceV2Client metricsServiceV2Client = MetricsServiceV2Client.create()) {
   *   MetricNameOneof metricName = MetricNameOneof.from(MetricName.create("[PROJECT]", "[METRIC]"));
   *   LogMetric response = metricsServiceV2Client.getLogMetric(metricName);
   * }
   * </code></pre>
   *
   * @param metricName The resource name of the desired metric:
   *     <p>"projects/[PROJECT_ID]/metrics/[METRIC_ID]"
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final LogMetric getLogMetric(MetricNameOneof metricName) {

    GetLogMetricRequest request =
        GetLogMetricRequest.newBuilder().setMetricNameWithMetricNameOneof(metricName).build();
    return getLogMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricsServiceV2Client metricsServiceV2Client = MetricsServiceV2Client.create()) {
   *   MetricNameOneof metricName = MetricNameOneof.from(MetricName.create("[PROJECT]", "[METRIC]"));
   *   GetLogMetricRequest request = GetLogMetricRequest.newBuilder()
   *     .setMetricNameWithMetricNameOneof(metricName)
   *     .build();
   *   LogMetric response = metricsServiceV2Client.getLogMetric(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private final LogMetric getLogMetric(GetLogMetricRequest request) {
    return getLogMetricCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricsServiceV2Client metricsServiceV2Client = MetricsServiceV2Client.create()) {
   *   MetricNameOneof metricName = MetricNameOneof.from(MetricName.create("[PROJECT]", "[METRIC]"));
   *   GetLogMetricRequest request = GetLogMetricRequest.newBuilder()
   *     .setMetricNameWithMetricNameOneof(metricName)
   *     .build();
   *   RpcFuture&lt;LogMetric&gt; future = metricsServiceV2Client.getLogMetricCallable().futureCall(request);
   *   // Do something
   *   LogMetric response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetLogMetricRequest, LogMetric> getLogMetricCallable() {
    return getLogMetricCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricsServiceV2Client metricsServiceV2Client = MetricsServiceV2Client.create()) {
   *   ParentNameOneof parent = ParentNameOneof.from(ProjectName.create("[PROJECT]"));
   *   LogMetric metric = LogMetric.newBuilder().build();
   *   LogMetric response = metricsServiceV2Client.createLogMetric(parent, metric);
   * }
   * </code></pre>
   *
   * @param parent The resource name of the project in which to create the metric:
   *     <p>"projects/[PROJECT_ID]"
   *     <p>The new metric must be provided in the request.
   * @param metric The new logs-based metric, which must not have an identifier that already exists.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final LogMetric createLogMetric(ParentNameOneof parent, LogMetric metric) {

    CreateLogMetricRequest request =
        CreateLogMetricRequest.newBuilder()
            .setParentWithParentNameOneof(parent)
            .setMetric(metric)
            .build();
    return createLogMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricsServiceV2Client metricsServiceV2Client = MetricsServiceV2Client.create()) {
   *   ParentNameOneof parent = ParentNameOneof.from(ProjectName.create("[PROJECT]"));
   *   LogMetric metric = LogMetric.newBuilder().build();
   *   CreateLogMetricRequest request = CreateLogMetricRequest.newBuilder()
   *     .setParentWithParentNameOneof(parent)
   *     .setMetric(metric)
   *     .build();
   *   LogMetric response = metricsServiceV2Client.createLogMetric(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final LogMetric createLogMetric(CreateLogMetricRequest request) {
    return createLogMetricCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricsServiceV2Client metricsServiceV2Client = MetricsServiceV2Client.create()) {
   *   ParentNameOneof parent = ParentNameOneof.from(ProjectName.create("[PROJECT]"));
   *   LogMetric metric = LogMetric.newBuilder().build();
   *   CreateLogMetricRequest request = CreateLogMetricRequest.newBuilder()
   *     .setParentWithParentNameOneof(parent)
   *     .setMetric(metric)
   *     .build();
   *   RpcFuture&lt;LogMetric&gt; future = metricsServiceV2Client.createLogMetricCallable().futureCall(request);
   *   // Do something
   *   LogMetric response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateLogMetricRequest, LogMetric> createLogMetricCallable() {
    return createLogMetricCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates or updates a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricsServiceV2Client metricsServiceV2Client = MetricsServiceV2Client.create()) {
   *   MetricNameOneof metricName = MetricNameOneof.from(MetricName.create("[PROJECT]", "[METRIC]"));
   *   LogMetric metric = LogMetric.newBuilder().build();
   *   LogMetric response = metricsServiceV2Client.updateLogMetric(metricName, metric);
   * }
   * </code></pre>
   *
   * @param metricName The resource name of the metric to update:
   *     <p>"projects/[PROJECT_ID]/metrics/[METRIC_ID]"
   *     <p>The updated metric must be provided in the request and it's `name` field must be the
   *     same as `[METRIC_ID]` If the metric does not exist in `[PROJECT_ID]`, then a new metric is
   *     created.
   * @param metric The updated metric.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final LogMetric updateLogMetric(MetricNameOneof metricName, LogMetric metric) {

    UpdateLogMetricRequest request =
        UpdateLogMetricRequest.newBuilder()
            .setMetricNameWithMetricNameOneof(metricName)
            .setMetric(metric)
            .build();
    return updateLogMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates or updates a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricsServiceV2Client metricsServiceV2Client = MetricsServiceV2Client.create()) {
   *   MetricNameOneof metricName = MetricNameOneof.from(MetricName.create("[PROJECT]", "[METRIC]"));
   *   LogMetric metric = LogMetric.newBuilder().build();
   *   UpdateLogMetricRequest request = UpdateLogMetricRequest.newBuilder()
   *     .setMetricNameWithMetricNameOneof(metricName)
   *     .setMetric(metric)
   *     .build();
   *   LogMetric response = metricsServiceV2Client.updateLogMetric(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final LogMetric updateLogMetric(UpdateLogMetricRequest request) {
    return updateLogMetricCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates or updates a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricsServiceV2Client metricsServiceV2Client = MetricsServiceV2Client.create()) {
   *   MetricNameOneof metricName = MetricNameOneof.from(MetricName.create("[PROJECT]", "[METRIC]"));
   *   LogMetric metric = LogMetric.newBuilder().build();
   *   UpdateLogMetricRequest request = UpdateLogMetricRequest.newBuilder()
   *     .setMetricNameWithMetricNameOneof(metricName)
   *     .setMetric(metric)
   *     .build();
   *   RpcFuture&lt;LogMetric&gt; future = metricsServiceV2Client.updateLogMetricCallable().futureCall(request);
   *   // Do something
   *   LogMetric response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateLogMetricRequest, LogMetric> updateLogMetricCallable() {
    return updateLogMetricCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricsServiceV2Client metricsServiceV2Client = MetricsServiceV2Client.create()) {
   *   MetricNameOneof metricName = MetricNameOneof.from(MetricName.create("[PROJECT]", "[METRIC]"));
   *   metricsServiceV2Client.deleteLogMetric(metricName);
   * }
   * </code></pre>
   *
   * @param metricName The resource name of the metric to delete:
   *     <p>"projects/[PROJECT_ID]/metrics/[METRIC_ID]"
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void deleteLogMetric(MetricNameOneof metricName) {

    DeleteLogMetricRequest request =
        DeleteLogMetricRequest.newBuilder().setMetricNameWithMetricNameOneof(metricName).build();
    deleteLogMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricsServiceV2Client metricsServiceV2Client = MetricsServiceV2Client.create()) {
   *   MetricNameOneof metricName = MetricNameOneof.from(MetricName.create("[PROJECT]", "[METRIC]"));
   *   DeleteLogMetricRequest request = DeleteLogMetricRequest.newBuilder()
   *     .setMetricNameWithMetricNameOneof(metricName)
   *     .build();
   *   metricsServiceV2Client.deleteLogMetric(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private final void deleteLogMetric(DeleteLogMetricRequest request) {
    deleteLogMetricCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricsServiceV2Client metricsServiceV2Client = MetricsServiceV2Client.create()) {
   *   MetricNameOneof metricName = MetricNameOneof.from(MetricName.create("[PROJECT]", "[METRIC]"));
   *   DeleteLogMetricRequest request = DeleteLogMetricRequest.newBuilder()
   *     .setMetricNameWithMetricNameOneof(metricName)
   *     .build();
   *   RpcFuture&lt;Void&gt; future = metricsServiceV2Client.deleteLogMetricCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteLogMetricRequest, Empty> deleteLogMetricCallable() {
    return deleteLogMetricCallable;
  }

  /**
   * Initiates an orderly shutdown in which preexisting calls continue but new calls are immediately
   * cancelled.
   */
  @Override
  public final void close() throws Exception {
    for (AutoCloseable closeable : closeables) {
      closeable.close();
    }
  }
}
