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

package com.google.cloud.networkconnectivity.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networkconnectivity.v1.stub.InternalRangeServiceStub;
import com.google.cloud.networkconnectivity.v1.stub.InternalRangeServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The CLH-based service for internal range resources used to perform IPAM
 * operations within a VPC network.
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
 * try (InternalRangeServiceClient internalRangeServiceClient =
 *     InternalRangeServiceClient.create()) {
 *   InternalRangeName name = InternalRangeName.of("[PROJECT]", "[LOCATION]", "[INTERNAL_RANGE]");
 *   InternalRange response = internalRangeServiceClient.getInternalRange(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the InternalRangeServiceClient object to clean up
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
 *      <td><p> ListInternalRanges</td>
 *      <td><p> Lists internal ranges in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listInternalRanges(ListInternalRangesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listInternalRanges(LocationName parent)
 *           <li><p> listInternalRanges(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listInternalRangesPagedCallable()
 *           <li><p> listInternalRangesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetInternalRange</td>
 *      <td><p> Gets details of a single internal range.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getInternalRange(GetInternalRangeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getInternalRange(InternalRangeName name)
 *           <li><p> getInternalRange(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getInternalRangeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateInternalRange</td>
 *      <td><p> Creates a new internal range in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createInternalRangeAsync(CreateInternalRangeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createInternalRangeAsync(LocationName parent, InternalRange internalRange, String internalRangeId)
 *           <li><p> createInternalRangeAsync(String parent, InternalRange internalRange, String internalRangeId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createInternalRangeOperationCallable()
 *           <li><p> createInternalRangeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateInternalRange</td>
 *      <td><p> Updates the parameters of a single internal range.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateInternalRangeAsync(UpdateInternalRangeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateInternalRangeAsync(InternalRange internalRange, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateInternalRangeOperationCallable()
 *           <li><p> updateInternalRangeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteInternalRange</td>
 *      <td><p> Deletes a single internal range.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteInternalRangeAsync(DeleteInternalRangeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteInternalRangeAsync(InternalRangeName name)
 *           <li><p> deleteInternalRangeAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteInternalRangeOperationCallable()
 *           <li><p> deleteInternalRangeCallable()
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
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy on the specified resource. Replacesany existing policy.
 * <p> Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a resource. Returns an empty policyif the resource exists and does not have a policy set.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns permissions that a caller has on the specified resource. If theresource does not exist, this will return an empty set ofpermissions, not a `NOT_FOUND` error.
 * <p> Note: This operation is designed to be used for buildingpermission-aware UIs and command-line tools, not for authorizationchecking. This operation may "fail open" without warning.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
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
 * <p>This class can be customized by passing in a custom instance of InternalRangeServiceSettings
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
 * InternalRangeServiceSettings internalRangeServiceSettings =
 *     InternalRangeServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * InternalRangeServiceClient internalRangeServiceClient =
 *     InternalRangeServiceClient.create(internalRangeServiceSettings);
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
 * InternalRangeServiceSettings internalRangeServiceSettings =
 *     InternalRangeServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * InternalRangeServiceClient internalRangeServiceClient =
 *     InternalRangeServiceClient.create(internalRangeServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class InternalRangeServiceClient implements BackgroundResource {
  private final InternalRangeServiceSettings settings;
  private final InternalRangeServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of InternalRangeServiceClient with default settings. */
  public static final InternalRangeServiceClient create() throws IOException {
    return create(InternalRangeServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of InternalRangeServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final InternalRangeServiceClient create(InternalRangeServiceSettings settings)
      throws IOException {
    return new InternalRangeServiceClient(settings);
  }

  /**
   * Constructs an instance of InternalRangeServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(InternalRangeServiceSettings).
   */
  public static final InternalRangeServiceClient create(InternalRangeServiceStub stub) {
    return new InternalRangeServiceClient(stub);
  }

  /**
   * Constructs an instance of InternalRangeServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected InternalRangeServiceClient(InternalRangeServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((InternalRangeServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected InternalRangeServiceClient(InternalRangeServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final InternalRangeServiceSettings getSettings() {
    return settings;
  }

  public InternalRangeServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists internal ranges in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (InternalRange element :
   *       internalRangeServiceClient.listInternalRanges(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInternalRangesPagedResponse listInternalRanges(LocationName parent) {
    ListInternalRangesRequest request =
        ListInternalRangesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInternalRanges(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists internal ranges in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (InternalRange element :
   *       internalRangeServiceClient.listInternalRanges(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInternalRangesPagedResponse listInternalRanges(String parent) {
    ListInternalRangesRequest request =
        ListInternalRangesRequest.newBuilder().setParent(parent).build();
    return listInternalRanges(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists internal ranges in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   ListInternalRangesRequest request =
   *       ListInternalRangesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (InternalRange element :
   *       internalRangeServiceClient.listInternalRanges(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInternalRangesPagedResponse listInternalRanges(
      ListInternalRangesRequest request) {
    return listInternalRangesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists internal ranges in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   ListInternalRangesRequest request =
   *       ListInternalRangesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<InternalRange> future =
   *       internalRangeServiceClient.listInternalRangesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (InternalRange element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInternalRangesRequest, ListInternalRangesPagedResponse>
      listInternalRangesPagedCallable() {
    return stub.listInternalRangesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists internal ranges in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   ListInternalRangesRequest request =
   *       ListInternalRangesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListInternalRangesResponse response =
   *         internalRangeServiceClient.listInternalRangesCallable().call(request);
   *     for (InternalRange element : response.getInternalRangesList()) {
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
  public final UnaryCallable<ListInternalRangesRequest, ListInternalRangesResponse>
      listInternalRangesCallable() {
    return stub.listInternalRangesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single internal range.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   InternalRangeName name = InternalRangeName.of("[PROJECT]", "[LOCATION]", "[INTERNAL_RANGE]");
   *   InternalRange response = internalRangeServiceClient.getInternalRange(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the InternalRange to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InternalRange getInternalRange(InternalRangeName name) {
    GetInternalRangeRequest request =
        GetInternalRangeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getInternalRange(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single internal range.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   String name = InternalRangeName.of("[PROJECT]", "[LOCATION]", "[INTERNAL_RANGE]").toString();
   *   InternalRange response = internalRangeServiceClient.getInternalRange(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the InternalRange to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InternalRange getInternalRange(String name) {
    GetInternalRangeRequest request = GetInternalRangeRequest.newBuilder().setName(name).build();
    return getInternalRange(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single internal range.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   GetInternalRangeRequest request =
   *       GetInternalRangeRequest.newBuilder()
   *           .setName(
   *               InternalRangeName.of("[PROJECT]", "[LOCATION]", "[INTERNAL_RANGE]").toString())
   *           .build();
   *   InternalRange response = internalRangeServiceClient.getInternalRange(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InternalRange getInternalRange(GetInternalRangeRequest request) {
    return getInternalRangeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single internal range.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   GetInternalRangeRequest request =
   *       GetInternalRangeRequest.newBuilder()
   *           .setName(
   *               InternalRangeName.of("[PROJECT]", "[LOCATION]", "[INTERNAL_RANGE]").toString())
   *           .build();
   *   ApiFuture<InternalRange> future =
   *       internalRangeServiceClient.getInternalRangeCallable().futureCall(request);
   *   // Do something.
   *   InternalRange response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInternalRangeRequest, InternalRange> getInternalRangeCallable() {
    return stub.getInternalRangeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new internal range in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   InternalRange internalRange = InternalRange.newBuilder().build();
   *   String internalRangeId = "internalRangeId-392750661";
   *   InternalRange response =
   *       internalRangeServiceClient
   *           .createInternalRangeAsync(parent, internalRange, internalRangeId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name of the internal range.
   * @param internalRange Required. Initial values for a new internal range
   * @param internalRangeId Optional. Resource ID (i.e. 'foo' in
   *     '[...]/projects/p/locations/l/internalRanges/foo') See
   *     https://google.aip.dev/122#resource-id-segments Unique per location.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InternalRange, OperationMetadata> createInternalRangeAsync(
      LocationName parent, InternalRange internalRange, String internalRangeId) {
    CreateInternalRangeRequest request =
        CreateInternalRangeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInternalRange(internalRange)
            .setInternalRangeId(internalRangeId)
            .build();
    return createInternalRangeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new internal range in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   InternalRange internalRange = InternalRange.newBuilder().build();
   *   String internalRangeId = "internalRangeId-392750661";
   *   InternalRange response =
   *       internalRangeServiceClient
   *           .createInternalRangeAsync(parent, internalRange, internalRangeId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name of the internal range.
   * @param internalRange Required. Initial values for a new internal range
   * @param internalRangeId Optional. Resource ID (i.e. 'foo' in
   *     '[...]/projects/p/locations/l/internalRanges/foo') See
   *     https://google.aip.dev/122#resource-id-segments Unique per location.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InternalRange, OperationMetadata> createInternalRangeAsync(
      String parent, InternalRange internalRange, String internalRangeId) {
    CreateInternalRangeRequest request =
        CreateInternalRangeRequest.newBuilder()
            .setParent(parent)
            .setInternalRange(internalRange)
            .setInternalRangeId(internalRangeId)
            .build();
    return createInternalRangeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new internal range in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   CreateInternalRangeRequest request =
   *       CreateInternalRangeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInternalRangeId("internalRangeId-392750661")
   *           .setInternalRange(InternalRange.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   InternalRange response = internalRangeServiceClient.createInternalRangeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InternalRange, OperationMetadata> createInternalRangeAsync(
      CreateInternalRangeRequest request) {
    return createInternalRangeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new internal range in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   CreateInternalRangeRequest request =
   *       CreateInternalRangeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInternalRangeId("internalRangeId-392750661")
   *           .setInternalRange(InternalRange.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<InternalRange, OperationMetadata> future =
   *       internalRangeServiceClient.createInternalRangeOperationCallable().futureCall(request);
   *   // Do something.
   *   InternalRange response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateInternalRangeRequest, InternalRange, OperationMetadata>
      createInternalRangeOperationCallable() {
    return stub.createInternalRangeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new internal range in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   CreateInternalRangeRequest request =
   *       CreateInternalRangeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInternalRangeId("internalRangeId-392750661")
   *           .setInternalRange(InternalRange.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       internalRangeServiceClient.createInternalRangeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateInternalRangeRequest, Operation> createInternalRangeCallable() {
    return stub.createInternalRangeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single internal range.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   InternalRange internalRange = InternalRange.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   InternalRange response =
   *       internalRangeServiceClient.updateInternalRangeAsync(internalRange, updateMask).get();
   * }
   * }</pre>
   *
   * @param internalRange Required. New values to be patched into the resource.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     InternalRange resource by the update. The fields specified in the update_mask are relative
   *     to the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InternalRange, OperationMetadata> updateInternalRangeAsync(
      InternalRange internalRange, FieldMask updateMask) {
    UpdateInternalRangeRequest request =
        UpdateInternalRangeRequest.newBuilder()
            .setInternalRange(internalRange)
            .setUpdateMask(updateMask)
            .build();
    return updateInternalRangeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single internal range.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   UpdateInternalRangeRequest request =
   *       UpdateInternalRangeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInternalRange(InternalRange.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   InternalRange response = internalRangeServiceClient.updateInternalRangeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InternalRange, OperationMetadata> updateInternalRangeAsync(
      UpdateInternalRangeRequest request) {
    return updateInternalRangeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single internal range.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   UpdateInternalRangeRequest request =
   *       UpdateInternalRangeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInternalRange(InternalRange.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<InternalRange, OperationMetadata> future =
   *       internalRangeServiceClient.updateInternalRangeOperationCallable().futureCall(request);
   *   // Do something.
   *   InternalRange response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateInternalRangeRequest, InternalRange, OperationMetadata>
      updateInternalRangeOperationCallable() {
    return stub.updateInternalRangeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single internal range.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   UpdateInternalRangeRequest request =
   *       UpdateInternalRangeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInternalRange(InternalRange.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       internalRangeServiceClient.updateInternalRangeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateInternalRangeRequest, Operation> updateInternalRangeCallable() {
    return stub.updateInternalRangeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single internal range.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   InternalRangeName name = InternalRangeName.of("[PROJECT]", "[LOCATION]", "[INTERNAL_RANGE]");
   *   internalRangeServiceClient.deleteInternalRangeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the internal range to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInternalRangeAsync(
      InternalRangeName name) {
    DeleteInternalRangeRequest request =
        DeleteInternalRangeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteInternalRangeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single internal range.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   String name = InternalRangeName.of("[PROJECT]", "[LOCATION]", "[INTERNAL_RANGE]").toString();
   *   internalRangeServiceClient.deleteInternalRangeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the internal range to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInternalRangeAsync(String name) {
    DeleteInternalRangeRequest request =
        DeleteInternalRangeRequest.newBuilder().setName(name).build();
    return deleteInternalRangeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single internal range.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   DeleteInternalRangeRequest request =
   *       DeleteInternalRangeRequest.newBuilder()
   *           .setName(
   *               InternalRangeName.of("[PROJECT]", "[LOCATION]", "[INTERNAL_RANGE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   internalRangeServiceClient.deleteInternalRangeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInternalRangeAsync(
      DeleteInternalRangeRequest request) {
    return deleteInternalRangeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single internal range.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   DeleteInternalRangeRequest request =
   *       DeleteInternalRangeRequest.newBuilder()
   *           .setName(
   *               InternalRangeName.of("[PROJECT]", "[LOCATION]", "[INTERNAL_RANGE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       internalRangeServiceClient.deleteInternalRangeOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteInternalRangeRequest, Empty, OperationMetadata>
      deleteInternalRangeOperationCallable() {
    return stub.deleteInternalRangeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single internal range.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   DeleteInternalRangeRequest request =
   *       DeleteInternalRangeRequest.newBuilder()
   *           .setName(
   *               InternalRangeName.of("[PROJECT]", "[LOCATION]", "[INTERNAL_RANGE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       internalRangeServiceClient.deleteInternalRangeCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteInternalRangeRequest, Operation> deleteInternalRangeCallable() {
    return stub.deleteInternalRangeCallable();
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
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : internalRangeServiceClient.listLocations(request).iterateAll()) {
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
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       internalRangeServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         internalRangeServiceClient.listLocationsCallable().call(request);
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
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = internalRangeServiceClient.getLocation(request);
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
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       internalRangeServiceClient.getLocationCallable().futureCall(request);
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
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = internalRangeServiceClient.setIamPolicy(request);
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
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       internalRangeServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = internalRangeServiceClient.getIamPolicy(request);
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
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       internalRangeServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = internalRangeServiceClient.testIamPermissions(request);
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
   * try (InternalRangeServiceClient internalRangeServiceClient =
   *     InternalRangeServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       internalRangeServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListInternalRangesPagedResponse
      extends AbstractPagedListResponse<
          ListInternalRangesRequest,
          ListInternalRangesResponse,
          InternalRange,
          ListInternalRangesPage,
          ListInternalRangesFixedSizeCollection> {

    public static ApiFuture<ListInternalRangesPagedResponse> createAsync(
        PageContext<ListInternalRangesRequest, ListInternalRangesResponse, InternalRange> context,
        ApiFuture<ListInternalRangesResponse> futureResponse) {
      ApiFuture<ListInternalRangesPage> futurePage =
          ListInternalRangesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListInternalRangesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListInternalRangesPagedResponse(ListInternalRangesPage page) {
      super(page, ListInternalRangesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInternalRangesPage
      extends AbstractPage<
          ListInternalRangesRequest,
          ListInternalRangesResponse,
          InternalRange,
          ListInternalRangesPage> {

    private ListInternalRangesPage(
        PageContext<ListInternalRangesRequest, ListInternalRangesResponse, InternalRange> context,
        ListInternalRangesResponse response) {
      super(context, response);
    }

    private static ListInternalRangesPage createEmptyPage() {
      return new ListInternalRangesPage(null, null);
    }

    @Override
    protected ListInternalRangesPage createPage(
        PageContext<ListInternalRangesRequest, ListInternalRangesResponse, InternalRange> context,
        ListInternalRangesResponse response) {
      return new ListInternalRangesPage(context, response);
    }

    @Override
    public ApiFuture<ListInternalRangesPage> createPageAsync(
        PageContext<ListInternalRangesRequest, ListInternalRangesResponse, InternalRange> context,
        ApiFuture<ListInternalRangesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInternalRangesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInternalRangesRequest,
          ListInternalRangesResponse,
          InternalRange,
          ListInternalRangesPage,
          ListInternalRangesFixedSizeCollection> {

    private ListInternalRangesFixedSizeCollection(
        List<ListInternalRangesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInternalRangesFixedSizeCollection createEmptyCollection() {
      return new ListInternalRangesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInternalRangesFixedSizeCollection createCollection(
        List<ListInternalRangesPage> pages, int collectionSize) {
      return new ListInternalRangesFixedSizeCollection(pages, collectionSize);
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
