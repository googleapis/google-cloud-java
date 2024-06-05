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
import com.google.shopping.merchant.accounts.v1beta.BusinessIdentity;
import com.google.shopping.merchant.accounts.v1beta.GetBusinessIdentityRequest;
import com.google.shopping.merchant.accounts.v1beta.UpdateBusinessIdentityRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the BusinessIdentityService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonBusinessIdentityServiceStub extends BusinessIdentityServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetBusinessIdentityRequest, BusinessIdentity>
      getBusinessIdentityMethodDescriptor =
          ApiMethodDescriptor.<GetBusinessIdentityRequest, BusinessIdentity>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.BusinessIdentityService/GetBusinessIdentity")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBusinessIdentityRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{name=accounts/*/businessIdentity}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetBusinessIdentityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetBusinessIdentityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BusinessIdentity>newBuilder()
                      .setDefaultInstance(BusinessIdentity.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateBusinessIdentityRequest, BusinessIdentity>
      updateBusinessIdentityMethodDescriptor =
          ApiMethodDescriptor.<UpdateBusinessIdentityRequest, BusinessIdentity>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.BusinessIdentityService/UpdateBusinessIdentity")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBusinessIdentityRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{businessIdentity.name=accounts/*/businessIdentity}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBusinessIdentityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "businessIdentity.name",
                                request.getBusinessIdentity().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBusinessIdentityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("businessIdentity", request.getBusinessIdentity(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BusinessIdentity>newBuilder()
                      .setDefaultInstance(BusinessIdentity.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetBusinessIdentityRequest, BusinessIdentity>
      getBusinessIdentityCallable;
  private final UnaryCallable<UpdateBusinessIdentityRequest, BusinessIdentity>
      updateBusinessIdentityCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonBusinessIdentityServiceStub create(
      BusinessIdentityServiceStubSettings settings) throws IOException {
    return new HttpJsonBusinessIdentityServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonBusinessIdentityServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonBusinessIdentityServiceStub(
        BusinessIdentityServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonBusinessIdentityServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonBusinessIdentityServiceStub(
        BusinessIdentityServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonBusinessIdentityServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBusinessIdentityServiceStub(
      BusinessIdentityServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonBusinessIdentityServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonBusinessIdentityServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBusinessIdentityServiceStub(
      BusinessIdentityServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetBusinessIdentityRequest, BusinessIdentity>
        getBusinessIdentityTransportSettings =
            HttpJsonCallSettings.<GetBusinessIdentityRequest, BusinessIdentity>newBuilder()
                .setMethodDescriptor(getBusinessIdentityMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateBusinessIdentityRequest, BusinessIdentity>
        updateBusinessIdentityTransportSettings =
            HttpJsonCallSettings.<UpdateBusinessIdentityRequest, BusinessIdentity>newBuilder()
                .setMethodDescriptor(updateBusinessIdentityMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "business_identity.name",
                          String.valueOf(request.getBusinessIdentity().getName()));
                      return builder.build();
                    })
                .build();

    this.getBusinessIdentityCallable =
        callableFactory.createUnaryCallable(
            getBusinessIdentityTransportSettings,
            settings.getBusinessIdentitySettings(),
            clientContext);
    this.updateBusinessIdentityCallable =
        callableFactory.createUnaryCallable(
            updateBusinessIdentityTransportSettings,
            settings.updateBusinessIdentitySettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getBusinessIdentityMethodDescriptor);
    methodDescriptors.add(updateBusinessIdentityMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetBusinessIdentityRequest, BusinessIdentity> getBusinessIdentityCallable() {
    return getBusinessIdentityCallable;
  }

  @Override
  public UnaryCallable<UpdateBusinessIdentityRequest, BusinessIdentity>
      updateBusinessIdentityCallable() {
    return updateBusinessIdentityCallable;
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
