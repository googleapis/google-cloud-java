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
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.LogSink;
import com.google.logging.v2.ParentNameOneof;
import com.google.logging.v2.SinkNameOneof;
import com.google.logging.v2.UpdateSinkRequest;
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
 * Service Description: Service for configuring sinks used to export log entries outside of
 * Stackdriver Logging.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ConfigServiceV2Client configServiceV2Client = ConfigServiceV2Client.create()) {
 *   SinkNameOneof sinkName = SinkNameOneof.from(SinkName.create("[PROJECT]", "[SINK]"));
 *   LogSink response = configServiceV2Client.getSink(sinkName);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the configServiceV2Client object to clean up resources
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
 * ConfigServiceV2Client configServiceV2Client =
 *     ConfigServiceV2Client.create(configServiceV2Settings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC")
public class ConfigServiceV2Client implements AutoCloseable {
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

  /** Constructs an instance of ConfigServiceV2Client with default settings. */
  public static final ConfigServiceV2Client create() throws IOException {
    return create(ConfigServiceV2Settings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of ConfigServiceV2Client, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ConfigServiceV2Client create(ConfigServiceV2Settings settings)
      throws IOException {
    return new ConfigServiceV2Client(settings);
  }

  /**
   * Constructs an instance of ConfigServiceV2Client, using the given settings. This is protected so
   * that it easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected ConfigServiceV2Client(ConfigServiceV2Settings settings) throws IOException {
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
   * try (ConfigServiceV2Client configServiceV2Client = ConfigServiceV2Client.create()) {
   *   ParentNameOneof parent = ParentNameOneof.from(ProjectName.create("[PROJECT]"));
   *   for (LogSink element : configServiceV2Client.listSinks(parent).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The parent resource whose sinks are to be listed. Examples:
   *     `"projects/my-logging-project"`, `"organizations/123456789"`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final ListSinksPagedResponse listSinks(ParentNameOneof parent) {
    ListSinksRequest request =
        ListSinksRequest.newBuilder().setParentWithParentNameOneof(parent).build();
    return listSinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists sinks.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Client configServiceV2Client = ConfigServiceV2Client.create()) {
   *   ParentNameOneof parent = ParentNameOneof.from(ProjectName.create("[PROJECT]"));
   *   ListSinksRequest request = ListSinksRequest.newBuilder()
   *     .setParentWithParentNameOneof(parent)
   *     .build();
   *   for (LogSink element : configServiceV2Client.listSinks(request).iterateAllElements()) {
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
   * try (ConfigServiceV2Client configServiceV2Client = ConfigServiceV2Client.create()) {
   *   ParentNameOneof parent = ParentNameOneof.from(ProjectName.create("[PROJECT]"));
   *   ListSinksRequest request = ListSinksRequest.newBuilder()
   *     .setParentWithParentNameOneof(parent)
   *     .build();
   *   RpcFuture&lt;ListSinksPagedResponse&gt; future = configServiceV2Client.listSinksPagedCallable().futureCall(request);
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
   * try (ConfigServiceV2Client configServiceV2Client = ConfigServiceV2Client.create()) {
   *   ParentNameOneof parent = ParentNameOneof.from(ProjectName.create("[PROJECT]"));
   *   ListSinksRequest request = ListSinksRequest.newBuilder()
   *     .setParentWithParentNameOneof(parent)
   *     .build();
   *   while (true) {
   *     ListSinksResponse response = configServiceV2Client.listSinksCallable().call(request);
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
   * try (ConfigServiceV2Client configServiceV2Client = ConfigServiceV2Client.create()) {
   *   SinkNameOneof sinkName = SinkNameOneof.from(SinkName.create("[PROJECT]", "[SINK]"));
   *   LogSink response = configServiceV2Client.getSink(sinkName);
   * }
   * </code></pre>
   *
   * @param sinkName Required. The parent resource name of the sink:
   *     <p>"projects/[PROJECT_ID]/sinks/[SINK_ID]"
   *     "organizations/[ORGANIZATION_ID]/sinks/[SINK_ID]"
   *     <p>Example: `"projects/my-project-id/sinks/my-sink-id"`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final LogSink getSink(SinkNameOneof sinkName) {

    GetSinkRequest request =
        GetSinkRequest.newBuilder().setSinkNameWithSinkNameOneof(sinkName).build();
    return getSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a sink.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Client configServiceV2Client = ConfigServiceV2Client.create()) {
   *   SinkNameOneof sinkName = SinkNameOneof.from(SinkName.create("[PROJECT]", "[SINK]"));
   *   GetSinkRequest request = GetSinkRequest.newBuilder()
   *     .setSinkNameWithSinkNameOneof(sinkName)
   *     .build();
   *   LogSink response = configServiceV2Client.getSink(request);
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
   * try (ConfigServiceV2Client configServiceV2Client = ConfigServiceV2Client.create()) {
   *   SinkNameOneof sinkName = SinkNameOneof.from(SinkName.create("[PROJECT]", "[SINK]"));
   *   GetSinkRequest request = GetSinkRequest.newBuilder()
   *     .setSinkNameWithSinkNameOneof(sinkName)
   *     .build();
   *   RpcFuture&lt;LogSink&gt; future = configServiceV2Client.getSinkCallable().futureCall(request);
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
   * Creates a sink that exports specified log entries to a destination. The export of
   * newly-ingested log entries begins immediately, unless the current time is outside the sink's
   * start and end times or the sink's `writer_identity` is not permitted to write to the
   * destination. A sink can export log entries only from the resource owning the sink.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Client configServiceV2Client = ConfigServiceV2Client.create()) {
   *   ParentNameOneof parent = ParentNameOneof.from(ProjectName.create("[PROJECT]"));
   *   LogSink sink = LogSink.newBuilder().build();
   *   LogSink response = configServiceV2Client.createSink(parent, sink);
   * }
   * </code></pre>
   *
   * @param parent Required. The resource in which to create the sink:
   *     <p>"projects/[PROJECT_ID]" "organizations/[ORGANIZATION_ID]"
   *     <p>Examples: `"projects/my-logging-project"`, `"organizations/123456789"`.
   * @param sink Required. The new sink, whose `name` parameter is a sink identifier that is not
   *     already in use.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final LogSink createSink(ParentNameOneof parent, LogSink sink) {

    CreateSinkRequest request =
        CreateSinkRequest.newBuilder().setParentWithParentNameOneof(parent).setSink(sink).build();
    return createSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a sink that exports specified log entries to a destination. The export of
   * newly-ingested log entries begins immediately, unless the current time is outside the sink's
   * start and end times or the sink's `writer_identity` is not permitted to write to the
   * destination. A sink can export log entries only from the resource owning the sink.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Client configServiceV2Client = ConfigServiceV2Client.create()) {
   *   ParentNameOneof parent = ParentNameOneof.from(ProjectName.create("[PROJECT]"));
   *   LogSink sink = LogSink.newBuilder().build();
   *   CreateSinkRequest request = CreateSinkRequest.newBuilder()
   *     .setParentWithParentNameOneof(parent)
   *     .setSink(sink)
   *     .build();
   *   LogSink response = configServiceV2Client.createSink(request);
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
   * Creates a sink that exports specified log entries to a destination. The export of
   * newly-ingested log entries begins immediately, unless the current time is outside the sink's
   * start and end times or the sink's `writer_identity` is not permitted to write to the
   * destination. A sink can export log entries only from the resource owning the sink.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Client configServiceV2Client = ConfigServiceV2Client.create()) {
   *   ParentNameOneof parent = ParentNameOneof.from(ProjectName.create("[PROJECT]"));
   *   LogSink sink = LogSink.newBuilder().build();
   *   CreateSinkRequest request = CreateSinkRequest.newBuilder()
   *     .setParentWithParentNameOneof(parent)
   *     .setSink(sink)
   *     .build();
   *   RpcFuture&lt;LogSink&gt; future = configServiceV2Client.createSinkCallable().futureCall(request);
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
   * Updates a sink. If the named sink doesn't exist, then this method is identical to
   * [sinks.create](/logging/docs/api/reference/rest/v2/projects.sinks/create). If the named sink
   * does exist, then this method replaces the following fields in the existing sink with values
   * from the new sink: `destination`, `filter`, `output_version_format`, `start_time`, and
   * `end_time`. The updated filter might also have a new `writer_identity`; see the
   * `unique_writer_identity` field.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Client configServiceV2Client = ConfigServiceV2Client.create()) {
   *   SinkNameOneof sinkName = SinkNameOneof.from(SinkName.create("[PROJECT]", "[SINK]"));
   *   LogSink sink = LogSink.newBuilder().build();
   *   LogSink response = configServiceV2Client.updateSink(sinkName, sink);
   * }
   * </code></pre>
   *
   * @param sinkName Required. The full resource name of the sink to update, including the parent
   *     resource and the sink identifier:
   *     <p>"projects/[PROJECT_ID]/sinks/[SINK_ID]"
   *     "organizations/[ORGANIZATION_ID]/sinks/[SINK_ID]"
   *     <p>Example: `"projects/my-project-id/sinks/my-sink-id"`.
   * @param sink Required. The updated sink, whose name is the same identifier that appears as part
   *     of `sink_name`. If `sink_name` does not exist, then this method creates a new sink.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final LogSink updateSink(SinkNameOneof sinkName, LogSink sink) {

    UpdateSinkRequest request =
        UpdateSinkRequest.newBuilder().setSinkNameWithSinkNameOneof(sinkName).setSink(sink).build();
    return updateSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a sink. If the named sink doesn't exist, then this method is identical to
   * [sinks.create](/logging/docs/api/reference/rest/v2/projects.sinks/create). If the named sink
   * does exist, then this method replaces the following fields in the existing sink with values
   * from the new sink: `destination`, `filter`, `output_version_format`, `start_time`, and
   * `end_time`. The updated filter might also have a new `writer_identity`; see the
   * `unique_writer_identity` field.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Client configServiceV2Client = ConfigServiceV2Client.create()) {
   *   SinkNameOneof sinkName = SinkNameOneof.from(SinkName.create("[PROJECT]", "[SINK]"));
   *   LogSink sink = LogSink.newBuilder().build();
   *   UpdateSinkRequest request = UpdateSinkRequest.newBuilder()
   *     .setSinkNameWithSinkNameOneof(sinkName)
   *     .setSink(sink)
   *     .build();
   *   LogSink response = configServiceV2Client.updateSink(request);
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
   * Updates a sink. If the named sink doesn't exist, then this method is identical to
   * [sinks.create](/logging/docs/api/reference/rest/v2/projects.sinks/create). If the named sink
   * does exist, then this method replaces the following fields in the existing sink with values
   * from the new sink: `destination`, `filter`, `output_version_format`, `start_time`, and
   * `end_time`. The updated filter might also have a new `writer_identity`; see the
   * `unique_writer_identity` field.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Client configServiceV2Client = ConfigServiceV2Client.create()) {
   *   SinkNameOneof sinkName = SinkNameOneof.from(SinkName.create("[PROJECT]", "[SINK]"));
   *   LogSink sink = LogSink.newBuilder().build();
   *   UpdateSinkRequest request = UpdateSinkRequest.newBuilder()
   *     .setSinkNameWithSinkNameOneof(sinkName)
   *     .setSink(sink)
   *     .build();
   *   RpcFuture&lt;LogSink&gt; future = configServiceV2Client.updateSinkCallable().futureCall(request);
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
   * Deletes a sink. If the sink has a unique `writer_identity`, then that service account is also
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Client configServiceV2Client = ConfigServiceV2Client.create()) {
   *   SinkNameOneof sinkName = SinkNameOneof.from(SinkName.create("[PROJECT]", "[SINK]"));
   *   configServiceV2Client.deleteSink(sinkName);
   * }
   * </code></pre>
   *
   * @param sinkName Required. The full resource name of the sink to delete, including the parent
   *     resource and the sink identifier:
   *     <p>"projects/[PROJECT_ID]/sinks/[SINK_ID]"
   *     "organizations/[ORGANIZATION_ID]/sinks/[SINK_ID]"
   *     <p>It is an error if the sink does not exist. Example:
   *     `"projects/my-project-id/sinks/my-sink-id"`. It is an error if the sink does not exist.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void deleteSink(SinkNameOneof sinkName) {

    DeleteSinkRequest request =
        DeleteSinkRequest.newBuilder().setSinkNameWithSinkNameOneof(sinkName).build();
    deleteSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a sink. If the sink has a unique `writer_identity`, then that service account is also
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Client configServiceV2Client = ConfigServiceV2Client.create()) {
   *   SinkNameOneof sinkName = SinkNameOneof.from(SinkName.create("[PROJECT]", "[SINK]"));
   *   DeleteSinkRequest request = DeleteSinkRequest.newBuilder()
   *     .setSinkNameWithSinkNameOneof(sinkName)
   *     .build();
   *   configServiceV2Client.deleteSink(request);
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
   * Deletes a sink. If the sink has a unique `writer_identity`, then that service account is also
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ConfigServiceV2Client configServiceV2Client = ConfigServiceV2Client.create()) {
   *   SinkNameOneof sinkName = SinkNameOneof.from(SinkName.create("[PROJECT]", "[SINK]"));
   *   DeleteSinkRequest request = DeleteSinkRequest.newBuilder()
   *     .setSinkNameWithSinkNameOneof(sinkName)
   *     .build();
   *   RpcFuture&lt;Void&gt; future = configServiceV2Client.deleteSinkCallable().futureCall(request);
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
