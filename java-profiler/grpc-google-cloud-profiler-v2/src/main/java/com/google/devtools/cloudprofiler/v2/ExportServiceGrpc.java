/*
 * Copyright 2023 Google LLC
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
package com.google.devtools.cloudprofiler.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service allows existing Cloud Profiler customers to export their profile data
 * out of Google Cloud.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/devtools/cloudprofiler/v2/profiler.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ExportServiceGrpc {

  private ExportServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.devtools.cloudprofiler.v2.ExportService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.cloudprofiler.v2.ListProfilesRequest,
          com.google.devtools.cloudprofiler.v2.ListProfilesResponse>
      getListProfilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProfiles",
      requestType = com.google.devtools.cloudprofiler.v2.ListProfilesRequest.class,
      responseType = com.google.devtools.cloudprofiler.v2.ListProfilesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.cloudprofiler.v2.ListProfilesRequest,
          com.google.devtools.cloudprofiler.v2.ListProfilesResponse>
      getListProfilesMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.cloudprofiler.v2.ListProfilesRequest,
            com.google.devtools.cloudprofiler.v2.ListProfilesResponse>
        getListProfilesMethod;
    if ((getListProfilesMethod = ExportServiceGrpc.getListProfilesMethod) == null) {
      synchronized (ExportServiceGrpc.class) {
        if ((getListProfilesMethod = ExportServiceGrpc.getListProfilesMethod) == null) {
          ExportServiceGrpc.getListProfilesMethod =
              getListProfilesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.cloudprofiler.v2.ListProfilesRequest,
                          com.google.devtools.cloudprofiler.v2.ListProfilesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListProfiles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.cloudprofiler.v2.ListProfilesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.cloudprofiler.v2.ListProfilesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ExportServiceMethodDescriptorSupplier("ListProfiles"))
                      .build();
        }
      }
    }
    return getListProfilesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ExportServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExportServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ExportServiceStub>() {
          @java.lang.Override
          public ExportServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ExportServiceStub(channel, callOptions);
          }
        };
    return ExportServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ExportServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExportServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ExportServiceBlockingStub>() {
          @java.lang.Override
          public ExportServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ExportServiceBlockingStub(channel, callOptions);
          }
        };
    return ExportServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ExportServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExportServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ExportServiceFutureStub>() {
          @java.lang.Override
          public ExportServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ExportServiceFutureStub(channel, callOptions);
          }
        };
    return ExportServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service allows existing Cloud Profiler customers to export their profile data
   * out of Google Cloud.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists profiles which have been collected so far and for which the caller
     * has permission to view.
     * </pre>
     */
    default void listProfiles(
        com.google.devtools.cloudprofiler.v2.ListProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.cloudprofiler.v2.ListProfilesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListProfilesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ExportService.
   *
   * <pre>
   * Service allows existing Cloud Profiler customers to export their profile data
   * out of Google Cloud.
   * </pre>
   */
  public abstract static class ExportServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ExportServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ExportService.
   *
   * <pre>
   * Service allows existing Cloud Profiler customers to export their profile data
   * out of Google Cloud.
   * </pre>
   */
  public static final class ExportServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ExportServiceStub> {
    private ExportServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExportServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExportServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists profiles which have been collected so far and for which the caller
     * has permission to view.
     * </pre>
     */
    public void listProfiles(
        com.google.devtools.cloudprofiler.v2.ListProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.cloudprofiler.v2.ListProfilesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListProfilesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ExportService.
   *
   * <pre>
   * Service allows existing Cloud Profiler customers to export their profile data
   * out of Google Cloud.
   * </pre>
   */
  public static final class ExportServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ExportServiceBlockingStub> {
    private ExportServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExportServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExportServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists profiles which have been collected so far and for which the caller
     * has permission to view.
     * </pre>
     */
    public com.google.devtools.cloudprofiler.v2.ListProfilesResponse listProfiles(
        com.google.devtools.cloudprofiler.v2.ListProfilesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListProfilesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ExportService.
   *
   * <pre>
   * Service allows existing Cloud Profiler customers to export their profile data
   * out of Google Cloud.
   * </pre>
   */
  public static final class ExportServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ExportServiceFutureStub> {
    private ExportServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExportServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExportServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists profiles which have been collected so far and for which the caller
     * has permission to view.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.cloudprofiler.v2.ListProfilesResponse>
        listProfiles(com.google.devtools.cloudprofiler.v2.ListProfilesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListProfilesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_PROFILES = 0;

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
        case METHODID_LIST_PROFILES:
          serviceImpl.listProfiles(
              (com.google.devtools.cloudprofiler.v2.ListProfilesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devtools.cloudprofiler.v2.ListProfilesResponse>)
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
            getListProfilesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.cloudprofiler.v2.ListProfilesRequest,
                    com.google.devtools.cloudprofiler.v2.ListProfilesResponse>(
                    service, METHODID_LIST_PROFILES)))
        .build();
  }

  private abstract static class ExportServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ExportServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.devtools.cloudprofiler.v2.ProfilerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ExportService");
    }
  }

  private static final class ExportServiceFileDescriptorSupplier
      extends ExportServiceBaseDescriptorSupplier {
    ExportServiceFileDescriptorSupplier() {}
  }

  private static final class ExportServiceMethodDescriptorSupplier
      extends ExportServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ExportServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ExportServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ExportServiceFileDescriptorSupplier())
                      .addMethod(getListProfilesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
