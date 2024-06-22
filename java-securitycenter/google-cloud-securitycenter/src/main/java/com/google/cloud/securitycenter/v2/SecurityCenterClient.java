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

package com.google.cloud.securitycenter.v2;

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
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.securitycenter.v2.stub.SecurityCenterStub;
import com.google.cloud.securitycenter.v2.stub.SecurityCenterStubSettings;
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
 * Service Description: V2 APIs for Security Center service.
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
 * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
 *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
 *   List<CreateResourceValueConfigRequest> requests = new ArrayList<>();
 *   BatchCreateResourceValueConfigsResponse response =
 *       securityCenterClient.batchCreateResourceValueConfigs(parent, requests);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SecurityCenterClient object to clean up resources such
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
 *      <td><p> BatchCreateResourceValueConfigs</td>
 *      <td><p> Creates a ResourceValueConfig for an organization. Maps user's tags to difference resource values for use by the attack path simulation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateResourceValueConfigs(OrganizationName parent, List&lt;CreateResourceValueConfigRequest&gt; requests)
 *           <li><p> batchCreateResourceValueConfigs(String parent, List&lt;CreateResourceValueConfigRequest&gt; requests)
 *           <li><p> batchCreateResourceValueConfigs(BatchCreateResourceValueConfigsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateResourceValueConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BulkMuteFindings</td>
 *      <td><p> Kicks off an LRO to bulk mute findings for a parent based on a filter. If no location is specified, findings are muted in global. The parent can be either an organization, folder, or project. The findings matched by the filter will be muted after the LRO is done.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> bulkMuteFindingsAsync(BulkMuteFindingsRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> bulkMuteFindingsAsync(ResourceName parent)
 *           <li><p> bulkMuteFindingsAsync(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> bulkMuteFindingsOperationCallable()
 *           <li><p> bulkMuteFindingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateBigQueryExport</td>
 *      <td><p> Creates a BigQuery export.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createBigQueryExport(CreateBigQueryExportRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createBigQueryExport(FolderLocationName parent, BigQueryExport bigQueryExport, String bigQueryExportId)
 *           <li><p> createBigQueryExport(LocationName parent, BigQueryExport bigQueryExport, String bigQueryExportId)
 *           <li><p> createBigQueryExport(OrganizationLocationName parent, BigQueryExport bigQueryExport, String bigQueryExportId)
 *           <li><p> createBigQueryExport(String parent, BigQueryExport bigQueryExport, String bigQueryExportId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createBigQueryExportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateFinding</td>
 *      <td><p> Creates a finding in a location. The corresponding source must exist for finding creation to succeed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createFinding(CreateFindingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createFinding(SourceName parent, Finding finding, String findingId)
 *           <li><p> createFinding(String parent, Finding finding, String findingId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createFindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateMuteConfig</td>
 *      <td><p> Creates a mute config.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createMuteConfig(CreateMuteConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createMuteConfig(FolderLocationName parent, MuteConfig muteConfig, String muteConfigId)
 *           <li><p> createMuteConfig(FolderName parent, MuteConfig muteConfig, String muteConfigId)
 *           <li><p> createMuteConfig(LocationName parent, MuteConfig muteConfig, String muteConfigId)
 *           <li><p> createMuteConfig(OrganizationLocationName parent, MuteConfig muteConfig, String muteConfigId)
 *           <li><p> createMuteConfig(OrganizationName parent, MuteConfig muteConfig, String muteConfigId)
 *           <li><p> createMuteConfig(ProjectName parent, MuteConfig muteConfig, String muteConfigId)
 *           <li><p> createMuteConfig(String parent, MuteConfig muteConfig, String muteConfigId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createMuteConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateNotificationConfig</td>
 *      <td><p> Creates a notification config.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createNotificationConfig(CreateNotificationConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createNotificationConfig(FolderLocationName parent, NotificationConfig notificationConfig, String configId)
 *           <li><p> createNotificationConfig(LocationName parent, NotificationConfig notificationConfig, String configId)
 *           <li><p> createNotificationConfig(OrganizationLocationName parent, NotificationConfig notificationConfig, String configId)
 *           <li><p> createNotificationConfig(String parent, NotificationConfig notificationConfig, String configId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createNotificationConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSource</td>
 *      <td><p> Creates a source.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSource(CreateSourceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSource(OrganizationName parent, Source source)
 *           <li><p> createSource(String parent, Source source)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteBigQueryExport</td>
 *      <td><p> Deletes an existing BigQuery export.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteBigQueryExport(DeleteBigQueryExportRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteBigQueryExport(BigQueryExportName name)
 *           <li><p> deleteBigQueryExport(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteBigQueryExportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteMuteConfig</td>
 *      <td><p> Deletes an existing mute config. If no location is specified, default is global.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteMuteConfig(DeleteMuteConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteMuteConfig(MuteConfigName name)
 *           <li><p> deleteMuteConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteMuteConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteNotificationConfig</td>
 *      <td><p> Deletes a notification config.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteNotificationConfig(DeleteNotificationConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteNotificationConfig(NotificationConfigName name)
 *           <li><p> deleteNotificationConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteNotificationConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteResourceValueConfig</td>
 *      <td><p> Deletes a ResourceValueConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteResourceValueConfig(DeleteResourceValueConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteResourceValueConfig(ResourceValueConfigName name)
 *           <li><p> deleteResourceValueConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteResourceValueConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBigQueryExport</td>
 *      <td><p> Gets a BigQuery export.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBigQueryExport(GetBigQueryExportRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBigQueryExport(BigQueryExportName name)
 *           <li><p> getBigQueryExport(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBigQueryExportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSimulation</td>
 *      <td><p> Get the simulation by name or the latest simulation for the given organization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSimulation(GetSimulationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSimulation(SimulationName name)
 *           <li><p> getSimulation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSimulationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetValuedResource</td>
 *      <td><p> Get the valued resource by name</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getValuedResource(GetValuedResourceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getValuedResource(ValuedResourceName name)
 *           <li><p> getValuedResource(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getValuedResourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the access control policy on the specified Source.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getIamPolicy(ResourceName resource)
 *           <li><p> getIamPolicy(String resource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetMuteConfig</td>
 *      <td><p> Gets a mute config. If no location is specified, default is global.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMuteConfig(GetMuteConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMuteConfig(MuteConfigName name)
 *           <li><p> getMuteConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMuteConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetNotificationConfig</td>
 *      <td><p> Gets a notification config.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getNotificationConfig(GetNotificationConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getNotificationConfig(NotificationConfigName name)
 *           <li><p> getNotificationConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getNotificationConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetResourceValueConfig</td>
 *      <td><p> Gets a ResourceValueConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getResourceValueConfig(GetResourceValueConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getResourceValueConfig(ResourceValueConfigName name)
 *           <li><p> getResourceValueConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getResourceValueConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSource</td>
 *      <td><p> Gets a source.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSource(GetSourceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSource(SourceName name)
 *           <li><p> getSource(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GroupFindings</td>
 *      <td><p> Filters an organization or source's findings and groups them by their specified properties in a location. If no location is specified, findings are assumed to be in global
 * <p>  To group across all sources provide a `-` as the source id. The following list shows some examples:
 * <p>  + `/v2/organizations/{organization_id}/sources/-/findings` + `/v2/organizations/{organization_id}/sources/-/locations/{location_id}/findings` + `/v2/folders/{folder_id}/sources/-/findings` + `/v2/folders/{folder_id}/sources/-/locations/{location_id}/findings` + `/v2/projects/{project_id}/sources/-/findings` + `/v2/projects/{project_id}/sources/-/locations/{location_id}/findings`</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> groupFindings(GroupFindingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> groupFindings(SourceName parent, String groupBy)
 *           <li><p> groupFindings(String parent, String groupBy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> groupFindingsPagedCallable()
 *           <li><p> groupFindingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAttackPaths</td>
 *      <td><p> Lists the attack paths for a set of simulation results or valued resources and filter.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAttackPaths(ListAttackPathsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAttackPaths(ValuedResourceName parent)
 *           <li><p> listAttackPaths(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAttackPathsPagedCallable()
 *           <li><p> listAttackPathsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBigQueryExports</td>
 *      <td><p> Lists BigQuery exports. Note that when requesting BigQuery exports at a given level all exports under that level are also returned e.g. if requesting BigQuery exports under a folder, then all BigQuery exports immediately under the folder plus the ones created under the projects within the folder are returned.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBigQueryExports(ListBigQueryExportsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBigQueryExports(FolderLocationName parent)
 *           <li><p> listBigQueryExports(LocationName parent)
 *           <li><p> listBigQueryExports(OrganizationLocationName parent)
 *           <li><p> listBigQueryExports(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBigQueryExportsPagedCallable()
 *           <li><p> listBigQueryExportsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListFindings</td>
 *      <td><p> Lists an organization or source's findings.
 * <p>  To list across all sources for a given location provide a `-` as the source id. If no location is specified, finding are assumed to be in global. The following list shows some examples:
 * <p>  + `/v2/organizations/{organization_id}/sources/-/findings` + `/v2/organizations/{organization_id}/sources/-/locations/{location_id}/findings`</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listFindings(ListFindingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listFindings(SourceName parent)
 *           <li><p> listFindings(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listFindingsPagedCallable()
 *           <li><p> listFindingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMuteConfigs</td>
 *      <td><p> Lists mute configs. If no location is specified, default is global.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMuteConfigs(ListMuteConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMuteConfigs(FolderLocationName parent)
 *           <li><p> listMuteConfigs(FolderName parent)
 *           <li><p> listMuteConfigs(LocationName parent)
 *           <li><p> listMuteConfigs(OrganizationLocationName parent)
 *           <li><p> listMuteConfigs(OrganizationName parent)
 *           <li><p> listMuteConfigs(ProjectName parent)
 *           <li><p> listMuteConfigs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMuteConfigsPagedCallable()
 *           <li><p> listMuteConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListNotificationConfigs</td>
 *      <td><p> Lists notification configs.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listNotificationConfigs(ListNotificationConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listNotificationConfigs(FolderLocationName parent)
 *           <li><p> listNotificationConfigs(LocationName parent)
 *           <li><p> listNotificationConfigs(OrganizationLocationName parent)
 *           <li><p> listNotificationConfigs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listNotificationConfigsPagedCallable()
 *           <li><p> listNotificationConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListResourceValueConfigs</td>
 *      <td><p> Lists all ResourceValueConfigs.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listResourceValueConfigs(ListResourceValueConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listResourceValueConfigs(OrganizationName parent)
 *           <li><p> listResourceValueConfigs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listResourceValueConfigsPagedCallable()
 *           <li><p> listResourceValueConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSources</td>
 *      <td><p> Lists all sources belonging to an organization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSources(ListSourcesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSources(FolderName parent)
 *           <li><p> listSources(OrganizationName parent)
 *           <li><p> listSources(ProjectName parent)
 *           <li><p> listSources(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSourcesPagedCallable()
 *           <li><p> listSourcesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListValuedResources</td>
 *      <td><p> Lists the valued resources for a set of simulation results and filter.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listValuedResources(ListValuedResourcesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listValuedResources(SimulationName parent)
 *           <li><p> listValuedResources(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listValuedResourcesPagedCallable()
 *           <li><p> listValuedResourcesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetFindingState</td>
 *      <td><p> Updates the state of a finding. If no location is specified, finding is assumed to be in global</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setFindingState(SetFindingStateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> setFindingState(FindingName name, Finding.State state)
 *           <li><p> setFindingState(String name, Finding.State state)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setFindingStateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy on the specified Source.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> setIamPolicy(ResourceName resource, Policy policy)
 *           <li><p> setIamPolicy(String resource, Policy policy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetMute</td>
 *      <td><p> Updates the mute state of a finding. If no location is specified, finding is assumed to be in global</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setMute(SetMuteRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> setMute(FindingName name, Finding.Mute mute)
 *           <li><p> setMute(String name, Finding.Mute mute)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setMuteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns the permissions that a caller has on the specified source.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> testIamPermissions(ResourceName resource, List&lt;String&gt; permissions)
 *           <li><p> testIamPermissions(String resource, List&lt;String&gt; permissions)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateBigQueryExport</td>
 *      <td><p> Updates a BigQuery export.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateBigQueryExport(UpdateBigQueryExportRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateBigQueryExport(BigQueryExport bigQueryExport, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateBigQueryExportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateExternalSystem</td>
 *      <td><p> Updates external system. This is for a given finding. If no location is specified, finding is assumed to be in global</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateExternalSystem(UpdateExternalSystemRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateExternalSystem(ExternalSystem externalSystem, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateExternalSystemCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateFinding</td>
 *      <td><p> Creates or updates a finding. If no location is specified, finding is assumed to be in global. The corresponding source must exist for a finding creation to succeed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateFinding(UpdateFindingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateFinding(Finding finding, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateFindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateMuteConfig</td>
 *      <td><p> Updates a mute config. If no location is specified, default is global.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateMuteConfig(UpdateMuteConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateMuteConfig(MuteConfig muteConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateMuteConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateNotificationConfig</td>
 *      <td><p> Updates a notification config. The following update fields are allowed: description, pubsub_topic, streaming_config.filter</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateNotificationConfig(UpdateNotificationConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateNotificationConfig(NotificationConfig notificationConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateNotificationConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateResourceValueConfig</td>
 *      <td><p> Updates an existing ResourceValueConfigs with new rules.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateResourceValueConfig(UpdateResourceValueConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateResourceValueConfig(ResourceValueConfig resourceValueConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateResourceValueConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSecurityMarks</td>
 *      <td><p> Updates security marks. For Finding Security marks, if no location is specified, finding is assumed to be in global. Assets Security Marks can only be accessed through global endpoint.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSecurityMarks(UpdateSecurityMarksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSecurityMarks(SecurityMarks securityMarks, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSecurityMarksCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSource</td>
 *      <td><p> Updates a source.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSource(UpdateSourceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSource(Source source, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSourceCallable()
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
 * <p>This class can be customized by passing in a custom instance of SecurityCenterSettings to
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
 * SecurityCenterSettings securityCenterSettings =
 *     SecurityCenterSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SecurityCenterClient securityCenterClient = SecurityCenterClient.create(securityCenterSettings);
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
 * SecurityCenterSettings securityCenterSettings =
 *     SecurityCenterSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SecurityCenterClient securityCenterClient = SecurityCenterClient.create(securityCenterSettings);
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
 * SecurityCenterSettings securityCenterSettings =
 *     SecurityCenterSettings.newHttpJsonBuilder().build();
 * SecurityCenterClient securityCenterClient = SecurityCenterClient.create(securityCenterSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class SecurityCenterClient implements BackgroundResource {
  private final SecurityCenterSettings settings;
  private final SecurityCenterStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of SecurityCenterClient with default settings. */
  public static final SecurityCenterClient create() throws IOException {
    return create(SecurityCenterSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SecurityCenterClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SecurityCenterClient create(SecurityCenterSettings settings)
      throws IOException {
    return new SecurityCenterClient(settings);
  }

  /**
   * Constructs an instance of SecurityCenterClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(SecurityCenterSettings).
   */
  public static final SecurityCenterClient create(SecurityCenterStub stub) {
    return new SecurityCenterClient(stub);
  }

  /**
   * Constructs an instance of SecurityCenterClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SecurityCenterClient(SecurityCenterSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SecurityCenterStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected SecurityCenterClient(SecurityCenterStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final SecurityCenterSettings getSettings() {
    return settings;
  }

  public SecurityCenterStub getStub() {
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
   * Creates a ResourceValueConfig for an organization. Maps user's tags to difference resource
   * values for use by the attack path simulation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   List<CreateResourceValueConfigRequest> requests = new ArrayList<>();
   *   BatchCreateResourceValueConfigsResponse response =
   *       securityCenterClient.batchCreateResourceValueConfigs(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new ResourceValueConfig's parent. The parent field
   *     in the CreateResourceValueConfigRequest messages must either be empty or match this field.
   * @param requests Required. The resource value configs to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateResourceValueConfigsResponse batchCreateResourceValueConfigs(
      OrganizationName parent, List<CreateResourceValueConfigRequest> requests) {
    BatchCreateResourceValueConfigsRequest request =
        BatchCreateResourceValueConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateResourceValueConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ResourceValueConfig for an organization. Maps user's tags to difference resource
   * values for use by the attack path simulation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   List<CreateResourceValueConfigRequest> requests = new ArrayList<>();
   *   BatchCreateResourceValueConfigsResponse response =
   *       securityCenterClient.batchCreateResourceValueConfigs(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new ResourceValueConfig's parent. The parent field
   *     in the CreateResourceValueConfigRequest messages must either be empty or match this field.
   * @param requests Required. The resource value configs to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateResourceValueConfigsResponse batchCreateResourceValueConfigs(
      String parent, List<CreateResourceValueConfigRequest> requests) {
    BatchCreateResourceValueConfigsRequest request =
        BatchCreateResourceValueConfigsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchCreateResourceValueConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ResourceValueConfig for an organization. Maps user's tags to difference resource
   * values for use by the attack path simulation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   BatchCreateResourceValueConfigsRequest request =
   *       BatchCreateResourceValueConfigsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .addAllRequests(new ArrayList<CreateResourceValueConfigRequest>())
   *           .build();
   *   BatchCreateResourceValueConfigsResponse response =
   *       securityCenterClient.batchCreateResourceValueConfigs(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateResourceValueConfigsResponse batchCreateResourceValueConfigs(
      BatchCreateResourceValueConfigsRequest request) {
    return batchCreateResourceValueConfigsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ResourceValueConfig for an organization. Maps user's tags to difference resource
   * values for use by the attack path simulation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   BatchCreateResourceValueConfigsRequest request =
   *       BatchCreateResourceValueConfigsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .addAllRequests(new ArrayList<CreateResourceValueConfigRequest>())
   *           .build();
   *   ApiFuture<BatchCreateResourceValueConfigsResponse> future =
   *       securityCenterClient.batchCreateResourceValueConfigsCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateResourceValueConfigsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchCreateResourceValueConfigsRequest, BatchCreateResourceValueConfigsResponse>
      batchCreateResourceValueConfigsCallable() {
    return stub.batchCreateResourceValueConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Kicks off an LRO to bulk mute findings for a parent based on a filter. If no location is
   * specified, findings are muted in global. The parent can be either an organization, folder, or
   * project. The findings matched by the filter will be muted after the LRO is done.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ResourceName parent = FolderName.of("[FOLDER]");
   *   BulkMuteFindingsResponse response = securityCenterClient.bulkMuteFindingsAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent, at which bulk action needs to be applied. If no location is
   *     specified, findings are updated in global. The following list shows some examples:
   *     <p>+ `organizations/[organization_id]` +
   *     `organizations/[organization_id]/locations/[location_id]` + `folders/[folder_id]` +
   *     `folders/[folder_id]/locations/[location_id]` + `projects/[project_id]` +
   *     `projects/[project_id]/locations/[location_id]`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BulkMuteFindingsResponse, Empty> bulkMuteFindingsAsync(
      ResourceName parent) {
    BulkMuteFindingsRequest request =
        BulkMuteFindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return bulkMuteFindingsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Kicks off an LRO to bulk mute findings for a parent based on a filter. If no location is
   * specified, findings are muted in global. The parent can be either an organization, folder, or
   * project. The findings matched by the filter will be muted after the LRO is done.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String parent = FolderName.of("[FOLDER]").toString();
   *   BulkMuteFindingsResponse response = securityCenterClient.bulkMuteFindingsAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent, at which bulk action needs to be applied. If no location is
   *     specified, findings are updated in global. The following list shows some examples:
   *     <p>+ `organizations/[organization_id]` +
   *     `organizations/[organization_id]/locations/[location_id]` + `folders/[folder_id]` +
   *     `folders/[folder_id]/locations/[location_id]` + `projects/[project_id]` +
   *     `projects/[project_id]/locations/[location_id]`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BulkMuteFindingsResponse, Empty> bulkMuteFindingsAsync(
      String parent) {
    BulkMuteFindingsRequest request =
        BulkMuteFindingsRequest.newBuilder().setParent(parent).build();
    return bulkMuteFindingsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Kicks off an LRO to bulk mute findings for a parent based on a filter. If no location is
   * specified, findings are muted in global. The parent can be either an organization, folder, or
   * project. The findings matched by the filter will be muted after the LRO is done.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   BulkMuteFindingsRequest request =
   *       BulkMuteFindingsRequest.newBuilder()
   *           .setParent(FolderName.of("[FOLDER]").toString())
   *           .setFilter("filter-1274492040")
   *           .build();
   *   BulkMuteFindingsResponse response = securityCenterClient.bulkMuteFindingsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BulkMuteFindingsResponse, Empty> bulkMuteFindingsAsync(
      BulkMuteFindingsRequest request) {
    return bulkMuteFindingsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Kicks off an LRO to bulk mute findings for a parent based on a filter. If no location is
   * specified, findings are muted in global. The parent can be either an organization, folder, or
   * project. The findings matched by the filter will be muted after the LRO is done.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   BulkMuteFindingsRequest request =
   *       BulkMuteFindingsRequest.newBuilder()
   *           .setParent(FolderName.of("[FOLDER]").toString())
   *           .setFilter("filter-1274492040")
   *           .build();
   *   OperationFuture<BulkMuteFindingsResponse, Empty> future =
   *       securityCenterClient.bulkMuteFindingsOperationCallable().futureCall(request);
   *   // Do something.
   *   BulkMuteFindingsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<BulkMuteFindingsRequest, BulkMuteFindingsResponse, Empty>
      bulkMuteFindingsOperationCallable() {
    return stub.bulkMuteFindingsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Kicks off an LRO to bulk mute findings for a parent based on a filter. If no location is
   * specified, findings are muted in global. The parent can be either an organization, folder, or
   * project. The findings matched by the filter will be muted after the LRO is done.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   BulkMuteFindingsRequest request =
   *       BulkMuteFindingsRequest.newBuilder()
   *           .setParent(FolderName.of("[FOLDER]").toString())
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Operation> future =
   *       securityCenterClient.bulkMuteFindingsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BulkMuteFindingsRequest, Operation> bulkMuteFindingsCallable() {
    return stub.bulkMuteFindingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a BigQuery export.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
   *   BigQueryExport bigQueryExport = BigQueryExport.newBuilder().build();
   *   String bigQueryExportId = "bigQueryExportId1024198583";
   *   BigQueryExport response =
   *       securityCenterClient.createBigQueryExport(parent, bigQueryExport, bigQueryExportId);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource of the new BigQuery export. Its format
   *     is "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]", or
   *     "projects/[project_id]/locations/[location_id]".
   * @param bigQueryExport Required. The BigQuery export being created.
   * @param bigQueryExportId Required. Unique identifier provided by the client within the parent
   *     scope. It must consist of only lowercase letters, numbers, and hyphens, must start with a
   *     letter, must end with either a letter or a number, and must be 63 characters or less.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BigQueryExport createBigQueryExport(
      FolderLocationName parent, BigQueryExport bigQueryExport, String bigQueryExportId) {
    CreateBigQueryExportRequest request =
        CreateBigQueryExportRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBigQueryExport(bigQueryExport)
            .setBigQueryExportId(bigQueryExportId)
            .build();
    return createBigQueryExport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a BigQuery export.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   BigQueryExport bigQueryExport = BigQueryExport.newBuilder().build();
   *   String bigQueryExportId = "bigQueryExportId1024198583";
   *   BigQueryExport response =
   *       securityCenterClient.createBigQueryExport(parent, bigQueryExport, bigQueryExportId);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource of the new BigQuery export. Its format
   *     is "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]", or
   *     "projects/[project_id]/locations/[location_id]".
   * @param bigQueryExport Required. The BigQuery export being created.
   * @param bigQueryExportId Required. Unique identifier provided by the client within the parent
   *     scope. It must consist of only lowercase letters, numbers, and hyphens, must start with a
   *     letter, must end with either a letter or a number, and must be 63 characters or less.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BigQueryExport createBigQueryExport(
      LocationName parent, BigQueryExport bigQueryExport, String bigQueryExportId) {
    CreateBigQueryExportRequest request =
        CreateBigQueryExportRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBigQueryExport(bigQueryExport)
            .setBigQueryExportId(bigQueryExportId)
            .build();
    return createBigQueryExport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a BigQuery export.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   BigQueryExport bigQueryExport = BigQueryExport.newBuilder().build();
   *   String bigQueryExportId = "bigQueryExportId1024198583";
   *   BigQueryExport response =
   *       securityCenterClient.createBigQueryExport(parent, bigQueryExport, bigQueryExportId);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource of the new BigQuery export. Its format
   *     is "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]", or
   *     "projects/[project_id]/locations/[location_id]".
   * @param bigQueryExport Required. The BigQuery export being created.
   * @param bigQueryExportId Required. Unique identifier provided by the client within the parent
   *     scope. It must consist of only lowercase letters, numbers, and hyphens, must start with a
   *     letter, must end with either a letter or a number, and must be 63 characters or less.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BigQueryExport createBigQueryExport(
      OrganizationLocationName parent, BigQueryExport bigQueryExport, String bigQueryExportId) {
    CreateBigQueryExportRequest request =
        CreateBigQueryExportRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBigQueryExport(bigQueryExport)
            .setBigQueryExportId(bigQueryExportId)
            .build();
    return createBigQueryExport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a BigQuery export.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   BigQueryExport bigQueryExport = BigQueryExport.newBuilder().build();
   *   String bigQueryExportId = "bigQueryExportId1024198583";
   *   BigQueryExport response =
   *       securityCenterClient.createBigQueryExport(parent, bigQueryExport, bigQueryExportId);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource of the new BigQuery export. Its format
   *     is "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]", or
   *     "projects/[project_id]/locations/[location_id]".
   * @param bigQueryExport Required. The BigQuery export being created.
   * @param bigQueryExportId Required. Unique identifier provided by the client within the parent
   *     scope. It must consist of only lowercase letters, numbers, and hyphens, must start with a
   *     letter, must end with either a letter or a number, and must be 63 characters or less.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BigQueryExport createBigQueryExport(
      String parent, BigQueryExport bigQueryExport, String bigQueryExportId) {
    CreateBigQueryExportRequest request =
        CreateBigQueryExportRequest.newBuilder()
            .setParent(parent)
            .setBigQueryExport(bigQueryExport)
            .setBigQueryExportId(bigQueryExportId)
            .build();
    return createBigQueryExport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a BigQuery export.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   CreateBigQueryExportRequest request =
   *       CreateBigQueryExportRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setBigQueryExport(BigQueryExport.newBuilder().build())
   *           .setBigQueryExportId("bigQueryExportId1024198583")
   *           .build();
   *   BigQueryExport response = securityCenterClient.createBigQueryExport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BigQueryExport createBigQueryExport(CreateBigQueryExportRequest request) {
    return createBigQueryExportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a BigQuery export.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   CreateBigQueryExportRequest request =
   *       CreateBigQueryExportRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setBigQueryExport(BigQueryExport.newBuilder().build())
   *           .setBigQueryExportId("bigQueryExportId1024198583")
   *           .build();
   *   ApiFuture<BigQueryExport> future =
   *       securityCenterClient.createBigQueryExportCallable().futureCall(request);
   *   // Do something.
   *   BigQueryExport response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBigQueryExportRequest, BigQueryExport>
      createBigQueryExportCallable() {
    return stub.createBigQueryExportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a finding in a location. The corresponding source must exist for finding creation to
   * succeed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   SourceName parent = SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]");
   *   Finding finding = Finding.newBuilder().build();
   *   String findingId = "findingId439150212";
   *   Finding response = securityCenterClient.createFinding(parent, finding, findingId);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new finding's parent. The following list shows
   *     some examples of the format: + `organizations/[organization_id]/sources/[source_id]` +
   *     `organizations/[organization_id]/sources/[source_id]/locations/[location_id]`
   * @param finding Required. The Finding being created. The name and security_marks will be ignored
   *     as they are both output only fields on this resource.
   * @param findingId Required. Unique identifier provided by the client within the parent scope. It
   *     must be alphanumeric and less than or equal to 32 characters and greater than 0 characters
   *     in length.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Finding createFinding(SourceName parent, Finding finding, String findingId) {
    CreateFindingRequest request =
        CreateFindingRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFinding(finding)
            .setFindingId(findingId)
            .build();
    return createFinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a finding in a location. The corresponding source must exist for finding creation to
   * succeed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String parent = SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString();
   *   Finding finding = Finding.newBuilder().build();
   *   String findingId = "findingId439150212";
   *   Finding response = securityCenterClient.createFinding(parent, finding, findingId);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new finding's parent. The following list shows
   *     some examples of the format: + `organizations/[organization_id]/sources/[source_id]` +
   *     `organizations/[organization_id]/sources/[source_id]/locations/[location_id]`
   * @param finding Required. The Finding being created. The name and security_marks will be ignored
   *     as they are both output only fields on this resource.
   * @param findingId Required. Unique identifier provided by the client within the parent scope. It
   *     must be alphanumeric and less than or equal to 32 characters and greater than 0 characters
   *     in length.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Finding createFinding(String parent, Finding finding, String findingId) {
    CreateFindingRequest request =
        CreateFindingRequest.newBuilder()
            .setParent(parent)
            .setFinding(finding)
            .setFindingId(findingId)
            .build();
    return createFinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a finding in a location. The corresponding source must exist for finding creation to
   * succeed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   CreateFindingRequest request =
   *       CreateFindingRequest.newBuilder()
   *           .setParent(
   *               SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString())
   *           .setFindingId("findingId439150212")
   *           .setFinding(Finding.newBuilder().build())
   *           .build();
   *   Finding response = securityCenterClient.createFinding(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Finding createFinding(CreateFindingRequest request) {
    return createFindingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a finding in a location. The corresponding source must exist for finding creation to
   * succeed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   CreateFindingRequest request =
   *       CreateFindingRequest.newBuilder()
   *           .setParent(
   *               SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString())
   *           .setFindingId("findingId439150212")
   *           .setFinding(Finding.newBuilder().build())
   *           .build();
   *   ApiFuture<Finding> future = securityCenterClient.createFindingCallable().futureCall(request);
   *   // Do something.
   *   Finding response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateFindingRequest, Finding> createFindingCallable() {
    return stub.createFindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a mute config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
   *   MuteConfig muteConfig = MuteConfig.newBuilder().build();
   *   String muteConfigId = "muteConfigId1689669942";
   *   MuteConfig response = securityCenterClient.createMuteConfig(parent, muteConfig, muteConfigId);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new mute configs's parent. Its format is
   *     "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]", or
   *     "projects/[project_id]/locations/[location_id]".
   * @param muteConfig Required. The mute config being created.
   * @param muteConfigId Required. Unique identifier provided by the client within the parent scope.
   *     It must consist of only lowercase letters, numbers, and hyphens, must start with a letter,
   *     must end with either a letter or a number, and must be 63 characters or less.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MuteConfig createMuteConfig(
      FolderLocationName parent, MuteConfig muteConfig, String muteConfigId) {
    CreateMuteConfigRequest request =
        CreateMuteConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMuteConfig(muteConfig)
            .setMuteConfigId(muteConfigId)
            .build();
    return createMuteConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a mute config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   FolderName parent = FolderName.of("[FOLDER]");
   *   MuteConfig muteConfig = MuteConfig.newBuilder().build();
   *   String muteConfigId = "muteConfigId1689669942";
   *   MuteConfig response = securityCenterClient.createMuteConfig(parent, muteConfig, muteConfigId);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new mute configs's parent. Its format is
   *     "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]", or
   *     "projects/[project_id]/locations/[location_id]".
   * @param muteConfig Required. The mute config being created.
   * @param muteConfigId Required. Unique identifier provided by the client within the parent scope.
   *     It must consist of only lowercase letters, numbers, and hyphens, must start with a letter,
   *     must end with either a letter or a number, and must be 63 characters or less.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MuteConfig createMuteConfig(
      FolderName parent, MuteConfig muteConfig, String muteConfigId) {
    CreateMuteConfigRequest request =
        CreateMuteConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMuteConfig(muteConfig)
            .setMuteConfigId(muteConfigId)
            .build();
    return createMuteConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a mute config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   MuteConfig muteConfig = MuteConfig.newBuilder().build();
   *   String muteConfigId = "muteConfigId1689669942";
   *   MuteConfig response = securityCenterClient.createMuteConfig(parent, muteConfig, muteConfigId);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new mute configs's parent. Its format is
   *     "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]", or
   *     "projects/[project_id]/locations/[location_id]".
   * @param muteConfig Required. The mute config being created.
   * @param muteConfigId Required. Unique identifier provided by the client within the parent scope.
   *     It must consist of only lowercase letters, numbers, and hyphens, must start with a letter,
   *     must end with either a letter or a number, and must be 63 characters or less.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MuteConfig createMuteConfig(
      LocationName parent, MuteConfig muteConfig, String muteConfigId) {
    CreateMuteConfigRequest request =
        CreateMuteConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMuteConfig(muteConfig)
            .setMuteConfigId(muteConfigId)
            .build();
    return createMuteConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a mute config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   MuteConfig muteConfig = MuteConfig.newBuilder().build();
   *   String muteConfigId = "muteConfigId1689669942";
   *   MuteConfig response = securityCenterClient.createMuteConfig(parent, muteConfig, muteConfigId);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new mute configs's parent. Its format is
   *     "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]", or
   *     "projects/[project_id]/locations/[location_id]".
   * @param muteConfig Required. The mute config being created.
   * @param muteConfigId Required. Unique identifier provided by the client within the parent scope.
   *     It must consist of only lowercase letters, numbers, and hyphens, must start with a letter,
   *     must end with either a letter or a number, and must be 63 characters or less.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MuteConfig createMuteConfig(
      OrganizationLocationName parent, MuteConfig muteConfig, String muteConfigId) {
    CreateMuteConfigRequest request =
        CreateMuteConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMuteConfig(muteConfig)
            .setMuteConfigId(muteConfigId)
            .build();
    return createMuteConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a mute config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   MuteConfig muteConfig = MuteConfig.newBuilder().build();
   *   String muteConfigId = "muteConfigId1689669942";
   *   MuteConfig response = securityCenterClient.createMuteConfig(parent, muteConfig, muteConfigId);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new mute configs's parent. Its format is
   *     "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]", or
   *     "projects/[project_id]/locations/[location_id]".
   * @param muteConfig Required. The mute config being created.
   * @param muteConfigId Required. Unique identifier provided by the client within the parent scope.
   *     It must consist of only lowercase letters, numbers, and hyphens, must start with a letter,
   *     must end with either a letter or a number, and must be 63 characters or less.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MuteConfig createMuteConfig(
      OrganizationName parent, MuteConfig muteConfig, String muteConfigId) {
    CreateMuteConfigRequest request =
        CreateMuteConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMuteConfig(muteConfig)
            .setMuteConfigId(muteConfigId)
            .build();
    return createMuteConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a mute config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   MuteConfig muteConfig = MuteConfig.newBuilder().build();
   *   String muteConfigId = "muteConfigId1689669942";
   *   MuteConfig response = securityCenterClient.createMuteConfig(parent, muteConfig, muteConfigId);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new mute configs's parent. Its format is
   *     "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]", or
   *     "projects/[project_id]/locations/[location_id]".
   * @param muteConfig Required. The mute config being created.
   * @param muteConfigId Required. Unique identifier provided by the client within the parent scope.
   *     It must consist of only lowercase letters, numbers, and hyphens, must start with a letter,
   *     must end with either a letter or a number, and must be 63 characters or less.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MuteConfig createMuteConfig(
      ProjectName parent, MuteConfig muteConfig, String muteConfigId) {
    CreateMuteConfigRequest request =
        CreateMuteConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMuteConfig(muteConfig)
            .setMuteConfigId(muteConfigId)
            .build();
    return createMuteConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a mute config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   MuteConfig muteConfig = MuteConfig.newBuilder().build();
   *   String muteConfigId = "muteConfigId1689669942";
   *   MuteConfig response = securityCenterClient.createMuteConfig(parent, muteConfig, muteConfigId);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new mute configs's parent. Its format is
   *     "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]", or
   *     "projects/[project_id]/locations/[location_id]".
   * @param muteConfig Required. The mute config being created.
   * @param muteConfigId Required. Unique identifier provided by the client within the parent scope.
   *     It must consist of only lowercase letters, numbers, and hyphens, must start with a letter,
   *     must end with either a letter or a number, and must be 63 characters or less.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MuteConfig createMuteConfig(
      String parent, MuteConfig muteConfig, String muteConfigId) {
    CreateMuteConfigRequest request =
        CreateMuteConfigRequest.newBuilder()
            .setParent(parent)
            .setMuteConfig(muteConfig)
            .setMuteConfigId(muteConfigId)
            .build();
    return createMuteConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a mute config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   CreateMuteConfigRequest request =
   *       CreateMuteConfigRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setMuteConfig(MuteConfig.newBuilder().build())
   *           .setMuteConfigId("muteConfigId1689669942")
   *           .build();
   *   MuteConfig response = securityCenterClient.createMuteConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MuteConfig createMuteConfig(CreateMuteConfigRequest request) {
    return createMuteConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a mute config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   CreateMuteConfigRequest request =
   *       CreateMuteConfigRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setMuteConfig(MuteConfig.newBuilder().build())
   *           .setMuteConfigId("muteConfigId1689669942")
   *           .build();
   *   ApiFuture<MuteConfig> future =
   *       securityCenterClient.createMuteConfigCallable().futureCall(request);
   *   // Do something.
   *   MuteConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMuteConfigRequest, MuteConfig> createMuteConfigCallable() {
    return stub.createMuteConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a notification config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
   *   NotificationConfig notificationConfig = NotificationConfig.newBuilder().build();
   *   String configId = "configId-580140035";
   *   NotificationConfig response =
   *       securityCenterClient.createNotificationConfig(parent, notificationConfig, configId);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new notification config's parent. Its format is
   *     "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]", or
   *     "projects/[project_id]/locations/[location_id]".
   * @param notificationConfig Required. The notification config being created. The name and the
   *     service account will be ignored as they are both output only fields on this resource.
   * @param configId Required. Unique identifier provided by the client within the parent scope. It
   *     must be between 1 and 128 characters and contain alphanumeric characters, underscores, or
   *     hyphens only.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationConfig createNotificationConfig(
      FolderLocationName parent, NotificationConfig notificationConfig, String configId) {
    CreateNotificationConfigRequest request =
        CreateNotificationConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setNotificationConfig(notificationConfig)
            .setConfigId(configId)
            .build();
    return createNotificationConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a notification config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   NotificationConfig notificationConfig = NotificationConfig.newBuilder().build();
   *   String configId = "configId-580140035";
   *   NotificationConfig response =
   *       securityCenterClient.createNotificationConfig(parent, notificationConfig, configId);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new notification config's parent. Its format is
   *     "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]", or
   *     "projects/[project_id]/locations/[location_id]".
   * @param notificationConfig Required. The notification config being created. The name and the
   *     service account will be ignored as they are both output only fields on this resource.
   * @param configId Required. Unique identifier provided by the client within the parent scope. It
   *     must be between 1 and 128 characters and contain alphanumeric characters, underscores, or
   *     hyphens only.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationConfig createNotificationConfig(
      LocationName parent, NotificationConfig notificationConfig, String configId) {
    CreateNotificationConfigRequest request =
        CreateNotificationConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setNotificationConfig(notificationConfig)
            .setConfigId(configId)
            .build();
    return createNotificationConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a notification config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   NotificationConfig notificationConfig = NotificationConfig.newBuilder().build();
   *   String configId = "configId-580140035";
   *   NotificationConfig response =
   *       securityCenterClient.createNotificationConfig(parent, notificationConfig, configId);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new notification config's parent. Its format is
   *     "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]", or
   *     "projects/[project_id]/locations/[location_id]".
   * @param notificationConfig Required. The notification config being created. The name and the
   *     service account will be ignored as they are both output only fields on this resource.
   * @param configId Required. Unique identifier provided by the client within the parent scope. It
   *     must be between 1 and 128 characters and contain alphanumeric characters, underscores, or
   *     hyphens only.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationConfig createNotificationConfig(
      OrganizationLocationName parent, NotificationConfig notificationConfig, String configId) {
    CreateNotificationConfigRequest request =
        CreateNotificationConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setNotificationConfig(notificationConfig)
            .setConfigId(configId)
            .build();
    return createNotificationConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a notification config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   NotificationConfig notificationConfig = NotificationConfig.newBuilder().build();
   *   String configId = "configId-580140035";
   *   NotificationConfig response =
   *       securityCenterClient.createNotificationConfig(parent, notificationConfig, configId);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new notification config's parent. Its format is
   *     "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]", or
   *     "projects/[project_id]/locations/[location_id]".
   * @param notificationConfig Required. The notification config being created. The name and the
   *     service account will be ignored as they are both output only fields on this resource.
   * @param configId Required. Unique identifier provided by the client within the parent scope. It
   *     must be between 1 and 128 characters and contain alphanumeric characters, underscores, or
   *     hyphens only.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationConfig createNotificationConfig(
      String parent, NotificationConfig notificationConfig, String configId) {
    CreateNotificationConfigRequest request =
        CreateNotificationConfigRequest.newBuilder()
            .setParent(parent)
            .setNotificationConfig(notificationConfig)
            .setConfigId(configId)
            .build();
    return createNotificationConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a notification config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   CreateNotificationConfigRequest request =
   *       CreateNotificationConfigRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setConfigId("configId-580140035")
   *           .setNotificationConfig(NotificationConfig.newBuilder().build())
   *           .build();
   *   NotificationConfig response = securityCenterClient.createNotificationConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationConfig createNotificationConfig(
      CreateNotificationConfigRequest request) {
    return createNotificationConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a notification config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   CreateNotificationConfigRequest request =
   *       CreateNotificationConfigRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setConfigId("configId-580140035")
   *           .setNotificationConfig(NotificationConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<NotificationConfig> future =
   *       securityCenterClient.createNotificationConfigCallable().futureCall(request);
   *   // Do something.
   *   NotificationConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateNotificationConfigRequest, NotificationConfig>
      createNotificationConfigCallable() {
    return stub.createNotificationConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   Source source = Source.newBuilder().build();
   *   Source response = securityCenterClient.createSource(parent, source);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new source's parent. Its format should be
   *     "organizations/[organization_id]".
   * @param source Required. The Source being created, only the display_name and description will be
   *     used. All other fields will be ignored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Source createSource(OrganizationName parent, Source source) {
    CreateSourceRequest request =
        CreateSourceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSource(source)
            .build();
    return createSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   Source source = Source.newBuilder().build();
   *   Source response = securityCenterClient.createSource(parent, source);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new source's parent. Its format should be
   *     "organizations/[organization_id]".
   * @param source Required. The Source being created, only the display_name and description will be
   *     used. All other fields will be ignored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Source createSource(String parent, Source source) {
    CreateSourceRequest request =
        CreateSourceRequest.newBuilder().setParent(parent).setSource(source).build();
    return createSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   CreateSourceRequest request =
   *       CreateSourceRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setSource(Source.newBuilder().build())
   *           .build();
   *   Source response = securityCenterClient.createSource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Source createSource(CreateSourceRequest request) {
    return createSourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   CreateSourceRequest request =
   *       CreateSourceRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setSource(Source.newBuilder().build())
   *           .build();
   *   ApiFuture<Source> future = securityCenterClient.createSourceCallable().futureCall(request);
   *   // Do something.
   *   Source response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSourceRequest, Source> createSourceCallable() {
    return stub.createSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing BigQuery export.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   BigQueryExportName name =
   *       BigQueryExportName.ofOrganizationLocationExportName(
   *           "[ORGANIZATION]", "[LOCATION]", "[EXPORT]");
   *   securityCenterClient.deleteBigQueryExport(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the BigQuery export to delete. The following list shows some
   *     examples of the format:
   *     <p>+ `organizations/{organization}/locations/{location}/bigQueryExports/{export_id}` +
   *     `folders/{folder}/locations/{location}/bigQueryExports/{export_id}` +
   *     `projects/{project}/locations/{location}/bigQueryExports/{export_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBigQueryExport(BigQueryExportName name) {
    DeleteBigQueryExportRequest request =
        DeleteBigQueryExportRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteBigQueryExport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing BigQuery export.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String name =
   *       BigQueryExportName.ofOrganizationLocationExportName(
   *               "[ORGANIZATION]", "[LOCATION]", "[EXPORT]")
   *           .toString();
   *   securityCenterClient.deleteBigQueryExport(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the BigQuery export to delete. The following list shows some
   *     examples of the format:
   *     <p>+ `organizations/{organization}/locations/{location}/bigQueryExports/{export_id}` +
   *     `folders/{folder}/locations/{location}/bigQueryExports/{export_id}` +
   *     `projects/{project}/locations/{location}/bigQueryExports/{export_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBigQueryExport(String name) {
    DeleteBigQueryExportRequest request =
        DeleteBigQueryExportRequest.newBuilder().setName(name).build();
    deleteBigQueryExport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing BigQuery export.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   DeleteBigQueryExportRequest request =
   *       DeleteBigQueryExportRequest.newBuilder()
   *           .setName(
   *               BigQueryExportName.ofOrganizationLocationExportName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[EXPORT]")
   *                   .toString())
   *           .build();
   *   securityCenterClient.deleteBigQueryExport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBigQueryExport(DeleteBigQueryExportRequest request) {
    deleteBigQueryExportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing BigQuery export.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   DeleteBigQueryExportRequest request =
   *       DeleteBigQueryExportRequest.newBuilder()
   *           .setName(
   *               BigQueryExportName.ofOrganizationLocationExportName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[EXPORT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       securityCenterClient.deleteBigQueryExportCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBigQueryExportRequest, Empty> deleteBigQueryExportCallable() {
    return stub.deleteBigQueryExportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing mute config. If no location is specified, default is global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   MuteConfigName name =
   *       MuteConfigName.ofOrganizationMuteConfigName("[ORGANIZATION]", "[MUTE_CONFIG]");
   *   securityCenterClient.deleteMuteConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the mute config to delete. The following list shows some examples
   *     of the format:
   *     <p>+ `organizations/{organization}/muteConfigs/{config_id}` +
   *     `organizations/{organization}/locations/{location}/muteConfigs/{config_id}` +
   *     `folders/{folder}/muteConfigs/{config_id}` +
   *     `folders/{folder}/locations/{location}/muteConfigs/{config_id}` +
   *     `projects/{project}/muteConfigs/{config_id}` +
   *     `projects/{project}/locations/{location}/muteConfigs/{config_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMuteConfig(MuteConfigName name) {
    DeleteMuteConfigRequest request =
        DeleteMuteConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteMuteConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing mute config. If no location is specified, default is global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String name =
   *       MuteConfigName.ofOrganizationMuteConfigName("[ORGANIZATION]", "[MUTE_CONFIG]").toString();
   *   securityCenterClient.deleteMuteConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the mute config to delete. The following list shows some examples
   *     of the format:
   *     <p>+ `organizations/{organization}/muteConfigs/{config_id}` +
   *     `organizations/{organization}/locations/{location}/muteConfigs/{config_id}` +
   *     `folders/{folder}/muteConfigs/{config_id}` +
   *     `folders/{folder}/locations/{location}/muteConfigs/{config_id}` +
   *     `projects/{project}/muteConfigs/{config_id}` +
   *     `projects/{project}/locations/{location}/muteConfigs/{config_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMuteConfig(String name) {
    DeleteMuteConfigRequest request = DeleteMuteConfigRequest.newBuilder().setName(name).build();
    deleteMuteConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing mute config. If no location is specified, default is global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   DeleteMuteConfigRequest request =
   *       DeleteMuteConfigRequest.newBuilder()
   *           .setName(
   *               MuteConfigName.ofOrganizationMuteConfigName("[ORGANIZATION]", "[MUTE_CONFIG]")
   *                   .toString())
   *           .build();
   *   securityCenterClient.deleteMuteConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMuteConfig(DeleteMuteConfigRequest request) {
    deleteMuteConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing mute config. If no location is specified, default is global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   DeleteMuteConfigRequest request =
   *       DeleteMuteConfigRequest.newBuilder()
   *           .setName(
   *               MuteConfigName.ofOrganizationMuteConfigName("[ORGANIZATION]", "[MUTE_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = securityCenterClient.deleteMuteConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMuteConfigRequest, Empty> deleteMuteConfigCallable() {
    return stub.deleteMuteConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a notification config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   NotificationConfigName name =
   *       NotificationConfigName.ofOrganizationLocationNotificationConfigName(
   *           "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION_CONFIG]");
   *   securityCenterClient.deleteNotificationConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the notification config to delete. The following list shows some
   *     examples of the format:
   *     <p>+
   *     `organizations/[organization_id]/locations/[location_id]/notificationConfigs/[config_id]` +
   *     `folders/[folder_id]/locations/[location_id]notificationConfigs/[config_id]` +
   *     `projects/[project_id]/locations/[location_id]notificationConfigs/[config_id]`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteNotificationConfig(NotificationConfigName name) {
    DeleteNotificationConfigRequest request =
        DeleteNotificationConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteNotificationConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a notification config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String name =
   *       NotificationConfigName.ofOrganizationLocationNotificationConfigName(
   *               "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION_CONFIG]")
   *           .toString();
   *   securityCenterClient.deleteNotificationConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the notification config to delete. The following list shows some
   *     examples of the format:
   *     <p>+
   *     `organizations/[organization_id]/locations/[location_id]/notificationConfigs/[config_id]` +
   *     `folders/[folder_id]/locations/[location_id]notificationConfigs/[config_id]` +
   *     `projects/[project_id]/locations/[location_id]notificationConfigs/[config_id]`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteNotificationConfig(String name) {
    DeleteNotificationConfigRequest request =
        DeleteNotificationConfigRequest.newBuilder().setName(name).build();
    deleteNotificationConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a notification config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   DeleteNotificationConfigRequest request =
   *       DeleteNotificationConfigRequest.newBuilder()
   *           .setName(
   *               NotificationConfigName.ofOrganizationLocationNotificationConfigName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION_CONFIG]")
   *                   .toString())
   *           .build();
   *   securityCenterClient.deleteNotificationConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteNotificationConfig(DeleteNotificationConfigRequest request) {
    deleteNotificationConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a notification config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   DeleteNotificationConfigRequest request =
   *       DeleteNotificationConfigRequest.newBuilder()
   *           .setName(
   *               NotificationConfigName.ofOrganizationLocationNotificationConfigName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       securityCenterClient.deleteNotificationConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteNotificationConfigRequest, Empty>
      deleteNotificationConfigCallable() {
    return stub.deleteNotificationConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ResourceValueConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ResourceValueConfigName name =
   *       ResourceValueConfigName.of("[ORGANIZATION]", "[RESOURCE_VALUE_CONFIG]");
   *   securityCenterClient.deleteResourceValueConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the ResourceValueConfig to delete
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteResourceValueConfig(ResourceValueConfigName name) {
    DeleteResourceValueConfigRequest request =
        DeleteResourceValueConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteResourceValueConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ResourceValueConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String name =
   *       ResourceValueConfigName.of("[ORGANIZATION]", "[RESOURCE_VALUE_CONFIG]").toString();
   *   securityCenterClient.deleteResourceValueConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the ResourceValueConfig to delete
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteResourceValueConfig(String name) {
    DeleteResourceValueConfigRequest request =
        DeleteResourceValueConfigRequest.newBuilder().setName(name).build();
    deleteResourceValueConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ResourceValueConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   DeleteResourceValueConfigRequest request =
   *       DeleteResourceValueConfigRequest.newBuilder()
   *           .setName(
   *               ResourceValueConfigName.of("[ORGANIZATION]", "[RESOURCE_VALUE_CONFIG]")
   *                   .toString())
   *           .build();
   *   securityCenterClient.deleteResourceValueConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteResourceValueConfig(DeleteResourceValueConfigRequest request) {
    deleteResourceValueConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ResourceValueConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   DeleteResourceValueConfigRequest request =
   *       DeleteResourceValueConfigRequest.newBuilder()
   *           .setName(
   *               ResourceValueConfigName.of("[ORGANIZATION]", "[RESOURCE_VALUE_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       securityCenterClient.deleteResourceValueConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteResourceValueConfigRequest, Empty>
      deleteResourceValueConfigCallable() {
    return stub.deleteResourceValueConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a BigQuery export.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   BigQueryExportName name =
   *       BigQueryExportName.ofOrganizationLocationExportName(
   *           "[ORGANIZATION]", "[LOCATION]", "[EXPORT]");
   *   BigQueryExport response = securityCenterClient.getBigQueryExport(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the BigQuery export to retrieve. The following list shows some
   *     examples of the format:
   *     <p>+ `organizations/{organization}/locations/{location}/bigQueryExports/{export_id}` +
   *     `folders/{folder}/locations/{location}/bigQueryExports/{export_id}` +
   *     `projects/{project}locations/{location}//bigQueryExports/{export_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BigQueryExport getBigQueryExport(BigQueryExportName name) {
    GetBigQueryExportRequest request =
        GetBigQueryExportRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getBigQueryExport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a BigQuery export.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String name =
   *       BigQueryExportName.ofOrganizationLocationExportName(
   *               "[ORGANIZATION]", "[LOCATION]", "[EXPORT]")
   *           .toString();
   *   BigQueryExport response = securityCenterClient.getBigQueryExport(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the BigQuery export to retrieve. The following list shows some
   *     examples of the format:
   *     <p>+ `organizations/{organization}/locations/{location}/bigQueryExports/{export_id}` +
   *     `folders/{folder}/locations/{location}/bigQueryExports/{export_id}` +
   *     `projects/{project}locations/{location}//bigQueryExports/{export_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BigQueryExport getBigQueryExport(String name) {
    GetBigQueryExportRequest request = GetBigQueryExportRequest.newBuilder().setName(name).build();
    return getBigQueryExport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a BigQuery export.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   GetBigQueryExportRequest request =
   *       GetBigQueryExportRequest.newBuilder()
   *           .setName(
   *               BigQueryExportName.ofOrganizationLocationExportName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[EXPORT]")
   *                   .toString())
   *           .build();
   *   BigQueryExport response = securityCenterClient.getBigQueryExport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BigQueryExport getBigQueryExport(GetBigQueryExportRequest request) {
    return getBigQueryExportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a BigQuery export.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   GetBigQueryExportRequest request =
   *       GetBigQueryExportRequest.newBuilder()
   *           .setName(
   *               BigQueryExportName.ofOrganizationLocationExportName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[EXPORT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<BigQueryExport> future =
   *       securityCenterClient.getBigQueryExportCallable().futureCall(request);
   *   // Do something.
   *   BigQueryExport response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBigQueryExportRequest, BigQueryExport> getBigQueryExportCallable() {
    return stub.getBigQueryExportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the simulation by name or the latest simulation for the given organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   SimulationName name = SimulationName.of("[ORGANIZATION]", "[SIMULATION]");
   *   Simulation response = securityCenterClient.getSimulation(name);
   * }
   * }</pre>
   *
   * @param name Required. The organization name or simulation name of this simulation
   *     <p>Valid format: "organizations/{organization}/simulations/latest"
   *     "organizations/{organization}/simulations/{simulation}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Simulation getSimulation(SimulationName name) {
    GetSimulationRequest request =
        GetSimulationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSimulation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the simulation by name or the latest simulation for the given organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String name = SimulationName.of("[ORGANIZATION]", "[SIMULATION]").toString();
   *   Simulation response = securityCenterClient.getSimulation(name);
   * }
   * }</pre>
   *
   * @param name Required. The organization name or simulation name of this simulation
   *     <p>Valid format: "organizations/{organization}/simulations/latest"
   *     "organizations/{organization}/simulations/{simulation}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Simulation getSimulation(String name) {
    GetSimulationRequest request = GetSimulationRequest.newBuilder().setName(name).build();
    return getSimulation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the simulation by name or the latest simulation for the given organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   GetSimulationRequest request =
   *       GetSimulationRequest.newBuilder()
   *           .setName(SimulationName.of("[ORGANIZATION]", "[SIMULATION]").toString())
   *           .build();
   *   Simulation response = securityCenterClient.getSimulation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Simulation getSimulation(GetSimulationRequest request) {
    return getSimulationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the simulation by name or the latest simulation for the given organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   GetSimulationRequest request =
   *       GetSimulationRequest.newBuilder()
   *           .setName(SimulationName.of("[ORGANIZATION]", "[SIMULATION]").toString())
   *           .build();
   *   ApiFuture<Simulation> future =
   *       securityCenterClient.getSimulationCallable().futureCall(request);
   *   // Do something.
   *   Simulation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSimulationRequest, Simulation> getSimulationCallable() {
    return stub.getSimulationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the valued resource by name
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ValuedResourceName name =
   *       ValuedResourceName.of("[ORGANIZATION]", "[SIMULATION]", "[VALUED_RESOURCE]");
   *   ValuedResource response = securityCenterClient.getValuedResource(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of this valued resource
   *     <p>Valid format:
   *     "organizations/{organization}/simulations/{simulation}/valuedResources/{valued_resource}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ValuedResource getValuedResource(ValuedResourceName name) {
    GetValuedResourceRequest request =
        GetValuedResourceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getValuedResource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the valued resource by name
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String name =
   *       ValuedResourceName.of("[ORGANIZATION]", "[SIMULATION]", "[VALUED_RESOURCE]").toString();
   *   ValuedResource response = securityCenterClient.getValuedResource(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of this valued resource
   *     <p>Valid format:
   *     "organizations/{organization}/simulations/{simulation}/valuedResources/{valued_resource}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ValuedResource getValuedResource(String name) {
    GetValuedResourceRequest request = GetValuedResourceRequest.newBuilder().setName(name).build();
    return getValuedResource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the valued resource by name
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   GetValuedResourceRequest request =
   *       GetValuedResourceRequest.newBuilder()
   *           .setName(
   *               ValuedResourceName.of("[ORGANIZATION]", "[SIMULATION]", "[VALUED_RESOURCE]")
   *                   .toString())
   *           .build();
   *   ValuedResource response = securityCenterClient.getValuedResource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ValuedResource getValuedResource(GetValuedResourceRequest request) {
    return getValuedResourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the valued resource by name
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   GetValuedResourceRequest request =
   *       GetValuedResourceRequest.newBuilder()
   *           .setName(
   *               ValuedResourceName.of("[ORGANIZATION]", "[SIMULATION]", "[VALUED_RESOURCE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ValuedResource> future =
   *       securityCenterClient.getValuedResourceCallable().futureCall(request);
   *   // Do something.
   *   ValuedResource response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetValuedResourceRequest, ValuedResource> getValuedResourceCallable() {
    return stub.getValuedResourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy on the specified Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ResourceName resource = SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]");
   *   Policy response = securityCenterClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(ResourceName resource) {
    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy on the specified Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String resource = FolderName.of("[FOLDER]").toString();
   *   Policy response = securityCenterClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy on the specified Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(FolderName.of("[FOLDER]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = securityCenterClient.getIamPolicy(request);
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
   * Gets the access control policy on the specified Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(FolderName.of("[FOLDER]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = securityCenterClient.getIamPolicyCallable().futureCall(request);
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
   * Gets a mute config. If no location is specified, default is global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   MuteConfigName name =
   *       MuteConfigName.ofOrganizationMuteConfigName("[ORGANIZATION]", "[MUTE_CONFIG]");
   *   MuteConfig response = securityCenterClient.getMuteConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the mute config to retrieve. The following list shows some
   *     examples of the format:
   *     <p>+ `organizations/{organization}/muteConfigs/{config_id}` +
   *     `organizations/{organization}/locations/{location}/muteConfigs/{config_id}` +
   *     `folders/{folder}/muteConfigs/{config_id}` +
   *     `folders/{folder}/locations/{location}/muteConfigs/{config_id}` +
   *     `projects/{project}/muteConfigs/{config_id}` +
   *     `projects/{project}/locations/{location}/muteConfigs/{config_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MuteConfig getMuteConfig(MuteConfigName name) {
    GetMuteConfigRequest request =
        GetMuteConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getMuteConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a mute config. If no location is specified, default is global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String name =
   *       MuteConfigName.ofOrganizationMuteConfigName("[ORGANIZATION]", "[MUTE_CONFIG]").toString();
   *   MuteConfig response = securityCenterClient.getMuteConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the mute config to retrieve. The following list shows some
   *     examples of the format:
   *     <p>+ `organizations/{organization}/muteConfigs/{config_id}` +
   *     `organizations/{organization}/locations/{location}/muteConfigs/{config_id}` +
   *     `folders/{folder}/muteConfigs/{config_id}` +
   *     `folders/{folder}/locations/{location}/muteConfigs/{config_id}` +
   *     `projects/{project}/muteConfigs/{config_id}` +
   *     `projects/{project}/locations/{location}/muteConfigs/{config_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MuteConfig getMuteConfig(String name) {
    GetMuteConfigRequest request = GetMuteConfigRequest.newBuilder().setName(name).build();
    return getMuteConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a mute config. If no location is specified, default is global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   GetMuteConfigRequest request =
   *       GetMuteConfigRequest.newBuilder()
   *           .setName(
   *               MuteConfigName.ofOrganizationMuteConfigName("[ORGANIZATION]", "[MUTE_CONFIG]")
   *                   .toString())
   *           .build();
   *   MuteConfig response = securityCenterClient.getMuteConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MuteConfig getMuteConfig(GetMuteConfigRequest request) {
    return getMuteConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a mute config. If no location is specified, default is global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   GetMuteConfigRequest request =
   *       GetMuteConfigRequest.newBuilder()
   *           .setName(
   *               MuteConfigName.ofOrganizationMuteConfigName("[ORGANIZATION]", "[MUTE_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<MuteConfig> future =
   *       securityCenterClient.getMuteConfigCallable().futureCall(request);
   *   // Do something.
   *   MuteConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMuteConfigRequest, MuteConfig> getMuteConfigCallable() {
    return stub.getMuteConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a notification config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   NotificationConfigName name =
   *       NotificationConfigName.ofOrganizationLocationNotificationConfigName(
   *           "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION_CONFIG]");
   *   NotificationConfig response = securityCenterClient.getNotificationConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the notification config to get. The following list shows some
   *     examples of the format:
   *     <p>+
   *     `organizations/[organization_id]/locations/[location_id]/notificationConfigs/[config_id]` +
   *     `folders/[folder_id]/locations/[location_id]/notificationConfigs/[config_id]` +
   *     `projects/[project_id]/locations/[location_id]/notificationConfigs/[config_id]`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationConfig getNotificationConfig(NotificationConfigName name) {
    GetNotificationConfigRequest request =
        GetNotificationConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getNotificationConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a notification config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String name =
   *       NotificationConfigName.ofOrganizationLocationNotificationConfigName(
   *               "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION_CONFIG]")
   *           .toString();
   *   NotificationConfig response = securityCenterClient.getNotificationConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the notification config to get. The following list shows some
   *     examples of the format:
   *     <p>+
   *     `organizations/[organization_id]/locations/[location_id]/notificationConfigs/[config_id]` +
   *     `folders/[folder_id]/locations/[location_id]/notificationConfigs/[config_id]` +
   *     `projects/[project_id]/locations/[location_id]/notificationConfigs/[config_id]`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationConfig getNotificationConfig(String name) {
    GetNotificationConfigRequest request =
        GetNotificationConfigRequest.newBuilder().setName(name).build();
    return getNotificationConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a notification config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   GetNotificationConfigRequest request =
   *       GetNotificationConfigRequest.newBuilder()
   *           .setName(
   *               NotificationConfigName.ofOrganizationLocationNotificationConfigName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION_CONFIG]")
   *                   .toString())
   *           .build();
   *   NotificationConfig response = securityCenterClient.getNotificationConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationConfig getNotificationConfig(GetNotificationConfigRequest request) {
    return getNotificationConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a notification config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   GetNotificationConfigRequest request =
   *       GetNotificationConfigRequest.newBuilder()
   *           .setName(
   *               NotificationConfigName.ofOrganizationLocationNotificationConfigName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<NotificationConfig> future =
   *       securityCenterClient.getNotificationConfigCallable().futureCall(request);
   *   // Do something.
   *   NotificationConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNotificationConfigRequest, NotificationConfig>
      getNotificationConfigCallable() {
    return stub.getNotificationConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ResourceValueConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ResourceValueConfigName name =
   *       ResourceValueConfigName.of("[ORGANIZATION]", "[RESOURCE_VALUE_CONFIG]");
   *   ResourceValueConfig response = securityCenterClient.getResourceValueConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource value config to retrieve. Its format is
   *     organizations/{organization}/resourceValueConfigs/{config_id}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResourceValueConfig getResourceValueConfig(ResourceValueConfigName name) {
    GetResourceValueConfigRequest request =
        GetResourceValueConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getResourceValueConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ResourceValueConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String name =
   *       ResourceValueConfigName.of("[ORGANIZATION]", "[RESOURCE_VALUE_CONFIG]").toString();
   *   ResourceValueConfig response = securityCenterClient.getResourceValueConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource value config to retrieve. Its format is
   *     organizations/{organization}/resourceValueConfigs/{config_id}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResourceValueConfig getResourceValueConfig(String name) {
    GetResourceValueConfigRequest request =
        GetResourceValueConfigRequest.newBuilder().setName(name).build();
    return getResourceValueConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ResourceValueConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   GetResourceValueConfigRequest request =
   *       GetResourceValueConfigRequest.newBuilder()
   *           .setName(
   *               ResourceValueConfigName.of("[ORGANIZATION]", "[RESOURCE_VALUE_CONFIG]")
   *                   .toString())
   *           .build();
   *   ResourceValueConfig response = securityCenterClient.getResourceValueConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResourceValueConfig getResourceValueConfig(GetResourceValueConfigRequest request) {
    return getResourceValueConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ResourceValueConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   GetResourceValueConfigRequest request =
   *       GetResourceValueConfigRequest.newBuilder()
   *           .setName(
   *               ResourceValueConfigName.of("[ORGANIZATION]", "[RESOURCE_VALUE_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ResourceValueConfig> future =
   *       securityCenterClient.getResourceValueConfigCallable().futureCall(request);
   *   // Do something.
   *   ResourceValueConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetResourceValueConfigRequest, ResourceValueConfig>
      getResourceValueConfigCallable() {
    return stub.getResourceValueConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   SourceName name = SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]");
   *   Source response = securityCenterClient.getSource(name);
   * }
   * }</pre>
   *
   * @param name Required. Relative resource name of the source. Its format is
   *     "organizations/[organization_id]/source/[source_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Source getSource(SourceName name) {
    GetSourceRequest request =
        GetSourceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String name = SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString();
   *   Source response = securityCenterClient.getSource(name);
   * }
   * }</pre>
   *
   * @param name Required. Relative resource name of the source. Its format is
   *     "organizations/[organization_id]/source/[source_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Source getSource(String name) {
    GetSourceRequest request = GetSourceRequest.newBuilder().setName(name).build();
    return getSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   GetSourceRequest request =
   *       GetSourceRequest.newBuilder()
   *           .setName(SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString())
   *           .build();
   *   Source response = securityCenterClient.getSource(request);
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
   * Gets a source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   GetSourceRequest request =
   *       GetSourceRequest.newBuilder()
   *           .setName(SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString())
   *           .build();
   *   ApiFuture<Source> future = securityCenterClient.getSourceCallable().futureCall(request);
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
   * Filters an organization or source's findings and groups them by their specified properties in a
   * location. If no location is specified, findings are assumed to be in global
   *
   * <p>To group across all sources provide a `-` as the source id. The following list shows some
   * examples:
   *
   * <p>+ `/v2/organizations/{organization_id}/sources/-/findings` +
   * `/v2/organizations/{organization_id}/sources/-/locations/{location_id}/findings` +
   * `/v2/folders/{folder_id}/sources/-/findings` +
   * `/v2/folders/{folder_id}/sources/-/locations/{location_id}/findings` +
   * `/v2/projects/{project_id}/sources/-/findings` +
   * `/v2/projects/{project_id}/sources/-/locations/{location_id}/findings`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   SourceName parent = SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]");
   *   String groupBy = "groupBy293428022";
   *   for (GroupResult element : securityCenterClient.groupFindings(parent, groupBy).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of the source to groupBy. If no location is specified, finding is
   *     assumed to be in global. The following list shows some examples:
   *     <p>+ `organizations/[organization_id]/sources/[source_id]` +
   *     `organizations/[organization_id]/sources/[source_id]/locations/[location_id]` +
   *     `folders/[folder_id]/sources/[source_id]` +
   *     `folders/[folder_id]/sources/[source_id]/locations/[location_id]` +
   *     `projects/[project_id]/sources/[source_id]` +
   *     `projects/[project_id]/sources/[source_id]/locations/[location_id]`
   *     <p>To groupBy across all sources provide a source_id of `-`. The following list shows some
   *     examples:
   *     <p>+ `organizations/{organization_id}/sources/-` +
   *     `organizations/{organization_id}/sources/-/locations/[location_id]` +
   *     `folders/{folder_id}/sources/-` + `folders/{folder_id}/sources/-/locations/[location_id]` +
   *     `projects/{project_id}/sources/-` +
   *     `projects/{project_id}/sources/-/locations/[location_id]`
   * @param groupBy Required. Expression that defines what assets fields to use for grouping. The
   *     string value should follow SQL syntax: comma separated list of fields. For example:
   *     "parent,resource_name".
   *     <p>The following fields are supported:
   *     <ul>
   *       <li>resource_name
   *       <li>category
   *       <li>state
   *       <li>parent
   *       <li>severity
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GroupFindingsPagedResponse groupFindings(SourceName parent, String groupBy) {
    GroupFindingsRequest request =
        GroupFindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGroupBy(groupBy)
            .build();
    return groupFindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Filters an organization or source's findings and groups them by their specified properties in a
   * location. If no location is specified, findings are assumed to be in global
   *
   * <p>To group across all sources provide a `-` as the source id. The following list shows some
   * examples:
   *
   * <p>+ `/v2/organizations/{organization_id}/sources/-/findings` +
   * `/v2/organizations/{organization_id}/sources/-/locations/{location_id}/findings` +
   * `/v2/folders/{folder_id}/sources/-/findings` +
   * `/v2/folders/{folder_id}/sources/-/locations/{location_id}/findings` +
   * `/v2/projects/{project_id}/sources/-/findings` +
   * `/v2/projects/{project_id}/sources/-/locations/{location_id}/findings`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String parent = SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString();
   *   String groupBy = "groupBy293428022";
   *   for (GroupResult element : securityCenterClient.groupFindings(parent, groupBy).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of the source to groupBy. If no location is specified, finding is
   *     assumed to be in global. The following list shows some examples:
   *     <p>+ `organizations/[organization_id]/sources/[source_id]` +
   *     `organizations/[organization_id]/sources/[source_id]/locations/[location_id]` +
   *     `folders/[folder_id]/sources/[source_id]` +
   *     `folders/[folder_id]/sources/[source_id]/locations/[location_id]` +
   *     `projects/[project_id]/sources/[source_id]` +
   *     `projects/[project_id]/sources/[source_id]/locations/[location_id]`
   *     <p>To groupBy across all sources provide a source_id of `-`. The following list shows some
   *     examples:
   *     <p>+ `organizations/{organization_id}/sources/-` +
   *     `organizations/{organization_id}/sources/-/locations/[location_id]` +
   *     `folders/{folder_id}/sources/-` + `folders/{folder_id}/sources/-/locations/[location_id]` +
   *     `projects/{project_id}/sources/-` +
   *     `projects/{project_id}/sources/-/locations/[location_id]`
   * @param groupBy Required. Expression that defines what assets fields to use for grouping. The
   *     string value should follow SQL syntax: comma separated list of fields. For example:
   *     "parent,resource_name".
   *     <p>The following fields are supported:
   *     <ul>
   *       <li>resource_name
   *       <li>category
   *       <li>state
   *       <li>parent
   *       <li>severity
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GroupFindingsPagedResponse groupFindings(String parent, String groupBy) {
    GroupFindingsRequest request =
        GroupFindingsRequest.newBuilder().setParent(parent).setGroupBy(groupBy).build();
    return groupFindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Filters an organization or source's findings and groups them by their specified properties in a
   * location. If no location is specified, findings are assumed to be in global
   *
   * <p>To group across all sources provide a `-` as the source id. The following list shows some
   * examples:
   *
   * <p>+ `/v2/organizations/{organization_id}/sources/-/findings` +
   * `/v2/organizations/{organization_id}/sources/-/locations/{location_id}/findings` +
   * `/v2/folders/{folder_id}/sources/-/findings` +
   * `/v2/folders/{folder_id}/sources/-/locations/{location_id}/findings` +
   * `/v2/projects/{project_id}/sources/-/findings` +
   * `/v2/projects/{project_id}/sources/-/locations/{location_id}/findings`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   GroupFindingsRequest request =
   *       GroupFindingsRequest.newBuilder()
   *           .setParent(
   *               SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setGroupBy("groupBy293428022")
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   for (GroupResult element : securityCenterClient.groupFindings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GroupFindingsPagedResponse groupFindings(GroupFindingsRequest request) {
    return groupFindingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Filters an organization or source's findings and groups them by their specified properties in a
   * location. If no location is specified, findings are assumed to be in global
   *
   * <p>To group across all sources provide a `-` as the source id. The following list shows some
   * examples:
   *
   * <p>+ `/v2/organizations/{organization_id}/sources/-/findings` +
   * `/v2/organizations/{organization_id}/sources/-/locations/{location_id}/findings` +
   * `/v2/folders/{folder_id}/sources/-/findings` +
   * `/v2/folders/{folder_id}/sources/-/locations/{location_id}/findings` +
   * `/v2/projects/{project_id}/sources/-/findings` +
   * `/v2/projects/{project_id}/sources/-/locations/{location_id}/findings`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   GroupFindingsRequest request =
   *       GroupFindingsRequest.newBuilder()
   *           .setParent(
   *               SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setGroupBy("groupBy293428022")
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   ApiFuture<GroupResult> future =
   *       securityCenterClient.groupFindingsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (GroupResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<GroupFindingsRequest, GroupFindingsPagedResponse>
      groupFindingsPagedCallable() {
    return stub.groupFindingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Filters an organization or source's findings and groups them by their specified properties in a
   * location. If no location is specified, findings are assumed to be in global
   *
   * <p>To group across all sources provide a `-` as the source id. The following list shows some
   * examples:
   *
   * <p>+ `/v2/organizations/{organization_id}/sources/-/findings` +
   * `/v2/organizations/{organization_id}/sources/-/locations/{location_id}/findings` +
   * `/v2/folders/{folder_id}/sources/-/findings` +
   * `/v2/folders/{folder_id}/sources/-/locations/{location_id}/findings` +
   * `/v2/projects/{project_id}/sources/-/findings` +
   * `/v2/projects/{project_id}/sources/-/locations/{location_id}/findings`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   GroupFindingsRequest request =
   *       GroupFindingsRequest.newBuilder()
   *           .setParent(
   *               SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setGroupBy("groupBy293428022")
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   while (true) {
   *     GroupFindingsResponse response = securityCenterClient.groupFindingsCallable().call(request);
   *     for (GroupResult element : response.getGroupByResultsList()) {
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
  public final UnaryCallable<GroupFindingsRequest, GroupFindingsResponse> groupFindingsCallable() {
    return stub.groupFindingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the attack paths for a set of simulation results or valued resources and filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ValuedResourceName parent =
   *       ValuedResourceName.of("[ORGANIZATION]", "[SIMULATION]", "[VALUED_RESOURCE]");
   *   for (AttackPath element : securityCenterClient.listAttackPaths(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list attack paths.
   *     <p>Valid formats: "organizations/{organization}",
   *     "organizations/{organization}/simulations/{simulation}"
   *     "organizations/{organization}/simulations/{simulation}/attackExposureResults/{attack_exposure_result_v2}"
   *     "organizations/{organization}/simulations/{simulation}/valuedResources/{valued_resource}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAttackPathsPagedResponse listAttackPaths(ValuedResourceName parent) {
    ListAttackPathsRequest request =
        ListAttackPathsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAttackPaths(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the attack paths for a set of simulation results or valued resources and filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String parent =
   *       ValuedResourceName.of("[ORGANIZATION]", "[SIMULATION]", "[VALUED_RESOURCE]").toString();
   *   for (AttackPath element : securityCenterClient.listAttackPaths(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list attack paths.
   *     <p>Valid formats: "organizations/{organization}",
   *     "organizations/{organization}/simulations/{simulation}"
   *     "organizations/{organization}/simulations/{simulation}/attackExposureResults/{attack_exposure_result_v2}"
   *     "organizations/{organization}/simulations/{simulation}/valuedResources/{valued_resource}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAttackPathsPagedResponse listAttackPaths(String parent) {
    ListAttackPathsRequest request = ListAttackPathsRequest.newBuilder().setParent(parent).build();
    return listAttackPaths(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the attack paths for a set of simulation results or valued resources and filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ListAttackPathsRequest request =
   *       ListAttackPathsRequest.newBuilder()
   *           .setParent(
   *               ValuedResourceName.of("[ORGANIZATION]", "[SIMULATION]", "[VALUED_RESOURCE]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   for (AttackPath element : securityCenterClient.listAttackPaths(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAttackPathsPagedResponse listAttackPaths(ListAttackPathsRequest request) {
    return listAttackPathsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the attack paths for a set of simulation results or valued resources and filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ListAttackPathsRequest request =
   *       ListAttackPathsRequest.newBuilder()
   *           .setParent(
   *               ValuedResourceName.of("[ORGANIZATION]", "[SIMULATION]", "[VALUED_RESOURCE]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   ApiFuture<AttackPath> future =
   *       securityCenterClient.listAttackPathsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AttackPath element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAttackPathsRequest, ListAttackPathsPagedResponse>
      listAttackPathsPagedCallable() {
    return stub.listAttackPathsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the attack paths for a set of simulation results or valued resources and filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ListAttackPathsRequest request =
   *       ListAttackPathsRequest.newBuilder()
   *           .setParent(
   *               ValuedResourceName.of("[ORGANIZATION]", "[SIMULATION]", "[VALUED_RESOURCE]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   while (true) {
   *     ListAttackPathsResponse response =
   *         securityCenterClient.listAttackPathsCallable().call(request);
   *     for (AttackPath element : response.getAttackPathsList()) {
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
  public final UnaryCallable<ListAttackPathsRequest, ListAttackPathsResponse>
      listAttackPathsCallable() {
    return stub.listAttackPathsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BigQuery exports. Note that when requesting BigQuery exports at a given level all exports
   * under that level are also returned e.g. if requesting BigQuery exports under a folder, then all
   * BigQuery exports immediately under the folder plus the ones created under the projects within
   * the folder are returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
   *   for (BigQueryExport element : securityCenterClient.listBigQueryExports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns the collection of BigQuery exports. Its format
   *     is "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]", or
   *     "projects/[project_id]/locations/[location_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBigQueryExportsPagedResponse listBigQueryExports(FolderLocationName parent) {
    ListBigQueryExportsRequest request =
        ListBigQueryExportsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBigQueryExports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BigQuery exports. Note that when requesting BigQuery exports at a given level all exports
   * under that level are also returned e.g. if requesting BigQuery exports under a folder, then all
   * BigQuery exports immediately under the folder plus the ones created under the projects within
   * the folder are returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (BigQueryExport element : securityCenterClient.listBigQueryExports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns the collection of BigQuery exports. Its format
   *     is "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]", or
   *     "projects/[project_id]/locations/[location_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBigQueryExportsPagedResponse listBigQueryExports(LocationName parent) {
    ListBigQueryExportsRequest request =
        ListBigQueryExportsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBigQueryExports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BigQuery exports. Note that when requesting BigQuery exports at a given level all exports
   * under that level are also returned e.g. if requesting BigQuery exports under a folder, then all
   * BigQuery exports immediately under the folder plus the ones created under the projects within
   * the folder are returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (BigQueryExport element : securityCenterClient.listBigQueryExports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns the collection of BigQuery exports. Its format
   *     is "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]", or
   *     "projects/[project_id]/locations/[location_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBigQueryExportsPagedResponse listBigQueryExports(
      OrganizationLocationName parent) {
    ListBigQueryExportsRequest request =
        ListBigQueryExportsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBigQueryExports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BigQuery exports. Note that when requesting BigQuery exports at a given level all exports
   * under that level are also returned e.g. if requesting BigQuery exports under a folder, then all
   * BigQuery exports immediately under the folder plus the ones created under the projects within
   * the folder are returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (BigQueryExport element : securityCenterClient.listBigQueryExports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns the collection of BigQuery exports. Its format
   *     is "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]", or
   *     "projects/[project_id]/locations/[location_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBigQueryExportsPagedResponse listBigQueryExports(String parent) {
    ListBigQueryExportsRequest request =
        ListBigQueryExportsRequest.newBuilder().setParent(parent).build();
    return listBigQueryExports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BigQuery exports. Note that when requesting BigQuery exports at a given level all exports
   * under that level are also returned e.g. if requesting BigQuery exports under a folder, then all
   * BigQuery exports immediately under the folder plus the ones created under the projects within
   * the folder are returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ListBigQueryExportsRequest request =
   *       ListBigQueryExportsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (BigQueryExport element :
   *       securityCenterClient.listBigQueryExports(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBigQueryExportsPagedResponse listBigQueryExports(
      ListBigQueryExportsRequest request) {
    return listBigQueryExportsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BigQuery exports. Note that when requesting BigQuery exports at a given level all exports
   * under that level are also returned e.g. if requesting BigQuery exports under a folder, then all
   * BigQuery exports immediately under the folder plus the ones created under the projects within
   * the folder are returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ListBigQueryExportsRequest request =
   *       ListBigQueryExportsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<BigQueryExport> future =
   *       securityCenterClient.listBigQueryExportsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (BigQueryExport element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBigQueryExportsRequest, ListBigQueryExportsPagedResponse>
      listBigQueryExportsPagedCallable() {
    return stub.listBigQueryExportsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BigQuery exports. Note that when requesting BigQuery exports at a given level all exports
   * under that level are also returned e.g. if requesting BigQuery exports under a folder, then all
   * BigQuery exports immediately under the folder plus the ones created under the projects within
   * the folder are returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ListBigQueryExportsRequest request =
   *       ListBigQueryExportsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListBigQueryExportsResponse response =
   *         securityCenterClient.listBigQueryExportsCallable().call(request);
   *     for (BigQueryExport element : response.getBigQueryExportsList()) {
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
  public final UnaryCallable<ListBigQueryExportsRequest, ListBigQueryExportsResponse>
      listBigQueryExportsCallable() {
    return stub.listBigQueryExportsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists an organization or source's findings.
   *
   * <p>To list across all sources for a given location provide a `-` as the source id. If no
   * location is specified, finding are assumed to be in global. The following list shows some
   * examples:
   *
   * <p>+ `/v2/organizations/{organization_id}/sources/-/findings` +
   * `/v2/organizations/{organization_id}/sources/-/locations/{location_id}/findings`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   SourceName parent = SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]");
   *   for (ListFindingsResponse.ListFindingsResult element :
   *       securityCenterClient.listFindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of the source the findings belong to. If no location is specified,
   *     the default is global. The following list shows some examples:
   *     <p>+ `organizations/[organization_id]/sources/[source_id]` +
   *     `organizations/[organization_id]/sources/[source_id]/locations/[location_id]` +
   *     `folders/[folder_id]/sources/[source_id]` +
   *     `folders/[folder_id]/sources/[source_id]/locations/[location_id]` +
   *     `projects/[project_id]/sources/[source_id]` +
   *     `projects/[project_id]/sources/[source_id]/locations/[location_id]`
   *     <p>To list across all sources provide a source_id of `-`. The following list shows some
   *     examples:
   *     <p>+ `organizations/{organization_id}/sources/-` +
   *     `organizations/{organization_id}/sources/-/locations/{location_id}` +
   *     `folders/{folder_id}/sources/-` + `folders/{folder_id}/sources/-locations/{location_id}` +
   *     `projects/{projects_id}/sources/-` +
   *     `projects/{projects_id}/sources/-/locations/{location_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFindingsPagedResponse listFindings(SourceName parent) {
    ListFindingsRequest request =
        ListFindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists an organization or source's findings.
   *
   * <p>To list across all sources for a given location provide a `-` as the source id. If no
   * location is specified, finding are assumed to be in global. The following list shows some
   * examples:
   *
   * <p>+ `/v2/organizations/{organization_id}/sources/-/findings` +
   * `/v2/organizations/{organization_id}/sources/-/locations/{location_id}/findings`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String parent = SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString();
   *   for (ListFindingsResponse.ListFindingsResult element :
   *       securityCenterClient.listFindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of the source the findings belong to. If no location is specified,
   *     the default is global. The following list shows some examples:
   *     <p>+ `organizations/[organization_id]/sources/[source_id]` +
   *     `organizations/[organization_id]/sources/[source_id]/locations/[location_id]` +
   *     `folders/[folder_id]/sources/[source_id]` +
   *     `folders/[folder_id]/sources/[source_id]/locations/[location_id]` +
   *     `projects/[project_id]/sources/[source_id]` +
   *     `projects/[project_id]/sources/[source_id]/locations/[location_id]`
   *     <p>To list across all sources provide a source_id of `-`. The following list shows some
   *     examples:
   *     <p>+ `organizations/{organization_id}/sources/-` +
   *     `organizations/{organization_id}/sources/-/locations/{location_id}` +
   *     `folders/{folder_id}/sources/-` + `folders/{folder_id}/sources/-locations/{location_id}` +
   *     `projects/{projects_id}/sources/-` +
   *     `projects/{projects_id}/sources/-/locations/{location_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFindingsPagedResponse listFindings(String parent) {
    ListFindingsRequest request = ListFindingsRequest.newBuilder().setParent(parent).build();
    return listFindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists an organization or source's findings.
   *
   * <p>To list across all sources for a given location provide a `-` as the source id. If no
   * location is specified, finding are assumed to be in global. The following list shows some
   * examples:
   *
   * <p>+ `/v2/organizations/{organization_id}/sources/-/findings` +
   * `/v2/organizations/{organization_id}/sources/-/locations/{location_id}/findings`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ListFindingsRequest request =
   *       ListFindingsRequest.newBuilder()
   *           .setParent(
   *               SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFieldMask(FieldMask.newBuilder().build())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   for (ListFindingsResponse.ListFindingsResult element :
   *       securityCenterClient.listFindings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFindingsPagedResponse listFindings(ListFindingsRequest request) {
    return listFindingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists an organization or source's findings.
   *
   * <p>To list across all sources for a given location provide a `-` as the source id. If no
   * location is specified, finding are assumed to be in global. The following list shows some
   * examples:
   *
   * <p>+ `/v2/organizations/{organization_id}/sources/-/findings` +
   * `/v2/organizations/{organization_id}/sources/-/locations/{location_id}/findings`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ListFindingsRequest request =
   *       ListFindingsRequest.newBuilder()
   *           .setParent(
   *               SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFieldMask(FieldMask.newBuilder().build())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   ApiFuture<ListFindingsResponse.ListFindingsResult> future =
   *       securityCenterClient.listFindingsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ListFindingsResponse.ListFindingsResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFindingsRequest, ListFindingsPagedResponse>
      listFindingsPagedCallable() {
    return stub.listFindingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists an organization or source's findings.
   *
   * <p>To list across all sources for a given location provide a `-` as the source id. If no
   * location is specified, finding are assumed to be in global. The following list shows some
   * examples:
   *
   * <p>+ `/v2/organizations/{organization_id}/sources/-/findings` +
   * `/v2/organizations/{organization_id}/sources/-/locations/{location_id}/findings`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ListFindingsRequest request =
   *       ListFindingsRequest.newBuilder()
   *           .setParent(
   *               SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFieldMask(FieldMask.newBuilder().build())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   while (true) {
   *     ListFindingsResponse response = securityCenterClient.listFindingsCallable().call(request);
   *     for (ListFindingsResponse.ListFindingsResult element :
   *         response.getListFindingsResultsList()) {
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
  public final UnaryCallable<ListFindingsRequest, ListFindingsResponse> listFindingsCallable() {
    return stub.listFindingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists mute configs. If no location is specified, default is global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
   *   for (MuteConfig element : securityCenterClient.listMuteConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns the collection of mute configs. Its format is
   *     "organizations/[organization_id]", "folders/[folder_id]", "projects/[project_id]",
   *     "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]",
   *     "projects/[project_id]/locations/[location_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMuteConfigsPagedResponse listMuteConfigs(FolderLocationName parent) {
    ListMuteConfigsRequest request =
        ListMuteConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMuteConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists mute configs. If no location is specified, default is global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   FolderName parent = FolderName.of("[FOLDER]");
   *   for (MuteConfig element : securityCenterClient.listMuteConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns the collection of mute configs. Its format is
   *     "organizations/[organization_id]", "folders/[folder_id]", "projects/[project_id]",
   *     "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]",
   *     "projects/[project_id]/locations/[location_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMuteConfigsPagedResponse listMuteConfigs(FolderName parent) {
    ListMuteConfigsRequest request =
        ListMuteConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMuteConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists mute configs. If no location is specified, default is global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (MuteConfig element : securityCenterClient.listMuteConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns the collection of mute configs. Its format is
   *     "organizations/[organization_id]", "folders/[folder_id]", "projects/[project_id]",
   *     "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]",
   *     "projects/[project_id]/locations/[location_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMuteConfigsPagedResponse listMuteConfigs(LocationName parent) {
    ListMuteConfigsRequest request =
        ListMuteConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMuteConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists mute configs. If no location is specified, default is global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (MuteConfig element : securityCenterClient.listMuteConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns the collection of mute configs. Its format is
   *     "organizations/[organization_id]", "folders/[folder_id]", "projects/[project_id]",
   *     "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]",
   *     "projects/[project_id]/locations/[location_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMuteConfigsPagedResponse listMuteConfigs(OrganizationLocationName parent) {
    ListMuteConfigsRequest request =
        ListMuteConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMuteConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists mute configs. If no location is specified, default is global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   for (MuteConfig element : securityCenterClient.listMuteConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns the collection of mute configs. Its format is
   *     "organizations/[organization_id]", "folders/[folder_id]", "projects/[project_id]",
   *     "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]",
   *     "projects/[project_id]/locations/[location_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMuteConfigsPagedResponse listMuteConfigs(OrganizationName parent) {
    ListMuteConfigsRequest request =
        ListMuteConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMuteConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists mute configs. If no location is specified, default is global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (MuteConfig element : securityCenterClient.listMuteConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns the collection of mute configs. Its format is
   *     "organizations/[organization_id]", "folders/[folder_id]", "projects/[project_id]",
   *     "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]",
   *     "projects/[project_id]/locations/[location_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMuteConfigsPagedResponse listMuteConfigs(ProjectName parent) {
    ListMuteConfigsRequest request =
        ListMuteConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMuteConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists mute configs. If no location is specified, default is global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   for (MuteConfig element : securityCenterClient.listMuteConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns the collection of mute configs. Its format is
   *     "organizations/[organization_id]", "folders/[folder_id]", "projects/[project_id]",
   *     "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]",
   *     "projects/[project_id]/locations/[location_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMuteConfigsPagedResponse listMuteConfigs(String parent) {
    ListMuteConfigsRequest request = ListMuteConfigsRequest.newBuilder().setParent(parent).build();
    return listMuteConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists mute configs. If no location is specified, default is global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ListMuteConfigsRequest request =
   *       ListMuteConfigsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (MuteConfig element : securityCenterClient.listMuteConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMuteConfigsPagedResponse listMuteConfigs(ListMuteConfigsRequest request) {
    return listMuteConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists mute configs. If no location is specified, default is global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ListMuteConfigsRequest request =
   *       ListMuteConfigsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<MuteConfig> future =
   *       securityCenterClient.listMuteConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MuteConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMuteConfigsRequest, ListMuteConfigsPagedResponse>
      listMuteConfigsPagedCallable() {
    return stub.listMuteConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists mute configs. If no location is specified, default is global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ListMuteConfigsRequest request =
   *       ListMuteConfigsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListMuteConfigsResponse response =
   *         securityCenterClient.listMuteConfigsCallable().call(request);
   *     for (MuteConfig element : response.getMuteConfigsList()) {
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
  public final UnaryCallable<ListMuteConfigsRequest, ListMuteConfigsResponse>
      listMuteConfigsCallable() {
    return stub.listMuteConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists notification configs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
   *   for (NotificationConfig element :
   *       securityCenterClient.listNotificationConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent in which to list the notification
   *     configurations. Its format is "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]", or
   *     "projects/[project_id]/locations/[location_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotificationConfigsPagedResponse listNotificationConfigs(
      FolderLocationName parent) {
    ListNotificationConfigsRequest request =
        ListNotificationConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listNotificationConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists notification configs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (NotificationConfig element :
   *       securityCenterClient.listNotificationConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent in which to list the notification
   *     configurations. Its format is "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]", or
   *     "projects/[project_id]/locations/[location_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotificationConfigsPagedResponse listNotificationConfigs(LocationName parent) {
    ListNotificationConfigsRequest request =
        ListNotificationConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listNotificationConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists notification configs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (NotificationConfig element :
   *       securityCenterClient.listNotificationConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent in which to list the notification
   *     configurations. Its format is "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]", or
   *     "projects/[project_id]/locations/[location_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotificationConfigsPagedResponse listNotificationConfigs(
      OrganizationLocationName parent) {
    ListNotificationConfigsRequest request =
        ListNotificationConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listNotificationConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists notification configs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (NotificationConfig element :
   *       securityCenterClient.listNotificationConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent in which to list the notification
   *     configurations. Its format is "organizations/[organization_id]/locations/[location_id]",
   *     "folders/[folder_id]/locations/[location_id]", or
   *     "projects/[project_id]/locations/[location_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotificationConfigsPagedResponse listNotificationConfigs(String parent) {
    ListNotificationConfigsRequest request =
        ListNotificationConfigsRequest.newBuilder().setParent(parent).build();
    return listNotificationConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists notification configs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ListNotificationConfigsRequest request =
   *       ListNotificationConfigsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   for (NotificationConfig element :
   *       securityCenterClient.listNotificationConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotificationConfigsPagedResponse listNotificationConfigs(
      ListNotificationConfigsRequest request) {
    return listNotificationConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists notification configs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ListNotificationConfigsRequest request =
   *       ListNotificationConfigsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   ApiFuture<NotificationConfig> future =
   *       securityCenterClient.listNotificationConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (NotificationConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNotificationConfigsRequest, ListNotificationConfigsPagedResponse>
      listNotificationConfigsPagedCallable() {
    return stub.listNotificationConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists notification configs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ListNotificationConfigsRequest request =
   *       ListNotificationConfigsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   while (true) {
   *     ListNotificationConfigsResponse response =
   *         securityCenterClient.listNotificationConfigsCallable().call(request);
   *     for (NotificationConfig element : response.getNotificationConfigsList()) {
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
  public final UnaryCallable<ListNotificationConfigsRequest, ListNotificationConfigsResponse>
      listNotificationConfigsCallable() {
    return stub.listNotificationConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all ResourceValueConfigs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   for (ResourceValueConfig element :
   *       securityCenterClient.listResourceValueConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns the collection of resource value configs. Its
   *     format is "organizations/[organization_id]"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListResourceValueConfigsPagedResponse listResourceValueConfigs(
      OrganizationName parent) {
    ListResourceValueConfigsRequest request =
        ListResourceValueConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listResourceValueConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all ResourceValueConfigs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   for (ResourceValueConfig element :
   *       securityCenterClient.listResourceValueConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns the collection of resource value configs. Its
   *     format is "organizations/[organization_id]"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListResourceValueConfigsPagedResponse listResourceValueConfigs(String parent) {
    ListResourceValueConfigsRequest request =
        ListResourceValueConfigsRequest.newBuilder().setParent(parent).build();
    return listResourceValueConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all ResourceValueConfigs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ListResourceValueConfigsRequest request =
   *       ListResourceValueConfigsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ResourceValueConfig element :
   *       securityCenterClient.listResourceValueConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListResourceValueConfigsPagedResponse listResourceValueConfigs(
      ListResourceValueConfigsRequest request) {
    return listResourceValueConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all ResourceValueConfigs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ListResourceValueConfigsRequest request =
   *       ListResourceValueConfigsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ResourceValueConfig> future =
   *       securityCenterClient.listResourceValueConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ResourceValueConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListResourceValueConfigsRequest, ListResourceValueConfigsPagedResponse>
      listResourceValueConfigsPagedCallable() {
    return stub.listResourceValueConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all ResourceValueConfigs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ListResourceValueConfigsRequest request =
   *       ListResourceValueConfigsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListResourceValueConfigsResponse response =
   *         securityCenterClient.listResourceValueConfigsCallable().call(request);
   *     for (ResourceValueConfig element : response.getResourceValueConfigsList()) {
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
  public final UnaryCallable<ListResourceValueConfigsRequest, ListResourceValueConfigsResponse>
      listResourceValueConfigsCallable() {
    return stub.listResourceValueConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all sources belonging to an organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   FolderName parent = FolderName.of("[FOLDER]");
   *   for (Source element : securityCenterClient.listSources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the parent of sources to list. Its format should be
   *     "organizations/[organization_id]", "folders/[folder_id]", or "projects/[project_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSourcesPagedResponse listSources(FolderName parent) {
    ListSourcesRequest request =
        ListSourcesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all sources belonging to an organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   for (Source element : securityCenterClient.listSources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the parent of sources to list. Its format should be
   *     "organizations/[organization_id]", "folders/[folder_id]", or "projects/[project_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSourcesPagedResponse listSources(OrganizationName parent) {
    ListSourcesRequest request =
        ListSourcesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all sources belonging to an organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (Source element : securityCenterClient.listSources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the parent of sources to list. Its format should be
   *     "organizations/[organization_id]", "folders/[folder_id]", or "projects/[project_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSourcesPagedResponse listSources(ProjectName parent) {
    ListSourcesRequest request =
        ListSourcesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all sources belonging to an organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   for (Source element : securityCenterClient.listSources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the parent of sources to list. Its format should be
   *     "organizations/[organization_id]", "folders/[folder_id]", or "projects/[project_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSourcesPagedResponse listSources(String parent) {
    ListSourcesRequest request = ListSourcesRequest.newBuilder().setParent(parent).build();
    return listSources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all sources belonging to an organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ListSourcesRequest request =
   *       ListSourcesRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   for (Source element : securityCenterClient.listSources(request).iterateAll()) {
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
   * Lists all sources belonging to an organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ListSourcesRequest request =
   *       ListSourcesRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   ApiFuture<Source> future =
   *       securityCenterClient.listSourcesPagedCallable().futureCall(request);
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
   * Lists all sources belonging to an organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ListSourcesRequest request =
   *       ListSourcesRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   while (true) {
   *     ListSourcesResponse response = securityCenterClient.listSourcesCallable().call(request);
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
   * Lists the valued resources for a set of simulation results and filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   SimulationName parent = SimulationName.of("[ORGANIZATION]", "[SIMULATION]");
   *   for (ValuedResource element : securityCenterClient.listValuedResources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list exposed resources.
   *     <p>Valid formats: "organizations/{organization}",
   *     "organizations/{organization}/simulations/{simulation}"
   *     "organizations/{organization}/simulations/{simulation}/attackExposureResults/{attack_exposure_result_v2}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListValuedResourcesPagedResponse listValuedResources(SimulationName parent) {
    ListValuedResourcesRequest request =
        ListValuedResourcesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listValuedResources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the valued resources for a set of simulation results and filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String parent = SimulationName.of("[ORGANIZATION]", "[SIMULATION]").toString();
   *   for (ValuedResource element : securityCenterClient.listValuedResources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list exposed resources.
   *     <p>Valid formats: "organizations/{organization}",
   *     "organizations/{organization}/simulations/{simulation}"
   *     "organizations/{organization}/simulations/{simulation}/attackExposureResults/{attack_exposure_result_v2}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListValuedResourcesPagedResponse listValuedResources(String parent) {
    ListValuedResourcesRequest request =
        ListValuedResourcesRequest.newBuilder().setParent(parent).build();
    return listValuedResources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the valued resources for a set of simulation results and filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ListValuedResourcesRequest request =
   *       ListValuedResourcesRequest.newBuilder()
   *           .setParent(SimulationName.of("[ORGANIZATION]", "[SIMULATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ValuedResource element :
   *       securityCenterClient.listValuedResources(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListValuedResourcesPagedResponse listValuedResources(
      ListValuedResourcesRequest request) {
    return listValuedResourcesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the valued resources for a set of simulation results and filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ListValuedResourcesRequest request =
   *       ListValuedResourcesRequest.newBuilder()
   *           .setParent(SimulationName.of("[ORGANIZATION]", "[SIMULATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ValuedResource> future =
   *       securityCenterClient.listValuedResourcesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ValuedResource element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListValuedResourcesRequest, ListValuedResourcesPagedResponse>
      listValuedResourcesPagedCallable() {
    return stub.listValuedResourcesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the valued resources for a set of simulation results and filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ListValuedResourcesRequest request =
   *       ListValuedResourcesRequest.newBuilder()
   *           .setParent(SimulationName.of("[ORGANIZATION]", "[SIMULATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListValuedResourcesResponse response =
   *         securityCenterClient.listValuedResourcesCallable().call(request);
   *     for (ValuedResource element : response.getValuedResourcesList()) {
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
  public final UnaryCallable<ListValuedResourcesRequest, ListValuedResourcesResponse>
      listValuedResourcesCallable() {
    return stub.listValuedResourcesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the state of a finding. If no location is specified, finding is assumed to be in global
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   FindingName name =
   *       FindingName.ofOrganizationSourceFindingName("[ORGANIZATION]", "[SOURCE]", "[FINDING]");
   *   Finding.State state = Finding.State.forNumber(0);
   *   Finding response = securityCenterClient.setFindingState(name, state);
   * }
   * }</pre>
   *
   * @param name Required. The [relative resource
   *     name](https://cloud.google.com/apis/design/resource_names#relative_resource_name) of the
   *     finding. If no location is specified, finding is assumed to be in global. The following
   *     list shows some examples:
   *     <p>+ `organizations/{organization_id}/sources/{source_id}/findings/{finding_id}` +
   *     `organizations/{organization_id}/sources/{source_id}/locations/{location_id}/findings/{finding_id}`
   *     + `folders/{folder_id}/sources/{source_id}/findings/{finding_id}` +
   *     `folders/{folder_id}/sources/{source_id}/locations/{location_id}/findings/{finding_id}` +
   *     `projects/{project_id}/sources/{source_id}/findings/{finding_id}` +
   *     `projects/{project_id}/sources/{source_id}/locations/{location_id}/findings/{finding_id}`
   * @param state Required. The desired State of the finding.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Finding setFindingState(FindingName name, Finding.State state) {
    SetFindingStateRequest request =
        SetFindingStateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setState(state)
            .build();
    return setFindingState(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the state of a finding. If no location is specified, finding is assumed to be in global
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String name =
   *       FindingName.ofOrganizationSourceFindingName("[ORGANIZATION]", "[SOURCE]", "[FINDING]")
   *           .toString();
   *   Finding.State state = Finding.State.forNumber(0);
   *   Finding response = securityCenterClient.setFindingState(name, state);
   * }
   * }</pre>
   *
   * @param name Required. The [relative resource
   *     name](https://cloud.google.com/apis/design/resource_names#relative_resource_name) of the
   *     finding. If no location is specified, finding is assumed to be in global. The following
   *     list shows some examples:
   *     <p>+ `organizations/{organization_id}/sources/{source_id}/findings/{finding_id}` +
   *     `organizations/{organization_id}/sources/{source_id}/locations/{location_id}/findings/{finding_id}`
   *     + `folders/{folder_id}/sources/{source_id}/findings/{finding_id}` +
   *     `folders/{folder_id}/sources/{source_id}/locations/{location_id}/findings/{finding_id}` +
   *     `projects/{project_id}/sources/{source_id}/findings/{finding_id}` +
   *     `projects/{project_id}/sources/{source_id}/locations/{location_id}/findings/{finding_id}`
   * @param state Required. The desired State of the finding.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Finding setFindingState(String name, Finding.State state) {
    SetFindingStateRequest request =
        SetFindingStateRequest.newBuilder().setName(name).setState(state).build();
    return setFindingState(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the state of a finding. If no location is specified, finding is assumed to be in global
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   SetFindingStateRequest request =
   *       SetFindingStateRequest.newBuilder()
   *           .setName(
   *               FindingName.ofOrganizationSourceFindingName(
   *                       "[ORGANIZATION]", "[SOURCE]", "[FINDING]")
   *                   .toString())
   *           .build();
   *   Finding response = securityCenterClient.setFindingState(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Finding setFindingState(SetFindingStateRequest request) {
    return setFindingStateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the state of a finding. If no location is specified, finding is assumed to be in global
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   SetFindingStateRequest request =
   *       SetFindingStateRequest.newBuilder()
   *           .setName(
   *               FindingName.ofOrganizationSourceFindingName(
   *                       "[ORGANIZATION]", "[SOURCE]", "[FINDING]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Finding> future =
   *       securityCenterClient.setFindingStateCallable().futureCall(request);
   *   // Do something.
   *   Finding response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetFindingStateRequest, Finding> setFindingStateCallable() {
    return stub.setFindingStateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ResourceName resource = SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = securityCenterClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(ResourceName resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setPolicy(policy)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String resource = FolderName.of("[FOLDER]").toString();
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = securityCenterClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(FolderName.of("[FOLDER]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = securityCenterClient.setIamPolicy(request);
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
   * Sets the access control policy on the specified Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(FolderName.of("[FOLDER]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = securityCenterClient.setIamPolicyCallable().futureCall(request);
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
   * Updates the mute state of a finding. If no location is specified, finding is assumed to be in
   * global
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   FindingName name =
   *       FindingName.ofOrganizationSourceFindingName("[ORGANIZATION]", "[SOURCE]", "[FINDING]");
   *   Finding.Mute mute = Finding.Mute.forNumber(0);
   *   Finding response = securityCenterClient.setMute(name, mute);
   * }
   * }</pre>
   *
   * @param name Required. The [relative resource
   *     name](https://cloud.google.com/apis/design/resource_names#relative_resource_name) of the
   *     finding. If no location is specified, finding is assumed to be in global. The following
   *     list shows some examples:
   *     <p>+ `organizations/{organization_id}/sources/{source_id}/findings/{finding_id}` +
   *     `organizations/{organization_id}/sources/{source_id}/locations/{location_id}/findings/{finding_id}`
   *     + `folders/{folder_id}/sources/{source_id}/findings/{finding_id}` +
   *     `folders/{folder_id}/sources/{source_id}/locations/{location_id}/findings/{finding_id}` +
   *     `projects/{project_id}/sources/{source_id}/findings/{finding_id}` +
   *     `projects/{project_id}/sources/{source_id}/locations/{location_id}/findings/{finding_id}`
   * @param mute Required. The desired state of the Mute.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Finding setMute(FindingName name, Finding.Mute mute) {
    SetMuteRequest request =
        SetMuteRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setMute(mute)
            .build();
    return setMute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the mute state of a finding. If no location is specified, finding is assumed to be in
   * global
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String name =
   *       FindingName.ofOrganizationSourceFindingName("[ORGANIZATION]", "[SOURCE]", "[FINDING]")
   *           .toString();
   *   Finding.Mute mute = Finding.Mute.forNumber(0);
   *   Finding response = securityCenterClient.setMute(name, mute);
   * }
   * }</pre>
   *
   * @param name Required. The [relative resource
   *     name](https://cloud.google.com/apis/design/resource_names#relative_resource_name) of the
   *     finding. If no location is specified, finding is assumed to be in global. The following
   *     list shows some examples:
   *     <p>+ `organizations/{organization_id}/sources/{source_id}/findings/{finding_id}` +
   *     `organizations/{organization_id}/sources/{source_id}/locations/{location_id}/findings/{finding_id}`
   *     + `folders/{folder_id}/sources/{source_id}/findings/{finding_id}` +
   *     `folders/{folder_id}/sources/{source_id}/locations/{location_id}/findings/{finding_id}` +
   *     `projects/{project_id}/sources/{source_id}/findings/{finding_id}` +
   *     `projects/{project_id}/sources/{source_id}/locations/{location_id}/findings/{finding_id}`
   * @param mute Required. The desired state of the Mute.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Finding setMute(String name, Finding.Mute mute) {
    SetMuteRequest request = SetMuteRequest.newBuilder().setName(name).setMute(mute).build();
    return setMute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the mute state of a finding. If no location is specified, finding is assumed to be in
   * global
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   SetMuteRequest request =
   *       SetMuteRequest.newBuilder()
   *           .setName(
   *               FindingName.ofOrganizationSourceFindingName(
   *                       "[ORGANIZATION]", "[SOURCE]", "[FINDING]")
   *                   .toString())
   *           .build();
   *   Finding response = securityCenterClient.setMute(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Finding setMute(SetMuteRequest request) {
    return setMuteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the mute state of a finding. If no location is specified, finding is assumed to be in
   * global
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   SetMuteRequest request =
   *       SetMuteRequest.newBuilder()
   *           .setName(
   *               FindingName.ofOrganizationSourceFindingName(
   *                       "[ORGANIZATION]", "[SOURCE]", "[FINDING]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Finding> future = securityCenterClient.setMuteCallable().futureCall(request);
   *   // Do something.
   *   Finding response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetMuteRequest, Finding> setMuteCallable() {
    return stub.setMuteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the permissions that a caller has on the specified source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ResourceName resource = SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]");
   *   List<String> permissions = new ArrayList<>();
   *   TestIamPermissionsResponse response =
   *       securityCenterClient.testIamPermissions(resource, permissions);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      ResourceName resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the permissions that a caller has on the specified source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   String resource = FolderName.of("[FOLDER]").toString();
   *   List<String> permissions = new ArrayList<>();
   *   TestIamPermissionsResponse response =
   *       securityCenterClient.testIamPermissions(resource, permissions);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      String resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the permissions that a caller has on the specified source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(FolderName.of("[FOLDER]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = securityCenterClient.testIamPermissions(request);
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
   * Returns the permissions that a caller has on the specified source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(FolderName.of("[FOLDER]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       securityCenterClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a BigQuery export.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   BigQueryExport bigQueryExport = BigQueryExport.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   BigQueryExport response =
   *       securityCenterClient.updateBigQueryExport(bigQueryExport, updateMask);
   * }
   * }</pre>
   *
   * @param bigQueryExport Required. The BigQuery export being updated.
   * @param updateMask The list of fields to be updated. If empty all mutable fields will be
   *     updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BigQueryExport updateBigQueryExport(
      BigQueryExport bigQueryExport, FieldMask updateMask) {
    UpdateBigQueryExportRequest request =
        UpdateBigQueryExportRequest.newBuilder()
            .setBigQueryExport(bigQueryExport)
            .setUpdateMask(updateMask)
            .build();
    return updateBigQueryExport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a BigQuery export.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   UpdateBigQueryExportRequest request =
   *       UpdateBigQueryExportRequest.newBuilder()
   *           .setBigQueryExport(BigQueryExport.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   BigQueryExport response = securityCenterClient.updateBigQueryExport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BigQueryExport updateBigQueryExport(UpdateBigQueryExportRequest request) {
    return updateBigQueryExportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a BigQuery export.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   UpdateBigQueryExportRequest request =
   *       UpdateBigQueryExportRequest.newBuilder()
   *           .setBigQueryExport(BigQueryExport.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<BigQueryExport> future =
   *       securityCenterClient.updateBigQueryExportCallable().futureCall(request);
   *   // Do something.
   *   BigQueryExport response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBigQueryExportRequest, BigQueryExport>
      updateBigQueryExportCallable() {
    return stub.updateBigQueryExportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates external system. This is for a given finding. If no location is specified, finding is
   * assumed to be in global
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ExternalSystem externalSystem = ExternalSystem.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ExternalSystem response =
   *       securityCenterClient.updateExternalSystem(externalSystem, updateMask);
   * }
   * }</pre>
   *
   * @param externalSystem Required. The external system resource to update.
   * @param updateMask The FieldMask to use when updating the external system resource.
   *     <p>If empty all mutable fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExternalSystem updateExternalSystem(
      ExternalSystem externalSystem, FieldMask updateMask) {
    UpdateExternalSystemRequest request =
        UpdateExternalSystemRequest.newBuilder()
            .setExternalSystem(externalSystem)
            .setUpdateMask(updateMask)
            .build();
    return updateExternalSystem(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates external system. This is for a given finding. If no location is specified, finding is
   * assumed to be in global
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   UpdateExternalSystemRequest request =
   *       UpdateExternalSystemRequest.newBuilder()
   *           .setExternalSystem(ExternalSystem.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ExternalSystem response = securityCenterClient.updateExternalSystem(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExternalSystem updateExternalSystem(UpdateExternalSystemRequest request) {
    return updateExternalSystemCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates external system. This is for a given finding. If no location is specified, finding is
   * assumed to be in global
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   UpdateExternalSystemRequest request =
   *       UpdateExternalSystemRequest.newBuilder()
   *           .setExternalSystem(ExternalSystem.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ExternalSystem> future =
   *       securityCenterClient.updateExternalSystemCallable().futureCall(request);
   *   // Do something.
   *   ExternalSystem response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateExternalSystemRequest, ExternalSystem>
      updateExternalSystemCallable() {
    return stub.updateExternalSystemCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates or updates a finding. If no location is specified, finding is assumed to be in global.
   * The corresponding source must exist for a finding creation to succeed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   Finding finding = Finding.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Finding response = securityCenterClient.updateFinding(finding, updateMask);
   * }
   * }</pre>
   *
   * @param finding Required. The finding resource to update or create if it does not already exist.
   *     parent, security_marks, and update_time will be ignored.
   *     <p>In the case of creation, the finding id portion of the name must be alphanumeric and
   *     less than or equal to 32 characters and greater than 0 characters in length.
   * @param updateMask The FieldMask to use when updating the finding resource. This field should
   *     not be specified when creating a finding.
   *     <p>When updating a finding, an empty mask is treated as updating all mutable fields and
   *     replacing source_properties. Individual source_properties can be added/updated by using
   *     "source_properties.&lt;property key&gt;" in the field mask.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Finding updateFinding(Finding finding, FieldMask updateMask) {
    UpdateFindingRequest request =
        UpdateFindingRequest.newBuilder().setFinding(finding).setUpdateMask(updateMask).build();
    return updateFinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates or updates a finding. If no location is specified, finding is assumed to be in global.
   * The corresponding source must exist for a finding creation to succeed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   UpdateFindingRequest request =
   *       UpdateFindingRequest.newBuilder()
   *           .setFinding(Finding.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Finding response = securityCenterClient.updateFinding(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Finding updateFinding(UpdateFindingRequest request) {
    return updateFindingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates or updates a finding. If no location is specified, finding is assumed to be in global.
   * The corresponding source must exist for a finding creation to succeed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   UpdateFindingRequest request =
   *       UpdateFindingRequest.newBuilder()
   *           .setFinding(Finding.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Finding> future = securityCenterClient.updateFindingCallable().futureCall(request);
   *   // Do something.
   *   Finding response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateFindingRequest, Finding> updateFindingCallable() {
    return stub.updateFindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a mute config. If no location is specified, default is global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   MuteConfig muteConfig = MuteConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   MuteConfig response = securityCenterClient.updateMuteConfig(muteConfig, updateMask);
   * }
   * }</pre>
   *
   * @param muteConfig Required. The mute config being updated.
   * @param updateMask The list of fields to be updated. If empty all mutable fields will be
   *     updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MuteConfig updateMuteConfig(MuteConfig muteConfig, FieldMask updateMask) {
    UpdateMuteConfigRequest request =
        UpdateMuteConfigRequest.newBuilder()
            .setMuteConfig(muteConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateMuteConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a mute config. If no location is specified, default is global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   UpdateMuteConfigRequest request =
   *       UpdateMuteConfigRequest.newBuilder()
   *           .setMuteConfig(MuteConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   MuteConfig response = securityCenterClient.updateMuteConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MuteConfig updateMuteConfig(UpdateMuteConfigRequest request) {
    return updateMuteConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a mute config. If no location is specified, default is global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   UpdateMuteConfigRequest request =
   *       UpdateMuteConfigRequest.newBuilder()
   *           .setMuteConfig(MuteConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<MuteConfig> future =
   *       securityCenterClient.updateMuteConfigCallable().futureCall(request);
   *   // Do something.
   *   MuteConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateMuteConfigRequest, MuteConfig> updateMuteConfigCallable() {
    return stub.updateMuteConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a notification config. The following update fields are allowed: description,
   * pubsub_topic, streaming_config.filter
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   NotificationConfig notificationConfig = NotificationConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   NotificationConfig response =
   *       securityCenterClient.updateNotificationConfig(notificationConfig, updateMask);
   * }
   * }</pre>
   *
   * @param notificationConfig Required. The notification config to update.
   * @param updateMask The FieldMask to use when updating the notification config.
   *     <p>If empty all mutable fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationConfig updateNotificationConfig(
      NotificationConfig notificationConfig, FieldMask updateMask) {
    UpdateNotificationConfigRequest request =
        UpdateNotificationConfigRequest.newBuilder()
            .setNotificationConfig(notificationConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateNotificationConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a notification config. The following update fields are allowed: description,
   * pubsub_topic, streaming_config.filter
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   UpdateNotificationConfigRequest request =
   *       UpdateNotificationConfigRequest.newBuilder()
   *           .setNotificationConfig(NotificationConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   NotificationConfig response = securityCenterClient.updateNotificationConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationConfig updateNotificationConfig(
      UpdateNotificationConfigRequest request) {
    return updateNotificationConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a notification config. The following update fields are allowed: description,
   * pubsub_topic, streaming_config.filter
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   UpdateNotificationConfigRequest request =
   *       UpdateNotificationConfigRequest.newBuilder()
   *           .setNotificationConfig(NotificationConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<NotificationConfig> future =
   *       securityCenterClient.updateNotificationConfigCallable().futureCall(request);
   *   // Do something.
   *   NotificationConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateNotificationConfigRequest, NotificationConfig>
      updateNotificationConfigCallable() {
    return stub.updateNotificationConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing ResourceValueConfigs with new rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   ResourceValueConfig resourceValueConfig = ResourceValueConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ResourceValueConfig response =
   *       securityCenterClient.updateResourceValueConfig(resourceValueConfig, updateMask);
   * }
   * }</pre>
   *
   * @param resourceValueConfig Required. The resource value config being updated.
   * @param updateMask The list of fields to be updated. If empty all mutable fields will be
   *     updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResourceValueConfig updateResourceValueConfig(
      ResourceValueConfig resourceValueConfig, FieldMask updateMask) {
    UpdateResourceValueConfigRequest request =
        UpdateResourceValueConfigRequest.newBuilder()
            .setResourceValueConfig(resourceValueConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateResourceValueConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing ResourceValueConfigs with new rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   UpdateResourceValueConfigRequest request =
   *       UpdateResourceValueConfigRequest.newBuilder()
   *           .setResourceValueConfig(ResourceValueConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ResourceValueConfig response = securityCenterClient.updateResourceValueConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResourceValueConfig updateResourceValueConfig(
      UpdateResourceValueConfigRequest request) {
    return updateResourceValueConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing ResourceValueConfigs with new rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   UpdateResourceValueConfigRequest request =
   *       UpdateResourceValueConfigRequest.newBuilder()
   *           .setResourceValueConfig(ResourceValueConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ResourceValueConfig> future =
   *       securityCenterClient.updateResourceValueConfigCallable().futureCall(request);
   *   // Do something.
   *   ResourceValueConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateResourceValueConfigRequest, ResourceValueConfig>
      updateResourceValueConfigCallable() {
    return stub.updateResourceValueConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates security marks. For Finding Security marks, if no location is specified, finding is
   * assumed to be in global. Assets Security Marks can only be accessed through global endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   SecurityMarks securityMarks = SecurityMarks.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   SecurityMarks response = securityCenterClient.updateSecurityMarks(securityMarks, updateMask);
   * }
   * }</pre>
   *
   * @param securityMarks Required. The security marks resource to update.
   * @param updateMask The FieldMask to use when updating the security marks resource.
   *     <p>The field mask must not contain duplicate fields. If empty or set to "marks", all marks
   *     will be replaced. Individual marks can be updated using "marks.&lt;mark_key&gt;".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityMarks updateSecurityMarks(
      SecurityMarks securityMarks, FieldMask updateMask) {
    UpdateSecurityMarksRequest request =
        UpdateSecurityMarksRequest.newBuilder()
            .setSecurityMarks(securityMarks)
            .setUpdateMask(updateMask)
            .build();
    return updateSecurityMarks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates security marks. For Finding Security marks, if no location is specified, finding is
   * assumed to be in global. Assets Security Marks can only be accessed through global endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   UpdateSecurityMarksRequest request =
   *       UpdateSecurityMarksRequest.newBuilder()
   *           .setSecurityMarks(SecurityMarks.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   SecurityMarks response = securityCenterClient.updateSecurityMarks(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityMarks updateSecurityMarks(UpdateSecurityMarksRequest request) {
    return updateSecurityMarksCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates security marks. For Finding Security marks, if no location is specified, finding is
   * assumed to be in global. Assets Security Marks can only be accessed through global endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   UpdateSecurityMarksRequest request =
   *       UpdateSecurityMarksRequest.newBuilder()
   *           .setSecurityMarks(SecurityMarks.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<SecurityMarks> future =
   *       securityCenterClient.updateSecurityMarksCallable().futureCall(request);
   *   // Do something.
   *   SecurityMarks response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSecurityMarksRequest, SecurityMarks>
      updateSecurityMarksCallable() {
    return stub.updateSecurityMarksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   Source source = Source.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Source response = securityCenterClient.updateSource(source, updateMask);
   * }
   * }</pre>
   *
   * @param source Required. The source resource to update.
   * @param updateMask The FieldMask to use when updating the source resource.
   *     <p>If empty all mutable fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Source updateSource(Source source, FieldMask updateMask) {
    UpdateSourceRequest request =
        UpdateSourceRequest.newBuilder().setSource(source).setUpdateMask(updateMask).build();
    return updateSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   UpdateSourceRequest request =
   *       UpdateSourceRequest.newBuilder()
   *           .setSource(Source.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Source response = securityCenterClient.updateSource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Source updateSource(UpdateSourceRequest request) {
    return updateSourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
   *   UpdateSourceRequest request =
   *       UpdateSourceRequest.newBuilder()
   *           .setSource(Source.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Source> future = securityCenterClient.updateSourceCallable().futureCall(request);
   *   // Do something.
   *   Source response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSourceRequest, Source> updateSourceCallable() {
    return stub.updateSourceCallable();
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

  public static class GroupFindingsPagedResponse
      extends AbstractPagedListResponse<
          GroupFindingsRequest,
          GroupFindingsResponse,
          GroupResult,
          GroupFindingsPage,
          GroupFindingsFixedSizeCollection> {

    public static ApiFuture<GroupFindingsPagedResponse> createAsync(
        PageContext<GroupFindingsRequest, GroupFindingsResponse, GroupResult> context,
        ApiFuture<GroupFindingsResponse> futureResponse) {
      ApiFuture<GroupFindingsPage> futurePage =
          GroupFindingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new GroupFindingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private GroupFindingsPagedResponse(GroupFindingsPage page) {
      super(page, GroupFindingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class GroupFindingsPage
      extends AbstractPage<
          GroupFindingsRequest, GroupFindingsResponse, GroupResult, GroupFindingsPage> {

    private GroupFindingsPage(
        PageContext<GroupFindingsRequest, GroupFindingsResponse, GroupResult> context,
        GroupFindingsResponse response) {
      super(context, response);
    }

    private static GroupFindingsPage createEmptyPage() {
      return new GroupFindingsPage(null, null);
    }

    @Override
    protected GroupFindingsPage createPage(
        PageContext<GroupFindingsRequest, GroupFindingsResponse, GroupResult> context,
        GroupFindingsResponse response) {
      return new GroupFindingsPage(context, response);
    }

    @Override
    public ApiFuture<GroupFindingsPage> createPageAsync(
        PageContext<GroupFindingsRequest, GroupFindingsResponse, GroupResult> context,
        ApiFuture<GroupFindingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class GroupFindingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          GroupFindingsRequest,
          GroupFindingsResponse,
          GroupResult,
          GroupFindingsPage,
          GroupFindingsFixedSizeCollection> {

    private GroupFindingsFixedSizeCollection(List<GroupFindingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static GroupFindingsFixedSizeCollection createEmptyCollection() {
      return new GroupFindingsFixedSizeCollection(null, 0);
    }

    @Override
    protected GroupFindingsFixedSizeCollection createCollection(
        List<GroupFindingsPage> pages, int collectionSize) {
      return new GroupFindingsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAttackPathsPagedResponse
      extends AbstractPagedListResponse<
          ListAttackPathsRequest,
          ListAttackPathsResponse,
          AttackPath,
          ListAttackPathsPage,
          ListAttackPathsFixedSizeCollection> {

    public static ApiFuture<ListAttackPathsPagedResponse> createAsync(
        PageContext<ListAttackPathsRequest, ListAttackPathsResponse, AttackPath> context,
        ApiFuture<ListAttackPathsResponse> futureResponse) {
      ApiFuture<ListAttackPathsPage> futurePage =
          ListAttackPathsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAttackPathsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAttackPathsPagedResponse(ListAttackPathsPage page) {
      super(page, ListAttackPathsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAttackPathsPage
      extends AbstractPage<
          ListAttackPathsRequest, ListAttackPathsResponse, AttackPath, ListAttackPathsPage> {

    private ListAttackPathsPage(
        PageContext<ListAttackPathsRequest, ListAttackPathsResponse, AttackPath> context,
        ListAttackPathsResponse response) {
      super(context, response);
    }

    private static ListAttackPathsPage createEmptyPage() {
      return new ListAttackPathsPage(null, null);
    }

    @Override
    protected ListAttackPathsPage createPage(
        PageContext<ListAttackPathsRequest, ListAttackPathsResponse, AttackPath> context,
        ListAttackPathsResponse response) {
      return new ListAttackPathsPage(context, response);
    }

    @Override
    public ApiFuture<ListAttackPathsPage> createPageAsync(
        PageContext<ListAttackPathsRequest, ListAttackPathsResponse, AttackPath> context,
        ApiFuture<ListAttackPathsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAttackPathsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAttackPathsRequest,
          ListAttackPathsResponse,
          AttackPath,
          ListAttackPathsPage,
          ListAttackPathsFixedSizeCollection> {

    private ListAttackPathsFixedSizeCollection(
        List<ListAttackPathsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAttackPathsFixedSizeCollection createEmptyCollection() {
      return new ListAttackPathsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAttackPathsFixedSizeCollection createCollection(
        List<ListAttackPathsPage> pages, int collectionSize) {
      return new ListAttackPathsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBigQueryExportsPagedResponse
      extends AbstractPagedListResponse<
          ListBigQueryExportsRequest,
          ListBigQueryExportsResponse,
          BigQueryExport,
          ListBigQueryExportsPage,
          ListBigQueryExportsFixedSizeCollection> {

    public static ApiFuture<ListBigQueryExportsPagedResponse> createAsync(
        PageContext<ListBigQueryExportsRequest, ListBigQueryExportsResponse, BigQueryExport>
            context,
        ApiFuture<ListBigQueryExportsResponse> futureResponse) {
      ApiFuture<ListBigQueryExportsPage> futurePage =
          ListBigQueryExportsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBigQueryExportsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBigQueryExportsPagedResponse(ListBigQueryExportsPage page) {
      super(page, ListBigQueryExportsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBigQueryExportsPage
      extends AbstractPage<
          ListBigQueryExportsRequest,
          ListBigQueryExportsResponse,
          BigQueryExport,
          ListBigQueryExportsPage> {

    private ListBigQueryExportsPage(
        PageContext<ListBigQueryExportsRequest, ListBigQueryExportsResponse, BigQueryExport>
            context,
        ListBigQueryExportsResponse response) {
      super(context, response);
    }

    private static ListBigQueryExportsPage createEmptyPage() {
      return new ListBigQueryExportsPage(null, null);
    }

    @Override
    protected ListBigQueryExportsPage createPage(
        PageContext<ListBigQueryExportsRequest, ListBigQueryExportsResponse, BigQueryExport>
            context,
        ListBigQueryExportsResponse response) {
      return new ListBigQueryExportsPage(context, response);
    }

    @Override
    public ApiFuture<ListBigQueryExportsPage> createPageAsync(
        PageContext<ListBigQueryExportsRequest, ListBigQueryExportsResponse, BigQueryExport>
            context,
        ApiFuture<ListBigQueryExportsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBigQueryExportsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBigQueryExportsRequest,
          ListBigQueryExportsResponse,
          BigQueryExport,
          ListBigQueryExportsPage,
          ListBigQueryExportsFixedSizeCollection> {

    private ListBigQueryExportsFixedSizeCollection(
        List<ListBigQueryExportsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBigQueryExportsFixedSizeCollection createEmptyCollection() {
      return new ListBigQueryExportsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBigQueryExportsFixedSizeCollection createCollection(
        List<ListBigQueryExportsPage> pages, int collectionSize) {
      return new ListBigQueryExportsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListFindingsPagedResponse
      extends AbstractPagedListResponse<
          ListFindingsRequest,
          ListFindingsResponse,
          ListFindingsResponse.ListFindingsResult,
          ListFindingsPage,
          ListFindingsFixedSizeCollection> {

    public static ApiFuture<ListFindingsPagedResponse> createAsync(
        PageContext<
                ListFindingsRequest, ListFindingsResponse, ListFindingsResponse.ListFindingsResult>
            context,
        ApiFuture<ListFindingsResponse> futureResponse) {
      ApiFuture<ListFindingsPage> futurePage =
          ListFindingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListFindingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListFindingsPagedResponse(ListFindingsPage page) {
      super(page, ListFindingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFindingsPage
      extends AbstractPage<
          ListFindingsRequest,
          ListFindingsResponse,
          ListFindingsResponse.ListFindingsResult,
          ListFindingsPage> {

    private ListFindingsPage(
        PageContext<
                ListFindingsRequest, ListFindingsResponse, ListFindingsResponse.ListFindingsResult>
            context,
        ListFindingsResponse response) {
      super(context, response);
    }

    private static ListFindingsPage createEmptyPage() {
      return new ListFindingsPage(null, null);
    }

    @Override
    protected ListFindingsPage createPage(
        PageContext<
                ListFindingsRequest, ListFindingsResponse, ListFindingsResponse.ListFindingsResult>
            context,
        ListFindingsResponse response) {
      return new ListFindingsPage(context, response);
    }

    @Override
    public ApiFuture<ListFindingsPage> createPageAsync(
        PageContext<
                ListFindingsRequest, ListFindingsResponse, ListFindingsResponse.ListFindingsResult>
            context,
        ApiFuture<ListFindingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFindingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFindingsRequest,
          ListFindingsResponse,
          ListFindingsResponse.ListFindingsResult,
          ListFindingsPage,
          ListFindingsFixedSizeCollection> {

    private ListFindingsFixedSizeCollection(List<ListFindingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFindingsFixedSizeCollection createEmptyCollection() {
      return new ListFindingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFindingsFixedSizeCollection createCollection(
        List<ListFindingsPage> pages, int collectionSize) {
      return new ListFindingsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMuteConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListMuteConfigsRequest,
          ListMuteConfigsResponse,
          MuteConfig,
          ListMuteConfigsPage,
          ListMuteConfigsFixedSizeCollection> {

    public static ApiFuture<ListMuteConfigsPagedResponse> createAsync(
        PageContext<ListMuteConfigsRequest, ListMuteConfigsResponse, MuteConfig> context,
        ApiFuture<ListMuteConfigsResponse> futureResponse) {
      ApiFuture<ListMuteConfigsPage> futurePage =
          ListMuteConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMuteConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMuteConfigsPagedResponse(ListMuteConfigsPage page) {
      super(page, ListMuteConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMuteConfigsPage
      extends AbstractPage<
          ListMuteConfigsRequest, ListMuteConfigsResponse, MuteConfig, ListMuteConfigsPage> {

    private ListMuteConfigsPage(
        PageContext<ListMuteConfigsRequest, ListMuteConfigsResponse, MuteConfig> context,
        ListMuteConfigsResponse response) {
      super(context, response);
    }

    private static ListMuteConfigsPage createEmptyPage() {
      return new ListMuteConfigsPage(null, null);
    }

    @Override
    protected ListMuteConfigsPage createPage(
        PageContext<ListMuteConfigsRequest, ListMuteConfigsResponse, MuteConfig> context,
        ListMuteConfigsResponse response) {
      return new ListMuteConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListMuteConfigsPage> createPageAsync(
        PageContext<ListMuteConfigsRequest, ListMuteConfigsResponse, MuteConfig> context,
        ApiFuture<ListMuteConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMuteConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMuteConfigsRequest,
          ListMuteConfigsResponse,
          MuteConfig,
          ListMuteConfigsPage,
          ListMuteConfigsFixedSizeCollection> {

    private ListMuteConfigsFixedSizeCollection(
        List<ListMuteConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMuteConfigsFixedSizeCollection createEmptyCollection() {
      return new ListMuteConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMuteConfigsFixedSizeCollection createCollection(
        List<ListMuteConfigsPage> pages, int collectionSize) {
      return new ListMuteConfigsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNotificationConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListNotificationConfigsRequest,
          ListNotificationConfigsResponse,
          NotificationConfig,
          ListNotificationConfigsPage,
          ListNotificationConfigsFixedSizeCollection> {

    public static ApiFuture<ListNotificationConfigsPagedResponse> createAsync(
        PageContext<
                ListNotificationConfigsRequest, ListNotificationConfigsResponse, NotificationConfig>
            context,
        ApiFuture<ListNotificationConfigsResponse> futureResponse) {
      ApiFuture<ListNotificationConfigsPage> futurePage =
          ListNotificationConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListNotificationConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListNotificationConfigsPagedResponse(ListNotificationConfigsPage page) {
      super(page, ListNotificationConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNotificationConfigsPage
      extends AbstractPage<
          ListNotificationConfigsRequest,
          ListNotificationConfigsResponse,
          NotificationConfig,
          ListNotificationConfigsPage> {

    private ListNotificationConfigsPage(
        PageContext<
                ListNotificationConfigsRequest, ListNotificationConfigsResponse, NotificationConfig>
            context,
        ListNotificationConfigsResponse response) {
      super(context, response);
    }

    private static ListNotificationConfigsPage createEmptyPage() {
      return new ListNotificationConfigsPage(null, null);
    }

    @Override
    protected ListNotificationConfigsPage createPage(
        PageContext<
                ListNotificationConfigsRequest, ListNotificationConfigsResponse, NotificationConfig>
            context,
        ListNotificationConfigsResponse response) {
      return new ListNotificationConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListNotificationConfigsPage> createPageAsync(
        PageContext<
                ListNotificationConfigsRequest, ListNotificationConfigsResponse, NotificationConfig>
            context,
        ApiFuture<ListNotificationConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNotificationConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNotificationConfigsRequest,
          ListNotificationConfigsResponse,
          NotificationConfig,
          ListNotificationConfigsPage,
          ListNotificationConfigsFixedSizeCollection> {

    private ListNotificationConfigsFixedSizeCollection(
        List<ListNotificationConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNotificationConfigsFixedSizeCollection createEmptyCollection() {
      return new ListNotificationConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNotificationConfigsFixedSizeCollection createCollection(
        List<ListNotificationConfigsPage> pages, int collectionSize) {
      return new ListNotificationConfigsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListResourceValueConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListResourceValueConfigsRequest,
          ListResourceValueConfigsResponse,
          ResourceValueConfig,
          ListResourceValueConfigsPage,
          ListResourceValueConfigsFixedSizeCollection> {

    public static ApiFuture<ListResourceValueConfigsPagedResponse> createAsync(
        PageContext<
                ListResourceValueConfigsRequest,
                ListResourceValueConfigsResponse,
                ResourceValueConfig>
            context,
        ApiFuture<ListResourceValueConfigsResponse> futureResponse) {
      ApiFuture<ListResourceValueConfigsPage> futurePage =
          ListResourceValueConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListResourceValueConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListResourceValueConfigsPagedResponse(ListResourceValueConfigsPage page) {
      super(page, ListResourceValueConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListResourceValueConfigsPage
      extends AbstractPage<
          ListResourceValueConfigsRequest,
          ListResourceValueConfigsResponse,
          ResourceValueConfig,
          ListResourceValueConfigsPage> {

    private ListResourceValueConfigsPage(
        PageContext<
                ListResourceValueConfigsRequest,
                ListResourceValueConfigsResponse,
                ResourceValueConfig>
            context,
        ListResourceValueConfigsResponse response) {
      super(context, response);
    }

    private static ListResourceValueConfigsPage createEmptyPage() {
      return new ListResourceValueConfigsPage(null, null);
    }

    @Override
    protected ListResourceValueConfigsPage createPage(
        PageContext<
                ListResourceValueConfigsRequest,
                ListResourceValueConfigsResponse,
                ResourceValueConfig>
            context,
        ListResourceValueConfigsResponse response) {
      return new ListResourceValueConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListResourceValueConfigsPage> createPageAsync(
        PageContext<
                ListResourceValueConfigsRequest,
                ListResourceValueConfigsResponse,
                ResourceValueConfig>
            context,
        ApiFuture<ListResourceValueConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListResourceValueConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListResourceValueConfigsRequest,
          ListResourceValueConfigsResponse,
          ResourceValueConfig,
          ListResourceValueConfigsPage,
          ListResourceValueConfigsFixedSizeCollection> {

    private ListResourceValueConfigsFixedSizeCollection(
        List<ListResourceValueConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListResourceValueConfigsFixedSizeCollection createEmptyCollection() {
      return new ListResourceValueConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListResourceValueConfigsFixedSizeCollection createCollection(
        List<ListResourceValueConfigsPage> pages, int collectionSize) {
      return new ListResourceValueConfigsFixedSizeCollection(pages, collectionSize);
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

  public static class ListValuedResourcesPagedResponse
      extends AbstractPagedListResponse<
          ListValuedResourcesRequest,
          ListValuedResourcesResponse,
          ValuedResource,
          ListValuedResourcesPage,
          ListValuedResourcesFixedSizeCollection> {

    public static ApiFuture<ListValuedResourcesPagedResponse> createAsync(
        PageContext<ListValuedResourcesRequest, ListValuedResourcesResponse, ValuedResource>
            context,
        ApiFuture<ListValuedResourcesResponse> futureResponse) {
      ApiFuture<ListValuedResourcesPage> futurePage =
          ListValuedResourcesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListValuedResourcesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListValuedResourcesPagedResponse(ListValuedResourcesPage page) {
      super(page, ListValuedResourcesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListValuedResourcesPage
      extends AbstractPage<
          ListValuedResourcesRequest,
          ListValuedResourcesResponse,
          ValuedResource,
          ListValuedResourcesPage> {

    private ListValuedResourcesPage(
        PageContext<ListValuedResourcesRequest, ListValuedResourcesResponse, ValuedResource>
            context,
        ListValuedResourcesResponse response) {
      super(context, response);
    }

    private static ListValuedResourcesPage createEmptyPage() {
      return new ListValuedResourcesPage(null, null);
    }

    @Override
    protected ListValuedResourcesPage createPage(
        PageContext<ListValuedResourcesRequest, ListValuedResourcesResponse, ValuedResource>
            context,
        ListValuedResourcesResponse response) {
      return new ListValuedResourcesPage(context, response);
    }

    @Override
    public ApiFuture<ListValuedResourcesPage> createPageAsync(
        PageContext<ListValuedResourcesRequest, ListValuedResourcesResponse, ValuedResource>
            context,
        ApiFuture<ListValuedResourcesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListValuedResourcesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListValuedResourcesRequest,
          ListValuedResourcesResponse,
          ValuedResource,
          ListValuedResourcesPage,
          ListValuedResourcesFixedSizeCollection> {

    private ListValuedResourcesFixedSizeCollection(
        List<ListValuedResourcesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListValuedResourcesFixedSizeCollection createEmptyCollection() {
      return new ListValuedResourcesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListValuedResourcesFixedSizeCollection createCollection(
        List<ListValuedResourcesPage> pages, int collectionSize) {
      return new ListValuedResourcesFixedSizeCollection(pages, collectionSize);
    }
  }
}
