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

package com.google.cloud.run.v2.stub;

import static com.google.cloud.run.v2.WorkerPoolsClient.ListWorkerPoolsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.run.v2.CreateWorkerPoolRequest;
import com.google.cloud.run.v2.DeleteWorkerPoolRequest;
import com.google.cloud.run.v2.GetWorkerPoolRequest;
import com.google.cloud.run.v2.ListWorkerPoolsRequest;
import com.google.cloud.run.v2.ListWorkerPoolsResponse;
import com.google.cloud.run.v2.UpdateWorkerPoolRequest;
import com.google.cloud.run.v2.WorkerPool;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the WorkerPools service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcWorkerPoolsStub extends WorkerPoolsStub {
  private static final MethodDescriptor<CreateWorkerPoolRequest, Operation>
      createWorkerPoolMethodDescriptor =
          MethodDescriptor.<CreateWorkerPoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.run.v2.WorkerPools/CreateWorkerPool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateWorkerPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetWorkerPoolRequest, WorkerPool>
      getWorkerPoolMethodDescriptor =
          MethodDescriptor.<GetWorkerPoolRequest, WorkerPool>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.run.v2.WorkerPools/GetWorkerPool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetWorkerPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(WorkerPool.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListWorkerPoolsRequest, ListWorkerPoolsResponse>
      listWorkerPoolsMethodDescriptor =
          MethodDescriptor.<ListWorkerPoolsRequest, ListWorkerPoolsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.run.v2.WorkerPools/ListWorkerPools")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListWorkerPoolsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListWorkerPoolsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateWorkerPoolRequest, Operation>
      updateWorkerPoolMethodDescriptor =
          MethodDescriptor.<UpdateWorkerPoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.run.v2.WorkerPools/UpdateWorkerPool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateWorkerPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteWorkerPoolRequest, Operation>
      deleteWorkerPoolMethodDescriptor =
          MethodDescriptor.<DeleteWorkerPoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.run.v2.WorkerPools/DeleteWorkerPool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteWorkerPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.run.v2.WorkerPools/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.run.v2.WorkerPools/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.run.v2.WorkerPools/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateWorkerPoolRequest, Operation> createWorkerPoolCallable;
  private final OperationCallable<CreateWorkerPoolRequest, WorkerPool, WorkerPool>
      createWorkerPoolOperationCallable;
  private final UnaryCallable<GetWorkerPoolRequest, WorkerPool> getWorkerPoolCallable;
  private final UnaryCallable<ListWorkerPoolsRequest, ListWorkerPoolsResponse>
      listWorkerPoolsCallable;
  private final UnaryCallable<ListWorkerPoolsRequest, ListWorkerPoolsPagedResponse>
      listWorkerPoolsPagedCallable;
  private final UnaryCallable<UpdateWorkerPoolRequest, Operation> updateWorkerPoolCallable;
  private final OperationCallable<UpdateWorkerPoolRequest, WorkerPool, WorkerPool>
      updateWorkerPoolOperationCallable;
  private final UnaryCallable<DeleteWorkerPoolRequest, Operation> deleteWorkerPoolCallable;
  private final OperationCallable<DeleteWorkerPoolRequest, WorkerPool, WorkerPool>
      deleteWorkerPoolOperationCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  private static final PathTemplate CREATE_WORKER_POOL_0_PATH_TEMPLATE =
      PathTemplate.create("projects/*/locations/{location=*}");
  private static final PathTemplate GET_WORKER_POOL_0_PATH_TEMPLATE =
      PathTemplate.create("projects/*/locations/{location=*}/**");
  private static final PathTemplate LIST_WORKER_POOLS_0_PATH_TEMPLATE =
      PathTemplate.create("projects/*/locations/{location=*}");
  private static final PathTemplate UPDATE_WORKER_POOL_0_PATH_TEMPLATE =
      PathTemplate.create("projects/*/locations/{location=*}/**");
  private static final PathTemplate DELETE_WORKER_POOL_0_PATH_TEMPLATE =
      PathTemplate.create("projects/*/locations/{location=*}/**");

  public static final GrpcWorkerPoolsStub create(WorkerPoolsStubSettings settings)
      throws IOException {
    return new GrpcWorkerPoolsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcWorkerPoolsStub create(ClientContext clientContext) throws IOException {
    return new GrpcWorkerPoolsStub(WorkerPoolsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcWorkerPoolsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcWorkerPoolsStub(
        WorkerPoolsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcWorkerPoolsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcWorkerPoolsStub(WorkerPoolsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcWorkerPoolsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcWorkerPoolsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcWorkerPoolsStub(
      WorkerPoolsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateWorkerPoolRequest, Operation> createWorkerPoolTransportSettings =
        GrpcCallSettings.<CreateWorkerPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(createWorkerPoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getParent(), "location", CREATE_WORKER_POOL_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetWorkerPoolRequest, WorkerPool> getWorkerPoolTransportSettings =
        GrpcCallSettings.<GetWorkerPoolRequest, WorkerPool>newBuilder()
            .setMethodDescriptor(getWorkerPoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "location", GET_WORKER_POOL_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListWorkerPoolsRequest, ListWorkerPoolsResponse>
        listWorkerPoolsTransportSettings =
            GrpcCallSettings.<ListWorkerPoolsRequest, ListWorkerPoolsResponse>newBuilder()
                .setMethodDescriptor(listWorkerPoolsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getParent(), "location", LIST_WORKER_POOLS_0_PATH_TEMPLATE);
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateWorkerPoolRequest, Operation> updateWorkerPoolTransportSettings =
        GrpcCallSettings.<UpdateWorkerPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(updateWorkerPoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  if (request.getWorkerPool() != null) {
                    builder.add(
                        request.getWorkerPool().getName(),
                        "location",
                        UPDATE_WORKER_POOL_0_PATH_TEMPLATE);
                  }
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteWorkerPoolRequest, Operation> deleteWorkerPoolTransportSettings =
        GrpcCallSettings.<DeleteWorkerPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteWorkerPoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "location", DELETE_WORKER_POOL_0_PATH_TEMPLATE);
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

    this.createWorkerPoolCallable =
        callableFactory.createUnaryCallable(
            createWorkerPoolTransportSettings, settings.createWorkerPoolSettings(), clientContext);
    this.createWorkerPoolOperationCallable =
        callableFactory.createOperationCallable(
            createWorkerPoolTransportSettings,
            settings.createWorkerPoolOperationSettings(),
            clientContext,
            operationsStub);
    this.getWorkerPoolCallable =
        callableFactory.createUnaryCallable(
            getWorkerPoolTransportSettings, settings.getWorkerPoolSettings(), clientContext);
    this.listWorkerPoolsCallable =
        callableFactory.createUnaryCallable(
            listWorkerPoolsTransportSettings, settings.listWorkerPoolsSettings(), clientContext);
    this.listWorkerPoolsPagedCallable =
        callableFactory.createPagedCallable(
            listWorkerPoolsTransportSettings, settings.listWorkerPoolsSettings(), clientContext);
    this.updateWorkerPoolCallable =
        callableFactory.createUnaryCallable(
            updateWorkerPoolTransportSettings, settings.updateWorkerPoolSettings(), clientContext);
    this.updateWorkerPoolOperationCallable =
        callableFactory.createOperationCallable(
            updateWorkerPoolTransportSettings,
            settings.updateWorkerPoolOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteWorkerPoolCallable =
        callableFactory.createUnaryCallable(
            deleteWorkerPoolTransportSettings, settings.deleteWorkerPoolSettings(), clientContext);
    this.deleteWorkerPoolOperationCallable =
        callableFactory.createOperationCallable(
            deleteWorkerPoolTransportSettings,
            settings.deleteWorkerPoolOperationSettings(),
            clientContext,
            operationsStub);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
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
  public UnaryCallable<CreateWorkerPoolRequest, Operation> createWorkerPoolCallable() {
    return createWorkerPoolCallable;
  }

  @Override
  public OperationCallable<CreateWorkerPoolRequest, WorkerPool, WorkerPool>
      createWorkerPoolOperationCallable() {
    return createWorkerPoolOperationCallable;
  }

  @Override
  public UnaryCallable<GetWorkerPoolRequest, WorkerPool> getWorkerPoolCallable() {
    return getWorkerPoolCallable;
  }

  @Override
  public UnaryCallable<ListWorkerPoolsRequest, ListWorkerPoolsResponse> listWorkerPoolsCallable() {
    return listWorkerPoolsCallable;
  }

  @Override
  public UnaryCallable<ListWorkerPoolsRequest, ListWorkerPoolsPagedResponse>
      listWorkerPoolsPagedCallable() {
    return listWorkerPoolsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateWorkerPoolRequest, Operation> updateWorkerPoolCallable() {
    return updateWorkerPoolCallable;
  }

  @Override
  public OperationCallable<UpdateWorkerPoolRequest, WorkerPool, WorkerPool>
      updateWorkerPoolOperationCallable() {
    return updateWorkerPoolOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteWorkerPoolRequest, Operation> deleteWorkerPoolCallable() {
    return deleteWorkerPoolCallable;
  }

  @Override
  public OperationCallable<DeleteWorkerPoolRequest, WorkerPool, WorkerPool>
      deleteWorkerPoolOperationCallable() {
    return deleteWorkerPoolOperationCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
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
