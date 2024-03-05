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

package com.google.cloud.apphub.v1;

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
import com.google.cloud.apphub.v1.stub.AppHubStub;
import com.google.cloud.apphub.v1.stub.AppHubStubSettings;
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
 * Service Description: The AppHub services allows users to enable toplogy and telemetry
 * configuration.
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
 * try (AppHubClient appHubClient = AppHubClient.create()) {
 *   LocationName name = LocationName.of("[PROJECT]", "[LOCATION]");
 *   LookupServiceProjectAttachmentResponse response =
 *       appHubClient.lookupServiceProjectAttachment(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AppHubClient object to clean up resources such as
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
 *      <td><p> LookupServiceProjectAttachment</td>
 *      <td><p> Looks up a service project attachment. You can call this API from either a host or service project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> lookupServiceProjectAttachment(LookupServiceProjectAttachmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> lookupServiceProjectAttachment(LocationName name)
 *           <li><p> lookupServiceProjectAttachment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> lookupServiceProjectAttachmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListServiceProjectAttachments</td>
 *      <td><p> List service projects attached to the host project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listServiceProjectAttachments(ListServiceProjectAttachmentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listServiceProjectAttachments(LocationName parent)
 *           <li><p> listServiceProjectAttachments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listServiceProjectAttachmentsPagedCallable()
 *           <li><p> listServiceProjectAttachmentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateServiceProjectAttachment</td>
 *      <td><p> Attaches a service project to the host project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createServiceProjectAttachmentAsync(CreateServiceProjectAttachmentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createServiceProjectAttachmentAsync(LocationName parent, ServiceProjectAttachment serviceProjectAttachment, String serviceProjectAttachmentId)
 *           <li><p> createServiceProjectAttachmentAsync(String parent, ServiceProjectAttachment serviceProjectAttachment, String serviceProjectAttachmentId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createServiceProjectAttachmentOperationCallable()
 *           <li><p> createServiceProjectAttachmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetServiceProjectAttachment</td>
 *      <td><p> Gets a service project attached to the host project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getServiceProjectAttachment(GetServiceProjectAttachmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getServiceProjectAttachment(ServiceProjectAttachmentName name)
 *           <li><p> getServiceProjectAttachment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getServiceProjectAttachmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteServiceProjectAttachment</td>
 *      <td><p> Deletes a service project attached to the host project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteServiceProjectAttachmentAsync(DeleteServiceProjectAttachmentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteServiceProjectAttachmentAsync(ServiceProjectAttachmentName name)
 *           <li><p> deleteServiceProjectAttachmentAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteServiceProjectAttachmentOperationCallable()
 *           <li><p> deleteServiceProjectAttachmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DetachServiceProjectAttachment</td>
 *      <td><p> Detaches a service project from a host project. You can call this API from either a host or service project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> detachServiceProjectAttachment(DetachServiceProjectAttachmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> detachServiceProjectAttachment(LocationName name)
 *           <li><p> detachServiceProjectAttachment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> detachServiceProjectAttachmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDiscoveredServices</td>
 *      <td><p> Lists discovered services that can be added to an application in a host project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDiscoveredServices(ListDiscoveredServicesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDiscoveredServices(LocationName parent)
 *           <li><p> listDiscoveredServices(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDiscoveredServicesPagedCallable()
 *           <li><p> listDiscoveredServicesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDiscoveredService</td>
 *      <td><p> Gets a discovered service in a host project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDiscoveredService(GetDiscoveredServiceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDiscoveredService(DiscoveredServiceName name)
 *           <li><p> getDiscoveredService(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDiscoveredServiceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> LookupDiscoveredService</td>
 *      <td><p> Looks up a discovered service in a host project and location and with a given resource URI.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> lookupDiscoveredService(LookupDiscoveredServiceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> lookupDiscoveredService(LocationName parent, String uri)
 *           <li><p> lookupDiscoveredService(String parent, String uri)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> lookupDiscoveredServiceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListServices</td>
 *      <td><p> List Services in an Application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listServices(ListServicesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listServices(ApplicationName parent)
 *           <li><p> listServices(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listServicesPagedCallable()
 *           <li><p> listServicesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateService</td>
 *      <td><p> Creates a Service in an Application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createServiceAsync(CreateServiceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createServiceAsync(ApplicationName parent, Service service, String serviceId)
 *           <li><p> createServiceAsync(String parent, Service service, String serviceId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createServiceOperationCallable()
 *           <li><p> createServiceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetService</td>
 *      <td><p> Gets a Service in an Application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getService(GetServiceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getService(ServiceName name)
 *           <li><p> getService(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getServiceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateService</td>
 *      <td><p> Updates a Service in an Application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateServiceAsync(UpdateServiceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateServiceAsync(Service service, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateServiceOperationCallable()
 *           <li><p> updateServiceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteService</td>
 *      <td><p> Deletes a Service in an Application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteServiceAsync(DeleteServiceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteServiceAsync(ServiceName name)
 *           <li><p> deleteServiceAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteServiceOperationCallable()
 *           <li><p> deleteServiceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDiscoveredWorkloads</td>
 *      <td><p> Lists discovered workloads that can be added to an application in a host project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDiscoveredWorkloads(ListDiscoveredWorkloadsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDiscoveredWorkloads(LocationName parent)
 *           <li><p> listDiscoveredWorkloads(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDiscoveredWorkloadsPagedCallable()
 *           <li><p> listDiscoveredWorkloadsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDiscoveredWorkload</td>
 *      <td><p> Gets a discovered workload in a host project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDiscoveredWorkload(GetDiscoveredWorkloadRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDiscoveredWorkload(DiscoveredWorkloadName name)
 *           <li><p> getDiscoveredWorkload(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDiscoveredWorkloadCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> LookupDiscoveredWorkload</td>
 *      <td><p> Looks up a discovered Workload in a host project and location and with a given resource URI.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> lookupDiscoveredWorkload(LookupDiscoveredWorkloadRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> lookupDiscoveredWorkload(LocationName parent, String uri)
 *           <li><p> lookupDiscoveredWorkload(String parent, String uri)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> lookupDiscoveredWorkloadCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListWorkloads</td>
 *      <td><p> Lists Workloads in an Application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listWorkloads(ListWorkloadsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listWorkloads(ApplicationName parent)
 *           <li><p> listWorkloads(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listWorkloadsPagedCallable()
 *           <li><p> listWorkloadsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateWorkload</td>
 *      <td><p> Creates a Workload in an Application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createWorkloadAsync(CreateWorkloadRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createWorkloadAsync(ApplicationName parent, Workload workload, String workloadId)
 *           <li><p> createWorkloadAsync(String parent, Workload workload, String workloadId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createWorkloadOperationCallable()
 *           <li><p> createWorkloadCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetWorkload</td>
 *      <td><p> Gets a Workload in an Application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getWorkload(GetWorkloadRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getWorkload(WorkloadName name)
 *           <li><p> getWorkload(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getWorkloadCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateWorkload</td>
 *      <td><p> Updates a Workload in an Application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateWorkloadAsync(UpdateWorkloadRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateWorkloadAsync(Workload workload, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateWorkloadOperationCallable()
 *           <li><p> updateWorkloadCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteWorkload</td>
 *      <td><p> Deletes a Workload in an Application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteWorkloadAsync(DeleteWorkloadRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteWorkloadAsync(WorkloadName name)
 *           <li><p> deleteWorkloadAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteWorkloadOperationCallable()
 *           <li><p> deleteWorkloadCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListApplications</td>
 *      <td><p> Lists Applications in a host project and location.</td>
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
 *      <td><p> CreateApplication</td>
 *      <td><p> Creates an Application in a host project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createApplicationAsync(CreateApplicationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createApplicationAsync(LocationName parent, Application application, String applicationId)
 *           <li><p> createApplicationAsync(String parent, Application application, String applicationId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createApplicationOperationCallable()
 *           <li><p> createApplicationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetApplication</td>
 *      <td><p> Gets an Application in a host project and location.</td>
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
 *      <td><p> UpdateApplication</td>
 *      <td><p> Updates an Application in a host project and location.</td>
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
 *      <td><p> Deletes an Application in a host project and location.</td>
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
 * <p>This class can be customized by passing in a custom instance of AppHubSettings to create().
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
 * AppHubSettings appHubSettings =
 *     AppHubSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AppHubClient appHubClient = AppHubClient.create(appHubSettings);
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
 * AppHubSettings appHubSettings = AppHubSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AppHubClient appHubClient = AppHubClient.create(appHubSettings);
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
 * AppHubSettings appHubSettings = AppHubSettings.newHttpJsonBuilder().build();
 * AppHubClient appHubClient = AppHubClient.create(appHubSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AppHubClient implements BackgroundResource {
  private final AppHubSettings settings;
  private final AppHubStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of AppHubClient with default settings. */
  public static final AppHubClient create() throws IOException {
    return create(AppHubSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AppHubClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AppHubClient create(AppHubSettings settings) throws IOException {
    return new AppHubClient(settings);
  }

  /**
   * Constructs an instance of AppHubClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(AppHubSettings).
   */
  public static final AppHubClient create(AppHubStub stub) {
    return new AppHubClient(stub);
  }

  /**
   * Constructs an instance of AppHubClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected AppHubClient(AppHubSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AppHubStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected AppHubClient(AppHubStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final AppHubSettings getSettings() {
    return settings;
  }

  public AppHubStub getStub() {
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
   * Looks up a service project attachment. You can call this API from either a host or service
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   LocationName name = LocationName.of("[PROJECT]", "[LOCATION]");
   *   LookupServiceProjectAttachmentResponse response =
   *       appHubClient.lookupServiceProjectAttachment(name);
   * }
   * }</pre>
   *
   * @param name Required. Value for name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupServiceProjectAttachmentResponse lookupServiceProjectAttachment(
      LocationName name) {
    LookupServiceProjectAttachmentRequest request =
        LookupServiceProjectAttachmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return lookupServiceProjectAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a service project attachment. You can call this API from either a host or service
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   String name = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   LookupServiceProjectAttachmentResponse response =
   *       appHubClient.lookupServiceProjectAttachment(name);
   * }
   * }</pre>
   *
   * @param name Required. Value for name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupServiceProjectAttachmentResponse lookupServiceProjectAttachment(String name) {
    LookupServiceProjectAttachmentRequest request =
        LookupServiceProjectAttachmentRequest.newBuilder().setName(name).build();
    return lookupServiceProjectAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a service project attachment. You can call this API from either a host or service
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   LookupServiceProjectAttachmentRequest request =
   *       LookupServiceProjectAttachmentRequest.newBuilder()
   *           .setName(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   LookupServiceProjectAttachmentResponse response =
   *       appHubClient.lookupServiceProjectAttachment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupServiceProjectAttachmentResponse lookupServiceProjectAttachment(
      LookupServiceProjectAttachmentRequest request) {
    return lookupServiceProjectAttachmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a service project attachment. You can call this API from either a host or service
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   LookupServiceProjectAttachmentRequest request =
   *       LookupServiceProjectAttachmentRequest.newBuilder()
   *           .setName(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<LookupServiceProjectAttachmentResponse> future =
   *       appHubClient.lookupServiceProjectAttachmentCallable().futureCall(request);
   *   // Do something.
   *   LookupServiceProjectAttachmentResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          LookupServiceProjectAttachmentRequest, LookupServiceProjectAttachmentResponse>
      lookupServiceProjectAttachmentCallable() {
    return stub.lookupServiceProjectAttachmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List service projects attached to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ServiceProjectAttachment element :
   *       appHubClient.listServiceProjectAttachments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceProjectAttachmentsPagedResponse listServiceProjectAttachments(
      LocationName parent) {
    ListServiceProjectAttachmentsRequest request =
        ListServiceProjectAttachmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listServiceProjectAttachments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List service projects attached to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ServiceProjectAttachment element :
   *       appHubClient.listServiceProjectAttachments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceProjectAttachmentsPagedResponse listServiceProjectAttachments(
      String parent) {
    ListServiceProjectAttachmentsRequest request =
        ListServiceProjectAttachmentsRequest.newBuilder().setParent(parent).build();
    return listServiceProjectAttachments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List service projects attached to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ListServiceProjectAttachmentsRequest request =
   *       ListServiceProjectAttachmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ServiceProjectAttachment element :
   *       appHubClient.listServiceProjectAttachments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceProjectAttachmentsPagedResponse listServiceProjectAttachments(
      ListServiceProjectAttachmentsRequest request) {
    return listServiceProjectAttachmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List service projects attached to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ListServiceProjectAttachmentsRequest request =
   *       ListServiceProjectAttachmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ServiceProjectAttachment> future =
   *       appHubClient.listServiceProjectAttachmentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ServiceProjectAttachment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListServiceProjectAttachmentsRequest, ListServiceProjectAttachmentsPagedResponse>
      listServiceProjectAttachmentsPagedCallable() {
    return stub.listServiceProjectAttachmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List service projects attached to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ListServiceProjectAttachmentsRequest request =
   *       ListServiceProjectAttachmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListServiceProjectAttachmentsResponse response =
   *         appHubClient.listServiceProjectAttachmentsCallable().call(request);
   *     for (ServiceProjectAttachment element : response.getServiceProjectAttachmentsList()) {
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
          ListServiceProjectAttachmentsRequest, ListServiceProjectAttachmentsResponse>
      listServiceProjectAttachmentsCallable() {
    return stub.listServiceProjectAttachmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Attaches a service project to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ServiceProjectAttachment serviceProjectAttachment =
   *       ServiceProjectAttachment.newBuilder().build();
   *   String serviceProjectAttachmentId = "serviceProjectAttachmentId-1738589598";
   *   ServiceProjectAttachment response =
   *       appHubClient
   *           .createServiceProjectAttachmentAsync(
   *               parent, serviceProjectAttachment, serviceProjectAttachmentId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param serviceProjectAttachment Required. The resource being created.
   * @param serviceProjectAttachmentId Required. The service project attachment identifier must
   *     contain the project_id of the service project specified in the
   *     service_project_attachment.service_project field. Hint: "projects/{project_id}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServiceProjectAttachment, OperationMetadata>
      createServiceProjectAttachmentAsync(
          LocationName parent,
          ServiceProjectAttachment serviceProjectAttachment,
          String serviceProjectAttachmentId) {
    CreateServiceProjectAttachmentRequest request =
        CreateServiceProjectAttachmentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setServiceProjectAttachment(serviceProjectAttachment)
            .setServiceProjectAttachmentId(serviceProjectAttachmentId)
            .build();
    return createServiceProjectAttachmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Attaches a service project to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ServiceProjectAttachment serviceProjectAttachment =
   *       ServiceProjectAttachment.newBuilder().build();
   *   String serviceProjectAttachmentId = "serviceProjectAttachmentId-1738589598";
   *   ServiceProjectAttachment response =
   *       appHubClient
   *           .createServiceProjectAttachmentAsync(
   *               parent, serviceProjectAttachment, serviceProjectAttachmentId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param serviceProjectAttachment Required. The resource being created.
   * @param serviceProjectAttachmentId Required. The service project attachment identifier must
   *     contain the project_id of the service project specified in the
   *     service_project_attachment.service_project field. Hint: "projects/{project_id}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServiceProjectAttachment, OperationMetadata>
      createServiceProjectAttachmentAsync(
          String parent,
          ServiceProjectAttachment serviceProjectAttachment,
          String serviceProjectAttachmentId) {
    CreateServiceProjectAttachmentRequest request =
        CreateServiceProjectAttachmentRequest.newBuilder()
            .setParent(parent)
            .setServiceProjectAttachment(serviceProjectAttachment)
            .setServiceProjectAttachmentId(serviceProjectAttachmentId)
            .build();
    return createServiceProjectAttachmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Attaches a service project to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   CreateServiceProjectAttachmentRequest request =
   *       CreateServiceProjectAttachmentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServiceProjectAttachmentId("serviceProjectAttachmentId-1738589598")
   *           .setServiceProjectAttachment(ServiceProjectAttachment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ServiceProjectAttachment response =
   *       appHubClient.createServiceProjectAttachmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServiceProjectAttachment, OperationMetadata>
      createServiceProjectAttachmentAsync(CreateServiceProjectAttachmentRequest request) {
    return createServiceProjectAttachmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Attaches a service project to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   CreateServiceProjectAttachmentRequest request =
   *       CreateServiceProjectAttachmentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServiceProjectAttachmentId("serviceProjectAttachmentId-1738589598")
   *           .setServiceProjectAttachment(ServiceProjectAttachment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ServiceProjectAttachment, OperationMetadata> future =
   *       appHubClient.createServiceProjectAttachmentOperationCallable().futureCall(request);
   *   // Do something.
   *   ServiceProjectAttachment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateServiceProjectAttachmentRequest, ServiceProjectAttachment, OperationMetadata>
      createServiceProjectAttachmentOperationCallable() {
    return stub.createServiceProjectAttachmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Attaches a service project to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   CreateServiceProjectAttachmentRequest request =
   *       CreateServiceProjectAttachmentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServiceProjectAttachmentId("serviceProjectAttachmentId-1738589598")
   *           .setServiceProjectAttachment(ServiceProjectAttachment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       appHubClient.createServiceProjectAttachmentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateServiceProjectAttachmentRequest, Operation>
      createServiceProjectAttachmentCallable() {
    return stub.createServiceProjectAttachmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a service project attached to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ServiceProjectAttachmentName name =
   *       ServiceProjectAttachmentName.of(
   *           "[PROJECT]", "[LOCATION]", "[SERVICE_PROJECT_ATTACHMENT]");
   *   ServiceProjectAttachment response = appHubClient.getServiceProjectAttachment(name);
   * }
   * }</pre>
   *
   * @param name Required. Value for name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceProjectAttachment getServiceProjectAttachment(
      ServiceProjectAttachmentName name) {
    GetServiceProjectAttachmentRequest request =
        GetServiceProjectAttachmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getServiceProjectAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a service project attached to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   String name =
   *       ServiceProjectAttachmentName.of("[PROJECT]", "[LOCATION]", "[SERVICE_PROJECT_ATTACHMENT]")
   *           .toString();
   *   ServiceProjectAttachment response = appHubClient.getServiceProjectAttachment(name);
   * }
   * }</pre>
   *
   * @param name Required. Value for name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceProjectAttachment getServiceProjectAttachment(String name) {
    GetServiceProjectAttachmentRequest request =
        GetServiceProjectAttachmentRequest.newBuilder().setName(name).build();
    return getServiceProjectAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a service project attached to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   GetServiceProjectAttachmentRequest request =
   *       GetServiceProjectAttachmentRequest.newBuilder()
   *           .setName(
   *               ServiceProjectAttachmentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SERVICE_PROJECT_ATTACHMENT]")
   *                   .toString())
   *           .build();
   *   ServiceProjectAttachment response = appHubClient.getServiceProjectAttachment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceProjectAttachment getServiceProjectAttachment(
      GetServiceProjectAttachmentRequest request) {
    return getServiceProjectAttachmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a service project attached to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   GetServiceProjectAttachmentRequest request =
   *       GetServiceProjectAttachmentRequest.newBuilder()
   *           .setName(
   *               ServiceProjectAttachmentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SERVICE_PROJECT_ATTACHMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ServiceProjectAttachment> future =
   *       appHubClient.getServiceProjectAttachmentCallable().futureCall(request);
   *   // Do something.
   *   ServiceProjectAttachment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetServiceProjectAttachmentRequest, ServiceProjectAttachment>
      getServiceProjectAttachmentCallable() {
    return stub.getServiceProjectAttachmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a service project attached to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ServiceProjectAttachmentName name =
   *       ServiceProjectAttachmentName.of(
   *           "[PROJECT]", "[LOCATION]", "[SERVICE_PROJECT_ATTACHMENT]");
   *   appHubClient.deleteServiceProjectAttachmentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Value for name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceProjectAttachmentAsync(
      ServiceProjectAttachmentName name) {
    DeleteServiceProjectAttachmentRequest request =
        DeleteServiceProjectAttachmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteServiceProjectAttachmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a service project attached to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   String name =
   *       ServiceProjectAttachmentName.of("[PROJECT]", "[LOCATION]", "[SERVICE_PROJECT_ATTACHMENT]")
   *           .toString();
   *   appHubClient.deleteServiceProjectAttachmentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Value for name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceProjectAttachmentAsync(
      String name) {
    DeleteServiceProjectAttachmentRequest request =
        DeleteServiceProjectAttachmentRequest.newBuilder().setName(name).build();
    return deleteServiceProjectAttachmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a service project attached to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   DeleteServiceProjectAttachmentRequest request =
   *       DeleteServiceProjectAttachmentRequest.newBuilder()
   *           .setName(
   *               ServiceProjectAttachmentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SERVICE_PROJECT_ATTACHMENT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   appHubClient.deleteServiceProjectAttachmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceProjectAttachmentAsync(
      DeleteServiceProjectAttachmentRequest request) {
    return deleteServiceProjectAttachmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a service project attached to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   DeleteServiceProjectAttachmentRequest request =
   *       DeleteServiceProjectAttachmentRequest.newBuilder()
   *           .setName(
   *               ServiceProjectAttachmentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SERVICE_PROJECT_ATTACHMENT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       appHubClient.deleteServiceProjectAttachmentOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteServiceProjectAttachmentRequest, Empty, OperationMetadata>
      deleteServiceProjectAttachmentOperationCallable() {
    return stub.deleteServiceProjectAttachmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a service project attached to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   DeleteServiceProjectAttachmentRequest request =
   *       DeleteServiceProjectAttachmentRequest.newBuilder()
   *           .setName(
   *               ServiceProjectAttachmentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SERVICE_PROJECT_ATTACHMENT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       appHubClient.deleteServiceProjectAttachmentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteServiceProjectAttachmentRequest, Operation>
      deleteServiceProjectAttachmentCallable() {
    return stub.deleteServiceProjectAttachmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detaches a service project from a host project. You can call this API from either a host or
   * service project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   LocationName name = LocationName.of("[PROJECT]", "[LOCATION]");
   *   DetachServiceProjectAttachmentResponse response =
   *       appHubClient.detachServiceProjectAttachment(name);
   * }
   * }</pre>
   *
   * @param name Required. Value for name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DetachServiceProjectAttachmentResponse detachServiceProjectAttachment(
      LocationName name) {
    DetachServiceProjectAttachmentRequest request =
        DetachServiceProjectAttachmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return detachServiceProjectAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detaches a service project from a host project. You can call this API from either a host or
   * service project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   String name = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   DetachServiceProjectAttachmentResponse response =
   *       appHubClient.detachServiceProjectAttachment(name);
   * }
   * }</pre>
   *
   * @param name Required. Value for name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DetachServiceProjectAttachmentResponse detachServiceProjectAttachment(String name) {
    DetachServiceProjectAttachmentRequest request =
        DetachServiceProjectAttachmentRequest.newBuilder().setName(name).build();
    return detachServiceProjectAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detaches a service project from a host project. You can call this API from either a host or
   * service project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   DetachServiceProjectAttachmentRequest request =
   *       DetachServiceProjectAttachmentRequest.newBuilder()
   *           .setName(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   DetachServiceProjectAttachmentResponse response =
   *       appHubClient.detachServiceProjectAttachment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DetachServiceProjectAttachmentResponse detachServiceProjectAttachment(
      DetachServiceProjectAttachmentRequest request) {
    return detachServiceProjectAttachmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detaches a service project from a host project. You can call this API from either a host or
   * service project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   DetachServiceProjectAttachmentRequest request =
   *       DetachServiceProjectAttachmentRequest.newBuilder()
   *           .setName(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<DetachServiceProjectAttachmentResponse> future =
   *       appHubClient.detachServiceProjectAttachmentCallable().futureCall(request);
   *   // Do something.
   *   DetachServiceProjectAttachmentResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          DetachServiceProjectAttachmentRequest, DetachServiceProjectAttachmentResponse>
      detachServiceProjectAttachmentCallable() {
    return stub.detachServiceProjectAttachmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists discovered services that can be added to an application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (DiscoveredService element : appHubClient.listDiscoveredServices(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDiscoveredServicesPagedResponse listDiscoveredServices(LocationName parent) {
    ListDiscoveredServicesRequest request =
        ListDiscoveredServicesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDiscoveredServices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists discovered services that can be added to an application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (DiscoveredService element : appHubClient.listDiscoveredServices(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDiscoveredServicesPagedResponse listDiscoveredServices(String parent) {
    ListDiscoveredServicesRequest request =
        ListDiscoveredServicesRequest.newBuilder().setParent(parent).build();
    return listDiscoveredServices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists discovered services that can be added to an application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ListDiscoveredServicesRequest request =
   *       ListDiscoveredServicesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (DiscoveredService element : appHubClient.listDiscoveredServices(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDiscoveredServicesPagedResponse listDiscoveredServices(
      ListDiscoveredServicesRequest request) {
    return listDiscoveredServicesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists discovered services that can be added to an application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ListDiscoveredServicesRequest request =
   *       ListDiscoveredServicesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<DiscoveredService> future =
   *       appHubClient.listDiscoveredServicesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DiscoveredService element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDiscoveredServicesRequest, ListDiscoveredServicesPagedResponse>
      listDiscoveredServicesPagedCallable() {
    return stub.listDiscoveredServicesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists discovered services that can be added to an application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ListDiscoveredServicesRequest request =
   *       ListDiscoveredServicesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDiscoveredServicesResponse response =
   *         appHubClient.listDiscoveredServicesCallable().call(request);
   *     for (DiscoveredService element : response.getDiscoveredServicesList()) {
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
  public final UnaryCallable<ListDiscoveredServicesRequest, ListDiscoveredServicesResponse>
      listDiscoveredServicesCallable() {
    return stub.listDiscoveredServicesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a discovered service in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   DiscoveredServiceName name =
   *       DiscoveredServiceName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_SERVICE]");
   *   DiscoveredService response = appHubClient.getDiscoveredService(name);
   * }
   * }</pre>
   *
   * @param name Required. Value for name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiscoveredService getDiscoveredService(DiscoveredServiceName name) {
    GetDiscoveredServiceRequest request =
        GetDiscoveredServiceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDiscoveredService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a discovered service in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   String name =
   *       DiscoveredServiceName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_SERVICE]").toString();
   *   DiscoveredService response = appHubClient.getDiscoveredService(name);
   * }
   * }</pre>
   *
   * @param name Required. Value for name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiscoveredService getDiscoveredService(String name) {
    GetDiscoveredServiceRequest request =
        GetDiscoveredServiceRequest.newBuilder().setName(name).build();
    return getDiscoveredService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a discovered service in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   GetDiscoveredServiceRequest request =
   *       GetDiscoveredServiceRequest.newBuilder()
   *           .setName(
   *               DiscoveredServiceName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_SERVICE]")
   *                   .toString())
   *           .build();
   *   DiscoveredService response = appHubClient.getDiscoveredService(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiscoveredService getDiscoveredService(GetDiscoveredServiceRequest request) {
    return getDiscoveredServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a discovered service in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   GetDiscoveredServiceRequest request =
   *       GetDiscoveredServiceRequest.newBuilder()
   *           .setName(
   *               DiscoveredServiceName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_SERVICE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DiscoveredService> future =
   *       appHubClient.getDiscoveredServiceCallable().futureCall(request);
   *   // Do something.
   *   DiscoveredService response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDiscoveredServiceRequest, DiscoveredService>
      getDiscoveredServiceCallable() {
    return stub.getDiscoveredServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a discovered service in a host project and location and with a given resource URI.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String uri = "uri116076";
   *   LookupDiscoveredServiceResponse response = appHubClient.lookupDiscoveredService(parent, uri);
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param uri Required. GCP resource URI to find service for Accepts both project number and
   *     project id and does translation when needed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupDiscoveredServiceResponse lookupDiscoveredService(
      LocationName parent, String uri) {
    LookupDiscoveredServiceRequest request =
        LookupDiscoveredServiceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setUri(uri)
            .build();
    return lookupDiscoveredService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a discovered service in a host project and location and with a given resource URI.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String uri = "uri116076";
   *   LookupDiscoveredServiceResponse response = appHubClient.lookupDiscoveredService(parent, uri);
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param uri Required. GCP resource URI to find service for Accepts both project number and
   *     project id and does translation when needed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupDiscoveredServiceResponse lookupDiscoveredService(String parent, String uri) {
    LookupDiscoveredServiceRequest request =
        LookupDiscoveredServiceRequest.newBuilder().setParent(parent).setUri(uri).build();
    return lookupDiscoveredService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a discovered service in a host project and location and with a given resource URI.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   LookupDiscoveredServiceRequest request =
   *       LookupDiscoveredServiceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setUri("uri116076")
   *           .build();
   *   LookupDiscoveredServiceResponse response = appHubClient.lookupDiscoveredService(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupDiscoveredServiceResponse lookupDiscoveredService(
      LookupDiscoveredServiceRequest request) {
    return lookupDiscoveredServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a discovered service in a host project and location and with a given resource URI.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   LookupDiscoveredServiceRequest request =
   *       LookupDiscoveredServiceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setUri("uri116076")
   *           .build();
   *   ApiFuture<LookupDiscoveredServiceResponse> future =
   *       appHubClient.lookupDiscoveredServiceCallable().futureCall(request);
   *   // Do something.
   *   LookupDiscoveredServiceResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<LookupDiscoveredServiceRequest, LookupDiscoveredServiceResponse>
      lookupDiscoveredServiceCallable() {
    return stub.lookupDiscoveredServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Services in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ApplicationName parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
   *   for (Service element : appHubClient.listServices(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServicesPagedResponse listServices(ApplicationName parent) {
    ListServicesRequest request =
        ListServicesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listServices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Services in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   String parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString();
   *   for (Service element : appHubClient.listServices(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServicesPagedResponse listServices(String parent) {
    ListServicesRequest request = ListServicesRequest.newBuilder().setParent(parent).build();
    return listServices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Services in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ListServicesRequest request =
   *       ListServicesRequest.newBuilder()
   *           .setParent(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Service element : appHubClient.listServices(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServicesPagedResponse listServices(ListServicesRequest request) {
    return listServicesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Services in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ListServicesRequest request =
   *       ListServicesRequest.newBuilder()
   *           .setParent(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Service> future = appHubClient.listServicesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Service element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListServicesRequest, ListServicesPagedResponse>
      listServicesPagedCallable() {
    return stub.listServicesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Services in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ListServicesRequest request =
   *       ListServicesRequest.newBuilder()
   *           .setParent(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListServicesResponse response = appHubClient.listServicesCallable().call(request);
   *     for (Service element : response.getServicesList()) {
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
  public final UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable() {
    return stub.listServicesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Service in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ApplicationName parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
   *   Service service = Service.newBuilder().build();
   *   String serviceId = "serviceId-194185552";
   *   Service response = appHubClient.createServiceAsync(parent, service, serviceId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param service Required. The resource being created.
   * @param serviceId Required. The Service identifier. Must contain only lowercase letters, numbers
   *     or hyphens, with the first character a letter, the last a letter or a number, and a 63
   *     character maximum.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Service, OperationMetadata> createServiceAsync(
      ApplicationName parent, Service service, String serviceId) {
    CreateServiceRequest request =
        CreateServiceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setService(service)
            .setServiceId(serviceId)
            .build();
    return createServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Service in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   String parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString();
   *   Service service = Service.newBuilder().build();
   *   String serviceId = "serviceId-194185552";
   *   Service response = appHubClient.createServiceAsync(parent, service, serviceId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param service Required. The resource being created.
   * @param serviceId Required. The Service identifier. Must contain only lowercase letters, numbers
   *     or hyphens, with the first character a letter, the last a letter or a number, and a 63
   *     character maximum.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Service, OperationMetadata> createServiceAsync(
      String parent, Service service, String serviceId) {
    CreateServiceRequest request =
        CreateServiceRequest.newBuilder()
            .setParent(parent)
            .setService(service)
            .setServiceId(serviceId)
            .build();
    return createServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Service in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   CreateServiceRequest request =
   *       CreateServiceRequest.newBuilder()
   *           .setParent(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setServiceId("serviceId-194185552")
   *           .setService(Service.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Service response = appHubClient.createServiceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Service, OperationMetadata> createServiceAsync(
      CreateServiceRequest request) {
    return createServiceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Service in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   CreateServiceRequest request =
   *       CreateServiceRequest.newBuilder()
   *           .setParent(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setServiceId("serviceId-194185552")
   *           .setService(Service.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Service, OperationMetadata> future =
   *       appHubClient.createServiceOperationCallable().futureCall(request);
   *   // Do something.
   *   Service response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateServiceRequest, Service, OperationMetadata>
      createServiceOperationCallable() {
    return stub.createServiceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Service in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   CreateServiceRequest request =
   *       CreateServiceRequest.newBuilder()
   *           .setParent(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setServiceId("serviceId-194185552")
   *           .setService(Service.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = appHubClient.createServiceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateServiceRequest, Operation> createServiceCallable() {
    return stub.createServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Service in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[SERVICE]");
   *   Service response = appHubClient.getService(name);
   * }
   * }</pre>
   *
   * @param name Required. Value for name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Service getService(ServiceName name) {
    GetServiceRequest request =
        GetServiceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Service in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   String name =
   *       ServiceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[SERVICE]").toString();
   *   Service response = appHubClient.getService(name);
   * }
   * }</pre>
   *
   * @param name Required. Value for name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Service getService(String name) {
    GetServiceRequest request = GetServiceRequest.newBuilder().setName(name).build();
    return getService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Service in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   GetServiceRequest request =
   *       GetServiceRequest.newBuilder()
   *           .setName(
   *               ServiceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[SERVICE]")
   *                   .toString())
   *           .build();
   *   Service response = appHubClient.getService(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Service getService(GetServiceRequest request) {
    return getServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Service in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   GetServiceRequest request =
   *       GetServiceRequest.newBuilder()
   *           .setName(
   *               ServiceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[SERVICE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Service> future = appHubClient.getServiceCallable().futureCall(request);
   *   // Do something.
   *   Service response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetServiceRequest, Service> getServiceCallable() {
    return stub.getServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Service in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   Service service = Service.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Service response = appHubClient.updateServiceAsync(service, updateMask).get();
   * }
   * }</pre>
   *
   * @param service Required. The resource being updated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Service resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. The API changes the values of the fields as specified in
   *     the update_mask. The API ignores the values of all fields not covered by the update_mask.
   *     You can also unset a field by not specifying it in the updated message, but adding the
   *     field to the mask. This clears whatever value the field previously had.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Service, OperationMetadata> updateServiceAsync(
      Service service, FieldMask updateMask) {
    UpdateServiceRequest request =
        UpdateServiceRequest.newBuilder().setService(service).setUpdateMask(updateMask).build();
    return updateServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Service in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   UpdateServiceRequest request =
   *       UpdateServiceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setService(Service.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Service response = appHubClient.updateServiceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Service, OperationMetadata> updateServiceAsync(
      UpdateServiceRequest request) {
    return updateServiceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Service in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   UpdateServiceRequest request =
   *       UpdateServiceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setService(Service.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Service, OperationMetadata> future =
   *       appHubClient.updateServiceOperationCallable().futureCall(request);
   *   // Do something.
   *   Service response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateServiceRequest, Service, OperationMetadata>
      updateServiceOperationCallable() {
    return stub.updateServiceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Service in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   UpdateServiceRequest request =
   *       UpdateServiceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setService(Service.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = appHubClient.updateServiceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateServiceRequest, Operation> updateServiceCallable() {
    return stub.updateServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Service in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[SERVICE]");
   *   appHubClient.deleteServiceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Value for name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceAsync(ServiceName name) {
    DeleteServiceRequest request =
        DeleteServiceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Service in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   String name =
   *       ServiceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[SERVICE]").toString();
   *   appHubClient.deleteServiceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Value for name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceAsync(String name) {
    DeleteServiceRequest request = DeleteServiceRequest.newBuilder().setName(name).build();
    return deleteServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Service in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   DeleteServiceRequest request =
   *       DeleteServiceRequest.newBuilder()
   *           .setName(
   *               ServiceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[SERVICE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   appHubClient.deleteServiceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceAsync(
      DeleteServiceRequest request) {
    return deleteServiceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Service in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   DeleteServiceRequest request =
   *       DeleteServiceRequest.newBuilder()
   *           .setName(
   *               ServiceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[SERVICE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       appHubClient.deleteServiceOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationCallable() {
    return stub.deleteServiceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Service in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   DeleteServiceRequest request =
   *       DeleteServiceRequest.newBuilder()
   *           .setName(
   *               ServiceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[SERVICE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = appHubClient.deleteServiceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteServiceRequest, Operation> deleteServiceCallable() {
    return stub.deleteServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists discovered workloads that can be added to an application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (DiscoveredWorkload element : appHubClient.listDiscoveredWorkloads(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDiscoveredWorkloadsPagedResponse listDiscoveredWorkloads(LocationName parent) {
    ListDiscoveredWorkloadsRequest request =
        ListDiscoveredWorkloadsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDiscoveredWorkloads(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists discovered workloads that can be added to an application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (DiscoveredWorkload element : appHubClient.listDiscoveredWorkloads(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDiscoveredWorkloadsPagedResponse listDiscoveredWorkloads(String parent) {
    ListDiscoveredWorkloadsRequest request =
        ListDiscoveredWorkloadsRequest.newBuilder().setParent(parent).build();
    return listDiscoveredWorkloads(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists discovered workloads that can be added to an application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ListDiscoveredWorkloadsRequest request =
   *       ListDiscoveredWorkloadsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (DiscoveredWorkload element :
   *       appHubClient.listDiscoveredWorkloads(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDiscoveredWorkloadsPagedResponse listDiscoveredWorkloads(
      ListDiscoveredWorkloadsRequest request) {
    return listDiscoveredWorkloadsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists discovered workloads that can be added to an application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ListDiscoveredWorkloadsRequest request =
   *       ListDiscoveredWorkloadsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<DiscoveredWorkload> future =
   *       appHubClient.listDiscoveredWorkloadsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DiscoveredWorkload element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDiscoveredWorkloadsRequest, ListDiscoveredWorkloadsPagedResponse>
      listDiscoveredWorkloadsPagedCallable() {
    return stub.listDiscoveredWorkloadsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists discovered workloads that can be added to an application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ListDiscoveredWorkloadsRequest request =
   *       ListDiscoveredWorkloadsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDiscoveredWorkloadsResponse response =
   *         appHubClient.listDiscoveredWorkloadsCallable().call(request);
   *     for (DiscoveredWorkload element : response.getDiscoveredWorkloadsList()) {
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
  public final UnaryCallable<ListDiscoveredWorkloadsRequest, ListDiscoveredWorkloadsResponse>
      listDiscoveredWorkloadsCallable() {
    return stub.listDiscoveredWorkloadsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a discovered workload in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   DiscoveredWorkloadName name =
   *       DiscoveredWorkloadName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_WORKLOAD]");
   *   DiscoveredWorkload response = appHubClient.getDiscoveredWorkload(name);
   * }
   * }</pre>
   *
   * @param name Required. Value for name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiscoveredWorkload getDiscoveredWorkload(DiscoveredWorkloadName name) {
    GetDiscoveredWorkloadRequest request =
        GetDiscoveredWorkloadRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDiscoveredWorkload(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a discovered workload in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   String name =
   *       DiscoveredWorkloadName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_WORKLOAD]").toString();
   *   DiscoveredWorkload response = appHubClient.getDiscoveredWorkload(name);
   * }
   * }</pre>
   *
   * @param name Required. Value for name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiscoveredWorkload getDiscoveredWorkload(String name) {
    GetDiscoveredWorkloadRequest request =
        GetDiscoveredWorkloadRequest.newBuilder().setName(name).build();
    return getDiscoveredWorkload(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a discovered workload in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   GetDiscoveredWorkloadRequest request =
   *       GetDiscoveredWorkloadRequest.newBuilder()
   *           .setName(
   *               DiscoveredWorkloadName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_WORKLOAD]")
   *                   .toString())
   *           .build();
   *   DiscoveredWorkload response = appHubClient.getDiscoveredWorkload(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiscoveredWorkload getDiscoveredWorkload(GetDiscoveredWorkloadRequest request) {
    return getDiscoveredWorkloadCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a discovered workload in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   GetDiscoveredWorkloadRequest request =
   *       GetDiscoveredWorkloadRequest.newBuilder()
   *           .setName(
   *               DiscoveredWorkloadName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_WORKLOAD]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DiscoveredWorkload> future =
   *       appHubClient.getDiscoveredWorkloadCallable().futureCall(request);
   *   // Do something.
   *   DiscoveredWorkload response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDiscoveredWorkloadRequest, DiscoveredWorkload>
      getDiscoveredWorkloadCallable() {
    return stub.getDiscoveredWorkloadCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a discovered Workload in a host project and location and with a given resource URI.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String uri = "uri116076";
   *   LookupDiscoveredWorkloadResponse response =
   *       appHubClient.lookupDiscoveredWorkload(parent, uri);
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param uri Required. GCP resource URI to find workload for. Accepts both project number and
   *     project id and does translation when needed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupDiscoveredWorkloadResponse lookupDiscoveredWorkload(
      LocationName parent, String uri) {
    LookupDiscoveredWorkloadRequest request =
        LookupDiscoveredWorkloadRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setUri(uri)
            .build();
    return lookupDiscoveredWorkload(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a discovered Workload in a host project and location and with a given resource URI.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String uri = "uri116076";
   *   LookupDiscoveredWorkloadResponse response =
   *       appHubClient.lookupDiscoveredWorkload(parent, uri);
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param uri Required. GCP resource URI to find workload for. Accepts both project number and
   *     project id and does translation when needed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupDiscoveredWorkloadResponse lookupDiscoveredWorkload(
      String parent, String uri) {
    LookupDiscoveredWorkloadRequest request =
        LookupDiscoveredWorkloadRequest.newBuilder().setParent(parent).setUri(uri).build();
    return lookupDiscoveredWorkload(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a discovered Workload in a host project and location and with a given resource URI.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   LookupDiscoveredWorkloadRequest request =
   *       LookupDiscoveredWorkloadRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setUri("uri116076")
   *           .build();
   *   LookupDiscoveredWorkloadResponse response = appHubClient.lookupDiscoveredWorkload(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupDiscoveredWorkloadResponse lookupDiscoveredWorkload(
      LookupDiscoveredWorkloadRequest request) {
    return lookupDiscoveredWorkloadCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a discovered Workload in a host project and location and with a given resource URI.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   LookupDiscoveredWorkloadRequest request =
   *       LookupDiscoveredWorkloadRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setUri("uri116076")
   *           .build();
   *   ApiFuture<LookupDiscoveredWorkloadResponse> future =
   *       appHubClient.lookupDiscoveredWorkloadCallable().futureCall(request);
   *   // Do something.
   *   LookupDiscoveredWorkloadResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<LookupDiscoveredWorkloadRequest, LookupDiscoveredWorkloadResponse>
      lookupDiscoveredWorkloadCallable() {
    return stub.lookupDiscoveredWorkloadCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Workloads in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ApplicationName parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
   *   for (Workload element : appHubClient.listWorkloads(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkloadsPagedResponse listWorkloads(ApplicationName parent) {
    ListWorkloadsRequest request =
        ListWorkloadsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listWorkloads(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Workloads in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   String parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString();
   *   for (Workload element : appHubClient.listWorkloads(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkloadsPagedResponse listWorkloads(String parent) {
    ListWorkloadsRequest request = ListWorkloadsRequest.newBuilder().setParent(parent).build();
    return listWorkloads(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Workloads in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ListWorkloadsRequest request =
   *       ListWorkloadsRequest.newBuilder()
   *           .setParent(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Workload element : appHubClient.listWorkloads(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkloadsPagedResponse listWorkloads(ListWorkloadsRequest request) {
    return listWorkloadsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Workloads in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ListWorkloadsRequest request =
   *       ListWorkloadsRequest.newBuilder()
   *           .setParent(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Workload> future = appHubClient.listWorkloadsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Workload element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListWorkloadsRequest, ListWorkloadsPagedResponse>
      listWorkloadsPagedCallable() {
    return stub.listWorkloadsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Workloads in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ListWorkloadsRequest request =
   *       ListWorkloadsRequest.newBuilder()
   *           .setParent(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListWorkloadsResponse response = appHubClient.listWorkloadsCallable().call(request);
   *     for (Workload element : response.getWorkloadsList()) {
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
  public final UnaryCallable<ListWorkloadsRequest, ListWorkloadsResponse> listWorkloadsCallable() {
    return stub.listWorkloadsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Workload in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ApplicationName parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
   *   Workload workload = Workload.newBuilder().build();
   *   String workloadId = "workloadId-186277134";
   *   Workload response = appHubClient.createWorkloadAsync(parent, workload, workloadId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param workload Required. The resource being created.
   * @param workloadId Required. The Workload identifier. Must contain only lowercase letters,
   *     numbers or hyphens, with the first character a letter, the last a letter or a number, and a
   *     63 character maximum.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workload, OperationMetadata> createWorkloadAsync(
      ApplicationName parent, Workload workload, String workloadId) {
    CreateWorkloadRequest request =
        CreateWorkloadRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setWorkload(workload)
            .setWorkloadId(workloadId)
            .build();
    return createWorkloadAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Workload in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   String parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString();
   *   Workload workload = Workload.newBuilder().build();
   *   String workloadId = "workloadId-186277134";
   *   Workload response = appHubClient.createWorkloadAsync(parent, workload, workloadId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param workload Required. The resource being created.
   * @param workloadId Required. The Workload identifier. Must contain only lowercase letters,
   *     numbers or hyphens, with the first character a letter, the last a letter or a number, and a
   *     63 character maximum.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workload, OperationMetadata> createWorkloadAsync(
      String parent, Workload workload, String workloadId) {
    CreateWorkloadRequest request =
        CreateWorkloadRequest.newBuilder()
            .setParent(parent)
            .setWorkload(workload)
            .setWorkloadId(workloadId)
            .build();
    return createWorkloadAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Workload in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   CreateWorkloadRequest request =
   *       CreateWorkloadRequest.newBuilder()
   *           .setParent(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setWorkloadId("workloadId-186277134")
   *           .setWorkload(Workload.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Workload response = appHubClient.createWorkloadAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workload, OperationMetadata> createWorkloadAsync(
      CreateWorkloadRequest request) {
    return createWorkloadOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Workload in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   CreateWorkloadRequest request =
   *       CreateWorkloadRequest.newBuilder()
   *           .setParent(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setWorkloadId("workloadId-186277134")
   *           .setWorkload(Workload.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Workload, OperationMetadata> future =
   *       appHubClient.createWorkloadOperationCallable().futureCall(request);
   *   // Do something.
   *   Workload response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateWorkloadRequest, Workload, OperationMetadata>
      createWorkloadOperationCallable() {
    return stub.createWorkloadOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Workload in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   CreateWorkloadRequest request =
   *       CreateWorkloadRequest.newBuilder()
   *           .setParent(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setWorkloadId("workloadId-186277134")
   *           .setWorkload(Workload.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = appHubClient.createWorkloadCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateWorkloadRequest, Operation> createWorkloadCallable() {
    return stub.createWorkloadCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Workload in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   WorkloadName name = WorkloadName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[WORKLOAD]");
   *   Workload response = appHubClient.getWorkload(name);
   * }
   * }</pre>
   *
   * @param name Required. Value for name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Workload getWorkload(WorkloadName name) {
    GetWorkloadRequest request =
        GetWorkloadRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getWorkload(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Workload in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   String name =
   *       WorkloadName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[WORKLOAD]").toString();
   *   Workload response = appHubClient.getWorkload(name);
   * }
   * }</pre>
   *
   * @param name Required. Value for name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Workload getWorkload(String name) {
    GetWorkloadRequest request = GetWorkloadRequest.newBuilder().setName(name).build();
    return getWorkload(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Workload in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   GetWorkloadRequest request =
   *       GetWorkloadRequest.newBuilder()
   *           .setName(
   *               WorkloadName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[WORKLOAD]")
   *                   .toString())
   *           .build();
   *   Workload response = appHubClient.getWorkload(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Workload getWorkload(GetWorkloadRequest request) {
    return getWorkloadCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Workload in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   GetWorkloadRequest request =
   *       GetWorkloadRequest.newBuilder()
   *           .setName(
   *               WorkloadName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[WORKLOAD]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Workload> future = appHubClient.getWorkloadCallable().futureCall(request);
   *   // Do something.
   *   Workload response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetWorkloadRequest, Workload> getWorkloadCallable() {
    return stub.getWorkloadCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Workload in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   Workload workload = Workload.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Workload response = appHubClient.updateWorkloadAsync(workload, updateMask).get();
   * }
   * }</pre>
   *
   * @param workload Required. The resource being updated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Workload resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. The API changes the values of the fields as specified
   *     in the update_mask. The API ignores the values of all fields not covered by the
   *     update_mask. You can also unset a field by not specifying it in the updated message, but
   *     adding the field to the mask. This clears whatever value the field previously had.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workload, OperationMetadata> updateWorkloadAsync(
      Workload workload, FieldMask updateMask) {
    UpdateWorkloadRequest request =
        UpdateWorkloadRequest.newBuilder().setWorkload(workload).setUpdateMask(updateMask).build();
    return updateWorkloadAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Workload in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   UpdateWorkloadRequest request =
   *       UpdateWorkloadRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setWorkload(Workload.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Workload response = appHubClient.updateWorkloadAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workload, OperationMetadata> updateWorkloadAsync(
      UpdateWorkloadRequest request) {
    return updateWorkloadOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Workload in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   UpdateWorkloadRequest request =
   *       UpdateWorkloadRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setWorkload(Workload.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Workload, OperationMetadata> future =
   *       appHubClient.updateWorkloadOperationCallable().futureCall(request);
   *   // Do something.
   *   Workload response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateWorkloadRequest, Workload, OperationMetadata>
      updateWorkloadOperationCallable() {
    return stub.updateWorkloadOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Workload in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   UpdateWorkloadRequest request =
   *       UpdateWorkloadRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setWorkload(Workload.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = appHubClient.updateWorkloadCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateWorkloadRequest, Operation> updateWorkloadCallable() {
    return stub.updateWorkloadCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Workload in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   WorkloadName name = WorkloadName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[WORKLOAD]");
   *   appHubClient.deleteWorkloadAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Value for name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteWorkloadAsync(WorkloadName name) {
    DeleteWorkloadRequest request =
        DeleteWorkloadRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteWorkloadAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Workload in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   String name =
   *       WorkloadName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[WORKLOAD]").toString();
   *   appHubClient.deleteWorkloadAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Value for name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteWorkloadAsync(String name) {
    DeleteWorkloadRequest request = DeleteWorkloadRequest.newBuilder().setName(name).build();
    return deleteWorkloadAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Workload in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   DeleteWorkloadRequest request =
   *       DeleteWorkloadRequest.newBuilder()
   *           .setName(
   *               WorkloadName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[WORKLOAD]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   appHubClient.deleteWorkloadAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteWorkloadAsync(
      DeleteWorkloadRequest request) {
    return deleteWorkloadOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Workload in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   DeleteWorkloadRequest request =
   *       DeleteWorkloadRequest.newBuilder()
   *           .setName(
   *               WorkloadName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[WORKLOAD]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       appHubClient.deleteWorkloadOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteWorkloadRequest, Empty, OperationMetadata>
      deleteWorkloadOperationCallable() {
    return stub.deleteWorkloadOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Workload in an Application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   DeleteWorkloadRequest request =
   *       DeleteWorkloadRequest.newBuilder()
   *           .setName(
   *               WorkloadName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[WORKLOAD]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = appHubClient.deleteWorkloadCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteWorkloadRequest, Operation> deleteWorkloadCallable() {
    return stub.deleteWorkloadCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Applications in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Application element : appHubClient.listApplications(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
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
   * Lists Applications in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Application element : appHubClient.listApplications(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApplicationsPagedResponse listApplications(String parent) {
    ListApplicationsRequest request =
        ListApplicationsRequest.newBuilder().setParent(parent).build();
    return listApplications(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Applications in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ListApplicationsRequest request =
   *       ListApplicationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Application element : appHubClient.listApplications(request).iterateAll()) {
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
   * Lists Applications in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ListApplicationsRequest request =
   *       ListApplicationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Application> future =
   *       appHubClient.listApplicationsPagedCallable().futureCall(request);
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
   * Lists Applications in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ListApplicationsRequest request =
   *       ListApplicationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListApplicationsResponse response = appHubClient.listApplicationsCallable().call(request);
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
   * Creates an Application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Application application = Application.newBuilder().build();
   *   String applicationId = "applicationId-1011352949";
   *   Application response =
   *       appHubClient.createApplicationAsync(parent, application, applicationId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param application Required. The resource being created
   * @param applicationId Required. The Application identifier. Must contain only lowercase letters,
   *     numbers or hyphens, with the first character a letter, the last a letter or a number, and a
   *     63 character maximum.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Application, OperationMetadata> createApplicationAsync(
      LocationName parent, Application application, String applicationId) {
    CreateApplicationRequest request =
        CreateApplicationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setApplication(application)
            .setApplicationId(applicationId)
            .build();
    return createApplicationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Application application = Application.newBuilder().build();
   *   String applicationId = "applicationId-1011352949";
   *   Application response =
   *       appHubClient.createApplicationAsync(parent, application, applicationId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param application Required. The resource being created
   * @param applicationId Required. The Application identifier. Must contain only lowercase letters,
   *     numbers or hyphens, with the first character a letter, the last a letter or a number, and a
   *     63 character maximum.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Application, OperationMetadata> createApplicationAsync(
      String parent, Application application, String applicationId) {
    CreateApplicationRequest request =
        CreateApplicationRequest.newBuilder()
            .setParent(parent)
            .setApplication(application)
            .setApplicationId(applicationId)
            .build();
    return createApplicationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   CreateApplicationRequest request =
   *       CreateApplicationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setApplicationId("applicationId-1011352949")
   *           .setApplication(Application.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Application response = appHubClient.createApplicationAsync(request).get();
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
   * Creates an Application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   CreateApplicationRequest request =
   *       CreateApplicationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setApplicationId("applicationId-1011352949")
   *           .setApplication(Application.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Application, OperationMetadata> future =
   *       appHubClient.createApplicationOperationCallable().futureCall(request);
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
   * Creates an Application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   CreateApplicationRequest request =
   *       CreateApplicationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setApplicationId("applicationId-1011352949")
   *           .setApplication(Application.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = appHubClient.createApplicationCallable().futureCall(request);
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
   * Gets an Application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
   *   Application response = appHubClient.getApplication(name);
   * }
   * }</pre>
   *
   * @param name Required. Value for name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Application getApplication(ApplicationName name) {
    GetApplicationRequest request =
        GetApplicationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getApplication(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an Application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   String name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString();
   *   Application response = appHubClient.getApplication(name);
   * }
   * }</pre>
   *
   * @param name Required. Value for name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Application getApplication(String name) {
    GetApplicationRequest request = GetApplicationRequest.newBuilder().setName(name).build();
    return getApplication(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an Application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   GetApplicationRequest request =
   *       GetApplicationRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .build();
   *   Application response = appHubClient.getApplication(request);
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
   * Gets an Application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   GetApplicationRequest request =
   *       GetApplicationRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .build();
   *   ApiFuture<Application> future = appHubClient.getApplicationCallable().futureCall(request);
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
   * Updates an Application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   Application application = Application.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Application response = appHubClient.updateApplicationAsync(application, updateMask).get();
   * }
   * }</pre>
   *
   * @param application Required. The resource being updated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Application resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. The API changes the values of the fields as specified
   *     in the update_mask. The API ignores the values of all fields not covered by the
   *     update_mask. You can also unset a field by not specifying it in the updated message, but
   *     adding the field to the mask. This clears whatever value the field previously had.
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
   * Updates an Application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   UpdateApplicationRequest request =
   *       UpdateApplicationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setApplication(Application.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Application response = appHubClient.updateApplicationAsync(request).get();
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
   * Updates an Application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   UpdateApplicationRequest request =
   *       UpdateApplicationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setApplication(Application.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Application, OperationMetadata> future =
   *       appHubClient.updateApplicationOperationCallable().futureCall(request);
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
   * Updates an Application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   UpdateApplicationRequest request =
   *       UpdateApplicationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setApplication(Application.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = appHubClient.updateApplicationCallable().futureCall(request);
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
   * Deletes an Application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
   *   appHubClient.deleteApplicationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Value for name.
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
   * Deletes an Application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   String name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString();
   *   appHubClient.deleteApplicationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Value for name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteApplicationAsync(String name) {
    DeleteApplicationRequest request = DeleteApplicationRequest.newBuilder().setName(name).build();
    return deleteApplicationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   DeleteApplicationRequest request =
   *       DeleteApplicationRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   appHubClient.deleteApplicationAsync(request).get();
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
   * Deletes an Application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   DeleteApplicationRequest request =
   *       DeleteApplicationRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       appHubClient.deleteApplicationOperationCallable().futureCall(request);
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
   * Deletes an Application in a host project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   DeleteApplicationRequest request =
   *       DeleteApplicationRequest.newBuilder()
   *           .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = appHubClient.deleteApplicationCallable().futureCall(request);
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
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : appHubClient.listLocations(request).iterateAll()) {
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
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future = appHubClient.listLocationsPagedCallable().futureCall(request);
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
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = appHubClient.listLocationsCallable().call(request);
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
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = appHubClient.getLocation(request);
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
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = appHubClient.getLocationCallable().futureCall(request);
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
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = appHubClient.setIamPolicy(request);
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
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = appHubClient.setIamPolicyCallable().futureCall(request);
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
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = appHubClient.getIamPolicy(request);
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
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = appHubClient.getIamPolicyCallable().futureCall(request);
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
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = appHubClient.testIamPermissions(request);
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
   * try (AppHubClient appHubClient = AppHubClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       appHubClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListServiceProjectAttachmentsPagedResponse
      extends AbstractPagedListResponse<
          ListServiceProjectAttachmentsRequest,
          ListServiceProjectAttachmentsResponse,
          ServiceProjectAttachment,
          ListServiceProjectAttachmentsPage,
          ListServiceProjectAttachmentsFixedSizeCollection> {

    public static ApiFuture<ListServiceProjectAttachmentsPagedResponse> createAsync(
        PageContext<
                ListServiceProjectAttachmentsRequest,
                ListServiceProjectAttachmentsResponse,
                ServiceProjectAttachment>
            context,
        ApiFuture<ListServiceProjectAttachmentsResponse> futureResponse) {
      ApiFuture<ListServiceProjectAttachmentsPage> futurePage =
          ListServiceProjectAttachmentsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListServiceProjectAttachmentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListServiceProjectAttachmentsPagedResponse(ListServiceProjectAttachmentsPage page) {
      super(page, ListServiceProjectAttachmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListServiceProjectAttachmentsPage
      extends AbstractPage<
          ListServiceProjectAttachmentsRequest,
          ListServiceProjectAttachmentsResponse,
          ServiceProjectAttachment,
          ListServiceProjectAttachmentsPage> {

    private ListServiceProjectAttachmentsPage(
        PageContext<
                ListServiceProjectAttachmentsRequest,
                ListServiceProjectAttachmentsResponse,
                ServiceProjectAttachment>
            context,
        ListServiceProjectAttachmentsResponse response) {
      super(context, response);
    }

    private static ListServiceProjectAttachmentsPage createEmptyPage() {
      return new ListServiceProjectAttachmentsPage(null, null);
    }

    @Override
    protected ListServiceProjectAttachmentsPage createPage(
        PageContext<
                ListServiceProjectAttachmentsRequest,
                ListServiceProjectAttachmentsResponse,
                ServiceProjectAttachment>
            context,
        ListServiceProjectAttachmentsResponse response) {
      return new ListServiceProjectAttachmentsPage(context, response);
    }

    @Override
    public ApiFuture<ListServiceProjectAttachmentsPage> createPageAsync(
        PageContext<
                ListServiceProjectAttachmentsRequest,
                ListServiceProjectAttachmentsResponse,
                ServiceProjectAttachment>
            context,
        ApiFuture<ListServiceProjectAttachmentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListServiceProjectAttachmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListServiceProjectAttachmentsRequest,
          ListServiceProjectAttachmentsResponse,
          ServiceProjectAttachment,
          ListServiceProjectAttachmentsPage,
          ListServiceProjectAttachmentsFixedSizeCollection> {

    private ListServiceProjectAttachmentsFixedSizeCollection(
        List<ListServiceProjectAttachmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListServiceProjectAttachmentsFixedSizeCollection createEmptyCollection() {
      return new ListServiceProjectAttachmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListServiceProjectAttachmentsFixedSizeCollection createCollection(
        List<ListServiceProjectAttachmentsPage> pages, int collectionSize) {
      return new ListServiceProjectAttachmentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDiscoveredServicesPagedResponse
      extends AbstractPagedListResponse<
          ListDiscoveredServicesRequest,
          ListDiscoveredServicesResponse,
          DiscoveredService,
          ListDiscoveredServicesPage,
          ListDiscoveredServicesFixedSizeCollection> {

    public static ApiFuture<ListDiscoveredServicesPagedResponse> createAsync(
        PageContext<
                ListDiscoveredServicesRequest, ListDiscoveredServicesResponse, DiscoveredService>
            context,
        ApiFuture<ListDiscoveredServicesResponse> futureResponse) {
      ApiFuture<ListDiscoveredServicesPage> futurePage =
          ListDiscoveredServicesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDiscoveredServicesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDiscoveredServicesPagedResponse(ListDiscoveredServicesPage page) {
      super(page, ListDiscoveredServicesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDiscoveredServicesPage
      extends AbstractPage<
          ListDiscoveredServicesRequest,
          ListDiscoveredServicesResponse,
          DiscoveredService,
          ListDiscoveredServicesPage> {

    private ListDiscoveredServicesPage(
        PageContext<
                ListDiscoveredServicesRequest, ListDiscoveredServicesResponse, DiscoveredService>
            context,
        ListDiscoveredServicesResponse response) {
      super(context, response);
    }

    private static ListDiscoveredServicesPage createEmptyPage() {
      return new ListDiscoveredServicesPage(null, null);
    }

    @Override
    protected ListDiscoveredServicesPage createPage(
        PageContext<
                ListDiscoveredServicesRequest, ListDiscoveredServicesResponse, DiscoveredService>
            context,
        ListDiscoveredServicesResponse response) {
      return new ListDiscoveredServicesPage(context, response);
    }

    @Override
    public ApiFuture<ListDiscoveredServicesPage> createPageAsync(
        PageContext<
                ListDiscoveredServicesRequest, ListDiscoveredServicesResponse, DiscoveredService>
            context,
        ApiFuture<ListDiscoveredServicesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDiscoveredServicesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDiscoveredServicesRequest,
          ListDiscoveredServicesResponse,
          DiscoveredService,
          ListDiscoveredServicesPage,
          ListDiscoveredServicesFixedSizeCollection> {

    private ListDiscoveredServicesFixedSizeCollection(
        List<ListDiscoveredServicesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDiscoveredServicesFixedSizeCollection createEmptyCollection() {
      return new ListDiscoveredServicesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDiscoveredServicesFixedSizeCollection createCollection(
        List<ListDiscoveredServicesPage> pages, int collectionSize) {
      return new ListDiscoveredServicesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListServicesPagedResponse
      extends AbstractPagedListResponse<
          ListServicesRequest,
          ListServicesResponse,
          Service,
          ListServicesPage,
          ListServicesFixedSizeCollection> {

    public static ApiFuture<ListServicesPagedResponse> createAsync(
        PageContext<ListServicesRequest, ListServicesResponse, Service> context,
        ApiFuture<ListServicesResponse> futureResponse) {
      ApiFuture<ListServicesPage> futurePage =
          ListServicesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListServicesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListServicesPagedResponse(ListServicesPage page) {
      super(page, ListServicesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListServicesPage
      extends AbstractPage<ListServicesRequest, ListServicesResponse, Service, ListServicesPage> {

    private ListServicesPage(
        PageContext<ListServicesRequest, ListServicesResponse, Service> context,
        ListServicesResponse response) {
      super(context, response);
    }

    private static ListServicesPage createEmptyPage() {
      return new ListServicesPage(null, null);
    }

    @Override
    protected ListServicesPage createPage(
        PageContext<ListServicesRequest, ListServicesResponse, Service> context,
        ListServicesResponse response) {
      return new ListServicesPage(context, response);
    }

    @Override
    public ApiFuture<ListServicesPage> createPageAsync(
        PageContext<ListServicesRequest, ListServicesResponse, Service> context,
        ApiFuture<ListServicesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListServicesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListServicesRequest,
          ListServicesResponse,
          Service,
          ListServicesPage,
          ListServicesFixedSizeCollection> {

    private ListServicesFixedSizeCollection(List<ListServicesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListServicesFixedSizeCollection createEmptyCollection() {
      return new ListServicesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListServicesFixedSizeCollection createCollection(
        List<ListServicesPage> pages, int collectionSize) {
      return new ListServicesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDiscoveredWorkloadsPagedResponse
      extends AbstractPagedListResponse<
          ListDiscoveredWorkloadsRequest,
          ListDiscoveredWorkloadsResponse,
          DiscoveredWorkload,
          ListDiscoveredWorkloadsPage,
          ListDiscoveredWorkloadsFixedSizeCollection> {

    public static ApiFuture<ListDiscoveredWorkloadsPagedResponse> createAsync(
        PageContext<
                ListDiscoveredWorkloadsRequest, ListDiscoveredWorkloadsResponse, DiscoveredWorkload>
            context,
        ApiFuture<ListDiscoveredWorkloadsResponse> futureResponse) {
      ApiFuture<ListDiscoveredWorkloadsPage> futurePage =
          ListDiscoveredWorkloadsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDiscoveredWorkloadsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDiscoveredWorkloadsPagedResponse(ListDiscoveredWorkloadsPage page) {
      super(page, ListDiscoveredWorkloadsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDiscoveredWorkloadsPage
      extends AbstractPage<
          ListDiscoveredWorkloadsRequest,
          ListDiscoveredWorkloadsResponse,
          DiscoveredWorkload,
          ListDiscoveredWorkloadsPage> {

    private ListDiscoveredWorkloadsPage(
        PageContext<
                ListDiscoveredWorkloadsRequest, ListDiscoveredWorkloadsResponse, DiscoveredWorkload>
            context,
        ListDiscoveredWorkloadsResponse response) {
      super(context, response);
    }

    private static ListDiscoveredWorkloadsPage createEmptyPage() {
      return new ListDiscoveredWorkloadsPage(null, null);
    }

    @Override
    protected ListDiscoveredWorkloadsPage createPage(
        PageContext<
                ListDiscoveredWorkloadsRequest, ListDiscoveredWorkloadsResponse, DiscoveredWorkload>
            context,
        ListDiscoveredWorkloadsResponse response) {
      return new ListDiscoveredWorkloadsPage(context, response);
    }

    @Override
    public ApiFuture<ListDiscoveredWorkloadsPage> createPageAsync(
        PageContext<
                ListDiscoveredWorkloadsRequest, ListDiscoveredWorkloadsResponse, DiscoveredWorkload>
            context,
        ApiFuture<ListDiscoveredWorkloadsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDiscoveredWorkloadsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDiscoveredWorkloadsRequest,
          ListDiscoveredWorkloadsResponse,
          DiscoveredWorkload,
          ListDiscoveredWorkloadsPage,
          ListDiscoveredWorkloadsFixedSizeCollection> {

    private ListDiscoveredWorkloadsFixedSizeCollection(
        List<ListDiscoveredWorkloadsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDiscoveredWorkloadsFixedSizeCollection createEmptyCollection() {
      return new ListDiscoveredWorkloadsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDiscoveredWorkloadsFixedSizeCollection createCollection(
        List<ListDiscoveredWorkloadsPage> pages, int collectionSize) {
      return new ListDiscoveredWorkloadsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListWorkloadsPagedResponse
      extends AbstractPagedListResponse<
          ListWorkloadsRequest,
          ListWorkloadsResponse,
          Workload,
          ListWorkloadsPage,
          ListWorkloadsFixedSizeCollection> {

    public static ApiFuture<ListWorkloadsPagedResponse> createAsync(
        PageContext<ListWorkloadsRequest, ListWorkloadsResponse, Workload> context,
        ApiFuture<ListWorkloadsResponse> futureResponse) {
      ApiFuture<ListWorkloadsPage> futurePage =
          ListWorkloadsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListWorkloadsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListWorkloadsPagedResponse(ListWorkloadsPage page) {
      super(page, ListWorkloadsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListWorkloadsPage
      extends AbstractPage<
          ListWorkloadsRequest, ListWorkloadsResponse, Workload, ListWorkloadsPage> {

    private ListWorkloadsPage(
        PageContext<ListWorkloadsRequest, ListWorkloadsResponse, Workload> context,
        ListWorkloadsResponse response) {
      super(context, response);
    }

    private static ListWorkloadsPage createEmptyPage() {
      return new ListWorkloadsPage(null, null);
    }

    @Override
    protected ListWorkloadsPage createPage(
        PageContext<ListWorkloadsRequest, ListWorkloadsResponse, Workload> context,
        ListWorkloadsResponse response) {
      return new ListWorkloadsPage(context, response);
    }

    @Override
    public ApiFuture<ListWorkloadsPage> createPageAsync(
        PageContext<ListWorkloadsRequest, ListWorkloadsResponse, Workload> context,
        ApiFuture<ListWorkloadsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListWorkloadsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListWorkloadsRequest,
          ListWorkloadsResponse,
          Workload,
          ListWorkloadsPage,
          ListWorkloadsFixedSizeCollection> {

    private ListWorkloadsFixedSizeCollection(List<ListWorkloadsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListWorkloadsFixedSizeCollection createEmptyCollection() {
      return new ListWorkloadsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListWorkloadsFixedSizeCollection createCollection(
        List<ListWorkloadsPage> pages, int collectionSize) {
      return new ListWorkloadsFixedSizeCollection(pages, collectionSize);
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
