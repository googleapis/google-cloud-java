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

package com.google.cloud.recommendationengine.v1beta1.stub;

import static com.google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistryClient.ListPredictionApiKeyRegistrationsPagedResponse;

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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.recommendationengine.v1beta1.CreatePredictionApiKeyRegistrationRequest;
import com.google.cloud.recommendationengine.v1beta1.DeletePredictionApiKeyRegistrationRequest;
import com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsRequest;
import com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsResponse;
import com.google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistration;
import com.google.protobuf.Empty;
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
 * REST stub implementation for the PredictionApiKeyRegistry service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonPredictionApiKeyRegistryStub extends PredictionApiKeyRegistryStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          CreatePredictionApiKeyRegistrationRequest, PredictionApiKeyRegistration>
      createPredictionApiKeyRegistrationMethodDescriptor =
          ApiMethodDescriptor
              .<CreatePredictionApiKeyRegistrationRequest, PredictionApiKeyRegistration>newBuilder()
              .setFullMethodName(
                  "google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistry/CreatePredictionApiKeyRegistration")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<CreatePredictionApiKeyRegistrationRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/catalogs/*/eventStores/*}/predictionApiKeyRegistrations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePredictionApiKeyRegistrationRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePredictionApiKeyRegistrationRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PredictionApiKeyRegistration>newBuilder()
                      .setDefaultInstance(PredictionApiKeyRegistration.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListPredictionApiKeyRegistrationsRequest, ListPredictionApiKeyRegistrationsResponse>
      listPredictionApiKeyRegistrationsMethodDescriptor =
          ApiMethodDescriptor
              .<ListPredictionApiKeyRegistrationsRequest, ListPredictionApiKeyRegistrationsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistry/ListPredictionApiKeyRegistrations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListPredictionApiKeyRegistrationsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/catalogs/*/eventStores/*}/predictionApiKeyRegistrations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPredictionApiKeyRegistrationsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPredictionApiKeyRegistrationsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPredictionApiKeyRegistrationsResponse>newBuilder()
                      .setDefaultInstance(
                          ListPredictionApiKeyRegistrationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeletePredictionApiKeyRegistrationRequest, Empty>
      deletePredictionApiKeyRegistrationMethodDescriptor =
          ApiMethodDescriptor.<DeletePredictionApiKeyRegistrationRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistry/DeletePredictionApiKeyRegistration")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeletePredictionApiKeyRegistrationRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/catalogs/*/eventStores/*/predictionApiKeyRegistrations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePredictionApiKeyRegistrationRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePredictionApiKeyRegistrationRequest>
                                serializer = ProtoRestSerializer.create();
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

  private final UnaryCallable<
          CreatePredictionApiKeyRegistrationRequest, PredictionApiKeyRegistration>
      createPredictionApiKeyRegistrationCallable;
  private final UnaryCallable<
          ListPredictionApiKeyRegistrationsRequest, ListPredictionApiKeyRegistrationsResponse>
      listPredictionApiKeyRegistrationsCallable;
  private final UnaryCallable<
          ListPredictionApiKeyRegistrationsRequest, ListPredictionApiKeyRegistrationsPagedResponse>
      listPredictionApiKeyRegistrationsPagedCallable;
  private final UnaryCallable<DeletePredictionApiKeyRegistrationRequest, Empty>
      deletePredictionApiKeyRegistrationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPredictionApiKeyRegistryStub create(
      PredictionApiKeyRegistryStubSettings settings) throws IOException {
    return new HttpJsonPredictionApiKeyRegistryStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPredictionApiKeyRegistryStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonPredictionApiKeyRegistryStub(
        PredictionApiKeyRegistryStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonPredictionApiKeyRegistryStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPredictionApiKeyRegistryStub(
        PredictionApiKeyRegistryStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPredictionApiKeyRegistryStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPredictionApiKeyRegistryStub(
      PredictionApiKeyRegistryStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonPredictionApiKeyRegistryCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPredictionApiKeyRegistryStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPredictionApiKeyRegistryStub(
      PredictionApiKeyRegistryStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreatePredictionApiKeyRegistrationRequest, PredictionApiKeyRegistration>
        createPredictionApiKeyRegistrationTransportSettings =
            HttpJsonCallSettings
                .<CreatePredictionApiKeyRegistrationRequest, PredictionApiKeyRegistration>
                    newBuilder()
                .setMethodDescriptor(createPredictionApiKeyRegistrationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            ListPredictionApiKeyRegistrationsRequest, ListPredictionApiKeyRegistrationsResponse>
        listPredictionApiKeyRegistrationsTransportSettings =
            HttpJsonCallSettings
                .<ListPredictionApiKeyRegistrationsRequest,
                    ListPredictionApiKeyRegistrationsResponse>
                    newBuilder()
                .setMethodDescriptor(listPredictionApiKeyRegistrationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeletePredictionApiKeyRegistrationRequest, Empty>
        deletePredictionApiKeyRegistrationTransportSettings =
            HttpJsonCallSettings.<DeletePredictionApiKeyRegistrationRequest, Empty>newBuilder()
                .setMethodDescriptor(deletePredictionApiKeyRegistrationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.createPredictionApiKeyRegistrationCallable =
        callableFactory.createUnaryCallable(
            createPredictionApiKeyRegistrationTransportSettings,
            settings.createPredictionApiKeyRegistrationSettings(),
            clientContext);
    this.listPredictionApiKeyRegistrationsCallable =
        callableFactory.createUnaryCallable(
            listPredictionApiKeyRegistrationsTransportSettings,
            settings.listPredictionApiKeyRegistrationsSettings(),
            clientContext);
    this.listPredictionApiKeyRegistrationsPagedCallable =
        callableFactory.createPagedCallable(
            listPredictionApiKeyRegistrationsTransportSettings,
            settings.listPredictionApiKeyRegistrationsSettings(),
            clientContext);
    this.deletePredictionApiKeyRegistrationCallable =
        callableFactory.createUnaryCallable(
            deletePredictionApiKeyRegistrationTransportSettings,
            settings.deletePredictionApiKeyRegistrationSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createPredictionApiKeyRegistrationMethodDescriptor);
    methodDescriptors.add(listPredictionApiKeyRegistrationsMethodDescriptor);
    methodDescriptors.add(deletePredictionApiKeyRegistrationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreatePredictionApiKeyRegistrationRequest, PredictionApiKeyRegistration>
      createPredictionApiKeyRegistrationCallable() {
    return createPredictionApiKeyRegistrationCallable;
  }

  @Override
  public UnaryCallable<
          ListPredictionApiKeyRegistrationsRequest, ListPredictionApiKeyRegistrationsResponse>
      listPredictionApiKeyRegistrationsCallable() {
    return listPredictionApiKeyRegistrationsCallable;
  }

  @Override
  public UnaryCallable<
          ListPredictionApiKeyRegistrationsRequest, ListPredictionApiKeyRegistrationsPagedResponse>
      listPredictionApiKeyRegistrationsPagedCallable() {
    return listPredictionApiKeyRegistrationsPagedCallable;
  }

  @Override
  public UnaryCallable<DeletePredictionApiKeyRegistrationRequest, Empty>
      deletePredictionApiKeyRegistrationCallable() {
    return deletePredictionApiKeyRegistrationCallable;
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
