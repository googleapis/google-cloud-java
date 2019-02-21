package com.google.spanner.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * Cloud Spanner API
 * The Cloud Spanner API can be used to manage sessions and execute
 * transactions on data stored in Cloud Spanner databases.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/spanner/v1/spanner.proto")
public final class SpannerGrpc {

  private SpannerGrpc() {}

  public static final String SERVICE_NAME = "google.spanner.v1.Spanner";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateSessionMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.v1.CreateSessionRequest, com.google.spanner.v1.Session>
      METHOD_CREATE_SESSION = getCreateSessionMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.CreateSessionRequest, com.google.spanner.v1.Session>
      getCreateSessionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.CreateSessionRequest, com.google.spanner.v1.Session>
      getCreateSessionMethod() {
    return getCreateSessionMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.v1.CreateSessionRequest, com.google.spanner.v1.Session>
      getCreateSessionMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.spanner.v1.Spanner", "CreateSession"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetSessionMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.v1.GetSessionRequest, com.google.spanner.v1.Session>
      METHOD_GET_SESSION = getGetSessionMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.GetSessionRequest, com.google.spanner.v1.Session>
      getGetSessionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.GetSessionRequest, com.google.spanner.v1.Session>
      getGetSessionMethod() {
    return getGetSessionMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.v1.GetSessionRequest, com.google.spanner.v1.Session>
      getGetSessionMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.spanner.v1.Spanner", "GetSession"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListSessionsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.v1.ListSessionsRequest, com.google.spanner.v1.ListSessionsResponse>
      METHOD_LIST_SESSIONS = getListSessionsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.ListSessionsRequest, com.google.spanner.v1.ListSessionsResponse>
      getListSessionsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.ListSessionsRequest, com.google.spanner.v1.ListSessionsResponse>
      getListSessionsMethod() {
    return getListSessionsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.v1.ListSessionsRequest, com.google.spanner.v1.ListSessionsResponse>
      getListSessionsMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.spanner.v1.Spanner", "ListSessions"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteSessionMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.v1.DeleteSessionRequest, com.google.protobuf.Empty>
      METHOD_DELETE_SESSION = getDeleteSessionMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.DeleteSessionRequest, com.google.protobuf.Empty>
      getDeleteSessionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.DeleteSessionRequest, com.google.protobuf.Empty>
      getDeleteSessionMethod() {
    return getDeleteSessionMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.v1.DeleteSessionRequest, com.google.protobuf.Empty>
      getDeleteSessionMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.spanner.v1.Spanner", "DeleteSession"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getExecuteSqlMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.v1.ExecuteSqlRequest, com.google.spanner.v1.ResultSet>
      METHOD_EXECUTE_SQL = getExecuteSqlMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.ExecuteSqlRequest, com.google.spanner.v1.ResultSet>
      getExecuteSqlMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.ExecuteSqlRequest, com.google.spanner.v1.ResultSet>
      getExecuteSqlMethod() {
    return getExecuteSqlMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.v1.ExecuteSqlRequest, com.google.spanner.v1.ResultSet>
      getExecuteSqlMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.spanner.v1.Spanner", "ExecuteSql"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getExecuteStreamingSqlMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.v1.ExecuteSqlRequest, com.google.spanner.v1.PartialResultSet>
      METHOD_EXECUTE_STREAMING_SQL = getExecuteStreamingSqlMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.ExecuteSqlRequest, com.google.spanner.v1.PartialResultSet>
      getExecuteStreamingSqlMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.ExecuteSqlRequest, com.google.spanner.v1.PartialResultSet>
      getExecuteStreamingSqlMethod() {
    return getExecuteStreamingSqlMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.v1.ExecuteSqlRequest, com.google.spanner.v1.PartialResultSet>
      getExecuteStreamingSqlMethodHelper() {
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
                          generateFullMethodName(
                              "google.spanner.v1.Spanner", "ExecuteStreamingSql"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getExecuteBatchDmlMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.v1.ExecuteBatchDmlRequest,
          com.google.spanner.v1.ExecuteBatchDmlResponse>
      METHOD_EXECUTE_BATCH_DML = getExecuteBatchDmlMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.ExecuteBatchDmlRequest,
          com.google.spanner.v1.ExecuteBatchDmlResponse>
      getExecuteBatchDmlMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.ExecuteBatchDmlRequest,
          com.google.spanner.v1.ExecuteBatchDmlResponse>
      getExecuteBatchDmlMethod() {
    return getExecuteBatchDmlMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.v1.ExecuteBatchDmlRequest,
          com.google.spanner.v1.ExecuteBatchDmlResponse>
      getExecuteBatchDmlMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.spanner.v1.Spanner", "ExecuteBatchDml"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.v1.ReadRequest, com.google.spanner.v1.ResultSet>
      METHOD_READ = getReadMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.ReadRequest, com.google.spanner.v1.ResultSet>
      getReadMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.ReadRequest, com.google.spanner.v1.ResultSet>
      getReadMethod() {
    return getReadMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.v1.ReadRequest, com.google.spanner.v1.ResultSet>
      getReadMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.spanner.v1.Spanner", "Read"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getStreamingReadMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.v1.ReadRequest, com.google.spanner.v1.PartialResultSet>
      METHOD_STREAMING_READ = getStreamingReadMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.ReadRequest, com.google.spanner.v1.PartialResultSet>
      getStreamingReadMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.ReadRequest, com.google.spanner.v1.PartialResultSet>
      getStreamingReadMethod() {
    return getStreamingReadMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.v1.ReadRequest, com.google.spanner.v1.PartialResultSet>
      getStreamingReadMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.spanner.v1.Spanner", "StreamingRead"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBeginTransactionMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.v1.BeginTransactionRequest, com.google.spanner.v1.Transaction>
      METHOD_BEGIN_TRANSACTION = getBeginTransactionMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.BeginTransactionRequest, com.google.spanner.v1.Transaction>
      getBeginTransactionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.BeginTransactionRequest, com.google.spanner.v1.Transaction>
      getBeginTransactionMethod() {
    return getBeginTransactionMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.v1.BeginTransactionRequest, com.google.spanner.v1.Transaction>
      getBeginTransactionMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.spanner.v1.Spanner", "BeginTransaction"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCommitMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.v1.CommitRequest, com.google.spanner.v1.CommitResponse>
      METHOD_COMMIT = getCommitMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.CommitRequest, com.google.spanner.v1.CommitResponse>
      getCommitMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.CommitRequest, com.google.spanner.v1.CommitResponse>
      getCommitMethod() {
    return getCommitMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.v1.CommitRequest, com.google.spanner.v1.CommitResponse>
      getCommitMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.spanner.v1.Spanner", "Commit"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRollbackMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.v1.RollbackRequest, com.google.protobuf.Empty>
      METHOD_ROLLBACK = getRollbackMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.RollbackRequest, com.google.protobuf.Empty>
      getRollbackMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.RollbackRequest, com.google.protobuf.Empty>
      getRollbackMethod() {
    return getRollbackMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.v1.RollbackRequest, com.google.protobuf.Empty>
      getRollbackMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.spanner.v1.Spanner", "Rollback"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getPartitionQueryMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.v1.PartitionQueryRequest, com.google.spanner.v1.PartitionResponse>
      METHOD_PARTITION_QUERY = getPartitionQueryMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.PartitionQueryRequest, com.google.spanner.v1.PartitionResponse>
      getPartitionQueryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.PartitionQueryRequest, com.google.spanner.v1.PartitionResponse>
      getPartitionQueryMethod() {
    return getPartitionQueryMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.v1.PartitionQueryRequest, com.google.spanner.v1.PartitionResponse>
      getPartitionQueryMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.spanner.v1.Spanner", "PartitionQuery"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getPartitionReadMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.v1.PartitionReadRequest, com.google.spanner.v1.PartitionResponse>
      METHOD_PARTITION_READ = getPartitionReadMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.v1.PartitionReadRequest, com.google.spanner.v1.PartitionResponse>
      getPartitionReadMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.v1.PartitionReadRequest, com.google.spanner.v1.PartitionResponse>
      getPartitionReadMethod() {
    return getPartitionReadMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.v1.PartitionReadRequest, com.google.spanner.v1.PartitionResponse>
      getPartitionReadMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.spanner.v1.Spanner", "PartitionRead"))
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

  /** Creates a new async stub that supports all call types for the service */
  public static SpannerStub newStub(io.grpc.Channel channel) {
    return new SpannerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SpannerBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new SpannerBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SpannerFutureStub newFutureStub(io.grpc.Channel channel) {
    return new SpannerFutureStub(channel);
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
  public abstract static class SpannerImplBase implements io.grpc.BindableService {

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
     * Cloud Spanner limits the number of sessions that can exist at any given
     * time; thus, it is a good idea to delete idle and/or unneeded sessions.
     * Aside from explicit deletes, Cloud Spanner can delete sessions for which no
     * operations are sent for more than an hour. If a session is deleted,
     * requests to it return `NOT_FOUND`.
     * Idle sessions can be kept alive by sending a trivial SQL query
     * periodically, e.g., `"SELECT 1"`.
     * </pre>
     */
    public void createSession(
        com.google.spanner.v1.CreateSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.Session> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateSessionMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a session. Returns `NOT_FOUND` if the session does not exist.
     * This is mainly useful for determining whether a session is still
     * alive.
     * </pre>
     */
    public void getSession(
        com.google.spanner.v1.GetSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.Session> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSessionMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getListSessionsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Ends a session, releasing server resources associated with it. This will
     * asynchronously trigger cancellation of any operations that are running with
     * this session.
     * </pre>
     */
    public void deleteSession(
        com.google.spanner.v1.DeleteSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteSessionMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Executes an SQL statement, returning all results in a single reply. This
     * method cannot be used to return a result set larger than 10 MiB;
     * if the query yields more data than that, the query fails with
     * a `FAILED_PRECONDITION` error.
     * Operations inside read-write transactions might return `ABORTED`. If
     * this occurs, the application should restart the transaction from
     * the beginning. See [Transaction][google.spanner.v1.Transaction] for more details.
     * Larger result sets can be fetched in streaming fashion by calling
     * [ExecuteStreamingSql][google.spanner.v1.Spanner.ExecuteStreamingSql] instead.
     * </pre>
     */
    public void executeSql(
        com.google.spanner.v1.ExecuteSqlRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.ResultSet> responseObserver) {
      asyncUnimplementedUnaryCall(getExecuteSqlMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Like [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql], except returns the result
     * set as a stream. Unlike [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql], there
     * is no limit on the size of the returned result set. However, no
     * individual row in the result set can exceed 100 MiB, and no
     * column value can exceed 10 MiB.
     * </pre>
     */
    public void executeStreamingSql(
        com.google.spanner.v1.ExecuteSqlRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.PartialResultSet> responseObserver) {
      asyncUnimplementedUnaryCall(getExecuteStreamingSqlMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Executes a batch of SQL DML statements. This method allows many statements
     * to be run with lower latency than submitting them sequentially with
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql].
     * Statements are executed in order, sequentially.
     * [ExecuteBatchDmlResponse][Spanner.ExecuteBatchDmlResponse] will contain a
     * [ResultSet][google.spanner.v1.ResultSet] for each DML statement that has successfully executed. If a
     * statement fails, its error status will be returned as part of the
     * [ExecuteBatchDmlResponse][Spanner.ExecuteBatchDmlResponse]. Execution will
     * stop at the first failed statement; the remaining statements will not run.
     * ExecuteBatchDml is expected to return an OK status with a response even if
     * there was an error while processing one of the DML statements. Clients must
     * inspect response.status to determine if there were any errors while
     * processing the request.
     * See more details in
     * [ExecuteBatchDmlRequest][Spanner.ExecuteBatchDmlRequest] and
     * [ExecuteBatchDmlResponse][Spanner.ExecuteBatchDmlResponse].
     * </pre>
     */
    public void executeBatchDml(
        com.google.spanner.v1.ExecuteBatchDmlRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.ExecuteBatchDmlResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getExecuteBatchDmlMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reads rows from the database using key lookups and scans, as a
     * simple key/value style alternative to
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql].  This method cannot be used to
     * return a result set larger than 10 MiB; if the read matches more
     * data than that, the read fails with a `FAILED_PRECONDITION`
     * error.
     * Reads inside read-write transactions might return `ABORTED`. If
     * this occurs, the application should restart the transaction from
     * the beginning. See [Transaction][google.spanner.v1.Transaction] for more details.
     * Larger result sets can be yielded in streaming fashion by calling
     * [StreamingRead][google.spanner.v1.Spanner.StreamingRead] instead.
     * </pre>
     */
    public void read(
        com.google.spanner.v1.ReadRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.ResultSet> responseObserver) {
      asyncUnimplementedUnaryCall(getReadMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Like [Read][google.spanner.v1.Spanner.Read], except returns the result set as a
     * stream. Unlike [Read][google.spanner.v1.Spanner.Read], there is no limit on the
     * size of the returned result set. However, no individual row in
     * the result set can exceed 100 MiB, and no column value can exceed
     * 10 MiB.
     * </pre>
     */
    public void streamingRead(
        com.google.spanner.v1.ReadRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.PartialResultSet> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamingReadMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Begins a new transaction. This step can often be skipped:
     * [Read][google.spanner.v1.Spanner.Read], [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql] and
     * [Commit][google.spanner.v1.Spanner.Commit] can begin a new transaction as a
     * side-effect.
     * </pre>
     */
    public void beginTransaction(
        com.google.spanner.v1.BeginTransactionRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.Transaction> responseObserver) {
      asyncUnimplementedUnaryCall(getBeginTransactionMethodHelper(), responseObserver);
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
     * reasons. If `Commit` returns `ABORTED`, the caller should re-attempt
     * the transaction from the beginning, re-using the same session.
     * </pre>
     */
    public void commit(
        com.google.spanner.v1.CommitRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.CommitResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCommitMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a transaction, releasing any locks it holds. It is a good
     * idea to call this for any transaction that includes one or more
     * [Read][google.spanner.v1.Spanner.Read] or [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql] requests and
     * ultimately decides not to commit.
     * `Rollback` returns `OK` if it successfully aborts the transaction, the
     * transaction was already aborted, or the transaction is not
     * found. `Rollback` never returns `ABORTED`.
     * </pre>
     */
    public void rollback(
        com.google.spanner.v1.RollbackRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getRollbackMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a set of partition tokens that can be used to execute a query
     * operation in parallel.  Each of the returned partition tokens can be used
     * by [ExecuteStreamingSql][google.spanner.v1.Spanner.ExecuteStreamingSql] to specify a subset
     * of the query result to read.  The same session and read-only transaction
     * must be used by the PartitionQueryRequest used to create the
     * partition tokens and the ExecuteSqlRequests that use the partition tokens.
     * Partition tokens become invalid when the session used to create them
     * is deleted, is idle for too long, begins a new transaction, or becomes too
     * old.  When any of these happen, it is not possible to resume the query, and
     * the whole operation must be restarted from the beginning.
     * </pre>
     */
    public void partitionQuery(
        com.google.spanner.v1.PartitionQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.PartitionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPartitionQueryMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a set of partition tokens that can be used to execute a read
     * operation in parallel.  Each of the returned partition tokens can be used
     * by [StreamingRead][google.spanner.v1.Spanner.StreamingRead] to specify a subset of the read
     * result to read.  The same session and read-only transaction must be used by
     * the PartitionReadRequest used to create the partition tokens and the
     * ReadRequests that use the partition tokens.  There are no ordering
     * guarantees on rows returned among the returned partition tokens, or even
     * within each individual StreamingRead call issued with a partition_token.
     * Partition tokens become invalid when the session used to create them
     * is deleted, is idle for too long, begins a new transaction, or becomes too
     * old.  When any of these happen, it is not possible to resume the read, and
     * the whole operation must be restarted from the beginning.
     * </pre>
     */
    public void partitionRead(
        com.google.spanner.v1.PartitionReadRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.PartitionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPartitionReadMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateSessionMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.v1.CreateSessionRequest, com.google.spanner.v1.Session>(
                      this, METHODID_CREATE_SESSION)))
          .addMethod(
              getGetSessionMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.v1.GetSessionRequest, com.google.spanner.v1.Session>(
                      this, METHODID_GET_SESSION)))
          .addMethod(
              getListSessionsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.v1.ListSessionsRequest,
                      com.google.spanner.v1.ListSessionsResponse>(this, METHODID_LIST_SESSIONS)))
          .addMethod(
              getDeleteSessionMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.v1.DeleteSessionRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_SESSION)))
          .addMethod(
              getExecuteSqlMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.v1.ExecuteSqlRequest, com.google.spanner.v1.ResultSet>(
                      this, METHODID_EXECUTE_SQL)))
          .addMethod(
              getExecuteStreamingSqlMethodHelper(),
              asyncServerStreamingCall(
                  new MethodHandlers<
                      com.google.spanner.v1.ExecuteSqlRequest,
                      com.google.spanner.v1.PartialResultSet>(
                      this, METHODID_EXECUTE_STREAMING_SQL)))
          .addMethod(
              getExecuteBatchDmlMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.v1.ExecuteBatchDmlRequest,
                      com.google.spanner.v1.ExecuteBatchDmlResponse>(
                      this, METHODID_EXECUTE_BATCH_DML)))
          .addMethod(
              getReadMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.v1.ReadRequest, com.google.spanner.v1.ResultSet>(
                      this, METHODID_READ)))
          .addMethod(
              getStreamingReadMethodHelper(),
              asyncServerStreamingCall(
                  new MethodHandlers<
                      com.google.spanner.v1.ReadRequest, com.google.spanner.v1.PartialResultSet>(
                      this, METHODID_STREAMING_READ)))
          .addMethod(
              getBeginTransactionMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.v1.BeginTransactionRequest,
                      com.google.spanner.v1.Transaction>(this, METHODID_BEGIN_TRANSACTION)))
          .addMethod(
              getCommitMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.v1.CommitRequest, com.google.spanner.v1.CommitResponse>(
                      this, METHODID_COMMIT)))
          .addMethod(
              getRollbackMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.v1.RollbackRequest, com.google.protobuf.Empty>(
                      this, METHODID_ROLLBACK)))
          .addMethod(
              getPartitionQueryMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.v1.PartitionQueryRequest,
                      com.google.spanner.v1.PartitionResponse>(this, METHODID_PARTITION_QUERY)))
          .addMethod(
              getPartitionReadMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.v1.PartitionReadRequest,
                      com.google.spanner.v1.PartitionResponse>(this, METHODID_PARTITION_READ)))
          .build();
    }
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
  public static final class SpannerStub extends io.grpc.stub.AbstractStub<SpannerStub> {
    private SpannerStub(io.grpc.Channel channel) {
      super(channel);
    }

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
     * Cloud Spanner limits the number of sessions that can exist at any given
     * time; thus, it is a good idea to delete idle and/or unneeded sessions.
     * Aside from explicit deletes, Cloud Spanner can delete sessions for which no
     * operations are sent for more than an hour. If a session is deleted,
     * requests to it return `NOT_FOUND`.
     * Idle sessions can be kept alive by sending a trivial SQL query
     * periodically, e.g., `"SELECT 1"`.
     * </pre>
     */
    public void createSession(
        com.google.spanner.v1.CreateSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.Session> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateSessionMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a session. Returns `NOT_FOUND` if the session does not exist.
     * This is mainly useful for determining whether a session is still
     * alive.
     * </pre>
     */
    public void getSession(
        com.google.spanner.v1.GetSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.Session> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSessionMethodHelper(), getCallOptions()),
          request,
          responseObserver);
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
      asyncUnaryCall(
          getChannel().newCall(getListSessionsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Ends a session, releasing server resources associated with it. This will
     * asynchronously trigger cancellation of any operations that are running with
     * this session.
     * </pre>
     */
    public void deleteSession(
        com.google.spanner.v1.DeleteSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteSessionMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Executes an SQL statement, returning all results in a single reply. This
     * method cannot be used to return a result set larger than 10 MiB;
     * if the query yields more data than that, the query fails with
     * a `FAILED_PRECONDITION` error.
     * Operations inside read-write transactions might return `ABORTED`. If
     * this occurs, the application should restart the transaction from
     * the beginning. See [Transaction][google.spanner.v1.Transaction] for more details.
     * Larger result sets can be fetched in streaming fashion by calling
     * [ExecuteStreamingSql][google.spanner.v1.Spanner.ExecuteStreamingSql] instead.
     * </pre>
     */
    public void executeSql(
        com.google.spanner.v1.ExecuteSqlRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.ResultSet> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getExecuteSqlMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Like [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql], except returns the result
     * set as a stream. Unlike [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql], there
     * is no limit on the size of the returned result set. However, no
     * individual row in the result set can exceed 100 MiB, and no
     * column value can exceed 10 MiB.
     * </pre>
     */
    public void executeStreamingSql(
        com.google.spanner.v1.ExecuteSqlRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.PartialResultSet> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getExecuteStreamingSqlMethodHelper(), getCallOptions()),
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
     * Statements are executed in order, sequentially.
     * [ExecuteBatchDmlResponse][Spanner.ExecuteBatchDmlResponse] will contain a
     * [ResultSet][google.spanner.v1.ResultSet] for each DML statement that has successfully executed. If a
     * statement fails, its error status will be returned as part of the
     * [ExecuteBatchDmlResponse][Spanner.ExecuteBatchDmlResponse]. Execution will
     * stop at the first failed statement; the remaining statements will not run.
     * ExecuteBatchDml is expected to return an OK status with a response even if
     * there was an error while processing one of the DML statements. Clients must
     * inspect response.status to determine if there were any errors while
     * processing the request.
     * See more details in
     * [ExecuteBatchDmlRequest][Spanner.ExecuteBatchDmlRequest] and
     * [ExecuteBatchDmlResponse][Spanner.ExecuteBatchDmlResponse].
     * </pre>
     */
    public void executeBatchDml(
        com.google.spanner.v1.ExecuteBatchDmlRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.ExecuteBatchDmlResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getExecuteBatchDmlMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reads rows from the database using key lookups and scans, as a
     * simple key/value style alternative to
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql].  This method cannot be used to
     * return a result set larger than 10 MiB; if the read matches more
     * data than that, the read fails with a `FAILED_PRECONDITION`
     * error.
     * Reads inside read-write transactions might return `ABORTED`. If
     * this occurs, the application should restart the transaction from
     * the beginning. See [Transaction][google.spanner.v1.Transaction] for more details.
     * Larger result sets can be yielded in streaming fashion by calling
     * [StreamingRead][google.spanner.v1.Spanner.StreamingRead] instead.
     * </pre>
     */
    public void read(
        com.google.spanner.v1.ReadRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.ResultSet> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Like [Read][google.spanner.v1.Spanner.Read], except returns the result set as a
     * stream. Unlike [Read][google.spanner.v1.Spanner.Read], there is no limit on the
     * size of the returned result set. However, no individual row in
     * the result set can exceed 100 MiB, and no column value can exceed
     * 10 MiB.
     * </pre>
     */
    public void streamingRead(
        com.google.spanner.v1.ReadRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.PartialResultSet> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStreamingReadMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Begins a new transaction. This step can often be skipped:
     * [Read][google.spanner.v1.Spanner.Read], [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql] and
     * [Commit][google.spanner.v1.Spanner.Commit] can begin a new transaction as a
     * side-effect.
     * </pre>
     */
    public void beginTransaction(
        com.google.spanner.v1.BeginTransactionRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.Transaction> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBeginTransactionMethodHelper(), getCallOptions()),
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
     * reasons. If `Commit` returns `ABORTED`, the caller should re-attempt
     * the transaction from the beginning, re-using the same session.
     * </pre>
     */
    public void commit(
        com.google.spanner.v1.CommitRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.CommitResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCommitMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a transaction, releasing any locks it holds. It is a good
     * idea to call this for any transaction that includes one or more
     * [Read][google.spanner.v1.Spanner.Read] or [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql] requests and
     * ultimately decides not to commit.
     * `Rollback` returns `OK` if it successfully aborts the transaction, the
     * transaction was already aborted, or the transaction is not
     * found. `Rollback` never returns `ABORTED`.
     * </pre>
     */
    public void rollback(
        com.google.spanner.v1.RollbackRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRollbackMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a set of partition tokens that can be used to execute a query
     * operation in parallel.  Each of the returned partition tokens can be used
     * by [ExecuteStreamingSql][google.spanner.v1.Spanner.ExecuteStreamingSql] to specify a subset
     * of the query result to read.  The same session and read-only transaction
     * must be used by the PartitionQueryRequest used to create the
     * partition tokens and the ExecuteSqlRequests that use the partition tokens.
     * Partition tokens become invalid when the session used to create them
     * is deleted, is idle for too long, begins a new transaction, or becomes too
     * old.  When any of these happen, it is not possible to resume the query, and
     * the whole operation must be restarted from the beginning.
     * </pre>
     */
    public void partitionQuery(
        com.google.spanner.v1.PartitionQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.PartitionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPartitionQueryMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a set of partition tokens that can be used to execute a read
     * operation in parallel.  Each of the returned partition tokens can be used
     * by [StreamingRead][google.spanner.v1.Spanner.StreamingRead] to specify a subset of the read
     * result to read.  The same session and read-only transaction must be used by
     * the PartitionReadRequest used to create the partition tokens and the
     * ReadRequests that use the partition tokens.  There are no ordering
     * guarantees on rows returned among the returned partition tokens, or even
     * within each individual StreamingRead call issued with a partition_token.
     * Partition tokens become invalid when the session used to create them
     * is deleted, is idle for too long, begins a new transaction, or becomes too
     * old.  When any of these happen, it is not possible to resume the read, and
     * the whole operation must be restarted from the beginning.
     * </pre>
     */
    public void partitionRead(
        com.google.spanner.v1.PartitionReadRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.v1.PartitionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPartitionReadMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
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
  public static final class SpannerBlockingStub
      extends io.grpc.stub.AbstractStub<SpannerBlockingStub> {
    private SpannerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

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
     * Cloud Spanner limits the number of sessions that can exist at any given
     * time; thus, it is a good idea to delete idle and/or unneeded sessions.
     * Aside from explicit deletes, Cloud Spanner can delete sessions for which no
     * operations are sent for more than an hour. If a session is deleted,
     * requests to it return `NOT_FOUND`.
     * Idle sessions can be kept alive by sending a trivial SQL query
     * periodically, e.g., `"SELECT 1"`.
     * </pre>
     */
    public com.google.spanner.v1.Session createSession(
        com.google.spanner.v1.CreateSessionRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateSessionMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a session. Returns `NOT_FOUND` if the session does not exist.
     * This is mainly useful for determining whether a session is still
     * alive.
     * </pre>
     */
    public com.google.spanner.v1.Session getSession(
        com.google.spanner.v1.GetSessionRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetSessionMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getListSessionsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Ends a session, releasing server resources associated with it. This will
     * asynchronously trigger cancellation of any operations that are running with
     * this session.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSession(
        com.google.spanner.v1.DeleteSessionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteSessionMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Executes an SQL statement, returning all results in a single reply. This
     * method cannot be used to return a result set larger than 10 MiB;
     * if the query yields more data than that, the query fails with
     * a `FAILED_PRECONDITION` error.
     * Operations inside read-write transactions might return `ABORTED`. If
     * this occurs, the application should restart the transaction from
     * the beginning. See [Transaction][google.spanner.v1.Transaction] for more details.
     * Larger result sets can be fetched in streaming fashion by calling
     * [ExecuteStreamingSql][google.spanner.v1.Spanner.ExecuteStreamingSql] instead.
     * </pre>
     */
    public com.google.spanner.v1.ResultSet executeSql(
        com.google.spanner.v1.ExecuteSqlRequest request) {
      return blockingUnaryCall(
          getChannel(), getExecuteSqlMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Like [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql], except returns the result
     * set as a stream. Unlike [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql], there
     * is no limit on the size of the returned result set. However, no
     * individual row in the result set can exceed 100 MiB, and no
     * column value can exceed 10 MiB.
     * </pre>
     */
    public java.util.Iterator<com.google.spanner.v1.PartialResultSet> executeStreamingSql(
        com.google.spanner.v1.ExecuteSqlRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getExecuteStreamingSqlMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Executes a batch of SQL DML statements. This method allows many statements
     * to be run with lower latency than submitting them sequentially with
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql].
     * Statements are executed in order, sequentially.
     * [ExecuteBatchDmlResponse][Spanner.ExecuteBatchDmlResponse] will contain a
     * [ResultSet][google.spanner.v1.ResultSet] for each DML statement that has successfully executed. If a
     * statement fails, its error status will be returned as part of the
     * [ExecuteBatchDmlResponse][Spanner.ExecuteBatchDmlResponse]. Execution will
     * stop at the first failed statement; the remaining statements will not run.
     * ExecuteBatchDml is expected to return an OK status with a response even if
     * there was an error while processing one of the DML statements. Clients must
     * inspect response.status to determine if there were any errors while
     * processing the request.
     * See more details in
     * [ExecuteBatchDmlRequest][Spanner.ExecuteBatchDmlRequest] and
     * [ExecuteBatchDmlResponse][Spanner.ExecuteBatchDmlResponse].
     * </pre>
     */
    public com.google.spanner.v1.ExecuteBatchDmlResponse executeBatchDml(
        com.google.spanner.v1.ExecuteBatchDmlRequest request) {
      return blockingUnaryCall(
          getChannel(), getExecuteBatchDmlMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reads rows from the database using key lookups and scans, as a
     * simple key/value style alternative to
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql].  This method cannot be used to
     * return a result set larger than 10 MiB; if the read matches more
     * data than that, the read fails with a `FAILED_PRECONDITION`
     * error.
     * Reads inside read-write transactions might return `ABORTED`. If
     * this occurs, the application should restart the transaction from
     * the beginning. See [Transaction][google.spanner.v1.Transaction] for more details.
     * Larger result sets can be yielded in streaming fashion by calling
     * [StreamingRead][google.spanner.v1.Spanner.StreamingRead] instead.
     * </pre>
     */
    public com.google.spanner.v1.ResultSet read(com.google.spanner.v1.ReadRequest request) {
      return blockingUnaryCall(getChannel(), getReadMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Like [Read][google.spanner.v1.Spanner.Read], except returns the result set as a
     * stream. Unlike [Read][google.spanner.v1.Spanner.Read], there is no limit on the
     * size of the returned result set. However, no individual row in
     * the result set can exceed 100 MiB, and no column value can exceed
     * 10 MiB.
     * </pre>
     */
    public java.util.Iterator<com.google.spanner.v1.PartialResultSet> streamingRead(
        com.google.spanner.v1.ReadRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getStreamingReadMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Begins a new transaction. This step can often be skipped:
     * [Read][google.spanner.v1.Spanner.Read], [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql] and
     * [Commit][google.spanner.v1.Spanner.Commit] can begin a new transaction as a
     * side-effect.
     * </pre>
     */
    public com.google.spanner.v1.Transaction beginTransaction(
        com.google.spanner.v1.BeginTransactionRequest request) {
      return blockingUnaryCall(
          getChannel(), getBeginTransactionMethodHelper(), getCallOptions(), request);
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
     * reasons. If `Commit` returns `ABORTED`, the caller should re-attempt
     * the transaction from the beginning, re-using the same session.
     * </pre>
     */
    public com.google.spanner.v1.CommitResponse commit(
        com.google.spanner.v1.CommitRequest request) {
      return blockingUnaryCall(getChannel(), getCommitMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a transaction, releasing any locks it holds. It is a good
     * idea to call this for any transaction that includes one or more
     * [Read][google.spanner.v1.Spanner.Read] or [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql] requests and
     * ultimately decides not to commit.
     * `Rollback` returns `OK` if it successfully aborts the transaction, the
     * transaction was already aborted, or the transaction is not
     * found. `Rollback` never returns `ABORTED`.
     * </pre>
     */
    public com.google.protobuf.Empty rollback(com.google.spanner.v1.RollbackRequest request) {
      return blockingUnaryCall(getChannel(), getRollbackMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a set of partition tokens that can be used to execute a query
     * operation in parallel.  Each of the returned partition tokens can be used
     * by [ExecuteStreamingSql][google.spanner.v1.Spanner.ExecuteStreamingSql] to specify a subset
     * of the query result to read.  The same session and read-only transaction
     * must be used by the PartitionQueryRequest used to create the
     * partition tokens and the ExecuteSqlRequests that use the partition tokens.
     * Partition tokens become invalid when the session used to create them
     * is deleted, is idle for too long, begins a new transaction, or becomes too
     * old.  When any of these happen, it is not possible to resume the query, and
     * the whole operation must be restarted from the beginning.
     * </pre>
     */
    public com.google.spanner.v1.PartitionResponse partitionQuery(
        com.google.spanner.v1.PartitionQueryRequest request) {
      return blockingUnaryCall(
          getChannel(), getPartitionQueryMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a set of partition tokens that can be used to execute a read
     * operation in parallel.  Each of the returned partition tokens can be used
     * by [StreamingRead][google.spanner.v1.Spanner.StreamingRead] to specify a subset of the read
     * result to read.  The same session and read-only transaction must be used by
     * the PartitionReadRequest used to create the partition tokens and the
     * ReadRequests that use the partition tokens.  There are no ordering
     * guarantees on rows returned among the returned partition tokens, or even
     * within each individual StreamingRead call issued with a partition_token.
     * Partition tokens become invalid when the session used to create them
     * is deleted, is idle for too long, begins a new transaction, or becomes too
     * old.  When any of these happen, it is not possible to resume the read, and
     * the whole operation must be restarted from the beginning.
     * </pre>
     */
    public com.google.spanner.v1.PartitionResponse partitionRead(
        com.google.spanner.v1.PartitionReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getPartitionReadMethodHelper(), getCallOptions(), request);
    }
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
  public static final class SpannerFutureStub extends io.grpc.stub.AbstractStub<SpannerFutureStub> {
    private SpannerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

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
     * Cloud Spanner limits the number of sessions that can exist at any given
     * time; thus, it is a good idea to delete idle and/or unneeded sessions.
     * Aside from explicit deletes, Cloud Spanner can delete sessions for which no
     * operations are sent for more than an hour. If a session is deleted,
     * requests to it return `NOT_FOUND`.
     * Idle sessions can be kept alive by sending a trivial SQL query
     * periodically, e.g., `"SELECT 1"`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.spanner.v1.Session>
        createSession(com.google.spanner.v1.CreateSessionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateSessionMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a session. Returns `NOT_FOUND` if the session does not exist.
     * This is mainly useful for determining whether a session is still
     * alive.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.spanner.v1.Session>
        getSession(com.google.spanner.v1.GetSessionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetSessionMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getListSessionsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Ends a session, releasing server resources associated with it. This will
     * asynchronously trigger cancellation of any operations that are running with
     * this session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSession(com.google.spanner.v1.DeleteSessionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteSessionMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Executes an SQL statement, returning all results in a single reply. This
     * method cannot be used to return a result set larger than 10 MiB;
     * if the query yields more data than that, the query fails with
     * a `FAILED_PRECONDITION` error.
     * Operations inside read-write transactions might return `ABORTED`. If
     * this occurs, the application should restart the transaction from
     * the beginning. See [Transaction][google.spanner.v1.Transaction] for more details.
     * Larger result sets can be fetched in streaming fashion by calling
     * [ExecuteStreamingSql][google.spanner.v1.Spanner.ExecuteStreamingSql] instead.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.spanner.v1.ResultSet>
        executeSql(com.google.spanner.v1.ExecuteSqlRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getExecuteSqlMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Executes a batch of SQL DML statements. This method allows many statements
     * to be run with lower latency than submitting them sequentially with
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql].
     * Statements are executed in order, sequentially.
     * [ExecuteBatchDmlResponse][Spanner.ExecuteBatchDmlResponse] will contain a
     * [ResultSet][google.spanner.v1.ResultSet] for each DML statement that has successfully executed. If a
     * statement fails, its error status will be returned as part of the
     * [ExecuteBatchDmlResponse][Spanner.ExecuteBatchDmlResponse]. Execution will
     * stop at the first failed statement; the remaining statements will not run.
     * ExecuteBatchDml is expected to return an OK status with a response even if
     * there was an error while processing one of the DML statements. Clients must
     * inspect response.status to determine if there were any errors while
     * processing the request.
     * See more details in
     * [ExecuteBatchDmlRequest][Spanner.ExecuteBatchDmlRequest] and
     * [ExecuteBatchDmlResponse][Spanner.ExecuteBatchDmlResponse].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.v1.ExecuteBatchDmlResponse>
        executeBatchDml(com.google.spanner.v1.ExecuteBatchDmlRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getExecuteBatchDmlMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Reads rows from the database using key lookups and scans, as a
     * simple key/value style alternative to
     * [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql].  This method cannot be used to
     * return a result set larger than 10 MiB; if the read matches more
     * data than that, the read fails with a `FAILED_PRECONDITION`
     * error.
     * Reads inside read-write transactions might return `ABORTED`. If
     * this occurs, the application should restart the transaction from
     * the beginning. See [Transaction][google.spanner.v1.Transaction] for more details.
     * Larger result sets can be yielded in streaming fashion by calling
     * [StreamingRead][google.spanner.v1.Spanner.StreamingRead] instead.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.spanner.v1.ResultSet> read(
        com.google.spanner.v1.ReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Begins a new transaction. This step can often be skipped:
     * [Read][google.spanner.v1.Spanner.Read], [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql] and
     * [Commit][google.spanner.v1.Spanner.Commit] can begin a new transaction as a
     * side-effect.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.spanner.v1.Transaction>
        beginTransaction(com.google.spanner.v1.BeginTransactionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBeginTransactionMethodHelper(), getCallOptions()), request);
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
     * reasons. If `Commit` returns `ABORTED`, the caller should re-attempt
     * the transaction from the beginning, re-using the same session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.spanner.v1.CommitResponse>
        commit(com.google.spanner.v1.CommitRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCommitMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a transaction, releasing any locks it holds. It is a good
     * idea to call this for any transaction that includes one or more
     * [Read][google.spanner.v1.Spanner.Read] or [ExecuteSql][google.spanner.v1.Spanner.ExecuteSql] requests and
     * ultimately decides not to commit.
     * `Rollback` returns `OK` if it successfully aborts the transaction, the
     * transaction was already aborted, or the transaction is not
     * found. `Rollback` never returns `ABORTED`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> rollback(
        com.google.spanner.v1.RollbackRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRollbackMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a set of partition tokens that can be used to execute a query
     * operation in parallel.  Each of the returned partition tokens can be used
     * by [ExecuteStreamingSql][google.spanner.v1.Spanner.ExecuteStreamingSql] to specify a subset
     * of the query result to read.  The same session and read-only transaction
     * must be used by the PartitionQueryRequest used to create the
     * partition tokens and the ExecuteSqlRequests that use the partition tokens.
     * Partition tokens become invalid when the session used to create them
     * is deleted, is idle for too long, begins a new transaction, or becomes too
     * old.  When any of these happen, it is not possible to resume the query, and
     * the whole operation must be restarted from the beginning.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.v1.PartitionResponse>
        partitionQuery(com.google.spanner.v1.PartitionQueryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPartitionQueryMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a set of partition tokens that can be used to execute a read
     * operation in parallel.  Each of the returned partition tokens can be used
     * by [StreamingRead][google.spanner.v1.Spanner.StreamingRead] to specify a subset of the read
     * result to read.  The same session and read-only transaction must be used by
     * the PartitionReadRequest used to create the partition tokens and the
     * ReadRequests that use the partition tokens.  There are no ordering
     * guarantees on rows returned among the returned partition tokens, or even
     * within each individual StreamingRead call issued with a partition_token.
     * Partition tokens become invalid when the session used to create them
     * is deleted, is idle for too long, begins a new transaction, or becomes too
     * old.  When any of these happen, it is not possible to resume the read, and
     * the whole operation must be restarted from the beginning.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.v1.PartitionResponse>
        partitionRead(com.google.spanner.v1.PartitionReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPartitionReadMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SESSION = 0;
  private static final int METHODID_GET_SESSION = 1;
  private static final int METHODID_LIST_SESSIONS = 2;
  private static final int METHODID_DELETE_SESSION = 3;
  private static final int METHODID_EXECUTE_SQL = 4;
  private static final int METHODID_EXECUTE_STREAMING_SQL = 5;
  private static final int METHODID_EXECUTE_BATCH_DML = 6;
  private static final int METHODID_READ = 7;
  private static final int METHODID_STREAMING_READ = 8;
  private static final int METHODID_BEGIN_TRANSACTION = 9;
  private static final int METHODID_COMMIT = 10;
  private static final int METHODID_ROLLBACK = 11;
  private static final int METHODID_PARTITION_QUERY = 12;
  private static final int METHODID_PARTITION_READ = 13;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SpannerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SpannerImplBase serviceImpl, int methodId) {
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
    private final String methodName;

    SpannerMethodDescriptorSupplier(String methodName) {
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
                      .addMethod(getCreateSessionMethodHelper())
                      .addMethod(getGetSessionMethodHelper())
                      .addMethod(getListSessionsMethodHelper())
                      .addMethod(getDeleteSessionMethodHelper())
                      .addMethod(getExecuteSqlMethodHelper())
                      .addMethod(getExecuteStreamingSqlMethodHelper())
                      .addMethod(getExecuteBatchDmlMethodHelper())
                      .addMethod(getReadMethodHelper())
                      .addMethod(getStreamingReadMethodHelper())
                      .addMethod(getBeginTransactionMethodHelper())
                      .addMethod(getCommitMethodHelper())
                      .addMethod(getRollbackMethodHelper())
                      .addMethod(getPartitionQueryMethodHelper())
                      .addMethod(getPartitionReadMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
