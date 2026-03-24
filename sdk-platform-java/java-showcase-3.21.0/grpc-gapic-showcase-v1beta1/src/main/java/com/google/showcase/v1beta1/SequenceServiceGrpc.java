/*
 * Copyright 2025 Google LLC
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
package com.google.showcase.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/** */
@io.grpc.stub.annotations.GrpcGenerated
public final class SequenceServiceGrpc {

  private SequenceServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.showcase.v1beta1.SequenceService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.CreateSequenceRequest, com.google.showcase.v1beta1.Sequence>
      getCreateSequenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSequence",
      requestType = com.google.showcase.v1beta1.CreateSequenceRequest.class,
      responseType = com.google.showcase.v1beta1.Sequence.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.CreateSequenceRequest, com.google.showcase.v1beta1.Sequence>
      getCreateSequenceMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.CreateSequenceRequest, com.google.showcase.v1beta1.Sequence>
        getCreateSequenceMethod;
    if ((getCreateSequenceMethod = SequenceServiceGrpc.getCreateSequenceMethod) == null) {
      synchronized (SequenceServiceGrpc.class) {
        if ((getCreateSequenceMethod = SequenceServiceGrpc.getCreateSequenceMethod) == null) {
          SequenceServiceGrpc.getCreateSequenceMethod =
              getCreateSequenceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.CreateSequenceRequest,
                          com.google.showcase.v1beta1.Sequence>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSequence"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.CreateSequenceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.Sequence.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SequenceServiceMethodDescriptorSupplier("CreateSequence"))
                      .build();
        }
      }
    }
    return getCreateSequenceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.CreateStreamingSequenceRequest,
          com.google.showcase.v1beta1.StreamingSequence>
      getCreateStreamingSequenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateStreamingSequence",
      requestType = com.google.showcase.v1beta1.CreateStreamingSequenceRequest.class,
      responseType = com.google.showcase.v1beta1.StreamingSequence.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.CreateStreamingSequenceRequest,
          com.google.showcase.v1beta1.StreamingSequence>
      getCreateStreamingSequenceMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.CreateStreamingSequenceRequest,
            com.google.showcase.v1beta1.StreamingSequence>
        getCreateStreamingSequenceMethod;
    if ((getCreateStreamingSequenceMethod = SequenceServiceGrpc.getCreateStreamingSequenceMethod)
        == null) {
      synchronized (SequenceServiceGrpc.class) {
        if ((getCreateStreamingSequenceMethod =
                SequenceServiceGrpc.getCreateStreamingSequenceMethod)
            == null) {
          SequenceServiceGrpc.getCreateStreamingSequenceMethod =
              getCreateStreamingSequenceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.CreateStreamingSequenceRequest,
                          com.google.showcase.v1beta1.StreamingSequence>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateStreamingSequence"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.CreateStreamingSequenceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.StreamingSequence.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SequenceServiceMethodDescriptorSupplier("CreateStreamingSequence"))
                      .build();
        }
      }
    }
    return getCreateStreamingSequenceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.GetSequenceReportRequest,
          com.google.showcase.v1beta1.SequenceReport>
      getGetSequenceReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSequenceReport",
      requestType = com.google.showcase.v1beta1.GetSequenceReportRequest.class,
      responseType = com.google.showcase.v1beta1.SequenceReport.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.GetSequenceReportRequest,
          com.google.showcase.v1beta1.SequenceReport>
      getGetSequenceReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.GetSequenceReportRequest,
            com.google.showcase.v1beta1.SequenceReport>
        getGetSequenceReportMethod;
    if ((getGetSequenceReportMethod = SequenceServiceGrpc.getGetSequenceReportMethod) == null) {
      synchronized (SequenceServiceGrpc.class) {
        if ((getGetSequenceReportMethod = SequenceServiceGrpc.getGetSequenceReportMethod) == null) {
          SequenceServiceGrpc.getGetSequenceReportMethod =
              getGetSequenceReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.GetSequenceReportRequest,
                          com.google.showcase.v1beta1.SequenceReport>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSequenceReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.GetSequenceReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.SequenceReport.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SequenceServiceMethodDescriptorSupplier("GetSequenceReport"))
                      .build();
        }
      }
    }
    return getGetSequenceReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.GetStreamingSequenceReportRequest,
          com.google.showcase.v1beta1.StreamingSequenceReport>
      getGetStreamingSequenceReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStreamingSequenceReport",
      requestType = com.google.showcase.v1beta1.GetStreamingSequenceReportRequest.class,
      responseType = com.google.showcase.v1beta1.StreamingSequenceReport.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.GetStreamingSequenceReportRequest,
          com.google.showcase.v1beta1.StreamingSequenceReport>
      getGetStreamingSequenceReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.GetStreamingSequenceReportRequest,
            com.google.showcase.v1beta1.StreamingSequenceReport>
        getGetStreamingSequenceReportMethod;
    if ((getGetStreamingSequenceReportMethod =
            SequenceServiceGrpc.getGetStreamingSequenceReportMethod)
        == null) {
      synchronized (SequenceServiceGrpc.class) {
        if ((getGetStreamingSequenceReportMethod =
                SequenceServiceGrpc.getGetStreamingSequenceReportMethod)
            == null) {
          SequenceServiceGrpc.getGetStreamingSequenceReportMethod =
              getGetStreamingSequenceReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.GetStreamingSequenceReportRequest,
                          com.google.showcase.v1beta1.StreamingSequenceReport>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetStreamingSequenceReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.GetStreamingSequenceReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.StreamingSequenceReport
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SequenceServiceMethodDescriptorSupplier("GetStreamingSequenceReport"))
                      .build();
        }
      }
    }
    return getGetStreamingSequenceReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.AttemptSequenceRequest, com.google.protobuf.Empty>
      getAttemptSequenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AttemptSequence",
      requestType = com.google.showcase.v1beta1.AttemptSequenceRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.AttemptSequenceRequest, com.google.protobuf.Empty>
      getAttemptSequenceMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.AttemptSequenceRequest, com.google.protobuf.Empty>
        getAttemptSequenceMethod;
    if ((getAttemptSequenceMethod = SequenceServiceGrpc.getAttemptSequenceMethod) == null) {
      synchronized (SequenceServiceGrpc.class) {
        if ((getAttemptSequenceMethod = SequenceServiceGrpc.getAttemptSequenceMethod) == null) {
          SequenceServiceGrpc.getAttemptSequenceMethod =
              getAttemptSequenceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.AttemptSequenceRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AttemptSequence"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.AttemptSequenceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SequenceServiceMethodDescriptorSupplier("AttemptSequence"))
                      .build();
        }
      }
    }
    return getAttemptSequenceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.AttemptStreamingSequenceRequest,
          com.google.showcase.v1beta1.AttemptStreamingSequenceResponse>
      getAttemptStreamingSequenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AttemptStreamingSequence",
      requestType = com.google.showcase.v1beta1.AttemptStreamingSequenceRequest.class,
      responseType = com.google.showcase.v1beta1.AttemptStreamingSequenceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.AttemptStreamingSequenceRequest,
          com.google.showcase.v1beta1.AttemptStreamingSequenceResponse>
      getAttemptStreamingSequenceMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.AttemptStreamingSequenceRequest,
            com.google.showcase.v1beta1.AttemptStreamingSequenceResponse>
        getAttemptStreamingSequenceMethod;
    if ((getAttemptStreamingSequenceMethod = SequenceServiceGrpc.getAttemptStreamingSequenceMethod)
        == null) {
      synchronized (SequenceServiceGrpc.class) {
        if ((getAttemptStreamingSequenceMethod =
                SequenceServiceGrpc.getAttemptStreamingSequenceMethod)
            == null) {
          SequenceServiceGrpc.getAttemptStreamingSequenceMethod =
              getAttemptStreamingSequenceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.AttemptStreamingSequenceRequest,
                          com.google.showcase.v1beta1.AttemptStreamingSequenceResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "AttemptStreamingSequence"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.AttemptStreamingSequenceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.AttemptStreamingSequenceResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SequenceServiceMethodDescriptorSupplier("AttemptStreamingSequence"))
                      .build();
        }
      }
    }
    return getAttemptStreamingSequenceMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SequenceServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SequenceServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SequenceServiceStub>() {
          @java.lang.Override
          public SequenceServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SequenceServiceStub(channel, callOptions);
          }
        };
    return SequenceServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SequenceServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SequenceServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SequenceServiceBlockingV2Stub>() {
          @java.lang.Override
          public SequenceServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SequenceServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return SequenceServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SequenceServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SequenceServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SequenceServiceBlockingStub>() {
          @java.lang.Override
          public SequenceServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SequenceServiceBlockingStub(channel, callOptions);
          }
        };
    return SequenceServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SequenceServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SequenceServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SequenceServiceFutureStub>() {
          @java.lang.Override
          public SequenceServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SequenceServiceFutureStub(channel, callOptions);
          }
        };
    return SequenceServiceFutureStub.newStub(factory, channel);
  }

  /** */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a sequence.
     * </pre>
     */
    default void createSequence(
        com.google.showcase.v1beta1.CreateSequenceRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Sequence> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSequenceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a sequence.
     * </pre>
     */
    default void createStreamingSequence(
        com.google.showcase.v1beta1.CreateStreamingSequenceRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.StreamingSequence>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateStreamingSequenceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a sequence.
     * </pre>
     */
    default void getSequenceReport(
        com.google.showcase.v1beta1.GetSequenceReportRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.SequenceReport> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSequenceReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a sequence.
     * </pre>
     */
    default void getStreamingSequenceReport(
        com.google.showcase.v1beta1.GetStreamingSequenceReportRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.StreamingSequenceReport>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetStreamingSequenceReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Attempts a sequence.
     * </pre>
     */
    default void attemptSequence(
        com.google.showcase.v1beta1.AttemptSequenceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAttemptSequenceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Attempts a streaming sequence.
     * May not function as expected in HTTP mode due to when http statuses are sent
     * See https://github.com/googleapis/gapic-showcase/issues/1377 for more details
     * </pre>
     */
    default void attemptStreamingSequence(
        com.google.showcase.v1beta1.AttemptStreamingSequenceRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.AttemptStreamingSequenceResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAttemptStreamingSequenceMethod(), responseObserver);
    }
  }

  /** Base class for the server implementation of the service SequenceService. */
  public abstract static class SequenceServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SequenceServiceGrpc.bindService(this);
    }
  }

  /** A stub to allow clients to do asynchronous rpc calls to service SequenceService. */
  public static final class SequenceServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SequenceServiceStub> {
    private SequenceServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SequenceServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SequenceServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a sequence.
     * </pre>
     */
    public void createSequence(
        com.google.showcase.v1beta1.CreateSequenceRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Sequence> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSequenceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a sequence.
     * </pre>
     */
    public void createStreamingSequence(
        com.google.showcase.v1beta1.CreateStreamingSequenceRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.StreamingSequence>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateStreamingSequenceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a sequence.
     * </pre>
     */
    public void getSequenceReport(
        com.google.showcase.v1beta1.GetSequenceReportRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.SequenceReport> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSequenceReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a sequence.
     * </pre>
     */
    public void getStreamingSequenceReport(
        com.google.showcase.v1beta1.GetStreamingSequenceReportRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.StreamingSequenceReport>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetStreamingSequenceReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Attempts a sequence.
     * </pre>
     */
    public void attemptSequence(
        com.google.showcase.v1beta1.AttemptSequenceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAttemptSequenceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Attempts a streaming sequence.
     * May not function as expected in HTTP mode due to when http statuses are sent
     * See https://github.com/googleapis/gapic-showcase/issues/1377 for more details
     * </pre>
     */
    public void attemptStreamingSequence(
        com.google.showcase.v1beta1.AttemptStreamingSequenceRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.AttemptStreamingSequenceResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getAttemptStreamingSequenceMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /** A stub to allow clients to do synchronous rpc calls to service SequenceService. */
  public static final class SequenceServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SequenceServiceBlockingV2Stub> {
    private SequenceServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SequenceServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SequenceServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a sequence.
     * </pre>
     */
    public com.google.showcase.v1beta1.Sequence createSequence(
        com.google.showcase.v1beta1.CreateSequenceRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateSequenceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a sequence.
     * </pre>
     */
    public com.google.showcase.v1beta1.StreamingSequence createStreamingSequence(
        com.google.showcase.v1beta1.CreateStreamingSequenceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateStreamingSequenceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a sequence.
     * </pre>
     */
    public com.google.showcase.v1beta1.SequenceReport getSequenceReport(
        com.google.showcase.v1beta1.GetSequenceReportRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSequenceReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a sequence.
     * </pre>
     */
    public com.google.showcase.v1beta1.StreamingSequenceReport getStreamingSequenceReport(
        com.google.showcase.v1beta1.GetStreamingSequenceReportRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetStreamingSequenceReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Attempts a sequence.
     * </pre>
     */
    public com.google.protobuf.Empty attemptSequence(
        com.google.showcase.v1beta1.AttemptSequenceRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getAttemptSequenceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Attempts a streaming sequence.
     * May not function as expected in HTTP mode due to when http statuses are sent
     * See https://github.com/googleapis/gapic-showcase/issues/1377 for more details
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<
            ?, com.google.showcase.v1beta1.AttemptStreamingSequenceResponse>
        attemptStreamingSequence(
            com.google.showcase.v1beta1.AttemptStreamingSequenceRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getAttemptStreamingSequenceMethod(), getCallOptions(), request);
    }
  }

  /** A stub to allow clients to do limited synchronous rpc calls to service SequenceService. */
  public static final class SequenceServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SequenceServiceBlockingStub> {
    private SequenceServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SequenceServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SequenceServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a sequence.
     * </pre>
     */
    public com.google.showcase.v1beta1.Sequence createSequence(
        com.google.showcase.v1beta1.CreateSequenceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSequenceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a sequence.
     * </pre>
     */
    public com.google.showcase.v1beta1.StreamingSequence createStreamingSequence(
        com.google.showcase.v1beta1.CreateStreamingSequenceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateStreamingSequenceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a sequence.
     * </pre>
     */
    public com.google.showcase.v1beta1.SequenceReport getSequenceReport(
        com.google.showcase.v1beta1.GetSequenceReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSequenceReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a sequence.
     * </pre>
     */
    public com.google.showcase.v1beta1.StreamingSequenceReport getStreamingSequenceReport(
        com.google.showcase.v1beta1.GetStreamingSequenceReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetStreamingSequenceReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Attempts a sequence.
     * </pre>
     */
    public com.google.protobuf.Empty attemptSequence(
        com.google.showcase.v1beta1.AttemptSequenceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAttemptSequenceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Attempts a streaming sequence.
     * May not function as expected in HTTP mode due to when http statuses are sent
     * See https://github.com/googleapis/gapic-showcase/issues/1377 for more details
     * </pre>
     */
    public java.util.Iterator<com.google.showcase.v1beta1.AttemptStreamingSequenceResponse>
        attemptStreamingSequence(
            com.google.showcase.v1beta1.AttemptStreamingSequenceRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getAttemptStreamingSequenceMethod(), getCallOptions(), request);
    }
  }

  /** A stub to allow clients to do ListenableFuture-style rpc calls to service SequenceService. */
  public static final class SequenceServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SequenceServiceFutureStub> {
    private SequenceServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SequenceServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SequenceServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a sequence.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.showcase.v1beta1.Sequence>
        createSequence(com.google.showcase.v1beta1.CreateSequenceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSequenceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a sequence.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.showcase.v1beta1.StreamingSequence>
        createStreamingSequence(
            com.google.showcase.v1beta1.CreateStreamingSequenceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateStreamingSequenceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a sequence.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.showcase.v1beta1.SequenceReport>
        getSequenceReport(com.google.showcase.v1beta1.GetSequenceReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSequenceReportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a sequence.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.showcase.v1beta1.StreamingSequenceReport>
        getStreamingSequenceReport(
            com.google.showcase.v1beta1.GetStreamingSequenceReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetStreamingSequenceReportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Attempts a sequence.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        attemptSequence(com.google.showcase.v1beta1.AttemptSequenceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAttemptSequenceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SEQUENCE = 0;
  private static final int METHODID_CREATE_STREAMING_SEQUENCE = 1;
  private static final int METHODID_GET_SEQUENCE_REPORT = 2;
  private static final int METHODID_GET_STREAMING_SEQUENCE_REPORT = 3;
  private static final int METHODID_ATTEMPT_SEQUENCE = 4;
  private static final int METHODID_ATTEMPT_STREAMING_SEQUENCE = 5;

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
        case METHODID_CREATE_SEQUENCE:
          serviceImpl.createSequence(
              (com.google.showcase.v1beta1.CreateSequenceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Sequence>) responseObserver);
          break;
        case METHODID_CREATE_STREAMING_SEQUENCE:
          serviceImpl.createStreamingSequence(
              (com.google.showcase.v1beta1.CreateStreamingSequenceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.StreamingSequence>)
                  responseObserver);
          break;
        case METHODID_GET_SEQUENCE_REPORT:
          serviceImpl.getSequenceReport(
              (com.google.showcase.v1beta1.GetSequenceReportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.SequenceReport>)
                  responseObserver);
          break;
        case METHODID_GET_STREAMING_SEQUENCE_REPORT:
          serviceImpl.getStreamingSequenceReport(
              (com.google.showcase.v1beta1.GetStreamingSequenceReportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.StreamingSequenceReport>)
                  responseObserver);
          break;
        case METHODID_ATTEMPT_SEQUENCE:
          serviceImpl.attemptSequence(
              (com.google.showcase.v1beta1.AttemptSequenceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_ATTEMPT_STREAMING_SEQUENCE:
          serviceImpl.attemptStreamingSequence(
              (com.google.showcase.v1beta1.AttemptStreamingSequenceRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.showcase.v1beta1.AttemptStreamingSequenceResponse>)
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
            getCreateSequenceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.CreateSequenceRequest,
                    com.google.showcase.v1beta1.Sequence>(service, METHODID_CREATE_SEQUENCE)))
        .addMethod(
            getCreateStreamingSequenceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.CreateStreamingSequenceRequest,
                    com.google.showcase.v1beta1.StreamingSequence>(
                    service, METHODID_CREATE_STREAMING_SEQUENCE)))
        .addMethod(
            getGetSequenceReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.GetSequenceReportRequest,
                    com.google.showcase.v1beta1.SequenceReport>(
                    service, METHODID_GET_SEQUENCE_REPORT)))
        .addMethod(
            getGetStreamingSequenceReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.GetStreamingSequenceReportRequest,
                    com.google.showcase.v1beta1.StreamingSequenceReport>(
                    service, METHODID_GET_STREAMING_SEQUENCE_REPORT)))
        .addMethod(
            getAttemptSequenceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.AttemptSequenceRequest, com.google.protobuf.Empty>(
                    service, METHODID_ATTEMPT_SEQUENCE)))
        .addMethod(
            getAttemptStreamingSequenceMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.AttemptStreamingSequenceRequest,
                    com.google.showcase.v1beta1.AttemptStreamingSequenceResponse>(
                    service, METHODID_ATTEMPT_STREAMING_SEQUENCE)))
        .build();
  }

  private abstract static class SequenceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SequenceServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.showcase.v1beta1.SequenceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SequenceService");
    }
  }

  private static final class SequenceServiceFileDescriptorSupplier
      extends SequenceServiceBaseDescriptorSupplier {
    SequenceServiceFileDescriptorSupplier() {}
  }

  private static final class SequenceServiceMethodDescriptorSupplier
      extends SequenceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SequenceServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SequenceServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SequenceServiceFileDescriptorSupplier())
                      .addMethod(getCreateSequenceMethod())
                      .addMethod(getCreateStreamingSequenceMethod())
                      .addMethod(getGetSequenceReportMethod())
                      .addMethod(getGetStreamingSequenceReportMethod())
                      .addMethod(getAttemptSequenceMethod())
                      .addMethod(getAttemptStreamingSequenceMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
