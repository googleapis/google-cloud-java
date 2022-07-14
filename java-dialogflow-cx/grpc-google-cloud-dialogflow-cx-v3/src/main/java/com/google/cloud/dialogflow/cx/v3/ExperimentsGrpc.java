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
 * Service for managing [Experiments][google.cloud.dialogflow.cx.v3.Experiment].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/cx/v3/experiment.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ExperimentsGrpc {

  private ExperimentsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.cx.v3.Experiments";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.ListExperimentsRequest,
          com.google.cloud.dialogflow.cx.v3.ListExperimentsResponse>
      getListExperimentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListExperiments",
      requestType = com.google.cloud.dialogflow.cx.v3.ListExperimentsRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.ListExperimentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.ListExperimentsRequest,
          com.google.cloud.dialogflow.cx.v3.ListExperimentsResponse>
      getListExperimentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.ListExperimentsRequest,
            com.google.cloud.dialogflow.cx.v3.ListExperimentsResponse>
        getListExperimentsMethod;
    if ((getListExperimentsMethod = ExperimentsGrpc.getListExperimentsMethod) == null) {
      synchronized (ExperimentsGrpc.class) {
        if ((getListExperimentsMethod = ExperimentsGrpc.getListExperimentsMethod) == null) {
          ExperimentsGrpc.getListExperimentsMethod =
              getListExperimentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.ListExperimentsRequest,
                          com.google.cloud.dialogflow.cx.v3.ListExperimentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListExperiments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.ListExperimentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.ListExperimentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ExperimentsMethodDescriptorSupplier("ListExperiments"))
                      .build();
        }
      }
    }
    return getListExperimentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.GetExperimentRequest,
          com.google.cloud.dialogflow.cx.v3.Experiment>
      getGetExperimentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetExperiment",
      requestType = com.google.cloud.dialogflow.cx.v3.GetExperimentRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.Experiment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.GetExperimentRequest,
          com.google.cloud.dialogflow.cx.v3.Experiment>
      getGetExperimentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.GetExperimentRequest,
            com.google.cloud.dialogflow.cx.v3.Experiment>
        getGetExperimentMethod;
    if ((getGetExperimentMethod = ExperimentsGrpc.getGetExperimentMethod) == null) {
      synchronized (ExperimentsGrpc.class) {
        if ((getGetExperimentMethod = ExperimentsGrpc.getGetExperimentMethod) == null) {
          ExperimentsGrpc.getGetExperimentMethod =
              getGetExperimentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.GetExperimentRequest,
                          com.google.cloud.dialogflow.cx.v3.Experiment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetExperiment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.GetExperimentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.Experiment.getDefaultInstance()))
                      .setSchemaDescriptor(new ExperimentsMethodDescriptorSupplier("GetExperiment"))
                      .build();
        }
      }
    }
    return getGetExperimentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.CreateExperimentRequest,
          com.google.cloud.dialogflow.cx.v3.Experiment>
      getCreateExperimentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateExperiment",
      requestType = com.google.cloud.dialogflow.cx.v3.CreateExperimentRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.Experiment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.CreateExperimentRequest,
          com.google.cloud.dialogflow.cx.v3.Experiment>
      getCreateExperimentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.CreateExperimentRequest,
            com.google.cloud.dialogflow.cx.v3.Experiment>
        getCreateExperimentMethod;
    if ((getCreateExperimentMethod = ExperimentsGrpc.getCreateExperimentMethod) == null) {
      synchronized (ExperimentsGrpc.class) {
        if ((getCreateExperimentMethod = ExperimentsGrpc.getCreateExperimentMethod) == null) {
          ExperimentsGrpc.getCreateExperimentMethod =
              getCreateExperimentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.CreateExperimentRequest,
                          com.google.cloud.dialogflow.cx.v3.Experiment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateExperiment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.CreateExperimentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.Experiment.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ExperimentsMethodDescriptorSupplier("CreateExperiment"))
                      .build();
        }
      }
    }
    return getCreateExperimentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.UpdateExperimentRequest,
          com.google.cloud.dialogflow.cx.v3.Experiment>
      getUpdateExperimentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateExperiment",
      requestType = com.google.cloud.dialogflow.cx.v3.UpdateExperimentRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.Experiment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.UpdateExperimentRequest,
          com.google.cloud.dialogflow.cx.v3.Experiment>
      getUpdateExperimentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.UpdateExperimentRequest,
            com.google.cloud.dialogflow.cx.v3.Experiment>
        getUpdateExperimentMethod;
    if ((getUpdateExperimentMethod = ExperimentsGrpc.getUpdateExperimentMethod) == null) {
      synchronized (ExperimentsGrpc.class) {
        if ((getUpdateExperimentMethod = ExperimentsGrpc.getUpdateExperimentMethod) == null) {
          ExperimentsGrpc.getUpdateExperimentMethod =
              getUpdateExperimentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.UpdateExperimentRequest,
                          com.google.cloud.dialogflow.cx.v3.Experiment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateExperiment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.UpdateExperimentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.Experiment.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ExperimentsMethodDescriptorSupplier("UpdateExperiment"))
                      .build();
        }
      }
    }
    return getUpdateExperimentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.DeleteExperimentRequest, com.google.protobuf.Empty>
      getDeleteExperimentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteExperiment",
      requestType = com.google.cloud.dialogflow.cx.v3.DeleteExperimentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.DeleteExperimentRequest, com.google.protobuf.Empty>
      getDeleteExperimentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.DeleteExperimentRequest, com.google.protobuf.Empty>
        getDeleteExperimentMethod;
    if ((getDeleteExperimentMethod = ExperimentsGrpc.getDeleteExperimentMethod) == null) {
      synchronized (ExperimentsGrpc.class) {
        if ((getDeleteExperimentMethod = ExperimentsGrpc.getDeleteExperimentMethod) == null) {
          ExperimentsGrpc.getDeleteExperimentMethod =
              getDeleteExperimentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.DeleteExperimentRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteExperiment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.DeleteExperimentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ExperimentsMethodDescriptorSupplier("DeleteExperiment"))
                      .build();
        }
      }
    }
    return getDeleteExperimentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.StartExperimentRequest,
          com.google.cloud.dialogflow.cx.v3.Experiment>
      getStartExperimentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartExperiment",
      requestType = com.google.cloud.dialogflow.cx.v3.StartExperimentRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.Experiment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.StartExperimentRequest,
          com.google.cloud.dialogflow.cx.v3.Experiment>
      getStartExperimentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.StartExperimentRequest,
            com.google.cloud.dialogflow.cx.v3.Experiment>
        getStartExperimentMethod;
    if ((getStartExperimentMethod = ExperimentsGrpc.getStartExperimentMethod) == null) {
      synchronized (ExperimentsGrpc.class) {
        if ((getStartExperimentMethod = ExperimentsGrpc.getStartExperimentMethod) == null) {
          ExperimentsGrpc.getStartExperimentMethod =
              getStartExperimentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.StartExperimentRequest,
                          com.google.cloud.dialogflow.cx.v3.Experiment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartExperiment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.StartExperimentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.Experiment.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ExperimentsMethodDescriptorSupplier("StartExperiment"))
                      .build();
        }
      }
    }
    return getStartExperimentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.StopExperimentRequest,
          com.google.cloud.dialogflow.cx.v3.Experiment>
      getStopExperimentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopExperiment",
      requestType = com.google.cloud.dialogflow.cx.v3.StopExperimentRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.Experiment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.StopExperimentRequest,
          com.google.cloud.dialogflow.cx.v3.Experiment>
      getStopExperimentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.StopExperimentRequest,
            com.google.cloud.dialogflow.cx.v3.Experiment>
        getStopExperimentMethod;
    if ((getStopExperimentMethod = ExperimentsGrpc.getStopExperimentMethod) == null) {
      synchronized (ExperimentsGrpc.class) {
        if ((getStopExperimentMethod = ExperimentsGrpc.getStopExperimentMethod) == null) {
          ExperimentsGrpc.getStopExperimentMethod =
              getStopExperimentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.StopExperimentRequest,
                          com.google.cloud.dialogflow.cx.v3.Experiment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopExperiment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.StopExperimentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.Experiment.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ExperimentsMethodDescriptorSupplier("StopExperiment"))
                      .build();
        }
      }
    }
    return getStopExperimentMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ExperimentsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExperimentsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ExperimentsStub>() {
          @java.lang.Override
          public ExperimentsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ExperimentsStub(channel, callOptions);
          }
        };
    return ExperimentsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ExperimentsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExperimentsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ExperimentsBlockingStub>() {
          @java.lang.Override
          public ExperimentsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ExperimentsBlockingStub(channel, callOptions);
          }
        };
    return ExperimentsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ExperimentsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExperimentsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ExperimentsFutureStub>() {
          @java.lang.Override
          public ExperimentsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ExperimentsFutureStub(channel, callOptions);
          }
        };
    return ExperimentsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Experiments][google.cloud.dialogflow.cx.v3.Experiment].
   * </pre>
   */
  public abstract static class ExperimentsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Returns the list of all experiments in the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * </pre>
     */
    public void listExperiments(
        com.google.cloud.dialogflow.cx.v3.ListExperimentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListExperimentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListExperimentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment].
     * </pre>
     */
    public void getExperiment(
        com.google.cloud.dialogflow.cx.v3.GetExperimentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Experiment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetExperimentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an [Experiment][google.cloud.dialogflow.cx.v3.Experiment] in the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * </pre>
     */
    public void createExperiment(
        com.google.cloud.dialogflow.cx.v3.CreateExperimentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Experiment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateExperimentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment].
     * </pre>
     */
    public void updateExperiment(
        com.google.cloud.dialogflow.cx.v3.UpdateExperimentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Experiment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateExperimentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment].
     * </pre>
     */
    public void deleteExperiment(
        com.google.cloud.dialogflow.cx.v3.DeleteExperimentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteExperimentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment]. This rpc only changes the state of
     * experiment from PENDING to RUNNING.
     * </pre>
     */
    public void startExperiment(
        com.google.cloud.dialogflow.cx.v3.StartExperimentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Experiment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStartExperimentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stops the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment]. This rpc only changes the state of
     * experiment from RUNNING to DONE.
     * </pre>
     */
    public void stopExperiment(
        com.google.cloud.dialogflow.cx.v3.StopExperimentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Experiment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStopExperimentMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListExperimentsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3.ListExperimentsRequest,
                      com.google.cloud.dialogflow.cx.v3.ListExperimentsResponse>(
                      this, METHODID_LIST_EXPERIMENTS)))
          .addMethod(
              getGetExperimentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3.GetExperimentRequest,
                      com.google.cloud.dialogflow.cx.v3.Experiment>(this, METHODID_GET_EXPERIMENT)))
          .addMethod(
              getCreateExperimentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3.CreateExperimentRequest,
                      com.google.cloud.dialogflow.cx.v3.Experiment>(
                      this, METHODID_CREATE_EXPERIMENT)))
          .addMethod(
              getUpdateExperimentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3.UpdateExperimentRequest,
                      com.google.cloud.dialogflow.cx.v3.Experiment>(
                      this, METHODID_UPDATE_EXPERIMENT)))
          .addMethod(
              getDeleteExperimentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3.DeleteExperimentRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_EXPERIMENT)))
          .addMethod(
              getStartExperimentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3.StartExperimentRequest,
                      com.google.cloud.dialogflow.cx.v3.Experiment>(
                      this, METHODID_START_EXPERIMENT)))
          .addMethod(
              getStopExperimentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3.StopExperimentRequest,
                      com.google.cloud.dialogflow.cx.v3.Experiment>(
                      this, METHODID_STOP_EXPERIMENT)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Experiments][google.cloud.dialogflow.cx.v3.Experiment].
   * </pre>
   */
  public static final class ExperimentsStub
      extends io.grpc.stub.AbstractAsyncStub<ExperimentsStub> {
    private ExperimentsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExperimentsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExperimentsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all experiments in the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * </pre>
     */
    public void listExperiments(
        com.google.cloud.dialogflow.cx.v3.ListExperimentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListExperimentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListExperimentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment].
     * </pre>
     */
    public void getExperiment(
        com.google.cloud.dialogflow.cx.v3.GetExperimentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Experiment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetExperimentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an [Experiment][google.cloud.dialogflow.cx.v3.Experiment] in the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * </pre>
     */
    public void createExperiment(
        com.google.cloud.dialogflow.cx.v3.CreateExperimentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Experiment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateExperimentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment].
     * </pre>
     */
    public void updateExperiment(
        com.google.cloud.dialogflow.cx.v3.UpdateExperimentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Experiment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateExperimentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment].
     * </pre>
     */
    public void deleteExperiment(
        com.google.cloud.dialogflow.cx.v3.DeleteExperimentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteExperimentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment]. This rpc only changes the state of
     * experiment from PENDING to RUNNING.
     * </pre>
     */
    public void startExperiment(
        com.google.cloud.dialogflow.cx.v3.StartExperimentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Experiment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartExperimentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stops the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment]. This rpc only changes the state of
     * experiment from RUNNING to DONE.
     * </pre>
     */
    public void stopExperiment(
        com.google.cloud.dialogflow.cx.v3.StopExperimentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Experiment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopExperimentMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Experiments][google.cloud.dialogflow.cx.v3.Experiment].
   * </pre>
   */
  public static final class ExperimentsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ExperimentsBlockingStub> {
    private ExperimentsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExperimentsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExperimentsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all experiments in the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.ListExperimentsResponse listExperiments(
        com.google.cloud.dialogflow.cx.v3.ListExperimentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListExperimentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment].
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.Experiment getExperiment(
        com.google.cloud.dialogflow.cx.v3.GetExperimentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetExperimentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an [Experiment][google.cloud.dialogflow.cx.v3.Experiment] in the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.Experiment createExperiment(
        com.google.cloud.dialogflow.cx.v3.CreateExperimentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateExperimentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment].
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.Experiment updateExperiment(
        com.google.cloud.dialogflow.cx.v3.UpdateExperimentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateExperimentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment].
     * </pre>
     */
    public com.google.protobuf.Empty deleteExperiment(
        com.google.cloud.dialogflow.cx.v3.DeleteExperimentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteExperimentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment]. This rpc only changes the state of
     * experiment from PENDING to RUNNING.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.Experiment startExperiment(
        com.google.cloud.dialogflow.cx.v3.StartExperimentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartExperimentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Stops the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment]. This rpc only changes the state of
     * experiment from RUNNING to DONE.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.Experiment stopExperiment(
        com.google.cloud.dialogflow.cx.v3.StopExperimentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopExperimentMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Experiments][google.cloud.dialogflow.cx.v3.Experiment].
   * </pre>
   */
  public static final class ExperimentsFutureStub
      extends io.grpc.stub.AbstractFutureStub<ExperimentsFutureStub> {
    private ExperimentsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExperimentsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExperimentsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all experiments in the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.ListExperimentsResponse>
        listExperiments(com.google.cloud.dialogflow.cx.v3.ListExperimentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListExperimentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.Experiment>
        getExperiment(com.google.cloud.dialogflow.cx.v3.GetExperimentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetExperimentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an [Experiment][google.cloud.dialogflow.cx.v3.Experiment] in the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.Experiment>
        createExperiment(com.google.cloud.dialogflow.cx.v3.CreateExperimentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateExperimentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.Experiment>
        updateExperiment(com.google.cloud.dialogflow.cx.v3.UpdateExperimentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateExperimentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteExperiment(com.google.cloud.dialogflow.cx.v3.DeleteExperimentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteExperimentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Starts the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment]. This rpc only changes the state of
     * experiment from PENDING to RUNNING.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.Experiment>
        startExperiment(com.google.cloud.dialogflow.cx.v3.StartExperimentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartExperimentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Stops the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment]. This rpc only changes the state of
     * experiment from RUNNING to DONE.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.Experiment>
        stopExperiment(com.google.cloud.dialogflow.cx.v3.StopExperimentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopExperimentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_EXPERIMENTS = 0;
  private static final int METHODID_GET_EXPERIMENT = 1;
  private static final int METHODID_CREATE_EXPERIMENT = 2;
  private static final int METHODID_UPDATE_EXPERIMENT = 3;
  private static final int METHODID_DELETE_EXPERIMENT = 4;
  private static final int METHODID_START_EXPERIMENT = 5;
  private static final int METHODID_STOP_EXPERIMENT = 6;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ExperimentsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ExperimentsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_EXPERIMENTS:
          serviceImpl.listExperiments(
              (com.google.cloud.dialogflow.cx.v3.ListExperimentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.cx.v3.ListExperimentsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_EXPERIMENT:
          serviceImpl.getExperiment(
              (com.google.cloud.dialogflow.cx.v3.GetExperimentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Experiment>)
                  responseObserver);
          break;
        case METHODID_CREATE_EXPERIMENT:
          serviceImpl.createExperiment(
              (com.google.cloud.dialogflow.cx.v3.CreateExperimentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Experiment>)
                  responseObserver);
          break;
        case METHODID_UPDATE_EXPERIMENT:
          serviceImpl.updateExperiment(
              (com.google.cloud.dialogflow.cx.v3.UpdateExperimentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Experiment>)
                  responseObserver);
          break;
        case METHODID_DELETE_EXPERIMENT:
          serviceImpl.deleteExperiment(
              (com.google.cloud.dialogflow.cx.v3.DeleteExperimentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_START_EXPERIMENT:
          serviceImpl.startExperiment(
              (com.google.cloud.dialogflow.cx.v3.StartExperimentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Experiment>)
                  responseObserver);
          break;
        case METHODID_STOP_EXPERIMENT:
          serviceImpl.stopExperiment(
              (com.google.cloud.dialogflow.cx.v3.StopExperimentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Experiment>)
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

  private abstract static class ExperimentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ExperimentsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.cx.v3.ExperimentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Experiments");
    }
  }

  private static final class ExperimentsFileDescriptorSupplier
      extends ExperimentsBaseDescriptorSupplier {
    ExperimentsFileDescriptorSupplier() {}
  }

  private static final class ExperimentsMethodDescriptorSupplier
      extends ExperimentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ExperimentsMethodDescriptorSupplier(String methodName) {
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
      synchronized (ExperimentsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ExperimentsFileDescriptorSupplier())
                      .addMethod(getListExperimentsMethod())
                      .addMethod(getGetExperimentMethod())
                      .addMethod(getCreateExperimentMethod())
                      .addMethod(getUpdateExperimentMethod())
                      .addMethod(getDeleteExperimentMethod())
                      .addMethod(getStartExperimentMethod())
                      .addMethod(getStopExperimentMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
