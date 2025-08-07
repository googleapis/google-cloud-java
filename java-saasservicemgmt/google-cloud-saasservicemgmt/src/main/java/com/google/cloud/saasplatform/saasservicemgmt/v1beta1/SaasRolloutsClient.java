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

package com.google.cloud.saasplatform.saasservicemgmt.v1beta1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.stub.SaasRolloutsStub;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.stub.SaasRolloutsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Manages the rollout of SaaS services.
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
 * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
 *   RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]");
 *   Rollout response = saasRolloutsClient.getRollout(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SaasRolloutsClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListRollouts</td>
 *      <td><p> Retrieve a collection of rollouts.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRollouts(ListRolloutsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRollouts(LocationName parent)
 *           <li><p> listRollouts(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRolloutsPagedCallable()
 *           <li><p> listRolloutsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRollout</td>
 *      <td><p> Retrieve a single rollout.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRollout(GetRolloutRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRollout(RolloutName name)
 *           <li><p> getRollout(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRolloutCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateRollout</td>
 *      <td><p> Create a new rollout.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createRollout(CreateRolloutRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createRollout(LocationName parent, Rollout rollout, String rolloutId)
 *           <li><p> createRollout(String parent, Rollout rollout, String rolloutId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createRolloutCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateRollout</td>
 *      <td><p> Update a single rollout.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateRollout(UpdateRolloutRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateRollout(Rollout rollout, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateRolloutCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteRollout</td>
 *      <td><p> Delete a single rollout.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteRollout(DeleteRolloutRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteRollout(RolloutName name)
 *           <li><p> deleteRollout(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteRolloutCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRolloutKinds</td>
 *      <td><p> Retrieve a collection of rollout kinds.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRolloutKinds(ListRolloutKindsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRolloutKinds(LocationName parent)
 *           <li><p> listRolloutKinds(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRolloutKindsPagedCallable()
 *           <li><p> listRolloutKindsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRolloutKind</td>
 *      <td><p> Retrieve a single rollout kind.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRolloutKind(GetRolloutKindRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRolloutKind(RolloutKindName name)
 *           <li><p> getRolloutKind(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRolloutKindCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateRolloutKind</td>
 *      <td><p> Create a new rollout kind.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createRolloutKind(CreateRolloutKindRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createRolloutKind(LocationName parent, RolloutKind rolloutKind, String rolloutKindId)
 *           <li><p> createRolloutKind(String parent, RolloutKind rolloutKind, String rolloutKindId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createRolloutKindCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateRolloutKind</td>
 *      <td><p> Update a single rollout kind.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateRolloutKind(UpdateRolloutKindRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateRolloutKind(RolloutKind rolloutKind, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateRolloutKindCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteRolloutKind</td>
 *      <td><p> Delete a single rollout kind.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteRolloutKind(DeleteRolloutKindRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteRolloutKind(RolloutKindName name)
 *           <li><p> deleteRolloutKind(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteRolloutKindCallable()
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
 * <p>This class can be customized by passing in a custom instance of SaasRolloutsSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SaasRolloutsSettings saasRolloutsSettings =
 *     SaasRolloutsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create(saasRolloutsSettings);
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
 * SaasRolloutsSettings saasRolloutsSettings =
 *     SaasRolloutsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create(saasRolloutsSettings);
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
 * SaasRolloutsSettings saasRolloutsSettings = SaasRolloutsSettings.newHttpJsonBuilder().build();
 * SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create(saasRolloutsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SaasRolloutsClient implements BackgroundResource {
  private final SaasRolloutsSettings settings;
  private final SaasRolloutsStub stub;

  /** Constructs an instance of SaasRolloutsClient with default settings. */
  public static final SaasRolloutsClient create() throws IOException {
    return create(SaasRolloutsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SaasRolloutsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SaasRolloutsClient create(SaasRolloutsSettings settings) throws IOException {
    return new SaasRolloutsClient(settings);
  }

  /**
   * Constructs an instance of SaasRolloutsClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(SaasRolloutsSettings).
   */
  public static final SaasRolloutsClient create(SaasRolloutsStub stub) {
    return new SaasRolloutsClient(stub);
  }

  /**
   * Constructs an instance of SaasRolloutsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SaasRolloutsClient(SaasRolloutsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SaasRolloutsStubSettings) settings.getStubSettings()).createStub();
  }

  protected SaasRolloutsClient(SaasRolloutsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SaasRolloutsSettings getSettings() {
    return settings;
  }

  public SaasRolloutsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of rollouts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Rollout element : saasRolloutsClient.listRollouts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the rollout.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRolloutsPagedResponse listRollouts(LocationName parent) {
    ListRolloutsRequest request =
        ListRolloutsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRollouts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of rollouts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Rollout element : saasRolloutsClient.listRollouts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the rollout.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRolloutsPagedResponse listRollouts(String parent) {
    ListRolloutsRequest request = ListRolloutsRequest.newBuilder().setParent(parent).build();
    return listRollouts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of rollouts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   ListRolloutsRequest request =
   *       ListRolloutsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Rollout element : saasRolloutsClient.listRollouts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRolloutsPagedResponse listRollouts(ListRolloutsRequest request) {
    return listRolloutsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of rollouts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   ListRolloutsRequest request =
   *       ListRolloutsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Rollout> future =
   *       saasRolloutsClient.listRolloutsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Rollout element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRolloutsRequest, ListRolloutsPagedResponse>
      listRolloutsPagedCallable() {
    return stub.listRolloutsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of rollouts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   ListRolloutsRequest request =
   *       ListRolloutsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListRolloutsResponse response = saasRolloutsClient.listRolloutsCallable().call(request);
   *     for (Rollout element : response.getRolloutsList()) {
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
  public final UnaryCallable<ListRolloutsRequest, ListRolloutsResponse> listRolloutsCallable() {
    return stub.listRolloutsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]");
   *   Rollout response = saasRolloutsClient.getRollout(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rollout getRollout(RolloutName name) {
    GetRolloutRequest request =
        GetRolloutRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRollout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   String name = RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString();
   *   Rollout response = saasRolloutsClient.getRollout(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rollout getRollout(String name) {
    GetRolloutRequest request = GetRolloutRequest.newBuilder().setName(name).build();
    return getRollout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   GetRolloutRequest request =
   *       GetRolloutRequest.newBuilder()
   *           .setName(RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString())
   *           .build();
   *   Rollout response = saasRolloutsClient.getRollout(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rollout getRollout(GetRolloutRequest request) {
    return getRolloutCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   GetRolloutRequest request =
   *       GetRolloutRequest.newBuilder()
   *           .setName(RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString())
   *           .build();
   *   ApiFuture<Rollout> future = saasRolloutsClient.getRolloutCallable().futureCall(request);
   *   // Do something.
   *   Rollout response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRolloutRequest, Rollout> getRolloutCallable() {
    return stub.getRolloutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Rollout rollout = Rollout.newBuilder().build();
   *   String rolloutId = "rolloutId551248556";
   *   Rollout response = saasRolloutsClient.createRollout(parent, rollout, rolloutId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the rollout.
   * @param rollout Required. The desired state for the rollout.
   * @param rolloutId Required. The ID value for the new rollout.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rollout createRollout(LocationName parent, Rollout rollout, String rolloutId) {
    CreateRolloutRequest request =
        CreateRolloutRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRollout(rollout)
            .setRolloutId(rolloutId)
            .build();
    return createRollout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Rollout rollout = Rollout.newBuilder().build();
   *   String rolloutId = "rolloutId551248556";
   *   Rollout response = saasRolloutsClient.createRollout(parent, rollout, rolloutId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the rollout.
   * @param rollout Required. The desired state for the rollout.
   * @param rolloutId Required. The ID value for the new rollout.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rollout createRollout(String parent, Rollout rollout, String rolloutId) {
    CreateRolloutRequest request =
        CreateRolloutRequest.newBuilder()
            .setParent(parent)
            .setRollout(rollout)
            .setRolloutId(rolloutId)
            .build();
    return createRollout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   CreateRolloutRequest request =
   *       CreateRolloutRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRolloutId("rolloutId551248556")
   *           .setRollout(Rollout.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Rollout response = saasRolloutsClient.createRollout(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rollout createRollout(CreateRolloutRequest request) {
    return createRolloutCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   CreateRolloutRequest request =
   *       CreateRolloutRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRolloutId("rolloutId551248556")
   *           .setRollout(Rollout.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Rollout> future = saasRolloutsClient.createRolloutCallable().futureCall(request);
   *   // Do something.
   *   Rollout response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRolloutRequest, Rollout> createRolloutCallable() {
    return stub.createRolloutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   Rollout rollout = Rollout.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Rollout response = saasRolloutsClient.updateRollout(rollout, updateMask);
   * }
   * }</pre>
   *
   * @param rollout Required. The desired state for the rollout.
   * @param updateMask Field mask is used to specify the fields to be overwritten in the Rollout
   *     resource by the update.
   *     <p>The fields specified in the update_mask are relative to the resource, not the full
   *     request. A field will be overwritten if it is in the mask.
   *     <p>If the user does not provide a mask then all fields in the Rollout will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rollout updateRollout(Rollout rollout, FieldMask updateMask) {
    UpdateRolloutRequest request =
        UpdateRolloutRequest.newBuilder().setRollout(rollout).setUpdateMask(updateMask).build();
    return updateRollout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   UpdateRolloutRequest request =
   *       UpdateRolloutRequest.newBuilder()
   *           .setRollout(Rollout.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Rollout response = saasRolloutsClient.updateRollout(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rollout updateRollout(UpdateRolloutRequest request) {
    return updateRolloutCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   UpdateRolloutRequest request =
   *       UpdateRolloutRequest.newBuilder()
   *           .setRollout(Rollout.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Rollout> future = saasRolloutsClient.updateRolloutCallable().futureCall(request);
   *   // Do something.
   *   Rollout response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRolloutRequest, Rollout> updateRolloutCallable() {
    return stub.updateRolloutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]");
   *   saasRolloutsClient.deleteRollout(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRollout(RolloutName name) {
    DeleteRolloutRequest request =
        DeleteRolloutRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteRollout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   String name = RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString();
   *   saasRolloutsClient.deleteRollout(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRollout(String name) {
    DeleteRolloutRequest request = DeleteRolloutRequest.newBuilder().setName(name).build();
    deleteRollout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   DeleteRolloutRequest request =
   *       DeleteRolloutRequest.newBuilder()
   *           .setName(RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   saasRolloutsClient.deleteRollout(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRollout(DeleteRolloutRequest request) {
    deleteRolloutCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   DeleteRolloutRequest request =
   *       DeleteRolloutRequest.newBuilder()
   *           .setName(RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Empty> future = saasRolloutsClient.deleteRolloutCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRolloutRequest, Empty> deleteRolloutCallable() {
    return stub.deleteRolloutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of rollout kinds.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (RolloutKind element : saasRolloutsClient.listRolloutKinds(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the rollout kind.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRolloutKindsPagedResponse listRolloutKinds(LocationName parent) {
    ListRolloutKindsRequest request =
        ListRolloutKindsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRolloutKinds(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of rollout kinds.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (RolloutKind element : saasRolloutsClient.listRolloutKinds(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the rollout kind.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRolloutKindsPagedResponse listRolloutKinds(String parent) {
    ListRolloutKindsRequest request =
        ListRolloutKindsRequest.newBuilder().setParent(parent).build();
    return listRolloutKinds(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of rollout kinds.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   ListRolloutKindsRequest request =
   *       ListRolloutKindsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (RolloutKind element : saasRolloutsClient.listRolloutKinds(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRolloutKindsPagedResponse listRolloutKinds(ListRolloutKindsRequest request) {
    return listRolloutKindsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of rollout kinds.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   ListRolloutKindsRequest request =
   *       ListRolloutKindsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<RolloutKind> future =
   *       saasRolloutsClient.listRolloutKindsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (RolloutKind element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRolloutKindsRequest, ListRolloutKindsPagedResponse>
      listRolloutKindsPagedCallable() {
    return stub.listRolloutKindsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of rollout kinds.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   ListRolloutKindsRequest request =
   *       ListRolloutKindsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListRolloutKindsResponse response =
   *         saasRolloutsClient.listRolloutKindsCallable().call(request);
   *     for (RolloutKind element : response.getRolloutKindsList()) {
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
  public final UnaryCallable<ListRolloutKindsRequest, ListRolloutKindsResponse>
      listRolloutKindsCallable() {
    return stub.listRolloutKindsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single rollout kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   RolloutKindName name = RolloutKindName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_KIND_ID]");
   *   RolloutKind response = saasRolloutsClient.getRolloutKind(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RolloutKind getRolloutKind(RolloutKindName name) {
    GetRolloutKindRequest request =
        GetRolloutKindRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRolloutKind(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single rollout kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   String name = RolloutKindName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_KIND_ID]").toString();
   *   RolloutKind response = saasRolloutsClient.getRolloutKind(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RolloutKind getRolloutKind(String name) {
    GetRolloutKindRequest request = GetRolloutKindRequest.newBuilder().setName(name).build();
    return getRolloutKind(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single rollout kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   GetRolloutKindRequest request =
   *       GetRolloutKindRequest.newBuilder()
   *           .setName(
   *               RolloutKindName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_KIND_ID]").toString())
   *           .build();
   *   RolloutKind response = saasRolloutsClient.getRolloutKind(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RolloutKind getRolloutKind(GetRolloutKindRequest request) {
    return getRolloutKindCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single rollout kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   GetRolloutKindRequest request =
   *       GetRolloutKindRequest.newBuilder()
   *           .setName(
   *               RolloutKindName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_KIND_ID]").toString())
   *           .build();
   *   ApiFuture<RolloutKind> future =
   *       saasRolloutsClient.getRolloutKindCallable().futureCall(request);
   *   // Do something.
   *   RolloutKind response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRolloutKindRequest, RolloutKind> getRolloutKindCallable() {
    return stub.getRolloutKindCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new rollout kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   RolloutKind rolloutKind = RolloutKind.newBuilder().build();
   *   String rolloutKindId = "rolloutKindId-1380592416";
   *   RolloutKind response =
   *       saasRolloutsClient.createRolloutKind(parent, rolloutKind, rolloutKindId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the rollout kind.
   * @param rolloutKind Required. The desired state for the rollout kind.
   * @param rolloutKindId Required. The ID value for the new rollout kind.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RolloutKind createRolloutKind(
      LocationName parent, RolloutKind rolloutKind, String rolloutKindId) {
    CreateRolloutKindRequest request =
        CreateRolloutKindRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRolloutKind(rolloutKind)
            .setRolloutKindId(rolloutKindId)
            .build();
    return createRolloutKind(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new rollout kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   RolloutKind rolloutKind = RolloutKind.newBuilder().build();
   *   String rolloutKindId = "rolloutKindId-1380592416";
   *   RolloutKind response =
   *       saasRolloutsClient.createRolloutKind(parent, rolloutKind, rolloutKindId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the rollout kind.
   * @param rolloutKind Required. The desired state for the rollout kind.
   * @param rolloutKindId Required. The ID value for the new rollout kind.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RolloutKind createRolloutKind(
      String parent, RolloutKind rolloutKind, String rolloutKindId) {
    CreateRolloutKindRequest request =
        CreateRolloutKindRequest.newBuilder()
            .setParent(parent)
            .setRolloutKind(rolloutKind)
            .setRolloutKindId(rolloutKindId)
            .build();
    return createRolloutKind(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new rollout kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   CreateRolloutKindRequest request =
   *       CreateRolloutKindRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRolloutKindId("rolloutKindId-1380592416")
   *           .setRolloutKind(RolloutKind.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   RolloutKind response = saasRolloutsClient.createRolloutKind(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RolloutKind createRolloutKind(CreateRolloutKindRequest request) {
    return createRolloutKindCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new rollout kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   CreateRolloutKindRequest request =
   *       CreateRolloutKindRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRolloutKindId("rolloutKindId-1380592416")
   *           .setRolloutKind(RolloutKind.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<RolloutKind> future =
   *       saasRolloutsClient.createRolloutKindCallable().futureCall(request);
   *   // Do something.
   *   RolloutKind response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRolloutKindRequest, RolloutKind> createRolloutKindCallable() {
    return stub.createRolloutKindCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single rollout kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   RolloutKind rolloutKind = RolloutKind.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   RolloutKind response = saasRolloutsClient.updateRolloutKind(rolloutKind, updateMask);
   * }
   * }</pre>
   *
   * @param rolloutKind Required. The desired state for the rollout kind.
   * @param updateMask Field mask is used to specify the fields to be overwritten in the RolloutKind
   *     resource by the update.
   *     <p>The fields specified in the update_mask are relative to the resource, not the full
   *     request. A field will be overwritten if it is in the mask.
   *     <p>If the user does not provide a mask then all fields in the RolloutKind will be
   *     overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RolloutKind updateRolloutKind(RolloutKind rolloutKind, FieldMask updateMask) {
    UpdateRolloutKindRequest request =
        UpdateRolloutKindRequest.newBuilder()
            .setRolloutKind(rolloutKind)
            .setUpdateMask(updateMask)
            .build();
    return updateRolloutKind(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single rollout kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   UpdateRolloutKindRequest request =
   *       UpdateRolloutKindRequest.newBuilder()
   *           .setRolloutKind(RolloutKind.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   RolloutKind response = saasRolloutsClient.updateRolloutKind(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RolloutKind updateRolloutKind(UpdateRolloutKindRequest request) {
    return updateRolloutKindCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single rollout kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   UpdateRolloutKindRequest request =
   *       UpdateRolloutKindRequest.newBuilder()
   *           .setRolloutKind(RolloutKind.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<RolloutKind> future =
   *       saasRolloutsClient.updateRolloutKindCallable().futureCall(request);
   *   // Do something.
   *   RolloutKind response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRolloutKindRequest, RolloutKind> updateRolloutKindCallable() {
    return stub.updateRolloutKindCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single rollout kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   RolloutKindName name = RolloutKindName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_KIND_ID]");
   *   saasRolloutsClient.deleteRolloutKind(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRolloutKind(RolloutKindName name) {
    DeleteRolloutKindRequest request =
        DeleteRolloutKindRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteRolloutKind(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single rollout kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   String name = RolloutKindName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_KIND_ID]").toString();
   *   saasRolloutsClient.deleteRolloutKind(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRolloutKind(String name) {
    DeleteRolloutKindRequest request = DeleteRolloutKindRequest.newBuilder().setName(name).build();
    deleteRolloutKind(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single rollout kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   DeleteRolloutKindRequest request =
   *       DeleteRolloutKindRequest.newBuilder()
   *           .setName(
   *               RolloutKindName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_KIND_ID]").toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   saasRolloutsClient.deleteRolloutKind(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRolloutKind(DeleteRolloutKindRequest request) {
    deleteRolloutKindCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single rollout kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   DeleteRolloutKindRequest request =
   *       DeleteRolloutKindRequest.newBuilder()
   *           .setName(
   *               RolloutKindName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_KIND_ID]").toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Empty> future = saasRolloutsClient.deleteRolloutKindCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRolloutKindRequest, Empty> deleteRolloutKindCallable() {
    return stub.deleteRolloutKindCallable();
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
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : saasRolloutsClient.listLocations(request).iterateAll()) {
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
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       saasRolloutsClient.listLocationsPagedCallable().futureCall(request);
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
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = saasRolloutsClient.listLocationsCallable().call(request);
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
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = saasRolloutsClient.getLocation(request);
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
   * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = saasRolloutsClient.getLocationCallable().futureCall(request);
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

  public static class ListRolloutsPagedResponse
      extends AbstractPagedListResponse<
          ListRolloutsRequest,
          ListRolloutsResponse,
          Rollout,
          ListRolloutsPage,
          ListRolloutsFixedSizeCollection> {

    public static ApiFuture<ListRolloutsPagedResponse> createAsync(
        PageContext<ListRolloutsRequest, ListRolloutsResponse, Rollout> context,
        ApiFuture<ListRolloutsResponse> futureResponse) {
      ApiFuture<ListRolloutsPage> futurePage =
          ListRolloutsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRolloutsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRolloutsPagedResponse(ListRolloutsPage page) {
      super(page, ListRolloutsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRolloutsPage
      extends AbstractPage<ListRolloutsRequest, ListRolloutsResponse, Rollout, ListRolloutsPage> {

    private ListRolloutsPage(
        PageContext<ListRolloutsRequest, ListRolloutsResponse, Rollout> context,
        ListRolloutsResponse response) {
      super(context, response);
    }

    private static ListRolloutsPage createEmptyPage() {
      return new ListRolloutsPage(null, null);
    }

    @Override
    protected ListRolloutsPage createPage(
        PageContext<ListRolloutsRequest, ListRolloutsResponse, Rollout> context,
        ListRolloutsResponse response) {
      return new ListRolloutsPage(context, response);
    }

    @Override
    public ApiFuture<ListRolloutsPage> createPageAsync(
        PageContext<ListRolloutsRequest, ListRolloutsResponse, Rollout> context,
        ApiFuture<ListRolloutsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRolloutsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRolloutsRequest,
          ListRolloutsResponse,
          Rollout,
          ListRolloutsPage,
          ListRolloutsFixedSizeCollection> {

    private ListRolloutsFixedSizeCollection(List<ListRolloutsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRolloutsFixedSizeCollection createEmptyCollection() {
      return new ListRolloutsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRolloutsFixedSizeCollection createCollection(
        List<ListRolloutsPage> pages, int collectionSize) {
      return new ListRolloutsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRolloutKindsPagedResponse
      extends AbstractPagedListResponse<
          ListRolloutKindsRequest,
          ListRolloutKindsResponse,
          RolloutKind,
          ListRolloutKindsPage,
          ListRolloutKindsFixedSizeCollection> {

    public static ApiFuture<ListRolloutKindsPagedResponse> createAsync(
        PageContext<ListRolloutKindsRequest, ListRolloutKindsResponse, RolloutKind> context,
        ApiFuture<ListRolloutKindsResponse> futureResponse) {
      ApiFuture<ListRolloutKindsPage> futurePage =
          ListRolloutKindsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRolloutKindsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRolloutKindsPagedResponse(ListRolloutKindsPage page) {
      super(page, ListRolloutKindsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRolloutKindsPage
      extends AbstractPage<
          ListRolloutKindsRequest, ListRolloutKindsResponse, RolloutKind, ListRolloutKindsPage> {

    private ListRolloutKindsPage(
        PageContext<ListRolloutKindsRequest, ListRolloutKindsResponse, RolloutKind> context,
        ListRolloutKindsResponse response) {
      super(context, response);
    }

    private static ListRolloutKindsPage createEmptyPage() {
      return new ListRolloutKindsPage(null, null);
    }

    @Override
    protected ListRolloutKindsPage createPage(
        PageContext<ListRolloutKindsRequest, ListRolloutKindsResponse, RolloutKind> context,
        ListRolloutKindsResponse response) {
      return new ListRolloutKindsPage(context, response);
    }

    @Override
    public ApiFuture<ListRolloutKindsPage> createPageAsync(
        PageContext<ListRolloutKindsRequest, ListRolloutKindsResponse, RolloutKind> context,
        ApiFuture<ListRolloutKindsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRolloutKindsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRolloutKindsRequest,
          ListRolloutKindsResponse,
          RolloutKind,
          ListRolloutKindsPage,
          ListRolloutKindsFixedSizeCollection> {

    private ListRolloutKindsFixedSizeCollection(
        List<ListRolloutKindsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRolloutKindsFixedSizeCollection createEmptyCollection() {
      return new ListRolloutKindsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRolloutKindsFixedSizeCollection createCollection(
        List<ListRolloutKindsPage> pages, int collectionSize) {
      return new ListRolloutKindsFixedSizeCollection(pages, collectionSize);
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
