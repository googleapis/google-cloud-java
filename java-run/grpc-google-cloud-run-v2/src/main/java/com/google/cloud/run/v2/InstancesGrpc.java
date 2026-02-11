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
package com.google.cloud.run.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The Cloud Run Instances API allows you to manage Cloud Run Instances.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class InstancesGrpc {

  private InstancesGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.run.v2.Instances";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.CreateInstanceRequest, com.google.longrunning.Operation>
      getCreateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInstance",
      requestType = com.google.cloud.run.v2.CreateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.CreateInstanceRequest, com.google.longrunning.Operation>
      getCreateInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.run.v2.CreateInstanceRequest, com.google.longrunning.Operation>
        getCreateInstanceMethod;
    if ((getCreateInstanceMethod = InstancesGrpc.getCreateInstanceMethod) == null) {
      synchronized (InstancesGrpc.class) {
        if ((getCreateInstanceMethod = InstancesGrpc.getCreateInstanceMethod) == null) {
          InstancesGrpc.getCreateInstanceMethod =
              getCreateInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.CreateInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.CreateInstanceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new InstancesMethodDescriptorSupplier("CreateInstance"))
                      .build();
        }
      }
    }
    return getCreateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.DeleteInstanceRequest, com.google.longrunning.Operation>
      getDeleteInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInstance",
      requestType = com.google.cloud.run.v2.DeleteInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.DeleteInstanceRequest, com.google.longrunning.Operation>
      getDeleteInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.run.v2.DeleteInstanceRequest, com.google.longrunning.Operation>
        getDeleteInstanceMethod;
    if ((getDeleteInstanceMethod = InstancesGrpc.getDeleteInstanceMethod) == null) {
      synchronized (InstancesGrpc.class) {
        if ((getDeleteInstanceMethod = InstancesGrpc.getDeleteInstanceMethod) == null) {
          InstancesGrpc.getDeleteInstanceMethod =
              getDeleteInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.DeleteInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.DeleteInstanceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new InstancesMethodDescriptorSupplier("DeleteInstance"))
                      .build();
        }
      }
    }
    return getDeleteInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.GetInstanceRequest, com.google.cloud.run.v2.Instance>
      getGetInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstance",
      requestType = com.google.cloud.run.v2.GetInstanceRequest.class,
      responseType = com.google.cloud.run.v2.Instance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.GetInstanceRequest, com.google.cloud.run.v2.Instance>
      getGetInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.run.v2.GetInstanceRequest, com.google.cloud.run.v2.Instance>
        getGetInstanceMethod;
    if ((getGetInstanceMethod = InstancesGrpc.getGetInstanceMethod) == null) {
      synchronized (InstancesGrpc.class) {
        if ((getGetInstanceMethod = InstancesGrpc.getGetInstanceMethod) == null) {
          InstancesGrpc.getGetInstanceMethod =
              getGetInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.GetInstanceRequest,
                          com.google.cloud.run.v2.Instance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.GetInstanceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.Instance.getDefaultInstance()))
                      .setSchemaDescriptor(new InstancesMethodDescriptorSupplier("GetInstance"))
                      .build();
        }
      }
    }
    return getGetInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.ListInstancesRequest,
          com.google.cloud.run.v2.ListInstancesResponse>
      getListInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInstances",
      requestType = com.google.cloud.run.v2.ListInstancesRequest.class,
      responseType = com.google.cloud.run.v2.ListInstancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.ListInstancesRequest,
          com.google.cloud.run.v2.ListInstancesResponse>
      getListInstancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.run.v2.ListInstancesRequest,
            com.google.cloud.run.v2.ListInstancesResponse>
        getListInstancesMethod;
    if ((getListInstancesMethod = InstancesGrpc.getListInstancesMethod) == null) {
      synchronized (InstancesGrpc.class) {
        if ((getListInstancesMethod = InstancesGrpc.getListInstancesMethod) == null) {
          InstancesGrpc.getListInstancesMethod =
              getListInstancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.ListInstancesRequest,
                          com.google.cloud.run.v2.ListInstancesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInstances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.ListInstancesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.ListInstancesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new InstancesMethodDescriptorSupplier("ListInstances"))
                      .build();
        }
      }
    }
    return getListInstancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.StopInstanceRequest, com.google.longrunning.Operation>
      getStopInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopInstance",
      requestType = com.google.cloud.run.v2.StopInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.StopInstanceRequest, com.google.longrunning.Operation>
      getStopInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.run.v2.StopInstanceRequest, com.google.longrunning.Operation>
        getStopInstanceMethod;
    if ((getStopInstanceMethod = InstancesGrpc.getStopInstanceMethod) == null) {
      synchronized (InstancesGrpc.class) {
        if ((getStopInstanceMethod = InstancesGrpc.getStopInstanceMethod) == null) {
          InstancesGrpc.getStopInstanceMethod =
              getStopInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.StopInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.StopInstanceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new InstancesMethodDescriptorSupplier("StopInstance"))
                      .build();
        }
      }
    }
    return getStopInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.StartInstanceRequest, com.google.longrunning.Operation>
      getStartInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartInstance",
      requestType = com.google.cloud.run.v2.StartInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.StartInstanceRequest, com.google.longrunning.Operation>
      getStartInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.run.v2.StartInstanceRequest, com.google.longrunning.Operation>
        getStartInstanceMethod;
    if ((getStartInstanceMethod = InstancesGrpc.getStartInstanceMethod) == null) {
      synchronized (InstancesGrpc.class) {
        if ((getStartInstanceMethod = InstancesGrpc.getStartInstanceMethod) == null) {
          InstancesGrpc.getStartInstanceMethod =
              getStartInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.StartInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.StartInstanceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new InstancesMethodDescriptorSupplier("StartInstance"))
                      .build();
        }
      }
    }
    return getStartInstanceMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static InstancesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InstancesStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<InstancesStub>() {
          @java.lang.Override
          public InstancesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new InstancesStub(channel, callOptions);
          }
        };
    return InstancesStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static InstancesBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InstancesBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<InstancesBlockingV2Stub>() {
          @java.lang.Override
          public InstancesBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new InstancesBlockingV2Stub(channel, callOptions);
          }
        };
    return InstancesBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InstancesBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InstancesBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<InstancesBlockingStub>() {
          @java.lang.Override
          public InstancesBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new InstancesBlockingStub(channel, callOptions);
          }
        };
    return InstancesBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static InstancesFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InstancesFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<InstancesFutureStub>() {
          @java.lang.Override
          public InstancesFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new InstancesFutureStub(channel, callOptions);
          }
        };
    return InstancesFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The Cloud Run Instances API allows you to manage Cloud Run Instances.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates an Instance.
     * </pre>
     */
    default void createInstance(
        com.google.cloud.run.v2.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Instance
     * </pre>
     */
    default void deleteInstance(
        com.google.cloud.run.v2.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Instance
     * </pre>
     */
    default void getInstance(
        com.google.cloud.run.v2.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.Instance> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances. Results are sorted by creation time, descending.
     * </pre>
     */
    default void listInstances(
        com.google.cloud.run.v2.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.ListInstancesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListInstancesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stops an Instance.
     * </pre>
     */
    default void stopInstance(
        com.google.cloud.run.v2.StopInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStopInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts an Instance.
     * </pre>
     */
    default void startInstance(
        com.google.cloud.run.v2.StartInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStartInstanceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Instances.
   *
   * <pre>
   * The Cloud Run Instances API allows you to manage Cloud Run Instances.
   * </pre>
   */
  public abstract static class InstancesImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return InstancesGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Instances.
   *
   * <pre>
   * The Cloud Run Instances API allows you to manage Cloud Run Instances.
   * </pre>
   */
  public static final class InstancesStub extends io.grpc.stub.AbstractAsyncStub<InstancesStub> {
    private InstancesStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InstancesStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InstancesStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an Instance.
     * </pre>
     */
    public void createInstance(
        com.google.cloud.run.v2.CreateInstanceRequest request,
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
     * Deletes a Instance
     * </pre>
     */
    public void deleteInstance(
        com.google.cloud.run.v2.DeleteInstanceRequest request,
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
     * Gets a Instance
     * </pre>
     */
    public void getInstance(
        com.google.cloud.run.v2.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.Instance> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances. Results are sorted by creation time, descending.
     * </pre>
     */
    public void listInstances(
        com.google.cloud.run.v2.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.ListInstancesResponse>
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
     * Stops an Instance.
     * </pre>
     */
    public void stopInstance(
        com.google.cloud.run.v2.StopInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts an Instance.
     * </pre>
     */
    public void startInstance(
        com.google.cloud.run.v2.StartInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Instances.
   *
   * <pre>
   * The Cloud Run Instances API allows you to manage Cloud Run Instances.
   * </pre>
   */
  public static final class InstancesBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<InstancesBlockingV2Stub> {
    private InstancesBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InstancesBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InstancesBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an Instance.
     * </pre>
     */
    public com.google.longrunning.Operation createInstance(
        com.google.cloud.run.v2.CreateInstanceRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Instance
     * </pre>
     */
    public com.google.longrunning.Operation deleteInstance(
        com.google.cloud.run.v2.DeleteInstanceRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Instance
     * </pre>
     */
    public com.google.cloud.run.v2.Instance getInstance(
        com.google.cloud.run.v2.GetInstanceRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances. Results are sorted by creation time, descending.
     * </pre>
     */
    public com.google.cloud.run.v2.ListInstancesResponse listInstances(
        com.google.cloud.run.v2.ListInstancesRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Stops an Instance.
     * </pre>
     */
    public com.google.longrunning.Operation stopInstance(
        com.google.cloud.run.v2.StopInstanceRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getStopInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts an Instance.
     * </pre>
     */
    public com.google.longrunning.Operation startInstance(
        com.google.cloud.run.v2.StartInstanceRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getStartInstanceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Instances.
   *
   * <pre>
   * The Cloud Run Instances API allows you to manage Cloud Run Instances.
   * </pre>
   */
  public static final class InstancesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<InstancesBlockingStub> {
    private InstancesBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InstancesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InstancesBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an Instance.
     * </pre>
     */
    public com.google.longrunning.Operation createInstance(
        com.google.cloud.run.v2.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Instance
     * </pre>
     */
    public com.google.longrunning.Operation deleteInstance(
        com.google.cloud.run.v2.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Instance
     * </pre>
     */
    public com.google.cloud.run.v2.Instance getInstance(
        com.google.cloud.run.v2.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances. Results are sorted by creation time, descending.
     * </pre>
     */
    public com.google.cloud.run.v2.ListInstancesResponse listInstances(
        com.google.cloud.run.v2.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Stops an Instance.
     * </pre>
     */
    public com.google.longrunning.Operation stopInstance(
        com.google.cloud.run.v2.StopInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts an Instance.
     * </pre>
     */
    public com.google.longrunning.Operation startInstance(
        com.google.cloud.run.v2.StartInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartInstanceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Instances.
   *
   * <pre>
   * The Cloud Run Instances API allows you to manage Cloud Run Instances.
   * </pre>
   */
  public static final class InstancesFutureStub
      extends io.grpc.stub.AbstractFutureStub<InstancesFutureStub> {
    private InstancesFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InstancesFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InstancesFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createInstance(com.google.cloud.run.v2.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Instance
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteInstance(com.google.cloud.run.v2.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Instance
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.run.v2.Instance>
        getInstance(com.google.cloud.run.v2.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances. Results are sorted by creation time, descending.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.run.v2.ListInstancesResponse>
        listInstances(com.google.cloud.run.v2.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Stops an Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        stopInstance(com.google.cloud.run.v2.StopInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Starts an Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        startInstance(com.google.cloud.run.v2.StartInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartInstanceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_INSTANCE = 0;
  private static final int METHODID_DELETE_INSTANCE = 1;
  private static final int METHODID_GET_INSTANCE = 2;
  private static final int METHODID_LIST_INSTANCES = 3;
  private static final int METHODID_STOP_INSTANCE = 4;
  private static final int METHODID_START_INSTANCE = 5;

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
        case METHODID_CREATE_INSTANCE:
          serviceImpl.createInstance(
              (com.google.cloud.run.v2.CreateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INSTANCE:
          serviceImpl.deleteInstance(
              (com.google.cloud.run.v2.DeleteInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_INSTANCE:
          serviceImpl.getInstance(
              (com.google.cloud.run.v2.GetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.run.v2.Instance>) responseObserver);
          break;
        case METHODID_LIST_INSTANCES:
          serviceImpl.listInstances(
              (com.google.cloud.run.v2.ListInstancesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.run.v2.ListInstancesResponse>)
                  responseObserver);
          break;
        case METHODID_STOP_INSTANCE:
          serviceImpl.stopInstance(
              (com.google.cloud.run.v2.StopInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_START_INSTANCE:
          serviceImpl.startInstance(
              (com.google.cloud.run.v2.StartInstanceRequest) request,
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
            getCreateInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.run.v2.CreateInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_INSTANCE)))
        .addMethod(
            getDeleteInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.run.v2.DeleteInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_INSTANCE)))
        .addMethod(
            getGetInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.run.v2.GetInstanceRequest, com.google.cloud.run.v2.Instance>(
                    service, METHODID_GET_INSTANCE)))
        .addMethod(
            getListInstancesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.run.v2.ListInstancesRequest,
                    com.google.cloud.run.v2.ListInstancesResponse>(
                    service, METHODID_LIST_INSTANCES)))
        .addMethod(
            getStopInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.run.v2.StopInstanceRequest, com.google.longrunning.Operation>(
                    service, METHODID_STOP_INSTANCE)))
        .addMethod(
            getStartInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.run.v2.StartInstanceRequest, com.google.longrunning.Operation>(
                    service, METHODID_START_INSTANCE)))
        .build();
  }

  private abstract static class InstancesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    InstancesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.run.v2.InstanceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Instances");
    }
  }

  private static final class InstancesFileDescriptorSupplier
      extends InstancesBaseDescriptorSupplier {
    InstancesFileDescriptorSupplier() {}
  }

  private static final class InstancesMethodDescriptorSupplier
      extends InstancesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    InstancesMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (InstancesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new InstancesFileDescriptorSupplier())
                      .addMethod(getCreateInstanceMethod())
                      .addMethod(getDeleteInstanceMethod())
                      .addMethod(getGetInstanceMethod())
                      .addMethod(getListInstancesMethod())
                      .addMethod(getStopInstanceMethod())
                      .addMethod(getStartInstanceMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
