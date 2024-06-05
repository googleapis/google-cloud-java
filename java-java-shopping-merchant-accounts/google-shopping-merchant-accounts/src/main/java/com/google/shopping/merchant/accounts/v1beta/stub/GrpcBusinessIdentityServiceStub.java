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

package com.google.shopping.merchant.accounts.v1beta.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.shopping.merchant.accounts.v1beta.BusinessIdentity;
import com.google.shopping.merchant.accounts.v1beta.GetBusinessIdentityRequest;
import com.google.shopping.merchant.accounts.v1beta.UpdateBusinessIdentityRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the BusinessIdentityService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcBusinessIdentityServiceStub extends BusinessIdentityServiceStub {
  private static final MethodDescriptor<GetBusinessIdentityRequest, BusinessIdentity>
      getBusinessIdentityMethodDescriptor =
          MethodDescriptor.<GetBusinessIdentityRequest, BusinessIdentity>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.BusinessIdentityService/GetBusinessIdentity")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBusinessIdentityRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BusinessIdentity.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateBusinessIdentityRequest, BusinessIdentity>
      updateBusinessIdentityMethodDescriptor =
          MethodDescriptor.<UpdateBusinessIdentityRequest, BusinessIdentity>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.BusinessIdentityService/UpdateBusinessIdentity")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateBusinessIdentityRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BusinessIdentity.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetBusinessIdentityRequest, BusinessIdentity>
      getBusinessIdentityCallable;
  private final UnaryCallable<UpdateBusinessIdentityRequest, BusinessIdentity>
      updateBusinessIdentityCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcBusinessIdentityServiceStub create(
      BusinessIdentityServiceStubSettings settings) throws IOException {
    return new GrpcBusinessIdentityServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcBusinessIdentityServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcBusinessIdentityServiceStub(
        BusinessIdentityServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcBusinessIdentityServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcBusinessIdentityServiceStub(
        BusinessIdentityServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcBusinessIdentityServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcBusinessIdentityServiceStub(
      BusinessIdentityServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcBusinessIdentityServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcBusinessIdentityServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcBusinessIdentityServiceStub(
      BusinessIdentityServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetBusinessIdentityRequest, BusinessIdentity>
        getBusinessIdentityTransportSettings =
            GrpcCallSettings.<GetBusinessIdentityRequest, BusinessIdentity>newBuilder()
                .setMethodDescriptor(getBusinessIdentityMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateBusinessIdentityRequest, BusinessIdentity>
        updateBusinessIdentityTransportSettings =
            GrpcCallSettings.<UpdateBusinessIdentityRequest, BusinessIdentity>newBuilder()
                .setMethodDescriptor(updateBusinessIdentityMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "business_identity.name",
                          String.valueOf(request.getBusinessIdentity().getName()));
                      return builder.build();
                    })
                .build();

    this.getBusinessIdentityCallable =
        callableFactory.createUnaryCallable(
            getBusinessIdentityTransportSettings,
            settings.getBusinessIdentitySettings(),
            clientContext);
    this.updateBusinessIdentityCallable =
        callableFactory.createUnaryCallable(
            updateBusinessIdentityTransportSettings,
            settings.updateBusinessIdentitySettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetBusinessIdentityRequest, BusinessIdentity> getBusinessIdentityCallable() {
    return getBusinessIdentityCallable;
  }

  @Override
  public UnaryCallable<UpdateBusinessIdentityRequest, BusinessIdentity>
      updateBusinessIdentityCallable() {
    return updateBusinessIdentityCallable;
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
