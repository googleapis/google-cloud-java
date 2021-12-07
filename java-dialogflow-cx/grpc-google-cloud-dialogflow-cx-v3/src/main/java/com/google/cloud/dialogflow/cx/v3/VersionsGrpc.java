/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.dialogflow.cx.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing [Versions][google.cloud.dialogflow.cx.v3.Version].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/cx/v3/version.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class VersionsGrpc {

  private VersionsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.cx.v3.Versions";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.ListVersionsRequest,
          com.google.cloud.dialogflow.cx.v3.ListVersionsResponse>
      getListVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListVersions",
      requestType = com.google.cloud.dialogflow.cx.v3.ListVersionsRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.ListVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.ListVersionsRequest,
          com.google.cloud.dialogflow.cx.v3.ListVersionsResponse>
      getListVersionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.ListVersionsRequest,
            com.google.cloud.dialogflow.cx.v3.ListVersionsResponse>
        getListVersionsMethod;
    if ((getListVersionsMethod = VersionsGrpc.getListVersionsMethod) == null) {
      synchronized (VersionsGrpc.class) {
        if ((getListVersionsMethod = VersionsGrpc.getListVersionsMethod) == null) {
          VersionsGrpc.getListVersionsMethod =
              getListVersionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.ListVersionsRequest,
                          com.google.cloud.dialogflow.cx.v3.ListVersionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListVersions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.ListVersionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.ListVersionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new VersionsMethodDescriptorSupplier("ListVersions"))
                      .build();
        }
      }
    }
    return getListVersionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.GetVersionRequest,
          com.google.cloud.dialogflow.cx.v3.Version>
      getGetVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVersion",
      requestType = com.google.cloud.dialogflow.cx.v3.GetVersionRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.Version.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.GetVersionRequest,
          com.google.cloud.dialogflow.cx.v3.Version>
      getGetVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.GetVersionRequest,
            com.google.cloud.dialogflow.cx.v3.Version>
        getGetVersionMethod;
    if ((getGetVersionMethod = VersionsGrpc.getGetVersionMethod) == null) {
      synchronized (VersionsGrpc.class) {
        if ((getGetVersionMethod = VersionsGrpc.getGetVersionMethod) == null) {
          VersionsGrpc.getGetVersionMethod =
              getGetVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.GetVersionRequest,
                          com.google.cloud.dialogflow.cx.v3.Version>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.GetVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.Version.getDefaultInstance()))
                      .setSchemaDescriptor(new VersionsMethodDescriptorSupplier("GetVersion"))
                      .build();
        }
      }
    }
    return getGetVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.CreateVersionRequest, com.google.longrunning.Operation>
      getCreateVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateVersion",
      requestType = com.google.cloud.dialogflow.cx.v3.CreateVersionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.CreateVersionRequest, com.google.longrunning.Operation>
      getCreateVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.CreateVersionRequest,
            com.google.longrunning.Operation>
        getCreateVersionMethod;
    if ((getCreateVersionMethod = VersionsGrpc.getCreateVersionMethod) == null) {
      synchronized (VersionsGrpc.class) {
        if ((getCreateVersionMethod = VersionsGrpc.getCreateVersionMethod) == null) {
          VersionsGrpc.getCreateVersionMethod =
              getCreateVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.CreateVersionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.CreateVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new VersionsMethodDescriptorSupplier("CreateVersion"))
                      .build();
        }
      }
    }
    return getCreateVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.UpdateVersionRequest,
          com.google.cloud.dialogflow.cx.v3.Version>
      getUpdateVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateVersion",
      requestType = com.google.cloud.dialogflow.cx.v3.UpdateVersionRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.Version.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.UpdateVersionRequest,
          com.google.cloud.dialogflow.cx.v3.Version>
      getUpdateVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.UpdateVersionRequest,
            com.google.cloud.dialogflow.cx.v3.Version>
        getUpdateVersionMethod;
    if ((getUpdateVersionMethod = VersionsGrpc.getUpdateVersionMethod) == null) {
      synchronized (VersionsGrpc.class) {
        if ((getUpdateVersionMethod = VersionsGrpc.getUpdateVersionMethod) == null) {
          VersionsGrpc.getUpdateVersionMethod =
              getUpdateVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.UpdateVersionRequest,
                          com.google.cloud.dialogflow.cx.v3.Version>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.UpdateVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.Version.getDefaultInstance()))
                      .setSchemaDescriptor(new VersionsMethodDescriptorSupplier("UpdateVersion"))
                      .build();
        }
      }
    }
    return getUpdateVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.DeleteVersionRequest, com.google.protobuf.Empty>
      getDeleteVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteVersion",
      requestType = com.google.cloud.dialogflow.cx.v3.DeleteVersionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.DeleteVersionRequest, com.google.protobuf.Empty>
      getDeleteVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.DeleteVersionRequest, com.google.protobuf.Empty>
        getDeleteVersionMethod;
    if ((getDeleteVersionMethod = VersionsGrpc.getDeleteVersionMethod) == null) {
      synchronized (VersionsGrpc.class) {
        if ((getDeleteVersionMethod = VersionsGrpc.getDeleteVersionMethod) == null) {
          VersionsGrpc.getDeleteVersionMethod =
              getDeleteVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.DeleteVersionRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.DeleteVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new VersionsMethodDescriptorSupplier("DeleteVersion"))
                      .build();
        }
      }
    }
    return getDeleteVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.LoadVersionRequest, com.google.longrunning.Operation>
      getLoadVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LoadVersion",
      requestType = com.google.cloud.dialogflow.cx.v3.LoadVersionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.LoadVersionRequest, com.google.longrunning.Operation>
      getLoadVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.LoadVersionRequest, com.google.longrunning.Operation>
        getLoadVersionMethod;
    if ((getLoadVersionMethod = VersionsGrpc.getLoadVersionMethod) == null) {
      synchronized (VersionsGrpc.class) {
        if ((getLoadVersionMethod = VersionsGrpc.getLoadVersionMethod) == null) {
          VersionsGrpc.getLoadVersionMethod =
              getLoadVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.LoadVersionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LoadVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.LoadVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new VersionsMethodDescriptorSupplier("LoadVersion"))
                      .build();
        }
      }
    }
    return getLoadVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.CompareVersionsRequest,
          com.google.cloud.dialogflow.cx.v3.CompareVersionsResponse>
      getCompareVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CompareVersions",
      requestType = com.google.cloud.dialogflow.cx.v3.CompareVersionsRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.CompareVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.CompareVersionsRequest,
          com.google.cloud.dialogflow.cx.v3.CompareVersionsResponse>
      getCompareVersionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.CompareVersionsRequest,
            com.google.cloud.dialogflow.cx.v3.CompareVersionsResponse>
        getCompareVersionsMethod;
    if ((getCompareVersionsMethod = VersionsGrpc.getCompareVersionsMethod) == null) {
      synchronized (VersionsGrpc.class) {
        if ((getCompareVersionsMethod = VersionsGrpc.getCompareVersionsMethod) == null) {
          VersionsGrpc.getCompareVersionsMethod =
              getCompareVersionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.CompareVersionsRequest,
                          com.google.cloud.dialogflow.cx.v3.CompareVersionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CompareVersions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.CompareVersionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.CompareVersionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new VersionsMethodDescriptorSupplier("CompareVersions"))
                      .build();
        }
      }
    }
    return getCompareVersionsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static VersionsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VersionsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VersionsStub>() {
          @java.lang.Override
          public VersionsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VersionsStub(channel, callOptions);
          }
        };
    return VersionsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VersionsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VersionsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VersionsBlockingStub>() {
          @java.lang.Override
          public VersionsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VersionsBlockingStub(channel, callOptions);
          }
        };
    return VersionsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static VersionsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VersionsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VersionsFutureStub>() {
          @java.lang.Override
          public VersionsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VersionsFutureStub(channel, callOptions);
          }
        };
    return VersionsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Versions][google.cloud.dialogflow.cx.v3.Version].
   * </pre>
   */
  public abstract static class VersionsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Returns the list of all versions in the specified [Flow][google.cloud.dialogflow.cx.v3.Flow].
     * </pre>
     */
    public void listVersions(
        com.google.cloud.dialogflow.cx.v3.ListVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListVersionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListVersionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified [Version][google.cloud.dialogflow.cx.v3.Version].
     * </pre>
     */
    public void getVersion(
        com.google.cloud.dialogflow.cx.v3.GetVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Version> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Version][google.cloud.dialogflow.cx.v3.Version] in the specified [Flow][google.cloud.dialogflow.cx.v3.Flow].
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [CreateVersionOperationMetadata][google.cloud.dialogflow.cx.v3.CreateVersionOperationMetadata]
     * - `response`: [Version][google.cloud.dialogflow.cx.v3.Version]
     * </pre>
     */
    public void createVersion(
        com.google.cloud.dialogflow.cx.v3.CreateVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified [Version][google.cloud.dialogflow.cx.v3.Version].
     * </pre>
     */
    public void updateVersion(
        com.google.cloud.dialogflow.cx.v3.UpdateVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Version> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified [Version][google.cloud.dialogflow.cx.v3.Version].
     * </pre>
     */
    public void deleteVersion(
        com.google.cloud.dialogflow.cx.v3.DeleteVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Loads resources in the specified version to the draft flow.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * </pre>
     */
    public void loadVersion(
        com.google.cloud.dialogflow.cx.v3.LoadVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getLoadVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Compares the specified base version with target version.
     * </pre>
     */
    public void compareVersions(
        com.google.cloud.dialogflow.cx.v3.CompareVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.CompareVersionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCompareVersionsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListVersionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3.ListVersionsRequest,
                      com.google.cloud.dialogflow.cx.v3.ListVersionsResponse>(
                      this, METHODID_LIST_VERSIONS)))
          .addMethod(
              getGetVersionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3.GetVersionRequest,
                      com.google.cloud.dialogflow.cx.v3.Version>(this, METHODID_GET_VERSION)))
          .addMethod(
              getCreateVersionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3.CreateVersionRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_VERSION)))
          .addMethod(
              getUpdateVersionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3.UpdateVersionRequest,
                      com.google.cloud.dialogflow.cx.v3.Version>(this, METHODID_UPDATE_VERSION)))
          .addMethod(
              getDeleteVersionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3.DeleteVersionRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_VERSION)))
          .addMethod(
              getLoadVersionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3.LoadVersionRequest,
                      com.google.longrunning.Operation>(this, METHODID_LOAD_VERSION)))
          .addMethod(
              getCompareVersionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3.CompareVersionsRequest,
                      com.google.cloud.dialogflow.cx.v3.CompareVersionsResponse>(
                      this, METHODID_COMPARE_VERSIONS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Versions][google.cloud.dialogflow.cx.v3.Version].
   * </pre>
   */
  public static final class VersionsStub extends io.grpc.stub.AbstractAsyncStub<VersionsStub> {
    private VersionsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VersionsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VersionsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all versions in the specified [Flow][google.cloud.dialogflow.cx.v3.Flow].
     * </pre>
     */
    public void listVersions(
        com.google.cloud.dialogflow.cx.v3.ListVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListVersionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListVersionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified [Version][google.cloud.dialogflow.cx.v3.Version].
     * </pre>
     */
    public void getVersion(
        com.google.cloud.dialogflow.cx.v3.GetVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Version> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Version][google.cloud.dialogflow.cx.v3.Version] in the specified [Flow][google.cloud.dialogflow.cx.v3.Flow].
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [CreateVersionOperationMetadata][google.cloud.dialogflow.cx.v3.CreateVersionOperationMetadata]
     * - `response`: [Version][google.cloud.dialogflow.cx.v3.Version]
     * </pre>
     */
    public void createVersion(
        com.google.cloud.dialogflow.cx.v3.CreateVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified [Version][google.cloud.dialogflow.cx.v3.Version].
     * </pre>
     */
    public void updateVersion(
        com.google.cloud.dialogflow.cx.v3.UpdateVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Version> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified [Version][google.cloud.dialogflow.cx.v3.Version].
     * </pre>
     */
    public void deleteVersion(
        com.google.cloud.dialogflow.cx.v3.DeleteVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Loads resources in the specified version to the draft flow.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * </pre>
     */
    public void loadVersion(
        com.google.cloud.dialogflow.cx.v3.LoadVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLoadVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Compares the specified base version with target version.
     * </pre>
     */
    public void compareVersions(
        com.google.cloud.dialogflow.cx.v3.CompareVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.CompareVersionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCompareVersionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Versions][google.cloud.dialogflow.cx.v3.Version].
   * </pre>
   */
  public static final class VersionsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<VersionsBlockingStub> {
    private VersionsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VersionsBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VersionsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all versions in the specified [Flow][google.cloud.dialogflow.cx.v3.Flow].
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.ListVersionsResponse listVersions(
        com.google.cloud.dialogflow.cx.v3.ListVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified [Version][google.cloud.dialogflow.cx.v3.Version].
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.Version getVersion(
        com.google.cloud.dialogflow.cx.v3.GetVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Version][google.cloud.dialogflow.cx.v3.Version] in the specified [Flow][google.cloud.dialogflow.cx.v3.Flow].
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [CreateVersionOperationMetadata][google.cloud.dialogflow.cx.v3.CreateVersionOperationMetadata]
     * - `response`: [Version][google.cloud.dialogflow.cx.v3.Version]
     * </pre>
     */
    public com.google.longrunning.Operation createVersion(
        com.google.cloud.dialogflow.cx.v3.CreateVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified [Version][google.cloud.dialogflow.cx.v3.Version].
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.Version updateVersion(
        com.google.cloud.dialogflow.cx.v3.UpdateVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified [Version][google.cloud.dialogflow.cx.v3.Version].
     * </pre>
     */
    public com.google.protobuf.Empty deleteVersion(
        com.google.cloud.dialogflow.cx.v3.DeleteVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Loads resources in the specified version to the draft flow.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * </pre>
     */
    public com.google.longrunning.Operation loadVersion(
        com.google.cloud.dialogflow.cx.v3.LoadVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLoadVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Compares the specified base version with target version.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.CompareVersionsResponse compareVersions(
        com.google.cloud.dialogflow.cx.v3.CompareVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCompareVersionsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Versions][google.cloud.dialogflow.cx.v3.Version].
   * </pre>
   */
  public static final class VersionsFutureStub
      extends io.grpc.stub.AbstractFutureStub<VersionsFutureStub> {
    private VersionsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VersionsFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VersionsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all versions in the specified [Flow][google.cloud.dialogflow.cx.v3.Flow].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.ListVersionsResponse>
        listVersions(com.google.cloud.dialogflow.cx.v3.ListVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListVersionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified [Version][google.cloud.dialogflow.cx.v3.Version].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.Version>
        getVersion(com.google.cloud.dialogflow.cx.v3.GetVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Version][google.cloud.dialogflow.cx.v3.Version] in the specified [Flow][google.cloud.dialogflow.cx.v3.Flow].
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [CreateVersionOperationMetadata][google.cloud.dialogflow.cx.v3.CreateVersionOperationMetadata]
     * - `response`: [Version][google.cloud.dialogflow.cx.v3.Version]
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createVersion(com.google.cloud.dialogflow.cx.v3.CreateVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified [Version][google.cloud.dialogflow.cx.v3.Version].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.Version>
        updateVersion(com.google.cloud.dialogflow.cx.v3.UpdateVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified [Version][google.cloud.dialogflow.cx.v3.Version].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteVersion(com.google.cloud.dialogflow.cx.v3.DeleteVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Loads resources in the specified version to the draft flow.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        loadVersion(com.google.cloud.dialogflow.cx.v3.LoadVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLoadVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Compares the specified base version with target version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.CompareVersionsResponse>
        compareVersions(com.google.cloud.dialogflow.cx.v3.CompareVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCompareVersionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_VERSIONS = 0;
  private static final int METHODID_GET_VERSION = 1;
  private static final int METHODID_CREATE_VERSION = 2;
  private static final int METHODID_UPDATE_VERSION = 3;
  private static final int METHODID_DELETE_VERSION = 4;
  private static final int METHODID_LOAD_VERSION = 5;
  private static final int METHODID_COMPARE_VERSIONS = 6;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final VersionsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(VersionsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_VERSIONS:
          serviceImpl.listVersions(
              (com.google.cloud.dialogflow.cx.v3.ListVersionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListVersionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_VERSION:
          serviceImpl.getVersion(
              (com.google.cloud.dialogflow.cx.v3.GetVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Version>)
                  responseObserver);
          break;
        case METHODID_CREATE_VERSION:
          serviceImpl.createVersion(
              (com.google.cloud.dialogflow.cx.v3.CreateVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_VERSION:
          serviceImpl.updateVersion(
              (com.google.cloud.dialogflow.cx.v3.UpdateVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Version>)
                  responseObserver);
          break;
        case METHODID_DELETE_VERSION:
          serviceImpl.deleteVersion(
              (com.google.cloud.dialogflow.cx.v3.DeleteVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LOAD_VERSION:
          serviceImpl.loadVersion(
              (com.google.cloud.dialogflow.cx.v3.LoadVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_COMPARE_VERSIONS:
          serviceImpl.compareVersions(
              (com.google.cloud.dialogflow.cx.v3.CompareVersionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.cx.v3.CompareVersionsResponse>)
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

  private abstract static class VersionsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VersionsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.cx.v3.VersionProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Versions");
    }
  }

  private static final class VersionsFileDescriptorSupplier extends VersionsBaseDescriptorSupplier {
    VersionsFileDescriptorSupplier() {}
  }

  private static final class VersionsMethodDescriptorSupplier extends VersionsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    VersionsMethodDescriptorSupplier(String methodName) {
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
      synchronized (VersionsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new VersionsFileDescriptorSupplier())
                      .addMethod(getListVersionsMethod())
                      .addMethod(getGetVersionMethod())
                      .addMethod(getCreateVersionMethod())
                      .addMethod(getUpdateVersionMethod())
                      .addMethod(getDeleteVersionMethod())
                      .addMethod(getLoadVersionMethod())
                      .addMethod(getCompareVersionsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
