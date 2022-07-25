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
package com.google.cloud.aiplatform.v1beta1;

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
    comments = "Source: google/cloud/aiplatform/v1beta1/endpoint_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EndpointServiceGrpc {

  private EndpointServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.aiplatform.v1beta1.EndpointService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateEndpointRequest,
          com.google.longrunning.Operation>
      getCreateEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEndpoint",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateEndpointRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateEndpointRequest,
          com.google.longrunning.Operation>
      getCreateEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateEndpointRequest,
            com.google.longrunning.Operation>
        getCreateEndpointMethod;
    if ((getCreateEndpointMethod = EndpointServiceGrpc.getCreateEndpointMethod) == null) {
      synchronized (EndpointServiceGrpc.class) {
        if ((getCreateEndpointMethod = EndpointServiceGrpc.getCreateEndpointMethod) == null) {
          EndpointServiceGrpc.getCreateEndpointMethod =
              getCreateEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreateEndpointRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CreateEndpointRequest
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
          com.google.cloud.aiplatform.v1beta1.GetEndpointRequest,
          com.google.cloud.aiplatform.v1beta1.Endpoint>
      getGetEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEndpoint",
      requestType = com.google.cloud.aiplatform.v1beta1.GetEndpointRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.Endpoint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetEndpointRequest,
          com.google.cloud.aiplatform.v1beta1.Endpoint>
      getGetEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetEndpointRequest,
            com.google.cloud.aiplatform.v1beta1.Endpoint>
        getGetEndpointMethod;
    if ((getGetEndpointMethod = EndpointServiceGrpc.getGetEndpointMethod) == null) {
      synchronized (EndpointServiceGrpc.class) {
        if ((getGetEndpointMethod = EndpointServiceGrpc.getGetEndpointMethod) == null) {
          EndpointServiceGrpc.getGetEndpointMethod =
              getGetEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetEndpointRequest,
                          com.google.cloud.aiplatform.v1beta1.Endpoint>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetEndpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.Endpoint.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EndpointServiceMethodDescriptorSupplier("GetEndpoint"))
                      .build();
        }
      }
    }
    return getGetEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListEndpointsRequest,
          com.google.cloud.aiplatform.v1beta1.ListEndpointsResponse>
      getListEndpointsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEndpoints",
      requestType = com.google.cloud.aiplatform.v1beta1.ListEndpointsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListEndpointsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListEndpointsRequest,
          com.google.cloud.aiplatform.v1beta1.ListEndpointsResponse>
      getListEndpointsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListEndpointsRequest,
            com.google.cloud.aiplatform.v1beta1.ListEndpointsResponse>
        getListEndpointsMethod;
    if ((getListEndpointsMethod = EndpointServiceGrpc.getListEndpointsMethod) == null) {
      synchronized (EndpointServiceGrpc.class) {
        if ((getListEndpointsMethod = EndpointServiceGrpc.getListEndpointsMethod) == null) {
          EndpointServiceGrpc.getListEndpointsMethod =
              getListEndpointsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListEndpointsRequest,
                          com.google.cloud.aiplatform.v1beta1.ListEndpointsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEndpoints"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListEndpointsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListEndpointsResponse
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
          com.google.cloud.aiplatform.v1beta1.UpdateEndpointRequest,
          com.google.cloud.aiplatform.v1beta1.Endpoint>
      getUpdateEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEndpoint",
      requestType = com.google.cloud.aiplatform.v1beta1.UpdateEndpointRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.Endpoint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateEndpointRequest,
          com.google.cloud.aiplatform.v1beta1.Endpoint>
      getUpdateEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.UpdateEndpointRequest,
            com.google.cloud.aiplatform.v1beta1.Endpoint>
        getUpdateEndpointMethod;
    if ((getUpdateEndpointMethod = EndpointServiceGrpc.getUpdateEndpointMethod) == null) {
      synchronized (EndpointServiceGrpc.class) {
        if ((getUpdateEndpointMethod = EndpointServiceGrpc.getUpdateEndpointMethod) == null) {
          EndpointServiceGrpc.getUpdateEndpointMethod =
              getUpdateEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.UpdateEndpointRequest,
                          com.google.cloud.aiplatform.v1beta1.Endpoint>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UpdateEndpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.Endpoint.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EndpointServiceMethodDescriptorSupplier("UpdateEndpoint"))
                      .build();
        }
      }
    }
    return getUpdateEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteEndpointRequest,
          com.google.longrunning.Operation>
      getDeleteEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEndpoint",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteEndpointRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteEndpointRequest,
          com.google.longrunning.Operation>
      getDeleteEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteEndpointRequest,
            com.google.longrunning.Operation>
        getDeleteEndpointMethod;
    if ((getDeleteEndpointMethod = EndpointServiceGrpc.getDeleteEndpointMethod) == null) {
      synchronized (EndpointServiceGrpc.class) {
        if ((getDeleteEndpointMethod = EndpointServiceGrpc.getDeleteEndpointMethod) == null) {
          EndpointServiceGrpc.getDeleteEndpointMethod =
              getDeleteEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteEndpointRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteEndpointRequest
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
          com.google.cloud.aiplatform.v1beta1.DeployModelRequest, com.google.longrunning.Operation>
      getDeployModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeployModel",
      requestType = com.google.cloud.aiplatform.v1beta1.DeployModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeployModelRequest, com.google.longrunning.Operation>
      getDeployModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeployModelRequest,
            com.google.longrunning.Operation>
        getDeployModelMethod;
    if ((getDeployModelMethod = EndpointServiceGrpc.getDeployModelMethod) == null) {
      synchronized (EndpointServiceGrpc.class) {
        if ((getDeployModelMethod = EndpointServiceGrpc.getDeployModelMethod) == null) {
          EndpointServiceGrpc.getDeployModelMethod =
              getDeployModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeployModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeployModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeployModelRequest
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
          com.google.cloud.aiplatform.v1beta1.UndeployModelRequest,
          com.google.longrunning.Operation>
      getUndeployModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeployModel",
      requestType = com.google.cloud.aiplatform.v1beta1.UndeployModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UndeployModelRequest,
          com.google.longrunning.Operation>
      getUndeployModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.UndeployModelRequest,
            com.google.longrunning.Operation>
        getUndeployModelMethod;
    if ((getUndeployModelMethod = EndpointServiceGrpc.getUndeployModelMethod) == null) {
      synchronized (EndpointServiceGrpc.class) {
        if ((getUndeployModelMethod = EndpointServiceGrpc.getUndeployModelMethod) == null) {
          EndpointServiceGrpc.getUndeployModelMethod =
              getUndeployModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.UndeployModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UndeployModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UndeployModelRequest
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
  public abstract static class EndpointServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates an Endpoint.
     * </pre>
     */
    public void createEndpoint(
        com.google.cloud.aiplatform.v1beta1.CreateEndpointRequest request,
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
    public void getEndpoint(
        com.google.cloud.aiplatform.v1beta1.GetEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Endpoint>
            responseObserver) {
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
    public void listEndpoints(
        com.google.cloud.aiplatform.v1beta1.ListEndpointsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListEndpointsResponse>
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
    public void updateEndpoint(
        com.google.cloud.aiplatform.v1beta1.UpdateEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Endpoint>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEndpointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Endpoint.
     * </pre>
     */
    public void deleteEndpoint(
        com.google.cloud.aiplatform.v1beta1.DeleteEndpointRequest request,
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
    public void deployModel(
        com.google.cloud.aiplatform.v1beta1.DeployModelRequest request,
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
    public void undeployModel(
        com.google.cloud.aiplatform.v1beta1.UndeployModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUndeployModelMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateEndpointMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.CreateEndpointRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_ENDPOINT)))
          .addMethod(
              getGetEndpointMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.GetEndpointRequest,
                      com.google.cloud.aiplatform.v1beta1.Endpoint>(this, METHODID_GET_ENDPOINT)))
          .addMethod(
              getListEndpointsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.ListEndpointsRequest,
                      com.google.cloud.aiplatform.v1beta1.ListEndpointsResponse>(
                      this, METHODID_LIST_ENDPOINTS)))
          .addMethod(
              getUpdateEndpointMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.UpdateEndpointRequest,
                      com.google.cloud.aiplatform.v1beta1.Endpoint>(
                      this, METHODID_UPDATE_ENDPOINT)))
          .addMethod(
              getDeleteEndpointMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.DeleteEndpointRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_ENDPOINT)))
          .addMethod(
              getDeployModelMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.DeployModelRequest,
                      com.google.longrunning.Operation>(this, METHODID_DEPLOY_MODEL)))
          .addMethod(
              getUndeployModelMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.UndeployModelRequest,
                      com.google.longrunning.Operation>(this, METHODID_UNDEPLOY_MODEL)))
          .build();
    }
  }

  /**
   *
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
        com.google.cloud.aiplatform.v1beta1.CreateEndpointRequest request,
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
        com.google.cloud.aiplatform.v1beta1.GetEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Endpoint>
            responseObserver) {
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
        com.google.cloud.aiplatform.v1beta1.ListEndpointsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListEndpointsResponse>
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
        com.google.cloud.aiplatform.v1beta1.UpdateEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Endpoint>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEndpointMethod(), getCallOptions()),
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
        com.google.cloud.aiplatform.v1beta1.DeleteEndpointRequest request,
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
        com.google.cloud.aiplatform.v1beta1.DeployModelRequest request,
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
        com.google.cloud.aiplatform.v1beta1.UndeployModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeployModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
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
        com.google.cloud.aiplatform.v1beta1.CreateEndpointRequest request) {
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
    public com.google.cloud.aiplatform.v1beta1.Endpoint getEndpoint(
        com.google.cloud.aiplatform.v1beta1.GetEndpointRequest request) {
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
    public com.google.cloud.aiplatform.v1beta1.ListEndpointsResponse listEndpoints(
        com.google.cloud.aiplatform.v1beta1.ListEndpointsRequest request) {
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
    public com.google.cloud.aiplatform.v1beta1.Endpoint updateEndpoint(
        com.google.cloud.aiplatform.v1beta1.UpdateEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Endpoint.
     * </pre>
     */
    public com.google.longrunning.Operation deleteEndpoint(
        com.google.cloud.aiplatform.v1beta1.DeleteEndpointRequest request) {
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
        com.google.cloud.aiplatform.v1beta1.DeployModelRequest request) {
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
        com.google.cloud.aiplatform.v1beta1.UndeployModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeployModelMethod(), getCallOptions(), request);
    }
  }

  /**
   *
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
        createEndpoint(com.google.cloud.aiplatform.v1beta1.CreateEndpointRequest request) {
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
            com.google.cloud.aiplatform.v1beta1.Endpoint>
        getEndpoint(com.google.cloud.aiplatform.v1beta1.GetEndpointRequest request) {
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
            com.google.cloud.aiplatform.v1beta1.ListEndpointsResponse>
        listEndpoints(com.google.cloud.aiplatform.v1beta1.ListEndpointsRequest request) {
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
            com.google.cloud.aiplatform.v1beta1.Endpoint>
        updateEndpoint(com.google.cloud.aiplatform.v1beta1.UpdateEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEndpointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Endpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteEndpoint(com.google.cloud.aiplatform.v1beta1.DeleteEndpointRequest request) {
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
        deployModel(com.google.cloud.aiplatform.v1beta1.DeployModelRequest request) {
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
        undeployModel(com.google.cloud.aiplatform.v1beta1.UndeployModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeployModelMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ENDPOINT = 0;
  private static final int METHODID_GET_ENDPOINT = 1;
  private static final int METHODID_LIST_ENDPOINTS = 2;
  private static final int METHODID_UPDATE_ENDPOINT = 3;
  private static final int METHODID_DELETE_ENDPOINT = 4;
  private static final int METHODID_DEPLOY_MODEL = 5;
  private static final int METHODID_UNDEPLOY_MODEL = 6;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EndpointServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EndpointServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_ENDPOINT:
          serviceImpl.createEndpoint(
              (com.google.cloud.aiplatform.v1beta1.CreateEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_ENDPOINT:
          serviceImpl.getEndpoint(
              (com.google.cloud.aiplatform.v1beta1.GetEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Endpoint>)
                  responseObserver);
          break;
        case METHODID_LIST_ENDPOINTS:
          serviceImpl.listEndpoints(
              (com.google.cloud.aiplatform.v1beta1.ListEndpointsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListEndpointsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ENDPOINT:
          serviceImpl.updateEndpoint(
              (com.google.cloud.aiplatform.v1beta1.UpdateEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Endpoint>)
                  responseObserver);
          break;
        case METHODID_DELETE_ENDPOINT:
          serviceImpl.deleteEndpoint(
              (com.google.cloud.aiplatform.v1beta1.DeleteEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DEPLOY_MODEL:
          serviceImpl.deployModel(
              (com.google.cloud.aiplatform.v1beta1.DeployModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UNDEPLOY_MODEL:
          serviceImpl.undeployModel(
              (com.google.cloud.aiplatform.v1beta1.UndeployModelRequest) request,
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

  private abstract static class EndpointServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EndpointServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1beta1.EndpointServiceProto.getDescriptor();
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
    private final String methodName;

    EndpointServiceMethodDescriptorSupplier(String methodName) {
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
                      .addMethod(getDeleteEndpointMethod())
                      .addMethod(getDeployModelMethod())
                      .addMethod(getUndeployModelMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
