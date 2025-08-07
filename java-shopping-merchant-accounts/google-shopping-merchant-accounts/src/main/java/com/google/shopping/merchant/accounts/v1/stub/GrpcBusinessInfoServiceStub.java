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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.shopping.merchant.accounts.v1.BusinessInfo;
import com.google.shopping.merchant.accounts.v1.GetBusinessInfoRequest;
import com.google.shopping.merchant.accounts.v1.UpdateBusinessInfoRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the BusinessInfoService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcBusinessInfoServiceStub extends BusinessInfoServiceStub {
  private static final MethodDescriptor<GetBusinessInfoRequest, BusinessInfo>
      getBusinessInfoMethodDescriptor =
          MethodDescriptor.<GetBusinessInfoRequest, BusinessInfo>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.BusinessInfoService/GetBusinessInfo")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBusinessInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BusinessInfo.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateBusinessInfoRequest, BusinessInfo>
      updateBusinessInfoMethodDescriptor =
          MethodDescriptor.<UpdateBusinessInfoRequest, BusinessInfo>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.BusinessInfoService/UpdateBusinessInfo")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateBusinessInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BusinessInfo.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetBusinessInfoRequest, BusinessInfo> getBusinessInfoCallable;
  private final UnaryCallable<UpdateBusinessInfoRequest, BusinessInfo> updateBusinessInfoCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcBusinessInfoServiceStub create(BusinessInfoServiceStubSettings settings)
      throws IOException {
    return new GrpcBusinessInfoServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcBusinessInfoServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcBusinessInfoServiceStub(
        BusinessInfoServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcBusinessInfoServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcBusinessInfoServiceStub(
        BusinessInfoServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcBusinessInfoServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcBusinessInfoServiceStub(
      BusinessInfoServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcBusinessInfoServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcBusinessInfoServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcBusinessInfoServiceStub(
      BusinessInfoServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetBusinessInfoRequest, BusinessInfo> getBusinessInfoTransportSettings =
        GrpcCallSettings.<GetBusinessInfoRequest, BusinessInfo>newBuilder()
            .setMethodDescriptor(getBusinessInfoMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateBusinessInfoRequest, BusinessInfo> updateBusinessInfoTransportSettings =
        GrpcCallSettings.<UpdateBusinessInfoRequest, BusinessInfo>newBuilder()
            .setMethodDescriptor(updateBusinessInfoMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "business_info.name", String.valueOf(request.getBusinessInfo().getName()));
                  return builder.build();
                })
            .build();

    this.getBusinessInfoCallable =
        callableFactory.createUnaryCallable(
            getBusinessInfoTransportSettings, settings.getBusinessInfoSettings(), clientContext);
    this.updateBusinessInfoCallable =
        callableFactory.createUnaryCallable(
            updateBusinessInfoTransportSettings,
            settings.updateBusinessInfoSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetBusinessInfoRequest, BusinessInfo> getBusinessInfoCallable() {
    return getBusinessInfoCallable;
  }

  @Override
  public UnaryCallable<UpdateBusinessInfoRequest, BusinessInfo> updateBusinessInfoCallable() {
    return updateBusinessInfoCallable;
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
