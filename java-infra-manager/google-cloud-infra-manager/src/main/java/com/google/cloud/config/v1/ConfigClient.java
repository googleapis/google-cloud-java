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

package com.google.cloud.config.v1;

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
import com.google.cloud.config.v1.stub.ConfigStub;
import com.google.cloud.config.v1.stub.ConfigStubSettings;
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
 * Service Description: Infrastructure Manager is a managed service that automates the deployment
 * and management of Google Cloud infrastructure resources.
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
 * try (ConfigClient configClient = ConfigClient.create()) {
 *   DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
 *   Deployment response = configClient.getDeployment(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ConfigClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListDeployments</td>
 *      <td><p> Lists [Deployment][google.cloud.config.v1.Deployment]s in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDeployments(ListDeploymentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDeployments(LocationName parent)
 *           <li><p> listDeployments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDeploymentsPagedCallable()
 *           <li><p> listDeploymentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDeployment</td>
 *      <td><p> Gets details about a [Deployment][google.cloud.config.v1.Deployment].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDeployment(GetDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDeployment(DeploymentName name)
 *           <li><p> getDeployment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDeployment</td>
 *      <td><p> Creates a [Deployment][google.cloud.config.v1.Deployment].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDeploymentAsync(CreateDeploymentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createDeploymentAsync(LocationName parent, Deployment deployment, String deploymentId)
 *           <li><p> createDeploymentAsync(String parent, Deployment deployment, String deploymentId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDeploymentOperationCallable()
 *           <li><p> createDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDeployment</td>
 *      <td><p> Updates a [Deployment][google.cloud.config.v1.Deployment].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDeploymentAsync(UpdateDeploymentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateDeploymentAsync(Deployment deployment, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDeploymentOperationCallable()
 *           <li><p> updateDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDeployment</td>
 *      <td><p> Deletes a [Deployment][google.cloud.config.v1.Deployment].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDeploymentAsync(DeleteDeploymentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteDeploymentAsync(DeploymentName name)
 *           <li><p> deleteDeploymentAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDeploymentOperationCallable()
 *           <li><p> deleteDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRevisions</td>
 *      <td><p> Lists [Revision][google.cloud.config.v1.Revision]s of a deployment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRevisions(ListRevisionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRevisions(DeploymentName parent)
 *           <li><p> listRevisions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRevisionsPagedCallable()
 *           <li><p> listRevisionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRevision</td>
 *      <td><p> Gets details about a [Revision][google.cloud.config.v1.Revision].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRevision(GetRevisionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRevision(RevisionName name)
 *           <li><p> getRevision(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRevisionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetResource</td>
 *      <td><p> Gets details about a [Resource][google.cloud.config.v1.Resource] deployed by Infra Manager.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getResource(GetResourceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getResource(ResourceName name)
 *           <li><p> getResource(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getResourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListResources</td>
 *      <td><p> Lists [Resources][google.cloud.config.v1.Resource] in a given revision.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listResources(ListResourcesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listResources(RevisionName parent)
 *           <li><p> listResources(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listResourcesPagedCallable()
 *           <li><p> listResourcesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportDeploymentStatefile</td>
 *      <td><p> Exports Terraform state file from a given deployment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportDeploymentStatefile(ExportDeploymentStatefileRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportDeploymentStatefileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportRevisionStatefile</td>
 *      <td><p> Exports Terraform state file from a given revision.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportRevisionStatefile(ExportRevisionStatefileRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportRevisionStatefileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ImportStatefile</td>
 *      <td><p> Imports Terraform state file in a given deployment. The state file does not take effect until the Deployment has been unlocked.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> importStatefile(ImportStatefileRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> importStatefile(DeploymentName parent, long lockId)
 *           <li><p> importStatefile(String parent, long lockId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> importStatefileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteStatefile</td>
 *      <td><p> Deletes Terraform state file in a given deployment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteStatefile(DeleteStatefileRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteStatefile(DeploymentName name)
 *           <li><p> deleteStatefile(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteStatefileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> LockDeployment</td>
 *      <td><p> Locks a deployment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> lockDeploymentAsync(LockDeploymentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> lockDeploymentAsync(DeploymentName name)
 *           <li><p> lockDeploymentAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> lockDeploymentOperationCallable()
 *           <li><p> lockDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UnlockDeployment</td>
 *      <td><p> Unlocks a locked deployment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> unlockDeploymentAsync(UnlockDeploymentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> unlockDeploymentAsync(DeploymentName name, long lockId)
 *           <li><p> unlockDeploymentAsync(String name, long lockId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> unlockDeploymentOperationCallable()
 *           <li><p> unlockDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportLockInfo</td>
 *      <td><p> Exports the lock info on a locked deployment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportLockInfo(ExportLockInfoRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> exportLockInfo(DeploymentName name)
 *           <li><p> exportLockInfo(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportLockInfoCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreatePreview</td>
 *      <td><p> Creates a [Preview][google.cloud.config.v1.Preview].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createPreviewAsync(CreatePreviewRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createPreviewAsync(LocationName parent, Preview preview)
 *           <li><p> createPreviewAsync(String parent, Preview preview)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createPreviewOperationCallable()
 *           <li><p> createPreviewCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPreview</td>
 *      <td><p> Gets details about a [Preview][google.cloud.config.v1.Preview].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPreview(GetPreviewRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPreview(PreviewName name)
 *           <li><p> getPreview(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPreviewCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPreviews</td>
 *      <td><p> Lists [Preview][google.cloud.config.v1.Preview]s in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPreviews(ListPreviewsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPreviews(LocationName parent)
 *           <li><p> listPreviews(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPreviewsPagedCallable()
 *           <li><p> listPreviewsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeletePreview</td>
 *      <td><p> Deletes a [Preview][google.cloud.config.v1.Preview].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deletePreviewAsync(DeletePreviewRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deletePreviewAsync(PreviewName name)
 *           <li><p> deletePreviewAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deletePreviewOperationCallable()
 *           <li><p> deletePreviewCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportPreviewResult</td>
 *      <td><p> Export [Preview][google.cloud.config.v1.Preview] results.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportPreviewResult(ExportPreviewResultRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportPreviewResultCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTerraformVersions</td>
 *      <td><p> Lists [TerraformVersion][google.cloud.config.v1.TerraformVersion]s in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTerraformVersions(ListTerraformVersionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTerraformVersions(LocationName parent)
 *           <li><p> listTerraformVersions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTerraformVersionsPagedCallable()
 *           <li><p> listTerraformVersionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetTerraformVersion</td>
 *      <td><p> Gets details about a [TerraformVersion][google.cloud.config.v1.TerraformVersion].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTerraformVersion(GetTerraformVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTerraformVersion(TerraformVersionName name)
 *           <li><p> getTerraformVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTerraformVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListResourceChanges</td>
 *      <td><p> Lists ResourceChanges for a given preview.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listResourceChanges(ListResourceChangesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listResourceChanges(PreviewName parent)
 *           <li><p> listResourceChanges(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listResourceChangesPagedCallable()
 *           <li><p> listResourceChangesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetResourceChange</td>
 *      <td><p> Get a ResourceChange for a given preview.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getResourceChange(GetResourceChangeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getResourceChange(ResourceChangeName name)
 *           <li><p> getResourceChange(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getResourceChangeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListResourceDrifts</td>
 *      <td><p> List ResourceDrifts for a given preview.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listResourceDrifts(ListResourceDriftsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listResourceDrifts(PreviewName parent)
 *           <li><p> listResourceDrifts(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listResourceDriftsPagedCallable()
 *           <li><p> listResourceDriftsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetResourceDrift</td>
 *      <td><p> Get a ResourceDrift for a given preview.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getResourceDrift(GetResourceDriftRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getResourceDrift(ResourceDriftName name)
 *           <li><p> getResourceDrift(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getResourceDriftCallable()
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
 * <p>This class can be customized by passing in a custom instance of ConfigSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConfigSettings configSettings =
 *     ConfigSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ConfigClient configClient = ConfigClient.create(configSettings);
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
 * ConfigSettings configSettings = ConfigSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ConfigClient configClient = ConfigClient.create(configSettings);
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
 * ConfigSettings configSettings = ConfigSettings.newHttpJsonBuilder().build();
 * ConfigClient configClient = ConfigClient.create(configSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ConfigClient implements BackgroundResource {
  private final ConfigSettings settings;
  private final ConfigStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of ConfigClient with default settings. */
  public static final ConfigClient create() throws IOException {
    return create(ConfigSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ConfigClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ConfigClient create(ConfigSettings settings) throws IOException {
    return new ConfigClient(settings);
  }

  /**
   * Constructs an instance of ConfigClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(ConfigSettings).
   */
  public static final ConfigClient create(ConfigStub stub) {
    return new ConfigClient(stub);
  }

  /**
   * Constructs an instance of ConfigClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected ConfigClient(ConfigSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ConfigStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ConfigClient(ConfigStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ConfigSettings getSettings() {
    return settings;
  }

  public ConfigStub getStub() {
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
   * Lists [Deployment][google.cloud.config.v1.Deployment]s in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Deployment element : configClient.listDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the Deployments are listed. The parent
   *     value is in the format: 'projects/{project_id}/locations/{location}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeploymentsPagedResponse listDeployments(LocationName parent) {
    ListDeploymentsRequest request =
        ListDeploymentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Deployment][google.cloud.config.v1.Deployment]s in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Deployment element : configClient.listDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the Deployments are listed. The parent
   *     value is in the format: 'projects/{project_id}/locations/{location}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeploymentsPagedResponse listDeployments(String parent) {
    ListDeploymentsRequest request = ListDeploymentsRequest.newBuilder().setParent(parent).build();
    return listDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Deployment][google.cloud.config.v1.Deployment]s in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListDeploymentsRequest request =
   *       ListDeploymentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Deployment element : configClient.listDeployments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeploymentsPagedResponse listDeployments(ListDeploymentsRequest request) {
    return listDeploymentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Deployment][google.cloud.config.v1.Deployment]s in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListDeploymentsRequest request =
   *       ListDeploymentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Deployment> future =
   *       configClient.listDeploymentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Deployment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable() {
    return stub.listDeploymentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Deployment][google.cloud.config.v1.Deployment]s in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListDeploymentsRequest request =
   *       ListDeploymentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDeploymentsResponse response = configClient.listDeploymentsCallable().call(request);
   *     for (Deployment element : response.getDeploymentsList()) {
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
  public final UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse>
      listDeploymentsCallable() {
    return stub.listDeploymentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
   *   Deployment response = configClient.getDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment. Format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment getDeployment(DeploymentName name) {
    GetDeploymentRequest request =
        GetDeploymentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString();
   *   Deployment response = configClient.getDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment. Format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment getDeployment(String name) {
    GetDeploymentRequest request = GetDeploymentRequest.newBuilder().setName(name).build();
    return getDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetDeploymentRequest request =
   *       GetDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .build();
   *   Deployment response = configClient.getDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment getDeployment(GetDeploymentRequest request) {
    return getDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetDeploymentRequest request =
   *       GetDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .build();
   *   ApiFuture<Deployment> future = configClient.getDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Deployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable() {
    return stub.getDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Deployment deployment = Deployment.newBuilder().build();
   *   String deploymentId = "deploymentId-136894784";
   *   Deployment response =
   *       configClient.createDeploymentAsync(parent, deployment, deploymentId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the Deployment is created. The parent value
   *     is in the format: 'projects/{project_id}/locations/{location}'.
   * @param deployment Required. [Deployment][google.cloud.config.v1.Deployment] resource to be
   *     created.
   * @param deploymentId Required. The Deployment ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> createDeploymentAsync(
      LocationName parent, Deployment deployment, String deploymentId) {
    CreateDeploymentRequest request =
        CreateDeploymentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDeployment(deployment)
            .setDeploymentId(deploymentId)
            .build();
    return createDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Deployment deployment = Deployment.newBuilder().build();
   *   String deploymentId = "deploymentId-136894784";
   *   Deployment response =
   *       configClient.createDeploymentAsync(parent, deployment, deploymentId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the Deployment is created. The parent value
   *     is in the format: 'projects/{project_id}/locations/{location}'.
   * @param deployment Required. [Deployment][google.cloud.config.v1.Deployment] resource to be
   *     created.
   * @param deploymentId Required. The Deployment ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> createDeploymentAsync(
      String parent, Deployment deployment, String deploymentId) {
    CreateDeploymentRequest request =
        CreateDeploymentRequest.newBuilder()
            .setParent(parent)
            .setDeployment(deployment)
            .setDeploymentId(deploymentId)
            .build();
    return createDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreateDeploymentRequest request =
   *       CreateDeploymentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDeploymentId("deploymentId-136894784")
   *           .setDeployment(Deployment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Deployment response = configClient.createDeploymentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> createDeploymentAsync(
      CreateDeploymentRequest request) {
    return createDeploymentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreateDeploymentRequest request =
   *       CreateDeploymentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDeploymentId("deploymentId-136894784")
   *           .setDeployment(Deployment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Deployment, OperationMetadata> future =
   *       configClient.createDeploymentOperationCallable().futureCall(request);
   *   // Do something.
   *   Deployment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateDeploymentRequest, Deployment, OperationMetadata>
      createDeploymentOperationCallable() {
    return stub.createDeploymentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreateDeploymentRequest request =
   *       CreateDeploymentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDeploymentId("deploymentId-136894784")
   *           .setDeployment(Deployment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = configClient.createDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDeploymentRequest, Operation> createDeploymentCallable() {
    return stub.createDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   Deployment deployment = Deployment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Deployment response = configClient.updateDeploymentAsync(deployment, updateMask).get();
   * }
   * }</pre>
   *
   * @param deployment Required. [Deployment][google.cloud.config.v1.Deployment] to update.
   *     <p>The deployment's `name` field is used to identify the resource to be updated. Format:
   *     `projects/{project}/locations/{location}/deployments/{deployment}`
   * @param updateMask Optional. Field mask used to specify the fields to be overwritten in the
   *     Deployment resource by the update.
   *     <p>The fields specified in the update_mask are relative to the resource, not the full
   *     request. A field will be overwritten if it is in the mask. If the user does not provide a
   *     mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> updateDeploymentAsync(
      Deployment deployment, FieldMask updateMask) {
    UpdateDeploymentRequest request =
        UpdateDeploymentRequest.newBuilder()
            .setDeployment(deployment)
            .setUpdateMask(updateMask)
            .build();
    return updateDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UpdateDeploymentRequest request =
   *       UpdateDeploymentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDeployment(Deployment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Deployment response = configClient.updateDeploymentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> updateDeploymentAsync(
      UpdateDeploymentRequest request) {
    return updateDeploymentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UpdateDeploymentRequest request =
   *       UpdateDeploymentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDeployment(Deployment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Deployment, OperationMetadata> future =
   *       configClient.updateDeploymentOperationCallable().futureCall(request);
   *   // Do something.
   *   Deployment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateDeploymentRequest, Deployment, OperationMetadata>
      updateDeploymentOperationCallable() {
    return stub.updateDeploymentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UpdateDeploymentRequest request =
   *       UpdateDeploymentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDeployment(Deployment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = configClient.updateDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDeploymentRequest, Operation> updateDeploymentCallable() {
    return stub.updateDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
   *   Deployment response = configClient.deleteDeploymentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Deployment in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> deleteDeploymentAsync(
      DeploymentName name) {
    DeleteDeploymentRequest request =
        DeleteDeploymentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString();
   *   Deployment response = configClient.deleteDeploymentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Deployment in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> deleteDeploymentAsync(String name) {
    DeleteDeploymentRequest request = DeleteDeploymentRequest.newBuilder().setName(name).build();
    return deleteDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeleteDeploymentRequest request =
   *       DeleteDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   Deployment response = configClient.deleteDeploymentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> deleteDeploymentAsync(
      DeleteDeploymentRequest request) {
    return deleteDeploymentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeleteDeploymentRequest request =
   *       DeleteDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Deployment, OperationMetadata> future =
   *       configClient.deleteDeploymentOperationCallable().futureCall(request);
   *   // Do something.
   *   Deployment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDeploymentRequest, Deployment, OperationMetadata>
      deleteDeploymentOperationCallable() {
    return stub.deleteDeploymentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeleteDeploymentRequest request =
   *       DeleteDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future = configClient.deleteDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDeploymentRequest, Operation> deleteDeploymentCallable() {
    return stub.deleteDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Revision][google.cloud.config.v1.Revision]s of a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeploymentName parent = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
   *   for (Revision element : configClient.listRevisions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the Revisions are listed. The parent value
   *     is in the format: 'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRevisionsPagedResponse listRevisions(DeploymentName parent) {
    ListRevisionsRequest request =
        ListRevisionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Revision][google.cloud.config.v1.Revision]s of a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString();
   *   for (Revision element : configClient.listRevisions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the Revisions are listed. The parent value
   *     is in the format: 'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRevisionsPagedResponse listRevisions(String parent) {
    ListRevisionsRequest request = ListRevisionsRequest.newBuilder().setParent(parent).build();
    return listRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Revision][google.cloud.config.v1.Revision]s of a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListRevisionsRequest request =
   *       ListRevisionsRequest.newBuilder()
   *           .setParent(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Revision element : configClient.listRevisions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRevisionsPagedResponse listRevisions(ListRevisionsRequest request) {
    return listRevisionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Revision][google.cloud.config.v1.Revision]s of a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListRevisionsRequest request =
   *       ListRevisionsRequest.newBuilder()
   *           .setParent(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Revision> future = configClient.listRevisionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Revision element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRevisionsRequest, ListRevisionsPagedResponse>
      listRevisionsPagedCallable() {
    return stub.listRevisionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Revision][google.cloud.config.v1.Revision]s of a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListRevisionsRequest request =
   *       ListRevisionsRequest.newBuilder()
   *           .setParent(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListRevisionsResponse response = configClient.listRevisionsCallable().call(request);
   *     for (Revision element : response.getRevisionsList()) {
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
  public final UnaryCallable<ListRevisionsRequest, ListRevisionsResponse> listRevisionsCallable() {
    return stub.listRevisionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Revision][google.cloud.config.v1.Revision].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   RevisionName name = RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]");
   *   Revision response = configClient.getRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Revision in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}/revisions/{revision}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Revision getRevision(RevisionName name) {
    GetRevisionRequest request =
        GetRevisionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Revision][google.cloud.config.v1.Revision].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name =
   *       RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]").toString();
   *   Revision response = configClient.getRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Revision in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}/revisions/{revision}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Revision getRevision(String name) {
    GetRevisionRequest request = GetRevisionRequest.newBuilder().setName(name).build();
    return getRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Revision][google.cloud.config.v1.Revision].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetRevisionRequest request =
   *       GetRevisionRequest.newBuilder()
   *           .setName(
   *               RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]")
   *                   .toString())
   *           .build();
   *   Revision response = configClient.getRevision(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Revision getRevision(GetRevisionRequest request) {
    return getRevisionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Revision][google.cloud.config.v1.Revision].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetRevisionRequest request =
   *       GetRevisionRequest.newBuilder()
   *           .setName(
   *               RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Revision> future = configClient.getRevisionCallable().futureCall(request);
   *   // Do something.
   *   Revision response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRevisionRequest, Revision> getRevisionCallable() {
    return stub.getRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Resource][google.cloud.config.v1.Resource] deployed by Infra Manager.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ResourceName name =
   *       ResourceName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]", "[RESOURCE]");
   *   Resource response = configClient.getResource(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Resource in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}/revisions/{revision}/resource/{resource}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Resource getResource(ResourceName name) {
    GetResourceRequest request =
        GetResourceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getResource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Resource][google.cloud.config.v1.Resource] deployed by Infra Manager.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name =
   *       ResourceName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]", "[RESOURCE]")
   *           .toString();
   *   Resource response = configClient.getResource(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Resource in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}/revisions/{revision}/resource/{resource}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Resource getResource(String name) {
    GetResourceRequest request = GetResourceRequest.newBuilder().setName(name).build();
    return getResource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Resource][google.cloud.config.v1.Resource] deployed by Infra Manager.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetResourceRequest request =
   *       GetResourceRequest.newBuilder()
   *           .setName(
   *               ResourceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]", "[RESOURCE]")
   *                   .toString())
   *           .build();
   *   Resource response = configClient.getResource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Resource getResource(GetResourceRequest request) {
    return getResourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Resource][google.cloud.config.v1.Resource] deployed by Infra Manager.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetResourceRequest request =
   *       GetResourceRequest.newBuilder()
   *           .setName(
   *               ResourceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]", "[RESOURCE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Resource> future = configClient.getResourceCallable().futureCall(request);
   *   // Do something.
   *   Resource response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetResourceRequest, Resource> getResourceCallable() {
    return stub.getResourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Resources][google.cloud.config.v1.Resource] in a given revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   RevisionName parent =
   *       RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]");
   *   for (Resource element : configClient.listResources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the Resources are listed. The parent value
   *     is in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}/revisions/{revision}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListResourcesPagedResponse listResources(RevisionName parent) {
    ListResourcesRequest request =
        ListResourcesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listResources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Resources][google.cloud.config.v1.Resource] in a given revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent =
   *       RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]").toString();
   *   for (Resource element : configClient.listResources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the Resources are listed. The parent value
   *     is in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}/revisions/{revision}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListResourcesPagedResponse listResources(String parent) {
    ListResourcesRequest request = ListResourcesRequest.newBuilder().setParent(parent).build();
    return listResources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Resources][google.cloud.config.v1.Resource] in a given revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListResourcesRequest request =
   *       ListResourcesRequest.newBuilder()
   *           .setParent(
   *               RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Resource element : configClient.listResources(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListResourcesPagedResponse listResources(ListResourcesRequest request) {
    return listResourcesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Resources][google.cloud.config.v1.Resource] in a given revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListResourcesRequest request =
   *       ListResourcesRequest.newBuilder()
   *           .setParent(
   *               RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Resource> future = configClient.listResourcesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Resource element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListResourcesRequest, ListResourcesPagedResponse>
      listResourcesPagedCallable() {
    return stub.listResourcesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Resources][google.cloud.config.v1.Resource] in a given revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListResourcesRequest request =
   *       ListResourcesRequest.newBuilder()
   *           .setParent(
   *               RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListResourcesResponse response = configClient.listResourcesCallable().call(request);
   *     for (Resource element : response.getResourcesList()) {
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
  public final UnaryCallable<ListResourcesRequest, ListResourcesResponse> listResourcesCallable() {
    return stub.listResourcesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports Terraform state file from a given deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ExportDeploymentStatefileRequest request =
   *       ExportDeploymentStatefileRequest.newBuilder()
   *           .setParent(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setDraft(true)
   *           .build();
   *   Statefile response = configClient.exportDeploymentStatefile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Statefile exportDeploymentStatefile(ExportDeploymentStatefileRequest request) {
    return exportDeploymentStatefileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports Terraform state file from a given deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ExportDeploymentStatefileRequest request =
   *       ExportDeploymentStatefileRequest.newBuilder()
   *           .setParent(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setDraft(true)
   *           .build();
   *   ApiFuture<Statefile> future =
   *       configClient.exportDeploymentStatefileCallable().futureCall(request);
   *   // Do something.
   *   Statefile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportDeploymentStatefileRequest, Statefile>
      exportDeploymentStatefileCallable() {
    return stub.exportDeploymentStatefileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports Terraform state file from a given revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ExportRevisionStatefileRequest request =
   *       ExportRevisionStatefileRequest.newBuilder()
   *           .setParent(
   *               RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]")
   *                   .toString())
   *           .build();
   *   Statefile response = configClient.exportRevisionStatefile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Statefile exportRevisionStatefile(ExportRevisionStatefileRequest request) {
    return exportRevisionStatefileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports Terraform state file from a given revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ExportRevisionStatefileRequest request =
   *       ExportRevisionStatefileRequest.newBuilder()
   *           .setParent(
   *               RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Statefile> future =
   *       configClient.exportRevisionStatefileCallable().futureCall(request);
   *   // Do something.
   *   Statefile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportRevisionStatefileRequest, Statefile>
      exportRevisionStatefileCallable() {
    return stub.exportRevisionStatefileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports Terraform state file in a given deployment. The state file does not take effect until
   * the Deployment has been unlocked.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeploymentName parent = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
   *   long lockId = 338696367;
   *   Statefile response = configClient.importStatefile(parent, lockId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the statefile is listed. The parent value
   *     is in the format: 'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @param lockId Required. Lock ID of the lock file to verify that the user who is importing the
   *     state file previously locked the Deployment.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Statefile importStatefile(DeploymentName parent, long lockId) {
    ImportStatefileRequest request =
        ImportStatefileRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setLockId(lockId)
            .build();
    return importStatefile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports Terraform state file in a given deployment. The state file does not take effect until
   * the Deployment has been unlocked.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString();
   *   long lockId = 338696367;
   *   Statefile response = configClient.importStatefile(parent, lockId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the statefile is listed. The parent value
   *     is in the format: 'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @param lockId Required. Lock ID of the lock file to verify that the user who is importing the
   *     state file previously locked the Deployment.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Statefile importStatefile(String parent, long lockId) {
    ImportStatefileRequest request =
        ImportStatefileRequest.newBuilder().setParent(parent).setLockId(lockId).build();
    return importStatefile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports Terraform state file in a given deployment. The state file does not take effect until
   * the Deployment has been unlocked.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ImportStatefileRequest request =
   *       ImportStatefileRequest.newBuilder()
   *           .setParent(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setLockId(338696367)
   *           .setSkipDraft(true)
   *           .build();
   *   Statefile response = configClient.importStatefile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Statefile importStatefile(ImportStatefileRequest request) {
    return importStatefileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports Terraform state file in a given deployment. The state file does not take effect until
   * the Deployment has been unlocked.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ImportStatefileRequest request =
   *       ImportStatefileRequest.newBuilder()
   *           .setParent(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setLockId(338696367)
   *           .setSkipDraft(true)
   *           .build();
   *   ApiFuture<Statefile> future = configClient.importStatefileCallable().futureCall(request);
   *   // Do something.
   *   Statefile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportStatefileRequest, Statefile> importStatefileCallable() {
    return stub.importStatefileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes Terraform state file in a given deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
   *   configClient.deleteStatefile(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteStatefile(DeploymentName name) {
    DeleteStatefileRequest request =
        DeleteStatefileRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteStatefile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes Terraform state file in a given deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString();
   *   configClient.deleteStatefile(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteStatefile(String name) {
    DeleteStatefileRequest request = DeleteStatefileRequest.newBuilder().setName(name).build();
    deleteStatefile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes Terraform state file in a given deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeleteStatefileRequest request =
   *       DeleteStatefileRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setLockId(338696367)
   *           .build();
   *   configClient.deleteStatefile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteStatefile(DeleteStatefileRequest request) {
    deleteStatefileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes Terraform state file in a given deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeleteStatefileRequest request =
   *       DeleteStatefileRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setLockId(338696367)
   *           .build();
   *   ApiFuture<Empty> future = configClient.deleteStatefileCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteStatefileRequest, Empty> deleteStatefileCallable() {
    return stub.deleteStatefileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Locks a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
   *   Deployment response = configClient.lockDeploymentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> lockDeploymentAsync(
      DeploymentName name) {
    LockDeploymentRequest request =
        LockDeploymentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return lockDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Locks a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString();
   *   Deployment response = configClient.lockDeploymentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> lockDeploymentAsync(String name) {
    LockDeploymentRequest request = LockDeploymentRequest.newBuilder().setName(name).build();
    return lockDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Locks a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   LockDeploymentRequest request =
   *       LockDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .build();
   *   Deployment response = configClient.lockDeploymentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> lockDeploymentAsync(
      LockDeploymentRequest request) {
    return lockDeploymentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Locks a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   LockDeploymentRequest request =
   *       LockDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .build();
   *   OperationFuture<Deployment, OperationMetadata> future =
   *       configClient.lockDeploymentOperationCallable().futureCall(request);
   *   // Do something.
   *   Deployment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<LockDeploymentRequest, Deployment, OperationMetadata>
      lockDeploymentOperationCallable() {
    return stub.lockDeploymentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Locks a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   LockDeploymentRequest request =
   *       LockDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .build();
   *   ApiFuture<Operation> future = configClient.lockDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<LockDeploymentRequest, Operation> lockDeploymentCallable() {
    return stub.lockDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unlocks a locked deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
   *   long lockId = 338696367;
   *   Deployment response = configClient.unlockDeploymentAsync(name, lockId).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @param lockId Required. Lock ID of the lock file to be unlocked.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> unlockDeploymentAsync(
      DeploymentName name, long lockId) {
    UnlockDeploymentRequest request =
        UnlockDeploymentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setLockId(lockId)
            .build();
    return unlockDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unlocks a locked deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString();
   *   long lockId = 338696367;
   *   Deployment response = configClient.unlockDeploymentAsync(name, lockId).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @param lockId Required. Lock ID of the lock file to be unlocked.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> unlockDeploymentAsync(
      String name, long lockId) {
    UnlockDeploymentRequest request =
        UnlockDeploymentRequest.newBuilder().setName(name).setLockId(lockId).build();
    return unlockDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unlocks a locked deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UnlockDeploymentRequest request =
   *       UnlockDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setLockId(338696367)
   *           .build();
   *   Deployment response = configClient.unlockDeploymentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> unlockDeploymentAsync(
      UnlockDeploymentRequest request) {
    return unlockDeploymentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unlocks a locked deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UnlockDeploymentRequest request =
   *       UnlockDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setLockId(338696367)
   *           .build();
   *   OperationFuture<Deployment, OperationMetadata> future =
   *       configClient.unlockDeploymentOperationCallable().futureCall(request);
   *   // Do something.
   *   Deployment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UnlockDeploymentRequest, Deployment, OperationMetadata>
      unlockDeploymentOperationCallable() {
    return stub.unlockDeploymentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unlocks a locked deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UnlockDeploymentRequest request =
   *       UnlockDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setLockId(338696367)
   *           .build();
   *   ApiFuture<Operation> future = configClient.unlockDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UnlockDeploymentRequest, Operation> unlockDeploymentCallable() {
    return stub.unlockDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports the lock info on a locked deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
   *   LockInfo response = configClient.exportLockInfo(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LockInfo exportLockInfo(DeploymentName name) {
    ExportLockInfoRequest request =
        ExportLockInfoRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return exportLockInfo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports the lock info on a locked deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString();
   *   LockInfo response = configClient.exportLockInfo(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LockInfo exportLockInfo(String name) {
    ExportLockInfoRequest request = ExportLockInfoRequest.newBuilder().setName(name).build();
    return exportLockInfo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports the lock info on a locked deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ExportLockInfoRequest request =
   *       ExportLockInfoRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .build();
   *   LockInfo response = configClient.exportLockInfo(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LockInfo exportLockInfo(ExportLockInfoRequest request) {
    return exportLockInfoCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports the lock info on a locked deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ExportLockInfoRequest request =
   *       ExportLockInfoRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .build();
   *   ApiFuture<LockInfo> future = configClient.exportLockInfoCallable().futureCall(request);
   *   // Do something.
   *   LockInfo response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportLockInfoRequest, LockInfo> exportLockInfoCallable() {
    return stub.exportLockInfoCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Preview][google.cloud.config.v1.Preview].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Preview preview = Preview.newBuilder().build();
   *   Preview response = configClient.createPreviewAsync(parent, preview).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the Preview is created. The parent value is
   *     in the format: 'projects/{project_id}/locations/{location}'.
   * @param preview Required. [Preview][google.cloud.config.v1.Preview] resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Preview, OperationMetadata> createPreviewAsync(
      LocationName parent, Preview preview) {
    CreatePreviewRequest request =
        CreatePreviewRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPreview(preview)
            .build();
    return createPreviewAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Preview][google.cloud.config.v1.Preview].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Preview preview = Preview.newBuilder().build();
   *   Preview response = configClient.createPreviewAsync(parent, preview).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the Preview is created. The parent value is
   *     in the format: 'projects/{project_id}/locations/{location}'.
   * @param preview Required. [Preview][google.cloud.config.v1.Preview] resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Preview, OperationMetadata> createPreviewAsync(
      String parent, Preview preview) {
    CreatePreviewRequest request =
        CreatePreviewRequest.newBuilder().setParent(parent).setPreview(preview).build();
    return createPreviewAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Preview][google.cloud.config.v1.Preview].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreatePreviewRequest request =
   *       CreatePreviewRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPreviewId("previewId-832627965")
   *           .setPreview(Preview.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Preview response = configClient.createPreviewAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Preview, OperationMetadata> createPreviewAsync(
      CreatePreviewRequest request) {
    return createPreviewOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Preview][google.cloud.config.v1.Preview].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreatePreviewRequest request =
   *       CreatePreviewRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPreviewId("previewId-832627965")
   *           .setPreview(Preview.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Preview, OperationMetadata> future =
   *       configClient.createPreviewOperationCallable().futureCall(request);
   *   // Do something.
   *   Preview response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreatePreviewRequest, Preview, OperationMetadata>
      createPreviewOperationCallable() {
    return stub.createPreviewOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Preview][google.cloud.config.v1.Preview].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreatePreviewRequest request =
   *       CreatePreviewRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPreviewId("previewId-832627965")
   *           .setPreview(Preview.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = configClient.createPreviewCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePreviewRequest, Operation> createPreviewCallable() {
    return stub.createPreviewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Preview][google.cloud.config.v1.Preview].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   PreviewName name = PreviewName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]");
   *   Preview response = configClient.getPreview(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the preview. Format:
   *     'projects/{project_id}/locations/{location}/previews/{preview}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Preview getPreview(PreviewName name) {
    GetPreviewRequest request =
        GetPreviewRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPreview(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Preview][google.cloud.config.v1.Preview].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name = PreviewName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]").toString();
   *   Preview response = configClient.getPreview(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the preview. Format:
   *     'projects/{project_id}/locations/{location}/previews/{preview}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Preview getPreview(String name) {
    GetPreviewRequest request = GetPreviewRequest.newBuilder().setName(name).build();
    return getPreview(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Preview][google.cloud.config.v1.Preview].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetPreviewRequest request =
   *       GetPreviewRequest.newBuilder()
   *           .setName(PreviewName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]").toString())
   *           .build();
   *   Preview response = configClient.getPreview(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Preview getPreview(GetPreviewRequest request) {
    return getPreviewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Preview][google.cloud.config.v1.Preview].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetPreviewRequest request =
   *       GetPreviewRequest.newBuilder()
   *           .setName(PreviewName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]").toString())
   *           .build();
   *   ApiFuture<Preview> future = configClient.getPreviewCallable().futureCall(request);
   *   // Do something.
   *   Preview response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPreviewRequest, Preview> getPreviewCallable() {
    return stub.getPreviewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Preview][google.cloud.config.v1.Preview]s in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Preview element : configClient.listPreviews(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the Previews are listed. The parent value
   *     is in the format: 'projects/{project_id}/locations/{location}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPreviewsPagedResponse listPreviews(LocationName parent) {
    ListPreviewsRequest request =
        ListPreviewsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPreviews(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Preview][google.cloud.config.v1.Preview]s in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Preview element : configClient.listPreviews(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the Previews are listed. The parent value
   *     is in the format: 'projects/{project_id}/locations/{location}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPreviewsPagedResponse listPreviews(String parent) {
    ListPreviewsRequest request = ListPreviewsRequest.newBuilder().setParent(parent).build();
    return listPreviews(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Preview][google.cloud.config.v1.Preview]s in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListPreviewsRequest request =
   *       ListPreviewsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Preview element : configClient.listPreviews(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPreviewsPagedResponse listPreviews(ListPreviewsRequest request) {
    return listPreviewsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Preview][google.cloud.config.v1.Preview]s in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListPreviewsRequest request =
   *       ListPreviewsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Preview> future = configClient.listPreviewsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Preview element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPreviewsRequest, ListPreviewsPagedResponse>
      listPreviewsPagedCallable() {
    return stub.listPreviewsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Preview][google.cloud.config.v1.Preview]s in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListPreviewsRequest request =
   *       ListPreviewsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListPreviewsResponse response = configClient.listPreviewsCallable().call(request);
   *     for (Preview element : response.getPreviewsList()) {
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
  public final UnaryCallable<ListPreviewsRequest, ListPreviewsResponse> listPreviewsCallable() {
    return stub.listPreviewsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Preview][google.cloud.config.v1.Preview].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   PreviewName name = PreviewName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]");
   *   Preview response = configClient.deletePreviewAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Preview in the format:
   *     'projects/{project_id}/locations/{location}/previews/{preview}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Preview, OperationMetadata> deletePreviewAsync(PreviewName name) {
    DeletePreviewRequest request =
        DeletePreviewRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deletePreviewAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Preview][google.cloud.config.v1.Preview].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name = PreviewName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]").toString();
   *   Preview response = configClient.deletePreviewAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Preview in the format:
   *     'projects/{project_id}/locations/{location}/previews/{preview}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Preview, OperationMetadata> deletePreviewAsync(String name) {
    DeletePreviewRequest request = DeletePreviewRequest.newBuilder().setName(name).build();
    return deletePreviewAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Preview][google.cloud.config.v1.Preview].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeletePreviewRequest request =
   *       DeletePreviewRequest.newBuilder()
   *           .setName(PreviewName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Preview response = configClient.deletePreviewAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Preview, OperationMetadata> deletePreviewAsync(
      DeletePreviewRequest request) {
    return deletePreviewOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Preview][google.cloud.config.v1.Preview].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeletePreviewRequest request =
   *       DeletePreviewRequest.newBuilder()
   *           .setName(PreviewName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Preview, OperationMetadata> future =
   *       configClient.deletePreviewOperationCallable().futureCall(request);
   *   // Do something.
   *   Preview response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeletePreviewRequest, Preview, OperationMetadata>
      deletePreviewOperationCallable() {
    return stub.deletePreviewOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Preview][google.cloud.config.v1.Preview].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeletePreviewRequest request =
   *       DeletePreviewRequest.newBuilder()
   *           .setName(PreviewName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = configClient.deletePreviewCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePreviewRequest, Operation> deletePreviewCallable() {
    return stub.deletePreviewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export [Preview][google.cloud.config.v1.Preview] results.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ExportPreviewResultRequest request =
   *       ExportPreviewResultRequest.newBuilder()
   *           .setParent(PreviewName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]").toString())
   *           .build();
   *   ExportPreviewResultResponse response = configClient.exportPreviewResult(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExportPreviewResultResponse exportPreviewResult(ExportPreviewResultRequest request) {
    return exportPreviewResultCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export [Preview][google.cloud.config.v1.Preview] results.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ExportPreviewResultRequest request =
   *       ExportPreviewResultRequest.newBuilder()
   *           .setParent(PreviewName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]").toString())
   *           .build();
   *   ApiFuture<ExportPreviewResultResponse> future =
   *       configClient.exportPreviewResultCallable().futureCall(request);
   *   // Do something.
   *   ExportPreviewResultResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportPreviewResultRequest, ExportPreviewResultResponse>
      exportPreviewResultCallable() {
    return stub.exportPreviewResultCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [TerraformVersion][google.cloud.config.v1.TerraformVersion]s in a given project and
   * location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (TerraformVersion element : configClient.listTerraformVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the TerraformVersions are listed. The
   *     parent value is in the format: 'projects/{project_id}/locations/{location}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTerraformVersionsPagedResponse listTerraformVersions(LocationName parent) {
    ListTerraformVersionsRequest request =
        ListTerraformVersionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTerraformVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [TerraformVersion][google.cloud.config.v1.TerraformVersion]s in a given project and
   * location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (TerraformVersion element : configClient.listTerraformVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the TerraformVersions are listed. The
   *     parent value is in the format: 'projects/{project_id}/locations/{location}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTerraformVersionsPagedResponse listTerraformVersions(String parent) {
    ListTerraformVersionsRequest request =
        ListTerraformVersionsRequest.newBuilder().setParent(parent).build();
    return listTerraformVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [TerraformVersion][google.cloud.config.v1.TerraformVersion]s in a given project and
   * location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListTerraformVersionsRequest request =
   *       ListTerraformVersionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (TerraformVersion element : configClient.listTerraformVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTerraformVersionsPagedResponse listTerraformVersions(
      ListTerraformVersionsRequest request) {
    return listTerraformVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [TerraformVersion][google.cloud.config.v1.TerraformVersion]s in a given project and
   * location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListTerraformVersionsRequest request =
   *       ListTerraformVersionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<TerraformVersion> future =
   *       configClient.listTerraformVersionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TerraformVersion element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTerraformVersionsRequest, ListTerraformVersionsPagedResponse>
      listTerraformVersionsPagedCallable() {
    return stub.listTerraformVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [TerraformVersion][google.cloud.config.v1.TerraformVersion]s in a given project and
   * location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListTerraformVersionsRequest request =
   *       ListTerraformVersionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListTerraformVersionsResponse response =
   *         configClient.listTerraformVersionsCallable().call(request);
   *     for (TerraformVersion element : response.getTerraformVersionsList()) {
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
  public final UnaryCallable<ListTerraformVersionsRequest, ListTerraformVersionsResponse>
      listTerraformVersionsCallable() {
    return stub.listTerraformVersionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [TerraformVersion][google.cloud.config.v1.TerraformVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   TerraformVersionName name =
   *       TerraformVersionName.of("[PROJECT]", "[LOCATION]", "[TERRAFORM_VERSION]");
   *   TerraformVersion response = configClient.getTerraformVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the TerraformVersion. Format:
   *     'projects/{project_id}/locations/{location}/terraformVersions/{terraform_version}'
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TerraformVersion getTerraformVersion(TerraformVersionName name) {
    GetTerraformVersionRequest request =
        GetTerraformVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getTerraformVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [TerraformVersion][google.cloud.config.v1.TerraformVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name =
   *       TerraformVersionName.of("[PROJECT]", "[LOCATION]", "[TERRAFORM_VERSION]").toString();
   *   TerraformVersion response = configClient.getTerraformVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the TerraformVersion. Format:
   *     'projects/{project_id}/locations/{location}/terraformVersions/{terraform_version}'
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TerraformVersion getTerraformVersion(String name) {
    GetTerraformVersionRequest request =
        GetTerraformVersionRequest.newBuilder().setName(name).build();
    return getTerraformVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [TerraformVersion][google.cloud.config.v1.TerraformVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetTerraformVersionRequest request =
   *       GetTerraformVersionRequest.newBuilder()
   *           .setName(
   *               TerraformVersionName.of("[PROJECT]", "[LOCATION]", "[TERRAFORM_VERSION]")
   *                   .toString())
   *           .build();
   *   TerraformVersion response = configClient.getTerraformVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TerraformVersion getTerraformVersion(GetTerraformVersionRequest request) {
    return getTerraformVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [TerraformVersion][google.cloud.config.v1.TerraformVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetTerraformVersionRequest request =
   *       GetTerraformVersionRequest.newBuilder()
   *           .setName(
   *               TerraformVersionName.of("[PROJECT]", "[LOCATION]", "[TERRAFORM_VERSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<TerraformVersion> future =
   *       configClient.getTerraformVersionCallable().futureCall(request);
   *   // Do something.
   *   TerraformVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTerraformVersionRequest, TerraformVersion>
      getTerraformVersionCallable() {
    return stub.getTerraformVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ResourceChanges for a given preview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   PreviewName parent = PreviewName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]");
   *   for (ResourceChange element : configClient.listResourceChanges(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the ResourceChanges are listed. The parent
   *     value is in the format: 'projects/{project_id}/locations/{location}/previews/{preview}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListResourceChangesPagedResponse listResourceChanges(PreviewName parent) {
    ListResourceChangesRequest request =
        ListResourceChangesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listResourceChanges(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ResourceChanges for a given preview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent = PreviewName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]").toString();
   *   for (ResourceChange element : configClient.listResourceChanges(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the ResourceChanges are listed. The parent
   *     value is in the format: 'projects/{project_id}/locations/{location}/previews/{preview}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListResourceChangesPagedResponse listResourceChanges(String parent) {
    ListResourceChangesRequest request =
        ListResourceChangesRequest.newBuilder().setParent(parent).build();
    return listResourceChanges(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ResourceChanges for a given preview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListResourceChangesRequest request =
   *       ListResourceChangesRequest.newBuilder()
   *           .setParent(PreviewName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ResourceChange element : configClient.listResourceChanges(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListResourceChangesPagedResponse listResourceChanges(
      ListResourceChangesRequest request) {
    return listResourceChangesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ResourceChanges for a given preview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListResourceChangesRequest request =
   *       ListResourceChangesRequest.newBuilder()
   *           .setParent(PreviewName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ResourceChange> future =
   *       configClient.listResourceChangesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ResourceChange element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListResourceChangesRequest, ListResourceChangesPagedResponse>
      listResourceChangesPagedCallable() {
    return stub.listResourceChangesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ResourceChanges for a given preview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListResourceChangesRequest request =
   *       ListResourceChangesRequest.newBuilder()
   *           .setParent(PreviewName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListResourceChangesResponse response =
   *         configClient.listResourceChangesCallable().call(request);
   *     for (ResourceChange element : response.getResourceChangesList()) {
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
  public final UnaryCallable<ListResourceChangesRequest, ListResourceChangesResponse>
      listResourceChangesCallable() {
    return stub.listResourceChangesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a ResourceChange for a given preview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ResourceChangeName name =
   *       ResourceChangeName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]", "[RESOURCE_CHANGE]");
   *   ResourceChange response = configClient.getResourceChange(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the resource change to retrieve. Format:
   *     'projects/{project_id}/locations/{location}/previews/{preview}/resourceChanges/{resource_change}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResourceChange getResourceChange(ResourceChangeName name) {
    GetResourceChangeRequest request =
        GetResourceChangeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getResourceChange(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a ResourceChange for a given preview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name =
   *       ResourceChangeName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]", "[RESOURCE_CHANGE]")
   *           .toString();
   *   ResourceChange response = configClient.getResourceChange(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the resource change to retrieve. Format:
   *     'projects/{project_id}/locations/{location}/previews/{preview}/resourceChanges/{resource_change}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResourceChange getResourceChange(String name) {
    GetResourceChangeRequest request = GetResourceChangeRequest.newBuilder().setName(name).build();
    return getResourceChange(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a ResourceChange for a given preview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetResourceChangeRequest request =
   *       GetResourceChangeRequest.newBuilder()
   *           .setName(
   *               ResourceChangeName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]", "[RESOURCE_CHANGE]")
   *                   .toString())
   *           .build();
   *   ResourceChange response = configClient.getResourceChange(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResourceChange getResourceChange(GetResourceChangeRequest request) {
    return getResourceChangeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a ResourceChange for a given preview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetResourceChangeRequest request =
   *       GetResourceChangeRequest.newBuilder()
   *           .setName(
   *               ResourceChangeName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]", "[RESOURCE_CHANGE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ResourceChange> future =
   *       configClient.getResourceChangeCallable().futureCall(request);
   *   // Do something.
   *   ResourceChange response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetResourceChangeRequest, ResourceChange> getResourceChangeCallable() {
    return stub.getResourceChangeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List ResourceDrifts for a given preview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   PreviewName parent = PreviewName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]");
   *   for (ResourceDrift element : configClient.listResourceDrifts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the ResourceDrifts are listed. The parent
   *     value is in the format: 'projects/{project_id}/locations/{location}/previews/{preview}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListResourceDriftsPagedResponse listResourceDrifts(PreviewName parent) {
    ListResourceDriftsRequest request =
        ListResourceDriftsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listResourceDrifts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List ResourceDrifts for a given preview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent = PreviewName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]").toString();
   *   for (ResourceDrift element : configClient.listResourceDrifts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the ResourceDrifts are listed. The parent
   *     value is in the format: 'projects/{project_id}/locations/{location}/previews/{preview}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListResourceDriftsPagedResponse listResourceDrifts(String parent) {
    ListResourceDriftsRequest request =
        ListResourceDriftsRequest.newBuilder().setParent(parent).build();
    return listResourceDrifts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List ResourceDrifts for a given preview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListResourceDriftsRequest request =
   *       ListResourceDriftsRequest.newBuilder()
   *           .setParent(PreviewName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ResourceDrift element : configClient.listResourceDrifts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListResourceDriftsPagedResponse listResourceDrifts(
      ListResourceDriftsRequest request) {
    return listResourceDriftsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List ResourceDrifts for a given preview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListResourceDriftsRequest request =
   *       ListResourceDriftsRequest.newBuilder()
   *           .setParent(PreviewName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ResourceDrift> future =
   *       configClient.listResourceDriftsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ResourceDrift element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListResourceDriftsRequest, ListResourceDriftsPagedResponse>
      listResourceDriftsPagedCallable() {
    return stub.listResourceDriftsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List ResourceDrifts for a given preview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListResourceDriftsRequest request =
   *       ListResourceDriftsRequest.newBuilder()
   *           .setParent(PreviewName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListResourceDriftsResponse response =
   *         configClient.listResourceDriftsCallable().call(request);
   *     for (ResourceDrift element : response.getResourceDriftsList()) {
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
  public final UnaryCallable<ListResourceDriftsRequest, ListResourceDriftsResponse>
      listResourceDriftsCallable() {
    return stub.listResourceDriftsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a ResourceDrift for a given preview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ResourceDriftName name =
   *       ResourceDriftName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]", "[RESOURCE_DRIFT]");
   *   ResourceDrift response = configClient.getResourceDrift(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the resource drift to retrieve. Format:
   *     'projects/{project_id}/locations/{location}/previews/{preview}/resourceDrifts/{resource_drift}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResourceDrift getResourceDrift(ResourceDriftName name) {
    GetResourceDriftRequest request =
        GetResourceDriftRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getResourceDrift(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a ResourceDrift for a given preview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name =
   *       ResourceDriftName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]", "[RESOURCE_DRIFT]")
   *           .toString();
   *   ResourceDrift response = configClient.getResourceDrift(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the resource drift to retrieve. Format:
   *     'projects/{project_id}/locations/{location}/previews/{preview}/resourceDrifts/{resource_drift}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResourceDrift getResourceDrift(String name) {
    GetResourceDriftRequest request = GetResourceDriftRequest.newBuilder().setName(name).build();
    return getResourceDrift(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a ResourceDrift for a given preview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetResourceDriftRequest request =
   *       GetResourceDriftRequest.newBuilder()
   *           .setName(
   *               ResourceDriftName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]", "[RESOURCE_DRIFT]")
   *                   .toString())
   *           .build();
   *   ResourceDrift response = configClient.getResourceDrift(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResourceDrift getResourceDrift(GetResourceDriftRequest request) {
    return getResourceDriftCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a ResourceDrift for a given preview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetResourceDriftRequest request =
   *       GetResourceDriftRequest.newBuilder()
   *           .setName(
   *               ResourceDriftName.of("[PROJECT]", "[LOCATION]", "[PREVIEW]", "[RESOURCE_DRIFT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ResourceDrift> future = configClient.getResourceDriftCallable().futureCall(request);
   *   // Do something.
   *   ResourceDrift response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetResourceDriftRequest, ResourceDrift> getResourceDriftCallable() {
    return stub.getResourceDriftCallable();
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : configClient.listLocations(request).iterateAll()) {
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future = configClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = configClient.listLocationsCallable().call(request);
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = configClient.getLocation(request);
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = configClient.getLocationCallable().futureCall(request);
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = configClient.setIamPolicy(request);
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = configClient.setIamPolicyCallable().futureCall(request);
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = configClient.getIamPolicy(request);
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = configClient.getIamPolicyCallable().futureCall(request);
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = configClient.testIamPermissions(request);
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       configClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListDeploymentsPagedResponse
      extends AbstractPagedListResponse<
          ListDeploymentsRequest,
          ListDeploymentsResponse,
          Deployment,
          ListDeploymentsPage,
          ListDeploymentsFixedSizeCollection> {

    public static ApiFuture<ListDeploymentsPagedResponse> createAsync(
        PageContext<ListDeploymentsRequest, ListDeploymentsResponse, Deployment> context,
        ApiFuture<ListDeploymentsResponse> futureResponse) {
      ApiFuture<ListDeploymentsPage> futurePage =
          ListDeploymentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDeploymentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDeploymentsPagedResponse(ListDeploymentsPage page) {
      super(page, ListDeploymentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDeploymentsPage
      extends AbstractPage<
          ListDeploymentsRequest, ListDeploymentsResponse, Deployment, ListDeploymentsPage> {

    private ListDeploymentsPage(
        PageContext<ListDeploymentsRequest, ListDeploymentsResponse, Deployment> context,
        ListDeploymentsResponse response) {
      super(context, response);
    }

    private static ListDeploymentsPage createEmptyPage() {
      return new ListDeploymentsPage(null, null);
    }

    @Override
    protected ListDeploymentsPage createPage(
        PageContext<ListDeploymentsRequest, ListDeploymentsResponse, Deployment> context,
        ListDeploymentsResponse response) {
      return new ListDeploymentsPage(context, response);
    }

    @Override
    public ApiFuture<ListDeploymentsPage> createPageAsync(
        PageContext<ListDeploymentsRequest, ListDeploymentsResponse, Deployment> context,
        ApiFuture<ListDeploymentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDeploymentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDeploymentsRequest,
          ListDeploymentsResponse,
          Deployment,
          ListDeploymentsPage,
          ListDeploymentsFixedSizeCollection> {

    private ListDeploymentsFixedSizeCollection(
        List<ListDeploymentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDeploymentsFixedSizeCollection createEmptyCollection() {
      return new ListDeploymentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDeploymentsFixedSizeCollection createCollection(
        List<ListDeploymentsPage> pages, int collectionSize) {
      return new ListDeploymentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRevisionsPagedResponse
      extends AbstractPagedListResponse<
          ListRevisionsRequest,
          ListRevisionsResponse,
          Revision,
          ListRevisionsPage,
          ListRevisionsFixedSizeCollection> {

    public static ApiFuture<ListRevisionsPagedResponse> createAsync(
        PageContext<ListRevisionsRequest, ListRevisionsResponse, Revision> context,
        ApiFuture<ListRevisionsResponse> futureResponse) {
      ApiFuture<ListRevisionsPage> futurePage =
          ListRevisionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRevisionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRevisionsPagedResponse(ListRevisionsPage page) {
      super(page, ListRevisionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRevisionsPage
      extends AbstractPage<
          ListRevisionsRequest, ListRevisionsResponse, Revision, ListRevisionsPage> {

    private ListRevisionsPage(
        PageContext<ListRevisionsRequest, ListRevisionsResponse, Revision> context,
        ListRevisionsResponse response) {
      super(context, response);
    }

    private static ListRevisionsPage createEmptyPage() {
      return new ListRevisionsPage(null, null);
    }

    @Override
    protected ListRevisionsPage createPage(
        PageContext<ListRevisionsRequest, ListRevisionsResponse, Revision> context,
        ListRevisionsResponse response) {
      return new ListRevisionsPage(context, response);
    }

    @Override
    public ApiFuture<ListRevisionsPage> createPageAsync(
        PageContext<ListRevisionsRequest, ListRevisionsResponse, Revision> context,
        ApiFuture<ListRevisionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRevisionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRevisionsRequest,
          ListRevisionsResponse,
          Revision,
          ListRevisionsPage,
          ListRevisionsFixedSizeCollection> {

    private ListRevisionsFixedSizeCollection(List<ListRevisionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRevisionsFixedSizeCollection createEmptyCollection() {
      return new ListRevisionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRevisionsFixedSizeCollection createCollection(
        List<ListRevisionsPage> pages, int collectionSize) {
      return new ListRevisionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListResourcesPagedResponse
      extends AbstractPagedListResponse<
          ListResourcesRequest,
          ListResourcesResponse,
          Resource,
          ListResourcesPage,
          ListResourcesFixedSizeCollection> {

    public static ApiFuture<ListResourcesPagedResponse> createAsync(
        PageContext<ListResourcesRequest, ListResourcesResponse, Resource> context,
        ApiFuture<ListResourcesResponse> futureResponse) {
      ApiFuture<ListResourcesPage> futurePage =
          ListResourcesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListResourcesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListResourcesPagedResponse(ListResourcesPage page) {
      super(page, ListResourcesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListResourcesPage
      extends AbstractPage<
          ListResourcesRequest, ListResourcesResponse, Resource, ListResourcesPage> {

    private ListResourcesPage(
        PageContext<ListResourcesRequest, ListResourcesResponse, Resource> context,
        ListResourcesResponse response) {
      super(context, response);
    }

    private static ListResourcesPage createEmptyPage() {
      return new ListResourcesPage(null, null);
    }

    @Override
    protected ListResourcesPage createPage(
        PageContext<ListResourcesRequest, ListResourcesResponse, Resource> context,
        ListResourcesResponse response) {
      return new ListResourcesPage(context, response);
    }

    @Override
    public ApiFuture<ListResourcesPage> createPageAsync(
        PageContext<ListResourcesRequest, ListResourcesResponse, Resource> context,
        ApiFuture<ListResourcesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListResourcesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListResourcesRequest,
          ListResourcesResponse,
          Resource,
          ListResourcesPage,
          ListResourcesFixedSizeCollection> {

    private ListResourcesFixedSizeCollection(List<ListResourcesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListResourcesFixedSizeCollection createEmptyCollection() {
      return new ListResourcesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListResourcesFixedSizeCollection createCollection(
        List<ListResourcesPage> pages, int collectionSize) {
      return new ListResourcesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPreviewsPagedResponse
      extends AbstractPagedListResponse<
          ListPreviewsRequest,
          ListPreviewsResponse,
          Preview,
          ListPreviewsPage,
          ListPreviewsFixedSizeCollection> {

    public static ApiFuture<ListPreviewsPagedResponse> createAsync(
        PageContext<ListPreviewsRequest, ListPreviewsResponse, Preview> context,
        ApiFuture<ListPreviewsResponse> futureResponse) {
      ApiFuture<ListPreviewsPage> futurePage =
          ListPreviewsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPreviewsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPreviewsPagedResponse(ListPreviewsPage page) {
      super(page, ListPreviewsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPreviewsPage
      extends AbstractPage<ListPreviewsRequest, ListPreviewsResponse, Preview, ListPreviewsPage> {

    private ListPreviewsPage(
        PageContext<ListPreviewsRequest, ListPreviewsResponse, Preview> context,
        ListPreviewsResponse response) {
      super(context, response);
    }

    private static ListPreviewsPage createEmptyPage() {
      return new ListPreviewsPage(null, null);
    }

    @Override
    protected ListPreviewsPage createPage(
        PageContext<ListPreviewsRequest, ListPreviewsResponse, Preview> context,
        ListPreviewsResponse response) {
      return new ListPreviewsPage(context, response);
    }

    @Override
    public ApiFuture<ListPreviewsPage> createPageAsync(
        PageContext<ListPreviewsRequest, ListPreviewsResponse, Preview> context,
        ApiFuture<ListPreviewsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPreviewsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPreviewsRequest,
          ListPreviewsResponse,
          Preview,
          ListPreviewsPage,
          ListPreviewsFixedSizeCollection> {

    private ListPreviewsFixedSizeCollection(List<ListPreviewsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPreviewsFixedSizeCollection createEmptyCollection() {
      return new ListPreviewsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPreviewsFixedSizeCollection createCollection(
        List<ListPreviewsPage> pages, int collectionSize) {
      return new ListPreviewsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTerraformVersionsPagedResponse
      extends AbstractPagedListResponse<
          ListTerraformVersionsRequest,
          ListTerraformVersionsResponse,
          TerraformVersion,
          ListTerraformVersionsPage,
          ListTerraformVersionsFixedSizeCollection> {

    public static ApiFuture<ListTerraformVersionsPagedResponse> createAsync(
        PageContext<ListTerraformVersionsRequest, ListTerraformVersionsResponse, TerraformVersion>
            context,
        ApiFuture<ListTerraformVersionsResponse> futureResponse) {
      ApiFuture<ListTerraformVersionsPage> futurePage =
          ListTerraformVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTerraformVersionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTerraformVersionsPagedResponse(ListTerraformVersionsPage page) {
      super(page, ListTerraformVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTerraformVersionsPage
      extends AbstractPage<
          ListTerraformVersionsRequest,
          ListTerraformVersionsResponse,
          TerraformVersion,
          ListTerraformVersionsPage> {

    private ListTerraformVersionsPage(
        PageContext<ListTerraformVersionsRequest, ListTerraformVersionsResponse, TerraformVersion>
            context,
        ListTerraformVersionsResponse response) {
      super(context, response);
    }

    private static ListTerraformVersionsPage createEmptyPage() {
      return new ListTerraformVersionsPage(null, null);
    }

    @Override
    protected ListTerraformVersionsPage createPage(
        PageContext<ListTerraformVersionsRequest, ListTerraformVersionsResponse, TerraformVersion>
            context,
        ListTerraformVersionsResponse response) {
      return new ListTerraformVersionsPage(context, response);
    }

    @Override
    public ApiFuture<ListTerraformVersionsPage> createPageAsync(
        PageContext<ListTerraformVersionsRequest, ListTerraformVersionsResponse, TerraformVersion>
            context,
        ApiFuture<ListTerraformVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTerraformVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTerraformVersionsRequest,
          ListTerraformVersionsResponse,
          TerraformVersion,
          ListTerraformVersionsPage,
          ListTerraformVersionsFixedSizeCollection> {

    private ListTerraformVersionsFixedSizeCollection(
        List<ListTerraformVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTerraformVersionsFixedSizeCollection createEmptyCollection() {
      return new ListTerraformVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTerraformVersionsFixedSizeCollection createCollection(
        List<ListTerraformVersionsPage> pages, int collectionSize) {
      return new ListTerraformVersionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListResourceChangesPagedResponse
      extends AbstractPagedListResponse<
          ListResourceChangesRequest,
          ListResourceChangesResponse,
          ResourceChange,
          ListResourceChangesPage,
          ListResourceChangesFixedSizeCollection> {

    public static ApiFuture<ListResourceChangesPagedResponse> createAsync(
        PageContext<ListResourceChangesRequest, ListResourceChangesResponse, ResourceChange>
            context,
        ApiFuture<ListResourceChangesResponse> futureResponse) {
      ApiFuture<ListResourceChangesPage> futurePage =
          ListResourceChangesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListResourceChangesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListResourceChangesPagedResponse(ListResourceChangesPage page) {
      super(page, ListResourceChangesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListResourceChangesPage
      extends AbstractPage<
          ListResourceChangesRequest,
          ListResourceChangesResponse,
          ResourceChange,
          ListResourceChangesPage> {

    private ListResourceChangesPage(
        PageContext<ListResourceChangesRequest, ListResourceChangesResponse, ResourceChange>
            context,
        ListResourceChangesResponse response) {
      super(context, response);
    }

    private static ListResourceChangesPage createEmptyPage() {
      return new ListResourceChangesPage(null, null);
    }

    @Override
    protected ListResourceChangesPage createPage(
        PageContext<ListResourceChangesRequest, ListResourceChangesResponse, ResourceChange>
            context,
        ListResourceChangesResponse response) {
      return new ListResourceChangesPage(context, response);
    }

    @Override
    public ApiFuture<ListResourceChangesPage> createPageAsync(
        PageContext<ListResourceChangesRequest, ListResourceChangesResponse, ResourceChange>
            context,
        ApiFuture<ListResourceChangesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListResourceChangesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListResourceChangesRequest,
          ListResourceChangesResponse,
          ResourceChange,
          ListResourceChangesPage,
          ListResourceChangesFixedSizeCollection> {

    private ListResourceChangesFixedSizeCollection(
        List<ListResourceChangesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListResourceChangesFixedSizeCollection createEmptyCollection() {
      return new ListResourceChangesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListResourceChangesFixedSizeCollection createCollection(
        List<ListResourceChangesPage> pages, int collectionSize) {
      return new ListResourceChangesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListResourceDriftsPagedResponse
      extends AbstractPagedListResponse<
          ListResourceDriftsRequest,
          ListResourceDriftsResponse,
          ResourceDrift,
          ListResourceDriftsPage,
          ListResourceDriftsFixedSizeCollection> {

    public static ApiFuture<ListResourceDriftsPagedResponse> createAsync(
        PageContext<ListResourceDriftsRequest, ListResourceDriftsResponse, ResourceDrift> context,
        ApiFuture<ListResourceDriftsResponse> futureResponse) {
      ApiFuture<ListResourceDriftsPage> futurePage =
          ListResourceDriftsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListResourceDriftsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListResourceDriftsPagedResponse(ListResourceDriftsPage page) {
      super(page, ListResourceDriftsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListResourceDriftsPage
      extends AbstractPage<
          ListResourceDriftsRequest,
          ListResourceDriftsResponse,
          ResourceDrift,
          ListResourceDriftsPage> {

    private ListResourceDriftsPage(
        PageContext<ListResourceDriftsRequest, ListResourceDriftsResponse, ResourceDrift> context,
        ListResourceDriftsResponse response) {
      super(context, response);
    }

    private static ListResourceDriftsPage createEmptyPage() {
      return new ListResourceDriftsPage(null, null);
    }

    @Override
    protected ListResourceDriftsPage createPage(
        PageContext<ListResourceDriftsRequest, ListResourceDriftsResponse, ResourceDrift> context,
        ListResourceDriftsResponse response) {
      return new ListResourceDriftsPage(context, response);
    }

    @Override
    public ApiFuture<ListResourceDriftsPage> createPageAsync(
        PageContext<ListResourceDriftsRequest, ListResourceDriftsResponse, ResourceDrift> context,
        ApiFuture<ListResourceDriftsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListResourceDriftsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListResourceDriftsRequest,
          ListResourceDriftsResponse,
          ResourceDrift,
          ListResourceDriftsPage,
          ListResourceDriftsFixedSizeCollection> {

    private ListResourceDriftsFixedSizeCollection(
        List<ListResourceDriftsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListResourceDriftsFixedSizeCollection createEmptyCollection() {
      return new ListResourceDriftsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListResourceDriftsFixedSizeCollection createCollection(
        List<ListResourceDriftsPage> pages, int collectionSize) {
      return new ListResourceDriftsFixedSizeCollection(pages, collectionSize);
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
