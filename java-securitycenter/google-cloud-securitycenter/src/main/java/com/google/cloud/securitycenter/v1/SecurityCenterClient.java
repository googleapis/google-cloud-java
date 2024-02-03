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

package com.google.cloud.securitycenter.v1;

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
import com.google.cloud.securitycenter.v1.stub.SecurityCenterStub;
import com.google.cloud.securitycenter.v1.stub.SecurityCenterStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: V1 APIs for Security Center service.
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
 *   SecurityHealthAnalyticsSettingsName parent =
 *       SecurityHealthAnalyticsSettingsName.ofOrganizationName("[ORGANIZATION]");
 *   SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule =
 *       SecurityHealthAnalyticsCustomModule.newBuilder().build();
 *   SecurityHealthAnalyticsCustomModule response =
 *       securityCenterClient.createSecurityHealthAnalyticsCustomModule(
 *           parent, securityHealthAnalyticsCustomModule);
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
 *      <td><p> BulkMuteFindings</td>
 *      <td><p> Kicks off an LRO to bulk mute findings for a parent based on a filter. The parent can be either an organization, folder or project. The findings matched by the filter will be muted after the LRO is done.</td>
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
 *      <td><p> CreateSecurityHealthAnalyticsCustomModule</td>
 *      <td><p> Creates a resident SecurityHealthAnalyticsCustomModule at the scope of the given CRM parent, and also creates inherited SecurityHealthAnalyticsCustomModules for all CRM descendants of the given parent. These modules are enabled by default.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSecurityHealthAnalyticsCustomModule(CreateSecurityHealthAnalyticsCustomModuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSecurityHealthAnalyticsCustomModule(SecurityHealthAnalyticsSettingsName parent, SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule)
 *           <li><p> createSecurityHealthAnalyticsCustomModule(String parent, SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSecurityHealthAnalyticsCustomModuleCallable()
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
 *      <td><p> CreateFinding</td>
 *      <td><p> Creates a finding. The corresponding source must exist for finding creation to succeed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createFinding(CreateFindingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createFinding(SourceName parent, String findingId, Finding finding)
 *           <li><p> createFinding(String parent, String findingId, Finding finding)
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
 *           <li><p> createMuteConfig(FolderName parent, MuteConfig muteConfig)
 *           <li><p> createMuteConfig(OrganizationName parent, MuteConfig muteConfig)
 *           <li><p> createMuteConfig(ProjectName parent, MuteConfig muteConfig)
 *           <li><p> createMuteConfig(String parent, MuteConfig muteConfig)
 *           <li><p> createMuteConfig(FolderName parent, MuteConfig muteConfig, String muteConfigId)
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
 *           <li><p> createNotificationConfig(FolderName parent, NotificationConfig notificationConfig)
 *           <li><p> createNotificationConfig(OrganizationName parent, NotificationConfig notificationConfig)
 *           <li><p> createNotificationConfig(ProjectName parent, NotificationConfig notificationConfig)
 *           <li><p> createNotificationConfig(String parent, NotificationConfig notificationConfig)
 *           <li><p> createNotificationConfig(FolderName parent, String configId, NotificationConfig notificationConfig)
 *           <li><p> createNotificationConfig(OrganizationName parent, String configId, NotificationConfig notificationConfig)
 *           <li><p> createNotificationConfig(ProjectName parent, String configId, NotificationConfig notificationConfig)
 *           <li><p> createNotificationConfig(String parent, String configId, NotificationConfig notificationConfig)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createNotificationConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteMuteConfig</td>
 *      <td><p> Deletes an existing mute config.</td>
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
 *      <td><p> DeleteSecurityHealthAnalyticsCustomModule</td>
 *      <td><p> Deletes the specified SecurityHealthAnalyticsCustomModule and all of its descendants in the CRM hierarchy. This method is only supported for resident custom modules.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSecurityHealthAnalyticsCustomModule(DeleteSecurityHealthAnalyticsCustomModuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteSecurityHealthAnalyticsCustomModule(SecurityHealthAnalyticsCustomModuleName name)
 *           <li><p> deleteSecurityHealthAnalyticsCustomModule(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSecurityHealthAnalyticsCustomModuleCallable()
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
 *      <td><p> Gets a mute config.</td>
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
 *      <td><p> GetOrganizationSettings</td>
 *      <td><p> Gets the settings for an organization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getOrganizationSettings(GetOrganizationSettingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getOrganizationSettings(OrganizationSettingsName name)
 *           <li><p> getOrganizationSettings(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getOrganizationSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEffectiveSecurityHealthAnalyticsCustomModule</td>
 *      <td><p> Retrieves an EffectiveSecurityHealthAnalyticsCustomModule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEffectiveSecurityHealthAnalyticsCustomModule(GetEffectiveSecurityHealthAnalyticsCustomModuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEffectiveSecurityHealthAnalyticsCustomModule(EffectiveSecurityHealthAnalyticsCustomModuleName name)
 *           <li><p> getEffectiveSecurityHealthAnalyticsCustomModule(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEffectiveSecurityHealthAnalyticsCustomModuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSecurityHealthAnalyticsCustomModule</td>
 *      <td><p> Retrieves a SecurityHealthAnalyticsCustomModule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSecurityHealthAnalyticsCustomModule(GetSecurityHealthAnalyticsCustomModuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSecurityHealthAnalyticsCustomModule(SecurityHealthAnalyticsCustomModuleName name)
 *           <li><p> getSecurityHealthAnalyticsCustomModule(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSecurityHealthAnalyticsCustomModuleCallable()
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
 *      <td><p> GroupAssets</td>
 *      <td><p> Filters an organization's assets and  groups them by their specified properties.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> groupAssets(GroupAssetsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> groupAssetsPagedCallable()
 *           <li><p> groupAssetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GroupFindings</td>
 *      <td><p> Filters an organization or source's findings and  groups them by their specified properties.
 * <p>  To group across all sources provide a `-` as the source id. Example: /v1/organizations/{organization_id}/sources/-/findings, /v1/folders/{folder_id}/sources/-/findings, /v1/projects/{project_id}/sources/-/findings</td>
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
 *      <td><p> ListAssets</td>
 *      <td><p> Lists an organization's assets.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAssets(ListAssetsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAssetsPagedCallable()
 *           <li><p> listAssetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDescendantSecurityHealthAnalyticsCustomModules</td>
 *      <td><p> Returns a list of all resident SecurityHealthAnalyticsCustomModules under the given CRM parent and all of the parent’s CRM descendants.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDescendantSecurityHealthAnalyticsCustomModules(ListDescendantSecurityHealthAnalyticsCustomModulesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDescendantSecurityHealthAnalyticsCustomModules(SecurityHealthAnalyticsSettingsName parent)
 *           <li><p> listDescendantSecurityHealthAnalyticsCustomModules(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDescendantSecurityHealthAnalyticsCustomModulesPagedCallable()
 *           <li><p> listDescendantSecurityHealthAnalyticsCustomModulesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListFindings</td>
 *      <td><p> Lists an organization or source's findings.
 * <p>  To list across all sources provide a `-` as the source id. Example: /v1/organizations/{organization_id}/sources/-/findings</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listFindings(ListFindingsRequest request)
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
 *      <td><p> Lists mute configs.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMuteConfigs(ListMuteConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMuteConfigs(FolderName parent)
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
 *           <li><p> listNotificationConfigs(FolderName parent)
 *           <li><p> listNotificationConfigs(OrganizationName parent)
 *           <li><p> listNotificationConfigs(ProjectName parent)
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
 *      <td><p> ListEffectiveSecurityHealthAnalyticsCustomModules</td>
 *      <td><p> Returns a list of all EffectiveSecurityHealthAnalyticsCustomModules for the given parent. This includes resident modules defined at the scope of the parent, and inherited modules, inherited from CRM ancestors.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEffectiveSecurityHealthAnalyticsCustomModules(ListEffectiveSecurityHealthAnalyticsCustomModulesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEffectiveSecurityHealthAnalyticsCustomModules(SecurityHealthAnalyticsSettingsName parent)
 *           <li><p> listEffectiveSecurityHealthAnalyticsCustomModules(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEffectiveSecurityHealthAnalyticsCustomModulesPagedCallable()
 *           <li><p> listEffectiveSecurityHealthAnalyticsCustomModulesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSecurityHealthAnalyticsCustomModules</td>
 *      <td><p> Returns a list of all SecurityHealthAnalyticsCustomModules for the given parent. This includes resident modules defined at the scope of the parent, and inherited modules, inherited from CRM ancestors.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSecurityHealthAnalyticsCustomModules(ListSecurityHealthAnalyticsCustomModulesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSecurityHealthAnalyticsCustomModules(SecurityHealthAnalyticsSettingsName parent)
 *           <li><p> listSecurityHealthAnalyticsCustomModules(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSecurityHealthAnalyticsCustomModulesPagedCallable()
 *           <li><p> listSecurityHealthAnalyticsCustomModulesCallable()
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
 *      <td><p> RunAssetDiscovery</td>
 *      <td><p> Runs asset discovery. The discovery is tracked with a long-running operation.
 * <p>  This API can only be called with limited frequency for an organization. If it is called too frequently the caller will receive a TOO_MANY_REQUESTS error.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> runAssetDiscoveryAsync(RunAssetDiscoveryRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> runAssetDiscoveryAsync(OrganizationName parent)
 *           <li><p> runAssetDiscoveryAsync(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> runAssetDiscoveryOperationCallable()
 *           <li><p> runAssetDiscoveryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetFindingState</td>
 *      <td><p> Updates the state of a finding.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setFindingState(SetFindingStateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> setFindingState(FindingName name, Finding.State state, Timestamp startTime)
 *           <li><p> setFindingState(String name, Finding.State state, Timestamp startTime)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setFindingStateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetMute</td>
 *      <td><p> Updates the mute state of a finding.</td>
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
 *      <td><p> SimulateSecurityHealthAnalyticsCustomModule</td>
 *      <td><p> Simulates a given SecurityHealthAnalyticsCustomModule and Resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> simulateSecurityHealthAnalyticsCustomModule(SimulateSecurityHealthAnalyticsCustomModuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> simulateSecurityHealthAnalyticsCustomModule(String parent, CustomConfig customConfig, SimulateSecurityHealthAnalyticsCustomModuleRequest.SimulatedResource resource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> simulateSecurityHealthAnalyticsCustomModuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateExternalSystem</td>
 *      <td><p> Updates external system. This is for a given finding.</td>
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
 *      <td><p> Creates or updates a finding. The corresponding source must exist for a finding creation to succeed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateFinding(UpdateFindingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateFinding(Finding finding)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateFindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateMuteConfig</td>
 *      <td><p> Updates a mute config.</td>
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
 *           <li><p> updateNotificationConfig(NotificationConfig notificationConfig)
 *           <li><p> updateNotificationConfig(NotificationConfig notificationConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateNotificationConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateOrganizationSettings</td>
 *      <td><p> Updates an organization's settings.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateOrganizationSettings(UpdateOrganizationSettingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateOrganizationSettings(OrganizationSettings organizationSettings)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateOrganizationSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSecurityHealthAnalyticsCustomModule</td>
 *      <td><p> Updates the SecurityHealthAnalyticsCustomModule under the given name based on the given update mask. Updating the enablement state is supported on both resident and inherited modules (though resident modules cannot have an enablement state of "inherited"). Updating the display name and custom config of a module is supported on resident modules only.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSecurityHealthAnalyticsCustomModule(UpdateSecurityHealthAnalyticsCustomModuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSecurityHealthAnalyticsCustomModule(SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSecurityHealthAnalyticsCustomModuleCallable()
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
 *           <li><p> updateSource(Source source)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSecurityMarks</td>
 *      <td><p> Updates security marks.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSecurityMarks(UpdateSecurityMarksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSecurityMarks(SecurityMarks securityMarks)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSecurityMarksCallable()
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
 *           <li><p> createBigQueryExport(FolderName parent, BigQueryExport bigQueryExport, String bigQueryExportId)
 *           <li><p> createBigQueryExport(OrganizationName parent, BigQueryExport bigQueryExport, String bigQueryExportId)
 *           <li><p> createBigQueryExport(ProjectName parent, BigQueryExport bigQueryExport, String bigQueryExportId)
 *           <li><p> createBigQueryExport(String parent, BigQueryExport bigQueryExport, String bigQueryExportId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createBigQueryExportCallable()
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
 *      <td><p> ListBigQueryExports</td>
 *      <td><p> Lists BigQuery exports. Note that when requesting BigQuery exports at a given level all exports under that level are also returned e.g. if requesting BigQuery exports under a folder, then all BigQuery exports immediately under the folder plus the ones created under the projects within the folder are returned.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBigQueryExports(ListBigQueryExportsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBigQueryExports(FolderName parent)
 *           <li><p> listBigQueryExports(OrganizationName parent)
 *           <li><p> listBigQueryExports(ProjectName parent)
 *           <li><p> listBigQueryExports(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBigQueryExportsPagedCallable()
 *           <li><p> listBigQueryExportsCallable()
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
   * Kicks off an LRO to bulk mute findings for a parent based on a filter. The parent can be either
   * an organization, folder or project. The findings matched by the filter will be muted after the
   * LRO is done.
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
   * @param parent Required. The parent, at which bulk action needs to be applied. Its format is
   *     "organizations/[organization_id]", "folders/[folder_id]", "projects/[project_id]".
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
   * Kicks off an LRO to bulk mute findings for a parent based on a filter. The parent can be either
   * an organization, folder or project. The findings matched by the filter will be muted after the
   * LRO is done.
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
   * @param parent Required. The parent, at which bulk action needs to be applied. Its format is
   *     "organizations/[organization_id]", "folders/[folder_id]", "projects/[project_id]".
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
   * Kicks off an LRO to bulk mute findings for a parent based on a filter. The parent can be either
   * an organization, folder or project. The findings matched by the filter will be muted after the
   * LRO is done.
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
   *           .setMuteAnnotation("muteAnnotation-2111042008")
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
   * Kicks off an LRO to bulk mute findings for a parent based on a filter. The parent can be either
   * an organization, folder or project. The findings matched by the filter will be muted after the
   * LRO is done.
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
   *           .setMuteAnnotation("muteAnnotation-2111042008")
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
   * Kicks off an LRO to bulk mute findings for a parent based on a filter. The parent can be either
   * an organization, folder or project. The findings matched by the filter will be muted after the
   * LRO is done.
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
   *           .setMuteAnnotation("muteAnnotation-2111042008")
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
   * Creates a resident SecurityHealthAnalyticsCustomModule at the scope of the given CRM parent,
   * and also creates inherited SecurityHealthAnalyticsCustomModules for all CRM descendants of the
   * given parent. These modules are enabled by default.
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
   *   SecurityHealthAnalyticsSettingsName parent =
   *       SecurityHealthAnalyticsSettingsName.ofOrganizationName("[ORGANIZATION]");
   *   SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule =
   *       SecurityHealthAnalyticsCustomModule.newBuilder().build();
   *   SecurityHealthAnalyticsCustomModule response =
   *       securityCenterClient.createSecurityHealthAnalyticsCustomModule(
   *           parent, securityHealthAnalyticsCustomModule);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new custom module's parent. Its format is
   *     "organizations/{organization}/securityHealthAnalyticsSettings",
   *     "folders/{folder}/securityHealthAnalyticsSettings", or
   *     "projects/{project}/securityHealthAnalyticsSettings"
   * @param securityHealthAnalyticsCustomModule Required. SecurityHealthAnalytics custom module to
   *     create. The provided name is ignored and reset with provided parent information and
   *     server-generated ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityHealthAnalyticsCustomModule createSecurityHealthAnalyticsCustomModule(
      SecurityHealthAnalyticsSettingsName parent,
      SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule) {
    CreateSecurityHealthAnalyticsCustomModuleRequest request =
        CreateSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSecurityHealthAnalyticsCustomModule(securityHealthAnalyticsCustomModule)
            .build();
    return createSecurityHealthAnalyticsCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a resident SecurityHealthAnalyticsCustomModule at the scope of the given CRM parent,
   * and also creates inherited SecurityHealthAnalyticsCustomModules for all CRM descendants of the
   * given parent. These modules are enabled by default.
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
   *       SecurityHealthAnalyticsSettingsName.ofOrganizationName("[ORGANIZATION]").toString();
   *   SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule =
   *       SecurityHealthAnalyticsCustomModule.newBuilder().build();
   *   SecurityHealthAnalyticsCustomModule response =
   *       securityCenterClient.createSecurityHealthAnalyticsCustomModule(
   *           parent, securityHealthAnalyticsCustomModule);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new custom module's parent. Its format is
   *     "organizations/{organization}/securityHealthAnalyticsSettings",
   *     "folders/{folder}/securityHealthAnalyticsSettings", or
   *     "projects/{project}/securityHealthAnalyticsSettings"
   * @param securityHealthAnalyticsCustomModule Required. SecurityHealthAnalytics custom module to
   *     create. The provided name is ignored and reset with provided parent information and
   *     server-generated ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityHealthAnalyticsCustomModule createSecurityHealthAnalyticsCustomModule(
      String parent, SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule) {
    CreateSecurityHealthAnalyticsCustomModuleRequest request =
        CreateSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
            .setParent(parent)
            .setSecurityHealthAnalyticsCustomModule(securityHealthAnalyticsCustomModule)
            .build();
    return createSecurityHealthAnalyticsCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a resident SecurityHealthAnalyticsCustomModule at the scope of the given CRM parent,
   * and also creates inherited SecurityHealthAnalyticsCustomModules for all CRM descendants of the
   * given parent. These modules are enabled by default.
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
   *   CreateSecurityHealthAnalyticsCustomModuleRequest request =
   *       CreateSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
   *           .setParent(
   *               SecurityHealthAnalyticsSettingsName.ofOrganizationName("[ORGANIZATION]")
   *                   .toString())
   *           .setSecurityHealthAnalyticsCustomModule(
   *               SecurityHealthAnalyticsCustomModule.newBuilder().build())
   *           .build();
   *   SecurityHealthAnalyticsCustomModule response =
   *       securityCenterClient.createSecurityHealthAnalyticsCustomModule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityHealthAnalyticsCustomModule createSecurityHealthAnalyticsCustomModule(
      CreateSecurityHealthAnalyticsCustomModuleRequest request) {
    return createSecurityHealthAnalyticsCustomModuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a resident SecurityHealthAnalyticsCustomModule at the scope of the given CRM parent,
   * and also creates inherited SecurityHealthAnalyticsCustomModules for all CRM descendants of the
   * given parent. These modules are enabled by default.
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
   *   CreateSecurityHealthAnalyticsCustomModuleRequest request =
   *       CreateSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
   *           .setParent(
   *               SecurityHealthAnalyticsSettingsName.ofOrganizationName("[ORGANIZATION]")
   *                   .toString())
   *           .setSecurityHealthAnalyticsCustomModule(
   *               SecurityHealthAnalyticsCustomModule.newBuilder().build())
   *           .build();
   *   ApiFuture<SecurityHealthAnalyticsCustomModule> future =
   *       securityCenterClient
   *           .createSecurityHealthAnalyticsCustomModuleCallable()
   *           .futureCall(request);
   *   // Do something.
   *   SecurityHealthAnalyticsCustomModule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          CreateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      createSecurityHealthAnalyticsCustomModuleCallable() {
    return stub.createSecurityHealthAnalyticsCustomModuleCallable();
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
   * Creates a finding. The corresponding source must exist for finding creation to succeed.
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
   *   String findingId = "findingId439150212";
   *   Finding finding = Finding.newBuilder().build();
   *   Finding response = securityCenterClient.createFinding(parent, findingId, finding);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new finding's parent. Its format should be
   *     "organizations/[organization_id]/sources/[source_id]".
   * @param findingId Required. Unique identifier provided by the client within the parent scope. It
   *     must be alphanumeric and less than or equal to 32 characters and greater than 0 characters
   *     in length.
   * @param finding Required. The Finding being created. The name and security_marks will be ignored
   *     as they are both output only fields on this resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Finding createFinding(SourceName parent, String findingId, Finding finding) {
    CreateFindingRequest request =
        CreateFindingRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFindingId(findingId)
            .setFinding(finding)
            .build();
    return createFinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a finding. The corresponding source must exist for finding creation to succeed.
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
   *   String findingId = "findingId439150212";
   *   Finding finding = Finding.newBuilder().build();
   *   Finding response = securityCenterClient.createFinding(parent, findingId, finding);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new finding's parent. Its format should be
   *     "organizations/[organization_id]/sources/[source_id]".
   * @param findingId Required. Unique identifier provided by the client within the parent scope. It
   *     must be alphanumeric and less than or equal to 32 characters and greater than 0 characters
   *     in length.
   * @param finding Required. The Finding being created. The name and security_marks will be ignored
   *     as they are both output only fields on this resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Finding createFinding(String parent, String findingId, Finding finding) {
    CreateFindingRequest request =
        CreateFindingRequest.newBuilder()
            .setParent(parent)
            .setFindingId(findingId)
            .setFinding(finding)
            .build();
    return createFinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a finding. The corresponding source must exist for finding creation to succeed.
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
   * Creates a finding. The corresponding source must exist for finding creation to succeed.
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
   *   FolderName parent = FolderName.of("[FOLDER]");
   *   MuteConfig muteConfig = MuteConfig.newBuilder().build();
   *   MuteConfig response = securityCenterClient.createMuteConfig(parent, muteConfig);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new mute configs's parent. Its format is
   *     "organizations/[organization_id]", "folders/[folder_id]", or "projects/[project_id]".
   * @param muteConfig Required. The mute config being created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MuteConfig createMuteConfig(FolderName parent, MuteConfig muteConfig) {
    CreateMuteConfigRequest request =
        CreateMuteConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMuteConfig(muteConfig)
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
   *   MuteConfig response = securityCenterClient.createMuteConfig(parent, muteConfig);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new mute configs's parent. Its format is
   *     "organizations/[organization_id]", "folders/[folder_id]", or "projects/[project_id]".
   * @param muteConfig Required. The mute config being created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MuteConfig createMuteConfig(OrganizationName parent, MuteConfig muteConfig) {
    CreateMuteConfigRequest request =
        CreateMuteConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMuteConfig(muteConfig)
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
   *   MuteConfig response = securityCenterClient.createMuteConfig(parent, muteConfig);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new mute configs's parent. Its format is
   *     "organizations/[organization_id]", "folders/[folder_id]", or "projects/[project_id]".
   * @param muteConfig Required. The mute config being created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MuteConfig createMuteConfig(ProjectName parent, MuteConfig muteConfig) {
    CreateMuteConfigRequest request =
        CreateMuteConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMuteConfig(muteConfig)
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
   *   MuteConfig response = securityCenterClient.createMuteConfig(parent, muteConfig);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new mute configs's parent. Its format is
   *     "organizations/[organization_id]", "folders/[folder_id]", or "projects/[project_id]".
   * @param muteConfig Required. The mute config being created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MuteConfig createMuteConfig(String parent, MuteConfig muteConfig) {
    CreateMuteConfigRequest request =
        CreateMuteConfigRequest.newBuilder().setParent(parent).setMuteConfig(muteConfig).build();
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
   *     "organizations/[organization_id]", "folders/[folder_id]", or "projects/[project_id]".
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
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   MuteConfig muteConfig = MuteConfig.newBuilder().build();
   *   String muteConfigId = "muteConfigId1689669942";
   *   MuteConfig response = securityCenterClient.createMuteConfig(parent, muteConfig, muteConfigId);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new mute configs's parent. Its format is
   *     "organizations/[organization_id]", "folders/[folder_id]", or "projects/[project_id]".
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
   *     "organizations/[organization_id]", "folders/[folder_id]", or "projects/[project_id]".
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
   *     "organizations/[organization_id]", "folders/[folder_id]", or "projects/[project_id]".
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
   *   FolderName parent = FolderName.of("[FOLDER]");
   *   NotificationConfig notificationConfig = NotificationConfig.newBuilder().build();
   *   NotificationConfig response =
   *       securityCenterClient.createNotificationConfig(parent, notificationConfig);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new notification config's parent. Its format is
   *     "organizations/[organization_id]", "folders/[folder_id]", or "projects/[project_id]".
   * @param notificationConfig Required. The notification config being created. The name and the
   *     service account will be ignored as they are both output only fields on this resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationConfig createNotificationConfig(
      FolderName parent, NotificationConfig notificationConfig) {
    CreateNotificationConfigRequest request =
        CreateNotificationConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setNotificationConfig(notificationConfig)
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
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   NotificationConfig notificationConfig = NotificationConfig.newBuilder().build();
   *   NotificationConfig response =
   *       securityCenterClient.createNotificationConfig(parent, notificationConfig);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new notification config's parent. Its format is
   *     "organizations/[organization_id]", "folders/[folder_id]", or "projects/[project_id]".
   * @param notificationConfig Required. The notification config being created. The name and the
   *     service account will be ignored as they are both output only fields on this resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationConfig createNotificationConfig(
      OrganizationName parent, NotificationConfig notificationConfig) {
    CreateNotificationConfigRequest request =
        CreateNotificationConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setNotificationConfig(notificationConfig)
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
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   NotificationConfig notificationConfig = NotificationConfig.newBuilder().build();
   *   NotificationConfig response =
   *       securityCenterClient.createNotificationConfig(parent, notificationConfig);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new notification config's parent. Its format is
   *     "organizations/[organization_id]", "folders/[folder_id]", or "projects/[project_id]".
   * @param notificationConfig Required. The notification config being created. The name and the
   *     service account will be ignored as they are both output only fields on this resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationConfig createNotificationConfig(
      ProjectName parent, NotificationConfig notificationConfig) {
    CreateNotificationConfigRequest request =
        CreateNotificationConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setNotificationConfig(notificationConfig)
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
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   NotificationConfig notificationConfig = NotificationConfig.newBuilder().build();
   *   NotificationConfig response =
   *       securityCenterClient.createNotificationConfig(parent, notificationConfig);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new notification config's parent. Its format is
   *     "organizations/[organization_id]", "folders/[folder_id]", or "projects/[project_id]".
   * @param notificationConfig Required. The notification config being created. The name and the
   *     service account will be ignored as they are both output only fields on this resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationConfig createNotificationConfig(
      String parent, NotificationConfig notificationConfig) {
    CreateNotificationConfigRequest request =
        CreateNotificationConfigRequest.newBuilder()
            .setParent(parent)
            .setNotificationConfig(notificationConfig)
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
   *   FolderName parent = FolderName.of("[FOLDER]");
   *   String configId = "configId-580140035";
   *   NotificationConfig notificationConfig = NotificationConfig.newBuilder().build();
   *   NotificationConfig response =
   *       securityCenterClient.createNotificationConfig(parent, configId, notificationConfig);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new notification config's parent. Its format is
   *     "organizations/[organization_id]", "folders/[folder_id]", or "projects/[project_id]".
   * @param configId Required. Unique identifier provided by the client within the parent scope. It
   *     must be between 1 and 128 characters and contain alphanumeric characters, underscores, or
   *     hyphens only.
   * @param notificationConfig Required. The notification config being created. The name and the
   *     service account will be ignored as they are both output only fields on this resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationConfig createNotificationConfig(
      FolderName parent, String configId, NotificationConfig notificationConfig) {
    CreateNotificationConfigRequest request =
        CreateNotificationConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConfigId(configId)
            .setNotificationConfig(notificationConfig)
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
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   String configId = "configId-580140035";
   *   NotificationConfig notificationConfig = NotificationConfig.newBuilder().build();
   *   NotificationConfig response =
   *       securityCenterClient.createNotificationConfig(parent, configId, notificationConfig);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new notification config's parent. Its format is
   *     "organizations/[organization_id]", "folders/[folder_id]", or "projects/[project_id]".
   * @param configId Required. Unique identifier provided by the client within the parent scope. It
   *     must be between 1 and 128 characters and contain alphanumeric characters, underscores, or
   *     hyphens only.
   * @param notificationConfig Required. The notification config being created. The name and the
   *     service account will be ignored as they are both output only fields on this resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationConfig createNotificationConfig(
      OrganizationName parent, String configId, NotificationConfig notificationConfig) {
    CreateNotificationConfigRequest request =
        CreateNotificationConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConfigId(configId)
            .setNotificationConfig(notificationConfig)
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
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String configId = "configId-580140035";
   *   NotificationConfig notificationConfig = NotificationConfig.newBuilder().build();
   *   NotificationConfig response =
   *       securityCenterClient.createNotificationConfig(parent, configId, notificationConfig);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new notification config's parent. Its format is
   *     "organizations/[organization_id]", "folders/[folder_id]", or "projects/[project_id]".
   * @param configId Required. Unique identifier provided by the client within the parent scope. It
   *     must be between 1 and 128 characters and contain alphanumeric characters, underscores, or
   *     hyphens only.
   * @param notificationConfig Required. The notification config being created. The name and the
   *     service account will be ignored as they are both output only fields on this resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationConfig createNotificationConfig(
      ProjectName parent, String configId, NotificationConfig notificationConfig) {
    CreateNotificationConfigRequest request =
        CreateNotificationConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConfigId(configId)
            .setNotificationConfig(notificationConfig)
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
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   String configId = "configId-580140035";
   *   NotificationConfig notificationConfig = NotificationConfig.newBuilder().build();
   *   NotificationConfig response =
   *       securityCenterClient.createNotificationConfig(parent, configId, notificationConfig);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the new notification config's parent. Its format is
   *     "organizations/[organization_id]", "folders/[folder_id]", or "projects/[project_id]".
   * @param configId Required. Unique identifier provided by the client within the parent scope. It
   *     must be between 1 and 128 characters and contain alphanumeric characters, underscores, or
   *     hyphens only.
   * @param notificationConfig Required. The notification config being created. The name and the
   *     service account will be ignored as they are both output only fields on this resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationConfig createNotificationConfig(
      String parent, String configId, NotificationConfig notificationConfig) {
    CreateNotificationConfigRequest request =
        CreateNotificationConfigRequest.newBuilder()
            .setParent(parent)
            .setConfigId(configId)
            .setNotificationConfig(notificationConfig)
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
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
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
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
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
   * Deletes an existing mute config.
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
   * @param name Required. Name of the mute config to delete. Its format is
   *     organizations/{organization}/muteConfigs/{config_id},
   *     folders/{folder}/muteConfigs/{config_id}, or projects/{project}/muteConfigs/{config_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMuteConfig(MuteConfigName name) {
    DeleteMuteConfigRequest request =
        DeleteMuteConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteMuteConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing mute config.
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
   * @param name Required. Name of the mute config to delete. Its format is
   *     organizations/{organization}/muteConfigs/{config_id},
   *     folders/{folder}/muteConfigs/{config_id}, or projects/{project}/muteConfigs/{config_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMuteConfig(String name) {
    DeleteMuteConfigRequest request = DeleteMuteConfigRequest.newBuilder().setName(name).build();
    deleteMuteConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing mute config.
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
   * Deletes an existing mute config.
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
   *       NotificationConfigName.ofOrganizationNotificationConfigName(
   *           "[ORGANIZATION]", "[NOTIFICATION_CONFIG]");
   *   securityCenterClient.deleteNotificationConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the notification config to delete. Its format is
   *     "organizations/[organization_id]/notificationConfigs/[config_id]",
   *     "folders/[folder_id]/notificationConfigs/[config_id]", or
   *     "projects/[project_id]/notificationConfigs/[config_id]".
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
   *       NotificationConfigName.ofOrganizationNotificationConfigName(
   *               "[ORGANIZATION]", "[NOTIFICATION_CONFIG]")
   *           .toString();
   *   securityCenterClient.deleteNotificationConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the notification config to delete. Its format is
   *     "organizations/[organization_id]/notificationConfigs/[config_id]",
   *     "folders/[folder_id]/notificationConfigs/[config_id]", or
   *     "projects/[project_id]/notificationConfigs/[config_id]".
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
   *               NotificationConfigName.ofOrganizationNotificationConfigName(
   *                       "[ORGANIZATION]", "[NOTIFICATION_CONFIG]")
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
   *               NotificationConfigName.ofOrganizationNotificationConfigName(
   *                       "[ORGANIZATION]", "[NOTIFICATION_CONFIG]")
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
   * Deletes the specified SecurityHealthAnalyticsCustomModule and all of its descendants in the CRM
   * hierarchy. This method is only supported for resident custom modules.
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
   *   SecurityHealthAnalyticsCustomModuleName name =
   *       SecurityHealthAnalyticsCustomModuleName.ofOrganizationCustomModuleName(
   *           "[ORGANIZATION]", "[CUSTOM_MODULE]");
   *   securityCenterClient.deleteSecurityHealthAnalyticsCustomModule(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the custom module to delete. Its format is
   *     "organizations/{organization}/securityHealthAnalyticsSettings/customModules/{customModule}",
   *     "folders/{folder}/securityHealthAnalyticsSettings/customModules/{customModule}", or
   *     "projects/{project}/securityHealthAnalyticsSettings/customModules/{customModule}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSecurityHealthAnalyticsCustomModule(
      SecurityHealthAnalyticsCustomModuleName name) {
    DeleteSecurityHealthAnalyticsCustomModuleRequest request =
        DeleteSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteSecurityHealthAnalyticsCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified SecurityHealthAnalyticsCustomModule and all of its descendants in the CRM
   * hierarchy. This method is only supported for resident custom modules.
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
   *       SecurityHealthAnalyticsCustomModuleName.ofOrganizationCustomModuleName(
   *               "[ORGANIZATION]", "[CUSTOM_MODULE]")
   *           .toString();
   *   securityCenterClient.deleteSecurityHealthAnalyticsCustomModule(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the custom module to delete. Its format is
   *     "organizations/{organization}/securityHealthAnalyticsSettings/customModules/{customModule}",
   *     "folders/{folder}/securityHealthAnalyticsSettings/customModules/{customModule}", or
   *     "projects/{project}/securityHealthAnalyticsSettings/customModules/{customModule}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSecurityHealthAnalyticsCustomModule(String name) {
    DeleteSecurityHealthAnalyticsCustomModuleRequest request =
        DeleteSecurityHealthAnalyticsCustomModuleRequest.newBuilder().setName(name).build();
    deleteSecurityHealthAnalyticsCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified SecurityHealthAnalyticsCustomModule and all of its descendants in the CRM
   * hierarchy. This method is only supported for resident custom modules.
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
   *   DeleteSecurityHealthAnalyticsCustomModuleRequest request =
   *       DeleteSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
   *           .setName(
   *               SecurityHealthAnalyticsCustomModuleName.ofOrganizationCustomModuleName(
   *                       "[ORGANIZATION]", "[CUSTOM_MODULE]")
   *                   .toString())
   *           .build();
   *   securityCenterClient.deleteSecurityHealthAnalyticsCustomModule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSecurityHealthAnalyticsCustomModule(
      DeleteSecurityHealthAnalyticsCustomModuleRequest request) {
    deleteSecurityHealthAnalyticsCustomModuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified SecurityHealthAnalyticsCustomModule and all of its descendants in the CRM
   * hierarchy. This method is only supported for resident custom modules.
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
   *   DeleteSecurityHealthAnalyticsCustomModuleRequest request =
   *       DeleteSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
   *           .setName(
   *               SecurityHealthAnalyticsCustomModuleName.ofOrganizationCustomModuleName(
   *                       "[ORGANIZATION]", "[CUSTOM_MODULE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       securityCenterClient
   *           .deleteSecurityHealthAnalyticsCustomModuleCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSecurityHealthAnalyticsCustomModuleRequest, Empty>
      deleteSecurityHealthAnalyticsCustomModuleCallable() {
    return stub.deleteSecurityHealthAnalyticsCustomModuleCallable();
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
   *       BigQueryExportName.ofOrganizationExportName("[ORGANIZATION]", "[EXPORT]");
   *   BigQueryExport response = securityCenterClient.getBigQueryExport(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the BigQuery export to retrieve. Its format is
   *     organizations/{organization}/bigQueryExports/{export_id},
   *     folders/{folder}/bigQueryExports/{export_id}, or
   *     projects/{project}/bigQueryExports/{export_id}
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
   *       BigQueryExportName.ofOrganizationExportName("[ORGANIZATION]", "[EXPORT]").toString();
   *   BigQueryExport response = securityCenterClient.getBigQueryExport(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the BigQuery export to retrieve. Its format is
   *     organizations/{organization}/bigQueryExports/{export_id},
   *     folders/{folder}/bigQueryExports/{export_id}, or
   *     projects/{project}/bigQueryExports/{export_id}
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
   *               BigQueryExportName.ofOrganizationExportName("[ORGANIZATION]", "[EXPORT]")
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
   *               BigQueryExportName.ofOrganizationExportName("[ORGANIZATION]", "[EXPORT]")
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
   *           .setResource(
   *               SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString())
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
   *           .setResource(
   *               SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString())
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
   * Gets a mute config.
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
   * @param name Required. Name of the mute config to retrieve. Its format is
   *     organizations/{organization}/muteConfigs/{config_id},
   *     folders/{folder}/muteConfigs/{config_id}, or projects/{project}/muteConfigs/{config_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MuteConfig getMuteConfig(MuteConfigName name) {
    GetMuteConfigRequest request =
        GetMuteConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getMuteConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a mute config.
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
   * @param name Required. Name of the mute config to retrieve. Its format is
   *     organizations/{organization}/muteConfigs/{config_id},
   *     folders/{folder}/muteConfigs/{config_id}, or projects/{project}/muteConfigs/{config_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MuteConfig getMuteConfig(String name) {
    GetMuteConfigRequest request = GetMuteConfigRequest.newBuilder().setName(name).build();
    return getMuteConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a mute config.
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
   * Gets a mute config.
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
   *       NotificationConfigName.ofOrganizationNotificationConfigName(
   *           "[ORGANIZATION]", "[NOTIFICATION_CONFIG]");
   *   NotificationConfig response = securityCenterClient.getNotificationConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the notification config to get. Its format is
   *     "organizations/[organization_id]/notificationConfigs/[config_id]",
   *     "folders/[folder_id]/notificationConfigs/[config_id]", or
   *     "projects/[project_id]/notificationConfigs/[config_id]".
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
   *       NotificationConfigName.ofOrganizationNotificationConfigName(
   *               "[ORGANIZATION]", "[NOTIFICATION_CONFIG]")
   *           .toString();
   *   NotificationConfig response = securityCenterClient.getNotificationConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the notification config to get. Its format is
   *     "organizations/[organization_id]/notificationConfigs/[config_id]",
   *     "folders/[folder_id]/notificationConfigs/[config_id]", or
   *     "projects/[project_id]/notificationConfigs/[config_id]".
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
   *               NotificationConfigName.ofOrganizationNotificationConfigName(
   *                       "[ORGANIZATION]", "[NOTIFICATION_CONFIG]")
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
   *               NotificationConfigName.ofOrganizationNotificationConfigName(
   *                       "[ORGANIZATION]", "[NOTIFICATION_CONFIG]")
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
   * Gets the settings for an organization.
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
   *   OrganizationSettingsName name = OrganizationSettingsName.of("[ORGANIZATION]");
   *   OrganizationSettings response = securityCenterClient.getOrganizationSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the organization to get organization settings for. Its format is
   *     "organizations/[organization_id]/organizationSettings".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OrganizationSettings getOrganizationSettings(OrganizationSettingsName name) {
    GetOrganizationSettingsRequest request =
        GetOrganizationSettingsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getOrganizationSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the settings for an organization.
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
   *   String name = OrganizationSettingsName.of("[ORGANIZATION]").toString();
   *   OrganizationSettings response = securityCenterClient.getOrganizationSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the organization to get organization settings for. Its format is
   *     "organizations/[organization_id]/organizationSettings".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OrganizationSettings getOrganizationSettings(String name) {
    GetOrganizationSettingsRequest request =
        GetOrganizationSettingsRequest.newBuilder().setName(name).build();
    return getOrganizationSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the settings for an organization.
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
   *   GetOrganizationSettingsRequest request =
   *       GetOrganizationSettingsRequest.newBuilder()
   *           .setName(OrganizationSettingsName.of("[ORGANIZATION]").toString())
   *           .build();
   *   OrganizationSettings response = securityCenterClient.getOrganizationSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OrganizationSettings getOrganizationSettings(
      GetOrganizationSettingsRequest request) {
    return getOrganizationSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the settings for an organization.
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
   *   GetOrganizationSettingsRequest request =
   *       GetOrganizationSettingsRequest.newBuilder()
   *           .setName(OrganizationSettingsName.of("[ORGANIZATION]").toString())
   *           .build();
   *   ApiFuture<OrganizationSettings> future =
   *       securityCenterClient.getOrganizationSettingsCallable().futureCall(request);
   *   // Do something.
   *   OrganizationSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetOrganizationSettingsRequest, OrganizationSettings>
      getOrganizationSettingsCallable() {
    return stub.getOrganizationSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an EffectiveSecurityHealthAnalyticsCustomModule.
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
   *   EffectiveSecurityHealthAnalyticsCustomModuleName name =
   *       EffectiveSecurityHealthAnalyticsCustomModuleName.ofOrganizationEffectiveCustomModuleName(
   *           "[ORGANIZATION]", "[EFFECTIVE_CUSTOM_MODULE]");
   *   EffectiveSecurityHealthAnalyticsCustomModule response =
   *       securityCenterClient.getEffectiveSecurityHealthAnalyticsCustomModule(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the effective custom module to get. Its format is
   *     "organizations/{organization}/securityHealthAnalyticsSettings/effectiveCustomModules/{customModule}",
   *     "folders/{folder}/securityHealthAnalyticsSettings/effectiveCustomModules/{customModule}",
   *     or
   *     "projects/{project}/securityHealthAnalyticsSettings/effectiveCustomModules/{customModule}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EffectiveSecurityHealthAnalyticsCustomModule
      getEffectiveSecurityHealthAnalyticsCustomModule(
          EffectiveSecurityHealthAnalyticsCustomModuleName name) {
    GetEffectiveSecurityHealthAnalyticsCustomModuleRequest request =
        GetEffectiveSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getEffectiveSecurityHealthAnalyticsCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an EffectiveSecurityHealthAnalyticsCustomModule.
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
   *       EffectiveSecurityHealthAnalyticsCustomModuleName.ofOrganizationEffectiveCustomModuleName(
   *               "[ORGANIZATION]", "[EFFECTIVE_CUSTOM_MODULE]")
   *           .toString();
   *   EffectiveSecurityHealthAnalyticsCustomModule response =
   *       securityCenterClient.getEffectiveSecurityHealthAnalyticsCustomModule(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the effective custom module to get. Its format is
   *     "organizations/{organization}/securityHealthAnalyticsSettings/effectiveCustomModules/{customModule}",
   *     "folders/{folder}/securityHealthAnalyticsSettings/effectiveCustomModules/{customModule}",
   *     or
   *     "projects/{project}/securityHealthAnalyticsSettings/effectiveCustomModules/{customModule}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EffectiveSecurityHealthAnalyticsCustomModule
      getEffectiveSecurityHealthAnalyticsCustomModule(String name) {
    GetEffectiveSecurityHealthAnalyticsCustomModuleRequest request =
        GetEffectiveSecurityHealthAnalyticsCustomModuleRequest.newBuilder().setName(name).build();
    return getEffectiveSecurityHealthAnalyticsCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an EffectiveSecurityHealthAnalyticsCustomModule.
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
   *   GetEffectiveSecurityHealthAnalyticsCustomModuleRequest request =
   *       GetEffectiveSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
   *           .setName(
   *               EffectiveSecurityHealthAnalyticsCustomModuleName
   *                   .ofOrganizationEffectiveCustomModuleName(
   *                       "[ORGANIZATION]", "[EFFECTIVE_CUSTOM_MODULE]")
   *                   .toString())
   *           .build();
   *   EffectiveSecurityHealthAnalyticsCustomModule response =
   *       securityCenterClient.getEffectiveSecurityHealthAnalyticsCustomModule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EffectiveSecurityHealthAnalyticsCustomModule
      getEffectiveSecurityHealthAnalyticsCustomModule(
          GetEffectiveSecurityHealthAnalyticsCustomModuleRequest request) {
    return getEffectiveSecurityHealthAnalyticsCustomModuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an EffectiveSecurityHealthAnalyticsCustomModule.
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
   *   GetEffectiveSecurityHealthAnalyticsCustomModuleRequest request =
   *       GetEffectiveSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
   *           .setName(
   *               EffectiveSecurityHealthAnalyticsCustomModuleName
   *                   .ofOrganizationEffectiveCustomModuleName(
   *                       "[ORGANIZATION]", "[EFFECTIVE_CUSTOM_MODULE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<EffectiveSecurityHealthAnalyticsCustomModule> future =
   *       securityCenterClient
   *           .getEffectiveSecurityHealthAnalyticsCustomModuleCallable()
   *           .futureCall(request);
   *   // Do something.
   *   EffectiveSecurityHealthAnalyticsCustomModule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
          EffectiveSecurityHealthAnalyticsCustomModule>
      getEffectiveSecurityHealthAnalyticsCustomModuleCallable() {
    return stub.getEffectiveSecurityHealthAnalyticsCustomModuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a SecurityHealthAnalyticsCustomModule.
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
   *   SecurityHealthAnalyticsCustomModuleName name =
   *       SecurityHealthAnalyticsCustomModuleName.ofOrganizationCustomModuleName(
   *           "[ORGANIZATION]", "[CUSTOM_MODULE]");
   *   SecurityHealthAnalyticsCustomModule response =
   *       securityCenterClient.getSecurityHealthAnalyticsCustomModule(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the custom module to get. Its format is
   *     "organizations/{organization}/securityHealthAnalyticsSettings/customModules/{customModule}",
   *     "folders/{folder}/securityHealthAnalyticsSettings/customModules/{customModule}", or
   *     "projects/{project}/securityHealthAnalyticsSettings/customModules/{customModule}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityHealthAnalyticsCustomModule getSecurityHealthAnalyticsCustomModule(
      SecurityHealthAnalyticsCustomModuleName name) {
    GetSecurityHealthAnalyticsCustomModuleRequest request =
        GetSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getSecurityHealthAnalyticsCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a SecurityHealthAnalyticsCustomModule.
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
   *       SecurityHealthAnalyticsCustomModuleName.ofOrganizationCustomModuleName(
   *               "[ORGANIZATION]", "[CUSTOM_MODULE]")
   *           .toString();
   *   SecurityHealthAnalyticsCustomModule response =
   *       securityCenterClient.getSecurityHealthAnalyticsCustomModule(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the custom module to get. Its format is
   *     "organizations/{organization}/securityHealthAnalyticsSettings/customModules/{customModule}",
   *     "folders/{folder}/securityHealthAnalyticsSettings/customModules/{customModule}", or
   *     "projects/{project}/securityHealthAnalyticsSettings/customModules/{customModule}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityHealthAnalyticsCustomModule getSecurityHealthAnalyticsCustomModule(
      String name) {
    GetSecurityHealthAnalyticsCustomModuleRequest request =
        GetSecurityHealthAnalyticsCustomModuleRequest.newBuilder().setName(name).build();
    return getSecurityHealthAnalyticsCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a SecurityHealthAnalyticsCustomModule.
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
   *   GetSecurityHealthAnalyticsCustomModuleRequest request =
   *       GetSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
   *           .setName(
   *               SecurityHealthAnalyticsCustomModuleName.ofOrganizationCustomModuleName(
   *                       "[ORGANIZATION]", "[CUSTOM_MODULE]")
   *                   .toString())
   *           .build();
   *   SecurityHealthAnalyticsCustomModule response =
   *       securityCenterClient.getSecurityHealthAnalyticsCustomModule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityHealthAnalyticsCustomModule getSecurityHealthAnalyticsCustomModule(
      GetSecurityHealthAnalyticsCustomModuleRequest request) {
    return getSecurityHealthAnalyticsCustomModuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a SecurityHealthAnalyticsCustomModule.
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
   *   GetSecurityHealthAnalyticsCustomModuleRequest request =
   *       GetSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
   *           .setName(
   *               SecurityHealthAnalyticsCustomModuleName.ofOrganizationCustomModuleName(
   *                       "[ORGANIZATION]", "[CUSTOM_MODULE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<SecurityHealthAnalyticsCustomModule> future =
   *       securityCenterClient.getSecurityHealthAnalyticsCustomModuleCallable().futureCall(request);
   *   // Do something.
   *   SecurityHealthAnalyticsCustomModule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      getSecurityHealthAnalyticsCustomModuleCallable() {
    return stub.getSecurityHealthAnalyticsCustomModuleCallable();
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
   * Filters an organization's assets and groups them by their specified properties.
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
   *   GroupAssetsRequest request =
   *       GroupAssetsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setGroupBy("groupBy293428022")
   *           .setCompareDuration(Duration.newBuilder().build())
   *           .setReadTime(Timestamp.newBuilder().build())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   for (GroupResult element : securityCenterClient.groupAssets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final GroupAssetsPagedResponse groupAssets(GroupAssetsRequest request) {
    return groupAssetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Filters an organization's assets and groups them by their specified properties.
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
   *   GroupAssetsRequest request =
   *       GroupAssetsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setGroupBy("groupBy293428022")
   *           .setCompareDuration(Duration.newBuilder().build())
   *           .setReadTime(Timestamp.newBuilder().build())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   ApiFuture<GroupResult> future =
   *       securityCenterClient.groupAssetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (GroupResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<GroupAssetsRequest, GroupAssetsPagedResponse>
      groupAssetsPagedCallable() {
    return stub.groupAssetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Filters an organization's assets and groups them by their specified properties.
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
   *   GroupAssetsRequest request =
   *       GroupAssetsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setGroupBy("groupBy293428022")
   *           .setCompareDuration(Duration.newBuilder().build())
   *           .setReadTime(Timestamp.newBuilder().build())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   while (true) {
   *     GroupAssetsResponse response = securityCenterClient.groupAssetsCallable().call(request);
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
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<GroupAssetsRequest, GroupAssetsResponse> groupAssetsCallable() {
    return stub.groupAssetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Filters an organization or source's findings and groups them by their specified properties.
   *
   * <p>To group across all sources provide a `-` as the source id. Example:
   * /v1/organizations/{organization_id}/sources/-/findings,
   * /v1/folders/{folder_id}/sources/-/findings, /v1/projects/{project_id}/sources/-/findings
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
   * @param parent Required. Name of the source to groupBy. Its format is
   *     "organizations/[organization_id]/sources/[source_id]",
   *     folders/[folder_id]/sources/[source_id], or projects/[project_id]/sources/[source_id]. To
   *     groupBy across all sources provide a source_id of `-`. For example:
   *     organizations/{organization_id}/sources/-, folders/{folder_id}/sources/-, or
   *     projects/{project_id}/sources/-
   * @param groupBy Required. Expression that defines what assets fields to use for grouping
   *     (including `state_change`). The string value should follow SQL syntax: comma separated list
   *     of fields. For example: "parent,resource_name".
   *     <p>The following fields are supported:
   *     <ul>
   *       <li>resource_name
   *       <li>category
   *       <li>state
   *       <li>parent
   *       <li>severity
   *     </ul>
   *     <p>The following fields are supported when compare_duration is set:
   *     <ul>
   *       <li>state_change
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
   * Filters an organization or source's findings and groups them by their specified properties.
   *
   * <p>To group across all sources provide a `-` as the source id. Example:
   * /v1/organizations/{organization_id}/sources/-/findings,
   * /v1/folders/{folder_id}/sources/-/findings, /v1/projects/{project_id}/sources/-/findings
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
   * @param parent Required. Name of the source to groupBy. Its format is
   *     "organizations/[organization_id]/sources/[source_id]",
   *     folders/[folder_id]/sources/[source_id], or projects/[project_id]/sources/[source_id]. To
   *     groupBy across all sources provide a source_id of `-`. For example:
   *     organizations/{organization_id}/sources/-, folders/{folder_id}/sources/-, or
   *     projects/{project_id}/sources/-
   * @param groupBy Required. Expression that defines what assets fields to use for grouping
   *     (including `state_change`). The string value should follow SQL syntax: comma separated list
   *     of fields. For example: "parent,resource_name".
   *     <p>The following fields are supported:
   *     <ul>
   *       <li>resource_name
   *       <li>category
   *       <li>state
   *       <li>parent
   *       <li>severity
   *     </ul>
   *     <p>The following fields are supported when compare_duration is set:
   *     <ul>
   *       <li>state_change
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
   * Filters an organization or source's findings and groups them by their specified properties.
   *
   * <p>To group across all sources provide a `-` as the source id. Example:
   * /v1/organizations/{organization_id}/sources/-/findings,
   * /v1/folders/{folder_id}/sources/-/findings, /v1/projects/{project_id}/sources/-/findings
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
   *           .setReadTime(Timestamp.newBuilder().build())
   *           .setCompareDuration(Duration.newBuilder().build())
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
   * Filters an organization or source's findings and groups them by their specified properties.
   *
   * <p>To group across all sources provide a `-` as the source id. Example:
   * /v1/organizations/{organization_id}/sources/-/findings,
   * /v1/folders/{folder_id}/sources/-/findings, /v1/projects/{project_id}/sources/-/findings
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
   *           .setReadTime(Timestamp.newBuilder().build())
   *           .setCompareDuration(Duration.newBuilder().build())
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
   * Filters an organization or source's findings and groups them by their specified properties.
   *
   * <p>To group across all sources provide a `-` as the source id. Example:
   * /v1/organizations/{organization_id}/sources/-/findings,
   * /v1/folders/{folder_id}/sources/-/findings, /v1/projects/{project_id}/sources/-/findings
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
   *           .setReadTime(Timestamp.newBuilder().build())
   *           .setCompareDuration(Duration.newBuilder().build())
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
   * Lists an organization's assets.
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
   *   ListAssetsRequest request =
   *       ListAssetsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReadTime(Timestamp.newBuilder().build())
   *           .setCompareDuration(Duration.newBuilder().build())
   *           .setFieldMask(FieldMask.newBuilder().build())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   for (ListAssetsResponse.ListAssetsResult element :
   *       securityCenterClient.listAssets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final ListAssetsPagedResponse listAssets(ListAssetsRequest request) {
    return listAssetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists an organization's assets.
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
   *   ListAssetsRequest request =
   *       ListAssetsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReadTime(Timestamp.newBuilder().build())
   *           .setCompareDuration(Duration.newBuilder().build())
   *           .setFieldMask(FieldMask.newBuilder().build())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   ApiFuture<ListAssetsResponse.ListAssetsResult> future =
   *       securityCenterClient.listAssetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ListAssetsResponse.ListAssetsResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<ListAssetsRequest, ListAssetsPagedResponse> listAssetsPagedCallable() {
    return stub.listAssetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists an organization's assets.
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
   *   ListAssetsRequest request =
   *       ListAssetsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReadTime(Timestamp.newBuilder().build())
   *           .setCompareDuration(Duration.newBuilder().build())
   *           .setFieldMask(FieldMask.newBuilder().build())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   while (true) {
   *     ListAssetsResponse response = securityCenterClient.listAssetsCallable().call(request);
   *     for (ListAssetsResponse.ListAssetsResult element : response.getListAssetsResultsList()) {
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
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<ListAssetsRequest, ListAssetsResponse> listAssetsCallable() {
    return stub.listAssetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all resident SecurityHealthAnalyticsCustomModules under the given CRM parent
   * and all of the parent’s CRM descendants.
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
   *   SecurityHealthAnalyticsSettingsName parent =
   *       SecurityHealthAnalyticsSettingsName.ofOrganizationName("[ORGANIZATION]");
   *   for (SecurityHealthAnalyticsCustomModule element :
   *       securityCenterClient
   *           .listDescendantSecurityHealthAnalyticsCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list descendant custom modules. Its format is
   *     "organizations/{organization}/securityHealthAnalyticsSettings",
   *     "folders/{folder}/securityHealthAnalyticsSettings", or
   *     "projects/{project}/securityHealthAnalyticsSettings"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse
      listDescendantSecurityHealthAnalyticsCustomModules(
          SecurityHealthAnalyticsSettingsName parent) {
    ListDescendantSecurityHealthAnalyticsCustomModulesRequest request =
        ListDescendantSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDescendantSecurityHealthAnalyticsCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all resident SecurityHealthAnalyticsCustomModules under the given CRM parent
   * and all of the parent’s CRM descendants.
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
   *       SecurityHealthAnalyticsSettingsName.ofOrganizationName("[ORGANIZATION]").toString();
   *   for (SecurityHealthAnalyticsCustomModule element :
   *       securityCenterClient
   *           .listDescendantSecurityHealthAnalyticsCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list descendant custom modules. Its format is
   *     "organizations/{organization}/securityHealthAnalyticsSettings",
   *     "folders/{folder}/securityHealthAnalyticsSettings", or
   *     "projects/{project}/securityHealthAnalyticsSettings"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse
      listDescendantSecurityHealthAnalyticsCustomModules(String parent) {
    ListDescendantSecurityHealthAnalyticsCustomModulesRequest request =
        ListDescendantSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
            .setParent(parent)
            .build();
    return listDescendantSecurityHealthAnalyticsCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all resident SecurityHealthAnalyticsCustomModules under the given CRM parent
   * and all of the parent’s CRM descendants.
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
   *   ListDescendantSecurityHealthAnalyticsCustomModulesRequest request =
   *       ListDescendantSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
   *           .setParent(
   *               SecurityHealthAnalyticsSettingsName.ofOrganizationName("[ORGANIZATION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SecurityHealthAnalyticsCustomModule element :
   *       securityCenterClient
   *           .listDescendantSecurityHealthAnalyticsCustomModules(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse
      listDescendantSecurityHealthAnalyticsCustomModules(
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest request) {
    return listDescendantSecurityHealthAnalyticsCustomModulesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all resident SecurityHealthAnalyticsCustomModules under the given CRM parent
   * and all of the parent’s CRM descendants.
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
   *   ListDescendantSecurityHealthAnalyticsCustomModulesRequest request =
   *       ListDescendantSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
   *           .setParent(
   *               SecurityHealthAnalyticsSettingsName.ofOrganizationName("[ORGANIZATION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SecurityHealthAnalyticsCustomModule> future =
   *       securityCenterClient
   *           .listDescendantSecurityHealthAnalyticsCustomModulesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (SecurityHealthAnalyticsCustomModule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse>
      listDescendantSecurityHealthAnalyticsCustomModulesPagedCallable() {
    return stub.listDescendantSecurityHealthAnalyticsCustomModulesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all resident SecurityHealthAnalyticsCustomModules under the given CRM parent
   * and all of the parent’s CRM descendants.
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
   *   ListDescendantSecurityHealthAnalyticsCustomModulesRequest request =
   *       ListDescendantSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
   *           .setParent(
   *               SecurityHealthAnalyticsSettingsName.ofOrganizationName("[ORGANIZATION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDescendantSecurityHealthAnalyticsCustomModulesResponse response =
   *         securityCenterClient
   *             .listDescendantSecurityHealthAnalyticsCustomModulesCallable()
   *             .call(request);
   *     for (SecurityHealthAnalyticsCustomModule element :
   *         response.getSecurityHealthAnalyticsCustomModulesList()) {
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
  public final UnaryCallable<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesResponse>
      listDescendantSecurityHealthAnalyticsCustomModulesCallable() {
    return stub.listDescendantSecurityHealthAnalyticsCustomModulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists an organization or source's findings.
   *
   * <p>To list across all sources provide a `-` as the source id. Example:
   * /v1/organizations/{organization_id}/sources/-/findings
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
   *           .setReadTime(Timestamp.newBuilder().build())
   *           .setCompareDuration(Duration.newBuilder().build())
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
   * <p>To list across all sources provide a `-` as the source id. Example:
   * /v1/organizations/{organization_id}/sources/-/findings
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
   *           .setReadTime(Timestamp.newBuilder().build())
   *           .setCompareDuration(Duration.newBuilder().build())
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
   * <p>To list across all sources provide a `-` as the source id. Example:
   * /v1/organizations/{organization_id}/sources/-/findings
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
   *           .setReadTime(Timestamp.newBuilder().build())
   *           .setCompareDuration(Duration.newBuilder().build())
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
   * Lists mute configs.
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
   *     "organizations/[organization_id]", "folders/[folder_id]", "projects/[project_id]".
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
   * Lists mute configs.
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
   *     "organizations/[organization_id]", "folders/[folder_id]", "projects/[project_id]".
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
   * Lists mute configs.
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
   *     "organizations/[organization_id]", "folders/[folder_id]", "projects/[project_id]".
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
   * Lists mute configs.
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
   *     "organizations/[organization_id]", "folders/[folder_id]", "projects/[project_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMuteConfigsPagedResponse listMuteConfigs(String parent) {
    ListMuteConfigsRequest request = ListMuteConfigsRequest.newBuilder().setParent(parent).build();
    return listMuteConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists mute configs.
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
   * Lists mute configs.
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
   * Lists mute configs.
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
   *   FolderName parent = FolderName.of("[FOLDER]");
   *   for (NotificationConfig element :
   *       securityCenterClient.listNotificationConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent in which to list the notification
   *     configurations. Its format is "organizations/[organization_id]", "folders/[folder_id]", or
   *     "projects/[project_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotificationConfigsPagedResponse listNotificationConfigs(FolderName parent) {
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
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   for (NotificationConfig element :
   *       securityCenterClient.listNotificationConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent in which to list the notification
   *     configurations. Its format is "organizations/[organization_id]", "folders/[folder_id]", or
   *     "projects/[project_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotificationConfigsPagedResponse listNotificationConfigs(
      OrganizationName parent) {
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
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (NotificationConfig element :
   *       securityCenterClient.listNotificationConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent in which to list the notification
   *     configurations. Its format is "organizations/[organization_id]", "folders/[folder_id]", or
   *     "projects/[project_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotificationConfigsPagedResponse listNotificationConfigs(ProjectName parent) {
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
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   for (NotificationConfig element :
   *       securityCenterClient.listNotificationConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent in which to list the notification
   *     configurations. Its format is "organizations/[organization_id]", "folders/[folder_id]", or
   *     "projects/[project_id]".
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
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
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
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
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
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
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
   * Returns a list of all EffectiveSecurityHealthAnalyticsCustomModules for the given parent. This
   * includes resident modules defined at the scope of the parent, and inherited modules, inherited
   * from CRM ancestors.
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
   *   SecurityHealthAnalyticsSettingsName parent =
   *       SecurityHealthAnalyticsSettingsName.ofOrganizationName("[ORGANIZATION]");
   *   for (EffectiveSecurityHealthAnalyticsCustomModule element :
   *       securityCenterClient
   *           .listEffectiveSecurityHealthAnalyticsCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list effective custom modules. Its format is
   *     "organizations/{organization}/securityHealthAnalyticsSettings",
   *     "folders/{folder}/securityHealthAnalyticsSettings", or
   *     "projects/{project}/securityHealthAnalyticsSettings"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse
      listEffectiveSecurityHealthAnalyticsCustomModules(
          SecurityHealthAnalyticsSettingsName parent) {
    ListEffectiveSecurityHealthAnalyticsCustomModulesRequest request =
        ListEffectiveSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEffectiveSecurityHealthAnalyticsCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all EffectiveSecurityHealthAnalyticsCustomModules for the given parent. This
   * includes resident modules defined at the scope of the parent, and inherited modules, inherited
   * from CRM ancestors.
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
   *       SecurityHealthAnalyticsSettingsName.ofOrganizationName("[ORGANIZATION]").toString();
   *   for (EffectiveSecurityHealthAnalyticsCustomModule element :
   *       securityCenterClient
   *           .listEffectiveSecurityHealthAnalyticsCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list effective custom modules. Its format is
   *     "organizations/{organization}/securityHealthAnalyticsSettings",
   *     "folders/{folder}/securityHealthAnalyticsSettings", or
   *     "projects/{project}/securityHealthAnalyticsSettings"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse
      listEffectiveSecurityHealthAnalyticsCustomModules(String parent) {
    ListEffectiveSecurityHealthAnalyticsCustomModulesRequest request =
        ListEffectiveSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
            .setParent(parent)
            .build();
    return listEffectiveSecurityHealthAnalyticsCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all EffectiveSecurityHealthAnalyticsCustomModules for the given parent. This
   * includes resident modules defined at the scope of the parent, and inherited modules, inherited
   * from CRM ancestors.
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
   *   ListEffectiveSecurityHealthAnalyticsCustomModulesRequest request =
   *       ListEffectiveSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
   *           .setParent(
   *               SecurityHealthAnalyticsSettingsName.ofOrganizationName("[ORGANIZATION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (EffectiveSecurityHealthAnalyticsCustomModule element :
   *       securityCenterClient
   *           .listEffectiveSecurityHealthAnalyticsCustomModules(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse
      listEffectiveSecurityHealthAnalyticsCustomModules(
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest request) {
    return listEffectiveSecurityHealthAnalyticsCustomModulesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all EffectiveSecurityHealthAnalyticsCustomModules for the given parent. This
   * includes resident modules defined at the scope of the parent, and inherited modules, inherited
   * from CRM ancestors.
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
   *   ListEffectiveSecurityHealthAnalyticsCustomModulesRequest request =
   *       ListEffectiveSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
   *           .setParent(
   *               SecurityHealthAnalyticsSettingsName.ofOrganizationName("[ORGANIZATION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<EffectiveSecurityHealthAnalyticsCustomModule> future =
   *       securityCenterClient
   *           .listEffectiveSecurityHealthAnalyticsCustomModulesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (EffectiveSecurityHealthAnalyticsCustomModule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse>
      listEffectiveSecurityHealthAnalyticsCustomModulesPagedCallable() {
    return stub.listEffectiveSecurityHealthAnalyticsCustomModulesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all EffectiveSecurityHealthAnalyticsCustomModules for the given parent. This
   * includes resident modules defined at the scope of the parent, and inherited modules, inherited
   * from CRM ancestors.
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
   *   ListEffectiveSecurityHealthAnalyticsCustomModulesRequest request =
   *       ListEffectiveSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
   *           .setParent(
   *               SecurityHealthAnalyticsSettingsName.ofOrganizationName("[ORGANIZATION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListEffectiveSecurityHealthAnalyticsCustomModulesResponse response =
   *         securityCenterClient
   *             .listEffectiveSecurityHealthAnalyticsCustomModulesCallable()
   *             .call(request);
   *     for (EffectiveSecurityHealthAnalyticsCustomModule element :
   *         response.getEffectiveSecurityHealthAnalyticsCustomModulesList()) {
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
  public final UnaryCallable<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>
      listEffectiveSecurityHealthAnalyticsCustomModulesCallable() {
    return stub.listEffectiveSecurityHealthAnalyticsCustomModulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all SecurityHealthAnalyticsCustomModules for the given parent. This includes
   * resident modules defined at the scope of the parent, and inherited modules, inherited from CRM
   * ancestors.
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
   *   SecurityHealthAnalyticsSettingsName parent =
   *       SecurityHealthAnalyticsSettingsName.ofOrganizationName("[ORGANIZATION]");
   *   for (SecurityHealthAnalyticsCustomModule element :
   *       securityCenterClient.listSecurityHealthAnalyticsCustomModules(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list custom modules. Its format is
   *     "organizations/{organization}/securityHealthAnalyticsSettings",
   *     "folders/{folder}/securityHealthAnalyticsSettings", or
   *     "projects/{project}/securityHealthAnalyticsSettings"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSecurityHealthAnalyticsCustomModulesPagedResponse
      listSecurityHealthAnalyticsCustomModules(SecurityHealthAnalyticsSettingsName parent) {
    ListSecurityHealthAnalyticsCustomModulesRequest request =
        ListSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSecurityHealthAnalyticsCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all SecurityHealthAnalyticsCustomModules for the given parent. This includes
   * resident modules defined at the scope of the parent, and inherited modules, inherited from CRM
   * ancestors.
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
   *       SecurityHealthAnalyticsSettingsName.ofOrganizationName("[ORGANIZATION]").toString();
   *   for (SecurityHealthAnalyticsCustomModule element :
   *       securityCenterClient.listSecurityHealthAnalyticsCustomModules(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list custom modules. Its format is
   *     "organizations/{organization}/securityHealthAnalyticsSettings",
   *     "folders/{folder}/securityHealthAnalyticsSettings", or
   *     "projects/{project}/securityHealthAnalyticsSettings"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSecurityHealthAnalyticsCustomModulesPagedResponse
      listSecurityHealthAnalyticsCustomModules(String parent) {
    ListSecurityHealthAnalyticsCustomModulesRequest request =
        ListSecurityHealthAnalyticsCustomModulesRequest.newBuilder().setParent(parent).build();
    return listSecurityHealthAnalyticsCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all SecurityHealthAnalyticsCustomModules for the given parent. This includes
   * resident modules defined at the scope of the parent, and inherited modules, inherited from CRM
   * ancestors.
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
   *   ListSecurityHealthAnalyticsCustomModulesRequest request =
   *       ListSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
   *           .setParent(
   *               SecurityHealthAnalyticsSettingsName.ofOrganizationName("[ORGANIZATION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SecurityHealthAnalyticsCustomModule element :
   *       securityCenterClient.listSecurityHealthAnalyticsCustomModules(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSecurityHealthAnalyticsCustomModulesPagedResponse
      listSecurityHealthAnalyticsCustomModules(
          ListSecurityHealthAnalyticsCustomModulesRequest request) {
    return listSecurityHealthAnalyticsCustomModulesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all SecurityHealthAnalyticsCustomModules for the given parent. This includes
   * resident modules defined at the scope of the parent, and inherited modules, inherited from CRM
   * ancestors.
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
   *   ListSecurityHealthAnalyticsCustomModulesRequest request =
   *       ListSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
   *           .setParent(
   *               SecurityHealthAnalyticsSettingsName.ofOrganizationName("[ORGANIZATION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SecurityHealthAnalyticsCustomModule> future =
   *       securityCenterClient
   *           .listSecurityHealthAnalyticsCustomModulesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (SecurityHealthAnalyticsCustomModule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesPagedResponse>
      listSecurityHealthAnalyticsCustomModulesPagedCallable() {
    return stub.listSecurityHealthAnalyticsCustomModulesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all SecurityHealthAnalyticsCustomModules for the given parent. This includes
   * resident modules defined at the scope of the parent, and inherited modules, inherited from CRM
   * ancestors.
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
   *   ListSecurityHealthAnalyticsCustomModulesRequest request =
   *       ListSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
   *           .setParent(
   *               SecurityHealthAnalyticsSettingsName.ofOrganizationName("[ORGANIZATION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSecurityHealthAnalyticsCustomModulesResponse response =
   *         securityCenterClient.listSecurityHealthAnalyticsCustomModulesCallable().call(request);
   *     for (SecurityHealthAnalyticsCustomModule element :
   *         response.getSecurityHealthAnalyticsCustomModulesList()) {
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
  public final UnaryCallable<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesResponse>
      listSecurityHealthAnalyticsCustomModulesCallable() {
    return stub.listSecurityHealthAnalyticsCustomModulesCallable();
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
   * Runs asset discovery. The discovery is tracked with a long-running operation.
   *
   * <p>This API can only be called with limited frequency for an organization. If it is called too
   * frequently the caller will receive a TOO_MANY_REQUESTS error.
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
   *   RunAssetDiscoveryResponse response =
   *       securityCenterClient.runAssetDiscoveryAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. Name of the organization to run asset discovery for. Its format is
   *     "organizations/[organization_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final OperationFuture<RunAssetDiscoveryResponse, Empty> runAssetDiscoveryAsync(
      OrganizationName parent) {
    RunAssetDiscoveryRequest request =
        RunAssetDiscoveryRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return runAssetDiscoveryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs asset discovery. The discovery is tracked with a long-running operation.
   *
   * <p>This API can only be called with limited frequency for an organization. If it is called too
   * frequently the caller will receive a TOO_MANY_REQUESTS error.
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
   *   RunAssetDiscoveryResponse response =
   *       securityCenterClient.runAssetDiscoveryAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. Name of the organization to run asset discovery for. Its format is
   *     "organizations/[organization_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final OperationFuture<RunAssetDiscoveryResponse, Empty> runAssetDiscoveryAsync(
      String parent) {
    RunAssetDiscoveryRequest request =
        RunAssetDiscoveryRequest.newBuilder().setParent(parent).build();
    return runAssetDiscoveryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs asset discovery. The discovery is tracked with a long-running operation.
   *
   * <p>This API can only be called with limited frequency for an organization. If it is called too
   * frequently the caller will receive a TOO_MANY_REQUESTS error.
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
   *   RunAssetDiscoveryRequest request =
   *       RunAssetDiscoveryRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .build();
   *   RunAssetDiscoveryResponse response =
   *       securityCenterClient.runAssetDiscoveryAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final OperationFuture<RunAssetDiscoveryResponse, Empty> runAssetDiscoveryAsync(
      RunAssetDiscoveryRequest request) {
    return runAssetDiscoveryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs asset discovery. The discovery is tracked with a long-running operation.
   *
   * <p>This API can only be called with limited frequency for an organization. If it is called too
   * frequently the caller will receive a TOO_MANY_REQUESTS error.
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
   *   RunAssetDiscoveryRequest request =
   *       RunAssetDiscoveryRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .build();
   *   OperationFuture<RunAssetDiscoveryResponse, Empty> future =
   *       securityCenterClient.runAssetDiscoveryOperationCallable().futureCall(request);
   *   // Do something.
   *   RunAssetDiscoveryResponse response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final OperationCallable<RunAssetDiscoveryRequest, RunAssetDiscoveryResponse, Empty>
      runAssetDiscoveryOperationCallable() {
    return stub.runAssetDiscoveryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs asset discovery. The discovery is tracked with a long-running operation.
   *
   * <p>This API can only be called with limited frequency for an organization. If it is called too
   * frequently the caller will receive a TOO_MANY_REQUESTS error.
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
   *   RunAssetDiscoveryRequest request =
   *       RunAssetDiscoveryRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       securityCenterClient.runAssetDiscoveryCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<RunAssetDiscoveryRequest, Operation> runAssetDiscoveryCallable() {
    return stub.runAssetDiscoveryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the state of a finding.
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
   *   Timestamp startTime = Timestamp.newBuilder().build();
   *   Finding response = securityCenterClient.setFindingState(name, state, startTime);
   * }
   * }</pre>
   *
   * @param name Required. The [relative resource
   *     name](https://cloud.google.com/apis/design/resource_names#relative_resource_name) of the
   *     finding. Example:
   *     "organizations/{organization_id}/sources/{source_id}/findings/{finding_id}",
   *     "folders/{folder_id}/sources/{source_id}/findings/{finding_id}",
   *     "projects/{project_id}/sources/{source_id}/findings/{finding_id}".
   * @param state Required. The desired State of the finding.
   * @param startTime Required. The time at which the updated state takes effect.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Finding setFindingState(FindingName name, Finding.State state, Timestamp startTime) {
    SetFindingStateRequest request =
        SetFindingStateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setState(state)
            .setStartTime(startTime)
            .build();
    return setFindingState(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the state of a finding.
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
   *   Timestamp startTime = Timestamp.newBuilder().build();
   *   Finding response = securityCenterClient.setFindingState(name, state, startTime);
   * }
   * }</pre>
   *
   * @param name Required. The [relative resource
   *     name](https://cloud.google.com/apis/design/resource_names#relative_resource_name) of the
   *     finding. Example:
   *     "organizations/{organization_id}/sources/{source_id}/findings/{finding_id}",
   *     "folders/{folder_id}/sources/{source_id}/findings/{finding_id}",
   *     "projects/{project_id}/sources/{source_id}/findings/{finding_id}".
   * @param state Required. The desired State of the finding.
   * @param startTime Required. The time at which the updated state takes effect.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Finding setFindingState(String name, Finding.State state, Timestamp startTime) {
    SetFindingStateRequest request =
        SetFindingStateRequest.newBuilder()
            .setName(name)
            .setState(state)
            .setStartTime(startTime)
            .build();
    return setFindingState(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the state of a finding.
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
   *           .setStartTime(Timestamp.newBuilder().build())
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
   * Updates the state of a finding.
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
   *           .setStartTime(Timestamp.newBuilder().build())
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
   * Updates the mute state of a finding.
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
   *     finding. Example:
   *     "organizations/{organization_id}/sources/{source_id}/findings/{finding_id}",
   *     "folders/{folder_id}/sources/{source_id}/findings/{finding_id}",
   *     "projects/{project_id}/sources/{source_id}/findings/{finding_id}".
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
   * Updates the mute state of a finding.
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
   *     finding. Example:
   *     "organizations/{organization_id}/sources/{source_id}/findings/{finding_id}",
   *     "folders/{folder_id}/sources/{source_id}/findings/{finding_id}",
   *     "projects/{project_id}/sources/{source_id}/findings/{finding_id}".
   * @param mute Required. The desired state of the Mute.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Finding setMute(String name, Finding.Mute mute) {
    SetMuteRequest request = SetMuteRequest.newBuilder().setName(name).setMute(mute).build();
    return setMute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the mute state of a finding.
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
   * Updates the mute state of a finding.
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
   *           .setResource(
   *               SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString())
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
   *           .setResource(
   *               SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString())
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
   *           .setResource(
   *               SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString())
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
   *           .setResource(
   *               SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString())
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
   * Simulates a given SecurityHealthAnalyticsCustomModule and Resource.
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
   *   String parent = "parent-995424086";
   *   CustomConfig customConfig = CustomConfig.newBuilder().build();
   *   SimulateSecurityHealthAnalyticsCustomModuleRequest.SimulatedResource resource =
   *       SimulateSecurityHealthAnalyticsCustomModuleRequest.SimulatedResource.newBuilder().build();
   *   SimulateSecurityHealthAnalyticsCustomModuleResponse response =
   *       securityCenterClient.simulateSecurityHealthAnalyticsCustomModule(
   *           parent, customConfig, resource);
   * }
   * }</pre>
   *
   * @param parent Required. The relative resource name of the organization, project, or folder. For
   *     more information about relative resource names, see [Relative Resource
   *     Name](https://cloud.google.com/apis/design/resource_names#relative_resource_name) Example:
   *     `organizations/{organization_id}`
   * @param customConfig Required. The custom configuration that you need to test.
   * @param resource Required. Resource data to simulate custom module against.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SimulateSecurityHealthAnalyticsCustomModuleResponse
      simulateSecurityHealthAnalyticsCustomModule(
          String parent,
          CustomConfig customConfig,
          SimulateSecurityHealthAnalyticsCustomModuleRequest.SimulatedResource resource) {
    SimulateSecurityHealthAnalyticsCustomModuleRequest request =
        SimulateSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
            .setParent(parent)
            .setCustomConfig(customConfig)
            .setResource(resource)
            .build();
    return simulateSecurityHealthAnalyticsCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Simulates a given SecurityHealthAnalyticsCustomModule and Resource.
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
   *   SimulateSecurityHealthAnalyticsCustomModuleRequest request =
   *       SimulateSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setCustomConfig(CustomConfig.newBuilder().build())
   *           .setResource(
   *               SimulateSecurityHealthAnalyticsCustomModuleRequest.SimulatedResource.newBuilder()
   *                   .build())
   *           .build();
   *   SimulateSecurityHealthAnalyticsCustomModuleResponse response =
   *       securityCenterClient.simulateSecurityHealthAnalyticsCustomModule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SimulateSecurityHealthAnalyticsCustomModuleResponse
      simulateSecurityHealthAnalyticsCustomModule(
          SimulateSecurityHealthAnalyticsCustomModuleRequest request) {
    return simulateSecurityHealthAnalyticsCustomModuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Simulates a given SecurityHealthAnalyticsCustomModule and Resource.
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
   *   SimulateSecurityHealthAnalyticsCustomModuleRequest request =
   *       SimulateSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setCustomConfig(CustomConfig.newBuilder().build())
   *           .setResource(
   *               SimulateSecurityHealthAnalyticsCustomModuleRequest.SimulatedResource.newBuilder()
   *                   .build())
   *           .build();
   *   ApiFuture<SimulateSecurityHealthAnalyticsCustomModuleResponse> future =
   *       securityCenterClient
   *           .simulateSecurityHealthAnalyticsCustomModuleCallable()
   *           .futureCall(request);
   *   // Do something.
   *   SimulateSecurityHealthAnalyticsCustomModuleResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          SimulateSecurityHealthAnalyticsCustomModuleRequest,
          SimulateSecurityHealthAnalyticsCustomModuleResponse>
      simulateSecurityHealthAnalyticsCustomModuleCallable() {
    return stub.simulateSecurityHealthAnalyticsCustomModuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates external system. This is for a given finding.
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
   * Updates external system. This is for a given finding.
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
   * Updates external system. This is for a given finding.
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
   * Creates or updates a finding. The corresponding source must exist for a finding creation to
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
   *   Finding finding = Finding.newBuilder().build();
   *   Finding response = securityCenterClient.updateFinding(finding);
   * }
   * }</pre>
   *
   * @param finding Required. The finding resource to update or create if it does not already exist.
   *     parent, security_marks, and update_time will be ignored.
   *     <p>In the case of creation, the finding id portion of the name must be alphanumeric and
   *     less than or equal to 32 characters and greater than 0 characters in length.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Finding updateFinding(Finding finding) {
    UpdateFindingRequest request = UpdateFindingRequest.newBuilder().setFinding(finding).build();
    return updateFinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates or updates a finding. The corresponding source must exist for a finding creation to
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
   * Creates or updates a finding. The corresponding source must exist for a finding creation to
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
   * Updates a mute config.
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
   * Updates a mute config.
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
   * Updates a mute config.
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
   *   NotificationConfig response =
   *       securityCenterClient.updateNotificationConfig(notificationConfig);
   * }
   * }</pre>
   *
   * @param notificationConfig Required. The notification config to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationConfig updateNotificationConfig(NotificationConfig notificationConfig) {
    UpdateNotificationConfigRequest request =
        UpdateNotificationConfigRequest.newBuilder()
            .setNotificationConfig(notificationConfig)
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
   * Updates an organization's settings.
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
   *   OrganizationSettings organizationSettings = OrganizationSettings.newBuilder().build();
   *   OrganizationSettings response =
   *       securityCenterClient.updateOrganizationSettings(organizationSettings);
   * }
   * }</pre>
   *
   * @param organizationSettings Required. The organization settings resource to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OrganizationSettings updateOrganizationSettings(
      OrganizationSettings organizationSettings) {
    UpdateOrganizationSettingsRequest request =
        UpdateOrganizationSettingsRequest.newBuilder()
            .setOrganizationSettings(organizationSettings)
            .build();
    return updateOrganizationSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an organization's settings.
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
   *   UpdateOrganizationSettingsRequest request =
   *       UpdateOrganizationSettingsRequest.newBuilder()
   *           .setOrganizationSettings(OrganizationSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OrganizationSettings response = securityCenterClient.updateOrganizationSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OrganizationSettings updateOrganizationSettings(
      UpdateOrganizationSettingsRequest request) {
    return updateOrganizationSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an organization's settings.
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
   *   UpdateOrganizationSettingsRequest request =
   *       UpdateOrganizationSettingsRequest.newBuilder()
   *           .setOrganizationSettings(OrganizationSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<OrganizationSettings> future =
   *       securityCenterClient.updateOrganizationSettingsCallable().futureCall(request);
   *   // Do something.
   *   OrganizationSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateOrganizationSettingsRequest, OrganizationSettings>
      updateOrganizationSettingsCallable() {
    return stub.updateOrganizationSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the SecurityHealthAnalyticsCustomModule under the given name based on the given update
   * mask. Updating the enablement state is supported on both resident and inherited modules (though
   * resident modules cannot have an enablement state of "inherited"). Updating the display name and
   * custom config of a module is supported on resident modules only.
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
   *   SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule =
   *       SecurityHealthAnalyticsCustomModule.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   SecurityHealthAnalyticsCustomModule response =
   *       securityCenterClient.updateSecurityHealthAnalyticsCustomModule(
   *           securityHealthAnalyticsCustomModule, updateMask);
   * }
   * }</pre>
   *
   * @param securityHealthAnalyticsCustomModule Required. The SecurityHealthAnalytics custom module
   *     to update.
   * @param updateMask The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityHealthAnalyticsCustomModule updateSecurityHealthAnalyticsCustomModule(
      SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule,
      FieldMask updateMask) {
    UpdateSecurityHealthAnalyticsCustomModuleRequest request =
        UpdateSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
            .setSecurityHealthAnalyticsCustomModule(securityHealthAnalyticsCustomModule)
            .setUpdateMask(updateMask)
            .build();
    return updateSecurityHealthAnalyticsCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the SecurityHealthAnalyticsCustomModule under the given name based on the given update
   * mask. Updating the enablement state is supported on both resident and inherited modules (though
   * resident modules cannot have an enablement state of "inherited"). Updating the display name and
   * custom config of a module is supported on resident modules only.
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
   *   UpdateSecurityHealthAnalyticsCustomModuleRequest request =
   *       UpdateSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
   *           .setSecurityHealthAnalyticsCustomModule(
   *               SecurityHealthAnalyticsCustomModule.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   SecurityHealthAnalyticsCustomModule response =
   *       securityCenterClient.updateSecurityHealthAnalyticsCustomModule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityHealthAnalyticsCustomModule updateSecurityHealthAnalyticsCustomModule(
      UpdateSecurityHealthAnalyticsCustomModuleRequest request) {
    return updateSecurityHealthAnalyticsCustomModuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the SecurityHealthAnalyticsCustomModule under the given name based on the given update
   * mask. Updating the enablement state is supported on both resident and inherited modules (though
   * resident modules cannot have an enablement state of "inherited"). Updating the display name and
   * custom config of a module is supported on resident modules only.
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
   *   UpdateSecurityHealthAnalyticsCustomModuleRequest request =
   *       UpdateSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
   *           .setSecurityHealthAnalyticsCustomModule(
   *               SecurityHealthAnalyticsCustomModule.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<SecurityHealthAnalyticsCustomModule> future =
   *       securityCenterClient
   *           .updateSecurityHealthAnalyticsCustomModuleCallable()
   *           .futureCall(request);
   *   // Do something.
   *   SecurityHealthAnalyticsCustomModule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          UpdateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      updateSecurityHealthAnalyticsCustomModuleCallable() {
    return stub.updateSecurityHealthAnalyticsCustomModuleCallable();
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
   *   Source response = securityCenterClient.updateSource(source);
   * }
   * }</pre>
   *
   * @param source Required. The source resource to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Source updateSource(Source source) {
    UpdateSourceRequest request = UpdateSourceRequest.newBuilder().setSource(source).build();
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates security marks.
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
   *   SecurityMarks response = securityCenterClient.updateSecurityMarks(securityMarks);
   * }
   * }</pre>
   *
   * @param securityMarks Required. The security marks resource to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityMarks updateSecurityMarks(SecurityMarks securityMarks) {
    UpdateSecurityMarksRequest request =
        UpdateSecurityMarksRequest.newBuilder().setSecurityMarks(securityMarks).build();
    return updateSecurityMarks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates security marks.
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
   *           .setStartTime(Timestamp.newBuilder().build())
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
   * Updates security marks.
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
   *           .setStartTime(Timestamp.newBuilder().build())
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
   *   FolderName parent = FolderName.of("[FOLDER]");
   *   BigQueryExport bigQueryExport = BigQueryExport.newBuilder().build();
   *   String bigQueryExportId = "bigQueryExportId1024198583";
   *   BigQueryExport response =
   *       securityCenterClient.createBigQueryExport(parent, bigQueryExport, bigQueryExportId);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource of the new BigQuery export. Its format
   *     is "organizations/[organization_id]", "folders/[folder_id]", or "projects/[project_id]".
   * @param bigQueryExport Required. The BigQuery export being created.
   * @param bigQueryExportId Required. Unique identifier provided by the client within the parent
   *     scope. It must consist of only lowercase letters, numbers, and hyphens, must start with a
   *     letter, must end with either a letter or a number, and must be 63 characters or less.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BigQueryExport createBigQueryExport(
      FolderName parent, BigQueryExport bigQueryExport, String bigQueryExportId) {
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
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   BigQueryExport bigQueryExport = BigQueryExport.newBuilder().build();
   *   String bigQueryExportId = "bigQueryExportId1024198583";
   *   BigQueryExport response =
   *       securityCenterClient.createBigQueryExport(parent, bigQueryExport, bigQueryExportId);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource of the new BigQuery export. Its format
   *     is "organizations/[organization_id]", "folders/[folder_id]", or "projects/[project_id]".
   * @param bigQueryExport Required. The BigQuery export being created.
   * @param bigQueryExportId Required. Unique identifier provided by the client within the parent
   *     scope. It must consist of only lowercase letters, numbers, and hyphens, must start with a
   *     letter, must end with either a letter or a number, and must be 63 characters or less.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BigQueryExport createBigQueryExport(
      OrganizationName parent, BigQueryExport bigQueryExport, String bigQueryExportId) {
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
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   BigQueryExport bigQueryExport = BigQueryExport.newBuilder().build();
   *   String bigQueryExportId = "bigQueryExportId1024198583";
   *   BigQueryExport response =
   *       securityCenterClient.createBigQueryExport(parent, bigQueryExport, bigQueryExportId);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource of the new BigQuery export. Its format
   *     is "organizations/[organization_id]", "folders/[folder_id]", or "projects/[project_id]".
   * @param bigQueryExport Required. The BigQuery export being created.
   * @param bigQueryExportId Required. Unique identifier provided by the client within the parent
   *     scope. It must consist of only lowercase letters, numbers, and hyphens, must start with a
   *     letter, must end with either a letter or a number, and must be 63 characters or less.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BigQueryExport createBigQueryExport(
      ProjectName parent, BigQueryExport bigQueryExport, String bigQueryExportId) {
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
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   BigQueryExport bigQueryExport = BigQueryExport.newBuilder().build();
   *   String bigQueryExportId = "bigQueryExportId1024198583";
   *   BigQueryExport response =
   *       securityCenterClient.createBigQueryExport(parent, bigQueryExport, bigQueryExportId);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource of the new BigQuery export. Its format
   *     is "organizations/[organization_id]", "folders/[folder_id]", or "projects/[project_id]".
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
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
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
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
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
   *       BigQueryExportName.ofOrganizationExportName("[ORGANIZATION]", "[EXPORT]");
   *   securityCenterClient.deleteBigQueryExport(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the BigQuery export to delete. Its format is
   *     organizations/{organization}/bigQueryExports/{export_id},
   *     folders/{folder}/bigQueryExports/{export_id}, or
   *     projects/{project}/bigQueryExports/{export_id}
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
   *       BigQueryExportName.ofOrganizationExportName("[ORGANIZATION]", "[EXPORT]").toString();
   *   securityCenterClient.deleteBigQueryExport(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the BigQuery export to delete. Its format is
   *     organizations/{organization}/bigQueryExports/{export_id},
   *     folders/{folder}/bigQueryExports/{export_id}, or
   *     projects/{project}/bigQueryExports/{export_id}
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
   *               BigQueryExportName.ofOrganizationExportName("[ORGANIZATION]", "[EXPORT]")
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
   *               BigQueryExportName.ofOrganizationExportName("[ORGANIZATION]", "[EXPORT]")
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
   *   FolderName parent = FolderName.of("[FOLDER]");
   *   for (BigQueryExport element : securityCenterClient.listBigQueryExports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns the collection of BigQuery exports. Its format
   *     is "organizations/[organization_id]", "folders/[folder_id]", "projects/[project_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBigQueryExportsPagedResponse listBigQueryExports(FolderName parent) {
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
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   for (BigQueryExport element : securityCenterClient.listBigQueryExports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns the collection of BigQuery exports. Its format
   *     is "organizations/[organization_id]", "folders/[folder_id]", "projects/[project_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBigQueryExportsPagedResponse listBigQueryExports(OrganizationName parent) {
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
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (BigQueryExport element : securityCenterClient.listBigQueryExports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns the collection of BigQuery exports. Its format
   *     is "organizations/[organization_id]", "folders/[folder_id]", "projects/[project_id]".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBigQueryExportsPagedResponse listBigQueryExports(ProjectName parent) {
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
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   for (BigQueryExport element : securityCenterClient.listBigQueryExports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns the collection of BigQuery exports. Its format
   *     is "organizations/[organization_id]", "folders/[folder_id]", "projects/[project_id]".
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
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
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
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
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
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
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

  public static class GroupAssetsPagedResponse
      extends AbstractPagedListResponse<
          GroupAssetsRequest,
          GroupAssetsResponse,
          GroupResult,
          GroupAssetsPage,
          GroupAssetsFixedSizeCollection> {

    public static ApiFuture<GroupAssetsPagedResponse> createAsync(
        PageContext<GroupAssetsRequest, GroupAssetsResponse, GroupResult> context,
        ApiFuture<GroupAssetsResponse> futureResponse) {
      ApiFuture<GroupAssetsPage> futurePage =
          GroupAssetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new GroupAssetsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private GroupAssetsPagedResponse(GroupAssetsPage page) {
      super(page, GroupAssetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class GroupAssetsPage
      extends AbstractPage<GroupAssetsRequest, GroupAssetsResponse, GroupResult, GroupAssetsPage> {

    private GroupAssetsPage(
        PageContext<GroupAssetsRequest, GroupAssetsResponse, GroupResult> context,
        GroupAssetsResponse response) {
      super(context, response);
    }

    private static GroupAssetsPage createEmptyPage() {
      return new GroupAssetsPage(null, null);
    }

    @Override
    protected GroupAssetsPage createPage(
        PageContext<GroupAssetsRequest, GroupAssetsResponse, GroupResult> context,
        GroupAssetsResponse response) {
      return new GroupAssetsPage(context, response);
    }

    @Override
    public ApiFuture<GroupAssetsPage> createPageAsync(
        PageContext<GroupAssetsRequest, GroupAssetsResponse, GroupResult> context,
        ApiFuture<GroupAssetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class GroupAssetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          GroupAssetsRequest,
          GroupAssetsResponse,
          GroupResult,
          GroupAssetsPage,
          GroupAssetsFixedSizeCollection> {

    private GroupAssetsFixedSizeCollection(List<GroupAssetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static GroupAssetsFixedSizeCollection createEmptyCollection() {
      return new GroupAssetsFixedSizeCollection(null, 0);
    }

    @Override
    protected GroupAssetsFixedSizeCollection createCollection(
        List<GroupAssetsPage> pages, int collectionSize) {
      return new GroupAssetsFixedSizeCollection(pages, collectionSize);
    }
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

  public static class ListAssetsPagedResponse
      extends AbstractPagedListResponse<
          ListAssetsRequest,
          ListAssetsResponse,
          ListAssetsResponse.ListAssetsResult,
          ListAssetsPage,
          ListAssetsFixedSizeCollection> {

    public static ApiFuture<ListAssetsPagedResponse> createAsync(
        PageContext<ListAssetsRequest, ListAssetsResponse, ListAssetsResponse.ListAssetsResult>
            context,
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
      extends AbstractPage<
          ListAssetsRequest,
          ListAssetsResponse,
          ListAssetsResponse.ListAssetsResult,
          ListAssetsPage> {

    private ListAssetsPage(
        PageContext<ListAssetsRequest, ListAssetsResponse, ListAssetsResponse.ListAssetsResult>
            context,
        ListAssetsResponse response) {
      super(context, response);
    }

    private static ListAssetsPage createEmptyPage() {
      return new ListAssetsPage(null, null);
    }

    @Override
    protected ListAssetsPage createPage(
        PageContext<ListAssetsRequest, ListAssetsResponse, ListAssetsResponse.ListAssetsResult>
            context,
        ListAssetsResponse response) {
      return new ListAssetsPage(context, response);
    }

    @Override
    public ApiFuture<ListAssetsPage> createPageAsync(
        PageContext<ListAssetsRequest, ListAssetsResponse, ListAssetsResponse.ListAssetsResult>
            context,
        ApiFuture<ListAssetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAssetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAssetsRequest,
          ListAssetsResponse,
          ListAssetsResponse.ListAssetsResult,
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

  public static class ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse
      extends AbstractPagedListResponse<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesResponse,
          SecurityHealthAnalyticsCustomModule,
          ListDescendantSecurityHealthAnalyticsCustomModulesPage,
          ListDescendantSecurityHealthAnalyticsCustomModulesFixedSizeCollection> {

    public static ApiFuture<ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse>
        createAsync(
            PageContext<
                    ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
                    ListDescendantSecurityHealthAnalyticsCustomModulesResponse,
                    SecurityHealthAnalyticsCustomModule>
                context,
            ApiFuture<ListDescendantSecurityHealthAnalyticsCustomModulesResponse> futureResponse) {
      ApiFuture<ListDescendantSecurityHealthAnalyticsCustomModulesPage> futurePage =
          ListDescendantSecurityHealthAnalyticsCustomModulesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse(
        ListDescendantSecurityHealthAnalyticsCustomModulesPage page) {
      super(
          page,
          ListDescendantSecurityHealthAnalyticsCustomModulesFixedSizeCollection
              .createEmptyCollection());
    }
  }

  public static class ListDescendantSecurityHealthAnalyticsCustomModulesPage
      extends AbstractPage<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesResponse,
          SecurityHealthAnalyticsCustomModule,
          ListDescendantSecurityHealthAnalyticsCustomModulesPage> {

    private ListDescendantSecurityHealthAnalyticsCustomModulesPage(
        PageContext<
                ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
                ListDescendantSecurityHealthAnalyticsCustomModulesResponse,
                SecurityHealthAnalyticsCustomModule>
            context,
        ListDescendantSecurityHealthAnalyticsCustomModulesResponse response) {
      super(context, response);
    }

    private static ListDescendantSecurityHealthAnalyticsCustomModulesPage createEmptyPage() {
      return new ListDescendantSecurityHealthAnalyticsCustomModulesPage(null, null);
    }

    @Override
    protected ListDescendantSecurityHealthAnalyticsCustomModulesPage createPage(
        PageContext<
                ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
                ListDescendantSecurityHealthAnalyticsCustomModulesResponse,
                SecurityHealthAnalyticsCustomModule>
            context,
        ListDescendantSecurityHealthAnalyticsCustomModulesResponse response) {
      return new ListDescendantSecurityHealthAnalyticsCustomModulesPage(context, response);
    }

    @Override
    public ApiFuture<ListDescendantSecurityHealthAnalyticsCustomModulesPage> createPageAsync(
        PageContext<
                ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
                ListDescendantSecurityHealthAnalyticsCustomModulesResponse,
                SecurityHealthAnalyticsCustomModule>
            context,
        ApiFuture<ListDescendantSecurityHealthAnalyticsCustomModulesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDescendantSecurityHealthAnalyticsCustomModulesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesResponse,
          SecurityHealthAnalyticsCustomModule,
          ListDescendantSecurityHealthAnalyticsCustomModulesPage,
          ListDescendantSecurityHealthAnalyticsCustomModulesFixedSizeCollection> {

    private ListDescendantSecurityHealthAnalyticsCustomModulesFixedSizeCollection(
        List<ListDescendantSecurityHealthAnalyticsCustomModulesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDescendantSecurityHealthAnalyticsCustomModulesFixedSizeCollection
        createEmptyCollection() {
      return new ListDescendantSecurityHealthAnalyticsCustomModulesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDescendantSecurityHealthAnalyticsCustomModulesFixedSizeCollection
        createCollection(
            List<ListDescendantSecurityHealthAnalyticsCustomModulesPage> pages,
            int collectionSize) {
      return new ListDescendantSecurityHealthAnalyticsCustomModulesFixedSizeCollection(
          pages, collectionSize);
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

  public static class ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse
      extends AbstractPagedListResponse<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesResponse,
          EffectiveSecurityHealthAnalyticsCustomModule,
          ListEffectiveSecurityHealthAnalyticsCustomModulesPage,
          ListEffectiveSecurityHealthAnalyticsCustomModulesFixedSizeCollection> {

    public static ApiFuture<ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse>
        createAsync(
            PageContext<
                    ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
                    ListEffectiveSecurityHealthAnalyticsCustomModulesResponse,
                    EffectiveSecurityHealthAnalyticsCustomModule>
                context,
            ApiFuture<ListEffectiveSecurityHealthAnalyticsCustomModulesResponse> futureResponse) {
      ApiFuture<ListEffectiveSecurityHealthAnalyticsCustomModulesPage> futurePage =
          ListEffectiveSecurityHealthAnalyticsCustomModulesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse(
        ListEffectiveSecurityHealthAnalyticsCustomModulesPage page) {
      super(
          page,
          ListEffectiveSecurityHealthAnalyticsCustomModulesFixedSizeCollection
              .createEmptyCollection());
    }
  }

  public static class ListEffectiveSecurityHealthAnalyticsCustomModulesPage
      extends AbstractPage<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesResponse,
          EffectiveSecurityHealthAnalyticsCustomModule,
          ListEffectiveSecurityHealthAnalyticsCustomModulesPage> {

    private ListEffectiveSecurityHealthAnalyticsCustomModulesPage(
        PageContext<
                ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
                ListEffectiveSecurityHealthAnalyticsCustomModulesResponse,
                EffectiveSecurityHealthAnalyticsCustomModule>
            context,
        ListEffectiveSecurityHealthAnalyticsCustomModulesResponse response) {
      super(context, response);
    }

    private static ListEffectiveSecurityHealthAnalyticsCustomModulesPage createEmptyPage() {
      return new ListEffectiveSecurityHealthAnalyticsCustomModulesPage(null, null);
    }

    @Override
    protected ListEffectiveSecurityHealthAnalyticsCustomModulesPage createPage(
        PageContext<
                ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
                ListEffectiveSecurityHealthAnalyticsCustomModulesResponse,
                EffectiveSecurityHealthAnalyticsCustomModule>
            context,
        ListEffectiveSecurityHealthAnalyticsCustomModulesResponse response) {
      return new ListEffectiveSecurityHealthAnalyticsCustomModulesPage(context, response);
    }

    @Override
    public ApiFuture<ListEffectiveSecurityHealthAnalyticsCustomModulesPage> createPageAsync(
        PageContext<
                ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
                ListEffectiveSecurityHealthAnalyticsCustomModulesResponse,
                EffectiveSecurityHealthAnalyticsCustomModule>
            context,
        ApiFuture<ListEffectiveSecurityHealthAnalyticsCustomModulesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEffectiveSecurityHealthAnalyticsCustomModulesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesResponse,
          EffectiveSecurityHealthAnalyticsCustomModule,
          ListEffectiveSecurityHealthAnalyticsCustomModulesPage,
          ListEffectiveSecurityHealthAnalyticsCustomModulesFixedSizeCollection> {

    private ListEffectiveSecurityHealthAnalyticsCustomModulesFixedSizeCollection(
        List<ListEffectiveSecurityHealthAnalyticsCustomModulesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEffectiveSecurityHealthAnalyticsCustomModulesFixedSizeCollection
        createEmptyCollection() {
      return new ListEffectiveSecurityHealthAnalyticsCustomModulesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEffectiveSecurityHealthAnalyticsCustomModulesFixedSizeCollection createCollection(
        List<ListEffectiveSecurityHealthAnalyticsCustomModulesPage> pages, int collectionSize) {
      return new ListEffectiveSecurityHealthAnalyticsCustomModulesFixedSizeCollection(
          pages, collectionSize);
    }
  }

  public static class ListSecurityHealthAnalyticsCustomModulesPagedResponse
      extends AbstractPagedListResponse<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesResponse,
          SecurityHealthAnalyticsCustomModule,
          ListSecurityHealthAnalyticsCustomModulesPage,
          ListSecurityHealthAnalyticsCustomModulesFixedSizeCollection> {

    public static ApiFuture<ListSecurityHealthAnalyticsCustomModulesPagedResponse> createAsync(
        PageContext<
                ListSecurityHealthAnalyticsCustomModulesRequest,
                ListSecurityHealthAnalyticsCustomModulesResponse,
                SecurityHealthAnalyticsCustomModule>
            context,
        ApiFuture<ListSecurityHealthAnalyticsCustomModulesResponse> futureResponse) {
      ApiFuture<ListSecurityHealthAnalyticsCustomModulesPage> futurePage =
          ListSecurityHealthAnalyticsCustomModulesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSecurityHealthAnalyticsCustomModulesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSecurityHealthAnalyticsCustomModulesPagedResponse(
        ListSecurityHealthAnalyticsCustomModulesPage page) {
      super(
          page,
          ListSecurityHealthAnalyticsCustomModulesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSecurityHealthAnalyticsCustomModulesPage
      extends AbstractPage<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesResponse,
          SecurityHealthAnalyticsCustomModule,
          ListSecurityHealthAnalyticsCustomModulesPage> {

    private ListSecurityHealthAnalyticsCustomModulesPage(
        PageContext<
                ListSecurityHealthAnalyticsCustomModulesRequest,
                ListSecurityHealthAnalyticsCustomModulesResponse,
                SecurityHealthAnalyticsCustomModule>
            context,
        ListSecurityHealthAnalyticsCustomModulesResponse response) {
      super(context, response);
    }

    private static ListSecurityHealthAnalyticsCustomModulesPage createEmptyPage() {
      return new ListSecurityHealthAnalyticsCustomModulesPage(null, null);
    }

    @Override
    protected ListSecurityHealthAnalyticsCustomModulesPage createPage(
        PageContext<
                ListSecurityHealthAnalyticsCustomModulesRequest,
                ListSecurityHealthAnalyticsCustomModulesResponse,
                SecurityHealthAnalyticsCustomModule>
            context,
        ListSecurityHealthAnalyticsCustomModulesResponse response) {
      return new ListSecurityHealthAnalyticsCustomModulesPage(context, response);
    }

    @Override
    public ApiFuture<ListSecurityHealthAnalyticsCustomModulesPage> createPageAsync(
        PageContext<
                ListSecurityHealthAnalyticsCustomModulesRequest,
                ListSecurityHealthAnalyticsCustomModulesResponse,
                SecurityHealthAnalyticsCustomModule>
            context,
        ApiFuture<ListSecurityHealthAnalyticsCustomModulesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSecurityHealthAnalyticsCustomModulesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesResponse,
          SecurityHealthAnalyticsCustomModule,
          ListSecurityHealthAnalyticsCustomModulesPage,
          ListSecurityHealthAnalyticsCustomModulesFixedSizeCollection> {

    private ListSecurityHealthAnalyticsCustomModulesFixedSizeCollection(
        List<ListSecurityHealthAnalyticsCustomModulesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSecurityHealthAnalyticsCustomModulesFixedSizeCollection
        createEmptyCollection() {
      return new ListSecurityHealthAnalyticsCustomModulesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSecurityHealthAnalyticsCustomModulesFixedSizeCollection createCollection(
        List<ListSecurityHealthAnalyticsCustomModulesPage> pages, int collectionSize) {
      return new ListSecurityHealthAnalyticsCustomModulesFixedSizeCollection(pages, collectionSize);
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
}
