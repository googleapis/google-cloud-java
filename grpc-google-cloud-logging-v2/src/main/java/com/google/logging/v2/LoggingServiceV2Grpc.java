/*
 * Copyright 2020 Google LLC
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
package com.google.logging.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * Service for ingesting and querying logs.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/logging/v2/logging.proto")
public final class LoggingServiceV2Grpc {

  private LoggingServiceV2Grpc() {}

  public static final String SERVICE_NAME = "google.logging.v2.LoggingServiceV2";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.DeleteLogRequest, com.google.protobuf.Empty>
      getDeleteLogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteLog",
      requestType = com.google.logging.v2.DeleteLogRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.DeleteLogRequest, com.google.protobuf.Empty>
      getDeleteLogMethod() {
    io.grpc.MethodDescriptor<com.google.logging.v2.DeleteLogRequest, com.google.protobuf.Empty>
        getDeleteLogMethod;
    if ((getDeleteLogMethod = LoggingServiceV2Grpc.getDeleteLogMethod) == null) {
      synchronized (LoggingServiceV2Grpc.class) {
        if ((getDeleteLogMethod = LoggingServiceV2Grpc.getDeleteLogMethod) == null) {
          LoggingServiceV2Grpc.getDeleteLogMethod =
              getDeleteLogMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.DeleteLogRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteLog"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.DeleteLogRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LoggingServiceV2MethodDescriptorSupplier("DeleteLog"))
                      .build();
        }
      }
    }
    return getDeleteLogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.WriteLogEntriesRequest,
          com.google.logging.v2.WriteLogEntriesResponse>
      getWriteLogEntriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WriteLogEntries",
      requestType = com.google.logging.v2.WriteLogEntriesRequest.class,
      responseType = com.google.logging.v2.WriteLogEntriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.WriteLogEntriesRequest,
          com.google.logging.v2.WriteLogEntriesResponse>
      getWriteLogEntriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.WriteLogEntriesRequest,
            com.google.logging.v2.WriteLogEntriesResponse>
        getWriteLogEntriesMethod;
    if ((getWriteLogEntriesMethod = LoggingServiceV2Grpc.getWriteLogEntriesMethod) == null) {
      synchronized (LoggingServiceV2Grpc.class) {
        if ((getWriteLogEntriesMethod = LoggingServiceV2Grpc.getWriteLogEntriesMethod) == null) {
          LoggingServiceV2Grpc.getWriteLogEntriesMethod =
              getWriteLogEntriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.WriteLogEntriesRequest,
                          com.google.logging.v2.WriteLogEntriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WriteLogEntries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.WriteLogEntriesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.WriteLogEntriesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LoggingServiceV2MethodDescriptorSupplier("WriteLogEntries"))
                      .build();
        }
      }
    }
    return getWriteLogEntriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.ListLogEntriesRequest, com.google.logging.v2.ListLogEntriesResponse>
      getListLogEntriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListLogEntries",
      requestType = com.google.logging.v2.ListLogEntriesRequest.class,
      responseType = com.google.logging.v2.ListLogEntriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.ListLogEntriesRequest, com.google.logging.v2.ListLogEntriesResponse>
      getListLogEntriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.ListLogEntriesRequest,
            com.google.logging.v2.ListLogEntriesResponse>
        getListLogEntriesMethod;
    if ((getListLogEntriesMethod = LoggingServiceV2Grpc.getListLogEntriesMethod) == null) {
      synchronized (LoggingServiceV2Grpc.class) {
        if ((getListLogEntriesMethod = LoggingServiceV2Grpc.getListLogEntriesMethod) == null) {
          LoggingServiceV2Grpc.getListLogEntriesMethod =
              getListLogEntriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.ListLogEntriesRequest,
                          com.google.logging.v2.ListLogEntriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListLogEntries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.ListLogEntriesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.ListLogEntriesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LoggingServiceV2MethodDescriptorSupplier("ListLogEntries"))
                      .build();
        }
      }
    }
    return getListLogEntriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.ListMonitoredResourceDescriptorsRequest,
          com.google.logging.v2.ListMonitoredResourceDescriptorsResponse>
      getListMonitoredResourceDescriptorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMonitoredResourceDescriptors",
      requestType = com.google.logging.v2.ListMonitoredResourceDescriptorsRequest.class,
      responseType = com.google.logging.v2.ListMonitoredResourceDescriptorsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.ListMonitoredResourceDescriptorsRequest,
          com.google.logging.v2.ListMonitoredResourceDescriptorsResponse>
      getListMonitoredResourceDescriptorsMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.ListMonitoredResourceDescriptorsRequest,
            com.google.logging.v2.ListMonitoredResourceDescriptorsResponse>
        getListMonitoredResourceDescriptorsMethod;
    if ((getListMonitoredResourceDescriptorsMethod =
            LoggingServiceV2Grpc.getListMonitoredResourceDescriptorsMethod)
        == null) {
      synchronized (LoggingServiceV2Grpc.class) {
        if ((getListMonitoredResourceDescriptorsMethod =
                LoggingServiceV2Grpc.getListMonitoredResourceDescriptorsMethod)
            == null) {
          LoggingServiceV2Grpc.getListMonitoredResourceDescriptorsMethod =
              getListMonitoredResourceDescriptorsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.ListMonitoredResourceDescriptorsRequest,
                          com.google.logging.v2.ListMonitoredResourceDescriptorsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListMonitoredResourceDescriptors"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.ListMonitoredResourceDescriptorsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.ListMonitoredResourceDescriptorsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LoggingServiceV2MethodDescriptorSupplier(
                              "ListMonitoredResourceDescriptors"))
                      .build();
        }
      }
    }
    return getListMonitoredResourceDescriptorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.ListLogsRequest, com.google.logging.v2.ListLogsResponse>
      getListLogsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListLogs",
      requestType = com.google.logging.v2.ListLogsRequest.class,
      responseType = com.google.logging.v2.ListLogsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.ListLogsRequest, com.google.logging.v2.ListLogsResponse>
      getListLogsMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.ListLogsRequest, com.google.logging.v2.ListLogsResponse>
        getListLogsMethod;
    if ((getListLogsMethod = LoggingServiceV2Grpc.getListLogsMethod) == null) {
      synchronized (LoggingServiceV2Grpc.class) {
        if ((getListLogsMethod = LoggingServiceV2Grpc.getListLogsMethod) == null) {
          LoggingServiceV2Grpc.getListLogsMethod =
              getListLogsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.ListLogsRequest,
                          com.google.logging.v2.ListLogsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListLogs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.ListLogsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.ListLogsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new LoggingServiceV2MethodDescriptorSupplier("ListLogs"))
                      .build();
        }
      }
    }
    return getListLogsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.TailLogEntriesRequest, com.google.logging.v2.TailLogEntriesResponse>
      getTailLogEntriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TailLogEntries",
      requestType = com.google.logging.v2.TailLogEntriesRequest.class,
      responseType = com.google.logging.v2.TailLogEntriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.TailLogEntriesRequest, com.google.logging.v2.TailLogEntriesResponse>
      getTailLogEntriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.TailLogEntriesRequest,
            com.google.logging.v2.TailLogEntriesResponse>
        getTailLogEntriesMethod;
    if ((getTailLogEntriesMethod = LoggingServiceV2Grpc.getTailLogEntriesMethod) == null) {
      synchronized (LoggingServiceV2Grpc.class) {
        if ((getTailLogEntriesMethod = LoggingServiceV2Grpc.getTailLogEntriesMethod) == null) {
          LoggingServiceV2Grpc.getTailLogEntriesMethod =
              getTailLogEntriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.TailLogEntriesRequest,
                          com.google.logging.v2.TailLogEntriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TailLogEntries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.TailLogEntriesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.TailLogEntriesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LoggingServiceV2MethodDescriptorSupplier("TailLogEntries"))
                      .build();
        }
      }
    }
    return getTailLogEntriesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static LoggingServiceV2Stub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LoggingServiceV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LoggingServiceV2Stub>() {
          @java.lang.Override
          public LoggingServiceV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LoggingServiceV2Stub(channel, callOptions);
          }
        };
    return LoggingServiceV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LoggingServiceV2BlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LoggingServiceV2BlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LoggingServiceV2BlockingStub>() {
          @java.lang.Override
          public LoggingServiceV2BlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LoggingServiceV2BlockingStub(channel, callOptions);
          }
        };
    return LoggingServiceV2BlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static LoggingServiceV2FutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LoggingServiceV2FutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LoggingServiceV2FutureStub>() {
          @java.lang.Override
          public LoggingServiceV2FutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LoggingServiceV2FutureStub(channel, callOptions);
          }
        };
    return LoggingServiceV2FutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for ingesting and querying logs.
   * </pre>
   */
  public abstract static class LoggingServiceV2ImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Deletes all the log entries in a log. The log reappears if it receives new
     * entries. Log entries written shortly before the delete operation might not
     * be deleted. Entries received after the delete operation with a timestamp
     * before the operation will be deleted.
     * </pre>
     */
    public void deleteLog(
        com.google.logging.v2.DeleteLogRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteLogMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Writes log entries to Logging. This API method is the
     * only way to send log entries to Logging. This method
     * is used, directly or indirectly, by the Logging agent
     * (fluentd) and all logging libraries configured to use Logging.
     * A single request may contain log entries for a maximum of 1000
     * different resources (projects, organizations, billing accounts or
     * folders)
     * </pre>
     */
    public void writeLogEntries(
        com.google.logging.v2.WriteLogEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.WriteLogEntriesResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getWriteLogEntriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists log entries.  Use this method to retrieve log entries that originated
     * from a project/folder/organization/billing account.  For ways to export log
     * entries, see [Exporting
     * Logs](https://cloud.google.com/logging/docs/export).
     * </pre>
     */
    public void listLogEntries(
        com.google.logging.v2.ListLogEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListLogEntriesResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListLogEntriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the descriptors for monitored resource types used by Logging.
     * </pre>
     */
    public void listMonitoredResourceDescriptors(
        com.google.logging.v2.ListMonitoredResourceDescriptorsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListMonitoredResourceDescriptorsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListMonitoredResourceDescriptorsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the logs in projects, organizations, folders, or billing accounts.
     * Only logs that have entries are listed.
     * </pre>
     */
    public void listLogs(
        com.google.logging.v2.ListLogsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListLogsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListLogsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Streaming read of log entries as they are ingested. Until the stream is
     * terminated, it will continue reading logs.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.logging.v2.TailLogEntriesRequest> tailLogEntries(
        io.grpc.stub.StreamObserver<com.google.logging.v2.TailLogEntriesResponse>
            responseObserver) {
      return asyncUnimplementedStreamingCall(getTailLogEntriesMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getDeleteLogMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.logging.v2.DeleteLogRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_LOG)))
          .addMethod(
              getWriteLogEntriesMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.logging.v2.WriteLogEntriesRequest,
                      com.google.logging.v2.WriteLogEntriesResponse>(
                      this, METHODID_WRITE_LOG_ENTRIES)))
          .addMethod(
              getListLogEntriesMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.logging.v2.ListLogEntriesRequest,
                      com.google.logging.v2.ListLogEntriesResponse>(
                      this, METHODID_LIST_LOG_ENTRIES)))
          .addMethod(
              getListMonitoredResourceDescriptorsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.logging.v2.ListMonitoredResourceDescriptorsRequest,
                      com.google.logging.v2.ListMonitoredResourceDescriptorsResponse>(
                      this, METHODID_LIST_MONITORED_RESOURCE_DESCRIPTORS)))
          .addMethod(
              getListLogsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.logging.v2.ListLogsRequest,
                      com.google.logging.v2.ListLogsResponse>(this, METHODID_LIST_LOGS)))
          .addMethod(
              getTailLogEntriesMethod(),
              asyncBidiStreamingCall(
                  new MethodHandlers<
                      com.google.logging.v2.TailLogEntriesRequest,
                      com.google.logging.v2.TailLogEntriesResponse>(
                      this, METHODID_TAIL_LOG_ENTRIES)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for ingesting and querying logs.
   * </pre>
   */
  public static final class LoggingServiceV2Stub
      extends io.grpc.stub.AbstractAsyncStub<LoggingServiceV2Stub> {
    private LoggingServiceV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoggingServiceV2Stub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LoggingServiceV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deletes all the log entries in a log. The log reappears if it receives new
     * entries. Log entries written shortly before the delete operation might not
     * be deleted. Entries received after the delete operation with a timestamp
     * before the operation will be deleted.
     * </pre>
     */
    public void deleteLog(
        com.google.logging.v2.DeleteLogRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteLogMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Writes log entries to Logging. This API method is the
     * only way to send log entries to Logging. This method
     * is used, directly or indirectly, by the Logging agent
     * (fluentd) and all logging libraries configured to use Logging.
     * A single request may contain log entries for a maximum of 1000
     * different resources (projects, organizations, billing accounts or
     * folders)
     * </pre>
     */
    public void writeLogEntries(
        com.google.logging.v2.WriteLogEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.WriteLogEntriesResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteLogEntriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists log entries.  Use this method to retrieve log entries that originated
     * from a project/folder/organization/billing account.  For ways to export log
     * entries, see [Exporting
     * Logs](https://cloud.google.com/logging/docs/export).
     * </pre>
     */
    public void listLogEntries(
        com.google.logging.v2.ListLogEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListLogEntriesResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListLogEntriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the descriptors for monitored resource types used by Logging.
     * </pre>
     */
    public void listMonitoredResourceDescriptors(
        com.google.logging.v2.ListMonitoredResourceDescriptorsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListMonitoredResourceDescriptorsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListMonitoredResourceDescriptorsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the logs in projects, organizations, folders, or billing accounts.
     * Only logs that have entries are listed.
     * </pre>
     */
    public void listLogs(
        com.google.logging.v2.ListLogsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListLogsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListLogsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Streaming read of log entries as they are ingested. Until the stream is
     * terminated, it will continue reading logs.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.logging.v2.TailLogEntriesRequest> tailLogEntries(
        io.grpc.stub.StreamObserver<com.google.logging.v2.TailLogEntriesResponse>
            responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getTailLogEntriesMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for ingesting and querying logs.
   * </pre>
   */
  public static final class LoggingServiceV2BlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LoggingServiceV2BlockingStub> {
    private LoggingServiceV2BlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoggingServiceV2BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LoggingServiceV2BlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deletes all the log entries in a log. The log reappears if it receives new
     * entries. Log entries written shortly before the delete operation might not
     * be deleted. Entries received after the delete operation with a timestamp
     * before the operation will be deleted.
     * </pre>
     */
    public com.google.protobuf.Empty deleteLog(com.google.logging.v2.DeleteLogRequest request) {
      return blockingUnaryCall(getChannel(), getDeleteLogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Writes log entries to Logging. This API method is the
     * only way to send log entries to Logging. This method
     * is used, directly or indirectly, by the Logging agent
     * (fluentd) and all logging libraries configured to use Logging.
     * A single request may contain log entries for a maximum of 1000
     * different resources (projects, organizations, billing accounts or
     * folders)
     * </pre>
     */
    public com.google.logging.v2.WriteLogEntriesResponse writeLogEntries(
        com.google.logging.v2.WriteLogEntriesRequest request) {
      return blockingUnaryCall(getChannel(), getWriteLogEntriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists log entries.  Use this method to retrieve log entries that originated
     * from a project/folder/organization/billing account.  For ways to export log
     * entries, see [Exporting
     * Logs](https://cloud.google.com/logging/docs/export).
     * </pre>
     */
    public com.google.logging.v2.ListLogEntriesResponse listLogEntries(
        com.google.logging.v2.ListLogEntriesRequest request) {
      return blockingUnaryCall(getChannel(), getListLogEntriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the descriptors for monitored resource types used by Logging.
     * </pre>
     */
    public com.google.logging.v2.ListMonitoredResourceDescriptorsResponse
        listMonitoredResourceDescriptors(
            com.google.logging.v2.ListMonitoredResourceDescriptorsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListMonitoredResourceDescriptorsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the logs in projects, organizations, folders, or billing accounts.
     * Only logs that have entries are listed.
     * </pre>
     */
    public com.google.logging.v2.ListLogsResponse listLogs(
        com.google.logging.v2.ListLogsRequest request) {
      return blockingUnaryCall(getChannel(), getListLogsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for ingesting and querying logs.
   * </pre>
   */
  public static final class LoggingServiceV2FutureStub
      extends io.grpc.stub.AbstractFutureStub<LoggingServiceV2FutureStub> {
    private LoggingServiceV2FutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoggingServiceV2FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LoggingServiceV2FutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deletes all the log entries in a log. The log reappears if it receives new
     * entries. Log entries written shortly before the delete operation might not
     * be deleted. Entries received after the delete operation with a timestamp
     * before the operation will be deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteLog(
        com.google.logging.v2.DeleteLogRequest request) {
      return futureUnaryCall(getChannel().newCall(getDeleteLogMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Writes log entries to Logging. This API method is the
     * only way to send log entries to Logging. This method
     * is used, directly or indirectly, by the Logging agent
     * (fluentd) and all logging libraries configured to use Logging.
     * A single request may contain log entries for a maximum of 1000
     * different resources (projects, organizations, billing accounts or
     * folders)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.logging.v2.WriteLogEntriesResponse>
        writeLogEntries(com.google.logging.v2.WriteLogEntriesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteLogEntriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists log entries.  Use this method to retrieve log entries that originated
     * from a project/folder/organization/billing account.  For ways to export log
     * entries, see [Exporting
     * Logs](https://cloud.google.com/logging/docs/export).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.logging.v2.ListLogEntriesResponse>
        listLogEntries(com.google.logging.v2.ListLogEntriesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListLogEntriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the descriptors for monitored resource types used by Logging.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.logging.v2.ListMonitoredResourceDescriptorsResponse>
        listMonitoredResourceDescriptors(
            com.google.logging.v2.ListMonitoredResourceDescriptorsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListMonitoredResourceDescriptorsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists the logs in projects, organizations, folders, or billing accounts.
     * Only logs that have entries are listed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.logging.v2.ListLogsResponse>
        listLogs(com.google.logging.v2.ListLogsRequest request) {
      return futureUnaryCall(getChannel().newCall(getListLogsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DELETE_LOG = 0;
  private static final int METHODID_WRITE_LOG_ENTRIES = 1;
  private static final int METHODID_LIST_LOG_ENTRIES = 2;
  private static final int METHODID_LIST_MONITORED_RESOURCE_DESCRIPTORS = 3;
  private static final int METHODID_LIST_LOGS = 4;
  private static final int METHODID_TAIL_LOG_ENTRIES = 5;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LoggingServiceV2ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LoggingServiceV2ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DELETE_LOG:
          serviceImpl.deleteLog(
              (com.google.logging.v2.DeleteLogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_WRITE_LOG_ENTRIES:
          serviceImpl.writeLogEntries(
              (com.google.logging.v2.WriteLogEntriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.WriteLogEntriesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_LOG_ENTRIES:
          serviceImpl.listLogEntries(
              (com.google.logging.v2.ListLogEntriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.ListLogEntriesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_MONITORED_RESOURCE_DESCRIPTORS:
          serviceImpl.listMonitoredResourceDescriptors(
              (com.google.logging.v2.ListMonitoredResourceDescriptorsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.logging.v2.ListMonitoredResourceDescriptorsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_LOGS:
          serviceImpl.listLogs(
              (com.google.logging.v2.ListLogsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.ListLogsResponse>)
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
        case METHODID_TAIL_LOG_ENTRIES:
          return (io.grpc.stub.StreamObserver<Req>)
              serviceImpl.tailLogEntries(
                  (io.grpc.stub.StreamObserver<com.google.logging.v2.TailLogEntriesResponse>)
                      responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private abstract static class LoggingServiceV2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LoggingServiceV2BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.logging.v2.LoggingProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LoggingServiceV2");
    }
  }

  private static final class LoggingServiceV2FileDescriptorSupplier
      extends LoggingServiceV2BaseDescriptorSupplier {
    LoggingServiceV2FileDescriptorSupplier() {}
  }

  private static final class LoggingServiceV2MethodDescriptorSupplier
      extends LoggingServiceV2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LoggingServiceV2MethodDescriptorSupplier(String methodName) {
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
      synchronized (LoggingServiceV2Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new LoggingServiceV2FileDescriptorSupplier())
                      .addMethod(getDeleteLogMethod())
                      .addMethod(getWriteLogEntriesMethod())
                      .addMethod(getListLogEntriesMethod())
                      .addMethod(getListMonitoredResourceDescriptorsMethod())
                      .addMethod(getListLogsMethod())
                      .addMethod(getTailLogEntriesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
