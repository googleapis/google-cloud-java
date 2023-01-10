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

package com.google.cloud.dialogflow.v2.stub;

import static com.google.cloud.dialogflow.v2.ConversationDatasetsClient.ListConversationDatasetsPagedResponse;
import static com.google.cloud.dialogflow.v2.ConversationDatasetsClient.ListLocationsPagedResponse;

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
import com.google.cloud.dialogflow.v2.ConversationDataset;
import com.google.cloud.dialogflow.v2.CreateConversationDatasetOperationMetadata;
import com.google.cloud.dialogflow.v2.CreateConversationDatasetRequest;
import com.google.cloud.dialogflow.v2.DeleteConversationDatasetOperationMetadata;
import com.google.cloud.dialogflow.v2.DeleteConversationDatasetRequest;
import com.google.cloud.dialogflow.v2.GetConversationDatasetRequest;
import com.google.cloud.dialogflow.v2.ImportConversationDataOperationMetadata;
import com.google.cloud.dialogflow.v2.ImportConversationDataOperationResponse;
import com.google.cloud.dialogflow.v2.ImportConversationDataRequest;
import com.google.cloud.dialogflow.v2.ListConversationDatasetsRequest;
import com.google.cloud.dialogflow.v2.ListConversationDatasetsResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * REST stub implementation for the ConversationDatasets service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonConversationDatasetsStub extends ConversationDatasetsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(ImportConversationDataOperationResponse.getDescriptor())
          .add(ConversationDataset.getDescriptor())
          .add(Empty.getDescriptor())
          .add(DeleteConversationDatasetOperationMetadata.getDescriptor())
          .add(CreateConversationDatasetOperationMetadata.getDescriptor())
          .add(ImportConversationDataOperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateConversationDatasetRequest, Operation>
      createConversationDatasetMethodDescriptor =
          ApiMethodDescriptor.<CreateConversationDatasetRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationDatasets/CreateConversationDataset")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateConversationDatasetRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/conversationDatasets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConversationDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConversationDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "conversationDataset",
                                      request.getConversationDataset(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateConversationDatasetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetConversationDatasetRequest, ConversationDataset>
      getConversationDatasetMethodDescriptor =
          ApiMethodDescriptor.<GetConversationDatasetRequest, ConversationDataset>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationDatasets/GetConversationDataset")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetConversationDatasetRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/conversationDatasets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetConversationDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=projects/*/locations/*/conversationDatasets/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetConversationDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConversationDataset>newBuilder()
                      .setDefaultInstance(ConversationDataset.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListConversationDatasetsRequest, ListConversationDatasetsResponse>
      listConversationDatasetsMethodDescriptor =
          ApiMethodDescriptor
              .<ListConversationDatasetsRequest, ListConversationDatasetsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationDatasets/ListConversationDatasets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListConversationDatasetsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*}/conversationDatasets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListConversationDatasetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=projects/*/locations/*}/conversationDatasets")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListConversationDatasetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListConversationDatasetsResponse>newBuilder()
                      .setDefaultInstance(ListConversationDatasetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteConversationDatasetRequest, Operation>
      deleteConversationDatasetMethodDescriptor =
          ApiMethodDescriptor.<DeleteConversationDatasetRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationDatasets/DeleteConversationDataset")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteConversationDatasetRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/conversationDatasets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConversationDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConversationDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteConversationDatasetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ImportConversationDataRequest, Operation>
      importConversationDataMethodDescriptor =
          ApiMethodDescriptor.<ImportConversationDataRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationDatasets/ImportConversationData")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportConversationDataRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/conversationDatasets/*}:importConversationData",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportConversationDataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=projects/*/locations/*/conversationDatasets/*}:importConversationData")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportConversationDataRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ImportConversationDataRequest request, Operation response) ->
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
                          "/v2/{name=projects/*}/locations",
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
                          "/v2/{name=projects/*/locations/*}",
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

  private final UnaryCallable<CreateConversationDatasetRequest, Operation>
      createConversationDatasetCallable;
  private final OperationCallable<
          CreateConversationDatasetRequest,
          ConversationDataset,
          CreateConversationDatasetOperationMetadata>
      createConversationDatasetOperationCallable;
  private final UnaryCallable<GetConversationDatasetRequest, ConversationDataset>
      getConversationDatasetCallable;
  private final UnaryCallable<ListConversationDatasetsRequest, ListConversationDatasetsResponse>
      listConversationDatasetsCallable;
  private final UnaryCallable<
          ListConversationDatasetsRequest, ListConversationDatasetsPagedResponse>
      listConversationDatasetsPagedCallable;
  private final UnaryCallable<DeleteConversationDatasetRequest, Operation>
      deleteConversationDatasetCallable;
  private final OperationCallable<
          DeleteConversationDatasetRequest, Empty, DeleteConversationDatasetOperationMetadata>
      deleteConversationDatasetOperationCallable;
  private final UnaryCallable<ImportConversationDataRequest, Operation>
      importConversationDataCallable;
  private final OperationCallable<
          ImportConversationDataRequest,
          ImportConversationDataOperationResponse,
          ImportConversationDataOperationMetadata>
      importConversationDataOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonConversationDatasetsStub create(
      ConversationDatasetsStubSettings settings) throws IOException {
    return new HttpJsonConversationDatasetsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonConversationDatasetsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonConversationDatasetsStub(
        ConversationDatasetsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonConversationDatasetsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonConversationDatasetsStub(
        ConversationDatasetsStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonConversationDatasetsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonConversationDatasetsStub(
      ConversationDatasetsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonConversationDatasetsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonConversationDatasetsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonConversationDatasetsStub(
      ConversationDatasetsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateConversationDatasetRequest, Operation>
        createConversationDatasetTransportSettings =
            HttpJsonCallSettings.<CreateConversationDatasetRequest, Operation>newBuilder()
                .setMethodDescriptor(createConversationDatasetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetConversationDatasetRequest, ConversationDataset>
        getConversationDatasetTransportSettings =
            HttpJsonCallSettings.<GetConversationDatasetRequest, ConversationDataset>newBuilder()
                .setMethodDescriptor(getConversationDatasetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListConversationDatasetsRequest, ListConversationDatasetsResponse>
        listConversationDatasetsTransportSettings =
            HttpJsonCallSettings
                .<ListConversationDatasetsRequest, ListConversationDatasetsResponse>newBuilder()
                .setMethodDescriptor(listConversationDatasetsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteConversationDatasetRequest, Operation>
        deleteConversationDatasetTransportSettings =
            HttpJsonCallSettings.<DeleteConversationDatasetRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteConversationDatasetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ImportConversationDataRequest, Operation>
        importConversationDataTransportSettings =
            HttpJsonCallSettings.<ImportConversationDataRequest, Operation>newBuilder()
                .setMethodDescriptor(importConversationDataMethodDescriptor)
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

    this.createConversationDatasetCallable =
        callableFactory.createUnaryCallable(
            createConversationDatasetTransportSettings,
            settings.createConversationDatasetSettings(),
            clientContext);
    this.createConversationDatasetOperationCallable =
        callableFactory.createOperationCallable(
            createConversationDatasetTransportSettings,
            settings.createConversationDatasetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getConversationDatasetCallable =
        callableFactory.createUnaryCallable(
            getConversationDatasetTransportSettings,
            settings.getConversationDatasetSettings(),
            clientContext);
    this.listConversationDatasetsCallable =
        callableFactory.createUnaryCallable(
            listConversationDatasetsTransportSettings,
            settings.listConversationDatasetsSettings(),
            clientContext);
    this.listConversationDatasetsPagedCallable =
        callableFactory.createPagedCallable(
            listConversationDatasetsTransportSettings,
            settings.listConversationDatasetsSettings(),
            clientContext);
    this.deleteConversationDatasetCallable =
        callableFactory.createUnaryCallable(
            deleteConversationDatasetTransportSettings,
            settings.deleteConversationDatasetSettings(),
            clientContext);
    this.deleteConversationDatasetOperationCallable =
        callableFactory.createOperationCallable(
            deleteConversationDatasetTransportSettings,
            settings.deleteConversationDatasetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.importConversationDataCallable =
        callableFactory.createUnaryCallable(
            importConversationDataTransportSettings,
            settings.importConversationDataSettings(),
            clientContext);
    this.importConversationDataOperationCallable =
        callableFactory.createOperationCallable(
            importConversationDataTransportSettings,
            settings.importConversationDataOperationSettings(),
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
    methodDescriptors.add(createConversationDatasetMethodDescriptor);
    methodDescriptors.add(getConversationDatasetMethodDescriptor);
    methodDescriptors.add(listConversationDatasetsMethodDescriptor);
    methodDescriptors.add(deleteConversationDatasetMethodDescriptor);
    methodDescriptors.add(importConversationDataMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateConversationDatasetRequest, Operation>
      createConversationDatasetCallable() {
    return createConversationDatasetCallable;
  }

  @Override
  public OperationCallable<
          CreateConversationDatasetRequest,
          ConversationDataset,
          CreateConversationDatasetOperationMetadata>
      createConversationDatasetOperationCallable() {
    return createConversationDatasetOperationCallable;
  }

  @Override
  public UnaryCallable<GetConversationDatasetRequest, ConversationDataset>
      getConversationDatasetCallable() {
    return getConversationDatasetCallable;
  }

  @Override
  public UnaryCallable<ListConversationDatasetsRequest, ListConversationDatasetsResponse>
      listConversationDatasetsCallable() {
    return listConversationDatasetsCallable;
  }

  @Override
  public UnaryCallable<ListConversationDatasetsRequest, ListConversationDatasetsPagedResponse>
      listConversationDatasetsPagedCallable() {
    return listConversationDatasetsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteConversationDatasetRequest, Operation>
      deleteConversationDatasetCallable() {
    return deleteConversationDatasetCallable;
  }

  @Override
  public OperationCallable<
          DeleteConversationDatasetRequest, Empty, DeleteConversationDatasetOperationMetadata>
      deleteConversationDatasetOperationCallable() {
    return deleteConversationDatasetOperationCallable;
  }

  @Override
  public UnaryCallable<ImportConversationDataRequest, Operation> importConversationDataCallable() {
    return importConversationDataCallable;
  }

  @Override
  public OperationCallable<
          ImportConversationDataRequest,
          ImportConversationDataOperationResponse,
          ImportConversationDataOperationMetadata>
      importConversationDataOperationCallable() {
    return importConversationDataOperationCallable;
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
