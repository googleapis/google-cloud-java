package com.google.cloud.dialogflow.v2;

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
 * Entities are extracted from user input and represent parameters that are
 * meaningful to your application. For example, a date range, a proper name
 * such as a geographic location or landmark, and so on. Entities represent
 * actionable data for your application.
 * When you define an entity, you can also include synonyms that all map to
 * that entity. For example, "soft drink", "soda", "pop", and so on.
 * There are three types of entities:
 * *   **System** - entities that are defined by the Dialogflow API for common
 *     data types such as date, time, currency, and so on. A system entity is
 *     represented by the `EntityType` type.
 * *   **Developer** - entities that are defined by you that represent
 *     actionable data that is meaningful to your application. For example,
 *     you could define a `pizza.sauce` entity for red or white pizza sauce,
 *     a `pizza.cheese` entity for the different types of cheese on a pizza,
 *     a `pizza.topping` entity for different toppings, and so on. A developer
 *     entity is represented by the `EntityType` type.
 * *   **User** - entities that are built for an individual user such as
 *     favorites, preferences, playlists, and so on. A user entity is
 *     represented by the [SessionEntityType][google.cloud.dialogflow.v2.SessionEntityType] type.
 * For more information about entity types, see the
 * [Dialogflow
 * documentation](https://cloud.google.com/dialogflow/docs/entities-overview).
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/dialogflow/v2/entity_type.proto")
public final class EntityTypesGrpc {

  private EntityTypesGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.v2.EntityTypes";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListEntityTypesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListEntityTypesRequest,
          com.google.cloud.dialogflow.v2.ListEntityTypesResponse>
      METHOD_LIST_ENTITY_TYPES = getListEntityTypesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListEntityTypesRequest,
          com.google.cloud.dialogflow.v2.ListEntityTypesResponse>
      getListEntityTypesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListEntityTypesRequest,
          com.google.cloud.dialogflow.v2.ListEntityTypesResponse>
      getListEntityTypesMethod() {
    return getListEntityTypesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListEntityTypesRequest,
          com.google.cloud.dialogflow.v2.ListEntityTypesResponse>
      getListEntityTypesMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2.EntityTypes", "ListEntityTypes"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetEntityTypeMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetEntityTypeRequest,
          com.google.cloud.dialogflow.v2.EntityType>
      METHOD_GET_ENTITY_TYPE = getGetEntityTypeMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetEntityTypeRequest,
          com.google.cloud.dialogflow.v2.EntityType>
      getGetEntityTypeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetEntityTypeRequest,
          com.google.cloud.dialogflow.v2.EntityType>
      getGetEntityTypeMethod() {
    return getGetEntityTypeMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetEntityTypeRequest,
          com.google.cloud.dialogflow.v2.EntityType>
      getGetEntityTypeMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2.EntityTypes", "GetEntityType"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateEntityTypeMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.CreateEntityTypeRequest,
          com.google.cloud.dialogflow.v2.EntityType>
      METHOD_CREATE_ENTITY_TYPE = getCreateEntityTypeMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.CreateEntityTypeRequest,
          com.google.cloud.dialogflow.v2.EntityType>
      getCreateEntityTypeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.CreateEntityTypeRequest,
          com.google.cloud.dialogflow.v2.EntityType>
      getCreateEntityTypeMethod() {
    return getCreateEntityTypeMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.CreateEntityTypeRequest,
          com.google.cloud.dialogflow.v2.EntityType>
      getCreateEntityTypeMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2.EntityTypes", "CreateEntityType"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateEntityTypeMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.UpdateEntityTypeRequest,
          com.google.cloud.dialogflow.v2.EntityType>
      METHOD_UPDATE_ENTITY_TYPE = getUpdateEntityTypeMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.UpdateEntityTypeRequest,
          com.google.cloud.dialogflow.v2.EntityType>
      getUpdateEntityTypeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.UpdateEntityTypeRequest,
          com.google.cloud.dialogflow.v2.EntityType>
      getUpdateEntityTypeMethod() {
    return getUpdateEntityTypeMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.UpdateEntityTypeRequest,
          com.google.cloud.dialogflow.v2.EntityType>
      getUpdateEntityTypeMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2.EntityTypes", "UpdateEntityType"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteEntityTypeMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DeleteEntityTypeRequest, com.google.protobuf.Empty>
      METHOD_DELETE_ENTITY_TYPE = getDeleteEntityTypeMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DeleteEntityTypeRequest, com.google.protobuf.Empty>
      getDeleteEntityTypeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DeleteEntityTypeRequest, com.google.protobuf.Empty>
      getDeleteEntityTypeMethod() {
    return getDeleteEntityTypeMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DeleteEntityTypeRequest, com.google.protobuf.Empty>
      getDeleteEntityTypeMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2.EntityTypes", "DeleteEntityType"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBatchUpdateEntityTypesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchUpdateEntityTypesRequest,
          com.google.longrunning.Operation>
      METHOD_BATCH_UPDATE_ENTITY_TYPES = getBatchUpdateEntityTypesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchUpdateEntityTypesRequest,
          com.google.longrunning.Operation>
      getBatchUpdateEntityTypesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchUpdateEntityTypesRequest,
          com.google.longrunning.Operation>
      getBatchUpdateEntityTypesMethod() {
    return getBatchUpdateEntityTypesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchUpdateEntityTypesRequest,
          com.google.longrunning.Operation>
      getBatchUpdateEntityTypesMethodHelper() {
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
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2.EntityTypes", "BatchUpdateEntityTypes"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBatchDeleteEntityTypesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchDeleteEntityTypesRequest,
          com.google.longrunning.Operation>
      METHOD_BATCH_DELETE_ENTITY_TYPES = getBatchDeleteEntityTypesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchDeleteEntityTypesRequest,
          com.google.longrunning.Operation>
      getBatchDeleteEntityTypesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchDeleteEntityTypesRequest,
          com.google.longrunning.Operation>
      getBatchDeleteEntityTypesMethod() {
    return getBatchDeleteEntityTypesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchDeleteEntityTypesRequest,
          com.google.longrunning.Operation>
      getBatchDeleteEntityTypesMethodHelper() {
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
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2.EntityTypes", "BatchDeleteEntityTypes"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBatchCreateEntitiesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchCreateEntitiesRequest,
          com.google.longrunning.Operation>
      METHOD_BATCH_CREATE_ENTITIES = getBatchCreateEntitiesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchCreateEntitiesRequest,
          com.google.longrunning.Operation>
      getBatchCreateEntitiesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchCreateEntitiesRequest,
          com.google.longrunning.Operation>
      getBatchCreateEntitiesMethod() {
    return getBatchCreateEntitiesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchCreateEntitiesRequest,
          com.google.longrunning.Operation>
      getBatchCreateEntitiesMethodHelper() {
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
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2.EntityTypes", "BatchCreateEntities"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBatchUpdateEntitiesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchUpdateEntitiesRequest,
          com.google.longrunning.Operation>
      METHOD_BATCH_UPDATE_ENTITIES = getBatchUpdateEntitiesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchUpdateEntitiesRequest,
          com.google.longrunning.Operation>
      getBatchUpdateEntitiesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchUpdateEntitiesRequest,
          com.google.longrunning.Operation>
      getBatchUpdateEntitiesMethod() {
    return getBatchUpdateEntitiesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchUpdateEntitiesRequest,
          com.google.longrunning.Operation>
      getBatchUpdateEntitiesMethodHelper() {
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
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2.EntityTypes", "BatchUpdateEntities"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBatchDeleteEntitiesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchDeleteEntitiesRequest,
          com.google.longrunning.Operation>
      METHOD_BATCH_DELETE_ENTITIES = getBatchDeleteEntitiesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchDeleteEntitiesRequest,
          com.google.longrunning.Operation>
      getBatchDeleteEntitiesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchDeleteEntitiesRequest,
          com.google.longrunning.Operation>
      getBatchDeleteEntitiesMethod() {
    return getBatchDeleteEntitiesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.BatchDeleteEntitiesRequest,
          com.google.longrunning.Operation>
      getBatchDeleteEntitiesMethodHelper() {
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
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2.EntityTypes", "BatchDeleteEntities"))
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
    return new EntityTypesStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EntityTypesBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new EntityTypesBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static EntityTypesFutureStub newFutureStub(io.grpc.Channel channel) {
    return new EntityTypesFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * Entities are extracted from user input and represent parameters that are
   * meaningful to your application. For example, a date range, a proper name
   * such as a geographic location or landmark, and so on. Entities represent
   * actionable data for your application.
   * When you define an entity, you can also include synonyms that all map to
   * that entity. For example, "soft drink", "soda", "pop", and so on.
   * There are three types of entities:
   * *   **System** - entities that are defined by the Dialogflow API for common
   *     data types such as date, time, currency, and so on. A system entity is
   *     represented by the `EntityType` type.
   * *   **Developer** - entities that are defined by you that represent
   *     actionable data that is meaningful to your application. For example,
   *     you could define a `pizza.sauce` entity for red or white pizza sauce,
   *     a `pizza.cheese` entity for the different types of cheese on a pizza,
   *     a `pizza.topping` entity for different toppings, and so on. A developer
   *     entity is represented by the `EntityType` type.
   * *   **User** - entities that are built for an individual user such as
   *     favorites, preferences, playlists, and so on. A user entity is
   *     represented by the [SessionEntityType][google.cloud.dialogflow.v2.SessionEntityType] type.
   * For more information about entity types, see the
   * [Dialogflow
   * documentation](https://cloud.google.com/dialogflow/docs/entities-overview).
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
      asyncUnimplementedUnaryCall(getListEntityTypesMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getGetEntityTypeMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an entity type in the specified agent.
     * </pre>
     */
    public void createEntityType(
        com.google.cloud.dialogflow.v2.CreateEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.EntityType> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateEntityTypeMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified entity type.
     * </pre>
     */
    public void updateEntityType(
        com.google.cloud.dialogflow.v2.UpdateEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.EntityType> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateEntityTypeMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified entity type.
     * </pre>
     */
    public void deleteEntityType(
        com.google.cloud.dialogflow.v2.DeleteEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteEntityTypeMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates/Creates multiple entity types in the specified agent.
     * Operation &lt;response: [BatchUpdateEntityTypesResponse][google.cloud.dialogflow.v2.BatchUpdateEntityTypesResponse]&gt;
     * </pre>
     */
    public void batchUpdateEntityTypes(
        com.google.cloud.dialogflow.v2.BatchUpdateEntityTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getBatchUpdateEntityTypesMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes entity types in the specified agent.
     * Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
     * </pre>
     */
    public void batchDeleteEntityTypes(
        com.google.cloud.dialogflow.v2.BatchDeleteEntityTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getBatchDeleteEntityTypesMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates multiple new entities in the specified entity type.
     * Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
     * </pre>
     */
    public void batchCreateEntities(
        com.google.cloud.dialogflow.v2.BatchCreateEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getBatchCreateEntitiesMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates or creates multiple entities in the specified entity type. This
     * method does not affect entities in the entity type that aren't explicitly
     * specified in the request.
     * Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
     * </pre>
     */
    public void batchUpdateEntities(
        com.google.cloud.dialogflow.v2.BatchUpdateEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getBatchUpdateEntitiesMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes entities in the specified entity type.
     * Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
     * </pre>
     */
    public void batchDeleteEntities(
        com.google.cloud.dialogflow.v2.BatchDeleteEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getBatchDeleteEntitiesMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListEntityTypesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.ListEntityTypesRequest,
                      com.google.cloud.dialogflow.v2.ListEntityTypesResponse>(
                      this, METHODID_LIST_ENTITY_TYPES)))
          .addMethod(
              getGetEntityTypeMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.GetEntityTypeRequest,
                      com.google.cloud.dialogflow.v2.EntityType>(this, METHODID_GET_ENTITY_TYPE)))
          .addMethod(
              getCreateEntityTypeMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.CreateEntityTypeRequest,
                      com.google.cloud.dialogflow.v2.EntityType>(
                      this, METHODID_CREATE_ENTITY_TYPE)))
          .addMethod(
              getUpdateEntityTypeMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.UpdateEntityTypeRequest,
                      com.google.cloud.dialogflow.v2.EntityType>(
                      this, METHODID_UPDATE_ENTITY_TYPE)))
          .addMethod(
              getDeleteEntityTypeMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.DeleteEntityTypeRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_ENTITY_TYPE)))
          .addMethod(
              getBatchUpdateEntityTypesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.BatchUpdateEntityTypesRequest,
                      com.google.longrunning.Operation>(this, METHODID_BATCH_UPDATE_ENTITY_TYPES)))
          .addMethod(
              getBatchDeleteEntityTypesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.BatchDeleteEntityTypesRequest,
                      com.google.longrunning.Operation>(this, METHODID_BATCH_DELETE_ENTITY_TYPES)))
          .addMethod(
              getBatchCreateEntitiesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.BatchCreateEntitiesRequest,
                      com.google.longrunning.Operation>(this, METHODID_BATCH_CREATE_ENTITIES)))
          .addMethod(
              getBatchUpdateEntitiesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.BatchUpdateEntitiesRequest,
                      com.google.longrunning.Operation>(this, METHODID_BATCH_UPDATE_ENTITIES)))
          .addMethod(
              getBatchDeleteEntitiesMethodHelper(),
              asyncUnaryCall(
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
   * Entities are extracted from user input and represent parameters that are
   * meaningful to your application. For example, a date range, a proper name
   * such as a geographic location or landmark, and so on. Entities represent
   * actionable data for your application.
   * When you define an entity, you can also include synonyms that all map to
   * that entity. For example, "soft drink", "soda", "pop", and so on.
   * There are three types of entities:
   * *   **System** - entities that are defined by the Dialogflow API for common
   *     data types such as date, time, currency, and so on. A system entity is
   *     represented by the `EntityType` type.
   * *   **Developer** - entities that are defined by you that represent
   *     actionable data that is meaningful to your application. For example,
   *     you could define a `pizza.sauce` entity for red or white pizza sauce,
   *     a `pizza.cheese` entity for the different types of cheese on a pizza,
   *     a `pizza.topping` entity for different toppings, and so on. A developer
   *     entity is represented by the `EntityType` type.
   * *   **User** - entities that are built for an individual user such as
   *     favorites, preferences, playlists, and so on. A user entity is
   *     represented by the [SessionEntityType][google.cloud.dialogflow.v2.SessionEntityType] type.
   * For more information about entity types, see the
   * [Dialogflow
   * documentation](https://cloud.google.com/dialogflow/docs/entities-overview).
   * </pre>
   */
  public static final class EntityTypesStub extends io.grpc.stub.AbstractStub<EntityTypesStub> {
    private EntityTypesStub(io.grpc.Channel channel) {
      super(channel);
    }

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
      asyncUnaryCall(
          getChannel().newCall(getListEntityTypesMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getGetEntityTypeMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an entity type in the specified agent.
     * </pre>
     */
    public void createEntityType(
        com.google.cloud.dialogflow.v2.CreateEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.EntityType> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateEntityTypeMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified entity type.
     * </pre>
     */
    public void updateEntityType(
        com.google.cloud.dialogflow.v2.UpdateEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.EntityType> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateEntityTypeMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified entity type.
     * </pre>
     */
    public void deleteEntityType(
        com.google.cloud.dialogflow.v2.DeleteEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteEntityTypeMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates/Creates multiple entity types in the specified agent.
     * Operation &lt;response: [BatchUpdateEntityTypesResponse][google.cloud.dialogflow.v2.BatchUpdateEntityTypesResponse]&gt;
     * </pre>
     */
    public void batchUpdateEntityTypes(
        com.google.cloud.dialogflow.v2.BatchUpdateEntityTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchUpdateEntityTypesMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes entity types in the specified agent.
     * Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
     * </pre>
     */
    public void batchDeleteEntityTypes(
        com.google.cloud.dialogflow.v2.BatchDeleteEntityTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchDeleteEntityTypesMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates multiple new entities in the specified entity type.
     * Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
     * </pre>
     */
    public void batchCreateEntities(
        com.google.cloud.dialogflow.v2.BatchCreateEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchCreateEntitiesMethodHelper(), getCallOptions()),
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
     * Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
     * </pre>
     */
    public void batchUpdateEntities(
        com.google.cloud.dialogflow.v2.BatchUpdateEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchUpdateEntitiesMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes entities in the specified entity type.
     * Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
     * </pre>
     */
    public void batchDeleteEntities(
        com.google.cloud.dialogflow.v2.BatchDeleteEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchDeleteEntitiesMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Entities are extracted from user input and represent parameters that are
   * meaningful to your application. For example, a date range, a proper name
   * such as a geographic location or landmark, and so on. Entities represent
   * actionable data for your application.
   * When you define an entity, you can also include synonyms that all map to
   * that entity. For example, "soft drink", "soda", "pop", and so on.
   * There are three types of entities:
   * *   **System** - entities that are defined by the Dialogflow API for common
   *     data types such as date, time, currency, and so on. A system entity is
   *     represented by the `EntityType` type.
   * *   **Developer** - entities that are defined by you that represent
   *     actionable data that is meaningful to your application. For example,
   *     you could define a `pizza.sauce` entity for red or white pizza sauce,
   *     a `pizza.cheese` entity for the different types of cheese on a pizza,
   *     a `pizza.topping` entity for different toppings, and so on. A developer
   *     entity is represented by the `EntityType` type.
   * *   **User** - entities that are built for an individual user such as
   *     favorites, preferences, playlists, and so on. A user entity is
   *     represented by the [SessionEntityType][google.cloud.dialogflow.v2.SessionEntityType] type.
   * For more information about entity types, see the
   * [Dialogflow
   * documentation](https://cloud.google.com/dialogflow/docs/entities-overview).
   * </pre>
   */
  public static final class EntityTypesBlockingStub
      extends io.grpc.stub.AbstractStub<EntityTypesBlockingStub> {
    private EntityTypesBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

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
      return blockingUnaryCall(
          getChannel(), getListEntityTypesMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getGetEntityTypeMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an entity type in the specified agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.EntityType createEntityType(
        com.google.cloud.dialogflow.v2.CreateEntityTypeRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateEntityTypeMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified entity type.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.EntityType updateEntityType(
        com.google.cloud.dialogflow.v2.UpdateEntityTypeRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateEntityTypeMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified entity type.
     * </pre>
     */
    public com.google.protobuf.Empty deleteEntityType(
        com.google.cloud.dialogflow.v2.DeleteEntityTypeRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteEntityTypeMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates/Creates multiple entity types in the specified agent.
     * Operation &lt;response: [BatchUpdateEntityTypesResponse][google.cloud.dialogflow.v2.BatchUpdateEntityTypesResponse]&gt;
     * </pre>
     */
    public com.google.longrunning.Operation batchUpdateEntityTypes(
        com.google.cloud.dialogflow.v2.BatchUpdateEntityTypesRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchUpdateEntityTypesMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes entity types in the specified agent.
     * Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
     * </pre>
     */
    public com.google.longrunning.Operation batchDeleteEntityTypes(
        com.google.cloud.dialogflow.v2.BatchDeleteEntityTypesRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchDeleteEntityTypesMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates multiple new entities in the specified entity type.
     * Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
     * </pre>
     */
    public com.google.longrunning.Operation batchCreateEntities(
        com.google.cloud.dialogflow.v2.BatchCreateEntitiesRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchCreateEntitiesMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates or creates multiple entities in the specified entity type. This
     * method does not affect entities in the entity type that aren't explicitly
     * specified in the request.
     * Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
     * </pre>
     */
    public com.google.longrunning.Operation batchUpdateEntities(
        com.google.cloud.dialogflow.v2.BatchUpdateEntitiesRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchUpdateEntitiesMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes entities in the specified entity type.
     * Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
     * </pre>
     */
    public com.google.longrunning.Operation batchDeleteEntities(
        com.google.cloud.dialogflow.v2.BatchDeleteEntitiesRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchDeleteEntitiesMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Entities are extracted from user input and represent parameters that are
   * meaningful to your application. For example, a date range, a proper name
   * such as a geographic location or landmark, and so on. Entities represent
   * actionable data for your application.
   * When you define an entity, you can also include synonyms that all map to
   * that entity. For example, "soft drink", "soda", "pop", and so on.
   * There are three types of entities:
   * *   **System** - entities that are defined by the Dialogflow API for common
   *     data types such as date, time, currency, and so on. A system entity is
   *     represented by the `EntityType` type.
   * *   **Developer** - entities that are defined by you that represent
   *     actionable data that is meaningful to your application. For example,
   *     you could define a `pizza.sauce` entity for red or white pizza sauce,
   *     a `pizza.cheese` entity for the different types of cheese on a pizza,
   *     a `pizza.topping` entity for different toppings, and so on. A developer
   *     entity is represented by the `EntityType` type.
   * *   **User** - entities that are built for an individual user such as
   *     favorites, preferences, playlists, and so on. A user entity is
   *     represented by the [SessionEntityType][google.cloud.dialogflow.v2.SessionEntityType] type.
   * For more information about entity types, see the
   * [Dialogflow
   * documentation](https://cloud.google.com/dialogflow/docs/entities-overview).
   * </pre>
   */
  public static final class EntityTypesFutureStub
      extends io.grpc.stub.AbstractStub<EntityTypesFutureStub> {
    private EntityTypesFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

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
      return futureUnaryCall(
          getChannel().newCall(getListEntityTypesMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getGetEntityTypeMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an entity type in the specified agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.EntityType>
        createEntityType(com.google.cloud.dialogflow.v2.CreateEntityTypeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateEntityTypeMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified entity type.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.EntityType>
        updateEntityType(com.google.cloud.dialogflow.v2.UpdateEntityTypeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateEntityTypeMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified entity type.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteEntityType(com.google.cloud.dialogflow.v2.DeleteEntityTypeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteEntityTypeMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates/Creates multiple entity types in the specified agent.
     * Operation &lt;response: [BatchUpdateEntityTypesResponse][google.cloud.dialogflow.v2.BatchUpdateEntityTypesResponse]&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchUpdateEntityTypes(
            com.google.cloud.dialogflow.v2.BatchUpdateEntityTypesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchUpdateEntityTypesMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes entity types in the specified agent.
     * Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchDeleteEntityTypes(
            com.google.cloud.dialogflow.v2.BatchDeleteEntityTypesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchDeleteEntityTypesMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates multiple new entities in the specified entity type.
     * Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchCreateEntities(com.google.cloud.dialogflow.v2.BatchCreateEntitiesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchCreateEntitiesMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates or creates multiple entities in the specified entity type. This
     * method does not affect entities in the entity type that aren't explicitly
     * specified in the request.
     * Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchUpdateEntities(com.google.cloud.dialogflow.v2.BatchUpdateEntitiesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchUpdateEntitiesMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes entities in the specified entity type.
     * Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchDeleteEntities(com.google.cloud.dialogflow.v2.BatchDeleteEntitiesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchDeleteEntitiesMethodHelper(), getCallOptions()), request);
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
                      .addMethod(getListEntityTypesMethodHelper())
                      .addMethod(getGetEntityTypeMethodHelper())
                      .addMethod(getCreateEntityTypeMethodHelper())
                      .addMethod(getUpdateEntityTypeMethodHelper())
                      .addMethod(getDeleteEntityTypeMethodHelper())
                      .addMethod(getBatchUpdateEntityTypesMethodHelper())
                      .addMethod(getBatchDeleteEntityTypesMethodHelper())
                      .addMethod(getBatchCreateEntitiesMethodHelper())
                      .addMethod(getBatchUpdateEntitiesMethodHelper())
                      .addMethod(getBatchDeleteEntitiesMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
