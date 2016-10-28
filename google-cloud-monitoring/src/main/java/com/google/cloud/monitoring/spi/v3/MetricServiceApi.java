/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cloud.monitoring.spi.v3;

import com.google.api.MetricDescriptor;
import com.google.api.MonitoredResourceDescriptor;
import com.google.api.gax.core.PagedListResponse;
import com.google.api.gax.grpc.ApiCallable;
import com.google.api.gax.protobuf.PathTemplate;
import com.google.monitoring.v3.CreateMetricDescriptorRequest;
import com.google.monitoring.v3.CreateTimeSeriesRequest;
import com.google.monitoring.v3.DeleteMetricDescriptorRequest;
import com.google.monitoring.v3.GetMetricDescriptorRequest;
import com.google.monitoring.v3.GetMonitoredResourceDescriptorRequest;
import com.google.monitoring.v3.ListMetricDescriptorsRequest;
import com.google.monitoring.v3.ListMetricDescriptorsResponse;
import com.google.monitoring.v3.ListMonitoredResourceDescriptorsRequest;
import com.google.monitoring.v3.ListMonitoredResourceDescriptorsResponse;
import com.google.monitoring.v3.ListTimeSeriesRequest;
import com.google.monitoring.v3.ListTimeSeriesResponse;
import com.google.monitoring.v3.TimeSeries;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Manages metric descriptors, monitored resource descriptors, and time series
 * data.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
 *   String formattedName = MetricServiceApi.formatMonitoredResourceDescriptorName("[PROJECT]", "[MONITORED_RESOURCE_DESCRIPTOR]");
 *   MonitoredResourceDescriptor response = metricServiceApi.getMonitoredResourceDescriptor(formattedName);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the metricServiceApi object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
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
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable
 *       ApiCallable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of MetricServiceSettings to
 * create(). For example:
 *
 * <pre>
 * <code>
 * MetricServiceSettings metricServiceSettings = MetricServiceSettings.defaultBuilder()
 *     .provideChannelWith(myCredentials)
 *     .build();
 * MetricServiceApi metricServiceApi = MetricServiceApi.create(metricServiceSettings);
 * </code>
 * </pre>
 */
@javax.annotation.Generated("by GAPIC")
public class MetricServiceApi implements AutoCloseable {
  private final MetricServiceSettings settings;
  private final ManagedChannel channel;
  private final ScheduledExecutorService executor;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final ApiCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse>
      listMonitoredResourceDescriptorsCallable;
  private final ApiCallable<
          ListMonitoredResourceDescriptorsRequest,
          PagedListResponse<
              ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
              MonitoredResourceDescriptor>>
      listMonitoredResourceDescriptorsPagedCallable;
  private final ApiCallable<GetMonitoredResourceDescriptorRequest, MonitoredResourceDescriptor>
      getMonitoredResourceDescriptorCallable;
  private final ApiCallable<ListMetricDescriptorsRequest, ListMetricDescriptorsResponse>
      listMetricDescriptorsCallable;
  private final ApiCallable<
          ListMetricDescriptorsRequest,
          PagedListResponse<
              ListMetricDescriptorsRequest, ListMetricDescriptorsResponse, MetricDescriptor>>
      listMetricDescriptorsPagedCallable;
  private final ApiCallable<GetMetricDescriptorRequest, MetricDescriptor>
      getMetricDescriptorCallable;
  private final ApiCallable<CreateMetricDescriptorRequest, MetricDescriptor>
      createMetricDescriptorCallable;
  private final ApiCallable<DeleteMetricDescriptorRequest, Empty> deleteMetricDescriptorCallable;
  private final ApiCallable<ListTimeSeriesRequest, ListTimeSeriesResponse> listTimeSeriesCallable;
  private final ApiCallable<
          ListTimeSeriesRequest,
          PagedListResponse<ListTimeSeriesRequest, ListTimeSeriesResponse, TimeSeries>>
      listTimeSeriesPagedCallable;
  private final ApiCallable<CreateTimeSeriesRequest, Empty> createTimeSeriesCallable;

  private static final PathTemplate PROJECT_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}");

  private static final PathTemplate METRIC_DESCRIPTOR_PATH_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/metricDescriptors/{metric_descriptor_path=**}");

  private static final PathTemplate MONITORED_RESOURCE_DESCRIPTOR_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/monitoredResourceDescriptors/{monitored_resource_descriptor}");

  /** Formats a string containing the fully-qualified path to represent a project resource. */
  public static final String formatProjectName(String project) {
    return PROJECT_PATH_TEMPLATE.instantiate("project", project);
  }

  /**
   * Formats a string containing the fully-qualified path to represent a metric_descriptor_path
   * resource.
   */
  public static final String formatMetricDescriptorPathName(
      String project, String metricDescriptorPath) {
    return METRIC_DESCRIPTOR_PATH_PATH_TEMPLATE.instantiate(
        "project", project,
        "metric_descriptor_path", metricDescriptorPath);
  }

  /**
   * Formats a string containing the fully-qualified path to represent a
   * monitored_resource_descriptor resource.
   */
  public static final String formatMonitoredResourceDescriptorName(
      String project, String monitoredResourceDescriptor) {
    return MONITORED_RESOURCE_DESCRIPTOR_PATH_TEMPLATE.instantiate(
        "project", project,
        "monitored_resource_descriptor", monitoredResourceDescriptor);
  }

  /** Parses the project from the given fully-qualified path which represents a project resource. */
  public static final String parseProjectFromProjectName(String projectName) {
    return PROJECT_PATH_TEMPLATE.parse(projectName).get("project");
  }

  /**
   * Parses the project from the given fully-qualified path which represents a metricDescriptorPath
   * resource.
   */
  public static final String parseProjectFromMetricDescriptorPathName(
      String metricDescriptorPathName) {
    return METRIC_DESCRIPTOR_PATH_PATH_TEMPLATE.parse(metricDescriptorPathName).get("project");
  }

  /**
   * Parses the metric_descriptor_path from the given fully-qualified path which represents a
   * metricDescriptorPath resource.
   */
  public static final String parseMetricDescriptorPathFromMetricDescriptorPathName(
      String metricDescriptorPathName) {
    return METRIC_DESCRIPTOR_PATH_PATH_TEMPLATE
        .parse(metricDescriptorPathName)
        .get("metric_descriptor_path");
  }

  /**
   * Parses the project from the given fully-qualified path which represents a
   * monitoredResourceDescriptor resource.
   */
  public static final String parseProjectFromMonitoredResourceDescriptorName(
      String monitoredResourceDescriptorName) {
    return MONITORED_RESOURCE_DESCRIPTOR_PATH_TEMPLATE
        .parse(monitoredResourceDescriptorName)
        .get("project");
  }

  /**
   * Parses the monitored_resource_descriptor from the given fully-qualified path which represents a
   * monitoredResourceDescriptor resource.
   */
  public static final String parseMonitoredResourceDescriptorFromMonitoredResourceDescriptorName(
      String monitoredResourceDescriptorName) {
    return MONITORED_RESOURCE_DESCRIPTOR_PATH_TEMPLATE
        .parse(monitoredResourceDescriptorName)
        .get("monitored_resource_descriptor");
  }

  /** Constructs an instance of MetricServiceApi with default settings. */
  public static final MetricServiceApi create() throws IOException {
    return create(MetricServiceSettings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of MetricServiceApi, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final MetricServiceApi create(MetricServiceSettings settings) throws IOException {
    return new MetricServiceApi(settings);
  }

  /**
   * Constructs an instance of MetricServiceApi, using the given settings. This is protected so that
   * it easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected MetricServiceApi(MetricServiceSettings settings) throws IOException {
    this.settings = settings;
    this.executor = settings.getExecutorProvider().getOrBuildExecutor();
    this.channel = settings.getChannelProvider().getOrBuildChannel(this.executor);

    this.listMonitoredResourceDescriptorsCallable =
        ApiCallable.create(
            settings.listMonitoredResourceDescriptorsSettings(), this.channel, this.executor);
    this.listMonitoredResourceDescriptorsPagedCallable =
        ApiCallable.createPagedVariant(
            settings.listMonitoredResourceDescriptorsSettings(), this.channel, this.executor);
    this.getMonitoredResourceDescriptorCallable =
        ApiCallable.create(
            settings.getMonitoredResourceDescriptorSettings(), this.channel, this.executor);
    this.listMetricDescriptorsCallable =
        ApiCallable.create(settings.listMetricDescriptorsSettings(), this.channel, this.executor);
    this.listMetricDescriptorsPagedCallable =
        ApiCallable.createPagedVariant(
            settings.listMetricDescriptorsSettings(), this.channel, this.executor);
    this.getMetricDescriptorCallable =
        ApiCallable.create(settings.getMetricDescriptorSettings(), this.channel, this.executor);
    this.createMetricDescriptorCallable =
        ApiCallable.create(settings.createMetricDescriptorSettings(), this.channel, this.executor);
    this.deleteMetricDescriptorCallable =
        ApiCallable.create(settings.deleteMetricDescriptorSettings(), this.channel, this.executor);
    this.listTimeSeriesCallable =
        ApiCallable.create(settings.listTimeSeriesSettings(), this.channel, this.executor);
    this.listTimeSeriesPagedCallable =
        ApiCallable.createPagedVariant(
            settings.listTimeSeriesSettings(), this.channel, this.executor);
    this.createTimeSeriesCallable =
        ApiCallable.create(settings.createTimeSeriesSettings(), this.channel, this.executor);

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

  public final MetricServiceSettings getSettings() {
    return settings;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists monitored resource descriptors that match a filter. This method does not require a
   * Stackdriver account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatProjectName("[PROJECT]");
   *   String filter = "";
   *   for (MonitoredResourceDescriptor element : metricServiceApi.listMonitoredResourceDescriptors(formattedName, filter).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param name The project on which to execute the request. The format is
   *     `"projects/{project_id_or_number}"`.
   * @param filter An optional [filter](/monitoring/api/v3/filters) describing the descriptors to be
   *     returned. The filter can reference the descriptor's type and labels. For example, the
   *     following filter returns only Google Compute Engine descriptors that have an `id` label:
   *     <p>resource.type = starts_with("gce_") AND resource.label:id
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PagedListResponse<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
          MonitoredResourceDescriptor>
      listMonitoredResourceDescriptors(String name, String filter) {
    PROJECT_PATH_TEMPLATE.validate(name, "listMonitoredResourceDescriptors");
    ListMonitoredResourceDescriptorsRequest request =
        ListMonitoredResourceDescriptorsRequest.newBuilder()
            .setName(name)
            .setFilter(filter)
            .build();
    return listMonitoredResourceDescriptors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists monitored resource descriptors that match a filter. This method does not require a
   * Stackdriver account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatProjectName("[PROJECT]");
   *   String filter = "";
   *   ListMonitoredResourceDescriptorsRequest request = ListMonitoredResourceDescriptorsRequest.newBuilder()
   *     .setName(formattedName)
   *     .setFilter(filter)
   *     .build();
   *   for (MonitoredResourceDescriptor element : metricServiceApi.listMonitoredResourceDescriptors(request).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PagedListResponse<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
          MonitoredResourceDescriptor>
      listMonitoredResourceDescriptors(ListMonitoredResourceDescriptorsRequest request) {
    return listMonitoredResourceDescriptorsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists monitored resource descriptors that match a filter. This method does not require a
   * Stackdriver account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatProjectName("[PROJECT]");
   *   String filter = "";
   *   ListMonitoredResourceDescriptorsRequest request = ListMonitoredResourceDescriptorsRequest.newBuilder()
   *     .setName(formattedName)
   *     .setFilter(filter)
   *     .build();
   *   ListenableFuture&lt;PagedListResponse&lt;ListMonitoredResourceDescriptorsRequest,ListMonitoredResourceDescriptorsResponse,MonitoredResourceDescriptor&gt;&gt; future = metricServiceApi.listMonitoredResourceDescriptorsPagedCallable().futureCall(request);
   *   // Do something
   *   for (MonitoredResourceDescriptor element : future.get().iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final ApiCallable<
          ListMonitoredResourceDescriptorsRequest,
          PagedListResponse<
              ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
              MonitoredResourceDescriptor>>
      listMonitoredResourceDescriptorsPagedCallable() {
    return listMonitoredResourceDescriptorsPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists monitored resource descriptors that match a filter. This method does not require a
   * Stackdriver account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatProjectName("[PROJECT]");
   *   String filter = "";
   *   ListMonitoredResourceDescriptorsRequest request = ListMonitoredResourceDescriptorsRequest.newBuilder()
   *     .setName(formattedName)
   *     .setFilter(filter)
   *     .build();
   *   while (true) {
   *     ListMonitoredResourceDescriptorsResponse response = metricServiceApi.listMonitoredResourceDescriptorsCallable().call(request);
   *     for (MonitoredResourceDescriptor element : response.getResourceDescriptorsList()) {
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
  public final ApiCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse>
      listMonitoredResourceDescriptorsCallable() {
    return listMonitoredResourceDescriptorsCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a single monitored resource descriptor. This method does not require a Stackdriver
   * account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatMonitoredResourceDescriptorName("[PROJECT]", "[MONITORED_RESOURCE_DESCRIPTOR]");
   *   MonitoredResourceDescriptor response = metricServiceApi.getMonitoredResourceDescriptor(formattedName);
   * }
   * </code></pre>
   *
   * @param name The monitored resource descriptor to get. The format is
   *     `"projects/{project_id_or_number}/monitoredResourceDescriptors/{resource_type}"`. The
   *     `{resource_type}` is a predefined type, such as `cloudsql_database`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final MonitoredResourceDescriptor getMonitoredResourceDescriptor(String name) {
    MONITORED_RESOURCE_DESCRIPTOR_PATH_TEMPLATE.validate(name, "getMonitoredResourceDescriptor");
    GetMonitoredResourceDescriptorRequest request =
        GetMonitoredResourceDescriptorRequest.newBuilder().setName(name).build();
    return getMonitoredResourceDescriptor(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a single monitored resource descriptor. This method does not require a Stackdriver
   * account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatMonitoredResourceDescriptorName("[PROJECT]", "[MONITORED_RESOURCE_DESCRIPTOR]");
   *   GetMonitoredResourceDescriptorRequest request = GetMonitoredResourceDescriptorRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   MonitoredResourceDescriptor response = metricServiceApi.getMonitoredResourceDescriptor(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private final MonitoredResourceDescriptor getMonitoredResourceDescriptor(
      GetMonitoredResourceDescriptorRequest request) {
    return getMonitoredResourceDescriptorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a single monitored resource descriptor. This method does not require a Stackdriver
   * account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatMonitoredResourceDescriptorName("[PROJECT]", "[MONITORED_RESOURCE_DESCRIPTOR]");
   *   GetMonitoredResourceDescriptorRequest request = GetMonitoredResourceDescriptorRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ListenableFuture&lt;MonitoredResourceDescriptor&gt; future = metricServiceApi.getMonitoredResourceDescriptorCallable().futureCall(request);
   *   // Do something
   *   MonitoredResourceDescriptor response = future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<GetMonitoredResourceDescriptorRequest, MonitoredResourceDescriptor>
      getMonitoredResourceDescriptorCallable() {
    return getMonitoredResourceDescriptorCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists metric descriptors that match a filter. This method does not require a Stackdriver
   * account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatProjectName("[PROJECT]");
   *   String filter = "";
   *   for (MetricDescriptor element : metricServiceApi.listMetricDescriptors(formattedName, filter).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param name The project on which to execute the request. The format is
   *     `"projects/{project_id_or_number}"`.
   * @param filter If this field is empty, all custom and system-defined metric descriptors are
   *     returned. Otherwise, the [filter](/monitoring/api/v3/filters) specifies which metric
   *     descriptors are to be returned. For example, the following filter matches all [custom
   *     metrics](/monitoring/custom-metrics):
   *     <p>metric.type = starts_with("custom.googleapis.com/")
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PagedListResponse<
          ListMetricDescriptorsRequest, ListMetricDescriptorsResponse, MetricDescriptor>
      listMetricDescriptors(String name, String filter) {
    PROJECT_PATH_TEMPLATE.validate(name, "listMetricDescriptors");
    ListMetricDescriptorsRequest request =
        ListMetricDescriptorsRequest.newBuilder().setName(name).setFilter(filter).build();
    return listMetricDescriptors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists metric descriptors that match a filter. This method does not require a Stackdriver
   * account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatProjectName("[PROJECT]");
   *   String filter = "";
   *   ListMetricDescriptorsRequest request = ListMetricDescriptorsRequest.newBuilder()
   *     .setName(formattedName)
   *     .setFilter(filter)
   *     .build();
   *   for (MetricDescriptor element : metricServiceApi.listMetricDescriptors(request).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PagedListResponse<
          ListMetricDescriptorsRequest, ListMetricDescriptorsResponse, MetricDescriptor>
      listMetricDescriptors(ListMetricDescriptorsRequest request) {
    return listMetricDescriptorsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists metric descriptors that match a filter. This method does not require a Stackdriver
   * account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatProjectName("[PROJECT]");
   *   String filter = "";
   *   ListMetricDescriptorsRequest request = ListMetricDescriptorsRequest.newBuilder()
   *     .setName(formattedName)
   *     .setFilter(filter)
   *     .build();
   *   ListenableFuture&lt;PagedListResponse&lt;ListMetricDescriptorsRequest,ListMetricDescriptorsResponse,MetricDescriptor&gt;&gt; future = metricServiceApi.listMetricDescriptorsPagedCallable().futureCall(request);
   *   // Do something
   *   for (MetricDescriptor element : future.get().iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final ApiCallable<
          ListMetricDescriptorsRequest,
          PagedListResponse<
              ListMetricDescriptorsRequest, ListMetricDescriptorsResponse, MetricDescriptor>>
      listMetricDescriptorsPagedCallable() {
    return listMetricDescriptorsPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists metric descriptors that match a filter. This method does not require a Stackdriver
   * account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatProjectName("[PROJECT]");
   *   String filter = "";
   *   ListMetricDescriptorsRequest request = ListMetricDescriptorsRequest.newBuilder()
   *     .setName(formattedName)
   *     .setFilter(filter)
   *     .build();
   *   while (true) {
   *     ListMetricDescriptorsResponse response = metricServiceApi.listMetricDescriptorsCallable().call(request);
   *     for (MetricDescriptor element : response.getMetricDescriptorsList()) {
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
  public final ApiCallable<ListMetricDescriptorsRequest, ListMetricDescriptorsResponse>
      listMetricDescriptorsCallable() {
    return listMetricDescriptorsCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a single metric descriptor. This method does not require a Stackdriver account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatMetricDescriptorPathName("[PROJECT]", "[METRIC_DESCRIPTOR_PATH]");
   *   MetricDescriptor response = metricServiceApi.getMetricDescriptor(formattedName);
   * }
   * </code></pre>
   *
   * @param name The metric descriptor on which to execute the request. The format is
   *     `"projects/{project_id_or_number}/metricDescriptors/{metric_id}"`. An example value of
   *     `{metric_id}` is `"compute.googleapis.com/instance/disk/read_bytes_count"`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final MetricDescriptor getMetricDescriptor(String name) {
    METRIC_DESCRIPTOR_PATH_PATH_TEMPLATE.validate(name, "getMetricDescriptor");
    GetMetricDescriptorRequest request =
        GetMetricDescriptorRequest.newBuilder().setName(name).build();
    return getMetricDescriptor(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a single metric descriptor. This method does not require a Stackdriver account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatMetricDescriptorPathName("[PROJECT]", "[METRIC_DESCRIPTOR_PATH]");
   *   GetMetricDescriptorRequest request = GetMetricDescriptorRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   MetricDescriptor response = metricServiceApi.getMetricDescriptor(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private final MetricDescriptor getMetricDescriptor(GetMetricDescriptorRequest request) {
    return getMetricDescriptorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a single metric descriptor. This method does not require a Stackdriver account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatMetricDescriptorPathName("[PROJECT]", "[METRIC_DESCRIPTOR_PATH]");
   *   GetMetricDescriptorRequest request = GetMetricDescriptorRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ListenableFuture&lt;MetricDescriptor&gt; future = metricServiceApi.getMetricDescriptorCallable().futureCall(request);
   *   // Do something
   *   MetricDescriptor response = future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<GetMetricDescriptorRequest, MetricDescriptor>
      getMetricDescriptorCallable() {
    return getMetricDescriptorCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new metric descriptor. User-created metric descriptors define [custom
   * metrics](/monitoring/custom-metrics).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatProjectName("[PROJECT]");
   *   MetricDescriptor metricDescriptor = MetricDescriptor.newBuilder().build();
   *   MetricDescriptor response = metricServiceApi.createMetricDescriptor(formattedName, metricDescriptor);
   * }
   * </code></pre>
   *
   * @param name The project on which to execute the request. The format is
   *     `"projects/{project_id_or_number}"`.
   * @param metricDescriptor The new [custom metric](/monitoring/custom-metrics) descriptor.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final MetricDescriptor createMetricDescriptor(
      String name, MetricDescriptor metricDescriptor) {
    PROJECT_PATH_TEMPLATE.validate(name, "createMetricDescriptor");
    CreateMetricDescriptorRequest request =
        CreateMetricDescriptorRequest.newBuilder()
            .setName(name)
            .setMetricDescriptor(metricDescriptor)
            .build();
    return createMetricDescriptor(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new metric descriptor. User-created metric descriptors define [custom
   * metrics](/monitoring/custom-metrics).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatProjectName("[PROJECT]");
   *   MetricDescriptor metricDescriptor = MetricDescriptor.newBuilder().build();
   *   CreateMetricDescriptorRequest request = CreateMetricDescriptorRequest.newBuilder()
   *     .setName(formattedName)
   *     .setMetricDescriptor(metricDescriptor)
   *     .build();
   *   MetricDescriptor response = metricServiceApi.createMetricDescriptor(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final MetricDescriptor createMetricDescriptor(CreateMetricDescriptorRequest request) {
    return createMetricDescriptorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new metric descriptor. User-created metric descriptors define [custom
   * metrics](/monitoring/custom-metrics).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatProjectName("[PROJECT]");
   *   MetricDescriptor metricDescriptor = MetricDescriptor.newBuilder().build();
   *   CreateMetricDescriptorRequest request = CreateMetricDescriptorRequest.newBuilder()
   *     .setName(formattedName)
   *     .setMetricDescriptor(metricDescriptor)
   *     .build();
   *   ListenableFuture&lt;MetricDescriptor&gt; future = metricServiceApi.createMetricDescriptorCallable().futureCall(request);
   *   // Do something
   *   MetricDescriptor response = future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<CreateMetricDescriptorRequest, MetricDescriptor>
      createMetricDescriptorCallable() {
    return createMetricDescriptorCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a metric descriptor. Only user-created [custom metrics](/monitoring/custom-metrics) can
   * be deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatMetricDescriptorPathName("[PROJECT]", "[METRIC_DESCRIPTOR_PATH]");
   *   metricServiceApi.deleteMetricDescriptor(formattedName);
   * }
   * </code></pre>
   *
   * @param name The metric descriptor on which to execute the request. The format is
   *     `"projects/{project_id_or_number}/metricDescriptors/{metric_id}"`. An example of
   *     `{metric_id}` is: `"custom.googleapis.com/my_test_metric"`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void deleteMetricDescriptor(String name) {
    METRIC_DESCRIPTOR_PATH_PATH_TEMPLATE.validate(name, "deleteMetricDescriptor");
    DeleteMetricDescriptorRequest request =
        DeleteMetricDescriptorRequest.newBuilder().setName(name).build();
    deleteMetricDescriptor(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a metric descriptor. Only user-created [custom metrics](/monitoring/custom-metrics) can
   * be deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatMetricDescriptorPathName("[PROJECT]", "[METRIC_DESCRIPTOR_PATH]");
   *   DeleteMetricDescriptorRequest request = DeleteMetricDescriptorRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   metricServiceApi.deleteMetricDescriptor(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private final void deleteMetricDescriptor(DeleteMetricDescriptorRequest request) {
    deleteMetricDescriptorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a metric descriptor. Only user-created [custom metrics](/monitoring/custom-metrics) can
   * be deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatMetricDescriptorPathName("[PROJECT]", "[METRIC_DESCRIPTOR_PATH]");
   *   DeleteMetricDescriptorRequest request = DeleteMetricDescriptorRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ListenableFuture&lt;Void&gt; future = metricServiceApi.deleteMetricDescriptorCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<DeleteMetricDescriptorRequest, Empty> deleteMetricDescriptorCallable() {
    return deleteMetricDescriptorCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists time series that match a filter. This method does not require a Stackdriver account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatProjectName("[PROJECT]");
   *   String filter = "";
   *   TimeInterval interval = TimeInterval.newBuilder().build();
   *   Aggregation aggregation = Aggregation.newBuilder().build();
   *   String orderBy = "";
   *   ListTimeSeriesRequest.TimeSeriesView view = ListTimeSeriesRequest.TimeSeriesView.FULL;
   *   ListTimeSeriesRequest request = ListTimeSeriesRequest.newBuilder()
   *     .setName(formattedName)
   *     .setFilter(filter)
   *     .setInterval(interval)
   *     .setAggregation(aggregation)
   *     .setOrderBy(orderBy)
   *     .setView(view)
   *     .build();
   *   for (TimeSeries element : metricServiceApi.listTimeSeries(request).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PagedListResponse<ListTimeSeriesRequest, ListTimeSeriesResponse, TimeSeries>
      listTimeSeries(ListTimeSeriesRequest request) {
    return listTimeSeriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists time series that match a filter. This method does not require a Stackdriver account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatProjectName("[PROJECT]");
   *   String filter = "";
   *   TimeInterval interval = TimeInterval.newBuilder().build();
   *   Aggregation aggregation = Aggregation.newBuilder().build();
   *   String orderBy = "";
   *   ListTimeSeriesRequest.TimeSeriesView view = ListTimeSeriesRequest.TimeSeriesView.FULL;
   *   ListTimeSeriesRequest request = ListTimeSeriesRequest.newBuilder()
   *     .setName(formattedName)
   *     .setFilter(filter)
   *     .setInterval(interval)
   *     .setAggregation(aggregation)
   *     .setOrderBy(orderBy)
   *     .setView(view)
   *     .build();
   *   ListenableFuture&lt;PagedListResponse&lt;ListTimeSeriesRequest,ListTimeSeriesResponse,TimeSeries&gt;&gt; future = metricServiceApi.listTimeSeriesPagedCallable().futureCall(request);
   *   // Do something
   *   for (TimeSeries element : future.get().iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final ApiCallable<
          ListTimeSeriesRequest,
          PagedListResponse<ListTimeSeriesRequest, ListTimeSeriesResponse, TimeSeries>>
      listTimeSeriesPagedCallable() {
    return listTimeSeriesPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists time series that match a filter. This method does not require a Stackdriver account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatProjectName("[PROJECT]");
   *   String filter = "";
   *   TimeInterval interval = TimeInterval.newBuilder().build();
   *   Aggregation aggregation = Aggregation.newBuilder().build();
   *   String orderBy = "";
   *   ListTimeSeriesRequest.TimeSeriesView view = ListTimeSeriesRequest.TimeSeriesView.FULL;
   *   ListTimeSeriesRequest request = ListTimeSeriesRequest.newBuilder()
   *     .setName(formattedName)
   *     .setFilter(filter)
   *     .setInterval(interval)
   *     .setAggregation(aggregation)
   *     .setOrderBy(orderBy)
   *     .setView(view)
   *     .build();
   *   while (true) {
   *     ListTimeSeriesResponse response = metricServiceApi.listTimeSeriesCallable().call(request);
   *     for (TimeSeries element : response.getTimeSeriesList()) {
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
  public final ApiCallable<ListTimeSeriesRequest, ListTimeSeriesResponse> listTimeSeriesCallable() {
    return listTimeSeriesCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates or adds data to one or more time series. The response is empty if all time series in
   * the request were written. If any time series could not be written, a corresponding failure
   * message is included in the error response.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatProjectName("[PROJECT]");
   *   List&lt;TimeSeries&gt; timeSeries = new ArrayList&lt;&gt;();
   *   metricServiceApi.createTimeSeries(formattedName, timeSeries);
   * }
   * </code></pre>
   *
   * @param name The project on which to execute the request. The format is
   *     `"projects/{project_id_or_number}"`.
   * @param timeSeries The new data to be added to a list of time series. Adds at most one data
   *     point to each of several time series. The new data point must be more recent than any other
   *     point in its time series. Each `TimeSeries` value must fully specify a unique time series
   *     by supplying all label values for the metric and the monitored resource.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void createTimeSeries(String name, List<TimeSeries> timeSeries) {
    PROJECT_PATH_TEMPLATE.validate(name, "createTimeSeries");
    CreateTimeSeriesRequest request =
        CreateTimeSeriesRequest.newBuilder().setName(name).addAllTimeSeries(timeSeries).build();
    createTimeSeries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates or adds data to one or more time series. The response is empty if all time series in
   * the request were written. If any time series could not be written, a corresponding failure
   * message is included in the error response.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatProjectName("[PROJECT]");
   *   List&lt;TimeSeries&gt; timeSeries = new ArrayList&lt;&gt;();
   *   CreateTimeSeriesRequest request = CreateTimeSeriesRequest.newBuilder()
   *     .setName(formattedName)
   *     .addAllTimeSeries(timeSeries)
   *     .build();
   *   metricServiceApi.createTimeSeries(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void createTimeSeries(CreateTimeSeriesRequest request) {
    createTimeSeriesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates or adds data to one or more time series. The response is empty if all time series in
   * the request were written. If any time series could not be written, a corresponding failure
   * message is included in the error response.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
   *   String formattedName = MetricServiceApi.formatProjectName("[PROJECT]");
   *   List&lt;TimeSeries&gt; timeSeries = new ArrayList&lt;&gt;();
   *   CreateTimeSeriesRequest request = CreateTimeSeriesRequest.newBuilder()
   *     .setName(formattedName)
   *     .addAllTimeSeries(timeSeries)
   *     .build();
   *   ListenableFuture&lt;Void&gt; future = metricServiceApi.createTimeSeriesCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<CreateTimeSeriesRequest, Empty> createTimeSeriesCallable() {
    return createTimeSeriesCallable;
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
