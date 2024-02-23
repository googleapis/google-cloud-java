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

package com.google.shopping.css.v1.stub;

import static com.google.shopping.css.v1.CssProductsServiceClient.ListCssProductsPagedResponse;

import com.google.api.core.BetaApi;
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
import com.google.protobuf.TypeRegistry;
import com.google.shopping.css.v1.CssProduct;
import com.google.shopping.css.v1.GetCssProductRequest;
import com.google.shopping.css.v1.ListCssProductsRequest;
import com.google.shopping.css.v1.ListCssProductsResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the CssProductsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonCssProductsServiceStub extends CssProductsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetCssProductRequest, CssProduct>
      getCssProductMethodDescriptor =
          ApiMethodDescriptor.<GetCssProductRequest, CssProduct>newBuilder()
              .setFullMethodName("google.shopping.css.v1.CssProductsService/GetCssProduct")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCssProductRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accounts/*/cssProducts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCssProductRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCssProductRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CssProduct>newBuilder()
                      .setDefaultInstance(CssProduct.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListCssProductsRequest, ListCssProductsResponse>
      listCssProductsMethodDescriptor =
          ApiMethodDescriptor.<ListCssProductsRequest, ListCssProductsResponse>newBuilder()
              .setFullMethodName("google.shopping.css.v1.CssProductsService/ListCssProducts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCssProductsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accounts/*}/cssProducts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCssProductsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCssProductsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCssProductsResponse>newBuilder()
                      .setDefaultInstance(ListCssProductsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetCssProductRequest, CssProduct> getCssProductCallable;
  private final UnaryCallable<ListCssProductsRequest, ListCssProductsResponse>
      listCssProductsCallable;
  private final UnaryCallable<ListCssProductsRequest, ListCssProductsPagedResponse>
      listCssProductsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCssProductsServiceStub create(CssProductsServiceStubSettings settings)
      throws IOException {
    return new HttpJsonCssProductsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCssProductsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCssProductsServiceStub(
        CssProductsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCssProductsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCssProductsServiceStub(
        CssProductsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCssProductsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCssProductsServiceStub(
      CssProductsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonCssProductsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCssProductsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCssProductsServiceStub(
      CssProductsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetCssProductRequest, CssProduct> getCssProductTransportSettings =
        HttpJsonCallSettings.<GetCssProductRequest, CssProduct>newBuilder()
            .setMethodDescriptor(getCssProductMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListCssProductsRequest, ListCssProductsResponse>
        listCssProductsTransportSettings =
            HttpJsonCallSettings.<ListCssProductsRequest, ListCssProductsResponse>newBuilder()
                .setMethodDescriptor(listCssProductsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getCssProductCallable =
        callableFactory.createUnaryCallable(
            getCssProductTransportSettings, settings.getCssProductSettings(), clientContext);
    this.listCssProductsCallable =
        callableFactory.createUnaryCallable(
            listCssProductsTransportSettings, settings.listCssProductsSettings(), clientContext);
    this.listCssProductsPagedCallable =
        callableFactory.createPagedCallable(
            listCssProductsTransportSettings, settings.listCssProductsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getCssProductMethodDescriptor);
    methodDescriptors.add(listCssProductsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetCssProductRequest, CssProduct> getCssProductCallable() {
    return getCssProductCallable;
  }

  @Override
  public UnaryCallable<ListCssProductsRequest, ListCssProductsResponse> listCssProductsCallable() {
    return listCssProductsCallable;
  }

  @Override
  public UnaryCallable<ListCssProductsRequest, ListCssProductsPagedResponse>
      listCssProductsPagedCallable() {
    return listCssProductsPagedCallable;
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
