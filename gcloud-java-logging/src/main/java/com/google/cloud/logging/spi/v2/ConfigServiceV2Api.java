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

/*
 * EDITING INSTRUCTIONS
 * This file was generated from the file
 * https://github.com/google/googleapis/blob/master/google/logging/v2/logging_config.proto
 * and updates to that file get reflected here through a refresh process.
 * For the short term, the refresh process will only be runnable by Google engineers.
 * Manual additions are allowed because the refresh process performs
 * a 3-way merge in order to preserve those manual additions. In order to not
 * break the refresh process, only certain types of modifications are
 * allowed.
 *
 * Allowed modifications - currently these are the only types allowed:
 * 1. New methods (these should be added to the end of the class)
 * 2. New imports
 * 3. Additional documentation between "manual edit" demarcations
 *
 * Happy editing!
 */

package com.google.cloud.logging.spi.v2;

import com.google.api.gax.core.PageAccessor;
import com.google.api.gax.grpc.ApiCallable;
import com.google.api.gax.protobuf.PathTemplate;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.LogSink;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

// Manually-added imports: add custom (non-generated) imports after this point.

// AUTO-GENERATED DOCUMENTATION AND SERVICE - see instructions at the top of the file for editing.
/**
 * Service Description:
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.createWithDefaults()) {
 *   String formattedProjectName = ConfigServiceV2Api.formatProjectName("[PROJECT]");
 *   ListSinksResponse response = configServiceV2Api.listSinks(formattedProjectName);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the configServiceV2Api object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of ConfigServiceV2Settings to
 * create(). For example:
 *
 * <pre>
 * <code>
 * ConfigServiceV2Settings configServiceV2Settings = ConfigServiceV2Settings.defaultBuilder()
 *     .provideChannelWith(myCredentials)
 *     .build();
 * ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.create(configServiceV2Settings);
 * </code>
 * </pre>
 *
 * <!-- manual edit -->
 * <!-- end manual edit -->
 */
@javax.annotation.Generated("by GAPIC")
public class ConfigServiceV2Api implements AutoCloseable {
  private final ConfigServiceV2Settings settings;
  private final ManagedChannel channel;
  private final ScheduledExecutorService executor;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final ApiCallable<ListSinksRequest, ListSinksResponse> listSinksCallable;
  private final ApiCallable<ListSinksRequest, PageAccessor<LogSink>> listSinksPagedCallable;
  private final ApiCallable<GetSinkRequest, LogSink> getSinkCallable;
  private final ApiCallable<CreateSinkRequest, LogSink> createSinkCallable;
  private final ApiCallable<UpdateSinkRequest, LogSink> updateSinkCallable;
  private final ApiCallable<DeleteSinkRequest, Empty> deleteSinkCallable;

  public final ConfigServiceV2Settings getSettings() {
    return settings;
  }

  private static final PathTemplate PROJECT_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}");

  private static final PathTemplate SINK_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/sinks/{sink}");

  /**
   * Formats a string containing the fully-qualified path to represent
   * a project resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String formatProjectName(String project) {
    return PROJECT_PATH_TEMPLATE.instantiate("project", project);
  }

  /**
   * Formats a string containing the fully-qualified path to represent
   * a sink resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String formatSinkName(String project, String sink) {
    return SINK_PATH_TEMPLATE.instantiate("project", project, "sink", sink);
  }

  /**
   * Parses the project from the given fully-qualified path which
   * represents a project resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String parseProjectFromProjectName(String projectName) {
    return PROJECT_PATH_TEMPLATE.parse(projectName).get("project");
  }

  /**
   * Parses the project from the given fully-qualified path which
   * represents a sink resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String parseProjectFromSinkName(String sinkName) {
    return SINK_PATH_TEMPLATE.parse(sinkName).get("project");
  }

  /**
   * Parses the sink from the given fully-qualified path which
   * represents a sink resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String parseSinkFromSinkName(String sinkName) {
    return SINK_PATH_TEMPLATE.parse(sinkName).get("sink");
  }

  /**
   * Constructs an instance of ConfigServiceV2Api with default settings.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final ConfigServiceV2Api createWithDefaults() throws IOException {
    return create(ConfigServiceV2Settings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of ConfigServiceV2Api, using the given settings.
   * The channels are created based on the settings passed in, or defaults for any
   * settings that are not set.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final ConfigServiceV2Api create(ConfigServiceV2Settings settings)
      throws IOException {
    return new ConfigServiceV2Api(settings);
  }

  /**
   * Constructs an instance of ConfigServiceV2Api, using the given settings.
   * This is protected so that it easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  protected ConfigServiceV2Api(ConfigServiceV2Settings settings) throws IOException {
    this.settings = settings;
    this.executor = settings.getExecutorProvider().getOrBuildExecutor();
    this.channel = settings.getChannelProvider().getOrBuildChannel(this.executor);

    this.listSinksCallable =
        ApiCallable.create(settings.listSinksSettings(), this.channel, this.executor);
    this.listSinksPagedCallable =
        ApiCallable.createPagedVariant(settings.listSinksSettings(), this.channel, this.executor);
    this.getSinkCallable =
        ApiCallable.create(settings.getSinkSettings(), this.channel, this.executor);
    this.createSinkCallable =
        ApiCallable.create(settings.createSinkSettings(), this.channel, this.executor);
    this.updateSinkCallable =
        ApiCallable.create(settings.updateSinkSettings(), this.channel, this.executor);
    this.deleteSinkCallable =
        ApiCallable.create(settings.deleteSinkSettings(), this.channel, this.executor);

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

  // ----- listSinks -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists sinks.
   *
   * Sample code:
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.createWithDefaults()) {
   *   String formattedProjectName = ConfigServiceV2Api.formatProjectName("[PROJECT]");
   *   for (LogSink elements : configServiceV2Api.listSinks(formattedProjectName)) {
   *     // doThingsWith(elements);
   *   }
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param projectName Required. The resource name of the project containing the sinks.
   * Example: `"projects/my-logging-project"`, `"projects/01234567890"`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PageAccessor<LogSink> listSinks(String projectName) {
    PROJECT_PATH_TEMPLATE.validate(projectName);
    ListSinksRequest request = ListSinksRequest.newBuilder().setProjectName(projectName).build();
    return listSinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists sinks.
   *
   * Sample code:
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.createWithDefaults()) {
   *   String formattedProjectName = ConfigServiceV2Api.formatProjectName("[PROJECT]");
   *   ListSinksRequest request = ListSinksRequest.newBuilder()
   *     .setProjectName(formattedProjectName)
   *     .build();
   *   for (LogSink elements : configServiceV2Api.listSinks(request)) {
   *     // doThingsWith(elements);
   *   }
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PageAccessor<LogSink> listSinks(ListSinksRequest request) {
    return listSinksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists sinks.
   *
   * Sample code:
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.createWithDefaults()) {
   *   String formattedProjectName = ConfigServiceV2Api.formatProjectName("[PROJECT]");
   *   ListSinksRequest request = ListSinksRequest.newBuilder()
   *     .setProjectName(formattedProjectName)
   *     .build();
   *   ListenableFuture&lt;PageAccessor&lt;LogSink&gt;&gt; future = configServiceV2Api.listSinksPagedCallable().futureCall(request);
   *   // Do something
   *   for (LogSink elements : future.get()) {
   *     // doThingsWith(elements);
   *   }
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<ListSinksRequest, PageAccessor<LogSink>> listSinksPagedCallable() {
    return listSinksPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists sinks.
   *
   * Sample code:
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.createWithDefaults()) {
   *   String formattedProjectName = ConfigServiceV2Api.formatProjectName("[PROJECT]");
   *   ListSinksRequest request = ListSinksRequest.newBuilder()
   *     .setProjectName(formattedProjectName)
   *     .build();
   *   while (true) {
   *     ListSinksResponse response = configServiceV2Api.listSinksCallable().call(request);
   *     for (LogSink elements : response.getSinksList()) {
   *       // doThingsWith(elements);
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
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<ListSinksRequest, ListSinksResponse> listSinksCallable() {
    return listSinksCallable;
  }

  // ----- getSink -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Gets a sink.
   *
   * Sample code:
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.createWithDefaults()) {
   *   String formattedSinkName = ConfigServiceV2Api.formatSinkName("[PROJECT]", "[SINK]");
   *   LogSink response = configServiceV2Api.getSink(formattedSinkName);
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param sinkName The resource name of the sink to return.
   * Example: `"projects/my-project-id/sinks/my-sink-id"`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final LogSink getSink(String sinkName) {
    SINK_PATH_TEMPLATE.validate(sinkName);
    GetSinkRequest request = GetSinkRequest.newBuilder().setSinkName(sinkName).build();
    return getSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Gets a sink.
   *
   * Sample code:
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.createWithDefaults()) {
   *   String formattedSinkName = ConfigServiceV2Api.formatSinkName("[PROJECT]", "[SINK]");
   *   GetSinkRequest request = GetSinkRequest.newBuilder()
   *     .setSinkName(formattedSinkName)
   *     .build();
   *   LogSink response = configServiceV2Api.getSink(request);
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private LogSink getSink(GetSinkRequest request) {
    return getSinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Gets a sink.
   *
   * Sample code:
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.createWithDefaults()) {
   *   String formattedSinkName = ConfigServiceV2Api.formatSinkName("[PROJECT]", "[SINK]");
   *   GetSinkRequest request = GetSinkRequest.newBuilder()
   *     .setSinkName(formattedSinkName)
   *     .build();
   *   ListenableFuture&lt;LogSink&gt; future = configServiceV2Api.getSinkCallable().futureCall(request);
   *   // Do something
   *   LogSink response = future.get();
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<GetSinkRequest, LogSink> getSinkCallable() {
    return getSinkCallable;
  }

  // ----- createSink -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates a sink.
   *
   * Sample code:
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.createWithDefaults()) {
   *   String formattedProjectName = ConfigServiceV2Api.formatProjectName("[PROJECT]");
   *   LogSink sink = LogSink.newBuilder().build();
   *   LogSink response = configServiceV2Api.createSink(formattedProjectName, sink);
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param projectName The resource name of the project in which to create the sink.
   * Example: `"projects/my-project-id"`.
   *
   * The new sink must be provided in the request.
   * @param sink The new sink, which must not have an identifier that already
   * exists.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final LogSink createSink(String projectName, LogSink sink) {
    PROJECT_PATH_TEMPLATE.validate(projectName);

    CreateSinkRequest request =
        CreateSinkRequest.newBuilder().setProjectName(projectName).setSink(sink).build();
    return createSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates a sink.
   *
   * Sample code:
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.createWithDefaults()) {
   *   String formattedProjectName = ConfigServiceV2Api.formatProjectName("[PROJECT]");
   *   LogSink sink = LogSink.newBuilder().build();
   *   CreateSinkRequest request = CreateSinkRequest.newBuilder()
   *     .setProjectName(formattedProjectName)
   *     .setSink(sink)
   *     .build();
   *   LogSink response = configServiceV2Api.createSink(request);
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public LogSink createSink(CreateSinkRequest request) {
    return createSinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates a sink.
   *
   * Sample code:
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.createWithDefaults()) {
   *   String formattedProjectName = ConfigServiceV2Api.formatProjectName("[PROJECT]");
   *   LogSink sink = LogSink.newBuilder().build();
   *   CreateSinkRequest request = CreateSinkRequest.newBuilder()
   *     .setProjectName(formattedProjectName)
   *     .setSink(sink)
   *     .build();
   *   ListenableFuture&lt;LogSink&gt; future = configServiceV2Api.createSinkCallable().futureCall(request);
   *   // Do something
   *   LogSink response = future.get();
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<CreateSinkRequest, LogSink> createSinkCallable() {
    return createSinkCallable;
  }

  // ----- updateSink -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates or updates a sink.
   *
   * Sample code:
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.createWithDefaults()) {
   *   String formattedSinkName = ConfigServiceV2Api.formatSinkName("[PROJECT]", "[SINK]");
   *   LogSink sink = LogSink.newBuilder().build();
   *   LogSink response = configServiceV2Api.updateSink(formattedSinkName, sink);
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param sinkName The resource name of the sink to update.
   * Example: `"projects/my-project-id/sinks/my-sink-id"`.
   *
   * The updated sink must be provided in the request and have the
   * same name that is specified in `sinkName`.  If the sink does not
   * exist, it is created.
   * @param sink The updated sink, whose name must be the same as the sink
   * identifier in `sinkName`.  If `sinkName` does not exist, then
   * this method creates a new sink.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final LogSink updateSink(String sinkName, LogSink sink) {
    SINK_PATH_TEMPLATE.validate(sinkName);

    UpdateSinkRequest request =
        UpdateSinkRequest.newBuilder().setSinkName(sinkName).setSink(sink).build();
    return updateSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates or updates a sink.
   *
   * Sample code:
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.createWithDefaults()) {
   *   String formattedSinkName = ConfigServiceV2Api.formatSinkName("[PROJECT]", "[SINK]");
   *   LogSink sink = LogSink.newBuilder().build();
   *   UpdateSinkRequest request = UpdateSinkRequest.newBuilder()
   *     .setSinkName(formattedSinkName)
   *     .setSink(sink)
   *     .build();
   *   LogSink response = configServiceV2Api.updateSink(request);
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public LogSink updateSink(UpdateSinkRequest request) {
    return updateSinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates or updates a sink.
   *
   * Sample code:
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.createWithDefaults()) {
   *   String formattedSinkName = ConfigServiceV2Api.formatSinkName("[PROJECT]", "[SINK]");
   *   LogSink sink = LogSink.newBuilder().build();
   *   UpdateSinkRequest request = UpdateSinkRequest.newBuilder()
   *     .setSinkName(formattedSinkName)
   *     .setSink(sink)
   *     .build();
   *   ListenableFuture&lt;LogSink&gt; future = configServiceV2Api.updateSinkCallable().futureCall(request);
   *   // Do something
   *   LogSink response = future.get();
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<UpdateSinkRequest, LogSink> updateSinkCallable() {
    return updateSinkCallable;
  }

  // ----- deleteSink -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes a sink.
   *
   * Sample code:
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.createWithDefaults()) {
   *   String formattedSinkName = ConfigServiceV2Api.formatSinkName("[PROJECT]", "[SINK]");
   *   configServiceV2Api.deleteSink(formattedSinkName);
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param sinkName The resource name of the sink to delete.
   * Example: `"projects/my-project-id/sinks/my-sink-id"`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void deleteSink(String sinkName) {
    SINK_PATH_TEMPLATE.validate(sinkName);
    DeleteSinkRequest request = DeleteSinkRequest.newBuilder().setSinkName(sinkName).build();
    deleteSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes a sink.
   *
   * Sample code:
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.createWithDefaults()) {
   *   String formattedSinkName = ConfigServiceV2Api.formatSinkName("[PROJECT]", "[SINK]");
   *   DeleteSinkRequest request = DeleteSinkRequest.newBuilder()
   *     .setSinkName(formattedSinkName)
   *     .build();
   *   configServiceV2Api.deleteSink(request);
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private void deleteSink(DeleteSinkRequest request) {
    deleteSinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes a sink.
   *
   * Sample code:
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.createWithDefaults()) {
   *   String formattedSinkName = ConfigServiceV2Api.formatSinkName("[PROJECT]", "[SINK]");
   *   DeleteSinkRequest request = DeleteSinkRequest.newBuilder()
   *     .setSinkName(formattedSinkName)
   *     .build();
   *   ListenableFuture&lt;Void&gt; future = configServiceV2Api.deleteSinkCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<DeleteSinkRequest, Empty> deleteSinkCallable() {
    return deleteSinkCallable;
  }

  /**
   * Initiates an orderly shutdown in which preexisting calls continue but new calls are immediately
   * cancelled.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  @Override
  public final void close() throws Exception {
    for (AutoCloseable closeable : closeables) {
      closeable.close();
    }
  }

  // ========
  // Manually-added methods: add custom (non-generated) methods after this point.
  // ========

}
