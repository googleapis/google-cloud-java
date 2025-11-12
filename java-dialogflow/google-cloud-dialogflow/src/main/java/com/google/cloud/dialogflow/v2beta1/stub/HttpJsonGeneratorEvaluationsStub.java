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

package com.google.cloud.dialogflow.v2beta1.stub;

import static com.google.cloud.dialogflow.v2beta1.GeneratorEvaluationsClient.ListGeneratorEvaluationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.GeneratorEvaluationsClient.ListLocationsPagedResponse;

import com.google.api.HttpRule;
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
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.CreateGeneratorEvaluationRequest;
import com.google.cloud.dialogflow.v2beta1.DeleteGeneratorEvaluationRequest;
import com.google.cloud.dialogflow.v2beta1.GeneratorEvaluation;
import com.google.cloud.dialogflow.v2beta1.GeneratorEvaluationOperationMetadata;
import com.google.cloud.dialogflow.v2beta1.GetGeneratorEvaluationRequest;
import com.google.cloud.dialogflow.v2beta1.ListGeneratorEvaluationsRequest;
import com.google.cloud.dialogflow.v2beta1.ListGeneratorEvaluationsResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the GeneratorEvaluations service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonGeneratorEvaluationsStub extends GeneratorEvaluationsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(GeneratorEvaluation.getDescriptor())
          .add(GeneratorEvaluationOperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateGeneratorEvaluationRequest, Operation>
      createGeneratorEvaluationMethodDescriptor =
          ApiMethodDescriptor.<CreateGeneratorEvaluationRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2beta1.GeneratorEvaluations/CreateGeneratorEvaluation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateGeneratorEvaluationRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{parent=projects/*/locations/*/generators/*}/evaluations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGeneratorEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGeneratorEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "generatorEvaluation",
                                      request.getGeneratorEvaluation(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateGeneratorEvaluationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetGeneratorEvaluationRequest, GeneratorEvaluation>
      getGeneratorEvaluationMethodDescriptor =
          ApiMethodDescriptor.<GetGeneratorEvaluationRequest, GeneratorEvaluation>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2beta1.GeneratorEvaluations/GetGeneratorEvaluation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGeneratorEvaluationRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{name=projects/*/locations/*/generators/*/evaluations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGeneratorEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGeneratorEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GeneratorEvaluation>newBuilder()
                      .setDefaultInstance(GeneratorEvaluation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListGeneratorEvaluationsRequest, ListGeneratorEvaluationsResponse>
      listGeneratorEvaluationsMethodDescriptor =
          ApiMethodDescriptor
              .<ListGeneratorEvaluationsRequest, ListGeneratorEvaluationsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2beta1.GeneratorEvaluations/ListGeneratorEvaluations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGeneratorEvaluationsRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{parent=projects/*/locations/*/generators/*}/evaluations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGeneratorEvaluationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGeneratorEvaluationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListGeneratorEvaluationsResponse>newBuilder()
                      .setDefaultInstance(ListGeneratorEvaluationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteGeneratorEvaluationRequest, Empty>
      deleteGeneratorEvaluationMethodDescriptor =
          ApiMethodDescriptor.<DeleteGeneratorEvaluationRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2beta1.GeneratorEvaluations/DeleteGeneratorEvaluation")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGeneratorEvaluationRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{name=projects/*/locations/*/generators/*/evaluations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGeneratorEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGeneratorEvaluationRequest> serializer =
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

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateGeneratorEvaluationRequest, Operation>
      createGeneratorEvaluationCallable;
  private final OperationCallable<
          CreateGeneratorEvaluationRequest,
          GeneratorEvaluation,
          GeneratorEvaluationOperationMetadata>
      createGeneratorEvaluationOperationCallable;
  private final UnaryCallable<GetGeneratorEvaluationRequest, GeneratorEvaluation>
      getGeneratorEvaluationCallable;
  private final UnaryCallable<ListGeneratorEvaluationsRequest, ListGeneratorEvaluationsResponse>
      listGeneratorEvaluationsCallable;
  private final UnaryCallable<
          ListGeneratorEvaluationsRequest, ListGeneratorEvaluationsPagedResponse>
      listGeneratorEvaluationsPagedCallable;
  private final UnaryCallable<DeleteGeneratorEvaluationRequest, Empty>
      deleteGeneratorEvaluationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGeneratorEvaluationsStub create(
      GeneratorEvaluationsStubSettings settings) throws IOException {
    return new HttpJsonGeneratorEvaluationsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGeneratorEvaluationsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGeneratorEvaluationsStub(
        GeneratorEvaluationsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonGeneratorEvaluationsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGeneratorEvaluationsStub(
        GeneratorEvaluationsStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGeneratorEvaluationsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGeneratorEvaluationsStub(
      GeneratorEvaluationsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonGeneratorEvaluationsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGeneratorEvaluationsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGeneratorEvaluationsStub(
      GeneratorEvaluationsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v2beta1/{name=projects/*/operations/*}:cancel")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setPost(
                                    "/v2beta1/{name=projects/*/locations/*/operations/*}:cancel")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v2beta1/{name=projects/*/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v2beta1/{name=projects/*/locations/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v2beta1/{name=projects/*}/operations")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v2beta1/{name=projects/*/locations/*}/operations")
                                .build())
                        .build())
                .build());

    HttpJsonCallSettings<CreateGeneratorEvaluationRequest, Operation>
        createGeneratorEvaluationTransportSettings =
            HttpJsonCallSettings.<CreateGeneratorEvaluationRequest, Operation>newBuilder()
                .setMethodDescriptor(createGeneratorEvaluationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetGeneratorEvaluationRequest, GeneratorEvaluation>
        getGeneratorEvaluationTransportSettings =
            HttpJsonCallSettings.<GetGeneratorEvaluationRequest, GeneratorEvaluation>newBuilder()
                .setMethodDescriptor(getGeneratorEvaluationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListGeneratorEvaluationsRequest, ListGeneratorEvaluationsResponse>
        listGeneratorEvaluationsTransportSettings =
            HttpJsonCallSettings
                .<ListGeneratorEvaluationsRequest, ListGeneratorEvaluationsResponse>newBuilder()
                .setMethodDescriptor(listGeneratorEvaluationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteGeneratorEvaluationRequest, Empty>
        deleteGeneratorEvaluationTransportSettings =
            HttpJsonCallSettings.<DeleteGeneratorEvaluationRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteGeneratorEvaluationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.createGeneratorEvaluationCallable =
        callableFactory.createUnaryCallable(
            createGeneratorEvaluationTransportSettings,
            settings.createGeneratorEvaluationSettings(),
            clientContext);
    this.createGeneratorEvaluationOperationCallable =
        callableFactory.createOperationCallable(
            createGeneratorEvaluationTransportSettings,
            settings.createGeneratorEvaluationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getGeneratorEvaluationCallable =
        callableFactory.createUnaryCallable(
            getGeneratorEvaluationTransportSettings,
            settings.getGeneratorEvaluationSettings(),
            clientContext);
    this.listGeneratorEvaluationsCallable =
        callableFactory.createUnaryCallable(
            listGeneratorEvaluationsTransportSettings,
            settings.listGeneratorEvaluationsSettings(),
            clientContext);
    this.listGeneratorEvaluationsPagedCallable =
        callableFactory.createPagedCallable(
            listGeneratorEvaluationsTransportSettings,
            settings.listGeneratorEvaluationsSettings(),
            clientContext);
    this.deleteGeneratorEvaluationCallable =
        callableFactory.createUnaryCallable(
            deleteGeneratorEvaluationTransportSettings,
            settings.deleteGeneratorEvaluationSettings(),
            clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createGeneratorEvaluationMethodDescriptor);
    methodDescriptors.add(getGeneratorEvaluationMethodDescriptor);
    methodDescriptors.add(listGeneratorEvaluationsMethodDescriptor);
    methodDescriptors.add(deleteGeneratorEvaluationMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateGeneratorEvaluationRequest, Operation>
      createGeneratorEvaluationCallable() {
    return createGeneratorEvaluationCallable;
  }

  @Override
  public OperationCallable<
          CreateGeneratorEvaluationRequest,
          GeneratorEvaluation,
          GeneratorEvaluationOperationMetadata>
      createGeneratorEvaluationOperationCallable() {
    return createGeneratorEvaluationOperationCallable;
  }

  @Override
  public UnaryCallable<GetGeneratorEvaluationRequest, GeneratorEvaluation>
      getGeneratorEvaluationCallable() {
    return getGeneratorEvaluationCallable;
  }

  @Override
  public UnaryCallable<ListGeneratorEvaluationsRequest, ListGeneratorEvaluationsResponse>
      listGeneratorEvaluationsCallable() {
    return listGeneratorEvaluationsCallable;
  }

  @Override
  public UnaryCallable<ListGeneratorEvaluationsRequest, ListGeneratorEvaluationsPagedResponse>
      listGeneratorEvaluationsPagedCallable() {
    return listGeneratorEvaluationsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteGeneratorEvaluationRequest, Empty>
      deleteGeneratorEvaluationCallable() {
    return deleteGeneratorEvaluationCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
