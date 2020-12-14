/*
 * Copyright 2020 Google LLC
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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.assuredworkloads.v1beta1.CreateWorkloadOperationMetadata;
import com.google.cloud.assuredworkloads.v1beta1.CreateWorkloadRequest;
import com.google.cloud.assuredworkloads.v1beta1.DeleteWorkloadRequest;
import com.google.cloud.assuredworkloads.v1beta1.GetWorkloadRequest;
import com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsRequest;
import com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsResponse;
import com.google.cloud.assuredworkloads.v1beta1.UpdateWorkloadRequest;
import com.google.cloud.assuredworkloads.v1beta1.Workload;
import com.google.common.collect.ImmutableMap;
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
 * gRPC stub implementation for the AssuredWorkloadsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
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
  private final UnaryCallable<DeleteWorkloadRequest, Empty> deleteWorkloadCallable;
  private final UnaryCallable<GetWorkloadRequest, Workload> getWorkloadCallable;
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
                new RequestParamsExtractor<CreateWorkloadRequest>() {
                  @Override
                  public Map<String, String> extract(CreateWorkloadRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateWorkloadRequest, Workload> updateWorkloadTransportSettings =
        GrpcCallSettings.<UpdateWorkloadRequest, Workload>newBuilder()
            .setMethodDescriptor(updateWorkloadMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateWorkloadRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateWorkloadRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("workload.name", String.valueOf(request.getWorkload().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteWorkloadRequest, Empty> deleteWorkloadTransportSettings =
        GrpcCallSettings.<DeleteWorkloadRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteWorkloadMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteWorkloadRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteWorkloadRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetWorkloadRequest, Workload> getWorkloadTransportSettings =
        GrpcCallSettings.<GetWorkloadRequest, Workload>newBuilder()
            .setMethodDescriptor(getWorkloadMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetWorkloadRequest>() {
                  @Override
                  public Map<String, String> extract(GetWorkloadRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListWorkloadsRequest, ListWorkloadsResponse> listWorkloadsTransportSettings =
        GrpcCallSettings.<ListWorkloadsRequest, ListWorkloadsResponse>newBuilder()
            .setMethodDescriptor(listWorkloadsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListWorkloadsRequest>() {
                  @Override
                  public Map<String, String> extract(ListWorkloadsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
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
    this.deleteWorkloadCallable =
        callableFactory.createUnaryCallable(
            deleteWorkloadTransportSettings, settings.deleteWorkloadSettings(), clientContext);
    this.getWorkloadCallable =
        callableFactory.createUnaryCallable(
            getWorkloadTransportSettings, settings.getWorkloadSettings(), clientContext);
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

  public UnaryCallable<CreateWorkloadRequest, Operation> createWorkloadCallable() {
    return createWorkloadCallable;
  }

  public OperationCallable<CreateWorkloadRequest, Workload, CreateWorkloadOperationMetadata>
      createWorkloadOperationCallable() {
    return createWorkloadOperationCallable;
  }

  public UnaryCallable<UpdateWorkloadRequest, Workload> updateWorkloadCallable() {
    return updateWorkloadCallable;
  }

  public UnaryCallable<DeleteWorkloadRequest, Empty> deleteWorkloadCallable() {
    return deleteWorkloadCallable;
  }

  public UnaryCallable<GetWorkloadRequest, Workload> getWorkloadCallable() {
    return getWorkloadCallable;
  }

  public UnaryCallable<ListWorkloadsRequest, ListWorkloadsResponse> listWorkloadsCallable() {
    return listWorkloadsCallable;
  }

  public UnaryCallable<ListWorkloadsRequest, ListWorkloadsPagedResponse>
      listWorkloadsPagedCallable() {
    return listWorkloadsPagedCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
