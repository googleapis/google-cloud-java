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

import static com.google.cloud.logging.spi.v2.PagedResponseWrappers.ListSinksPagedResponse;

import com.google.api.gax.grpc.ChannelAndExecutor;
import com.google.api.gax.grpc.UnaryCallable;
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

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Service for configuring sinks used to export log entries outside Stackdriver
 * Logging.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.create()) {
 *   String formattedSinkName = ConfigServiceV2Api.formatSinkName("[PROJECT]", "[SINK]");
 *   LogSink response = configServiceV2Api.getSink(formattedSinkName);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the configServiceV2Api object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of ConfigServiceV2Settings to
 * create(). For example:
 *
 * <pre>
 * <code>
 * InstantiatingChannelProvider channelProvider =
 *     ConfigServiceV2Settings.defaultChannelProviderBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ConfigServiceV2Settings configServiceV2Settings =
 *     ConfigServiceV2Settings.defaultBuilder().setChannelProvider(channelProvider).build();
 * ConfigServiceV2Api configServiceV2Api =
 *     ConfigServiceV2Api.create(configServiceV2Settings);
 * </code>
 * </pre>
 */
@javax.annotation.Generated("by GAPIC")
public class ConfigServiceV2Api implements AutoCloseable {
  private final ConfigServiceV2Settings settings;
  private final ScheduledExecutorService executor;
  private final ManagedChannel channel;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final UnaryCallable<ListSinksRequest, ListSinksResponse> listSinksCallable;
  private final UnaryCallable<ListSinksRequest, ListSinksPagedResponse> listSinksPagedCallable;
  private final UnaryCallable<GetSinkRequest, LogSink> getSinkCallable;
  private final UnaryCallable<CreateSinkRequest, LogSink> createSinkCallable;
  private final UnaryCallable<UpdateSinkRequest, LogSink> updateSinkCallable;
  private final UnaryCallable<DeleteSinkRequest, Empty> deleteSinkCallable;

  private static final PathTemplate PARENT_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}");

  private static final PathTemplate SINK_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/sinks/{sink}");

  /** Formats a string containing the fully-qualified path to represent a parent resource. */
  public static final String formatParentName(String project) {
    return PARENT_PATH_TEMPLATE.instantiate("project", project);
  }

  /** Formats a string containing the fully-qualified path to represent a sink resource. */
  public static final String formatSinkName(String project, String sink) {
    return SINK_PATH_TEMPLATE.instantiate(
        "project", project,
        "sink", sink);
  }

  /** Parses the project from the given fully-qualified path which represents a parent resource. */
  public static final String parseProjectFromParentName(String parentName) {
    return PARENT_PATH_TEMPLATE.parse(parentName).get("project");
  }

  /** Parses the project from the given fully-qualified path which represents a sink resource. */
  public static final String parseProjectFromSinkName(String sinkName) {
    return SINK_PATH_TEMPLATE.parse(sinkName).get("project");
  }

  /** Parses the sink from the given fully-qualified path which represents a sink resource. */
  public static final String parseSinkFromSinkName(String sinkName) {
    return SINK_PATH_TEMPLATE.parse(sinkName).get("sink");
  }

  /** Constructs an instance of ConfigServiceV2Api with default settings. */
  public static final ConfigServiceV2Api create() throws IOException {
    return create(ConfigServiceV2Settings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of ConfigServiceV2Api, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ConfigServiceV2Api create(ConfigServiceV2Settings settings)
      throws IOException {
    return new ConfigServiceV2Api(settings);
  }

  /**
   * Constructs an instance of ConfigServiceV2Api, using the given settings. This is protected so
   * that it easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected ConfigServiceV2Api(ConfigServiceV2Settings settings) throws IOException {
    this.settings = settings;
    ChannelAndExecutor channelAndExecutor = settings.getChannelAndExecutor();
    this.executor = channelAndExecutor.getExecutor();
    this.channel = channelAndExecutor.getChannel();

    this.listSinksCallable =
        UnaryCallable.create(settings.listSinksSettings(), this.channel, this.executor);
    this.listSinksPagedCallable =
        UnaryCallable.createPagedVariant(settings.listSinksSettings(), this.channel, this.executor);
    this.getSinkCallable =
        UnaryCallable.create(settings.getSinkSettings(), this.channel, this.executor);
    this.createSinkCallable =
        UnaryCallable.create(settings.createSinkSettings(), this.channel, this.executor);
    this.updateSinkCallable =
        UnaryCallable.create(settings.updateSinkSettings(), this.channel, this.executor);
    this.deleteSinkCallable =
        UnaryCallable.create(settings.deleteSinkSettings(), this.channel, this.executor);

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

  public final ConfigServiceV2Settings getSettings() {
    return settings;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists sinks.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.create()) {
   *   String formattedParent = ConfigServiceV2Api.formatParentName("[PROJECT]");
   *   for (LogSink element : configServiceV2Api.listSinks(formattedParent).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The cloud resource containing the sinks. Example:
   *     `"projects/my-logging-project"`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final ListSinksPagedResponse listSinks(String parent) {
    PARENT_PATH_TEMPLATE.validate(parent, "listSinks");
    ListSinksRequest request = ListSinksRequest.newBuilder().setParent(parent).build();
    return listSinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists sinks.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.create()) {
   *   String formattedParent = ConfigServiceV2Api.formatParentName("[PROJECT]");
   *   ListSinksRequest request = ListSinksRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   for (LogSink element : configServiceV2Api.listSinks(request).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final ListSinksPagedResponse listSinks(ListSinksRequest request) {
    return listSinksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists sinks.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.create()) {
   *   String formattedParent = ConfigServiceV2Api.formatParentName("[PROJECT]");
   *   ListSinksRequest request = ListSinksRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ListenableFuture&lt;ListSinksPagedResponse&gt; future = configServiceV2Api.listSinksPagedCallable().futureCall(request);
   *   // Do something
   *   for (LogSink element : future.get().iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListSinksRequest, ListSinksPagedResponse> listSinksPagedCallable() {
    return listSinksPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists sinks.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.create()) {
   *   String formattedParent = ConfigServiceV2Api.formatParentName("[PROJECT]");
   *   ListSinksRequest request = ListSinksRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   while (true) {
   *     ListSinksResponse response = configServiceV2Api.listSinksCallable().call(request);
   *     for (LogSink element : response.getSinksList()) {
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
  public final UnaryCallable<ListSinksRequest, ListSinksResponse> listSinksCallable() {
    return listSinksCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a sink.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.create()) {
   *   String formattedSinkName = ConfigServiceV2Api.formatSinkName("[PROJECT]", "[SINK]");
   *   LogSink response = configServiceV2Api.getSink(formattedSinkName);
   * }
   * </code></pre>
   *
   * @param sinkName Required. The resource name of the sink to return. Example:
   *     `"projects/my-project-id/sinks/my-sink-id"`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final LogSink getSink(String sinkName) {
    SINK_PATH_TEMPLATE.validate(sinkName, "getSink");
    GetSinkRequest request = GetSinkRequest.newBuilder().setSinkName(sinkName).build();
    return getSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a sink.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.create()) {
   *   String formattedSinkName = ConfigServiceV2Api.formatSinkName("[PROJECT]", "[SINK]");
   *   GetSinkRequest request = GetSinkRequest.newBuilder()
   *     .setSinkName(formattedSinkName)
   *     .build();
   *   LogSink response = configServiceV2Api.getSink(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private final LogSink getSink(GetSinkRequest request) {
    return getSinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a sink.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.create()) {
   *   String formattedSinkName = ConfigServiceV2Api.formatSinkName("[PROJECT]", "[SINK]");
   *   GetSinkRequest request = GetSinkRequest.newBuilder()
   *     .setSinkName(formattedSinkName)
   *     .build();
   *   ListenableFuture&lt;LogSink&gt; future = configServiceV2Api.getSinkCallable().futureCall(request);
   *   // Do something
   *   LogSink response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetSinkRequest, LogSink> getSinkCallable() {
    return getSinkCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a sink.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.create()) {
   *   String formattedParent = ConfigServiceV2Api.formatParentName("[PROJECT]");
   *   LogSink sink = LogSink.newBuilder().build();
   *   LogSink response = configServiceV2Api.createSink(formattedParent, sink);
   * }
   * </code></pre>
   *
   * @param parent Required. The resource in which to create the sink. Example:
   *     `"projects/my-project-id"`. The new sink must be provided in the request.
   * @param sink Required. The new sink, whose `name` parameter is a sink identifier that is not
   *     already in use.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final LogSink createSink(String parent, LogSink sink) {
    PARENT_PATH_TEMPLATE.validate(parent, "createSink");
    CreateSinkRequest request =
        CreateSinkRequest.newBuilder().setParent(parent).setSink(sink).build();
    return createSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a sink.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.create()) {
   *   String formattedParent = ConfigServiceV2Api.formatParentName("[PROJECT]");
   *   LogSink sink = LogSink.newBuilder().build();
   *   CreateSinkRequest request = CreateSinkRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setSink(sink)
   *     .build();
   *   LogSink response = configServiceV2Api.createSink(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final LogSink createSink(CreateSinkRequest request) {
    return createSinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a sink.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.create()) {
   *   String formattedParent = ConfigServiceV2Api.formatParentName("[PROJECT]");
   *   LogSink sink = LogSink.newBuilder().build();
   *   CreateSinkRequest request = CreateSinkRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setSink(sink)
   *     .build();
   *   ListenableFuture&lt;LogSink&gt; future = configServiceV2Api.createSinkCallable().futureCall(request);
   *   // Do something
   *   LogSink response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateSinkRequest, LogSink> createSinkCallable() {
    return createSinkCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates or creates a sink.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.create()) {
   *   String formattedSinkName = ConfigServiceV2Api.formatSinkName("[PROJECT]", "[SINK]");
   *   LogSink sink = LogSink.newBuilder().build();
   *   LogSink response = configServiceV2Api.updateSink(formattedSinkName, sink);
   * }
   * </code></pre>
   *
   * @param sinkName Required. The resource name of the sink to update, including the parent
   *     resource and the sink identifier. If the sink does not exist, this method creates the sink.
   *     Example: `"projects/my-project-id/sinks/my-sink-id"`.
   * @param sink Required. The updated sink, whose name is the same identifier that appears as part
   *     of `sinkName`. If `sinkName` does not exist, then this method creates a new sink.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final LogSink updateSink(String sinkName, LogSink sink) {
    SINK_PATH_TEMPLATE.validate(sinkName, "updateSink");
    UpdateSinkRequest request =
        UpdateSinkRequest.newBuilder().setSinkName(sinkName).setSink(sink).build();
    return updateSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates or creates a sink.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.create()) {
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
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final LogSink updateSink(UpdateSinkRequest request) {
    return updateSinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates or creates a sink.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.create()) {
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
   */
  public final UnaryCallable<UpdateSinkRequest, LogSink> updateSinkCallable() {
    return updateSinkCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a sink.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.create()) {
   *   String formattedSinkName = ConfigServiceV2Api.formatSinkName("[PROJECT]", "[SINK]");
   *   configServiceV2Api.deleteSink(formattedSinkName);
   * }
   * </code></pre>
   *
   * @param sinkName Required. The resource name of the sink to delete, including the parent
   *     resource and the sink identifier. Example: `"projects/my-project-id/sinks/my-sink-id"`. It
   *     is an error if the sink does not exist.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void deleteSink(String sinkName) {
    SINK_PATH_TEMPLATE.validate(sinkName, "deleteSink");
    DeleteSinkRequest request = DeleteSinkRequest.newBuilder().setSinkName(sinkName).build();
    deleteSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a sink.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.create()) {
   *   String formattedSinkName = ConfigServiceV2Api.formatSinkName("[PROJECT]", "[SINK]");
   *   DeleteSinkRequest request = DeleteSinkRequest.newBuilder()
   *     .setSinkName(formattedSinkName)
   *     .build();
   *   configServiceV2Api.deleteSink(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private final void deleteSink(DeleteSinkRequest request) {
    deleteSinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a sink.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.create()) {
   *   String formattedSinkName = ConfigServiceV2Api.formatSinkName("[PROJECT]", "[SINK]");
   *   DeleteSinkRequest request = DeleteSinkRequest.newBuilder()
   *     .setSinkName(formattedSinkName)
   *     .build();
   *   ListenableFuture&lt;Void&gt; future = configServiceV2Api.deleteSinkCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteSinkRequest, Empty> deleteSinkCallable() {
    return deleteSinkCallable;
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
