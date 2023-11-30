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

package com.google.cloud.migrationcenter.v1;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.migrationcenter.v1.stub.MigrationCenterStub;
import com.google.cloud.migrationcenter.v1.stub.MigrationCenterStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service describing handlers for resources.
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
 * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
 *   AssetName name = AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]");
 *   Asset response = migrationCenterClient.getAsset(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MigrationCenterClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    <tr>
 *      <td>ListAssets</td>
 *      <td><p>Lists all the assets in a given project and location.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listAssets(ListAssetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listAssets(LocationName parent)
 *           <li>listAssets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listAssetsPagedCallable()
 *           <li>listAssetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetAsset</td>
 *      <td><p>Gets the details of an asset.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getAsset(GetAssetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getAsset(AssetName name)
 *           <li>getAsset(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getAssetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateAsset</td>
 *      <td><p>Updates the parameters of an asset.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateAsset(UpdateAssetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>updateAsset(Asset asset, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateAssetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>BatchUpdateAssets</td>
 *      <td><p>Updates the parameters of a list of assets.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>batchUpdateAssets(LocationName parent, List<UpdateAssetRequest> requests)
 *           <li>batchUpdateAssets(String parent, List<UpdateAssetRequest> requests)
 *           <li>batchUpdateAssets(BatchUpdateAssetsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>batchUpdateAssetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteAsset</td>
 *      <td><p>Deletes an asset.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteAsset(DeleteAssetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>deleteAsset(AssetName name)
 *           <li>deleteAsset(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteAssetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>BatchDeleteAssets</td>
 *      <td><p>Deletes list of Assets.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>batchDeleteAssets(BatchDeleteAssetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>batchDeleteAssets(LocationName parent, List<String> names)
 *           <li>batchDeleteAssets(String parent, List<String> names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>batchDeleteAssetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ReportAssetFrames</td>
 *      <td><p>Reports a set of frames.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>reportAssetFrames(ReportAssetFramesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>reportAssetFramesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>AggregateAssetsValues</td>
 *      <td><p>Aggregates the requested fields based on provided function.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>aggregateAssetsValues(AggregateAssetsValuesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>aggregateAssetsValuesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateImportJob</td>
 *      <td><p>Creates an import job.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createImportJobAsync(CreateImportJobRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>createImportJobAsync(LocationName parent, ImportJob importJob, String importJobId)
 *           <li>createImportJobAsync(String parent, ImportJob importJob, String importJobId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createImportJobOperationCallable()
 *           <li>createImportJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListImportJobs</td>
 *      <td><p>Lists all import jobs.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listImportJobs(ListImportJobsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listImportJobs(LocationName parent)
 *           <li>listImportJobs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listImportJobsPagedCallable()
 *           <li>listImportJobsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetImportJob</td>
 *      <td><p>Gets the details of an import job.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getImportJob(GetImportJobRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getImportJob(ImportJobName name)
 *           <li>getImportJob(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getImportJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteImportJob</td>
 *      <td><p>Deletes an import job.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteImportJobAsync(DeleteImportJobRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>deleteImportJobAsync(ImportJobName name)
 *           <li>deleteImportJobAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteImportJobOperationCallable()
 *           <li>deleteImportJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateImportJob</td>
 *      <td><p>Updates an import job.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateImportJobAsync(UpdateImportJobRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>updateImportJobAsync(ImportJob importJob, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateImportJobOperationCallable()
 *           <li>updateImportJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ValidateImportJob</td>
 *      <td><p>Validates an import job.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>validateImportJobAsync(ValidateImportJobRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>validateImportJobAsync(ImportJobName name)
 *           <li>validateImportJobAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>validateImportJobOperationCallable()
 *           <li>validateImportJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>RunImportJob</td>
 *      <td><p>Runs an import job.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>runImportJobAsync(RunImportJobRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>runImportJobAsync(ImportJobName name)
 *           <li>runImportJobAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>runImportJobOperationCallable()
 *           <li>runImportJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetImportDataFile</td>
 *      <td><p>Gets an import data file.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getImportDataFile(GetImportDataFileRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getImportDataFile(ImportDataFileName name)
 *           <li>getImportDataFile(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getImportDataFileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListImportDataFiles</td>
 *      <td><p>List import data files.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listImportDataFiles(ListImportDataFilesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listImportDataFiles(ImportJobName parent)
 *           <li>listImportDataFiles(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listImportDataFilesPagedCallable()
 *           <li>listImportDataFilesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateImportDataFile</td>
 *      <td><p>Creates an import data file.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createImportDataFileAsync(CreateImportDataFileRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>createImportDataFileAsync(ImportJobName parent, ImportDataFile importDataFile, String importDataFileId)
 *           <li>createImportDataFileAsync(String parent, ImportDataFile importDataFile, String importDataFileId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createImportDataFileOperationCallable()
 *           <li>createImportDataFileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteImportDataFile</td>
 *      <td><p>Delete an import data file.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteImportDataFileAsync(DeleteImportDataFileRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>deleteImportDataFileAsync(ImportDataFileName name)
 *           <li>deleteImportDataFileAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteImportDataFileOperationCallable()
 *           <li>deleteImportDataFileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListGroups</td>
 *      <td><p>Lists all groups in a given project and location.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listGroups(ListGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listGroups(LocationName parent)
 *           <li>listGroups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listGroupsPagedCallable()
 *           <li>listGroupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetGroup</td>
 *      <td><p>Gets the details of a group.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getGroup(GetGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getGroup(GroupName name)
 *           <li>getGroup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateGroup</td>
 *      <td><p>Creates a new group in a given project and location.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createGroupAsync(CreateGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>createGroupAsync(LocationName parent, Group group, String groupId)
 *           <li>createGroupAsync(String parent, Group group, String groupId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createGroupOperationCallable()
 *           <li>createGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateGroup</td>
 *      <td><p>Updates the parameters of a group.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateGroupAsync(UpdateGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>updateGroupAsync(Group group, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateGroupOperationCallable()
 *           <li>updateGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteGroup</td>
 *      <td><p>Deletes a group.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteGroupAsync(DeleteGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>deleteGroupAsync(GroupName name)
 *           <li>deleteGroupAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteGroupOperationCallable()
 *           <li>deleteGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>AddAssetsToGroup</td>
 *      <td><p>Adds assets to a group.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>addAssetsToGroupAsync(AddAssetsToGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>addAssetsToGroupAsync(GroupName group)
 *           <li>addAssetsToGroupAsync(String group)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>addAssetsToGroupOperationCallable()
 *           <li>addAssetsToGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>RemoveAssetsFromGroup</td>
 *      <td><p>Removes assets from a group.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>removeAssetsFromGroupAsync(RemoveAssetsFromGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>removeAssetsFromGroupAsync(GroupName group)
 *           <li>removeAssetsFromGroupAsync(String group)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>removeAssetsFromGroupOperationCallable()
 *           <li>removeAssetsFromGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListErrorFrames</td>
 *      <td><p>Lists all error frames in a given source and location.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listErrorFrames(ListErrorFramesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listErrorFrames(SourceName parent)
 *           <li>listErrorFrames(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listErrorFramesPagedCallable()
 *           <li>listErrorFramesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetErrorFrame</td>
 *      <td><p>Gets the details of an error frame.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getErrorFrame(GetErrorFrameRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getErrorFrame(ErrorFrameName name)
 *           <li>getErrorFrame(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getErrorFrameCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListSources</td>
 *      <td><p>Lists all the sources in a given project and location.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listSources(ListSourcesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listSources(LocationName parent)
 *           <li>listSources(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listSourcesPagedCallable()
 *           <li>listSourcesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetSource</td>
 *      <td><p>Gets the details of a source.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getSource(GetSourceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getSource(SourceName name)
 *           <li>getSource(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getSourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateSource</td>
 *      <td><p>Creates a new source in a given project and location.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createSourceAsync(CreateSourceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>createSourceAsync(LocationName parent, Source source, String sourceId)
 *           <li>createSourceAsync(String parent, Source source, String sourceId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createSourceOperationCallable()
 *           <li>createSourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateSource</td>
 *      <td><p>Updates the parameters of a source.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateSourceAsync(UpdateSourceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>updateSourceAsync(Source source, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateSourceOperationCallable()
 *           <li>updateSourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteSource</td>
 *      <td><p>Deletes a source.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteSourceAsync(DeleteSourceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>deleteSourceAsync(SourceName name)
 *           <li>deleteSourceAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteSourceOperationCallable()
 *           <li>deleteSourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListPreferenceSets</td>
 *      <td><p>Lists all the preference sets in a given project and location.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listPreferenceSets(ListPreferenceSetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listPreferenceSets(LocationName parent)
 *           <li>listPreferenceSets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listPreferenceSetsPagedCallable()
 *           <li>listPreferenceSetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetPreferenceSet</td>
 *      <td><p>Gets the details of a preference set.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getPreferenceSet(GetPreferenceSetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getPreferenceSet(PreferenceSetName name)
 *           <li>getPreferenceSet(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getPreferenceSetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreatePreferenceSet</td>
 *      <td><p>Creates a new preference set in a given project and location.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createPreferenceSetAsync(CreatePreferenceSetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>createPreferenceSetAsync(LocationName parent, PreferenceSet preferenceSet, String preferenceSetId)
 *           <li>createPreferenceSetAsync(String parent, PreferenceSet preferenceSet, String preferenceSetId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createPreferenceSetOperationCallable()
 *           <li>createPreferenceSetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdatePreferenceSet</td>
 *      <td><p>Updates the parameters of a preference set.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updatePreferenceSetAsync(UpdatePreferenceSetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>updatePreferenceSetAsync(PreferenceSet preferenceSet, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updatePreferenceSetOperationCallable()
 *           <li>updatePreferenceSetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeletePreferenceSet</td>
 *      <td><p>Deletes a preference set.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deletePreferenceSetAsync(DeletePreferenceSetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>deletePreferenceSetAsync(PreferenceSetName name)
 *           <li>deletePreferenceSetAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deletePreferenceSetOperationCallable()
 *           <li>deletePreferenceSetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetSettings</td>
 *      <td><p>Gets the details of regional settings.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getSettings(GetSettingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getSettings(SettingsName name)
 *           <li>getSettings(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateSettings</td>
 *      <td><p>Updates the regional-level project settings.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateSettingsAsync(UpdateSettingsRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>updateSettingsAsync(Settings settings, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateSettingsOperationCallable()
 *           <li>updateSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateReportConfig</td>
 *      <td><p>Creates a report configuration.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createReportConfigAsync(CreateReportConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>createReportConfigAsync(LocationName parent, ReportConfig reportConfig, String reportConfigId)
 *           <li>createReportConfigAsync(String parent, ReportConfig reportConfig, String reportConfigId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createReportConfigOperationCallable()
 *           <li>createReportConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetReportConfig</td>
 *      <td><p>Gets details of a single ReportConfig.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getReportConfig(GetReportConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getReportConfig(ReportConfigName name)
 *           <li>getReportConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getReportConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListReportConfigs</td>
 *      <td><p>Lists ReportConfigs in a given project and location.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listReportConfigs(ListReportConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listReportConfigs(LocationName parent)
 *           <li>listReportConfigs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listReportConfigsPagedCallable()
 *           <li>listReportConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteReportConfig</td>
 *      <td><p>Deletes a ReportConfig.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteReportConfigAsync(DeleteReportConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>deleteReportConfigAsync(ReportConfigName name)
 *           <li>deleteReportConfigAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteReportConfigOperationCallable()
 *           <li>deleteReportConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateReport</td>
 *      <td><p>Creates a report.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createReportAsync(CreateReportRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>createReportAsync(ReportConfigName parent, Report report, String reportId)
 *           <li>createReportAsync(String parent, Report report, String reportId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createReportOperationCallable()
 *           <li>createReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetReport</td>
 *      <td><p>Gets details of a single Report.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getReport(GetReportRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getReport(ReportName name)
 *           <li>getReport(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListReports</td>
 *      <td><p>Lists Reports in a given ReportConfig.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listReports(ListReportsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listReports(ReportConfigName parent)
 *           <li>listReports(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listReportsPagedCallable()
 *           <li>listReportsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteReport</td>
 *      <td><p>Deletes a Report.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteReportAsync(DeleteReportRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>deleteReportAsync(ReportName name)
 *           <li>deleteReportAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteReportOperationCallable()
 *           <li>deleteReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListLocations</td>
 *      <td><p>Lists information about the supported locations for this service.</p></td>
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
 *      <td><p>Gets information about a location.</p></td>
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
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of MigrationCenterSettings to
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
 * MigrationCenterSettings migrationCenterSettings =
 *     MigrationCenterSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MigrationCenterClient migrationCenterClient =
 *     MigrationCenterClient.create(migrationCenterSettings);
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
 * MigrationCenterSettings migrationCenterSettings =
 *     MigrationCenterSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MigrationCenterClient migrationCenterClient =
 *     MigrationCenterClient.create(migrationCenterSettings);
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
 * MigrationCenterSettings migrationCenterSettings =
 *     MigrationCenterSettings.newHttpJsonBuilder().build();
 * MigrationCenterClient migrationCenterClient =
 *     MigrationCenterClient.create(migrationCenterSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class MigrationCenterClient implements BackgroundResource {
  private final MigrationCenterSettings settings;
  private final MigrationCenterStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of MigrationCenterClient with default settings. */
  public static final MigrationCenterClient create() throws IOException {
    return create(MigrationCenterSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MigrationCenterClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final MigrationCenterClient create(MigrationCenterSettings settings)
      throws IOException {
    return new MigrationCenterClient(settings);
  }

  /**
   * Constructs an instance of MigrationCenterClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(MigrationCenterSettings).
   */
  public static final MigrationCenterClient create(MigrationCenterStub stub) {
    return new MigrationCenterClient(stub);
  }

  /**
   * Constructs an instance of MigrationCenterClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected MigrationCenterClient(MigrationCenterSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((MigrationCenterStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected MigrationCenterClient(MigrationCenterStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final MigrationCenterSettings getSettings() {
    return settings;
  }

  public MigrationCenterStub getStub() {
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
   * Lists all the assets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Asset element : migrationCenterClient.listAssets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for `ListAssetsRequest`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssetsPagedResponse listAssets(LocationName parent) {
    ListAssetsRequest request =
        ListAssetsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listAssets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the assets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Asset element : migrationCenterClient.listAssets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for `ListAssetsRequest`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssetsPagedResponse listAssets(String parent) {
    ListAssetsRequest request = ListAssetsRequest.newBuilder().setParent(parent).build();
    return listAssets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the assets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListAssetsRequest request =
   *       ListAssetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(AssetView.forNumber(0))
   *           .build();
   *   for (Asset element : migrationCenterClient.listAssets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssetsPagedResponse listAssets(ListAssetsRequest request) {
    return listAssetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the assets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListAssetsRequest request =
   *       ListAssetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(AssetView.forNumber(0))
   *           .build();
   *   ApiFuture<Asset> future = migrationCenterClient.listAssetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Asset element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAssetsRequest, ListAssetsPagedResponse> listAssetsPagedCallable() {
    return stub.listAssetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the assets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListAssetsRequest request =
   *       ListAssetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(AssetView.forNumber(0))
   *           .build();
   *   while (true) {
   *     ListAssetsResponse response = migrationCenterClient.listAssetsCallable().call(request);
   *     for (Asset element : response.getAssetsList()) {
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
  public final UnaryCallable<ListAssetsRequest, ListAssetsResponse> listAssetsCallable() {
    return stub.listAssetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of an asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   AssetName name = AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]");
   *   Asset response = migrationCenterClient.getAsset(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Asset getAsset(AssetName name) {
    GetAssetRequest request =
        GetAssetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAsset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of an asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String name = AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]").toString();
   *   Asset response = migrationCenterClient.getAsset(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Asset getAsset(String name) {
    GetAssetRequest request = GetAssetRequest.newBuilder().setName(name).build();
    return getAsset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of an asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GetAssetRequest request =
   *       GetAssetRequest.newBuilder()
   *           .setName(AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]").toString())
   *           .setView(AssetView.forNumber(0))
   *           .build();
   *   Asset response = migrationCenterClient.getAsset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Asset getAsset(GetAssetRequest request) {
    return getAssetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of an asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GetAssetRequest request =
   *       GetAssetRequest.newBuilder()
   *           .setName(AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]").toString())
   *           .setView(AssetView.forNumber(0))
   *           .build();
   *   ApiFuture<Asset> future = migrationCenterClient.getAssetCallable().futureCall(request);
   *   // Do something.
   *   Asset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAssetRequest, Asset> getAssetCallable() {
    return stub.getAssetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of an asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   Asset asset = Asset.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Asset response = migrationCenterClient.updateAsset(asset, updateMask);
   * }
   * }</pre>
   *
   * @param asset Required. The resource being updated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     `Asset` resource by the update. The values specified in the `update_mask` field are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. A single &#42; value in the mask lets you to overwrite all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Asset updateAsset(Asset asset, FieldMask updateMask) {
    UpdateAssetRequest request =
        UpdateAssetRequest.newBuilder().setAsset(asset).setUpdateMask(updateMask).build();
    return updateAsset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of an asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   UpdateAssetRequest request =
   *       UpdateAssetRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAsset(Asset.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Asset response = migrationCenterClient.updateAsset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Asset updateAsset(UpdateAssetRequest request) {
    return updateAssetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of an asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   UpdateAssetRequest request =
   *       UpdateAssetRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAsset(Asset.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Asset> future = migrationCenterClient.updateAssetCallable().futureCall(request);
   *   // Do something.
   *   Asset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAssetRequest, Asset> updateAssetCallable() {
    return stub.updateAssetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a list of assets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   List<UpdateAssetRequest> requests = new ArrayList<>();
   *   BatchUpdateAssetsResponse response =
   *       migrationCenterClient.batchUpdateAssets(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for batch asset update.
   * @param requests Required. The request message specifying the resources to update. A maximum of
   *     1000 assets can be modified in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateAssetsResponse batchUpdateAssets(
      LocationName parent, List<UpdateAssetRequest> requests) {
    BatchUpdateAssetsRequest request =
        BatchUpdateAssetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateAssets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a list of assets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   List<UpdateAssetRequest> requests = new ArrayList<>();
   *   BatchUpdateAssetsResponse response =
   *       migrationCenterClient.batchUpdateAssets(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for batch asset update.
   * @param requests Required. The request message specifying the resources to update. A maximum of
   *     1000 assets can be modified in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateAssetsResponse batchUpdateAssets(
      String parent, List<UpdateAssetRequest> requests) {
    BatchUpdateAssetsRequest request =
        BatchUpdateAssetsRequest.newBuilder().setParent(parent).addAllRequests(requests).build();
    return batchUpdateAssets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a list of assets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   BatchUpdateAssetsRequest request =
   *       BatchUpdateAssetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllRequests(new ArrayList<UpdateAssetRequest>())
   *           .build();
   *   BatchUpdateAssetsResponse response = migrationCenterClient.batchUpdateAssets(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateAssetsResponse batchUpdateAssets(BatchUpdateAssetsRequest request) {
    return batchUpdateAssetsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a list of assets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   BatchUpdateAssetsRequest request =
   *       BatchUpdateAssetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllRequests(new ArrayList<UpdateAssetRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateAssetsResponse> future =
   *       migrationCenterClient.batchUpdateAssetsCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdateAssetsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdateAssetsRequest, BatchUpdateAssetsResponse>
      batchUpdateAssetsCallable() {
    return stub.batchUpdateAssetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   AssetName name = AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]");
   *   migrationCenterClient.deleteAsset(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAsset(AssetName name) {
    DeleteAssetRequest request =
        DeleteAssetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteAsset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String name = AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]").toString();
   *   migrationCenterClient.deleteAsset(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAsset(String name) {
    DeleteAssetRequest request = DeleteAssetRequest.newBuilder().setName(name).build();
    deleteAsset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   DeleteAssetRequest request =
   *       DeleteAssetRequest.newBuilder()
   *           .setName(AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   migrationCenterClient.deleteAsset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAsset(DeleteAssetRequest request) {
    deleteAssetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   DeleteAssetRequest request =
   *       DeleteAssetRequest.newBuilder()
   *           .setName(AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Empty> future = migrationCenterClient.deleteAssetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAssetRequest, Empty> deleteAssetCallable() {
    return stub.deleteAssetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes list of Assets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   List<String> names = new ArrayList<>();
   *   migrationCenterClient.batchDeleteAssets(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for batch asset delete.
   * @param names Required. The IDs of the assets to delete. A maximum of 1000 assets can be deleted
   *     in a batch. Format: projects/{project}/locations/{location}/assets/{name}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteAssets(LocationName parent, List<String> names) {
    BatchDeleteAssetsRequest request =
        BatchDeleteAssetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    batchDeleteAssets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes list of Assets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   List<String> names = new ArrayList<>();
   *   migrationCenterClient.batchDeleteAssets(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for batch asset delete.
   * @param names Required. The IDs of the assets to delete. A maximum of 1000 assets can be deleted
   *     in a batch. Format: projects/{project}/locations/{location}/assets/{name}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteAssets(String parent, List<String> names) {
    BatchDeleteAssetsRequest request =
        BatchDeleteAssetsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    batchDeleteAssets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes list of Assets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   BatchDeleteAssetsRequest request =
   *       BatchDeleteAssetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setAllowMissing(true)
   *           .build();
   *   migrationCenterClient.batchDeleteAssets(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteAssets(BatchDeleteAssetsRequest request) {
    batchDeleteAssetsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes list of Assets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   BatchDeleteAssetsRequest request =
   *       BatchDeleteAssetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Empty> future =
   *       migrationCenterClient.batchDeleteAssetsCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDeleteAssetsRequest, Empty> batchDeleteAssetsCallable() {
    return stub.batchDeleteAssetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reports a set of frames.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ReportAssetFramesRequest request =
   *       ReportAssetFramesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFrames(Frames.newBuilder().build())
   *           .setSource(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .build();
   *   ReportAssetFramesResponse response = migrationCenterClient.reportAssetFrames(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReportAssetFramesResponse reportAssetFrames(ReportAssetFramesRequest request) {
    return reportAssetFramesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reports a set of frames.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ReportAssetFramesRequest request =
   *       ReportAssetFramesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFrames(Frames.newBuilder().build())
   *           .setSource(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .build();
   *   ApiFuture<ReportAssetFramesResponse> future =
   *       migrationCenterClient.reportAssetFramesCallable().futureCall(request);
   *   // Do something.
   *   ReportAssetFramesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ReportAssetFramesRequest, ReportAssetFramesResponse>
      reportAssetFramesCallable() {
    return stub.reportAssetFramesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Aggregates the requested fields based on provided function.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   AggregateAssetsValuesRequest request =
   *       AggregateAssetsValuesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllAggregations(new ArrayList<Aggregation>())
   *           .setFilter("filter-1274492040")
   *           .build();
   *   AggregateAssetsValuesResponse response = migrationCenterClient.aggregateAssetsValues(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregateAssetsValuesResponse aggregateAssetsValues(
      AggregateAssetsValuesRequest request) {
    return aggregateAssetsValuesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Aggregates the requested fields based on provided function.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   AggregateAssetsValuesRequest request =
   *       AggregateAssetsValuesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllAggregations(new ArrayList<Aggregation>())
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<AggregateAssetsValuesResponse> future =
   *       migrationCenterClient.aggregateAssetsValuesCallable().futureCall(request);
   *   // Do something.
   *   AggregateAssetsValuesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AggregateAssetsValuesRequest, AggregateAssetsValuesResponse>
      aggregateAssetsValuesCallable() {
    return stub.aggregateAssetsValuesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ImportJob importJob = ImportJob.newBuilder().build();
   *   String importJobId = "importJobId1449444627";
   *   ImportJob response =
   *       migrationCenterClient.createImportJobAsync(parent, importJob, importJobId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param importJob Required. The resource being created.
   * @param importJobId Required. ID of the import job.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportJob, OperationMetadata> createImportJobAsync(
      LocationName parent, ImportJob importJob, String importJobId) {
    CreateImportJobRequest request =
        CreateImportJobRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setImportJob(importJob)
            .setImportJobId(importJobId)
            .build();
    return createImportJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ImportJob importJob = ImportJob.newBuilder().build();
   *   String importJobId = "importJobId1449444627";
   *   ImportJob response =
   *       migrationCenterClient.createImportJobAsync(parent, importJob, importJobId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param importJob Required. The resource being created.
   * @param importJobId Required. ID of the import job.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportJob, OperationMetadata> createImportJobAsync(
      String parent, ImportJob importJob, String importJobId) {
    CreateImportJobRequest request =
        CreateImportJobRequest.newBuilder()
            .setParent(parent)
            .setImportJob(importJob)
            .setImportJobId(importJobId)
            .build();
    return createImportJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   CreateImportJobRequest request =
   *       CreateImportJobRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setImportJobId("importJobId1449444627")
   *           .setImportJob(ImportJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ImportJob response = migrationCenterClient.createImportJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportJob, OperationMetadata> createImportJobAsync(
      CreateImportJobRequest request) {
    return createImportJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   CreateImportJobRequest request =
   *       CreateImportJobRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setImportJobId("importJobId1449444627")
   *           .setImportJob(ImportJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ImportJob, OperationMetadata> future =
   *       migrationCenterClient.createImportJobOperationCallable().futureCall(request);
   *   // Do something.
   *   ImportJob response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateImportJobRequest, ImportJob, OperationMetadata>
      createImportJobOperationCallable() {
    return stub.createImportJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   CreateImportJobRequest request =
   *       CreateImportJobRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setImportJobId("importJobId1449444627")
   *           .setImportJob(ImportJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       migrationCenterClient.createImportJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateImportJobRequest, Operation> createImportJobCallable() {
    return stub.createImportJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all import jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ImportJob element : migrationCenterClient.listImportJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for `ListImportJobsRequest`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListImportJobsPagedResponse listImportJobs(LocationName parent) {
    ListImportJobsRequest request =
        ListImportJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listImportJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all import jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ImportJob element : migrationCenterClient.listImportJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for `ListImportJobsRequest`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListImportJobsPagedResponse listImportJobs(String parent) {
    ListImportJobsRequest request = ListImportJobsRequest.newBuilder().setParent(parent).build();
    return listImportJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all import jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListImportJobsRequest request =
   *       ListImportJobsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(ImportJobView.forNumber(0))
   *           .build();
   *   for (ImportJob element : migrationCenterClient.listImportJobs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListImportJobsPagedResponse listImportJobs(ListImportJobsRequest request) {
    return listImportJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all import jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListImportJobsRequest request =
   *       ListImportJobsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(ImportJobView.forNumber(0))
   *           .build();
   *   ApiFuture<ImportJob> future =
   *       migrationCenterClient.listImportJobsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ImportJob element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListImportJobsRequest, ListImportJobsPagedResponse>
      listImportJobsPagedCallable() {
    return stub.listImportJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all import jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListImportJobsRequest request =
   *       ListImportJobsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(ImportJobView.forNumber(0))
   *           .build();
   *   while (true) {
   *     ListImportJobsResponse response =
   *         migrationCenterClient.listImportJobsCallable().call(request);
   *     for (ImportJob element : response.getImportJobsList()) {
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
  public final UnaryCallable<ListImportJobsRequest, ListImportJobsResponse>
      listImportJobsCallable() {
    return stub.listImportJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ImportJobName name = ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]");
   *   ImportJob response = migrationCenterClient.getImportJob(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportJob getImportJob(ImportJobName name) {
    GetImportJobRequest request =
        GetImportJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getImportJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String name = ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString();
   *   ImportJob response = migrationCenterClient.getImportJob(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportJob getImportJob(String name) {
    GetImportJobRequest request = GetImportJobRequest.newBuilder().setName(name).build();
    return getImportJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GetImportJobRequest request =
   *       GetImportJobRequest.newBuilder()
   *           .setName(ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString())
   *           .setView(ImportJobView.forNumber(0))
   *           .build();
   *   ImportJob response = migrationCenterClient.getImportJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportJob getImportJob(GetImportJobRequest request) {
    return getImportJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GetImportJobRequest request =
   *       GetImportJobRequest.newBuilder()
   *           .setName(ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString())
   *           .setView(ImportJobView.forNumber(0))
   *           .build();
   *   ApiFuture<ImportJob> future =
   *       migrationCenterClient.getImportJobCallable().futureCall(request);
   *   // Do something.
   *   ImportJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetImportJobRequest, ImportJob> getImportJobCallable() {
    return stub.getImportJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ImportJobName name = ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]");
   *   migrationCenterClient.deleteImportJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteImportJobAsync(ImportJobName name) {
    DeleteImportJobRequest request =
        DeleteImportJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteImportJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String name = ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString();
   *   migrationCenterClient.deleteImportJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteImportJobAsync(String name) {
    DeleteImportJobRequest request = DeleteImportJobRequest.newBuilder().setName(name).build();
    return deleteImportJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   DeleteImportJobRequest request =
   *       DeleteImportJobRequest.newBuilder()
   *           .setName(ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   migrationCenterClient.deleteImportJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteImportJobAsync(
      DeleteImportJobRequest request) {
    return deleteImportJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   DeleteImportJobRequest request =
   *       DeleteImportJobRequest.newBuilder()
   *           .setName(ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       migrationCenterClient.deleteImportJobOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteImportJobRequest, Empty, OperationMetadata>
      deleteImportJobOperationCallable() {
    return stub.deleteImportJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   DeleteImportJobRequest request =
   *       DeleteImportJobRequest.newBuilder()
   *           .setName(ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       migrationCenterClient.deleteImportJobCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteImportJobRequest, Operation> deleteImportJobCallable() {
    return stub.deleteImportJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ImportJob importJob = ImportJob.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ImportJob response = migrationCenterClient.updateImportJobAsync(importJob, updateMask).get();
   * }
   * }</pre>
   *
   * @param importJob Required. The resource being updated
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     `Asset` resource by the update. The values specified in the `update_mask` field are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. A single &#42; value in the mask lets you to overwrite all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportJob, OperationMetadata> updateImportJobAsync(
      ImportJob importJob, FieldMask updateMask) {
    UpdateImportJobRequest request =
        UpdateImportJobRequest.newBuilder()
            .setImportJob(importJob)
            .setUpdateMask(updateMask)
            .build();
    return updateImportJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   UpdateImportJobRequest request =
   *       UpdateImportJobRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setImportJob(ImportJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ImportJob response = migrationCenterClient.updateImportJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportJob, OperationMetadata> updateImportJobAsync(
      UpdateImportJobRequest request) {
    return updateImportJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   UpdateImportJobRequest request =
   *       UpdateImportJobRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setImportJob(ImportJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ImportJob, OperationMetadata> future =
   *       migrationCenterClient.updateImportJobOperationCallable().futureCall(request);
   *   // Do something.
   *   ImportJob response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateImportJobRequest, ImportJob, OperationMetadata>
      updateImportJobOperationCallable() {
    return stub.updateImportJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   UpdateImportJobRequest request =
   *       UpdateImportJobRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setImportJob(ImportJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       migrationCenterClient.updateImportJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateImportJobRequest, Operation> updateImportJobCallable() {
    return stub.updateImportJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Validates an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ImportJobName name = ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]");
   *   migrationCenterClient.validateImportJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the import job to validate.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> validateImportJobAsync(
      ImportJobName name) {
    ValidateImportJobRequest request =
        ValidateImportJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return validateImportJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Validates an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String name = ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString();
   *   migrationCenterClient.validateImportJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the import job to validate.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> validateImportJobAsync(String name) {
    ValidateImportJobRequest request = ValidateImportJobRequest.newBuilder().setName(name).build();
    return validateImportJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Validates an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ValidateImportJobRequest request =
   *       ValidateImportJobRequest.newBuilder()
   *           .setName(ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   migrationCenterClient.validateImportJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> validateImportJobAsync(
      ValidateImportJobRequest request) {
    return validateImportJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Validates an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ValidateImportJobRequest request =
   *       ValidateImportJobRequest.newBuilder()
   *           .setName(ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       migrationCenterClient.validateImportJobOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ValidateImportJobRequest, Empty, OperationMetadata>
      validateImportJobOperationCallable() {
    return stub.validateImportJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Validates an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ValidateImportJobRequest request =
   *       ValidateImportJobRequest.newBuilder()
   *           .setName(ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       migrationCenterClient.validateImportJobCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ValidateImportJobRequest, Operation> validateImportJobCallable() {
    return stub.validateImportJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ImportJobName name = ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]");
   *   migrationCenterClient.runImportJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the import job to run.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> runImportJobAsync(ImportJobName name) {
    RunImportJobRequest request =
        RunImportJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return runImportJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String name = ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString();
   *   migrationCenterClient.runImportJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the import job to run.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> runImportJobAsync(String name) {
    RunImportJobRequest request = RunImportJobRequest.newBuilder().setName(name).build();
    return runImportJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   RunImportJobRequest request =
   *       RunImportJobRequest.newBuilder()
   *           .setName(ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   migrationCenterClient.runImportJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> runImportJobAsync(
      RunImportJobRequest request) {
    return runImportJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   RunImportJobRequest request =
   *       RunImportJobRequest.newBuilder()
   *           .setName(ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       migrationCenterClient.runImportJobOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RunImportJobRequest, Empty, OperationMetadata>
      runImportJobOperationCallable() {
    return stub.runImportJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs an import job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   RunImportJobRequest request =
   *       RunImportJobRequest.newBuilder()
   *           .setName(ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       migrationCenterClient.runImportJobCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RunImportJobRequest, Operation> runImportJobCallable() {
    return stub.runImportJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an import data file.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ImportDataFileName name =
   *       ImportDataFileName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]", "[IMPORT_DATA_FILE]");
   *   ImportDataFile response = migrationCenterClient.getImportDataFile(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the ImportDataFile.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportDataFile getImportDataFile(ImportDataFileName name) {
    GetImportDataFileRequest request =
        GetImportDataFileRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getImportDataFile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an import data file.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String name =
   *       ImportDataFileName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]", "[IMPORT_DATA_FILE]")
   *           .toString();
   *   ImportDataFile response = migrationCenterClient.getImportDataFile(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the ImportDataFile.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportDataFile getImportDataFile(String name) {
    GetImportDataFileRequest request = GetImportDataFileRequest.newBuilder().setName(name).build();
    return getImportDataFile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an import data file.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GetImportDataFileRequest request =
   *       GetImportDataFileRequest.newBuilder()
   *           .setName(
   *               ImportDataFileName.of(
   *                       "[PROJECT]", "[LOCATION]", "[IMPORT_JOB]", "[IMPORT_DATA_FILE]")
   *                   .toString())
   *           .build();
   *   ImportDataFile response = migrationCenterClient.getImportDataFile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportDataFile getImportDataFile(GetImportDataFileRequest request) {
    return getImportDataFileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an import data file.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GetImportDataFileRequest request =
   *       GetImportDataFileRequest.newBuilder()
   *           .setName(
   *               ImportDataFileName.of(
   *                       "[PROJECT]", "[LOCATION]", "[IMPORT_JOB]", "[IMPORT_DATA_FILE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ImportDataFile> future =
   *       migrationCenterClient.getImportDataFileCallable().futureCall(request);
   *   // Do something.
   *   ImportDataFile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetImportDataFileRequest, ImportDataFile> getImportDataFileCallable() {
    return stub.getImportDataFileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List import data files.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ImportJobName parent = ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]");
   *   for (ImportDataFile element :
   *       migrationCenterClient.listImportDataFiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent of the `ImportDataFiles` resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListImportDataFilesPagedResponse listImportDataFiles(ImportJobName parent) {
    ListImportDataFilesRequest request =
        ListImportDataFilesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listImportDataFiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List import data files.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String parent = ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString();
   *   for (ImportDataFile element :
   *       migrationCenterClient.listImportDataFiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent of the `ImportDataFiles` resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListImportDataFilesPagedResponse listImportDataFiles(String parent) {
    ListImportDataFilesRequest request =
        ListImportDataFilesRequest.newBuilder().setParent(parent).build();
    return listImportDataFiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List import data files.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListImportDataFilesRequest request =
   *       ListImportDataFilesRequest.newBuilder()
   *           .setParent(ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ImportDataFile element :
   *       migrationCenterClient.listImportDataFiles(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListImportDataFilesPagedResponse listImportDataFiles(
      ListImportDataFilesRequest request) {
    return listImportDataFilesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List import data files.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListImportDataFilesRequest request =
   *       ListImportDataFilesRequest.newBuilder()
   *           .setParent(ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ImportDataFile> future =
   *       migrationCenterClient.listImportDataFilesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ImportDataFile element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListImportDataFilesRequest, ListImportDataFilesPagedResponse>
      listImportDataFilesPagedCallable() {
    return stub.listImportDataFilesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List import data files.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListImportDataFilesRequest request =
   *       ListImportDataFilesRequest.newBuilder()
   *           .setParent(ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListImportDataFilesResponse response =
   *         migrationCenterClient.listImportDataFilesCallable().call(request);
   *     for (ImportDataFile element : response.getImportDataFilesList()) {
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
  public final UnaryCallable<ListImportDataFilesRequest, ListImportDataFilesResponse>
      listImportDataFilesCallable() {
    return stub.listImportDataFilesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an import data file.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ImportJobName parent = ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]");
   *   ImportDataFile importDataFile = ImportDataFile.newBuilder().build();
   *   String importDataFileId = "importDataFileId-1812510330";
   *   ImportDataFile response =
   *       migrationCenterClient
   *           .createImportDataFileAsync(parent, importDataFile, importDataFileId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent of the ImportDataFile.
   * @param importDataFile Required. The resource being created.
   * @param importDataFileId Required. The ID of the new data file.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportDataFile, OperationMetadata> createImportDataFileAsync(
      ImportJobName parent, ImportDataFile importDataFile, String importDataFileId) {
    CreateImportDataFileRequest request =
        CreateImportDataFileRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setImportDataFile(importDataFile)
            .setImportDataFileId(importDataFileId)
            .build();
    return createImportDataFileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an import data file.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String parent = ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString();
   *   ImportDataFile importDataFile = ImportDataFile.newBuilder().build();
   *   String importDataFileId = "importDataFileId-1812510330";
   *   ImportDataFile response =
   *       migrationCenterClient
   *           .createImportDataFileAsync(parent, importDataFile, importDataFileId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent of the ImportDataFile.
   * @param importDataFile Required. The resource being created.
   * @param importDataFileId Required. The ID of the new data file.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportDataFile, OperationMetadata> createImportDataFileAsync(
      String parent, ImportDataFile importDataFile, String importDataFileId) {
    CreateImportDataFileRequest request =
        CreateImportDataFileRequest.newBuilder()
            .setParent(parent)
            .setImportDataFile(importDataFile)
            .setImportDataFileId(importDataFileId)
            .build();
    return createImportDataFileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an import data file.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   CreateImportDataFileRequest request =
   *       CreateImportDataFileRequest.newBuilder()
   *           .setParent(ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString())
   *           .setImportDataFileId("importDataFileId-1812510330")
   *           .setImportDataFile(ImportDataFile.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ImportDataFile response = migrationCenterClient.createImportDataFileAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportDataFile, OperationMetadata> createImportDataFileAsync(
      CreateImportDataFileRequest request) {
    return createImportDataFileOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an import data file.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   CreateImportDataFileRequest request =
   *       CreateImportDataFileRequest.newBuilder()
   *           .setParent(ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString())
   *           .setImportDataFileId("importDataFileId-1812510330")
   *           .setImportDataFile(ImportDataFile.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ImportDataFile, OperationMetadata> future =
   *       migrationCenterClient.createImportDataFileOperationCallable().futureCall(request);
   *   // Do something.
   *   ImportDataFile response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateImportDataFileRequest, ImportDataFile, OperationMetadata>
      createImportDataFileOperationCallable() {
    return stub.createImportDataFileOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an import data file.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   CreateImportDataFileRequest request =
   *       CreateImportDataFileRequest.newBuilder()
   *           .setParent(ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString())
   *           .setImportDataFileId("importDataFileId-1812510330")
   *           .setImportDataFile(ImportDataFile.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       migrationCenterClient.createImportDataFileCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateImportDataFileRequest, Operation>
      createImportDataFileCallable() {
    return stub.createImportDataFileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an import data file.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ImportDataFileName name =
   *       ImportDataFileName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]", "[IMPORT_DATA_FILE]");
   *   migrationCenterClient.deleteImportDataFileAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the ImportDataFile to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteImportDataFileAsync(
      ImportDataFileName name) {
    DeleteImportDataFileRequest request =
        DeleteImportDataFileRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteImportDataFileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an import data file.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String name =
   *       ImportDataFileName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]", "[IMPORT_DATA_FILE]")
   *           .toString();
   *   migrationCenterClient.deleteImportDataFileAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the ImportDataFile to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteImportDataFileAsync(String name) {
    DeleteImportDataFileRequest request =
        DeleteImportDataFileRequest.newBuilder().setName(name).build();
    return deleteImportDataFileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an import data file.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   DeleteImportDataFileRequest request =
   *       DeleteImportDataFileRequest.newBuilder()
   *           .setName(
   *               ImportDataFileName.of(
   *                       "[PROJECT]", "[LOCATION]", "[IMPORT_JOB]", "[IMPORT_DATA_FILE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   migrationCenterClient.deleteImportDataFileAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteImportDataFileAsync(
      DeleteImportDataFileRequest request) {
    return deleteImportDataFileOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an import data file.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   DeleteImportDataFileRequest request =
   *       DeleteImportDataFileRequest.newBuilder()
   *           .setName(
   *               ImportDataFileName.of(
   *                       "[PROJECT]", "[LOCATION]", "[IMPORT_JOB]", "[IMPORT_DATA_FILE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       migrationCenterClient.deleteImportDataFileOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteImportDataFileRequest, Empty, OperationMetadata>
      deleteImportDataFileOperationCallable() {
    return stub.deleteImportDataFileOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an import data file.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   DeleteImportDataFileRequest request =
   *       DeleteImportDataFileRequest.newBuilder()
   *           .setName(
   *               ImportDataFileName.of(
   *                       "[PROJECT]", "[LOCATION]", "[IMPORT_JOB]", "[IMPORT_DATA_FILE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       migrationCenterClient.deleteImportDataFileCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteImportDataFileRequest, Operation>
      deleteImportDataFileCallable() {
    return stub.deleteImportDataFileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all groups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Group element : migrationCenterClient.listGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for `ListGroupsRequest`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupsPagedResponse listGroups(LocationName parent) {
    ListGroupsRequest request =
        ListGroupsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all groups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Group element : migrationCenterClient.listGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for `ListGroupsRequest`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupsPagedResponse listGroups(String parent) {
    ListGroupsRequest request = ListGroupsRequest.newBuilder().setParent(parent).build();
    return listGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all groups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListGroupsRequest request =
   *       ListGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Group element : migrationCenterClient.listGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupsPagedResponse listGroups(ListGroupsRequest request) {
    return listGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all groups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListGroupsRequest request =
   *       ListGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Group> future = migrationCenterClient.listGroupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Group element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGroupsRequest, ListGroupsPagedResponse> listGroupsPagedCallable() {
    return stub.listGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all groups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListGroupsRequest request =
   *       ListGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListGroupsResponse response = migrationCenterClient.listGroupsCallable().call(request);
   *     for (Group element : response.getGroupsList()) {
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
  public final UnaryCallable<ListGroupsRequest, ListGroupsResponse> listGroupsCallable() {
    return stub.listGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GroupName name = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");
   *   Group response = migrationCenterClient.getGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Group getGroup(GroupName name) {
    GetGroupRequest request =
        GetGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String name = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString();
   *   Group response = migrationCenterClient.getGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Group getGroup(String name) {
    GetGroupRequest request = GetGroupRequest.newBuilder().setName(name).build();
    return getGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GetGroupRequest request =
   *       GetGroupRequest.newBuilder()
   *           .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .build();
   *   Group response = migrationCenterClient.getGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Group getGroup(GetGroupRequest request) {
    return getGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GetGroupRequest request =
   *       GetGroupRequest.newBuilder()
   *           .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .build();
   *   ApiFuture<Group> future = migrationCenterClient.getGroupCallable().futureCall(request);
   *   // Do something.
   *   Group response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGroupRequest, Group> getGroupCallable() {
    return stub.getGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new group in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Group group = Group.newBuilder().build();
   *   String groupId = "groupId293428218";
   *   Group response = migrationCenterClient.createGroupAsync(parent, group, groupId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param group Required. The group resource being created.
   * @param groupId Required. User specified ID for the group. It will become the last component of
   *     the group name. The ID must be unique within the project, must conform with RFC-1034, is
   *     restricted to lower-cased letters, and has a maximum length of 63 characters. The ID must
   *     match the regular expression: `[a-z]([a-z0-9-]{0,61}[a-z0-9])?`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Group, OperationMetadata> createGroupAsync(
      LocationName parent, Group group, String groupId) {
    CreateGroupRequest request =
        CreateGroupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGroup(group)
            .setGroupId(groupId)
            .build();
    return createGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new group in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Group group = Group.newBuilder().build();
   *   String groupId = "groupId293428218";
   *   Group response = migrationCenterClient.createGroupAsync(parent, group, groupId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param group Required. The group resource being created.
   * @param groupId Required. User specified ID for the group. It will become the last component of
   *     the group name. The ID must be unique within the project, must conform with RFC-1034, is
   *     restricted to lower-cased letters, and has a maximum length of 63 characters. The ID must
   *     match the regular expression: `[a-z]([a-z0-9-]{0,61}[a-z0-9])?`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Group, OperationMetadata> createGroupAsync(
      String parent, Group group, String groupId) {
    CreateGroupRequest request =
        CreateGroupRequest.newBuilder()
            .setParent(parent)
            .setGroup(group)
            .setGroupId(groupId)
            .build();
    return createGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new group in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   CreateGroupRequest request =
   *       CreateGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGroupId("groupId293428218")
   *           .setGroup(Group.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Group response = migrationCenterClient.createGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Group, OperationMetadata> createGroupAsync(
      CreateGroupRequest request) {
    return createGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new group in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   CreateGroupRequest request =
   *       CreateGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGroupId("groupId293428218")
   *           .setGroup(Group.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Group, OperationMetadata> future =
   *       migrationCenterClient.createGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   Group response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateGroupRequest, Group, OperationMetadata>
      createGroupOperationCallable() {
    return stub.createGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new group in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   CreateGroupRequest request =
   *       CreateGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGroupId("groupId293428218")
   *           .setGroup(Group.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = migrationCenterClient.createGroupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateGroupRequest, Operation> createGroupCallable() {
    return stub.createGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   Group group = Group.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Group response = migrationCenterClient.updateGroupAsync(group, updateMask).get();
   * }
   * }</pre>
   *
   * @param group Required. The group resource being updated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     `Group` resource by the update. The values specified in the `update_mask` are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. A
   *     single &#42; value in the mask lets you to overwrite all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Group, OperationMetadata> updateGroupAsync(
      Group group, FieldMask updateMask) {
    UpdateGroupRequest request =
        UpdateGroupRequest.newBuilder().setGroup(group).setUpdateMask(updateMask).build();
    return updateGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   UpdateGroupRequest request =
   *       UpdateGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setGroup(Group.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Group response = migrationCenterClient.updateGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Group, OperationMetadata> updateGroupAsync(
      UpdateGroupRequest request) {
    return updateGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   UpdateGroupRequest request =
   *       UpdateGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setGroup(Group.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Group, OperationMetadata> future =
   *       migrationCenterClient.updateGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   Group response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateGroupRequest, Group, OperationMetadata>
      updateGroupOperationCallable() {
    return stub.updateGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   UpdateGroupRequest request =
   *       UpdateGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setGroup(Group.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = migrationCenterClient.updateGroupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateGroupRequest, Operation> updateGroupCallable() {
    return stub.updateGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GroupName name = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");
   *   migrationCenterClient.deleteGroupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the group resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGroupAsync(GroupName name) {
    DeleteGroupRequest request =
        DeleteGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String name = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString();
   *   migrationCenterClient.deleteGroupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the group resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGroupAsync(String name) {
    DeleteGroupRequest request = DeleteGroupRequest.newBuilder().setName(name).build();
    return deleteGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   DeleteGroupRequest request =
   *       DeleteGroupRequest.newBuilder()
   *           .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   migrationCenterClient.deleteGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGroupAsync(
      DeleteGroupRequest request) {
    return deleteGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   DeleteGroupRequest request =
   *       DeleteGroupRequest.newBuilder()
   *           .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       migrationCenterClient.deleteGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteGroupRequest, Empty, OperationMetadata>
      deleteGroupOperationCallable() {
    return stub.deleteGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   DeleteGroupRequest request =
   *       DeleteGroupRequest.newBuilder()
   *           .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = migrationCenterClient.deleteGroupCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGroupRequest, Operation> deleteGroupCallable() {
    return stub.deleteGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds assets to a group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GroupName group = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");
   *   Group response = migrationCenterClient.addAssetsToGroupAsync(group).get();
   * }
   * }</pre>
   *
   * @param group Required. Group reference.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Group, OperationMetadata> addAssetsToGroupAsync(GroupName group) {
    AddAssetsToGroupRequest request =
        AddAssetsToGroupRequest.newBuilder()
            .setGroup(group == null ? null : group.toString())
            .build();
    return addAssetsToGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds assets to a group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String group = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString();
   *   Group response = migrationCenterClient.addAssetsToGroupAsync(group).get();
   * }
   * }</pre>
   *
   * @param group Required. Group reference.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Group, OperationMetadata> addAssetsToGroupAsync(String group) {
    AddAssetsToGroupRequest request = AddAssetsToGroupRequest.newBuilder().setGroup(group).build();
    return addAssetsToGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds assets to a group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   AddAssetsToGroupRequest request =
   *       AddAssetsToGroupRequest.newBuilder()
   *           .setGroup(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setRequestId("requestId693933066")
   *           .setAssets(AssetList.newBuilder().build())
   *           .setAllowExisting(true)
   *           .build();
   *   Group response = migrationCenterClient.addAssetsToGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Group, OperationMetadata> addAssetsToGroupAsync(
      AddAssetsToGroupRequest request) {
    return addAssetsToGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds assets to a group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   AddAssetsToGroupRequest request =
   *       AddAssetsToGroupRequest.newBuilder()
   *           .setGroup(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setRequestId("requestId693933066")
   *           .setAssets(AssetList.newBuilder().build())
   *           .setAllowExisting(true)
   *           .build();
   *   OperationFuture<Group, OperationMetadata> future =
   *       migrationCenterClient.addAssetsToGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   Group response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<AddAssetsToGroupRequest, Group, OperationMetadata>
      addAssetsToGroupOperationCallable() {
    return stub.addAssetsToGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds assets to a group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   AddAssetsToGroupRequest request =
   *       AddAssetsToGroupRequest.newBuilder()
   *           .setGroup(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setRequestId("requestId693933066")
   *           .setAssets(AssetList.newBuilder().build())
   *           .setAllowExisting(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       migrationCenterClient.addAssetsToGroupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddAssetsToGroupRequest, Operation> addAssetsToGroupCallable() {
    return stub.addAssetsToGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes assets from a group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GroupName group = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");
   *   Group response = migrationCenterClient.removeAssetsFromGroupAsync(group).get();
   * }
   * }</pre>
   *
   * @param group Required. Group reference.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Group, OperationMetadata> removeAssetsFromGroupAsync(
      GroupName group) {
    RemoveAssetsFromGroupRequest request =
        RemoveAssetsFromGroupRequest.newBuilder()
            .setGroup(group == null ? null : group.toString())
            .build();
    return removeAssetsFromGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes assets from a group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String group = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString();
   *   Group response = migrationCenterClient.removeAssetsFromGroupAsync(group).get();
   * }
   * }</pre>
   *
   * @param group Required. Group reference.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Group, OperationMetadata> removeAssetsFromGroupAsync(String group) {
    RemoveAssetsFromGroupRequest request =
        RemoveAssetsFromGroupRequest.newBuilder().setGroup(group).build();
    return removeAssetsFromGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes assets from a group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   RemoveAssetsFromGroupRequest request =
   *       RemoveAssetsFromGroupRequest.newBuilder()
   *           .setGroup(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setRequestId("requestId693933066")
   *           .setAssets(AssetList.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   Group response = migrationCenterClient.removeAssetsFromGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Group, OperationMetadata> removeAssetsFromGroupAsync(
      RemoveAssetsFromGroupRequest request) {
    return removeAssetsFromGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes assets from a group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   RemoveAssetsFromGroupRequest request =
   *       RemoveAssetsFromGroupRequest.newBuilder()
   *           .setGroup(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setRequestId("requestId693933066")
   *           .setAssets(AssetList.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   OperationFuture<Group, OperationMetadata> future =
   *       migrationCenterClient.removeAssetsFromGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   Group response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RemoveAssetsFromGroupRequest, Group, OperationMetadata>
      removeAssetsFromGroupOperationCallable() {
    return stub.removeAssetsFromGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes assets from a group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   RemoveAssetsFromGroupRequest request =
   *       RemoveAssetsFromGroupRequest.newBuilder()
   *           .setGroup(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setRequestId("requestId693933066")
   *           .setAssets(AssetList.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       migrationCenterClient.removeAssetsFromGroupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveAssetsFromGroupRequest, Operation>
      removeAssetsFromGroupCallable() {
    return stub.removeAssetsFromGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all error frames in a given source and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
   *   for (ErrorFrame element : migrationCenterClient.listErrorFrames(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value (the source) for `ListErrorFramesRequest`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListErrorFramesPagedResponse listErrorFrames(SourceName parent) {
    ListErrorFramesRequest request =
        ListErrorFramesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listErrorFrames(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all error frames in a given source and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString();
   *   for (ErrorFrame element : migrationCenterClient.listErrorFrames(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value (the source) for `ListErrorFramesRequest`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListErrorFramesPagedResponse listErrorFrames(String parent) {
    ListErrorFramesRequest request = ListErrorFramesRequest.newBuilder().setParent(parent).build();
    return listErrorFrames(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all error frames in a given source and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListErrorFramesRequest request =
   *       ListErrorFramesRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(ErrorFrameView.forNumber(0))
   *           .build();
   *   for (ErrorFrame element : migrationCenterClient.listErrorFrames(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListErrorFramesPagedResponse listErrorFrames(ListErrorFramesRequest request) {
    return listErrorFramesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all error frames in a given source and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListErrorFramesRequest request =
   *       ListErrorFramesRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(ErrorFrameView.forNumber(0))
   *           .build();
   *   ApiFuture<ErrorFrame> future =
   *       migrationCenterClient.listErrorFramesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ErrorFrame element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListErrorFramesRequest, ListErrorFramesPagedResponse>
      listErrorFramesPagedCallable() {
    return stub.listErrorFramesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all error frames in a given source and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListErrorFramesRequest request =
   *       ListErrorFramesRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(ErrorFrameView.forNumber(0))
   *           .build();
   *   while (true) {
   *     ListErrorFramesResponse response =
   *         migrationCenterClient.listErrorFramesCallable().call(request);
   *     for (ErrorFrame element : response.getErrorFramesList()) {
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
  public final UnaryCallable<ListErrorFramesRequest, ListErrorFramesResponse>
      listErrorFramesCallable() {
    return stub.listErrorFramesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of an error frame.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ErrorFrameName name =
   *       ErrorFrameName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[ERROR_FRAME]");
   *   ErrorFrame response = migrationCenterClient.getErrorFrame(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the frame to retrieve. Format:
   *     projects/{project}/locations/{location}/sources/{source}/errorFrames/{error_frame}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ErrorFrame getErrorFrame(ErrorFrameName name) {
    GetErrorFrameRequest request =
        GetErrorFrameRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getErrorFrame(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of an error frame.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String name =
   *       ErrorFrameName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[ERROR_FRAME]").toString();
   *   ErrorFrame response = migrationCenterClient.getErrorFrame(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the frame to retrieve. Format:
   *     projects/{project}/locations/{location}/sources/{source}/errorFrames/{error_frame}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ErrorFrame getErrorFrame(String name) {
    GetErrorFrameRequest request = GetErrorFrameRequest.newBuilder().setName(name).build();
    return getErrorFrame(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of an error frame.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GetErrorFrameRequest request =
   *       GetErrorFrameRequest.newBuilder()
   *           .setName(
   *               ErrorFrameName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[ERROR_FRAME]")
   *                   .toString())
   *           .setView(ErrorFrameView.forNumber(0))
   *           .build();
   *   ErrorFrame response = migrationCenterClient.getErrorFrame(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ErrorFrame getErrorFrame(GetErrorFrameRequest request) {
    return getErrorFrameCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of an error frame.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GetErrorFrameRequest request =
   *       GetErrorFrameRequest.newBuilder()
   *           .setName(
   *               ErrorFrameName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[ERROR_FRAME]")
   *                   .toString())
   *           .setView(ErrorFrameView.forNumber(0))
   *           .build();
   *   ApiFuture<ErrorFrame> future =
   *       migrationCenterClient.getErrorFrameCallable().futureCall(request);
   *   // Do something.
   *   ErrorFrame response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetErrorFrameRequest, ErrorFrame> getErrorFrameCallable() {
    return stub.getErrorFrameCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the sources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Source element : migrationCenterClient.listSources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for `ListSourcesRequest`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSourcesPagedResponse listSources(LocationName parent) {
    ListSourcesRequest request =
        ListSourcesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the sources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Source element : migrationCenterClient.listSources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for `ListSourcesRequest`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSourcesPagedResponse listSources(String parent) {
    ListSourcesRequest request = ListSourcesRequest.newBuilder().setParent(parent).build();
    return listSources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the sources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListSourcesRequest request =
   *       ListSourcesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Source element : migrationCenterClient.listSources(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSourcesPagedResponse listSources(ListSourcesRequest request) {
    return listSourcesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the sources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListSourcesRequest request =
   *       ListSourcesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Source> future =
   *       migrationCenterClient.listSourcesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Source element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSourcesRequest, ListSourcesPagedResponse>
      listSourcesPagedCallable() {
    return stub.listSourcesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the sources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListSourcesRequest request =
   *       ListSourcesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListSourcesResponse response = migrationCenterClient.listSourcesCallable().call(request);
   *     for (Source element : response.getSourcesList()) {
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
  public final UnaryCallable<ListSourcesRequest, ListSourcesResponse> listSourcesCallable() {
    return stub.listSourcesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   SourceName name = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
   *   Source response = migrationCenterClient.getSource(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Source getSource(SourceName name) {
    GetSourceRequest request =
        GetSourceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String name = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString();
   *   Source response = migrationCenterClient.getSource(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Source getSource(String name) {
    GetSourceRequest request = GetSourceRequest.newBuilder().setName(name).build();
    return getSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GetSourceRequest request =
   *       GetSourceRequest.newBuilder()
   *           .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .build();
   *   Source response = migrationCenterClient.getSource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Source getSource(GetSourceRequest request) {
    return getSourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GetSourceRequest request =
   *       GetSourceRequest.newBuilder()
   *           .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .build();
   *   ApiFuture<Source> future = migrationCenterClient.getSourceCallable().futureCall(request);
   *   // Do something.
   *   Source response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSourceRequest, Source> getSourceCallable() {
    return stub.getSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new source in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Source source = Source.newBuilder().build();
   *   String sourceId = "sourceId1746327190";
   *   Source response = migrationCenterClient.createSourceAsync(parent, source, sourceId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param source Required. The resource being created.
   * @param sourceId Required. User specified ID for the source. It will become the last component
   *     of the source name. The ID must be unique within the project, must conform with RFC-1034,
   *     is restricted to lower-cased letters, and has a maximum length of 63 characters. The ID
   *     must match the regular expression: `[a-z]([a-z0-9-]{0,61}[a-z0-9])?`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Source, OperationMetadata> createSourceAsync(
      LocationName parent, Source source, String sourceId) {
    CreateSourceRequest request =
        CreateSourceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSource(source)
            .setSourceId(sourceId)
            .build();
    return createSourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new source in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Source source = Source.newBuilder().build();
   *   String sourceId = "sourceId1746327190";
   *   Source response = migrationCenterClient.createSourceAsync(parent, source, sourceId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param source Required. The resource being created.
   * @param sourceId Required. User specified ID for the source. It will become the last component
   *     of the source name. The ID must be unique within the project, must conform with RFC-1034,
   *     is restricted to lower-cased letters, and has a maximum length of 63 characters. The ID
   *     must match the regular expression: `[a-z]([a-z0-9-]{0,61}[a-z0-9])?`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Source, OperationMetadata> createSourceAsync(
      String parent, Source source, String sourceId) {
    CreateSourceRequest request =
        CreateSourceRequest.newBuilder()
            .setParent(parent)
            .setSource(source)
            .setSourceId(sourceId)
            .build();
    return createSourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new source in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   CreateSourceRequest request =
   *       CreateSourceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceId("sourceId1746327190")
   *           .setSource(Source.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Source response = migrationCenterClient.createSourceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Source, OperationMetadata> createSourceAsync(
      CreateSourceRequest request) {
    return createSourceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new source in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   CreateSourceRequest request =
   *       CreateSourceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceId("sourceId1746327190")
   *           .setSource(Source.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Source, OperationMetadata> future =
   *       migrationCenterClient.createSourceOperationCallable().futureCall(request);
   *   // Do something.
   *   Source response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateSourceRequest, Source, OperationMetadata>
      createSourceOperationCallable() {
    return stub.createSourceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new source in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   CreateSourceRequest request =
   *       CreateSourceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceId("sourceId1746327190")
   *           .setSource(Source.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       migrationCenterClient.createSourceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSourceRequest, Operation> createSourceCallable() {
    return stub.createSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   Source source = Source.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Source response = migrationCenterClient.updateSourceAsync(source, updateMask).get();
   * }
   * }</pre>
   *
   * @param source Required. The resource being updated
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     `Source` resource by the update. The values specified in the `update_mask` field are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. A single &#42; value in the mask lets you to overwrite all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Source, OperationMetadata> updateSourceAsync(
      Source source, FieldMask updateMask) {
    UpdateSourceRequest request =
        UpdateSourceRequest.newBuilder().setSource(source).setUpdateMask(updateMask).build();
    return updateSourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   UpdateSourceRequest request =
   *       UpdateSourceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSource(Source.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Source response = migrationCenterClient.updateSourceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Source, OperationMetadata> updateSourceAsync(
      UpdateSourceRequest request) {
    return updateSourceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   UpdateSourceRequest request =
   *       UpdateSourceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSource(Source.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Source, OperationMetadata> future =
   *       migrationCenterClient.updateSourceOperationCallable().futureCall(request);
   *   // Do something.
   *   Source response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateSourceRequest, Source, OperationMetadata>
      updateSourceOperationCallable() {
    return stub.updateSourceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   UpdateSourceRequest request =
   *       UpdateSourceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSource(Source.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       migrationCenterClient.updateSourceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSourceRequest, Operation> updateSourceCallable() {
    return stub.updateSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   SourceName name = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
   *   migrationCenterClient.deleteSourceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSourceAsync(SourceName name) {
    DeleteSourceRequest request =
        DeleteSourceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteSourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String name = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString();
   *   migrationCenterClient.deleteSourceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSourceAsync(String name) {
    DeleteSourceRequest request = DeleteSourceRequest.newBuilder().setName(name).build();
    return deleteSourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   DeleteSourceRequest request =
   *       DeleteSourceRequest.newBuilder()
   *           .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   migrationCenterClient.deleteSourceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSourceAsync(
      DeleteSourceRequest request) {
    return deleteSourceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   DeleteSourceRequest request =
   *       DeleteSourceRequest.newBuilder()
   *           .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       migrationCenterClient.deleteSourceOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteSourceRequest, Empty, OperationMetadata>
      deleteSourceOperationCallable() {
    return stub.deleteSourceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   DeleteSourceRequest request =
   *       DeleteSourceRequest.newBuilder()
   *           .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       migrationCenterClient.deleteSourceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSourceRequest, Operation> deleteSourceCallable() {
    return stub.deleteSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the preference sets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (PreferenceSet element : migrationCenterClient.listPreferenceSets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for `ListPreferenceSetsRequest`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPreferenceSetsPagedResponse listPreferenceSets(LocationName parent) {
    ListPreferenceSetsRequest request =
        ListPreferenceSetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPreferenceSets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the preference sets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (PreferenceSet element : migrationCenterClient.listPreferenceSets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for `ListPreferenceSetsRequest`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPreferenceSetsPagedResponse listPreferenceSets(String parent) {
    ListPreferenceSetsRequest request =
        ListPreferenceSetsRequest.newBuilder().setParent(parent).build();
    return listPreferenceSets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the preference sets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListPreferenceSetsRequest request =
   *       ListPreferenceSetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (PreferenceSet element : migrationCenterClient.listPreferenceSets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPreferenceSetsPagedResponse listPreferenceSets(
      ListPreferenceSetsRequest request) {
    return listPreferenceSetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the preference sets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListPreferenceSetsRequest request =
   *       ListPreferenceSetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<PreferenceSet> future =
   *       migrationCenterClient.listPreferenceSetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PreferenceSet element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPreferenceSetsRequest, ListPreferenceSetsPagedResponse>
      listPreferenceSetsPagedCallable() {
    return stub.listPreferenceSetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the preference sets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListPreferenceSetsRequest request =
   *       ListPreferenceSetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListPreferenceSetsResponse response =
   *         migrationCenterClient.listPreferenceSetsCallable().call(request);
   *     for (PreferenceSet element : response.getPreferenceSetsList()) {
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
  public final UnaryCallable<ListPreferenceSetsRequest, ListPreferenceSetsResponse>
      listPreferenceSetsCallable() {
    return stub.listPreferenceSetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a preference set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   PreferenceSetName name = PreferenceSetName.of("[PROJECT]", "[LOCATION]", "[PREFERENCE_SET]");
   *   PreferenceSet response = migrationCenterClient.getPreferenceSet(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PreferenceSet getPreferenceSet(PreferenceSetName name) {
    GetPreferenceSetRequest request =
        GetPreferenceSetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPreferenceSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a preference set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String name = PreferenceSetName.of("[PROJECT]", "[LOCATION]", "[PREFERENCE_SET]").toString();
   *   PreferenceSet response = migrationCenterClient.getPreferenceSet(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PreferenceSet getPreferenceSet(String name) {
    GetPreferenceSetRequest request = GetPreferenceSetRequest.newBuilder().setName(name).build();
    return getPreferenceSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a preference set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GetPreferenceSetRequest request =
   *       GetPreferenceSetRequest.newBuilder()
   *           .setName(
   *               PreferenceSetName.of("[PROJECT]", "[LOCATION]", "[PREFERENCE_SET]").toString())
   *           .build();
   *   PreferenceSet response = migrationCenterClient.getPreferenceSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PreferenceSet getPreferenceSet(GetPreferenceSetRequest request) {
    return getPreferenceSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a preference set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GetPreferenceSetRequest request =
   *       GetPreferenceSetRequest.newBuilder()
   *           .setName(
   *               PreferenceSetName.of("[PROJECT]", "[LOCATION]", "[PREFERENCE_SET]").toString())
   *           .build();
   *   ApiFuture<PreferenceSet> future =
   *       migrationCenterClient.getPreferenceSetCallable().futureCall(request);
   *   // Do something.
   *   PreferenceSet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPreferenceSetRequest, PreferenceSet> getPreferenceSetCallable() {
    return stub.getPreferenceSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new preference set in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   PreferenceSet preferenceSet = PreferenceSet.newBuilder().build();
   *   String preferenceSetId = "preferenceSetId-569419518";
   *   PreferenceSet response =
   *       migrationCenterClient
   *           .createPreferenceSetAsync(parent, preferenceSet, preferenceSetId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param preferenceSet Required. The preference set resource being created.
   * @param preferenceSetId Required. User specified ID for the preference set. It will become the
   *     last component of the preference set name. The ID must be unique within the project, must
   *     conform with RFC-1034, is restricted to lower-cased letters, and has a maximum length of 63
   *     characters. The ID must match the regular expression `[a-z]([a-z0-9-]{0,61}[a-z0-9])?`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PreferenceSet, OperationMetadata> createPreferenceSetAsync(
      LocationName parent, PreferenceSet preferenceSet, String preferenceSetId) {
    CreatePreferenceSetRequest request =
        CreatePreferenceSetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPreferenceSet(preferenceSet)
            .setPreferenceSetId(preferenceSetId)
            .build();
    return createPreferenceSetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new preference set in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   PreferenceSet preferenceSet = PreferenceSet.newBuilder().build();
   *   String preferenceSetId = "preferenceSetId-569419518";
   *   PreferenceSet response =
   *       migrationCenterClient
   *           .createPreferenceSetAsync(parent, preferenceSet, preferenceSetId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param preferenceSet Required. The preference set resource being created.
   * @param preferenceSetId Required. User specified ID for the preference set. It will become the
   *     last component of the preference set name. The ID must be unique within the project, must
   *     conform with RFC-1034, is restricted to lower-cased letters, and has a maximum length of 63
   *     characters. The ID must match the regular expression `[a-z]([a-z0-9-]{0,61}[a-z0-9])?`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PreferenceSet, OperationMetadata> createPreferenceSetAsync(
      String parent, PreferenceSet preferenceSet, String preferenceSetId) {
    CreatePreferenceSetRequest request =
        CreatePreferenceSetRequest.newBuilder()
            .setParent(parent)
            .setPreferenceSet(preferenceSet)
            .setPreferenceSetId(preferenceSetId)
            .build();
    return createPreferenceSetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new preference set in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   CreatePreferenceSetRequest request =
   *       CreatePreferenceSetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPreferenceSetId("preferenceSetId-569419518")
   *           .setPreferenceSet(PreferenceSet.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   PreferenceSet response = migrationCenterClient.createPreferenceSetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PreferenceSet, OperationMetadata> createPreferenceSetAsync(
      CreatePreferenceSetRequest request) {
    return createPreferenceSetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new preference set in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   CreatePreferenceSetRequest request =
   *       CreatePreferenceSetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPreferenceSetId("preferenceSetId-569419518")
   *           .setPreferenceSet(PreferenceSet.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<PreferenceSet, OperationMetadata> future =
   *       migrationCenterClient.createPreferenceSetOperationCallable().futureCall(request);
   *   // Do something.
   *   PreferenceSet response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreatePreferenceSetRequest, PreferenceSet, OperationMetadata>
      createPreferenceSetOperationCallable() {
    return stub.createPreferenceSetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new preference set in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   CreatePreferenceSetRequest request =
   *       CreatePreferenceSetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPreferenceSetId("preferenceSetId-569419518")
   *           .setPreferenceSet(PreferenceSet.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       migrationCenterClient.createPreferenceSetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePreferenceSetRequest, Operation> createPreferenceSetCallable() {
    return stub.createPreferenceSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a preference set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   PreferenceSet preferenceSet = PreferenceSet.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   PreferenceSet response =
   *       migrationCenterClient.updatePreferenceSetAsync(preferenceSet, updateMask).get();
   * }
   * }</pre>
   *
   * @param preferenceSet Required. The preference set resource being updated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     `PreferenceSet` resource by the update. The values specified in the `update_mask` field are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. A single &#42; value in the mask lets you to overwrite all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PreferenceSet, OperationMetadata> updatePreferenceSetAsync(
      PreferenceSet preferenceSet, FieldMask updateMask) {
    UpdatePreferenceSetRequest request =
        UpdatePreferenceSetRequest.newBuilder()
            .setPreferenceSet(preferenceSet)
            .setUpdateMask(updateMask)
            .build();
    return updatePreferenceSetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a preference set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   UpdatePreferenceSetRequest request =
   *       UpdatePreferenceSetRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setPreferenceSet(PreferenceSet.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   PreferenceSet response = migrationCenterClient.updatePreferenceSetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PreferenceSet, OperationMetadata> updatePreferenceSetAsync(
      UpdatePreferenceSetRequest request) {
    return updatePreferenceSetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a preference set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   UpdatePreferenceSetRequest request =
   *       UpdatePreferenceSetRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setPreferenceSet(PreferenceSet.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<PreferenceSet, OperationMetadata> future =
   *       migrationCenterClient.updatePreferenceSetOperationCallable().futureCall(request);
   *   // Do something.
   *   PreferenceSet response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdatePreferenceSetRequest, PreferenceSet, OperationMetadata>
      updatePreferenceSetOperationCallable() {
    return stub.updatePreferenceSetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a preference set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   UpdatePreferenceSetRequest request =
   *       UpdatePreferenceSetRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setPreferenceSet(PreferenceSet.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       migrationCenterClient.updatePreferenceSetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePreferenceSetRequest, Operation> updatePreferenceSetCallable() {
    return stub.updatePreferenceSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a preference set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   PreferenceSetName name = PreferenceSetName.of("[PROJECT]", "[LOCATION]", "[PREFERENCE_SET]");
   *   migrationCenterClient.deletePreferenceSetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the group resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePreferenceSetAsync(
      PreferenceSetName name) {
    DeletePreferenceSetRequest request =
        DeletePreferenceSetRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deletePreferenceSetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a preference set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String name = PreferenceSetName.of("[PROJECT]", "[LOCATION]", "[PREFERENCE_SET]").toString();
   *   migrationCenterClient.deletePreferenceSetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the group resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePreferenceSetAsync(String name) {
    DeletePreferenceSetRequest request =
        DeletePreferenceSetRequest.newBuilder().setName(name).build();
    return deletePreferenceSetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a preference set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   DeletePreferenceSetRequest request =
   *       DeletePreferenceSetRequest.newBuilder()
   *           .setName(
   *               PreferenceSetName.of("[PROJECT]", "[LOCATION]", "[PREFERENCE_SET]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   migrationCenterClient.deletePreferenceSetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePreferenceSetAsync(
      DeletePreferenceSetRequest request) {
    return deletePreferenceSetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a preference set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   DeletePreferenceSetRequest request =
   *       DeletePreferenceSetRequest.newBuilder()
   *           .setName(
   *               PreferenceSetName.of("[PROJECT]", "[LOCATION]", "[PREFERENCE_SET]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       migrationCenterClient.deletePreferenceSetOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeletePreferenceSetRequest, Empty, OperationMetadata>
      deletePreferenceSetOperationCallable() {
    return stub.deletePreferenceSetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a preference set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   DeletePreferenceSetRequest request =
   *       DeletePreferenceSetRequest.newBuilder()
   *           .setName(
   *               PreferenceSetName.of("[PROJECT]", "[LOCATION]", "[PREFERENCE_SET]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       migrationCenterClient.deletePreferenceSetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePreferenceSetRequest, Operation> deletePreferenceSetCallable() {
    return stub.deletePreferenceSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of regional settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   SettingsName name = SettingsName.of("[PROJECT]", "[LOCATION]");
   *   Settings response = migrationCenterClient.getSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings getSettings(SettingsName name) {
    GetSettingsRequest request =
        GetSettingsRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of regional settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String name = SettingsName.of("[PROJECT]", "[LOCATION]").toString();
   *   Settings response = migrationCenterClient.getSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings getSettings(String name) {
    GetSettingsRequest request = GetSettingsRequest.newBuilder().setName(name).build();
    return getSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of regional settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GetSettingsRequest request =
   *       GetSettingsRequest.newBuilder()
   *           .setName(SettingsName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   Settings response = migrationCenterClient.getSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings getSettings(GetSettingsRequest request) {
    return getSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of regional settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GetSettingsRequest request =
   *       GetSettingsRequest.newBuilder()
   *           .setName(SettingsName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<Settings> future = migrationCenterClient.getSettingsCallable().futureCall(request);
   *   // Do something.
   *   Settings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable() {
    return stub.getSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the regional-level project settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   Settings settings = Settings.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Settings response = migrationCenterClient.updateSettingsAsync(settings, updateMask).get();
   * }
   * }</pre>
   *
   * @param settings Required. The project settings resource being updated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     `Settings` resource by the update. The values specified in the `update_mask` field are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. A single &#42; value in the mask lets you to overwrite all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Settings, OperationMetadata> updateSettingsAsync(
      Settings settings, FieldMask updateMask) {
    UpdateSettingsRequest request =
        UpdateSettingsRequest.newBuilder().setSettings(settings).setUpdateMask(updateMask).build();
    return updateSettingsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the regional-level project settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   UpdateSettingsRequest request =
   *       UpdateSettingsRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSettings(Settings.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Settings response = migrationCenterClient.updateSettingsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Settings, OperationMetadata> updateSettingsAsync(
      UpdateSettingsRequest request) {
    return updateSettingsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the regional-level project settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   UpdateSettingsRequest request =
   *       UpdateSettingsRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSettings(Settings.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Settings, OperationMetadata> future =
   *       migrationCenterClient.updateSettingsOperationCallable().futureCall(request);
   *   // Do something.
   *   Settings response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateSettingsRequest, Settings, OperationMetadata>
      updateSettingsOperationCallable() {
    return stub.updateSettingsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the regional-level project settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   UpdateSettingsRequest request =
   *       UpdateSettingsRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSettings(Settings.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       migrationCenterClient.updateSettingsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSettingsRequest, Operation> updateSettingsCallable() {
    return stub.updateSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a report configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ReportConfig reportConfig = ReportConfig.newBuilder().build();
   *   String reportConfigId = "reportConfigId1951664465";
   *   ReportConfig response =
   *       migrationCenterClient.createReportConfigAsync(parent, reportConfig, reportConfigId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param reportConfig Required. The report config set resource being created.
   * @param reportConfigId Required. User specified ID for the report config. It will become the
   *     last component of the report config name. The ID must be unique within the project, must
   *     conform with RFC-1034, is restricted to lower-cased letters, and has a maximum length of 63
   *     characters. The ID must match the regular expression: [a-z]([a-z0-9-]{0,61}[a-z0-9])?.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ReportConfig, OperationMetadata> createReportConfigAsync(
      LocationName parent, ReportConfig reportConfig, String reportConfigId) {
    CreateReportConfigRequest request =
        CreateReportConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setReportConfig(reportConfig)
            .setReportConfigId(reportConfigId)
            .build();
    return createReportConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a report configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ReportConfig reportConfig = ReportConfig.newBuilder().build();
   *   String reportConfigId = "reportConfigId1951664465";
   *   ReportConfig response =
   *       migrationCenterClient.createReportConfigAsync(parent, reportConfig, reportConfigId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param reportConfig Required. The report config set resource being created.
   * @param reportConfigId Required. User specified ID for the report config. It will become the
   *     last component of the report config name. The ID must be unique within the project, must
   *     conform with RFC-1034, is restricted to lower-cased letters, and has a maximum length of 63
   *     characters. The ID must match the regular expression: [a-z]([a-z0-9-]{0,61}[a-z0-9])?.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ReportConfig, OperationMetadata> createReportConfigAsync(
      String parent, ReportConfig reportConfig, String reportConfigId) {
    CreateReportConfigRequest request =
        CreateReportConfigRequest.newBuilder()
            .setParent(parent)
            .setReportConfig(reportConfig)
            .setReportConfigId(reportConfigId)
            .build();
    return createReportConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a report configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   CreateReportConfigRequest request =
   *       CreateReportConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setReportConfigId("reportConfigId1951664465")
   *           .setReportConfig(ReportConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ReportConfig response = migrationCenterClient.createReportConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ReportConfig, OperationMetadata> createReportConfigAsync(
      CreateReportConfigRequest request) {
    return createReportConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a report configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   CreateReportConfigRequest request =
   *       CreateReportConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setReportConfigId("reportConfigId1951664465")
   *           .setReportConfig(ReportConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ReportConfig, OperationMetadata> future =
   *       migrationCenterClient.createReportConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   ReportConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateReportConfigRequest, ReportConfig, OperationMetadata>
      createReportConfigOperationCallable() {
    return stub.createReportConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a report configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   CreateReportConfigRequest request =
   *       CreateReportConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setReportConfigId("reportConfigId1951664465")
   *           .setReportConfig(ReportConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       migrationCenterClient.createReportConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateReportConfigRequest, Operation> createReportConfigCallable() {
    return stub.createReportConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ReportConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ReportConfigName name = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]");
   *   ReportConfig response = migrationCenterClient.getReportConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReportConfig getReportConfig(ReportConfigName name) {
    GetReportConfigRequest request =
        GetReportConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getReportConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ReportConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String name = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString();
   *   ReportConfig response = migrationCenterClient.getReportConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReportConfig getReportConfig(String name) {
    GetReportConfigRequest request = GetReportConfigRequest.newBuilder().setName(name).build();
    return getReportConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ReportConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GetReportConfigRequest request =
   *       GetReportConfigRequest.newBuilder()
   *           .setName(ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
   *           .build();
   *   ReportConfig response = migrationCenterClient.getReportConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReportConfig getReportConfig(GetReportConfigRequest request) {
    return getReportConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ReportConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GetReportConfigRequest request =
   *       GetReportConfigRequest.newBuilder()
   *           .setName(ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
   *           .build();
   *   ApiFuture<ReportConfig> future =
   *       migrationCenterClient.getReportConfigCallable().futureCall(request);
   *   // Do something.
   *   ReportConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetReportConfigRequest, ReportConfig> getReportConfigCallable() {
    return stub.getReportConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ReportConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ReportConfig element : migrationCenterClient.listReportConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for `ListReportConfigsRequest`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReportConfigsPagedResponse listReportConfigs(LocationName parent) {
    ListReportConfigsRequest request =
        ListReportConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listReportConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ReportConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ReportConfig element : migrationCenterClient.listReportConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for `ListReportConfigsRequest`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReportConfigsPagedResponse listReportConfigs(String parent) {
    ListReportConfigsRequest request =
        ListReportConfigsRequest.newBuilder().setParent(parent).build();
    return listReportConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ReportConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListReportConfigsRequest request =
   *       ListReportConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ReportConfig element : migrationCenterClient.listReportConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReportConfigsPagedResponse listReportConfigs(ListReportConfigsRequest request) {
    return listReportConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ReportConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListReportConfigsRequest request =
   *       ListReportConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ReportConfig> future =
   *       migrationCenterClient.listReportConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ReportConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReportConfigsRequest, ListReportConfigsPagedResponse>
      listReportConfigsPagedCallable() {
    return stub.listReportConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ReportConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListReportConfigsRequest request =
   *       ListReportConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListReportConfigsResponse response =
   *         migrationCenterClient.listReportConfigsCallable().call(request);
   *     for (ReportConfig element : response.getReportConfigsList()) {
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
  public final UnaryCallable<ListReportConfigsRequest, ListReportConfigsResponse>
      listReportConfigsCallable() {
    return stub.listReportConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ReportConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ReportConfigName name = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]");
   *   migrationCenterClient.deleteReportConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteReportConfigAsync(
      ReportConfigName name) {
    DeleteReportConfigRequest request =
        DeleteReportConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteReportConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ReportConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String name = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString();
   *   migrationCenterClient.deleteReportConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteReportConfigAsync(String name) {
    DeleteReportConfigRequest request =
        DeleteReportConfigRequest.newBuilder().setName(name).build();
    return deleteReportConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ReportConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   DeleteReportConfigRequest request =
   *       DeleteReportConfigRequest.newBuilder()
   *           .setName(ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   migrationCenterClient.deleteReportConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteReportConfigAsync(
      DeleteReportConfigRequest request) {
    return deleteReportConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ReportConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   DeleteReportConfigRequest request =
   *       DeleteReportConfigRequest.newBuilder()
   *           .setName(ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       migrationCenterClient.deleteReportConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteReportConfigRequest, Empty, OperationMetadata>
      deleteReportConfigOperationCallable() {
    return stub.deleteReportConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ReportConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   DeleteReportConfigRequest request =
   *       DeleteReportConfigRequest.newBuilder()
   *           .setName(ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       migrationCenterClient.deleteReportConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteReportConfigRequest, Operation> deleteReportConfigCallable() {
    return stub.deleteReportConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ReportConfigName parent = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]");
   *   Report report = Report.newBuilder().build();
   *   String reportId = "reportId-427040401";
   *   Report response = migrationCenterClient.createReportAsync(parent, report, reportId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param report Required. The report resource being created.
   * @param reportId Required. User specified id for the report. It will become the last component
   *     of the report name. The id must be unique within the project, must conform with RFC-1034,
   *     is restricted to lower-cased letters, and has a maximum length of 63 characters. The id
   *     must match the regular expression: [a-z]([a-z0-9-]{0,61}[a-z0-9])?.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Report, OperationMetadata> createReportAsync(
      ReportConfigName parent, Report report, String reportId) {
    CreateReportRequest request =
        CreateReportRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setReport(report)
            .setReportId(reportId)
            .build();
    return createReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String parent = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString();
   *   Report report = Report.newBuilder().build();
   *   String reportId = "reportId-427040401";
   *   Report response = migrationCenterClient.createReportAsync(parent, report, reportId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param report Required. The report resource being created.
   * @param reportId Required. User specified id for the report. It will become the last component
   *     of the report name. The id must be unique within the project, must conform with RFC-1034,
   *     is restricted to lower-cased letters, and has a maximum length of 63 characters. The id
   *     must match the regular expression: [a-z]([a-z0-9-]{0,61}[a-z0-9])?.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Report, OperationMetadata> createReportAsync(
      String parent, Report report, String reportId) {
    CreateReportRequest request =
        CreateReportRequest.newBuilder()
            .setParent(parent)
            .setReport(report)
            .setReportId(reportId)
            .build();
    return createReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   CreateReportRequest request =
   *       CreateReportRequest.newBuilder()
   *           .setParent(
   *               ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
   *           .setReportId("reportId-427040401")
   *           .setReport(Report.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Report response = migrationCenterClient.createReportAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Report, OperationMetadata> createReportAsync(
      CreateReportRequest request) {
    return createReportOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   CreateReportRequest request =
   *       CreateReportRequest.newBuilder()
   *           .setParent(
   *               ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
   *           .setReportId("reportId-427040401")
   *           .setReport(Report.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Report, OperationMetadata> future =
   *       migrationCenterClient.createReportOperationCallable().futureCall(request);
   *   // Do something.
   *   Report response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateReportRequest, Report, OperationMetadata>
      createReportOperationCallable() {
    return stub.createReportOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   CreateReportRequest request =
   *       CreateReportRequest.newBuilder()
   *           .setParent(
   *               ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
   *           .setReportId("reportId-427040401")
   *           .setReport(Report.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       migrationCenterClient.createReportCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateReportRequest, Operation> createReportCallable() {
    return stub.createReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ReportName name = ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]", "[REPORT]");
   *   Report response = migrationCenterClient.getReport(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Report getReport(ReportName name) {
    GetReportRequest request =
        GetReportRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String name =
   *       ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]", "[REPORT]").toString();
   *   Report response = migrationCenterClient.getReport(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Report getReport(String name) {
    GetReportRequest request = GetReportRequest.newBuilder().setName(name).build();
    return getReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GetReportRequest request =
   *       GetReportRequest.newBuilder()
   *           .setName(
   *               ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]", "[REPORT]")
   *                   .toString())
   *           .setView(ReportView.forNumber(0))
   *           .build();
   *   Report response = migrationCenterClient.getReport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Report getReport(GetReportRequest request) {
    return getReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GetReportRequest request =
   *       GetReportRequest.newBuilder()
   *           .setName(
   *               ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]", "[REPORT]")
   *                   .toString())
   *           .setView(ReportView.forNumber(0))
   *           .build();
   *   ApiFuture<Report> future = migrationCenterClient.getReportCallable().futureCall(request);
   *   // Do something.
   *   Report response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetReportRequest, Report> getReportCallable() {
    return stub.getReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Reports in a given ReportConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ReportConfigName parent = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]");
   *   for (Report element : migrationCenterClient.listReports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for `ListReportsRequest`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReportsPagedResponse listReports(ReportConfigName parent) {
    ListReportsRequest request =
        ListReportsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listReports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Reports in a given ReportConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String parent = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString();
   *   for (Report element : migrationCenterClient.listReports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for `ListReportsRequest`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReportsPagedResponse listReports(String parent) {
    ListReportsRequest request = ListReportsRequest.newBuilder().setParent(parent).build();
    return listReports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Reports in a given ReportConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListReportsRequest request =
   *       ListReportsRequest.newBuilder()
   *           .setParent(
   *               ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(ReportView.forNumber(0))
   *           .build();
   *   for (Report element : migrationCenterClient.listReports(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReportsPagedResponse listReports(ListReportsRequest request) {
    return listReportsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Reports in a given ReportConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListReportsRequest request =
   *       ListReportsRequest.newBuilder()
   *           .setParent(
   *               ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(ReportView.forNumber(0))
   *           .build();
   *   ApiFuture<Report> future =
   *       migrationCenterClient.listReportsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Report element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReportsRequest, ListReportsPagedResponse>
      listReportsPagedCallable() {
    return stub.listReportsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Reports in a given ReportConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListReportsRequest request =
   *       ListReportsRequest.newBuilder()
   *           .setParent(
   *               ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(ReportView.forNumber(0))
   *           .build();
   *   while (true) {
   *     ListReportsResponse response = migrationCenterClient.listReportsCallable().call(request);
   *     for (Report element : response.getReportsList()) {
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
  public final UnaryCallable<ListReportsRequest, ListReportsResponse> listReportsCallable() {
    return stub.listReportsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ReportName name = ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]", "[REPORT]");
   *   migrationCenterClient.deleteReportAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteReportAsync(ReportName name) {
    DeleteReportRequest request =
        DeleteReportRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   String name =
   *       ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]", "[REPORT]").toString();
   *   migrationCenterClient.deleteReportAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteReportAsync(String name) {
    DeleteReportRequest request = DeleteReportRequest.newBuilder().setName(name).build();
    return deleteReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   DeleteReportRequest request =
   *       DeleteReportRequest.newBuilder()
   *           .setName(
   *               ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]", "[REPORT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   migrationCenterClient.deleteReportAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteReportAsync(
      DeleteReportRequest request) {
    return deleteReportOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   DeleteReportRequest request =
   *       DeleteReportRequest.newBuilder()
   *           .setName(
   *               ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]", "[REPORT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       migrationCenterClient.deleteReportOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteReportRequest, Empty, OperationMetadata>
      deleteReportOperationCallable() {
    return stub.deleteReportOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   DeleteReportRequest request =
   *       DeleteReportRequest.newBuilder()
   *           .setName(
   *               ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]", "[REPORT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       migrationCenterClient.deleteReportCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteReportRequest, Operation> deleteReportCallable() {
    return stub.deleteReportCallable();
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
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : migrationCenterClient.listLocations(request).iterateAll()) {
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
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       migrationCenterClient.listLocationsPagedCallable().futureCall(request);
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
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         migrationCenterClient.listLocationsCallable().call(request);
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
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = migrationCenterClient.getLocation(request);
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
   * try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = migrationCenterClient.getLocationCallable().futureCall(request);
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

  public static class ListAssetsPagedResponse
      extends AbstractPagedListResponse<
          ListAssetsRequest,
          ListAssetsResponse,
          Asset,
          ListAssetsPage,
          ListAssetsFixedSizeCollection> {

    public static ApiFuture<ListAssetsPagedResponse> createAsync(
        PageContext<ListAssetsRequest, ListAssetsResponse, Asset> context,
        ApiFuture<ListAssetsResponse> futureResponse) {
      ApiFuture<ListAssetsPage> futurePage =
          ListAssetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListAssetsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListAssetsPagedResponse(ListAssetsPage page) {
      super(page, ListAssetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAssetsPage
      extends AbstractPage<ListAssetsRequest, ListAssetsResponse, Asset, ListAssetsPage> {

    private ListAssetsPage(
        PageContext<ListAssetsRequest, ListAssetsResponse, Asset> context,
        ListAssetsResponse response) {
      super(context, response);
    }

    private static ListAssetsPage createEmptyPage() {
      return new ListAssetsPage(null, null);
    }

    @Override
    protected ListAssetsPage createPage(
        PageContext<ListAssetsRequest, ListAssetsResponse, Asset> context,
        ListAssetsResponse response) {
      return new ListAssetsPage(context, response);
    }

    @Override
    public ApiFuture<ListAssetsPage> createPageAsync(
        PageContext<ListAssetsRequest, ListAssetsResponse, Asset> context,
        ApiFuture<ListAssetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAssetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAssetsRequest,
          ListAssetsResponse,
          Asset,
          ListAssetsPage,
          ListAssetsFixedSizeCollection> {

    private ListAssetsFixedSizeCollection(List<ListAssetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAssetsFixedSizeCollection createEmptyCollection() {
      return new ListAssetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAssetsFixedSizeCollection createCollection(
        List<ListAssetsPage> pages, int collectionSize) {
      return new ListAssetsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListImportJobsPagedResponse
      extends AbstractPagedListResponse<
          ListImportJobsRequest,
          ListImportJobsResponse,
          ImportJob,
          ListImportJobsPage,
          ListImportJobsFixedSizeCollection> {

    public static ApiFuture<ListImportJobsPagedResponse> createAsync(
        PageContext<ListImportJobsRequest, ListImportJobsResponse, ImportJob> context,
        ApiFuture<ListImportJobsResponse> futureResponse) {
      ApiFuture<ListImportJobsPage> futurePage =
          ListImportJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListImportJobsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListImportJobsPagedResponse(ListImportJobsPage page) {
      super(page, ListImportJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListImportJobsPage
      extends AbstractPage<
          ListImportJobsRequest, ListImportJobsResponse, ImportJob, ListImportJobsPage> {

    private ListImportJobsPage(
        PageContext<ListImportJobsRequest, ListImportJobsResponse, ImportJob> context,
        ListImportJobsResponse response) {
      super(context, response);
    }

    private static ListImportJobsPage createEmptyPage() {
      return new ListImportJobsPage(null, null);
    }

    @Override
    protected ListImportJobsPage createPage(
        PageContext<ListImportJobsRequest, ListImportJobsResponse, ImportJob> context,
        ListImportJobsResponse response) {
      return new ListImportJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListImportJobsPage> createPageAsync(
        PageContext<ListImportJobsRequest, ListImportJobsResponse, ImportJob> context,
        ApiFuture<ListImportJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListImportJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListImportJobsRequest,
          ListImportJobsResponse,
          ImportJob,
          ListImportJobsPage,
          ListImportJobsFixedSizeCollection> {

    private ListImportJobsFixedSizeCollection(List<ListImportJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListImportJobsFixedSizeCollection createEmptyCollection() {
      return new ListImportJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListImportJobsFixedSizeCollection createCollection(
        List<ListImportJobsPage> pages, int collectionSize) {
      return new ListImportJobsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListImportDataFilesPagedResponse
      extends AbstractPagedListResponse<
          ListImportDataFilesRequest,
          ListImportDataFilesResponse,
          ImportDataFile,
          ListImportDataFilesPage,
          ListImportDataFilesFixedSizeCollection> {

    public static ApiFuture<ListImportDataFilesPagedResponse> createAsync(
        PageContext<ListImportDataFilesRequest, ListImportDataFilesResponse, ImportDataFile>
            context,
        ApiFuture<ListImportDataFilesResponse> futureResponse) {
      ApiFuture<ListImportDataFilesPage> futurePage =
          ListImportDataFilesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListImportDataFilesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListImportDataFilesPagedResponse(ListImportDataFilesPage page) {
      super(page, ListImportDataFilesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListImportDataFilesPage
      extends AbstractPage<
          ListImportDataFilesRequest,
          ListImportDataFilesResponse,
          ImportDataFile,
          ListImportDataFilesPage> {

    private ListImportDataFilesPage(
        PageContext<ListImportDataFilesRequest, ListImportDataFilesResponse, ImportDataFile>
            context,
        ListImportDataFilesResponse response) {
      super(context, response);
    }

    private static ListImportDataFilesPage createEmptyPage() {
      return new ListImportDataFilesPage(null, null);
    }

    @Override
    protected ListImportDataFilesPage createPage(
        PageContext<ListImportDataFilesRequest, ListImportDataFilesResponse, ImportDataFile>
            context,
        ListImportDataFilesResponse response) {
      return new ListImportDataFilesPage(context, response);
    }

    @Override
    public ApiFuture<ListImportDataFilesPage> createPageAsync(
        PageContext<ListImportDataFilesRequest, ListImportDataFilesResponse, ImportDataFile>
            context,
        ApiFuture<ListImportDataFilesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListImportDataFilesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListImportDataFilesRequest,
          ListImportDataFilesResponse,
          ImportDataFile,
          ListImportDataFilesPage,
          ListImportDataFilesFixedSizeCollection> {

    private ListImportDataFilesFixedSizeCollection(
        List<ListImportDataFilesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListImportDataFilesFixedSizeCollection createEmptyCollection() {
      return new ListImportDataFilesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListImportDataFilesFixedSizeCollection createCollection(
        List<ListImportDataFilesPage> pages, int collectionSize) {
      return new ListImportDataFilesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListGroupsRequest,
          ListGroupsResponse,
          Group,
          ListGroupsPage,
          ListGroupsFixedSizeCollection> {

    public static ApiFuture<ListGroupsPagedResponse> createAsync(
        PageContext<ListGroupsRequest, ListGroupsResponse, Group> context,
        ApiFuture<ListGroupsResponse> futureResponse) {
      ApiFuture<ListGroupsPage> futurePage =
          ListGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListGroupsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListGroupsPagedResponse(ListGroupsPage page) {
      super(page, ListGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGroupsPage
      extends AbstractPage<ListGroupsRequest, ListGroupsResponse, Group, ListGroupsPage> {

    private ListGroupsPage(
        PageContext<ListGroupsRequest, ListGroupsResponse, Group> context,
        ListGroupsResponse response) {
      super(context, response);
    }

    private static ListGroupsPage createEmptyPage() {
      return new ListGroupsPage(null, null);
    }

    @Override
    protected ListGroupsPage createPage(
        PageContext<ListGroupsRequest, ListGroupsResponse, Group> context,
        ListGroupsResponse response) {
      return new ListGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListGroupsPage> createPageAsync(
        PageContext<ListGroupsRequest, ListGroupsResponse, Group> context,
        ApiFuture<ListGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGroupsRequest,
          ListGroupsResponse,
          Group,
          ListGroupsPage,
          ListGroupsFixedSizeCollection> {

    private ListGroupsFixedSizeCollection(List<ListGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGroupsFixedSizeCollection createEmptyCollection() {
      return new ListGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGroupsFixedSizeCollection createCollection(
        List<ListGroupsPage> pages, int collectionSize) {
      return new ListGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListErrorFramesPagedResponse
      extends AbstractPagedListResponse<
          ListErrorFramesRequest,
          ListErrorFramesResponse,
          ErrorFrame,
          ListErrorFramesPage,
          ListErrorFramesFixedSizeCollection> {

    public static ApiFuture<ListErrorFramesPagedResponse> createAsync(
        PageContext<ListErrorFramesRequest, ListErrorFramesResponse, ErrorFrame> context,
        ApiFuture<ListErrorFramesResponse> futureResponse) {
      ApiFuture<ListErrorFramesPage> futurePage =
          ListErrorFramesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListErrorFramesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListErrorFramesPagedResponse(ListErrorFramesPage page) {
      super(page, ListErrorFramesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListErrorFramesPage
      extends AbstractPage<
          ListErrorFramesRequest, ListErrorFramesResponse, ErrorFrame, ListErrorFramesPage> {

    private ListErrorFramesPage(
        PageContext<ListErrorFramesRequest, ListErrorFramesResponse, ErrorFrame> context,
        ListErrorFramesResponse response) {
      super(context, response);
    }

    private static ListErrorFramesPage createEmptyPage() {
      return new ListErrorFramesPage(null, null);
    }

    @Override
    protected ListErrorFramesPage createPage(
        PageContext<ListErrorFramesRequest, ListErrorFramesResponse, ErrorFrame> context,
        ListErrorFramesResponse response) {
      return new ListErrorFramesPage(context, response);
    }

    @Override
    public ApiFuture<ListErrorFramesPage> createPageAsync(
        PageContext<ListErrorFramesRequest, ListErrorFramesResponse, ErrorFrame> context,
        ApiFuture<ListErrorFramesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListErrorFramesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListErrorFramesRequest,
          ListErrorFramesResponse,
          ErrorFrame,
          ListErrorFramesPage,
          ListErrorFramesFixedSizeCollection> {

    private ListErrorFramesFixedSizeCollection(
        List<ListErrorFramesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListErrorFramesFixedSizeCollection createEmptyCollection() {
      return new ListErrorFramesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListErrorFramesFixedSizeCollection createCollection(
        List<ListErrorFramesPage> pages, int collectionSize) {
      return new ListErrorFramesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSourcesPagedResponse
      extends AbstractPagedListResponse<
          ListSourcesRequest,
          ListSourcesResponse,
          Source,
          ListSourcesPage,
          ListSourcesFixedSizeCollection> {

    public static ApiFuture<ListSourcesPagedResponse> createAsync(
        PageContext<ListSourcesRequest, ListSourcesResponse, Source> context,
        ApiFuture<ListSourcesResponse> futureResponse) {
      ApiFuture<ListSourcesPage> futurePage =
          ListSourcesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSourcesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSourcesPagedResponse(ListSourcesPage page) {
      super(page, ListSourcesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSourcesPage
      extends AbstractPage<ListSourcesRequest, ListSourcesResponse, Source, ListSourcesPage> {

    private ListSourcesPage(
        PageContext<ListSourcesRequest, ListSourcesResponse, Source> context,
        ListSourcesResponse response) {
      super(context, response);
    }

    private static ListSourcesPage createEmptyPage() {
      return new ListSourcesPage(null, null);
    }

    @Override
    protected ListSourcesPage createPage(
        PageContext<ListSourcesRequest, ListSourcesResponse, Source> context,
        ListSourcesResponse response) {
      return new ListSourcesPage(context, response);
    }

    @Override
    public ApiFuture<ListSourcesPage> createPageAsync(
        PageContext<ListSourcesRequest, ListSourcesResponse, Source> context,
        ApiFuture<ListSourcesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSourcesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSourcesRequest,
          ListSourcesResponse,
          Source,
          ListSourcesPage,
          ListSourcesFixedSizeCollection> {

    private ListSourcesFixedSizeCollection(List<ListSourcesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSourcesFixedSizeCollection createEmptyCollection() {
      return new ListSourcesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSourcesFixedSizeCollection createCollection(
        List<ListSourcesPage> pages, int collectionSize) {
      return new ListSourcesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPreferenceSetsPagedResponse
      extends AbstractPagedListResponse<
          ListPreferenceSetsRequest,
          ListPreferenceSetsResponse,
          PreferenceSet,
          ListPreferenceSetsPage,
          ListPreferenceSetsFixedSizeCollection> {

    public static ApiFuture<ListPreferenceSetsPagedResponse> createAsync(
        PageContext<ListPreferenceSetsRequest, ListPreferenceSetsResponse, PreferenceSet> context,
        ApiFuture<ListPreferenceSetsResponse> futureResponse) {
      ApiFuture<ListPreferenceSetsPage> futurePage =
          ListPreferenceSetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPreferenceSetsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPreferenceSetsPagedResponse(ListPreferenceSetsPage page) {
      super(page, ListPreferenceSetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPreferenceSetsPage
      extends AbstractPage<
          ListPreferenceSetsRequest,
          ListPreferenceSetsResponse,
          PreferenceSet,
          ListPreferenceSetsPage> {

    private ListPreferenceSetsPage(
        PageContext<ListPreferenceSetsRequest, ListPreferenceSetsResponse, PreferenceSet> context,
        ListPreferenceSetsResponse response) {
      super(context, response);
    }

    private static ListPreferenceSetsPage createEmptyPage() {
      return new ListPreferenceSetsPage(null, null);
    }

    @Override
    protected ListPreferenceSetsPage createPage(
        PageContext<ListPreferenceSetsRequest, ListPreferenceSetsResponse, PreferenceSet> context,
        ListPreferenceSetsResponse response) {
      return new ListPreferenceSetsPage(context, response);
    }

    @Override
    public ApiFuture<ListPreferenceSetsPage> createPageAsync(
        PageContext<ListPreferenceSetsRequest, ListPreferenceSetsResponse, PreferenceSet> context,
        ApiFuture<ListPreferenceSetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPreferenceSetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPreferenceSetsRequest,
          ListPreferenceSetsResponse,
          PreferenceSet,
          ListPreferenceSetsPage,
          ListPreferenceSetsFixedSizeCollection> {

    private ListPreferenceSetsFixedSizeCollection(
        List<ListPreferenceSetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPreferenceSetsFixedSizeCollection createEmptyCollection() {
      return new ListPreferenceSetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPreferenceSetsFixedSizeCollection createCollection(
        List<ListPreferenceSetsPage> pages, int collectionSize) {
      return new ListPreferenceSetsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListReportConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListReportConfigsRequest,
          ListReportConfigsResponse,
          ReportConfig,
          ListReportConfigsPage,
          ListReportConfigsFixedSizeCollection> {

    public static ApiFuture<ListReportConfigsPagedResponse> createAsync(
        PageContext<ListReportConfigsRequest, ListReportConfigsResponse, ReportConfig> context,
        ApiFuture<ListReportConfigsResponse> futureResponse) {
      ApiFuture<ListReportConfigsPage> futurePage =
          ListReportConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListReportConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListReportConfigsPagedResponse(ListReportConfigsPage page) {
      super(page, ListReportConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListReportConfigsPage
      extends AbstractPage<
          ListReportConfigsRequest,
          ListReportConfigsResponse,
          ReportConfig,
          ListReportConfigsPage> {

    private ListReportConfigsPage(
        PageContext<ListReportConfigsRequest, ListReportConfigsResponse, ReportConfig> context,
        ListReportConfigsResponse response) {
      super(context, response);
    }

    private static ListReportConfigsPage createEmptyPage() {
      return new ListReportConfigsPage(null, null);
    }

    @Override
    protected ListReportConfigsPage createPage(
        PageContext<ListReportConfigsRequest, ListReportConfigsResponse, ReportConfig> context,
        ListReportConfigsResponse response) {
      return new ListReportConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListReportConfigsPage> createPageAsync(
        PageContext<ListReportConfigsRequest, ListReportConfigsResponse, ReportConfig> context,
        ApiFuture<ListReportConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReportConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReportConfigsRequest,
          ListReportConfigsResponse,
          ReportConfig,
          ListReportConfigsPage,
          ListReportConfigsFixedSizeCollection> {

    private ListReportConfigsFixedSizeCollection(
        List<ListReportConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListReportConfigsFixedSizeCollection createEmptyCollection() {
      return new ListReportConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListReportConfigsFixedSizeCollection createCollection(
        List<ListReportConfigsPage> pages, int collectionSize) {
      return new ListReportConfigsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListReportsPagedResponse
      extends AbstractPagedListResponse<
          ListReportsRequest,
          ListReportsResponse,
          Report,
          ListReportsPage,
          ListReportsFixedSizeCollection> {

    public static ApiFuture<ListReportsPagedResponse> createAsync(
        PageContext<ListReportsRequest, ListReportsResponse, Report> context,
        ApiFuture<ListReportsResponse> futureResponse) {
      ApiFuture<ListReportsPage> futurePage =
          ListReportsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListReportsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListReportsPagedResponse(ListReportsPage page) {
      super(page, ListReportsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListReportsPage
      extends AbstractPage<ListReportsRequest, ListReportsResponse, Report, ListReportsPage> {

    private ListReportsPage(
        PageContext<ListReportsRequest, ListReportsResponse, Report> context,
        ListReportsResponse response) {
      super(context, response);
    }

    private static ListReportsPage createEmptyPage() {
      return new ListReportsPage(null, null);
    }

    @Override
    protected ListReportsPage createPage(
        PageContext<ListReportsRequest, ListReportsResponse, Report> context,
        ListReportsResponse response) {
      return new ListReportsPage(context, response);
    }

    @Override
    public ApiFuture<ListReportsPage> createPageAsync(
        PageContext<ListReportsRequest, ListReportsResponse, Report> context,
        ApiFuture<ListReportsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReportsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReportsRequest,
          ListReportsResponse,
          Report,
          ListReportsPage,
          ListReportsFixedSizeCollection> {

    private ListReportsFixedSizeCollection(List<ListReportsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListReportsFixedSizeCollection createEmptyCollection() {
      return new ListReportsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListReportsFixedSizeCollection createCollection(
        List<ListReportsPage> pages, int collectionSize) {
      return new ListReportsFixedSizeCollection(pages, collectionSize);
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
