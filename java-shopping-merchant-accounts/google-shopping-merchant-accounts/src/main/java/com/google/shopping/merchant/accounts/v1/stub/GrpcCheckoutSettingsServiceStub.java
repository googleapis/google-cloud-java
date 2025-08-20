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
import com.google.protobuf.Empty;
import com.google.shopping.merchant.accounts.v1.CheckoutSettings;
import com.google.shopping.merchant.accounts.v1.CreateCheckoutSettingsRequest;
import com.google.shopping.merchant.accounts.v1.DeleteCheckoutSettingsRequest;
import com.google.shopping.merchant.accounts.v1.GetCheckoutSettingsRequest;
import com.google.shopping.merchant.accounts.v1.UpdateCheckoutSettingsRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CheckoutSettingsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcCheckoutSettingsServiceStub extends CheckoutSettingsServiceStub {
  private static final MethodDescriptor<GetCheckoutSettingsRequest, CheckoutSettings>
      getCheckoutSettingsMethodDescriptor =
          MethodDescriptor.<GetCheckoutSettingsRequest, CheckoutSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.CheckoutSettingsService/GetCheckoutSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCheckoutSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CheckoutSettings.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateCheckoutSettingsRequest, CheckoutSettings>
      createCheckoutSettingsMethodDescriptor =
          MethodDescriptor.<CreateCheckoutSettingsRequest, CheckoutSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.CheckoutSettingsService/CreateCheckoutSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCheckoutSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CheckoutSettings.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateCheckoutSettingsRequest, CheckoutSettings>
      updateCheckoutSettingsMethodDescriptor =
          MethodDescriptor.<UpdateCheckoutSettingsRequest, CheckoutSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.CheckoutSettingsService/UpdateCheckoutSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCheckoutSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CheckoutSettings.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteCheckoutSettingsRequest, Empty>
      deleteCheckoutSettingsMethodDescriptor =
          MethodDescriptor.<DeleteCheckoutSettingsRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.CheckoutSettingsService/DeleteCheckoutSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCheckoutSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GetCheckoutSettingsRequest, CheckoutSettings>
      getCheckoutSettingsCallable;
  private final UnaryCallable<CreateCheckoutSettingsRequest, CheckoutSettings>
      createCheckoutSettingsCallable;
  private final UnaryCallable<UpdateCheckoutSettingsRequest, CheckoutSettings>
      updateCheckoutSettingsCallable;
  private final UnaryCallable<DeleteCheckoutSettingsRequest, Empty> deleteCheckoutSettingsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCheckoutSettingsServiceStub create(
      CheckoutSettingsServiceStubSettings settings) throws IOException {
    return new GrpcCheckoutSettingsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCheckoutSettingsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCheckoutSettingsServiceStub(
        CheckoutSettingsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCheckoutSettingsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCheckoutSettingsServiceStub(
        CheckoutSettingsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCheckoutSettingsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCheckoutSettingsServiceStub(
      CheckoutSettingsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcCheckoutSettingsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCheckoutSettingsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCheckoutSettingsServiceStub(
      CheckoutSettingsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetCheckoutSettingsRequest, CheckoutSettings>
        getCheckoutSettingsTransportSettings =
            GrpcCallSettings.<GetCheckoutSettingsRequest, CheckoutSettings>newBuilder()
                .setMethodDescriptor(getCheckoutSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateCheckoutSettingsRequest, CheckoutSettings>
        createCheckoutSettingsTransportSettings =
            GrpcCallSettings.<CreateCheckoutSettingsRequest, CheckoutSettings>newBuilder()
                .setMethodDescriptor(createCheckoutSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateCheckoutSettingsRequest, CheckoutSettings>
        updateCheckoutSettingsTransportSettings =
            GrpcCallSettings.<UpdateCheckoutSettingsRequest, CheckoutSettings>newBuilder()
                .setMethodDescriptor(updateCheckoutSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "checkout_settings.name",
                          String.valueOf(request.getCheckoutSettings().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteCheckoutSettingsRequest, Empty> deleteCheckoutSettingsTransportSettings =
        GrpcCallSettings.<DeleteCheckoutSettingsRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteCheckoutSettingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getCheckoutSettingsCallable =
        callableFactory.createUnaryCallable(
            getCheckoutSettingsTransportSettings,
            settings.getCheckoutSettingsSettings(),
            clientContext);
    this.createCheckoutSettingsCallable =
        callableFactory.createUnaryCallable(
            createCheckoutSettingsTransportSettings,
            settings.createCheckoutSettingsSettings(),
            clientContext);
    this.updateCheckoutSettingsCallable =
        callableFactory.createUnaryCallable(
            updateCheckoutSettingsTransportSettings,
            settings.updateCheckoutSettingsSettings(),
            clientContext);
    this.deleteCheckoutSettingsCallable =
        callableFactory.createUnaryCallable(
            deleteCheckoutSettingsTransportSettings,
            settings.deleteCheckoutSettingsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetCheckoutSettingsRequest, CheckoutSettings> getCheckoutSettingsCallable() {
    return getCheckoutSettingsCallable;
  }

  @Override
  public UnaryCallable<CreateCheckoutSettingsRequest, CheckoutSettings>
      createCheckoutSettingsCallable() {
    return createCheckoutSettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateCheckoutSettingsRequest, CheckoutSettings>
      updateCheckoutSettingsCallable() {
    return updateCheckoutSettingsCallable;
  }

  @Override
  public UnaryCallable<DeleteCheckoutSettingsRequest, Empty> deleteCheckoutSettingsCallable() {
    return deleteCheckoutSettingsCallable;
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
