/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.sql.v1;


/**
 *
 *
 * <pre>
 * Cloud SQL instance names service.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class SqlInstanceNamesServiceGrpc {

  private SqlInstanceNamesServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.sql.v1.SqlInstanceNamesService";

  // Static method descriptors that strictly reflect the proto.
  /** Creates a new async stub that supports all call types for the service */
  public static SqlInstanceNamesServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlInstanceNamesServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlInstanceNamesServiceStub>() {
          @java.lang.Override
          public SqlInstanceNamesServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlInstanceNamesServiceStub(channel, callOptions);
          }
        };
    return SqlInstanceNamesServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SqlInstanceNamesServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlInstanceNamesServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlInstanceNamesServiceBlockingV2Stub>() {
          @java.lang.Override
          public SqlInstanceNamesServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlInstanceNamesServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return SqlInstanceNamesServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SqlInstanceNamesServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlInstanceNamesServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlInstanceNamesServiceBlockingStub>() {
          @java.lang.Override
          public SqlInstanceNamesServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlInstanceNamesServiceBlockingStub(channel, callOptions);
          }
        };
    return SqlInstanceNamesServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SqlInstanceNamesServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlInstanceNamesServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlInstanceNamesServiceFutureStub>() {
          @java.lang.Override
          public SqlInstanceNamesServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlInstanceNamesServiceFutureStub(channel, callOptions);
          }
        };
    return SqlInstanceNamesServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Cloud SQL instance names service.
   * </pre>
   */
  public interface AsyncService {}

  /**
   * Base class for the server implementation of the service SqlInstanceNamesService.
   *
   * <pre>
   * Cloud SQL instance names service.
   * </pre>
   */
  public abstract static class SqlInstanceNamesServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SqlInstanceNamesServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SqlInstanceNamesService.
   *
   * <pre>
   * Cloud SQL instance names service.
   * </pre>
   */
  public static final class SqlInstanceNamesServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SqlInstanceNamesServiceStub> {
    private SqlInstanceNamesServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlInstanceNamesServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlInstanceNamesServiceStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SqlInstanceNamesService.
   *
   * <pre>
   * Cloud SQL instance names service.
   * </pre>
   */
  public static final class SqlInstanceNamesServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SqlInstanceNamesServiceBlockingV2Stub> {
    private SqlInstanceNamesServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlInstanceNamesServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlInstanceNamesServiceBlockingV2Stub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service SqlInstanceNamesService.
   *
   * <pre>
   * Cloud SQL instance names service.
   * </pre>
   */
  public static final class SqlInstanceNamesServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SqlInstanceNamesServiceBlockingStub> {
    private SqlInstanceNamesServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlInstanceNamesServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlInstanceNamesServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * SqlInstanceNamesService.
   *
   * <pre>
   * Cloud SQL instance names service.
   * </pre>
   */
  public static final class SqlInstanceNamesServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SqlInstanceNamesServiceFutureStub> {
    private SqlInstanceNamesServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlInstanceNamesServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlInstanceNamesServiceFutureStub(channel, callOptions);
    }
  }

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
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor()).build();
  }

  private abstract static class SqlInstanceNamesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SqlInstanceNamesServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.sql.v1.CloudSqlInstanceNamesServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SqlInstanceNamesService");
    }
  }

  private static final class SqlInstanceNamesServiceFileDescriptorSupplier
      extends SqlInstanceNamesServiceBaseDescriptorSupplier {
    SqlInstanceNamesServiceFileDescriptorSupplier() {}
  }

  private static final class SqlInstanceNamesServiceMethodDescriptorSupplier
      extends SqlInstanceNamesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SqlInstanceNamesServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SqlInstanceNamesServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SqlInstanceNamesServiceFileDescriptorSupplier())
                      .build();
        }
      }
    }
    return result;
  }
}
