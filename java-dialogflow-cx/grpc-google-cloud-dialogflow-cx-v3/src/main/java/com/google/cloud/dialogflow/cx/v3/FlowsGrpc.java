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
package com.google.cloud.dialogflow.cx.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing [Flows][google.cloud.dialogflow.cx.v3.Flow].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/cx/v3/flow.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FlowsGrpc {

  private FlowsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.dialogflow.cx.v3.Flows";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.CreateFlowRequest,
          com.google.cloud.dialogflow.cx.v3.Flow>
      getCreateFlowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFlow",
      requestType = com.google.cloud.dialogflow.cx.v3.CreateFlowRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.Flow.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.CreateFlowRequest,
          com.google.cloud.dialogflow.cx.v3.Flow>
      getCreateFlowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.CreateFlowRequest,
            com.google.cloud.dialogflow.cx.v3.Flow>
        getCreateFlowMethod;
    if ((getCreateFlowMethod = FlowsGrpc.getCreateFlowMethod) == null) {
      synchronized (FlowsGrpc.class) {
        if ((getCreateFlowMethod = FlowsGrpc.getCreateFlowMethod) == null) {
          FlowsGrpc.getCreateFlowMethod =
              getCreateFlowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.CreateFlowRequest,
                          com.google.cloud.dialogflow.cx.v3.Flow>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFlow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.CreateFlowRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.Flow.getDefaultInstance()))
                      .setSchemaDescriptor(new FlowsMethodDescriptorSupplier("CreateFlow"))
                      .build();
        }
      }
    }
    return getCreateFlowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.DeleteFlowRequest, com.google.protobuf.Empty>
      getDeleteFlowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFlow",
      requestType = com.google.cloud.dialogflow.cx.v3.DeleteFlowRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.DeleteFlowRequest, com.google.protobuf.Empty>
      getDeleteFlowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.DeleteFlowRequest, com.google.protobuf.Empty>
        getDeleteFlowMethod;
    if ((getDeleteFlowMethod = FlowsGrpc.getDeleteFlowMethod) == null) {
      synchronized (FlowsGrpc.class) {
        if ((getDeleteFlowMethod = FlowsGrpc.getDeleteFlowMethod) == null) {
          FlowsGrpc.getDeleteFlowMethod =
              getDeleteFlowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.DeleteFlowRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFlow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.DeleteFlowRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new FlowsMethodDescriptorSupplier("DeleteFlow"))
                      .build();
        }
      }
    }
    return getDeleteFlowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.ListFlowsRequest,
          com.google.cloud.dialogflow.cx.v3.ListFlowsResponse>
      getListFlowsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFlows",
      requestType = com.google.cloud.dialogflow.cx.v3.ListFlowsRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.ListFlowsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.ListFlowsRequest,
          com.google.cloud.dialogflow.cx.v3.ListFlowsResponse>
      getListFlowsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.ListFlowsRequest,
            com.google.cloud.dialogflow.cx.v3.ListFlowsResponse>
        getListFlowsMethod;
    if ((getListFlowsMethod = FlowsGrpc.getListFlowsMethod) == null) {
      synchronized (FlowsGrpc.class) {
        if ((getListFlowsMethod = FlowsGrpc.getListFlowsMethod) == null) {
          FlowsGrpc.getListFlowsMethod =
              getListFlowsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.ListFlowsRequest,
                          com.google.cloud.dialogflow.cx.v3.ListFlowsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFlows"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.ListFlowsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.ListFlowsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new FlowsMethodDescriptorSupplier("ListFlows"))
                      .build();
        }
      }
    }
    return getListFlowsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.GetFlowRequest, com.google.cloud.dialogflow.cx.v3.Flow>
      getGetFlowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFlow",
      requestType = com.google.cloud.dialogflow.cx.v3.GetFlowRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.Flow.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.GetFlowRequest, com.google.cloud.dialogflow.cx.v3.Flow>
      getGetFlowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.GetFlowRequest,
            com.google.cloud.dialogflow.cx.v3.Flow>
        getGetFlowMethod;
    if ((getGetFlowMethod = FlowsGrpc.getGetFlowMethod) == null) {
      synchronized (FlowsGrpc.class) {
        if ((getGetFlowMethod = FlowsGrpc.getGetFlowMethod) == null) {
          FlowsGrpc.getGetFlowMethod =
              getGetFlowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.GetFlowRequest,
                          com.google.cloud.dialogflow.cx.v3.Flow>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFlow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.GetFlowRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.Flow.getDefaultInstance()))
                      .setSchemaDescriptor(new FlowsMethodDescriptorSupplier("GetFlow"))
                      .build();
        }
      }
    }
    return getGetFlowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.UpdateFlowRequest,
          com.google.cloud.dialogflow.cx.v3.Flow>
      getUpdateFlowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFlow",
      requestType = com.google.cloud.dialogflow.cx.v3.UpdateFlowRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.Flow.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.UpdateFlowRequest,
          com.google.cloud.dialogflow.cx.v3.Flow>
      getUpdateFlowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.UpdateFlowRequest,
            com.google.cloud.dialogflow.cx.v3.Flow>
        getUpdateFlowMethod;
    if ((getUpdateFlowMethod = FlowsGrpc.getUpdateFlowMethod) == null) {
      synchronized (FlowsGrpc.class) {
        if ((getUpdateFlowMethod = FlowsGrpc.getUpdateFlowMethod) == null) {
          FlowsGrpc.getUpdateFlowMethod =
              getUpdateFlowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.UpdateFlowRequest,
                          com.google.cloud.dialogflow.cx.v3.Flow>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFlow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.UpdateFlowRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.Flow.getDefaultInstance()))
                      .setSchemaDescriptor(new FlowsMethodDescriptorSupplier("UpdateFlow"))
                      .build();
        }
      }
    }
    return getUpdateFlowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.TrainFlowRequest, com.google.longrunning.Operation>
      getTrainFlowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TrainFlow",
      requestType = com.google.cloud.dialogflow.cx.v3.TrainFlowRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.TrainFlowRequest, com.google.longrunning.Operation>
      getTrainFlowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.TrainFlowRequest, com.google.longrunning.Operation>
        getTrainFlowMethod;
    if ((getTrainFlowMethod = FlowsGrpc.getTrainFlowMethod) == null) {
      synchronized (FlowsGrpc.class) {
        if ((getTrainFlowMethod = FlowsGrpc.getTrainFlowMethod) == null) {
          FlowsGrpc.getTrainFlowMethod =
              getTrainFlowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.TrainFlowRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TrainFlow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.TrainFlowRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new FlowsMethodDescriptorSupplier("TrainFlow"))
                      .build();
        }
      }
    }
    return getTrainFlowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.ValidateFlowRequest,
          com.google.cloud.dialogflow.cx.v3.FlowValidationResult>
      getValidateFlowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateFlow",
      requestType = com.google.cloud.dialogflow.cx.v3.ValidateFlowRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.FlowValidationResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.ValidateFlowRequest,
          com.google.cloud.dialogflow.cx.v3.FlowValidationResult>
      getValidateFlowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.ValidateFlowRequest,
            com.google.cloud.dialogflow.cx.v3.FlowValidationResult>
        getValidateFlowMethod;
    if ((getValidateFlowMethod = FlowsGrpc.getValidateFlowMethod) == null) {
      synchronized (FlowsGrpc.class) {
        if ((getValidateFlowMethod = FlowsGrpc.getValidateFlowMethod) == null) {
          FlowsGrpc.getValidateFlowMethod =
              getValidateFlowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.ValidateFlowRequest,
                          com.google.cloud.dialogflow.cx.v3.FlowValidationResult>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateFlow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.ValidateFlowRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.FlowValidationResult
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new FlowsMethodDescriptorSupplier("ValidateFlow"))
                      .build();
        }
      }
    }
    return getValidateFlowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.GetFlowValidationResultRequest,
          com.google.cloud.dialogflow.cx.v3.FlowValidationResult>
      getGetFlowValidationResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFlowValidationResult",
      requestType = com.google.cloud.dialogflow.cx.v3.GetFlowValidationResultRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.FlowValidationResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.GetFlowValidationResultRequest,
          com.google.cloud.dialogflow.cx.v3.FlowValidationResult>
      getGetFlowValidationResultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.GetFlowValidationResultRequest,
            com.google.cloud.dialogflow.cx.v3.FlowValidationResult>
        getGetFlowValidationResultMethod;
    if ((getGetFlowValidationResultMethod = FlowsGrpc.getGetFlowValidationResultMethod) == null) {
      synchronized (FlowsGrpc.class) {
        if ((getGetFlowValidationResultMethod = FlowsGrpc.getGetFlowValidationResultMethod)
            == null) {
          FlowsGrpc.getGetFlowValidationResultMethod =
              getGetFlowValidationResultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.GetFlowValidationResultRequest,
                          com.google.cloud.dialogflow.cx.v3.FlowValidationResult>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetFlowValidationResult"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.GetFlowValidationResultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.FlowValidationResult
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FlowsMethodDescriptorSupplier("GetFlowValidationResult"))
                      .build();
        }
      }
    }
    return getGetFlowValidationResultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.ImportFlowRequest, com.google.longrunning.Operation>
      getImportFlowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportFlow",
      requestType = com.google.cloud.dialogflow.cx.v3.ImportFlowRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.ImportFlowRequest, com.google.longrunning.Operation>
      getImportFlowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.ImportFlowRequest, com.google.longrunning.Operation>
        getImportFlowMethod;
    if ((getImportFlowMethod = FlowsGrpc.getImportFlowMethod) == null) {
      synchronized (FlowsGrpc.class) {
        if ((getImportFlowMethod = FlowsGrpc.getImportFlowMethod) == null) {
          FlowsGrpc.getImportFlowMethod =
              getImportFlowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.ImportFlowRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportFlow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.ImportFlowRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new FlowsMethodDescriptorSupplier("ImportFlow"))
                      .build();
        }
      }
    }
    return getImportFlowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.ExportFlowRequest, com.google.longrunning.Operation>
      getExportFlowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportFlow",
      requestType = com.google.cloud.dialogflow.cx.v3.ExportFlowRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.ExportFlowRequest, com.google.longrunning.Operation>
      getExportFlowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.ExportFlowRequest, com.google.longrunning.Operation>
        getExportFlowMethod;
    if ((getExportFlowMethod = FlowsGrpc.getExportFlowMethod) == null) {
      synchronized (FlowsGrpc.class) {
        if ((getExportFlowMethod = FlowsGrpc.getExportFlowMethod) == null) {
          FlowsGrpc.getExportFlowMethod =
              getExportFlowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.ExportFlowRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportFlow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.ExportFlowRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new FlowsMethodDescriptorSupplier("ExportFlow"))
                      .build();
        }
      }
    }
    return getExportFlowMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static FlowsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FlowsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FlowsStub>() {
          @java.lang.Override
          public FlowsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FlowsStub(channel, callOptions);
          }
        };
    return FlowsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FlowsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FlowsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FlowsBlockingStub>() {
          @java.lang.Override
          public FlowsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FlowsBlockingStub(channel, callOptions);
          }
        };
    return FlowsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static FlowsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FlowsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FlowsFutureStub>() {
          @java.lang.Override
          public FlowsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FlowsFutureStub(channel, callOptions);
          }
        };
    return FlowsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Flows][google.cloud.dialogflow.cx.v3.Flow].
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a flow in the specified agent.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    default void createFlow(
        com.google.cloud.dialogflow.cx.v3.CreateFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Flow> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateFlowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specified flow.
     * </pre>
     */
    default void deleteFlow(
        com.google.cloud.dialogflow.cx.v3.DeleteFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteFlowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all flows in the specified agent.
     * </pre>
     */
    default void listFlows(
        com.google.cloud.dialogflow.cx.v3.ListFlowsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListFlowsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListFlowsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified flow.
     * </pre>
     */
    default void getFlow(
        com.google.cloud.dialogflow.cx.v3.GetFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Flow> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFlowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified flow.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    default void updateFlow(
        com.google.cloud.dialogflow.cx.v3.UpdateFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Flow> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateFlowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Trains the specified flow. Note that only the flow in 'draft' environment
     * is trained.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    default void trainFlow(
        com.google.cloud.dialogflow.cx.v3.TrainFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTrainFlowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Validates the specified flow and creates or updates validation results.
     * Please call this API after the training is completed to get the complete
     * validation results.
     * </pre>
     */
    default void validateFlow(
        com.google.cloud.dialogflow.cx.v3.ValidateFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.FlowValidationResult>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getValidateFlowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the latest flow validation result. Flow validation is performed
     * when ValidateFlow is called.
     * </pre>
     */
    default void getFlowValidationResult(
        com.google.cloud.dialogflow.cx.v3.GetFlowValidationResultRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.FlowValidationResult>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetFlowValidationResultMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports the specified flow to the specified agent from a binary file.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`:
     * [ImportFlowResponse][google.cloud.dialogflow.cx.v3.ImportFlowResponse]
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    default void importFlow(
        com.google.cloud.dialogflow.cx.v3.ImportFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getImportFlowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports the specified flow to a binary file.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`:
     * [ExportFlowResponse][google.cloud.dialogflow.cx.v3.ExportFlowResponse]
     * Note that resources (e.g. intents, entities, webhooks) that the flow
     * references will also be exported.
     * </pre>
     */
    default void exportFlow(
        com.google.cloud.dialogflow.cx.v3.ExportFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExportFlowMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Flows.
   *
   * <pre>
   * Service for managing [Flows][google.cloud.dialogflow.cx.v3.Flow].
   * </pre>
   */
  public abstract static class FlowsImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return FlowsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Flows.
   *
   * <pre>
   * Service for managing [Flows][google.cloud.dialogflow.cx.v3.Flow].
   * </pre>
   */
  public static final class FlowsStub extends io.grpc.stub.AbstractAsyncStub<FlowsStub> {
    private FlowsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FlowsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FlowsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a flow in the specified agent.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void createFlow(
        com.google.cloud.dialogflow.cx.v3.CreateFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Flow> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFlowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specified flow.
     * </pre>
     */
    public void deleteFlow(
        com.google.cloud.dialogflow.cx.v3.DeleteFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFlowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all flows in the specified agent.
     * </pre>
     */
    public void listFlows(
        com.google.cloud.dialogflow.cx.v3.ListFlowsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListFlowsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFlowsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified flow.
     * </pre>
     */
    public void getFlow(
        com.google.cloud.dialogflow.cx.v3.GetFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Flow> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFlowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified flow.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void updateFlow(
        com.google.cloud.dialogflow.cx.v3.UpdateFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Flow> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFlowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Trains the specified flow. Note that only the flow in 'draft' environment
     * is trained.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void trainFlow(
        com.google.cloud.dialogflow.cx.v3.TrainFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTrainFlowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Validates the specified flow and creates or updates validation results.
     * Please call this API after the training is completed to get the complete
     * validation results.
     * </pre>
     */
    public void validateFlow(
        com.google.cloud.dialogflow.cx.v3.ValidateFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.FlowValidationResult>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateFlowMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the latest flow validation result. Flow validation is performed
     * when ValidateFlow is called.
     * </pre>
     */
    public void getFlowValidationResult(
        com.google.cloud.dialogflow.cx.v3.GetFlowValidationResultRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.FlowValidationResult>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFlowValidationResultMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports the specified flow to the specified agent from a binary file.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`:
     * [ImportFlowResponse][google.cloud.dialogflow.cx.v3.ImportFlowResponse]
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void importFlow(
        com.google.cloud.dialogflow.cx.v3.ImportFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportFlowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports the specified flow to a binary file.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`:
     * [ExportFlowResponse][google.cloud.dialogflow.cx.v3.ExportFlowResponse]
     * Note that resources (e.g. intents, entities, webhooks) that the flow
     * references will also be exported.
     * </pre>
     */
    public void exportFlow(
        com.google.cloud.dialogflow.cx.v3.ExportFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportFlowMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Flows.
   *
   * <pre>
   * Service for managing [Flows][google.cloud.dialogflow.cx.v3.Flow].
   * </pre>
   */
  public static final class FlowsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FlowsBlockingStub> {
    private FlowsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FlowsBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FlowsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a flow in the specified agent.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.Flow createFlow(
        com.google.cloud.dialogflow.cx.v3.CreateFlowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFlowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specified flow.
     * </pre>
     */
    public com.google.protobuf.Empty deleteFlow(
        com.google.cloud.dialogflow.cx.v3.DeleteFlowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFlowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all flows in the specified agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.ListFlowsResponse listFlows(
        com.google.cloud.dialogflow.cx.v3.ListFlowsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFlowsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified flow.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.Flow getFlow(
        com.google.cloud.dialogflow.cx.v3.GetFlowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFlowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified flow.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.Flow updateFlow(
        com.google.cloud.dialogflow.cx.v3.UpdateFlowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFlowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Trains the specified flow. Note that only the flow in 'draft' environment
     * is trained.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.longrunning.Operation trainFlow(
        com.google.cloud.dialogflow.cx.v3.TrainFlowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTrainFlowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Validates the specified flow and creates or updates validation results.
     * Please call this API after the training is completed to get the complete
     * validation results.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.FlowValidationResult validateFlow(
        com.google.cloud.dialogflow.cx.v3.ValidateFlowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateFlowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the latest flow validation result. Flow validation is performed
     * when ValidateFlow is called.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.FlowValidationResult getFlowValidationResult(
        com.google.cloud.dialogflow.cx.v3.GetFlowValidationResultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFlowValidationResultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports the specified flow to the specified agent from a binary file.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`:
     * [ImportFlowResponse][google.cloud.dialogflow.cx.v3.ImportFlowResponse]
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.longrunning.Operation importFlow(
        com.google.cloud.dialogflow.cx.v3.ImportFlowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportFlowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports the specified flow to a binary file.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`:
     * [ExportFlowResponse][google.cloud.dialogflow.cx.v3.ExportFlowResponse]
     * Note that resources (e.g. intents, entities, webhooks) that the flow
     * references will also be exported.
     * </pre>
     */
    public com.google.longrunning.Operation exportFlow(
        com.google.cloud.dialogflow.cx.v3.ExportFlowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportFlowMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Flows.
   *
   * <pre>
   * Service for managing [Flows][google.cloud.dialogflow.cx.v3.Flow].
   * </pre>
   */
  public static final class FlowsFutureStub
      extends io.grpc.stub.AbstractFutureStub<FlowsFutureStub> {
    private FlowsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FlowsFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FlowsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a flow in the specified agent.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.Flow>
        createFlow(com.google.cloud.dialogflow.cx.v3.CreateFlowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFlowMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specified flow.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteFlow(
        com.google.cloud.dialogflow.cx.v3.DeleteFlowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFlowMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all flows in the specified agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.ListFlowsResponse>
        listFlows(com.google.cloud.dialogflow.cx.v3.ListFlowsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFlowsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified flow.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.Flow>
        getFlow(com.google.cloud.dialogflow.cx.v3.GetFlowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFlowMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified flow.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.Flow>
        updateFlow(com.google.cloud.dialogflow.cx.v3.UpdateFlowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFlowMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Trains the specified flow. Note that only the flow in 'draft' environment
     * is trained.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        trainFlow(com.google.cloud.dialogflow.cx.v3.TrainFlowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTrainFlowMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Validates the specified flow and creates or updates validation results.
     * Please call this API after the training is completed to get the complete
     * validation results.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.FlowValidationResult>
        validateFlow(com.google.cloud.dialogflow.cx.v3.ValidateFlowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateFlowMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the latest flow validation result. Flow validation is performed
     * when ValidateFlow is called.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.FlowValidationResult>
        getFlowValidationResult(
            com.google.cloud.dialogflow.cx.v3.GetFlowValidationResultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFlowValidationResultMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports the specified flow to the specified agent from a binary file.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`:
     * [ImportFlowResponse][google.cloud.dialogflow.cx.v3.ImportFlowResponse]
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importFlow(com.google.cloud.dialogflow.cx.v3.ImportFlowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportFlowMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports the specified flow to a binary file.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`:
     * [ExportFlowResponse][google.cloud.dialogflow.cx.v3.ExportFlowResponse]
     * Note that resources (e.g. intents, entities, webhooks) that the flow
     * references will also be exported.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportFlow(com.google.cloud.dialogflow.cx.v3.ExportFlowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportFlowMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_FLOW = 0;
  private static final int METHODID_DELETE_FLOW = 1;
  private static final int METHODID_LIST_FLOWS = 2;
  private static final int METHODID_GET_FLOW = 3;
  private static final int METHODID_UPDATE_FLOW = 4;
  private static final int METHODID_TRAIN_FLOW = 5;
  private static final int METHODID_VALIDATE_FLOW = 6;
  private static final int METHODID_GET_FLOW_VALIDATION_RESULT = 7;
  private static final int METHODID_IMPORT_FLOW = 8;
  private static final int METHODID_EXPORT_FLOW = 9;

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
        case METHODID_CREATE_FLOW:
          serviceImpl.createFlow(
              (com.google.cloud.dialogflow.cx.v3.CreateFlowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Flow>)
                  responseObserver);
          break;
        case METHODID_DELETE_FLOW:
          serviceImpl.deleteFlow(
              (com.google.cloud.dialogflow.cx.v3.DeleteFlowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_FLOWS:
          serviceImpl.listFlows(
              (com.google.cloud.dialogflow.cx.v3.ListFlowsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListFlowsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_FLOW:
          serviceImpl.getFlow(
              (com.google.cloud.dialogflow.cx.v3.GetFlowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Flow>)
                  responseObserver);
          break;
        case METHODID_UPDATE_FLOW:
          serviceImpl.updateFlow(
              (com.google.cloud.dialogflow.cx.v3.UpdateFlowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Flow>)
                  responseObserver);
          break;
        case METHODID_TRAIN_FLOW:
          serviceImpl.trainFlow(
              (com.google.cloud.dialogflow.cx.v3.TrainFlowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_VALIDATE_FLOW:
          serviceImpl.validateFlow(
              (com.google.cloud.dialogflow.cx.v3.ValidateFlowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.FlowValidationResult>)
                  responseObserver);
          break;
        case METHODID_GET_FLOW_VALIDATION_RESULT:
          serviceImpl.getFlowValidationResult(
              (com.google.cloud.dialogflow.cx.v3.GetFlowValidationResultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.FlowValidationResult>)
                  responseObserver);
          break;
        case METHODID_IMPORT_FLOW:
          serviceImpl.importFlow(
              (com.google.cloud.dialogflow.cx.v3.ImportFlowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_FLOW:
          serviceImpl.exportFlow(
              (com.google.cloud.dialogflow.cx.v3.ExportFlowRequest) request,
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
            getCreateFlowMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3.CreateFlowRequest,
                    com.google.cloud.dialogflow.cx.v3.Flow>(service, METHODID_CREATE_FLOW)))
        .addMethod(
            getDeleteFlowMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3.DeleteFlowRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_FLOW)))
        .addMethod(
            getListFlowsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3.ListFlowsRequest,
                    com.google.cloud.dialogflow.cx.v3.ListFlowsResponse>(
                    service, METHODID_LIST_FLOWS)))
        .addMethod(
            getGetFlowMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3.GetFlowRequest,
                    com.google.cloud.dialogflow.cx.v3.Flow>(service, METHODID_GET_FLOW)))
        .addMethod(
            getUpdateFlowMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3.UpdateFlowRequest,
                    com.google.cloud.dialogflow.cx.v3.Flow>(service, METHODID_UPDATE_FLOW)))
        .addMethod(
            getTrainFlowMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3.TrainFlowRequest,
                    com.google.longrunning.Operation>(service, METHODID_TRAIN_FLOW)))
        .addMethod(
            getValidateFlowMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3.ValidateFlowRequest,
                    com.google.cloud.dialogflow.cx.v3.FlowValidationResult>(
                    service, METHODID_VALIDATE_FLOW)))
        .addMethod(
            getGetFlowValidationResultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3.GetFlowValidationResultRequest,
                    com.google.cloud.dialogflow.cx.v3.FlowValidationResult>(
                    service, METHODID_GET_FLOW_VALIDATION_RESULT)))
        .addMethod(
            getImportFlowMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3.ImportFlowRequest,
                    com.google.longrunning.Operation>(service, METHODID_IMPORT_FLOW)))
        .addMethod(
            getExportFlowMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3.ExportFlowRequest,
                    com.google.longrunning.Operation>(service, METHODID_EXPORT_FLOW)))
        .build();
  }

  private abstract static class FlowsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FlowsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.cx.v3.FlowProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Flows");
    }
  }

  private static final class FlowsFileDescriptorSupplier extends FlowsBaseDescriptorSupplier {
    FlowsFileDescriptorSupplier() {}
  }

  private static final class FlowsMethodDescriptorSupplier extends FlowsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FlowsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (FlowsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new FlowsFileDescriptorSupplier())
                      .addMethod(getCreateFlowMethod())
                      .addMethod(getDeleteFlowMethod())
                      .addMethod(getListFlowsMethod())
                      .addMethod(getGetFlowMethod())
                      .addMethod(getUpdateFlowMethod())
                      .addMethod(getTrainFlowMethod())
                      .addMethod(getValidateFlowMethod())
                      .addMethod(getGetFlowValidationResultMethod())
                      .addMethod(getImportFlowMethod())
                      .addMethod(getExportFlowMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
