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

package com.google.cloud.aiplatform.v1beta1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.stub.DatasetServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.DatasetServiceStubSettings;
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
 * Service Description: The service that manages Vertex AI Dataset and its child resources.
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
 * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
 *   DatasetName name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
 *   Dataset response = datasetServiceClient.getDataset(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DatasetServiceClient object to clean up resources such
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
 *      <td><p> CreateDataset</td>
 *      <td><p> Creates a Dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDatasetAsync(CreateDatasetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createDatasetAsync(LocationName parent, Dataset dataset)
 *           <li><p> createDatasetAsync(String parent, Dataset dataset)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDatasetOperationCallable()
 *           <li><p> createDatasetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDataset</td>
 *      <td><p> Gets a Dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDataset(GetDatasetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDataset(DatasetName name)
 *           <li><p> getDataset(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDatasetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDataset</td>
 *      <td><p> Updates a Dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDataset(UpdateDatasetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDataset(Dataset dataset, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDatasetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDatasets</td>
 *      <td><p> Lists Datasets in a Location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDatasets(ListDatasetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDatasets(LocationName parent)
 *           <li><p> listDatasets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDatasetsPagedCallable()
 *           <li><p> listDatasetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDataset</td>
 *      <td><p> Deletes a Dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDatasetAsync(DeleteDatasetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteDatasetAsync(DatasetName name)
 *           <li><p> deleteDatasetAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDatasetOperationCallable()
 *           <li><p> deleteDatasetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ImportData</td>
 *      <td><p> Imports data into a Dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> importDataAsync(ImportDataRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> importDataAsync(DatasetName name, List&lt;ImportDataConfig&gt; importConfigs)
 *           <li><p> importDataAsync(String name, List&lt;ImportDataConfig&gt; importConfigs)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> importDataOperationCallable()
 *           <li><p> importDataCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportData</td>
 *      <td><p> Exports data from a Dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportDataAsync(ExportDataRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> exportDataAsync(DatasetName name, ExportDataConfig exportConfig)
 *           <li><p> exportDataAsync(String name, ExportDataConfig exportConfig)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportDataOperationCallable()
 *           <li><p> exportDataCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDatasetVersion</td>
 *      <td><p> Create a version from a Dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDatasetVersionAsync(CreateDatasetVersionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createDatasetVersionAsync(DatasetName parent, DatasetVersion datasetVersion)
 *           <li><p> createDatasetVersionAsync(String parent, DatasetVersion datasetVersion)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDatasetVersionOperationCallable()
 *           <li><p> createDatasetVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDatasetVersion</td>
 *      <td><p> Updates a DatasetVersion.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDatasetVersion(UpdateDatasetVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDatasetVersion(DatasetVersion datasetVersion, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDatasetVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDatasetVersion</td>
 *      <td><p> Deletes a Dataset version.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDatasetVersionAsync(DeleteDatasetVersionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteDatasetVersionAsync(DatasetVersionName name)
 *           <li><p> deleteDatasetVersionAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDatasetVersionOperationCallable()
 *           <li><p> deleteDatasetVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDatasetVersion</td>
 *      <td><p> Gets a Dataset version.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDatasetVersion(GetDatasetVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDatasetVersion(DatasetVersionName name)
 *           <li><p> getDatasetVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDatasetVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDatasetVersions</td>
 *      <td><p> Lists DatasetVersions in a Dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDatasetVersions(ListDatasetVersionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDatasetVersions(DatasetName parent)
 *           <li><p> listDatasetVersions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDatasetVersionsPagedCallable()
 *           <li><p> listDatasetVersionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RestoreDatasetVersion</td>
 *      <td><p> Restores a dataset version.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> restoreDatasetVersionAsync(RestoreDatasetVersionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> restoreDatasetVersionAsync(DatasetVersionName name)
 *           <li><p> restoreDatasetVersionAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> restoreDatasetVersionOperationCallable()
 *           <li><p> restoreDatasetVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDataItems</td>
 *      <td><p> Lists DataItems in a Dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDataItems(ListDataItemsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDataItems(DatasetName parent)
 *           <li><p> listDataItems(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDataItemsPagedCallable()
 *           <li><p> listDataItemsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchDataItems</td>
 *      <td><p> Searches DataItems in a Dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchDataItems(SearchDataItemsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchDataItemsPagedCallable()
 *           <li><p> searchDataItemsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSavedQueries</td>
 *      <td><p> Lists SavedQueries in a Dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSavedQueries(ListSavedQueriesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSavedQueries(DatasetName parent)
 *           <li><p> listSavedQueries(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSavedQueriesPagedCallable()
 *           <li><p> listSavedQueriesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSavedQuery</td>
 *      <td><p> Deletes a SavedQuery.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSavedQueryAsync(DeleteSavedQueryRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteSavedQueryAsync(SavedQueryName name)
 *           <li><p> deleteSavedQueryAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSavedQueryOperationCallable()
 *           <li><p> deleteSavedQueryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAnnotationSpec</td>
 *      <td><p> Gets an AnnotationSpec.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAnnotationSpec(GetAnnotationSpecRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAnnotationSpec(AnnotationSpecName name)
 *           <li><p> getAnnotationSpec(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAnnotationSpecCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAnnotations</td>
 *      <td><p> Lists Annotations belongs to a dataitem</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAnnotations(ListAnnotationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAnnotations(DataItemName parent)
 *           <li><p> listAnnotations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAnnotationsPagedCallable()
 *           <li><p> listAnnotationsCallable()
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
 * <p>This class can be customized by passing in a custom instance of DatasetServiceSettings to
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
 * DatasetServiceSettings datasetServiceSettings =
 *     DatasetServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DatasetServiceClient datasetServiceClient = DatasetServiceClient.create(datasetServiceSettings);
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
 * DatasetServiceSettings datasetServiceSettings =
 *     DatasetServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DatasetServiceClient datasetServiceClient = DatasetServiceClient.create(datasetServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DatasetServiceClient implements BackgroundResource {
  private final DatasetServiceSettings settings;
  private final DatasetServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of DatasetServiceClient with default settings. */
  public static final DatasetServiceClient create() throws IOException {
    return create(DatasetServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DatasetServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DatasetServiceClient create(DatasetServiceSettings settings)
      throws IOException {
    return new DatasetServiceClient(settings);
  }

  /**
   * Constructs an instance of DatasetServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(DatasetServiceSettings).
   */
  public static final DatasetServiceClient create(DatasetServiceStub stub) {
    return new DatasetServiceClient(stub);
  }

  /**
   * Constructs an instance of DatasetServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DatasetServiceClient(DatasetServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DatasetServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected DatasetServiceClient(DatasetServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final DatasetServiceSettings getSettings() {
    return settings;
  }

  public DatasetServiceStub getStub() {
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
   * Creates a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Dataset dataset = Dataset.newBuilder().build();
   *   Dataset response = datasetServiceClient.createDatasetAsync(parent, dataset).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the Dataset in. Format:
   *     `projects/{project}/locations/{location}`
   * @param dataset Required. The Dataset to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Dataset, CreateDatasetOperationMetadata> createDatasetAsync(
      LocationName parent, Dataset dataset) {
    CreateDatasetRequest request =
        CreateDatasetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataset(dataset)
            .build();
    return createDatasetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Dataset dataset = Dataset.newBuilder().build();
   *   Dataset response = datasetServiceClient.createDatasetAsync(parent, dataset).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the Dataset in. Format:
   *     `projects/{project}/locations/{location}`
   * @param dataset Required. The Dataset to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Dataset, CreateDatasetOperationMetadata> createDatasetAsync(
      String parent, Dataset dataset) {
    CreateDatasetRequest request =
        CreateDatasetRequest.newBuilder().setParent(parent).setDataset(dataset).build();
    return createDatasetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   CreateDatasetRequest request =
   *       CreateDatasetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataset(Dataset.newBuilder().build())
   *           .build();
   *   Dataset response = datasetServiceClient.createDatasetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Dataset, CreateDatasetOperationMetadata> createDatasetAsync(
      CreateDatasetRequest request) {
    return createDatasetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   CreateDatasetRequest request =
   *       CreateDatasetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataset(Dataset.newBuilder().build())
   *           .build();
   *   OperationFuture<Dataset, CreateDatasetOperationMetadata> future =
   *       datasetServiceClient.createDatasetOperationCallable().futureCall(request);
   *   // Do something.
   *   Dataset response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateDatasetRequest, Dataset, CreateDatasetOperationMetadata>
      createDatasetOperationCallable() {
    return stub.createDatasetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   CreateDatasetRequest request =
   *       CreateDatasetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataset(Dataset.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       datasetServiceClient.createDatasetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDatasetRequest, Operation> createDatasetCallable() {
    return stub.createDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   DatasetName name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
   *   Dataset response = datasetServiceClient.getDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Dataset resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset getDataset(DatasetName name) {
    GetDatasetRequest request =
        GetDatasetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   String name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString();
   *   Dataset response = datasetServiceClient.getDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Dataset resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset getDataset(String name) {
    GetDatasetRequest request = GetDatasetRequest.newBuilder().setName(name).build();
    return getDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   GetDatasetRequest request =
   *       GetDatasetRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   Dataset response = datasetServiceClient.getDataset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset getDataset(GetDatasetRequest request) {
    return getDatasetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   GetDatasetRequest request =
   *       GetDatasetRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Dataset> future = datasetServiceClient.getDatasetCallable().futureCall(request);
   *   // Do something.
   *   Dataset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable() {
    return stub.getDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   Dataset dataset = Dataset.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Dataset response = datasetServiceClient.updateDataset(dataset, updateMask);
   * }
   * }</pre>
   *
   * @param dataset Required. The Dataset which replaces the resource on the server.
   * @param updateMask Required. The update mask applies to the resource. For the `FieldMask`
   *     definition, see [google.protobuf.FieldMask][google.protobuf.FieldMask]. Updatable fields:
   *     <p>&#42; `display_name` &#42; `description` &#42; `labels`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset updateDataset(Dataset dataset, FieldMask updateMask) {
    UpdateDatasetRequest request =
        UpdateDatasetRequest.newBuilder().setDataset(dataset).setUpdateMask(updateMask).build();
    return updateDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   UpdateDatasetRequest request =
   *       UpdateDatasetRequest.newBuilder()
   *           .setDataset(Dataset.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Dataset response = datasetServiceClient.updateDataset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset updateDataset(UpdateDatasetRequest request) {
    return updateDatasetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   UpdateDatasetRequest request =
   *       UpdateDatasetRequest.newBuilder()
   *           .setDataset(Dataset.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Dataset> future = datasetServiceClient.updateDatasetCallable().futureCall(request);
   *   // Do something.
   *   Dataset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDatasetRequest, Dataset> updateDatasetCallable() {
    return stub.updateDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Datasets in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Dataset element : datasetServiceClient.listDatasets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the Dataset's parent resource. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetsPagedResponse listDatasets(LocationName parent) {
    ListDatasetsRequest request =
        ListDatasetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDatasets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Datasets in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Dataset element : datasetServiceClient.listDatasets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the Dataset's parent resource. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetsPagedResponse listDatasets(String parent) {
    ListDatasetsRequest request = ListDatasetsRequest.newBuilder().setParent(parent).build();
    return listDatasets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Datasets in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   ListDatasetsRequest request =
   *       ListDatasetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Dataset element : datasetServiceClient.listDatasets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetsPagedResponse listDatasets(ListDatasetsRequest request) {
    return listDatasetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Datasets in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   ListDatasetsRequest request =
   *       ListDatasetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Dataset> future =
   *       datasetServiceClient.listDatasetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Dataset element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse>
      listDatasetsPagedCallable() {
    return stub.listDatasetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Datasets in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   ListDatasetsRequest request =
   *       ListDatasetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDatasetsResponse response = datasetServiceClient.listDatasetsCallable().call(request);
   *     for (Dataset element : response.getDatasetsList()) {
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
  public final UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable() {
    return stub.listDatasetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   DatasetName name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
   *   datasetServiceClient.deleteDatasetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Dataset to delete. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteDatasetAsync(
      DatasetName name) {
    DeleteDatasetRequest request =
        DeleteDatasetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteDatasetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   String name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString();
   *   datasetServiceClient.deleteDatasetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Dataset to delete. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteDatasetAsync(String name) {
    DeleteDatasetRequest request = DeleteDatasetRequest.newBuilder().setName(name).build();
    return deleteDatasetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   DeleteDatasetRequest request =
   *       DeleteDatasetRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .build();
   *   datasetServiceClient.deleteDatasetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteDatasetAsync(
      DeleteDatasetRequest request) {
    return deleteDatasetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   DeleteDatasetRequest request =
   *       DeleteDatasetRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       datasetServiceClient.deleteDatasetOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDatasetRequest, Empty, DeleteOperationMetadata>
      deleteDatasetOperationCallable() {
    return stub.deleteDatasetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   DeleteDatasetRequest request =
   *       DeleteDatasetRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       datasetServiceClient.deleteDatasetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDatasetRequest, Operation> deleteDatasetCallable() {
    return stub.deleteDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports data into a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   DatasetName name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
   *   List<ImportDataConfig> importConfigs = new ArrayList<>();
   *   ImportDataResponse response = datasetServiceClient.importDataAsync(name, importConfigs).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Dataset resource. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}`
   * @param importConfigs Required. The desired input locations. The contents of all input locations
   *     will be imported in one batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportDataResponse, ImportDataOperationMetadata> importDataAsync(
      DatasetName name, List<ImportDataConfig> importConfigs) {
    ImportDataRequest request =
        ImportDataRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .addAllImportConfigs(importConfigs)
            .build();
    return importDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports data into a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   String name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString();
   *   List<ImportDataConfig> importConfigs = new ArrayList<>();
   *   ImportDataResponse response = datasetServiceClient.importDataAsync(name, importConfigs).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Dataset resource. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}`
   * @param importConfigs Required. The desired input locations. The contents of all input locations
   *     will be imported in one batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportDataResponse, ImportDataOperationMetadata> importDataAsync(
      String name, List<ImportDataConfig> importConfigs) {
    ImportDataRequest request =
        ImportDataRequest.newBuilder().setName(name).addAllImportConfigs(importConfigs).build();
    return importDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports data into a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   ImportDataRequest request =
   *       ImportDataRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .addAllImportConfigs(new ArrayList<ImportDataConfig>())
   *           .build();
   *   ImportDataResponse response = datasetServiceClient.importDataAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportDataResponse, ImportDataOperationMetadata> importDataAsync(
      ImportDataRequest request) {
    return importDataOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports data into a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   ImportDataRequest request =
   *       ImportDataRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .addAllImportConfigs(new ArrayList<ImportDataConfig>())
   *           .build();
   *   OperationFuture<ImportDataResponse, ImportDataOperationMetadata> future =
   *       datasetServiceClient.importDataOperationCallable().futureCall(request);
   *   // Do something.
   *   ImportDataResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ImportDataRequest, ImportDataResponse, ImportDataOperationMetadata>
      importDataOperationCallable() {
    return stub.importDataOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports data into a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   ImportDataRequest request =
   *       ImportDataRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .addAllImportConfigs(new ArrayList<ImportDataConfig>())
   *           .build();
   *   ApiFuture<Operation> future = datasetServiceClient.importDataCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportDataRequest, Operation> importDataCallable() {
    return stub.importDataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports data from a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   DatasetName name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
   *   ExportDataConfig exportConfig = ExportDataConfig.newBuilder().build();
   *   ExportDataResponse response = datasetServiceClient.exportDataAsync(name, exportConfig).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Dataset resource. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}`
   * @param exportConfig Required. The desired output location.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportDataResponse, ExportDataOperationMetadata> exportDataAsync(
      DatasetName name, ExportDataConfig exportConfig) {
    ExportDataRequest request =
        ExportDataRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setExportConfig(exportConfig)
            .build();
    return exportDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports data from a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   String name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString();
   *   ExportDataConfig exportConfig = ExportDataConfig.newBuilder().build();
   *   ExportDataResponse response = datasetServiceClient.exportDataAsync(name, exportConfig).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Dataset resource. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}`
   * @param exportConfig Required. The desired output location.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportDataResponse, ExportDataOperationMetadata> exportDataAsync(
      String name, ExportDataConfig exportConfig) {
    ExportDataRequest request =
        ExportDataRequest.newBuilder().setName(name).setExportConfig(exportConfig).build();
    return exportDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports data from a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   ExportDataRequest request =
   *       ExportDataRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setExportConfig(ExportDataConfig.newBuilder().build())
   *           .build();
   *   ExportDataResponse response = datasetServiceClient.exportDataAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportDataResponse, ExportDataOperationMetadata> exportDataAsync(
      ExportDataRequest request) {
    return exportDataOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports data from a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   ExportDataRequest request =
   *       ExportDataRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setExportConfig(ExportDataConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<ExportDataResponse, ExportDataOperationMetadata> future =
   *       datasetServiceClient.exportDataOperationCallable().futureCall(request);
   *   // Do something.
   *   ExportDataResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ExportDataRequest, ExportDataResponse, ExportDataOperationMetadata>
      exportDataOperationCallable() {
    return stub.exportDataOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports data from a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   ExportDataRequest request =
   *       ExportDataRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setExportConfig(ExportDataConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = datasetServiceClient.exportDataCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportDataRequest, Operation> exportDataCallable() {
    return stub.exportDataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a version from a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   DatasetName parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
   *   DatasetVersion datasetVersion = DatasetVersion.newBuilder().build();
   *   DatasetVersion response =
   *       datasetServiceClient.createDatasetVersionAsync(parent, datasetVersion).get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the Dataset resource. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}`
   * @param datasetVersion Required. The version to be created. The same CMEK policies with the
   *     original Dataset will be applied the dataset version. So here we don't need to specify the
   *     EncryptionSpecType here.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DatasetVersion, CreateDatasetVersionOperationMetadata>
      createDatasetVersionAsync(DatasetName parent, DatasetVersion datasetVersion) {
    CreateDatasetVersionRequest request =
        CreateDatasetVersionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDatasetVersion(datasetVersion)
            .build();
    return createDatasetVersionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a version from a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   String parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString();
   *   DatasetVersion datasetVersion = DatasetVersion.newBuilder().build();
   *   DatasetVersion response =
   *       datasetServiceClient.createDatasetVersionAsync(parent, datasetVersion).get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the Dataset resource. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}`
   * @param datasetVersion Required. The version to be created. The same CMEK policies with the
   *     original Dataset will be applied the dataset version. So here we don't need to specify the
   *     EncryptionSpecType here.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DatasetVersion, CreateDatasetVersionOperationMetadata>
      createDatasetVersionAsync(String parent, DatasetVersion datasetVersion) {
    CreateDatasetVersionRequest request =
        CreateDatasetVersionRequest.newBuilder()
            .setParent(parent)
            .setDatasetVersion(datasetVersion)
            .build();
    return createDatasetVersionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a version from a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   CreateDatasetVersionRequest request =
   *       CreateDatasetVersionRequest.newBuilder()
   *           .setParent(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setDatasetVersion(DatasetVersion.newBuilder().build())
   *           .build();
   *   DatasetVersion response = datasetServiceClient.createDatasetVersionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DatasetVersion, CreateDatasetVersionOperationMetadata>
      createDatasetVersionAsync(CreateDatasetVersionRequest request) {
    return createDatasetVersionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a version from a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   CreateDatasetVersionRequest request =
   *       CreateDatasetVersionRequest.newBuilder()
   *           .setParent(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setDatasetVersion(DatasetVersion.newBuilder().build())
   *           .build();
   *   OperationFuture<DatasetVersion, CreateDatasetVersionOperationMetadata> future =
   *       datasetServiceClient.createDatasetVersionOperationCallable().futureCall(request);
   *   // Do something.
   *   DatasetVersion response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateDatasetVersionRequest, DatasetVersion, CreateDatasetVersionOperationMetadata>
      createDatasetVersionOperationCallable() {
    return stub.createDatasetVersionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a version from a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   CreateDatasetVersionRequest request =
   *       CreateDatasetVersionRequest.newBuilder()
   *           .setParent(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setDatasetVersion(DatasetVersion.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       datasetServiceClient.createDatasetVersionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDatasetVersionRequest, Operation>
      createDatasetVersionCallable() {
    return stub.createDatasetVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DatasetVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   DatasetVersion datasetVersion = DatasetVersion.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DatasetVersion response =
   *       datasetServiceClient.updateDatasetVersion(datasetVersion, updateMask);
   * }
   * }</pre>
   *
   * @param datasetVersion Required. The DatasetVersion which replaces the resource on the server.
   * @param updateMask Required. The update mask applies to the resource. For the `FieldMask`
   *     definition, see [google.protobuf.FieldMask][google.protobuf.FieldMask]. Updatable fields:
   *     <p>&#42; `display_name`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DatasetVersion updateDatasetVersion(
      DatasetVersion datasetVersion, FieldMask updateMask) {
    UpdateDatasetVersionRequest request =
        UpdateDatasetVersionRequest.newBuilder()
            .setDatasetVersion(datasetVersion)
            .setUpdateMask(updateMask)
            .build();
    return updateDatasetVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DatasetVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   UpdateDatasetVersionRequest request =
   *       UpdateDatasetVersionRequest.newBuilder()
   *           .setDatasetVersion(DatasetVersion.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   DatasetVersion response = datasetServiceClient.updateDatasetVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DatasetVersion updateDatasetVersion(UpdateDatasetVersionRequest request) {
    return updateDatasetVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DatasetVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   UpdateDatasetVersionRequest request =
   *       UpdateDatasetVersionRequest.newBuilder()
   *           .setDatasetVersion(DatasetVersion.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<DatasetVersion> future =
   *       datasetServiceClient.updateDatasetVersionCallable().futureCall(request);
   *   // Do something.
   *   DatasetVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDatasetVersionRequest, DatasetVersion>
      updateDatasetVersionCallable() {
    return stub.updateDatasetVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Dataset version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   DatasetVersionName name =
   *       DatasetVersionName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[DATASET_VERSION]");
   *   datasetServiceClient.deleteDatasetVersionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Dataset version to delete. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}/datasetVersions/{dataset_version}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteDatasetVersionAsync(
      DatasetVersionName name) {
    DeleteDatasetVersionRequest request =
        DeleteDatasetVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteDatasetVersionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Dataset version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   String name =
   *       DatasetVersionName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[DATASET_VERSION]")
   *           .toString();
   *   datasetServiceClient.deleteDatasetVersionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Dataset version to delete. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}/datasetVersions/{dataset_version}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteDatasetVersionAsync(
      String name) {
    DeleteDatasetVersionRequest request =
        DeleteDatasetVersionRequest.newBuilder().setName(name).build();
    return deleteDatasetVersionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Dataset version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   DeleteDatasetVersionRequest request =
   *       DeleteDatasetVersionRequest.newBuilder()
   *           .setName(
   *               DatasetVersionName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[DATASET_VERSION]")
   *                   .toString())
   *           .build();
   *   datasetServiceClient.deleteDatasetVersionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteDatasetVersionAsync(
      DeleteDatasetVersionRequest request) {
    return deleteDatasetVersionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Dataset version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   DeleteDatasetVersionRequest request =
   *       DeleteDatasetVersionRequest.newBuilder()
   *           .setName(
   *               DatasetVersionName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[DATASET_VERSION]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       datasetServiceClient.deleteDatasetVersionOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDatasetVersionRequest, Empty, DeleteOperationMetadata>
      deleteDatasetVersionOperationCallable() {
    return stub.deleteDatasetVersionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Dataset version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   DeleteDatasetVersionRequest request =
   *       DeleteDatasetVersionRequest.newBuilder()
   *           .setName(
   *               DatasetVersionName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[DATASET_VERSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       datasetServiceClient.deleteDatasetVersionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDatasetVersionRequest, Operation>
      deleteDatasetVersionCallable() {
    return stub.deleteDatasetVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Dataset version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   DatasetVersionName name =
   *       DatasetVersionName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[DATASET_VERSION]");
   *   DatasetVersion response = datasetServiceClient.getDatasetVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Dataset version to delete. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}/datasetVersions/{dataset_version}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DatasetVersion getDatasetVersion(DatasetVersionName name) {
    GetDatasetVersionRequest request =
        GetDatasetVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDatasetVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Dataset version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   String name =
   *       DatasetVersionName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[DATASET_VERSION]")
   *           .toString();
   *   DatasetVersion response = datasetServiceClient.getDatasetVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Dataset version to delete. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}/datasetVersions/{dataset_version}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DatasetVersion getDatasetVersion(String name) {
    GetDatasetVersionRequest request = GetDatasetVersionRequest.newBuilder().setName(name).build();
    return getDatasetVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Dataset version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   GetDatasetVersionRequest request =
   *       GetDatasetVersionRequest.newBuilder()
   *           .setName(
   *               DatasetVersionName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[DATASET_VERSION]")
   *                   .toString())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   DatasetVersion response = datasetServiceClient.getDatasetVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DatasetVersion getDatasetVersion(GetDatasetVersionRequest request) {
    return getDatasetVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Dataset version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   GetDatasetVersionRequest request =
   *       GetDatasetVersionRequest.newBuilder()
   *           .setName(
   *               DatasetVersionName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[DATASET_VERSION]")
   *                   .toString())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<DatasetVersion> future =
   *       datasetServiceClient.getDatasetVersionCallable().futureCall(request);
   *   // Do something.
   *   DatasetVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDatasetVersionRequest, DatasetVersion> getDatasetVersionCallable() {
    return stub.getDatasetVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DatasetVersions in a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   DatasetName parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
   *   for (DatasetVersion element : datasetServiceClient.listDatasetVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Dataset to list DatasetVersions from. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetVersionsPagedResponse listDatasetVersions(DatasetName parent) {
    ListDatasetVersionsRequest request =
        ListDatasetVersionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDatasetVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DatasetVersions in a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   String parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString();
   *   for (DatasetVersion element : datasetServiceClient.listDatasetVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Dataset to list DatasetVersions from. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetVersionsPagedResponse listDatasetVersions(String parent) {
    ListDatasetVersionsRequest request =
        ListDatasetVersionsRequest.newBuilder().setParent(parent).build();
    return listDatasetVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DatasetVersions in a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   ListDatasetVersionsRequest request =
   *       ListDatasetVersionsRequest.newBuilder()
   *           .setParent(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (DatasetVersion element :
   *       datasetServiceClient.listDatasetVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetVersionsPagedResponse listDatasetVersions(
      ListDatasetVersionsRequest request) {
    return listDatasetVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DatasetVersions in a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   ListDatasetVersionsRequest request =
   *       ListDatasetVersionsRequest.newBuilder()
   *           .setParent(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<DatasetVersion> future =
   *       datasetServiceClient.listDatasetVersionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DatasetVersion element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDatasetVersionsRequest, ListDatasetVersionsPagedResponse>
      listDatasetVersionsPagedCallable() {
    return stub.listDatasetVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DatasetVersions in a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   ListDatasetVersionsRequest request =
   *       ListDatasetVersionsRequest.newBuilder()
   *           .setParent(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDatasetVersionsResponse response =
   *         datasetServiceClient.listDatasetVersionsCallable().call(request);
   *     for (DatasetVersion element : response.getDatasetVersionsList()) {
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
  public final UnaryCallable<ListDatasetVersionsRequest, ListDatasetVersionsResponse>
      listDatasetVersionsCallable() {
    return stub.listDatasetVersionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a dataset version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   DatasetVersionName name =
   *       DatasetVersionName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[DATASET_VERSION]");
   *   DatasetVersion response = datasetServiceClient.restoreDatasetVersionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the DatasetVersion resource. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}/datasetVersions/{dataset_version}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DatasetVersion, RestoreDatasetVersionOperationMetadata>
      restoreDatasetVersionAsync(DatasetVersionName name) {
    RestoreDatasetVersionRequest request =
        RestoreDatasetVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return restoreDatasetVersionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a dataset version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   String name =
   *       DatasetVersionName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[DATASET_VERSION]")
   *           .toString();
   *   DatasetVersion response = datasetServiceClient.restoreDatasetVersionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the DatasetVersion resource. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}/datasetVersions/{dataset_version}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DatasetVersion, RestoreDatasetVersionOperationMetadata>
      restoreDatasetVersionAsync(String name) {
    RestoreDatasetVersionRequest request =
        RestoreDatasetVersionRequest.newBuilder().setName(name).build();
    return restoreDatasetVersionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a dataset version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   RestoreDatasetVersionRequest request =
   *       RestoreDatasetVersionRequest.newBuilder()
   *           .setName(
   *               DatasetVersionName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[DATASET_VERSION]")
   *                   .toString())
   *           .build();
   *   DatasetVersion response = datasetServiceClient.restoreDatasetVersionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DatasetVersion, RestoreDatasetVersionOperationMetadata>
      restoreDatasetVersionAsync(RestoreDatasetVersionRequest request) {
    return restoreDatasetVersionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a dataset version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   RestoreDatasetVersionRequest request =
   *       RestoreDatasetVersionRequest.newBuilder()
   *           .setName(
   *               DatasetVersionName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[DATASET_VERSION]")
   *                   .toString())
   *           .build();
   *   OperationFuture<DatasetVersion, RestoreDatasetVersionOperationMetadata> future =
   *       datasetServiceClient.restoreDatasetVersionOperationCallable().futureCall(request);
   *   // Do something.
   *   DatasetVersion response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RestoreDatasetVersionRequest, DatasetVersion, RestoreDatasetVersionOperationMetadata>
      restoreDatasetVersionOperationCallable() {
    return stub.restoreDatasetVersionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a dataset version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   RestoreDatasetVersionRequest request =
   *       RestoreDatasetVersionRequest.newBuilder()
   *           .setName(
   *               DatasetVersionName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[DATASET_VERSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       datasetServiceClient.restoreDatasetVersionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RestoreDatasetVersionRequest, Operation>
      restoreDatasetVersionCallable() {
    return stub.restoreDatasetVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataItems in a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   DatasetName parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
   *   for (DataItem element : datasetServiceClient.listDataItems(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Dataset to list DataItems from. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataItemsPagedResponse listDataItems(DatasetName parent) {
    ListDataItemsRequest request =
        ListDataItemsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDataItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataItems in a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   String parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString();
   *   for (DataItem element : datasetServiceClient.listDataItems(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Dataset to list DataItems from. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataItemsPagedResponse listDataItems(String parent) {
    ListDataItemsRequest request = ListDataItemsRequest.newBuilder().setParent(parent).build();
    return listDataItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataItems in a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   ListDataItemsRequest request =
   *       ListDataItemsRequest.newBuilder()
   *           .setParent(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (DataItem element : datasetServiceClient.listDataItems(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataItemsPagedResponse listDataItems(ListDataItemsRequest request) {
    return listDataItemsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataItems in a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   ListDataItemsRequest request =
   *       ListDataItemsRequest.newBuilder()
   *           .setParent(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<DataItem> future =
   *       datasetServiceClient.listDataItemsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DataItem element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDataItemsRequest, ListDataItemsPagedResponse>
      listDataItemsPagedCallable() {
    return stub.listDataItemsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataItems in a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   ListDataItemsRequest request =
   *       ListDataItemsRequest.newBuilder()
   *           .setParent(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDataItemsResponse response = datasetServiceClient.listDataItemsCallable().call(request);
   *     for (DataItem element : response.getDataItemsList()) {
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
  public final UnaryCallable<ListDataItemsRequest, ListDataItemsResponse> listDataItemsCallable() {
    return stub.listDataItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches DataItems in a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   SearchDataItemsRequest request =
   *       SearchDataItemsRequest.newBuilder()
   *           .setDataset(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setSavedQuery(
   *               SavedQueryName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[SAVED_QUERY]")
   *                   .toString())
   *           .setDataLabelingJob("dataLabelingJob951814757")
   *           .setDataItemFilter("dataItemFilter1487804341")
   *           .setAnnotationsFilter("annotationsFilter-583841860")
   *           .addAllAnnotationFilters(new ArrayList<String>())
   *           .setFieldMask(FieldMask.newBuilder().build())
   *           .setAnnotationsLimit(134561504)
   *           .setPageSize(883849137)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DataItemView element : datasetServiceClient.searchDataItems(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchDataItemsPagedResponse searchDataItems(SearchDataItemsRequest request) {
    return searchDataItemsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches DataItems in a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   SearchDataItemsRequest request =
   *       SearchDataItemsRequest.newBuilder()
   *           .setDataset(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setSavedQuery(
   *               SavedQueryName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[SAVED_QUERY]")
   *                   .toString())
   *           .setDataLabelingJob("dataLabelingJob951814757")
   *           .setDataItemFilter("dataItemFilter1487804341")
   *           .setAnnotationsFilter("annotationsFilter-583841860")
   *           .addAllAnnotationFilters(new ArrayList<String>())
   *           .setFieldMask(FieldMask.newBuilder().build())
   *           .setAnnotationsLimit(134561504)
   *           .setPageSize(883849137)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DataItemView> future =
   *       datasetServiceClient.searchDataItemsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DataItemView element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchDataItemsRequest, SearchDataItemsPagedResponse>
      searchDataItemsPagedCallable() {
    return stub.searchDataItemsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches DataItems in a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   SearchDataItemsRequest request =
   *       SearchDataItemsRequest.newBuilder()
   *           .setDataset(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setSavedQuery(
   *               SavedQueryName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[SAVED_QUERY]")
   *                   .toString())
   *           .setDataLabelingJob("dataLabelingJob951814757")
   *           .setDataItemFilter("dataItemFilter1487804341")
   *           .setAnnotationsFilter("annotationsFilter-583841860")
   *           .addAllAnnotationFilters(new ArrayList<String>())
   *           .setFieldMask(FieldMask.newBuilder().build())
   *           .setAnnotationsLimit(134561504)
   *           .setPageSize(883849137)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchDataItemsResponse response =
   *         datasetServiceClient.searchDataItemsCallable().call(request);
   *     for (DataItemView element : response.getDataItemViewsList()) {
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
  public final UnaryCallable<SearchDataItemsRequest, SearchDataItemsResponse>
      searchDataItemsCallable() {
    return stub.searchDataItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SavedQueries in a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   DatasetName parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
   *   for (SavedQuery element : datasetServiceClient.listSavedQueries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Dataset to list SavedQueries from. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSavedQueriesPagedResponse listSavedQueries(DatasetName parent) {
    ListSavedQueriesRequest request =
        ListSavedQueriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSavedQueries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SavedQueries in a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   String parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString();
   *   for (SavedQuery element : datasetServiceClient.listSavedQueries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Dataset to list SavedQueries from. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSavedQueriesPagedResponse listSavedQueries(String parent) {
    ListSavedQueriesRequest request =
        ListSavedQueriesRequest.newBuilder().setParent(parent).build();
    return listSavedQueries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SavedQueries in a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   ListSavedQueriesRequest request =
   *       ListSavedQueriesRequest.newBuilder()
   *           .setParent(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (SavedQuery element : datasetServiceClient.listSavedQueries(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSavedQueriesPagedResponse listSavedQueries(ListSavedQueriesRequest request) {
    return listSavedQueriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SavedQueries in a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   ListSavedQueriesRequest request =
   *       ListSavedQueriesRequest.newBuilder()
   *           .setParent(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<SavedQuery> future =
   *       datasetServiceClient.listSavedQueriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SavedQuery element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSavedQueriesRequest, ListSavedQueriesPagedResponse>
      listSavedQueriesPagedCallable() {
    return stub.listSavedQueriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SavedQueries in a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   ListSavedQueriesRequest request =
   *       ListSavedQueriesRequest.newBuilder()
   *           .setParent(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListSavedQueriesResponse response =
   *         datasetServiceClient.listSavedQueriesCallable().call(request);
   *     for (SavedQuery element : response.getSavedQueriesList()) {
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
  public final UnaryCallable<ListSavedQueriesRequest, ListSavedQueriesResponse>
      listSavedQueriesCallable() {
    return stub.listSavedQueriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a SavedQuery.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   SavedQueryName name =
   *       SavedQueryName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[SAVED_QUERY]");
   *   datasetServiceClient.deleteSavedQueryAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the SavedQuery to delete. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}/savedQueries/{saved_query}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteSavedQueryAsync(
      SavedQueryName name) {
    DeleteSavedQueryRequest request =
        DeleteSavedQueryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteSavedQueryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a SavedQuery.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   String name =
   *       SavedQueryName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[SAVED_QUERY]").toString();
   *   datasetServiceClient.deleteSavedQueryAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the SavedQuery to delete. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}/savedQueries/{saved_query}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteSavedQueryAsync(String name) {
    DeleteSavedQueryRequest request = DeleteSavedQueryRequest.newBuilder().setName(name).build();
    return deleteSavedQueryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a SavedQuery.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   DeleteSavedQueryRequest request =
   *       DeleteSavedQueryRequest.newBuilder()
   *           .setName(
   *               SavedQueryName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[SAVED_QUERY]")
   *                   .toString())
   *           .build();
   *   datasetServiceClient.deleteSavedQueryAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteSavedQueryAsync(
      DeleteSavedQueryRequest request) {
    return deleteSavedQueryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a SavedQuery.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   DeleteSavedQueryRequest request =
   *       DeleteSavedQueryRequest.newBuilder()
   *           .setName(
   *               SavedQueryName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[SAVED_QUERY]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       datasetServiceClient.deleteSavedQueryOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteSavedQueryRequest, Empty, DeleteOperationMetadata>
      deleteSavedQueryOperationCallable() {
    return stub.deleteSavedQueryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a SavedQuery.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   DeleteSavedQueryRequest request =
   *       DeleteSavedQueryRequest.newBuilder()
   *           .setName(
   *               SavedQueryName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[SAVED_QUERY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       datasetServiceClient.deleteSavedQueryCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSavedQueryRequest, Operation> deleteSavedQueryCallable() {
    return stub.deleteSavedQueryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an AnnotationSpec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   AnnotationSpecName name =
   *       AnnotationSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[ANNOTATION_SPEC]");
   *   AnnotationSpec response = datasetServiceClient.getAnnotationSpec(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the AnnotationSpec resource. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}/annotationSpecs/{annotation_spec}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnnotationSpec getAnnotationSpec(AnnotationSpecName name) {
    GetAnnotationSpecRequest request =
        GetAnnotationSpecRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAnnotationSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an AnnotationSpec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   String name =
   *       AnnotationSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[ANNOTATION_SPEC]")
   *           .toString();
   *   AnnotationSpec response = datasetServiceClient.getAnnotationSpec(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the AnnotationSpec resource. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}/annotationSpecs/{annotation_spec}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnnotationSpec getAnnotationSpec(String name) {
    GetAnnotationSpecRequest request = GetAnnotationSpecRequest.newBuilder().setName(name).build();
    return getAnnotationSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an AnnotationSpec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   GetAnnotationSpecRequest request =
   *       GetAnnotationSpecRequest.newBuilder()
   *           .setName(
   *               AnnotationSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[ANNOTATION_SPEC]")
   *                   .toString())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   AnnotationSpec response = datasetServiceClient.getAnnotationSpec(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnnotationSpec getAnnotationSpec(GetAnnotationSpecRequest request) {
    return getAnnotationSpecCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an AnnotationSpec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   GetAnnotationSpecRequest request =
   *       GetAnnotationSpecRequest.newBuilder()
   *           .setName(
   *               AnnotationSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[ANNOTATION_SPEC]")
   *                   .toString())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<AnnotationSpec> future =
   *       datasetServiceClient.getAnnotationSpecCallable().futureCall(request);
   *   // Do something.
   *   AnnotationSpec response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAnnotationSpecRequest, AnnotationSpec> getAnnotationSpecCallable() {
    return stub.getAnnotationSpecCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Annotations belongs to a dataitem
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   DataItemName parent = DataItemName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[DATA_ITEM]");
   *   for (Annotation element : datasetServiceClient.listAnnotations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the DataItem to list Annotations from. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}/dataItems/{data_item}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnnotationsPagedResponse listAnnotations(DataItemName parent) {
    ListAnnotationsRequest request =
        ListAnnotationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAnnotations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Annotations belongs to a dataitem
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   String parent =
   *       DataItemName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[DATA_ITEM]").toString();
   *   for (Annotation element : datasetServiceClient.listAnnotations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the DataItem to list Annotations from. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}/dataItems/{data_item}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnnotationsPagedResponse listAnnotations(String parent) {
    ListAnnotationsRequest request = ListAnnotationsRequest.newBuilder().setParent(parent).build();
    return listAnnotations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Annotations belongs to a dataitem
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   ListAnnotationsRequest request =
   *       ListAnnotationsRequest.newBuilder()
   *           .setParent(
   *               DataItemName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[DATA_ITEM]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Annotation element : datasetServiceClient.listAnnotations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnnotationsPagedResponse listAnnotations(ListAnnotationsRequest request) {
    return listAnnotationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Annotations belongs to a dataitem
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   ListAnnotationsRequest request =
   *       ListAnnotationsRequest.newBuilder()
   *           .setParent(
   *               DataItemName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[DATA_ITEM]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Annotation> future =
   *       datasetServiceClient.listAnnotationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Annotation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAnnotationsRequest, ListAnnotationsPagedResponse>
      listAnnotationsPagedCallable() {
    return stub.listAnnotationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Annotations belongs to a dataitem
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   ListAnnotationsRequest request =
   *       ListAnnotationsRequest.newBuilder()
   *           .setParent(
   *               DataItemName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[DATA_ITEM]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListAnnotationsResponse response =
   *         datasetServiceClient.listAnnotationsCallable().call(request);
   *     for (Annotation element : response.getAnnotationsList()) {
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
  public final UnaryCallable<ListAnnotationsRequest, ListAnnotationsResponse>
      listAnnotationsCallable() {
    return stub.listAnnotationsCallable();
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
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : datasetServiceClient.listLocations(request).iterateAll()) {
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
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       datasetServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = datasetServiceClient.listLocationsCallable().call(request);
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
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = datasetServiceClient.getLocation(request);
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
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = datasetServiceClient.getLocationCallable().futureCall(request);
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
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = datasetServiceClient.setIamPolicy(request);
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
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = datasetServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = datasetServiceClient.getIamPolicy(request);
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
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = datasetServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = datasetServiceClient.testIamPermissions(request);
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
   * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       datasetServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListDatasetsPagedResponse
      extends AbstractPagedListResponse<
          ListDatasetsRequest,
          ListDatasetsResponse,
          Dataset,
          ListDatasetsPage,
          ListDatasetsFixedSizeCollection> {

    public static ApiFuture<ListDatasetsPagedResponse> createAsync(
        PageContext<ListDatasetsRequest, ListDatasetsResponse, Dataset> context,
        ApiFuture<ListDatasetsResponse> futureResponse) {
      ApiFuture<ListDatasetsPage> futurePage =
          ListDatasetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDatasetsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDatasetsPagedResponse(ListDatasetsPage page) {
      super(page, ListDatasetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDatasetsPage
      extends AbstractPage<ListDatasetsRequest, ListDatasetsResponse, Dataset, ListDatasetsPage> {

    private ListDatasetsPage(
        PageContext<ListDatasetsRequest, ListDatasetsResponse, Dataset> context,
        ListDatasetsResponse response) {
      super(context, response);
    }

    private static ListDatasetsPage createEmptyPage() {
      return new ListDatasetsPage(null, null);
    }

    @Override
    protected ListDatasetsPage createPage(
        PageContext<ListDatasetsRequest, ListDatasetsResponse, Dataset> context,
        ListDatasetsResponse response) {
      return new ListDatasetsPage(context, response);
    }

    @Override
    public ApiFuture<ListDatasetsPage> createPageAsync(
        PageContext<ListDatasetsRequest, ListDatasetsResponse, Dataset> context,
        ApiFuture<ListDatasetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDatasetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDatasetsRequest,
          ListDatasetsResponse,
          Dataset,
          ListDatasetsPage,
          ListDatasetsFixedSizeCollection> {

    private ListDatasetsFixedSizeCollection(List<ListDatasetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDatasetsFixedSizeCollection createEmptyCollection() {
      return new ListDatasetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDatasetsFixedSizeCollection createCollection(
        List<ListDatasetsPage> pages, int collectionSize) {
      return new ListDatasetsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDatasetVersionsPagedResponse
      extends AbstractPagedListResponse<
          ListDatasetVersionsRequest,
          ListDatasetVersionsResponse,
          DatasetVersion,
          ListDatasetVersionsPage,
          ListDatasetVersionsFixedSizeCollection> {

    public static ApiFuture<ListDatasetVersionsPagedResponse> createAsync(
        PageContext<ListDatasetVersionsRequest, ListDatasetVersionsResponse, DatasetVersion>
            context,
        ApiFuture<ListDatasetVersionsResponse> futureResponse) {
      ApiFuture<ListDatasetVersionsPage> futurePage =
          ListDatasetVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDatasetVersionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDatasetVersionsPagedResponse(ListDatasetVersionsPage page) {
      super(page, ListDatasetVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDatasetVersionsPage
      extends AbstractPage<
          ListDatasetVersionsRequest,
          ListDatasetVersionsResponse,
          DatasetVersion,
          ListDatasetVersionsPage> {

    private ListDatasetVersionsPage(
        PageContext<ListDatasetVersionsRequest, ListDatasetVersionsResponse, DatasetVersion>
            context,
        ListDatasetVersionsResponse response) {
      super(context, response);
    }

    private static ListDatasetVersionsPage createEmptyPage() {
      return new ListDatasetVersionsPage(null, null);
    }

    @Override
    protected ListDatasetVersionsPage createPage(
        PageContext<ListDatasetVersionsRequest, ListDatasetVersionsResponse, DatasetVersion>
            context,
        ListDatasetVersionsResponse response) {
      return new ListDatasetVersionsPage(context, response);
    }

    @Override
    public ApiFuture<ListDatasetVersionsPage> createPageAsync(
        PageContext<ListDatasetVersionsRequest, ListDatasetVersionsResponse, DatasetVersion>
            context,
        ApiFuture<ListDatasetVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDatasetVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDatasetVersionsRequest,
          ListDatasetVersionsResponse,
          DatasetVersion,
          ListDatasetVersionsPage,
          ListDatasetVersionsFixedSizeCollection> {

    private ListDatasetVersionsFixedSizeCollection(
        List<ListDatasetVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDatasetVersionsFixedSizeCollection createEmptyCollection() {
      return new ListDatasetVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDatasetVersionsFixedSizeCollection createCollection(
        List<ListDatasetVersionsPage> pages, int collectionSize) {
      return new ListDatasetVersionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDataItemsPagedResponse
      extends AbstractPagedListResponse<
          ListDataItemsRequest,
          ListDataItemsResponse,
          DataItem,
          ListDataItemsPage,
          ListDataItemsFixedSizeCollection> {

    public static ApiFuture<ListDataItemsPagedResponse> createAsync(
        PageContext<ListDataItemsRequest, ListDataItemsResponse, DataItem> context,
        ApiFuture<ListDataItemsResponse> futureResponse) {
      ApiFuture<ListDataItemsPage> futurePage =
          ListDataItemsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDataItemsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDataItemsPagedResponse(ListDataItemsPage page) {
      super(page, ListDataItemsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDataItemsPage
      extends AbstractPage<
          ListDataItemsRequest, ListDataItemsResponse, DataItem, ListDataItemsPage> {

    private ListDataItemsPage(
        PageContext<ListDataItemsRequest, ListDataItemsResponse, DataItem> context,
        ListDataItemsResponse response) {
      super(context, response);
    }

    private static ListDataItemsPage createEmptyPage() {
      return new ListDataItemsPage(null, null);
    }

    @Override
    protected ListDataItemsPage createPage(
        PageContext<ListDataItemsRequest, ListDataItemsResponse, DataItem> context,
        ListDataItemsResponse response) {
      return new ListDataItemsPage(context, response);
    }

    @Override
    public ApiFuture<ListDataItemsPage> createPageAsync(
        PageContext<ListDataItemsRequest, ListDataItemsResponse, DataItem> context,
        ApiFuture<ListDataItemsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDataItemsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDataItemsRequest,
          ListDataItemsResponse,
          DataItem,
          ListDataItemsPage,
          ListDataItemsFixedSizeCollection> {

    private ListDataItemsFixedSizeCollection(List<ListDataItemsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDataItemsFixedSizeCollection createEmptyCollection() {
      return new ListDataItemsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDataItemsFixedSizeCollection createCollection(
        List<ListDataItemsPage> pages, int collectionSize) {
      return new ListDataItemsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchDataItemsPagedResponse
      extends AbstractPagedListResponse<
          SearchDataItemsRequest,
          SearchDataItemsResponse,
          DataItemView,
          SearchDataItemsPage,
          SearchDataItemsFixedSizeCollection> {

    public static ApiFuture<SearchDataItemsPagedResponse> createAsync(
        PageContext<SearchDataItemsRequest, SearchDataItemsResponse, DataItemView> context,
        ApiFuture<SearchDataItemsResponse> futureResponse) {
      ApiFuture<SearchDataItemsPage> futurePage =
          SearchDataItemsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchDataItemsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchDataItemsPagedResponse(SearchDataItemsPage page) {
      super(page, SearchDataItemsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchDataItemsPage
      extends AbstractPage<
          SearchDataItemsRequest, SearchDataItemsResponse, DataItemView, SearchDataItemsPage> {

    private SearchDataItemsPage(
        PageContext<SearchDataItemsRequest, SearchDataItemsResponse, DataItemView> context,
        SearchDataItemsResponse response) {
      super(context, response);
    }

    private static SearchDataItemsPage createEmptyPage() {
      return new SearchDataItemsPage(null, null);
    }

    @Override
    protected SearchDataItemsPage createPage(
        PageContext<SearchDataItemsRequest, SearchDataItemsResponse, DataItemView> context,
        SearchDataItemsResponse response) {
      return new SearchDataItemsPage(context, response);
    }

    @Override
    public ApiFuture<SearchDataItemsPage> createPageAsync(
        PageContext<SearchDataItemsRequest, SearchDataItemsResponse, DataItemView> context,
        ApiFuture<SearchDataItemsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchDataItemsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchDataItemsRequest,
          SearchDataItemsResponse,
          DataItemView,
          SearchDataItemsPage,
          SearchDataItemsFixedSizeCollection> {

    private SearchDataItemsFixedSizeCollection(
        List<SearchDataItemsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchDataItemsFixedSizeCollection createEmptyCollection() {
      return new SearchDataItemsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchDataItemsFixedSizeCollection createCollection(
        List<SearchDataItemsPage> pages, int collectionSize) {
      return new SearchDataItemsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSavedQueriesPagedResponse
      extends AbstractPagedListResponse<
          ListSavedQueriesRequest,
          ListSavedQueriesResponse,
          SavedQuery,
          ListSavedQueriesPage,
          ListSavedQueriesFixedSizeCollection> {

    public static ApiFuture<ListSavedQueriesPagedResponse> createAsync(
        PageContext<ListSavedQueriesRequest, ListSavedQueriesResponse, SavedQuery> context,
        ApiFuture<ListSavedQueriesResponse> futureResponse) {
      ApiFuture<ListSavedQueriesPage> futurePage =
          ListSavedQueriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSavedQueriesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSavedQueriesPagedResponse(ListSavedQueriesPage page) {
      super(page, ListSavedQueriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSavedQueriesPage
      extends AbstractPage<
          ListSavedQueriesRequest, ListSavedQueriesResponse, SavedQuery, ListSavedQueriesPage> {

    private ListSavedQueriesPage(
        PageContext<ListSavedQueriesRequest, ListSavedQueriesResponse, SavedQuery> context,
        ListSavedQueriesResponse response) {
      super(context, response);
    }

    private static ListSavedQueriesPage createEmptyPage() {
      return new ListSavedQueriesPage(null, null);
    }

    @Override
    protected ListSavedQueriesPage createPage(
        PageContext<ListSavedQueriesRequest, ListSavedQueriesResponse, SavedQuery> context,
        ListSavedQueriesResponse response) {
      return new ListSavedQueriesPage(context, response);
    }

    @Override
    public ApiFuture<ListSavedQueriesPage> createPageAsync(
        PageContext<ListSavedQueriesRequest, ListSavedQueriesResponse, SavedQuery> context,
        ApiFuture<ListSavedQueriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSavedQueriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSavedQueriesRequest,
          ListSavedQueriesResponse,
          SavedQuery,
          ListSavedQueriesPage,
          ListSavedQueriesFixedSizeCollection> {

    private ListSavedQueriesFixedSizeCollection(
        List<ListSavedQueriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSavedQueriesFixedSizeCollection createEmptyCollection() {
      return new ListSavedQueriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSavedQueriesFixedSizeCollection createCollection(
        List<ListSavedQueriesPage> pages, int collectionSize) {
      return new ListSavedQueriesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAnnotationsPagedResponse
      extends AbstractPagedListResponse<
          ListAnnotationsRequest,
          ListAnnotationsResponse,
          Annotation,
          ListAnnotationsPage,
          ListAnnotationsFixedSizeCollection> {

    public static ApiFuture<ListAnnotationsPagedResponse> createAsync(
        PageContext<ListAnnotationsRequest, ListAnnotationsResponse, Annotation> context,
        ApiFuture<ListAnnotationsResponse> futureResponse) {
      ApiFuture<ListAnnotationsPage> futurePage =
          ListAnnotationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAnnotationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAnnotationsPagedResponse(ListAnnotationsPage page) {
      super(page, ListAnnotationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAnnotationsPage
      extends AbstractPage<
          ListAnnotationsRequest, ListAnnotationsResponse, Annotation, ListAnnotationsPage> {

    private ListAnnotationsPage(
        PageContext<ListAnnotationsRequest, ListAnnotationsResponse, Annotation> context,
        ListAnnotationsResponse response) {
      super(context, response);
    }

    private static ListAnnotationsPage createEmptyPage() {
      return new ListAnnotationsPage(null, null);
    }

    @Override
    protected ListAnnotationsPage createPage(
        PageContext<ListAnnotationsRequest, ListAnnotationsResponse, Annotation> context,
        ListAnnotationsResponse response) {
      return new ListAnnotationsPage(context, response);
    }

    @Override
    public ApiFuture<ListAnnotationsPage> createPageAsync(
        PageContext<ListAnnotationsRequest, ListAnnotationsResponse, Annotation> context,
        ApiFuture<ListAnnotationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAnnotationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAnnotationsRequest,
          ListAnnotationsResponse,
          Annotation,
          ListAnnotationsPage,
          ListAnnotationsFixedSizeCollection> {

    private ListAnnotationsFixedSizeCollection(
        List<ListAnnotationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAnnotationsFixedSizeCollection createEmptyCollection() {
      return new ListAnnotationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAnnotationsFixedSizeCollection createCollection(
        List<ListAnnotationsPage> pages, int collectionSize) {
      return new ListAnnotationsFixedSizeCollection(pages, collectionSize);
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
