package com.google.cloud.dialogflow.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service for managing [Agents][google.cloud.dialogflow.v2.Agent].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/v2/agent.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AgentsGrpc {

  private AgentsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.v2.Agents";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.GetAgentRequest,
      com.google.cloud.dialogflow.v2.Agent> getGetAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAgent",
      requestType = com.google.cloud.dialogflow.v2.GetAgentRequest.class,
      responseType = com.google.cloud.dialogflow.v2.Agent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.GetAgentRequest,
      com.google.cloud.dialogflow.v2.Agent> getGetAgentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.GetAgentRequest, com.google.cloud.dialogflow.v2.Agent> getGetAgentMethod;
    if ((getGetAgentMethod = AgentsGrpc.getGetAgentMethod) == null) {
      synchronized (AgentsGrpc.class) {
        if ((getGetAgentMethod = AgentsGrpc.getGetAgentMethod) == null) {
          AgentsGrpc.getGetAgentMethod = getGetAgentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.v2.GetAgentRequest, com.google.cloud.dialogflow.v2.Agent>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAgent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.GetAgentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.Agent.getDefaultInstance()))
              .setSchemaDescriptor(new AgentsMethodDescriptorSupplier("GetAgent"))
              .build();
        }
      }
    }
    return getGetAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.SetAgentRequest,
      com.google.cloud.dialogflow.v2.Agent> getSetAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetAgent",
      requestType = com.google.cloud.dialogflow.v2.SetAgentRequest.class,
      responseType = com.google.cloud.dialogflow.v2.Agent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.SetAgentRequest,
      com.google.cloud.dialogflow.v2.Agent> getSetAgentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.SetAgentRequest, com.google.cloud.dialogflow.v2.Agent> getSetAgentMethod;
    if ((getSetAgentMethod = AgentsGrpc.getSetAgentMethod) == null) {
      synchronized (AgentsGrpc.class) {
        if ((getSetAgentMethod = AgentsGrpc.getSetAgentMethod) == null) {
          AgentsGrpc.getSetAgentMethod = getSetAgentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.v2.SetAgentRequest, com.google.cloud.dialogflow.v2.Agent>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetAgent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.SetAgentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.Agent.getDefaultInstance()))
              .setSchemaDescriptor(new AgentsMethodDescriptorSupplier("SetAgent"))
              .build();
        }
      }
    }
    return getSetAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.DeleteAgentRequest,
      com.google.protobuf.Empty> getDeleteAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAgent",
      requestType = com.google.cloud.dialogflow.v2.DeleteAgentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.DeleteAgentRequest,
      com.google.protobuf.Empty> getDeleteAgentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.DeleteAgentRequest, com.google.protobuf.Empty> getDeleteAgentMethod;
    if ((getDeleteAgentMethod = AgentsGrpc.getDeleteAgentMethod) == null) {
      synchronized (AgentsGrpc.class) {
        if ((getDeleteAgentMethod = AgentsGrpc.getDeleteAgentMethod) == null) {
          AgentsGrpc.getDeleteAgentMethod = getDeleteAgentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.v2.DeleteAgentRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAgent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.DeleteAgentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new AgentsMethodDescriptorSupplier("DeleteAgent"))
              .build();
        }
      }
    }
    return getDeleteAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.SearchAgentsRequest,
      com.google.cloud.dialogflow.v2.SearchAgentsResponse> getSearchAgentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchAgents",
      requestType = com.google.cloud.dialogflow.v2.SearchAgentsRequest.class,
      responseType = com.google.cloud.dialogflow.v2.SearchAgentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.SearchAgentsRequest,
      com.google.cloud.dialogflow.v2.SearchAgentsResponse> getSearchAgentsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.SearchAgentsRequest, com.google.cloud.dialogflow.v2.SearchAgentsResponse> getSearchAgentsMethod;
    if ((getSearchAgentsMethod = AgentsGrpc.getSearchAgentsMethod) == null) {
      synchronized (AgentsGrpc.class) {
        if ((getSearchAgentsMethod = AgentsGrpc.getSearchAgentsMethod) == null) {
          AgentsGrpc.getSearchAgentsMethod = getSearchAgentsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.v2.SearchAgentsRequest, com.google.cloud.dialogflow.v2.SearchAgentsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchAgents"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.SearchAgentsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.SearchAgentsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AgentsMethodDescriptorSupplier("SearchAgents"))
              .build();
        }
      }
    }
    return getSearchAgentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.TrainAgentRequest,
      com.google.longrunning.Operation> getTrainAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TrainAgent",
      requestType = com.google.cloud.dialogflow.v2.TrainAgentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.TrainAgentRequest,
      com.google.longrunning.Operation> getTrainAgentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.TrainAgentRequest, com.google.longrunning.Operation> getTrainAgentMethod;
    if ((getTrainAgentMethod = AgentsGrpc.getTrainAgentMethod) == null) {
      synchronized (AgentsGrpc.class) {
        if ((getTrainAgentMethod = AgentsGrpc.getTrainAgentMethod) == null) {
          AgentsGrpc.getTrainAgentMethod = getTrainAgentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.v2.TrainAgentRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TrainAgent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.TrainAgentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AgentsMethodDescriptorSupplier("TrainAgent"))
              .build();
        }
      }
    }
    return getTrainAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.ExportAgentRequest,
      com.google.longrunning.Operation> getExportAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportAgent",
      requestType = com.google.cloud.dialogflow.v2.ExportAgentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.ExportAgentRequest,
      com.google.longrunning.Operation> getExportAgentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.ExportAgentRequest, com.google.longrunning.Operation> getExportAgentMethod;
    if ((getExportAgentMethod = AgentsGrpc.getExportAgentMethod) == null) {
      synchronized (AgentsGrpc.class) {
        if ((getExportAgentMethod = AgentsGrpc.getExportAgentMethod) == null) {
          AgentsGrpc.getExportAgentMethod = getExportAgentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.v2.ExportAgentRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportAgent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.ExportAgentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AgentsMethodDescriptorSupplier("ExportAgent"))
              .build();
        }
      }
    }
    return getExportAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.ImportAgentRequest,
      com.google.longrunning.Operation> getImportAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportAgent",
      requestType = com.google.cloud.dialogflow.v2.ImportAgentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.ImportAgentRequest,
      com.google.longrunning.Operation> getImportAgentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.ImportAgentRequest, com.google.longrunning.Operation> getImportAgentMethod;
    if ((getImportAgentMethod = AgentsGrpc.getImportAgentMethod) == null) {
      synchronized (AgentsGrpc.class) {
        if ((getImportAgentMethod = AgentsGrpc.getImportAgentMethod) == null) {
          AgentsGrpc.getImportAgentMethod = getImportAgentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.v2.ImportAgentRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportAgent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.ImportAgentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AgentsMethodDescriptorSupplier("ImportAgent"))
              .build();
        }
      }
    }
    return getImportAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.RestoreAgentRequest,
      com.google.longrunning.Operation> getRestoreAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestoreAgent",
      requestType = com.google.cloud.dialogflow.v2.RestoreAgentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.RestoreAgentRequest,
      com.google.longrunning.Operation> getRestoreAgentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.RestoreAgentRequest, com.google.longrunning.Operation> getRestoreAgentMethod;
    if ((getRestoreAgentMethod = AgentsGrpc.getRestoreAgentMethod) == null) {
      synchronized (AgentsGrpc.class) {
        if ((getRestoreAgentMethod = AgentsGrpc.getRestoreAgentMethod) == null) {
          AgentsGrpc.getRestoreAgentMethod = getRestoreAgentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.v2.RestoreAgentRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RestoreAgent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.RestoreAgentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AgentsMethodDescriptorSupplier("RestoreAgent"))
              .build();
        }
      }
    }
    return getRestoreAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.GetValidationResultRequest,
      com.google.cloud.dialogflow.v2.ValidationResult> getGetValidationResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetValidationResult",
      requestType = com.google.cloud.dialogflow.v2.GetValidationResultRequest.class,
      responseType = com.google.cloud.dialogflow.v2.ValidationResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.GetValidationResultRequest,
      com.google.cloud.dialogflow.v2.ValidationResult> getGetValidationResultMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.GetValidationResultRequest, com.google.cloud.dialogflow.v2.ValidationResult> getGetValidationResultMethod;
    if ((getGetValidationResultMethod = AgentsGrpc.getGetValidationResultMethod) == null) {
      synchronized (AgentsGrpc.class) {
        if ((getGetValidationResultMethod = AgentsGrpc.getGetValidationResultMethod) == null) {
          AgentsGrpc.getGetValidationResultMethod = getGetValidationResultMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.v2.GetValidationResultRequest, com.google.cloud.dialogflow.v2.ValidationResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetValidationResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.GetValidationResultRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.ValidationResult.getDefaultInstance()))
              .setSchemaDescriptor(new AgentsMethodDescriptorSupplier("GetValidationResult"))
              .build();
        }
      }
    }
    return getGetValidationResultMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AgentsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgentsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AgentsStub>() {
        @java.lang.Override
        public AgentsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AgentsStub(channel, callOptions);
        }
      };
    return AgentsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AgentsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgentsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AgentsBlockingStub>() {
        @java.lang.Override
        public AgentsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AgentsBlockingStub(channel, callOptions);
        }
      };
    return AgentsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AgentsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgentsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AgentsFutureStub>() {
        @java.lang.Override
        public AgentsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AgentsFutureStub(channel, callOptions);
        }
      };
    return AgentsFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service for managing [Agents][google.cloud.dialogflow.v2.Agent].
   * </pre>
   */
  public static abstract class AgentsImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Retrieves the specified agent.
     * </pre>
     */
    public void getAgent(com.google.cloud.dialogflow.v2.GetAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Agent> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAgentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates/updates the specified agent.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void setAgent(com.google.cloud.dialogflow.v2.SetAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Agent> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetAgentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified agent.
     * </pre>
     */
    public void deleteAgent(com.google.cloud.dialogflow.v2.DeleteAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAgentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns the list of agents.
     * Since there is at most one conversational agent per project, this method is
     * useful primarily for listing all agents across projects the caller has
     * access to. One can achieve that with a wildcard project collection id "-".
     * Refer to [List
     * Sub-Collections](https://cloud.google.com/apis/design/design_patterns#list_sub-collections).
     * </pre>
     */
    public void searchAgents(com.google.cloud.dialogflow.v2.SearchAgentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.SearchAgentsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchAgentsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Trains the specified agent.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void trainAgent(com.google.cloud.dialogflow.v2.TrainAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTrainAgentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Exports the specified agent to a ZIP file.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: [ExportAgentResponse][google.cloud.dialogflow.v2.ExportAgentResponse]
     * </pre>
     */
    public void exportAgent(com.google.cloud.dialogflow.v2.ExportAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExportAgentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Imports the specified agent from a ZIP file.
     * Uploads new intents and entity types without deleting the existing ones.
     * Intents and entity types with the same name are replaced with the new
     * versions from [ImportAgentRequest][google.cloud.dialogflow.v2.ImportAgentRequest]. After the import, the imported draft
     * agent will be trained automatically (unless disabled in agent settings).
     * However, once the import is done, training may not be completed yet. Please
     * call [TrainAgent][google.cloud.dialogflow.v2.Agents.TrainAgent] and wait for the operation it returns in order to train
     * explicitly.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * The operation only tracks when importing is complete, not when it is done
     * training.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void importAgent(com.google.cloud.dialogflow.v2.ImportAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getImportAgentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Restores the specified agent from a ZIP file.
     * Replaces the current agent version with a new one. All the intents and
     * entity types in the older version are deleted. After the restore, the
     * restored draft agent will be trained automatically (unless disabled in
     * agent settings). However, once the restore is done, training may not be
     * completed yet. Please call [TrainAgent][google.cloud.dialogflow.v2.Agents.TrainAgent] and wait for the operation it
     * returns in order to train explicitly.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * The operation only tracks when restoring is complete, not when it is done
     * training.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void restoreAgent(com.google.cloud.dialogflow.v2.RestoreAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRestoreAgentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets agent validation result. Agent validation is performed during
     * training time and is updated automatically when training is completed.
     * </pre>
     */
    public void getValidationResult(com.google.cloud.dialogflow.v2.GetValidationResultRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ValidationResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetValidationResultMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAgentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.v2.GetAgentRequest,
                com.google.cloud.dialogflow.v2.Agent>(
                  this, METHODID_GET_AGENT)))
          .addMethod(
            getSetAgentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.v2.SetAgentRequest,
                com.google.cloud.dialogflow.v2.Agent>(
                  this, METHODID_SET_AGENT)))
          .addMethod(
            getDeleteAgentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.v2.DeleteAgentRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_AGENT)))
          .addMethod(
            getSearchAgentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.v2.SearchAgentsRequest,
                com.google.cloud.dialogflow.v2.SearchAgentsResponse>(
                  this, METHODID_SEARCH_AGENTS)))
          .addMethod(
            getTrainAgentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.v2.TrainAgentRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_TRAIN_AGENT)))
          .addMethod(
            getExportAgentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.v2.ExportAgentRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_EXPORT_AGENT)))
          .addMethod(
            getImportAgentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.v2.ImportAgentRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_IMPORT_AGENT)))
          .addMethod(
            getRestoreAgentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.v2.RestoreAgentRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_RESTORE_AGENT)))
          .addMethod(
            getGetValidationResultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.v2.GetValidationResultRequest,
                com.google.cloud.dialogflow.v2.ValidationResult>(
                  this, METHODID_GET_VALIDATION_RESULT)))
          .build();
    }
  }

  /**
   * <pre>
   * Service for managing [Agents][google.cloud.dialogflow.v2.Agent].
   * </pre>
   */
  public static final class AgentsStub extends io.grpc.stub.AbstractAsyncStub<AgentsStub> {
    private AgentsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgentsStub(channel, callOptions);
    }

    /**
     * <pre>
     * Retrieves the specified agent.
     * </pre>
     */
    public void getAgent(com.google.cloud.dialogflow.v2.GetAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Agent> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAgentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates/updates the specified agent.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void setAgent(com.google.cloud.dialogflow.v2.SetAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Agent> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetAgentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified agent.
     * </pre>
     */
    public void deleteAgent(com.google.cloud.dialogflow.v2.DeleteAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAgentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns the list of agents.
     * Since there is at most one conversational agent per project, this method is
     * useful primarily for listing all agents across projects the caller has
     * access to. One can achieve that with a wildcard project collection id "-".
     * Refer to [List
     * Sub-Collections](https://cloud.google.com/apis/design/design_patterns#list_sub-collections).
     * </pre>
     */
    public void searchAgents(com.google.cloud.dialogflow.v2.SearchAgentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.SearchAgentsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchAgentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Trains the specified agent.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void trainAgent(com.google.cloud.dialogflow.v2.TrainAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTrainAgentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Exports the specified agent to a ZIP file.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: [ExportAgentResponse][google.cloud.dialogflow.v2.ExportAgentResponse]
     * </pre>
     */
    public void exportAgent(com.google.cloud.dialogflow.v2.ExportAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportAgentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Imports the specified agent from a ZIP file.
     * Uploads new intents and entity types without deleting the existing ones.
     * Intents and entity types with the same name are replaced with the new
     * versions from [ImportAgentRequest][google.cloud.dialogflow.v2.ImportAgentRequest]. After the import, the imported draft
     * agent will be trained automatically (unless disabled in agent settings).
     * However, once the import is done, training may not be completed yet. Please
     * call [TrainAgent][google.cloud.dialogflow.v2.Agents.TrainAgent] and wait for the operation it returns in order to train
     * explicitly.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * The operation only tracks when importing is complete, not when it is done
     * training.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void importAgent(com.google.cloud.dialogflow.v2.ImportAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportAgentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Restores the specified agent from a ZIP file.
     * Replaces the current agent version with a new one. All the intents and
     * entity types in the older version are deleted. After the restore, the
     * restored draft agent will be trained automatically (unless disabled in
     * agent settings). However, once the restore is done, training may not be
     * completed yet. Please call [TrainAgent][google.cloud.dialogflow.v2.Agents.TrainAgent] and wait for the operation it
     * returns in order to train explicitly.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * The operation only tracks when restoring is complete, not when it is done
     * training.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void restoreAgent(com.google.cloud.dialogflow.v2.RestoreAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestoreAgentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets agent validation result. Agent validation is performed during
     * training time and is updated automatically when training is completed.
     * </pre>
     */
    public void getValidationResult(com.google.cloud.dialogflow.v2.GetValidationResultRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ValidationResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetValidationResultMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service for managing [Agents][google.cloud.dialogflow.v2.Agent].
   * </pre>
   */
  public static final class AgentsBlockingStub extends io.grpc.stub.AbstractBlockingStub<AgentsBlockingStub> {
    private AgentsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgentsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Retrieves the specified agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.Agent getAgent(com.google.cloud.dialogflow.v2.GetAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAgentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates/updates the specified agent.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.Agent setAgent(com.google.cloud.dialogflow.v2.SetAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetAgentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the specified agent.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAgent(com.google.cloud.dialogflow.v2.DeleteAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAgentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns the list of agents.
     * Since there is at most one conversational agent per project, this method is
     * useful primarily for listing all agents across projects the caller has
     * access to. One can achieve that with a wildcard project collection id "-".
     * Refer to [List
     * Sub-Collections](https://cloud.google.com/apis/design/design_patterns#list_sub-collections).
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.SearchAgentsResponse searchAgents(com.google.cloud.dialogflow.v2.SearchAgentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchAgentsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Trains the specified agent.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.longrunning.Operation trainAgent(com.google.cloud.dialogflow.v2.TrainAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTrainAgentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Exports the specified agent to a ZIP file.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: [ExportAgentResponse][google.cloud.dialogflow.v2.ExportAgentResponse]
     * </pre>
     */
    public com.google.longrunning.Operation exportAgent(com.google.cloud.dialogflow.v2.ExportAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportAgentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Imports the specified agent from a ZIP file.
     * Uploads new intents and entity types without deleting the existing ones.
     * Intents and entity types with the same name are replaced with the new
     * versions from [ImportAgentRequest][google.cloud.dialogflow.v2.ImportAgentRequest]. After the import, the imported draft
     * agent will be trained automatically (unless disabled in agent settings).
     * However, once the import is done, training may not be completed yet. Please
     * call [TrainAgent][google.cloud.dialogflow.v2.Agents.TrainAgent] and wait for the operation it returns in order to train
     * explicitly.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * The operation only tracks when importing is complete, not when it is done
     * training.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.longrunning.Operation importAgent(com.google.cloud.dialogflow.v2.ImportAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportAgentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Restores the specified agent from a ZIP file.
     * Replaces the current agent version with a new one. All the intents and
     * entity types in the older version are deleted. After the restore, the
     * restored draft agent will be trained automatically (unless disabled in
     * agent settings). However, once the restore is done, training may not be
     * completed yet. Please call [TrainAgent][google.cloud.dialogflow.v2.Agents.TrainAgent] and wait for the operation it
     * returns in order to train explicitly.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * The operation only tracks when restoring is complete, not when it is done
     * training.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.longrunning.Operation restoreAgent(com.google.cloud.dialogflow.v2.RestoreAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestoreAgentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets agent validation result. Agent validation is performed during
     * training time and is updated automatically when training is completed.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.ValidationResult getValidationResult(com.google.cloud.dialogflow.v2.GetValidationResultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetValidationResultMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service for managing [Agents][google.cloud.dialogflow.v2.Agent].
   * </pre>
   */
  public static final class AgentsFutureStub extends io.grpc.stub.AbstractFutureStub<AgentsFutureStub> {
    private AgentsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgentsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Retrieves the specified agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.v2.Agent> getAgent(
        com.google.cloud.dialogflow.v2.GetAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAgentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates/updates the specified agent.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.v2.Agent> setAgent(
        com.google.cloud.dialogflow.v2.SetAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetAgentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the specified agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteAgent(
        com.google.cloud.dialogflow.v2.DeleteAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAgentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns the list of agents.
     * Since there is at most one conversational agent per project, this method is
     * useful primarily for listing all agents across projects the caller has
     * access to. One can achieve that with a wildcard project collection id "-".
     * Refer to [List
     * Sub-Collections](https://cloud.google.com/apis/design/design_patterns#list_sub-collections).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.v2.SearchAgentsResponse> searchAgents(
        com.google.cloud.dialogflow.v2.SearchAgentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchAgentsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Trains the specified agent.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> trainAgent(
        com.google.cloud.dialogflow.v2.TrainAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTrainAgentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Exports the specified agent to a ZIP file.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: [ExportAgentResponse][google.cloud.dialogflow.v2.ExportAgentResponse]
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> exportAgent(
        com.google.cloud.dialogflow.v2.ExportAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportAgentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Imports the specified agent from a ZIP file.
     * Uploads new intents and entity types without deleting the existing ones.
     * Intents and entity types with the same name are replaced with the new
     * versions from [ImportAgentRequest][google.cloud.dialogflow.v2.ImportAgentRequest]. After the import, the imported draft
     * agent will be trained automatically (unless disabled in agent settings).
     * However, once the import is done, training may not be completed yet. Please
     * call [TrainAgent][google.cloud.dialogflow.v2.Agents.TrainAgent] and wait for the operation it returns in order to train
     * explicitly.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * The operation only tracks when importing is complete, not when it is done
     * training.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> importAgent(
        com.google.cloud.dialogflow.v2.ImportAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportAgentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Restores the specified agent from a ZIP file.
     * Replaces the current agent version with a new one. All the intents and
     * entity types in the older version are deleted. After the restore, the
     * restored draft agent will be trained automatically (unless disabled in
     * agent settings). However, once the restore is done, training may not be
     * completed yet. Please call [TrainAgent][google.cloud.dialogflow.v2.Agents.TrainAgent] and wait for the operation it
     * returns in order to train explicitly.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * The operation only tracks when restoring is complete, not when it is done
     * training.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> restoreAgent(
        com.google.cloud.dialogflow.v2.RestoreAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestoreAgentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets agent validation result. Agent validation is performed during
     * training time and is updated automatically when training is completed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.v2.ValidationResult> getValidationResult(
        com.google.cloud.dialogflow.v2.GetValidationResultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetValidationResultMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_AGENT = 0;
  private static final int METHODID_SET_AGENT = 1;
  private static final int METHODID_DELETE_AGENT = 2;
  private static final int METHODID_SEARCH_AGENTS = 3;
  private static final int METHODID_TRAIN_AGENT = 4;
  private static final int METHODID_EXPORT_AGENT = 5;
  private static final int METHODID_IMPORT_AGENT = 6;
  private static final int METHODID_RESTORE_AGENT = 7;
  private static final int METHODID_GET_VALIDATION_RESULT = 8;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AgentsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AgentsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_AGENT:
          serviceImpl.getAgent((com.google.cloud.dialogflow.v2.GetAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Agent>) responseObserver);
          break;
        case METHODID_SET_AGENT:
          serviceImpl.setAgent((com.google.cloud.dialogflow.v2.SetAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Agent>) responseObserver);
          break;
        case METHODID_DELETE_AGENT:
          serviceImpl.deleteAgent((com.google.cloud.dialogflow.v2.DeleteAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SEARCH_AGENTS:
          serviceImpl.searchAgents((com.google.cloud.dialogflow.v2.SearchAgentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.SearchAgentsResponse>) responseObserver);
          break;
        case METHODID_TRAIN_AGENT:
          serviceImpl.trainAgent((com.google.cloud.dialogflow.v2.TrainAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_AGENT:
          serviceImpl.exportAgent((com.google.cloud.dialogflow.v2.ExportAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_AGENT:
          serviceImpl.importAgent((com.google.cloud.dialogflow.v2.ImportAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESTORE_AGENT:
          serviceImpl.restoreAgent((com.google.cloud.dialogflow.v2.RestoreAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_VALIDATION_RESULT:
          serviceImpl.getValidationResult((com.google.cloud.dialogflow.v2.GetValidationResultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ValidationResult>) responseObserver);
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

  private static abstract class AgentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AgentsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.v2.AgentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Agents");
    }
  }

  private static final class AgentsFileDescriptorSupplier
      extends AgentsBaseDescriptorSupplier {
    AgentsFileDescriptorSupplier() {}
  }

  private static final class AgentsMethodDescriptorSupplier
      extends AgentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AgentsMethodDescriptorSupplier(String methodName) {
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
      synchronized (AgentsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AgentsFileDescriptorSupplier())
              .addMethod(getGetAgentMethod())
              .addMethod(getSetAgentMethod())
              .addMethod(getDeleteAgentMethod())
              .addMethod(getSearchAgentsMethod())
              .addMethod(getTrainAgentMethod())
              .addMethod(getExportAgentMethod())
              .addMethod(getImportAgentMethod())
              .addMethod(getRestoreAgentMethod())
              .addMethod(getGetValidationResultMethod())
              .build();
        }
      }
    }
    return result;
  }
}
