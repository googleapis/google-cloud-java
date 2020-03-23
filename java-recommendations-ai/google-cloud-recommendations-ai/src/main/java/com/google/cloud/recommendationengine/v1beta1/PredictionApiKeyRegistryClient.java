/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.recommendationengine.v1beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.recommendationengine.v1beta1.stub.PredictionApiKeyRegistryStub;
import com.google.cloud.recommendationengine.v1beta1.stub.PredictionApiKeyRegistryStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Service for registering API keys for use with the `predict` method. If you
 * use an API key to request predictions, you must first register the API key. Otherwise, your
 * prediction request is rejected. If you use OAuth to authenticate your `predict` method call, you
 * do not need to register an API key. You can register up to 20 API keys per project.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (PredictionApiKeyRegistryClient predictionApiKeyRegistryClient = PredictionApiKeyRegistryClient.create()) {
 *   String formattedParent = PredictionApiKeyRegistryClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
 *   PredictionApiKeyRegistration predictionApiKeyRegistration = PredictionApiKeyRegistration.newBuilder().build();
 *   PredictionApiKeyRegistration response = predictionApiKeyRegistryClient.createPredictionApiKeyRegistration(formattedParent, predictionApiKeyRegistration);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the predictionApiKeyRegistryClient object to clean up
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
 * <pre>
 * <code>
 * PredictionApiKeyRegistrySettings predictionApiKeyRegistrySettings =
 *     PredictionApiKeyRegistrySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PredictionApiKeyRegistryClient predictionApiKeyRegistryClient =
 *     PredictionApiKeyRegistryClient.create(predictionApiKeyRegistrySettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * PredictionApiKeyRegistrySettings predictionApiKeyRegistrySettings =
 *     PredictionApiKeyRegistrySettings.newBuilder().setEndpoint(myEndpoint).build();
 * PredictionApiKeyRegistryClient predictionApiKeyRegistryClient =
 *     PredictionApiKeyRegistryClient.create(predictionApiKeyRegistrySettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class PredictionApiKeyRegistryClient implements BackgroundResource {
  private final PredictionApiKeyRegistrySettings settings;
  private final PredictionApiKeyRegistryStub stub;

  private static final PathTemplate EVENT_STORE_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/catalogs/{catalog}/eventStores/{event_store}");

  private static final PathTemplate PREDICTION_API_KEY_REGISTRATION_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/catalogs/{catalog}/eventStores/{event_store}/predictionApiKeyRegistrations/{prediction_api_key_registration}");

  /**
   * Formats a string containing the fully-qualified path to represent a event_store resource.
   *
   * @deprecated Use the {@link EventStoreName} class instead.
   */
  @Deprecated
  public static final String formatEventStoreName(
      String project, String location, String catalog, String eventStore) {
    return EVENT_STORE_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location,
        "catalog", catalog,
        "event_store", eventStore);
  }

  /**
   * Formats a string containing the fully-qualified path to represent a
   * prediction_api_key_registration resource.
   *
   * @deprecated Use the {@link PredictionApiKeyRegistrationName} class instead.
   */
  @Deprecated
  public static final String formatPredictionApiKeyRegistrationName(
      String project,
      String location,
      String catalog,
      String eventStore,
      String predictionApiKeyRegistration) {
    return PREDICTION_API_KEY_REGISTRATION_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location,
        "catalog", catalog,
        "event_store", eventStore,
        "prediction_api_key_registration", predictionApiKeyRegistration);
  }

  /**
   * Parses the project from the given fully-qualified path which represents a event_store resource.
   *
   * @deprecated Use the {@link EventStoreName} class instead.
   */
  @Deprecated
  public static final String parseProjectFromEventStoreName(String eventStoreName) {
    return EVENT_STORE_PATH_TEMPLATE.parse(eventStoreName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a event_store
   * resource.
   *
   * @deprecated Use the {@link EventStoreName} class instead.
   */
  @Deprecated
  public static final String parseLocationFromEventStoreName(String eventStoreName) {
    return EVENT_STORE_PATH_TEMPLATE.parse(eventStoreName).get("location");
  }

  /**
   * Parses the catalog from the given fully-qualified path which represents a event_store resource.
   *
   * @deprecated Use the {@link EventStoreName} class instead.
   */
  @Deprecated
  public static final String parseCatalogFromEventStoreName(String eventStoreName) {
    return EVENT_STORE_PATH_TEMPLATE.parse(eventStoreName).get("catalog");
  }

  /**
   * Parses the event_store from the given fully-qualified path which represents a event_store
   * resource.
   *
   * @deprecated Use the {@link EventStoreName} class instead.
   */
  @Deprecated
  public static final String parseEventStoreFromEventStoreName(String eventStoreName) {
    return EVENT_STORE_PATH_TEMPLATE.parse(eventStoreName).get("event_store");
  }

  /**
   * Parses the project from the given fully-qualified path which represents a
   * prediction_api_key_registration resource.
   *
   * @deprecated Use the {@link PredictionApiKeyRegistrationName} class instead.
   */
  @Deprecated
  public static final String parseProjectFromPredictionApiKeyRegistrationName(
      String predictionApiKeyRegistrationName) {
    return PREDICTION_API_KEY_REGISTRATION_PATH_TEMPLATE
        .parse(predictionApiKeyRegistrationName)
        .get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a
   * prediction_api_key_registration resource.
   *
   * @deprecated Use the {@link PredictionApiKeyRegistrationName} class instead.
   */
  @Deprecated
  public static final String parseLocationFromPredictionApiKeyRegistrationName(
      String predictionApiKeyRegistrationName) {
    return PREDICTION_API_KEY_REGISTRATION_PATH_TEMPLATE
        .parse(predictionApiKeyRegistrationName)
        .get("location");
  }

  /**
   * Parses the catalog from the given fully-qualified path which represents a
   * prediction_api_key_registration resource.
   *
   * @deprecated Use the {@link PredictionApiKeyRegistrationName} class instead.
   */
  @Deprecated
  public static final String parseCatalogFromPredictionApiKeyRegistrationName(
      String predictionApiKeyRegistrationName) {
    return PREDICTION_API_KEY_REGISTRATION_PATH_TEMPLATE
        .parse(predictionApiKeyRegistrationName)
        .get("catalog");
  }

  /**
   * Parses the event_store from the given fully-qualified path which represents a
   * prediction_api_key_registration resource.
   *
   * @deprecated Use the {@link PredictionApiKeyRegistrationName} class instead.
   */
  @Deprecated
  public static final String parseEventStoreFromPredictionApiKeyRegistrationName(
      String predictionApiKeyRegistrationName) {
    return PREDICTION_API_KEY_REGISTRATION_PATH_TEMPLATE
        .parse(predictionApiKeyRegistrationName)
        .get("event_store");
  }

  /**
   * Parses the prediction_api_key_registration from the given fully-qualified path which represents
   * a prediction_api_key_registration resource.
   *
   * @deprecated Use the {@link PredictionApiKeyRegistrationName} class instead.
   */
  @Deprecated
  public static final String parsePredictionApiKeyRegistrationFromPredictionApiKeyRegistrationName(
      String predictionApiKeyRegistrationName) {
    return PREDICTION_API_KEY_REGISTRATION_PATH_TEMPLATE
        .parse(predictionApiKeyRegistrationName)
        .get("prediction_api_key_registration");
  }

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
   * calls. This is for advanced usage - prefer to use PredictionApiKeyRegistrySettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected PredictionApiKeyRegistryClient(PredictionApiKeyRegistryStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PredictionApiKeyRegistrySettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public PredictionApiKeyRegistryStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Register an API key for use with predict method.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PredictionApiKeyRegistryClient predictionApiKeyRegistryClient = PredictionApiKeyRegistryClient.create()) {
   *   String formattedParent = PredictionApiKeyRegistryClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   PredictionApiKeyRegistration predictionApiKeyRegistration = PredictionApiKeyRegistration.newBuilder().build();
   *   PredictionApiKeyRegistration response = predictionApiKeyRegistryClient.createPredictionApiKeyRegistration(formattedParent, predictionApiKeyRegistration);
   * }
   * </code></pre>
   *
   * @param parent Required. The parent resource path.
   *     "projects/&#42;/locations/global/catalogs/default_catalog/eventStores/default_event_store".
   * @param predictionApiKeyRegistration Required. The prediction API key registration.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PredictionApiKeyRegistration createPredictionApiKeyRegistration(
      String parent, PredictionApiKeyRegistration predictionApiKeyRegistration) {
    EVENT_STORE_PATH_TEMPLATE.validate(parent, "createPredictionApiKeyRegistration");
    CreatePredictionApiKeyRegistrationRequest request =
        CreatePredictionApiKeyRegistrationRequest.newBuilder()
            .setParent(parent)
            .setPredictionApiKeyRegistration(predictionApiKeyRegistration)
            .build();
    return createPredictionApiKeyRegistration(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Register an API key for use with predict method.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PredictionApiKeyRegistryClient predictionApiKeyRegistryClient = PredictionApiKeyRegistryClient.create()) {
   *   String formattedParent = PredictionApiKeyRegistryClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   PredictionApiKeyRegistration predictionApiKeyRegistration = PredictionApiKeyRegistration.newBuilder().build();
   *   CreatePredictionApiKeyRegistrationRequest request = CreatePredictionApiKeyRegistrationRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setPredictionApiKeyRegistration(predictionApiKeyRegistration)
   *     .build();
   *   PredictionApiKeyRegistration response = predictionApiKeyRegistryClient.createPredictionApiKeyRegistration(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PredictionApiKeyRegistration createPredictionApiKeyRegistration(
      CreatePredictionApiKeyRegistrationRequest request) {
    return createPredictionApiKeyRegistrationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Register an API key for use with predict method.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PredictionApiKeyRegistryClient predictionApiKeyRegistryClient = PredictionApiKeyRegistryClient.create()) {
   *   String formattedParent = PredictionApiKeyRegistryClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   PredictionApiKeyRegistration predictionApiKeyRegistration = PredictionApiKeyRegistration.newBuilder().build();
   *   CreatePredictionApiKeyRegistrationRequest request = CreatePredictionApiKeyRegistrationRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setPredictionApiKeyRegistration(predictionApiKeyRegistration)
   *     .build();
   *   ApiFuture&lt;PredictionApiKeyRegistration&gt; future = predictionApiKeyRegistryClient.createPredictionApiKeyRegistrationCallable().futureCall(request);
   *   // Do something
   *   PredictionApiKeyRegistration response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<
          CreatePredictionApiKeyRegistrationRequest, PredictionApiKeyRegistration>
      createPredictionApiKeyRegistrationCallable() {
    return stub.createPredictionApiKeyRegistrationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * List the registered apiKeys for use with predict method.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PredictionApiKeyRegistryClient predictionApiKeyRegistryClient = PredictionApiKeyRegistryClient.create()) {
   *   String formattedParent = PredictionApiKeyRegistryClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   for (PredictionApiKeyRegistration element : predictionApiKeyRegistryClient.listPredictionApiKeyRegistrations(formattedParent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The parent placement resource name such as
   *     "projects/1234/locations/global/catalogs/default_catalog/eventStores/default_event_store"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPredictionApiKeyRegistrationsPagedResponse listPredictionApiKeyRegistrations(
      String parent) {
    EVENT_STORE_PATH_TEMPLATE.validate(parent, "listPredictionApiKeyRegistrations");
    ListPredictionApiKeyRegistrationsRequest request =
        ListPredictionApiKeyRegistrationsRequest.newBuilder().setParent(parent).build();
    return listPredictionApiKeyRegistrations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * List the registered apiKeys for use with predict method.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PredictionApiKeyRegistryClient predictionApiKeyRegistryClient = PredictionApiKeyRegistryClient.create()) {
   *   String formattedParent = PredictionApiKeyRegistryClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   ListPredictionApiKeyRegistrationsRequest request = ListPredictionApiKeyRegistrationsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   for (PredictionApiKeyRegistration element : predictionApiKeyRegistryClient.listPredictionApiKeyRegistrations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPredictionApiKeyRegistrationsPagedResponse listPredictionApiKeyRegistrations(
      ListPredictionApiKeyRegistrationsRequest request) {
    return listPredictionApiKeyRegistrationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * List the registered apiKeys for use with predict method.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PredictionApiKeyRegistryClient predictionApiKeyRegistryClient = PredictionApiKeyRegistryClient.create()) {
   *   String formattedParent = PredictionApiKeyRegistryClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   ListPredictionApiKeyRegistrationsRequest request = ListPredictionApiKeyRegistrationsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ApiFuture&lt;ListPredictionApiKeyRegistrationsPagedResponse&gt; future = predictionApiKeyRegistryClient.listPredictionApiKeyRegistrationsPagedCallable().futureCall(request);
   *   // Do something
   *   for (PredictionApiKeyRegistration element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<
          ListPredictionApiKeyRegistrationsRequest, ListPredictionApiKeyRegistrationsPagedResponse>
      listPredictionApiKeyRegistrationsPagedCallable() {
    return stub.listPredictionApiKeyRegistrationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * List the registered apiKeys for use with predict method.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PredictionApiKeyRegistryClient predictionApiKeyRegistryClient = PredictionApiKeyRegistryClient.create()) {
   *   String formattedParent = PredictionApiKeyRegistryClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   ListPredictionApiKeyRegistrationsRequest request = ListPredictionApiKeyRegistrationsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   while (true) {
   *     ListPredictionApiKeyRegistrationsResponse response = predictionApiKeyRegistryClient.listPredictionApiKeyRegistrationsCallable().call(request);
   *     for (PredictionApiKeyRegistration element : response.getPredictionApiKeyRegistrationsList()) {
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
  public final UnaryCallable<
          ListPredictionApiKeyRegistrationsRequest, ListPredictionApiKeyRegistrationsResponse>
      listPredictionApiKeyRegistrationsCallable() {
    return stub.listPredictionApiKeyRegistrationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Unregister an apiKey from using for predict method.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PredictionApiKeyRegistryClient predictionApiKeyRegistryClient = PredictionApiKeyRegistryClient.create()) {
   *   String formattedName = PredictionApiKeyRegistryClient.formatPredictionApiKeyRegistrationName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]", "[PREDICTION_API_KEY_REGISTRATION]");
   *   predictionApiKeyRegistryClient.deletePredictionApiKeyRegistration(formattedName);
   * }
   * </code></pre>
   *
   * @param name Required. The API key to unregister including full resource path.
   *     "projects/&#42;/locations/global/catalogs/default_catalog/eventStores/default_event_store/predictionApiKeyRegistrations/&lt;YOUR_API_KEY&gt;"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePredictionApiKeyRegistration(String name) {
    PREDICTION_API_KEY_REGISTRATION_PATH_TEMPLATE.validate(
        name, "deletePredictionApiKeyRegistration");
    DeletePredictionApiKeyRegistrationRequest request =
        DeletePredictionApiKeyRegistrationRequest.newBuilder().setName(name).build();
    deletePredictionApiKeyRegistration(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Unregister an apiKey from using for predict method.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PredictionApiKeyRegistryClient predictionApiKeyRegistryClient = PredictionApiKeyRegistryClient.create()) {
   *   String formattedName = PredictionApiKeyRegistryClient.formatPredictionApiKeyRegistrationName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]", "[PREDICTION_API_KEY_REGISTRATION]");
   *   DeletePredictionApiKeyRegistrationRequest request = DeletePredictionApiKeyRegistrationRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   predictionApiKeyRegistryClient.deletePredictionApiKeyRegistration(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePredictionApiKeyRegistration(
      DeletePredictionApiKeyRegistrationRequest request) {
    deletePredictionApiKeyRegistrationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Unregister an apiKey from using for predict method.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PredictionApiKeyRegistryClient predictionApiKeyRegistryClient = PredictionApiKeyRegistryClient.create()) {
   *   String formattedName = PredictionApiKeyRegistryClient.formatPredictionApiKeyRegistrationName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]", "[PREDICTION_API_KEY_REGISTRATION]");
   *   DeletePredictionApiKeyRegistrationRequest request = DeletePredictionApiKeyRegistrationRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = predictionApiKeyRegistryClient.deletePredictionApiKeyRegistrationCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
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
          new ApiFunction<
              ListPredictionApiKeyRegistrationsPage,
              ListPredictionApiKeyRegistrationsPagedResponse>() {
            @Override
            public ListPredictionApiKeyRegistrationsPagedResponse apply(
                ListPredictionApiKeyRegistrationsPage input) {
              return new ListPredictionApiKeyRegistrationsPagedResponse(input);
            }
          },
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
