package com.google.cloud.dialogflow.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Manages a collection of models for human agent assistant.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/v2/conversation_model.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ConversationModelsGrpc {

  private ConversationModelsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.v2.ConversationModels";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.CreateConversationModelRequest,
      com.google.longrunning.Operation> getCreateConversationModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateConversationModel",
      requestType = com.google.cloud.dialogflow.v2.CreateConversationModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.CreateConversationModelRequest,
      com.google.longrunning.Operation> getCreateConversationModelMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.CreateConversationModelRequest, com.google.longrunning.Operation> getCreateConversationModelMethod;
    if ((getCreateConversationModelMethod = ConversationModelsGrpc.getCreateConversationModelMethod) == null) {
      synchronized (ConversationModelsGrpc.class) {
        if ((getCreateConversationModelMethod = ConversationModelsGrpc.getCreateConversationModelMethod) == null) {
          ConversationModelsGrpc.getCreateConversationModelMethod = getCreateConversationModelMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.v2.CreateConversationModelRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateConversationModel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.CreateConversationModelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ConversationModelsMethodDescriptorSupplier("CreateConversationModel"))
              .build();
        }
      }
    }
    return getCreateConversationModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.GetConversationModelRequest,
      com.google.cloud.dialogflow.v2.ConversationModel> getGetConversationModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConversationModel",
      requestType = com.google.cloud.dialogflow.v2.GetConversationModelRequest.class,
      responseType = com.google.cloud.dialogflow.v2.ConversationModel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.GetConversationModelRequest,
      com.google.cloud.dialogflow.v2.ConversationModel> getGetConversationModelMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.GetConversationModelRequest, com.google.cloud.dialogflow.v2.ConversationModel> getGetConversationModelMethod;
    if ((getGetConversationModelMethod = ConversationModelsGrpc.getGetConversationModelMethod) == null) {
      synchronized (ConversationModelsGrpc.class) {
        if ((getGetConversationModelMethod = ConversationModelsGrpc.getGetConversationModelMethod) == null) {
          ConversationModelsGrpc.getGetConversationModelMethod = getGetConversationModelMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.v2.GetConversationModelRequest, com.google.cloud.dialogflow.v2.ConversationModel>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConversationModel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.GetConversationModelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.ConversationModel.getDefaultInstance()))
              .setSchemaDescriptor(new ConversationModelsMethodDescriptorSupplier("GetConversationModel"))
              .build();
        }
      }
    }
    return getGetConversationModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.ListConversationModelsRequest,
      com.google.cloud.dialogflow.v2.ListConversationModelsResponse> getListConversationModelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConversationModels",
      requestType = com.google.cloud.dialogflow.v2.ListConversationModelsRequest.class,
      responseType = com.google.cloud.dialogflow.v2.ListConversationModelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.ListConversationModelsRequest,
      com.google.cloud.dialogflow.v2.ListConversationModelsResponse> getListConversationModelsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.ListConversationModelsRequest, com.google.cloud.dialogflow.v2.ListConversationModelsResponse> getListConversationModelsMethod;
    if ((getListConversationModelsMethod = ConversationModelsGrpc.getListConversationModelsMethod) == null) {
      synchronized (ConversationModelsGrpc.class) {
        if ((getListConversationModelsMethod = ConversationModelsGrpc.getListConversationModelsMethod) == null) {
          ConversationModelsGrpc.getListConversationModelsMethod = getListConversationModelsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.v2.ListConversationModelsRequest, com.google.cloud.dialogflow.v2.ListConversationModelsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListConversationModels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.ListConversationModelsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.ListConversationModelsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ConversationModelsMethodDescriptorSupplier("ListConversationModels"))
              .build();
        }
      }
    }
    return getListConversationModelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.DeleteConversationModelRequest,
      com.google.longrunning.Operation> getDeleteConversationModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteConversationModel",
      requestType = com.google.cloud.dialogflow.v2.DeleteConversationModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.DeleteConversationModelRequest,
      com.google.longrunning.Operation> getDeleteConversationModelMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.DeleteConversationModelRequest, com.google.longrunning.Operation> getDeleteConversationModelMethod;
    if ((getDeleteConversationModelMethod = ConversationModelsGrpc.getDeleteConversationModelMethod) == null) {
      synchronized (ConversationModelsGrpc.class) {
        if ((getDeleteConversationModelMethod = ConversationModelsGrpc.getDeleteConversationModelMethod) == null) {
          ConversationModelsGrpc.getDeleteConversationModelMethod = getDeleteConversationModelMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.v2.DeleteConversationModelRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteConversationModel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.DeleteConversationModelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ConversationModelsMethodDescriptorSupplier("DeleteConversationModel"))
              .build();
        }
      }
    }
    return getDeleteConversationModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.DeployConversationModelRequest,
      com.google.longrunning.Operation> getDeployConversationModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeployConversationModel",
      requestType = com.google.cloud.dialogflow.v2.DeployConversationModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.DeployConversationModelRequest,
      com.google.longrunning.Operation> getDeployConversationModelMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.DeployConversationModelRequest, com.google.longrunning.Operation> getDeployConversationModelMethod;
    if ((getDeployConversationModelMethod = ConversationModelsGrpc.getDeployConversationModelMethod) == null) {
      synchronized (ConversationModelsGrpc.class) {
        if ((getDeployConversationModelMethod = ConversationModelsGrpc.getDeployConversationModelMethod) == null) {
          ConversationModelsGrpc.getDeployConversationModelMethod = getDeployConversationModelMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.v2.DeployConversationModelRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeployConversationModel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.DeployConversationModelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ConversationModelsMethodDescriptorSupplier("DeployConversationModel"))
              .build();
        }
      }
    }
    return getDeployConversationModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.UndeployConversationModelRequest,
      com.google.longrunning.Operation> getUndeployConversationModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeployConversationModel",
      requestType = com.google.cloud.dialogflow.v2.UndeployConversationModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.UndeployConversationModelRequest,
      com.google.longrunning.Operation> getUndeployConversationModelMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.UndeployConversationModelRequest, com.google.longrunning.Operation> getUndeployConversationModelMethod;
    if ((getUndeployConversationModelMethod = ConversationModelsGrpc.getUndeployConversationModelMethod) == null) {
      synchronized (ConversationModelsGrpc.class) {
        if ((getUndeployConversationModelMethod = ConversationModelsGrpc.getUndeployConversationModelMethod) == null) {
          ConversationModelsGrpc.getUndeployConversationModelMethod = getUndeployConversationModelMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.v2.UndeployConversationModelRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UndeployConversationModel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.UndeployConversationModelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ConversationModelsMethodDescriptorSupplier("UndeployConversationModel"))
              .build();
        }
      }
    }
    return getUndeployConversationModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.GetConversationModelEvaluationRequest,
      com.google.cloud.dialogflow.v2.ConversationModelEvaluation> getGetConversationModelEvaluationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConversationModelEvaluation",
      requestType = com.google.cloud.dialogflow.v2.GetConversationModelEvaluationRequest.class,
      responseType = com.google.cloud.dialogflow.v2.ConversationModelEvaluation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.GetConversationModelEvaluationRequest,
      com.google.cloud.dialogflow.v2.ConversationModelEvaluation> getGetConversationModelEvaluationMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.GetConversationModelEvaluationRequest, com.google.cloud.dialogflow.v2.ConversationModelEvaluation> getGetConversationModelEvaluationMethod;
    if ((getGetConversationModelEvaluationMethod = ConversationModelsGrpc.getGetConversationModelEvaluationMethod) == null) {
      synchronized (ConversationModelsGrpc.class) {
        if ((getGetConversationModelEvaluationMethod = ConversationModelsGrpc.getGetConversationModelEvaluationMethod) == null) {
          ConversationModelsGrpc.getGetConversationModelEvaluationMethod = getGetConversationModelEvaluationMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.v2.GetConversationModelEvaluationRequest, com.google.cloud.dialogflow.v2.ConversationModelEvaluation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConversationModelEvaluation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.GetConversationModelEvaluationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.ConversationModelEvaluation.getDefaultInstance()))
              .setSchemaDescriptor(new ConversationModelsMethodDescriptorSupplier("GetConversationModelEvaluation"))
              .build();
        }
      }
    }
    return getGetConversationModelEvaluationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsRequest,
      com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsResponse> getListConversationModelEvaluationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConversationModelEvaluations",
      requestType = com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsRequest.class,
      responseType = com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsRequest,
      com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsResponse> getListConversationModelEvaluationsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsRequest, com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsResponse> getListConversationModelEvaluationsMethod;
    if ((getListConversationModelEvaluationsMethod = ConversationModelsGrpc.getListConversationModelEvaluationsMethod) == null) {
      synchronized (ConversationModelsGrpc.class) {
        if ((getListConversationModelEvaluationsMethod = ConversationModelsGrpc.getListConversationModelEvaluationsMethod) == null) {
          ConversationModelsGrpc.getListConversationModelEvaluationsMethod = getListConversationModelEvaluationsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsRequest, com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListConversationModelEvaluations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ConversationModelsMethodDescriptorSupplier("ListConversationModelEvaluations"))
              .build();
        }
      }
    }
    return getListConversationModelEvaluationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.CreateConversationModelEvaluationRequest,
      com.google.longrunning.Operation> getCreateConversationModelEvaluationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateConversationModelEvaluation",
      requestType = com.google.cloud.dialogflow.v2.CreateConversationModelEvaluationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.CreateConversationModelEvaluationRequest,
      com.google.longrunning.Operation> getCreateConversationModelEvaluationMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.CreateConversationModelEvaluationRequest, com.google.longrunning.Operation> getCreateConversationModelEvaluationMethod;
    if ((getCreateConversationModelEvaluationMethod = ConversationModelsGrpc.getCreateConversationModelEvaluationMethod) == null) {
      synchronized (ConversationModelsGrpc.class) {
        if ((getCreateConversationModelEvaluationMethod = ConversationModelsGrpc.getCreateConversationModelEvaluationMethod) == null) {
          ConversationModelsGrpc.getCreateConversationModelEvaluationMethod = getCreateConversationModelEvaluationMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.v2.CreateConversationModelEvaluationRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateConversationModelEvaluation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.CreateConversationModelEvaluationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ConversationModelsMethodDescriptorSupplier("CreateConversationModelEvaluation"))
              .build();
        }
      }
    }
    return getCreateConversationModelEvaluationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ConversationModelsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversationModelsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConversationModelsStub>() {
        @java.lang.Override
        public ConversationModelsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConversationModelsStub(channel, callOptions);
        }
      };
    return ConversationModelsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConversationModelsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversationModelsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConversationModelsBlockingStub>() {
        @java.lang.Override
        public ConversationModelsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConversationModelsBlockingStub(channel, callOptions);
        }
      };
    return ConversationModelsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ConversationModelsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversationModelsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConversationModelsFutureStub>() {
        @java.lang.Override
        public ConversationModelsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConversationModelsFutureStub(channel, callOptions);
        }
      };
    return ConversationModelsFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Manages a collection of models for human agent assistant.
   * </pre>
   */
  public static abstract class ConversationModelsImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Creates a model.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [CreateConversationModelOperationMetadata][google.cloud.dialogflow.v2.CreateConversationModelOperationMetadata]
     * - `response`: [ConversationModel][google.cloud.dialogflow.v2.ConversationModel]
     * </pre>
     */
    public void createConversationModel(com.google.cloud.dialogflow.v2.CreateConversationModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateConversationModelMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets conversation model.
     * </pre>
     */
    public void getConversationModel(com.google.cloud.dialogflow.v2.GetConversationModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ConversationModel> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetConversationModelMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists conversation models.
     * </pre>
     */
    public void listConversationModels(com.google.cloud.dialogflow.v2.ListConversationModelsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListConversationModelsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListConversationModelsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a model.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [DeleteConversationModelOperationMetadata][google.cloud.dialogflow.v2.DeleteConversationModelOperationMetadata]
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * </pre>
     */
    public void deleteConversationModel(com.google.cloud.dialogflow.v2.DeleteConversationModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteConversationModelMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deploys a model. If a model is already deployed, deploying it
     * has no effect. A model can only serve prediction requests after it gets
     * deployed. For article suggestion, custom model will not be used unless
     * it is deployed.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [DeployConversationModelOperationMetadata][google.cloud.dialogflow.v2.DeployConversationModelOperationMetadata]
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * </pre>
     */
    public void deployConversationModel(com.google.cloud.dialogflow.v2.DeployConversationModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeployConversationModelMethod(), responseObserver);
    }

    /**
     * <pre>
     * Undeploys a model. If the model is not deployed this method has no effect.
     * If the model is currently being used:
     *   - For article suggestion, article suggestion will fallback to the default
     *     model if model is undeployed.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [UndeployConversationModelOperationMetadata][google.cloud.dialogflow.v2.UndeployConversationModelOperationMetadata]
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * </pre>
     */
    public void undeployConversationModel(com.google.cloud.dialogflow.v2.UndeployConversationModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUndeployConversationModelMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets an evaluation of conversation model.
     * </pre>
     */
    public void getConversationModelEvaluation(com.google.cloud.dialogflow.v2.GetConversationModelEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ConversationModelEvaluation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetConversationModelEvaluationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists evaluations of a conversation model.
     * </pre>
     */
    public void listConversationModelEvaluations(com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListConversationModelEvaluationsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates evaluation of a conversation model.
     * </pre>
     */
    public void createConversationModelEvaluation(com.google.cloud.dialogflow.v2.CreateConversationModelEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateConversationModelEvaluationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateConversationModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.v2.CreateConversationModelRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_CONVERSATION_MODEL)))
          .addMethod(
            getGetConversationModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.v2.GetConversationModelRequest,
                com.google.cloud.dialogflow.v2.ConversationModel>(
                  this, METHODID_GET_CONVERSATION_MODEL)))
          .addMethod(
            getListConversationModelsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.v2.ListConversationModelsRequest,
                com.google.cloud.dialogflow.v2.ListConversationModelsResponse>(
                  this, METHODID_LIST_CONVERSATION_MODELS)))
          .addMethod(
            getDeleteConversationModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.v2.DeleteConversationModelRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_CONVERSATION_MODEL)))
          .addMethod(
            getDeployConversationModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.v2.DeployConversationModelRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DEPLOY_CONVERSATION_MODEL)))
          .addMethod(
            getUndeployConversationModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.v2.UndeployConversationModelRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UNDEPLOY_CONVERSATION_MODEL)))
          .addMethod(
            getGetConversationModelEvaluationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.v2.GetConversationModelEvaluationRequest,
                com.google.cloud.dialogflow.v2.ConversationModelEvaluation>(
                  this, METHODID_GET_CONVERSATION_MODEL_EVALUATION)))
          .addMethod(
            getListConversationModelEvaluationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsRequest,
                com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsResponse>(
                  this, METHODID_LIST_CONVERSATION_MODEL_EVALUATIONS)))
          .addMethod(
            getCreateConversationModelEvaluationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.v2.CreateConversationModelEvaluationRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_CONVERSATION_MODEL_EVALUATION)))
          .build();
    }
  }

  /**
   * <pre>
   * Manages a collection of models for human agent assistant.
   * </pre>
   */
  public static final class ConversationModelsStub extends io.grpc.stub.AbstractAsyncStub<ConversationModelsStub> {
    private ConversationModelsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversationModelsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversationModelsStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a model.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [CreateConversationModelOperationMetadata][google.cloud.dialogflow.v2.CreateConversationModelOperationMetadata]
     * - `response`: [ConversationModel][google.cloud.dialogflow.v2.ConversationModel]
     * </pre>
     */
    public void createConversationModel(com.google.cloud.dialogflow.v2.CreateConversationModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateConversationModelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets conversation model.
     * </pre>
     */
    public void getConversationModel(com.google.cloud.dialogflow.v2.GetConversationModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ConversationModel> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConversationModelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists conversation models.
     * </pre>
     */
    public void listConversationModels(com.google.cloud.dialogflow.v2.ListConversationModelsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListConversationModelsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConversationModelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a model.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [DeleteConversationModelOperationMetadata][google.cloud.dialogflow.v2.DeleteConversationModelOperationMetadata]
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * </pre>
     */
    public void deleteConversationModel(com.google.cloud.dialogflow.v2.DeleteConversationModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteConversationModelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deploys a model. If a model is already deployed, deploying it
     * has no effect. A model can only serve prediction requests after it gets
     * deployed. For article suggestion, custom model will not be used unless
     * it is deployed.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [DeployConversationModelOperationMetadata][google.cloud.dialogflow.v2.DeployConversationModelOperationMetadata]
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * </pre>
     */
    public void deployConversationModel(com.google.cloud.dialogflow.v2.DeployConversationModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeployConversationModelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Undeploys a model. If the model is not deployed this method has no effect.
     * If the model is currently being used:
     *   - For article suggestion, article suggestion will fallback to the default
     *     model if model is undeployed.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [UndeployConversationModelOperationMetadata][google.cloud.dialogflow.v2.UndeployConversationModelOperationMetadata]
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * </pre>
     */
    public void undeployConversationModel(com.google.cloud.dialogflow.v2.UndeployConversationModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeployConversationModelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets an evaluation of conversation model.
     * </pre>
     */
    public void getConversationModelEvaluation(com.google.cloud.dialogflow.v2.GetConversationModelEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ConversationModelEvaluation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConversationModelEvaluationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists evaluations of a conversation model.
     * </pre>
     */
    public void listConversationModelEvaluations(com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConversationModelEvaluationsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates evaluation of a conversation model.
     * </pre>
     */
    public void createConversationModelEvaluation(com.google.cloud.dialogflow.v2.CreateConversationModelEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateConversationModelEvaluationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Manages a collection of models for human agent assistant.
   * </pre>
   */
  public static final class ConversationModelsBlockingStub extends io.grpc.stub.AbstractBlockingStub<ConversationModelsBlockingStub> {
    private ConversationModelsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversationModelsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversationModelsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a model.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [CreateConversationModelOperationMetadata][google.cloud.dialogflow.v2.CreateConversationModelOperationMetadata]
     * - `response`: [ConversationModel][google.cloud.dialogflow.v2.ConversationModel]
     * </pre>
     */
    public com.google.longrunning.Operation createConversationModel(com.google.cloud.dialogflow.v2.CreateConversationModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConversationModelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets conversation model.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.ConversationModel getConversationModel(com.google.cloud.dialogflow.v2.GetConversationModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConversationModelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists conversation models.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.ListConversationModelsResponse listConversationModels(com.google.cloud.dialogflow.v2.ListConversationModelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConversationModelsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a model.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [DeleteConversationModelOperationMetadata][google.cloud.dialogflow.v2.DeleteConversationModelOperationMetadata]
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * </pre>
     */
    public com.google.longrunning.Operation deleteConversationModel(com.google.cloud.dialogflow.v2.DeleteConversationModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConversationModelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deploys a model. If a model is already deployed, deploying it
     * has no effect. A model can only serve prediction requests after it gets
     * deployed. For article suggestion, custom model will not be used unless
     * it is deployed.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [DeployConversationModelOperationMetadata][google.cloud.dialogflow.v2.DeployConversationModelOperationMetadata]
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * </pre>
     */
    public com.google.longrunning.Operation deployConversationModel(com.google.cloud.dialogflow.v2.DeployConversationModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeployConversationModelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Undeploys a model. If the model is not deployed this method has no effect.
     * If the model is currently being used:
     *   - For article suggestion, article suggestion will fallback to the default
     *     model if model is undeployed.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [UndeployConversationModelOperationMetadata][google.cloud.dialogflow.v2.UndeployConversationModelOperationMetadata]
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * </pre>
     */
    public com.google.longrunning.Operation undeployConversationModel(com.google.cloud.dialogflow.v2.UndeployConversationModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeployConversationModelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets an evaluation of conversation model.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.ConversationModelEvaluation getConversationModelEvaluation(com.google.cloud.dialogflow.v2.GetConversationModelEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConversationModelEvaluationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists evaluations of a conversation model.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsResponse listConversationModelEvaluations(com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConversationModelEvaluationsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates evaluation of a conversation model.
     * </pre>
     */
    public com.google.longrunning.Operation createConversationModelEvaluation(com.google.cloud.dialogflow.v2.CreateConversationModelEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConversationModelEvaluationMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Manages a collection of models for human agent assistant.
   * </pre>
   */
  public static final class ConversationModelsFutureStub extends io.grpc.stub.AbstractFutureStub<ConversationModelsFutureStub> {
    private ConversationModelsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversationModelsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversationModelsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a model.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [CreateConversationModelOperationMetadata][google.cloud.dialogflow.v2.CreateConversationModelOperationMetadata]
     * - `response`: [ConversationModel][google.cloud.dialogflow.v2.ConversationModel]
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createConversationModel(
        com.google.cloud.dialogflow.v2.CreateConversationModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateConversationModelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets conversation model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.v2.ConversationModel> getConversationModel(
        com.google.cloud.dialogflow.v2.GetConversationModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConversationModelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists conversation models.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.v2.ListConversationModelsResponse> listConversationModels(
        com.google.cloud.dialogflow.v2.ListConversationModelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConversationModelsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a model.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [DeleteConversationModelOperationMetadata][google.cloud.dialogflow.v2.DeleteConversationModelOperationMetadata]
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteConversationModel(
        com.google.cloud.dialogflow.v2.DeleteConversationModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteConversationModelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deploys a model. If a model is already deployed, deploying it
     * has no effect. A model can only serve prediction requests after it gets
     * deployed. For article suggestion, custom model will not be used unless
     * it is deployed.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [DeployConversationModelOperationMetadata][google.cloud.dialogflow.v2.DeployConversationModelOperationMetadata]
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deployConversationModel(
        com.google.cloud.dialogflow.v2.DeployConversationModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeployConversationModelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Undeploys a model. If the model is not deployed this method has no effect.
     * If the model is currently being used:
     *   - For article suggestion, article suggestion will fallback to the default
     *     model if model is undeployed.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [UndeployConversationModelOperationMetadata][google.cloud.dialogflow.v2.UndeployConversationModelOperationMetadata]
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> undeployConversationModel(
        com.google.cloud.dialogflow.v2.UndeployConversationModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeployConversationModelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets an evaluation of conversation model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.v2.ConversationModelEvaluation> getConversationModelEvaluation(
        com.google.cloud.dialogflow.v2.GetConversationModelEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConversationModelEvaluationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists evaluations of a conversation model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsResponse> listConversationModelEvaluations(
        com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConversationModelEvaluationsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates evaluation of a conversation model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createConversationModelEvaluation(
        com.google.cloud.dialogflow.v2.CreateConversationModelEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateConversationModelEvaluationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CONVERSATION_MODEL = 0;
  private static final int METHODID_GET_CONVERSATION_MODEL = 1;
  private static final int METHODID_LIST_CONVERSATION_MODELS = 2;
  private static final int METHODID_DELETE_CONVERSATION_MODEL = 3;
  private static final int METHODID_DEPLOY_CONVERSATION_MODEL = 4;
  private static final int METHODID_UNDEPLOY_CONVERSATION_MODEL = 5;
  private static final int METHODID_GET_CONVERSATION_MODEL_EVALUATION = 6;
  private static final int METHODID_LIST_CONVERSATION_MODEL_EVALUATIONS = 7;
  private static final int METHODID_CREATE_CONVERSATION_MODEL_EVALUATION = 8;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ConversationModelsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ConversationModelsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_CONVERSATION_MODEL:
          serviceImpl.createConversationModel((com.google.cloud.dialogflow.v2.CreateConversationModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_CONVERSATION_MODEL:
          serviceImpl.getConversationModel((com.google.cloud.dialogflow.v2.GetConversationModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ConversationModel>) responseObserver);
          break;
        case METHODID_LIST_CONVERSATION_MODELS:
          serviceImpl.listConversationModels((com.google.cloud.dialogflow.v2.ListConversationModelsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListConversationModelsResponse>) responseObserver);
          break;
        case METHODID_DELETE_CONVERSATION_MODEL:
          serviceImpl.deleteConversationModel((com.google.cloud.dialogflow.v2.DeleteConversationModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DEPLOY_CONVERSATION_MODEL:
          serviceImpl.deployConversationModel((com.google.cloud.dialogflow.v2.DeployConversationModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UNDEPLOY_CONVERSATION_MODEL:
          serviceImpl.undeployConversationModel((com.google.cloud.dialogflow.v2.UndeployConversationModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_CONVERSATION_MODEL_EVALUATION:
          serviceImpl.getConversationModelEvaluation((com.google.cloud.dialogflow.v2.GetConversationModelEvaluationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ConversationModelEvaluation>) responseObserver);
          break;
        case METHODID_LIST_CONVERSATION_MODEL_EVALUATIONS:
          serviceImpl.listConversationModelEvaluations((com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsResponse>) responseObserver);
          break;
        case METHODID_CREATE_CONVERSATION_MODEL_EVALUATION:
          serviceImpl.createConversationModelEvaluation((com.google.cloud.dialogflow.v2.CreateConversationModelEvaluationRequest) request,
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

  private static abstract class ConversationModelsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConversationModelsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.v2.ConversationModelProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ConversationModels");
    }
  }

  private static final class ConversationModelsFileDescriptorSupplier
      extends ConversationModelsBaseDescriptorSupplier {
    ConversationModelsFileDescriptorSupplier() {}
  }

  private static final class ConversationModelsMethodDescriptorSupplier
      extends ConversationModelsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ConversationModelsMethodDescriptorSupplier(String methodName) {
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
      synchronized (ConversationModelsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ConversationModelsFileDescriptorSupplier())
              .addMethod(getCreateConversationModelMethod())
              .addMethod(getGetConversationModelMethod())
              .addMethod(getListConversationModelsMethod())
              .addMethod(getDeleteConversationModelMethod())
              .addMethod(getDeployConversationModelMethod())
              .addMethod(getUndeployConversationModelMethod())
              .addMethod(getGetConversationModelEvaluationMethod())
              .addMethod(getListConversationModelEvaluationsMethod())
              .addMethod(getCreateConversationModelEvaluationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
