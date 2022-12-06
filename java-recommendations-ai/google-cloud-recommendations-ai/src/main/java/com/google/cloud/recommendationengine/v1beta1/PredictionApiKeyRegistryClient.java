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

package com.google.cloud.recommendationengine.v1beta1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.recommendationengine.v1beta1.stub.PredictionApiKeyRegistryStub;
import com.google.cloud.recommendationengine.v1beta1.stub.PredictionApiKeyRegistryStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for registering API keys for use with the `predict` method. If you
 * use an API key to request predictions, you must first register the API key. Otherwise, your
 * prediction request is rejected. If you use OAuth to authenticate your `predict` method call, you
 * do not need to register an API key. You can register up to 20 API keys per project.
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
 * try (PredictionApiKeyRegistryClient predictionApiKeyRegistryClient =
 *     PredictionApiKeyRegistryClient.create()) {
 *   EventStoreName parent =
 *       EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
 *   PredictionApiKeyRegistration predictionApiKeyRegistration =
 *       PredictionApiKeyRegistration.newBuilder().build();
 *   PredictionApiKeyRegistration response =
 *       predictionApiKeyRegistryClient.createPredictionApiKeyRegistration(
 *           parent, predictionApiKeyRegistration);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PredictionApiKeyRegistryClient object to clean up
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
 * PredictionApiKeyRegistrySettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PredictionApiKeyRegistrySettings predictionApiKeyRegistrySettings =
 *     PredictionApiKeyRegistrySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PredictionApiKeyRegistryClient predictionApiKeyRegistryClient =
 *     PredictionApiKeyRegistryClient.create(predictionApiKeyRegistrySettings);
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
 * PredictionApiKeyRegistrySettings predictionApiKeyRegistrySettings =
 *     PredictionApiKeyRegistrySettings.newBuilder().setEndpoint(myEndpoint).build();
 * PredictionApiKeyRegistryClient predictionApiKeyRegistryClient =
 *     PredictionApiKeyRegistryClient.create(predictionApiKeyRegistrySettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PredictionApiKeyRegistrySettings predictionApiKeyRegistrySettings =
 *     PredictionApiKeyRegistrySettings.newHttpJsonBuilder().build();
 * PredictionApiKeyRegistryClient predictionApiKeyRegistryClient =
 *     PredictionApiKeyRegistryClient.create(predictionApiKeyRegistrySettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class PredictionApiKeyRegistryClient implements BackgroundResource {
  private final PredictionApiKeyRegistrySettings settings;
  private final PredictionApiKeyRegistryStub stub;

  /** Constructs an instance of PredictionApiKeyRegistryClient with default settings. */
  public static final PredictionApiKeyRegistryClient create() throws IOException {
    return create(PredictionApiKeyRegistrySettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PredictionApiKeyRegistryClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final PredictionApiKeyRegistryClient create(
      PredictionApiKeyRegistrySettings settings) throws IOException {
    return new PredictionApiKeyRegistryClient(settings);
  }

  /**
   * Constructs an instance of PredictionApiKeyRegistryClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(PredictionApiKeyRegistrySettings).
   */
  public static final PredictionApiKeyRegistryClient create(PredictionApiKeyRegistryStub stub) {
    return new PredictionApiKeyRegistryClient(stub);
  }

  /**
   * Constructs an instance of PredictionApiKeyRegistryClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected PredictionApiKeyRegistryClient(PredictionApiKeyRegistrySettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((PredictionApiKeyRegistryStubSettings) settings.getStubSettings()).createStub();
  }

  protected PredictionApiKeyRegistryClient(PredictionApiKeyRegistryStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PredictionApiKeyRegistrySettings getSettings() {
    return settings;
  }

  public PredictionApiKeyRegistryStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Register an API key for use with predict method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionApiKeyRegistryClient predictionApiKeyRegistryClient =
   *     PredictionApiKeyRegistryClient.create()) {
   *   EventStoreName parent =
   *       EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   PredictionApiKeyRegistration predictionApiKeyRegistration =
   *       PredictionApiKeyRegistration.newBuilder().build();
   *   PredictionApiKeyRegistration response =
   *       predictionApiKeyRegistryClient.createPredictionApiKeyRegistration(
   *           parent, predictionApiKeyRegistration);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource path.
   *     `projects/&#42;/locations/global/catalogs/default_catalog/eventStores/default_event_store`.
   * @param predictionApiKeyRegistration Required. The prediction API key registration.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PredictionApiKeyRegistration createPredictionApiKeyRegistration(
      EventStoreName parent, PredictionApiKeyRegistration predictionApiKeyRegistration) {
    CreatePredictionApiKeyRegistrationRequest request =
        CreatePredictionApiKeyRegistrationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPredictionApiKeyRegistration(predictionApiKeyRegistration)
            .build();
    return createPredictionApiKeyRegistration(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Register an API key for use with predict method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionApiKeyRegistryClient predictionApiKeyRegistryClient =
   *     PredictionApiKeyRegistryClient.create()) {
   *   String parent =
   *       EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]").toString();
   *   PredictionApiKeyRegistration predictionApiKeyRegistration =
   *       PredictionApiKeyRegistration.newBuilder().build();
   *   PredictionApiKeyRegistration response =
   *       predictionApiKeyRegistryClient.createPredictionApiKeyRegistration(
   *           parent, predictionApiKeyRegistration);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource path.
   *     `projects/&#42;/locations/global/catalogs/default_catalog/eventStores/default_event_store`.
   * @param predictionApiKeyRegistration Required. The prediction API key registration.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PredictionApiKeyRegistration createPredictionApiKeyRegistration(
      String parent, PredictionApiKeyRegistration predictionApiKeyRegistration) {
    CreatePredictionApiKeyRegistrationRequest request =
        CreatePredictionApiKeyRegistrationRequest.newBuilder()
            .setParent(parent)
            .setPredictionApiKeyRegistration(predictionApiKeyRegistration)
            .build();
    return createPredictionApiKeyRegistration(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Register an API key for use with predict method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionApiKeyRegistryClient predictionApiKeyRegistryClient =
   *     PredictionApiKeyRegistryClient.create()) {
   *   CreatePredictionApiKeyRegistrationRequest request =
   *       CreatePredictionApiKeyRegistrationRequest.newBuilder()
   *           .setParent(
   *               EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]")
   *                   .toString())
   *           .setPredictionApiKeyRegistration(PredictionApiKeyRegistration.newBuilder().build())
   *           .build();
   *   PredictionApiKeyRegistration response =
   *       predictionApiKeyRegistryClient.createPredictionApiKeyRegistration(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PredictionApiKeyRegistration createPredictionApiKeyRegistration(
      CreatePredictionApiKeyRegistrationRequest request) {
    return createPredictionApiKeyRegistrationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Register an API key for use with predict method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionApiKeyRegistryClient predictionApiKeyRegistryClient =
   *     PredictionApiKeyRegistryClient.create()) {
   *   CreatePredictionApiKeyRegistrationRequest request =
   *       CreatePredictionApiKeyRegistrationRequest.newBuilder()
   *           .setParent(
   *               EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]")
   *                   .toString())
   *           .setPredictionApiKeyRegistration(PredictionApiKeyRegistration.newBuilder().build())
   *           .build();
   *   ApiFuture<PredictionApiKeyRegistration> future =
   *       predictionApiKeyRegistryClient
   *           .createPredictionApiKeyRegistrationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   PredictionApiKeyRegistration response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          CreatePredictionApiKeyRegistrationRequest, PredictionApiKeyRegistration>
      createPredictionApiKeyRegistrationCallable() {
    return stub.createPredictionApiKeyRegistrationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the registered apiKeys for use with predict method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionApiKeyRegistryClient predictionApiKeyRegistryClient =
   *     PredictionApiKeyRegistryClient.create()) {
   *   EventStoreName parent =
   *       EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   for (PredictionApiKeyRegistration element :
   *       predictionApiKeyRegistryClient.listPredictionApiKeyRegistrations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent placement resource name such as
   *     `projects/1234/locations/global/catalogs/default_catalog/eventStores/default_event_store`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPredictionApiKeyRegistrationsPagedResponse listPredictionApiKeyRegistrations(
      EventStoreName parent) {
    ListPredictionApiKeyRegistrationsRequest request =
        ListPredictionApiKeyRegistrationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPredictionApiKeyRegistrations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the registered apiKeys for use with predict method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionApiKeyRegistryClient predictionApiKeyRegistryClient =
   *     PredictionApiKeyRegistryClient.create()) {
   *   String parent =
   *       EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]").toString();
   *   for (PredictionApiKeyRegistration element :
   *       predictionApiKeyRegistryClient.listPredictionApiKeyRegistrations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent placement resource name such as
   *     `projects/1234/locations/global/catalogs/default_catalog/eventStores/default_event_store`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPredictionApiKeyRegistrationsPagedResponse listPredictionApiKeyRegistrations(
      String parent) {
    ListPredictionApiKeyRegistrationsRequest request =
        ListPredictionApiKeyRegistrationsRequest.newBuilder().setParent(parent).build();
    return listPredictionApiKeyRegistrations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the registered apiKeys for use with predict method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionApiKeyRegistryClient predictionApiKeyRegistryClient =
   *     PredictionApiKeyRegistryClient.create()) {
   *   ListPredictionApiKeyRegistrationsRequest request =
   *       ListPredictionApiKeyRegistrationsRequest.newBuilder()
   *           .setParent(
   *               EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (PredictionApiKeyRegistration element :
   *       predictionApiKeyRegistryClient.listPredictionApiKeyRegistrations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPredictionApiKeyRegistrationsPagedResponse listPredictionApiKeyRegistrations(
      ListPredictionApiKeyRegistrationsRequest request) {
    return listPredictionApiKeyRegistrationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the registered apiKeys for use with predict method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionApiKeyRegistryClient predictionApiKeyRegistryClient =
   *     PredictionApiKeyRegistryClient.create()) {
   *   ListPredictionApiKeyRegistrationsRequest request =
   *       ListPredictionApiKeyRegistrationsRequest.newBuilder()
   *           .setParent(
   *               EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<PredictionApiKeyRegistration> future =
   *       predictionApiKeyRegistryClient
   *           .listPredictionApiKeyRegistrationsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (PredictionApiKeyRegistration element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListPredictionApiKeyRegistrationsRequest, ListPredictionApiKeyRegistrationsPagedResponse>
      listPredictionApiKeyRegistrationsPagedCallable() {
    return stub.listPredictionApiKeyRegistrationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the registered apiKeys for use with predict method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionApiKeyRegistryClient predictionApiKeyRegistryClient =
   *     PredictionApiKeyRegistryClient.create()) {
   *   ListPredictionApiKeyRegistrationsRequest request =
   *       ListPredictionApiKeyRegistrationsRequest.newBuilder()
   *           .setParent(
   *               EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListPredictionApiKeyRegistrationsResponse response =
   *         predictionApiKeyRegistryClient
   *             .listPredictionApiKeyRegistrationsCallable()
   *             .call(request);
   *     for (PredictionApiKeyRegistration element :
   *         response.getPredictionApiKeyRegistrationsList()) {
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
  public final UnaryCallable<
          ListPredictionApiKeyRegistrationsRequest, ListPredictionApiKeyRegistrationsResponse>
      listPredictionApiKeyRegistrationsCallable() {
    return stub.listPredictionApiKeyRegistrationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unregister an apiKey from using for predict method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionApiKeyRegistryClient predictionApiKeyRegistryClient =
   *     PredictionApiKeyRegistryClient.create()) {
   *   PredictionApiKeyRegistrationName name =
   *       PredictionApiKeyRegistrationName.of(
   *           "[PROJECT]",
   *           "[LOCATION]",
   *           "[CATALOG]",
   *           "[EVENT_STORE]",
   *           "[PREDICTION_API_KEY_REGISTRATION]");
   *   predictionApiKeyRegistryClient.deletePredictionApiKeyRegistration(name);
   * }
   * }</pre>
   *
   * @param name Required. The API key to unregister including full resource path.
   *     `projects/&#42;/locations/global/catalogs/default_catalog/eventStores/default_event_store/predictionApiKeyRegistrations/&lt;YOUR_API_KEY&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePredictionApiKeyRegistration(PredictionApiKeyRegistrationName name) {
    DeletePredictionApiKeyRegistrationRequest request =
        DeletePredictionApiKeyRegistrationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deletePredictionApiKeyRegistration(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unregister an apiKey from using for predict method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionApiKeyRegistryClient predictionApiKeyRegistryClient =
   *     PredictionApiKeyRegistryClient.create()) {
   *   String name =
   *       PredictionApiKeyRegistrationName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[CATALOG]",
   *               "[EVENT_STORE]",
   *               "[PREDICTION_API_KEY_REGISTRATION]")
   *           .toString();
   *   predictionApiKeyRegistryClient.deletePredictionApiKeyRegistration(name);
   * }
   * }</pre>
   *
   * @param name Required. The API key to unregister including full resource path.
   *     `projects/&#42;/locations/global/catalogs/default_catalog/eventStores/default_event_store/predictionApiKeyRegistrations/&lt;YOUR_API_KEY&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePredictionApiKeyRegistration(String name) {
    DeletePredictionApiKeyRegistrationRequest request =
        DeletePredictionApiKeyRegistrationRequest.newBuilder().setName(name).build();
    deletePredictionApiKeyRegistration(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unregister an apiKey from using for predict method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionApiKeyRegistryClient predictionApiKeyRegistryClient =
   *     PredictionApiKeyRegistryClient.create()) {
   *   DeletePredictionApiKeyRegistrationRequest request =
   *       DeletePredictionApiKeyRegistrationRequest.newBuilder()
   *           .setName(
   *               PredictionApiKeyRegistrationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[CATALOG]",
   *                       "[EVENT_STORE]",
   *                       "[PREDICTION_API_KEY_REGISTRATION]")
   *                   .toString())
   *           .build();
   *   predictionApiKeyRegistryClient.deletePredictionApiKeyRegistration(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePredictionApiKeyRegistration(
      DeletePredictionApiKeyRegistrationRequest request) {
    deletePredictionApiKeyRegistrationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unregister an apiKey from using for predict method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionApiKeyRegistryClient predictionApiKeyRegistryClient =
   *     PredictionApiKeyRegistryClient.create()) {
   *   DeletePredictionApiKeyRegistrationRequest request =
   *       DeletePredictionApiKeyRegistrationRequest.newBuilder()
   *           .setName(
   *               PredictionApiKeyRegistrationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[CATALOG]",
   *                       "[EVENT_STORE]",
   *                       "[PREDICTION_API_KEY_REGISTRATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       predictionApiKeyRegistryClient
   *           .deletePredictionApiKeyRegistrationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePredictionApiKeyRegistrationRequest, Empty>
      deletePredictionApiKeyRegistrationCallable() {
    return stub.deletePredictionApiKeyRegistrationCallable();
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

  public static class ListPredictionApiKeyRegistrationsPagedResponse
      extends AbstractPagedListResponse<
          ListPredictionApiKeyRegistrationsRequest,
          ListPredictionApiKeyRegistrationsResponse,
          PredictionApiKeyRegistration,
          ListPredictionApiKeyRegistrationsPage,
          ListPredictionApiKeyRegistrationsFixedSizeCollection> {

    public static ApiFuture<ListPredictionApiKeyRegistrationsPagedResponse> createAsync(
        PageContext<
                ListPredictionApiKeyRegistrationsRequest,
                ListPredictionApiKeyRegistrationsResponse,
                PredictionApiKeyRegistration>
            context,
        ApiFuture<ListPredictionApiKeyRegistrationsResponse> futureResponse) {
      ApiFuture<ListPredictionApiKeyRegistrationsPage> futurePage =
          ListPredictionApiKeyRegistrationsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPredictionApiKeyRegistrationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPredictionApiKeyRegistrationsPagedResponse(
        ListPredictionApiKeyRegistrationsPage page) {
      super(page, ListPredictionApiKeyRegistrationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPredictionApiKeyRegistrationsPage
      extends AbstractPage<
          ListPredictionApiKeyRegistrationsRequest,
          ListPredictionApiKeyRegistrationsResponse,
          PredictionApiKeyRegistration,
          ListPredictionApiKeyRegistrationsPage> {

    private ListPredictionApiKeyRegistrationsPage(
        PageContext<
                ListPredictionApiKeyRegistrationsRequest,
                ListPredictionApiKeyRegistrationsResponse,
                PredictionApiKeyRegistration>
            context,
        ListPredictionApiKeyRegistrationsResponse response) {
      super(context, response);
    }

    private static ListPredictionApiKeyRegistrationsPage createEmptyPage() {
      return new ListPredictionApiKeyRegistrationsPage(null, null);
    }

    @Override
    protected ListPredictionApiKeyRegistrationsPage createPage(
        PageContext<
                ListPredictionApiKeyRegistrationsRequest,
                ListPredictionApiKeyRegistrationsResponse,
                PredictionApiKeyRegistration>
            context,
        ListPredictionApiKeyRegistrationsResponse response) {
      return new ListPredictionApiKeyRegistrationsPage(context, response);
    }

    @Override
    public ApiFuture<ListPredictionApiKeyRegistrationsPage> createPageAsync(
        PageContext<
                ListPredictionApiKeyRegistrationsRequest,
                ListPredictionApiKeyRegistrationsResponse,
                PredictionApiKeyRegistration>
            context,
        ApiFuture<ListPredictionApiKeyRegistrationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPredictionApiKeyRegistrationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPredictionApiKeyRegistrationsRequest,
          ListPredictionApiKeyRegistrationsResponse,
          PredictionApiKeyRegistration,
          ListPredictionApiKeyRegistrationsPage,
          ListPredictionApiKeyRegistrationsFixedSizeCollection> {

    private ListPredictionApiKeyRegistrationsFixedSizeCollection(
        List<ListPredictionApiKeyRegistrationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPredictionApiKeyRegistrationsFixedSizeCollection createEmptyCollection() {
      return new ListPredictionApiKeyRegistrationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPredictionApiKeyRegistrationsFixedSizeCollection createCollection(
        List<ListPredictionApiKeyRegistrationsPage> pages, int collectionSize) {
      return new ListPredictionApiKeyRegistrationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
