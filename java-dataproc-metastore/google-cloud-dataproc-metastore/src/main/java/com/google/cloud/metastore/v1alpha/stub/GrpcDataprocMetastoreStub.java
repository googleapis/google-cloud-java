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

package com.google.cloud.metastore.v1alpha.stub;

import static com.google.cloud.metastore.v1alpha.DataprocMetastoreClient.ListBackupsPagedResponse;
import static com.google.cloud.metastore.v1alpha.DataprocMetastoreClient.ListLocationsPagedResponse;
import static com.google.cloud.metastore.v1alpha.DataprocMetastoreClient.ListMetadataImportsPagedResponse;
import static com.google.cloud.metastore.v1alpha.DataprocMetastoreClient.ListServicesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.metastore.v1alpha.AlterMetadataResourceLocationRequest;
import com.google.cloud.metastore.v1alpha.AlterMetadataResourceLocationResponse;
import com.google.cloud.metastore.v1alpha.Backup;
import com.google.cloud.metastore.v1alpha.CreateBackupRequest;
import com.google.cloud.metastore.v1alpha.CreateMetadataImportRequest;
import com.google.cloud.metastore.v1alpha.CreateServiceRequest;
import com.google.cloud.metastore.v1alpha.DeleteBackupRequest;
import com.google.cloud.metastore.v1alpha.DeleteServiceRequest;
import com.google.cloud.metastore.v1alpha.ExportMetadataRequest;
import com.google.cloud.metastore.v1alpha.GetBackupRequest;
import com.google.cloud.metastore.v1alpha.GetMetadataImportRequest;
import com.google.cloud.metastore.v1alpha.GetServiceRequest;
import com.google.cloud.metastore.v1alpha.ListBackupsRequest;
import com.google.cloud.metastore.v1alpha.ListBackupsResponse;
import com.google.cloud.metastore.v1alpha.ListMetadataImportsRequest;
import com.google.cloud.metastore.v1alpha.ListMetadataImportsResponse;
import com.google.cloud.metastore.v1alpha.ListServicesRequest;
import com.google.cloud.metastore.v1alpha.ListServicesResponse;
import com.google.cloud.metastore.v1alpha.MetadataExport;
import com.google.cloud.metastore.v1alpha.MetadataImport;
import com.google.cloud.metastore.v1alpha.MoveTableToDatabaseRequest;
import com.google.cloud.metastore.v1alpha.MoveTableToDatabaseResponse;
import com.google.cloud.metastore.v1alpha.OperationMetadata;
import com.google.cloud.metastore.v1alpha.QueryMetadataRequest;
import com.google.cloud.metastore.v1alpha.QueryMetadataResponse;
import com.google.cloud.metastore.v1alpha.RemoveIamPolicyRequest;
import com.google.cloud.metastore.v1alpha.RemoveIamPolicyResponse;
import com.google.cloud.metastore.v1alpha.Restore;
import com.google.cloud.metastore.v1alpha.RestoreServiceRequest;
import com.google.cloud.metastore.v1alpha.Service;
import com.google.cloud.metastore.v1alpha.UpdateMetadataImportRequest;
import com.google.cloud.metastore.v1alpha.UpdateServiceRequest;
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
 * gRPC stub implementation for the DataprocMetastore service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcDataprocMetastoreStub extends DataprocMetastoreStub {
  private static final MethodDescriptor<ListServicesRequest, ListServicesResponse>
      listServicesMethodDescriptor =
          MethodDescriptor.<ListServicesRequest, ListServicesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.metastore.v1alpha.DataprocMetastore/ListServices")
              .setRequestMarshaller(ProtoUtils.marshaller(ListServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServicesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetServiceRequest, Service> getServiceMethodDescriptor =
      MethodDescriptor.<GetServiceRequest, Service>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.metastore.v1alpha.DataprocMetastore/GetService")
          .setRequestMarshaller(ProtoUtils.marshaller(GetServiceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Service.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateServiceRequest, Operation>
      createServiceMethodDescriptor =
          MethodDescriptor.<CreateServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.metastore.v1alpha.DataprocMetastore/CreateService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateServiceRequest, Operation>
      updateServiceMethodDescriptor =
          MethodDescriptor.<UpdateServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.metastore.v1alpha.DataprocMetastore/UpdateService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteServiceRequest, Operation>
      deleteServiceMethodDescriptor =
          MethodDescriptor.<DeleteServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.metastore.v1alpha.DataprocMetastore/DeleteService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListMetadataImportsRequest, ListMetadataImportsResponse>
      listMetadataImportsMethodDescriptor =
          MethodDescriptor.<ListMetadataImportsRequest, ListMetadataImportsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.metastore.v1alpha.DataprocMetastore/ListMetadataImports")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMetadataImportsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMetadataImportsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetMetadataImportRequest, MetadataImport>
      getMetadataImportMethodDescriptor =
          MethodDescriptor.<GetMetadataImportRequest, MetadataImport>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.metastore.v1alpha.DataprocMetastore/GetMetadataImport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMetadataImportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MetadataImport.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateMetadataImportRequest, Operation>
      createMetadataImportMethodDescriptor =
          MethodDescriptor.<CreateMetadataImportRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.metastore.v1alpha.DataprocMetastore/CreateMetadataImport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateMetadataImportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateMetadataImportRequest, Operation>
      updateMetadataImportMethodDescriptor =
          MethodDescriptor.<UpdateMetadataImportRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.metastore.v1alpha.DataprocMetastore/UpdateMetadataImport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateMetadataImportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ExportMetadataRequest, Operation>
      exportMetadataMethodDescriptor =
          MethodDescriptor.<ExportMetadataRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.metastore.v1alpha.DataprocMetastore/ExportMetadata")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportMetadataRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RestoreServiceRequest, Operation>
      restoreServiceMethodDescriptor =
          MethodDescriptor.<RestoreServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.metastore.v1alpha.DataprocMetastore/RestoreService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RestoreServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListBackupsRequest, ListBackupsResponse>
      listBackupsMethodDescriptor =
          MethodDescriptor.<ListBackupsRequest, ListBackupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.metastore.v1alpha.DataprocMetastore/ListBackups")
              .setRequestMarshaller(ProtoUtils.marshaller(ListBackupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBackupsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetBackupRequest, Backup> getBackupMethodDescriptor =
      MethodDescriptor.<GetBackupRequest, Backup>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.metastore.v1alpha.DataprocMetastore/GetBackup")
          .setRequestMarshaller(ProtoUtils.marshaller(GetBackupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Backup.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateBackupRequest, Operation>
      createBackupMethodDescriptor =
          MethodDescriptor.<CreateBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.metastore.v1alpha.DataprocMetastore/CreateBackup")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteBackupRequest, Operation>
      deleteBackupMethodDescriptor =
          MethodDescriptor.<DeleteBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.metastore.v1alpha.DataprocMetastore/DeleteBackup")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RemoveIamPolicyRequest, RemoveIamPolicyResponse>
      removeIamPolicyMethodDescriptor =
          MethodDescriptor.<RemoveIamPolicyRequest, RemoveIamPolicyResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.metastore.v1alpha.DataprocMetastore/RemoveIamPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RemoveIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RemoveIamPolicyResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<QueryMetadataRequest, Operation>
      queryMetadataMethodDescriptor =
          MethodDescriptor.<QueryMetadataRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.metastore.v1alpha.DataprocMetastore/QueryMetadata")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(QueryMetadataRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<MoveTableToDatabaseRequest, Operation>
      moveTableToDatabaseMethodDescriptor =
          MethodDescriptor.<MoveTableToDatabaseRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.metastore.v1alpha.DataprocMetastore/MoveTableToDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(MoveTableToDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<AlterMetadataResourceLocationRequest, Operation>
      alterMetadataResourceLocationMethodDescriptor =
          MethodDescriptor.<AlterMetadataResourceLocationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.metastore.v1alpha.DataprocMetastore/AlterMetadataResourceLocation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AlterMetadataResourceLocationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable;
  private final UnaryCallable<ListServicesRequest, ListServicesPagedResponse>
      listServicesPagedCallable;
  private final UnaryCallable<GetServiceRequest, Service> getServiceCallable;
  private final UnaryCallable<CreateServiceRequest, Operation> createServiceCallable;
  private final OperationCallable<CreateServiceRequest, Service, OperationMetadata>
      createServiceOperationCallable;
  private final UnaryCallable<UpdateServiceRequest, Operation> updateServiceCallable;
  private final OperationCallable<UpdateServiceRequest, Service, OperationMetadata>
      updateServiceOperationCallable;
  private final UnaryCallable<DeleteServiceRequest, Operation> deleteServiceCallable;
  private final OperationCallable<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationCallable;
  private final UnaryCallable<ListMetadataImportsRequest, ListMetadataImportsResponse>
      listMetadataImportsCallable;
  private final UnaryCallable<ListMetadataImportsRequest, ListMetadataImportsPagedResponse>
      listMetadataImportsPagedCallable;
  private final UnaryCallable<GetMetadataImportRequest, MetadataImport> getMetadataImportCallable;
  private final UnaryCallable<CreateMetadataImportRequest, Operation> createMetadataImportCallable;
  private final OperationCallable<CreateMetadataImportRequest, MetadataImport, OperationMetadata>
      createMetadataImportOperationCallable;
  private final UnaryCallable<UpdateMetadataImportRequest, Operation> updateMetadataImportCallable;
  private final OperationCallable<UpdateMetadataImportRequest, MetadataImport, OperationMetadata>
      updateMetadataImportOperationCallable;
  private final UnaryCallable<ExportMetadataRequest, Operation> exportMetadataCallable;
  private final OperationCallable<ExportMetadataRequest, MetadataExport, OperationMetadata>
      exportMetadataOperationCallable;
  private final UnaryCallable<RestoreServiceRequest, Operation> restoreServiceCallable;
  private final OperationCallable<RestoreServiceRequest, Restore, OperationMetadata>
      restoreServiceOperationCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse>
      listBackupsPagedCallable;
  private final UnaryCallable<GetBackupRequest, Backup> getBackupCallable;
  private final UnaryCallable<CreateBackupRequest, Operation> createBackupCallable;
  private final OperationCallable<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationCallable;
  private final UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable;
  private final OperationCallable<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationCallable;
  private final UnaryCallable<RemoveIamPolicyRequest, RemoveIamPolicyResponse>
      removeIamPolicyCallable;
  private final UnaryCallable<QueryMetadataRequest, Operation> queryMetadataCallable;
  private final OperationCallable<QueryMetadataRequest, QueryMetadataResponse, OperationMetadata>
      queryMetadataOperationCallable;
  private final UnaryCallable<MoveTableToDatabaseRequest, Operation> moveTableToDatabaseCallable;
  private final OperationCallable<
          MoveTableToDatabaseRequest, MoveTableToDatabaseResponse, OperationMetadata>
      moveTableToDatabaseOperationCallable;
  private final UnaryCallable<AlterMetadataResourceLocationRequest, Operation>
      alterMetadataResourceLocationCallable;
  private final OperationCallable<
          AlterMetadataResourceLocationRequest,
          AlterMetadataResourceLocationResponse,
          OperationMetadata>
      alterMetadataResourceLocationOperationCallable;
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

  public static final GrpcDataprocMetastoreStub create(DataprocMetastoreStubSettings settings)
      throws IOException {
    return new GrpcDataprocMetastoreStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataprocMetastoreStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDataprocMetastoreStub(
        DataprocMetastoreStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataprocMetastoreStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataprocMetastoreStub(
        DataprocMetastoreStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataprocMetastoreStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataprocMetastoreStub(
      DataprocMetastoreStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDataprocMetastoreCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataprocMetastoreStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataprocMetastoreStub(
      DataprocMetastoreStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

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
    GrpcCallSettings<ListMetadataImportsRequest, ListMetadataImportsResponse>
        listMetadataImportsTransportSettings =
            GrpcCallSettings.<ListMetadataImportsRequest, ListMetadataImportsResponse>newBuilder()
                .setMethodDescriptor(listMetadataImportsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetMetadataImportRequest, MetadataImport> getMetadataImportTransportSettings =
        GrpcCallSettings.<GetMetadataImportRequest, MetadataImport>newBuilder()
            .setMethodDescriptor(getMetadataImportMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateMetadataImportRequest, Operation> createMetadataImportTransportSettings =
        GrpcCallSettings.<CreateMetadataImportRequest, Operation>newBuilder()
            .setMethodDescriptor(createMetadataImportMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateMetadataImportRequest, Operation> updateMetadataImportTransportSettings =
        GrpcCallSettings.<UpdateMetadataImportRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMetadataImportMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "metadata_import.name",
                      String.valueOf(request.getMetadataImport().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ExportMetadataRequest, Operation> exportMetadataTransportSettings =
        GrpcCallSettings.<ExportMetadataRequest, Operation>newBuilder()
            .setMethodDescriptor(exportMetadataMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("service", String.valueOf(request.getService()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RestoreServiceRequest, Operation> restoreServiceTransportSettings =
        GrpcCallSettings.<RestoreServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(restoreServiceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("service", String.valueOf(request.getService()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListBackupsRequest, ListBackupsResponse> listBackupsTransportSettings =
        GrpcCallSettings.<ListBackupsRequest, ListBackupsResponse>newBuilder()
            .setMethodDescriptor(listBackupsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetBackupRequest, Backup> getBackupTransportSettings =
        GrpcCallSettings.<GetBackupRequest, Backup>newBuilder()
            .setMethodDescriptor(getBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateBackupRequest, Operation> createBackupTransportSettings =
        GrpcCallSettings.<CreateBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(createBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteBackupRequest, Operation> deleteBackupTransportSettings =
        GrpcCallSettings.<DeleteBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RemoveIamPolicyRequest, RemoveIamPolicyResponse>
        removeIamPolicyTransportSettings =
            GrpcCallSettings.<RemoveIamPolicyRequest, RemoveIamPolicyResponse>newBuilder()
                .setMethodDescriptor(removeIamPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<QueryMetadataRequest, Operation> queryMetadataTransportSettings =
        GrpcCallSettings.<QueryMetadataRequest, Operation>newBuilder()
            .setMethodDescriptor(queryMetadataMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("service", String.valueOf(request.getService()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<MoveTableToDatabaseRequest, Operation> moveTableToDatabaseTransportSettings =
        GrpcCallSettings.<MoveTableToDatabaseRequest, Operation>newBuilder()
            .setMethodDescriptor(moveTableToDatabaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("service", String.valueOf(request.getService()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<AlterMetadataResourceLocationRequest, Operation>
        alterMetadataResourceLocationTransportSettings =
            GrpcCallSettings.<AlterMetadataResourceLocationRequest, Operation>newBuilder()
                .setMethodDescriptor(alterMetadataResourceLocationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("service", String.valueOf(request.getService()));
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

    this.listServicesCallable =
        callableFactory.createUnaryCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.listServicesPagedCallable =
        callableFactory.createPagedCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.getServiceCallable =
        callableFactory.createUnaryCallable(
            getServiceTransportSettings, settings.getServiceSettings(), clientContext);
    this.createServiceCallable =
        callableFactory.createUnaryCallable(
            createServiceTransportSettings, settings.createServiceSettings(), clientContext);
    this.createServiceOperationCallable =
        callableFactory.createOperationCallable(
            createServiceTransportSettings,
            settings.createServiceOperationSettings(),
            clientContext,
            operationsStub);
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
    this.listMetadataImportsCallable =
        callableFactory.createUnaryCallable(
            listMetadataImportsTransportSettings,
            settings.listMetadataImportsSettings(),
            clientContext);
    this.listMetadataImportsPagedCallable =
        callableFactory.createPagedCallable(
            listMetadataImportsTransportSettings,
            settings.listMetadataImportsSettings(),
            clientContext);
    this.getMetadataImportCallable =
        callableFactory.createUnaryCallable(
            getMetadataImportTransportSettings,
            settings.getMetadataImportSettings(),
            clientContext);
    this.createMetadataImportCallable =
        callableFactory.createUnaryCallable(
            createMetadataImportTransportSettings,
            settings.createMetadataImportSettings(),
            clientContext);
    this.createMetadataImportOperationCallable =
        callableFactory.createOperationCallable(
            createMetadataImportTransportSettings,
            settings.createMetadataImportOperationSettings(),
            clientContext,
            operationsStub);
    this.updateMetadataImportCallable =
        callableFactory.createUnaryCallable(
            updateMetadataImportTransportSettings,
            settings.updateMetadataImportSettings(),
            clientContext);
    this.updateMetadataImportOperationCallable =
        callableFactory.createOperationCallable(
            updateMetadataImportTransportSettings,
            settings.updateMetadataImportOperationSettings(),
            clientContext,
            operationsStub);
    this.exportMetadataCallable =
        callableFactory.createUnaryCallable(
            exportMetadataTransportSettings, settings.exportMetadataSettings(), clientContext);
    this.exportMetadataOperationCallable =
        callableFactory.createOperationCallable(
            exportMetadataTransportSettings,
            settings.exportMetadataOperationSettings(),
            clientContext,
            operationsStub);
    this.restoreServiceCallable =
        callableFactory.createUnaryCallable(
            restoreServiceTransportSettings, settings.restoreServiceSettings(), clientContext);
    this.restoreServiceOperationCallable =
        callableFactory.createOperationCallable(
            restoreServiceTransportSettings,
            settings.restoreServiceOperationSettings(),
            clientContext,
            operationsStub);
    this.listBackupsCallable =
        callableFactory.createUnaryCallable(
            listBackupsTransportSettings, settings.listBackupsSettings(), clientContext);
    this.listBackupsPagedCallable =
        callableFactory.createPagedCallable(
            listBackupsTransportSettings, settings.listBackupsSettings(), clientContext);
    this.getBackupCallable =
        callableFactory.createUnaryCallable(
            getBackupTransportSettings, settings.getBackupSettings(), clientContext);
    this.createBackupCallable =
        callableFactory.createUnaryCallable(
            createBackupTransportSettings, settings.createBackupSettings(), clientContext);
    this.createBackupOperationCallable =
        callableFactory.createOperationCallable(
            createBackupTransportSettings,
            settings.createBackupOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteBackupCallable =
        callableFactory.createUnaryCallable(
            deleteBackupTransportSettings, settings.deleteBackupSettings(), clientContext);
    this.deleteBackupOperationCallable =
        callableFactory.createOperationCallable(
            deleteBackupTransportSettings,
            settings.deleteBackupOperationSettings(),
            clientContext,
            operationsStub);
    this.removeIamPolicyCallable =
        callableFactory.createUnaryCallable(
            removeIamPolicyTransportSettings, settings.removeIamPolicySettings(), clientContext);
    this.queryMetadataCallable =
        callableFactory.createUnaryCallable(
            queryMetadataTransportSettings, settings.queryMetadataSettings(), clientContext);
    this.queryMetadataOperationCallable =
        callableFactory.createOperationCallable(
            queryMetadataTransportSettings,
            settings.queryMetadataOperationSettings(),
            clientContext,
            operationsStub);
    this.moveTableToDatabaseCallable =
        callableFactory.createUnaryCallable(
            moveTableToDatabaseTransportSettings,
            settings.moveTableToDatabaseSettings(),
            clientContext);
    this.moveTableToDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            moveTableToDatabaseTransportSettings,
            settings.moveTableToDatabaseOperationSettings(),
            clientContext,
            operationsStub);
    this.alterMetadataResourceLocationCallable =
        callableFactory.createUnaryCallable(
            alterMetadataResourceLocationTransportSettings,
            settings.alterMetadataResourceLocationSettings(),
            clientContext);
    this.alterMetadataResourceLocationOperationCallable =
        callableFactory.createOperationCallable(
            alterMetadataResourceLocationTransportSettings,
            settings.alterMetadataResourceLocationOperationSettings(),
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
  public UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable() {
    return listServicesCallable;
  }

  @Override
  public UnaryCallable<ListServicesRequest, ListServicesPagedResponse> listServicesPagedCallable() {
    return listServicesPagedCallable;
  }

  @Override
  public UnaryCallable<GetServiceRequest, Service> getServiceCallable() {
    return getServiceCallable;
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
  public UnaryCallable<ListMetadataImportsRequest, ListMetadataImportsResponse>
      listMetadataImportsCallable() {
    return listMetadataImportsCallable;
  }

  @Override
  public UnaryCallable<ListMetadataImportsRequest, ListMetadataImportsPagedResponse>
      listMetadataImportsPagedCallable() {
    return listMetadataImportsPagedCallable;
  }

  @Override
  public UnaryCallable<GetMetadataImportRequest, MetadataImport> getMetadataImportCallable() {
    return getMetadataImportCallable;
  }

  @Override
  public UnaryCallable<CreateMetadataImportRequest, Operation> createMetadataImportCallable() {
    return createMetadataImportCallable;
  }

  @Override
  public OperationCallable<CreateMetadataImportRequest, MetadataImport, OperationMetadata>
      createMetadataImportOperationCallable() {
    return createMetadataImportOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateMetadataImportRequest, Operation> updateMetadataImportCallable() {
    return updateMetadataImportCallable;
  }

  @Override
  public OperationCallable<UpdateMetadataImportRequest, MetadataImport, OperationMetadata>
      updateMetadataImportOperationCallable() {
    return updateMetadataImportOperationCallable;
  }

  @Override
  public UnaryCallable<ExportMetadataRequest, Operation> exportMetadataCallable() {
    return exportMetadataCallable;
  }

  @Override
  public OperationCallable<ExportMetadataRequest, MetadataExport, OperationMetadata>
      exportMetadataOperationCallable() {
    return exportMetadataOperationCallable;
  }

  @Override
  public UnaryCallable<RestoreServiceRequest, Operation> restoreServiceCallable() {
    return restoreServiceCallable;
  }

  @Override
  public OperationCallable<RestoreServiceRequest, Restore, OperationMetadata>
      restoreServiceOperationCallable() {
    return restoreServiceOperationCallable;
  }

  @Override
  public UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable() {
    return listBackupsCallable;
  }

  @Override
  public UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse> listBackupsPagedCallable() {
    return listBackupsPagedCallable;
  }

  @Override
  public UnaryCallable<GetBackupRequest, Backup> getBackupCallable() {
    return getBackupCallable;
  }

  @Override
  public UnaryCallable<CreateBackupRequest, Operation> createBackupCallable() {
    return createBackupCallable;
  }

  @Override
  public OperationCallable<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationCallable() {
    return createBackupOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable() {
    return deleteBackupCallable;
  }

  @Override
  public OperationCallable<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationCallable() {
    return deleteBackupOperationCallable;
  }

  @Override
  public UnaryCallable<RemoveIamPolicyRequest, RemoveIamPolicyResponse> removeIamPolicyCallable() {
    return removeIamPolicyCallable;
  }

  @Override
  public UnaryCallable<QueryMetadataRequest, Operation> queryMetadataCallable() {
    return queryMetadataCallable;
  }

  @Override
  public OperationCallable<QueryMetadataRequest, QueryMetadataResponse, OperationMetadata>
      queryMetadataOperationCallable() {
    return queryMetadataOperationCallable;
  }

  @Override
  public UnaryCallable<MoveTableToDatabaseRequest, Operation> moveTableToDatabaseCallable() {
    return moveTableToDatabaseCallable;
  }

  @Override
  public OperationCallable<
          MoveTableToDatabaseRequest, MoveTableToDatabaseResponse, OperationMetadata>
      moveTableToDatabaseOperationCallable() {
    return moveTableToDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<AlterMetadataResourceLocationRequest, Operation>
      alterMetadataResourceLocationCallable() {
    return alterMetadataResourceLocationCallable;
  }

  @Override
  public OperationCallable<
          AlterMetadataResourceLocationRequest,
          AlterMetadataResourceLocationResponse,
          OperationMetadata>
      alterMetadataResourceLocationOperationCallable() {
    return alterMetadataResourceLocationOperationCallable;
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
