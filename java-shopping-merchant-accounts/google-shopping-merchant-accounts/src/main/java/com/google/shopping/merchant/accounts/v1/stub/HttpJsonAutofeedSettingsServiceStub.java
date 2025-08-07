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
import com.google.shopping.merchant.accounts.v1.AutofeedSettings;
import com.google.shopping.merchant.accounts.v1.GetAutofeedSettingsRequest;
import com.google.shopping.merchant.accounts.v1.UpdateAutofeedSettingsRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the AutofeedSettingsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonAutofeedSettingsServiceStub extends AutofeedSettingsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetAutofeedSettingsRequest, AutofeedSettings>
      getAutofeedSettingsMethodDescriptor =
          ApiMethodDescriptor.<GetAutofeedSettingsRequest, AutofeedSettings>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.AutofeedSettingsService/GetAutofeedSettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAutofeedSettingsRequest>newBuilder()
                      .setPath(
                          "/accounts/v1/{name=accounts/*/autofeedSettings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAutofeedSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAutofeedSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AutofeedSettings>newBuilder()
                      .setDefaultInstance(AutofeedSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateAutofeedSettingsRequest, AutofeedSettings>
      updateAutofeedSettingsMethodDescriptor =
          ApiMethodDescriptor.<UpdateAutofeedSettingsRequest, AutofeedSettings>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.AutofeedSettingsService/UpdateAutofeedSettings")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAutofeedSettingsRequest>newBuilder()
                      .setPath(
                          "/accounts/v1/{autofeedSettings.name=accounts/*/autofeedSettings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAutofeedSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "autofeedSettings.name",
                                request.getAutofeedSettings().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAutofeedSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("autofeedSettings", request.getAutofeedSettings(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AutofeedSettings>newBuilder()
                      .setDefaultInstance(AutofeedSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetAutofeedSettingsRequest, AutofeedSettings>
      getAutofeedSettingsCallable;
  private final UnaryCallable<UpdateAutofeedSettingsRequest, AutofeedSettings>
      updateAutofeedSettingsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAutofeedSettingsServiceStub create(
      AutofeedSettingsServiceStubSettings settings) throws IOException {
    return new HttpJsonAutofeedSettingsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAutofeedSettingsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAutofeedSettingsServiceStub(
        AutofeedSettingsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAutofeedSettingsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAutofeedSettingsServiceStub(
        AutofeedSettingsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAutofeedSettingsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAutofeedSettingsServiceStub(
      AutofeedSettingsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonAutofeedSettingsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAutofeedSettingsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAutofeedSettingsServiceStub(
      AutofeedSettingsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetAutofeedSettingsRequest, AutofeedSettings>
        getAutofeedSettingsTransportSettings =
            HttpJsonCallSettings.<GetAutofeedSettingsRequest, AutofeedSettings>newBuilder()
                .setMethodDescriptor(getAutofeedSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateAutofeedSettingsRequest, AutofeedSettings>
        updateAutofeedSettingsTransportSettings =
            HttpJsonCallSettings.<UpdateAutofeedSettingsRequest, AutofeedSettings>newBuilder()
                .setMethodDescriptor(updateAutofeedSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "autofeed_settings.name",
                          String.valueOf(request.getAutofeedSettings().getName()));
                      return builder.build();
                    })
                .build();

    this.getAutofeedSettingsCallable =
        callableFactory.createUnaryCallable(
            getAutofeedSettingsTransportSettings,
            settings.getAutofeedSettingsSettings(),
            clientContext);
    this.updateAutofeedSettingsCallable =
        callableFactory.createUnaryCallable(
            updateAutofeedSettingsTransportSettings,
            settings.updateAutofeedSettingsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getAutofeedSettingsMethodDescriptor);
    methodDescriptors.add(updateAutofeedSettingsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetAutofeedSettingsRequest, AutofeedSettings> getAutofeedSettingsCallable() {
    return getAutofeedSettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateAutofeedSettingsRequest, AutofeedSettings>
      updateAutofeedSettingsCallable() {
    return updateAutofeedSettingsCallable;
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
