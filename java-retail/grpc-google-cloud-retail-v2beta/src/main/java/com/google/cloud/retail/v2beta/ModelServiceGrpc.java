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
package com.google.cloud.retail.v2beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for performing CRUD operations on models.
 * Recommendation models contain all the metadata necessary to generate a set of
 * models for the `Predict()` API. A model is queried
 * indirectly via a ServingConfig, which associates a model with a
 * given Placement (e.g. Frequently Bought Together on Home Page).
 * This service allows you to do the following:
 * * Initiate training of a model.
 * * Pause training of an existing model.
 * * List all the available models along with their metadata.
 * * Control their tuning schedule.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/retail/v2beta/model_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ModelServiceGrpc {

  private ModelServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.retail.v2beta.ModelService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.CreateModelRequest, com.google.longrunning.Operation>
      getCreateModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateModel",
      requestType = com.google.cloud.retail.v2beta.CreateModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.CreateModelRequest, com.google.longrunning.Operation>
      getCreateModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2beta.CreateModelRequest, com.google.longrunning.Operation>
        getCreateModelMethod;
    if ((getCreateModelMethod = ModelServiceGrpc.getCreateModelMethod) == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getCreateModelMethod = ModelServiceGrpc.getCreateModelMethod) == null) {
          ModelServiceGrpc.getCreateModelMethod =
              getCreateModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2beta.CreateModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.CreateModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new ModelServiceMethodDescriptorSupplier("CreateModel"))
                      .build();
        }
      }
    }
    return getCreateModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.PauseModelRequest, com.google.cloud.retail.v2beta.Model>
      getPauseModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PauseModel",
      requestType = com.google.cloud.retail.v2beta.PauseModelRequest.class,
      responseType = com.google.cloud.retail.v2beta.Model.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.PauseModelRequest, com.google.cloud.retail.v2beta.Model>
      getPauseModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2beta.PauseModelRequest, com.google.cloud.retail.v2beta.Model>
        getPauseModelMethod;
    if ((getPauseModelMethod = ModelServiceGrpc.getPauseModelMethod) == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getPauseModelMethod = ModelServiceGrpc.getPauseModelMethod) == null) {
          ModelServiceGrpc.getPauseModelMethod =
              getPauseModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2beta.PauseModelRequest,
                          com.google.cloud.retail.v2beta.Model>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PauseModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.PauseModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.Model.getDefaultInstance()))
                      .setSchemaDescriptor(new ModelServiceMethodDescriptorSupplier("PauseModel"))
                      .build();
        }
      }
    }
    return getPauseModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.ResumeModelRequest, com.google.cloud.retail.v2beta.Model>
      getResumeModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResumeModel",
      requestType = com.google.cloud.retail.v2beta.ResumeModelRequest.class,
      responseType = com.google.cloud.retail.v2beta.Model.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.ResumeModelRequest, com.google.cloud.retail.v2beta.Model>
      getResumeModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2beta.ResumeModelRequest, com.google.cloud.retail.v2beta.Model>
        getResumeModelMethod;
    if ((getResumeModelMethod = ModelServiceGrpc.getResumeModelMethod) == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getResumeModelMethod = ModelServiceGrpc.getResumeModelMethod) == null) {
          ModelServiceGrpc.getResumeModelMethod =
              getResumeModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2beta.ResumeModelRequest,
                          com.google.cloud.retail.v2beta.Model>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResumeModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.ResumeModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.Model.getDefaultInstance()))
                      .setSchemaDescriptor(new ModelServiceMethodDescriptorSupplier("ResumeModel"))
                      .build();
        }
      }
    }
    return getResumeModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.DeleteModelRequest, com.google.protobuf.Empty>
      getDeleteModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteModel",
      requestType = com.google.cloud.retail.v2beta.DeleteModelRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.DeleteModelRequest, com.google.protobuf.Empty>
      getDeleteModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2beta.DeleteModelRequest, com.google.protobuf.Empty>
        getDeleteModelMethod;
    if ((getDeleteModelMethod = ModelServiceGrpc.getDeleteModelMethod) == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getDeleteModelMethod = ModelServiceGrpc.getDeleteModelMethod) == null) {
          ModelServiceGrpc.getDeleteModelMethod =
              getDeleteModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2beta.DeleteModelRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.DeleteModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new ModelServiceMethodDescriptorSupplier("DeleteModel"))
                      .build();
        }
      }
    }
    return getDeleteModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.ListModelsRequest,
          com.google.cloud.retail.v2beta.ListModelsResponse>
      getListModelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListModels",
      requestType = com.google.cloud.retail.v2beta.ListModelsRequest.class,
      responseType = com.google.cloud.retail.v2beta.ListModelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.ListModelsRequest,
          com.google.cloud.retail.v2beta.ListModelsResponse>
      getListModelsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2beta.ListModelsRequest,
            com.google.cloud.retail.v2beta.ListModelsResponse>
        getListModelsMethod;
    if ((getListModelsMethod = ModelServiceGrpc.getListModelsMethod) == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getListModelsMethod = ModelServiceGrpc.getListModelsMethod) == null) {
          ModelServiceGrpc.getListModelsMethod =
              getListModelsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2beta.ListModelsRequest,
                          com.google.cloud.retail.v2beta.ListModelsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListModels"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.ListModelsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.ListModelsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ModelServiceMethodDescriptorSupplier("ListModels"))
                      .build();
        }
      }
    }
    return getListModelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.UpdateModelRequest, com.google.cloud.retail.v2beta.Model>
      getUpdateModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateModel",
      requestType = com.google.cloud.retail.v2beta.UpdateModelRequest.class,
      responseType = com.google.cloud.retail.v2beta.Model.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.UpdateModelRequest, com.google.cloud.retail.v2beta.Model>
      getUpdateModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2beta.UpdateModelRequest, com.google.cloud.retail.v2beta.Model>
        getUpdateModelMethod;
    if ((getUpdateModelMethod = ModelServiceGrpc.getUpdateModelMethod) == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getUpdateModelMethod = ModelServiceGrpc.getUpdateModelMethod) == null) {
          ModelServiceGrpc.getUpdateModelMethod =
              getUpdateModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2beta.UpdateModelRequest,
                          com.google.cloud.retail.v2beta.Model>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.UpdateModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.Model.getDefaultInstance()))
                      .setSchemaDescriptor(new ModelServiceMethodDescriptorSupplier("UpdateModel"))
                      .build();
        }
      }
    }
    return getUpdateModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.TuneModelRequest, com.google.longrunning.Operation>
      getTuneModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TuneModel",
      requestType = com.google.cloud.retail.v2beta.TuneModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.TuneModelRequest, com.google.longrunning.Operation>
      getTuneModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2beta.TuneModelRequest, com.google.longrunning.Operation>
        getTuneModelMethod;
    if ((getTuneModelMethod = ModelServiceGrpc.getTuneModelMethod) == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getTuneModelMethod = ModelServiceGrpc.getTuneModelMethod) == null) {
          ModelServiceGrpc.getTuneModelMethod =
              getTuneModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2beta.TuneModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TuneModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.TuneModelRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new ModelServiceMethodDescriptorSupplier("TuneModel"))
                      .build();
        }
      }
    }
    return getTuneModelMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ModelServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModelServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ModelServiceStub>() {
          @java.lang.Override
          public ModelServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ModelServiceStub(channel, callOptions);
          }
        };
    return ModelServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ModelServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModelServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ModelServiceBlockingStub>() {
          @java.lang.Override
          public ModelServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ModelServiceBlockingStub(channel, callOptions);
          }
        };
    return ModelServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ModelServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModelServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ModelServiceFutureStub>() {
          @java.lang.Override
          public ModelServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ModelServiceFutureStub(channel, callOptions);
          }
        };
    return ModelServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for performing CRUD operations on models.
   * Recommendation models contain all the metadata necessary to generate a set of
   * models for the `Predict()` API. A model is queried
   * indirectly via a ServingConfig, which associates a model with a
   * given Placement (e.g. Frequently Bought Together on Home Page).
   * This service allows you to do the following:
   * * Initiate training of a model.
   * * Pause training of an existing model.
   * * List all the available models along with their metadata.
   * * Control their tuning schedule.
   * </pre>
   */
  public abstract static class ModelServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a new model.
     * </pre>
     */
    public void createModel(
        com.google.cloud.retail.v2beta.CreateModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pauses the training of an existing model.
     * </pre>
     */
    public void pauseModel(
        com.google.cloud.retail.v2beta.PauseModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.Model> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPauseModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resumes the training of an existing model.
     * </pre>
     */
    public void resumeModel(
        com.google.cloud.retail.v2beta.ResumeModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.Model> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResumeModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing model.
     * </pre>
     */
    public void deleteModel(
        com.google.cloud.retail.v2beta.DeleteModelRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the models linked to this event store.
     * </pre>
     */
    public void listModels(
        com.google.cloud.retail.v2beta.ListModelsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.ListModelsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListModelsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update of model metadata. Only fields that
     * currently can be updated are: `filtering_option` and
     * `periodic_tuning_state`.
     * If other values are provided, this API method ignores them.
     * </pre>
     */
    public void updateModel(
        com.google.cloud.retail.v2beta.UpdateModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.Model> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Tunes an existing model.
     * </pre>
     */
    public void tuneModel(
        com.google.cloud.retail.v2beta.TuneModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTuneModelMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateModelMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.retail.v2beta.CreateModelRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_MODEL)))
          .addMethod(
              getPauseModelMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.retail.v2beta.PauseModelRequest,
                      com.google.cloud.retail.v2beta.Model>(this, METHODID_PAUSE_MODEL)))
          .addMethod(
              getResumeModelMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.retail.v2beta.ResumeModelRequest,
                      com.google.cloud.retail.v2beta.Model>(this, METHODID_RESUME_MODEL)))
          .addMethod(
              getDeleteModelMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.retail.v2beta.DeleteModelRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_MODEL)))
          .addMethod(
              getListModelsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.retail.v2beta.ListModelsRequest,
                      com.google.cloud.retail.v2beta.ListModelsResponse>(
                      this, METHODID_LIST_MODELS)))
          .addMethod(
              getUpdateModelMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.retail.v2beta.UpdateModelRequest,
                      com.google.cloud.retail.v2beta.Model>(this, METHODID_UPDATE_MODEL)))
          .addMethod(
              getTuneModelMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.retail.v2beta.TuneModelRequest,
                      com.google.longrunning.Operation>(this, METHODID_TUNE_MODEL)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for performing CRUD operations on models.
   * Recommendation models contain all the metadata necessary to generate a set of
   * models for the `Predict()` API. A model is queried
   * indirectly via a ServingConfig, which associates a model with a
   * given Placement (e.g. Frequently Bought Together on Home Page).
   * This service allows you to do the following:
   * * Initiate training of a model.
   * * Pause training of an existing model.
   * * List all the available models along with their metadata.
   * * Control their tuning schedule.
   * </pre>
   */
  public static final class ModelServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ModelServiceStub> {
    private ModelServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModelServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModelServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new model.
     * </pre>
     */
    public void createModel(
        com.google.cloud.retail.v2beta.CreateModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pauses the training of an existing model.
     * </pre>
     */
    public void pauseModel(
        com.google.cloud.retail.v2beta.PauseModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.Model> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPauseModelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resumes the training of an existing model.
     * </pre>
     */
    public void resumeModel(
        com.google.cloud.retail.v2beta.ResumeModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.Model> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResumeModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing model.
     * </pre>
     */
    public void deleteModel(
        com.google.cloud.retail.v2beta.DeleteModelRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the models linked to this event store.
     * </pre>
     */
    public void listModels(
        com.google.cloud.retail.v2beta.ListModelsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.ListModelsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListModelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update of model metadata. Only fields that
     * currently can be updated are: `filtering_option` and
     * `periodic_tuning_state`.
     * If other values are provided, this API method ignores them.
     * </pre>
     */
    public void updateModel(
        com.google.cloud.retail.v2beta.UpdateModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.Model> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Tunes an existing model.
     * </pre>
     */
    public void tuneModel(
        com.google.cloud.retail.v2beta.TuneModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTuneModelMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for performing CRUD operations on models.
   * Recommendation models contain all the metadata necessary to generate a set of
   * models for the `Predict()` API. A model is queried
   * indirectly via a ServingConfig, which associates a model with a
   * given Placement (e.g. Frequently Bought Together on Home Page).
   * This service allows you to do the following:
   * * Initiate training of a model.
   * * Pause training of an existing model.
   * * List all the available models along with their metadata.
   * * Control their tuning schedule.
   * </pre>
   */
  public static final class ModelServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ModelServiceBlockingStub> {
    private ModelServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModelServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModelServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new model.
     * </pre>
     */
    public com.google.longrunning.Operation createModel(
        com.google.cloud.retail.v2beta.CreateModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Pauses the training of an existing model.
     * </pre>
     */
    public com.google.cloud.retail.v2beta.Model pauseModel(
        com.google.cloud.retail.v2beta.PauseModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPauseModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resumes the training of an existing model.
     * </pre>
     */
    public com.google.cloud.retail.v2beta.Model resumeModel(
        com.google.cloud.retail.v2beta.ResumeModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResumeModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing model.
     * </pre>
     */
    public com.google.protobuf.Empty deleteModel(
        com.google.cloud.retail.v2beta.DeleteModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the models linked to this event store.
     * </pre>
     */
    public com.google.cloud.retail.v2beta.ListModelsResponse listModels(
        com.google.cloud.retail.v2beta.ListModelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListModelsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update of model metadata. Only fields that
     * currently can be updated are: `filtering_option` and
     * `periodic_tuning_state`.
     * If other values are provided, this API method ignores them.
     * </pre>
     */
    public com.google.cloud.retail.v2beta.Model updateModel(
        com.google.cloud.retail.v2beta.UpdateModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Tunes an existing model.
     * </pre>
     */
    public com.google.longrunning.Operation tuneModel(
        com.google.cloud.retail.v2beta.TuneModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTuneModelMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for performing CRUD operations on models.
   * Recommendation models contain all the metadata necessary to generate a set of
   * models for the `Predict()` API. A model is queried
   * indirectly via a ServingConfig, which associates a model with a
   * given Placement (e.g. Frequently Bought Together on Home Page).
   * This service allows you to do the following:
   * * Initiate training of a model.
   * * Pause training of an existing model.
   * * List all the available models along with their metadata.
   * * Control their tuning schedule.
   * </pre>
   */
  public static final class ModelServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ModelServiceFutureStub> {
    private ModelServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModelServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModelServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createModel(com.google.cloud.retail.v2beta.CreateModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Pauses the training of an existing model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.retail.v2beta.Model>
        pauseModel(com.google.cloud.retail.v2beta.PauseModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPauseModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Resumes the training of an existing model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.retail.v2beta.Model>
        resumeModel(com.google.cloud.retail.v2beta.ResumeModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResumeModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteModel(com.google.cloud.retail.v2beta.DeleteModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the models linked to this event store.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2beta.ListModelsResponse>
        listModels(com.google.cloud.retail.v2beta.ListModelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListModelsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update of model metadata. Only fields that
     * currently can be updated are: `filtering_option` and
     * `periodic_tuning_state`.
     * If other values are provided, this API method ignores them.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.retail.v2beta.Model>
        updateModel(com.google.cloud.retail.v2beta.UpdateModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Tunes an existing model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        tuneModel(com.google.cloud.retail.v2beta.TuneModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTuneModelMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_MODEL = 0;
  private static final int METHODID_PAUSE_MODEL = 1;
  private static final int METHODID_RESUME_MODEL = 2;
  private static final int METHODID_DELETE_MODEL = 3;
  private static final int METHODID_LIST_MODELS = 4;
  private static final int METHODID_UPDATE_MODEL = 5;
  private static final int METHODID_TUNE_MODEL = 6;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ModelServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ModelServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_MODEL:
          serviceImpl.createModel(
              (com.google.cloud.retail.v2beta.CreateModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PAUSE_MODEL:
          serviceImpl.pauseModel(
              (com.google.cloud.retail.v2beta.PauseModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.Model>) responseObserver);
          break;
        case METHODID_RESUME_MODEL:
          serviceImpl.resumeModel(
              (com.google.cloud.retail.v2beta.ResumeModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.Model>) responseObserver);
          break;
        case METHODID_DELETE_MODEL:
          serviceImpl.deleteModel(
              (com.google.cloud.retail.v2beta.DeleteModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_MODELS:
          serviceImpl.listModels(
              (com.google.cloud.retail.v2beta.ListModelsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.ListModelsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_MODEL:
          serviceImpl.updateModel(
              (com.google.cloud.retail.v2beta.UpdateModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.Model>) responseObserver);
          break;
        case METHODID_TUNE_MODEL:
          serviceImpl.tuneModel(
              (com.google.cloud.retail.v2beta.TuneModelRequest) request,
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

  private abstract static class ModelServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ModelServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.retail.v2beta.ModelServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ModelService");
    }
  }

  private static final class ModelServiceFileDescriptorSupplier
      extends ModelServiceBaseDescriptorSupplier {
    ModelServiceFileDescriptorSupplier() {}
  }

  private static final class ModelServiceMethodDescriptorSupplier
      extends ModelServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ModelServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ModelServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ModelServiceFileDescriptorSupplier())
                      .addMethod(getCreateModelMethod())
                      .addMethod(getPauseModelMethod())
                      .addMethod(getResumeModelMethod())
                      .addMethod(getDeleteModelMethod())
                      .addMethod(getListModelsMethod())
                      .addMethod(getUpdateModelMethod())
                      .addMethod(getTuneModelMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
