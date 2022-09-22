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
package com.google.dataflow.v1beta3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The Dataflow Messages API is used for monitoring the progress of
 * Dataflow jobs.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/dataflow/v1beta3/messages.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MessagesV1Beta3Grpc {

  private MessagesV1Beta3Grpc() {}

  public static final String SERVICE_NAME = "google.dataflow.v1beta3.MessagesV1Beta3";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.dataflow.v1beta3.ListJobMessagesRequest,
          com.google.dataflow.v1beta3.ListJobMessagesResponse>
      getListJobMessagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListJobMessages",
      requestType = com.google.dataflow.v1beta3.ListJobMessagesRequest.class,
      responseType = com.google.dataflow.v1beta3.ListJobMessagesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.dataflow.v1beta3.ListJobMessagesRequest,
          com.google.dataflow.v1beta3.ListJobMessagesResponse>
      getListJobMessagesMethod() {
    io.grpc.MethodDescriptor<
            com.google.dataflow.v1beta3.ListJobMessagesRequest,
            com.google.dataflow.v1beta3.ListJobMessagesResponse>
        getListJobMessagesMethod;
    if ((getListJobMessagesMethod = MessagesV1Beta3Grpc.getListJobMessagesMethod) == null) {
      synchronized (MessagesV1Beta3Grpc.class) {
        if ((getListJobMessagesMethod = MessagesV1Beta3Grpc.getListJobMessagesMethod) == null) {
          MessagesV1Beta3Grpc.getListJobMessagesMethod =
              getListJobMessagesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.dataflow.v1beta3.ListJobMessagesRequest,
                          com.google.dataflow.v1beta3.ListJobMessagesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListJobMessages"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.dataflow.v1beta3.ListJobMessagesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.dataflow.v1beta3.ListJobMessagesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MessagesV1Beta3MethodDescriptorSupplier("ListJobMessages"))
                      .build();
        }
      }
    }
    return getListJobMessagesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static MessagesV1Beta3Stub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessagesV1Beta3Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MessagesV1Beta3Stub>() {
          @java.lang.Override
          public MessagesV1Beta3Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MessagesV1Beta3Stub(channel, callOptions);
          }
        };
    return MessagesV1Beta3Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MessagesV1Beta3BlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessagesV1Beta3BlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MessagesV1Beta3BlockingStub>() {
          @java.lang.Override
          public MessagesV1Beta3BlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MessagesV1Beta3BlockingStub(channel, callOptions);
          }
        };
    return MessagesV1Beta3BlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static MessagesV1Beta3FutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessagesV1Beta3FutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MessagesV1Beta3FutureStub>() {
          @java.lang.Override
          public MessagesV1Beta3FutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MessagesV1Beta3FutureStub(channel, callOptions);
          }
        };
    return MessagesV1Beta3FutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The Dataflow Messages API is used for monitoring the progress of
   * Dataflow jobs.
   * </pre>
   */
  public abstract static class MessagesV1Beta3ImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Request the job status.
     * To request the status of a job, we recommend using
     * `projects.locations.jobs.messages.list` with a [regional endpoint]
     * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
     * `projects.jobs.messages.list` is not recommended, as you can only request
     * the status of jobs that are running in `us-central1`.
     * </pre>
     */
    public void listJobMessages(
        com.google.dataflow.v1beta3.ListJobMessagesRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.ListJobMessagesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListJobMessagesMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListJobMessagesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.dataflow.v1beta3.ListJobMessagesRequest,
                      com.google.dataflow.v1beta3.ListJobMessagesResponse>(
                      this, METHODID_LIST_JOB_MESSAGES)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The Dataflow Messages API is used for monitoring the progress of
   * Dataflow jobs.
   * </pre>
   */
  public static final class MessagesV1Beta3Stub
      extends io.grpc.stub.AbstractAsyncStub<MessagesV1Beta3Stub> {
    private MessagesV1Beta3Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessagesV1Beta3Stub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessagesV1Beta3Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Request the job status.
     * To request the status of a job, we recommend using
     * `projects.locations.jobs.messages.list` with a [regional endpoint]
     * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
     * `projects.jobs.messages.list` is not recommended, as you can only request
     * the status of jobs that are running in `us-central1`.
     * </pre>
     */
    public void listJobMessages(
        com.google.dataflow.v1beta3.ListJobMessagesRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.ListJobMessagesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListJobMessagesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The Dataflow Messages API is used for monitoring the progress of
   * Dataflow jobs.
   * </pre>
   */
  public static final class MessagesV1Beta3BlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MessagesV1Beta3BlockingStub> {
    private MessagesV1Beta3BlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessagesV1Beta3BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessagesV1Beta3BlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Request the job status.
     * To request the status of a job, we recommend using
     * `projects.locations.jobs.messages.list` with a [regional endpoint]
     * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
     * `projects.jobs.messages.list` is not recommended, as you can only request
     * the status of jobs that are running in `us-central1`.
     * </pre>
     */
    public com.google.dataflow.v1beta3.ListJobMessagesResponse listJobMessages(
        com.google.dataflow.v1beta3.ListJobMessagesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListJobMessagesMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The Dataflow Messages API is used for monitoring the progress of
   * Dataflow jobs.
   * </pre>
   */
  public static final class MessagesV1Beta3FutureStub
      extends io.grpc.stub.AbstractFutureStub<MessagesV1Beta3FutureStub> {
    private MessagesV1Beta3FutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessagesV1Beta3FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessagesV1Beta3FutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Request the job status.
     * To request the status of a job, we recommend using
     * `projects.locations.jobs.messages.list` with a [regional endpoint]
     * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
     * `projects.jobs.messages.list` is not recommended, as you can only request
     * the status of jobs that are running in `us-central1`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.dataflow.v1beta3.ListJobMessagesResponse>
        listJobMessages(com.google.dataflow.v1beta3.ListJobMessagesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListJobMessagesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_JOB_MESSAGES = 0;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MessagesV1Beta3ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MessagesV1Beta3ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_JOB_MESSAGES:
          serviceImpl.listJobMessages(
              (com.google.dataflow.v1beta3.ListJobMessagesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.ListJobMessagesResponse>)
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

  private abstract static class MessagesV1Beta3BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MessagesV1Beta3BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.dataflow.v1beta3.MessagesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MessagesV1Beta3");
    }
  }

  private static final class MessagesV1Beta3FileDescriptorSupplier
      extends MessagesV1Beta3BaseDescriptorSupplier {
    MessagesV1Beta3FileDescriptorSupplier() {}
  }

  private static final class MessagesV1Beta3MethodDescriptorSupplier
      extends MessagesV1Beta3BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MessagesV1Beta3MethodDescriptorSupplier(String methodName) {
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
      synchronized (MessagesV1Beta3Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new MessagesV1Beta3FileDescriptorSupplier())
                      .addMethod(getListJobMessagesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
