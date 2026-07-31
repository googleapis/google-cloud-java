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
 * Service that exposes Cloud SQL region information. This service is only used
 * internally and does not follow the same patterns as the other v1 RPCs.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class SqlRegionsServiceGrpc {

  private SqlRegionsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.sql.v1.SqlRegionsService";

  // Static method descriptors that strictly reflect the proto.
  /** Creates a new async stub that supports all call types for the service */
  public static SqlRegionsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlRegionsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlRegionsServiceStub>() {
          @java.lang.Override
          public SqlRegionsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlRegionsServiceStub(channel, callOptions);
          }
        };
    return SqlRegionsServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SqlRegionsServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlRegionsServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlRegionsServiceBlockingV2Stub>() {
          @java.lang.Override
          public SqlRegionsServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlRegionsServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return SqlRegionsServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SqlRegionsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlRegionsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlRegionsServiceBlockingStub>() {
          @java.lang.Override
          public SqlRegionsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlRegionsServiceBlockingStub(channel, callOptions);
          }
        };
    return SqlRegionsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SqlRegionsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlRegionsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlRegionsServiceFutureStub>() {
          @java.lang.Override
          public SqlRegionsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlRegionsServiceFutureStub(channel, callOptions);
          }
        };
    return SqlRegionsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service that exposes Cloud SQL region information. This service is only used
   * internally and does not follow the same patterns as the other v1 RPCs.
   * </pre>
   */
  public interface AsyncService {}

  /**
   * Base class for the server implementation of the service SqlRegionsService.
   *
   * <pre>
   * Service that exposes Cloud SQL region information. This service is only used
   * internally and does not follow the same patterns as the other v1 RPCs.
   * </pre>
   */
  public abstract static class SqlRegionsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SqlRegionsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SqlRegionsService.
   *
   * <pre>
   * Service that exposes Cloud SQL region information. This service is only used
   * internally and does not follow the same patterns as the other v1 RPCs.
   * </pre>
   */
  public static final class SqlRegionsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SqlRegionsServiceStub> {
    private SqlRegionsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlRegionsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlRegionsServiceStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SqlRegionsService.
   *
   * <pre>
   * Service that exposes Cloud SQL region information. This service is only used
   * internally and does not follow the same patterns as the other v1 RPCs.
   * </pre>
   */
  public static final class SqlRegionsServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SqlRegionsServiceBlockingV2Stub> {
    private SqlRegionsServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlRegionsServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlRegionsServiceBlockingV2Stub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service SqlRegionsService.
   *
   * <pre>
   * Service that exposes Cloud SQL region information. This service is only used
   * internally and does not follow the same patterns as the other v1 RPCs.
   * </pre>
   */
  public static final class SqlRegionsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SqlRegionsServiceBlockingStub> {
    private SqlRegionsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlRegionsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlRegionsServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SqlRegionsService.
   *
   * <pre>
   * Service that exposes Cloud SQL region information. This service is only used
   * internally and does not follow the same patterns as the other v1 RPCs.
   * </pre>
   */
  public static final class SqlRegionsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SqlRegionsServiceFutureStub> {
    private SqlRegionsServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlRegionsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlRegionsServiceFutureStub(channel, callOptions);
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

  private abstract static class SqlRegionsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SqlRegionsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.sql.v1.CloudSqlRegionsServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SqlRegionsService");
    }
  }

  private static final class SqlRegionsServiceFileDescriptorSupplier
      extends SqlRegionsServiceBaseDescriptorSupplier {
    SqlRegionsServiceFileDescriptorSupplier() {}
  }

  private static final class SqlRegionsServiceMethodDescriptorSupplier
      extends SqlRegionsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SqlRegionsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SqlRegionsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SqlRegionsServiceFileDescriptorSupplier())
                      .build();
        }
      }
    }
    return result;
  }
}
