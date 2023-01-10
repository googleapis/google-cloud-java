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

package com.google.cloud.dialogflow.v2beta1.stub;

import static com.google.cloud.dialogflow.v2beta1.DocumentsClient.ListDocumentsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.DocumentsClient.ListLocationsPagedResponse;

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
import com.google.cloud.dialogflow.v2beta1.CreateDocumentRequest;
import com.google.cloud.dialogflow.v2beta1.DeleteDocumentRequest;
import com.google.cloud.dialogflow.v2beta1.Document;
import com.google.cloud.dialogflow.v2beta1.GetDocumentRequest;
import com.google.cloud.dialogflow.v2beta1.ImportDocumentsRequest;
import com.google.cloud.dialogflow.v2beta1.ImportDocumentsResponse;
import com.google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata;
import com.google.cloud.dialogflow.v2beta1.ListDocumentsRequest;
import com.google.cloud.dialogflow.v2beta1.ListDocumentsResponse;
import com.google.cloud.dialogflow.v2beta1.ReloadDocumentRequest;
import com.google.cloud.dialogflow.v2beta1.UpdateDocumentRequest;
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
 * REST stub implementation for the Documents service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonDocumentsStub extends DocumentsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(ImportDocumentsResponse.getDescriptor())
          .add(Empty.getDescriptor())
          .add(Document.getDescriptor())
          .add(KnowledgeOperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListDocumentsRequest, ListDocumentsResponse>
      listDocumentsMethodDescriptor =
          ApiMethodDescriptor.<ListDocumentsRequest, ListDocumentsResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Documents/ListDocuments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDocumentsRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{parent=projects/*/knowledgeBases/*}/documents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDocumentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{parent=projects/*/locations/*/knowledgeBases/*}/documents",
                          "/v2beta1/{parent=projects/*/agent/knowledgeBases/*}/documents")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDocumentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDocumentsResponse>newBuilder()
                      .setDefaultInstance(ListDocumentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDocumentRequest, Document>
      getDocumentMethodDescriptor =
          ApiMethodDescriptor.<GetDocumentRequest, Document>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Documents/GetDocument")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDocumentRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{name=projects/*/knowledgeBases/*/documents/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{name=projects/*/locations/*/knowledgeBases/*/documents/*}",
                          "/v2beta1/{name=projects/*/agent/knowledgeBases/*/documents/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Document>newBuilder()
                      .setDefaultInstance(Document.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateDocumentRequest, Operation>
      createDocumentMethodDescriptor =
          ApiMethodDescriptor.<CreateDocumentRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Documents/CreateDocument")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDocumentRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{parent=projects/*/knowledgeBases/*}/documents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{parent=projects/*/locations/*/knowledgeBases/*}/documents",
                          "/v2beta1/{parent=projects/*/agent/knowledgeBases/*}/documents")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "importGcsCustomMetadata",
                                request.getImportGcsCustomMetadata());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("document", request.getDocument(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateDocumentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ImportDocumentsRequest, Operation>
      importDocumentsMethodDescriptor =
          ApiMethodDescriptor.<ImportDocumentsRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Documents/ImportDocuments")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportDocumentsRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{parent=projects/*/knowledgeBases/*}/documents:import",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportDocumentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{parent=projects/*/locations/*/knowledgeBases/*}/documents:import")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportDocumentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ImportDocumentsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteDocumentRequest, Operation>
      deleteDocumentMethodDescriptor =
          ApiMethodDescriptor.<DeleteDocumentRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Documents/DeleteDocument")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDocumentRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{name=projects/*/knowledgeBases/*/documents/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{name=projects/*/locations/*/knowledgeBases/*/documents/*}",
                          "/v2beta1/{name=projects/*/agent/knowledgeBases/*/documents/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDocumentRequest> serializer =
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
                  (DeleteDocumentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateDocumentRequest, Operation>
      updateDocumentMethodDescriptor =
          ApiMethodDescriptor.<UpdateDocumentRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Documents/UpdateDocument")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDocumentRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{document.name=projects/*/knowledgeBases/*/documents/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "document.name", request.getDocument().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{document.name=projects/*/locations/*/knowledgeBases/*/documents/*}",
                          "/v2beta1/{document.name=projects/*/agent/knowledgeBases/*/documents/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("document", request.getDocument(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateDocumentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ReloadDocumentRequest, Operation>
      reloadDocumentMethodDescriptor =
          ApiMethodDescriptor.<ReloadDocumentRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Documents/ReloadDocument")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ReloadDocumentRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{name=projects/*/knowledgeBases/*/documents/*}:reload",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ReloadDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{name=projects/*/locations/*/knowledgeBases/*/documents/*}:reload",
                          "/v2beta1/{name=projects/*/agent/knowledgeBases/*/documents/*}:reload")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ReloadDocumentRequest> serializer =
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
                  (ReloadDocumentRequest request, Operation response) ->
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

  private final UnaryCallable<ListDocumentsRequest, ListDocumentsResponse> listDocumentsCallable;
  private final UnaryCallable<ListDocumentsRequest, ListDocumentsPagedResponse>
      listDocumentsPagedCallable;
  private final UnaryCallable<GetDocumentRequest, Document> getDocumentCallable;
  private final UnaryCallable<CreateDocumentRequest, Operation> createDocumentCallable;
  private final OperationCallable<CreateDocumentRequest, Document, KnowledgeOperationMetadata>
      createDocumentOperationCallable;
  private final UnaryCallable<ImportDocumentsRequest, Operation> importDocumentsCallable;
  private final OperationCallable<
          ImportDocumentsRequest, ImportDocumentsResponse, KnowledgeOperationMetadata>
      importDocumentsOperationCallable;
  private final UnaryCallable<DeleteDocumentRequest, Operation> deleteDocumentCallable;
  private final OperationCallable<DeleteDocumentRequest, Empty, KnowledgeOperationMetadata>
      deleteDocumentOperationCallable;
  private final UnaryCallable<UpdateDocumentRequest, Operation> updateDocumentCallable;
  private final OperationCallable<UpdateDocumentRequest, Document, KnowledgeOperationMetadata>
      updateDocumentOperationCallable;
  private final UnaryCallable<ReloadDocumentRequest, Operation> reloadDocumentCallable;
  private final OperationCallable<ReloadDocumentRequest, Document, KnowledgeOperationMetadata>
      reloadDocumentOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDocumentsStub create(DocumentsStubSettings settings)
      throws IOException {
    return new HttpJsonDocumentsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDocumentsStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonDocumentsStub(
        DocumentsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDocumentsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDocumentsStub(
        DocumentsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDocumentsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDocumentsStub(DocumentsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonDocumentsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDocumentsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDocumentsStub(
      DocumentsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListDocumentsRequest, ListDocumentsResponse>
        listDocumentsTransportSettings =
            HttpJsonCallSettings.<ListDocumentsRequest, ListDocumentsResponse>newBuilder()
                .setMethodDescriptor(listDocumentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetDocumentRequest, Document> getDocumentTransportSettings =
        HttpJsonCallSettings.<GetDocumentRequest, Document>newBuilder()
            .setMethodDescriptor(getDocumentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateDocumentRequest, Operation> createDocumentTransportSettings =
        HttpJsonCallSettings.<CreateDocumentRequest, Operation>newBuilder()
            .setMethodDescriptor(createDocumentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ImportDocumentsRequest, Operation> importDocumentsTransportSettings =
        HttpJsonCallSettings.<ImportDocumentsRequest, Operation>newBuilder()
            .setMethodDescriptor(importDocumentsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteDocumentRequest, Operation> deleteDocumentTransportSettings =
        HttpJsonCallSettings.<DeleteDocumentRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDocumentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateDocumentRequest, Operation> updateDocumentTransportSettings =
        HttpJsonCallSettings.<UpdateDocumentRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDocumentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ReloadDocumentRequest, Operation> reloadDocumentTransportSettings =
        HttpJsonCallSettings.<ReloadDocumentRequest, Operation>newBuilder()
            .setMethodDescriptor(reloadDocumentMethodDescriptor)
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

    this.listDocumentsCallable =
        callableFactory.createUnaryCallable(
            listDocumentsTransportSettings, settings.listDocumentsSettings(), clientContext);
    this.listDocumentsPagedCallable =
        callableFactory.createPagedCallable(
            listDocumentsTransportSettings, settings.listDocumentsSettings(), clientContext);
    this.getDocumentCallable =
        callableFactory.createUnaryCallable(
            getDocumentTransportSettings, settings.getDocumentSettings(), clientContext);
    this.createDocumentCallable =
        callableFactory.createUnaryCallable(
            createDocumentTransportSettings, settings.createDocumentSettings(), clientContext);
    this.createDocumentOperationCallable =
        callableFactory.createOperationCallable(
            createDocumentTransportSettings,
            settings.createDocumentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.importDocumentsCallable =
        callableFactory.createUnaryCallable(
            importDocumentsTransportSettings, settings.importDocumentsSettings(), clientContext);
    this.importDocumentsOperationCallable =
        callableFactory.createOperationCallable(
            importDocumentsTransportSettings,
            settings.importDocumentsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteDocumentCallable =
        callableFactory.createUnaryCallable(
            deleteDocumentTransportSettings, settings.deleteDocumentSettings(), clientContext);
    this.deleteDocumentOperationCallable =
        callableFactory.createOperationCallable(
            deleteDocumentTransportSettings,
            settings.deleteDocumentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateDocumentCallable =
        callableFactory.createUnaryCallable(
            updateDocumentTransportSettings, settings.updateDocumentSettings(), clientContext);
    this.updateDocumentOperationCallable =
        callableFactory.createOperationCallable(
            updateDocumentTransportSettings,
            settings.updateDocumentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.reloadDocumentCallable =
        callableFactory.createUnaryCallable(
            reloadDocumentTransportSettings, settings.reloadDocumentSettings(), clientContext);
    this.reloadDocumentOperationCallable =
        callableFactory.createOperationCallable(
            reloadDocumentTransportSettings,
            settings.reloadDocumentOperationSettings(),
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
    methodDescriptors.add(listDocumentsMethodDescriptor);
    methodDescriptors.add(getDocumentMethodDescriptor);
    methodDescriptors.add(createDocumentMethodDescriptor);
    methodDescriptors.add(importDocumentsMethodDescriptor);
    methodDescriptors.add(deleteDocumentMethodDescriptor);
    methodDescriptors.add(updateDocumentMethodDescriptor);
    methodDescriptors.add(reloadDocumentMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListDocumentsRequest, ListDocumentsResponse> listDocumentsCallable() {
    return listDocumentsCallable;
  }

  @Override
  public UnaryCallable<ListDocumentsRequest, ListDocumentsPagedResponse>
      listDocumentsPagedCallable() {
    return listDocumentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDocumentRequest, Document> getDocumentCallable() {
    return getDocumentCallable;
  }

  @Override
  public UnaryCallable<CreateDocumentRequest, Operation> createDocumentCallable() {
    return createDocumentCallable;
  }

  @Override
  public OperationCallable<CreateDocumentRequest, Document, KnowledgeOperationMetadata>
      createDocumentOperationCallable() {
    return createDocumentOperationCallable;
  }

  @Override
  public UnaryCallable<ImportDocumentsRequest, Operation> importDocumentsCallable() {
    return importDocumentsCallable;
  }

  @Override
  public OperationCallable<
          ImportDocumentsRequest, ImportDocumentsResponse, KnowledgeOperationMetadata>
      importDocumentsOperationCallable() {
    return importDocumentsOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDocumentRequest, Operation> deleteDocumentCallable() {
    return deleteDocumentCallable;
  }

  @Override
  public OperationCallable<DeleteDocumentRequest, Empty, KnowledgeOperationMetadata>
      deleteDocumentOperationCallable() {
    return deleteDocumentOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDocumentRequest, Operation> updateDocumentCallable() {
    return updateDocumentCallable;
  }

  @Override
  public OperationCallable<UpdateDocumentRequest, Document, KnowledgeOperationMetadata>
      updateDocumentOperationCallable() {
    return updateDocumentOperationCallable;
  }

  @Override
  public UnaryCallable<ReloadDocumentRequest, Operation> reloadDocumentCallable() {
    return reloadDocumentCallable;
  }

  @Override
  public OperationCallable<ReloadDocumentRequest, Document, KnowledgeOperationMetadata>
      reloadDocumentOperationCallable() {
    return reloadDocumentOperationCallable;
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
