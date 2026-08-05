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

import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
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
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the CloudProductRegistryReadService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonCloudProductRegistryReadServiceStub
    extends CloudProductRegistryReadServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetProductSuiteRequest, ProductSuite>
      getProductSuiteMethodDescriptor =
          ApiMethodDescriptor.<GetProductSuiteRequest, ProductSuite>newBuilder()
              .setFullMethodName(
                  "google.cloud.productregistry.v1.CloudProductRegistryReadService/GetProductSuite")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetProductSuiteRequest>newBuilder()
                      .setPath(
                          "/v1/{name=productSuites/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetProductSuiteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetProductSuiteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ProductSuite>newBuilder()
                      .setDefaultInstance(ProductSuite.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListProductSuitesRequest, ListProductSuitesResponse>
      listProductSuitesMethodDescriptor =
          ApiMethodDescriptor.<ListProductSuitesRequest, ListProductSuitesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.productregistry.v1.CloudProductRegistryReadService/ListProductSuites")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListProductSuitesRequest>newBuilder()
                      .setPath(
                          "/v1/productSuites",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListProductSuitesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListProductSuitesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListProductSuitesResponse>newBuilder()
                      .setDefaultInstance(ListProductSuitesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLogicalProductRequest, LogicalProduct>
      getLogicalProductMethodDescriptor =
          ApiMethodDescriptor.<GetLogicalProductRequest, LogicalProduct>newBuilder()
              .setFullMethodName(
                  "google.cloud.productregistry.v1.CloudProductRegistryReadService/GetLogicalProduct")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLogicalProductRequest>newBuilder()
                      .setPath(
                          "/v1/{name=logicalProducts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLogicalProductRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLogicalProductRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LogicalProduct>newBuilder()
                      .setDefaultInstance(LogicalProduct.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLogicalProductsRequest, ListLogicalProductsResponse>
      listLogicalProductsMethodDescriptor =
          ApiMethodDescriptor.<ListLogicalProductsRequest, ListLogicalProductsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.productregistry.v1.CloudProductRegistryReadService/ListLogicalProducts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLogicalProductsRequest>newBuilder()
                      .setPath(
                          "/v1/logicalProducts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLogicalProductsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLogicalProductsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLogicalProductsResponse>newBuilder()
                      .setDefaultInstance(ListLogicalProductsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLogicalProductVariantRequest, LogicalProductVariant>
      getLogicalProductVariantMethodDescriptor =
          ApiMethodDescriptor.<GetLogicalProductVariantRequest, LogicalProductVariant>newBuilder()
              .setFullMethodName(
                  "google.cloud.productregistry.v1.CloudProductRegistryReadService/GetLogicalProductVariant")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLogicalProductVariantRequest>newBuilder()
                      .setPath(
                          "/v1/{name=logicalProducts/*/variants/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLogicalProductVariantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLogicalProductVariantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LogicalProductVariant>newBuilder()
                      .setDefaultInstance(LogicalProductVariant.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListLogicalProductVariantsRequest, ListLogicalProductVariantsResponse>
      listLogicalProductVariantsMethodDescriptor =
          ApiMethodDescriptor
              .<ListLogicalProductVariantsRequest, ListLogicalProductVariantsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.productregistry.v1.CloudProductRegistryReadService/ListLogicalProductVariants")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLogicalProductVariantsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=logicalProducts/*}/variants",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLogicalProductVariantsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLogicalProductVariantsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLogicalProductVariantsResponse>newBuilder()
                      .setDefaultInstance(ListLogicalProductVariantsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<LookupEntityRequest, LookupEntityResponse>
      lookupEntityMethodDescriptor =
          ApiMethodDescriptor.<LookupEntityRequest, LookupEntityResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.productregistry.v1.CloudProductRegistryReadService/LookupEntity")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<LookupEntityRequest>newBuilder()
                      .setPath(
                          "/v1/{lookupUri=logicalProducts/*}:lookupEntity",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<LookupEntityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "lookupUri", request.getLookupUri());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{lookupUri=logicalProducts/*/variants/*}:lookupEntity",
                          "/v1/{lookupUri=productSuites/*}:lookupEntity")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<LookupEntityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LookupEntityResponse>newBuilder()
                      .setDefaultInstance(LookupEntityResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCloudProductRegistryReadServiceStub create(
      CloudProductRegistryReadServiceStubSettings settings) throws IOException {
    return new HttpJsonCloudProductRegistryReadServiceStub(
        settings, ClientContext.create(settings));
  }

  public static final HttpJsonCloudProductRegistryReadServiceStub create(
      ClientContext clientContext) throws IOException {
    return new HttpJsonCloudProductRegistryReadServiceStub(
        CloudProductRegistryReadServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCloudProductRegistryReadServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCloudProductRegistryReadServiceStub(
        CloudProductRegistryReadServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCloudProductRegistryReadServiceStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonCloudProductRegistryReadServiceStub(
      CloudProductRegistryReadServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonCloudProductRegistryReadServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCloudProductRegistryReadServiceStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonCloudProductRegistryReadServiceStub(
      CloudProductRegistryReadServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetProductSuiteRequest, ProductSuite> getProductSuiteTransportSettings =
        HttpJsonCallSettings.<GetProductSuiteRequest, ProductSuite>newBuilder()
            .setMethodDescriptor(getProductSuiteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListProductSuitesRequest, ListProductSuitesResponse>
        listProductSuitesTransportSettings =
            HttpJsonCallSettings.<ListProductSuitesRequest, ListProductSuitesResponse>newBuilder()
                .setMethodDescriptor(listProductSuitesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetLogicalProductRequest, LogicalProduct>
        getLogicalProductTransportSettings =
            HttpJsonCallSettings.<GetLogicalProductRequest, LogicalProduct>newBuilder()
                .setMethodDescriptor(getLogicalProductMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListLogicalProductsRequest, ListLogicalProductsResponse>
        listLogicalProductsTransportSettings =
            HttpJsonCallSettings
                .<ListLogicalProductsRequest, ListLogicalProductsResponse>newBuilder()
                .setMethodDescriptor(listLogicalProductsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetLogicalProductVariantRequest, LogicalProductVariant>
        getLogicalProductVariantTransportSettings =
            HttpJsonCallSettings
                .<GetLogicalProductVariantRequest, LogicalProductVariant>newBuilder()
                .setMethodDescriptor(getLogicalProductVariantMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListLogicalProductVariantsRequest, ListLogicalProductVariantsResponse>
        listLogicalProductVariantsTransportSettings =
            HttpJsonCallSettings
                .<ListLogicalProductVariantsRequest, ListLogicalProductVariantsResponse>newBuilder()
                .setMethodDescriptor(listLogicalProductVariantsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<LookupEntityRequest, LookupEntityResponse> lookupEntityTransportSettings =
        HttpJsonCallSettings.<LookupEntityRequest, LookupEntityResponse>newBuilder()
            .setMethodDescriptor(lookupEntityMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getProductSuiteMethodDescriptor);
    methodDescriptors.add(listProductSuitesMethodDescriptor);
    methodDescriptors.add(getLogicalProductMethodDescriptor);
    methodDescriptors.add(listLogicalProductsMethodDescriptor);
    methodDescriptors.add(getLogicalProductVariantMethodDescriptor);
    methodDescriptors.add(listLogicalProductVariantsMethodDescriptor);
    methodDescriptors.add(lookupEntityMethodDescriptor);
    return methodDescriptors;
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
