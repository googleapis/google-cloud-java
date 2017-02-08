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
package com.google.cloud.errorreporting.spi.v1beta1;

import com.google.api.gax.grpc.ChannelAndExecutor;
import com.google.api.gax.grpc.UnaryCallable;
import com.google.devtools.clouderrorreporting.v1beta1.ProjectName;
import com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ReportedErrorEvent;
import com.google.protobuf.ExperimentalApi;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: An API for reporting error events.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ReportErrorsServiceClient reportErrorsServiceClient = ReportErrorsServiceClient.create()) {
 *   ProjectName projectName = ProjectName.create("[PROJECT]");
 *   ReportedErrorEvent event = ReportedErrorEvent.newBuilder().build();
 *   ReportErrorEventResponse response = reportErrorsServiceClient.reportErrorEvent(projectName, event);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the reportErrorsServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of ReportErrorsServiceSettings to
 * create(). For example:
 *
 * <pre>
 * <code>
 * InstantiatingChannelProvider channelProvider =
 *     ReportErrorsServiceSettings.defaultChannelProviderBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ReportErrorsServiceSettings reportErrorsServiceSettings =
 *     ReportErrorsServiceSettings.defaultBuilder().setChannelProvider(channelProvider).build();
 * ReportErrorsServiceClient reportErrorsServiceClient =
 *     ReportErrorsServiceClient.create(reportErrorsServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC")
@ExperimentalApi
public class ReportErrorsServiceClient implements AutoCloseable {
  private final ReportErrorsServiceSettings settings;
  private final ScheduledExecutorService executor;
  private final ManagedChannel channel;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final UnaryCallable<ReportErrorEventRequest, ReportErrorEventResponse>
      reportErrorEventCallable;

  /** Constructs an instance of ReportErrorsServiceClient with default settings. */
  public static final ReportErrorsServiceClient create() throws IOException {
    return create(ReportErrorsServiceSettings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of ReportErrorsServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ReportErrorsServiceClient create(ReportErrorsServiceSettings settings)
      throws IOException {
    return new ReportErrorsServiceClient(settings);
  }

  /**
   * Constructs an instance of ReportErrorsServiceClient, using the given settings. This is
   * protected so that it easy to make a subclass, but otherwise, the static factory methods should
   * be preferred.
   */
  protected ReportErrorsServiceClient(ReportErrorsServiceSettings settings) throws IOException {
    this.settings = settings;
    ChannelAndExecutor channelAndExecutor = settings.getChannelAndExecutor();
    this.executor = channelAndExecutor.getExecutor();
    this.channel = channelAndExecutor.getChannel();

    this.reportErrorEventCallable =
        UnaryCallable.create(settings.reportErrorEventSettings(), this.channel, this.executor);

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

  public final ReportErrorsServiceSettings getSettings() {
    return settings;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Report an individual error event.
   *
   * <p>This endpoint accepts &lt;strong&gt;either&lt;/strong&gt; an OAuth token,
   * &lt;strong&gt;or&lt;/strong&gt; an &lt;a
   * href="https://support.google.com/cloud/answer/6158862"&gt;API key&lt;/a&gt; for authentication.
   * To use an API key, append it to the URL as the value of a `key` parameter. For example:
   * &lt;pre&gt;POST
   * https://clouderrorreporting.googleapis.com/v1beta1/projects/example-project/events:report?key=123ABC456&lt;/pre&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReportErrorsServiceClient reportErrorsServiceClient = ReportErrorsServiceClient.create()) {
   *   ProjectName projectName = ProjectName.create("[PROJECT]");
   *   ReportedErrorEvent event = ReportedErrorEvent.newBuilder().build();
   *   ReportErrorEventResponse response = reportErrorsServiceClient.reportErrorEvent(projectName, event);
   * }
   * </code></pre>
   *
   * @param projectName [Required] The resource name of the Google Cloud Platform project. Written
   *     as `projects/` plus the [Google Cloud Platform project
   *     ID](https://support.google.com/cloud/answer/6158840). Example: `projects/my-project-123`.
   * @param event [Required] The error event to be reported.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final ReportErrorEventResponse reportErrorEvent(
      ProjectName projectName, ReportedErrorEvent event) {

    ReportErrorEventRequest request =
        ReportErrorEventRequest.newBuilder()
            .setProjectNameWithProjectName(projectName)
            .setEvent(event)
            .build();
    return reportErrorEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Report an individual error event.
   *
   * <p>This endpoint accepts &lt;strong&gt;either&lt;/strong&gt; an OAuth token,
   * &lt;strong&gt;or&lt;/strong&gt; an &lt;a
   * href="https://support.google.com/cloud/answer/6158862"&gt;API key&lt;/a&gt; for authentication.
   * To use an API key, append it to the URL as the value of a `key` parameter. For example:
   * &lt;pre&gt;POST
   * https://clouderrorreporting.googleapis.com/v1beta1/projects/example-project/events:report?key=123ABC456&lt;/pre&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReportErrorsServiceClient reportErrorsServiceClient = ReportErrorsServiceClient.create()) {
   *   ProjectName projectName = ProjectName.create("[PROJECT]");
   *   ReportedErrorEvent event = ReportedErrorEvent.newBuilder().build();
   *   ReportErrorEventRequest request = ReportErrorEventRequest.newBuilder()
   *     .setProjectNameWithProjectName(projectName)
   *     .setEvent(event)
   *     .build();
   *   ReportErrorEventResponse response = reportErrorsServiceClient.reportErrorEvent(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final ReportErrorEventResponse reportErrorEvent(ReportErrorEventRequest request) {
    return reportErrorEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Report an individual error event.
   *
   * <p>This endpoint accepts &lt;strong&gt;either&lt;/strong&gt; an OAuth token,
   * &lt;strong&gt;or&lt;/strong&gt; an &lt;a
   * href="https://support.google.com/cloud/answer/6158862"&gt;API key&lt;/a&gt; for authentication.
   * To use an API key, append it to the URL as the value of a `key` parameter. For example:
   * &lt;pre&gt;POST
   * https://clouderrorreporting.googleapis.com/v1beta1/projects/example-project/events:report?key=123ABC456&lt;/pre&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ReportErrorsServiceClient reportErrorsServiceClient = ReportErrorsServiceClient.create()) {
   *   ProjectName projectName = ProjectName.create("[PROJECT]");
   *   ReportedErrorEvent event = ReportedErrorEvent.newBuilder().build();
   *   ReportErrorEventRequest request = ReportErrorEventRequest.newBuilder()
   *     .setProjectNameWithProjectName(projectName)
   *     .setEvent(event)
   *     .build();
   *   RpcFuture&lt;ReportErrorEventResponse&gt; future = reportErrorsServiceClient.reportErrorEventCallable().futureCall(request);
   *   // Do something
   *   ReportErrorEventResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ReportErrorEventRequest, ReportErrorEventResponse>
      reportErrorEventCallable() {
    return reportErrorEventCallable;
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
