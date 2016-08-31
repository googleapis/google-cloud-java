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

import com.google.api.MonitoredResource;
import com.google.api.gax.grpc.ApiCallable;
import com.google.api.gax.protobuf.PathTemplate;
import com.google.monitoring.v3.CollectdPayload;
import com.google.monitoring.v3.CreateCollectdTimeSeriesRequest;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The AgentTranslation API allows `collectd`-based agents to
 * write time series data to Cloud Monitoring.
 * See [google.monitoring.v3.MetricService.CreateTimeSeries] instead.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (AgentTranslationServiceApi agentTranslationServiceApi = AgentTranslationServiceApi.create()) {
 *   String formattedName = AgentTranslationServiceApi.formatProjectName("[PROJECT]");
 *   MonitoredResource resource = MonitoredResource.newBuilder().build();
 *   String collectdVersion = "";
 *   List&lt;CollectdPayload&gt; collectdPayloads = new ArrayList&lt;&gt;();
 *   agentTranslationServiceApi.createCollectdTimeSeries(formattedName, resource, collectdVersion, collectdPayloads);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the agentTranslationServiceApi object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's methods:
 *
 * <ol>
 * <li> A "flattened" method. With this type of method, the fields of the request type have been
 * converted into function parameters. It may be the case that not all fields are available
 * as parameters, and not every API method will have a flattened method entry point.
 * <li> A "request object" method. This type of method only takes one parameter, a request
 * object, which must be constructed before the call. Not every API method will have a request
 * object method.
 * <li> A "callable" method. This type of method takes no parameters and returns an immutable
 * ApiCallable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist
 * with these names, this class includes a format method for each type of name, and additionally
 * a parse method to extract the individual identifiers contained within names that are
 * returned.
 *
 * <p>This class can be customized by passing in a custom instance of AgentTranslationServiceSettings to
 * create(). For example:
 *
 * <pre>
 * <code>
 * AgentTranslationServiceSettings agentTranslationServiceSettings = AgentTranslationServiceSettings.defaultBuilder()
 *     .provideChannelWith(myCredentials)
 *     .build();
 * AgentTranslationServiceApi agentTranslationServiceApi = AgentTranslationServiceApi.create(agentTranslationServiceSettings);
 * </code>
 * </pre>
 */
@javax.annotation.Generated("by GAPIC")
public class AgentTranslationServiceApi implements AutoCloseable {
  private final AgentTranslationServiceSettings settings;
  private final ManagedChannel channel;
  private final ScheduledExecutorService executor;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final ApiCallable<CreateCollectdTimeSeriesRequest, Empty>
      createCollectdTimeSeriesCallable;

  public final AgentTranslationServiceSettings getSettings() {
    return settings;
  }

  private static final PathTemplate PROJECT_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}");

  /**
   * Formats a string containing the fully-qualified path to represent
   * a project resource.
   */
  public static final String formatProjectName(String project) {
    return PROJECT_PATH_TEMPLATE.instantiate("project", project);
  }

  /**
   * Parses the project from the given fully-qualified path which
   * represents a project resource.
   */
  public static final String parseProjectFromProjectName(String projectName) {
    return PROJECT_PATH_TEMPLATE.parse(projectName).get("project");
  }

  /**
   * Constructs an instance of AgentTranslationServiceApi with default settings.
   */
  public static final AgentTranslationServiceApi create() throws IOException {
    return create(AgentTranslationServiceSettings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of AgentTranslationServiceApi, using the given settings.
   * The channels are created based on the settings passed in, or defaults for any
   * settings that are not set.
   */
  public static final AgentTranslationServiceApi create(AgentTranslationServiceSettings settings)
      throws IOException {
    return new AgentTranslationServiceApi(settings);
  }

  /**
   * Constructs an instance of AgentTranslationServiceApi, using the given settings.
   * This is protected so that it easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected AgentTranslationServiceApi(AgentTranslationServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.executor = settings.getExecutorProvider().getOrBuildExecutor();
    this.channel = settings.getChannelProvider().getOrBuildChannel(this.executor);

    this.createCollectdTimeSeriesCallable =
        ApiCallable.create(
            settings.createCollectdTimeSeriesSettings(), this.channel, this.executor);

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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * &ast;&ast;Stackdriver Monitoring Agent only:&ast;&ast; Creates a new time series.
   *
   * &lt;aside class="caution"&gt;This method is only for use by the Google Monitoring Agent.
   * Use [projects.timeSeries.create][google.monitoring.v3.MetricService.CreateTimeSeries]
   * instead.&lt;/aside&gt;
   *
   * Sample code:
   * <pre><code>
   * try (AgentTranslationServiceApi agentTranslationServiceApi = AgentTranslationServiceApi.create()) {
   *   String formattedName = AgentTranslationServiceApi.formatProjectName("[PROJECT]");
   *   MonitoredResource resource = MonitoredResource.newBuilder().build();
   *   String collectdVersion = "";
   *   List&lt;CollectdPayload&gt; collectdPayloads = new ArrayList&lt;&gt;();
   *   agentTranslationServiceApi.createCollectdTimeSeries(formattedName, resource, collectdVersion, collectdPayloads);
   * }
   * </code></pre>
   *
   * @param name The project in which to create the time series. The format is
   * `"projects/PROJECT_ID_OR_NUMBER"`.
   * @param resource The monitored resource associated with the time series.
   * @param collectdVersion The version of `collectd` that collected the data. Example: `"5.3.0-192.el6"`.
   * @param collectdPayloads The `collectd` payloads representing the time series data.
   * You must not include more than a single point for each
   * time series, so no two payloads can have the same values
   * for all of the fields `plugin`, `plugin_instance`, `type`, and `type_instance`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void createCollectdTimeSeries(
      String name,
      MonitoredResource resource,
      String collectdVersion,
      List<CollectdPayload> collectdPayloads) {
    PROJECT_PATH_TEMPLATE.validate(name, "createCollectdTimeSeries");
    CreateCollectdTimeSeriesRequest request =
        CreateCollectdTimeSeriesRequest.newBuilder()
            .setName(name)
            .setResource(resource)
            .setCollectdVersion(collectdVersion)
            .addAllCollectdPayloads(collectdPayloads)
            .build();
    createCollectdTimeSeries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * &ast;&ast;Stackdriver Monitoring Agent only:&ast;&ast; Creates a new time series.
   *
   * &lt;aside class="caution"&gt;This method is only for use by the Google Monitoring Agent.
   * Use [projects.timeSeries.create][google.monitoring.v3.MetricService.CreateTimeSeries]
   * instead.&lt;/aside&gt;
   *
   * Sample code:
   * <pre><code>
   * try (AgentTranslationServiceApi agentTranslationServiceApi = AgentTranslationServiceApi.create()) {
   *   String formattedName = AgentTranslationServiceApi.formatProjectName("[PROJECT]");
   *   MonitoredResource resource = MonitoredResource.newBuilder().build();
   *   String collectdVersion = "";
   *   List&lt;CollectdPayload&gt; collectdPayloads = new ArrayList&lt;&gt;();
   *   CreateCollectdTimeSeriesRequest request = CreateCollectdTimeSeriesRequest.newBuilder()
   *     .setName(formattedName)
   *     .setResource(resource)
   *     .setCollectdVersion(collectdVersion)
   *     .addAllCollectdPayloads(collectdPayloads)
   *     .build();
   *   agentTranslationServiceApi.createCollectdTimeSeries(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void createCollectdTimeSeries(CreateCollectdTimeSeriesRequest request) {
    createCollectdTimeSeriesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * &ast;&ast;Stackdriver Monitoring Agent only:&ast;&ast; Creates a new time series.
   *
   * &lt;aside class="caution"&gt;This method is only for use by the Google Monitoring Agent.
   * Use [projects.timeSeries.create][google.monitoring.v3.MetricService.CreateTimeSeries]
   * instead.&lt;/aside&gt;
   *
   * Sample code:
   * <pre><code>
   * try (AgentTranslationServiceApi agentTranslationServiceApi = AgentTranslationServiceApi.create()) {
   *   String formattedName = AgentTranslationServiceApi.formatProjectName("[PROJECT]");
   *   MonitoredResource resource = MonitoredResource.newBuilder().build();
   *   String collectdVersion = "";
   *   List&lt;CollectdPayload&gt; collectdPayloads = new ArrayList&lt;&gt;();
   *   CreateCollectdTimeSeriesRequest request = CreateCollectdTimeSeriesRequest.newBuilder()
   *     .setName(formattedName)
   *     .setResource(resource)
   *     .setCollectdVersion(collectdVersion)
   *     .addAllCollectdPayloads(collectdPayloads)
   *     .build();
   *   ListenableFuture&lt;Void&gt; future = agentTranslationServiceApi.createCollectdTimeSeriesCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<CreateCollectdTimeSeriesRequest, Empty>
      createCollectdTimeSeriesCallable() {
    return createCollectdTimeSeriesCallable;
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
