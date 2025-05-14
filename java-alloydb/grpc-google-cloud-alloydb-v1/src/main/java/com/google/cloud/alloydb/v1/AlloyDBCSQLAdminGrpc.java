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
package com.google.cloud.alloydb.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for interactions with CloudSQL.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/alloydb/v1/csql_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AlloyDBCSQLAdminGrpc {

  private AlloyDBCSQLAdminGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.alloydb.v1.AlloyDBCSQLAdmin";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1.RestoreFromCloudSQLRequest, com.google.longrunning.Operation>
      getRestoreFromCloudSQLMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestoreFromCloudSQL",
      requestType = com.google.cloud.alloydb.v1.RestoreFromCloudSQLRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1.RestoreFromCloudSQLRequest, com.google.longrunning.Operation>
      getRestoreFromCloudSQLMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1.RestoreFromCloudSQLRequest,
            com.google.longrunning.Operation>
        getRestoreFromCloudSQLMethod;
    if ((getRestoreFromCloudSQLMethod = AlloyDBCSQLAdminGrpc.getRestoreFromCloudSQLMethod)
        == null) {
      synchronized (AlloyDBCSQLAdminGrpc.class) {
        if ((getRestoreFromCloudSQLMethod = AlloyDBCSQLAdminGrpc.getRestoreFromCloudSQLMethod)
            == null) {
          AlloyDBCSQLAdminGrpc.getRestoreFromCloudSQLMethod =
              getRestoreFromCloudSQLMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1.RestoreFromCloudSQLRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RestoreFromCloudSQL"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1.RestoreFromCloudSQLRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBCSQLAdminMethodDescriptorSupplier("RestoreFromCloudSQL"))
                      .build();
        }
      }
    }
    return getRestoreFromCloudSQLMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AlloyDBCSQLAdminStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlloyDBCSQLAdminStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AlloyDBCSQLAdminStub>() {
          @java.lang.Override
          public AlloyDBCSQLAdminStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AlloyDBCSQLAdminStub(channel, callOptions);
          }
        };
    return AlloyDBCSQLAdminStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static AlloyDBCSQLAdminBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlloyDBCSQLAdminBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AlloyDBCSQLAdminBlockingV2Stub>() {
          @java.lang.Override
          public AlloyDBCSQLAdminBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AlloyDBCSQLAdminBlockingV2Stub(channel, callOptions);
          }
        };
    return AlloyDBCSQLAdminBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AlloyDBCSQLAdminBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlloyDBCSQLAdminBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AlloyDBCSQLAdminBlockingStub>() {
          @java.lang.Override
          public AlloyDBCSQLAdminBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AlloyDBCSQLAdminBlockingStub(channel, callOptions);
          }
        };
    return AlloyDBCSQLAdminBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AlloyDBCSQLAdminFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlloyDBCSQLAdminFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AlloyDBCSQLAdminFutureStub>() {
          @java.lang.Override
          public AlloyDBCSQLAdminFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AlloyDBCSQLAdminFutureStub(channel, callOptions);
          }
        };
    return AlloyDBCSQLAdminFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for interactions with CloudSQL.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Restores an AlloyDB cluster from a CloudSQL resource.
     * </pre>
     */
    default void restoreFromCloudSQL(
        com.google.cloud.alloydb.v1.RestoreFromCloudSQLRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRestoreFromCloudSQLMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AlloyDBCSQLAdmin.
   *
   * <pre>
   * Service for interactions with CloudSQL.
   * </pre>
   */
  public abstract static class AlloyDBCSQLAdminImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AlloyDBCSQLAdminGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AlloyDBCSQLAdmin.
   *
   * <pre>
   * Service for interactions with CloudSQL.
   * </pre>
   */
  public static final class AlloyDBCSQLAdminStub
      extends io.grpc.stub.AbstractAsyncStub<AlloyDBCSQLAdminStub> {
    private AlloyDBCSQLAdminStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlloyDBCSQLAdminStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlloyDBCSQLAdminStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Restores an AlloyDB cluster from a CloudSQL resource.
     * </pre>
     */
    public void restoreFromCloudSQL(
        com.google.cloud.alloydb.v1.RestoreFromCloudSQLRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestoreFromCloudSQLMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AlloyDBCSQLAdmin.
   *
   * <pre>
   * Service for interactions with CloudSQL.
   * </pre>
   */
  public static final class AlloyDBCSQLAdminBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AlloyDBCSQLAdminBlockingV2Stub> {
    private AlloyDBCSQLAdminBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlloyDBCSQLAdminBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlloyDBCSQLAdminBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Restores an AlloyDB cluster from a CloudSQL resource.
     * </pre>
     */
    public com.google.longrunning.Operation restoreFromCloudSQL(
        com.google.cloud.alloydb.v1.RestoreFromCloudSQLRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestoreFromCloudSQLMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service AlloyDBCSQLAdmin.
   *
   * <pre>
   * Service for interactions with CloudSQL.
   * </pre>
   */
  public static final class AlloyDBCSQLAdminBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AlloyDBCSQLAdminBlockingStub> {
    private AlloyDBCSQLAdminBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlloyDBCSQLAdminBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlloyDBCSQLAdminBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Restores an AlloyDB cluster from a CloudSQL resource.
     * </pre>
     */
    public com.google.longrunning.Operation restoreFromCloudSQL(
        com.google.cloud.alloydb.v1.RestoreFromCloudSQLRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestoreFromCloudSQLMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AlloyDBCSQLAdmin.
   *
   * <pre>
   * Service for interactions with CloudSQL.
   * </pre>
   */
  public static final class AlloyDBCSQLAdminFutureStub
      extends io.grpc.stub.AbstractFutureStub<AlloyDBCSQLAdminFutureStub> {
    private AlloyDBCSQLAdminFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlloyDBCSQLAdminFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlloyDBCSQLAdminFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Restores an AlloyDB cluster from a CloudSQL resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        restoreFromCloudSQL(com.google.cloud.alloydb.v1.RestoreFromCloudSQLRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestoreFromCloudSQLMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RESTORE_FROM_CLOUD_SQL = 0;

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
        case METHODID_RESTORE_FROM_CLOUD_SQL:
          serviceImpl.restoreFromCloudSQL(
              (com.google.cloud.alloydb.v1.RestoreFromCloudSQLRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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
            getRestoreFromCloudSQLMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1.RestoreFromCloudSQLRequest,
                    com.google.longrunning.Operation>(service, METHODID_RESTORE_FROM_CLOUD_SQL)))
        .build();
  }

  private abstract static class AlloyDBCSQLAdminBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AlloyDBCSQLAdminBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.alloydb.v1.CSQLServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AlloyDBCSQLAdmin");
    }
  }

  private static final class AlloyDBCSQLAdminFileDescriptorSupplier
      extends AlloyDBCSQLAdminBaseDescriptorSupplier {
    AlloyDBCSQLAdminFileDescriptorSupplier() {}
  }

  private static final class AlloyDBCSQLAdminMethodDescriptorSupplier
      extends AlloyDBCSQLAdminBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AlloyDBCSQLAdminMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AlloyDBCSQLAdminGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AlloyDBCSQLAdminFileDescriptorSupplier())
                      .addMethod(getRestoreFromCloudSQLMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
