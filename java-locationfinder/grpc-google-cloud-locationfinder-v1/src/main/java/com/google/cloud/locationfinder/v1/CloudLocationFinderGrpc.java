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
package com.google.cloud.locationfinder.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/locationfinder/v1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CloudLocationFinderGrpc {

  private CloudLocationFinderGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.locationfinder.v1.CloudLocationFinder";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.locationfinder.v1.ListCloudLocationsRequest,
          com.google.cloud.locationfinder.v1.ListCloudLocationsResponse>
      getListCloudLocationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCloudLocations",
      requestType = com.google.cloud.locationfinder.v1.ListCloudLocationsRequest.class,
      responseType = com.google.cloud.locationfinder.v1.ListCloudLocationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.locationfinder.v1.ListCloudLocationsRequest,
          com.google.cloud.locationfinder.v1.ListCloudLocationsResponse>
      getListCloudLocationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.locationfinder.v1.ListCloudLocationsRequest,
            com.google.cloud.locationfinder.v1.ListCloudLocationsResponse>
        getListCloudLocationsMethod;
    if ((getListCloudLocationsMethod = CloudLocationFinderGrpc.getListCloudLocationsMethod)
        == null) {
      synchronized (CloudLocationFinderGrpc.class) {
        if ((getListCloudLocationsMethod = CloudLocationFinderGrpc.getListCloudLocationsMethod)
            == null) {
          CloudLocationFinderGrpc.getListCloudLocationsMethod =
              getListCloudLocationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.locationfinder.v1.ListCloudLocationsRequest,
                          com.google.cloud.locationfinder.v1.ListCloudLocationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCloudLocations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.locationfinder.v1.ListCloudLocationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.locationfinder.v1.ListCloudLocationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudLocationFinderMethodDescriptorSupplier("ListCloudLocations"))
                      .build();
        }
      }
    }
    return getListCloudLocationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.locationfinder.v1.GetCloudLocationRequest,
          com.google.cloud.locationfinder.v1.CloudLocation>
      getGetCloudLocationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCloudLocation",
      requestType = com.google.cloud.locationfinder.v1.GetCloudLocationRequest.class,
      responseType = com.google.cloud.locationfinder.v1.CloudLocation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.locationfinder.v1.GetCloudLocationRequest,
          com.google.cloud.locationfinder.v1.CloudLocation>
      getGetCloudLocationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.locationfinder.v1.GetCloudLocationRequest,
            com.google.cloud.locationfinder.v1.CloudLocation>
        getGetCloudLocationMethod;
    if ((getGetCloudLocationMethod = CloudLocationFinderGrpc.getGetCloudLocationMethod) == null) {
      synchronized (CloudLocationFinderGrpc.class) {
        if ((getGetCloudLocationMethod = CloudLocationFinderGrpc.getGetCloudLocationMethod)
            == null) {
          CloudLocationFinderGrpc.getGetCloudLocationMethod =
              getGetCloudLocationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.locationfinder.v1.GetCloudLocationRequest,
                          com.google.cloud.locationfinder.v1.CloudLocation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCloudLocation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.locationfinder.v1.GetCloudLocationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.locationfinder.v1.CloudLocation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudLocationFinderMethodDescriptorSupplier("GetCloudLocation"))
                      .build();
        }
      }
    }
    return getGetCloudLocationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.locationfinder.v1.SearchCloudLocationsRequest,
          com.google.cloud.locationfinder.v1.SearchCloudLocationsResponse>
      getSearchCloudLocationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchCloudLocations",
      requestType = com.google.cloud.locationfinder.v1.SearchCloudLocationsRequest.class,
      responseType = com.google.cloud.locationfinder.v1.SearchCloudLocationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.locationfinder.v1.SearchCloudLocationsRequest,
          com.google.cloud.locationfinder.v1.SearchCloudLocationsResponse>
      getSearchCloudLocationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.locationfinder.v1.SearchCloudLocationsRequest,
            com.google.cloud.locationfinder.v1.SearchCloudLocationsResponse>
        getSearchCloudLocationsMethod;
    if ((getSearchCloudLocationsMethod = CloudLocationFinderGrpc.getSearchCloudLocationsMethod)
        == null) {
      synchronized (CloudLocationFinderGrpc.class) {
        if ((getSearchCloudLocationsMethod = CloudLocationFinderGrpc.getSearchCloudLocationsMethod)
            == null) {
          CloudLocationFinderGrpc.getSearchCloudLocationsMethod =
              getSearchCloudLocationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.locationfinder.v1.SearchCloudLocationsRequest,
                          com.google.cloud.locationfinder.v1.SearchCloudLocationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SearchCloudLocations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.locationfinder.v1.SearchCloudLocationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.locationfinder.v1.SearchCloudLocationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudLocationFinderMethodDescriptorSupplier("SearchCloudLocations"))
                      .build();
        }
      }
    }
    return getSearchCloudLocationsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CloudLocationFinderStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudLocationFinderStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudLocationFinderStub>() {
          @java.lang.Override
          public CloudLocationFinderStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudLocationFinderStub(channel, callOptions);
          }
        };
    return CloudLocationFinderStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static CloudLocationFinderBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudLocationFinderBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudLocationFinderBlockingV2Stub>() {
          @java.lang.Override
          public CloudLocationFinderBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudLocationFinderBlockingV2Stub(channel, callOptions);
          }
        };
    return CloudLocationFinderBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CloudLocationFinderBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudLocationFinderBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudLocationFinderBlockingStub>() {
          @java.lang.Override
          public CloudLocationFinderBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudLocationFinderBlockingStub(channel, callOptions);
          }
        };
    return CloudLocationFinderBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CloudLocationFinderFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudLocationFinderFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudLocationFinderFutureStub>() {
          @java.lang.Override
          public CloudLocationFinderFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudLocationFinderFutureStub(channel, callOptions);
          }
        };
    return CloudLocationFinderFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists cloud locations under a given project and location.
     * </pre>
     */
    default void listCloudLocations(
        com.google.cloud.locationfinder.v1.ListCloudLocationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.locationfinder.v1.ListCloudLocationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCloudLocationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a cloud location.
     * </pre>
     */
    default void getCloudLocation(
        com.google.cloud.locationfinder.v1.GetCloudLocationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.locationfinder.v1.CloudLocation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCloudLocationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches for cloud locations from a given source location.
     * </pre>
     */
    default void searchCloudLocations(
        com.google.cloud.locationfinder.v1.SearchCloudLocationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.locationfinder.v1.SearchCloudLocationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchCloudLocationsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CloudLocationFinder.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class CloudLocationFinderImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return CloudLocationFinderGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CloudLocationFinder.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class CloudLocationFinderStub
      extends io.grpc.stub.AbstractAsyncStub<CloudLocationFinderStub> {
    private CloudLocationFinderStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudLocationFinderStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudLocationFinderStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists cloud locations under a given project and location.
     * </pre>
     */
    public void listCloudLocations(
        com.google.cloud.locationfinder.v1.ListCloudLocationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.locationfinder.v1.ListCloudLocationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCloudLocationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a cloud location.
     * </pre>
     */
    public void getCloudLocation(
        com.google.cloud.locationfinder.v1.GetCloudLocationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.locationfinder.v1.CloudLocation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCloudLocationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches for cloud locations from a given source location.
     * </pre>
     */
    public void searchCloudLocations(
        com.google.cloud.locationfinder.v1.SearchCloudLocationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.locationfinder.v1.SearchCloudLocationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchCloudLocationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CloudLocationFinder.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class CloudLocationFinderBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<CloudLocationFinderBlockingV2Stub> {
    private CloudLocationFinderBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudLocationFinderBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudLocationFinderBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists cloud locations under a given project and location.
     * </pre>
     */
    public com.google.cloud.locationfinder.v1.ListCloudLocationsResponse listCloudLocations(
        com.google.cloud.locationfinder.v1.ListCloudLocationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCloudLocationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a cloud location.
     * </pre>
     */
    public com.google.cloud.locationfinder.v1.CloudLocation getCloudLocation(
        com.google.cloud.locationfinder.v1.GetCloudLocationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCloudLocationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches for cloud locations from a given source location.
     * </pre>
     */
    public com.google.cloud.locationfinder.v1.SearchCloudLocationsResponse searchCloudLocations(
        com.google.cloud.locationfinder.v1.SearchCloudLocationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchCloudLocationsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service CloudLocationFinder.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class CloudLocationFinderBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CloudLocationFinderBlockingStub> {
    private CloudLocationFinderBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudLocationFinderBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudLocationFinderBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists cloud locations under a given project and location.
     * </pre>
     */
    public com.google.cloud.locationfinder.v1.ListCloudLocationsResponse listCloudLocations(
        com.google.cloud.locationfinder.v1.ListCloudLocationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCloudLocationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a cloud location.
     * </pre>
     */
    public com.google.cloud.locationfinder.v1.CloudLocation getCloudLocation(
        com.google.cloud.locationfinder.v1.GetCloudLocationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCloudLocationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches for cloud locations from a given source location.
     * </pre>
     */
    public com.google.cloud.locationfinder.v1.SearchCloudLocationsResponse searchCloudLocations(
        com.google.cloud.locationfinder.v1.SearchCloudLocationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchCloudLocationsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CloudLocationFinder.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class CloudLocationFinderFutureStub
      extends io.grpc.stub.AbstractFutureStub<CloudLocationFinderFutureStub> {
    private CloudLocationFinderFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudLocationFinderFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudLocationFinderFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists cloud locations under a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.locationfinder.v1.ListCloudLocationsResponse>
        listCloudLocations(com.google.cloud.locationfinder.v1.ListCloudLocationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCloudLocationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a cloud location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.locationfinder.v1.CloudLocation>
        getCloudLocation(com.google.cloud.locationfinder.v1.GetCloudLocationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCloudLocationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Searches for cloud locations from a given source location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.locationfinder.v1.SearchCloudLocationsResponse>
        searchCloudLocations(
            com.google.cloud.locationfinder.v1.SearchCloudLocationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchCloudLocationsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CLOUD_LOCATIONS = 0;
  private static final int METHODID_GET_CLOUD_LOCATION = 1;
  private static final int METHODID_SEARCH_CLOUD_LOCATIONS = 2;

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
        case METHODID_LIST_CLOUD_LOCATIONS:
          serviceImpl.listCloudLocations(
              (com.google.cloud.locationfinder.v1.ListCloudLocationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.locationfinder.v1.ListCloudLocationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CLOUD_LOCATION:
          serviceImpl.getCloudLocation(
              (com.google.cloud.locationfinder.v1.GetCloudLocationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.locationfinder.v1.CloudLocation>)
                  responseObserver);
          break;
        case METHODID_SEARCH_CLOUD_LOCATIONS:
          serviceImpl.searchCloudLocations(
              (com.google.cloud.locationfinder.v1.SearchCloudLocationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.locationfinder.v1.SearchCloudLocationsResponse>)
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
            getListCloudLocationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.locationfinder.v1.ListCloudLocationsRequest,
                    com.google.cloud.locationfinder.v1.ListCloudLocationsResponse>(
                    service, METHODID_LIST_CLOUD_LOCATIONS)))
        .addMethod(
            getGetCloudLocationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.locationfinder.v1.GetCloudLocationRequest,
                    com.google.cloud.locationfinder.v1.CloudLocation>(
                    service, METHODID_GET_CLOUD_LOCATION)))
        .addMethod(
            getSearchCloudLocationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.locationfinder.v1.SearchCloudLocationsRequest,
                    com.google.cloud.locationfinder.v1.SearchCloudLocationsResponse>(
                    service, METHODID_SEARCH_CLOUD_LOCATIONS)))
        .build();
  }

  private abstract static class CloudLocationFinderBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CloudLocationFinderBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.locationfinder.v1.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CloudLocationFinder");
    }
  }

  private static final class CloudLocationFinderFileDescriptorSupplier
      extends CloudLocationFinderBaseDescriptorSupplier {
    CloudLocationFinderFileDescriptorSupplier() {}
  }

  private static final class CloudLocationFinderMethodDescriptorSupplier
      extends CloudLocationFinderBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CloudLocationFinderMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CloudLocationFinderGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CloudLocationFinderFileDescriptorSupplier())
                      .addMethod(getListCloudLocationsMethod())
                      .addMethod(getGetCloudLocationMethod())
                      .addMethod(getSearchCloudLocationsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
