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

package com.google.cloud.visionai.v1.stub;

import static com.google.cloud.visionai.v1.AppPlatformClient.ListApplicationsPagedResponse;
import static com.google.cloud.visionai.v1.AppPlatformClient.ListDraftsPagedResponse;
import static com.google.cloud.visionai.v1.AppPlatformClient.ListInstancesPagedResponse;
import static com.google.cloud.visionai.v1.AppPlatformClient.ListProcessorsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.visionai.v1.AddApplicationStreamInputRequest;
import com.google.cloud.visionai.v1.AddApplicationStreamInputResponse;
import com.google.cloud.visionai.v1.Application;
import com.google.cloud.visionai.v1.CreateApplicationInstancesRequest;
import com.google.cloud.visionai.v1.CreateApplicationInstancesResponse;
import com.google.cloud.visionai.v1.CreateApplicationRequest;
import com.google.cloud.visionai.v1.CreateDraftRequest;
import com.google.cloud.visionai.v1.CreateProcessorRequest;
import com.google.cloud.visionai.v1.DeleteApplicationInstancesRequest;
import com.google.cloud.visionai.v1.DeleteApplicationRequest;
import com.google.cloud.visionai.v1.DeleteDraftRequest;
import com.google.cloud.visionai.v1.DeleteProcessorRequest;
import com.google.cloud.visionai.v1.DeployApplicationRequest;
import com.google.cloud.visionai.v1.DeployApplicationResponse;
import com.google.cloud.visionai.v1.Draft;
import com.google.cloud.visionai.v1.GetApplicationRequest;
import com.google.cloud.visionai.v1.GetDraftRequest;
import com.google.cloud.visionai.v1.GetInstanceRequest;
import com.google.cloud.visionai.v1.GetProcessorRequest;
import com.google.cloud.visionai.v1.Instance;
import com.google.cloud.visionai.v1.ListApplicationsRequest;
import com.google.cloud.visionai.v1.ListApplicationsResponse;
import com.google.cloud.visionai.v1.ListDraftsRequest;
import com.google.cloud.visionai.v1.ListDraftsResponse;
import com.google.cloud.visionai.v1.ListInstancesRequest;
import com.google.cloud.visionai.v1.ListInstancesResponse;
import com.google.cloud.visionai.v1.ListPrebuiltProcessorsRequest;
import com.google.cloud.visionai.v1.ListPrebuiltProcessorsResponse;
import com.google.cloud.visionai.v1.ListProcessorsRequest;
import com.google.cloud.visionai.v1.ListProcessorsResponse;
import com.google.cloud.visionai.v1.OperationMetadata;
import com.google.cloud.visionai.v1.Processor;
import com.google.cloud.visionai.v1.RemoveApplicationStreamInputRequest;
import com.google.cloud.visionai.v1.RemoveApplicationStreamInputResponse;
import com.google.cloud.visionai.v1.UndeployApplicationRequest;
import com.google.cloud.visionai.v1.UndeployApplicationResponse;
import com.google.cloud.visionai.v1.UpdateApplicationInstancesRequest;
import com.google.cloud.visionai.v1.UpdateApplicationInstancesResponse;
import com.google.cloud.visionai.v1.UpdateApplicationRequest;
import com.google.cloud.visionai.v1.UpdateApplicationStreamInputRequest;
import com.google.cloud.visionai.v1.UpdateApplicationStreamInputResponse;
import com.google.cloud.visionai.v1.UpdateDraftRequest;
import com.google.cloud.visionai.v1.UpdateProcessorRequest;
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
 * gRPC stub implementation for the AppPlatform service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAppPlatformStub extends AppPlatformStub {
  private static final MethodDescriptor<ListApplicationsRequest, ListApplicationsResponse>
      listApplicationsMethodDescriptor =
          MethodDescriptor.<ListApplicationsRequest, ListApplicationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/ListApplications")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListApplicationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListApplicationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetApplicationRequest, Application>
      getApplicationMethodDescriptor =
          MethodDescriptor.<GetApplicationRequest, Application>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/GetApplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Application.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateApplicationRequest, Operation>
      createApplicationMethodDescriptor =
          MethodDescriptor.<CreateApplicationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/CreateApplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateApplicationRequest, Operation>
      updateApplicationMethodDescriptor =
          MethodDescriptor.<UpdateApplicationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/UpdateApplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteApplicationRequest, Operation>
      deleteApplicationMethodDescriptor =
          MethodDescriptor.<DeleteApplicationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/DeleteApplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeployApplicationRequest, Operation>
      deployApplicationMethodDescriptor =
          MethodDescriptor.<DeployApplicationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/DeployApplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeployApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UndeployApplicationRequest, Operation>
      undeployApplicationMethodDescriptor =
          MethodDescriptor.<UndeployApplicationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/UndeployApplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UndeployApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AddApplicationStreamInputRequest, Operation>
      addApplicationStreamInputMethodDescriptor =
          MethodDescriptor.<AddApplicationStreamInputRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/AddApplicationStreamInput")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AddApplicationStreamInputRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RemoveApplicationStreamInputRequest, Operation>
      removeApplicationStreamInputMethodDescriptor =
          MethodDescriptor.<RemoveApplicationStreamInputRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.visionai.v1.AppPlatform/RemoveApplicationStreamInput")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RemoveApplicationStreamInputRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateApplicationStreamInputRequest, Operation>
      updateApplicationStreamInputMethodDescriptor =
          MethodDescriptor.<UpdateApplicationStreamInputRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.visionai.v1.AppPlatform/UpdateApplicationStreamInput")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateApplicationStreamInputRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListInstancesRequest, ListInstancesResponse>
      listInstancesMethodDescriptor =
          MethodDescriptor.<ListInstancesRequest, ListInstancesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/ListInstances")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInstancesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetInstanceRequest, Instance> getInstanceMethodDescriptor =
      MethodDescriptor.<GetInstanceRequest, Instance>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.AppPlatform/GetInstance")
          .setRequestMarshaller(ProtoUtils.marshaller(GetInstanceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Instance.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateApplicationInstancesRequest, Operation>
      createApplicationInstancesMethodDescriptor =
          MethodDescriptor.<CreateApplicationInstancesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/CreateApplicationInstances")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateApplicationInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteApplicationInstancesRequest, Operation>
      deleteApplicationInstancesMethodDescriptor =
          MethodDescriptor.<DeleteApplicationInstancesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/DeleteApplicationInstances")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteApplicationInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateApplicationInstancesRequest, Operation>
      updateApplicationInstancesMethodDescriptor =
          MethodDescriptor.<UpdateApplicationInstancesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/UpdateApplicationInstances")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateApplicationInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDraftsRequest, ListDraftsResponse>
      listDraftsMethodDescriptor =
          MethodDescriptor.<ListDraftsRequest, ListDraftsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/ListDrafts")
              .setRequestMarshaller(ProtoUtils.marshaller(ListDraftsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListDraftsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDraftRequest, Draft> getDraftMethodDescriptor =
      MethodDescriptor.<GetDraftRequest, Draft>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.AppPlatform/GetDraft")
          .setRequestMarshaller(ProtoUtils.marshaller(GetDraftRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Draft.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateDraftRequest, Operation> createDraftMethodDescriptor =
      MethodDescriptor.<CreateDraftRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.AppPlatform/CreateDraft")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateDraftRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateDraftRequest, Operation> updateDraftMethodDescriptor =
      MethodDescriptor.<UpdateDraftRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.AppPlatform/UpdateDraft")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateDraftRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteDraftRequest, Operation> deleteDraftMethodDescriptor =
      MethodDescriptor.<DeleteDraftRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.AppPlatform/DeleteDraft")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteDraftRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListProcessorsRequest, ListProcessorsResponse>
      listProcessorsMethodDescriptor =
          MethodDescriptor.<ListProcessorsRequest, ListProcessorsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/ListProcessors")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListProcessorsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListProcessorsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListPrebuiltProcessorsRequest, ListPrebuiltProcessorsResponse>
      listPrebuiltProcessorsMethodDescriptor =
          MethodDescriptor
              .<ListPrebuiltProcessorsRequest, ListPrebuiltProcessorsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/ListPrebuiltProcessors")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPrebuiltProcessorsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPrebuiltProcessorsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetProcessorRequest, Processor>
      getProcessorMethodDescriptor =
          MethodDescriptor.<GetProcessorRequest, Processor>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/GetProcessor")
              .setRequestMarshaller(ProtoUtils.marshaller(GetProcessorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Processor.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateProcessorRequest, Operation>
      createProcessorMethodDescriptor =
          MethodDescriptor.<CreateProcessorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/CreateProcessor")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateProcessorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateProcessorRequest, Operation>
      updateProcessorMethodDescriptor =
          MethodDescriptor.<UpdateProcessorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/UpdateProcessor")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateProcessorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteProcessorRequest, Operation>
      deleteProcessorMethodDescriptor =
          MethodDescriptor.<DeleteProcessorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/DeleteProcessor")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteProcessorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListApplicationsRequest, ListApplicationsResponse>
      listApplicationsCallable;
  private final UnaryCallable<ListApplicationsRequest, ListApplicationsPagedResponse>
      listApplicationsPagedCallable;
  private final UnaryCallable<GetApplicationRequest, Application> getApplicationCallable;
  private final UnaryCallable<CreateApplicationRequest, Operation> createApplicationCallable;
  private final OperationCallable<CreateApplicationRequest, Application, OperationMetadata>
      createApplicationOperationCallable;
  private final UnaryCallable<UpdateApplicationRequest, Operation> updateApplicationCallable;
  private final OperationCallable<UpdateApplicationRequest, Application, OperationMetadata>
      updateApplicationOperationCallable;
  private final UnaryCallable<DeleteApplicationRequest, Operation> deleteApplicationCallable;
  private final OperationCallable<DeleteApplicationRequest, Empty, OperationMetadata>
      deleteApplicationOperationCallable;
  private final UnaryCallable<DeployApplicationRequest, Operation> deployApplicationCallable;
  private final OperationCallable<
          DeployApplicationRequest, DeployApplicationResponse, OperationMetadata>
      deployApplicationOperationCallable;
  private final UnaryCallable<UndeployApplicationRequest, Operation> undeployApplicationCallable;
  private final OperationCallable<
          UndeployApplicationRequest, UndeployApplicationResponse, OperationMetadata>
      undeployApplicationOperationCallable;
  private final UnaryCallable<AddApplicationStreamInputRequest, Operation>
      addApplicationStreamInputCallable;
  private final OperationCallable<
          AddApplicationStreamInputRequest, AddApplicationStreamInputResponse, OperationMetadata>
      addApplicationStreamInputOperationCallable;
  private final UnaryCallable<RemoveApplicationStreamInputRequest, Operation>
      removeApplicationStreamInputCallable;
  private final OperationCallable<
          RemoveApplicationStreamInputRequest,
          RemoveApplicationStreamInputResponse,
          OperationMetadata>
      removeApplicationStreamInputOperationCallable;
  private final UnaryCallable<UpdateApplicationStreamInputRequest, Operation>
      updateApplicationStreamInputCallable;
  private final OperationCallable<
          UpdateApplicationStreamInputRequest,
          UpdateApplicationStreamInputResponse,
          OperationMetadata>
      updateApplicationStreamInputOperationCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable;
  private final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable;
  private final UnaryCallable<CreateApplicationInstancesRequest, Operation>
      createApplicationInstancesCallable;
  private final OperationCallable<
          CreateApplicationInstancesRequest, CreateApplicationInstancesResponse, OperationMetadata>
      createApplicationInstancesOperationCallable;
  private final UnaryCallable<DeleteApplicationInstancesRequest, Operation>
      deleteApplicationInstancesCallable;
  private final OperationCallable<DeleteApplicationInstancesRequest, Instance, OperationMetadata>
      deleteApplicationInstancesOperationCallable;
  private final UnaryCallable<UpdateApplicationInstancesRequest, Operation>
      updateApplicationInstancesCallable;
  private final OperationCallable<
          UpdateApplicationInstancesRequest, UpdateApplicationInstancesResponse, OperationMetadata>
      updateApplicationInstancesOperationCallable;
  private final UnaryCallable<ListDraftsRequest, ListDraftsResponse> listDraftsCallable;
  private final UnaryCallable<ListDraftsRequest, ListDraftsPagedResponse> listDraftsPagedCallable;
  private final UnaryCallable<GetDraftRequest, Draft> getDraftCallable;
  private final UnaryCallable<CreateDraftRequest, Operation> createDraftCallable;
  private final OperationCallable<CreateDraftRequest, Draft, OperationMetadata>
      createDraftOperationCallable;
  private final UnaryCallable<UpdateDraftRequest, Operation> updateDraftCallable;
  private final OperationCallable<UpdateDraftRequest, Draft, OperationMetadata>
      updateDraftOperationCallable;
  private final UnaryCallable<DeleteDraftRequest, Operation> deleteDraftCallable;
  private final OperationCallable<DeleteDraftRequest, Empty, OperationMetadata>
      deleteDraftOperationCallable;
  private final UnaryCallable<ListProcessorsRequest, ListProcessorsResponse> listProcessorsCallable;
  private final UnaryCallable<ListProcessorsRequest, ListProcessorsPagedResponse>
      listProcessorsPagedCallable;
  private final UnaryCallable<ListPrebuiltProcessorsRequest, ListPrebuiltProcessorsResponse>
      listPrebuiltProcessorsCallable;
  private final UnaryCallable<GetProcessorRequest, Processor> getProcessorCallable;
  private final UnaryCallable<CreateProcessorRequest, Operation> createProcessorCallable;
  private final OperationCallable<CreateProcessorRequest, Processor, OperationMetadata>
      createProcessorOperationCallable;
  private final UnaryCallable<UpdateProcessorRequest, Operation> updateProcessorCallable;
  private final OperationCallable<UpdateProcessorRequest, Processor, OperationMetadata>
      updateProcessorOperationCallable;
  private final UnaryCallable<DeleteProcessorRequest, Operation> deleteProcessorCallable;
  private final OperationCallable<DeleteProcessorRequest, Empty, OperationMetadata>
      deleteProcessorOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAppPlatformStub create(AppPlatformStubSettings settings)
      throws IOException {
    return new GrpcAppPlatformStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAppPlatformStub create(ClientContext clientContext) throws IOException {
    return new GrpcAppPlatformStub(AppPlatformStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAppPlatformStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAppPlatformStub(
        AppPlatformStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAppPlatformStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAppPlatformStub(AppPlatformStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAppPlatformCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAppPlatformStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAppPlatformStub(
      AppPlatformStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

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
    GrpcCallSettings<DeployApplicationRequest, Operation> deployApplicationTransportSettings =
        GrpcCallSettings.<DeployApplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(deployApplicationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UndeployApplicationRequest, Operation> undeployApplicationTransportSettings =
        GrpcCallSettings.<UndeployApplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(undeployApplicationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<AddApplicationStreamInputRequest, Operation>
        addApplicationStreamInputTransportSettings =
            GrpcCallSettings.<AddApplicationStreamInputRequest, Operation>newBuilder()
                .setMethodDescriptor(addApplicationStreamInputMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RemoveApplicationStreamInputRequest, Operation>
        removeApplicationStreamInputTransportSettings =
            GrpcCallSettings.<RemoveApplicationStreamInputRequest, Operation>newBuilder()
                .setMethodDescriptor(removeApplicationStreamInputMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateApplicationStreamInputRequest, Operation>
        updateApplicationStreamInputTransportSettings =
            GrpcCallSettings.<UpdateApplicationStreamInputRequest, Operation>newBuilder()
                .setMethodDescriptor(updateApplicationStreamInputMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListInstancesRequest, ListInstancesResponse> listInstancesTransportSettings =
        GrpcCallSettings.<ListInstancesRequest, ListInstancesResponse>newBuilder()
            .setMethodDescriptor(listInstancesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetInstanceRequest, Instance> getInstanceTransportSettings =
        GrpcCallSettings.<GetInstanceRequest, Instance>newBuilder()
            .setMethodDescriptor(getInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateApplicationInstancesRequest, Operation>
        createApplicationInstancesTransportSettings =
            GrpcCallSettings.<CreateApplicationInstancesRequest, Operation>newBuilder()
                .setMethodDescriptor(createApplicationInstancesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteApplicationInstancesRequest, Operation>
        deleteApplicationInstancesTransportSettings =
            GrpcCallSettings.<DeleteApplicationInstancesRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteApplicationInstancesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateApplicationInstancesRequest, Operation>
        updateApplicationInstancesTransportSettings =
            GrpcCallSettings.<UpdateApplicationInstancesRequest, Operation>newBuilder()
                .setMethodDescriptor(updateApplicationInstancesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListDraftsRequest, ListDraftsResponse> listDraftsTransportSettings =
        GrpcCallSettings.<ListDraftsRequest, ListDraftsResponse>newBuilder()
            .setMethodDescriptor(listDraftsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetDraftRequest, Draft> getDraftTransportSettings =
        GrpcCallSettings.<GetDraftRequest, Draft>newBuilder()
            .setMethodDescriptor(getDraftMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateDraftRequest, Operation> createDraftTransportSettings =
        GrpcCallSettings.<CreateDraftRequest, Operation>newBuilder()
            .setMethodDescriptor(createDraftMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDraftRequest, Operation> updateDraftTransportSettings =
        GrpcCallSettings.<UpdateDraftRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDraftMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("draft.name", String.valueOf(request.getDraft().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDraftRequest, Operation> deleteDraftTransportSettings =
        GrpcCallSettings.<DeleteDraftRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDraftMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListProcessorsRequest, ListProcessorsResponse>
        listProcessorsTransportSettings =
            GrpcCallSettings.<ListProcessorsRequest, ListProcessorsResponse>newBuilder()
                .setMethodDescriptor(listProcessorsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListPrebuiltProcessorsRequest, ListPrebuiltProcessorsResponse>
        listPrebuiltProcessorsTransportSettings =
            GrpcCallSettings
                .<ListPrebuiltProcessorsRequest, ListPrebuiltProcessorsResponse>newBuilder()
                .setMethodDescriptor(listPrebuiltProcessorsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetProcessorRequest, Processor> getProcessorTransportSettings =
        GrpcCallSettings.<GetProcessorRequest, Processor>newBuilder()
            .setMethodDescriptor(getProcessorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateProcessorRequest, Operation> createProcessorTransportSettings =
        GrpcCallSettings.<CreateProcessorRequest, Operation>newBuilder()
            .setMethodDescriptor(createProcessorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateProcessorRequest, Operation> updateProcessorTransportSettings =
        GrpcCallSettings.<UpdateProcessorRequest, Operation>newBuilder()
            .setMethodDescriptor(updateProcessorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("processor.name", String.valueOf(request.getProcessor().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteProcessorRequest, Operation> deleteProcessorTransportSettings =
        GrpcCallSettings.<DeleteProcessorRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteProcessorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listApplicationsCallable =
        callableFactory.createUnaryCallable(
            listApplicationsTransportSettings, settings.listApplicationsSettings(), clientContext);
    this.listApplicationsPagedCallable =
        callableFactory.createPagedCallable(
            listApplicationsTransportSettings, settings.listApplicationsSettings(), clientContext);
    this.getApplicationCallable =
        callableFactory.createUnaryCallable(
            getApplicationTransportSettings, settings.getApplicationSettings(), clientContext);
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
    this.deployApplicationCallable =
        callableFactory.createUnaryCallable(
            deployApplicationTransportSettings,
            settings.deployApplicationSettings(),
            clientContext);
    this.deployApplicationOperationCallable =
        callableFactory.createOperationCallable(
            deployApplicationTransportSettings,
            settings.deployApplicationOperationSettings(),
            clientContext,
            operationsStub);
    this.undeployApplicationCallable =
        callableFactory.createUnaryCallable(
            undeployApplicationTransportSettings,
            settings.undeployApplicationSettings(),
            clientContext);
    this.undeployApplicationOperationCallable =
        callableFactory.createOperationCallable(
            undeployApplicationTransportSettings,
            settings.undeployApplicationOperationSettings(),
            clientContext,
            operationsStub);
    this.addApplicationStreamInputCallable =
        callableFactory.createUnaryCallable(
            addApplicationStreamInputTransportSettings,
            settings.addApplicationStreamInputSettings(),
            clientContext);
    this.addApplicationStreamInputOperationCallable =
        callableFactory.createOperationCallable(
            addApplicationStreamInputTransportSettings,
            settings.addApplicationStreamInputOperationSettings(),
            clientContext,
            operationsStub);
    this.removeApplicationStreamInputCallable =
        callableFactory.createUnaryCallable(
            removeApplicationStreamInputTransportSettings,
            settings.removeApplicationStreamInputSettings(),
            clientContext);
    this.removeApplicationStreamInputOperationCallable =
        callableFactory.createOperationCallable(
            removeApplicationStreamInputTransportSettings,
            settings.removeApplicationStreamInputOperationSettings(),
            clientContext,
            operationsStub);
    this.updateApplicationStreamInputCallable =
        callableFactory.createUnaryCallable(
            updateApplicationStreamInputTransportSettings,
            settings.updateApplicationStreamInputSettings(),
            clientContext);
    this.updateApplicationStreamInputOperationCallable =
        callableFactory.createOperationCallable(
            updateApplicationStreamInputTransportSettings,
            settings.updateApplicationStreamInputOperationSettings(),
            clientContext,
            operationsStub);
    this.listInstancesCallable =
        callableFactory.createUnaryCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.listInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.getInstanceCallable =
        callableFactory.createUnaryCallable(
            getInstanceTransportSettings, settings.getInstanceSettings(), clientContext);
    this.createApplicationInstancesCallable =
        callableFactory.createUnaryCallable(
            createApplicationInstancesTransportSettings,
            settings.createApplicationInstancesSettings(),
            clientContext);
    this.createApplicationInstancesOperationCallable =
        callableFactory.createOperationCallable(
            createApplicationInstancesTransportSettings,
            settings.createApplicationInstancesOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteApplicationInstancesCallable =
        callableFactory.createUnaryCallable(
            deleteApplicationInstancesTransportSettings,
            settings.deleteApplicationInstancesSettings(),
            clientContext);
    this.deleteApplicationInstancesOperationCallable =
        callableFactory.createOperationCallable(
            deleteApplicationInstancesTransportSettings,
            settings.deleteApplicationInstancesOperationSettings(),
            clientContext,
            operationsStub);
    this.updateApplicationInstancesCallable =
        callableFactory.createUnaryCallable(
            updateApplicationInstancesTransportSettings,
            settings.updateApplicationInstancesSettings(),
            clientContext);
    this.updateApplicationInstancesOperationCallable =
        callableFactory.createOperationCallable(
            updateApplicationInstancesTransportSettings,
            settings.updateApplicationInstancesOperationSettings(),
            clientContext,
            operationsStub);
    this.listDraftsCallable =
        callableFactory.createUnaryCallable(
            listDraftsTransportSettings, settings.listDraftsSettings(), clientContext);
    this.listDraftsPagedCallable =
        callableFactory.createPagedCallable(
            listDraftsTransportSettings, settings.listDraftsSettings(), clientContext);
    this.getDraftCallable =
        callableFactory.createUnaryCallable(
            getDraftTransportSettings, settings.getDraftSettings(), clientContext);
    this.createDraftCallable =
        callableFactory.createUnaryCallable(
            createDraftTransportSettings, settings.createDraftSettings(), clientContext);
    this.createDraftOperationCallable =
        callableFactory.createOperationCallable(
            createDraftTransportSettings,
            settings.createDraftOperationSettings(),
            clientContext,
            operationsStub);
    this.updateDraftCallable =
        callableFactory.createUnaryCallable(
            updateDraftTransportSettings, settings.updateDraftSettings(), clientContext);
    this.updateDraftOperationCallable =
        callableFactory.createOperationCallable(
            updateDraftTransportSettings,
            settings.updateDraftOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteDraftCallable =
        callableFactory.createUnaryCallable(
            deleteDraftTransportSettings, settings.deleteDraftSettings(), clientContext);
    this.deleteDraftOperationCallable =
        callableFactory.createOperationCallable(
            deleteDraftTransportSettings,
            settings.deleteDraftOperationSettings(),
            clientContext,
            operationsStub);
    this.listProcessorsCallable =
        callableFactory.createUnaryCallable(
            listProcessorsTransportSettings, settings.listProcessorsSettings(), clientContext);
    this.listProcessorsPagedCallable =
        callableFactory.createPagedCallable(
            listProcessorsTransportSettings, settings.listProcessorsSettings(), clientContext);
    this.listPrebuiltProcessorsCallable =
        callableFactory.createUnaryCallable(
            listPrebuiltProcessorsTransportSettings,
            settings.listPrebuiltProcessorsSettings(),
            clientContext);
    this.getProcessorCallable =
        callableFactory.createUnaryCallable(
            getProcessorTransportSettings, settings.getProcessorSettings(), clientContext);
    this.createProcessorCallable =
        callableFactory.createUnaryCallable(
            createProcessorTransportSettings, settings.createProcessorSettings(), clientContext);
    this.createProcessorOperationCallable =
        callableFactory.createOperationCallable(
            createProcessorTransportSettings,
            settings.createProcessorOperationSettings(),
            clientContext,
            operationsStub);
    this.updateProcessorCallable =
        callableFactory.createUnaryCallable(
            updateProcessorTransportSettings, settings.updateProcessorSettings(), clientContext);
    this.updateProcessorOperationCallable =
        callableFactory.createOperationCallable(
            updateProcessorTransportSettings,
            settings.updateProcessorOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteProcessorCallable =
        callableFactory.createUnaryCallable(
            deleteProcessorTransportSettings, settings.deleteProcessorSettings(), clientContext);
    this.deleteProcessorOperationCallable =
        callableFactory.createOperationCallable(
            deleteProcessorTransportSettings,
            settings.deleteProcessorOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
  public UnaryCallable<GetApplicationRequest, Application> getApplicationCallable() {
    return getApplicationCallable;
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
  public UnaryCallable<DeployApplicationRequest, Operation> deployApplicationCallable() {
    return deployApplicationCallable;
  }

  @Override
  public OperationCallable<DeployApplicationRequest, DeployApplicationResponse, OperationMetadata>
      deployApplicationOperationCallable() {
    return deployApplicationOperationCallable;
  }

  @Override
  public UnaryCallable<UndeployApplicationRequest, Operation> undeployApplicationCallable() {
    return undeployApplicationCallable;
  }

  @Override
  public OperationCallable<
          UndeployApplicationRequest, UndeployApplicationResponse, OperationMetadata>
      undeployApplicationOperationCallable() {
    return undeployApplicationOperationCallable;
  }

  @Override
  public UnaryCallable<AddApplicationStreamInputRequest, Operation>
      addApplicationStreamInputCallable() {
    return addApplicationStreamInputCallable;
  }

  @Override
  public OperationCallable<
          AddApplicationStreamInputRequest, AddApplicationStreamInputResponse, OperationMetadata>
      addApplicationStreamInputOperationCallable() {
    return addApplicationStreamInputOperationCallable;
  }

  @Override
  public UnaryCallable<RemoveApplicationStreamInputRequest, Operation>
      removeApplicationStreamInputCallable() {
    return removeApplicationStreamInputCallable;
  }

  @Override
  public OperationCallable<
          RemoveApplicationStreamInputRequest,
          RemoveApplicationStreamInputResponse,
          OperationMetadata>
      removeApplicationStreamInputOperationCallable() {
    return removeApplicationStreamInputOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateApplicationStreamInputRequest, Operation>
      updateApplicationStreamInputCallable() {
    return updateApplicationStreamInputCallable;
  }

  @Override
  public OperationCallable<
          UpdateApplicationStreamInputRequest,
          UpdateApplicationStreamInputResponse,
          OperationMetadata>
      updateApplicationStreamInputOperationCallable() {
    return updateApplicationStreamInputOperationCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return listInstancesCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return listInstancesPagedCallable;
  }

  @Override
  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return getInstanceCallable;
  }

  @Override
  public UnaryCallable<CreateApplicationInstancesRequest, Operation>
      createApplicationInstancesCallable() {
    return createApplicationInstancesCallable;
  }

  @Override
  public OperationCallable<
          CreateApplicationInstancesRequest, CreateApplicationInstancesResponse, OperationMetadata>
      createApplicationInstancesOperationCallable() {
    return createApplicationInstancesOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteApplicationInstancesRequest, Operation>
      deleteApplicationInstancesCallable() {
    return deleteApplicationInstancesCallable;
  }

  @Override
  public OperationCallable<DeleteApplicationInstancesRequest, Instance, OperationMetadata>
      deleteApplicationInstancesOperationCallable() {
    return deleteApplicationInstancesOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateApplicationInstancesRequest, Operation>
      updateApplicationInstancesCallable() {
    return updateApplicationInstancesCallable;
  }

  @Override
  public OperationCallable<
          UpdateApplicationInstancesRequest, UpdateApplicationInstancesResponse, OperationMetadata>
      updateApplicationInstancesOperationCallable() {
    return updateApplicationInstancesOperationCallable;
  }

  @Override
  public UnaryCallable<ListDraftsRequest, ListDraftsResponse> listDraftsCallable() {
    return listDraftsCallable;
  }

  @Override
  public UnaryCallable<ListDraftsRequest, ListDraftsPagedResponse> listDraftsPagedCallable() {
    return listDraftsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDraftRequest, Draft> getDraftCallable() {
    return getDraftCallable;
  }

  @Override
  public UnaryCallable<CreateDraftRequest, Operation> createDraftCallable() {
    return createDraftCallable;
  }

  @Override
  public OperationCallable<CreateDraftRequest, Draft, OperationMetadata>
      createDraftOperationCallable() {
    return createDraftOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDraftRequest, Operation> updateDraftCallable() {
    return updateDraftCallable;
  }

  @Override
  public OperationCallable<UpdateDraftRequest, Draft, OperationMetadata>
      updateDraftOperationCallable() {
    return updateDraftOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDraftRequest, Operation> deleteDraftCallable() {
    return deleteDraftCallable;
  }

  @Override
  public OperationCallable<DeleteDraftRequest, Empty, OperationMetadata>
      deleteDraftOperationCallable() {
    return deleteDraftOperationCallable;
  }

  @Override
  public UnaryCallable<ListProcessorsRequest, ListProcessorsResponse> listProcessorsCallable() {
    return listProcessorsCallable;
  }

  @Override
  public UnaryCallable<ListProcessorsRequest, ListProcessorsPagedResponse>
      listProcessorsPagedCallable() {
    return listProcessorsPagedCallable;
  }

  @Override
  public UnaryCallable<ListPrebuiltProcessorsRequest, ListPrebuiltProcessorsResponse>
      listPrebuiltProcessorsCallable() {
    return listPrebuiltProcessorsCallable;
  }

  @Override
  public UnaryCallable<GetProcessorRequest, Processor> getProcessorCallable() {
    return getProcessorCallable;
  }

  @Override
  public UnaryCallable<CreateProcessorRequest, Operation> createProcessorCallable() {
    return createProcessorCallable;
  }

  @Override
  public OperationCallable<CreateProcessorRequest, Processor, OperationMetadata>
      createProcessorOperationCallable() {
    return createProcessorOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateProcessorRequest, Operation> updateProcessorCallable() {
    return updateProcessorCallable;
  }

  @Override
  public OperationCallable<UpdateProcessorRequest, Processor, OperationMetadata>
      updateProcessorOperationCallable() {
    return updateProcessorOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteProcessorRequest, Operation> deleteProcessorCallable() {
    return deleteProcessorCallable;
  }

  @Override
  public OperationCallable<DeleteProcessorRequest, Empty, OperationMetadata>
      deleteProcessorOperationCallable() {
    return deleteProcessorOperationCallable;
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
