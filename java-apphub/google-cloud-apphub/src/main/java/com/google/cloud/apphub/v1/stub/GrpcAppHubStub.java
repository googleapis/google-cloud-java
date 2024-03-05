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
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
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
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AppHub service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAppHubStub extends AppHubStub {
  private static final MethodDescriptor<
          LookupServiceProjectAttachmentRequest, LookupServiceProjectAttachmentResponse>
      lookupServiceProjectAttachmentMethodDescriptor =
          MethodDescriptor
              .<LookupServiceProjectAttachmentRequest, LookupServiceProjectAttachmentResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apphub.v1.AppHub/LookupServiceProjectAttachment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(LookupServiceProjectAttachmentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      LookupServiceProjectAttachmentResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListServiceProjectAttachmentsRequest, ListServiceProjectAttachmentsResponse>
      listServiceProjectAttachmentsMethodDescriptor =
          MethodDescriptor
              .<ListServiceProjectAttachmentsRequest, ListServiceProjectAttachmentsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apphub.v1.AppHub/ListServiceProjectAttachments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListServiceProjectAttachmentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServiceProjectAttachmentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateServiceProjectAttachmentRequest, Operation>
      createServiceProjectAttachmentMethodDescriptor =
          MethodDescriptor.<CreateServiceProjectAttachmentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apphub.v1.AppHub/CreateServiceProjectAttachment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateServiceProjectAttachmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetServiceProjectAttachmentRequest, ServiceProjectAttachment>
      getServiceProjectAttachmentMethodDescriptor =
          MethodDescriptor
              .<GetServiceProjectAttachmentRequest, ServiceProjectAttachment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apphub.v1.AppHub/GetServiceProjectAttachment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetServiceProjectAttachmentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ServiceProjectAttachment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteServiceProjectAttachmentRequest, Operation>
      deleteServiceProjectAttachmentMethodDescriptor =
          MethodDescriptor.<DeleteServiceProjectAttachmentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apphub.v1.AppHub/DeleteServiceProjectAttachment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteServiceProjectAttachmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          DetachServiceProjectAttachmentRequest, DetachServiceProjectAttachmentResponse>
      detachServiceProjectAttachmentMethodDescriptor =
          MethodDescriptor
              .<DetachServiceProjectAttachmentRequest, DetachServiceProjectAttachmentResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apphub.v1.AppHub/DetachServiceProjectAttachment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DetachServiceProjectAttachmentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      DetachServiceProjectAttachmentResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListDiscoveredServicesRequest, ListDiscoveredServicesResponse>
      listDiscoveredServicesMethodDescriptor =
          MethodDescriptor
              .<ListDiscoveredServicesRequest, ListDiscoveredServicesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apphub.v1.AppHub/ListDiscoveredServices")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDiscoveredServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDiscoveredServicesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDiscoveredServiceRequest, DiscoveredService>
      getDiscoveredServiceMethodDescriptor =
          MethodDescriptor.<GetDiscoveredServiceRequest, DiscoveredService>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apphub.v1.AppHub/GetDiscoveredService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDiscoveredServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DiscoveredService.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          LookupDiscoveredServiceRequest, LookupDiscoveredServiceResponse>
      lookupDiscoveredServiceMethodDescriptor =
          MethodDescriptor
              .<LookupDiscoveredServiceRequest, LookupDiscoveredServiceResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apphub.v1.AppHub/LookupDiscoveredService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(LookupDiscoveredServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(LookupDiscoveredServiceResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListServicesRequest, ListServicesResponse>
      listServicesMethodDescriptor =
          MethodDescriptor.<ListServicesRequest, ListServicesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apphub.v1.AppHub/ListServices")
              .setRequestMarshaller(ProtoUtils.marshaller(ListServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServicesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateServiceRequest, Operation>
      createServiceMethodDescriptor =
          MethodDescriptor.<CreateServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apphub.v1.AppHub/CreateService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetServiceRequest, Service> getServiceMethodDescriptor =
      MethodDescriptor.<GetServiceRequest, Service>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apphub.v1.AppHub/GetService")
          .setRequestMarshaller(ProtoUtils.marshaller(GetServiceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Service.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateServiceRequest, Operation>
      updateServiceMethodDescriptor =
          MethodDescriptor.<UpdateServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apphub.v1.AppHub/UpdateService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteServiceRequest, Operation>
      deleteServiceMethodDescriptor =
          MethodDescriptor.<DeleteServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apphub.v1.AppHub/DeleteService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListDiscoveredWorkloadsRequest, ListDiscoveredWorkloadsResponse>
      listDiscoveredWorkloadsMethodDescriptor =
          MethodDescriptor
              .<ListDiscoveredWorkloadsRequest, ListDiscoveredWorkloadsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apphub.v1.AppHub/ListDiscoveredWorkloads")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDiscoveredWorkloadsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDiscoveredWorkloadsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDiscoveredWorkloadRequest, DiscoveredWorkload>
      getDiscoveredWorkloadMethodDescriptor =
          MethodDescriptor.<GetDiscoveredWorkloadRequest, DiscoveredWorkload>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apphub.v1.AppHub/GetDiscoveredWorkload")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDiscoveredWorkloadRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DiscoveredWorkload.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          LookupDiscoveredWorkloadRequest, LookupDiscoveredWorkloadResponse>
      lookupDiscoveredWorkloadMethodDescriptor =
          MethodDescriptor
              .<LookupDiscoveredWorkloadRequest, LookupDiscoveredWorkloadResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apphub.v1.AppHub/LookupDiscoveredWorkload")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(LookupDiscoveredWorkloadRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(LookupDiscoveredWorkloadResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListWorkloadsRequest, ListWorkloadsResponse>
      listWorkloadsMethodDescriptor =
          MethodDescriptor.<ListWorkloadsRequest, ListWorkloadsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apphub.v1.AppHub/ListWorkloads")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListWorkloadsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListWorkloadsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateWorkloadRequest, Operation>
      createWorkloadMethodDescriptor =
          MethodDescriptor.<CreateWorkloadRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apphub.v1.AppHub/CreateWorkload")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateWorkloadRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetWorkloadRequest, Workload> getWorkloadMethodDescriptor =
      MethodDescriptor.<GetWorkloadRequest, Workload>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apphub.v1.AppHub/GetWorkload")
          .setRequestMarshaller(ProtoUtils.marshaller(GetWorkloadRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Workload.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateWorkloadRequest, Operation>
      updateWorkloadMethodDescriptor =
          MethodDescriptor.<UpdateWorkloadRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apphub.v1.AppHub/UpdateWorkload")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateWorkloadRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteWorkloadRequest, Operation>
      deleteWorkloadMethodDescriptor =
          MethodDescriptor.<DeleteWorkloadRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apphub.v1.AppHub/DeleteWorkload")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteWorkloadRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListApplicationsRequest, ListApplicationsResponse>
      listApplicationsMethodDescriptor =
          MethodDescriptor.<ListApplicationsRequest, ListApplicationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apphub.v1.AppHub/ListApplications")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListApplicationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListApplicationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateApplicationRequest, Operation>
      createApplicationMethodDescriptor =
          MethodDescriptor.<CreateApplicationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apphub.v1.AppHub/CreateApplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetApplicationRequest, Application>
      getApplicationMethodDescriptor =
          MethodDescriptor.<GetApplicationRequest, Application>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apphub.v1.AppHub/GetApplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Application.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateApplicationRequest, Operation>
      updateApplicationMethodDescriptor =
          MethodDescriptor.<UpdateApplicationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apphub.v1.AppHub/UpdateApplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteApplicationRequest, Operation>
      deleteApplicationMethodDescriptor =
          MethodDescriptor.<DeleteApplicationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apphub.v1.AppHub/DeleteApplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<
          LookupServiceProjectAttachmentRequest, LookupServiceProjectAttachmentResponse>
      lookupServiceProjectAttachmentCallable;
  private final UnaryCallable<
          ListServiceProjectAttachmentsRequest, ListServiceProjectAttachmentsResponse>
      listServiceProjectAttachmentsCallable;
  private final UnaryCallable<
          ListServiceProjectAttachmentsRequest, ListServiceProjectAttachmentsPagedResponse>
      listServiceProjectAttachmentsPagedCallable;
  private final UnaryCallable<CreateServiceProjectAttachmentRequest, Operation>
      createServiceProjectAttachmentCallable;
  private final OperationCallable<
          CreateServiceProjectAttachmentRequest, ServiceProjectAttachment, OperationMetadata>
      createServiceProjectAttachmentOperationCallable;
  private final UnaryCallable<GetServiceProjectAttachmentRequest, ServiceProjectAttachment>
      getServiceProjectAttachmentCallable;
  private final UnaryCallable<DeleteServiceProjectAttachmentRequest, Operation>
      deleteServiceProjectAttachmentCallable;
  private final OperationCallable<DeleteServiceProjectAttachmentRequest, Empty, OperationMetadata>
      deleteServiceProjectAttachmentOperationCallable;
  private final UnaryCallable<
          DetachServiceProjectAttachmentRequest, DetachServiceProjectAttachmentResponse>
      detachServiceProjectAttachmentCallable;
  private final UnaryCallable<ListDiscoveredServicesRequest, ListDiscoveredServicesResponse>
      listDiscoveredServicesCallable;
  private final UnaryCallable<ListDiscoveredServicesRequest, ListDiscoveredServicesPagedResponse>
      listDiscoveredServicesPagedCallable;
  private final UnaryCallable<GetDiscoveredServiceRequest, DiscoveredService>
      getDiscoveredServiceCallable;
  private final UnaryCallable<LookupDiscoveredServiceRequest, LookupDiscoveredServiceResponse>
      lookupDiscoveredServiceCallable;
  private final UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable;
  private final UnaryCallable<ListServicesRequest, ListServicesPagedResponse>
      listServicesPagedCallable;
  private final UnaryCallable<CreateServiceRequest, Operation> createServiceCallable;
  private final OperationCallable<CreateServiceRequest, Service, OperationMetadata>
      createServiceOperationCallable;
  private final UnaryCallable<GetServiceRequest, Service> getServiceCallable;
  private final UnaryCallable<UpdateServiceRequest, Operation> updateServiceCallable;
  private final OperationCallable<UpdateServiceRequest, Service, OperationMetadata>
      updateServiceOperationCallable;
  private final UnaryCallable<DeleteServiceRequest, Operation> deleteServiceCallable;
  private final OperationCallable<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationCallable;
  private final UnaryCallable<ListDiscoveredWorkloadsRequest, ListDiscoveredWorkloadsResponse>
      listDiscoveredWorkloadsCallable;
  private final UnaryCallable<ListDiscoveredWorkloadsRequest, ListDiscoveredWorkloadsPagedResponse>
      listDiscoveredWorkloadsPagedCallable;
  private final UnaryCallable<GetDiscoveredWorkloadRequest, DiscoveredWorkload>
      getDiscoveredWorkloadCallable;
  private final UnaryCallable<LookupDiscoveredWorkloadRequest, LookupDiscoveredWorkloadResponse>
      lookupDiscoveredWorkloadCallable;
  private final UnaryCallable<ListWorkloadsRequest, ListWorkloadsResponse> listWorkloadsCallable;
  private final UnaryCallable<ListWorkloadsRequest, ListWorkloadsPagedResponse>
      listWorkloadsPagedCallable;
  private final UnaryCallable<CreateWorkloadRequest, Operation> createWorkloadCallable;
  private final OperationCallable<CreateWorkloadRequest, Workload, OperationMetadata>
      createWorkloadOperationCallable;
  private final UnaryCallable<GetWorkloadRequest, Workload> getWorkloadCallable;
  private final UnaryCallable<UpdateWorkloadRequest, Operation> updateWorkloadCallable;
  private final OperationCallable<UpdateWorkloadRequest, Workload, OperationMetadata>
      updateWorkloadOperationCallable;
  private final UnaryCallable<DeleteWorkloadRequest, Operation> deleteWorkloadCallable;
  private final OperationCallable<DeleteWorkloadRequest, Empty, OperationMetadata>
      deleteWorkloadOperationCallable;
  private final UnaryCallable<ListApplicationsRequest, ListApplicationsResponse>
      listApplicationsCallable;
  private final UnaryCallable<ListApplicationsRequest, ListApplicationsPagedResponse>
      listApplicationsPagedCallable;
  private final UnaryCallable<CreateApplicationRequest, Operation> createApplicationCallable;
  private final OperationCallable<CreateApplicationRequest, Application, OperationMetadata>
      createApplicationOperationCallable;
  private final UnaryCallable<GetApplicationRequest, Application> getApplicationCallable;
  private final UnaryCallable<UpdateApplicationRequest, Operation> updateApplicationCallable;
  private final OperationCallable<UpdateApplicationRequest, Application, OperationMetadata>
      updateApplicationOperationCallable;
  private final UnaryCallable<DeleteApplicationRequest, Operation> deleteApplicationCallable;
  private final OperationCallable<DeleteApplicationRequest, Empty, OperationMetadata>
      deleteApplicationOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAppHubStub create(AppHubStubSettings settings) throws IOException {
    return new GrpcAppHubStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAppHubStub create(ClientContext clientContext) throws IOException {
    return new GrpcAppHubStub(AppHubStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAppHubStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAppHubStub(
        AppHubStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAppHubStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcAppHubStub(AppHubStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAppHubCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAppHubStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcAppHubStub(
      AppHubStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<LookupServiceProjectAttachmentRequest, LookupServiceProjectAttachmentResponse>
        lookupServiceProjectAttachmentTransportSettings =
            GrpcCallSettings
                .<LookupServiceProjectAttachmentRequest, LookupServiceProjectAttachmentResponse>
                    newBuilder()
                .setMethodDescriptor(lookupServiceProjectAttachmentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListServiceProjectAttachmentsRequest, ListServiceProjectAttachmentsResponse>
        listServiceProjectAttachmentsTransportSettings =
            GrpcCallSettings
                .<ListServiceProjectAttachmentsRequest, ListServiceProjectAttachmentsResponse>
                    newBuilder()
                .setMethodDescriptor(listServiceProjectAttachmentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateServiceProjectAttachmentRequest, Operation>
        createServiceProjectAttachmentTransportSettings =
            GrpcCallSettings.<CreateServiceProjectAttachmentRequest, Operation>newBuilder()
                .setMethodDescriptor(createServiceProjectAttachmentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetServiceProjectAttachmentRequest, ServiceProjectAttachment>
        getServiceProjectAttachmentTransportSettings =
            GrpcCallSettings
                .<GetServiceProjectAttachmentRequest, ServiceProjectAttachment>newBuilder()
                .setMethodDescriptor(getServiceProjectAttachmentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteServiceProjectAttachmentRequest, Operation>
        deleteServiceProjectAttachmentTransportSettings =
            GrpcCallSettings.<DeleteServiceProjectAttachmentRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteServiceProjectAttachmentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DetachServiceProjectAttachmentRequest, DetachServiceProjectAttachmentResponse>
        detachServiceProjectAttachmentTransportSettings =
            GrpcCallSettings
                .<DetachServiceProjectAttachmentRequest, DetachServiceProjectAttachmentResponse>
                    newBuilder()
                .setMethodDescriptor(detachServiceProjectAttachmentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListDiscoveredServicesRequest, ListDiscoveredServicesResponse>
        listDiscoveredServicesTransportSettings =
            GrpcCallSettings
                .<ListDiscoveredServicesRequest, ListDiscoveredServicesResponse>newBuilder()
                .setMethodDescriptor(listDiscoveredServicesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDiscoveredServiceRequest, DiscoveredService>
        getDiscoveredServiceTransportSettings =
            GrpcCallSettings.<GetDiscoveredServiceRequest, DiscoveredService>newBuilder()
                .setMethodDescriptor(getDiscoveredServiceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<LookupDiscoveredServiceRequest, LookupDiscoveredServiceResponse>
        lookupDiscoveredServiceTransportSettings =
            GrpcCallSettings
                .<LookupDiscoveredServiceRequest, LookupDiscoveredServiceResponse>newBuilder()
                .setMethodDescriptor(lookupDiscoveredServiceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListServicesRequest, ListServicesResponse> listServicesTransportSettings =
        GrpcCallSettings.<ListServicesRequest, ListServicesResponse>newBuilder()
            .setMethodDescriptor(listServicesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateServiceRequest, Operation> createServiceTransportSettings =
        GrpcCallSettings.<CreateServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(createServiceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetServiceRequest, Service> getServiceTransportSettings =
        GrpcCallSettings.<GetServiceRequest, Service>newBuilder()
            .setMethodDescriptor(getServiceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateServiceRequest, Operation> updateServiceTransportSettings =
        GrpcCallSettings.<UpdateServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateServiceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("service.name", String.valueOf(request.getService().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteServiceRequest, Operation> deleteServiceTransportSettings =
        GrpcCallSettings.<DeleteServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteServiceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDiscoveredWorkloadsRequest, ListDiscoveredWorkloadsResponse>
        listDiscoveredWorkloadsTransportSettings =
            GrpcCallSettings
                .<ListDiscoveredWorkloadsRequest, ListDiscoveredWorkloadsResponse>newBuilder()
                .setMethodDescriptor(listDiscoveredWorkloadsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDiscoveredWorkloadRequest, DiscoveredWorkload>
        getDiscoveredWorkloadTransportSettings =
            GrpcCallSettings.<GetDiscoveredWorkloadRequest, DiscoveredWorkload>newBuilder()
                .setMethodDescriptor(getDiscoveredWorkloadMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<LookupDiscoveredWorkloadRequest, LookupDiscoveredWorkloadResponse>
        lookupDiscoveredWorkloadTransportSettings =
            GrpcCallSettings
                .<LookupDiscoveredWorkloadRequest, LookupDiscoveredWorkloadResponse>newBuilder()
                .setMethodDescriptor(lookupDiscoveredWorkloadMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListWorkloadsRequest, ListWorkloadsResponse> listWorkloadsTransportSettings =
        GrpcCallSettings.<ListWorkloadsRequest, ListWorkloadsResponse>newBuilder()
            .setMethodDescriptor(listWorkloadsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateWorkloadRequest, Operation> createWorkloadTransportSettings =
        GrpcCallSettings.<CreateWorkloadRequest, Operation>newBuilder()
            .setMethodDescriptor(createWorkloadMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetWorkloadRequest, Workload> getWorkloadTransportSettings =
        GrpcCallSettings.<GetWorkloadRequest, Workload>newBuilder()
            .setMethodDescriptor(getWorkloadMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateWorkloadRequest, Operation> updateWorkloadTransportSettings =
        GrpcCallSettings.<UpdateWorkloadRequest, Operation>newBuilder()
            .setMethodDescriptor(updateWorkloadMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("workload.name", String.valueOf(request.getWorkload().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteWorkloadRequest, Operation> deleteWorkloadTransportSettings =
        GrpcCallSettings.<DeleteWorkloadRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteWorkloadMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListApplicationsRequest, ListApplicationsResponse>
        listApplicationsTransportSettings =
            GrpcCallSettings.<ListApplicationsRequest, ListApplicationsResponse>newBuilder()
                .setMethodDescriptor(listApplicationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateApplicationRequest, Operation> createApplicationTransportSettings =
        GrpcCallSettings.<CreateApplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(createApplicationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetApplicationRequest, Application> getApplicationTransportSettings =
        GrpcCallSettings.<GetApplicationRequest, Application>newBuilder()
            .setMethodDescriptor(getApplicationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateApplicationRequest, Operation> updateApplicationTransportSettings =
        GrpcCallSettings.<UpdateApplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(updateApplicationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "application.name", String.valueOf(request.getApplication().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteApplicationRequest, Operation> deleteApplicationTransportSettings =
        GrpcCallSettings.<DeleteApplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteApplicationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.lookupServiceProjectAttachmentCallable =
        callableFactory.createUnaryCallable(
            lookupServiceProjectAttachmentTransportSettings,
            settings.lookupServiceProjectAttachmentSettings(),
            clientContext);
    this.listServiceProjectAttachmentsCallable =
        callableFactory.createUnaryCallable(
            listServiceProjectAttachmentsTransportSettings,
            settings.listServiceProjectAttachmentsSettings(),
            clientContext);
    this.listServiceProjectAttachmentsPagedCallable =
        callableFactory.createPagedCallable(
            listServiceProjectAttachmentsTransportSettings,
            settings.listServiceProjectAttachmentsSettings(),
            clientContext);
    this.createServiceProjectAttachmentCallable =
        callableFactory.createUnaryCallable(
            createServiceProjectAttachmentTransportSettings,
            settings.createServiceProjectAttachmentSettings(),
            clientContext);
    this.createServiceProjectAttachmentOperationCallable =
        callableFactory.createOperationCallable(
            createServiceProjectAttachmentTransportSettings,
            settings.createServiceProjectAttachmentOperationSettings(),
            clientContext,
            operationsStub);
    this.getServiceProjectAttachmentCallable =
        callableFactory.createUnaryCallable(
            getServiceProjectAttachmentTransportSettings,
            settings.getServiceProjectAttachmentSettings(),
            clientContext);
    this.deleteServiceProjectAttachmentCallable =
        callableFactory.createUnaryCallable(
            deleteServiceProjectAttachmentTransportSettings,
            settings.deleteServiceProjectAttachmentSettings(),
            clientContext);
    this.deleteServiceProjectAttachmentOperationCallable =
        callableFactory.createOperationCallable(
            deleteServiceProjectAttachmentTransportSettings,
            settings.deleteServiceProjectAttachmentOperationSettings(),
            clientContext,
            operationsStub);
    this.detachServiceProjectAttachmentCallable =
        callableFactory.createUnaryCallable(
            detachServiceProjectAttachmentTransportSettings,
            settings.detachServiceProjectAttachmentSettings(),
            clientContext);
    this.listDiscoveredServicesCallable =
        callableFactory.createUnaryCallable(
            listDiscoveredServicesTransportSettings,
            settings.listDiscoveredServicesSettings(),
            clientContext);
    this.listDiscoveredServicesPagedCallable =
        callableFactory.createPagedCallable(
            listDiscoveredServicesTransportSettings,
            settings.listDiscoveredServicesSettings(),
            clientContext);
    this.getDiscoveredServiceCallable =
        callableFactory.createUnaryCallable(
            getDiscoveredServiceTransportSettings,
            settings.getDiscoveredServiceSettings(),
            clientContext);
    this.lookupDiscoveredServiceCallable =
        callableFactory.createUnaryCallable(
            lookupDiscoveredServiceTransportSettings,
            settings.lookupDiscoveredServiceSettings(),
            clientContext);
    this.listServicesCallable =
        callableFactory.createUnaryCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.listServicesPagedCallable =
        callableFactory.createPagedCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.createServiceCallable =
        callableFactory.createUnaryCallable(
            createServiceTransportSettings, settings.createServiceSettings(), clientContext);
    this.createServiceOperationCallable =
        callableFactory.createOperationCallable(
            createServiceTransportSettings,
            settings.createServiceOperationSettings(),
            clientContext,
            operationsStub);
    this.getServiceCallable =
        callableFactory.createUnaryCallable(
            getServiceTransportSettings, settings.getServiceSettings(), clientContext);
    this.updateServiceCallable =
        callableFactory.createUnaryCallable(
            updateServiceTransportSettings, settings.updateServiceSettings(), clientContext);
    this.updateServiceOperationCallable =
        callableFactory.createOperationCallable(
            updateServiceTransportSettings,
            settings.updateServiceOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteServiceCallable =
        callableFactory.createUnaryCallable(
            deleteServiceTransportSettings, settings.deleteServiceSettings(), clientContext);
    this.deleteServiceOperationCallable =
        callableFactory.createOperationCallable(
            deleteServiceTransportSettings,
            settings.deleteServiceOperationSettings(),
            clientContext,
            operationsStub);
    this.listDiscoveredWorkloadsCallable =
        callableFactory.createUnaryCallable(
            listDiscoveredWorkloadsTransportSettings,
            settings.listDiscoveredWorkloadsSettings(),
            clientContext);
    this.listDiscoveredWorkloadsPagedCallable =
        callableFactory.createPagedCallable(
            listDiscoveredWorkloadsTransportSettings,
            settings.listDiscoveredWorkloadsSettings(),
            clientContext);
    this.getDiscoveredWorkloadCallable =
        callableFactory.createUnaryCallable(
            getDiscoveredWorkloadTransportSettings,
            settings.getDiscoveredWorkloadSettings(),
            clientContext);
    this.lookupDiscoveredWorkloadCallable =
        callableFactory.createUnaryCallable(
            lookupDiscoveredWorkloadTransportSettings,
            settings.lookupDiscoveredWorkloadSettings(),
            clientContext);
    this.listWorkloadsCallable =
        callableFactory.createUnaryCallable(
            listWorkloadsTransportSettings, settings.listWorkloadsSettings(), clientContext);
    this.listWorkloadsPagedCallable =
        callableFactory.createPagedCallable(
            listWorkloadsTransportSettings, settings.listWorkloadsSettings(), clientContext);
    this.createWorkloadCallable =
        callableFactory.createUnaryCallable(
            createWorkloadTransportSettings, settings.createWorkloadSettings(), clientContext);
    this.createWorkloadOperationCallable =
        callableFactory.createOperationCallable(
            createWorkloadTransportSettings,
            settings.createWorkloadOperationSettings(),
            clientContext,
            operationsStub);
    this.getWorkloadCallable =
        callableFactory.createUnaryCallable(
            getWorkloadTransportSettings, settings.getWorkloadSettings(), clientContext);
    this.updateWorkloadCallable =
        callableFactory.createUnaryCallable(
            updateWorkloadTransportSettings, settings.updateWorkloadSettings(), clientContext);
    this.updateWorkloadOperationCallable =
        callableFactory.createOperationCallable(
            updateWorkloadTransportSettings,
            settings.updateWorkloadOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteWorkloadCallable =
        callableFactory.createUnaryCallable(
            deleteWorkloadTransportSettings, settings.deleteWorkloadSettings(), clientContext);
    this.deleteWorkloadOperationCallable =
        callableFactory.createOperationCallable(
            deleteWorkloadTransportSettings,
            settings.deleteWorkloadOperationSettings(),
            clientContext,
            operationsStub);
    this.listApplicationsCallable =
        callableFactory.createUnaryCallable(
            listApplicationsTransportSettings, settings.listApplicationsSettings(), clientContext);
    this.listApplicationsPagedCallable =
        callableFactory.createPagedCallable(
            listApplicationsTransportSettings, settings.listApplicationsSettings(), clientContext);
    this.createApplicationCallable =
        callableFactory.createUnaryCallable(
            createApplicationTransportSettings,
            settings.createApplicationSettings(),
            clientContext);
    this.createApplicationOperationCallable =
        callableFactory.createOperationCallable(
            createApplicationTransportSettings,
            settings.createApplicationOperationSettings(),
            clientContext,
            operationsStub);
    this.getApplicationCallable =
        callableFactory.createUnaryCallable(
            getApplicationTransportSettings, settings.getApplicationSettings(), clientContext);
    this.updateApplicationCallable =
        callableFactory.createUnaryCallable(
            updateApplicationTransportSettings,
            settings.updateApplicationSettings(),
            clientContext);
    this.updateApplicationOperationCallable =
        callableFactory.createOperationCallable(
            updateApplicationTransportSettings,
            settings.updateApplicationOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteApplicationCallable =
        callableFactory.createUnaryCallable(
            deleteApplicationTransportSettings,
            settings.deleteApplicationSettings(),
            clientContext);
    this.deleteApplicationOperationCallable =
        callableFactory.createOperationCallable(
            deleteApplicationTransportSettings,
            settings.deleteApplicationOperationSettings(),
            clientContext,
            operationsStub);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<
          LookupServiceProjectAttachmentRequest, LookupServiceProjectAttachmentResponse>
      lookupServiceProjectAttachmentCallable() {
    return lookupServiceProjectAttachmentCallable;
  }

  @Override
  public UnaryCallable<ListServiceProjectAttachmentsRequest, ListServiceProjectAttachmentsResponse>
      listServiceProjectAttachmentsCallable() {
    return listServiceProjectAttachmentsCallable;
  }

  @Override
  public UnaryCallable<
          ListServiceProjectAttachmentsRequest, ListServiceProjectAttachmentsPagedResponse>
      listServiceProjectAttachmentsPagedCallable() {
    return listServiceProjectAttachmentsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateServiceProjectAttachmentRequest, Operation>
      createServiceProjectAttachmentCallable() {
    return createServiceProjectAttachmentCallable;
  }

  @Override
  public OperationCallable<
          CreateServiceProjectAttachmentRequest, ServiceProjectAttachment, OperationMetadata>
      createServiceProjectAttachmentOperationCallable() {
    return createServiceProjectAttachmentOperationCallable;
  }

  @Override
  public UnaryCallable<GetServiceProjectAttachmentRequest, ServiceProjectAttachment>
      getServiceProjectAttachmentCallable() {
    return getServiceProjectAttachmentCallable;
  }

  @Override
  public UnaryCallable<DeleteServiceProjectAttachmentRequest, Operation>
      deleteServiceProjectAttachmentCallable() {
    return deleteServiceProjectAttachmentCallable;
  }

  @Override
  public OperationCallable<DeleteServiceProjectAttachmentRequest, Empty, OperationMetadata>
      deleteServiceProjectAttachmentOperationCallable() {
    return deleteServiceProjectAttachmentOperationCallable;
  }

  @Override
  public UnaryCallable<
          DetachServiceProjectAttachmentRequest, DetachServiceProjectAttachmentResponse>
      detachServiceProjectAttachmentCallable() {
    return detachServiceProjectAttachmentCallable;
  }

  @Override
  public UnaryCallable<ListDiscoveredServicesRequest, ListDiscoveredServicesResponse>
      listDiscoveredServicesCallable() {
    return listDiscoveredServicesCallable;
  }

  @Override
  public UnaryCallable<ListDiscoveredServicesRequest, ListDiscoveredServicesPagedResponse>
      listDiscoveredServicesPagedCallable() {
    return listDiscoveredServicesPagedCallable;
  }

  @Override
  public UnaryCallable<GetDiscoveredServiceRequest, DiscoveredService>
      getDiscoveredServiceCallable() {
    return getDiscoveredServiceCallable;
  }

  @Override
  public UnaryCallable<LookupDiscoveredServiceRequest, LookupDiscoveredServiceResponse>
      lookupDiscoveredServiceCallable() {
    return lookupDiscoveredServiceCallable;
  }

  @Override
  public UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable() {
    return listServicesCallable;
  }

  @Override
  public UnaryCallable<ListServicesRequest, ListServicesPagedResponse> listServicesPagedCallable() {
    return listServicesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateServiceRequest, Operation> createServiceCallable() {
    return createServiceCallable;
  }

  @Override
  public OperationCallable<CreateServiceRequest, Service, OperationMetadata>
      createServiceOperationCallable() {
    return createServiceOperationCallable;
  }

  @Override
  public UnaryCallable<GetServiceRequest, Service> getServiceCallable() {
    return getServiceCallable;
  }

  @Override
  public UnaryCallable<UpdateServiceRequest, Operation> updateServiceCallable() {
    return updateServiceCallable;
  }

  @Override
  public OperationCallable<UpdateServiceRequest, Service, OperationMetadata>
      updateServiceOperationCallable() {
    return updateServiceOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteServiceRequest, Operation> deleteServiceCallable() {
    return deleteServiceCallable;
  }

  @Override
  public OperationCallable<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationCallable() {
    return deleteServiceOperationCallable;
  }

  @Override
  public UnaryCallable<ListDiscoveredWorkloadsRequest, ListDiscoveredWorkloadsResponse>
      listDiscoveredWorkloadsCallable() {
    return listDiscoveredWorkloadsCallable;
  }

  @Override
  public UnaryCallable<ListDiscoveredWorkloadsRequest, ListDiscoveredWorkloadsPagedResponse>
      listDiscoveredWorkloadsPagedCallable() {
    return listDiscoveredWorkloadsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDiscoveredWorkloadRequest, DiscoveredWorkload>
      getDiscoveredWorkloadCallable() {
    return getDiscoveredWorkloadCallable;
  }

  @Override
  public UnaryCallable<LookupDiscoveredWorkloadRequest, LookupDiscoveredWorkloadResponse>
      lookupDiscoveredWorkloadCallable() {
    return lookupDiscoveredWorkloadCallable;
  }

  @Override
  public UnaryCallable<ListWorkloadsRequest, ListWorkloadsResponse> listWorkloadsCallable() {
    return listWorkloadsCallable;
  }

  @Override
  public UnaryCallable<ListWorkloadsRequest, ListWorkloadsPagedResponse>
      listWorkloadsPagedCallable() {
    return listWorkloadsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateWorkloadRequest, Operation> createWorkloadCallable() {
    return createWorkloadCallable;
  }

  @Override
  public OperationCallable<CreateWorkloadRequest, Workload, OperationMetadata>
      createWorkloadOperationCallable() {
    return createWorkloadOperationCallable;
  }

  @Override
  public UnaryCallable<GetWorkloadRequest, Workload> getWorkloadCallable() {
    return getWorkloadCallable;
  }

  @Override
  public UnaryCallable<UpdateWorkloadRequest, Operation> updateWorkloadCallable() {
    return updateWorkloadCallable;
  }

  @Override
  public OperationCallable<UpdateWorkloadRequest, Workload, OperationMetadata>
      updateWorkloadOperationCallable() {
    return updateWorkloadOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteWorkloadRequest, Operation> deleteWorkloadCallable() {
    return deleteWorkloadCallable;
  }

  @Override
  public OperationCallable<DeleteWorkloadRequest, Empty, OperationMetadata>
      deleteWorkloadOperationCallable() {
    return deleteWorkloadOperationCallable;
  }

  @Override
  public UnaryCallable<ListApplicationsRequest, ListApplicationsResponse>
      listApplicationsCallable() {
    return listApplicationsCallable;
  }

  @Override
  public UnaryCallable<ListApplicationsRequest, ListApplicationsPagedResponse>
      listApplicationsPagedCallable() {
    return listApplicationsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateApplicationRequest, Operation> createApplicationCallable() {
    return createApplicationCallable;
  }

  @Override
  public OperationCallable<CreateApplicationRequest, Application, OperationMetadata>
      createApplicationOperationCallable() {
    return createApplicationOperationCallable;
  }

  @Override
  public UnaryCallable<GetApplicationRequest, Application> getApplicationCallable() {
    return getApplicationCallable;
  }

  @Override
  public UnaryCallable<UpdateApplicationRequest, Operation> updateApplicationCallable() {
    return updateApplicationCallable;
  }

  @Override
  public OperationCallable<UpdateApplicationRequest, Application, OperationMetadata>
      updateApplicationOperationCallable() {
    return updateApplicationOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteApplicationRequest, Operation> deleteApplicationCallable() {
    return deleteApplicationCallable;
  }

  @Override
  public OperationCallable<DeleteApplicationRequest, Empty, OperationMetadata>
      deleteApplicationOperationCallable() {
    return deleteApplicationOperationCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
