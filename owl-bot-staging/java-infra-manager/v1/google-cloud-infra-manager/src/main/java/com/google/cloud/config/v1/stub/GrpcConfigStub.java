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

package com.google.cloud.config.v1.stub;

import static com.google.cloud.config.v1.ConfigClient.ListDeploymentsPagedResponse;
import static com.google.cloud.config.v1.ConfigClient.ListLocationsPagedResponse;
import static com.google.cloud.config.v1.ConfigClient.ListPreviewsPagedResponse;
import static com.google.cloud.config.v1.ConfigClient.ListResourcesPagedResponse;
import static com.google.cloud.config.v1.ConfigClient.ListRevisionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.config.v1.CreateDeploymentRequest;
import com.google.cloud.config.v1.CreatePreviewRequest;
import com.google.cloud.config.v1.DeleteDeploymentRequest;
import com.google.cloud.config.v1.DeletePreviewRequest;
import com.google.cloud.config.v1.DeleteStatefileRequest;
import com.google.cloud.config.v1.Deployment;
import com.google.cloud.config.v1.ExportDeploymentStatefileRequest;
import com.google.cloud.config.v1.ExportLockInfoRequest;
import com.google.cloud.config.v1.ExportPreviewResultRequest;
import com.google.cloud.config.v1.ExportPreviewResultResponse;
import com.google.cloud.config.v1.ExportRevisionStatefileRequest;
import com.google.cloud.config.v1.GetDeploymentRequest;
import com.google.cloud.config.v1.GetPreviewRequest;
import com.google.cloud.config.v1.GetResourceRequest;
import com.google.cloud.config.v1.GetRevisionRequest;
import com.google.cloud.config.v1.ImportStatefileRequest;
import com.google.cloud.config.v1.ListDeploymentsRequest;
import com.google.cloud.config.v1.ListDeploymentsResponse;
import com.google.cloud.config.v1.ListPreviewsRequest;
import com.google.cloud.config.v1.ListPreviewsResponse;
import com.google.cloud.config.v1.ListResourcesRequest;
import com.google.cloud.config.v1.ListResourcesResponse;
import com.google.cloud.config.v1.ListRevisionsRequest;
import com.google.cloud.config.v1.ListRevisionsResponse;
import com.google.cloud.config.v1.LockDeploymentRequest;
import com.google.cloud.config.v1.LockInfo;
import com.google.cloud.config.v1.OperationMetadata;
import com.google.cloud.config.v1.Preview;
import com.google.cloud.config.v1.Resource;
import com.google.cloud.config.v1.Revision;
import com.google.cloud.config.v1.Statefile;
import com.google.cloud.config.v1.UnlockDeploymentRequest;
import com.google.cloud.config.v1.UpdateDeploymentRequest;
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
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Config service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcConfigStub extends ConfigStub {
  private static final MethodDescriptor<ListDeploymentsRequest, ListDeploymentsResponse>
      listDeploymentsMethodDescriptor =
          MethodDescriptor.<ListDeploymentsRequest, ListDeploymentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.config.v1.Config/ListDeployments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDeploymentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDeploymentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDeploymentRequest, Deployment>
      getDeploymentMethodDescriptor =
          MethodDescriptor.<GetDeploymentRequest, Deployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.config.v1.Config/GetDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Deployment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateDeploymentRequest, Operation>
      createDeploymentMethodDescriptor =
          MethodDescriptor.<CreateDeploymentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.config.v1.Config/CreateDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDeploymentRequest, Operation>
      updateDeploymentMethodDescriptor =
          MethodDescriptor.<UpdateDeploymentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.config.v1.Config/UpdateDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDeploymentRequest, Operation>
      deleteDeploymentMethodDescriptor =
          MethodDescriptor.<DeleteDeploymentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.config.v1.Config/DeleteDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListRevisionsRequest, ListRevisionsResponse>
      listRevisionsMethodDescriptor =
          MethodDescriptor.<ListRevisionsRequest, ListRevisionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.config.v1.Config/ListRevisions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRevisionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRevisionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRevisionRequest, Revision> getRevisionMethodDescriptor =
      MethodDescriptor.<GetRevisionRequest, Revision>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.config.v1.Config/GetRevision")
          .setRequestMarshaller(ProtoUtils.marshaller(GetRevisionRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Revision.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetResourceRequest, Resource> getResourceMethodDescriptor =
      MethodDescriptor.<GetResourceRequest, Resource>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.config.v1.Config/GetResource")
          .setRequestMarshaller(ProtoUtils.marshaller(GetResourceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Resource.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListResourcesRequest, ListResourcesResponse>
      listResourcesMethodDescriptor =
          MethodDescriptor.<ListResourcesRequest, ListResourcesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.config.v1.Config/ListResources")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListResourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListResourcesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ExportDeploymentStatefileRequest, Statefile>
      exportDeploymentStatefileMethodDescriptor =
          MethodDescriptor.<ExportDeploymentStatefileRequest, Statefile>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.config.v1.Config/ExportDeploymentStatefile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportDeploymentStatefileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Statefile.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ExportRevisionStatefileRequest, Statefile>
      exportRevisionStatefileMethodDescriptor =
          MethodDescriptor.<ExportRevisionStatefileRequest, Statefile>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.config.v1.Config/ExportRevisionStatefile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportRevisionStatefileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Statefile.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ImportStatefileRequest, Statefile>
      importStatefileMethodDescriptor =
          MethodDescriptor.<ImportStatefileRequest, Statefile>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.config.v1.Config/ImportStatefile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportStatefileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Statefile.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteStatefileRequest, Empty>
      deleteStatefileMethodDescriptor =
          MethodDescriptor.<DeleteStatefileRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.config.v1.Config/DeleteStatefile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteStatefileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<LockDeploymentRequest, Operation>
      lockDeploymentMethodDescriptor =
          MethodDescriptor.<LockDeploymentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.config.v1.Config/LockDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(LockDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UnlockDeploymentRequest, Operation>
      unlockDeploymentMethodDescriptor =
          MethodDescriptor.<UnlockDeploymentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.config.v1.Config/UnlockDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UnlockDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ExportLockInfoRequest, LockInfo>
      exportLockInfoMethodDescriptor =
          MethodDescriptor.<ExportLockInfoRequest, LockInfo>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.config.v1.Config/ExportLockInfo")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportLockInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LockInfo.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreatePreviewRequest, Operation>
      createPreviewMethodDescriptor =
          MethodDescriptor.<CreatePreviewRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.config.v1.Config/CreatePreview")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePreviewRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPreviewRequest, Preview> getPreviewMethodDescriptor =
      MethodDescriptor.<GetPreviewRequest, Preview>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.config.v1.Config/GetPreview")
          .setRequestMarshaller(ProtoUtils.marshaller(GetPreviewRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Preview.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListPreviewsRequest, ListPreviewsResponse>
      listPreviewsMethodDescriptor =
          MethodDescriptor.<ListPreviewsRequest, ListPreviewsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.config.v1.Config/ListPreviews")
              .setRequestMarshaller(ProtoUtils.marshaller(ListPreviewsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPreviewsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeletePreviewRequest, Operation>
      deletePreviewMethodDescriptor =
          MethodDescriptor.<DeletePreviewRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.config.v1.Config/DeletePreview")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePreviewRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ExportPreviewResultRequest, ExportPreviewResultResponse>
      exportPreviewResultMethodDescriptor =
          MethodDescriptor.<ExportPreviewResultRequest, ExportPreviewResultResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.config.v1.Config/ExportPreviewResult")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportPreviewResultRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ExportPreviewResultResponse.getDefaultInstance()))
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

  private final UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse>
      listDeploymentsCallable;
  private final UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable;
  private final UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable;
  private final UnaryCallable<CreateDeploymentRequest, Operation> createDeploymentCallable;
  private final OperationCallable<CreateDeploymentRequest, Deployment, OperationMetadata>
      createDeploymentOperationCallable;
  private final UnaryCallable<UpdateDeploymentRequest, Operation> updateDeploymentCallable;
  private final OperationCallable<UpdateDeploymentRequest, Deployment, OperationMetadata>
      updateDeploymentOperationCallable;
  private final UnaryCallable<DeleteDeploymentRequest, Operation> deleteDeploymentCallable;
  private final OperationCallable<DeleteDeploymentRequest, Deployment, OperationMetadata>
      deleteDeploymentOperationCallable;
  private final UnaryCallable<ListRevisionsRequest, ListRevisionsResponse> listRevisionsCallable;
  private final UnaryCallable<ListRevisionsRequest, ListRevisionsPagedResponse>
      listRevisionsPagedCallable;
  private final UnaryCallable<GetRevisionRequest, Revision> getRevisionCallable;
  private final UnaryCallable<GetResourceRequest, Resource> getResourceCallable;
  private final UnaryCallable<ListResourcesRequest, ListResourcesResponse> listResourcesCallable;
  private final UnaryCallable<ListResourcesRequest, ListResourcesPagedResponse>
      listResourcesPagedCallable;
  private final UnaryCallable<ExportDeploymentStatefileRequest, Statefile>
      exportDeploymentStatefileCallable;
  private final UnaryCallable<ExportRevisionStatefileRequest, Statefile>
      exportRevisionStatefileCallable;
  private final UnaryCallable<ImportStatefileRequest, Statefile> importStatefileCallable;
  private final UnaryCallable<DeleteStatefileRequest, Empty> deleteStatefileCallable;
  private final UnaryCallable<LockDeploymentRequest, Operation> lockDeploymentCallable;
  private final OperationCallable<LockDeploymentRequest, Deployment, OperationMetadata>
      lockDeploymentOperationCallable;
  private final UnaryCallable<UnlockDeploymentRequest, Operation> unlockDeploymentCallable;
  private final OperationCallable<UnlockDeploymentRequest, Deployment, OperationMetadata>
      unlockDeploymentOperationCallable;
  private final UnaryCallable<ExportLockInfoRequest, LockInfo> exportLockInfoCallable;
  private final UnaryCallable<CreatePreviewRequest, Operation> createPreviewCallable;
  private final OperationCallable<CreatePreviewRequest, Preview, OperationMetadata>
      createPreviewOperationCallable;
  private final UnaryCallable<GetPreviewRequest, Preview> getPreviewCallable;
  private final UnaryCallable<ListPreviewsRequest, ListPreviewsResponse> listPreviewsCallable;
  private final UnaryCallable<ListPreviewsRequest, ListPreviewsPagedResponse>
      listPreviewsPagedCallable;
  private final UnaryCallable<DeletePreviewRequest, Operation> deletePreviewCallable;
  private final OperationCallable<DeletePreviewRequest, Preview, OperationMetadata>
      deletePreviewOperationCallable;
  private final UnaryCallable<ExportPreviewResultRequest, ExportPreviewResultResponse>
      exportPreviewResultCallable;
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

  public static final GrpcConfigStub create(ConfigStubSettings settings) throws IOException {
    return new GrpcConfigStub(settings, ClientContext.create(settings));
  }

  public static final GrpcConfigStub create(ClientContext clientContext) throws IOException {
    return new GrpcConfigStub(ConfigStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcConfigStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcConfigStub(
        ConfigStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcConfigStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcConfigStub(ConfigStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcConfigCallableFactory());
  }

  /**
   * Constructs an instance of GrpcConfigStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcConfigStub(
      ConfigStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListDeploymentsRequest, ListDeploymentsResponse>
        listDeploymentsTransportSettings =
            GrpcCallSettings.<ListDeploymentsRequest, ListDeploymentsResponse>newBuilder()
                .setMethodDescriptor(listDeploymentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDeploymentRequest, Deployment> getDeploymentTransportSettings =
        GrpcCallSettings.<GetDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(getDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateDeploymentRequest, Operation> createDeploymentTransportSettings =
        GrpcCallSettings.<CreateDeploymentRequest, Operation>newBuilder()
            .setMethodDescriptor(createDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDeploymentRequest, Operation> updateDeploymentTransportSettings =
        GrpcCallSettings.<UpdateDeploymentRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("deployment.name", String.valueOf(request.getDeployment().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDeploymentRequest, Operation> deleteDeploymentTransportSettings =
        GrpcCallSettings.<DeleteDeploymentRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListRevisionsRequest, ListRevisionsResponse> listRevisionsTransportSettings =
        GrpcCallSettings.<ListRevisionsRequest, ListRevisionsResponse>newBuilder()
            .setMethodDescriptor(listRevisionsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetRevisionRequest, Revision> getRevisionTransportSettings =
        GrpcCallSettings.<GetRevisionRequest, Revision>newBuilder()
            .setMethodDescriptor(getRevisionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetResourceRequest, Resource> getResourceTransportSettings =
        GrpcCallSettings.<GetResourceRequest, Resource>newBuilder()
            .setMethodDescriptor(getResourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListResourcesRequest, ListResourcesResponse> listResourcesTransportSettings =
        GrpcCallSettings.<ListResourcesRequest, ListResourcesResponse>newBuilder()
            .setMethodDescriptor(listResourcesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ExportDeploymentStatefileRequest, Statefile>
        exportDeploymentStatefileTransportSettings =
            GrpcCallSettings.<ExportDeploymentStatefileRequest, Statefile>newBuilder()
                .setMethodDescriptor(exportDeploymentStatefileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ExportRevisionStatefileRequest, Statefile>
        exportRevisionStatefileTransportSettings =
            GrpcCallSettings.<ExportRevisionStatefileRequest, Statefile>newBuilder()
                .setMethodDescriptor(exportRevisionStatefileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ImportStatefileRequest, Statefile> importStatefileTransportSettings =
        GrpcCallSettings.<ImportStatefileRequest, Statefile>newBuilder()
            .setMethodDescriptor(importStatefileMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteStatefileRequest, Empty> deleteStatefileTransportSettings =
        GrpcCallSettings.<DeleteStatefileRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteStatefileMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<LockDeploymentRequest, Operation> lockDeploymentTransportSettings =
        GrpcCallSettings.<LockDeploymentRequest, Operation>newBuilder()
            .setMethodDescriptor(lockDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UnlockDeploymentRequest, Operation> unlockDeploymentTransportSettings =
        GrpcCallSettings.<UnlockDeploymentRequest, Operation>newBuilder()
            .setMethodDescriptor(unlockDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ExportLockInfoRequest, LockInfo> exportLockInfoTransportSettings =
        GrpcCallSettings.<ExportLockInfoRequest, LockInfo>newBuilder()
            .setMethodDescriptor(exportLockInfoMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreatePreviewRequest, Operation> createPreviewTransportSettings =
        GrpcCallSettings.<CreatePreviewRequest, Operation>newBuilder()
            .setMethodDescriptor(createPreviewMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetPreviewRequest, Preview> getPreviewTransportSettings =
        GrpcCallSettings.<GetPreviewRequest, Preview>newBuilder()
            .setMethodDescriptor(getPreviewMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListPreviewsRequest, ListPreviewsResponse> listPreviewsTransportSettings =
        GrpcCallSettings.<ListPreviewsRequest, ListPreviewsResponse>newBuilder()
            .setMethodDescriptor(listPreviewsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeletePreviewRequest, Operation> deletePreviewTransportSettings =
        GrpcCallSettings.<DeletePreviewRequest, Operation>newBuilder()
            .setMethodDescriptor(deletePreviewMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ExportPreviewResultRequest, ExportPreviewResultResponse>
        exportPreviewResultTransportSettings =
            GrpcCallSettings.<ExportPreviewResultRequest, ExportPreviewResultResponse>newBuilder()
                .setMethodDescriptor(exportPreviewResultMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
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

    this.listDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listDeploymentsTransportSettings, settings.listDeploymentsSettings(), clientContext);
    this.listDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listDeploymentsTransportSettings, settings.listDeploymentsSettings(), clientContext);
    this.getDeploymentCallable =
        callableFactory.createUnaryCallable(
            getDeploymentTransportSettings, settings.getDeploymentSettings(), clientContext);
    this.createDeploymentCallable =
        callableFactory.createUnaryCallable(
            createDeploymentTransportSettings, settings.createDeploymentSettings(), clientContext);
    this.createDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            createDeploymentTransportSettings,
            settings.createDeploymentOperationSettings(),
            clientContext,
            operationsStub);
    this.updateDeploymentCallable =
        callableFactory.createUnaryCallable(
            updateDeploymentTransportSettings, settings.updateDeploymentSettings(), clientContext);
    this.updateDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            updateDeploymentTransportSettings,
            settings.updateDeploymentOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteDeploymentCallable =
        callableFactory.createUnaryCallable(
            deleteDeploymentTransportSettings, settings.deleteDeploymentSettings(), clientContext);
    this.deleteDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            deleteDeploymentTransportSettings,
            settings.deleteDeploymentOperationSettings(),
            clientContext,
            operationsStub);
    this.listRevisionsCallable =
        callableFactory.createUnaryCallable(
            listRevisionsTransportSettings, settings.listRevisionsSettings(), clientContext);
    this.listRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listRevisionsTransportSettings, settings.listRevisionsSettings(), clientContext);
    this.getRevisionCallable =
        callableFactory.createUnaryCallable(
            getRevisionTransportSettings, settings.getRevisionSettings(), clientContext);
    this.getResourceCallable =
        callableFactory.createUnaryCallable(
            getResourceTransportSettings, settings.getResourceSettings(), clientContext);
    this.listResourcesCallable =
        callableFactory.createUnaryCallable(
            listResourcesTransportSettings, settings.listResourcesSettings(), clientContext);
    this.listResourcesPagedCallable =
        callableFactory.createPagedCallable(
            listResourcesTransportSettings, settings.listResourcesSettings(), clientContext);
    this.exportDeploymentStatefileCallable =
        callableFactory.createUnaryCallable(
            exportDeploymentStatefileTransportSettings,
            settings.exportDeploymentStatefileSettings(),
            clientContext);
    this.exportRevisionStatefileCallable =
        callableFactory.createUnaryCallable(
            exportRevisionStatefileTransportSettings,
            settings.exportRevisionStatefileSettings(),
            clientContext);
    this.importStatefileCallable =
        callableFactory.createUnaryCallable(
            importStatefileTransportSettings, settings.importStatefileSettings(), clientContext);
    this.deleteStatefileCallable =
        callableFactory.createUnaryCallable(
            deleteStatefileTransportSettings, settings.deleteStatefileSettings(), clientContext);
    this.lockDeploymentCallable =
        callableFactory.createUnaryCallable(
            lockDeploymentTransportSettings, settings.lockDeploymentSettings(), clientContext);
    this.lockDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            lockDeploymentTransportSettings,
            settings.lockDeploymentOperationSettings(),
            clientContext,
            operationsStub);
    this.unlockDeploymentCallable =
        callableFactory.createUnaryCallable(
            unlockDeploymentTransportSettings, settings.unlockDeploymentSettings(), clientContext);
    this.unlockDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            unlockDeploymentTransportSettings,
            settings.unlockDeploymentOperationSettings(),
            clientContext,
            operationsStub);
    this.exportLockInfoCallable =
        callableFactory.createUnaryCallable(
            exportLockInfoTransportSettings, settings.exportLockInfoSettings(), clientContext);
    this.createPreviewCallable =
        callableFactory.createUnaryCallable(
            createPreviewTransportSettings, settings.createPreviewSettings(), clientContext);
    this.createPreviewOperationCallable =
        callableFactory.createOperationCallable(
            createPreviewTransportSettings,
            settings.createPreviewOperationSettings(),
            clientContext,
            operationsStub);
    this.getPreviewCallable =
        callableFactory.createUnaryCallable(
            getPreviewTransportSettings, settings.getPreviewSettings(), clientContext);
    this.listPreviewsCallable =
        callableFactory.createUnaryCallable(
            listPreviewsTransportSettings, settings.listPreviewsSettings(), clientContext);
    this.listPreviewsPagedCallable =
        callableFactory.createPagedCallable(
            listPreviewsTransportSettings, settings.listPreviewsSettings(), clientContext);
    this.deletePreviewCallable =
        callableFactory.createUnaryCallable(
            deletePreviewTransportSettings, settings.deletePreviewSettings(), clientContext);
    this.deletePreviewOperationCallable =
        callableFactory.createOperationCallable(
            deletePreviewTransportSettings,
            settings.deletePreviewOperationSettings(),
            clientContext,
            operationsStub);
    this.exportPreviewResultCallable =
        callableFactory.createUnaryCallable(
            exportPreviewResultTransportSettings,
            settings.exportPreviewResultSettings(),
            clientContext);
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
  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse> listDeploymentsCallable() {
    return listDeploymentsCallable;
  }

  @Override
  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable() {
    return listDeploymentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable() {
    return getDeploymentCallable;
  }

  @Override
  public UnaryCallable<CreateDeploymentRequest, Operation> createDeploymentCallable() {
    return createDeploymentCallable;
  }

  @Override
  public OperationCallable<CreateDeploymentRequest, Deployment, OperationMetadata>
      createDeploymentOperationCallable() {
    return createDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDeploymentRequest, Operation> updateDeploymentCallable() {
    return updateDeploymentCallable;
  }

  @Override
  public OperationCallable<UpdateDeploymentRequest, Deployment, OperationMetadata>
      updateDeploymentOperationCallable() {
    return updateDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDeploymentRequest, Operation> deleteDeploymentCallable() {
    return deleteDeploymentCallable;
  }

  @Override
  public OperationCallable<DeleteDeploymentRequest, Deployment, OperationMetadata>
      deleteDeploymentOperationCallable() {
    return deleteDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<ListRevisionsRequest, ListRevisionsResponse> listRevisionsCallable() {
    return listRevisionsCallable;
  }

  @Override
  public UnaryCallable<ListRevisionsRequest, ListRevisionsPagedResponse>
      listRevisionsPagedCallable() {
    return listRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetRevisionRequest, Revision> getRevisionCallable() {
    return getRevisionCallable;
  }

  @Override
  public UnaryCallable<GetResourceRequest, Resource> getResourceCallable() {
    return getResourceCallable;
  }

  @Override
  public UnaryCallable<ListResourcesRequest, ListResourcesResponse> listResourcesCallable() {
    return listResourcesCallable;
  }

  @Override
  public UnaryCallable<ListResourcesRequest, ListResourcesPagedResponse>
      listResourcesPagedCallable() {
    return listResourcesPagedCallable;
  }

  @Override
  public UnaryCallable<ExportDeploymentStatefileRequest, Statefile>
      exportDeploymentStatefileCallable() {
    return exportDeploymentStatefileCallable;
  }

  @Override
  public UnaryCallable<ExportRevisionStatefileRequest, Statefile>
      exportRevisionStatefileCallable() {
    return exportRevisionStatefileCallable;
  }

  @Override
  public UnaryCallable<ImportStatefileRequest, Statefile> importStatefileCallable() {
    return importStatefileCallable;
  }

  @Override
  public UnaryCallable<DeleteStatefileRequest, Empty> deleteStatefileCallable() {
    return deleteStatefileCallable;
  }

  @Override
  public UnaryCallable<LockDeploymentRequest, Operation> lockDeploymentCallable() {
    return lockDeploymentCallable;
  }

  @Override
  public OperationCallable<LockDeploymentRequest, Deployment, OperationMetadata>
      lockDeploymentOperationCallable() {
    return lockDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<UnlockDeploymentRequest, Operation> unlockDeploymentCallable() {
    return unlockDeploymentCallable;
  }

  @Override
  public OperationCallable<UnlockDeploymentRequest, Deployment, OperationMetadata>
      unlockDeploymentOperationCallable() {
    return unlockDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<ExportLockInfoRequest, LockInfo> exportLockInfoCallable() {
    return exportLockInfoCallable;
  }

  @Override
  public UnaryCallable<CreatePreviewRequest, Operation> createPreviewCallable() {
    return createPreviewCallable;
  }

  @Override
  public OperationCallable<CreatePreviewRequest, Preview, OperationMetadata>
      createPreviewOperationCallable() {
    return createPreviewOperationCallable;
  }

  @Override
  public UnaryCallable<GetPreviewRequest, Preview> getPreviewCallable() {
    return getPreviewCallable;
  }

  @Override
  public UnaryCallable<ListPreviewsRequest, ListPreviewsResponse> listPreviewsCallable() {
    return listPreviewsCallable;
  }

  @Override
  public UnaryCallable<ListPreviewsRequest, ListPreviewsPagedResponse> listPreviewsPagedCallable() {
    return listPreviewsPagedCallable;
  }

  @Override
  public UnaryCallable<DeletePreviewRequest, Operation> deletePreviewCallable() {
    return deletePreviewCallable;
  }

  @Override
  public OperationCallable<DeletePreviewRequest, Preview, OperationMetadata>
      deletePreviewOperationCallable() {
    return deletePreviewOperationCallable;
  }

  @Override
  public UnaryCallable<ExportPreviewResultRequest, ExportPreviewResultResponse>
      exportPreviewResultCallable() {
    return exportPreviewResultCallable;
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
