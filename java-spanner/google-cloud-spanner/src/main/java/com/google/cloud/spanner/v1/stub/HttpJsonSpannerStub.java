/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner.v1.stub;

import static com.google.cloud.spanner.v1.SpannerClient.ListSessionsPagedResponse;

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
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import com.google.spanner.v1.BatchCreateSessionsRequest;
import com.google.spanner.v1.BatchCreateSessionsResponse;
import com.google.spanner.v1.BatchWriteRequest;
import com.google.spanner.v1.BatchWriteResponse;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CommitResponse;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.DeleteSessionRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteBatchDmlResponse;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.GetSessionRequest;
import com.google.spanner.v1.ListSessionsRequest;
import com.google.spanner.v1.ListSessionsResponse;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.PartitionQueryRequest;
import com.google.spanner.v1.PartitionReadRequest;
import com.google.spanner.v1.PartitionResponse;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.RollbackRequest;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.Transaction;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the Spanner service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonSpannerStub extends SpannerStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateSessionRequest, Session>
      createSessionMethodDescriptor =
          ApiMethodDescriptor.<CreateSessionRequest, Session>newBuilder()
              .setFullMethodName("google.spanner.v1.Spanner/CreateSession")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSessionRequest>newBuilder()
                      .setPath(
                          "/v1/{database=projects/*/instances/*/databases/*}/sessions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSessionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "database", request.getDatabase());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSessionRequest> serializer =
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
                  ProtoMessageResponseParser.<Session>newBuilder()
                      .setDefaultInstance(Session.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchCreateSessionsRequest, BatchCreateSessionsResponse>
      batchCreateSessionsMethodDescriptor =
          ApiMethodDescriptor.<BatchCreateSessionsRequest, BatchCreateSessionsResponse>newBuilder()
              .setFullMethodName("google.spanner.v1.Spanner/BatchCreateSessions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateSessionsRequest>newBuilder()
                      .setPath(
                          "/v1/{database=projects/*/instances/*/databases/*}/sessions:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateSessionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "database", request.getDatabase());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateSessionsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchCreateSessionsResponse>newBuilder()
                      .setDefaultInstance(BatchCreateSessionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSessionRequest, Session> getSessionMethodDescriptor =
      ApiMethodDescriptor.<GetSessionRequest, Session>newBuilder()
          .setFullMethodName("google.spanner.v1.Spanner/GetSession")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSessionRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/instances/*/databases/*/sessions/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetSessionRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetSessionRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Session>newBuilder()
                  .setDefaultInstance(Session.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListSessionsRequest, ListSessionsResponse>
      listSessionsMethodDescriptor =
          ApiMethodDescriptor.<ListSessionsRequest, ListSessionsResponse>newBuilder()
              .setFullMethodName("google.spanner.v1.Spanner/ListSessions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSessionsRequest>newBuilder()
                      .setPath(
                          "/v1/{database=projects/*/instances/*/databases/*}/sessions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSessionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "database", request.getDatabase());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSessionsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListSessionsResponse>newBuilder()
                      .setDefaultInstance(ListSessionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSessionRequest, Empty>
      deleteSessionMethodDescriptor =
          ApiMethodDescriptor.<DeleteSessionRequest, Empty>newBuilder()
              .setFullMethodName("google.spanner.v1.Spanner/DeleteSession")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSessionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/instances/*/databases/*/sessions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSessionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSessionRequest> serializer =
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

  private static final ApiMethodDescriptor<ExecuteSqlRequest, ResultSet>
      executeSqlMethodDescriptor =
          ApiMethodDescriptor.<ExecuteSqlRequest, ResultSet>newBuilder()
              .setFullMethodName("google.spanner.v1.Spanner/ExecuteSql")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExecuteSqlRequest>newBuilder()
                      .setPath(
                          "/v1/{session=projects/*/instances/*/databases/*/sessions/*}:executeSql",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExecuteSqlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "session", request.getSession());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExecuteSqlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearSession().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ResultSet>newBuilder()
                      .setDefaultInstance(ResultSet.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ExecuteSqlRequest, PartialResultSet>
      executeStreamingSqlMethodDescriptor =
          ApiMethodDescriptor.<ExecuteSqlRequest, PartialResultSet>newBuilder()
              .setFullMethodName("google.spanner.v1.Spanner/ExecuteStreamingSql")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.SERVER_STREAMING)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExecuteSqlRequest>newBuilder()
                      .setPath(
                          "/v1/{session=projects/*/instances/*/databases/*/sessions/*}:executeStreamingSql",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExecuteSqlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "session", request.getSession());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExecuteSqlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearSession().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PartialResultSet>newBuilder()
                      .setDefaultInstance(PartialResultSet.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ExecuteBatchDmlRequest, ExecuteBatchDmlResponse>
      executeBatchDmlMethodDescriptor =
          ApiMethodDescriptor.<ExecuteBatchDmlRequest, ExecuteBatchDmlResponse>newBuilder()
              .setFullMethodName("google.spanner.v1.Spanner/ExecuteBatchDml")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExecuteBatchDmlRequest>newBuilder()
                      .setPath(
                          "/v1/{session=projects/*/instances/*/databases/*/sessions/*}:executeBatchDml",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExecuteBatchDmlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "session", request.getSession());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExecuteBatchDmlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearSession().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ExecuteBatchDmlResponse>newBuilder()
                      .setDefaultInstance(ExecuteBatchDmlResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ReadRequest, ResultSet> readMethodDescriptor =
      ApiMethodDescriptor.<ReadRequest, ResultSet>newBuilder()
          .setFullMethodName("google.spanner.v1.Spanner/Read")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<ReadRequest>newBuilder()
                  .setPath(
                      "/v1/{session=projects/*/instances/*/databases/*/sessions/*}:read",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<ReadRequest> serializer = ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "session", request.getSession());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<ReadRequest> serializer = ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearSession().build(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<ResultSet>newBuilder()
                  .setDefaultInstance(ResultSet.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ReadRequest, PartialResultSet>
      streamingReadMethodDescriptor =
          ApiMethodDescriptor.<ReadRequest, PartialResultSet>newBuilder()
              .setFullMethodName("google.spanner.v1.Spanner/StreamingRead")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.SERVER_STREAMING)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ReadRequest>newBuilder()
                      .setPath(
                          "/v1/{session=projects/*/instances/*/databases/*/sessions/*}:streamingRead",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ReadRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "session", request.getSession());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ReadRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearSession().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PartialResultSet>newBuilder()
                      .setDefaultInstance(PartialResultSet.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BeginTransactionRequest, Transaction>
      beginTransactionMethodDescriptor =
          ApiMethodDescriptor.<BeginTransactionRequest, Transaction>newBuilder()
              .setFullMethodName("google.spanner.v1.Spanner/BeginTransaction")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BeginTransactionRequest>newBuilder()
                      .setPath(
                          "/v1/{session=projects/*/instances/*/databases/*/sessions/*}:beginTransaction",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BeginTransactionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "session", request.getSession());
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
                                  .toBody("*", request.toBuilder().clearSession().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Transaction>newBuilder()
                      .setDefaultInstance(Transaction.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CommitRequest, CommitResponse> commitMethodDescriptor =
      ApiMethodDescriptor.<CommitRequest, CommitResponse>newBuilder()
          .setFullMethodName("google.spanner.v1.Spanner/Commit")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CommitRequest>newBuilder()
                  .setPath(
                      "/v1/{session=projects/*/instances/*/databases/*/sessions/*}:commit",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CommitRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "session", request.getSession());
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
                              .toBody("*", request.toBuilder().clearSession().build(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<CommitResponse>newBuilder()
                  .setDefaultInstance(CommitResponse.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<RollbackRequest, Empty> rollbackMethodDescriptor =
      ApiMethodDescriptor.<RollbackRequest, Empty>newBuilder()
          .setFullMethodName("google.spanner.v1.Spanner/Rollback")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<RollbackRequest>newBuilder()
                  .setPath(
                      "/v1/{session=projects/*/instances/*/databases/*/sessions/*}:rollback",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<RollbackRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "session", request.getSession());
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
                              .toBody("*", request.toBuilder().clearSession().build(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Empty>newBuilder()
                  .setDefaultInstance(Empty.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<PartitionQueryRequest, PartitionResponse>
      partitionQueryMethodDescriptor =
          ApiMethodDescriptor.<PartitionQueryRequest, PartitionResponse>newBuilder()
              .setFullMethodName("google.spanner.v1.Spanner/PartitionQuery")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PartitionQueryRequest>newBuilder()
                      .setPath(
                          "/v1/{session=projects/*/instances/*/databases/*/sessions/*}:partitionQuery",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PartitionQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "session", request.getSession());
                            return fields;
                          })
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
                                  .toBody("*", request.toBuilder().clearSession().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PartitionResponse>newBuilder()
                      .setDefaultInstance(PartitionResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PartitionReadRequest, PartitionResponse>
      partitionReadMethodDescriptor =
          ApiMethodDescriptor.<PartitionReadRequest, PartitionResponse>newBuilder()
              .setFullMethodName("google.spanner.v1.Spanner/PartitionRead")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PartitionReadRequest>newBuilder()
                      .setPath(
                          "/v1/{session=projects/*/instances/*/databases/*/sessions/*}:partitionRead",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PartitionReadRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "session", request.getSession());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PartitionReadRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearSession().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PartitionResponse>newBuilder()
                      .setDefaultInstance(PartitionResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchWriteRequest, BatchWriteResponse>
      batchWriteMethodDescriptor =
          ApiMethodDescriptor.<BatchWriteRequest, BatchWriteResponse>newBuilder()
              .setFullMethodName("google.spanner.v1.Spanner/BatchWrite")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.SERVER_STREAMING)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchWriteRequest>newBuilder()
                      .setPath(
                          "/v1/{session=projects/*/instances/*/databases/*/sessions/*}:batchWrite",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchWriteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "session", request.getSession());
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
                                  .toBody("*", request.toBuilder().clearSession().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchWriteResponse>newBuilder()
                      .setDefaultInstance(BatchWriteResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateSessionRequest, Session> createSessionCallable;
  private final UnaryCallable<BatchCreateSessionsRequest, BatchCreateSessionsResponse>
      batchCreateSessionsCallable;
  private final UnaryCallable<GetSessionRequest, Session> getSessionCallable;
  private final UnaryCallable<ListSessionsRequest, ListSessionsResponse> listSessionsCallable;
  private final UnaryCallable<ListSessionsRequest, ListSessionsPagedResponse>
      listSessionsPagedCallable;
  private final UnaryCallable<DeleteSessionRequest, Empty> deleteSessionCallable;
  private final UnaryCallable<ExecuteSqlRequest, ResultSet> executeSqlCallable;
  private final ServerStreamingCallable<ExecuteSqlRequest, PartialResultSet>
      executeStreamingSqlCallable;
  private final UnaryCallable<ExecuteBatchDmlRequest, ExecuteBatchDmlResponse>
      executeBatchDmlCallable;
  private final UnaryCallable<ReadRequest, ResultSet> readCallable;
  private final ServerStreamingCallable<ReadRequest, PartialResultSet> streamingReadCallable;
  private final UnaryCallable<BeginTransactionRequest, Transaction> beginTransactionCallable;
  private final UnaryCallable<CommitRequest, CommitResponse> commitCallable;
  private final UnaryCallable<RollbackRequest, Empty> rollbackCallable;
  private final UnaryCallable<PartitionQueryRequest, PartitionResponse> partitionQueryCallable;
  private final UnaryCallable<PartitionReadRequest, PartitionResponse> partitionReadCallable;
  private final ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> batchWriteCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSpannerStub create(SpannerStubSettings settings) throws IOException {
    return new HttpJsonSpannerStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSpannerStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonSpannerStub(SpannerStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSpannerStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSpannerStub(
        SpannerStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSpannerStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSpannerStub(SpannerStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonSpannerCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSpannerStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSpannerStub(
      SpannerStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateSessionRequest, Session> createSessionTransportSettings =
        HttpJsonCallSettings.<CreateSessionRequest, Session>newBuilder()
            .setMethodDescriptor(createSessionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database", String.valueOf(request.getDatabase()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getDatabase())
            .build();
    HttpJsonCallSettings<BatchCreateSessionsRequest, BatchCreateSessionsResponse>
        batchCreateSessionsTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateSessionsRequest, BatchCreateSessionsResponse>newBuilder()
                .setMethodDescriptor(batchCreateSessionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("database", String.valueOf(request.getDatabase()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getDatabase())
                .build();
    HttpJsonCallSettings<GetSessionRequest, Session> getSessionTransportSettings =
        HttpJsonCallSettings.<GetSessionRequest, Session>newBuilder()
            .setMethodDescriptor(getSessionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListSessionsRequest, ListSessionsResponse> listSessionsTransportSettings =
        HttpJsonCallSettings.<ListSessionsRequest, ListSessionsResponse>newBuilder()
            .setMethodDescriptor(listSessionsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database", String.valueOf(request.getDatabase()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getDatabase())
            .build();
    HttpJsonCallSettings<DeleteSessionRequest, Empty> deleteSessionTransportSettings =
        HttpJsonCallSettings.<DeleteSessionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSessionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ExecuteSqlRequest, ResultSet> executeSqlTransportSettings =
        HttpJsonCallSettings.<ExecuteSqlRequest, ResultSet>newBuilder()
            .setMethodDescriptor(executeSqlMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("session", String.valueOf(request.getSession()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getSession())
            .build();
    HttpJsonCallSettings<ExecuteSqlRequest, PartialResultSet> executeStreamingSqlTransportSettings =
        HttpJsonCallSettings.<ExecuteSqlRequest, PartialResultSet>newBuilder()
            .setMethodDescriptor(executeStreamingSqlMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("session", String.valueOf(request.getSession()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getSession())
            .build();
    HttpJsonCallSettings<ExecuteBatchDmlRequest, ExecuteBatchDmlResponse>
        executeBatchDmlTransportSettings =
            HttpJsonCallSettings.<ExecuteBatchDmlRequest, ExecuteBatchDmlResponse>newBuilder()
                .setMethodDescriptor(executeBatchDmlMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("session", String.valueOf(request.getSession()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getSession())
                .build();
    HttpJsonCallSettings<ReadRequest, ResultSet> readTransportSettings =
        HttpJsonCallSettings.<ReadRequest, ResultSet>newBuilder()
            .setMethodDescriptor(readMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("session", String.valueOf(request.getSession()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getSession())
            .build();
    HttpJsonCallSettings<ReadRequest, PartialResultSet> streamingReadTransportSettings =
        HttpJsonCallSettings.<ReadRequest, PartialResultSet>newBuilder()
            .setMethodDescriptor(streamingReadMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("session", String.valueOf(request.getSession()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getSession())
            .build();
    HttpJsonCallSettings<BeginTransactionRequest, Transaction> beginTransactionTransportSettings =
        HttpJsonCallSettings.<BeginTransactionRequest, Transaction>newBuilder()
            .setMethodDescriptor(beginTransactionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("session", String.valueOf(request.getSession()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getSession())
            .build();
    HttpJsonCallSettings<CommitRequest, CommitResponse> commitTransportSettings =
        HttpJsonCallSettings.<CommitRequest, CommitResponse>newBuilder()
            .setMethodDescriptor(commitMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("session", String.valueOf(request.getSession()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getSession())
            .build();
    HttpJsonCallSettings<RollbackRequest, Empty> rollbackTransportSettings =
        HttpJsonCallSettings.<RollbackRequest, Empty>newBuilder()
            .setMethodDescriptor(rollbackMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("session", String.valueOf(request.getSession()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getSession())
            .build();
    HttpJsonCallSettings<PartitionQueryRequest, PartitionResponse> partitionQueryTransportSettings =
        HttpJsonCallSettings.<PartitionQueryRequest, PartitionResponse>newBuilder()
            .setMethodDescriptor(partitionQueryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("session", String.valueOf(request.getSession()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getSession())
            .build();
    HttpJsonCallSettings<PartitionReadRequest, PartitionResponse> partitionReadTransportSettings =
        HttpJsonCallSettings.<PartitionReadRequest, PartitionResponse>newBuilder()
            .setMethodDescriptor(partitionReadMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("session", String.valueOf(request.getSession()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getSession())
            .build();
    HttpJsonCallSettings<BatchWriteRequest, BatchWriteResponse> batchWriteTransportSettings =
        HttpJsonCallSettings.<BatchWriteRequest, BatchWriteResponse>newBuilder()
            .setMethodDescriptor(batchWriteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("session", String.valueOf(request.getSession()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getSession())
            .build();

    this.createSessionCallable =
        callableFactory.createUnaryCallable(
            createSessionTransportSettings, settings.createSessionSettings(), clientContext);
    this.batchCreateSessionsCallable =
        callableFactory.createUnaryCallable(
            batchCreateSessionsTransportSettings,
            settings.batchCreateSessionsSettings(),
            clientContext);
    this.getSessionCallable =
        callableFactory.createUnaryCallable(
            getSessionTransportSettings, settings.getSessionSettings(), clientContext);
    this.listSessionsCallable =
        callableFactory.createUnaryCallable(
            listSessionsTransportSettings, settings.listSessionsSettings(), clientContext);
    this.listSessionsPagedCallable =
        callableFactory.createPagedCallable(
            listSessionsTransportSettings, settings.listSessionsSettings(), clientContext);
    this.deleteSessionCallable =
        callableFactory.createUnaryCallable(
            deleteSessionTransportSettings, settings.deleteSessionSettings(), clientContext);
    this.executeSqlCallable =
        callableFactory.createUnaryCallable(
            executeSqlTransportSettings, settings.executeSqlSettings(), clientContext);
    this.executeStreamingSqlCallable =
        callableFactory.createServerStreamingCallable(
            executeStreamingSqlTransportSettings,
            settings.executeStreamingSqlSettings(),
            clientContext);
    this.executeBatchDmlCallable =
        callableFactory.createUnaryCallable(
            executeBatchDmlTransportSettings, settings.executeBatchDmlSettings(), clientContext);
    this.readCallable =
        callableFactory.createUnaryCallable(
            readTransportSettings, settings.readSettings(), clientContext);
    this.streamingReadCallable =
        callableFactory.createServerStreamingCallable(
            streamingReadTransportSettings, settings.streamingReadSettings(), clientContext);
    this.beginTransactionCallable =
        callableFactory.createUnaryCallable(
            beginTransactionTransportSettings, settings.beginTransactionSettings(), clientContext);
    this.commitCallable =
        callableFactory.createUnaryCallable(
            commitTransportSettings, settings.commitSettings(), clientContext);
    this.rollbackCallable =
        callableFactory.createUnaryCallable(
            rollbackTransportSettings, settings.rollbackSettings(), clientContext);
    this.partitionQueryCallable =
        callableFactory.createUnaryCallable(
            partitionQueryTransportSettings, settings.partitionQuerySettings(), clientContext);
    this.partitionReadCallable =
        callableFactory.createUnaryCallable(
            partitionReadTransportSettings, settings.partitionReadSettings(), clientContext);
    this.batchWriteCallable =
        callableFactory.createServerStreamingCallable(
            batchWriteTransportSettings, settings.batchWriteSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createSessionMethodDescriptor);
    methodDescriptors.add(batchCreateSessionsMethodDescriptor);
    methodDescriptors.add(getSessionMethodDescriptor);
    methodDescriptors.add(listSessionsMethodDescriptor);
    methodDescriptors.add(deleteSessionMethodDescriptor);
    methodDescriptors.add(executeSqlMethodDescriptor);
    methodDescriptors.add(executeStreamingSqlMethodDescriptor);
    methodDescriptors.add(executeBatchDmlMethodDescriptor);
    methodDescriptors.add(readMethodDescriptor);
    methodDescriptors.add(streamingReadMethodDescriptor);
    methodDescriptors.add(beginTransactionMethodDescriptor);
    methodDescriptors.add(commitMethodDescriptor);
    methodDescriptors.add(rollbackMethodDescriptor);
    methodDescriptors.add(partitionQueryMethodDescriptor);
    methodDescriptors.add(partitionReadMethodDescriptor);
    methodDescriptors.add(batchWriteMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateSessionRequest, Session> createSessionCallable() {
    return createSessionCallable;
  }

  @Override
  public UnaryCallable<BatchCreateSessionsRequest, BatchCreateSessionsResponse>
      batchCreateSessionsCallable() {
    return batchCreateSessionsCallable;
  }

  @Override
  public UnaryCallable<GetSessionRequest, Session> getSessionCallable() {
    return getSessionCallable;
  }

  @Override
  public UnaryCallable<ListSessionsRequest, ListSessionsResponse> listSessionsCallable() {
    return listSessionsCallable;
  }

  @Override
  public UnaryCallable<ListSessionsRequest, ListSessionsPagedResponse> listSessionsPagedCallable() {
    return listSessionsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteSessionRequest, Empty> deleteSessionCallable() {
    return deleteSessionCallable;
  }

  @Override
  public UnaryCallable<ExecuteSqlRequest, ResultSet> executeSqlCallable() {
    return executeSqlCallable;
  }

  @Override
  public ServerStreamingCallable<ExecuteSqlRequest, PartialResultSet>
      executeStreamingSqlCallable() {
    return executeStreamingSqlCallable;
  }

  @Override
  public UnaryCallable<ExecuteBatchDmlRequest, ExecuteBatchDmlResponse> executeBatchDmlCallable() {
    return executeBatchDmlCallable;
  }

  @Override
  public UnaryCallable<ReadRequest, ResultSet> readCallable() {
    return readCallable;
  }

  @Override
  public ServerStreamingCallable<ReadRequest, PartialResultSet> streamingReadCallable() {
    return streamingReadCallable;
  }

  @Override
  public UnaryCallable<BeginTransactionRequest, Transaction> beginTransactionCallable() {
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
  public UnaryCallable<PartitionQueryRequest, PartitionResponse> partitionQueryCallable() {
    return partitionQueryCallable;
  }

  @Override
  public UnaryCallable<PartitionReadRequest, PartitionResponse> partitionReadCallable() {
    return partitionReadCallable;
  }

  @Override
  public ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> batchWriteCallable() {
    return batchWriteCallable;
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
