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

package com.google.iam.v2.stub;

import static com.google.iam.v2.PoliciesClient.ListPoliciesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v2.CreatePolicyRequest;
import com.google.iam.v2.DeletePolicyRequest;
import com.google.iam.v2.GetPolicyRequest;
import com.google.iam.v2.ListPoliciesRequest;
import com.google.iam.v2.ListPoliciesResponse;
import com.google.iam.v2.Policy;
import com.google.iam.v2.PolicyOperationMetadata;
import com.google.iam.v2.UpdatePolicyRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Policies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcPoliciesStub extends PoliciesStub {
  private static final MethodDescriptor<ListPoliciesRequest, ListPoliciesResponse>
      listPoliciesMethodDescriptor =
          MethodDescriptor.<ListPoliciesRequest, ListPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v2.Policies/ListPolicies")
              .setRequestMarshaller(ProtoUtils.marshaller(ListPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPoliciesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPolicyRequest, Policy> getPolicyMethodDescriptor =
      MethodDescriptor.<GetPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v2.Policies/GetPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreatePolicyRequest, Operation>
      createPolicyMethodDescriptor =
          MethodDescriptor.<CreatePolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v2.Policies/CreatePolicy")
              .setRequestMarshaller(ProtoUtils.marshaller(CreatePolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdatePolicyRequest, Operation>
      updatePolicyMethodDescriptor =
          MethodDescriptor.<UpdatePolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v2.Policies/UpdatePolicy")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdatePolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeletePolicyRequest, Operation>
      deletePolicyMethodDescriptor =
          MethodDescriptor.<DeletePolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v2.Policies/DeletePolicy")
              .setRequestMarshaller(ProtoUtils.marshaller(DeletePolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListPoliciesRequest, ListPoliciesResponse> listPoliciesCallable;
  private final UnaryCallable<ListPoliciesRequest, ListPoliciesPagedResponse>
      listPoliciesPagedCallable;
  private final UnaryCallable<GetPolicyRequest, Policy> getPolicyCallable;
  private final UnaryCallable<CreatePolicyRequest, Operation> createPolicyCallable;
  private final OperationCallable<CreatePolicyRequest, Policy, PolicyOperationMetadata>
      createPolicyOperationCallable;
  private final UnaryCallable<UpdatePolicyRequest, Operation> updatePolicyCallable;
  private final OperationCallable<UpdatePolicyRequest, Policy, PolicyOperationMetadata>
      updatePolicyOperationCallable;
  private final UnaryCallable<DeletePolicyRequest, Operation> deletePolicyCallable;
  private final OperationCallable<DeletePolicyRequest, Policy, PolicyOperationMetadata>
      deletePolicyOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcPoliciesStub create(PoliciesStubSettings settings) throws IOException {
    return new GrpcPoliciesStub(settings, ClientContext.create(settings));
  }

  public static final GrpcPoliciesStub create(ClientContext clientContext) throws IOException {
    return new GrpcPoliciesStub(PoliciesStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcPoliciesStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcPoliciesStub(
        PoliciesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcPoliciesStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcPoliciesStub(PoliciesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcPoliciesCallableFactory());
  }

  /**
   * Constructs an instance of GrpcPoliciesStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcPoliciesStub(
      PoliciesStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListPoliciesRequest, ListPoliciesResponse> listPoliciesTransportSettings =
        GrpcCallSettings.<ListPoliciesRequest, ListPoliciesResponse>newBuilder()
            .setMethodDescriptor(listPoliciesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetPolicyRequest, Policy> getPolicyTransportSettings =
        GrpcCallSettings.<GetPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreatePolicyRequest, Operation> createPolicyTransportSettings =
        GrpcCallSettings.<CreatePolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(createPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdatePolicyRequest, Operation> updatePolicyTransportSettings =
        GrpcCallSettings.<UpdatePolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(updatePolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("policy.name", String.valueOf(request.getPolicy().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeletePolicyRequest, Operation> deletePolicyTransportSettings =
        GrpcCallSettings.<DeletePolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(deletePolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.listPoliciesCallable =
        callableFactory.createUnaryCallable(
            listPoliciesTransportSettings, settings.listPoliciesSettings(), clientContext);
    this.listPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listPoliciesTransportSettings, settings.listPoliciesSettings(), clientContext);
    this.getPolicyCallable =
        callableFactory.createUnaryCallable(
            getPolicyTransportSettings, settings.getPolicySettings(), clientContext);
    this.createPolicyCallable =
        callableFactory.createUnaryCallable(
            createPolicyTransportSettings, settings.createPolicySettings(), clientContext);
    this.createPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createPolicyTransportSettings,
            settings.createPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.updatePolicyCallable =
        callableFactory.createUnaryCallable(
            updatePolicyTransportSettings, settings.updatePolicySettings(), clientContext);
    this.updatePolicyOperationCallable =
        callableFactory.createOperationCallable(
            updatePolicyTransportSettings,
            settings.updatePolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.deletePolicyCallable =
        callableFactory.createUnaryCallable(
            deletePolicyTransportSettings, settings.deletePolicySettings(), clientContext);
    this.deletePolicyOperationCallable =
        callableFactory.createOperationCallable(
            deletePolicyTransportSettings,
            settings.deletePolicyOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListPoliciesRequest, ListPoliciesResponse> listPoliciesCallable() {
    return listPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListPoliciesRequest, ListPoliciesPagedResponse> listPoliciesPagedCallable() {
    return listPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<GetPolicyRequest, Policy> getPolicyCallable() {
    return getPolicyCallable;
  }

  @Override
  public UnaryCallable<CreatePolicyRequest, Operation> createPolicyCallable() {
    return createPolicyCallable;
  }

  @Override
  public OperationCallable<CreatePolicyRequest, Policy, PolicyOperationMetadata>
      createPolicyOperationCallable() {
    return createPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdatePolicyRequest, Operation> updatePolicyCallable() {
    return updatePolicyCallable;
  }

  @Override
  public OperationCallable<UpdatePolicyRequest, Policy, PolicyOperationMetadata>
      updatePolicyOperationCallable() {
    return updatePolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeletePolicyRequest, Operation> deletePolicyCallable() {
    return deletePolicyCallable;
  }

  @Override
  public OperationCallable<DeletePolicyRequest, Policy, PolicyOperationMetadata>
      deletePolicyOperationCallable() {
    return deletePolicyOperationCallable;
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
