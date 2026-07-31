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

package com.google.cloud.networksecurity.v1;

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
import com.google.cloud.networksecurity.v1.stub.SSERealmServiceStub;
import com.google.cloud.networksecurity.v1.stub.SSERealmServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service describing handlers for resources
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
 * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
 *   SACRealmName name = SACRealmName.of("[PROJECT]", "[LOCATION]", "[SAC_REALM]");
 *   SACRealm response = sSERealmServiceClient.getSACRealm(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SSERealmServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListSACRealms</td>
 *      <td><p> Lists SACRealms in a given project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSACRealms(ListSACRealmsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSACRealms(LocationName parent)
 *           <li><p> listSACRealms(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSACRealmsPagedCallable()
 *           <li><p> listSACRealmsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSACRealm</td>
 *      <td><p> Returns the specified realm.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSACRealm(GetSACRealmRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSACRealm(SACRealmName name)
 *           <li><p> getSACRealm(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSACRealmCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSACRealm</td>
 *      <td><p> Creates a new SACRealm in a given project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSACRealmAsync(CreateSACRealmRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createSACRealmAsync(LocationName parent, SACRealm sacRealm, String sacRealmId)
 *           <li><p> createSACRealmAsync(String parent, SACRealm sacRealm, String sacRealmId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSACRealmOperationCallable()
 *           <li><p> createSACRealmCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSACRealm</td>
 *      <td><p> Deletes the specified realm.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSACRealmAsync(DeleteSACRealmRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteSACRealmAsync(SACRealmName name)
 *           <li><p> deleteSACRealmAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSACRealmOperationCallable()
 *           <li><p> deleteSACRealmCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSACAttachments</td>
 *      <td><p> Lists SACAttachments in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSACAttachments(ListSACAttachmentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSACAttachments(LocationName parent)
 *           <li><p> listSACAttachments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSACAttachmentsPagedCallable()
 *           <li><p> listSACAttachmentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSACAttachment</td>
 *      <td><p> Returns the specified attachment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSACAttachment(GetSACAttachmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSACAttachment(SACAttachmentName name)
 *           <li><p> getSACAttachment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSACAttachmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSACAttachment</td>
 *      <td><p> Creates a new SACAttachment in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSACAttachmentAsync(CreateSACAttachmentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createSACAttachmentAsync(LocationName parent, SACAttachment sacAttachment, String sacAttachmentId)
 *           <li><p> createSACAttachmentAsync(String parent, SACAttachment sacAttachment, String sacAttachmentId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSACAttachmentOperationCallable()
 *           <li><p> createSACAttachmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSACAttachment</td>
 *      <td><p> Deletes the specified attachment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSACAttachmentAsync(DeleteSACAttachmentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteSACAttachmentAsync(SACAttachmentName name)
 *           <li><p> deleteSACAttachmentAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSACAttachmentOperationCallable()
 *           <li><p> deleteSACAttachmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.
 * <p> This method lists locations based on the resource scope provided inthe [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field: &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If `name` follows the format`projects/{project}`, the method lists locations visible to thatspecific project. This includes public, private, or otherproject-specific locations enabled for the project.
 * <p> For gRPC and client library implementations, the resource name ispassed as the `name` field. For direct service calls, the resourcename isincorporated into the request path based on the specific serviceimplementation and version.</td>
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
 * <p>This class can be customized by passing in a custom instance of SSERealmServiceSettings to
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
 * SSERealmServiceSettings sSERealmServiceSettings =
 *     SSERealmServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SSERealmServiceClient sSERealmServiceClient =
 *     SSERealmServiceClient.create(sSERealmServiceSettings);
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
 * SSERealmServiceSettings sSERealmServiceSettings =
 *     SSERealmServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SSERealmServiceClient sSERealmServiceClient =
 *     SSERealmServiceClient.create(sSERealmServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class SSERealmServiceClient implements BackgroundResource {
  private final @Nullable SSERealmServiceSettings settings;
  private final SSERealmServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of SSERealmServiceClient with default settings. */
  public static final SSERealmServiceClient create() throws IOException {
    return create(SSERealmServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SSERealmServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SSERealmServiceClient create(SSERealmServiceSettings settings)
      throws IOException {
    return new SSERealmServiceClient(settings);
  }

  /**
   * Constructs an instance of SSERealmServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(SSERealmServiceSettings).
   */
  public static final SSERealmServiceClient create(SSERealmServiceStub stub) {
    return new SSERealmServiceClient(stub);
  }

  /**
   * Constructs an instance of SSERealmServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SSERealmServiceClient(SSERealmServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SSERealmServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected SSERealmServiceClient(SSERealmServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final @Nullable SSERealmServiceSettings getSettings() {
    return settings;
  }

  public SSERealmServiceStub getStub() {
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
   * Lists SACRealms in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (SACRealm element : sSERealmServiceClient.listSACRealms(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, in the form `projects/{project}/locations/global`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSACRealmsPagedResponse listSACRealms(@Nullable LocationName parent) {
    ListSACRealmsRequest request =
        ListSACRealmsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSACRealms(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SACRealms in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (SACRealm element : sSERealmServiceClient.listSACRealms(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, in the form `projects/{project}/locations/global`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSACRealmsPagedResponse listSACRealms(String parent) {
    ListSACRealmsRequest request = ListSACRealmsRequest.newBuilder().setParent(parent).build();
    return listSACRealms(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SACRealms in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   ListSACRealmsRequest request =
   *       ListSACRealmsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (SACRealm element : sSERealmServiceClient.listSACRealms(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSACRealmsPagedResponse listSACRealms(ListSACRealmsRequest request) {
    return listSACRealmsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SACRealms in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   ListSACRealmsRequest request =
   *       ListSACRealmsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<SACRealm> future =
   *       sSERealmServiceClient.listSACRealmsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SACRealm element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSACRealmsRequest, ListSACRealmsPagedResponse>
      listSACRealmsPagedCallable() {
    return stub.listSACRealmsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SACRealms in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   ListSACRealmsRequest request =
   *       ListSACRealmsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListSACRealmsResponse response =
   *         sSERealmServiceClient.listSACRealmsCallable().call(request);
   *     for (SACRealm element : response.getSacRealmsList()) {
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
  public final UnaryCallable<ListSACRealmsRequest, ListSACRealmsResponse> listSACRealmsCallable() {
    return stub.listSACRealmsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified realm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   SACRealmName name = SACRealmName.of("[PROJECT]", "[LOCATION]", "[SAC_REALM]");
   *   SACRealm response = sSERealmServiceClient.getSACRealm(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource, in the form
   *     `projects/{project}/locations/global/sacRealms/{sacRealm}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SACRealm getSACRealm(@Nullable SACRealmName name) {
    GetSACRealmRequest request =
        GetSACRealmRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSACRealm(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified realm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   String name = SACRealmName.of("[PROJECT]", "[LOCATION]", "[SAC_REALM]").toString();
   *   SACRealm response = sSERealmServiceClient.getSACRealm(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource, in the form
   *     `projects/{project}/locations/global/sacRealms/{sacRealm}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SACRealm getSACRealm(String name) {
    GetSACRealmRequest request = GetSACRealmRequest.newBuilder().setName(name).build();
    return getSACRealm(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified realm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   GetSACRealmRequest request =
   *       GetSACRealmRequest.newBuilder()
   *           .setName(SACRealmName.of("[PROJECT]", "[LOCATION]", "[SAC_REALM]").toString())
   *           .build();
   *   SACRealm response = sSERealmServiceClient.getSACRealm(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SACRealm getSACRealm(GetSACRealmRequest request) {
    return getSACRealmCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified realm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   GetSACRealmRequest request =
   *       GetSACRealmRequest.newBuilder()
   *           .setName(SACRealmName.of("[PROJECT]", "[LOCATION]", "[SAC_REALM]").toString())
   *           .build();
   *   ApiFuture<SACRealm> future = sSERealmServiceClient.getSACRealmCallable().futureCall(request);
   *   // Do something.
   *   SACRealm response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSACRealmRequest, SACRealm> getSACRealmCallable() {
    return stub.getSACRealmCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new SACRealm in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   SACRealm sacRealm = SACRealm.newBuilder().build();
   *   String sacRealmId = "sacRealmId-1163768203";
   *   SACRealm response =
   *       sSERealmServiceClient.createSACRealmAsync(parent, sacRealm, sacRealmId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent, in the form `projects/{project}/locations/global`.
   * @param sacRealm Required. The resource being created.
   * @param sacRealmId Required. ID of the created realm. The ID must be 1-63 characters long, and
   *     comply with &lt;a href="https://www.ietf.org/rfc/rfc1035.txt"
   *     target="_blank"&gt;RFC1035&lt;/a&gt;. Specifically, it must be 1-63 characters long and
   *     match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
   *     character must be a lowercase letter, and all following characters must be a dash,
   *     lowercase letter, or digit, except the last character, which cannot be a dash.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SACRealm, OperationMetadata> createSACRealmAsync(
      @Nullable LocationName parent, SACRealm sacRealm, String sacRealmId) {
    CreateSACRealmRequest request =
        CreateSACRealmRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSacRealm(sacRealm)
            .setSacRealmId(sacRealmId)
            .build();
    return createSACRealmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new SACRealm in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   SACRealm sacRealm = SACRealm.newBuilder().build();
   *   String sacRealmId = "sacRealmId-1163768203";
   *   SACRealm response =
   *       sSERealmServiceClient.createSACRealmAsync(parent, sacRealm, sacRealmId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent, in the form `projects/{project}/locations/global`.
   * @param sacRealm Required. The resource being created.
   * @param sacRealmId Required. ID of the created realm. The ID must be 1-63 characters long, and
   *     comply with &lt;a href="https://www.ietf.org/rfc/rfc1035.txt"
   *     target="_blank"&gt;RFC1035&lt;/a&gt;. Specifically, it must be 1-63 characters long and
   *     match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
   *     character must be a lowercase letter, and all following characters must be a dash,
   *     lowercase letter, or digit, except the last character, which cannot be a dash.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SACRealm, OperationMetadata> createSACRealmAsync(
      String parent, SACRealm sacRealm, String sacRealmId) {
    CreateSACRealmRequest request =
        CreateSACRealmRequest.newBuilder()
            .setParent(parent)
            .setSacRealm(sacRealm)
            .setSacRealmId(sacRealmId)
            .build();
    return createSACRealmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new SACRealm in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   CreateSACRealmRequest request =
   *       CreateSACRealmRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSacRealmId("sacRealmId-1163768203")
   *           .setSacRealm(SACRealm.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   SACRealm response = sSERealmServiceClient.createSACRealmAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SACRealm, OperationMetadata> createSACRealmAsync(
      CreateSACRealmRequest request) {
    return createSACRealmOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new SACRealm in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   CreateSACRealmRequest request =
   *       CreateSACRealmRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSacRealmId("sacRealmId-1163768203")
   *           .setSacRealm(SACRealm.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<SACRealm, OperationMetadata> future =
   *       sSERealmServiceClient.createSACRealmOperationCallable().futureCall(request);
   *   // Do something.
   *   SACRealm response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateSACRealmRequest, SACRealm, OperationMetadata>
      createSACRealmOperationCallable() {
    return stub.createSACRealmOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new SACRealm in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   CreateSACRealmRequest request =
   *       CreateSACRealmRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSacRealmId("sacRealmId-1163768203")
   *           .setSacRealm(SACRealm.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       sSERealmServiceClient.createSACRealmCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSACRealmRequest, Operation> createSACRealmCallable() {
    return stub.createSACRealmCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified realm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   SACRealmName name = SACRealmName.of("[PROJECT]", "[LOCATION]", "[SAC_REALM]");
   *   sSERealmServiceClient.deleteSACRealmAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource, in the form
   *     `projects/{project}/locations/global/sacRealms/{sacRealm}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSACRealmAsync(
      @Nullable SACRealmName name) {
    DeleteSACRealmRequest request =
        DeleteSACRealmRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteSACRealmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified realm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   String name = SACRealmName.of("[PROJECT]", "[LOCATION]", "[SAC_REALM]").toString();
   *   sSERealmServiceClient.deleteSACRealmAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource, in the form
   *     `projects/{project}/locations/global/sacRealms/{sacRealm}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSACRealmAsync(String name) {
    DeleteSACRealmRequest request = DeleteSACRealmRequest.newBuilder().setName(name).build();
    return deleteSACRealmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified realm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   DeleteSACRealmRequest request =
   *       DeleteSACRealmRequest.newBuilder()
   *           .setName(SACRealmName.of("[PROJECT]", "[LOCATION]", "[SAC_REALM]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   sSERealmServiceClient.deleteSACRealmAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSACRealmAsync(
      DeleteSACRealmRequest request) {
    return deleteSACRealmOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified realm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   DeleteSACRealmRequest request =
   *       DeleteSACRealmRequest.newBuilder()
   *           .setName(SACRealmName.of("[PROJECT]", "[LOCATION]", "[SAC_REALM]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       sSERealmServiceClient.deleteSACRealmOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteSACRealmRequest, Empty, OperationMetadata>
      deleteSACRealmOperationCallable() {
    return stub.deleteSACRealmOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified realm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   DeleteSACRealmRequest request =
   *       DeleteSACRealmRequest.newBuilder()
   *           .setName(SACRealmName.of("[PROJECT]", "[LOCATION]", "[SAC_REALM]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       sSERealmServiceClient.deleteSACRealmCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSACRealmRequest, Operation> deleteSACRealmCallable() {
    return stub.deleteSACRealmCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SACAttachments in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (SACAttachment element : sSERealmServiceClient.listSACAttachments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, in the form `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSACAttachmentsPagedResponse listSACAttachments(@Nullable LocationName parent) {
    ListSACAttachmentsRequest request =
        ListSACAttachmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSACAttachments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SACAttachments in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (SACAttachment element : sSERealmServiceClient.listSACAttachments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, in the form `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSACAttachmentsPagedResponse listSACAttachments(String parent) {
    ListSACAttachmentsRequest request =
        ListSACAttachmentsRequest.newBuilder().setParent(parent).build();
    return listSACAttachments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SACAttachments in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   ListSACAttachmentsRequest request =
   *       ListSACAttachmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (SACAttachment element : sSERealmServiceClient.listSACAttachments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSACAttachmentsPagedResponse listSACAttachments(
      ListSACAttachmentsRequest request) {
    return listSACAttachmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SACAttachments in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   ListSACAttachmentsRequest request =
   *       ListSACAttachmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<SACAttachment> future =
   *       sSERealmServiceClient.listSACAttachmentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SACAttachment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSACAttachmentsRequest, ListSACAttachmentsPagedResponse>
      listSACAttachmentsPagedCallable() {
    return stub.listSACAttachmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SACAttachments in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   ListSACAttachmentsRequest request =
   *       ListSACAttachmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListSACAttachmentsResponse response =
   *         sSERealmServiceClient.listSACAttachmentsCallable().call(request);
   *     for (SACAttachment element : response.getSacAttachmentsList()) {
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
  public final UnaryCallable<ListSACAttachmentsRequest, ListSACAttachmentsResponse>
      listSACAttachmentsCallable() {
    return stub.listSACAttachmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   SACAttachmentName name = SACAttachmentName.of("[PROJECT]", "[LOCATION]", "[SAC_ATTACHMENT]");
   *   SACAttachment response = sSERealmServiceClient.getSACAttachment(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource, in the form
   *     `projects/{project}/locations/{location}/sacAttachments/{sac_attachment}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SACAttachment getSACAttachment(@Nullable SACAttachmentName name) {
    GetSACAttachmentRequest request =
        GetSACAttachmentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSACAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   String name = SACAttachmentName.of("[PROJECT]", "[LOCATION]", "[SAC_ATTACHMENT]").toString();
   *   SACAttachment response = sSERealmServiceClient.getSACAttachment(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource, in the form
   *     `projects/{project}/locations/{location}/sacAttachments/{sac_attachment}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SACAttachment getSACAttachment(String name) {
    GetSACAttachmentRequest request = GetSACAttachmentRequest.newBuilder().setName(name).build();
    return getSACAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   GetSACAttachmentRequest request =
   *       GetSACAttachmentRequest.newBuilder()
   *           .setName(
   *               SACAttachmentName.of("[PROJECT]", "[LOCATION]", "[SAC_ATTACHMENT]").toString())
   *           .build();
   *   SACAttachment response = sSERealmServiceClient.getSACAttachment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SACAttachment getSACAttachment(GetSACAttachmentRequest request) {
    return getSACAttachmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   GetSACAttachmentRequest request =
   *       GetSACAttachmentRequest.newBuilder()
   *           .setName(
   *               SACAttachmentName.of("[PROJECT]", "[LOCATION]", "[SAC_ATTACHMENT]").toString())
   *           .build();
   *   ApiFuture<SACAttachment> future =
   *       sSERealmServiceClient.getSACAttachmentCallable().futureCall(request);
   *   // Do something.
   *   SACAttachment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSACAttachmentRequest, SACAttachment> getSACAttachmentCallable() {
    return stub.getSACAttachmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new SACAttachment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   SACAttachment sacAttachment = SACAttachment.newBuilder().build();
   *   String sacAttachmentId = "sacAttachmentId-476668397";
   *   SACAttachment response =
   *       sSERealmServiceClient
   *           .createSACAttachmentAsync(parent, sacAttachment, sacAttachmentId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent, in the form `projects/{project}/locations/{location}`.
   * @param sacAttachment Required. The resource being created.
   * @param sacAttachmentId Required. ID of the created attachment. The ID must be 1-63 characters
   *     long, and comply with &lt;a href="https://www.ietf.org/rfc/rfc1035.txt"
   *     target="_blank"&gt;RFC1035&lt;/a&gt;. Specifically, it must be 1-63 characters long and
   *     match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
   *     character must be a lowercase letter, and all following characters must be a dash,
   *     lowercase letter, or digit, except the last character, which cannot be a dash.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SACAttachment, OperationMetadata> createSACAttachmentAsync(
      @Nullable LocationName parent, SACAttachment sacAttachment, String sacAttachmentId) {
    CreateSACAttachmentRequest request =
        CreateSACAttachmentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSacAttachment(sacAttachment)
            .setSacAttachmentId(sacAttachmentId)
            .build();
    return createSACAttachmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new SACAttachment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   SACAttachment sacAttachment = SACAttachment.newBuilder().build();
   *   String sacAttachmentId = "sacAttachmentId-476668397";
   *   SACAttachment response =
   *       sSERealmServiceClient
   *           .createSACAttachmentAsync(parent, sacAttachment, sacAttachmentId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent, in the form `projects/{project}/locations/{location}`.
   * @param sacAttachment Required. The resource being created.
   * @param sacAttachmentId Required. ID of the created attachment. The ID must be 1-63 characters
   *     long, and comply with &lt;a href="https://www.ietf.org/rfc/rfc1035.txt"
   *     target="_blank"&gt;RFC1035&lt;/a&gt;. Specifically, it must be 1-63 characters long and
   *     match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
   *     character must be a lowercase letter, and all following characters must be a dash,
   *     lowercase letter, or digit, except the last character, which cannot be a dash.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SACAttachment, OperationMetadata> createSACAttachmentAsync(
      String parent, SACAttachment sacAttachment, String sacAttachmentId) {
    CreateSACAttachmentRequest request =
        CreateSACAttachmentRequest.newBuilder()
            .setParent(parent)
            .setSacAttachment(sacAttachment)
            .setSacAttachmentId(sacAttachmentId)
            .build();
    return createSACAttachmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new SACAttachment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   CreateSACAttachmentRequest request =
   *       CreateSACAttachmentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSacAttachmentId("sacAttachmentId-476668397")
   *           .setSacAttachment(SACAttachment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   SACAttachment response = sSERealmServiceClient.createSACAttachmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SACAttachment, OperationMetadata> createSACAttachmentAsync(
      CreateSACAttachmentRequest request) {
    return createSACAttachmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new SACAttachment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   CreateSACAttachmentRequest request =
   *       CreateSACAttachmentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSacAttachmentId("sacAttachmentId-476668397")
   *           .setSacAttachment(SACAttachment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<SACAttachment, OperationMetadata> future =
   *       sSERealmServiceClient.createSACAttachmentOperationCallable().futureCall(request);
   *   // Do something.
   *   SACAttachment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateSACAttachmentRequest, SACAttachment, OperationMetadata>
      createSACAttachmentOperationCallable() {
    return stub.createSACAttachmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new SACAttachment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   CreateSACAttachmentRequest request =
   *       CreateSACAttachmentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSacAttachmentId("sacAttachmentId-476668397")
   *           .setSacAttachment(SACAttachment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       sSERealmServiceClient.createSACAttachmentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSACAttachmentRequest, Operation> createSACAttachmentCallable() {
    return stub.createSACAttachmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   SACAttachmentName name = SACAttachmentName.of("[PROJECT]", "[LOCATION]", "[SAC_ATTACHMENT]");
   *   sSERealmServiceClient.deleteSACAttachmentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource, in the form
   *     `projects/{project}/locations/{location}/sacAttachments/{sac_attachment}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSACAttachmentAsync(
      @Nullable SACAttachmentName name) {
    DeleteSACAttachmentRequest request =
        DeleteSACAttachmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteSACAttachmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   String name = SACAttachmentName.of("[PROJECT]", "[LOCATION]", "[SAC_ATTACHMENT]").toString();
   *   sSERealmServiceClient.deleteSACAttachmentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource, in the form
   *     `projects/{project}/locations/{location}/sacAttachments/{sac_attachment}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSACAttachmentAsync(String name) {
    DeleteSACAttachmentRequest request =
        DeleteSACAttachmentRequest.newBuilder().setName(name).build();
    return deleteSACAttachmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   DeleteSACAttachmentRequest request =
   *       DeleteSACAttachmentRequest.newBuilder()
   *           .setName(
   *               SACAttachmentName.of("[PROJECT]", "[LOCATION]", "[SAC_ATTACHMENT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   sSERealmServiceClient.deleteSACAttachmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSACAttachmentAsync(
      DeleteSACAttachmentRequest request) {
    return deleteSACAttachmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   DeleteSACAttachmentRequest request =
   *       DeleteSACAttachmentRequest.newBuilder()
   *           .setName(
   *               SACAttachmentName.of("[PROJECT]", "[LOCATION]", "[SAC_ATTACHMENT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       sSERealmServiceClient.deleteSACAttachmentOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteSACAttachmentRequest, Empty, OperationMetadata>
      deleteSACAttachmentOperationCallable() {
    return stub.deleteSACAttachmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   DeleteSACAttachmentRequest request =
   *       DeleteSACAttachmentRequest.newBuilder()
   *           .setName(
   *               SACAttachmentName.of("[PROJECT]", "[LOCATION]", "[SAC_ATTACHMENT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       sSERealmServiceClient.deleteSACAttachmentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSACAttachmentRequest, Operation> deleteSACAttachmentCallable() {
    return stub.deleteSACAttachmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : sSERealmServiceClient.listLocations(request).iterateAll()) {
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
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       sSERealmServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         sSERealmServiceClient.listLocationsCallable().call(request);
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
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = sSERealmServiceClient.getLocation(request);
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
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = sSERealmServiceClient.getLocationCallable().futureCall(request);
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
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = sSERealmServiceClient.setIamPolicy(request);
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
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = sSERealmServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = sSERealmServiceClient.getIamPolicy(request);
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
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = sSERealmServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = sSERealmServiceClient.testIamPermissions(request);
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
   * try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       sSERealmServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListSACRealmsPagedResponse
      extends AbstractPagedListResponse<
          ListSACRealmsRequest,
          ListSACRealmsResponse,
          SACRealm,
          ListSACRealmsPage,
          ListSACRealmsFixedSizeCollection> {

    public static ApiFuture<ListSACRealmsPagedResponse> createAsync(
        PageContext<ListSACRealmsRequest, ListSACRealmsResponse, SACRealm> context,
        ApiFuture<ListSACRealmsResponse> futureResponse) {
      ApiFuture<ListSACRealmsPage> futurePage =
          ListSACRealmsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSACRealmsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSACRealmsPagedResponse(ListSACRealmsPage page) {
      super(page, ListSACRealmsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSACRealmsPage
      extends AbstractPage<
          ListSACRealmsRequest, ListSACRealmsResponse, SACRealm, ListSACRealmsPage> {

    private ListSACRealmsPage(
        @Nullable PageContext<ListSACRealmsRequest, ListSACRealmsResponse, SACRealm> context,
        @Nullable ListSACRealmsResponse response) {
      super(context, response);
    }

    private static ListSACRealmsPage createEmptyPage() {
      return new ListSACRealmsPage(null, null);
    }

    @Override
    protected ListSACRealmsPage createPage(
        @Nullable PageContext<ListSACRealmsRequest, ListSACRealmsResponse, SACRealm> context,
        @Nullable ListSACRealmsResponse response) {
      return new ListSACRealmsPage(context, response);
    }

    @Override
    public ApiFuture<ListSACRealmsPage> createPageAsync(
        @Nullable PageContext<ListSACRealmsRequest, ListSACRealmsResponse, SACRealm> context,
        ApiFuture<ListSACRealmsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSACRealmsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSACRealmsRequest,
          ListSACRealmsResponse,
          SACRealm,
          ListSACRealmsPage,
          ListSACRealmsFixedSizeCollection> {

    private ListSACRealmsFixedSizeCollection(
        @Nullable List<ListSACRealmsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSACRealmsFixedSizeCollection createEmptyCollection() {
      return new ListSACRealmsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSACRealmsFixedSizeCollection createCollection(
        @Nullable List<ListSACRealmsPage> pages, int collectionSize) {
      return new ListSACRealmsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSACAttachmentsPagedResponse
      extends AbstractPagedListResponse<
          ListSACAttachmentsRequest,
          ListSACAttachmentsResponse,
          SACAttachment,
          ListSACAttachmentsPage,
          ListSACAttachmentsFixedSizeCollection> {

    public static ApiFuture<ListSACAttachmentsPagedResponse> createAsync(
        PageContext<ListSACAttachmentsRequest, ListSACAttachmentsResponse, SACAttachment> context,
        ApiFuture<ListSACAttachmentsResponse> futureResponse) {
      ApiFuture<ListSACAttachmentsPage> futurePage =
          ListSACAttachmentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSACAttachmentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSACAttachmentsPagedResponse(ListSACAttachmentsPage page) {
      super(page, ListSACAttachmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSACAttachmentsPage
      extends AbstractPage<
          ListSACAttachmentsRequest,
          ListSACAttachmentsResponse,
          SACAttachment,
          ListSACAttachmentsPage> {

    private ListSACAttachmentsPage(
        @Nullable PageContext<ListSACAttachmentsRequest, ListSACAttachmentsResponse, SACAttachment>
            context,
        @Nullable ListSACAttachmentsResponse response) {
      super(context, response);
    }

    private static ListSACAttachmentsPage createEmptyPage() {
      return new ListSACAttachmentsPage(null, null);
    }

    @Override
    protected ListSACAttachmentsPage createPage(
        @Nullable PageContext<ListSACAttachmentsRequest, ListSACAttachmentsResponse, SACAttachment>
            context,
        @Nullable ListSACAttachmentsResponse response) {
      return new ListSACAttachmentsPage(context, response);
    }

    @Override
    public ApiFuture<ListSACAttachmentsPage> createPageAsync(
        @Nullable PageContext<ListSACAttachmentsRequest, ListSACAttachmentsResponse, SACAttachment>
            context,
        ApiFuture<ListSACAttachmentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSACAttachmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSACAttachmentsRequest,
          ListSACAttachmentsResponse,
          SACAttachment,
          ListSACAttachmentsPage,
          ListSACAttachmentsFixedSizeCollection> {

    private ListSACAttachmentsFixedSizeCollection(
        @Nullable List<ListSACAttachmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSACAttachmentsFixedSizeCollection createEmptyCollection() {
      return new ListSACAttachmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSACAttachmentsFixedSizeCollection createCollection(
        @Nullable List<ListSACAttachmentsPage> pages, int collectionSize) {
      return new ListSACAttachmentsFixedSizeCollection(pages, collectionSize);
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
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
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

    private ListLocationsFixedSizeCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
