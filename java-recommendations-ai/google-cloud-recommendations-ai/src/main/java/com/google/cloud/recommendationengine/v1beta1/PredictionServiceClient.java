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
import com.google.cloud.recommendationengine.v1beta1.stub.PredictionServiceStub;
import com.google.cloud.recommendationengine.v1beta1.stub.PredictionServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for making recommendation prediction.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the PredictionServiceClient object to clean up resources
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
 * <pre>{@code
 * PredictionServiceSettings predictionServiceSettings =
 *     PredictionServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PredictionServiceClient predictionServiceClient =
 *     PredictionServiceClient.create(predictionServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * PredictionServiceSettings predictionServiceSettings =
 *     PredictionServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PredictionServiceClient predictionServiceClient =
 *     PredictionServiceClient.create(predictionServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
public class PredictionServiceClient implements BackgroundResource {
  private final PredictionServiceSettings settings;
  private final PredictionServiceStub stub;

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
   * is for advanced usage - prefer using create(PredictionServiceSettings).
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Makes a recommendation prediction. If using API Key based authentication, the API Key must be
   * registered using the
   * [PredictionApiKeyRegistry][google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistry]
   * service. [Learn more](/recommendations-ai/docs/setting-up#register-key).
   *
   * @param name Required. Full resource name of the format:
   *     {name=projects/&#42;/locations/global/catalogs/default_catalog/eventStores/default_event_store/placements/&#42;}
   *     The id of the recommendation engine placement. This id is used to identify the set of
   *     models that will be used to make the prediction.
   *     <p>We currently support three placements with the following IDs by default:
   *     <ul>
   *       <li>`shopping_cart`: Predicts items frequently bought together with one or more catalog
   *           items in the same shopping session. Commonly displayed after `add-to-cart` events, on
   *           product detail pages, or on the shopping cart page.
   *     </ul>
   *     <ul>
   *       <li>`home_page`: Predicts the next product that a user will most likely engage with or
   *           purchase based on the shopping or viewing history of the specified `userId` or
   *           `visitorId`. For example - Recommendations for you.
   *     </ul>
   *     <ul>
   *       <li>`product_detail`: Predicts the next product that a user will most likely engage with
   *           or purchase. The prediction is based on the shopping or viewing history of the
   *           specified `userId` or `visitorId` and its relevance to a specified `CatalogItem`.
   *           Typically used on product detail pages. For example - More items like this.
   *     </ul>
   *     <ul>
   *       <li>`recently_viewed_default`: Returns up to 75 items recently viewed by the specified
   *           `userId` or `visitorId`, most recent ones first. Returns nothing if neither of them
   *           has viewed any items yet. For example - Recently viewed.
   *     </ul>
   *     <p>The full list of available placements can be seen at
   *     https://console.cloud.google.com/recommendation/datafeeds/default_catalog/dashboard
   * @param userEvent Required. Context about the user, what they are looking at and what action
   *     they took to trigger the predict request. Note that this user event detail won't be
   *     ingested to userEvent logs. Thus, a separate userEvent write request is required for event
   *     logging.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PredictPagedResponse predict(PlacementName name, UserEvent userEvent) {
    PredictRequest request =
        PredictRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setUserEvent(userEvent)
            .build();
    return predict(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Makes a recommendation prediction. If using API Key based authentication, the API Key must be
   * registered using the
   * [PredictionApiKeyRegistry][google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistry]
   * service. [Learn more](/recommendations-ai/docs/setting-up#register-key).
   *
   * @param name Required. Full resource name of the format:
   *     {name=projects/&#42;/locations/global/catalogs/default_catalog/eventStores/default_event_store/placements/&#42;}
   *     The id of the recommendation engine placement. This id is used to identify the set of
   *     models that will be used to make the prediction.
   *     <p>We currently support three placements with the following IDs by default:
   *     <ul>
   *       <li>`shopping_cart`: Predicts items frequently bought together with one or more catalog
   *           items in the same shopping session. Commonly displayed after `add-to-cart` events, on
   *           product detail pages, or on the shopping cart page.
   *     </ul>
   *     <ul>
   *       <li>`home_page`: Predicts the next product that a user will most likely engage with or
   *           purchase based on the shopping or viewing history of the specified `userId` or
   *           `visitorId`. For example - Recommendations for you.
   *     </ul>
   *     <ul>
   *       <li>`product_detail`: Predicts the next product that a user will most likely engage with
   *           or purchase. The prediction is based on the shopping or viewing history of the
   *           specified `userId` or `visitorId` and its relevance to a specified `CatalogItem`.
   *           Typically used on product detail pages. For example - More items like this.
   *     </ul>
   *     <ul>
   *       <li>`recently_viewed_default`: Returns up to 75 items recently viewed by the specified
   *           `userId` or `visitorId`, most recent ones first. Returns nothing if neither of them
   *           has viewed any items yet. For example - Recently viewed.
   *     </ul>
   *     <p>The full list of available placements can be seen at
   *     https://console.cloud.google.com/recommendation/datafeeds/default_catalog/dashboard
   * @param userEvent Required. Context about the user, what they are looking at and what action
   *     they took to trigger the predict request. Note that this user event detail won't be
   *     ingested to userEvent logs. Thus, a separate userEvent write request is required for event
   *     logging.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PredictPagedResponse predict(String name, UserEvent userEvent) {
    PredictRequest request =
        PredictRequest.newBuilder().setName(name).setUserEvent(userEvent).build();
    return predict(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Makes a recommendation prediction. If using API Key based authentication, the API Key must be
   * registered using the
   * [PredictionApiKeyRegistry][google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistry]
   * service. [Learn more](/recommendations-ai/docs/setting-up#register-key).
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PredictPagedResponse predict(PredictRequest request) {
    return predictPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Makes a recommendation prediction. If using API Key based authentication, the API Key must be
   * registered using the
   * [PredictionApiKeyRegistry][google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistry]
   * service. [Learn more](/recommendations-ai/docs/setting-up#register-key).
   *
   * <p>Sample code:
   */
  public final UnaryCallable<PredictRequest, PredictPagedResponse> predictPagedCallable() {
    return stub.predictPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Makes a recommendation prediction. If using API Key based authentication, the API Key must be
   * registered using the
   * [PredictionApiKeyRegistry][google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistry]
   * service. [Learn more](/recommendations-ai/docs/setting-up#register-key).
   *
   * <p>Sample code:
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
