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
import com.google.shopping.merchant.accounts.v1beta.BusinessInfo;
import com.google.shopping.merchant.accounts.v1beta.GetBusinessInfoRequest;
import com.google.shopping.merchant.accounts.v1beta.UpdateBusinessInfoRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the BusinessInfoService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonBusinessInfoServiceStub extends BusinessInfoServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetBusinessInfoRequest, BusinessInfo>
      getBusinessInfoMethodDescriptor =
          ApiMethodDescriptor.<GetBusinessInfoRequest, BusinessInfo>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.BusinessInfoService/GetBusinessInfo")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBusinessInfoRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{name=accounts/*/businessInfo}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetBusinessInfoRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetBusinessInfoRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BusinessInfo>newBuilder()
                      .setDefaultInstance(BusinessInfo.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateBusinessInfoRequest, BusinessInfo>
      updateBusinessInfoMethodDescriptor =
          ApiMethodDescriptor.<UpdateBusinessInfoRequest, BusinessInfo>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.BusinessInfoService/UpdateBusinessInfo")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBusinessInfoRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{businessInfo.name=accounts/*/businessInfo}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBusinessInfoRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "businessInfo.name", request.getBusinessInfo().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBusinessInfoRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("businessInfo", request.getBusinessInfo(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BusinessInfo>newBuilder()
                      .setDefaultInstance(BusinessInfo.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetBusinessInfoRequest, BusinessInfo> getBusinessInfoCallable;
  private final UnaryCallable<UpdateBusinessInfoRequest, BusinessInfo> updateBusinessInfoCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonBusinessInfoServiceStub create(
      BusinessInfoServiceStubSettings settings) throws IOException {
    return new HttpJsonBusinessInfoServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonBusinessInfoServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonBusinessInfoServiceStub(
        BusinessInfoServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonBusinessInfoServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonBusinessInfoServiceStub(
        BusinessInfoServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonBusinessInfoServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBusinessInfoServiceStub(
      BusinessInfoServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonBusinessInfoServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonBusinessInfoServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBusinessInfoServiceStub(
      BusinessInfoServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetBusinessInfoRequest, BusinessInfo> getBusinessInfoTransportSettings =
        HttpJsonCallSettings.<GetBusinessInfoRequest, BusinessInfo>newBuilder()
            .setMethodDescriptor(getBusinessInfoMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateBusinessInfoRequest, BusinessInfo>
        updateBusinessInfoTransportSettings =
            HttpJsonCallSettings.<UpdateBusinessInfoRequest, BusinessInfo>newBuilder()
                .setMethodDescriptor(updateBusinessInfoMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "business_info.name",
                          String.valueOf(request.getBusinessInfo().getName()));
                      return builder.build();
                    })
                .build();

    this.getBusinessInfoCallable =
        callableFactory.createUnaryCallable(
            getBusinessInfoTransportSettings, settings.getBusinessInfoSettings(), clientContext);
    this.updateBusinessInfoCallable =
        callableFactory.createUnaryCallable(
            updateBusinessInfoTransportSettings,
            settings.updateBusinessInfoSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getBusinessInfoMethodDescriptor);
    methodDescriptors.add(updateBusinessInfoMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetBusinessInfoRequest, BusinessInfo> getBusinessInfoCallable() {
    return getBusinessInfoCallable;
  }

  @Override
  public UnaryCallable<UpdateBusinessInfoRequest, BusinessInfo> updateBusinessInfoCallable() {
    return updateBusinessInfoCallable;
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
