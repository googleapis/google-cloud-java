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
package com.google.cloud.dialogflow.v2beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing [AnswerRecords][google.cloud.dialogflow.v2beta1.AnswerRecord].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/v2beta1/answer_record.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AnswerRecordsGrpc {

  private AnswerRecordsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.v2beta1.AnswerRecords";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.GetAnswerRecordRequest,
          com.google.cloud.dialogflow.v2beta1.AnswerRecord>
      getGetAnswerRecordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAnswerRecord",
      requestType = com.google.cloud.dialogflow.v2beta1.GetAnswerRecordRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.AnswerRecord.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.GetAnswerRecordRequest,
          com.google.cloud.dialogflow.v2beta1.AnswerRecord>
      getGetAnswerRecordMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.GetAnswerRecordRequest,
            com.google.cloud.dialogflow.v2beta1.AnswerRecord>
        getGetAnswerRecordMethod;
    if ((getGetAnswerRecordMethod = AnswerRecordsGrpc.getGetAnswerRecordMethod) == null) {
      synchronized (AnswerRecordsGrpc.class) {
        if ((getGetAnswerRecordMethod = AnswerRecordsGrpc.getGetAnswerRecordMethod) == null) {
          AnswerRecordsGrpc.getGetAnswerRecordMethod =
              getGetAnswerRecordMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.GetAnswerRecordRequest,
                          com.google.cloud.dialogflow.v2beta1.AnswerRecord>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAnswerRecord"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.GetAnswerRecordRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.AnswerRecord
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnswerRecordsMethodDescriptorSupplier("GetAnswerRecord"))
                      .build();
        }
      }
    }
    return getGetAnswerRecordMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsRequest,
          com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsResponse>
      getListAnswerRecordsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAnswerRecords",
      requestType = com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsRequest,
          com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsResponse>
      getListAnswerRecordsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsRequest,
            com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsResponse>
        getListAnswerRecordsMethod;
    if ((getListAnswerRecordsMethod = AnswerRecordsGrpc.getListAnswerRecordsMethod) == null) {
      synchronized (AnswerRecordsGrpc.class) {
        if ((getListAnswerRecordsMethod = AnswerRecordsGrpc.getListAnswerRecordsMethod) == null) {
          AnswerRecordsGrpc.getListAnswerRecordsMethod =
              getListAnswerRecordsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsRequest,
                          com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAnswerRecords"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnswerRecordsMethodDescriptorSupplier("ListAnswerRecords"))
                      .build();
        }
      }
    }
    return getListAnswerRecordsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.UpdateAnswerRecordRequest,
          com.google.cloud.dialogflow.v2beta1.AnswerRecord>
      getUpdateAnswerRecordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAnswerRecord",
      requestType = com.google.cloud.dialogflow.v2beta1.UpdateAnswerRecordRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.AnswerRecord.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.UpdateAnswerRecordRequest,
          com.google.cloud.dialogflow.v2beta1.AnswerRecord>
      getUpdateAnswerRecordMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.UpdateAnswerRecordRequest,
            com.google.cloud.dialogflow.v2beta1.AnswerRecord>
        getUpdateAnswerRecordMethod;
    if ((getUpdateAnswerRecordMethod = AnswerRecordsGrpc.getUpdateAnswerRecordMethod) == null) {
      synchronized (AnswerRecordsGrpc.class) {
        if ((getUpdateAnswerRecordMethod = AnswerRecordsGrpc.getUpdateAnswerRecordMethod) == null) {
          AnswerRecordsGrpc.getUpdateAnswerRecordMethod =
              getUpdateAnswerRecordMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.UpdateAnswerRecordRequest,
                          com.google.cloud.dialogflow.v2beta1.AnswerRecord>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAnswerRecord"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.UpdateAnswerRecordRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.AnswerRecord
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnswerRecordsMethodDescriptorSupplier("UpdateAnswerRecord"))
                      .build();
        }
      }
    }
    return getUpdateAnswerRecordMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AnswerRecordsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnswerRecordsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AnswerRecordsStub>() {
          @java.lang.Override
          public AnswerRecordsStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AnswerRecordsStub(channel, callOptions);
          }
        };
    return AnswerRecordsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AnswerRecordsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnswerRecordsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AnswerRecordsBlockingStub>() {
          @java.lang.Override
          public AnswerRecordsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AnswerRecordsBlockingStub(channel, callOptions);
          }
        };
    return AnswerRecordsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AnswerRecordsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnswerRecordsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AnswerRecordsFutureStub>() {
          @java.lang.Override
          public AnswerRecordsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AnswerRecordsFutureStub(channel, callOptions);
          }
        };
    return AnswerRecordsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing [AnswerRecords][google.cloud.dialogflow.v2beta1.AnswerRecord].
   * </pre>
   */
  public abstract static class AnswerRecordsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Deprecated.
     * Retrieves a specific answer record.
     * </pre>
     */
    @java.lang.Deprecated
    public void getAnswerRecord(
        com.google.cloud.dialogflow.v2beta1.GetAnswerRecordRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.AnswerRecord>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAnswerRecordMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all answer records in the specified project in reverse
     * chronological order.
     * </pre>
     */
    public void listAnswerRecords(
        com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAnswerRecordsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified answer record.
     * </pre>
     */
    public void updateAnswerRecord(
        com.google.cloud.dialogflow.v2beta1.UpdateAnswerRecordRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.AnswerRecord>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAnswerRecordMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGetAnswerRecordMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.GetAnswerRecordRequest,
                      com.google.cloud.dialogflow.v2beta1.AnswerRecord>(
                      this, METHODID_GET_ANSWER_RECORD)))
          .addMethod(
              getListAnswerRecordsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsRequest,
                      com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsResponse>(
                      this, METHODID_LIST_ANSWER_RECORDS)))
          .addMethod(
              getUpdateAnswerRecordMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.UpdateAnswerRecordRequest,
                      com.google.cloud.dialogflow.v2beta1.AnswerRecord>(
                      this, METHODID_UPDATE_ANSWER_RECORD)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [AnswerRecords][google.cloud.dialogflow.v2beta1.AnswerRecord].
   * </pre>
   */
  public static final class AnswerRecordsStub
      extends io.grpc.stub.AbstractAsyncStub<AnswerRecordsStub> {
    private AnswerRecordsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnswerRecordsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnswerRecordsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deprecated.
     * Retrieves a specific answer record.
     * </pre>
     */
    @java.lang.Deprecated
    public void getAnswerRecord(
        com.google.cloud.dialogflow.v2beta1.GetAnswerRecordRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.AnswerRecord>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAnswerRecordMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all answer records in the specified project in reverse
     * chronological order.
     * </pre>
     */
    public void listAnswerRecords(
        com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAnswerRecordsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified answer record.
     * </pre>
     */
    public void updateAnswerRecord(
        com.google.cloud.dialogflow.v2beta1.UpdateAnswerRecordRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.AnswerRecord>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAnswerRecordMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [AnswerRecords][google.cloud.dialogflow.v2beta1.AnswerRecord].
   * </pre>
   */
  public static final class AnswerRecordsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AnswerRecordsBlockingStub> {
    private AnswerRecordsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnswerRecordsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnswerRecordsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deprecated.
     * Retrieves a specific answer record.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.cloud.dialogflow.v2beta1.AnswerRecord getAnswerRecord(
        com.google.cloud.dialogflow.v2beta1.GetAnswerRecordRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnswerRecordMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all answer records in the specified project in reverse
     * chronological order.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsResponse listAnswerRecords(
        com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAnswerRecordsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified answer record.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.AnswerRecord updateAnswerRecord(
        com.google.cloud.dialogflow.v2beta1.UpdateAnswerRecordRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAnswerRecordMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [AnswerRecords][google.cloud.dialogflow.v2beta1.AnswerRecord].
   * </pre>
   */
  public static final class AnswerRecordsFutureStub
      extends io.grpc.stub.AbstractFutureStub<AnswerRecordsFutureStub> {
    private AnswerRecordsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnswerRecordsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnswerRecordsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deprecated.
     * Retrieves a specific answer record.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.AnswerRecord>
        getAnswerRecord(com.google.cloud.dialogflow.v2beta1.GetAnswerRecordRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAnswerRecordMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all answer records in the specified project in reverse
     * chronological order.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsResponse>
        listAnswerRecords(com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAnswerRecordsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified answer record.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.AnswerRecord>
        updateAnswerRecord(com.google.cloud.dialogflow.v2beta1.UpdateAnswerRecordRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAnswerRecordMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ANSWER_RECORD = 0;
  private static final int METHODID_LIST_ANSWER_RECORDS = 1;
  private static final int METHODID_UPDATE_ANSWER_RECORD = 2;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AnswerRecordsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AnswerRecordsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ANSWER_RECORD:
          serviceImpl.getAnswerRecord(
              (com.google.cloud.dialogflow.v2beta1.GetAnswerRecordRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.AnswerRecord>)
                  responseObserver);
          break;
        case METHODID_LIST_ANSWER_RECORDS:
          serviceImpl.listAnswerRecords(
              (com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ANSWER_RECORD:
          serviceImpl.updateAnswerRecord(
              (com.google.cloud.dialogflow.v2beta1.UpdateAnswerRecordRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.AnswerRecord>)
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

  private abstract static class AnswerRecordsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AnswerRecordsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.v2beta1.AnswerRecordsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AnswerRecords");
    }
  }

  private static final class AnswerRecordsFileDescriptorSupplier
      extends AnswerRecordsBaseDescriptorSupplier {
    AnswerRecordsFileDescriptorSupplier() {}
  }

  private static final class AnswerRecordsMethodDescriptorSupplier
      extends AnswerRecordsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AnswerRecordsMethodDescriptorSupplier(String methodName) {
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
      synchronized (AnswerRecordsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AnswerRecordsFileDescriptorSupplier())
                      .addMethod(getGetAnswerRecordMethod())
                      .addMethod(getListAnswerRecordsMethod())
                      .addMethod(getUpdateAnswerRecordMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
