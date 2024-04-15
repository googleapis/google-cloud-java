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
package com.google.cloud.discoveryengine.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing [Engine][google.cloud.discoveryengine.v1beta.Engine]
 * configuration.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1beta/engine_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EngineServiceGrpc {

  private EngineServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1beta.EngineService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.CreateEngineRequest,
          com.google.longrunning.Operation>
      getCreateEngineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEngine",
      requestType = com.google.cloud.discoveryengine.v1beta.CreateEngineRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.CreateEngineRequest,
          com.google.longrunning.Operation>
      getCreateEngineMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.CreateEngineRequest,
            com.google.longrunning.Operation>
        getCreateEngineMethod;
    if ((getCreateEngineMethod = EngineServiceGrpc.getCreateEngineMethod) == null) {
      synchronized (EngineServiceGrpc.class) {
        if ((getCreateEngineMethod = EngineServiceGrpc.getCreateEngineMethod) == null) {
          EngineServiceGrpc.getCreateEngineMethod =
              getCreateEngineMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.CreateEngineRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEngine"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.CreateEngineRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EngineServiceMethodDescriptorSupplier("CreateEngine"))
                      .build();
        }
      }
    }
    return getCreateEngineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.DeleteEngineRequest,
          com.google.longrunning.Operation>
      getDeleteEngineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEngine",
      requestType = com.google.cloud.discoveryengine.v1beta.DeleteEngineRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.DeleteEngineRequest,
          com.google.longrunning.Operation>
      getDeleteEngineMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.DeleteEngineRequest,
            com.google.longrunning.Operation>
        getDeleteEngineMethod;
    if ((getDeleteEngineMethod = EngineServiceGrpc.getDeleteEngineMethod) == null) {
      synchronized (EngineServiceGrpc.class) {
        if ((getDeleteEngineMethod = EngineServiceGrpc.getDeleteEngineMethod) == null) {
          EngineServiceGrpc.getDeleteEngineMethod =
              getDeleteEngineMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.DeleteEngineRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEngine"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.DeleteEngineRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EngineServiceMethodDescriptorSupplier("DeleteEngine"))
                      .build();
        }
      }
    }
    return getDeleteEngineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.UpdateEngineRequest,
          com.google.cloud.discoveryengine.v1beta.Engine>
      getUpdateEngineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEngine",
      requestType = com.google.cloud.discoveryengine.v1beta.UpdateEngineRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.Engine.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.UpdateEngineRequest,
          com.google.cloud.discoveryengine.v1beta.Engine>
      getUpdateEngineMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.UpdateEngineRequest,
            com.google.cloud.discoveryengine.v1beta.Engine>
        getUpdateEngineMethod;
    if ((getUpdateEngineMethod = EngineServiceGrpc.getUpdateEngineMethod) == null) {
      synchronized (EngineServiceGrpc.class) {
        if ((getUpdateEngineMethod = EngineServiceGrpc.getUpdateEngineMethod) == null) {
          EngineServiceGrpc.getUpdateEngineMethod =
              getUpdateEngineMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.UpdateEngineRequest,
                          com.google.cloud.discoveryengine.v1beta.Engine>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEngine"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.UpdateEngineRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.Engine.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EngineServiceMethodDescriptorSupplier("UpdateEngine"))
                      .build();
        }
      }
    }
    return getUpdateEngineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.GetEngineRequest,
          com.google.cloud.discoveryengine.v1beta.Engine>
      getGetEngineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEngine",
      requestType = com.google.cloud.discoveryengine.v1beta.GetEngineRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.Engine.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.GetEngineRequest,
          com.google.cloud.discoveryengine.v1beta.Engine>
      getGetEngineMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.GetEngineRequest,
            com.google.cloud.discoveryengine.v1beta.Engine>
        getGetEngineMethod;
    if ((getGetEngineMethod = EngineServiceGrpc.getGetEngineMethod) == null) {
      synchronized (EngineServiceGrpc.class) {
        if ((getGetEngineMethod = EngineServiceGrpc.getGetEngineMethod) == null) {
          EngineServiceGrpc.getGetEngineMethod =
              getGetEngineMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.GetEngineRequest,
                          com.google.cloud.discoveryengine.v1beta.Engine>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEngine"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.GetEngineRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.Engine.getDefaultInstance()))
                      .setSchemaDescriptor(new EngineServiceMethodDescriptorSupplier("GetEngine"))
                      .build();
        }
      }
    }
    return getGetEngineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ListEnginesRequest,
          com.google.cloud.discoveryengine.v1beta.ListEnginesResponse>
      getListEnginesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEngines",
      requestType = com.google.cloud.discoveryengine.v1beta.ListEnginesRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.ListEnginesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ListEnginesRequest,
          com.google.cloud.discoveryengine.v1beta.ListEnginesResponse>
      getListEnginesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.ListEnginesRequest,
            com.google.cloud.discoveryengine.v1beta.ListEnginesResponse>
        getListEnginesMethod;
    if ((getListEnginesMethod = EngineServiceGrpc.getListEnginesMethod) == null) {
      synchronized (EngineServiceGrpc.class) {
        if ((getListEnginesMethod = EngineServiceGrpc.getListEnginesMethod) == null) {
          EngineServiceGrpc.getListEnginesMethod =
              getListEnginesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.ListEnginesRequest,
                          com.google.cloud.discoveryengine.v1beta.ListEnginesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEngines"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ListEnginesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ListEnginesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new EngineServiceMethodDescriptorSupplier("ListEngines"))
                      .build();
        }
      }
    }
    return getListEnginesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.PauseEngineRequest,
          com.google.cloud.discoveryengine.v1beta.Engine>
      getPauseEngineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PauseEngine",
      requestType = com.google.cloud.discoveryengine.v1beta.PauseEngineRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.Engine.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.PauseEngineRequest,
          com.google.cloud.discoveryengine.v1beta.Engine>
      getPauseEngineMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.PauseEngineRequest,
            com.google.cloud.discoveryengine.v1beta.Engine>
        getPauseEngineMethod;
    if ((getPauseEngineMethod = EngineServiceGrpc.getPauseEngineMethod) == null) {
      synchronized (EngineServiceGrpc.class) {
        if ((getPauseEngineMethod = EngineServiceGrpc.getPauseEngineMethod) == null) {
          EngineServiceGrpc.getPauseEngineMethod =
              getPauseEngineMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.PauseEngineRequest,
                          com.google.cloud.discoveryengine.v1beta.Engine>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PauseEngine"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.PauseEngineRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.Engine.getDefaultInstance()))
                      .setSchemaDescriptor(new EngineServiceMethodDescriptorSupplier("PauseEngine"))
                      .build();
        }
      }
    }
    return getPauseEngineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ResumeEngineRequest,
          com.google.cloud.discoveryengine.v1beta.Engine>
      getResumeEngineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResumeEngine",
      requestType = com.google.cloud.discoveryengine.v1beta.ResumeEngineRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.Engine.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ResumeEngineRequest,
          com.google.cloud.discoveryengine.v1beta.Engine>
      getResumeEngineMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.ResumeEngineRequest,
            com.google.cloud.discoveryengine.v1beta.Engine>
        getResumeEngineMethod;
    if ((getResumeEngineMethod = EngineServiceGrpc.getResumeEngineMethod) == null) {
      synchronized (EngineServiceGrpc.class) {
        if ((getResumeEngineMethod = EngineServiceGrpc.getResumeEngineMethod) == null) {
          EngineServiceGrpc.getResumeEngineMethod =
              getResumeEngineMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.ResumeEngineRequest,
                          com.google.cloud.discoveryengine.v1beta.Engine>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResumeEngine"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ResumeEngineRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.Engine.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EngineServiceMethodDescriptorSupplier("ResumeEngine"))
                      .build();
        }
      }
    }
    return getResumeEngineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.TuneEngineRequest,
          com.google.longrunning.Operation>
      getTuneEngineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TuneEngine",
      requestType = com.google.cloud.discoveryengine.v1beta.TuneEngineRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.TuneEngineRequest,
          com.google.longrunning.Operation>
      getTuneEngineMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.TuneEngineRequest,
            com.google.longrunning.Operation>
        getTuneEngineMethod;
    if ((getTuneEngineMethod = EngineServiceGrpc.getTuneEngineMethod) == null) {
      synchronized (EngineServiceGrpc.class) {
        if ((getTuneEngineMethod = EngineServiceGrpc.getTuneEngineMethod) == null) {
          EngineServiceGrpc.getTuneEngineMethod =
              getTuneEngineMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.TuneEngineRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TuneEngine"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.TuneEngineRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new EngineServiceMethodDescriptorSupplier("TuneEngine"))
                      .build();
        }
      }
    }
    return getTuneEngineMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static EngineServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EngineServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EngineServiceStub>() {
          @java.lang.Override
          public EngineServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EngineServiceStub(channel, callOptions);
          }
        };
    return EngineServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EngineServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EngineServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EngineServiceBlockingStub>() {
          @java.lang.Override
          public EngineServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EngineServiceBlockingStub(channel, callOptions);
          }
        };
    return EngineServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static EngineServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EngineServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EngineServiceFutureStub>() {
          @java.lang.Override
          public EngineServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EngineServiceFutureStub(channel, callOptions);
          }
        };
    return EngineServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Engine][google.cloud.discoveryengine.v1beta.Engine]
   * configuration.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a [Engine][google.cloud.discoveryengine.v1beta.Engine].
     * </pre>
     */
    default void createEngine(
        com.google.cloud.discoveryengine.v1beta.CreateEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEngineMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [Engine][google.cloud.discoveryengine.v1beta.Engine].
     * </pre>
     */
    default void deleteEngine(
        com.google.cloud.discoveryengine.v1beta.DeleteEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEngineMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an [Engine][google.cloud.discoveryengine.v1beta.Engine]
     * </pre>
     */
    default void updateEngine(
        com.google.cloud.discoveryengine.v1beta.UpdateEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Engine>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEngineMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a [Engine][google.cloud.discoveryengine.v1beta.Engine].
     * </pre>
     */
    default void getEngine(
        com.google.cloud.discoveryengine.v1beta.GetEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Engine>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEngineMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the [Engine][google.cloud.discoveryengine.v1beta.Engine]s
     * associated with the project.
     * </pre>
     */
    default void listEngines(
        com.google.cloud.discoveryengine.v1beta.ListEnginesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.ListEnginesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEnginesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pauses the training of an existing engine. Only applicable if
     * [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is
     * [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].
     * </pre>
     */
    default void pauseEngine(
        com.google.cloud.discoveryengine.v1beta.PauseEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Engine>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPauseEngineMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resumes the training of an existing engine. Only applicable if
     * [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is
     * [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].
     * </pre>
     */
    default void resumeEngine(
        com.google.cloud.discoveryengine.v1beta.ResumeEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Engine>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResumeEngineMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Tunes an existing engine. Only applicable if
     * [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is
     * [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].
     * </pre>
     */
    default void tuneEngine(
        com.google.cloud.discoveryengine.v1beta.TuneEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTuneEngineMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service EngineService.
   *
   * <pre>
   * Service for managing [Engine][google.cloud.discoveryengine.v1beta.Engine]
   * configuration.
   * </pre>
   */
  public abstract static class EngineServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return EngineServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service EngineService.
   *
   * <pre>
   * Service for managing [Engine][google.cloud.discoveryengine.v1beta.Engine]
   * configuration.
   * </pre>
   */
  public static final class EngineServiceStub
      extends io.grpc.stub.AbstractAsyncStub<EngineServiceStub> {
    private EngineServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EngineServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EngineServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Engine][google.cloud.discoveryengine.v1beta.Engine].
     * </pre>
     */
    public void createEngine(
        com.google.cloud.discoveryengine.v1beta.CreateEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEngineMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [Engine][google.cloud.discoveryengine.v1beta.Engine].
     * </pre>
     */
    public void deleteEngine(
        com.google.cloud.discoveryengine.v1beta.DeleteEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEngineMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an [Engine][google.cloud.discoveryengine.v1beta.Engine]
     * </pre>
     */
    public void updateEngine(
        com.google.cloud.discoveryengine.v1beta.UpdateEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Engine>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEngineMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a [Engine][google.cloud.discoveryengine.v1beta.Engine].
     * </pre>
     */
    public void getEngine(
        com.google.cloud.discoveryengine.v1beta.GetEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Engine>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEngineMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the [Engine][google.cloud.discoveryengine.v1beta.Engine]s
     * associated with the project.
     * </pre>
     */
    public void listEngines(
        com.google.cloud.discoveryengine.v1beta.ListEnginesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.ListEnginesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEnginesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pauses the training of an existing engine. Only applicable if
     * [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is
     * [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].
     * </pre>
     */
    public void pauseEngine(
        com.google.cloud.discoveryengine.v1beta.PauseEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Engine>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPauseEngineMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resumes the training of an existing engine. Only applicable if
     * [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is
     * [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].
     * </pre>
     */
    public void resumeEngine(
        com.google.cloud.discoveryengine.v1beta.ResumeEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Engine>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResumeEngineMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Tunes an existing engine. Only applicable if
     * [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is
     * [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].
     * </pre>
     */
    public void tuneEngine(
        com.google.cloud.discoveryengine.v1beta.TuneEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTuneEngineMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service EngineService.
   *
   * <pre>
   * Service for managing [Engine][google.cloud.discoveryengine.v1beta.Engine]
   * configuration.
   * </pre>
   */
  public static final class EngineServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EngineServiceBlockingStub> {
    private EngineServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EngineServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EngineServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Engine][google.cloud.discoveryengine.v1beta.Engine].
     * </pre>
     */
    public com.google.longrunning.Operation createEngine(
        com.google.cloud.discoveryengine.v1beta.CreateEngineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEngineMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [Engine][google.cloud.discoveryengine.v1beta.Engine].
     * </pre>
     */
    public com.google.longrunning.Operation deleteEngine(
        com.google.cloud.discoveryengine.v1beta.DeleteEngineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEngineMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an [Engine][google.cloud.discoveryengine.v1beta.Engine]
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.Engine updateEngine(
        com.google.cloud.discoveryengine.v1beta.UpdateEngineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEngineMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a [Engine][google.cloud.discoveryengine.v1beta.Engine].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.Engine getEngine(
        com.google.cloud.discoveryengine.v1beta.GetEngineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEngineMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the [Engine][google.cloud.discoveryengine.v1beta.Engine]s
     * associated with the project.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.ListEnginesResponse listEngines(
        com.google.cloud.discoveryengine.v1beta.ListEnginesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEnginesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Pauses the training of an existing engine. Only applicable if
     * [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is
     * [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.Engine pauseEngine(
        com.google.cloud.discoveryengine.v1beta.PauseEngineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPauseEngineMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resumes the training of an existing engine. Only applicable if
     * [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is
     * [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.Engine resumeEngine(
        com.google.cloud.discoveryengine.v1beta.ResumeEngineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResumeEngineMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Tunes an existing engine. Only applicable if
     * [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is
     * [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].
     * </pre>
     */
    public com.google.longrunning.Operation tuneEngine(
        com.google.cloud.discoveryengine.v1beta.TuneEngineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTuneEngineMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service EngineService.
   *
   * <pre>
   * Service for managing [Engine][google.cloud.discoveryengine.v1beta.Engine]
   * configuration.
   * </pre>
   */
  public static final class EngineServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<EngineServiceFutureStub> {
    private EngineServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EngineServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EngineServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Engine][google.cloud.discoveryengine.v1beta.Engine].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createEngine(com.google.cloud.discoveryengine.v1beta.CreateEngineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEngineMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [Engine][google.cloud.discoveryengine.v1beta.Engine].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteEngine(com.google.cloud.discoveryengine.v1beta.DeleteEngineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEngineMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an [Engine][google.cloud.discoveryengine.v1beta.Engine]
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.Engine>
        updateEngine(com.google.cloud.discoveryengine.v1beta.UpdateEngineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEngineMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a [Engine][google.cloud.discoveryengine.v1beta.Engine].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.Engine>
        getEngine(com.google.cloud.discoveryengine.v1beta.GetEngineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEngineMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the [Engine][google.cloud.discoveryengine.v1beta.Engine]s
     * associated with the project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.ListEnginesResponse>
        listEngines(com.google.cloud.discoveryengine.v1beta.ListEnginesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEnginesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Pauses the training of an existing engine. Only applicable if
     * [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is
     * [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.Engine>
        pauseEngine(com.google.cloud.discoveryengine.v1beta.PauseEngineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPauseEngineMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Resumes the training of an existing engine. Only applicable if
     * [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is
     * [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.Engine>
        resumeEngine(com.google.cloud.discoveryengine.v1beta.ResumeEngineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResumeEngineMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Tunes an existing engine. Only applicable if
     * [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is
     * [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        tuneEngine(com.google.cloud.discoveryengine.v1beta.TuneEngineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTuneEngineMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ENGINE = 0;
  private static final int METHODID_DELETE_ENGINE = 1;
  private static final int METHODID_UPDATE_ENGINE = 2;
  private static final int METHODID_GET_ENGINE = 3;
  private static final int METHODID_LIST_ENGINES = 4;
  private static final int METHODID_PAUSE_ENGINE = 5;
  private static final int METHODID_RESUME_ENGINE = 6;
  private static final int METHODID_TUNE_ENGINE = 7;

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
        case METHODID_CREATE_ENGINE:
          serviceImpl.createEngine(
              (com.google.cloud.discoveryengine.v1beta.CreateEngineRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ENGINE:
          serviceImpl.deleteEngine(
              (com.google.cloud.discoveryengine.v1beta.DeleteEngineRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ENGINE:
          serviceImpl.updateEngine(
              (com.google.cloud.discoveryengine.v1beta.UpdateEngineRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Engine>)
                  responseObserver);
          break;
        case METHODID_GET_ENGINE:
          serviceImpl.getEngine(
              (com.google.cloud.discoveryengine.v1beta.GetEngineRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Engine>)
                  responseObserver);
          break;
        case METHODID_LIST_ENGINES:
          serviceImpl.listEngines(
              (com.google.cloud.discoveryengine.v1beta.ListEnginesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1beta.ListEnginesResponse>)
                  responseObserver);
          break;
        case METHODID_PAUSE_ENGINE:
          serviceImpl.pauseEngine(
              (com.google.cloud.discoveryengine.v1beta.PauseEngineRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Engine>)
                  responseObserver);
          break;
        case METHODID_RESUME_ENGINE:
          serviceImpl.resumeEngine(
              (com.google.cloud.discoveryengine.v1beta.ResumeEngineRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Engine>)
                  responseObserver);
          break;
        case METHODID_TUNE_ENGINE:
          serviceImpl.tuneEngine(
              (com.google.cloud.discoveryengine.v1beta.TuneEngineRequest) request,
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
            getCreateEngineMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.CreateEngineRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_ENGINE)))
        .addMethod(
            getDeleteEngineMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.DeleteEngineRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_ENGINE)))
        .addMethod(
            getUpdateEngineMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.UpdateEngineRequest,
                    com.google.cloud.discoveryengine.v1beta.Engine>(
                    service, METHODID_UPDATE_ENGINE)))
        .addMethod(
            getGetEngineMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.GetEngineRequest,
                    com.google.cloud.discoveryengine.v1beta.Engine>(service, METHODID_GET_ENGINE)))
        .addMethod(
            getListEnginesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.ListEnginesRequest,
                    com.google.cloud.discoveryengine.v1beta.ListEnginesResponse>(
                    service, METHODID_LIST_ENGINES)))
        .addMethod(
            getPauseEngineMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.PauseEngineRequest,
                    com.google.cloud.discoveryengine.v1beta.Engine>(
                    service, METHODID_PAUSE_ENGINE)))
        .addMethod(
            getResumeEngineMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.ResumeEngineRequest,
                    com.google.cloud.discoveryengine.v1beta.Engine>(
                    service, METHODID_RESUME_ENGINE)))
        .addMethod(
            getTuneEngineMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.TuneEngineRequest,
                    com.google.longrunning.Operation>(service, METHODID_TUNE_ENGINE)))
        .build();
  }

  private abstract static class EngineServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EngineServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1beta.EngineServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EngineService");
    }
  }

  private static final class EngineServiceFileDescriptorSupplier
      extends EngineServiceBaseDescriptorSupplier {
    EngineServiceFileDescriptorSupplier() {}
  }

  private static final class EngineServiceMethodDescriptorSupplier
      extends EngineServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    EngineServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (EngineServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new EngineServiceFileDescriptorSupplier())
                      .addMethod(getCreateEngineMethod())
                      .addMethod(getDeleteEngineMethod())
                      .addMethod(getUpdateEngineMethod())
                      .addMethod(getGetEngineMethod())
                      .addMethod(getListEnginesMethod())
                      .addMethod(getPauseEngineMethod())
                      .addMethod(getResumeEngineMethod())
                      .addMethod(getTuneEngineMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
