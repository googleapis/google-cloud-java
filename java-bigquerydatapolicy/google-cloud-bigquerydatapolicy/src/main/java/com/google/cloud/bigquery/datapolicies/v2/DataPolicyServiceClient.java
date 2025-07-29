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

package com.google.cloud.bigquery.datapolicies.v2;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.datapolicies.v2.stub.DataPolicyServiceStub;
import com.google.cloud.bigquery.datapolicies.v2.stub.DataPolicyServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Data Policy Service provides APIs for managing the BigQuery Data Policy.
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
 * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   DataPolicy dataPolicy = DataPolicy.newBuilder().build();
 *   String dataPolicyId = "dataPolicyId1874146231";
 *   DataPolicy response =
 *       dataPolicyServiceClient.createDataPolicy(parent, dataPolicy, dataPolicyId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DataPolicyServiceClient object to clean up resources
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
 *      <td><p> CreateDataPolicy</td>
 *      <td><p> Creates a new data policy under a project with the given `data_policy_id` (used as the display name), and data policy type.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDataPolicy(CreateDataPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createDataPolicy(LocationName parent, DataPolicy dataPolicy, String dataPolicyId)
 *           <li><p> createDataPolicy(String parent, DataPolicy dataPolicy, String dataPolicyId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDataPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AddGrantees</td>
 *      <td><p> Adds new grantees to a data policy. The new grantees will be added to the existing grantees. If the request contains a duplicate grantee, the grantee will be ignored. If the request contains a grantee that already exists, the grantee will be ignored.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> addGrantees(AddGranteesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> addGrantees(DataPolicyName dataPolicy, List&lt;String&gt; grantees)
 *           <li><p> addGrantees(String dataPolicy, List&lt;String&gt; grantees)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> addGranteesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RemoveGrantees</td>
 *      <td><p> Removes grantees from a data policy. The grantees will be removed from the existing grantees. If the request contains a grantee that does not exist, the grantee will be ignored.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> removeGrantees(RemoveGranteesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> removeGrantees(DataPolicyName dataPolicy, List&lt;String&gt; grantees)
 *           <li><p> removeGrantees(String dataPolicy, List&lt;String&gt; grantees)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> removeGranteesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDataPolicy</td>
 *      <td><p> Updates the metadata for an existing data policy. The target data policy can be specified by the resource name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDataPolicy(UpdateDataPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDataPolicy(DataPolicy dataPolicy, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDataPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDataPolicy</td>
 *      <td><p> Deletes the data policy specified by its resource name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDataPolicy(DeleteDataPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteDataPolicy(DataPolicyName name)
 *           <li><p> deleteDataPolicy(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDataPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDataPolicy</td>
 *      <td><p> Gets the data policy specified by its resource name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDataPolicy(GetDataPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDataPolicy(DataPolicyName name)
 *           <li><p> getDataPolicy(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDataPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDataPolicies</td>
 *      <td><p> List all of the data policies in the specified parent project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDataPolicies(ListDataPoliciesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDataPolicies(LocationName parent)
 *           <li><p> listDataPolicies(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDataPoliciesPagedCallable()
 *           <li><p> listDataPoliciesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the IAM policy for the specified data policy.</td>
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
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the IAM policy for the specified data policy.</td>
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
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns the caller's permission on the specified data policy resource.</td>
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
 * <p>This class can be customized by passing in a custom instance of DataPolicyServiceSettings to
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
 * DataPolicyServiceSettings dataPolicyServiceSettings =
 *     DataPolicyServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataPolicyServiceClient dataPolicyServiceClient =
 *     DataPolicyServiceClient.create(dataPolicyServiceSettings);
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
 * DataPolicyServiceSettings dataPolicyServiceSettings =
 *     DataPolicyServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataPolicyServiceClient dataPolicyServiceClient =
 *     DataPolicyServiceClient.create(dataPolicyServiceSettings);
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
 * DataPolicyServiceSettings dataPolicyServiceSettings =
 *     DataPolicyServiceSettings.newHttpJsonBuilder().build();
 * DataPolicyServiceClient dataPolicyServiceClient =
 *     DataPolicyServiceClient.create(dataPolicyServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DataPolicyServiceClient implements BackgroundResource {
  private final DataPolicyServiceSettings settings;
  private final DataPolicyServiceStub stub;

  /** Constructs an instance of DataPolicyServiceClient with default settings. */
  public static final DataPolicyServiceClient create() throws IOException {
    return create(DataPolicyServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataPolicyServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DataPolicyServiceClient create(DataPolicyServiceSettings settings)
      throws IOException {
    return new DataPolicyServiceClient(settings);
  }

  /**
   * Constructs an instance of DataPolicyServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(DataPolicyServiceSettings).
   */
  public static final DataPolicyServiceClient create(DataPolicyServiceStub stub) {
    return new DataPolicyServiceClient(stub);
  }

  /**
   * Constructs an instance of DataPolicyServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DataPolicyServiceClient(DataPolicyServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DataPolicyServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected DataPolicyServiceClient(DataPolicyServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DataPolicyServiceSettings getSettings() {
    return settings;
  }

  public DataPolicyServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new data policy under a project with the given `data_policy_id` (used as the display
   * name), and data policy type.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   DataPolicy dataPolicy = DataPolicy.newBuilder().build();
   *   String dataPolicyId = "dataPolicyId1874146231";
   *   DataPolicy response =
   *       dataPolicyServiceClient.createDataPolicy(parent, dataPolicy, dataPolicyId);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the project that the data policy will belong to. The
   *     format is `projects/{project_number}/locations/{location_id}`.
   * @param dataPolicy Required. The data policy to create. The `name` field does not need to be
   *     provided for the data policy creation.
   * @param dataPolicyId Required. User-assigned (human readable) ID of the data policy that needs
   *     to be unique within a project. Used as {data_policy_id} in part of the resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataPolicy createDataPolicy(
      LocationName parent, DataPolicy dataPolicy, String dataPolicyId) {
    CreateDataPolicyRequest request =
        CreateDataPolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataPolicy(dataPolicy)
            .setDataPolicyId(dataPolicyId)
            .build();
    return createDataPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new data policy under a project with the given `data_policy_id` (used as the display
   * name), and data policy type.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   DataPolicy dataPolicy = DataPolicy.newBuilder().build();
   *   String dataPolicyId = "dataPolicyId1874146231";
   *   DataPolicy response =
   *       dataPolicyServiceClient.createDataPolicy(parent, dataPolicy, dataPolicyId);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the project that the data policy will belong to. The
   *     format is `projects/{project_number}/locations/{location_id}`.
   * @param dataPolicy Required. The data policy to create. The `name` field does not need to be
   *     provided for the data policy creation.
   * @param dataPolicyId Required. User-assigned (human readable) ID of the data policy that needs
   *     to be unique within a project. Used as {data_policy_id} in part of the resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataPolicy createDataPolicy(
      String parent, DataPolicy dataPolicy, String dataPolicyId) {
    CreateDataPolicyRequest request =
        CreateDataPolicyRequest.newBuilder()
            .setParent(parent)
            .setDataPolicy(dataPolicy)
            .setDataPolicyId(dataPolicyId)
            .build();
    return createDataPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new data policy under a project with the given `data_policy_id` (used as the display
   * name), and data policy type.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   CreateDataPolicyRequest request =
   *       CreateDataPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataPolicyId("dataPolicyId1874146231")
   *           .setDataPolicy(DataPolicy.newBuilder().build())
   *           .build();
   *   DataPolicy response = dataPolicyServiceClient.createDataPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataPolicy createDataPolicy(CreateDataPolicyRequest request) {
    return createDataPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new data policy under a project with the given `data_policy_id` (used as the display
   * name), and data policy type.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   CreateDataPolicyRequest request =
   *       CreateDataPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataPolicyId("dataPolicyId1874146231")
   *           .setDataPolicy(DataPolicy.newBuilder().build())
   *           .build();
   *   ApiFuture<DataPolicy> future =
   *       dataPolicyServiceClient.createDataPolicyCallable().futureCall(request);
   *   // Do something.
   *   DataPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDataPolicyRequest, DataPolicy> createDataPolicyCallable() {
    return stub.createDataPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds new grantees to a data policy. The new grantees will be added to the existing grantees. If
   * the request contains a duplicate grantee, the grantee will be ignored. If the request contains
   * a grantee that already exists, the grantee will be ignored.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   DataPolicyName dataPolicy = DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]");
   *   List<String> grantees = new ArrayList<>();
   *   DataPolicy response = dataPolicyServiceClient.addGrantees(dataPolicy, grantees);
   * }
   * }</pre>
   *
   * @param dataPolicy Required. Resource name of this data policy, in the format of
   *     `projects/{project_number}/locations/{location_id}/dataPolicies/{data_policy_id}`.
   * @param grantees Required. IAM principal that should be granted Fine Grained Access to the
   *     underlying data goverened by the data policy. The target data policy is determined by the
   *     `data_policy` field.
   *     <p>Uses the [IAM V2 principal
   *     syntax](https://cloud.google.com/iam/docs/principal-identifiers#v2). Supported principal
   *     types:
   *     <ul>
   *       <li>User
   *       <li>Group
   *       <li>Service account
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataPolicy addGrantees(DataPolicyName dataPolicy, List<String> grantees) {
    AddGranteesRequest request =
        AddGranteesRequest.newBuilder()
            .setDataPolicy(dataPolicy == null ? null : dataPolicy.toString())
            .addAllGrantees(grantees)
            .build();
    return addGrantees(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds new grantees to a data policy. The new grantees will be added to the existing grantees. If
   * the request contains a duplicate grantee, the grantee will be ignored. If the request contains
   * a grantee that already exists, the grantee will be ignored.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   String dataPolicy = DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString();
   *   List<String> grantees = new ArrayList<>();
   *   DataPolicy response = dataPolicyServiceClient.addGrantees(dataPolicy, grantees);
   * }
   * }</pre>
   *
   * @param dataPolicy Required. Resource name of this data policy, in the format of
   *     `projects/{project_number}/locations/{location_id}/dataPolicies/{data_policy_id}`.
   * @param grantees Required. IAM principal that should be granted Fine Grained Access to the
   *     underlying data goverened by the data policy. The target data policy is determined by the
   *     `data_policy` field.
   *     <p>Uses the [IAM V2 principal
   *     syntax](https://cloud.google.com/iam/docs/principal-identifiers#v2). Supported principal
   *     types:
   *     <ul>
   *       <li>User
   *       <li>Group
   *       <li>Service account
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataPolicy addGrantees(String dataPolicy, List<String> grantees) {
    AddGranteesRequest request =
        AddGranteesRequest.newBuilder().setDataPolicy(dataPolicy).addAllGrantees(grantees).build();
    return addGrantees(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds new grantees to a data policy. The new grantees will be added to the existing grantees. If
   * the request contains a duplicate grantee, the grantee will be ignored. If the request contains
   * a grantee that already exists, the grantee will be ignored.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   AddGranteesRequest request =
   *       AddGranteesRequest.newBuilder()
   *           .setDataPolicy(
   *               DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString())
   *           .addAllGrantees(new ArrayList<String>())
   *           .build();
   *   DataPolicy response = dataPolicyServiceClient.addGrantees(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataPolicy addGrantees(AddGranteesRequest request) {
    return addGranteesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds new grantees to a data policy. The new grantees will be added to the existing grantees. If
   * the request contains a duplicate grantee, the grantee will be ignored. If the request contains
   * a grantee that already exists, the grantee will be ignored.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   AddGranteesRequest request =
   *       AddGranteesRequest.newBuilder()
   *           .setDataPolicy(
   *               DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString())
   *           .addAllGrantees(new ArrayList<String>())
   *           .build();
   *   ApiFuture<DataPolicy> future =
   *       dataPolicyServiceClient.addGranteesCallable().futureCall(request);
   *   // Do something.
   *   DataPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddGranteesRequest, DataPolicy> addGranteesCallable() {
    return stub.addGranteesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes grantees from a data policy. The grantees will be removed from the existing grantees.
   * If the request contains a grantee that does not exist, the grantee will be ignored.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   DataPolicyName dataPolicy = DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]");
   *   List<String> grantees = new ArrayList<>();
   *   DataPolicy response = dataPolicyServiceClient.removeGrantees(dataPolicy, grantees);
   * }
   * }</pre>
   *
   * @param dataPolicy Required. Resource name of this data policy, in the format of
   *     `projects/{project_number}/locations/{location_id}/dataPolicies/{data_policy_id}`.
   * @param grantees Required. IAM principal that should be revoked from Fine Grained Access to the
   *     underlying data goverened by the data policy. The target data policy is determined by the
   *     `data_policy` field.
   *     <p>Uses the [IAM V2 principal
   *     syntax](https://cloud.google.com/iam/docs/principal-identifiers#v2). Supported principal
   *     types:
   *     <ul>
   *       <li>User
   *       <li>Group
   *       <li>Service account
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataPolicy removeGrantees(DataPolicyName dataPolicy, List<String> grantees) {
    RemoveGranteesRequest request =
        RemoveGranteesRequest.newBuilder()
            .setDataPolicy(dataPolicy == null ? null : dataPolicy.toString())
            .addAllGrantees(grantees)
            .build();
    return removeGrantees(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes grantees from a data policy. The grantees will be removed from the existing grantees.
   * If the request contains a grantee that does not exist, the grantee will be ignored.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   String dataPolicy = DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString();
   *   List<String> grantees = new ArrayList<>();
   *   DataPolicy response = dataPolicyServiceClient.removeGrantees(dataPolicy, grantees);
   * }
   * }</pre>
   *
   * @param dataPolicy Required. Resource name of this data policy, in the format of
   *     `projects/{project_number}/locations/{location_id}/dataPolicies/{data_policy_id}`.
   * @param grantees Required. IAM principal that should be revoked from Fine Grained Access to the
   *     underlying data goverened by the data policy. The target data policy is determined by the
   *     `data_policy` field.
   *     <p>Uses the [IAM V2 principal
   *     syntax](https://cloud.google.com/iam/docs/principal-identifiers#v2). Supported principal
   *     types:
   *     <ul>
   *       <li>User
   *       <li>Group
   *       <li>Service account
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataPolicy removeGrantees(String dataPolicy, List<String> grantees) {
    RemoveGranteesRequest request =
        RemoveGranteesRequest.newBuilder()
            .setDataPolicy(dataPolicy)
            .addAllGrantees(grantees)
            .build();
    return removeGrantees(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes grantees from a data policy. The grantees will be removed from the existing grantees.
   * If the request contains a grantee that does not exist, the grantee will be ignored.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   RemoveGranteesRequest request =
   *       RemoveGranteesRequest.newBuilder()
   *           .setDataPolicy(
   *               DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString())
   *           .addAllGrantees(new ArrayList<String>())
   *           .build();
   *   DataPolicy response = dataPolicyServiceClient.removeGrantees(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataPolicy removeGrantees(RemoveGranteesRequest request) {
    return removeGranteesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes grantees from a data policy. The grantees will be removed from the existing grantees.
   * If the request contains a grantee that does not exist, the grantee will be ignored.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   RemoveGranteesRequest request =
   *       RemoveGranteesRequest.newBuilder()
   *           .setDataPolicy(
   *               DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString())
   *           .addAllGrantees(new ArrayList<String>())
   *           .build();
   *   ApiFuture<DataPolicy> future =
   *       dataPolicyServiceClient.removeGranteesCallable().futureCall(request);
   *   // Do something.
   *   DataPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveGranteesRequest, DataPolicy> removeGranteesCallable() {
    return stub.removeGranteesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the metadata for an existing data policy. The target data policy can be specified by
   * the resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   DataPolicy dataPolicy = DataPolicy.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DataPolicy response = dataPolicyServiceClient.updateDataPolicy(dataPolicy, updateMask);
   * }
   * }</pre>
   *
   * @param dataPolicy Required. Update the data policy's metadata.
   *     <p>The target data policy is determined by the `name` field. Other fields are updated to
   *     the specified values based on the field masks.
   * @param updateMask Optional. The update mask applies to the resource. For the `FieldMask`
   *     definition, see
   *     https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask If
   *     not set, defaults to all of the fields that are allowed to update.
   *     <p>Updates to the `name` and `dataPolicyId` fields are not allowed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataPolicy updateDataPolicy(DataPolicy dataPolicy, FieldMask updateMask) {
    UpdateDataPolicyRequest request =
        UpdateDataPolicyRequest.newBuilder()
            .setDataPolicy(dataPolicy)
            .setUpdateMask(updateMask)
            .build();
    return updateDataPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the metadata for an existing data policy. The target data policy can be specified by
   * the resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   UpdateDataPolicyRequest request =
   *       UpdateDataPolicyRequest.newBuilder()
   *           .setDataPolicy(DataPolicy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   DataPolicy response = dataPolicyServiceClient.updateDataPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataPolicy updateDataPolicy(UpdateDataPolicyRequest request) {
    return updateDataPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the metadata for an existing data policy. The target data policy can be specified by
   * the resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   UpdateDataPolicyRequest request =
   *       UpdateDataPolicyRequest.newBuilder()
   *           .setDataPolicy(DataPolicy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<DataPolicy> future =
   *       dataPolicyServiceClient.updateDataPolicyCallable().futureCall(request);
   *   // Do something.
   *   DataPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDataPolicyRequest, DataPolicy> updateDataPolicyCallable() {
    return stub.updateDataPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the data policy specified by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   DataPolicyName name = DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]");
   *   dataPolicyServiceClient.deleteDataPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the data policy to delete. Format is
   *     `projects/{project_number}/locations/{location_id}/dataPolicies/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataPolicy(DataPolicyName name) {
    DeleteDataPolicyRequest request =
        DeleteDataPolicyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteDataPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the data policy specified by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   String name = DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString();
   *   dataPolicyServiceClient.deleteDataPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the data policy to delete. Format is
   *     `projects/{project_number}/locations/{location_id}/dataPolicies/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataPolicy(String name) {
    DeleteDataPolicyRequest request = DeleteDataPolicyRequest.newBuilder().setName(name).build();
    deleteDataPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the data policy specified by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   DeleteDataPolicyRequest request =
   *       DeleteDataPolicyRequest.newBuilder()
   *           .setName(DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString())
   *           .build();
   *   dataPolicyServiceClient.deleteDataPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataPolicy(DeleteDataPolicyRequest request) {
    deleteDataPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the data policy specified by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   DeleteDataPolicyRequest request =
   *       DeleteDataPolicyRequest.newBuilder()
   *           .setName(DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       dataPolicyServiceClient.deleteDataPolicyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDataPolicyRequest, Empty> deleteDataPolicyCallable() {
    return stub.deleteDataPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the data policy specified by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   DataPolicyName name = DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]");
   *   DataPolicy response = dataPolicyServiceClient.getDataPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the requested data policy. Format is
   *     `projects/{project_number}/locations/{location_id}/dataPolicies/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataPolicy getDataPolicy(DataPolicyName name) {
    GetDataPolicyRequest request =
        GetDataPolicyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the data policy specified by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   String name = DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString();
   *   DataPolicy response = dataPolicyServiceClient.getDataPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the requested data policy. Format is
   *     `projects/{project_number}/locations/{location_id}/dataPolicies/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataPolicy getDataPolicy(String name) {
    GetDataPolicyRequest request = GetDataPolicyRequest.newBuilder().setName(name).build();
    return getDataPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the data policy specified by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   GetDataPolicyRequest request =
   *       GetDataPolicyRequest.newBuilder()
   *           .setName(DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString())
   *           .build();
   *   DataPolicy response = dataPolicyServiceClient.getDataPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataPolicy getDataPolicy(GetDataPolicyRequest request) {
    return getDataPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the data policy specified by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   GetDataPolicyRequest request =
   *       GetDataPolicyRequest.newBuilder()
   *           .setName(DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString())
   *           .build();
   *   ApiFuture<DataPolicy> future =
   *       dataPolicyServiceClient.getDataPolicyCallable().futureCall(request);
   *   // Do something.
   *   DataPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataPolicyRequest, DataPolicy> getDataPolicyCallable() {
    return stub.getDataPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all of the data policies in the specified parent project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (DataPolicy element : dataPolicyServiceClient.listDataPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the project for which to list data policies. Format is
   *     `projects/{project_number}/locations/{location_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataPoliciesPagedResponse listDataPolicies(LocationName parent) {
    ListDataPoliciesRequest request =
        ListDataPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDataPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all of the data policies in the specified parent project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (DataPolicy element : dataPolicyServiceClient.listDataPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the project for which to list data policies. Format is
   *     `projects/{project_number}/locations/{location_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataPoliciesPagedResponse listDataPolicies(String parent) {
    ListDataPoliciesRequest request =
        ListDataPoliciesRequest.newBuilder().setParent(parent).build();
    return listDataPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all of the data policies in the specified parent project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   ListDataPoliciesRequest request =
   *       ListDataPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (DataPolicy element : dataPolicyServiceClient.listDataPolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataPoliciesPagedResponse listDataPolicies(ListDataPoliciesRequest request) {
    return listDataPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all of the data policies in the specified parent project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   ListDataPoliciesRequest request =
   *       ListDataPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<DataPolicy> future =
   *       dataPolicyServiceClient.listDataPoliciesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DataPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDataPoliciesRequest, ListDataPoliciesPagedResponse>
      listDataPoliciesPagedCallable() {
    return stub.listDataPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all of the data policies in the specified parent project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   ListDataPoliciesRequest request =
   *       ListDataPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListDataPoliciesResponse response =
   *         dataPolicyServiceClient.listDataPoliciesCallable().call(request);
   *     for (DataPolicy element : response.getDataPoliciesList()) {
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
  public final UnaryCallable<ListDataPoliciesRequest, ListDataPoliciesResponse>
      listDataPoliciesCallable() {
    return stub.listDataPoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAM policy for the specified data policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = dataPolicyServiceClient.getIamPolicy(request);
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
   * Gets the IAM policy for the specified data policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = dataPolicyServiceClient.getIamPolicyCallable().futureCall(request);
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
   * Sets the IAM policy for the specified data policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = dataPolicyServiceClient.setIamPolicy(request);
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
   * Sets the IAM policy for the specified data policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = dataPolicyServiceClient.setIamPolicyCallable().futureCall(request);
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
   * Returns the caller's permission on the specified data policy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = dataPolicyServiceClient.testIamPermissions(request);
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
   * Returns the caller's permission on the specified data policy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       dataPolicyServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListDataPoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListDataPoliciesRequest,
          ListDataPoliciesResponse,
          DataPolicy,
          ListDataPoliciesPage,
          ListDataPoliciesFixedSizeCollection> {

    public static ApiFuture<ListDataPoliciesPagedResponse> createAsync(
        PageContext<ListDataPoliciesRequest, ListDataPoliciesResponse, DataPolicy> context,
        ApiFuture<ListDataPoliciesResponse> futureResponse) {
      ApiFuture<ListDataPoliciesPage> futurePage =
          ListDataPoliciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDataPoliciesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDataPoliciesPagedResponse(ListDataPoliciesPage page) {
      super(page, ListDataPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDataPoliciesPage
      extends AbstractPage<
          ListDataPoliciesRequest, ListDataPoliciesResponse, DataPolicy, ListDataPoliciesPage> {

    private ListDataPoliciesPage(
        PageContext<ListDataPoliciesRequest, ListDataPoliciesResponse, DataPolicy> context,
        ListDataPoliciesResponse response) {
      super(context, response);
    }

    private static ListDataPoliciesPage createEmptyPage() {
      return new ListDataPoliciesPage(null, null);
    }

    @Override
    protected ListDataPoliciesPage createPage(
        PageContext<ListDataPoliciesRequest, ListDataPoliciesResponse, DataPolicy> context,
        ListDataPoliciesResponse response) {
      return new ListDataPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListDataPoliciesPage> createPageAsync(
        PageContext<ListDataPoliciesRequest, ListDataPoliciesResponse, DataPolicy> context,
        ApiFuture<ListDataPoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDataPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDataPoliciesRequest,
          ListDataPoliciesResponse,
          DataPolicy,
          ListDataPoliciesPage,
          ListDataPoliciesFixedSizeCollection> {

    private ListDataPoliciesFixedSizeCollection(
        List<ListDataPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDataPoliciesFixedSizeCollection createEmptyCollection() {
      return new ListDataPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDataPoliciesFixedSizeCollection createCollection(
        List<ListDataPoliciesPage> pages, int collectionSize) {
      return new ListDataPoliciesFixedSizeCollection(pages, collectionSize);
    }
  }
}
