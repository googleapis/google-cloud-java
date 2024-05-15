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

package com.google.cloud.visionai.v1;

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
import com.google.cloud.visionai.v1.stub.AppPlatformStub;
import com.google.cloud.visionai.v1.stub.AppPlatformStubSettings;
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
 * Service Description: Service describing handlers for resources
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
 * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
 *   ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
 *   Application response = appPlatformClient.getApplication(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AppPlatformClient object to clean up resources such as
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
 *      <td><p> ListApplications</td>
 *      <td><p> Lists Applications in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listApplications(ListApplicationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listApplications(LocationName parent)
 *           <li><p> listApplications(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listApplicationsPagedCallable()
 *           <li><p> listApplicationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetApplication</td>
 *      <td><p> Gets details of a single Application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getApplication(GetApplicationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getApplication(ApplicationName name)
 *           <li><p> getApplication(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getApplicationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateApplication</td>
 *      <td><p> Creates a new Application in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createApplicationAsync(CreateApplicationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createApplicationAsync(LocationName parent, Application application)
 *           <li><p> createApplicationAsync(String parent, Application application)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createApplicationOperationCallable()
 *           <li><p> createApplicationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateApplication</td>
 *      <td><p> Updates the parameters of a single Application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateApplicationAsync(UpdateApplicationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateApplicationAsync(Application application, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateApplicationOperationCallable()
 *           <li><p> updateApplicationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteApplication</td>
 *      <td><p> Deletes a single Application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteApplicationAsync(DeleteApplicationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteApplicationAsync(ApplicationName name)
 *           <li><p> deleteApplicationAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteApplicationOperationCallable()
 *           <li><p> deleteApplicationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeployApplication</td>
 *      <td><p> Deploys a single Application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deployApplicationAsync(DeployApplicationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deployApplicationAsync(ApplicationName name)
 *           <li><p> deployApplicationAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deployApplicationOperationCallable()
 *           <li><p> deployApplicationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UndeployApplication</td>
 *      <td><p> Undeploys a single Application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> undeployApplicationAsync(UndeployApplicationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> undeployApplicationAsync(ApplicationName name)
 *           <li><p> undeployApplicationAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> undeployApplicationOperationCallable()
 *           <li><p> undeployApplicationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AddApplicationStreamInput</td>
 *      <td><p> Adds target stream input to the Application. If the Application is deployed, the corresponding new Application instance will be created. If the stream has already been in the Application, the RPC will fail.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> addApplicationStreamInputAsync(AddApplicationStreamInputRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> addApplicationStreamInputAsync(ApplicationName name)
 *           <li><p> addApplicationStreamInputAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> addApplicationStreamInputOperationCallable()
 *           <li><p> addApplicationStreamInputCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RemoveApplicationStreamInput</td>
 *      <td><p> Remove target stream input to the Application, if the Application is deployed, the corresponding instance based will be deleted. If the stream is not in the Application, the RPC will fail.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> removeApplicationStreamInputAsync(RemoveApplicationStreamInputRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> removeApplicationStreamInputAsync(ApplicationName name)
 *           <li><p> removeApplicationStreamInputAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> removeApplicationStreamInputOperationCallable()
 *           <li><p> removeApplicationStreamInputCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateApplicationStreamInput</td>
 *      <td><p> Update target stream input to the Application, if the Application is deployed, the corresponding instance based will be deployed. For CreateOrUpdate behavior, set allow_missing to true.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateApplicationStreamInputAsync(UpdateApplicationStreamInputRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateApplicationStreamInputAsync(ApplicationName name)
 *           <li><p> updateApplicationStreamInputAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateApplicationStreamInputOperationCallable()
 *           <li><p> updateApplicationStreamInputCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListInstances</td>
 *      <td><p> Lists Instances in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listInstances(ListInstancesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listInstances(ApplicationName parent)
 *           <li><p> listInstances(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listInstancesPagedCallable()
 *           <li><p> listInstancesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetInstance</td>
 *      <td><p> Gets details of a single Instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getInstance(GetInstanceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getInstance(InstanceName name)
 *           <li><p> getInstance(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateApplicationInstances</td>
 *      <td><p> Adds target stream input to the Application. If the Application is deployed, the corresponding new Application instance will be created. If the stream has already been in the Application, the RPC will fail.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createApplicationInstancesAsync(CreateApplicationInstancesRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createApplicationInstancesAsync(ApplicationName name)
 *           <li><p> createApplicationInstancesAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createApplicationInstancesOperationCallable()
 *           <li><p> createApplicationInstancesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteApplicationInstances</td>
 *      <td><p> Remove target stream input to the Application, if the Application is deployed, the corresponding instance based will be deleted. If the stream is not in the Application, the RPC will fail.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteApplicationInstancesAsync(DeleteApplicationInstancesRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteApplicationInstancesAsync(ApplicationName name)
 *           <li><p> deleteApplicationInstancesAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteApplicationInstancesOperationCallable()
 *           <li><p> deleteApplicationInstancesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateApplicationInstances</td>
 *      <td><p> Adds target stream input to the Application. If the Application is deployed, the corresponding new Application instance will be created. If the stream has already been in the Application, the RPC will fail.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateApplicationInstancesAsync(UpdateApplicationInstancesRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateApplicationInstancesAsync(ApplicationName name, List&lt;UpdateApplicationInstancesRequest.UpdateApplicationInstance&gt; applicationInstances)
 *           <li><p> updateApplicationInstancesAsync(String name, List&lt;UpdateApplicationInstancesRequest.UpdateApplicationInstance&gt; applicationInstances)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateApplicationInstancesOperationCallable()
 *           <li><p> updateApplicationInstancesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDrafts</td>
 *      <td><p> Lists Drafts in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDrafts(ListDraftsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDrafts(ApplicationName parent)
 *           <li><p> listDrafts(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDraftsPagedCallable()
 *           <li><p> listDraftsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDraft</td>
 *      <td><p> Gets details of a single Draft.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDraft(GetDraftRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDraft(DraftName name)
 *           <li><p> getDraft(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDraftCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDraft</td>
 *      <td><p> Creates a new Draft in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDraftAsync(CreateDraftRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createDraftAsync(ApplicationName parent, Draft draft, String draftId)
 *           <li><p> createDraftAsync(String parent, Draft draft, String draftId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDraftOperationCallable()
 *           <li><p> createDraftCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDraft</td>
 *      <td><p> Updates the parameters of a single Draft.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDraftAsync(UpdateDraftRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateDraftAsync(Draft draft, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDraftOperationCallable()
 *           <li><p> updateDraftCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDraft</td>
 *      <td><p> Deletes a single Draft.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDraftAsync(DeleteDraftRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteDraftAsync(DraftName name)
 *           <li><p> deleteDraftAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDraftOperationCallable()
 *           <li><p> deleteDraftCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListProcessors</td>
 *      <td><p> Lists Processors in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listProcessors(ListProcessorsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listProcessors(LocationName parent)
 *           <li><p> listProcessors(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listProcessorsPagedCallable()
 *           <li><p> listProcessorsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPrebuiltProcessors</td>
 *      <td><p> ListPrebuiltProcessors is a custom pass-through verb that Lists Prebuilt Processors.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPrebuiltProcessors(ListPrebuiltProcessorsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPrebuiltProcessors(LocationName parent)
 *           <li><p> listPrebuiltProcessors(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPrebuiltProcessorsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetProcessor</td>
 *      <td><p> Gets details of a single Processor.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getProcessor(GetProcessorRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getProcessor(ProcessorName name)
 *           <li><p> getProcessor(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getProcessorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateProcessor</td>
 *      <td><p> Creates a new Processor in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createProcessorAsync(CreateProcessorRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createProcessorAsync(LocationName parent, Processor processor, String processorId)
 *           <li><p> createProcessorAsync(String parent, Processor processor, String processorId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createProcessorOperationCallable()
 *           <li><p> createProcessorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateProcessor</td>
 *      <td><p> Updates the parameters of a single Processor.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateProcessorAsync(UpdateProcessorRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateProcessorAsync(Processor processor, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateProcessorOperationCallable()
 *           <li><p> updateProcessorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteProcessor</td>
 *      <td><p> Deletes a single Processor.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteProcessorAsync(DeleteProcessorRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteProcessorAsync(ProcessorName name)
 *           <li><p> deleteProcessorAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteProcessorOperationCallable()
 *           <li><p> deleteProcessorCallable()
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
 * <p>This class can be customized by passing in a custom instance of AppPlatformSettings to
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
 * AppPlatformSettings appPlatformSettings =
 *     AppPlatformSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AppPlatformClient appPlatformClient = AppPlatformClient.create(appPlatformSettings);
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
 * AppPlatformSettings appPlatformSettings =
 *     AppPlatformSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AppPlatformClient appPlatformClient = AppPlatformClient.create(appPlatformSettings);
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
 * AppPlatformSettings appPlatformSettings = AppPlatformSettings.newHttpJsonBuilder().build();
 * AppPlatformClient appPlatformClient = AppPlatformClient.create(appPlatformSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AppPlatformClient implements BackgroundResource {
  private final AppPlatformSettings settings;
  private final AppPlatformStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of AppPlatformClient with default settings. */
  public static final AppPlatformClient create() throws IOException {
    return create(AppPlatformSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AppPlatformClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AppPlatformClient create(AppPlatformSettings settings) throws IOException {
    return new AppPlatformClient(settings);
  }

  /**
   * Constructs an instance of AppPlatformClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(AppPlatformSettings).
   */
  public static final AppPlatformClient create(AppPlatformStub stub) {
    return new AppPlatformClient(stub);
  }

  /**
   * Constructs an instance of AppPlatformClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AppPlatformClient(AppPlatformSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AppPlatformStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected AppPlatformClient(AppPlatformStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final AppPlatformSettings getSettings() {
    return settings;
  }

  public AppPlatformStub getStub() {
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
   * Lists Applications in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Application element : appPlatformClient.listApplications(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListApplicationsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApplicationsPagedResponse listApplications(LocationName parent) {
    ListApplicationsRequest request =
        ListApplicationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listApplications(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Applications in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Application element : appPlatformClient.listApplications(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListApplicationsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApplicationsPagedResponse listApplications(String parent) {
    ListApplicationsRequest request =
        ListApplicationsRequest.newBuilder().setParent(parent).build();
    return listApplications(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Applications in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ListApplicationsRequest request =
   *       ListApplicationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Application element : appPlatformClient.listApplications(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApplicationsPagedResponse listApplications(ListApplicationsRequest request) {
    return listApplicationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Applications in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ListApplicationsRequest request =
   *       ListApplicationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Application> future =
   *       appPlatformClient.listApplicationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Application element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListApplicationsRequest, ListApplicationsPagedResponse>
      listApplicationsPagedCallable() {
    return stub.listApplicationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Applications in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ListApplicationsRequest request =
   *       ListApplicationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListApplicationsResponse response =
   *         appPlatformClient.listApplicationsCallable().call(request);
   *     for (Application element : response.getApplicationsList()) {
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
  public final UnaryCallable<ListApplicationsRequest, ListApplicationsResponse>
      listApplicationsCallable() {
    return stub.listApplicationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
   *   Application response = appPlatformClient.getApplication(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Application getApplication(ApplicationName name) {
    GetApplicationRequest request =
        GetApplicationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getApplication(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   String name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString();
   *   Application response = appPlatformClient.getApplication(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Application getApplication(String name) {
    GetApplicationRequest request = GetApplicationRequest.newBuilder().setName(name).build();
    return getApplication(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   GetApplicationRequest request =
   *       GetApplicationRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .build();
   *   Application response = appPlatformClient.getApplication(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Application getApplication(GetApplicationRequest request) {
    return getApplicationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   GetApplicationRequest request =
   *       GetApplicationRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .build();
   *   ApiFuture<Application> future =
   *       appPlatformClient.getApplicationCallable().futureCall(request);
   *   // Do something.
   *   Application response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetApplicationRequest, Application> getApplicationCallable() {
    return stub.getApplicationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Application in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Application application = Application.newBuilder().build();
   *   Application response = appPlatformClient.createApplicationAsync(parent, application).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param application Required. The resource being created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Application, OperationMetadata> createApplicationAsync(
      LocationName parent, Application application) {
    CreateApplicationRequest request =
        CreateApplicationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setApplication(application)
            .build();
    return createApplicationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Application in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Application application = Application.newBuilder().build();
   *   Application response = appPlatformClient.createApplicationAsync(parent, application).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param application Required. The resource being created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Application, OperationMetadata> createApplicationAsync(
      String parent, Application application) {
    CreateApplicationRequest request =
        CreateApplicationRequest.newBuilder().setParent(parent).setApplication(application).build();
    return createApplicationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Application in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   CreateApplicationRequest request =
   *       CreateApplicationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setApplicationId("applicationId-1011352949")
   *           .setApplication(Application.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Application response = appPlatformClient.createApplicationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Application, OperationMetadata> createApplicationAsync(
      CreateApplicationRequest request) {
    return createApplicationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Application in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   CreateApplicationRequest request =
   *       CreateApplicationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setApplicationId("applicationId-1011352949")
   *           .setApplication(Application.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Application, OperationMetadata> future =
   *       appPlatformClient.createApplicationOperationCallable().futureCall(request);
   *   // Do something.
   *   Application response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateApplicationRequest, Application, OperationMetadata>
      createApplicationOperationCallable() {
    return stub.createApplicationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Application in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   CreateApplicationRequest request =
   *       CreateApplicationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setApplicationId("applicationId-1011352949")
   *           .setApplication(Application.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       appPlatformClient.createApplicationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateApplicationRequest, Operation> createApplicationCallable() {
    return stub.createApplicationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   Application application = Application.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Application response =
   *       appPlatformClient.updateApplicationAsync(application, updateMask).get();
   * }
   * }</pre>
   *
   * @param application Required. The resource being updated.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     Application resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Application, OperationMetadata> updateApplicationAsync(
      Application application, FieldMask updateMask) {
    UpdateApplicationRequest request =
        UpdateApplicationRequest.newBuilder()
            .setApplication(application)
            .setUpdateMask(updateMask)
            .build();
    return updateApplicationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   UpdateApplicationRequest request =
   *       UpdateApplicationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setApplication(Application.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Application response = appPlatformClient.updateApplicationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Application, OperationMetadata> updateApplicationAsync(
      UpdateApplicationRequest request) {
    return updateApplicationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   UpdateApplicationRequest request =
   *       UpdateApplicationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setApplication(Application.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Application, OperationMetadata> future =
   *       appPlatformClient.updateApplicationOperationCallable().futureCall(request);
   *   // Do something.
   *   Application response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateApplicationRequest, Application, OperationMetadata>
      updateApplicationOperationCallable() {
    return stub.updateApplicationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   UpdateApplicationRequest request =
   *       UpdateApplicationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setApplication(Application.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       appPlatformClient.updateApplicationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateApplicationRequest, Operation> updateApplicationCallable() {
    return stub.updateApplicationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
   *   appPlatformClient.deleteApplicationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteApplicationAsync(
      ApplicationName name) {
    DeleteApplicationRequest request =
        DeleteApplicationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteApplicationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   String name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString();
   *   appPlatformClient.deleteApplicationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteApplicationAsync(String name) {
    DeleteApplicationRequest request = DeleteApplicationRequest.newBuilder().setName(name).build();
    return deleteApplicationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   DeleteApplicationRequest request =
   *       DeleteApplicationRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   appPlatformClient.deleteApplicationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteApplicationAsync(
      DeleteApplicationRequest request) {
    return deleteApplicationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   DeleteApplicationRequest request =
   *       DeleteApplicationRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       appPlatformClient.deleteApplicationOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteApplicationRequest, Empty, OperationMetadata>
      deleteApplicationOperationCallable() {
    return stub.deleteApplicationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   DeleteApplicationRequest request =
   *       DeleteApplicationRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       appPlatformClient.deleteApplicationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteApplicationRequest, Operation> deleteApplicationCallable() {
    return stub.deleteApplicationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a single Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
   *   DeployApplicationResponse response = appPlatformClient.deployApplicationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. the name of the application to retrieve. Format:
   *     "projects/{project}/locations/{location}/applications/{application}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployApplicationResponse, OperationMetadata> deployApplicationAsync(
      ApplicationName name) {
    DeployApplicationRequest request =
        DeployApplicationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deployApplicationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a single Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   String name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString();
   *   DeployApplicationResponse response = appPlatformClient.deployApplicationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. the name of the application to retrieve. Format:
   *     "projects/{project}/locations/{location}/applications/{application}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployApplicationResponse, OperationMetadata> deployApplicationAsync(
      String name) {
    DeployApplicationRequest request = DeployApplicationRequest.newBuilder().setName(name).build();
    return deployApplicationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a single Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   DeployApplicationRequest request =
   *       DeployApplicationRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .setEnableMonitoring(true)
   *           .build();
   *   DeployApplicationResponse response = appPlatformClient.deployApplicationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployApplicationResponse, OperationMetadata> deployApplicationAsync(
      DeployApplicationRequest request) {
    return deployApplicationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a single Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   DeployApplicationRequest request =
   *       DeployApplicationRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .setEnableMonitoring(true)
   *           .build();
   *   OperationFuture<DeployApplicationResponse, OperationMetadata> future =
   *       appPlatformClient.deployApplicationOperationCallable().futureCall(request);
   *   // Do something.
   *   DeployApplicationResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeployApplicationRequest, DeployApplicationResponse, OperationMetadata>
      deployApplicationOperationCallable() {
    return stub.deployApplicationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a single Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   DeployApplicationRequest request =
   *       DeployApplicationRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .setEnableMonitoring(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       appPlatformClient.deployApplicationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeployApplicationRequest, Operation> deployApplicationCallable() {
    return stub.deployApplicationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys a single Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
   *   UndeployApplicationResponse response = appPlatformClient.undeployApplicationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. the name of the application to retrieve. Format:
   *     "projects/{project}/locations/{location}/applications/{application}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UndeployApplicationResponse, OperationMetadata>
      undeployApplicationAsync(ApplicationName name) {
    UndeployApplicationRequest request =
        UndeployApplicationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return undeployApplicationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys a single Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   String name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString();
   *   UndeployApplicationResponse response = appPlatformClient.undeployApplicationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. the name of the application to retrieve. Format:
   *     "projects/{project}/locations/{location}/applications/{application}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UndeployApplicationResponse, OperationMetadata>
      undeployApplicationAsync(String name) {
    UndeployApplicationRequest request =
        UndeployApplicationRequest.newBuilder().setName(name).build();
    return undeployApplicationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys a single Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   UndeployApplicationRequest request =
   *       UndeployApplicationRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   UndeployApplicationResponse response =
   *       appPlatformClient.undeployApplicationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UndeployApplicationResponse, OperationMetadata>
      undeployApplicationAsync(UndeployApplicationRequest request) {
    return undeployApplicationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys a single Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   UndeployApplicationRequest request =
   *       UndeployApplicationRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<UndeployApplicationResponse, OperationMetadata> future =
   *       appPlatformClient.undeployApplicationOperationCallable().futureCall(request);
   *   // Do something.
   *   UndeployApplicationResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UndeployApplicationRequest, UndeployApplicationResponse, OperationMetadata>
      undeployApplicationOperationCallable() {
    return stub.undeployApplicationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys a single Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   UndeployApplicationRequest request =
   *       UndeployApplicationRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       appPlatformClient.undeployApplicationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeployApplicationRequest, Operation> undeployApplicationCallable() {
    return stub.undeployApplicationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds target stream input to the Application. If the Application is deployed, the corresponding
   * new Application instance will be created. If the stream has already been in the Application,
   * the RPC will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
   *   AddApplicationStreamInputResponse response =
   *       appPlatformClient.addApplicationStreamInputAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. the name of the application to retrieve. Format:
   *     "projects/{project}/locations/{location}/applications/{application}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddApplicationStreamInputResponse, OperationMetadata>
      addApplicationStreamInputAsync(ApplicationName name) {
    AddApplicationStreamInputRequest request =
        AddApplicationStreamInputRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return addApplicationStreamInputAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds target stream input to the Application. If the Application is deployed, the corresponding
   * new Application instance will be created. If the stream has already been in the Application,
   * the RPC will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   String name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString();
   *   AddApplicationStreamInputResponse response =
   *       appPlatformClient.addApplicationStreamInputAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. the name of the application to retrieve. Format:
   *     "projects/{project}/locations/{location}/applications/{application}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddApplicationStreamInputResponse, OperationMetadata>
      addApplicationStreamInputAsync(String name) {
    AddApplicationStreamInputRequest request =
        AddApplicationStreamInputRequest.newBuilder().setName(name).build();
    return addApplicationStreamInputAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds target stream input to the Application. If the Application is deployed, the corresponding
   * new Application instance will be created. If the stream has already been in the Application,
   * the RPC will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   AddApplicationStreamInputRequest request =
   *       AddApplicationStreamInputRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .addAllApplicationStreamInputs(new ArrayList<ApplicationStreamInput>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   AddApplicationStreamInputResponse response =
   *       appPlatformClient.addApplicationStreamInputAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddApplicationStreamInputResponse, OperationMetadata>
      addApplicationStreamInputAsync(AddApplicationStreamInputRequest request) {
    return addApplicationStreamInputOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds target stream input to the Application. If the Application is deployed, the corresponding
   * new Application instance will be created. If the stream has already been in the Application,
   * the RPC will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   AddApplicationStreamInputRequest request =
   *       AddApplicationStreamInputRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .addAllApplicationStreamInputs(new ArrayList<ApplicationStreamInput>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<AddApplicationStreamInputResponse, OperationMetadata> future =
   *       appPlatformClient.addApplicationStreamInputOperationCallable().futureCall(request);
   *   // Do something.
   *   AddApplicationStreamInputResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          AddApplicationStreamInputRequest, AddApplicationStreamInputResponse, OperationMetadata>
      addApplicationStreamInputOperationCallable() {
    return stub.addApplicationStreamInputOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds target stream input to the Application. If the Application is deployed, the corresponding
   * new Application instance will be created. If the stream has already been in the Application,
   * the RPC will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   AddApplicationStreamInputRequest request =
   *       AddApplicationStreamInputRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .addAllApplicationStreamInputs(new ArrayList<ApplicationStreamInput>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       appPlatformClient.addApplicationStreamInputCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddApplicationStreamInputRequest, Operation>
      addApplicationStreamInputCallable() {
    return stub.addApplicationStreamInputCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove target stream input to the Application, if the Application is deployed, the
   * corresponding instance based will be deleted. If the stream is not in the Application, the RPC
   * will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
   *   RemoveApplicationStreamInputResponse response =
   *       appPlatformClient.removeApplicationStreamInputAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. the name of the application to retrieve. Format:
   *     "projects/{project}/locations/{location}/applications/{application}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RemoveApplicationStreamInputResponse, OperationMetadata>
      removeApplicationStreamInputAsync(ApplicationName name) {
    RemoveApplicationStreamInputRequest request =
        RemoveApplicationStreamInputRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return removeApplicationStreamInputAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove target stream input to the Application, if the Application is deployed, the
   * corresponding instance based will be deleted. If the stream is not in the Application, the RPC
   * will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   String name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString();
   *   RemoveApplicationStreamInputResponse response =
   *       appPlatformClient.removeApplicationStreamInputAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. the name of the application to retrieve. Format:
   *     "projects/{project}/locations/{location}/applications/{application}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RemoveApplicationStreamInputResponse, OperationMetadata>
      removeApplicationStreamInputAsync(String name) {
    RemoveApplicationStreamInputRequest request =
        RemoveApplicationStreamInputRequest.newBuilder().setName(name).build();
    return removeApplicationStreamInputAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove target stream input to the Application, if the Application is deployed, the
   * corresponding instance based will be deleted. If the stream is not in the Application, the RPC
   * will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   RemoveApplicationStreamInputRequest request =
   *       RemoveApplicationStreamInputRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .addAllTargetStreamInputs(
   *               new ArrayList<RemoveApplicationStreamInputRequest.TargetStreamInput>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   RemoveApplicationStreamInputResponse response =
   *       appPlatformClient.removeApplicationStreamInputAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RemoveApplicationStreamInputResponse, OperationMetadata>
      removeApplicationStreamInputAsync(RemoveApplicationStreamInputRequest request) {
    return removeApplicationStreamInputOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove target stream input to the Application, if the Application is deployed, the
   * corresponding instance based will be deleted. If the stream is not in the Application, the RPC
   * will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   RemoveApplicationStreamInputRequest request =
   *       RemoveApplicationStreamInputRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .addAllTargetStreamInputs(
   *               new ArrayList<RemoveApplicationStreamInputRequest.TargetStreamInput>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<RemoveApplicationStreamInputResponse, OperationMetadata> future =
   *       appPlatformClient.removeApplicationStreamInputOperationCallable().futureCall(request);
   *   // Do something.
   *   RemoveApplicationStreamInputResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RemoveApplicationStreamInputRequest,
          RemoveApplicationStreamInputResponse,
          OperationMetadata>
      removeApplicationStreamInputOperationCallable() {
    return stub.removeApplicationStreamInputOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove target stream input to the Application, if the Application is deployed, the
   * corresponding instance based will be deleted. If the stream is not in the Application, the RPC
   * will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   RemoveApplicationStreamInputRequest request =
   *       RemoveApplicationStreamInputRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .addAllTargetStreamInputs(
   *               new ArrayList<RemoveApplicationStreamInputRequest.TargetStreamInput>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       appPlatformClient.removeApplicationStreamInputCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveApplicationStreamInputRequest, Operation>
      removeApplicationStreamInputCallable() {
    return stub.removeApplicationStreamInputCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update target stream input to the Application, if the Application is deployed, the
   * corresponding instance based will be deployed. For CreateOrUpdate behavior, set allow_missing
   * to true.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
   *   UpdateApplicationStreamInputResponse response =
   *       appPlatformClient.updateApplicationStreamInputAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. the name of the application to retrieve. Format:
   *     "projects/{project}/locations/{location}/applications/{application}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UpdateApplicationStreamInputResponse, OperationMetadata>
      updateApplicationStreamInputAsync(ApplicationName name) {
    UpdateApplicationStreamInputRequest request =
        UpdateApplicationStreamInputRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return updateApplicationStreamInputAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update target stream input to the Application, if the Application is deployed, the
   * corresponding instance based will be deployed. For CreateOrUpdate behavior, set allow_missing
   * to true.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   String name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString();
   *   UpdateApplicationStreamInputResponse response =
   *       appPlatformClient.updateApplicationStreamInputAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. the name of the application to retrieve. Format:
   *     "projects/{project}/locations/{location}/applications/{application}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UpdateApplicationStreamInputResponse, OperationMetadata>
      updateApplicationStreamInputAsync(String name) {
    UpdateApplicationStreamInputRequest request =
        UpdateApplicationStreamInputRequest.newBuilder().setName(name).build();
    return updateApplicationStreamInputAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update target stream input to the Application, if the Application is deployed, the
   * corresponding instance based will be deployed. For CreateOrUpdate behavior, set allow_missing
   * to true.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   UpdateApplicationStreamInputRequest request =
   *       UpdateApplicationStreamInputRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .addAllApplicationStreamInputs(new ArrayList<ApplicationStreamInput>())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .build();
   *   UpdateApplicationStreamInputResponse response =
   *       appPlatformClient.updateApplicationStreamInputAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UpdateApplicationStreamInputResponse, OperationMetadata>
      updateApplicationStreamInputAsync(UpdateApplicationStreamInputRequest request) {
    return updateApplicationStreamInputOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update target stream input to the Application, if the Application is deployed, the
   * corresponding instance based will be deployed. For CreateOrUpdate behavior, set allow_missing
   * to true.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   UpdateApplicationStreamInputRequest request =
   *       UpdateApplicationStreamInputRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .addAllApplicationStreamInputs(new ArrayList<ApplicationStreamInput>())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .build();
   *   OperationFuture<UpdateApplicationStreamInputResponse, OperationMetadata> future =
   *       appPlatformClient.updateApplicationStreamInputOperationCallable().futureCall(request);
   *   // Do something.
   *   UpdateApplicationStreamInputResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateApplicationStreamInputRequest,
          UpdateApplicationStreamInputResponse,
          OperationMetadata>
      updateApplicationStreamInputOperationCallable() {
    return stub.updateApplicationStreamInputOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update target stream input to the Application, if the Application is deployed, the
   * corresponding instance based will be deployed. For CreateOrUpdate behavior, set allow_missing
   * to true.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   UpdateApplicationStreamInputRequest request =
   *       UpdateApplicationStreamInputRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .addAllApplicationStreamInputs(new ArrayList<ApplicationStreamInput>())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       appPlatformClient.updateApplicationStreamInputCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateApplicationStreamInputRequest, Operation>
      updateApplicationStreamInputCallable() {
    return stub.updateApplicationStreamInputCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ApplicationName parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
   *   for (Instance element : appPlatformClient.listInstances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListInstancesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(ApplicationName parent) {
    ListInstancesRequest request =
        ListInstancesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   String parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString();
   *   for (Instance element : appPlatformClient.listInstances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListInstancesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(String parent) {
    ListInstancesRequest request = ListInstancesRequest.newBuilder().setParent(parent).build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Instance element : appPlatformClient.listInstances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(ListInstancesRequest request) {
    return listInstancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Instance> future =
   *       appPlatformClient.listInstancesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Instance element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return stub.listInstancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListInstancesResponse response = appPlatformClient.listInstancesCallable().call(request);
   *     for (Instance element : response.getInstancesList()) {
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
  public final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return stub.listInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[INSTANCE]");
   *   Instance response = appPlatformClient.getInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(InstanceName name) {
    GetInstanceRequest request =
        GetInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   String name =
   *       InstanceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[INSTANCE]").toString();
   *   Instance response = appPlatformClient.getInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(String name) {
    GetInstanceRequest request = GetInstanceRequest.newBuilder().setName(name).build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   GetInstanceRequest request =
   *       GetInstanceRequest.newBuilder()
   *           .setName(
   *               InstanceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[INSTANCE]")
   *                   .toString())
   *           .build();
   *   Instance response = appPlatformClient.getInstance(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(GetInstanceRequest request) {
    return getInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   GetInstanceRequest request =
   *       GetInstanceRequest.newBuilder()
   *           .setName(
   *               InstanceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[INSTANCE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Instance> future = appPlatformClient.getInstanceCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return stub.getInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds target stream input to the Application. If the Application is deployed, the corresponding
   * new Application instance will be created. If the stream has already been in the Application,
   * the RPC will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
   *   CreateApplicationInstancesResponse response =
   *       appPlatformClient.createApplicationInstancesAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. the name of the application to retrieve. Format:
   *     "projects/{project}/locations/{location}/applications/{application}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CreateApplicationInstancesResponse, OperationMetadata>
      createApplicationInstancesAsync(ApplicationName name) {
    CreateApplicationInstancesRequest request =
        CreateApplicationInstancesRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return createApplicationInstancesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds target stream input to the Application. If the Application is deployed, the corresponding
   * new Application instance will be created. If the stream has already been in the Application,
   * the RPC will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   String name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString();
   *   CreateApplicationInstancesResponse response =
   *       appPlatformClient.createApplicationInstancesAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. the name of the application to retrieve. Format:
   *     "projects/{project}/locations/{location}/applications/{application}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CreateApplicationInstancesResponse, OperationMetadata>
      createApplicationInstancesAsync(String name) {
    CreateApplicationInstancesRequest request =
        CreateApplicationInstancesRequest.newBuilder().setName(name).build();
    return createApplicationInstancesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds target stream input to the Application. If the Application is deployed, the corresponding
   * new Application instance will be created. If the stream has already been in the Application,
   * the RPC will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   CreateApplicationInstancesRequest request =
   *       CreateApplicationInstancesRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .addAllApplicationInstances(new ArrayList<ApplicationInstance>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   CreateApplicationInstancesResponse response =
   *       appPlatformClient.createApplicationInstancesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CreateApplicationInstancesResponse, OperationMetadata>
      createApplicationInstancesAsync(CreateApplicationInstancesRequest request) {
    return createApplicationInstancesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds target stream input to the Application. If the Application is deployed, the corresponding
   * new Application instance will be created. If the stream has already been in the Application,
   * the RPC will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   CreateApplicationInstancesRequest request =
   *       CreateApplicationInstancesRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .addAllApplicationInstances(new ArrayList<ApplicationInstance>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<CreateApplicationInstancesResponse, OperationMetadata> future =
   *       appPlatformClient.createApplicationInstancesOperationCallable().futureCall(request);
   *   // Do something.
   *   CreateApplicationInstancesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateApplicationInstancesRequest, CreateApplicationInstancesResponse, OperationMetadata>
      createApplicationInstancesOperationCallable() {
    return stub.createApplicationInstancesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds target stream input to the Application. If the Application is deployed, the corresponding
   * new Application instance will be created. If the stream has already been in the Application,
   * the RPC will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   CreateApplicationInstancesRequest request =
   *       CreateApplicationInstancesRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .addAllApplicationInstances(new ArrayList<ApplicationInstance>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       appPlatformClient.createApplicationInstancesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateApplicationInstancesRequest, Operation>
      createApplicationInstancesCallable() {
    return stub.createApplicationInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove target stream input to the Application, if the Application is deployed, the
   * corresponding instance based will be deleted. If the stream is not in the Application, the RPC
   * will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
   *   Instance response = appPlatformClient.deleteApplicationInstancesAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. the name of the application to retrieve. Format:
   *     "projects/{project}/locations/{location}/applications/{application}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> deleteApplicationInstancesAsync(
      ApplicationName name) {
    DeleteApplicationInstancesRequest request =
        DeleteApplicationInstancesRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteApplicationInstancesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove target stream input to the Application, if the Application is deployed, the
   * corresponding instance based will be deleted. If the stream is not in the Application, the RPC
   * will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   String name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString();
   *   Instance response = appPlatformClient.deleteApplicationInstancesAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. the name of the application to retrieve. Format:
   *     "projects/{project}/locations/{location}/applications/{application}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> deleteApplicationInstancesAsync(
      String name) {
    DeleteApplicationInstancesRequest request =
        DeleteApplicationInstancesRequest.newBuilder().setName(name).build();
    return deleteApplicationInstancesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove target stream input to the Application, if the Application is deployed, the
   * corresponding instance based will be deleted. If the stream is not in the Application, the RPC
   * will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   DeleteApplicationInstancesRequest request =
   *       DeleteApplicationInstancesRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .addAllInstanceIds(new ArrayList<String>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Instance response = appPlatformClient.deleteApplicationInstancesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> deleteApplicationInstancesAsync(
      DeleteApplicationInstancesRequest request) {
    return deleteApplicationInstancesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove target stream input to the Application, if the Application is deployed, the
   * corresponding instance based will be deleted. If the stream is not in the Application, the RPC
   * will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   DeleteApplicationInstancesRequest request =
   *       DeleteApplicationInstancesRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .addAllInstanceIds(new ArrayList<String>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       appPlatformClient.deleteApplicationInstancesOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteApplicationInstancesRequest, Instance, OperationMetadata>
      deleteApplicationInstancesOperationCallable() {
    return stub.deleteApplicationInstancesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove target stream input to the Application, if the Application is deployed, the
   * corresponding instance based will be deleted. If the stream is not in the Application, the RPC
   * will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   DeleteApplicationInstancesRequest request =
   *       DeleteApplicationInstancesRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .addAllInstanceIds(new ArrayList<String>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       appPlatformClient.deleteApplicationInstancesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteApplicationInstancesRequest, Operation>
      deleteApplicationInstancesCallable() {
    return stub.deleteApplicationInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds target stream input to the Application. If the Application is deployed, the corresponding
   * new Application instance will be created. If the stream has already been in the Application,
   * the RPC will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
   *   List<UpdateApplicationInstancesRequest.UpdateApplicationInstance> applicationInstances =
   *       new ArrayList<>();
   *   UpdateApplicationInstancesResponse response =
   *       appPlatformClient.updateApplicationInstancesAsync(name, applicationInstances).get();
   * }
   * }</pre>
   *
   * @param name Required. the name of the application to retrieve. Format:
   *     "projects/{project}/locations/{location}/applications/{application}"
   * @param applicationInstances
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UpdateApplicationInstancesResponse, OperationMetadata>
      updateApplicationInstancesAsync(
          ApplicationName name,
          List<UpdateApplicationInstancesRequest.UpdateApplicationInstance> applicationInstances) {
    UpdateApplicationInstancesRequest request =
        UpdateApplicationInstancesRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .addAllApplicationInstances(applicationInstances)
            .build();
    return updateApplicationInstancesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds target stream input to the Application. If the Application is deployed, the corresponding
   * new Application instance will be created. If the stream has already been in the Application,
   * the RPC will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   String name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString();
   *   List<UpdateApplicationInstancesRequest.UpdateApplicationInstance> applicationInstances =
   *       new ArrayList<>();
   *   UpdateApplicationInstancesResponse response =
   *       appPlatformClient.updateApplicationInstancesAsync(name, applicationInstances).get();
   * }
   * }</pre>
   *
   * @param name Required. the name of the application to retrieve. Format:
   *     "projects/{project}/locations/{location}/applications/{application}"
   * @param applicationInstances
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UpdateApplicationInstancesResponse, OperationMetadata>
      updateApplicationInstancesAsync(
          String name,
          List<UpdateApplicationInstancesRequest.UpdateApplicationInstance> applicationInstances) {
    UpdateApplicationInstancesRequest request =
        UpdateApplicationInstancesRequest.newBuilder()
            .setName(name)
            .addAllApplicationInstances(applicationInstances)
            .build();
    return updateApplicationInstancesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds target stream input to the Application. If the Application is deployed, the corresponding
   * new Application instance will be created. If the stream has already been in the Application,
   * the RPC will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   UpdateApplicationInstancesRequest request =
   *       UpdateApplicationInstancesRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .addAllApplicationInstances(
   *               new ArrayList<UpdateApplicationInstancesRequest.UpdateApplicationInstance>())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .build();
   *   UpdateApplicationInstancesResponse response =
   *       appPlatformClient.updateApplicationInstancesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UpdateApplicationInstancesResponse, OperationMetadata>
      updateApplicationInstancesAsync(UpdateApplicationInstancesRequest request) {
    return updateApplicationInstancesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds target stream input to the Application. If the Application is deployed, the corresponding
   * new Application instance will be created. If the stream has already been in the Application,
   * the RPC will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   UpdateApplicationInstancesRequest request =
   *       UpdateApplicationInstancesRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .addAllApplicationInstances(
   *               new ArrayList<UpdateApplicationInstancesRequest.UpdateApplicationInstance>())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .build();
   *   OperationFuture<UpdateApplicationInstancesResponse, OperationMetadata> future =
   *       appPlatformClient.updateApplicationInstancesOperationCallable().futureCall(request);
   *   // Do something.
   *   UpdateApplicationInstancesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateApplicationInstancesRequest, UpdateApplicationInstancesResponse, OperationMetadata>
      updateApplicationInstancesOperationCallable() {
    return stub.updateApplicationInstancesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds target stream input to the Application. If the Application is deployed, the corresponding
   * new Application instance will be created. If the stream has already been in the Application,
   * the RPC will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   UpdateApplicationInstancesRequest request =
   *       UpdateApplicationInstancesRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .addAllApplicationInstances(
   *               new ArrayList<UpdateApplicationInstancesRequest.UpdateApplicationInstance>())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       appPlatformClient.updateApplicationInstancesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateApplicationInstancesRequest, Operation>
      updateApplicationInstancesCallable() {
    return stub.updateApplicationInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Drafts in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ApplicationName parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
   *   for (Draft element : appPlatformClient.listDrafts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListDraftsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDraftsPagedResponse listDrafts(ApplicationName parent) {
    ListDraftsRequest request =
        ListDraftsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listDrafts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Drafts in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   String parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString();
   *   for (Draft element : appPlatformClient.listDrafts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListDraftsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDraftsPagedResponse listDrafts(String parent) {
    ListDraftsRequest request = ListDraftsRequest.newBuilder().setParent(parent).build();
    return listDrafts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Drafts in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ListDraftsRequest request =
   *       ListDraftsRequest.newBuilder()
   *           .setParent(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Draft element : appPlatformClient.listDrafts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDraftsPagedResponse listDrafts(ListDraftsRequest request) {
    return listDraftsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Drafts in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ListDraftsRequest request =
   *       ListDraftsRequest.newBuilder()
   *           .setParent(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Draft> future = appPlatformClient.listDraftsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Draft element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDraftsRequest, ListDraftsPagedResponse> listDraftsPagedCallable() {
    return stub.listDraftsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Drafts in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ListDraftsRequest request =
   *       ListDraftsRequest.newBuilder()
   *           .setParent(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDraftsResponse response = appPlatformClient.listDraftsCallable().call(request);
   *     for (Draft element : response.getDraftsList()) {
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
  public final UnaryCallable<ListDraftsRequest, ListDraftsResponse> listDraftsCallable() {
    return stub.listDraftsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Draft.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   DraftName name = DraftName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[DRAFT]");
   *   Draft response = appPlatformClient.getDraft(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Draft getDraft(DraftName name) {
    GetDraftRequest request =
        GetDraftRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDraft(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Draft.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   String name = DraftName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[DRAFT]").toString();
   *   Draft response = appPlatformClient.getDraft(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Draft getDraft(String name) {
    GetDraftRequest request = GetDraftRequest.newBuilder().setName(name).build();
    return getDraft(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Draft.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   GetDraftRequest request =
   *       GetDraftRequest.newBuilder()
   *           .setName(
   *               DraftName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[DRAFT]").toString())
   *           .build();
   *   Draft response = appPlatformClient.getDraft(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Draft getDraft(GetDraftRequest request) {
    return getDraftCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Draft.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   GetDraftRequest request =
   *       GetDraftRequest.newBuilder()
   *           .setName(
   *               DraftName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[DRAFT]").toString())
   *           .build();
   *   ApiFuture<Draft> future = appPlatformClient.getDraftCallable().futureCall(request);
   *   // Do something.
   *   Draft response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDraftRequest, Draft> getDraftCallable() {
    return stub.getDraftCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Draft in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ApplicationName parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
   *   Draft draft = Draft.newBuilder().build();
   *   String draftId = "draftId1912512156";
   *   Draft response = appPlatformClient.createDraftAsync(parent, draft, draftId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param draft Required. The resource being created.
   * @param draftId Required. Id of the requesting object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Draft, OperationMetadata> createDraftAsync(
      ApplicationName parent, Draft draft, String draftId) {
    CreateDraftRequest request =
        CreateDraftRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDraft(draft)
            .setDraftId(draftId)
            .build();
    return createDraftAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Draft in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   String parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString();
   *   Draft draft = Draft.newBuilder().build();
   *   String draftId = "draftId1912512156";
   *   Draft response = appPlatformClient.createDraftAsync(parent, draft, draftId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param draft Required. The resource being created.
   * @param draftId Required. Id of the requesting object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Draft, OperationMetadata> createDraftAsync(
      String parent, Draft draft, String draftId) {
    CreateDraftRequest request =
        CreateDraftRequest.newBuilder()
            .setParent(parent)
            .setDraft(draft)
            .setDraftId(draftId)
            .build();
    return createDraftAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Draft in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   CreateDraftRequest request =
   *       CreateDraftRequest.newBuilder()
   *           .setParent(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setDraftId("draftId1912512156")
   *           .setDraft(Draft.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Draft response = appPlatformClient.createDraftAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Draft, OperationMetadata> createDraftAsync(
      CreateDraftRequest request) {
    return createDraftOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Draft in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   CreateDraftRequest request =
   *       CreateDraftRequest.newBuilder()
   *           .setParent(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setDraftId("draftId1912512156")
   *           .setDraft(Draft.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Draft, OperationMetadata> future =
   *       appPlatformClient.createDraftOperationCallable().futureCall(request);
   *   // Do something.
   *   Draft response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateDraftRequest, Draft, OperationMetadata>
      createDraftOperationCallable() {
    return stub.createDraftOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Draft in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   CreateDraftRequest request =
   *       CreateDraftRequest.newBuilder()
   *           .setParent(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setDraftId("draftId1912512156")
   *           .setDraft(Draft.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = appPlatformClient.createDraftCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDraftRequest, Operation> createDraftCallable() {
    return stub.createDraftCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Draft.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   Draft draft = Draft.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Draft response = appPlatformClient.updateDraftAsync(draft, updateMask).get();
   * }
   * }</pre>
   *
   * @param draft Required. The resource being updated.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     Draft resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Draft, OperationMetadata> updateDraftAsync(
      Draft draft, FieldMask updateMask) {
    UpdateDraftRequest request =
        UpdateDraftRequest.newBuilder().setDraft(draft).setUpdateMask(updateMask).build();
    return updateDraftAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Draft.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   UpdateDraftRequest request =
   *       UpdateDraftRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDraft(Draft.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .build();
   *   Draft response = appPlatformClient.updateDraftAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Draft, OperationMetadata> updateDraftAsync(
      UpdateDraftRequest request) {
    return updateDraftOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Draft.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   UpdateDraftRequest request =
   *       UpdateDraftRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDraft(Draft.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .build();
   *   OperationFuture<Draft, OperationMetadata> future =
   *       appPlatformClient.updateDraftOperationCallable().futureCall(request);
   *   // Do something.
   *   Draft response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateDraftRequest, Draft, OperationMetadata>
      updateDraftOperationCallable() {
    return stub.updateDraftOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Draft.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   UpdateDraftRequest request =
   *       UpdateDraftRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDraft(Draft.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Operation> future = appPlatformClient.updateDraftCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDraftRequest, Operation> updateDraftCallable() {
    return stub.updateDraftCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Draft.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   DraftName name = DraftName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[DRAFT]");
   *   appPlatformClient.deleteDraftAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDraftAsync(DraftName name) {
    DeleteDraftRequest request =
        DeleteDraftRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteDraftAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Draft.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   String name = DraftName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[DRAFT]").toString();
   *   appPlatformClient.deleteDraftAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDraftAsync(String name) {
    DeleteDraftRequest request = DeleteDraftRequest.newBuilder().setName(name).build();
    return deleteDraftAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Draft.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   DeleteDraftRequest request =
   *       DeleteDraftRequest.newBuilder()
   *           .setName(
   *               DraftName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[DRAFT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   appPlatformClient.deleteDraftAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDraftAsync(
      DeleteDraftRequest request) {
    return deleteDraftOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Draft.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   DeleteDraftRequest request =
   *       DeleteDraftRequest.newBuilder()
   *           .setName(
   *               DraftName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[DRAFT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       appPlatformClient.deleteDraftOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDraftRequest, Empty, OperationMetadata>
      deleteDraftOperationCallable() {
    return stub.deleteDraftOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Draft.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   DeleteDraftRequest request =
   *       DeleteDraftRequest.newBuilder()
   *           .setName(
   *               DraftName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[DRAFT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = appPlatformClient.deleteDraftCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDraftRequest, Operation> deleteDraftCallable() {
    return stub.deleteDraftCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Processors in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Processor element : appPlatformClient.listProcessors(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListProcessorsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProcessorsPagedResponse listProcessors(LocationName parent) {
    ListProcessorsRequest request =
        ListProcessorsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listProcessors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Processors in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Processor element : appPlatformClient.listProcessors(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListProcessorsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProcessorsPagedResponse listProcessors(String parent) {
    ListProcessorsRequest request = ListProcessorsRequest.newBuilder().setParent(parent).build();
    return listProcessors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Processors in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ListProcessorsRequest request =
   *       ListProcessorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Processor element : appPlatformClient.listProcessors(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProcessorsPagedResponse listProcessors(ListProcessorsRequest request) {
    return listProcessorsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Processors in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ListProcessorsRequest request =
   *       ListProcessorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Processor> future =
   *       appPlatformClient.listProcessorsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Processor element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListProcessorsRequest, ListProcessorsPagedResponse>
      listProcessorsPagedCallable() {
    return stub.listProcessorsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Processors in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ListProcessorsRequest request =
   *       ListProcessorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListProcessorsResponse response = appPlatformClient.listProcessorsCallable().call(request);
   *     for (Processor element : response.getProcessorsList()) {
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
  public final UnaryCallable<ListProcessorsRequest, ListProcessorsResponse>
      listProcessorsCallable() {
    return stub.listProcessorsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ListPrebuiltProcessors is a custom pass-through verb that Lists Prebuilt Processors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListPrebuiltProcessorsResponse response = appPlatformClient.listPrebuiltProcessors(parent);
   * }
   * }</pre>
   *
   * @param parent Required. Parent path.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrebuiltProcessorsResponse listPrebuiltProcessors(LocationName parent) {
    ListPrebuiltProcessorsRequest request =
        ListPrebuiltProcessorsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPrebuiltProcessors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ListPrebuiltProcessors is a custom pass-through verb that Lists Prebuilt Processors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ListPrebuiltProcessorsResponse response = appPlatformClient.listPrebuiltProcessors(parent);
   * }
   * }</pre>
   *
   * @param parent Required. Parent path.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrebuiltProcessorsResponse listPrebuiltProcessors(String parent) {
    ListPrebuiltProcessorsRequest request =
        ListPrebuiltProcessorsRequest.newBuilder().setParent(parent).build();
    return listPrebuiltProcessors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ListPrebuiltProcessors is a custom pass-through verb that Lists Prebuilt Processors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ListPrebuiltProcessorsRequest request =
   *       ListPrebuiltProcessorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ListPrebuiltProcessorsResponse response = appPlatformClient.listPrebuiltProcessors(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrebuiltProcessorsResponse listPrebuiltProcessors(
      ListPrebuiltProcessorsRequest request) {
    return listPrebuiltProcessorsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ListPrebuiltProcessors is a custom pass-through verb that Lists Prebuilt Processors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ListPrebuiltProcessorsRequest request =
   *       ListPrebuiltProcessorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<ListPrebuiltProcessorsResponse> future =
   *       appPlatformClient.listPrebuiltProcessorsCallable().futureCall(request);
   *   // Do something.
   *   ListPrebuiltProcessorsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPrebuiltProcessorsRequest, ListPrebuiltProcessorsResponse>
      listPrebuiltProcessorsCallable() {
    return stub.listPrebuiltProcessorsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   Processor response = appPlatformClient.getProcessor(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Processor getProcessor(ProcessorName name) {
    GetProcessorRequest request =
        GetProcessorRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getProcessor(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   String name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString();
   *   Processor response = appPlatformClient.getProcessor(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Processor getProcessor(String name) {
    GetProcessorRequest request = GetProcessorRequest.newBuilder().setName(name).build();
    return getProcessor(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   GetProcessorRequest request =
   *       GetProcessorRequest.newBuilder()
   *           .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .build();
   *   Processor response = appPlatformClient.getProcessor(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Processor getProcessor(GetProcessorRequest request) {
    return getProcessorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   GetProcessorRequest request =
   *       GetProcessorRequest.newBuilder()
   *           .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .build();
   *   ApiFuture<Processor> future = appPlatformClient.getProcessorCallable().futureCall(request);
   *   // Do something.
   *   Processor response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetProcessorRequest, Processor> getProcessorCallable() {
    return stub.getProcessorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Processor in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Processor processor = Processor.newBuilder().build();
   *   String processorId = "processorId203323725";
   *   Processor response =
   *       appPlatformClient.createProcessorAsync(parent, processor, processorId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param processor Required. The resource being created.
   * @param processorId Required. Id of the requesting object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Processor, OperationMetadata> createProcessorAsync(
      LocationName parent, Processor processor, String processorId) {
    CreateProcessorRequest request =
        CreateProcessorRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setProcessor(processor)
            .setProcessorId(processorId)
            .build();
    return createProcessorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Processor in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Processor processor = Processor.newBuilder().build();
   *   String processorId = "processorId203323725";
   *   Processor response =
   *       appPlatformClient.createProcessorAsync(parent, processor, processorId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param processor Required. The resource being created.
   * @param processorId Required. Id of the requesting object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Processor, OperationMetadata> createProcessorAsync(
      String parent, Processor processor, String processorId) {
    CreateProcessorRequest request =
        CreateProcessorRequest.newBuilder()
            .setParent(parent)
            .setProcessor(processor)
            .setProcessorId(processorId)
            .build();
    return createProcessorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Processor in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   CreateProcessorRequest request =
   *       CreateProcessorRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setProcessorId("processorId203323725")
   *           .setProcessor(Processor.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Processor response = appPlatformClient.createProcessorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Processor, OperationMetadata> createProcessorAsync(
      CreateProcessorRequest request) {
    return createProcessorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Processor in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   CreateProcessorRequest request =
   *       CreateProcessorRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setProcessorId("processorId203323725")
   *           .setProcessor(Processor.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Processor, OperationMetadata> future =
   *       appPlatformClient.createProcessorOperationCallable().futureCall(request);
   *   // Do something.
   *   Processor response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateProcessorRequest, Processor, OperationMetadata>
      createProcessorOperationCallable() {
    return stub.createProcessorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Processor in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   CreateProcessorRequest request =
   *       CreateProcessorRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setProcessorId("processorId203323725")
   *           .setProcessor(Processor.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = appPlatformClient.createProcessorCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateProcessorRequest, Operation> createProcessorCallable() {
    return stub.createProcessorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   Processor processor = Processor.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Processor response = appPlatformClient.updateProcessorAsync(processor, updateMask).get();
   * }
   * }</pre>
   *
   * @param processor Required. The resource being updated.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     Processor resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Processor, OperationMetadata> updateProcessorAsync(
      Processor processor, FieldMask updateMask) {
    UpdateProcessorRequest request =
        UpdateProcessorRequest.newBuilder()
            .setProcessor(processor)
            .setUpdateMask(updateMask)
            .build();
    return updateProcessorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   UpdateProcessorRequest request =
   *       UpdateProcessorRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setProcessor(Processor.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Processor response = appPlatformClient.updateProcessorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Processor, OperationMetadata> updateProcessorAsync(
      UpdateProcessorRequest request) {
    return updateProcessorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   UpdateProcessorRequest request =
   *       UpdateProcessorRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setProcessor(Processor.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Processor, OperationMetadata> future =
   *       appPlatformClient.updateProcessorOperationCallable().futureCall(request);
   *   // Do something.
   *   Processor response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateProcessorRequest, Processor, OperationMetadata>
      updateProcessorOperationCallable() {
    return stub.updateProcessorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   UpdateProcessorRequest request =
   *       UpdateProcessorRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setProcessor(Processor.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = appPlatformClient.updateProcessorCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateProcessorRequest, Operation> updateProcessorCallable() {
    return stub.updateProcessorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   appPlatformClient.deleteProcessorAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteProcessorAsync(ProcessorName name) {
    DeleteProcessorRequest request =
        DeleteProcessorRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteProcessorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   String name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString();
   *   appPlatformClient.deleteProcessorAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteProcessorAsync(String name) {
    DeleteProcessorRequest request = DeleteProcessorRequest.newBuilder().setName(name).build();
    return deleteProcessorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   DeleteProcessorRequest request =
   *       DeleteProcessorRequest.newBuilder()
   *           .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   appPlatformClient.deleteProcessorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteProcessorAsync(
      DeleteProcessorRequest request) {
    return deleteProcessorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   DeleteProcessorRequest request =
   *       DeleteProcessorRequest.newBuilder()
   *           .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       appPlatformClient.deleteProcessorOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteProcessorRequest, Empty, OperationMetadata>
      deleteProcessorOperationCallable() {
    return stub.deleteProcessorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
   *   DeleteProcessorRequest request =
   *       DeleteProcessorRequest.newBuilder()
   *           .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = appPlatformClient.deleteProcessorCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteProcessorRequest, Operation> deleteProcessorCallable() {
    return stub.deleteProcessorCallable();
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

  public static class ListApplicationsPagedResponse
      extends AbstractPagedListResponse<
          ListApplicationsRequest,
          ListApplicationsResponse,
          Application,
          ListApplicationsPage,
          ListApplicationsFixedSizeCollection> {

    public static ApiFuture<ListApplicationsPagedResponse> createAsync(
        PageContext<ListApplicationsRequest, ListApplicationsResponse, Application> context,
        ApiFuture<ListApplicationsResponse> futureResponse) {
      ApiFuture<ListApplicationsPage> futurePage =
          ListApplicationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListApplicationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListApplicationsPagedResponse(ListApplicationsPage page) {
      super(page, ListApplicationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListApplicationsPage
      extends AbstractPage<
          ListApplicationsRequest, ListApplicationsResponse, Application, ListApplicationsPage> {

    private ListApplicationsPage(
        PageContext<ListApplicationsRequest, ListApplicationsResponse, Application> context,
        ListApplicationsResponse response) {
      super(context, response);
    }

    private static ListApplicationsPage createEmptyPage() {
      return new ListApplicationsPage(null, null);
    }

    @Override
    protected ListApplicationsPage createPage(
        PageContext<ListApplicationsRequest, ListApplicationsResponse, Application> context,
        ListApplicationsResponse response) {
      return new ListApplicationsPage(context, response);
    }

    @Override
    public ApiFuture<ListApplicationsPage> createPageAsync(
        PageContext<ListApplicationsRequest, ListApplicationsResponse, Application> context,
        ApiFuture<ListApplicationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListApplicationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListApplicationsRequest,
          ListApplicationsResponse,
          Application,
          ListApplicationsPage,
          ListApplicationsFixedSizeCollection> {

    private ListApplicationsFixedSizeCollection(
        List<ListApplicationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListApplicationsFixedSizeCollection createEmptyCollection() {
      return new ListApplicationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListApplicationsFixedSizeCollection createCollection(
        List<ListApplicationsPage> pages, int collectionSize) {
      return new ListApplicationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListInstancesPagedResponse
      extends AbstractPagedListResponse<
          ListInstancesRequest,
          ListInstancesResponse,
          Instance,
          ListInstancesPage,
          ListInstancesFixedSizeCollection> {

    public static ApiFuture<ListInstancesPagedResponse> createAsync(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ApiFuture<ListInstancesResponse> futureResponse) {
      ApiFuture<ListInstancesPage> futurePage =
          ListInstancesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListInstancesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListInstancesPagedResponse(ListInstancesPage page) {
      super(page, ListInstancesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInstancesPage
      extends AbstractPage<
          ListInstancesRequest, ListInstancesResponse, Instance, ListInstancesPage> {

    private ListInstancesPage(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ListInstancesResponse response) {
      super(context, response);
    }

    private static ListInstancesPage createEmptyPage() {
      return new ListInstancesPage(null, null);
    }

    @Override
    protected ListInstancesPage createPage(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ListInstancesResponse response) {
      return new ListInstancesPage(context, response);
    }

    @Override
    public ApiFuture<ListInstancesPage> createPageAsync(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ApiFuture<ListInstancesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInstancesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstancesRequest,
          ListInstancesResponse,
          Instance,
          ListInstancesPage,
          ListInstancesFixedSizeCollection> {

    private ListInstancesFixedSizeCollection(List<ListInstancesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInstancesFixedSizeCollection createEmptyCollection() {
      return new ListInstancesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInstancesFixedSizeCollection createCollection(
        List<ListInstancesPage> pages, int collectionSize) {
      return new ListInstancesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDraftsPagedResponse
      extends AbstractPagedListResponse<
          ListDraftsRequest,
          ListDraftsResponse,
          Draft,
          ListDraftsPage,
          ListDraftsFixedSizeCollection> {

    public static ApiFuture<ListDraftsPagedResponse> createAsync(
        PageContext<ListDraftsRequest, ListDraftsResponse, Draft> context,
        ApiFuture<ListDraftsResponse> futureResponse) {
      ApiFuture<ListDraftsPage> futurePage =
          ListDraftsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListDraftsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListDraftsPagedResponse(ListDraftsPage page) {
      super(page, ListDraftsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDraftsPage
      extends AbstractPage<ListDraftsRequest, ListDraftsResponse, Draft, ListDraftsPage> {

    private ListDraftsPage(
        PageContext<ListDraftsRequest, ListDraftsResponse, Draft> context,
        ListDraftsResponse response) {
      super(context, response);
    }

    private static ListDraftsPage createEmptyPage() {
      return new ListDraftsPage(null, null);
    }

    @Override
    protected ListDraftsPage createPage(
        PageContext<ListDraftsRequest, ListDraftsResponse, Draft> context,
        ListDraftsResponse response) {
      return new ListDraftsPage(context, response);
    }

    @Override
    public ApiFuture<ListDraftsPage> createPageAsync(
        PageContext<ListDraftsRequest, ListDraftsResponse, Draft> context,
        ApiFuture<ListDraftsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDraftsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDraftsRequest,
          ListDraftsResponse,
          Draft,
          ListDraftsPage,
          ListDraftsFixedSizeCollection> {

    private ListDraftsFixedSizeCollection(List<ListDraftsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDraftsFixedSizeCollection createEmptyCollection() {
      return new ListDraftsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDraftsFixedSizeCollection createCollection(
        List<ListDraftsPage> pages, int collectionSize) {
      return new ListDraftsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListProcessorsPagedResponse
      extends AbstractPagedListResponse<
          ListProcessorsRequest,
          ListProcessorsResponse,
          Processor,
          ListProcessorsPage,
          ListProcessorsFixedSizeCollection> {

    public static ApiFuture<ListProcessorsPagedResponse> createAsync(
        PageContext<ListProcessorsRequest, ListProcessorsResponse, Processor> context,
        ApiFuture<ListProcessorsResponse> futureResponse) {
      ApiFuture<ListProcessorsPage> futurePage =
          ListProcessorsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListProcessorsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListProcessorsPagedResponse(ListProcessorsPage page) {
      super(page, ListProcessorsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListProcessorsPage
      extends AbstractPage<
          ListProcessorsRequest, ListProcessorsResponse, Processor, ListProcessorsPage> {

    private ListProcessorsPage(
        PageContext<ListProcessorsRequest, ListProcessorsResponse, Processor> context,
        ListProcessorsResponse response) {
      super(context, response);
    }

    private static ListProcessorsPage createEmptyPage() {
      return new ListProcessorsPage(null, null);
    }

    @Override
    protected ListProcessorsPage createPage(
        PageContext<ListProcessorsRequest, ListProcessorsResponse, Processor> context,
        ListProcessorsResponse response) {
      return new ListProcessorsPage(context, response);
    }

    @Override
    public ApiFuture<ListProcessorsPage> createPageAsync(
        PageContext<ListProcessorsRequest, ListProcessorsResponse, Processor> context,
        ApiFuture<ListProcessorsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListProcessorsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListProcessorsRequest,
          ListProcessorsResponse,
          Processor,
          ListProcessorsPage,
          ListProcessorsFixedSizeCollection> {

    private ListProcessorsFixedSizeCollection(List<ListProcessorsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListProcessorsFixedSizeCollection createEmptyCollection() {
      return new ListProcessorsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListProcessorsFixedSizeCollection createCollection(
        List<ListProcessorsPage> pages, int collectionSize) {
      return new ListProcessorsFixedSizeCollection(pages, collectionSize);
    }
  }
}
