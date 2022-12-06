/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.aiplatform.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.stub.FeaturestoreOnlineServingServiceStub;
import com.google.cloud.aiplatform.v1.stub.FeaturestoreOnlineServingServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import java.io.IOException;
import java.util.List;
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FeaturestoreOnlineServingServiceSettings featurestoreOnlineServingServiceSettings =
 *     FeaturestoreOnlineServingServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
 *     FeaturestoreOnlineServingServiceClient.create(featurestoreOnlineServingServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
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

  protected FeaturestoreOnlineServingServiceClient(FeaturestoreOnlineServingServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final FeaturestoreOnlineServingServiceSettings getSettings() {
    return settings;
  }

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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   *     Value format:
   *     `projects/{project}/locations/{location}/featurestores/{featurestore}/entityTypes/{entityType}`.
   *     For example, for a machine learning model predicting user clicks on a website, an
   *     EntityType ID could be `user`.
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   *     Value format:
   *     `projects/{project}/locations/{location}/featurestores/{featurestore}/entityTypes/{entityType}`.
   *     For example, for a machine learning model predicting user clicks on a website, an
   *     EntityType ID could be `user`.
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Writes Feature values of one or more entities of an EntityType.
   *
   * <p>The Feature values are merged into existing entities if any. The Feature values to be
   * written must have timestamp within the online storage retention.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
   *     FeaturestoreOnlineServingServiceClient.create()) {
   *   EntityTypeName entityType =
   *       EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]");
   *   List<WriteFeatureValuesPayload> payloads = new ArrayList<>();
   *   WriteFeatureValuesResponse response =
   *       featurestoreOnlineServingServiceClient.writeFeatureValues(entityType, payloads);
   * }
   * }</pre>
   *
   * @param entityType Required. The resource name of the EntityType for the entities being written.
   *     Value format: `projects/{project}/locations/{location}/featurestores/
   *     {featurestore}/entityTypes/{entityType}`. For example, for a machine learning model
   *     predicting user clicks on a website, an EntityType ID could be `user`.
   * @param payloads Required. The entities to be written. Up to 100,000 feature values can be
   *     written across all `payloads`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WriteFeatureValuesResponse writeFeatureValues(
      EntityTypeName entityType, List<WriteFeatureValuesPayload> payloads) {
    WriteFeatureValuesRequest request =
        WriteFeatureValuesRequest.newBuilder()
            .setEntityType(entityType == null ? null : entityType.toString())
            .addAllPayloads(payloads)
            .build();
    return writeFeatureValues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Writes Feature values of one or more entities of an EntityType.
   *
   * <p>The Feature values are merged into existing entities if any. The Feature values to be
   * written must have timestamp within the online storage retention.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
   *     FeaturestoreOnlineServingServiceClient.create()) {
   *   String entityType =
   *       EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *           .toString();
   *   List<WriteFeatureValuesPayload> payloads = new ArrayList<>();
   *   WriteFeatureValuesResponse response =
   *       featurestoreOnlineServingServiceClient.writeFeatureValues(entityType, payloads);
   * }
   * }</pre>
   *
   * @param entityType Required. The resource name of the EntityType for the entities being written.
   *     Value format: `projects/{project}/locations/{location}/featurestores/
   *     {featurestore}/entityTypes/{entityType}`. For example, for a machine learning model
   *     predicting user clicks on a website, an EntityType ID could be `user`.
   * @param payloads Required. The entities to be written. Up to 100,000 feature values can be
   *     written across all `payloads`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WriteFeatureValuesResponse writeFeatureValues(
      String entityType, List<WriteFeatureValuesPayload> payloads) {
    WriteFeatureValuesRequest request =
        WriteFeatureValuesRequest.newBuilder()
            .setEntityType(entityType)
            .addAllPayloads(payloads)
            .build();
    return writeFeatureValues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Writes Feature values of one or more entities of an EntityType.
   *
   * <p>The Feature values are merged into existing entities if any. The Feature values to be
   * written must have timestamp within the online storage retention.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
   *     FeaturestoreOnlineServingServiceClient.create()) {
   *   WriteFeatureValuesRequest request =
   *       WriteFeatureValuesRequest.newBuilder()
   *           .setEntityType(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .addAllPayloads(new ArrayList<WriteFeatureValuesPayload>())
   *           .build();
   *   WriteFeatureValuesResponse response =
   *       featurestoreOnlineServingServiceClient.writeFeatureValues(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WriteFeatureValuesResponse writeFeatureValues(WriteFeatureValuesRequest request) {
    return writeFeatureValuesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Writes Feature values of one or more entities of an EntityType.
   *
   * <p>The Feature values are merged into existing entities if any. The Feature values to be
   * written must have timestamp within the online storage retention.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
   *     FeaturestoreOnlineServingServiceClient.create()) {
   *   WriteFeatureValuesRequest request =
   *       WriteFeatureValuesRequest.newBuilder()
   *           .setEntityType(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .addAllPayloads(new ArrayList<WriteFeatureValuesPayload>())
   *           .build();
   *   ApiFuture<WriteFeatureValuesResponse> future =
   *       featurestoreOnlineServingServiceClient.writeFeatureValuesCallable().futureCall(request);
   *   // Do something.
   *   WriteFeatureValuesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<WriteFeatureValuesRequest, WriteFeatureValuesResponse>
      writeFeatureValuesCallable() {
    return stub.writeFeatureValuesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
   *     FeaturestoreOnlineServingServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element :
   *       featurestoreOnlineServingServiceClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
   *     FeaturestoreOnlineServingServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       featurestoreOnlineServingServiceClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
   *     FeaturestoreOnlineServingServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         featurestoreOnlineServingServiceClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
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
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
   *     FeaturestoreOnlineServingServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = featurestoreOnlineServingServiceClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
   *     FeaturestoreOnlineServingServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       featurestoreOnlineServingServiceClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
   *     FeaturestoreOnlineServingServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = featurestoreOnlineServingServiceClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
   *     FeaturestoreOnlineServingServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       featurestoreOnlineServingServiceClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
   *     FeaturestoreOnlineServingServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = featurestoreOnlineServingServiceClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
   *     FeaturestoreOnlineServingServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       featurestoreOnlineServingServiceClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
   *     FeaturestoreOnlineServingServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response =
   *       featurestoreOnlineServingServiceClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
   *     FeaturestoreOnlineServingServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       featurestoreOnlineServingServiceClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
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

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
