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
package com.google.cloud.chronicle.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing BigQuery export configurations for Chronicle instances.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class BigQueryExportServiceGrpc {

  private BigQueryExportServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.chronicle.v1.BigQueryExportService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetBigQueryExportRequest,
          com.google.cloud.chronicle.v1.BigQueryExport>
      getGetBigQueryExportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBigQueryExport",
      requestType = com.google.cloud.chronicle.v1.GetBigQueryExportRequest.class,
      responseType = com.google.cloud.chronicle.v1.BigQueryExport.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetBigQueryExportRequest,
          com.google.cloud.chronicle.v1.BigQueryExport>
      getGetBigQueryExportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.GetBigQueryExportRequest,
            com.google.cloud.chronicle.v1.BigQueryExport>
        getGetBigQueryExportMethod;
    if ((getGetBigQueryExportMethod = BigQueryExportServiceGrpc.getGetBigQueryExportMethod)
        == null) {
      synchronized (BigQueryExportServiceGrpc.class) {
        if ((getGetBigQueryExportMethod = BigQueryExportServiceGrpc.getGetBigQueryExportMethod)
            == null) {
          BigQueryExportServiceGrpc.getGetBigQueryExportMethod =
              getGetBigQueryExportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.GetBigQueryExportRequest,
                          com.google.cloud.chronicle.v1.BigQueryExport>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBigQueryExport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.GetBigQueryExportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.BigQueryExport.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigQueryExportServiceMethodDescriptorSupplier("GetBigQueryExport"))
                      .build();
        }
      }
    }
    return getGetBigQueryExportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.UpdateBigQueryExportRequest,
          com.google.cloud.chronicle.v1.BigQueryExport>
      getUpdateBigQueryExportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBigQueryExport",
      requestType = com.google.cloud.chronicle.v1.UpdateBigQueryExportRequest.class,
      responseType = com.google.cloud.chronicle.v1.BigQueryExport.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.UpdateBigQueryExportRequest,
          com.google.cloud.chronicle.v1.BigQueryExport>
      getUpdateBigQueryExportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.UpdateBigQueryExportRequest,
            com.google.cloud.chronicle.v1.BigQueryExport>
        getUpdateBigQueryExportMethod;
    if ((getUpdateBigQueryExportMethod = BigQueryExportServiceGrpc.getUpdateBigQueryExportMethod)
        == null) {
      synchronized (BigQueryExportServiceGrpc.class) {
        if ((getUpdateBigQueryExportMethod =
                BigQueryExportServiceGrpc.getUpdateBigQueryExportMethod)
            == null) {
          BigQueryExportServiceGrpc.getUpdateBigQueryExportMethod =
              getUpdateBigQueryExportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.UpdateBigQueryExportRequest,
                          com.google.cloud.chronicle.v1.BigQueryExport>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateBigQueryExport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.UpdateBigQueryExportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.BigQueryExport.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigQueryExportServiceMethodDescriptorSupplier("UpdateBigQueryExport"))
                      .build();
        }
      }
    }
    return getUpdateBigQueryExportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ProvisionBigQueryExportRequest,
          com.google.cloud.chronicle.v1.BigQueryExport>
      getProvisionBigQueryExportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProvisionBigQueryExport",
      requestType = com.google.cloud.chronicle.v1.ProvisionBigQueryExportRequest.class,
      responseType = com.google.cloud.chronicle.v1.BigQueryExport.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ProvisionBigQueryExportRequest,
          com.google.cloud.chronicle.v1.BigQueryExport>
      getProvisionBigQueryExportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.ProvisionBigQueryExportRequest,
            com.google.cloud.chronicle.v1.BigQueryExport>
        getProvisionBigQueryExportMethod;
    if ((getProvisionBigQueryExportMethod =
            BigQueryExportServiceGrpc.getProvisionBigQueryExportMethod)
        == null) {
      synchronized (BigQueryExportServiceGrpc.class) {
        if ((getProvisionBigQueryExportMethod =
                BigQueryExportServiceGrpc.getProvisionBigQueryExportMethod)
            == null) {
          BigQueryExportServiceGrpc.getProvisionBigQueryExportMethod =
              getProvisionBigQueryExportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.ProvisionBigQueryExportRequest,
                          com.google.cloud.chronicle.v1.BigQueryExport>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ProvisionBigQueryExport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ProvisionBigQueryExportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.BigQueryExport.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigQueryExportServiceMethodDescriptorSupplier(
                              "ProvisionBigQueryExport"))
                      .build();
        }
      }
    }
    return getProvisionBigQueryExportMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static BigQueryExportServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BigQueryExportServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BigQueryExportServiceStub>() {
          @java.lang.Override
          public BigQueryExportServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BigQueryExportServiceStub(channel, callOptions);
          }
        };
    return BigQueryExportServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static BigQueryExportServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BigQueryExportServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BigQueryExportServiceBlockingV2Stub>() {
          @java.lang.Override
          public BigQueryExportServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BigQueryExportServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return BigQueryExportServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BigQueryExportServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BigQueryExportServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BigQueryExportServiceBlockingStub>() {
          @java.lang.Override
          public BigQueryExportServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BigQueryExportServiceBlockingStub(channel, callOptions);
          }
        };
    return BigQueryExportServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static BigQueryExportServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BigQueryExportServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BigQueryExportServiceFutureStub>() {
          @java.lang.Override
          public BigQueryExportServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BigQueryExportServiceFutureStub(channel, callOptions);
          }
        };
    return BigQueryExportServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing BigQuery export configurations for Chronicle instances.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Get the BigQuery export configuration for a Chronicle instance.
     * </pre>
     */
    default void getBigQueryExport(
        com.google.cloud.chronicle.v1.GetBigQueryExportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.BigQueryExport>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetBigQueryExportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the BigQuery export configuration for a Chronicle instance.
     * </pre>
     */
    default void updateBigQueryExport(
        com.google.cloud.chronicle.v1.UpdateBigQueryExportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.BigQueryExport>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBigQueryExportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Provision the BigQuery export for a Chronicle instance. This will create
     * {{gcp_name}} resources like {{storage_name}} buckets, BigQuery datasets
     * and set default export settings for each data source.
     * </pre>
     */
    default void provisionBigQueryExport(
        com.google.cloud.chronicle.v1.ProvisionBigQueryExportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.BigQueryExport>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getProvisionBigQueryExportMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service BigQueryExportService.
   *
   * <pre>
   * Service for managing BigQuery export configurations for Chronicle instances.
   * </pre>
   */
  public abstract static class BigQueryExportServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return BigQueryExportServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service BigQueryExportService.
   *
   * <pre>
   * Service for managing BigQuery export configurations for Chronicle instances.
   * </pre>
   */
  public static final class BigQueryExportServiceStub
      extends io.grpc.stub.AbstractAsyncStub<BigQueryExportServiceStub> {
    private BigQueryExportServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BigQueryExportServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BigQueryExportServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get the BigQuery export configuration for a Chronicle instance.
     * </pre>
     */
    public void getBigQueryExport(
        com.google.cloud.chronicle.v1.GetBigQueryExportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.BigQueryExport>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBigQueryExportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the BigQuery export configuration for a Chronicle instance.
     * </pre>
     */
    public void updateBigQueryExport(
        com.google.cloud.chronicle.v1.UpdateBigQueryExportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.BigQueryExport>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBigQueryExportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Provision the BigQuery export for a Chronicle instance. This will create
     * {{gcp_name}} resources like {{storage_name}} buckets, BigQuery datasets
     * and set default export settings for each data source.
     * </pre>
     */
    public void provisionBigQueryExport(
        com.google.cloud.chronicle.v1.ProvisionBigQueryExportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.BigQueryExport>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProvisionBigQueryExportMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service BigQueryExportService.
   *
   * <pre>
   * Service for managing BigQuery export configurations for Chronicle instances.
   * </pre>
   */
  public static final class BigQueryExportServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<BigQueryExportServiceBlockingV2Stub> {
    private BigQueryExportServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BigQueryExportServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BigQueryExportServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get the BigQuery export configuration for a Chronicle instance.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.BigQueryExport getBigQueryExport(
        com.google.cloud.chronicle.v1.GetBigQueryExportRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetBigQueryExportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update the BigQuery export configuration for a Chronicle instance.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.BigQueryExport updateBigQueryExport(
        com.google.cloud.chronicle.v1.UpdateBigQueryExportRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateBigQueryExportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Provision the BigQuery export for a Chronicle instance. This will create
     * {{gcp_name}} resources like {{storage_name}} buckets, BigQuery datasets
     * and set default export settings for each data source.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.BigQueryExport provisionBigQueryExport(
        com.google.cloud.chronicle.v1.ProvisionBigQueryExportRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getProvisionBigQueryExportMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service BigQueryExportService.
   *
   * <pre>
   * Service for managing BigQuery export configurations for Chronicle instances.
   * </pre>
   */
  public static final class BigQueryExportServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BigQueryExportServiceBlockingStub> {
    private BigQueryExportServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BigQueryExportServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BigQueryExportServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get the BigQuery export configuration for a Chronicle instance.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.BigQueryExport getBigQueryExport(
        com.google.cloud.chronicle.v1.GetBigQueryExportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBigQueryExportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update the BigQuery export configuration for a Chronicle instance.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.BigQueryExport updateBigQueryExport(
        com.google.cloud.chronicle.v1.UpdateBigQueryExportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBigQueryExportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Provision the BigQuery export for a Chronicle instance. This will create
     * {{gcp_name}} resources like {{storage_name}} buckets, BigQuery datasets
     * and set default export settings for each data source.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.BigQueryExport provisionBigQueryExport(
        com.google.cloud.chronicle.v1.ProvisionBigQueryExportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProvisionBigQueryExportMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * BigQueryExportService.
   *
   * <pre>
   * Service for managing BigQuery export configurations for Chronicle instances.
   * </pre>
   */
  public static final class BigQueryExportServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<BigQueryExportServiceFutureStub> {
    private BigQueryExportServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BigQueryExportServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BigQueryExportServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get the BigQuery export configuration for a Chronicle instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.BigQueryExport>
        getBigQueryExport(com.google.cloud.chronicle.v1.GetBigQueryExportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBigQueryExportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update the BigQuery export configuration for a Chronicle instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.BigQueryExport>
        updateBigQueryExport(com.google.cloud.chronicle.v1.UpdateBigQueryExportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBigQueryExportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Provision the BigQuery export for a Chronicle instance. This will create
     * {{gcp_name}} resources like {{storage_name}} buckets, BigQuery datasets
     * and set default export settings for each data source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.BigQueryExport>
        provisionBigQueryExport(
            com.google.cloud.chronicle.v1.ProvisionBigQueryExportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProvisionBigQueryExportMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_BIG_QUERY_EXPORT = 0;
  private static final int METHODID_UPDATE_BIG_QUERY_EXPORT = 1;
  private static final int METHODID_PROVISION_BIG_QUERY_EXPORT = 2;

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
        case METHODID_GET_BIG_QUERY_EXPORT:
          serviceImpl.getBigQueryExport(
              (com.google.cloud.chronicle.v1.GetBigQueryExportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.BigQueryExport>)
                  responseObserver);
          break;
        case METHODID_UPDATE_BIG_QUERY_EXPORT:
          serviceImpl.updateBigQueryExport(
              (com.google.cloud.chronicle.v1.UpdateBigQueryExportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.BigQueryExport>)
                  responseObserver);
          break;
        case METHODID_PROVISION_BIG_QUERY_EXPORT:
          serviceImpl.provisionBigQueryExport(
              (com.google.cloud.chronicle.v1.ProvisionBigQueryExportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.BigQueryExport>)
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
            getGetBigQueryExportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.GetBigQueryExportRequest,
                    com.google.cloud.chronicle.v1.BigQueryExport>(
                    service, METHODID_GET_BIG_QUERY_EXPORT)))
        .addMethod(
            getUpdateBigQueryExportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.UpdateBigQueryExportRequest,
                    com.google.cloud.chronicle.v1.BigQueryExport>(
                    service, METHODID_UPDATE_BIG_QUERY_EXPORT)))
        .addMethod(
            getProvisionBigQueryExportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.ProvisionBigQueryExportRequest,
                    com.google.cloud.chronicle.v1.BigQueryExport>(
                    service, METHODID_PROVISION_BIG_QUERY_EXPORT)))
        .build();
  }

  private abstract static class BigQueryExportServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BigQueryExportServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.chronicle.v1.BigQueryExportProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BigQueryExportService");
    }
  }

  private static final class BigQueryExportServiceFileDescriptorSupplier
      extends BigQueryExportServiceBaseDescriptorSupplier {
    BigQueryExportServiceFileDescriptorSupplier() {}
  }

  private static final class BigQueryExportServiceMethodDescriptorSupplier
      extends BigQueryExportServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    BigQueryExportServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (BigQueryExportServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new BigQueryExportServiceFileDescriptorSupplier())
                      .addMethod(getGetBigQueryExportMethod())
                      .addMethod(getUpdateBigQueryExportMethod())
                      .addMethod(getProvisionBigQueryExportMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
