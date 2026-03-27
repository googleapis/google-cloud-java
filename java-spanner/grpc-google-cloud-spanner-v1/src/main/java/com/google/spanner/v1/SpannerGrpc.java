/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.spanner.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Cloud Spanner API
 * The Cloud Spanner API can be used to manage sessions and execute
 * transactions on data stored in Cloud Spanner databases.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class SpannerGrpc {

  private SpannerGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.spanner.v1.Spanner";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.CreateSessionRequest, com.google.spanner.v1.Session>
      getCreateSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSession",
      requestType = com.google.spanner.v1.CreateSessionRequest.class,
      responseType = com.google.spanner.v1.Session.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.CreateSessionRequest, com.google.spanner.v1.Session>
      getCreateSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.v1.CreateSessionRequest, com.google.spanner.v1.Session>
        getCreateSessionMethod;
    if ((getCreateSessionMethod = SpannerGrpc.getCreateSessionMethod) == null) {
      synchronized (SpannerGrpc.class) {
        if ((getCreateSessionMethod = SpannerGrpc.getCreateSessionMethod) == null) {
          SpannerGrpc.getCreateSessionMethod =
              getCreateSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.v1.CreateSessionRequest, com.google.spanner.v1.Session>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.CreateSessionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.Session.getDefaultInstance()))
                      .setSchemaDescriptor(new SpannerMethodDescriptorSupplier("CreateSession"))
                      .build();
        }
      }
    }
    return getCreateSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.BatchCreateSessionsRequest,
          com.google.spanner.v1.BatchCreateSessionsResponse>
      getBatchCreateSessionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateSessions",
      requestType = com.google.spanner.v1.BatchCreateSessionsRequest.class,
      responseType = com.google.spanner.v1.BatchCreateSessionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.BatchCreateSessionsRequest,
          com.google.spanner.v1.BatchCreateSessionsResponse>
      getBatchCreateSessionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.v1.BatchCreateSessionsRequest,
            com.google.spanner.v1.BatchCreateSessionsResponse>
        getBatchCreateSessionsMethod;
    if ((getBatchCreateSessionsMethod = SpannerGrpc.getBatchCreateSessionsMethod) == null) {
      synchronized (SpannerGrpc.class) {
        if ((getBatchCreateSessionsMethod = SpannerGrpc.getBatchCreateSessionsMethod) == null) {
          SpannerGrpc.getBatchCreateSessionsMethod =
              getBatchCreateSessionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.v1.BatchCreateSessionsRequest,
                          com.google.spanner.v1.BatchCreateSessionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchCreateSessions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.BatchCreateSessionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.BatchCreateSessionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SpannerMethodDescriptorSupplier("BatchCreateSessions"))
                      .build();
        }
      }
    }
    return getBatchCreateSessionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.GetSessionRequest, com.google.spanner.v1.Session>
      getGetSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSession",
      requestType = com.google.spanner.v1.GetSessionRequest.class,
      responseType = com.google.spanner.v1.Session.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.GetSessionRequest, com.google.spanner.v1.Session>
      getGetSessionMethod() {
    io.grpc.MethodDescriptor<com.google.spanner.v1.GetSessionRequest, com.google.spanner.v1.Session>
        getGetSessionMethod;
    if ((getGetSessionMethod = SpannerGrpc.getGetSessionMethod) == null) {
      synchronized (SpannerGrpc.class) {
        if ((getGetSessionMethod = SpannerGrpc.getGetSessionMethod) == null) {
          SpannerGrpc.getGetSessionMethod =
              getGetSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.v1.GetSessionRequest, com.google.spanner.v1.Session>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.GetSessionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.Session.getDefaultInstance()))
                      .setSchemaDescriptor(new SpannerMethodDescriptorSupplier("GetSession"))
                      .build();
        }
      }
    }
    return getGetSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.ListSessionsRequest, com.google.spanner.v1.ListSessionsResponse>
      getListSessionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSessions",
      requestType = com.google.spanner.v1.ListSessionsRequest.class,
      responseType = com.google.spanner.v1.ListSessionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.ListSessionsRequest, com.google.spanner.v1.ListSessionsResponse>
      getListSessionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.v1.ListSessionsRequest, com.google.spanner.v1.ListSessionsResponse>
        getListSessionsMethod;
    if ((getListSessionsMethod = SpannerGrpc.getListSessionsMethod) == null) {
      synchronized (SpannerGrpc.class) {
        if ((getListSessionsMethod = SpannerGrpc.getListSessionsMethod) == null) {
          SpannerGrpc.getListSessionsMethod =
              getListSessionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.v1.ListSessionsRequest,
                          com.google.spanner.v1.ListSessionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSessions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.ListSessionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.ListSessionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new SpannerMethodDescriptorSupplier("ListSessions"))
                      .build();
        }
      }
    }
    return getListSessionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.DeleteSessionRequest, com.google.protobuf.Empty>
      getDeleteSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSession",
      requestType = com.google.spanner.v1.DeleteSessionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.DeleteSessionRequest, com.google.protobuf.Empty>
      getDeleteSessionMethod() {
    io.grpc.MethodDescriptor<com.google.spanner.v1.DeleteSessionRequest, com.google.protobuf.Empty>
        getDeleteSessionMethod;
    if ((getDeleteSessionMethod = SpannerGrpc.getDeleteSessionMethod) == null) {
      synchronized (SpannerGrpc.class) {
        if ((getDeleteSessionMethod = SpannerGrpc.getDeleteSessionMethod) == null) {
          SpannerGrpc.getDeleteSessionMethod =
              getDeleteSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.v1.DeleteSessionRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.DeleteSessionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new SpannerMethodDescriptorSupplier("DeleteSession"))
                      .build();
        }
      }
    }
    return getDeleteSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.ExecuteSqlRequest, com.google.spanner.v1.ResultSet>
      getExecuteSqlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExecuteSql",
      requestType = com.google.spanner.v1.ExecuteSqlRequest.class,
      responseType = com.google.spanner.v1.ResultSet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.ExecuteSqlRequest, com.google.spanner.v1.ResultSet>
      getExecuteSqlMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.v1.ExecuteSqlRequest, com.google.spanner.v1.ResultSet>
        getExecuteSqlMethod;
    if ((getExecuteSqlMethod = SpannerGrpc.getExecuteSqlMethod) == null) {
      synchronized (SpannerGrpc.class) {
        if ((getExecuteSqlMethod = SpannerGrpc.getExecuteSqlMethod) == null) {
          SpannerGrpc.getExecuteSqlMethod =
              getExecuteSqlMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.v1.ExecuteSqlRequest, com.google.spanner.v1.ResultSet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExecuteSql"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.ExecuteSqlRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.ResultSet.getDefaultInstance()))
                      .setSchemaDescriptor(new SpannerMethodDescriptorSupplier("ExecuteSql"))
                      .build();
        }
      }
    }
    return getExecuteSqlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.ExecuteSqlRequest, com.google.spanner.v1.PartialResultSet>
      getExecuteStreamingSqlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExecuteStreamingSql",
      requestType = com.google.spanner.v1.ExecuteSqlRequest.class,
      responseType = com.google.spanner.v1.PartialResultSet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.ExecuteSqlRequest, com.google.spanner.v1.PartialResultSet>
      getExecuteStreamingSqlMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.v1.ExecuteSqlRequest, com.google.spanner.v1.PartialResultSet>
        getExecuteStreamingSqlMethod;
    if ((getExecuteStreamingSqlMethod = SpannerGrpc.getExecuteStreamingSqlMethod) == null) {
      synchronized (SpannerGrpc.class) {
        if ((getExecuteStreamingSqlMethod = SpannerGrpc.getExecuteStreamingSqlMethod) == null) {
          SpannerGrpc.getExecuteStreamingSqlMethod =
              getExecuteStreamingSqlMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.v1.ExecuteSqlRequest,
                          com.google.spanner.v1.PartialResultSet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ExecuteStreamingSql"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.ExecuteSqlRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.PartialResultSet.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SpannerMethodDescriptorSupplier("ExecuteStreamingSql"))
                      .build();
        }
      }
    }
    return getExecuteStreamingSqlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.ExecuteBatchDmlRequest,
          com.google.spanner.v1.ExecuteBatchDmlResponse>
      getExecuteBatchDmlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExecuteBatchDml",
      requestType = com.google.spanner.v1.ExecuteBatchDmlRequest.class,
      responseType = com.google.spanner.v1.ExecuteBatchDmlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.ExecuteBatchDmlRequest,
          com.google.spanner.v1.ExecuteBatchDmlResponse>
      getExecuteBatchDmlMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.v1.ExecuteBatchDmlRequest,
            com.google.spanner.v1.ExecuteBatchDmlResponse>
        getExecuteBatchDmlMethod;
    if ((getExecuteBatchDmlMethod = SpannerGrpc.getExecuteBatchDmlMethod) == null) {
      synchronized (SpannerGrpc.class) {
        if ((getExecuteBatchDmlMethod = SpannerGrpc.getExecuteBatchDmlMethod) == null) {
          SpannerGrpc.getExecuteBatchDmlMethod =
              getExecuteBatchDmlMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.v1.ExecuteBatchDmlRequest,
                          com.google.spanner.v1.ExecuteBatchDmlResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExecuteBatchDml"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.ExecuteBatchDmlRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.ExecuteBatchDmlResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new SpannerMethodDescriptorSupplier("ExecuteBatchDml"))
                      .build();
        }
      }
    }
    return getExecuteBatchDmlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.ReadRequest, com.google.spanner.v1.ResultSet>
      getReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Read",
      requestType = com.google.spanner.v1.ReadRequest.class,
      responseType = com.google.spanner.v1.ResultSet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.ReadRequest, com.google.spanner.v1.ResultSet>
      getReadMethod() {
    io.grpc.MethodDescriptor<com.google.spanner.v1.ReadRequest, com.google.spanner.v1.ResultSet>
        getReadMethod;
    if ((getReadMethod = SpannerGrpc.getReadMethod) == null) {
      synchronized (SpannerGrpc.class) {
        if ((getReadMethod = SpannerGrpc.getReadMethod) == null) {
          SpannerGrpc.getReadMethod =
              getReadMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.v1.ReadRequest, com.google.spanner.v1.ResultSet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Read"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.ReadRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.ResultSet.getDefaultInstance()))
                      .setSchemaDescriptor(new SpannerMethodDescriptorSupplier("Read"))
                      .build();
        }
      }
    }
    return getReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.ReadRequest, com.google.spanner.v1.PartialResultSet>
      getStreamingReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamingRead",
      requestType = com.google.spanner.v1.ReadRequest.class,
      responseType = com.google.spanner.v1.PartialResultSet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.ReadRequest, com.google.spanner.v1.PartialResultSet>
      getStreamingReadMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.v1.ReadRequest, com.google.spanner.v1.PartialResultSet>
        getStreamingReadMethod;
    if ((getStreamingReadMethod = SpannerGrpc.getStreamingReadMethod) == null) {
      synchronized (SpannerGrpc.class) {
        if ((getStreamingReadMethod = SpannerGrpc.getStreamingReadMethod) == null) {
          SpannerGrpc.getStreamingReadMethod =
              getStreamingReadMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.v1.ReadRequest, com.google.spanner.v1.PartialResultSet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamingRead"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.ReadRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.PartialResultSet.getDefaultInstance()))
                      .setSchemaDescriptor(new SpannerMethodDescriptorSupplier("StreamingRead"))
                      .build();
        }
      }
    }
    return getStreamingReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.BeginTransactionRequest, com.google.spanner.v1.Transaction>
      getBeginTransactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BeginTransaction",
      requestType = com.google.spanner.v1.BeginTransactionRequest.class,
      responseType = com.google.spanner.v1.Transaction.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.BeginTransactionRequest, com.google.spanner.v1.Transaction>
      getBeginTransactionMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.v1.BeginTransactionRequest, com.google.spanner.v1.Transaction>
        getBeginTransactionMethod;
    if ((getBeginTransactionMethod = SpannerGrpc.getBeginTransactionMethod) == null) {
      synchronized (SpannerGrpc.class) {
        if ((getBeginTransactionMethod = SpannerGrpc.getBeginTransactionMethod) == null) {
          SpannerGrpc.getBeginTransactionMethod =
              getBeginTransactionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.v1.BeginTransactionRequest,
                          com.google.spanner.v1.Transaction>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BeginTransaction"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.BeginTransactionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.Transaction.getDefaultInstance()))
                      .setSchemaDescriptor(new SpannerMethodDescriptorSupplier("BeginTransaction"))
                      .build();
        }
      }
    }
    return getBeginTransactionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.CommitRequest, com.google.spanner.v1.CommitResponse>
      getCommitMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Commit",
      requestType = com.google.spanner.v1.CommitRequest.class,
      responseType = com.google.spanner.v1.CommitResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.CommitRequest, com.google.spanner.v1.CommitResponse>
      getCommitMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.v1.CommitRequest, com.google.spanner.v1.CommitResponse>
        getCommitMethod;
    if ((getCommitMethod = SpannerGrpc.getCommitMethod) == null) {
      synchronized (SpannerGrpc.class) {
        if ((getCommitMethod = SpannerGrpc.getCommitMethod) == null) {
          SpannerGrpc.getCommitMethod =
              getCommitMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.v1.CommitRequest, com.google.spanner.v1.CommitResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Commit"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.CommitRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.CommitResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new SpannerMethodDescriptorSupplier("Commit"))
                      .build();
        }
      }
    }
    return getCommitMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.RollbackRequest, com.google.protobuf.Empty>
      getRollbackMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Rollback",
      requestType = com.google.spanner.v1.RollbackRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.RollbackRequest, com.google.protobuf.Empty>
      getRollbackMethod() {
    io.grpc.MethodDescriptor<com.google.spanner.v1.RollbackRequest, com.google.protobuf.Empty>
        getRollbackMethod;
    if ((getRollbackMethod = SpannerGrpc.getRollbackMethod) == null) {
      synchronized (SpannerGrpc.class) {
        if ((getRollbackMethod = SpannerGrpc.getRollbackMethod) == null) {
          SpannerGrpc.getRollbackMethod =
              getRollbackMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.v1.RollbackRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Rollback"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.RollbackRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new SpannerMethodDescriptorSupplier("Rollback"))
                      .build();
        }
      }
    }
    return getRollbackMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.PartitionQueryRequest, com.google.spanner.v1.PartitionResponse>
      getPartitionQueryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PartitionQuery",
      requestType = com.google.spanner.v1.PartitionQueryRequest.class,
      responseType = com.google.spanner.v1.PartitionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.PartitionQueryRequest, com.google.spanner.v1.PartitionResponse>
      getPartitionQueryMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.v1.PartitionQueryRequest, com.google.spanner.v1.PartitionResponse>
        getPartitionQueryMethod;
    if ((getPartitionQueryMethod = SpannerGrpc.getPartitionQueryMethod) == null) {
      synchronized (SpannerGrpc.class) {
        if ((getPartitionQueryMethod = SpannerGrpc.getPartitionQueryMethod) == null) {
          SpannerGrpc.getPartitionQueryMethod =
              getPartitionQueryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.v1.PartitionQueryRequest,
                          com.google.spanner.v1.PartitionResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PartitionQuery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.PartitionQueryRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.PartitionResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new SpannerMethodDescriptorSupplier("PartitionQuery"))
                      .build();
        }
      }
    }
    return getPartitionQueryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.PartitionReadRequest, com.google.spanner.v1.PartitionResponse>
      getPartitionReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PartitionRead",
      requestType = com.google.spanner.v1.PartitionReadRequest.class,
      responseType = com.google.spanner.v1.PartitionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.PartitionReadRequest, com.google.spanner.v1.PartitionResponse>
      getPartitionReadMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.v1.PartitionReadRequest, com.google.spanner.v1.PartitionResponse>
        getPartitionReadMethod;
    if ((getPartitionReadMethod = SpannerGrpc.getPartitionReadMethod) == null) {
      synchronized (SpannerGrpc.class) {
        if ((getPartitionReadMethod = SpannerGrpc.getPartitionReadMethod) == null) {
          SpannerGrpc.getPartitionReadMethod =
              getPartitionReadMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.v1.PartitionReadRequest,
                          com.google.spanner.v1.PartitionResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PartitionRead"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.PartitionReadRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.PartitionResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new SpannerMethodDescriptorSupplier("PartitionRead"))
                      .build();
        }
      }
    }
    return getPartitionReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.BatchWriteRequest, com.google.spanner.v1.BatchWriteResponse>
      getBatchWriteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchWrite",
      requestType = com.google.spanner.v1.BatchWriteRequest.class,
      responseType = com.google.spanner.v1.BatchWriteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.BatchWriteRequest, com.google.spanner.v1.BatchWriteResponse>
      getBatchWriteMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.v1.BatchWriteRequest, com.google.spanner.v1.BatchWriteResponse>
        getBatchWriteMethod;
    if ((getBatchWriteMethod = SpannerGrpc.getBatchWriteMethod) == null) {
      synchronized (SpannerGrpc.class) {
        if ((getBatchWriteMethod = SpannerGrpc.getBatchWriteMethod) == null) {
          SpannerGrpc.getBatchWriteMethod =
              getBatchWriteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.v1.BatchWriteRequest,
                          com.google.spanner.v1.BatchWriteResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchWrite"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.BatchWriteRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.v1.BatchWriteResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new SpannerMethodDescriptorSupplier("BatchWrite"))
                      .build();
        }
      }
    }
    return getBatchWriteMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SpannerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SpannerStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SpannerStub>() {
          @java.lang.Override
          public SpannerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SpannerStub(channel, callOptions);
          }
        };
    return SpannerStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SpannerBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SpannerBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SpannerBlockingV2Stub>() {
          @java.lang.Override
          public SpannerBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SpannerBlockingV2Stub(channel, callOptions);
          }
        };
    return SpannerBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SpannerBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SpannerBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SpannerBlockingStub>() {
          @java.lang.Override
          public SpannerBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SpannerBlockingStub(channel, callOptions);
          }
        };
    return SpannerBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SpannerFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SpannerFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SpannerFutureStub>() {
          @java.lang.Override
          public SpannerFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SpannerFutureStub(channel, callOptions);
          }
        };
    return SpannerFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Cloud Spanner API
   * The Cloud Spanner API can be used to manage sessions and execute
   * transactions on data stored in Cloud Spanner databases.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a new session. A session can be used to perform
     * transactions that read and/or modify data in a Cloud Spanner database.
     * Sessions are meant to be reused for many consecutive
     * transactions.
     * Sessions can only execute one transaction at a time. To execute
     * multiple concurrent read-write/write-only transactions, create
     * multiple sessions. Note that standalone reads and queries use a
     * transaction internally, and count toward the one transaction
     * limit.
     * Active sessions use additional server resources, so it's a good idea to
     * delete idle and unneeded sessions.
     * Aside from explicit deletes, Cloud Spanner can delete sessions when no
     * operations are sent for more than an hour. If a session is deleted,
     * requests to it return `NOT_FOUND`.
     * Idle sessions can be kept alive by sending a trivial SQL query
     * periodically, for example, `"SELECT 1"`.
     * </pre>
     */
    default void createSession(
        com.google.spanner.v1.CreateSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.Session> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates multiple new sessions.
     * This API can be used to initialize a session cache on the clients.
     * See https://goo.gl/TgSFN2 for best practices on session cache management.
     * </pre>
     */
    default void batchCreateSessions(
        com.google.spanner.v1.BatchCreateSessionsRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.BatchCreateSessionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchCreateSessionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a session. Returns `NOT_FOUND` if the session doesn't exist.
     * This is mainly useful for determining whether a session is still
     * alive.
     * </pre>
     */
    default void getSession(
        com.google.spanner.v1.GetSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.Session> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all sessions in a given database.
     * </pre>
     */
    default void listSessions(
        com.google.spanner.v1.ListSessionsRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.ListSessionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSessionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Ends a session, releasing server resources associated with it. This
     * asynchronously triggers the cancellation of any operations that are running
     * with this session.
     * </pre>
     */
    default void deleteSession(
        com.google.spanner.v1.DeleteSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Executes an SQL statement, returning all results in a single reply. This
     * method can't be used to return a result set larger than 10 MiB;
     * if the query yields more data than that, the query fails with
     * a `FAILED_PRECONDITION` error.
     * Operations inside read-write transactions might return `ABORTED`. If
     * this occurs, the application should restart the transaction from
     * the beginning. See [Transaction][google.spanner.v1.Transaction] for more
     * details.
     * Larger result sets can be fetched in streaming fashion by calling
     * [ExecuteStreamingSql][google.spanner.v1.Spanner.ExecuteStreamingSql]
     * instead.
     * The query string can be SQL or [Graph Query Language
     * (GQL)](https://cloud.google.com/spanner/docs/reference/standard-sql/graph-intro).
     * </pre>
     */
    default void executeSql(
        com.google.spanner.v1.ExecuteSqlRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.ResultSet> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExecuteSqlMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Like [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql], except returns the
     * result set as a stream. Unlike
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql], there is no limit on
     * the size of the returned result set. However, no individual row in the
     * result set can exceed 100 MiB, and no column value can exceed 10 MiB.
     * The query string can be SQL or [Graph Query Language
     * (GQL)](https://cloud.google.com/spanner/docs/reference/standard-sql/graph-intro).
     * </pre>
     */
    default void executeStreamingSql(
        com.google.spanner.v1.ExecuteSqlRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.PartialResultSet> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExecuteStreamingSqlMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Executes a batch of SQL DML statements. This method allows many statements
     * to be run with lower latency than submitting them sequentially with
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql].
     * Statements are executed in sequential order. A request can succeed even if
     * a statement fails. The
     * [ExecuteBatchDmlResponse.status][google.spanner.v1.ExecuteBatchDmlResponse.status]
     * field in the response provides information about the statement that failed.
     * Clients must inspect this field to determine whether an error occurred.
     * Execution stops after the first failed statement; the remaining statements
     * are not executed.
     * </pre>
     */
    default void executeBatchDml(
        com.google.spanner.v1.ExecuteBatchDmlRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.ExecuteBatchDmlResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExecuteBatchDmlMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reads rows from the database using key lookups and scans, as a
     * simple key/value style alternative to
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql]. This method can't be
     * used to return a result set larger than 10 MiB; if the read matches more
     * data than that, the read fails with a `FAILED_PRECONDITION`
     * error.
     * Reads inside read-write transactions might return `ABORTED`. If
     * this occurs, the application should restart the transaction from
     * the beginning. See [Transaction][google.spanner.v1.Transaction] for more
     * details.
     * Larger result sets can be yielded in streaming fashion by calling
     * [StreamingRead][google.spanner.v1.Spanner.StreamingRead] instead.
     * </pre>
     */
    default void read(
        com.google.spanner.v1.ReadRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.ResultSet> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Like [Read][google.spanner.v1.Spanner.Read], except returns the result set
     * as a stream. Unlike [Read][google.spanner.v1.Spanner.Read], there is no
     * limit on the size of the returned result set. However, no individual row in
     * the result set can exceed 100 MiB, and no column value can exceed
     * 10 MiB.
     * </pre>
     */
    default void streamingRead(
        com.google.spanner.v1.ReadRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.PartialResultSet> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStreamingReadMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Begins a new transaction. This step can often be skipped:
     * [Read][google.spanner.v1.Spanner.Read],
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql] and
     * [Commit][google.spanner.v1.Spanner.Commit] can begin a new transaction as a
     * side-effect.
     * </pre>
     */
    default void beginTransaction(
        com.google.spanner.v1.BeginTransactionRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.Transaction> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBeginTransactionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Commits a transaction. The request includes the mutations to be
     * applied to rows in the database.
     * `Commit` might return an `ABORTED` error. This can occur at any time;
     * commonly, the cause is conflicts with concurrent
     * transactions. However, it can also happen for a variety of other
     * reasons. If `Commit` returns `ABORTED`, the caller should retry
     * the transaction from the beginning, reusing the same session.
     * On very rare occasions, `Commit` might return `UNKNOWN`. This can happen,
     * for example, if the client job experiences a 1+ hour networking failure.
     * At that point, Cloud Spanner has lost track of the transaction outcome and
     * we recommend that you perform another read from the database to see the
     * state of things as they are now.
     * </pre>
     */
    default void commit(
        com.google.spanner.v1.CommitRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.CommitResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCommitMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a transaction, releasing any locks it holds. It's a good
     * idea to call this for any transaction that includes one or more
     * [Read][google.spanner.v1.Spanner.Read] or
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql] requests and ultimately
     * decides not to commit.
     * `Rollback` returns `OK` if it successfully aborts the transaction, the
     * transaction was already aborted, or the transaction isn't
     * found. `Rollback` never returns `ABORTED`.
     * </pre>
     */
    default void rollback(
        com.google.spanner.v1.RollbackRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRollbackMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a set of partition tokens that can be used to execute a query
     * operation in parallel. Each of the returned partition tokens can be used
     * by [ExecuteStreamingSql][google.spanner.v1.Spanner.ExecuteStreamingSql] to
     * specify a subset of the query result to read. The same session and
     * read-only transaction must be used by the `PartitionQueryRequest` used to
     * create the partition tokens and the `ExecuteSqlRequests` that use the
     * partition tokens.
     * Partition tokens become invalid when the session used to create them
     * is deleted, is idle for too long, begins a new transaction, or becomes too
     * old. When any of these happen, it isn't possible to resume the query, and
     * the whole operation must be restarted from the beginning.
     * </pre>
     */
    default void partitionQuery(
        com.google.spanner.v1.PartitionQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.PartitionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPartitionQueryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a set of partition tokens that can be used to execute a read
     * operation in parallel. Each of the returned partition tokens can be used
     * by [StreamingRead][google.spanner.v1.Spanner.StreamingRead] to specify a
     * subset of the read result to read. The same session and read-only
     * transaction must be used by the `PartitionReadRequest` used to create the
     * partition tokens and the `ReadRequests` that use the partition tokens.
     * There are no ordering guarantees on rows returned among the returned
     * partition tokens, or even within each individual `StreamingRead` call
     * issued with a `partition_token`.
     * Partition tokens become invalid when the session used to create them
     * is deleted, is idle for too long, begins a new transaction, or becomes too
     * old. When any of these happen, it isn't possible to resume the read, and
     * the whole operation must be restarted from the beginning.
     * </pre>
     */
    default void partitionRead(
        com.google.spanner.v1.PartitionReadRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.PartitionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPartitionReadMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Batches the supplied mutation groups in a collection of efficient
     * transactions. All mutations in a group are committed atomically. However,
     * mutations across groups can be committed non-atomically in an unspecified
     * order and thus, they must be independent of each other. Partial failure is
     * possible, that is, some groups might have been committed successfully,
     * while some might have failed. The results of individual batches are
     * streamed into the response as the batches are applied.
     * `BatchWrite` requests are not replay protected, meaning that each mutation
     * group can be applied more than once. Replays of non-idempotent mutations
     * can have undesirable effects. For example, replays of an insert mutation
     * can produce an already exists error or if you use generated or commit
     * timestamp-based keys, it can result in additional rows being added to the
     * mutation's table. We recommend structuring your mutation groups to be
     * idempotent to avoid this issue.
     * </pre>
     */
    default void batchWrite(
        com.google.spanner.v1.BatchWriteRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.BatchWriteResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBatchWriteMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Spanner.
   *
   * <pre>
   * Cloud Spanner API
   * The Cloud Spanner API can be used to manage sessions and execute
   * transactions on data stored in Cloud Spanner databases.
   * </pre>
   */
  public abstract static class SpannerImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SpannerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Spanner.
   *
   * <pre>
   * Cloud Spanner API
   * The Cloud Spanner API can be used to manage sessions and execute
   * transactions on data stored in Cloud Spanner databases.
   * </pre>
   */
  public static final class SpannerStub extends io.grpc.stub.AbstractAsyncStub<SpannerStub> {
    private SpannerStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpannerStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SpannerStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new session. A session can be used to perform
     * transactions that read and/or modify data in a Cloud Spanner database.
     * Sessions are meant to be reused for many consecutive
     * transactions.
     * Sessions can only execute one transaction at a time. To execute
     * multiple concurrent read-write/write-only transactions, create
     * multiple sessions. Note that standalone reads and queries use a
     * transaction internally, and count toward the one transaction
     * limit.
     * Active sessions use additional server resources, so it's a good idea to
     * delete idle and unneeded sessions.
     * Aside from explicit deletes, Cloud Spanner can delete sessions when no
     * operations are sent for more than an hour. If a session is deleted,
     * requests to it return `NOT_FOUND`.
     * Idle sessions can be kept alive by sending a trivial SQL query
     * periodically, for example, `"SELECT 1"`.
     * </pre>
     */
    public void createSession(
        com.google.spanner.v1.CreateSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.Session> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates multiple new sessions.
     * This API can be used to initialize a session cache on the clients.
     * See https://goo.gl/TgSFN2 for best practices on session cache management.
     * </pre>
     */
    public void batchCreateSessions(
        com.google.spanner.v1.BatchCreateSessionsRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.BatchCreateSessionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCreateSessionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a session. Returns `NOT_FOUND` if the session doesn't exist.
     * This is mainly useful for determining whether a session is still
     * alive.
     * </pre>
     */
    public void getSession(
        com.google.spanner.v1.GetSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.Session> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSessionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all sessions in a given database.
     * </pre>
     */
    public void listSessions(
        com.google.spanner.v1.ListSessionsRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.ListSessionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSessionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Ends a session, releasing server resources associated with it. This
     * asynchronously triggers the cancellation of any operations that are running
     * with this session.
     * </pre>
     */
    public void deleteSession(
        com.google.spanner.v1.DeleteSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Executes an SQL statement, returning all results in a single reply. This
     * method can't be used to return a result set larger than 10 MiB;
     * if the query yields more data than that, the query fails with
     * a `FAILED_PRECONDITION` error.
     * Operations inside read-write transactions might return `ABORTED`. If
     * this occurs, the application should restart the transaction from
     * the beginning. See [Transaction][google.spanner.v1.Transaction] for more
     * details.
     * Larger result sets can be fetched in streaming fashion by calling
     * [ExecuteStreamingSql][google.spanner.v1.Spanner.ExecuteStreamingSql]
     * instead.
     * The query string can be SQL or [Graph Query Language
     * (GQL)](https://cloud.google.com/spanner/docs/reference/standard-sql/graph-intro).
     * </pre>
     */
    public void executeSql(
        com.google.spanner.v1.ExecuteSqlRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.ResultSet> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExecuteSqlMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Like [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql], except returns the
     * result set as a stream. Unlike
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql], there is no limit on
     * the size of the returned result set. However, no individual row in the
     * result set can exceed 100 MiB, and no column value can exceed 10 MiB.
     * The query string can be SQL or [Graph Query Language
     * (GQL)](https://cloud.google.com/spanner/docs/reference/standard-sql/graph-intro).
     * </pre>
     */
    public void executeStreamingSql(
        com.google.spanner.v1.ExecuteSqlRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.PartialResultSet> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getExecuteStreamingSqlMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Executes a batch of SQL DML statements. This method allows many statements
     * to be run with lower latency than submitting them sequentially with
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql].
     * Statements are executed in sequential order. A request can succeed even if
     * a statement fails. The
     * [ExecuteBatchDmlResponse.status][google.spanner.v1.ExecuteBatchDmlResponse.status]
     * field in the response provides information about the statement that failed.
     * Clients must inspect this field to determine whether an error occurred.
     * Execution stops after the first failed statement; the remaining statements
     * are not executed.
     * </pre>
     */
    public void executeBatchDml(
        com.google.spanner.v1.ExecuteBatchDmlRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.ExecuteBatchDmlResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExecuteBatchDmlMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reads rows from the database using key lookups and scans, as a
     * simple key/value style alternative to
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql]. This method can't be
     * used to return a result set larger than 10 MiB; if the read matches more
     * data than that, the read fails with a `FAILED_PRECONDITION`
     * error.
     * Reads inside read-write transactions might return `ABORTED`. If
     * this occurs, the application should restart the transaction from
     * the beginning. See [Transaction][google.spanner.v1.Transaction] for more
     * details.
     * Larger result sets can be yielded in streaming fashion by calling
     * [StreamingRead][google.spanner.v1.Spanner.StreamingRead] instead.
     * </pre>
     */
    public void read(
        com.google.spanner.v1.ReadRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.ResultSet> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Like [Read][google.spanner.v1.Spanner.Read], except returns the result set
     * as a stream. Unlike [Read][google.spanner.v1.Spanner.Read], there is no
     * limit on the size of the returned result set. However, no individual row in
     * the result set can exceed 100 MiB, and no column value can exceed
     * 10 MiB.
     * </pre>
     */
    public void streamingRead(
        com.google.spanner.v1.ReadRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.PartialResultSet> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamingReadMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Begins a new transaction. This step can often be skipped:
     * [Read][google.spanner.v1.Spanner.Read],
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql] and
     * [Commit][google.spanner.v1.Spanner.Commit] can begin a new transaction as a
     * side-effect.
     * </pre>
     */
    public void beginTransaction(
        com.google.spanner.v1.BeginTransactionRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.Transaction> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBeginTransactionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Commits a transaction. The request includes the mutations to be
     * applied to rows in the database.
     * `Commit` might return an `ABORTED` error. This can occur at any time;
     * commonly, the cause is conflicts with concurrent
     * transactions. However, it can also happen for a variety of other
     * reasons. If `Commit` returns `ABORTED`, the caller should retry
     * the transaction from the beginning, reusing the same session.
     * On very rare occasions, `Commit` might return `UNKNOWN`. This can happen,
     * for example, if the client job experiences a 1+ hour networking failure.
     * At that point, Cloud Spanner has lost track of the transaction outcome and
     * we recommend that you perform another read from the database to see the
     * state of things as they are now.
     * </pre>
     */
    public void commit(
        com.google.spanner.v1.CommitRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.CommitResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCommitMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a transaction, releasing any locks it holds. It's a good
     * idea to call this for any transaction that includes one or more
     * [Read][google.spanner.v1.Spanner.Read] or
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql] requests and ultimately
     * decides not to commit.
     * `Rollback` returns `OK` if it successfully aborts the transaction, the
     * transaction was already aborted, or the transaction isn't
     * found. `Rollback` never returns `ABORTED`.
     * </pre>
     */
    public void rollback(
        com.google.spanner.v1.RollbackRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRollbackMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a set of partition tokens that can be used to execute a query
     * operation in parallel. Each of the returned partition tokens can be used
     * by [ExecuteStreamingSql][google.spanner.v1.Spanner.ExecuteStreamingSql] to
     * specify a subset of the query result to read. The same session and
     * read-only transaction must be used by the `PartitionQueryRequest` used to
     * create the partition tokens and the `ExecuteSqlRequests` that use the
     * partition tokens.
     * Partition tokens become invalid when the session used to create them
     * is deleted, is idle for too long, begins a new transaction, or becomes too
     * old. When any of these happen, it isn't possible to resume the query, and
     * the whole operation must be restarted from the beginning.
     * </pre>
     */
    public void partitionQuery(
        com.google.spanner.v1.PartitionQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.PartitionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPartitionQueryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a set of partition tokens that can be used to execute a read
     * operation in parallel. Each of the returned partition tokens can be used
     * by [StreamingRead][google.spanner.v1.Spanner.StreamingRead] to specify a
     * subset of the read result to read. The same session and read-only
     * transaction must be used by the `PartitionReadRequest` used to create the
     * partition tokens and the `ReadRequests` that use the partition tokens.
     * There are no ordering guarantees on rows returned among the returned
     * partition tokens, or even within each individual `StreamingRead` call
     * issued with a `partition_token`.
     * Partition tokens become invalid when the session used to create them
     * is deleted, is idle for too long, begins a new transaction, or becomes too
     * old. When any of these happen, it isn't possible to resume the read, and
     * the whole operation must be restarted from the beginning.
     * </pre>
     */
    public void partitionRead(
        com.google.spanner.v1.PartitionReadRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.PartitionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPartitionReadMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Batches the supplied mutation groups in a collection of efficient
     * transactions. All mutations in a group are committed atomically. However,
     * mutations across groups can be committed non-atomically in an unspecified
     * order and thus, they must be independent of each other. Partial failure is
     * possible, that is, some groups might have been committed successfully,
     * while some might have failed. The results of individual batches are
     * streamed into the response as the batches are applied.
     * `BatchWrite` requests are not replay protected, meaning that each mutation
     * group can be applied more than once. Replays of non-idempotent mutations
     * can have undesirable effects. For example, replays of an insert mutation
     * can produce an already exists error or if you use generated or commit
     * timestamp-based keys, it can result in additional rows being added to the
     * mutation's table. We recommend structuring your mutation groups to be
     * idempotent to avoid this issue.
     * </pre>
     */
    public void batchWrite(
        com.google.spanner.v1.BatchWriteRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.BatchWriteResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getBatchWriteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Spanner.
   *
   * <pre>
   * Cloud Spanner API
   * The Cloud Spanner API can be used to manage sessions and execute
   * transactions on data stored in Cloud Spanner databases.
   * </pre>
   */
  public static final class SpannerBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SpannerBlockingV2Stub> {
    private SpannerBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpannerBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SpannerBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new session. A session can be used to perform
     * transactions that read and/or modify data in a Cloud Spanner database.
     * Sessions are meant to be reused for many consecutive
     * transactions.
     * Sessions can only execute one transaction at a time. To execute
     * multiple concurrent read-write/write-only transactions, create
     * multiple sessions. Note that standalone reads and queries use a
     * transaction internally, and count toward the one transaction
     * limit.
     * Active sessions use additional server resources, so it's a good idea to
     * delete idle and unneeded sessions.
     * Aside from explicit deletes, Cloud Spanner can delete sessions when no
     * operations are sent for more than an hour. If a session is deleted,
     * requests to it return `NOT_FOUND`.
     * Idle sessions can be kept alive by sending a trivial SQL query
     * periodically, for example, `"SELECT 1"`.
     * </pre>
     */
    public com.google.spanner.v1.Session createSession(
        com.google.spanner.v1.CreateSessionRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates multiple new sessions.
     * This API can be used to initialize a session cache on the clients.
     * See https://goo.gl/TgSFN2 for best practices on session cache management.
     * </pre>
     */
    public com.google.spanner.v1.BatchCreateSessionsResponse batchCreateSessions(
        com.google.spanner.v1.BatchCreateSessionsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBatchCreateSessionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a session. Returns `NOT_FOUND` if the session doesn't exist.
     * This is mainly useful for determining whether a session is still
     * alive.
     * </pre>
     */
    public com.google.spanner.v1.Session getSession(com.google.spanner.v1.GetSessionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all sessions in a given database.
     * </pre>
     */
    public com.google.spanner.v1.ListSessionsResponse listSessions(
        com.google.spanner.v1.ListSessionsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListSessionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Ends a session, releasing server resources associated with it. This
     * asynchronously triggers the cancellation of any operations that are running
     * with this session.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSession(
        com.google.spanner.v1.DeleteSessionRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Executes an SQL statement, returning all results in a single reply. This
     * method can't be used to return a result set larger than 10 MiB;
     * if the query yields more data than that, the query fails with
     * a `FAILED_PRECONDITION` error.
     * Operations inside read-write transactions might return `ABORTED`. If
     * this occurs, the application should restart the transaction from
     * the beginning. See [Transaction][google.spanner.v1.Transaction] for more
     * details.
     * Larger result sets can be fetched in streaming fashion by calling
     * [ExecuteStreamingSql][google.spanner.v1.Spanner.ExecuteStreamingSql]
     * instead.
     * The query string can be SQL or [Graph Query Language
     * (GQL)](https://cloud.google.com/spanner/docs/reference/standard-sql/graph-intro).
     * </pre>
     */
    public com.google.spanner.v1.ResultSet executeSql(
        com.google.spanner.v1.ExecuteSqlRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getExecuteSqlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Like [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql], except returns the
     * result set as a stream. Unlike
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql], there is no limit on
     * the size of the returned result set. However, no individual row in the
     * result set can exceed 100 MiB, and no column value can exceed 10 MiB.
     * The query string can be SQL or [Graph Query Language
     * (GQL)](https://cloud.google.com/spanner/docs/reference/standard-sql/graph-intro).
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, com.google.spanner.v1.PartialResultSet>
        executeStreamingSql(com.google.spanner.v1.ExecuteSqlRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getExecuteStreamingSqlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Executes a batch of SQL DML statements. This method allows many statements
     * to be run with lower latency than submitting them sequentially with
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql].
     * Statements are executed in sequential order. A request can succeed even if
     * a statement fails. The
     * [ExecuteBatchDmlResponse.status][google.spanner.v1.ExecuteBatchDmlResponse.status]
     * field in the response provides information about the statement that failed.
     * Clients must inspect this field to determine whether an error occurred.
     * Execution stops after the first failed statement; the remaining statements
     * are not executed.
     * </pre>
     */
    public com.google.spanner.v1.ExecuteBatchDmlResponse executeBatchDml(
        com.google.spanner.v1.ExecuteBatchDmlRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getExecuteBatchDmlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reads rows from the database using key lookups and scans, as a
     * simple key/value style alternative to
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql]. This method can't be
     * used to return a result set larger than 10 MiB; if the read matches more
     * data than that, the read fails with a `FAILED_PRECONDITION`
     * error.
     * Reads inside read-write transactions might return `ABORTED`. If
     * this occurs, the application should restart the transaction from
     * the beginning. See [Transaction][google.spanner.v1.Transaction] for more
     * details.
     * Larger result sets can be yielded in streaming fashion by calling
     * [StreamingRead][google.spanner.v1.Spanner.StreamingRead] instead.
     * </pre>
     */
    public com.google.spanner.v1.ResultSet read(com.google.spanner.v1.ReadRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getReadMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Like [Read][google.spanner.v1.Spanner.Read], except returns the result set
     * as a stream. Unlike [Read][google.spanner.v1.Spanner.Read], there is no
     * limit on the size of the returned result set. However, no individual row in
     * the result set can exceed 100 MiB, and no column value can exceed
     * 10 MiB.
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, com.google.spanner.v1.PartialResultSet> streamingRead(
        com.google.spanner.v1.ReadRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getStreamingReadMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Begins a new transaction. This step can often be skipped:
     * [Read][google.spanner.v1.Spanner.Read],
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql] and
     * [Commit][google.spanner.v1.Spanner.Commit] can begin a new transaction as a
     * side-effect.
     * </pre>
     */
    public com.google.spanner.v1.Transaction beginTransaction(
        com.google.spanner.v1.BeginTransactionRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBeginTransactionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Commits a transaction. The request includes the mutations to be
     * applied to rows in the database.
     * `Commit` might return an `ABORTED` error. This can occur at any time;
     * commonly, the cause is conflicts with concurrent
     * transactions. However, it can also happen for a variety of other
     * reasons. If `Commit` returns `ABORTED`, the caller should retry
     * the transaction from the beginning, reusing the same session.
     * On very rare occasions, `Commit` might return `UNKNOWN`. This can happen,
     * for example, if the client job experiences a 1+ hour networking failure.
     * At that point, Cloud Spanner has lost track of the transaction outcome and
     * we recommend that you perform another read from the database to see the
     * state of things as they are now.
     * </pre>
     */
    public com.google.spanner.v1.CommitResponse commit(com.google.spanner.v1.CommitRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCommitMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a transaction, releasing any locks it holds. It's a good
     * idea to call this for any transaction that includes one or more
     * [Read][google.spanner.v1.Spanner.Read] or
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql] requests and ultimately
     * decides not to commit.
     * `Rollback` returns `OK` if it successfully aborts the transaction, the
     * transaction was already aborted, or the transaction isn't
     * found. `Rollback` never returns `ABORTED`.
     * </pre>
     */
    public com.google.protobuf.Empty rollback(com.google.spanner.v1.RollbackRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRollbackMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a set of partition tokens that can be used to execute a query
     * operation in parallel. Each of the returned partition tokens can be used
     * by [ExecuteStreamingSql][google.spanner.v1.Spanner.ExecuteStreamingSql] to
     * specify a subset of the query result to read. The same session and
     * read-only transaction must be used by the `PartitionQueryRequest` used to
     * create the partition tokens and the `ExecuteSqlRequests` that use the
     * partition tokens.
     * Partition tokens become invalid when the session used to create them
     * is deleted, is idle for too long, begins a new transaction, or becomes too
     * old. When any of these happen, it isn't possible to resume the query, and
     * the whole operation must be restarted from the beginning.
     * </pre>
     */
    public com.google.spanner.v1.PartitionResponse partitionQuery(
        com.google.spanner.v1.PartitionQueryRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getPartitionQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a set of partition tokens that can be used to execute a read
     * operation in parallel. Each of the returned partition tokens can be used
     * by [StreamingRead][google.spanner.v1.Spanner.StreamingRead] to specify a
     * subset of the read result to read. The same session and read-only
     * transaction must be used by the `PartitionReadRequest` used to create the
     * partition tokens and the `ReadRequests` that use the partition tokens.
     * There are no ordering guarantees on rows returned among the returned
     * partition tokens, or even within each individual `StreamingRead` call
     * issued with a `partition_token`.
     * Partition tokens become invalid when the session used to create them
     * is deleted, is idle for too long, begins a new transaction, or becomes too
     * old. When any of these happen, it isn't possible to resume the read, and
     * the whole operation must be restarted from the beginning.
     * </pre>
     */
    public com.google.spanner.v1.PartitionResponse partitionRead(
        com.google.spanner.v1.PartitionReadRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getPartitionReadMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Batches the supplied mutation groups in a collection of efficient
     * transactions. All mutations in a group are committed atomically. However,
     * mutations across groups can be committed non-atomically in an unspecified
     * order and thus, they must be independent of each other. Partial failure is
     * possible, that is, some groups might have been committed successfully,
     * while some might have failed. The results of individual batches are
     * streamed into the response as the batches are applied.
     * `BatchWrite` requests are not replay protected, meaning that each mutation
     * group can be applied more than once. Replays of non-idempotent mutations
     * can have undesirable effects. For example, replays of an insert mutation
     * can produce an already exists error or if you use generated or commit
     * timestamp-based keys, it can result in additional rows being added to the
     * mutation's table. We recommend structuring your mutation groups to be
     * idempotent to avoid this issue.
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, com.google.spanner.v1.BatchWriteResponse> batchWrite(
        com.google.spanner.v1.BatchWriteRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getBatchWriteMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Spanner.
   *
   * <pre>
   * Cloud Spanner API
   * The Cloud Spanner API can be used to manage sessions and execute
   * transactions on data stored in Cloud Spanner databases.
   * </pre>
   */
  public static final class SpannerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SpannerBlockingStub> {
    private SpannerBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpannerBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SpannerBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new session. A session can be used to perform
     * transactions that read and/or modify data in a Cloud Spanner database.
     * Sessions are meant to be reused for many consecutive
     * transactions.
     * Sessions can only execute one transaction at a time. To execute
     * multiple concurrent read-write/write-only transactions, create
     * multiple sessions. Note that standalone reads and queries use a
     * transaction internally, and count toward the one transaction
     * limit.
     * Active sessions use additional server resources, so it's a good idea to
     * delete idle and unneeded sessions.
     * Aside from explicit deletes, Cloud Spanner can delete sessions when no
     * operations are sent for more than an hour. If a session is deleted,
     * requests to it return `NOT_FOUND`.
     * Idle sessions can be kept alive by sending a trivial SQL query
     * periodically, for example, `"SELECT 1"`.
     * </pre>
     */
    public com.google.spanner.v1.Session createSession(
        com.google.spanner.v1.CreateSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates multiple new sessions.
     * This API can be used to initialize a session cache on the clients.
     * See https://goo.gl/TgSFN2 for best practices on session cache management.
     * </pre>
     */
    public com.google.spanner.v1.BatchCreateSessionsResponse batchCreateSessions(
        com.google.spanner.v1.BatchCreateSessionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreateSessionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a session. Returns `NOT_FOUND` if the session doesn't exist.
     * This is mainly useful for determining whether a session is still
     * alive.
     * </pre>
     */
    public com.google.spanner.v1.Session getSession(
        com.google.spanner.v1.GetSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all sessions in a given database.
     * </pre>
     */
    public com.google.spanner.v1.ListSessionsResponse listSessions(
        com.google.spanner.v1.ListSessionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSessionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Ends a session, releasing server resources associated with it. This
     * asynchronously triggers the cancellation of any operations that are running
     * with this session.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSession(
        com.google.spanner.v1.DeleteSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Executes an SQL statement, returning all results in a single reply. This
     * method can't be used to return a result set larger than 10 MiB;
     * if the query yields more data than that, the query fails with
     * a `FAILED_PRECONDITION` error.
     * Operations inside read-write transactions might return `ABORTED`. If
     * this occurs, the application should restart the transaction from
     * the beginning. See [Transaction][google.spanner.v1.Transaction] for more
     * details.
     * Larger result sets can be fetched in streaming fashion by calling
     * [ExecuteStreamingSql][google.spanner.v1.Spanner.ExecuteStreamingSql]
     * instead.
     * The query string can be SQL or [Graph Query Language
     * (GQL)](https://cloud.google.com/spanner/docs/reference/standard-sql/graph-intro).
     * </pre>
     */
    public com.google.spanner.v1.ResultSet executeSql(
        com.google.spanner.v1.ExecuteSqlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExecuteSqlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Like [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql], except returns the
     * result set as a stream. Unlike
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql], there is no limit on
     * the size of the returned result set. However, no individual row in the
     * result set can exceed 100 MiB, and no column value can exceed 10 MiB.
     * The query string can be SQL or [Graph Query Language
     * (GQL)](https://cloud.google.com/spanner/docs/reference/standard-sql/graph-intro).
     * </pre>
     */
    public java.util.Iterator<com.google.spanner.v1.PartialResultSet> executeStreamingSql(
        com.google.spanner.v1.ExecuteSqlRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getExecuteStreamingSqlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Executes a batch of SQL DML statements. This method allows many statements
     * to be run with lower latency than submitting them sequentially with
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql].
     * Statements are executed in sequential order. A request can succeed even if
     * a statement fails. The
     * [ExecuteBatchDmlResponse.status][google.spanner.v1.ExecuteBatchDmlResponse.status]
     * field in the response provides information about the statement that failed.
     * Clients must inspect this field to determine whether an error occurred.
     * Execution stops after the first failed statement; the remaining statements
     * are not executed.
     * </pre>
     */
    public com.google.spanner.v1.ExecuteBatchDmlResponse executeBatchDml(
        com.google.spanner.v1.ExecuteBatchDmlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExecuteBatchDmlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reads rows from the database using key lookups and scans, as a
     * simple key/value style alternative to
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql]. This method can't be
     * used to return a result set larger than 10 MiB; if the read matches more
     * data than that, the read fails with a `FAILED_PRECONDITION`
     * error.
     * Reads inside read-write transactions might return `ABORTED`. If
     * this occurs, the application should restart the transaction from
     * the beginning. See [Transaction][google.spanner.v1.Transaction] for more
     * details.
     * Larger result sets can be yielded in streaming fashion by calling
     * [StreamingRead][google.spanner.v1.Spanner.StreamingRead] instead.
     * </pre>
     */
    public com.google.spanner.v1.ResultSet read(com.google.spanner.v1.ReadRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReadMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Like [Read][google.spanner.v1.Spanner.Read], except returns the result set
     * as a stream. Unlike [Read][google.spanner.v1.Spanner.Read], there is no
     * limit on the size of the returned result set. However, no individual row in
     * the result set can exceed 100 MiB, and no column value can exceed
     * 10 MiB.
     * </pre>
     */
    public java.util.Iterator<com.google.spanner.v1.PartialResultSet> streamingRead(
        com.google.spanner.v1.ReadRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamingReadMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Begins a new transaction. This step can often be skipped:
     * [Read][google.spanner.v1.Spanner.Read],
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql] and
     * [Commit][google.spanner.v1.Spanner.Commit] can begin a new transaction as a
     * side-effect.
     * </pre>
     */
    public com.google.spanner.v1.Transaction beginTransaction(
        com.google.spanner.v1.BeginTransactionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBeginTransactionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Commits a transaction. The request includes the mutations to be
     * applied to rows in the database.
     * `Commit` might return an `ABORTED` error. This can occur at any time;
     * commonly, the cause is conflicts with concurrent
     * transactions. However, it can also happen for a variety of other
     * reasons. If `Commit` returns `ABORTED`, the caller should retry
     * the transaction from the beginning, reusing the same session.
     * On very rare occasions, `Commit` might return `UNKNOWN`. This can happen,
     * for example, if the client job experiences a 1+ hour networking failure.
     * At that point, Cloud Spanner has lost track of the transaction outcome and
     * we recommend that you perform another read from the database to see the
     * state of things as they are now.
     * </pre>
     */
    public com.google.spanner.v1.CommitResponse commit(
        com.google.spanner.v1.CommitRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCommitMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a transaction, releasing any locks it holds. It's a good
     * idea to call this for any transaction that includes one or more
     * [Read][google.spanner.v1.Spanner.Read] or
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql] requests and ultimately
     * decides not to commit.
     * `Rollback` returns `OK` if it successfully aborts the transaction, the
     * transaction was already aborted, or the transaction isn't
     * found. `Rollback` never returns `ABORTED`.
     * </pre>
     */
    public com.google.protobuf.Empty rollback(com.google.spanner.v1.RollbackRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRollbackMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a set of partition tokens that can be used to execute a query
     * operation in parallel. Each of the returned partition tokens can be used
     * by [ExecuteStreamingSql][google.spanner.v1.Spanner.ExecuteStreamingSql] to
     * specify a subset of the query result to read. The same session and
     * read-only transaction must be used by the `PartitionQueryRequest` used to
     * create the partition tokens and the `ExecuteSqlRequests` that use the
     * partition tokens.
     * Partition tokens become invalid when the session used to create them
     * is deleted, is idle for too long, begins a new transaction, or becomes too
     * old. When any of these happen, it isn't possible to resume the query, and
     * the whole operation must be restarted from the beginning.
     * </pre>
     */
    public com.google.spanner.v1.PartitionResponse partitionQuery(
        com.google.spanner.v1.PartitionQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPartitionQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a set of partition tokens that can be used to execute a read
     * operation in parallel. Each of the returned partition tokens can be used
     * by [StreamingRead][google.spanner.v1.Spanner.StreamingRead] to specify a
     * subset of the read result to read. The same session and read-only
     * transaction must be used by the `PartitionReadRequest` used to create the
     * partition tokens and the `ReadRequests` that use the partition tokens.
     * There are no ordering guarantees on rows returned among the returned
     * partition tokens, or even within each individual `StreamingRead` call
     * issued with a `partition_token`.
     * Partition tokens become invalid when the session used to create them
     * is deleted, is idle for too long, begins a new transaction, or becomes too
     * old. When any of these happen, it isn't possible to resume the read, and
     * the whole operation must be restarted from the beginning.
     * </pre>
     */
    public com.google.spanner.v1.PartitionResponse partitionRead(
        com.google.spanner.v1.PartitionReadRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPartitionReadMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Batches the supplied mutation groups in a collection of efficient
     * transactions. All mutations in a group are committed atomically. However,
     * mutations across groups can be committed non-atomically in an unspecified
     * order and thus, they must be independent of each other. Partial failure is
     * possible, that is, some groups might have been committed successfully,
     * while some might have failed. The results of individual batches are
     * streamed into the response as the batches are applied.
     * `BatchWrite` requests are not replay protected, meaning that each mutation
     * group can be applied more than once. Replays of non-idempotent mutations
     * can have undesirable effects. For example, replays of an insert mutation
     * can produce an already exists error or if you use generated or commit
     * timestamp-based keys, it can result in additional rows being added to the
     * mutation's table. We recommend structuring your mutation groups to be
     * idempotent to avoid this issue.
     * </pre>
     */
    public java.util.Iterator<com.google.spanner.v1.BatchWriteResponse> batchWrite(
        com.google.spanner.v1.BatchWriteRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getBatchWriteMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Spanner.
   *
   * <pre>
   * Cloud Spanner API
   * The Cloud Spanner API can be used to manage sessions and execute
   * transactions on data stored in Cloud Spanner databases.
   * </pre>
   */
  public static final class SpannerFutureStub
      extends io.grpc.stub.AbstractFutureStub<SpannerFutureStub> {
    private SpannerFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpannerFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SpannerFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new session. A session can be used to perform
     * transactions that read and/or modify data in a Cloud Spanner database.
     * Sessions are meant to be reused for many consecutive
     * transactions.
     * Sessions can only execute one transaction at a time. To execute
     * multiple concurrent read-write/write-only transactions, create
     * multiple sessions. Note that standalone reads and queries use a
     * transaction internally, and count toward the one transaction
     * limit.
     * Active sessions use additional server resources, so it's a good idea to
     * delete idle and unneeded sessions.
     * Aside from explicit deletes, Cloud Spanner can delete sessions when no
     * operations are sent for more than an hour. If a session is deleted,
     * requests to it return `NOT_FOUND`.
     * Idle sessions can be kept alive by sending a trivial SQL query
     * periodically, for example, `"SELECT 1"`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.spanner.v1.Session>
        createSession(com.google.spanner.v1.CreateSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates multiple new sessions.
     * This API can be used to initialize a session cache on the clients.
     * See https://goo.gl/TgSFN2 for best practices on session cache management.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.v1.BatchCreateSessionsResponse>
        batchCreateSessions(com.google.spanner.v1.BatchCreateSessionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCreateSessionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a session. Returns `NOT_FOUND` if the session doesn't exist.
     * This is mainly useful for determining whether a session is still
     * alive.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.spanner.v1.Session>
        getSession(com.google.spanner.v1.GetSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all sessions in a given database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.v1.ListSessionsResponse>
        listSessions(com.google.spanner.v1.ListSessionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSessionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Ends a session, releasing server resources associated with it. This
     * asynchronously triggers the cancellation of any operations that are running
     * with this session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSession(com.google.spanner.v1.DeleteSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Executes an SQL statement, returning all results in a single reply. This
     * method can't be used to return a result set larger than 10 MiB;
     * if the query yields more data than that, the query fails with
     * a `FAILED_PRECONDITION` error.
     * Operations inside read-write transactions might return `ABORTED`. If
     * this occurs, the application should restart the transaction from
     * the beginning. See [Transaction][google.spanner.v1.Transaction] for more
     * details.
     * Larger result sets can be fetched in streaming fashion by calling
     * [ExecuteStreamingSql][google.spanner.v1.Spanner.ExecuteStreamingSql]
     * instead.
     * The query string can be SQL or [Graph Query Language
     * (GQL)](https://cloud.google.com/spanner/docs/reference/standard-sql/graph-intro).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.spanner.v1.ResultSet>
        executeSql(com.google.spanner.v1.ExecuteSqlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExecuteSqlMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Executes a batch of SQL DML statements. This method allows many statements
     * to be run with lower latency than submitting them sequentially with
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql].
     * Statements are executed in sequential order. A request can succeed even if
     * a statement fails. The
     * [ExecuteBatchDmlResponse.status][google.spanner.v1.ExecuteBatchDmlResponse.status]
     * field in the response provides information about the statement that failed.
     * Clients must inspect this field to determine whether an error occurred.
     * Execution stops after the first failed statement; the remaining statements
     * are not executed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.v1.ExecuteBatchDmlResponse>
        executeBatchDml(com.google.spanner.v1.ExecuteBatchDmlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExecuteBatchDmlMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Reads rows from the database using key lookups and scans, as a
     * simple key/value style alternative to
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql]. This method can't be
     * used to return a result set larger than 10 MiB; if the read matches more
     * data than that, the read fails with a `FAILED_PRECONDITION`
     * error.
     * Reads inside read-write transactions might return `ABORTED`. If
     * this occurs, the application should restart the transaction from
     * the beginning. See [Transaction][google.spanner.v1.Transaction] for more
     * details.
     * Larger result sets can be yielded in streaming fashion by calling
     * [StreamingRead][google.spanner.v1.Spanner.StreamingRead] instead.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.spanner.v1.ResultSet> read(
        com.google.spanner.v1.ReadRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReadMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Begins a new transaction. This step can often be skipped:
     * [Read][google.spanner.v1.Spanner.Read],
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql] and
     * [Commit][google.spanner.v1.Spanner.Commit] can begin a new transaction as a
     * side-effect.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.spanner.v1.Transaction>
        beginTransaction(com.google.spanner.v1.BeginTransactionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBeginTransactionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Commits a transaction. The request includes the mutations to be
     * applied to rows in the database.
     * `Commit` might return an `ABORTED` error. This can occur at any time;
     * commonly, the cause is conflicts with concurrent
     * transactions. However, it can also happen for a variety of other
     * reasons. If `Commit` returns `ABORTED`, the caller should retry
     * the transaction from the beginning, reusing the same session.
     * On very rare occasions, `Commit` might return `UNKNOWN`. This can happen,
     * for example, if the client job experiences a 1+ hour networking failure.
     * At that point, Cloud Spanner has lost track of the transaction outcome and
     * we recommend that you perform another read from the database to see the
     * state of things as they are now.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.spanner.v1.CommitResponse>
        commit(com.google.spanner.v1.CommitRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCommitMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a transaction, releasing any locks it holds. It's a good
     * idea to call this for any transaction that includes one or more
     * [Read][google.spanner.v1.Spanner.Read] or
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql] requests and ultimately
     * decides not to commit.
     * `Rollback` returns `OK` if it successfully aborts the transaction, the
     * transaction was already aborted, or the transaction isn't
     * found. `Rollback` never returns `ABORTED`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> rollback(
        com.google.spanner.v1.RollbackRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRollbackMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a set of partition tokens that can be used to execute a query
     * operation in parallel. Each of the returned partition tokens can be used
     * by [ExecuteStreamingSql][google.spanner.v1.Spanner.ExecuteStreamingSql] to
     * specify a subset of the query result to read. The same session and
     * read-only transaction must be used by the `PartitionQueryRequest` used to
     * create the partition tokens and the `ExecuteSqlRequests` that use the
     * partition tokens.
     * Partition tokens become invalid when the session used to create them
     * is deleted, is idle for too long, begins a new transaction, or becomes too
     * old. When any of these happen, it isn't possible to resume the query, and
     * the whole operation must be restarted from the beginning.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.v1.PartitionResponse>
        partitionQuery(com.google.spanner.v1.PartitionQueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPartitionQueryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a set of partition tokens that can be used to execute a read
     * operation in parallel. Each of the returned partition tokens can be used
     * by [StreamingRead][google.spanner.v1.Spanner.StreamingRead] to specify a
     * subset of the read result to read. The same session and read-only
     * transaction must be used by the `PartitionReadRequest` used to create the
     * partition tokens and the `ReadRequests` that use the partition tokens.
     * There are no ordering guarantees on rows returned among the returned
     * partition tokens, or even within each individual `StreamingRead` call
     * issued with a `partition_token`.
     * Partition tokens become invalid when the session used to create them
     * is deleted, is idle for too long, begins a new transaction, or becomes too
     * old. When any of these happen, it isn't possible to resume the read, and
     * the whole operation must be restarted from the beginning.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.v1.PartitionResponse>
        partitionRead(com.google.spanner.v1.PartitionReadRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPartitionReadMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SESSION = 0;
  private static final int METHODID_BATCH_CREATE_SESSIONS = 1;
  private static final int METHODID_GET_SESSION = 2;
  private static final int METHODID_LIST_SESSIONS = 3;
  private static final int METHODID_DELETE_SESSION = 4;
  private static final int METHODID_EXECUTE_SQL = 5;
  private static final int METHODID_EXECUTE_STREAMING_SQL = 6;
  private static final int METHODID_EXECUTE_BATCH_DML = 7;
  private static final int METHODID_READ = 8;
  private static final int METHODID_STREAMING_READ = 9;
  private static final int METHODID_BEGIN_TRANSACTION = 10;
  private static final int METHODID_COMMIT = 11;
  private static final int METHODID_ROLLBACK = 12;
  private static final int METHODID_PARTITION_QUERY = 13;
  private static final int METHODID_PARTITION_READ = 14;
  private static final int METHODID_BATCH_WRITE = 15;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_SESSION:
          serviceImpl.createSession(
              (com.google.spanner.v1.CreateSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.v1.Session>) responseObserver);
          break;
        case METHODID_BATCH_CREATE_SESSIONS:
          serviceImpl.batchCreateSessions(
              (com.google.spanner.v1.BatchCreateSessionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.v1.BatchCreateSessionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SESSION:
          serviceImpl.getSession(
              (com.google.spanner.v1.GetSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.v1.Session>) responseObserver);
          break;
        case METHODID_LIST_SESSIONS:
          serviceImpl.listSessions(
              (com.google.spanner.v1.ListSessionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.v1.ListSessionsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_SESSION:
          serviceImpl.deleteSession(
              (com.google.spanner.v1.DeleteSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_EXECUTE_SQL:
          serviceImpl.executeSql(
              (com.google.spanner.v1.ExecuteSqlRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.v1.ResultSet>) responseObserver);
          break;
        case METHODID_EXECUTE_STREAMING_SQL:
          serviceImpl.executeStreamingSql(
              (com.google.spanner.v1.ExecuteSqlRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.v1.PartialResultSet>)
                  responseObserver);
          break;
        case METHODID_EXECUTE_BATCH_DML:
          serviceImpl.executeBatchDml(
              (com.google.spanner.v1.ExecuteBatchDmlRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.v1.ExecuteBatchDmlResponse>)
                  responseObserver);
          break;
        case METHODID_READ:
          serviceImpl.read(
              (com.google.spanner.v1.ReadRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.v1.ResultSet>) responseObserver);
          break;
        case METHODID_STREAMING_READ:
          serviceImpl.streamingRead(
              (com.google.spanner.v1.ReadRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.v1.PartialResultSet>)
                  responseObserver);
          break;
        case METHODID_BEGIN_TRANSACTION:
          serviceImpl.beginTransaction(
              (com.google.spanner.v1.BeginTransactionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.v1.Transaction>) responseObserver);
          break;
        case METHODID_COMMIT:
          serviceImpl.commit(
              (com.google.spanner.v1.CommitRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.v1.CommitResponse>) responseObserver);
          break;
        case METHODID_ROLLBACK:
          serviceImpl.rollback(
              (com.google.spanner.v1.RollbackRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_PARTITION_QUERY:
          serviceImpl.partitionQuery(
              (com.google.spanner.v1.PartitionQueryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.v1.PartitionResponse>)
                  responseObserver);
          break;
        case METHODID_PARTITION_READ:
          serviceImpl.partitionRead(
              (com.google.spanner.v1.PartitionReadRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.v1.PartitionResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_WRITE:
          serviceImpl.batchWrite(
              (com.google.spanner.v1.BatchWriteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.v1.BatchWriteResponse>)
                  responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getCreateSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.v1.CreateSessionRequest, com.google.spanner.v1.Session>(
                    service, METHODID_CREATE_SESSION)))
        .addMethod(
            getBatchCreateSessionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.v1.BatchCreateSessionsRequest,
                    com.google.spanner.v1.BatchCreateSessionsResponse>(
                    service, METHODID_BATCH_CREATE_SESSIONS)))
        .addMethod(
            getGetSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.v1.GetSessionRequest, com.google.spanner.v1.Session>(
                    service, METHODID_GET_SESSION)))
        .addMethod(
            getListSessionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.v1.ListSessionsRequest,
                    com.google.spanner.v1.ListSessionsResponse>(service, METHODID_LIST_SESSIONS)))
        .addMethod(
            getDeleteSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.v1.DeleteSessionRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_SESSION)))
        .addMethod(
            getExecuteSqlMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.v1.ExecuteSqlRequest, com.google.spanner.v1.ResultSet>(
                    service, METHODID_EXECUTE_SQL)))
        .addMethod(
            getExecuteStreamingSqlMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                new MethodHandlers<
                    com.google.spanner.v1.ExecuteSqlRequest,
                    com.google.spanner.v1.PartialResultSet>(
                    service, METHODID_EXECUTE_STREAMING_SQL)))
        .addMethod(
            getExecuteBatchDmlMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.v1.ExecuteBatchDmlRequest,
                    com.google.spanner.v1.ExecuteBatchDmlResponse>(
                    service, METHODID_EXECUTE_BATCH_DML)))
        .addMethod(
            getReadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.v1.ReadRequest, com.google.spanner.v1.ResultSet>(
                    service, METHODID_READ)))
        .addMethod(
            getStreamingReadMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                new MethodHandlers<
                    com.google.spanner.v1.ReadRequest, com.google.spanner.v1.PartialResultSet>(
                    service, METHODID_STREAMING_READ)))
        .addMethod(
            getBeginTransactionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.v1.BeginTransactionRequest,
                    com.google.spanner.v1.Transaction>(service, METHODID_BEGIN_TRANSACTION)))
        .addMethod(
            getCommitMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.v1.CommitRequest, com.google.spanner.v1.CommitResponse>(
                    service, METHODID_COMMIT)))
        .addMethod(
            getRollbackMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.v1.RollbackRequest, com.google.protobuf.Empty>(
                    service, METHODID_ROLLBACK)))
        .addMethod(
            getPartitionQueryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.v1.PartitionQueryRequest,
                    com.google.spanner.v1.PartitionResponse>(service, METHODID_PARTITION_QUERY)))
        .addMethod(
            getPartitionReadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.v1.PartitionReadRequest,
                    com.google.spanner.v1.PartitionResponse>(service, METHODID_PARTITION_READ)))
        .addMethod(
            getBatchWriteMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                new MethodHandlers<
                    com.google.spanner.v1.BatchWriteRequest,
                    com.google.spanner.v1.BatchWriteResponse>(service, METHODID_BATCH_WRITE)))
        .build();
  }

  private abstract static class SpannerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SpannerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.spanner.v1.SpannerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Spanner");
    }
  }

  private static final class SpannerFileDescriptorSupplier extends SpannerBaseDescriptorSupplier {
    SpannerFileDescriptorSupplier() {}
  }

  private static final class SpannerMethodDescriptorSupplier extends SpannerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SpannerMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SpannerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SpannerFileDescriptorSupplier())
                      .addMethod(getCreateSessionMethod())
                      .addMethod(getBatchCreateSessionsMethod())
                      .addMethod(getGetSessionMethod())
                      .addMethod(getListSessionsMethod())
                      .addMethod(getDeleteSessionMethod())
                      .addMethod(getExecuteSqlMethod())
                      .addMethod(getExecuteStreamingSqlMethod())
                      .addMethod(getExecuteBatchDmlMethod())
                      .addMethod(getReadMethod())
                      .addMethod(getStreamingReadMethod())
                      .addMethod(getBeginTransactionMethod())
                      .addMethod(getCommitMethod())
                      .addMethod(getRollbackMethod())
                      .addMethod(getPartitionQueryMethod())
                      .addMethod(getPartitionReadMethod())
                      .addMethod(getBatchWriteMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
