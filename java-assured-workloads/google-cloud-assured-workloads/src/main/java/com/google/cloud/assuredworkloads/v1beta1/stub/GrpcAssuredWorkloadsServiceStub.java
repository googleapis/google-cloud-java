/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.assuredworkloads.v1beta1.stub;

import static com.google.cloud.assuredworkloads.v1beta1.AssuredWorkloadsServiceClient.ListWorkloadsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveRequest;
import com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveResponse;
import com.google.cloud.assuredworkloads.v1beta1.CreateWorkloadOperationMetadata;
import com.google.cloud.assuredworkloads.v1beta1.CreateWorkloadRequest;
import com.google.cloud.assuredworkloads.v1beta1.DeleteWorkloadRequest;
import com.google.cloud.assuredworkloads.v1beta1.GetWorkloadRequest;
import com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsRequest;
import com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsResponse;
import com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesRequest;
import com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesResponse;
import com.google.cloud.assuredworkloads.v1beta1.UpdateWorkloadRequest;
import com.google.cloud.assuredworkloads.v1beta1.Workload;
import com.google.common.collect.ImmutableMap;
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
 * gRPC stub implementation for the AssuredWorkloadsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcAssuredWorkloadsServiceStub extends AssuredWorkloadsServiceStub {
  private static final MethodDescriptor<CreateWorkloadRequest, Operation>
      createWorkloadMethodDescriptor =
          MethodDescriptor.<CreateWorkloadRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.assuredworkloads.v1beta1.AssuredWorkloadsService/CreateWorkload")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateWorkloadRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateWorkloadRequest, Workload>
      updateWorkloadMethodDescriptor =
          MethodDescriptor.<UpdateWorkloadRequest, Workload>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.assuredworkloads.v1beta1.AssuredWorkloadsService/UpdateWorkload")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateWorkloadRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Workload.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          RestrictAllowedResourcesRequest, RestrictAllowedResourcesResponse>
      restrictAllowedResourcesMethodDescriptor =
          MethodDescriptor
              .<RestrictAllowedResourcesRequest, RestrictAllowedResourcesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.assuredworkloads.v1beta1.AssuredWorkloadsService/RestrictAllowedResources")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RestrictAllowedResourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RestrictAllowedResourcesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteWorkloadRequest, Empty>
      deleteWorkloadMethodDescriptor =
          MethodDescriptor.<DeleteWorkloadRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.assuredworkloads.v1beta1.AssuredWorkloadsService/DeleteWorkload")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteWorkloadRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetWorkloadRequest, Workload> getWorkloadMethodDescriptor =
      MethodDescriptor.<GetWorkloadRequest, Workload>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.assuredworkloads.v1beta1.AssuredWorkloadsService/GetWorkload")
          .setRequestMarshaller(ProtoUtils.marshaller(GetWorkloadRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Workload.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<AnalyzeWorkloadMoveRequest, AnalyzeWorkloadMoveResponse>
      analyzeWorkloadMoveMethodDescriptor =
          MethodDescriptor.<AnalyzeWorkloadMoveRequest, AnalyzeWorkloadMoveResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.assuredworkloads.v1beta1.AssuredWorkloadsService/AnalyzeWorkloadMove")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AnalyzeWorkloadMoveRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AnalyzeWorkloadMoveResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListWorkloadsRequest, ListWorkloadsResponse>
      listWorkloadsMethodDescriptor =
          MethodDescriptor.<ListWorkloadsRequest, ListWorkloadsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.assuredworkloads.v1beta1.AssuredWorkloadsService/ListWorkloads")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListWorkloadsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListWorkloadsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateWorkloadRequest, Operation> createWorkloadCallable;
  private final OperationCallable<CreateWorkloadRequest, Workload, CreateWorkloadOperationMetadata>
      createWorkloadOperationCallable;
  private final UnaryCallable<UpdateWorkloadRequest, Workload> updateWorkloadCallable;
  private final UnaryCallable<RestrictAllowedResourcesRequest, RestrictAllowedResourcesResponse>
      restrictAllowedResourcesCallable;
  private final UnaryCallable<DeleteWorkloadRequest, Empty> deleteWorkloadCallable;
  private final UnaryCallable<GetWorkloadRequest, Workload> getWorkloadCallable;
  private final UnaryCallable<AnalyzeWorkloadMoveRequest, AnalyzeWorkloadMoveResponse>
      analyzeWorkloadMoveCallable;
  private final UnaryCallable<ListWorkloadsRequest, ListWorkloadsResponse> listWorkloadsCallable;
  private final UnaryCallable<ListWorkloadsRequest, ListWorkloadsPagedResponse>
      listWorkloadsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAssuredWorkloadsServiceStub create(
      AssuredWorkloadsServiceStubSettings settings) throws IOException {
    return new GrpcAssuredWorkloadsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAssuredWorkloadsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAssuredWorkloadsServiceStub(
        AssuredWorkloadsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAssuredWorkloadsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAssuredWorkloadsServiceStub(
        AssuredWorkloadsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAssuredWorkloadsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAssuredWorkloadsServiceStub(
      AssuredWorkloadsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAssuredWorkloadsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAssuredWorkloadsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAssuredWorkloadsServiceStub(
      AssuredWorkloadsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateWorkloadRequest, Operation> createWorkloadTransportSettings =
        GrpcCallSettings.<CreateWorkloadRequest, Operation>newBuilder()
            .setMethodDescriptor(createWorkloadMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateWorkloadRequest, Workload> updateWorkloadTransportSettings =
        GrpcCallSettings.<UpdateWorkloadRequest, Workload>newBuilder()
            .setMethodDescriptor(updateWorkloadMethodDescriptor)
            .build();
    GrpcCallSettings<RestrictAllowedResourcesRequest, RestrictAllowedResourcesResponse>
        restrictAllowedResourcesTransportSettings =
            GrpcCallSettings
                .<RestrictAllowedResourcesRequest, RestrictAllowedResourcesResponse>newBuilder()
                .setMethodDescriptor(restrictAllowedResourcesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteWorkloadRequest, Empty> deleteWorkloadTransportSettings =
        GrpcCallSettings.<DeleteWorkloadRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteWorkloadMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetWorkloadRequest, Workload> getWorkloadTransportSettings =
        GrpcCallSettings.<GetWorkloadRequest, Workload>newBuilder()
            .setMethodDescriptor(getWorkloadMethodDescriptor)
            .build();
    GrpcCallSettings<AnalyzeWorkloadMoveRequest, AnalyzeWorkloadMoveResponse>
        analyzeWorkloadMoveTransportSettings =
            GrpcCallSettings.<AnalyzeWorkloadMoveRequest, AnalyzeWorkloadMoveResponse>newBuilder()
                .setMethodDescriptor(analyzeWorkloadMoveMethodDescriptor)
                .build();
    GrpcCallSettings<ListWorkloadsRequest, ListWorkloadsResponse> listWorkloadsTransportSettings =
        GrpcCallSettings.<ListWorkloadsRequest, ListWorkloadsResponse>newBuilder()
            .setMethodDescriptor(listWorkloadsMethodDescriptor)
            .build();

    this.createWorkloadCallable =
        callableFactory.createUnaryCallable(
            createWorkloadTransportSettings, settings.createWorkloadSettings(), clientContext);
    this.createWorkloadOperationCallable =
        callableFactory.createOperationCallable(
            createWorkloadTransportSettings,
            settings.createWorkloadOperationSettings(),
            clientContext,
            operationsStub);
    this.updateWorkloadCallable =
        callableFactory.createUnaryCallable(
            updateWorkloadTransportSettings, settings.updateWorkloadSettings(), clientContext);
    this.restrictAllowedResourcesCallable =
        callableFactory.createUnaryCallable(
            restrictAllowedResourcesTransportSettings,
            settings.restrictAllowedResourcesSettings(),
            clientContext);
    this.deleteWorkloadCallable =
        callableFactory.createUnaryCallable(
            deleteWorkloadTransportSettings, settings.deleteWorkloadSettings(), clientContext);
    this.getWorkloadCallable =
        callableFactory.createUnaryCallable(
            getWorkloadTransportSettings, settings.getWorkloadSettings(), clientContext);
    this.analyzeWorkloadMoveCallable =
        callableFactory.createUnaryCallable(
            analyzeWorkloadMoveTransportSettings,
            settings.analyzeWorkloadMoveSettings(),
            clientContext);
    this.listWorkloadsCallable =
        callableFactory.createUnaryCallable(
            listWorkloadsTransportSettings, settings.listWorkloadsSettings(), clientContext);
    this.listWorkloadsPagedCallable =
        callableFactory.createPagedCallable(
            listWorkloadsTransportSettings, settings.listWorkloadsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateWorkloadRequest, Operation> createWorkloadCallable() {
    return createWorkloadCallable;
  }

  @Override
  public OperationCallable<CreateWorkloadRequest, Workload, CreateWorkloadOperationMetadata>
      createWorkloadOperationCallable() {
    return createWorkloadOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateWorkloadRequest, Workload> updateWorkloadCallable() {
    return updateWorkloadCallable;
  }

  @Override
  public UnaryCallable<RestrictAllowedResourcesRequest, RestrictAllowedResourcesResponse>
      restrictAllowedResourcesCallable() {
    return restrictAllowedResourcesCallable;
  }

  @Override
  public UnaryCallable<DeleteWorkloadRequest, Empty> deleteWorkloadCallable() {
    return deleteWorkloadCallable;
  }

  @Override
  public UnaryCallable<GetWorkloadRequest, Workload> getWorkloadCallable() {
    return getWorkloadCallable;
  }

  @Override
  public UnaryCallable<AnalyzeWorkloadMoveRequest, AnalyzeWorkloadMoveResponse>
      analyzeWorkloadMoveCallable() {
    return analyzeWorkloadMoveCallable;
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
