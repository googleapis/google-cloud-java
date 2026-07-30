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

package com.google.cloud.productregistry.v1.stub;

import static com.google.cloud.productregistry.v1.CloudProductRegistryReadServiceClient.ListLogicalProductVariantsPagedResponse;
import static com.google.cloud.productregistry.v1.CloudProductRegistryReadServiceClient.ListLogicalProductsPagedResponse;
import static com.google.cloud.productregistry.v1.CloudProductRegistryReadServiceClient.ListProductSuitesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.productregistry.v1.GetLogicalProductRequest;
import com.google.cloud.productregistry.v1.GetLogicalProductVariantRequest;
import com.google.cloud.productregistry.v1.GetProductSuiteRequest;
import com.google.cloud.productregistry.v1.ListLogicalProductVariantsRequest;
import com.google.cloud.productregistry.v1.ListLogicalProductVariantsResponse;
import com.google.cloud.productregistry.v1.ListLogicalProductsRequest;
import com.google.cloud.productregistry.v1.ListLogicalProductsResponse;
import com.google.cloud.productregistry.v1.ListProductSuitesRequest;
import com.google.cloud.productregistry.v1.ListProductSuitesResponse;
import com.google.cloud.productregistry.v1.LogicalProduct;
import com.google.cloud.productregistry.v1.LogicalProductVariant;
import com.google.cloud.productregistry.v1.LookupEntityRequest;
import com.google.cloud.productregistry.v1.LookupEntityResponse;
import com.google.cloud.productregistry.v1.ProductSuite;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CloudProductRegistryReadService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GrpcCloudProductRegistryReadServiceStub extends CloudProductRegistryReadServiceStub {
  private static final MethodDescriptor<GetProductSuiteRequest, ProductSuite>
      getProductSuiteMethodDescriptor =
          MethodDescriptor.<GetProductSuiteRequest, ProductSuite>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.productregistry.v1.CloudProductRegistryReadService/GetProductSuite")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetProductSuiteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ProductSuite.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListProductSuitesRequest, ListProductSuitesResponse>
      listProductSuitesMethodDescriptor =
          MethodDescriptor.<ListProductSuitesRequest, ListProductSuitesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.productregistry.v1.CloudProductRegistryReadService/ListProductSuites")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListProductSuitesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListProductSuitesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLogicalProductRequest, LogicalProduct>
      getLogicalProductMethodDescriptor =
          MethodDescriptor.<GetLogicalProductRequest, LogicalProduct>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.productregistry.v1.CloudProductRegistryReadService/GetLogicalProduct")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetLogicalProductRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LogicalProduct.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListLogicalProductsRequest, ListLogicalProductsResponse>
      listLogicalProductsMethodDescriptor =
          MethodDescriptor.<ListLogicalProductsRequest, ListLogicalProductsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.productregistry.v1.CloudProductRegistryReadService/ListLogicalProducts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLogicalProductsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLogicalProductsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLogicalProductVariantRequest, LogicalProductVariant>
      getLogicalProductVariantMethodDescriptor =
          MethodDescriptor.<GetLogicalProductVariantRequest, LogicalProductVariant>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.productregistry.v1.CloudProductRegistryReadService/GetLogicalProductVariant")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetLogicalProductVariantRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(LogicalProductVariant.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListLogicalProductVariantsRequest, ListLogicalProductVariantsResponse>
      listLogicalProductVariantsMethodDescriptor =
          MethodDescriptor
              .<ListLogicalProductVariantsRequest, ListLogicalProductVariantsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.productregistry.v1.CloudProductRegistryReadService/ListLogicalProductVariants")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLogicalProductVariantsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLogicalProductVariantsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<LookupEntityRequest, LookupEntityResponse>
      lookupEntityMethodDescriptor =
          MethodDescriptor.<LookupEntityRequest, LookupEntityResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.productregistry.v1.CloudProductRegistryReadService/LookupEntity")
              .setRequestMarshaller(ProtoUtils.marshaller(LookupEntityRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(LookupEntityResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GetProductSuiteRequest, ProductSuite> getProductSuiteCallable;
  private final UnaryCallable<ListProductSuitesRequest, ListProductSuitesResponse>
      listProductSuitesCallable;
  private final UnaryCallable<ListProductSuitesRequest, ListProductSuitesPagedResponse>
      listProductSuitesPagedCallable;
  private final UnaryCallable<GetLogicalProductRequest, LogicalProduct> getLogicalProductCallable;
  private final UnaryCallable<ListLogicalProductsRequest, ListLogicalProductsResponse>
      listLogicalProductsCallable;
  private final UnaryCallable<ListLogicalProductsRequest, ListLogicalProductsPagedResponse>
      listLogicalProductsPagedCallable;
  private final UnaryCallable<GetLogicalProductVariantRequest, LogicalProductVariant>
      getLogicalProductVariantCallable;
  private final UnaryCallable<ListLogicalProductVariantsRequest, ListLogicalProductVariantsResponse>
      listLogicalProductVariantsCallable;
  private final UnaryCallable<
          ListLogicalProductVariantsRequest, ListLogicalProductVariantsPagedResponse>
      listLogicalProductVariantsPagedCallable;
  private final UnaryCallable<LookupEntityRequest, LookupEntityResponse> lookupEntityCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCloudProductRegistryReadServiceStub create(
      CloudProductRegistryReadServiceStubSettings settings) throws IOException {
    return new GrpcCloudProductRegistryReadServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCloudProductRegistryReadServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCloudProductRegistryReadServiceStub(
        CloudProductRegistryReadServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCloudProductRegistryReadServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCloudProductRegistryReadServiceStub(
        CloudProductRegistryReadServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcCloudProductRegistryReadServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcCloudProductRegistryReadServiceStub(
      CloudProductRegistryReadServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcCloudProductRegistryReadServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCloudProductRegistryReadServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcCloudProductRegistryReadServiceStub(
      CloudProductRegistryReadServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetProductSuiteRequest, ProductSuite> getProductSuiteTransportSettings =
        GrpcCallSettings.<GetProductSuiteRequest, ProductSuite>newBuilder()
            .setMethodDescriptor(getProductSuiteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListProductSuitesRequest, ListProductSuitesResponse>
        listProductSuitesTransportSettings =
            GrpcCallSettings.<ListProductSuitesRequest, ListProductSuitesResponse>newBuilder()
                .setMethodDescriptor(listProductSuitesMethodDescriptor)
                .build();
    GrpcCallSettings<GetLogicalProductRequest, LogicalProduct> getLogicalProductTransportSettings =
        GrpcCallSettings.<GetLogicalProductRequest, LogicalProduct>newBuilder()
            .setMethodDescriptor(getLogicalProductMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListLogicalProductsRequest, ListLogicalProductsResponse>
        listLogicalProductsTransportSettings =
            GrpcCallSettings.<ListLogicalProductsRequest, ListLogicalProductsResponse>newBuilder()
                .setMethodDescriptor(listLogicalProductsMethodDescriptor)
                .build();
    GrpcCallSettings<GetLogicalProductVariantRequest, LogicalProductVariant>
        getLogicalProductVariantTransportSettings =
            GrpcCallSettings.<GetLogicalProductVariantRequest, LogicalProductVariant>newBuilder()
                .setMethodDescriptor(getLogicalProductVariantMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListLogicalProductVariantsRequest, ListLogicalProductVariantsResponse>
        listLogicalProductVariantsTransportSettings =
            GrpcCallSettings
                .<ListLogicalProductVariantsRequest, ListLogicalProductVariantsResponse>newBuilder()
                .setMethodDescriptor(listLogicalProductVariantsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<LookupEntityRequest, LookupEntityResponse> lookupEntityTransportSettings =
        GrpcCallSettings.<LookupEntityRequest, LookupEntityResponse>newBuilder()
            .setMethodDescriptor(lookupEntityMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("lookup_uri", String.valueOf(request.getLookupUri()));
                  return builder.build();
                })
            .build();

    this.getProductSuiteCallable =
        callableFactory.createUnaryCallable(
            getProductSuiteTransportSettings, settings.getProductSuiteSettings(), clientContext);
    this.listProductSuitesCallable =
        callableFactory.createUnaryCallable(
            listProductSuitesTransportSettings,
            settings.listProductSuitesSettings(),
            clientContext);
    this.listProductSuitesPagedCallable =
        callableFactory.createPagedCallable(
            listProductSuitesTransportSettings,
            settings.listProductSuitesSettings(),
            clientContext);
    this.getLogicalProductCallable =
        callableFactory.createUnaryCallable(
            getLogicalProductTransportSettings,
            settings.getLogicalProductSettings(),
            clientContext);
    this.listLogicalProductsCallable =
        callableFactory.createUnaryCallable(
            listLogicalProductsTransportSettings,
            settings.listLogicalProductsSettings(),
            clientContext);
    this.listLogicalProductsPagedCallable =
        callableFactory.createPagedCallable(
            listLogicalProductsTransportSettings,
            settings.listLogicalProductsSettings(),
            clientContext);
    this.getLogicalProductVariantCallable =
        callableFactory.createUnaryCallable(
            getLogicalProductVariantTransportSettings,
            settings.getLogicalProductVariantSettings(),
            clientContext);
    this.listLogicalProductVariantsCallable =
        callableFactory.createUnaryCallable(
            listLogicalProductVariantsTransportSettings,
            settings.listLogicalProductVariantsSettings(),
            clientContext);
    this.listLogicalProductVariantsPagedCallable =
        callableFactory.createPagedCallable(
            listLogicalProductVariantsTransportSettings,
            settings.listLogicalProductVariantsSettings(),
            clientContext);
    this.lookupEntityCallable =
        callableFactory.createUnaryCallable(
            lookupEntityTransportSettings, settings.lookupEntitySettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetProductSuiteRequest, ProductSuite> getProductSuiteCallable() {
    return getProductSuiteCallable;
  }

  @Override
  public UnaryCallable<ListProductSuitesRequest, ListProductSuitesResponse>
      listProductSuitesCallable() {
    return listProductSuitesCallable;
  }

  @Override
  public UnaryCallable<ListProductSuitesRequest, ListProductSuitesPagedResponse>
      listProductSuitesPagedCallable() {
    return listProductSuitesPagedCallable;
  }

  @Override
  public UnaryCallable<GetLogicalProductRequest, LogicalProduct> getLogicalProductCallable() {
    return getLogicalProductCallable;
  }

  @Override
  public UnaryCallable<ListLogicalProductsRequest, ListLogicalProductsResponse>
      listLogicalProductsCallable() {
    return listLogicalProductsCallable;
  }

  @Override
  public UnaryCallable<ListLogicalProductsRequest, ListLogicalProductsPagedResponse>
      listLogicalProductsPagedCallable() {
    return listLogicalProductsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLogicalProductVariantRequest, LogicalProductVariant>
      getLogicalProductVariantCallable() {
    return getLogicalProductVariantCallable;
  }

  @Override
  public UnaryCallable<ListLogicalProductVariantsRequest, ListLogicalProductVariantsResponse>
      listLogicalProductVariantsCallable() {
    return listLogicalProductVariantsCallable;
  }

  @Override
  public UnaryCallable<ListLogicalProductVariantsRequest, ListLogicalProductVariantsPagedResponse>
      listLogicalProductVariantsPagedCallable() {
    return listLogicalProductVariantsPagedCallable;
  }

  @Override
  public UnaryCallable<LookupEntityRequest, LookupEntityResponse> lookupEntityCallable() {
    return lookupEntityCallable;
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
