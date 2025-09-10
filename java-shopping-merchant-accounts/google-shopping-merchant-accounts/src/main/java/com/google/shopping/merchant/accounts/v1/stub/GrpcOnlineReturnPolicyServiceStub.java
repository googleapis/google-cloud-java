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

package com.google.shopping.merchant.accounts.v1.stub;

import static com.google.shopping.merchant.accounts.v1.OnlineReturnPolicyServiceClient.ListOnlineReturnPoliciesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.accounts.v1.CreateOnlineReturnPolicyRequest;
import com.google.shopping.merchant.accounts.v1.DeleteOnlineReturnPolicyRequest;
import com.google.shopping.merchant.accounts.v1.GetOnlineReturnPolicyRequest;
import com.google.shopping.merchant.accounts.v1.ListOnlineReturnPoliciesRequest;
import com.google.shopping.merchant.accounts.v1.ListOnlineReturnPoliciesResponse;
import com.google.shopping.merchant.accounts.v1.OnlineReturnPolicy;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the OnlineReturnPolicyService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcOnlineReturnPolicyServiceStub extends OnlineReturnPolicyServiceStub {
  private static final MethodDescriptor<GetOnlineReturnPolicyRequest, OnlineReturnPolicy>
      getOnlineReturnPolicyMethodDescriptor =
          MethodDescriptor.<GetOnlineReturnPolicyRequest, OnlineReturnPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.OnlineReturnPolicyService/GetOnlineReturnPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetOnlineReturnPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(OnlineReturnPolicy.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListOnlineReturnPoliciesRequest, ListOnlineReturnPoliciesResponse>
      listOnlineReturnPoliciesMethodDescriptor =
          MethodDescriptor
              .<ListOnlineReturnPoliciesRequest, ListOnlineReturnPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.OnlineReturnPolicyService/ListOnlineReturnPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListOnlineReturnPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListOnlineReturnPoliciesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateOnlineReturnPolicyRequest, OnlineReturnPolicy>
      createOnlineReturnPolicyMethodDescriptor =
          MethodDescriptor.<CreateOnlineReturnPolicyRequest, OnlineReturnPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.OnlineReturnPolicyService/CreateOnlineReturnPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateOnlineReturnPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(OnlineReturnPolicy.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteOnlineReturnPolicyRequest, Empty>
      deleteOnlineReturnPolicyMethodDescriptor =
          MethodDescriptor.<DeleteOnlineReturnPolicyRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.OnlineReturnPolicyService/DeleteOnlineReturnPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteOnlineReturnPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GetOnlineReturnPolicyRequest, OnlineReturnPolicy>
      getOnlineReturnPolicyCallable;
  private final UnaryCallable<ListOnlineReturnPoliciesRequest, ListOnlineReturnPoliciesResponse>
      listOnlineReturnPoliciesCallable;
  private final UnaryCallable<
          ListOnlineReturnPoliciesRequest, ListOnlineReturnPoliciesPagedResponse>
      listOnlineReturnPoliciesPagedCallable;
  private final UnaryCallable<CreateOnlineReturnPolicyRequest, OnlineReturnPolicy>
      createOnlineReturnPolicyCallable;
  private final UnaryCallable<DeleteOnlineReturnPolicyRequest, Empty>
      deleteOnlineReturnPolicyCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcOnlineReturnPolicyServiceStub create(
      OnlineReturnPolicyServiceStubSettings settings) throws IOException {
    return new GrpcOnlineReturnPolicyServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcOnlineReturnPolicyServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcOnlineReturnPolicyServiceStub(
        OnlineReturnPolicyServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcOnlineReturnPolicyServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcOnlineReturnPolicyServiceStub(
        OnlineReturnPolicyServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcOnlineReturnPolicyServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcOnlineReturnPolicyServiceStub(
      OnlineReturnPolicyServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcOnlineReturnPolicyServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcOnlineReturnPolicyServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcOnlineReturnPolicyServiceStub(
      OnlineReturnPolicyServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetOnlineReturnPolicyRequest, OnlineReturnPolicy>
        getOnlineReturnPolicyTransportSettings =
            GrpcCallSettings.<GetOnlineReturnPolicyRequest, OnlineReturnPolicy>newBuilder()
                .setMethodDescriptor(getOnlineReturnPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListOnlineReturnPoliciesRequest, ListOnlineReturnPoliciesResponse>
        listOnlineReturnPoliciesTransportSettings =
            GrpcCallSettings
                .<ListOnlineReturnPoliciesRequest, ListOnlineReturnPoliciesResponse>newBuilder()
                .setMethodDescriptor(listOnlineReturnPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateOnlineReturnPolicyRequest, OnlineReturnPolicy>
        createOnlineReturnPolicyTransportSettings =
            GrpcCallSettings.<CreateOnlineReturnPolicyRequest, OnlineReturnPolicy>newBuilder()
                .setMethodDescriptor(createOnlineReturnPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteOnlineReturnPolicyRequest, Empty>
        deleteOnlineReturnPolicyTransportSettings =
            GrpcCallSettings.<DeleteOnlineReturnPolicyRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteOnlineReturnPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.getOnlineReturnPolicyCallable =
        callableFactory.createUnaryCallable(
            getOnlineReturnPolicyTransportSettings,
            settings.getOnlineReturnPolicySettings(),
            clientContext);
    this.listOnlineReturnPoliciesCallable =
        callableFactory.createUnaryCallable(
            listOnlineReturnPoliciesTransportSettings,
            settings.listOnlineReturnPoliciesSettings(),
            clientContext);
    this.listOnlineReturnPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listOnlineReturnPoliciesTransportSettings,
            settings.listOnlineReturnPoliciesSettings(),
            clientContext);
    this.createOnlineReturnPolicyCallable =
        callableFactory.createUnaryCallable(
            createOnlineReturnPolicyTransportSettings,
            settings.createOnlineReturnPolicySettings(),
            clientContext);
    this.deleteOnlineReturnPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteOnlineReturnPolicyTransportSettings,
            settings.deleteOnlineReturnPolicySettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetOnlineReturnPolicyRequest, OnlineReturnPolicy>
      getOnlineReturnPolicyCallable() {
    return getOnlineReturnPolicyCallable;
  }

  @Override
  public UnaryCallable<ListOnlineReturnPoliciesRequest, ListOnlineReturnPoliciesResponse>
      listOnlineReturnPoliciesCallable() {
    return listOnlineReturnPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListOnlineReturnPoliciesRequest, ListOnlineReturnPoliciesPagedResponse>
      listOnlineReturnPoliciesPagedCallable() {
    return listOnlineReturnPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateOnlineReturnPolicyRequest, OnlineReturnPolicy>
      createOnlineReturnPolicyCallable() {
    return createOnlineReturnPolicyCallable;
  }

  @Override
  public UnaryCallable<DeleteOnlineReturnPolicyRequest, Empty> deleteOnlineReturnPolicyCallable() {
    return deleteOnlineReturnPolicyCallable;
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
