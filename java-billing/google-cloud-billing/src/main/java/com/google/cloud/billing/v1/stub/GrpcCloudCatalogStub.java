/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.billing.v1.stub;

import static com.google.cloud.billing.v1.CloudCatalogClient.ListServicesPagedResponse;
import static com.google.cloud.billing.v1.CloudCatalogClient.ListSkusPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.billing.v1.ListServicesRequest;
import com.google.cloud.billing.v1.ListServicesResponse;
import com.google.cloud.billing.v1.ListSkusRequest;
import com.google.cloud.billing.v1.ListSkusResponse;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CloudCatalog service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcCloudCatalogStub extends CloudCatalogStub {
  private static final MethodDescriptor<ListServicesRequest, ListServicesResponse>
      listServicesMethodDescriptor =
          MethodDescriptor.<ListServicesRequest, ListServicesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.billing.v1.CloudCatalog/ListServices")
              .setRequestMarshaller(ProtoUtils.marshaller(ListServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServicesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSkusRequest, ListSkusResponse>
      listSkusMethodDescriptor =
          MethodDescriptor.<ListSkusRequest, ListSkusResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.billing.v1.CloudCatalog/ListSkus")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSkusRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListSkusResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable;
  private final UnaryCallable<ListServicesRequest, ListServicesPagedResponse>
      listServicesPagedCallable;
  private final UnaryCallable<ListSkusRequest, ListSkusResponse> listSkusCallable;
  private final UnaryCallable<ListSkusRequest, ListSkusPagedResponse> listSkusPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCloudCatalogStub create(CloudCatalogStubSettings settings)
      throws IOException {
    return new GrpcCloudCatalogStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCloudCatalogStub create(ClientContext clientContext) throws IOException {
    return new GrpcCloudCatalogStub(CloudCatalogStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCloudCatalogStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCloudCatalogStub(
        CloudCatalogStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCloudCatalogStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCloudCatalogStub(CloudCatalogStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcCloudCatalogCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCloudCatalogStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCloudCatalogStub(
      CloudCatalogStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListServicesRequest, ListServicesResponse> listServicesTransportSettings =
        GrpcCallSettings.<ListServicesRequest, ListServicesResponse>newBuilder()
            .setMethodDescriptor(listServicesMethodDescriptor)
            .build();
    GrpcCallSettings<ListSkusRequest, ListSkusResponse> listSkusTransportSettings =
        GrpcCallSettings.<ListSkusRequest, ListSkusResponse>newBuilder()
            .setMethodDescriptor(listSkusMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();

    this.listServicesCallable =
        callableFactory.createUnaryCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.listServicesPagedCallable =
        callableFactory.createPagedCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.listSkusCallable =
        callableFactory.createUnaryCallable(
            listSkusTransportSettings, settings.listSkusSettings(), clientContext);
    this.listSkusPagedCallable =
        callableFactory.createPagedCallable(
            listSkusTransportSettings, settings.listSkusSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable() {
    return listServicesCallable;
  }

  @Override
  public UnaryCallable<ListServicesRequest, ListServicesPagedResponse> listServicesPagedCallable() {
    return listServicesPagedCallable;
  }

  @Override
  public UnaryCallable<ListSkusRequest, ListSkusResponse> listSkusCallable() {
    return listSkusCallable;
  }

  @Override
  public UnaryCallable<ListSkusRequest, ListSkusPagedResponse> listSkusPagedCallable() {
    return listSkusPagedCallable;
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
