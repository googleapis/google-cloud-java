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

package com.google.cloud.designcenter.v1;

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
import com.google.cloud.designcenter.v1.stub.DesignCenterStub;
import com.google.cloud.designcenter.v1.stub.DesignCenterStubSettings;
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
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

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
 * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
 *   SpaceName name = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
 *   Space response = designCenterClient.getSpace(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DesignCenterClient object to clean up resources such
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
 *      <td><p> GetSpace</td>
 *      <td><p> Gets details about a space.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSpace(GetSpaceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSpace(SpaceName name)
 *           <li><p> getSpace(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSpaceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSpaces</td>
 *      <td><p> Lists spaces in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSpaces(ListSpacesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSpaces(LocationName parent)
 *           <li><p> listSpaces(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSpacesPagedCallable()
 *           <li><p> listSpacesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSpace</td>
 *      <td><p> Creates a space.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSpace(CreateSpaceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSpace(LocationName parent, Space space, String spaceId)
 *           <li><p> createSpace(String parent, Space space, String spaceId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSpaceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSpace</td>
 *      <td><p> Updates a space.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSpace(UpdateSpaceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSpace(Space space, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSpaceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSpace</td>
 *      <td><p> Deletes a space.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSpace(DeleteSpaceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteSpace(SpaceName name)
 *           <li><p> deleteSpace(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSpaceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetApplicationTemplate</td>
 *      <td><p> Gets details about an application template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getApplicationTemplate(GetApplicationTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getApplicationTemplate(ApplicationTemplateName name)
 *           <li><p> getApplicationTemplate(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getApplicationTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListApplicationTemplates</td>
 *      <td><p> Lists application templates in a given space.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listApplicationTemplates(ListApplicationTemplatesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listApplicationTemplates(SpaceName parent)
 *           <li><p> listApplicationTemplates(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listApplicationTemplatesPagedCallable()
 *           <li><p> listApplicationTemplatesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateApplicationTemplate</td>
 *      <td><p> Creates an application template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createApplicationTemplate(CreateApplicationTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createApplicationTemplate(SpaceName parent, ApplicationTemplate applicationTemplate, String applicationTemplateId)
 *           <li><p> createApplicationTemplate(String parent, ApplicationTemplate applicationTemplate, String applicationTemplateId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createApplicationTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateApplicationTemplate</td>
 *      <td><p> Updates an application template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateApplicationTemplate(UpdateApplicationTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateApplicationTemplate(ApplicationTemplate applicationTemplate, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateApplicationTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ImportApplicationTemplate</td>
 *      <td><p> Imports to an existing application template from a given shared template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> importApplicationTemplate(ImportApplicationTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> importApplicationTemplate(ApplicationTemplateName name, ApplicationTemplateRevisionName applicationTemplateRevisionUri)
 *           <li><p> importApplicationTemplate(ApplicationTemplateName name, String applicationTemplateRevisionUri)
 *           <li><p> importApplicationTemplate(String name, ApplicationTemplateRevisionName applicationTemplateRevisionUri)
 *           <li><p> importApplicationTemplate(String name, String applicationTemplateRevisionUri)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> importApplicationTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteApplicationTemplate</td>
 *      <td><p> Deletes an application template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteApplicationTemplate(DeleteApplicationTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteApplicationTemplate(ApplicationTemplateName name)
 *           <li><p> deleteApplicationTemplate(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteApplicationTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CommitApplicationTemplate</td>
 *      <td><p> Commits an application template to create a new revision.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> commitApplicationTemplate(CommitApplicationTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> commitApplicationTemplate(ApplicationTemplateName name)
 *           <li><p> commitApplicationTemplate(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> commitApplicationTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SnapshotApplicationTemplate</td>
 *      <td><p> Snapshots an application template to create a new revision asynchronously.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> snapshotApplicationTemplateAsync(SnapshotApplicationTemplateRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> snapshotApplicationTemplateAsync(ApplicationTemplateName name)
 *           <li><p> snapshotApplicationTemplateAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> snapshotApplicationTemplateOperationCallable()
 *           <li><p> snapshotApplicationTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateApplicationTemplateIaC</td>
 *      <td><p> Generates Terraform files for an application template. This is a SYNCHRONOUS operation and returns the generated IaC directly in the response. It does NOT download external module sources; it only uses remote sources.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateApplicationTemplateIaC(GenerateApplicationTemplateIaCRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> generateApplicationTemplateIaC(ApplicationTemplateName name)
 *           <li><p> generateApplicationTemplateIaC(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateApplicationTemplateIaCCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportApplicationTemplateIaC</td>
 *      <td><p> Exports Terraform files for an application template. The generated modules can have remote sources or local sources downloaded from remote. This is an ASYNCHRONOUS operation that returns a Long Running Operation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportApplicationTemplateIaCAsync(ExportApplicationTemplateIaCRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> exportApplicationTemplateIaCAsync(ApplicationTemplateName name)
 *           <li><p> exportApplicationTemplateIaCAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportApplicationTemplateIaCOperationCallable()
 *           <li><p> exportApplicationTemplateIaCCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateApplicationTemplateRevisionIaC</td>
 *      <td><p> Generates Terraform files for an application template revision. This is a SYNCHRONOUS operation and returns the generated IaC directly in the response. It does NOT download external module sources; it only uses remote sources.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateApplicationTemplateRevisionIaC(GenerateApplicationTemplateRevisionIaCRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> generateApplicationTemplateRevisionIaC(ApplicationTemplateRevisionName name)
 *           <li><p> generateApplicationTemplateRevisionIaC(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateApplicationTemplateRevisionIaCCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportApplicationTemplateRevisionIaC</td>
 *      <td><p> Exports Terraform files for an application template revision. The generated modules can have remote sources or local sources downloaded from remote. This is an ASYNCHRONOUS operation that returns a Long Running Operation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportApplicationTemplateRevisionIaCAsync(ExportApplicationTemplateRevisionIaCRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> exportApplicationTemplateRevisionIaCAsync(ApplicationTemplateRevisionName name)
 *           <li><p> exportApplicationTemplateRevisionIaCAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportApplicationTemplateRevisionIaCOperationCallable()
 *           <li><p> exportApplicationTemplateRevisionIaCCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetComponent</td>
 *      <td><p> Gets details about a Component.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getComponent(GetComponentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getComponent(ComponentName name)
 *           <li><p> getComponent(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getComponentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListComponents</td>
 *      <td><p> Lists components in an application template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listComponents(ListComponentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listComponents(ApplicationTemplateName parent)
 *           <li><p> listComponents(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listComponentsPagedCallable()
 *           <li><p> listComponentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateComponent</td>
 *      <td><p> Creates a component.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createComponent(CreateComponentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createComponent(ApplicationTemplateName parent, Component component, String componentId)
 *           <li><p> createComponent(String parent, Component component, String componentId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createComponentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateComponent</td>
 *      <td><p> Updates a component.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateComponent(UpdateComponentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateComponent(Component component, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateComponentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteComponent</td>
 *      <td><p> Deletes a component.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteComponent(DeleteComponentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteComponent(ComponentName name)
 *           <li><p> deleteComponent(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteComponentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetConnection</td>
 *      <td><p> Gets details about a connection.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getConnection(GetConnectionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getConnection(ConnectionName name)
 *           <li><p> getConnection(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getConnectionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListConnections</td>
 *      <td><p> Lists connections in an application template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listConnections(ListConnectionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listConnections(ComponentName parent)
 *           <li><p> listConnections(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listConnectionsPagedCallable()
 *           <li><p> listConnectionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateConnection</td>
 *      <td><p> Creates a connection.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createConnection(CreateConnectionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createConnection(ComponentName parent, Connection connection, String connectionId)
 *           <li><p> createConnection(String parent, Connection connection, String connectionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createConnectionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateConnection</td>
 *      <td><p> Updates a connection.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateConnection(UpdateConnectionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateConnection(Connection connection, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateConnectionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteConnection</td>
 *      <td><p> Deletes a connection.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteConnection(DeleteConnectionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteConnection(ConnectionName name)
 *           <li><p> deleteConnection(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteConnectionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetApplicationTemplateRevision</td>
 *      <td><p> Gets details about an application template revision.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getApplicationTemplateRevision(GetApplicationTemplateRevisionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getApplicationTemplateRevision(ApplicationTemplateRevisionName name)
 *           <li><p> getApplicationTemplateRevision(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getApplicationTemplateRevisionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListApplicationTemplateRevisions</td>
 *      <td><p> Lists application template revisions in a given application template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listApplicationTemplateRevisions(ListApplicationTemplateRevisionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listApplicationTemplateRevisions(ApplicationTemplateName parent)
 *           <li><p> listApplicationTemplateRevisions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listApplicationTemplateRevisionsPagedCallable()
 *           <li><p> listApplicationTemplateRevisionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteApplicationTemplateRevision</td>
 *      <td><p> Deletes an application template revision.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteApplicationTemplateRevision(DeleteApplicationTemplateRevisionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteApplicationTemplateRevision(ApplicationTemplateRevisionName name)
 *           <li><p> deleteApplicationTemplateRevision(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteApplicationTemplateRevisionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCatalog</td>
 *      <td><p> Gets details about a catalog.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCatalog(GetCatalogRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCatalog(CatalogName name)
 *           <li><p> getCatalog(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCatalogCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCatalogs</td>
 *      <td><p> Lists catalogs in a given space.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCatalogs(ListCatalogsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCatalogs(SpaceName parent)
 *           <li><p> listCatalogs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCatalogsPagedCallable()
 *           <li><p> listCatalogsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCatalog</td>
 *      <td><p> Creates a catalog.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCatalog(CreateCatalogRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createCatalog(SpaceName parent, Catalog catalog, String catalogId)
 *           <li><p> createCatalog(String parent, Catalog catalog, String catalogId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCatalogCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCatalog</td>
 *      <td><p> Updates a catalog.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateCatalog(UpdateCatalogRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateCatalog(Catalog catalog, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateCatalogCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCatalog</td>
 *      <td><p> Deletes a catalog.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteCatalogAsync(DeleteCatalogRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteCatalogAsync(CatalogName name)
 *           <li><p> deleteCatalogAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCatalogOperationCallable()
 *           <li><p> deleteCatalogCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCatalogTemplate</td>
 *      <td><p> Adds a template to a catalog.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCatalogTemplate(CreateCatalogTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createCatalogTemplate(CatalogName parent, CatalogTemplate catalogTemplate, String catalogTemplateId)
 *           <li><p> createCatalogTemplate(String parent, CatalogTemplate catalogTemplate, String catalogTemplateId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCatalogTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCatalogTemplate</td>
 *      <td><p> Gets a catalog template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCatalogTemplate(GetCatalogTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCatalogTemplate(CatalogTemplateName name)
 *           <li><p> getCatalogTemplate(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCatalogTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCatalogTemplates</td>
 *      <td><p> Lists catalog templates.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCatalogTemplates(ListCatalogTemplatesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCatalogTemplates(CatalogName parent)
 *           <li><p> listCatalogTemplates(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCatalogTemplatesPagedCallable()
 *           <li><p> listCatalogTemplatesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCatalogTemplate</td>
 *      <td><p> Updates a catalog template resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateCatalogTemplate(UpdateCatalogTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateCatalogTemplate(CatalogTemplate catalogTemplate, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateCatalogTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCatalogTemplate</td>
 *      <td><p> Deletes a catalog template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteCatalogTemplateAsync(DeleteCatalogTemplateRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteCatalogTemplateAsync(CatalogTemplateName name)
 *           <li><p> deleteCatalogTemplateAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCatalogTemplateOperationCallable()
 *           <li><p> deleteCatalogTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateShare</td>
 *      <td><p> Shares a catalog from one space to another space.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createShareAsync(CreateShareRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createShareAsync(CatalogName parent, Share share, String shareId)
 *           <li><p> createShareAsync(String parent, Share share, String shareId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createShareOperationCallable()
 *           <li><p> createShareCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListShares</td>
 *      <td><p> Lists catalog share objects for the space.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listShares(ListSharesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listShares(CatalogName parent)
 *           <li><p> listShares(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSharesPagedCallable()
 *           <li><p> listSharesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetShare</td>
 *      <td><p> Get catalog share object for the space.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getShare(GetShareRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getShare(ShareName name)
 *           <li><p> getShare(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getShareCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteShare</td>
 *      <td><p> Deletes a catalog share.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteShareAsync(DeleteShareRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteShareAsync(ShareName name)
 *           <li><p> deleteShareAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteShareOperationCallable()
 *           <li><p> deleteShareCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SyncShare</td>
 *      <td><p> Synchronizes a share and updates the destination workspace to reflect. reflect the most recent changes to the catalog.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> syncShareAsync(SyncShareRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> syncShareAsync(ShareName name)
 *           <li><p> syncShareAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> syncShareOperationCallable()
 *           <li><p> syncShareCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSharedTemplate</td>
 *      <td><p> Gets details about a shared template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSharedTemplate(GetSharedTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSharedTemplate(SharedTemplateName name)
 *           <li><p> getSharedTemplate(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSharedTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSharedTemplates</td>
 *      <td><p> Lists shared templates in a given space.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSharedTemplates(ListSharedTemplatesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSharedTemplates(SpaceName parent)
 *           <li><p> listSharedTemplates(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSharedTemplatesPagedCallable()
 *           <li><p> listSharedTemplatesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSharedTemplateRevision</td>
 *      <td><p> Gets details about a shared template revision.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSharedTemplateRevision(GetSharedTemplateRevisionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSharedTemplateRevision(SharedTemplateRevisionName name)
 *           <li><p> getSharedTemplateRevision(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSharedTemplateRevisionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSharedTemplateRevisions</td>
 *      <td><p> Lists shared template revisions in a given space.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSharedTemplateRevisions(ListSharedTemplateRevisionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSharedTemplateRevisions(SharedTemplateName parent)
 *           <li><p> listSharedTemplateRevisions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSharedTemplateRevisionsPagedCallable()
 *           <li><p> listSharedTemplateRevisionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCatalogTemplateRevision</td>
 *      <td><p> Creates a template revision.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCatalogTemplateRevisionAsync(CreateCatalogTemplateRevisionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createCatalogTemplateRevisionAsync(CatalogTemplateName parent, CatalogTemplateRevision catalogTemplateRevision, String catalogTemplateRevisionId)
 *           <li><p> createCatalogTemplateRevisionAsync(String parent, CatalogTemplateRevision catalogTemplateRevision, String catalogTemplateRevisionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCatalogTemplateRevisionOperationCallable()
 *           <li><p> createCatalogTemplateRevisionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCatalogTemplateRevision</td>
 *      <td><p> Gets details about a template revision.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCatalogTemplateRevision(GetCatalogTemplateRevisionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCatalogTemplateRevision(CatalogTemplateRevisionName name)
 *           <li><p> getCatalogTemplateRevision(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCatalogTemplateRevisionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCatalogTemplateRevisions</td>
 *      <td><p> Lists template revisions.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCatalogTemplateRevisions(ListCatalogTemplateRevisionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCatalogTemplateRevisions(CatalogTemplateName parent)
 *           <li><p> listCatalogTemplateRevisions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCatalogTemplateRevisionsPagedCallable()
 *           <li><p> listCatalogTemplateRevisionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCatalogTemplateRevision</td>
 *      <td><p> Deletes a template revision.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteCatalogTemplateRevisionAsync(DeleteCatalogTemplateRevisionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteCatalogTemplateRevisionAsync(CatalogTemplateRevisionName name)
 *           <li><p> deleteCatalogTemplateRevisionAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCatalogTemplateRevisionOperationCallable()
 *           <li><p> deleteCatalogTemplateRevisionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateApplication</td>
 *      <td><p> Creates an application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createApplication(CreateApplicationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createApplication(SpaceName parent, Application application, String applicationId)
 *           <li><p> createApplication(String parent, Application application, String applicationId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createApplicationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetApplication</td>
 *      <td><p> Gets details about an application.</td>
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
 *      <td><p> ListApplications</td>
 *      <td><p> Lists applications in a given space.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listApplications(ListApplicationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listApplications(SpaceName parent)
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
 *      <td><p> UpdateApplication</td>
 *      <td><p> Updates an application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateApplication(UpdateApplicationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateApplication(Application application, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateApplicationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteApplication</td>
 *      <td><p> Deletes an application.</td>
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
 *      <td><p> Deploys an application.</td>
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
 *      <td><p> PreviewApplication</td>
 *      <td><p> Previews deployment of an application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> previewApplicationAsync(PreviewApplicationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> previewApplicationAsync(ApplicationName name)
 *           <li><p> previewApplicationAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> previewApplicationOperationCallable()
 *           <li><p> previewApplicationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchApplicationAssessmentReport</td>
 *      <td><p> Fetches the assessment report of a deployed application if present.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchApplicationAssessmentReport(FetchApplicationAssessmentReportRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> fetchApplicationAssessmentReport(ApplicationName name)
 *           <li><p> fetchApplicationAssessmentReport(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchApplicationAssessmentReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateApplicationAssessmentReport</td>
 *      <td><p> Generate Assessment Reports of an application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateApplicationAssessmentReportAsync(GenerateApplicationAssessmentReportRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> generateApplicationAssessmentReportAsync(ApplicationName name)
 *           <li><p> generateApplicationAssessmentReportAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateApplicationAssessmentReportOperationCallable()
 *           <li><p> generateApplicationAssessmentReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateApplicationTemplateAssessmentReport</td>
 *      <td><p> Generate Assessment Reports of an application template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateApplicationTemplateAssessmentReportAsync(GenerateApplicationTemplateAssessmentReportRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> generateApplicationTemplateAssessmentReportAsync(ApplicationTemplateName name)
 *           <li><p> generateApplicationTemplateAssessmentReportAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateApplicationTemplateAssessmentReportOperationCallable()
 *           <li><p> generateApplicationTemplateAssessmentReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateAssessmentReport</td>
 *      <td><p> Deprecated: Use GenerateTerraformPlanAssessmentReport instead.
 * <p>  Generate a best practice report for a given Terraform plan.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateAssessmentReportAsync(GenerateAssessmentReportRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> generateAssessmentReportAsync(SpaceName spaceName)
 *           <li><p> generateAssessmentReportAsync(String spaceName)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateAssessmentReportOperationCallable()
 *           <li><p> generateAssessmentReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateTerraformPlanAssessmentReport</td>
 *      <td><p> Generate a Terraform plan assessment report for a given Terraform plan.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateTerraformPlanAssessmentReportAsync(GenerateTerraformPlanAssessmentReportRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> generateTerraformPlanAssessmentReportAsync(SpaceName name, ByteString terraformPlan)
 *           <li><p> generateTerraformPlanAssessmentReportAsync(String name, ByteString terraformPlan)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateTerraformPlanAssessmentReportOperationCallable()
 *           <li><p> generateTerraformPlanAssessmentReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPolicy</td>
 *      <td><p> Policy related APIs. Get a policy for an application template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPolicy(GetPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPolicy(PolicyName name)
 *           <li><p> getPolicy(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPolicies</td>
 *      <td><p> Lists policies for an application template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPolicies(ListPoliciesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPolicies(ApplicationTemplateName parent)
 *           <li><p> listPolicies(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPoliciesPagedCallable()
 *           <li><p> listPoliciesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreatePolicy</td>
 *      <td><p> Creates a policy for an application template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createPolicy(CreatePolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createPolicy(ApplicationTemplateName parent, Policy policy, String policyId)
 *           <li><p> createPolicy(String parent, Policy policy, String policyId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdatePolicy</td>
 *      <td><p> Updates a policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updatePolicy(UpdatePolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updatePolicy(Policy policy, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updatePolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeletePolicy</td>
 *      <td><p> Deletes a policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deletePolicy(DeletePolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deletePolicy(PolicyName name)
 *           <li><p> deletePolicy(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deletePolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchFrameworks</td>
 *      <td><p> Fetches all frameworks for assessment report.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchFrameworks(FetchFrameworksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> fetchFrameworks(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchFrameworksPagedCallable()
 *           <li><p> fetchFrameworksCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateApplicationIaC</td>
 *      <td><p> Generates Terraform files for an application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateApplicationIaC(GenerateApplicationIaCRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> generateApplicationIaC(ApplicationName name)
 *           <li><p> generateApplicationIaC(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateApplicationIaCCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportApplicationIaC</td>
 *      <td><p> Exports Terraform files for an application asynchronously.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportApplicationIaCAsync(ExportApplicationIaCRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> exportApplicationIaCAsync(ApplicationName name)
 *           <li><p> exportApplicationIaCAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportApplicationIaCOperationCallable()
 *           <li><p> exportApplicationIaCCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ImportApplicationTemplateIaC</td>
 *      <td><p> Imports IaC for an application template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> importApplicationTemplateIaC(ImportApplicationTemplateIaCRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> importApplicationTemplateIaC(ApplicationTemplateName name)
 *           <li><p> importApplicationTemplateIaC(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> importApplicationTemplateIaCCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> IngestApplicationTemplateIaC</td>
 *      <td><p> Ingests IaC for an application template asynchronously.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> ingestApplicationTemplateIaCAsync(IngestApplicationTemplateIaCRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> ingestApplicationTemplateIaCAsync(ApplicationTemplateName name)
 *           <li><p> ingestApplicationTemplateIaCAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> ingestApplicationTemplateIaCOperationCallable()
 *           <li><p> ingestApplicationTemplateIaCCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ImportApplicationIaC</td>
 *      <td><p> Imports IaC for an application resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> importApplicationIaC(ImportApplicationIaCRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> importApplicationIaC(ApplicationName name)
 *           <li><p> importApplicationIaC(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> importApplicationIaCCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RegisterAppHubApplicationResources</td>
 *      <td><p> Register deployed resources from terraform state file with App Hub without needing a space.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> registerAppHubApplicationResourcesAsync(RegisterAppHubApplicationResourcesRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> registerAppHubApplicationResourcesAsync(LocationName parent, String apphubApplication, String tfstateContent)
 *           <li><p> registerAppHubApplicationResourcesAsync(String parent, String apphubApplication, String tfstateContent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> registerAppHubApplicationResourcesOperationCallable()
 *           <li><p> registerAppHubApplicationResourcesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListApplicationTemplateSystemRevisions</td>
 *      <td><p> Lists application template system revisions in a given application template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listApplicationTemplateSystemRevisions(ListApplicationTemplateSystemRevisionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listApplicationTemplateSystemRevisions(ApplicationTemplateName parent)
 *           <li><p> listApplicationTemplateSystemRevisions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listApplicationTemplateSystemRevisionsPagedCallable()
 *           <li><p> listApplicationTemplateSystemRevisionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetApplicationTemplateSystemRevision</td>
 *      <td><p> Gets the given application template system revision.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getApplicationTemplateSystemRevision(GetApplicationTemplateSystemRevisionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getApplicationTemplateSystemRevision(ApplicationTemplateSystemRevisionName name)
 *           <li><p> getApplicationTemplateSystemRevision(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getApplicationTemplateSystemRevisionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RecommendIAMRoles</td>
 *      <td><p> Gets recommended IAM roles for an application.
 * <p>  Evaluates the infrastructure resources defined by an application (including its template configuration and parameters) to determine the set of IAM roles and Google Cloud APIs that you must configure before you deploy across target projects.
 * <p>  The operation is asynchronous and returns a `google.longrunning.Operation`. Upon completion, the operation result contains a `RecommendIAMRolesResponse` with project-level IAM role and API recommendations.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> recommendIAMRolesAsync(RecommendIAMRolesRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> recommendIAMRolesAsync(ApplicationName name)
 *           <li><p> recommendIAMRolesAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> recommendIAMRolesOperationCallable()
 *           <li><p> recommendIAMRolesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.
 * <p> This method lists locations based on the resource scope provided inthe [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field: &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If `name` follows the format`projects/{project}`, the method lists locations visible to thatspecific project. This includes public, private, or otherproject-specific locations enabled for the project.
 * <p> For gRPC and client library implementations, the resource name ispassed as the `name` field. For direct service calls, the resourcename isincorporated into the request path based on the specific serviceimplementation and version.</td>
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
 * <p>This class can be customized by passing in a custom instance of DesignCenterSettings to
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
 * DesignCenterSettings designCenterSettings =
 *     DesignCenterSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DesignCenterClient designCenterClient = DesignCenterClient.create(designCenterSettings);
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
 * DesignCenterSettings designCenterSettings =
 *     DesignCenterSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DesignCenterClient designCenterClient = DesignCenterClient.create(designCenterSettings);
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
 * DesignCenterSettings designCenterSettings = DesignCenterSettings.newHttpJsonBuilder().build();
 * DesignCenterClient designCenterClient = DesignCenterClient.create(designCenterSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class DesignCenterClient implements BackgroundResource {
  private final @Nullable DesignCenterSettings settings;
  private final DesignCenterStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of DesignCenterClient with default settings. */
  public static final DesignCenterClient create() throws IOException {
    return create(DesignCenterSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DesignCenterClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DesignCenterClient create(DesignCenterSettings settings) throws IOException {
    return new DesignCenterClient(settings);
  }

  /**
   * Constructs an instance of DesignCenterClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(DesignCenterSettings).
   */
  public static final DesignCenterClient create(DesignCenterStub stub) {
    return new DesignCenterClient(stub);
  }

  /**
   * Constructs an instance of DesignCenterClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DesignCenterClient(DesignCenterSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DesignCenterStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected DesignCenterClient(DesignCenterStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final @Nullable DesignCenterSettings getSettings() {
    return settings;
  }

  public DesignCenterStub getStub() {
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
   * Gets details about a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   SpaceName name = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
   *   Space response = designCenterClient.getSpace(name);
   * }
   * }</pre>
   *
   * @param name Required. The space name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space getSpace(@Nullable SpaceName name) {
    GetSpaceRequest request =
        GetSpaceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSpace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString();
   *   Space response = designCenterClient.getSpace(name);
   * }
   * }</pre>
   *
   * @param name Required. The space name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space getSpace(String name) {
    GetSpaceRequest request = GetSpaceRequest.newBuilder().setName(name).build();
    return getSpace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetSpaceRequest request =
   *       GetSpaceRequest.newBuilder()
   *           .setName(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .build();
   *   Space response = designCenterClient.getSpace(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space getSpace(GetSpaceRequest request) {
    return getSpaceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetSpaceRequest request =
   *       GetSpaceRequest.newBuilder()
   *           .setName(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .build();
   *   ApiFuture<Space> future = designCenterClient.getSpaceCallable().futureCall(request);
   *   // Do something.
   *   Space response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSpaceRequest, Space> getSpaceCallable() {
    return stub.getSpaceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists spaces in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Space element : designCenterClient.listSpaces(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource, for which spaces are listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSpacesPagedResponse listSpaces(@Nullable LocationName parent) {
    ListSpacesRequest request =
        ListSpacesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listSpaces(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists spaces in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Space element : designCenterClient.listSpaces(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource, for which spaces are listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSpacesPagedResponse listSpaces(String parent) {
    ListSpacesRequest request = ListSpacesRequest.newBuilder().setParent(parent).build();
    return listSpaces(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists spaces in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListSpacesRequest request =
   *       ListSpacesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Space element : designCenterClient.listSpaces(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSpacesPagedResponse listSpaces(ListSpacesRequest request) {
    return listSpacesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists spaces in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListSpacesRequest request =
   *       ListSpacesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Space> future = designCenterClient.listSpacesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Space element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSpacesRequest, ListSpacesPagedResponse> listSpacesPagedCallable() {
    return stub.listSpacesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists spaces in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListSpacesRequest request =
   *       ListSpacesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListSpacesResponse response = designCenterClient.listSpacesCallable().call(request);
   *     for (Space element : response.getSpacesList()) {
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
  public final UnaryCallable<ListSpacesRequest, ListSpacesResponse> listSpacesCallable() {
    return stub.listSpacesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Space space = Space.newBuilder().build();
   *   String spaceId = "spaceId-2012163903";
   *   Space response = designCenterClient.createSpace(parent, space, spaceId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent in which to create a space.
   * @param space Required. The space to create.
   * @param spaceId Required. The ID of the space to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space createSpace(@Nullable LocationName parent, Space space, String spaceId) {
    CreateSpaceRequest request =
        CreateSpaceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSpace(space)
            .setSpaceId(spaceId)
            .build();
    return createSpace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Space space = Space.newBuilder().build();
   *   String spaceId = "spaceId-2012163903";
   *   Space response = designCenterClient.createSpace(parent, space, spaceId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent in which to create a space.
   * @param space Required. The space to create.
   * @param spaceId Required. The ID of the space to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space createSpace(String parent, Space space, String spaceId) {
    CreateSpaceRequest request =
        CreateSpaceRequest.newBuilder()
            .setParent(parent)
            .setSpace(space)
            .setSpaceId(spaceId)
            .build();
    return createSpace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CreateSpaceRequest request =
   *       CreateSpaceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSpaceId("spaceId-2012163903")
   *           .setSpace(Space.newBuilder().build())
   *           .build();
   *   Space response = designCenterClient.createSpace(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space createSpace(CreateSpaceRequest request) {
    return createSpaceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CreateSpaceRequest request =
   *       CreateSpaceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSpaceId("spaceId-2012163903")
   *           .setSpace(Space.newBuilder().build())
   *           .build();
   *   ApiFuture<Space> future = designCenterClient.createSpaceCallable().futureCall(request);
   *   // Do something.
   *   Space response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSpaceRequest, Space> createSpaceCallable() {
    return stub.createSpaceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   Space space = Space.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Space response = designCenterClient.updateSpace(space, updateMask);
   * }
   * }</pre>
   *
   * @param space Required. The space to update.
   * @param updateMask Optional. The fields to overwrite in the space update. If you don't provide a
   *     mask, all fields are overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space updateSpace(Space space, FieldMask updateMask) {
    UpdateSpaceRequest request =
        UpdateSpaceRequest.newBuilder().setSpace(space).setUpdateMask(updateMask).build();
    return updateSpace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   UpdateSpaceRequest request =
   *       UpdateSpaceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSpace(Space.newBuilder().build())
   *           .build();
   *   Space response = designCenterClient.updateSpace(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space updateSpace(UpdateSpaceRequest request) {
    return updateSpaceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   UpdateSpaceRequest request =
   *       UpdateSpaceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSpace(Space.newBuilder().build())
   *           .build();
   *   ApiFuture<Space> future = designCenterClient.updateSpaceCallable().futureCall(request);
   *   // Do something.
   *   Space response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSpaceRequest, Space> updateSpaceCallable() {
    return stub.updateSpaceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   SpaceName name = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
   *   designCenterClient.deleteSpace(name);
   * }
   * }</pre>
   *
   * @param name Required. The space name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSpace(@Nullable SpaceName name) {
    DeleteSpaceRequest request =
        DeleteSpaceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteSpace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString();
   *   designCenterClient.deleteSpace(name);
   * }
   * }</pre>
   *
   * @param name Required. The space name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSpace(String name) {
    DeleteSpaceRequest request = DeleteSpaceRequest.newBuilder().setName(name).build();
    deleteSpace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeleteSpaceRequest request =
   *       DeleteSpaceRequest.newBuilder()
   *           .setName(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setForce(true)
   *           .build();
   *   designCenterClient.deleteSpace(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSpace(DeleteSpaceRequest request) {
    deleteSpaceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeleteSpaceRequest request =
   *       DeleteSpaceRequest.newBuilder()
   *           .setName(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future = designCenterClient.deleteSpaceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSpaceRequest, Empty> deleteSpaceCallable() {
    return stub.deleteSpaceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationTemplateName name =
   *       ApplicationTemplateName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
   *   ApplicationTemplate response = designCenterClient.getApplicationTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The application template name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApplicationTemplate getApplicationTemplate(@Nullable ApplicationTemplateName name) {
    GetApplicationTemplateRequest request =
        GetApplicationTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getApplicationTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *           .toString();
   *   ApplicationTemplate response = designCenterClient.getApplicationTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The application template name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApplicationTemplate getApplicationTemplate(String name) {
    GetApplicationTemplateRequest request =
        GetApplicationTemplateRequest.newBuilder().setName(name).build();
    return getApplicationTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetApplicationTemplateRequest request =
   *       GetApplicationTemplateRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   ApplicationTemplate response = designCenterClient.getApplicationTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApplicationTemplate getApplicationTemplate(GetApplicationTemplateRequest request) {
    return getApplicationTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetApplicationTemplateRequest request =
   *       GetApplicationTemplateRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ApplicationTemplate> future =
   *       designCenterClient.getApplicationTemplateCallable().futureCall(request);
   *   // Do something.
   *   ApplicationTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetApplicationTemplateRequest, ApplicationTemplate>
      getApplicationTemplateCallable() {
    return stub.getApplicationTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists application templates in a given space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   SpaceName parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
   *   for (ApplicationTemplate element :
   *       designCenterClient.listApplicationTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource from which to list application templates.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApplicationTemplatesPagedResponse listApplicationTemplates(
      @Nullable SpaceName parent) {
    ListApplicationTemplatesRequest request =
        ListApplicationTemplatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listApplicationTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists application templates in a given space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString();
   *   for (ApplicationTemplate element :
   *       designCenterClient.listApplicationTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource from which to list application templates.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApplicationTemplatesPagedResponse listApplicationTemplates(String parent) {
    ListApplicationTemplatesRequest request =
        ListApplicationTemplatesRequest.newBuilder().setParent(parent).build();
    return listApplicationTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists application templates in a given space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListApplicationTemplatesRequest request =
   *       ListApplicationTemplatesRequest.newBuilder()
   *           .setParent(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ApplicationTemplate element :
   *       designCenterClient.listApplicationTemplates(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApplicationTemplatesPagedResponse listApplicationTemplates(
      ListApplicationTemplatesRequest request) {
    return listApplicationTemplatesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists application templates in a given space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListApplicationTemplatesRequest request =
   *       ListApplicationTemplatesRequest.newBuilder()
   *           .setParent(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ApplicationTemplate> future =
   *       designCenterClient.listApplicationTemplatesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ApplicationTemplate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListApplicationTemplatesRequest, ListApplicationTemplatesPagedResponse>
      listApplicationTemplatesPagedCallable() {
    return stub.listApplicationTemplatesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists application templates in a given space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListApplicationTemplatesRequest request =
   *       ListApplicationTemplatesRequest.newBuilder()
   *           .setParent(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListApplicationTemplatesResponse response =
   *         designCenterClient.listApplicationTemplatesCallable().call(request);
   *     for (ApplicationTemplate element : response.getApplicationTemplatesList()) {
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
  public final UnaryCallable<ListApplicationTemplatesRequest, ListApplicationTemplatesResponse>
      listApplicationTemplatesCallable() {
    return stub.listApplicationTemplatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   SpaceName parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
   *   ApplicationTemplate applicationTemplate = ApplicationTemplate.newBuilder().build();
   *   String applicationTemplateId = "applicationTemplateId-1557848923";
   *   ApplicationTemplate response =
   *       designCenterClient.createApplicationTemplate(
   *           parent, applicationTemplate, applicationTemplateId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource in which to create the application template.
   * @param applicationTemplate Required. The application template to create.
   * @param applicationTemplateId Required. The ID of the application template to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApplicationTemplate createApplicationTemplate(
      @Nullable SpaceName parent,
      ApplicationTemplate applicationTemplate,
      String applicationTemplateId) {
    CreateApplicationTemplateRequest request =
        CreateApplicationTemplateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setApplicationTemplate(applicationTemplate)
            .setApplicationTemplateId(applicationTemplateId)
            .build();
    return createApplicationTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString();
   *   ApplicationTemplate applicationTemplate = ApplicationTemplate.newBuilder().build();
   *   String applicationTemplateId = "applicationTemplateId-1557848923";
   *   ApplicationTemplate response =
   *       designCenterClient.createApplicationTemplate(
   *           parent, applicationTemplate, applicationTemplateId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource in which to create the application template.
   * @param applicationTemplate Required. The application template to create.
   * @param applicationTemplateId Required. The ID of the application template to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApplicationTemplate createApplicationTemplate(
      String parent, ApplicationTemplate applicationTemplate, String applicationTemplateId) {
    CreateApplicationTemplateRequest request =
        CreateApplicationTemplateRequest.newBuilder()
            .setParent(parent)
            .setApplicationTemplate(applicationTemplate)
            .setApplicationTemplateId(applicationTemplateId)
            .build();
    return createApplicationTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CreateApplicationTemplateRequest request =
   *       CreateApplicationTemplateRequest.newBuilder()
   *           .setParent(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setApplicationTemplateId("applicationTemplateId-1557848923")
   *           .setApplicationTemplate(ApplicationTemplate.newBuilder().build())
   *           .build();
   *   ApplicationTemplate response = designCenterClient.createApplicationTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApplicationTemplate createApplicationTemplate(
      CreateApplicationTemplateRequest request) {
    return createApplicationTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CreateApplicationTemplateRequest request =
   *       CreateApplicationTemplateRequest.newBuilder()
   *           .setParent(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setApplicationTemplateId("applicationTemplateId-1557848923")
   *           .setApplicationTemplate(ApplicationTemplate.newBuilder().build())
   *           .build();
   *   ApiFuture<ApplicationTemplate> future =
   *       designCenterClient.createApplicationTemplateCallable().futureCall(request);
   *   // Do something.
   *   ApplicationTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateApplicationTemplateRequest, ApplicationTemplate>
      createApplicationTemplateCallable() {
    return stub.createApplicationTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationTemplate applicationTemplate = ApplicationTemplate.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ApplicationTemplate response =
   *       designCenterClient.updateApplicationTemplate(applicationTemplate, updateMask);
   * }
   * }</pre>
   *
   * @param applicationTemplate Required. The application template to update.
   * @param updateMask Optional. The fields to overwrite in the application template update. The
   *     fields specified in the update_mask are relative to the resource, not the full request. A
   *     field will be overwritten if it is in the mask. If you don't provide a mask, all fields are
   *     overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApplicationTemplate updateApplicationTemplate(
      ApplicationTemplate applicationTemplate, FieldMask updateMask) {
    UpdateApplicationTemplateRequest request =
        UpdateApplicationTemplateRequest.newBuilder()
            .setApplicationTemplate(applicationTemplate)
            .setUpdateMask(updateMask)
            .build();
    return updateApplicationTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   UpdateApplicationTemplateRequest request =
   *       UpdateApplicationTemplateRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setApplicationTemplate(ApplicationTemplate.newBuilder().build())
   *           .build();
   *   ApplicationTemplate response = designCenterClient.updateApplicationTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApplicationTemplate updateApplicationTemplate(
      UpdateApplicationTemplateRequest request) {
    return updateApplicationTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   UpdateApplicationTemplateRequest request =
   *       UpdateApplicationTemplateRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setApplicationTemplate(ApplicationTemplate.newBuilder().build())
   *           .build();
   *   ApiFuture<ApplicationTemplate> future =
   *       designCenterClient.updateApplicationTemplateCallable().futureCall(request);
   *   // Do something.
   *   ApplicationTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateApplicationTemplateRequest, ApplicationTemplate>
      updateApplicationTemplateCallable() {
    return stub.updateApplicationTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports to an existing application template from a given shared template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationTemplateName name =
   *       ApplicationTemplateName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
   *   ApplicationTemplateRevisionName applicationTemplateRevisionUri =
   *       ApplicationTemplateRevisionName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[REVISION]");
   *   ApplicationTemplate response =
   *       designCenterClient.importApplicationTemplate(name, applicationTemplateRevisionUri);
   * }
   * }</pre>
   *
   * @param name Required. The name of the application template.
   * @param applicationTemplateRevisionUri Optional. The source URI for application template
   *     revision.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApplicationTemplate importApplicationTemplate(
      @Nullable ApplicationTemplateName name,
      @Nullable ApplicationTemplateRevisionName applicationTemplateRevisionUri) {
    ImportApplicationTemplateRequest request =
        ImportApplicationTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setApplicationTemplateRevisionUri(
                applicationTemplateRevisionUri == null
                    ? null
                    : applicationTemplateRevisionUri.toString())
            .build();
    return importApplicationTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports to an existing application template from a given shared template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationTemplateName name =
   *       ApplicationTemplateName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
   *   String applicationTemplateRevisionUri =
   *       ApplicationTemplateRevisionName.of(
   *               "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[REVISION]")
   *           .toString();
   *   ApplicationTemplate response =
   *       designCenterClient.importApplicationTemplate(name, applicationTemplateRevisionUri);
   * }
   * }</pre>
   *
   * @param name Required. The name of the application template.
   * @param applicationTemplateRevisionUri Optional. The source URI for application template
   *     revision.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApplicationTemplate importApplicationTemplate(
      @Nullable ApplicationTemplateName name, String applicationTemplateRevisionUri) {
    ImportApplicationTemplateRequest request =
        ImportApplicationTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setApplicationTemplateRevisionUri(applicationTemplateRevisionUri)
            .build();
    return importApplicationTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports to an existing application template from a given shared template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *           .toString();
   *   ApplicationTemplateRevisionName applicationTemplateRevisionUri =
   *       ApplicationTemplateRevisionName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[REVISION]");
   *   ApplicationTemplate response =
   *       designCenterClient.importApplicationTemplate(name, applicationTemplateRevisionUri);
   * }
   * }</pre>
   *
   * @param name Required. The name of the application template.
   * @param applicationTemplateRevisionUri Optional. The source URI for application template
   *     revision.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApplicationTemplate importApplicationTemplate(
      String name, @Nullable ApplicationTemplateRevisionName applicationTemplateRevisionUri) {
    ImportApplicationTemplateRequest request =
        ImportApplicationTemplateRequest.newBuilder()
            .setName(name)
            .setApplicationTemplateRevisionUri(
                applicationTemplateRevisionUri == null
                    ? null
                    : applicationTemplateRevisionUri.toString())
            .build();
    return importApplicationTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports to an existing application template from a given shared template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *           .toString();
   *   String applicationTemplateRevisionUri =
   *       ApplicationTemplateRevisionName.of(
   *               "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[REVISION]")
   *           .toString();
   *   ApplicationTemplate response =
   *       designCenterClient.importApplicationTemplate(name, applicationTemplateRevisionUri);
   * }
   * }</pre>
   *
   * @param name Required. The name of the application template.
   * @param applicationTemplateRevisionUri Optional. The source URI for application template
   *     revision.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApplicationTemplate importApplicationTemplate(
      String name, String applicationTemplateRevisionUri) {
    ImportApplicationTemplateRequest request =
        ImportApplicationTemplateRequest.newBuilder()
            .setName(name)
            .setApplicationTemplateRevisionUri(applicationTemplateRevisionUri)
            .build();
    return importApplicationTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports to an existing application template from a given shared template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ImportApplicationTemplateRequest request =
   *       ImportApplicationTemplateRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .putAllAnnotations(new HashMap<String, String>())
   *           .build();
   *   ApplicationTemplate response = designCenterClient.importApplicationTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApplicationTemplate importApplicationTemplate(
      ImportApplicationTemplateRequest request) {
    return importApplicationTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports to an existing application template from a given shared template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ImportApplicationTemplateRequest request =
   *       ImportApplicationTemplateRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .putAllAnnotations(new HashMap<String, String>())
   *           .build();
   *   ApiFuture<ApplicationTemplate> future =
   *       designCenterClient.importApplicationTemplateCallable().futureCall(request);
   *   // Do something.
   *   ApplicationTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportApplicationTemplateRequest, ApplicationTemplate>
      importApplicationTemplateCallable() {
    return stub.importApplicationTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationTemplateName name =
   *       ApplicationTemplateName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
   *   designCenterClient.deleteApplicationTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The application template name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteApplicationTemplate(@Nullable ApplicationTemplateName name) {
    DeleteApplicationTemplateRequest request =
        DeleteApplicationTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteApplicationTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *           .toString();
   *   designCenterClient.deleteApplicationTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The application template name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteApplicationTemplate(String name) {
    DeleteApplicationTemplateRequest request =
        DeleteApplicationTemplateRequest.newBuilder().setName(name).build();
    deleteApplicationTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeleteApplicationTemplateRequest request =
   *       DeleteApplicationTemplateRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   designCenterClient.deleteApplicationTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteApplicationTemplate(DeleteApplicationTemplateRequest request) {
    deleteApplicationTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeleteApplicationTemplateRequest request =
   *       DeleteApplicationTemplateRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future =
   *       designCenterClient.deleteApplicationTemplateCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteApplicationTemplateRequest, Empty>
      deleteApplicationTemplateCallable() {
    return stub.deleteApplicationTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Commits an application template to create a new revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationTemplateName name =
   *       ApplicationTemplateName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
   *   ApplicationTemplateRevision response = designCenterClient.commitApplicationTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the application template.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApplicationTemplateRevision commitApplicationTemplate(
      @Nullable ApplicationTemplateName name) {
    CommitApplicationTemplateRequest request =
        CommitApplicationTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return commitApplicationTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Commits an application template to create a new revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *           .toString();
   *   ApplicationTemplateRevision response = designCenterClient.commitApplicationTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the application template.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApplicationTemplateRevision commitApplicationTemplate(String name) {
    CommitApplicationTemplateRequest request =
        CommitApplicationTemplateRequest.newBuilder().setName(name).build();
    return commitApplicationTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Commits an application template to create a new revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CommitApplicationTemplateRequest request =
   *       CommitApplicationTemplateRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   ApplicationTemplateRevision response = designCenterClient.commitApplicationTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApplicationTemplateRevision commitApplicationTemplate(
      CommitApplicationTemplateRequest request) {
    return commitApplicationTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Commits an application template to create a new revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CommitApplicationTemplateRequest request =
   *       CommitApplicationTemplateRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ApplicationTemplateRevision> future =
   *       designCenterClient.commitApplicationTemplateCallable().futureCall(request);
   *   // Do something.
   *   ApplicationTemplateRevision response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CommitApplicationTemplateRequest, ApplicationTemplateRevision>
      commitApplicationTemplateCallable() {
    return stub.commitApplicationTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Snapshots an application template to create a new revision asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationTemplateName name =
   *       ApplicationTemplateName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
   *   SnapshotApplicationTemplateResponse response =
   *       designCenterClient.snapshotApplicationTemplateAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the application template.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SnapshotApplicationTemplateResponse, OperationMetadata>
      snapshotApplicationTemplateAsync(@Nullable ApplicationTemplateName name) {
    SnapshotApplicationTemplateRequest request =
        SnapshotApplicationTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return snapshotApplicationTemplateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Snapshots an application template to create a new revision asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *           .toString();
   *   SnapshotApplicationTemplateResponse response =
   *       designCenterClient.snapshotApplicationTemplateAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the application template.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SnapshotApplicationTemplateResponse, OperationMetadata>
      snapshotApplicationTemplateAsync(String name) {
    SnapshotApplicationTemplateRequest request =
        SnapshotApplicationTemplateRequest.newBuilder().setName(name).build();
    return snapshotApplicationTemplateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Snapshots an application template to create a new revision asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   SnapshotApplicationTemplateRequest request =
   *       SnapshotApplicationTemplateRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   SnapshotApplicationTemplateResponse response =
   *       designCenterClient.snapshotApplicationTemplateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SnapshotApplicationTemplateResponse, OperationMetadata>
      snapshotApplicationTemplateAsync(SnapshotApplicationTemplateRequest request) {
    return snapshotApplicationTemplateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Snapshots an application template to create a new revision asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   SnapshotApplicationTemplateRequest request =
   *       SnapshotApplicationTemplateRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   OperationFuture<SnapshotApplicationTemplateResponse, OperationMetadata> future =
   *       designCenterClient.snapshotApplicationTemplateOperationCallable().futureCall(request);
   *   // Do something.
   *   SnapshotApplicationTemplateResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          SnapshotApplicationTemplateRequest,
          SnapshotApplicationTemplateResponse,
          OperationMetadata>
      snapshotApplicationTemplateOperationCallable() {
    return stub.snapshotApplicationTemplateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Snapshots an application template to create a new revision asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   SnapshotApplicationTemplateRequest request =
   *       SnapshotApplicationTemplateRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       designCenterClient.snapshotApplicationTemplateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SnapshotApplicationTemplateRequest, Operation>
      snapshotApplicationTemplateCallable() {
    return stub.snapshotApplicationTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates Terraform files for an application template. This is a SYNCHRONOUS operation and
   * returns the generated IaC directly in the response. It does NOT download external module
   * sources; it only uses remote sources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationTemplateName name =
   *       ApplicationTemplateName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
   *   GenerateApplicationTemplateIaCResponse response =
   *       designCenterClient.generateApplicationTemplateIaC(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the application template.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateApplicationTemplateIaCResponse generateApplicationTemplateIaC(
      @Nullable ApplicationTemplateName name) {
    GenerateApplicationTemplateIaCRequest request =
        GenerateApplicationTemplateIaCRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return generateApplicationTemplateIaC(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates Terraform files for an application template. This is a SYNCHRONOUS operation and
   * returns the generated IaC directly in the response. It does NOT download external module
   * sources; it only uses remote sources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *           .toString();
   *   GenerateApplicationTemplateIaCResponse response =
   *       designCenterClient.generateApplicationTemplateIaC(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the application template.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateApplicationTemplateIaCResponse generateApplicationTemplateIaC(String name) {
    GenerateApplicationTemplateIaCRequest request =
        GenerateApplicationTemplateIaCRequest.newBuilder().setName(name).build();
    return generateApplicationTemplateIaC(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates Terraform files for an application template. This is a SYNCHRONOUS operation and
   * returns the generated IaC directly in the response. It does NOT download external module
   * sources; it only uses remote sources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GenerateApplicationTemplateIaCRequest request =
   *       GenerateApplicationTemplateIaCRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setGcsUri("gcsUri-1251224875")
   *           .setArtifactLocation(ArtifactLocation.newBuilder().build())
   *           .build();
   *   GenerateApplicationTemplateIaCResponse response =
   *       designCenterClient.generateApplicationTemplateIaC(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateApplicationTemplateIaCResponse generateApplicationTemplateIaC(
      GenerateApplicationTemplateIaCRequest request) {
    return generateApplicationTemplateIaCCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates Terraform files for an application template. This is a SYNCHRONOUS operation and
   * returns the generated IaC directly in the response. It does NOT download external module
   * sources; it only uses remote sources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GenerateApplicationTemplateIaCRequest request =
   *       GenerateApplicationTemplateIaCRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setGcsUri("gcsUri-1251224875")
   *           .setArtifactLocation(ArtifactLocation.newBuilder().build())
   *           .build();
   *   ApiFuture<GenerateApplicationTemplateIaCResponse> future =
   *       designCenterClient.generateApplicationTemplateIaCCallable().futureCall(request);
   *   // Do something.
   *   GenerateApplicationTemplateIaCResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GenerateApplicationTemplateIaCRequest, GenerateApplicationTemplateIaCResponse>
      generateApplicationTemplateIaCCallable() {
    return stub.generateApplicationTemplateIaCCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports Terraform files for an application template. The generated modules can have remote
   * sources or local sources downloaded from remote. This is an ASYNCHRONOUS operation that returns
   * a Long Running Operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationTemplateName name =
   *       ApplicationTemplateName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
   *   ExportApplicationTemplateIaCResponse response =
   *       designCenterClient.exportApplicationTemplateIaCAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the application template.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportApplicationTemplateIaCResponse, OperationMetadata>
      exportApplicationTemplateIaCAsync(@Nullable ApplicationTemplateName name) {
    ExportApplicationTemplateIaCRequest request =
        ExportApplicationTemplateIaCRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return exportApplicationTemplateIaCAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports Terraform files for an application template. The generated modules can have remote
   * sources or local sources downloaded from remote. This is an ASYNCHRONOUS operation that returns
   * a Long Running Operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *           .toString();
   *   ExportApplicationTemplateIaCResponse response =
   *       designCenterClient.exportApplicationTemplateIaCAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the application template.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportApplicationTemplateIaCResponse, OperationMetadata>
      exportApplicationTemplateIaCAsync(String name) {
    ExportApplicationTemplateIaCRequest request =
        ExportApplicationTemplateIaCRequest.newBuilder().setName(name).build();
    return exportApplicationTemplateIaCAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports Terraform files for an application template. The generated modules can have remote
   * sources or local sources downloaded from remote. This is an ASYNCHRONOUS operation that returns
   * a Long Running Operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ExportApplicationTemplateIaCRequest request =
   *       ExportApplicationTemplateIaCRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setArtifactLocation(ArtifactLocation.newBuilder().build())
   *           .setExportIacConfig(ExportIaCConfig.newBuilder().build())
   *           .build();
   *   ExportApplicationTemplateIaCResponse response =
   *       designCenterClient.exportApplicationTemplateIaCAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportApplicationTemplateIaCResponse, OperationMetadata>
      exportApplicationTemplateIaCAsync(ExportApplicationTemplateIaCRequest request) {
    return exportApplicationTemplateIaCOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports Terraform files for an application template. The generated modules can have remote
   * sources or local sources downloaded from remote. This is an ASYNCHRONOUS operation that returns
   * a Long Running Operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ExportApplicationTemplateIaCRequest request =
   *       ExportApplicationTemplateIaCRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setArtifactLocation(ArtifactLocation.newBuilder().build())
   *           .setExportIacConfig(ExportIaCConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<ExportApplicationTemplateIaCResponse, OperationMetadata> future =
   *       designCenterClient.exportApplicationTemplateIaCOperationCallable().futureCall(request);
   *   // Do something.
   *   ExportApplicationTemplateIaCResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ExportApplicationTemplateIaCRequest,
          ExportApplicationTemplateIaCResponse,
          OperationMetadata>
      exportApplicationTemplateIaCOperationCallable() {
    return stub.exportApplicationTemplateIaCOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports Terraform files for an application template. The generated modules can have remote
   * sources or local sources downloaded from remote. This is an ASYNCHRONOUS operation that returns
   * a Long Running Operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ExportApplicationTemplateIaCRequest request =
   *       ExportApplicationTemplateIaCRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setArtifactLocation(ArtifactLocation.newBuilder().build())
   *           .setExportIacConfig(ExportIaCConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       designCenterClient.exportApplicationTemplateIaCCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportApplicationTemplateIaCRequest, Operation>
      exportApplicationTemplateIaCCallable() {
    return stub.exportApplicationTemplateIaCCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates Terraform files for an application template revision. This is a SYNCHRONOUS operation
   * and returns the generated IaC directly in the response. It does NOT download external module
   * sources; it only uses remote sources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationTemplateRevisionName name =
   *       ApplicationTemplateRevisionName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[REVISION]");
   *   GenerateApplicationTemplateRevisionIaCResponse response =
   *       designCenterClient.generateApplicationTemplateRevisionIaC(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the application template revision.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateApplicationTemplateRevisionIaCResponse
      generateApplicationTemplateRevisionIaC(@Nullable ApplicationTemplateRevisionName name) {
    GenerateApplicationTemplateRevisionIaCRequest request =
        GenerateApplicationTemplateRevisionIaCRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return generateApplicationTemplateRevisionIaC(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates Terraform files for an application template revision. This is a SYNCHRONOUS operation
   * and returns the generated IaC directly in the response. It does NOT download external module
   * sources; it only uses remote sources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationTemplateRevisionName.of(
   *               "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[REVISION]")
   *           .toString();
   *   GenerateApplicationTemplateRevisionIaCResponse response =
   *       designCenterClient.generateApplicationTemplateRevisionIaC(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the application template revision.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateApplicationTemplateRevisionIaCResponse
      generateApplicationTemplateRevisionIaC(String name) {
    GenerateApplicationTemplateRevisionIaCRequest request =
        GenerateApplicationTemplateRevisionIaCRequest.newBuilder().setName(name).build();
    return generateApplicationTemplateRevisionIaC(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates Terraform files for an application template revision. This is a SYNCHRONOUS operation
   * and returns the generated IaC directly in the response. It does NOT download external module
   * sources; it only uses remote sources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GenerateApplicationTemplateRevisionIaCRequest request =
   *       GenerateApplicationTemplateRevisionIaCRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateRevisionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[REVISION]")
   *                   .toString())
   *           .setArtifactLocation(ArtifactLocation.newBuilder().build())
   *           .build();
   *   GenerateApplicationTemplateRevisionIaCResponse response =
   *       designCenterClient.generateApplicationTemplateRevisionIaC(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateApplicationTemplateRevisionIaCResponse
      generateApplicationTemplateRevisionIaC(
          GenerateApplicationTemplateRevisionIaCRequest request) {
    return generateApplicationTemplateRevisionIaCCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates Terraform files for an application template revision. This is a SYNCHRONOUS operation
   * and returns the generated IaC directly in the response. It does NOT download external module
   * sources; it only uses remote sources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GenerateApplicationTemplateRevisionIaCRequest request =
   *       GenerateApplicationTemplateRevisionIaCRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateRevisionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[REVISION]")
   *                   .toString())
   *           .setArtifactLocation(ArtifactLocation.newBuilder().build())
   *           .build();
   *   ApiFuture<GenerateApplicationTemplateRevisionIaCResponse> future =
   *       designCenterClient.generateApplicationTemplateRevisionIaCCallable().futureCall(request);
   *   // Do something.
   *   GenerateApplicationTemplateRevisionIaCResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GenerateApplicationTemplateRevisionIaCRequest,
          GenerateApplicationTemplateRevisionIaCResponse>
      generateApplicationTemplateRevisionIaCCallable() {
    return stub.generateApplicationTemplateRevisionIaCCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports Terraform files for an application template revision. The generated modules can have
   * remote sources or local sources downloaded from remote. This is an ASYNCHRONOUS operation that
   * returns a Long Running Operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationTemplateRevisionName name =
   *       ApplicationTemplateRevisionName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[REVISION]");
   *   ExportApplicationTemplateRevisionIaCResponse response =
   *       designCenterClient.exportApplicationTemplateRevisionIaCAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the application template revision.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportApplicationTemplateRevisionIaCResponse, OperationMetadata>
      exportApplicationTemplateRevisionIaCAsync(@Nullable ApplicationTemplateRevisionName name) {
    ExportApplicationTemplateRevisionIaCRequest request =
        ExportApplicationTemplateRevisionIaCRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return exportApplicationTemplateRevisionIaCAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports Terraform files for an application template revision. The generated modules can have
   * remote sources or local sources downloaded from remote. This is an ASYNCHRONOUS operation that
   * returns a Long Running Operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationTemplateRevisionName.of(
   *               "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[REVISION]")
   *           .toString();
   *   ExportApplicationTemplateRevisionIaCResponse response =
   *       designCenterClient.exportApplicationTemplateRevisionIaCAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the application template revision.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportApplicationTemplateRevisionIaCResponse, OperationMetadata>
      exportApplicationTemplateRevisionIaCAsync(String name) {
    ExportApplicationTemplateRevisionIaCRequest request =
        ExportApplicationTemplateRevisionIaCRequest.newBuilder().setName(name).build();
    return exportApplicationTemplateRevisionIaCAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports Terraform files for an application template revision. The generated modules can have
   * remote sources or local sources downloaded from remote. This is an ASYNCHRONOUS operation that
   * returns a Long Running Operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ExportApplicationTemplateRevisionIaCRequest request =
   *       ExportApplicationTemplateRevisionIaCRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateRevisionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[REVISION]")
   *                   .toString())
   *           .setArtifactLocation(ArtifactLocation.newBuilder().build())
   *           .setExportIacConfig(ExportIaCConfig.newBuilder().build())
   *           .build();
   *   ExportApplicationTemplateRevisionIaCResponse response =
   *       designCenterClient.exportApplicationTemplateRevisionIaCAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportApplicationTemplateRevisionIaCResponse, OperationMetadata>
      exportApplicationTemplateRevisionIaCAsync(
          ExportApplicationTemplateRevisionIaCRequest request) {
    return exportApplicationTemplateRevisionIaCOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports Terraform files for an application template revision. The generated modules can have
   * remote sources or local sources downloaded from remote. This is an ASYNCHRONOUS operation that
   * returns a Long Running Operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ExportApplicationTemplateRevisionIaCRequest request =
   *       ExportApplicationTemplateRevisionIaCRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateRevisionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[REVISION]")
   *                   .toString())
   *           .setArtifactLocation(ArtifactLocation.newBuilder().build())
   *           .setExportIacConfig(ExportIaCConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<ExportApplicationTemplateRevisionIaCResponse, OperationMetadata> future =
   *       designCenterClient
   *           .exportApplicationTemplateRevisionIaCOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ExportApplicationTemplateRevisionIaCResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ExportApplicationTemplateRevisionIaCRequest,
          ExportApplicationTemplateRevisionIaCResponse,
          OperationMetadata>
      exportApplicationTemplateRevisionIaCOperationCallable() {
    return stub.exportApplicationTemplateRevisionIaCOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports Terraform files for an application template revision. The generated modules can have
   * remote sources or local sources downloaded from remote. This is an ASYNCHRONOUS operation that
   * returns a Long Running Operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ExportApplicationTemplateRevisionIaCRequest request =
   *       ExportApplicationTemplateRevisionIaCRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateRevisionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[REVISION]")
   *                   .toString())
   *           .setArtifactLocation(ArtifactLocation.newBuilder().build())
   *           .setExportIacConfig(ExportIaCConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       designCenterClient.exportApplicationTemplateRevisionIaCCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportApplicationTemplateRevisionIaCRequest, Operation>
      exportApplicationTemplateRevisionIaCCallable() {
    return stub.exportApplicationTemplateRevisionIaCCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a Component.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ComponentName name =
   *       ComponentName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[COMPONENT]");
   *   Component response = designCenterClient.getComponent(name);
   * }
   * }</pre>
   *
   * @param name Required. The component name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Component getComponent(@Nullable ComponentName name) {
    GetComponentRequest request =
        GetComponentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getComponent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a Component.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ComponentName.of(
   *               "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[COMPONENT]")
   *           .toString();
   *   Component response = designCenterClient.getComponent(name);
   * }
   * }</pre>
   *
   * @param name Required. The component name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Component getComponent(String name) {
    GetComponentRequest request = GetComponentRequest.newBuilder().setName(name).build();
    return getComponent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a Component.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetComponentRequest request =
   *       GetComponentRequest.newBuilder()
   *           .setName(
   *               ComponentName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[COMPONENT]")
   *                   .toString())
   *           .build();
   *   Component response = designCenterClient.getComponent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Component getComponent(GetComponentRequest request) {
    return getComponentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a Component.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetComponentRequest request =
   *       GetComponentRequest.newBuilder()
   *           .setName(
   *               ComponentName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[COMPONENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Component> future = designCenterClient.getComponentCallable().futureCall(request);
   *   // Do something.
   *   Component response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetComponentRequest, Component> getComponentCallable() {
    return stub.getComponentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists components in an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationTemplateName parent =
   *       ApplicationTemplateName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
   *   for (Component element : designCenterClient.listComponents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource from which the list of components is requested.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListComponentsPagedResponse listComponents(
      @Nullable ApplicationTemplateName parent) {
    ListComponentsRequest request =
        ListComponentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listComponents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists components in an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent =
   *       ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *           .toString();
   *   for (Component element : designCenterClient.listComponents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource from which the list of components is requested.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListComponentsPagedResponse listComponents(String parent) {
    ListComponentsRequest request = ListComponentsRequest.newBuilder().setParent(parent).build();
    return listComponents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists components in an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListComponentsRequest request =
   *       ListComponentsRequest.newBuilder()
   *           .setParent(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Component element : designCenterClient.listComponents(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListComponentsPagedResponse listComponents(ListComponentsRequest request) {
    return listComponentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists components in an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListComponentsRequest request =
   *       ListComponentsRequest.newBuilder()
   *           .setParent(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Component> future =
   *       designCenterClient.listComponentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Component element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListComponentsRequest, ListComponentsPagedResponse>
      listComponentsPagedCallable() {
    return stub.listComponentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists components in an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListComponentsRequest request =
   *       ListComponentsRequest.newBuilder()
   *           .setParent(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListComponentsResponse response = designCenterClient.listComponentsCallable().call(request);
   *     for (Component element : response.getComponentsList()) {
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
  public final UnaryCallable<ListComponentsRequest, ListComponentsResponse>
      listComponentsCallable() {
    return stub.listComponentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a component.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationTemplateName parent =
   *       ApplicationTemplateName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
   *   Component component = Component.newBuilder().build();
   *   String componentId = "componentId-985933064";
   *   Component response = designCenterClient.createComponent(parent, component, componentId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource in which to create the component.
   * @param component Required. The component to create.
   * @param componentId Required. The ID of the component to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Component createComponent(
      @Nullable ApplicationTemplateName parent, Component component, String componentId) {
    CreateComponentRequest request =
        CreateComponentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setComponent(component)
            .setComponentId(componentId)
            .build();
    return createComponent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a component.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent =
   *       ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *           .toString();
   *   Component component = Component.newBuilder().build();
   *   String componentId = "componentId-985933064";
   *   Component response = designCenterClient.createComponent(parent, component, componentId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource in which to create the component.
   * @param component Required. The component to create.
   * @param componentId Required. The ID of the component to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Component createComponent(String parent, Component component, String componentId) {
    CreateComponentRequest request =
        CreateComponentRequest.newBuilder()
            .setParent(parent)
            .setComponent(component)
            .setComponentId(componentId)
            .build();
    return createComponent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a component.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CreateComponentRequest request =
   *       CreateComponentRequest.newBuilder()
   *           .setParent(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setComponentId("componentId-985933064")
   *           .setComponent(Component.newBuilder().build())
   *           .build();
   *   Component response = designCenterClient.createComponent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Component createComponent(CreateComponentRequest request) {
    return createComponentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a component.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CreateComponentRequest request =
   *       CreateComponentRequest.newBuilder()
   *           .setParent(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setComponentId("componentId-985933064")
   *           .setComponent(Component.newBuilder().build())
   *           .build();
   *   ApiFuture<Component> future =
   *       designCenterClient.createComponentCallable().futureCall(request);
   *   // Do something.
   *   Component response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateComponentRequest, Component> createComponentCallable() {
    return stub.createComponentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a component.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   Component component = Component.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Component response = designCenterClient.updateComponent(component, updateMask);
   * }
   * }</pre>
   *
   * @param component Required. The component to update.
   * @param updateMask Optional. The fields to overwrite in the component update. If you don't
   *     provide a mask, all fields are overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Component updateComponent(Component component, FieldMask updateMask) {
    UpdateComponentRequest request =
        UpdateComponentRequest.newBuilder()
            .setComponent(component)
            .setUpdateMask(updateMask)
            .build();
    return updateComponent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a component.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   UpdateComponentRequest request =
   *       UpdateComponentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setComponent(Component.newBuilder().build())
   *           .build();
   *   Component response = designCenterClient.updateComponent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Component updateComponent(UpdateComponentRequest request) {
    return updateComponentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a component.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   UpdateComponentRequest request =
   *       UpdateComponentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setComponent(Component.newBuilder().build())
   *           .build();
   *   ApiFuture<Component> future =
   *       designCenterClient.updateComponentCallable().futureCall(request);
   *   // Do something.
   *   Component response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateComponentRequest, Component> updateComponentCallable() {
    return stub.updateComponentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a component.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ComponentName name =
   *       ComponentName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[COMPONENT]");
   *   designCenterClient.deleteComponent(name);
   * }
   * }</pre>
   *
   * @param name Required. The component name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteComponent(@Nullable ComponentName name) {
    DeleteComponentRequest request =
        DeleteComponentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteComponent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a component.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ComponentName.of(
   *               "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[COMPONENT]")
   *           .toString();
   *   designCenterClient.deleteComponent(name);
   * }
   * }</pre>
   *
   * @param name Required. The component name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteComponent(String name) {
    DeleteComponentRequest request = DeleteComponentRequest.newBuilder().setName(name).build();
    deleteComponent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a component.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeleteComponentRequest request =
   *       DeleteComponentRequest.newBuilder()
   *           .setName(
   *               ComponentName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[COMPONENT]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   designCenterClient.deleteComponent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteComponent(DeleteComponentRequest request) {
    deleteComponentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a component.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeleteComponentRequest request =
   *       DeleteComponentRequest.newBuilder()
   *           .setName(
   *               ComponentName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[COMPONENT]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future = designCenterClient.deleteComponentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteComponentRequest, Empty> deleteComponentCallable() {
    return stub.deleteComponentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ConnectionName name =
   *       ConnectionName.of(
   *           "[PROJECT]",
   *           "[LOCATION]",
   *           "[SPACE]",
   *           "[APPLICATION_TEMPLATE]",
   *           "[COMPONENT]",
   *           "[CONNECTION]");
   *   Connection response = designCenterClient.getConnection(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Connection getConnection(@Nullable ConnectionName name) {
    GetConnectionRequest request =
        GetConnectionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ConnectionName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[SPACE]",
   *               "[APPLICATION_TEMPLATE]",
   *               "[COMPONENT]",
   *               "[CONNECTION]")
   *           .toString();
   *   Connection response = designCenterClient.getConnection(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Connection getConnection(String name) {
    GetConnectionRequest request = GetConnectionRequest.newBuilder().setName(name).build();
    return getConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetConnectionRequest request =
   *       GetConnectionRequest.newBuilder()
   *           .setName(
   *               ConnectionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[COMPONENT]",
   *                       "[CONNECTION]")
   *                   .toString())
   *           .build();
   *   Connection response = designCenterClient.getConnection(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Connection getConnection(GetConnectionRequest request) {
    return getConnectionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetConnectionRequest request =
   *       GetConnectionRequest.newBuilder()
   *           .setName(
   *               ConnectionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[COMPONENT]",
   *                       "[CONNECTION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Connection> future = designCenterClient.getConnectionCallable().futureCall(request);
   *   // Do something.
   *   Connection response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConnectionRequest, Connection> getConnectionCallable() {
    return stub.getConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists connections in an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ComponentName parent =
   *       ComponentName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[COMPONENT]");
   *   for (Connection element : designCenterClient.listConnections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource from which to request a list of connections.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectionsPagedResponse listConnections(@Nullable ComponentName parent) {
    ListConnectionsRequest request =
        ListConnectionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listConnections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists connections in an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent =
   *       ComponentName.of(
   *               "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[COMPONENT]")
   *           .toString();
   *   for (Connection element : designCenterClient.listConnections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource from which to request a list of connections.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectionsPagedResponse listConnections(String parent) {
    ListConnectionsRequest request = ListConnectionsRequest.newBuilder().setParent(parent).build();
    return listConnections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists connections in an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListConnectionsRequest request =
   *       ListConnectionsRequest.newBuilder()
   *           .setParent(
   *               ComponentName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[COMPONENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Connection element : designCenterClient.listConnections(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectionsPagedResponse listConnections(ListConnectionsRequest request) {
    return listConnectionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists connections in an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListConnectionsRequest request =
   *       ListConnectionsRequest.newBuilder()
   *           .setParent(
   *               ComponentName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[COMPONENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Connection> future =
   *       designCenterClient.listConnectionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Connection element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListConnectionsRequest, ListConnectionsPagedResponse>
      listConnectionsPagedCallable() {
    return stub.listConnectionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists connections in an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListConnectionsRequest request =
   *       ListConnectionsRequest.newBuilder()
   *           .setParent(
   *               ComponentName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[COMPONENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListConnectionsResponse response =
   *         designCenterClient.listConnectionsCallable().call(request);
   *     for (Connection element : response.getConnectionsList()) {
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
  public final UnaryCallable<ListConnectionsRequest, ListConnectionsResponse>
      listConnectionsCallable() {
    return stub.listConnectionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ComponentName parent =
   *       ComponentName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[COMPONENT]");
   *   Connection connection = Connection.newBuilder().build();
   *   String connectionId = "connectionId1923106969";
   *   Connection response = designCenterClient.createConnection(parent, connection, connectionId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource in which to create a connection.
   * @param connection Required. The connection to create.
   * @param connectionId Required. The ID of the connection to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Connection createConnection(
      @Nullable ComponentName parent, Connection connection, String connectionId) {
    CreateConnectionRequest request =
        CreateConnectionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConnection(connection)
            .setConnectionId(connectionId)
            .build();
    return createConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent =
   *       ComponentName.of(
   *               "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[COMPONENT]")
   *           .toString();
   *   Connection connection = Connection.newBuilder().build();
   *   String connectionId = "connectionId1923106969";
   *   Connection response = designCenterClient.createConnection(parent, connection, connectionId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource in which to create a connection.
   * @param connection Required. The connection to create.
   * @param connectionId Required. The ID of the connection to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Connection createConnection(
      String parent, Connection connection, String connectionId) {
    CreateConnectionRequest request =
        CreateConnectionRequest.newBuilder()
            .setParent(parent)
            .setConnection(connection)
            .setConnectionId(connectionId)
            .build();
    return createConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CreateConnectionRequest request =
   *       CreateConnectionRequest.newBuilder()
   *           .setParent(
   *               ComponentName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[COMPONENT]")
   *                   .toString())
   *           .setConnectionId("connectionId1923106969")
   *           .setConnection(Connection.newBuilder().build())
   *           .build();
   *   Connection response = designCenterClient.createConnection(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Connection createConnection(CreateConnectionRequest request) {
    return createConnectionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CreateConnectionRequest request =
   *       CreateConnectionRequest.newBuilder()
   *           .setParent(
   *               ComponentName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[COMPONENT]")
   *                   .toString())
   *           .setConnectionId("connectionId1923106969")
   *           .setConnection(Connection.newBuilder().build())
   *           .build();
   *   ApiFuture<Connection> future =
   *       designCenterClient.createConnectionCallable().futureCall(request);
   *   // Do something.
   *   Connection response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateConnectionRequest, Connection> createConnectionCallable() {
    return stub.createConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   Connection connection = Connection.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Connection response = designCenterClient.updateConnection(connection, updateMask);
   * }
   * }</pre>
   *
   * @param connection Required. The connection to update.
   * @param updateMask Optional. Fields to overwrite in the connection update. The fields specified
   *     in the update_mask are relative to the resource, not the full request. A field will be
   *     overwritten if it is in the mask. If you don't provide a mask, all fields are overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Connection updateConnection(Connection connection, FieldMask updateMask) {
    UpdateConnectionRequest request =
        UpdateConnectionRequest.newBuilder()
            .setConnection(connection)
            .setUpdateMask(updateMask)
            .build();
    return updateConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   UpdateConnectionRequest request =
   *       UpdateConnectionRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setConnection(Connection.newBuilder().build())
   *           .build();
   *   Connection response = designCenterClient.updateConnection(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Connection updateConnection(UpdateConnectionRequest request) {
    return updateConnectionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   UpdateConnectionRequest request =
   *       UpdateConnectionRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setConnection(Connection.newBuilder().build())
   *           .build();
   *   ApiFuture<Connection> future =
   *       designCenterClient.updateConnectionCallable().futureCall(request);
   *   // Do something.
   *   Connection response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateConnectionRequest, Connection> updateConnectionCallable() {
    return stub.updateConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ConnectionName name =
   *       ConnectionName.of(
   *           "[PROJECT]",
   *           "[LOCATION]",
   *           "[SPACE]",
   *           "[APPLICATION_TEMPLATE]",
   *           "[COMPONENT]",
   *           "[CONNECTION]");
   *   designCenterClient.deleteConnection(name);
   * }
   * }</pre>
   *
   * @param name Required. The connection name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConnection(@Nullable ConnectionName name) {
    DeleteConnectionRequest request =
        DeleteConnectionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ConnectionName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[SPACE]",
   *               "[APPLICATION_TEMPLATE]",
   *               "[COMPONENT]",
   *               "[CONNECTION]")
   *           .toString();
   *   designCenterClient.deleteConnection(name);
   * }
   * }</pre>
   *
   * @param name Required. The connection name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConnection(String name) {
    DeleteConnectionRequest request = DeleteConnectionRequest.newBuilder().setName(name).build();
    deleteConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeleteConnectionRequest request =
   *       DeleteConnectionRequest.newBuilder()
   *           .setName(
   *               ConnectionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[COMPONENT]",
   *                       "[CONNECTION]")
   *                   .toString())
   *           .build();
   *   designCenterClient.deleteConnection(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConnection(DeleteConnectionRequest request) {
    deleteConnectionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeleteConnectionRequest request =
   *       DeleteConnectionRequest.newBuilder()
   *           .setName(
   *               ConnectionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[COMPONENT]",
   *                       "[CONNECTION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = designCenterClient.deleteConnectionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteConnectionRequest, Empty> deleteConnectionCallable() {
    return stub.deleteConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about an application template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationTemplateRevisionName name =
   *       ApplicationTemplateRevisionName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[REVISION]");
   *   ApplicationTemplateRevision response =
   *       designCenterClient.getApplicationTemplateRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The application template revision name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApplicationTemplateRevision getApplicationTemplateRevision(
      @Nullable ApplicationTemplateRevisionName name) {
    GetApplicationTemplateRevisionRequest request =
        GetApplicationTemplateRevisionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getApplicationTemplateRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about an application template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationTemplateRevisionName.of(
   *               "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[REVISION]")
   *           .toString();
   *   ApplicationTemplateRevision response =
   *       designCenterClient.getApplicationTemplateRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The application template revision name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApplicationTemplateRevision getApplicationTemplateRevision(String name) {
    GetApplicationTemplateRevisionRequest request =
        GetApplicationTemplateRevisionRequest.newBuilder().setName(name).build();
    return getApplicationTemplateRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about an application template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetApplicationTemplateRevisionRequest request =
   *       GetApplicationTemplateRevisionRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateRevisionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[REVISION]")
   *                   .toString())
   *           .build();
   *   ApplicationTemplateRevision response =
   *       designCenterClient.getApplicationTemplateRevision(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApplicationTemplateRevision getApplicationTemplateRevision(
      GetApplicationTemplateRevisionRequest request) {
    return getApplicationTemplateRevisionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about an application template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetApplicationTemplateRevisionRequest request =
   *       GetApplicationTemplateRevisionRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateRevisionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[REVISION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ApplicationTemplateRevision> future =
   *       designCenterClient.getApplicationTemplateRevisionCallable().futureCall(request);
   *   // Do something.
   *   ApplicationTemplateRevision response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetApplicationTemplateRevisionRequest, ApplicationTemplateRevision>
      getApplicationTemplateRevisionCallable() {
    return stub.getApplicationTemplateRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists application template revisions in a given application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationTemplateName parent =
   *       ApplicationTemplateName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
   *   for (ApplicationTemplateRevision element :
   *       designCenterClient.listApplicationTemplateRevisions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent from which to list application template revisions.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApplicationTemplateRevisionsPagedResponse listApplicationTemplateRevisions(
      @Nullable ApplicationTemplateName parent) {
    ListApplicationTemplateRevisionsRequest request =
        ListApplicationTemplateRevisionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listApplicationTemplateRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists application template revisions in a given application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent =
   *       ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *           .toString();
   *   for (ApplicationTemplateRevision element :
   *       designCenterClient.listApplicationTemplateRevisions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent from which to list application template revisions.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApplicationTemplateRevisionsPagedResponse listApplicationTemplateRevisions(
      String parent) {
    ListApplicationTemplateRevisionsRequest request =
        ListApplicationTemplateRevisionsRequest.newBuilder().setParent(parent).build();
    return listApplicationTemplateRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists application template revisions in a given application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListApplicationTemplateRevisionsRequest request =
   *       ListApplicationTemplateRevisionsRequest.newBuilder()
   *           .setParent(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ApplicationTemplateRevision element :
   *       designCenterClient.listApplicationTemplateRevisions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApplicationTemplateRevisionsPagedResponse listApplicationTemplateRevisions(
      ListApplicationTemplateRevisionsRequest request) {
    return listApplicationTemplateRevisionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists application template revisions in a given application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListApplicationTemplateRevisionsRequest request =
   *       ListApplicationTemplateRevisionsRequest.newBuilder()
   *           .setParent(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ApplicationTemplateRevision> future =
   *       designCenterClient.listApplicationTemplateRevisionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ApplicationTemplateRevision element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListApplicationTemplateRevisionsRequest, ListApplicationTemplateRevisionsPagedResponse>
      listApplicationTemplateRevisionsPagedCallable() {
    return stub.listApplicationTemplateRevisionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists application template revisions in a given application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListApplicationTemplateRevisionsRequest request =
   *       ListApplicationTemplateRevisionsRequest.newBuilder()
   *           .setParent(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListApplicationTemplateRevisionsResponse response =
   *         designCenterClient.listApplicationTemplateRevisionsCallable().call(request);
   *     for (ApplicationTemplateRevision element : response.getApplicationTemplateRevisionsList()) {
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
          ListApplicationTemplateRevisionsRequest, ListApplicationTemplateRevisionsResponse>
      listApplicationTemplateRevisionsCallable() {
    return stub.listApplicationTemplateRevisionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an application template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationTemplateRevisionName name =
   *       ApplicationTemplateRevisionName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[REVISION]");
   *   designCenterClient.deleteApplicationTemplateRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The application template revision name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteApplicationTemplateRevision(
      @Nullable ApplicationTemplateRevisionName name) {
    DeleteApplicationTemplateRevisionRequest request =
        DeleteApplicationTemplateRevisionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteApplicationTemplateRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an application template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationTemplateRevisionName.of(
   *               "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[REVISION]")
   *           .toString();
   *   designCenterClient.deleteApplicationTemplateRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The application template revision name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteApplicationTemplateRevision(String name) {
    DeleteApplicationTemplateRevisionRequest request =
        DeleteApplicationTemplateRevisionRequest.newBuilder().setName(name).build();
    deleteApplicationTemplateRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an application template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeleteApplicationTemplateRevisionRequest request =
   *       DeleteApplicationTemplateRevisionRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateRevisionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[REVISION]")
   *                   .toString())
   *           .build();
   *   designCenterClient.deleteApplicationTemplateRevision(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteApplicationTemplateRevision(
      DeleteApplicationTemplateRevisionRequest request) {
    deleteApplicationTemplateRevisionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an application template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeleteApplicationTemplateRevisionRequest request =
   *       DeleteApplicationTemplateRevisionRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateRevisionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[REVISION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       designCenterClient.deleteApplicationTemplateRevisionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteApplicationTemplateRevisionRequest, Empty>
      deleteApplicationTemplateRevisionCallable() {
    return stub.deleteApplicationTemplateRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CatalogName name = CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]");
   *   Catalog response = designCenterClient.getCatalog(name);
   * }
   * }</pre>
   *
   * @param name Required. The catalog name in the following format:
   *     `projects/$project/locations/$location/spaces/$space/catalogs/$catalog`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Catalog getCatalog(@Nullable CatalogName name) {
    GetCatalogRequest request =
        GetCatalogRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name = CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString();
   *   Catalog response = designCenterClient.getCatalog(name);
   * }
   * }</pre>
   *
   * @param name Required. The catalog name in the following format:
   *     `projects/$project/locations/$location/spaces/$space/catalogs/$catalog`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Catalog getCatalog(String name) {
    GetCatalogRequest request = GetCatalogRequest.newBuilder().setName(name).build();
    return getCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetCatalogRequest request =
   *       GetCatalogRequest.newBuilder()
   *           .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString())
   *           .build();
   *   Catalog response = designCenterClient.getCatalog(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Catalog getCatalog(GetCatalogRequest request) {
    return getCatalogCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetCatalogRequest request =
   *       GetCatalogRequest.newBuilder()
   *           .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString())
   *           .build();
   *   ApiFuture<Catalog> future = designCenterClient.getCatalogCallable().futureCall(request);
   *   // Do something.
   *   Catalog response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCatalogRequest, Catalog> getCatalogCallable() {
    return stub.getCatalogCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists catalogs in a given space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   SpaceName parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
   *   for (Catalog element : designCenterClient.listCatalogs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent space from which catalogs are listed. Format:
   *     `projects/$project/locations/$location/spaces/$space`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCatalogsPagedResponse listCatalogs(@Nullable SpaceName parent) {
    ListCatalogsRequest request =
        ListCatalogsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCatalogs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists catalogs in a given space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString();
   *   for (Catalog element : designCenterClient.listCatalogs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent space from which catalogs are listed. Format:
   *     `projects/$project/locations/$location/spaces/$space`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCatalogsPagedResponse listCatalogs(String parent) {
    ListCatalogsRequest request = ListCatalogsRequest.newBuilder().setParent(parent).build();
    return listCatalogs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists catalogs in a given space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListCatalogsRequest request =
   *       ListCatalogsRequest.newBuilder()
   *           .setParent(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Catalog element : designCenterClient.listCatalogs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCatalogsPagedResponse listCatalogs(ListCatalogsRequest request) {
    return listCatalogsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists catalogs in a given space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListCatalogsRequest request =
   *       ListCatalogsRequest.newBuilder()
   *           .setParent(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Catalog> future =
   *       designCenterClient.listCatalogsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Catalog element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCatalogsRequest, ListCatalogsPagedResponse>
      listCatalogsPagedCallable() {
    return stub.listCatalogsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists catalogs in a given space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListCatalogsRequest request =
   *       ListCatalogsRequest.newBuilder()
   *           .setParent(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCatalogsResponse response = designCenterClient.listCatalogsCallable().call(request);
   *     for (Catalog element : response.getCatalogsList()) {
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
  public final UnaryCallable<ListCatalogsRequest, ListCatalogsResponse> listCatalogsCallable() {
    return stub.listCatalogsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   SpaceName parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
   *   Catalog catalog = Catalog.newBuilder().build();
   *   String catalogId = "catalogId1455933204";
   *   Catalog response = designCenterClient.createCatalog(parent, catalog, catalogId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent space in which a catalog is created in the following format:
   *     `projects/$project/locations/$location/spaces/$space`
   * @param catalog Required. The catalog to create.
   * @param catalogId Required. The ID of the catalog to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Catalog createCatalog(
      @Nullable SpaceName parent, Catalog catalog, String catalogId) {
    CreateCatalogRequest request =
        CreateCatalogRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCatalog(catalog)
            .setCatalogId(catalogId)
            .build();
    return createCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString();
   *   Catalog catalog = Catalog.newBuilder().build();
   *   String catalogId = "catalogId1455933204";
   *   Catalog response = designCenterClient.createCatalog(parent, catalog, catalogId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent space in which a catalog is created in the following format:
   *     `projects/$project/locations/$location/spaces/$space`
   * @param catalog Required. The catalog to create.
   * @param catalogId Required. The ID of the catalog to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Catalog createCatalog(String parent, Catalog catalog, String catalogId) {
    CreateCatalogRequest request =
        CreateCatalogRequest.newBuilder()
            .setParent(parent)
            .setCatalog(catalog)
            .setCatalogId(catalogId)
            .build();
    return createCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CreateCatalogRequest request =
   *       CreateCatalogRequest.newBuilder()
   *           .setParent(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setCatalogId("catalogId1455933204")
   *           .setCatalog(Catalog.newBuilder().build())
   *           .build();
   *   Catalog response = designCenterClient.createCatalog(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Catalog createCatalog(CreateCatalogRequest request) {
    return createCatalogCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CreateCatalogRequest request =
   *       CreateCatalogRequest.newBuilder()
   *           .setParent(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setCatalogId("catalogId1455933204")
   *           .setCatalog(Catalog.newBuilder().build())
   *           .build();
   *   ApiFuture<Catalog> future = designCenterClient.createCatalogCallable().futureCall(request);
   *   // Do something.
   *   Catalog response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCatalogRequest, Catalog> createCatalogCallable() {
    return stub.createCatalogCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   Catalog catalog = Catalog.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Catalog response = designCenterClient.updateCatalog(catalog, updateMask);
   * }
   * }</pre>
   *
   * @param catalog Required. The catalog to update.
   * @param updateMask Optional. The fields to overwrite in the catalog update. If you don't provide
   *     a mask, all fields are overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Catalog updateCatalog(Catalog catalog, FieldMask updateMask) {
    UpdateCatalogRequest request =
        UpdateCatalogRequest.newBuilder().setCatalog(catalog).setUpdateMask(updateMask).build();
    return updateCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   UpdateCatalogRequest request =
   *       UpdateCatalogRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCatalog(Catalog.newBuilder().build())
   *           .build();
   *   Catalog response = designCenterClient.updateCatalog(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Catalog updateCatalog(UpdateCatalogRequest request) {
    return updateCatalogCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   UpdateCatalogRequest request =
   *       UpdateCatalogRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCatalog(Catalog.newBuilder().build())
   *           .build();
   *   ApiFuture<Catalog> future = designCenterClient.updateCatalogCallable().futureCall(request);
   *   // Do something.
   *   Catalog response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCatalogRequest, Catalog> updateCatalogCallable() {
    return stub.updateCatalogCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CatalogName name = CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]");
   *   designCenterClient.deleteCatalogAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The catalog name in the following format:
   *     `projects/$project/locations/$location/spaces/$space/catalogs/$catalog`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCatalogAsync(
      @Nullable CatalogName name) {
    DeleteCatalogRequest request =
        DeleteCatalogRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteCatalogAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name = CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString();
   *   designCenterClient.deleteCatalogAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The catalog name in the following format:
   *     `projects/$project/locations/$location/spaces/$space/catalogs/$catalog`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCatalogAsync(String name) {
    DeleteCatalogRequest request = DeleteCatalogRequest.newBuilder().setName(name).build();
    return deleteCatalogAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeleteCatalogRequest request =
   *       DeleteCatalogRequest.newBuilder()
   *           .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString())
   *           .setForce(true)
   *           .build();
   *   designCenterClient.deleteCatalogAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCatalogAsync(
      DeleteCatalogRequest request) {
    return deleteCatalogOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeleteCatalogRequest request =
   *       DeleteCatalogRequest.newBuilder()
   *           .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString())
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       designCenterClient.deleteCatalogOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteCatalogRequest, Empty, OperationMetadata>
      deleteCatalogOperationCallable() {
    return stub.deleteCatalogOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeleteCatalogRequest request =
   *       DeleteCatalogRequest.newBuilder()
   *           .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future = designCenterClient.deleteCatalogCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCatalogRequest, Operation> deleteCatalogCallable() {
    return stub.deleteCatalogCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a template to a catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]");
   *   CatalogTemplate catalogTemplate = CatalogTemplate.newBuilder().build();
   *   String catalogTemplateId = "catalogTemplateId-1740091346";
   *   CatalogTemplate response =
   *       designCenterClient.createCatalogTemplate(parent, catalogTemplate, catalogTemplateId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource in which the catalog template is created.
   * @param catalogTemplate Required. The catalog template to create.
   * @param catalogTemplateId Required. The ID of the catalog template to create. The ID is appended
   *     to the catalog template's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CatalogTemplate createCatalogTemplate(
      @Nullable CatalogName parent, CatalogTemplate catalogTemplate, String catalogTemplateId) {
    CreateCatalogTemplateRequest request =
        CreateCatalogTemplateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCatalogTemplate(catalogTemplate)
            .setCatalogTemplateId(catalogTemplateId)
            .build();
    return createCatalogTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a template to a catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString();
   *   CatalogTemplate catalogTemplate = CatalogTemplate.newBuilder().build();
   *   String catalogTemplateId = "catalogTemplateId-1740091346";
   *   CatalogTemplate response =
   *       designCenterClient.createCatalogTemplate(parent, catalogTemplate, catalogTemplateId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource in which the catalog template is created.
   * @param catalogTemplate Required. The catalog template to create.
   * @param catalogTemplateId Required. The ID of the catalog template to create. The ID is appended
   *     to the catalog template's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CatalogTemplate createCatalogTemplate(
      String parent, CatalogTemplate catalogTemplate, String catalogTemplateId) {
    CreateCatalogTemplateRequest request =
        CreateCatalogTemplateRequest.newBuilder()
            .setParent(parent)
            .setCatalogTemplate(catalogTemplate)
            .setCatalogTemplateId(catalogTemplateId)
            .build();
    return createCatalogTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a template to a catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CreateCatalogTemplateRequest request =
   *       CreateCatalogTemplateRequest.newBuilder()
   *           .setParent(
   *               CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString())
   *           .setCatalogTemplateId("catalogTemplateId-1740091346")
   *           .setCatalogTemplate(CatalogTemplate.newBuilder().build())
   *           .build();
   *   CatalogTemplate response = designCenterClient.createCatalogTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CatalogTemplate createCatalogTemplate(CreateCatalogTemplateRequest request) {
    return createCatalogTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a template to a catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CreateCatalogTemplateRequest request =
   *       CreateCatalogTemplateRequest.newBuilder()
   *           .setParent(
   *               CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString())
   *           .setCatalogTemplateId("catalogTemplateId-1740091346")
   *           .setCatalogTemplate(CatalogTemplate.newBuilder().build())
   *           .build();
   *   ApiFuture<CatalogTemplate> future =
   *       designCenterClient.createCatalogTemplateCallable().futureCall(request);
   *   // Do something.
   *   CatalogTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCatalogTemplateRequest, CatalogTemplate>
      createCatalogTemplateCallable() {
    return stub.createCatalogTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a catalog template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CatalogTemplateName name =
   *       CatalogTemplateName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]");
   *   CatalogTemplate response = designCenterClient.getCatalogTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The catalog template name in the following format:
   *     `projects/$project/locations/$location/spaces/$space/catalogs/$catalog/templates/$template`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CatalogTemplate getCatalogTemplate(@Nullable CatalogTemplateName name) {
    GetCatalogTemplateRequest request =
        GetCatalogTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCatalogTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a catalog template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       CatalogTemplateName.of(
   *               "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]")
   *           .toString();
   *   CatalogTemplate response = designCenterClient.getCatalogTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The catalog template name in the following format:
   *     `projects/$project/locations/$location/spaces/$space/catalogs/$catalog/templates/$template`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CatalogTemplate getCatalogTemplate(String name) {
    GetCatalogTemplateRequest request =
        GetCatalogTemplateRequest.newBuilder().setName(name).build();
    return getCatalogTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a catalog template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetCatalogTemplateRequest request =
   *       GetCatalogTemplateRequest.newBuilder()
   *           .setName(
   *               CatalogTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   CatalogTemplate response = designCenterClient.getCatalogTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CatalogTemplate getCatalogTemplate(GetCatalogTemplateRequest request) {
    return getCatalogTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a catalog template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetCatalogTemplateRequest request =
   *       GetCatalogTemplateRequest.newBuilder()
   *           .setName(
   *               CatalogTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CatalogTemplate> future =
   *       designCenterClient.getCatalogTemplateCallable().futureCall(request);
   *   // Do something.
   *   CatalogTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCatalogTemplateRequest, CatalogTemplate>
      getCatalogTemplateCallable() {
    return stub.getCatalogTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists catalog templates.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]");
   *   for (CatalogTemplate element : designCenterClient.listCatalogTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent from which the catalog templates are listed in the following
   *     format: `projects/$project/locations/$location/spaces/$space/catalogs/$catalog`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCatalogTemplatesPagedResponse listCatalogTemplates(
      @Nullable CatalogName parent) {
    ListCatalogTemplatesRequest request =
        ListCatalogTemplatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCatalogTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists catalog templates.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString();
   *   for (CatalogTemplate element : designCenterClient.listCatalogTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent from which the catalog templates are listed in the following
   *     format: `projects/$project/locations/$location/spaces/$space/catalogs/$catalog`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCatalogTemplatesPagedResponse listCatalogTemplates(String parent) {
    ListCatalogTemplatesRequest request =
        ListCatalogTemplatesRequest.newBuilder().setParent(parent).build();
    return listCatalogTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists catalog templates.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListCatalogTemplatesRequest request =
   *       ListCatalogTemplatesRequest.newBuilder()
   *           .setParent(
   *               CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (CatalogTemplate element :
   *       designCenterClient.listCatalogTemplates(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCatalogTemplatesPagedResponse listCatalogTemplates(
      ListCatalogTemplatesRequest request) {
    return listCatalogTemplatesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists catalog templates.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListCatalogTemplatesRequest request =
   *       ListCatalogTemplatesRequest.newBuilder()
   *           .setParent(
   *               CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<CatalogTemplate> future =
   *       designCenterClient.listCatalogTemplatesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CatalogTemplate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCatalogTemplatesRequest, ListCatalogTemplatesPagedResponse>
      listCatalogTemplatesPagedCallable() {
    return stub.listCatalogTemplatesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists catalog templates.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListCatalogTemplatesRequest request =
   *       ListCatalogTemplatesRequest.newBuilder()
   *           .setParent(
   *               CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCatalogTemplatesResponse response =
   *         designCenterClient.listCatalogTemplatesCallable().call(request);
   *     for (CatalogTemplate element : response.getCatalogTemplatesList()) {
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
  public final UnaryCallable<ListCatalogTemplatesRequest, ListCatalogTemplatesResponse>
      listCatalogTemplatesCallable() {
    return stub.listCatalogTemplatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a catalog template resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CatalogTemplate catalogTemplate = CatalogTemplate.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CatalogTemplate response =
   *       designCenterClient.updateCatalogTemplate(catalogTemplate, updateMask);
   * }
   * }</pre>
   *
   * @param catalogTemplate Required. The catalog template to update. Format:
   *     `projects/$project/locations/$location/spaces/$space/catalogs/$catalog/templates/$template`
   * @param updateMask Optional. The fields to overwrite in the catalog template update. The fields
   *     specified in the update_mask are relative to the resource, not the full request. A field
   *     will be overwritten if it is in the mask. If you don't provide a mask, all fields are
   *     overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CatalogTemplate updateCatalogTemplate(
      CatalogTemplate catalogTemplate, FieldMask updateMask) {
    UpdateCatalogTemplateRequest request =
        UpdateCatalogTemplateRequest.newBuilder()
            .setCatalogTemplate(catalogTemplate)
            .setUpdateMask(updateMask)
            .build();
    return updateCatalogTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a catalog template resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   UpdateCatalogTemplateRequest request =
   *       UpdateCatalogTemplateRequest.newBuilder()
   *           .setCatalogTemplate(CatalogTemplate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   CatalogTemplate response = designCenterClient.updateCatalogTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CatalogTemplate updateCatalogTemplate(UpdateCatalogTemplateRequest request) {
    return updateCatalogTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a catalog template resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   UpdateCatalogTemplateRequest request =
   *       UpdateCatalogTemplateRequest.newBuilder()
   *           .setCatalogTemplate(CatalogTemplate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<CatalogTemplate> future =
   *       designCenterClient.updateCatalogTemplateCallable().futureCall(request);
   *   // Do something.
   *   CatalogTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCatalogTemplateRequest, CatalogTemplate>
      updateCatalogTemplateCallable() {
    return stub.updateCatalogTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a catalog template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CatalogTemplateName name =
   *       CatalogTemplateName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]");
   *   designCenterClient.deleteCatalogTemplateAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The catalog template name. Format:
   *     `projects/$project/locations/$location/spaces/$space/catalogs/$catalog/templates/$template`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCatalogTemplateAsync(
      @Nullable CatalogTemplateName name) {
    DeleteCatalogTemplateRequest request =
        DeleteCatalogTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteCatalogTemplateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a catalog template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       CatalogTemplateName.of(
   *               "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]")
   *           .toString();
   *   designCenterClient.deleteCatalogTemplateAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The catalog template name. Format:
   *     `projects/$project/locations/$location/spaces/$space/catalogs/$catalog/templates/$template`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCatalogTemplateAsync(String name) {
    DeleteCatalogTemplateRequest request =
        DeleteCatalogTemplateRequest.newBuilder().setName(name).build();
    return deleteCatalogTemplateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a catalog template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeleteCatalogTemplateRequest request =
   *       DeleteCatalogTemplateRequest.newBuilder()
   *           .setName(
   *               CatalogTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   designCenterClient.deleteCatalogTemplateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCatalogTemplateAsync(
      DeleteCatalogTemplateRequest request) {
    return deleteCatalogTemplateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a catalog template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeleteCatalogTemplateRequest request =
   *       DeleteCatalogTemplateRequest.newBuilder()
   *           .setName(
   *               CatalogTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       designCenterClient.deleteCatalogTemplateOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteCatalogTemplateRequest, Empty, OperationMetadata>
      deleteCatalogTemplateOperationCallable() {
    return stub.deleteCatalogTemplateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a catalog template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeleteCatalogTemplateRequest request =
   *       DeleteCatalogTemplateRequest.newBuilder()
   *           .setName(
   *               CatalogTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       designCenterClient.deleteCatalogTemplateCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCatalogTemplateRequest, Operation>
      deleteCatalogTemplateCallable() {
    return stub.deleteCatalogTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Shares a catalog from one space to another space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]");
   *   Share share = Share.newBuilder().build();
   *   String shareId = "shareId2054217050";
   *   Share response = designCenterClient.createShareAsync(parent, share, shareId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource in which shares are created.
   * @param share Required. The share to create.
   * @param shareId Required. The ID of the share to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Share, OperationMetadata> createShareAsync(
      @Nullable CatalogName parent, Share share, String shareId) {
    CreateShareRequest request =
        CreateShareRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setShare(share)
            .setShareId(shareId)
            .build();
    return createShareAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Shares a catalog from one space to another space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString();
   *   Share share = Share.newBuilder().build();
   *   String shareId = "shareId2054217050";
   *   Share response = designCenterClient.createShareAsync(parent, share, shareId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource in which shares are created.
   * @param share Required. The share to create.
   * @param shareId Required. The ID of the share to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Share, OperationMetadata> createShareAsync(
      String parent, Share share, String shareId) {
    CreateShareRequest request =
        CreateShareRequest.newBuilder()
            .setParent(parent)
            .setShare(share)
            .setShareId(shareId)
            .build();
    return createShareAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Shares a catalog from one space to another space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CreateShareRequest request =
   *       CreateShareRequest.newBuilder()
   *           .setParent(
   *               CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString())
   *           .setShareId("shareId2054217050")
   *           .setShare(Share.newBuilder().build())
   *           .build();
   *   Share response = designCenterClient.createShareAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Share, OperationMetadata> createShareAsync(
      CreateShareRequest request) {
    return createShareOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Shares a catalog from one space to another space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CreateShareRequest request =
   *       CreateShareRequest.newBuilder()
   *           .setParent(
   *               CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString())
   *           .setShareId("shareId2054217050")
   *           .setShare(Share.newBuilder().build())
   *           .build();
   *   OperationFuture<Share, OperationMetadata> future =
   *       designCenterClient.createShareOperationCallable().futureCall(request);
   *   // Do something.
   *   Share response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateShareRequest, Share, OperationMetadata>
      createShareOperationCallable() {
    return stub.createShareOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Shares a catalog from one space to another space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CreateShareRequest request =
   *       CreateShareRequest.newBuilder()
   *           .setParent(
   *               CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString())
   *           .setShareId("shareId2054217050")
   *           .setShare(Share.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = designCenterClient.createShareCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateShareRequest, Operation> createShareCallable() {
    return stub.createShareCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists catalog share objects for the space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]");
   *   for (Share element : designCenterClient.listShares(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource from which a list of shares is requested.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSharesPagedResponse listShares(@Nullable CatalogName parent) {
    ListSharesRequest request =
        ListSharesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listShares(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists catalog share objects for the space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString();
   *   for (Share element : designCenterClient.listShares(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource from which a list of shares is requested.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSharesPagedResponse listShares(String parent) {
    ListSharesRequest request = ListSharesRequest.newBuilder().setParent(parent).build();
    return listShares(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists catalog share objects for the space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListSharesRequest request =
   *       ListSharesRequest.newBuilder()
   *           .setParent(
   *               CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Share element : designCenterClient.listShares(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSharesPagedResponse listShares(ListSharesRequest request) {
    return listSharesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists catalog share objects for the space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListSharesRequest request =
   *       ListSharesRequest.newBuilder()
   *           .setParent(
   *               CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Share> future = designCenterClient.listSharesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Share element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSharesRequest, ListSharesPagedResponse> listSharesPagedCallable() {
    return stub.listSharesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists catalog share objects for the space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListSharesRequest request =
   *       ListSharesRequest.newBuilder()
   *           .setParent(
   *               CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListSharesResponse response = designCenterClient.listSharesCallable().call(request);
   *     for (Share element : response.getSharesList()) {
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
  public final UnaryCallable<ListSharesRequest, ListSharesResponse> listSharesCallable() {
    return stub.listSharesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get catalog share object for the space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ShareName name = ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]");
   *   Share response = designCenterClient.getShare(name);
   * }
   * }</pre>
   *
   * @param name Required. The share name in the following format:
   *     `projects/$project/locations/$location/spaces/$space/catalogs/$catalog/shares/$share`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Share getShare(@Nullable ShareName name) {
    GetShareRequest request =
        GetShareRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getShare(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get catalog share object for the space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]").toString();
   *   Share response = designCenterClient.getShare(name);
   * }
   * }</pre>
   *
   * @param name Required. The share name in the following format:
   *     `projects/$project/locations/$location/spaces/$space/catalogs/$catalog/shares/$share`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Share getShare(String name) {
    GetShareRequest request = GetShareRequest.newBuilder().setName(name).build();
    return getShare(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get catalog share object for the space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetShareRequest request =
   *       GetShareRequest.newBuilder()
   *           .setName(
   *               ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]")
   *                   .toString())
   *           .build();
   *   Share response = designCenterClient.getShare(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Share getShare(GetShareRequest request) {
    return getShareCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get catalog share object for the space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetShareRequest request =
   *       GetShareRequest.newBuilder()
   *           .setName(
   *               ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Share> future = designCenterClient.getShareCallable().futureCall(request);
   *   // Do something.
   *   Share response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetShareRequest, Share> getShareCallable() {
    return stub.getShareCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a catalog share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ShareName name = ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]");
   *   designCenterClient.deleteShareAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The share name in the following format:
   *     `projects/$project/locations/$location/spaces/$space/catalogs/$catalog/shares/$share`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteShareAsync(
      @Nullable ShareName name) {
    DeleteShareRequest request =
        DeleteShareRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteShareAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a catalog share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]").toString();
   *   designCenterClient.deleteShareAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The share name in the following format:
   *     `projects/$project/locations/$location/spaces/$space/catalogs/$catalog/shares/$share`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteShareAsync(String name) {
    DeleteShareRequest request = DeleteShareRequest.newBuilder().setName(name).build();
    return deleteShareAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a catalog share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeleteShareRequest request =
   *       DeleteShareRequest.newBuilder()
   *           .setName(
   *               ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]")
   *                   .toString())
   *           .build();
   *   designCenterClient.deleteShareAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteShareAsync(
      DeleteShareRequest request) {
    return deleteShareOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a catalog share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeleteShareRequest request =
   *       DeleteShareRequest.newBuilder()
   *           .setName(
   *               ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       designCenterClient.deleteShareOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteShareRequest, Empty, OperationMetadata>
      deleteShareOperationCallable() {
    return stub.deleteShareOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a catalog share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeleteShareRequest request =
   *       DeleteShareRequest.newBuilder()
   *           .setName(
   *               ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future = designCenterClient.deleteShareCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteShareRequest, Operation> deleteShareCallable() {
    return stub.deleteShareCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Synchronizes a share and updates the destination workspace to reflect. reflect the most recent
   * changes to the catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ShareName name = ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]");
   *   Share response = designCenterClient.syncShareAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The share name in the following format:
   *     `projects/$project/locations/$location/spaces/$space/catalogs/$catalog/shares/$share`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Share, OperationMetadata> syncShareAsync(@Nullable ShareName name) {
    SyncShareRequest request =
        SyncShareRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return syncShareAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Synchronizes a share and updates the destination workspace to reflect. reflect the most recent
   * changes to the catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]").toString();
   *   Share response = designCenterClient.syncShareAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The share name in the following format:
   *     `projects/$project/locations/$location/spaces/$space/catalogs/$catalog/shares/$share`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Share, OperationMetadata> syncShareAsync(String name) {
    SyncShareRequest request = SyncShareRequest.newBuilder().setName(name).build();
    return syncShareAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Synchronizes a share and updates the destination workspace to reflect. reflect the most recent
   * changes to the catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   SyncShareRequest request =
   *       SyncShareRequest.newBuilder()
   *           .setName(
   *               ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]")
   *                   .toString())
   *           .build();
   *   Share response = designCenterClient.syncShareAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Share, OperationMetadata> syncShareAsync(SyncShareRequest request) {
    return syncShareOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Synchronizes a share and updates the destination workspace to reflect. reflect the most recent
   * changes to the catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   SyncShareRequest request =
   *       SyncShareRequest.newBuilder()
   *           .setName(
   *               ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Share, OperationMetadata> future =
   *       designCenterClient.syncShareOperationCallable().futureCall(request);
   *   // Do something.
   *   Share response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SyncShareRequest, Share, OperationMetadata>
      syncShareOperationCallable() {
    return stub.syncShareOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Synchronizes a share and updates the destination workspace to reflect. reflect the most recent
   * changes to the catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   SyncShareRequest request =
   *       SyncShareRequest.newBuilder()
   *           .setName(
   *               ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future = designCenterClient.syncShareCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SyncShareRequest, Operation> syncShareCallable() {
    return stub.syncShareCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a shared template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   SharedTemplateName name =
   *       SharedTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[SHARED_TEMPLATE]");
   *   SharedTemplate response = designCenterClient.getSharedTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The shared template name. Format:
   *     `projects/$project/locations/$location/spaces/$space/sharedTemplates/$sharedTemplate`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SharedTemplate getSharedTemplate(@Nullable SharedTemplateName name) {
    GetSharedTemplateRequest request =
        GetSharedTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getSharedTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a shared template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       SharedTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[SHARED_TEMPLATE]")
   *           .toString();
   *   SharedTemplate response = designCenterClient.getSharedTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The shared template name. Format:
   *     `projects/$project/locations/$location/spaces/$space/sharedTemplates/$sharedTemplate`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SharedTemplate getSharedTemplate(String name) {
    GetSharedTemplateRequest request = GetSharedTemplateRequest.newBuilder().setName(name).build();
    return getSharedTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a shared template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetSharedTemplateRequest request =
   *       GetSharedTemplateRequest.newBuilder()
   *           .setName(
   *               SharedTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[SHARED_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   SharedTemplate response = designCenterClient.getSharedTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SharedTemplate getSharedTemplate(GetSharedTemplateRequest request) {
    return getSharedTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a shared template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetSharedTemplateRequest request =
   *       GetSharedTemplateRequest.newBuilder()
   *           .setName(
   *               SharedTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[SHARED_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<SharedTemplate> future =
   *       designCenterClient.getSharedTemplateCallable().futureCall(request);
   *   // Do something.
   *   SharedTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSharedTemplateRequest, SharedTemplate> getSharedTemplateCallable() {
    return stub.getSharedTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists shared templates in a given space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   SpaceName parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
   *   for (SharedTemplate element : designCenterClient.listSharedTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent space for which shared templates are listed in the following
   *     format: `projects/$project/locations/$location/spaces/$space`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSharedTemplatesPagedResponse listSharedTemplates(@Nullable SpaceName parent) {
    ListSharedTemplatesRequest request =
        ListSharedTemplatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSharedTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists shared templates in a given space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString();
   *   for (SharedTemplate element : designCenterClient.listSharedTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent space for which shared templates are listed in the following
   *     format: `projects/$project/locations/$location/spaces/$space`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSharedTemplatesPagedResponse listSharedTemplates(String parent) {
    ListSharedTemplatesRequest request =
        ListSharedTemplatesRequest.newBuilder().setParent(parent).build();
    return listSharedTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists shared templates in a given space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListSharedTemplatesRequest request =
   *       ListSharedTemplatesRequest.newBuilder()
   *           .setParent(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (SharedTemplate element : designCenterClient.listSharedTemplates(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSharedTemplatesPagedResponse listSharedTemplates(
      ListSharedTemplatesRequest request) {
    return listSharedTemplatesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists shared templates in a given space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListSharedTemplatesRequest request =
   *       ListSharedTemplatesRequest.newBuilder()
   *           .setParent(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<SharedTemplate> future =
   *       designCenterClient.listSharedTemplatesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SharedTemplate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSharedTemplatesRequest, ListSharedTemplatesPagedResponse>
      listSharedTemplatesPagedCallable() {
    return stub.listSharedTemplatesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists shared templates in a given space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListSharedTemplatesRequest request =
   *       ListSharedTemplatesRequest.newBuilder()
   *           .setParent(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListSharedTemplatesResponse response =
   *         designCenterClient.listSharedTemplatesCallable().call(request);
   *     for (SharedTemplate element : response.getSharedTemplatesList()) {
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
  public final UnaryCallable<ListSharedTemplatesRequest, ListSharedTemplatesResponse>
      listSharedTemplatesCallable() {
    return stub.listSharedTemplatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a shared template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   SharedTemplateRevisionName name =
   *       SharedTemplateRevisionName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[SHARED_TEMPLATE]", "[REVISION]");
   *   SharedTemplateRevision response = designCenterClient.getSharedTemplateRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The shared template revision name, in the following format:
   *     `projects/$project/locations/$location/spaces/$space/sharedTemplates/$sharedTemplate/revisions/$revision`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SharedTemplateRevision getSharedTemplateRevision(
      @Nullable SharedTemplateRevisionName name) {
    GetSharedTemplateRevisionRequest request =
        GetSharedTemplateRevisionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getSharedTemplateRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a shared template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       SharedTemplateRevisionName.of(
   *               "[PROJECT]", "[LOCATION]", "[SPACE]", "[SHARED_TEMPLATE]", "[REVISION]")
   *           .toString();
   *   SharedTemplateRevision response = designCenterClient.getSharedTemplateRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The shared template revision name, in the following format:
   *     `projects/$project/locations/$location/spaces/$space/sharedTemplates/$sharedTemplate/revisions/$revision`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SharedTemplateRevision getSharedTemplateRevision(String name) {
    GetSharedTemplateRevisionRequest request =
        GetSharedTemplateRevisionRequest.newBuilder().setName(name).build();
    return getSharedTemplateRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a shared template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetSharedTemplateRevisionRequest request =
   *       GetSharedTemplateRevisionRequest.newBuilder()
   *           .setName(
   *               SharedTemplateRevisionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[SHARED_TEMPLATE]", "[REVISION]")
   *                   .toString())
   *           .build();
   *   SharedTemplateRevision response = designCenterClient.getSharedTemplateRevision(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SharedTemplateRevision getSharedTemplateRevision(
      GetSharedTemplateRevisionRequest request) {
    return getSharedTemplateRevisionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a shared template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetSharedTemplateRevisionRequest request =
   *       GetSharedTemplateRevisionRequest.newBuilder()
   *           .setName(
   *               SharedTemplateRevisionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[SHARED_TEMPLATE]", "[REVISION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<SharedTemplateRevision> future =
   *       designCenterClient.getSharedTemplateRevisionCallable().futureCall(request);
   *   // Do something.
   *   SharedTemplateRevision response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSharedTemplateRevisionRequest, SharedTemplateRevision>
      getSharedTemplateRevisionCallable() {
    return stub.getSharedTemplateRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists shared template revisions in a given space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   SharedTemplateName parent =
   *       SharedTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[SHARED_TEMPLATE]");
   *   for (SharedTemplateRevision element :
   *       designCenterClient.listSharedTemplateRevisions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource from which to list shared template revisions, in
   *     the following format:
   *     `projects/$project/locations/$location/spaces/$space/sharedTemplates/$sharedTemplate`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSharedTemplateRevisionsPagedResponse listSharedTemplateRevisions(
      @Nullable SharedTemplateName parent) {
    ListSharedTemplateRevisionsRequest request =
        ListSharedTemplateRevisionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSharedTemplateRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists shared template revisions in a given space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent =
   *       SharedTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[SHARED_TEMPLATE]")
   *           .toString();
   *   for (SharedTemplateRevision element :
   *       designCenterClient.listSharedTemplateRevisions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource from which to list shared template revisions, in
   *     the following format:
   *     `projects/$project/locations/$location/spaces/$space/sharedTemplates/$sharedTemplate`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSharedTemplateRevisionsPagedResponse listSharedTemplateRevisions(String parent) {
    ListSharedTemplateRevisionsRequest request =
        ListSharedTemplateRevisionsRequest.newBuilder().setParent(parent).build();
    return listSharedTemplateRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists shared template revisions in a given space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListSharedTemplateRevisionsRequest request =
   *       ListSharedTemplateRevisionsRequest.newBuilder()
   *           .setParent(
   *               SharedTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[SHARED_TEMPLATE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (SharedTemplateRevision element :
   *       designCenterClient.listSharedTemplateRevisions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSharedTemplateRevisionsPagedResponse listSharedTemplateRevisions(
      ListSharedTemplateRevisionsRequest request) {
    return listSharedTemplateRevisionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists shared template revisions in a given space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListSharedTemplateRevisionsRequest request =
   *       ListSharedTemplateRevisionsRequest.newBuilder()
   *           .setParent(
   *               SharedTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[SHARED_TEMPLATE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<SharedTemplateRevision> future =
   *       designCenterClient.listSharedTemplateRevisionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SharedTemplateRevision element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListSharedTemplateRevisionsRequest, ListSharedTemplateRevisionsPagedResponse>
      listSharedTemplateRevisionsPagedCallable() {
    return stub.listSharedTemplateRevisionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists shared template revisions in a given space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListSharedTemplateRevisionsRequest request =
   *       ListSharedTemplateRevisionsRequest.newBuilder()
   *           .setParent(
   *               SharedTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[SHARED_TEMPLATE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListSharedTemplateRevisionsResponse response =
   *         designCenterClient.listSharedTemplateRevisionsCallable().call(request);
   *     for (SharedTemplateRevision element : response.getSharedTemplateRevisionsList()) {
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
          ListSharedTemplateRevisionsRequest, ListSharedTemplateRevisionsResponse>
      listSharedTemplateRevisionsCallable() {
    return stub.listSharedTemplateRevisionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CatalogTemplateName parent =
   *       CatalogTemplateName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]");
   *   CatalogTemplateRevision catalogTemplateRevision =
   *       CatalogTemplateRevision.newBuilder().build();
   *   String catalogTemplateRevisionId = "catalogTemplateRevisionId1620031081";
   *   CatalogTemplateRevision response =
   *       designCenterClient
   *           .createCatalogTemplateRevisionAsync(
   *               parent, catalogTemplateRevision, catalogTemplateRevisionId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent in which the catalog template revisions request is created
   *     in following format:
   *     `projects/$project/locations/$location/spaces/$space/templates/$template`
   * @param catalogTemplateRevision Required. The template revision to create.
   * @param catalogTemplateRevisionId Required. The ID of the template revision to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CatalogTemplateRevision, OperationMetadata>
      createCatalogTemplateRevisionAsync(
          @Nullable CatalogTemplateName parent,
          CatalogTemplateRevision catalogTemplateRevision,
          String catalogTemplateRevisionId) {
    CreateCatalogTemplateRevisionRequest request =
        CreateCatalogTemplateRevisionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCatalogTemplateRevision(catalogTemplateRevision)
            .setCatalogTemplateRevisionId(catalogTemplateRevisionId)
            .build();
    return createCatalogTemplateRevisionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent =
   *       CatalogTemplateName.of(
   *               "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]")
   *           .toString();
   *   CatalogTemplateRevision catalogTemplateRevision =
   *       CatalogTemplateRevision.newBuilder().build();
   *   String catalogTemplateRevisionId = "catalogTemplateRevisionId1620031081";
   *   CatalogTemplateRevision response =
   *       designCenterClient
   *           .createCatalogTemplateRevisionAsync(
   *               parent, catalogTemplateRevision, catalogTemplateRevisionId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent in which the catalog template revisions request is created
   *     in following format:
   *     `projects/$project/locations/$location/spaces/$space/templates/$template`
   * @param catalogTemplateRevision Required. The template revision to create.
   * @param catalogTemplateRevisionId Required. The ID of the template revision to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CatalogTemplateRevision, OperationMetadata>
      createCatalogTemplateRevisionAsync(
          String parent,
          CatalogTemplateRevision catalogTemplateRevision,
          String catalogTemplateRevisionId) {
    CreateCatalogTemplateRevisionRequest request =
        CreateCatalogTemplateRevisionRequest.newBuilder()
            .setParent(parent)
            .setCatalogTemplateRevision(catalogTemplateRevision)
            .setCatalogTemplateRevisionId(catalogTemplateRevisionId)
            .build();
    return createCatalogTemplateRevisionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CreateCatalogTemplateRevisionRequest request =
   *       CreateCatalogTemplateRevisionRequest.newBuilder()
   *           .setParent(
   *               CatalogTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]")
   *                   .toString())
   *           .setCatalogTemplateRevisionId("catalogTemplateRevisionId1620031081")
   *           .setCatalogTemplateRevision(CatalogTemplateRevision.newBuilder().build())
   *           .build();
   *   CatalogTemplateRevision response =
   *       designCenterClient.createCatalogTemplateRevisionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CatalogTemplateRevision, OperationMetadata>
      createCatalogTemplateRevisionAsync(CreateCatalogTemplateRevisionRequest request) {
    return createCatalogTemplateRevisionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CreateCatalogTemplateRevisionRequest request =
   *       CreateCatalogTemplateRevisionRequest.newBuilder()
   *           .setParent(
   *               CatalogTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]")
   *                   .toString())
   *           .setCatalogTemplateRevisionId("catalogTemplateRevisionId1620031081")
   *           .setCatalogTemplateRevision(CatalogTemplateRevision.newBuilder().build())
   *           .build();
   *   OperationFuture<CatalogTemplateRevision, OperationMetadata> future =
   *       designCenterClient.createCatalogTemplateRevisionOperationCallable().futureCall(request);
   *   // Do something.
   *   CatalogTemplateRevision response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateCatalogTemplateRevisionRequest, CatalogTemplateRevision, OperationMetadata>
      createCatalogTemplateRevisionOperationCallable() {
    return stub.createCatalogTemplateRevisionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CreateCatalogTemplateRevisionRequest request =
   *       CreateCatalogTemplateRevisionRequest.newBuilder()
   *           .setParent(
   *               CatalogTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]")
   *                   .toString())
   *           .setCatalogTemplateRevisionId("catalogTemplateRevisionId1620031081")
   *           .setCatalogTemplateRevision(CatalogTemplateRevision.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       designCenterClient.createCatalogTemplateRevisionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCatalogTemplateRevisionRequest, Operation>
      createCatalogTemplateRevisionCallable() {
    return stub.createCatalogTemplateRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CatalogTemplateRevisionName name =
   *       CatalogTemplateRevisionName.of(
   *           "[PROJECT]",
   *           "[LOCATION]",
   *           "[SPACE]",
   *           "[CATALOG]",
   *           "[CATALOG_TEMPLATE]",
   *           "[REVISION]");
   *   CatalogTemplateRevision response = designCenterClient.getCatalogTemplateRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The catalog template revisions name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CatalogTemplateRevision getCatalogTemplateRevision(
      @Nullable CatalogTemplateRevisionName name) {
    GetCatalogTemplateRevisionRequest request =
        GetCatalogTemplateRevisionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCatalogTemplateRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       CatalogTemplateRevisionName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[SPACE]",
   *               "[CATALOG]",
   *               "[CATALOG_TEMPLATE]",
   *               "[REVISION]")
   *           .toString();
   *   CatalogTemplateRevision response = designCenterClient.getCatalogTemplateRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The catalog template revisions name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CatalogTemplateRevision getCatalogTemplateRevision(String name) {
    GetCatalogTemplateRevisionRequest request =
        GetCatalogTemplateRevisionRequest.newBuilder().setName(name).build();
    return getCatalogTemplateRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetCatalogTemplateRevisionRequest request =
   *       GetCatalogTemplateRevisionRequest.newBuilder()
   *           .setName(
   *               CatalogTemplateRevisionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[CATALOG]",
   *                       "[CATALOG_TEMPLATE]",
   *                       "[REVISION]")
   *                   .toString())
   *           .build();
   *   CatalogTemplateRevision response = designCenterClient.getCatalogTemplateRevision(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CatalogTemplateRevision getCatalogTemplateRevision(
      GetCatalogTemplateRevisionRequest request) {
    return getCatalogTemplateRevisionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetCatalogTemplateRevisionRequest request =
   *       GetCatalogTemplateRevisionRequest.newBuilder()
   *           .setName(
   *               CatalogTemplateRevisionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[CATALOG]",
   *                       "[CATALOG_TEMPLATE]",
   *                       "[REVISION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CatalogTemplateRevision> future =
   *       designCenterClient.getCatalogTemplateRevisionCallable().futureCall(request);
   *   // Do something.
   *   CatalogTemplateRevision response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCatalogTemplateRevisionRequest, CatalogTemplateRevision>
      getCatalogTemplateRevisionCallable() {
    return stub.getCatalogTemplateRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists template revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CatalogTemplateName parent =
   *       CatalogTemplateName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]");
   *   for (CatalogTemplateRevision element :
   *       designCenterClient.listCatalogTemplateRevisions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource from which a list of catalog template revisions is
   *     requested.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCatalogTemplateRevisionsPagedResponse listCatalogTemplateRevisions(
      @Nullable CatalogTemplateName parent) {
    ListCatalogTemplateRevisionsRequest request =
        ListCatalogTemplateRevisionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCatalogTemplateRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists template revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent =
   *       CatalogTemplateName.of(
   *               "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]")
   *           .toString();
   *   for (CatalogTemplateRevision element :
   *       designCenterClient.listCatalogTemplateRevisions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource from which a list of catalog template revisions is
   *     requested.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCatalogTemplateRevisionsPagedResponse listCatalogTemplateRevisions(
      String parent) {
    ListCatalogTemplateRevisionsRequest request =
        ListCatalogTemplateRevisionsRequest.newBuilder().setParent(parent).build();
    return listCatalogTemplateRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists template revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListCatalogTemplateRevisionsRequest request =
   *       ListCatalogTemplateRevisionsRequest.newBuilder()
   *           .setParent(
   *               CatalogTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (CatalogTemplateRevision element :
   *       designCenterClient.listCatalogTemplateRevisions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCatalogTemplateRevisionsPagedResponse listCatalogTemplateRevisions(
      ListCatalogTemplateRevisionsRequest request) {
    return listCatalogTemplateRevisionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists template revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListCatalogTemplateRevisionsRequest request =
   *       ListCatalogTemplateRevisionsRequest.newBuilder()
   *           .setParent(
   *               CatalogTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<CatalogTemplateRevision> future =
   *       designCenterClient.listCatalogTemplateRevisionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CatalogTemplateRevision element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListCatalogTemplateRevisionsRequest, ListCatalogTemplateRevisionsPagedResponse>
      listCatalogTemplateRevisionsPagedCallable() {
    return stub.listCatalogTemplateRevisionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists template revisions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListCatalogTemplateRevisionsRequest request =
   *       ListCatalogTemplateRevisionsRequest.newBuilder()
   *           .setParent(
   *               CatalogTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCatalogTemplateRevisionsResponse response =
   *         designCenterClient.listCatalogTemplateRevisionsCallable().call(request);
   *     for (CatalogTemplateRevision element : response.getCatalogTemplateRevisionsList()) {
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
          ListCatalogTemplateRevisionsRequest, ListCatalogTemplateRevisionsResponse>
      listCatalogTemplateRevisionsCallable() {
    return stub.listCatalogTemplateRevisionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CatalogTemplateRevisionName name =
   *       CatalogTemplateRevisionName.of(
   *           "[PROJECT]",
   *           "[LOCATION]",
   *           "[SPACE]",
   *           "[CATALOG]",
   *           "[CATALOG_TEMPLATE]",
   *           "[REVISION]");
   *   designCenterClient.deleteCatalogTemplateRevisionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The template revision name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCatalogTemplateRevisionAsync(
      @Nullable CatalogTemplateRevisionName name) {
    DeleteCatalogTemplateRevisionRequest request =
        DeleteCatalogTemplateRevisionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteCatalogTemplateRevisionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       CatalogTemplateRevisionName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[SPACE]",
   *               "[CATALOG]",
   *               "[CATALOG_TEMPLATE]",
   *               "[REVISION]")
   *           .toString();
   *   designCenterClient.deleteCatalogTemplateRevisionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The template revision name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCatalogTemplateRevisionAsync(
      String name) {
    DeleteCatalogTemplateRevisionRequest request =
        DeleteCatalogTemplateRevisionRequest.newBuilder().setName(name).build();
    return deleteCatalogTemplateRevisionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeleteCatalogTemplateRevisionRequest request =
   *       DeleteCatalogTemplateRevisionRequest.newBuilder()
   *           .setName(
   *               CatalogTemplateRevisionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[CATALOG]",
   *                       "[CATALOG_TEMPLATE]",
   *                       "[REVISION]")
   *                   .toString())
   *           .build();
   *   designCenterClient.deleteCatalogTemplateRevisionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCatalogTemplateRevisionAsync(
      DeleteCatalogTemplateRevisionRequest request) {
    return deleteCatalogTemplateRevisionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeleteCatalogTemplateRevisionRequest request =
   *       DeleteCatalogTemplateRevisionRequest.newBuilder()
   *           .setName(
   *               CatalogTemplateRevisionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[CATALOG]",
   *                       "[CATALOG_TEMPLATE]",
   *                       "[REVISION]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       designCenterClient.deleteCatalogTemplateRevisionOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteCatalogTemplateRevisionRequest, Empty, OperationMetadata>
      deleteCatalogTemplateRevisionOperationCallable() {
    return stub.deleteCatalogTemplateRevisionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a template revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeleteCatalogTemplateRevisionRequest request =
   *       DeleteCatalogTemplateRevisionRequest.newBuilder()
   *           .setName(
   *               CatalogTemplateRevisionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[CATALOG]",
   *                       "[CATALOG_TEMPLATE]",
   *                       "[REVISION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       designCenterClient.deleteCatalogTemplateRevisionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCatalogTemplateRevisionRequest, Operation>
      deleteCatalogTemplateRevisionCallable() {
    return stub.deleteCatalogTemplateRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   SpaceName parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
   *   Application application = Application.newBuilder().build();
   *   String applicationId = "applicationId-1011352949";
   *   Application response =
   *       designCenterClient.createApplication(parent, application, applicationId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource in which to create the application. Format:
   *     `projects/$project/locations/$location/spaces/$space`
   * @param application Required. The application to create.
   * @param applicationId Required. The ID of the application to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Application createApplication(
      @Nullable SpaceName parent, Application application, String applicationId) {
    CreateApplicationRequest request =
        CreateApplicationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setApplication(application)
            .setApplicationId(applicationId)
            .build();
    return createApplication(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString();
   *   Application application = Application.newBuilder().build();
   *   String applicationId = "applicationId-1011352949";
   *   Application response =
   *       designCenterClient.createApplication(parent, application, applicationId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource in which to create the application. Format:
   *     `projects/$project/locations/$location/spaces/$space`
   * @param application Required. The application to create.
   * @param applicationId Required. The ID of the application to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Application createApplication(
      String parent, Application application, String applicationId) {
    CreateApplicationRequest request =
        CreateApplicationRequest.newBuilder()
            .setParent(parent)
            .setApplication(application)
            .setApplicationId(applicationId)
            .build();
    return createApplication(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CreateApplicationRequest request =
   *       CreateApplicationRequest.newBuilder()
   *           .setParent(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setApplicationId("applicationId-1011352949")
   *           .setApplication(Application.newBuilder().build())
   *           .build();
   *   Application response = designCenterClient.createApplication(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Application createApplication(CreateApplicationRequest request) {
    return createApplicationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CreateApplicationRequest request =
   *       CreateApplicationRequest.newBuilder()
   *           .setParent(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setApplicationId("applicationId-1011352949")
   *           .setApplication(Application.newBuilder().build())
   *           .build();
   *   ApiFuture<Application> future =
   *       designCenterClient.createApplicationCallable().futureCall(request);
   *   // Do something.
   *   Application response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateApplicationRequest, Application> createApplicationCallable() {
    return stub.createApplicationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationName name =
   *       ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");
   *   Application response = designCenterClient.getApplication(name);
   * }
   * }</pre>
   *
   * @param name Required. The application name. Format:
   *     `projects/$project/locations/$location/spaces/$space/applications/$application`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Application getApplication(@Nullable ApplicationName name) {
    GetApplicationRequest request =
        GetApplicationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getApplication(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]").toString();
   *   Application response = designCenterClient.getApplication(name);
   * }
   * }</pre>
   *
   * @param name Required. The application name. Format:
   *     `projects/$project/locations/$location/spaces/$space/applications/$application`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Application getApplication(String name) {
    GetApplicationRequest request = GetApplicationRequest.newBuilder().setName(name).build();
    return getApplication(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetApplicationRequest request =
   *       GetApplicationRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .build();
   *   Application response = designCenterClient.getApplication(request);
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
   * Gets details about an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetApplicationRequest request =
   *       GetApplicationRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Application> future =
   *       designCenterClient.getApplicationCallable().futureCall(request);
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
   * Lists applications in a given space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   SpaceName parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
   *   for (Application element : designCenterClient.listApplications(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource from which to request a list of applications.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApplicationsPagedResponse listApplications(@Nullable SpaceName parent) {
    ListApplicationsRequest request =
        ListApplicationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listApplications(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists applications in a given space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString();
   *   for (Application element : designCenterClient.listApplications(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource from which to request a list of applications.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApplicationsPagedResponse listApplications(String parent) {
    ListApplicationsRequest request =
        ListApplicationsRequest.newBuilder().setParent(parent).build();
    return listApplications(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists applications in a given space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListApplicationsRequest request =
   *       ListApplicationsRequest.newBuilder()
   *           .setParent(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Application element : designCenterClient.listApplications(request).iterateAll()) {
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
   * Lists applications in a given space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListApplicationsRequest request =
   *       ListApplicationsRequest.newBuilder()
   *           .setParent(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Application> future =
   *       designCenterClient.listApplicationsPagedCallable().futureCall(request);
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
   * Lists applications in a given space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListApplicationsRequest request =
   *       ListApplicationsRequest.newBuilder()
   *           .setParent(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListApplicationsResponse response =
   *         designCenterClient.listApplicationsCallable().call(request);
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
   * Updates an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   Application application = Application.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Application response = designCenterClient.updateApplication(application, updateMask);
   * }
   * }</pre>
   *
   * @param application Required. The application to update.
   * @param updateMask Optional. The fields to overwrite in the application update. If you don't
   *     provide a mask, all fields are overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Application updateApplication(Application application, FieldMask updateMask) {
    UpdateApplicationRequest request =
        UpdateApplicationRequest.newBuilder()
            .setApplication(application)
            .setUpdateMask(updateMask)
            .build();
    return updateApplication(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   UpdateApplicationRequest request =
   *       UpdateApplicationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setApplication(Application.newBuilder().build())
   *           .build();
   *   Application response = designCenterClient.updateApplication(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Application updateApplication(UpdateApplicationRequest request) {
    return updateApplicationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   UpdateApplicationRequest request =
   *       UpdateApplicationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setApplication(Application.newBuilder().build())
   *           .build();
   *   ApiFuture<Application> future =
   *       designCenterClient.updateApplicationCallable().futureCall(request);
   *   // Do something.
   *   Application response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateApplicationRequest, Application> updateApplicationCallable() {
    return stub.updateApplicationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationName name =
   *       ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");
   *   designCenterClient.deleteApplicationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The application name. Format:
   *     `projects/$project/locations/$location/spaces/$space/applications/$application`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteApplicationAsync(
      @Nullable ApplicationName name) {
    DeleteApplicationRequest request =
        DeleteApplicationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteApplicationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]").toString();
   *   designCenterClient.deleteApplicationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The application name. Format:
   *     `projects/$project/locations/$location/spaces/$space/applications/$application`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteApplicationAsync(String name) {
    DeleteApplicationRequest request = DeleteApplicationRequest.newBuilder().setName(name).build();
    return deleteApplicationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeleteApplicationRequest request =
   *       DeleteApplicationRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   designCenterClient.deleteApplicationAsync(request).get();
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
   * Deletes an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeleteApplicationRequest request =
   *       DeleteApplicationRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       designCenterClient.deleteApplicationOperationCallable().futureCall(request);
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
   * Deletes an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeleteApplicationRequest request =
   *       DeleteApplicationRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       designCenterClient.deleteApplicationCallable().futureCall(request);
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
   * Deploys an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationName name =
   *       ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");
   *   DeployApplicationResponse response = designCenterClient.deployApplicationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The application name. Format:
   *     `projects/$project/locations/$location/spaces/$space/applications/$application`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployApplicationResponse, OperationMetadata> deployApplicationAsync(
      @Nullable ApplicationName name) {
    DeployApplicationRequest request =
        DeployApplicationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deployApplicationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]").toString();
   *   DeployApplicationResponse response = designCenterClient.deployApplicationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The application name. Format:
   *     `projects/$project/locations/$location/spaces/$space/applications/$application`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployApplicationResponse, OperationMetadata> deployApplicationAsync(
      String name) {
    DeployApplicationRequest request = DeployApplicationRequest.newBuilder().setName(name).build();
    return deployApplicationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeployApplicationRequest request =
   *       DeployApplicationRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .setReplace(true)
   *           .setWorkerPool("workerPool-384405318")
   *           .setServiceAccount("serviceAccount1079137720")
   *           .setValidateOnly(true)
   *           .build();
   *   DeployApplicationResponse response = designCenterClient.deployApplicationAsync(request).get();
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
   * Deploys an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeployApplicationRequest request =
   *       DeployApplicationRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .setReplace(true)
   *           .setWorkerPool("workerPool-384405318")
   *           .setServiceAccount("serviceAccount1079137720")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<DeployApplicationResponse, OperationMetadata> future =
   *       designCenterClient.deployApplicationOperationCallable().futureCall(request);
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
   * Deploys an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeployApplicationRequest request =
   *       DeployApplicationRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .setReplace(true)
   *           .setWorkerPool("workerPool-384405318")
   *           .setServiceAccount("serviceAccount1079137720")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       designCenterClient.deployApplicationCallable().futureCall(request);
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
   * Previews deployment of an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationName name =
   *       ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");
   *   PreviewApplicationResponse response = designCenterClient.previewApplicationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The application name in the following format:
   *     `projects/$project/locations/$location/spaces/$space/applications/$application`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PreviewApplicationResponse, OperationMetadata>
      previewApplicationAsync(@Nullable ApplicationName name) {
    PreviewApplicationRequest request =
        PreviewApplicationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return previewApplicationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Previews deployment of an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]").toString();
   *   PreviewApplicationResponse response = designCenterClient.previewApplicationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The application name in the following format:
   *     `projects/$project/locations/$location/spaces/$space/applications/$application`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PreviewApplicationResponse, OperationMetadata>
      previewApplicationAsync(String name) {
    PreviewApplicationRequest request =
        PreviewApplicationRequest.newBuilder().setName(name).build();
    return previewApplicationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Previews deployment of an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   PreviewApplicationRequest request =
   *       PreviewApplicationRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .setWorkerPool("workerPool-384405318")
   *           .setServiceAccount("serviceAccount1079137720")
   *           .build();
   *   PreviewApplicationResponse response =
   *       designCenterClient.previewApplicationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PreviewApplicationResponse, OperationMetadata>
      previewApplicationAsync(PreviewApplicationRequest request) {
    return previewApplicationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Previews deployment of an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   PreviewApplicationRequest request =
   *       PreviewApplicationRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .setWorkerPool("workerPool-384405318")
   *           .setServiceAccount("serviceAccount1079137720")
   *           .build();
   *   OperationFuture<PreviewApplicationResponse, OperationMetadata> future =
   *       designCenterClient.previewApplicationOperationCallable().futureCall(request);
   *   // Do something.
   *   PreviewApplicationResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          PreviewApplicationRequest, PreviewApplicationResponse, OperationMetadata>
      previewApplicationOperationCallable() {
    return stub.previewApplicationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Previews deployment of an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   PreviewApplicationRequest request =
   *       PreviewApplicationRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .setWorkerPool("workerPool-384405318")
   *           .setServiceAccount("serviceAccount1079137720")
   *           .build();
   *   ApiFuture<Operation> future =
   *       designCenterClient.previewApplicationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PreviewApplicationRequest, Operation> previewApplicationCallable() {
    return stub.previewApplicationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches the assessment report of a deployed application if present.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationName name =
   *       ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");
   *   FetchApplicationAssessmentReportResponse response =
   *       designCenterClient.fetchApplicationAssessmentReport(name);
   * }
   * }</pre>
   *
   * @param name Required. The application name in the following format:
   *     `projects/$project/locations/$location/spaces/$space/applications/$application`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchApplicationAssessmentReportResponse fetchApplicationAssessmentReport(
      @Nullable ApplicationName name) {
    FetchApplicationAssessmentReportRequest request =
        FetchApplicationAssessmentReportRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return fetchApplicationAssessmentReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches the assessment report of a deployed application if present.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]").toString();
   *   FetchApplicationAssessmentReportResponse response =
   *       designCenterClient.fetchApplicationAssessmentReport(name);
   * }
   * }</pre>
   *
   * @param name Required. The application name in the following format:
   *     `projects/$project/locations/$location/spaces/$space/applications/$application`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchApplicationAssessmentReportResponse fetchApplicationAssessmentReport(
      String name) {
    FetchApplicationAssessmentReportRequest request =
        FetchApplicationAssessmentReportRequest.newBuilder().setName(name).build();
    return fetchApplicationAssessmentReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches the assessment report of a deployed application if present.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   FetchApplicationAssessmentReportRequest request =
   *       FetchApplicationAssessmentReportRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .build();
   *   FetchApplicationAssessmentReportResponse response =
   *       designCenterClient.fetchApplicationAssessmentReport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchApplicationAssessmentReportResponse fetchApplicationAssessmentReport(
      FetchApplicationAssessmentReportRequest request) {
    return fetchApplicationAssessmentReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches the assessment report of a deployed application if present.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   FetchApplicationAssessmentReportRequest request =
   *       FetchApplicationAssessmentReportRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<FetchApplicationAssessmentReportResponse> future =
   *       designCenterClient.fetchApplicationAssessmentReportCallable().futureCall(request);
   *   // Do something.
   *   FetchApplicationAssessmentReportResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          FetchApplicationAssessmentReportRequest, FetchApplicationAssessmentReportResponse>
      fetchApplicationAssessmentReportCallable() {
    return stub.fetchApplicationAssessmentReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate Assessment Reports of an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationName name =
   *       ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");
   *   GenerateApplicationAssessmentReportResponse response =
   *       designCenterClient.generateApplicationAssessmentReportAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The application name in the following format:
   *     `projects/$project/locations/$location/spaces/$space/applications/$application`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GenerateApplicationAssessmentReportResponse, OperationMetadata>
      generateApplicationAssessmentReportAsync(@Nullable ApplicationName name) {
    GenerateApplicationAssessmentReportRequest request =
        GenerateApplicationAssessmentReportRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return generateApplicationAssessmentReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate Assessment Reports of an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]").toString();
   *   GenerateApplicationAssessmentReportResponse response =
   *       designCenterClient.generateApplicationAssessmentReportAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The application name in the following format:
   *     `projects/$project/locations/$location/spaces/$space/applications/$application`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GenerateApplicationAssessmentReportResponse, OperationMetadata>
      generateApplicationAssessmentReportAsync(String name) {
    GenerateApplicationAssessmentReportRequest request =
        GenerateApplicationAssessmentReportRequest.newBuilder().setName(name).build();
    return generateApplicationAssessmentReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate Assessment Reports of an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GenerateApplicationAssessmentReportRequest request =
   *       GenerateApplicationAssessmentReportRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .build();
   *   GenerateApplicationAssessmentReportResponse response =
   *       designCenterClient.generateApplicationAssessmentReportAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GenerateApplicationAssessmentReportResponse, OperationMetadata>
      generateApplicationAssessmentReportAsync(GenerateApplicationAssessmentReportRequest request) {
    return generateApplicationAssessmentReportOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate Assessment Reports of an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GenerateApplicationAssessmentReportRequest request =
   *       GenerateApplicationAssessmentReportRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .build();
   *   OperationFuture<GenerateApplicationAssessmentReportResponse, OperationMetadata> future =
   *       designCenterClient
   *           .generateApplicationAssessmentReportOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   GenerateApplicationAssessmentReportResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          GenerateApplicationAssessmentReportRequest,
          GenerateApplicationAssessmentReportResponse,
          OperationMetadata>
      generateApplicationAssessmentReportOperationCallable() {
    return stub.generateApplicationAssessmentReportOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate Assessment Reports of an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GenerateApplicationAssessmentReportRequest request =
   *       GenerateApplicationAssessmentReportRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       designCenterClient.generateApplicationAssessmentReportCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateApplicationAssessmentReportRequest, Operation>
      generateApplicationAssessmentReportCallable() {
    return stub.generateApplicationAssessmentReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate Assessment Reports of an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationTemplateName name =
   *       ApplicationTemplateName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
   *   GenerateApplicationTemplateAssessmentReportResponse response =
   *       designCenterClient.generateApplicationTemplateAssessmentReportAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The application template name in the following format:
   *     `projects/$project/locations/$location/spaces/$space/applicationTemplates/$applicationTemplate`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          GenerateApplicationTemplateAssessmentReportResponse, OperationMetadata>
      generateApplicationTemplateAssessmentReportAsync(@Nullable ApplicationTemplateName name) {
    GenerateApplicationTemplateAssessmentReportRequest request =
        GenerateApplicationTemplateAssessmentReportRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return generateApplicationTemplateAssessmentReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate Assessment Reports of an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *           .toString();
   *   GenerateApplicationTemplateAssessmentReportResponse response =
   *       designCenterClient.generateApplicationTemplateAssessmentReportAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The application template name in the following format:
   *     `projects/$project/locations/$location/spaces/$space/applicationTemplates/$applicationTemplate`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          GenerateApplicationTemplateAssessmentReportResponse, OperationMetadata>
      generateApplicationTemplateAssessmentReportAsync(String name) {
    GenerateApplicationTemplateAssessmentReportRequest request =
        GenerateApplicationTemplateAssessmentReportRequest.newBuilder().setName(name).build();
    return generateApplicationTemplateAssessmentReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate Assessment Reports of an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GenerateApplicationTemplateAssessmentReportRequest request =
   *       GenerateApplicationTemplateAssessmentReportRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setServiceAccount("serviceAccount1079137720")
   *           .build();
   *   GenerateApplicationTemplateAssessmentReportResponse response =
   *       designCenterClient.generateApplicationTemplateAssessmentReportAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          GenerateApplicationTemplateAssessmentReportResponse, OperationMetadata>
      generateApplicationTemplateAssessmentReportAsync(
          GenerateApplicationTemplateAssessmentReportRequest request) {
    return generateApplicationTemplateAssessmentReportOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate Assessment Reports of an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GenerateApplicationTemplateAssessmentReportRequest request =
   *       GenerateApplicationTemplateAssessmentReportRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setServiceAccount("serviceAccount1079137720")
   *           .build();
   *   OperationFuture<GenerateApplicationTemplateAssessmentReportResponse, OperationMetadata>
   *       future =
   *           designCenterClient
   *               .generateApplicationTemplateAssessmentReportOperationCallable()
   *               .futureCall(request);
   *   // Do something.
   *   GenerateApplicationTemplateAssessmentReportResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          GenerateApplicationTemplateAssessmentReportRequest,
          GenerateApplicationTemplateAssessmentReportResponse,
          OperationMetadata>
      generateApplicationTemplateAssessmentReportOperationCallable() {
    return stub.generateApplicationTemplateAssessmentReportOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate Assessment Reports of an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GenerateApplicationTemplateAssessmentReportRequest request =
   *       GenerateApplicationTemplateAssessmentReportRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setServiceAccount("serviceAccount1079137720")
   *           .build();
   *   ApiFuture<Operation> future =
   *       designCenterClient
   *           .generateApplicationTemplateAssessmentReportCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateApplicationTemplateAssessmentReportRequest, Operation>
      generateApplicationTemplateAssessmentReportCallable() {
    return stub.generateApplicationTemplateAssessmentReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deprecated: Use GenerateTerraformPlanAssessmentReport instead.
   *
   * <p>Generate a best practice report for a given Terraform plan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   SpaceName spaceName = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
   *   GenerateAssessmentReportResponse response =
   *       designCenterClient.generateAssessmentReportAsync(spaceName).get();
   * }
   * }</pre>
   *
   * @param spaceName Required. The name of the space at which Generate Assessment Report is called.
   *     Format: `projects/$project/locations/$location/spaces/$space`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final OperationFuture<GenerateAssessmentReportResponse, OperationMetadata>
      generateAssessmentReportAsync(@Nullable SpaceName spaceName) {
    GenerateAssessmentReportRequest request =
        GenerateAssessmentReportRequest.newBuilder()
            .setSpaceName(spaceName == null ? null : spaceName.toString())
            .build();
    return generateAssessmentReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deprecated: Use GenerateTerraformPlanAssessmentReport instead.
   *
   * <p>Generate a best practice report for a given Terraform plan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String spaceName = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString();
   *   GenerateAssessmentReportResponse response =
   *       designCenterClient.generateAssessmentReportAsync(spaceName).get();
   * }
   * }</pre>
   *
   * @param spaceName Required. The name of the space at which Generate Assessment Report is called.
   *     Format: `projects/$project/locations/$location/spaces/$space`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final OperationFuture<GenerateAssessmentReportResponse, OperationMetadata>
      generateAssessmentReportAsync(String spaceName) {
    GenerateAssessmentReportRequest request =
        GenerateAssessmentReportRequest.newBuilder().setSpaceName(spaceName).build();
    return generateAssessmentReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deprecated: Use GenerateTerraformPlanAssessmentReport instead.
   *
   * <p>Generate a best practice report for a given Terraform plan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GenerateAssessmentReportRequest request =
   *       GenerateAssessmentReportRequest.newBuilder()
   *           .setTerraformPlan(ByteString.EMPTY)
   *           .addAllAdditionalFrameworks(new ArrayList<String>())
   *           .setSpaceName(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .build();
   *   GenerateAssessmentReportResponse response =
   *       designCenterClient.generateAssessmentReportAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final OperationFuture<GenerateAssessmentReportResponse, OperationMetadata>
      generateAssessmentReportAsync(GenerateAssessmentReportRequest request) {
    return generateAssessmentReportOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deprecated: Use GenerateTerraformPlanAssessmentReport instead.
   *
   * <p>Generate a best practice report for a given Terraform plan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GenerateAssessmentReportRequest request =
   *       GenerateAssessmentReportRequest.newBuilder()
   *           .setTerraformPlan(ByteString.EMPTY)
   *           .addAllAdditionalFrameworks(new ArrayList<String>())
   *           .setSpaceName(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .build();
   *   OperationFuture<GenerateAssessmentReportResponse, OperationMetadata> future =
   *       designCenterClient.generateAssessmentReportOperationCallable().futureCall(request);
   *   // Do something.
   *   GenerateAssessmentReportResponse response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final OperationCallable<
          GenerateAssessmentReportRequest, GenerateAssessmentReportResponse, OperationMetadata>
      generateAssessmentReportOperationCallable() {
    return stub.generateAssessmentReportOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deprecated: Use GenerateTerraformPlanAssessmentReport instead.
   *
   * <p>Generate a best practice report for a given Terraform plan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GenerateAssessmentReportRequest request =
   *       GenerateAssessmentReportRequest.newBuilder()
   *           .setTerraformPlan(ByteString.EMPTY)
   *           .addAllAdditionalFrameworks(new ArrayList<String>())
   *           .setSpaceName(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       designCenterClient.generateAssessmentReportCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<GenerateAssessmentReportRequest, Operation>
      generateAssessmentReportCallable() {
    return stub.generateAssessmentReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate a Terraform plan assessment report for a given Terraform plan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   SpaceName name = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
   *   ByteString terraformPlan = ByteString.EMPTY;
   *   GenerateTerraformPlanAssessmentReportResponse response =
   *       designCenterClient.generateTerraformPlanAssessmentReportAsync(name, terraformPlan).get();
   * }
   * }</pre>
   *
   * @param name Required. The parent resource in which to generate the assessment report. Format:
   *     projects/$project/locations/$location/spaces/$space
   * @param terraformPlan Required. The raw JSON representation of the generated Terraform plan,
   *     provided as bytes.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GenerateTerraformPlanAssessmentReportResponse, OperationMetadata>
      generateTerraformPlanAssessmentReportAsync(
          @Nullable SpaceName name, ByteString terraformPlan) {
    GenerateTerraformPlanAssessmentReportRequest request =
        GenerateTerraformPlanAssessmentReportRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setTerraformPlan(terraformPlan)
            .build();
    return generateTerraformPlanAssessmentReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate a Terraform plan assessment report for a given Terraform plan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString();
   *   ByteString terraformPlan = ByteString.EMPTY;
   *   GenerateTerraformPlanAssessmentReportResponse response =
   *       designCenterClient.generateTerraformPlanAssessmentReportAsync(name, terraformPlan).get();
   * }
   * }</pre>
   *
   * @param name Required. The parent resource in which to generate the assessment report. Format:
   *     projects/$project/locations/$location/spaces/$space
   * @param terraformPlan Required. The raw JSON representation of the generated Terraform plan,
   *     provided as bytes.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GenerateTerraformPlanAssessmentReportResponse, OperationMetadata>
      generateTerraformPlanAssessmentReportAsync(String name, ByteString terraformPlan) {
    GenerateTerraformPlanAssessmentReportRequest request =
        GenerateTerraformPlanAssessmentReportRequest.newBuilder()
            .setName(name)
            .setTerraformPlan(terraformPlan)
            .build();
    return generateTerraformPlanAssessmentReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate a Terraform plan assessment report for a given Terraform plan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GenerateTerraformPlanAssessmentReportRequest request =
   *       GenerateTerraformPlanAssessmentReportRequest.newBuilder()
   *           .setName(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setTerraformPlan(ByteString.EMPTY)
   *           .addAllAdditionalFrameworks(new ArrayList<String>())
   *           .build();
   *   GenerateTerraformPlanAssessmentReportResponse response =
   *       designCenterClient.generateTerraformPlanAssessmentReportAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GenerateTerraformPlanAssessmentReportResponse, OperationMetadata>
      generateTerraformPlanAssessmentReportAsync(
          GenerateTerraformPlanAssessmentReportRequest request) {
    return generateTerraformPlanAssessmentReportOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate a Terraform plan assessment report for a given Terraform plan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GenerateTerraformPlanAssessmentReportRequest request =
   *       GenerateTerraformPlanAssessmentReportRequest.newBuilder()
   *           .setName(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setTerraformPlan(ByteString.EMPTY)
   *           .addAllAdditionalFrameworks(new ArrayList<String>())
   *           .build();
   *   OperationFuture<GenerateTerraformPlanAssessmentReportResponse, OperationMetadata> future =
   *       designCenterClient
   *           .generateTerraformPlanAssessmentReportOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   GenerateTerraformPlanAssessmentReportResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          GenerateTerraformPlanAssessmentReportRequest,
          GenerateTerraformPlanAssessmentReportResponse,
          OperationMetadata>
      generateTerraformPlanAssessmentReportOperationCallable() {
    return stub.generateTerraformPlanAssessmentReportOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate a Terraform plan assessment report for a given Terraform plan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GenerateTerraformPlanAssessmentReportRequest request =
   *       GenerateTerraformPlanAssessmentReportRequest.newBuilder()
   *           .setName(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setTerraformPlan(ByteString.EMPTY)
   *           .addAllAdditionalFrameworks(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       designCenterClient.generateTerraformPlanAssessmentReportCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateTerraformPlanAssessmentReportRequest, Operation>
      generateTerraformPlanAssessmentReportCallable() {
    return stub.generateTerraformPlanAssessmentReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Policy related APIs. Get a policy for an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   PolicyName name =
   *       PolicyName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[POLICY]");
   *   Policy response = designCenterClient.getPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. The policy name in the following format:
   *     `projects/$project/locations/$location/spaces/$space/applicationTemplates/$applicationTemplate/policies/$policy`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final com.google.cloud.designcenter.v1.Policy getPolicy(@Nullable PolicyName name) {
    GetPolicyRequest request =
        GetPolicyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Policy related APIs. Get a policy for an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       PolicyName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[POLICY]")
   *           .toString();
   *   Policy response = designCenterClient.getPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. The policy name in the following format:
   *     `projects/$project/locations/$location/spaces/$space/applicationTemplates/$applicationTemplate/policies/$policy`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final com.google.cloud.designcenter.v1.Policy getPolicy(String name) {
    GetPolicyRequest request = GetPolicyRequest.newBuilder().setName(name).build();
    return getPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Policy related APIs. Get a policy for an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetPolicyRequest request =
   *       GetPolicyRequest.newBuilder()
   *           .setName(
   *               PolicyName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[POLICY]")
   *                   .toString())
   *           .build();
   *   Policy response = designCenterClient.getPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final com.google.cloud.designcenter.v1.Policy getPolicy(GetPolicyRequest request) {
    return getPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Policy related APIs. Get a policy for an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetPolicyRequest request =
   *       GetPolicyRequest.newBuilder()
   *           .setName(
   *               PolicyName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[POLICY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Policy> future = designCenterClient.getPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPolicyRequest, com.google.cloud.designcenter.v1.Policy>
      getPolicyCallable() {
    return stub.getPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists policies for an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationTemplateName parent =
   *       ApplicationTemplateName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
   *   for (Policy element : designCenterClient.listPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent application template from which policies are listed in the
   *     following format:
   *     `projects/$project/locations/$location/spaces/$space/applicationTemplates/$applicationTemplate`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPoliciesPagedResponse listPolicies(@Nullable ApplicationTemplateName parent) {
    ListPoliciesRequest request =
        ListPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists policies for an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent =
   *       ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *           .toString();
   *   for (Policy element : designCenterClient.listPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent application template from which policies are listed in the
   *     following format:
   *     `projects/$project/locations/$location/spaces/$space/applicationTemplates/$applicationTemplate`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPoliciesPagedResponse listPolicies(String parent) {
    ListPoliciesRequest request = ListPoliciesRequest.newBuilder().setParent(parent).build();
    return listPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists policies for an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListPoliciesRequest request =
   *       ListPoliciesRequest.newBuilder()
   *           .setParent(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Policy element : designCenterClient.listPolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPoliciesPagedResponse listPolicies(ListPoliciesRequest request) {
    return listPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists policies for an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListPoliciesRequest request =
   *       ListPoliciesRequest.newBuilder()
   *           .setParent(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Policy> future = designCenterClient.listPoliciesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Policy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPoliciesRequest, ListPoliciesPagedResponse>
      listPoliciesPagedCallable() {
    return stub.listPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists policies for an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListPoliciesRequest request =
   *       ListPoliciesRequest.newBuilder()
   *           .setParent(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListPoliciesResponse response = designCenterClient.listPoliciesCallable().call(request);
   *     for (Policy element : response.getPoliciesList()) {
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
  public final UnaryCallable<ListPoliciesRequest, ListPoliciesResponse> listPoliciesCallable() {
    return stub.listPoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a policy for an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationTemplateName parent =
   *       ApplicationTemplateName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
   *   Policy policy = Policy.newBuilder().build();
   *   String policyId = "policyId546908653";
   *   Policy response = designCenterClient.createPolicy(parent, policy, policyId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource in which to create the policy in the following
   *     format:
   *     `projects/$project/locations/$location/spaces/$space/applicationTemplates/$applicationTemplate`
   * @param policy Required. The policy to create.
   * @param policyId Required. The ID of the policy to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final com.google.cloud.designcenter.v1.Policy createPolicy(
      @Nullable ApplicationTemplateName parent,
      com.google.cloud.designcenter.v1.Policy policy,
      String policyId) {
    CreatePolicyRequest request =
        CreatePolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPolicy(policy)
            .setPolicyId(policyId)
            .build();
    return createPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a policy for an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent =
   *       ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *           .toString();
   *   Policy policy = Policy.newBuilder().build();
   *   String policyId = "policyId546908653";
   *   Policy response = designCenterClient.createPolicy(parent, policy, policyId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource in which to create the policy in the following
   *     format:
   *     `projects/$project/locations/$location/spaces/$space/applicationTemplates/$applicationTemplate`
   * @param policy Required. The policy to create.
   * @param policyId Required. The ID of the policy to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final com.google.cloud.designcenter.v1.Policy createPolicy(
      String parent, com.google.cloud.designcenter.v1.Policy policy, String policyId) {
    CreatePolicyRequest request =
        CreatePolicyRequest.newBuilder()
            .setParent(parent)
            .setPolicy(policy)
            .setPolicyId(policyId)
            .build();
    return createPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a policy for an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CreatePolicyRequest request =
   *       CreatePolicyRequest.newBuilder()
   *           .setParent(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setPolicyId("policyId546908653")
   *           .setPolicy(Policy.newBuilder().build())
   *           .build();
   *   Policy response = designCenterClient.createPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final com.google.cloud.designcenter.v1.Policy createPolicy(CreatePolicyRequest request) {
    return createPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a policy for an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   CreatePolicyRequest request =
   *       CreatePolicyRequest.newBuilder()
   *           .setParent(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setPolicyId("policyId546908653")
   *           .setPolicy(Policy.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = designCenterClient.createPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePolicyRequest, com.google.cloud.designcenter.v1.Policy>
      createPolicyCallable() {
    return stub.createPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   Policy policy = Policy.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Policy response = designCenterClient.updatePolicy(policy, updateMask);
   * }
   * }</pre>
   *
   * @param policy Required. The policy to update.
   * @param updateMask Optional. The fields to overwrite in the policy update. The fields specified
   *     in the update_mask are relative to the resource, not the full request. A field will be
   *     overwritten if it is in the mask. If you don't provide a mask, all fields are overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final com.google.cloud.designcenter.v1.Policy updatePolicy(
      com.google.cloud.designcenter.v1.Policy policy, FieldMask updateMask) {
    UpdatePolicyRequest request =
        UpdatePolicyRequest.newBuilder().setPolicy(policy).setUpdateMask(updateMask).build();
    return updatePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   UpdatePolicyRequest request =
   *       UpdatePolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setPolicy(Policy.newBuilder().build())
   *           .build();
   *   Policy response = designCenterClient.updatePolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final com.google.cloud.designcenter.v1.Policy updatePolicy(UpdatePolicyRequest request) {
    return updatePolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   UpdatePolicyRequest request =
   *       UpdatePolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setPolicy(Policy.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = designCenterClient.updatePolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePolicyRequest, com.google.cloud.designcenter.v1.Policy>
      updatePolicyCallable() {
    return stub.updatePolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   PolicyName name =
   *       PolicyName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[POLICY]");
   *   designCenterClient.deletePolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. The policy name in the following format:
   *     `projects/$project/locations/$location/spaces/$space/applicationTemplates/$applicationTemplate/policies/$policy`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePolicy(@Nullable PolicyName name) {
    DeletePolicyRequest request =
        DeletePolicyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deletePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       PolicyName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[POLICY]")
   *           .toString();
   *   designCenterClient.deletePolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. The policy name in the following format:
   *     `projects/$project/locations/$location/spaces/$space/applicationTemplates/$applicationTemplate/policies/$policy`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePolicy(String name) {
    DeletePolicyRequest request = DeletePolicyRequest.newBuilder().setName(name).build();
    deletePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeletePolicyRequest request =
   *       DeletePolicyRequest.newBuilder()
   *           .setName(
   *               PolicyName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[POLICY]")
   *                   .toString())
   *           .build();
   *   designCenterClient.deletePolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePolicy(DeletePolicyRequest request) {
    deletePolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   DeletePolicyRequest request =
   *       DeletePolicyRequest.newBuilder()
   *           .setName(
   *               PolicyName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[POLICY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = designCenterClient.deletePolicyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePolicyRequest, Empty> deletePolicyCallable() {
    return stub.deletePolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches all frameworks for assessment report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent = "parent-995424086";
   *   for (Framework element : designCenterClient.fetchFrameworks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name. Format:
   *     projects/{project}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchFrameworksPagedResponse fetchFrameworks(String parent) {
    FetchFrameworksRequest request = FetchFrameworksRequest.newBuilder().setParent(parent).build();
    return fetchFrameworks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches all frameworks for assessment report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   FetchFrameworksRequest request =
   *       FetchFrameworksRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllProjects(new ArrayList<String>())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Framework element : designCenterClient.fetchFrameworks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchFrameworksPagedResponse fetchFrameworks(FetchFrameworksRequest request) {
    return fetchFrameworksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches all frameworks for assessment report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   FetchFrameworksRequest request =
   *       FetchFrameworksRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllProjects(new ArrayList<String>())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Framework> future =
   *       designCenterClient.fetchFrameworksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Framework element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchFrameworksRequest, FetchFrameworksPagedResponse>
      fetchFrameworksPagedCallable() {
    return stub.fetchFrameworksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches all frameworks for assessment report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   FetchFrameworksRequest request =
   *       FetchFrameworksRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllProjects(new ArrayList<String>())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     FetchFrameworksResponse response =
   *         designCenterClient.fetchFrameworksCallable().call(request);
   *     for (Framework element : response.getFrameworksList()) {
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
  public final UnaryCallable<FetchFrameworksRequest, FetchFrameworksResponse>
      fetchFrameworksCallable() {
    return stub.fetchFrameworksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates Terraform files for an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationName name =
   *       ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");
   *   GenerateApplicationIaCResponse response = designCenterClient.generateApplicationIaC(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the application.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateApplicationIaCResponse generateApplicationIaC(
      @Nullable ApplicationName name) {
    GenerateApplicationIaCRequest request =
        GenerateApplicationIaCRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return generateApplicationIaC(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates Terraform files for an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]").toString();
   *   GenerateApplicationIaCResponse response = designCenterClient.generateApplicationIaC(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the application.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateApplicationIaCResponse generateApplicationIaC(String name) {
    GenerateApplicationIaCRequest request =
        GenerateApplicationIaCRequest.newBuilder().setName(name).build();
    return generateApplicationIaC(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates Terraform files for an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GenerateApplicationIaCRequest request =
   *       GenerateApplicationIaCRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .setIacFormat(IACFormat.forNumber(0))
   *           .setGcsUri("gcsUri-1251224875")
   *           .setArtifactLocation(ArtifactLocation.newBuilder().build())
   *           .build();
   *   GenerateApplicationIaCResponse response = designCenterClient.generateApplicationIaC(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateApplicationIaCResponse generateApplicationIaC(
      GenerateApplicationIaCRequest request) {
    return generateApplicationIaCCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates Terraform files for an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GenerateApplicationIaCRequest request =
   *       GenerateApplicationIaCRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .setIacFormat(IACFormat.forNumber(0))
   *           .setGcsUri("gcsUri-1251224875")
   *           .setArtifactLocation(ArtifactLocation.newBuilder().build())
   *           .build();
   *   ApiFuture<GenerateApplicationIaCResponse> future =
   *       designCenterClient.generateApplicationIaCCallable().futureCall(request);
   *   // Do something.
   *   GenerateApplicationIaCResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateApplicationIaCRequest, GenerateApplicationIaCResponse>
      generateApplicationIaCCallable() {
    return stub.generateApplicationIaCCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports Terraform files for an application asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationName name =
   *       ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");
   *   ExportApplicationIaCResponse response =
   *       designCenterClient.exportApplicationIaCAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the application.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportApplicationIaCResponse, OperationMetadata>
      exportApplicationIaCAsync(@Nullable ApplicationName name) {
    ExportApplicationIaCRequest request =
        ExportApplicationIaCRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return exportApplicationIaCAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports Terraform files for an application asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]").toString();
   *   ExportApplicationIaCResponse response =
   *       designCenterClient.exportApplicationIaCAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the application.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportApplicationIaCResponse, OperationMetadata>
      exportApplicationIaCAsync(String name) {
    ExportApplicationIaCRequest request =
        ExportApplicationIaCRequest.newBuilder().setName(name).build();
    return exportApplicationIaCAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports Terraform files for an application asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ExportApplicationIaCRequest request =
   *       ExportApplicationIaCRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .setIacFormat(IACFormat.forNumber(0))
   *           .setArtifactLocation(ArtifactLocation.newBuilder().build())
   *           .setExportIacConfig(ExportIaCConfig.newBuilder().build())
   *           .build();
   *   ExportApplicationIaCResponse response =
   *       designCenterClient.exportApplicationIaCAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportApplicationIaCResponse, OperationMetadata>
      exportApplicationIaCAsync(ExportApplicationIaCRequest request) {
    return exportApplicationIaCOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports Terraform files for an application asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ExportApplicationIaCRequest request =
   *       ExportApplicationIaCRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .setIacFormat(IACFormat.forNumber(0))
   *           .setArtifactLocation(ArtifactLocation.newBuilder().build())
   *           .setExportIacConfig(ExportIaCConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<ExportApplicationIaCResponse, OperationMetadata> future =
   *       designCenterClient.exportApplicationIaCOperationCallable().futureCall(request);
   *   // Do something.
   *   ExportApplicationIaCResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ExportApplicationIaCRequest, ExportApplicationIaCResponse, OperationMetadata>
      exportApplicationIaCOperationCallable() {
    return stub.exportApplicationIaCOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports Terraform files for an application asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ExportApplicationIaCRequest request =
   *       ExportApplicationIaCRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .setIacFormat(IACFormat.forNumber(0))
   *           .setArtifactLocation(ArtifactLocation.newBuilder().build())
   *           .setExportIacConfig(ExportIaCConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       designCenterClient.exportApplicationIaCCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportApplicationIaCRequest, Operation>
      exportApplicationIaCCallable() {
    return stub.exportApplicationIaCCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports IaC for an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationTemplateName name =
   *       ApplicationTemplateName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
   *   ImportApplicationTemplateIaCResponse response =
   *       designCenterClient.importApplicationTemplateIaC(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the application template.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportApplicationTemplateIaCResponse importApplicationTemplateIaC(
      @Nullable ApplicationTemplateName name) {
    ImportApplicationTemplateIaCRequest request =
        ImportApplicationTemplateIaCRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return importApplicationTemplateIaC(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports IaC for an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *           .toString();
   *   ImportApplicationTemplateIaCResponse response =
   *       designCenterClient.importApplicationTemplateIaC(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the application template.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportApplicationTemplateIaCResponse importApplicationTemplateIaC(String name) {
    ImportApplicationTemplateIaCRequest request =
        ImportApplicationTemplateIaCRequest.newBuilder().setName(name).build();
    return importApplicationTemplateIaC(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports IaC for an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ImportApplicationTemplateIaCRequest request =
   *       ImportApplicationTemplateIaCRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setAllowPartialImport(true)
   *           .setValidateIac(true)
   *           .build();
   *   ImportApplicationTemplateIaCResponse response =
   *       designCenterClient.importApplicationTemplateIaC(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportApplicationTemplateIaCResponse importApplicationTemplateIaC(
      ImportApplicationTemplateIaCRequest request) {
    return importApplicationTemplateIaCCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports IaC for an application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ImportApplicationTemplateIaCRequest request =
   *       ImportApplicationTemplateIaCRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setAllowPartialImport(true)
   *           .setValidateIac(true)
   *           .build();
   *   ApiFuture<ImportApplicationTemplateIaCResponse> future =
   *       designCenterClient.importApplicationTemplateIaCCallable().futureCall(request);
   *   // Do something.
   *   ImportApplicationTemplateIaCResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ImportApplicationTemplateIaCRequest, ImportApplicationTemplateIaCResponse>
      importApplicationTemplateIaCCallable() {
    return stub.importApplicationTemplateIaCCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Ingests IaC for an application template asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationTemplateName name =
   *       ApplicationTemplateName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
   *   IngestApplicationTemplateIaCResponse response =
   *       designCenterClient.ingestApplicationTemplateIaCAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the application template.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IngestApplicationTemplateIaCResponse, OperationMetadata>
      ingestApplicationTemplateIaCAsync(@Nullable ApplicationTemplateName name) {
    IngestApplicationTemplateIaCRequest request =
        IngestApplicationTemplateIaCRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return ingestApplicationTemplateIaCAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Ingests IaC for an application template asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *           .toString();
   *   IngestApplicationTemplateIaCResponse response =
   *       designCenterClient.ingestApplicationTemplateIaCAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the application template.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IngestApplicationTemplateIaCResponse, OperationMetadata>
      ingestApplicationTemplateIaCAsync(String name) {
    IngestApplicationTemplateIaCRequest request =
        IngestApplicationTemplateIaCRequest.newBuilder().setName(name).build();
    return ingestApplicationTemplateIaCAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Ingests IaC for an application template asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   IngestApplicationTemplateIaCRequest request =
   *       IngestApplicationTemplateIaCRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setValidateCatalogCompatibility(true)
   *           .setRawTerraformImportEnabled(true)
   *           .build();
   *   IngestApplicationTemplateIaCResponse response =
   *       designCenterClient.ingestApplicationTemplateIaCAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IngestApplicationTemplateIaCResponse, OperationMetadata>
      ingestApplicationTemplateIaCAsync(IngestApplicationTemplateIaCRequest request) {
    return ingestApplicationTemplateIaCOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Ingests IaC for an application template asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   IngestApplicationTemplateIaCRequest request =
   *       IngestApplicationTemplateIaCRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setValidateCatalogCompatibility(true)
   *           .setRawTerraformImportEnabled(true)
   *           .build();
   *   OperationFuture<IngestApplicationTemplateIaCResponse, OperationMetadata> future =
   *       designCenterClient.ingestApplicationTemplateIaCOperationCallable().futureCall(request);
   *   // Do something.
   *   IngestApplicationTemplateIaCResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          IngestApplicationTemplateIaCRequest,
          IngestApplicationTemplateIaCResponse,
          OperationMetadata>
      ingestApplicationTemplateIaCOperationCallable() {
    return stub.ingestApplicationTemplateIaCOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Ingests IaC for an application template asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   IngestApplicationTemplateIaCRequest request =
   *       IngestApplicationTemplateIaCRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setValidateCatalogCompatibility(true)
   *           .setRawTerraformImportEnabled(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       designCenterClient.ingestApplicationTemplateIaCCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<IngestApplicationTemplateIaCRequest, Operation>
      ingestApplicationTemplateIaCCallable() {
    return stub.ingestApplicationTemplateIaCCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports IaC for an application resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationName name =
   *       ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");
   *   ImportApplicationIaCResponse response = designCenterClient.importApplicationIaC(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the application.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportApplicationIaCResponse importApplicationIaC(@Nullable ApplicationName name) {
    ImportApplicationIaCRequest request =
        ImportApplicationIaCRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return importApplicationIaC(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports IaC for an application resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]").toString();
   *   ImportApplicationIaCResponse response = designCenterClient.importApplicationIaC(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the application.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportApplicationIaCResponse importApplicationIaC(String name) {
    ImportApplicationIaCRequest request =
        ImportApplicationIaCRequest.newBuilder().setName(name).build();
    return importApplicationIaC(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports IaC for an application resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ImportApplicationIaCRequest request =
   *       ImportApplicationIaCRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .setAllowPartialImport(true)
   *           .setValidateIac(true)
   *           .build();
   *   ImportApplicationIaCResponse response = designCenterClient.importApplicationIaC(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportApplicationIaCResponse importApplicationIaC(
      ImportApplicationIaCRequest request) {
    return importApplicationIaCCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports IaC for an application resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ImportApplicationIaCRequest request =
   *       ImportApplicationIaCRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .setAllowPartialImport(true)
   *           .setValidateIac(true)
   *           .build();
   *   ApiFuture<ImportApplicationIaCResponse> future =
   *       designCenterClient.importApplicationIaCCallable().futureCall(request);
   *   // Do something.
   *   ImportApplicationIaCResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportApplicationIaCRequest, ImportApplicationIaCResponse>
      importApplicationIaCCallable() {
    return stub.importApplicationIaCCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Register deployed resources from terraform state file with App Hub without needing a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String apphubApplication = "apphubApplication104302972";
   *   String tfstateContent = "tfstateContent-1547770342";
   *   RegisterAppHubApplicationResourcesResponse response =
   *       designCenterClient
   *           .registerAppHubApplicationResourcesAsync(parent, apphubApplication, tfstateContent)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent location. Format: projects/{project}/locations/{location}
   * @param apphubApplication Required. The name of the AppHub Application. Format:
   *     projects/{project}/locations/{location}/applications/{application}
   * @param tfstateContent Optional. The Terraform state (tfstate) content as a raw string. For
   *     large state files exceeding 10MB, use the 'tfstate_signed_gcs_uri' field instead.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RegisterAppHubApplicationResourcesResponse, OperationMetadata>
      registerAppHubApplicationResourcesAsync(
          @Nullable LocationName parent, String apphubApplication, String tfstateContent) {
    RegisterAppHubApplicationResourcesRequest request =
        RegisterAppHubApplicationResourcesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setApphubApplication(apphubApplication)
            .setTfstateContent(tfstateContent)
            .build();
    return registerAppHubApplicationResourcesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Register deployed resources from terraform state file with App Hub without needing a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String apphubApplication = "apphubApplication104302972";
   *   String tfstateContent = "tfstateContent-1547770342";
   *   RegisterAppHubApplicationResourcesResponse response =
   *       designCenterClient
   *           .registerAppHubApplicationResourcesAsync(parent, apphubApplication, tfstateContent)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent location. Format: projects/{project}/locations/{location}
   * @param apphubApplication Required. The name of the AppHub Application. Format:
   *     projects/{project}/locations/{location}/applications/{application}
   * @param tfstateContent Optional. The Terraform state (tfstate) content as a raw string. For
   *     large state files exceeding 10MB, use the 'tfstate_signed_gcs_uri' field instead.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RegisterAppHubApplicationResourcesResponse, OperationMetadata>
      registerAppHubApplicationResourcesAsync(
          String parent, String apphubApplication, String tfstateContent) {
    RegisterAppHubApplicationResourcesRequest request =
        RegisterAppHubApplicationResourcesRequest.newBuilder()
            .setParent(parent)
            .setApphubApplication(apphubApplication)
            .setTfstateContent(tfstateContent)
            .build();
    return registerAppHubApplicationResourcesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Register deployed resources from terraform state file with App Hub without needing a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   RegisterAppHubApplicationResourcesRequest request =
   *       RegisterAppHubApplicationResourcesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setApphubApplication("apphubApplication104302972")
   *           .build();
   *   RegisterAppHubApplicationResourcesResponse response =
   *       designCenterClient.registerAppHubApplicationResourcesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RegisterAppHubApplicationResourcesResponse, OperationMetadata>
      registerAppHubApplicationResourcesAsync(RegisterAppHubApplicationResourcesRequest request) {
    return registerAppHubApplicationResourcesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Register deployed resources from terraform state file with App Hub without needing a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   RegisterAppHubApplicationResourcesRequest request =
   *       RegisterAppHubApplicationResourcesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setApphubApplication("apphubApplication104302972")
   *           .build();
   *   OperationFuture<RegisterAppHubApplicationResourcesResponse, OperationMetadata> future =
   *       designCenterClient
   *           .registerAppHubApplicationResourcesOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   RegisterAppHubApplicationResourcesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RegisterAppHubApplicationResourcesRequest,
          RegisterAppHubApplicationResourcesResponse,
          OperationMetadata>
      registerAppHubApplicationResourcesOperationCallable() {
    return stub.registerAppHubApplicationResourcesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Register deployed resources from terraform state file with App Hub without needing a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   RegisterAppHubApplicationResourcesRequest request =
   *       RegisterAppHubApplicationResourcesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setApphubApplication("apphubApplication104302972")
   *           .build();
   *   ApiFuture<Operation> future =
   *       designCenterClient.registerAppHubApplicationResourcesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RegisterAppHubApplicationResourcesRequest, Operation>
      registerAppHubApplicationResourcesCallable() {
    return stub.registerAppHubApplicationResourcesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists application template system revisions in a given application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationTemplateName parent =
   *       ApplicationTemplateName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
   *   for (ApplicationTemplateSystemRevision element :
   *       designCenterClient.listApplicationTemplateSystemRevisions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent Application Template from which to list the system
   *     revisions. Format:
   *     projects/{project}/locations/{location}/spaces/{space}/applicationTemplates/{application_template}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApplicationTemplateSystemRevisionsPagedResponse
      listApplicationTemplateSystemRevisions(@Nullable ApplicationTemplateName parent) {
    ListApplicationTemplateSystemRevisionsRequest request =
        ListApplicationTemplateSystemRevisionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listApplicationTemplateSystemRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists application template system revisions in a given application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String parent =
   *       ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *           .toString();
   *   for (ApplicationTemplateSystemRevision element :
   *       designCenterClient.listApplicationTemplateSystemRevisions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent Application Template from which to list the system
   *     revisions. Format:
   *     projects/{project}/locations/{location}/spaces/{space}/applicationTemplates/{application_template}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApplicationTemplateSystemRevisionsPagedResponse
      listApplicationTemplateSystemRevisions(String parent) {
    ListApplicationTemplateSystemRevisionsRequest request =
        ListApplicationTemplateSystemRevisionsRequest.newBuilder().setParent(parent).build();
    return listApplicationTemplateSystemRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists application template system revisions in a given application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListApplicationTemplateSystemRevisionsRequest request =
   *       ListApplicationTemplateSystemRevisionsRequest.newBuilder()
   *           .setParent(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (ApplicationTemplateSystemRevision element :
   *       designCenterClient.listApplicationTemplateSystemRevisions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApplicationTemplateSystemRevisionsPagedResponse
      listApplicationTemplateSystemRevisions(
          ListApplicationTemplateSystemRevisionsRequest request) {
    return listApplicationTemplateSystemRevisionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists application template system revisions in a given application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListApplicationTemplateSystemRevisionsRequest request =
   *       ListApplicationTemplateSystemRevisionsRequest.newBuilder()
   *           .setParent(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<ApplicationTemplateSystemRevision> future =
   *       designCenterClient
   *           .listApplicationTemplateSystemRevisionsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (ApplicationTemplateSystemRevision element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListApplicationTemplateSystemRevisionsRequest,
          ListApplicationTemplateSystemRevisionsPagedResponse>
      listApplicationTemplateSystemRevisionsPagedCallable() {
    return stub.listApplicationTemplateSystemRevisionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists application template system revisions in a given application template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListApplicationTemplateSystemRevisionsRequest request =
   *       ListApplicationTemplateSystemRevisionsRequest.newBuilder()
   *           .setParent(
   *               ApplicationTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListApplicationTemplateSystemRevisionsResponse response =
   *         designCenterClient.listApplicationTemplateSystemRevisionsCallable().call(request);
   *     for (ApplicationTemplateSystemRevision element :
   *         response.getApplicationTemplateSystemRevisionsList()) {
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
          ListApplicationTemplateSystemRevisionsRequest,
          ListApplicationTemplateSystemRevisionsResponse>
      listApplicationTemplateSystemRevisionsCallable() {
    return stub.listApplicationTemplateSystemRevisionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the given application template system revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationTemplateSystemRevisionName name =
   *       ApplicationTemplateSystemRevisionName.of(
   *           "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[SYSTEM_REVISION]");
   *   ApplicationTemplateSystemRevision response =
   *       designCenterClient.getApplicationTemplateSystemRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ApplicationTemplateSystemRevision to retrieve. Format:
   *     projects/{project}/locations/{location}/spaces/{space}/applicationTemplates/{application_template}/systemRevisions/{system_revision}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApplicationTemplateSystemRevision getApplicationTemplateSystemRevision(
      @Nullable ApplicationTemplateSystemRevisionName name) {
    GetApplicationTemplateSystemRevisionRequest request =
        GetApplicationTemplateSystemRevisionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getApplicationTemplateSystemRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the given application template system revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationTemplateSystemRevisionName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[SPACE]",
   *               "[APPLICATION_TEMPLATE]",
   *               "[SYSTEM_REVISION]")
   *           .toString();
   *   ApplicationTemplateSystemRevision response =
   *       designCenterClient.getApplicationTemplateSystemRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ApplicationTemplateSystemRevision to retrieve. Format:
   *     projects/{project}/locations/{location}/spaces/{space}/applicationTemplates/{application_template}/systemRevisions/{system_revision}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApplicationTemplateSystemRevision getApplicationTemplateSystemRevision(String name) {
    GetApplicationTemplateSystemRevisionRequest request =
        GetApplicationTemplateSystemRevisionRequest.newBuilder().setName(name).build();
    return getApplicationTemplateSystemRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the given application template system revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetApplicationTemplateSystemRevisionRequest request =
   *       GetApplicationTemplateSystemRevisionRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateSystemRevisionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[SYSTEM_REVISION]")
   *                   .toString())
   *           .build();
   *   ApplicationTemplateSystemRevision response =
   *       designCenterClient.getApplicationTemplateSystemRevision(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApplicationTemplateSystemRevision getApplicationTemplateSystemRevision(
      GetApplicationTemplateSystemRevisionRequest request) {
    return getApplicationTemplateSystemRevisionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the given application template system revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetApplicationTemplateSystemRevisionRequest request =
   *       GetApplicationTemplateSystemRevisionRequest.newBuilder()
   *           .setName(
   *               ApplicationTemplateSystemRevisionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SPACE]",
   *                       "[APPLICATION_TEMPLATE]",
   *                       "[SYSTEM_REVISION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ApplicationTemplateSystemRevision> future =
   *       designCenterClient.getApplicationTemplateSystemRevisionCallable().futureCall(request);
   *   // Do something.
   *   ApplicationTemplateSystemRevision response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetApplicationTemplateSystemRevisionRequest, ApplicationTemplateSystemRevision>
      getApplicationTemplateSystemRevisionCallable() {
    return stub.getApplicationTemplateSystemRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets recommended IAM roles for an application.
   *
   * <p>Evaluates the infrastructure resources defined by an application (including its template
   * configuration and parameters) to determine the set of IAM roles and Google Cloud APIs that you
   * must configure before you deploy across target projects.
   *
   * <p>The operation is asynchronous and returns a `google.longrunning.Operation`. Upon completion,
   * the operation result contains a `RecommendIAMRolesResponse` with project-level IAM role and API
   * recommendations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ApplicationName name =
   *       ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");
   *   RecommendIAMRolesResponse response = designCenterClient.recommendIAMRolesAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the application resource for which to recommend IAM roles.
   *     Format: projects/$project/locations/$location/spaces/$space/applications/$application
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RecommendIAMRolesResponse, OperationMetadata> recommendIAMRolesAsync(
      @Nullable ApplicationName name) {
    RecommendIAMRolesRequest request =
        RecommendIAMRolesRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return recommendIAMRolesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets recommended IAM roles for an application.
   *
   * <p>Evaluates the infrastructure resources defined by an application (including its template
   * configuration and parameters) to determine the set of IAM roles and Google Cloud APIs that you
   * must configure before you deploy across target projects.
   *
   * <p>The operation is asynchronous and returns a `google.longrunning.Operation`. Upon completion,
   * the operation result contains a `RecommendIAMRolesResponse` with project-level IAM role and API
   * recommendations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   String name =
   *       ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]").toString();
   *   RecommendIAMRolesResponse response = designCenterClient.recommendIAMRolesAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the application resource for which to recommend IAM roles.
   *     Format: projects/$project/locations/$location/spaces/$space/applications/$application
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RecommendIAMRolesResponse, OperationMetadata> recommendIAMRolesAsync(
      String name) {
    RecommendIAMRolesRequest request = RecommendIAMRolesRequest.newBuilder().setName(name).build();
    return recommendIAMRolesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets recommended IAM roles for an application.
   *
   * <p>Evaluates the infrastructure resources defined by an application (including its template
   * configuration and parameters) to determine the set of IAM roles and Google Cloud APIs that you
   * must configure before you deploy across target projects.
   *
   * <p>The operation is asynchronous and returns a `google.longrunning.Operation`. Upon completion,
   * the operation result contains a `RecommendIAMRolesResponse` with project-level IAM role and API
   * recommendations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   RecommendIAMRolesRequest request =
   *       RecommendIAMRolesRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .build();
   *   RecommendIAMRolesResponse response = designCenterClient.recommendIAMRolesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RecommendIAMRolesResponse, OperationMetadata> recommendIAMRolesAsync(
      RecommendIAMRolesRequest request) {
    return recommendIAMRolesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets recommended IAM roles for an application.
   *
   * <p>Evaluates the infrastructure resources defined by an application (including its template
   * configuration and parameters) to determine the set of IAM roles and Google Cloud APIs that you
   * must configure before you deploy across target projects.
   *
   * <p>The operation is asynchronous and returns a `google.longrunning.Operation`. Upon completion,
   * the operation result contains a `RecommendIAMRolesResponse` with project-level IAM role and API
   * recommendations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   RecommendIAMRolesRequest request =
   *       RecommendIAMRolesRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .build();
   *   OperationFuture<RecommendIAMRolesResponse, OperationMetadata> future =
   *       designCenterClient.recommendIAMRolesOperationCallable().futureCall(request);
   *   // Do something.
   *   RecommendIAMRolesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RecommendIAMRolesRequest, RecommendIAMRolesResponse, OperationMetadata>
      recommendIAMRolesOperationCallable() {
    return stub.recommendIAMRolesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets recommended IAM roles for an application.
   *
   * <p>Evaluates the infrastructure resources defined by an application (including its template
   * configuration and parameters) to determine the set of IAM roles and Google Cloud APIs that you
   * must configure before you deploy across target projects.
   *
   * <p>The operation is asynchronous and returns a `google.longrunning.Operation`. Upon completion,
   * the operation result contains a `RecommendIAMRolesResponse` with project-level IAM role and API
   * recommendations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   RecommendIAMRolesRequest request =
   *       RecommendIAMRolesRequest.newBuilder()
   *           .setName(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       designCenterClient.recommendIAMRolesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RecommendIAMRolesRequest, Operation> recommendIAMRolesCallable() {
    return stub.recommendIAMRolesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : designCenterClient.listLocations(request).iterateAll()) {
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
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       designCenterClient.listLocationsPagedCallable().futureCall(request);
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
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = designCenterClient.listLocationsCallable().call(request);
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
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = designCenterClient.getLocation(request);
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
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = designCenterClient.getLocationCallable().futureCall(request);
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
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = designCenterClient.setIamPolicy(request);
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
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = designCenterClient.setIamPolicyCallable().futureCall(request);
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
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = designCenterClient.getIamPolicy(request);
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
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = designCenterClient.getIamPolicyCallable().futureCall(request);
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
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = designCenterClient.testIamPermissions(request);
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
   * try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       designCenterClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListSpacesPagedResponse
      extends AbstractPagedListResponse<
          ListSpacesRequest,
          ListSpacesResponse,
          Space,
          ListSpacesPage,
          ListSpacesFixedSizeCollection> {

    public static ApiFuture<ListSpacesPagedResponse> createAsync(
        PageContext<ListSpacesRequest, ListSpacesResponse, Space> context,
        ApiFuture<ListSpacesResponse> futureResponse) {
      ApiFuture<ListSpacesPage> futurePage =
          ListSpacesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSpacesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSpacesPagedResponse(ListSpacesPage page) {
      super(page, ListSpacesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSpacesPage
      extends AbstractPage<ListSpacesRequest, ListSpacesResponse, Space, ListSpacesPage> {

    private ListSpacesPage(
        @Nullable PageContext<ListSpacesRequest, ListSpacesResponse, Space> context,
        @Nullable ListSpacesResponse response) {
      super(context, response);
    }

    private static ListSpacesPage createEmptyPage() {
      return new ListSpacesPage(null, null);
    }

    @Override
    protected ListSpacesPage createPage(
        @Nullable PageContext<ListSpacesRequest, ListSpacesResponse, Space> context,
        @Nullable ListSpacesResponse response) {
      return new ListSpacesPage(context, response);
    }

    @Override
    public ApiFuture<ListSpacesPage> createPageAsync(
        @Nullable PageContext<ListSpacesRequest, ListSpacesResponse, Space> context,
        ApiFuture<ListSpacesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSpacesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSpacesRequest,
          ListSpacesResponse,
          Space,
          ListSpacesPage,
          ListSpacesFixedSizeCollection> {

    private ListSpacesFixedSizeCollection(
        @Nullable List<ListSpacesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSpacesFixedSizeCollection createEmptyCollection() {
      return new ListSpacesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSpacesFixedSizeCollection createCollection(
        @Nullable List<ListSpacesPage> pages, int collectionSize) {
      return new ListSpacesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListApplicationTemplatesPagedResponse
      extends AbstractPagedListResponse<
          ListApplicationTemplatesRequest,
          ListApplicationTemplatesResponse,
          ApplicationTemplate,
          ListApplicationTemplatesPage,
          ListApplicationTemplatesFixedSizeCollection> {

    public static ApiFuture<ListApplicationTemplatesPagedResponse> createAsync(
        PageContext<
                ListApplicationTemplatesRequest,
                ListApplicationTemplatesResponse,
                ApplicationTemplate>
            context,
        ApiFuture<ListApplicationTemplatesResponse> futureResponse) {
      ApiFuture<ListApplicationTemplatesPage> futurePage =
          ListApplicationTemplatesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListApplicationTemplatesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListApplicationTemplatesPagedResponse(ListApplicationTemplatesPage page) {
      super(page, ListApplicationTemplatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListApplicationTemplatesPage
      extends AbstractPage<
          ListApplicationTemplatesRequest,
          ListApplicationTemplatesResponse,
          ApplicationTemplate,
          ListApplicationTemplatesPage> {

    private ListApplicationTemplatesPage(
        @Nullable
            PageContext<
                ListApplicationTemplatesRequest,
                ListApplicationTemplatesResponse,
                ApplicationTemplate>
            context,
        @Nullable ListApplicationTemplatesResponse response) {
      super(context, response);
    }

    private static ListApplicationTemplatesPage createEmptyPage() {
      return new ListApplicationTemplatesPage(null, null);
    }

    @Override
    protected ListApplicationTemplatesPage createPage(
        @Nullable
            PageContext<
                ListApplicationTemplatesRequest,
                ListApplicationTemplatesResponse,
                ApplicationTemplate>
            context,
        @Nullable ListApplicationTemplatesResponse response) {
      return new ListApplicationTemplatesPage(context, response);
    }

    @Override
    public ApiFuture<ListApplicationTemplatesPage> createPageAsync(
        @Nullable
            PageContext<
                ListApplicationTemplatesRequest,
                ListApplicationTemplatesResponse,
                ApplicationTemplate>
            context,
        ApiFuture<ListApplicationTemplatesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListApplicationTemplatesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListApplicationTemplatesRequest,
          ListApplicationTemplatesResponse,
          ApplicationTemplate,
          ListApplicationTemplatesPage,
          ListApplicationTemplatesFixedSizeCollection> {

    private ListApplicationTemplatesFixedSizeCollection(
        @Nullable List<ListApplicationTemplatesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListApplicationTemplatesFixedSizeCollection createEmptyCollection() {
      return new ListApplicationTemplatesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListApplicationTemplatesFixedSizeCollection createCollection(
        @Nullable List<ListApplicationTemplatesPage> pages, int collectionSize) {
      return new ListApplicationTemplatesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListComponentsPagedResponse
      extends AbstractPagedListResponse<
          ListComponentsRequest,
          ListComponentsResponse,
          Component,
          ListComponentsPage,
          ListComponentsFixedSizeCollection> {

    public static ApiFuture<ListComponentsPagedResponse> createAsync(
        PageContext<ListComponentsRequest, ListComponentsResponse, Component> context,
        ApiFuture<ListComponentsResponse> futureResponse) {
      ApiFuture<ListComponentsPage> futurePage =
          ListComponentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListComponentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListComponentsPagedResponse(ListComponentsPage page) {
      super(page, ListComponentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListComponentsPage
      extends AbstractPage<
          ListComponentsRequest, ListComponentsResponse, Component, ListComponentsPage> {

    private ListComponentsPage(
        @Nullable PageContext<ListComponentsRequest, ListComponentsResponse, Component> context,
        @Nullable ListComponentsResponse response) {
      super(context, response);
    }

    private static ListComponentsPage createEmptyPage() {
      return new ListComponentsPage(null, null);
    }

    @Override
    protected ListComponentsPage createPage(
        @Nullable PageContext<ListComponentsRequest, ListComponentsResponse, Component> context,
        @Nullable ListComponentsResponse response) {
      return new ListComponentsPage(context, response);
    }

    @Override
    public ApiFuture<ListComponentsPage> createPageAsync(
        @Nullable PageContext<ListComponentsRequest, ListComponentsResponse, Component> context,
        ApiFuture<ListComponentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListComponentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListComponentsRequest,
          ListComponentsResponse,
          Component,
          ListComponentsPage,
          ListComponentsFixedSizeCollection> {

    private ListComponentsFixedSizeCollection(
        @Nullable List<ListComponentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListComponentsFixedSizeCollection createEmptyCollection() {
      return new ListComponentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListComponentsFixedSizeCollection createCollection(
        @Nullable List<ListComponentsPage> pages, int collectionSize) {
      return new ListComponentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListConnectionsPagedResponse
      extends AbstractPagedListResponse<
          ListConnectionsRequest,
          ListConnectionsResponse,
          Connection,
          ListConnectionsPage,
          ListConnectionsFixedSizeCollection> {

    public static ApiFuture<ListConnectionsPagedResponse> createAsync(
        PageContext<ListConnectionsRequest, ListConnectionsResponse, Connection> context,
        ApiFuture<ListConnectionsResponse> futureResponse) {
      ApiFuture<ListConnectionsPage> futurePage =
          ListConnectionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListConnectionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListConnectionsPagedResponse(ListConnectionsPage page) {
      super(page, ListConnectionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListConnectionsPage
      extends AbstractPage<
          ListConnectionsRequest, ListConnectionsResponse, Connection, ListConnectionsPage> {

    private ListConnectionsPage(
        @Nullable PageContext<ListConnectionsRequest, ListConnectionsResponse, Connection> context,
        @Nullable ListConnectionsResponse response) {
      super(context, response);
    }

    private static ListConnectionsPage createEmptyPage() {
      return new ListConnectionsPage(null, null);
    }

    @Override
    protected ListConnectionsPage createPage(
        @Nullable PageContext<ListConnectionsRequest, ListConnectionsResponse, Connection> context,
        @Nullable ListConnectionsResponse response) {
      return new ListConnectionsPage(context, response);
    }

    @Override
    public ApiFuture<ListConnectionsPage> createPageAsync(
        @Nullable PageContext<ListConnectionsRequest, ListConnectionsResponse, Connection> context,
        ApiFuture<ListConnectionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListConnectionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListConnectionsRequest,
          ListConnectionsResponse,
          Connection,
          ListConnectionsPage,
          ListConnectionsFixedSizeCollection> {

    private ListConnectionsFixedSizeCollection(
        @Nullable List<ListConnectionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListConnectionsFixedSizeCollection createEmptyCollection() {
      return new ListConnectionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListConnectionsFixedSizeCollection createCollection(
        @Nullable List<ListConnectionsPage> pages, int collectionSize) {
      return new ListConnectionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListApplicationTemplateRevisionsPagedResponse
      extends AbstractPagedListResponse<
          ListApplicationTemplateRevisionsRequest,
          ListApplicationTemplateRevisionsResponse,
          ApplicationTemplateRevision,
          ListApplicationTemplateRevisionsPage,
          ListApplicationTemplateRevisionsFixedSizeCollection> {

    public static ApiFuture<ListApplicationTemplateRevisionsPagedResponse> createAsync(
        PageContext<
                ListApplicationTemplateRevisionsRequest,
                ListApplicationTemplateRevisionsResponse,
                ApplicationTemplateRevision>
            context,
        ApiFuture<ListApplicationTemplateRevisionsResponse> futureResponse) {
      ApiFuture<ListApplicationTemplateRevisionsPage> futurePage =
          ListApplicationTemplateRevisionsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListApplicationTemplateRevisionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListApplicationTemplateRevisionsPagedResponse(
        ListApplicationTemplateRevisionsPage page) {
      super(page, ListApplicationTemplateRevisionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListApplicationTemplateRevisionsPage
      extends AbstractPage<
          ListApplicationTemplateRevisionsRequest,
          ListApplicationTemplateRevisionsResponse,
          ApplicationTemplateRevision,
          ListApplicationTemplateRevisionsPage> {

    private ListApplicationTemplateRevisionsPage(
        @Nullable
            PageContext<
                ListApplicationTemplateRevisionsRequest,
                ListApplicationTemplateRevisionsResponse,
                ApplicationTemplateRevision>
            context,
        @Nullable ListApplicationTemplateRevisionsResponse response) {
      super(context, response);
    }

    private static ListApplicationTemplateRevisionsPage createEmptyPage() {
      return new ListApplicationTemplateRevisionsPage(null, null);
    }

    @Override
    protected ListApplicationTemplateRevisionsPage createPage(
        @Nullable
            PageContext<
                ListApplicationTemplateRevisionsRequest,
                ListApplicationTemplateRevisionsResponse,
                ApplicationTemplateRevision>
            context,
        @Nullable ListApplicationTemplateRevisionsResponse response) {
      return new ListApplicationTemplateRevisionsPage(context, response);
    }

    @Override
    public ApiFuture<ListApplicationTemplateRevisionsPage> createPageAsync(
        @Nullable
            PageContext<
                ListApplicationTemplateRevisionsRequest,
                ListApplicationTemplateRevisionsResponse,
                ApplicationTemplateRevision>
            context,
        ApiFuture<ListApplicationTemplateRevisionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListApplicationTemplateRevisionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListApplicationTemplateRevisionsRequest,
          ListApplicationTemplateRevisionsResponse,
          ApplicationTemplateRevision,
          ListApplicationTemplateRevisionsPage,
          ListApplicationTemplateRevisionsFixedSizeCollection> {

    private ListApplicationTemplateRevisionsFixedSizeCollection(
        @Nullable List<ListApplicationTemplateRevisionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListApplicationTemplateRevisionsFixedSizeCollection createEmptyCollection() {
      return new ListApplicationTemplateRevisionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListApplicationTemplateRevisionsFixedSizeCollection createCollection(
        @Nullable List<ListApplicationTemplateRevisionsPage> pages, int collectionSize) {
      return new ListApplicationTemplateRevisionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCatalogsPagedResponse
      extends AbstractPagedListResponse<
          ListCatalogsRequest,
          ListCatalogsResponse,
          Catalog,
          ListCatalogsPage,
          ListCatalogsFixedSizeCollection> {

    public static ApiFuture<ListCatalogsPagedResponse> createAsync(
        PageContext<ListCatalogsRequest, ListCatalogsResponse, Catalog> context,
        ApiFuture<ListCatalogsResponse> futureResponse) {
      ApiFuture<ListCatalogsPage> futurePage =
          ListCatalogsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCatalogsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCatalogsPagedResponse(ListCatalogsPage page) {
      super(page, ListCatalogsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCatalogsPage
      extends AbstractPage<ListCatalogsRequest, ListCatalogsResponse, Catalog, ListCatalogsPage> {

    private ListCatalogsPage(
        @Nullable PageContext<ListCatalogsRequest, ListCatalogsResponse, Catalog> context,
        @Nullable ListCatalogsResponse response) {
      super(context, response);
    }

    private static ListCatalogsPage createEmptyPage() {
      return new ListCatalogsPage(null, null);
    }

    @Override
    protected ListCatalogsPage createPage(
        @Nullable PageContext<ListCatalogsRequest, ListCatalogsResponse, Catalog> context,
        @Nullable ListCatalogsResponse response) {
      return new ListCatalogsPage(context, response);
    }

    @Override
    public ApiFuture<ListCatalogsPage> createPageAsync(
        @Nullable PageContext<ListCatalogsRequest, ListCatalogsResponse, Catalog> context,
        ApiFuture<ListCatalogsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCatalogsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCatalogsRequest,
          ListCatalogsResponse,
          Catalog,
          ListCatalogsPage,
          ListCatalogsFixedSizeCollection> {

    private ListCatalogsFixedSizeCollection(
        @Nullable List<ListCatalogsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCatalogsFixedSizeCollection createEmptyCollection() {
      return new ListCatalogsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCatalogsFixedSizeCollection createCollection(
        @Nullable List<ListCatalogsPage> pages, int collectionSize) {
      return new ListCatalogsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCatalogTemplatesPagedResponse
      extends AbstractPagedListResponse<
          ListCatalogTemplatesRequest,
          ListCatalogTemplatesResponse,
          CatalogTemplate,
          ListCatalogTemplatesPage,
          ListCatalogTemplatesFixedSizeCollection> {

    public static ApiFuture<ListCatalogTemplatesPagedResponse> createAsync(
        PageContext<ListCatalogTemplatesRequest, ListCatalogTemplatesResponse, CatalogTemplate>
            context,
        ApiFuture<ListCatalogTemplatesResponse> futureResponse) {
      ApiFuture<ListCatalogTemplatesPage> futurePage =
          ListCatalogTemplatesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCatalogTemplatesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCatalogTemplatesPagedResponse(ListCatalogTemplatesPage page) {
      super(page, ListCatalogTemplatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCatalogTemplatesPage
      extends AbstractPage<
          ListCatalogTemplatesRequest,
          ListCatalogTemplatesResponse,
          CatalogTemplate,
          ListCatalogTemplatesPage> {

    private ListCatalogTemplatesPage(
        @Nullable
            PageContext<ListCatalogTemplatesRequest, ListCatalogTemplatesResponse, CatalogTemplate>
            context,
        @Nullable ListCatalogTemplatesResponse response) {
      super(context, response);
    }

    private static ListCatalogTemplatesPage createEmptyPage() {
      return new ListCatalogTemplatesPage(null, null);
    }

    @Override
    protected ListCatalogTemplatesPage createPage(
        @Nullable
            PageContext<ListCatalogTemplatesRequest, ListCatalogTemplatesResponse, CatalogTemplate>
            context,
        @Nullable ListCatalogTemplatesResponse response) {
      return new ListCatalogTemplatesPage(context, response);
    }

    @Override
    public ApiFuture<ListCatalogTemplatesPage> createPageAsync(
        @Nullable
            PageContext<ListCatalogTemplatesRequest, ListCatalogTemplatesResponse, CatalogTemplate>
            context,
        ApiFuture<ListCatalogTemplatesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCatalogTemplatesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCatalogTemplatesRequest,
          ListCatalogTemplatesResponse,
          CatalogTemplate,
          ListCatalogTemplatesPage,
          ListCatalogTemplatesFixedSizeCollection> {

    private ListCatalogTemplatesFixedSizeCollection(
        @Nullable List<ListCatalogTemplatesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCatalogTemplatesFixedSizeCollection createEmptyCollection() {
      return new ListCatalogTemplatesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCatalogTemplatesFixedSizeCollection createCollection(
        @Nullable List<ListCatalogTemplatesPage> pages, int collectionSize) {
      return new ListCatalogTemplatesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSharesPagedResponse
      extends AbstractPagedListResponse<
          ListSharesRequest,
          ListSharesResponse,
          Share,
          ListSharesPage,
          ListSharesFixedSizeCollection> {

    public static ApiFuture<ListSharesPagedResponse> createAsync(
        PageContext<ListSharesRequest, ListSharesResponse, Share> context,
        ApiFuture<ListSharesResponse> futureResponse) {
      ApiFuture<ListSharesPage> futurePage =
          ListSharesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSharesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSharesPagedResponse(ListSharesPage page) {
      super(page, ListSharesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSharesPage
      extends AbstractPage<ListSharesRequest, ListSharesResponse, Share, ListSharesPage> {

    private ListSharesPage(
        @Nullable PageContext<ListSharesRequest, ListSharesResponse, Share> context,
        @Nullable ListSharesResponse response) {
      super(context, response);
    }

    private static ListSharesPage createEmptyPage() {
      return new ListSharesPage(null, null);
    }

    @Override
    protected ListSharesPage createPage(
        @Nullable PageContext<ListSharesRequest, ListSharesResponse, Share> context,
        @Nullable ListSharesResponse response) {
      return new ListSharesPage(context, response);
    }

    @Override
    public ApiFuture<ListSharesPage> createPageAsync(
        @Nullable PageContext<ListSharesRequest, ListSharesResponse, Share> context,
        ApiFuture<ListSharesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSharesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSharesRequest,
          ListSharesResponse,
          Share,
          ListSharesPage,
          ListSharesFixedSizeCollection> {

    private ListSharesFixedSizeCollection(
        @Nullable List<ListSharesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSharesFixedSizeCollection createEmptyCollection() {
      return new ListSharesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSharesFixedSizeCollection createCollection(
        @Nullable List<ListSharesPage> pages, int collectionSize) {
      return new ListSharesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSharedTemplatesPagedResponse
      extends AbstractPagedListResponse<
          ListSharedTemplatesRequest,
          ListSharedTemplatesResponse,
          SharedTemplate,
          ListSharedTemplatesPage,
          ListSharedTemplatesFixedSizeCollection> {

    public static ApiFuture<ListSharedTemplatesPagedResponse> createAsync(
        PageContext<ListSharedTemplatesRequest, ListSharedTemplatesResponse, SharedTemplate>
            context,
        ApiFuture<ListSharedTemplatesResponse> futureResponse) {
      ApiFuture<ListSharedTemplatesPage> futurePage =
          ListSharedTemplatesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSharedTemplatesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSharedTemplatesPagedResponse(ListSharedTemplatesPage page) {
      super(page, ListSharedTemplatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSharedTemplatesPage
      extends AbstractPage<
          ListSharedTemplatesRequest,
          ListSharedTemplatesResponse,
          SharedTemplate,
          ListSharedTemplatesPage> {

    private ListSharedTemplatesPage(
        @Nullable
            PageContext<ListSharedTemplatesRequest, ListSharedTemplatesResponse, SharedTemplate>
            context,
        @Nullable ListSharedTemplatesResponse response) {
      super(context, response);
    }

    private static ListSharedTemplatesPage createEmptyPage() {
      return new ListSharedTemplatesPage(null, null);
    }

    @Override
    protected ListSharedTemplatesPage createPage(
        @Nullable
            PageContext<ListSharedTemplatesRequest, ListSharedTemplatesResponse, SharedTemplate>
            context,
        @Nullable ListSharedTemplatesResponse response) {
      return new ListSharedTemplatesPage(context, response);
    }

    @Override
    public ApiFuture<ListSharedTemplatesPage> createPageAsync(
        @Nullable
            PageContext<ListSharedTemplatesRequest, ListSharedTemplatesResponse, SharedTemplate>
            context,
        ApiFuture<ListSharedTemplatesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSharedTemplatesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSharedTemplatesRequest,
          ListSharedTemplatesResponse,
          SharedTemplate,
          ListSharedTemplatesPage,
          ListSharedTemplatesFixedSizeCollection> {

    private ListSharedTemplatesFixedSizeCollection(
        @Nullable List<ListSharedTemplatesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSharedTemplatesFixedSizeCollection createEmptyCollection() {
      return new ListSharedTemplatesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSharedTemplatesFixedSizeCollection createCollection(
        @Nullable List<ListSharedTemplatesPage> pages, int collectionSize) {
      return new ListSharedTemplatesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSharedTemplateRevisionsPagedResponse
      extends AbstractPagedListResponse<
          ListSharedTemplateRevisionsRequest,
          ListSharedTemplateRevisionsResponse,
          SharedTemplateRevision,
          ListSharedTemplateRevisionsPage,
          ListSharedTemplateRevisionsFixedSizeCollection> {

    public static ApiFuture<ListSharedTemplateRevisionsPagedResponse> createAsync(
        PageContext<
                ListSharedTemplateRevisionsRequest,
                ListSharedTemplateRevisionsResponse,
                SharedTemplateRevision>
            context,
        ApiFuture<ListSharedTemplateRevisionsResponse> futureResponse) {
      ApiFuture<ListSharedTemplateRevisionsPage> futurePage =
          ListSharedTemplateRevisionsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSharedTemplateRevisionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSharedTemplateRevisionsPagedResponse(ListSharedTemplateRevisionsPage page) {
      super(page, ListSharedTemplateRevisionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSharedTemplateRevisionsPage
      extends AbstractPage<
          ListSharedTemplateRevisionsRequest,
          ListSharedTemplateRevisionsResponse,
          SharedTemplateRevision,
          ListSharedTemplateRevisionsPage> {

    private ListSharedTemplateRevisionsPage(
        @Nullable
            PageContext<
                ListSharedTemplateRevisionsRequest,
                ListSharedTemplateRevisionsResponse,
                SharedTemplateRevision>
            context,
        @Nullable ListSharedTemplateRevisionsResponse response) {
      super(context, response);
    }

    private static ListSharedTemplateRevisionsPage createEmptyPage() {
      return new ListSharedTemplateRevisionsPage(null, null);
    }

    @Override
    protected ListSharedTemplateRevisionsPage createPage(
        @Nullable
            PageContext<
                ListSharedTemplateRevisionsRequest,
                ListSharedTemplateRevisionsResponse,
                SharedTemplateRevision>
            context,
        @Nullable ListSharedTemplateRevisionsResponse response) {
      return new ListSharedTemplateRevisionsPage(context, response);
    }

    @Override
    public ApiFuture<ListSharedTemplateRevisionsPage> createPageAsync(
        @Nullable
            PageContext<
                ListSharedTemplateRevisionsRequest,
                ListSharedTemplateRevisionsResponse,
                SharedTemplateRevision>
            context,
        ApiFuture<ListSharedTemplateRevisionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSharedTemplateRevisionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSharedTemplateRevisionsRequest,
          ListSharedTemplateRevisionsResponse,
          SharedTemplateRevision,
          ListSharedTemplateRevisionsPage,
          ListSharedTemplateRevisionsFixedSizeCollection> {

    private ListSharedTemplateRevisionsFixedSizeCollection(
        @Nullable List<ListSharedTemplateRevisionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSharedTemplateRevisionsFixedSizeCollection createEmptyCollection() {
      return new ListSharedTemplateRevisionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSharedTemplateRevisionsFixedSizeCollection createCollection(
        @Nullable List<ListSharedTemplateRevisionsPage> pages, int collectionSize) {
      return new ListSharedTemplateRevisionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCatalogTemplateRevisionsPagedResponse
      extends AbstractPagedListResponse<
          ListCatalogTemplateRevisionsRequest,
          ListCatalogTemplateRevisionsResponse,
          CatalogTemplateRevision,
          ListCatalogTemplateRevisionsPage,
          ListCatalogTemplateRevisionsFixedSizeCollection> {

    public static ApiFuture<ListCatalogTemplateRevisionsPagedResponse> createAsync(
        PageContext<
                ListCatalogTemplateRevisionsRequest,
                ListCatalogTemplateRevisionsResponse,
                CatalogTemplateRevision>
            context,
        ApiFuture<ListCatalogTemplateRevisionsResponse> futureResponse) {
      ApiFuture<ListCatalogTemplateRevisionsPage> futurePage =
          ListCatalogTemplateRevisionsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCatalogTemplateRevisionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCatalogTemplateRevisionsPagedResponse(ListCatalogTemplateRevisionsPage page) {
      super(page, ListCatalogTemplateRevisionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCatalogTemplateRevisionsPage
      extends AbstractPage<
          ListCatalogTemplateRevisionsRequest,
          ListCatalogTemplateRevisionsResponse,
          CatalogTemplateRevision,
          ListCatalogTemplateRevisionsPage> {

    private ListCatalogTemplateRevisionsPage(
        @Nullable
            PageContext<
                ListCatalogTemplateRevisionsRequest,
                ListCatalogTemplateRevisionsResponse,
                CatalogTemplateRevision>
            context,
        @Nullable ListCatalogTemplateRevisionsResponse response) {
      super(context, response);
    }

    private static ListCatalogTemplateRevisionsPage createEmptyPage() {
      return new ListCatalogTemplateRevisionsPage(null, null);
    }

    @Override
    protected ListCatalogTemplateRevisionsPage createPage(
        @Nullable
            PageContext<
                ListCatalogTemplateRevisionsRequest,
                ListCatalogTemplateRevisionsResponse,
                CatalogTemplateRevision>
            context,
        @Nullable ListCatalogTemplateRevisionsResponse response) {
      return new ListCatalogTemplateRevisionsPage(context, response);
    }

    @Override
    public ApiFuture<ListCatalogTemplateRevisionsPage> createPageAsync(
        @Nullable
            PageContext<
                ListCatalogTemplateRevisionsRequest,
                ListCatalogTemplateRevisionsResponse,
                CatalogTemplateRevision>
            context,
        ApiFuture<ListCatalogTemplateRevisionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCatalogTemplateRevisionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCatalogTemplateRevisionsRequest,
          ListCatalogTemplateRevisionsResponse,
          CatalogTemplateRevision,
          ListCatalogTemplateRevisionsPage,
          ListCatalogTemplateRevisionsFixedSizeCollection> {

    private ListCatalogTemplateRevisionsFixedSizeCollection(
        @Nullable List<ListCatalogTemplateRevisionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCatalogTemplateRevisionsFixedSizeCollection createEmptyCollection() {
      return new ListCatalogTemplateRevisionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCatalogTemplateRevisionsFixedSizeCollection createCollection(
        @Nullable List<ListCatalogTemplateRevisionsPage> pages, int collectionSize) {
      return new ListCatalogTemplateRevisionsFixedSizeCollection(pages, collectionSize);
    }
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
        @Nullable PageContext<ListApplicationsRequest, ListApplicationsResponse, Application>
            context,
        @Nullable ListApplicationsResponse response) {
      super(context, response);
    }

    private static ListApplicationsPage createEmptyPage() {
      return new ListApplicationsPage(null, null);
    }

    @Override
    protected ListApplicationsPage createPage(
        @Nullable PageContext<ListApplicationsRequest, ListApplicationsResponse, Application>
            context,
        @Nullable ListApplicationsResponse response) {
      return new ListApplicationsPage(context, response);
    }

    @Override
    public ApiFuture<ListApplicationsPage> createPageAsync(
        @Nullable PageContext<ListApplicationsRequest, ListApplicationsResponse, Application>
            context,
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
        @Nullable List<ListApplicationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListApplicationsFixedSizeCollection createEmptyCollection() {
      return new ListApplicationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListApplicationsFixedSizeCollection createCollection(
        @Nullable List<ListApplicationsPage> pages, int collectionSize) {
      return new ListApplicationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListPoliciesRequest,
          ListPoliciesResponse,
          com.google.cloud.designcenter.v1.Policy,
          ListPoliciesPage,
          ListPoliciesFixedSizeCollection> {

    public static ApiFuture<ListPoliciesPagedResponse> createAsync(
        PageContext<
                ListPoliciesRequest, ListPoliciesResponse, com.google.cloud.designcenter.v1.Policy>
            context,
        ApiFuture<ListPoliciesResponse> futureResponse) {
      ApiFuture<ListPoliciesPage> futurePage =
          ListPoliciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPoliciesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPoliciesPagedResponse(ListPoliciesPage page) {
      super(page, ListPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPoliciesPage
      extends AbstractPage<
          ListPoliciesRequest,
          ListPoliciesResponse,
          com.google.cloud.designcenter.v1.Policy,
          ListPoliciesPage> {

    private ListPoliciesPage(
        @Nullable
            PageContext<
                ListPoliciesRequest, ListPoliciesResponse, com.google.cloud.designcenter.v1.Policy>
            context,
        @Nullable ListPoliciesResponse response) {
      super(context, response);
    }

    private static ListPoliciesPage createEmptyPage() {
      return new ListPoliciesPage(null, null);
    }

    @Override
    protected ListPoliciesPage createPage(
        @Nullable
            PageContext<
                ListPoliciesRequest, ListPoliciesResponse, com.google.cloud.designcenter.v1.Policy>
            context,
        @Nullable ListPoliciesResponse response) {
      return new ListPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListPoliciesPage> createPageAsync(
        @Nullable
            PageContext<
                ListPoliciesRequest, ListPoliciesResponse, com.google.cloud.designcenter.v1.Policy>
            context,
        ApiFuture<ListPoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPoliciesRequest,
          ListPoliciesResponse,
          com.google.cloud.designcenter.v1.Policy,
          ListPoliciesPage,
          ListPoliciesFixedSizeCollection> {

    private ListPoliciesFixedSizeCollection(
        @Nullable List<ListPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPoliciesFixedSizeCollection createEmptyCollection() {
      return new ListPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPoliciesFixedSizeCollection createCollection(
        @Nullable List<ListPoliciesPage> pages, int collectionSize) {
      return new ListPoliciesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class FetchFrameworksPagedResponse
      extends AbstractPagedListResponse<
          FetchFrameworksRequest,
          FetchFrameworksResponse,
          Framework,
          FetchFrameworksPage,
          FetchFrameworksFixedSizeCollection> {

    public static ApiFuture<FetchFrameworksPagedResponse> createAsync(
        PageContext<FetchFrameworksRequest, FetchFrameworksResponse, Framework> context,
        ApiFuture<FetchFrameworksResponse> futureResponse) {
      ApiFuture<FetchFrameworksPage> futurePage =
          FetchFrameworksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new FetchFrameworksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private FetchFrameworksPagedResponse(FetchFrameworksPage page) {
      super(page, FetchFrameworksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class FetchFrameworksPage
      extends AbstractPage<
          FetchFrameworksRequest, FetchFrameworksResponse, Framework, FetchFrameworksPage> {

    private FetchFrameworksPage(
        @Nullable PageContext<FetchFrameworksRequest, FetchFrameworksResponse, Framework> context,
        @Nullable FetchFrameworksResponse response) {
      super(context, response);
    }

    private static FetchFrameworksPage createEmptyPage() {
      return new FetchFrameworksPage(null, null);
    }

    @Override
    protected FetchFrameworksPage createPage(
        @Nullable PageContext<FetchFrameworksRequest, FetchFrameworksResponse, Framework> context,
        @Nullable FetchFrameworksResponse response) {
      return new FetchFrameworksPage(context, response);
    }

    @Override
    public ApiFuture<FetchFrameworksPage> createPageAsync(
        @Nullable PageContext<FetchFrameworksRequest, FetchFrameworksResponse, Framework> context,
        ApiFuture<FetchFrameworksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class FetchFrameworksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          FetchFrameworksRequest,
          FetchFrameworksResponse,
          Framework,
          FetchFrameworksPage,
          FetchFrameworksFixedSizeCollection> {

    private FetchFrameworksFixedSizeCollection(
        @Nullable List<FetchFrameworksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static FetchFrameworksFixedSizeCollection createEmptyCollection() {
      return new FetchFrameworksFixedSizeCollection(null, 0);
    }

    @Override
    protected FetchFrameworksFixedSizeCollection createCollection(
        @Nullable List<FetchFrameworksPage> pages, int collectionSize) {
      return new FetchFrameworksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListApplicationTemplateSystemRevisionsPagedResponse
      extends AbstractPagedListResponse<
          ListApplicationTemplateSystemRevisionsRequest,
          ListApplicationTemplateSystemRevisionsResponse,
          ApplicationTemplateSystemRevision,
          ListApplicationTemplateSystemRevisionsPage,
          ListApplicationTemplateSystemRevisionsFixedSizeCollection> {

    public static ApiFuture<ListApplicationTemplateSystemRevisionsPagedResponse> createAsync(
        PageContext<
                ListApplicationTemplateSystemRevisionsRequest,
                ListApplicationTemplateSystemRevisionsResponse,
                ApplicationTemplateSystemRevision>
            context,
        ApiFuture<ListApplicationTemplateSystemRevisionsResponse> futureResponse) {
      ApiFuture<ListApplicationTemplateSystemRevisionsPage> futurePage =
          ListApplicationTemplateSystemRevisionsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListApplicationTemplateSystemRevisionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListApplicationTemplateSystemRevisionsPagedResponse(
        ListApplicationTemplateSystemRevisionsPage page) {
      super(
          page, ListApplicationTemplateSystemRevisionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListApplicationTemplateSystemRevisionsPage
      extends AbstractPage<
          ListApplicationTemplateSystemRevisionsRequest,
          ListApplicationTemplateSystemRevisionsResponse,
          ApplicationTemplateSystemRevision,
          ListApplicationTemplateSystemRevisionsPage> {

    private ListApplicationTemplateSystemRevisionsPage(
        @Nullable
            PageContext<
                ListApplicationTemplateSystemRevisionsRequest,
                ListApplicationTemplateSystemRevisionsResponse,
                ApplicationTemplateSystemRevision>
            context,
        @Nullable ListApplicationTemplateSystemRevisionsResponse response) {
      super(context, response);
    }

    private static ListApplicationTemplateSystemRevisionsPage createEmptyPage() {
      return new ListApplicationTemplateSystemRevisionsPage(null, null);
    }

    @Override
    protected ListApplicationTemplateSystemRevisionsPage createPage(
        @Nullable
            PageContext<
                ListApplicationTemplateSystemRevisionsRequest,
                ListApplicationTemplateSystemRevisionsResponse,
                ApplicationTemplateSystemRevision>
            context,
        @Nullable ListApplicationTemplateSystemRevisionsResponse response) {
      return new ListApplicationTemplateSystemRevisionsPage(context, response);
    }

    @Override
    public ApiFuture<ListApplicationTemplateSystemRevisionsPage> createPageAsync(
        @Nullable
            PageContext<
                ListApplicationTemplateSystemRevisionsRequest,
                ListApplicationTemplateSystemRevisionsResponse,
                ApplicationTemplateSystemRevision>
            context,
        ApiFuture<ListApplicationTemplateSystemRevisionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListApplicationTemplateSystemRevisionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListApplicationTemplateSystemRevisionsRequest,
          ListApplicationTemplateSystemRevisionsResponse,
          ApplicationTemplateSystemRevision,
          ListApplicationTemplateSystemRevisionsPage,
          ListApplicationTemplateSystemRevisionsFixedSizeCollection> {

    private ListApplicationTemplateSystemRevisionsFixedSizeCollection(
        @Nullable List<ListApplicationTemplateSystemRevisionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListApplicationTemplateSystemRevisionsFixedSizeCollection
        createEmptyCollection() {
      return new ListApplicationTemplateSystemRevisionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListApplicationTemplateSystemRevisionsFixedSizeCollection createCollection(
        @Nullable List<ListApplicationTemplateSystemRevisionsPage> pages, int collectionSize) {
      return new ListApplicationTemplateSystemRevisionsFixedSizeCollection(pages, collectionSize);
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
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
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

    private ListLocationsFixedSizeCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
