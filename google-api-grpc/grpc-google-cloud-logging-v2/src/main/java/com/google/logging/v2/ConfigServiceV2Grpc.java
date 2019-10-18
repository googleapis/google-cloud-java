package com.google.logging.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * Service for configuring sinks used to route log entries.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/logging/v2/logging_config.proto")
public final class ConfigServiceV2Grpc {

  private ConfigServiceV2Grpc() {}

  public static final String SERVICE_NAME = "google.logging.v2.ConfigServiceV2";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListSinksMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.logging.v2.ListSinksRequest, com.google.logging.v2.ListSinksResponse>
      METHOD_LIST_SINKS = getListSinksMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.ListSinksRequest, com.google.logging.v2.ListSinksResponse>
      getListSinksMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.ListSinksRequest, com.google.logging.v2.ListSinksResponse>
      getListSinksMethod() {
    return getListSinksMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.logging.v2.ListSinksRequest, com.google.logging.v2.ListSinksResponse>
      getListSinksMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.ListSinksRequest, com.google.logging.v2.ListSinksResponse>
        getListSinksMethod;
    if ((getListSinksMethod = ConfigServiceV2Grpc.getListSinksMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getListSinksMethod = ConfigServiceV2Grpc.getListSinksMethod) == null) {
          ConfigServiceV2Grpc.getListSinksMethod =
              getListSinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.ListSinksRequest,
                          com.google.logging.v2.ListSinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName("google.logging.v2.ConfigServiceV2", "ListSinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.ListSinksRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.ListSinksResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new ConfigServiceV2MethodDescriptorSupplier("ListSinks"))
                      .build();
        }
      }
    }
    return getListSinksMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetSinkMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.logging.v2.GetSinkRequest, com.google.logging.v2.LogSink>
      METHOD_GET_SINK = getGetSinkMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.GetSinkRequest, com.google.logging.v2.LogSink>
      getGetSinkMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.GetSinkRequest, com.google.logging.v2.LogSink>
      getGetSinkMethod() {
    return getGetSinkMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.logging.v2.GetSinkRequest, com.google.logging.v2.LogSink>
      getGetSinkMethodHelper() {
    io.grpc.MethodDescriptor<com.google.logging.v2.GetSinkRequest, com.google.logging.v2.LogSink>
        getGetSinkMethod;
    if ((getGetSinkMethod = ConfigServiceV2Grpc.getGetSinkMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getGetSinkMethod = ConfigServiceV2Grpc.getGetSinkMethod) == null) {
          ConfigServiceV2Grpc.getGetSinkMethod =
              getGetSinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.GetSinkRequest, com.google.logging.v2.LogSink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName("google.logging.v2.ConfigServiceV2", "GetSink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.GetSinkRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.LogSink.getDefaultInstance()))
                      .setSchemaDescriptor(new ConfigServiceV2MethodDescriptorSupplier("GetSink"))
                      .build();
        }
      }
    }
    return getGetSinkMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateSinkMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.logging.v2.CreateSinkRequest, com.google.logging.v2.LogSink>
      METHOD_CREATE_SINK = getCreateSinkMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.CreateSinkRequest, com.google.logging.v2.LogSink>
      getCreateSinkMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.CreateSinkRequest, com.google.logging.v2.LogSink>
      getCreateSinkMethod() {
    return getCreateSinkMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.logging.v2.CreateSinkRequest, com.google.logging.v2.LogSink>
      getCreateSinkMethodHelper() {
    io.grpc.MethodDescriptor<com.google.logging.v2.CreateSinkRequest, com.google.logging.v2.LogSink>
        getCreateSinkMethod;
    if ((getCreateSinkMethod = ConfigServiceV2Grpc.getCreateSinkMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getCreateSinkMethod = ConfigServiceV2Grpc.getCreateSinkMethod) == null) {
          ConfigServiceV2Grpc.getCreateSinkMethod =
              getCreateSinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.CreateSinkRequest, com.google.logging.v2.LogSink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName("google.logging.v2.ConfigServiceV2", "CreateSink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.CreateSinkRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.LogSink.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("CreateSink"))
                      .build();
        }
      }
    }
    return getCreateSinkMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateSinkMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.logging.v2.UpdateSinkRequest, com.google.logging.v2.LogSink>
      METHOD_UPDATE_SINK = getUpdateSinkMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.UpdateSinkRequest, com.google.logging.v2.LogSink>
      getUpdateSinkMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.UpdateSinkRequest, com.google.logging.v2.LogSink>
      getUpdateSinkMethod() {
    return getUpdateSinkMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.logging.v2.UpdateSinkRequest, com.google.logging.v2.LogSink>
      getUpdateSinkMethodHelper() {
    io.grpc.MethodDescriptor<com.google.logging.v2.UpdateSinkRequest, com.google.logging.v2.LogSink>
        getUpdateSinkMethod;
    if ((getUpdateSinkMethod = ConfigServiceV2Grpc.getUpdateSinkMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getUpdateSinkMethod = ConfigServiceV2Grpc.getUpdateSinkMethod) == null) {
          ConfigServiceV2Grpc.getUpdateSinkMethod =
              getUpdateSinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.UpdateSinkRequest, com.google.logging.v2.LogSink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName("google.logging.v2.ConfigServiceV2", "UpdateSink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.UpdateSinkRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.LogSink.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("UpdateSink"))
                      .build();
        }
      }
    }
    return getUpdateSinkMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteSinkMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.logging.v2.DeleteSinkRequest, com.google.protobuf.Empty>
      METHOD_DELETE_SINK = getDeleteSinkMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.DeleteSinkRequest, com.google.protobuf.Empty>
      getDeleteSinkMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.DeleteSinkRequest, com.google.protobuf.Empty>
      getDeleteSinkMethod() {
    return getDeleteSinkMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.logging.v2.DeleteSinkRequest, com.google.protobuf.Empty>
      getDeleteSinkMethodHelper() {
    io.grpc.MethodDescriptor<com.google.logging.v2.DeleteSinkRequest, com.google.protobuf.Empty>
        getDeleteSinkMethod;
    if ((getDeleteSinkMethod = ConfigServiceV2Grpc.getDeleteSinkMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getDeleteSinkMethod = ConfigServiceV2Grpc.getDeleteSinkMethod) == null) {
          ConfigServiceV2Grpc.getDeleteSinkMethod =
              getDeleteSinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.DeleteSinkRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName("google.logging.v2.ConfigServiceV2", "DeleteSink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.DeleteSinkRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("DeleteSink"))
                      .build();
        }
      }
    }
    return getDeleteSinkMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListExclusionsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.logging.v2.ListExclusionsRequest, com.google.logging.v2.ListExclusionsResponse>
      METHOD_LIST_EXCLUSIONS = getListExclusionsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.ListExclusionsRequest, com.google.logging.v2.ListExclusionsResponse>
      getListExclusionsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.ListExclusionsRequest, com.google.logging.v2.ListExclusionsResponse>
      getListExclusionsMethod() {
    return getListExclusionsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.logging.v2.ListExclusionsRequest, com.google.logging.v2.ListExclusionsResponse>
      getListExclusionsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.ListExclusionsRequest,
            com.google.logging.v2.ListExclusionsResponse>
        getListExclusionsMethod;
    if ((getListExclusionsMethod = ConfigServiceV2Grpc.getListExclusionsMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getListExclusionsMethod = ConfigServiceV2Grpc.getListExclusionsMethod) == null) {
          ConfigServiceV2Grpc.getListExclusionsMethod =
              getListExclusionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.ListExclusionsRequest,
                          com.google.logging.v2.ListExclusionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.logging.v2.ConfigServiceV2", "ListExclusions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.ListExclusionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.ListExclusionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("ListExclusions"))
                      .build();
        }
      }
    }
    return getListExclusionsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetExclusionMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.logging.v2.GetExclusionRequest, com.google.logging.v2.LogExclusion>
      METHOD_GET_EXCLUSION = getGetExclusionMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.GetExclusionRequest, com.google.logging.v2.LogExclusion>
      getGetExclusionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.GetExclusionRequest, com.google.logging.v2.LogExclusion>
      getGetExclusionMethod() {
    return getGetExclusionMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.logging.v2.GetExclusionRequest, com.google.logging.v2.LogExclusion>
      getGetExclusionMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.GetExclusionRequest, com.google.logging.v2.LogExclusion>
        getGetExclusionMethod;
    if ((getGetExclusionMethod = ConfigServiceV2Grpc.getGetExclusionMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getGetExclusionMethod = ConfigServiceV2Grpc.getGetExclusionMethod) == null) {
          ConfigServiceV2Grpc.getGetExclusionMethod =
              getGetExclusionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.GetExclusionRequest,
                          com.google.logging.v2.LogExclusion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.logging.v2.ConfigServiceV2", "GetExclusion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.GetExclusionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.LogExclusion.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("GetExclusion"))
                      .build();
        }
      }
    }
    return getGetExclusionMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateExclusionMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.logging.v2.CreateExclusionRequest, com.google.logging.v2.LogExclusion>
      METHOD_CREATE_EXCLUSION = getCreateExclusionMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.CreateExclusionRequest, com.google.logging.v2.LogExclusion>
      getCreateExclusionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.CreateExclusionRequest, com.google.logging.v2.LogExclusion>
      getCreateExclusionMethod() {
    return getCreateExclusionMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.logging.v2.CreateExclusionRequest, com.google.logging.v2.LogExclusion>
      getCreateExclusionMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.CreateExclusionRequest, com.google.logging.v2.LogExclusion>
        getCreateExclusionMethod;
    if ((getCreateExclusionMethod = ConfigServiceV2Grpc.getCreateExclusionMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getCreateExclusionMethod = ConfigServiceV2Grpc.getCreateExclusionMethod) == null) {
          ConfigServiceV2Grpc.getCreateExclusionMethod =
              getCreateExclusionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.CreateExclusionRequest,
                          com.google.logging.v2.LogExclusion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.logging.v2.ConfigServiceV2", "CreateExclusion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.CreateExclusionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.LogExclusion.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("CreateExclusion"))
                      .build();
        }
      }
    }
    return getCreateExclusionMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateExclusionMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.logging.v2.UpdateExclusionRequest, com.google.logging.v2.LogExclusion>
      METHOD_UPDATE_EXCLUSION = getUpdateExclusionMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.UpdateExclusionRequest, com.google.logging.v2.LogExclusion>
      getUpdateExclusionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.UpdateExclusionRequest, com.google.logging.v2.LogExclusion>
      getUpdateExclusionMethod() {
    return getUpdateExclusionMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.logging.v2.UpdateExclusionRequest, com.google.logging.v2.LogExclusion>
      getUpdateExclusionMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.UpdateExclusionRequest, com.google.logging.v2.LogExclusion>
        getUpdateExclusionMethod;
    if ((getUpdateExclusionMethod = ConfigServiceV2Grpc.getUpdateExclusionMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getUpdateExclusionMethod = ConfigServiceV2Grpc.getUpdateExclusionMethod) == null) {
          ConfigServiceV2Grpc.getUpdateExclusionMethod =
              getUpdateExclusionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.UpdateExclusionRequest,
                          com.google.logging.v2.LogExclusion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.logging.v2.ConfigServiceV2", "UpdateExclusion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.UpdateExclusionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.LogExclusion.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("UpdateExclusion"))
                      .build();
        }
      }
    }
    return getUpdateExclusionMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteExclusionMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.logging.v2.DeleteExclusionRequest, com.google.protobuf.Empty>
      METHOD_DELETE_EXCLUSION = getDeleteExclusionMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.DeleteExclusionRequest, com.google.protobuf.Empty>
      getDeleteExclusionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.DeleteExclusionRequest, com.google.protobuf.Empty>
      getDeleteExclusionMethod() {
    return getDeleteExclusionMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.logging.v2.DeleteExclusionRequest, com.google.protobuf.Empty>
      getDeleteExclusionMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.DeleteExclusionRequest, com.google.protobuf.Empty>
        getDeleteExclusionMethod;
    if ((getDeleteExclusionMethod = ConfigServiceV2Grpc.getDeleteExclusionMethod) == null) {
      synchronized (ConfigServiceV2Grpc.class) {
        if ((getDeleteExclusionMethod = ConfigServiceV2Grpc.getDeleteExclusionMethod) == null) {
          ConfigServiceV2Grpc.getDeleteExclusionMethod =
              getDeleteExclusionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.DeleteExclusionRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.logging.v2.ConfigServiceV2", "DeleteExclusion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.DeleteExclusionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigServiceV2MethodDescriptorSupplier("DeleteExclusion"))
                      .build();
        }
      }
    }
    return getDeleteExclusionMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ConfigServiceV2Stub newStub(io.grpc.Channel channel) {
    return new ConfigServiceV2Stub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConfigServiceV2BlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new ConfigServiceV2BlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ConfigServiceV2FutureStub newFutureStub(io.grpc.Channel channel) {
    return new ConfigServiceV2FutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * Service for configuring sinks used to route log entries.
   * </pre>
   */
  public abstract static class ConfigServiceV2ImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists sinks.
     * </pre>
     */
    public void listSinks(
        com.google.logging.v2.ListSinksRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListSinksResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListSinksMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a sink.
     * </pre>
     */
    public void getSink(
        com.google.logging.v2.GetSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSinkMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a sink that exports specified log entries to a destination. The
     * export of newly-ingested log entries begins immediately, unless the sink's
     * `writer_identity` is not permitted to write to the destination. A sink can
     * export log entries only from the resource owning the sink.
     * </pre>
     */
    public void createSink(
        com.google.logging.v2.CreateSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateSinkMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a sink. This method replaces the following fields in the existing
     * sink with values from the new sink: `destination`, and `filter`.
     * The updated sink might also have a new `writer_identity`; see the
     * `unique_writer_identity` field.
     * </pre>
     */
    public void updateSink(
        com.google.logging.v2.UpdateSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateSinkMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a sink. If the sink has a unique `writer_identity`, then that
     * service account is also deleted.
     * </pre>
     */
    public void deleteSink(
        com.google.logging.v2.DeleteSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteSinkMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the exclusions in a parent resource.
     * </pre>
     */
    public void listExclusions(
        com.google.logging.v2.ListExclusionsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListExclusionsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListExclusionsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the description of an exclusion.
     * </pre>
     */
    public void getExclusion(
        com.google.logging.v2.GetExclusionRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogExclusion> responseObserver) {
      asyncUnimplementedUnaryCall(getGetExclusionMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new exclusion in a specified parent resource.
     * Only log entries belonging to that resource can be excluded.
     * You can have up to 10 exclusions in a resource.
     * </pre>
     */
    public void createExclusion(
        com.google.logging.v2.CreateExclusionRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogExclusion> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateExclusionMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Changes one or more properties of an existing exclusion.
     * </pre>
     */
    public void updateExclusion(
        com.google.logging.v2.UpdateExclusionRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogExclusion> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateExclusionMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an exclusion.
     * </pre>
     */
    public void deleteExclusion(
        com.google.logging.v2.DeleteExclusionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteExclusionMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListSinksMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.logging.v2.ListSinksRequest,
                      com.google.logging.v2.ListSinksResponse>(this, METHODID_LIST_SINKS)))
          .addMethod(
              getGetSinkMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.logging.v2.GetSinkRequest, com.google.logging.v2.LogSink>(
                      this, METHODID_GET_SINK)))
          .addMethod(
              getCreateSinkMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.logging.v2.CreateSinkRequest, com.google.logging.v2.LogSink>(
                      this, METHODID_CREATE_SINK)))
          .addMethod(
              getUpdateSinkMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.logging.v2.UpdateSinkRequest, com.google.logging.v2.LogSink>(
                      this, METHODID_UPDATE_SINK)))
          .addMethod(
              getDeleteSinkMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.logging.v2.DeleteSinkRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_SINK)))
          .addMethod(
              getListExclusionsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.logging.v2.ListExclusionsRequest,
                      com.google.logging.v2.ListExclusionsResponse>(
                      this, METHODID_LIST_EXCLUSIONS)))
          .addMethod(
              getGetExclusionMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.logging.v2.GetExclusionRequest,
                      com.google.logging.v2.LogExclusion>(this, METHODID_GET_EXCLUSION)))
          .addMethod(
              getCreateExclusionMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.logging.v2.CreateExclusionRequest,
                      com.google.logging.v2.LogExclusion>(this, METHODID_CREATE_EXCLUSION)))
          .addMethod(
              getUpdateExclusionMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.logging.v2.UpdateExclusionRequest,
                      com.google.logging.v2.LogExclusion>(this, METHODID_UPDATE_EXCLUSION)))
          .addMethod(
              getDeleteExclusionMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.logging.v2.DeleteExclusionRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_EXCLUSION)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for configuring sinks used to route log entries.
   * </pre>
   */
  public static final class ConfigServiceV2Stub
      extends io.grpc.stub.AbstractStub<ConfigServiceV2Stub> {
    private ConfigServiceV2Stub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConfigServiceV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigServiceV2Stub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigServiceV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists sinks.
     * </pre>
     */
    public void listSinks(
        com.google.logging.v2.ListSinksRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListSinksResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListSinksMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a sink.
     * </pre>
     */
    public void getSink(
        com.google.logging.v2.GetSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSinkMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a sink that exports specified log entries to a destination. The
     * export of newly-ingested log entries begins immediately, unless the sink's
     * `writer_identity` is not permitted to write to the destination. A sink can
     * export log entries only from the resource owning the sink.
     * </pre>
     */
    public void createSink(
        com.google.logging.v2.CreateSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateSinkMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a sink. This method replaces the following fields in the existing
     * sink with values from the new sink: `destination`, and `filter`.
     * The updated sink might also have a new `writer_identity`; see the
     * `unique_writer_identity` field.
     * </pre>
     */
    public void updateSink(
        com.google.logging.v2.UpdateSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateSinkMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a sink. If the sink has a unique `writer_identity`, then that
     * service account is also deleted.
     * </pre>
     */
    public void deleteSink(
        com.google.logging.v2.DeleteSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteSinkMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the exclusions in a parent resource.
     * </pre>
     */
    public void listExclusions(
        com.google.logging.v2.ListExclusionsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListExclusionsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListExclusionsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the description of an exclusion.
     * </pre>
     */
    public void getExclusion(
        com.google.logging.v2.GetExclusionRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogExclusion> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetExclusionMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new exclusion in a specified parent resource.
     * Only log entries belonging to that resource can be excluded.
     * You can have up to 10 exclusions in a resource.
     * </pre>
     */
    public void createExclusion(
        com.google.logging.v2.CreateExclusionRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogExclusion> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateExclusionMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Changes one or more properties of an existing exclusion.
     * </pre>
     */
    public void updateExclusion(
        com.google.logging.v2.UpdateExclusionRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogExclusion> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateExclusionMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an exclusion.
     * </pre>
     */
    public void deleteExclusion(
        com.google.logging.v2.DeleteExclusionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteExclusionMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for configuring sinks used to route log entries.
   * </pre>
   */
  public static final class ConfigServiceV2BlockingStub
      extends io.grpc.stub.AbstractStub<ConfigServiceV2BlockingStub> {
    private ConfigServiceV2BlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConfigServiceV2BlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigServiceV2BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigServiceV2BlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists sinks.
     * </pre>
     */
    public com.google.logging.v2.ListSinksResponse listSinks(
        com.google.logging.v2.ListSinksRequest request) {
      return blockingUnaryCall(getChannel(), getListSinksMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a sink.
     * </pre>
     */
    public com.google.logging.v2.LogSink getSink(com.google.logging.v2.GetSinkRequest request) {
      return blockingUnaryCall(getChannel(), getGetSinkMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a sink that exports specified log entries to a destination. The
     * export of newly-ingested log entries begins immediately, unless the sink's
     * `writer_identity` is not permitted to write to the destination. A sink can
     * export log entries only from the resource owning the sink.
     * </pre>
     */
    public com.google.logging.v2.LogSink createSink(
        com.google.logging.v2.CreateSinkRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateSinkMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a sink. This method replaces the following fields in the existing
     * sink with values from the new sink: `destination`, and `filter`.
     * The updated sink might also have a new `writer_identity`; see the
     * `unique_writer_identity` field.
     * </pre>
     */
    public com.google.logging.v2.LogSink updateSink(
        com.google.logging.v2.UpdateSinkRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateSinkMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a sink. If the sink has a unique `writer_identity`, then that
     * service account is also deleted.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSink(com.google.logging.v2.DeleteSinkRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteSinkMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the exclusions in a parent resource.
     * </pre>
     */
    public com.google.logging.v2.ListExclusionsResponse listExclusions(
        com.google.logging.v2.ListExclusionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListExclusionsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the description of an exclusion.
     * </pre>
     */
    public com.google.logging.v2.LogExclusion getExclusion(
        com.google.logging.v2.GetExclusionRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetExclusionMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new exclusion in a specified parent resource.
     * Only log entries belonging to that resource can be excluded.
     * You can have up to 10 exclusions in a resource.
     * </pre>
     */
    public com.google.logging.v2.LogExclusion createExclusion(
        com.google.logging.v2.CreateExclusionRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateExclusionMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Changes one or more properties of an existing exclusion.
     * </pre>
     */
    public com.google.logging.v2.LogExclusion updateExclusion(
        com.google.logging.v2.UpdateExclusionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateExclusionMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an exclusion.
     * </pre>
     */
    public com.google.protobuf.Empty deleteExclusion(
        com.google.logging.v2.DeleteExclusionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteExclusionMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for configuring sinks used to route log entries.
   * </pre>
   */
  public static final class ConfigServiceV2FutureStub
      extends io.grpc.stub.AbstractStub<ConfigServiceV2FutureStub> {
    private ConfigServiceV2FutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConfigServiceV2FutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigServiceV2FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigServiceV2FutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists sinks.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.logging.v2.ListSinksResponse>
        listSinks(com.google.logging.v2.ListSinksRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListSinksMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a sink.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogSink>
        getSink(com.google.logging.v2.GetSinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetSinkMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a sink that exports specified log entries to a destination. The
     * export of newly-ingested log entries begins immediately, unless the sink's
     * `writer_identity` is not permitted to write to the destination. A sink can
     * export log entries only from the resource owning the sink.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogSink>
        createSink(com.google.logging.v2.CreateSinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateSinkMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a sink. This method replaces the following fields in the existing
     * sink with values from the new sink: `destination`, and `filter`.
     * The updated sink might also have a new `writer_identity`; see the
     * `unique_writer_identity` field.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogSink>
        updateSink(com.google.logging.v2.UpdateSinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateSinkMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a sink. If the sink has a unique `writer_identity`, then that
     * service account is also deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteSink(
        com.google.logging.v2.DeleteSinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteSinkMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the exclusions in a parent resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.logging.v2.ListExclusionsResponse>
        listExclusions(com.google.logging.v2.ListExclusionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListExclusionsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the description of an exclusion.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogExclusion>
        getExclusion(com.google.logging.v2.GetExclusionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetExclusionMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new exclusion in a specified parent resource.
     * Only log entries belonging to that resource can be excluded.
     * You can have up to 10 exclusions in a resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogExclusion>
        createExclusion(com.google.logging.v2.CreateExclusionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateExclusionMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Changes one or more properties of an existing exclusion.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogExclusion>
        updateExclusion(com.google.logging.v2.UpdateExclusionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateExclusionMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an exclusion.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteExclusion(com.google.logging.v2.DeleteExclusionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteExclusionMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_SINKS = 0;
  private static final int METHODID_GET_SINK = 1;
  private static final int METHODID_CREATE_SINK = 2;
  private static final int METHODID_UPDATE_SINK = 3;
  private static final int METHODID_DELETE_SINK = 4;
  private static final int METHODID_LIST_EXCLUSIONS = 5;
  private static final int METHODID_GET_EXCLUSION = 6;
  private static final int METHODID_CREATE_EXCLUSION = 7;
  private static final int METHODID_UPDATE_EXCLUSION = 8;
  private static final int METHODID_DELETE_EXCLUSION = 9;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ConfigServiceV2ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ConfigServiceV2ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_SINKS:
          serviceImpl.listSinks(
              (com.google.logging.v2.ListSinksRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.ListSinksResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SINK:
          serviceImpl.getSink(
              (com.google.logging.v2.GetSinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink>) responseObserver);
          break;
        case METHODID_CREATE_SINK:
          serviceImpl.createSink(
              (com.google.logging.v2.CreateSinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink>) responseObserver);
          break;
        case METHODID_UPDATE_SINK:
          serviceImpl.updateSink(
              (com.google.logging.v2.UpdateSinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink>) responseObserver);
          break;
        case METHODID_DELETE_SINK:
          serviceImpl.deleteSink(
              (com.google.logging.v2.DeleteSinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_EXCLUSIONS:
          serviceImpl.listExclusions(
              (com.google.logging.v2.ListExclusionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.ListExclusionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_EXCLUSION:
          serviceImpl.getExclusion(
              (com.google.logging.v2.GetExclusionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.LogExclusion>) responseObserver);
          break;
        case METHODID_CREATE_EXCLUSION:
          serviceImpl.createExclusion(
              (com.google.logging.v2.CreateExclusionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.LogExclusion>) responseObserver);
          break;
        case METHODID_UPDATE_EXCLUSION:
          serviceImpl.updateExclusion(
              (com.google.logging.v2.UpdateExclusionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.LogExclusion>) responseObserver);
          break;
        case METHODID_DELETE_EXCLUSION:
          serviceImpl.deleteExclusion(
              (com.google.logging.v2.DeleteExclusionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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

  private abstract static class ConfigServiceV2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConfigServiceV2BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.logging.v2.LoggingConfigProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ConfigServiceV2");
    }
  }

  private static final class ConfigServiceV2FileDescriptorSupplier
      extends ConfigServiceV2BaseDescriptorSupplier {
    ConfigServiceV2FileDescriptorSupplier() {}
  }

  private static final class ConfigServiceV2MethodDescriptorSupplier
      extends ConfigServiceV2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ConfigServiceV2MethodDescriptorSupplier(String methodName) {
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
      synchronized (ConfigServiceV2Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ConfigServiceV2FileDescriptorSupplier())
                      .addMethod(getListSinksMethodHelper())
                      .addMethod(getGetSinkMethodHelper())
                      .addMethod(getCreateSinkMethodHelper())
                      .addMethod(getUpdateSinkMethodHelper())
                      .addMethod(getDeleteSinkMethodHelper())
                      .addMethod(getListExclusionsMethodHelper())
                      .addMethod(getGetExclusionMethodHelper())
                      .addMethod(getCreateExclusionMethodHelper())
                      .addMethod(getUpdateExclusionMethodHelper())
                      .addMethod(getDeleteExclusionMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
