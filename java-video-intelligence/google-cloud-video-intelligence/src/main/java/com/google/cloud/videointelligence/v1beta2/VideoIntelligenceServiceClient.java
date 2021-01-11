/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.videointelligence.v1beta2;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.videointelligence.v1beta2.stub.VideoIntelligenceServiceStub;
import com.google.cloud.videointelligence.v1beta2.stub.VideoIntelligenceServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service that implements Google Cloud Video Intelligence API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the VideoIntelligenceServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
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
 * <p>To customize credentials:
 *
 * <pre>{@code
 * VideoIntelligenceServiceSettings videoIntelligenceServiceSettings =
 *     VideoIntelligenceServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * VideoIntelligenceServiceClient videoIntelligenceServiceClient =
 *     VideoIntelligenceServiceClient.create(videoIntelligenceServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * VideoIntelligenceServiceSettings videoIntelligenceServiceSettings =
 *     VideoIntelligenceServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * VideoIntelligenceServiceClient videoIntelligenceServiceClient =
 *     VideoIntelligenceServiceClient.create(videoIntelligenceServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class VideoIntelligenceServiceClient implements BackgroundResource {
  private final VideoIntelligenceServiceSettings settings;
  private final VideoIntelligenceServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of VideoIntelligenceServiceClient with default settings. */
  public static final VideoIntelligenceServiceClient create() throws IOException {
    return create(VideoIntelligenceServiceSettings.newBuilder().build());
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
   * Constructs an instance of VideoIntelligenceServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(VideoIntelligenceServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final VideoIntelligenceServiceClient create(VideoIntelligenceServiceStub stub) {
    return new VideoIntelligenceServiceClient(stub);
  }

  /**
   * Constructs an instance of VideoIntelligenceServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected VideoIntelligenceServiceClient(VideoIntelligenceServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((VideoIntelligenceServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected VideoIntelligenceServiceClient(VideoIntelligenceServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final VideoIntelligenceServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public VideoIntelligenceServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs asynchronous video annotation. Progress and results can be retrieved through the
   * `google.longrunning.Operations` interface. `Operation.metadata` contains
   * `AnnotateVideoProgress` (progress). `Operation.response` contains `AnnotateVideoResponse`
   * (results).
   *
   * @param inputUri Input video location. Currently, only [Google Cloud
   *     Storage](https://cloud.google.com/storage/) URIs are supported, which must be specified in
   *     the following format: `gs://bucket-id/object-id` (other URI formats return
   *     [google.rpc.Code.INVALID_ARGUMENT][google.rpc.Code.INVALID_ARGUMENT]). For more
   *     information, see [Request URIs](https://cloud.google.com/storage/docs/request-endpoints). A
   *     video URI may include wildcards in `object-id`, and thus identify multiple videos.
   *     Supported wildcards: '&#42;' to match 0 or more characters; '?' to match 1 character. If
   *     unset, the input video should be embedded in the request as `input_content`. If set,
   *     `input_content` should be unset.
   * @param features Required. Requested video annotation features.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AnnotateVideoResponse, AnnotateVideoProgress> annotateVideoAsync(
      String inputUri, List<Feature> features) {
    AnnotateVideoRequest request =
        AnnotateVideoRequest.newBuilder().setInputUri(inputUri).addAllFeatures(features).build();
    return annotateVideoAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs asynchronous video annotation. Progress and results can be retrieved through the
   * `google.longrunning.Operations` interface. `Operation.metadata` contains
   * `AnnotateVideoProgress` (progress). `Operation.response` contains `AnnotateVideoResponse`
   * (results).
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AnnotateVideoResponse, AnnotateVideoProgress> annotateVideoAsync(
      AnnotateVideoRequest request) {
    return annotateVideoOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs asynchronous video annotation. Progress and results can be retrieved through the
   * `google.longrunning.Operations` interface. `Operation.metadata` contains
   * `AnnotateVideoProgress` (progress). `Operation.response` contains `AnnotateVideoResponse`
   * (results).
   *
   * <p>Sample code:
   */
  public final OperationCallable<AnnotateVideoRequest, AnnotateVideoResponse, AnnotateVideoProgress>
      annotateVideoOperationCallable() {
    return stub.annotateVideoOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs asynchronous video annotation. Progress and results can be retrieved through the
   * `google.longrunning.Operations` interface. `Operation.metadata` contains
   * `AnnotateVideoProgress` (progress). `Operation.response` contains `AnnotateVideoResponse`
   * (results).
   *
   * <p>Sample code:
   */
  public final UnaryCallable<AnnotateVideoRequest, Operation> annotateVideoCallable() {
    return stub.annotateVideoCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }
}
