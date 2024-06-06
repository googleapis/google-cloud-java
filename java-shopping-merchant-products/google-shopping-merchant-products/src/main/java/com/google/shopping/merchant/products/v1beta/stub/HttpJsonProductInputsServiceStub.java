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

package com.google.shopping.merchant.products.v1beta.stub;

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
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import com.google.shopping.merchant.products.v1beta.DeleteProductInputRequest;
import com.google.shopping.merchant.products.v1beta.InsertProductInputRequest;
import com.google.shopping.merchant.products.v1beta.ProductInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the ProductInputsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonProductInputsServiceStub extends ProductInputsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<InsertProductInputRequest, ProductInput>
      insertProductInputMethodDescriptor =
          ApiMethodDescriptor.<InsertProductInputRequest, ProductInput>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.products.v1beta.ProductInputsService/InsertProductInput")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertProductInputRequest>newBuilder()
                      .setPath(
                          "/products/v1beta/{parent=accounts/*}/productInputs:insert",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertProductInputRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertProductInputRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "dataSource", request.getDataSource());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("productInput", request.getProductInput(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ProductInput>newBuilder()
                      .setDefaultInstance(ProductInput.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteProductInputRequest, Empty>
      deleteProductInputMethodDescriptor =
          ApiMethodDescriptor.<DeleteProductInputRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.products.v1beta.ProductInputsService/DeleteProductInput")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteProductInputRequest>newBuilder()
                      .setPath(
                          "/products/v1beta/{name=accounts/*/productInputs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteProductInputRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteProductInputRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "dataSource", request.getDataSource());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<InsertProductInputRequest, ProductInput> insertProductInputCallable;
  private final UnaryCallable<DeleteProductInputRequest, Empty> deleteProductInputCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonProductInputsServiceStub create(
      ProductInputsServiceStubSettings settings) throws IOException {
    return new HttpJsonProductInputsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonProductInputsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonProductInputsServiceStub(
        ProductInputsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonProductInputsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonProductInputsServiceStub(
        ProductInputsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonProductInputsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonProductInputsServiceStub(
      ProductInputsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonProductInputsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonProductInputsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonProductInputsServiceStub(
      ProductInputsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<InsertProductInputRequest, ProductInput>
        insertProductInputTransportSettings =
            HttpJsonCallSettings.<InsertProductInputRequest, ProductInput>newBuilder()
                .setMethodDescriptor(insertProductInputMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteProductInputRequest, Empty> deleteProductInputTransportSettings =
        HttpJsonCallSettings.<DeleteProductInputRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteProductInputMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.insertProductInputCallable =
        callableFactory.createUnaryCallable(
            insertProductInputTransportSettings,
            settings.insertProductInputSettings(),
            clientContext);
    this.deleteProductInputCallable =
        callableFactory.createUnaryCallable(
            deleteProductInputTransportSettings,
            settings.deleteProductInputSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(insertProductInputMethodDescriptor);
    methodDescriptors.add(deleteProductInputMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<InsertProductInputRequest, ProductInput> insertProductInputCallable() {
    return insertProductInputCallable;
  }

  @Override
  public UnaryCallable<DeleteProductInputRequest, Empty> deleteProductInputCallable() {
    return deleteProductInputCallable;
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
