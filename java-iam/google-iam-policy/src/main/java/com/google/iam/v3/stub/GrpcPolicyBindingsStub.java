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

package com.google.iam.v3.stub;

import static com.google.iam.v3.PolicyBindingsClient.ListPolicyBindingsPagedResponse;
import static com.google.iam.v3.PolicyBindingsClient.SearchTargetPolicyBindingsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.iam.v3.CreatePolicyBindingRequest;
import com.google.iam.v3.DeletePolicyBindingRequest;
import com.google.iam.v3.GetPolicyBindingRequest;
import com.google.iam.v3.ListPolicyBindingsRequest;
import com.google.iam.v3.ListPolicyBindingsResponse;
import com.google.iam.v3.OperationMetadata;
import com.google.iam.v3.PolicyBinding;
import com.google.iam.v3.SearchTargetPolicyBindingsRequest;
import com.google.iam.v3.SearchTargetPolicyBindingsResponse;
import com.google.iam.v3.UpdatePolicyBindingRequest;
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
 * gRPC stub implementation for the PolicyBindings service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcPolicyBindingsStub extends PolicyBindingsStub {
  private static final MethodDescriptor<CreatePolicyBindingRequest, Operation>
      createPolicyBindingMethodDescriptor =
          MethodDescriptor.<CreatePolicyBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v3.PolicyBindings/CreatePolicyBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePolicyBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPolicyBindingRequest, PolicyBinding>
      getPolicyBindingMethodDescriptor =
          MethodDescriptor.<GetPolicyBindingRequest, PolicyBinding>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v3.PolicyBindings/GetPolicyBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetPolicyBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PolicyBinding.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdatePolicyBindingRequest, Operation>
      updatePolicyBindingMethodDescriptor =
          MethodDescriptor.<UpdatePolicyBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v3.PolicyBindings/UpdatePolicyBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdatePolicyBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeletePolicyBindingRequest, Operation>
      deletePolicyBindingMethodDescriptor =
          MethodDescriptor.<DeletePolicyBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v3.PolicyBindings/DeletePolicyBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePolicyBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListPolicyBindingsRequest, ListPolicyBindingsResponse>
      listPolicyBindingsMethodDescriptor =
          MethodDescriptor.<ListPolicyBindingsRequest, ListPolicyBindingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v3.PolicyBindings/ListPolicyBindings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPolicyBindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPolicyBindingsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          SearchTargetPolicyBindingsRequest, SearchTargetPolicyBindingsResponse>
      searchTargetPolicyBindingsMethodDescriptor =
          MethodDescriptor
              .<SearchTargetPolicyBindingsRequest, SearchTargetPolicyBindingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v3.PolicyBindings/SearchTargetPolicyBindings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchTargetPolicyBindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchTargetPolicyBindingsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreatePolicyBindingRequest, Operation> createPolicyBindingCallable;
  private final OperationCallable<CreatePolicyBindingRequest, PolicyBinding, OperationMetadata>
      createPolicyBindingOperationCallable;
  private final UnaryCallable<GetPolicyBindingRequest, PolicyBinding> getPolicyBindingCallable;
  private final UnaryCallable<UpdatePolicyBindingRequest, Operation> updatePolicyBindingCallable;
  private final OperationCallable<UpdatePolicyBindingRequest, PolicyBinding, OperationMetadata>
      updatePolicyBindingOperationCallable;
  private final UnaryCallable<DeletePolicyBindingRequest, Operation> deletePolicyBindingCallable;
  private final OperationCallable<DeletePolicyBindingRequest, Empty, OperationMetadata>
      deletePolicyBindingOperationCallable;
  private final UnaryCallable<ListPolicyBindingsRequest, ListPolicyBindingsResponse>
      listPolicyBindingsCallable;
  private final UnaryCallable<ListPolicyBindingsRequest, ListPolicyBindingsPagedResponse>
      listPolicyBindingsPagedCallable;
  private final UnaryCallable<SearchTargetPolicyBindingsRequest, SearchTargetPolicyBindingsResponse>
      searchTargetPolicyBindingsCallable;
  private final UnaryCallable<
          SearchTargetPolicyBindingsRequest, SearchTargetPolicyBindingsPagedResponse>
      searchTargetPolicyBindingsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcPolicyBindingsStub create(PolicyBindingsStubSettings settings)
      throws IOException {
    return new GrpcPolicyBindingsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcPolicyBindingsStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcPolicyBindingsStub(
        PolicyBindingsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcPolicyBindingsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcPolicyBindingsStub(
        PolicyBindingsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcPolicyBindingsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcPolicyBindingsStub(PolicyBindingsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcPolicyBindingsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcPolicyBindingsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcPolicyBindingsStub(
      PolicyBindingsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreatePolicyBindingRequest, Operation> createPolicyBindingTransportSettings =
        GrpcCallSettings.<CreatePolicyBindingRequest, Operation>newBuilder()
            .setMethodDescriptor(createPolicyBindingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetPolicyBindingRequest, PolicyBinding> getPolicyBindingTransportSettings =
        GrpcCallSettings.<GetPolicyBindingRequest, PolicyBinding>newBuilder()
            .setMethodDescriptor(getPolicyBindingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdatePolicyBindingRequest, Operation> updatePolicyBindingTransportSettings =
        GrpcCallSettings.<UpdatePolicyBindingRequest, Operation>newBuilder()
            .setMethodDescriptor(updatePolicyBindingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "policy_binding.name", String.valueOf(request.getPolicyBinding().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeletePolicyBindingRequest, Operation> deletePolicyBindingTransportSettings =
        GrpcCallSettings.<DeletePolicyBindingRequest, Operation>newBuilder()
            .setMethodDescriptor(deletePolicyBindingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListPolicyBindingsRequest, ListPolicyBindingsResponse>
        listPolicyBindingsTransportSettings =
            GrpcCallSettings.<ListPolicyBindingsRequest, ListPolicyBindingsResponse>newBuilder()
                .setMethodDescriptor(listPolicyBindingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SearchTargetPolicyBindingsRequest, SearchTargetPolicyBindingsResponse>
        searchTargetPolicyBindingsTransportSettings =
            GrpcCallSettings
                .<SearchTargetPolicyBindingsRequest, SearchTargetPolicyBindingsResponse>newBuilder()
                .setMethodDescriptor(searchTargetPolicyBindingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.createPolicyBindingCallable =
        callableFactory.createUnaryCallable(
            createPolicyBindingTransportSettings,
            settings.createPolicyBindingSettings(),
            clientContext);
    this.createPolicyBindingOperationCallable =
        callableFactory.createOperationCallable(
            createPolicyBindingTransportSettings,
            settings.createPolicyBindingOperationSettings(),
            clientContext,
            operationsStub);
    this.getPolicyBindingCallable =
        callableFactory.createUnaryCallable(
            getPolicyBindingTransportSettings, settings.getPolicyBindingSettings(), clientContext);
    this.updatePolicyBindingCallable =
        callableFactory.createUnaryCallable(
            updatePolicyBindingTransportSettings,
            settings.updatePolicyBindingSettings(),
            clientContext);
    this.updatePolicyBindingOperationCallable =
        callableFactory.createOperationCallable(
            updatePolicyBindingTransportSettings,
            settings.updatePolicyBindingOperationSettings(),
            clientContext,
            operationsStub);
    this.deletePolicyBindingCallable =
        callableFactory.createUnaryCallable(
            deletePolicyBindingTransportSettings,
            settings.deletePolicyBindingSettings(),
            clientContext);
    this.deletePolicyBindingOperationCallable =
        callableFactory.createOperationCallable(
            deletePolicyBindingTransportSettings,
            settings.deletePolicyBindingOperationSettings(),
            clientContext,
            operationsStub);
    this.listPolicyBindingsCallable =
        callableFactory.createUnaryCallable(
            listPolicyBindingsTransportSettings,
            settings.listPolicyBindingsSettings(),
            clientContext);
    this.listPolicyBindingsPagedCallable =
        callableFactory.createPagedCallable(
            listPolicyBindingsTransportSettings,
            settings.listPolicyBindingsSettings(),
            clientContext);
    this.searchTargetPolicyBindingsCallable =
        callableFactory.createUnaryCallable(
            searchTargetPolicyBindingsTransportSettings,
            settings.searchTargetPolicyBindingsSettings(),
            clientContext);
    this.searchTargetPolicyBindingsPagedCallable =
        callableFactory.createPagedCallable(
            searchTargetPolicyBindingsTransportSettings,
            settings.searchTargetPolicyBindingsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreatePolicyBindingRequest, Operation> createPolicyBindingCallable() {
    return createPolicyBindingCallable;
  }

  @Override
  public OperationCallable<CreatePolicyBindingRequest, PolicyBinding, OperationMetadata>
      createPolicyBindingOperationCallable() {
    return createPolicyBindingOperationCallable;
  }

  @Override
  public UnaryCallable<GetPolicyBindingRequest, PolicyBinding> getPolicyBindingCallable() {
    return getPolicyBindingCallable;
  }

  @Override
  public UnaryCallable<UpdatePolicyBindingRequest, Operation> updatePolicyBindingCallable() {
    return updatePolicyBindingCallable;
  }

  @Override
  public OperationCallable<UpdatePolicyBindingRequest, PolicyBinding, OperationMetadata>
      updatePolicyBindingOperationCallable() {
    return updatePolicyBindingOperationCallable;
  }

  @Override
  public UnaryCallable<DeletePolicyBindingRequest, Operation> deletePolicyBindingCallable() {
    return deletePolicyBindingCallable;
  }

  @Override
  public OperationCallable<DeletePolicyBindingRequest, Empty, OperationMetadata>
      deletePolicyBindingOperationCallable() {
    return deletePolicyBindingOperationCallable;
  }

  @Override
  public UnaryCallable<ListPolicyBindingsRequest, ListPolicyBindingsResponse>
      listPolicyBindingsCallable() {
    return listPolicyBindingsCallable;
  }

  @Override
  public UnaryCallable<ListPolicyBindingsRequest, ListPolicyBindingsPagedResponse>
      listPolicyBindingsPagedCallable() {
    return listPolicyBindingsPagedCallable;
  }

  @Override
  public UnaryCallable<SearchTargetPolicyBindingsRequest, SearchTargetPolicyBindingsResponse>
      searchTargetPolicyBindingsCallable() {
    return searchTargetPolicyBindingsCallable;
  }

  @Override
  public UnaryCallable<SearchTargetPolicyBindingsRequest, SearchTargetPolicyBindingsPagedResponse>
      searchTargetPolicyBindingsPagedCallable() {
    return searchTargetPolicyBindingsPagedCallable;
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
