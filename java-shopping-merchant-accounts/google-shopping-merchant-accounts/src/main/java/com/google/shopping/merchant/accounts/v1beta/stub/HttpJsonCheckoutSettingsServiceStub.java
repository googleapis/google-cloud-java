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
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import com.google.shopping.merchant.accounts.v1beta.CheckoutSettings;
import com.google.shopping.merchant.accounts.v1beta.CreateCheckoutSettingsRequest;
import com.google.shopping.merchant.accounts.v1beta.DeleteCheckoutSettingsRequest;
import com.google.shopping.merchant.accounts.v1beta.GetCheckoutSettingsRequest;
import com.google.shopping.merchant.accounts.v1beta.UpdateCheckoutSettingsRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the CheckoutSettingsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonCheckoutSettingsServiceStub extends CheckoutSettingsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetCheckoutSettingsRequest, CheckoutSettings>
      getCheckoutSettingsMethodDescriptor =
          ApiMethodDescriptor.<GetCheckoutSettingsRequest, CheckoutSettings>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.CheckoutSettingsService/GetCheckoutSettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCheckoutSettingsRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{name=accounts/*/programs/*/checkoutSettings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCheckoutSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCheckoutSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CheckoutSettings>newBuilder()
                      .setDefaultInstance(CheckoutSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateCheckoutSettingsRequest, CheckoutSettings>
      createCheckoutSettingsMethodDescriptor =
          ApiMethodDescriptor.<CreateCheckoutSettingsRequest, CheckoutSettings>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.CheckoutSettingsService/CreateCheckoutSettings")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCheckoutSettingsRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{parent=accounts/*/programs/*}/checkoutSettings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCheckoutSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCheckoutSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("checkoutSettings", request.getCheckoutSettings(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CheckoutSettings>newBuilder()
                      .setDefaultInstance(CheckoutSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCheckoutSettingsRequest, CheckoutSettings>
      updateCheckoutSettingsMethodDescriptor =
          ApiMethodDescriptor.<UpdateCheckoutSettingsRequest, CheckoutSettings>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.CheckoutSettingsService/UpdateCheckoutSettings")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCheckoutSettingsRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{checkoutSettings.name=accounts/*/programs/*/checkoutSettings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCheckoutSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "checkoutSettings.name",
                                request.getCheckoutSettings().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCheckoutSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("checkoutSettings", request.getCheckoutSettings(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CheckoutSettings>newBuilder()
                      .setDefaultInstance(CheckoutSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteCheckoutSettingsRequest, Empty>
      deleteCheckoutSettingsMethodDescriptor =
          ApiMethodDescriptor.<DeleteCheckoutSettingsRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.CheckoutSettingsService/DeleteCheckoutSettings")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCheckoutSettingsRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{name=accounts/*/programs/*/checkoutSettings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCheckoutSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCheckoutSettingsRequest> serializer =
                                ProtoRestSerializer.create();
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

  private final UnaryCallable<GetCheckoutSettingsRequest, CheckoutSettings>
      getCheckoutSettingsCallable;
  private final UnaryCallable<CreateCheckoutSettingsRequest, CheckoutSettings>
      createCheckoutSettingsCallable;
  private final UnaryCallable<UpdateCheckoutSettingsRequest, CheckoutSettings>
      updateCheckoutSettingsCallable;
  private final UnaryCallable<DeleteCheckoutSettingsRequest, Empty> deleteCheckoutSettingsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCheckoutSettingsServiceStub create(
      CheckoutSettingsServiceStubSettings settings) throws IOException {
    return new HttpJsonCheckoutSettingsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCheckoutSettingsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCheckoutSettingsServiceStub(
        CheckoutSettingsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCheckoutSettingsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCheckoutSettingsServiceStub(
        CheckoutSettingsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCheckoutSettingsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCheckoutSettingsServiceStub(
      CheckoutSettingsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonCheckoutSettingsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCheckoutSettingsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCheckoutSettingsServiceStub(
      CheckoutSettingsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetCheckoutSettingsRequest, CheckoutSettings>
        getCheckoutSettingsTransportSettings =
            HttpJsonCallSettings.<GetCheckoutSettingsRequest, CheckoutSettings>newBuilder()
                .setMethodDescriptor(getCheckoutSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateCheckoutSettingsRequest, CheckoutSettings>
        createCheckoutSettingsTransportSettings =
            HttpJsonCallSettings.<CreateCheckoutSettingsRequest, CheckoutSettings>newBuilder()
                .setMethodDescriptor(createCheckoutSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateCheckoutSettingsRequest, CheckoutSettings>
        updateCheckoutSettingsTransportSettings =
            HttpJsonCallSettings.<UpdateCheckoutSettingsRequest, CheckoutSettings>newBuilder()
                .setMethodDescriptor(updateCheckoutSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "checkout_settings.name",
                          String.valueOf(request.getCheckoutSettings().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteCheckoutSettingsRequest, Empty>
        deleteCheckoutSettingsTransportSettings =
            HttpJsonCallSettings.<DeleteCheckoutSettingsRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteCheckoutSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getCheckoutSettingsMethodDescriptor);
    methodDescriptors.add(createCheckoutSettingsMethodDescriptor);
    methodDescriptors.add(updateCheckoutSettingsMethodDescriptor);
    methodDescriptors.add(deleteCheckoutSettingsMethodDescriptor);
    return methodDescriptors;
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
