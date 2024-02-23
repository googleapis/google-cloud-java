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

package com.google.cloud.orgpolicy.v2.stub;

import static com.google.cloud.orgpolicy.v2.OrgPolicyClient.ListConstraintsPagedResponse;
import static com.google.cloud.orgpolicy.v2.OrgPolicyClient.ListCustomConstraintsPagedResponse;
import static com.google.cloud.orgpolicy.v2.OrgPolicyClient.ListPoliciesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.orgpolicy.v2.CreateCustomConstraintRequest;
import com.google.cloud.orgpolicy.v2.CreatePolicyRequest;
import com.google.cloud.orgpolicy.v2.CustomConstraint;
import com.google.cloud.orgpolicy.v2.DeleteCustomConstraintRequest;
import com.google.cloud.orgpolicy.v2.DeletePolicyRequest;
import com.google.cloud.orgpolicy.v2.GetCustomConstraintRequest;
import com.google.cloud.orgpolicy.v2.GetEffectivePolicyRequest;
import com.google.cloud.orgpolicy.v2.GetPolicyRequest;
import com.google.cloud.orgpolicy.v2.ListConstraintsRequest;
import com.google.cloud.orgpolicy.v2.ListConstraintsResponse;
import com.google.cloud.orgpolicy.v2.ListCustomConstraintsRequest;
import com.google.cloud.orgpolicy.v2.ListCustomConstraintsResponse;
import com.google.cloud.orgpolicy.v2.ListPoliciesRequest;
import com.google.cloud.orgpolicy.v2.ListPoliciesResponse;
import com.google.cloud.orgpolicy.v2.Policy;
import com.google.cloud.orgpolicy.v2.UpdateCustomConstraintRequest;
import com.google.cloud.orgpolicy.v2.UpdatePolicyRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the OrgPolicy service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcOrgPolicyStub extends OrgPolicyStub {
  private static final MethodDescriptor<ListConstraintsRequest, ListConstraintsResponse>
      listConstraintsMethodDescriptor =
          MethodDescriptor.<ListConstraintsRequest, ListConstraintsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.orgpolicy.v2.OrgPolicy/ListConstraints")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConstraintsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConstraintsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListPoliciesRequest, ListPoliciesResponse>
      listPoliciesMethodDescriptor =
          MethodDescriptor.<ListPoliciesRequest, ListPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.orgpolicy.v2.OrgPolicy/ListPolicies")
              .setRequestMarshaller(ProtoUtils.marshaller(ListPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPoliciesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPolicyRequest, Policy> getPolicyMethodDescriptor =
      MethodDescriptor.<GetPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.orgpolicy.v2.OrgPolicy/GetPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetEffectivePolicyRequest, Policy>
      getEffectivePolicyMethodDescriptor =
          MethodDescriptor.<GetEffectivePolicyRequest, Policy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.orgpolicy.v2.OrgPolicy/GetEffectivePolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEffectivePolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreatePolicyRequest, Policy> createPolicyMethodDescriptor =
      MethodDescriptor.<CreatePolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.orgpolicy.v2.OrgPolicy/CreatePolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(CreatePolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdatePolicyRequest, Policy> updatePolicyMethodDescriptor =
      MethodDescriptor.<UpdatePolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.orgpolicy.v2.OrgPolicy/UpdatePolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdatePolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeletePolicyRequest, Empty> deletePolicyMethodDescriptor =
      MethodDescriptor.<DeletePolicyRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.orgpolicy.v2.OrgPolicy/DeletePolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(DeletePolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateCustomConstraintRequest, CustomConstraint>
      createCustomConstraintMethodDescriptor =
          MethodDescriptor.<CreateCustomConstraintRequest, CustomConstraint>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.orgpolicy.v2.OrgPolicy/CreateCustomConstraint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCustomConstraintRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CustomConstraint.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCustomConstraintRequest, CustomConstraint>
      updateCustomConstraintMethodDescriptor =
          MethodDescriptor.<UpdateCustomConstraintRequest, CustomConstraint>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.orgpolicy.v2.OrgPolicy/UpdateCustomConstraint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCustomConstraintRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CustomConstraint.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCustomConstraintRequest, CustomConstraint>
      getCustomConstraintMethodDescriptor =
          MethodDescriptor.<GetCustomConstraintRequest, CustomConstraint>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.orgpolicy.v2.OrgPolicy/GetCustomConstraint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCustomConstraintRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CustomConstraint.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListCustomConstraintsRequest, ListCustomConstraintsResponse>
      listCustomConstraintsMethodDescriptor =
          MethodDescriptor.<ListCustomConstraintsRequest, ListCustomConstraintsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.orgpolicy.v2.OrgPolicy/ListCustomConstraints")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCustomConstraintsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCustomConstraintsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteCustomConstraintRequest, Empty>
      deleteCustomConstraintMethodDescriptor =
          MethodDescriptor.<DeleteCustomConstraintRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.orgpolicy.v2.OrgPolicy/DeleteCustomConstraint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCustomConstraintRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListConstraintsRequest, ListConstraintsResponse>
      listConstraintsCallable;
  private final UnaryCallable<ListConstraintsRequest, ListConstraintsPagedResponse>
      listConstraintsPagedCallable;
  private final UnaryCallable<ListPoliciesRequest, ListPoliciesResponse> listPoliciesCallable;
  private final UnaryCallable<ListPoliciesRequest, ListPoliciesPagedResponse>
      listPoliciesPagedCallable;
  private final UnaryCallable<GetPolicyRequest, Policy> getPolicyCallable;
  private final UnaryCallable<GetEffectivePolicyRequest, Policy> getEffectivePolicyCallable;
  private final UnaryCallable<CreatePolicyRequest, Policy> createPolicyCallable;
  private final UnaryCallable<UpdatePolicyRequest, Policy> updatePolicyCallable;
  private final UnaryCallable<DeletePolicyRequest, Empty> deletePolicyCallable;
  private final UnaryCallable<CreateCustomConstraintRequest, CustomConstraint>
      createCustomConstraintCallable;
  private final UnaryCallable<UpdateCustomConstraintRequest, CustomConstraint>
      updateCustomConstraintCallable;
  private final UnaryCallable<GetCustomConstraintRequest, CustomConstraint>
      getCustomConstraintCallable;
  private final UnaryCallable<ListCustomConstraintsRequest, ListCustomConstraintsResponse>
      listCustomConstraintsCallable;
  private final UnaryCallable<ListCustomConstraintsRequest, ListCustomConstraintsPagedResponse>
      listCustomConstraintsPagedCallable;
  private final UnaryCallable<DeleteCustomConstraintRequest, Empty> deleteCustomConstraintCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcOrgPolicyStub create(OrgPolicyStubSettings settings) throws IOException {
    return new GrpcOrgPolicyStub(settings, ClientContext.create(settings));
  }

  public static final GrpcOrgPolicyStub create(ClientContext clientContext) throws IOException {
    return new GrpcOrgPolicyStub(OrgPolicyStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcOrgPolicyStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcOrgPolicyStub(
        OrgPolicyStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcOrgPolicyStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcOrgPolicyStub(OrgPolicyStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcOrgPolicyCallableFactory());
  }

  /**
   * Constructs an instance of GrpcOrgPolicyStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcOrgPolicyStub(
      OrgPolicyStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListConstraintsRequest, ListConstraintsResponse>
        listConstraintsTransportSettings =
            GrpcCallSettings.<ListConstraintsRequest, ListConstraintsResponse>newBuilder()
                .setMethodDescriptor(listConstraintsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListPoliciesRequest, ListPoliciesResponse> listPoliciesTransportSettings =
        GrpcCallSettings.<ListPoliciesRequest, ListPoliciesResponse>newBuilder()
            .setMethodDescriptor(listPoliciesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetPolicyRequest, Policy> getPolicyTransportSettings =
        GrpcCallSettings.<GetPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetEffectivePolicyRequest, Policy> getEffectivePolicyTransportSettings =
        GrpcCallSettings.<GetEffectivePolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getEffectivePolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreatePolicyRequest, Policy> createPolicyTransportSettings =
        GrpcCallSettings.<CreatePolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(createPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdatePolicyRequest, Policy> updatePolicyTransportSettings =
        GrpcCallSettings.<UpdatePolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(updatePolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("policy.name", String.valueOf(request.getPolicy().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeletePolicyRequest, Empty> deletePolicyTransportSettings =
        GrpcCallSettings.<DeletePolicyRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateCustomConstraintRequest, CustomConstraint>
        createCustomConstraintTransportSettings =
            GrpcCallSettings.<CreateCustomConstraintRequest, CustomConstraint>newBuilder()
                .setMethodDescriptor(createCustomConstraintMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateCustomConstraintRequest, CustomConstraint>
        updateCustomConstraintTransportSettings =
            GrpcCallSettings.<UpdateCustomConstraintRequest, CustomConstraint>newBuilder()
                .setMethodDescriptor(updateCustomConstraintMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "custom_constraint.name",
                          String.valueOf(request.getCustomConstraint().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetCustomConstraintRequest, CustomConstraint>
        getCustomConstraintTransportSettings =
            GrpcCallSettings.<GetCustomConstraintRequest, CustomConstraint>newBuilder()
                .setMethodDescriptor(getCustomConstraintMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListCustomConstraintsRequest, ListCustomConstraintsResponse>
        listCustomConstraintsTransportSettings =
            GrpcCallSettings
                .<ListCustomConstraintsRequest, ListCustomConstraintsResponse>newBuilder()
                .setMethodDescriptor(listCustomConstraintsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteCustomConstraintRequest, Empty> deleteCustomConstraintTransportSettings =
        GrpcCallSettings.<DeleteCustomConstraintRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteCustomConstraintMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listConstraintsCallable =
        callableFactory.createUnaryCallable(
            listConstraintsTransportSettings, settings.listConstraintsSettings(), clientContext);
    this.listConstraintsPagedCallable =
        callableFactory.createPagedCallable(
            listConstraintsTransportSettings, settings.listConstraintsSettings(), clientContext);
    this.listPoliciesCallable =
        callableFactory.createUnaryCallable(
            listPoliciesTransportSettings, settings.listPoliciesSettings(), clientContext);
    this.listPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listPoliciesTransportSettings, settings.listPoliciesSettings(), clientContext);
    this.getPolicyCallable =
        callableFactory.createUnaryCallable(
            getPolicyTransportSettings, settings.getPolicySettings(), clientContext);
    this.getEffectivePolicyCallable =
        callableFactory.createUnaryCallable(
            getEffectivePolicyTransportSettings,
            settings.getEffectivePolicySettings(),
            clientContext);
    this.createPolicyCallable =
        callableFactory.createUnaryCallable(
            createPolicyTransportSettings, settings.createPolicySettings(), clientContext);
    this.updatePolicyCallable =
        callableFactory.createUnaryCallable(
            updatePolicyTransportSettings, settings.updatePolicySettings(), clientContext);
    this.deletePolicyCallable =
        callableFactory.createUnaryCallable(
            deletePolicyTransportSettings, settings.deletePolicySettings(), clientContext);
    this.createCustomConstraintCallable =
        callableFactory.createUnaryCallable(
            createCustomConstraintTransportSettings,
            settings.createCustomConstraintSettings(),
            clientContext);
    this.updateCustomConstraintCallable =
        callableFactory.createUnaryCallable(
            updateCustomConstraintTransportSettings,
            settings.updateCustomConstraintSettings(),
            clientContext);
    this.getCustomConstraintCallable =
        callableFactory.createUnaryCallable(
            getCustomConstraintTransportSettings,
            settings.getCustomConstraintSettings(),
            clientContext);
    this.listCustomConstraintsCallable =
        callableFactory.createUnaryCallable(
            listCustomConstraintsTransportSettings,
            settings.listCustomConstraintsSettings(),
            clientContext);
    this.listCustomConstraintsPagedCallable =
        callableFactory.createPagedCallable(
            listCustomConstraintsTransportSettings,
            settings.listCustomConstraintsSettings(),
            clientContext);
    this.deleteCustomConstraintCallable =
        callableFactory.createUnaryCallable(
            deleteCustomConstraintTransportSettings,
            settings.deleteCustomConstraintSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListConstraintsRequest, ListConstraintsResponse> listConstraintsCallable() {
    return listConstraintsCallable;
  }

  @Override
  public UnaryCallable<ListConstraintsRequest, ListConstraintsPagedResponse>
      listConstraintsPagedCallable() {
    return listConstraintsPagedCallable;
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
  public UnaryCallable<GetEffectivePolicyRequest, Policy> getEffectivePolicyCallable() {
    return getEffectivePolicyCallable;
  }

  @Override
  public UnaryCallable<CreatePolicyRequest, Policy> createPolicyCallable() {
    return createPolicyCallable;
  }

  @Override
  public UnaryCallable<UpdatePolicyRequest, Policy> updatePolicyCallable() {
    return updatePolicyCallable;
  }

  @Override
  public UnaryCallable<DeletePolicyRequest, Empty> deletePolicyCallable() {
    return deletePolicyCallable;
  }

  @Override
  public UnaryCallable<CreateCustomConstraintRequest, CustomConstraint>
      createCustomConstraintCallable() {
    return createCustomConstraintCallable;
  }

  @Override
  public UnaryCallable<UpdateCustomConstraintRequest, CustomConstraint>
      updateCustomConstraintCallable() {
    return updateCustomConstraintCallable;
  }

  @Override
  public UnaryCallable<GetCustomConstraintRequest, CustomConstraint> getCustomConstraintCallable() {
    return getCustomConstraintCallable;
  }

  @Override
  public UnaryCallable<ListCustomConstraintsRequest, ListCustomConstraintsResponse>
      listCustomConstraintsCallable() {
    return listCustomConstraintsCallable;
  }

  @Override
  public UnaryCallable<ListCustomConstraintsRequest, ListCustomConstraintsPagedResponse>
      listCustomConstraintsPagedCallable() {
    return listCustomConstraintsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteCustomConstraintRequest, Empty> deleteCustomConstraintCallable() {
    return deleteCustomConstraintCallable;
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
