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

package com.google.shopping.merchant.loyaltycustomers.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.shopping.merchant.loyaltycustomers.v1.ManageLoyaltyCustomerMatchRequest;
import com.google.shopping.merchant.loyaltycustomers.v1.ManageLoyaltyCustomerMatchResponse;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the LoyaltyCustomerMatchService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GrpcLoyaltyCustomerMatchServiceStub extends LoyaltyCustomerMatchServiceStub {
  private static final MethodDescriptor<
          ManageLoyaltyCustomerMatchRequest, ManageLoyaltyCustomerMatchResponse>
      manageLoyaltyCustomerMatchMethodDescriptor =
          MethodDescriptor
              .<ManageLoyaltyCustomerMatchRequest, ManageLoyaltyCustomerMatchResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.loyaltycustomers.v1.LoyaltyCustomerMatchService/ManageLoyaltyCustomerMatch")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ManageLoyaltyCustomerMatchRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ManageLoyaltyCustomerMatchResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<ManageLoyaltyCustomerMatchRequest, ManageLoyaltyCustomerMatchResponse>
      manageLoyaltyCustomerMatchCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcLoyaltyCustomerMatchServiceStub create(
      LoyaltyCustomerMatchServiceStubSettings settings) throws IOException {
    return new GrpcLoyaltyCustomerMatchServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcLoyaltyCustomerMatchServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcLoyaltyCustomerMatchServiceStub(
        LoyaltyCustomerMatchServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcLoyaltyCustomerMatchServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcLoyaltyCustomerMatchServiceStub(
        LoyaltyCustomerMatchServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcLoyaltyCustomerMatchServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcLoyaltyCustomerMatchServiceStub(
      LoyaltyCustomerMatchServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcLoyaltyCustomerMatchServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcLoyaltyCustomerMatchServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcLoyaltyCustomerMatchServiceStub(
      LoyaltyCustomerMatchServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ManageLoyaltyCustomerMatchRequest, ManageLoyaltyCustomerMatchResponse>
        manageLoyaltyCustomerMatchTransportSettings =
            GrpcCallSettings
                .<ManageLoyaltyCustomerMatchRequest, ManageLoyaltyCustomerMatchResponse>newBuilder()
                .setMethodDescriptor(manageLoyaltyCustomerMatchMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.manageLoyaltyCustomerMatchCallable =
        callableFactory.createUnaryCallable(
            manageLoyaltyCustomerMatchTransportSettings,
            settings.manageLoyaltyCustomerMatchSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ManageLoyaltyCustomerMatchRequest, ManageLoyaltyCustomerMatchResponse>
      manageLoyaltyCustomerMatchCallable() {
    return manageLoyaltyCustomerMatchCallable;
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
