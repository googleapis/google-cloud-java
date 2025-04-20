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
package com.google.cloud.aiplatform.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The interface of Model Garden Service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1beta1/model_garden_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ModelGardenServiceGrpc {

  private ModelGardenServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.aiplatform.v1beta1.ModelGardenService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetPublisherModelRequest,
          com.google.cloud.aiplatform.v1beta1.PublisherModel>
      getGetPublisherModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPublisherModel",
      requestType = com.google.cloud.aiplatform.v1beta1.GetPublisherModelRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.PublisherModel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetPublisherModelRequest,
          com.google.cloud.aiplatform.v1beta1.PublisherModel>
      getGetPublisherModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetPublisherModelRequest,
            com.google.cloud.aiplatform.v1beta1.PublisherModel>
        getGetPublisherModelMethod;
    if ((getGetPublisherModelMethod = ModelGardenServiceGrpc.getGetPublisherModelMethod) == null) {
      synchronized (ModelGardenServiceGrpc.class) {
        if ((getGetPublisherModelMethod = ModelGardenServiceGrpc.getGetPublisherModelMethod)
            == null) {
          ModelGardenServiceGrpc.getGetPublisherModelMethod =
              getGetPublisherModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetPublisherModelRequest,
                          com.google.cloud.aiplatform.v1beta1.PublisherModel>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPublisherModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetPublisherModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.PublisherModel
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelGardenServiceMethodDescriptorSupplier("GetPublisherModel"))
                      .build();
        }
      }
    }
    return getGetPublisherModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListPublisherModelsRequest,
          com.google.cloud.aiplatform.v1beta1.ListPublisherModelsResponse>
      getListPublisherModelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPublisherModels",
      requestType = com.google.cloud.aiplatform.v1beta1.ListPublisherModelsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListPublisherModelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListPublisherModelsRequest,
          com.google.cloud.aiplatform.v1beta1.ListPublisherModelsResponse>
      getListPublisherModelsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListPublisherModelsRequest,
            com.google.cloud.aiplatform.v1beta1.ListPublisherModelsResponse>
        getListPublisherModelsMethod;
    if ((getListPublisherModelsMethod = ModelGardenServiceGrpc.getListPublisherModelsMethod)
        == null) {
      synchronized (ModelGardenServiceGrpc.class) {
        if ((getListPublisherModelsMethod = ModelGardenServiceGrpc.getListPublisherModelsMethod)
            == null) {
          ModelGardenServiceGrpc.getListPublisherModelsMethod =
              getListPublisherModelsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListPublisherModelsRequest,
                          com.google.cloud.aiplatform.v1beta1.ListPublisherModelsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListPublisherModels"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListPublisherModelsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListPublisherModelsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelGardenServiceMethodDescriptorSupplier("ListPublisherModels"))
                      .build();
        }
      }
    }
    return getListPublisherModelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeployRequest, com.google.longrunning.Operation>
      getDeployMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Deploy",
      requestType = com.google.cloud.aiplatform.v1beta1.DeployRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeployRequest, com.google.longrunning.Operation>
      getDeployMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeployRequest, com.google.longrunning.Operation>
        getDeployMethod;
    if ((getDeployMethod = ModelGardenServiceGrpc.getDeployMethod) == null) {
      synchronized (ModelGardenServiceGrpc.class) {
        if ((getDeployMethod = ModelGardenServiceGrpc.getDeployMethod) == null) {
          ModelGardenServiceGrpc.getDeployMethod =
              getDeployMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeployRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Deploy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeployRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new ModelGardenServiceMethodDescriptorSupplier("Deploy"))
                      .build();
        }
      }
    }
    return getDeployMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeployPublisherModelRequest,
          com.google.longrunning.Operation>
      getDeployPublisherModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeployPublisherModel",
      requestType = com.google.cloud.aiplatform.v1beta1.DeployPublisherModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeployPublisherModelRequest,
          com.google.longrunning.Operation>
      getDeployPublisherModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeployPublisherModelRequest,
            com.google.longrunning.Operation>
        getDeployPublisherModelMethod;
    if ((getDeployPublisherModelMethod = ModelGardenServiceGrpc.getDeployPublisherModelMethod)
        == null) {
      synchronized (ModelGardenServiceGrpc.class) {
        if ((getDeployPublisherModelMethod = ModelGardenServiceGrpc.getDeployPublisherModelMethod)
            == null) {
          ModelGardenServiceGrpc.getDeployPublisherModelMethod =
              getDeployPublisherModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeployPublisherModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeployPublisherModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeployPublisherModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelGardenServiceMethodDescriptorSupplier("DeployPublisherModel"))
                      .build();
        }
      }
    }
    return getDeployPublisherModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ExportPublisherModelRequest,
          com.google.longrunning.Operation>
      getExportPublisherModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportPublisherModel",
      requestType = com.google.cloud.aiplatform.v1beta1.ExportPublisherModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ExportPublisherModelRequest,
          com.google.longrunning.Operation>
      getExportPublisherModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ExportPublisherModelRequest,
            com.google.longrunning.Operation>
        getExportPublisherModelMethod;
    if ((getExportPublisherModelMethod = ModelGardenServiceGrpc.getExportPublisherModelMethod)
        == null) {
      synchronized (ModelGardenServiceGrpc.class) {
        if ((getExportPublisherModelMethod = ModelGardenServiceGrpc.getExportPublisherModelMethod)
            == null) {
          ModelGardenServiceGrpc.getExportPublisherModelMethod =
              getExportPublisherModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ExportPublisherModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ExportPublisherModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ExportPublisherModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelGardenServiceMethodDescriptorSupplier("ExportPublisherModel"))
                      .build();
        }
      }
    }
    return getExportPublisherModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CheckPublisherModelEulaAcceptanceRequest,
          com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance>
      getCheckPublisherModelEulaAcceptanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckPublisherModelEulaAcceptance",
      requestType =
          com.google.cloud.aiplatform.v1beta1.CheckPublisherModelEulaAcceptanceRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CheckPublisherModelEulaAcceptanceRequest,
          com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance>
      getCheckPublisherModelEulaAcceptanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CheckPublisherModelEulaAcceptanceRequest,
            com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance>
        getCheckPublisherModelEulaAcceptanceMethod;
    if ((getCheckPublisherModelEulaAcceptanceMethod =
            ModelGardenServiceGrpc.getCheckPublisherModelEulaAcceptanceMethod)
        == null) {
      synchronized (ModelGardenServiceGrpc.class) {
        if ((getCheckPublisherModelEulaAcceptanceMethod =
                ModelGardenServiceGrpc.getCheckPublisherModelEulaAcceptanceMethod)
            == null) {
          ModelGardenServiceGrpc.getCheckPublisherModelEulaAcceptanceMethod =
              getCheckPublisherModelEulaAcceptanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1
                              .CheckPublisherModelEulaAcceptanceRequest,
                          com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CheckPublisherModelEulaAcceptance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .CheckPublisherModelEulaAcceptanceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelGardenServiceMethodDescriptorSupplier(
                              "CheckPublisherModelEulaAcceptance"))
                      .build();
        }
      }
    }
    return getCheckPublisherModelEulaAcceptanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.AcceptPublisherModelEulaRequest,
          com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance>
      getAcceptPublisherModelEulaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AcceptPublisherModelEula",
      requestType = com.google.cloud.aiplatform.v1beta1.AcceptPublisherModelEulaRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.AcceptPublisherModelEulaRequest,
          com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance>
      getAcceptPublisherModelEulaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.AcceptPublisherModelEulaRequest,
            com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance>
        getAcceptPublisherModelEulaMethod;
    if ((getAcceptPublisherModelEulaMethod =
            ModelGardenServiceGrpc.getAcceptPublisherModelEulaMethod)
        == null) {
      synchronized (ModelGardenServiceGrpc.class) {
        if ((getAcceptPublisherModelEulaMethod =
                ModelGardenServiceGrpc.getAcceptPublisherModelEulaMethod)
            == null) {
          ModelGardenServiceGrpc.getAcceptPublisherModelEulaMethod =
              getAcceptPublisherModelEulaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.AcceptPublisherModelEulaRequest,
                          com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "AcceptPublisherModelEula"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.AcceptPublisherModelEulaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelGardenServiceMethodDescriptorSupplier(
                              "AcceptPublisherModelEula"))
                      .build();
        }
      }
    }
    return getAcceptPublisherModelEulaMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ModelGardenServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModelGardenServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ModelGardenServiceStub>() {
          @java.lang.Override
          public ModelGardenServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ModelGardenServiceStub(channel, callOptions);
          }
        };
    return ModelGardenServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static ModelGardenServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModelGardenServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ModelGardenServiceBlockingV2Stub>() {
          @java.lang.Override
          public ModelGardenServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ModelGardenServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return ModelGardenServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ModelGardenServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModelGardenServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ModelGardenServiceBlockingStub>() {
          @java.lang.Override
          public ModelGardenServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ModelGardenServiceBlockingStub(channel, callOptions);
          }
        };
    return ModelGardenServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ModelGardenServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModelGardenServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ModelGardenServiceFutureStub>() {
          @java.lang.Override
          public ModelGardenServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ModelGardenServiceFutureStub(channel, callOptions);
          }
        };
    return ModelGardenServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The interface of Model Garden Service.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets a Model Garden publisher model.
     * </pre>
     */
    default void getPublisherModel(
        com.google.cloud.aiplatform.v1beta1.GetPublisherModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.PublisherModel>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPublisherModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists publisher models in Model Garden.
     * </pre>
     */
    default void listPublisherModels(
        com.google.cloud.aiplatform.v1beta1.ListPublisherModelsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListPublisherModelsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPublisherModelsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deploys a model to a new endpoint.
     * </pre>
     */
    default void deploy(
        com.google.cloud.aiplatform.v1beta1.DeployRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeployMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deploys publisher models.
     * </pre>
     */
    @java.lang.Deprecated
    default void deployPublisherModel(
        com.google.cloud.aiplatform.v1beta1.DeployPublisherModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeployPublisherModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports a publisher model to a user provided Google Cloud Storage bucket.
     * </pre>
     */
    default void exportPublisherModel(
        com.google.cloud.aiplatform.v1beta1.ExportPublisherModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportPublisherModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Checks the EULA acceptance status of a publisher model.
     * </pre>
     */
    default void checkPublisherModelEulaAcceptance(
        com.google.cloud.aiplatform.v1beta1.CheckPublisherModelEulaAcceptanceRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCheckPublisherModelEulaAcceptanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Accepts the EULA acceptance status of a publisher model.
     * </pre>
     */
    default void acceptPublisherModelEula(
        com.google.cloud.aiplatform.v1beta1.AcceptPublisherModelEulaRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAcceptPublisherModelEulaMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ModelGardenService.
   *
   * <pre>
   * The interface of Model Garden Service.
   * </pre>
   */
  public abstract static class ModelGardenServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ModelGardenServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ModelGardenService.
   *
   * <pre>
   * The interface of Model Garden Service.
   * </pre>
   */
  public static final class ModelGardenServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ModelGardenServiceStub> {
    private ModelGardenServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModelGardenServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModelGardenServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a Model Garden publisher model.
     * </pre>
     */
    public void getPublisherModel(
        com.google.cloud.aiplatform.v1beta1.GetPublisherModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.PublisherModel>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPublisherModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists publisher models in Model Garden.
     * </pre>
     */
    public void listPublisherModels(
        com.google.cloud.aiplatform.v1beta1.ListPublisherModelsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListPublisherModelsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPublisherModelsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deploys a model to a new endpoint.
     * </pre>
     */
    public void deploy(
        com.google.cloud.aiplatform.v1beta1.DeployRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeployMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deploys publisher models.
     * </pre>
     */
    @java.lang.Deprecated
    public void deployPublisherModel(
        com.google.cloud.aiplatform.v1beta1.DeployPublisherModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeployPublisherModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports a publisher model to a user provided Google Cloud Storage bucket.
     * </pre>
     */
    public void exportPublisherModel(
        com.google.cloud.aiplatform.v1beta1.ExportPublisherModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportPublisherModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Checks the EULA acceptance status of a publisher model.
     * </pre>
     */
    public void checkPublisherModelEulaAcceptance(
        com.google.cloud.aiplatform.v1beta1.CheckPublisherModelEulaAcceptanceRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckPublisherModelEulaAcceptanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Accepts the EULA acceptance status of a publisher model.
     * </pre>
     */
    public void acceptPublisherModelEula(
        com.google.cloud.aiplatform.v1beta1.AcceptPublisherModelEulaRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAcceptPublisherModelEulaMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ModelGardenService.
   *
   * <pre>
   * The interface of Model Garden Service.
   * </pre>
   */
  public static final class ModelGardenServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ModelGardenServiceBlockingV2Stub> {
    private ModelGardenServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModelGardenServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModelGardenServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a Model Garden publisher model.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.PublisherModel getPublisherModel(
        com.google.cloud.aiplatform.v1beta1.GetPublisherModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPublisherModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists publisher models in Model Garden.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListPublisherModelsResponse listPublisherModels(
        com.google.cloud.aiplatform.v1beta1.ListPublisherModelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPublisherModelsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deploys a model to a new endpoint.
     * </pre>
     */
    public com.google.longrunning.Operation deploy(
        com.google.cloud.aiplatform.v1beta1.DeployRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeployMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deploys publisher models.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.longrunning.Operation deployPublisherModel(
        com.google.cloud.aiplatform.v1beta1.DeployPublisherModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeployPublisherModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports a publisher model to a user provided Google Cloud Storage bucket.
     * </pre>
     */
    public com.google.longrunning.Operation exportPublisherModel(
        com.google.cloud.aiplatform.v1beta1.ExportPublisherModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportPublisherModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Checks the EULA acceptance status of a publisher model.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance
        checkPublisherModelEulaAcceptance(
            com.google.cloud.aiplatform.v1beta1.CheckPublisherModelEulaAcceptanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckPublisherModelEulaAcceptanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Accepts the EULA acceptance status of a publisher model.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance
        acceptPublisherModelEula(
            com.google.cloud.aiplatform.v1beta1.AcceptPublisherModelEulaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAcceptPublisherModelEulaMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service ModelGardenService.
   *
   * <pre>
   * The interface of Model Garden Service.
   * </pre>
   */
  public static final class ModelGardenServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ModelGardenServiceBlockingStub> {
    private ModelGardenServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModelGardenServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModelGardenServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a Model Garden publisher model.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.PublisherModel getPublisherModel(
        com.google.cloud.aiplatform.v1beta1.GetPublisherModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPublisherModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists publisher models in Model Garden.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListPublisherModelsResponse listPublisherModels(
        com.google.cloud.aiplatform.v1beta1.ListPublisherModelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPublisherModelsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deploys a model to a new endpoint.
     * </pre>
     */
    public com.google.longrunning.Operation deploy(
        com.google.cloud.aiplatform.v1beta1.DeployRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeployMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deploys publisher models.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.longrunning.Operation deployPublisherModel(
        com.google.cloud.aiplatform.v1beta1.DeployPublisherModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeployPublisherModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports a publisher model to a user provided Google Cloud Storage bucket.
     * </pre>
     */
    public com.google.longrunning.Operation exportPublisherModel(
        com.google.cloud.aiplatform.v1beta1.ExportPublisherModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportPublisherModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Checks the EULA acceptance status of a publisher model.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance
        checkPublisherModelEulaAcceptance(
            com.google.cloud.aiplatform.v1beta1.CheckPublisherModelEulaAcceptanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckPublisherModelEulaAcceptanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Accepts the EULA acceptance status of a publisher model.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance
        acceptPublisherModelEula(
            com.google.cloud.aiplatform.v1beta1.AcceptPublisherModelEulaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAcceptPublisherModelEulaMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ModelGardenService.
   *
   * <pre>
   * The interface of Model Garden Service.
   * </pre>
   */
  public static final class ModelGardenServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ModelGardenServiceFutureStub> {
    private ModelGardenServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModelGardenServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModelGardenServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a Model Garden publisher model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.PublisherModel>
        getPublisherModel(com.google.cloud.aiplatform.v1beta1.GetPublisherModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPublisherModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists publisher models in Model Garden.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListPublisherModelsResponse>
        listPublisherModels(
            com.google.cloud.aiplatform.v1beta1.ListPublisherModelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPublisherModelsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deploys a model to a new endpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deploy(com.google.cloud.aiplatform.v1beta1.DeployRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeployMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deploys publisher models.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deployPublisherModel(
            com.google.cloud.aiplatform.v1beta1.DeployPublisherModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeployPublisherModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports a publisher model to a user provided Google Cloud Storage bucket.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportPublisherModel(
            com.google.cloud.aiplatform.v1beta1.ExportPublisherModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportPublisherModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Checks the EULA acceptance status of a publisher model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance>
        checkPublisherModelEulaAcceptance(
            com.google.cloud.aiplatform.v1beta1.CheckPublisherModelEulaAcceptanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckPublisherModelEulaAcceptanceMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Accepts the EULA acceptance status of a publisher model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance>
        acceptPublisherModelEula(
            com.google.cloud.aiplatform.v1beta1.AcceptPublisherModelEulaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAcceptPublisherModelEulaMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PUBLISHER_MODEL = 0;
  private static final int METHODID_LIST_PUBLISHER_MODELS = 1;
  private static final int METHODID_DEPLOY = 2;
  private static final int METHODID_DEPLOY_PUBLISHER_MODEL = 3;
  private static final int METHODID_EXPORT_PUBLISHER_MODEL = 4;
  private static final int METHODID_CHECK_PUBLISHER_MODEL_EULA_ACCEPTANCE = 5;
  private static final int METHODID_ACCEPT_PUBLISHER_MODEL_EULA = 6;

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
        case METHODID_GET_PUBLISHER_MODEL:
          serviceImpl.getPublisherModel(
              (com.google.cloud.aiplatform.v1beta1.GetPublisherModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.PublisherModel>)
                  responseObserver);
          break;
        case METHODID_LIST_PUBLISHER_MODELS:
          serviceImpl.listPublisherModels(
              (com.google.cloud.aiplatform.v1beta1.ListPublisherModelsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListPublisherModelsResponse>)
                  responseObserver);
          break;
        case METHODID_DEPLOY:
          serviceImpl.deploy(
              (com.google.cloud.aiplatform.v1beta1.DeployRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DEPLOY_PUBLISHER_MODEL:
          serviceImpl.deployPublisherModel(
              (com.google.cloud.aiplatform.v1beta1.DeployPublisherModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_PUBLISHER_MODEL:
          serviceImpl.exportPublisherModel(
              (com.google.cloud.aiplatform.v1beta1.ExportPublisherModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CHECK_PUBLISHER_MODEL_EULA_ACCEPTANCE:
          serviceImpl.checkPublisherModelEulaAcceptance(
              (com.google.cloud.aiplatform.v1beta1.CheckPublisherModelEulaAcceptanceRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance>)
                  responseObserver);
          break;
        case METHODID_ACCEPT_PUBLISHER_MODEL_EULA:
          serviceImpl.acceptPublisherModelEula(
              (com.google.cloud.aiplatform.v1beta1.AcceptPublisherModelEulaRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance>)
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
            getGetPublisherModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.GetPublisherModelRequest,
                    com.google.cloud.aiplatform.v1beta1.PublisherModel>(
                    service, METHODID_GET_PUBLISHER_MODEL)))
        .addMethod(
            getListPublisherModelsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ListPublisherModelsRequest,
                    com.google.cloud.aiplatform.v1beta1.ListPublisherModelsResponse>(
                    service, METHODID_LIST_PUBLISHER_MODELS)))
        .addMethod(
            getDeployMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.DeployRequest,
                    com.google.longrunning.Operation>(service, METHODID_DEPLOY)))
        .addMethod(
            getDeployPublisherModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.DeployPublisherModelRequest,
                    com.google.longrunning.Operation>(service, METHODID_DEPLOY_PUBLISHER_MODEL)))
        .addMethod(
            getExportPublisherModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ExportPublisherModelRequest,
                    com.google.longrunning.Operation>(service, METHODID_EXPORT_PUBLISHER_MODEL)))
        .addMethod(
            getCheckPublisherModelEulaAcceptanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.CheckPublisherModelEulaAcceptanceRequest,
                    com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance>(
                    service, METHODID_CHECK_PUBLISHER_MODEL_EULA_ACCEPTANCE)))
        .addMethod(
            getAcceptPublisherModelEulaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.AcceptPublisherModelEulaRequest,
                    com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance>(
                    service, METHODID_ACCEPT_PUBLISHER_MODEL_EULA)))
        .build();
  }

  private abstract static class ModelGardenServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ModelGardenServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1beta1.ModelGardenServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ModelGardenService");
    }
  }

  private static final class ModelGardenServiceFileDescriptorSupplier
      extends ModelGardenServiceBaseDescriptorSupplier {
    ModelGardenServiceFileDescriptorSupplier() {}
  }

  private static final class ModelGardenServiceMethodDescriptorSupplier
      extends ModelGardenServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ModelGardenServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ModelGardenServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ModelGardenServiceFileDescriptorSupplier())
                      .addMethod(getGetPublisherModelMethod())
                      .addMethod(getListPublisherModelsMethod())
                      .addMethod(getDeployMethod())
                      .addMethod(getDeployPublisherModelMethod())
                      .addMethod(getExportPublisherModelMethod())
                      .addMethod(getCheckPublisherModelEulaAcceptanceMethod())
                      .addMethod(getAcceptPublisherModelEulaMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
