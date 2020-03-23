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
import com.google.cloud.recommendationengine.v1beta1.stub.PredictionServiceStub;
import com.google.cloud.recommendationengine.v1beta1.stub.PredictionServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Service for making recommendation prediction.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
 *   String formattedName = PredictionServiceClient.formatPlacementName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]", "[PLACEMENT]");
 *   UserEvent userEvent = UserEvent.newBuilder().build();
 *   PredictRequest request = PredictRequest.newBuilder()
 *     .setName(formattedName)
 *     .setUserEvent(userEvent)
 *     .build();
 *   ApiFuture&lt;PredictPagedResponse&gt; future = predictionServiceClient.predictPagedCallable().futureCall(request);
 *   // Do something
 *   for (PredictResponse.PredictionResult element : future.get().iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the predictionServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
 * <p>This class can be customized by passing in a custom instance of PredictionServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * PredictionServiceSettings predictionServiceSettings =
 *     PredictionServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PredictionServiceClient predictionServiceClient =
 *     PredictionServiceClient.create(predictionServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * PredictionServiceSettings predictionServiceSettings =
 *     PredictionServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PredictionServiceClient predictionServiceClient =
 *     PredictionServiceClient.create(predictionServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class PredictionServiceClient implements BackgroundResource {
  private final PredictionServiceSettings settings;
  private final PredictionServiceStub stub;

  private static final PathTemplate PLACEMENT_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/catalogs/{catalog}/eventStores/{event_store}/placements/{placement}");

  /**
   * Formats a string containing the fully-qualified path to represent a placement resource.
   *
   * @deprecated Use the {@link PlacementName} class instead.
   */
  @Deprecated
  public static final String formatPlacementName(
      String project, String location, String catalog, String eventStore, String placement) {
    return PLACEMENT_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location,
        "catalog", catalog,
        "event_store", eventStore,
        "placement", placement);
  }

  /**
   * Parses the project from the given fully-qualified path which represents a placement resource.
   *
   * @deprecated Use the {@link PlacementName} class instead.
   */
  @Deprecated
  public static final String parseProjectFromPlacementName(String placementName) {
    return PLACEMENT_PATH_TEMPLATE.parse(placementName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a placement resource.
   *
   * @deprecated Use the {@link PlacementName} class instead.
   */
  @Deprecated
  public static final String parseLocationFromPlacementName(String placementName) {
    return PLACEMENT_PATH_TEMPLATE.parse(placementName).get("location");
  }

  /**
   * Parses the catalog from the given fully-qualified path which represents a placement resource.
   *
   * @deprecated Use the {@link PlacementName} class instead.
   */
  @Deprecated
  public static final String parseCatalogFromPlacementName(String placementName) {
    return PLACEMENT_PATH_TEMPLATE.parse(placementName).get("catalog");
  }

  /**
   * Parses the event_store from the given fully-qualified path which represents a placement
   * resource.
   *
   * @deprecated Use the {@link PlacementName} class instead.
   */
  @Deprecated
  public static final String parseEventStoreFromPlacementName(String placementName) {
    return PLACEMENT_PATH_TEMPLATE.parse(placementName).get("event_store");
  }

  /**
   * Parses the placement from the given fully-qualified path which represents a placement resource.
   *
   * @deprecated Use the {@link PlacementName} class instead.
   */
  @Deprecated
  public static final String parsePlacementFromPlacementName(String placementName) {
    return PLACEMENT_PATH_TEMPLATE.parse(placementName).get("placement");
  }

  /** Constructs an instance of PredictionServiceClient with default settings. */
  public static final PredictionServiceClient create() throws IOException {
    return create(PredictionServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PredictionServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PredictionServiceClient create(PredictionServiceSettings settings)
      throws IOException {
    return new PredictionServiceClient(settings);
  }

  /**
   * Constructs an instance of PredictionServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer to use PredictionServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final PredictionServiceClient create(PredictionServiceStub stub) {
    return new PredictionServiceClient(stub);
  }

  /**
   * Constructs an instance of PredictionServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected PredictionServiceClient(PredictionServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PredictionServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected PredictionServiceClient(PredictionServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PredictionServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public PredictionServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Makes a recommendation prediction. If using API Key based authentication, the API Key must be
   * registered using the
   * [PredictionApiKeyRegistry][google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistry]
   * service. [Learn more](/recommendations-ai/docs/setting-up#register-key).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   String formattedName = PredictionServiceClient.formatPlacementName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]", "[PLACEMENT]");
   *   UserEvent userEvent = UserEvent.newBuilder().build();
   *   PredictRequest request = PredictRequest.newBuilder()
   *     .setName(formattedName)
   *     .setUserEvent(userEvent)
   *     .build();
   *   for (PredictResponse.PredictionResult element : predictionServiceClient.predict(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PredictPagedResponse predict(PredictRequest request) {
    return predictPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Makes a recommendation prediction. If using API Key based authentication, the API Key must be
   * registered using the
   * [PredictionApiKeyRegistry][google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistry]
   * service. [Learn more](/recommendations-ai/docs/setting-up#register-key).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   String formattedName = PredictionServiceClient.formatPlacementName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]", "[PLACEMENT]");
   *   UserEvent userEvent = UserEvent.newBuilder().build();
   *   PredictRequest request = PredictRequest.newBuilder()
   *     .setName(formattedName)
   *     .setUserEvent(userEvent)
   *     .build();
   *   ApiFuture&lt;PredictPagedResponse&gt; future = predictionServiceClient.predictPagedCallable().futureCall(request);
   *   // Do something
   *   for (PredictResponse.PredictionResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<PredictRequest, PredictPagedResponse> predictPagedCallable() {
    return stub.predictPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Makes a recommendation prediction. If using API Key based authentication, the API Key must be
   * registered using the
   * [PredictionApiKeyRegistry][google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistry]
   * service. [Learn more](/recommendations-ai/docs/setting-up#register-key).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   String formattedName = PredictionServiceClient.formatPlacementName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]", "[PLACEMENT]");
   *   UserEvent userEvent = UserEvent.newBuilder().build();
   *   PredictRequest request = PredictRequest.newBuilder()
   *     .setName(formattedName)
   *     .setUserEvent(userEvent)
   *     .build();
   *   while (true) {
   *     PredictResponse response = predictionServiceClient.predictCallable().call(request);
   *     for (PredictResponse.PredictionResult element : response.getResultsList()) {
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
  public final UnaryCallable<PredictRequest, PredictResponse> predictCallable() {
    return stub.predictCallable();
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

  public static class PredictPagedResponse
      extends AbstractPagedListResponse<
          PredictRequest,
          PredictResponse,
          PredictResponse.PredictionResult,
          PredictPage,
          PredictFixedSizeCollection> {

    public static ApiFuture<PredictPagedResponse> createAsync(
        PageContext<PredictRequest, PredictResponse, PredictResponse.PredictionResult> context,
        ApiFuture<PredictResponse> futureResponse) {
      ApiFuture<PredictPage> futurePage =
          PredictPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<PredictPage, PredictPagedResponse>() {
            @Override
            public PredictPagedResponse apply(PredictPage input) {
              return new PredictPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private PredictPagedResponse(PredictPage page) {
      super(page, PredictFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class PredictPage
      extends AbstractPage<
          PredictRequest, PredictResponse, PredictResponse.PredictionResult, PredictPage> {

    private PredictPage(
        PageContext<PredictRequest, PredictResponse, PredictResponse.PredictionResult> context,
        PredictResponse response) {
      super(context, response);
    }

    private static PredictPage createEmptyPage() {
      return new PredictPage(null, null);
    }

    @Override
    protected PredictPage createPage(
        PageContext<PredictRequest, PredictResponse, PredictResponse.PredictionResult> context,
        PredictResponse response) {
      return new PredictPage(context, response);
    }

    @Override
    public ApiFuture<PredictPage> createPageAsync(
        PageContext<PredictRequest, PredictResponse, PredictResponse.PredictionResult> context,
        ApiFuture<PredictResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class PredictFixedSizeCollection
      extends AbstractFixedSizeCollection<
          PredictRequest,
          PredictResponse,
          PredictResponse.PredictionResult,
          PredictPage,
          PredictFixedSizeCollection> {

    private PredictFixedSizeCollection(List<PredictPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static PredictFixedSizeCollection createEmptyCollection() {
      return new PredictFixedSizeCollection(null, 0);
    }

    @Override
    protected PredictFixedSizeCollection createCollection(
        List<PredictPage> pages, int collectionSize) {
      return new PredictFixedSizeCollection(pages, collectionSize);
    }
  }
}
