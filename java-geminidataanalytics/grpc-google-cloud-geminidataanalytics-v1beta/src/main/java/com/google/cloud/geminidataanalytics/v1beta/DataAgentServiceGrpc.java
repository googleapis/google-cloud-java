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
package com.google.cloud.geminidataanalytics.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/geminidataanalytics/v1beta/data_agent_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataAgentServiceGrpc {

  private DataAgentServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.geminidataanalytics.v1beta.DataAgentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsRequest,
          com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsResponse>
      getListDataAgentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataAgents",
      requestType = com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsRequest.class,
      responseType = com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsRequest,
          com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsResponse>
      getListDataAgentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsRequest,
            com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsResponse>
        getListDataAgentsMethod;
    if ((getListDataAgentsMethod = DataAgentServiceGrpc.getListDataAgentsMethod) == null) {
      synchronized (DataAgentServiceGrpc.class) {
        if ((getListDataAgentsMethod = DataAgentServiceGrpc.getListDataAgentsMethod) == null) {
          DataAgentServiceGrpc.getListDataAgentsMethod =
              getListDataAgentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsRequest,
                          com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDataAgents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataAgentServiceMethodDescriptorSupplier("ListDataAgents"))
                      .build();
        }
      }
    }
    return getListDataAgentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsRequest,
          com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsResponse>
      getListAccessibleDataAgentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAccessibleDataAgents",
      requestType =
          com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsRequest.class,
      responseType =
          com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsRequest,
          com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsResponse>
      getListAccessibleDataAgentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsRequest,
            com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsResponse>
        getListAccessibleDataAgentsMethod;
    if ((getListAccessibleDataAgentsMethod = DataAgentServiceGrpc.getListAccessibleDataAgentsMethod)
        == null) {
      synchronized (DataAgentServiceGrpc.class) {
        if ((getListAccessibleDataAgentsMethod =
                DataAgentServiceGrpc.getListAccessibleDataAgentsMethod)
            == null) {
          DataAgentServiceGrpc.getListAccessibleDataAgentsMethod =
              getListAccessibleDataAgentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsRequest,
                          com.google.cloud.geminidataanalytics.v1beta
                              .ListAccessibleDataAgentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAccessibleDataAgents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta
                                  .ListAccessibleDataAgentsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta
                                  .ListAccessibleDataAgentsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataAgentServiceMethodDescriptorSupplier("ListAccessibleDataAgents"))
                      .build();
        }
      }
    }
    return getListAccessibleDataAgentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.GetDataAgentRequest,
          com.google.cloud.geminidataanalytics.v1beta.DataAgent>
      getGetDataAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataAgent",
      requestType = com.google.cloud.geminidataanalytics.v1beta.GetDataAgentRequest.class,
      responseType = com.google.cloud.geminidataanalytics.v1beta.DataAgent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.GetDataAgentRequest,
          com.google.cloud.geminidataanalytics.v1beta.DataAgent>
      getGetDataAgentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.geminidataanalytics.v1beta.GetDataAgentRequest,
            com.google.cloud.geminidataanalytics.v1beta.DataAgent>
        getGetDataAgentMethod;
    if ((getGetDataAgentMethod = DataAgentServiceGrpc.getGetDataAgentMethod) == null) {
      synchronized (DataAgentServiceGrpc.class) {
        if ((getGetDataAgentMethod = DataAgentServiceGrpc.getGetDataAgentMethod) == null) {
          DataAgentServiceGrpc.getGetDataAgentMethod =
              getGetDataAgentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.geminidataanalytics.v1beta.GetDataAgentRequest,
                          com.google.cloud.geminidataanalytics.v1beta.DataAgent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataAgent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta.GetDataAgentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta.DataAgent
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataAgentServiceMethodDescriptorSupplier("GetDataAgent"))
                      .build();
        }
      }
    }
    return getGetDataAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.CreateDataAgentRequest,
          com.google.longrunning.Operation>
      getCreateDataAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataAgent",
      requestType = com.google.cloud.geminidataanalytics.v1beta.CreateDataAgentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.CreateDataAgentRequest,
          com.google.longrunning.Operation>
      getCreateDataAgentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.geminidataanalytics.v1beta.CreateDataAgentRequest,
            com.google.longrunning.Operation>
        getCreateDataAgentMethod;
    if ((getCreateDataAgentMethod = DataAgentServiceGrpc.getCreateDataAgentMethod) == null) {
      synchronized (DataAgentServiceGrpc.class) {
        if ((getCreateDataAgentMethod = DataAgentServiceGrpc.getCreateDataAgentMethod) == null) {
          DataAgentServiceGrpc.getCreateDataAgentMethod =
              getCreateDataAgentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.geminidataanalytics.v1beta.CreateDataAgentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDataAgent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta.CreateDataAgentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataAgentServiceMethodDescriptorSupplier("CreateDataAgent"))
                      .build();
        }
      }
    }
    return getCreateDataAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.UpdateDataAgentRequest,
          com.google.longrunning.Operation>
      getUpdateDataAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataAgent",
      requestType = com.google.cloud.geminidataanalytics.v1beta.UpdateDataAgentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.UpdateDataAgentRequest,
          com.google.longrunning.Operation>
      getUpdateDataAgentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.geminidataanalytics.v1beta.UpdateDataAgentRequest,
            com.google.longrunning.Operation>
        getUpdateDataAgentMethod;
    if ((getUpdateDataAgentMethod = DataAgentServiceGrpc.getUpdateDataAgentMethod) == null) {
      synchronized (DataAgentServiceGrpc.class) {
        if ((getUpdateDataAgentMethod = DataAgentServiceGrpc.getUpdateDataAgentMethod) == null) {
          DataAgentServiceGrpc.getUpdateDataAgentMethod =
              getUpdateDataAgentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.geminidataanalytics.v1beta.UpdateDataAgentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDataAgent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta.UpdateDataAgentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataAgentServiceMethodDescriptorSupplier("UpdateDataAgent"))
                      .build();
        }
      }
    }
    return getUpdateDataAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.DeleteDataAgentRequest,
          com.google.longrunning.Operation>
      getDeleteDataAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataAgent",
      requestType = com.google.cloud.geminidataanalytics.v1beta.DeleteDataAgentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.DeleteDataAgentRequest,
          com.google.longrunning.Operation>
      getDeleteDataAgentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.geminidataanalytics.v1beta.DeleteDataAgentRequest,
            com.google.longrunning.Operation>
        getDeleteDataAgentMethod;
    if ((getDeleteDataAgentMethod = DataAgentServiceGrpc.getDeleteDataAgentMethod) == null) {
      synchronized (DataAgentServiceGrpc.class) {
        if ((getDeleteDataAgentMethod = DataAgentServiceGrpc.getDeleteDataAgentMethod) == null) {
          DataAgentServiceGrpc.getDeleteDataAgentMethod =
              getDeleteDataAgentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.geminidataanalytics.v1beta.DeleteDataAgentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDataAgent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta.DeleteDataAgentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataAgentServiceMethodDescriptorSupplier("DeleteDataAgent"))
                      .build();
        }
      }
    }
    return getDeleteDataAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIamPolicy",
      requestType = com.google.iam.v1.GetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
        getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = DataAgentServiceGrpc.getGetIamPolicyMethod) == null) {
      synchronized (DataAgentServiceGrpc.class) {
        if ((getGetIamPolicyMethod = DataAgentServiceGrpc.getGetIamPolicyMethod) == null) {
          DataAgentServiceGrpc.getGetIamPolicyMethod =
              getGetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataAgentServiceMethodDescriptorSupplier("GetIamPolicy"))
                      .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIamPolicy",
      requestType = com.google.iam.v1.SetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
        getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = DataAgentServiceGrpc.getSetIamPolicyMethod) == null) {
      synchronized (DataAgentServiceGrpc.class) {
        if ((getSetIamPolicyMethod = DataAgentServiceGrpc.getSetIamPolicyMethod) == null) {
          DataAgentServiceGrpc.getSetIamPolicyMethod =
              getSetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataAgentServiceMethodDescriptorSupplier("SetIamPolicy"))
                      .build();
        }
      }
    }
    return getSetIamPolicyMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DataAgentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataAgentServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataAgentServiceStub>() {
          @java.lang.Override
          public DataAgentServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataAgentServiceStub(channel, callOptions);
          }
        };
    return DataAgentServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static DataAgentServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataAgentServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataAgentServiceBlockingV2Stub>() {
          @java.lang.Override
          public DataAgentServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataAgentServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return DataAgentServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataAgentServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataAgentServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataAgentServiceBlockingStub>() {
          @java.lang.Override
          public DataAgentServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataAgentServiceBlockingStub(channel, callOptions);
          }
        };
    return DataAgentServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DataAgentServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataAgentServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataAgentServiceFutureStub>() {
          @java.lang.Override
          public DataAgentServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataAgentServiceFutureStub(channel, callOptions);
          }
        };
    return DataAgentServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists DataAgents in a given project and location.
     * </pre>
     */
    default void listDataAgents(
        com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDataAgentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DataAgents that are accessible to the caller in a given project and
     * location.
     * </pre>
     */
    default void listAccessibleDataAgents(
        com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAccessibleDataAgentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DataAgent.
     * </pre>
     */
    default void getDataAgent(
        com.google.cloud.geminidataanalytics.v1beta.GetDataAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.geminidataanalytics.v1beta.DataAgent>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataAgentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new DataAgent in a given project and location.
     * </pre>
     */
    default void createDataAgent(
        com.google.cloud.geminidataanalytics.v1beta.CreateDataAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDataAgentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single DataAgent.
     * </pre>
     */
    default void updateDataAgent(
        com.google.cloud.geminidataanalytics.v1beta.UpdateDataAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDataAgentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DataAgent.
     * </pre>
     */
    default void deleteDataAgent(
        com.google.cloud.geminidataanalytics.v1beta.DeleteDataAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDataAgentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy for DataAgent
     * </pre>
     */
    default void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM policy for a DataAgent.
     * </pre>
     */
    default void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetIamPolicyMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DataAgentService.
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public abstract static class DataAgentServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DataAgentServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DataAgentService.
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public static final class DataAgentServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DataAgentServiceStub> {
    private DataAgentServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataAgentServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataAgentServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists DataAgents in a given project and location.
     * </pre>
     */
    public void listDataAgents(
        com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDataAgentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DataAgents that are accessible to the caller in a given project and
     * location.
     * </pre>
     */
    public void listAccessibleDataAgents(
        com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAccessibleDataAgentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DataAgent.
     * </pre>
     */
    public void getDataAgent(
        com.google.cloud.geminidataanalytics.v1beta.GetDataAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.geminidataanalytics.v1beta.DataAgent>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataAgentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new DataAgent in a given project and location.
     * </pre>
     */
    public void createDataAgent(
        com.google.cloud.geminidataanalytics.v1beta.CreateDataAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDataAgentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single DataAgent.
     * </pre>
     */
    public void updateDataAgent(
        com.google.cloud.geminidataanalytics.v1beta.UpdateDataAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDataAgentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DataAgent.
     * </pre>
     */
    public void deleteDataAgent(
        com.google.cloud.geminidataanalytics.v1beta.DeleteDataAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDataAgentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy for DataAgent
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM policy for a DataAgent.
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DataAgentService.
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public static final class DataAgentServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DataAgentServiceBlockingV2Stub> {
    private DataAgentServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataAgentServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataAgentServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists DataAgents in a given project and location.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsResponse listDataAgents(
        com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataAgentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DataAgents that are accessible to the caller in a given project and
     * location.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsResponse
        listAccessibleDataAgents(
            com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAccessibleDataAgentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DataAgent.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta.DataAgent getDataAgent(
        com.google.cloud.geminidataanalytics.v1beta.GetDataAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new DataAgent in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createDataAgent(
        com.google.cloud.geminidataanalytics.v1beta.CreateDataAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDataAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single DataAgent.
     * </pre>
     */
    public com.google.longrunning.Operation updateDataAgent(
        com.google.cloud.geminidataanalytics.v1beta.UpdateDataAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DataAgent.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDataAgent(
        com.google.cloud.geminidataanalytics.v1beta.DeleteDataAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDataAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy for DataAgent
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM policy for a DataAgent.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service DataAgentService.
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public static final class DataAgentServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataAgentServiceBlockingStub> {
    private DataAgentServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataAgentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataAgentServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists DataAgents in a given project and location.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsResponse listDataAgents(
        com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataAgentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DataAgents that are accessible to the caller in a given project and
     * location.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsResponse
        listAccessibleDataAgents(
            com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAccessibleDataAgentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DataAgent.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta.DataAgent getDataAgent(
        com.google.cloud.geminidataanalytics.v1beta.GetDataAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new DataAgent in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createDataAgent(
        com.google.cloud.geminidataanalytics.v1beta.CreateDataAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDataAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single DataAgent.
     * </pre>
     */
    public com.google.longrunning.Operation updateDataAgent(
        com.google.cloud.geminidataanalytics.v1beta.UpdateDataAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DataAgent.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDataAgent(
        com.google.cloud.geminidataanalytics.v1beta.DeleteDataAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDataAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy for DataAgent
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM policy for a DataAgent.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DataAgentService.
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public static final class DataAgentServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataAgentServiceFutureStub> {
    private DataAgentServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataAgentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataAgentServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists DataAgents in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsResponse>
        listDataAgents(com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataAgentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DataAgents that are accessible to the caller in a given project and
     * location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsResponse>
        listAccessibleDataAgents(
            com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAccessibleDataAgentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DataAgent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.geminidataanalytics.v1beta.DataAgent>
        getDataAgent(com.google.cloud.geminidataanalytics.v1beta.GetDataAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataAgentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new DataAgent in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createDataAgent(
            com.google.cloud.geminidataanalytics.v1beta.CreateDataAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDataAgentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single DataAgent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateDataAgent(
            com.google.cloud.geminidataanalytics.v1beta.UpdateDataAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDataAgentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DataAgent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteDataAgent(
            com.google.cloud.geminidataanalytics.v1beta.DeleteDataAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDataAgentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy for DataAgent
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM policy for a DataAgent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_DATA_AGENTS = 0;
  private static final int METHODID_LIST_ACCESSIBLE_DATA_AGENTS = 1;
  private static final int METHODID_GET_DATA_AGENT = 2;
  private static final int METHODID_CREATE_DATA_AGENT = 3;
  private static final int METHODID_UPDATE_DATA_AGENT = 4;
  private static final int METHODID_DELETE_DATA_AGENT = 5;
  private static final int METHODID_GET_IAM_POLICY = 6;
  private static final int METHODID_SET_IAM_POLICY = 7;

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
        case METHODID_LIST_DATA_AGENTS:
          serviceImpl.listDataAgents(
              (com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_ACCESSIBLE_DATA_AGENTS:
          serviceImpl.listAccessibleDataAgents(
              (com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DATA_AGENT:
          serviceImpl.getDataAgent(
              (com.google.cloud.geminidataanalytics.v1beta.GetDataAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.geminidataanalytics.v1beta.DataAgent>)
                  responseObserver);
          break;
        case METHODID_CREATE_DATA_AGENT:
          serviceImpl.createDataAgent(
              (com.google.cloud.geminidataanalytics.v1beta.CreateDataAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_DATA_AGENT:
          serviceImpl.updateDataAgent(
              (com.google.cloud.geminidataanalytics.v1beta.UpdateDataAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_DATA_AGENT:
          serviceImpl.deleteDataAgent(
              (com.google.cloud.geminidataanalytics.v1beta.DeleteDataAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy(
              (com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy(
              (com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
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
            getListDataAgentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsRequest,
                    com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsResponse>(
                    service, METHODID_LIST_DATA_AGENTS)))
        .addMethod(
            getListAccessibleDataAgentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsRequest,
                    com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsResponse>(
                    service, METHODID_LIST_ACCESSIBLE_DATA_AGENTS)))
        .addMethod(
            getGetDataAgentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.geminidataanalytics.v1beta.GetDataAgentRequest,
                    com.google.cloud.geminidataanalytics.v1beta.DataAgent>(
                    service, METHODID_GET_DATA_AGENT)))
        .addMethod(
            getCreateDataAgentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.geminidataanalytics.v1beta.CreateDataAgentRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_DATA_AGENT)))
        .addMethod(
            getUpdateDataAgentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.geminidataanalytics.v1beta.UpdateDataAgentRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_DATA_AGENT)))
        .addMethod(
            getDeleteDataAgentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.geminidataanalytics.v1beta.DeleteDataAgentRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_DATA_AGENT)))
        .addMethod(
            getGetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_GET_IAM_POLICY)))
        .addMethod(
            getSetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_SET_IAM_POLICY)))
        .build();
  }

  private abstract static class DataAgentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataAgentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.geminidataanalytics.v1beta.DataAgentServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataAgentService");
    }
  }

  private static final class DataAgentServiceFileDescriptorSupplier
      extends DataAgentServiceBaseDescriptorSupplier {
    DataAgentServiceFileDescriptorSupplier() {}
  }

  private static final class DataAgentServiceMethodDescriptorSupplier
      extends DataAgentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DataAgentServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DataAgentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DataAgentServiceFileDescriptorSupplier())
                      .addMethod(getListDataAgentsMethod())
                      .addMethod(getListAccessibleDataAgentsMethod())
                      .addMethod(getGetDataAgentMethod())
                      .addMethod(getCreateDataAgentMethod())
                      .addMethod(getUpdateDataAgentMethod())
                      .addMethod(getDeleteDataAgentMethod())
                      .addMethod(getGetIamPolicyMethod())
                      .addMethod(getSetIamPolicyMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
