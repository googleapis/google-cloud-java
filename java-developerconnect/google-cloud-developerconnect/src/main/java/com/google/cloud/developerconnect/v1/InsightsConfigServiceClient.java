/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.developerconnect.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.developerconnect.v1.stub.InsightsConfigServiceStub;
import com.google.cloud.developerconnect.v1.stub.InsightsConfigServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Creates and manages InsightsConfigs.
 *
 * <p>The InsightsConfig resource is the core configuration object to capture events from your
 * Software Development Lifecycle. It acts as the central hub for managing how Developer connect
 * understands your application, its runtime environments, and the artifacts deployed within them. A
 * user can create an InsightsConfig, list previously-requested InsightsConfigs or get
 * InsightsConfigs by their ID to determine the status of the InsightsConfig.
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
 * try (InsightsConfigServiceClient insightsConfigServiceClient =
 *     InsightsConfigServiceClient.create()) {
 *   InsightsConfigName name =
 *       InsightsConfigName.of("[PROJECT]", "[LOCATION]", "[INSIGHTS_CONFIG]");
 *   InsightsConfig response = insightsConfigServiceClient.getInsightsConfig(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the InsightsConfigServiceClient object to clean up
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
 *      <td><p> ListInsightsConfigs</td>
 *      <td><p> Lists InsightsConfigs in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listInsightsConfigs(ListInsightsConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listInsightsConfigs(LocationName parent)
 *           <li><p> listInsightsConfigs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listInsightsConfigsPagedCallable()
 *           <li><p> listInsightsConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateInsightsConfig</td>
 *      <td><p> Creates a new InsightsConfig in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createInsightsConfigAsync(CreateInsightsConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createInsightsConfigAsync(LocationName parent, InsightsConfig insightsConfig, String insightsConfigId)
 *           <li><p> createInsightsConfigAsync(String parent, InsightsConfig insightsConfig, String insightsConfigId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createInsightsConfigOperationCallable()
 *           <li><p> createInsightsConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetInsightsConfig</td>
 *      <td><p> Gets details of a single Insight.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getInsightsConfig(GetInsightsConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getInsightsConfig(InsightsConfigName name)
 *           <li><p> getInsightsConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getInsightsConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateInsightsConfig</td>
 *      <td><p> Updates the parameters of a single InsightsConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateInsightsConfigAsync(UpdateInsightsConfigRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateInsightsConfigOperationCallable()
 *           <li><p> updateInsightsConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteInsightsConfig</td>
 *      <td><p> Delete a single Insight.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteInsightsConfigAsync(DeleteInsightsConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteInsightsConfigAsync(InsightsConfigName name)
 *           <li><p> deleteInsightsConfigAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteInsightsConfigOperationCallable()
 *           <li><p> deleteInsightsConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLocationsPagedCallable()
 *           <li><p> listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLocationCallable()
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
 * <p>This class can be customized by passing in a custom instance of InsightsConfigServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * InsightsConfigServiceSettings insightsConfigServiceSettings =
 *     InsightsConfigServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * InsightsConfigServiceClient insightsConfigServiceClient =
 *     InsightsConfigServiceClient.create(insightsConfigServiceSettings);
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
 * InsightsConfigServiceSettings insightsConfigServiceSettings =
 *     InsightsConfigServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * InsightsConfigServiceClient insightsConfigServiceClient =
 *     InsightsConfigServiceClient.create(insightsConfigServiceSettings);
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
 * InsightsConfigServiceSettings insightsConfigServiceSettings =
 *     InsightsConfigServiceSettings.newHttpJsonBuilder().build();
 * InsightsConfigServiceClient insightsConfigServiceClient =
 *     InsightsConfigServiceClient.create(insightsConfigServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class InsightsConfigServiceClient implements BackgroundResource {
  private final InsightsConfigServiceSettings settings;
  private final InsightsConfigServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of InsightsConfigServiceClient with default settings. */
  public static final InsightsConfigServiceClient create() throws IOException {
    return create(InsightsConfigServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of InsightsConfigServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final InsightsConfigServiceClient create(InsightsConfigServiceSettings settings)
      throws IOException {
    return new InsightsConfigServiceClient(settings);
  }

  /**
   * Constructs an instance of InsightsConfigServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(InsightsConfigServiceSettings).
   */
  public static final InsightsConfigServiceClient create(InsightsConfigServiceStub stub) {
    return new InsightsConfigServiceClient(stub);
  }

  /**
   * Constructs an instance of InsightsConfigServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected InsightsConfigServiceClient(InsightsConfigServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((InsightsConfigServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected InsightsConfigServiceClient(InsightsConfigServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final InsightsConfigServiceSettings getSettings() {
    return settings;
  }

  public InsightsConfigServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists InsightsConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (InsightsConfig element :
   *       insightsConfigServiceClient.listInsightsConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListInsightsConfigsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInsightsConfigsPagedResponse listInsightsConfigs(LocationName parent) {
    ListInsightsConfigsRequest request =
        ListInsightsConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInsightsConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists InsightsConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (InsightsConfig element :
   *       insightsConfigServiceClient.listInsightsConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListInsightsConfigsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInsightsConfigsPagedResponse listInsightsConfigs(String parent) {
    ListInsightsConfigsRequest request =
        ListInsightsConfigsRequest.newBuilder().setParent(parent).build();
    return listInsightsConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists InsightsConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   ListInsightsConfigsRequest request =
   *       ListInsightsConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (InsightsConfig element :
   *       insightsConfigServiceClient.listInsightsConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInsightsConfigsPagedResponse listInsightsConfigs(
      ListInsightsConfigsRequest request) {
    return listInsightsConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists InsightsConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   ListInsightsConfigsRequest request =
   *       ListInsightsConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<InsightsConfig> future =
   *       insightsConfigServiceClient.listInsightsConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (InsightsConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInsightsConfigsRequest, ListInsightsConfigsPagedResponse>
      listInsightsConfigsPagedCallable() {
    return stub.listInsightsConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists InsightsConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   ListInsightsConfigsRequest request =
   *       ListInsightsConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListInsightsConfigsResponse response =
   *         insightsConfigServiceClient.listInsightsConfigsCallable().call(request);
   *     for (InsightsConfig element : response.getInsightsConfigsList()) {
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
  public final UnaryCallable<ListInsightsConfigsRequest, ListInsightsConfigsResponse>
      listInsightsConfigsCallable() {
    return stub.listInsightsConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new InsightsConfig in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   InsightsConfig insightsConfig = InsightsConfig.newBuilder().build();
   *   String insightsConfigId = "insightsConfigId774395128";
   *   InsightsConfig response =
   *       insightsConfigServiceClient
   *           .createInsightsConfigAsync(parent, insightsConfig, insightsConfigId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param insightsConfig Required. The resource being created.
   * @param insightsConfigId Required. ID of the requesting InsightsConfig.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InsightsConfig, OperationMetadata> createInsightsConfigAsync(
      LocationName parent, InsightsConfig insightsConfig, String insightsConfigId) {
    CreateInsightsConfigRequest request =
        CreateInsightsConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInsightsConfig(insightsConfig)
            .setInsightsConfigId(insightsConfigId)
            .build();
    return createInsightsConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new InsightsConfig in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   InsightsConfig insightsConfig = InsightsConfig.newBuilder().build();
   *   String insightsConfigId = "insightsConfigId774395128";
   *   InsightsConfig response =
   *       insightsConfigServiceClient
   *           .createInsightsConfigAsync(parent, insightsConfig, insightsConfigId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param insightsConfig Required. The resource being created.
   * @param insightsConfigId Required. ID of the requesting InsightsConfig.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InsightsConfig, OperationMetadata> createInsightsConfigAsync(
      String parent, InsightsConfig insightsConfig, String insightsConfigId) {
    CreateInsightsConfigRequest request =
        CreateInsightsConfigRequest.newBuilder()
            .setParent(parent)
            .setInsightsConfig(insightsConfig)
            .setInsightsConfigId(insightsConfigId)
            .build();
    return createInsightsConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new InsightsConfig in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   CreateInsightsConfigRequest request =
   *       CreateInsightsConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInsightsConfigId("insightsConfigId774395128")
   *           .setInsightsConfig(InsightsConfig.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   InsightsConfig response =
   *       insightsConfigServiceClient.createInsightsConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InsightsConfig, OperationMetadata> createInsightsConfigAsync(
      CreateInsightsConfigRequest request) {
    return createInsightsConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new InsightsConfig in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   CreateInsightsConfigRequest request =
   *       CreateInsightsConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInsightsConfigId("insightsConfigId774395128")
   *           .setInsightsConfig(InsightsConfig.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<InsightsConfig, OperationMetadata> future =
   *       insightsConfigServiceClient.createInsightsConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   InsightsConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateInsightsConfigRequest, InsightsConfig, OperationMetadata>
      createInsightsConfigOperationCallable() {
    return stub.createInsightsConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new InsightsConfig in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   CreateInsightsConfigRequest request =
   *       CreateInsightsConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInsightsConfigId("insightsConfigId774395128")
   *           .setInsightsConfig(InsightsConfig.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       insightsConfigServiceClient.createInsightsConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateInsightsConfigRequest, Operation>
      createInsightsConfigCallable() {
    return stub.createInsightsConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Insight.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   InsightsConfigName name =
   *       InsightsConfigName.of("[PROJECT]", "[LOCATION]", "[INSIGHTS_CONFIG]");
   *   InsightsConfig response = insightsConfigServiceClient.getInsightsConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InsightsConfig getInsightsConfig(InsightsConfigName name) {
    GetInsightsConfigRequest request =
        GetInsightsConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getInsightsConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Insight.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   String name =
   *       InsightsConfigName.of("[PROJECT]", "[LOCATION]", "[INSIGHTS_CONFIG]").toString();
   *   InsightsConfig response = insightsConfigServiceClient.getInsightsConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InsightsConfig getInsightsConfig(String name) {
    GetInsightsConfigRequest request = GetInsightsConfigRequest.newBuilder().setName(name).build();
    return getInsightsConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Insight.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   GetInsightsConfigRequest request =
   *       GetInsightsConfigRequest.newBuilder()
   *           .setName(
   *               InsightsConfigName.of("[PROJECT]", "[LOCATION]", "[INSIGHTS_CONFIG]").toString())
   *           .build();
   *   InsightsConfig response = insightsConfigServiceClient.getInsightsConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InsightsConfig getInsightsConfig(GetInsightsConfigRequest request) {
    return getInsightsConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Insight.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   GetInsightsConfigRequest request =
   *       GetInsightsConfigRequest.newBuilder()
   *           .setName(
   *               InsightsConfigName.of("[PROJECT]", "[LOCATION]", "[INSIGHTS_CONFIG]").toString())
   *           .build();
   *   ApiFuture<InsightsConfig> future =
   *       insightsConfigServiceClient.getInsightsConfigCallable().futureCall(request);
   *   // Do something.
   *   InsightsConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInsightsConfigRequest, InsightsConfig> getInsightsConfigCallable() {
    return stub.getInsightsConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single InsightsConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   UpdateInsightsConfigRequest request =
   *       UpdateInsightsConfigRequest.newBuilder()
   *           .setInsightsConfig(InsightsConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   InsightsConfig response =
   *       insightsConfigServiceClient.updateInsightsConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InsightsConfig, OperationMetadata> updateInsightsConfigAsync(
      UpdateInsightsConfigRequest request) {
    return updateInsightsConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single InsightsConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   UpdateInsightsConfigRequest request =
   *       UpdateInsightsConfigRequest.newBuilder()
   *           .setInsightsConfig(InsightsConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<InsightsConfig, OperationMetadata> future =
   *       insightsConfigServiceClient.updateInsightsConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   InsightsConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateInsightsConfigRequest, InsightsConfig, OperationMetadata>
      updateInsightsConfigOperationCallable() {
    return stub.updateInsightsConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single InsightsConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   UpdateInsightsConfigRequest request =
   *       UpdateInsightsConfigRequest.newBuilder()
   *           .setInsightsConfig(InsightsConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       insightsConfigServiceClient.updateInsightsConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateInsightsConfigRequest, Operation>
      updateInsightsConfigCallable() {
    return stub.updateInsightsConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single Insight.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   InsightsConfigName name =
   *       InsightsConfigName.of("[PROJECT]", "[LOCATION]", "[INSIGHTS_CONFIG]");
   *   insightsConfigServiceClient.deleteInsightsConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Value for parent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInsightsConfigAsync(
      InsightsConfigName name) {
    DeleteInsightsConfigRequest request =
        DeleteInsightsConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteInsightsConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single Insight.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   String name =
   *       InsightsConfigName.of("[PROJECT]", "[LOCATION]", "[INSIGHTS_CONFIG]").toString();
   *   insightsConfigServiceClient.deleteInsightsConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Value for parent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInsightsConfigAsync(String name) {
    DeleteInsightsConfigRequest request =
        DeleteInsightsConfigRequest.newBuilder().setName(name).build();
    return deleteInsightsConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single Insight.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   DeleteInsightsConfigRequest request =
   *       DeleteInsightsConfigRequest.newBuilder()
   *           .setName(
   *               InsightsConfigName.of("[PROJECT]", "[LOCATION]", "[INSIGHTS_CONFIG]").toString())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   insightsConfigServiceClient.deleteInsightsConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInsightsConfigAsync(
      DeleteInsightsConfigRequest request) {
    return deleteInsightsConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single Insight.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   DeleteInsightsConfigRequest request =
   *       DeleteInsightsConfigRequest.newBuilder()
   *           .setName(
   *               InsightsConfigName.of("[PROJECT]", "[LOCATION]", "[INSIGHTS_CONFIG]").toString())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       insightsConfigServiceClient.deleteInsightsConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteInsightsConfigRequest, Empty, OperationMetadata>
      deleteInsightsConfigOperationCallable() {
    return stub.deleteInsightsConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single Insight.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   DeleteInsightsConfigRequest request =
   *       DeleteInsightsConfigRequest.newBuilder()
   *           .setName(
   *               InsightsConfigName.of("[PROJECT]", "[LOCATION]", "[INSIGHTS_CONFIG]").toString())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       insightsConfigServiceClient.deleteInsightsConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteInsightsConfigRequest, Operation>
      deleteInsightsConfigCallable() {
    return stub.deleteInsightsConfigCallable();
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
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : insightsConfigServiceClient.listLocations(request).iterateAll()) {
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
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       insightsConfigServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         insightsConfigServiceClient.listLocationsCallable().call(request);
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
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = insightsConfigServiceClient.getLocation(request);
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
   * try (InsightsConfigServiceClient insightsConfigServiceClient =
   *     InsightsConfigServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       insightsConfigServiceClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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

  public static class ListInsightsConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListInsightsConfigsRequest,
          ListInsightsConfigsResponse,
          InsightsConfig,
          ListInsightsConfigsPage,
          ListInsightsConfigsFixedSizeCollection> {

    public static ApiFuture<ListInsightsConfigsPagedResponse> createAsync(
        PageContext<ListInsightsConfigsRequest, ListInsightsConfigsResponse, InsightsConfig>
            context,
        ApiFuture<ListInsightsConfigsResponse> futureResponse) {
      ApiFuture<ListInsightsConfigsPage> futurePage =
          ListInsightsConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListInsightsConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListInsightsConfigsPagedResponse(ListInsightsConfigsPage page) {
      super(page, ListInsightsConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInsightsConfigsPage
      extends AbstractPage<
          ListInsightsConfigsRequest,
          ListInsightsConfigsResponse,
          InsightsConfig,
          ListInsightsConfigsPage> {

    private ListInsightsConfigsPage(
        PageContext<ListInsightsConfigsRequest, ListInsightsConfigsResponse, InsightsConfig>
            context,
        ListInsightsConfigsResponse response) {
      super(context, response);
    }

    private static ListInsightsConfigsPage createEmptyPage() {
      return new ListInsightsConfigsPage(null, null);
    }

    @Override
    protected ListInsightsConfigsPage createPage(
        PageContext<ListInsightsConfigsRequest, ListInsightsConfigsResponse, InsightsConfig>
            context,
        ListInsightsConfigsResponse response) {
      return new ListInsightsConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListInsightsConfigsPage> createPageAsync(
        PageContext<ListInsightsConfigsRequest, ListInsightsConfigsResponse, InsightsConfig>
            context,
        ApiFuture<ListInsightsConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInsightsConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInsightsConfigsRequest,
          ListInsightsConfigsResponse,
          InsightsConfig,
          ListInsightsConfigsPage,
          ListInsightsConfigsFixedSizeCollection> {

    private ListInsightsConfigsFixedSizeCollection(
        List<ListInsightsConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInsightsConfigsFixedSizeCollection createEmptyCollection() {
      return new ListInsightsConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInsightsConfigsFixedSizeCollection createCollection(
        List<ListInsightsConfigsPage> pages, int collectionSize) {
      return new ListInsightsConfigsFixedSizeCollection(pages, collectionSize);
    }
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
