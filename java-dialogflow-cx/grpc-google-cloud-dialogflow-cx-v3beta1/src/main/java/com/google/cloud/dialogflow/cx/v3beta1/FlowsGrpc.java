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
package com.google.cloud.dialogflow.cx.v3beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * Service for managing [Flows][google.cloud.dialogflow.cx.v3beta1.Flow].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/cx/v3beta1/flow.proto")
public final class FlowsGrpc {

  private FlowsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.cx.v3beta1.Flows";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.CreateFlowRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Flow>
      getCreateFlowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFlow",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.CreateFlowRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.Flow.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.CreateFlowRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Flow>
      getCreateFlowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.CreateFlowRequest,
            com.google.cloud.dialogflow.cx.v3beta1.Flow>
        getCreateFlowMethod;
    if ((getCreateFlowMethod = FlowsGrpc.getCreateFlowMethod) == null) {
      synchronized (FlowsGrpc.class) {
        if ((getCreateFlowMethod = FlowsGrpc.getCreateFlowMethod) == null) {
          FlowsGrpc.getCreateFlowMethod =
              getCreateFlowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.CreateFlowRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.Flow>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFlow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.CreateFlowRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.Flow.getDefaultInstance()))
                      .setSchemaDescriptor(new FlowsMethodDescriptorSupplier("CreateFlow"))
                      .build();
        }
      }
    }
    return getCreateFlowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.DeleteFlowRequest, com.google.protobuf.Empty>
      getDeleteFlowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFlow",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.DeleteFlowRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.DeleteFlowRequest, com.google.protobuf.Empty>
      getDeleteFlowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.DeleteFlowRequest, com.google.protobuf.Empty>
        getDeleteFlowMethod;
    if ((getDeleteFlowMethod = FlowsGrpc.getDeleteFlowMethod) == null) {
      synchronized (FlowsGrpc.class) {
        if ((getDeleteFlowMethod = FlowsGrpc.getDeleteFlowMethod) == null) {
          FlowsGrpc.getDeleteFlowMethod =
              getDeleteFlowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.DeleteFlowRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFlow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.DeleteFlowRequest
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
          com.google.cloud.dialogflow.cx.v3beta1.ListFlowsRequest,
          com.google.cloud.dialogflow.cx.v3beta1.ListFlowsResponse>
      getListFlowsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFlows",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.ListFlowsRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.ListFlowsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ListFlowsRequest,
          com.google.cloud.dialogflow.cx.v3beta1.ListFlowsResponse>
      getListFlowsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.ListFlowsRequest,
            com.google.cloud.dialogflow.cx.v3beta1.ListFlowsResponse>
        getListFlowsMethod;
    if ((getListFlowsMethod = FlowsGrpc.getListFlowsMethod) == null) {
      synchronized (FlowsGrpc.class) {
        if ((getListFlowsMethod = FlowsGrpc.getListFlowsMethod) == null) {
          FlowsGrpc.getListFlowsMethod =
              getListFlowsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.ListFlowsRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.ListFlowsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFlows"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ListFlowsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ListFlowsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new FlowsMethodDescriptorSupplier("ListFlows"))
                      .build();
        }
      }
    }
    return getListFlowsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.GetFlowRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Flow>
      getGetFlowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFlow",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.GetFlowRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.Flow.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.GetFlowRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Flow>
      getGetFlowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.GetFlowRequest,
            com.google.cloud.dialogflow.cx.v3beta1.Flow>
        getGetFlowMethod;
    if ((getGetFlowMethod = FlowsGrpc.getGetFlowMethod) == null) {
      synchronized (FlowsGrpc.class) {
        if ((getGetFlowMethod = FlowsGrpc.getGetFlowMethod) == null) {
          FlowsGrpc.getGetFlowMethod =
              getGetFlowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.GetFlowRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.Flow>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFlow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.GetFlowRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.Flow.getDefaultInstance()))
                      .setSchemaDescriptor(new FlowsMethodDescriptorSupplier("GetFlow"))
                      .build();
        }
      }
    }
    return getGetFlowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.UpdateFlowRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Flow>
      getUpdateFlowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFlow",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.UpdateFlowRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.Flow.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.UpdateFlowRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Flow>
      getUpdateFlowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.UpdateFlowRequest,
            com.google.cloud.dialogflow.cx.v3beta1.Flow>
        getUpdateFlowMethod;
    if ((getUpdateFlowMethod = FlowsGrpc.getUpdateFlowMethod) == null) {
      synchronized (FlowsGrpc.class) {
        if ((getUpdateFlowMethod = FlowsGrpc.getUpdateFlowMethod) == null) {
          FlowsGrpc.getUpdateFlowMethod =
              getUpdateFlowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.UpdateFlowRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.Flow>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFlow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.UpdateFlowRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.Flow.getDefaultInstance()))
                      .setSchemaDescriptor(new FlowsMethodDescriptorSupplier("UpdateFlow"))
                      .build();
        }
      }
    }
    return getUpdateFlowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.TrainFlowRequest, com.google.longrunning.Operation>
      getTrainFlowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TrainFlow",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.TrainFlowRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.TrainFlowRequest, com.google.longrunning.Operation>
      getTrainFlowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.TrainFlowRequest,
            com.google.longrunning.Operation>
        getTrainFlowMethod;
    if ((getTrainFlowMethod = FlowsGrpc.getTrainFlowMethod) == null) {
      synchronized (FlowsGrpc.class) {
        if ((getTrainFlowMethod = FlowsGrpc.getTrainFlowMethod) == null) {
          FlowsGrpc.getTrainFlowMethod =
              getTrainFlowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.TrainFlowRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TrainFlow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.TrainFlowRequest
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
          com.google.cloud.dialogflow.cx.v3beta1.ValidateFlowRequest,
          com.google.cloud.dialogflow.cx.v3beta1.FlowValidationResult>
      getValidateFlowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateFlow",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.ValidateFlowRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.FlowValidationResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ValidateFlowRequest,
          com.google.cloud.dialogflow.cx.v3beta1.FlowValidationResult>
      getValidateFlowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.ValidateFlowRequest,
            com.google.cloud.dialogflow.cx.v3beta1.FlowValidationResult>
        getValidateFlowMethod;
    if ((getValidateFlowMethod = FlowsGrpc.getValidateFlowMethod) == null) {
      synchronized (FlowsGrpc.class) {
        if ((getValidateFlowMethod = FlowsGrpc.getValidateFlowMethod) == null) {
          FlowsGrpc.getValidateFlowMethod =
              getValidateFlowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.ValidateFlowRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.FlowValidationResult>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateFlow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ValidateFlowRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.FlowValidationResult
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new FlowsMethodDescriptorSupplier("ValidateFlow"))
                      .build();
        }
      }
    }
    return getValidateFlowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.GetFlowValidationResultRequest,
          com.google.cloud.dialogflow.cx.v3beta1.FlowValidationResult>
      getGetFlowValidationResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFlowValidationResult",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.GetFlowValidationResultRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.FlowValidationResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.GetFlowValidationResultRequest,
          com.google.cloud.dialogflow.cx.v3beta1.FlowValidationResult>
      getGetFlowValidationResultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.GetFlowValidationResultRequest,
            com.google.cloud.dialogflow.cx.v3beta1.FlowValidationResult>
        getGetFlowValidationResultMethod;
    if ((getGetFlowValidationResultMethod = FlowsGrpc.getGetFlowValidationResultMethod) == null) {
      synchronized (FlowsGrpc.class) {
        if ((getGetFlowValidationResultMethod = FlowsGrpc.getGetFlowValidationResultMethod)
            == null) {
          FlowsGrpc.getGetFlowValidationResultMethod =
              getGetFlowValidationResultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.GetFlowValidationResultRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.FlowValidationResult>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetFlowValidationResult"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.GetFlowValidationResultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.FlowValidationResult
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FlowsMethodDescriptorSupplier("GetFlowValidationResult"))
                      .build();
        }
      }
    }
    return getGetFlowValidationResultMethod;
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
   * Service for managing [Flows][google.cloud.dialogflow.cx.v3beta1.Flow].
   * </pre>
   */
  public abstract static class FlowsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a flow in the specified agent.
     * </pre>
     */
    public void createFlow(
        com.google.cloud.dialogflow.cx.v3beta1.CreateFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Flow> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateFlowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specified flow.
     * </pre>
     */
    public void deleteFlow(
        com.google.cloud.dialogflow.cx.v3beta1.DeleteFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteFlowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all flows in the specified agent.
     * </pre>
     */
    public void listFlows(
        com.google.cloud.dialogflow.cx.v3beta1.ListFlowsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.ListFlowsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListFlowsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified flow.
     * </pre>
     */
    public void getFlow(
        com.google.cloud.dialogflow.cx.v3beta1.GetFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Flow> responseObserver) {
      asyncUnimplementedUnaryCall(getGetFlowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified flow.
     * </pre>
     */
    public void updateFlow(
        com.google.cloud.dialogflow.cx.v3beta1.UpdateFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Flow> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateFlowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Trains the specified flow. Note that only the flow in 'draft' environment
     * is trained.
     * </pre>
     */
    public void trainFlow(
        com.google.cloud.dialogflow.cx.v3beta1.TrainFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getTrainFlowMethod(), responseObserver);
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
        com.google.cloud.dialogflow.cx.v3beta1.ValidateFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.FlowValidationResult>
            responseObserver) {
      asyncUnimplementedUnaryCall(getValidateFlowMethod(), responseObserver);
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
        com.google.cloud.dialogflow.cx.v3beta1.GetFlowValidationResultRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.FlowValidationResult>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetFlowValidationResultMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateFlowMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.CreateFlowRequest,
                      com.google.cloud.dialogflow.cx.v3beta1.Flow>(this, METHODID_CREATE_FLOW)))
          .addMethod(
              getDeleteFlowMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.DeleteFlowRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_FLOW)))
          .addMethod(
              getListFlowsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.ListFlowsRequest,
                      com.google.cloud.dialogflow.cx.v3beta1.ListFlowsResponse>(
                      this, METHODID_LIST_FLOWS)))
          .addMethod(
              getGetFlowMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.GetFlowRequest,
                      com.google.cloud.dialogflow.cx.v3beta1.Flow>(this, METHODID_GET_FLOW)))
          .addMethod(
              getUpdateFlowMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.UpdateFlowRequest,
                      com.google.cloud.dialogflow.cx.v3beta1.Flow>(this, METHODID_UPDATE_FLOW)))
          .addMethod(
              getTrainFlowMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.TrainFlowRequest,
                      com.google.longrunning.Operation>(this, METHODID_TRAIN_FLOW)))
          .addMethod(
              getValidateFlowMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.ValidateFlowRequest,
                      com.google.cloud.dialogflow.cx.v3beta1.FlowValidationResult>(
                      this, METHODID_VALIDATE_FLOW)))
          .addMethod(
              getGetFlowValidationResultMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.GetFlowValidationResultRequest,
                      com.google.cloud.dialogflow.cx.v3beta1.FlowValidationResult>(
                      this, METHODID_GET_FLOW_VALIDATION_RESULT)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Flows][google.cloud.dialogflow.cx.v3beta1.Flow].
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
     * </pre>
     */
    public void createFlow(
        com.google.cloud.dialogflow.cx.v3beta1.CreateFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Flow> responseObserver) {
      asyncUnaryCall(
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
        com.google.cloud.dialogflow.cx.v3beta1.DeleteFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
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
        com.google.cloud.dialogflow.cx.v3beta1.ListFlowsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.ListFlowsResponse>
            responseObserver) {
      asyncUnaryCall(
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
        com.google.cloud.dialogflow.cx.v3beta1.GetFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Flow> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetFlowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified flow.
     * </pre>
     */
    public void updateFlow(
        com.google.cloud.dialogflow.cx.v3beta1.UpdateFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Flow> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateFlowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Trains the specified flow. Note that only the flow in 'draft' environment
     * is trained.
     * </pre>
     */
    public void trainFlow(
        com.google.cloud.dialogflow.cx.v3beta1.TrainFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
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
        com.google.cloud.dialogflow.cx.v3beta1.ValidateFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.FlowValidationResult>
            responseObserver) {
      asyncUnaryCall(
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
        com.google.cloud.dialogflow.cx.v3beta1.GetFlowValidationResultRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.FlowValidationResult>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetFlowValidationResultMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Flows][google.cloud.dialogflow.cx.v3beta1.Flow].
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
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.Flow createFlow(
        com.google.cloud.dialogflow.cx.v3beta1.CreateFlowRequest request) {
      return blockingUnaryCall(getChannel(), getCreateFlowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specified flow.
     * </pre>
     */
    public com.google.protobuf.Empty deleteFlow(
        com.google.cloud.dialogflow.cx.v3beta1.DeleteFlowRequest request) {
      return blockingUnaryCall(getChannel(), getDeleteFlowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all flows in the specified agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.ListFlowsResponse listFlows(
        com.google.cloud.dialogflow.cx.v3beta1.ListFlowsRequest request) {
      return blockingUnaryCall(getChannel(), getListFlowsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified flow.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.Flow getFlow(
        com.google.cloud.dialogflow.cx.v3beta1.GetFlowRequest request) {
      return blockingUnaryCall(getChannel(), getGetFlowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified flow.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.Flow updateFlow(
        com.google.cloud.dialogflow.cx.v3beta1.UpdateFlowRequest request) {
      return blockingUnaryCall(getChannel(), getUpdateFlowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Trains the specified flow. Note that only the flow in 'draft' environment
     * is trained.
     * </pre>
     */
    public com.google.longrunning.Operation trainFlow(
        com.google.cloud.dialogflow.cx.v3beta1.TrainFlowRequest request) {
      return blockingUnaryCall(getChannel(), getTrainFlowMethod(), getCallOptions(), request);
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
    public com.google.cloud.dialogflow.cx.v3beta1.FlowValidationResult validateFlow(
        com.google.cloud.dialogflow.cx.v3beta1.ValidateFlowRequest request) {
      return blockingUnaryCall(getChannel(), getValidateFlowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the latest flow validation result. Flow validation is performed
     * when ValidateFlow is called.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.FlowValidationResult getFlowValidationResult(
        com.google.cloud.dialogflow.cx.v3beta1.GetFlowValidationResultRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetFlowValidationResultMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Flows][google.cloud.dialogflow.cx.v3beta1.Flow].
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
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.Flow>
        createFlow(com.google.cloud.dialogflow.cx.v3beta1.CreateFlowRequest request) {
      return futureUnaryCall(
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
        com.google.cloud.dialogflow.cx.v3beta1.DeleteFlowRequest request) {
      return futureUnaryCall(
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
            com.google.cloud.dialogflow.cx.v3beta1.ListFlowsResponse>
        listFlows(com.google.cloud.dialogflow.cx.v3beta1.ListFlowsRequest request) {
      return futureUnaryCall(getChannel().newCall(getListFlowsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified flow.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.Flow>
        getFlow(com.google.cloud.dialogflow.cx.v3beta1.GetFlowRequest request) {
      return futureUnaryCall(getChannel().newCall(getGetFlowMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified flow.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.Flow>
        updateFlow(com.google.cloud.dialogflow.cx.v3beta1.UpdateFlowRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateFlowMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Trains the specified flow. Note that only the flow in 'draft' environment
     * is trained.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        trainFlow(com.google.cloud.dialogflow.cx.v3beta1.TrainFlowRequest request) {
      return futureUnaryCall(getChannel().newCall(getTrainFlowMethod(), getCallOptions()), request);
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
            com.google.cloud.dialogflow.cx.v3beta1.FlowValidationResult>
        validateFlow(com.google.cloud.dialogflow.cx.v3beta1.ValidateFlowRequest request) {
      return futureUnaryCall(
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
            com.google.cloud.dialogflow.cx.v3beta1.FlowValidationResult>
        getFlowValidationResult(
            com.google.cloud.dialogflow.cx.v3beta1.GetFlowValidationResultRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetFlowValidationResultMethod(), getCallOptions()), request);
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

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FlowsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FlowsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_FLOW:
          serviceImpl.createFlow(
              (com.google.cloud.dialogflow.cx.v3beta1.CreateFlowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Flow>)
                  responseObserver);
          break;
        case METHODID_DELETE_FLOW:
          serviceImpl.deleteFlow(
              (com.google.cloud.dialogflow.cx.v3beta1.DeleteFlowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_FLOWS:
          serviceImpl.listFlows(
              (com.google.cloud.dialogflow.cx.v3beta1.ListFlowsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.cx.v3beta1.ListFlowsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_FLOW:
          serviceImpl.getFlow(
              (com.google.cloud.dialogflow.cx.v3beta1.GetFlowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Flow>)
                  responseObserver);
          break;
        case METHODID_UPDATE_FLOW:
          serviceImpl.updateFlow(
              (com.google.cloud.dialogflow.cx.v3beta1.UpdateFlowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Flow>)
                  responseObserver);
          break;
        case METHODID_TRAIN_FLOW:
          serviceImpl.trainFlow(
              (com.google.cloud.dialogflow.cx.v3beta1.TrainFlowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_VALIDATE_FLOW:
          serviceImpl.validateFlow(
              (com.google.cloud.dialogflow.cx.v3beta1.ValidateFlowRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.cx.v3beta1.FlowValidationResult>)
                  responseObserver);
          break;
        case METHODID_GET_FLOW_VALIDATION_RESULT:
          serviceImpl.getFlowValidationResult(
              (com.google.cloud.dialogflow.cx.v3beta1.GetFlowValidationResultRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.cx.v3beta1.FlowValidationResult>)
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

  private abstract static class FlowsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FlowsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.cx.v3beta1.FlowProto.getDescriptor();
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
    private final String methodName;

    FlowsMethodDescriptorSupplier(String methodName) {
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
                      .build();
        }
      }
    }
    return result;
  }
}
