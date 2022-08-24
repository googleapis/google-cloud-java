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
package com.google.cloud.dialogflow.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing [EntityTypes][google.cloud.dialogflow.v2.EntityType].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/v2/entity_type.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EntityTypesGrpc {

  private EntityTypesGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.v2.EntityTypes";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListEntityTypesRequest,
          com.google.cloud.dialogflow.v2.ListEntityTypesResponse>
      getListEntityTypesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEntityTypes",
      requestType = com.google.cloud.dialogflow.v2.ListEntityTypesRequest.class,
      responseType = com.google.cloud.dialogflow.v2.ListEntityTypesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListEntityTypesRequest,
          com.google.cloud.dialogflow.v2.ListEntityTypesResponse>
      getListEntityTypesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.ListEntityTypesRequest,
            com.google.cloud.dialogflow.v2.ListEntityTypesResponse>
        getListEntityTypesMethod;
    if ((getListEntityTypesMethod = EntityTypesGrpc.getListEntityTypesMethod) == null) {
      synchronized (EntityTypesGrpc.class) {
        if ((getListEntityTypesMethod = EntityTypesGrpc.getListEntityTypesMethod) == null) {
          EntityTypesGrpc.getListEntityTypesMethod =
              getListEntityTypesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.ListEntityTypesRequest,
                          com.google.cloud.dialogflow.v2.ListEntityTypesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEntityTypes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.ListEntityTypesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.ListEntityTypesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EntityTypesMethodDescriptorSupplier("ListEntityTypes"))
                      .build();
        }
      }
    }
    return getListEntityTypesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetEntityTypeRequest,
          com.google.cloud.dialogflow.v2.EntityType>
      getGetEntityTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEntityType",
      requestType = com.google.cloud.dialogflow.v2.GetEntityTypeRequest.class,
      responseType = com.google.cloud.dialogflow.v2.EntityType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetEntityTypeRequest,
          com.google.cloud.dialogflow.v2.EntityType>
      getGetEntityTypeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.GetEntityTypeRequest,
            com.google.cloud.dialogflow.v2.EntityType>
        getGetEntityTypeMethod;
    if ((getGetEntityTypeMethod = EntityTypesGrpc.getGetEntityTypeMethod) == null) {
      synchronized (EntityTypesGrpc.class) {
        if ((getGetEntityTypeMethod = EntityTypesGrpc.getGetEntityTypeMethod) == null) {
          EntityTypesGrpc.getGetEntityTypeMethod =
              getGetEntityTypeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.GetEntityTypeRequest,
                          com.google.cloud.dialogflow.v2.EntityType>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEntityType"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.GetEntityTypeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.EntityType.getDefaultInstance()))
                      .setSchemaDescriptor(new EntityTypesMethodDescriptorSupplier("GetEntityType"))
                      .build();
        }
      }
    }
    return getGetEntityTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.CreateEntityTypeRequest,
          com.google.cloud.dialogflow.v2.EntityType>
      getCreateEntityTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEntityType",
      requestType = com.google.cloud.dialogflow.v2.CreateEntityTypeRequest.class,
      responseType = com.google.cloud.dialogflow.v2.EntityType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.CreateEntityTypeRequest,
          com.google.cloud.dialogflow.v2.EntityType>
      getCreateEntityTypeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.CreateEntityTypeRequest,
            com.google.cloud.dialogflow.v2.EntityType>
        getCreateEntityTypeMethod;
    if ((getCreateEntityTypeMethod = EntityTypesGrpc.getCreateEntityTypeMethod) == null) {
      synchronized (EntityTypesGrpc.class) {
        if ((getCreateEntityTypeMethod = EntityTypesGrpc.getCreateEntityTypeMethod) == null) {
          EntityTypesGrpc.getCreateEntityTypeMethod =
              getCreateEntityTypeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.CreateEntityTypeRequest,
                          com.google.cloud.dialogflow.v2.EntityType>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEntityType"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.CreateEntityTypeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.EntityType.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EntityTypesMethodDescriptorSupplier("CreateEntityType"))
                      .build();
        }
      }
    }
    return getCreateEntityTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.UpdateEntityTypeRequest,
          com.google.cloud.dialogflow.v2.EntityType>
      getUpdateEntityTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEntityType",
      requestType = com.google.cloud.dialogflow.v2.UpdateEntityTypeRequest.class,
      responseType = com.google.cloud.dialogflow.v2.EntityType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.UpdateEntityTypeRequest,
          com.google.cloud.dialogflow.v2.EntityType>
      getUpdateEntityTypeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.UpdateEntityTypeRequest,
            com.google.cloud.dialogflow.v2.EntityType>
        getUpdateEntityTypeMethod;
    if ((getUpdateEntityTypeMethod = EntityTypesGrpc.getUpdateEntityTypeMethod) == null) {
      synchronized (EntityTypesGrpc.class) {
        if ((getUpdateEntityTypeMethod = EntityTypesGrpc.getUpdateEntityTypeMethod) == null) {
          EntityTypesGrpc.getUpdateEntityTypeMethod =
              getUpdateEntityTypeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.UpdateEntityTypeRequest,
                          com.google.cloud.dialogflow.v2.EntityType>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEntityType"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.UpdateEntityTypeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.EntityType.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EntityTypesMethodDescriptorSupplier("UpdateEntityType"))
                      .build();
        }
      }
    }
    return getUpdateEntityTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DeleteEntityTypeRequest, com.google.protobuf.Empty>
      getDeleteEntityTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEntityType",
      requestType = com.google.cloud.dialogflow.v2.DeleteEntityTypeRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DeleteEntityTypeRequest, com.google.protobuf.Empty>
      getDeleteEntityTypeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.DeleteEntityTypeRequest, com.google.protobuf.Empty>
        getDeleteEntityTypeMethod;
    if ((getDeleteEntityTypeMethod = EntityTypesGrpc.getDeleteEntityTypeMethod) == null) {
      synchronized (EntityTypesGrpc.class) {
        if ((getDeleteEntityTypeMethod = EntityTypesGrpc.getDeleteEntityTypeMethod) == null) {
          EntityTypesGrpc.getDeleteEntityTypeMethod =
              getDeleteEntityTypeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.DeleteEntityTypeRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEntityType"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.DeleteEntityTypeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EntityTypesMethodDescriptorSupplier("DeleteEntityType"))
                      .build();
        }
      }
    }
    return getDeleteEntityTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchUpdateEntityTypesRequest,
          com.google.longrunning.Operation>
      getBatchUpdateEntityTypesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchUpdateEntityTypes",
      requestType = com.google.cloud.dialogflow.v2.BatchUpdateEntityTypesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchUpdateEntityTypesRequest,
          com.google.longrunning.Operation>
      getBatchUpdateEntityTypesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.BatchUpdateEntityTypesRequest,
            com.google.longrunning.Operation>
        getBatchUpdateEntityTypesMethod;
    if ((getBatchUpdateEntityTypesMethod = EntityTypesGrpc.getBatchUpdateEntityTypesMethod)
        == null) {
      synchronized (EntityTypesGrpc.class) {
        if ((getBatchUpdateEntityTypesMethod = EntityTypesGrpc.getBatchUpdateEntityTypesMethod)
            == null) {
          EntityTypesGrpc.getBatchUpdateEntityTypesMethod =
              getBatchUpdateEntityTypesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.BatchUpdateEntityTypesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchUpdateEntityTypes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.BatchUpdateEntityTypesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EntityTypesMethodDescriptorSupplier("BatchUpdateEntityTypes"))
                      .build();
        }
      }
    }
    return getBatchUpdateEntityTypesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchDeleteEntityTypesRequest,
          com.google.longrunning.Operation>
      getBatchDeleteEntityTypesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchDeleteEntityTypes",
      requestType = com.google.cloud.dialogflow.v2.BatchDeleteEntityTypesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchDeleteEntityTypesRequest,
          com.google.longrunning.Operation>
      getBatchDeleteEntityTypesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.BatchDeleteEntityTypesRequest,
            com.google.longrunning.Operation>
        getBatchDeleteEntityTypesMethod;
    if ((getBatchDeleteEntityTypesMethod = EntityTypesGrpc.getBatchDeleteEntityTypesMethod)
        == null) {
      synchronized (EntityTypesGrpc.class) {
        if ((getBatchDeleteEntityTypesMethod = EntityTypesGrpc.getBatchDeleteEntityTypesMethod)
            == null) {
          EntityTypesGrpc.getBatchDeleteEntityTypesMethod =
              getBatchDeleteEntityTypesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.BatchDeleteEntityTypesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchDeleteEntityTypes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.BatchDeleteEntityTypesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EntityTypesMethodDescriptorSupplier("BatchDeleteEntityTypes"))
                      .build();
        }
      }
    }
    return getBatchDeleteEntityTypesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchCreateEntitiesRequest,
          com.google.longrunning.Operation>
      getBatchCreateEntitiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateEntities",
      requestType = com.google.cloud.dialogflow.v2.BatchCreateEntitiesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchCreateEntitiesRequest,
          com.google.longrunning.Operation>
      getBatchCreateEntitiesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.BatchCreateEntitiesRequest,
            com.google.longrunning.Operation>
        getBatchCreateEntitiesMethod;
    if ((getBatchCreateEntitiesMethod = EntityTypesGrpc.getBatchCreateEntitiesMethod) == null) {
      synchronized (EntityTypesGrpc.class) {
        if ((getBatchCreateEntitiesMethod = EntityTypesGrpc.getBatchCreateEntitiesMethod) == null) {
          EntityTypesGrpc.getBatchCreateEntitiesMethod =
              getBatchCreateEntitiesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.BatchCreateEntitiesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchCreateEntities"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.BatchCreateEntitiesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EntityTypesMethodDescriptorSupplier("BatchCreateEntities"))
                      .build();
        }
      }
    }
    return getBatchCreateEntitiesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchUpdateEntitiesRequest,
          com.google.longrunning.Operation>
      getBatchUpdateEntitiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchUpdateEntities",
      requestType = com.google.cloud.dialogflow.v2.BatchUpdateEntitiesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchUpdateEntitiesRequest,
          com.google.longrunning.Operation>
      getBatchUpdateEntitiesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.BatchUpdateEntitiesRequest,
            com.google.longrunning.Operation>
        getBatchUpdateEntitiesMethod;
    if ((getBatchUpdateEntitiesMethod = EntityTypesGrpc.getBatchUpdateEntitiesMethod) == null) {
      synchronized (EntityTypesGrpc.class) {
        if ((getBatchUpdateEntitiesMethod = EntityTypesGrpc.getBatchUpdateEntitiesMethod) == null) {
          EntityTypesGrpc.getBatchUpdateEntitiesMethod =
              getBatchUpdateEntitiesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.BatchUpdateEntitiesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchUpdateEntities"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.BatchUpdateEntitiesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EntityTypesMethodDescriptorSupplier("BatchUpdateEntities"))
                      .build();
        }
      }
    }
    return getBatchUpdateEntitiesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchDeleteEntitiesRequest,
          com.google.longrunning.Operation>
      getBatchDeleteEntitiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchDeleteEntities",
      requestType = com.google.cloud.dialogflow.v2.BatchDeleteEntitiesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchDeleteEntitiesRequest,
          com.google.longrunning.Operation>
      getBatchDeleteEntitiesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.BatchDeleteEntitiesRequest,
            com.google.longrunning.Operation>
        getBatchDeleteEntitiesMethod;
    if ((getBatchDeleteEntitiesMethod = EntityTypesGrpc.getBatchDeleteEntitiesMethod) == null) {
      synchronized (EntityTypesGrpc.class) {
        if ((getBatchDeleteEntitiesMethod = EntityTypesGrpc.getBatchDeleteEntitiesMethod) == null) {
          EntityTypesGrpc.getBatchDeleteEntitiesMethod =
              getBatchDeleteEntitiesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.BatchDeleteEntitiesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchDeleteEntities"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.BatchDeleteEntitiesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EntityTypesMethodDescriptorSupplier("BatchDeleteEntities"))
                      .build();
        }
      }
    }
    return getBatchDeleteEntitiesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static EntityTypesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EntityTypesStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EntityTypesStub>() {
          @java.lang.Override
          public EntityTypesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EntityTypesStub(channel, callOptions);
          }
        };
    return EntityTypesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EntityTypesBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EntityTypesBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EntityTypesBlockingStub>() {
          @java.lang.Override
          public EntityTypesBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EntityTypesBlockingStub(channel, callOptions);
          }
        };
    return EntityTypesBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static EntityTypesFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EntityTypesFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EntityTypesFutureStub>() {
          @java.lang.Override
          public EntityTypesFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EntityTypesFutureStub(channel, callOptions);
          }
        };
    return EntityTypesFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing [EntityTypes][google.cloud.dialogflow.v2.EntityType].
   * </pre>
   */
  public abstract static class EntityTypesImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Returns the list of all entity types in the specified agent.
     * </pre>
     */
    public void listEntityTypes(
        com.google.cloud.dialogflow.v2.ListEntityTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListEntityTypesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEntityTypesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified entity type.
     * </pre>
     */
    public void getEntityType(
        com.google.cloud.dialogflow.v2.GetEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.EntityType> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEntityTypeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an entity type in the specified agent.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void createEntityType(
        com.google.cloud.dialogflow.v2.CreateEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.EntityType> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEntityTypeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified entity type.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void updateEntityType(
        com.google.cloud.dialogflow.v2.UpdateEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.EntityType> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEntityTypeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified entity type.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void deleteEntityType(
        com.google.cloud.dialogflow.v2.DeleteEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEntityTypeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates/Creates multiple entity types in the specified agent.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: [BatchUpdateEntityTypesResponse][google.cloud.dialogflow.v2.BatchUpdateEntityTypesResponse]
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void batchUpdateEntityTypes(
        com.google.cloud.dialogflow.v2.BatchUpdateEntityTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchUpdateEntityTypesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes entity types in the specified agent.
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
    public void batchDeleteEntityTypes(
        com.google.cloud.dialogflow.v2.BatchDeleteEntityTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchDeleteEntityTypesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates multiple new entities in the specified entity type.
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
    public void batchCreateEntities(
        com.google.cloud.dialogflow.v2.BatchCreateEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchCreateEntitiesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates or creates multiple entities in the specified entity type. This
     * method does not affect entities in the entity type that aren't explicitly
     * specified in the request.
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
    public void batchUpdateEntities(
        com.google.cloud.dialogflow.v2.BatchUpdateEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchUpdateEntitiesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes entities in the specified entity type.
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
    public void batchDeleteEntities(
        com.google.cloud.dialogflow.v2.BatchDeleteEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchDeleteEntitiesMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListEntityTypesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.ListEntityTypesRequest,
                      com.google.cloud.dialogflow.v2.ListEntityTypesResponse>(
                      this, METHODID_LIST_ENTITY_TYPES)))
          .addMethod(
              getGetEntityTypeMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.GetEntityTypeRequest,
                      com.google.cloud.dialogflow.v2.EntityType>(this, METHODID_GET_ENTITY_TYPE)))
          .addMethod(
              getCreateEntityTypeMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.CreateEntityTypeRequest,
                      com.google.cloud.dialogflow.v2.EntityType>(
                      this, METHODID_CREATE_ENTITY_TYPE)))
          .addMethod(
              getUpdateEntityTypeMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.UpdateEntityTypeRequest,
                      com.google.cloud.dialogflow.v2.EntityType>(
                      this, METHODID_UPDATE_ENTITY_TYPE)))
          .addMethod(
              getDeleteEntityTypeMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.DeleteEntityTypeRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_ENTITY_TYPE)))
          .addMethod(
              getBatchUpdateEntityTypesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.BatchUpdateEntityTypesRequest,
                      com.google.longrunning.Operation>(this, METHODID_BATCH_UPDATE_ENTITY_TYPES)))
          .addMethod(
              getBatchDeleteEntityTypesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.BatchDeleteEntityTypesRequest,
                      com.google.longrunning.Operation>(this, METHODID_BATCH_DELETE_ENTITY_TYPES)))
          .addMethod(
              getBatchCreateEntitiesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.BatchCreateEntitiesRequest,
                      com.google.longrunning.Operation>(this, METHODID_BATCH_CREATE_ENTITIES)))
          .addMethod(
              getBatchUpdateEntitiesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.BatchUpdateEntitiesRequest,
                      com.google.longrunning.Operation>(this, METHODID_BATCH_UPDATE_ENTITIES)))
          .addMethod(
              getBatchDeleteEntitiesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.BatchDeleteEntitiesRequest,
                      com.google.longrunning.Operation>(this, METHODID_BATCH_DELETE_ENTITIES)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [EntityTypes][google.cloud.dialogflow.v2.EntityType].
   * </pre>
   */
  public static final class EntityTypesStub
      extends io.grpc.stub.AbstractAsyncStub<EntityTypesStub> {
    private EntityTypesStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EntityTypesStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EntityTypesStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all entity types in the specified agent.
     * </pre>
     */
    public void listEntityTypes(
        com.google.cloud.dialogflow.v2.ListEntityTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListEntityTypesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEntityTypesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified entity type.
     * </pre>
     */
    public void getEntityType(
        com.google.cloud.dialogflow.v2.GetEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.EntityType> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEntityTypeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an entity type in the specified agent.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void createEntityType(
        com.google.cloud.dialogflow.v2.CreateEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.EntityType> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEntityTypeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified entity type.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void updateEntityType(
        com.google.cloud.dialogflow.v2.UpdateEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.EntityType> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEntityTypeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified entity type.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void deleteEntityType(
        com.google.cloud.dialogflow.v2.DeleteEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEntityTypeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates/Creates multiple entity types in the specified agent.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: [BatchUpdateEntityTypesResponse][google.cloud.dialogflow.v2.BatchUpdateEntityTypesResponse]
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public void batchUpdateEntityTypes(
        com.google.cloud.dialogflow.v2.BatchUpdateEntityTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchUpdateEntityTypesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes entity types in the specified agent.
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
    public void batchDeleteEntityTypes(
        com.google.cloud.dialogflow.v2.BatchDeleteEntityTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchDeleteEntityTypesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates multiple new entities in the specified entity type.
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
    public void batchCreateEntities(
        com.google.cloud.dialogflow.v2.BatchCreateEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCreateEntitiesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates or creates multiple entities in the specified entity type. This
     * method does not affect entities in the entity type that aren't explicitly
     * specified in the request.
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
    public void batchUpdateEntities(
        com.google.cloud.dialogflow.v2.BatchUpdateEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchUpdateEntitiesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes entities in the specified entity type.
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
    public void batchDeleteEntities(
        com.google.cloud.dialogflow.v2.BatchDeleteEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchDeleteEntitiesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [EntityTypes][google.cloud.dialogflow.v2.EntityType].
   * </pre>
   */
  public static final class EntityTypesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EntityTypesBlockingStub> {
    private EntityTypesBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EntityTypesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EntityTypesBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all entity types in the specified agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.ListEntityTypesResponse listEntityTypes(
        com.google.cloud.dialogflow.v2.ListEntityTypesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEntityTypesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified entity type.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.EntityType getEntityType(
        com.google.cloud.dialogflow.v2.GetEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEntityTypeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an entity type in the specified agent.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.EntityType createEntityType(
        com.google.cloud.dialogflow.v2.CreateEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEntityTypeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified entity type.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.EntityType updateEntityType(
        com.google.cloud.dialogflow.v2.UpdateEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEntityTypeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified entity type.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.protobuf.Empty deleteEntityType(
        com.google.cloud.dialogflow.v2.DeleteEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEntityTypeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates/Creates multiple entity types in the specified agent.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: [BatchUpdateEntityTypesResponse][google.cloud.dialogflow.v2.BatchUpdateEntityTypesResponse]
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.longrunning.Operation batchUpdateEntityTypes(
        com.google.cloud.dialogflow.v2.BatchUpdateEntityTypesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchUpdateEntityTypesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes entity types in the specified agent.
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
    public com.google.longrunning.Operation batchDeleteEntityTypes(
        com.google.cloud.dialogflow.v2.BatchDeleteEntityTypesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchDeleteEntityTypesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates multiple new entities in the specified entity type.
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
    public com.google.longrunning.Operation batchCreateEntities(
        com.google.cloud.dialogflow.v2.BatchCreateEntitiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreateEntitiesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates or creates multiple entities in the specified entity type. This
     * method does not affect entities in the entity type that aren't explicitly
     * specified in the request.
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
    public com.google.longrunning.Operation batchUpdateEntities(
        com.google.cloud.dialogflow.v2.BatchUpdateEntitiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchUpdateEntitiesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes entities in the specified entity type.
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
    public com.google.longrunning.Operation batchDeleteEntities(
        com.google.cloud.dialogflow.v2.BatchDeleteEntitiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchDeleteEntitiesMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [EntityTypes][google.cloud.dialogflow.v2.EntityType].
   * </pre>
   */
  public static final class EntityTypesFutureStub
      extends io.grpc.stub.AbstractFutureStub<EntityTypesFutureStub> {
    private EntityTypesFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EntityTypesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EntityTypesFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all entity types in the specified agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.ListEntityTypesResponse>
        listEntityTypes(com.google.cloud.dialogflow.v2.ListEntityTypesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEntityTypesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified entity type.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.EntityType>
        getEntityType(com.google.cloud.dialogflow.v2.GetEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEntityTypeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an entity type in the specified agent.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.EntityType>
        createEntityType(com.google.cloud.dialogflow.v2.CreateEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEntityTypeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified entity type.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.EntityType>
        updateEntityType(com.google.cloud.dialogflow.v2.UpdateEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEntityTypeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified entity type.
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteEntityType(com.google.cloud.dialogflow.v2.DeleteEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEntityTypeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates/Creates multiple entity types in the specified agent.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: [BatchUpdateEntityTypesResponse][google.cloud.dialogflow.v2.BatchUpdateEntityTypesResponse]
     * Note: You should always train an agent prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/es/docs/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchUpdateEntityTypes(
            com.google.cloud.dialogflow.v2.BatchUpdateEntityTypesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchUpdateEntityTypesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes entity types in the specified agent.
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
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchDeleteEntityTypes(
            com.google.cloud.dialogflow.v2.BatchDeleteEntityTypesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchDeleteEntityTypesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates multiple new entities in the specified entity type.
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
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchCreateEntities(com.google.cloud.dialogflow.v2.BatchCreateEntitiesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCreateEntitiesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates or creates multiple entities in the specified entity type. This
     * method does not affect entities in the entity type that aren't explicitly
     * specified in the request.
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
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchUpdateEntities(com.google.cloud.dialogflow.v2.BatchUpdateEntitiesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchUpdateEntitiesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes entities in the specified entity type.
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
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchDeleteEntities(com.google.cloud.dialogflow.v2.BatchDeleteEntitiesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchDeleteEntitiesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ENTITY_TYPES = 0;
  private static final int METHODID_GET_ENTITY_TYPE = 1;
  private static final int METHODID_CREATE_ENTITY_TYPE = 2;
  private static final int METHODID_UPDATE_ENTITY_TYPE = 3;
  private static final int METHODID_DELETE_ENTITY_TYPE = 4;
  private static final int METHODID_BATCH_UPDATE_ENTITY_TYPES = 5;
  private static final int METHODID_BATCH_DELETE_ENTITY_TYPES = 6;
  private static final int METHODID_BATCH_CREATE_ENTITIES = 7;
  private static final int METHODID_BATCH_UPDATE_ENTITIES = 8;
  private static final int METHODID_BATCH_DELETE_ENTITIES = 9;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EntityTypesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EntityTypesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_ENTITY_TYPES:
          serviceImpl.listEntityTypes(
              (com.google.cloud.dialogflow.v2.ListEntityTypesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListEntityTypesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ENTITY_TYPE:
          serviceImpl.getEntityType(
              (com.google.cloud.dialogflow.v2.GetEntityTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.EntityType>)
                  responseObserver);
          break;
        case METHODID_CREATE_ENTITY_TYPE:
          serviceImpl.createEntityType(
              (com.google.cloud.dialogflow.v2.CreateEntityTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.EntityType>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ENTITY_TYPE:
          serviceImpl.updateEntityType(
              (com.google.cloud.dialogflow.v2.UpdateEntityTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.EntityType>)
                  responseObserver);
          break;
        case METHODID_DELETE_ENTITY_TYPE:
          serviceImpl.deleteEntityType(
              (com.google.cloud.dialogflow.v2.DeleteEntityTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_BATCH_UPDATE_ENTITY_TYPES:
          serviceImpl.batchUpdateEntityTypes(
              (com.google.cloud.dialogflow.v2.BatchUpdateEntityTypesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BATCH_DELETE_ENTITY_TYPES:
          serviceImpl.batchDeleteEntityTypes(
              (com.google.cloud.dialogflow.v2.BatchDeleteEntityTypesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BATCH_CREATE_ENTITIES:
          serviceImpl.batchCreateEntities(
              (com.google.cloud.dialogflow.v2.BatchCreateEntitiesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BATCH_UPDATE_ENTITIES:
          serviceImpl.batchUpdateEntities(
              (com.google.cloud.dialogflow.v2.BatchUpdateEntitiesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BATCH_DELETE_ENTITIES:
          serviceImpl.batchDeleteEntities(
              (com.google.cloud.dialogflow.v2.BatchDeleteEntitiesRequest) request,
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

  private abstract static class EntityTypesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EntityTypesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.v2.EntityTypeProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EntityTypes");
    }
  }

  private static final class EntityTypesFileDescriptorSupplier
      extends EntityTypesBaseDescriptorSupplier {
    EntityTypesFileDescriptorSupplier() {}
  }

  private static final class EntityTypesMethodDescriptorSupplier
      extends EntityTypesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EntityTypesMethodDescriptorSupplier(String methodName) {
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
      synchronized (EntityTypesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new EntityTypesFileDescriptorSupplier())
                      .addMethod(getListEntityTypesMethod())
                      .addMethod(getGetEntityTypeMethod())
                      .addMethod(getCreateEntityTypeMethod())
                      .addMethod(getUpdateEntityTypeMethod())
                      .addMethod(getDeleteEntityTypeMethod())
                      .addMethod(getBatchUpdateEntityTypesMethod())
                      .addMethod(getBatchDeleteEntityTypesMethod())
                      .addMethod(getBatchCreateEntitiesMethod())
                      .addMethod(getBatchUpdateEntitiesMethod())
                      .addMethod(getBatchDeleteEntitiesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
