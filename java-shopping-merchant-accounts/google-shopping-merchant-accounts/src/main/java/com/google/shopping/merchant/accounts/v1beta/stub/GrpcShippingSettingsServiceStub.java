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
import com.google.shopping.merchant.accounts.v1beta.GetShippingSettingsRequest;
import com.google.shopping.merchant.accounts.v1beta.InsertShippingSettingsRequest;
import com.google.shopping.merchant.accounts.v1beta.ShippingSettings;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ShippingSettingsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcShippingSettingsServiceStub extends ShippingSettingsServiceStub {
  private static final MethodDescriptor<GetShippingSettingsRequest, ShippingSettings>
      getShippingSettingsMethodDescriptor =
          MethodDescriptor.<GetShippingSettingsRequest, ShippingSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.ShippingSettingsService/GetShippingSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetShippingSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ShippingSettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<InsertShippingSettingsRequest, ShippingSettings>
      insertShippingSettingsMethodDescriptor =
          MethodDescriptor.<InsertShippingSettingsRequest, ShippingSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.ShippingSettingsService/InsertShippingSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(InsertShippingSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ShippingSettings.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetShippingSettingsRequest, ShippingSettings>
      getShippingSettingsCallable;
  private final UnaryCallable<InsertShippingSettingsRequest, ShippingSettings>
      insertShippingSettingsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcShippingSettingsServiceStub create(
      ShippingSettingsServiceStubSettings settings) throws IOException {
    return new GrpcShippingSettingsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcShippingSettingsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcShippingSettingsServiceStub(
        ShippingSettingsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcShippingSettingsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcShippingSettingsServiceStub(
        ShippingSettingsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcShippingSettingsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcShippingSettingsServiceStub(
      ShippingSettingsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcShippingSettingsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcShippingSettingsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcShippingSettingsServiceStub(
      ShippingSettingsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetShippingSettingsRequest, ShippingSettings>
        getShippingSettingsTransportSettings =
            GrpcCallSettings.<GetShippingSettingsRequest, ShippingSettings>newBuilder()
                .setMethodDescriptor(getShippingSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<InsertShippingSettingsRequest, ShippingSettings>
        insertShippingSettingsTransportSettings =
            GrpcCallSettings.<InsertShippingSettingsRequest, ShippingSettings>newBuilder()
                .setMethodDescriptor(insertShippingSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getShippingSettingsCallable =
        callableFactory.createUnaryCallable(
            getShippingSettingsTransportSettings,
            settings.getShippingSettingsSettings(),
            clientContext);
    this.insertShippingSettingsCallable =
        callableFactory.createUnaryCallable(
            insertShippingSettingsTransportSettings,
            settings.insertShippingSettingsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetShippingSettingsRequest, ShippingSettings> getShippingSettingsCallable() {
    return getShippingSettingsCallable;
  }

  @Override
  public UnaryCallable<InsertShippingSettingsRequest, ShippingSettings>
      insertShippingSettingsCallable() {
    return insertShippingSettingsCallable;
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
