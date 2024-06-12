/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.retail.v2alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for [Branch][google.cloud.retail.v2alpha.Branch] Management
 * [Branch][google.cloud.retail.v2alpha.Branch]es are automatically created when
 * a [Catalog][google.cloud.retail.v2alpha.Catalog] is created. There are fixed
 * three branches in each catalog, and may use
 * [ListBranches][google.cloud.retail.v2alpha.BranchService.ListBranches] method
 * to get the details of all branches.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/retail/v2alpha/branch_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BranchServiceGrpc {

  private BranchServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.retail.v2alpha.BranchService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.ListBranchesRequest,
          com.google.cloud.retail.v2alpha.ListBranchesResponse>
      getListBranchesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBranches",
      requestType = com.google.cloud.retail.v2alpha.ListBranchesRequest.class,
      responseType = com.google.cloud.retail.v2alpha.ListBranchesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.ListBranchesRequest,
          com.google.cloud.retail.v2alpha.ListBranchesResponse>
      getListBranchesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2alpha.ListBranchesRequest,
            com.google.cloud.retail.v2alpha.ListBranchesResponse>
        getListBranchesMethod;
    if ((getListBranchesMethod = BranchServiceGrpc.getListBranchesMethod) == null) {
      synchronized (BranchServiceGrpc.class) {
        if ((getListBranchesMethod = BranchServiceGrpc.getListBranchesMethod) == null) {
          BranchServiceGrpc.getListBranchesMethod =
              getListBranchesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2alpha.ListBranchesRequest,
                          com.google.cloud.retail.v2alpha.ListBranchesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBranches"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.ListBranchesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.ListBranchesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BranchServiceMethodDescriptorSupplier("ListBranches"))
                      .build();
        }
      }
    }
    return getListBranchesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.GetBranchRequest, com.google.cloud.retail.v2alpha.Branch>
      getGetBranchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBranch",
      requestType = com.google.cloud.retail.v2alpha.GetBranchRequest.class,
      responseType = com.google.cloud.retail.v2alpha.Branch.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.GetBranchRequest, com.google.cloud.retail.v2alpha.Branch>
      getGetBranchMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2alpha.GetBranchRequest,
            com.google.cloud.retail.v2alpha.Branch>
        getGetBranchMethod;
    if ((getGetBranchMethod = BranchServiceGrpc.getGetBranchMethod) == null) {
      synchronized (BranchServiceGrpc.class) {
        if ((getGetBranchMethod = BranchServiceGrpc.getGetBranchMethod) == null) {
          BranchServiceGrpc.getGetBranchMethod =
              getGetBranchMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2alpha.GetBranchRequest,
                          com.google.cloud.retail.v2alpha.Branch>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBranch"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.GetBranchRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.Branch.getDefaultInstance()))
                      .setSchemaDescriptor(new BranchServiceMethodDescriptorSupplier("GetBranch"))
                      .build();
        }
      }
    }
    return getGetBranchMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static BranchServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BranchServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BranchServiceStub>() {
          @java.lang.Override
          public BranchServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BranchServiceStub(channel, callOptions);
          }
        };
    return BranchServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BranchServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BranchServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BranchServiceBlockingStub>() {
          @java.lang.Override
          public BranchServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BranchServiceBlockingStub(channel, callOptions);
          }
        };
    return BranchServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static BranchServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BranchServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BranchServiceFutureStub>() {
          @java.lang.Override
          public BranchServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BranchServiceFutureStub(channel, callOptions);
          }
        };
    return BranchServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for [Branch][google.cloud.retail.v2alpha.Branch] Management
   * [Branch][google.cloud.retail.v2alpha.Branch]es are automatically created when
   * a [Catalog][google.cloud.retail.v2alpha.Catalog] is created. There are fixed
   * three branches in each catalog, and may use
   * [ListBranches][google.cloud.retail.v2alpha.BranchService.ListBranches] method
   * to get the details of all branches.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists all [Branch][google.cloud.retail.v2alpha.Branch]s under the specified
     * parent [Catalog][google.cloud.retail.v2alpha.Catalog].
     * </pre>
     */
    default void listBranches(
        com.google.cloud.retail.v2alpha.ListBranchesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.ListBranchesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBranchesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a [Branch][google.cloud.retail.v2alpha.Branch].
     * </pre>
     */
    default void getBranch(
        com.google.cloud.retail.v2alpha.GetBranchRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.Branch> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBranchMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service BranchService.
   *
   * <pre>
   * Service for [Branch][google.cloud.retail.v2alpha.Branch] Management
   * [Branch][google.cloud.retail.v2alpha.Branch]es are automatically created when
   * a [Catalog][google.cloud.retail.v2alpha.Catalog] is created. There are fixed
   * three branches in each catalog, and may use
   * [ListBranches][google.cloud.retail.v2alpha.BranchService.ListBranches] method
   * to get the details of all branches.
   * </pre>
   */
  public abstract static class BranchServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return BranchServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service BranchService.
   *
   * <pre>
   * Service for [Branch][google.cloud.retail.v2alpha.Branch] Management
   * [Branch][google.cloud.retail.v2alpha.Branch]es are automatically created when
   * a [Catalog][google.cloud.retail.v2alpha.Catalog] is created. There are fixed
   * three branches in each catalog, and may use
   * [ListBranches][google.cloud.retail.v2alpha.BranchService.ListBranches] method
   * to get the details of all branches.
   * </pre>
   */
  public static final class BranchServiceStub
      extends io.grpc.stub.AbstractAsyncStub<BranchServiceStub> {
    private BranchServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BranchServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BranchServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all [Branch][google.cloud.retail.v2alpha.Branch]s under the specified
     * parent [Catalog][google.cloud.retail.v2alpha.Catalog].
     * </pre>
     */
    public void listBranches(
        com.google.cloud.retail.v2alpha.ListBranchesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.ListBranchesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBranchesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a [Branch][google.cloud.retail.v2alpha.Branch].
     * </pre>
     */
    public void getBranch(
        com.google.cloud.retail.v2alpha.GetBranchRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.Branch> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBranchMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service BranchService.
   *
   * <pre>
   * Service for [Branch][google.cloud.retail.v2alpha.Branch] Management
   * [Branch][google.cloud.retail.v2alpha.Branch]es are automatically created when
   * a [Catalog][google.cloud.retail.v2alpha.Catalog] is created. There are fixed
   * three branches in each catalog, and may use
   * [ListBranches][google.cloud.retail.v2alpha.BranchService.ListBranches] method
   * to get the details of all branches.
   * </pre>
   */
  public static final class BranchServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BranchServiceBlockingStub> {
    private BranchServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BranchServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BranchServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all [Branch][google.cloud.retail.v2alpha.Branch]s under the specified
     * parent [Catalog][google.cloud.retail.v2alpha.Catalog].
     * </pre>
     */
    public com.google.cloud.retail.v2alpha.ListBranchesResponse listBranches(
        com.google.cloud.retail.v2alpha.ListBranchesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBranchesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a [Branch][google.cloud.retail.v2alpha.Branch].
     * </pre>
     */
    public com.google.cloud.retail.v2alpha.Branch getBranch(
        com.google.cloud.retail.v2alpha.GetBranchRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBranchMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service BranchService.
   *
   * <pre>
   * Service for [Branch][google.cloud.retail.v2alpha.Branch] Management
   * [Branch][google.cloud.retail.v2alpha.Branch]es are automatically created when
   * a [Catalog][google.cloud.retail.v2alpha.Catalog] is created. There are fixed
   * three branches in each catalog, and may use
   * [ListBranches][google.cloud.retail.v2alpha.BranchService.ListBranches] method
   * to get the details of all branches.
   * </pre>
   */
  public static final class BranchServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<BranchServiceFutureStub> {
    private BranchServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BranchServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BranchServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all [Branch][google.cloud.retail.v2alpha.Branch]s under the specified
     * parent [Catalog][google.cloud.retail.v2alpha.Catalog].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2alpha.ListBranchesResponse>
        listBranches(com.google.cloud.retail.v2alpha.ListBranchesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBranchesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a [Branch][google.cloud.retail.v2alpha.Branch].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2alpha.Branch>
        getBranch(com.google.cloud.retail.v2alpha.GetBranchRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBranchMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_BRANCHES = 0;
  private static final int METHODID_GET_BRANCH = 1;

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
        case METHODID_LIST_BRANCHES:
          serviceImpl.listBranches(
              (com.google.cloud.retail.v2alpha.ListBranchesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.ListBranchesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_BRANCH:
          serviceImpl.getBranch(
              (com.google.cloud.retail.v2alpha.GetBranchRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.Branch>)
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
            getListBranchesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2alpha.ListBranchesRequest,
                    com.google.cloud.retail.v2alpha.ListBranchesResponse>(
                    service, METHODID_LIST_BRANCHES)))
        .addMethod(
            getGetBranchMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2alpha.GetBranchRequest,
                    com.google.cloud.retail.v2alpha.Branch>(service, METHODID_GET_BRANCH)))
        .build();
  }

  private abstract static class BranchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BranchServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.retail.v2alpha.BranchServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BranchService");
    }
  }

  private static final class BranchServiceFileDescriptorSupplier
      extends BranchServiceBaseDescriptorSupplier {
    BranchServiceFileDescriptorSupplier() {}
  }

  private static final class BranchServiceMethodDescriptorSupplier
      extends BranchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    BranchServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (BranchServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new BranchServiceFileDescriptorSupplier())
                      .addMethod(getListBranchesMethod())
                      .addMethod(getGetBranchMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
