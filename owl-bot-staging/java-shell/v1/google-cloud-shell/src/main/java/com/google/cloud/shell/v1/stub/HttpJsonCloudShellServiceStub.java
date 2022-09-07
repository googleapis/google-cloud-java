/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.shell.v1.stub;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.shell.v1.AddPublicKeyMetadata;
import com.google.cloud.shell.v1.AddPublicKeyRequest;
import com.google.cloud.shell.v1.AddPublicKeyResponse;
import com.google.cloud.shell.v1.AuthorizeEnvironmentMetadata;
import com.google.cloud.shell.v1.AuthorizeEnvironmentRequest;
import com.google.cloud.shell.v1.AuthorizeEnvironmentResponse;
import com.google.cloud.shell.v1.Environment;
import com.google.cloud.shell.v1.GetEnvironmentRequest;
import com.google.cloud.shell.v1.RemovePublicKeyMetadata;
import com.google.cloud.shell.v1.RemovePublicKeyRequest;
import com.google.cloud.shell.v1.RemovePublicKeyResponse;
import com.google.cloud.shell.v1.StartEnvironmentMetadata;
import com.google.cloud.shell.v1.StartEnvironmentRequest;
import com.google.cloud.shell.v1.StartEnvironmentResponse;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the CloudShellService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonCloudShellServiceStub extends CloudShellServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(StartEnvironmentResponse.getDescriptor())
          .add(RemovePublicKeyResponse.getDescriptor())
          .add(AuthorizeEnvironmentResponse.getDescriptor())
          .add(StartEnvironmentMetadata.getDescriptor())
          .add(RemovePublicKeyMetadata.getDescriptor())
          .add(AddPublicKeyResponse.getDescriptor())
          .add(AuthorizeEnvironmentMetadata.getDescriptor())
          .add(AddPublicKeyMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<GetEnvironmentRequest, Environment>
      getEnvironmentMethodDescriptor =
          ApiMethodDescriptor.<GetEnvironmentRequest, Environment>newBuilder()
              .setFullMethodName("google.cloud.shell.v1.CloudShellService/GetEnvironment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEnvironmentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=users/*/environments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEnvironmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEnvironmentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Environment>newBuilder()
                      .setDefaultInstance(Environment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<StartEnvironmentRequest, Operation>
      startEnvironmentMethodDescriptor =
          ApiMethodDescriptor.<StartEnvironmentRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.shell.v1.CloudShellService/StartEnvironment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StartEnvironmentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=users/*/environments/*}:start",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StartEnvironmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StartEnvironmentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (StartEnvironmentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<AuthorizeEnvironmentRequest, Operation>
      authorizeEnvironmentMethodDescriptor =
          ApiMethodDescriptor.<AuthorizeEnvironmentRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.shell.v1.CloudShellService/AuthorizeEnvironment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AuthorizeEnvironmentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=users/*/environments/*}:authorize",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AuthorizeEnvironmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AuthorizeEnvironmentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AuthorizeEnvironmentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<AddPublicKeyRequest, Operation>
      addPublicKeyMethodDescriptor =
          ApiMethodDescriptor.<AddPublicKeyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.shell.v1.CloudShellService/AddPublicKey")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddPublicKeyRequest>newBuilder()
                      .setPath(
                          "/v1/{environment=users/*/environments/*}:addPublicKey",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddPublicKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "environment", request.getEnvironment());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddPublicKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearEnvironment().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AddPublicKeyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RemovePublicKeyRequest, Operation>
      removePublicKeyMethodDescriptor =
          ApiMethodDescriptor.<RemovePublicKeyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.shell.v1.CloudShellService/RemovePublicKey")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemovePublicKeyRequest>newBuilder()
                      .setPath(
                          "/v1/{environment=users/*/environments/*}:removePublicKey",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemovePublicKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "environment", request.getEnvironment());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemovePublicKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearEnvironment().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RemovePublicKeyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<GetEnvironmentRequest, Environment> getEnvironmentCallable;
  private final UnaryCallable<StartEnvironmentRequest, Operation> startEnvironmentCallable;
  private final OperationCallable<
          StartEnvironmentRequest, StartEnvironmentResponse, StartEnvironmentMetadata>
      startEnvironmentOperationCallable;
  private final UnaryCallable<AuthorizeEnvironmentRequest, Operation> authorizeEnvironmentCallable;
  private final OperationCallable<
          AuthorizeEnvironmentRequest, AuthorizeEnvironmentResponse, AuthorizeEnvironmentMetadata>
      authorizeEnvironmentOperationCallable;
  private final UnaryCallable<AddPublicKeyRequest, Operation> addPublicKeyCallable;
  private final OperationCallable<AddPublicKeyRequest, AddPublicKeyResponse, AddPublicKeyMetadata>
      addPublicKeyOperationCallable;
  private final UnaryCallable<RemovePublicKeyRequest, Operation> removePublicKeyCallable;
  private final OperationCallable<
          RemovePublicKeyRequest, RemovePublicKeyResponse, RemovePublicKeyMetadata>
      removePublicKeyOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCloudShellServiceStub create(CloudShellServiceStubSettings settings)
      throws IOException {
    return new HttpJsonCloudShellServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCloudShellServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCloudShellServiceStub(
        CloudShellServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCloudShellServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCloudShellServiceStub(
        CloudShellServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCloudShellServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCloudShellServiceStub(
      CloudShellServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonCloudShellServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCloudShellServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCloudShellServiceStub(
      CloudShellServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<GetEnvironmentRequest, Environment> getEnvironmentTransportSettings =
        HttpJsonCallSettings.<GetEnvironmentRequest, Environment>newBuilder()
            .setMethodDescriptor(getEnvironmentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<StartEnvironmentRequest, Operation> startEnvironmentTransportSettings =
        HttpJsonCallSettings.<StartEnvironmentRequest, Operation>newBuilder()
            .setMethodDescriptor(startEnvironmentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<AuthorizeEnvironmentRequest, Operation>
        authorizeEnvironmentTransportSettings =
            HttpJsonCallSettings.<AuthorizeEnvironmentRequest, Operation>newBuilder()
                .setMethodDescriptor(authorizeEnvironmentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AddPublicKeyRequest, Operation> addPublicKeyTransportSettings =
        HttpJsonCallSettings.<AddPublicKeyRequest, Operation>newBuilder()
            .setMethodDescriptor(addPublicKeyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RemovePublicKeyRequest, Operation> removePublicKeyTransportSettings =
        HttpJsonCallSettings.<RemovePublicKeyRequest, Operation>newBuilder()
            .setMethodDescriptor(removePublicKeyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.getEnvironmentCallable =
        callableFactory.createUnaryCallable(
            getEnvironmentTransportSettings, settings.getEnvironmentSettings(), clientContext);
    this.startEnvironmentCallable =
        callableFactory.createUnaryCallable(
            startEnvironmentTransportSettings, settings.startEnvironmentSettings(), clientContext);
    this.startEnvironmentOperationCallable =
        callableFactory.createOperationCallable(
            startEnvironmentTransportSettings,
            settings.startEnvironmentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.authorizeEnvironmentCallable =
        callableFactory.createUnaryCallable(
            authorizeEnvironmentTransportSettings,
            settings.authorizeEnvironmentSettings(),
            clientContext);
    this.authorizeEnvironmentOperationCallable =
        callableFactory.createOperationCallable(
            authorizeEnvironmentTransportSettings,
            settings.authorizeEnvironmentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.addPublicKeyCallable =
        callableFactory.createUnaryCallable(
            addPublicKeyTransportSettings, settings.addPublicKeySettings(), clientContext);
    this.addPublicKeyOperationCallable =
        callableFactory.createOperationCallable(
            addPublicKeyTransportSettings,
            settings.addPublicKeyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.removePublicKeyCallable =
        callableFactory.createUnaryCallable(
            removePublicKeyTransportSettings, settings.removePublicKeySettings(), clientContext);
    this.removePublicKeyOperationCallable =
        callableFactory.createOperationCallable(
            removePublicKeyTransportSettings,
            settings.removePublicKeyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getEnvironmentMethodDescriptor);
    methodDescriptors.add(startEnvironmentMethodDescriptor);
    methodDescriptors.add(authorizeEnvironmentMethodDescriptor);
    methodDescriptors.add(addPublicKeyMethodDescriptor);
    methodDescriptors.add(removePublicKeyMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<GetEnvironmentRequest, Environment> getEnvironmentCallable() {
    return getEnvironmentCallable;
  }

  @Override
  public UnaryCallable<StartEnvironmentRequest, Operation> startEnvironmentCallable() {
    return startEnvironmentCallable;
  }

  @Override
  public OperationCallable<
          StartEnvironmentRequest, StartEnvironmentResponse, StartEnvironmentMetadata>
      startEnvironmentOperationCallable() {
    return startEnvironmentOperationCallable;
  }

  @Override
  public UnaryCallable<AuthorizeEnvironmentRequest, Operation> authorizeEnvironmentCallable() {
    return authorizeEnvironmentCallable;
  }

  @Override
  public OperationCallable<
          AuthorizeEnvironmentRequest, AuthorizeEnvironmentResponse, AuthorizeEnvironmentMetadata>
      authorizeEnvironmentOperationCallable() {
    return authorizeEnvironmentOperationCallable;
  }

  @Override
  public UnaryCallable<AddPublicKeyRequest, Operation> addPublicKeyCallable() {
    return addPublicKeyCallable;
  }

  @Override
  public OperationCallable<AddPublicKeyRequest, AddPublicKeyResponse, AddPublicKeyMetadata>
      addPublicKeyOperationCallable() {
    return addPublicKeyOperationCallable;
  }

  @Override
  public UnaryCallable<RemovePublicKeyRequest, Operation> removePublicKeyCallable() {
    return removePublicKeyCallable;
  }

  @Override
  public OperationCallable<RemovePublicKeyRequest, RemovePublicKeyResponse, RemovePublicKeyMetadata>
      removePublicKeyOperationCallable() {
    return removePublicKeyOperationCallable;
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
