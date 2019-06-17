/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.gaming.v1alpha.stub;

import static com.google.cloud.gaming.v1alpha.AllocationPoliciesServiceClient.ListAllocationPoliciesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gaming.v1alpha.AllocationPolicy;
import com.google.cloud.gaming.v1alpha.CreateAllocationPolicyRequest;
import com.google.cloud.gaming.v1alpha.DeleteAllocationPolicyRequest;
import com.google.cloud.gaming.v1alpha.GetAllocationPolicyRequest;
import com.google.cloud.gaming.v1alpha.ListAllocationPoliciesRequest;
import com.google.cloud.gaming.v1alpha.ListAllocationPoliciesResponse;
import com.google.cloud.gaming.v1alpha.UpdateAllocationPolicyRequest;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for gameservices API (prod).
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcAllocationPoliciesServiceStub extends AllocationPoliciesServiceStub {

  private static final MethodDescriptor<
          ListAllocationPoliciesRequest, ListAllocationPoliciesResponse>
      listAllocationPoliciesMethodDescriptor =
          MethodDescriptor
              .<ListAllocationPoliciesRequest, ListAllocationPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1alpha.AllocationPoliciesService/ListAllocationPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAllocationPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAllocationPoliciesResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetAllocationPolicyRequest, AllocationPolicy>
      getAllocationPolicyMethodDescriptor =
          MethodDescriptor.<GetAllocationPolicyRequest, AllocationPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1alpha.AllocationPoliciesService/GetAllocationPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAllocationPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AllocationPolicy.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<CreateAllocationPolicyRequest, Operation>
      createAllocationPolicyMethodDescriptor =
          MethodDescriptor.<CreateAllocationPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1alpha.AllocationPoliciesService/CreateAllocationPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAllocationPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<DeleteAllocationPolicyRequest, Operation>
      deleteAllocationPolicyMethodDescriptor =
          MethodDescriptor.<DeleteAllocationPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1alpha.AllocationPoliciesService/DeleteAllocationPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAllocationPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<UpdateAllocationPolicyRequest, Operation>
      updateAllocationPolicyMethodDescriptor =
          MethodDescriptor.<UpdateAllocationPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1alpha.AllocationPoliciesService/UpdateAllocationPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAllocationPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;

  private final UnaryCallable<ListAllocationPoliciesRequest, ListAllocationPoliciesResponse>
      listAllocationPoliciesCallable;
  private final UnaryCallable<ListAllocationPoliciesRequest, ListAllocationPoliciesPagedResponse>
      listAllocationPoliciesPagedCallable;
  private final UnaryCallable<GetAllocationPolicyRequest, AllocationPolicy>
      getAllocationPolicyCallable;
  private final UnaryCallable<CreateAllocationPolicyRequest, Operation>
      createAllocationPolicyCallable;
  private final OperationCallable<CreateAllocationPolicyRequest, AllocationPolicy, Empty>
      createAllocationPolicyOperationCallable;
  private final UnaryCallable<DeleteAllocationPolicyRequest, Operation>
      deleteAllocationPolicyCallable;
  private final OperationCallable<DeleteAllocationPolicyRequest, Empty, Empty>
      deleteAllocationPolicyOperationCallable;
  private final UnaryCallable<UpdateAllocationPolicyRequest, Operation>
      updateAllocationPolicyCallable;
  private final OperationCallable<UpdateAllocationPolicyRequest, AllocationPolicy, Empty>
      updateAllocationPolicyOperationCallable;

  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAllocationPoliciesServiceStub create(
      AllocationPoliciesServiceStubSettings settings) throws IOException {
    return new GrpcAllocationPoliciesServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAllocationPoliciesServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAllocationPoliciesServiceStub(
        AllocationPoliciesServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAllocationPoliciesServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAllocationPoliciesServiceStub(
        AllocationPoliciesServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAllocationPoliciesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAllocationPoliciesServiceStub(
      AllocationPoliciesServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAllocationPoliciesServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAllocationPoliciesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAllocationPoliciesServiceStub(
      AllocationPoliciesServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListAllocationPoliciesRequest, ListAllocationPoliciesResponse>
        listAllocationPoliciesTransportSettings =
            GrpcCallSettings
                .<ListAllocationPoliciesRequest, ListAllocationPoliciesResponse>newBuilder()
                .setMethodDescriptor(listAllocationPoliciesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListAllocationPoliciesRequest>() {
                      @Override
                      public Map<String, String> extract(ListAllocationPoliciesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetAllocationPolicyRequest, AllocationPolicy>
        getAllocationPolicyTransportSettings =
            GrpcCallSettings.<GetAllocationPolicyRequest, AllocationPolicy>newBuilder()
                .setMethodDescriptor(getAllocationPolicyMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GetAllocationPolicyRequest>() {
                      @Override
                      public Map<String, String> extract(GetAllocationPolicyRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<CreateAllocationPolicyRequest, Operation>
        createAllocationPolicyTransportSettings =
            GrpcCallSettings.<CreateAllocationPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(createAllocationPolicyMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CreateAllocationPolicyRequest>() {
                      @Override
                      public Map<String, String> extract(CreateAllocationPolicyRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeleteAllocationPolicyRequest, Operation>
        deleteAllocationPolicyTransportSettings =
            GrpcCallSettings.<DeleteAllocationPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteAllocationPolicyMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<DeleteAllocationPolicyRequest>() {
                      @Override
                      public Map<String, String> extract(DeleteAllocationPolicyRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<UpdateAllocationPolicyRequest, Operation>
        updateAllocationPolicyTransportSettings =
            GrpcCallSettings.<UpdateAllocationPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(updateAllocationPolicyMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<UpdateAllocationPolicyRequest>() {
                      @Override
                      public Map<String, String> extract(UpdateAllocationPolicyRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put(
                            "allocation_policy.name",
                            String.valueOf(request.getAllocationPolicy().getName()));
                        return params.build();
                      }
                    })
                .build();

    this.listAllocationPoliciesCallable =
        callableFactory.createUnaryCallable(
            listAllocationPoliciesTransportSettings,
            settings.listAllocationPoliciesSettings(),
            clientContext);
    this.listAllocationPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listAllocationPoliciesTransportSettings,
            settings.listAllocationPoliciesSettings(),
            clientContext);
    this.getAllocationPolicyCallable =
        callableFactory.createUnaryCallable(
            getAllocationPolicyTransportSettings,
            settings.getAllocationPolicySettings(),
            clientContext);
    this.createAllocationPolicyCallable =
        callableFactory.createUnaryCallable(
            createAllocationPolicyTransportSettings,
            settings.createAllocationPolicySettings(),
            clientContext);
    this.createAllocationPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createAllocationPolicyTransportSettings,
            settings.createAllocationPolicyOperationSettings(),
            clientContext,
            this.operationsStub);
    this.deleteAllocationPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteAllocationPolicyTransportSettings,
            settings.deleteAllocationPolicySettings(),
            clientContext);
    this.deleteAllocationPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteAllocationPolicyTransportSettings,
            settings.deleteAllocationPolicyOperationSettings(),
            clientContext,
            this.operationsStub);
    this.updateAllocationPolicyCallable =
        callableFactory.createUnaryCallable(
            updateAllocationPolicyTransportSettings,
            settings.updateAllocationPolicySettings(),
            clientContext);
    this.updateAllocationPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateAllocationPolicyTransportSettings,
            settings.updateAllocationPolicyOperationSettings(),
            clientContext,
            this.operationsStub);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<ListAllocationPoliciesRequest, ListAllocationPoliciesPagedResponse>
      listAllocationPoliciesPagedCallable() {
    return listAllocationPoliciesPagedCallable;
  }

  public UnaryCallable<ListAllocationPoliciesRequest, ListAllocationPoliciesResponse>
      listAllocationPoliciesCallable() {
    return listAllocationPoliciesCallable;
  }

  public UnaryCallable<GetAllocationPolicyRequest, AllocationPolicy> getAllocationPolicyCallable() {
    return getAllocationPolicyCallable;
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<CreateAllocationPolicyRequest, AllocationPolicy, Empty>
      createAllocationPolicyOperationCallable() {
    return createAllocationPolicyOperationCallable;
  }

  public UnaryCallable<CreateAllocationPolicyRequest, Operation> createAllocationPolicyCallable() {
    return createAllocationPolicyCallable;
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<DeleteAllocationPolicyRequest, Empty, Empty>
      deleteAllocationPolicyOperationCallable() {
    return deleteAllocationPolicyOperationCallable;
  }

  public UnaryCallable<DeleteAllocationPolicyRequest, Operation> deleteAllocationPolicyCallable() {
    return deleteAllocationPolicyCallable;
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<UpdateAllocationPolicyRequest, AllocationPolicy, Empty>
      updateAllocationPolicyOperationCallable() {
    return updateAllocationPolicyOperationCallable;
  }

  public UnaryCallable<UpdateAllocationPolicyRequest, Operation> updateAllocationPolicyCallable() {
    return updateAllocationPolicyCallable;
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
