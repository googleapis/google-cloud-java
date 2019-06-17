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

import static com.google.cloud.gaming.v1alpha.ScalingPoliciesServiceClient.ListScalingPoliciesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gaming.v1alpha.CreateScalingPolicyRequest;
import com.google.cloud.gaming.v1alpha.DeleteScalingPolicyRequest;
import com.google.cloud.gaming.v1alpha.GetScalingPolicyRequest;
import com.google.cloud.gaming.v1alpha.ListScalingPoliciesRequest;
import com.google.cloud.gaming.v1alpha.ListScalingPoliciesResponse;
import com.google.cloud.gaming.v1alpha.ScalingPolicy;
import com.google.cloud.gaming.v1alpha.UpdateScalingPolicyRequest;
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
public class GrpcScalingPoliciesServiceStub extends ScalingPoliciesServiceStub {

  private static final MethodDescriptor<ListScalingPoliciesRequest, ListScalingPoliciesResponse>
      listScalingPoliciesMethodDescriptor =
          MethodDescriptor.<ListScalingPoliciesRequest, ListScalingPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1alpha.ScalingPoliciesService/ListScalingPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListScalingPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListScalingPoliciesResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetScalingPolicyRequest, ScalingPolicy>
      getScalingPolicyMethodDescriptor =
          MethodDescriptor.<GetScalingPolicyRequest, ScalingPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1alpha.ScalingPoliciesService/GetScalingPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetScalingPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ScalingPolicy.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<CreateScalingPolicyRequest, Operation>
      createScalingPolicyMethodDescriptor =
          MethodDescriptor.<CreateScalingPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1alpha.ScalingPoliciesService/CreateScalingPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateScalingPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<DeleteScalingPolicyRequest, Operation>
      deleteScalingPolicyMethodDescriptor =
          MethodDescriptor.<DeleteScalingPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1alpha.ScalingPoliciesService/DeleteScalingPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteScalingPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<UpdateScalingPolicyRequest, Operation>
      updateScalingPolicyMethodDescriptor =
          MethodDescriptor.<UpdateScalingPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1alpha.ScalingPoliciesService/UpdateScalingPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateScalingPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;

  private final UnaryCallable<ListScalingPoliciesRequest, ListScalingPoliciesResponse>
      listScalingPoliciesCallable;
  private final UnaryCallable<ListScalingPoliciesRequest, ListScalingPoliciesPagedResponse>
      listScalingPoliciesPagedCallable;
  private final UnaryCallable<GetScalingPolicyRequest, ScalingPolicy> getScalingPolicyCallable;
  private final UnaryCallable<CreateScalingPolicyRequest, Operation> createScalingPolicyCallable;
  private final OperationCallable<CreateScalingPolicyRequest, ScalingPolicy, Empty>
      createScalingPolicyOperationCallable;
  private final UnaryCallable<DeleteScalingPolicyRequest, Operation> deleteScalingPolicyCallable;
  private final OperationCallable<DeleteScalingPolicyRequest, Empty, Empty>
      deleteScalingPolicyOperationCallable;
  private final UnaryCallable<UpdateScalingPolicyRequest, Operation> updateScalingPolicyCallable;
  private final OperationCallable<UpdateScalingPolicyRequest, ScalingPolicy, Empty>
      updateScalingPolicyOperationCallable;

  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcScalingPoliciesServiceStub create(
      ScalingPoliciesServiceStubSettings settings) throws IOException {
    return new GrpcScalingPoliciesServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcScalingPoliciesServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcScalingPoliciesServiceStub(
        ScalingPoliciesServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcScalingPoliciesServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcScalingPoliciesServiceStub(
        ScalingPoliciesServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcScalingPoliciesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcScalingPoliciesServiceStub(
      ScalingPoliciesServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcScalingPoliciesServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcScalingPoliciesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcScalingPoliciesServiceStub(
      ScalingPoliciesServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListScalingPoliciesRequest, ListScalingPoliciesResponse>
        listScalingPoliciesTransportSettings =
            GrpcCallSettings.<ListScalingPoliciesRequest, ListScalingPoliciesResponse>newBuilder()
                .setMethodDescriptor(listScalingPoliciesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListScalingPoliciesRequest>() {
                      @Override
                      public Map<String, String> extract(ListScalingPoliciesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetScalingPolicyRequest, ScalingPolicy> getScalingPolicyTransportSettings =
        GrpcCallSettings.<GetScalingPolicyRequest, ScalingPolicy>newBuilder()
            .setMethodDescriptor(getScalingPolicyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetScalingPolicyRequest>() {
                  @Override
                  public Map<String, String> extract(GetScalingPolicyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateScalingPolicyRequest, Operation> createScalingPolicyTransportSettings =
        GrpcCallSettings.<CreateScalingPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(createScalingPolicyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateScalingPolicyRequest>() {
                  @Override
                  public Map<String, String> extract(CreateScalingPolicyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteScalingPolicyRequest, Operation> deleteScalingPolicyTransportSettings =
        GrpcCallSettings.<DeleteScalingPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteScalingPolicyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteScalingPolicyRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteScalingPolicyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateScalingPolicyRequest, Operation> updateScalingPolicyTransportSettings =
        GrpcCallSettings.<UpdateScalingPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(updateScalingPolicyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateScalingPolicyRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateScalingPolicyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put(
                        "scaling_policy.name",
                        String.valueOf(request.getScalingPolicy().getName()));
                    return params.build();
                  }
                })
            .build();

    this.listScalingPoliciesCallable =
        callableFactory.createUnaryCallable(
            listScalingPoliciesTransportSettings,
            settings.listScalingPoliciesSettings(),
            clientContext);
    this.listScalingPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listScalingPoliciesTransportSettings,
            settings.listScalingPoliciesSettings(),
            clientContext);
    this.getScalingPolicyCallable =
        callableFactory.createUnaryCallable(
            getScalingPolicyTransportSettings, settings.getScalingPolicySettings(), clientContext);
    this.createScalingPolicyCallable =
        callableFactory.createUnaryCallable(
            createScalingPolicyTransportSettings,
            settings.createScalingPolicySettings(),
            clientContext);
    this.createScalingPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createScalingPolicyTransportSettings,
            settings.createScalingPolicyOperationSettings(),
            clientContext,
            this.operationsStub);
    this.deleteScalingPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteScalingPolicyTransportSettings,
            settings.deleteScalingPolicySettings(),
            clientContext);
    this.deleteScalingPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteScalingPolicyTransportSettings,
            settings.deleteScalingPolicyOperationSettings(),
            clientContext,
            this.operationsStub);
    this.updateScalingPolicyCallable =
        callableFactory.createUnaryCallable(
            updateScalingPolicyTransportSettings,
            settings.updateScalingPolicySettings(),
            clientContext);
    this.updateScalingPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateScalingPolicyTransportSettings,
            settings.updateScalingPolicyOperationSettings(),
            clientContext,
            this.operationsStub);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<ListScalingPoliciesRequest, ListScalingPoliciesPagedResponse>
      listScalingPoliciesPagedCallable() {
    return listScalingPoliciesPagedCallable;
  }

  public UnaryCallable<ListScalingPoliciesRequest, ListScalingPoliciesResponse>
      listScalingPoliciesCallable() {
    return listScalingPoliciesCallable;
  }

  public UnaryCallable<GetScalingPolicyRequest, ScalingPolicy> getScalingPolicyCallable() {
    return getScalingPolicyCallable;
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<CreateScalingPolicyRequest, ScalingPolicy, Empty>
      createScalingPolicyOperationCallable() {
    return createScalingPolicyOperationCallable;
  }

  public UnaryCallable<CreateScalingPolicyRequest, Operation> createScalingPolicyCallable() {
    return createScalingPolicyCallable;
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<DeleteScalingPolicyRequest, Empty, Empty>
      deleteScalingPolicyOperationCallable() {
    return deleteScalingPolicyOperationCallable;
  }

  public UnaryCallable<DeleteScalingPolicyRequest, Operation> deleteScalingPolicyCallable() {
    return deleteScalingPolicyCallable;
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<UpdateScalingPolicyRequest, ScalingPolicy, Empty>
      updateScalingPolicyOperationCallable() {
    return updateScalingPolicyOperationCallable;
  }

  public UnaryCallable<UpdateScalingPolicyRequest, Operation> updateScalingPolicyCallable() {
    return updateScalingPolicyCallable;
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
