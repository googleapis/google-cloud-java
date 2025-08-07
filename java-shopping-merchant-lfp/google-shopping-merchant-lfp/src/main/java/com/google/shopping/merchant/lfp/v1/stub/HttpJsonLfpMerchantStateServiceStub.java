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

package com.google.shopping.merchant.lfp.v1.stub;

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
import com.google.shopping.merchant.lfp.v1.GetLfpMerchantStateRequest;
import com.google.shopping.merchant.lfp.v1.LfpMerchantState;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the LfpMerchantStateService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonLfpMerchantStateServiceStub extends LfpMerchantStateServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetLfpMerchantStateRequest, LfpMerchantState>
      getLfpMerchantStateMethodDescriptor =
          ApiMethodDescriptor.<GetLfpMerchantStateRequest, LfpMerchantState>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.lfp.v1.LfpMerchantStateService/GetLfpMerchantState")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLfpMerchantStateRequest>newBuilder()
                      .setPath(
                          "/lfp/v1/{name=accounts/*/lfpMerchantStates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLfpMerchantStateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLfpMerchantStateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LfpMerchantState>newBuilder()
                      .setDefaultInstance(LfpMerchantState.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetLfpMerchantStateRequest, LfpMerchantState>
      getLfpMerchantStateCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonLfpMerchantStateServiceStub create(
      LfpMerchantStateServiceStubSettings settings) throws IOException {
    return new HttpJsonLfpMerchantStateServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonLfpMerchantStateServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonLfpMerchantStateServiceStub(
        LfpMerchantStateServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonLfpMerchantStateServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonLfpMerchantStateServiceStub(
        LfpMerchantStateServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonLfpMerchantStateServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLfpMerchantStateServiceStub(
      LfpMerchantStateServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonLfpMerchantStateServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonLfpMerchantStateServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLfpMerchantStateServiceStub(
      LfpMerchantStateServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetLfpMerchantStateRequest, LfpMerchantState>
        getLfpMerchantStateTransportSettings =
            HttpJsonCallSettings.<GetLfpMerchantStateRequest, LfpMerchantState>newBuilder()
                .setMethodDescriptor(getLfpMerchantStateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.getLfpMerchantStateCallable =
        callableFactory.createUnaryCallable(
            getLfpMerchantStateTransportSettings,
            settings.getLfpMerchantStateSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getLfpMerchantStateMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetLfpMerchantStateRequest, LfpMerchantState> getLfpMerchantStateCallable() {
    return getLfpMerchantStateCallable;
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
