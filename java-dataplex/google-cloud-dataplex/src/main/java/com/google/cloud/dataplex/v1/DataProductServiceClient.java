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

package com.google.cloud.dataplex.v1;

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
import com.google.cloud.dataplex.v1.stub.DataProductServiceStub;
import com.google.cloud.dataplex.v1.stub.DataProductServiceStubSettings;
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
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: `DataProductService` provides APIs for managing data products and the
 * underlying data assets.
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
 * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
 *   DataProductName name = DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]");
 *   DataProduct response = dataProductServiceClient.getDataProduct(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DataProductServiceClient object to clean up resources
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
 *      <td><p> CreateDataProduct</td>
 *      <td><p> Creates a data product.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDataProductAsync(CreateDataProductRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createDataProductAsync(LocationName parent, DataProduct dataProduct, String dataProductId)
 *           <li><p> createDataProductAsync(String parent, DataProduct dataProduct, String dataProductId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDataProductOperationCallable()
 *           <li><p> createDataProductCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDataProduct</td>
 *      <td><p> Deletes a data product. The deletion will fail if the data product is not empty (i.e. contains at least one data asset).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDataProductAsync(DeleteDataProductRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteDataProductAsync(DataProductName name)
 *           <li><p> deleteDataProductAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDataProductOperationCallable()
 *           <li><p> deleteDataProductCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDataProduct</td>
 *      <td><p> Gets a data product.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDataProduct(GetDataProductRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDataProduct(DataProductName name)
 *           <li><p> getDataProduct(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDataProductCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDataProducts</td>
 *      <td><p> Lists data products for a given project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDataProducts(ListDataProductsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDataProducts(LocationName parent)
 *           <li><p> listDataProducts(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDataProductsPagedCallable()
 *           <li><p> listDataProductsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDataProduct</td>
 *      <td><p> Updates a data product.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDataProductAsync(UpdateDataProductRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateDataProductAsync(DataProduct dataProduct, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDataProductOperationCallable()
 *           <li><p> updateDataProductCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDataAsset</td>
 *      <td><p> Creates a data asset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDataAssetAsync(CreateDataAssetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createDataAssetAsync(DataProductName parent, DataAsset dataAsset, String dataAssetId)
 *           <li><p> createDataAssetAsync(String parent, DataAsset dataAsset, String dataAssetId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDataAssetOperationCallable()
 *           <li><p> createDataAssetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDataAsset</td>
 *      <td><p> Updates a data asset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDataAssetAsync(UpdateDataAssetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateDataAssetAsync(DataAsset dataAsset, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDataAssetOperationCallable()
 *           <li><p> updateDataAssetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDataAsset</td>
 *      <td><p> Deletes a data asset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDataAssetAsync(DeleteDataAssetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteDataAssetAsync(DataAssetName name)
 *           <li><p> deleteDataAssetAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDataAssetOperationCallable()
 *           <li><p> deleteDataAssetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDataAsset</td>
 *      <td><p> Gets a data asset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDataAsset(GetDataAssetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDataAsset(DataAssetName name)
 *           <li><p> getDataAsset(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDataAssetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDataAssets</td>
 *      <td><p> Lists data assets for a given data product.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDataAssets(ListDataAssetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDataAssets(DataProductName parent)
 *           <li><p> listDataAssets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDataAssetsPagedCallable()
 *           <li><p> listDataAssetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.This method can be called in two ways:
 * <p> &#42;   &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;   &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or other locations specifically visibleto the project.</td>
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
 * <p>This class can be customized by passing in a custom instance of DataProductServiceSettings to
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
 * DataProductServiceSettings dataProductServiceSettings =
 *     DataProductServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataProductServiceClient dataProductServiceClient =
 *     DataProductServiceClient.create(dataProductServiceSettings);
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
 * DataProductServiceSettings dataProductServiceSettings =
 *     DataProductServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataProductServiceClient dataProductServiceClient =
 *     DataProductServiceClient.create(dataProductServiceSettings);
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
 * DataProductServiceSettings dataProductServiceSettings =
 *     DataProductServiceSettings.newHttpJsonBuilder().build();
 * DataProductServiceClient dataProductServiceClient =
 *     DataProductServiceClient.create(dataProductServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DataProductServiceClient implements BackgroundResource {
  private final DataProductServiceSettings settings;
  private final DataProductServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of DataProductServiceClient with default settings. */
  public static final DataProductServiceClient create() throws IOException {
    return create(DataProductServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataProductServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DataProductServiceClient create(DataProductServiceSettings settings)
      throws IOException {
    return new DataProductServiceClient(settings);
  }

  /**
   * Constructs an instance of DataProductServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(DataProductServiceSettings).
   */
  public static final DataProductServiceClient create(DataProductServiceStub stub) {
    return new DataProductServiceClient(stub);
  }

  /**
   * Constructs an instance of DataProductServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DataProductServiceClient(DataProductServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DataProductServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected DataProductServiceClient(DataProductServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final DataProductServiceSettings getSettings() {
    return settings;
  }

  public DataProductServiceStub getStub() {
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
   * Creates a data product.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   DataProduct dataProduct = DataProduct.newBuilder().build();
   *   String dataProductId = "dataProductId1437828576";
   *   DataProduct response =
   *       dataProductServiceClient.createDataProductAsync(parent, dataProduct, dataProductId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this data product will be created. Format:
   *     projects/{project_id_or_number}/locations/{location_id}
   * @param dataProduct Required. The data product to create.
   * @param dataProductId Optional. The ID of the data product to create.
   *     <p>The ID must conform to RFC-1034 and contain only lower-case letters (a-z), numbers
   *     (0-9), or hyphens, with the first character a letter, the last a letter or a number, and a
   *     63 character maximum. Characters outside of ASCII are not permitted. Valid format regex:
   *     `^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$` If not provided, a system generated ID will be used.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataProduct, OperationMetadata> createDataProductAsync(
      LocationName parent, DataProduct dataProduct, String dataProductId) {
    CreateDataProductRequest request =
        CreateDataProductRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataProduct(dataProduct)
            .setDataProductId(dataProductId)
            .build();
    return createDataProductAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a data product.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   DataProduct dataProduct = DataProduct.newBuilder().build();
   *   String dataProductId = "dataProductId1437828576";
   *   DataProduct response =
   *       dataProductServiceClient.createDataProductAsync(parent, dataProduct, dataProductId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this data product will be created. Format:
   *     projects/{project_id_or_number}/locations/{location_id}
   * @param dataProduct Required. The data product to create.
   * @param dataProductId Optional. The ID of the data product to create.
   *     <p>The ID must conform to RFC-1034 and contain only lower-case letters (a-z), numbers
   *     (0-9), or hyphens, with the first character a letter, the last a letter or a number, and a
   *     63 character maximum. Characters outside of ASCII are not permitted. Valid format regex:
   *     `^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$` If not provided, a system generated ID will be used.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataProduct, OperationMetadata> createDataProductAsync(
      String parent, DataProduct dataProduct, String dataProductId) {
    CreateDataProductRequest request =
        CreateDataProductRequest.newBuilder()
            .setParent(parent)
            .setDataProduct(dataProduct)
            .setDataProductId(dataProductId)
            .build();
    return createDataProductAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a data product.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   CreateDataProductRequest request =
   *       CreateDataProductRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataProductId("dataProductId1437828576")
   *           .setDataProduct(DataProduct.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   DataProduct response = dataProductServiceClient.createDataProductAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataProduct, OperationMetadata> createDataProductAsync(
      CreateDataProductRequest request) {
    return createDataProductOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a data product.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   CreateDataProductRequest request =
   *       CreateDataProductRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataProductId("dataProductId1437828576")
   *           .setDataProduct(DataProduct.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<DataProduct, OperationMetadata> future =
   *       dataProductServiceClient.createDataProductOperationCallable().futureCall(request);
   *   // Do something.
   *   DataProduct response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateDataProductRequest, DataProduct, OperationMetadata>
      createDataProductOperationCallable() {
    return stub.createDataProductOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a data product.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   CreateDataProductRequest request =
   *       CreateDataProductRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataProductId("dataProductId1437828576")
   *           .setDataProduct(DataProduct.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataProductServiceClient.createDataProductCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDataProductRequest, Operation> createDataProductCallable() {
    return stub.createDataProductCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a data product. The deletion will fail if the data product is not empty (i.e. contains
   * at least one data asset).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   DataProductName name = DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]");
   *   dataProductServiceClient.deleteDataProductAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the data product to delete. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/dataProducts/{data_product_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDataProductAsync(
      DataProductName name) {
    DeleteDataProductRequest request =
        DeleteDataProductRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteDataProductAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a data product. The deletion will fail if the data product is not empty (i.e. contains
   * at least one data asset).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   String name = DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]").toString();
   *   dataProductServiceClient.deleteDataProductAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the data product to delete. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/dataProducts/{data_product_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDataProductAsync(String name) {
    DeleteDataProductRequest request = DeleteDataProductRequest.newBuilder().setName(name).build();
    return deleteDataProductAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a data product. The deletion will fail if the data product is not empty (i.e. contains
   * at least one data asset).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   DeleteDataProductRequest request =
   *       DeleteDataProductRequest.newBuilder()
   *           .setName(DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]").toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .build();
   *   dataProductServiceClient.deleteDataProductAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDataProductAsync(
      DeleteDataProductRequest request) {
    return deleteDataProductOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a data product. The deletion will fail if the data product is not empty (i.e. contains
   * at least one data asset).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   DeleteDataProductRequest request =
   *       DeleteDataProductRequest.newBuilder()
   *           .setName(DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]").toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       dataProductServiceClient.deleteDataProductOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDataProductRequest, Empty, OperationMetadata>
      deleteDataProductOperationCallable() {
    return stub.deleteDataProductOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a data product. The deletion will fail if the data product is not empty (i.e. contains
   * at least one data asset).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   DeleteDataProductRequest request =
   *       DeleteDataProductRequest.newBuilder()
   *           .setName(DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]").toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataProductServiceClient.deleteDataProductCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDataProductRequest, Operation> deleteDataProductCallable() {
    return stub.deleteDataProductCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a data product.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   DataProductName name = DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]");
   *   DataProduct response = dataProductServiceClient.getDataProduct(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the data product to retrieve. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/dataProducts/{data_product_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataProduct getDataProduct(DataProductName name) {
    GetDataProductRequest request =
        GetDataProductRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a data product.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   String name = DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]").toString();
   *   DataProduct response = dataProductServiceClient.getDataProduct(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the data product to retrieve. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/dataProducts/{data_product_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataProduct getDataProduct(String name) {
    GetDataProductRequest request = GetDataProductRequest.newBuilder().setName(name).build();
    return getDataProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a data product.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   GetDataProductRequest request =
   *       GetDataProductRequest.newBuilder()
   *           .setName(DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]").toString())
   *           .build();
   *   DataProduct response = dataProductServiceClient.getDataProduct(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataProduct getDataProduct(GetDataProductRequest request) {
    return getDataProductCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a data product.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   GetDataProductRequest request =
   *       GetDataProductRequest.newBuilder()
   *           .setName(DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]").toString())
   *           .build();
   *   ApiFuture<DataProduct> future =
   *       dataProductServiceClient.getDataProductCallable().futureCall(request);
   *   // Do something.
   *   DataProduct response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataProductRequest, DataProduct> getDataProductCallable() {
    return stub.getDataProductCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists data products for a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (DataProduct element : dataProductServiceClient.listDataProducts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which has this collection of data products.
   *     <p>Format: `projects/{project_id_or_number}/locations/{location_id}`.
   *     <p>Supports listing across all locations with the wildcard `-` (hyphen) character. Example:
   *     `projects/{project_id_or_number}/locations/-`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataProductsPagedResponse listDataProducts(LocationName parent) {
    ListDataProductsRequest request =
        ListDataProductsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDataProducts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists data products for a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (DataProduct element : dataProductServiceClient.listDataProducts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which has this collection of data products.
   *     <p>Format: `projects/{project_id_or_number}/locations/{location_id}`.
   *     <p>Supports listing across all locations with the wildcard `-` (hyphen) character. Example:
   *     `projects/{project_id_or_number}/locations/-`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataProductsPagedResponse listDataProducts(String parent) {
    ListDataProductsRequest request =
        ListDataProductsRequest.newBuilder().setParent(parent).build();
    return listDataProducts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists data products for a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   ListDataProductsRequest request =
   *       ListDataProductsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (DataProduct element : dataProductServiceClient.listDataProducts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataProductsPagedResponse listDataProducts(ListDataProductsRequest request) {
    return listDataProductsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists data products for a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   ListDataProductsRequest request =
   *       ListDataProductsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<DataProduct> future =
   *       dataProductServiceClient.listDataProductsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DataProduct element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDataProductsRequest, ListDataProductsPagedResponse>
      listDataProductsPagedCallable() {
    return stub.listDataProductsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists data products for a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   ListDataProductsRequest request =
   *       ListDataProductsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDataProductsResponse response =
   *         dataProductServiceClient.listDataProductsCallable().call(request);
   *     for (DataProduct element : response.getDataProductsList()) {
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
  public final UnaryCallable<ListDataProductsRequest, ListDataProductsResponse>
      listDataProductsCallable() {
    return stub.listDataProductsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a data product.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   DataProduct dataProduct = DataProduct.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DataProduct response =
   *       dataProductServiceClient.updateDataProductAsync(dataProduct, updateMask).get();
   * }
   * }</pre>
   *
   * @param dataProduct Required. The data product to update. The data product's `name` field is
   *     used to identify the data product to update.
   * @param updateMask Optional. The list of fields to update. If this is empty or not set, then all
   *     the fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataProduct, OperationMetadata> updateDataProductAsync(
      DataProduct dataProduct, FieldMask updateMask) {
    UpdateDataProductRequest request =
        UpdateDataProductRequest.newBuilder()
            .setDataProduct(dataProduct)
            .setUpdateMask(updateMask)
            .build();
    return updateDataProductAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a data product.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   UpdateDataProductRequest request =
   *       UpdateDataProductRequest.newBuilder()
   *           .setDataProduct(DataProduct.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   DataProduct response = dataProductServiceClient.updateDataProductAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataProduct, OperationMetadata> updateDataProductAsync(
      UpdateDataProductRequest request) {
    return updateDataProductOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a data product.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   UpdateDataProductRequest request =
   *       UpdateDataProductRequest.newBuilder()
   *           .setDataProduct(DataProduct.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<DataProduct, OperationMetadata> future =
   *       dataProductServiceClient.updateDataProductOperationCallable().futureCall(request);
   *   // Do something.
   *   DataProduct response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateDataProductRequest, DataProduct, OperationMetadata>
      updateDataProductOperationCallable() {
    return stub.updateDataProductOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a data product.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   UpdateDataProductRequest request =
   *       UpdateDataProductRequest.newBuilder()
   *           .setDataProduct(DataProduct.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataProductServiceClient.updateDataProductCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDataProductRequest, Operation> updateDataProductCallable() {
    return stub.updateDataProductCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a data asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   DataProductName parent = DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]");
   *   DataAsset dataAsset = DataAsset.newBuilder().build();
   *   String dataAssetId = "dataAssetId2108984609";
   *   DataAsset response =
   *       dataProductServiceClient.createDataAssetAsync(parent, dataAsset, dataAssetId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this data asset will be created. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/dataProducts/{data_product_id}
   * @param dataAsset Required. The data asset to create.
   * @param dataAssetId Optional. The ID of the data asset to create.
   *     <p>The ID must conform to RFC-1034 and contain only lower-case letters (a-z), numbers
   *     (0-9), or hyphens, with the first character a letter, the last a letter or a number, and a
   *     63 character maximum. Characters outside of ASCII are not permitted. Valid format regex:
   *     `^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$` If not provided, a system generated ID will be used.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataAsset, OperationMetadata> createDataAssetAsync(
      DataProductName parent, DataAsset dataAsset, String dataAssetId) {
    CreateDataAssetRequest request =
        CreateDataAssetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataAsset(dataAsset)
            .setDataAssetId(dataAssetId)
            .build();
    return createDataAssetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a data asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   String parent = DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]").toString();
   *   DataAsset dataAsset = DataAsset.newBuilder().build();
   *   String dataAssetId = "dataAssetId2108984609";
   *   DataAsset response =
   *       dataProductServiceClient.createDataAssetAsync(parent, dataAsset, dataAssetId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this data asset will be created. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/dataProducts/{data_product_id}
   * @param dataAsset Required. The data asset to create.
   * @param dataAssetId Optional. The ID of the data asset to create.
   *     <p>The ID must conform to RFC-1034 and contain only lower-case letters (a-z), numbers
   *     (0-9), or hyphens, with the first character a letter, the last a letter or a number, and a
   *     63 character maximum. Characters outside of ASCII are not permitted. Valid format regex:
   *     `^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$` If not provided, a system generated ID will be used.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataAsset, OperationMetadata> createDataAssetAsync(
      String parent, DataAsset dataAsset, String dataAssetId) {
    CreateDataAssetRequest request =
        CreateDataAssetRequest.newBuilder()
            .setParent(parent)
            .setDataAsset(dataAsset)
            .setDataAssetId(dataAssetId)
            .build();
    return createDataAssetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a data asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   CreateDataAssetRequest request =
   *       CreateDataAssetRequest.newBuilder()
   *           .setParent(DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]").toString())
   *           .setDataAssetId("dataAssetId2108984609")
   *           .setDataAsset(DataAsset.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   DataAsset response = dataProductServiceClient.createDataAssetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataAsset, OperationMetadata> createDataAssetAsync(
      CreateDataAssetRequest request) {
    return createDataAssetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a data asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   CreateDataAssetRequest request =
   *       CreateDataAssetRequest.newBuilder()
   *           .setParent(DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]").toString())
   *           .setDataAssetId("dataAssetId2108984609")
   *           .setDataAsset(DataAsset.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<DataAsset, OperationMetadata> future =
   *       dataProductServiceClient.createDataAssetOperationCallable().futureCall(request);
   *   // Do something.
   *   DataAsset response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateDataAssetRequest, DataAsset, OperationMetadata>
      createDataAssetOperationCallable() {
    return stub.createDataAssetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a data asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   CreateDataAssetRequest request =
   *       CreateDataAssetRequest.newBuilder()
   *           .setParent(DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]").toString())
   *           .setDataAssetId("dataAssetId2108984609")
   *           .setDataAsset(DataAsset.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataProductServiceClient.createDataAssetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDataAssetRequest, Operation> createDataAssetCallable() {
    return stub.createDataAssetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a data asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   DataAsset dataAsset = DataAsset.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DataAsset response =
   *       dataProductServiceClient.updateDataAssetAsync(dataAsset, updateMask).get();
   * }
   * }</pre>
   *
   * @param dataAsset Required. The data asset to update. The data asset's `name` field is used to
   *     identify the data asset to update.
   * @param updateMask Optional. The list of fields to update. If this is empty or not set, then all
   *     the fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataAsset, OperationMetadata> updateDataAssetAsync(
      DataAsset dataAsset, FieldMask updateMask) {
    UpdateDataAssetRequest request =
        UpdateDataAssetRequest.newBuilder()
            .setDataAsset(dataAsset)
            .setUpdateMask(updateMask)
            .build();
    return updateDataAssetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a data asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   UpdateDataAssetRequest request =
   *       UpdateDataAssetRequest.newBuilder()
   *           .setDataAsset(DataAsset.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   DataAsset response = dataProductServiceClient.updateDataAssetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataAsset, OperationMetadata> updateDataAssetAsync(
      UpdateDataAssetRequest request) {
    return updateDataAssetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a data asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   UpdateDataAssetRequest request =
   *       UpdateDataAssetRequest.newBuilder()
   *           .setDataAsset(DataAsset.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<DataAsset, OperationMetadata> future =
   *       dataProductServiceClient.updateDataAssetOperationCallable().futureCall(request);
   *   // Do something.
   *   DataAsset response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateDataAssetRequest, DataAsset, OperationMetadata>
      updateDataAssetOperationCallable() {
    return stub.updateDataAssetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a data asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   UpdateDataAssetRequest request =
   *       UpdateDataAssetRequest.newBuilder()
   *           .setDataAsset(DataAsset.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataProductServiceClient.updateDataAssetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDataAssetRequest, Operation> updateDataAssetCallable() {
    return stub.updateDataAssetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a data asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   DataAssetName name =
   *       DataAssetName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]", "[DATA_ASSET]");
   *   dataProductServiceClient.deleteDataAssetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the data asset to delete. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/dataProducts/{data_product_id}/dataAssets/{data_asset_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDataAssetAsync(DataAssetName name) {
    DeleteDataAssetRequest request =
        DeleteDataAssetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteDataAssetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a data asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   String name =
   *       DataAssetName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]", "[DATA_ASSET]").toString();
   *   dataProductServiceClient.deleteDataAssetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the data asset to delete. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/dataProducts/{data_product_id}/dataAssets/{data_asset_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDataAssetAsync(String name) {
    DeleteDataAssetRequest request = DeleteDataAssetRequest.newBuilder().setName(name).build();
    return deleteDataAssetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a data asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   DeleteDataAssetRequest request =
   *       DeleteDataAssetRequest.newBuilder()
   *           .setName(
   *               DataAssetName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]", "[DATA_ASSET]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .build();
   *   dataProductServiceClient.deleteDataAssetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDataAssetAsync(
      DeleteDataAssetRequest request) {
    return deleteDataAssetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a data asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   DeleteDataAssetRequest request =
   *       DeleteDataAssetRequest.newBuilder()
   *           .setName(
   *               DataAssetName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]", "[DATA_ASSET]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       dataProductServiceClient.deleteDataAssetOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDataAssetRequest, Empty, OperationMetadata>
      deleteDataAssetOperationCallable() {
    return stub.deleteDataAssetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a data asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   DeleteDataAssetRequest request =
   *       DeleteDataAssetRequest.newBuilder()
   *           .setName(
   *               DataAssetName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]", "[DATA_ASSET]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataProductServiceClient.deleteDataAssetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDataAssetRequest, Operation> deleteDataAssetCallable() {
    return stub.deleteDataAssetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a data asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   DataAssetName name =
   *       DataAssetName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]", "[DATA_ASSET]");
   *   DataAsset response = dataProductServiceClient.getDataAsset(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the data asset to retrieve. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/dataProducts/{data_product_id}/dataAssets/{data_asset_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAsset getDataAsset(DataAssetName name) {
    GetDataAssetRequest request =
        GetDataAssetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataAsset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a data asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   String name =
   *       DataAssetName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]", "[DATA_ASSET]").toString();
   *   DataAsset response = dataProductServiceClient.getDataAsset(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the data asset to retrieve. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/dataProducts/{data_product_id}/dataAssets/{data_asset_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAsset getDataAsset(String name) {
    GetDataAssetRequest request = GetDataAssetRequest.newBuilder().setName(name).build();
    return getDataAsset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a data asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   GetDataAssetRequest request =
   *       GetDataAssetRequest.newBuilder()
   *           .setName(
   *               DataAssetName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]", "[DATA_ASSET]")
   *                   .toString())
   *           .build();
   *   DataAsset response = dataProductServiceClient.getDataAsset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAsset getDataAsset(GetDataAssetRequest request) {
    return getDataAssetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a data asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   GetDataAssetRequest request =
   *       GetDataAssetRequest.newBuilder()
   *           .setName(
   *               DataAssetName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]", "[DATA_ASSET]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DataAsset> future =
   *       dataProductServiceClient.getDataAssetCallable().futureCall(request);
   *   // Do something.
   *   DataAsset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataAssetRequest, DataAsset> getDataAssetCallable() {
    return stub.getDataAssetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists data assets for a given data product.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   DataProductName parent = DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]");
   *   for (DataAsset element : dataProductServiceClient.listDataAssets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which has this collection of data assets. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/dataProducts/{data_product_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataAssetsPagedResponse listDataAssets(DataProductName parent) {
    ListDataAssetsRequest request =
        ListDataAssetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDataAssets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists data assets for a given data product.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   String parent = DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]").toString();
   *   for (DataAsset element : dataProductServiceClient.listDataAssets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which has this collection of data assets. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/dataProducts/{data_product_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataAssetsPagedResponse listDataAssets(String parent) {
    ListDataAssetsRequest request = ListDataAssetsRequest.newBuilder().setParent(parent).build();
    return listDataAssets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists data assets for a given data product.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   ListDataAssetsRequest request =
   *       ListDataAssetsRequest.newBuilder()
   *           .setParent(DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DataAsset element : dataProductServiceClient.listDataAssets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataAssetsPagedResponse listDataAssets(ListDataAssetsRequest request) {
    return listDataAssetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists data assets for a given data product.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   ListDataAssetsRequest request =
   *       ListDataAssetsRequest.newBuilder()
   *           .setParent(DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DataAsset> future =
   *       dataProductServiceClient.listDataAssetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DataAsset element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDataAssetsRequest, ListDataAssetsPagedResponse>
      listDataAssetsPagedCallable() {
    return stub.listDataAssetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists data assets for a given data product.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   ListDataAssetsRequest request =
   *       ListDataAssetsRequest.newBuilder()
   *           .setParent(DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDataAssetsResponse response =
   *         dataProductServiceClient.listDataAssetsCallable().call(request);
   *     for (DataAsset element : response.getDataAssetsList()) {
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
  public final UnaryCallable<ListDataAssetsRequest, ListDataAssetsResponse>
      listDataAssetsCallable() {
    return stub.listDataAssetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.This method can be called in
   * two ways:
   *
   * <p>&#42; &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;
   * &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET
   * /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or
   * other locations specifically visibleto the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : dataProductServiceClient.listLocations(request).iterateAll()) {
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
   * Lists information about the supported locations for this service.This method can be called in
   * two ways:
   *
   * <p>&#42; &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;
   * &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET
   * /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or
   * other locations specifically visibleto the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       dataProductServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * Lists information about the supported locations for this service.This method can be called in
   * two ways:
   *
   * <p>&#42; &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;
   * &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET
   * /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or
   * other locations specifically visibleto the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         dataProductServiceClient.listLocationsCallable().call(request);
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
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = dataProductServiceClient.getLocation(request);
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
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       dataProductServiceClient.getLocationCallable().futureCall(request);
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
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = dataProductServiceClient.setIamPolicy(request);
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
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       dataProductServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = dataProductServiceClient.getIamPolicy(request);
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
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       dataProductServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = dataProductServiceClient.testIamPermissions(request);
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
   * try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       dataProductServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListDataProductsPagedResponse
      extends AbstractPagedListResponse<
          ListDataProductsRequest,
          ListDataProductsResponse,
          DataProduct,
          ListDataProductsPage,
          ListDataProductsFixedSizeCollection> {

    public static ApiFuture<ListDataProductsPagedResponse> createAsync(
        PageContext<ListDataProductsRequest, ListDataProductsResponse, DataProduct> context,
        ApiFuture<ListDataProductsResponse> futureResponse) {
      ApiFuture<ListDataProductsPage> futurePage =
          ListDataProductsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDataProductsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDataProductsPagedResponse(ListDataProductsPage page) {
      super(page, ListDataProductsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDataProductsPage
      extends AbstractPage<
          ListDataProductsRequest, ListDataProductsResponse, DataProduct, ListDataProductsPage> {

    private ListDataProductsPage(
        PageContext<ListDataProductsRequest, ListDataProductsResponse, DataProduct> context,
        ListDataProductsResponse response) {
      super(context, response);
    }

    private static ListDataProductsPage createEmptyPage() {
      return new ListDataProductsPage(null, null);
    }

    @Override
    protected ListDataProductsPage createPage(
        PageContext<ListDataProductsRequest, ListDataProductsResponse, DataProduct> context,
        ListDataProductsResponse response) {
      return new ListDataProductsPage(context, response);
    }

    @Override
    public ApiFuture<ListDataProductsPage> createPageAsync(
        PageContext<ListDataProductsRequest, ListDataProductsResponse, DataProduct> context,
        ApiFuture<ListDataProductsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDataProductsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDataProductsRequest,
          ListDataProductsResponse,
          DataProduct,
          ListDataProductsPage,
          ListDataProductsFixedSizeCollection> {

    private ListDataProductsFixedSizeCollection(
        List<ListDataProductsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDataProductsFixedSizeCollection createEmptyCollection() {
      return new ListDataProductsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDataProductsFixedSizeCollection createCollection(
        List<ListDataProductsPage> pages, int collectionSize) {
      return new ListDataProductsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDataAssetsPagedResponse
      extends AbstractPagedListResponse<
          ListDataAssetsRequest,
          ListDataAssetsResponse,
          DataAsset,
          ListDataAssetsPage,
          ListDataAssetsFixedSizeCollection> {

    public static ApiFuture<ListDataAssetsPagedResponse> createAsync(
        PageContext<ListDataAssetsRequest, ListDataAssetsResponse, DataAsset> context,
        ApiFuture<ListDataAssetsResponse> futureResponse) {
      ApiFuture<ListDataAssetsPage> futurePage =
          ListDataAssetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDataAssetsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDataAssetsPagedResponse(ListDataAssetsPage page) {
      super(page, ListDataAssetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDataAssetsPage
      extends AbstractPage<
          ListDataAssetsRequest, ListDataAssetsResponse, DataAsset, ListDataAssetsPage> {

    private ListDataAssetsPage(
        PageContext<ListDataAssetsRequest, ListDataAssetsResponse, DataAsset> context,
        ListDataAssetsResponse response) {
      super(context, response);
    }

    private static ListDataAssetsPage createEmptyPage() {
      return new ListDataAssetsPage(null, null);
    }

    @Override
    protected ListDataAssetsPage createPage(
        PageContext<ListDataAssetsRequest, ListDataAssetsResponse, DataAsset> context,
        ListDataAssetsResponse response) {
      return new ListDataAssetsPage(context, response);
    }

    @Override
    public ApiFuture<ListDataAssetsPage> createPageAsync(
        PageContext<ListDataAssetsRequest, ListDataAssetsResponse, DataAsset> context,
        ApiFuture<ListDataAssetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDataAssetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDataAssetsRequest,
          ListDataAssetsResponse,
          DataAsset,
          ListDataAssetsPage,
          ListDataAssetsFixedSizeCollection> {

    private ListDataAssetsFixedSizeCollection(List<ListDataAssetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDataAssetsFixedSizeCollection createEmptyCollection() {
      return new ListDataAssetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDataAssetsFixedSizeCollection createCollection(
        List<ListDataAssetsPage> pages, int collectionSize) {
      return new ListDataAssetsFixedSizeCollection(pages, collectionSize);
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
