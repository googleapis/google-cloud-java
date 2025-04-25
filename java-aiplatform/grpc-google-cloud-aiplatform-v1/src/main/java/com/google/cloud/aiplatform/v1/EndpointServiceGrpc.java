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
package com.google.cloud.aiplatform.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service for managing Vertex AI's Endpoints.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1/endpoint_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EndpointServiceGrpc {

  private EndpointServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.aiplatform.v1.EndpointService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CreateEndpointRequest, com.google.longrunning.Operation>
      getCreateEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEndpoint",
      requestType = com.google.cloud.aiplatform.v1.CreateEndpointRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CreateEndpointRequest, com.google.longrunning.Operation>
      getCreateEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.CreateEndpointRequest, com.google.longrunning.Operation>
        getCreateEndpointMethod;
    if ((getCreateEndpointMethod = EndpointServiceGrpc.getCreateEndpointMethod) == null) {
      synchronized (EndpointServiceGrpc.class) {
        if ((getCreateEndpointMethod = EndpointServiceGrpc.getCreateEndpointMethod) == null) {
          EndpointServiceGrpc.getCreateEndpointMethod =
              getCreateEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.CreateEndpointRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.CreateEndpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EndpointServiceMethodDescriptorSupplier("CreateEndpoint"))
                      .build();
        }
      }
    }
    return getCreateEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetEndpointRequest,
          com.google.cloud.aiplatform.v1.Endpoint>
      getGetEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEndpoint",
      requestType = com.google.cloud.aiplatform.v1.GetEndpointRequest.class,
      responseType = com.google.cloud.aiplatform.v1.Endpoint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetEndpointRequest,
          com.google.cloud.aiplatform.v1.Endpoint>
      getGetEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.GetEndpointRequest,
            com.google.cloud.aiplatform.v1.Endpoint>
        getGetEndpointMethod;
    if ((getGetEndpointMethod = EndpointServiceGrpc.getGetEndpointMethod) == null) {
      synchronized (EndpointServiceGrpc.class) {
        if ((getGetEndpointMethod = EndpointServiceGrpc.getGetEndpointMethod) == null) {
          EndpointServiceGrpc.getGetEndpointMethod =
              getGetEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.GetEndpointRequest,
                          com.google.cloud.aiplatform.v1.Endpoint>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.GetEndpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.Endpoint.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EndpointServiceMethodDescriptorSupplier("GetEndpoint"))
                      .build();
        }
      }
    }
    return getGetEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListEndpointsRequest,
          com.google.cloud.aiplatform.v1.ListEndpointsResponse>
      getListEndpointsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEndpoints",
      requestType = com.google.cloud.aiplatform.v1.ListEndpointsRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListEndpointsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListEndpointsRequest,
          com.google.cloud.aiplatform.v1.ListEndpointsResponse>
      getListEndpointsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ListEndpointsRequest,
            com.google.cloud.aiplatform.v1.ListEndpointsResponse>
        getListEndpointsMethod;
    if ((getListEndpointsMethod = EndpointServiceGrpc.getListEndpointsMethod) == null) {
      synchronized (EndpointServiceGrpc.class) {
        if ((getListEndpointsMethod = EndpointServiceGrpc.getListEndpointsMethod) == null) {
          EndpointServiceGrpc.getListEndpointsMethod =
              getListEndpointsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ListEndpointsRequest,
                          com.google.cloud.aiplatform.v1.ListEndpointsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEndpoints"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListEndpointsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListEndpointsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EndpointServiceMethodDescriptorSupplier("ListEndpoints"))
                      .build();
        }
      }
    }
    return getListEndpointsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.UpdateEndpointRequest,
          com.google.cloud.aiplatform.v1.Endpoint>
      getUpdateEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEndpoint",
      requestType = com.google.cloud.aiplatform.v1.UpdateEndpointRequest.class,
      responseType = com.google.cloud.aiplatform.v1.Endpoint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.UpdateEndpointRequest,
          com.google.cloud.aiplatform.v1.Endpoint>
      getUpdateEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.UpdateEndpointRequest,
            com.google.cloud.aiplatform.v1.Endpoint>
        getUpdateEndpointMethod;
    if ((getUpdateEndpointMethod = EndpointServiceGrpc.getUpdateEndpointMethod) == null) {
      synchronized (EndpointServiceGrpc.class) {
        if ((getUpdateEndpointMethod = EndpointServiceGrpc.getUpdateEndpointMethod) == null) {
          EndpointServiceGrpc.getUpdateEndpointMethod =
              getUpdateEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.UpdateEndpointRequest,
                          com.google.cloud.aiplatform.v1.Endpoint>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.UpdateEndpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.Endpoint.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EndpointServiceMethodDescriptorSupplier("UpdateEndpoint"))
                      .build();
        }
      }
    }
    return getUpdateEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.UpdateEndpointLongRunningRequest,
          com.google.longrunning.Operation>
      getUpdateEndpointLongRunningMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEndpointLongRunning",
      requestType = com.google.cloud.aiplatform.v1.UpdateEndpointLongRunningRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.UpdateEndpointLongRunningRequest,
          com.google.longrunning.Operation>
      getUpdateEndpointLongRunningMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.UpdateEndpointLongRunningRequest,
            com.google.longrunning.Operation>
        getUpdateEndpointLongRunningMethod;
    if ((getUpdateEndpointLongRunningMethod =
            EndpointServiceGrpc.getUpdateEndpointLongRunningMethod)
        == null) {
      synchronized (EndpointServiceGrpc.class) {
        if ((getUpdateEndpointLongRunningMethod =
                EndpointServiceGrpc.getUpdateEndpointLongRunningMethod)
            == null) {
          EndpointServiceGrpc.getUpdateEndpointLongRunningMethod =
              getUpdateEndpointLongRunningMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.UpdateEndpointLongRunningRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateEndpointLongRunning"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.UpdateEndpointLongRunningRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EndpointServiceMethodDescriptorSupplier("UpdateEndpointLongRunning"))
                      .build();
        }
      }
    }
    return getUpdateEndpointLongRunningMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DeleteEndpointRequest, com.google.longrunning.Operation>
      getDeleteEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEndpoint",
      requestType = com.google.cloud.aiplatform.v1.DeleteEndpointRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DeleteEndpointRequest, com.google.longrunning.Operation>
      getDeleteEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.DeleteEndpointRequest, com.google.longrunning.Operation>
        getDeleteEndpointMethod;
    if ((getDeleteEndpointMethod = EndpointServiceGrpc.getDeleteEndpointMethod) == null) {
      synchronized (EndpointServiceGrpc.class) {
        if ((getDeleteEndpointMethod = EndpointServiceGrpc.getDeleteEndpointMethod) == null) {
          EndpointServiceGrpc.getDeleteEndpointMethod =
              getDeleteEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.DeleteEndpointRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.DeleteEndpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EndpointServiceMethodDescriptorSupplier("DeleteEndpoint"))
                      .build();
        }
      }
    }
    return getDeleteEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DeployModelRequest, com.google.longrunning.Operation>
      getDeployModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeployModel",
      requestType = com.google.cloud.aiplatform.v1.DeployModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DeployModelRequest, com.google.longrunning.Operation>
      getDeployModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.DeployModelRequest, com.google.longrunning.Operation>
        getDeployModelMethod;
    if ((getDeployModelMethod = EndpointServiceGrpc.getDeployModelMethod) == null) {
      synchronized (EndpointServiceGrpc.class) {
        if ((getDeployModelMethod = EndpointServiceGrpc.getDeployModelMethod) == null) {
          EndpointServiceGrpc.getDeployModelMethod =
              getDeployModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.DeployModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeployModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.DeployModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EndpointServiceMethodDescriptorSupplier("DeployModel"))
                      .build();
        }
      }
    }
    return getDeployModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.UndeployModelRequest, com.google.longrunning.Operation>
      getUndeployModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeployModel",
      requestType = com.google.cloud.aiplatform.v1.UndeployModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.UndeployModelRequest, com.google.longrunning.Operation>
      getUndeployModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.UndeployModelRequest, com.google.longrunning.Operation>
        getUndeployModelMethod;
    if ((getUndeployModelMethod = EndpointServiceGrpc.getUndeployModelMethod) == null) {
      synchronized (EndpointServiceGrpc.class) {
        if ((getUndeployModelMethod = EndpointServiceGrpc.getUndeployModelMethod) == null) {
          EndpointServiceGrpc.getUndeployModelMethod =
              getUndeployModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.UndeployModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UndeployModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.UndeployModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EndpointServiceMethodDescriptorSupplier("UndeployModel"))
                      .build();
        }
      }
    }
    return getUndeployModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.MutateDeployedModelRequest,
          com.google.longrunning.Operation>
      getMutateDeployedModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MutateDeployedModel",
      requestType = com.google.cloud.aiplatform.v1.MutateDeployedModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.MutateDeployedModelRequest,
          com.google.longrunning.Operation>
      getMutateDeployedModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.MutateDeployedModelRequest,
            com.google.longrunning.Operation>
        getMutateDeployedModelMethod;
    if ((getMutateDeployedModelMethod = EndpointServiceGrpc.getMutateDeployedModelMethod) == null) {
      synchronized (EndpointServiceGrpc.class) {
        if ((getMutateDeployedModelMethod = EndpointServiceGrpc.getMutateDeployedModelMethod)
            == null) {
          EndpointServiceGrpc.getMutateDeployedModelMethod =
              getMutateDeployedModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.MutateDeployedModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "MutateDeployedModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.MutateDeployedModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EndpointServiceMethodDescriptorSupplier("MutateDeployedModel"))
                      .build();
        }
      }
    }
    return getMutateDeployedModelMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static EndpointServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EndpointServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EndpointServiceStub>() {
          @java.lang.Override
          public EndpointServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EndpointServiceStub(channel, callOptions);
          }
        };
    return EndpointServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EndpointServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EndpointServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EndpointServiceBlockingStub>() {
          @java.lang.Override
          public EndpointServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EndpointServiceBlockingStub(channel, callOptions);
          }
        };
    return EndpointServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static EndpointServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EndpointServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EndpointServiceFutureStub>() {
          @java.lang.Override
          public EndpointServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EndpointServiceFutureStub(channel, callOptions);
          }
        };
    return EndpointServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service for managing Vertex AI's Endpoints.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates an Endpoint.
     * </pre>
     */
    default void createEndpoint(
        com.google.cloud.aiplatform.v1.CreateEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEndpointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an Endpoint.
     * </pre>
     */
    default void getEndpoint(
        com.google.cloud.aiplatform.v1.GetEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Endpoint> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEndpointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Endpoints in a Location.
     * </pre>
     */
    default void listEndpoints(
        com.google.cloud.aiplatform.v1.ListEndpointsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListEndpointsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEndpointsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an Endpoint.
     * </pre>
     */
    default void updateEndpoint(
        com.google.cloud.aiplatform.v1.UpdateEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Endpoint> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEndpointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an Endpoint with a long running operation.
     * </pre>
     */
    default void updateEndpointLongRunning(
        com.google.cloud.aiplatform.v1.UpdateEndpointLongRunningRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEndpointLongRunningMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Endpoint.
     * </pre>
     */
    default void deleteEndpoint(
        com.google.cloud.aiplatform.v1.DeleteEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEndpointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deploys a Model into this Endpoint, creating a DeployedModel within it.
     * </pre>
     */
    default void deployModel(
        com.google.cloud.aiplatform.v1.DeployModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeployModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeploys a Model from an Endpoint, removing a DeployedModel from it, and
     * freeing all resources it's using.
     * </pre>
     */
    default void undeployModel(
        com.google.cloud.aiplatform.v1.UndeployModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUndeployModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing deployed model. Updatable fields include
     * `min_replica_count`, `max_replica_count`, `autoscaling_metric_specs`,
     * `disable_container_logging` (v1 only), and `enable_container_logging`
     * (v1beta1 only).
     * </pre>
     */
    default void mutateDeployedModel(
        com.google.cloud.aiplatform.v1.MutateDeployedModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getMutateDeployedModelMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service EndpointService.
   *
   * <pre>
   * A service for managing Vertex AI's Endpoints.
   * </pre>
   */
  public abstract static class EndpointServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return EndpointServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service EndpointService.
   *
   * <pre>
   * A service for managing Vertex AI's Endpoints.
   * </pre>
   */
  public static final class EndpointServiceStub
      extends io.grpc.stub.AbstractAsyncStub<EndpointServiceStub> {
    private EndpointServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EndpointServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EndpointServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an Endpoint.
     * </pre>
     */
    public void createEndpoint(
        com.google.cloud.aiplatform.v1.CreateEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEndpointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an Endpoint.
     * </pre>
     */
    public void getEndpoint(
        com.google.cloud.aiplatform.v1.GetEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Endpoint> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEndpointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Endpoints in a Location.
     * </pre>
     */
    public void listEndpoints(
        com.google.cloud.aiplatform.v1.ListEndpointsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListEndpointsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEndpointsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an Endpoint.
     * </pre>
     */
    public void updateEndpoint(
        com.google.cloud.aiplatform.v1.UpdateEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Endpoint> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEndpointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an Endpoint with a long running operation.
     * </pre>
     */
    public void updateEndpointLongRunning(
        com.google.cloud.aiplatform.v1.UpdateEndpointLongRunningRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEndpointLongRunningMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Endpoint.
     * </pre>
     */
    public void deleteEndpoint(
        com.google.cloud.aiplatform.v1.DeleteEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEndpointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deploys a Model into this Endpoint, creating a DeployedModel within it.
     * </pre>
     */
    public void deployModel(
        com.google.cloud.aiplatform.v1.DeployModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeployModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeploys a Model from an Endpoint, removing a DeployedModel from it, and
     * freeing all resources it's using.
     * </pre>
     */
    public void undeployModel(
        com.google.cloud.aiplatform.v1.UndeployModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeployModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing deployed model. Updatable fields include
     * `min_replica_count`, `max_replica_count`, `autoscaling_metric_specs`,
     * `disable_container_logging` (v1 only), and `enable_container_logging`
     * (v1beta1 only).
     * </pre>
     */
    public void mutateDeployedModel(
        com.google.cloud.aiplatform.v1.MutateDeployedModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMutateDeployedModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service EndpointService.
   *
   * <pre>
   * A service for managing Vertex AI's Endpoints.
   * </pre>
   */
  public static final class EndpointServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EndpointServiceBlockingStub> {
    private EndpointServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EndpointServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EndpointServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an Endpoint.
     * </pre>
     */
    public com.google.longrunning.Operation createEndpoint(
        com.google.cloud.aiplatform.v1.CreateEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an Endpoint.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.Endpoint getEndpoint(
        com.google.cloud.aiplatform.v1.GetEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Endpoints in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListEndpointsResponse listEndpoints(
        com.google.cloud.aiplatform.v1.ListEndpointsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEndpointsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an Endpoint.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.Endpoint updateEndpoint(
        com.google.cloud.aiplatform.v1.UpdateEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an Endpoint with a long running operation.
     * </pre>
     */
    public com.google.longrunning.Operation updateEndpointLongRunning(
        com.google.cloud.aiplatform.v1.UpdateEndpointLongRunningRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEndpointLongRunningMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Endpoint.
     * </pre>
     */
    public com.google.longrunning.Operation deleteEndpoint(
        com.google.cloud.aiplatform.v1.DeleteEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deploys a Model into this Endpoint, creating a DeployedModel within it.
     * </pre>
     */
    public com.google.longrunning.Operation deployModel(
        com.google.cloud.aiplatform.v1.DeployModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeployModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Undeploys a Model from an Endpoint, removing a DeployedModel from it, and
     * freeing all resources it's using.
     * </pre>
     */
    public com.google.longrunning.Operation undeployModel(
        com.google.cloud.aiplatform.v1.UndeployModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeployModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing deployed model. Updatable fields include
     * `min_replica_count`, `max_replica_count`, `autoscaling_metric_specs`,
     * `disable_container_logging` (v1 only), and `enable_container_logging`
     * (v1beta1 only).
     * </pre>
     */
    public com.google.longrunning.Operation mutateDeployedModel(
        com.google.cloud.aiplatform.v1.MutateDeployedModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMutateDeployedModelMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service EndpointService.
   *
   * <pre>
   * A service for managing Vertex AI's Endpoints.
   * </pre>
   */
  public static final class EndpointServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<EndpointServiceFutureStub> {
    private EndpointServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EndpointServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EndpointServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an Endpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createEndpoint(com.google.cloud.aiplatform.v1.CreateEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEndpointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an Endpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.Endpoint>
        getEndpoint(com.google.cloud.aiplatform.v1.GetEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEndpointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Endpoints in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.ListEndpointsResponse>
        listEndpoints(com.google.cloud.aiplatform.v1.ListEndpointsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEndpointsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an Endpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.Endpoint>
        updateEndpoint(com.google.cloud.aiplatform.v1.UpdateEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEndpointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an Endpoint with a long running operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateEndpointLongRunning(
            com.google.cloud.aiplatform.v1.UpdateEndpointLongRunningRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEndpointLongRunningMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Endpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteEndpoint(com.google.cloud.aiplatform.v1.DeleteEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEndpointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deploys a Model into this Endpoint, creating a DeployedModel within it.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deployModel(com.google.cloud.aiplatform.v1.DeployModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeployModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Undeploys a Model from an Endpoint, removing a DeployedModel from it, and
     * freeing all resources it's using.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        undeployModel(com.google.cloud.aiplatform.v1.UndeployModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeployModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing deployed model. Updatable fields include
     * `min_replica_count`, `max_replica_count`, `autoscaling_metric_specs`,
     * `disable_container_logging` (v1 only), and `enable_container_logging`
     * (v1beta1 only).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        mutateDeployedModel(com.google.cloud.aiplatform.v1.MutateDeployedModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMutateDeployedModelMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ENDPOINT = 0;
  private static final int METHODID_GET_ENDPOINT = 1;
  private static final int METHODID_LIST_ENDPOINTS = 2;
  private static final int METHODID_UPDATE_ENDPOINT = 3;
  private static final int METHODID_UPDATE_ENDPOINT_LONG_RUNNING = 4;
  private static final int METHODID_DELETE_ENDPOINT = 5;
  private static final int METHODID_DEPLOY_MODEL = 6;
  private static final int METHODID_UNDEPLOY_MODEL = 7;
  private static final int METHODID_MUTATE_DEPLOYED_MODEL = 8;

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
        case METHODID_CREATE_ENDPOINT:
          serviceImpl.createEndpoint(
              (com.google.cloud.aiplatform.v1.CreateEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_ENDPOINT:
          serviceImpl.getEndpoint(
              (com.google.cloud.aiplatform.v1.GetEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Endpoint>)
                  responseObserver);
          break;
        case METHODID_LIST_ENDPOINTS:
          serviceImpl.listEndpoints(
              (com.google.cloud.aiplatform.v1.ListEndpointsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListEndpointsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ENDPOINT:
          serviceImpl.updateEndpoint(
              (com.google.cloud.aiplatform.v1.UpdateEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Endpoint>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ENDPOINT_LONG_RUNNING:
          serviceImpl.updateEndpointLongRunning(
              (com.google.cloud.aiplatform.v1.UpdateEndpointLongRunningRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ENDPOINT:
          serviceImpl.deleteEndpoint(
              (com.google.cloud.aiplatform.v1.DeleteEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DEPLOY_MODEL:
          serviceImpl.deployModel(
              (com.google.cloud.aiplatform.v1.DeployModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UNDEPLOY_MODEL:
          serviceImpl.undeployModel(
              (com.google.cloud.aiplatform.v1.UndeployModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_MUTATE_DEPLOYED_MODEL:
          serviceImpl.mutateDeployedModel(
              (com.google.cloud.aiplatform.v1.MutateDeployedModelRequest) request,
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
            getCreateEndpointMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.CreateEndpointRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_ENDPOINT)))
        .addMethod(
            getGetEndpointMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.GetEndpointRequest,
                    com.google.cloud.aiplatform.v1.Endpoint>(service, METHODID_GET_ENDPOINT)))
        .addMethod(
            getListEndpointsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.ListEndpointsRequest,
                    com.google.cloud.aiplatform.v1.ListEndpointsResponse>(
                    service, METHODID_LIST_ENDPOINTS)))
        .addMethod(
            getUpdateEndpointMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.UpdateEndpointRequest,
                    com.google.cloud.aiplatform.v1.Endpoint>(service, METHODID_UPDATE_ENDPOINT)))
        .addMethod(
            getUpdateEndpointLongRunningMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.UpdateEndpointLongRunningRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_ENDPOINT_LONG_RUNNING)))
        .addMethod(
            getDeleteEndpointMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.DeleteEndpointRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_ENDPOINT)))
        .addMethod(
            getDeployModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.DeployModelRequest,
                    com.google.longrunning.Operation>(service, METHODID_DEPLOY_MODEL)))
        .addMethod(
            getUndeployModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.UndeployModelRequest,
                    com.google.longrunning.Operation>(service, METHODID_UNDEPLOY_MODEL)))
        .addMethod(
            getMutateDeployedModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.MutateDeployedModelRequest,
                    com.google.longrunning.Operation>(service, METHODID_MUTATE_DEPLOYED_MODEL)))
        .build();
  }

  private abstract static class EndpointServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EndpointServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1.EndpointServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EndpointService");
    }
  }

  private static final class EndpointServiceFileDescriptorSupplier
      extends EndpointServiceBaseDescriptorSupplier {
    EndpointServiceFileDescriptorSupplier() {}
  }

  private static final class EndpointServiceMethodDescriptorSupplier
      extends EndpointServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    EndpointServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (EndpointServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new EndpointServiceFileDescriptorSupplier())
                      .addMethod(getCreateEndpointMethod())
                      .addMethod(getGetEndpointMethod())
                      .addMethod(getListEndpointsMethod())
                      .addMethod(getUpdateEndpointMethod())
                      .addMethod(getUpdateEndpointLongRunningMethod())
                      .addMethod(getDeleteEndpointMethod())
                      .addMethod(getDeployModelMethod())
                      .addMethod(getUndeployModelMethod())
                      .addMethod(getMutateDeployedModelMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
