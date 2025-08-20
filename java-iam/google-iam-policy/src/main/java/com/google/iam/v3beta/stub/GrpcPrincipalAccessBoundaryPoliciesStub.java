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

package com.google.iam.v3beta.stub;

import static com.google.iam.v3beta.PrincipalAccessBoundaryPoliciesClient.ListPrincipalAccessBoundaryPoliciesPagedResponse;
import static com.google.iam.v3beta.PrincipalAccessBoundaryPoliciesClient.SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.iam.v3beta.CreatePrincipalAccessBoundaryPolicyRequest;
import com.google.iam.v3beta.DeletePrincipalAccessBoundaryPolicyRequest;
import com.google.iam.v3beta.GetPrincipalAccessBoundaryPolicyRequest;
import com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesRequest;
import com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesResponse;
import com.google.iam.v3beta.OperationMetadata;
import com.google.iam.v3beta.PrincipalAccessBoundaryPolicy;
import com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsRequest;
import com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsResponse;
import com.google.iam.v3beta.UpdatePrincipalAccessBoundaryPolicyRequest;
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
 * gRPC stub implementation for the PrincipalAccessBoundaryPolicies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcPrincipalAccessBoundaryPoliciesStub extends PrincipalAccessBoundaryPoliciesStub {
  private static final MethodDescriptor<CreatePrincipalAccessBoundaryPolicyRequest, Operation>
      createPrincipalAccessBoundaryPolicyMethodDescriptor =
          MethodDescriptor.<CreatePrincipalAccessBoundaryPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.iam.v3beta.PrincipalAccessBoundaryPolicies/CreatePrincipalAccessBoundaryPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreatePrincipalAccessBoundaryPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GetPrincipalAccessBoundaryPolicyRequest, PrincipalAccessBoundaryPolicy>
      getPrincipalAccessBoundaryPolicyMethodDescriptor =
          MethodDescriptor
              .<GetPrincipalAccessBoundaryPolicyRequest, PrincipalAccessBoundaryPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.iam.v3beta.PrincipalAccessBoundaryPolicies/GetPrincipalAccessBoundaryPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetPrincipalAccessBoundaryPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(PrincipalAccessBoundaryPolicy.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdatePrincipalAccessBoundaryPolicyRequest, Operation>
      updatePrincipalAccessBoundaryPolicyMethodDescriptor =
          MethodDescriptor.<UpdatePrincipalAccessBoundaryPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.iam.v3beta.PrincipalAccessBoundaryPolicies/UpdatePrincipalAccessBoundaryPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      UpdatePrincipalAccessBoundaryPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeletePrincipalAccessBoundaryPolicyRequest, Operation>
      deletePrincipalAccessBoundaryPolicyMethodDescriptor =
          MethodDescriptor.<DeletePrincipalAccessBoundaryPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.iam.v3beta.PrincipalAccessBoundaryPolicies/DeletePrincipalAccessBoundaryPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DeletePrincipalAccessBoundaryPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListPrincipalAccessBoundaryPoliciesRequest, ListPrincipalAccessBoundaryPoliciesResponse>
      listPrincipalAccessBoundaryPoliciesMethodDescriptor =
          MethodDescriptor
              .<ListPrincipalAccessBoundaryPoliciesRequest,
                  ListPrincipalAccessBoundaryPoliciesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.iam.v3beta.PrincipalAccessBoundaryPolicies/ListPrincipalAccessBoundaryPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListPrincipalAccessBoundaryPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListPrincipalAccessBoundaryPoliciesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          SearchPrincipalAccessBoundaryPolicyBindingsRequest,
          SearchPrincipalAccessBoundaryPolicyBindingsResponse>
      searchPrincipalAccessBoundaryPolicyBindingsMethodDescriptor =
          MethodDescriptor
              .<SearchPrincipalAccessBoundaryPolicyBindingsRequest,
                  SearchPrincipalAccessBoundaryPolicyBindingsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.iam.v3beta.PrincipalAccessBoundaryPolicies/SearchPrincipalAccessBoundaryPolicyBindings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      SearchPrincipalAccessBoundaryPolicyBindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      SearchPrincipalAccessBoundaryPolicyBindingsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreatePrincipalAccessBoundaryPolicyRequest, Operation>
      createPrincipalAccessBoundaryPolicyCallable;
  private final OperationCallable<
          CreatePrincipalAccessBoundaryPolicyRequest,
          PrincipalAccessBoundaryPolicy,
          OperationMetadata>
      createPrincipalAccessBoundaryPolicyOperationCallable;
  private final UnaryCallable<
          GetPrincipalAccessBoundaryPolicyRequest, PrincipalAccessBoundaryPolicy>
      getPrincipalAccessBoundaryPolicyCallable;
  private final UnaryCallable<UpdatePrincipalAccessBoundaryPolicyRequest, Operation>
      updatePrincipalAccessBoundaryPolicyCallable;
  private final OperationCallable<
          UpdatePrincipalAccessBoundaryPolicyRequest,
          PrincipalAccessBoundaryPolicy,
          OperationMetadata>
      updatePrincipalAccessBoundaryPolicyOperationCallable;
  private final UnaryCallable<DeletePrincipalAccessBoundaryPolicyRequest, Operation>
      deletePrincipalAccessBoundaryPolicyCallable;
  private final OperationCallable<
          DeletePrincipalAccessBoundaryPolicyRequest, Empty, OperationMetadata>
      deletePrincipalAccessBoundaryPolicyOperationCallable;
  private final UnaryCallable<
          ListPrincipalAccessBoundaryPoliciesRequest, ListPrincipalAccessBoundaryPoliciesResponse>
      listPrincipalAccessBoundaryPoliciesCallable;
  private final UnaryCallable<
          ListPrincipalAccessBoundaryPoliciesRequest,
          ListPrincipalAccessBoundaryPoliciesPagedResponse>
      listPrincipalAccessBoundaryPoliciesPagedCallable;
  private final UnaryCallable<
          SearchPrincipalAccessBoundaryPolicyBindingsRequest,
          SearchPrincipalAccessBoundaryPolicyBindingsResponse>
      searchPrincipalAccessBoundaryPolicyBindingsCallable;
  private final UnaryCallable<
          SearchPrincipalAccessBoundaryPolicyBindingsRequest,
          SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse>
      searchPrincipalAccessBoundaryPolicyBindingsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcPrincipalAccessBoundaryPoliciesStub create(
      PrincipalAccessBoundaryPoliciesStubSettings settings) throws IOException {
    return new GrpcPrincipalAccessBoundaryPoliciesStub(settings, ClientContext.create(settings));
  }

  public static final GrpcPrincipalAccessBoundaryPoliciesStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcPrincipalAccessBoundaryPoliciesStub(
        PrincipalAccessBoundaryPoliciesStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcPrincipalAccessBoundaryPoliciesStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcPrincipalAccessBoundaryPoliciesStub(
        PrincipalAccessBoundaryPoliciesStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcPrincipalAccessBoundaryPoliciesStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcPrincipalAccessBoundaryPoliciesStub(
      PrincipalAccessBoundaryPoliciesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcPrincipalAccessBoundaryPoliciesCallableFactory());
  }

  /**
   * Constructs an instance of GrpcPrincipalAccessBoundaryPoliciesStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcPrincipalAccessBoundaryPoliciesStub(
      PrincipalAccessBoundaryPoliciesStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreatePrincipalAccessBoundaryPolicyRequest, Operation>
        createPrincipalAccessBoundaryPolicyTransportSettings =
            GrpcCallSettings.<CreatePrincipalAccessBoundaryPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(createPrincipalAccessBoundaryPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetPrincipalAccessBoundaryPolicyRequest, PrincipalAccessBoundaryPolicy>
        getPrincipalAccessBoundaryPolicyTransportSettings =
            GrpcCallSettings
                .<GetPrincipalAccessBoundaryPolicyRequest, PrincipalAccessBoundaryPolicy>
                    newBuilder()
                .setMethodDescriptor(getPrincipalAccessBoundaryPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdatePrincipalAccessBoundaryPolicyRequest, Operation>
        updatePrincipalAccessBoundaryPolicyTransportSettings =
            GrpcCallSettings.<UpdatePrincipalAccessBoundaryPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(updatePrincipalAccessBoundaryPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "principal_access_boundary_policy.name",
                          String.valueOf(request.getPrincipalAccessBoundaryPolicy().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeletePrincipalAccessBoundaryPolicyRequest, Operation>
        deletePrincipalAccessBoundaryPolicyTransportSettings =
            GrpcCallSettings.<DeletePrincipalAccessBoundaryPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(deletePrincipalAccessBoundaryPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            ListPrincipalAccessBoundaryPoliciesRequest, ListPrincipalAccessBoundaryPoliciesResponse>
        listPrincipalAccessBoundaryPoliciesTransportSettings =
            GrpcCallSettings
                .<ListPrincipalAccessBoundaryPoliciesRequest,
                    ListPrincipalAccessBoundaryPoliciesResponse>
                    newBuilder()
                .setMethodDescriptor(listPrincipalAccessBoundaryPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            SearchPrincipalAccessBoundaryPolicyBindingsRequest,
            SearchPrincipalAccessBoundaryPolicyBindingsResponse>
        searchPrincipalAccessBoundaryPolicyBindingsTransportSettings =
            GrpcCallSettings
                .<SearchPrincipalAccessBoundaryPolicyBindingsRequest,
                    SearchPrincipalAccessBoundaryPolicyBindingsResponse>
                    newBuilder()
                .setMethodDescriptor(searchPrincipalAccessBoundaryPolicyBindingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.createPrincipalAccessBoundaryPolicyCallable =
        callableFactory.createUnaryCallable(
            createPrincipalAccessBoundaryPolicyTransportSettings,
            settings.createPrincipalAccessBoundaryPolicySettings(),
            clientContext);
    this.createPrincipalAccessBoundaryPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createPrincipalAccessBoundaryPolicyTransportSettings,
            settings.createPrincipalAccessBoundaryPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.getPrincipalAccessBoundaryPolicyCallable =
        callableFactory.createUnaryCallable(
            getPrincipalAccessBoundaryPolicyTransportSettings,
            settings.getPrincipalAccessBoundaryPolicySettings(),
            clientContext);
    this.updatePrincipalAccessBoundaryPolicyCallable =
        callableFactory.createUnaryCallable(
            updatePrincipalAccessBoundaryPolicyTransportSettings,
            settings.updatePrincipalAccessBoundaryPolicySettings(),
            clientContext);
    this.updatePrincipalAccessBoundaryPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updatePrincipalAccessBoundaryPolicyTransportSettings,
            settings.updatePrincipalAccessBoundaryPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.deletePrincipalAccessBoundaryPolicyCallable =
        callableFactory.createUnaryCallable(
            deletePrincipalAccessBoundaryPolicyTransportSettings,
            settings.deletePrincipalAccessBoundaryPolicySettings(),
            clientContext);
    this.deletePrincipalAccessBoundaryPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deletePrincipalAccessBoundaryPolicyTransportSettings,
            settings.deletePrincipalAccessBoundaryPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.listPrincipalAccessBoundaryPoliciesCallable =
        callableFactory.createUnaryCallable(
            listPrincipalAccessBoundaryPoliciesTransportSettings,
            settings.listPrincipalAccessBoundaryPoliciesSettings(),
            clientContext);
    this.listPrincipalAccessBoundaryPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listPrincipalAccessBoundaryPoliciesTransportSettings,
            settings.listPrincipalAccessBoundaryPoliciesSettings(),
            clientContext);
    this.searchPrincipalAccessBoundaryPolicyBindingsCallable =
        callableFactory.createUnaryCallable(
            searchPrincipalAccessBoundaryPolicyBindingsTransportSettings,
            settings.searchPrincipalAccessBoundaryPolicyBindingsSettings(),
            clientContext);
    this.searchPrincipalAccessBoundaryPolicyBindingsPagedCallable =
        callableFactory.createPagedCallable(
            searchPrincipalAccessBoundaryPolicyBindingsTransportSettings,
            settings.searchPrincipalAccessBoundaryPolicyBindingsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreatePrincipalAccessBoundaryPolicyRequest, Operation>
      createPrincipalAccessBoundaryPolicyCallable() {
    return createPrincipalAccessBoundaryPolicyCallable;
  }

  @Override
  public OperationCallable<
          CreatePrincipalAccessBoundaryPolicyRequest,
          PrincipalAccessBoundaryPolicy,
          OperationMetadata>
      createPrincipalAccessBoundaryPolicyOperationCallable() {
    return createPrincipalAccessBoundaryPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<GetPrincipalAccessBoundaryPolicyRequest, PrincipalAccessBoundaryPolicy>
      getPrincipalAccessBoundaryPolicyCallable() {
    return getPrincipalAccessBoundaryPolicyCallable;
  }

  @Override
  public UnaryCallable<UpdatePrincipalAccessBoundaryPolicyRequest, Operation>
      updatePrincipalAccessBoundaryPolicyCallable() {
    return updatePrincipalAccessBoundaryPolicyCallable;
  }

  @Override
  public OperationCallable<
          UpdatePrincipalAccessBoundaryPolicyRequest,
          PrincipalAccessBoundaryPolicy,
          OperationMetadata>
      updatePrincipalAccessBoundaryPolicyOperationCallable() {
    return updatePrincipalAccessBoundaryPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeletePrincipalAccessBoundaryPolicyRequest, Operation>
      deletePrincipalAccessBoundaryPolicyCallable() {
    return deletePrincipalAccessBoundaryPolicyCallable;
  }

  @Override
  public OperationCallable<DeletePrincipalAccessBoundaryPolicyRequest, Empty, OperationMetadata>
      deletePrincipalAccessBoundaryPolicyOperationCallable() {
    return deletePrincipalAccessBoundaryPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<
          ListPrincipalAccessBoundaryPoliciesRequest, ListPrincipalAccessBoundaryPoliciesResponse>
      listPrincipalAccessBoundaryPoliciesCallable() {
    return listPrincipalAccessBoundaryPoliciesCallable;
  }

  @Override
  public UnaryCallable<
          ListPrincipalAccessBoundaryPoliciesRequest,
          ListPrincipalAccessBoundaryPoliciesPagedResponse>
      listPrincipalAccessBoundaryPoliciesPagedCallable() {
    return listPrincipalAccessBoundaryPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<
          SearchPrincipalAccessBoundaryPolicyBindingsRequest,
          SearchPrincipalAccessBoundaryPolicyBindingsResponse>
      searchPrincipalAccessBoundaryPolicyBindingsCallable() {
    return searchPrincipalAccessBoundaryPolicyBindingsCallable;
  }

  @Override
  public UnaryCallable<
          SearchPrincipalAccessBoundaryPolicyBindingsRequest,
          SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse>
      searchPrincipalAccessBoundaryPolicyBindingsPagedCallable() {
    return searchPrincipalAccessBoundaryPolicyBindingsPagedCallable;
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
