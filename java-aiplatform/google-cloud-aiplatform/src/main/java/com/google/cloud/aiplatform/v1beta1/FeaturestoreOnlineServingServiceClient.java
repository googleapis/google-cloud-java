/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.aiplatform.v1beta1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.stub.FeaturestoreOnlineServingServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.FeaturestoreOnlineServingServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service for serving online feature values.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
 *     FeaturestoreOnlineServingServiceClient.create()) {
 *   EntityTypeName entityType =
 *       EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]");
 *   ReadFeatureValuesResponse response =
 *       featurestoreOnlineServingServiceClient.readFeatureValues(entityType);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the FeaturestoreOnlineServingServiceClient object to clean
 * up resources such as threads. In the example above, try-with-resources is used, which
 * automatically calls close().
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
 * FeaturestoreOnlineServingServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * FeaturestoreOnlineServingServiceSettings featurestoreOnlineServingServiceSettings =
 *     FeaturestoreOnlineServingServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
 *     FeaturestoreOnlineServingServiceClient.create(featurestoreOnlineServingServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * FeaturestoreOnlineServingServiceSettings featurestoreOnlineServingServiceSettings =
 *     FeaturestoreOnlineServingServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
 *     FeaturestoreOnlineServingServiceClient.create(featurestoreOnlineServingServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class FeaturestoreOnlineServingServiceClient implements BackgroundResource {
  private final FeaturestoreOnlineServingServiceSettings settings;
  private final FeaturestoreOnlineServingServiceStub stub;

  /** Constructs an instance of FeaturestoreOnlineServingServiceClient with default settings. */
  public static final FeaturestoreOnlineServingServiceClient create() throws IOException {
    return create(FeaturestoreOnlineServingServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of FeaturestoreOnlineServingServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final FeaturestoreOnlineServingServiceClient create(
      FeaturestoreOnlineServingServiceSettings settings) throws IOException {
    return new FeaturestoreOnlineServingServiceClient(settings);
  }

  /**
   * Constructs an instance of FeaturestoreOnlineServingServiceClient, using the given stub for
   * making calls. This is for advanced usage - prefer using
   * create(FeaturestoreOnlineServingServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final FeaturestoreOnlineServingServiceClient create(
      FeaturestoreOnlineServingServiceStub stub) {
    return new FeaturestoreOnlineServingServiceClient(stub);
  }

  /**
   * Constructs an instance of FeaturestoreOnlineServingServiceClient, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected FeaturestoreOnlineServingServiceClient(
      FeaturestoreOnlineServingServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub =
        ((FeaturestoreOnlineServingServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected FeaturestoreOnlineServingServiceClient(FeaturestoreOnlineServingServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final FeaturestoreOnlineServingServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public FeaturestoreOnlineServingServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads Feature values of a specific entity of an EntityType. For reading feature values of
   * multiple entities of an EntityType, please use StreamingReadFeatureValues.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
   *     FeaturestoreOnlineServingServiceClient.create()) {
   *   EntityTypeName entityType =
   *       EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]");
   *   ReadFeatureValuesResponse response =
   *       featurestoreOnlineServingServiceClient.readFeatureValues(entityType);
   * }
   * }</pre>
   *
   * @param entityType Required. The resource name of the EntityType for the entity being read.
   *     Value format: `projects/{project}/locations/{location}/featurestores/
   *     {featurestore}/entityTypes/{entityType}`. For example, for a machine learning model
   *     predicting user clicks on a website, an EntityType ID could be "user".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReadFeatureValuesResponse readFeatureValues(EntityTypeName entityType) {
    ReadFeatureValuesRequest request =
        ReadFeatureValuesRequest.newBuilder()
            .setEntityType(entityType == null ? null : entityType.toString())
            .build();
    return readFeatureValues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads Feature values of a specific entity of an EntityType. For reading feature values of
   * multiple entities of an EntityType, please use StreamingReadFeatureValues.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
   *     FeaturestoreOnlineServingServiceClient.create()) {
   *   String entityType =
   *       EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *           .toString();
   *   ReadFeatureValuesResponse response =
   *       featurestoreOnlineServingServiceClient.readFeatureValues(entityType);
   * }
   * }</pre>
   *
   * @param entityType Required. The resource name of the EntityType for the entity being read.
   *     Value format: `projects/{project}/locations/{location}/featurestores/
   *     {featurestore}/entityTypes/{entityType}`. For example, for a machine learning model
   *     predicting user clicks on a website, an EntityType ID could be "user".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReadFeatureValuesResponse readFeatureValues(String entityType) {
    ReadFeatureValuesRequest request =
        ReadFeatureValuesRequest.newBuilder().setEntityType(entityType).build();
    return readFeatureValues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads Feature values of a specific entity of an EntityType. For reading feature values of
   * multiple entities of an EntityType, please use StreamingReadFeatureValues.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
   *     FeaturestoreOnlineServingServiceClient.create()) {
   *   ReadFeatureValuesRequest request =
   *       ReadFeatureValuesRequest.newBuilder()
   *           .setEntityType(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setEntityId("entityId-2102099874")
   *           .setFeatureSelector(FeatureSelector.newBuilder().build())
   *           .build();
   *   ReadFeatureValuesResponse response =
   *       featurestoreOnlineServingServiceClient.readFeatureValues(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReadFeatureValuesResponse readFeatureValues(ReadFeatureValuesRequest request) {
    return readFeatureValuesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads Feature values of a specific entity of an EntityType. For reading feature values of
   * multiple entities of an EntityType, please use StreamingReadFeatureValues.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
   *     FeaturestoreOnlineServingServiceClient.create()) {
   *   ReadFeatureValuesRequest request =
   *       ReadFeatureValuesRequest.newBuilder()
   *           .setEntityType(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setEntityId("entityId-2102099874")
   *           .setFeatureSelector(FeatureSelector.newBuilder().build())
   *           .build();
   *   ApiFuture<ReadFeatureValuesResponse> future =
   *       featurestoreOnlineServingServiceClient.readFeatureValuesCallable().futureCall(request);
   *   // Do something.
   *   ReadFeatureValuesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ReadFeatureValuesRequest, ReadFeatureValuesResponse>
      readFeatureValuesCallable() {
    return stub.readFeatureValuesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads Feature values for multiple entities. Depending on their size, data for different
   * entities may be broken up across multiple responses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
   *     FeaturestoreOnlineServingServiceClient.create()) {
   *   StreamingReadFeatureValuesRequest request =
   *       StreamingReadFeatureValuesRequest.newBuilder()
   *           .setEntityType(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .addAllEntityIds(new ArrayList<String>())
   *           .setFeatureSelector(FeatureSelector.newBuilder().build())
   *           .build();
   *   ServerStream<ReadFeatureValuesResponse> stream =
   *       featurestoreOnlineServingServiceClient.streamingReadFeatureValuesCallable().call(request);
   *   for (ReadFeatureValuesResponse response : stream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final ServerStreamingCallable<StreamingReadFeatureValuesRequest, ReadFeatureValuesResponse>
      streamingReadFeatureValuesCallable() {
    return stub.streamingReadFeatureValuesCallable();
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
