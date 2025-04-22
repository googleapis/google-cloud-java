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

package com.google.cloud.firestore.v1.stub;

import static com.google.cloud.firestore.v1.FirestoreClient.ListCollectionIdsPagedResponse;
import static com.google.cloud.firestore.v1.FirestoreClient.ListDocumentsPagedResponse;
import static com.google.cloud.firestore.v1.FirestoreClient.PartitionQueryPagedResponse;

import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.firestore.v1.BatchGetDocumentsRequest;
import com.google.firestore.v1.BatchGetDocumentsResponse;
import com.google.firestore.v1.BatchWriteRequest;
import com.google.firestore.v1.BatchWriteResponse;
import com.google.firestore.v1.BeginTransactionRequest;
import com.google.firestore.v1.BeginTransactionResponse;
import com.google.firestore.v1.CommitRequest;
import com.google.firestore.v1.CommitResponse;
import com.google.firestore.v1.CreateDocumentRequest;
import com.google.firestore.v1.DeleteDocumentRequest;
import com.google.firestore.v1.Document;
import com.google.firestore.v1.GetDocumentRequest;
import com.google.firestore.v1.ListCollectionIdsRequest;
import com.google.firestore.v1.ListCollectionIdsResponse;
import com.google.firestore.v1.ListDocumentsRequest;
import com.google.firestore.v1.ListDocumentsResponse;
import com.google.firestore.v1.ListenRequest;
import com.google.firestore.v1.ListenResponse;
import com.google.firestore.v1.PartitionQueryRequest;
import com.google.firestore.v1.PartitionQueryResponse;
import com.google.firestore.v1.RollbackRequest;
import com.google.firestore.v1.RunAggregationQueryRequest;
import com.google.firestore.v1.RunAggregationQueryResponse;
import com.google.firestore.v1.RunQueryRequest;
import com.google.firestore.v1.RunQueryResponse;
import com.google.firestore.v1.UpdateDocumentRequest;
import com.google.firestore.v1.WriteRequest;
import com.google.firestore.v1.WriteResponse;
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
 * REST stub implementation for the Firestore service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonFirestoreStub extends FirestoreStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetDocumentRequest, Document>
      getDocumentMethodDescriptor =
          ApiMethodDescriptor.<GetDocumentRequest, Document>newBuilder()
              .setFullMethodName("google.firestore.v1.Firestore/GetDocument")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDocumentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/databases/*/documents/*/**}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "mask", request.getMask());
                            serializer.putQueryParam(fields, "readTime", request.getReadTime());
                            serializer.putQueryParam(
                                fields, "transaction", request.getTransaction());
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
              .setFullMethodName("google.firestore.v1.Firestore/ListDocuments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDocumentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/databases/*/documents/*/**}/{collectionId}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDocumentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "collectionId", request.getCollectionId());
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=projects/*/databases/*/documents}/{collectionId}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDocumentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "mask", request.getMask());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "readTime", request.getReadTime());
                            serializer.putQueryParam(
                                fields, "showMissing", request.getShowMissing());
                            serializer.putQueryParam(
                                fields, "transaction", request.getTransaction());
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

  private static final ApiMethodDescriptor<UpdateDocumentRequest, Document>
      updateDocumentMethodDescriptor =
          ApiMethodDescriptor.<UpdateDocumentRequest, Document>newBuilder()
              .setFullMethodName("google.firestore.v1.Firestore/UpdateDocument")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDocumentRequest>newBuilder()
                      .setPath(
                          "/v1/{document.name=projects/*/databases/*/documents/*/**}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "document.name", request.getDocument().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "currentDocument", request.getCurrentDocument());
                            serializer.putQueryParam(fields, "mask", request.getMask());
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
              .setFullMethodName("google.firestore.v1.Firestore/DeleteDocument")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDocumentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/databases/*/documents/*/**}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "currentDocument", request.getCurrentDocument());
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

  private static final ApiMethodDescriptor<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsMethodDescriptor =
          ApiMethodDescriptor.<BatchGetDocumentsRequest, BatchGetDocumentsResponse>newBuilder()
              .setFullMethodName("google.firestore.v1.Firestore/BatchGetDocuments")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.SERVER_STREAMING)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchGetDocumentsRequest>newBuilder()
                      .setPath(
                          "/v1/{database=projects/*/databases/*}/documents:batchGet",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchGetDocumentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "database", request.getDatabase());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchGetDocumentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearDatabase().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchGetDocumentsResponse>newBuilder()
                      .setDefaultInstance(BatchGetDocumentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionMethodDescriptor =
          ApiMethodDescriptor.<BeginTransactionRequest, BeginTransactionResponse>newBuilder()
              .setFullMethodName("google.firestore.v1.Firestore/BeginTransaction")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BeginTransactionRequest>newBuilder()
                      .setPath(
                          "/v1/{database=projects/*/databases/*}/documents:beginTransaction",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BeginTransactionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "database", request.getDatabase());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BeginTransactionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearDatabase().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BeginTransactionResponse>newBuilder()
                      .setDefaultInstance(BeginTransactionResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CommitRequest, CommitResponse> commitMethodDescriptor =
      ApiMethodDescriptor.<CommitRequest, CommitResponse>newBuilder()
          .setFullMethodName("google.firestore.v1.Firestore/Commit")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CommitRequest>newBuilder()
                  .setPath(
                      "/v1/{database=projects/*/databases/*}/documents:commit",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CommitRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "database", request.getDatabase());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CommitRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearDatabase().build(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<CommitResponse>newBuilder()
                  .setDefaultInstance(CommitResponse.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<RollbackRequest, Empty> rollbackMethodDescriptor =
      ApiMethodDescriptor.<RollbackRequest, Empty>newBuilder()
          .setFullMethodName("google.firestore.v1.Firestore/Rollback")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<RollbackRequest>newBuilder()
                  .setPath(
                      "/v1/{database=projects/*/databases/*}/documents:rollback",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<RollbackRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "database", request.getDatabase());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<RollbackRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearDatabase().build(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Empty>newBuilder()
                  .setDefaultInstance(Empty.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<RunQueryRequest, RunQueryResponse>
      runQueryMethodDescriptor =
          ApiMethodDescriptor.<RunQueryRequest, RunQueryResponse>newBuilder()
              .setFullMethodName("google.firestore.v1.Firestore/RunQuery")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.SERVER_STREAMING)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RunQueryRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/databases/*/documents}:runQuery",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RunQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=projects/*/databases/*/documents/*/**}:runQuery")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RunQueryRequest> serializer =
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
                  ProtoMessageResponseParser.<RunQueryResponse>newBuilder()
                      .setDefaultInstance(RunQueryResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RunAggregationQueryRequest, RunAggregationQueryResponse>
      runAggregationQueryMethodDescriptor =
          ApiMethodDescriptor.<RunAggregationQueryRequest, RunAggregationQueryResponse>newBuilder()
              .setFullMethodName("google.firestore.v1.Firestore/RunAggregationQuery")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.SERVER_STREAMING)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RunAggregationQueryRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/databases/*/documents}:runAggregationQuery",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RunAggregationQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=projects/*/databases/*/documents/*/**}:runAggregationQuery")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RunAggregationQueryRequest> serializer =
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
                  ProtoMessageResponseParser.<RunAggregationQueryResponse>newBuilder()
                      .setDefaultInstance(RunAggregationQueryResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PartitionQueryRequest, PartitionQueryResponse>
      partitionQueryMethodDescriptor =
          ApiMethodDescriptor.<PartitionQueryRequest, PartitionQueryResponse>newBuilder()
              .setFullMethodName("google.firestore.v1.Firestore/PartitionQuery")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PartitionQueryRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/databases/*/documents}:partitionQuery",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PartitionQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=projects/*/databases/*/documents/*/**}:partitionQuery")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PartitionQueryRequest> serializer =
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
                  ProtoMessageResponseParser.<PartitionQueryResponse>newBuilder()
                      .setDefaultInstance(PartitionQueryResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListCollectionIdsRequest, ListCollectionIdsResponse>
      listCollectionIdsMethodDescriptor =
          ApiMethodDescriptor.<ListCollectionIdsRequest, ListCollectionIdsResponse>newBuilder()
              .setFullMethodName("google.firestore.v1.Firestore/ListCollectionIds")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCollectionIdsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/databases/*/documents}:listCollectionIds",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCollectionIdsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=projects/*/databases/*/documents/*/**}:listCollectionIds")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCollectionIdsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListCollectionIdsResponse>newBuilder()
                      .setDefaultInstance(ListCollectionIdsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchWriteRequest, BatchWriteResponse>
      batchWriteMethodDescriptor =
          ApiMethodDescriptor.<BatchWriteRequest, BatchWriteResponse>newBuilder()
              .setFullMethodName("google.firestore.v1.Firestore/BatchWrite")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchWriteRequest>newBuilder()
                      .setPath(
                          "/v1/{database=projects/*/databases/*}/documents:batchWrite",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchWriteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "database", request.getDatabase());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchWriteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearDatabase().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchWriteResponse>newBuilder()
                      .setDefaultInstance(BatchWriteResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateDocumentRequest, Document>
      createDocumentMethodDescriptor =
          ApiMethodDescriptor.<CreateDocumentRequest, Document>newBuilder()
              .setFullMethodName("google.firestore.v1.Firestore/CreateDocument")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDocumentRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/databases/*/documents/**}/{collectionId}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "collectionId", request.getCollectionId());
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "documentId", request.getDocumentId());
                            serializer.putQueryParam(fields, "mask", request.getMask());
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

  private final UnaryCallable<GetDocumentRequest, Document> getDocumentCallable;
  private final UnaryCallable<ListDocumentsRequest, ListDocumentsResponse> listDocumentsCallable;
  private final UnaryCallable<ListDocumentsRequest, ListDocumentsPagedResponse>
      listDocumentsPagedCallable;
  private final UnaryCallable<UpdateDocumentRequest, Document> updateDocumentCallable;
  private final UnaryCallable<DeleteDocumentRequest, Empty> deleteDocumentCallable;
  private final ServerStreamingCallable<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsCallable;
  private final UnaryCallable<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionCallable;
  private final UnaryCallable<CommitRequest, CommitResponse> commitCallable;
  private final UnaryCallable<RollbackRequest, Empty> rollbackCallable;
  private final ServerStreamingCallable<RunQueryRequest, RunQueryResponse> runQueryCallable;
  private final ServerStreamingCallable<RunAggregationQueryRequest, RunAggregationQueryResponse>
      runAggregationQueryCallable;
  private final UnaryCallable<PartitionQueryRequest, PartitionQueryResponse> partitionQueryCallable;
  private final UnaryCallable<PartitionQueryRequest, PartitionQueryPagedResponse>
      partitionQueryPagedCallable;
  private final UnaryCallable<ListCollectionIdsRequest, ListCollectionIdsResponse>
      listCollectionIdsCallable;
  private final UnaryCallable<ListCollectionIdsRequest, ListCollectionIdsPagedResponse>
      listCollectionIdsPagedCallable;
  private final UnaryCallable<BatchWriteRequest, BatchWriteResponse> batchWriteCallable;
  private final UnaryCallable<CreateDocumentRequest, Document> createDocumentCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonFirestoreStub create(FirestoreStubSettings settings)
      throws IOException {
    return new HttpJsonFirestoreStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonFirestoreStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonFirestoreStub(
        FirestoreStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonFirestoreStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonFirestoreStub(
        FirestoreStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonFirestoreStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonFirestoreStub(FirestoreStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonFirestoreCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonFirestoreStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonFirestoreStub(
      FirestoreStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

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
                      builder.add("collection_id", String.valueOf(request.getCollectionId()));
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
    HttpJsonCallSettings<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
        batchGetDocumentsTransportSettings =
            HttpJsonCallSettings.<BatchGetDocumentsRequest, BatchGetDocumentsResponse>newBuilder()
                .setMethodDescriptor(batchGetDocumentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("database", String.valueOf(request.getDatabase()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BeginTransactionRequest, BeginTransactionResponse>
        beginTransactionTransportSettings =
            HttpJsonCallSettings.<BeginTransactionRequest, BeginTransactionResponse>newBuilder()
                .setMethodDescriptor(beginTransactionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("database", String.valueOf(request.getDatabase()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CommitRequest, CommitResponse> commitTransportSettings =
        HttpJsonCallSettings.<CommitRequest, CommitResponse>newBuilder()
            .setMethodDescriptor(commitMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database", String.valueOf(request.getDatabase()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RollbackRequest, Empty> rollbackTransportSettings =
        HttpJsonCallSettings.<RollbackRequest, Empty>newBuilder()
            .setMethodDescriptor(rollbackMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database", String.valueOf(request.getDatabase()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RunQueryRequest, RunQueryResponse> runQueryTransportSettings =
        HttpJsonCallSettings.<RunQueryRequest, RunQueryResponse>newBuilder()
            .setMethodDescriptor(runQueryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RunAggregationQueryRequest, RunAggregationQueryResponse>
        runAggregationQueryTransportSettings =
            HttpJsonCallSettings
                .<RunAggregationQueryRequest, RunAggregationQueryResponse>newBuilder()
                .setMethodDescriptor(runAggregationQueryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<PartitionQueryRequest, PartitionQueryResponse>
        partitionQueryTransportSettings =
            HttpJsonCallSettings.<PartitionQueryRequest, PartitionQueryResponse>newBuilder()
                .setMethodDescriptor(partitionQueryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListCollectionIdsRequest, ListCollectionIdsResponse>
        listCollectionIdsTransportSettings =
            HttpJsonCallSettings.<ListCollectionIdsRequest, ListCollectionIdsResponse>newBuilder()
                .setMethodDescriptor(listCollectionIdsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchWriteRequest, BatchWriteResponse> batchWriteTransportSettings =
        HttpJsonCallSettings.<BatchWriteRequest, BatchWriteResponse>newBuilder()
            .setMethodDescriptor(batchWriteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database", String.valueOf(request.getDatabase()));
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
                  builder.add("collection_id", String.valueOf(request.getCollectionId()));
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
    this.updateDocumentCallable =
        callableFactory.createUnaryCallable(
            updateDocumentTransportSettings, settings.updateDocumentSettings(), clientContext);
    this.deleteDocumentCallable =
        callableFactory.createUnaryCallable(
            deleteDocumentTransportSettings, settings.deleteDocumentSettings(), clientContext);
    this.batchGetDocumentsCallable =
        callableFactory.createServerStreamingCallable(
            batchGetDocumentsTransportSettings,
            settings.batchGetDocumentsSettings(),
            clientContext);
    this.beginTransactionCallable =
        callableFactory.createUnaryCallable(
            beginTransactionTransportSettings, settings.beginTransactionSettings(), clientContext);
    this.commitCallable =
        callableFactory.createUnaryCallable(
            commitTransportSettings, settings.commitSettings(), clientContext);
    this.rollbackCallable =
        callableFactory.createUnaryCallable(
            rollbackTransportSettings, settings.rollbackSettings(), clientContext);
    this.runQueryCallable =
        callableFactory.createServerStreamingCallable(
            runQueryTransportSettings, settings.runQuerySettings(), clientContext);
    this.runAggregationQueryCallable =
        callableFactory.createServerStreamingCallable(
            runAggregationQueryTransportSettings,
            settings.runAggregationQuerySettings(),
            clientContext);
    this.partitionQueryCallable =
        callableFactory.createUnaryCallable(
            partitionQueryTransportSettings, settings.partitionQuerySettings(), clientContext);
    this.partitionQueryPagedCallable =
        callableFactory.createPagedCallable(
            partitionQueryTransportSettings, settings.partitionQuerySettings(), clientContext);
    this.listCollectionIdsCallable =
        callableFactory.createUnaryCallable(
            listCollectionIdsTransportSettings,
            settings.listCollectionIdsSettings(),
            clientContext);
    this.listCollectionIdsPagedCallable =
        callableFactory.createPagedCallable(
            listCollectionIdsTransportSettings,
            settings.listCollectionIdsSettings(),
            clientContext);
    this.batchWriteCallable =
        callableFactory.createUnaryCallable(
            batchWriteTransportSettings, settings.batchWriteSettings(), clientContext);
    this.createDocumentCallable =
        callableFactory.createUnaryCallable(
            createDocumentTransportSettings, settings.createDocumentSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getDocumentMethodDescriptor);
    methodDescriptors.add(listDocumentsMethodDescriptor);
    methodDescriptors.add(updateDocumentMethodDescriptor);
    methodDescriptors.add(deleteDocumentMethodDescriptor);
    methodDescriptors.add(batchGetDocumentsMethodDescriptor);
    methodDescriptors.add(beginTransactionMethodDescriptor);
    methodDescriptors.add(commitMethodDescriptor);
    methodDescriptors.add(rollbackMethodDescriptor);
    methodDescriptors.add(runQueryMethodDescriptor);
    methodDescriptors.add(runAggregationQueryMethodDescriptor);
    methodDescriptors.add(partitionQueryMethodDescriptor);
    methodDescriptors.add(listCollectionIdsMethodDescriptor);
    methodDescriptors.add(batchWriteMethodDescriptor);
    methodDescriptors.add(createDocumentMethodDescriptor);
    return methodDescriptors;
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
  public UnaryCallable<UpdateDocumentRequest, Document> updateDocumentCallable() {
    return updateDocumentCallable;
  }

  @Override
  public UnaryCallable<DeleteDocumentRequest, Empty> deleteDocumentCallable() {
    return deleteDocumentCallable;
  }

  @Override
  public ServerStreamingCallable<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsCallable() {
    return batchGetDocumentsCallable;
  }

  @Override
  public UnaryCallable<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionCallable() {
    return beginTransactionCallable;
  }

  @Override
  public UnaryCallable<CommitRequest, CommitResponse> commitCallable() {
    return commitCallable;
  }

  @Override
  public UnaryCallable<RollbackRequest, Empty> rollbackCallable() {
    return rollbackCallable;
  }

  @Override
  public ServerStreamingCallable<RunQueryRequest, RunQueryResponse> runQueryCallable() {
    return runQueryCallable;
  }

  @Override
  public ServerStreamingCallable<RunAggregationQueryRequest, RunAggregationQueryResponse>
      runAggregationQueryCallable() {
    return runAggregationQueryCallable;
  }

  @Override
  public UnaryCallable<PartitionQueryRequest, PartitionQueryResponse> partitionQueryCallable() {
    return partitionQueryCallable;
  }

  @Override
  public UnaryCallable<PartitionQueryRequest, PartitionQueryPagedResponse>
      partitionQueryPagedCallable() {
    return partitionQueryPagedCallable;
  }

  @Override
  public UnaryCallable<ListCollectionIdsRequest, ListCollectionIdsResponse>
      listCollectionIdsCallable() {
    return listCollectionIdsCallable;
  }

  @Override
  public UnaryCallable<ListCollectionIdsRequest, ListCollectionIdsPagedResponse>
      listCollectionIdsPagedCallable() {
    return listCollectionIdsPagedCallable;
  }

  @Override
  public UnaryCallable<BatchWriteRequest, BatchWriteResponse> batchWriteCallable() {
    return batchWriteCallable;
  }

  @Override
  public UnaryCallable<CreateDocumentRequest, Document> createDocumentCallable() {
    return createDocumentCallable;
  }

  @Override
  public BidiStreamingCallable<WriteRequest, WriteResponse> writeCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: writeCallable(). REST transport is not implemented for this method yet.");
  }

  @Override
  public BidiStreamingCallable<ListenRequest, ListenResponse> listenCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listenCallable(). REST transport is not implemented for this method"
            + " yet.");
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
