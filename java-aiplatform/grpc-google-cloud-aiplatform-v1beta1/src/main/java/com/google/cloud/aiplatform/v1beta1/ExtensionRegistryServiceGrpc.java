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
package com.google.cloud.aiplatform.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service for managing Vertex AI's Extension registry.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1beta1/extension_registry_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ExtensionRegistryServiceGrpc {

  private ExtensionRegistryServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.aiplatform.v1beta1.ExtensionRegistryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ImportExtensionRequest,
          com.google.longrunning.Operation>
      getImportExtensionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportExtension",
      requestType = com.google.cloud.aiplatform.v1beta1.ImportExtensionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ImportExtensionRequest,
          com.google.longrunning.Operation>
      getImportExtensionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ImportExtensionRequest,
            com.google.longrunning.Operation>
        getImportExtensionMethod;
    if ((getImportExtensionMethod = ExtensionRegistryServiceGrpc.getImportExtensionMethod)
        == null) {
      synchronized (ExtensionRegistryServiceGrpc.class) {
        if ((getImportExtensionMethod = ExtensionRegistryServiceGrpc.getImportExtensionMethod)
            == null) {
          ExtensionRegistryServiceGrpc.getImportExtensionMethod =
              getImportExtensionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ImportExtensionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportExtension"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ImportExtensionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ExtensionRegistryServiceMethodDescriptorSupplier("ImportExtension"))
                      .build();
        }
      }
    }
    return getImportExtensionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetExtensionRequest,
          com.google.cloud.aiplatform.v1beta1.Extension>
      getGetExtensionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetExtension",
      requestType = com.google.cloud.aiplatform.v1beta1.GetExtensionRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.Extension.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetExtensionRequest,
          com.google.cloud.aiplatform.v1beta1.Extension>
      getGetExtensionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetExtensionRequest,
            com.google.cloud.aiplatform.v1beta1.Extension>
        getGetExtensionMethod;
    if ((getGetExtensionMethod = ExtensionRegistryServiceGrpc.getGetExtensionMethod) == null) {
      synchronized (ExtensionRegistryServiceGrpc.class) {
        if ((getGetExtensionMethod = ExtensionRegistryServiceGrpc.getGetExtensionMethod) == null) {
          ExtensionRegistryServiceGrpc.getGetExtensionMethod =
              getGetExtensionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetExtensionRequest,
                          com.google.cloud.aiplatform.v1beta1.Extension>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetExtension"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetExtensionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.Extension.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ExtensionRegistryServiceMethodDescriptorSupplier("GetExtension"))
                      .build();
        }
      }
    }
    return getGetExtensionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListExtensionsRequest,
          com.google.cloud.aiplatform.v1beta1.ListExtensionsResponse>
      getListExtensionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListExtensions",
      requestType = com.google.cloud.aiplatform.v1beta1.ListExtensionsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListExtensionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListExtensionsRequest,
          com.google.cloud.aiplatform.v1beta1.ListExtensionsResponse>
      getListExtensionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListExtensionsRequest,
            com.google.cloud.aiplatform.v1beta1.ListExtensionsResponse>
        getListExtensionsMethod;
    if ((getListExtensionsMethod = ExtensionRegistryServiceGrpc.getListExtensionsMethod) == null) {
      synchronized (ExtensionRegistryServiceGrpc.class) {
        if ((getListExtensionsMethod = ExtensionRegistryServiceGrpc.getListExtensionsMethod)
            == null) {
          ExtensionRegistryServiceGrpc.getListExtensionsMethod =
              getListExtensionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListExtensionsRequest,
                          com.google.cloud.aiplatform.v1beta1.ListExtensionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListExtensions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListExtensionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListExtensionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ExtensionRegistryServiceMethodDescriptorSupplier("ListExtensions"))
                      .build();
        }
      }
    }
    return getListExtensionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateExtensionRequest,
          com.google.cloud.aiplatform.v1beta1.Extension>
      getUpdateExtensionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateExtension",
      requestType = com.google.cloud.aiplatform.v1beta1.UpdateExtensionRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.Extension.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateExtensionRequest,
          com.google.cloud.aiplatform.v1beta1.Extension>
      getUpdateExtensionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.UpdateExtensionRequest,
            com.google.cloud.aiplatform.v1beta1.Extension>
        getUpdateExtensionMethod;
    if ((getUpdateExtensionMethod = ExtensionRegistryServiceGrpc.getUpdateExtensionMethod)
        == null) {
      synchronized (ExtensionRegistryServiceGrpc.class) {
        if ((getUpdateExtensionMethod = ExtensionRegistryServiceGrpc.getUpdateExtensionMethod)
            == null) {
          ExtensionRegistryServiceGrpc.getUpdateExtensionMethod =
              getUpdateExtensionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.UpdateExtensionRequest,
                          com.google.cloud.aiplatform.v1beta1.Extension>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateExtension"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UpdateExtensionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.Extension.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ExtensionRegistryServiceMethodDescriptorSupplier("UpdateExtension"))
                      .build();
        }
      }
    }
    return getUpdateExtensionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteExtensionRequest,
          com.google.longrunning.Operation>
      getDeleteExtensionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteExtension",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteExtensionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteExtensionRequest,
          com.google.longrunning.Operation>
      getDeleteExtensionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteExtensionRequest,
            com.google.longrunning.Operation>
        getDeleteExtensionMethod;
    if ((getDeleteExtensionMethod = ExtensionRegistryServiceGrpc.getDeleteExtensionMethod)
        == null) {
      synchronized (ExtensionRegistryServiceGrpc.class) {
        if ((getDeleteExtensionMethod = ExtensionRegistryServiceGrpc.getDeleteExtensionMethod)
            == null) {
          ExtensionRegistryServiceGrpc.getDeleteExtensionMethod =
              getDeleteExtensionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteExtensionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteExtension"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteExtensionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ExtensionRegistryServiceMethodDescriptorSupplier("DeleteExtension"))
                      .build();
        }
      }
    }
    return getDeleteExtensionMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ExtensionRegistryServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExtensionRegistryServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ExtensionRegistryServiceStub>() {
          @java.lang.Override
          public ExtensionRegistryServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ExtensionRegistryServiceStub(channel, callOptions);
          }
        };
    return ExtensionRegistryServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ExtensionRegistryServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExtensionRegistryServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ExtensionRegistryServiceBlockingStub>() {
          @java.lang.Override
          public ExtensionRegistryServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ExtensionRegistryServiceBlockingStub(channel, callOptions);
          }
        };
    return ExtensionRegistryServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ExtensionRegistryServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExtensionRegistryServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ExtensionRegistryServiceFutureStub>() {
          @java.lang.Override
          public ExtensionRegistryServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ExtensionRegistryServiceFutureStub(channel, callOptions);
          }
        };
    return ExtensionRegistryServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service for managing Vertex AI's Extension registry.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Imports an Extension.
     * </pre>
     */
    default void importExtension(
        com.google.cloud.aiplatform.v1beta1.ImportExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportExtensionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an Extension.
     * </pre>
     */
    default void getExtension(
        com.google.cloud.aiplatform.v1beta1.GetExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Extension>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetExtensionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Extensions in a location.
     * </pre>
     */
    default void listExtensions(
        com.google.cloud.aiplatform.v1beta1.ListExtensionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListExtensionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListExtensionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an Extension.
     * </pre>
     */
    default void updateExtension(
        com.google.cloud.aiplatform.v1beta1.UpdateExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Extension>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateExtensionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Extension.
     * </pre>
     */
    default void deleteExtension(
        com.google.cloud.aiplatform.v1beta1.DeleteExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteExtensionMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ExtensionRegistryService.
   *
   * <pre>
   * A service for managing Vertex AI's Extension registry.
   * </pre>
   */
  public abstract static class ExtensionRegistryServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ExtensionRegistryServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ExtensionRegistryService.
   *
   * <pre>
   * A service for managing Vertex AI's Extension registry.
   * </pre>
   */
  public static final class ExtensionRegistryServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ExtensionRegistryServiceStub> {
    private ExtensionRegistryServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExtensionRegistryServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExtensionRegistryServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Imports an Extension.
     * </pre>
     */
    public void importExtension(
        com.google.cloud.aiplatform.v1beta1.ImportExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportExtensionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an Extension.
     * </pre>
     */
    public void getExtension(
        com.google.cloud.aiplatform.v1beta1.GetExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Extension>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetExtensionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Extensions in a location.
     * </pre>
     */
    public void listExtensions(
        com.google.cloud.aiplatform.v1beta1.ListExtensionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListExtensionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListExtensionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an Extension.
     * </pre>
     */
    public void updateExtension(
        com.google.cloud.aiplatform.v1beta1.UpdateExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Extension>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateExtensionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Extension.
     * </pre>
     */
    public void deleteExtension(
        com.google.cloud.aiplatform.v1beta1.DeleteExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteExtensionMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ExtensionRegistryService.
   *
   * <pre>
   * A service for managing Vertex AI's Extension registry.
   * </pre>
   */
  public static final class ExtensionRegistryServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ExtensionRegistryServiceBlockingStub> {
    private ExtensionRegistryServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExtensionRegistryServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExtensionRegistryServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Imports an Extension.
     * </pre>
     */
    public com.google.longrunning.Operation importExtension(
        com.google.cloud.aiplatform.v1beta1.ImportExtensionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportExtensionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an Extension.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.Extension getExtension(
        com.google.cloud.aiplatform.v1beta1.GetExtensionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetExtensionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Extensions in a location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListExtensionsResponse listExtensions(
        com.google.cloud.aiplatform.v1beta1.ListExtensionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListExtensionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an Extension.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.Extension updateExtension(
        com.google.cloud.aiplatform.v1beta1.UpdateExtensionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateExtensionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Extension.
     * </pre>
     */
    public com.google.longrunning.Operation deleteExtension(
        com.google.cloud.aiplatform.v1beta1.DeleteExtensionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteExtensionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * ExtensionRegistryService.
   *
   * <pre>
   * A service for managing Vertex AI's Extension registry.
   * </pre>
   */
  public static final class ExtensionRegistryServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ExtensionRegistryServiceFutureStub> {
    private ExtensionRegistryServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExtensionRegistryServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExtensionRegistryServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Imports an Extension.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importExtension(com.google.cloud.aiplatform.v1beta1.ImportExtensionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportExtensionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an Extension.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.Extension>
        getExtension(com.google.cloud.aiplatform.v1beta1.GetExtensionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetExtensionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Extensions in a location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListExtensionsResponse>
        listExtensions(com.google.cloud.aiplatform.v1beta1.ListExtensionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListExtensionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an Extension.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.Extension>
        updateExtension(com.google.cloud.aiplatform.v1beta1.UpdateExtensionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateExtensionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Extension.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteExtension(com.google.cloud.aiplatform.v1beta1.DeleteExtensionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteExtensionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_IMPORT_EXTENSION = 0;
  private static final int METHODID_GET_EXTENSION = 1;
  private static final int METHODID_LIST_EXTENSIONS = 2;
  private static final int METHODID_UPDATE_EXTENSION = 3;
  private static final int METHODID_DELETE_EXTENSION = 4;

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
        case METHODID_IMPORT_EXTENSION:
          serviceImpl.importExtension(
              (com.google.cloud.aiplatform.v1beta1.ImportExtensionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_EXTENSION:
          serviceImpl.getExtension(
              (com.google.cloud.aiplatform.v1beta1.GetExtensionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Extension>)
                  responseObserver);
          break;
        case METHODID_LIST_EXTENSIONS:
          serviceImpl.listExtensions(
              (com.google.cloud.aiplatform.v1beta1.ListExtensionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListExtensionsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_EXTENSION:
          serviceImpl.updateExtension(
              (com.google.cloud.aiplatform.v1beta1.UpdateExtensionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Extension>)
                  responseObserver);
          break;
        case METHODID_DELETE_EXTENSION:
          serviceImpl.deleteExtension(
              (com.google.cloud.aiplatform.v1beta1.DeleteExtensionRequest) request,
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
            getImportExtensionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ImportExtensionRequest,
                    com.google.longrunning.Operation>(service, METHODID_IMPORT_EXTENSION)))
        .addMethod(
            getGetExtensionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.GetExtensionRequest,
                    com.google.cloud.aiplatform.v1beta1.Extension>(
                    service, METHODID_GET_EXTENSION)))
        .addMethod(
            getListExtensionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ListExtensionsRequest,
                    com.google.cloud.aiplatform.v1beta1.ListExtensionsResponse>(
                    service, METHODID_LIST_EXTENSIONS)))
        .addMethod(
            getUpdateExtensionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.UpdateExtensionRequest,
                    com.google.cloud.aiplatform.v1beta1.Extension>(
                    service, METHODID_UPDATE_EXTENSION)))
        .addMethod(
            getDeleteExtensionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.DeleteExtensionRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_EXTENSION)))
        .build();
  }

  private abstract static class ExtensionRegistryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ExtensionRegistryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1beta1.ExtensionRegistryServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ExtensionRegistryService");
    }
  }

  private static final class ExtensionRegistryServiceFileDescriptorSupplier
      extends ExtensionRegistryServiceBaseDescriptorSupplier {
    ExtensionRegistryServiceFileDescriptorSupplier() {}
  }

  private static final class ExtensionRegistryServiceMethodDescriptorSupplier
      extends ExtensionRegistryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ExtensionRegistryServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ExtensionRegistryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ExtensionRegistryServiceFileDescriptorSupplier())
                      .addMethod(getImportExtensionMethod())
                      .addMethod(getGetExtensionMethod())
                      .addMethod(getListExtensionsMethod())
                      .addMethod(getUpdateExtensionMethod())
                      .addMethod(getDeleteExtensionMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
