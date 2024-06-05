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
import com.google.shopping.merchant.accounts.v1beta.GetShippingSettingsRequest;
import com.google.shopping.merchant.accounts.v1beta.InsertShippingSettingsRequest;
import com.google.shopping.merchant.accounts.v1beta.ShippingSettings;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the ShippingSettingsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonShippingSettingsServiceStub extends ShippingSettingsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetShippingSettingsRequest, ShippingSettings>
      getShippingSettingsMethodDescriptor =
          ApiMethodDescriptor.<GetShippingSettingsRequest, ShippingSettings>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.ShippingSettingsService/GetShippingSettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetShippingSettingsRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{name=accounts/*/shippingSettings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetShippingSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetShippingSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ShippingSettings>newBuilder()
                      .setDefaultInstance(ShippingSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertShippingSettingsRequest, ShippingSettings>
      insertShippingSettingsMethodDescriptor =
          ApiMethodDescriptor.<InsertShippingSettingsRequest, ShippingSettings>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.ShippingSettingsService/InsertShippingSettings")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertShippingSettingsRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{parent=accounts/*}/shippingSettings:insert",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertShippingSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertShippingSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("shippingSetting", request.getShippingSetting(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ShippingSettings>newBuilder()
                      .setDefaultInstance(ShippingSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetShippingSettingsRequest, ShippingSettings>
      getShippingSettingsCallable;
  private final UnaryCallable<InsertShippingSettingsRequest, ShippingSettings>
      insertShippingSettingsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonShippingSettingsServiceStub create(
      ShippingSettingsServiceStubSettings settings) throws IOException {
    return new HttpJsonShippingSettingsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonShippingSettingsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonShippingSettingsServiceStub(
        ShippingSettingsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonShippingSettingsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonShippingSettingsServiceStub(
        ShippingSettingsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonShippingSettingsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonShippingSettingsServiceStub(
      ShippingSettingsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonShippingSettingsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonShippingSettingsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonShippingSettingsServiceStub(
      ShippingSettingsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetShippingSettingsRequest, ShippingSettings>
        getShippingSettingsTransportSettings =
            HttpJsonCallSettings.<GetShippingSettingsRequest, ShippingSettings>newBuilder()
                .setMethodDescriptor(getShippingSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<InsertShippingSettingsRequest, ShippingSettings>
        insertShippingSettingsTransportSettings =
            HttpJsonCallSettings.<InsertShippingSettingsRequest, ShippingSettings>newBuilder()
                .setMethodDescriptor(insertShippingSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getShippingSettingsMethodDescriptor);
    methodDescriptors.add(insertShippingSettingsMethodDescriptor);
    return methodDescriptors;
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
