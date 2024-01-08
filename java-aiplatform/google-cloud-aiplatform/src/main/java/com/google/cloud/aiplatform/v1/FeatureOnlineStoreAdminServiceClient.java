/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.aiplatform.v1;

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
import com.google.cloud.aiplatform.v1.stub.FeatureOnlineStoreAdminServiceStub;
import com.google.cloud.aiplatform.v1.stub.FeatureOnlineStoreAdminServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * Service Description: The service that handles CRUD and List for resources for FeatureOnlineStore.
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
 * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
 *     FeatureOnlineStoreAdminServiceClient.create()) {
 *   FeatureOnlineStoreName name =
 *       FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]");
 *   FeatureOnlineStore response =
 *       featureOnlineStoreAdminServiceClient.getFeatureOnlineStore(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the FeatureOnlineStoreAdminServiceClient object to clean
 * up resources such as threads. In the example above, try-with-resources is used, which
 * automatically calls close().
 *
 * <table>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    <tr>
 *      <td>CreateFeatureOnlineStore</td>
 *      <td><p> Creates a new FeatureOnlineStore in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createFeatureOnlineStoreAsync(CreateFeatureOnlineStoreRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>createFeatureOnlineStoreAsync(LocationName parent, FeatureOnlineStore featureOnlineStore, String featureOnlineStoreId)
 *           <li>createFeatureOnlineStoreAsync(String parent, FeatureOnlineStore featureOnlineStore, String featureOnlineStoreId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createFeatureOnlineStoreOperationCallable()
 *           <li>createFeatureOnlineStoreCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetFeatureOnlineStore</td>
 *      <td><p> Gets details of a single FeatureOnlineStore.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getFeatureOnlineStore(GetFeatureOnlineStoreRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getFeatureOnlineStore(FeatureOnlineStoreName name)
 *           <li>getFeatureOnlineStore(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getFeatureOnlineStoreCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListFeatureOnlineStores</td>
 *      <td><p> Lists FeatureOnlineStores in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listFeatureOnlineStores(ListFeatureOnlineStoresRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listFeatureOnlineStores(LocationName parent)
 *           <li>listFeatureOnlineStores(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listFeatureOnlineStoresPagedCallable()
 *           <li>listFeatureOnlineStoresCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateFeatureOnlineStore</td>
 *      <td><p> Updates the parameters of a single FeatureOnlineStore.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateFeatureOnlineStoreAsync(UpdateFeatureOnlineStoreRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>updateFeatureOnlineStoreAsync(FeatureOnlineStore featureOnlineStore, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateFeatureOnlineStoreOperationCallable()
 *           <li>updateFeatureOnlineStoreCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteFeatureOnlineStore</td>
 *      <td><p> Deletes a single FeatureOnlineStore. The FeatureOnlineStore must not contain any FeatureViews.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteFeatureOnlineStoreAsync(DeleteFeatureOnlineStoreRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>deleteFeatureOnlineStoreAsync(FeatureOnlineStoreName name, boolean force)
 *           <li>deleteFeatureOnlineStoreAsync(String name, boolean force)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteFeatureOnlineStoreOperationCallable()
 *           <li>deleteFeatureOnlineStoreCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateFeatureView</td>
 *      <td><p> Creates a new FeatureView in a given FeatureOnlineStore.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createFeatureViewAsync(CreateFeatureViewRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>createFeatureViewAsync(FeatureOnlineStoreName parent, FeatureView featureView, String featureViewId)
 *           <li>createFeatureViewAsync(String parent, FeatureView featureView, String featureViewId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createFeatureViewOperationCallable()
 *           <li>createFeatureViewCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetFeatureView</td>
 *      <td><p> Gets details of a single FeatureView.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getFeatureView(GetFeatureViewRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getFeatureView(FeatureViewName name)
 *           <li>getFeatureView(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getFeatureViewCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListFeatureViews</td>
 *      <td><p> Lists FeatureViews in a given FeatureOnlineStore.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listFeatureViews(ListFeatureViewsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listFeatureViews(FeatureOnlineStoreName parent)
 *           <li>listFeatureViews(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listFeatureViewsPagedCallable()
 *           <li>listFeatureViewsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateFeatureView</td>
 *      <td><p> Updates the parameters of a single FeatureView.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateFeatureViewAsync(UpdateFeatureViewRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>updateFeatureViewAsync(FeatureView featureView, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateFeatureViewOperationCallable()
 *           <li>updateFeatureViewCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteFeatureView</td>
 *      <td><p> Deletes a single FeatureView.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteFeatureViewAsync(DeleteFeatureViewRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>deleteFeatureViewAsync(FeatureViewName name)
 *           <li>deleteFeatureViewAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteFeatureViewOperationCallable()
 *           <li>deleteFeatureViewCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>SyncFeatureView</td>
 *      <td><p> Triggers on-demand sync for the FeatureView.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>syncFeatureView(SyncFeatureViewRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>syncFeatureView(FeatureViewName featureView)
 *           <li>syncFeatureView(String featureView)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>syncFeatureViewCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetFeatureViewSync</td>
 *      <td><p> Gets details of a single FeatureViewSync.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getFeatureViewSync(GetFeatureViewSyncRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getFeatureViewSync(FeatureViewSyncName name)
 *           <li>getFeatureViewSync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getFeatureViewSyncCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListFeatureViewSyncs</td>
 *      <td><p> Lists FeatureViewSyncs in a given FeatureView.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listFeatureViewSyncs(ListFeatureViewSyncsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listFeatureViewSyncs(FeatureViewName parent)
 *           <li>listFeatureViewSyncs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listFeatureViewSyncsPagedCallable()
 *           <li>listFeatureViewSyncsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listLocationsPagedCallable()
 *           <li>listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getLocationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>SetIamPolicy</td>
 *      <td><p> Sets the access control policy on the specified resource. Replacesany existing policy.
 * <p> Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a resource. Returns an empty policyif the resource exists and does not have a policy set.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>TestIamPermissions</td>
 *      <td><p> Returns permissions that a caller has on the specified resource. If theresource does not exist, this will return an empty set ofpermissions, not a `NOT_FOUND` error.
 * <p> Note: This operation is designed to be used for buildingpermission-aware UIs and command-line tools, not for authorizationchecking. This operation may "fail open" without warning.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>testIamPermissionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
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
 * FeatureOnlineStoreAdminServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FeatureOnlineStoreAdminServiceSettings featureOnlineStoreAdminServiceSettings =
 *     FeatureOnlineStoreAdminServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
 *     FeatureOnlineStoreAdminServiceClient.create(featureOnlineStoreAdminServiceSettings);
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
 * FeatureOnlineStoreAdminServiceSettings featureOnlineStoreAdminServiceSettings =
 *     FeatureOnlineStoreAdminServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
 *     FeatureOnlineStoreAdminServiceClient.create(featureOnlineStoreAdminServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class FeatureOnlineStoreAdminServiceClient implements BackgroundResource {
  private final FeatureOnlineStoreAdminServiceSettings settings;
  private final FeatureOnlineStoreAdminServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of FeatureOnlineStoreAdminServiceClient with default settings. */
  public static final FeatureOnlineStoreAdminServiceClient create() throws IOException {
    return create(FeatureOnlineStoreAdminServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of FeatureOnlineStoreAdminServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final FeatureOnlineStoreAdminServiceClient create(
      FeatureOnlineStoreAdminServiceSettings settings) throws IOException {
    return new FeatureOnlineStoreAdminServiceClient(settings);
  }

  /**
   * Constructs an instance of FeatureOnlineStoreAdminServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using
   * create(FeatureOnlineStoreAdminServiceSettings).
   */
  public static final FeatureOnlineStoreAdminServiceClient create(
      FeatureOnlineStoreAdminServiceStub stub) {
    return new FeatureOnlineStoreAdminServiceClient(stub);
  }

  /**
   * Constructs an instance of FeatureOnlineStoreAdminServiceClient, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected FeatureOnlineStoreAdminServiceClient(FeatureOnlineStoreAdminServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((FeatureOnlineStoreAdminServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected FeatureOnlineStoreAdminServiceClient(FeatureOnlineStoreAdminServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final FeatureOnlineStoreAdminServiceSettings getSettings() {
    return settings;
  }

  public FeatureOnlineStoreAdminServiceStub getStub() {
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
   * Creates a new FeatureOnlineStore in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   FeatureOnlineStore featureOnlineStore = FeatureOnlineStore.newBuilder().build();
   *   String featureOnlineStoreId = "featureOnlineStoreId1046065331";
   *   FeatureOnlineStore response =
   *       featureOnlineStoreAdminServiceClient
   *           .createFeatureOnlineStoreAsync(parent, featureOnlineStore, featureOnlineStoreId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create FeatureOnlineStores.
   *     Format: `projects/{project}/locations/{location}'`
   * @param featureOnlineStore Required. The FeatureOnlineStore to create.
   * @param featureOnlineStoreId Required. The ID to use for this FeatureOnlineStore, which will
   *     become the final component of the FeatureOnlineStore's resource name.
   *     <p>This value may be up to 60 characters, and valid characters are `[a-z0-9_]`. The first
   *     character cannot be a number.
   *     <p>The value must be unique within the project and location.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FeatureOnlineStore, CreateFeatureOnlineStoreOperationMetadata>
      createFeatureOnlineStoreAsync(
          LocationName parent, FeatureOnlineStore featureOnlineStore, String featureOnlineStoreId) {
    CreateFeatureOnlineStoreRequest request =
        CreateFeatureOnlineStoreRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFeatureOnlineStore(featureOnlineStore)
            .setFeatureOnlineStoreId(featureOnlineStoreId)
            .build();
    return createFeatureOnlineStoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FeatureOnlineStore in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   FeatureOnlineStore featureOnlineStore = FeatureOnlineStore.newBuilder().build();
   *   String featureOnlineStoreId = "featureOnlineStoreId1046065331";
   *   FeatureOnlineStore response =
   *       featureOnlineStoreAdminServiceClient
   *           .createFeatureOnlineStoreAsync(parent, featureOnlineStore, featureOnlineStoreId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create FeatureOnlineStores.
   *     Format: `projects/{project}/locations/{location}'`
   * @param featureOnlineStore Required. The FeatureOnlineStore to create.
   * @param featureOnlineStoreId Required. The ID to use for this FeatureOnlineStore, which will
   *     become the final component of the FeatureOnlineStore's resource name.
   *     <p>This value may be up to 60 characters, and valid characters are `[a-z0-9_]`. The first
   *     character cannot be a number.
   *     <p>The value must be unique within the project and location.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FeatureOnlineStore, CreateFeatureOnlineStoreOperationMetadata>
      createFeatureOnlineStoreAsync(
          String parent, FeatureOnlineStore featureOnlineStore, String featureOnlineStoreId) {
    CreateFeatureOnlineStoreRequest request =
        CreateFeatureOnlineStoreRequest.newBuilder()
            .setParent(parent)
            .setFeatureOnlineStore(featureOnlineStore)
            .setFeatureOnlineStoreId(featureOnlineStoreId)
            .build();
    return createFeatureOnlineStoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FeatureOnlineStore in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   CreateFeatureOnlineStoreRequest request =
   *       CreateFeatureOnlineStoreRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFeatureOnlineStore(FeatureOnlineStore.newBuilder().build())
   *           .setFeatureOnlineStoreId("featureOnlineStoreId1046065331")
   *           .build();
   *   FeatureOnlineStore response =
   *       featureOnlineStoreAdminServiceClient.createFeatureOnlineStoreAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FeatureOnlineStore, CreateFeatureOnlineStoreOperationMetadata>
      createFeatureOnlineStoreAsync(CreateFeatureOnlineStoreRequest request) {
    return createFeatureOnlineStoreOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FeatureOnlineStore in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   CreateFeatureOnlineStoreRequest request =
   *       CreateFeatureOnlineStoreRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFeatureOnlineStore(FeatureOnlineStore.newBuilder().build())
   *           .setFeatureOnlineStoreId("featureOnlineStoreId1046065331")
   *           .build();
   *   OperationFuture<FeatureOnlineStore, CreateFeatureOnlineStoreOperationMetadata> future =
   *       featureOnlineStoreAdminServiceClient
   *           .createFeatureOnlineStoreOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   FeatureOnlineStore response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateFeatureOnlineStoreRequest,
          FeatureOnlineStore,
          CreateFeatureOnlineStoreOperationMetadata>
      createFeatureOnlineStoreOperationCallable() {
    return stub.createFeatureOnlineStoreOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FeatureOnlineStore in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   CreateFeatureOnlineStoreRequest request =
   *       CreateFeatureOnlineStoreRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFeatureOnlineStore(FeatureOnlineStore.newBuilder().build())
   *           .setFeatureOnlineStoreId("featureOnlineStoreId1046065331")
   *           .build();
   *   ApiFuture<Operation> future =
   *       featureOnlineStoreAdminServiceClient
   *           .createFeatureOnlineStoreCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateFeatureOnlineStoreRequest, Operation>
      createFeatureOnlineStoreCallable() {
    return stub.createFeatureOnlineStoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single FeatureOnlineStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   FeatureOnlineStoreName name =
   *       FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]");
   *   FeatureOnlineStore response =
   *       featureOnlineStoreAdminServiceClient.getFeatureOnlineStore(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the FeatureOnlineStore resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeatureOnlineStore getFeatureOnlineStore(FeatureOnlineStoreName name) {
    GetFeatureOnlineStoreRequest request =
        GetFeatureOnlineStoreRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getFeatureOnlineStore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single FeatureOnlineStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   String name =
   *       FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]").toString();
   *   FeatureOnlineStore response =
   *       featureOnlineStoreAdminServiceClient.getFeatureOnlineStore(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the FeatureOnlineStore resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeatureOnlineStore getFeatureOnlineStore(String name) {
    GetFeatureOnlineStoreRequest request =
        GetFeatureOnlineStoreRequest.newBuilder().setName(name).build();
    return getFeatureOnlineStore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single FeatureOnlineStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   GetFeatureOnlineStoreRequest request =
   *       GetFeatureOnlineStoreRequest.newBuilder()
   *           .setName(
   *               FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]")
   *                   .toString())
   *           .build();
   *   FeatureOnlineStore response =
   *       featureOnlineStoreAdminServiceClient.getFeatureOnlineStore(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeatureOnlineStore getFeatureOnlineStore(GetFeatureOnlineStoreRequest request) {
    return getFeatureOnlineStoreCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single FeatureOnlineStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   GetFeatureOnlineStoreRequest request =
   *       GetFeatureOnlineStoreRequest.newBuilder()
   *           .setName(
   *               FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<FeatureOnlineStore> future =
   *       featureOnlineStoreAdminServiceClient.getFeatureOnlineStoreCallable().futureCall(request);
   *   // Do something.
   *   FeatureOnlineStore response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFeatureOnlineStoreRequest, FeatureOnlineStore>
      getFeatureOnlineStoreCallable() {
    return stub.getFeatureOnlineStoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FeatureOnlineStores in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (FeatureOnlineStore element :
   *       featureOnlineStoreAdminServiceClient.listFeatureOnlineStores(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list FeatureOnlineStores. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeatureOnlineStoresPagedResponse listFeatureOnlineStores(LocationName parent) {
    ListFeatureOnlineStoresRequest request =
        ListFeatureOnlineStoresRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFeatureOnlineStores(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FeatureOnlineStores in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (FeatureOnlineStore element :
   *       featureOnlineStoreAdminServiceClient.listFeatureOnlineStores(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list FeatureOnlineStores. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeatureOnlineStoresPagedResponse listFeatureOnlineStores(String parent) {
    ListFeatureOnlineStoresRequest request =
        ListFeatureOnlineStoresRequest.newBuilder().setParent(parent).build();
    return listFeatureOnlineStores(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FeatureOnlineStores in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   ListFeatureOnlineStoresRequest request =
   *       ListFeatureOnlineStoresRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (FeatureOnlineStore element :
   *       featureOnlineStoreAdminServiceClient.listFeatureOnlineStores(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeatureOnlineStoresPagedResponse listFeatureOnlineStores(
      ListFeatureOnlineStoresRequest request) {
    return listFeatureOnlineStoresPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FeatureOnlineStores in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   ListFeatureOnlineStoresRequest request =
   *       ListFeatureOnlineStoresRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<FeatureOnlineStore> future =
   *       featureOnlineStoreAdminServiceClient
   *           .listFeatureOnlineStoresPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (FeatureOnlineStore element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFeatureOnlineStoresRequest, ListFeatureOnlineStoresPagedResponse>
      listFeatureOnlineStoresPagedCallable() {
    return stub.listFeatureOnlineStoresPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FeatureOnlineStores in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   ListFeatureOnlineStoresRequest request =
   *       ListFeatureOnlineStoresRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListFeatureOnlineStoresResponse response =
   *         featureOnlineStoreAdminServiceClient.listFeatureOnlineStoresCallable().call(request);
   *     for (FeatureOnlineStore element : response.getFeatureOnlineStoresList()) {
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
  public final UnaryCallable<ListFeatureOnlineStoresRequest, ListFeatureOnlineStoresResponse>
      listFeatureOnlineStoresCallable() {
    return stub.listFeatureOnlineStoresCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single FeatureOnlineStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   FeatureOnlineStore featureOnlineStore = FeatureOnlineStore.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   FeatureOnlineStore response =
   *       featureOnlineStoreAdminServiceClient
   *           .updateFeatureOnlineStoreAsync(featureOnlineStore, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param featureOnlineStore Required. The FeatureOnlineStore's `name` field is used to identify
   *     the FeatureOnlineStore to be updated. Format:
   *     `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}`
   * @param updateMask Field mask is used to specify the fields to be overwritten in the
   *     FeatureOnlineStore resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then only the non-empty fields present in the
   *     request will be overwritten. Set the update_mask to `&#42;` to override all fields.
   *     <p>Updatable fields:
   *     <p>&#42; `big_query_source` &#42; `labels` &#42; `sync_config`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FeatureOnlineStore, UpdateFeatureOnlineStoreOperationMetadata>
      updateFeatureOnlineStoreAsync(FeatureOnlineStore featureOnlineStore, FieldMask updateMask) {
    UpdateFeatureOnlineStoreRequest request =
        UpdateFeatureOnlineStoreRequest.newBuilder()
            .setFeatureOnlineStore(featureOnlineStore)
            .setUpdateMask(updateMask)
            .build();
    return updateFeatureOnlineStoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single FeatureOnlineStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   UpdateFeatureOnlineStoreRequest request =
   *       UpdateFeatureOnlineStoreRequest.newBuilder()
   *           .setFeatureOnlineStore(FeatureOnlineStore.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   FeatureOnlineStore response =
   *       featureOnlineStoreAdminServiceClient.updateFeatureOnlineStoreAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FeatureOnlineStore, UpdateFeatureOnlineStoreOperationMetadata>
      updateFeatureOnlineStoreAsync(UpdateFeatureOnlineStoreRequest request) {
    return updateFeatureOnlineStoreOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single FeatureOnlineStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   UpdateFeatureOnlineStoreRequest request =
   *       UpdateFeatureOnlineStoreRequest.newBuilder()
   *           .setFeatureOnlineStore(FeatureOnlineStore.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<FeatureOnlineStore, UpdateFeatureOnlineStoreOperationMetadata> future =
   *       featureOnlineStoreAdminServiceClient
   *           .updateFeatureOnlineStoreOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   FeatureOnlineStore response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateFeatureOnlineStoreRequest,
          FeatureOnlineStore,
          UpdateFeatureOnlineStoreOperationMetadata>
      updateFeatureOnlineStoreOperationCallable() {
    return stub.updateFeatureOnlineStoreOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single FeatureOnlineStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   UpdateFeatureOnlineStoreRequest request =
   *       UpdateFeatureOnlineStoreRequest.newBuilder()
   *           .setFeatureOnlineStore(FeatureOnlineStore.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       featureOnlineStoreAdminServiceClient
   *           .updateFeatureOnlineStoreCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateFeatureOnlineStoreRequest, Operation>
      updateFeatureOnlineStoreCallable() {
    return stub.updateFeatureOnlineStoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single FeatureOnlineStore. The FeatureOnlineStore must not contain any FeatureViews.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   FeatureOnlineStoreName name =
   *       FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]");
   *   boolean force = true;
   *   featureOnlineStoreAdminServiceClient.deleteFeatureOnlineStoreAsync(name, force).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the FeatureOnlineStore to be deleted. Format:
   *     `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}`
   * @param force If set to true, any FeatureViews and Features for this FeatureOnlineStore will
   *     also be deleted. (Otherwise, the request will only work if the FeatureOnlineStore has no
   *     FeatureViews.)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteFeatureOnlineStoreAsync(
      FeatureOnlineStoreName name, boolean force) {
    DeleteFeatureOnlineStoreRequest request =
        DeleteFeatureOnlineStoreRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setForce(force)
            .build();
    return deleteFeatureOnlineStoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single FeatureOnlineStore. The FeatureOnlineStore must not contain any FeatureViews.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   String name =
   *       FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]").toString();
   *   boolean force = true;
   *   featureOnlineStoreAdminServiceClient.deleteFeatureOnlineStoreAsync(name, force).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the FeatureOnlineStore to be deleted. Format:
   *     `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}`
   * @param force If set to true, any FeatureViews and Features for this FeatureOnlineStore will
   *     also be deleted. (Otherwise, the request will only work if the FeatureOnlineStore has no
   *     FeatureViews.)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteFeatureOnlineStoreAsync(
      String name, boolean force) {
    DeleteFeatureOnlineStoreRequest request =
        DeleteFeatureOnlineStoreRequest.newBuilder().setName(name).setForce(force).build();
    return deleteFeatureOnlineStoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single FeatureOnlineStore. The FeatureOnlineStore must not contain any FeatureViews.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   DeleteFeatureOnlineStoreRequest request =
   *       DeleteFeatureOnlineStoreRequest.newBuilder()
   *           .setName(
   *               FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   featureOnlineStoreAdminServiceClient.deleteFeatureOnlineStoreAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteFeatureOnlineStoreAsync(
      DeleteFeatureOnlineStoreRequest request) {
    return deleteFeatureOnlineStoreOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single FeatureOnlineStore. The FeatureOnlineStore must not contain any FeatureViews.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   DeleteFeatureOnlineStoreRequest request =
   *       DeleteFeatureOnlineStoreRequest.newBuilder()
   *           .setName(
   *               FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       featureOnlineStoreAdminServiceClient
   *           .deleteFeatureOnlineStoreOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteFeatureOnlineStoreRequest, Empty, DeleteOperationMetadata>
      deleteFeatureOnlineStoreOperationCallable() {
    return stub.deleteFeatureOnlineStoreOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single FeatureOnlineStore. The FeatureOnlineStore must not contain any FeatureViews.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   DeleteFeatureOnlineStoreRequest request =
   *       DeleteFeatureOnlineStoreRequest.newBuilder()
   *           .setName(
   *               FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       featureOnlineStoreAdminServiceClient
   *           .deleteFeatureOnlineStoreCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteFeatureOnlineStoreRequest, Operation>
      deleteFeatureOnlineStoreCallable() {
    return stub.deleteFeatureOnlineStoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FeatureView in a given FeatureOnlineStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   FeatureOnlineStoreName parent =
   *       FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]");
   *   FeatureView featureView = FeatureView.newBuilder().build();
   *   String featureViewId = "featureViewId-1437334218";
   *   FeatureView response =
   *       featureOnlineStoreAdminServiceClient
   *           .createFeatureViewAsync(parent, featureView, featureViewId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the FeatureOnlineStore to create FeatureViews.
   *     Format:
   *     `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}`
   * @param featureView Required. The FeatureView to create.
   * @param featureViewId Required. The ID to use for the FeatureView, which will become the final
   *     component of the FeatureView's resource name.
   *     <p>This value may be up to 60 characters, and valid characters are `[a-z0-9_]`. The first
   *     character cannot be a number.
   *     <p>The value must be unique within a FeatureOnlineStore.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FeatureView, CreateFeatureViewOperationMetadata>
      createFeatureViewAsync(
          FeatureOnlineStoreName parent, FeatureView featureView, String featureViewId) {
    CreateFeatureViewRequest request =
        CreateFeatureViewRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFeatureView(featureView)
            .setFeatureViewId(featureViewId)
            .build();
    return createFeatureViewAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FeatureView in a given FeatureOnlineStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   String parent =
   *       FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]").toString();
   *   FeatureView featureView = FeatureView.newBuilder().build();
   *   String featureViewId = "featureViewId-1437334218";
   *   FeatureView response =
   *       featureOnlineStoreAdminServiceClient
   *           .createFeatureViewAsync(parent, featureView, featureViewId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the FeatureOnlineStore to create FeatureViews.
   *     Format:
   *     `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}`
   * @param featureView Required. The FeatureView to create.
   * @param featureViewId Required. The ID to use for the FeatureView, which will become the final
   *     component of the FeatureView's resource name.
   *     <p>This value may be up to 60 characters, and valid characters are `[a-z0-9_]`. The first
   *     character cannot be a number.
   *     <p>The value must be unique within a FeatureOnlineStore.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FeatureView, CreateFeatureViewOperationMetadata>
      createFeatureViewAsync(String parent, FeatureView featureView, String featureViewId) {
    CreateFeatureViewRequest request =
        CreateFeatureViewRequest.newBuilder()
            .setParent(parent)
            .setFeatureView(featureView)
            .setFeatureViewId(featureViewId)
            .build();
    return createFeatureViewAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FeatureView in a given FeatureOnlineStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   CreateFeatureViewRequest request =
   *       CreateFeatureViewRequest.newBuilder()
   *           .setParent(
   *               FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]")
   *                   .toString())
   *           .setFeatureView(FeatureView.newBuilder().build())
   *           .setFeatureViewId("featureViewId-1437334218")
   *           .setRunSyncImmediately(true)
   *           .build();
   *   FeatureView response =
   *       featureOnlineStoreAdminServiceClient.createFeatureViewAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FeatureView, CreateFeatureViewOperationMetadata>
      createFeatureViewAsync(CreateFeatureViewRequest request) {
    return createFeatureViewOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FeatureView in a given FeatureOnlineStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   CreateFeatureViewRequest request =
   *       CreateFeatureViewRequest.newBuilder()
   *           .setParent(
   *               FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]")
   *                   .toString())
   *           .setFeatureView(FeatureView.newBuilder().build())
   *           .setFeatureViewId("featureViewId-1437334218")
   *           .setRunSyncImmediately(true)
   *           .build();
   *   OperationFuture<FeatureView, CreateFeatureViewOperationMetadata> future =
   *       featureOnlineStoreAdminServiceClient
   *           .createFeatureViewOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   FeatureView response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateFeatureViewRequest, FeatureView, CreateFeatureViewOperationMetadata>
      createFeatureViewOperationCallable() {
    return stub.createFeatureViewOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FeatureView in a given FeatureOnlineStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   CreateFeatureViewRequest request =
   *       CreateFeatureViewRequest.newBuilder()
   *           .setParent(
   *               FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]")
   *                   .toString())
   *           .setFeatureView(FeatureView.newBuilder().build())
   *           .setFeatureViewId("featureViewId-1437334218")
   *           .setRunSyncImmediately(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       featureOnlineStoreAdminServiceClient.createFeatureViewCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateFeatureViewRequest, Operation> createFeatureViewCallable() {
    return stub.createFeatureViewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single FeatureView.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   FeatureViewName name =
   *       FeatureViewName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]");
   *   FeatureView response = featureOnlineStoreAdminServiceClient.getFeatureView(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the FeatureView resource. Format:
   *     `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}/featureViews/{feature_view}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeatureView getFeatureView(FeatureViewName name) {
    GetFeatureViewRequest request =
        GetFeatureViewRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getFeatureView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single FeatureView.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   String name =
   *       FeatureViewName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]")
   *           .toString();
   *   FeatureView response = featureOnlineStoreAdminServiceClient.getFeatureView(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the FeatureView resource. Format:
   *     `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}/featureViews/{feature_view}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeatureView getFeatureView(String name) {
    GetFeatureViewRequest request = GetFeatureViewRequest.newBuilder().setName(name).build();
    return getFeatureView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single FeatureView.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   GetFeatureViewRequest request =
   *       GetFeatureViewRequest.newBuilder()
   *           .setName(
   *               FeatureViewName.of(
   *                       "[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]")
   *                   .toString())
   *           .build();
   *   FeatureView response = featureOnlineStoreAdminServiceClient.getFeatureView(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeatureView getFeatureView(GetFeatureViewRequest request) {
    return getFeatureViewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single FeatureView.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   GetFeatureViewRequest request =
   *       GetFeatureViewRequest.newBuilder()
   *           .setName(
   *               FeatureViewName.of(
   *                       "[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]")
   *                   .toString())
   *           .build();
   *   ApiFuture<FeatureView> future =
   *       featureOnlineStoreAdminServiceClient.getFeatureViewCallable().futureCall(request);
   *   // Do something.
   *   FeatureView response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFeatureViewRequest, FeatureView> getFeatureViewCallable() {
    return stub.getFeatureViewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FeatureViews in a given FeatureOnlineStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   FeatureOnlineStoreName parent =
   *       FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]");
   *   for (FeatureView element :
   *       featureOnlineStoreAdminServiceClient.listFeatureViews(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the FeatureOnlineStore to list FeatureViews.
   *     Format:
   *     `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeatureViewsPagedResponse listFeatureViews(FeatureOnlineStoreName parent) {
    ListFeatureViewsRequest request =
        ListFeatureViewsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFeatureViews(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FeatureViews in a given FeatureOnlineStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   String parent =
   *       FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]").toString();
   *   for (FeatureView element :
   *       featureOnlineStoreAdminServiceClient.listFeatureViews(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the FeatureOnlineStore to list FeatureViews.
   *     Format:
   *     `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeatureViewsPagedResponse listFeatureViews(String parent) {
    ListFeatureViewsRequest request =
        ListFeatureViewsRequest.newBuilder().setParent(parent).build();
    return listFeatureViews(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FeatureViews in a given FeatureOnlineStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   ListFeatureViewsRequest request =
   *       ListFeatureViewsRequest.newBuilder()
   *           .setParent(
   *               FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (FeatureView element :
   *       featureOnlineStoreAdminServiceClient.listFeatureViews(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeatureViewsPagedResponse listFeatureViews(ListFeatureViewsRequest request) {
    return listFeatureViewsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FeatureViews in a given FeatureOnlineStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   ListFeatureViewsRequest request =
   *       ListFeatureViewsRequest.newBuilder()
   *           .setParent(
   *               FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<FeatureView> future =
   *       featureOnlineStoreAdminServiceClient.listFeatureViewsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (FeatureView element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFeatureViewsRequest, ListFeatureViewsPagedResponse>
      listFeatureViewsPagedCallable() {
    return stub.listFeatureViewsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FeatureViews in a given FeatureOnlineStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   ListFeatureViewsRequest request =
   *       ListFeatureViewsRequest.newBuilder()
   *           .setParent(
   *               FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListFeatureViewsResponse response =
   *         featureOnlineStoreAdminServiceClient.listFeatureViewsCallable().call(request);
   *     for (FeatureView element : response.getFeatureViewsList()) {
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
  public final UnaryCallable<ListFeatureViewsRequest, ListFeatureViewsResponse>
      listFeatureViewsCallable() {
    return stub.listFeatureViewsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single FeatureView.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   FeatureView featureView = FeatureView.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   FeatureView response =
   *       featureOnlineStoreAdminServiceClient
   *           .updateFeatureViewAsync(featureView, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param featureView Required. The FeatureView's `name` field is used to identify the FeatureView
   *     to be updated. Format:
   *     `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}/featureViews/{feature_view}`
   * @param updateMask Field mask is used to specify the fields to be overwritten in the FeatureView
   *     resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then only the non-empty fields present in the request will be
   *     overwritten. Set the update_mask to `&#42;` to override all fields.
   *     <p>Updatable fields:
   *     <p>&#42; `labels`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FeatureView, UpdateFeatureViewOperationMetadata>
      updateFeatureViewAsync(FeatureView featureView, FieldMask updateMask) {
    UpdateFeatureViewRequest request =
        UpdateFeatureViewRequest.newBuilder()
            .setFeatureView(featureView)
            .setUpdateMask(updateMask)
            .build();
    return updateFeatureViewAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single FeatureView.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   UpdateFeatureViewRequest request =
   *       UpdateFeatureViewRequest.newBuilder()
   *           .setFeatureView(FeatureView.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   FeatureView response =
   *       featureOnlineStoreAdminServiceClient.updateFeatureViewAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FeatureView, UpdateFeatureViewOperationMetadata>
      updateFeatureViewAsync(UpdateFeatureViewRequest request) {
    return updateFeatureViewOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single FeatureView.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   UpdateFeatureViewRequest request =
   *       UpdateFeatureViewRequest.newBuilder()
   *           .setFeatureView(FeatureView.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<FeatureView, UpdateFeatureViewOperationMetadata> future =
   *       featureOnlineStoreAdminServiceClient
   *           .updateFeatureViewOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   FeatureView response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateFeatureViewRequest, FeatureView, UpdateFeatureViewOperationMetadata>
      updateFeatureViewOperationCallable() {
    return stub.updateFeatureViewOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single FeatureView.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   UpdateFeatureViewRequest request =
   *       UpdateFeatureViewRequest.newBuilder()
   *           .setFeatureView(FeatureView.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       featureOnlineStoreAdminServiceClient.updateFeatureViewCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateFeatureViewRequest, Operation> updateFeatureViewCallable() {
    return stub.updateFeatureViewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single FeatureView.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   FeatureViewName name =
   *       FeatureViewName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]");
   *   featureOnlineStoreAdminServiceClient.deleteFeatureViewAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the FeatureView to be deleted. Format:
   *     `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}/featureViews/{feature_view}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteFeatureViewAsync(
      FeatureViewName name) {
    DeleteFeatureViewRequest request =
        DeleteFeatureViewRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteFeatureViewAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single FeatureView.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   String name =
   *       FeatureViewName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]")
   *           .toString();
   *   featureOnlineStoreAdminServiceClient.deleteFeatureViewAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the FeatureView to be deleted. Format:
   *     `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}/featureViews/{feature_view}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteFeatureViewAsync(String name) {
    DeleteFeatureViewRequest request = DeleteFeatureViewRequest.newBuilder().setName(name).build();
    return deleteFeatureViewAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single FeatureView.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   DeleteFeatureViewRequest request =
   *       DeleteFeatureViewRequest.newBuilder()
   *           .setName(
   *               FeatureViewName.of(
   *                       "[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]")
   *                   .toString())
   *           .build();
   *   featureOnlineStoreAdminServiceClient.deleteFeatureViewAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteFeatureViewAsync(
      DeleteFeatureViewRequest request) {
    return deleteFeatureViewOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single FeatureView.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   DeleteFeatureViewRequest request =
   *       DeleteFeatureViewRequest.newBuilder()
   *           .setName(
   *               FeatureViewName.of(
   *                       "[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       featureOnlineStoreAdminServiceClient
   *           .deleteFeatureViewOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteFeatureViewRequest, Empty, DeleteOperationMetadata>
      deleteFeatureViewOperationCallable() {
    return stub.deleteFeatureViewOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single FeatureView.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   DeleteFeatureViewRequest request =
   *       DeleteFeatureViewRequest.newBuilder()
   *           .setName(
   *               FeatureViewName.of(
   *                       "[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       featureOnlineStoreAdminServiceClient.deleteFeatureViewCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteFeatureViewRequest, Operation> deleteFeatureViewCallable() {
    return stub.deleteFeatureViewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Triggers on-demand sync for the FeatureView.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   FeatureViewName featureView =
   *       FeatureViewName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]");
   *   SyncFeatureViewResponse response =
   *       featureOnlineStoreAdminServiceClient.syncFeatureView(featureView);
   * }
   * }</pre>
   *
   * @param featureView Required. Format:
   *     `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}/featureViews/{feature_view}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SyncFeatureViewResponse syncFeatureView(FeatureViewName featureView) {
    SyncFeatureViewRequest request =
        SyncFeatureViewRequest.newBuilder()
            .setFeatureView(featureView == null ? null : featureView.toString())
            .build();
    return syncFeatureView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Triggers on-demand sync for the FeatureView.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   String featureView =
   *       FeatureViewName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]")
   *           .toString();
   *   SyncFeatureViewResponse response =
   *       featureOnlineStoreAdminServiceClient.syncFeatureView(featureView);
   * }
   * }</pre>
   *
   * @param featureView Required. Format:
   *     `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}/featureViews/{feature_view}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SyncFeatureViewResponse syncFeatureView(String featureView) {
    SyncFeatureViewRequest request =
        SyncFeatureViewRequest.newBuilder().setFeatureView(featureView).build();
    return syncFeatureView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Triggers on-demand sync for the FeatureView.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   SyncFeatureViewRequest request =
   *       SyncFeatureViewRequest.newBuilder()
   *           .setFeatureView(
   *               FeatureViewName.of(
   *                       "[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]")
   *                   .toString())
   *           .build();
   *   SyncFeatureViewResponse response =
   *       featureOnlineStoreAdminServiceClient.syncFeatureView(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SyncFeatureViewResponse syncFeatureView(SyncFeatureViewRequest request) {
    return syncFeatureViewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Triggers on-demand sync for the FeatureView.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   SyncFeatureViewRequest request =
   *       SyncFeatureViewRequest.newBuilder()
   *           .setFeatureView(
   *               FeatureViewName.of(
   *                       "[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]")
   *                   .toString())
   *           .build();
   *   ApiFuture<SyncFeatureViewResponse> future =
   *       featureOnlineStoreAdminServiceClient.syncFeatureViewCallable().futureCall(request);
   *   // Do something.
   *   SyncFeatureViewResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SyncFeatureViewRequest, SyncFeatureViewResponse>
      syncFeatureViewCallable() {
    return stub.syncFeatureViewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single FeatureViewSync.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   FeatureViewSyncName name =
   *       FeatureViewSyncName.of(
   *           "[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]");
   *   FeatureViewSync response = featureOnlineStoreAdminServiceClient.getFeatureViewSync(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the FeatureViewSync resource. Format:
   *     `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}/featureViews/{feature_view}/featureViewSyncs/{feature_view_sync}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeatureViewSync getFeatureViewSync(FeatureViewSyncName name) {
    GetFeatureViewSyncRequest request =
        GetFeatureViewSyncRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getFeatureViewSync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single FeatureViewSync.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   String name =
   *       FeatureViewSyncName.of(
   *               "[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]")
   *           .toString();
   *   FeatureViewSync response = featureOnlineStoreAdminServiceClient.getFeatureViewSync(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the FeatureViewSync resource. Format:
   *     `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}/featureViews/{feature_view}/featureViewSyncs/{feature_view_sync}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeatureViewSync getFeatureViewSync(String name) {
    GetFeatureViewSyncRequest request =
        GetFeatureViewSyncRequest.newBuilder().setName(name).build();
    return getFeatureViewSync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single FeatureViewSync.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   GetFeatureViewSyncRequest request =
   *       GetFeatureViewSyncRequest.newBuilder()
   *           .setName(
   *               FeatureViewSyncName.of(
   *                       "[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]")
   *                   .toString())
   *           .build();
   *   FeatureViewSync response = featureOnlineStoreAdminServiceClient.getFeatureViewSync(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeatureViewSync getFeatureViewSync(GetFeatureViewSyncRequest request) {
    return getFeatureViewSyncCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single FeatureViewSync.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   GetFeatureViewSyncRequest request =
   *       GetFeatureViewSyncRequest.newBuilder()
   *           .setName(
   *               FeatureViewSyncName.of(
   *                       "[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]")
   *                   .toString())
   *           .build();
   *   ApiFuture<FeatureViewSync> future =
   *       featureOnlineStoreAdminServiceClient.getFeatureViewSyncCallable().futureCall(request);
   *   // Do something.
   *   FeatureViewSync response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFeatureViewSyncRequest, FeatureViewSync>
      getFeatureViewSyncCallable() {
    return stub.getFeatureViewSyncCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FeatureViewSyncs in a given FeatureView.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   FeatureViewName parent =
   *       FeatureViewName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]");
   *   for (FeatureViewSync element :
   *       featureOnlineStoreAdminServiceClient.listFeatureViewSyncs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the FeatureView to list FeatureViewSyncs. Format:
   *     `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}/featureViews/{feature_view}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeatureViewSyncsPagedResponse listFeatureViewSyncs(FeatureViewName parent) {
    ListFeatureViewSyncsRequest request =
        ListFeatureViewSyncsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFeatureViewSyncs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FeatureViewSyncs in a given FeatureView.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   String parent =
   *       FeatureViewName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]")
   *           .toString();
   *   for (FeatureViewSync element :
   *       featureOnlineStoreAdminServiceClient.listFeatureViewSyncs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the FeatureView to list FeatureViewSyncs. Format:
   *     `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}/featureViews/{feature_view}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeatureViewSyncsPagedResponse listFeatureViewSyncs(String parent) {
    ListFeatureViewSyncsRequest request =
        ListFeatureViewSyncsRequest.newBuilder().setParent(parent).build();
    return listFeatureViewSyncs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FeatureViewSyncs in a given FeatureView.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   ListFeatureViewSyncsRequest request =
   *       ListFeatureViewSyncsRequest.newBuilder()
   *           .setParent(
   *               FeatureViewName.of(
   *                       "[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (FeatureViewSync element :
   *       featureOnlineStoreAdminServiceClient.listFeatureViewSyncs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeatureViewSyncsPagedResponse listFeatureViewSyncs(
      ListFeatureViewSyncsRequest request) {
    return listFeatureViewSyncsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FeatureViewSyncs in a given FeatureView.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   ListFeatureViewSyncsRequest request =
   *       ListFeatureViewSyncsRequest.newBuilder()
   *           .setParent(
   *               FeatureViewName.of(
   *                       "[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<FeatureViewSync> future =
   *       featureOnlineStoreAdminServiceClient
   *           .listFeatureViewSyncsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (FeatureViewSync element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFeatureViewSyncsRequest, ListFeatureViewSyncsPagedResponse>
      listFeatureViewSyncsPagedCallable() {
    return stub.listFeatureViewSyncsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FeatureViewSyncs in a given FeatureView.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   ListFeatureViewSyncsRequest request =
   *       ListFeatureViewSyncsRequest.newBuilder()
   *           .setParent(
   *               FeatureViewName.of(
   *                       "[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListFeatureViewSyncsResponse response =
   *         featureOnlineStoreAdminServiceClient.listFeatureViewSyncsCallable().call(request);
   *     for (FeatureViewSync element : response.getFeatureViewSyncsList()) {
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
  public final UnaryCallable<ListFeatureViewSyncsRequest, ListFeatureViewSyncsResponse>
      listFeatureViewSyncsCallable() {
    return stub.listFeatureViewSyncsCallable();
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
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element :
   *       featureOnlineStoreAdminServiceClient.listLocations(request).iterateAll()) {
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
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       featureOnlineStoreAdminServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         featureOnlineStoreAdminServiceClient.listLocationsCallable().call(request);
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
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = featureOnlineStoreAdminServiceClient.getLocation(request);
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
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       featureOnlineStoreAdminServiceClient.getLocationCallable().futureCall(request);
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
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = featureOnlineStoreAdminServiceClient.setIamPolicy(request);
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
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       featureOnlineStoreAdminServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = featureOnlineStoreAdminServiceClient.getIamPolicy(request);
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
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       featureOnlineStoreAdminServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response =
   *       featureOnlineStoreAdminServiceClient.testIamPermissions(request);
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
   * try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
   *     FeatureOnlineStoreAdminServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       featureOnlineStoreAdminServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListFeatureOnlineStoresPagedResponse
      extends AbstractPagedListResponse<
          ListFeatureOnlineStoresRequest,
          ListFeatureOnlineStoresResponse,
          FeatureOnlineStore,
          ListFeatureOnlineStoresPage,
          ListFeatureOnlineStoresFixedSizeCollection> {

    public static ApiFuture<ListFeatureOnlineStoresPagedResponse> createAsync(
        PageContext<
                ListFeatureOnlineStoresRequest, ListFeatureOnlineStoresResponse, FeatureOnlineStore>
            context,
        ApiFuture<ListFeatureOnlineStoresResponse> futureResponse) {
      ApiFuture<ListFeatureOnlineStoresPage> futurePage =
          ListFeatureOnlineStoresPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListFeatureOnlineStoresPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListFeatureOnlineStoresPagedResponse(ListFeatureOnlineStoresPage page) {
      super(page, ListFeatureOnlineStoresFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFeatureOnlineStoresPage
      extends AbstractPage<
          ListFeatureOnlineStoresRequest,
          ListFeatureOnlineStoresResponse,
          FeatureOnlineStore,
          ListFeatureOnlineStoresPage> {

    private ListFeatureOnlineStoresPage(
        PageContext<
                ListFeatureOnlineStoresRequest, ListFeatureOnlineStoresResponse, FeatureOnlineStore>
            context,
        ListFeatureOnlineStoresResponse response) {
      super(context, response);
    }

    private static ListFeatureOnlineStoresPage createEmptyPage() {
      return new ListFeatureOnlineStoresPage(null, null);
    }

    @Override
    protected ListFeatureOnlineStoresPage createPage(
        PageContext<
                ListFeatureOnlineStoresRequest, ListFeatureOnlineStoresResponse, FeatureOnlineStore>
            context,
        ListFeatureOnlineStoresResponse response) {
      return new ListFeatureOnlineStoresPage(context, response);
    }

    @Override
    public ApiFuture<ListFeatureOnlineStoresPage> createPageAsync(
        PageContext<
                ListFeatureOnlineStoresRequest, ListFeatureOnlineStoresResponse, FeatureOnlineStore>
            context,
        ApiFuture<ListFeatureOnlineStoresResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFeatureOnlineStoresFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFeatureOnlineStoresRequest,
          ListFeatureOnlineStoresResponse,
          FeatureOnlineStore,
          ListFeatureOnlineStoresPage,
          ListFeatureOnlineStoresFixedSizeCollection> {

    private ListFeatureOnlineStoresFixedSizeCollection(
        List<ListFeatureOnlineStoresPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFeatureOnlineStoresFixedSizeCollection createEmptyCollection() {
      return new ListFeatureOnlineStoresFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFeatureOnlineStoresFixedSizeCollection createCollection(
        List<ListFeatureOnlineStoresPage> pages, int collectionSize) {
      return new ListFeatureOnlineStoresFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListFeatureViewsPagedResponse
      extends AbstractPagedListResponse<
          ListFeatureViewsRequest,
          ListFeatureViewsResponse,
          FeatureView,
          ListFeatureViewsPage,
          ListFeatureViewsFixedSizeCollection> {

    public static ApiFuture<ListFeatureViewsPagedResponse> createAsync(
        PageContext<ListFeatureViewsRequest, ListFeatureViewsResponse, FeatureView> context,
        ApiFuture<ListFeatureViewsResponse> futureResponse) {
      ApiFuture<ListFeatureViewsPage> futurePage =
          ListFeatureViewsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListFeatureViewsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListFeatureViewsPagedResponse(ListFeatureViewsPage page) {
      super(page, ListFeatureViewsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFeatureViewsPage
      extends AbstractPage<
          ListFeatureViewsRequest, ListFeatureViewsResponse, FeatureView, ListFeatureViewsPage> {

    private ListFeatureViewsPage(
        PageContext<ListFeatureViewsRequest, ListFeatureViewsResponse, FeatureView> context,
        ListFeatureViewsResponse response) {
      super(context, response);
    }

    private static ListFeatureViewsPage createEmptyPage() {
      return new ListFeatureViewsPage(null, null);
    }

    @Override
    protected ListFeatureViewsPage createPage(
        PageContext<ListFeatureViewsRequest, ListFeatureViewsResponse, FeatureView> context,
        ListFeatureViewsResponse response) {
      return new ListFeatureViewsPage(context, response);
    }

    @Override
    public ApiFuture<ListFeatureViewsPage> createPageAsync(
        PageContext<ListFeatureViewsRequest, ListFeatureViewsResponse, FeatureView> context,
        ApiFuture<ListFeatureViewsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFeatureViewsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFeatureViewsRequest,
          ListFeatureViewsResponse,
          FeatureView,
          ListFeatureViewsPage,
          ListFeatureViewsFixedSizeCollection> {

    private ListFeatureViewsFixedSizeCollection(
        List<ListFeatureViewsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFeatureViewsFixedSizeCollection createEmptyCollection() {
      return new ListFeatureViewsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFeatureViewsFixedSizeCollection createCollection(
        List<ListFeatureViewsPage> pages, int collectionSize) {
      return new ListFeatureViewsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListFeatureViewSyncsPagedResponse
      extends AbstractPagedListResponse<
          ListFeatureViewSyncsRequest,
          ListFeatureViewSyncsResponse,
          FeatureViewSync,
          ListFeatureViewSyncsPage,
          ListFeatureViewSyncsFixedSizeCollection> {

    public static ApiFuture<ListFeatureViewSyncsPagedResponse> createAsync(
        PageContext<ListFeatureViewSyncsRequest, ListFeatureViewSyncsResponse, FeatureViewSync>
            context,
        ApiFuture<ListFeatureViewSyncsResponse> futureResponse) {
      ApiFuture<ListFeatureViewSyncsPage> futurePage =
          ListFeatureViewSyncsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListFeatureViewSyncsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListFeatureViewSyncsPagedResponse(ListFeatureViewSyncsPage page) {
      super(page, ListFeatureViewSyncsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFeatureViewSyncsPage
      extends AbstractPage<
          ListFeatureViewSyncsRequest,
          ListFeatureViewSyncsResponse,
          FeatureViewSync,
          ListFeatureViewSyncsPage> {

    private ListFeatureViewSyncsPage(
        PageContext<ListFeatureViewSyncsRequest, ListFeatureViewSyncsResponse, FeatureViewSync>
            context,
        ListFeatureViewSyncsResponse response) {
      super(context, response);
    }

    private static ListFeatureViewSyncsPage createEmptyPage() {
      return new ListFeatureViewSyncsPage(null, null);
    }

    @Override
    protected ListFeatureViewSyncsPage createPage(
        PageContext<ListFeatureViewSyncsRequest, ListFeatureViewSyncsResponse, FeatureViewSync>
            context,
        ListFeatureViewSyncsResponse response) {
      return new ListFeatureViewSyncsPage(context, response);
    }

    @Override
    public ApiFuture<ListFeatureViewSyncsPage> createPageAsync(
        PageContext<ListFeatureViewSyncsRequest, ListFeatureViewSyncsResponse, FeatureViewSync>
            context,
        ApiFuture<ListFeatureViewSyncsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFeatureViewSyncsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFeatureViewSyncsRequest,
          ListFeatureViewSyncsResponse,
          FeatureViewSync,
          ListFeatureViewSyncsPage,
          ListFeatureViewSyncsFixedSizeCollection> {

    private ListFeatureViewSyncsFixedSizeCollection(
        List<ListFeatureViewSyncsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFeatureViewSyncsFixedSizeCollection createEmptyCollection() {
      return new ListFeatureViewSyncsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFeatureViewSyncsFixedSizeCollection createCollection(
        List<ListFeatureViewSyncsPage> pages, int collectionSize) {
      return new ListFeatureViewSyncsFixedSizeCollection(pages, collectionSize);
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
