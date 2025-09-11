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
package com.google.cloud.cloudsecuritycompliance.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/cloudsecuritycompliance/v1/deployment.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DeploymentGrpc {

  private DeploymentGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.cloudsecuritycompliance.v1.Deployment";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkDeploymentRequest,
          com.google.longrunning.Operation>
      getCreateFrameworkDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFrameworkDeployment",
      requestType =
          com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkDeploymentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkDeploymentRequest,
          com.google.longrunning.Operation>
      getCreateFrameworkDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkDeploymentRequest,
            com.google.longrunning.Operation>
        getCreateFrameworkDeploymentMethod;
    if ((getCreateFrameworkDeploymentMethod = DeploymentGrpc.getCreateFrameworkDeploymentMethod)
        == null) {
      synchronized (DeploymentGrpc.class) {
        if ((getCreateFrameworkDeploymentMethod = DeploymentGrpc.getCreateFrameworkDeploymentMethod)
            == null) {
          DeploymentGrpc.getCreateFrameworkDeploymentMethod =
              getCreateFrameworkDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1
                              .CreateFrameworkDeploymentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateFrameworkDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1
                                  .CreateFrameworkDeploymentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeploymentMethodDescriptorSupplier("CreateFrameworkDeployment"))
                      .build();
        }
      }
    }
    return getCreateFrameworkDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkDeploymentRequest,
          com.google.longrunning.Operation>
      getDeleteFrameworkDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFrameworkDeployment",
      requestType =
          com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkDeploymentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkDeploymentRequest,
          com.google.longrunning.Operation>
      getDeleteFrameworkDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkDeploymentRequest,
            com.google.longrunning.Operation>
        getDeleteFrameworkDeploymentMethod;
    if ((getDeleteFrameworkDeploymentMethod = DeploymentGrpc.getDeleteFrameworkDeploymentMethod)
        == null) {
      synchronized (DeploymentGrpc.class) {
        if ((getDeleteFrameworkDeploymentMethod = DeploymentGrpc.getDeleteFrameworkDeploymentMethod)
            == null) {
          DeploymentGrpc.getDeleteFrameworkDeploymentMethod =
              getDeleteFrameworkDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1
                              .DeleteFrameworkDeploymentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteFrameworkDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1
                                  .DeleteFrameworkDeploymentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeploymentMethodDescriptorSupplier("DeleteFrameworkDeployment"))
                      .build();
        }
      }
    }
    return getDeleteFrameworkDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkDeploymentRequest,
          com.google.cloud.cloudsecuritycompliance.v1.FrameworkDeployment>
      getGetFrameworkDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFrameworkDeployment",
      requestType = com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkDeploymentRequest.class,
      responseType = com.google.cloud.cloudsecuritycompliance.v1.FrameworkDeployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkDeploymentRequest,
          com.google.cloud.cloudsecuritycompliance.v1.FrameworkDeployment>
      getGetFrameworkDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkDeploymentRequest,
            com.google.cloud.cloudsecuritycompliance.v1.FrameworkDeployment>
        getGetFrameworkDeploymentMethod;
    if ((getGetFrameworkDeploymentMethod = DeploymentGrpc.getGetFrameworkDeploymentMethod)
        == null) {
      synchronized (DeploymentGrpc.class) {
        if ((getGetFrameworkDeploymentMethod = DeploymentGrpc.getGetFrameworkDeploymentMethod)
            == null) {
          DeploymentGrpc.getGetFrameworkDeploymentMethod =
              getGetFrameworkDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkDeploymentRequest,
                          com.google.cloud.cloudsecuritycompliance.v1.FrameworkDeployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetFrameworkDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1
                                  .GetFrameworkDeploymentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.FrameworkDeployment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeploymentMethodDescriptorSupplier("GetFrameworkDeployment"))
                      .build();
        }
      }
    }
    return getGetFrameworkDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsRequest,
          com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsResponse>
      getListFrameworkDeploymentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFrameworkDeployments",
      requestType =
          com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsRequest.class,
      responseType =
          com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsRequest,
          com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsResponse>
      getListFrameworkDeploymentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsRequest,
            com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsResponse>
        getListFrameworkDeploymentsMethod;
    if ((getListFrameworkDeploymentsMethod = DeploymentGrpc.getListFrameworkDeploymentsMethod)
        == null) {
      synchronized (DeploymentGrpc.class) {
        if ((getListFrameworkDeploymentsMethod = DeploymentGrpc.getListFrameworkDeploymentsMethod)
            == null) {
          DeploymentGrpc.getListFrameworkDeploymentsMethod =
              getListFrameworkDeploymentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsRequest,
                          com.google.cloud.cloudsecuritycompliance.v1
                              .ListFrameworkDeploymentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListFrameworkDeployments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1
                                  .ListFrameworkDeploymentsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1
                                  .ListFrameworkDeploymentsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeploymentMethodDescriptorSupplier("ListFrameworkDeployments"))
                      .build();
        }
      }
    }
    return getListFrameworkDeploymentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlDeploymentRequest,
          com.google.cloud.cloudsecuritycompliance.v1.CloudControlDeployment>
      getGetCloudControlDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCloudControlDeployment",
      requestType =
          com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlDeploymentRequest.class,
      responseType = com.google.cloud.cloudsecuritycompliance.v1.CloudControlDeployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlDeploymentRequest,
          com.google.cloud.cloudsecuritycompliance.v1.CloudControlDeployment>
      getGetCloudControlDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlDeploymentRequest,
            com.google.cloud.cloudsecuritycompliance.v1.CloudControlDeployment>
        getGetCloudControlDeploymentMethod;
    if ((getGetCloudControlDeploymentMethod = DeploymentGrpc.getGetCloudControlDeploymentMethod)
        == null) {
      synchronized (DeploymentGrpc.class) {
        if ((getGetCloudControlDeploymentMethod = DeploymentGrpc.getGetCloudControlDeploymentMethod)
            == null) {
          DeploymentGrpc.getGetCloudControlDeploymentMethod =
              getGetCloudControlDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1
                              .GetCloudControlDeploymentRequest,
                          com.google.cloud.cloudsecuritycompliance.v1.CloudControlDeployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetCloudControlDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1
                                  .GetCloudControlDeploymentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.CloudControlDeployment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeploymentMethodDescriptorSupplier("GetCloudControlDeployment"))
                      .build();
        }
      }
    }
    return getGetCloudControlDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsRequest,
          com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsResponse>
      getListCloudControlDeploymentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCloudControlDeployments",
      requestType =
          com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsRequest.class,
      responseType =
          com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsRequest,
          com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsResponse>
      getListCloudControlDeploymentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsRequest,
            com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsResponse>
        getListCloudControlDeploymentsMethod;
    if ((getListCloudControlDeploymentsMethod = DeploymentGrpc.getListCloudControlDeploymentsMethod)
        == null) {
      synchronized (DeploymentGrpc.class) {
        if ((getListCloudControlDeploymentsMethod =
                DeploymentGrpc.getListCloudControlDeploymentsMethod)
            == null) {
          DeploymentGrpc.getListCloudControlDeploymentsMethod =
              getListCloudControlDeploymentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1
                              .ListCloudControlDeploymentsRequest,
                          com.google.cloud.cloudsecuritycompliance.v1
                              .ListCloudControlDeploymentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListCloudControlDeployments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1
                                  .ListCloudControlDeploymentsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1
                                  .ListCloudControlDeploymentsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeploymentMethodDescriptorSupplier("ListCloudControlDeployments"))
                      .build();
        }
      }
    }
    return getListCloudControlDeploymentsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DeploymentStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeploymentStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DeploymentStub>() {
          @java.lang.Override
          public DeploymentStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DeploymentStub(channel, callOptions);
          }
        };
    return DeploymentStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static DeploymentBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeploymentBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DeploymentBlockingV2Stub>() {
          @java.lang.Override
          public DeploymentBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DeploymentBlockingV2Stub(channel, callOptions);
          }
        };
    return DeploymentBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DeploymentBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeploymentBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DeploymentBlockingStub>() {
          @java.lang.Override
          public DeploymentBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DeploymentBlockingStub(channel, callOptions);
          }
        };
    return DeploymentBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DeploymentFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeploymentFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DeploymentFutureStub>() {
          @java.lang.Override
          public DeploymentFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DeploymentFutureStub(channel, callOptions);
          }
        };
    return DeploymentFutureStub.newStub(factory, channel);
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
     * Creates a new FrameworkDeployment in a given project and location.
     * </pre>
     */
    default void createFrameworkDeployment(
        com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateFrameworkDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single FrameworkDeployment.
     * </pre>
     */
    default void deleteFrameworkDeployment(
        com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteFrameworkDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single FrameworkDeployment.
     * </pre>
     */
    default void getFrameworkDeployment(
        com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudsecuritycompliance.v1.FrameworkDeployment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetFrameworkDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists FrameworkDeployments in a given parent and location.
     * </pre>
     */
    default void listFrameworkDeployments(
        com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFrameworkDeploymentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CloudControlDeployment.
     * </pre>
     */
    default void getCloudControlDeployment(
        com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlDeploymentRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1.CloudControlDeployment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCloudControlDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists CloudControlDeployments under a given parent.
     * </pre>
     */
    default void listCloudControlDeployments(
        com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCloudControlDeploymentsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Deployment.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class DeploymentImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DeploymentGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Deployment.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class DeploymentStub extends io.grpc.stub.AbstractAsyncStub<DeploymentStub> {
    private DeploymentStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeploymentStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeploymentStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FrameworkDeployment in a given project and location.
     * </pre>
     */
    public void createFrameworkDeployment(
        com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFrameworkDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single FrameworkDeployment.
     * </pre>
     */
    public void deleteFrameworkDeployment(
        com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFrameworkDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single FrameworkDeployment.
     * </pre>
     */
    public void getFrameworkDeployment(
        com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudsecuritycompliance.v1.FrameworkDeployment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFrameworkDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists FrameworkDeployments in a given parent and location.
     * </pre>
     */
    public void listFrameworkDeployments(
        com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFrameworkDeploymentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CloudControlDeployment.
     * </pre>
     */
    public void getCloudControlDeployment(
        com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlDeploymentRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1.CloudControlDeployment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCloudControlDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists CloudControlDeployments under a given parent.
     * </pre>
     */
    public void listCloudControlDeployments(
        com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCloudControlDeploymentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Deployment.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class DeploymentBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DeploymentBlockingV2Stub> {
    private DeploymentBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeploymentBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeploymentBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FrameworkDeployment in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createFrameworkDeployment(
        com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFrameworkDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single FrameworkDeployment.
     * </pre>
     */
    public com.google.longrunning.Operation deleteFrameworkDeployment(
        com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFrameworkDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single FrameworkDeployment.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.FrameworkDeployment getFrameworkDeployment(
        com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFrameworkDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists FrameworkDeployments in a given parent and location.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsResponse
        listFrameworkDeployments(
            com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFrameworkDeploymentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CloudControlDeployment.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.CloudControlDeployment
        getCloudControlDeployment(
            com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCloudControlDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists CloudControlDeployments under a given parent.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsResponse
        listCloudControlDeployments(
            com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCloudControlDeploymentsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Deployment.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class DeploymentBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DeploymentBlockingStub> {
    private DeploymentBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeploymentBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeploymentBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FrameworkDeployment in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createFrameworkDeployment(
        com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFrameworkDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single FrameworkDeployment.
     * </pre>
     */
    public com.google.longrunning.Operation deleteFrameworkDeployment(
        com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFrameworkDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single FrameworkDeployment.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.FrameworkDeployment getFrameworkDeployment(
        com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFrameworkDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists FrameworkDeployments in a given parent and location.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsResponse
        listFrameworkDeployments(
            com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFrameworkDeploymentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CloudControlDeployment.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.CloudControlDeployment
        getCloudControlDeployment(
            com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCloudControlDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists CloudControlDeployments under a given parent.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsResponse
        listCloudControlDeployments(
            com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCloudControlDeploymentsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Deployment.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class DeploymentFutureStub
      extends io.grpc.stub.AbstractFutureStub<DeploymentFutureStub> {
    private DeploymentFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeploymentFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeploymentFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FrameworkDeployment in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createFrameworkDeployment(
            com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFrameworkDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single FrameworkDeployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteFrameworkDeployment(
            com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFrameworkDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single FrameworkDeployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.cloudsecuritycompliance.v1.FrameworkDeployment>
        getFrameworkDeployment(
            com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFrameworkDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists FrameworkDeployments in a given parent and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsResponse>
        listFrameworkDeployments(
            com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFrameworkDeploymentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CloudControlDeployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.cloudsecuritycompliance.v1.CloudControlDeployment>
        getCloudControlDeployment(
            com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCloudControlDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists CloudControlDeployments under a given parent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsResponse>
        listCloudControlDeployments(
            com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCloudControlDeploymentsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_FRAMEWORK_DEPLOYMENT = 0;
  private static final int METHODID_DELETE_FRAMEWORK_DEPLOYMENT = 1;
  private static final int METHODID_GET_FRAMEWORK_DEPLOYMENT = 2;
  private static final int METHODID_LIST_FRAMEWORK_DEPLOYMENTS = 3;
  private static final int METHODID_GET_CLOUD_CONTROL_DEPLOYMENT = 4;
  private static final int METHODID_LIST_CLOUD_CONTROL_DEPLOYMENTS = 5;

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
        case METHODID_CREATE_FRAMEWORK_DEPLOYMENT:
          serviceImpl.createFrameworkDeployment(
              (com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkDeploymentRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_FRAMEWORK_DEPLOYMENT:
          serviceImpl.deleteFrameworkDeployment(
              (com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkDeploymentRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_FRAMEWORK_DEPLOYMENT:
          serviceImpl.getFrameworkDeployment(
              (com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.cloudsecuritycompliance.v1.FrameworkDeployment>)
                  responseObserver);
          break;
        case METHODID_LIST_FRAMEWORK_DEPLOYMENTS:
          serviceImpl.listFrameworkDeployments(
              (com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CLOUD_CONTROL_DEPLOYMENT:
          serviceImpl.getCloudControlDeployment(
              (com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlDeploymentRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.cloudsecuritycompliance.v1.CloudControlDeployment>)
                  responseObserver);
          break;
        case METHODID_LIST_CLOUD_CONTROL_DEPLOYMENTS:
          serviceImpl.listCloudControlDeployments(
              (com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.cloudsecuritycompliance.v1
                          .ListCloudControlDeploymentsResponse>)
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
            getCreateFrameworkDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkDeploymentRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_FRAMEWORK_DEPLOYMENT)))
        .addMethod(
            getDeleteFrameworkDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkDeploymentRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_FRAMEWORK_DEPLOYMENT)))
        .addMethod(
            getGetFrameworkDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkDeploymentRequest,
                    com.google.cloud.cloudsecuritycompliance.v1.FrameworkDeployment>(
                    service, METHODID_GET_FRAMEWORK_DEPLOYMENT)))
        .addMethod(
            getListFrameworkDeploymentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsRequest,
                    com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsResponse>(
                    service, METHODID_LIST_FRAMEWORK_DEPLOYMENTS)))
        .addMethod(
            getGetCloudControlDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlDeploymentRequest,
                    com.google.cloud.cloudsecuritycompliance.v1.CloudControlDeployment>(
                    service, METHODID_GET_CLOUD_CONTROL_DEPLOYMENT)))
        .addMethod(
            getListCloudControlDeploymentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsRequest,
                    com.google.cloud.cloudsecuritycompliance.v1
                        .ListCloudControlDeploymentsResponse>(
                    service, METHODID_LIST_CLOUD_CONTROL_DEPLOYMENTS)))
        .build();
  }

  private abstract static class DeploymentBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DeploymentBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.cloudsecuritycompliance.v1.DeploymentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Deployment");
    }
  }

  private static final class DeploymentFileDescriptorSupplier
      extends DeploymentBaseDescriptorSupplier {
    DeploymentFileDescriptorSupplier() {}
  }

  private static final class DeploymentMethodDescriptorSupplier
      extends DeploymentBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DeploymentMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DeploymentGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DeploymentFileDescriptorSupplier())
                      .addMethod(getCreateFrameworkDeploymentMethod())
                      .addMethod(getDeleteFrameworkDeploymentMethod())
                      .addMethod(getGetFrameworkDeploymentMethod())
                      .addMethod(getListFrameworkDeploymentsMethod())
                      .addMethod(getGetCloudControlDeploymentMethod())
                      .addMethod(getListCloudControlDeploymentsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
