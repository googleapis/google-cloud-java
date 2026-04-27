/*
 * Copyright 2026 Google LLC
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

import static com.google.iam.v3beta.AccessPoliciesClient.ListAccessPoliciesPagedResponse;
import static com.google.iam.v3beta.AccessPoliciesClient.SearchAccessPolicyBindingsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.iam.v3beta.AccessPolicy;
import com.google.iam.v3beta.CreateAccessPolicyRequest;
import com.google.iam.v3beta.DeleteAccessPolicyRequest;
import com.google.iam.v3beta.GetAccessPolicyRequest;
import com.google.iam.v3beta.ListAccessPoliciesRequest;
import com.google.iam.v3beta.ListAccessPoliciesResponse;
import com.google.iam.v3beta.OperationMetadata;
import com.google.iam.v3beta.SearchAccessPolicyBindingsRequest;
import com.google.iam.v3beta.SearchAccessPolicyBindingsResponse;
import com.google.iam.v3beta.UpdateAccessPolicyRequest;
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
 * gRPC stub implementation for the AccessPolicies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcAccessPoliciesStub extends AccessPoliciesStub {
  private static final MethodDescriptor<CreateAccessPolicyRequest, Operation>
      createAccessPolicyMethodDescriptor =
          MethodDescriptor.<CreateAccessPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v3beta.AccessPolicies/CreateAccessPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAccessPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAccessPolicyRequest, AccessPolicy>
      getAccessPolicyMethodDescriptor =
          MethodDescriptor.<GetAccessPolicyRequest, AccessPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v3beta.AccessPolicies/GetAccessPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAccessPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AccessPolicy.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateAccessPolicyRequest, Operation>
      updateAccessPolicyMethodDescriptor =
          MethodDescriptor.<UpdateAccessPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v3beta.AccessPolicies/UpdateAccessPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAccessPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteAccessPolicyRequest, Operation>
      deleteAccessPolicyMethodDescriptor =
          MethodDescriptor.<DeleteAccessPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v3beta.AccessPolicies/DeleteAccessPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAccessPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListAccessPoliciesRequest, ListAccessPoliciesResponse>
      listAccessPoliciesMethodDescriptor =
          MethodDescriptor.<ListAccessPoliciesRequest, ListAccessPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v3beta.AccessPolicies/ListAccessPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAccessPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAccessPoliciesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          SearchAccessPolicyBindingsRequest, SearchAccessPolicyBindingsResponse>
      searchAccessPolicyBindingsMethodDescriptor =
          MethodDescriptor
              .<SearchAccessPolicyBindingsRequest, SearchAccessPolicyBindingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v3beta.AccessPolicies/SearchAccessPolicyBindings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchAccessPolicyBindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchAccessPolicyBindingsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateAccessPolicyRequest, Operation> createAccessPolicyCallable;
  private final OperationCallable<CreateAccessPolicyRequest, AccessPolicy, OperationMetadata>
      createAccessPolicyOperationCallable;
  private final UnaryCallable<GetAccessPolicyRequest, AccessPolicy> getAccessPolicyCallable;
  private final UnaryCallable<UpdateAccessPolicyRequest, Operation> updateAccessPolicyCallable;
  private final OperationCallable<UpdateAccessPolicyRequest, AccessPolicy, OperationMetadata>
      updateAccessPolicyOperationCallable;
  private final UnaryCallable<DeleteAccessPolicyRequest, Operation> deleteAccessPolicyCallable;
  private final OperationCallable<DeleteAccessPolicyRequest, Empty, OperationMetadata>
      deleteAccessPolicyOperationCallable;
  private final UnaryCallable<ListAccessPoliciesRequest, ListAccessPoliciesResponse>
      listAccessPoliciesCallable;
  private final UnaryCallable<ListAccessPoliciesRequest, ListAccessPoliciesPagedResponse>
      listAccessPoliciesPagedCallable;
  private final UnaryCallable<SearchAccessPolicyBindingsRequest, SearchAccessPolicyBindingsResponse>
      searchAccessPolicyBindingsCallable;
  private final UnaryCallable<
          SearchAccessPolicyBindingsRequest, SearchAccessPolicyBindingsPagedResponse>
      searchAccessPolicyBindingsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAccessPoliciesStub create(AccessPoliciesStubSettings settings)
      throws IOException {
    return new GrpcAccessPoliciesStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAccessPoliciesStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAccessPoliciesStub(
        AccessPoliciesStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAccessPoliciesStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAccessPoliciesStub(
        AccessPoliciesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAccessPoliciesStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAccessPoliciesStub(AccessPoliciesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAccessPoliciesCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAccessPoliciesStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAccessPoliciesStub(
      AccessPoliciesStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateAccessPolicyRequest, Operation> createAccessPolicyTransportSettings =
        GrpcCallSettings.<CreateAccessPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(createAccessPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetAccessPolicyRequest, AccessPolicy> getAccessPolicyTransportSettings =
        GrpcCallSettings.<GetAccessPolicyRequest, AccessPolicy>newBuilder()
            .setMethodDescriptor(getAccessPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<UpdateAccessPolicyRequest, Operation> updateAccessPolicyTransportSettings =
        GrpcCallSettings.<UpdateAccessPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAccessPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "access_policy.name", String.valueOf(request.getAccessPolicy().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteAccessPolicyRequest, Operation> deleteAccessPolicyTransportSettings =
        GrpcCallSettings.<DeleteAccessPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAccessPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListAccessPoliciesRequest, ListAccessPoliciesResponse>
        listAccessPoliciesTransportSettings =
            GrpcCallSettings.<ListAccessPoliciesRequest, ListAccessPoliciesResponse>newBuilder()
                .setMethodDescriptor(listAccessPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<SearchAccessPolicyBindingsRequest, SearchAccessPolicyBindingsResponse>
        searchAccessPolicyBindingsTransportSettings =
            GrpcCallSettings
                .<SearchAccessPolicyBindingsRequest, SearchAccessPolicyBindingsResponse>newBuilder()
                .setMethodDescriptor(searchAccessPolicyBindingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();

    this.createAccessPolicyCallable =
        callableFactory.createUnaryCallable(
            createAccessPolicyTransportSettings,
            settings.createAccessPolicySettings(),
            clientContext);
    this.createAccessPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createAccessPolicyTransportSettings,
            settings.createAccessPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.getAccessPolicyCallable =
        callableFactory.createUnaryCallable(
            getAccessPolicyTransportSettings, settings.getAccessPolicySettings(), clientContext);
    this.updateAccessPolicyCallable =
        callableFactory.createUnaryCallable(
            updateAccessPolicyTransportSettings,
            settings.updateAccessPolicySettings(),
            clientContext);
    this.updateAccessPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateAccessPolicyTransportSettings,
            settings.updateAccessPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteAccessPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteAccessPolicyTransportSettings,
            settings.deleteAccessPolicySettings(),
            clientContext);
    this.deleteAccessPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteAccessPolicyTransportSettings,
            settings.deleteAccessPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.listAccessPoliciesCallable =
        callableFactory.createUnaryCallable(
            listAccessPoliciesTransportSettings,
            settings.listAccessPoliciesSettings(),
            clientContext);
    this.listAccessPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listAccessPoliciesTransportSettings,
            settings.listAccessPoliciesSettings(),
            clientContext);
    this.searchAccessPolicyBindingsCallable =
        callableFactory.createUnaryCallable(
            searchAccessPolicyBindingsTransportSettings,
            settings.searchAccessPolicyBindingsSettings(),
            clientContext);
    this.searchAccessPolicyBindingsPagedCallable =
        callableFactory.createPagedCallable(
            searchAccessPolicyBindingsTransportSettings,
            settings.searchAccessPolicyBindingsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateAccessPolicyRequest, Operation> createAccessPolicyCallable() {
    return createAccessPolicyCallable;
  }

  @Override
  public OperationCallable<CreateAccessPolicyRequest, AccessPolicy, OperationMetadata>
      createAccessPolicyOperationCallable() {
    return createAccessPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<GetAccessPolicyRequest, AccessPolicy> getAccessPolicyCallable() {
    return getAccessPolicyCallable;
  }

  @Override
  public UnaryCallable<UpdateAccessPolicyRequest, Operation> updateAccessPolicyCallable() {
    return updateAccessPolicyCallable;
  }

  @Override
  public OperationCallable<UpdateAccessPolicyRequest, AccessPolicy, OperationMetadata>
      updateAccessPolicyOperationCallable() {
    return updateAccessPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAccessPolicyRequest, Operation> deleteAccessPolicyCallable() {
    return deleteAccessPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteAccessPolicyRequest, Empty, OperationMetadata>
      deleteAccessPolicyOperationCallable() {
    return deleteAccessPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<ListAccessPoliciesRequest, ListAccessPoliciesResponse>
      listAccessPoliciesCallable() {
    return listAccessPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListAccessPoliciesRequest, ListAccessPoliciesPagedResponse>
      listAccessPoliciesPagedCallable() {
    return listAccessPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<SearchAccessPolicyBindingsRequest, SearchAccessPolicyBindingsResponse>
      searchAccessPolicyBindingsCallable() {
    return searchAccessPolicyBindingsCallable;
  }

  @Override
  public UnaryCallable<SearchAccessPolicyBindingsRequest, SearchAccessPolicyBindingsPagedResponse>
      searchAccessPolicyBindingsPagedCallable() {
    return searchAccessPolicyBindingsPagedCallable;
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
