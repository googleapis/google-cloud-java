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

package com.google.cloud.deploy.v1;

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
import com.google.cloud.deploy.v1.stub.CloudDeployStub;
import com.google.cloud.deploy.v1.stub.CloudDeployStubSettings;
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
 * Service Description: CloudDeploy service creates and manages Continuous Delivery operations on
 * Google Cloud Platform via Skaffold (https://skaffold.dev).
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
 * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
 *   DeliveryPipelineName name =
 *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]");
 *   DeliveryPipeline response = cloudDeployClient.getDeliveryPipeline(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CloudDeployClient object to clean up resources such as
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
 *      <td><p> ListDeliveryPipelines</td>
 *      <td><p> Lists DeliveryPipelines in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDeliveryPipelines(ListDeliveryPipelinesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDeliveryPipelines(LocationName parent)
 *           <li><p> listDeliveryPipelines(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDeliveryPipelinesPagedCallable()
 *           <li><p> listDeliveryPipelinesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDeliveryPipeline</td>
 *      <td><p> Gets details of a single DeliveryPipeline.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDeliveryPipeline(GetDeliveryPipelineRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDeliveryPipeline(DeliveryPipelineName name)
 *           <li><p> getDeliveryPipeline(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDeliveryPipelineCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDeliveryPipeline</td>
 *      <td><p> Creates a new DeliveryPipeline in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDeliveryPipelineAsync(CreateDeliveryPipelineRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createDeliveryPipelineAsync(LocationName parent, DeliveryPipeline deliveryPipeline, String deliveryPipelineId)
 *           <li><p> createDeliveryPipelineAsync(String parent, DeliveryPipeline deliveryPipeline, String deliveryPipelineId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDeliveryPipelineOperationCallable()
 *           <li><p> createDeliveryPipelineCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDeliveryPipeline</td>
 *      <td><p> Updates the parameters of a single DeliveryPipeline.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDeliveryPipelineAsync(UpdateDeliveryPipelineRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateDeliveryPipelineAsync(DeliveryPipeline deliveryPipeline, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDeliveryPipelineOperationCallable()
 *           <li><p> updateDeliveryPipelineCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDeliveryPipeline</td>
 *      <td><p> Deletes a single DeliveryPipeline.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDeliveryPipelineAsync(DeleteDeliveryPipelineRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteDeliveryPipelineAsync(DeliveryPipelineName name)
 *           <li><p> deleteDeliveryPipelineAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDeliveryPipelineOperationCallable()
 *           <li><p> deleteDeliveryPipelineCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTargets</td>
 *      <td><p> Lists Targets in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTargets(ListTargetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTargets(LocationName parent)
 *           <li><p> listTargets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTargetsPagedCallable()
 *           <li><p> listTargetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RollbackTarget</td>
 *      <td><p> Creates a `Rollout` to roll back the specified target.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> rollbackTarget(RollbackTargetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> rollbackTarget(DeliveryPipelineName name, String targetId, String rolloutId)
 *           <li><p> rollbackTarget(String name, String targetId, String rolloutId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> rollbackTargetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetTarget</td>
 *      <td><p> Gets details of a single Target.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTarget(GetTargetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTarget(TargetName name)
 *           <li><p> getTarget(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTargetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateTarget</td>
 *      <td><p> Creates a new Target in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTargetAsync(CreateTargetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createTargetAsync(LocationName parent, Target target, String targetId)
 *           <li><p> createTargetAsync(String parent, Target target, String targetId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createTargetOperationCallable()
 *           <li><p> createTargetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateTarget</td>
 *      <td><p> Updates the parameters of a single Target.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateTargetAsync(UpdateTargetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateTargetAsync(Target target, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateTargetOperationCallable()
 *           <li><p> updateTargetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteTarget</td>
 *      <td><p> Deletes a single Target.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteTargetAsync(DeleteTargetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteTargetAsync(TargetName name)
 *           <li><p> deleteTargetAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteTargetOperationCallable()
 *           <li><p> deleteTargetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCustomTargetTypes</td>
 *      <td><p> Lists CustomTargetTypes in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCustomTargetTypes(ListCustomTargetTypesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCustomTargetTypes(LocationName parent)
 *           <li><p> listCustomTargetTypes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCustomTargetTypesPagedCallable()
 *           <li><p> listCustomTargetTypesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCustomTargetType</td>
 *      <td><p> Gets details of a single CustomTargetType.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCustomTargetType(GetCustomTargetTypeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCustomTargetType(CustomTargetTypeName name)
 *           <li><p> getCustomTargetType(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCustomTargetTypeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCustomTargetType</td>
 *      <td><p> Creates a new CustomTargetType in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCustomTargetTypeAsync(CreateCustomTargetTypeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createCustomTargetTypeAsync(LocationName parent, CustomTargetType customTargetType, String customTargetTypeId)
 *           <li><p> createCustomTargetTypeAsync(String parent, CustomTargetType customTargetType, String customTargetTypeId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCustomTargetTypeOperationCallable()
 *           <li><p> createCustomTargetTypeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCustomTargetType</td>
 *      <td><p> Updates a single CustomTargetType.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateCustomTargetTypeAsync(UpdateCustomTargetTypeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateCustomTargetTypeAsync(CustomTargetType customTargetType, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateCustomTargetTypeOperationCallable()
 *           <li><p> updateCustomTargetTypeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCustomTargetType</td>
 *      <td><p> Deletes a single CustomTargetType.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteCustomTargetTypeAsync(DeleteCustomTargetTypeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteCustomTargetTypeAsync(CustomTargetTypeName name)
 *           <li><p> deleteCustomTargetTypeAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCustomTargetTypeOperationCallable()
 *           <li><p> deleteCustomTargetTypeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListReleases</td>
 *      <td><p> Lists Releases in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listReleases(ListReleasesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listReleases(DeliveryPipelineName parent)
 *           <li><p> listReleases(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listReleasesPagedCallable()
 *           <li><p> listReleasesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRelease</td>
 *      <td><p> Gets details of a single Release.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRelease(GetReleaseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRelease(ReleaseName name)
 *           <li><p> getRelease(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getReleaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateRelease</td>
 *      <td><p> Creates a new Release in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createReleaseAsync(CreateReleaseRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createReleaseAsync(DeliveryPipelineName parent, Release release, String releaseId)
 *           <li><p> createReleaseAsync(String parent, Release release, String releaseId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createReleaseOperationCallable()
 *           <li><p> createReleaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AbandonRelease</td>
 *      <td><p> Abandons a Release in the Delivery Pipeline.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> abandonRelease(AbandonReleaseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> abandonRelease(ReleaseName name)
 *           <li><p> abandonRelease(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> abandonReleaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ApproveRollout</td>
 *      <td><p> Approves a Rollout.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> approveRollout(ApproveRolloutRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> approveRollout(RolloutName name)
 *           <li><p> approveRollout(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> approveRolloutCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AdvanceRollout</td>
 *      <td><p> Advances a Rollout in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> advanceRollout(AdvanceRolloutRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> advanceRollout(RolloutName name, String phaseId)
 *           <li><p> advanceRollout(String name, String phaseId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> advanceRolloutCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CancelRollout</td>
 *      <td><p> Cancels a Rollout in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> cancelRollout(CancelRolloutRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> cancelRollout(RolloutName name)
 *           <li><p> cancelRollout(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> cancelRolloutCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRollouts</td>
 *      <td><p> Lists Rollouts in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRollouts(ListRolloutsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRollouts(ReleaseName parent)
 *           <li><p> listRollouts(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRolloutsPagedCallable()
 *           <li><p> listRolloutsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRollout</td>
 *      <td><p> Gets details of a single Rollout.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRollout(GetRolloutRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRollout(RolloutName name)
 *           <li><p> getRollout(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRolloutCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateRollout</td>
 *      <td><p> Creates a new Rollout in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createRolloutAsync(CreateRolloutRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createRolloutAsync(ReleaseName parent, Rollout rollout, String rolloutId)
 *           <li><p> createRolloutAsync(String parent, Rollout rollout, String rolloutId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createRolloutOperationCallable()
 *           <li><p> createRolloutCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> IgnoreJob</td>
 *      <td><p> Ignores the specified Job in a Rollout.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> ignoreJob(IgnoreJobRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> ignoreJob(RolloutName rollout, String phaseId, String jobId)
 *           <li><p> ignoreJob(String rollout, String phaseId, String jobId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> ignoreJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RetryJob</td>
 *      <td><p> Retries the specified Job in a Rollout.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> retryJob(RetryJobRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> retryJob(RolloutName rollout, String phaseId, String jobId)
 *           <li><p> retryJob(String rollout, String phaseId, String jobId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> retryJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListJobRuns</td>
 *      <td><p> Lists JobRuns in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listJobRuns(ListJobRunsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listJobRuns(RolloutName parent)
 *           <li><p> listJobRuns(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listJobRunsPagedCallable()
 *           <li><p> listJobRunsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetJobRun</td>
 *      <td><p> Gets details of a single JobRun.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getJobRun(GetJobRunRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getJobRun(JobRunName name)
 *           <li><p> getJobRun(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getJobRunCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TerminateJobRun</td>
 *      <td><p> Terminates a Job Run in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> terminateJobRun(TerminateJobRunRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> terminateJobRun(JobRunName name)
 *           <li><p> terminateJobRun(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> terminateJobRunCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetConfig</td>
 *      <td><p> Gets the configuration for a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getConfig(GetConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getConfig(ConfigName name)
 *           <li><p> getConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAutomation</td>
 *      <td><p> Creates a new Automation in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAutomationAsync(CreateAutomationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createAutomationAsync(DeliveryPipelineName parent, Automation automation, String automationId)
 *           <li><p> createAutomationAsync(String parent, Automation automation, String automationId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAutomationOperationCallable()
 *           <li><p> createAutomationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAutomation</td>
 *      <td><p> Updates the parameters of a single Automation resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAutomationAsync(UpdateAutomationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateAutomationAsync(Automation automation, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAutomationOperationCallable()
 *           <li><p> updateAutomationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAutomation</td>
 *      <td><p> Deletes a single Automation resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAutomationAsync(DeleteAutomationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAutomationAsync(AutomationName name)
 *           <li><p> deleteAutomationAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAutomationOperationCallable()
 *           <li><p> deleteAutomationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAutomation</td>
 *      <td><p> Gets details of a single Automation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAutomation(GetAutomationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAutomation(AutomationName name)
 *           <li><p> getAutomation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAutomationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAutomations</td>
 *      <td><p> Lists Automations in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAutomations(ListAutomationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAutomations(DeliveryPipelineName parent)
 *           <li><p> listAutomations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAutomationsPagedCallable()
 *           <li><p> listAutomationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAutomationRun</td>
 *      <td><p> Gets details of a single AutomationRun.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAutomationRun(GetAutomationRunRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAutomationRun(AutomationRunName name)
 *           <li><p> getAutomationRun(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAutomationRunCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAutomationRuns</td>
 *      <td><p> Lists AutomationRuns in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAutomationRuns(ListAutomationRunsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAutomationRuns(DeliveryPipelineName parent)
 *           <li><p> listAutomationRuns(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAutomationRunsPagedCallable()
 *           <li><p> listAutomationRunsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CancelAutomationRun</td>
 *      <td><p> Cancels an AutomationRun. The `state` of the `AutomationRun` after cancelling is `CANCELLED`. `CancelAutomationRun` can be called on AutomationRun in the state `IN_PROGRESS` and `PENDING`; AutomationRun in a different state returns an `FAILED_PRECONDITION` error.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> cancelAutomationRun(CancelAutomationRunRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> cancelAutomationRun(AutomationRunName name)
 *           <li><p> cancelAutomationRun(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> cancelAutomationRunCallable()
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
 * <p>This class can be customized by passing in a custom instance of CloudDeploySettings to
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
 * CloudDeploySettings cloudDeploySettings =
 *     CloudDeploySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CloudDeployClient cloudDeployClient = CloudDeployClient.create(cloudDeploySettings);
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
 * CloudDeploySettings cloudDeploySettings =
 *     CloudDeploySettings.newBuilder().setEndpoint(myEndpoint).build();
 * CloudDeployClient cloudDeployClient = CloudDeployClient.create(cloudDeploySettings);
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
 * CloudDeploySettings cloudDeploySettings = CloudDeploySettings.newHttpJsonBuilder().build();
 * CloudDeployClient cloudDeployClient = CloudDeployClient.create(cloudDeploySettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CloudDeployClient implements BackgroundResource {
  private final CloudDeploySettings settings;
  private final CloudDeployStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of CloudDeployClient with default settings. */
  public static final CloudDeployClient create() throws IOException {
    return create(CloudDeploySettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CloudDeployClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CloudDeployClient create(CloudDeploySettings settings) throws IOException {
    return new CloudDeployClient(settings);
  }

  /**
   * Constructs an instance of CloudDeployClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(CloudDeploySettings).
   */
  public static final CloudDeployClient create(CloudDeployStub stub) {
    return new CloudDeployClient(stub);
  }

  /**
   * Constructs an instance of CloudDeployClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CloudDeployClient(CloudDeploySettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CloudDeployStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected CloudDeployClient(CloudDeployStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final CloudDeploySettings getSettings() {
    return settings;
  }

  public CloudDeployStub getStub() {
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
   * Lists DeliveryPipelines in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (DeliveryPipeline element :
   *       cloudDeployClient.listDeliveryPipelines(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of pipelines. Format must be
   *     `projects/{project_id}/locations/{location_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeliveryPipelinesPagedResponse listDeliveryPipelines(LocationName parent) {
    ListDeliveryPipelinesRequest request =
        ListDeliveryPipelinesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDeliveryPipelines(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DeliveryPipelines in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (DeliveryPipeline element :
   *       cloudDeployClient.listDeliveryPipelines(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of pipelines. Format must be
   *     `projects/{project_id}/locations/{location_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeliveryPipelinesPagedResponse listDeliveryPipelines(String parent) {
    ListDeliveryPipelinesRequest request =
        ListDeliveryPipelinesRequest.newBuilder().setParent(parent).build();
    return listDeliveryPipelines(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DeliveryPipelines in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListDeliveryPipelinesRequest request =
   *       ListDeliveryPipelinesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (DeliveryPipeline element :
   *       cloudDeployClient.listDeliveryPipelines(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeliveryPipelinesPagedResponse listDeliveryPipelines(
      ListDeliveryPipelinesRequest request) {
    return listDeliveryPipelinesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DeliveryPipelines in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListDeliveryPipelinesRequest request =
   *       ListDeliveryPipelinesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<DeliveryPipeline> future =
   *       cloudDeployClient.listDeliveryPipelinesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DeliveryPipeline element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDeliveryPipelinesRequest, ListDeliveryPipelinesPagedResponse>
      listDeliveryPipelinesPagedCallable() {
    return stub.listDeliveryPipelinesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DeliveryPipelines in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListDeliveryPipelinesRequest request =
   *       ListDeliveryPipelinesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDeliveryPipelinesResponse response =
   *         cloudDeployClient.listDeliveryPipelinesCallable().call(request);
   *     for (DeliveryPipeline element : response.getDeliveryPipelinesList()) {
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
  public final UnaryCallable<ListDeliveryPipelinesRequest, ListDeliveryPipelinesResponse>
      listDeliveryPipelinesCallable() {
    return stub.listDeliveryPipelinesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeliveryPipelineName name =
   *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]");
   *   DeliveryPipeline response = cloudDeployClient.getDeliveryPipeline(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `DeliveryPipeline`. Format must be
   *     `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeliveryPipeline getDeliveryPipeline(DeliveryPipelineName name) {
    GetDeliveryPipelineRequest request =
        GetDeliveryPipelineRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDeliveryPipeline(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name =
   *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]").toString();
   *   DeliveryPipeline response = cloudDeployClient.getDeliveryPipeline(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `DeliveryPipeline`. Format must be
   *     `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeliveryPipeline getDeliveryPipeline(String name) {
    GetDeliveryPipelineRequest request =
        GetDeliveryPipelineRequest.newBuilder().setName(name).build();
    return getDeliveryPipeline(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetDeliveryPipelineRequest request =
   *       GetDeliveryPipelineRequest.newBuilder()
   *           .setName(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .build();
   *   DeliveryPipeline response = cloudDeployClient.getDeliveryPipeline(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeliveryPipeline getDeliveryPipeline(GetDeliveryPipelineRequest request) {
    return getDeliveryPipelineCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetDeliveryPipelineRequest request =
   *       GetDeliveryPipelineRequest.newBuilder()
   *           .setName(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DeliveryPipeline> future =
   *       cloudDeployClient.getDeliveryPipelineCallable().futureCall(request);
   *   // Do something.
   *   DeliveryPipeline response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDeliveryPipelineRequest, DeliveryPipeline>
      getDeliveryPipelineCallable() {
    return stub.getDeliveryPipelineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DeliveryPipeline in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   DeliveryPipeline deliveryPipeline = DeliveryPipeline.newBuilder().build();
   *   String deliveryPipelineId = "deliveryPipelineId-632411535";
   *   DeliveryPipeline response =
   *       cloudDeployClient
   *           .createDeliveryPipelineAsync(parent, deliveryPipeline, deliveryPipelineId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which the `DeliveryPipeline` should be
   *     created. Format should be `projects/{project_id}/locations/{location_name}`.
   * @param deliveryPipeline Required. The `DeliveryPipeline` to create.
   * @param deliveryPipelineId Required. ID of the `DeliveryPipeline`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeliveryPipeline, OperationMetadata> createDeliveryPipelineAsync(
      LocationName parent, DeliveryPipeline deliveryPipeline, String deliveryPipelineId) {
    CreateDeliveryPipelineRequest request =
        CreateDeliveryPipelineRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDeliveryPipeline(deliveryPipeline)
            .setDeliveryPipelineId(deliveryPipelineId)
            .build();
    return createDeliveryPipelineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DeliveryPipeline in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   DeliveryPipeline deliveryPipeline = DeliveryPipeline.newBuilder().build();
   *   String deliveryPipelineId = "deliveryPipelineId-632411535";
   *   DeliveryPipeline response =
   *       cloudDeployClient
   *           .createDeliveryPipelineAsync(parent, deliveryPipeline, deliveryPipelineId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which the `DeliveryPipeline` should be
   *     created. Format should be `projects/{project_id}/locations/{location_name}`.
   * @param deliveryPipeline Required. The `DeliveryPipeline` to create.
   * @param deliveryPipelineId Required. ID of the `DeliveryPipeline`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeliveryPipeline, OperationMetadata> createDeliveryPipelineAsync(
      String parent, DeliveryPipeline deliveryPipeline, String deliveryPipelineId) {
    CreateDeliveryPipelineRequest request =
        CreateDeliveryPipelineRequest.newBuilder()
            .setParent(parent)
            .setDeliveryPipeline(deliveryPipeline)
            .setDeliveryPipelineId(deliveryPipelineId)
            .build();
    return createDeliveryPipelineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DeliveryPipeline in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateDeliveryPipelineRequest request =
   *       CreateDeliveryPipelineRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDeliveryPipelineId("deliveryPipelineId-632411535")
   *           .setDeliveryPipeline(DeliveryPipeline.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   DeliveryPipeline response = cloudDeployClient.createDeliveryPipelineAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeliveryPipeline, OperationMetadata> createDeliveryPipelineAsync(
      CreateDeliveryPipelineRequest request) {
    return createDeliveryPipelineOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DeliveryPipeline in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateDeliveryPipelineRequest request =
   *       CreateDeliveryPipelineRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDeliveryPipelineId("deliveryPipelineId-632411535")
   *           .setDeliveryPipeline(DeliveryPipeline.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<DeliveryPipeline, OperationMetadata> future =
   *       cloudDeployClient.createDeliveryPipelineOperationCallable().futureCall(request);
   *   // Do something.
   *   DeliveryPipeline response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateDeliveryPipelineRequest, DeliveryPipeline, OperationMetadata>
      createDeliveryPipelineOperationCallable() {
    return stub.createDeliveryPipelineOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DeliveryPipeline in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateDeliveryPipelineRequest request =
   *       CreateDeliveryPipelineRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDeliveryPipelineId("deliveryPipelineId-632411535")
   *           .setDeliveryPipeline(DeliveryPipeline.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudDeployClient.createDeliveryPipelineCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDeliveryPipelineRequest, Operation>
      createDeliveryPipelineCallable() {
    return stub.createDeliveryPipelineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeliveryPipeline deliveryPipeline = DeliveryPipeline.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DeliveryPipeline response =
   *       cloudDeployClient.updateDeliveryPipelineAsync(deliveryPipeline, updateMask).get();
   * }
   * }</pre>
   *
   * @param deliveryPipeline Required. The `DeliveryPipeline` to update.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     `DeliveryPipeline` resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field will be overwritten if it's in the
   *     mask. If the user doesn't provide a mask then all fields are overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeliveryPipeline, OperationMetadata> updateDeliveryPipelineAsync(
      DeliveryPipeline deliveryPipeline, FieldMask updateMask) {
    UpdateDeliveryPipelineRequest request =
        UpdateDeliveryPipelineRequest.newBuilder()
            .setDeliveryPipeline(deliveryPipeline)
            .setUpdateMask(updateMask)
            .build();
    return updateDeliveryPipelineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   UpdateDeliveryPipelineRequest request =
   *       UpdateDeliveryPipelineRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDeliveryPipeline(DeliveryPipeline.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   DeliveryPipeline response = cloudDeployClient.updateDeliveryPipelineAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeliveryPipeline, OperationMetadata> updateDeliveryPipelineAsync(
      UpdateDeliveryPipelineRequest request) {
    return updateDeliveryPipelineOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   UpdateDeliveryPipelineRequest request =
   *       UpdateDeliveryPipelineRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDeliveryPipeline(DeliveryPipeline.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<DeliveryPipeline, OperationMetadata> future =
   *       cloudDeployClient.updateDeliveryPipelineOperationCallable().futureCall(request);
   *   // Do something.
   *   DeliveryPipeline response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateDeliveryPipelineRequest, DeliveryPipeline, OperationMetadata>
      updateDeliveryPipelineOperationCallable() {
    return stub.updateDeliveryPipelineOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   UpdateDeliveryPipelineRequest request =
   *       UpdateDeliveryPipelineRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDeliveryPipeline(DeliveryPipeline.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudDeployClient.updateDeliveryPipelineCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDeliveryPipelineRequest, Operation>
      updateDeliveryPipelineCallable() {
    return stub.updateDeliveryPipelineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeliveryPipelineName name =
   *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]");
   *   cloudDeployClient.deleteDeliveryPipelineAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `DeliveryPipeline` to delete. Format should be
   *     `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDeliveryPipelineAsync(
      DeliveryPipelineName name) {
    DeleteDeliveryPipelineRequest request =
        DeleteDeliveryPipelineRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteDeliveryPipelineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name =
   *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]").toString();
   *   cloudDeployClient.deleteDeliveryPipelineAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `DeliveryPipeline` to delete. Format should be
   *     `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDeliveryPipelineAsync(String name) {
    DeleteDeliveryPipelineRequest request =
        DeleteDeliveryPipelineRequest.newBuilder().setName(name).build();
    return deleteDeliveryPipelineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeleteDeliveryPipelineRequest request =
   *       DeleteDeliveryPipelineRequest.newBuilder()
   *           .setName(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   cloudDeployClient.deleteDeliveryPipelineAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDeliveryPipelineAsync(
      DeleteDeliveryPipelineRequest request) {
    return deleteDeliveryPipelineOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeleteDeliveryPipelineRequest request =
   *       DeleteDeliveryPipelineRequest.newBuilder()
   *           .setName(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       cloudDeployClient.deleteDeliveryPipelineOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDeliveryPipelineRequest, Empty, OperationMetadata>
      deleteDeliveryPipelineOperationCallable() {
    return stub.deleteDeliveryPipelineOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeleteDeliveryPipelineRequest request =
   *       DeleteDeliveryPipelineRequest.newBuilder()
   *           .setName(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudDeployClient.deleteDeliveryPipelineCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDeliveryPipelineRequest, Operation>
      deleteDeliveryPipelineCallable() {
    return stub.deleteDeliveryPipelineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Targets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Target element : cloudDeployClient.listTargets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of targets. Format must be
   *     `projects/{project_id}/locations/{location_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTargetsPagedResponse listTargets(LocationName parent) {
    ListTargetsRequest request =
        ListTargetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTargets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Targets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Target element : cloudDeployClient.listTargets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of targets. Format must be
   *     `projects/{project_id}/locations/{location_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTargetsPagedResponse listTargets(String parent) {
    ListTargetsRequest request = ListTargetsRequest.newBuilder().setParent(parent).build();
    return listTargets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Targets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListTargetsRequest request =
   *       ListTargetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Target element : cloudDeployClient.listTargets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTargetsPagedResponse listTargets(ListTargetsRequest request) {
    return listTargetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Targets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListTargetsRequest request =
   *       ListTargetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Target> future = cloudDeployClient.listTargetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Target element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTargetsRequest, ListTargetsPagedResponse>
      listTargetsPagedCallable() {
    return stub.listTargetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Targets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListTargetsRequest request =
   *       ListTargetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListTargetsResponse response = cloudDeployClient.listTargetsCallable().call(request);
   *     for (Target element : response.getTargetsList()) {
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
  public final UnaryCallable<ListTargetsRequest, ListTargetsResponse> listTargetsCallable() {
    return stub.listTargetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `Rollout` to roll back the specified target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeliveryPipelineName name =
   *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]");
   *   String targetId = "targetId-441951604";
   *   String rolloutId = "rolloutId551248556";
   *   RollbackTargetResponse response = cloudDeployClient.rollbackTarget(name, targetId, rolloutId);
   * }
   * }</pre>
   *
   * @param name Required. The `DeliveryPipeline` for which the rollback `Rollout` should be
   *     created. Format should be
   *     `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}`.
   * @param targetId Required. ID of the `Target` that is being rolled back.
   * @param rolloutId Required. ID of the rollback `Rollout` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RollbackTargetResponse rollbackTarget(
      DeliveryPipelineName name, String targetId, String rolloutId) {
    RollbackTargetRequest request =
        RollbackTargetRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setTargetId(targetId)
            .setRolloutId(rolloutId)
            .build();
    return rollbackTarget(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `Rollout` to roll back the specified target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name =
   *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]").toString();
   *   String targetId = "targetId-441951604";
   *   String rolloutId = "rolloutId551248556";
   *   RollbackTargetResponse response = cloudDeployClient.rollbackTarget(name, targetId, rolloutId);
   * }
   * }</pre>
   *
   * @param name Required. The `DeliveryPipeline` for which the rollback `Rollout` should be
   *     created. Format should be
   *     `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}`.
   * @param targetId Required. ID of the `Target` that is being rolled back.
   * @param rolloutId Required. ID of the rollback `Rollout` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RollbackTargetResponse rollbackTarget(
      String name, String targetId, String rolloutId) {
    RollbackTargetRequest request =
        RollbackTargetRequest.newBuilder()
            .setName(name)
            .setTargetId(targetId)
            .setRolloutId(rolloutId)
            .build();
    return rollbackTarget(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `Rollout` to roll back the specified target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   RollbackTargetRequest request =
   *       RollbackTargetRequest.newBuilder()
   *           .setName(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setTargetId("targetId-441951604")
   *           .setRolloutId("rolloutId551248556")
   *           .setReleaseId("releaseId89607042")
   *           .setRolloutToRollBack("rolloutToRollBack-1195544784")
   *           .setRollbackConfig(RollbackTargetConfig.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   RollbackTargetResponse response = cloudDeployClient.rollbackTarget(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RollbackTargetResponse rollbackTarget(RollbackTargetRequest request) {
    return rollbackTargetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `Rollout` to roll back the specified target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   RollbackTargetRequest request =
   *       RollbackTargetRequest.newBuilder()
   *           .setName(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setTargetId("targetId-441951604")
   *           .setRolloutId("rolloutId551248556")
   *           .setReleaseId("releaseId89607042")
   *           .setRolloutToRollBack("rolloutToRollBack-1195544784")
   *           .setRollbackConfig(RollbackTargetConfig.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<RollbackTargetResponse> future =
   *       cloudDeployClient.rollbackTargetCallable().futureCall(request);
   *   // Do something.
   *   RollbackTargetResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RollbackTargetRequest, RollbackTargetResponse>
      rollbackTargetCallable() {
    return stub.rollbackTargetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   TargetName name = TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]");
   *   Target response = cloudDeployClient.getTarget(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `Target`. Format must be
   *     `projects/{project_id}/locations/{location_name}/targets/{target_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Target getTarget(TargetName name) {
    GetTargetRequest request =
        GetTargetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTarget(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name = TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]").toString();
   *   Target response = cloudDeployClient.getTarget(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `Target`. Format must be
   *     `projects/{project_id}/locations/{location_name}/targets/{target_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Target getTarget(String name) {
    GetTargetRequest request = GetTargetRequest.newBuilder().setName(name).build();
    return getTarget(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetTargetRequest request =
   *       GetTargetRequest.newBuilder()
   *           .setName(TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]").toString())
   *           .build();
   *   Target response = cloudDeployClient.getTarget(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Target getTarget(GetTargetRequest request) {
    return getTargetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetTargetRequest request =
   *       GetTargetRequest.newBuilder()
   *           .setName(TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]").toString())
   *           .build();
   *   ApiFuture<Target> future = cloudDeployClient.getTargetCallable().futureCall(request);
   *   // Do something.
   *   Target response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTargetRequest, Target> getTargetCallable() {
    return stub.getTargetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Target in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Target target = Target.newBuilder().build();
   *   String targetId = "targetId-441951604";
   *   Target response = cloudDeployClient.createTargetAsync(parent, target, targetId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which the `Target` should be created. Format
   *     should be `projects/{project_id}/locations/{location_name}`.
   * @param target Required. The `Target` to create.
   * @param targetId Required. ID of the `Target`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Target, OperationMetadata> createTargetAsync(
      LocationName parent, Target target, String targetId) {
    CreateTargetRequest request =
        CreateTargetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTarget(target)
            .setTargetId(targetId)
            .build();
    return createTargetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Target in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Target target = Target.newBuilder().build();
   *   String targetId = "targetId-441951604";
   *   Target response = cloudDeployClient.createTargetAsync(parent, target, targetId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which the `Target` should be created. Format
   *     should be `projects/{project_id}/locations/{location_name}`.
   * @param target Required. The `Target` to create.
   * @param targetId Required. ID of the `Target`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Target, OperationMetadata> createTargetAsync(
      String parent, Target target, String targetId) {
    CreateTargetRequest request =
        CreateTargetRequest.newBuilder()
            .setParent(parent)
            .setTarget(target)
            .setTargetId(targetId)
            .build();
    return createTargetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Target in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateTargetRequest request =
   *       CreateTargetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTargetId("targetId-441951604")
   *           .setTarget(Target.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   Target response = cloudDeployClient.createTargetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Target, OperationMetadata> createTargetAsync(
      CreateTargetRequest request) {
    return createTargetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Target in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateTargetRequest request =
   *       CreateTargetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTargetId("targetId-441951604")
   *           .setTarget(Target.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Target, OperationMetadata> future =
   *       cloudDeployClient.createTargetOperationCallable().futureCall(request);
   *   // Do something.
   *   Target response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateTargetRequest, Target, OperationMetadata>
      createTargetOperationCallable() {
    return stub.createTargetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Target in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateTargetRequest request =
   *       CreateTargetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTargetId("targetId-441951604")
   *           .setTarget(Target.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = cloudDeployClient.createTargetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTargetRequest, Operation> createTargetCallable() {
    return stub.createTargetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   Target target = Target.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Target response = cloudDeployClient.updateTargetAsync(target, updateMask).get();
   * }
   * }</pre>
   *
   * @param target Required. The `Target` to update.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Target resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it's in the mask. If the
   *     user doesn't provide a mask then all fields are overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Target, OperationMetadata> updateTargetAsync(
      Target target, FieldMask updateMask) {
    UpdateTargetRequest request =
        UpdateTargetRequest.newBuilder().setTarget(target).setUpdateMask(updateMask).build();
    return updateTargetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   UpdateTargetRequest request =
   *       UpdateTargetRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTarget(Target.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   Target response = cloudDeployClient.updateTargetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Target, OperationMetadata> updateTargetAsync(
      UpdateTargetRequest request) {
    return updateTargetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   UpdateTargetRequest request =
   *       UpdateTargetRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTarget(Target.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Target, OperationMetadata> future =
   *       cloudDeployClient.updateTargetOperationCallable().futureCall(request);
   *   // Do something.
   *   Target response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateTargetRequest, Target, OperationMetadata>
      updateTargetOperationCallable() {
    return stub.updateTargetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   UpdateTargetRequest request =
   *       UpdateTargetRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTarget(Target.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = cloudDeployClient.updateTargetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTargetRequest, Operation> updateTargetCallable() {
    return stub.updateTargetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   TargetName name = TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]");
   *   cloudDeployClient.deleteTargetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `Target` to delete. Format should be
   *     `projects/{project_id}/locations/{location_name}/targets/{target_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTargetAsync(TargetName name) {
    DeleteTargetRequest request =
        DeleteTargetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteTargetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name = TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]").toString();
   *   cloudDeployClient.deleteTargetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `Target` to delete. Format should be
   *     `projects/{project_id}/locations/{location_name}/targets/{target_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTargetAsync(String name) {
    DeleteTargetRequest request = DeleteTargetRequest.newBuilder().setName(name).build();
    return deleteTargetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeleteTargetRequest request =
   *       DeleteTargetRequest.newBuilder()
   *           .setName(TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]").toString())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   cloudDeployClient.deleteTargetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTargetAsync(
      DeleteTargetRequest request) {
    return deleteTargetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeleteTargetRequest request =
   *       DeleteTargetRequest.newBuilder()
   *           .setName(TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]").toString())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       cloudDeployClient.deleteTargetOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTargetRequest, Empty, OperationMetadata>
      deleteTargetOperationCallable() {
    return stub.deleteTargetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeleteTargetRequest request =
   *       DeleteTargetRequest.newBuilder()
   *           .setName(TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]").toString())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future = cloudDeployClient.deleteTargetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTargetRequest, Operation> deleteTargetCallable() {
    return stub.deleteTargetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomTargetTypes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (CustomTargetType element :
   *       cloudDeployClient.listCustomTargetTypes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent that owns this collection of custom target types. Format
   *     must be `projects/{project_id}/locations/{location_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomTargetTypesPagedResponse listCustomTargetTypes(LocationName parent) {
    ListCustomTargetTypesRequest request =
        ListCustomTargetTypesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCustomTargetTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomTargetTypes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (CustomTargetType element :
   *       cloudDeployClient.listCustomTargetTypes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent that owns this collection of custom target types. Format
   *     must be `projects/{project_id}/locations/{location_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomTargetTypesPagedResponse listCustomTargetTypes(String parent) {
    ListCustomTargetTypesRequest request =
        ListCustomTargetTypesRequest.newBuilder().setParent(parent).build();
    return listCustomTargetTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomTargetTypes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListCustomTargetTypesRequest request =
   *       ListCustomTargetTypesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (CustomTargetType element :
   *       cloudDeployClient.listCustomTargetTypes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomTargetTypesPagedResponse listCustomTargetTypes(
      ListCustomTargetTypesRequest request) {
    return listCustomTargetTypesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomTargetTypes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListCustomTargetTypesRequest request =
   *       ListCustomTargetTypesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<CustomTargetType> future =
   *       cloudDeployClient.listCustomTargetTypesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CustomTargetType element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCustomTargetTypesRequest, ListCustomTargetTypesPagedResponse>
      listCustomTargetTypesPagedCallable() {
    return stub.listCustomTargetTypesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomTargetTypes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListCustomTargetTypesRequest request =
   *       ListCustomTargetTypesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCustomTargetTypesResponse response =
   *         cloudDeployClient.listCustomTargetTypesCallable().call(request);
   *     for (CustomTargetType element : response.getCustomTargetTypesList()) {
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
  public final UnaryCallable<ListCustomTargetTypesRequest, ListCustomTargetTypesResponse>
      listCustomTargetTypesCallable() {
    return stub.listCustomTargetTypesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CustomTargetType.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CustomTargetTypeName name =
   *       CustomTargetTypeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_TARGET_TYPE]");
   *   CustomTargetType response = cloudDeployClient.getCustomTargetType(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `CustomTargetType`. Format must be
   *     `projects/{project_id}/locations/{location_name}/customTargetTypes/{custom_target_type}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomTargetType getCustomTargetType(CustomTargetTypeName name) {
    GetCustomTargetTypeRequest request =
        GetCustomTargetTypeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCustomTargetType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CustomTargetType.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name =
   *       CustomTargetTypeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_TARGET_TYPE]").toString();
   *   CustomTargetType response = cloudDeployClient.getCustomTargetType(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `CustomTargetType`. Format must be
   *     `projects/{project_id}/locations/{location_name}/customTargetTypes/{custom_target_type}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomTargetType getCustomTargetType(String name) {
    GetCustomTargetTypeRequest request =
        GetCustomTargetTypeRequest.newBuilder().setName(name).build();
    return getCustomTargetType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CustomTargetType.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetCustomTargetTypeRequest request =
   *       GetCustomTargetTypeRequest.newBuilder()
   *           .setName(
   *               CustomTargetTypeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_TARGET_TYPE]")
   *                   .toString())
   *           .build();
   *   CustomTargetType response = cloudDeployClient.getCustomTargetType(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomTargetType getCustomTargetType(GetCustomTargetTypeRequest request) {
    return getCustomTargetTypeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CustomTargetType.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetCustomTargetTypeRequest request =
   *       GetCustomTargetTypeRequest.newBuilder()
   *           .setName(
   *               CustomTargetTypeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_TARGET_TYPE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CustomTargetType> future =
   *       cloudDeployClient.getCustomTargetTypeCallable().futureCall(request);
   *   // Do something.
   *   CustomTargetType response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCustomTargetTypeRequest, CustomTargetType>
      getCustomTargetTypeCallable() {
    return stub.getCustomTargetTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CustomTargetType in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   CustomTargetType customTargetType = CustomTargetType.newBuilder().build();
   *   String customTargetTypeId = "customTargetTypeId1451302135";
   *   CustomTargetType response =
   *       cloudDeployClient
   *           .createCustomTargetTypeAsync(parent, customTargetType, customTargetTypeId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which the `CustomTargetType` should be
   *     created. Format should be `projects/{project_id}/locations/{location_name}`.
   * @param customTargetType Required. The `CustomTargetType` to create.
   * @param customTargetTypeId Required. ID of the `CustomTargetType`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CustomTargetType, OperationMetadata> createCustomTargetTypeAsync(
      LocationName parent, CustomTargetType customTargetType, String customTargetTypeId) {
    CreateCustomTargetTypeRequest request =
        CreateCustomTargetTypeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCustomTargetType(customTargetType)
            .setCustomTargetTypeId(customTargetTypeId)
            .build();
    return createCustomTargetTypeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CustomTargetType in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   CustomTargetType customTargetType = CustomTargetType.newBuilder().build();
   *   String customTargetTypeId = "customTargetTypeId1451302135";
   *   CustomTargetType response =
   *       cloudDeployClient
   *           .createCustomTargetTypeAsync(parent, customTargetType, customTargetTypeId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which the `CustomTargetType` should be
   *     created. Format should be `projects/{project_id}/locations/{location_name}`.
   * @param customTargetType Required. The `CustomTargetType` to create.
   * @param customTargetTypeId Required. ID of the `CustomTargetType`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CustomTargetType, OperationMetadata> createCustomTargetTypeAsync(
      String parent, CustomTargetType customTargetType, String customTargetTypeId) {
    CreateCustomTargetTypeRequest request =
        CreateCustomTargetTypeRequest.newBuilder()
            .setParent(parent)
            .setCustomTargetType(customTargetType)
            .setCustomTargetTypeId(customTargetTypeId)
            .build();
    return createCustomTargetTypeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CustomTargetType in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateCustomTargetTypeRequest request =
   *       CreateCustomTargetTypeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCustomTargetTypeId("customTargetTypeId1451302135")
   *           .setCustomTargetType(CustomTargetType.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   CustomTargetType response = cloudDeployClient.createCustomTargetTypeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CustomTargetType, OperationMetadata> createCustomTargetTypeAsync(
      CreateCustomTargetTypeRequest request) {
    return createCustomTargetTypeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CustomTargetType in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateCustomTargetTypeRequest request =
   *       CreateCustomTargetTypeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCustomTargetTypeId("customTargetTypeId1451302135")
   *           .setCustomTargetType(CustomTargetType.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<CustomTargetType, OperationMetadata> future =
   *       cloudDeployClient.createCustomTargetTypeOperationCallable().futureCall(request);
   *   // Do something.
   *   CustomTargetType response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateCustomTargetTypeRequest, CustomTargetType, OperationMetadata>
      createCustomTargetTypeOperationCallable() {
    return stub.createCustomTargetTypeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CustomTargetType in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateCustomTargetTypeRequest request =
   *       CreateCustomTargetTypeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCustomTargetTypeId("customTargetTypeId1451302135")
   *           .setCustomTargetType(CustomTargetType.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudDeployClient.createCustomTargetTypeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCustomTargetTypeRequest, Operation>
      createCustomTargetTypeCallable() {
    return stub.createCustomTargetTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single CustomTargetType.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CustomTargetType customTargetType = CustomTargetType.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CustomTargetType response =
   *       cloudDeployClient.updateCustomTargetTypeAsync(customTargetType, updateMask).get();
   * }
   * }</pre>
   *
   * @param customTargetType Required. The `CustomTargetType` to update.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     `CustomTargetType` resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field will be overwritten if it's in the
   *     mask. If the user doesn't provide a mask then all fields are overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CustomTargetType, OperationMetadata> updateCustomTargetTypeAsync(
      CustomTargetType customTargetType, FieldMask updateMask) {
    UpdateCustomTargetTypeRequest request =
        UpdateCustomTargetTypeRequest.newBuilder()
            .setCustomTargetType(customTargetType)
            .setUpdateMask(updateMask)
            .build();
    return updateCustomTargetTypeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single CustomTargetType.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   UpdateCustomTargetTypeRequest request =
   *       UpdateCustomTargetTypeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCustomTargetType(CustomTargetType.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   CustomTargetType response = cloudDeployClient.updateCustomTargetTypeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CustomTargetType, OperationMetadata> updateCustomTargetTypeAsync(
      UpdateCustomTargetTypeRequest request) {
    return updateCustomTargetTypeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single CustomTargetType.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   UpdateCustomTargetTypeRequest request =
   *       UpdateCustomTargetTypeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCustomTargetType(CustomTargetType.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<CustomTargetType, OperationMetadata> future =
   *       cloudDeployClient.updateCustomTargetTypeOperationCallable().futureCall(request);
   *   // Do something.
   *   CustomTargetType response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateCustomTargetTypeRequest, CustomTargetType, OperationMetadata>
      updateCustomTargetTypeOperationCallable() {
    return stub.updateCustomTargetTypeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single CustomTargetType.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   UpdateCustomTargetTypeRequest request =
   *       UpdateCustomTargetTypeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCustomTargetType(CustomTargetType.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudDeployClient.updateCustomTargetTypeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCustomTargetTypeRequest, Operation>
      updateCustomTargetTypeCallable() {
    return stub.updateCustomTargetTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single CustomTargetType.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CustomTargetTypeName name =
   *       CustomTargetTypeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_TARGET_TYPE]");
   *   cloudDeployClient.deleteCustomTargetTypeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `CustomTargetType` to delete. Format must be
   *     `projects/{project_id}/locations/{location_name}/customTargetTypes/{custom_target_type}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCustomTargetTypeAsync(
      CustomTargetTypeName name) {
    DeleteCustomTargetTypeRequest request =
        DeleteCustomTargetTypeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteCustomTargetTypeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single CustomTargetType.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name =
   *       CustomTargetTypeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_TARGET_TYPE]").toString();
   *   cloudDeployClient.deleteCustomTargetTypeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `CustomTargetType` to delete. Format must be
   *     `projects/{project_id}/locations/{location_name}/customTargetTypes/{custom_target_type}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCustomTargetTypeAsync(String name) {
    DeleteCustomTargetTypeRequest request =
        DeleteCustomTargetTypeRequest.newBuilder().setName(name).build();
    return deleteCustomTargetTypeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single CustomTargetType.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeleteCustomTargetTypeRequest request =
   *       DeleteCustomTargetTypeRequest.newBuilder()
   *           .setName(
   *               CustomTargetTypeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_TARGET_TYPE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   cloudDeployClient.deleteCustomTargetTypeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCustomTargetTypeAsync(
      DeleteCustomTargetTypeRequest request) {
    return deleteCustomTargetTypeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single CustomTargetType.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeleteCustomTargetTypeRequest request =
   *       DeleteCustomTargetTypeRequest.newBuilder()
   *           .setName(
   *               CustomTargetTypeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_TARGET_TYPE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       cloudDeployClient.deleteCustomTargetTypeOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteCustomTargetTypeRequest, Empty, OperationMetadata>
      deleteCustomTargetTypeOperationCallable() {
    return stub.deleteCustomTargetTypeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single CustomTargetType.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeleteCustomTargetTypeRequest request =
   *       DeleteCustomTargetTypeRequest.newBuilder()
   *           .setName(
   *               CustomTargetTypeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_TARGET_TYPE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudDeployClient.deleteCustomTargetTypeCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCustomTargetTypeRequest, Operation>
      deleteCustomTargetTypeCallable() {
    return stub.deleteCustomTargetTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Releases in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeliveryPipelineName parent =
   *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]");
   *   for (Release element : cloudDeployClient.listReleases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The `DeliveryPipeline` which owns this collection of `Release` objects.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReleasesPagedResponse listReleases(DeliveryPipelineName parent) {
    ListReleasesRequest request =
        ListReleasesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listReleases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Releases in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String parent =
   *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]").toString();
   *   for (Release element : cloudDeployClient.listReleases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The `DeliveryPipeline` which owns this collection of `Release` objects.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReleasesPagedResponse listReleases(String parent) {
    ListReleasesRequest request = ListReleasesRequest.newBuilder().setParent(parent).build();
    return listReleases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Releases in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListReleasesRequest request =
   *       ListReleasesRequest.newBuilder()
   *           .setParent(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Release element : cloudDeployClient.listReleases(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReleasesPagedResponse listReleases(ListReleasesRequest request) {
    return listReleasesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Releases in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListReleasesRequest request =
   *       ListReleasesRequest.newBuilder()
   *           .setParent(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Release> future = cloudDeployClient.listReleasesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Release element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReleasesRequest, ListReleasesPagedResponse>
      listReleasesPagedCallable() {
    return stub.listReleasesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Releases in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListReleasesRequest request =
   *       ListReleasesRequest.newBuilder()
   *           .setParent(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListReleasesResponse response = cloudDeployClient.listReleasesCallable().call(request);
   *     for (Release element : response.getReleasesList()) {
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
  public final UnaryCallable<ListReleasesRequest, ListReleasesResponse> listReleasesCallable() {
    return stub.listReleasesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ReleaseName name =
   *       ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]");
   *   Release response = cloudDeployClient.getRelease(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `Release`. Format must be
   *     `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/releases/{release_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Release getRelease(ReleaseName name) {
    GetReleaseRequest request =
        GetReleaseRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRelease(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name =
   *       ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]").toString();
   *   Release response = cloudDeployClient.getRelease(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `Release`. Format must be
   *     `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/releases/{release_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Release getRelease(String name) {
    GetReleaseRequest request = GetReleaseRequest.newBuilder().setName(name).build();
    return getRelease(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetReleaseRequest request =
   *       GetReleaseRequest.newBuilder()
   *           .setName(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]")
   *                   .toString())
   *           .build();
   *   Release response = cloudDeployClient.getRelease(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Release getRelease(GetReleaseRequest request) {
    return getReleaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetReleaseRequest request =
   *       GetReleaseRequest.newBuilder()
   *           .setName(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Release> future = cloudDeployClient.getReleaseCallable().futureCall(request);
   *   // Do something.
   *   Release response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetReleaseRequest, Release> getReleaseCallable() {
    return stub.getReleaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Release in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeliveryPipelineName parent =
   *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]");
   *   Release release = Release.newBuilder().build();
   *   String releaseId = "releaseId89607042";
   *   Release response = cloudDeployClient.createReleaseAsync(parent, release, releaseId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which the `Release` should be created. Format
   *     should be
   *     `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}`.
   * @param release Required. The `Release` to create.
   * @param releaseId Required. ID of the `Release`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Release, OperationMetadata> createReleaseAsync(
      DeliveryPipelineName parent, Release release, String releaseId) {
    CreateReleaseRequest request =
        CreateReleaseRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRelease(release)
            .setReleaseId(releaseId)
            .build();
    return createReleaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Release in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String parent =
   *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]").toString();
   *   Release release = Release.newBuilder().build();
   *   String releaseId = "releaseId89607042";
   *   Release response = cloudDeployClient.createReleaseAsync(parent, release, releaseId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which the `Release` should be created. Format
   *     should be
   *     `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}`.
   * @param release Required. The `Release` to create.
   * @param releaseId Required. ID of the `Release`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Release, OperationMetadata> createReleaseAsync(
      String parent, Release release, String releaseId) {
    CreateReleaseRequest request =
        CreateReleaseRequest.newBuilder()
            .setParent(parent)
            .setRelease(release)
            .setReleaseId(releaseId)
            .build();
    return createReleaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Release in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateReleaseRequest request =
   *       CreateReleaseRequest.newBuilder()
   *           .setParent(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setReleaseId("releaseId89607042")
   *           .setRelease(Release.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   Release response = cloudDeployClient.createReleaseAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Release, OperationMetadata> createReleaseAsync(
      CreateReleaseRequest request) {
    return createReleaseOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Release in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateReleaseRequest request =
   *       CreateReleaseRequest.newBuilder()
   *           .setParent(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setReleaseId("releaseId89607042")
   *           .setRelease(Release.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Release, OperationMetadata> future =
   *       cloudDeployClient.createReleaseOperationCallable().futureCall(request);
   *   // Do something.
   *   Release response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateReleaseRequest, Release, OperationMetadata>
      createReleaseOperationCallable() {
    return stub.createReleaseOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Release in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateReleaseRequest request =
   *       CreateReleaseRequest.newBuilder()
   *           .setParent(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setReleaseId("releaseId89607042")
   *           .setRelease(Release.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = cloudDeployClient.createReleaseCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateReleaseRequest, Operation> createReleaseCallable() {
    return stub.createReleaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Abandons a Release in the Delivery Pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ReleaseName name =
   *       ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]");
   *   AbandonReleaseResponse response = cloudDeployClient.abandonRelease(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the Release. Format is
   *     `projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/releases/{release}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AbandonReleaseResponse abandonRelease(ReleaseName name) {
    AbandonReleaseRequest request =
        AbandonReleaseRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return abandonRelease(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Abandons a Release in the Delivery Pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name =
   *       ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]").toString();
   *   AbandonReleaseResponse response = cloudDeployClient.abandonRelease(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the Release. Format is
   *     `projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/releases/{release}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AbandonReleaseResponse abandonRelease(String name) {
    AbandonReleaseRequest request = AbandonReleaseRequest.newBuilder().setName(name).build();
    return abandonRelease(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Abandons a Release in the Delivery Pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   AbandonReleaseRequest request =
   *       AbandonReleaseRequest.newBuilder()
   *           .setName(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]")
   *                   .toString())
   *           .build();
   *   AbandonReleaseResponse response = cloudDeployClient.abandonRelease(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AbandonReleaseResponse abandonRelease(AbandonReleaseRequest request) {
    return abandonReleaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Abandons a Release in the Delivery Pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   AbandonReleaseRequest request =
   *       AbandonReleaseRequest.newBuilder()
   *           .setName(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<AbandonReleaseResponse> future =
   *       cloudDeployClient.abandonReleaseCallable().futureCall(request);
   *   // Do something.
   *   AbandonReleaseResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AbandonReleaseRequest, AbandonReleaseResponse>
      abandonReleaseCallable() {
    return stub.abandonReleaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   RolloutName name =
   *       RolloutName.of(
   *           "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]");
   *   ApproveRolloutResponse response = cloudDeployClient.approveRollout(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the Rollout. Format is
   *     `projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/releases/{release}/rollouts/{rollout}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApproveRolloutResponse approveRollout(RolloutName name) {
    ApproveRolloutRequest request =
        ApproveRolloutRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return approveRollout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name =
   *       RolloutName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]")
   *           .toString();
   *   ApproveRolloutResponse response = cloudDeployClient.approveRollout(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the Rollout. Format is
   *     `projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/releases/{release}/rollouts/{rollout}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApproveRolloutResponse approveRollout(String name) {
    ApproveRolloutRequest request = ApproveRolloutRequest.newBuilder().setName(name).build();
    return approveRollout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ApproveRolloutRequest request =
   *       ApproveRolloutRequest.newBuilder()
   *           .setName(
   *               RolloutName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]")
   *                   .toString())
   *           .setApproved(true)
   *           .build();
   *   ApproveRolloutResponse response = cloudDeployClient.approveRollout(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApproveRolloutResponse approveRollout(ApproveRolloutRequest request) {
    return approveRolloutCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ApproveRolloutRequest request =
   *       ApproveRolloutRequest.newBuilder()
   *           .setName(
   *               RolloutName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]")
   *                   .toString())
   *           .setApproved(true)
   *           .build();
   *   ApiFuture<ApproveRolloutResponse> future =
   *       cloudDeployClient.approveRolloutCallable().futureCall(request);
   *   // Do something.
   *   ApproveRolloutResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ApproveRolloutRequest, ApproveRolloutResponse>
      approveRolloutCallable() {
    return stub.approveRolloutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Advances a Rollout in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   RolloutName name =
   *       RolloutName.of(
   *           "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]");
   *   String phaseId = "phaseId-608264202";
   *   AdvanceRolloutResponse response = cloudDeployClient.advanceRollout(name, phaseId);
   * }
   * }</pre>
   *
   * @param name Required. Name of the Rollout. Format is
   *     `projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/releases/{release}/rollouts/{rollout}`.
   * @param phaseId Required. The phase ID to advance the `Rollout` to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdvanceRolloutResponse advanceRollout(RolloutName name, String phaseId) {
    AdvanceRolloutRequest request =
        AdvanceRolloutRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setPhaseId(phaseId)
            .build();
    return advanceRollout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Advances a Rollout in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name =
   *       RolloutName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]")
   *           .toString();
   *   String phaseId = "phaseId-608264202";
   *   AdvanceRolloutResponse response = cloudDeployClient.advanceRollout(name, phaseId);
   * }
   * }</pre>
   *
   * @param name Required. Name of the Rollout. Format is
   *     `projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/releases/{release}/rollouts/{rollout}`.
   * @param phaseId Required. The phase ID to advance the `Rollout` to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdvanceRolloutResponse advanceRollout(String name, String phaseId) {
    AdvanceRolloutRequest request =
        AdvanceRolloutRequest.newBuilder().setName(name).setPhaseId(phaseId).build();
    return advanceRollout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Advances a Rollout in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   AdvanceRolloutRequest request =
   *       AdvanceRolloutRequest.newBuilder()
   *           .setName(
   *               RolloutName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]")
   *                   .toString())
   *           .setPhaseId("phaseId-608264202")
   *           .build();
   *   AdvanceRolloutResponse response = cloudDeployClient.advanceRollout(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdvanceRolloutResponse advanceRollout(AdvanceRolloutRequest request) {
    return advanceRolloutCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Advances a Rollout in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   AdvanceRolloutRequest request =
   *       AdvanceRolloutRequest.newBuilder()
   *           .setName(
   *               RolloutName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]")
   *                   .toString())
   *           .setPhaseId("phaseId-608264202")
   *           .build();
   *   ApiFuture<AdvanceRolloutResponse> future =
   *       cloudDeployClient.advanceRolloutCallable().futureCall(request);
   *   // Do something.
   *   AdvanceRolloutResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AdvanceRolloutRequest, AdvanceRolloutResponse>
      advanceRolloutCallable() {
    return stub.advanceRolloutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a Rollout in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   RolloutName name =
   *       RolloutName.of(
   *           "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]");
   *   CancelRolloutResponse response = cloudDeployClient.cancelRollout(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the Rollout. Format is
   *     `projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/releases/{release}/rollouts/{rollout}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CancelRolloutResponse cancelRollout(RolloutName name) {
    CancelRolloutRequest request =
        CancelRolloutRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return cancelRollout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a Rollout in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name =
   *       RolloutName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]")
   *           .toString();
   *   CancelRolloutResponse response = cloudDeployClient.cancelRollout(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the Rollout. Format is
   *     `projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/releases/{release}/rollouts/{rollout}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CancelRolloutResponse cancelRollout(String name) {
    CancelRolloutRequest request = CancelRolloutRequest.newBuilder().setName(name).build();
    return cancelRollout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a Rollout in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CancelRolloutRequest request =
   *       CancelRolloutRequest.newBuilder()
   *           .setName(
   *               RolloutName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]")
   *                   .toString())
   *           .build();
   *   CancelRolloutResponse response = cloudDeployClient.cancelRollout(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CancelRolloutResponse cancelRollout(CancelRolloutRequest request) {
    return cancelRolloutCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a Rollout in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CancelRolloutRequest request =
   *       CancelRolloutRequest.newBuilder()
   *           .setName(
   *               RolloutName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CancelRolloutResponse> future =
   *       cloudDeployClient.cancelRolloutCallable().futureCall(request);
   *   // Do something.
   *   CancelRolloutResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CancelRolloutRequest, CancelRolloutResponse> cancelRolloutCallable() {
    return stub.cancelRolloutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Rollouts in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ReleaseName parent =
   *       ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]");
   *   for (Rollout element : cloudDeployClient.listRollouts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The `Release` which owns this collection of `Rollout` objects.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRolloutsPagedResponse listRollouts(ReleaseName parent) {
    ListRolloutsRequest request =
        ListRolloutsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRollouts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Rollouts in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String parent =
   *       ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]").toString();
   *   for (Rollout element : cloudDeployClient.listRollouts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The `Release` which owns this collection of `Rollout` objects.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRolloutsPagedResponse listRollouts(String parent) {
    ListRolloutsRequest request = ListRolloutsRequest.newBuilder().setParent(parent).build();
    return listRollouts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Rollouts in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListRolloutsRequest request =
   *       ListRolloutsRequest.newBuilder()
   *           .setParent(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Rollout element : cloudDeployClient.listRollouts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRolloutsPagedResponse listRollouts(ListRolloutsRequest request) {
    return listRolloutsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Rollouts in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListRolloutsRequest request =
   *       ListRolloutsRequest.newBuilder()
   *           .setParent(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Rollout> future = cloudDeployClient.listRolloutsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Rollout element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRolloutsRequest, ListRolloutsPagedResponse>
      listRolloutsPagedCallable() {
    return stub.listRolloutsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Rollouts in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListRolloutsRequest request =
   *       ListRolloutsRequest.newBuilder()
   *           .setParent(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListRolloutsResponse response = cloudDeployClient.listRolloutsCallable().call(request);
   *     for (Rollout element : response.getRolloutsList()) {
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
  public final UnaryCallable<ListRolloutsRequest, ListRolloutsResponse> listRolloutsCallable() {
    return stub.listRolloutsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   RolloutName name =
   *       RolloutName.of(
   *           "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]");
   *   Rollout response = cloudDeployClient.getRollout(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `Rollout`. Format must be
   *     `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/releases/{release_name}/rollouts/{rollout_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rollout getRollout(RolloutName name) {
    GetRolloutRequest request =
        GetRolloutRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRollout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name =
   *       RolloutName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]")
   *           .toString();
   *   Rollout response = cloudDeployClient.getRollout(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `Rollout`. Format must be
   *     `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/releases/{release_name}/rollouts/{rollout_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rollout getRollout(String name) {
    GetRolloutRequest request = GetRolloutRequest.newBuilder().setName(name).build();
    return getRollout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetRolloutRequest request =
   *       GetRolloutRequest.newBuilder()
   *           .setName(
   *               RolloutName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]")
   *                   .toString())
   *           .build();
   *   Rollout response = cloudDeployClient.getRollout(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rollout getRollout(GetRolloutRequest request) {
    return getRolloutCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetRolloutRequest request =
   *       GetRolloutRequest.newBuilder()
   *           .setName(
   *               RolloutName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Rollout> future = cloudDeployClient.getRolloutCallable().futureCall(request);
   *   // Do something.
   *   Rollout response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRolloutRequest, Rollout> getRolloutCallable() {
    return stub.getRolloutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Rollout in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ReleaseName parent =
   *       ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]");
   *   Rollout rollout = Rollout.newBuilder().build();
   *   String rolloutId = "rolloutId551248556";
   *   Rollout response = cloudDeployClient.createRolloutAsync(parent, rollout, rolloutId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which the `Rollout` should be created. Format
   *     should be
   *     `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/releases/{release_name}`.
   * @param rollout Required. The `Rollout` to create.
   * @param rolloutId Required. ID of the `Rollout`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Rollout, OperationMetadata> createRolloutAsync(
      ReleaseName parent, Rollout rollout, String rolloutId) {
    CreateRolloutRequest request =
        CreateRolloutRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRollout(rollout)
            .setRolloutId(rolloutId)
            .build();
    return createRolloutAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Rollout in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String parent =
   *       ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]").toString();
   *   Rollout rollout = Rollout.newBuilder().build();
   *   String rolloutId = "rolloutId551248556";
   *   Rollout response = cloudDeployClient.createRolloutAsync(parent, rollout, rolloutId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which the `Rollout` should be created. Format
   *     should be
   *     `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/releases/{release_name}`.
   * @param rollout Required. The `Rollout` to create.
   * @param rolloutId Required. ID of the `Rollout`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Rollout, OperationMetadata> createRolloutAsync(
      String parent, Rollout rollout, String rolloutId) {
    CreateRolloutRequest request =
        CreateRolloutRequest.newBuilder()
            .setParent(parent)
            .setRollout(rollout)
            .setRolloutId(rolloutId)
            .build();
    return createRolloutAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Rollout in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateRolloutRequest request =
   *       CreateRolloutRequest.newBuilder()
   *           .setParent(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]")
   *                   .toString())
   *           .setRolloutId("rolloutId551248556")
   *           .setRollout(Rollout.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setStartingPhaseId("startingPhaseId-326529130")
   *           .build();
   *   Rollout response = cloudDeployClient.createRolloutAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Rollout, OperationMetadata> createRolloutAsync(
      CreateRolloutRequest request) {
    return createRolloutOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Rollout in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateRolloutRequest request =
   *       CreateRolloutRequest.newBuilder()
   *           .setParent(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]")
   *                   .toString())
   *           .setRolloutId("rolloutId551248556")
   *           .setRollout(Rollout.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setStartingPhaseId("startingPhaseId-326529130")
   *           .build();
   *   OperationFuture<Rollout, OperationMetadata> future =
   *       cloudDeployClient.createRolloutOperationCallable().futureCall(request);
   *   // Do something.
   *   Rollout response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateRolloutRequest, Rollout, OperationMetadata>
      createRolloutOperationCallable() {
    return stub.createRolloutOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Rollout in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateRolloutRequest request =
   *       CreateRolloutRequest.newBuilder()
   *           .setParent(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]")
   *                   .toString())
   *           .setRolloutId("rolloutId551248556")
   *           .setRollout(Rollout.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setStartingPhaseId("startingPhaseId-326529130")
   *           .build();
   *   ApiFuture<Operation> future = cloudDeployClient.createRolloutCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRolloutRequest, Operation> createRolloutCallable() {
    return stub.createRolloutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Ignores the specified Job in a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   RolloutName rollout =
   *       RolloutName.of(
   *           "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]");
   *   String phaseId = "phaseId-608264202";
   *   String jobId = "jobId101296568";
   *   IgnoreJobResponse response = cloudDeployClient.ignoreJob(rollout, phaseId, jobId);
   * }
   * }</pre>
   *
   * @param rollout Required. Name of the Rollout. Format is
   *     `projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/releases/{release}/rollouts/{rollout}`.
   * @param phaseId Required. The phase ID the Job to ignore belongs to.
   * @param jobId Required. The job ID for the Job to ignore.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IgnoreJobResponse ignoreJob(RolloutName rollout, String phaseId, String jobId) {
    IgnoreJobRequest request =
        IgnoreJobRequest.newBuilder()
            .setRollout(rollout == null ? null : rollout.toString())
            .setPhaseId(phaseId)
            .setJobId(jobId)
            .build();
    return ignoreJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Ignores the specified Job in a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String rollout =
   *       RolloutName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]")
   *           .toString();
   *   String phaseId = "phaseId-608264202";
   *   String jobId = "jobId101296568";
   *   IgnoreJobResponse response = cloudDeployClient.ignoreJob(rollout, phaseId, jobId);
   * }
   * }</pre>
   *
   * @param rollout Required. Name of the Rollout. Format is
   *     `projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/releases/{release}/rollouts/{rollout}`.
   * @param phaseId Required. The phase ID the Job to ignore belongs to.
   * @param jobId Required. The job ID for the Job to ignore.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IgnoreJobResponse ignoreJob(String rollout, String phaseId, String jobId) {
    IgnoreJobRequest request =
        IgnoreJobRequest.newBuilder()
            .setRollout(rollout)
            .setPhaseId(phaseId)
            .setJobId(jobId)
            .build();
    return ignoreJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Ignores the specified Job in a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   IgnoreJobRequest request =
   *       IgnoreJobRequest.newBuilder()
   *           .setRollout(
   *               RolloutName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]")
   *                   .toString())
   *           .setPhaseId("phaseId-608264202")
   *           .setJobId("jobId101296568")
   *           .build();
   *   IgnoreJobResponse response = cloudDeployClient.ignoreJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IgnoreJobResponse ignoreJob(IgnoreJobRequest request) {
    return ignoreJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Ignores the specified Job in a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   IgnoreJobRequest request =
   *       IgnoreJobRequest.newBuilder()
   *           .setRollout(
   *               RolloutName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]")
   *                   .toString())
   *           .setPhaseId("phaseId-608264202")
   *           .setJobId("jobId101296568")
   *           .build();
   *   ApiFuture<IgnoreJobResponse> future =
   *       cloudDeployClient.ignoreJobCallable().futureCall(request);
   *   // Do something.
   *   IgnoreJobResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<IgnoreJobRequest, IgnoreJobResponse> ignoreJobCallable() {
    return stub.ignoreJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retries the specified Job in a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   RolloutName rollout =
   *       RolloutName.of(
   *           "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]");
   *   String phaseId = "phaseId-608264202";
   *   String jobId = "jobId101296568";
   *   RetryJobResponse response = cloudDeployClient.retryJob(rollout, phaseId, jobId);
   * }
   * }</pre>
   *
   * @param rollout Required. Name of the Rollout. Format is
   *     `projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/releases/{release}/rollouts/{rollout}`.
   * @param phaseId Required. The phase ID the Job to retry belongs to.
   * @param jobId Required. The job ID for the Job to retry.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetryJobResponse retryJob(RolloutName rollout, String phaseId, String jobId) {
    RetryJobRequest request =
        RetryJobRequest.newBuilder()
            .setRollout(rollout == null ? null : rollout.toString())
            .setPhaseId(phaseId)
            .setJobId(jobId)
            .build();
    return retryJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retries the specified Job in a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String rollout =
   *       RolloutName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]")
   *           .toString();
   *   String phaseId = "phaseId-608264202";
   *   String jobId = "jobId101296568";
   *   RetryJobResponse response = cloudDeployClient.retryJob(rollout, phaseId, jobId);
   * }
   * }</pre>
   *
   * @param rollout Required. Name of the Rollout. Format is
   *     `projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/releases/{release}/rollouts/{rollout}`.
   * @param phaseId Required. The phase ID the Job to retry belongs to.
   * @param jobId Required. The job ID for the Job to retry.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetryJobResponse retryJob(String rollout, String phaseId, String jobId) {
    RetryJobRequest request =
        RetryJobRequest.newBuilder()
            .setRollout(rollout)
            .setPhaseId(phaseId)
            .setJobId(jobId)
            .build();
    return retryJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retries the specified Job in a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   RetryJobRequest request =
   *       RetryJobRequest.newBuilder()
   *           .setRollout(
   *               RolloutName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]")
   *                   .toString())
   *           .setPhaseId("phaseId-608264202")
   *           .setJobId("jobId101296568")
   *           .build();
   *   RetryJobResponse response = cloudDeployClient.retryJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetryJobResponse retryJob(RetryJobRequest request) {
    return retryJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retries the specified Job in a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   RetryJobRequest request =
   *       RetryJobRequest.newBuilder()
   *           .setRollout(
   *               RolloutName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]")
   *                   .toString())
   *           .setPhaseId("phaseId-608264202")
   *           .setJobId("jobId101296568")
   *           .build();
   *   ApiFuture<RetryJobResponse> future = cloudDeployClient.retryJobCallable().futureCall(request);
   *   // Do something.
   *   RetryJobResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RetryJobRequest, RetryJobResponse> retryJobCallable() {
    return stub.retryJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists JobRuns in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   RolloutName parent =
   *       RolloutName.of(
   *           "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]");
   *   for (JobRun element : cloudDeployClient.listJobRuns(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The `Rollout` which owns this collection of `JobRun` objects.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobRunsPagedResponse listJobRuns(RolloutName parent) {
    ListJobRunsRequest request =
        ListJobRunsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listJobRuns(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists JobRuns in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String parent =
   *       RolloutName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]")
   *           .toString();
   *   for (JobRun element : cloudDeployClient.listJobRuns(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The `Rollout` which owns this collection of `JobRun` objects.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobRunsPagedResponse listJobRuns(String parent) {
    ListJobRunsRequest request = ListJobRunsRequest.newBuilder().setParent(parent).build();
    return listJobRuns(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists JobRuns in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListJobRunsRequest request =
   *       ListJobRunsRequest.newBuilder()
   *           .setParent(
   *               RolloutName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (JobRun element : cloudDeployClient.listJobRuns(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobRunsPagedResponse listJobRuns(ListJobRunsRequest request) {
    return listJobRunsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists JobRuns in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListJobRunsRequest request =
   *       ListJobRunsRequest.newBuilder()
   *           .setParent(
   *               RolloutName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<JobRun> future = cloudDeployClient.listJobRunsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (JobRun element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListJobRunsRequest, ListJobRunsPagedResponse>
      listJobRunsPagedCallable() {
    return stub.listJobRunsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists JobRuns in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListJobRunsRequest request =
   *       ListJobRunsRequest.newBuilder()
   *           .setParent(
   *               RolloutName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListJobRunsResponse response = cloudDeployClient.listJobRunsCallable().call(request);
   *     for (JobRun element : response.getJobRunsList()) {
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
  public final UnaryCallable<ListJobRunsRequest, ListJobRunsResponse> listJobRunsCallable() {
    return stub.listJobRunsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single JobRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   JobRunName name =
   *       JobRunName.of(
   *           "[PROJECT]",
   *           "[LOCATION]",
   *           "[DELIVERY_PIPELINE]",
   *           "[RELEASE]",
   *           "[ROLLOUT]",
   *           "[JOB_RUN]");
   *   JobRun response = cloudDeployClient.getJobRun(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `JobRun`. Format must be
   *     `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/releases/{release_name}/rollouts/{rollout_name}/jobRuns/{job_run_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobRun getJobRun(JobRunName name) {
    GetJobRunRequest request =
        GetJobRunRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getJobRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single JobRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name =
   *       JobRunName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[DELIVERY_PIPELINE]",
   *               "[RELEASE]",
   *               "[ROLLOUT]",
   *               "[JOB_RUN]")
   *           .toString();
   *   JobRun response = cloudDeployClient.getJobRun(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `JobRun`. Format must be
   *     `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/releases/{release_name}/rollouts/{rollout_name}/jobRuns/{job_run_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobRun getJobRun(String name) {
    GetJobRunRequest request = GetJobRunRequest.newBuilder().setName(name).build();
    return getJobRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single JobRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetJobRunRequest request =
   *       GetJobRunRequest.newBuilder()
   *           .setName(
   *               JobRunName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]",
   *                       "[JOB_RUN]")
   *                   .toString())
   *           .build();
   *   JobRun response = cloudDeployClient.getJobRun(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobRun getJobRun(GetJobRunRequest request) {
    return getJobRunCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single JobRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetJobRunRequest request =
   *       GetJobRunRequest.newBuilder()
   *           .setName(
   *               JobRunName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]",
   *                       "[JOB_RUN]")
   *                   .toString())
   *           .build();
   *   ApiFuture<JobRun> future = cloudDeployClient.getJobRunCallable().futureCall(request);
   *   // Do something.
   *   JobRun response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetJobRunRequest, JobRun> getJobRunCallable() {
    return stub.getJobRunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Terminates a Job Run in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   JobRunName name =
   *       JobRunName.of(
   *           "[PROJECT]",
   *           "[LOCATION]",
   *           "[DELIVERY_PIPELINE]",
   *           "[RELEASE]",
   *           "[ROLLOUT]",
   *           "[JOB_RUN]");
   *   TerminateJobRunResponse response = cloudDeployClient.terminateJobRun(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `JobRun`. Format must be
   *     `projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/releases/{release}/rollouts/{rollout}/jobRuns/{jobRun}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TerminateJobRunResponse terminateJobRun(JobRunName name) {
    TerminateJobRunRequest request =
        TerminateJobRunRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return terminateJobRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Terminates a Job Run in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name =
   *       JobRunName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[DELIVERY_PIPELINE]",
   *               "[RELEASE]",
   *               "[ROLLOUT]",
   *               "[JOB_RUN]")
   *           .toString();
   *   TerminateJobRunResponse response = cloudDeployClient.terminateJobRun(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `JobRun`. Format must be
   *     `projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/releases/{release}/rollouts/{rollout}/jobRuns/{jobRun}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TerminateJobRunResponse terminateJobRun(String name) {
    TerminateJobRunRequest request = TerminateJobRunRequest.newBuilder().setName(name).build();
    return terminateJobRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Terminates a Job Run in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   TerminateJobRunRequest request =
   *       TerminateJobRunRequest.newBuilder()
   *           .setName(
   *               JobRunName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]",
   *                       "[JOB_RUN]")
   *                   .toString())
   *           .build();
   *   TerminateJobRunResponse response = cloudDeployClient.terminateJobRun(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TerminateJobRunResponse terminateJobRun(TerminateJobRunRequest request) {
    return terminateJobRunCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Terminates a Job Run in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   TerminateJobRunRequest request =
   *       TerminateJobRunRequest.newBuilder()
   *           .setName(
   *               JobRunName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]",
   *                       "[JOB_RUN]")
   *                   .toString())
   *           .build();
   *   ApiFuture<TerminateJobRunResponse> future =
   *       cloudDeployClient.terminateJobRunCallable().futureCall(request);
   *   // Do something.
   *   TerminateJobRunResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TerminateJobRunRequest, TerminateJobRunResponse>
      terminateJobRunCallable() {
    return stub.terminateJobRunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the configuration for a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ConfigName name = ConfigName.of("[PROJECT]", "[LOCATION]");
   *   Config response = cloudDeployClient.getConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of requested configuration.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Config getConfig(ConfigName name) {
    GetConfigRequest request =
        GetConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the configuration for a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name = ConfigName.of("[PROJECT]", "[LOCATION]").toString();
   *   Config response = cloudDeployClient.getConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of requested configuration.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Config getConfig(String name) {
    GetConfigRequest request = GetConfigRequest.newBuilder().setName(name).build();
    return getConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the configuration for a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetConfigRequest request =
   *       GetConfigRequest.newBuilder()
   *           .setName(ConfigName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   Config response = cloudDeployClient.getConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Config getConfig(GetConfigRequest request) {
    return getConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the configuration for a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetConfigRequest request =
   *       GetConfigRequest.newBuilder()
   *           .setName(ConfigName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<Config> future = cloudDeployClient.getConfigCallable().futureCall(request);
   *   // Do something.
   *   Config response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConfigRequest, Config> getConfigCallable() {
    return stub.getConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Automation in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeliveryPipelineName parent =
   *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]");
   *   Automation automation = Automation.newBuilder().build();
   *   String automationId = "automationId64173202";
   *   Automation response =
   *       cloudDeployClient.createAutomationAsync(parent, automation, automationId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which the `Automation` should be created.
   *     Format should be
   *     `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}`.
   * @param automation Required. The `Automation` to create.
   * @param automationId Required. ID of the `Automation`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Automation, OperationMetadata> createAutomationAsync(
      DeliveryPipelineName parent, Automation automation, String automationId) {
    CreateAutomationRequest request =
        CreateAutomationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAutomation(automation)
            .setAutomationId(automationId)
            .build();
    return createAutomationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Automation in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String parent =
   *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]").toString();
   *   Automation automation = Automation.newBuilder().build();
   *   String automationId = "automationId64173202";
   *   Automation response =
   *       cloudDeployClient.createAutomationAsync(parent, automation, automationId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which the `Automation` should be created.
   *     Format should be
   *     `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}`.
   * @param automation Required. The `Automation` to create.
   * @param automationId Required. ID of the `Automation`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Automation, OperationMetadata> createAutomationAsync(
      String parent, Automation automation, String automationId) {
    CreateAutomationRequest request =
        CreateAutomationRequest.newBuilder()
            .setParent(parent)
            .setAutomation(automation)
            .setAutomationId(automationId)
            .build();
    return createAutomationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Automation in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateAutomationRequest request =
   *       CreateAutomationRequest.newBuilder()
   *           .setParent(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setAutomationId("automationId64173202")
   *           .setAutomation(Automation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   Automation response = cloudDeployClient.createAutomationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Automation, OperationMetadata> createAutomationAsync(
      CreateAutomationRequest request) {
    return createAutomationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Automation in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateAutomationRequest request =
   *       CreateAutomationRequest.newBuilder()
   *           .setParent(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setAutomationId("automationId64173202")
   *           .setAutomation(Automation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Automation, OperationMetadata> future =
   *       cloudDeployClient.createAutomationOperationCallable().futureCall(request);
   *   // Do something.
   *   Automation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateAutomationRequest, Automation, OperationMetadata>
      createAutomationOperationCallable() {
    return stub.createAutomationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Automation in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateAutomationRequest request =
   *       CreateAutomationRequest.newBuilder()
   *           .setParent(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setAutomationId("automationId64173202")
   *           .setAutomation(Automation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudDeployClient.createAutomationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAutomationRequest, Operation> createAutomationCallable() {
    return stub.createAutomationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Automation resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   Automation automation = Automation.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Automation response = cloudDeployClient.updateAutomationAsync(automation, updateMask).get();
   * }
   * }</pre>
   *
   * @param automation Required. The `Automation` to update.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     `Automation` resource by the update. The fields specified in the update_mask are relative
   *     to the resource, not the full request. A field will be overwritten if it's in the mask. If
   *     the user doesn't provide a mask then all fields are overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Automation, OperationMetadata> updateAutomationAsync(
      Automation automation, FieldMask updateMask) {
    UpdateAutomationRequest request =
        UpdateAutomationRequest.newBuilder()
            .setAutomation(automation)
            .setUpdateMask(updateMask)
            .build();
    return updateAutomationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Automation resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   UpdateAutomationRequest request =
   *       UpdateAutomationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAutomation(Automation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   Automation response = cloudDeployClient.updateAutomationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Automation, OperationMetadata> updateAutomationAsync(
      UpdateAutomationRequest request) {
    return updateAutomationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Automation resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   UpdateAutomationRequest request =
   *       UpdateAutomationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAutomation(Automation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Automation, OperationMetadata> future =
   *       cloudDeployClient.updateAutomationOperationCallable().futureCall(request);
   *   // Do something.
   *   Automation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateAutomationRequest, Automation, OperationMetadata>
      updateAutomationOperationCallable() {
    return stub.updateAutomationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Automation resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   UpdateAutomationRequest request =
   *       UpdateAutomationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAutomation(Automation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudDeployClient.updateAutomationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAutomationRequest, Operation> updateAutomationCallable() {
    return stub.updateAutomationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Automation resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   AutomationName name =
   *       AutomationName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[AUTOMATION]");
   *   cloudDeployClient.deleteAutomationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `Automation` to delete. Format should be
   *     `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/automations/{automation_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAutomationAsync(
      AutomationName name) {
    DeleteAutomationRequest request =
        DeleteAutomationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteAutomationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Automation resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name =
   *       AutomationName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[AUTOMATION]")
   *           .toString();
   *   cloudDeployClient.deleteAutomationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `Automation` to delete. Format should be
   *     `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/automations/{automation_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAutomationAsync(String name) {
    DeleteAutomationRequest request = DeleteAutomationRequest.newBuilder().setName(name).build();
    return deleteAutomationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Automation resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeleteAutomationRequest request =
   *       DeleteAutomationRequest.newBuilder()
   *           .setName(
   *               AutomationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[AUTOMATION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   cloudDeployClient.deleteAutomationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAutomationAsync(
      DeleteAutomationRequest request) {
    return deleteAutomationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Automation resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeleteAutomationRequest request =
   *       DeleteAutomationRequest.newBuilder()
   *           .setName(
   *               AutomationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[AUTOMATION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       cloudDeployClient.deleteAutomationOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteAutomationRequest, Empty, OperationMetadata>
      deleteAutomationOperationCallable() {
    return stub.deleteAutomationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Automation resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeleteAutomationRequest request =
   *       DeleteAutomationRequest.newBuilder()
   *           .setName(
   *               AutomationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[AUTOMATION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudDeployClient.deleteAutomationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAutomationRequest, Operation> deleteAutomationCallable() {
    return stub.deleteAutomationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Automation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   AutomationName name =
   *       AutomationName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[AUTOMATION]");
   *   Automation response = cloudDeployClient.getAutomation(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `Automation`. Format must be
   *     `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/automations/{automation_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Automation getAutomation(AutomationName name) {
    GetAutomationRequest request =
        GetAutomationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAutomation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Automation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name =
   *       AutomationName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[AUTOMATION]")
   *           .toString();
   *   Automation response = cloudDeployClient.getAutomation(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `Automation`. Format must be
   *     `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/automations/{automation_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Automation getAutomation(String name) {
    GetAutomationRequest request = GetAutomationRequest.newBuilder().setName(name).build();
    return getAutomation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Automation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetAutomationRequest request =
   *       GetAutomationRequest.newBuilder()
   *           .setName(
   *               AutomationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[AUTOMATION]")
   *                   .toString())
   *           .build();
   *   Automation response = cloudDeployClient.getAutomation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Automation getAutomation(GetAutomationRequest request) {
    return getAutomationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Automation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetAutomationRequest request =
   *       GetAutomationRequest.newBuilder()
   *           .setName(
   *               AutomationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[AUTOMATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Automation> future = cloudDeployClient.getAutomationCallable().futureCall(request);
   *   // Do something.
   *   Automation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAutomationRequest, Automation> getAutomationCallable() {
    return stub.getAutomationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Automations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeliveryPipelineName parent =
   *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]");
   *   for (Automation element : cloudDeployClient.listAutomations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent `Delivery Pipeline`, which owns this collection of
   *     automations. Format must be
   *     `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutomationsPagedResponse listAutomations(DeliveryPipelineName parent) {
    ListAutomationsRequest request =
        ListAutomationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAutomations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Automations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String parent =
   *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]").toString();
   *   for (Automation element : cloudDeployClient.listAutomations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent `Delivery Pipeline`, which owns this collection of
   *     automations. Format must be
   *     `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutomationsPagedResponse listAutomations(String parent) {
    ListAutomationsRequest request = ListAutomationsRequest.newBuilder().setParent(parent).build();
    return listAutomations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Automations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListAutomationsRequest request =
   *       ListAutomationsRequest.newBuilder()
   *           .setParent(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Automation element : cloudDeployClient.listAutomations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutomationsPagedResponse listAutomations(ListAutomationsRequest request) {
    return listAutomationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Automations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListAutomationsRequest request =
   *       ListAutomationsRequest.newBuilder()
   *           .setParent(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Automation> future =
   *       cloudDeployClient.listAutomationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Automation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAutomationsRequest, ListAutomationsPagedResponse>
      listAutomationsPagedCallable() {
    return stub.listAutomationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Automations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListAutomationsRequest request =
   *       ListAutomationsRequest.newBuilder()
   *           .setParent(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListAutomationsResponse response =
   *         cloudDeployClient.listAutomationsCallable().call(request);
   *     for (Automation element : response.getAutomationsList()) {
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
  public final UnaryCallable<ListAutomationsRequest, ListAutomationsResponse>
      listAutomationsCallable() {
    return stub.listAutomationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AutomationRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   AutomationRunName name =
   *       AutomationRunName.of(
   *           "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[AUTOMATION_RUN]");
   *   AutomationRun response = cloudDeployClient.getAutomationRun(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `AutomationRun`. Format must be
   *     `projects/{project}/locations/{location}/deliveryPipelines/{delivery_pipeline}/automationRuns/{automation_run}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutomationRun getAutomationRun(AutomationRunName name) {
    GetAutomationRunRequest request =
        GetAutomationRunRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAutomationRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AutomationRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name =
   *       AutomationRunName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[AUTOMATION_RUN]")
   *           .toString();
   *   AutomationRun response = cloudDeployClient.getAutomationRun(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `AutomationRun`. Format must be
   *     `projects/{project}/locations/{location}/deliveryPipelines/{delivery_pipeline}/automationRuns/{automation_run}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutomationRun getAutomationRun(String name) {
    GetAutomationRunRequest request = GetAutomationRunRequest.newBuilder().setName(name).build();
    return getAutomationRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AutomationRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetAutomationRunRequest request =
   *       GetAutomationRunRequest.newBuilder()
   *           .setName(
   *               AutomationRunName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[AUTOMATION_RUN]")
   *                   .toString())
   *           .build();
   *   AutomationRun response = cloudDeployClient.getAutomationRun(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutomationRun getAutomationRun(GetAutomationRunRequest request) {
    return getAutomationRunCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AutomationRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetAutomationRunRequest request =
   *       GetAutomationRunRequest.newBuilder()
   *           .setName(
   *               AutomationRunName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[AUTOMATION_RUN]")
   *                   .toString())
   *           .build();
   *   ApiFuture<AutomationRun> future =
   *       cloudDeployClient.getAutomationRunCallable().futureCall(request);
   *   // Do something.
   *   AutomationRun response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAutomationRunRequest, AutomationRun> getAutomationRunCallable() {
    return stub.getAutomationRunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AutomationRuns in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeliveryPipelineName parent =
   *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]");
   *   for (AutomationRun element : cloudDeployClient.listAutomationRuns(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent `Delivery Pipeline`, which owns this collection of
   *     automationRuns. Format must be
   *     `projects/{project}/locations/{location}/deliveryPipelines/{delivery_pipeline}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutomationRunsPagedResponse listAutomationRuns(DeliveryPipelineName parent) {
    ListAutomationRunsRequest request =
        ListAutomationRunsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAutomationRuns(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AutomationRuns in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String parent =
   *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]").toString();
   *   for (AutomationRun element : cloudDeployClient.listAutomationRuns(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent `Delivery Pipeline`, which owns this collection of
   *     automationRuns. Format must be
   *     `projects/{project}/locations/{location}/deliveryPipelines/{delivery_pipeline}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutomationRunsPagedResponse listAutomationRuns(String parent) {
    ListAutomationRunsRequest request =
        ListAutomationRunsRequest.newBuilder().setParent(parent).build();
    return listAutomationRuns(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AutomationRuns in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListAutomationRunsRequest request =
   *       ListAutomationRunsRequest.newBuilder()
   *           .setParent(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (AutomationRun element : cloudDeployClient.listAutomationRuns(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutomationRunsPagedResponse listAutomationRuns(
      ListAutomationRunsRequest request) {
    return listAutomationRunsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AutomationRuns in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListAutomationRunsRequest request =
   *       ListAutomationRunsRequest.newBuilder()
   *           .setParent(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<AutomationRun> future =
   *       cloudDeployClient.listAutomationRunsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AutomationRun element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAutomationRunsRequest, ListAutomationRunsPagedResponse>
      listAutomationRunsPagedCallable() {
    return stub.listAutomationRunsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AutomationRuns in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListAutomationRunsRequest request =
   *       ListAutomationRunsRequest.newBuilder()
   *           .setParent(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListAutomationRunsResponse response =
   *         cloudDeployClient.listAutomationRunsCallable().call(request);
   *     for (AutomationRun element : response.getAutomationRunsList()) {
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
  public final UnaryCallable<ListAutomationRunsRequest, ListAutomationRunsResponse>
      listAutomationRunsCallable() {
    return stub.listAutomationRunsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels an AutomationRun. The `state` of the `AutomationRun` after cancelling is `CANCELLED`.
   * `CancelAutomationRun` can be called on AutomationRun in the state `IN_PROGRESS` and `PENDING`;
   * AutomationRun in a different state returns an `FAILED_PRECONDITION` error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   AutomationRunName name =
   *       AutomationRunName.of(
   *           "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[AUTOMATION_RUN]");
   *   CancelAutomationRunResponse response = cloudDeployClient.cancelAutomationRun(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `AutomationRun`. Format is
   *     `projects/{project}/locations/{location}/deliveryPipelines/{delivery_pipeline}/automationRuns/{automation_run}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CancelAutomationRunResponse cancelAutomationRun(AutomationRunName name) {
    CancelAutomationRunRequest request =
        CancelAutomationRunRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return cancelAutomationRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels an AutomationRun. The `state` of the `AutomationRun` after cancelling is `CANCELLED`.
   * `CancelAutomationRun` can be called on AutomationRun in the state `IN_PROGRESS` and `PENDING`;
   * AutomationRun in a different state returns an `FAILED_PRECONDITION` error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name =
   *       AutomationRunName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[AUTOMATION_RUN]")
   *           .toString();
   *   CancelAutomationRunResponse response = cloudDeployClient.cancelAutomationRun(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `AutomationRun`. Format is
   *     `projects/{project}/locations/{location}/deliveryPipelines/{delivery_pipeline}/automationRuns/{automation_run}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CancelAutomationRunResponse cancelAutomationRun(String name) {
    CancelAutomationRunRequest request =
        CancelAutomationRunRequest.newBuilder().setName(name).build();
    return cancelAutomationRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels an AutomationRun. The `state` of the `AutomationRun` after cancelling is `CANCELLED`.
   * `CancelAutomationRun` can be called on AutomationRun in the state `IN_PROGRESS` and `PENDING`;
   * AutomationRun in a different state returns an `FAILED_PRECONDITION` error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CancelAutomationRunRequest request =
   *       CancelAutomationRunRequest.newBuilder()
   *           .setName(
   *               AutomationRunName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[AUTOMATION_RUN]")
   *                   .toString())
   *           .build();
   *   CancelAutomationRunResponse response = cloudDeployClient.cancelAutomationRun(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CancelAutomationRunResponse cancelAutomationRun(CancelAutomationRunRequest request) {
    return cancelAutomationRunCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels an AutomationRun. The `state` of the `AutomationRun` after cancelling is `CANCELLED`.
   * `CancelAutomationRun` can be called on AutomationRun in the state `IN_PROGRESS` and `PENDING`;
   * AutomationRun in a different state returns an `FAILED_PRECONDITION` error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CancelAutomationRunRequest request =
   *       CancelAutomationRunRequest.newBuilder()
   *           .setName(
   *               AutomationRunName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[AUTOMATION_RUN]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CancelAutomationRunResponse> future =
   *       cloudDeployClient.cancelAutomationRunCallable().futureCall(request);
   *   // Do something.
   *   CancelAutomationRunResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CancelAutomationRunRequest, CancelAutomationRunResponse>
      cancelAutomationRunCallable() {
    return stub.cancelAutomationRunCallable();
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
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : cloudDeployClient.listLocations(request).iterateAll()) {
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
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       cloudDeployClient.listLocationsPagedCallable().futureCall(request);
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
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = cloudDeployClient.listLocationsCallable().call(request);
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
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = cloudDeployClient.getLocation(request);
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
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = cloudDeployClient.getLocationCallable().futureCall(request);
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
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               CustomTargetTypeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_TARGET_TYPE]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = cloudDeployClient.setIamPolicy(request);
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
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               CustomTargetTypeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_TARGET_TYPE]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = cloudDeployClient.setIamPolicyCallable().futureCall(request);
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
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               CustomTargetTypeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_TARGET_TYPE]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = cloudDeployClient.getIamPolicy(request);
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
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               CustomTargetTypeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_TARGET_TYPE]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = cloudDeployClient.getIamPolicyCallable().futureCall(request);
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
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = cloudDeployClient.testIamPermissions(request);
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
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       cloudDeployClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListDeliveryPipelinesPagedResponse
      extends AbstractPagedListResponse<
          ListDeliveryPipelinesRequest,
          ListDeliveryPipelinesResponse,
          DeliveryPipeline,
          ListDeliveryPipelinesPage,
          ListDeliveryPipelinesFixedSizeCollection> {

    public static ApiFuture<ListDeliveryPipelinesPagedResponse> createAsync(
        PageContext<ListDeliveryPipelinesRequest, ListDeliveryPipelinesResponse, DeliveryPipeline>
            context,
        ApiFuture<ListDeliveryPipelinesResponse> futureResponse) {
      ApiFuture<ListDeliveryPipelinesPage> futurePage =
          ListDeliveryPipelinesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDeliveryPipelinesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDeliveryPipelinesPagedResponse(ListDeliveryPipelinesPage page) {
      super(page, ListDeliveryPipelinesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDeliveryPipelinesPage
      extends AbstractPage<
          ListDeliveryPipelinesRequest,
          ListDeliveryPipelinesResponse,
          DeliveryPipeline,
          ListDeliveryPipelinesPage> {

    private ListDeliveryPipelinesPage(
        PageContext<ListDeliveryPipelinesRequest, ListDeliveryPipelinesResponse, DeliveryPipeline>
            context,
        ListDeliveryPipelinesResponse response) {
      super(context, response);
    }

    private static ListDeliveryPipelinesPage createEmptyPage() {
      return new ListDeliveryPipelinesPage(null, null);
    }

    @Override
    protected ListDeliveryPipelinesPage createPage(
        PageContext<ListDeliveryPipelinesRequest, ListDeliveryPipelinesResponse, DeliveryPipeline>
            context,
        ListDeliveryPipelinesResponse response) {
      return new ListDeliveryPipelinesPage(context, response);
    }

    @Override
    public ApiFuture<ListDeliveryPipelinesPage> createPageAsync(
        PageContext<ListDeliveryPipelinesRequest, ListDeliveryPipelinesResponse, DeliveryPipeline>
            context,
        ApiFuture<ListDeliveryPipelinesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDeliveryPipelinesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDeliveryPipelinesRequest,
          ListDeliveryPipelinesResponse,
          DeliveryPipeline,
          ListDeliveryPipelinesPage,
          ListDeliveryPipelinesFixedSizeCollection> {

    private ListDeliveryPipelinesFixedSizeCollection(
        List<ListDeliveryPipelinesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDeliveryPipelinesFixedSizeCollection createEmptyCollection() {
      return new ListDeliveryPipelinesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDeliveryPipelinesFixedSizeCollection createCollection(
        List<ListDeliveryPipelinesPage> pages, int collectionSize) {
      return new ListDeliveryPipelinesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTargetsPagedResponse
      extends AbstractPagedListResponse<
          ListTargetsRequest,
          ListTargetsResponse,
          Target,
          ListTargetsPage,
          ListTargetsFixedSizeCollection> {

    public static ApiFuture<ListTargetsPagedResponse> createAsync(
        PageContext<ListTargetsRequest, ListTargetsResponse, Target> context,
        ApiFuture<ListTargetsResponse> futureResponse) {
      ApiFuture<ListTargetsPage> futurePage =
          ListTargetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListTargetsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListTargetsPagedResponse(ListTargetsPage page) {
      super(page, ListTargetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTargetsPage
      extends AbstractPage<ListTargetsRequest, ListTargetsResponse, Target, ListTargetsPage> {

    private ListTargetsPage(
        PageContext<ListTargetsRequest, ListTargetsResponse, Target> context,
        ListTargetsResponse response) {
      super(context, response);
    }

    private static ListTargetsPage createEmptyPage() {
      return new ListTargetsPage(null, null);
    }

    @Override
    protected ListTargetsPage createPage(
        PageContext<ListTargetsRequest, ListTargetsResponse, Target> context,
        ListTargetsResponse response) {
      return new ListTargetsPage(context, response);
    }

    @Override
    public ApiFuture<ListTargetsPage> createPageAsync(
        PageContext<ListTargetsRequest, ListTargetsResponse, Target> context,
        ApiFuture<ListTargetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTargetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTargetsRequest,
          ListTargetsResponse,
          Target,
          ListTargetsPage,
          ListTargetsFixedSizeCollection> {

    private ListTargetsFixedSizeCollection(List<ListTargetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTargetsFixedSizeCollection createEmptyCollection() {
      return new ListTargetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTargetsFixedSizeCollection createCollection(
        List<ListTargetsPage> pages, int collectionSize) {
      return new ListTargetsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCustomTargetTypesPagedResponse
      extends AbstractPagedListResponse<
          ListCustomTargetTypesRequest,
          ListCustomTargetTypesResponse,
          CustomTargetType,
          ListCustomTargetTypesPage,
          ListCustomTargetTypesFixedSizeCollection> {

    public static ApiFuture<ListCustomTargetTypesPagedResponse> createAsync(
        PageContext<ListCustomTargetTypesRequest, ListCustomTargetTypesResponse, CustomTargetType>
            context,
        ApiFuture<ListCustomTargetTypesResponse> futureResponse) {
      ApiFuture<ListCustomTargetTypesPage> futurePage =
          ListCustomTargetTypesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCustomTargetTypesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCustomTargetTypesPagedResponse(ListCustomTargetTypesPage page) {
      super(page, ListCustomTargetTypesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCustomTargetTypesPage
      extends AbstractPage<
          ListCustomTargetTypesRequest,
          ListCustomTargetTypesResponse,
          CustomTargetType,
          ListCustomTargetTypesPage> {

    private ListCustomTargetTypesPage(
        PageContext<ListCustomTargetTypesRequest, ListCustomTargetTypesResponse, CustomTargetType>
            context,
        ListCustomTargetTypesResponse response) {
      super(context, response);
    }

    private static ListCustomTargetTypesPage createEmptyPage() {
      return new ListCustomTargetTypesPage(null, null);
    }

    @Override
    protected ListCustomTargetTypesPage createPage(
        PageContext<ListCustomTargetTypesRequest, ListCustomTargetTypesResponse, CustomTargetType>
            context,
        ListCustomTargetTypesResponse response) {
      return new ListCustomTargetTypesPage(context, response);
    }

    @Override
    public ApiFuture<ListCustomTargetTypesPage> createPageAsync(
        PageContext<ListCustomTargetTypesRequest, ListCustomTargetTypesResponse, CustomTargetType>
            context,
        ApiFuture<ListCustomTargetTypesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCustomTargetTypesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCustomTargetTypesRequest,
          ListCustomTargetTypesResponse,
          CustomTargetType,
          ListCustomTargetTypesPage,
          ListCustomTargetTypesFixedSizeCollection> {

    private ListCustomTargetTypesFixedSizeCollection(
        List<ListCustomTargetTypesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCustomTargetTypesFixedSizeCollection createEmptyCollection() {
      return new ListCustomTargetTypesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCustomTargetTypesFixedSizeCollection createCollection(
        List<ListCustomTargetTypesPage> pages, int collectionSize) {
      return new ListCustomTargetTypesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListReleasesPagedResponse
      extends AbstractPagedListResponse<
          ListReleasesRequest,
          ListReleasesResponse,
          Release,
          ListReleasesPage,
          ListReleasesFixedSizeCollection> {

    public static ApiFuture<ListReleasesPagedResponse> createAsync(
        PageContext<ListReleasesRequest, ListReleasesResponse, Release> context,
        ApiFuture<ListReleasesResponse> futureResponse) {
      ApiFuture<ListReleasesPage> futurePage =
          ListReleasesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListReleasesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListReleasesPagedResponse(ListReleasesPage page) {
      super(page, ListReleasesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListReleasesPage
      extends AbstractPage<ListReleasesRequest, ListReleasesResponse, Release, ListReleasesPage> {

    private ListReleasesPage(
        PageContext<ListReleasesRequest, ListReleasesResponse, Release> context,
        ListReleasesResponse response) {
      super(context, response);
    }

    private static ListReleasesPage createEmptyPage() {
      return new ListReleasesPage(null, null);
    }

    @Override
    protected ListReleasesPage createPage(
        PageContext<ListReleasesRequest, ListReleasesResponse, Release> context,
        ListReleasesResponse response) {
      return new ListReleasesPage(context, response);
    }

    @Override
    public ApiFuture<ListReleasesPage> createPageAsync(
        PageContext<ListReleasesRequest, ListReleasesResponse, Release> context,
        ApiFuture<ListReleasesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReleasesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReleasesRequest,
          ListReleasesResponse,
          Release,
          ListReleasesPage,
          ListReleasesFixedSizeCollection> {

    private ListReleasesFixedSizeCollection(List<ListReleasesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListReleasesFixedSizeCollection createEmptyCollection() {
      return new ListReleasesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListReleasesFixedSizeCollection createCollection(
        List<ListReleasesPage> pages, int collectionSize) {
      return new ListReleasesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRolloutsPagedResponse
      extends AbstractPagedListResponse<
          ListRolloutsRequest,
          ListRolloutsResponse,
          Rollout,
          ListRolloutsPage,
          ListRolloutsFixedSizeCollection> {

    public static ApiFuture<ListRolloutsPagedResponse> createAsync(
        PageContext<ListRolloutsRequest, ListRolloutsResponse, Rollout> context,
        ApiFuture<ListRolloutsResponse> futureResponse) {
      ApiFuture<ListRolloutsPage> futurePage =
          ListRolloutsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRolloutsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRolloutsPagedResponse(ListRolloutsPage page) {
      super(page, ListRolloutsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRolloutsPage
      extends AbstractPage<ListRolloutsRequest, ListRolloutsResponse, Rollout, ListRolloutsPage> {

    private ListRolloutsPage(
        PageContext<ListRolloutsRequest, ListRolloutsResponse, Rollout> context,
        ListRolloutsResponse response) {
      super(context, response);
    }

    private static ListRolloutsPage createEmptyPage() {
      return new ListRolloutsPage(null, null);
    }

    @Override
    protected ListRolloutsPage createPage(
        PageContext<ListRolloutsRequest, ListRolloutsResponse, Rollout> context,
        ListRolloutsResponse response) {
      return new ListRolloutsPage(context, response);
    }

    @Override
    public ApiFuture<ListRolloutsPage> createPageAsync(
        PageContext<ListRolloutsRequest, ListRolloutsResponse, Rollout> context,
        ApiFuture<ListRolloutsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRolloutsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRolloutsRequest,
          ListRolloutsResponse,
          Rollout,
          ListRolloutsPage,
          ListRolloutsFixedSizeCollection> {

    private ListRolloutsFixedSizeCollection(List<ListRolloutsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRolloutsFixedSizeCollection createEmptyCollection() {
      return new ListRolloutsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRolloutsFixedSizeCollection createCollection(
        List<ListRolloutsPage> pages, int collectionSize) {
      return new ListRolloutsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListJobRunsPagedResponse
      extends AbstractPagedListResponse<
          ListJobRunsRequest,
          ListJobRunsResponse,
          JobRun,
          ListJobRunsPage,
          ListJobRunsFixedSizeCollection> {

    public static ApiFuture<ListJobRunsPagedResponse> createAsync(
        PageContext<ListJobRunsRequest, ListJobRunsResponse, JobRun> context,
        ApiFuture<ListJobRunsResponse> futureResponse) {
      ApiFuture<ListJobRunsPage> futurePage =
          ListJobRunsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListJobRunsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListJobRunsPagedResponse(ListJobRunsPage page) {
      super(page, ListJobRunsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListJobRunsPage
      extends AbstractPage<ListJobRunsRequest, ListJobRunsResponse, JobRun, ListJobRunsPage> {

    private ListJobRunsPage(
        PageContext<ListJobRunsRequest, ListJobRunsResponse, JobRun> context,
        ListJobRunsResponse response) {
      super(context, response);
    }

    private static ListJobRunsPage createEmptyPage() {
      return new ListJobRunsPage(null, null);
    }

    @Override
    protected ListJobRunsPage createPage(
        PageContext<ListJobRunsRequest, ListJobRunsResponse, JobRun> context,
        ListJobRunsResponse response) {
      return new ListJobRunsPage(context, response);
    }

    @Override
    public ApiFuture<ListJobRunsPage> createPageAsync(
        PageContext<ListJobRunsRequest, ListJobRunsResponse, JobRun> context,
        ApiFuture<ListJobRunsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListJobRunsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListJobRunsRequest,
          ListJobRunsResponse,
          JobRun,
          ListJobRunsPage,
          ListJobRunsFixedSizeCollection> {

    private ListJobRunsFixedSizeCollection(List<ListJobRunsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListJobRunsFixedSizeCollection createEmptyCollection() {
      return new ListJobRunsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListJobRunsFixedSizeCollection createCollection(
        List<ListJobRunsPage> pages, int collectionSize) {
      return new ListJobRunsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAutomationsPagedResponse
      extends AbstractPagedListResponse<
          ListAutomationsRequest,
          ListAutomationsResponse,
          Automation,
          ListAutomationsPage,
          ListAutomationsFixedSizeCollection> {

    public static ApiFuture<ListAutomationsPagedResponse> createAsync(
        PageContext<ListAutomationsRequest, ListAutomationsResponse, Automation> context,
        ApiFuture<ListAutomationsResponse> futureResponse) {
      ApiFuture<ListAutomationsPage> futurePage =
          ListAutomationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAutomationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAutomationsPagedResponse(ListAutomationsPage page) {
      super(page, ListAutomationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAutomationsPage
      extends AbstractPage<
          ListAutomationsRequest, ListAutomationsResponse, Automation, ListAutomationsPage> {

    private ListAutomationsPage(
        PageContext<ListAutomationsRequest, ListAutomationsResponse, Automation> context,
        ListAutomationsResponse response) {
      super(context, response);
    }

    private static ListAutomationsPage createEmptyPage() {
      return new ListAutomationsPage(null, null);
    }

    @Override
    protected ListAutomationsPage createPage(
        PageContext<ListAutomationsRequest, ListAutomationsResponse, Automation> context,
        ListAutomationsResponse response) {
      return new ListAutomationsPage(context, response);
    }

    @Override
    public ApiFuture<ListAutomationsPage> createPageAsync(
        PageContext<ListAutomationsRequest, ListAutomationsResponse, Automation> context,
        ApiFuture<ListAutomationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAutomationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAutomationsRequest,
          ListAutomationsResponse,
          Automation,
          ListAutomationsPage,
          ListAutomationsFixedSizeCollection> {

    private ListAutomationsFixedSizeCollection(
        List<ListAutomationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAutomationsFixedSizeCollection createEmptyCollection() {
      return new ListAutomationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAutomationsFixedSizeCollection createCollection(
        List<ListAutomationsPage> pages, int collectionSize) {
      return new ListAutomationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAutomationRunsPagedResponse
      extends AbstractPagedListResponse<
          ListAutomationRunsRequest,
          ListAutomationRunsResponse,
          AutomationRun,
          ListAutomationRunsPage,
          ListAutomationRunsFixedSizeCollection> {

    public static ApiFuture<ListAutomationRunsPagedResponse> createAsync(
        PageContext<ListAutomationRunsRequest, ListAutomationRunsResponse, AutomationRun> context,
        ApiFuture<ListAutomationRunsResponse> futureResponse) {
      ApiFuture<ListAutomationRunsPage> futurePage =
          ListAutomationRunsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAutomationRunsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAutomationRunsPagedResponse(ListAutomationRunsPage page) {
      super(page, ListAutomationRunsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAutomationRunsPage
      extends AbstractPage<
          ListAutomationRunsRequest,
          ListAutomationRunsResponse,
          AutomationRun,
          ListAutomationRunsPage> {

    private ListAutomationRunsPage(
        PageContext<ListAutomationRunsRequest, ListAutomationRunsResponse, AutomationRun> context,
        ListAutomationRunsResponse response) {
      super(context, response);
    }

    private static ListAutomationRunsPage createEmptyPage() {
      return new ListAutomationRunsPage(null, null);
    }

    @Override
    protected ListAutomationRunsPage createPage(
        PageContext<ListAutomationRunsRequest, ListAutomationRunsResponse, AutomationRun> context,
        ListAutomationRunsResponse response) {
      return new ListAutomationRunsPage(context, response);
    }

    @Override
    public ApiFuture<ListAutomationRunsPage> createPageAsync(
        PageContext<ListAutomationRunsRequest, ListAutomationRunsResponse, AutomationRun> context,
        ApiFuture<ListAutomationRunsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAutomationRunsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAutomationRunsRequest,
          ListAutomationRunsResponse,
          AutomationRun,
          ListAutomationRunsPage,
          ListAutomationRunsFixedSizeCollection> {

    private ListAutomationRunsFixedSizeCollection(
        List<ListAutomationRunsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAutomationRunsFixedSizeCollection createEmptyCollection() {
      return new ListAutomationRunsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAutomationRunsFixedSizeCollection createCollection(
        List<ListAutomationRunsPage> pages, int collectionSize) {
      return new ListAutomationRunsFixedSizeCollection(pages, collectionSize);
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
