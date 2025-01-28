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

package com.google.api.cloudquotas.v1beta.stub;

import com.google.api.cloudquotas.v1beta.GetQuotaAdjusterSettingsRequest;
import com.google.api.cloudquotas.v1beta.QuotaAdjusterSettings;
import com.google.api.cloudquotas.v1beta.UpdateQuotaAdjusterSettingsRequest;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the QuotaAdjusterSettingsManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonQuotaAdjusterSettingsManagerStub extends QuotaAdjusterSettingsManagerStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          UpdateQuotaAdjusterSettingsRequest, QuotaAdjusterSettings>
      updateQuotaAdjusterSettingsMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateQuotaAdjusterSettingsRequest, QuotaAdjusterSettings>newBuilder()
              .setFullMethodName(
                  "google.api.cloudquotas.v1beta.QuotaAdjusterSettingsManager/UpdateQuotaAdjusterSettings")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateQuotaAdjusterSettingsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{quotaAdjusterSettings.name=projects/*/locations/*/quotaAdjusterSettings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateQuotaAdjusterSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "quotaAdjusterSettings.name",
                                request.getQuotaAdjusterSettings().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateQuotaAdjusterSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "quotaAdjusterSettings",
                                      request.getQuotaAdjusterSettings(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QuotaAdjusterSettings>newBuilder()
                      .setDefaultInstance(QuotaAdjusterSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetQuotaAdjusterSettingsRequest, QuotaAdjusterSettings>
      getQuotaAdjusterSettingsMethodDescriptor =
          ApiMethodDescriptor.<GetQuotaAdjusterSettingsRequest, QuotaAdjusterSettings>newBuilder()
              .setFullMethodName(
                  "google.api.cloudquotas.v1beta.QuotaAdjusterSettingsManager/GetQuotaAdjusterSettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetQuotaAdjusterSettingsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/quotaAdjusterSettings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetQuotaAdjusterSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetQuotaAdjusterSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QuotaAdjusterSettings>newBuilder()
                      .setDefaultInstance(QuotaAdjusterSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<UpdateQuotaAdjusterSettingsRequest, QuotaAdjusterSettings>
      updateQuotaAdjusterSettingsCallable;
  private final UnaryCallable<GetQuotaAdjusterSettingsRequest, QuotaAdjusterSettings>
      getQuotaAdjusterSettingsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonQuotaAdjusterSettingsManagerStub create(
      QuotaAdjusterSettingsManagerStubSettings settings) throws IOException {
    return new HttpJsonQuotaAdjusterSettingsManagerStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonQuotaAdjusterSettingsManagerStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonQuotaAdjusterSettingsManagerStub(
        QuotaAdjusterSettingsManagerStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonQuotaAdjusterSettingsManagerStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonQuotaAdjusterSettingsManagerStub(
        QuotaAdjusterSettingsManagerStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonQuotaAdjusterSettingsManagerStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonQuotaAdjusterSettingsManagerStub(
      QuotaAdjusterSettingsManagerStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonQuotaAdjusterSettingsManagerCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonQuotaAdjusterSettingsManagerStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonQuotaAdjusterSettingsManagerStub(
      QuotaAdjusterSettingsManagerStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<UpdateQuotaAdjusterSettingsRequest, QuotaAdjusterSettings>
        updateQuotaAdjusterSettingsTransportSettings =
            HttpJsonCallSettings
                .<UpdateQuotaAdjusterSettingsRequest, QuotaAdjusterSettings>newBuilder()
                .setMethodDescriptor(updateQuotaAdjusterSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "quota_adjuster_settings.name",
                          String.valueOf(request.getQuotaAdjusterSettings().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetQuotaAdjusterSettingsRequest, QuotaAdjusterSettings>
        getQuotaAdjusterSettingsTransportSettings =
            HttpJsonCallSettings
                .<GetQuotaAdjusterSettingsRequest, QuotaAdjusterSettings>newBuilder()
                .setMethodDescriptor(getQuotaAdjusterSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.updateQuotaAdjusterSettingsCallable =
        callableFactory.createUnaryCallable(
            updateQuotaAdjusterSettingsTransportSettings,
            settings.updateQuotaAdjusterSettingsSettings(),
            clientContext);
    this.getQuotaAdjusterSettingsCallable =
        callableFactory.createUnaryCallable(
            getQuotaAdjusterSettingsTransportSettings,
            settings.getQuotaAdjusterSettingsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(updateQuotaAdjusterSettingsMethodDescriptor);
    methodDescriptors.add(getQuotaAdjusterSettingsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<UpdateQuotaAdjusterSettingsRequest, QuotaAdjusterSettings>
      updateQuotaAdjusterSettingsCallable() {
    return updateQuotaAdjusterSettingsCallable;
  }

  @Override
  public UnaryCallable<GetQuotaAdjusterSettingsRequest, QuotaAdjusterSettings>
      getQuotaAdjusterSettingsCallable() {
    return getQuotaAdjusterSettingsCallable;
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
