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
package com.google.cloud.memorystore.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class MemorystoreGrpc {

  private MemorystoreGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.memorystore.v1beta.Memorystore";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1beta.ListInstancesRequest,
          com.google.cloud.memorystore.v1beta.ListInstancesResponse>
      getListInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInstances",
      requestType = com.google.cloud.memorystore.v1beta.ListInstancesRequest.class,
      responseType = com.google.cloud.memorystore.v1beta.ListInstancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1beta.ListInstancesRequest,
          com.google.cloud.memorystore.v1beta.ListInstancesResponse>
      getListInstancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1beta.ListInstancesRequest,
            com.google.cloud.memorystore.v1beta.ListInstancesResponse>
        getListInstancesMethod;
    if ((getListInstancesMethod = MemorystoreGrpc.getListInstancesMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getListInstancesMethod = MemorystoreGrpc.getListInstancesMethod) == null) {
          MemorystoreGrpc.getListInstancesMethod =
              getListInstancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1beta.ListInstancesRequest,
                          com.google.cloud.memorystore.v1beta.ListInstancesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInstances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1beta.ListInstancesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1beta.ListInstancesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new MemorystoreMethodDescriptorSupplier("ListInstances"))
                      .build();
        }
      }
    }
    return getListInstancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1beta.GetInstanceRequest,
          com.google.cloud.memorystore.v1beta.Instance>
      getGetInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstance",
      requestType = com.google.cloud.memorystore.v1beta.GetInstanceRequest.class,
      responseType = com.google.cloud.memorystore.v1beta.Instance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1beta.GetInstanceRequest,
          com.google.cloud.memorystore.v1beta.Instance>
      getGetInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1beta.GetInstanceRequest,
            com.google.cloud.memorystore.v1beta.Instance>
        getGetInstanceMethod;
    if ((getGetInstanceMethod = MemorystoreGrpc.getGetInstanceMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getGetInstanceMethod = MemorystoreGrpc.getGetInstanceMethod) == null) {
          MemorystoreGrpc.getGetInstanceMethod =
              getGetInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1beta.GetInstanceRequest,
                          com.google.cloud.memorystore.v1beta.Instance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1beta.GetInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1beta.Instance.getDefaultInstance()))
                      .setSchemaDescriptor(new MemorystoreMethodDescriptorSupplier("GetInstance"))
                      .build();
        }
      }
    }
    return getGetInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1beta.CreateInstanceRequest,
          com.google.longrunning.Operation>
      getCreateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInstance",
      requestType = com.google.cloud.memorystore.v1beta.CreateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1beta.CreateInstanceRequest,
          com.google.longrunning.Operation>
      getCreateInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1beta.CreateInstanceRequest,
            com.google.longrunning.Operation>
        getCreateInstanceMethod;
    if ((getCreateInstanceMethod = MemorystoreGrpc.getCreateInstanceMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getCreateInstanceMethod = MemorystoreGrpc.getCreateInstanceMethod) == null) {
          MemorystoreGrpc.getCreateInstanceMethod =
              getCreateInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1beta.CreateInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1beta.CreateInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemorystoreMethodDescriptorSupplier("CreateInstance"))
                      .build();
        }
      }
    }
    return getCreateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1beta.UpdateInstanceRequest,
          com.google.longrunning.Operation>
      getUpdateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateInstance",
      requestType = com.google.cloud.memorystore.v1beta.UpdateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1beta.UpdateInstanceRequest,
          com.google.longrunning.Operation>
      getUpdateInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1beta.UpdateInstanceRequest,
            com.google.longrunning.Operation>
        getUpdateInstanceMethod;
    if ((getUpdateInstanceMethod = MemorystoreGrpc.getUpdateInstanceMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getUpdateInstanceMethod = MemorystoreGrpc.getUpdateInstanceMethod) == null) {
          MemorystoreGrpc.getUpdateInstanceMethod =
              getUpdateInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1beta.UpdateInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1beta.UpdateInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemorystoreMethodDescriptorSupplier("UpdateInstance"))
                      .build();
        }
      }
    }
    return getUpdateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1beta.DeleteInstanceRequest,
          com.google.longrunning.Operation>
      getDeleteInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInstance",
      requestType = com.google.cloud.memorystore.v1beta.DeleteInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1beta.DeleteInstanceRequest,
          com.google.longrunning.Operation>
      getDeleteInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1beta.DeleteInstanceRequest,
            com.google.longrunning.Operation>
        getDeleteInstanceMethod;
    if ((getDeleteInstanceMethod = MemorystoreGrpc.getDeleteInstanceMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getDeleteInstanceMethod = MemorystoreGrpc.getDeleteInstanceMethod) == null) {
          MemorystoreGrpc.getDeleteInstanceMethod =
              getDeleteInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1beta.DeleteInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1beta.DeleteInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemorystoreMethodDescriptorSupplier("DeleteInstance"))
                      .build();
        }
      }
    }
    return getDeleteInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1beta.GetCertificateAuthorityRequest,
          com.google.cloud.memorystore.v1beta.CertificateAuthority>
      getGetCertificateAuthorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCertificateAuthority",
      requestType = com.google.cloud.memorystore.v1beta.GetCertificateAuthorityRequest.class,
      responseType = com.google.cloud.memorystore.v1beta.CertificateAuthority.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1beta.GetCertificateAuthorityRequest,
          com.google.cloud.memorystore.v1beta.CertificateAuthority>
      getGetCertificateAuthorityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1beta.GetCertificateAuthorityRequest,
            com.google.cloud.memorystore.v1beta.CertificateAuthority>
        getGetCertificateAuthorityMethod;
    if ((getGetCertificateAuthorityMethod = MemorystoreGrpc.getGetCertificateAuthorityMethod)
        == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getGetCertificateAuthorityMethod = MemorystoreGrpc.getGetCertificateAuthorityMethod)
            == null) {
          MemorystoreGrpc.getGetCertificateAuthorityMethod =
              getGetCertificateAuthorityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1beta.GetCertificateAuthorityRequest,
                          com.google.cloud.memorystore.v1beta.CertificateAuthority>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetCertificateAuthority"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1beta.GetCertificateAuthorityRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1beta.CertificateAuthority
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemorystoreMethodDescriptorSupplier("GetCertificateAuthority"))
                      .build();
        }
      }
    }
    return getGetCertificateAuthorityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1beta.GetSharedRegionalCertificateAuthorityRequest,
          com.google.cloud.memorystore.v1beta.SharedRegionalCertificateAuthority>
      getGetSharedRegionalCertificateAuthorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSharedRegionalCertificateAuthority",
      requestType =
          com.google.cloud.memorystore.v1beta.GetSharedRegionalCertificateAuthorityRequest.class,
      responseType = com.google.cloud.memorystore.v1beta.SharedRegionalCertificateAuthority.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1beta.GetSharedRegionalCertificateAuthorityRequest,
          com.google.cloud.memorystore.v1beta.SharedRegionalCertificateAuthority>
      getGetSharedRegionalCertificateAuthorityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1beta.GetSharedRegionalCertificateAuthorityRequest,
            com.google.cloud.memorystore.v1beta.SharedRegionalCertificateAuthority>
        getGetSharedRegionalCertificateAuthorityMethod;
    if ((getGetSharedRegionalCertificateAuthorityMethod =
            MemorystoreGrpc.getGetSharedRegionalCertificateAuthorityMethod)
        == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getGetSharedRegionalCertificateAuthorityMethod =
                MemorystoreGrpc.getGetSharedRegionalCertificateAuthorityMethod)
            == null) {
          MemorystoreGrpc.getGetSharedRegionalCertificateAuthorityMethod =
              getGetSharedRegionalCertificateAuthorityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1beta
                              .GetSharedRegionalCertificateAuthorityRequest,
                          com.google.cloud.memorystore.v1beta.SharedRegionalCertificateAuthority>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "GetSharedRegionalCertificateAuthority"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1beta
                                  .GetSharedRegionalCertificateAuthorityRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1beta.SharedRegionalCertificateAuthority
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemorystoreMethodDescriptorSupplier(
                              "GetSharedRegionalCertificateAuthority"))
                      .build();
        }
      }
    }
    return getGetSharedRegionalCertificateAuthorityMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static MemorystoreStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MemorystoreStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MemorystoreStub>() {
          @java.lang.Override
          public MemorystoreStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MemorystoreStub(channel, callOptions);
          }
        };
    return MemorystoreStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static MemorystoreBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MemorystoreBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MemorystoreBlockingV2Stub>() {
          @java.lang.Override
          public MemorystoreBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MemorystoreBlockingV2Stub(channel, callOptions);
          }
        };
    return MemorystoreBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MemorystoreBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MemorystoreBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MemorystoreBlockingStub>() {
          @java.lang.Override
          public MemorystoreBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MemorystoreBlockingStub(channel, callOptions);
          }
        };
    return MemorystoreBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static MemorystoreFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MemorystoreFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MemorystoreFutureStub>() {
          @java.lang.Override
          public MemorystoreFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MemorystoreFutureStub(channel, callOptions);
          }
        };
    return MemorystoreFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    default void listInstances(
        com.google.cloud.memorystore.v1beta.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1beta.ListInstancesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListInstancesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    default void getInstance(
        com.google.cloud.memorystore.v1beta.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1beta.Instance>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Instance in a given project and location.
     * </pre>
     */
    default void createInstance(
        com.google.cloud.memorystore.v1beta.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Instance.
     * </pre>
     */
    default void updateInstance(
        com.google.cloud.memorystore.v1beta.UpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    default void deleteInstance(
        com.google.cloud.memorystore.v1beta.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about the certificate authority for an Instance.
     * </pre>
     */
    default void getCertificateAuthority(
        com.google.cloud.memorystore.v1beta.GetCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1beta.CertificateAuthority>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCertificateAuthorityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of shared regional certificate authority information for
     * Memorystore instance.
     * </pre>
     */
    default void getSharedRegionalCertificateAuthority(
        com.google.cloud.memorystore.v1beta.GetSharedRegionalCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.memorystore.v1beta.SharedRegionalCertificateAuthority>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSharedRegionalCertificateAuthorityMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Memorystore.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class MemorystoreImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return MemorystoreGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Memorystore.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class MemorystoreStub
      extends io.grpc.stub.AbstractAsyncStub<MemorystoreStub> {
    private MemorystoreStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MemorystoreStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MemorystoreStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public void listInstances(
        com.google.cloud.memorystore.v1beta.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1beta.ListInstancesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public void getInstance(
        com.google.cloud.memorystore.v1beta.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1beta.Instance>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Instance in a given project and location.
     * </pre>
     */
    public void createInstance(
        com.google.cloud.memorystore.v1beta.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Instance.
     * </pre>
     */
    public void updateInstance(
        com.google.cloud.memorystore.v1beta.UpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    public void deleteInstance(
        com.google.cloud.memorystore.v1beta.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about the certificate authority for an Instance.
     * </pre>
     */
    public void getCertificateAuthority(
        com.google.cloud.memorystore.v1beta.GetCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1beta.CertificateAuthority>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCertificateAuthorityMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of shared regional certificate authority information for
     * Memorystore instance.
     * </pre>
     */
    public void getSharedRegionalCertificateAuthority(
        com.google.cloud.memorystore.v1beta.GetSharedRegionalCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.memorystore.v1beta.SharedRegionalCertificateAuthority>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSharedRegionalCertificateAuthorityMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Memorystore.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class MemorystoreBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<MemorystoreBlockingV2Stub> {
    private MemorystoreBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MemorystoreBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MemorystoreBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public com.google.cloud.memorystore.v1beta.ListInstancesResponse listInstances(
        com.google.cloud.memorystore.v1beta.ListInstancesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public com.google.cloud.memorystore.v1beta.Instance getInstance(
        com.google.cloud.memorystore.v1beta.GetInstanceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Instance in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createInstance(
        com.google.cloud.memorystore.v1beta.CreateInstanceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Instance.
     * </pre>
     */
    public com.google.longrunning.Operation updateInstance(
        com.google.cloud.memorystore.v1beta.UpdateInstanceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInstance(
        com.google.cloud.memorystore.v1beta.DeleteInstanceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about the certificate authority for an Instance.
     * </pre>
     */
    public com.google.cloud.memorystore.v1beta.CertificateAuthority getCertificateAuthority(
        com.google.cloud.memorystore.v1beta.GetCertificateAuthorityRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetCertificateAuthorityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of shared regional certificate authority information for
     * Memorystore instance.
     * </pre>
     */
    public com.google.cloud.memorystore.v1beta.SharedRegionalCertificateAuthority
        getSharedRegionalCertificateAuthority(
            com.google.cloud.memorystore.v1beta.GetSharedRegionalCertificateAuthorityRequest
                request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getGetSharedRegionalCertificateAuthorityMethod(),
          getCallOptions(),
          request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Memorystore.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class MemorystoreBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MemorystoreBlockingStub> {
    private MemorystoreBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MemorystoreBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MemorystoreBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public com.google.cloud.memorystore.v1beta.ListInstancesResponse listInstances(
        com.google.cloud.memorystore.v1beta.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public com.google.cloud.memorystore.v1beta.Instance getInstance(
        com.google.cloud.memorystore.v1beta.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Instance in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createInstance(
        com.google.cloud.memorystore.v1beta.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Instance.
     * </pre>
     */
    public com.google.longrunning.Operation updateInstance(
        com.google.cloud.memorystore.v1beta.UpdateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInstance(
        com.google.cloud.memorystore.v1beta.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about the certificate authority for an Instance.
     * </pre>
     */
    public com.google.cloud.memorystore.v1beta.CertificateAuthority getCertificateAuthority(
        com.google.cloud.memorystore.v1beta.GetCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCertificateAuthorityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of shared regional certificate authority information for
     * Memorystore instance.
     * </pre>
     */
    public com.google.cloud.memorystore.v1beta.SharedRegionalCertificateAuthority
        getSharedRegionalCertificateAuthority(
            com.google.cloud.memorystore.v1beta.GetSharedRegionalCertificateAuthorityRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getGetSharedRegionalCertificateAuthorityMethod(),
          getCallOptions(),
          request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Memorystore.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class MemorystoreFutureStub
      extends io.grpc.stub.AbstractFutureStub<MemorystoreFutureStub> {
    private MemorystoreFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MemorystoreFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MemorystoreFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.memorystore.v1beta.ListInstancesResponse>
        listInstances(com.google.cloud.memorystore.v1beta.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.memorystore.v1beta.Instance>
        getInstance(com.google.cloud.memorystore.v1beta.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Instance in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createInstance(com.google.cloud.memorystore.v1beta.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateInstance(com.google.cloud.memorystore.v1beta.UpdateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteInstance(com.google.cloud.memorystore.v1beta.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about the certificate authority for an Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.memorystore.v1beta.CertificateAuthority>
        getCertificateAuthority(
            com.google.cloud.memorystore.v1beta.GetCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCertificateAuthorityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of shared regional certificate authority information for
     * Memorystore instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.memorystore.v1beta.SharedRegionalCertificateAuthority>
        getSharedRegionalCertificateAuthority(
            com.google.cloud.memorystore.v1beta.GetSharedRegionalCertificateAuthorityRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSharedRegionalCertificateAuthorityMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_LIST_INSTANCES = 0;
  private static final int METHODID_GET_INSTANCE = 1;
  private static final int METHODID_CREATE_INSTANCE = 2;
  private static final int METHODID_UPDATE_INSTANCE = 3;
  private static final int METHODID_DELETE_INSTANCE = 4;
  private static final int METHODID_GET_CERTIFICATE_AUTHORITY = 5;
  private static final int METHODID_GET_SHARED_REGIONAL_CERTIFICATE_AUTHORITY = 6;

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
        case METHODID_LIST_INSTANCES:
          serviceImpl.listInstances(
              (com.google.cloud.memorystore.v1beta.ListInstancesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.memorystore.v1beta.ListInstancesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_INSTANCE:
          serviceImpl.getInstance(
              (com.google.cloud.memorystore.v1beta.GetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1beta.Instance>)
                  responseObserver);
          break;
        case METHODID_CREATE_INSTANCE:
          serviceImpl.createInstance(
              (com.google.cloud.memorystore.v1beta.CreateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_INSTANCE:
          serviceImpl.updateInstance(
              (com.google.cloud.memorystore.v1beta.UpdateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INSTANCE:
          serviceImpl.deleteInstance(
              (com.google.cloud.memorystore.v1beta.DeleteInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_CERTIFICATE_AUTHORITY:
          serviceImpl.getCertificateAuthority(
              (com.google.cloud.memorystore.v1beta.GetCertificateAuthorityRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.memorystore.v1beta.CertificateAuthority>)
                  responseObserver);
          break;
        case METHODID_GET_SHARED_REGIONAL_CERTIFICATE_AUTHORITY:
          serviceImpl.getSharedRegionalCertificateAuthority(
              (com.google.cloud.memorystore.v1beta.GetSharedRegionalCertificateAuthorityRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.memorystore.v1beta.SharedRegionalCertificateAuthority>)
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
            getListInstancesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1beta.ListInstancesRequest,
                    com.google.cloud.memorystore.v1beta.ListInstancesResponse>(
                    service, METHODID_LIST_INSTANCES)))
        .addMethod(
            getGetInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1beta.GetInstanceRequest,
                    com.google.cloud.memorystore.v1beta.Instance>(service, METHODID_GET_INSTANCE)))
        .addMethod(
            getCreateInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1beta.CreateInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_INSTANCE)))
        .addMethod(
            getUpdateInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1beta.UpdateInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_INSTANCE)))
        .addMethod(
            getDeleteInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1beta.DeleteInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_INSTANCE)))
        .addMethod(
            getGetCertificateAuthorityMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1beta.GetCertificateAuthorityRequest,
                    com.google.cloud.memorystore.v1beta.CertificateAuthority>(
                    service, METHODID_GET_CERTIFICATE_AUTHORITY)))
        .addMethod(
            getGetSharedRegionalCertificateAuthorityMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1beta
                        .GetSharedRegionalCertificateAuthorityRequest,
                    com.google.cloud.memorystore.v1beta.SharedRegionalCertificateAuthority>(
                    service, METHODID_GET_SHARED_REGIONAL_CERTIFICATE_AUTHORITY)))
        .build();
  }

  private abstract static class MemorystoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MemorystoreBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.memorystore.v1beta.V1mainProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Memorystore");
    }
  }

  private static final class MemorystoreFileDescriptorSupplier
      extends MemorystoreBaseDescriptorSupplier {
    MemorystoreFileDescriptorSupplier() {}
  }

  private static final class MemorystoreMethodDescriptorSupplier
      extends MemorystoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MemorystoreMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (MemorystoreGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new MemorystoreFileDescriptorSupplier())
                      .addMethod(getListInstancesMethod())
                      .addMethod(getGetInstanceMethod())
                      .addMethod(getCreateInstanceMethod())
                      .addMethod(getUpdateInstanceMethod())
                      .addMethod(getDeleteInstanceMethod())
                      .addMethod(getGetCertificateAuthorityMethod())
                      .addMethod(getGetSharedRegionalCertificateAuthorityMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
