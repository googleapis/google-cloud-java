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

package com.google.cloud.telcoautomation.v1;

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
import com.google.cloud.telcoautomation.v1.stub.TelcoAutomationStub;
import com.google.cloud.telcoautomation.v1.stub.TelcoAutomationStubSettings;
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
 * Service Description: TelcoAutomation Service manages the control plane cluster a.k.a.
 * Orchestration Cluster (GKE cluster with config controller) of TNA. It also exposes blueprint APIs
 * which manages the lifecycle of blueprints that control the infrastructure setup (e.g GDCE
 * clusters) and deployment of network functions.
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
 * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
 *   OrchestrationClusterName name =
 *       OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]");
 *   OrchestrationCluster response = telcoAutomationClient.getOrchestrationCluster(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TelcoAutomationClient object to clean up resources
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
 *      <td><p> ListOrchestrationClusters</td>
 *      <td><p> Lists OrchestrationClusters in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listOrchestrationClusters(ListOrchestrationClustersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listOrchestrationClusters(LocationName parent)
 *           <li><p> listOrchestrationClusters(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listOrchestrationClustersPagedCallable()
 *           <li><p> listOrchestrationClustersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetOrchestrationCluster</td>
 *      <td><p> Gets details of a single OrchestrationCluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getOrchestrationCluster(GetOrchestrationClusterRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getOrchestrationCluster(OrchestrationClusterName name)
 *           <li><p> getOrchestrationCluster(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getOrchestrationClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateOrchestrationCluster</td>
 *      <td><p> Creates a new OrchestrationCluster in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createOrchestrationClusterAsync(CreateOrchestrationClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createOrchestrationClusterAsync(LocationName parent, OrchestrationCluster orchestrationCluster, String orchestrationClusterId)
 *           <li><p> createOrchestrationClusterAsync(String parent, OrchestrationCluster orchestrationCluster, String orchestrationClusterId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createOrchestrationClusterOperationCallable()
 *           <li><p> createOrchestrationClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteOrchestrationCluster</td>
 *      <td><p> Deletes a single OrchestrationCluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteOrchestrationClusterAsync(DeleteOrchestrationClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteOrchestrationClusterAsync(OrchestrationClusterName name)
 *           <li><p> deleteOrchestrationClusterAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteOrchestrationClusterOperationCallable()
 *           <li><p> deleteOrchestrationClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListEdgeSlms</td>
 *      <td><p> Lists EdgeSlms in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEdgeSlms(ListEdgeSlmsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEdgeSlms(LocationName parent)
 *           <li><p> listEdgeSlms(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEdgeSlmsPagedCallable()
 *           <li><p> listEdgeSlmsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEdgeSlm</td>
 *      <td><p> Gets details of a single EdgeSlm.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEdgeSlm(GetEdgeSlmRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEdgeSlm(EdgeSlmName name)
 *           <li><p> getEdgeSlm(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEdgeSlmCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateEdgeSlm</td>
 *      <td><p> Creates a new EdgeSlm in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createEdgeSlmAsync(CreateEdgeSlmRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createEdgeSlmAsync(LocationName parent, EdgeSlm edgeSlm, String edgeSlmId)
 *           <li><p> createEdgeSlmAsync(String parent, EdgeSlm edgeSlm, String edgeSlmId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createEdgeSlmOperationCallable()
 *           <li><p> createEdgeSlmCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteEdgeSlm</td>
 *      <td><p> Deletes a single EdgeSlm.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteEdgeSlmAsync(DeleteEdgeSlmRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteEdgeSlmAsync(EdgeSlmName name)
 *           <li><p> deleteEdgeSlmAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteEdgeSlmOperationCallable()
 *           <li><p> deleteEdgeSlmCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateBlueprint</td>
 *      <td><p> Creates a blueprint.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createBlueprint(CreateBlueprintRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createBlueprint(OrchestrationClusterName parent, Blueprint blueprint, String blueprintId)
 *           <li><p> createBlueprint(String parent, Blueprint blueprint, String blueprintId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createBlueprintCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateBlueprint</td>
 *      <td><p> Updates a blueprint.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateBlueprint(UpdateBlueprintRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateBlueprint(Blueprint blueprint, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateBlueprintCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBlueprint</td>
 *      <td><p> Returns the requested blueprint.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBlueprint(GetBlueprintRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBlueprint(BlueprintName name)
 *           <li><p> getBlueprint(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBlueprintCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteBlueprint</td>
 *      <td><p> Deletes a blueprint and all its revisions.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteBlueprint(DeleteBlueprintRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteBlueprint(BlueprintName name)
 *           <li><p> deleteBlueprint(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteBlueprintCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBlueprints</td>
 *      <td><p> List all blueprints.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBlueprints(ListBlueprintsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBlueprints(OrchestrationClusterName parent)
 *           <li><p> listBlueprints(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBlueprintsPagedCallable()
 *           <li><p> listBlueprintsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ApproveBlueprint</td>
 *      <td><p> Approves a blueprint and commits a new revision.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> approveBlueprint(ApproveBlueprintRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> approveBlueprint(BlueprintName name)
 *           <li><p> approveBlueprint(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> approveBlueprintCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ProposeBlueprint</td>
 *      <td><p> Proposes a blueprint for approval of changes.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> proposeBlueprint(ProposeBlueprintRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> proposeBlueprint(BlueprintName name)
 *           <li><p> proposeBlueprint(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> proposeBlueprintCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RejectBlueprint</td>
 *      <td><p> Rejects a blueprint revision proposal and flips it back to Draft state.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> rejectBlueprint(RejectBlueprintRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> rejectBlueprint(BlueprintName name)
 *           <li><p> rejectBlueprint(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> rejectBlueprintCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBlueprintRevisions</td>
 *      <td><p> List blueprint revisions of a given blueprint.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBlueprintRevisions(ListBlueprintRevisionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBlueprintRevisions(BlueprintName name)
 *           <li><p> listBlueprintRevisions(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBlueprintRevisionsPagedCallable()
 *           <li><p> listBlueprintRevisionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchBlueprintRevisions</td>
 *      <td><p> Searches across blueprint revisions.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchBlueprintRevisions(SearchBlueprintRevisionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> searchBlueprintRevisions(OrchestrationClusterName parent, String query)
 *           <li><p> searchBlueprintRevisions(String parent, String query)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchBlueprintRevisionsPagedCallable()
 *           <li><p> searchBlueprintRevisionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchDeploymentRevisions</td>
 *      <td><p> Searches across deployment revisions.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchDeploymentRevisions(SearchDeploymentRevisionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> searchDeploymentRevisions(OrchestrationClusterName parent, String query)
 *           <li><p> searchDeploymentRevisions(String parent, String query)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchDeploymentRevisionsPagedCallable()
 *           <li><p> searchDeploymentRevisionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DiscardBlueprintChanges</td>
 *      <td><p> Discards the changes in a blueprint and reverts the blueprint to the last approved blueprint revision. No changes take place if a blueprint does not have revisions.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> discardBlueprintChanges(DiscardBlueprintChangesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> discardBlueprintChanges(BlueprintName name)
 *           <li><p> discardBlueprintChanges(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> discardBlueprintChangesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPublicBlueprints</td>
 *      <td><p> Lists the blueprints in TNA's public catalog. Default page size = 20, Max Page Size = 100.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPublicBlueprints(ListPublicBlueprintsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPublicBlueprints(LocationName parent)
 *           <li><p> listPublicBlueprints(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPublicBlueprintsPagedCallable()
 *           <li><p> listPublicBlueprintsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPublicBlueprint</td>
 *      <td><p> Returns the requested public blueprint.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPublicBlueprint(GetPublicBlueprintRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPublicBlueprint(PublicBlueprintName name)
 *           <li><p> getPublicBlueprint(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPublicBlueprintCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDeployment</td>
 *      <td><p> Creates a deployment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDeployment(CreateDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createDeployment(OrchestrationClusterName parent, Deployment deployment, String deploymentId)
 *           <li><p> createDeployment(String parent, Deployment deployment, String deploymentId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDeployment</td>
 *      <td><p> Updates a deployment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDeployment(UpdateDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDeployment(Deployment deployment, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDeployment</td>
 *      <td><p> Returns the requested deployment.</td>
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
 *      <td><p> RemoveDeployment</td>
 *      <td><p> Removes the deployment by marking it as DELETING. Post which deployment and it's revisions gets deleted.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> removeDeployment(RemoveDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> removeDeployment(DeploymentName name)
 *           <li><p> removeDeployment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> removeDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDeployments</td>
 *      <td><p> List all deployments.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDeployments(ListDeploymentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDeployments(OrchestrationClusterName parent)
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
 *      <td><p> ListDeploymentRevisions</td>
 *      <td><p> List deployment revisions of a given deployment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDeploymentRevisions(ListDeploymentRevisionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDeploymentRevisions(DeploymentName name)
 *           <li><p> listDeploymentRevisions(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDeploymentRevisionsPagedCallable()
 *           <li><p> listDeploymentRevisionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DiscardDeploymentChanges</td>
 *      <td><p> Discards the changes in a deployment and reverts the deployment to the last approved deployment revision. No changes take place if a deployment does not have revisions.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> discardDeploymentChanges(DiscardDeploymentChangesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> discardDeploymentChanges(DeploymentName name)
 *           <li><p> discardDeploymentChanges(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> discardDeploymentChangesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ApplyDeployment</td>
 *      <td><p> Applies the deployment's YAML files to the parent orchestration cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> applyDeployment(ApplyDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> applyDeployment(DeploymentName name)
 *           <li><p> applyDeployment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> applyDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ComputeDeploymentStatus</td>
 *      <td><p> Returns the requested deployment status.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> computeDeploymentStatus(ComputeDeploymentStatusRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> computeDeploymentStatus(DeploymentName name)
 *           <li><p> computeDeploymentStatus(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> computeDeploymentStatusCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RollbackDeployment</td>
 *      <td><p> Rollback the active deployment to the given past approved deployment revision.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> rollbackDeployment(RollbackDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> rollbackDeployment(DeploymentName name, String revisionId)
 *           <li><p> rollbackDeployment(String name, String revisionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> rollbackDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetHydratedDeployment</td>
 *      <td><p> Returns the requested hydrated deployment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getHydratedDeployment(GetHydratedDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getHydratedDeployment(HydratedDeploymentName name)
 *           <li><p> getHydratedDeployment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getHydratedDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListHydratedDeployments</td>
 *      <td><p> List all hydrated deployments present under a deployment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listHydratedDeployments(ListHydratedDeploymentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listHydratedDeployments(DeploymentName parent)
 *           <li><p> listHydratedDeployments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listHydratedDeploymentsPagedCallable()
 *           <li><p> listHydratedDeploymentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateHydratedDeployment</td>
 *      <td><p> Updates a hydrated deployment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateHydratedDeployment(UpdateHydratedDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateHydratedDeployment(HydratedDeployment hydratedDeployment, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateHydratedDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ApplyHydratedDeployment</td>
 *      <td><p> Applies a hydrated deployment to a workload cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> applyHydratedDeployment(ApplyHydratedDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> applyHydratedDeployment(HydratedDeploymentName name)
 *           <li><p> applyHydratedDeployment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> applyHydratedDeploymentCallable()
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
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of TelcoAutomationSettings to
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
 * TelcoAutomationSettings telcoAutomationSettings =
 *     TelcoAutomationSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TelcoAutomationClient telcoAutomationClient =
 *     TelcoAutomationClient.create(telcoAutomationSettings);
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
 * TelcoAutomationSettings telcoAutomationSettings =
 *     TelcoAutomationSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TelcoAutomationClient telcoAutomationClient =
 *     TelcoAutomationClient.create(telcoAutomationSettings);
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
 * TelcoAutomationSettings telcoAutomationSettings =
 *     TelcoAutomationSettings.newHttpJsonBuilder().build();
 * TelcoAutomationClient telcoAutomationClient =
 *     TelcoAutomationClient.create(telcoAutomationSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class TelcoAutomationClient implements BackgroundResource {
  private final TelcoAutomationSettings settings;
  private final TelcoAutomationStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of TelcoAutomationClient with default settings. */
  public static final TelcoAutomationClient create() throws IOException {
    return create(TelcoAutomationSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TelcoAutomationClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TelcoAutomationClient create(TelcoAutomationSettings settings)
      throws IOException {
    return new TelcoAutomationClient(settings);
  }

  /**
   * Constructs an instance of TelcoAutomationClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(TelcoAutomationSettings).
   */
  public static final TelcoAutomationClient create(TelcoAutomationStub stub) {
    return new TelcoAutomationClient(stub);
  }

  /**
   * Constructs an instance of TelcoAutomationClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TelcoAutomationClient(TelcoAutomationSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TelcoAutomationStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected TelcoAutomationClient(TelcoAutomationStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final TelcoAutomationSettings getSettings() {
    return settings;
  }

  public TelcoAutomationStub getStub() {
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
   * Lists OrchestrationClusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (OrchestrationCluster element :
   *       telcoAutomationClient.listOrchestrationClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListOrchestrationClustersRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOrchestrationClustersPagedResponse listOrchestrationClusters(
      LocationName parent) {
    ListOrchestrationClustersRequest request =
        ListOrchestrationClustersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listOrchestrationClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists OrchestrationClusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (OrchestrationCluster element :
   *       telcoAutomationClient.listOrchestrationClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListOrchestrationClustersRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOrchestrationClustersPagedResponse listOrchestrationClusters(String parent) {
    ListOrchestrationClustersRequest request =
        ListOrchestrationClustersRequest.newBuilder().setParent(parent).build();
    return listOrchestrationClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists OrchestrationClusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListOrchestrationClustersRequest request =
   *       ListOrchestrationClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (OrchestrationCluster element :
   *       telcoAutomationClient.listOrchestrationClusters(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOrchestrationClustersPagedResponse listOrchestrationClusters(
      ListOrchestrationClustersRequest request) {
    return listOrchestrationClustersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists OrchestrationClusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListOrchestrationClustersRequest request =
   *       ListOrchestrationClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<OrchestrationCluster> future =
   *       telcoAutomationClient.listOrchestrationClustersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (OrchestrationCluster element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListOrchestrationClustersRequest, ListOrchestrationClustersPagedResponse>
      listOrchestrationClustersPagedCallable() {
    return stub.listOrchestrationClustersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists OrchestrationClusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListOrchestrationClustersRequest request =
   *       ListOrchestrationClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListOrchestrationClustersResponse response =
   *         telcoAutomationClient.listOrchestrationClustersCallable().call(request);
   *     for (OrchestrationCluster element : response.getOrchestrationClustersList()) {
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
  public final UnaryCallable<ListOrchestrationClustersRequest, ListOrchestrationClustersResponse>
      listOrchestrationClustersCallable() {
    return stub.listOrchestrationClustersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single OrchestrationCluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   OrchestrationClusterName name =
   *       OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]");
   *   OrchestrationCluster response = telcoAutomationClient.getOrchestrationCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OrchestrationCluster getOrchestrationCluster(OrchestrationClusterName name) {
    GetOrchestrationClusterRequest request =
        GetOrchestrationClusterRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getOrchestrationCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single OrchestrationCluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String name =
   *       OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *           .toString();
   *   OrchestrationCluster response = telcoAutomationClient.getOrchestrationCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OrchestrationCluster getOrchestrationCluster(String name) {
    GetOrchestrationClusterRequest request =
        GetOrchestrationClusterRequest.newBuilder().setName(name).build();
    return getOrchestrationCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single OrchestrationCluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   GetOrchestrationClusterRequest request =
   *       GetOrchestrationClusterRequest.newBuilder()
   *           .setName(
   *               OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *                   .toString())
   *           .build();
   *   OrchestrationCluster response = telcoAutomationClient.getOrchestrationCluster(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OrchestrationCluster getOrchestrationCluster(
      GetOrchestrationClusterRequest request) {
    return getOrchestrationClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single OrchestrationCluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   GetOrchestrationClusterRequest request =
   *       GetOrchestrationClusterRequest.newBuilder()
   *           .setName(
   *               OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *                   .toString())
   *           .build();
   *   ApiFuture<OrchestrationCluster> future =
   *       telcoAutomationClient.getOrchestrationClusterCallable().futureCall(request);
   *   // Do something.
   *   OrchestrationCluster response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetOrchestrationClusterRequest, OrchestrationCluster>
      getOrchestrationClusterCallable() {
    return stub.getOrchestrationClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new OrchestrationCluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   OrchestrationCluster orchestrationCluster = OrchestrationCluster.newBuilder().build();
   *   String orchestrationClusterId = "orchestrationClusterId75469684";
   *   OrchestrationCluster response =
   *       telcoAutomationClient
   *           .createOrchestrationClusterAsync(parent, orchestrationCluster, orchestrationClusterId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param orchestrationCluster Required. The resource being created
   * @param orchestrationClusterId Required. Id of the requesting object If auto-generating Id
   *     server-side, remove this field and orchestration_cluster_id from the method_signature of
   *     Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<OrchestrationCluster, OperationMetadata>
      createOrchestrationClusterAsync(
          LocationName parent,
          OrchestrationCluster orchestrationCluster,
          String orchestrationClusterId) {
    CreateOrchestrationClusterRequest request =
        CreateOrchestrationClusterRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setOrchestrationCluster(orchestrationCluster)
            .setOrchestrationClusterId(orchestrationClusterId)
            .build();
    return createOrchestrationClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new OrchestrationCluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   OrchestrationCluster orchestrationCluster = OrchestrationCluster.newBuilder().build();
   *   String orchestrationClusterId = "orchestrationClusterId75469684";
   *   OrchestrationCluster response =
   *       telcoAutomationClient
   *           .createOrchestrationClusterAsync(parent, orchestrationCluster, orchestrationClusterId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param orchestrationCluster Required. The resource being created
   * @param orchestrationClusterId Required. Id of the requesting object If auto-generating Id
   *     server-side, remove this field and orchestration_cluster_id from the method_signature of
   *     Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<OrchestrationCluster, OperationMetadata>
      createOrchestrationClusterAsync(
          String parent, OrchestrationCluster orchestrationCluster, String orchestrationClusterId) {
    CreateOrchestrationClusterRequest request =
        CreateOrchestrationClusterRequest.newBuilder()
            .setParent(parent)
            .setOrchestrationCluster(orchestrationCluster)
            .setOrchestrationClusterId(orchestrationClusterId)
            .build();
    return createOrchestrationClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new OrchestrationCluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   CreateOrchestrationClusterRequest request =
   *       CreateOrchestrationClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setOrchestrationClusterId("orchestrationClusterId75469684")
   *           .setOrchestrationCluster(OrchestrationCluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OrchestrationCluster response =
   *       telcoAutomationClient.createOrchestrationClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<OrchestrationCluster, OperationMetadata>
      createOrchestrationClusterAsync(CreateOrchestrationClusterRequest request) {
    return createOrchestrationClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new OrchestrationCluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   CreateOrchestrationClusterRequest request =
   *       CreateOrchestrationClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setOrchestrationClusterId("orchestrationClusterId75469684")
   *           .setOrchestrationCluster(OrchestrationCluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<OrchestrationCluster, OperationMetadata> future =
   *       telcoAutomationClient.createOrchestrationClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   OrchestrationCluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateOrchestrationClusterRequest, OrchestrationCluster, OperationMetadata>
      createOrchestrationClusterOperationCallable() {
    return stub.createOrchestrationClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new OrchestrationCluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   CreateOrchestrationClusterRequest request =
   *       CreateOrchestrationClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setOrchestrationClusterId("orchestrationClusterId75469684")
   *           .setOrchestrationCluster(OrchestrationCluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       telcoAutomationClient.createOrchestrationClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateOrchestrationClusterRequest, Operation>
      createOrchestrationClusterCallable() {
    return stub.createOrchestrationClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single OrchestrationCluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   OrchestrationClusterName name =
   *       OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]");
   *   telcoAutomationClient.deleteOrchestrationClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteOrchestrationClusterAsync(
      OrchestrationClusterName name) {
    DeleteOrchestrationClusterRequest request =
        DeleteOrchestrationClusterRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteOrchestrationClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single OrchestrationCluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String name =
   *       OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *           .toString();
   *   telcoAutomationClient.deleteOrchestrationClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteOrchestrationClusterAsync(
      String name) {
    DeleteOrchestrationClusterRequest request =
        DeleteOrchestrationClusterRequest.newBuilder().setName(name).build();
    return deleteOrchestrationClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single OrchestrationCluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   DeleteOrchestrationClusterRequest request =
   *       DeleteOrchestrationClusterRequest.newBuilder()
   *           .setName(
   *               OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   telcoAutomationClient.deleteOrchestrationClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteOrchestrationClusterAsync(
      DeleteOrchestrationClusterRequest request) {
    return deleteOrchestrationClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single OrchestrationCluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   DeleteOrchestrationClusterRequest request =
   *       DeleteOrchestrationClusterRequest.newBuilder()
   *           .setName(
   *               OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       telcoAutomationClient.deleteOrchestrationClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteOrchestrationClusterRequest, Empty, OperationMetadata>
      deleteOrchestrationClusterOperationCallable() {
    return stub.deleteOrchestrationClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single OrchestrationCluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   DeleteOrchestrationClusterRequest request =
   *       DeleteOrchestrationClusterRequest.newBuilder()
   *           .setName(
   *               OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       telcoAutomationClient.deleteOrchestrationClusterCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteOrchestrationClusterRequest, Operation>
      deleteOrchestrationClusterCallable() {
    return stub.deleteOrchestrationClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EdgeSlms in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (EdgeSlm element : telcoAutomationClient.listEdgeSlms(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListEdgeSlmsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEdgeSlmsPagedResponse listEdgeSlms(LocationName parent) {
    ListEdgeSlmsRequest request =
        ListEdgeSlmsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEdgeSlms(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EdgeSlms in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (EdgeSlm element : telcoAutomationClient.listEdgeSlms(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListEdgeSlmsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEdgeSlmsPagedResponse listEdgeSlms(String parent) {
    ListEdgeSlmsRequest request = ListEdgeSlmsRequest.newBuilder().setParent(parent).build();
    return listEdgeSlms(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EdgeSlms in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListEdgeSlmsRequest request =
   *       ListEdgeSlmsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (EdgeSlm element : telcoAutomationClient.listEdgeSlms(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEdgeSlmsPagedResponse listEdgeSlms(ListEdgeSlmsRequest request) {
    return listEdgeSlmsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EdgeSlms in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListEdgeSlmsRequest request =
   *       ListEdgeSlmsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<EdgeSlm> future =
   *       telcoAutomationClient.listEdgeSlmsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (EdgeSlm element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEdgeSlmsRequest, ListEdgeSlmsPagedResponse>
      listEdgeSlmsPagedCallable() {
    return stub.listEdgeSlmsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EdgeSlms in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListEdgeSlmsRequest request =
   *       ListEdgeSlmsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListEdgeSlmsResponse response = telcoAutomationClient.listEdgeSlmsCallable().call(request);
   *     for (EdgeSlm element : response.getEdgeSlmsList()) {
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
  public final UnaryCallable<ListEdgeSlmsRequest, ListEdgeSlmsResponse> listEdgeSlmsCallable() {
    return stub.listEdgeSlmsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single EdgeSlm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   EdgeSlmName name = EdgeSlmName.of("[PROJECT]", "[LOCATION]", "[EDGE_SLM]");
   *   EdgeSlm response = telcoAutomationClient.getEdgeSlm(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EdgeSlm getEdgeSlm(EdgeSlmName name) {
    GetEdgeSlmRequest request =
        GetEdgeSlmRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEdgeSlm(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single EdgeSlm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String name = EdgeSlmName.of("[PROJECT]", "[LOCATION]", "[EDGE_SLM]").toString();
   *   EdgeSlm response = telcoAutomationClient.getEdgeSlm(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EdgeSlm getEdgeSlm(String name) {
    GetEdgeSlmRequest request = GetEdgeSlmRequest.newBuilder().setName(name).build();
    return getEdgeSlm(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single EdgeSlm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   GetEdgeSlmRequest request =
   *       GetEdgeSlmRequest.newBuilder()
   *           .setName(EdgeSlmName.of("[PROJECT]", "[LOCATION]", "[EDGE_SLM]").toString())
   *           .build();
   *   EdgeSlm response = telcoAutomationClient.getEdgeSlm(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EdgeSlm getEdgeSlm(GetEdgeSlmRequest request) {
    return getEdgeSlmCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single EdgeSlm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   GetEdgeSlmRequest request =
   *       GetEdgeSlmRequest.newBuilder()
   *           .setName(EdgeSlmName.of("[PROJECT]", "[LOCATION]", "[EDGE_SLM]").toString())
   *           .build();
   *   ApiFuture<EdgeSlm> future = telcoAutomationClient.getEdgeSlmCallable().futureCall(request);
   *   // Do something.
   *   EdgeSlm response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEdgeSlmRequest, EdgeSlm> getEdgeSlmCallable() {
    return stub.getEdgeSlmCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new EdgeSlm in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   EdgeSlm edgeSlm = EdgeSlm.newBuilder().build();
   *   String edgeSlmId = "edgeSlmId213186994";
   *   EdgeSlm response = telcoAutomationClient.createEdgeSlmAsync(parent, edgeSlm, edgeSlmId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param edgeSlm Required. The resource being created
   * @param edgeSlmId Required. Id of the requesting object If auto-generating Id server-side,
   *     remove this field and edge_slm_id from the method_signature of Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EdgeSlm, OperationMetadata> createEdgeSlmAsync(
      LocationName parent, EdgeSlm edgeSlm, String edgeSlmId) {
    CreateEdgeSlmRequest request =
        CreateEdgeSlmRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEdgeSlm(edgeSlm)
            .setEdgeSlmId(edgeSlmId)
            .build();
    return createEdgeSlmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new EdgeSlm in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   EdgeSlm edgeSlm = EdgeSlm.newBuilder().build();
   *   String edgeSlmId = "edgeSlmId213186994";
   *   EdgeSlm response = telcoAutomationClient.createEdgeSlmAsync(parent, edgeSlm, edgeSlmId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param edgeSlm Required. The resource being created
   * @param edgeSlmId Required. Id of the requesting object If auto-generating Id server-side,
   *     remove this field and edge_slm_id from the method_signature of Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EdgeSlm, OperationMetadata> createEdgeSlmAsync(
      String parent, EdgeSlm edgeSlm, String edgeSlmId) {
    CreateEdgeSlmRequest request =
        CreateEdgeSlmRequest.newBuilder()
            .setParent(parent)
            .setEdgeSlm(edgeSlm)
            .setEdgeSlmId(edgeSlmId)
            .build();
    return createEdgeSlmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new EdgeSlm in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   CreateEdgeSlmRequest request =
   *       CreateEdgeSlmRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEdgeSlmId("edgeSlmId213186994")
   *           .setEdgeSlm(EdgeSlm.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   EdgeSlm response = telcoAutomationClient.createEdgeSlmAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EdgeSlm, OperationMetadata> createEdgeSlmAsync(
      CreateEdgeSlmRequest request) {
    return createEdgeSlmOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new EdgeSlm in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   CreateEdgeSlmRequest request =
   *       CreateEdgeSlmRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEdgeSlmId("edgeSlmId213186994")
   *           .setEdgeSlm(EdgeSlm.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<EdgeSlm, OperationMetadata> future =
   *       telcoAutomationClient.createEdgeSlmOperationCallable().futureCall(request);
   *   // Do something.
   *   EdgeSlm response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateEdgeSlmRequest, EdgeSlm, OperationMetadata>
      createEdgeSlmOperationCallable() {
    return stub.createEdgeSlmOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new EdgeSlm in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   CreateEdgeSlmRequest request =
   *       CreateEdgeSlmRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEdgeSlmId("edgeSlmId213186994")
   *           .setEdgeSlm(EdgeSlm.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       telcoAutomationClient.createEdgeSlmCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEdgeSlmRequest, Operation> createEdgeSlmCallable() {
    return stub.createEdgeSlmCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single EdgeSlm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   EdgeSlmName name = EdgeSlmName.of("[PROJECT]", "[LOCATION]", "[EDGE_SLM]");
   *   telcoAutomationClient.deleteEdgeSlmAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEdgeSlmAsync(EdgeSlmName name) {
    DeleteEdgeSlmRequest request =
        DeleteEdgeSlmRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteEdgeSlmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single EdgeSlm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String name = EdgeSlmName.of("[PROJECT]", "[LOCATION]", "[EDGE_SLM]").toString();
   *   telcoAutomationClient.deleteEdgeSlmAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEdgeSlmAsync(String name) {
    DeleteEdgeSlmRequest request = DeleteEdgeSlmRequest.newBuilder().setName(name).build();
    return deleteEdgeSlmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single EdgeSlm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   DeleteEdgeSlmRequest request =
   *       DeleteEdgeSlmRequest.newBuilder()
   *           .setName(EdgeSlmName.of("[PROJECT]", "[LOCATION]", "[EDGE_SLM]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   telcoAutomationClient.deleteEdgeSlmAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEdgeSlmAsync(
      DeleteEdgeSlmRequest request) {
    return deleteEdgeSlmOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single EdgeSlm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   DeleteEdgeSlmRequest request =
   *       DeleteEdgeSlmRequest.newBuilder()
   *           .setName(EdgeSlmName.of("[PROJECT]", "[LOCATION]", "[EDGE_SLM]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       telcoAutomationClient.deleteEdgeSlmOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteEdgeSlmRequest, Empty, OperationMetadata>
      deleteEdgeSlmOperationCallable() {
    return stub.deleteEdgeSlmOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single EdgeSlm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   DeleteEdgeSlmRequest request =
   *       DeleteEdgeSlmRequest.newBuilder()
   *           .setName(EdgeSlmName.of("[PROJECT]", "[LOCATION]", "[EDGE_SLM]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       telcoAutomationClient.deleteEdgeSlmCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEdgeSlmRequest, Operation> deleteEdgeSlmCallable() {
    return stub.deleteEdgeSlmCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a blueprint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   OrchestrationClusterName parent =
   *       OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]");
   *   Blueprint blueprint = Blueprint.newBuilder().build();
   *   String blueprintId = "blueprintId-1159505138";
   *   Blueprint response = telcoAutomationClient.createBlueprint(parent, blueprint, blueprintId);
   * }
   * }</pre>
   *
   * @param parent Required. The name of parent resource. Format should be -
   *     "projects/{project_id}/locations/{location_name}/orchestrationClusters/{orchestration_cluster}".
   * @param blueprint Required. The `Blueprint` to create.
   * @param blueprintId Optional. The name of the blueprint.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Blueprint createBlueprint(
      OrchestrationClusterName parent, Blueprint blueprint, String blueprintId) {
    CreateBlueprintRequest request =
        CreateBlueprintRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBlueprint(blueprint)
            .setBlueprintId(blueprintId)
            .build();
    return createBlueprint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a blueprint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String parent =
   *       OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *           .toString();
   *   Blueprint blueprint = Blueprint.newBuilder().build();
   *   String blueprintId = "blueprintId-1159505138";
   *   Blueprint response = telcoAutomationClient.createBlueprint(parent, blueprint, blueprintId);
   * }
   * }</pre>
   *
   * @param parent Required. The name of parent resource. Format should be -
   *     "projects/{project_id}/locations/{location_name}/orchestrationClusters/{orchestration_cluster}".
   * @param blueprint Required. The `Blueprint` to create.
   * @param blueprintId Optional. The name of the blueprint.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Blueprint createBlueprint(String parent, Blueprint blueprint, String blueprintId) {
    CreateBlueprintRequest request =
        CreateBlueprintRequest.newBuilder()
            .setParent(parent)
            .setBlueprint(blueprint)
            .setBlueprintId(blueprintId)
            .build();
    return createBlueprint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a blueprint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   CreateBlueprintRequest request =
   *       CreateBlueprintRequest.newBuilder()
   *           .setParent(
   *               OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *                   .toString())
   *           .setBlueprintId("blueprintId-1159505138")
   *           .setBlueprint(Blueprint.newBuilder().build())
   *           .build();
   *   Blueprint response = telcoAutomationClient.createBlueprint(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Blueprint createBlueprint(CreateBlueprintRequest request) {
    return createBlueprintCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a blueprint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   CreateBlueprintRequest request =
   *       CreateBlueprintRequest.newBuilder()
   *           .setParent(
   *               OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *                   .toString())
   *           .setBlueprintId("blueprintId-1159505138")
   *           .setBlueprint(Blueprint.newBuilder().build())
   *           .build();
   *   ApiFuture<Blueprint> future =
   *       telcoAutomationClient.createBlueprintCallable().futureCall(request);
   *   // Do something.
   *   Blueprint response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBlueprintRequest, Blueprint> createBlueprintCallable() {
    return stub.createBlueprintCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a blueprint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   Blueprint blueprint = Blueprint.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Blueprint response = telcoAutomationClient.updateBlueprint(blueprint, updateMask);
   * }
   * }</pre>
   *
   * @param blueprint Required. The `blueprint` to update.
   * @param updateMask Required. Update mask is used to specify the fields to be overwritten in the
   *     `blueprint` resource by the update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Blueprint updateBlueprint(Blueprint blueprint, FieldMask updateMask) {
    UpdateBlueprintRequest request =
        UpdateBlueprintRequest.newBuilder()
            .setBlueprint(blueprint)
            .setUpdateMask(updateMask)
            .build();
    return updateBlueprint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a blueprint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   UpdateBlueprintRequest request =
   *       UpdateBlueprintRequest.newBuilder()
   *           .setBlueprint(Blueprint.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Blueprint response = telcoAutomationClient.updateBlueprint(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Blueprint updateBlueprint(UpdateBlueprintRequest request) {
    return updateBlueprintCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a blueprint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   UpdateBlueprintRequest request =
   *       UpdateBlueprintRequest.newBuilder()
   *           .setBlueprint(Blueprint.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Blueprint> future =
   *       telcoAutomationClient.updateBlueprintCallable().futureCall(request);
   *   // Do something.
   *   Blueprint response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBlueprintRequest, Blueprint> updateBlueprintCallable() {
    return stub.updateBlueprintCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested blueprint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   BlueprintName name =
   *       BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]");
   *   Blueprint response = telcoAutomationClient.getBlueprint(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the blueprint. Case 1: If the name provided in the request is
   *     {blueprint_id}{@literal @}{revision_id}, then the revision with revision_id will be
   *     returned. Case 2: If the name provided in the request is {blueprint}, then the current
   *     state of the blueprint is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Blueprint getBlueprint(BlueprintName name) {
    GetBlueprintRequest request =
        GetBlueprintRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBlueprint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested blueprint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String name =
   *       BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
   *           .toString();
   *   Blueprint response = telcoAutomationClient.getBlueprint(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the blueprint. Case 1: If the name provided in the request is
   *     {blueprint_id}{@literal @}{revision_id}, then the revision with revision_id will be
   *     returned. Case 2: If the name provided in the request is {blueprint}, then the current
   *     state of the blueprint is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Blueprint getBlueprint(String name) {
    GetBlueprintRequest request = GetBlueprintRequest.newBuilder().setName(name).build();
    return getBlueprint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested blueprint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   GetBlueprintRequest request =
   *       GetBlueprintRequest.newBuilder()
   *           .setName(
   *               BlueprintName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
   *                   .toString())
   *           .setView(BlueprintView.forNumber(0))
   *           .build();
   *   Blueprint response = telcoAutomationClient.getBlueprint(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Blueprint getBlueprint(GetBlueprintRequest request) {
    return getBlueprintCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested blueprint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   GetBlueprintRequest request =
   *       GetBlueprintRequest.newBuilder()
   *           .setName(
   *               BlueprintName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
   *                   .toString())
   *           .setView(BlueprintView.forNumber(0))
   *           .build();
   *   ApiFuture<Blueprint> future =
   *       telcoAutomationClient.getBlueprintCallable().futureCall(request);
   *   // Do something.
   *   Blueprint response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBlueprintRequest, Blueprint> getBlueprintCallable() {
    return stub.getBlueprintCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a blueprint and all its revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   BlueprintName name =
   *       BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]");
   *   telcoAutomationClient.deleteBlueprint(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of blueprint to delete. Blueprint name should be in the format
   *     {blueprint_id}, if {blueprint_id}{@literal @}{revision_id} is passed then the API throws
   *     invalid argument.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBlueprint(BlueprintName name) {
    DeleteBlueprintRequest request =
        DeleteBlueprintRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteBlueprint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a blueprint and all its revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String name =
   *       BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
   *           .toString();
   *   telcoAutomationClient.deleteBlueprint(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of blueprint to delete. Blueprint name should be in the format
   *     {blueprint_id}, if {blueprint_id}{@literal @}{revision_id} is passed then the API throws
   *     invalid argument.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBlueprint(String name) {
    DeleteBlueprintRequest request = DeleteBlueprintRequest.newBuilder().setName(name).build();
    deleteBlueprint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a blueprint and all its revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   DeleteBlueprintRequest request =
   *       DeleteBlueprintRequest.newBuilder()
   *           .setName(
   *               BlueprintName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
   *                   .toString())
   *           .build();
   *   telcoAutomationClient.deleteBlueprint(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBlueprint(DeleteBlueprintRequest request) {
    deleteBlueprintCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a blueprint and all its revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   DeleteBlueprintRequest request =
   *       DeleteBlueprintRequest.newBuilder()
   *           .setName(
   *               BlueprintName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = telcoAutomationClient.deleteBlueprintCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBlueprintRequest, Empty> deleteBlueprintCallable() {
    return stub.deleteBlueprintCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all blueprints.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   OrchestrationClusterName parent =
   *       OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]");
   *   for (Blueprint element : telcoAutomationClient.listBlueprints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of parent orchestration cluster resource. Format should be -
   *     "projects/{project_id}/locations/{location_name}/orchestrationClusters/{orchestration_cluster}".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBlueprintsPagedResponse listBlueprints(OrchestrationClusterName parent) {
    ListBlueprintsRequest request =
        ListBlueprintsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBlueprints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all blueprints.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String parent =
   *       OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *           .toString();
   *   for (Blueprint element : telcoAutomationClient.listBlueprints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of parent orchestration cluster resource. Format should be -
   *     "projects/{project_id}/locations/{location_name}/orchestrationClusters/{orchestration_cluster}".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBlueprintsPagedResponse listBlueprints(String parent) {
    ListBlueprintsRequest request = ListBlueprintsRequest.newBuilder().setParent(parent).build();
    return listBlueprints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all blueprints.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListBlueprintsRequest request =
   *       ListBlueprintsRequest.newBuilder()
   *           .setParent(
   *               OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Blueprint element : telcoAutomationClient.listBlueprints(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBlueprintsPagedResponse listBlueprints(ListBlueprintsRequest request) {
    return listBlueprintsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all blueprints.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListBlueprintsRequest request =
   *       ListBlueprintsRequest.newBuilder()
   *           .setParent(
   *               OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Blueprint> future =
   *       telcoAutomationClient.listBlueprintsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Blueprint element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBlueprintsRequest, ListBlueprintsPagedResponse>
      listBlueprintsPagedCallable() {
    return stub.listBlueprintsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all blueprints.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListBlueprintsRequest request =
   *       ListBlueprintsRequest.newBuilder()
   *           .setParent(
   *               OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListBlueprintsResponse response =
   *         telcoAutomationClient.listBlueprintsCallable().call(request);
   *     for (Blueprint element : response.getBlueprintsList()) {
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
  public final UnaryCallable<ListBlueprintsRequest, ListBlueprintsResponse>
      listBlueprintsCallable() {
    return stub.listBlueprintsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a blueprint and commits a new revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   BlueprintName name =
   *       BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]");
   *   Blueprint response = telcoAutomationClient.approveBlueprint(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the blueprint to approve. The blueprint must be in Proposed
   *     state. A new revision is committed on approval.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Blueprint approveBlueprint(BlueprintName name) {
    ApproveBlueprintRequest request =
        ApproveBlueprintRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return approveBlueprint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a blueprint and commits a new revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String name =
   *       BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
   *           .toString();
   *   Blueprint response = telcoAutomationClient.approveBlueprint(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the blueprint to approve. The blueprint must be in Proposed
   *     state. A new revision is committed on approval.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Blueprint approveBlueprint(String name) {
    ApproveBlueprintRequest request = ApproveBlueprintRequest.newBuilder().setName(name).build();
    return approveBlueprint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a blueprint and commits a new revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ApproveBlueprintRequest request =
   *       ApproveBlueprintRequest.newBuilder()
   *           .setName(
   *               BlueprintName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
   *                   .toString())
   *           .build();
   *   Blueprint response = telcoAutomationClient.approveBlueprint(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Blueprint approveBlueprint(ApproveBlueprintRequest request) {
    return approveBlueprintCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a blueprint and commits a new revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ApproveBlueprintRequest request =
   *       ApproveBlueprintRequest.newBuilder()
   *           .setName(
   *               BlueprintName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Blueprint> future =
   *       telcoAutomationClient.approveBlueprintCallable().futureCall(request);
   *   // Do something.
   *   Blueprint response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ApproveBlueprintRequest, Blueprint> approveBlueprintCallable() {
    return stub.approveBlueprintCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Proposes a blueprint for approval of changes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   BlueprintName name =
   *       BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]");
   *   Blueprint response = telcoAutomationClient.proposeBlueprint(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the blueprint being proposed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Blueprint proposeBlueprint(BlueprintName name) {
    ProposeBlueprintRequest request =
        ProposeBlueprintRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return proposeBlueprint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Proposes a blueprint for approval of changes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String name =
   *       BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
   *           .toString();
   *   Blueprint response = telcoAutomationClient.proposeBlueprint(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the blueprint being proposed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Blueprint proposeBlueprint(String name) {
    ProposeBlueprintRequest request = ProposeBlueprintRequest.newBuilder().setName(name).build();
    return proposeBlueprint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Proposes a blueprint for approval of changes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ProposeBlueprintRequest request =
   *       ProposeBlueprintRequest.newBuilder()
   *           .setName(
   *               BlueprintName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
   *                   .toString())
   *           .build();
   *   Blueprint response = telcoAutomationClient.proposeBlueprint(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Blueprint proposeBlueprint(ProposeBlueprintRequest request) {
    return proposeBlueprintCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Proposes a blueprint for approval of changes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ProposeBlueprintRequest request =
   *       ProposeBlueprintRequest.newBuilder()
   *           .setName(
   *               BlueprintName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Blueprint> future =
   *       telcoAutomationClient.proposeBlueprintCallable().futureCall(request);
   *   // Do something.
   *   Blueprint response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ProposeBlueprintRequest, Blueprint> proposeBlueprintCallable() {
    return stub.proposeBlueprintCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rejects a blueprint revision proposal and flips it back to Draft state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   BlueprintName name =
   *       BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]");
   *   Blueprint response = telcoAutomationClient.rejectBlueprint(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the blueprint being rejected.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Blueprint rejectBlueprint(BlueprintName name) {
    RejectBlueprintRequest request =
        RejectBlueprintRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return rejectBlueprint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rejects a blueprint revision proposal and flips it back to Draft state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String name =
   *       BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
   *           .toString();
   *   Blueprint response = telcoAutomationClient.rejectBlueprint(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the blueprint being rejected.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Blueprint rejectBlueprint(String name) {
    RejectBlueprintRequest request = RejectBlueprintRequest.newBuilder().setName(name).build();
    return rejectBlueprint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rejects a blueprint revision proposal and flips it back to Draft state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   RejectBlueprintRequest request =
   *       RejectBlueprintRequest.newBuilder()
   *           .setName(
   *               BlueprintName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
   *                   .toString())
   *           .build();
   *   Blueprint response = telcoAutomationClient.rejectBlueprint(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Blueprint rejectBlueprint(RejectBlueprintRequest request) {
    return rejectBlueprintCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rejects a blueprint revision proposal and flips it back to Draft state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   RejectBlueprintRequest request =
   *       RejectBlueprintRequest.newBuilder()
   *           .setName(
   *               BlueprintName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Blueprint> future =
   *       telcoAutomationClient.rejectBlueprintCallable().futureCall(request);
   *   // Do something.
   *   Blueprint response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RejectBlueprintRequest, Blueprint> rejectBlueprintCallable() {
    return stub.rejectBlueprintCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List blueprint revisions of a given blueprint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   BlueprintName name =
   *       BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]");
   *   for (Blueprint element : telcoAutomationClient.listBlueprintRevisions(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The name of the blueprint to list revisions for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBlueprintRevisionsPagedResponse listBlueprintRevisions(BlueprintName name) {
    ListBlueprintRevisionsRequest request =
        ListBlueprintRevisionsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return listBlueprintRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List blueprint revisions of a given blueprint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String name =
   *       BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
   *           .toString();
   *   for (Blueprint element : telcoAutomationClient.listBlueprintRevisions(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The name of the blueprint to list revisions for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBlueprintRevisionsPagedResponse listBlueprintRevisions(String name) {
    ListBlueprintRevisionsRequest request =
        ListBlueprintRevisionsRequest.newBuilder().setName(name).build();
    return listBlueprintRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List blueprint revisions of a given blueprint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListBlueprintRevisionsRequest request =
   *       ListBlueprintRevisionsRequest.newBuilder()
   *           .setName(
   *               BlueprintName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Blueprint element : telcoAutomationClient.listBlueprintRevisions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBlueprintRevisionsPagedResponse listBlueprintRevisions(
      ListBlueprintRevisionsRequest request) {
    return listBlueprintRevisionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List blueprint revisions of a given blueprint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListBlueprintRevisionsRequest request =
   *       ListBlueprintRevisionsRequest.newBuilder()
   *           .setName(
   *               BlueprintName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Blueprint> future =
   *       telcoAutomationClient.listBlueprintRevisionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Blueprint element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBlueprintRevisionsRequest, ListBlueprintRevisionsPagedResponse>
      listBlueprintRevisionsPagedCallable() {
    return stub.listBlueprintRevisionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List blueprint revisions of a given blueprint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListBlueprintRevisionsRequest request =
   *       ListBlueprintRevisionsRequest.newBuilder()
   *           .setName(
   *               BlueprintName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListBlueprintRevisionsResponse response =
   *         telcoAutomationClient.listBlueprintRevisionsCallable().call(request);
   *     for (Blueprint element : response.getBlueprintsList()) {
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
  public final UnaryCallable<ListBlueprintRevisionsRequest, ListBlueprintRevisionsResponse>
      listBlueprintRevisionsCallable() {
    return stub.listBlueprintRevisionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches across blueprint revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   OrchestrationClusterName parent =
   *       OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]");
   *   String query = "query107944136";
   *   for (Blueprint element :
   *       telcoAutomationClient.searchBlueprintRevisions(parent, query).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of parent orchestration cluster resource. Format should be -
   *     "projects/{project_id}/locations/{location_name}/orchestrationClusters/{orchestration_cluster}".
   * @param query Required. Supported queries: 1. "" : Lists all revisions across all blueprints. 2.
   *     "latest=true" : Lists latest revisions across all blueprints. 3. "name={name}" : Lists all
   *     revisions of blueprint with name {name}. 4. "name={name} latest=true": Lists latest
   *     revision of blueprint with name {name}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchBlueprintRevisionsPagedResponse searchBlueprintRevisions(
      OrchestrationClusterName parent, String query) {
    SearchBlueprintRevisionsRequest request =
        SearchBlueprintRevisionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setQuery(query)
            .build();
    return searchBlueprintRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches across blueprint revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String parent =
   *       OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *           .toString();
   *   String query = "query107944136";
   *   for (Blueprint element :
   *       telcoAutomationClient.searchBlueprintRevisions(parent, query).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of parent orchestration cluster resource. Format should be -
   *     "projects/{project_id}/locations/{location_name}/orchestrationClusters/{orchestration_cluster}".
   * @param query Required. Supported queries: 1. "" : Lists all revisions across all blueprints. 2.
   *     "latest=true" : Lists latest revisions across all blueprints. 3. "name={name}" : Lists all
   *     revisions of blueprint with name {name}. 4. "name={name} latest=true": Lists latest
   *     revision of blueprint with name {name}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchBlueprintRevisionsPagedResponse searchBlueprintRevisions(
      String parent, String query) {
    SearchBlueprintRevisionsRequest request =
        SearchBlueprintRevisionsRequest.newBuilder().setParent(parent).setQuery(query).build();
    return searchBlueprintRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches across blueprint revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   SearchBlueprintRevisionsRequest request =
   *       SearchBlueprintRevisionsRequest.newBuilder()
   *           .setParent(
   *               OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *                   .toString())
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Blueprint element :
   *       telcoAutomationClient.searchBlueprintRevisions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchBlueprintRevisionsPagedResponse searchBlueprintRevisions(
      SearchBlueprintRevisionsRequest request) {
    return searchBlueprintRevisionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches across blueprint revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   SearchBlueprintRevisionsRequest request =
   *       SearchBlueprintRevisionsRequest.newBuilder()
   *           .setParent(
   *               OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *                   .toString())
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Blueprint> future =
   *       telcoAutomationClient.searchBlueprintRevisionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Blueprint element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsPagedResponse>
      searchBlueprintRevisionsPagedCallable() {
    return stub.searchBlueprintRevisionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches across blueprint revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   SearchBlueprintRevisionsRequest request =
   *       SearchBlueprintRevisionsRequest.newBuilder()
   *           .setParent(
   *               OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *                   .toString())
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchBlueprintRevisionsResponse response =
   *         telcoAutomationClient.searchBlueprintRevisionsCallable().call(request);
   *     for (Blueprint element : response.getBlueprintsList()) {
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
  public final UnaryCallable<SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsResponse>
      searchBlueprintRevisionsCallable() {
    return stub.searchBlueprintRevisionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches across deployment revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   OrchestrationClusterName parent =
   *       OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]");
   *   String query = "query107944136";
   *   for (Deployment element :
   *       telcoAutomationClient.searchDeploymentRevisions(parent, query).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of parent orchestration cluster resource. Format should be -
   *     "projects/{project_id}/locations/{location_name}/orchestrationClusters/{orchestration_cluster}".
   * @param query Required. Supported queries: 1. "" : Lists all revisions across all deployments.
   *     2. "latest=true" : Lists latest revisions across all deployments. 3. "name={name}" : Lists
   *     all revisions of deployment with name {name}. 4. "name={name} latest=true": Lists latest
   *     revision of deployment with name {name}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchDeploymentRevisionsPagedResponse searchDeploymentRevisions(
      OrchestrationClusterName parent, String query) {
    SearchDeploymentRevisionsRequest request =
        SearchDeploymentRevisionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setQuery(query)
            .build();
    return searchDeploymentRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches across deployment revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String parent =
   *       OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *           .toString();
   *   String query = "query107944136";
   *   for (Deployment element :
   *       telcoAutomationClient.searchDeploymentRevisions(parent, query).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of parent orchestration cluster resource. Format should be -
   *     "projects/{project_id}/locations/{location_name}/orchestrationClusters/{orchestration_cluster}".
   * @param query Required. Supported queries: 1. "" : Lists all revisions across all deployments.
   *     2. "latest=true" : Lists latest revisions across all deployments. 3. "name={name}" : Lists
   *     all revisions of deployment with name {name}. 4. "name={name} latest=true": Lists latest
   *     revision of deployment with name {name}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchDeploymentRevisionsPagedResponse searchDeploymentRevisions(
      String parent, String query) {
    SearchDeploymentRevisionsRequest request =
        SearchDeploymentRevisionsRequest.newBuilder().setParent(parent).setQuery(query).build();
    return searchDeploymentRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches across deployment revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   SearchDeploymentRevisionsRequest request =
   *       SearchDeploymentRevisionsRequest.newBuilder()
   *           .setParent(
   *               OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *                   .toString())
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Deployment element :
   *       telcoAutomationClient.searchDeploymentRevisions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchDeploymentRevisionsPagedResponse searchDeploymentRevisions(
      SearchDeploymentRevisionsRequest request) {
    return searchDeploymentRevisionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches across deployment revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   SearchDeploymentRevisionsRequest request =
   *       SearchDeploymentRevisionsRequest.newBuilder()
   *           .setParent(
   *               OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *                   .toString())
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Deployment> future =
   *       telcoAutomationClient.searchDeploymentRevisionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Deployment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsPagedResponse>
      searchDeploymentRevisionsPagedCallable() {
    return stub.searchDeploymentRevisionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches across deployment revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   SearchDeploymentRevisionsRequest request =
   *       SearchDeploymentRevisionsRequest.newBuilder()
   *           .setParent(
   *               OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *                   .toString())
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchDeploymentRevisionsResponse response =
   *         telcoAutomationClient.searchDeploymentRevisionsCallable().call(request);
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
  public final UnaryCallable<SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsResponse>
      searchDeploymentRevisionsCallable() {
    return stub.searchDeploymentRevisionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Discards the changes in a blueprint and reverts the blueprint to the last approved blueprint
   * revision. No changes take place if a blueprint does not have revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   BlueprintName name =
   *       BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]");
   *   DiscardBlueprintChangesResponse response =
   *       telcoAutomationClient.discardBlueprintChanges(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the blueprint of which changes are being discarded.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiscardBlueprintChangesResponse discardBlueprintChanges(BlueprintName name) {
    DiscardBlueprintChangesRequest request =
        DiscardBlueprintChangesRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return discardBlueprintChanges(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Discards the changes in a blueprint and reverts the blueprint to the last approved blueprint
   * revision. No changes take place if a blueprint does not have revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String name =
   *       BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
   *           .toString();
   *   DiscardBlueprintChangesResponse response =
   *       telcoAutomationClient.discardBlueprintChanges(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the blueprint of which changes are being discarded.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiscardBlueprintChangesResponse discardBlueprintChanges(String name) {
    DiscardBlueprintChangesRequest request =
        DiscardBlueprintChangesRequest.newBuilder().setName(name).build();
    return discardBlueprintChanges(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Discards the changes in a blueprint and reverts the blueprint to the last approved blueprint
   * revision. No changes take place if a blueprint does not have revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   DiscardBlueprintChangesRequest request =
   *       DiscardBlueprintChangesRequest.newBuilder()
   *           .setName(
   *               BlueprintName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
   *                   .toString())
   *           .build();
   *   DiscardBlueprintChangesResponse response =
   *       telcoAutomationClient.discardBlueprintChanges(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiscardBlueprintChangesResponse discardBlueprintChanges(
      DiscardBlueprintChangesRequest request) {
    return discardBlueprintChangesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Discards the changes in a blueprint and reverts the blueprint to the last approved blueprint
   * revision. No changes take place if a blueprint does not have revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   DiscardBlueprintChangesRequest request =
   *       DiscardBlueprintChangesRequest.newBuilder()
   *           .setName(
   *               BlueprintName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DiscardBlueprintChangesResponse> future =
   *       telcoAutomationClient.discardBlueprintChangesCallable().futureCall(request);
   *   // Do something.
   *   DiscardBlueprintChangesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DiscardBlueprintChangesRequest, DiscardBlueprintChangesResponse>
      discardBlueprintChangesCallable() {
    return stub.discardBlueprintChangesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the blueprints in TNA's public catalog. Default page size = 20, Max Page Size = 100.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (PublicBlueprint element :
   *       telcoAutomationClient.listPublicBlueprints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value of public blueprint. Format should be -
   *     "projects/{project_id}/locations/{location_name}".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPublicBlueprintsPagedResponse listPublicBlueprints(LocationName parent) {
    ListPublicBlueprintsRequest request =
        ListPublicBlueprintsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPublicBlueprints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the blueprints in TNA's public catalog. Default page size = 20, Max Page Size = 100.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (PublicBlueprint element :
   *       telcoAutomationClient.listPublicBlueprints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value of public blueprint. Format should be -
   *     "projects/{project_id}/locations/{location_name}".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPublicBlueprintsPagedResponse listPublicBlueprints(String parent) {
    ListPublicBlueprintsRequest request =
        ListPublicBlueprintsRequest.newBuilder().setParent(parent).build();
    return listPublicBlueprints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the blueprints in TNA's public catalog. Default page size = 20, Max Page Size = 100.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListPublicBlueprintsRequest request =
   *       ListPublicBlueprintsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (PublicBlueprint element :
   *       telcoAutomationClient.listPublicBlueprints(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPublicBlueprintsPagedResponse listPublicBlueprints(
      ListPublicBlueprintsRequest request) {
    return listPublicBlueprintsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the blueprints in TNA's public catalog. Default page size = 20, Max Page Size = 100.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListPublicBlueprintsRequest request =
   *       ListPublicBlueprintsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<PublicBlueprint> future =
   *       telcoAutomationClient.listPublicBlueprintsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PublicBlueprint element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPublicBlueprintsRequest, ListPublicBlueprintsPagedResponse>
      listPublicBlueprintsPagedCallable() {
    return stub.listPublicBlueprintsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the blueprints in TNA's public catalog. Default page size = 20, Max Page Size = 100.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListPublicBlueprintsRequest request =
   *       ListPublicBlueprintsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListPublicBlueprintsResponse response =
   *         telcoAutomationClient.listPublicBlueprintsCallable().call(request);
   *     for (PublicBlueprint element : response.getPublicBlueprintsList()) {
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
  public final UnaryCallable<ListPublicBlueprintsRequest, ListPublicBlueprintsResponse>
      listPublicBlueprintsCallable() {
    return stub.listPublicBlueprintsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested public blueprint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   PublicBlueprintName name =
   *       PublicBlueprintName.of("[PROJECT]", "[LOCATION]", "[PUBLIC_LUEPRINT]");
   *   PublicBlueprint response = telcoAutomationClient.getPublicBlueprint(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the public blueprint.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PublicBlueprint getPublicBlueprint(PublicBlueprintName name) {
    GetPublicBlueprintRequest request =
        GetPublicBlueprintRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getPublicBlueprint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested public blueprint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String name =
   *       PublicBlueprintName.of("[PROJECT]", "[LOCATION]", "[PUBLIC_LUEPRINT]").toString();
   *   PublicBlueprint response = telcoAutomationClient.getPublicBlueprint(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the public blueprint.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PublicBlueprint getPublicBlueprint(String name) {
    GetPublicBlueprintRequest request =
        GetPublicBlueprintRequest.newBuilder().setName(name).build();
    return getPublicBlueprint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested public blueprint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   GetPublicBlueprintRequest request =
   *       GetPublicBlueprintRequest.newBuilder()
   *           .setName(
   *               PublicBlueprintName.of("[PROJECT]", "[LOCATION]", "[PUBLIC_LUEPRINT]").toString())
   *           .build();
   *   PublicBlueprint response = telcoAutomationClient.getPublicBlueprint(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PublicBlueprint getPublicBlueprint(GetPublicBlueprintRequest request) {
    return getPublicBlueprintCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested public blueprint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   GetPublicBlueprintRequest request =
   *       GetPublicBlueprintRequest.newBuilder()
   *           .setName(
   *               PublicBlueprintName.of("[PROJECT]", "[LOCATION]", "[PUBLIC_LUEPRINT]").toString())
   *           .build();
   *   ApiFuture<PublicBlueprint> future =
   *       telcoAutomationClient.getPublicBlueprintCallable().futureCall(request);
   *   // Do something.
   *   PublicBlueprint response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPublicBlueprintRequest, PublicBlueprint>
      getPublicBlueprintCallable() {
    return stub.getPublicBlueprintCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   OrchestrationClusterName parent =
   *       OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]");
   *   Deployment deployment = Deployment.newBuilder().build();
   *   String deploymentId = "deploymentId-136894784";
   *   Deployment response =
   *       telcoAutomationClient.createDeployment(parent, deployment, deploymentId);
   * }
   * }</pre>
   *
   * @param parent Required. The name of parent resource. Format should be -
   *     "projects/{project_id}/locations/{location_name}/orchestrationClusters/{orchestration_cluster}".
   * @param deployment Required. The `Deployment` to create.
   * @param deploymentId Optional. The name of the deployment.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment createDeployment(
      OrchestrationClusterName parent, Deployment deployment, String deploymentId) {
    CreateDeploymentRequest request =
        CreateDeploymentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDeployment(deployment)
            .setDeploymentId(deploymentId)
            .build();
    return createDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String parent =
   *       OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *           .toString();
   *   Deployment deployment = Deployment.newBuilder().build();
   *   String deploymentId = "deploymentId-136894784";
   *   Deployment response =
   *       telcoAutomationClient.createDeployment(parent, deployment, deploymentId);
   * }
   * }</pre>
   *
   * @param parent Required. The name of parent resource. Format should be -
   *     "projects/{project_id}/locations/{location_name}/orchestrationClusters/{orchestration_cluster}".
   * @param deployment Required. The `Deployment` to create.
   * @param deploymentId Optional. The name of the deployment.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment createDeployment(
      String parent, Deployment deployment, String deploymentId) {
    CreateDeploymentRequest request =
        CreateDeploymentRequest.newBuilder()
            .setParent(parent)
            .setDeployment(deployment)
            .setDeploymentId(deploymentId)
            .build();
    return createDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   CreateDeploymentRequest request =
   *       CreateDeploymentRequest.newBuilder()
   *           .setParent(
   *               OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *                   .toString())
   *           .setDeploymentId("deploymentId-136894784")
   *           .setDeployment(Deployment.newBuilder().build())
   *           .build();
   *   Deployment response = telcoAutomationClient.createDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment createDeployment(CreateDeploymentRequest request) {
    return createDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   CreateDeploymentRequest request =
   *       CreateDeploymentRequest.newBuilder()
   *           .setParent(
   *               OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *                   .toString())
   *           .setDeploymentId("deploymentId-136894784")
   *           .setDeployment(Deployment.newBuilder().build())
   *           .build();
   *   ApiFuture<Deployment> future =
   *       telcoAutomationClient.createDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Deployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDeploymentRequest, Deployment> createDeploymentCallable() {
    return stub.createDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   Deployment deployment = Deployment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Deployment response = telcoAutomationClient.updateDeployment(deployment, updateMask);
   * }
   * }</pre>
   *
   * @param deployment Required. The `deployment` to update.
   * @param updateMask Required. Update mask is used to specify the fields to be overwritten in the
   *     `deployment` resource by the update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment updateDeployment(Deployment deployment, FieldMask updateMask) {
    UpdateDeploymentRequest request =
        UpdateDeploymentRequest.newBuilder()
            .setDeployment(deployment)
            .setUpdateMask(updateMask)
            .build();
    return updateDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   UpdateDeploymentRequest request =
   *       UpdateDeploymentRequest.newBuilder()
   *           .setDeployment(Deployment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Deployment response = telcoAutomationClient.updateDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment updateDeployment(UpdateDeploymentRequest request) {
    return updateDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   UpdateDeploymentRequest request =
   *       UpdateDeploymentRequest.newBuilder()
   *           .setDeployment(Deployment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Deployment> future =
   *       telcoAutomationClient.updateDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Deployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDeploymentRequest, Deployment> updateDeploymentCallable() {
    return stub.updateDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   DeploymentName name =
   *       DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]");
   *   Deployment response = telcoAutomationClient.getDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment. Case 1: If the name provided in the request
   *     is {deployment_id}{@literal @}{revision_id}, then the revision with revision_id will be
   *     returned. Case 2: If the name provided in the request is {deployment}, then the current
   *     state of the deployment is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment getDeployment(DeploymentName name) {
    GetDeploymentRequest request =
        GetDeploymentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String name =
   *       DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *           .toString();
   *   Deployment response = telcoAutomationClient.getDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment. Case 1: If the name provided in the request
   *     is {deployment_id}{@literal @}{revision_id}, then the revision with revision_id will be
   *     returned. Case 2: If the name provided in the request is {deployment}, then the current
   *     state of the deployment is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment getDeployment(String name) {
    GetDeploymentRequest request = GetDeploymentRequest.newBuilder().setName(name).build();
    return getDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   GetDeploymentRequest request =
   *       GetDeploymentRequest.newBuilder()
   *           .setName(
   *               DeploymentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *                   .toString())
   *           .setView(DeploymentView.forNumber(0))
   *           .build();
   *   Deployment response = telcoAutomationClient.getDeployment(request);
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
   * Returns the requested deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   GetDeploymentRequest request =
   *       GetDeploymentRequest.newBuilder()
   *           .setName(
   *               DeploymentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *                   .toString())
   *           .setView(DeploymentView.forNumber(0))
   *           .build();
   *   ApiFuture<Deployment> future =
   *       telcoAutomationClient.getDeploymentCallable().futureCall(request);
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
   * Removes the deployment by marking it as DELETING. Post which deployment and it's revisions gets
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   DeploymentName name =
   *       DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]");
   *   telcoAutomationClient.removeDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of deployment to initiate delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void removeDeployment(DeploymentName name) {
    RemoveDeploymentRequest request =
        RemoveDeploymentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    removeDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes the deployment by marking it as DELETING. Post which deployment and it's revisions gets
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String name =
   *       DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *           .toString();
   *   telcoAutomationClient.removeDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of deployment to initiate delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void removeDeployment(String name) {
    RemoveDeploymentRequest request = RemoveDeploymentRequest.newBuilder().setName(name).build();
    removeDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes the deployment by marking it as DELETING. Post which deployment and it's revisions gets
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   RemoveDeploymentRequest request =
   *       RemoveDeploymentRequest.newBuilder()
   *           .setName(
   *               DeploymentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   telcoAutomationClient.removeDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void removeDeployment(RemoveDeploymentRequest request) {
    removeDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes the deployment by marking it as DELETING. Post which deployment and it's revisions gets
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   RemoveDeploymentRequest request =
   *       RemoveDeploymentRequest.newBuilder()
   *           .setName(
   *               DeploymentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       telcoAutomationClient.removeDeploymentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveDeploymentRequest, Empty> removeDeploymentCallable() {
    return stub.removeDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all deployments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   OrchestrationClusterName parent =
   *       OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]");
   *   for (Deployment element : telcoAutomationClient.listDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of parent orchestration cluster resource. Format should be -
   *     "projects/{project_id}/locations/{location_name}/orchestrationClusters/{orchestration_cluster}".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeploymentsPagedResponse listDeployments(OrchestrationClusterName parent) {
    ListDeploymentsRequest request =
        ListDeploymentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all deployments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String parent =
   *       OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *           .toString();
   *   for (Deployment element : telcoAutomationClient.listDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of parent orchestration cluster resource. Format should be -
   *     "projects/{project_id}/locations/{location_name}/orchestrationClusters/{orchestration_cluster}".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeploymentsPagedResponse listDeployments(String parent) {
    ListDeploymentsRequest request = ListDeploymentsRequest.newBuilder().setParent(parent).build();
    return listDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all deployments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListDeploymentsRequest request =
   *       ListDeploymentsRequest.newBuilder()
   *           .setParent(
   *               OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Deployment element : telcoAutomationClient.listDeployments(request).iterateAll()) {
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
   * List all deployments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListDeploymentsRequest request =
   *       ListDeploymentsRequest.newBuilder()
   *           .setParent(
   *               OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Deployment> future =
   *       telcoAutomationClient.listDeploymentsPagedCallable().futureCall(request);
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
   * List all deployments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListDeploymentsRequest request =
   *       ListDeploymentsRequest.newBuilder()
   *           .setParent(
   *               OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDeploymentsResponse response =
   *         telcoAutomationClient.listDeploymentsCallable().call(request);
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
   * List deployment revisions of a given deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   DeploymentName name =
   *       DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]");
   *   for (Deployment element : telcoAutomationClient.listDeploymentRevisions(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment to list revisions for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeploymentRevisionsPagedResponse listDeploymentRevisions(DeploymentName name) {
    ListDeploymentRevisionsRequest request =
        ListDeploymentRevisionsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return listDeploymentRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List deployment revisions of a given deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String name =
   *       DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *           .toString();
   *   for (Deployment element : telcoAutomationClient.listDeploymentRevisions(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment to list revisions for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeploymentRevisionsPagedResponse listDeploymentRevisions(String name) {
    ListDeploymentRevisionsRequest request =
        ListDeploymentRevisionsRequest.newBuilder().setName(name).build();
    return listDeploymentRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List deployment revisions of a given deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListDeploymentRevisionsRequest request =
   *       ListDeploymentRevisionsRequest.newBuilder()
   *           .setName(
   *               DeploymentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Deployment element :
   *       telcoAutomationClient.listDeploymentRevisions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeploymentRevisionsPagedResponse listDeploymentRevisions(
      ListDeploymentRevisionsRequest request) {
    return listDeploymentRevisionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List deployment revisions of a given deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListDeploymentRevisionsRequest request =
   *       ListDeploymentRevisionsRequest.newBuilder()
   *           .setName(
   *               DeploymentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Deployment> future =
   *       telcoAutomationClient.listDeploymentRevisionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Deployment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDeploymentRevisionsRequest, ListDeploymentRevisionsPagedResponse>
      listDeploymentRevisionsPagedCallable() {
    return stub.listDeploymentRevisionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List deployment revisions of a given deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListDeploymentRevisionsRequest request =
   *       ListDeploymentRevisionsRequest.newBuilder()
   *           .setName(
   *               DeploymentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDeploymentRevisionsResponse response =
   *         telcoAutomationClient.listDeploymentRevisionsCallable().call(request);
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
  public final UnaryCallable<ListDeploymentRevisionsRequest, ListDeploymentRevisionsResponse>
      listDeploymentRevisionsCallable() {
    return stub.listDeploymentRevisionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Discards the changes in a deployment and reverts the deployment to the last approved deployment
   * revision. No changes take place if a deployment does not have revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   DeploymentName name =
   *       DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]");
   *   DiscardDeploymentChangesResponse response =
   *       telcoAutomationClient.discardDeploymentChanges(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment of which changes are being discarded.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiscardDeploymentChangesResponse discardDeploymentChanges(DeploymentName name) {
    DiscardDeploymentChangesRequest request =
        DiscardDeploymentChangesRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return discardDeploymentChanges(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Discards the changes in a deployment and reverts the deployment to the last approved deployment
   * revision. No changes take place if a deployment does not have revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String name =
   *       DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *           .toString();
   *   DiscardDeploymentChangesResponse response =
   *       telcoAutomationClient.discardDeploymentChanges(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment of which changes are being discarded.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiscardDeploymentChangesResponse discardDeploymentChanges(String name) {
    DiscardDeploymentChangesRequest request =
        DiscardDeploymentChangesRequest.newBuilder().setName(name).build();
    return discardDeploymentChanges(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Discards the changes in a deployment and reverts the deployment to the last approved deployment
   * revision. No changes take place if a deployment does not have revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   DiscardDeploymentChangesRequest request =
   *       DiscardDeploymentChangesRequest.newBuilder()
   *           .setName(
   *               DeploymentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   DiscardDeploymentChangesResponse response =
   *       telcoAutomationClient.discardDeploymentChanges(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiscardDeploymentChangesResponse discardDeploymentChanges(
      DiscardDeploymentChangesRequest request) {
    return discardDeploymentChangesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Discards the changes in a deployment and reverts the deployment to the last approved deployment
   * revision. No changes take place if a deployment does not have revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   DiscardDeploymentChangesRequest request =
   *       DiscardDeploymentChangesRequest.newBuilder()
   *           .setName(
   *               DeploymentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DiscardDeploymentChangesResponse> future =
   *       telcoAutomationClient.discardDeploymentChangesCallable().futureCall(request);
   *   // Do something.
   *   DiscardDeploymentChangesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DiscardDeploymentChangesRequest, DiscardDeploymentChangesResponse>
      discardDeploymentChangesCallable() {
    return stub.discardDeploymentChangesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Applies the deployment's YAML files to the parent orchestration cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   DeploymentName name =
   *       DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]");
   *   Deployment response = telcoAutomationClient.applyDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment to apply to orchestration cluster.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment applyDeployment(DeploymentName name) {
    ApplyDeploymentRequest request =
        ApplyDeploymentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return applyDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Applies the deployment's YAML files to the parent orchestration cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String name =
   *       DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *           .toString();
   *   Deployment response = telcoAutomationClient.applyDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment to apply to orchestration cluster.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment applyDeployment(String name) {
    ApplyDeploymentRequest request = ApplyDeploymentRequest.newBuilder().setName(name).build();
    return applyDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Applies the deployment's YAML files to the parent orchestration cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ApplyDeploymentRequest request =
   *       ApplyDeploymentRequest.newBuilder()
   *           .setName(
   *               DeploymentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   Deployment response = telcoAutomationClient.applyDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment applyDeployment(ApplyDeploymentRequest request) {
    return applyDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Applies the deployment's YAML files to the parent orchestration cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ApplyDeploymentRequest request =
   *       ApplyDeploymentRequest.newBuilder()
   *           .setName(
   *               DeploymentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Deployment> future =
   *       telcoAutomationClient.applyDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Deployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ApplyDeploymentRequest, Deployment> applyDeploymentCallable() {
    return stub.applyDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested deployment status.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   DeploymentName name =
   *       DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]");
   *   ComputeDeploymentStatusResponse response =
   *       telcoAutomationClient.computeDeploymentStatus(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment without revisionID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ComputeDeploymentStatusResponse computeDeploymentStatus(DeploymentName name) {
    ComputeDeploymentStatusRequest request =
        ComputeDeploymentStatusRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return computeDeploymentStatus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested deployment status.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String name =
   *       DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *           .toString();
   *   ComputeDeploymentStatusResponse response =
   *       telcoAutomationClient.computeDeploymentStatus(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment without revisionID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ComputeDeploymentStatusResponse computeDeploymentStatus(String name) {
    ComputeDeploymentStatusRequest request =
        ComputeDeploymentStatusRequest.newBuilder().setName(name).build();
    return computeDeploymentStatus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested deployment status.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ComputeDeploymentStatusRequest request =
   *       ComputeDeploymentStatusRequest.newBuilder()
   *           .setName(
   *               DeploymentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   ComputeDeploymentStatusResponse response =
   *       telcoAutomationClient.computeDeploymentStatus(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ComputeDeploymentStatusResponse computeDeploymentStatus(
      ComputeDeploymentStatusRequest request) {
    return computeDeploymentStatusCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested deployment status.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ComputeDeploymentStatusRequest request =
   *       ComputeDeploymentStatusRequest.newBuilder()
   *           .setName(
   *               DeploymentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ComputeDeploymentStatusResponse> future =
   *       telcoAutomationClient.computeDeploymentStatusCallable().futureCall(request);
   *   // Do something.
   *   ComputeDeploymentStatusResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ComputeDeploymentStatusRequest, ComputeDeploymentStatusResponse>
      computeDeploymentStatusCallable() {
    return stub.computeDeploymentStatusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rollback the active deployment to the given past approved deployment revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   DeploymentName name =
   *       DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]");
   *   String revisionId = "revisionId-1507445162";
   *   Deployment response = telcoAutomationClient.rollbackDeployment(name, revisionId);
   * }
   * }</pre>
   *
   * @param name Required. Name of the deployment.
   * @param revisionId Required. The revision id of deployment to roll back to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment rollbackDeployment(DeploymentName name, String revisionId) {
    RollbackDeploymentRequest request =
        RollbackDeploymentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setRevisionId(revisionId)
            .build();
    return rollbackDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rollback the active deployment to the given past approved deployment revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String name =
   *       DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *           .toString();
   *   String revisionId = "revisionId-1507445162";
   *   Deployment response = telcoAutomationClient.rollbackDeployment(name, revisionId);
   * }
   * }</pre>
   *
   * @param name Required. Name of the deployment.
   * @param revisionId Required. The revision id of deployment to roll back to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment rollbackDeployment(String name, String revisionId) {
    RollbackDeploymentRequest request =
        RollbackDeploymentRequest.newBuilder().setName(name).setRevisionId(revisionId).build();
    return rollbackDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rollback the active deployment to the given past approved deployment revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   RollbackDeploymentRequest request =
   *       RollbackDeploymentRequest.newBuilder()
   *           .setName(
   *               DeploymentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *                   .toString())
   *           .setRevisionId("revisionId-1507445162")
   *           .build();
   *   Deployment response = telcoAutomationClient.rollbackDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment rollbackDeployment(RollbackDeploymentRequest request) {
    return rollbackDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rollback the active deployment to the given past approved deployment revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   RollbackDeploymentRequest request =
   *       RollbackDeploymentRequest.newBuilder()
   *           .setName(
   *               DeploymentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *                   .toString())
   *           .setRevisionId("revisionId-1507445162")
   *           .build();
   *   ApiFuture<Deployment> future =
   *       telcoAutomationClient.rollbackDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Deployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RollbackDeploymentRequest, Deployment> rollbackDeploymentCallable() {
    return stub.rollbackDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested hydrated deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   HydratedDeploymentName name =
   *       HydratedDeploymentName.of(
   *           "[PROJECT]",
   *           "[LOCATION]",
   *           "[ORCHESTRATION_CLUSTER]",
   *           "[DEPLOYMENT]",
   *           "[HYDRATED_DEPLOYMENT]");
   *   HydratedDeployment response = telcoAutomationClient.getHydratedDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the hydrated deployment.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HydratedDeployment getHydratedDeployment(HydratedDeploymentName name) {
    GetHydratedDeploymentRequest request =
        GetHydratedDeploymentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getHydratedDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested hydrated deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String name =
   *       HydratedDeploymentName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[ORCHESTRATION_CLUSTER]",
   *               "[DEPLOYMENT]",
   *               "[HYDRATED_DEPLOYMENT]")
   *           .toString();
   *   HydratedDeployment response = telcoAutomationClient.getHydratedDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the hydrated deployment.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HydratedDeployment getHydratedDeployment(String name) {
    GetHydratedDeploymentRequest request =
        GetHydratedDeploymentRequest.newBuilder().setName(name).build();
    return getHydratedDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested hydrated deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   GetHydratedDeploymentRequest request =
   *       GetHydratedDeploymentRequest.newBuilder()
   *           .setName(
   *               HydratedDeploymentName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[ORCHESTRATION_CLUSTER]",
   *                       "[DEPLOYMENT]",
   *                       "[HYDRATED_DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   HydratedDeployment response = telcoAutomationClient.getHydratedDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HydratedDeployment getHydratedDeployment(GetHydratedDeploymentRequest request) {
    return getHydratedDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested hydrated deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   GetHydratedDeploymentRequest request =
   *       GetHydratedDeploymentRequest.newBuilder()
   *           .setName(
   *               HydratedDeploymentName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[ORCHESTRATION_CLUSTER]",
   *                       "[DEPLOYMENT]",
   *                       "[HYDRATED_DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<HydratedDeployment> future =
   *       telcoAutomationClient.getHydratedDeploymentCallable().futureCall(request);
   *   // Do something.
   *   HydratedDeployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetHydratedDeploymentRequest, HydratedDeployment>
      getHydratedDeploymentCallable() {
    return stub.getHydratedDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all hydrated deployments present under a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   DeploymentName parent =
   *       DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]");
   *   for (HydratedDeployment element :
   *       telcoAutomationClient.listHydratedDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The deployment managing the hydrated deployments.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHydratedDeploymentsPagedResponse listHydratedDeployments(DeploymentName parent) {
    ListHydratedDeploymentsRequest request =
        ListHydratedDeploymentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listHydratedDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all hydrated deployments present under a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String parent =
   *       DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *           .toString();
   *   for (HydratedDeployment element :
   *       telcoAutomationClient.listHydratedDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The deployment managing the hydrated deployments.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHydratedDeploymentsPagedResponse listHydratedDeployments(String parent) {
    ListHydratedDeploymentsRequest request =
        ListHydratedDeploymentsRequest.newBuilder().setParent(parent).build();
    return listHydratedDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all hydrated deployments present under a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListHydratedDeploymentsRequest request =
   *       ListHydratedDeploymentsRequest.newBuilder()
   *           .setParent(
   *               DeploymentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (HydratedDeployment element :
   *       telcoAutomationClient.listHydratedDeployments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHydratedDeploymentsPagedResponse listHydratedDeployments(
      ListHydratedDeploymentsRequest request) {
    return listHydratedDeploymentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all hydrated deployments present under a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListHydratedDeploymentsRequest request =
   *       ListHydratedDeploymentsRequest.newBuilder()
   *           .setParent(
   *               DeploymentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<HydratedDeployment> future =
   *       telcoAutomationClient.listHydratedDeploymentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (HydratedDeployment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListHydratedDeploymentsRequest, ListHydratedDeploymentsPagedResponse>
      listHydratedDeploymentsPagedCallable() {
    return stub.listHydratedDeploymentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all hydrated deployments present under a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListHydratedDeploymentsRequest request =
   *       ListHydratedDeploymentsRequest.newBuilder()
   *           .setParent(
   *               DeploymentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListHydratedDeploymentsResponse response =
   *         telcoAutomationClient.listHydratedDeploymentsCallable().call(request);
   *     for (HydratedDeployment element : response.getHydratedDeploymentsList()) {
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
  public final UnaryCallable<ListHydratedDeploymentsRequest, ListHydratedDeploymentsResponse>
      listHydratedDeploymentsCallable() {
    return stub.listHydratedDeploymentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a hydrated deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   HydratedDeployment hydratedDeployment = HydratedDeployment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   HydratedDeployment response =
   *       telcoAutomationClient.updateHydratedDeployment(hydratedDeployment, updateMask);
   * }
   * }</pre>
   *
   * @param hydratedDeployment Required. The hydrated deployment to update.
   * @param updateMask Required. The list of fields to update. Update mask supports a special value
   *     `&#42;` which fully replaces (equivalent to PUT) the resource provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HydratedDeployment updateHydratedDeployment(
      HydratedDeployment hydratedDeployment, FieldMask updateMask) {
    UpdateHydratedDeploymentRequest request =
        UpdateHydratedDeploymentRequest.newBuilder()
            .setHydratedDeployment(hydratedDeployment)
            .setUpdateMask(updateMask)
            .build();
    return updateHydratedDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a hydrated deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   UpdateHydratedDeploymentRequest request =
   *       UpdateHydratedDeploymentRequest.newBuilder()
   *           .setHydratedDeployment(HydratedDeployment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   HydratedDeployment response = telcoAutomationClient.updateHydratedDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HydratedDeployment updateHydratedDeployment(
      UpdateHydratedDeploymentRequest request) {
    return updateHydratedDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a hydrated deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   UpdateHydratedDeploymentRequest request =
   *       UpdateHydratedDeploymentRequest.newBuilder()
   *           .setHydratedDeployment(HydratedDeployment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<HydratedDeployment> future =
   *       telcoAutomationClient.updateHydratedDeploymentCallable().futureCall(request);
   *   // Do something.
   *   HydratedDeployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateHydratedDeploymentRequest, HydratedDeployment>
      updateHydratedDeploymentCallable() {
    return stub.updateHydratedDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Applies a hydrated deployment to a workload cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   HydratedDeploymentName name =
   *       HydratedDeploymentName.of(
   *           "[PROJECT]",
   *           "[LOCATION]",
   *           "[ORCHESTRATION_CLUSTER]",
   *           "[DEPLOYMENT]",
   *           "[HYDRATED_DEPLOYMENT]");
   *   HydratedDeployment response = telcoAutomationClient.applyHydratedDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the hydrated deployment to apply.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HydratedDeployment applyHydratedDeployment(HydratedDeploymentName name) {
    ApplyHydratedDeploymentRequest request =
        ApplyHydratedDeploymentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return applyHydratedDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Applies a hydrated deployment to a workload cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   String name =
   *       HydratedDeploymentName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[ORCHESTRATION_CLUSTER]",
   *               "[DEPLOYMENT]",
   *               "[HYDRATED_DEPLOYMENT]")
   *           .toString();
   *   HydratedDeployment response = telcoAutomationClient.applyHydratedDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the hydrated deployment to apply.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HydratedDeployment applyHydratedDeployment(String name) {
    ApplyHydratedDeploymentRequest request =
        ApplyHydratedDeploymentRequest.newBuilder().setName(name).build();
    return applyHydratedDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Applies a hydrated deployment to a workload cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ApplyHydratedDeploymentRequest request =
   *       ApplyHydratedDeploymentRequest.newBuilder()
   *           .setName(
   *               HydratedDeploymentName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[ORCHESTRATION_CLUSTER]",
   *                       "[DEPLOYMENT]",
   *                       "[HYDRATED_DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   HydratedDeployment response = telcoAutomationClient.applyHydratedDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HydratedDeployment applyHydratedDeployment(ApplyHydratedDeploymentRequest request) {
    return applyHydratedDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Applies a hydrated deployment to a workload cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ApplyHydratedDeploymentRequest request =
   *       ApplyHydratedDeploymentRequest.newBuilder()
   *           .setName(
   *               HydratedDeploymentName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[ORCHESTRATION_CLUSTER]",
   *                       "[DEPLOYMENT]",
   *                       "[HYDRATED_DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<HydratedDeployment> future =
   *       telcoAutomationClient.applyHydratedDeploymentCallable().futureCall(request);
   *   // Do something.
   *   HydratedDeployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ApplyHydratedDeploymentRequest, HydratedDeployment>
      applyHydratedDeploymentCallable() {
    return stub.applyHydratedDeploymentCallable();
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
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : telcoAutomationClient.listLocations(request).iterateAll()) {
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
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       telcoAutomationClient.listLocationsPagedCallable().futureCall(request);
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
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         telcoAutomationClient.listLocationsCallable().call(request);
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
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = telcoAutomationClient.getLocation(request);
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
   * try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = telcoAutomationClient.getLocationCallable().futureCall(request);
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

  public static class ListOrchestrationClustersPagedResponse
      extends AbstractPagedListResponse<
          ListOrchestrationClustersRequest,
          ListOrchestrationClustersResponse,
          OrchestrationCluster,
          ListOrchestrationClustersPage,
          ListOrchestrationClustersFixedSizeCollection> {

    public static ApiFuture<ListOrchestrationClustersPagedResponse> createAsync(
        PageContext<
                ListOrchestrationClustersRequest,
                ListOrchestrationClustersResponse,
                OrchestrationCluster>
            context,
        ApiFuture<ListOrchestrationClustersResponse> futureResponse) {
      ApiFuture<ListOrchestrationClustersPage> futurePage =
          ListOrchestrationClustersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListOrchestrationClustersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListOrchestrationClustersPagedResponse(ListOrchestrationClustersPage page) {
      super(page, ListOrchestrationClustersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListOrchestrationClustersPage
      extends AbstractPage<
          ListOrchestrationClustersRequest,
          ListOrchestrationClustersResponse,
          OrchestrationCluster,
          ListOrchestrationClustersPage> {

    private ListOrchestrationClustersPage(
        PageContext<
                ListOrchestrationClustersRequest,
                ListOrchestrationClustersResponse,
                OrchestrationCluster>
            context,
        ListOrchestrationClustersResponse response) {
      super(context, response);
    }

    private static ListOrchestrationClustersPage createEmptyPage() {
      return new ListOrchestrationClustersPage(null, null);
    }

    @Override
    protected ListOrchestrationClustersPage createPage(
        PageContext<
                ListOrchestrationClustersRequest,
                ListOrchestrationClustersResponse,
                OrchestrationCluster>
            context,
        ListOrchestrationClustersResponse response) {
      return new ListOrchestrationClustersPage(context, response);
    }

    @Override
    public ApiFuture<ListOrchestrationClustersPage> createPageAsync(
        PageContext<
                ListOrchestrationClustersRequest,
                ListOrchestrationClustersResponse,
                OrchestrationCluster>
            context,
        ApiFuture<ListOrchestrationClustersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListOrchestrationClustersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListOrchestrationClustersRequest,
          ListOrchestrationClustersResponse,
          OrchestrationCluster,
          ListOrchestrationClustersPage,
          ListOrchestrationClustersFixedSizeCollection> {

    private ListOrchestrationClustersFixedSizeCollection(
        List<ListOrchestrationClustersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListOrchestrationClustersFixedSizeCollection createEmptyCollection() {
      return new ListOrchestrationClustersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListOrchestrationClustersFixedSizeCollection createCollection(
        List<ListOrchestrationClustersPage> pages, int collectionSize) {
      return new ListOrchestrationClustersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEdgeSlmsPagedResponse
      extends AbstractPagedListResponse<
          ListEdgeSlmsRequest,
          ListEdgeSlmsResponse,
          EdgeSlm,
          ListEdgeSlmsPage,
          ListEdgeSlmsFixedSizeCollection> {

    public static ApiFuture<ListEdgeSlmsPagedResponse> createAsync(
        PageContext<ListEdgeSlmsRequest, ListEdgeSlmsResponse, EdgeSlm> context,
        ApiFuture<ListEdgeSlmsResponse> futureResponse) {
      ApiFuture<ListEdgeSlmsPage> futurePage =
          ListEdgeSlmsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEdgeSlmsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEdgeSlmsPagedResponse(ListEdgeSlmsPage page) {
      super(page, ListEdgeSlmsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEdgeSlmsPage
      extends AbstractPage<ListEdgeSlmsRequest, ListEdgeSlmsResponse, EdgeSlm, ListEdgeSlmsPage> {

    private ListEdgeSlmsPage(
        PageContext<ListEdgeSlmsRequest, ListEdgeSlmsResponse, EdgeSlm> context,
        ListEdgeSlmsResponse response) {
      super(context, response);
    }

    private static ListEdgeSlmsPage createEmptyPage() {
      return new ListEdgeSlmsPage(null, null);
    }

    @Override
    protected ListEdgeSlmsPage createPage(
        PageContext<ListEdgeSlmsRequest, ListEdgeSlmsResponse, EdgeSlm> context,
        ListEdgeSlmsResponse response) {
      return new ListEdgeSlmsPage(context, response);
    }

    @Override
    public ApiFuture<ListEdgeSlmsPage> createPageAsync(
        PageContext<ListEdgeSlmsRequest, ListEdgeSlmsResponse, EdgeSlm> context,
        ApiFuture<ListEdgeSlmsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEdgeSlmsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEdgeSlmsRequest,
          ListEdgeSlmsResponse,
          EdgeSlm,
          ListEdgeSlmsPage,
          ListEdgeSlmsFixedSizeCollection> {

    private ListEdgeSlmsFixedSizeCollection(List<ListEdgeSlmsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEdgeSlmsFixedSizeCollection createEmptyCollection() {
      return new ListEdgeSlmsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEdgeSlmsFixedSizeCollection createCollection(
        List<ListEdgeSlmsPage> pages, int collectionSize) {
      return new ListEdgeSlmsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBlueprintsPagedResponse
      extends AbstractPagedListResponse<
          ListBlueprintsRequest,
          ListBlueprintsResponse,
          Blueprint,
          ListBlueprintsPage,
          ListBlueprintsFixedSizeCollection> {

    public static ApiFuture<ListBlueprintsPagedResponse> createAsync(
        PageContext<ListBlueprintsRequest, ListBlueprintsResponse, Blueprint> context,
        ApiFuture<ListBlueprintsResponse> futureResponse) {
      ApiFuture<ListBlueprintsPage> futurePage =
          ListBlueprintsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBlueprintsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBlueprintsPagedResponse(ListBlueprintsPage page) {
      super(page, ListBlueprintsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBlueprintsPage
      extends AbstractPage<
          ListBlueprintsRequest, ListBlueprintsResponse, Blueprint, ListBlueprintsPage> {

    private ListBlueprintsPage(
        PageContext<ListBlueprintsRequest, ListBlueprintsResponse, Blueprint> context,
        ListBlueprintsResponse response) {
      super(context, response);
    }

    private static ListBlueprintsPage createEmptyPage() {
      return new ListBlueprintsPage(null, null);
    }

    @Override
    protected ListBlueprintsPage createPage(
        PageContext<ListBlueprintsRequest, ListBlueprintsResponse, Blueprint> context,
        ListBlueprintsResponse response) {
      return new ListBlueprintsPage(context, response);
    }

    @Override
    public ApiFuture<ListBlueprintsPage> createPageAsync(
        PageContext<ListBlueprintsRequest, ListBlueprintsResponse, Blueprint> context,
        ApiFuture<ListBlueprintsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBlueprintsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBlueprintsRequest,
          ListBlueprintsResponse,
          Blueprint,
          ListBlueprintsPage,
          ListBlueprintsFixedSizeCollection> {

    private ListBlueprintsFixedSizeCollection(List<ListBlueprintsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBlueprintsFixedSizeCollection createEmptyCollection() {
      return new ListBlueprintsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBlueprintsFixedSizeCollection createCollection(
        List<ListBlueprintsPage> pages, int collectionSize) {
      return new ListBlueprintsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBlueprintRevisionsPagedResponse
      extends AbstractPagedListResponse<
          ListBlueprintRevisionsRequest,
          ListBlueprintRevisionsResponse,
          Blueprint,
          ListBlueprintRevisionsPage,
          ListBlueprintRevisionsFixedSizeCollection> {

    public static ApiFuture<ListBlueprintRevisionsPagedResponse> createAsync(
        PageContext<ListBlueprintRevisionsRequest, ListBlueprintRevisionsResponse, Blueprint>
            context,
        ApiFuture<ListBlueprintRevisionsResponse> futureResponse) {
      ApiFuture<ListBlueprintRevisionsPage> futurePage =
          ListBlueprintRevisionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBlueprintRevisionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBlueprintRevisionsPagedResponse(ListBlueprintRevisionsPage page) {
      super(page, ListBlueprintRevisionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBlueprintRevisionsPage
      extends AbstractPage<
          ListBlueprintRevisionsRequest,
          ListBlueprintRevisionsResponse,
          Blueprint,
          ListBlueprintRevisionsPage> {

    private ListBlueprintRevisionsPage(
        PageContext<ListBlueprintRevisionsRequest, ListBlueprintRevisionsResponse, Blueprint>
            context,
        ListBlueprintRevisionsResponse response) {
      super(context, response);
    }

    private static ListBlueprintRevisionsPage createEmptyPage() {
      return new ListBlueprintRevisionsPage(null, null);
    }

    @Override
    protected ListBlueprintRevisionsPage createPage(
        PageContext<ListBlueprintRevisionsRequest, ListBlueprintRevisionsResponse, Blueprint>
            context,
        ListBlueprintRevisionsResponse response) {
      return new ListBlueprintRevisionsPage(context, response);
    }

    @Override
    public ApiFuture<ListBlueprintRevisionsPage> createPageAsync(
        PageContext<ListBlueprintRevisionsRequest, ListBlueprintRevisionsResponse, Blueprint>
            context,
        ApiFuture<ListBlueprintRevisionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBlueprintRevisionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBlueprintRevisionsRequest,
          ListBlueprintRevisionsResponse,
          Blueprint,
          ListBlueprintRevisionsPage,
          ListBlueprintRevisionsFixedSizeCollection> {

    private ListBlueprintRevisionsFixedSizeCollection(
        List<ListBlueprintRevisionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBlueprintRevisionsFixedSizeCollection createEmptyCollection() {
      return new ListBlueprintRevisionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBlueprintRevisionsFixedSizeCollection createCollection(
        List<ListBlueprintRevisionsPage> pages, int collectionSize) {
      return new ListBlueprintRevisionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchBlueprintRevisionsPagedResponse
      extends AbstractPagedListResponse<
          SearchBlueprintRevisionsRequest,
          SearchBlueprintRevisionsResponse,
          Blueprint,
          SearchBlueprintRevisionsPage,
          SearchBlueprintRevisionsFixedSizeCollection> {

    public static ApiFuture<SearchBlueprintRevisionsPagedResponse> createAsync(
        PageContext<SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsResponse, Blueprint>
            context,
        ApiFuture<SearchBlueprintRevisionsResponse> futureResponse) {
      ApiFuture<SearchBlueprintRevisionsPage> futurePage =
          SearchBlueprintRevisionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchBlueprintRevisionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchBlueprintRevisionsPagedResponse(SearchBlueprintRevisionsPage page) {
      super(page, SearchBlueprintRevisionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchBlueprintRevisionsPage
      extends AbstractPage<
          SearchBlueprintRevisionsRequest,
          SearchBlueprintRevisionsResponse,
          Blueprint,
          SearchBlueprintRevisionsPage> {

    private SearchBlueprintRevisionsPage(
        PageContext<SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsResponse, Blueprint>
            context,
        SearchBlueprintRevisionsResponse response) {
      super(context, response);
    }

    private static SearchBlueprintRevisionsPage createEmptyPage() {
      return new SearchBlueprintRevisionsPage(null, null);
    }

    @Override
    protected SearchBlueprintRevisionsPage createPage(
        PageContext<SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsResponse, Blueprint>
            context,
        SearchBlueprintRevisionsResponse response) {
      return new SearchBlueprintRevisionsPage(context, response);
    }

    @Override
    public ApiFuture<SearchBlueprintRevisionsPage> createPageAsync(
        PageContext<SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsResponse, Blueprint>
            context,
        ApiFuture<SearchBlueprintRevisionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchBlueprintRevisionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchBlueprintRevisionsRequest,
          SearchBlueprintRevisionsResponse,
          Blueprint,
          SearchBlueprintRevisionsPage,
          SearchBlueprintRevisionsFixedSizeCollection> {

    private SearchBlueprintRevisionsFixedSizeCollection(
        List<SearchBlueprintRevisionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchBlueprintRevisionsFixedSizeCollection createEmptyCollection() {
      return new SearchBlueprintRevisionsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchBlueprintRevisionsFixedSizeCollection createCollection(
        List<SearchBlueprintRevisionsPage> pages, int collectionSize) {
      return new SearchBlueprintRevisionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchDeploymentRevisionsPagedResponse
      extends AbstractPagedListResponse<
          SearchDeploymentRevisionsRequest,
          SearchDeploymentRevisionsResponse,
          Deployment,
          SearchDeploymentRevisionsPage,
          SearchDeploymentRevisionsFixedSizeCollection> {

    public static ApiFuture<SearchDeploymentRevisionsPagedResponse> createAsync(
        PageContext<SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsResponse, Deployment>
            context,
        ApiFuture<SearchDeploymentRevisionsResponse> futureResponse) {
      ApiFuture<SearchDeploymentRevisionsPage> futurePage =
          SearchDeploymentRevisionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchDeploymentRevisionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchDeploymentRevisionsPagedResponse(SearchDeploymentRevisionsPage page) {
      super(page, SearchDeploymentRevisionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchDeploymentRevisionsPage
      extends AbstractPage<
          SearchDeploymentRevisionsRequest,
          SearchDeploymentRevisionsResponse,
          Deployment,
          SearchDeploymentRevisionsPage> {

    private SearchDeploymentRevisionsPage(
        PageContext<SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsResponse, Deployment>
            context,
        SearchDeploymentRevisionsResponse response) {
      super(context, response);
    }

    private static SearchDeploymentRevisionsPage createEmptyPage() {
      return new SearchDeploymentRevisionsPage(null, null);
    }

    @Override
    protected SearchDeploymentRevisionsPage createPage(
        PageContext<SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsResponse, Deployment>
            context,
        SearchDeploymentRevisionsResponse response) {
      return new SearchDeploymentRevisionsPage(context, response);
    }

    @Override
    public ApiFuture<SearchDeploymentRevisionsPage> createPageAsync(
        PageContext<SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsResponse, Deployment>
            context,
        ApiFuture<SearchDeploymentRevisionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchDeploymentRevisionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchDeploymentRevisionsRequest,
          SearchDeploymentRevisionsResponse,
          Deployment,
          SearchDeploymentRevisionsPage,
          SearchDeploymentRevisionsFixedSizeCollection> {

    private SearchDeploymentRevisionsFixedSizeCollection(
        List<SearchDeploymentRevisionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchDeploymentRevisionsFixedSizeCollection createEmptyCollection() {
      return new SearchDeploymentRevisionsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchDeploymentRevisionsFixedSizeCollection createCollection(
        List<SearchDeploymentRevisionsPage> pages, int collectionSize) {
      return new SearchDeploymentRevisionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPublicBlueprintsPagedResponse
      extends AbstractPagedListResponse<
          ListPublicBlueprintsRequest,
          ListPublicBlueprintsResponse,
          PublicBlueprint,
          ListPublicBlueprintsPage,
          ListPublicBlueprintsFixedSizeCollection> {

    public static ApiFuture<ListPublicBlueprintsPagedResponse> createAsync(
        PageContext<ListPublicBlueprintsRequest, ListPublicBlueprintsResponse, PublicBlueprint>
            context,
        ApiFuture<ListPublicBlueprintsResponse> futureResponse) {
      ApiFuture<ListPublicBlueprintsPage> futurePage =
          ListPublicBlueprintsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPublicBlueprintsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPublicBlueprintsPagedResponse(ListPublicBlueprintsPage page) {
      super(page, ListPublicBlueprintsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPublicBlueprintsPage
      extends AbstractPage<
          ListPublicBlueprintsRequest,
          ListPublicBlueprintsResponse,
          PublicBlueprint,
          ListPublicBlueprintsPage> {

    private ListPublicBlueprintsPage(
        PageContext<ListPublicBlueprintsRequest, ListPublicBlueprintsResponse, PublicBlueprint>
            context,
        ListPublicBlueprintsResponse response) {
      super(context, response);
    }

    private static ListPublicBlueprintsPage createEmptyPage() {
      return new ListPublicBlueprintsPage(null, null);
    }

    @Override
    protected ListPublicBlueprintsPage createPage(
        PageContext<ListPublicBlueprintsRequest, ListPublicBlueprintsResponse, PublicBlueprint>
            context,
        ListPublicBlueprintsResponse response) {
      return new ListPublicBlueprintsPage(context, response);
    }

    @Override
    public ApiFuture<ListPublicBlueprintsPage> createPageAsync(
        PageContext<ListPublicBlueprintsRequest, ListPublicBlueprintsResponse, PublicBlueprint>
            context,
        ApiFuture<ListPublicBlueprintsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPublicBlueprintsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPublicBlueprintsRequest,
          ListPublicBlueprintsResponse,
          PublicBlueprint,
          ListPublicBlueprintsPage,
          ListPublicBlueprintsFixedSizeCollection> {

    private ListPublicBlueprintsFixedSizeCollection(
        List<ListPublicBlueprintsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPublicBlueprintsFixedSizeCollection createEmptyCollection() {
      return new ListPublicBlueprintsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPublicBlueprintsFixedSizeCollection createCollection(
        List<ListPublicBlueprintsPage> pages, int collectionSize) {
      return new ListPublicBlueprintsFixedSizeCollection(pages, collectionSize);
    }
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

  public static class ListDeploymentRevisionsPagedResponse
      extends AbstractPagedListResponse<
          ListDeploymentRevisionsRequest,
          ListDeploymentRevisionsResponse,
          Deployment,
          ListDeploymentRevisionsPage,
          ListDeploymentRevisionsFixedSizeCollection> {

    public static ApiFuture<ListDeploymentRevisionsPagedResponse> createAsync(
        PageContext<ListDeploymentRevisionsRequest, ListDeploymentRevisionsResponse, Deployment>
            context,
        ApiFuture<ListDeploymentRevisionsResponse> futureResponse) {
      ApiFuture<ListDeploymentRevisionsPage> futurePage =
          ListDeploymentRevisionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDeploymentRevisionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDeploymentRevisionsPagedResponse(ListDeploymentRevisionsPage page) {
      super(page, ListDeploymentRevisionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDeploymentRevisionsPage
      extends AbstractPage<
          ListDeploymentRevisionsRequest,
          ListDeploymentRevisionsResponse,
          Deployment,
          ListDeploymentRevisionsPage> {

    private ListDeploymentRevisionsPage(
        PageContext<ListDeploymentRevisionsRequest, ListDeploymentRevisionsResponse, Deployment>
            context,
        ListDeploymentRevisionsResponse response) {
      super(context, response);
    }

    private static ListDeploymentRevisionsPage createEmptyPage() {
      return new ListDeploymentRevisionsPage(null, null);
    }

    @Override
    protected ListDeploymentRevisionsPage createPage(
        PageContext<ListDeploymentRevisionsRequest, ListDeploymentRevisionsResponse, Deployment>
            context,
        ListDeploymentRevisionsResponse response) {
      return new ListDeploymentRevisionsPage(context, response);
    }

    @Override
    public ApiFuture<ListDeploymentRevisionsPage> createPageAsync(
        PageContext<ListDeploymentRevisionsRequest, ListDeploymentRevisionsResponse, Deployment>
            context,
        ApiFuture<ListDeploymentRevisionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDeploymentRevisionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDeploymentRevisionsRequest,
          ListDeploymentRevisionsResponse,
          Deployment,
          ListDeploymentRevisionsPage,
          ListDeploymentRevisionsFixedSizeCollection> {

    private ListDeploymentRevisionsFixedSizeCollection(
        List<ListDeploymentRevisionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDeploymentRevisionsFixedSizeCollection createEmptyCollection() {
      return new ListDeploymentRevisionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDeploymentRevisionsFixedSizeCollection createCollection(
        List<ListDeploymentRevisionsPage> pages, int collectionSize) {
      return new ListDeploymentRevisionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListHydratedDeploymentsPagedResponse
      extends AbstractPagedListResponse<
          ListHydratedDeploymentsRequest,
          ListHydratedDeploymentsResponse,
          HydratedDeployment,
          ListHydratedDeploymentsPage,
          ListHydratedDeploymentsFixedSizeCollection> {

    public static ApiFuture<ListHydratedDeploymentsPagedResponse> createAsync(
        PageContext<
                ListHydratedDeploymentsRequest, ListHydratedDeploymentsResponse, HydratedDeployment>
            context,
        ApiFuture<ListHydratedDeploymentsResponse> futureResponse) {
      ApiFuture<ListHydratedDeploymentsPage> futurePage =
          ListHydratedDeploymentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListHydratedDeploymentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListHydratedDeploymentsPagedResponse(ListHydratedDeploymentsPage page) {
      super(page, ListHydratedDeploymentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListHydratedDeploymentsPage
      extends AbstractPage<
          ListHydratedDeploymentsRequest,
          ListHydratedDeploymentsResponse,
          HydratedDeployment,
          ListHydratedDeploymentsPage> {

    private ListHydratedDeploymentsPage(
        PageContext<
                ListHydratedDeploymentsRequest, ListHydratedDeploymentsResponse, HydratedDeployment>
            context,
        ListHydratedDeploymentsResponse response) {
      super(context, response);
    }

    private static ListHydratedDeploymentsPage createEmptyPage() {
      return new ListHydratedDeploymentsPage(null, null);
    }

    @Override
    protected ListHydratedDeploymentsPage createPage(
        PageContext<
                ListHydratedDeploymentsRequest, ListHydratedDeploymentsResponse, HydratedDeployment>
            context,
        ListHydratedDeploymentsResponse response) {
      return new ListHydratedDeploymentsPage(context, response);
    }

    @Override
    public ApiFuture<ListHydratedDeploymentsPage> createPageAsync(
        PageContext<
                ListHydratedDeploymentsRequest, ListHydratedDeploymentsResponse, HydratedDeployment>
            context,
        ApiFuture<ListHydratedDeploymentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListHydratedDeploymentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListHydratedDeploymentsRequest,
          ListHydratedDeploymentsResponse,
          HydratedDeployment,
          ListHydratedDeploymentsPage,
          ListHydratedDeploymentsFixedSizeCollection> {

    private ListHydratedDeploymentsFixedSizeCollection(
        List<ListHydratedDeploymentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListHydratedDeploymentsFixedSizeCollection createEmptyCollection() {
      return new ListHydratedDeploymentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListHydratedDeploymentsFixedSizeCollection createCollection(
        List<ListHydratedDeploymentsPage> pages, int collectionSize) {
      return new ListHydratedDeploymentsFixedSizeCollection(pages, collectionSize);
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
