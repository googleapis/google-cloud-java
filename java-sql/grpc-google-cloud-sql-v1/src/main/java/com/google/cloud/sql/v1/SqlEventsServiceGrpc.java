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
 * Service that exposes Cloud SQL event information. This
 * service is only used internally.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class SqlEventsServiceGrpc {

  private SqlEventsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.sql.v1.SqlEventsService";

  // Static method descriptors that strictly reflect the proto.
  /** Creates a new async stub that supports all call types for the service */
  public static SqlEventsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlEventsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlEventsServiceStub>() {
          @java.lang.Override
          public SqlEventsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlEventsServiceStub(channel, callOptions);
          }
        };
    return SqlEventsServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SqlEventsServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlEventsServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlEventsServiceBlockingV2Stub>() {
          @java.lang.Override
          public SqlEventsServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlEventsServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return SqlEventsServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SqlEventsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlEventsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlEventsServiceBlockingStub>() {
          @java.lang.Override
          public SqlEventsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlEventsServiceBlockingStub(channel, callOptions);
          }
        };
    return SqlEventsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SqlEventsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlEventsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlEventsServiceFutureStub>() {
          @java.lang.Override
          public SqlEventsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlEventsServiceFutureStub(channel, callOptions);
          }
        };
    return SqlEventsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service that exposes Cloud SQL event information. This
   * service is only used internally.
   * </pre>
   */
  public interface AsyncService {}

  /**
   * Base class for the server implementation of the service SqlEventsService.
   *
   * <pre>
   * Service that exposes Cloud SQL event information. This
   * service is only used internally.
   * </pre>
   */
  public abstract static class SqlEventsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SqlEventsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SqlEventsService.
   *
   * <pre>
   * Service that exposes Cloud SQL event information. This
   * service is only used internally.
   * </pre>
   */
  public static final class SqlEventsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SqlEventsServiceStub> {
    private SqlEventsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlEventsServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlEventsServiceStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SqlEventsService.
   *
   * <pre>
   * Service that exposes Cloud SQL event information. This
   * service is only used internally.
   * </pre>
   */
  public static final class SqlEventsServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SqlEventsServiceBlockingV2Stub> {
    private SqlEventsServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlEventsServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlEventsServiceBlockingV2Stub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service SqlEventsService.
   *
   * <pre>
   * Service that exposes Cloud SQL event information. This
   * service is only used internally.
   * </pre>
   */
  public static final class SqlEventsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SqlEventsServiceBlockingStub> {
    private SqlEventsServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlEventsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlEventsServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SqlEventsService.
   *
   * <pre>
   * Service that exposes Cloud SQL event information. This
   * service is only used internally.
   * </pre>
   */
  public static final class SqlEventsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SqlEventsServiceFutureStub> {
    private SqlEventsServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlEventsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlEventsServiceFutureStub(channel, callOptions);
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

  private abstract static class SqlEventsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SqlEventsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.sql.v1.CloudSqlEventsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SqlEventsService");
    }
  }

  private static final class SqlEventsServiceFileDescriptorSupplier
      extends SqlEventsServiceBaseDescriptorSupplier {
    SqlEventsServiceFileDescriptorSupplier() {}
  }

  private static final class SqlEventsServiceMethodDescriptorSupplier
      extends SqlEventsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SqlEventsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SqlEventsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SqlEventsServiceFileDescriptorSupplier())
                      .build();
        }
      }
    }
    return result;
  }
}
