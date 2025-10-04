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
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import com.google.shopping.merchant.accounts.v1.DeveloperRegistration;
import com.google.shopping.merchant.accounts.v1.GetDeveloperRegistrationRequest;
import com.google.shopping.merchant.accounts.v1.RegisterGcpRequest;
import com.google.shopping.merchant.accounts.v1.UnregisterGcpRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the DeveloperRegistrationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonDeveloperRegistrationServiceStub extends DeveloperRegistrationServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<RegisterGcpRequest, DeveloperRegistration>
      registerGcpMethodDescriptor =
          ApiMethodDescriptor.<RegisterGcpRequest, DeveloperRegistration>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.DeveloperRegistrationService/RegisterGcp")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RegisterGcpRequest>newBuilder()
                      .setPath(
                          "/accounts/v1/{name=accounts/*/developerRegistration}:registerGcp",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RegisterGcpRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RegisterGcpRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeveloperRegistration>newBuilder()
                      .setDefaultInstance(DeveloperRegistration.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDeveloperRegistrationRequest, DeveloperRegistration>
      getDeveloperRegistrationMethodDescriptor =
          ApiMethodDescriptor.<GetDeveloperRegistrationRequest, DeveloperRegistration>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.DeveloperRegistrationService/GetDeveloperRegistration")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDeveloperRegistrationRequest>newBuilder()
                      .setPath(
                          "/accounts/v1/{name=accounts/*/developerRegistration}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeveloperRegistrationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeveloperRegistrationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeveloperRegistration>newBuilder()
                      .setDefaultInstance(DeveloperRegistration.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UnregisterGcpRequest, Empty>
      unregisterGcpMethodDescriptor =
          ApiMethodDescriptor.<UnregisterGcpRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.DeveloperRegistrationService/UnregisterGcp")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UnregisterGcpRequest>newBuilder()
                      .setPath(
                          "/accounts/v1/{name=accounts/*/developerRegistration}:unregisterGcp",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UnregisterGcpRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UnregisterGcpRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<RegisterGcpRequest, DeveloperRegistration> registerGcpCallable;
  private final UnaryCallable<GetDeveloperRegistrationRequest, DeveloperRegistration>
      getDeveloperRegistrationCallable;
  private final UnaryCallable<UnregisterGcpRequest, Empty> unregisterGcpCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDeveloperRegistrationServiceStub create(
      DeveloperRegistrationServiceStubSettings settings) throws IOException {
    return new HttpJsonDeveloperRegistrationServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDeveloperRegistrationServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDeveloperRegistrationServiceStub(
        DeveloperRegistrationServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDeveloperRegistrationServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDeveloperRegistrationServiceStub(
        DeveloperRegistrationServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDeveloperRegistrationServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonDeveloperRegistrationServiceStub(
      DeveloperRegistrationServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonDeveloperRegistrationServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDeveloperRegistrationServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonDeveloperRegistrationServiceStub(
      DeveloperRegistrationServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<RegisterGcpRequest, DeveloperRegistration> registerGcpTransportSettings =
        HttpJsonCallSettings.<RegisterGcpRequest, DeveloperRegistration>newBuilder()
            .setMethodDescriptor(registerGcpMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetDeveloperRegistrationRequest, DeveloperRegistration>
        getDeveloperRegistrationTransportSettings =
            HttpJsonCallSettings
                .<GetDeveloperRegistrationRequest, DeveloperRegistration>newBuilder()
                .setMethodDescriptor(getDeveloperRegistrationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UnregisterGcpRequest, Empty> unregisterGcpTransportSettings =
        HttpJsonCallSettings.<UnregisterGcpRequest, Empty>newBuilder()
            .setMethodDescriptor(unregisterGcpMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.registerGcpCallable =
        callableFactory.createUnaryCallable(
            registerGcpTransportSettings, settings.registerGcpSettings(), clientContext);
    this.getDeveloperRegistrationCallable =
        callableFactory.createUnaryCallable(
            getDeveloperRegistrationTransportSettings,
            settings.getDeveloperRegistrationSettings(),
            clientContext);
    this.unregisterGcpCallable =
        callableFactory.createUnaryCallable(
            unregisterGcpTransportSettings, settings.unregisterGcpSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(registerGcpMethodDescriptor);
    methodDescriptors.add(getDeveloperRegistrationMethodDescriptor);
    methodDescriptors.add(unregisterGcpMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<RegisterGcpRequest, DeveloperRegistration> registerGcpCallable() {
    return registerGcpCallable;
  }

  @Override
  public UnaryCallable<GetDeveloperRegistrationRequest, DeveloperRegistration>
      getDeveloperRegistrationCallable() {
    return getDeveloperRegistrationCallable;
  }

  @Override
  public UnaryCallable<UnregisterGcpRequest, Empty> unregisterGcpCallable() {
    return unregisterGcpCallable;
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
