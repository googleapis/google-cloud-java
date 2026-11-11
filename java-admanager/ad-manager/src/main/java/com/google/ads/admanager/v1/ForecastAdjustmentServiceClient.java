/*
 * Copyright 2026 Google LLC
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

package com.google.ads.admanager.v1;

import com.google.ads.admanager.v1.stub.ForecastAdjustmentServiceStub;
import com.google.ads.admanager.v1.stub.ForecastAdjustmentServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling `ForecastAdjustment` objects.
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
 * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
 *     ForecastAdjustmentServiceClient.create()) {
 *   ForecastAdjustmentName name =
 *       ForecastAdjustmentName.of("[NETWORK_CODE]", "[FORECAST_ADJUSTMENT]");
 *   ForecastAdjustment response = forecastAdjustmentServiceClient.getForecastAdjustment(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ForecastAdjustmentServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetForecastAdjustment</td>
 *      <td><p> Retrieves a `ForecastAdjustment` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getForecastAdjustment(GetForecastAdjustmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getForecastAdjustment(ForecastAdjustmentName name)
 *           <li><p> getForecastAdjustment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getForecastAdjustmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListForecastAdjustments</td>
 *      <td><p> Lists `ForecastAdjustment` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listForecastAdjustments(ListForecastAdjustmentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listForecastAdjustments(NetworkName parent)
 *           <li><p> listForecastAdjustments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listForecastAdjustmentsPagedCallable()
 *           <li><p> listForecastAdjustmentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateForecastAdjustment</td>
 *      <td><p> Creates a `ForecastAdjustment` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createForecastAdjustment(CreateForecastAdjustmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createForecastAdjustment(NetworkName parent, ForecastAdjustment forecastAdjustment)
 *           <li><p> createForecastAdjustment(String parent, ForecastAdjustment forecastAdjustment)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createForecastAdjustmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateForecastAdjustments</td>
 *      <td><p> Creates `ForecastAdjustment` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateForecastAdjustments(NetworkName parent, List&lt;CreateForecastAdjustmentRequest&gt; requests)
 *           <li><p> batchCreateForecastAdjustments(String parent, List&lt;CreateForecastAdjustmentRequest&gt; requests)
 *           <li><p> batchCreateForecastAdjustments(BatchCreateForecastAdjustmentsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateForecastAdjustmentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchActivateForecastAdjustments</td>
 *      <td><p> Activates a list of `ForecastAdjustment` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchActivateForecastAdjustments(BatchActivateForecastAdjustmentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchActivateForecastAdjustments(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchActivateForecastAdjustments(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchActivateForecastAdjustmentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeactivateForecastAdjustments</td>
 *      <td><p> Deactivates a list of `ForecastAdjustment` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeactivateForecastAdjustments(BatchDeactivateForecastAdjustmentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchDeactivateForecastAdjustments(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchDeactivateForecastAdjustments(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeactivateForecastAdjustmentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateForecastAdjustment</td>
 *      <td><p> Updates a `ForecastAdjustment` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateForecastAdjustment(UpdateForecastAdjustmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateForecastAdjustment(ForecastAdjustment forecastAdjustment, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateForecastAdjustmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateForecastAdjustments</td>
 *      <td><p> Batch updates `ForecastAdjustment` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateForecastAdjustments(NetworkName parent, List&lt;UpdateForecastAdjustmentRequest&gt; requests)
 *           <li><p> batchUpdateForecastAdjustments(String parent, List&lt;UpdateForecastAdjustmentRequest&gt; requests)
 *           <li><p> batchUpdateForecastAdjustments(BatchUpdateForecastAdjustmentsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateForecastAdjustmentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CalculateDailyAdOpportunityCounts</td>
 *      <td><p> Calculates daily ad opportunity counts for a prospective `ForecastAdjustment` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> calculateDailyAdOpportunityCounts(CalculateDailyAdOpportunityCountsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> calculateDailyAdOpportunityCounts(NetworkName parent, ForecastAdjustment forecastAdjustment)
 *           <li><p> calculateDailyAdOpportunityCounts(String parent, ForecastAdjustment forecastAdjustment)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> calculateDailyAdOpportunityCountsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of
 * ForecastAdjustmentServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ForecastAdjustmentServiceSettings forecastAdjustmentServiceSettings =
 *     ForecastAdjustmentServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
 *     ForecastAdjustmentServiceClient.create(forecastAdjustmentServiceSettings);
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
 * ForecastAdjustmentServiceSettings forecastAdjustmentServiceSettings =
 *     ForecastAdjustmentServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
 *     ForecastAdjustmentServiceClient.create(forecastAdjustmentServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class ForecastAdjustmentServiceClient implements BackgroundResource {
  private final @Nullable ForecastAdjustmentServiceSettings settings;
  private final ForecastAdjustmentServiceStub stub;

  /** Constructs an instance of ForecastAdjustmentServiceClient with default settings. */
  public static final ForecastAdjustmentServiceClient create() throws IOException {
    return create(ForecastAdjustmentServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ForecastAdjustmentServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final ForecastAdjustmentServiceClient create(
      ForecastAdjustmentServiceSettings settings) throws IOException {
    return new ForecastAdjustmentServiceClient(settings);
  }

  /**
   * Constructs an instance of ForecastAdjustmentServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(ForecastAdjustmentServiceSettings).
   */
  public static final ForecastAdjustmentServiceClient create(ForecastAdjustmentServiceStub stub) {
    return new ForecastAdjustmentServiceClient(stub);
  }

  /**
   * Constructs an instance of ForecastAdjustmentServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ForecastAdjustmentServiceClient(ForecastAdjustmentServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((ForecastAdjustmentServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ForecastAdjustmentServiceClient(ForecastAdjustmentServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable ForecastAdjustmentServiceSettings getSettings() {
    return settings;
  }

  public ForecastAdjustmentServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `ForecastAdjustment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   ForecastAdjustmentName name =
   *       ForecastAdjustmentName.of("[NETWORK_CODE]", "[FORECAST_ADJUSTMENT]");
   *   ForecastAdjustment response = forecastAdjustmentServiceClient.getForecastAdjustment(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ForecastAdjustment. Format:
   *     `networks/{network_code}/forecastAdjustments/{forecastAdjustmentId}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ForecastAdjustment getForecastAdjustment(@Nullable ForecastAdjustmentName name) {
    GetForecastAdjustmentRequest request =
        GetForecastAdjustmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getForecastAdjustment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `ForecastAdjustment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   String name = ForecastAdjustmentName.of("[NETWORK_CODE]", "[FORECAST_ADJUSTMENT]").toString();
   *   ForecastAdjustment response = forecastAdjustmentServiceClient.getForecastAdjustment(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ForecastAdjustment. Format:
   *     `networks/{network_code}/forecastAdjustments/{forecastAdjustmentId}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ForecastAdjustment getForecastAdjustment(String name) {
    GetForecastAdjustmentRequest request =
        GetForecastAdjustmentRequest.newBuilder().setName(name).build();
    return getForecastAdjustment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `ForecastAdjustment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   GetForecastAdjustmentRequest request =
   *       GetForecastAdjustmentRequest.newBuilder()
   *           .setName(
   *               ForecastAdjustmentName.of("[NETWORK_CODE]", "[FORECAST_ADJUSTMENT]").toString())
   *           .build();
   *   ForecastAdjustment response = forecastAdjustmentServiceClient.getForecastAdjustment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ForecastAdjustment getForecastAdjustment(GetForecastAdjustmentRequest request) {
    return getForecastAdjustmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `ForecastAdjustment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   GetForecastAdjustmentRequest request =
   *       GetForecastAdjustmentRequest.newBuilder()
   *           .setName(
   *               ForecastAdjustmentName.of("[NETWORK_CODE]", "[FORECAST_ADJUSTMENT]").toString())
   *           .build();
   *   ApiFuture<ForecastAdjustment> future =
   *       forecastAdjustmentServiceClient.getForecastAdjustmentCallable().futureCall(request);
   *   // Do something.
   *   ForecastAdjustment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetForecastAdjustmentRequest, ForecastAdjustment>
      getForecastAdjustmentCallable() {
    return stub.getForecastAdjustmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `ForecastAdjustment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (ForecastAdjustment element :
   *       forecastAdjustmentServiceClient.listForecastAdjustments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of ForecastAdjustments. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListForecastAdjustmentsPagedResponse listForecastAdjustments(
      @Nullable NetworkName parent) {
    ListForecastAdjustmentsRequest request =
        ListForecastAdjustmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listForecastAdjustments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `ForecastAdjustment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (ForecastAdjustment element :
   *       forecastAdjustmentServiceClient.listForecastAdjustments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of ForecastAdjustments. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListForecastAdjustmentsPagedResponse listForecastAdjustments(String parent) {
    ListForecastAdjustmentsRequest request =
        ListForecastAdjustmentsRequest.newBuilder().setParent(parent).build();
    return listForecastAdjustments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `ForecastAdjustment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   ListForecastAdjustmentsRequest request =
   *       ListForecastAdjustmentsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (ForecastAdjustment element :
   *       forecastAdjustmentServiceClient.listForecastAdjustments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListForecastAdjustmentsPagedResponse listForecastAdjustments(
      ListForecastAdjustmentsRequest request) {
    return listForecastAdjustmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `ForecastAdjustment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   ListForecastAdjustmentsRequest request =
   *       ListForecastAdjustmentsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<ForecastAdjustment> future =
   *       forecastAdjustmentServiceClient
   *           .listForecastAdjustmentsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (ForecastAdjustment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListForecastAdjustmentsRequest, ListForecastAdjustmentsPagedResponse>
      listForecastAdjustmentsPagedCallable() {
    return stub.listForecastAdjustmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `ForecastAdjustment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   ListForecastAdjustmentsRequest request =
   *       ListForecastAdjustmentsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListForecastAdjustmentsResponse response =
   *         forecastAdjustmentServiceClient.listForecastAdjustmentsCallable().call(request);
   *     for (ForecastAdjustment element : response.getForecastAdjustmentsList()) {
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
  public final UnaryCallable<ListForecastAdjustmentsRequest, ListForecastAdjustmentsResponse>
      listForecastAdjustmentsCallable() {
    return stub.listForecastAdjustmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `ForecastAdjustment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   ForecastAdjustment forecastAdjustment = ForecastAdjustment.newBuilder().build();
   *   ForecastAdjustment response =
   *       forecastAdjustmentServiceClient.createForecastAdjustment(parent, forecastAdjustment);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `ForecastAdjustment` will be created.
   *     Format: `networks/{network_code}`
   * @param forecastAdjustment Required. The `ForecastAdjustment` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ForecastAdjustment createForecastAdjustment(
      @Nullable NetworkName parent, ForecastAdjustment forecastAdjustment) {
    CreateForecastAdjustmentRequest request =
        CreateForecastAdjustmentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setForecastAdjustment(forecastAdjustment)
            .build();
    return createForecastAdjustment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `ForecastAdjustment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   ForecastAdjustment forecastAdjustment = ForecastAdjustment.newBuilder().build();
   *   ForecastAdjustment response =
   *       forecastAdjustmentServiceClient.createForecastAdjustment(parent, forecastAdjustment);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `ForecastAdjustment` will be created.
   *     Format: `networks/{network_code}`
   * @param forecastAdjustment Required. The `ForecastAdjustment` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ForecastAdjustment createForecastAdjustment(
      String parent, ForecastAdjustment forecastAdjustment) {
    CreateForecastAdjustmentRequest request =
        CreateForecastAdjustmentRequest.newBuilder()
            .setParent(parent)
            .setForecastAdjustment(forecastAdjustment)
            .build();
    return createForecastAdjustment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `ForecastAdjustment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   CreateForecastAdjustmentRequest request =
   *       CreateForecastAdjustmentRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setForecastAdjustment(ForecastAdjustment.newBuilder().build())
   *           .build();
   *   ForecastAdjustment response =
   *       forecastAdjustmentServiceClient.createForecastAdjustment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ForecastAdjustment createForecastAdjustment(
      CreateForecastAdjustmentRequest request) {
    return createForecastAdjustmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `ForecastAdjustment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   CreateForecastAdjustmentRequest request =
   *       CreateForecastAdjustmentRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setForecastAdjustment(ForecastAdjustment.newBuilder().build())
   *           .build();
   *   ApiFuture<ForecastAdjustment> future =
   *       forecastAdjustmentServiceClient.createForecastAdjustmentCallable().futureCall(request);
   *   // Do something.
   *   ForecastAdjustment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateForecastAdjustmentRequest, ForecastAdjustment>
      createForecastAdjustmentCallable() {
    return stub.createForecastAdjustmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `ForecastAdjustment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreateForecastAdjustmentRequest> requests = new ArrayList<>();
   *   BatchCreateForecastAdjustmentsResponse response =
   *       forecastAdjustmentServiceClient.batchCreateForecastAdjustments(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `ForecastAdjustments` will be created.
   *     Format: `networks/{network_code}` The parent field in the CreateForecastAdjustmentRequest
   *     must match this field.
   * @param requests Required. The `ForecastAdjustment` objects to create. A maximum of 100 objects
   *     can be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateForecastAdjustmentsResponse batchCreateForecastAdjustments(
      @Nullable NetworkName parent, List<CreateForecastAdjustmentRequest> requests) {
    BatchCreateForecastAdjustmentsRequest request =
        BatchCreateForecastAdjustmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateForecastAdjustments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `ForecastAdjustment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreateForecastAdjustmentRequest> requests = new ArrayList<>();
   *   BatchCreateForecastAdjustmentsResponse response =
   *       forecastAdjustmentServiceClient.batchCreateForecastAdjustments(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `ForecastAdjustments` will be created.
   *     Format: `networks/{network_code}` The parent field in the CreateForecastAdjustmentRequest
   *     must match this field.
   * @param requests Required. The `ForecastAdjustment` objects to create. A maximum of 100 objects
   *     can be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateForecastAdjustmentsResponse batchCreateForecastAdjustments(
      String parent, List<CreateForecastAdjustmentRequest> requests) {
    BatchCreateForecastAdjustmentsRequest request =
        BatchCreateForecastAdjustmentsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchCreateForecastAdjustments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `ForecastAdjustment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   BatchCreateForecastAdjustmentsRequest request =
   *       BatchCreateForecastAdjustmentsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateForecastAdjustmentRequest>())
   *           .build();
   *   BatchCreateForecastAdjustmentsResponse response =
   *       forecastAdjustmentServiceClient.batchCreateForecastAdjustments(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateForecastAdjustmentsResponse batchCreateForecastAdjustments(
      BatchCreateForecastAdjustmentsRequest request) {
    return batchCreateForecastAdjustmentsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `ForecastAdjustment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   BatchCreateForecastAdjustmentsRequest request =
   *       BatchCreateForecastAdjustmentsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateForecastAdjustmentRequest>())
   *           .build();
   *   ApiFuture<BatchCreateForecastAdjustmentsResponse> future =
   *       forecastAdjustmentServiceClient
   *           .batchCreateForecastAdjustmentsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchCreateForecastAdjustmentsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchCreateForecastAdjustmentsRequest, BatchCreateForecastAdjustmentsResponse>
      batchCreateForecastAdjustmentsCallable() {
    return stub.batchCreateForecastAdjustmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a list of `ForecastAdjustment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchActivateForecastAdjustmentsResponse response =
   *       forecastAdjustmentServiceClient.batchActivateForecastAdjustments(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `ForecastAdjustment` objects to activate.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateForecastAdjustmentsResponse batchActivateForecastAdjustments(
      @Nullable NetworkName parent, List<String> names) {
    BatchActivateForecastAdjustmentsRequest request =
        BatchActivateForecastAdjustmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchActivateForecastAdjustments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a list of `ForecastAdjustment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchActivateForecastAdjustmentsResponse response =
   *       forecastAdjustmentServiceClient.batchActivateForecastAdjustments(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `ForecastAdjustment` objects to activate.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateForecastAdjustmentsResponse batchActivateForecastAdjustments(
      String parent, List<String> names) {
    BatchActivateForecastAdjustmentsRequest request =
        BatchActivateForecastAdjustmentsRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchActivateForecastAdjustments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a list of `ForecastAdjustment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   BatchActivateForecastAdjustmentsRequest request =
   *       BatchActivateForecastAdjustmentsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchActivateForecastAdjustmentsResponse response =
   *       forecastAdjustmentServiceClient.batchActivateForecastAdjustments(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateForecastAdjustmentsResponse batchActivateForecastAdjustments(
      BatchActivateForecastAdjustmentsRequest request) {
    return batchActivateForecastAdjustmentsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a list of `ForecastAdjustment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   BatchActivateForecastAdjustmentsRequest request =
   *       BatchActivateForecastAdjustmentsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchActivateForecastAdjustmentsResponse> future =
   *       forecastAdjustmentServiceClient
   *           .batchActivateForecastAdjustmentsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchActivateForecastAdjustmentsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchActivateForecastAdjustmentsRequest, BatchActivateForecastAdjustmentsResponse>
      batchActivateForecastAdjustmentsCallable() {
    return stub.batchActivateForecastAdjustmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `ForecastAdjustment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchDeactivateForecastAdjustmentsResponse response =
   *       forecastAdjustmentServiceClient.batchDeactivateForecastAdjustments(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `ForecastAdjustment` objects to deactivate.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateForecastAdjustmentsResponse batchDeactivateForecastAdjustments(
      @Nullable NetworkName parent, List<String> names) {
    BatchDeactivateForecastAdjustmentsRequest request =
        BatchDeactivateForecastAdjustmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchDeactivateForecastAdjustments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `ForecastAdjustment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchDeactivateForecastAdjustmentsResponse response =
   *       forecastAdjustmentServiceClient.batchDeactivateForecastAdjustments(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `ForecastAdjustment` objects to deactivate.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateForecastAdjustmentsResponse batchDeactivateForecastAdjustments(
      String parent, List<String> names) {
    BatchDeactivateForecastAdjustmentsRequest request =
        BatchDeactivateForecastAdjustmentsRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchDeactivateForecastAdjustments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `ForecastAdjustment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   BatchDeactivateForecastAdjustmentsRequest request =
   *       BatchDeactivateForecastAdjustmentsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchDeactivateForecastAdjustmentsResponse response =
   *       forecastAdjustmentServiceClient.batchDeactivateForecastAdjustments(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateForecastAdjustmentsResponse batchDeactivateForecastAdjustments(
      BatchDeactivateForecastAdjustmentsRequest request) {
    return batchDeactivateForecastAdjustmentsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `ForecastAdjustment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   BatchDeactivateForecastAdjustmentsRequest request =
   *       BatchDeactivateForecastAdjustmentsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchDeactivateForecastAdjustmentsResponse> future =
   *       forecastAdjustmentServiceClient
   *           .batchDeactivateForecastAdjustmentsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchDeactivateForecastAdjustmentsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchDeactivateForecastAdjustmentsRequest, BatchDeactivateForecastAdjustmentsResponse>
      batchDeactivateForecastAdjustmentsCallable() {
    return stub.batchDeactivateForecastAdjustmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `ForecastAdjustment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   ForecastAdjustment forecastAdjustment = ForecastAdjustment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ForecastAdjustment response =
   *       forecastAdjustmentServiceClient.updateForecastAdjustment(forecastAdjustment, updateMask);
   * }
   * }</pre>
   *
   * @param forecastAdjustment Required. The `ForecastAdjustment` to update.
   *     <p>The `ForecastAdjustment`'s `name` is used to identify the `ForecastAdjustment` to
   *     update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ForecastAdjustment updateForecastAdjustment(
      ForecastAdjustment forecastAdjustment, FieldMask updateMask) {
    UpdateForecastAdjustmentRequest request =
        UpdateForecastAdjustmentRequest.newBuilder()
            .setForecastAdjustment(forecastAdjustment)
            .setUpdateMask(updateMask)
            .build();
    return updateForecastAdjustment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `ForecastAdjustment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   UpdateForecastAdjustmentRequest request =
   *       UpdateForecastAdjustmentRequest.newBuilder()
   *           .setForecastAdjustment(ForecastAdjustment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ForecastAdjustment response =
   *       forecastAdjustmentServiceClient.updateForecastAdjustment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ForecastAdjustment updateForecastAdjustment(
      UpdateForecastAdjustmentRequest request) {
    return updateForecastAdjustmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `ForecastAdjustment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   UpdateForecastAdjustmentRequest request =
   *       UpdateForecastAdjustmentRequest.newBuilder()
   *           .setForecastAdjustment(ForecastAdjustment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ForecastAdjustment> future =
   *       forecastAdjustmentServiceClient.updateForecastAdjustmentCallable().futureCall(request);
   *   // Do something.
   *   ForecastAdjustment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateForecastAdjustmentRequest, ForecastAdjustment>
      updateForecastAdjustmentCallable() {
    return stub.updateForecastAdjustmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `ForecastAdjustment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdateForecastAdjustmentRequest> requests = new ArrayList<>();
   *   BatchUpdateForecastAdjustmentsResponse response =
   *       forecastAdjustmentServiceClient.batchUpdateForecastAdjustments(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `ForecastAdjustments` will be updated.
   *     Format: `networks/{network_code}` The parent field in the UpdateForecastAdjustmentRequest
   *     must match this field.
   * @param requests Required. The `ForecastAdjustment` objects to update. A maximum of 100 objects
   *     can be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateForecastAdjustmentsResponse batchUpdateForecastAdjustments(
      @Nullable NetworkName parent, List<UpdateForecastAdjustmentRequest> requests) {
    BatchUpdateForecastAdjustmentsRequest request =
        BatchUpdateForecastAdjustmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateForecastAdjustments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `ForecastAdjustment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdateForecastAdjustmentRequest> requests = new ArrayList<>();
   *   BatchUpdateForecastAdjustmentsResponse response =
   *       forecastAdjustmentServiceClient.batchUpdateForecastAdjustments(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `ForecastAdjustments` will be updated.
   *     Format: `networks/{network_code}` The parent field in the UpdateForecastAdjustmentRequest
   *     must match this field.
   * @param requests Required. The `ForecastAdjustment` objects to update. A maximum of 100 objects
   *     can be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateForecastAdjustmentsResponse batchUpdateForecastAdjustments(
      String parent, List<UpdateForecastAdjustmentRequest> requests) {
    BatchUpdateForecastAdjustmentsRequest request =
        BatchUpdateForecastAdjustmentsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchUpdateForecastAdjustments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `ForecastAdjustment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   BatchUpdateForecastAdjustmentsRequest request =
   *       BatchUpdateForecastAdjustmentsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateForecastAdjustmentRequest>())
   *           .build();
   *   BatchUpdateForecastAdjustmentsResponse response =
   *       forecastAdjustmentServiceClient.batchUpdateForecastAdjustments(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateForecastAdjustmentsResponse batchUpdateForecastAdjustments(
      BatchUpdateForecastAdjustmentsRequest request) {
    return batchUpdateForecastAdjustmentsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `ForecastAdjustment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   BatchUpdateForecastAdjustmentsRequest request =
   *       BatchUpdateForecastAdjustmentsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateForecastAdjustmentRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateForecastAdjustmentsResponse> future =
   *       forecastAdjustmentServiceClient
   *           .batchUpdateForecastAdjustmentsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchUpdateForecastAdjustmentsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchUpdateForecastAdjustmentsRequest, BatchUpdateForecastAdjustmentsResponse>
      batchUpdateForecastAdjustmentsCallable() {
    return stub.batchUpdateForecastAdjustmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Calculates daily ad opportunity counts for a prospective `ForecastAdjustment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   ForecastAdjustment forecastAdjustment = ForecastAdjustment.newBuilder().build();
   *   CalculateDailyAdOpportunityCountsResponse response =
   *       forecastAdjustmentServiceClient.calculateDailyAdOpportunityCounts(
   *           parent, forecastAdjustment);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `ForecastAdjustment` will be calculated.
   *     Format: `networks/{network_code}`
   * @param forecastAdjustment Required. The prospective `ForecastAdjustment` to calculate daily ad
   *     opportunity counts for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CalculateDailyAdOpportunityCountsResponse calculateDailyAdOpportunityCounts(
      @Nullable NetworkName parent, ForecastAdjustment forecastAdjustment) {
    CalculateDailyAdOpportunityCountsRequest request =
        CalculateDailyAdOpportunityCountsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setForecastAdjustment(forecastAdjustment)
            .build();
    return calculateDailyAdOpportunityCounts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Calculates daily ad opportunity counts for a prospective `ForecastAdjustment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   ForecastAdjustment forecastAdjustment = ForecastAdjustment.newBuilder().build();
   *   CalculateDailyAdOpportunityCountsResponse response =
   *       forecastAdjustmentServiceClient.calculateDailyAdOpportunityCounts(
   *           parent, forecastAdjustment);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `ForecastAdjustment` will be calculated.
   *     Format: `networks/{network_code}`
   * @param forecastAdjustment Required. The prospective `ForecastAdjustment` to calculate daily ad
   *     opportunity counts for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CalculateDailyAdOpportunityCountsResponse calculateDailyAdOpportunityCounts(
      String parent, ForecastAdjustment forecastAdjustment) {
    CalculateDailyAdOpportunityCountsRequest request =
        CalculateDailyAdOpportunityCountsRequest.newBuilder()
            .setParent(parent)
            .setForecastAdjustment(forecastAdjustment)
            .build();
    return calculateDailyAdOpportunityCounts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Calculates daily ad opportunity counts for a prospective `ForecastAdjustment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   CalculateDailyAdOpportunityCountsRequest request =
   *       CalculateDailyAdOpportunityCountsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setForecastAdjustment(ForecastAdjustment.newBuilder().build())
   *           .build();
   *   CalculateDailyAdOpportunityCountsResponse response =
   *       forecastAdjustmentServiceClient.calculateDailyAdOpportunityCounts(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CalculateDailyAdOpportunityCountsResponse calculateDailyAdOpportunityCounts(
      CalculateDailyAdOpportunityCountsRequest request) {
    return calculateDailyAdOpportunityCountsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Calculates daily ad opportunity counts for a prospective `ForecastAdjustment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ForecastAdjustmentServiceClient forecastAdjustmentServiceClient =
   *     ForecastAdjustmentServiceClient.create()) {
   *   CalculateDailyAdOpportunityCountsRequest request =
   *       CalculateDailyAdOpportunityCountsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setForecastAdjustment(ForecastAdjustment.newBuilder().build())
   *           .build();
   *   ApiFuture<CalculateDailyAdOpportunityCountsResponse> future =
   *       forecastAdjustmentServiceClient
   *           .calculateDailyAdOpportunityCountsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   CalculateDailyAdOpportunityCountsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          CalculateDailyAdOpportunityCountsRequest, CalculateDailyAdOpportunityCountsResponse>
      calculateDailyAdOpportunityCountsCallable() {
    return stub.calculateDailyAdOpportunityCountsCallable();
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

  public static class ListForecastAdjustmentsPagedResponse
      extends AbstractPagedListResponse<
          ListForecastAdjustmentsRequest,
          ListForecastAdjustmentsResponse,
          ForecastAdjustment,
          ListForecastAdjustmentsPage,
          ListForecastAdjustmentsFixedSizeCollection> {

    public static ApiFuture<ListForecastAdjustmentsPagedResponse> createAsync(
        PageContext<
                ListForecastAdjustmentsRequest, ListForecastAdjustmentsResponse, ForecastAdjustment>
            context,
        ApiFuture<ListForecastAdjustmentsResponse> futureResponse) {
      ApiFuture<ListForecastAdjustmentsPage> futurePage =
          ListForecastAdjustmentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListForecastAdjustmentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListForecastAdjustmentsPagedResponse(ListForecastAdjustmentsPage page) {
      super(page, ListForecastAdjustmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListForecastAdjustmentsPage
      extends AbstractPage<
          ListForecastAdjustmentsRequest,
          ListForecastAdjustmentsResponse,
          ForecastAdjustment,
          ListForecastAdjustmentsPage> {

    private ListForecastAdjustmentsPage(
        @Nullable
            PageContext<
                ListForecastAdjustmentsRequest, ListForecastAdjustmentsResponse, ForecastAdjustment>
            context,
        @Nullable ListForecastAdjustmentsResponse response) {
      super(context, response);
    }

    private static ListForecastAdjustmentsPage createEmptyPage() {
      return new ListForecastAdjustmentsPage(null, null);
    }

    @Override
    protected ListForecastAdjustmentsPage createPage(
        @Nullable
            PageContext<
                ListForecastAdjustmentsRequest, ListForecastAdjustmentsResponse, ForecastAdjustment>
            context,
        @Nullable ListForecastAdjustmentsResponse response) {
      return new ListForecastAdjustmentsPage(context, response);
    }

    @Override
    public ApiFuture<ListForecastAdjustmentsPage> createPageAsync(
        @Nullable
            PageContext<
                ListForecastAdjustmentsRequest, ListForecastAdjustmentsResponse, ForecastAdjustment>
            context,
        ApiFuture<ListForecastAdjustmentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListForecastAdjustmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListForecastAdjustmentsRequest,
          ListForecastAdjustmentsResponse,
          ForecastAdjustment,
          ListForecastAdjustmentsPage,
          ListForecastAdjustmentsFixedSizeCollection> {

    private ListForecastAdjustmentsFixedSizeCollection(
        @Nullable List<ListForecastAdjustmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListForecastAdjustmentsFixedSizeCollection createEmptyCollection() {
      return new ListForecastAdjustmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListForecastAdjustmentsFixedSizeCollection createCollection(
        @Nullable List<ListForecastAdjustmentsPage> pages, int collectionSize) {
      return new ListForecastAdjustmentsFixedSizeCollection(pages, collectionSize);
    }
  }
}
