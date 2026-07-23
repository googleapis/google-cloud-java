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
 * Service to verify the eligibility of an instance for a given operation.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class SqlFeatureEligibilityServiceGrpc {

  private SqlFeatureEligibilityServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.sql.v1.SqlFeatureEligibilityService";

  // Static method descriptors that strictly reflect the proto.
  /** Creates a new async stub that supports all call types for the service */
  public static SqlFeatureEligibilityServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlFeatureEligibilityServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlFeatureEligibilityServiceStub>() {
          @java.lang.Override
          public SqlFeatureEligibilityServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlFeatureEligibilityServiceStub(channel, callOptions);
          }
        };
    return SqlFeatureEligibilityServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SqlFeatureEligibilityServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlFeatureEligibilityServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlFeatureEligibilityServiceBlockingV2Stub>() {
          @java.lang.Override
          public SqlFeatureEligibilityServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlFeatureEligibilityServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return SqlFeatureEligibilityServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SqlFeatureEligibilityServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlFeatureEligibilityServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlFeatureEligibilityServiceBlockingStub>() {
          @java.lang.Override
          public SqlFeatureEligibilityServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlFeatureEligibilityServiceBlockingStub(channel, callOptions);
          }
        };
    return SqlFeatureEligibilityServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SqlFeatureEligibilityServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlFeatureEligibilityServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlFeatureEligibilityServiceFutureStub>() {
          @java.lang.Override
          public SqlFeatureEligibilityServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlFeatureEligibilityServiceFutureStub(channel, callOptions);
          }
        };
    return SqlFeatureEligibilityServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to verify the eligibility of an instance for a given operation.
   * </pre>
   */
  public interface AsyncService {}

  /**
   * Base class for the server implementation of the service SqlFeatureEligibilityService.
   *
   * <pre>
   * Service to verify the eligibility of an instance for a given operation.
   * </pre>
   */
  public abstract static class SqlFeatureEligibilityServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SqlFeatureEligibilityServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SqlFeatureEligibilityService.
   *
   * <pre>
   * Service to verify the eligibility of an instance for a given operation.
   * </pre>
   */
  public static final class SqlFeatureEligibilityServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SqlFeatureEligibilityServiceStub> {
    private SqlFeatureEligibilityServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlFeatureEligibilityServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlFeatureEligibilityServiceStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SqlFeatureEligibilityService.
   *
   * <pre>
   * Service to verify the eligibility of an instance for a given operation.
   * </pre>
   */
  public static final class SqlFeatureEligibilityServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SqlFeatureEligibilityServiceBlockingV2Stub> {
    private SqlFeatureEligibilityServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlFeatureEligibilityServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlFeatureEligibilityServiceBlockingV2Stub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * SqlFeatureEligibilityService.
   *
   * <pre>
   * Service to verify the eligibility of an instance for a given operation.
   * </pre>
   */
  public static final class SqlFeatureEligibilityServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SqlFeatureEligibilityServiceBlockingStub> {
    private SqlFeatureEligibilityServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlFeatureEligibilityServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlFeatureEligibilityServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * SqlFeatureEligibilityService.
   *
   * <pre>
   * Service to verify the eligibility of an instance for a given operation.
   * </pre>
   */
  public static final class SqlFeatureEligibilityServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SqlFeatureEligibilityServiceFutureStub> {
    private SqlFeatureEligibilityServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlFeatureEligibilityServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlFeatureEligibilityServiceFutureStub(channel, callOptions);
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

  private abstract static class SqlFeatureEligibilityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SqlFeatureEligibilityServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.sql.v1.CloudSqlFeatureEligibilityProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SqlFeatureEligibilityService");
    }
  }

  private static final class SqlFeatureEligibilityServiceFileDescriptorSupplier
      extends SqlFeatureEligibilityServiceBaseDescriptorSupplier {
    SqlFeatureEligibilityServiceFileDescriptorSupplier() {}
  }

  private static final class SqlFeatureEligibilityServiceMethodDescriptorSupplier
      extends SqlFeatureEligibilityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SqlFeatureEligibilityServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SqlFeatureEligibilityServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SqlFeatureEligibilityServiceFileDescriptorSupplier())
                      .build();
        }
      }
    }
    return result;
  }
}
