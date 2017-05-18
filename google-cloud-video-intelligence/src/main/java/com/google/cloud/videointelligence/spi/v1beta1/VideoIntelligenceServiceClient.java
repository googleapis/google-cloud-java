/*
 * Copyright 2017, Google Inc. All rights reserved.
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
package com.google.cloud.videointelligence.spi.v1beta1;

import com.google.api.core.BetaApi;
import com.google.api.gax.grpc.ChannelAndExecutor;
import com.google.api.gax.grpc.FixedChannelProvider;
import com.google.api.gax.grpc.FixedExecutorProvider;
import com.google.api.gax.grpc.OperationCallable;
import com.google.api.gax.grpc.OperationFuture;
import com.google.api.gax.grpc.UnaryCallable;
import com.google.cloud.videointelligence.v1beta1.AnnotateVideoRequest;
import com.google.cloud.videointelligence.v1beta1.AnnotateVideoResponse;
import com.google.cloud.videointelligence.v1beta1.Feature;
import com.google.cloud.videointelligence.v1beta1.VideoContext;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.longrunning.OperationsSettings;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Service that implements Google Cloud Video Intelligence API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (VideoIntelligenceServiceClient videoIntelligenceServiceClient = VideoIntelligenceServiceClient.create()) {
 *   String inputUri = "";
 *   List&lt;Feature&gt; features = new ArrayList&lt;&gt;();
 *   VideoContext videoContext = VideoContext.newBuilder().build();
 *   String outputUri = "";
 *   String locationId = "";
 *   AnnotateVideoResponse response = videoIntelligenceServiceClient.annotateVideoAsync(inputUri, features, videoContext, outputUri, locationId).get();
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the videoIntelligenceServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of
 * VideoIntelligenceServiceSettings to create(). For example:
 *
 * <pre>
 * <code>
 * InstantiatingChannelProvider channelProvider =
 *     VideoIntelligenceServiceSettings.defaultChannelProviderBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * VideoIntelligenceServiceSettings videoIntelligenceServiceSettings =
 *     VideoIntelligenceServiceSettings.defaultBuilder().setChannelProvider(channelProvider).build();
 * VideoIntelligenceServiceClient videoIntelligenceServiceClient =
 *     VideoIntelligenceServiceClient.create(videoIntelligenceServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC")
@BetaApi
public class VideoIntelligenceServiceClient implements AutoCloseable {
  private final VideoIntelligenceServiceSettings settings;
  private final ScheduledExecutorService executor;
  private final ManagedChannel channel;
  private final OperationsClient operationsClient;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final UnaryCallable<AnnotateVideoRequest, Operation> annotateVideoCallable;
  private final OperationCallable<AnnotateVideoRequest, AnnotateVideoResponse>
      annotateVideoOperationCallable;

  /** Constructs an instance of VideoIntelligenceServiceClient with default settings. */
  public static final VideoIntelligenceServiceClient create() throws IOException {
    return create(VideoIntelligenceServiceSettings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of VideoIntelligenceServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final VideoIntelligenceServiceClient create(
      VideoIntelligenceServiceSettings settings) throws IOException {
    return new VideoIntelligenceServiceClient(settings);
  }

  /**
   * Constructs an instance of VideoIntelligenceServiceClient, using the given settings. This is
   * protected so that it easy to make a subclass, but otherwise, the static factory methods should
   * be preferred.
   */
  protected VideoIntelligenceServiceClient(VideoIntelligenceServiceSettings settings)
      throws IOException {
    this.settings = settings;
    ChannelAndExecutor channelAndExecutor = settings.getChannelAndExecutor();
    this.executor = channelAndExecutor.getExecutor();
    this.channel = channelAndExecutor.getChannel();

    FixedExecutorProvider executorProvider = FixedExecutorProvider.create(this.executor);
    FixedChannelProvider channelProvider = FixedChannelProvider.create(this.channel);
    OperationsSettings operationsSettings =
        OperationsSettings.defaultBuilder()
            .setExecutorProvider(executorProvider)
            .setChannelProvider(channelProvider)
            .build();
    this.operationsClient = OperationsClient.create(operationsSettings);

    this.annotateVideoCallable =
        UnaryCallable.create(
            settings.annotateVideoSettings().getInitialCallSettings(), this.channel, this.executor);
    this.annotateVideoOperationCallable =
        OperationCallable.create(
            settings.annotateVideoSettings(), this.channel, this.executor, this.operationsClient);

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

  public final VideoIntelligenceServiceSettings getSettings() {
    return settings;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Performs asynchronous video annotation. Progress and results can be retrieved through the
   * `google.longrunning.Operations` interface. `Operation.metadata` contains
   * `AnnotateVideoProgress` (progress). `Operation.response` contains `AnnotateVideoResponse`
   * (results).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VideoIntelligenceServiceClient videoIntelligenceServiceClient = VideoIntelligenceServiceClient.create()) {
   *   String inputUri = "";
   *   List&lt;Feature&gt; features = new ArrayList&lt;&gt;();
   *   VideoContext videoContext = VideoContext.newBuilder().build();
   *   String outputUri = "";
   *   String locationId = "";
   *   AnnotateVideoResponse response = videoIntelligenceServiceClient.annotateVideoAsync(inputUri, features, videoContext, outputUri, locationId).get();
   * }
   * </code></pre>
   *
   * @param inputUri Input video location. Currently, only [Google Cloud
   *     Storage](https://cloud.google.com/storage/) URIs are supported, which must be specified in
   *     the following format: `gs://bucket-id/object-id` (other URI formats return
   *     [google.rpc.Code.INVALID_ARGUMENT][google.rpc.Code.INVALID_ARGUMENT]). For more
   *     information, see [Request URIs](/storage/docs/reference-uris). A video URI may include
   *     wildcards in `object-id`, and thus identify multiple videos. Supported wildcards: '&#42;'
   *     to match 0 or more characters; '?' to match 1 character. If unset, the input video should
   *     be embedded in the request as `input_content`. If set, `input_content` should be unset.
   * @param features Requested video annotation features.
   * @param videoContext Additional video context and/or feature-specific parameters.
   * @param outputUri Optional location where the output (in JSON format) should be stored.
   *     Currently, only [Google Cloud Storage](https://cloud.google.com/storage/) URIs are
   *     supported, which must be specified in the following format: `gs://bucket-id/object-id`
   *     (other URI formats return
   *     [google.rpc.Code.INVALID_ARGUMENT][google.rpc.Code.INVALID_ARGUMENT]). For more
   *     information, see [Request URIs](/storage/docs/reference-uris).
   * @param locationId Optional cloud region where annotation should take place. Supported cloud
   *     regions: `us-east1`, `us-west1`, `europe-west1`, `asia-east1`. If no region is specified, a
   *     region will be determined based on video file location.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final OperationFuture<AnnotateVideoResponse> annotateVideoAsync(
      String inputUri,
      List<Feature> features,
      VideoContext videoContext,
      String outputUri,
      String locationId) {

    AnnotateVideoRequest request =
        AnnotateVideoRequest.newBuilder()
            .setInputUri(inputUri)
            .addAllFeatures(features)
            .setVideoContext(videoContext)
            .setOutputUri(outputUri)
            .setLocationId(locationId)
            .build();
    return annotateVideoAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Performs asynchronous video annotation. Progress and results can be retrieved through the
   * `google.longrunning.Operations` interface. `Operation.metadata` contains
   * `AnnotateVideoProgress` (progress). `Operation.response` contains `AnnotateVideoResponse`
   * (results).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VideoIntelligenceServiceClient videoIntelligenceServiceClient = VideoIntelligenceServiceClient.create()) {
   *   String inputUri = "";
   *   List&lt;Feature&gt; features = new ArrayList&lt;&gt;();
   *   AnnotateVideoRequest request = AnnotateVideoRequest.newBuilder()
   *     .setInputUri(inputUri)
   *     .addAllFeatures(features)
   *     .build();
   *   AnnotateVideoResponse response = videoIntelligenceServiceClient.annotateVideoAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final OperationFuture<AnnotateVideoResponse> annotateVideoAsync(
      AnnotateVideoRequest request) {
    return annotateVideoOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Performs asynchronous video annotation. Progress and results can be retrieved through the
   * `google.longrunning.Operations` interface. `Operation.metadata` contains
   * `AnnotateVideoProgress` (progress). `Operation.response` contains `AnnotateVideoResponse`
   * (results).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VideoIntelligenceServiceClient videoIntelligenceServiceClient = VideoIntelligenceServiceClient.create()) {
   *   String inputUri = "";
   *   List&lt;Feature&gt; features = new ArrayList&lt;&gt;();
   *   AnnotateVideoRequest request = AnnotateVideoRequest.newBuilder()
   *     .setInputUri(inputUri)
   *     .addAllFeatures(features)
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = videoIntelligenceServiceClient.annotateVideoOperationCallable().futureCall(request);
   *   // Do something
   *   AnnotateVideoResponse response = future.get();
   * }
   * </code></pre>
   */
  public final OperationCallable<AnnotateVideoRequest, AnnotateVideoResponse>
      annotateVideoOperationCallable() {
    return annotateVideoOperationCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Performs asynchronous video annotation. Progress and results can be retrieved through the
   * `google.longrunning.Operations` interface. `Operation.metadata` contains
   * `AnnotateVideoProgress` (progress). `Operation.response` contains `AnnotateVideoResponse`
   * (results).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VideoIntelligenceServiceClient videoIntelligenceServiceClient = VideoIntelligenceServiceClient.create()) {
   *   String inputUri = "";
   *   List&lt;Feature&gt; features = new ArrayList&lt;&gt;();
   *   AnnotateVideoRequest request = AnnotateVideoRequest.newBuilder()
   *     .setInputUri(inputUri)
   *     .addAllFeatures(features)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = videoIntelligenceServiceClient.annotateVideoCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AnnotateVideoRequest, Operation> annotateVideoCallable() {
    return annotateVideoCallable;
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
