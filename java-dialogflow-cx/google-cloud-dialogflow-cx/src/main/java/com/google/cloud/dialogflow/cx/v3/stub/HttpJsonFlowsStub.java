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

package com.google.cloud.dialogflow.cx.v3.stub;

import static com.google.cloud.dialogflow.cx.v3.FlowsClient.ListFlowsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3.FlowsClient.ListLocationsPagedResponse;

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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3.CreateFlowRequest;
import com.google.cloud.dialogflow.cx.v3.DeleteFlowRequest;
import com.google.cloud.dialogflow.cx.v3.ExportFlowRequest;
import com.google.cloud.dialogflow.cx.v3.ExportFlowResponse;
import com.google.cloud.dialogflow.cx.v3.Flow;
import com.google.cloud.dialogflow.cx.v3.FlowValidationResult;
import com.google.cloud.dialogflow.cx.v3.GetFlowRequest;
import com.google.cloud.dialogflow.cx.v3.GetFlowValidationResultRequest;
import com.google.cloud.dialogflow.cx.v3.ImportFlowRequest;
import com.google.cloud.dialogflow.cx.v3.ImportFlowResponse;
import com.google.cloud.dialogflow.cx.v3.ListFlowsRequest;
import com.google.cloud.dialogflow.cx.v3.ListFlowsResponse;
import com.google.cloud.dialogflow.cx.v3.TrainFlowRequest;
import com.google.cloud.dialogflow.cx.v3.UpdateFlowRequest;
import com.google.cloud.dialogflow.cx.v3.ValidateFlowRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
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
 * REST stub implementation for the Flows service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonFlowsStub extends FlowsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(ExportFlowResponse.getDescriptor())
          .add(ImportFlowResponse.getDescriptor())
          .add(Struct.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateFlowRequest, Flow> createFlowMethodDescriptor =
      ApiMethodDescriptor.<CreateFlowRequest, Flow>newBuilder()
          .setFullMethodName("google.cloud.dialogflow.cx.v3.Flows/CreateFlow")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateFlowRequest>newBuilder()
                  .setPath(
                      "/v3/{parent=projects/*/locations/*/agents/*}/flows",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateFlowRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateFlowRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "languageCode", request.getLanguageCode());
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("flow", request.getFlow(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Flow>newBuilder()
                  .setDefaultInstance(Flow.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteFlowRequest, Empty> deleteFlowMethodDescriptor =
      ApiMethodDescriptor.<DeleteFlowRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.dialogflow.cx.v3.Flows/DeleteFlow")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteFlowRequest>newBuilder()
                  .setPath(
                      "/v3/{name=projects/*/locations/*/agents/*/flows/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteFlowRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteFlowRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "force", request.getForce());
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

  private static final ApiMethodDescriptor<ListFlowsRequest, ListFlowsResponse>
      listFlowsMethodDescriptor =
          ApiMethodDescriptor.<ListFlowsRequest, ListFlowsResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Flows/ListFlows")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFlowsRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*/agents/*}/flows",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFlowsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFlowsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListFlowsResponse>newBuilder()
                      .setDefaultInstance(ListFlowsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetFlowRequest, Flow> getFlowMethodDescriptor =
      ApiMethodDescriptor.<GetFlowRequest, Flow>newBuilder()
          .setFullMethodName("google.cloud.dialogflow.cx.v3.Flows/GetFlow")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetFlowRequest>newBuilder()
                  .setPath(
                      "/v3/{name=projects/*/locations/*/agents/*/flows/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetFlowRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetFlowRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "languageCode", request.getLanguageCode());
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Flow>newBuilder()
                  .setDefaultInstance(Flow.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateFlowRequest, Flow> updateFlowMethodDescriptor =
      ApiMethodDescriptor.<UpdateFlowRequest, Flow>newBuilder()
          .setFullMethodName("google.cloud.dialogflow.cx.v3.Flows/UpdateFlow")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateFlowRequest>newBuilder()
                  .setPath(
                      "/v3/{flow.name=projects/*/locations/*/agents/*/flows/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateFlowRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "flow.name", request.getFlow().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateFlowRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "languageCode", request.getLanguageCode());
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("flow", request.getFlow(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Flow>newBuilder()
                  .setDefaultInstance(Flow.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<TrainFlowRequest, Operation> trainFlowMethodDescriptor =
      ApiMethodDescriptor.<TrainFlowRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.dialogflow.cx.v3.Flows/TrainFlow")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<TrainFlowRequest>newBuilder()
                  .setPath(
                      "/v3/{name=projects/*/locations/*/agents/*/flows/*}:train",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<TrainFlowRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<TrainFlowRequest> serializer =
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
              (TrainFlowRequest request, Operation response) ->
                  HttpJsonOperationSnapshot.create(response))
          .build();

  private static final ApiMethodDescriptor<ValidateFlowRequest, FlowValidationResult>
      validateFlowMethodDescriptor =
          ApiMethodDescriptor.<ValidateFlowRequest, FlowValidationResult>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Flows/ValidateFlow")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ValidateFlowRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*/locations/*/agents/*/flows/*}:validate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ValidateFlowRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ValidateFlowRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FlowValidationResult>newBuilder()
                      .setDefaultInstance(FlowValidationResult.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetFlowValidationResultRequest, FlowValidationResult>
      getFlowValidationResultMethodDescriptor =
          ApiMethodDescriptor.<GetFlowValidationResultRequest, FlowValidationResult>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Flows/GetFlowValidationResult")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetFlowValidationResultRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*/locations/*/agents/*/flows/*/validationResult}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetFlowValidationResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetFlowValidationResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FlowValidationResult>newBuilder()
                      .setDefaultInstance(FlowValidationResult.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ImportFlowRequest, Operation>
      importFlowMethodDescriptor =
          ApiMethodDescriptor.<ImportFlowRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Flows/ImportFlow")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportFlowRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*/agents/*}/flows:import",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportFlowRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportFlowRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ImportFlowRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExportFlowRequest, Operation>
      exportFlowMethodDescriptor =
          ApiMethodDescriptor.<ExportFlowRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Flows/ExportFlow")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportFlowRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*/locations/*/agents/*/flows/*}:export",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportFlowRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportFlowRequest> serializer =
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
                  (ExportFlowRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
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
                          "/v3/{name=projects/*}/locations",
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
                          "/v3/{name=projects/*/locations/*}",
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

  private final UnaryCallable<CreateFlowRequest, Flow> createFlowCallable;
  private final UnaryCallable<DeleteFlowRequest, Empty> deleteFlowCallable;
  private final UnaryCallable<ListFlowsRequest, ListFlowsResponse> listFlowsCallable;
  private final UnaryCallable<ListFlowsRequest, ListFlowsPagedResponse> listFlowsPagedCallable;
  private final UnaryCallable<GetFlowRequest, Flow> getFlowCallable;
  private final UnaryCallable<UpdateFlowRequest, Flow> updateFlowCallable;
  private final UnaryCallable<TrainFlowRequest, Operation> trainFlowCallable;
  private final OperationCallable<TrainFlowRequest, Empty, Struct> trainFlowOperationCallable;
  private final UnaryCallable<ValidateFlowRequest, FlowValidationResult> validateFlowCallable;
  private final UnaryCallable<GetFlowValidationResultRequest, FlowValidationResult>
      getFlowValidationResultCallable;
  private final UnaryCallable<ImportFlowRequest, Operation> importFlowCallable;
  private final OperationCallable<ImportFlowRequest, ImportFlowResponse, Struct>
      importFlowOperationCallable;
  private final UnaryCallable<ExportFlowRequest, Operation> exportFlowCallable;
  private final OperationCallable<ExportFlowRequest, ExportFlowResponse, Struct>
      exportFlowOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonFlowsStub create(FlowsStubSettings settings) throws IOException {
    return new HttpJsonFlowsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonFlowsStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonFlowsStub(FlowsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonFlowsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonFlowsStub(
        FlowsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonFlowsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonFlowsStub(FlowsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonFlowsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonFlowsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonFlowsStub(
      FlowsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateFlowRequest, Flow> createFlowTransportSettings =
        HttpJsonCallSettings.<CreateFlowRequest, Flow>newBuilder()
            .setMethodDescriptor(createFlowMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteFlowRequest, Empty> deleteFlowTransportSettings =
        HttpJsonCallSettings.<DeleteFlowRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteFlowMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListFlowsRequest, ListFlowsResponse> listFlowsTransportSettings =
        HttpJsonCallSettings.<ListFlowsRequest, ListFlowsResponse>newBuilder()
            .setMethodDescriptor(listFlowsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetFlowRequest, Flow> getFlowTransportSettings =
        HttpJsonCallSettings.<GetFlowRequest, Flow>newBuilder()
            .setMethodDescriptor(getFlowMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateFlowRequest, Flow> updateFlowTransportSettings =
        HttpJsonCallSettings.<UpdateFlowRequest, Flow>newBuilder()
            .setMethodDescriptor(updateFlowMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<TrainFlowRequest, Operation> trainFlowTransportSettings =
        HttpJsonCallSettings.<TrainFlowRequest, Operation>newBuilder()
            .setMethodDescriptor(trainFlowMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ValidateFlowRequest, FlowValidationResult> validateFlowTransportSettings =
        HttpJsonCallSettings.<ValidateFlowRequest, FlowValidationResult>newBuilder()
            .setMethodDescriptor(validateFlowMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetFlowValidationResultRequest, FlowValidationResult>
        getFlowValidationResultTransportSettings =
            HttpJsonCallSettings.<GetFlowValidationResultRequest, FlowValidationResult>newBuilder()
                .setMethodDescriptor(getFlowValidationResultMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ImportFlowRequest, Operation> importFlowTransportSettings =
        HttpJsonCallSettings.<ImportFlowRequest, Operation>newBuilder()
            .setMethodDescriptor(importFlowMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ExportFlowRequest, Operation> exportFlowTransportSettings =
        HttpJsonCallSettings.<ExportFlowRequest, Operation>newBuilder()
            .setMethodDescriptor(exportFlowMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.createFlowCallable =
        callableFactory.createUnaryCallable(
            createFlowTransportSettings, settings.createFlowSettings(), clientContext);
    this.deleteFlowCallable =
        callableFactory.createUnaryCallable(
            deleteFlowTransportSettings, settings.deleteFlowSettings(), clientContext);
    this.listFlowsCallable =
        callableFactory.createUnaryCallable(
            listFlowsTransportSettings, settings.listFlowsSettings(), clientContext);
    this.listFlowsPagedCallable =
        callableFactory.createPagedCallable(
            listFlowsTransportSettings, settings.listFlowsSettings(), clientContext);
    this.getFlowCallable =
        callableFactory.createUnaryCallable(
            getFlowTransportSettings, settings.getFlowSettings(), clientContext);
    this.updateFlowCallable =
        callableFactory.createUnaryCallable(
            updateFlowTransportSettings, settings.updateFlowSettings(), clientContext);
    this.trainFlowCallable =
        callableFactory.createUnaryCallable(
            trainFlowTransportSettings, settings.trainFlowSettings(), clientContext);
    this.trainFlowOperationCallable =
        callableFactory.createOperationCallable(
            trainFlowTransportSettings,
            settings.trainFlowOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.validateFlowCallable =
        callableFactory.createUnaryCallable(
            validateFlowTransportSettings, settings.validateFlowSettings(), clientContext);
    this.getFlowValidationResultCallable =
        callableFactory.createUnaryCallable(
            getFlowValidationResultTransportSettings,
            settings.getFlowValidationResultSettings(),
            clientContext);
    this.importFlowCallable =
        callableFactory.createUnaryCallable(
            importFlowTransportSettings, settings.importFlowSettings(), clientContext);
    this.importFlowOperationCallable =
        callableFactory.createOperationCallable(
            importFlowTransportSettings,
            settings.importFlowOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.exportFlowCallable =
        callableFactory.createUnaryCallable(
            exportFlowTransportSettings, settings.exportFlowSettings(), clientContext);
    this.exportFlowOperationCallable =
        callableFactory.createOperationCallable(
            exportFlowTransportSettings,
            settings.exportFlowOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
    methodDescriptors.add(createFlowMethodDescriptor);
    methodDescriptors.add(deleteFlowMethodDescriptor);
    methodDescriptors.add(listFlowsMethodDescriptor);
    methodDescriptors.add(getFlowMethodDescriptor);
    methodDescriptors.add(updateFlowMethodDescriptor);
    methodDescriptors.add(trainFlowMethodDescriptor);
    methodDescriptors.add(validateFlowMethodDescriptor);
    methodDescriptors.add(getFlowValidationResultMethodDescriptor);
    methodDescriptors.add(importFlowMethodDescriptor);
    methodDescriptors.add(exportFlowMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateFlowRequest, Flow> createFlowCallable() {
    return createFlowCallable;
  }

  @Override
  public UnaryCallable<DeleteFlowRequest, Empty> deleteFlowCallable() {
    return deleteFlowCallable;
  }

  @Override
  public UnaryCallable<ListFlowsRequest, ListFlowsResponse> listFlowsCallable() {
    return listFlowsCallable;
  }

  @Override
  public UnaryCallable<ListFlowsRequest, ListFlowsPagedResponse> listFlowsPagedCallable() {
    return listFlowsPagedCallable;
  }

  @Override
  public UnaryCallable<GetFlowRequest, Flow> getFlowCallable() {
    return getFlowCallable;
  }

  @Override
  public UnaryCallable<UpdateFlowRequest, Flow> updateFlowCallable() {
    return updateFlowCallable;
  }

  @Override
  public UnaryCallable<TrainFlowRequest, Operation> trainFlowCallable() {
    return trainFlowCallable;
  }

  @Override
  public OperationCallable<TrainFlowRequest, Empty, Struct> trainFlowOperationCallable() {
    return trainFlowOperationCallable;
  }

  @Override
  public UnaryCallable<ValidateFlowRequest, FlowValidationResult> validateFlowCallable() {
    return validateFlowCallable;
  }

  @Override
  public UnaryCallable<GetFlowValidationResultRequest, FlowValidationResult>
      getFlowValidationResultCallable() {
    return getFlowValidationResultCallable;
  }

  @Override
  public UnaryCallable<ImportFlowRequest, Operation> importFlowCallable() {
    return importFlowCallable;
  }

  @Override
  public OperationCallable<ImportFlowRequest, ImportFlowResponse, Struct>
      importFlowOperationCallable() {
    return importFlowOperationCallable;
  }

  @Override
  public UnaryCallable<ExportFlowRequest, Operation> exportFlowCallable() {
    return exportFlowCallable;
  }

  @Override
  public OperationCallable<ExportFlowRequest, ExportFlowResponse, Struct>
      exportFlowOperationCallable() {
    return exportFlowOperationCallable;
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
