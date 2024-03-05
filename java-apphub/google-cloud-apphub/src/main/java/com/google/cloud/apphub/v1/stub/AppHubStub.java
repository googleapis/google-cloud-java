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

package com.google.cloud.apphub.v1.stub;

import static com.google.cloud.apphub.v1.AppHubClient.ListApplicationsPagedResponse;
import static com.google.cloud.apphub.v1.AppHubClient.ListDiscoveredServicesPagedResponse;
import static com.google.cloud.apphub.v1.AppHubClient.ListDiscoveredWorkloadsPagedResponse;
import static com.google.cloud.apphub.v1.AppHubClient.ListLocationsPagedResponse;
import static com.google.cloud.apphub.v1.AppHubClient.ListServiceProjectAttachmentsPagedResponse;
import static com.google.cloud.apphub.v1.AppHubClient.ListServicesPagedResponse;
import static com.google.cloud.apphub.v1.AppHubClient.ListWorkloadsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apphub.v1.Application;
import com.google.cloud.apphub.v1.CreateApplicationRequest;
import com.google.cloud.apphub.v1.CreateServiceProjectAttachmentRequest;
import com.google.cloud.apphub.v1.CreateServiceRequest;
import com.google.cloud.apphub.v1.CreateWorkloadRequest;
import com.google.cloud.apphub.v1.DeleteApplicationRequest;
import com.google.cloud.apphub.v1.DeleteServiceProjectAttachmentRequest;
import com.google.cloud.apphub.v1.DeleteServiceRequest;
import com.google.cloud.apphub.v1.DeleteWorkloadRequest;
import com.google.cloud.apphub.v1.DetachServiceProjectAttachmentRequest;
import com.google.cloud.apphub.v1.DetachServiceProjectAttachmentResponse;
import com.google.cloud.apphub.v1.DiscoveredService;
import com.google.cloud.apphub.v1.DiscoveredWorkload;
import com.google.cloud.apphub.v1.GetApplicationRequest;
import com.google.cloud.apphub.v1.GetDiscoveredServiceRequest;
import com.google.cloud.apphub.v1.GetDiscoveredWorkloadRequest;
import com.google.cloud.apphub.v1.GetServiceProjectAttachmentRequest;
import com.google.cloud.apphub.v1.GetServiceRequest;
import com.google.cloud.apphub.v1.GetWorkloadRequest;
import com.google.cloud.apphub.v1.ListApplicationsRequest;
import com.google.cloud.apphub.v1.ListApplicationsResponse;
import com.google.cloud.apphub.v1.ListDiscoveredServicesRequest;
import com.google.cloud.apphub.v1.ListDiscoveredServicesResponse;
import com.google.cloud.apphub.v1.ListDiscoveredWorkloadsRequest;
import com.google.cloud.apphub.v1.ListDiscoveredWorkloadsResponse;
import com.google.cloud.apphub.v1.ListServiceProjectAttachmentsRequest;
import com.google.cloud.apphub.v1.ListServiceProjectAttachmentsResponse;
import com.google.cloud.apphub.v1.ListServicesRequest;
import com.google.cloud.apphub.v1.ListServicesResponse;
import com.google.cloud.apphub.v1.ListWorkloadsRequest;
import com.google.cloud.apphub.v1.ListWorkloadsResponse;
import com.google.cloud.apphub.v1.LookupDiscoveredServiceRequest;
import com.google.cloud.apphub.v1.LookupDiscoveredServiceResponse;
import com.google.cloud.apphub.v1.LookupDiscoveredWorkloadRequest;
import com.google.cloud.apphub.v1.LookupDiscoveredWorkloadResponse;
import com.google.cloud.apphub.v1.LookupServiceProjectAttachmentRequest;
import com.google.cloud.apphub.v1.LookupServiceProjectAttachmentResponse;
import com.google.cloud.apphub.v1.OperationMetadata;
import com.google.cloud.apphub.v1.Service;
import com.google.cloud.apphub.v1.ServiceProjectAttachment;
import com.google.cloud.apphub.v1.UpdateApplicationRequest;
import com.google.cloud.apphub.v1.UpdateServiceRequest;
import com.google.cloud.apphub.v1.UpdateWorkloadRequest;
import com.google.cloud.apphub.v1.Workload;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AppHub service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AppHubStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<
          LookupServiceProjectAttachmentRequest, LookupServiceProjectAttachmentResponse>
      lookupServiceProjectAttachmentCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: lookupServiceProjectAttachmentCallable()");
  }

  public UnaryCallable<
          ListServiceProjectAttachmentsRequest, ListServiceProjectAttachmentsPagedResponse>
      listServiceProjectAttachmentsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listServiceProjectAttachmentsPagedCallable()");
  }

  public UnaryCallable<ListServiceProjectAttachmentsRequest, ListServiceProjectAttachmentsResponse>
      listServiceProjectAttachmentsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listServiceProjectAttachmentsCallable()");
  }

  public OperationCallable<
          CreateServiceProjectAttachmentRequest, ServiceProjectAttachment, OperationMetadata>
      createServiceProjectAttachmentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createServiceProjectAttachmentOperationCallable()");
  }

  public UnaryCallable<CreateServiceProjectAttachmentRequest, Operation>
      createServiceProjectAttachmentCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createServiceProjectAttachmentCallable()");
  }

  public UnaryCallable<GetServiceProjectAttachmentRequest, ServiceProjectAttachment>
      getServiceProjectAttachmentCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getServiceProjectAttachmentCallable()");
  }

  public OperationCallable<DeleteServiceProjectAttachmentRequest, Empty, OperationMetadata>
      deleteServiceProjectAttachmentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteServiceProjectAttachmentOperationCallable()");
  }

  public UnaryCallable<DeleteServiceProjectAttachmentRequest, Operation>
      deleteServiceProjectAttachmentCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteServiceProjectAttachmentCallable()");
  }

  public UnaryCallable<
          DetachServiceProjectAttachmentRequest, DetachServiceProjectAttachmentResponse>
      detachServiceProjectAttachmentCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: detachServiceProjectAttachmentCallable()");
  }

  public UnaryCallable<ListDiscoveredServicesRequest, ListDiscoveredServicesPagedResponse>
      listDiscoveredServicesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDiscoveredServicesPagedCallable()");
  }

  public UnaryCallable<ListDiscoveredServicesRequest, ListDiscoveredServicesResponse>
      listDiscoveredServicesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDiscoveredServicesCallable()");
  }

  public UnaryCallable<GetDiscoveredServiceRequest, DiscoveredService>
      getDiscoveredServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: getDiscoveredServiceCallable()");
  }

  public UnaryCallable<LookupDiscoveredServiceRequest, LookupDiscoveredServiceResponse>
      lookupDiscoveredServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: lookupDiscoveredServiceCallable()");
  }

  public UnaryCallable<ListServicesRequest, ListServicesPagedResponse> listServicesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listServicesPagedCallable()");
  }

  public UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable() {
    throw new UnsupportedOperationException("Not implemented: listServicesCallable()");
  }

  public OperationCallable<CreateServiceRequest, Service, OperationMetadata>
      createServiceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createServiceOperationCallable()");
  }

  public UnaryCallable<CreateServiceRequest, Operation> createServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: createServiceCallable()");
  }

  public UnaryCallable<GetServiceRequest, Service> getServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: getServiceCallable()");
  }

  public OperationCallable<UpdateServiceRequest, Service, OperationMetadata>
      updateServiceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateServiceOperationCallable()");
  }

  public UnaryCallable<UpdateServiceRequest, Operation> updateServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateServiceCallable()");
  }

  public OperationCallable<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteServiceOperationCallable()");
  }

  public UnaryCallable<DeleteServiceRequest, Operation> deleteServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteServiceCallable()");
  }

  public UnaryCallable<ListDiscoveredWorkloadsRequest, ListDiscoveredWorkloadsPagedResponse>
      listDiscoveredWorkloadsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDiscoveredWorkloadsPagedCallable()");
  }

  public UnaryCallable<ListDiscoveredWorkloadsRequest, ListDiscoveredWorkloadsResponse>
      listDiscoveredWorkloadsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDiscoveredWorkloadsCallable()");
  }

  public UnaryCallable<GetDiscoveredWorkloadRequest, DiscoveredWorkload>
      getDiscoveredWorkloadCallable() {
    throw new UnsupportedOperationException("Not implemented: getDiscoveredWorkloadCallable()");
  }

  public UnaryCallable<LookupDiscoveredWorkloadRequest, LookupDiscoveredWorkloadResponse>
      lookupDiscoveredWorkloadCallable() {
    throw new UnsupportedOperationException("Not implemented: lookupDiscoveredWorkloadCallable()");
  }

  public UnaryCallable<ListWorkloadsRequest, ListWorkloadsPagedResponse>
      listWorkloadsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listWorkloadsPagedCallable()");
  }

  public UnaryCallable<ListWorkloadsRequest, ListWorkloadsResponse> listWorkloadsCallable() {
    throw new UnsupportedOperationException("Not implemented: listWorkloadsCallable()");
  }

  public OperationCallable<CreateWorkloadRequest, Workload, OperationMetadata>
      createWorkloadOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createWorkloadOperationCallable()");
  }

  public UnaryCallable<CreateWorkloadRequest, Operation> createWorkloadCallable() {
    throw new UnsupportedOperationException("Not implemented: createWorkloadCallable()");
  }

  public UnaryCallable<GetWorkloadRequest, Workload> getWorkloadCallable() {
    throw new UnsupportedOperationException("Not implemented: getWorkloadCallable()");
  }

  public OperationCallable<UpdateWorkloadRequest, Workload, OperationMetadata>
      updateWorkloadOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateWorkloadOperationCallable()");
  }

  public UnaryCallable<UpdateWorkloadRequest, Operation> updateWorkloadCallable() {
    throw new UnsupportedOperationException("Not implemented: updateWorkloadCallable()");
  }

  public OperationCallable<DeleteWorkloadRequest, Empty, OperationMetadata>
      deleteWorkloadOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteWorkloadOperationCallable()");
  }

  public UnaryCallable<DeleteWorkloadRequest, Operation> deleteWorkloadCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteWorkloadCallable()");
  }

  public UnaryCallable<ListApplicationsRequest, ListApplicationsPagedResponse>
      listApplicationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listApplicationsPagedCallable()");
  }

  public UnaryCallable<ListApplicationsRequest, ListApplicationsResponse>
      listApplicationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listApplicationsCallable()");
  }

  public OperationCallable<CreateApplicationRequest, Application, OperationMetadata>
      createApplicationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createApplicationOperationCallable()");
  }

  public UnaryCallable<CreateApplicationRequest, Operation> createApplicationCallable() {
    throw new UnsupportedOperationException("Not implemented: createApplicationCallable()");
  }

  public UnaryCallable<GetApplicationRequest, Application> getApplicationCallable() {
    throw new UnsupportedOperationException("Not implemented: getApplicationCallable()");
  }

  public OperationCallable<UpdateApplicationRequest, Application, OperationMetadata>
      updateApplicationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateApplicationOperationCallable()");
  }

  public UnaryCallable<UpdateApplicationRequest, Operation> updateApplicationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateApplicationCallable()");
  }

  public OperationCallable<DeleteApplicationRequest, Empty, OperationMetadata>
      deleteApplicationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteApplicationOperationCallable()");
  }

  public UnaryCallable<DeleteApplicationRequest, Operation> deleteApplicationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteApplicationCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
