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
package com.google.cloud.talent.v4;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service handles auto completion.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/talent/v4/completion_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CompletionGrpc {

  private CompletionGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.talent.v4.Completion";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4.CompleteQueryRequest,
          com.google.cloud.talent.v4.CompleteQueryResponse>
      getCompleteQueryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CompleteQuery",
      requestType = com.google.cloud.talent.v4.CompleteQueryRequest.class,
      responseType = com.google.cloud.talent.v4.CompleteQueryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4.CompleteQueryRequest,
          com.google.cloud.talent.v4.CompleteQueryResponse>
      getCompleteQueryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4.CompleteQueryRequest,
            com.google.cloud.talent.v4.CompleteQueryResponse>
        getCompleteQueryMethod;
    if ((getCompleteQueryMethod = CompletionGrpc.getCompleteQueryMethod) == null) {
      synchronized (CompletionGrpc.class) {
        if ((getCompleteQueryMethod = CompletionGrpc.getCompleteQueryMethod) == null) {
          CompletionGrpc.getCompleteQueryMethod =
              getCompleteQueryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4.CompleteQueryRequest,
                          com.google.cloud.talent.v4.CompleteQueryResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CompleteQuery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4.CompleteQueryRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4.CompleteQueryResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new CompletionMethodDescriptorSupplier("CompleteQuery"))
                      .build();
        }
      }
    }
    return getCompleteQueryMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CompletionStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CompletionStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CompletionStub>() {
          @java.lang.Override
          public CompletionStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CompletionStub(channel, callOptions);
          }
        };
    return CompletionStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CompletionBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CompletionBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CompletionBlockingStub>() {
          @java.lang.Override
          public CompletionBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CompletionBlockingStub(channel, callOptions);
          }
        };
    return CompletionBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CompletionFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CompletionFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CompletionFutureStub>() {
          @java.lang.Override
          public CompletionFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CompletionFutureStub(channel, callOptions);
          }
        };
    return CompletionFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service handles auto completion.
   * </pre>
   */
  public abstract static class CompletionImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Completes the specified prefix with keyword suggestions.
     * Intended for use by a job search auto-complete search box.
     * </pre>
     */
    public void completeQuery(
        com.google.cloud.talent.v4.CompleteQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4.CompleteQueryResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCompleteQueryMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCompleteQueryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4.CompleteQueryRequest,
                      com.google.cloud.talent.v4.CompleteQueryResponse>(
                      this, METHODID_COMPLETE_QUERY)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * A service handles auto completion.
   * </pre>
   */
  public static final class CompletionStub extends io.grpc.stub.AbstractAsyncStub<CompletionStub> {
    private CompletionStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompletionStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompletionStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Completes the specified prefix with keyword suggestions.
     * Intended for use by a job search auto-complete search box.
     * </pre>
     */
    public void completeQuery(
        com.google.cloud.talent.v4.CompleteQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4.CompleteQueryResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCompleteQueryMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * A service handles auto completion.
   * </pre>
   */
  public static final class CompletionBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CompletionBlockingStub> {
    private CompletionBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompletionBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompletionBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Completes the specified prefix with keyword suggestions.
     * Intended for use by a job search auto-complete search box.
     * </pre>
     */
    public com.google.cloud.talent.v4.CompleteQueryResponse completeQuery(
        com.google.cloud.talent.v4.CompleteQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCompleteQueryMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * A service handles auto completion.
   * </pre>
   */
  public static final class CompletionFutureStub
      extends io.grpc.stub.AbstractFutureStub<CompletionFutureStub> {
    private CompletionFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompletionFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompletionFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Completes the specified prefix with keyword suggestions.
     * Intended for use by a job search auto-complete search box.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4.CompleteQueryResponse>
        completeQuery(com.google.cloud.talent.v4.CompleteQueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCompleteQueryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_COMPLETE_QUERY = 0;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CompletionImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CompletionImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_COMPLETE_QUERY:
          serviceImpl.completeQuery(
              (com.google.cloud.talent.v4.CompleteQueryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4.CompleteQueryResponse>)
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

  private abstract static class CompletionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CompletionBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.talent.v4.CompletionServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Completion");
    }
  }

  private static final class CompletionFileDescriptorSupplier
      extends CompletionBaseDescriptorSupplier {
    CompletionFileDescriptorSupplier() {}
  }

  private static final class CompletionMethodDescriptorSupplier
      extends CompletionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CompletionMethodDescriptorSupplier(String methodName) {
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
      synchronized (CompletionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CompletionFileDescriptorSupplier())
                      .addMethod(getCompleteQueryMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
