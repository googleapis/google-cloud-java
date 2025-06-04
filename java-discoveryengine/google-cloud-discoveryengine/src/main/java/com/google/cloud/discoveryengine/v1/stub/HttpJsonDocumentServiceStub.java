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

package com.google.cloud.discoveryengine.v1.stub;

import static com.google.cloud.discoveryengine.v1.DocumentServiceClient.ListDocumentsPagedResponse;

import com.google.api.HttpRule;
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
import com.google.cloud.discoveryengine.v1.BatchGetDocumentsMetadataRequest;
import com.google.cloud.discoveryengine.v1.BatchGetDocumentsMetadataResponse;
import com.google.cloud.discoveryengine.v1.CreateDocumentRequest;
import com.google.cloud.discoveryengine.v1.DeleteDocumentRequest;
import com.google.cloud.discoveryengine.v1.Document;
import com.google.cloud.discoveryengine.v1.GetDocumentRequest;
import com.google.cloud.discoveryengine.v1.ImportDocumentsMetadata;
import com.google.cloud.discoveryengine.v1.ImportDocumentsRequest;
import com.google.cloud.discoveryengine.v1.ImportDocumentsResponse;
import com.google.cloud.discoveryengine.v1.ListDocumentsRequest;
import com.google.cloud.discoveryengine.v1.ListDocumentsResponse;
import com.google.cloud.discoveryengine.v1.PurgeDocumentsMetadata;
import com.google.cloud.discoveryengine.v1.PurgeDocumentsRequest;
import com.google.cloud.discoveryengine.v1.PurgeDocumentsResponse;
import com.google.cloud.discoveryengine.v1.UpdateDocumentRequest;
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
 * REST stub implementation for the DocumentService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonDocumentServiceStub extends DocumentServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(PurgeDocumentsResponse.getDescriptor())
          .add(PurgeDocumentsMetadata.getDescriptor())
          .add(ImportDocumentsMetadata.getDescriptor())
          .add(ImportDocumentsResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<GetDocumentRequest, Document>
      getDocumentMethodDescriptor =
          ApiMethodDescriptor.<GetDocumentRequest, Document>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1.DocumentService/GetDocument")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDocumentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataStores/*/branches/*/documents/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/branches/*/documents/*}")
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

  private static final ApiMethodDescriptor<ListDocumentsRequest, ListDocumentsResponse>
      listDocumentsMethodDescriptor =
          ApiMethodDescriptor.<ListDocumentsRequest, ListDocumentsResponse>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1.DocumentService/ListDocuments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDocumentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/dataStores/*/branches/*}/documents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDocumentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=projects/*/locations/*/collections/*/dataStores/*/branches/*}/documents")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDocumentsRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<CreateDocumentRequest, Document>
      createDocumentMethodDescriptor =
          ApiMethodDescriptor.<CreateDocumentRequest, Document>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1.DocumentService/CreateDocument")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDocumentRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/dataStores/*/branches/*}/documents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=projects/*/locations/*/collections/*/dataStores/*/branches/*}/documents")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "documentId", request.getDocumentId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("document", request.getDocument(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Document>newBuilder()
                      .setDefaultInstance(Document.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDocumentRequest, Document>
      updateDocumentMethodDescriptor =
          ApiMethodDescriptor.<UpdateDocumentRequest, Document>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1.DocumentService/UpdateDocument")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDocumentRequest>newBuilder()
                      .setPath(
                          "/v1/{document.name=projects/*/locations/*/dataStores/*/branches/*/documents/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "document.name", request.getDocument().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{document.name=projects/*/locations/*/collections/*/dataStores/*/branches/*/documents/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
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
                  ProtoMessageResponseParser.<Document>newBuilder()
                      .setDefaultInstance(Document.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDocumentRequest, Empty>
      deleteDocumentMethodDescriptor =
          ApiMethodDescriptor.<DeleteDocumentRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1.DocumentService/DeleteDocument")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDocumentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataStores/*/branches/*/documents/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/branches/*/documents/*}")
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
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ImportDocumentsRequest, Operation>
      importDocumentsMethodDescriptor =
          ApiMethodDescriptor.<ImportDocumentsRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1.DocumentService/ImportDocuments")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportDocumentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/dataStores/*/branches/*}/documents:import",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportDocumentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=projects/*/locations/*/collections/*/dataStores/*/branches/*}/documents:import")
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

  private static final ApiMethodDescriptor<PurgeDocumentsRequest, Operation>
      purgeDocumentsMethodDescriptor =
          ApiMethodDescriptor.<PurgeDocumentsRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1.DocumentService/PurgeDocuments")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PurgeDocumentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/dataStores/*/branches/*}/documents:purge",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PurgeDocumentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=projects/*/locations/*/collections/*/dataStores/*/branches/*}/documents:purge")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PurgeDocumentsRequest> serializer =
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
                  (PurgeDocumentsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          BatchGetDocumentsMetadataRequest, BatchGetDocumentsMetadataResponse>
      batchGetDocumentsMetadataMethodDescriptor =
          ApiMethodDescriptor
              .<BatchGetDocumentsMetadataRequest, BatchGetDocumentsMetadataResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.DocumentService/BatchGetDocumentsMetadata")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchGetDocumentsMetadataRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/dataStores/*/branches/*}/batchGetDocumentsMetadata",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchGetDocumentsMetadataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=projects/*/locations/*/collections/*/dataStores/*/branches/*}/batchGetDocumentsMetadata")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchGetDocumentsMetadataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "matcher", request.getMatcher());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchGetDocumentsMetadataResponse>newBuilder()
                      .setDefaultInstance(BatchGetDocumentsMetadataResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetDocumentRequest, Document> getDocumentCallable;
  private final UnaryCallable<ListDocumentsRequest, ListDocumentsResponse> listDocumentsCallable;
  private final UnaryCallable<ListDocumentsRequest, ListDocumentsPagedResponse>
      listDocumentsPagedCallable;
  private final UnaryCallable<CreateDocumentRequest, Document> createDocumentCallable;
  private final UnaryCallable<UpdateDocumentRequest, Document> updateDocumentCallable;
  private final UnaryCallable<DeleteDocumentRequest, Empty> deleteDocumentCallable;
  private final UnaryCallable<ImportDocumentsRequest, Operation> importDocumentsCallable;
  private final OperationCallable<
          ImportDocumentsRequest, ImportDocumentsResponse, ImportDocumentsMetadata>
      importDocumentsOperationCallable;
  private final UnaryCallable<PurgeDocumentsRequest, Operation> purgeDocumentsCallable;
  private final OperationCallable<
          PurgeDocumentsRequest, PurgeDocumentsResponse, PurgeDocumentsMetadata>
      purgeDocumentsOperationCallable;
  private final UnaryCallable<BatchGetDocumentsMetadataRequest, BatchGetDocumentsMetadataResponse>
      batchGetDocumentsMetadataCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDocumentServiceStub create(DocumentServiceStubSettings settings)
      throws IOException {
    return new HttpJsonDocumentServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDocumentServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDocumentServiceStub(
        DocumentServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDocumentServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDocumentServiceStub(
        DocumentServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDocumentServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDocumentServiceStub(
      DocumentServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonDocumentServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDocumentServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDocumentServiceStub(
      DocumentServiceStubSettings settings,
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
                        .setPost("/v1/{name=projects/*/operations/*}:cancel")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setPost(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/branches/*/operations/*}:cancel")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setPost(
                                    "/v1/{name=projects/*/locations/*/collections/*/engines/*/operations/*}:cancel")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setPost(
                                    "/v1/{name=projects/*/locations/*/dataStores/*/branches/*/operations/*}:cancel")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataConnector/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/branches/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/models/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/schemas/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/targetSites/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/engines/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/dataStores/*/branches/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/dataStores/*/models/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/dataStores/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/identityMappingStores/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*}/operations")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataConnector}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/branches/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/models/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/schemas/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/targetSites}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/engines/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/dataStores/*/branches/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/dataStores/*/models/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*/locations/*/dataStores/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/identityMappingStores/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*/locations/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*}/operations")
                                .build())
                        .build())
                .build());

    HttpJsonCallSettings<GetDocumentRequest, Document> getDocumentTransportSettings =
        HttpJsonCallSettings.<GetDocumentRequest, Document>newBuilder()
            .setMethodDescriptor(getDocumentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListDocumentsRequest, ListDocumentsResponse>
        listDocumentsTransportSettings =
            HttpJsonCallSettings.<ListDocumentsRequest, ListDocumentsResponse>newBuilder()
                .setMethodDescriptor(listDocumentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateDocumentRequest, Document> createDocumentTransportSettings =
        HttpJsonCallSettings.<CreateDocumentRequest, Document>newBuilder()
            .setMethodDescriptor(createDocumentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateDocumentRequest, Document> updateDocumentTransportSettings =
        HttpJsonCallSettings.<UpdateDocumentRequest, Document>newBuilder()
            .setMethodDescriptor(updateDocumentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("document.name", String.valueOf(request.getDocument().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteDocumentRequest, Empty> deleteDocumentTransportSettings =
        HttpJsonCallSettings.<DeleteDocumentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDocumentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ImportDocumentsRequest, Operation> importDocumentsTransportSettings =
        HttpJsonCallSettings.<ImportDocumentsRequest, Operation>newBuilder()
            .setMethodDescriptor(importDocumentsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<PurgeDocumentsRequest, Operation> purgeDocumentsTransportSettings =
        HttpJsonCallSettings.<PurgeDocumentsRequest, Operation>newBuilder()
            .setMethodDescriptor(purgeDocumentsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchGetDocumentsMetadataRequest, BatchGetDocumentsMetadataResponse>
        batchGetDocumentsMetadataTransportSettings =
            HttpJsonCallSettings
                .<BatchGetDocumentsMetadataRequest, BatchGetDocumentsMetadataResponse>newBuilder()
                .setMethodDescriptor(batchGetDocumentsMetadataMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getDocumentCallable =
        callableFactory.createUnaryCallable(
            getDocumentTransportSettings, settings.getDocumentSettings(), clientContext);
    this.listDocumentsCallable =
        callableFactory.createUnaryCallable(
            listDocumentsTransportSettings, settings.listDocumentsSettings(), clientContext);
    this.listDocumentsPagedCallable =
        callableFactory.createPagedCallable(
            listDocumentsTransportSettings, settings.listDocumentsSettings(), clientContext);
    this.createDocumentCallable =
        callableFactory.createUnaryCallable(
            createDocumentTransportSettings, settings.createDocumentSettings(), clientContext);
    this.updateDocumentCallable =
        callableFactory.createUnaryCallable(
            updateDocumentTransportSettings, settings.updateDocumentSettings(), clientContext);
    this.deleteDocumentCallable =
        callableFactory.createUnaryCallable(
            deleteDocumentTransportSettings, settings.deleteDocumentSettings(), clientContext);
    this.importDocumentsCallable =
        callableFactory.createUnaryCallable(
            importDocumentsTransportSettings, settings.importDocumentsSettings(), clientContext);
    this.importDocumentsOperationCallable =
        callableFactory.createOperationCallable(
            importDocumentsTransportSettings,
            settings.importDocumentsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.purgeDocumentsCallable =
        callableFactory.createUnaryCallable(
            purgeDocumentsTransportSettings, settings.purgeDocumentsSettings(), clientContext);
    this.purgeDocumentsOperationCallable =
        callableFactory.createOperationCallable(
            purgeDocumentsTransportSettings,
            settings.purgeDocumentsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.batchGetDocumentsMetadataCallable =
        callableFactory.createUnaryCallable(
            batchGetDocumentsMetadataTransportSettings,
            settings.batchGetDocumentsMetadataSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getDocumentMethodDescriptor);
    methodDescriptors.add(listDocumentsMethodDescriptor);
    methodDescriptors.add(createDocumentMethodDescriptor);
    methodDescriptors.add(updateDocumentMethodDescriptor);
    methodDescriptors.add(deleteDocumentMethodDescriptor);
    methodDescriptors.add(importDocumentsMethodDescriptor);
    methodDescriptors.add(purgeDocumentsMethodDescriptor);
    methodDescriptors.add(batchGetDocumentsMetadataMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<GetDocumentRequest, Document> getDocumentCallable() {
    return getDocumentCallable;
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
  public UnaryCallable<CreateDocumentRequest, Document> createDocumentCallable() {
    return createDocumentCallable;
  }

  @Override
  public UnaryCallable<UpdateDocumentRequest, Document> updateDocumentCallable() {
    return updateDocumentCallable;
  }

  @Override
  public UnaryCallable<DeleteDocumentRequest, Empty> deleteDocumentCallable() {
    return deleteDocumentCallable;
  }

  @Override
  public UnaryCallable<ImportDocumentsRequest, Operation> importDocumentsCallable() {
    return importDocumentsCallable;
  }

  @Override
  public OperationCallable<ImportDocumentsRequest, ImportDocumentsResponse, ImportDocumentsMetadata>
      importDocumentsOperationCallable() {
    return importDocumentsOperationCallable;
  }

  @Override
  public UnaryCallable<PurgeDocumentsRequest, Operation> purgeDocumentsCallable() {
    return purgeDocumentsCallable;
  }

  @Override
  public OperationCallable<PurgeDocumentsRequest, PurgeDocumentsResponse, PurgeDocumentsMetadata>
      purgeDocumentsOperationCallable() {
    return purgeDocumentsOperationCallable;
  }

  @Override
  public UnaryCallable<BatchGetDocumentsMetadataRequest, BatchGetDocumentsMetadataResponse>
      batchGetDocumentsMetadataCallable() {
    return batchGetDocumentsMetadataCallable;
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
