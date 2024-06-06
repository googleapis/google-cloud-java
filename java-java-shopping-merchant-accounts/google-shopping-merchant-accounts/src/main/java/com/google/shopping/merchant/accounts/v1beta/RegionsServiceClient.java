/*
 * Copyright 2024 Google LLC
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

package com.google.shopping.merchant.accounts.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.shopping.merchant.accounts.v1beta.stub.RegionsServiceStub;
import com.google.shopping.merchant.accounts.v1beta.stub.RegionsServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Manages regions configuration.
 *
 * <p>This API defines the following resource model:
 *
 * <p>- [Region][google.shopping.merchant.accounts.v1main.Region]
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
 * try (RegionsServiceClient regionsServiceClient = RegionsServiceClient.create()) {
 *   RegionName name = RegionName.of("[ACCOUNT]", "[REGION]");
 *   Region response = regionsServiceClient.getRegion(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RegionsServiceClient object to clean up resources such
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
 *      <td><p> GetRegion</td>
 *      <td><p> Retrieves a region defined in your Merchant Center account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRegion(GetRegionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRegion(RegionName name)
 *           <li><p> getRegion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRegionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateRegion</td>
 *      <td><p> Creates a region definition in your Merchant Center account. Executing this method requires admin access.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createRegion(CreateRegionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createRegion(AccountName parent, Region region, String regionId)
 *           <li><p> createRegion(String parent, Region region, String regionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createRegionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateRegion</td>
 *      <td><p> Updates a region definition in your Merchant Center account. Executing this method requires admin access.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateRegion(UpdateRegionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateRegion(Region region, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateRegionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteRegion</td>
 *      <td><p> Deletes a region definition from your Merchant Center account. Executing this method requires admin access.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteRegion(DeleteRegionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteRegion(RegionName name)
 *           <li><p> deleteRegion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteRegionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRegions</td>
 *      <td><p> Lists the regions in your Merchant Center account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRegions(ListRegionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRegions(AccountName parent)
 *           <li><p> listRegions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRegionsPagedCallable()
 *           <li><p> listRegionsCallable()
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
 * <p>This class can be customized by passing in a custom instance of RegionsServiceSettings to
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
 * RegionsServiceSettings regionsServiceSettings =
 *     RegionsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionsServiceClient regionsServiceClient = RegionsServiceClient.create(regionsServiceSettings);
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
 * RegionsServiceSettings regionsServiceSettings =
 *     RegionsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionsServiceClient regionsServiceClient = RegionsServiceClient.create(regionsServiceSettings);
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
 * RegionsServiceSettings regionsServiceSettings =
 *     RegionsServiceSettings.newHttpJsonBuilder().build();
 * RegionsServiceClient regionsServiceClient = RegionsServiceClient.create(regionsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class RegionsServiceClient implements BackgroundResource {
  private final RegionsServiceSettings settings;
  private final RegionsServiceStub stub;

  /** Constructs an instance of RegionsServiceClient with default settings. */
  public static final RegionsServiceClient create() throws IOException {
    return create(RegionsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionsServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionsServiceClient create(RegionsServiceSettings settings)
      throws IOException {
    return new RegionsServiceClient(settings);
  }

  /**
   * Constructs an instance of RegionsServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(RegionsServiceSettings).
   */
  public static final RegionsServiceClient create(RegionsServiceStub stub) {
    return new RegionsServiceClient(stub);
  }

  /**
   * Constructs an instance of RegionsServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected RegionsServiceClient(RegionsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RegionsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected RegionsServiceClient(RegionsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionsServiceSettings getSettings() {
    return settings;
  }

  public RegionsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a region defined in your Merchant Center account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsServiceClient regionsServiceClient = RegionsServiceClient.create()) {
   *   RegionName name = RegionName.of("[ACCOUNT]", "[REGION]");
   *   Region response = regionsServiceClient.getRegion(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the region to retrieve. Format:
   *     `accounts/{account}/regions/{region}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Region getRegion(RegionName name) {
    GetRegionRequest request =
        GetRegionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRegion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a region defined in your Merchant Center account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsServiceClient regionsServiceClient = RegionsServiceClient.create()) {
   *   String name = RegionName.of("[ACCOUNT]", "[REGION]").toString();
   *   Region response = regionsServiceClient.getRegion(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the region to retrieve. Format:
   *     `accounts/{account}/regions/{region}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Region getRegion(String name) {
    GetRegionRequest request = GetRegionRequest.newBuilder().setName(name).build();
    return getRegion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a region defined in your Merchant Center account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsServiceClient regionsServiceClient = RegionsServiceClient.create()) {
   *   GetRegionRequest request =
   *       GetRegionRequest.newBuilder()
   *           .setName(RegionName.of("[ACCOUNT]", "[REGION]").toString())
   *           .build();
   *   Region response = regionsServiceClient.getRegion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Region getRegion(GetRegionRequest request) {
    return getRegionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a region defined in your Merchant Center account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsServiceClient regionsServiceClient = RegionsServiceClient.create()) {
   *   GetRegionRequest request =
   *       GetRegionRequest.newBuilder()
   *           .setName(RegionName.of("[ACCOUNT]", "[REGION]").toString())
   *           .build();
   *   ApiFuture<Region> future = regionsServiceClient.getRegionCallable().futureCall(request);
   *   // Do something.
   *   Region response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRegionRequest, Region> getRegionCallable() {
    return stub.getRegionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a region definition in your Merchant Center account. Executing this method requires
   * admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsServiceClient regionsServiceClient = RegionsServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   Region region = Region.newBuilder().build();
   *   String regionId = "regionId-690339025";
   *   Region response = regionsServiceClient.createRegion(parent, region, regionId);
   * }
   * }</pre>
   *
   * @param parent Required. The account to create a region for. Format: `accounts/{account}`
   * @param region Required. The region to create.
   * @param regionId Required. The identifier for the region, unique over all regions of the same
   *     account.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Region createRegion(AccountName parent, Region region, String regionId) {
    CreateRegionRequest request =
        CreateRegionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRegion(region)
            .setRegionId(regionId)
            .build();
    return createRegion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a region definition in your Merchant Center account. Executing this method requires
   * admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsServiceClient regionsServiceClient = RegionsServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   Region region = Region.newBuilder().build();
   *   String regionId = "regionId-690339025";
   *   Region response = regionsServiceClient.createRegion(parent, region, regionId);
   * }
   * }</pre>
   *
   * @param parent Required. The account to create a region for. Format: `accounts/{account}`
   * @param region Required. The region to create.
   * @param regionId Required. The identifier for the region, unique over all regions of the same
   *     account.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Region createRegion(String parent, Region region, String regionId) {
    CreateRegionRequest request =
        CreateRegionRequest.newBuilder()
            .setParent(parent)
            .setRegion(region)
            .setRegionId(regionId)
            .build();
    return createRegion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a region definition in your Merchant Center account. Executing this method requires
   * admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsServiceClient regionsServiceClient = RegionsServiceClient.create()) {
   *   CreateRegionRequest request =
   *       CreateRegionRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setRegionId("regionId-690339025")
   *           .setRegion(Region.newBuilder().build())
   *           .build();
   *   Region response = regionsServiceClient.createRegion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Region createRegion(CreateRegionRequest request) {
    return createRegionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a region definition in your Merchant Center account. Executing this method requires
   * admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsServiceClient regionsServiceClient = RegionsServiceClient.create()) {
   *   CreateRegionRequest request =
   *       CreateRegionRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setRegionId("regionId-690339025")
   *           .setRegion(Region.newBuilder().build())
   *           .build();
   *   ApiFuture<Region> future = regionsServiceClient.createRegionCallable().futureCall(request);
   *   // Do something.
   *   Region response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRegionRequest, Region> createRegionCallable() {
    return stub.createRegionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a region definition in your Merchant Center account. Executing this method requires
   * admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsServiceClient regionsServiceClient = RegionsServiceClient.create()) {
   *   Region region = Region.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Region response = regionsServiceClient.updateRegion(region, updateMask);
   * }
   * }</pre>
   *
   * @param region Required. The updated region.
   * @param updateMask Optional. The comma-separated field mask indicating the fields to update.
   *     Example: `"displayName,postalCodeArea.regionCode"`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Region updateRegion(Region region, FieldMask updateMask) {
    UpdateRegionRequest request =
        UpdateRegionRequest.newBuilder().setRegion(region).setUpdateMask(updateMask).build();
    return updateRegion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a region definition in your Merchant Center account. Executing this method requires
   * admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsServiceClient regionsServiceClient = RegionsServiceClient.create()) {
   *   UpdateRegionRequest request =
   *       UpdateRegionRequest.newBuilder()
   *           .setRegion(Region.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Region response = regionsServiceClient.updateRegion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Region updateRegion(UpdateRegionRequest request) {
    return updateRegionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a region definition in your Merchant Center account. Executing this method requires
   * admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsServiceClient regionsServiceClient = RegionsServiceClient.create()) {
   *   UpdateRegionRequest request =
   *       UpdateRegionRequest.newBuilder()
   *           .setRegion(Region.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Region> future = regionsServiceClient.updateRegionCallable().futureCall(request);
   *   // Do something.
   *   Region response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRegionRequest, Region> updateRegionCallable() {
    return stub.updateRegionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a region definition from your Merchant Center account. Executing this method requires
   * admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsServiceClient regionsServiceClient = RegionsServiceClient.create()) {
   *   RegionName name = RegionName.of("[ACCOUNT]", "[REGION]");
   *   regionsServiceClient.deleteRegion(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the region to delete. Format:
   *     `accounts/{account}/regions/{region}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRegion(RegionName name) {
    DeleteRegionRequest request =
        DeleteRegionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteRegion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a region definition from your Merchant Center account. Executing this method requires
   * admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsServiceClient regionsServiceClient = RegionsServiceClient.create()) {
   *   String name = RegionName.of("[ACCOUNT]", "[REGION]").toString();
   *   regionsServiceClient.deleteRegion(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the region to delete. Format:
   *     `accounts/{account}/regions/{region}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRegion(String name) {
    DeleteRegionRequest request = DeleteRegionRequest.newBuilder().setName(name).build();
    deleteRegion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a region definition from your Merchant Center account. Executing this method requires
   * admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsServiceClient regionsServiceClient = RegionsServiceClient.create()) {
   *   DeleteRegionRequest request =
   *       DeleteRegionRequest.newBuilder()
   *           .setName(RegionName.of("[ACCOUNT]", "[REGION]").toString())
   *           .build();
   *   regionsServiceClient.deleteRegion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRegion(DeleteRegionRequest request) {
    deleteRegionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a region definition from your Merchant Center account. Executing this method requires
   * admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsServiceClient regionsServiceClient = RegionsServiceClient.create()) {
   *   DeleteRegionRequest request =
   *       DeleteRegionRequest.newBuilder()
   *           .setName(RegionName.of("[ACCOUNT]", "[REGION]").toString())
   *           .build();
   *   ApiFuture<Empty> future = regionsServiceClient.deleteRegionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRegionRequest, Empty> deleteRegionCallable() {
    return stub.deleteRegionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the regions in your Merchant Center account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsServiceClient regionsServiceClient = RegionsServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   for (Region element : regionsServiceClient.listRegions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The account to list regions for. Format: `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRegionsPagedResponse listRegions(AccountName parent) {
    ListRegionsRequest request =
        ListRegionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRegions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the regions in your Merchant Center account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsServiceClient regionsServiceClient = RegionsServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   for (Region element : regionsServiceClient.listRegions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The account to list regions for. Format: `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRegionsPagedResponse listRegions(String parent) {
    ListRegionsRequest request = ListRegionsRequest.newBuilder().setParent(parent).build();
    return listRegions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the regions in your Merchant Center account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsServiceClient regionsServiceClient = RegionsServiceClient.create()) {
   *   ListRegionsRequest request =
   *       ListRegionsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Region element : regionsServiceClient.listRegions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRegionsPagedResponse listRegions(ListRegionsRequest request) {
    return listRegionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the regions in your Merchant Center account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsServiceClient regionsServiceClient = RegionsServiceClient.create()) {
   *   ListRegionsRequest request =
   *       ListRegionsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Region> future =
   *       regionsServiceClient.listRegionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Region element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRegionsRequest, ListRegionsPagedResponse>
      listRegionsPagedCallable() {
    return stub.listRegionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the regions in your Merchant Center account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsServiceClient regionsServiceClient = RegionsServiceClient.create()) {
   *   ListRegionsRequest request =
   *       ListRegionsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListRegionsResponse response = regionsServiceClient.listRegionsCallable().call(request);
   *     for (Region element : response.getRegionsList()) {
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
  public final UnaryCallable<ListRegionsRequest, ListRegionsResponse> listRegionsCallable() {
    return stub.listRegionsCallable();
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

  public static class ListRegionsPagedResponse
      extends AbstractPagedListResponse<
          ListRegionsRequest,
          ListRegionsResponse,
          Region,
          ListRegionsPage,
          ListRegionsFixedSizeCollection> {

    public static ApiFuture<ListRegionsPagedResponse> createAsync(
        PageContext<ListRegionsRequest, ListRegionsResponse, Region> context,
        ApiFuture<ListRegionsResponse> futureResponse) {
      ApiFuture<ListRegionsPage> futurePage =
          ListRegionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListRegionsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListRegionsPagedResponse(ListRegionsPage page) {
      super(page, ListRegionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRegionsPage
      extends AbstractPage<ListRegionsRequest, ListRegionsResponse, Region, ListRegionsPage> {

    private ListRegionsPage(
        PageContext<ListRegionsRequest, ListRegionsResponse, Region> context,
        ListRegionsResponse response) {
      super(context, response);
    }

    private static ListRegionsPage createEmptyPage() {
      return new ListRegionsPage(null, null);
    }

    @Override
    protected ListRegionsPage createPage(
        PageContext<ListRegionsRequest, ListRegionsResponse, Region> context,
        ListRegionsResponse response) {
      return new ListRegionsPage(context, response);
    }

    @Override
    public ApiFuture<ListRegionsPage> createPageAsync(
        PageContext<ListRegionsRequest, ListRegionsResponse, Region> context,
        ApiFuture<ListRegionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRegionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionsRequest,
          ListRegionsResponse,
          Region,
          ListRegionsPage,
          ListRegionsFixedSizeCollection> {

    private ListRegionsFixedSizeCollection(List<ListRegionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRegionsFixedSizeCollection createEmptyCollection() {
      return new ListRegionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRegionsFixedSizeCollection createCollection(
        List<ListRegionsPage> pages, int collectionSize) {
      return new ListRegionsFixedSizeCollection(pages, collectionSize);
    }
  }
}
