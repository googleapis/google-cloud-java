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
 * Service for providing IAM Meta APIs for Cloud SQL.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class SqlIamPoliciesServiceGrpc {

  private SqlIamPoliciesServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.sql.v1.SqlIamPoliciesService";

  // Static method descriptors that strictly reflect the proto.
  /** Creates a new async stub that supports all call types for the service */
  public static SqlIamPoliciesServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlIamPoliciesServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlIamPoliciesServiceStub>() {
          @java.lang.Override
          public SqlIamPoliciesServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlIamPoliciesServiceStub(channel, callOptions);
          }
        };
    return SqlIamPoliciesServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SqlIamPoliciesServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlIamPoliciesServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlIamPoliciesServiceBlockingV2Stub>() {
          @java.lang.Override
          public SqlIamPoliciesServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlIamPoliciesServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return SqlIamPoliciesServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SqlIamPoliciesServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlIamPoliciesServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlIamPoliciesServiceBlockingStub>() {
          @java.lang.Override
          public SqlIamPoliciesServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlIamPoliciesServiceBlockingStub(channel, callOptions);
          }
        };
    return SqlIamPoliciesServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SqlIamPoliciesServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlIamPoliciesServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlIamPoliciesServiceFutureStub>() {
          @java.lang.Override
          public SqlIamPoliciesServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlIamPoliciesServiceFutureStub(channel, callOptions);
          }
        };
    return SqlIamPoliciesServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for providing IAM Meta APIs for Cloud SQL.
   * </pre>
   */
  public interface AsyncService {}

  /**
   * Base class for the server implementation of the service SqlIamPoliciesService.
   *
   * <pre>
   * Service for providing IAM Meta APIs for Cloud SQL.
   * </pre>
   */
  public abstract static class SqlIamPoliciesServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SqlIamPoliciesServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SqlIamPoliciesService.
   *
   * <pre>
   * Service for providing IAM Meta APIs for Cloud SQL.
   * </pre>
   */
  public static final class SqlIamPoliciesServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SqlIamPoliciesServiceStub> {
    private SqlIamPoliciesServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlIamPoliciesServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlIamPoliciesServiceStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SqlIamPoliciesService.
   *
   * <pre>
   * Service for providing IAM Meta APIs for Cloud SQL.
   * </pre>
   */
  public static final class SqlIamPoliciesServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SqlIamPoliciesServiceBlockingV2Stub> {
    private SqlIamPoliciesServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlIamPoliciesServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlIamPoliciesServiceBlockingV2Stub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service SqlIamPoliciesService.
   *
   * <pre>
   * Service for providing IAM Meta APIs for Cloud SQL.
   * </pre>
   */
  public static final class SqlIamPoliciesServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SqlIamPoliciesServiceBlockingStub> {
    private SqlIamPoliciesServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlIamPoliciesServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlIamPoliciesServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * SqlIamPoliciesService.
   *
   * <pre>
   * Service for providing IAM Meta APIs for Cloud SQL.
   * </pre>
   */
  public static final class SqlIamPoliciesServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SqlIamPoliciesServiceFutureStub> {
    private SqlIamPoliciesServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlIamPoliciesServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlIamPoliciesServiceFutureStub(channel, callOptions);
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

  private abstract static class SqlIamPoliciesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SqlIamPoliciesServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.sql.v1.CloudSqlIamPoliciesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SqlIamPoliciesService");
    }
  }

  private static final class SqlIamPoliciesServiceFileDescriptorSupplier
      extends SqlIamPoliciesServiceBaseDescriptorSupplier {
    SqlIamPoliciesServiceFileDescriptorSupplier() {}
  }

  private static final class SqlIamPoliciesServiceMethodDescriptorSupplier
      extends SqlIamPoliciesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SqlIamPoliciesServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SqlIamPoliciesServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SqlIamPoliciesServiceFileDescriptorSupplier())
                      .build();
        }
      }
    }
    return result;
  }
}
